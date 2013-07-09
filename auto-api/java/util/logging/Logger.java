package java.util.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.DalvikLogHandler;
import dalvik.system.DalvikLogging;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

public class Logger {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "927B896D5AC0DD7FBCC14EBF7566F9A4")

    private volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "4AE1F195790419CAC93DADD2BF6962F7")

    Logger parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "7EA955F14604E3FF10814255A6E159E7", hash_generated_field = "A8FA1EF9E438D313624ABCF6D48E27D1")

    volatile Level levelObjVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "BBCCBDCA09CAD3E5F892776736479402", hash_generated_field = "64484DD5AFFDF68559B6EA3E925D55F8")

    volatile int levelIntVal = Level.INFO.intValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "878F5AE2179223671F6F7BF03BBE54A8")

    private volatile String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "228A0F6DF977A45B5000D16BFD04B1D8", hash_generated_field = "D2720EA1493F697783188B90B5C01BC8")

    private volatile ResourceBundle resourceBundle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "D2701D1D83377E9CB140496A5C5A187D", hash_generated_field = "0713314804552265A9281F5BE4F5F4B2")

    private final List<Handler> handlers = new CopyOnWriteArrayList<Handler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "E1458F37E6588611AB594CFDB36EC40F", hash_generated_field = "A0A66C106644DF6FD3D6C7A1325B8EE1")

    private boolean notifyParentHandlers = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.483 -0400", hash_original_field = "857D649F32E8DB1CFE2F2EF1136A814E", hash_generated_field = "DF5415EF24FD42F5DFD2A24AF349A364")

    private boolean isNamed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.484 -0400", hash_original_field = "2CBC80B4B3201A743322ACE95290F75E", hash_generated_field = "766EA8FEA2309436285546014402AC5C")

    final List<Logger> children = new ArrayList<Logger>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.484 -0400", hash_original_field = "414C73EC90003063BE63D47C87377D68", hash_generated_field = "0F73A57BF2C3FEF042A9DB67B2E7D8CC")

    private String androidTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.484 -0400", hash_original_field = "2C69CB87427ECB00DBBE3B80E492283E", hash_generated_field = "B5C7FD88BFAFFDC7B0174CF578919C4C")

    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.484 -0400", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "5D4C50CD832938A7A058C0BBBCEE51C1")
    protected  Logger(String name, String resourceBundleName) {
        this.name = name;
        initResourceBundle(resourceBundleName);
        this.androidTag = DalvikLogging.loggerNameToTag(name);
        updateDalvikLogHandler();
        addTaint(resourceBundleName.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.488 -0400", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "4F9AB434A286878CEFCF3751254F3762")
     void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler = GENERAL_LOG_HANDLER;
        Logger parent = this.parent;
        {
            boolean var8082E9C2DB777313295DD7C5CCA58548_391209477 = (getClass() != Logger.class);
            {
                Iterator<Handler> h = handlers.iterator();
                {
                    boolean var0E8FA01F9947A2DBD8802083FE3B9D0A_1328247491 = (h.hasNext());
                    {
                        Handler firstHandler = h.next();
                        {
                            boolean var231B03ECF0BC670BB0F6657D7D9E7FC1_60664698 = (!h.hasNext() && firstHandler instanceof DalvikLogHandler);
                            {
                                newLogHandler = (DalvikLogHandler) firstHandler;
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean varE3FD279FB120B7A5C3226227F0A90695_238849625 = (handlers.isEmpty() && notifyParentHandlers);
                {
                    newLogHandler = parent.dalvikLogHandler;
                } 
            } 
        } 
        this.dalvikLogHandler = newLogHandler;
        {
            Iterator<Logger> var3219E9B080A57B4A0BB66CAE1B39DF50_1506441099 = (children).iterator();
            var3219E9B080A57B4A0BB66CAE1B39DF50_1506441099.hasNext();
            Logger logger = var3219E9B080A57B4A0BB66CAE1B39DF50_1506441099.next();
            {
                logger.updateDalvikLogHandler();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static ResourceBundle loadResourceBundle(String resourceBundleName) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl != null) {
            try {
                return ResourceBundle.getBundle(resourceBundleName, Locale.getDefault(), cl);
            } catch (MissingResourceException ignored) {
            }
        }
        cl = ClassLoader.getSystemClassLoader();
        if (cl != null) {
            try {
                return ResourceBundle.getBundle(resourceBundleName, Locale.getDefault(), cl);
            } catch (MissingResourceException ignored) {
            }
        }
        throw new MissingResourceException("Failed to load the specified resource bundle \"" +
                resourceBundleName + "\"", resourceBundleName, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Logger getAnonymousLogger(String resourceBundleName) {
        Logger result = new Logger(null, resourceBundleName);
        result.isNamed = false;
        LogManager logManager = LogManager.getLogManager();
        logManager.setParent(result, logManager.getLogger(""));
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.489 -0400", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "ABCB225AFE11EEBF0A2E51DC06F0C40D")
    private synchronized void initResourceBundle(String resourceBundleName) {
        String current = this.resourceBundleName;
        {
            {
                boolean var216EDF683781EB220AA7EF22E244048D_1195848746 = (current.equals(resourceBundleName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
                } 
            } 
        } 
        {
            this.resourceBundle = loadResourceBundle(resourceBundleName);
            this.resourceBundleName = resourceBundleName;
        } 
        
        
        
            
                
            
                
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Logger getLogger(String name) {
        return LogManager.getLogManager().getOrCreate(name, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Logger getLogger(String name, String resourceBundleName) {
        Logger result = LogManager.getLogManager()
                .getOrCreate(name, resourceBundleName);
        result.initResourceBundle(resourceBundleName);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static Logger getGlobal() {
        return global;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.491 -0400", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "0BE36FA5C3EA441D4C2E4785AC11EFA2")
    public void addHandler(Handler handler) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("handler == null");
        } 
        {
            LogManager.getLogManager().checkAccess();
        } 
        this.handlers.add(handler);
        updateDalvikLogHandler();
        addTaint(handler.getTaint());
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.499 -0400", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "67BE0A9D27E79C4E4940E62B4EF5BCCD")
     void setManager(LogManager manager) {
        String levelProperty = manager.getProperty(name + ".level");
        {
            try 
            {
                manager.setLevelRecursively(Logger.this, Level.parse(levelProperty));
            } 
            catch (IllegalArgumentException invalidLevel)
            {
                invalidLevel.printStackTrace();
            } 
        } 
        String handlersPropertyName;
        boolean var0EDE97A700956C6503647468C3ED00AB_1582652642 = (name.isEmpty());
        handlersPropertyName = "handlers";
        handlersPropertyName = name + ".handlers";
        String handlersProperty = manager.getProperty(handlersPropertyName);
        {
            {
                String handlerName = handlersProperty.split(",|\\s")[0];
                {
                    {
                        boolean var75740153E91B33587E112AFB85404C96_1295904484 = (handlerName.isEmpty());
                    } 
                    Handler handler;
                    try 
                    {
                        handler = (Handler) LogManager.getInstanceByClass(handlerName);
                    } 
                    catch (Exception invalidHandlerName)
                    {
                        invalidHandlerName.printStackTrace();
                        return;
                    } 
                    try 
                    {
                        String level = manager.getProperty(handlerName + ".level");
                        {
                            handler.setLevel(Level.parse(level));
                        } 
                    } 
                    catch (Exception invalidLevel)
                    {
                        invalidLevel.printStackTrace();
                    } 
                    handlers.add(handler);
                } 
            } 
        } 
        updateDalvikLogHandler();
        addTaint(manager.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.500 -0400", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "DD5500FECC8559CB96170F1DE5DB9CAE")
    public Handler[] getHandlers() {
        Handler[] varB4EAC82CA7396A68D541C85D26508E83_1134542917 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1134542917 = handlers.toArray(EMPTY_HANDLERS_ARRAY);
        varB4EAC82CA7396A68D541C85D26508E83_1134542917.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1134542917;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.500 -0400", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "18B91AC8ED6B9173EA0E079641F08405")
    public void removeHandler(Handler handler) {
        {
            LogManager.getLogManager().checkAccess();
        } 
        this.handlers.remove(handler);
        updateDalvikLogHandler();
        addTaint(handler.getTaint());
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.500 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "37948C8546A701AE19917D7C4FD2F366")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_32573778 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_32573778 = this.filter;
        varB4EAC82CA7396A68D541C85D26508E83_32573778.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32573778;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.501 -0400", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "4E964228E1B5C2C72B43721C7FA90FA1")
    public void setFilter(Filter newFilter) {
        {
            LogManager.getLogManager().checkAccess();
        } 
        filter = newFilter;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.502 -0400", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "E9B9694E48612DFB230CB306AD13D65D")
    public Level getLevel() {
        Level varB4EAC82CA7396A68D541C85D26508E83_184262851 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_184262851 = levelObjVal;
        varB4EAC82CA7396A68D541C85D26508E83_184262851.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_184262851;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.503 -0400", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "BF283D43C5B66519D8AFDC4722F48E4E")
    public void setLevel(Level newLevel) {
        LogManager logManager = LogManager.getLogManager();
        {
            logManager.checkAccess();
        } 
        logManager.setLevelRecursively(this, newLevel);
        addTaint(newLevel.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.503 -0400", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "820104404D17408939C1DFCDE2F7818E")
    public boolean getUseParentHandlers() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183205564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_183205564;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.504 -0400", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "8967E1D76B120C20F46207847BEEF625")
    public void setUseParentHandlers(boolean notifyParentHandlers) {
        {
            LogManager.getLogManager().checkAccess();
        } 
        this.notifyParentHandlers = notifyParentHandlers;
        updateDalvikLogHandler();
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.506 -0400", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "A03A917361DF99CCB5AB0A5EEDB2746D")
    public Logger getParent() {
        Logger varB4EAC82CA7396A68D541C85D26508E83_1706282341 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1706282341 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1706282341.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1706282341;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.506 -0400", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "165ADCF53C6FFB0C0075BC73CA539457")
    public void setParent(Logger parent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("parent == null");
        } 
        LogManager logManager = LogManager.getLogManager();
        logManager.checkAccess();
        logManager.setParent(this, parent);
        addTaint(parent.getTaint());
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.507 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "BB3FB3F2DFA5651DFD714BE768D4482D")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_512623683 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_512623683 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_512623683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_512623683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.507 -0400", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "A709836388C62F55C55893A1CF4CF001")
    public ResourceBundle getResourceBundle() {
        ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_610597469 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_610597469 = this.resourceBundle;
        varB4EAC82CA7396A68D541C85D26508E83_610597469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_610597469;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.508 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "12BB20747F71FE08E4CCE3CD906C7177")
    public String getResourceBundleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_783097066 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_783097066 = this.resourceBundleName;
        varB4EAC82CA7396A68D541C85D26508E83_783097066.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_783097066;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.508 -0400", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "ACEA736CF5ED74A9B066E80E4DFE2B53")
    private boolean internalIsLoggable(Level l) {
        int effectiveLevel = levelIntVal;
        {
            boolean var3BA3DAFD15E9AE35A708BCDFA8AF3F3D_1469159730 = (effectiveLevel == Level.OFF.intValue());
        } 
        boolean var4DE3913B1115D82F6261A3311500085D_1809734557 = (l.intValue() >= effectiveLevel);
        addTaint(l.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853969789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853969789;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.508 -0400", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "ED986C6A17C1F93918EFE70977F74C21")
    public boolean isLoggable(Level l) {
        boolean var7D8A791108905A03A9325B0476185D5F_838142361 = (internalIsLoggable(l));
        addTaint(l.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313054936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313054936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.509 -0400", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "9CF2A0B62DDC5C617BB48EE721E1D8B5")
    private void setResourceBundle(LogRecord record) {
        {
            Logger p = this;
            p = p.parent;
            {
                String resourceBundleName = p.resourceBundleName;
                {
                    record.setResourceBundle(p.resourceBundle);
                    record.setResourceBundleName(resourceBundleName);
                } 
            } 
        } 
        addTaint(record.getTaint());
        
        
            
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.509 -0400", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "50BB9A38BEB6D254AED49FF11A64EB34")
    public void entering(String sourceClass, String sourceMethod) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1327908152 = (!internalIsLoggable(Level.FINER));
        } 
        LogRecord record = new LogRecord(Level.FINER, "ENTRY");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.510 -0400", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "732886DB6471E81BDF45ABFD1EBB872B")
    public void entering(String sourceClass, String sourceMethod, Object param) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_136682035 = (!internalIsLoggable(Level.FINER));
        } 
        LogRecord record = new LogRecord(Level.FINER, "ENTRY" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(param.getTaint());
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.510 -0400", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "1B3010EFDA43621C28C39A3F0F5AAAF3")
    public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1846008043 = (!internalIsLoggable(Level.FINER));
        } 
        String msg = "ENTRY";
        {
            StringBuilder msgBuffer = new StringBuilder("ENTRY");
            {
                int i = 0;
                {
                    msgBuffer.append(" {").append(i).append("}");
                } 
            } 
            msg = msgBuffer.toString();
        } 
        LogRecord record = new LogRecord(Level.FINER, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(params[0].getTaint());
        
        
            
        
        
        
            
            
                
            
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.511 -0400", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "716A16C85AA86DAAE77C543BFF92F617")
    public void exiting(String sourceClass, String sourceMethod) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_791214517 = (!internalIsLoggable(Level.FINER));
        } 
        LogRecord record = new LogRecord(Level.FINER, "RETURN");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.511 -0400", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "55F7236849FA8C972CB77A27B16A6207")
    public void exiting(String sourceClass, String sourceMethod, Object result) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1131073770 = (!internalIsLoggable(Level.FINER));
        } 
        LogRecord record = new LogRecord(Level.FINER, "RETURN" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { result });
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(result.getTaint());
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.512 -0400", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "592EB4819E44879D472BA96CA6CD504C")
    public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_2001209095 = (!internalIsLoggable(Level.FINER));
        } 
        LogRecord record = new LogRecord(Level.FINER, "THROW");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(thrown.getTaint());
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.512 -0400", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "DDE5E0FB88269A945D7E635C2568E796")
    public void severe(String msg) {
        log(Level.SEVERE, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.513 -0400", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "D1D093B24B327F91BCFB91D1C0A25F5E")
    public void warning(String msg) {
        log(Level.WARNING, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.513 -0400", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "196EE6858040A873D7084A0F215804DA")
    public void info(String msg) {
        log(Level.INFO, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.514 -0400", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "2E44A2F72CB19492380E0B57354C2643")
    public void config(String msg) {
        log(Level.CONFIG, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.514 -0400", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "66FAD4B225BBC213641805FBDD07A714")
    public void fine(String msg) {
        log(Level.FINE, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.514 -0400", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "1404045AE4551686262BCC30403BFB10")
    public void finer(String msg) {
        log(Level.FINER, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.514 -0400", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "972D64C3C8257E783B4DD1F7EC1B593E")
    public void finest(String msg) {
        log(Level.FINEST, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.515 -0400", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "5967810634E31F303927B290ECC54C9D")
    public void log(Level logLevel, String msg) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_993892020 = (!internalIsLoggable(logLevel));
        } 
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.515 -0400", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "B9B7EE12853BC159132CA94819613750")
    public void log(Level logLevel, String msg, Object param) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_862965183 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        addTaint(param.getTaint());
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.515 -0400", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "F4D3044F99FAD054BDC1309A62D5953E")
    public void log(Level logLevel, String msg, Object[] params) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_319302885 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        addTaint(params[0].getTaint());
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.516 -0400", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "F804958B1AD2D92E5EF8EAF7FD8E1C15")
    public void log(Level logLevel, String msg, Throwable thrown) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1092199677 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        addTaint(thrown.getTaint());
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.523 -0400", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "699BBB71EFCD1601294B25918099BE1D")
    public void log(LogRecord record) {
        {
            boolean varCEC80650B67CA406CB8FB2593F3FF49E_1904909691 = (!internalIsLoggable(record.getLevel()));
        } 
        Filter f = filter;
        {
            boolean varF3C413378DE592F847ABD95948584B3B_1809621619 = (f != null && !f.isLoggable(record));
        } 
        Handler[] allHandlers = getHandlers();
        {
            Handler element = allHandlers[0];
            {
                element.publish(record);
            } 
        } 
        Logger temp = this;
        Logger theParent = temp.parent;
        {
            boolean varD5B3EB210A5448C5448650FF10241E86_1724601395 = (theParent != null && temp.getUseParentHandlers());
            {
                Handler[] ha = theParent.getHandlers();
                {
                    Handler element = ha[0];
                    {
                        element.publish(record);
                    } 
                } 
                temp = theParent;
                theParent = temp.parent;
            } 
        } 
        addTaint(record.getTaint());
        
        
            
        
        
        
            
        
        
        
            
        
        
        
        
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.523 -0400", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "E957B94D649A1C3E42B7738A84B3A808")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_106977395 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(msg.getTaint());
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.524 -0400", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "B37D922342070A4872E4261C69B636C9")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_241473551 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(msg.getTaint());
        addTaint(param.getTaint());
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.525 -0400", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "59BF44EF5F962D996C5B2F81B8BC6295")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_939866049 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(msg.getTaint());
        addTaint(params[0].getTaint());
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.525 -0400", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "460645F04B9108B7641712EF4FD02806")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_2027502486 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(msg.getTaint());
        addTaint(thrown.getTaint());
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.528 -0400", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "E9FB1F55EAEC7F829F0112393FF8CF45")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1867697965 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } 
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } 
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(msg.getTaint());
        
        
            
        
        
        
            
                
            
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.530 -0400", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "0FB7BEE72B7121A2431300185FC1067B")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object param) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1591925800 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } 
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } 
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(msg.getTaint());
        addTaint(param.getTaint());
        
        
            
        
        
        
            
                
            
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.532 -0400", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "CD86A035CD3730F882B4C720858D26B3")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object[] params) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_182974905 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } 
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } 
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(msg.getTaint());
        addTaint(params[0].getTaint());
        
        
            
        
        
        
            
                
            
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.533 -0400", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "80FFE044EEE0E6DA672F77D2A9A6BF99")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Throwable thrown) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1409768296 = (!internalIsLoggable(logLevel));
        } 
        LogRecord record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } 
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } 
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(msg.getTaint());
        addTaint(thrown.getTaint());
        
        
            
        
        
        
            
                
            
            
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.540 -0400", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "4A8492AAD3680E42F7FF4A077502C1FA")
     void reset() {
        levelObjVal = null;
        levelIntVal = Level.INFO.intValue();
        {
            Iterator<Handler> varD29CF3B96A4E0273C37FDD7A1457F1B2_935713362 = (handlers).iterator();
            varD29CF3B96A4E0273C37FDD7A1457F1B2_935713362.hasNext();
            Handler handler = varD29CF3B96A4E0273C37FDD7A1457F1B2_935713362.next();
            {
                try 
                {
                    {
                        boolean var59AEFC89230B78799BF76DB8CB63113F_1196015310 = (handlers.remove(handler));
                        {
                            handler.close();
                        } 
                    } 
                } 
                catch (Exception ignored)
                { }
            } 
        } 
        updateDalvikLogHandler();
        
        
        
        
            
                
                    
                
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_field = "C11C2AFA3BE2E8C2EACE37E50E80D018", hash_generated_field = "4D6D3020B80CE3D35D2F8F928539DCF2")

    private static final DalvikLogHandler GENERAL_LOG_HANDLER = new DalvikLogHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_method = "EC3A1A4621BA8EF22A571BDE68197799", hash_generated_method = "6101897D1D7337D250B83AA802BFD691")
        public void publish(Logger source, String tag, Level level, String message) {
            LogRecord record = new LogRecord(level, message);
            record.setLoggerName(source.name);
            source.setResourceBundle(record);
            source.log(record);
            addTaint(source.getTaint());
            addTaint(tag.getTaint());
            addTaint(level.getTaint());
            addTaint(message.getTaint());
            
            
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_field = "A44D841F27C7FAF8E708C936524E3A40", hash_generated_field = "EFFEA762C1908ADB01D1927B32F091A6")

    public static final String GLOBAL_LOGGER_NAME = "global";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_field = "5C1000D0986D94450F353B6AB42FC2EC", hash_generated_field = "E7AC46ADB144618E388DFF4E480328CF")

    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.541 -0400", hash_original_field = "AECCAFF8A9FCD49B2188D0F2F871F0AF", hash_generated_field = "46E006A6968A44BB222FB4D5DC1F24A5")

    private static final Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
}

