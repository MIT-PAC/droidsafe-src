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
    private static final DalvikLogHandler GENERAL_LOG_HANDLER = new DalvikLogHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.310 -0400", hash_original_method = "EC3A1A4621BA8EF22A571BDE68197799", hash_generated_method = "CFED754D4915BE4C172EFACE3D09C32A")
        @DSModeled(DSC.SAFE)
        public void publish(Logger source, String tag, Level level, String message) {
            dsTaint.addTaint(message);
            dsTaint.addTaint(level.dsTaint);
            dsTaint.addTaint(source.dsTaint);
            dsTaint.addTaint(tag);
            LogRecord record;
            record = new LogRecord(level, message);
            record.setLoggerName(source.name);
            source.setResourceBundle(record);
            source.log(record);
            // ---------- Original Method ----------
            //LogRecord record = new LogRecord(level, message);
            //record.setLoggerName(source.name);
            //source.setResourceBundle(record);
            //source.log(record);
        }

        
}; //Transformed anonymous class
    public static String GLOBAL_LOGGER_NAME = "global";
    @Deprecated public static Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    private static Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
    private volatile String name;
    Logger parent;
    volatile Level levelObjVal;
    volatile int levelIntVal = Level.INFO.intValue();
    private Filter filter;
    private volatile String resourceBundleName;
    private volatile ResourceBundle resourceBundle;
    private List<Handler> handlers = new CopyOnWriteArrayList<Handler>();
    private boolean notifyParentHandlers = true;
    private boolean isNamed = true;
    List<Logger> children = new ArrayList<Logger>();
    private String androidTag;
    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.322 -0400", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "D6A360AFD7EB2517087843C73B7995B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Logger(String name, String resourceBundleName) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(resourceBundleName);
        initResourceBundle(resourceBundleName);
        this.androidTag = DalvikLogging.loggerNameToTag(name);
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        //this.name = name;
        //initResourceBundle(resourceBundleName);
        //this.androidTag = DalvikLogging.loggerNameToTag(name);
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.346 -0400", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "406159621B2A8DCE11F786BAA6E97781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler;
        newLogHandler = GENERAL_LOG_HANDLER;
        Logger parent;
        parent = this.parent;
        {
            boolean var8082E9C2DB777313295DD7C5CCA58548_100291631 = (getClass() != Logger.class);
            {
                Iterator<Handler> h;
                h = handlers.iterator();
                {
                    boolean var0E8FA01F9947A2DBD8802083FE3B9D0A_639872691 = (h.hasNext());
                    {
                        Handler firstHandler;
                        firstHandler = h.next();
                        {
                            boolean var231B03ECF0BC670BB0F6657D7D9E7FC1_1021825464 = (!h.hasNext() && firstHandler instanceof DalvikLogHandler);
                            {
                                newLogHandler = (DalvikLogHandler) firstHandler;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE3FD279FB120B7A5C3226227F0A90695_567726509 = (handlers.isEmpty() && notifyParentHandlers);
                {
                    newLogHandler = parent.dalvikLogHandler;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        this.dalvikLogHandler = newLogHandler;
        {
            Iterator<Logger> seatecAstronomy42 = children.iterator();
            seatecAstronomy42.hasNext();
            Logger logger = seatecAstronomy42.next();
            {
                logger.updateDalvikLogHandler();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.363 -0400", hash_original_method = "0FBB80F13AF6F3A9057E687D9BCE4FB9", hash_generated_method = "F58D2CF4F9E8AF55A521B3D5C13FC1BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.372 -0400", hash_original_method = "33E35DAF5713B97A634B9F1AE8BF6A88", hash_generated_method = "4F3F4A4ED61E1528BB083EE36635ECD1")
    public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.379 -0400", hash_original_method = "B4C3A3B0A9BA44ADFC2BA61E72362AA6", hash_generated_method = "4C65D3BC21A9BB37FE27523143F7A8B5")
    public static Logger getAnonymousLogger(String resourceBundleName) {
        Logger result = new Logger(null, resourceBundleName);
        result.isNamed = false;
        LogManager logManager = LogManager.getLogManager();
        logManager.setParent(result, logManager.getLogger(""));
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.390 -0400", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "FE537696E3CD15B49866DCE2DD8D19ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void initResourceBundle(String resourceBundleName) {
        dsTaint.addTaint(resourceBundleName);
        String current;
        current = this.resourceBundleName;
        {
            {
                boolean var216EDF683781EB220AA7EF22E244048D_191283513 = (current.equals(resourceBundleName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            this.resourceBundle = loadResourceBundle(resourceBundleName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.400 -0400", hash_original_method = "CCC6971033B3E92E36973DF1CB62F316", hash_generated_method = "809F3C4D6A84AB87A94C2B953B2694E5")
    public static Logger getLogger(String name) {
        return LogManager.getLogManager().getOrCreate(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.403 -0400", hash_original_method = "FF215F56C3D4087B17E522721EB89987", hash_generated_method = "42AB9F239C505B8562FF36527980C955")
    public static Logger getLogger(String name, String resourceBundleName) {
        Logger result = LogManager.getLogManager()
                .getOrCreate(name, resourceBundleName);
        result.initResourceBundle(resourceBundleName);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.412 -0400", hash_original_method = "2D16380526A24256011C5D09E6CFA82F", hash_generated_method = "856042E979E1555090872CCD036A3CC4")
    public static Logger getGlobal() {
        return global;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.418 -0400", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "4ECF3E515FF5ADC132FD3D2A23738117")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addHandler(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("handler == null");
        } //End block
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        this.handlers.add(handler);
        updateDalvikLogHandler();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.457 -0400", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "939B8797AE4C6720F26D5458E2F0C3C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setManager(LogManager manager) {
        dsTaint.addTaint(manager.dsTaint);
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
        boolean var0EDE97A700956C6503647468C3ED00AB_443913497 = (name.isEmpty());
        handlersPropertyName = "handlers";
        handlersPropertyName = name + ".handlers";
        String handlersProperty;
        handlersProperty = manager.getProperty(handlersPropertyName);
        {
            {
                String[] strArray = handlersProperty.split(",|\\s");
                
                String handlerName = strArray[0];
                {
                    {
                        boolean var75740153E91B33587E112AFB85404C96_1795801679 = (handlerName.isEmpty());
                    } //End collapsed parenthetic
                    Handler handler;
                    try 
                    {
                        String level;
                        handler = (Handler) LogManager.getInstanceByClass(handlerName);
                        level = manager.getProperty(handlerName + ".level");
                        handler.setLevel(Level.parse(level));
                        handlers.add(handler);
                    } //End block
                    catch (Exception invalidHandlerName)
                    {
                        invalidHandlerName.printStackTrace();
                    } //End block
                    
                } //End block
            } //End collapsed parenthetic
        } //End block
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.470 -0400", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "AADF4246A9202D83C9EFB2FAB9FA0F6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler[] getHandlers() {
        Handler[] var91DE5C8B84311275A8DA7D2CA750457C_333348392 = (handlers.toArray(EMPTY_HANDLERS_ARRAY));
        return (Handler[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.482 -0400", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "EC4F9BB95EA47C0289B43518BF897D37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeHandler(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        this.handlers.remove(handler);
        updateDalvikLogHandler();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.493 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "732FAE90C2EF6F05D29D57861BD4FF7C")
    @DSModeled(DSC.SAFE)
    public Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.504 -0400", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "68F040AF49339F1C5F0C79A326913B73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilter(Filter newFilter) {
        dsTaint.addTaint(newFilter.dsTaint);
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        // ---------- Original Method ----------
        //if (this.isNamed) {
            //LogManager.getLogManager().checkAccess();
        //}
        //filter = newFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.513 -0400", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "5FDD03D43C679BC75EC82EFEEF647FBE")
    @DSModeled(DSC.SAFE)
    public Level getLevel() {
        return (Level)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return levelObjVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.519 -0400", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "93AD71714010A2881BF187461628C0BB")
    @DSModeled(DSC.SAFE)
    public void setLevel(Level newLevel) {
        dsTaint.addTaint(newLevel.dsTaint);
        LogManager logManager;
        logManager = LogManager.getLogManager();
        {
            logManager.checkAccess();
        } //End block
        logManager.setLevelRecursively(this, newLevel);
        // ---------- Original Method ----------
        //LogManager logManager = LogManager.getLogManager();
        //if (this.isNamed) {
            //logManager.checkAccess();
        //}
        //logManager.setLevelRecursively(this, newLevel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.527 -0400", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "0AA7556691F05734BA4DF2B79F776D5D")
    @DSModeled(DSC.SAFE)
    public boolean getUseParentHandlers() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.notifyParentHandlers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.529 -0400", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "AA5C430F2DA68EE68A970F7A80E76D63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUseParentHandlers(boolean notifyParentHandlers) {
        dsTaint.addTaint(notifyParentHandlers);
        {
            LogManager.getLogManager().checkAccess();
        } //End block
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        //if (this.isNamed) {
            //LogManager.getLogManager().checkAccess();
        //}
        //this.notifyParentHandlers = notifyParentHandlers;
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.537 -0400", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "F8CB13AC5621D98EBB35B715214E78F9")
    @DSModeled(DSC.SAFE)
    public Logger getParent() {
        return (Logger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.540 -0400", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "12DD72860D2585C66E5E1B6A5C354734")
    @DSModeled(DSC.SAFE)
    public void setParent(Logger parent) {
        dsTaint.addTaint(parent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("parent == null");
        } //End block
        LogManager logManager;
        logManager = LogManager.getLogManager();
        logManager.checkAccess();
        logManager.setParent(this, parent);
        // ---------- Original Method ----------
        //if (parent == null) {
            //throw new NullPointerException("parent == null");
        //}
        //LogManager logManager = LogManager.getLogManager();
        //logManager.checkAccess();
        //logManager.setParent(this, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.546 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "EF43AF6ECA190C096749521B6824B37F")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.548 -0400", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "7D9F6625CA0EED0A7F8A3DAC85912FCE")
    @DSModeled(DSC.SAFE)
    public ResourceBundle getResourceBundle() {
        return (ResourceBundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.550 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "CE5B7275BC807D2AF266823600A91FBE")
    @DSModeled(DSC.SAFE)
    public String getResourceBundleName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.553 -0400", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "A1759A6D70D4AA1DC839CB4C4CB8C54F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean internalIsLoggable(Level l) {
        dsTaint.addTaint(l.dsTaint);
        int effectiveLevel;
        effectiveLevel = levelIntVal;
        {
            boolean var3BA3DAFD15E9AE35A708BCDFA8AF3F3D_2125472665 = (effectiveLevel == Level.OFF.intValue());
        } //End collapsed parenthetic
        boolean var4DE3913B1115D82F6261A3311500085D_2137571373 = (l.intValue() >= effectiveLevel);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int effectiveLevel = levelIntVal;
        //if (effectiveLevel == Level.OFF.intValue()) {
            //return false;
        //}
        //return l.intValue() >= effectiveLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.564 -0400", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "7151A03E67F45DF3880404DC684D177C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoggable(Level l) {
        dsTaint.addTaint(l.dsTaint);
        boolean var7D8A791108905A03A9325B0476185D5F_1389554775 = (internalIsLoggable(l));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return internalIsLoggable(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.568 -0400", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "A1B1B789A8E06136A2699E4FE02A453E")
    @DSModeled(DSC.SAFE)
    private void setResourceBundle(LogRecord record) {
        dsTaint.addTaint(record.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.580 -0400", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "D7E83002E2BB8E7F1CF97AFBBF0EEAF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_888982237 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "ENTRY");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.592 -0400", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "321438CB201E72A52B97C7E494D31678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(param.dsTaint);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_948753124 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "ENTRY" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.610 -0400", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "B937D3BEC1D1A26CCA6460C3B029D26C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(params[0].dsTaint);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1809815047 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.615 -0400", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "648C9B968D6F2AB482D70049C20CB245")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exiting(String sourceClass, String sourceMethod) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1089555107 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "RETURN");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.618 -0400", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "D940FB0A89C0AA68BD35CD0D0A05D7FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exiting(String sourceClass, String sourceMethod, Object result) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_2111976129 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "RETURN" + " {0}");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { result });
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.621 -0400", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "BF2D7AEBA63A622512FAEE6595867885")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_216417265 = (!internalIsLoggable(Level.FINER));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(Level.FINER, "THROW");
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.626 -0400", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "827556A506B346F7779716B5D9012C0F")
    @DSModeled(DSC.SAFE)
    public void severe(String msg) {
        dsTaint.addTaint(msg);
        log(Level.SEVERE, msg);
        // ---------- Original Method ----------
        //log(Level.SEVERE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.629 -0400", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "2CD9EEE6D1B9FCE4D62874538F72ACA1")
    @DSModeled(DSC.SAFE)
    public void warning(String msg) {
        dsTaint.addTaint(msg);
        log(Level.WARNING, msg);
        // ---------- Original Method ----------
        //log(Level.WARNING, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.633 -0400", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "EB81BE799BE96F148D6942B9DE50ADF5")
    @DSModeled(DSC.SAFE)
    public void info(String msg) {
        dsTaint.addTaint(msg);
        log(Level.INFO, msg);
        // ---------- Original Method ----------
        //log(Level.INFO, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.635 -0400", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "21D2BE304E1F395769D3CF9AA3767212")
    @DSModeled(DSC.SAFE)
    public void config(String msg) {
        dsTaint.addTaint(msg);
        log(Level.CONFIG, msg);
        // ---------- Original Method ----------
        //log(Level.CONFIG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.636 -0400", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "3EDF1AFE0818FE87E12D3F9E649FCD83")
    @DSModeled(DSC.SAFE)
    public void fine(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINE, msg);
        // ---------- Original Method ----------
        //log(Level.FINE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.638 -0400", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "7775F9A6FA247020B8538C73B83DAC5F")
    @DSModeled(DSC.SAFE)
    public void finer(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINER, msg);
        // ---------- Original Method ----------
        //log(Level.FINER, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.640 -0400", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "D3AB02C8F09003340DB22ECB035515C0")
    @DSModeled(DSC.SAFE)
    public void finest(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINEST, msg);
        // ---------- Original Method ----------
        //log(Level.FINEST, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.643 -0400", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "8F1D483C343F17C02E4FABDF89FA4FFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1634961038 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //dalvikLogHandler.publish(this, androidTag, logLevel, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.646 -0400", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "9510075A3CE98FA46DFF7E09B3B1B228")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Object param) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1710296538 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.648 -0400", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "D3E1A4110885B0C652352B2624974311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Object[] params) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params[0].dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_761312640 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.654 -0400", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "E13E6C87A78D18090E5935B908015DB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Throwable thrown) {
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_191731060 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.664 -0400", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "8E7652FE04E1F2BAF0E213274DB55D40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(LogRecord record) {
        dsTaint.addTaint(record.dsTaint);
        {
            boolean varCEC80650B67CA406CB8FB2593F3FF49E_1067497448 = (!internalIsLoggable(record.getLevel()));
        } //End collapsed parenthetic
        Filter f;
        f = filter;
        {
            boolean varF3C413378DE592F847ABD95948584B3B_2130768317 = (f != null && !f.isLoggable(record));
        } //End collapsed parenthetic
        Handler[] allHandlers;
        allHandlers = getHandlers();
        {
            Handler element = allHandlers[0];
            {
                element.publish(record);
            } //End block
        } //End collapsed parenthetic
        Logger temp;
        temp = this;
        Logger theParent;
        theParent = temp.parent;
        {
            boolean varD5B3EB210A5448C5448650FF10241E86_1134969937 = (theParent != null && temp.getUseParentHandlers());
            {
                Handler[] ha;
                ha = theParent.getHandlers();
                {
                    Handler element = ha[0];
                    {
                        element.publish(record);
                    } //End block
                } //End collapsed parenthetic
                temp = theParent;
                theParent = temp.parent;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.667 -0400", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "95AF1370DE634F05EE735952A61BBB37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_222411129 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.672 -0400", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "7331896E7083821BDBEDB12EB56A9A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_336679250 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(new Object[] { param });
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.679 -0400", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "18ADAE3E76EABFE7AA29358D41B89BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params[0].dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_393237131 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setParameters(params);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.690 -0400", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "456A2C9F6EEC16CACBBA94D230904A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_645171923 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        LogRecord record;
        record = new LogRecord(logLevel, msg);
        record.setLoggerName(this.name);
        record.setSourceClassName(sourceClass);
        record.setSourceMethodName(sourceMethod);
        record.setThrown(thrown);
        setResourceBundle(record);
        log(record);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.700 -0400", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "E55E34A7AF32B7F0C9090447B867B03E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1796636312 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.704 -0400", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "26E55EB930E75F5A04B139A15B5D423E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_2101107282 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.713 -0400", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "9BF1A8EAFD1C3D323ED9DC9B7AC37463")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params[0].dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1988113603 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.717 -0400", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "8E71C38F393455B868252BF2519244CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1831610002 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.721 -0400", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "754F8FE2F3D04A5EDC85A5855E0F832C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reset() {
        levelObjVal = null;
        levelIntVal = Level.INFO.intValue();
        {
            Iterator<Handler> seatecAstronomy42 = handlers.iterator();
            seatecAstronomy42.hasNext();
            Handler handler = seatecAstronomy42.next();
            {
                try 
                {
                    {
                        boolean var59AEFC89230B78799BF76DB8CB63113F_2133028986 = (handlers.remove(handler));
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

    
}


