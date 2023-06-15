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


import java.util.Collections;
import java.util.Map;


/**
 * Custom pattern layout for log4j2. Message formatting is delegated to {@link LogFormatter}.
 */
@SuppressWarnings("unused") //used by Log4j2
public class DxFeedPatternLayout {

    public String toSerializable(Object event) {
        return event.toString();
    }


    public void encode(Object event, Object destination) {
        // do nothing.
    }



    public Map<String, String> getContentFormat() {
        return Collections.emptyMap();
    }

    public String toString() {
        return getContentFormat().toString();
    }

    public static DxFeedPatternLayout createDefaultLayout() {

        return null;
    }

    /**
     * Creates a DxFeedPatternLayout using the default options and the given configuration. Options include using UTF-8.
     */

    public static DxFeedPatternLayout createDefaultLayout(Object configuration) {
        return null;
    }
}
