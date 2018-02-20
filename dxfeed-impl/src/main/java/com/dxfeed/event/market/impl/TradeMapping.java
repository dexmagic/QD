/*
 * !++
 * QDS - Quick Data Signalling Library
 * !-
 * Copyright (C) 2002 - 2018 Devexperts LLC
 * !-
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/.
 * !__
 */
package com.dxfeed.event.market.impl;

import com.devexperts.qd.DataRecord;
import com.devexperts.qd.ng.RecordCursor;
import com.devexperts.qd.util.Decimal;
import com.devexperts.qd.util.MappingUtil;
import com.devexperts.util.TimeUtil;

public class TradeMapping extends MarketEventMapping {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final int iTime;
    private final int iSequence;
    private final int iTimeNanoPart;
    private final int iExchangeCode;
    private final int iPrice;
    private final int iSize;
    private final int iTick;
    private final int iChange;
    private final int iFlags;
    private final int iDayVolume;
    private final int iDayTurnover;

    public TradeMapping(DataRecord record) {
        super(record);
        iTime = MappingUtil.findIntField(record, "Last.Time", false);
        iSequence = MappingUtil.findIntField(record, "Last.Sequence", false);
        iTimeNanoPart = MappingUtil.findIntField(record, "Last.TimeNanoPart", false);
        iExchangeCode = MappingUtil.findIntField(record, "Last.Exchange", false);
        iPrice = MappingUtil.findIntField(record, "Last.Price", true);
        iSize = MappingUtil.findIntField(record, "Last.Size", true);
        iTick = MappingUtil.findIntField(record, "Last.Tick", false);
        iChange = MappingUtil.findIntField(record, "Last.Change", false);
        iFlags = MappingUtil.findIntField(record, "Last.Flags", false);
        iDayVolume = MappingUtil.findIntField(record, "Volume", false);
        iDayTurnover = MappingUtil.findIntField(record, "DayTurnover", false);
        putNonDefaultPropertyName("Last.Time", "Time");
        putNonDefaultPropertyName("Last.Sequence", "Sequence");
        putNonDefaultPropertyName("Last.TimeNanoPart", "TimeNanoPart");
        putNonDefaultPropertyName("Last.Exchange", "ExchangeCode");
        putNonDefaultPropertyName("Last.Price", "Price");
        putNonDefaultPropertyName("Last.Size", "Size");
        putNonDefaultPropertyName("Last.Tick", "Tick");
        putNonDefaultPropertyName("Last.Change", "Change");
        putNonDefaultPropertyName("Last.Flags", "Flags");
        putNonDefaultPropertyName("Volume", "DayVolume");
    }

    @Deprecated
    public long getLastTimeMillis(RecordCursor cursor) {
        if (iTime < 0)
            return 0;
        return getInt(cursor, iTime) * 1000L;
    }

    @Deprecated
    public void setLastTimeMillis(RecordCursor cursor, long lastTime) {
        if (iTime < 0)
            return;
        setInt(cursor, iTime, TimeUtil.getSecondsFromTime(lastTime));
    }

    @Deprecated
    public int getLastTimeSeconds(RecordCursor cursor) {
        if (iTime < 0)
            return 0;
        return getInt(cursor, iTime);
    }

    @Deprecated
    public void setLastTimeSeconds(RecordCursor cursor, int lastTime) {
        if (iTime < 0)
            return;
        setInt(cursor, iTime, lastTime);
    }

    public long getTimeMillis(RecordCursor cursor) {
        if (iTime < 0)
            return 0;
        return getInt(cursor, iTime) * 1000L;
    }

    public void setTimeMillis(RecordCursor cursor, long time) {
        if (iTime < 0)
            return;
        setInt(cursor, iTime, TimeUtil.getSecondsFromTime(time));
    }

    public int getTimeSeconds(RecordCursor cursor) {
        if (iTime < 0)
            return 0;
        return getInt(cursor, iTime);
    }

    public void setTimeSeconds(RecordCursor cursor, int time) {
        if (iTime < 0)
            return;
        setInt(cursor, iTime, time);
    }

    @Deprecated
    public int getLastSequence(RecordCursor cursor) {
        if (iSequence < 0)
            return 0;
        return getInt(cursor, iSequence);
    }

    @Deprecated
    public void setLastSequence(RecordCursor cursor, int lastSequence) {
        if (iSequence < 0)
            return;
        setInt(cursor, iSequence, lastSequence);
    }

    public int getSequence(RecordCursor cursor) {
        if (iSequence < 0)
            return 0;
        return getInt(cursor, iSequence);
    }

    public void setSequence(RecordCursor cursor, int sequence) {
        if (iSequence < 0)
            return;
        setInt(cursor, iSequence, sequence);
    }

    @Deprecated
    public int getLastTimeNanoPart(RecordCursor cursor) {
        if (iTimeNanoPart < 0)
            return 0;
        return getInt(cursor, iTimeNanoPart);
    }

