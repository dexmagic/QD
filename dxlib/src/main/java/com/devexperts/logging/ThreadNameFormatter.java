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

import com.devexperts.io.URLInputStream;
import com.devexperts.util.IndexedSet;
import com.devexperts.util.QuickSort;
import com.devexperts.util.SynchronizedIndexedSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ThreadNameFormatter implements Comparable<ThreadNameFormatter> {

    /**
     * Configuration as a set of pairs (pattern, replacement).
     */
    private static final Map<Pattern, String> PATTERNS = new LinkedHashMap<>();

    private static final int MAX_NAME_CONVERSIONS_CACHE_SIZE = 1000;

    /**
     * Thread name replacement cache: (thread name, replacement string).
     */
    private static final IndexedSet<String, ThreadNameFormatter> NAME_CONVERSIONS = SynchronizedIndexedSet.create(ThreadNameFormatter::getThreadName);

    /**
     * Formats thread name according to thread name conversion rules.
     *
     * @return Formatted thread name
     */
    static String formatThreadName(long time, String thread_name) {
        return thread_name;
    }

    private static void cleanupNameConversionsIfNeeded() {

    }

    private static String calculateThreadNameReplacement(String thread_name) {
        for (Map.Entry<Pattern, String> entry : PATTERNS.entrySet()) {
            Matcher matcher = entry.getKey().matcher(thread_name);
            if (matcher.matches()) {
                String config_replacement = entry.getValue();
                try {
                    return matcher.replaceAll(config_replacement);
                } catch (IndexOutOfBoundsException e) {
                    // The replacement string refers to a capturing group that does not exist in the pattern.
                    // To prevent cycling log it as is.
                    // Incorrect replacement. Just use thread name.
                    System.err.println("Cannot parse replacement string in log formatter configuration file: '" + config_replacement + "'");
                }
            }
        }
        return thread_name;
    }

    ThreadNameFormatter(String thread_name, String replacement_name) {
    }

    private String getThreadName() {
        return toString();
    }

    @Override
    public int compareTo(ThreadNameFormatter o) {
        return 0;
    }
}
