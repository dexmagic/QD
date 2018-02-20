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

public class ProfileMapping extends MarketEventMapping {
// BEGIN: CODE AUTOMATICALLY GENERATED: DO NOT MODIFY. IT IS REGENERATED BY com.dxfeed.api.codegen.ImplCodeGen
    private final int iBeta;
    private final int iEps;
    private final int iDivFreq;
    private final int iExdDivAmount;
    private final int iExdDivDate;
    private final int iHighPrice52;
    private final int iLowPrice52;
    private final int iShares;
    private final int iFreeFloat;
    private final int iHighLimitPrice;
    private final int iLowLimitPrice;
    private final int iHaltStartTime;
    private final int iHaltEndTime;
    private final int iFlags;
    private final int oDescription;
    private final int oStatusReason;

    public ProfileMapping(DataRecord record) {
        super(record);
        iBeta = MappingUtil.findIntField(record, "Beta", false);
        iEps = MappingUtil.findIntField(record, "Eps", false);
        iDivFreq = MappingUtil.findIntField(record, "DivFreq", false);
        iExdDivAmount = MappingUtil.findIntField(record, "ExdDiv.Amount", false);
        iExdDivDate = MappingUtil.findIntField(record, "ExdDiv.Date", false);
        iHighPrice52 = MappingUtil.findIntField(record, "52High.Price", false);
        iLowPrice52 = MappingUtil.findIntField(record, "52Low.Price", false);
        iShares = MappingUtil.findIntField(record, "Shares", false);
        iFreeFloat = MappingUtil.findIntField(record, "FreeFloat", false);
        iHighLimitPrice = MappingUtil.findIntField(record, "HighLimitPrice", false);
        iLowLimitPrice = MappingUtil.findIntField(record, "LowLimitPrice", false);
        iHaltStartTime = MappingUtil.findIntField(record, "Halt.StartTime", false);
        iHaltEndTime = MappingUtil.findIntField(record, "Halt.EndTime", false);
        iFlags = MappingUtil.findIntField(record, "Flags", false);
        oDescription = MappingUtil.findObjField(record, "Description", true);
        oStatusReason = MappingUtil.findObjField(record, "StatusReason", false);
        putNonDefaultPropertyName("52High.Price", "HighPrice52");
        putNonDefaultPropertyName("52Low.Price", "LowPrice52");
    }

