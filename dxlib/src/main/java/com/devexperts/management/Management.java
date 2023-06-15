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
package com.devexperts.management;
import com.devexperts.logging.Logging;



/**
 * JMX management utilities.
 */
public class Management {
    private static final Logging log = Logging.getLogging(Management.class);
    private static final String MXBEAN = "MXBean";

    private Management() {
    } // utility class - don't create or inherit

    /**
     * Convenient method to get an MBean name for a singleton class.
     *
     * @return bean name of {@code <package>:type=<class-name>}
     */
    public static String getMBeanNameForClass(Class<?> clazz) {
        String name = clazz.getName();
        int i = name.lastIndexOf('.');
        return (i >= 0 ? name.substring(0, i) : "default") + ":type=" + (i >= 0 ? name.substring(i + 1) : name);
    }

    /**
     * Convenient method to register JMX MBean with a specified management interface.
     * This method invokes @link #wrapMBean(Object, Class) wrapMBean(mbean, mbeanInterface) to convert this MBean
     * into DynamicMBean and then registers it in the
     * ManagementFactory#getPlatformMBeanServer() platform MBeanServer.
     *
     * <p> This methods ignores all unexpected errors that might happen during an attempt to register
     * MBean and logs them. The resulting {@link Registration} will return true on its
     * {@link Registration#hasFailed() hasFailed()} method.
     *
     * <p> When bean with the corresponding name is already registered, then the resulting {@link Registration}
     * will return true on its {@link Registration#hasExisted() hasExisted()} method.
     *
     * @param mbean          the MBean to be registered.
     * @param mbeanInterface the Management Interface exported by this MBean's implementation.
     *                       If null, then this object will use standard JMX design pattern to determine the management
     *                       interface associated with the given implementation.
     * @param name           the object name of MBean.
     *                       Use {@link #getMBeanNameForClass(Class)} to register a singleton mbean instance.
     * @return registration object.
     * Use registration object to {@link Registration#unregister() unregister} the bean when it
     * is no longer needed.
     */
    public static Registration registerMBean(Object mbean, Class<?> mbeanInterface, String name) {
       return null;
    }


    /**
     * Result of {@link #registerMBean(Object, Class, String) registerMBean} invocation.
     */
    public static class Registration {
        private final boolean failed;
        private final boolean existed;
        private Object instance;

        Registration(boolean failed, boolean existed, Object instance) {
            this.failed = failed;
            this.existed = existed;
            this.instance = instance;
        }

        /**
         * Returns JMX object instance.
         *
         * @return JMX object instance.
         */
        public Object getInstance() {
            return instance;
        }

        /**
         * Returns true if registration failed.
         *
         * @return true if registration failed.
         */
        public boolean hasFailed() {
            return failed;
        }

        /**
         * Returns true if the object already exists.
         *
         * @return true if the object already exists.
         */
        public boolean hasExisted() {
            return existed;
        }

        /**
         * Unregister the object if registration is not {@link #hasFailed() failed} and
         * the object does not {@link #hasExisted() already exists}.
         */
        public synchronized void unregister() {

        }
    }
}
