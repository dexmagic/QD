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
package com.dxfeed.event.candle;

import java.util.EnumSet;

import com.devexperts.qd.DataRecord;
import com.devexperts.qd.QDContract;
import com.devexperts.qd.ng.RecordBuffer;
import com.devexperts.qd.ng.RecordCursor;
import com.dxfeed.api.impl.EventDelegateFlags;
import com.dxfeed.event.candle.impl.CandleMapping;

public final class CandleDelegate extends CandleEventDelegateImpl<Candle> {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final CandleMapping m;

    public CandleDelegate(DataRecord record, QDContract contract, EnumSet<EventDelegateFlags> flags) {
        super(record, contract, flags);
        m = record.getMapping(CandleMapping.class);
    }

    @Override
    public CandleMapping getMapping() {
        return m;
    }

    @Override
    public Candle createEvent() {
        return new Candle();
    }

    @Override
    public Candle getEvent(Candle event, RecordCursor cursor) {
        super.getEvent(event, cursor);
        event.setEventFlags(cursor.getEventFlags());
        event.setIndex((((long) m.getTimeSeconds(cursor)) << 32) | (m.getSequence(cursor) & 0xFFFFFFFFL));
        event.setCount(m.getCount(cursor));
        event.setOpen(m.getOpen(cursor));
        event.setHigh(m.getHigh(cursor));
        event.setLow(m.getLow(cursor));
        event.setClose(m.getClose(cursor));
        event.setVolumeAsDouble(m.getVolumeDouble(cursor));
        event.setVWAP(m.getVWAP(cursor));
        event.setBidVolumeAsDouble(m.getBidVolumeDouble(cursor));
        event.setAskVolumeAsDouble(m.getAskVolumeDouble(cursor));
        return event;
    }

    @Override
    public RecordCursor putEvent(Candle event, RecordBuffer buf) {
        RecordCursor cursor = super.putEvent(event, buf);
        cursor.setEventFlags(event.getEventFlags());
        m.setTimeSeconds(cursor, (int) (event.getIndex() >>> 32));
        m.setSequence(cursor, (int) event.getIndex());
        m.setCount(cursor, event.getCount());
        m.setOpen(cursor, event.getOpen());
        m.setHigh(cursor, event.getHigh());
        m.setLow(cursor, event.getLow());
        m.setClose(cursor, event.getClose());
        m.setVolumeDouble(cursor, event.getVolumeAsDouble());
        m.setVWAP(cursor, event.getVWAP());
        m.setBidVolumeDouble(cursor, event.getBidVolumeAsDouble());
        m.setAskVolumeDouble(cursor, event.getAskVolumeAsDouble());
        return cursor;
    }
// END: CODE AUTOMATICALLY GENERATED
}
