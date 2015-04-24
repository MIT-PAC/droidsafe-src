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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;


/**
 * <p>Concrete subclass of {@link LogFactory} that implements the
 * following algorithm to dynamically select a logging implementation
 * class to instantiate a wrapper for.</p>
 * <ul>
 * <li>Use a factory configuration attribute named
 *     <code>org.apache.commons.logging.Log</code> to identify the
 *     requested implementation class.</li>
 * <li>Use the <code>org.apache.commons.logging.Log</code> system property
 *     to identify the requested implementation class.</li>
 * <li>If <em>Log4J</em> is available, return an instance of
 *     <code>org.apache.commons.logging.impl.Log4JLogger</code>.</li>
 * <li>If <em>JDK 1.4 or later</em> is available, return an instance of
 *     <code>org.apache.commons.logging.impl.Jdk14Logger</code>.</li>
 * <li>Otherwise, return an instance of
 *     <code>org.apache.commons.logging.impl.SimpleLog</code>.</li>
 * </ul>
 *
 * <p>If the selected {@link Log} implementation class has a
 * <code>setLogFactory()</code> method that accepts a {@link LogFactory}
 * parameter, this method will be called on each newly created instance
 * to identify the associated factory.  This makes factory configuration
 * attributes available to the Log instance, if it so desires.</p>
 *
 * <p>This factory will remember previously created <code>Log</code> instances
 * for the same name, and will return them on repeated requests to the
 * <code>getInstance()</code> method.</p>
 *
 * @author Rod Waldhoff
 * @author Craig R. McClanahan
 * @author Richard A. Sitze
 * @author Brian Stansberry
 * @version $Revision: 399224 $ $Date: 2006-05-03 10:25:54 +0100 (Wed, 03 May 2006) $
 */

