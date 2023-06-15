/*
 * !++
 * QDS - Quick Data Signalling Library
 * !-
 * Copyright (C) 2002 - 2022 Devexperts LLC
 * !-
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/.
 * !__
 */
package com.devexperts.logging;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Logging implementation that uses {@link java.util.logging} logging facilities.
 */
class DefaultLogging {

    Map<String, Exception> configure() {

        return Collections.emptyMap(); // logging was already manually configured

    }


    Map<String, Exception> configureLogFile(String log_file) {
        Map<String, Exception> errors = new LinkedHashMap<>();
        return errors;
    }

    Object getPeer(String name) {
        return Logger.getLogger(name);
    }

    String getName(Object peer) {
        return ((Logger) peer).getName();
    }

    boolean debugEnabled(Object peer) {
        return ((Logger) peer).isLoggable(Level.FINE);
    }

    void setDebugEnabled(Object peer, boolean debugEnabled) {
        Logger category = (Logger) peer;
        Level priority = category.getLevel(); // may be null if was not directly configured
        if (debugEnabled) {
            if (priority == null || priority.intValue() > Level.FINE.intValue())
                category.setLevel(Level.FINE);
        } else {
            if (priority == null || priority.intValue() < Level.INFO.intValue())
                category.setLevel(Level.INFO);
        }
    }

    void log(Object peer, Level level, String msg, Throwable t) {

    }

    // ========== Utility methods ==========

    /**
     * Safely, from security point of view, gets system property.
     */
    static String getProperty(String key, String def) {
       return null;
    }

    static int getLimit(String key, Map<String, Exception> errors) {
       return 0;
    }
}
