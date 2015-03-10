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
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 



/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.logging.impl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;

/**
 * <p>Simple implementation of Log that sends all enabled log messages,
 * for all defined loggers, to System.err.  The following system properties
 * are supported to configure the behavior of this logger:</p>
 * <ul>
 * <li><code>org.apache.commons.logging.simplelog.defaultlog</code> -
 *     Default logging detail level for all instances of SimpleLog.
 *     Must be one of ("trace", "debug", "info", "warn", "error", or "fatal").
 *     If not specified, defaults to "info". </li>
 * <li><code>org.apache.commons.logging.simplelog.log.xxxxx</code> -
 *     Logging detail level for a SimpleLog instance named "xxxxx".
 *     Must be one of ("trace", "debug", "info", "warn", "error", or "fatal").
 *     If not specified, the default logging detail level is used.</li>
 * <li><code>org.apache.commons.logging.simplelog.showlogname</code> -
 *     Set to <code>true</code> if you want the Log instance name to be
 *     included in output messages. Defaults to <code>false</code>.</li>
 * <li><code>org.apache.commons.logging.simplelog.showShortLogname</code> -
 *     Set to <code>true</code> if you want the last component of the name to be
 *     included in output messages. Defaults to <code>true</code>.</li>
 * <li><code>org.apache.commons.logging.simplelog.showdatetime</code> -
 *     Set to <code>true</code> if you want the current date and time
 *     to be included in output messages. Default is <code>false</code>.</li>
 * <li><code>org.apache.commons.logging.simplelog.dateTimeFormat</code> -
 *     The date and time format to be used in the output messages.
 *     The pattern describing the date and time format is the same that is
 *     used in <code>java.text.SimpleDateFormat</code>. If the format is not
 *     specified or is invalid, the default format is used.
 *     The default format is <code>yyyy/MM/dd HH:mm:ss:SSS zzz</code>.</li>
 * </ul>
 *
 * <p>In addition to looking for system properties with the names specified
 * above, this implementation also checks for a class loader resource named
 * <code>"simplelog.properties"</code>, and includes any matching definitions
 * from this resource (if it exists).</p>
 *
 * @author <a href="mailto:sanders@apache.org">Scott Sanders</a>
 * @author Rod Waldhoff
 * @author Robert Burrell Donkin
 *
 * @version $Id: SimpleLog.java 399221 2006-05-03 09:20:24Z dennisl $
 */
