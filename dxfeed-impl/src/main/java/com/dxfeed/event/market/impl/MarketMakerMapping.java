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
package com.dxfeed.event.market.impl;

import com.devexperts.qd.DataRecord;
import com.devexperts.qd.ng.RecordCursor;
import com.devexperts.qd.util.*;
import com.devexperts.util.TimeUtil;

public class MarketMakerMapping extends MarketEventMapping {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final int iExchangeCode;
    private final int iMarketMaker;
    private final int iBidTime;
    private final int iBidPrice;
    private final int iBidSize;
    private final int iBidCount;
    private final int iAskTime;
    private final int iAskPrice;
    private final int iAskSize;
    private final int iAskCount;

    public MarketMakerMapping(DataRecord record) {
        super(record);
        iExchangeCode = MappingUtil.findIntField(record, "MMExchange", true);
        iMarketMaker = MappingUtil.findIntField(record, "MMID", true);
        iBidTime = MappingUtil.findIntField(record, "MMBid.Time", false);
        iBidPrice = MappingUtil.findIntField(record, "MMBid.Price", true);
        iBidSize = MappingUtil.findIntField(record, "MMBid.Size", true);
        iBidCount = MappingUtil.findIntField(record, "MMBid.Count", false);
        iAskTime = MappingUtil.findIntField(record, "MMAsk.Time", false);
        iAskPrice = MappingUtil.findIntField(record, "MMAsk.Price", true);
        iAskSize = MappingUtil.findIntField(record, "MMAsk.Size", true);
        iAskCount = MappingUtil.findIntField(record, "MMAsk.Count", false);
        putNonDefaultPropertyName("MMExchange", "ExchangeCode");
        putNonDefaultPropertyName("MMID", "MarketMaker");
        putNonDefaultPropertyName("MMBid.Time", "BidTime");
        putNonDefaultPropertyName("MMBid.Price", "BidPrice");
        putNonDefaultPropertyName("MMBid.Size", "BidSize");
        putNonDefaultPropertyName("MMBid.Count", "BidCount");
        putNonDefaultPropertyName("MMAsk.Time", "AskTime");
        putNonDefaultPropertyName("MMAsk.Price", "AskPrice");
        putNonDefaultPropertyName("MMAsk.Size", "AskSize");
        putNonDefaultPropertyName("MMAsk.Count", "AskCount");
    }

    @Deprecated
    public char getMMExchange(RecordCursor cursor) {
        return (char) getInt(cursor, iExchangeCode);
    }

    @Deprecated
    public void setMMExchange(RecordCursor cursor, char _MMExchange) {
        setInt(cursor, iExchangeCode, _MMExchange);
    }

    public char getExchangeCode(RecordCursor cursor) {
        return (char) getInt(cursor, iExchangeCode);
    }

    public void setExchangeCode(RecordCursor cursor, char exchangeCode) {
        setInt(cursor, iExchangeCode, exchangeCode);
    }

    @Deprecated
    public String getMMIDString(RecordCursor cursor) {
        return ShortString.decode(getInt(cursor, iMarketMaker));
    }

    @Deprecated
    public void setMMIDString(RecordCursor cursor, String _MMID) {
        setInt(cursor, iMarketMaker, (int) ShortString.encode(_MMID));
    }

    @Deprecated
    public int getMMID(RecordCursor cursor) {
        return getInt(cursor, iMarketMaker);
    }

    @Deprecated
    public void setMMID(RecordCursor cursor, int _MMID) {
        setInt(cursor, iMarketMaker, _MMID);
    }

    public String getMarketMakerString(RecordCursor cursor) {
        return ShortString.decode(getInt(cursor, iMarketMaker));
    }

    public void setMarketMakerString(RecordCursor cursor, String marketMaker) {
        setInt(cursor, iMarketMaker, (int) ShortString.encode(marketMaker));
    }

    public int getMarketMaker(RecordCursor cursor) {
        return getInt(cursor, iMarketMaker);
    }

    public void setMarketMaker(RecordCursor cursor, int marketMaker) {
        setInt(cursor, iMarketMaker, marketMaker);
    }

