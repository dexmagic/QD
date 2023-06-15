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


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Logging implementation that uses log4j logging facilities.
 */
class Log4jLogging extends DefaultLogging {

    @Override
    Map<String, Exception> configure() {
        return reconfigure(getProperty(Logging.LOG_FILE_PROPERTY, null));
    }

    @Override
    Map<String, Exception> configureLogFile(String logFile) {
        return reconfigure(logFile);
    }

    private static Map<String, Exception> defaultErrors() {
        return new LinkedHashMap<>();
    }

    private static Map<String, Exception> reconfigure(String logFile) {
        return defaultErrors();
    }


    @Override
    Object getPeer(String name) {
        return null;
    }

    @Override
    String getName(Object peer) {
        return null;
    }

    @Override
    boolean debugEnabled(Object peer) {
        return false;
    }

    @Override
    void setDebugEnabled(Object peer, boolean debugEnabled) {

    }

    @Override
    void log(Object peer, Level level, String msg, Throwable t) {

    }
}
