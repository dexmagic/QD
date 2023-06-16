/*
 * !++
 * QDS - Quick Data Signalling Library
 * !-
 * Copyright (C) 2002 - 2022 Devexperts LLC
 * !-
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/.
 * !__
 */
package com.dxfeed.ondemand.impl.connector;

import com.devexperts.connector.proto.ApplicationConnectionFactory;
import com.devexperts.qd.qtp.AbstractConnectionHandler;
import com.devexperts.qd.qtp.AbstractMessageConnector;
import com.devexperts.qd.qtp.MessageConnectorState;
import com.devexperts.qd.qtp.ReconnectHelper;
import com.devexperts.qd.qtp.help.MessageConnectorProperty;
import com.devexperts.qd.qtp.help.MessageConnectorSummary;
import com.devexperts.util.LogUtil;
import com.devexperts.util.TimeFormat;
import com.devexperts.util.TimePeriod;
import com.dxfeed.api.impl.OnDemandConnectorMarker;
import com.dxfeed.ondemand.impl.MarketDataReplay;
import com.dxfeed.ondemand.impl.MarketDataToken;

import java.util.Date;


@MessageConnectorSummary(
    info = "On-demand historical data replay.",
    addressFormat = "ondemand:<address>"
)
public class OnDemandConnector extends AbstractMessageConnector
    implements OnDemandConnectorMBean, OnDemandConnectorMarker
{
    private final String address;
    private final ReconnectHelper reconnectHelper;
    private final MarketDataReplay replay = new MarketDataReplay();

    private volatile ReplayConnectionHandler handler; // !=null when active
    private Date time;
    private double speed = 1;

    private volatile TimePeriod tickPeriod = TimePeriod.valueOf(20); // tick at 50 fps by default

    public OnDemandConnector(ApplicationConnectionFactory factory, String address) {
        super(factory);
        this.address = address;
        reconnectHelper = new ReconnectHelper(getReconnectDelay());
    }

    @Override
    public synchronized void start() {
        if (isActive())
            return; // already active
        if (time == null)
            return; // will not start until time is set
        log.info("Starting OnDemandConnector to " + LogUtil.hideCredentials(getAddress()) + " at " +
            TimeFormat.DEFAULT.format(time));
        reconnectHelper.setReconnectDelay(getReconnectDelay()); // update reconnect delay
        handler = new ReplayConnectionHandler(this);
        handler.start();
        notifyMessageConnectorListeners();
    }

    @Override
    protected Joinable stopImpl() {
        ReplayConnectionHandler handler;
        synchronized (this) {
            if (!isActive())
                return null;
            handler = this.handler;
            this.handler = null; // mark as stopped, so we don't need to restart on handlerClosed
        }
        if (handler != null) {
            log.info("Stopping OnDemandConnector");
            handler.close();
        }
        notifyMessageConnectorListeners();
        return handler;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public boolean isActive() {
        return handler != null;
    }

    @Override
    public MessageConnectorState getState() {
        ReplayConnectionHandler handler = this.handler;
        return handler != null ? handler.getConnectionState() : MessageConnectorState.DISCONNECTED;
    }

    @Override
    public int getConnectionCount() {
        return isActive() ? 1 : 0;
    }

    @Override
    public TimePeriod getTickPeriod() {
        return tickPeriod;
    }

    @Override
    @MessageConnectorProperty("Tick period")
    public void setTickPeriod(TimePeriod tickPeriod) {
        if (tickPeriod == null)
            throw new NullPointerException();
        this.tickPeriod = tickPeriod;
    }

    @Override
    public long getCacheLimit() {
        return replay.getCacheLimit();
    }

    @Override
    @MessageConnectorProperty("Cache limit size in bytes")
    public void setCacheLimit(long amount) {
        replay.setCacheLimit(amount);
    }

    @Override
    public long getFileCacheLimit() {
        return replay.getFileCacheLimit();
    }

    @Override
    @MessageConnectorProperty("File cache limit size in bytes")
    public void setFileCacheLimit(long amount) {
        replay.setFileCacheLimit(amount);
    }

    @Override
    public synchronized String getFileCachePath() {
        return replay.getFileCachePath();
    }

    @Override
    @MessageConnectorProperty("Cache file directory, empty by default (current dir)")
    public synchronized void setFileCachePath(String cacheFileDir) {
        replay.setFileCachePath(cacheFileDir);
    }

    @Override
    public synchronized Date getTime() {
        return time;
    }

    @Override
    @MessageConnectorProperty("Replay time")
    public synchronized void setTime(Date time) {
        updateTime(time);
        reconfigure();
    }

    void updateTime(Date newTime) {
        Date oldTime;
        synchronized (this) {
            oldTime = this.time;
            this.time = newTime;
        }
    }

    @Override
    public synchronized double getSpeed() {
        return speed;
    }

    @Override
    @MessageConnectorProperty("Replay speed, 1.0 by default (real-time speed)")
    public synchronized void setSpeed(double speed) {
        this.speed = speed;
        if (handler != null)
            handler.setSpeed(speed);
    }


    public void startImmediately() {
        reconnectHelper.reset();
        start();
    }

    ReconnectHelper getReconnectHelper() {
        return reconnectHelper;
    }

    MarketDataReplay getMarketDataReplay() {
        return replay;
    }

    MarketDataToken resolveToken() {
        return MarketDataToken.fromUserPassword(getUser(), getPassword(), address);
    }

    @Override
    protected synchronized void handlerClosed(AbstractConnectionHandler handler) {
        if (handler != this.handler)
            return;
        this.handler = null;
        start();
    }
}
