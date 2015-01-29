package org.apache.commons.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import org.apache.commons.logging.impl.WeakHashtable;

public abstract class LogFactory {

    /**
     * Create the hashtable which will be used to store a map of
     * (context-classloader -> logfactory-object). Version 1.2+ of Java
     * supports "weak references", allowing a custom Hashtable class
     * to be used which uses only weak references to its keys. Using weak
     * references can fix memory leaks on webapp unload in some cases (though
     * not all). Version 1.1 of Java does not support weak references, so we
     * must dynamically determine which we are using. And just for fun, this
     * code also supports the ability for a system property to specify an
     * arbitrary Hashtable implementation name.
     * <p>
     * Note that the correct way to ensure no memory leaks occur is to ensure
     * that LogFactory.release(contextClassLoader) is called whenever a 
     * webapp is undeployed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.237 -0500", hash_original_method = "99E3A91D3C10CF72291E25D8500DEBBE", hash_generated_method = "1382044792DAC3A0FD246B154CBA0A69")
    
private static final Hashtable createFactoryStore() {
        Hashtable result = new Hashtable();
        return result;
    }

    // --------------------------------------------------------- Static Methods

    /**
     * <p>Construct (if necessary) and return a <code>LogFactory</code>
     * instance, using the following ordered lookup procedure to determine
     * the name of the implementation class to be loaded.</p>
     * <ul>
     * <li>The <code>org.apache.commons.logging.LogFactory</code> system
     *     property.</li>
     * <li>The JDK 1.3 Service Discovery mechanism</li>
     * <li>Use the properties file <code>commons-logging.properties</code>
     *     file, if found in the class path of this class.  The configuration
     *     file is in standard <code>java.util.Properties</code> format and
     *     contains the fully qualified name of the implementation class
     *     with the key being the system property defined above.</li>
     * <li>Fall back to a default implementation class
     *     (<code>org.apache.commons.logging.impl.LogFactoryImpl</code>).</li>
     * </ul>
     *
     * <p><em>NOTE</em> - If the properties file method of identifying the
     * <code>LogFactory</code> implementation class is utilized, all of the
     * properties defined in this file will be set as configuration attributes
     * on the corresponding <code>LogFactory</code> instance.</p>
     * 
     * <p><em>NOTE</em> - In a multithreaded environment it is possible 
     * that two different instances will be returned for the same 
     * classloader environment. 
     * </p>
     *
     * @exception LogConfigurationException if the implementation class is not
     *  available or cannot be instantiated.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.243 -0500", hash_original_method = "33FF688455A61CB525147A185CEE209C", hash_generated_method = "3DB104B438DA7DCEE194F35F16677826")
    
public static LogFactory getFactory() throws LogConfigurationException {
        // Identify the class loader we will be using
        ClassLoader contextClassLoader = getContextClassLoader();

        if (contextClassLoader == null) {
            // This is an odd enough situation to report about. This
            // output will be a nuisance on JDK1.1, as the system
            // classloader is null in that environment.
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Context classloader is null.");
            }
        }

        // Return any previously registered factory for this class loader
        LogFactory factory = getCachedFactory(contextClassLoader);
        if (factory != null) {
            return factory;
        }

        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                    "[LOOKUP] LogFactory implementation requested for the first time for context classloader "
                    + objectId(contextClassLoader));
            logHierarchy("[LOOKUP] ", contextClassLoader);
        }

        // Load properties file.
        //
        // If the properties file exists, then its contents are used as
        // "attributes" on the LogFactory implementation class. One particular
        // property may also control which LogFactory concrete subclass is
        // used, but only if other discovery mechanisms fail..
        //
        // As the properties file (if it exists) will be used one way or 
        // another in the end we may as well look for it first.

        Properties props = getConfigurationFile(contextClassLoader, FACTORY_PROPERTIES);

        // Determine whether we will be using the thread context class loader to
        // load logging classes or not by checking the loaded properties file (if any).
        ClassLoader baseClassLoader = contextClassLoader;
        if (props != null) {
            String useTCCLStr = props.getProperty(TCCL_KEY);
            if (useTCCLStr != null) {
                // The Boolean.valueOf(useTCCLStr).booleanValue() formulation
                // is required for Java 1.2 compatability.
                if (Boolean.valueOf(useTCCLStr).booleanValue() == false) {
                    // Don't use current context classloader when locating any
                    // LogFactory or Log classes, just use the class that loaded
                    // this abstract class. When this class is deployed in a shared
                    // classpath of a container, it means webapps cannot deploy their
                    // own logging implementations. It also means that it is up to the
                    // implementation whether to load library-specific config files
                    // from the TCCL or not.
                    baseClassLoader = thisClassLoader; 
                }
            }
        }

        // Determine which concrete LogFactory subclass to use.
        // First, try a global system property
        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                    "[LOOKUP] Looking for system property [" + FACTORY_PROPERTY 
                    + "] to define the LogFactory subclass to use...");
        }
        
        try {
            String factoryClass = System.getProperty(FACTORY_PROPERTY);
            if (factoryClass != null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                            "[LOOKUP] Creating an instance of LogFactory class '" + factoryClass
                            + "' as specified by system property " + FACTORY_PROPERTY);
                }
                
                factory = newFactory(factoryClass, baseClassLoader, contextClassLoader);
            } else {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                            "[LOOKUP] No system property [" + FACTORY_PROPERTY 
                            + "] defined.");
                }
            }
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] A security exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + e.getMessage().trim()
                        + "]. Trying alternative implementations...");
            }
            ;  // ignore
        } catch(RuntimeException e) {
            // This is not consistent with the behaviour when a bad LogFactory class is
            // specified in a services file.
            //
            // One possible exception that can occur here is a ClassCastException when
            // the specified class wasn't castable to this LogFactory type.
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] An exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + e.getMessage().trim()
                        + "] as specified by a system property.");
            }
            throw e;
        }

        // Second, try to find a service by using the JDK1.3 class
        // discovery mechanism, which involves putting a file with the name
        // of an interface class in the META-INF/services directory, where the
        // contents of the file is a single line specifying a concrete class 
        // that implements the desired interface.

        if (factory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] Looking for a resource file of name [" + SERVICE_ID
                        + "] to define the LogFactory subclass to use...");
            }
            try {
                InputStream is = getResourceAsStream(contextClassLoader,
                                                     SERVICE_ID);

                if( is != null ) {
                    // This code is needed by EBCDIC and other strange systems.
                    // It's a fix for bugs reported in xerces
                    BufferedReader rd;
                    try {
                        rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    } catch (java.io.UnsupportedEncodingException e) {
                        rd = new BufferedReader(new InputStreamReader(is));
                    }

                    String factoryClassName = rd.readLine();
                    rd.close();

                    if (factoryClassName != null &&
                        ! "".equals(factoryClassName)) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "[LOOKUP]  Creating an instance of LogFactory class " + factoryClassName
                                    + " as specified by file '" + SERVICE_ID 
                                    + "' which was present in the path of the context"
                                    + " classloader.");
                        }
                        factory = newFactory(factoryClassName, baseClassLoader, contextClassLoader );
                    }
                } else {
                    // is == null
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] No resource file with name '" + SERVICE_ID
                            + "' found.");
                    }
                }
            } catch( Exception ex ) {
                // note: if the specified LogFactory class wasn't compatible with LogFactory
                // for some reason, a ClassCastException will be caught here, and attempts will
                // continue to find a compatible class.
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] A security exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + ex.getMessage().trim()
                        + "]. Trying alternative implementations...");
                }
                ; // ignore
            }
        }

        // Third try looking into the properties file read earlier (if found)

        if (factory == null) {
            if (props != null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] Looking in properties file for entry with key '" 
                        + FACTORY_PROPERTY
                        + "' to define the LogFactory subclass to use...");
                }
                String factoryClass = props.getProperty(FACTORY_PROPERTY);
                if (factoryClass != null) {
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] Properties file specifies LogFactory subclass '" 
                            + factoryClass + "'");
                    }
                    factory = newFactory(factoryClass, baseClassLoader, contextClassLoader);
                    
                    // TODO: think about whether we need to handle exceptions from newFactory
                } else {
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
                    }
                }
            } else {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] No properties file available to determine"
                        + " LogFactory subclass from..");
                }
            }
        }

        // Fourth, try the fallback implementation class

        if (factory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                "[LOOKUP] Loading the default LogFactory implementation '" + FACTORY_DEFAULT
                + "' via the same classloader that loaded this LogFactory"
                + " class (ie not looking in the context classloader).");
            }
            
            // Note: unlike the above code which can try to load custom LogFactory
            // implementations via the TCCL, we don't try to load the default LogFactory
            // implementation via the context classloader because:
            // * that can cause problems (see comments in newFactory method)
            // * no-one should be customising the code of the default class
            // Yes, we do give up the ability for the child to ship a newer
            // version of the LogFactoryImpl class and have it used dynamically
            // by an old LogFactory class in the parent, but that isn't 
            // necessarily a good idea anyway.
            factory = newFactory(FACTORY_DEFAULT, thisClassLoader, contextClassLoader);
        }

        if (factory != null) {
            /**
             * Always cache using context class loader.
             */
            cacheFactory(contextClassLoader, factory);

