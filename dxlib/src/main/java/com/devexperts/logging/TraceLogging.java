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
package com.devexperts.logging;

import java.io.PrintStream;
import java.util.logging.Level;

/**
 * This is a small in-memory cyclic buffer to keep the log for debugging concurrency problems in order to
 * reconstruct what was going on immediately before tests crashes, without actually writing all debug logging
 * to the log file or console normally. It is used by some tests when assertions are enabled,
 * otherwise this class should not even be loaded.
 */
public class TraceLogging {

    /**
     * Restarts trace logging from scratch (old log entries are cleared).
     * Use it at the beginning of the test.
     */
    public static synchronized void restart() {

    }

    /**
     * Stops trace logging.
     */
    public static void stop() {

    }

    public static void log(String loggerName, Level level, String msg, Throwable t) {

    }

    /**
     * Adds last entry and stops trace logging.
     */
    public static void logAndStop(Class<?> where, String msg) {
        logAndStop(where, msg, null);
    }

    /**
     * Adds last entry with exception and stops trace logging.
     */
    public static void logAndStop(Class<?> where, String msg, Throwable t) {
    }


    /**
     * Dumps last entries from this trace log.
     * It should be called after {@link #stop()} or {@link #logAndStop(Class, String)}.
     * It does nothing if called more than once after stop or before stop.
     */
    public static synchronized void dump(PrintStream out, String title) {

    }


}
