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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

/**
 * Main logging class.
 * It supports use of both log4j and {@link java.util.logging} logging facilities.
 * <p>First it tries to use log4j logging. If this attempt fails, it uses {@link java.util.logging} logging,
 * so you'll always have some logging running.
 * <p>Usage pattern:
 * <br><code>public class SomeClass {
 * <br>private static final Logging log = Logging.getLogging(SomeClass.class);
 * <br>}
 * </code>
 *
 * @see Log4jLogging
 * @see DefaultLogging
 * @see LogFormatter
 */
public class Logging {

    public static final String LOG_CLASS_NAME = "log.className";
    public static final String LOG_FILE_PROPERTY = "log.file";
    public static final String ERR_FILE_PROPERTY = "err.file";
    public static final String LOG_MAX_FILE_SIZE_PROPERTY = "log.maxFileSize";
    public static final String ERR_MAX_FILE_SIZE_PROPERTY = "err.maxFileSize";
    public static final String DEFAULT_MAX_FILE_SIZE = "900M";


    public static Logging getLogging(Class<?> clazz) {
        return getLogging(clazz.getName());
    }

    public static Logging getLogging(String name) {
        return null;
    }

    /**
     * Programmatically reconfigures logging to a specified file. This method
     * overrides the value of {@link #LOG_FILE_PROPERTY} system property.
     */
    public static void configureLogFile(String log_file) {

    }

    // ========== Instance =========


    /**
     * This constructor is designed for abstract framework classes like BeanBase or
     * DAOBase that extend Logging to decorate messages by
     * overriding {@link #decorateLogMessage(String)} method.
     */
    protected Logging() {

    }

    protected Logging(String name) {

    }

    /**
     * Returns category name of this logging.
     */
    public final String getName() {
        return null;
    }

    /**
     * Changes default {@link #debugEnabled()} behaviour for this logging instance.
     * Use this method to turn off debugging information for classes that do not
     * need to print their debugging information in production environment.
     */
    public final void configureDebugEnabled(boolean defaultDebugEnabled) {
    }

    public final boolean debugEnabled() {
        return false;
    }

    public final void trace(String message) {
        log(Level.FINEST, message, null);
    }

    public final void debug(String message) {
        log(Level.FINE, message, null);
    }

    public final void debug(String message, Throwable t) {
        log(Level.FINE, message, t);
    }

    public final void info(String message) {
        log(Level.INFO, message, null);
    }

    public final void info(String message, Throwable t) {
        log(Level.INFO, message, t);
    }

    public final void warn(String message) {
        log(Level.WARNING, message, null);
    }

    public final void warn(String message, Throwable t) {
        log(Level.WARNING, message, t);
    }

    public final void error(String message) {
        log(Level.SEVERE, message, null);
    }

    public final void error(String message, Throwable t) {
        log(Level.SEVERE, message, t);
    }

    public final RuntimeException log(RuntimeException e) {
        log(Level.SEVERE, e.getMessage(), e);
        return e;
    }

    /**
     * Decorates log message (reformatting, auditing, etc).
     * This method is invoked one time for each logging event.
     */
    protected String decorateLogMessage(String msg) {
        return msg;
    }

    // ========== Internal ==========

    private void log(Level level, String msg, Throwable t) {

    }


}