public class SimpleLog implements Log, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.992 -0400", hash_original_field = "D625C92444AA1FA2327892EA0C2ACA73", hash_generated_field = "8C77B8FC7BF9A21E4E1A794270735A3A")


    /** All system properties used by <code>SimpleLog</code> start with this */
    static protected final String systemPrefix =
        "org.apache.commons.logging.simplelog.";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.993 -0400", hash_original_field = "CD41B0A8403C3692299563BED255A06F", hash_generated_field = "F1B504C8222D8013F465E4DE7754E2BA")

    static protected final Properties simpleLogProps = new Properties();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.993 -0400", hash_original_field = "28B6BDFD26D9FADE38F874E711FB9F5A", hash_generated_field = "9250FBCB68BB6D0BCE548F10544060D1")

    static protected final String DEFAULT_DATE_TIME_FORMAT =
        "yyyy/MM/dd HH:mm:ss:SSS zzz";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.994 -0400", hash_original_field = "EFE3BC333F2FBFE3C6280C7AC3F3F4F2", hash_generated_field = "5D97DCFAA9AACD201B008A517A831D64")

    static protected boolean showLogName = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.994 -0400", hash_original_field = "B86495FF2666F0384F5650798B1C74E4", hash_generated_field = "5230010FFB995C0281D888E2183D26A7")

    static protected boolean showShortName = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.995 -0400", hash_original_field = "9084CF41B05CE2E4BAE38FC942209289", hash_generated_field = "48DEDADFBA13C9E91B2AFE65BF84E39C")

    static protected boolean showDateTime = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.995 -0400", hash_original_field = "67D2123954B312642F49811C50FCC81A", hash_generated_field = "6025FF4314ECA11DE0DA103EF8E68B46")

    static protected String dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.996 -0400", hash_original_field = "A4C3FC87A58E4CF52292A08A4947EB84", hash_generated_field = "E1F11A1E0021F6478FFFC520785E8103")

    static protected DateFormat dateFormatter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.996 -0400", hash_original_field = "DA44DB9860EB2002DD0DE6EFDED59E67", hash_generated_field = "5571B32BD5BDCF2081C6939E10FF9098")



    /** "Trace" level logging. */
    public static final int LOG_LEVEL_TRACE  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.997 -0400", hash_original_field = "CA7F68D6A1CAC75BADF8FFA55913F152", hash_generated_field = "3453C4879A4BB342788D4C3312159BC4")

    public static final int LOG_LEVEL_DEBUG  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.997 -0400", hash_original_field = "AE35B7D89244532D1465DDBD65DA008D", hash_generated_field = "0FC0D27D3285B959D8CF2ED4A00055D0")

    public static final int LOG_LEVEL_INFO   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.998 -0400", hash_original_field = "88C3765D8C87CBC4F6AA2C6BA627CE66", hash_generated_field = "9B7A0565F4F73409823002BD680ACEB5")

    public static final int LOG_LEVEL_WARN   = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.998 -0400", hash_original_field = "4E7E3609D129CF30139144788F94B6FA", hash_generated_field = "BE99526A832A7F721AB1E4FA840C30D0")

    public static final int LOG_LEVEL_ERROR  = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.999 -0400", hash_original_field = "B337589C31FB74368CBF9794BDC1F470", hash_generated_field = "8F6319C00D9EF8856D4B8A8481B0833B")

    public static final int LOG_LEVEL_FATAL  = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.999 -0400", hash_original_field = "266D80858924C11E8EBF394DBC547B96", hash_generated_field = "72A08FDCD0C2123212BCC8F992C1F781")

    public static final int LOG_LEVEL_ALL    = (LOG_LEVEL_TRACE - 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.000 -0400", hash_original_field = "B7479D9D0FCBFF4F3FFEAA263AF06C86", hash_generated_field = "E1FFB7CA8F4A7F4A956001F239DC727F")

    public static final int LOG_LEVEL_OFF    = (LOG_LEVEL_FATAL + 1);

    // ------------------------------------------------------------ Initializer

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.000 -0400", hash_original_method = "B5DDCA082E4E497B6705E8AB921A623F", hash_generated_method = "16AF123170AA6FC321499CC0E441500E")
    
private static String getStringProperty(String name) {
        String prop = null;
	try {
	    prop = System.getProperty(name);
	} catch (SecurityException e) {
	    ; // Ignore
	}
        return (prop == null) ? simpleLogProps.getProperty(name) : prop;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.001 -0400", hash_original_method = "1F891A8D22680B9BBF732E15FF09607B", hash_generated_method = "56BDECE9140C909522CE87C2D8D64366")
    
private static String getStringProperty(String name, String dephault) {
        String prop = getStringProperty(name);
        return (prop == null) ? dephault : prop;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.001 -0400", hash_original_method = "8792AECA1511D7CA91A6DD360EBF01F0", hash_generated_method = "23F3992CA5B51F5A472D54B15989C2B7")
    
private static boolean getBooleanProperty(String name, boolean dephault) {
        String prop = getStringProperty(name);
        return (prop == null) ? dephault : "true".equalsIgnoreCase(prop);
    }

    // Initialize class attributes.
    // Load properties file, if found.
    // Override with system properties.
    static {
        // Add props from the resource simplelog.properties
        InputStream in = getResourceAsStream("simplelog.properties");
        if(null != in) {
            try {
                simpleLogProps.load(in);
                in.close();
            } catch(java.io.IOException e) {
                // ignored
            }
        }

        showLogName = getBooleanProperty( systemPrefix + "showlogname", showLogName);
        showShortName = getBooleanProperty( systemPrefix + "showShortLogname", showShortName);
        showDateTime = getBooleanProperty( systemPrefix + "showdatetime", showDateTime);

        if(showDateTime) {
            dateTimeFormat = getStringProperty(systemPrefix + "dateTimeFormat",
                                               dateTimeFormat);
            try {
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            } catch(IllegalArgumentException e) {
                // If the format pattern is invalid - use the default format
                dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            }
        }
    }


    /**
     * Return the thread context class loader if available.
     * Otherwise return null.
     *
     * The thread context class loader is available for JDK 1.2
     * or later, if certain security conditions are met.
     *
     * @exception LogConfigurationException if a suitable class loader
     * cannot be identified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.019 -0400", hash_original_method = "E55C98F6A5288120CFB7A48B78393108", hash_generated_method = "8BD2AB172C58E92FD3915746C42813F8")
    
private static ClassLoader getContextClassLoader()
    {
        ClassLoader classLoader = null;

        if (classLoader == null) {
            try {
                // Are we running on a JDK 1.2 or later system?
                Method method = Thread.class.getMethod("getContextClassLoader",
                        (Class[]) null);

                // Get the thread context class loader (if there is one)
                try {
                    classLoader = (ClassLoader)method.invoke(Thread.currentThread(), 
                            (Object[]) null);

                } catch (IllegalAccessException e) {
                    ;  // ignore
                } catch (InvocationTargetException e) {
                    /**
                     * InvocationTargetException is thrown by 'invoke' when
                     * the method being invoked (getContextClassLoader) throws
                     * an exception.
                     *
                     * getContextClassLoader() throws SecurityException when
                     * the context class loader isn't an ancestor of the
                     * calling class's class loader, or if security
                     * permissions are restricted.
                     *
                     * In the first case (not related), we want to ignore and
                     * keep going.  We cannot help but also ignore the second
                     * with the logic below, but other calls elsewhere (to
                     * obtain a class loader) will trigger this exception where
                     * we can make a distinction.
                     */
                    if (e.getTargetException() instanceof SecurityException) {
                        ;  // ignore
                    } else {
                        // Capture 'e.getTargetException()' exception for details
                        // alternate: log 'e.getTargetException()', and pass back 'e'.
                        throw new LogConfigurationException
                            ("Unexpected InvocationTargetException", e.getTargetException());
                    }
                }
            } catch (NoSuchMethodException e) {
                // Assume we are running on JDK 1.1
                ;  // ignore
            }
        }

        if (classLoader == null) {
            classLoader = SimpleLog.class.getClassLoader();
        }

        // Return the selected class loader
        return classLoader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.020 -0400", hash_original_method = "9CD8F2C6B769DB21F48AD710A5EFD2D9", hash_generated_method = "655E7A2CCFEA6B0D33BC461E994568E7")
    
