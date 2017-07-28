/*
 * !++
 * QDS - Quick Data Signalling Library
 * !-
 * Copyright (C) 2002 - 2017 Devexperts LLC
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
import com.dxfeed.event.market.impl.TradeMapping;

public final class TradeDelegate extends MarketEventDelegateImpl<Trade> {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final TradeMapping m;

    public TradeDelegate(DataRecord record, QDContract contract, EnumSet<EventDelegateFlags> flags) {
        super(record, contract, flags);
        m = record.getMapping(TradeMapping.class);
    }

    @Override
    public TradeMapping getMapping() {
        return m;
    }

    @Override
    public Trade createEvent() {
        return new Trade();
    }

    @Override
    public Trade getEvent(Trade event, RecordCursor cursor) {
        super.getEvent(event, cursor);
        event.setTimeSequence((((long) m.getTimeSeconds(cursor)) << 32) | (m.getSequence(cursor) & 0xFFFFFFFFL));
        event.setTimeNanoPart(m.getTimeNanoPart(cursor));
        event.setExchangeCode(m.getExchangeCode(cursor));
        event.setPrice(m.getPrice(cursor));
        event.setSize(m.getSize(cursor));
        event.setFlags(m.getFlags(cursor));
        if (event.getTickDirection() == Direction.UNDEFINED) {
            // if direction is not provided via flags field - compute it from tick field if provided
            int tick = m.getTick(cursor);
            if (tick == 1)
                event.setTickDirection(Direction.ZERO_UP);
            else if (tick == 2)
                event.setTickDirection(Direction.ZERO_DOWN);
        }
        event.setDayVolume(m.getDayVolume(cursor));
        event.setDayTurnover(m.getDayTurnover(cursor));
        return event;
    }

    @Override
    public RecordCursor putEvent(Trade event, RecordBuffer buf) {
        RecordCursor cursor = super.putEvent(event, buf);
        m.setTimeSeconds(cursor, (int) (event.getTimeSequence() >>> 32));
        m.setSequence(cursor, (int) event.getTimeSequence());
        m.setTimeNanoPart(cursor, event.getTimeNanoPart());
        m.setExchangeCode(cursor, event.getExchangeCode());
        m.setPrice(cursor, event.getPrice());
        m.setSize(cursor, (int) event.getSize());
        m.setFlags(cursor, event.getFlags());
        Direction d = event.getTickDirection();
        m.setTick(cursor, d == Direction.UP || d == Direction.ZERO_UP ? 1 : d == Direction.DOWN || d == Direction.ZERO_DOWN ? 2 : 0);
        m.setDayVolume(cursor, event.getDayVolume());
        m.setDayTurnover(cursor, event.getDayTurnover());
        return cursor;
    }
// END: CODE AUTOMATICALLY GENERATED
}
