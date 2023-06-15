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

import java.lang.reflect.Field;

/**
 * Detailed custom layout for log4j.
 */
public class DetailedLogLayout {

    public void activateOptions() {
    }

    public String[] getOptionStrings() {
        return new String[0];
    }

    public void setOption(String option, String value) {
    }

    public boolean ignoresThrowable() {
        return true;
    }

    public String format(Object event) {
        return event.toString();
    }
}
