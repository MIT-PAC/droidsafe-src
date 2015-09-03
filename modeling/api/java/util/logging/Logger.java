/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

import dalvik.system.DalvikLogHandler;
import dalvik.system.DalvikLogging;

public class Logger {

    /**
     * Load the specified resource bundle, use privileged code.
     *
     * @param resourceBundleName
     *            the name of the resource bundle to load, cannot be {@code null}.
     * @return the loaded resource bundle.
     * @throws MissingResourceException
     *             if the specified resource bundle can not be loaded.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.304 -0500", hash_original_method = "0FBB80F13AF6F3A9057E687D9BCE4FB9", hash_generated_method = "B5B7EC09E12205DC8F08FC85B42E3C26")
    
static ResourceBundle loadResourceBundle(String resourceBundleName) {
        // try context class loader to load the resource
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl != null) {
            try {
                return ResourceBundle.getBundle(resourceBundleName, Locale.getDefault(), cl);
            } catch (MissingResourceException ignored) {
                // Failed to load using context class loader, ignore
            }
        }
        // try system class loader to load the resource
        cl = ClassLoader.getSystemClassLoader();
        if (cl != null) {
            try {
                return ResourceBundle.getBundle(resourceBundleName, Locale.getDefault(), cl);
            } catch (MissingResourceException ignored) {
                // Failed to load using system class loader, ignore
            }
        }
        throw new MissingResourceException("Failed to load the specified resource bundle \"" +
                resourceBundleName + "\"", resourceBundleName, null);
    }

    /**
     * Gets an anonymous logger to use internally in a thread. Anonymous loggers
     * are not registered in the log manager's namespace. No security checks
     * will be performed when updating an anonymous logger's control settings.
     * <p>
     * The anonymous loggers' parent is set to be the root logger. This way it
     * inherits the default logging level and handlers from the root logger.
     *
     * @return a new instance of anonymous logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.307 -0500", hash_original_method = "33E35DAF5713B97A634B9F1AE8BF6A88", hash_generated_method = "4F3F4A4ED61E1528BB083EE36635ECD1")
    
public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    /**
     * Gets an anonymous logger to use internally in a thread. Anonymous loggers
     * are not registered in the log manager's namespace. No security checks
     * will be performed when updating an anonymous logger's control settings.
     * <p>
     * The anonymous loggers' parent is set to be the root logger. This way it
     * inherits default logging level and handlers from the root logger.
     *
     * @param resourceBundleName
     *            the name of the resource bundle used to localize log messages.
     * @return a new instance of anonymous logger.
     * @throws MissingResourceException
     *             if the specified resource bundle can not be loaded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.309 -0500", hash_original_method = "B4C3A3B0A9BA44ADFC2BA61E72362AA6", hash_generated_method = "4C65D3BC21A9BB37FE27523143F7A8B5")
    
public static Logger getAnonymousLogger(String resourceBundleName) {
        Logger result = new Logger(null, resourceBundleName);
        result.isNamed = false;
        LogManager logManager = LogManager.getLogManager();
        logManager.setParent(result, logManager.getLogger(""));
        return result;
    }

    /**
     * Gets a named logger. The returned logger may already exist or may be
     * newly created. In the latter case, its level will be set to the
     * configured level according to the {@code LogManager}'s properties.
     *
     * @param name
     *            the name of the logger to get, cannot be {@code null}.
     * @return a named logger.
     * @throws MissingResourceException
     *             If the specified resource bundle can not be loaded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.314 -0500", hash_original_method = "CCC6971033B3E92E36973DF1CB62F316", hash_generated_method = "809F3C4D6A84AB87A94C2B953B2694E5")
    
public static Logger getLogger(String name) {
        return LogManager.getLogManager().getOrCreate(name, null);
    }

    /**
     * Gets a named logger associated with the supplied resource bundle. The
     * resource bundle will be used to localize logging messages.
     *
     * @param name
     *            the name of the logger to get, cannot be {@code null}.
     * @param resourceBundleName
     *            the name of the resource bundle, may be {@code null}.
     * @throws IllegalArgumentException
     *             if the logger identified by {@code name} is associated with a
     *             resource bundle and its name is not equal to
     *             {@code resourceBundleName}.
     * @throws MissingResourceException
     *             if the name of the resource bundle cannot be found.
     * @return a named logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.318 -0500", hash_original_method = "FF215F56C3D4087B17E522721EB89987", hash_generated_method = "42AB9F239C505B8562FF36527980C955")
    
public static Logger getLogger(String name, String resourceBundleName) {
        Logger result = LogManager.getLogManager()
                .getOrCreate(name, resourceBundleName);
        result.initResourceBundle(resourceBundleName);
        return result;
    }

    /**
     * Returns the global {@code Logger}.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.320 -0500", hash_original_method = "2D16380526A24256011C5D09E6CFA82F", hash_generated_method = "856042E979E1555090872CCD036A3CC4")
    
public static Logger getGlobal() {
        return global;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_field = "C11C2AFA3BE2E8C2EACE37E50E80D018", hash_generated_field = "4D6D3020B80CE3D35D2F8F928539DCF2")

    private static final DalvikLogHandler GENERAL_LOG_HANDLER = new DalvikLogHandler() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_method = "EC3A1A4621BA8EF22A571BDE68197799", hash_generated_method = "6101897D1D7337D250B83AA802BFD691")
        public void publish(Logger source, String tag, Level level, String message) {
            LogRecord record = new LogRecord(level, message);
            record.setLoggerName(source.name);
            source.setResourceBundle(record);
            source.log(record);
            addTaint(source.getTaint());
            addTaint(tag.getTaint());
            addTaint(level.getTaint());
            addTaint(message.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.260 -0500", hash_original_field = "355EDAA79615583BDDA05DCEA7C37082", hash_generated_field = "EFFEA762C1908ADB01D1927B32F091A6")

    public static final String GLOBAL_LOGGER_NAME = "global";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.263 -0500", hash_original_field = "3FB43240F8EAA607CC9A0CB6F0FE9023", hash_generated_field = "E7AC46ADB144618E388DFF4E480328CF")

    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.265 -0500", hash_original_field = "BE163127EDFA45933AC5BD0DE9470245", hash_generated_field = "46E006A6968A44BB222FB4D5DC1F24A5")

    private static final Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.268 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "927B896D5AC0DD7FBCC14EBF7566F9A4")

    private volatile String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.270 -0500", hash_original_field = "4AE1F195790419CAC93DADD2BF6962F7", hash_generated_field = "4AE1F195790419CAC93DADD2BF6962F7")

    Logger parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.272 -0500", hash_original_field = "14DCE8BA793EFECA9A19904022092494", hash_generated_field = "A8FA1EF9E438D313624ABCF6D48E27D1")

    volatile Level levelObjVal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.275 -0500", hash_original_field = "A3026DD48ACB3024CE40531ADB5DA71A", hash_generated_field = "64484DD5AFFDF68559B6EA3E925D55F8")

    volatile int levelIntVal = Level.INFO.intValue();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.277 -0500", hash_original_field = "EF9962899F2EFF8A0104DADC91C5765D", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.280 -0500", hash_original_field = "35CC6187306CFB2B68FF26D1B6A58A2F", hash_generated_field = "878F5AE2179223671F6F7BF03BBE54A8")

    private volatile String resourceBundleName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.282 -0500", hash_original_field = "0BC5764EC59B8E2CBA669D3725A3F394", hash_generated_field = "D2720EA1493F697783188B90B5C01BC8")

    private volatile ResourceBundle resourceBundle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.285 -0500", hash_original_field = "511249F439F7EEDBF31419E8499FC0BF", hash_generated_field = "0713314804552265A9281F5BE4F5F4B2")

    private final List<Handler> handlers = new CopyOnWriteArrayList<Handler>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.287 -0500", hash_original_field = "2C5DB5CB4C5D584F30E780D76C1D43BB", hash_generated_field = "A0A66C106644DF6FD3D6C7A1325B8EE1")

    private boolean notifyParentHandlers = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.289 -0500", hash_original_field = "CD1BE419750B80A54FAC59C8D15B27B3", hash_generated_field = "DF5415EF24FD42F5DFD2A24AF349A364")

    private boolean isNamed = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.291 -0500", hash_original_field = "073FC86CB7FF15B250FB0D9F11151601", hash_generated_field = "766EA8FEA2309436285546014402AC5C")

    final List<Logger> children = new ArrayList<Logger>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.294 -0500", hash_original_field = "9DEB6E9C243420B192E14054716DC654", hash_generated_field = "0F73A57BF2C3FEF042A9DB67B2E7D8CC")

    private  String androidTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.296 -0500", hash_original_field = "DA1CD444238F18E6E65031B9D40C171C", hash_generated_field = "B5C7FD88BFAFFDC7B0174CF578919C4C")

    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;

    /**
     * Constructs a {@code Logger} object with the supplied name and resource
     * bundle name; {@code notifiyParentHandlers} is set to {@code true}.
     * <p>
     * Notice : Loggers use a naming hierarchy. Thus "z.x.y" is a child of "z.x".
     *
     * @param name
     *            the name of this logger, may be {@code null} for anonymous
     *            loggers.
     * @param resourceBundleName
     *            the name of the resource bundle used to localize logging
     *            messages, may be {@code null}.
     * @throws MissingResourceException
     *             if the specified resource bundle can not be loaded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.302 -0500", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "AEBD350904F4692D091562ED6A429BA4")
    
protected Logger(String name, String resourceBundleName) {
        this.name = name;
        initResourceBundle(resourceBundleName);
        this.androidTag = DalvikLogging.loggerNameToTag(name);
        updateDalvikLogHandler();
    }

    /**
     * We've optimized for the common case: logging to a single handler that
     * implements {@link DalvikLogHandler}. This is how Android framework
     * applications are configured by default.
     *
     * <p>This optimization has been measured to show a 2.75x improvement in
     * throughput in the common case: 154ns vs. 56ns per message on a Cortex-A8.
     * Direct use of {@code android.util.Log} takes 29ns per message.
     *
     * <p>Each time the handler configuration changes, either directly or
     * indirectly, it's necessary to either turn on or off this optimization.
     * When the optimization is off, {@link #dalvikLogHandler} is assigned to
     * {@link #GENERAL_LOG_HANDLER} which can satisfy arbitrary configuration.
     * When the optimization is possible, {@link #dalvikLogHandler} is assigned
     * to the user's efficient implementation. In pratice this is usually the
     * {@code com.android.internal.logging.AndroidHandler}.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.299 -0500", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "E5614210E3F76B6AFF7F65DBC4BB8E8C")
    
void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler = GENERAL_LOG_HANDLER;

        Logger parent = this.parent;

        if (getClass() != Logger.class) {
            /*
             * Do nothing. Subclasses aren't eligible for the optimization
             * because they may override methods like getHandlers() or
             * log(LogRecord).
             */

        } else if (parent == null) {
            // we use an iterator rather than size()+get() for safe concurrency
            Iterator<Handler> h = handlers.iterator();
            if (h.hasNext()) {
                Handler firstHandler = h.next();
                if (!h.hasNext() && firstHandler instanceof DalvikLogHandler) {
                    /*
                     * At this point, we're eligible for the optimization. We've
                     * satisfied these constraints:
                     *   1. This is not a subclass of logger
                     *   2. This is a root logger (no parent)
                     *   3. There is exactly one handler installed
                     *   4. That handler is a DalvikLogHandler
                     */
                    newLogHandler = (DalvikLogHandler) firstHandler;
                }
            }
        } else if (handlers.isEmpty() && notifyParentHandlers) {
            /*
             * At this point, we're eligible for the optimization if our parent
             * logger is eligible. We've satisfied these constraints:
             *   1. This is not a subclass of logger
             *   2. our parent exists
             *   3. we have no handlers of our own
             *   4. we notify our parent's handlers
             */
            newLogHandler = parent.dalvikLogHandler;
        }

        if (newLogHandler == this.dalvikLogHandler) {
            return;
        }

        this.dalvikLogHandler = newLogHandler;

        for (Logger logger : children) {
            logger.updateDalvikLogHandler();
        }
    }

    /**
     * Initializes this logger's resource bundle.
     *
     * @throws IllegalArgumentException if this logger's resource bundle already
     *      exists and is different from the resource bundle specified.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.312 -0500", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "04E41A1E9D1B521397ED7A85F49E31E1")
    
private synchronized void initResourceBundle(String resourceBundleName) {
        String current = this.resourceBundleName;

        if (current != null) {
            if (current.equals(resourceBundleName)) {
                return;
            } else {
                throw new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
            }
        }

        if (resourceBundleName != null) {
            this.resourceBundle = loadResourceBundle(resourceBundleName);
            this.resourceBundleName = resourceBundleName;
        }
    }

    /**
     * Adds a handler to this logger. The {@code name} will be fed with log
     * records received by this logger.
     *
     * @param handler
     *            the handler object to add, cannot be {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.323 -0500", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "320B81030ED269C96B74A5FBCC20C896")
    
public void addHandler(Handler handler) {
        if (handler == null) {
            throw new NullPointerException("handler == null");
        }
        // Anonymous loggers can always add handlers
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        this.handlers.add(handler);
        updateDalvikLogHandler();
    }

    /**
     * Set the logger's manager and initializes its configuration from the
     * manager's properties.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.326 -0500", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "4498A4914B339ECC6C0CA41B926DD713")
    
void setManager(LogManager manager) {
        String levelProperty = manager.getProperty(name + ".level");
        if (levelProperty != null) {
            try {
                manager.setLevelRecursively(Logger.this, Level.parse(levelProperty));
            } catch (IllegalArgumentException invalidLevel) {
                invalidLevel.printStackTrace();
            }
        }

        String handlersPropertyName = name.isEmpty() ? "handlers" : name + ".handlers";
        String handlersProperty = manager.getProperty(handlersPropertyName);
        if (handlersProperty != null) {
            for (String handlerName : handlersProperty.split(",|\\s")) {
                if (handlerName.isEmpty()) {
                    continue;
                }

                final Handler handler;
                try {
                    handler = (Handler) LogManager.getInstanceByClass(handlerName);
                } catch (Exception invalidHandlerName) {
                    invalidHandlerName.printStackTrace();
                    continue;
                }

                try {
                    String level = manager.getProperty(handlerName + ".level");
                    if (level != null) {
                        handler.setLevel(Level.parse(level));
                    }
                } catch (Exception invalidLevel) {
                    invalidLevel.printStackTrace();
                }

                handlers.add(handler);
            }
        }

        updateDalvikLogHandler();
    }

    /**
     * Gets all the handlers associated with this logger.
     *
     * @return an array of all the handlers associated with this logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.328 -0500", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "F7A31CC804749BB05D259E4FAECE2289")
    
public Handler[] getHandlers() {
        return handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    /**
     * Removes a handler from this logger. If the specified handler does not
     * exist then this method has no effect.
     *
     * @param handler
     *            the handler to be removed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.331 -0500", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "6ADB27F1DD86DDE7D5CB770B0C34E70A")
    
public void removeHandler(Handler handler) {
        // Anonymous loggers can always remove handlers
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        if (handler == null) {
            return;
        }
        this.handlers.remove(handler);
        updateDalvikLogHandler();
    }

    /**
     * Gets the filter used by this logger.
     *
     * @return the filter used by this logger, may be {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.333 -0500", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "CD9F61EC2D214FA63221AF047D239731")
    
public Filter getFilter() {
        return this.filter;
    }

    /**
     * Sets the filter used by this logger.
     *
     * @param newFilter
     *            the filter to set, may be {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.335 -0500", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "BC89FE02322F6D234E8AD80524A282BB")
    
public void setFilter(Filter newFilter) {
        // Anonymous loggers can always set the filter
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        filter = newFilter;
    }

    /**
     * Gets the logging level of this logger. A {@code null} level indicates
     * that this logger inherits its parent's level.
     *
     * @return the logging level of this logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.337 -0500", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "552FC699EA15320EF56F63B06C2CACBB")
    
public Level getLevel() {
        return levelObjVal;
    }

    /**
     * Sets the logging level for this logger. A {@code null} level indicates
     * that this logger will inherit its parent's level.
     *
     * @param newLevel
     *            the logging level to set.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.340 -0500", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "BB800794C64A092D7968A0D67731F40E")
    
public void setLevel(Level newLevel) {
        // Anonymous loggers can always set the level
        LogManager logManager = LogManager.getLogManager();
        if (this.isNamed) {
            logManager.checkAccess();
        }
        logManager.setLevelRecursively(this, newLevel);
    }

    /**
     * Gets the flag which indicates whether to use the handlers of this
     * logger's parent to publish incoming log records, potentially recursively
     * up the namespace.
     *
     * @return {@code true} if set to use parent's handlers, {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.342 -0500", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "C561E0E1E246A77F3490EECF473989B9")
    
public boolean getUseParentHandlers() {
        return this.notifyParentHandlers;
    }

    /**
     * Sets the flag which indicates whether to use the handlers of this
     * logger's parent, potentially recursively up the namespace.
     *
     * @param notifyParentHandlers
     *            the new flag indicating whether to use the parent's handlers.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.345 -0500", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "6537E83E5085CE8C15F816879765EC56")
    
public void setUseParentHandlers(boolean notifyParentHandlers) {
        // Anonymous loggers can always set the useParentHandlers flag
        if (this.isNamed) {
            LogManager.getLogManager().checkAccess();
        }
        this.notifyParentHandlers = notifyParentHandlers;
        updateDalvikLogHandler();
    }

    /**
     * Gets the nearest parent of this logger in the namespace, a {@code null}
     * value will be returned if called on the root logger.
     *
     * @return the parent of this logger in the namespace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.347 -0500", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "4536912723E5EC23E0F45E7EFCBD7C1F")
    
public Logger getParent() {
        return parent;
    }

    /**
     * Sets the parent of this logger in the namespace. This method should be
     * used by the {@code LogManager} object only.
     *
     * @param parent
     *            the parent logger to set.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.349 -0500", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "8386C5C2C579667FB5FC433143DD6487")
    
public void setParent(Logger parent) {
        if (parent == null) {
            throw new NullPointerException("parent == null");
        }

        // even anonymous loggers are checked
        LogManager logManager = LogManager.getLogManager();
        logManager.checkAccess();
        logManager.setParent(this, parent);
    }

    /**
     * Gets the name of this logger, {@code null} for anonymous loggers.
     *
     * @return the name of this logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.351 -0500", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "10AFD575EA26BE807F18801FAC02C531")
    
public String getName() {
        return this.name;
    }

    /**
     * Gets the loaded resource bundle used by this logger to localize logging
     * messages. If the value is {@code null}, the parent's resource bundle will be
     * inherited.
     *
     * @return the loaded resource bundle used by this logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.354 -0500", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "A5A8685F8C95A7C086DCDBE13C1DFA7A")
    
public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    /**
     * Gets the name of the loaded resource bundle used by this logger to
     * localize logging messages. If the value is {@code null}, the parent's resource
     * bundle name will be inherited.
     *
     * @return the name of the loaded resource bundle used by this logger.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.356 -0500", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "795ECC4106B798264DC061D44D617BDB")
    
public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    /**
     * This method is for compatibility. Tests written to the reference
     * implementation API imply that the isLoggable() method is not called
     * directly. This behavior is important because subclass may override
     * isLoggable() method, so that affect the result of log methods.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.358 -0500", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "B28FC58B263318953D060DBEAA11191B")
    
private boolean internalIsLoggable(Level l) {
        int effectiveLevel = levelIntVal;
        if (effectiveLevel == Level.OFF.intValue()) {
            // always return false if the effective level is off
            return false;
        }
        return l.intValue() >= effectiveLevel;
    }

    /**
     * Determines whether this logger will actually log messages of the
     * specified level. The effective level used to do the determination may be
     * inherited from its parent. The default level is {@code Level.INFO}.
     *
     * @param l
     *            the level to check.
     * @return {@code true} if this logger will actually log this level,
     *         otherwise {@code false}.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.361 -0500", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "8F13C7ACEBB1838E2FA30B8D5C4BDCE9")
    
public boolean isLoggable(Level l) {
        return internalIsLoggable(l);
    }

    /**
     * Sets the resource bundle and its name for a supplied LogRecord object.
     * This method first tries to use this logger's resource bundle if any,
     * otherwise try to inherit from this logger's parent, recursively up the
     * namespace.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.363 -0500", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "A32DA0C53A26C95DE7CEC49D22008D47")
    
private void setResourceBundle(LogRecord record) {
        for (Logger p = this; p != null; p = p.parent) {
            String resourceBundleName = p.resourceBundleName;
            if (resourceBundleName != null) {
                record.setResourceBundle(p.resourceBundle);
                record.setResourceBundleName(resourceBundleName);
                return;
            }
        }
    }

    /**
     * Logs a message indicating that a method has been entered. A log record
     * with log level {@code Level.FINER}, log message "ENTRY", the specified
     * source class name and source method name is submitted for logging.
     *
     * @param sourceClass
     *            the calling class name.
     * @param sourceMethod
     *            the method name.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.366 -0500", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "3985CBC7C40DFFDAC5294AF74B7070D1")
    
public void entering(String sourceClass, String sourceMethod) {
        if (!internalIsLoggable(Level.FINER)) {
            return;
        }

        LogRecord record = new LogRecord(Level.FINER, "ENTRY");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message indicating that a method has been entered. A log record
     * with log level {@code Level.FINER}, log message "ENTRY", the specified
     * source class name, source method name and one parameter is submitted for
     * logging.
     *
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param param
     *            the parameter for the method call.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.369 -0500", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "230E238B6806043AEA579C818824D14D")
    
public void entering(String sourceClass, String sourceMethod, Object param) {
        if (!internalIsLoggable(Level.FINER)) {
            return;
        }

        LogRecord record = new LogRecord(Level.FINER, "ENTRY" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message indicating that a method has been entered. A log record
     * with log level {@code Level.FINER}, log message "ENTRY", the specified
     * source class name, source method name and array of parameters is
     * submitted for logging.
     *
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param params
     *            an array of parameters for the method call.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.372 -0500", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "09D8B46C577EDF17713E9E30901DDD39")
    
public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        if (!internalIsLoggable(Level.FINER)) {
            return;
        }

        String msg = "ENTRY";
        if (params != null) {
            StringBuilder msgBuffer = new StringBuilder("ENTRY");
            for (int i = 0; i < params.length; i++) {
                msgBuffer.append(" {").append(i).append("}");
            }
            msg = msgBuffer.toString();
        }
        LogRecord record = new LogRecord(Level.FINER, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message indicating that a method is exited. A log record with log
     * level {@code Level.FINER}, log message "RETURN", the specified source
     * class name and source method name is submitted for logging.
     *
     * @param sourceClass
     *            the calling class name.
     * @param sourceMethod
     *            the method name.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.374 -0500", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "88385CA23F6D801621F62E53492C81FA")
    
public void exiting(String sourceClass, String sourceMethod) {
        if (!internalIsLoggable(Level.FINER)) {
            return;
        }

        LogRecord record = new LogRecord(Level.FINER, "RETURN");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message indicating that a method is exited. A log record with log
     * level {@code Level.FINER}, log message "RETURN", the specified source
     * class name, source method name and return value is submitted for logging.
     *
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param result
     *            the return value of the method call.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.377 -0500", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "9264B9C00CF70FB8F04CA28672DB2681")
    
public void exiting(String sourceClass, String sourceMethod, Object result) {
        if (!internalIsLoggable(Level.FINER)) {
            return;
        }

        LogRecord record = new LogRecord(Level.FINER, "RETURN" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { result });
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message indicating that an exception is thrown. A log record with
     * log level {@code Level.FINER}, log message "THROW", the specified source
     * class name, source method name and the {@code Throwable} object is
     * submitted for logging.
     *
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param thrown
     *            the {@code Throwable} object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.379 -0500", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "1AD8BCFD295988957FF657AD04D0851C")
    
public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        if (!internalIsLoggable(Level.FINER)) {
            return;
        }

        LogRecord record = new LogRecord(Level.FINER, "THROW");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of level {@code Level.SEVERE}; the message is transmitted
     * to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.382 -0500", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "7576FD4BCC2BAD5942C013686FA59187")
    
public void severe(String msg) {
        log(Level.SEVERE, msg);
    }

    /**
     * Logs a message of level {@code Level.WARNING}; the message is
     * transmitted to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.384 -0500", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "95A46BB0521C23AE9351F9074AC2996D")
    
public void warning(String msg) {
        log(Level.WARNING, msg);
    }

    /**
     * Logs a message of level {@code Level.INFO}; the message is transmitted
     * to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.386 -0500", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "6BCA1CC837AF57F6E0DB13ECBDB19DD1")
    
public void info(String msg) {
        log(Level.INFO, msg);
    }

    /**
     * Logs a message of level {@code Level.CONFIG}; the message is transmitted
     * to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.389 -0500", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "BF0757F6545338EAAAEE34A7F40F78B6")
    
public void config(String msg) {
        log(Level.CONFIG, msg);
    }

    /**
     * Logs a message of level {@code Level.FINE}; the message is transmitted
     * to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.392 -0500", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "A9A1537EEBF808682B54FD1DEAED5C76")
    
public void fine(String msg) {
        log(Level.FINE, msg);
    }

    /**
     * Logs a message of level {@code Level.FINER}; the message is transmitted
     * to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.394 -0500", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "92FC9E0050C8AC00FBEF9DA01E79CB54")
    
public void finer(String msg) {
        log(Level.FINER, msg);
    }

    /**
     * Logs a message of level {@code Level.FINEST}; the message is transmitted
     * to all subscribed handlers.
     *
     * @param msg
     *            the message to log.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.396 -0500", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "5EE40D82D8FF8B2BF2D6483FBC921F70")
    
public void finest(String msg) {
        log(Level.FINEST, msg);
    }

    /**
     * Logs a message of the specified level. The message is transmitted to all
     * subscribed handlers.
     *
     * @param logLevel
     *            the level of the specified message.
     * @param msg
     *            the message to log.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.398 -0500", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "07F34EE4496765EAD403180F4AE8BD23")
    
public void log(Level logLevel, String msg) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
    }

    /**
     * Logs a message of the specified level with the supplied parameter. The
     * message is then transmitted to all subscribed handlers.
     *
     * @param logLevel
     *            the level of the given message.
     * @param msg
     *            the message to log.
     * @param param
     *            the parameter associated with the event that is logged.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.400 -0500", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "1E4E1EF5EF8DFF2DEE554DF5C1CB64B6")
    
public void log(Level logLevel, String msg, Object param) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of the specified level with the supplied parameter array.
     * The message is then transmitted to all subscribed handlers.
     *
     * @param logLevel
     *            the level of the given message
     * @param msg
     *            the message to log.
     * @param params
     *            the parameter array associated with the event that is logged.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.403 -0500", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "FB5F5EF61221C4C9234FA7D9CD6A9D99")
    
public void log(Level logLevel, String msg, Object[] params) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of the specified level with the supplied {@code Throwable}
     * object. The message is then transmitted to all subscribed handlers.
     *
     * @param logLevel
     *            the level of the given message.
     * @param msg
     *            the message to log.
     * @param thrown
     *            the {@code Throwable} object associated with the event that is
     *            logged.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.406 -0500", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "62A0660D3E2EE0B3CF359C31CD341872")
    
public void log(Level logLevel, String msg, Throwable thrown) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a given log record. Only records with a logging level that is equal
     * or greater than this logger's level will be submitted to this logger's
     * handlers for logging. If {@code getUseParentHandlers()} returns {@code
     * true}, the log record will also be submitted to the handlers of this
     * logger's parent, potentially recursively up the namespace.
     * <p>
     * Since all other log methods call this method to actually perform the
     * logging action, subclasses of this class can override this method to
     * catch all logging activities.
     * </p>
     *
     * @param record
     *            the log record to be logged.
     */
    @DSSink({DSSinkKind.LOG})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.409 -0500", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "F22B02776DB70F1C85585159D2F9449E")
    
