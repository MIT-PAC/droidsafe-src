package java.util.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.367 -0400", hash_original_field = "E3744F330069AC8D2BE40C0CB5EFBDB6", hash_generated_field = "AD370BFFC6E9AB83396CFA02133C2A08")

    private Hashtable<String, Logger> loggers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.368 -0400", hash_original_field = "50FE03AB7BF37089A7E88DA9B31FFB3B", hash_generated_field = "C2D8C40A30BA03E4CF83D1B1429A651D")

    private Properties props;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.368 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "3B43FF39F7B726230E736460CF0CFA39")

    private PropertyChangeSupport listeners;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.368 -0400", hash_original_method = "F83269E1889FF9DC50A0440D3CD9234B", hash_generated_method = "2A997565C82286E3C0A90723210DA303")
    protected  LogManager() {
        loggers = new Hashtable<String, Logger>();
        props = new Properties();
        listeners = new PropertyChangeSupport(this);
        Runtime.getRuntime().addShutdownHook(new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.368 -0400", hash_original_method = "1836317CB8E0A5E5B172790642D1742E", hash_generated_method = "59D9E72089082C0A3CB03237A4A6EC42")
            @Override
            public void run() {
                reset();
                
                
            }
});
        
        
        
        
        
            
                
            
        
    }

    
        @DSModeled(DSC.SAFE)
    public static LoggingMXBean getLoggingMXBean() {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.369 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "C308BE0846D76E01A367023713D9A840")
    public void checkAccess() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.369 -0400", hash_original_method = "9E275E191101B6346DE13876068F41E1", hash_generated_method = "25F16E9D0F6830BFC64D143AAACAAD12")
    public synchronized boolean addLogger(Logger logger) {
        String name = logger.getName();
        {
            boolean var8D9B5EDD22D5E90786B9DFCF2C7B2FED_2077165150 = (loggers.get(name) != null);
        } 
        addToFamilyTree(logger, name);
        loggers.put(name, logger);
        logger.setManager(this);
        addTaint(logger.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281648976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281648976;
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.378 -0400", hash_original_method = "0070D539A38F64AFDE25421AB7DE8DFA", hash_generated_method = "7DD9B36071850A6DAA78142FF0FEB3A1")
    private void addToFamilyTree(Logger logger, String name) {
        Logger parent = null;
        int lastSeparator;
        String parentName = name;
        {
            boolean var24311821043CD386ECA987B6ED2E2081_241363339 = ((lastSeparator = parentName.lastIndexOf('.')) != -1);
            {
                parentName = parentName.substring(0, lastSeparator);
                parent = loggers.get(parentName);
                {
                    setParent(logger, parent);
                } 
                {
                    boolean var436F2D49C8476C95F0FD5686A4212BC7_575240558 = (getProperty(parentName + ".level") != null ||
                    getProperty(parentName + ".handlers") != null);
                    {
                        parent = Logger.getLogger(parentName);
                        setParent(logger, parent);
                    } 
                } 
            } 
        } 
        {
            boolean varE7420F5B75328DBDF911BFB1BBFE9320_2131091867 = (parent == null && (parent = loggers.get("")) != null);
            {
                setParent(logger, parent);
            } 
        } 
        String nameDot = name + '.';
        Collection<Logger> allLoggers = loggers.values();
        {
            Iterator<Logger> var4A013FF40FFB4353AFEDD6717288ACC8_1532832891 = (allLoggers).iterator();
            var4A013FF40FFB4353AFEDD6717288ACC8_1532832891.hasNext();
            final Logger child = var4A013FF40FFB4353AFEDD6717288ACC8_1532832891.next();
            {
                Logger oldParent = child.getParent();
                {
                    boolean varEE86372CE9D50F853F7F62A388B74232_67891352 = (parent == oldParent && (name.length() == 0 || child.getName().startsWith(nameDot)));
                    {
                        final Logger thisLogger = logger;
                        child.setParent(thisLogger);
                        {
                            oldParent.children.remove(child);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(logger.getTaint());
        addTaint(name.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.379 -0400", hash_original_method = "7CC5CB7CA011BF34DBD2626C5B91D261", hash_generated_method = "4083BFA7443D23B42F8F033B1449BCDB")
    public synchronized Logger getLogger(String name) {
        Logger varB4EAC82CA7396A68D541C85D26508E83_721887279 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_721887279 = loggers.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_721887279.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_721887279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.379 -0400", hash_original_method = "A3ADDC952F848C9366B53F69C5A416F6", hash_generated_method = "59BD2C7B7FC1B578DB4E7AE93801B883")
    public synchronized Enumeration<String> getLoggerNames() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_1732811004 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1732811004 = loggers.keys();
        varB4EAC82CA7396A68D541C85D26508E83_1732811004.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1732811004;
        
        
    }

    
        public static LogManager getLogManager() {
        return manager;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.380 -0400", hash_original_method = "308A02382C1792AE136BBB31488FF7DC", hash_generated_method = "75BC8267152278A9D174BD5625A85229")
    public String getProperty(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1702189657 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1702189657 = props.getProperty(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1702189657.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1702189657;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.380 -0400", hash_original_method = "F9E79871CB75749F3B3C682DFBEA7367", hash_generated_method = "BD86A888733C9B94B5F149259D047854")
    public void readConfiguration() throws IOException {
        String configClassName = System.getProperty("java.util.logging.config.class");
        {
            boolean varDD1F3D94E4BF22F8C21B8724834F5A99_488117754 = (configClassName == null || getInstanceByClass(configClassName) == null);
            {
                String configFile = System.getProperty("java.util.logging.config.file");
                {
                    configFile = System.getProperty("java.home") + File.separator + "lib" +
                        File.separator + "logging.properties";
                } 
                InputStream input = null;
                try 
                {
                    try 
                    {
                        input = new FileInputStream(configFile);
                    } 
                    catch (IOException exception)
                    {
                        input = LogManager.class.getResourceAsStream("logging.properties");
                        {
                            if (DroidSafeAndroidRuntime.control) throw exception;
                        } 
                    } 
                    readConfiguration(new BufferedInputStream(input));
                } 
                finally 
                {
                    IoUtils.closeQuietly(input);
                } 
            } 
        } 
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.388 -0400", hash_original_method = "5AA730DC7CE7051A789AED9B260AEA08", hash_generated_method = "2A883B86987B92F7B11EA3784F8F40FA")
    private synchronized void readConfigurationImpl(InputStream ins) throws IOException {
        reset();
        props.load(ins);
        Logger root = loggers.get("");
        {
            root.setManager(this);
        } 
        String configs = props.getProperty("config");
        {
            StringTokenizer st = new StringTokenizer(configs, " ");
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_1444349973 = (st.hasMoreTokens());
                {
                    String configerName = st.nextToken();
                    getInstanceByClass(configerName);
                } 
            } 
        } 
        Collection<Logger> allLoggers = loggers.values();
        {
            Iterator<Logger> var5DADD71C08A6A25BCD24EECB2286D82F_721800240 = (allLoggers).iterator();
            var5DADD71C08A6A25BCD24EECB2286D82F_721800240.hasNext();
            Logger logger = var5DADD71C08A6A25BCD24EECB2286D82F_721800240.next();
            {
                String property = props.getProperty(logger.getName() + ".level");
                {
                    logger.setLevel(Level.parse(property));
                } 
            } 
        } 
        listeners.firePropertyChange(null, null, null);
        addTaint(ins.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.389 -0400", hash_original_method = "0B5A5DFDBB36281B5E8835796DD30069", hash_generated_method = "2033D464A9B31A1EC9418D2986523A7D")
    public void readConfiguration(InputStream ins) throws IOException {
        checkAccess();
        readConfigurationImpl(ins);
        addTaint(ins.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.389 -0400", hash_original_method = "C7F5D5A126D3CC9BC9332DC327B04AA6", hash_generated_method = "E066EDDC4328BF1591C3F9F76C72FAEC")
    public synchronized void reset() {
        checkAccess();
        props = new Properties();
        Enumeration<String> names = getLoggerNames();
        {
            boolean var9F006A42B2CC9BF287474D33D9697C81_637339910 = (names.hasMoreElements());
            {
                String name = names.nextElement();
                Logger logger = getLogger(name);
                {
                    logger.reset();
                } 
            } 
        } 
        Logger root = loggers.get("");
        {
            root.setLevel(Level.INFO);
        } 
        
        
        
        
        
            
            
            
                
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.389 -0400", hash_original_method = "89AE29101867526E131C7EEE62325170", hash_generated_method = "882C6EE0CC053CC361FF9D6856595007")
    public void addPropertyChangeListener(PropertyChangeListener l) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        checkAccess();
        listeners.addPropertyChangeListener(l);
        addTaint(l.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.390 -0400", hash_original_method = "C0D7CB274D3F753AA28C566B595F1403", hash_generated_method = "21A4C2E825498CC874F03598DE096E16")
    public void removePropertyChangeListener(PropertyChangeListener l) {
        checkAccess();
        listeners.removePropertyChangeListener(l);
        addTaint(l.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.390 -0400", hash_original_method = "B934C7BD7B62C355AF995C71D51E6416", hash_generated_method = "5F7880A06ECFBF8DB3819592DAF7AD43")
    synchronized Logger getOrCreate(String name, String resourceBundleName) {
        Logger varB4EAC82CA7396A68D541C85D26508E83_1317350450 = null; 
        Logger result = getLogger(name);
        {
            result = new Logger(name, resourceBundleName);
            addLogger(result);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1317350450 = result;
        addTaint(name.getTaint());
        addTaint(resourceBundleName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1317350450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1317350450;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.391 -0400", hash_original_method = "B8E057E50526DE42F5AE7CC32A8A2058", hash_generated_method = "9F282BA13F692C4E1617CE25BD6E52C3")
    synchronized void setParent(Logger logger, Logger newParent) {
        logger.parent = newParent;
        {
            setLevelRecursively(logger, null);
        } 
        newParent.children.add(logger);
        logger.updateDalvikLogHandler();
        addTaint(logger.getTaint());
        addTaint(newParent.getTaint());
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.397 -0400", hash_original_method = "46EC17C11FD929B8108F5C206F2B42C8", hash_generated_method = "A3BFC1B62EAB5E96432A1D9481C9BD48")
    synchronized void setLevelRecursively(Logger logger, Level newLevel) {
        int previous = logger.levelIntVal;
        logger.levelObjVal = newLevel;
        {
            logger.levelIntVal = logger.parent != null
                    ? logger.parent.levelIntVal
                    : Level.INFO.intValue();
        } 
        {
            logger.levelIntVal = newLevel.intValue();
        } 
        {
            {
                Iterator<Logger> var269A6E3FAF8E58C011F2E1EF42BE0425_1694813759 = (logger.children).iterator();
                var269A6E3FAF8E58C011F2E1EF42BE0425_1694813759.hasNext();
                Logger child = var269A6E3FAF8E58C011F2E1EF42BE0425_1694813759.next();
                {
                    {
                        setLevelRecursively(child, null);
                    } 
                } 
            } 
        } 
        addTaint(logger.getTaint());
        addTaint(newLevel.getTaint());
        
        
        
        
            
                    
                    
        
            
        
        
            
                
                    
                
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.397 -0400", hash_original_field = "236E63F5B17A2E84BD136AD72EB7D7B3", hash_generated_field = "6DBE4148F2B32574633325AE3FB2F9F9")

    private static final LoggingPermission perm = new LoggingPermission("control", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.397 -0400", hash_original_field = "1D0258C2440A8D19E716292B231E3190", hash_generated_field = "60A931CC8E2121C9AF9FC8AFF4714295")

    static LogManager manager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.397 -0400", hash_original_field = "B8CB929319EE85E0FA97E8ABD40DEBBC", hash_generated_field = "A7D53AAA4BF83E2F2365813530C06BF1")

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