public class LogFactoryImpl extends LogFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.376 -0400", hash_original_field = "B8799D5AE92EA887B3BCAE727E0D43BC", hash_generated_field = "310D7F99EC0B1DEEC7B88F0EC24BFB74")

    private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.376 -0400", hash_original_field = "D6D2A74C4B5FDFAFFC3EDC35C23C66DB", hash_generated_field = "0C25031872EF4DBAA70ABEB56D305BD0")

    private static final String LOGGING_IMPL_JDK14_LOGGER = "org.apache.commons.logging.impl.Jdk14Logger";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.377 -0400", hash_original_field = "CF26993CEDFAC4E83E2004B62AACFC9A", hash_generated_field = "051EE0505C87F4E67875F40E9C3B6850")

    private static final String LOGGING_IMPL_LUMBERJACK_LOGGER = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.377 -0400", hash_original_field = "EB7B4BB392A7A7FAA28D538D0ED30F2B", hash_generated_field = "42DA4F45AFAA0ABF184E2965CF6F5B8F")

    private static final String LOGGING_IMPL_SIMPLE_LOGGER = "org.apache.commons.logging.impl.SimpleLog";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.378 -0400", hash_original_field = "0AD3FAEE398D8D59F3B4A05F09893625", hash_generated_field = "A6B266E43692469F47FF5E25A559D230")


    private static final String PKG_IMPL="org.apache.commons.logging.impl.";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.378 -0400", hash_original_field = "9481A712D1AE23A13D8F12E108BF3B45", hash_generated_field = "D3AE48545451F63BE2324FC546409E10")

    private static final int PKG_LEN = PKG_IMPL.length();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.380 -0400", hash_original_field = "ADEAC350660CDBCA1D249AF0A5C8B8AF", hash_generated_field = "A57D28D979C64E17EDB5F0FF6FAE4FAC")



    /**
     * The name (<code>org.apache.commons.logging.Log</code>) of the system 
     * property identifying our {@link Log} implementation class.
     */
    public static final String LOG_PROPERTY =
        "org.apache.commons.logging.Log";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.380 -0400", hash_original_field = "07305C5105175A0AEBAA03A9B4BA7684", hash_generated_field = "4F8D9FBEA41FEA39D367B8CCBA29E633")

    protected static final String LOG_PROPERTY_OLD =
        "org.apache.commons.logging.log";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.381 -0400", hash_original_field = "8E9EFD17B3E10E413F8421F38817FBC8", hash_generated_field = "3C37EE7B98ADACA92BD82FCD067097B0")

    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = 
        "org.apache.commons.logging.Log.allowFlawedContext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.381 -0400", hash_original_field = "183D0F75C26E817AFEFC8A55AF9F3E81", hash_generated_field = "94BDBE4FC20C9C8B77DFF18D539A079E")

    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = 
        "org.apache.commons.logging.Log.allowFlawedDiscovery";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.382 -0400", hash_original_field = "61FCFC2532711A6CD78A9ABB2EAF4942", hash_generated_field = "04680AA03F1296BDF252E6CBA9F2B786")

    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = 
        "org.apache.commons.logging.Log.allowFlawedHierarchy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.382 -0400", hash_original_field = "B92234017673463B973394ABC51C1F4F", hash_generated_field = "3CAD003C672B07C53C6D544692836EB8")

    private static final String[] classesToDiscover = {
            LOGGING_IMPL_LOG4J_LOGGER,
            "org.apache.commons.logging.impl.Jdk14Logger",
            "org.apache.commons.logging.impl.Jdk13LumberjackLogger",
            "org.apache.commons.logging.impl.SimpleLog"
    };


    // ------------------------------------------------------ 
    // Static Methods
    //
    // These methods only defined as workarounds for a java 1.2 bug;
    // theoretically none of these are needed.
    // ------------------------------------------------------ 
    
    /**
     * Gets the context classloader.
     * This method is a workaround for a java 1.2 compiler bug.
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.393 -0400", hash_original_method = "D77479CF5CA7A79EF443C82F9847052F", hash_generated_method = "AA05ECCD8CF89702DEACFF8DB4737609")
    
protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        return LogFactory.getContextClassLoader();
    }

    
    /**
     * Workaround for bug in Java1.2; in theory this method is not needed.
     * See LogFactory.isDiagnosticsEnabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.393 -0400", hash_original_method = "70526F861CF001113E9F6EA89506F1D3", hash_generated_method = "C75D4E782E307A289CCD2C219ED6B1AA")
    
protected static boolean isDiagnosticsEnabled() {
        return LogFactory.isDiagnosticsEnabled();
    }

    
    /**
     * Workaround for bug in Java1.2; in theory this method is not needed.
     * See LogFactory.getClassLoader.
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.394 -0400", hash_original_method = "7CB33C65153C1648F75A49EDBC07E2E7", hash_generated_method = "F8865AD31F03343ECC850E489872144D")
    
protected static ClassLoader getClassLoader(Class clazz) {
        return LogFactory.getClassLoader(clazz);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.383 -0400", hash_original_field = "118BC7B129183BB748DD860DDBC6F2E9", hash_generated_field = "24E6979F70E40B954527B0A86759395A")


    /**
     * Determines whether logging classes should be loaded using the thread-context
     * classloader, or via the classloader that loaded this LogFactoryImpl class.
     */
    private boolean useTCCL = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.383 -0400", hash_original_field = "F9B1BC72E6214E8224C6F6C21C66489A", hash_generated_field = "8B14087A8E9A868BA314A99B5F04A797")

    private String diagnosticPrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.384 -0400", hash_original_field = "86A34F12E3DAF086040264E5286AD034", hash_generated_field = "D929D15BE997A1745C7D3901022519ED")

    protected Hashtable attributes = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.385 -0400", hash_original_field = "73F9CA01B7C6610F0665A9CFC532A97C", hash_generated_field = "272B210F82388C1CA2839BF466907BA3")

    protected Hashtable instances = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.385 -0400", hash_original_field = "9407996E87772FA6C6F65BEF3917C498", hash_generated_field = "0D14D184729BF354EBD1CAE6C5599BE6")

    private String logClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.386 -0400", hash_original_field = "0B58A9D81B796E2A4B06148C8EDF09E1", hash_generated_field = "4E3E6196F46F37B5AC82DBD87E18F265")

    protected Constructor logConstructor = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.386 -0400", hash_original_field = "878FCC08D65335E9AAAE39D5C7F56762", hash_generated_field = "A79BD1F4DAA62FBA115DA8060B14F1B3")

    protected Class logConstructorSignature[] =
    { java.lang.String.class };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.387 -0400", hash_original_field = "3F577E5B52B6AF9771AC95B955EB944E", hash_generated_field = "2E94940264187C6E1C95D50F9FC6F304")

    protected Method logMethod = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.387 -0400", hash_original_field = "BCBAC9B4A17FB577A4EF04A96411BA05", hash_generated_field = "0BDE69C0899588F2E9ADEB24534DE255")

    protected Class logMethodSignature[] =
    { LogFactory.class };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.388 -0400", hash_original_field = "AE29EF668BAB99AA29556049E3686EED", hash_generated_field = "B6620E3AAE38F79B1D27EB4AD4796B96")

    private boolean allowFlawedContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.388 -0400", hash_original_field = "C45ECA6311CB5F0E98554FF42F00C366", hash_generated_field = "DD64959E51DCA8BEA04F5DDB3E4E7190")

    private boolean allowFlawedDiscovery;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.388 -0400", hash_original_field = "820B1ED7A96D2A1F5638713D6B1F5696", hash_generated_field = "86CF9C063C22586C1065BED40C2F5BD7")

    private boolean allowFlawedHierarchy;
    
    // ----------------------------------------------------------- Constructors

   

    /**
     * Public no-arguments constructor required by the lookup mechanism.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.379 -0400", hash_original_method = "93050B5F65D935AAD6FC53707BA320BF", hash_generated_method = "2169F3310D6E1AD26E696A3263506105")
    
public LogFactoryImpl() {
        super();
        initDiagnostics();  // method on this object
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Instance created.");
        }
    }
    
    // --------------------------------------------------------- Public Methods


    /**
     * Return the configuration attribute with the specified name (if any),
     * or <code>null</code> if there is no such attribute.
     *
     * @param name Name of the attribute to return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.389 -0400", hash_original_method = "1C198E011BD69AC9BBDAE21DE93A6A55", hash_generated_method = "468D58D48E832BF30A3AD33B53CEEF1C")
    
public Object getAttribute(String name) {

        return (attributes.get(name));

    }


    /**
     * Return an array containing the names of all currently defined
     * configuration attributes.  If there are no such attributes, a zero
     * length array is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.390 -0400", hash_original_method = "9562B4D9DCCF3830A382AE602D2B9601", hash_generated_method = "24E900AA9B51A49560C5E6065A7B34FD")
    
public String[] getAttributeNames() {

        Vector names = new Vector();
        Enumeration keys = attributes.keys();
        while (keys.hasMoreElements()) {
            names.addElement((String) keys.nextElement());
        }
        String results[] = new String[names.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = (String) names.elementAt(i);
        }
        return (results);

    }


    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.390 -0400", hash_original_method = "8C1B701E25DD287CFA5E53DC7A426009", hash_generated_method = "65CE8A184BD1229694498F30FDDA4C0E")
    
public Log getInstance(Class clazz) throws LogConfigurationException {

        return (getInstance(clazz.getName()));

    }


    /**
     * <p>Construct (if necessary) and return a <code>Log</code> instance,
     * using the factory's current set of configuration attributes.</p>
     *
     * <p><strong>NOTE</strong> - Depending upon the implementation of
     * the <code>LogFactory</code> you are using, the <code>Log</code>
     * instance you are returned may or may not be local to the current
     * application, and may or may not be returned again on a subsequent
     * call with the same name argument.</p>
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.391 -0400", hash_original_method = "384421227665A8390853D35DCC2B32F2", hash_generated_method = "51909162A391FB0FBA4DB4B16DF76B98")
    
public Log getInstance(String name) throws LogConfigurationException {

        Log instance = (Log) instances.get(name);
        if (instance == null) {
            instance = newInstance(name);
            instances.put(name, instance);
        }
        return (instance);

    }


    /**
     * Release any internal references to previously created
     * {@link org.apache.commons.logging.Log}
     * instances returned by this factory.  This is useful in environments
     * like servlet containers, which implement application reloading by
     * throwing away a ClassLoader.  Dangling references to objects in that
     * class loader would prevent garbage collection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.391 -0400", hash_original_method = "A9903E95F7A916A964F315F0A86C582F", hash_generated_method = "46DBCEF9C3CFB4D074C667B4B0D76381")
    
public void release() {

        logDiagnostic("Releasing all known loggers");
        instances.clear();
    }


    /**
     * Remove any configuration attribute associated with the specified name.
     * If there is no such attribute, no action is taken.
     *
     * @param name Name of the attribute to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.392 -0400", hash_original_method = "93D95A6C2BC51C643AAC1084F5BA9458", hash_generated_method = "5898EF9A47CD6D4D8A6946B5651B1C99")
    
public void removeAttribute(String name) {

        attributes.remove(name);

    }


    /**
     * Set the configuration attribute with the specified name.  Calling
     * this with a <code>null</code> value is equivalent to calling
     * <code>removeAttribute(name)</code>.
     * <p>
     * This method can be used to set logging configuration programmatically
     * rather than via system properties. It can also be used in code running
     * within a container (such as a webapp) to configure behaviour on a
     * per-component level instead of globally as system properties would do.
     * To use this method instead of a system property, call
     * <pre>
     * LogFactory.getFactory().setAttribute(...)
     * </pre>
     * This must be done before the first Log object is created; configuration
     * changes after that point will be ignored.
     * <p>
     * This method is also called automatically if LogFactory detects a
     * commons-logging.properties file; every entry in that file is set
     * automatically as an attribute here.
     *
     * @param name Name of the attribute to set
     * @param value Value of the attribute to set, or <code>null</code>
     *  to remove any setting for this attribute
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.392 -0400", hash_original_method = "7C01156DADC645B3FF2EC17CB179F355", hash_generated_method = "E126EADE2F8E79F6B03D8A1EB4D08737")
    
public void setAttribute(String name, Object value) {

        if (logConstructor != null) {
            logDiagnostic("setAttribute: call too late; configuration already performed.");
        }

        if (value == null) {
            attributes.remove(name);
        } else {
            attributes.put(name, value);
        }
        
        if (name.equals(TCCL_KEY)) {
            useTCCL = Boolean.valueOf(value.toString()).booleanValue();
        }

    }


    // ------------------------------------------------------ Protected Methods

    /**
     * Calculate and cache a string that uniquely identifies this instance,
     * including which classloader the object was loaded from.
     * <p>
     * This string will later be prefixed to each "internal logging" message
     * emitted, so that users can clearly see any unexpected behaviour.
     * <p>
     * Note that this method does not detect whether internal logging is 
     * enabled or not, nor where to output stuff if it is; that is all
     * handled by the parent LogFactory class. This method just computes
     * its own unique prefix for log messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.395 -0400", hash_original_method = "7AB0364EC8006702EB1B26C5F8F029B6", hash_generated_method = "9EAE88C9DAEFA184802765DF173D4EDB")
    
private void initDiagnostics() {
        // It would be nice to include an identifier of the context classloader
        // that this LogFactoryImpl object is responsible for. However that
        // isn't possible as that information isn't available. It is possible
        // to figure this out by looking at the logging from LogFactory to
        // see the context & impl ids from when this object was instantiated,
        // in order to link the impl id output as this object's prefix back to
        // the context it is intended to manage.
        // Note that this prefix should be kept consistent with that 
        // in LogFactory.
        Class clazz = this.getClass();
        ClassLoader classLoader = getClassLoader(clazz);
        String classLoaderName;
        try {
            if (classLoader == null) {
                classLoaderName = "BOOTLOADER";
            } else {
                classLoaderName = objectId(classLoader);
            }
        } catch(SecurityException e) {
            classLoaderName = "UNKNOWN";
        }
        diagnosticPrefix = "[LogFactoryImpl@" + System.identityHashCode(this) + " from " + classLoaderName + "] ";
    }

    
    /**
     * Output a diagnostic message to a user-specified destination (if the
     * user has enabled diagnostic logging).
     * 
     * @param msg diagnostic message
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.395 -0400", hash_original_method = "8431E20C339A956F4F5D9ADA2478B6A9", hash_generated_method = "9FB1861F6C63FC6D75F882C431F43A91")
    
protected void logDiagnostic(String msg) {
        if (isDiagnosticsEnabled()) {
            logRawDiagnostic(diagnosticPrefix + msg);
        }
    }

    /**
     * Return the fully qualified Java classname of the {@link Log}
     * implementation we will be using.  
     * 
     * @deprecated  Never invoked by this class; subclasses should not assume
     *              it will be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.396 -0400", hash_original_method = "CABA6C83F57F5B17737953B5FD954960", hash_generated_method = "10516D45206BB049508DF4A0885FB5DF")
    
protected String getLogClassName() {

        if (logClassName == null) {
            discoverLogImplementation(getClass().getName());
        }
        
        return logClassName;
    }


    /**
     * <p>Return the <code>Constructor</code> that can be called to instantiate
     * new {@link org.apache.commons.logging.Log} instances.</p>
     *
     * <p><strong>IMPLEMENTATION NOTE</strong> - Race conditions caused by
     * calling this method from more than one thread are ignored, because
     * the same <code>Constructor</code> instance will ultimately be derived
     * in all circumstances.</p>
     *
     * @exception LogConfigurationException if a suitable constructor
     *  cannot be returned   
     * 
     * @deprecated  Never invoked by this class; subclasses should not assume
     *              it will be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.396 -0400", hash_original_method = "A98EA93C7AFCA2D38153B07857B63F7E", hash_generated_method = "0962BC1246D1EEF60044D236C52665FB")
    
protected Constructor getLogConstructor()
        throws LogConfigurationException {

        // Return the previously identified Constructor (if any)
        if (logConstructor == null) {
            discoverLogImplementation(getClass().getName());
        }

        return logConstructor;
    }
    

    /**
     * Is <em>JDK 1.3 with Lumberjack</em> logging available?   
     * 
     * @deprecated  Never invoked by this class; subclasses should not assume
     *              it will be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.396 -0400", hash_original_method = "836D9E0757F7D4B08E6ED6703657F196", hash_generated_method = "07A902D5D01E26BFBD47BF579A749696")
    
protected boolean isJdk13LumberjackAvailable() {
        return isLogLibraryAvailable(
                "Jdk13Lumberjack",
                "org.apache.commons.logging.impl.Jdk13LumberjackLogger");
    }


    /**
     * <p>Return <code>true</code> if <em>JDK 1.4 or later</em> logging
     * is available.  Also checks that the <code>Throwable</code> class
     * supports <code>getStackTrace()</code>, which is required by
     * Jdk14Logger.</p>  
     * 
     * @deprecated  Never invoked by this class; subclasses should not assume
     *              it will be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.397 -0400", hash_original_method = "DD9093B6630FDA95068771DA019094CE", hash_generated_method = "D72ED220325CA7066E9333C435204C50")
    
protected boolean isJdk14Available() {
        return isLogLibraryAvailable(
                "Jdk14",
                "org.apache.commons.logging.impl.Jdk14Logger");
    }


    /**
     * Is a <em>Log4J</em> implementation available? 
     * 
     * @deprecated  Never invoked by this class; subclasses should not assume
     *              it will be.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.397 -0400", hash_original_method = "2F58076DE31F8FD3D26AA2A72A4389E9", hash_generated_method = "CA514565266853AFE0A0F7138C948F04")
    
protected boolean isLog4JAvailable() {
        return isLogLibraryAvailable(
                "Log4J",
                LOGGING_IMPL_LOG4J_LOGGER);
    }


    /**
     * Create and return a new {@link org.apache.commons.logging.Log}
     * instance for the specified name.
     *
     * @param name Name of the new logger
     *
     * @exception LogConfigurationException if a new instance cannot
     *  be created
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.399 -0400", hash_original_method = "ED24853B404BE829B919CA39CDFB9540", hash_generated_method = "9BE8CCEB8731B3BF87C4698A03F3743E")
    
protected Log newInstance(String name) throws LogConfigurationException {

        Log instance = null;
        try {
            if (logConstructor == null) {
                instance = discoverLogImplementation(name);
            }
            else {
                Object params[] = { name };
                instance = (Log) logConstructor.newInstance(params);
            }
            
            if (logMethod != null) {
                Object params[] = { this };
                logMethod.invoke(instance, params);
            }
            
            return (instance);
            
        } catch (LogConfigurationException lce) {
            
            // this type of exception means there was a problem in discovery
            // and we've already output diagnostics about the issue, etc.; 
            // just pass it on
            throw (LogConfigurationException) lce;
            
        } catch (InvocationTargetException e) {
            // A problem occurred invoking the Constructor or Method 
            // previously discovered
            Throwable c = e.getTargetException();
            if (c != null) {
                throw new LogConfigurationException(c);
            } else {
                throw new LogConfigurationException(e);
            }
        } catch (Throwable t) {
            // A problem occurred invoking the Constructor or Method 
            // previously discovered
            throw new LogConfigurationException(t);
        }
    }
    

    //  ------------------------------------------------------ Private Methods
    
    /**
     * Utility method to check whether a particular logging library is
     * present and available for use. Note that this does <i>not</i>
     * affect the future behaviour of this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.400 -0400", hash_original_method = "6ACE33DC5B7250308AF9F5940BFD54EA", hash_generated_method = "7A29C30262628F259D820EB4E06B2FAA")
    
private boolean isLogLibraryAvailable(String name, String classname) {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Checking for '" + name + "'.");
        }
        try {
            Log log = createLogFromClass(
                        classname, 
                        this.getClass().getName(), // dummy category
                        false);

            if (log == null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("Did not find '" + name + "'.");
                }
                return false;
            } else {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("Found '" + name + "'.");
                }
                return true;
            }
        } catch(LogConfigurationException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Logging system '" + name + "' is available but not useable.");
            }
            return false;
        }
    }

    /**
     * Attempt to find an attribute (see method setAttribute) or a 
     * system property with the provided name and return its value.
     * <p>
     * The attributes associated with this object are checked before
     * system properties in case someone has explicitly called setAttribute,
     * or a configuration property has been set in a commons-logging.properties
     * file.
     * 
     * @return the value associated with the property, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.401 -0400", hash_original_method = "627151FF6D8725BA562094280FF6569A", hash_generated_method = "E62CF862ED450F8376FDA6993FBDCFCD")
    
private String getConfigurationValue(String property) {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] Trying to get configuration for item " + property);
        }

        Object valueObj =  getAttribute(property);
        if (valueObj != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[ENV] Found LogFactory attribute [" + valueObj + "] for " + property);
            }
            return valueObj.toString();
        }
        
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] No LogFactory attribute found for " + property);
        }

        try {
            String value = System.getProperty(property);
            if (value != null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("[ENV] Found system property [" + value + "] for " + property);
                }
                return value;
            }

            if (isDiagnosticsEnabled()) {
                logDiagnostic("[ENV] No system property found for property " + property);
            }
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[ENV] Security prevented reading system property " + property);
            }
        }

        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] No configuration defined for item " + property);
        }

        return null;
    }
    
    /**
     * Get the setting for the user-configurable behaviour specified by key.
     * If nothing has explicitly been set, then return dflt.  
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.402 -0400", hash_original_method = "BF6D344C9E96242BA950DB7D8A7C8843", hash_generated_method = "637A448EF000F8D721F6821C5FD925ED")
    
private boolean getBooleanConfiguration(String key, boolean dflt) {
        String val = getConfigurationValue(key);
        if (val == null)
            return dflt;
        return Boolean.valueOf(val).booleanValue();
    }

    /**
     * Initialize a number of variables that control the behaviour of this
     * class and that can be tweaked by the user. This is done when the first
     * logger is created, not in the constructor of this class, because we
     * need to give the user a chance to call method setAttribute in order to
     * configure this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.402 -0400", hash_original_method = "0FD1FF85AF194431957D937CA643CE1B", hash_generated_method = "7B87EF0C2D5D88B23004911F3634822E")
    
private void initConfiguration() {
        allowFlawedContext = getBooleanConfiguration(ALLOW_FLAWED_CONTEXT_PROPERTY, true);
        allowFlawedDiscovery = getBooleanConfiguration(ALLOW_FLAWED_DISCOVERY_PROPERTY, true);
        allowFlawedHierarchy = getBooleanConfiguration(ALLOW_FLAWED_HIERARCHY_PROPERTY, true);
    }
  

    /**
     * Attempts to create a Log instance for the given category name.
     * Follows the discovery process described in the class javadoc.
     * 
     * @param logCategory the name of the log category
     * 
     * @throws LogConfigurationException if an error in discovery occurs, 
     * or if no adapter at all can be instantiated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.404 -0400", hash_original_method = "9BAAB904C2908A20E6C8F3394417762C", hash_generated_method = "24806FF8D625B99124D895020EF2BD66")
    
private Log discoverLogImplementation(String logCategory)
    throws LogConfigurationException
    {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Discovering a Log implementation...");
        }
        
        initConfiguration();
        
        Log result = null;
        
        // See if the user specified the Log implementation to use
        String specifiedLogClassName = findUserSpecifiedLogClassName();

        if (specifiedLogClassName != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Attempting to load user-specified log class '" + 
                    specifiedLogClassName + "'...");
            }
            
            result = createLogFromClass(specifiedLogClassName,
                                        logCategory,
                                        true);
            if (result == null) {
                StringBuffer messageBuffer =  new StringBuffer("User-specified log class '");
                messageBuffer.append(specifiedLogClassName);
                messageBuffer.append("' cannot be found or is not useable.");
                
                // Mistyping or misspelling names is a common fault.
                // Construct a good error message, if we can
                if (specifiedLogClassName != null) {
                    informUponSimilarName(messageBuffer, specifiedLogClassName, LOGGING_IMPL_LOG4J_LOGGER);
                    informUponSimilarName(messageBuffer, specifiedLogClassName, LOGGING_IMPL_JDK14_LOGGER);
                    informUponSimilarName(messageBuffer, specifiedLogClassName, LOGGING_IMPL_LUMBERJACK_LOGGER);
                    informUponSimilarName(messageBuffer, specifiedLogClassName, LOGGING_IMPL_SIMPLE_LOGGER);
                }
                throw new LogConfigurationException(messageBuffer.toString());
            }
            
            return result;
        }
        
        // No user specified log; try to discover what's on the classpath
        //
        // Note that we deliberately loop here over classesToDiscover and
        // expect method createLogFromClass to loop over the possible source
        // classloaders. The effect is:
        //   for each discoverable log adapter
        //      for each possible classloader
        //          see if it works
        //
        // It appears reasonable at first glance to do the opposite: 
        //   for each possible classloader
        //     for each discoverable log adapter
        //        see if it works
        //
        // The latter certainly has advantages for user-installable logging
        // libraries such as log4j; in a webapp for example this code should
        // first check whether the user has provided any of the possible
        // logging libraries before looking in the parent classloader. 
        // Unfortunately, however, Jdk14Logger will always work in jvm>=1.4,
        // and SimpleLog will always work in any JVM. So the loop would never
        // ever look for logging libraries in the parent classpath. Yet many
        // users would expect that putting log4j there would cause it to be
        // detected (and this is the historical JCL behaviour). So we go with
        // the first approach. A user that has bundled a specific logging lib
        // in a webapp should use a commons-logging.properties file or a
        // service file in META-INF to force use of that logging lib anyway,
        // rather than relying on discovery.
        
        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                "No user-specified Log implementation; performing discovery" +
            	" using the standard supported logging implementations...");
        }
        for(int i=0; (i<classesToDiscover.length) && (result == null); ++i) {
            result = createLogFromClass(classesToDiscover[i], logCategory, true);
        }
        
        if (result == null) {
            throw new LogConfigurationException
                        ("No suitable Log implementation");
        }
        
        return result;        
    }


    /**
     * Appends message if the given name is similar to the candidate.
     * @param messageBuffer <code>StringBuffer</code> the message should be appended to, 
     * not null
     * @param name the (trimmed) name to be test against the candidate, not null
     * @param candidate the candidate name (not null)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.405 -0400", hash_original_method = "34B52DE0227DFFB1E1EBE0090FF7842E", hash_generated_method = "A5F00BE2549DEB3591DB78C6D71D627E")
    
private void informUponSimilarName(final StringBuffer messageBuffer, final String name, 
            final String candidate) {
        if (name.equals(candidate)) {
            // Don't suggest a name that is exactly the same as the one the
            // user tried...
            return;
        }

        // If the user provides a name that is in the right package, and gets
        // the first 5 characters of the adapter class right (ignoring case),
        // then suggest the candidate adapter class name.
        if (name.regionMatches(true, 0, candidate, 0, PKG_LEN + 5)) {
            messageBuffer.append(" Did you mean '");
            messageBuffer.append(candidate);
            messageBuffer.append("'?");
        }
    }
    
    
    /**
     * Checks system properties and the attribute map for 
     * a Log implementation specified by the user under the 
     * property names {@link #LOG_PROPERTY} or {@link #LOG_PROPERTY_OLD}.
     * 
     * @return classname specified by the user, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.406 -0400", hash_original_method = "F024D28B2A0B136C565E9DA774876864", hash_generated_method = "3F5A5F600D41D4AA073F7972B6ECBCE7")
    
private String findUserSpecifiedLogClassName()
    {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Trying to get log class from attribute '" + LOG_PROPERTY + "'");
        }
        String specifiedClass = (String) getAttribute(LOG_PROPERTY);

        if (specifiedClass == null) { // @deprecated
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from attribute '" + 
                              LOG_PROPERTY_OLD + "'");
            }
            specifiedClass = (String) getAttribute(LOG_PROPERTY_OLD);
        }

        if (specifiedClass == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from system property '" + 
                          LOG_PROPERTY + "'");
            }
            try {
                specifiedClass = System.getProperty(LOG_PROPERTY);
            } catch (SecurityException e) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("No access allowed to system property '" + 
                        LOG_PROPERTY + "' - " + e.getMessage());
                }
            }
        }

        if (specifiedClass == null) { // @deprecated
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from system property '" + 
                          LOG_PROPERTY_OLD + "'");
            }
            try {
                specifiedClass = System.getProperty(LOG_PROPERTY_OLD);
            } catch (SecurityException e) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("No access allowed to system property '" + 
                        LOG_PROPERTY_OLD + "' - " + e.getMessage());
                }
            }
        }
        
        // Remove any whitespace; it's never valid in a classname so its
        // presence just means a user mistake. As we know what they meant,
        // we may as well strip the spaces.
        if (specifiedClass != null) {
            specifiedClass = specifiedClass.trim();
        }

        return specifiedClass;
    }

    
    /**
     * Attempts to load the given class, find a suitable constructor,
     * and instantiate an instance of Log.
     * 
     * @param logAdapterClassName classname of the Log implementation
     * 
     * @param logCategory  argument to pass to the Log implementation's
     * constructor
     * 
     * @param affectState  <code>true</code> if this object's state should
     * be affected by this method call, <code>false</code> otherwise.
     * 
     * @return  an instance of the given class, or null if the logging
     * library associated with the specified adapter is not available.
     *                          
     * @throws LogConfigurationException if there was a serious error with
     * configuration and the handleFlawedDiscovery method decided this
     * problem was fatal.
     */                                  
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.410 -0400", hash_original_method = "F5FECCB95FE8806CAD82D64ADC168BCA", hash_generated_method = "DC3F6E91ED8772CEAEE78370439DD188")
    
