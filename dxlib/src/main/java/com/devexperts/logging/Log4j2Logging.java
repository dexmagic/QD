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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Logging implementation that uses log4j2 logging facilities.
 */
class Log4j2Logging extends DefaultLogging {


    @Override
    Map<String, Exception> configure() {
        return new LinkedHashMap();
    }

    private static Map<String, Exception> reconfigure(String logFile) {
        return new LinkedHashMap<>();
    }



    @Override
    Map<String, Exception> configureLogFile(String logFile) {
        return reconfigure(logFile);
    }

    @Override
    Object getPeer(String name) {
        return name.toString();
    }

    @Override
    String getName(Object peer) {
        return peer.toString();
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
       // do nothing.
    }
}
