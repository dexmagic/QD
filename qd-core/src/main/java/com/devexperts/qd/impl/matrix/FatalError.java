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
package com.devexperts.qd.impl.matrix;

import com.devexperts.qd.QDLog;
import com.devexperts.qd.impl.matrix.management.DebugDump;
import com.devexperts.services.Services;
import com.devexperts.util.LogUtil;
import com.devexperts.util.SystemProperties;

/**
 * This class represents a fatal and unrecoverable error in the QDS core implementation.
 */
public class FatalError extends Error {

    /**
     * This method returns new {@code FatalError} with the corresponding message.
     * Does not terminate on Android.
     */
    static FatalError fatal(Object owner, String message) {
        return new FatalError(message);
    }

    private FatalError(String message) {
        super(message);
    }
}
