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
package com.dxfeed.event.option;

import java.util.EnumSet;

import com.devexperts.qd.DataRecord;
import com.devexperts.qd.QDContract;
import com.devexperts.qd.ng.RecordBuffer;
import com.devexperts.qd.ng.RecordCursor;
import com.dxfeed.api.impl.EventDelegate;
import com.dxfeed.api.impl.EventDelegateFlags;
import com.dxfeed.event.option.impl.SeriesMapping;

public final class SeriesDelegate extends EventDelegate<Series> {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final SeriesMapping m;

    public SeriesDelegate(DataRecord record, QDContract contract, EnumSet<EventDelegateFlags> flags) {
        super(record, contract, flags);
        m = record.getMapping(SeriesMapping.class);
    }

    @Override
    public SeriesMapping getMapping() {
        return m;
    }

    @Override
    public Series createEvent() {
        return new Series();
    }

    @Override
    public Series getEvent(Series event, RecordCursor cursor) {
        super.getEvent(event, cursor);
        event.setEventFlags(cursor.getEventFlags());
        event.setIndex(((long) m.getExpiration(cursor) << 32) | (m.getSequence(cursor) & 0xFFFFFFFFL));
        event.setVolatility(m.getVolatility(cursor));
        event.setPutCallRatio(m.getPutCallRatio(cursor));
        event.setForwardPrice(m.getForwardPrice(cursor));
        event.setDividend(m.getDividend(cursor));
        event.setInterest(m.getInterest(cursor));
        return event;
    }

    @Override
    public RecordCursor putEvent(Series event, RecordBuffer buf) {
        RecordCursor cursor = super.putEvent(event, buf);
        cursor.setEventFlags(event.getEventFlags());
        m.setExpiration(cursor, (int) (event.getIndex() >> 32));
        m.setSequence(cursor, (int) event.getIndex());
        m.setVolatility(cursor, event.getVolatility());
        m.setPutCallRatio(cursor, event.getPutCallRatio());
        m.setForwardPrice(cursor, event.getForwardPrice());
        m.setDividend(cursor, event.getDividend());
        m.setInterest(cursor, event.getInterest());
        return cursor;
    }
// END: CODE AUTOMATICALLY GENERATED
}