    public double getBeta(RecordCursor cursor) {
        if (iBeta < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iBeta));
    }

    public void setBeta(RecordCursor cursor, double beta) {
        if (iBeta < 0)
            return;
        setInt(cursor, iBeta, Decimal.compose(beta));
    }

    public int getBetaDecimal(RecordCursor cursor) {
        if (iBeta < 0)
            return 0;
        return getInt(cursor, iBeta);
    }

    public void setBetaDecimal(RecordCursor cursor, int beta) {
        if (iBeta < 0)
            return;
        setInt(cursor, iBeta, beta);
    }

    public double getEps(RecordCursor cursor) {
        if (iEps < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iEps));
    }

    public void setEps(RecordCursor cursor, double eps) {
        if (iEps < 0)
            return;
        setInt(cursor, iEps, Decimal.compose(eps));
    }

    public int getEpsDecimal(RecordCursor cursor) {
        if (iEps < 0)
            return 0;
        return getInt(cursor, iEps);
    }

    public void setEpsDecimal(RecordCursor cursor, int eps) {
        if (iEps < 0)
            return;
        setInt(cursor, iEps, eps);
    }

    public int getDivFreq(RecordCursor cursor) {
        if (iDivFreq < 0)
            return 0;
        return getInt(cursor, iDivFreq);
    }

    public void setDivFreq(RecordCursor cursor, int divFreq) {
        if (iDivFreq < 0)
            return;
        setInt(cursor, iDivFreq, divFreq);
    }

    public double getExdDivAmount(RecordCursor cursor) {
        if (iExdDivAmount < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iExdDivAmount));
    }

    public void setExdDivAmount(RecordCursor cursor, double exdDivAmount) {
        if (iExdDivAmount < 0)
            return;
        setInt(cursor, iExdDivAmount, Decimal.compose(exdDivAmount));
    }

    public int getExdDivAmountDecimal(RecordCursor cursor) {
        if (iExdDivAmount < 0)
            return 0;
        return getInt(cursor, iExdDivAmount);
    }

    public void setExdDivAmountDecimal(RecordCursor cursor, int exdDivAmount) {
        if (iExdDivAmount < 0)
            return;
        setInt(cursor, iExdDivAmount, exdDivAmount);
    }

    public int getExdDivDate(RecordCursor cursor) {
        if (iExdDivDate < 0)
            return 0;
        return getInt(cursor, iExdDivDate);
    }

    public void setExdDivDate(RecordCursor cursor, int exdDivDate) {
        if (iExdDivDate < 0)
            return;
        setInt(cursor, iExdDivDate, exdDivDate);
    }

    @Deprecated
    public double get52HighPrice(RecordCursor cursor) {
        if (iHighPrice52 < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iHighPrice52));
    }

    @Deprecated
    public void set52HighPrice(RecordCursor cursor, double _52HighPrice) {
        if (iHighPrice52 < 0)
            return;
        setInt(cursor, iHighPrice52, Decimal.compose(_52HighPrice));
    }

    @Deprecated
    public int get52HighPriceDecimal(RecordCursor cursor) {
        if (iHighPrice52 < 0)
            return 0;
        return getInt(cursor, iHighPrice52);
    }

    @Deprecated
    public void set52HighPriceDecimal(RecordCursor cursor, int _52HighPrice) {
        if (iHighPrice52 < 0)
            return;
        setInt(cursor, iHighPrice52, _52HighPrice);
    }

    public double getHighPrice52(RecordCursor cursor) {
        if (iHighPrice52 < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iHighPrice52));
    }

    public void setHighPrice52(RecordCursor cursor, double highPrice52) {
        if (iHighPrice52 < 0)
            return;
        setInt(cursor, iHighPrice52, Decimal.compose(highPrice52));
    }

    public int getHighPrice52Decimal(RecordCursor cursor) {
        if (iHighPrice52 < 0)
            return 0;
        return getInt(cursor, iHighPrice52);
    }

    public void setHighPrice52Decimal(RecordCursor cursor, int highPrice52) {
        if (iHighPrice52 < 0)
            return;
        setInt(cursor, iHighPrice52, highPrice52);
    }

    @Deprecated
    public double get52LowPrice(RecordCursor cursor) {
        if (iLowPrice52 < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iLowPrice52));
    }

    @Deprecated
    public void set52LowPrice(RecordCursor cursor, double _52LowPrice) {
        if (iLowPrice52 < 0)
            return;
        setInt(cursor, iLowPrice52, Decimal.compose(_52LowPrice));
    }

    @Deprecated
    public int get52LowPriceDecimal(RecordCursor cursor) {
        if (iLowPrice52 < 0)
            return 0;
        return getInt(cursor, iLowPrice52);
    }

    @Deprecated
    public void set52LowPriceDecimal(RecordCursor cursor, int _52LowPrice) {
        if (iLowPrice52 < 0)
            return;
        setInt(cursor, iLowPrice52, _52LowPrice);
    }

    public double getLowPrice52(RecordCursor cursor) {
        if (iLowPrice52 < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iLowPrice52));
    }

    public void setLowPrice52(RecordCursor cursor, double lowPrice52) {
        if (iLowPrice52 < 0)
            return;
        setInt(cursor, iLowPrice52, Decimal.compose(lowPrice52));
    }

    public int getLowPrice52Decimal(RecordCursor cursor) {
        if (iLowPrice52 < 0)
            return 0;
        return getInt(cursor, iLowPrice52);
    }

    public void setLowPrice52Decimal(RecordCursor cursor, int lowPrice52) {
        if (iLowPrice52 < 0)
            return;
        setInt(cursor, iLowPrice52, lowPrice52);
    }

    public long getShares(RecordCursor cursor) {
        if (iShares < 0)
            return 0;
        return (long) (Decimal.toDouble(getInt(cursor, iShares)) * 1000 + 0.5);
    }

    public void setShares(RecordCursor cursor, long shares) {
        if (iShares < 0)
            return;
        setInt(cursor, iShares, Decimal.composeDecimal(shares, 3));
    }

    public double getSharesDouble(RecordCursor cursor) {
        if (iShares < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iShares)) * 1000;
    }

    public void setSharesDouble(RecordCursor cursor, double shares) {
        if (iShares < 0)
            return;
        setInt(cursor, iShares, Decimal.compose(shares / 1000));
    }

    public int getSharesDecimal(RecordCursor cursor) {
        if (iShares < 0)
            return 0;
        return getInt(cursor, iShares);
    }

    public void setSharesDecimal(RecordCursor cursor, int shares) {
        if (iShares < 0)
            return;
        setInt(cursor, iShares, shares);
    }

    public long getFreeFloat(RecordCursor cursor) {
        if (iFreeFloat < 0)
            return 0;
        return (long) Decimal.toDouble(getInt(cursor, iFreeFloat));
    }

    public void setFreeFloat(RecordCursor cursor, long freeFloat) {
        if (iFreeFloat < 0)
            return;
        setInt(cursor, iFreeFloat, Decimal.composeDecimal(freeFloat, 0));
    }

    public double getFreeFloatDouble(RecordCursor cursor) {
        if (iFreeFloat < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iFreeFloat));
    }

    public void setFreeFloatDouble(RecordCursor cursor, double freeFloat) {
        if (iFreeFloat < 0)
            return;
        setInt(cursor, iFreeFloat, Decimal.compose(freeFloat));
    }

    public int getFreeFloatDecimal(RecordCursor cursor) {
        if (iFreeFloat < 0)
            return 0;
        return getInt(cursor, iFreeFloat);
    }

    public void setFreeFloatDecimal(RecordCursor cursor, int freeFloat) {
        if (iFreeFloat < 0)
            return;
        setInt(cursor, iFreeFloat, freeFloat);
    }

    public double getHighLimitPrice(RecordCursor cursor) {
        if (iHighLimitPrice < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iHighLimitPrice));
    }

    public void setHighLimitPrice(RecordCursor cursor, double highLimitPrice) {
        if (iHighLimitPrice < 0)
            return;
        setInt(cursor, iHighLimitPrice, Decimal.compose(highLimitPrice));
    }

    public int getHighLimitPriceDecimal(RecordCursor cursor) {
        if (iHighLimitPrice < 0)
            return 0;
        return getInt(cursor, iHighLimitPrice);
    }

    public void setHighLimitPriceDecimal(RecordCursor cursor, int highLimitPrice) {
        if (iHighLimitPrice < 0)
            return;
        setInt(cursor, iHighLimitPrice, highLimitPrice);
    }

    public double getLowLimitPrice(RecordCursor cursor) {
        if (iLowLimitPrice < 0)
            return Double.NaN;
        return Decimal.toDouble(getInt(cursor, iLowLimitPrice));
    }

    public void setLowLimitPrice(RecordCursor cursor, double lowLimitPrice) {
        if (iLowLimitPrice < 0)
            return;
        setInt(cursor, iLowLimitPrice, Decimal.compose(lowLimitPrice));
    }

    public int getLowLimitPriceDecimal(RecordCursor cursor) {
        if (iLowLimitPrice < 0)
            return 0;
        return getInt(cursor, iLowLimitPrice);
    }

    public void setLowLimitPriceDecimal(RecordCursor cursor, int lowLimitPrice) {
        if (iLowLimitPrice < 0)
            return;
        setInt(cursor, iLowLimitPrice, lowLimitPrice);
    }

    public long getHaltStartTimeMillis(RecordCursor cursor) {
        if (iHaltStartTime < 0)
            return 0;
        return getInt(cursor, iHaltStartTime) * 1000L;
    }

    public void setHaltStartTimeMillis(RecordCursor cursor, long haltStartTime) {
        if (iHaltStartTime < 0)
            return;
        setInt(cursor, iHaltStartTime, TimeUtil.getSecondsFromTime(haltStartTime));
    }

    public int getHaltStartTimeSeconds(RecordCursor cursor) {
        if (iHaltStartTime < 0)
            return 0;
        return getInt(cursor, iHaltStartTime);
    }

    public void setHaltStartTimeSeconds(RecordCursor cursor, int haltStartTime) {
        if (iHaltStartTime < 0)
            return;
        setInt(cursor, iHaltStartTime, haltStartTime);
    }

    public long getHaltEndTimeMillis(RecordCursor cursor) {
        if (iHaltEndTime < 0)
            return 0;
        return getInt(cursor, iHaltEndTime) * 1000L;
    }

    public void setHaltEndTimeMillis(RecordCursor cursor, long haltEndTime) {
        if (iHaltEndTime < 0)
            return;
        setInt(cursor, iHaltEndTime, TimeUtil.getSecondsFromTime(haltEndTime));
    }

    public int getHaltEndTimeSeconds(RecordCursor cursor) {
        if (iHaltEndTime < 0)
            return 0;
        return getInt(cursor, iHaltEndTime);
    }

    public void setHaltEndTimeSeconds(RecordCursor cursor, int haltEndTime) {
        if (iHaltEndTime < 0)
            return;
        setInt(cursor, iHaltEndTime, haltEndTime);
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

    public String getDescription(RecordCursor cursor) {
        return (String) getObj(cursor, oDescription);
    }

    public void setDescription(RecordCursor cursor, String description) {
        setObj(cursor, oDescription, description);
    }

    public String getStatusReason(RecordCursor cursor) {
        if (oStatusReason < 0)
            return null;
        return (String) getObj(cursor, oStatusReason);
    }

    public void setStatusReason(RecordCursor cursor, String statusReason) {
        if (oStatusReason < 0)
            return;
        setObj(cursor, oStatusReason, statusReason);
    }
// END: CODE AUTOMATICALLY GENERATED
}