    @Deprecated
    public long getMMBidTimeMillis(RecordCursor cursor) {
        if (iBidTime < 0)
            return 0;
        return getInt(cursor, iBidTime) * 1000L;
    }

    @Deprecated
    public void setMMBidTimeMillis(RecordCursor cursor, long _MMBidTime) {
        if (iBidTime < 0)
            return;
        setInt(cursor, iBidTime, TimeUtil.getSecondsFromTime(_MMBidTime));
    }

    @Deprecated
    public int getMMBidTimeSeconds(RecordCursor cursor) {
        if (iBidTime < 0)
            return 0;
        return getInt(cursor, iBidTime);
    }

    @Deprecated
    public void setMMBidTimeSeconds(RecordCursor cursor, int _MMBidTime) {
        if (iBidTime < 0)
            return;
        setInt(cursor, iBidTime, _MMBidTime);
    }

    public long getBidTimeMillis(RecordCursor cursor) {
        if (iBidTime < 0)
            return 0;
        return getInt(cursor, iBidTime) * 1000L;
    }

    public void setBidTimeMillis(RecordCursor cursor, long bidTime) {
        if (iBidTime < 0)
            return;
        setInt(cursor, iBidTime, TimeUtil.getSecondsFromTime(bidTime));
    }

    public int getBidTimeSeconds(RecordCursor cursor) {
        if (iBidTime < 0)
            return 0;
        return getInt(cursor, iBidTime);
    }

    public void setBidTimeSeconds(RecordCursor cursor, int bidTime) {
        if (iBidTime < 0)
            return;
        setInt(cursor, iBidTime, bidTime);
    }

    @Deprecated
    public double getMMBidPrice(RecordCursor cursor) {
        return Decimal.toDouble(getInt(cursor, iBidPrice));
    }

    @Deprecated
    public void setMMBidPrice(RecordCursor cursor, double _MMBidPrice) {
        setInt(cursor, iBidPrice, Decimal.compose(_MMBidPrice));
    }

    @Deprecated
    public int getMMBidPriceDecimal(RecordCursor cursor) {
        return getInt(cursor, iBidPrice);
    }

    @Deprecated
    public void setMMBidPriceDecimal(RecordCursor cursor, int _MMBidPrice) {
        setInt(cursor, iBidPrice, _MMBidPrice);
    }

    public double getBidPrice(RecordCursor cursor) {
        return Decimal.toDouble(getInt(cursor, iBidPrice));
    }

    public void setBidPrice(RecordCursor cursor, double bidPrice) {
        setInt(cursor, iBidPrice, Decimal.compose(bidPrice));
    }

    public int getBidPriceDecimal(RecordCursor cursor) {
        return getInt(cursor, iBidPrice);
    }

    public void setBidPriceDecimal(RecordCursor cursor, int bidPrice) {
        setInt(cursor, iBidPrice, bidPrice);
    }

    @Deprecated
    public int getMMBidSize(RecordCursor cursor) {
        return getInt(cursor, iBidSize);
    }

    @Deprecated
    public void setMMBidSize(RecordCursor cursor, int _MMBidSize) {
        setInt(cursor, iBidSize, _MMBidSize);
    }

    public int getBidSize(RecordCursor cursor) {
        return getInt(cursor, iBidSize);
    }

    public void setBidSize(RecordCursor cursor, int bidSize) {
        setInt(cursor, iBidSize, bidSize);
    }

    @Deprecated
    public int getMMBidCount(RecordCursor cursor) {
        if (iBidCount < 0)
            return 0;
        return getInt(cursor, iBidCount);
    }

    @Deprecated
    public void setMMBidCount(RecordCursor cursor, int _MMBidCount) {
        if (iBidCount < 0)
            return;
        setInt(cursor, iBidCount, _MMBidCount);
    }

    public int getBidCount(RecordCursor cursor) {
        if (iBidCount < 0)
            return 0;
        return getInt(cursor, iBidCount);
    }

    public void setBidCount(RecordCursor cursor, int bidCount) {
        if (iBidCount < 0)
            return;
        setInt(cursor, iBidCount, bidCount);
    }

