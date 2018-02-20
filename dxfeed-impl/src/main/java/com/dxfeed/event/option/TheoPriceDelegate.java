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
import com.dxfeed.event.option.impl.TheoPriceMapping;

public final class TheoPriceDelegate extends EventDelegate<TheoPrice> {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final TheoPriceMapping m;

    public TheoPriceDelegate(DataRecord record, QDContract contract, EnumSet<EventDelegateFlags> flags) {
        super(record, contract, flags);
        m = record.getMapping(TheoPriceMapping.class);
    }

    @Override
    public TheoPriceMapping getMapping() {
        return m;
    }

    @Override
    public TheoPrice createEvent() {
        return new TheoPrice();
    }

    @Override
    public TheoPrice getEvent(TheoPrice event, RecordCursor cursor) {
        super.getEvent(event, cursor);
        event.setTime(m.getTimeMillis(cursor));
        event.setPrice(m.getPrice(cursor));
        event.setUnderlyingPrice(m.getUnderlyingPrice(cursor));
        event.setDelta(m.getDelta(cursor));
        event.setGamma(m.getGamma(cursor));
        event.setDividend(m.getDividend(cursor));
        event.setInterest(m.getInterest(cursor));
        return event;
    }

    @Override
    public RecordCursor putEvent(TheoPrice event, RecordBuffer buf) {
        RecordCursor cursor = super.putEvent(event, buf);
        m.setTimeMillis(cursor, event.getTime());
        m.setPrice(cursor, event.getPrice());
        m.setUnderlyingPrice(cursor, event.getUnderlyingPrice());
        m.setDelta(cursor, event.getDelta());
        m.setGamma(cursor, event.getGamma());
        m.setDividend(cursor, event.getDividend());
        m.setInterest(cursor, event.getInterest());
        return cursor;
    }
// END: CODE AUTOMATICALLY GENERATED
}
