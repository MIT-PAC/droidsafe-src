package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.193 -0400", hash_original_field = "E3744F330069AC8D2BE40C0CB5EFBDB6", hash_generated_field = "AD370BFFC6E9AB83396CFA02133C2A08")

    private Hashtable<String, Logger> loggers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.193 -0400", hash_original_field = "50FE03AB7BF37089A7E88DA9B31FFB3B", hash_generated_field = "C2D8C40A30BA03E4CF83D1B1429A651D")

    private Properties props;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.193 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "3B43FF39F7B726230E736460CF0CFA39")

    private PropertyChangeSupport listeners;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.194 -0400", hash_original_method = "F83269E1889FF9DC50A0440D3CD9234B", hash_generated_method = "25A4D420CCA8D659CCCCE116BE659C0D")
    protected  LogManager() {
        loggers = new Hashtable<String, Logger>();
        props = new Properties();
        listeners = new PropertyChangeSupport(this);
        Runtime.getRuntime().addShutdownHook(new Thread() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.194 -0400", hash_original_method = "1836317CB8E0A5E5B172790642D1742E", hash_generated_method = "59D9E72089082C0A3CB03237A4A6EC42")
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

    
    @DSModeled(DSC.SAFE)
    public static LoggingMXBean getLoggingMXBean() {
        throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.195 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "C308BE0846D76E01A367023713D9A840")
    public void checkAccess() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.195 -0400", hash_original_method = "9E275E191101B6346DE13876068F41E1", hash_generated_method = "788D9160E981BB9CBFC3D7A9D722ADE4")
    public synchronized boolean addLogger(Logger logger) {
        addTaint(logger.getTaint());
        String name = logger.getName();
        if(loggers.get(name) != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1952410103 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123340122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123340122;
        } //End block
        addToFamilyTree(logger, name);
        loggers.put(name, logger);
        logger.setManager(this);
        boolean varB326B5062B2F0E69046810717534CB09_2084399327 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942299118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942299118;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.196 -0400", hash_original_method = "0070D539A38F64AFDE25421AB7DE8DFA", hash_generated_method = "76C1DB2B184826FDB1C78E29D45926F7")
    private void addToFamilyTree(Logger logger, String name) {
        addTaint(name.getTaint());
        addTaint(logger.getTaint());
        Logger parent = null;
        int lastSeparator;
        String parentName = name;
        while
((lastSeparator = parentName.lastIndexOf('.')) != -1)        
        {
            parentName = parentName.substring(0, lastSeparator);
            parent = loggers.get(parentName);
            if(parent != null)            
            {
                setParent(logger, parent);
                break;
            } //End block
            else
            if(getProperty(parentName + ".level") != null ||
                    getProperty(parentName + ".handlers") != null)            
            {
                parent = Logger.getLogger(parentName);
                setParent(logger, parent);
                break;
            } //End block
        } //End block
        if(parent == null && (parent = loggers.get("")) != null)        
        {
            setParent(logger, parent);
        } //End block
        String nameDot = name + '.';
        Collection<Logger> allLoggers = loggers.values();
for(Logger child : allLoggers)
        {
            Logger oldParent = child.getParent();
            if(parent == oldParent && (name.length() == 0 || child.getName().startsWith(nameDot)))            
            {
                final Logger thisLogger = logger;
                child.setParent(thisLogger);
                if(oldParent != null)                
                {
                    oldParent.children.remove(child);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.197 -0400", hash_original_method = "7CC5CB7CA011BF34DBD2626C5B91D261", hash_generated_method = "245A3107FD5E1A6D2638DF217BD64A09")
    public synchronized Logger getLogger(String name) {
        addTaint(name.getTaint());
Logger var221D8F3514DCB5DB275CC33A419F7FF7_1613151480 =         loggers.get(name);
        var221D8F3514DCB5DB275CC33A419F7FF7_1613151480.addTaint(taint);
        return var221D8F3514DCB5DB275CC33A419F7FF7_1613151480;
        // ---------- Original Method ----------
        //return loggers.get(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.198 -0400", hash_original_method = "A3ADDC952F848C9366B53F69C5A416F6", hash_generated_method = "64C5A716AE726A8BF6F9D167E79F4C9F")
    public synchronized Enumeration<String> getLoggerNames() {
Enumeration<String> var4E30A2D52E210CF3B5F426F6FA97D29F_414076122 =         loggers.keys();
        var4E30A2D52E210CF3B5F426F6FA97D29F_414076122.addTaint(taint);
        return var4E30A2D52E210CF3B5F426F6FA97D29F_414076122;
        // ---------- Original Method ----------
        //return loggers.keys();
    }

    
    @DSModeled(DSC.SAFE)
    public static LogManager getLogManager() {
        return manager;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.198 -0400", hash_original_method = "308A02382C1792AE136BBB31488FF7DC", hash_generated_method = "3F24AE8C41095D66912927F2C172E963")
    public String getProperty(String name) {
        addTaint(name.getTaint());
String varCAC2FB4F16F751F82616E09DB74CE99D_1727822386 =         props.getProperty(name);
        varCAC2FB4F16F751F82616E09DB74CE99D_1727822386.addTaint(taint);
        return varCAC2FB4F16F751F82616E09DB74CE99D_1727822386;
        // ---------- Original Method ----------
        //return props.getProperty(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.200 -0400", hash_original_method = "F9E79871CB75749F3B3C682DFBEA7367", hash_generated_method = "CCC7FF4AE08B15AAB694366B4FC23BD0")
    public void readConfiguration() throws IOException {
        String configClassName = System.getProperty("java.util.logging.config.class");
        if(configClassName == null || getInstanceByClass(configClassName) == null)        
        {
            String configFile = System.getProperty("java.util.logging.config.file");
            if(configFile == null)            
            {
                configFile = System.getProperty("java.home") + File.separator + "lib" +
                        File.separator + "logging.properties";
            } //End block
            InputStream input = null;
            try 
            {
                try 
                {
                    input = new FileInputStream(configFile);
                } //End block
                catch (IOException exception)
                {
                    input = LogManager.class.getResourceAsStream("logging.properties");
                    if(input == null)                    
                    {
                        exception.addTaint(taint);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.201 -0400", hash_original_method = "5AA730DC7CE7051A789AED9B260AEA08", hash_generated_method = "91EE07B56353B3774C117594F5E2D583")
    private synchronized void readConfigurationImpl(InputStream ins) throws IOException {
        addTaint(ins.getTaint());
        reset();
        props.load(ins);
        Logger root = loggers.get("");
        if(root != null)        
        {
            root.setManager(this);
        } //End block
        String configs = props.getProperty("config");
        if(configs != null)        
        {
            StringTokenizer st = new StringTokenizer(configs, " ");
            while
(st.hasMoreTokens())            
            {
                String configerName = st.nextToken();
                getInstanceByClass(configerName);
            } //End block
        } //End block
        Collection<Logger> allLoggers = loggers.values();
for(Logger logger : allLoggers)
        {
            String property = props.getProperty(logger.getName() + ".level");
            if(property != null)            
            {
                logger.setLevel(Level.parse(property));
            } //End block
        } //End block
        listeners.firePropertyChange(null, null, null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.202 -0400", hash_original_method = "0B5A5DFDBB36281B5E8835796DD30069", hash_generated_method = "B873FDB9BFB45A593D31088D6CC8EB3E")
    public void readConfiguration(InputStream ins) throws IOException {
        addTaint(ins.getTaint());
        checkAccess();
        readConfigurationImpl(ins);
        // ---------- Original Method ----------
        //checkAccess();
        //readConfigurationImpl(ins);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.203 -0400", hash_original_method = "C7F5D5A126D3CC9BC9332DC327B04AA6", hash_generated_method = "0BB5A647B728427053CFC8FEE2E63C26")
    public synchronized void reset() {
        checkAccess();
        props = new Properties();
        Enumeration<String> names = getLoggerNames();
        while
(names.hasMoreElements())        
        {
            String name = names.nextElement();
            Logger logger = getLogger(name);
            if(logger != null)            
            {
                logger.reset();
            } //End block
        } //End block
        Logger root = loggers.get("");
        if(root != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.205 -0400", hash_original_method = "89AE29101867526E131C7EEE62325170", hash_generated_method = "E9BEC48B98AE5720EAC68016E7322711")
    public void addPropertyChangeListener(PropertyChangeListener l) {
        addTaint(l.getTaint());
        if(l == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_166519483 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_166519483.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_166519483;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.205 -0400", hash_original_method = "C0D7CB274D3F753AA28C566B595F1403", hash_generated_method = "AA2028EE94561590C94782D57F1FB9E3")
    public void removePropertyChangeListener(PropertyChangeListener l) {
        addTaint(l.getTaint());
        checkAccess();
        listeners.removePropertyChangeListener(l);
        // ---------- Original Method ----------
        //checkAccess();
        //listeners.removePropertyChangeListener(l);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.206 -0400", hash_original_method = "B934C7BD7B62C355AF995C71D51E6416", hash_generated_method = "2D6D56D060CA289CCBB552E917F57EF6")
    synchronized Logger getOrCreate(String name, String resourceBundleName) {
        addTaint(resourceBundleName.getTaint());
        addTaint(name.getTaint());
        Logger result = getLogger(name);
        if(result == null)        
        {
            result = new Logger(name, resourceBundleName);
            addLogger(result);
        } //End block
Logger varDC838461EE2FA0CA4C9BBB70A15456B0_1044741909 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1044741909.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1044741909;
        // ---------- Original Method ----------
        //Logger result = getLogger(name);
        //if (result == null) {
            //result = new Logger(name, resourceBundleName);
            //addLogger(result);
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.207 -0400", hash_original_method = "B8E057E50526DE42F5AE7CC32A8A2058", hash_generated_method = "8EE1D572A948BD1FF6EB146007A7AD4E")
    synchronized void setParent(Logger logger, Logger newParent) {
        addTaint(newParent.getTaint());
        addTaint(logger.getTaint());
        logger.parent = newParent;
        if(logger.levelObjVal == null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.207 -0400", hash_original_method = "46EC17C11FD929B8108F5C206F2B42C8", hash_generated_method = "F26DDD568D91741F4C59DDDA36E22BE1")
    synchronized void setLevelRecursively(Logger logger, Level newLevel) {
        addTaint(newLevel.getTaint());
        addTaint(logger.getTaint());
        int previous = logger.levelIntVal;
        logger.levelObjVal = newLevel;
        if(newLevel == null)        
        {
            logger.levelIntVal = logger.parent != null
                    ? logger.parent.levelIntVal
                    : Level.INFO.intValue();
        } //End block
        else
        {
            logger.levelIntVal = newLevel.intValue();
        } //End block
        if(previous != logger.levelIntVal)        
        {
for(Logger child : logger.children)
            {
                if(child.levelObjVal == null)                
                {
                    setLevelRecursively(child, null);
                } //End block
            } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.208 -0400", hash_original_field = "236E63F5B17A2E84BD136AD72EB7D7B3", hash_generated_field = "6DBE4148F2B32574633325AE3FB2F9F9")

    private static final LoggingPermission perm = new LoggingPermission("control", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.208 -0400", hash_original_field = "1D0258C2440A8D19E716292B231E3190", hash_generated_field = "60A931CC8E2121C9AF9FC8AFF4714295")

    static LogManager manager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.208 -0400", hash_original_field = "B8CB929319EE85E0FA97E8ABD40DEBBC", hash_generated_field = "A7D53AAA4BF83E2F2365813530C06BF1")

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

