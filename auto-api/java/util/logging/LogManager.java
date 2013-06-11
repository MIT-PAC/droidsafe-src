package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final LoggingPermission perm = new LoggingPermission("control", null);
    static LogManager manager;
    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
    private Hashtable<String, Logger> loggers;
    private Properties props;
    private PropertyChangeSupport listeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.778 -0400", hash_original_method = "F83269E1889FF9DC50A0440D3CD9234B", hash_generated_method = "A1C66E4012C07B745F691B1A01B4EAE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LogManager() {
        loggers = new Hashtable<String, Logger>();
        props = new Properties();
        listeners = new PropertyChangeSupport(this);
        Runtime.getRuntime().addShutdownHook(new Thread() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.778 -0400", hash_original_method = "99854C4284B9CB15C4C88E0DA2C68A20", hash_generated_method = "101D71F5F72FF6847144D9317C1745CB")
    public static LoggingMXBean getLoggingMXBean() {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.778 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "DBCA13A62C4EB0E4F12B52A0D7FEC32D")
    @DSModeled(DSC.SAFE)
    public void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.778 -0400", hash_original_method = "9E275E191101B6346DE13876068F41E1", hash_generated_method = "4C839F8D866AE6160FE1F35655CFABD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean addLogger(Logger logger) {
        dsTaint.addTaint(logger.dsTaint);
        String name;
        name = logger.getName();
        {
            boolean var8D9B5EDD22D5E90786B9DFCF2C7B2FED_141585712 = (loggers.get(name) != null);
        } //End collapsed parenthetic
        addToFamilyTree(logger, name);
        loggers.put(name, logger);
        logger.setManager(this);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "0070D539A38F64AFDE25421AB7DE8DFA", hash_generated_method = "C9556473C91AFF1F2D0D8343CC62F615")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addToFamilyTree(Logger logger, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(logger.dsTaint);
        Logger parent;
        parent = null;
        int lastSeparator;
        String parentName;
        parentName = name;
        {
            boolean var24311821043CD386ECA987B6ED2E2081_961143256 = ((lastSeparator = parentName.lastIndexOf('.')) != -1);
            {
                parentName = parentName.substring(0, lastSeparator);
                parent = loggers.get(parentName);
                {
                    setParent(logger, parent);
                } //End block
                {
                    boolean var436F2D49C8476C95F0FD5686A4212BC7_3360982 = (getProperty(parentName + ".level") != null ||
                    getProperty(parentName + ".handlers") != null);
                    {
                        parent = Logger.getLogger(parentName);
                        setParent(logger, parent);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE7420F5B75328DBDF911BFB1BBFE9320_399343933 = (parent == null && (parent = loggers.get("")) != null);
            {
                setParent(logger, parent);
            } //End block
        } //End collapsed parenthetic
        String nameDot;
        nameDot = name + '.';
        Collection<Logger> allLoggers;
        allLoggers = loggers.values();
        {
            Iterator<Logger> seatecAstronomy42 = allLoggers.iterator();
            seatecAstronomy42.hasNext();
            final Logger child = seatecAstronomy42.next();
            {
                Logger oldParent;
                oldParent = child.getParent();
                {
                    boolean varEE86372CE9D50F853F7F62A388B74232_1345379267 = (parent == oldParent && (name.length() == 0 || child.getName().startsWith(nameDot)));
                    {
                        final Logger thisLogger;
                        thisLogger = logger;
                        child.setParent(thisLogger);
                        {
                            oldParent.children.remove(child);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "7CC5CB7CA011BF34DBD2626C5B91D261", hash_generated_method = "AF90D248E8FB682BC57332AB313FF2C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Logger getLogger(String name) {
        dsTaint.addTaint(name);
        Logger var31D32FC8C614FB34BA93480A2350EF8E_1815063563 = (loggers.get(name));
        return (Logger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loggers.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "A3ADDC952F848C9366B53F69C5A416F6", hash_generated_method = "6203EF802676E4FDFABE1D2991591C02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Enumeration<String> getLoggerNames() {
        Enumeration<String> varDEE033790CB4C1EC587BADB5882B12FB_632567966 = (loggers.keys());
        return (Enumeration<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loggers.keys();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "A967B00D3DC6A3CAC3067F3E0F5EBD2C", hash_generated_method = "A8A0D9D76BC0BA7CD058F572364881A7")
    public static LogManager getLogManager() {
        return manager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "308A02382C1792AE136BBB31488FF7DC", hash_generated_method = "4F77876E487DF075DA4A77E40B504A41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProperty(String name) {
        dsTaint.addTaint(name);
        String var078753C38135C55BB8C7094202FB1F55_357074345 = (props.getProperty(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return props.getProperty(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "F9E79871CB75749F3B3C682DFBEA7367", hash_generated_method = "731659D38CAF5875E70E596BD5ED1095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readConfiguration() throws IOException {
        String configClassName;
        configClassName = System.getProperty("java.util.logging.config.class");
        {
            boolean varDD1F3D94E4BF22F8C21B8724834F5A99_1717828523 = (configClassName == null || getInstanceByClass(configClassName) == null);
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
                            throw exception;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "21F4C1CFC4B65A9FB0283C382E57CCB7", hash_generated_method = "3B039A712FF28C3D9C5FBCD2C43AB5F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.779 -0400", hash_original_method = "5AA730DC7CE7051A789AED9B260AEA08", hash_generated_method = "7BCED64043DB6EA6EBC15AC00F5BDAE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void readConfigurationImpl(InputStream ins) throws IOException {
        dsTaint.addTaint(ins.dsTaint);
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
                boolean varA9BBA9119DD90070115272E6F9D4D419_1927778875 = (st.hasMoreTokens());
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
            Iterator<Logger> seatecAstronomy42 = allLoggers.iterator();
            seatecAstronomy42.hasNext();
            Logger logger = seatecAstronomy42.next();
            {
                String property;
                property = props.getProperty(logger.getName() + ".level");
                {
                    logger.setLevel(Level.parse(property));
                } //End block
            } //End block
        } //End collapsed parenthetic
        listeners.firePropertyChange(null, null, null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "0B5A5DFDBB36281B5E8835796DD30069", hash_generated_method = "170568F791C487C107FDCF83112440DB")
    @DSModeled(DSC.SAFE)
    public void readConfiguration(InputStream ins) throws IOException {
        dsTaint.addTaint(ins.dsTaint);
        checkAccess();
        readConfigurationImpl(ins);
        // ---------- Original Method ----------
        //checkAccess();
        //readConfigurationImpl(ins);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "C7F5D5A126D3CC9BC9332DC327B04AA6", hash_generated_method = "771951B0DC2477EC89C036B3B8944557")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void reset() {
        checkAccess();
        props = new Properties();
        Enumeration<String> names;
        names = getLoggerNames();
        {
            boolean var9F006A42B2CC9BF287474D33D9697C81_2109046697 = (names.hasMoreElements());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "89AE29101867526E131C7EEE62325170", hash_generated_method = "1C6AC1F49D2A40339F526F6844C58823")
    @DSModeled(DSC.SAFE)
    public void addPropertyChangeListener(PropertyChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        checkAccess();
        listeners.addPropertyChangeListener(l);
        // ---------- Original Method ----------
        //if (l == null) {
            //throw new NullPointerException();
        //}
        //checkAccess();
        //listeners.addPropertyChangeListener(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "C0D7CB274D3F753AA28C566B595F1403", hash_generated_method = "582E9AA55D03E528AE4A857D25BD9539")
    @DSModeled(DSC.SAFE)
    public void removePropertyChangeListener(PropertyChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        checkAccess();
        listeners.removePropertyChangeListener(l);
        // ---------- Original Method ----------
        //checkAccess();
        //listeners.removePropertyChangeListener(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "B934C7BD7B62C355AF995C71D51E6416", hash_generated_method = "AE09D87B3665614AFD86C50CF8846464")
    @DSModeled(DSC.SAFE)
    synchronized Logger getOrCreate(String name, String resourceBundleName) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(resourceBundleName);
        Logger result;
        result = getLogger(name);
        {
            result = new Logger(name, resourceBundleName);
            addLogger(result);
        } //End block
        return (Logger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Logger result = getLogger(name);
        //if (result == null) {
            //result = new Logger(name, resourceBundleName);
            //addLogger(result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "B8E057E50526DE42F5AE7CC32A8A2058", hash_generated_method = "AC8597BDBA6637AB9307C8EC193C71B1")
    @DSModeled(DSC.SAFE)
    synchronized void setParent(Logger logger, Logger newParent) {
        dsTaint.addTaint(logger.dsTaint);
        dsTaint.addTaint(newParent.dsTaint);
        logger.parent = newParent;
        {
            setLevelRecursively(logger, null);
        } //End block
        newParent.children.add(logger);
        logger.updateDalvikLogHandler();
        // ---------- Original Method ----------
        //logger.parent = newParent;
        //if (logger.levelObjVal == null) {
            //setLevelRecursively(logger, null);
        //}
        //newParent.children.add(logger);
        //logger.updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.780 -0400", hash_original_method = "46EC17C11FD929B8108F5C206F2B42C8", hash_generated_method = "E87FCCF846B31DE2DAEB453357E33EC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setLevelRecursively(Logger logger, Level newLevel) {
        dsTaint.addTaint(logger.dsTaint);
        dsTaint.addTaint(newLevel.dsTaint);
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
                Iterator<Logger> seatecAstronomy42 = logger.children.iterator();
                seatecAstronomy42.hasNext();
                Logger child = seatecAstronomy42.next();
                {
                    {
                        setLevelRecursively(child, null);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
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


