package org.apache.commons.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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

public abstract class LogFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.999 -0400", hash_original_method = "F774CEA84649DC0B4D4BCA84E3BCF878", hash_generated_method = "A8E7489E7B239B2C7DA374E4667D6148")
    protected  LogFactory() {
        
    }

    
    public abstract Object getAttribute(String name);

    
    public abstract String[] getAttributeNames();

    
    public abstract Log getInstance(Class clazz)
        throws LogConfigurationException;

    
    public abstract Log getInstance(String name)
        throws LogConfigurationException;

    
    public abstract void release();

    
    public abstract void removeAttribute(String name);

    
    public abstract void setAttribute(String name, Object value);

    
        private static final Hashtable createFactoryStore() {
        Hashtable result = null;
        String storeImplementationClass 
            = System.getProperty(HASHTABLE_IMPLEMENTATION_PROPERTY);
        if (storeImplementationClass == null) {
            storeImplementationClass = WEAK_HASHTABLE_CLASSNAME;
        }
        try {
            Class implementationClass = Class.forName(storeImplementationClass);
            result = (Hashtable) implementationClass.newInstance();
        } catch (Throwable t) {
            if (!WEAK_HASHTABLE_CLASSNAME.equals(storeImplementationClass)) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                } else {
                    System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
                }
            }
        }
        if (result == null) {
            result = new Hashtable();
        }
        return result;
    }

    
        public static LogFactory getFactory() throws LogConfigurationException {
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Context classloader is null.");
            }
        }
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
        Properties props = getConfigurationFile(contextClassLoader, FACTORY_PROPERTIES);
        ClassLoader baseClassLoader = contextClassLoader;
        if (props != null) {
            String useTCCLStr = props.getProperty(TCCL_KEY);
            if (useTCCLStr != null) {
                if (Boolean.valueOf(useTCCLStr).booleanValue() == false) {
                    baseClassLoader = thisClassLoader; 
                }
            }
        }
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
            ;  
        } catch(RuntimeException e) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                        "[LOOKUP] An exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + e.getMessage().trim()
                        + "] as specified by a system property.");
            }
            throw e;
        }
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
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(
                            "[LOOKUP] No resource file with name '" + SERVICE_ID
                            + "' found.");
                    }
                }
            } catch( Exception ex ) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(
                        "[LOOKUP] A security exception occurred while trying to create an"
                        + " instance of the custom factory class"
                        + ": [" + ex.getMessage().trim()
                        + "]. Trying alternative implementations...");
                }
                ; 
            }
        }
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
        if (factory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                "[LOOKUP] Loading the default LogFactory implementation '" + FACTORY_DEFAULT
                + "' via the same classloader that loaded this LogFactory"
                + " class (ie not looking in the context classloader).");
            }
            factory = newFactory(FACTORY_DEFAULT, thisClassLoader, contextClassLoader);
        }
        if (factory != null) {
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

    
        public static Log getLog(Class clazz) throws LogConfigurationException {
        return getLog(clazz.getName());
    }

    
        public static Log getLog(String name) throws LogConfigurationException {
        return new org.apache.commons.logging.impl.Jdk14Logger(name);
    }

    
        @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
    protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        return (ClassLoader)AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    return directGetContextClassLoader();
                }
            });
    }

    
        @DSModeled(DSC.BAN)
    protected static ClassLoader directGetContextClassLoader() throws LogConfigurationException {
        ClassLoader classLoader = null;
        try {
            Method method = Thread.class.getMethod("getContextClassLoader", 
                    (Class[]) null);
            try {
                classLoader = (ClassLoader)method.invoke(Thread.currentThread(), 
                        (Object[]) null);
            } catch (IllegalAccessException e) {
                throw new LogConfigurationException
                    ("Unexpected IllegalAccessException", e);
            } catch (InvocationTargetException e) {
                if (e.getTargetException() instanceof SecurityException) {
                    ;  
                } else {
                    throw new LogConfigurationException
                        ("Unexpected InvocationTargetException", e.getTargetException());
                }
            }
        } catch (NoSuchMethodException e) {
            classLoader = getClassLoader(LogFactory.class);
        }
        return classLoader;
    }

    
        @DSModeled(DSC.BAN)
    private static LogFactory getCachedFactory(ClassLoader contextClassLoader) {
        LogFactory factory = null;
        if (contextClassLoader == null) {
            factory = nullClassLoaderFactory;
        } else {
            factory = (LogFactory) factories.get(contextClassLoader);
        }
        return factory;
    }

    
        @DSModeled(DSC.BAN)
    private static void cacheFactory(ClassLoader classLoader, LogFactory factory) {
        if (factory != null) {
            if (classLoader == null) {
                nullClassLoaderFactory = factory;
            } else {
                factories.put(classLoader, factory);
            }
        }
    }

    
        protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader,
                                           final ClassLoader contextClassLoader) throws LogConfigurationException {
        Object result = AccessController.doPrivileged(
            new PrivilegedAction() {
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

    
        protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader) {
        return newFactory(factoryClass, classLoader, null);
    }

    
        @DSModeled(DSC.BAN)
    protected static Object createFactory(String factoryClass, ClassLoader classLoader) {
        Class logFactoryClass = null;
        try {
            if (classLoader != null) {
                try {
                    logFactoryClass = classLoader.loadClass(factoryClass);
                    if (LogFactory.class.isAssignableFrom(logFactoryClass)) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Loaded class " + logFactoryClass.getName()
                                    + " from classloader " + objectId(classLoader));
                        }
                    } else {
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
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Unable to locate any class called '" + factoryClass
                                    + "' via classloader " + objectId(classLoader));
                        }
                        throw ex;
                    }
                } catch (NoClassDefFoundError e) {
                    if (classLoader == thisClassLoader) {
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(
                                    "Class '" + factoryClass + "' cannot be loaded"
                                    + " via classloader " + objectId(classLoader)
                                    + " - it depends on some other class that cannot"
                                    + " be found.");
                        }
                        throw e;
                    }
                } catch(ClassCastException e) {
                    if (classLoader == thisClassLoader) {
                    	final boolean implementsLogFactory = implementsLogFactory(logFactoryClass);
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
                }
            }
            if (isDiagnosticsEnabled()) {
                logDiagnostic(
                    "Unable to load factory class via classloader " 
                    + objectId(classLoader)
                    + " - trying the classloader associated with this LogFactory.");
            }
            logFactoryClass = Class.forName(factoryClass);
            return (LogFactory) logFactoryClass.newInstance();
        } catch (Exception e) {
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
                logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether " +
                        "the compatibility was caused by a classloader conflict: "
                        + e.getMessage());
            } catch (LinkageError e) {
                logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether " +
                        "the compatibility was caused by a classloader conflict: "
                        + e.getMessage());
            } catch (ClassNotFoundException e) {
                logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the " +
                        "custom LogFactory implementation. Is the custom factory in the right classloader?");
            }
        }
        return implementsLogFactory;
    }

    
        private static InputStream getResourceAsStream(final ClassLoader loader,
                                                   final String name) {
        return (InputStream)AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    if (loader != null) {
                        return loader.getResourceAsStream(name);
                    } else {
                        return ClassLoader.getSystemResourceAsStream(name);
                    }
                }
            });
    }

    
        private static Enumeration getResources(final ClassLoader loader,
            final String name) {
        PrivilegedAction action = 
            new PrivilegedAction() {
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
                        return null;
                    }
                }
            };
        Object result = AccessController.doPrivileged(action);
        return (Enumeration) result;
    }

    
        private static Properties getProperties(final URL url) {
        PrivilegedAction action = 
            new PrivilegedAction() {
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

    
        private static void initDiagnostics() {
        String dest;
        try {
    	    dest = System.getProperty(DIAGNOSTICS_DEST_PROPERTY);
    	    if (dest == null) {
    	        return;
    	    }
    	} catch(SecurityException ex) {
    	    return;
    	}
        if (dest.equals("STDOUT")) {
    	    diagnosticsStream = System.out;
    	} else if (dest.equals("STDERR")) {
    	    diagnosticsStream = System.err;
    	} else {
    	    try {
    	        FileOutputStream fos = new FileOutputStream(dest, true);
    	        diagnosticsStream = new PrintStream(fos);
    	    } catch(IOException ex) {
    	        return;
    	    }
    	}
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

    
        @DSModeled(DSC.SAFE)
    protected static boolean isDiagnosticsEnabled() {
        return diagnosticsStream != null;
    }

    
        private static final void logDiagnostic(String msg) {
        if (diagnosticsStream != null) {
            diagnosticsStream.print(diagnosticPrefix);
            diagnosticsStream.println(msg);
            diagnosticsStream.flush();
        }
    }

    
        protected static final void logRawDiagnostic(String msg) {
        if (diagnosticsStream != null) {
            diagnosticsStream.println(msg);
            diagnosticsStream.flush();
        }
    }

    
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
            logDiagnostic(
                "[ENV] Security forbids determining the classloader for " + className);
            return;
        }
        logDiagnostic(
            "[ENV] Class " + className + " was loaded via classloader "
            + objectId(classLoader));
        logHierarchy("[ENV] Ancestry of classloader which loaded " + className + " is ", classLoader);
    }

    
        @DSModeled(DSC.BAN)
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

    
        public static String objectId(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.getClass().getName() + "@" + System.identityHashCode(o);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.004 -0400", hash_original_field = "C204A9B59300974326208E4CDAAE19D1", hash_generated_field = "1E5E53EF4DC914F529A3609C0F88BF62")

    public static final String PRIORITY_KEY = "priority";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.004 -0400", hash_original_field = "300F4DBFFA7891677949497F9E506653", hash_generated_field = "BA01E062102B079BBF63D15DBC3413CC")

    public static final String TCCL_KEY = "use_tccl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.004 -0400", hash_original_field = "0BDD01E9DB208B8382588D96385B1AF5", hash_generated_field = "11D26AB77645C1028DCD1B23280DFF25")

    public static final String FACTORY_PROPERTY =
        "org.apache.commons.logging.LogFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "F525BACEEBDBBBDE83858C7AC7E5C6BD", hash_generated_field = "F345A9589B47EE896ADF27E2B65BF2CA")

    public static final String FACTORY_DEFAULT =
        "org.apache.commons.logging.impl.LogFactoryImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "A408860A600424928531920305A936A6", hash_generated_field = "B4211EE3317940F3DF5F8CBEDEE45D44")

    public static final String FACTORY_PROPERTIES =
        "commons-logging.properties";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "90B4E58079F1D9D0D9DAC17B54272960", hash_generated_field = "097B030A4686AB60D9E88B759DEB8807")

    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "9A9D1BC218D6C73F887406CEC02601FD", hash_generated_field = "6A8778658C9B0B4DE94213091D0DE3B3")

    public static final String DIAGNOSTICS_DEST_PROPERTY =
        "org.apache.commons.logging.diagnostics.dest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "3889CA185E89F644935C6B6A0BE1B6A8", hash_generated_field = "502D4A8426F2D567358D7FA7868419EB")

    private static PrintStream diagnosticsStream = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "12E9A3CB39556B526310F08DE8C2A838", hash_generated_field = "50207E8543E2F4B02545B1FC7108DCA6")

    private static String diagnosticPrefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "6315DD8A75BE0327DA3A155FD6357E12", hash_generated_field = "D6581D8C069D3D0B5FC9CCEC021029A7")

    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY =
        "org.apache.commons.logging.LogFactory.HashtableImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "10A47EEBECB467F525A615F207CF8490", hash_generated_field = "3F8062920D2835FF30BF3946833B7D74")

    private static final String WEAK_HASHTABLE_CLASSNAME = "org.apache.commons.logging.impl.WeakHashtable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "8CBE7E518BFACE3BBC6F8B5E38467F8F", hash_generated_field = "59780F9C7686D986D4425308AC009E0C")

    private static ClassLoader thisClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "C9ACB1071BA9E80750C401CC668D1337", hash_generated_field = "E19D6CB1141429FE2CFD096492E04245")

    protected static Hashtable factories = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.005 -0400", hash_original_field = "483E32A11E7D7FDDE0FD1E8601D0C5AC", hash_generated_field = "D7891BCD06A51439A7F138B7BA8EB96E")

    protected static LogFactory nullClassLoaderFactory = null;
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

