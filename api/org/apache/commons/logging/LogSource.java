/*
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

package org.apache.commons.logging;


import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.lang.reflect.Constructor;
import java.util.Hashtable;

import org.apache.commons.logging.impl.NoOpLog;


/**
 * <p>Factory for creating {@link Log} instances.  Applications should call
 * the <code>makeNewLogInstance()</code> method to instantiate new instances
 * of the configured {@link Log} implementation class.</p>
 *
 * <p>By default, calling <code>getInstance()</code> will use the following
 * algorithm:</p>
 * <ul>
 * <li>If Log4J is available, return an instance of
 *     <code>org.apache.commons.logging.impl.Log4JLogger</code>.</li>
 * <li>If JDK 1.4 or later is available, return an instance of
 *     <code>org.apache.commons.logging.impl.Jdk14Logger</code>.</li>
 * <li>Otherwise, return an instance of
 *     <code>org.apache.commons.logging.impl.NoOpLog</code>.</li>
 * </ul>
 *
 * <p>You can change the default behavior in one of two ways:</p>
 * <ul>
 * <li>On the startup command line, set the system property
 *     <code>org.apache.commons.logging.log</code> to the name of the
 *     <code>org.apache.commons.logging.Log</code> implementation class
 *     you want to use.</li>
 * <li>At runtime, call <code>LogSource.setLogImplementation()</code>.</li>
 * </ul>
 *
 * @deprecated Use {@link LogFactory} instead - The default factory
 *  implementation performs exactly the same algorithm as this class did
 *
 * @author Rod Waldhoff
 * @version $Id: LogSource.java 155426 2005-02-26 13:10:49Z dirkv $
 */
public class LogSource {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.140 -0400", hash_original_field = "FDC9A5105F2D9B5A5A3257FEB48B153E", hash_generated_field = "F0D340854A30C58216CD0049FB5B5BA2")


    static protected Hashtable logs = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.141 -0400", hash_original_field = "5A4C61CCD4116E21FB010696DC574E37", hash_generated_field = "4E733A79F582F11C69C85CF24C08AD10")

    static protected boolean log4jIsAvailable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.142 -0400", hash_original_field = "A331331E8642277CC175F29683A3F4FA", hash_generated_field = "8AB9D4B8AF97A6DD7DACE309572ED291")

    static protected boolean jdk14IsAvailable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.142 -0400", hash_original_field = "C12E94093BFEA5CC2D31524AA73DD1F3", hash_generated_field = "E836E30F318A1A2F87AAF50FF54CB385")

    static protected Constructor logImplctor = null;


    // ----------------------------------------------------- Class Initializers

    static {

        // Is Log4J Available?
        try {
            if (null != Class.forName("org.apache.log4j.Logger")) {
                log4jIsAvailable = true;
            } else {
                log4jIsAvailable = false;
            }
        } catch (Throwable t) {
            log4jIsAvailable = false;
        }

        // Is JDK 1.4 Logging Available?
        try {
            if ((null != Class.forName("java.util.logging.Logger")) &&
                (null != Class.forName("org.apache.commons.logging.impl.Jdk14Logger"))) {
                jdk14IsAvailable = true;
            } else {
                jdk14IsAvailable = false;
            }
        } catch (Throwable t) {
            jdk14IsAvailable = false;
        }

        // Set the default Log implementation
        String name = null;
        try {
            name = System.getProperty("org.apache.commons.logging.log");
            if (name == null) {
                name = System.getProperty("org.apache.commons.logging.Log");
            }
        } catch (Throwable t) {
        }
        if (name != null) {
            try {
                setLogImplementation(name);
            } catch (Throwable t) {
                try {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.NoOpLog");
                } catch (Throwable u) {
                    ;
                }
            }
        } else {
            try {
                if (log4jIsAvailable) {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.Log4JLogger");
                } else if (jdk14IsAvailable) {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.Jdk14Logger");
                } else {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.NoOpLog");
                }
            } catch (Throwable t) {
                try {
                    setLogImplementation
                            ("org.apache.commons.logging.impl.NoOpLog");
                } catch (Throwable u) {
                    ;
                }
            }
        }

    }


    // ---------------------------------------------------------- Class Methods


