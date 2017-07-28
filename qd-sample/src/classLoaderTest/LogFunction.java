/*
 * !++
 * QDS - Quick Data Signalling Library
 * !-
 * Copyright (C) 2002 - 2017 Devexperts LLC
 * !-
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 * http://mozilla.org/MPL/2.0/.
 * !__
 */
import com.devexperts.rmi.classloader.Function;

public class LogFunction implements Function {

    @Override
    public double getFunctionValue(double x) {
        return Math.log(x);
    }

    @Override
    public String toString() {
        return "ln(x)";
    }
}
