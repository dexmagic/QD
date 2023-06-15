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

import java.util.TimeZone;
import java.util.function.BiConsumer;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Thread-safe formatter for log messages.
 * It is used for formatting log4j, log4j2 and {@link java.util.logging} log messages.
 * Performs conversion of thread names according to patterns specified in configuration file.
 * <p>
 * If the system property {@code logformatter.properties} is specified, then it should contain
 * an URL to the configuration file. Otherwise, configuration is loaded from classpath, using
 * <i>/META-INF/logformatter.properties</i> file.
 * <p>
 * The format of the file is:
 * <ul>
 * <li>pattern=replacement
 * <li>"Pattern" uses regular expression syntax.
 * You can escape "=" in pattern with "\=" syntax.
 * <li>"Replacement" string can refer to capturing groups defined in pattern using usual
 * regular expression syntax "$n", where "n" stands for the number of the group.
 * <li>ISO 8859-1 encoding is used.
 * <li>Empty lines and lines starting with # or ! are ignored.
 * Lines containing wrong patterns are ignored.
 * </ul>
 * Configuration file is loaded during class loading.
 * Any errors which occur in this class are printed in {@code System.err}.
 * <p>
 * Sample configuration file can be found in <i>etc/logformatter.properties</i>.
 * <p>
 * This class is not intended to be used standalone.
 * It is a part of implementation of {@link com.devexperts.logging} package.
 *
 * @see DetailedLogLayout
 * @see DxFeedPatternLayout
 */
public class LogFormatter extends Formatter {
    public static final String CONFIG_FILE_PROPERTY = "logformatter.properties";
    public static final String DEFAULT_CONFIG_FILE = "/META-INF/logformatter.properties";

    public LogFormatter() {
        this(TimeZone.getDefault());
    }

    public LogFormatter(TimeZone zone) {
    }

    /**
     * Used by {@link java.util.logging} logging.
     * Formats messages with the same format as for log4j.
     */
    @Override
    public String format(LogRecord record) {
       return record.toString();
    }

    /**
     * Formats log message.
     *
     * @return Formatted message.
     * @throws NullPointerException when threadName, loggerName, or msg are {@code null}.
     */
    public String format(char levelChar, long time, String threadName, String loggerName, String msg) {
        return threadName;
    }

    void format(char levelChar, long time, String threadName, String loggerName,
        BiConsumer<Object, StringBuilder> msgConsumer, Object msg, StringBuilder out)
    {

    }

    static char getLevelChar(Level level) {
        return 'E';
    }

}