    @Deprecated
    public void setLastTimeNanoPart(RecordCursor cursor, int lastTimeNanoPart) {
        if (iTimeNanoPart < 0)
            return;
        setInt(cursor, iTimeNanoPart, lastTimeNanoPart);
    }

    public int getTimeNanoPart(RecordCursor cursor) {
        if (iTimeNanoPart < 0)
            return 0;
        return getInt(cursor, iTimeNanoPart);
    }

    public void setTimeNanoPart(RecordCursor cursor, int timeNanoPart) {
        if (iTimeNanoPart < 0)
            return;
        setInt(cursor, iTimeNanoPart, timeNanoPart);
    }

    @Deprecated
    public char getLastExchange(RecordCursor cursor) {
        if (iExchangeCode < 0)
            return recordExchange;
        return (char) getInt(cursor, iExchangeCode);
    }

    @Deprecated
    public void setLastExchange(RecordCursor cursor, char lastExchange) {
        if (iExchangeCode < 0)
            return;
        setInt(cursor, iExchangeCode, lastExchange);
    }

    public char getExchangeCode(RecordCursor cursor) {
        if (iExchangeCode < 0)
            return recordExchange;
        return (char) getInt(cursor, iExchangeCode);
    }

    public void setExchangeCode(RecordCursor cursor, char exchangeCode) {
        if (iExchangeCode < 0)
            return;
        setInt(cursor, iExchangeCode, exchangeCode);
    }

    @Deprecated
    public double getLastPrice(RecordCursor cursor) {
        return Decimal.toDouble(getInt(cursor, iPrice));
    }

    @Deprecated
    public void setLastPrice(RecordCursor cursor, double lastPrice) {
        setInt(cursor, iPrice, Decimal.compose(lastPrice));
    }

    @Deprecated
    public int getLastPriceDecimal(RecordCursor cursor) {
        return getInt(cursor, iPrice);
    }

    @Deprecated
    public void setLastPriceDecimal(RecordCursor cursor, int lastPrice) {
        setInt(cursor, iPrice, lastPrice);
    }

    public double getPrice(RecordCursor cursor) {
        return Decimal.toDouble(getInt(cursor, iPrice));
    }

    public void setPrice(RecordCursor cursor, double price) {
        setInt(cursor, iPrice, Decimal.compose(price));
    }

    public int getPriceDecimal(RecordCursor cursor) {
        return getInt(cursor, iPrice);
    }

    public void setPriceDecimal(RecordCursor cursor, int price) {
        setInt(cursor, iPrice, price);
    }

    @Deprecated
    public int getLastSize(RecordCursor cursor) {
        return getInt(cursor, iSize);
    }

    @Deprecated
    public void setLastSize(RecordCursor cursor, int lastSize) {
        setInt(cursor, iSize, lastSize);
    }

    @Deprecated
    public double getLastSizeDouble(RecordCursor cursor) {
        return getInt(cursor, iSize);
    }

    @Deprecated
    public void setLastSizeDouble(RecordCursor cursor, double lastSize) {
        setInt(cursor, iSize, (int) lastSize);
    }

    @Deprecated
    public int getLastSizeDecimal(RecordCursor cursor) {
        return Decimal.composeDecimal(getInt(cursor, iSize), 0);
    }

    @Deprecated
    public void setLastSizeDecimal(RecordCursor cursor, int lastSize) {
        setInt(cursor, iSize, (int) Decimal.toDouble(lastSize));
    }

    public int getSize(RecordCursor cursor) {
        return getInt(cursor, iSize);
    }

    public void setSize(RecordCursor cursor, int size) {
        setInt(cursor, iSize, size);
    }

    public double getSizeDouble(RecordCursor cursor) {
        return getInt(cursor, iSize);
    }

    public void setSizeDouble(RecordCursor cursor, double size) {
        setInt(cursor, iSize, (int) size);
    }

    public int getSizeDecimal(RecordCursor cursor) {
        return Decimal.composeDecimal(getInt(cursor, iSize), 0);
    }

    public void setSizeDecimal(RecordCursor cursor, int size) {
        setInt(cursor, iSize, (int) Decimal.toDouble(size));
    }

    @Deprecated
    public int getLastTick(RecordCursor cursor) {
        if (iTick < 0)
            return 0;
        return getInt(cursor, iTick);
    }

    @Deprecated
    public void setLastTick(RecordCursor cursor, int lastTick) {
        if (iTick < 0)
            return;
        setInt(cursor, iTick, lastTick);
    }

    public int getTick(RecordCursor cursor) {
        if (iTick < 0)
            return 0;
        return getInt(cursor, iTick);
    }

    public void setTick(RecordCursor cursor, int tick) {
        if (iTick < 0)
            return;
        setInt(cursor, iTick, tick);
    }