            if( props!=null ) {
                Enumeration names = props.propertyNames();
                while (names.hasMoreElements()) {
                    String name = (String) names.nextElement();
                    String value = props.getProperty(name);
                    factory.setAttribute(name, value);
                }
            }
        }

        return factory;
    }

    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param clazz Class from which a log name will be derived
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.246 -0500", hash_original_method = "91375CC7DDE12AA338C602727C25174F", hash_generated_method = "044821AC2AA898B0076D21ECC71EC87A")
    
public static Log getLog(Class clazz)
        throws LogConfigurationException {

        // BEGIN android-added
        return getLog(clazz.getName());
        // END android-added
        // BEGIN android-deleted
        //return (getFactory().getInstance(clazz));
        // END android-deleted

    }

    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.248 -0500", hash_original_method = "9CDE1AF86C53A03FEBBCD488EAA5D64F", hash_generated_method = "101A139828661B07F82A7885866E2F7A")
    
public static Log getLog(String name)
        throws LogConfigurationException {

        // BEGIN android-added
        return new org.apache.commons.logging.impl.Jdk14Logger(name);
        // END android-added
        // BEGIN android-deleted
        //return (getFactory().getInstance(name));
        // END android-deleted

    }

    /**
     * Release any internal references to previously created {@link LogFactory}
     * instances that have been associated with the specified class loader
     * (if any), after calling the instance method <code>release()</code> on
     * each of them.
     *
     * @param classLoader ClassLoader for which to release the LogFactory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.251 -0500", hash_original_method = "86FE8ACF686D2196BF5667851791DCBD", hash_generated_method = "30F3227BE72810D5F6D025615EB03C0D")
    
public static void release(ClassLoader classLoader) {

        if (isDiagnosticsEnabled()) {
            logDiagnostic("Releasing factory for classloader " + objectId(classLoader));
        }
        synchronized (factories) {
            if (classLoader == null) {
                if (nullClassLoaderFactory != null) {
                    nullClassLoaderFactory.release();
                    nullClassLoaderFactory = null;
                }
            } else {
                LogFactory factory = (LogFactory) factories.get(classLoader);
                if (factory != null) {
                    factory.release();
                    factories.remove(classLoader);
                }
            }
        }

    }

    /**
     * Release any internal references to previously created {@link LogFactory}
     * instances, after calling the instance method <code>release()</code> on
     * each of them.  This is useful in environments like servlet containers,
     * which implement application reloading by throwing away a ClassLoader.
     * Dangling references to objects in that class loader would prevent
     * garbage collection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.254 -0500", hash_original_method = "462BCFC7F269930E40A4FCD6393CDC72", hash_generated_method = "B438EBAF3C3BEB2F7E7382237E095269")
    
public static void releaseAll() {

        if (isDiagnosticsEnabled()) {
            logDiagnostic("Releasing factory for all classloaders.");
        }
        synchronized (factories) {
            Enumeration elements = factories.elements();
            while (elements.hasMoreElements()) {
                LogFactory element = (LogFactory) elements.nextElement();
                element.release();
            }
            factories.clear();

            if (nullClassLoaderFactory != null) {
                nullClassLoaderFactory.release();
                nullClassLoaderFactory = null;
            }
        }

    }

    // ------------------------------------------------------ Protected Methods

    /**
     * Safely get access to the classloader for the specified class.
     * <p>
     * Theoretically, calling getClassLoader can throw a security exception,
     * and so should be done under an AccessController in order to provide
     * maximum flexibility. However in practice people don't appear to use
     * security policies that forbid getClassLoader calls. So for the moment
     * all code is written to call this method rather than Class.getClassLoader,
     * so that we could put AccessController stuff in this method without any
     * disruption later if we need to.
     * <p>
     * Even when using an AccessController, however, this method can still
     * throw SecurityException. Commons-logging basically relies on the
     * ability to access classloaders, ie a policy that forbids all
     * classloader access will also prevent commons-logging from working: 
     * currently this method will throw an exception preventing the entire app
     * from starting up. Maybe it would be good to detect this situation and
     * just disable all commons-logging? Not high priority though - as stated
     * above, security policies that prevent classloader access aren't common.
     * 
     * @since 1.1
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.256 -0500", hash_original_method = "BB3F6B78143DB6D0ADEC7F433E59252E", hash_generated_method = "D8624905AC94843F4FEF503B26E292EE")
    
protected static ClassLoader getClassLoader(Class clazz) {
        try {
            return clazz.getClassLoader();
        } catch(SecurityException ex) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "Unable to get classloader for class '" + clazz
                        + "' due to security restrictions - " + ex.getMessage());
            }
            throw ex;
        }
    }

    /**
     * Calls LogFactory.directGetContextClassLoader under the control of an
     * AccessController class. This means that java code running under a
     * security manager that forbids access to ClassLoaders will still work
     * if this class is given appropriate privileges, even when the caller
     * doesn't have such privileges. Without using an AccessController, the
     * the entire call stack must have the privilege before the call is
     * allowed.
     *  
     * @return the context classloader associated with the current thread,
     * or null if security doesn't allow it.
     * 
     * @throws LogConfigurationException if there was some weird error while
     * attempting to get the context classloader.
     * 
     * @throws SecurityException if the current java security policy doesn't
     * allow this class to access the context classloader.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.262 -0500", hash_original_method = "7256493EBAA0CD15571FBFA48D348BB6", hash_generated_method = "2E0B3E0B30DDC2E2195A8055D9CC2DBC")
    
protected static ClassLoader getContextClassLoader()
        throws LogConfigurationException {

        return (ClassLoader)AccessController.doPrivileged(
            new PrivilegedAction() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.817 -0400", hash_original_method = "CC8D432FB8D4020AEB8C8338ACBC2698", hash_generated_method = "09495409ACE85CF005FE4A9BD919B2A8")
            
public Object run() {
                    return directGetContextClassLoader();
                }
            });
    }

    /**
     * Return the thread context class loader if available; otherwise return 
     * null. 
     * <p>
     * Most/all code should call getContextClassLoader rather than calling
     * this method directly.
     * <p>
     * The thread context class loader is available for JDK 1.2
     * or later, if certain security conditions are met.
     * <p>
     * Note that no internal logging is done within this method because
     * this method is called every time LogFactory.getLogger() is called,
     * and we don't want too much output generated here.
     * 
     * @exception LogConfigurationException if a suitable class loader
     * cannot be identified.
     * 
     * @exception SecurityException if the java security policy forbids
     * access to the context classloader from one of the classes in the
     * current call stack. 
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.265 -0500", hash_original_method = "3AF672CB82A96AB2C340076756939FD9", hash_generated_method = "07E0FCDE8FA0307D1485229931A2840A")
    
protected static ClassLoader directGetContextClassLoader()
        throws LogConfigurationException
    {
        ClassLoader classLoader = null;

        try {
            // Are we running on a JDK 1.2 or later system?
            Method method = Thread.class.getMethod("getContextClassLoader", 
                    (Class[]) null);

            // Get the thread context class loader (if there is one)
            try {
                classLoader = (ClassLoader)method.invoke(Thread.currentThread(), 
                        (Object[]) null);
            } catch (IllegalAccessException e) {
                throw new LogConfigurationException
                    ("Unexpected IllegalAccessException", e);
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
            classLoader = getClassLoader(LogFactory.class);

            // We deliberately don't log a message here to outputStream;
            // this message would be output for every call to LogFactory.getLog()
            // when running on JDK1.1
            //
            // if (outputStream != null) {
            //    outputStream.println(
            //        "Method Thread.getContextClassLoader does not exist;"
            //         + " assuming this is JDK 1.1, and that the context"
            //         + " classloader is the same as the class that loaded"
            //         + " the concrete LogFactory class.");
            // }
            
        }

        // Return the selected class loader
        return classLoader;
    }

    /**
     * Check cached factories (keyed by contextClassLoader)
     *
     * @param contextClassLoader is the context classloader associated
     * with the current thread. This allows separate LogFactory objects
     * per component within a container, provided each component has
     * a distinct context classloader set. This parameter may be null
     * in JDK1.1, and in embedded systems where jcl-using code is
     * placed in the bootclasspath.
     * 
     * @return the factory associated with the specified classloader if
     * one has previously been created, or null if this is the first time
     * we have seen this particular classloader.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.267 -0500", hash_original_method = "A56069BFC3164E04069C579E1352C071", hash_generated_method = "C6257C81B9805CB643698CCD873C5C26")
    
private static LogFactory getCachedFactory(ClassLoader contextClassLoader)
    {
        LogFactory factory = null;

        if (contextClassLoader == null) {
            // We have to handle this specially, as factories is a Hashtable
            // and those don't accept null as a key value.
            //
            // nb: nullClassLoaderFactory might be null. That's ok.
            factory = nullClassLoaderFactory;
        } else {
            factory = (LogFactory) factories.get(contextClassLoader);
        }

        return factory;
    }

    /**
     * Remember this factory, so later calls to LogFactory.getCachedFactory
     * can return the previously created object (together with all its
     * cached Log objects).
     *
     * @param classLoader should be the current context classloader. Note that
     * this can be null under some circumstances; this is ok.
     *
     * @param factory should be the factory to cache. This should never be null.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.270 -0500", hash_original_method = "70047EA0D2501A673893EF14AF73F944", hash_generated_method = "BE9AC6CFF1A525FB6D155E729F9356AF")
    
private static void cacheFactory(ClassLoader classLoader, LogFactory factory)
    {
        // Ideally we would assert(factory != null) here. However reporting
        // errors from within a logging implementation is a little tricky!

        if (factory != null) {
            if (classLoader == null) {
                nullClassLoaderFactory = factory;
            } else {
                factories.put(classLoader, factory);
            }
        }
    }

    /**
     * Return a new instance of the specified <code>LogFactory</code>
     * implementation class, loaded by the specified class loader.
     * If that fails, try the class loader used to load this
     * (abstract) LogFactory.
     * <p>
     * <h2>ClassLoader conflicts</h2>
     * Note that there can be problems if the specified ClassLoader is not the 
     * same as the classloader that loaded this class, ie when loading a
     * concrete LogFactory subclass via a context classloader.
     * <p>
     * The problem is the same one that can occur when loading a concrete Log
     * subclass via a context classloader.
     * <p>
     * The problem occurs when code running in the context classloader calls
     * class X which was loaded via a parent classloader, and class X then calls
     * LogFactory.getFactory (either directly or via LogFactory.getLog). Because
     * class X was loaded via the parent, it binds to LogFactory loaded via
     * the parent. When the code in this method finds some LogFactoryYYYY
     * class in the child (context) classloader, and there also happens to be a
     * LogFactory class defined in the child classloader, then LogFactoryYYYY
     * will be bound to LogFactory@childloader. It cannot be cast to
     * LogFactory@parentloader, ie this method cannot return the object as
     * the desired type. Note that it doesn't matter if the LogFactory class
     * in the child classloader is identical to the LogFactory class in the
     * parent classloader, they are not compatible.
     * <p>
     * The solution taken here is to simply print out an error message when
     * this occurs then throw an exception. The deployer of the application
     * must ensure they remove all occurrences of the LogFactory class from
     * the child classloader in order to resolve the issue. Note that they
     * do not have to move the custom LogFactory subclass; that is ok as
     * long as the only LogFactory class it can find to bind to is in the
     * parent classloader.
     * <p>
     * @param factoryClass Fully qualified name of the <code>LogFactory</code>
     *  implementation class
     * @param classLoader ClassLoader from which to load this class
     * @param contextClassLoader is the context that this new factory will
     * manage logging for.
     *
     * @exception LogConfigurationException if a suitable instance
     *  cannot be created
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.276 -0500", hash_original_method = "3C92C15D8716C4492FE58B34AC4039A4", hash_generated_method = "CA7D8B094C93A5A7E96B76FDACAAE197")
    
protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader,
                                           final ClassLoader contextClassLoader)
        throws LogConfigurationException
    {
        // Note that any unchecked exceptions thrown by the createFactory
        // method will propagate out of this method; in particular a
        // ClassCastException can be thrown.
        Object result = AccessController.doPrivileged(
            new PrivilegedAction() {
                @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.820 -0400", hash_original_method = "60109351B608528E3600C5258D32BD0A", hash_generated_method = "884631075227E4A903BB0567EAA61524")
            
public Object run() {
                    return createFactory(factoryClass, classLoader);
                }
            });

        if (result instanceof LogConfigurationException) {
            LogConfigurationException ex = (LogConfigurationException) result;
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "An error occurred while loading the factory class:"
                        + ex.getMessage());
            }
            throw ex;
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic(
                    "Created object " + objectId(result)
                    + " to manage classloader " + objectId(contextClassLoader));
        }
        return (LogFactory)result;
    }

    /**
     * Method provided for backwards compatibility; see newFactory version that
     * takes 3 parameters.
     * <p>
     * This method would only ever be called in some rather odd situation.
     * Note that this method is static, so overriding in a subclass doesn't
     * have any effect unless this method is called from a method in that
     * subclass. However this method only makes sense to use from the
     * getFactory method, and as that is almost always invoked via
     * LogFactory.getFactory, any custom definition in a subclass would be
     * pointless. Only a class with a custom getFactory method, then invoked
     * directly via CustomFactoryImpl.getFactory or similar would ever call
     * this. Anyway, it's here just in case, though the "managed class loader"
     * value output to the diagnostics will not report the correct value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.279 -0500", hash_original_method = "92B08F82D4447E8C4BFC572942D5BA89", hash_generated_method = "5B31D345E6F789CEB3F306D029BF81BD")
    
protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader) {
	    return newFactory(factoryClass, classLoader, null);
    }

    /**
     * Implements the operations described in the javadoc for newFactory.
     * 
     * @param factoryClass
     * 
     * @param classLoader used to load the specified factory class. This is
     * expected to be either the TCCL or the classloader which loaded this
     * class. Note that the classloader which loaded this class might be
     * "null" (ie the bootloader) for embedded systems.
     * 
     * @return either a LogFactory object or a LogConfigurationException object.
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.284 -0500", hash_original_method = "1CC93C4114E498627BCA082B19335D5F", hash_generated_method = "94F3947077CFB19F3E506E84BF030F83")
    
protected static Object createFactory(String factoryClass, ClassLoader classLoader) {

        // This will be used to diagnose bad configurations
        // and allow a useful message to be sent to the user
        Class logFactoryClass = null;
        try {
            if (classLoader != null) {
                try {
                    // First the given class loader param (thread class loader)

                    // Warning: must typecast here & allow exception
                    // to be generated/caught & recast properly.
                    logFactoryClass = classLoader.loadClass(factoryClass);
                    if (LogFactory.class.isAssignableFrom(logFactoryClass)) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Loaded class " + logFactoryClass.getName()
                                    + " from classloader " + objectId(classLoader));
                        }
                    } else {
                        //
                        // This indicates a problem with the ClassLoader tree.
                        // An incompatible ClassLoader was used to load the 
                        // implementation. 
                        // As the same classes
                        // must be available in multiple class loaders,
                        // it is very likely that multiple JCL jars are present.
                        // The most likely fix for this
                        // problem is to remove the extra JCL jars from the 
                        // ClassLoader hierarchy. 
                        //
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Factory class " + logFactoryClass.getName()
                                + " loaded from classloader " + objectId(logFactoryClass.getClassLoader())
                                + " does not extend '" + LogFactory.class.getName()
                                + "' as loaded by this classloader.");
                            logHierarchy("[BAD CL TREE] ", classLoader);
                        }
                    }
                    
                    return (LogFactory) logFactoryClass.newInstance();

                } catch (ClassNotFoundException ex) {
                    if (classLoader == thisClassLoader) {
                        // Nothing more to try, onwards.
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Unable to locate any class called '" + factoryClass
                                    + "' via classloader " + objectId(classLoader));
                        }
                        throw ex;
                    }
                    // ignore exception, continue
                } catch (NoClassDefFoundError e) {
                    if (classLoader == thisClassLoader) {
                        // Nothing more to try, onwards.
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Class '" + factoryClass + "' cannot be loaded"
                                    + " via classloader " + objectId(classLoader)
                                    + " - it depends on some other class that cannot"
                                    + " be found.");
                        }
                        throw e;
                    }
                    // ignore exception, continue
                } catch(ClassCastException e) {
                    if (classLoader == thisClassLoader) {
                        // There's no point in falling through to the code below that
                        // tries again with thisClassLoader, because we've just tried
                        // loading with that loader (not the TCCL). Just throw an
                        // appropriate exception here.

                    	final boolean implementsLogFactory = implementsLogFactory(logFactoryClass);
                        
                        //
                        // Construct a good message: users may not actual expect that a custom implementation 
                        // has been specified. Several well known containers use this mechanism to adapt JCL 
                        // to their native logging system. 
                        // 
                        String msg = 
                            "The application has specified that a custom LogFactory implementation should be used but " +
                            "Class '" + factoryClass + "' cannot be converted to '"
                            + LogFactory.class.getName() + "'. ";
                        if (implementsLogFactory) {
                            msg = msg + "The conflict is caused by the presence of multiple LogFactory classes in incompatible classloaders. " +
                    		"Background can be found in http://jakarta.apache.org/commons/logging/tech.html. " +
                    		"If you have not explicitly specified a custom LogFactory then it is likely that " +
                    		"the container has set one without your knowledge. " +
                    		"In this case, consider using the commons-logging-adapters.jar file or " +
                    		"specifying the standard LogFactory from the command line. ";
                        } else {
                        	msg = msg + "Please check the custom implementation. ";
                        }
                        msg = msg + "Help can be found @http://jakarta.apache.org/commons/logging/troubleshooting.html.";
                        
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(msg);
                        }
                        
                        ClassCastException ex = new ClassCastException(msg);
                        throw ex;
                    }
                    
                    // Ignore exception, continue. Presumably the classloader was the
                    // TCCL; the code below will try to load the class via thisClassLoader.
                    // This will handle the case where the original calling class is in
                    // a shared classpath but the TCCL has a copy of LogFactory and the
                    // specified LogFactory implementation; we will fall back to using the
                    // LogFactory implementation from the same classloader as this class.
                    //
                    // Issue: this doesn't handle the reverse case, where this LogFactory
                    // is in the webapp, and the specified LogFactory implementation is
                    // in a shared classpath. In that case:
                    // (a) the class really does implement LogFactory (bad log msg above)
                    // (b) the fallback code will result in exactly the same problem.
                }
            }

            /* At this point, either classLoader == null, OR
             * classLoader was unable to load factoryClass.
             *
             * In either case, we call Class.forName, which is equivalent
             * to LogFactory.class.getClassLoader().load(name), ie we ignore
             * the classloader parameter the caller passed, and fall back
             * to trying the classloader associated with this class. See the
             * javadoc for the newFactory method for more info on the 
             * consequences of this.
             *
             * Notes:
             * * LogFactory.class.getClassLoader() may return 'null'
             *   if LogFactory is loaded by the bootstrap classloader.
             */
            // Warning: must typecast here & allow exception
            // to be generated/caught & recast properly.
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                    "Unable to load factory class via classloader " 
                    + objectId(classLoader)
                    + " - trying the classloader associated with this LogFactory.");
            }
            logFactoryClass = Class.forName(factoryClass);
            return (LogFactory) logFactoryClass.newInstance();
        } catch (Exception e) {
            // Check to see if we've got a bad configuration
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Unable to create LogFactory instance.");
            }
            if (logFactoryClass != null
                && !LogFactory.class.isAssignableFrom(logFactoryClass)) {
                
                return new LogConfigurationException(
                    "The chosen LogFactory implementation does not extend LogFactory."
                    + " Please check your configuration.",
                    e);
            }
            return new LogConfigurationException(e);
        }
    }

    /**
     * Determines whether the given class actually implements <code>LogFactory</code>.
     * Diagnostic information is also logged.
     * <p>
     * <strong>Usage:</strong> to diagnose whether a classloader conflict is the cause
     * of incompatibility. The test used is whether the class is assignable from
     * the <code>LogFactory</code> class loaded by the class's classloader.
     * @param logFactoryClass <code>Class</code> which may implement <code>LogFactory</code>
     * @return true if the <code>logFactoryClass</code> does extend
     * <code>LogFactory</code> when that class is loaded via the same
     * classloader that loaded the <code>logFactoryClass</code>.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.287 -0500", hash_original_method = "9E9B3F33140C2FD522BF5D0E76D4CFF1", hash_generated_method = "1A62B6752C21BD03839E0B0B6F746EB5")
    
private static boolean implementsLogFactory(Class logFactoryClass) {
        boolean implementsLogFactory = false;
        if (logFactoryClass != null) {
            try {
                ClassLoader logFactoryClassLoader = logFactoryClass.getClassLoader();
                if (logFactoryClassLoader == null) {
                    logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
                } else {
                    logHierarchy("[CUSTOM LOG FACTORY] ", logFactoryClassLoader);
                    Class factoryFromCustomLoader
                        = Class.forName("org.apache.commons.logging.LogFactory", false, logFactoryClassLoader);
                    implementsLogFactory = factoryFromCustomLoader.isAssignableFrom(logFactoryClass);
                    if (implementsLogFactory) {
                        logDiagnostic("[CUSTOM LOG FACTORY] " + logFactoryClass.getName()
                                + " implements LogFactory but was loaded by an incompatible classloader.");
                    } else {
                        logDiagnostic("[CUSTOM LOG FACTORY] " + logFactoryClass.getName()
                                + " does not implement LogFactory.");
                    }
                }
            } catch (SecurityException e) {
                //
                // The application is running within a hostile security environment.
                // This will make it very hard to diagnose issues with JCL.
                // Consider running less securely whilst debugging this issue.
                //
                logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether " +
                        "the compatibility was caused by a classloader conflict: "
                        + e.getMessage());
            } catch (LinkageError e) {
                //
                // This should be an unusual circumstance.
                // LinkageError's usually indicate that a dependent class has incompatibly changed.
                // Another possibility may be an exception thrown by an initializer.
                // Time for a clean rebuild?
                //
                logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether " +
                        "the compatibility was caused by a classloader conflict: "
                        + e.getMessage());
            } catch (ClassNotFoundException e) {
                //
                // LogFactory cannot be loaded by the classloader which loaded the custom factory implementation.
                // The custom implementation is not viable until this is corrected.
                // Ensure that the JCL jar and the custom class are available from the same classloader.
                // Running with diagnostics on should give information about the classloaders used
                // to load the custom factory.
                //
                logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the " +
                        "custom LogFactory implementation. Is the custom factory in the right classloader?");
            }
        }
        return implementsLogFactory;
    }

    /**
     * Applets may run in an environment where accessing resources of a loader is
     * a secure operation, but where the commons-logging library has explicitly
     * been granted permission for that operation. In this case, we need to 
     * run the operation using an AccessController.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.292 -0500", hash_original_method = "0498E2FA4E88B0B584C1C528E3B901A8", hash_generated_method = "B4858C8F544596DF2C1D8AF938F467DC")
    
private static InputStream getResourceAsStream(final ClassLoader loader,
                                                   final String name)
    {
        return (InputStream)AccessController.doPrivileged(
            new PrivilegedAction() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.827 -0400", hash_original_method = "6C33A3D7269BB0697C16109AACE184F6", hash_generated_method = "EE829866F2C383A7D811E4FD79905994")
            
public Object run() {
                    if (loader != null) {
                        return loader.getResourceAsStream(name);
                    } else {
                        return ClassLoader.getSystemResourceAsStream(name);
                    }
                }
            });
    }

    /**
     * Given a filename, return an enumeration of URLs pointing to
     * all the occurrences of that filename in the classpath.
     * <p>
     * This is just like ClassLoader.getResources except that the
     * operation is done under an AccessController so that this method will
     * succeed when this jarfile is privileged but the caller is not.
     * This method must therefore remain private to avoid security issues.
     * <p>
     * If no instances are found, an Enumeration is returned whose
     * hasMoreElements method returns false (ie an "empty" enumeration).
     * If resources could not be listed for some reason, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.299 -0500", hash_original_method = "A2F29F4C35DC94060573F2DA357EEBF8", hash_generated_method = "C5ADB01290D2354FF391E1783A86EF4C")
    
private static Enumeration getResources(final ClassLoader loader,
            final String name)
    {
        PrivilegedAction action = 
            new PrivilegedAction() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.829 -0400", hash_original_method = "183FF88C7AC96FD1E9A2F611522B9A25", hash_generated_method = "6E55A156071C0861638E5ABDE594FF12")
            
public Object run() {
                    try {
                        if (loader != null) {
                            return loader.getResources(name);
                        } else {
                            return ClassLoader.getSystemResources(name);
                        }
                    } catch(IOException e) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                "Exception while trying to find configuration file "
                                + name + ":" + e.getMessage());
                        }
                        return null;
                    } catch(NoSuchMethodError e) {
                        // we must be running on a 1.1 JVM which doesn't support
                        // ClassLoader.getSystemResources; just return null in
                        // this case.
                        return null;
                    }
                }
            };
        Object result = AccessController.doPrivileged(action);
        return (Enumeration) result;
    }

    /**
     * Given a URL that refers to a .properties file, load that file.
     * This is done under an AccessController so that this method will
     * succeed when this jarfile is privileged but the caller is not.
     * This method must therefore remain private to avoid security issues.
     * <p>
     * Null is returned if the URL cannot be opened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.305 -0500", hash_original_method = "71E2C0704554AE9E687BED49AB0F5251", hash_generated_method = "9D53EC50F5D78282410DAE4996DE9F10")
    
private static Properties getProperties(final URL url) {
        PrivilegedAction action = 
            new PrivilegedAction() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.831 -0400", hash_original_method = "0B5CD98DC6A7F99271D20C530D7C6283", hash_generated_method = "837EEF7D5476EE8D72900B7AA608D0F4")
            
public Object run() {
                    try {
                        InputStream stream = url.openStream();
                        if (stream != null) {
                            Properties props = new Properties();
                            props.load(stream);
                            stream.close();
                            return props;
                        }
                    } catch(IOException e) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic("Unable to read URL " + url);
                        }
                    }

                    return null;
                }
            };
        return (Properties) AccessController.doPrivileged(action);
    }

    /**
     * Locate a user-provided configuration file.
     * <p>
     * The classpath of the specified classLoader (usually the context classloader)
     * is searched for properties files of the specified name. If none is found,
     * null is returned. If more than one is found, then the file with the greatest
     * value for its PRIORITY property is returned. If multiple files have the
     * same PRIORITY value then the first in the classpath is returned.
     * <p> 
     * This differs from the 1.0.x releases; those always use the first one found.
     * However as the priority is a new field, this change is backwards compatible.
     * <p>
     * The purpose of the priority field is to allow a webserver administrator to
     * override logging settings in all webapps by placing a commons-logging.properties
     * file in a shared classpath location with a priority > 0; this overrides any
     * commons-logging.properties files without priorities which are in the
     * webapps. Webapps can also use explicit priorities to override a configuration
     * file in the shared classpath if needed. 
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.309 -0500", hash_original_method = "7DE9F3F0C3643EF9168BBA0425C15953", hash_generated_method = "8C2EDDBC3FE50A6648874505FBBE5C85")
    
private static final Properties getConfigurationFile(
            ClassLoader classLoader, String fileName) {

        Properties props = null;
        double priority = 0.0;
        URL propsUrl = null;
        try {
            Enumeration urls = getResources(classLoader, fileName);

            if (urls == null) {
                return null;
            }
            
            while (urls.hasMoreElements()) {
                URL url = (URL) urls.nextElement();
                
                Properties newProps = getProperties(url);
                if (newProps != null) {
                    if (props == null) {
                        propsUrl = url; 
                        props = newProps;
                        String priorityStr = props.getProperty(PRIORITY_KEY);
                        priority = 0.0;
                        if (priorityStr != null) {
                            priority = Double.parseDouble(priorityStr);
                        }

                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                "[LOOKUP] Properties file found at '" + url + "'"
                                + " with priority " + priority); 
                        }
                    } else {
                        String newPriorityStr = newProps.getProperty(PRIORITY_KEY);
                        double newPriority = 0.0;
                        if (newPriorityStr != null) {
                            newPriority = Double.parseDouble(newPriorityStr);
                        }

                        if (newPriority > priority) {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic(
                                    "[LOOKUP] Properties file at '" + url + "'"
                                    + " with priority " + newPriority 
                                    + " overrides file at '" + propsUrl + "'"
                                    + " with priority " + priority);
                            }

                            propsUrl = url; 
                            props = newProps;
                            priority = newPriority;
                        } else {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic(
                                    "[LOOKUP] Properties file at '" + url + "'"
                                    + " with priority " + newPriority 
                                    + " does not override file at '" + propsUrl + "'"
                                    + " with priority " + priority);
                            }
                        }
                    }

                }
            }
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("SecurityException thrown while trying to find/read config files.");
            }
        }

        if (isDiagnosticsEnabled()) {
            if (props == null) {
                logDiagnostic(
                    "[LOOKUP] No properties file of name '" + fileName
                    + "' found.");
            } else {
                logDiagnostic(
                    "[LOOKUP] Properties file of name '" + fileName
                    + "' found at '" + propsUrl + '"');
            }
        }

        return props;
    }

    /**
     * Determines whether the user wants internal diagnostic output. If so,
     * returns an appropriate writer object. Users can enable diagnostic
     * output by setting the system property named {@link #DIAGNOSTICS_DEST_PROPERTY} to
     * a filename, or the special values STDOUT or STDERR. 
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.312 -0500", hash_original_method = "BB706202832664F36987A29B6723E314", hash_generated_method = "572798DAC5565ADBAB50961C38124BF7")
    
private static void initDiagnostics() {
        String dest;
    	try {
    	    dest = System.getProperty(DIAGNOSTICS_DEST_PROPERTY);
    	    if (dest == null) {
    	        return;
    	    }
    	} catch(SecurityException ex) {
    	    // We must be running in some very secure environment.
    	    // We just have to assume output is not wanted..
    	    return;
    	}
    	
    	if (dest.equals("STDOUT")) {
    	    diagnosticsStream = System.out;
    	} else if (dest.equals("STDERR")) {
    	    diagnosticsStream = System.err;
    	} else {
    	    try {
                // open the file in append mode
    	        FileOutputStream fos = new FileOutputStream(dest, true);
    	        diagnosticsStream = new PrintStream(fos);
    	    } catch(IOException ex) {
    	        // We should report this to the user - but how?
    	        return;
    	    }
    	}

        // In order to avoid confusion where multiple instances of JCL are
        // being used via different classloaders within the same app, we
        // ensure each logged message has a prefix of form
        // [LogFactory from classloader OID]
        //
        // Note that this prefix should be kept consistent with that 
        // in LogFactoryImpl. However here we don't need to output info
        // about the actual *instance* of LogFactory, as all methods that
        // output diagnostics from this class are static.
        String classLoaderName;
        try {
            ClassLoader classLoader = thisClassLoader;
            if (thisClassLoader == null) {
                classLoaderName = "BOOTLOADER";
            } else {
                classLoaderName = objectId(classLoader);
            }
        } catch(SecurityException e) {
            classLoaderName = "UNKNOWN";
        }
        diagnosticPrefix = "[LogFactory from " + classLoaderName + "] ";
    }

    /**
     * Indicates true if the user has enabled internal logging.
     * <p>
     * By the way, sorry for the incorrect grammar, but calling this method
     * areDiagnosticsEnabled just isn't java beans style.
     * 
     * @return true if calls to logDiagnostic will have any effect.
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.314 -0500", hash_original_method = "ECB5C3B5CB855729F51EA9DA0FE1F709", hash_generated_method = "AB011A018E3B404B4D21F064623D0A42")
    
protected static boolean isDiagnosticsEnabled() {
        return diagnosticsStream != null;
    }

    /**
     * Write the specified message to the internal logging destination.
     * <p>
     * Note that this method is private; concrete subclasses of this class
     * should not call it because the diagnosticPrefix string this
     * method puts in front of all its messages is LogFactory@....,
     * while subclasses should put SomeSubClass@...
     * <p>
     * Subclasses should instead compute their own prefix, then call
     * logRawDiagnostic. Note that calling isDiagnosticsEnabled is
     * fine for subclasses.
     * <p>
     * Note that it is safe to call this method before initDiagnostics
     * is called; any output will just be ignored (as isDiagnosticsEnabled
     * will return false).
     * 
     * @param msg is the diagnostic message to be output.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.317 -0500", hash_original_method = "236FA7D434741B1A7CF02D845E091B05", hash_generated_method = "5D6EBC1AA6B4939FB9BB8311FA342699")
    
private static final void logDiagnostic(String msg) {
        if (diagnosticsStream != null) {
            diagnosticsStream.print(diagnosticPrefix);
            diagnosticsStream.println(msg);
            diagnosticsStream.flush();
        }
    }

    /**
     * Write the specified message to the internal logging destination.
     * 
     * @param msg is the diagnostic message to be output.
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.319 -0500", hash_original_method = "075757868D9F05D5BCB9F5AF64703AEB", hash_generated_method = "DDC4768F4C15EC5CEA03AD7277AA6403")
    
protected static final void logRawDiagnostic(String msg) {
        if (diagnosticsStream != null) {
            diagnosticsStream.println(msg);
            diagnosticsStream.flush();
        }
    }

    /**
     * Generate useful diagnostics regarding the classloader tree for
     * the specified class.
     * <p>
     * As an example, if the specified class was loaded via a webapp's
     * classloader, then you may get the following output:
     * <pre>
     * Class com.acme.Foo was loaded via classloader 11111
     * ClassLoader tree: 11111 -> 22222 (SYSTEM) -> 33333 -> BOOT 
     * </pre>
     * <p>
     * This method returns immediately if isDiagnosticsEnabled()
     * returns false.
     * 
     * @param clazz is the class whose classloader + tree are to be
     * output.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.322 -0500", hash_original_method = "E38F65D38D4D4B93D1A623DA076AB427", hash_generated_method = "B75AF62EB3787E7C63E2F853C1B93F8C")
    
private static void logClassLoaderEnvironment(Class clazz) {
        if (!isDiagnosticsEnabled()) {
            return;
        }
        
        try {
            logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
            logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
        } catch(SecurityException ex) {
            logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
        }
        
        String className = clazz.getName();
        ClassLoader classLoader;
        
        try {
            classLoader = getClassLoader(clazz);
        } catch(SecurityException ex) {
            // not much useful diagnostics we can print here!
            logDiagnostic(
                "[ENV] Security forbids determining the classloader for " + className);
            return;
        }

        logDiagnostic(
            "[ENV] Class " + className + " was loaded via classloader "
            + objectId(classLoader));
        logHierarchy("[ENV] Ancestry of classloader which loaded " + className + " is ", classLoader);
    }

    /**
     * Logs diagnostic messages about the given classloader
     * and it's hierarchy. The prefix is prepended to the message
     * and is intended to make it easier to understand the logs.
     * @param prefix 
     * @param classLoader
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.325 -0500", hash_original_method = "319AE7233CD27CBEA6DD860B25C7C22F", hash_generated_method = "FD4600DB6D8CFB08BF6C0AE2DAA3D58B")
    
private static void logHierarchy(String prefix, ClassLoader classLoader) {
        if (!isDiagnosticsEnabled()) {
            return;
        }
        ClassLoader systemClassLoader;
        if (classLoader != null) {
            final String classLoaderString = classLoader.toString();
            logDiagnostic(prefix + objectId(classLoader) + " == '" + classLoaderString + "'");
        }
        
        try {
            systemClassLoader = ClassLoader.getSystemClassLoader();
        } catch(SecurityException ex) {
            logDiagnostic(
                    prefix + "Security forbids determining the system classloader.");
            return;
        }        
        if (classLoader != null) {
            StringBuffer buf = new StringBuffer(prefix + "ClassLoader tree:");
            for(;;) {
                buf.append(objectId(classLoader));
                if (classLoader == systemClassLoader) {
                    buf.append(" (SYSTEM) ");
                }

                try {
                    classLoader = classLoader.getParent();
                } catch(SecurityException ex) {
                    buf.append(" --> SECRET");
                    break;
                }

                buf.append(" --> ");
                if (classLoader == null) {
                    buf.append("BOOT");
                    break;
                }
            }
            logDiagnostic(buf.toString());
        }
    }

    /**
     * Returns a string that uniquely identifies the specified object, including
     * its class.
     * <p>
     * The returned string is of form "classname@hashcode", ie is the same as
     * the return value of the Object.toString() method, but works even when
     * the specified object's class has overidden the toString method.
     * 
     * @param o may be null.
     * @return a string of form classname@hashcode, or "null" if param o is null.
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.328 -0500", hash_original_method = "292B7DCBCC7BDB4A508EA54DA0D8814E", hash_generated_method = "C2216A916252A9D3C3FCA262EADE2095")
    
public static String objectId(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.getClass().getName() + "@" + System.identityHashCode(o);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.180 -0500", hash_original_field = "F2B914B72B6C791BFE4F04E459705519", hash_generated_field = "D39AFAD27EED39D02E35F26FB5566E86")

    /**
     * The name (<code>priority</code>) of the key in the config file used to 
     * specify the priority of that particular config file. The associated value 
     * is a floating-point number; higher values take priority over lower values.
     */
    public static final String PRIORITY_KEY = "priority";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.183 -0500", hash_original_field = "EA65387D8CE020B6FCFE47C1F6BD853A", hash_generated_field = "BA01E062102B079BBF63D15DBC3413CC")

    public static final String TCCL_KEY = "use_tccl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.185 -0500", hash_original_field = "F321625E044214FC9D7BB20444763920", hash_generated_field = "11D26AB77645C1028DCD1B23280DFF25")

    public static final String FACTORY_PROPERTY =
        "org.apache.commons.logging.LogFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.188 -0500", hash_original_field = "AA636AA6DD85F557D515DDBAA1E7F6DE", hash_generated_field = "F345A9589B47EE896ADF27E2B65BF2CA")

    public static final String FACTORY_DEFAULT =
        "org.apache.commons.logging.impl.LogFactoryImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.192 -0500", hash_original_field = "82DA8AC3CABB85377945756531886020", hash_generated_field = "B4211EE3317940F3DF5F8CBEDEE45D44")

    public static final String FACTORY_PROPERTIES =
        "commons-logging.properties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.194 -0500", hash_original_field = "19CAF8D678720A49F9AE17E62879C664", hash_generated_field = "097B030A4686AB60D9E88B759DEB8807")

    protected static final String SERVICE_ID =
        "META-INF/services/org.apache.commons.logging.LogFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.197 -0500", hash_original_field = "E337B5F62BEE17C82F47F8CA94B78B4F", hash_generated_field = "6A8778658C9B0B4DE94213091D0DE3B3")

    public static final String DIAGNOSTICS_DEST_PROPERTY =
        "org.apache.commons.logging.diagnostics.dest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.199 -0500", hash_original_field = "F1327D35B5494F9D0A710F56F7D54B61", hash_generated_field = "502D4A8426F2D567358D7FA7868419EB")

    private static PrintStream diagnosticsStream = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.201 -0500", hash_original_field = "F9B1BC72E6214E8224C6F6C21C66489A", hash_generated_field = "50207E8543E2F4B02545B1FC7108DCA6")

    private static String diagnosticPrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.204 -0500", hash_original_field = "BA8444F748143AB174653AB404269F7E", hash_generated_field = "D6581D8C069D3D0B5FC9CCEC021029A7")

    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY =
        "org.apache.commons.logging.LogFactory.HashtableImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.208 -0500", hash_original_field = "994861C31CD9B4A7200F02B8D9E12BB0", hash_generated_field = "3F8062920D2835FF30BF3946833B7D74")

    private static final String WEAK_HASHTABLE_CLASSNAME = 
        "org.apache.commons.logging.impl.WeakHashtable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.210 -0500", hash_original_field = "DBEAA857754828E731DF8A1311E0C4F0", hash_generated_field = "59780F9C7686D986D4425308AC009E0C")

    private static ClassLoader thisClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.232 -0500", hash_original_field = "E39DFF69014CBC33B78403839A43A4BD", hash_generated_field = "0DD8D5F36915FC414889E9F489834DBF")

    /**
     * The previously constructed <code>LogFactory</code> instances, keyed by
     * the <code>ClassLoader</code> with which it was created.
     */
    protected static Hashtable factories = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.234 -0500", hash_original_field = "73719A90D2704AAFF5EAB74BC7EC69A3", hash_generated_field = "D7891BCD06A51439A7F138B7BA8EB96E")

    protected static LogFactory nullClassLoaderFactory = null;
    
    // ----------------------------------------------------------- Constructors

    /**
     * Protected constructor that is not available for public use.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.213 -0500", hash_original_method = "F774CEA84649DC0B4D4BCA84E3BCF878", hash_generated_method = "60F099FEF67CE9E15E6D08D1618F5B3A")
    
protected LogFactory() {
    }
    
    // --------------------------------------------------------- Public Methods

    /**
     * Return the configuration attribute with the specified name (if any),
     * or <code>null</code> if there is no such attribute.
     *
     * @param name Name of the attribute to return
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.215 -0500", hash_original_method = "FCC4022F9438D02A03EAF9E0461B0B3B", hash_generated_method = "9607117A4C58FE37636FB3C445473F6C")
    
public abstract Object getAttribute(String name);

    /**
     * Return an array containing the names of all currently defined
     * configuration attributes.  If there are no such attributes, a zero
     * length array is returned.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.217 -0500", hash_original_method = "B483E463AD782788123AFB164C362A6B", hash_generated_method = "31D18C91D6F792C33F89EF815037FEE0")
    
public abstract String[] getAttributeNames();

    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.220 -0500", hash_original_method = "F4C3B8BB2CEF85EE0F12ADFC26E0DE54", hash_generated_method = "69F22EA425FE790B5B6947FF5AF247DA")
    
public abstract Log getInstance(Class clazz)
        throws LogConfigurationException;

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
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.222 -0500", hash_original_method = "C15C7EE976772EFCE731ED8180CFFC13", hash_generated_method = "E6B297E296FDBE84568CEE36B2D70207")
    
public abstract Log getInstance(String name)
        throws LogConfigurationException;

    /**
     * Release any internal references to previously created {@link Log}
     * instances returned by this factory.  This is useful in environments
     * like servlet containers, which implement application reloading by
     * throwing away a ClassLoader.  Dangling references to objects in that
     * class loader would prevent garbage collection.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.224 -0500", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "6DFA7D15E7B71D240B8AE9B1CDC7676A")
    
public abstract void release();

    /**
     * Remove any configuration attribute associated with the specified name.
     * If there is no such attribute, no action is taken.
     *
     * @param name Name of the attribute to remove
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.227 -0500", hash_original_method = "F2B1C6370498677CAD1FF1E7C1667F22", hash_generated_method = "9E20905C9741F4DC53902FA8DF269B39")
    
public abstract void removeAttribute(String name);

    /**
     * Set the configuration attribute with the specified name.  Calling
     * this with a <code>null</code> value is equivalent to calling
     * <code>removeAttribute(name)</code>.
     *
     * @param name Name of the attribute to set
     * @param value Value of the attribute to set, or <code>null</code>
     *  to remove any setting for this attribute
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:52.229 -0500", hash_original_method = "1F863C3C4F056307A6C164B0CC924493", hash_generated_method = "AFB2A798D58B4DB15FE29BA9093D5023")
    
public abstract void setAttribute(String name, Object value);
    static {
        thisClassLoader = getClassLoader(LogFactory.class);
        initDiagnostics();
        logClassLoaderEnvironment(LogFactory.class);
        factories = createFactoryStore();
        if (isDiagnosticsEnabled()) {
            logDiagnostic("BOOTSTRAP COMPLETED");
        }
    }
    
}

