package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "927B896D5AC0DD7FBCC14EBF7566F9A4")

    private volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "4AE1F195790419CAC93DADD2BF6962F7")

    Logger parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "7EA955F14604E3FF10814255A6E159E7", hash_generated_field = "A8FA1EF9E438D313624ABCF6D48E27D1")

    volatile Level levelObjVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "BBCCBDCA09CAD3E5F892776736479402", hash_generated_field = "64484DD5AFFDF68559B6EA3E925D55F8")

    volatile int levelIntVal = Level.INFO.intValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "878F5AE2179223671F6F7BF03BBE54A8")

    private volatile String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "228A0F6DF977A45B5000D16BFD04B1D8", hash_generated_field = "D2720EA1493F697783188B90B5C01BC8")

    private volatile ResourceBundle resourceBundle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "D2701D1D83377E9CB140496A5C5A187D", hash_generated_field = "08A278607127F82770A06B4D402827EA")

    private List<Handler> handlers = new CopyOnWriteArrayList<Handler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "E1458F37E6588611AB594CFDB36EC40F", hash_generated_field = "A0A66C106644DF6FD3D6C7A1325B8EE1")

    private boolean notifyParentHandlers = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "857D649F32E8DB1CFE2F2EF1136A814E", hash_generated_field = "DF5415EF24FD42F5DFD2A24AF349A364")

    private boolean isNamed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "2CBC80B4B3201A743322ACE95290F75E", hash_generated_field = "073FC86CB7FF15B250FB0D9F11151601")

    List<Logger> children = new ArrayList<Logger>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "414C73EC90003063BE63D47C87377D68", hash_generated_field = "0F73A57BF2C3FEF042A9DB67B2E7D8CC")

    private String androidTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.297 -0400", hash_original_field = "2C69CB87427ECB00DBBE3B80E492283E", hash_generated_field = "B5C7FD88BFAFFDC7B0174CF578919C4C")

    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.298 -0400", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "5D4C50CD832938A7A058C0BBBCEE51C1")
    protected  Logger(String name, String resourceBundleName) {
        this.name = name;
        initResourceBundle(resourceBundleName);
        this.androidTag = DalvikLogging.loggerNameToTag(name);
        updateDalvikLogHandler();
        addTaint(resourceBundleName.getTaint());
        // ---------- Original Method ----------
        //this.name = name;
        //initResourceBundle(resourceBundleName);
        //this.androidTag = DalvikLogging.loggerNameToTag(name);
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.385 -0400", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "9BE9AF5841EF6E1F4710CB6FA0F3D265")
     void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler;
        newLogHandler = GENERAL_LOG_HANDLER;
        Logger parent;
        parent = this.parent;
        {
            boolean var8082E9C2DB777313295DD7C5CCA58548_139456566 = (getClass() != Logger.class);
            {
                Iterator<Handler> h;
                h = handlers.iterator();
                {
                    boolean var0E8FA01F9947A2DBD8802083FE3B9D0A_1219998647 = (h.hasNext());
                    {
                        Handler firstHandler;
                        firstHandler = h.next();
                        {
                            boolean var231B03ECF0BC670BB0F6657D7D9E7FC1_110198867 = (!h.hasNext() && firstHandler instanceof DalvikLogHandler);
                            {
                                newLogHandler = (DalvikLogHandler) firstHandler;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE3FD279FB120B7A5C3226227F0A90695_1041800606 = (handlers.isEmpty() && notifyParentHandlers);
                {
                    newLogHandler = parent.dalvikLogHandler;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        this.dalvikLogHandler = newLogHandler;
        {
            Iterator<Logger> var3219E9B080A57B4A0BB66CAE1B39DF50_963677887 = (children).iterator();
            var3219E9B080A57B4A0BB66CAE1B39DF50_963677887.hasNext();
            Logger logger = var3219E9B080A57B4A0BB66CAE1B39DF50_963677887.next();
            {
                logger.updateDalvikLogHandler();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
        public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    
        public static Logger getAnonymousLogger(String resourceBundleName) {
        Logger result = new Logger(null, resourceBundleName);
        result.isNamed = false;
        LogManager logManager = LogManager.getLogManager();
        logManager.setParent(result, logManager.getLogger(""));
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.386 -0400", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "B85CFC4A0FE02A290EB923DCB4AE2D42")
    private synchronized void initResourceBundle(String resourceBundleName) {
        String current;
        current = this.resourceBundleName;
        {
            {
                boolean var216EDF683781EB220AA7EF22E244048D_532734781 = (current.equals(resourceBundleName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            this.resourceBundle = loadResourceBundle(resourceBundleName);
            this.resourceBundleName = resourceBundleName;
        } //End block
        // ---------- Original Method ----------
        //String current = this.resourceBundleName;
        //if (current != null) {
            //if (current.equals(resourceBundleName)) {
                //return;
            //} else {
                //throw new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
            //}
        //}
        //if (resourceBundleName != null) {
            //this.resourceBundle = loadResourceBundle(resourceBundleName);
            //this.resourceBundleName = resourceBundleName;
        //}
    }

    
        public static Logger getLogger(String name) {
        return LogManager.getLogManager().getOrCreate(name, null);
    }

    
        public static Logger getLogger(String name, String resourceBundleName) {
        Logger result = LogManager.getLogManager()
                .getOrCreate(name, resourceBundleName);
        result.initResourceBundle(resourceBundleName);
        return result;
    }

    
        public static Logger getGlobal() {
        return global;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.411 -0400", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "0BE36FA5C3EA441D4C2E4785AC11EFA2")
    public void addHandler(Handler handler) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("handler == null");
        } //End block
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        this.handlers.add(handler);
        updateDalvikLogHandler();
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //if (handler == null) {
            //throw new NullPointerException("handler == null");
        //}
        //if (this.isNamed) {
            //LogManager.getLogManager().checkAccess();
        //}
        //this.handlers.add(handler);
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.472 -0400", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "C77DC4D45A7D692A5C9AB2EDFEF49CC9")
     void setManager(LogManager manager) {
        String levelProperty;
        levelProperty = manager.getProperty(name + ".level");
        {
            try 
            {
                manager.setLevelRecursively(Logger.this, Level.parse(levelProperty));
            } //End block
            catch (IllegalArgumentException invalidLevel)
            {
                invalidLevel.printStackTrace();
            } //End block
        } //End block
        String handlersPropertyName;
        boolean var0EDE97A700956C6503647468C3ED00AB_2013246141 = (name.isEmpty());
        handlersPropertyName = "handlers";
        handlersPropertyName = name + ".handlers";
        String handlersProperty;
        handlersProperty = manager.getProperty(handlersPropertyName);
        {
            {
                Iterator<String> varE73C679CC0125291CFBADDBCE927555A_154061979 = (handlersProperty.split(",|\\s")).iterator();
                varE73C679CC0125291CFBADDBCE927555A_154061979.hasNext();
                String handlerName = varE73C679CC0125291CFBADDBCE927555A_154061979.next();
                {
                    {
                        boolean var75740153E91B33587E112AFB85404C96_1842955902 = (handlerName.isEmpty());
                    } //End collapsed parenthetic
                    Handler handler;
                    try 
                    {
                        handler = (Handler) LogManager.getInstanceByClass(handlerName);
                    } //End block
                    catch (Exception invalidHandlerName)
                    {
                        invalidHandlerName.printStackTrace();
                    } //End block
                    try 
                    {
                        String level;
                        level = manager.getProperty(handlerName + ".level");
                        {
                            handler.setLevel(Level.parse(level));
                        } //End block
                    } //End block
                    catch (Exception invalidLevel)
                    {
                        invalidLevel.printStackTrace();
                    } //End block
                    handlers.add(handler);
                } //End block
            } //End collapsed parenthetic
        } //End block
        updateDalvikLogHandler();
        addTaint(manager.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.487 -0400", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "152AF376DE55A7AB46F1F3F97D101624")
    public Handler[] getHandlers() {
        Handler[] varB4EAC82CA7396A68D541C85D26508E83_599837050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_599837050 = handlers.toArray(EMPTY_HANDLERS_ARRAY);
        varB4EAC82CA7396A68D541C85D26508E83_599837050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599837050;
        // ---------- Original Method ----------
        //return handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.488 -0400", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "18B91AC8ED6B9173EA0E079641F08405")
    public void removeHandler(Handler handler) {
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        this.handlers.remove(handler);
        updateDalvikLogHandler();
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //if (this.isNamed) {
            //LogManager.getLogManager().checkAccess();
        //}
        //if (handler == null) {
            //return;
        //}
        //this.handlers.remove(handler);
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.489 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "80A138CB36C9EFEACA268622FC2D0990")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_621527247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_621527247 = this.filter;
        varB4EAC82CA7396A68D541C85D26508E83_621527247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_621527247;
        // ---------- Original Method ----------
        //return this.filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.489 -0400", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "4E964228E1B5C2C72B43721C7FA90FA1")
    public void setFilter(Filter newFilter) {
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        filter = newFilter;
        // ---------- Original Method ----------
        //if (this.isNamed) {
            //LogManager.getLogManager().checkAccess();
        //}
        //filter = newFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.490 -0400", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "0EECECC33352C16F66DD20CFF0FAC7A3")
    public Level getLevel() {
        Level varB4EAC82CA7396A68D541C85D26508E83_747786440 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_747786440 = levelObjVal;
        varB4EAC82CA7396A68D541C85D26508E83_747786440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747786440;
        // ---------- Original Method ----------
        //return levelObjVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.500 -0400", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "636975F95EA6615221C1C22E72806007")
    public void setLevel(Level newLevel) {
        LogManager logManager;
        logManager = LogManager.getLogManager();
        {
            logManager.checkAccess();
        } //End block
        logManager.setLevelRecursively(this, newLevel);
        addTaint(newLevel.getTaint());
        // ---------- Original Method ----------
        //LogManager logManager = LogManager.getLogManager();
        //if (this.isNamed) {
            //logManager.checkAccess();
        //}
        //logManager.setLevelRecursively(this, newLevel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.506 -0400", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "F4194EBD475C9D448F9BACE5D7CC5456")
    public boolean getUseParentHandlers() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565543702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565543702;
        // ---------- Original Method ----------
        //return this.notifyParentHandlers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.507 -0400", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "8967E1D76B120C20F46207847BEEF625")
    public void setUseParentHandlers(boolean notifyParentHandlers) {
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        this.notifyParentHandlers = notifyParentHandlers;
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        //if (this.isNamed) {
            //LogManager.getLogManager().checkAccess();
        //}
        //this.notifyParentHandlers = notifyParentHandlers;
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.507 -0400", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "42C1F9CCE8192929A8659B2342667CAA")
    public Logger getParent() {
        Logger varB4EAC82CA7396A68D541C85D26508E83_1582451247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1582451247 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1582451247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1582451247;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.508 -0400", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "07E7C2A01AC21C52DEB8DC9458962213")
    public void setParent(Logger parent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("parent == null");
        } //End block
        LogManager logManager;
        logManager = LogManager.getLogManager();
        logManager.checkAccess();
        logManager.setParent(this, parent);
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
        //if (parent == null) {
            //throw new NullPointerException("parent == null");
        //}
        //LogManager logManager = LogManager.getLogManager();
        //logManager.checkAccess();
        //logManager.setParent(this, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.521 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "3A52EE3DE8AFDD169E469EFBAC40E073")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_934316997 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_934316997 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_934316997.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_934316997;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.522 -0400", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "D081A79FA815D1B1B97F3C243FA9D6CA")
    public ResourceBundle getResourceBundle() {
        ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_939421299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_939421299 = this.resourceBundle;
        varB4EAC82CA7396A68D541C85D26508E83_939421299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_939421299;
        // ---------- Original Method ----------
        //return this.resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.522 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "7F66B72BC4B4664485771613B8E2218E")
    public String getResourceBundleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1970082043 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1970082043 = this.resourceBundleName;
        varB4EAC82CA7396A68D541C85D26508E83_1970082043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1970082043;
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.523 -0400", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "B25AB11E4C6DBA2E057413F5EE8A9ECE")
    private boolean internalIsLoggable(Level l) {
        int effectiveLevel;
        effectiveLevel = levelIntVal;
        {
            boolean var3BA3DAFD15E9AE35A708BCDFA8AF3F3D_236350320 = (effectiveLevel == Level.OFF.intValue());
        } //End collapsed parenthetic
        boolean var4DE3913B1115D82F6261A3311500085D_1190045889 = (l.intValue() >= effectiveLevel);
        addTaint(l.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840387860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840387860;
        // ---------- Original Method ----------
        //int effectiveLevel = levelIntVal;
        //if (effectiveLevel == Level.OFF.intValue()) {
            //return false;
        //}
        //return l.intValue() >= effectiveLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.523 -0400", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "A24EA251B7F213D37464192CE8F7E317")
    public boolean isLoggable(Level l) {
        boolean var7D8A791108905A03A9325B0476185D5F_305564969 = (internalIsLoggable(l));
        addTaint(l.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647972512 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647972512;
        // ---------- Original Method ----------
        //return internalIsLoggable(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.524 -0400", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "AAAF51F0BD3B2D10C2077E05C31F829C")
    private void setResourceBundle(LogRecord record) {
        {
            Logger p;
            p = this;
            p = p.parent;
            {
                String resourceBundleName;
                resourceBundleName = p.resourceBundleName;
                {
                    record.setResourceBundle(p.resourceBundle);
                    record.setResourceBundleName(resourceBundleName);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(record.getTaint());
        // ---------- Original Method ----------
        //for (Logger p = this; p != null; p = p.parent) {
            //String resourceBundleName = p.resourceBundleName;
            //if (resourceBundleName != null) {
                //record.setResourceBundle(p.resourceBundle);
                //record.setResourceBundleName(resourceBundleName);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.540 -0400", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "83F589C4CEA8035F3F6CB1AD89609E05")
    public void entering(String sourceClass, String sourceMethod) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1693699600 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "ENTRY");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(Level.FINER)) {
            //return;
        //}
        //LogRecord record = new LogRecord(Level.FINER, "ENTRY");
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.544 -0400", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "E8DA5B94AFB8544DC8A6486C80A9B1C9")
    public void entering(String sourceClass, String sourceMethod, Object param) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1810602042 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "ENTRY" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(param.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(Level.FINER)) {
            //return;
        //}
        //LogRecord record = new LogRecord(Level.FINER, "ENTRY" + " {0}");
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(new Object[] { param });
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.549 -0400", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "760332FF708E7094CF8BE0307546083F")
    public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1246236832 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        String msg;
        msg = "ENTRY";
        {
            StringBuilder msgBuffer;
            msgBuffer = new StringBuilder("ENTRY");
            {
                int i;
                i = 0;
                {
                    msgBuffer.append(" {").append(i).append("}");
                } //End block
            } //End collapsed parenthetic
            msg = msgBuffer.toString();
        } //End block
        LogRecord record;
        record = new LogRecord(Level.FINER, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(params[0].getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(Level.FINER)) {
            //return;
        //}
        //String msg = "ENTRY";
        //if (params != null) {
            //StringBuilder msgBuffer = new StringBuilder("ENTRY");
            //for (int i = 0; i < params.length; i++) {
                //msgBuffer.append(" {").append(i).append("}");
            //}
            //msg = msgBuffer.toString();
        //}
        //LogRecord record = new LogRecord(Level.FINER, msg);
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(params);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.552 -0400", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "F7F11700F2E3E8B5C78D806F0A3E39BB")
    public void exiting(String sourceClass, String sourceMethod) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_553119169 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "RETURN");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(Level.FINER)) {
            //return;
        //}
        //LogRecord record = new LogRecord(Level.FINER, "RETURN");
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.562 -0400", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "D88BC81B813A59678ED2287CD3B8A2AB")
    public void exiting(String sourceClass, String sourceMethod, Object result) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_140094002 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "RETURN" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { result });
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(Level.FINER)) {
            //return;
        //}
        //LogRecord record = new LogRecord(Level.FINER, "RETURN" + " {0}");
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(new Object[] { result });
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.563 -0400", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "A6CF3861F5F1A3402557478308C042F8")
    public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_94926617 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "THROW");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(thrown.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(Level.FINER)) {
            //return;
        //}
        //LogRecord record = new LogRecord(Level.FINER, "THROW");
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setThrown(thrown);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.564 -0400", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "DDE5E0FB88269A945D7E635C2568E796")
    public void severe(String msg) {
        log(Level.SEVERE, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.SEVERE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.564 -0400", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "D1D093B24B327F91BCFB91D1C0A25F5E")
    public void warning(String msg) {
        log(Level.WARNING, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.WARNING, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.580 -0400", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "196EE6858040A873D7084A0F215804DA")
    public void info(String msg) {
        log(Level.INFO, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.INFO, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.581 -0400", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "2E44A2F72CB19492380E0B57354C2643")
    public void config(String msg) {
        log(Level.CONFIG, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.CONFIG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.581 -0400", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "66FAD4B225BBC213641805FBDD07A714")
    public void fine(String msg) {
        log(Level.FINE, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.581 -0400", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "1404045AE4551686262BCC30403BFB10")
    public void finer(String msg) {
        log(Level.FINER, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINER, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.581 -0400", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "972D64C3C8257E783B4DD1F7EC1B593E")
    public void finest(String msg) {
        log(Level.FINEST, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINEST, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.582 -0400", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "E4FEDA7F18290F2FBFD7E966F3CB86D9")
    public void log(Level logLevel, String msg) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1292697246 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //dalvikLogHandler.publish(this, androidTag, logLevel, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.583 -0400", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "7E51E8315D05C996827450D0C5DDB68E")
    public void log(Level logLevel, String msg, Object param) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_180077355 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        addTaint(param.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setParameters(new Object[] { param });
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.583 -0400", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "55E2352E4F216E76C12CBB16DA98DCBF")
    public void log(Level logLevel, String msg, Object[] params) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_171913567 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        addTaint(params[0].getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setParameters(params);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.589 -0400", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "5BBD48DACAC9D1F016E1BFF7B7272C7A")
    public void log(Level logLevel, String msg, Throwable thrown) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_492239223 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(msg.getTaint());
        addTaint(thrown.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setThrown(thrown);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.666 -0400", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "3FCB8E734997825319931550A5877990")
    public void log(LogRecord record) {
        {
            boolean varCEC80650B67CA406CB8FB2593F3FF49E_361718163 = (!internalIsLoggable(record.getLevel()));
        } //End collapsed parenthetic
        Filter f;
        f = filter;
        {
            boolean varF3C413378DE592F847ABD95948584B3B_641360056 = (f != null && !f.isLoggable(record));
        } //End collapsed parenthetic
        Handler[] allHandlers;
        allHandlers = getHandlers();
        {
            Iterator<Handler> var79E6CA946AC687C9AA56962C363B4C22_1056619802 = (allHandlers).iterator();
            var79E6CA946AC687C9AA56962C363B4C22_1056619802.hasNext();
            Handler element = var79E6CA946AC687C9AA56962C363B4C22_1056619802.next();
            {
                element.publish(record);
            } //End block
        } //End collapsed parenthetic
        Logger temp;
        temp = this;
        Logger theParent;
        theParent = temp.parent;
        {
            boolean varD5B3EB210A5448C5448650FF10241E86_279841474 = (theParent != null && temp.getUseParentHandlers());
            {
                Handler[] ha;
                ha = theParent.getHandlers();
                {
                    Iterator<Handler> varA8DCF7259B7B42815A41D448E92657BD_108333587 = (ha).iterator();
                    varA8DCF7259B7B42815A41D448E92657BD_108333587.hasNext();
                    Handler element = varA8DCF7259B7B42815A41D448E92657BD_108333587.next();
                    {
                        element.publish(record);
                    } //End block
                } //End collapsed parenthetic
                temp = theParent;
                theParent = temp.parent;
            } //End block
        } //End collapsed parenthetic
        addTaint(record.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(record.getLevel())) {
            //return;
        //}
        //Filter f = filter;
        //if (f != null && !f.isLoggable(record)) {
            //return;
        //}
        //Handler[] allHandlers = getHandlers();
        //for (Handler element : allHandlers) {
            //element.publish(record);
        //}
        //Logger temp = this;
        //Logger theParent = temp.parent;
        //while (theParent != null && temp.getUseParentHandlers()) {
            //Handler[] ha = theParent.getHandlers();
            //for (Handler element : ha) {
                //element.publish(record);
            //}
            //temp = theParent;
            //theParent = temp.parent;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.667 -0400", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "393AFD5EC87CC4BBEBD8DBF42141A1DC")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_280685409 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.674 -0400", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "DEF63809C97AE381DCD8376044AF821A")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_312288902 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
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
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(new Object[] { param });
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.675 -0400", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "1CFF8D943BC05F5F03220F4A04A876FE")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1793877630 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
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
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(params);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.676 -0400", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "6C1F5A3EB866DE8B978860E85CFCD052")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1964491256 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
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
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setThrown(thrown);
        //setResourceBundle(record);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.681 -0400", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "288DAB43C98A7618A3A0439370914BA7")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1933623978 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } //End block
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        log(record);
        addTaint(logLevel.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //if (bundleName != null) {
            //try {
                //record.setResourceBundle(loadResourceBundle(bundleName));
            //} catch (MissingResourceException e) {
            //}
            //record.setResourceBundleName(bundleName);
        //}
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.689 -0400", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "ABBA26D40ECC25E6B7409EA854E3BB4B")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object param) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_912925261 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } //End block
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
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //if (bundleName != null) {
            //try {
                //record.setResourceBundle(loadResourceBundle(bundleName));
            //} catch (MissingResourceException e) {
            //}
            //record.setResourceBundleName(bundleName);
        //}
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(new Object[] { param });
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.704 -0400", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "9FE7D4927254165C16562A42F844B491")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object[] params) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1965337253 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } //End block
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
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //if (bundleName != null) {
            //try {
                //record.setResourceBundle(loadResourceBundle(bundleName));
            //} catch (MissingResourceException e) {
            //}
            //record.setResourceBundleName(bundleName);
        //}
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setParameters(params);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.705 -0400", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "0F1F68BF085EC249B39D4BF3692F87ED")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Throwable thrown) {
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_644596769 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            { }
            record.setResourceBundleName(bundleName);
        } //End block
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
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //LogRecord record = new LogRecord(logLevel, msg);
        //if (bundleName != null) {
            //try {
                //record.setResourceBundle(loadResourceBundle(bundleName));
            //} catch (MissingResourceException e) {
            //}
            //record.setResourceBundleName(bundleName);
        //}
        //record.setLoggerName(this.name);
        //record.setSourceClassName(sourceClass);
        //record.setSourceMethodName(sourceMethod);
        //record.setThrown(thrown);
        //log(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.781 -0400", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "B99622D7994202249B46F63807BF3471")
     void reset() {
        levelObjVal = null;
        levelIntVal = Level.INFO.intValue();
        {
            Iterator<Handler> varD29CF3B96A4E0273C37FDD7A1457F1B2_187656025 = (handlers).iterator();
            varD29CF3B96A4E0273C37FDD7A1457F1B2_187656025.hasNext();
            Handler handler = varD29CF3B96A4E0273C37FDD7A1457F1B2_187656025.next();
            {
                try 
                {
                    {
                        boolean var59AEFC89230B78799BF76DB8CB63113F_1268451616 = (handlers.remove(handler));
                        {
                            handler.close();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (Exception ignored)
                { }
            } //End block
        } //End collapsed parenthetic
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        //levelObjVal = null;
        //levelIntVal = Level.INFO.intValue();
        //for (Handler handler : handlers) {
            //try {
                //if (handlers.remove(handler)) {
                    //handler.close();
                //}
            //} catch (Exception ignored) {
            //}
        //}
        //updateDalvikLogHandler();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.799 -0400", hash_original_field = "C11C2AFA3BE2E8C2EACE37E50E80D018", hash_generated_field = "C6448E3D403FF993BA223CA211AC2BF5")

    private static DalvikLogHandler GENERAL_LOG_HANDLER = new DalvikLogHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.786 -0400", hash_original_method = "EC3A1A4621BA8EF22A571BDE68197799", hash_generated_method = "5FB35E2A31E3657682D90EAA8914F066")
        public void publish(Logger source, String tag, Level level, String message) {
            LogRecord record;
            record = new LogRecord(level, message);
            record.setLoggerName(source.name);
            source.setResourceBundle(record);
            source.log(record);
            addTaint(source.getTaint());
            addTaint(tag.getTaint());
            addTaint(level.getTaint());
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            //LogRecord record = new LogRecord(level, message);
            //record.setLoggerName(source.name);
            //source.setResourceBundle(record);
            //source.log(record);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.799 -0400", hash_original_field = "A44D841F27C7FAF8E708C936524E3A40", hash_generated_field = "EFFEA762C1908ADB01D1927B32F091A6")

    public static final String GLOBAL_LOGGER_NAME = "global";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.799 -0400", hash_original_field = "5C1000D0986D94450F353B6AB42FC2EC", hash_generated_field = "E7AC46ADB144618E388DFF4E480328CF")

    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.799 -0400", hash_original_field = "AECCAFF8A9FCD49B2188D0F2F871F0AF", hash_generated_field = "7A473108A264098900FDC39B4C7F1A2C")

    private static Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
}