    /**
     * Set the log implementation/log implementation factory
     * by the name of the class.  The given class
     * must implement {@link Log}, and provide a constructor that
     * takes a single {@link String} argument (containing the name
     * of the log).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.144 -0400", hash_original_method = "3C46B58362CD9D5235C56121A05B12B2", hash_generated_method = "DBC50419168E4F615AE776C9E7CCA83F")
    
static public void setLogImplementation(String classname) throws
            LinkageError, ExceptionInInitializerError,
            NoSuchMethodException, SecurityException,
            ClassNotFoundException {
        try {
            Class logclass = Class.forName(classname);
            Class[] argtypes = new Class[1];
            argtypes[0] = "".getClass();
            logImplctor = logclass.getConstructor(argtypes);
        } catch (Throwable t) {
            logImplctor = null;
        }
    }


    /**
     * Set the log implementation/log implementation factory
     * by class.  The given class must implement {@link Log},
     * and provide a constructor that takes a single {@link String}
     * argument (containing the name of the log).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.145 -0400", hash_original_method = "78E2A18536FB3D0B5BAB2F6814190D82", hash_generated_method = "4085655031641A871D52CC17CCAFA391")
    
static public void setLogImplementation(Class logclass) throws
            LinkageError, ExceptionInInitializerError,
            NoSuchMethodException, SecurityException {
        Class[] argtypes = new Class[1];
        argtypes[0] = "".getClass();
        logImplctor = logclass.getConstructor(argtypes);
    }


    /** Get a <code>Log</code> instance by class name */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.145 -0400", hash_original_method = "E0D93B37063AD78A45CD6BFECAA1084D", hash_generated_method = "25F42F5064A4F9DD10AFF4CE9F603254")
    
static public Log getInstance(String name) {
        Log log = (Log) (logs.get(name));
        if (null == log) {
            log = makeNewLogInstance(name);
            logs.put(name, log);
        }
        return log;
    }


    /** Get a <code>Log</code> instance by class */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.146 -0400", hash_original_method = "5251C02A907C79187C3FDEF976CF2AB1", hash_generated_method = "E1A83578D2408CB98312728F71D823E2")
    
static public Log getInstance(Class clazz) {
        return getInstance(clazz.getName());
    }


    /**
     * Create a new {@link Log} implementation, based
     * on the given <i>name</i>.
     * <p>
     * The specific {@link Log} implementation returned
     * is determined by the value of the
     * <tt>org.apache.commons.logging.log</tt> property.
     * The value of <tt>org.apache.commons.logging.log</tt> may be set to
     * the fully specified name of a class that implements
     * the {@link Log} interface.  This class must also
     * have a public constructor that takes a single
     * {@link String} argument (containing the <i>name</i>
     * of the {@link Log} to be constructed.
     * <p>
     * When <tt>org.apache.commons.logging.log</tt> is not set,
     * or when no corresponding class can be found,
     * this method will return a Log4JLogger
     * if the log4j Logger class is
     * available in the {@link LogSource}'s classpath, or a
     * Jdk14Logger if we are on a JDK 1.4 or later system, or
     * NoOpLog if neither of the above conditions is true.
     *
     * @param name the log name (or category)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.147 -0400", hash_original_method = "ADC6D6B667DEBCA03478BBD5AF00150E", hash_generated_method = "D3D96C7048C23C526EA208DD102E091B")
    
static public Log makeNewLogInstance(String name) {

        Log log = null;
        try {
            Object[] args = new Object[1];
            args[0] = name;
            log = (Log) (logImplctor.newInstance(args));
        } catch (Throwable t) {
            log = null;
        }
        if (null == log) {
            log = new NoOpLog(name);
        }
        return log;

    }


    /**
     * Returns a {@link String} array containing the names of
     * all logs known to me.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.147 -0400", hash_original_method = "7DC0969EDC835D35D3D4B93B871FE25B", hash_generated_method = "6FA9151792DBCDC8E528C75344F1BF56")
    
static public String[] getLogNames() {
        return (String[]) (logs.keySet().toArray(new String[logs.size()]));
    }


    // ------------------------------------------------------------ Constructor


    /** Don't allow others to create instances */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.143 -0400", hash_original_method = "12D2194E9C278BDA57991A732D339F66", hash_generated_method = "1E9BB347F752599D6C85D601AE462597")
    
private LogSource() {
    }


}
