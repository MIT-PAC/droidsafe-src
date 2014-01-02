package java.util.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;

import libcore.io.IoUtils;





public class LogManager {

    /**
     * Get the {@code LoggingMXBean} instance. this implementation always throws
     * an UnsupportedOperationException.
     *
     * @return the {@code LoggingMXBean} instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.302 -0500", hash_original_method = "99854C4284B9CB15C4C88E0DA2C68A20", hash_generated_method = "101D71F5F72FF6847144D9317C1745CB")
    
public static LoggingMXBean getLoggingMXBean() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get the global {@code LogManager} instance.
     *
     * @return the global {@code LogManager} instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.332 -0500", hash_original_method = "A967B00D3DC6A3CAC3067F3E0F5EBD2C", hash_generated_method = "A8A0D9D76BC0BA7CD058F572364881A7")
    
public static LogManager getLogManager() {
        return manager;
    }

    // use SystemClassLoader to load class from system classpath
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.340 -0500", hash_original_method = "21F4C1CFC4B65A9FB0283C382E57CCB7", hash_generated_method = "3B039A712FF28C3D9C5FBCD2C43AB5F5")
    
static Object getInstanceByClass(final String className) {
        try {
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(className);
            return clazz.newInstance();
        } catch (Exception e) {
            try {
                Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
                return clazz.newInstance();
            } catch (Exception innerE) {
                System.err.println("Loading class '" + className + "' failed");
                System.err.println(innerE);
                return null;
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.295 -0500", hash_original_field = "AE812773678C5169CC54CF246C32C189", hash_generated_field = "6DBE4148F2B32574633325AE3FB2F9F9")

    private static final LoggingPermission perm = new LoggingPermission("control", null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.297 -0500", hash_original_field = "ECE20837B4038EE2ACD579A6068BD82B", hash_generated_field = "60A931CC8E2121C9AF9FC8AFF4714295")

    static LogManager manager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.300 -0500", hash_original_field = "D40E787098BFE5C021DEA7E8F2B496C9", hash_generated_field = "A7D53AAA4BF83E2F2365813530C06BF1")

    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.305 -0500", hash_original_field = "F759F3D265EB9B5E75A8C890E71F1AC5", hash_generated_field = "AD370BFFC6E9AB83396CFA02133C2A08")

    private Hashtable<String, Logger> loggers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.307 -0500", hash_original_field = "A04F2373B5C8259109CCAEC0C63AAEB1", hash_generated_field = "C2D8C40A30BA03E4CF83D1B1429A651D")

    private Properties props;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.309 -0500", hash_original_field = "83A69C0A6B959D9FD4B02E07F651A62C", hash_generated_field = "3B43FF39F7B726230E736460CF0CFA39")

    private PropertyChangeSupport listeners;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.194 -0400", hash_original_method = "F83269E1889FF9DC50A0440D3CD9234B", hash_generated_method = "25A4D420CCA8D659CCCCE116BE659C0D")
    protected  LogManager() {
        loggers = new Hashtable<String, Logger>();
        props = new Properties();
        listeners = new PropertyChangeSupport(this);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.313 -0500", hash_original_method = "1836317CB8E0A5E5B172790642D1742E", hash_generated_method = "30E88919FA9218D5953BCBD0F9CAD1EA")
            
@Override public void run() {
                reset();
            }
});
        // ---------- Original Method ----------
        //loggers = new Hashtable<String, Logger>();
        //props = new Properties();
        //listeners = new PropertyChangeSupport(this);
        //Runtime.getRuntime().addShutdownHook(new Thread() {
            //@Override public void run() {
                //reset();
            //}
        //});
    }

    /**
     * Does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.318 -0500", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "8989A8C3AFF2A9F4B72793CB60A6C44F")
    
public void checkAccess() {
    }

    /**
     * Add a given logger into the hierarchical namespace. The
     * {@code Logger.addLogger()} factory methods call this method to add newly
     * created Logger. This returns false if a logger with the given name has
     * existed in the namespace
     * <p>
     * Note that the {@code LogManager} may only retain weak references to
     * registered loggers. In order to prevent {@code Logger} objects from being
     * unexpectedly garbage collected it is necessary for <i>applications</i>
     * to maintain references to them.
     * </p>
     *
     * @param logger
     *            the logger to be added.
     * @return true if the given logger is added into the namespace
     *         successfully, false if the given logger exists in the namespace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.321 -0500", hash_original_method = "9E275E191101B6346DE13876068F41E1", hash_generated_method = "377F62B00AC3CF147EA10A2C9C5B5B0E")
    
public synchronized boolean addLogger(Logger logger) {
        String name = logger.getName();
        if (loggers.get(name) != null) {
            return false;
        }
        addToFamilyTree(logger, name);
        loggers.put(name, logger);
        logger.setManager(this);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.325 -0500", hash_original_method = "0070D539A38F64AFDE25421AB7DE8DFA", hash_generated_method = "4DF9866F898C0A5E16C6456AB2E5C863")
    
private void addToFamilyTree(Logger logger, String name) {
        Logger parent = null;
        // find parent
        int lastSeparator;
        String parentName = name;
        while ((lastSeparator = parentName.lastIndexOf('.')) != -1) {
            parentName = parentName.substring(0, lastSeparator);
            parent = loggers.get(parentName);
            if (parent != null) {
                setParent(logger, parent);
                break;
            } else if (getProperty(parentName + ".level") != null ||
                    getProperty(parentName + ".handlers") != null) {
                parent = Logger.getLogger(parentName);
                setParent(logger, parent);
                break;
            }
        }
        if (parent == null && (parent = loggers.get("")) != null) {
            setParent(logger, parent);
        }

        // find children
        // TODO: performance can be improved here?
        String nameDot = name + '.';
        Collection<Logger> allLoggers = loggers.values();
        for (final Logger child : allLoggers) {
            Logger oldParent = child.getParent();
            if (parent == oldParent && (name.length() == 0 || child.getName().startsWith(nameDot))) {
                final Logger thisLogger = logger;
                child.setParent(thisLogger);
                if (oldParent != null) {
                    // -- remove from old parent as the parent has been changed
                    oldParent.children.remove(child);
                }
            }
        }
    }

    /**
     * Get the logger with the given name.
     *
     * @param name
     *            name of logger
     * @return logger with given name, or {@code null} if nothing is found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.327 -0500", hash_original_method = "7CC5CB7CA011BF34DBD2626C5B91D261", hash_generated_method = "F20E4986C2983349E2180B4EE3433DEF")
    
public synchronized Logger getLogger(String name) {
        return loggers.get(name);
    }

    /**
     * Get a {@code Enumeration} of all registered logger names.
     *
     * @return enumeration of registered logger names
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.329 -0500", hash_original_method = "A3ADDC952F848C9366B53F69C5A416F6", hash_generated_method = "CEF5D0F650774B176491F6A4150D0276")
    
public synchronized Enumeration<String> getLoggerNames() {
        return loggers.keys();
    }

    /**
     * Get the value of property with given name.
     *
     * @param name
     *            the name of property
     * @return the value of property
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.334 -0500", hash_original_method = "308A02382C1792AE136BBB31488FF7DC", hash_generated_method = "5A74B7D64213EFDDA9B0FD0847C7ABD3")
    
public String getProperty(String name) {
        return props.getProperty(name);
    }

    /**
     * Re-initialize the properties and configuration. The initialization
     * process is same as the {@code LogManager} instantiation.
     * <p>
     * Notice : No {@code PropertyChangeEvent} are fired.
     * </p>
     *
     * @throws IOException
     *             if any IO related problems happened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.337 -0500", hash_original_method = "F9E79871CB75749F3B3C682DFBEA7367", hash_generated_method = "48AA3805D9F1A0AA40E2666DF06657AA")
    
public void readConfiguration() throws IOException {
        // check config class
        String configClassName = System.getProperty("java.util.logging.config.class");
        if (configClassName == null || getInstanceByClass(configClassName) == null) {
            // if config class failed, check config file
            String configFile = System.getProperty("java.util.logging.config.file");

            if (configFile == null) {
                // if cannot find configFile, use default logging.properties
                configFile = System.getProperty("java.home") + File.separator + "lib" +
                        File.separator + "logging.properties";
            }

            InputStream input = null;
            try {
                try {
                    input = new FileInputStream(configFile);
                } catch (IOException exception) {
                    // fall back to using the built-in logging.properties file
                    input = LogManager.class.getResourceAsStream("logging.properties");
                    if (input == null) {
                        throw exception;
                    }
                }
                readConfiguration(new BufferedInputStream(input));
            } finally {
                IoUtils.closeQuietly(input);
            }
        }
    }

    // actual initialization process from a given input stream
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.343 -0500", hash_original_method = "5AA730DC7CE7051A789AED9B260AEA08", hash_generated_method = "8F7F768A4F1D4F4C3D64E643628F12B3")
    
private synchronized void readConfigurationImpl(InputStream ins)
            throws IOException {
        reset();
        props.load(ins);

        // The RI treats the root logger as special. For compatibility, always
        // update the root logger's handlers.
        Logger root = loggers.get("");
        if (root != null) {
            root.setManager(this);
        }

        // parse property "config" and apply setting
        String configs = props.getProperty("config");
        if (configs != null) {
            StringTokenizer st = new StringTokenizer(configs, " ");
            while (st.hasMoreTokens()) {
                String configerName = st.nextToken();
                getInstanceByClass(configerName);
            }
        }

        // set levels for logger
        Collection<Logger> allLoggers = loggers.values();
        for (Logger logger : allLoggers) {
            String property = props.getProperty(logger.getName() + ".level");
            if (property != null) {
                logger.setLevel(Level.parse(property));
            }
        }
        listeners.firePropertyChange(null, null, null);
    }

    /**
     * Re-initialize the properties and configuration from the given
     * {@code InputStream}
     * <p>
     * Notice : No {@code PropertyChangeEvent} are fired.
     * </p>
     *
     * @param ins
     *            the input stream
     * @throws IOException
     *             if any IO related problems happened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.346 -0500", hash_original_method = "0B5A5DFDBB36281B5E8835796DD30069", hash_generated_method = "B5BDD569EEFC40E6B7CDCC9621A45E10")
    
public void readConfiguration(InputStream ins) throws IOException {
        checkAccess();
        readConfigurationImpl(ins);
    }

    /**
     * Reset configuration.
     *
     * <p>All handlers are closed and removed from any named loggers. All loggers'
     * level is set to null, except the root logger's level is set to
     * {@code Level.INFO}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.349 -0500", hash_original_method = "C7F5D5A126D3CC9BC9332DC327B04AA6", hash_generated_method = "9CD2567A4C7F1831D7A2E0915FE7FA53")
    
public synchronized void reset() {
        checkAccess();
        props = new Properties();
        Enumeration<String> names = getLoggerNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            Logger logger = getLogger(name);
            if (logger != null) {
                logger.reset();
            }
        }
        Logger root = loggers.get("");
        if (root != null) {
            root.setLevel(Level.INFO);
        }
    }

    /**
     * Add a {@code PropertyChangeListener}, which will be invoked when
     * the properties are reread.
     *
     * @param l
     *            the {@code PropertyChangeListener} to be added.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.351 -0500", hash_original_method = "89AE29101867526E131C7EEE62325170", hash_generated_method = "13773548A085574F10C55BEF24ACA20E")
    
public void addPropertyChangeListener(PropertyChangeListener l) {
        if (l == null) {
            throw new NullPointerException();
        }
        checkAccess();
        listeners.addPropertyChangeListener(l);
    }

    /**
     * Remove a {@code PropertyChangeListener}, do nothing if the given
     * listener is not found.
     *
     * @param l
     *            the {@code PropertyChangeListener} to be removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.353 -0500", hash_original_method = "C0D7CB274D3F753AA28C566B595F1403", hash_generated_method = "342854F1A23657D47924FBC283C5A3EF")
    
public void removePropertyChangeListener(PropertyChangeListener l) {
        checkAccess();
        listeners.removePropertyChangeListener(l);
    }

    /**
     * Returns a named logger associated with the supplied resource bundle.
     *
     * @param resourceBundleName the resource bundle to associate, or null for
     *      no associated resource bundle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.356 -0500", hash_original_method = "B934C7BD7B62C355AF995C71D51E6416", hash_generated_method = "76B6DA62C524B74BADD1C23ED9CD543A")
    
synchronized Logger getOrCreate(String name, String resourceBundleName) {
        Logger result = getLogger(name);
        if (result == null) {
            result = new Logger(name, resourceBundleName);
            addLogger(result);
        }
        return result;
    }


    /**
     * Sets the parent of this logger in the namespace. Callers must first
     * {@link #checkAccess() check security}.
     *
     * @param newParent
     *            the parent logger to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.358 -0500", hash_original_method = "B8E057E50526DE42F5AE7CC32A8A2058", hash_generated_method = "835D86530730D8F4B31B5F48538A6CE6")
    
synchronized void setParent(Logger logger, Logger newParent) {
        logger.parent = newParent;

        if (logger.levelObjVal == null) {
            setLevelRecursively(logger, null);
        }
        newParent.children.add(logger);
        logger.updateDalvikLogHandler();
    }

    /**
     * Sets the level on {@code logger} to {@code newLevel}. Any child loggers
     * currently inheriting their level from {@code logger} will be updated
     * recursively.
     *
     * @param newLevel the new minimum logging threshold. If null, the logger's
     *      parent level will be used; or {@code Level.INFO} for loggers with no
     *      parent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:36.360 -0500", hash_original_method = "46EC17C11FD929B8108F5C206F2B42C8", hash_generated_method = "290BA8FBB47E6FFD68986B67FDA11B6C")
    
synchronized void setLevelRecursively(Logger logger, Level newLevel) {
        int previous = logger.levelIntVal;
        logger.levelObjVal = newLevel;

        if (newLevel == null) {
            logger.levelIntVal = logger.parent != null
                    ? logger.parent.levelIntVal
                    : Level.INFO.intValue();
        } else {
            logger.levelIntVal = newLevel.intValue();
        }

        if (previous != logger.levelIntVal) {
            for (Logger child : logger.children) {
                if (child.levelObjVal == null) {
                    setLevelRecursively(child, null);
                }
            }
        }
    }
    static {
        String className = System.getProperty("java.util.logging.manager");
        if (className != null) {
            manager = (LogManager) getInstanceByClass(className);
        }
        if (manager == null) {
            manager = new LogManager();
        }
        try {
            manager.readConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger root = new Logger("", null);
        root.setLevel(Level.INFO);
        Logger.global.setParent(root);
        manager.addLogger(root);
        manager.addLogger(Logger.global);
    }
    
}

