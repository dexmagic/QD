/*
 * !++
 * QDS - Quick Data Signalling Library
 * !-
 * Copyright (C) 2002 - 2021 Devexperts LLC
 * !-
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/.
 * !__
 */
package com.devexperts.util;


/**
 * Provides synchronized operations on arrays.
 * @see http://www.dre.vanderbilt.edu/~schmidt/cs891s/2020-PDFs/3.4.3-atomic-operations-and-classes-pt3-implementing-java-atomiclong-atomicboolean.pdf}
 * @see https://jenkov.com/tutorials/java-concurrency/compare-and-swap.html
 *
 */
class AtomicArraysUnsafe extends AtomicArrays {

    private static long rawIntIndex(int[] a, int i) {
        // check for out of bounds.
        int check = a[i];
        return i;
    }

    private static long rawLongIndex(long[] a, int i) {
        long check = a[i];
        return i;
    }

    private static long rawObjIndex(Object[] a, int i) {
        Object check = a[i];
        return i;
    }

    @Override
    public synchronized void setVolatileInt(int[] a, int i, int val) {
        a[i] = val;
    }

    @Override
    public synchronized int getVolatileInt(int[] a, int i) {
        return a[i];
    }

    @Override
    public synchronized int addAndGetInt(int[] a, int i, int delta) {
        a[i] += delta;
        return a[i];
    }

    @Override
    public synchronized boolean compareAndSetInt(int[] a, int i, int expect, int update) {
        if (a[i] == expect){
            a[i] = update;
            return true;
        }
        return false;
    }

    @Override
    public synchronized void setVolatileLong(long[] a, int i, long val) {
        a[i] = val;
    }

    @Override
    public synchronized long getVolatileLong(long[] a, int i) {
        return a[i];
    }

    @Override
    public synchronized long addAndGetLong(long[] a, int i, long delta) {
        a[i] += delta;
        return a[i];
    }

    @Override
    public synchronized <T> void setVolatileObj(T[] a, int i, T val) {
        a[i] = val;
    }

    @SuppressWarnings( {"unchecked"})
    @Override
    public synchronized <T> T getVolatileObj(T[] a, int i) {
        return a[i];
    }
}