private static InputStream getResourceAsStream(final String name)
    {
        return (InputStream)AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    ClassLoader threadCL = getContextClassLoader();

                    if (threadCL != null) {
                        return threadCL.getResourceAsStream(name);
                    } else {
                        return ClassLoader.getSystemResourceAsStream(name);
                    }
                }
            });
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.002 -0400", hash_original_field = "D406A7A8A8F1E681EA380882E40D197D", hash_generated_field = "AC75728CE176046E2CD5BD6C9FBF8333")


    /** The name of this simple log instance */
    protected String logName = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.003 -0400", hash_original_field = "6F63771DB9CA7AA62F514DFEA052E782", hash_generated_field = "ECC648F79FD1443545AC8D60D89D5220")

    protected int currentLogLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.003 -0400", hash_original_field = "BD06A4A779052546AECCEF93015261DF", hash_generated_field = "2ED3AC56C42D9A88BA7C4669F6146513")

    private String shortLogName = null;


    // ------------------------------------------------------------ Constructor

    /**
     * Construct a simple log with given name.
     *
     * @param name log name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.004 -0400", hash_original_method = "0FF0D3CF9935BD4D3758D93CDD8A5FD4", hash_generated_method = "43893C2D138F0664E8EE85BF7680233A")
    
public SimpleLog(String name) {

        logName = name;

        // Set initial log level
        // Used to be: set default log level to ERROR
        // IMHO it should be lower, but at least info ( costin ).
        setLevel(SimpleLog.LOG_LEVEL_INFO);

        // Set log level from properties
        String lvl = getStringProperty(systemPrefix + "log." + logName);
        int i = String.valueOf(name).lastIndexOf(".");
        while(null == lvl && i > -1) {
            name = name.substring(0,i);
            lvl = getStringProperty(systemPrefix + "log." + name);
            i = String.valueOf(name).lastIndexOf(".");
        }

        if(null == lvl) {
            lvl =  getStringProperty(systemPrefix + "defaultlog");
        }

        if("all".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_ALL);
        } else if("trace".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_TRACE);
        } else if("debug".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_DEBUG);
        } else if("info".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_INFO);
        } else if("warn".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_WARN);
        } else if("error".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_ERROR);
        } else if("fatal".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_FATAL);
        } else if("off".equalsIgnoreCase(lvl)) {
            setLevel(SimpleLog.LOG_LEVEL_OFF);
        }

    }


    // -------------------------------------------------------- Properties

    /**
     * <p> Set logging level. </p>
     *
     * @param currentLogLevel new logging level
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.005 -0400", hash_original_method = "B4AA2F12AB1B3543928B90EAD79C2C0F", hash_generated_method = "E0DB7D9A3584B25C9C9DEF9C371B27EC")
    
public void setLevel(int currentLogLevel) {

        this.currentLogLevel = currentLogLevel;

    }


    /**
     * <p> Get logging level. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.005 -0400", hash_original_method = "D6A3FEDC9D9C339E2CCE5276BEF1046C", hash_generated_method = "36B366DF43EDB6A6B85B3ACC911C5DA1")
    
public int getLevel() {

        return currentLogLevel;
    }


    // -------------------------------------------------------- Logging Methods


    /**
     * <p> Do the actual logging.
     * This method assembles the message
     * and then calls <code>write()</code> to cause it to be written.</p>
     *
     * @param type One of the LOG_LEVEL_XXX constants defining the log level
     * @param message The message itself (typically a String)
     * @param t The exception whose stack trace should be logged
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.007 -0400", hash_original_method = "4E150736B305580D7D558C0BBC13A278", hash_generated_method = "9F613AABC550C993F40C8AA15B39C7FF")
    
protected void log(int type, Object message, Throwable t) {
        // Use a string buffer for better performance
        StringBuffer buf = new StringBuffer();

        // Append date-time if so configured
        if(showDateTime) {
            buf.append(dateFormatter.format(new Date()));
            buf.append(" ");
        }

        // Append a readable representation of the log level
        switch(type) {
            case SimpleLog.LOG_LEVEL_TRACE: buf.append("[TRACE] "); break;
            case SimpleLog.LOG_LEVEL_DEBUG: buf.append("[DEBUG] "); break;
            case SimpleLog.LOG_LEVEL_INFO:  buf.append("[INFO] ");  break;
            case SimpleLog.LOG_LEVEL_WARN:  buf.append("[WARN] ");  break;
            case SimpleLog.LOG_LEVEL_ERROR: buf.append("[ERROR] "); break;
            case SimpleLog.LOG_LEVEL_FATAL: buf.append("[FATAL] "); break;
        }

        // Append the name of the log instance if so configured
 	if( showShortName) {
            if( shortLogName==null ) {
                // Cut all but the last component of the name for both styles
                shortLogName = logName.substring(logName.lastIndexOf(".") + 1);
                shortLogName =
                    shortLogName.substring(shortLogName.lastIndexOf("/") + 1);
            }
            buf.append(String.valueOf(shortLogName)).append(" - ");
        } else if(showLogName) {
            buf.append(String.valueOf(logName)).append(" - ");
        }

        // Append the message
        buf.append(String.valueOf(message));

        // Append stack trace if not null
        if(t != null) {
            buf.append(" <");
            buf.append(t.toString());
            buf.append(">");

            java.io.StringWriter sw= new java.io.StringWriter(1024);
            java.io.PrintWriter pw= new java.io.PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            buf.append(sw.toString());
        }

        // Print to the appropriate destination
        write(buf);

    }


    /**
     * <p>Write the content of the message accumulated in the specified
     * <code>StringBuffer</code> to the appropriate output destination.  The
     * default implementation writes to <code>System.err</code>.</p>
     *
     * @param buffer A <code>StringBuffer</code> containing the accumulated
     *  text to be logged
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.007 -0400", hash_original_method = "293291CBEB865291500E80151FFE418B", hash_generated_method = "6A5A1A6CBB12E585FC918B50A74AC4FA")
    
protected void write(StringBuffer buffer) {

        System.err.println(buffer.toString());

    }


    /**
     * Is the given log level currently enabled?
     *
     * @param logLevel is this level enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.008 -0400", hash_original_method = "4849D77EF78239B1BCEEDDFC9678F971", hash_generated_method = "4F227D182C30D3C4F06B0AA22F6BB3B6")
    
protected boolean isLevelEnabled(int logLevel) {
        // log level are numerically ordered so can use simple numeric
        // comparison
        return (logLevel >= currentLogLevel);
    }


    // -------------------------------------------------------- Log Implementation


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_DEBUG</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#debug(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.008 -0400", hash_original_method = "84EBDF4A6DAAA2DC457105BE949DDD50", hash_generated_method = "2325DB5571F48AF038D1FF76201F97FE")
    
public final void debug(Object message) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_DEBUG)) {
            log(SimpleLog.LOG_LEVEL_DEBUG, message, null);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_DEBUG</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#debug(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.009 -0400", hash_original_method = "5F26663935B789F5D9F1572A43B05D98", hash_generated_method = "0A8B10A755FBED95A35B2D069F7FFDE0")
    
public final void debug(Object message, Throwable t) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_DEBUG)) {
            log(SimpleLog.LOG_LEVEL_DEBUG, message, t);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_TRACE</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#trace(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.010 -0400", hash_original_method = "3C27D9617C55070B16FEF12103084D3B", hash_generated_method = "C4D486223071A049DEBDC7E656997D4A")
    
public final void trace(Object message) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE)) {
            log(SimpleLog.LOG_LEVEL_TRACE, message, null);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_TRACE</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#trace(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.010 -0400", hash_original_method = "3590979F2C43DA1B63D40973316C3758", hash_generated_method = "AE9345C0EED04FE3E81F7B7E760669CD")
    
public final void trace(Object message, Throwable t) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE)) {
            log(SimpleLog.LOG_LEVEL_TRACE, message, t);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_INFO</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#info(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.011 -0400", hash_original_method = "801DC567BE87B368F7C34CBAA5165FFF", hash_generated_method = "27DC6B0FF45E4C1DBA9EF960A9911185")
    
public final void info(Object message) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_INFO)) {
            log(SimpleLog.LOG_LEVEL_INFO,message,null);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_INFO</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#info(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.011 -0400", hash_original_method = "5780A6D38C00EE785E1226D34A2F2A1C", hash_generated_method = "C62CD7D9232FB3B13FFF56C16B43448B")
    
public final void info(Object message, Throwable t) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_INFO)) {
            log(SimpleLog.LOG_LEVEL_INFO, message, t);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_WARN</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#warn(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.012 -0400", hash_original_method = "755EBDA321A82D31400835D2D9A2791F", hash_generated_method = "A50F8EC60C8F4F1F97AB6C70C6C21F4C")
    
public final void warn(Object message) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_WARN)) {
            log(SimpleLog.LOG_LEVEL_WARN, message, null);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_WARN</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#warn(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.012 -0400", hash_original_method = "41E903B1D0BE5047F44C6158079A30F9", hash_generated_method = "16FE8F360E82F90545C4D7C4342FF530")
    
public final void warn(Object message, Throwable t) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_WARN)) {
            log(SimpleLog.LOG_LEVEL_WARN, message, t);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_ERROR</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#error(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.013 -0400", hash_original_method = "A6FF6BAA687449B5D708D91F3B130233", hash_generated_method = "2BBC16748E8C5AA7B537D446C6B17B61")
    
public final void error(Object message) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_ERROR)) {
            log(SimpleLog.LOG_LEVEL_ERROR, message, null);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_ERROR</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#error(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.013 -0400", hash_original_method = "D825D1EF81F727B98120B0E0B62D2994", hash_generated_method = "6286C8B071C5F669339F45AAC4A7D2FD")
    
public final void error(Object message, Throwable t) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_ERROR)) {
            log(SimpleLog.LOG_LEVEL_ERROR, message, t);
        }
    }


    /**
     * Log a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_FATAL</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#fatal(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.014 -0400", hash_original_method = "8FA9092EFDAC72016D6F832FCE94F2A1", hash_generated_method = "0DDAE922B1B20D822375E9CF52DB16AD")
    
public final void fatal(Object message) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_FATAL)) {
            log(SimpleLog.LOG_LEVEL_FATAL, message, null);
        }
    }


    /**
     * Logs a message with 
     * <code>org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_FATAL</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#fatal(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.015 -0400", hash_original_method = "74F780859B824BF53F43ED9E5061E287", hash_generated_method = "9BBCFFE6C41618BBFEEABC576C7B03AC")
    
public final void fatal(Object message, Throwable t) {

        if (isLevelEnabled(SimpleLog.LOG_LEVEL_FATAL)) {
            log(SimpleLog.LOG_LEVEL_FATAL, message, t);
        }
    }


    /**
     * <p> Are debug messages currently enabled? </p>
     *
     * <p> This allows expensive operations such as <code>String</code>
     * concatenation to be avoided when the message will be ignored by the
     * logger. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.015 -0400", hash_original_method = "B7BD90DC8ACEF2F646158B1D5B35155C", hash_generated_method = "80CCC5ED6B187D2080367E42AFB90486")
    
public final boolean isDebugEnabled() {

        return isLevelEnabled(SimpleLog.LOG_LEVEL_DEBUG);
    }


    /**
     * <p> Are error messages currently enabled? </p>
     *
     * <p> This allows expensive operations such as <code>String</code>
     * concatenation to be avoided when the message will be ignored by the
     * logger. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.016 -0400", hash_original_method = "7078C789E755843A9561416BB22BA5B9", hash_generated_method = "DDB7932FA33B9D61DB58E3FB65C16177")
    
public final boolean isErrorEnabled() {

        return isLevelEnabled(SimpleLog.LOG_LEVEL_ERROR);
    }


    /**
     * <p> Are fatal messages currently enabled? </p>
     *
     * <p> This allows expensive operations such as <code>String</code>
     * concatenation to be avoided when the message will be ignored by the
     * logger. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.016 -0400", hash_original_method = "43809A7AC1EC70A6E2ACF354BE745AD4", hash_generated_method = "914C96230346D24587C82BEC0F895AE4")
    
public final boolean isFatalEnabled() {

        return isLevelEnabled(SimpleLog.LOG_LEVEL_FATAL);
    }


    /**
     * <p> Are info messages currently enabled? </p>
     *
     * <p> This allows expensive operations such as <code>String</code>
     * concatenation to be avoided when the message will be ignored by the
     * logger. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.016 -0400", hash_original_method = "05F3A8B360721C62190516DE568C4E59", hash_generated_method = "35E0CF5CD1087DF45A1FE3EBC4CC70B6")
    
public final boolean isInfoEnabled() {

        return isLevelEnabled(SimpleLog.LOG_LEVEL_INFO);
    }


    /**
     * <p> Are trace messages currently enabled? </p>
     *
     * <p> This allows expensive operations such as <code>String</code>
     * concatenation to be avoided when the message will be ignored by the
     * logger. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.017 -0400", hash_original_method = "AC4BD6DAF4DA3706009A8A69E5A51552", hash_generated_method = "FB4874437424453A9BD521593DB0B054")
    
public final boolean isTraceEnabled() {

        return isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE);
    }


    /**
     * <p> Are warn messages currently enabled? </p>
     *
     * <p> This allows expensive operations such as <code>String</code>
     * concatenation to be avoided when the message will be ignored by the
     * logger. </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:48.018 -0400", hash_original_method = "7375C00FAA961592B0F1CD7B52495FD2", hash_generated_method = "362CF872E8888FAEBE4BA6B6A49DF7DB")
    
public final boolean isWarnEnabled() {

        return isLevelEnabled(SimpleLog.LOG_LEVEL_WARN);
    }
}

