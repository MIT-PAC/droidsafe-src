package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.317 -0400", hash_original_field = "E3744F330069AC8D2BE40C0CB5EFBDB6", hash_generated_field = "AD370BFFC6E9AB83396CFA02133C2A08")

    private Hashtable<String, Logger> loggers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.318 -0400", hash_original_field = "50FE03AB7BF37089A7E88DA9B31FFB3B", hash_generated_field = "C2D8C40A30BA03E4CF83D1B1429A651D")

    private Properties props;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.318 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "3B43FF39F7B726230E736460CF0CFA39")

    private PropertyChangeSupport listeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.323 -0400", hash_original_method = "F83269E1889FF9DC50A0440D3CD9234B", hash_generated_method = "10DAE76C254C0DAB59601107802B0A1B")
    protected  LogManager() {
        loggers = new Hashtable<String, Logger>();
        props = new Properties();
        listeners = new PropertyChangeSupport(this);
        Runtime.getRuntime().addShutdownHook(new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.323 -0400", hash_original_method = "1836317CB8E0A5E5B172790642D1742E", hash_generated_method = "59D9E72089082C0A3CB03237A4A6EC42")
            @Override
            public void run() {
                reset();
                // ---------- Original Method ----------
                //reset();
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

    
        public static LoggingMXBean getLoggingMXBean() {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.323 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "C308BE0846D76E01A367023713D9A840")
    public void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.334 -0400", hash_original_method = "9E275E191101B6346DE13876068F41E1", hash_generated_method = "A5332C7ECCD207E55D83FE8554F9C2D6")
    public synchronized boolean addLogger(Logger logger) {
        String name;
        name = logger.getName();
        {
            boolean var8D9B5EDD22D5E90786B9DFCF2C7B2FED_1076018204 = (loggers.get(name) != null);
        } //End collapsed parenthetic
        addToFamilyTree(logger, name);
        loggers.put(name, logger);
        logger.setManager(this);
        addTaint(logger.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637721760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637721760;
        // ---------- Original Method ----------
        //String name = logger.getName();
        //if (loggers.get(name) != null) {
            //return false;
        //}
        //addToFamilyTree(logger, name);
        //loggers.put(name, logger);
        //logger.setManager(this);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.419 -0400", hash_original_method = "0070D539A38F64AFDE25421AB7DE8DFA", hash_generated_method = "E9D530F3ECFB010154C75ED6F095F6CD")
    private void addToFamilyTree(Logger logger, String name) {
        Logger parent;
        parent = null;
        int lastSeparator;
        String parentName;
        parentName = name;
        {
            boolean var24311821043CD386ECA987B6ED2E2081_1318911553 = ((lastSeparator = parentName.lastIndexOf('.')) != -1);
            {
                parentName = parentName.substring(0, lastSeparator);
                parent = loggers.get(parentName);
                {
                    setParent(logger, parent);
                } //End block
                {
                    boolean var436F2D49C8476C95F0FD5686A4212BC7_35299598 = (getProperty(parentName + ".level") != null ||
                    getProperty(parentName + ".handlers") != null);
                    {
                        parent = Logger.getLogger(parentName);
                        setParent(logger, parent);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE7420F5B75328DBDF911BFB1BBFE9320_1556395921 = (parent == null && (parent = loggers.get("")) != null);
            {
                setParent(logger, parent);
            } //End block
        } //End collapsed parenthetic
        String nameDot;
        nameDot = name + '.';
        Collection<Logger> allLoggers;
        allLoggers = loggers.values();
        {
            Iterator<Logger> var4A013FF40FFB4353AFEDD6717288ACC8_1584967075 = (allLoggers).iterator();
            var4A013FF40FFB4353AFEDD6717288ACC8_1584967075.hasNext();
            final Logger child = var4A013FF40FFB4353AFEDD6717288ACC8_1584967075.next();
            {
                Logger oldParent;
                oldParent = child.getParent();
                {
                    boolean varEE86372CE9D50F853F7F62A388B74232_344194615 = (parent == oldParent && (name.length() == 0 || child.getName().startsWith(nameDot)));
                    {
                        Logger thisLogger;
                        thisLogger = logger;
                        child.setParent(thisLogger);
                        {
                            oldParent.children.remove(child);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(logger.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.420 -0400", hash_original_method = "7CC5CB7CA011BF34DBD2626C5B91D261", hash_generated_method = "DC409A183238D0B3C4E0541F159E0D2B")
    public synchronized Logger getLogger(String name) {
        Logger varB4EAC82CA7396A68D541C85D26508E83_1505334483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1505334483 = loggers.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1505334483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1505334483;
        // ---------- Original Method ----------
        //return loggers.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.447 -0400", hash_original_method = "A3ADDC952F848C9366B53F69C5A416F6", hash_generated_method = "AF8153F3B54253D987B84C3BE5378731")
    public synchronized Enumeration<String> getLoggerNames() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_1994819746 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1994819746 = loggers.keys();
        varB4EAC82CA7396A68D541C85D26508E83_1994819746.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994819746;
        // ---------- Original Method ----------
        //return loggers.keys();
    }

    
        public static LogManager getLogManager() {
        return manager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.448 -0400", hash_original_method = "308A02382C1792AE136BBB31488FF7DC", hash_generated_method = "E71637BAD0BD7E7CB1462D06F7A82CD0")
    public String getProperty(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_389956887 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_389956887 = props.getProperty(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_389956887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_389956887;
        // ---------- Original Method ----------
        //return props.getProperty(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.449 -0400", hash_original_method = "F9E79871CB75749F3B3C682DFBEA7367", hash_generated_method = "1936DFBE678C68FD8FA2754F6DA76D27")
    public void readConfiguration() throws IOException {
        String configClassName;
        configClassName = System.getProperty("java.util.logging.config.class");
        {
            boolean varDD1F3D94E4BF22F8C21B8724834F5A99_896521976 = (configClassName == null || getInstanceByClass(configClassName) == null);
            {
                String configFile;
                configFile = System.getProperty("java.util.logging.config.file");
                {
                    configFile = System.getProperty("java.home") + File.separator + "lib" +
                        File.separator + "logging.properties";
                } //End block
                InputStream input;
                input = null;
                try 
                {
                    try 
                    {
                        input = new FileInputStream(configFile);
                    } //End block
                    catch (IOException exception)
                    {
                        input = LogManager.class.getResourceAsStream("logging.properties");
                        {
                            if (DroidSafeAndroidRuntime.control) throw exception;
                        } //End block
                    } //End block
                    readConfiguration(new BufferedInputStream(input));
                } //End block
                finally 
                {
                    IoUtils.closeQuietly(input);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.567 -0400", hash_original_method = "5AA730DC7CE7051A789AED9B260AEA08", hash_generated_method = "DA1DF0B4EF37DE84EB9354146146179C")
    private synchronized void readConfigurationImpl(InputStream ins) throws IOException {
        reset();
        props.load(ins);
        Logger root;
        root = loggers.get("");
        {
            root.setManager(this);
        } //End block
        String configs;
        configs = props.getProperty("config");
        {
            StringTokenizer st;
            st = new StringTokenizer(configs, " ");
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_969899591 = (st.hasMoreTokens());
                {
                    String configerName;
                    configerName = st.nextToken();
                    getInstanceByClass(configerName);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Collection<Logger> allLoggers;
        allLoggers = loggers.values();
        {
            Iterator<Logger> var5DADD71C08A6A25BCD24EECB2286D82F_1064956962 = (allLoggers).iterator();
            var5DADD71C08A6A25BCD24EECB2286D82F_1064956962.hasNext();
            Logger logger = var5DADD71C08A6A25BCD24EECB2286D82F_1064956962.next();
            {
                String property;
                property = props.getProperty(logger.getName() + ".level");
                {
                    logger.setLevel(Level.parse(property));
                } //End block
            } //End block
        } //End collapsed parenthetic
        listeners.firePropertyChange(null, null, null);
        addTaint(ins.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.569 -0400", hash_original_method = "0B5A5DFDBB36281B5E8835796DD30069", hash_generated_method = "2033D464A9B31A1EC9418D2986523A7D")
    public void readConfiguration(InputStream ins) throws IOException {
        checkAccess();
        readConfigurationImpl(ins);
        addTaint(ins.getTaint());
        // ---------- Original Method ----------
        //checkAccess();
        //readConfigurationImpl(ins);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.573 -0400", hash_original_method = "C7F5D5A126D3CC9BC9332DC327B04AA6", hash_generated_method = "05FCCD30811757F3CFE33C02329B876B")
    public synchronized void reset() {
        checkAccess();
        props = new Properties();
        Enumeration<String> names;
        names = getLoggerNames();
        {
            boolean var9F006A42B2CC9BF287474D33D9697C81_666853678 = (names.hasMoreElements());
            {
                String name;
                name = names.nextElement();
                Logger logger;
                logger = getLogger(name);
                {
                    logger.reset();
                } //End block
            } //End block
        } //End collapsed parenthetic
        Logger root;
        root = loggers.get("");
        {
            root.setLevel(Level.INFO);
        } //End block
        // ---------- Original Method ----------
        //checkAccess();
        //props = new Properties();
        //Enumeration<String> names = getLoggerNames();
        //while (names.hasMoreElements()) {
            //String name = names.nextElement();
            //Logger logger = getLogger(name);
            //if (logger != null) {
                //logger.reset();
            //}
        //}
        //Logger root = loggers.get("");
        //if (root != null) {
            //root.setLevel(Level.INFO);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.574 -0400", hash_original_method = "89AE29101867526E131C7EEE62325170", hash_generated_method = "882C6EE0CC053CC361FF9D6856595007")
    public void addPropertyChangeListener(PropertyChangeListener l) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        checkAccess();
        listeners.addPropertyChangeListener(l);
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //if (l == null) {
            //throw new NullPointerException();
        //}
        //checkAccess();
        //listeners.addPropertyChangeListener(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.574 -0400", hash_original_method = "C0D7CB274D3F753AA28C566B595F1403", hash_generated_method = "21A4C2E825498CC874F03598DE096E16")
    public void removePropertyChangeListener(PropertyChangeListener l) {
        checkAccess();
        listeners.removePropertyChangeListener(l);
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //checkAccess();
        //listeners.removePropertyChangeListener(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.607 -0400", hash_original_method = "B934C7BD7B62C355AF995C71D51E6416", hash_generated_method = "39FEA4D54E507689B6BBB9E889158E45")
    synchronized Logger getOrCreate(String name, String resourceBundleName) {
        Logger varB4EAC82CA7396A68D541C85D26508E83_1715176951 = null; //Variable for return #1
        Logger result;
        result = getLogger(name);
        {
            result = new Logger(name, resourceBundleName);
            addLogger(result);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1715176951 = result;
        addTaint(name.getTaint());
        addTaint(resourceBundleName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1715176951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1715176951;
        // ---------- Original Method ----------
        //Logger result = getLogger(name);
        //if (result == null) {
            //result = new Logger(name, resourceBundleName);
            //addLogger(result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.612 -0400", hash_original_method = "B8E057E50526DE42F5AE7CC32A8A2058", hash_generated_method = "9F282BA13F692C4E1617CE25BD6E52C3")
    synchronized void setParent(Logger logger, Logger newParent) {
        logger.parent = newParent;
        {
            setLevelRecursively(logger, null);
        } //End block
        newParent.children.add(logger);
        logger.updateDalvikLogHandler();
        addTaint(logger.getTaint());
        addTaint(newParent.getTaint());
        // ---------- Original Method ----------
        //logger.parent = newParent;
        //if (logger.levelObjVal == null) {
            //setLevelRecursively(logger, null);
        //}
        //newParent.children.add(logger);
        //logger.updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.670 -0400", hash_original_method = "46EC17C11FD929B8108F5C206F2B42C8", hash_generated_method = "B51EB27BEA33E9560EF842C50648D6A8")
    synchronized void setLevelRecursively(Logger logger, Level newLevel) {
        int previous;
        previous = logger.levelIntVal;
        logger.levelObjVal = newLevel;
        {
            logger.levelIntVal = logger.parent != null
                    ? logger.parent.levelIntVal
                    : Level.INFO.intValue();
        } //End block
        {
            logger.levelIntVal = newLevel.intValue();
        } //End block
        {
            {
                Iterator<Logger> var269A6E3FAF8E58C011F2E1EF42BE0425_1217140420 = (logger.children).iterator();
                var269A6E3FAF8E58C011F2E1EF42BE0425_1217140420.hasNext();
                Logger child = var269A6E3FAF8E58C011F2E1EF42BE0425_1217140420.next();
                {
                    {
                        setLevelRecursively(child, null);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(logger.getTaint());
        addTaint(newLevel.getTaint());
        // ---------- Original Method ----------
        //int previous = logger.levelIntVal;
        //logger.levelObjVal = newLevel;
        //if (newLevel == null) {
            //logger.levelIntVal = logger.parent != null
                    //? logger.parent.levelIntVal
                    //: Level.INFO.intValue();
        //} else {
            //logger.levelIntVal = newLevel.intValue();
        //}
        //if (previous != logger.levelIntVal) {
            //for (Logger child : logger.children) {
                //if (child.levelObjVal == null) {
                    //setLevelRecursively(child, null);
                //}
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.670 -0400", hash_original_field = "236E63F5B17A2E84BD136AD72EB7D7B3", hash_generated_field = "C7322A2B58796BCD1C63DA2CFF4622FD")

    private static LoggingPermission perm = new LoggingPermission("control", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.670 -0400", hash_original_field = "1D0258C2440A8D19E716292B231E3190", hash_generated_field = "60A931CC8E2121C9AF9FC8AFF4714295")

    static LogManager manager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.670 -0400", hash_original_field = "B8CB929319EE85E0FA97E8ABD40DEBBC", hash_generated_field = "A7D53AAA4BF83E2F2365813530C06BF1")

    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
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

