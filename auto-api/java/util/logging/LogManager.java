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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.114 -0400", hash_original_field = "E3744F330069AC8D2BE40C0CB5EFBDB6", hash_generated_field = "AD370BFFC6E9AB83396CFA02133C2A08")

    private Hashtable<String, Logger> loggers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.114 -0400", hash_original_field = "50FE03AB7BF37089A7E88DA9B31FFB3B", hash_generated_field = "C2D8C40A30BA03E4CF83D1B1429A651D")

    private Properties props;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.114 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "3B43FF39F7B726230E736460CF0CFA39")

    private PropertyChangeSupport listeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.117 -0400", hash_original_method = "F83269E1889FF9DC50A0440D3CD9234B", hash_generated_method = "42580EDB79A5A77C2E3B583E9CC2B036")
    protected  LogManager() {
        loggers = new Hashtable<String, Logger>();
        props = new Properties();
        listeners = new PropertyChangeSupport(this);
        Runtime.getRuntime().addShutdownHook(new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.117 -0400", hash_original_method = "1836317CB8E0A5E5B172790642D1742E", hash_generated_method = "59D9E72089082C0A3CB03237A4A6EC42")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.117 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "C308BE0846D76E01A367023713D9A840")
    public void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.120 -0400", hash_original_method = "9E275E191101B6346DE13876068F41E1", hash_generated_method = "0CB831923BDE6536D22EA84F04D8949F")
    public synchronized boolean addLogger(Logger logger) {
        String name;
        name = logger.getName();
        {
            boolean var8D9B5EDD22D5E90786B9DFCF2C7B2FED_60192851 = (loggers.get(name) != null);
        } //End collapsed parenthetic
        addToFamilyTree(logger, name);
        loggers.put(name, logger);
        logger.setManager(this);
        addTaint(logger.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528310695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528310695;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.180 -0400", hash_original_method = "0070D539A38F64AFDE25421AB7DE8DFA", hash_generated_method = "8A5391DF9B971436550F8087D66EF187")
    private void addToFamilyTree(Logger logger, String name) {
        Logger parent;
        parent = null;
        int lastSeparator;
        String parentName;
        parentName = name;
        {
            boolean var24311821043CD386ECA987B6ED2E2081_1079796001 = ((lastSeparator = parentName.lastIndexOf('.')) != -1);
            {
                parentName = parentName.substring(0, lastSeparator);
                parent = loggers.get(parentName);
                {
                    setParent(logger, parent);
                } //End block
                {
                    boolean var436F2D49C8476C95F0FD5686A4212BC7_1160026330 = (getProperty(parentName + ".level") != null ||
                    getProperty(parentName + ".handlers") != null);
                    {
                        parent = Logger.getLogger(parentName);
                        setParent(logger, parent);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE7420F5B75328DBDF911BFB1BBFE9320_1169124567 = (parent == null && (parent = loggers.get("")) != null);
            {
                setParent(logger, parent);
            } //End block
        } //End collapsed parenthetic
        String nameDot;
        nameDot = name + '.';
        Collection<Logger> allLoggers;
        allLoggers = loggers.values();
        {
            Iterator<Logger> var4A013FF40FFB4353AFEDD6717288ACC8_1570856118 = (allLoggers).iterator();
            var4A013FF40FFB4353AFEDD6717288ACC8_1570856118.hasNext();
            final Logger child = var4A013FF40FFB4353AFEDD6717288ACC8_1570856118.next();
            {
                Logger oldParent;
                oldParent = child.getParent();
                {
                    boolean varEE86372CE9D50F853F7F62A388B74232_1229971351 = (parent == oldParent && (name.length() == 0 || child.getName().startsWith(nameDot)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.182 -0400", hash_original_method = "7CC5CB7CA011BF34DBD2626C5B91D261", hash_generated_method = "F450D665A1A601B21B042E065B6F9BBE")
    public synchronized Logger getLogger(String name) {
        Logger varB4EAC82CA7396A68D541C85D26508E83_404087340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_404087340 = loggers.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_404087340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_404087340;
        // ---------- Original Method ----------
        //return loggers.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.182 -0400", hash_original_method = "A3ADDC952F848C9366B53F69C5A416F6", hash_generated_method = "944F0AE5FBF996047A8C560AB6645A22")
    public synchronized Enumeration<String> getLoggerNames() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_516600233 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_516600233 = loggers.keys();
        varB4EAC82CA7396A68D541C85D26508E83_516600233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_516600233;
        // ---------- Original Method ----------
        //return loggers.keys();
    }

    
        public static LogManager getLogManager() {
        return manager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.190 -0400", hash_original_method = "308A02382C1792AE136BBB31488FF7DC", hash_generated_method = "FE245FC444AC91914F1E86A2CF890051")
    public String getProperty(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1575871935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1575871935 = props.getProperty(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1575871935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575871935;
        // ---------- Original Method ----------
        //return props.getProperty(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.192 -0400", hash_original_method = "F9E79871CB75749F3B3C682DFBEA7367", hash_generated_method = "0B52DB0704E50BD597AC0E7DE65F3FE1")
    public void readConfiguration() throws IOException {
        String configClassName;
        configClassName = System.getProperty("java.util.logging.config.class");
        {
            boolean varDD1F3D94E4BF22F8C21B8724834F5A99_1317548335 = (configClassName == null || getInstanceByClass(configClassName) == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.314 -0400", hash_original_method = "5AA730DC7CE7051A789AED9B260AEA08", hash_generated_method = "5CC65A3A9EF6EE557B9CAE02D110EC2C")
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
                boolean varA9BBA9119DD90070115272E6F9D4D419_331049400 = (st.hasMoreTokens());
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
            Iterator<Logger> var5DADD71C08A6A25BCD24EECB2286D82F_1475668005 = (allLoggers).iterator();
            var5DADD71C08A6A25BCD24EECB2286D82F_1475668005.hasNext();
            Logger logger = var5DADD71C08A6A25BCD24EECB2286D82F_1475668005.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.318 -0400", hash_original_method = "0B5A5DFDBB36281B5E8835796DD30069", hash_generated_method = "2033D464A9B31A1EC9418D2986523A7D")
    public void readConfiguration(InputStream ins) throws IOException {
        checkAccess();
        readConfigurationImpl(ins);
        addTaint(ins.getTaint());
        // ---------- Original Method ----------
        //checkAccess();
        //readConfigurationImpl(ins);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.319 -0400", hash_original_method = "C7F5D5A126D3CC9BC9332DC327B04AA6", hash_generated_method = "66087374496B9707D1255EEC911414AA")
    public synchronized void reset() {
        checkAccess();
        props = new Properties();
        Enumeration<String> names;
        names = getLoggerNames();
        {
            boolean var9F006A42B2CC9BF287474D33D9697C81_1651786937 = (names.hasMoreElements());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.319 -0400", hash_original_method = "89AE29101867526E131C7EEE62325170", hash_generated_method = "882C6EE0CC053CC361FF9D6856595007")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.320 -0400", hash_original_method = "C0D7CB274D3F753AA28C566B595F1403", hash_generated_method = "21A4C2E825498CC874F03598DE096E16")
    public void removePropertyChangeListener(PropertyChangeListener l) {
        checkAccess();
        listeners.removePropertyChangeListener(l);
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //checkAccess();
        //listeners.removePropertyChangeListener(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.321 -0400", hash_original_method = "B934C7BD7B62C355AF995C71D51E6416", hash_generated_method = "1827AEBC535AD49FE580F5E50C51C465")
    synchronized Logger getOrCreate(String name, String resourceBundleName) {
        Logger varB4EAC82CA7396A68D541C85D26508E83_1426791034 = null; //Variable for return #1
        Logger result;
        result = getLogger(name);
        {
            result = new Logger(name, resourceBundleName);
            addLogger(result);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1426791034 = result;
        addTaint(name.getTaint());
        addTaint(resourceBundleName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1426791034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426791034;
        // ---------- Original Method ----------
        //Logger result = getLogger(name);
        //if (result == null) {
            //result = new Logger(name, resourceBundleName);
            //addLogger(result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.333 -0400", hash_original_method = "B8E057E50526DE42F5AE7CC32A8A2058", hash_generated_method = "9F282BA13F692C4E1617CE25BD6E52C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.371 -0400", hash_original_method = "46EC17C11FD929B8108F5C206F2B42C8", hash_generated_method = "20E4412A4ABFFE96651771560E42C0AF")
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
                Iterator<Logger> var269A6E3FAF8E58C011F2E1EF42BE0425_306664180 = (logger.children).iterator();
                var269A6E3FAF8E58C011F2E1EF42BE0425_306664180.hasNext();
                Logger child = var269A6E3FAF8E58C011F2E1EF42BE0425_306664180.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.377 -0400", hash_original_field = "236E63F5B17A2E84BD136AD72EB7D7B3", hash_generated_field = "C7322A2B58796BCD1C63DA2CFF4622FD")

    private static LoggingPermission perm = new LoggingPermission("control", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.377 -0400", hash_original_field = "1D0258C2440A8D19E716292B231E3190", hash_generated_field = "60A931CC8E2121C9AF9FC8AFF4714295")

    static LogManager manager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.377 -0400", hash_original_field = "B8CB929319EE85E0FA97E8ABD40DEBBC", hash_generated_field = "A7D53AAA4BF83E2F2365813530C06BF1")

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