private Log createLogFromClass(String logAdapterClassName,
                                   String logCategory,
                                   boolean affectState) 
            throws LogConfigurationException {       

        if (isDiagnosticsEnabled()) {
            logDiagnostic("Attempting to instantiate '" + logAdapterClassName + "'");
        }
        
        Object[] params = { logCategory };
        Log logAdapter = null;
        Constructor constructor = null;
        
        Class logAdapterClass = null;
        ClassLoader currentCL = getBaseClassLoader();
        
        for(;;) {
            // Loop through the classloader hierarchy trying to find
            // a viable classloader.
            logDiagnostic(
                    "Trying to load '"
                    + logAdapterClassName
                    + "' from classloader "
                    + objectId(currentCL));
            try {
                if (isDiagnosticsEnabled()) {
                    // Show the location of the first occurrence of the .class file
                    // in the classpath. This is the location that ClassLoader.loadClass
                    // will load the class from -- unless the classloader is doing
                    // something weird. 
                    URL url;
                    String resourceName = logAdapterClassName.replace('.', '/') + ".class";
                    if (currentCL != null) {
                        url = currentCL.getResource(resourceName );
                    } else {
                        url = ClassLoader.getSystemResource(resourceName + ".class");
                    }

                    if (url == null) {
                        logDiagnostic("Class '" + logAdapterClassName + "' [" + resourceName + "] cannot be found.");
                    } else {
                        logDiagnostic("Class '" + logAdapterClassName + "' was found at '" + url + "'");
                    }
                }

                Class c = null;
                try {
                    c = Class.forName(logAdapterClassName, true, currentCL);
                } catch (ClassNotFoundException originalClassNotFoundException) {
                    // The current classloader was unable to find the log adapter 
                    // in this or any ancestor classloader. There's no point in
                    // trying higher up in the hierarchy in this case..
                    String msg = "" + originalClassNotFoundException.getMessage();
                    logDiagnostic(
                        "The log adapter '"
                        + logAdapterClassName
                        + "' is not available via classloader " 
                        + objectId(currentCL)
                        + ": "
                        + msg.trim());
                    try {
                        // Try the class classloader.
                        // This may work in cases where the TCCL
                        // does not contain the code executed or JCL.
                        // This behaviour indicates that the application 
                        // classloading strategy is not consistent with the
                        // Java 1.2 classloading guidelines but JCL can
                        // and so should handle this case.
                        c = Class.forName(logAdapterClassName);
                    } catch (ClassNotFoundException secondaryClassNotFoundException) {
                        // no point continuing: this adapter isn't available
                        msg = "" + secondaryClassNotFoundException.getMessage();
                        logDiagnostic(
                            "The log adapter '"
                            + logAdapterClassName
                            + "' is not available via the LogFactoryImpl class classloader: "
                            + msg.trim());
                        break;
                    }
                }
                
                constructor = c.getConstructor(logConstructorSignature);
                Object o = constructor.newInstance(params);

                // Note that we do this test after trying to create an instance
                // [rather than testing Log.class.isAssignableFrom(c)] so that
                // we don't complain about Log hierarchy problems when the
                // adapter couldn't be instantiated anyway.
                if (o instanceof Log) {
                    logAdapterClass = c;
                    logAdapter = (Log) o;
                    break;
                }
                
                // Oops, we have a potential problem here. An adapter class
                // has been found and its underlying lib is present too, but
                // there are multiple Log interface classes available making it
                // impossible to cast to the type the caller wanted. We 
                // certainly can't use this logger, but we need to know whether
                // to keep on discovering or terminate now.
                //
                // The handleFlawedHierarchy method will throw 
                // LogConfigurationException if it regards this problem as
                // fatal, and just return if not.
                handleFlawedHierarchy(currentCL, c);
            } catch (NoClassDefFoundError e) {
                // We were able to load the adapter but it had references to
                // other classes that could not be found. This simply means that
                // the underlying logger library is not present in this or any
                // ancestor classloader. There's no point in trying higher up
                // in the hierarchy in this case..
                String msg = "" + e.getMessage();
                logDiagnostic(
                    "The log adapter '"
                    + logAdapterClassName
                    + "' is missing dependencies when loaded via classloader "
                    + objectId(currentCL)
                    + ": "
                    + msg.trim());
                break;
            } catch (ExceptionInInitializerError e) {
                // A static initializer block or the initializer code associated 
                // with a static variable on the log adapter class has thrown
                // an exception.
                //
                // We treat this as meaning the adapter's underlying logging
                // library could not be found.
                String msg = "" + e.getMessage();
                logDiagnostic(
                    "The log adapter '"
                    + logAdapterClassName
                    + "' is unable to initialize itself when loaded via classloader "
                    + objectId(currentCL)
                    + ": "
                    + msg.trim());
                break;
            } catch(LogConfigurationException e) {
                // call to handleFlawedHierarchy above must have thrown
                // a LogConfigurationException, so just throw it on                
                throw e;
            } catch(Throwable t) {
                // handleFlawedDiscovery will determine whether this is a fatal
                // problem or not. If it is fatal, then a LogConfigurationException
                // will be thrown.
                handleFlawedDiscovery(logAdapterClassName, currentCL, t);
            }
                        
            if (currentCL == null) {
                break;
            }
            
            // try the parent classloader
            currentCL = currentCL.getParent();
        }

        if ((logAdapter != null) && affectState) {
            // We've succeeded, so set instance fields
            this.logClassName   = logAdapterClassName;
            this.logConstructor = constructor;
            
            // Identify the <code>setLogFactory</code> method (if there is one)
            try {
                this.logMethod = logAdapterClass.getMethod("setLogFactory",
                                               logMethodSignature);
                logDiagnostic("Found method setLogFactory(LogFactory) in '" 
                              + logAdapterClassName + "'");
            } catch (Throwable t) {
                this.logMethod = null;
                logDiagnostic(
                    "[INFO] '" + logAdapterClassName 
                    + "' from classloader " + objectId(currentCL)
                    + " does not declare optional method "
                    + "setLogFactory(LogFactory)");
            }
            
            logDiagnostic(
                "Log adapter '" + logAdapterClassName 
                + "' from classloader " + objectId(logAdapterClass.getClassLoader())
                + " has been selected for use.");
        }
        
        return logAdapter;
    }
    
    
    /**
     * Return the classloader from which we should try to load the logging
     * adapter classes.
     * <p>
     * This method usually returns the context classloader. However if it
     * is discovered that the classloader which loaded this class is a child
     * of the context classloader <i>and</i> the allowFlawedContext option
     * has been set then the classloader which loaded this class is returned
     * instead.
     * <p>
     * The only time when the classloader which loaded this class is a
     * descendant (rather than the same as or an ancestor of the context
     * classloader) is when an app has created custom classloaders but
     * failed to correctly set the context classloader. This is a bug in
     * the calling application; however we provide the option for JCL to
     * simply generate a warning rather than fail outright.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.411 -0400", hash_original_method = "185C16973909CF72FA529A5AADFF1B2B", hash_generated_method = "73CCB1DC30EAC821A8189C3F8B1DDE7E")
    
private ClassLoader getBaseClassLoader() throws LogConfigurationException {
        ClassLoader thisClassLoader = getClassLoader(LogFactoryImpl.class);
        
        if (useTCCL == false) {
            return thisClassLoader;
        }

        ClassLoader contextClassLoader = getContextClassLoader();

        ClassLoader baseClassLoader = getLowestClassLoader(
                contextClassLoader, thisClassLoader);
        
        if (baseClassLoader == null) {
           // The two classloaders are not part of a parent child relationship.
           // In some classloading setups (e.g. JBoss with its 
           // UnifiedLoaderRepository) this can still work, so if user hasn't
           // forbidden it, just return the contextClassLoader.
           if (allowFlawedContext) {   
              if (isDiagnosticsEnabled()) {
                   logDiagnostic(
                           "[WARNING] the context classloader is not part of a"
                           + " parent-child relationship with the classloader that"
                           + " loaded LogFactoryImpl.");
              }
              // If contextClassLoader were null, getLowestClassLoader() would
              // have returned thisClassLoader.  The fact we are here means
              // contextClassLoader is not null, so we can just return it.
              return contextClassLoader;
           }
           else {
            throw new LogConfigurationException(
                "Bad classloader hierarchy; LogFactoryImpl was loaded via"
                + " a classloader that is not related to the current context"
                + " classloader.");
           }           
        }

        if (baseClassLoader != contextClassLoader) {
            // We really should just use the contextClassLoader as the starting
            // point for scanning for log adapter classes. However it is expected
            // that there are a number of broken systems out there which create
            // custom classloaders but fail to set the context classloader so
            // we handle those flawed systems anyway.
            if (allowFlawedContext) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                            "Warning: the context classloader is an ancestor of the"
                            + " classloader that loaded LogFactoryImpl; it should be"
                            + " the same or a descendant. The application using"
                            + " commons-logging should ensure the context classloader"
                            + " is used correctly.");
                }
            } else {
                throw new LogConfigurationException(
                        "Bad classloader hierarchy; LogFactoryImpl was loaded via"
                        + " a classloader that is not related to the current context"
                        + " classloader."); 
            }
        }
        
        return baseClassLoader;
    }

    /**
     * Given two related classloaders, return the one which is a child of
     * the other.
     * <p>
     * @param c1 is a classloader (including the null classloader)
     * @param c2 is a classloader (including the null classloader)
     * 
     * @return c1 if it has c2 as an ancestor, c2 if it has c1 as an ancestor,
     * and null if neither is an ancestor of the other.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.412 -0400", hash_original_method = "FF8173E1132B851732BC699B3C49830D", hash_generated_method = "B2449060A70982D25F010B1AA429A059")
    
private ClassLoader getLowestClassLoader(ClassLoader c1, ClassLoader c2) {
        // TODO: use AccessController when dealing with classloaders here
        
        if (c1 == null)
            return c2;
        
        if (c2 == null)
            return c1;
        
        ClassLoader current;

        // scan c1's ancestors to find c2
        current = c1;
        while (current != null) {
            if (current == c2)
                return c1;
            current = current.getParent();
        }
       
        // scan c2's ancestors to find c1
        current = c2;
        while (current != null) {
            if (current == c1)
                return c2;
            current = current.getParent();
        }

        return null;
    }

    /**
     * Generates an internal diagnostic logging of the discovery failure and 
     * then throws a <code>LogConfigurationException</code> that wraps 
     * the passed <code>Throwable</code>.
     * 
     * @param logAdapterClassName is the class name of the Log implementation
     * that could not be instantiated. Cannot be <code>null</code>.
     * 
     * @param classLoader is the classloader that we were trying to load the
     * logAdapterClassName from when the exception occurred.
     * 
     * @param discoveryFlaw is the Throwable created by the classloader
     * 
     * @throws LogConfigurationException    ALWAYS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.413 -0400", hash_original_method = "85D28131980ACA042D133B2C5AC1F447", hash_generated_method = "E23111992F62ACC60B383CFBF8677273")
    
private void handleFlawedDiscovery(String logAdapterClassName,
                                       ClassLoader classLoader,
                                       Throwable discoveryFlaw) {
        
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Could not instantiate Log '"
                      + logAdapterClassName + "' -- "
                      + discoveryFlaw.getClass().getName() + ": "
                      + discoveryFlaw.getLocalizedMessage());       
        }
        
        if (!allowFlawedDiscovery) {
            throw new LogConfigurationException(discoveryFlaw);
        }
    }

    
    /**
     * Report a problem loading the log adapter, then either return 
     * (if the situation is considered recoverable) or throw a
     * LogConfigurationException.
     *  <p>
     * There are two possible reasons why we successfully loaded the 
     * specified log adapter class then failed to cast it to a Log object:
     * <ol>
     * <li>the specific class just doesn't implement the Log interface 
     *     (user screwed up), or
     * <li> the specified class has bound to a Log class loaded by some other
     *      classloader; Log@classloaderX cannot be cast to Log@classloaderY.
     * </ol>
     * <p>
     * Here we try to figure out which case has occurred so we can give the
     * user some reasonable feedback.
     * 
     * @param badClassLoader is the classloader we loaded the problem class from,
     * ie it is equivalent to badClass.getClassLoader().
     * 
     * @param badClass is a Class object with the desired name, but which 
     * does not implement Log correctly.
     * 
     * @throws LogConfigurationException when the situation
     * should not be recovered from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.415 -0400", hash_original_method = "C85D2BAD15C461ED773DB3910F32157A", hash_generated_method = "17382E4FC0E30E80EA455224281FF0A0")
    
private void handleFlawedHierarchy(ClassLoader badClassLoader, Class badClass)
    throws LogConfigurationException {

        boolean implementsLog = false;
        String logInterfaceName = Log.class.getName();
        Class interfaces[] = badClass.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (logInterfaceName.equals(interfaces[i].getName())) {
                implementsLog = true;
                break;
            }
        }
        
        if (implementsLog) {
            // the class does implement an interface called Log, but
            // it is in the wrong classloader
            if (isDiagnosticsEnabled()) {
                try {
                    ClassLoader logInterfaceClassLoader = getClassLoader(Log.class);
                    logDiagnostic(
                        "Class '" + badClass.getName()
                        + "' was found in classloader " 
                        + objectId(badClassLoader)
                        + ". It is bound to a Log interface which is not"
                        + " the one loaded from classloader "
                        + objectId(logInterfaceClassLoader));
                } catch (Throwable t) {
                    logDiagnostic(
                        "Error while trying to output diagnostics about"
                        + " bad class '" + badClass + "'");
                }
            }
            
            if (!allowFlawedHierarchy) {
                StringBuffer msg = new StringBuffer();
                msg.append("Terminating logging for this context ");
                msg.append("due to bad log hierarchy. ");
                msg.append("You have more than one version of '");
                msg.append(Log.class.getName());
                msg.append("' visible.");
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(msg.toString());
                } 
                throw new LogConfigurationException(msg.toString());
            }
        
            if (isDiagnosticsEnabled()) {
                StringBuffer msg = new StringBuffer();
                msg.append("Warning: bad log hierarchy. ");
                msg.append("You have more than one version of '");
                msg.append(Log.class.getName());
                msg.append("' visible.");
                logDiagnostic(msg.toString());
            }
        } else {
            // this is just a bad adapter class
            if (!allowFlawedDiscovery) {
                StringBuffer msg = new StringBuffer();
                msg.append("Terminating logging for this context. ");
                msg.append("Log class '");
                msg.append(badClass.getName());
                msg.append("' does not implement the Log interface.");
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(msg.toString());
                }
                
                throw new LogConfigurationException(msg.toString());
            }

            if (isDiagnosticsEnabled()) {
                StringBuffer msg = new StringBuffer();
                msg.append("[WARNING] Log class '");
                msg.append(badClass.getName());
                msg.append("' does not implement the Log interface.");
                logDiagnostic(msg.toString());
            }
        }
    }
}