public void log(LogRecord record) {
        if (!internalIsLoggable(record.getLevel())) {
            return;
        }

        // apply the filter if any
        Filter f = filter;
        if (f != null && !f.isLoggable(record)) {
            return;
        }

        /*
         * call the handlers of this logger, throw any exception that occurs
         */
        Handler[] allHandlers = getHandlers();
        for (Handler element : allHandlers) {
            element.publish(record);
        }
        // call the parent's handlers if set useParentHandlers
        Logger temp = this;
        Logger theParent = temp.parent;
        while (theParent != null && temp.getUseParentHandlers()) {
            Handler[] ha = theParent.getHandlers();
            for (Handler element : ha) {
                element.publish(record);
            }
            temp = theParent;
            theParent = temp.parent;
        }
    }

    /**
     * Logs a message of the given level with the specified source class name
     * and source method name.
     *
     * @param logLevel
     *            the level of the given message.
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param msg
     *            the message to be logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.411 -0500", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "B6A5DB70FCF05F1392F8A6D133E6F6D8")
    
public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name,
     * source method name and parameter.
     *
     * @param logLevel
     *            the level of the given message
     * @param sourceClass
     *            the source class name
     * @param sourceMethod
     *            the source method name
     * @param msg
     *            the message to be logged
     * @param param
     *            the parameter associated with the event that is logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.414 -0500", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "C5AAECEF0E5071D0AE6573D79D97CE47")
    
public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name,
     * source method name and parameter array.
     *
     * @param logLevel
     *            the level of the given message.
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param msg
     *            the message to be logged.
     * @param params
     *            the parameter array associated with the event that is logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.416 -0500", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "D85AF66DDD5CE2E826A3759035247BDC")
    
public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name,
     * source method name and {@code Throwable} object.
     *
     * @param logLevel
     *            the level of the given message.
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param msg
     *            the message to be logged.
     * @param thrown
     *            the {@code Throwable} object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.419 -0500", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "1B556F0EE6061564DFA0E4972343019C")
    
public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name
     * and source method name, using the given resource bundle to localize the
     * message. If {@code bundleName} is null, the empty string or not valid then
     * the message is not localized.
     *
     * @param logLevel
     *            the level of the given message.
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param bundleName
     *            the name of the resource bundle used to localize the message.
     * @param msg
     *            the message to be logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.421 -0500", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "02E49C48ACC3F6C8FBDD6B653F87A21C")
    
public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        if (bundleName != null) {
            try {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } catch (MissingResourceException e) {
                // ignore
            }
            record.setResourceBundleName(bundleName);
        }
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name,
     * source method name and parameter, using the given resource bundle to
     * localize the message. If {@code bundleName} is null, the empty string
     * or not valid then the message is not localized.
     *
     * @param logLevel
     *            the level of the given message.
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param bundleName
     *            the name of the resource bundle used to localize the message.
     * @param msg
     *            the message to be logged.
     * @param param
     *            the parameter associated with the event that is logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.424 -0500", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "A99EAE3F22A0F14397A3EB34CFBB6907")
    
public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object param) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        if (bundleName != null) {
            try {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } catch (MissingResourceException e) {
                // ignore
            }
            record.setResourceBundleName(bundleName);
        }
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name,
     * source method name and parameter array, using the given resource bundle
     * to localize the message. If {@code bundleName} is null, the empty string
     * or not valid then the message is not localized.
     *
     * @param logLevel
     *            the level of the given message.
     * @param sourceClass
     *            the source class name.
     * @param sourceMethod
     *            the source method name.
     * @param bundleName
     *            the name of the resource bundle used to localize the message.
     * @param msg
     *            the message to be logged.
     * @param params
     *            the parameter array associated with the event that is logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.427 -0500", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "182B83596EB418B365BFF36B3CFB3A70")
    
public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object[] params) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        if (bundleName != null) {
            try {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } catch (MissingResourceException e) {
                // ignore
            }
            record.setResourceBundleName(bundleName);
        }
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        log(record);
    }

    /**
     * Logs a message of the given level with the specified source class name,
     * source method name and {@code Throwable} object, using the given resource
     * bundle to localize the message. If {@code bundleName} is null, the empty
     * string or not valid then the message is not localized.
     *
     * @param logLevel
     *            the level of the given message
     * @param sourceClass
     *            the source class name
     * @param sourceMethod
     *            the source method name
     * @param bundleName
     *            the name of the resource bundle used to localize the message.
     * @param msg
     *            the message to be logged.
     * @param thrown
     *            the {@code Throwable} object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.430 -0500", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "F2E2A80806A967B1C318FAEE7A92A773")
    
public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Throwable thrown) {
        if (!internalIsLoggable(logLevel)) {
            return;
        }

        LogRecord record = new LogRecord(logLevel, msg);
        if (bundleName != null) {
            try {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } catch (MissingResourceException e) {
                // ignore
            }
            record.setResourceBundleName(bundleName);
        }
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        log(record);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.432 -0500", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "D14DBD797D15B100512BFD083DBB1EBD")
    
void reset() {
        levelObjVal = null;
        levelIntVal = Level.INFO.intValue();

        for (Handler handler : handlers) {
            try {
                if (handlers.remove(handler)) {
                    handler.close();
                }
            } catch (Exception ignored) {
            }
        }

        updateDalvikLogHandler();
    }
}