    @Deprecated
    public long getMMAskTimeMillis(RecordCursor cursor) {
        if (iAskTime < 0)
            return 0;
        return getInt(cursor, iAskTime) * 1000L;
    }

    @Deprecated
    public void setMMAskTimeMillis(RecordCursor cursor, long _MMAskTime) {
        if (iAskTime < 0)
            return;
        setInt(cursor, iAskTime, TimeUtil.getSecondsFromTime(_MMAskTime));
    }

    @Deprecated
    public int getMMAskTimeSeconds(RecordCursor cursor) {
        if (iAskTime < 0)
            return 0;
        return getInt(cursor, iAskTime);
    }

    @Deprecated
    public void setMMAskTimeSeconds(RecordCursor cursor, int _MMAskTime) {
        if (iAskTime < 0)
            return;
        setInt(cursor, iAskTime, _MMAskTime);
    }

    public long getAskTimeMillis(RecordCursor cursor) {
        if (iAskTime < 0)
            return 0;
        return getInt(cursor, iAskTime) * 1000L;
    }

    public void setAskTimeMillis(RecordCursor cursor, long askTime) {
        if (iAskTime < 0)
            return;
        setInt(cursor, iAskTime, TimeUtil.getSecondsFromTime(askTime));
    }

    public int getAskTimeSeconds(RecordCursor cursor) {
        if (iAskTime < 0)
            return 0;
        return getInt(cursor, iAskTime);
    }

    public void setAskTimeSeconds(RecordCursor cursor, int askTime) {
        if (iAskTime < 0)
            return;
        setInt(cursor, iAskTime, askTime);
    }

    @Deprecated
    public double getMMAskPrice(RecordCursor cursor) {
        return Decimal.toDouble(getInt(cursor, iAskPrice));
    }

    @Deprecated
    public void setMMAskPrice(RecordCursor cursor, double _MMAskPrice) {
        setInt(cursor, iAskPrice, Decimal.compose(_MMAskPrice));
    }

    @Deprecated
    public int getMMAskPriceDecimal(RecordCursor cursor) {
        return getInt(cursor, iAskPrice);
    }

    @Deprecated
    public void setMMAskPriceDecimal(RecordCursor cursor, int _MMAskPrice) {
        setInt(cursor, iAskPrice, _MMAskPrice);
    }

    public double getAskPrice(RecordCursor cursor) {
        return Decimal.toDouble(getInt(cursor, iAskPrice));
    }

    public void setAskPrice(RecordCursor cursor, double askPrice) {
        setInt(cursor, iAskPrice, Decimal.compose(askPrice));
    }

    public int getAskPriceDecimal(RecordCursor cursor) {
        return getInt(cursor, iAskPrice);
    }

    public void setAskPriceDecimal(RecordCursor cursor, int askPrice) {
        setInt(cursor, iAskPrice, askPrice);
    }

    @Deprecated
    public int getMMAskSize(RecordCursor cursor) {
        return getInt(cursor, iAskSize);
    }

    @Deprecated
    public void setMMAskSize(RecordCursor cursor, int _MMAskSize) {
        setInt(cursor, iAskSize, _MMAskSize);
    }

    public int getAskSize(RecordCursor cursor) {
        return getInt(cursor, iAskSize);
    }

    public void setAskSize(RecordCursor cursor, int askSize) {
        setInt(cursor, iAskSize, askSize);
    }

    @Deprecated
    public int getMMAskCount(RecordCursor cursor) {
        if (iAskCount < 0)
            return 0;
        return getInt(cursor, iAskCount);
    }

    @Deprecated
    public void setMMAskCount(RecordCursor cursor, int _MMAskCount) {
        if (iAskCount < 0)
            return;
        setInt(cursor, iAskCount, _MMAskCount);
    }

    public int getAskCount(RecordCursor cursor) {
        if (iAskCount < 0)
            return 0;
        return getInt(cursor, iAskCount);
    }

    public void setAskCount(RecordCursor cursor, int askCount) {
        if (iAskCount < 0)
            return;
        setInt(cursor, iAskCount, askCount);
    }
// END: CODE AUTOMATICALLY GENERATED
}
