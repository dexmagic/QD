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
package com.dxfeed.event.market;

import java.util.EnumSet;

import com.devexperts.qd.DataRecord;
import com.devexperts.qd.QDContract;
import com.devexperts.qd.ng.RecordBuffer;
import com.devexperts.qd.ng.RecordCursor;
import com.dxfeed.api.impl.EventDelegateFlags;
import com.dxfeed.event.IndexedEventSource;
import com.dxfeed.event.market.impl.OrderMapping;

public final class OrderDelegate extends OrderBaseDelegateImpl<Order> {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final OrderMapping m;

    public OrderDelegate(DataRecord record, QDContract contract, EnumSet<EventDelegateFlags> flags) {
        super(record, contract, flags);
        m = record.getMapping(OrderMapping.class);
    }

    @Override
    public OrderMapping getMapping() {
        return m;
    }

    @Override
    public Order createEvent() {
        return new Order();
    }

    @Override
    public Order getEvent(Order event, RecordCursor cursor) {
        super.getEvent(event, cursor);
        event.setEventFlags(cursor.getEventFlags());
        event.setTimeNanoPart(m.getTimeNanoPart(cursor));
        event.setIndex(((long) getSource().id() << 32) | (m.getIndex(cursor) & 0xFFFFFFFFL));
        event.setTimeSequence((((long) m.getTimeSeconds(cursor)) << 32) | (m.getSequence(cursor) & 0xFFFFFFFFL));
        event.setPrice(m.getPrice(cursor));
        event.setSizeAsDouble(m.getSizeDouble(cursor));
        event.setCount(m.getCount(cursor));
        event.setFlags(m.getFlags(cursor));
        event.setMarketMaker(m.getMarketMakerString(cursor));
        return event;
    }

    @Override
    public RecordCursor putEvent(Order event, RecordBuffer buf) {
        RecordCursor cursor = super.putEvent(event, buf);
        cursor.setEventFlags(event.getEventFlags());
        m.setTimeNanoPart(cursor, event.getTimeNanoPart());
        int index = (int) event.getIndex();
        m.setIndex(cursor, index);
        m.setTimeSeconds(cursor, (int) (event.getTimeSequence() >>> 32));
        m.setSequence(cursor, (int) event.getTimeSequence());
        m.setPrice(cursor, event.getPrice());
        m.setSizeDouble(cursor, event.getSizeAsDouble());
        m.setCount(cursor, (int) event.getCount());
        m.setFlags(cursor, event.getFlags());
        m.setMarketMakerString(cursor, event.getMarketMaker());
        if (index < 0)
            throw new IllegalArgumentException("Invalid index to publish");
        if ((event.getEventFlags() & OrderBase.SNAPSHOT_END) != 0 && index != 0)
            throw new IllegalArgumentException("SNAPSHOT_END event must have index == 0");
        if ((event.getEventFlags() & OrderBase.REMOVE_EVENT) == 0 && event.getOrderSide() == Side.UNDEFINED)
            throw new IllegalArgumentException("only REMOVE_EVENT event can have side == UNDEFINED");
        return cursor;
    }

    @Override
    public IndexedEventSource getSource() {
        return m.getRecordSource();
    }
// END: CODE AUTOMATICALLY GENERATED
}