    @Deprecated
    public double getLastChange(RecordCursor cursor) {
        if (iChange < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iChange));
    }

    @Deprecated
    public void setLastChange(RecordCursor cursor, double lastChange) {
        if (iChange < 0)
            return;
        setInt(cursor, iChange, Decimal.compose(lastChange));
    }

    @Deprecated
    public int getLastChangeDecimal(RecordCursor cursor) {
        if (iChange < 0)
            return 0;
        return getInt(cursor, iChange);
    }

    @Deprecated
    public void setLastChangeDecimal(RecordCursor cursor, int lastChange) {
        if (iChange < 0)
            return;
        setInt(cursor, iChange, lastChange);
    }

    public double getChange(RecordCursor cursor) {
        if (iChange < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iChange));
    }

    public void setChange(RecordCursor cursor, double change) {
        if (iChange < 0)
            return;
        setInt(cursor, iChange, Decimal.compose(change));
    }

    public int getChangeDecimal(RecordCursor cursor) {
        if (iChange < 0)
            return 0;
        return getInt(cursor, iChange);
    }

    public void setChangeDecimal(RecordCursor cursor, int change) {
        if (iChange < 0)
            return;
        setInt(cursor, iChange, change);
    }

    @Deprecated
    public int getLastFlags(RecordCursor cursor) {
        if (iFlags < 0)
            return 0;
        return getInt(cursor, iFlags);
    }

    @Deprecated
    public void setLastFlags(RecordCursor cursor, int lastFlags) {
        if (iFlags < 0)
            return;
        setInt(cursor, iFlags, lastFlags);
    }

    public int getFlags(RecordCursor cursor) {
        if (iFlags < 0)
            return 0;
        return getInt(cursor, iFlags);
    }

    public void setFlags(RecordCursor cursor, int flags) {
        if (iFlags < 0)
            return;
        setInt(cursor, iFlags, flags);
    }

    @Deprecated
    public long getVolume(RecordCursor cursor) {
        if (iDayVolume < 0)
            return 0;
        return (long) Decimal.toDouble(getInt(cursor, iDayVolume));
    }

    @Deprecated
    public void setVolume(RecordCursor cursor, long volume) {
        if (iDayVolume < 0)
            return;
        setInt(cursor, iDayVolume, Decimal.composeDecimal(volume, 0));
    }

    @Deprecated
    public double getVolumeDouble(RecordCursor cursor) {
        if (iDayVolume < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iDayVolume));
    }

    @Deprecated
    public void setVolumeDouble(RecordCursor cursor, double volume) {
        if (iDayVolume < 0)
            return;
        setInt(cursor, iDayVolume, Decimal.compose(volume));
    }

    @Deprecated
    public int getVolumeDecimal(RecordCursor cursor) {
        if (iDayVolume < 0)
            return 0;
        return getInt(cursor, iDayVolume);
    }

    @Deprecated
    public void setVolumeDecimal(RecordCursor cursor, int volume) {
        if (iDayVolume < 0)
            return;
        setInt(cursor, iDayVolume, volume);
    }

    public long getDayVolume(RecordCursor cursor) {
        if (iDayVolume < 0)
            return 0;
        return (long) Decimal.toDouble(getInt(cursor, iDayVolume));
    }

    public void setDayVolume(RecordCursor cursor, long dayVolume) {
        if (iDayVolume < 0)
            return;
        setInt(cursor, iDayVolume, Decimal.composeDecimal(dayVolume, 0));
    }

    public double getDayVolumeDouble(RecordCursor cursor) {
        if (iDayVolume < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iDayVolume));
    }

    public void setDayVolumeDouble(RecordCursor cursor, double dayVolume) {
        if (iDayVolume < 0)
            return;
        setInt(cursor, iDayVolume, Decimal.compose(dayVolume));
    }

    public int getDayVolumeDecimal(RecordCursor cursor) {
        if (iDayVolume < 0)
            return 0;
        return getInt(cursor, iDayVolume);
    }

    public void setDayVolumeDecimal(RecordCursor cursor, int dayVolume) {
        if (iDayVolume < 0)
            return;
        setInt(cursor, iDayVolume, dayVolume);
    }

    public double getDayTurnover(RecordCursor cursor) {
        if (iDayTurnover < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iDayTurnover));
    }

    public void setDayTurnover(RecordCursor cursor, double dayTurnover) {
        if (iDayTurnover < 0)
            return;
        setInt(cursor, iDayTurnover, Decimal.compose(dayTurnover));
    }

    public int getDayTurnoverDecimal(RecordCursor cursor) {
        if (iDayTurnover < 0)
            return 0;
        return getInt(cursor, iDayTurnover);
    }

    public void setDayTurnoverDecimal(RecordCursor cursor, int dayTurnover) {
        if (iDayTurnover < 0)
            return;
        setInt(cursor, iDayTurnover, dayTurnover);
    }
// END: CODE AUTOMATICALLY GENERATED
}
