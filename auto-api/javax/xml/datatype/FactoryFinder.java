package javax.xml.datatype;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import libcore.io.IoUtils;

final class FactoryFinder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.459 -0400", hash_original_method = "7B7719B12A7C6C3FB4A57C9E537309B5", hash_generated_method = "70C8AB5057BD93D35BF5340AED7D1084")
    private  FactoryFinder() {
        // ---------- Original Method ----------
    }

    
    private static void debugPrintln(String msg) {
        if (debug) {
            System.err.println(
                CLASS_NAME
                + ":"
                + msg);
        }
    }

    
    private static ClassLoader findClassLoader() throws ConfigurationError {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (debug) debugPrintln(
            "Using context class loader: "
            + classLoader);
        if (classLoader == null) {
            classLoader = FactoryFinder.class.getClassLoader();
            if (debug) debugPrintln(
                "Using the class loader of FactoryFinder: "
                + classLoader);
        }
        return classLoader;
    }

    
    static Object newInstance(
        String className,
        ClassLoader classLoader) throws ConfigurationError {
        try {
            Class spiClass;
            if (classLoader == null) {
                spiClass = Class.forName(className);
            } else {
                spiClass = classLoader.loadClass(className);
            }
            if (debug) {
                debugPrintln("Loaded " + className + " from " + which(spiClass));
            }
            return spiClass.newInstance();
        } catch (ClassNotFoundException x) {
            throw new ConfigurationError(
                "Provider " + className + " not found", x);
        } catch (Exception x) {
            throw new ConfigurationError(
                "Provider " + className + " could not be instantiated: " + x, x);
        }
    }

    
    static Object find(String factoryId, String fallbackClassName) throws ConfigurationError {
        ClassLoader classLoader = findClassLoader();
        String systemProp = System.getProperty(factoryId);
        if (systemProp != null && systemProp.length() > 0) {
            if (debug) debugPrintln("found " + systemProp + " in the system property " + factoryId);
            return newInstance(systemProp, classLoader);
        }
        try {
            String javah = System.getProperty("java.home");
            String configFile = javah + File.separator + "lib" + File.separator + "jaxp.properties";
            String factoryClassName = null;
            if (firstTime) {
                synchronized (cacheProps) {
                    if (firstTime) {
                        File f = new File(configFile);
                        firstTime = false;
                        if (f.exists()) {
                            if (debug) debugPrintln("Read properties file " + f);
                            cacheProps.load(new FileInputStream(f));
                        }
                    }
                }
            }
            factoryClassName = cacheProps.getProperty(factoryId);
            if (debug) debugPrintln("found " + factoryClassName + " in $java.home/jaxp.properties");
            if (factoryClassName != null) {
                return newInstance(factoryClassName, classLoader);
            }
        } catch (Exception ex) {
            if (debug) {
                ex.printStackTrace();
            }
        }
        Object provider = findJarServiceProvider(factoryId);
        if (provider != null) {
            return provider;
        }
        if (fallbackClassName == null) {
            throw new ConfigurationError(
                "Provider for " + factoryId + " cannot be found", null);
        }
        if (debug) debugPrintln("loaded from fallback value: " + fallbackClassName);
        return newInstance(fallbackClassName, classLoader);
    }

    
    private static Object findJarServiceProvider(String factoryId) throws ConfigurationError {
        String serviceId = "META-INF/services/" + factoryId;
        InputStream is = null;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl != null) {
            is = cl.getResourceAsStream(serviceId);
        }
        if (is == null) {
            cl = FactoryFinder.class.getClassLoader();
            is = cl.getResourceAsStream(serviceId);
        }
        if (is == null) {
            return null;
        }
        if (debug) debugPrintln("found jar resource=" + serviceId + " using ClassLoader: " + cl);
        BufferedReader rd;
        try {
            rd = new BufferedReader(new InputStreamReader(is, "UTF-8"), DEFAULT_LINE_LENGTH);
        } catch (java.io.UnsupportedEncodingException e) {
            rd = new BufferedReader(new InputStreamReader(is), DEFAULT_LINE_LENGTH);
        }
        String factoryClassName = null;
        try {
            factoryClassName = rd.readLine();
        } catch (IOException x) {
            return null;
        } finally {
            IoUtils.closeQuietly(rd);
        }
        if (factoryClassName != null &&
            ! "".equals(factoryClassName)) {
            if (debug) debugPrintln("found in resource, value="
                   + factoryClassName);
            return newInstance(factoryClassName, cl);
        }
        return null;
    }

    
    private static String which(Class clazz) {
        try {
            String classnameAsResource = clazz.getName().replace('.', '/') + ".class";
            ClassLoader loader = clazz.getClassLoader();
            URL it;
            if (loader != null) {
                it = loader.getResource(classnameAsResource);
            } else {
                it = ClassLoader.getSystemResource(classnameAsResource);
            }
            if (it != null) {
                return it.toString();
            }
        }
        catch (VirtualMachineError vme) {
            throw vme;
        }
        catch (ThreadDeath td) {
            throw td;
        }
        catch (Throwable t) {
            if (debug) {
                t.printStackTrace();
            }
        }
        return "unknown location";
    }

    
    static class ConfigurationError extends Error {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.460 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

        private Exception exception;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_method = "7384B234A714BB22DC7261536CC3F908", hash_generated_method = "301B0F070193DBE1E3BF73ECEDB48381")
          ConfigurationError(String msg, Exception x) {
            super(msg);
            this.exception = x;
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //this.exception = x;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "F82A39E40DA1CC7D9DFB9F3220989874")
         Exception getException() {
            Exception varB4EAC82CA7396A68D541C85D26508E83_689508038 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_689508038 = exception;
            varB4EAC82CA7396A68D541C85D26508E83_689508038.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_689508038;
            // ---------- Original Method ----------
            //return exception;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_field = "3968FBA132ACBD465B09E199D411A859", hash_generated_field = "F8222E9B0B6C0CF5ED69A500318A4223")

        private static final long serialVersionUID = -3644413026244211347L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_field = "9BBF649F31FC36A0CC4592961633E64F", hash_generated_field = "0A5FDC909C600BF1870C0D6CAB4BE2B6")

    private static final String CLASS_NAME = "javax.xml.datatype.FactoryFinder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_field = "3E160F8191A128BF71278081784675C8", hash_generated_field = "A32CF2309396233D2A1E4D89C9258CB7")

    private static boolean debug = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_field = "52A4BA4FC2AFEF64548D9B073D8EB3FB", hash_generated_field = "EE2E2F9952B07BED0E6A6FFE9E5E0C17")

    private static Properties cacheProps = new Properties();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_field = "A7893FAED7826B5857859A98202AF417", hash_generated_field = "F95055A903FED9629579B0455BF06A85")

    private static boolean firstTime = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.461 -0400", hash_original_field = "3AA22EFBCA2B88350AC8EC73F7CB96D8", hash_generated_field = "09DCCD316B3E885E246889B10781D5FA")

    private static final int DEFAULT_LINE_LENGTH = 80;
    static {
        String val = System.getProperty("jaxp.debug");
        debug = val != null && (! "false".equals(val));
    }
    
}

