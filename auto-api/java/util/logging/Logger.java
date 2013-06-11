package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.748 -0400", hash_original_method = "EC3A1A4621BA8EF22A571BDE68197799", hash_generated_method = "CFED754D4915BE4C172EFACE3D09C32A")
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
    public static final String GLOBAL_LOGGER_NAME = "global";
    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    private static final Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
    private volatile String name;
    Logger parent;
    volatile Level levelObjVal;
    volatile int levelIntVal = Level.INFO.intValue();
    private Filter filter;
    private volatile String resourceBundleName;
    private volatile ResourceBundle resourceBundle;
    private final List<Handler> handlers = new CopyOnWriteArrayList<Handler>();
    private boolean notifyParentHandlers = true;
    private boolean isNamed = true;
    final List<Logger> children = new ArrayList<Logger>();
    private final String androidTag;
    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.748 -0400", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "D6A360AFD7EB2517087843C73B7995B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "7D2BA1B380EACB59C3C7F1220234D7C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler;
        newLogHandler = GENERAL_LOG_HANDLER;
        Logger parent;
        parent = this.parent;
        {
            boolean var8082E9C2DB777313295DD7C5CCA58548_767717975 = (getClass() != Logger.class);
            {
                Iterator<Handler> h;
                h = handlers.iterator();
                {
                    boolean var0E8FA01F9947A2DBD8802083FE3B9D0A_285164971 = (h.hasNext());
                    {
                        Handler firstHandler;
                        firstHandler = h.next();
                        {
                            boolean var231B03ECF0BC670BB0F6657D7D9E7FC1_2006751971 = (!h.hasNext() && firstHandler instanceof DalvikLogHandler);
                            {
                                newLogHandler = (DalvikLogHandler) firstHandler;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE3FD279FB120B7A5C3226227F0A90695_1130589758 = (handlers.isEmpty() && notifyParentHandlers);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "0FBB80F13AF6F3A9057E687D9BCE4FB9", hash_generated_method = "F58D2CF4F9E8AF55A521B3D5C13FC1BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "33E35DAF5713B97A634B9F1AE8BF6A88", hash_generated_method = "4F3F4A4ED61E1528BB083EE36635ECD1")
    public static Logger getAnonymousLogger() {
        return getAnonymousLogger(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "B4C3A3B0A9BA44ADFC2BA61E72362AA6", hash_generated_method = "4C65D3BC21A9BB37FE27523143F7A8B5")
    public static Logger getAnonymousLogger(String resourceBundleName) {
        Logger result = new Logger(null, resourceBundleName);
        result.isNamed = false;
        LogManager logManager = LogManager.getLogManager();
        logManager.setParent(result, logManager.getLogger(""));
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "37706ED3CF1FE61E61DC47958A226134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void initResourceBundle(String resourceBundleName) {
        dsTaint.addTaint(resourceBundleName);
        String current;
        current = this.resourceBundleName;
        {
            {
                boolean var216EDF683781EB220AA7EF22E244048D_874131085 = (current.equals(resourceBundleName));
                {
                    throw new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "CCC6971033B3E92E36973DF1CB62F316", hash_generated_method = "809F3C4D6A84AB87A94C2B953B2694E5")
    public static Logger getLogger(String name) {
        return LogManager.getLogManager().getOrCreate(name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "FF215F56C3D4087B17E522721EB89987", hash_generated_method = "42AB9F239C505B8562FF36527980C955")
    public static Logger getLogger(String name, String resourceBundleName) {
        Logger result = LogManager.getLogManager()
                .getOrCreate(name, resourceBundleName);
        result.initResourceBundle(resourceBundleName);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "2D16380526A24256011C5D09E6CFA82F", hash_generated_method = "856042E979E1555090872CCD036A3CC4")
    public static Logger getGlobal() {
        return global;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "D8E072D079187091A71E7E0D66C60AC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addHandler(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        {
            throw new NullPointerException("handler == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.749 -0400", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "D5F3F8E2C9B1C52916335F5984EE7122")
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
        boolean var0EDE97A700956C6503647468C3ED00AB_684541854 = (name.isEmpty());
        handlersPropertyName = "handlers";
        handlersPropertyName = name + ".handlers";
        String handlersProperty;
        handlersProperty = manager.getProperty(handlersPropertyName);
        {
            {
                Iterator<String> seatecAstronomy42 = handlersProperty.split(",|\\s").iterator();
                seatecAstronomy42.hasNext();
                String handlerName = seatecAstronomy42.next();
                {
                    {
                        boolean var75740153E91B33587E112AFB85404C96_121322717 = (handlerName.isEmpty());
                    } //End collapsed parenthetic
                    final Handler handler;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "F15D2A1D8E1996A0AEC84D41C504A2B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler[] getHandlers() {
        Handler[] var91DE5C8B84311275A8DA7D2CA750457C_1532209784 = (handlers.toArray(EMPTY_HANDLERS_ARRAY));
        return (Handler[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "EC4F9BB95EA47C0289B43518BF897D37")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "732FAE90C2EF6F05D29D57861BD4FF7C")
    @DSModeled(DSC.SAFE)
    public Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "68F040AF49339F1C5F0C79A326913B73")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "5FDD03D43C679BC75EC82EFEEF647FBE")
    @DSModeled(DSC.SAFE)
    public Level getLevel() {
        return (Level)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return levelObjVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "93AD71714010A2881BF187461628C0BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.750 -0400", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "0AA7556691F05734BA4DF2B79F776D5D")
    @DSModeled(DSC.SAFE)
    public boolean getUseParentHandlers() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.notifyParentHandlers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.758 -0400", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "AA5C430F2DA68EE68A970F7A80E76D63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "F8CB13AC5621D98EBB35B715214E78F9")
    @DSModeled(DSC.SAFE)
    public Logger getParent() {
        return (Logger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "4C8FD3B52F737306DFB446CB2F71FEE4")
    @DSModeled(DSC.SAFE)
    public void setParent(Logger parent) {
        dsTaint.addTaint(parent.dsTaint);
        {
            throw new NullPointerException("parent == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "EF43AF6ECA190C096749521B6824B37F")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "7D9F6625CA0EED0A7F8A3DAC85912FCE")
    @DSModeled(DSC.SAFE)
    public ResourceBundle getResourceBundle() {
        return (ResourceBundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "CE5B7275BC807D2AF266823600A91FBE")
    @DSModeled(DSC.SAFE)
    public String getResourceBundleName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "D833D022F61DF20B5980DC40FBB1345B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean internalIsLoggable(Level l) {
        dsTaint.addTaint(l.dsTaint);
        int effectiveLevel;
        effectiveLevel = levelIntVal;
        {
            boolean var3BA3DAFD15E9AE35A708BCDFA8AF3F3D_241619738 = (effectiveLevel == Level.OFF.intValue());
        } //End collapsed parenthetic
        boolean var4DE3913B1115D82F6261A3311500085D_1587609587 = (l.intValue() >= effectiveLevel);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int effectiveLevel = levelIntVal;
        //if (effectiveLevel == Level.OFF.intValue()) {
            //return false;
        //}
        //return l.intValue() >= effectiveLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "48144C7BA2B9576376682B7DFEE6C6F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoggable(Level l) {
        dsTaint.addTaint(l.dsTaint);
        boolean var7D8A791108905A03A9325B0476185D5F_1014477229 = (internalIsLoggable(l));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return internalIsLoggable(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "A1B1B789A8E06136A2699E4FE02A453E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "3E1446BE11F4B0FFC78EBAB60D419F8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1338831398 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "964E0BCA0821762995CC6C13D45F4F63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(param.dsTaint);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1201685984 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.759 -0400", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "F4D6204D1457818F787D9DCA2D7ACCD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(params.dsTaint);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_211996335 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "C7B02065B529FA0F241992156992AC6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exiting(String sourceClass, String sourceMethod) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_445777103 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "7A2969FA1433027046688FC36AB58983")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exiting(String sourceClass, String sourceMethod, Object result) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1941230141 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "49CEAE6CD7E564F6DB92B6AB0F32BC05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_765684184 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "827556A506B346F7779716B5D9012C0F")
    @DSModeled(DSC.SAFE)
    public void severe(String msg) {
        dsTaint.addTaint(msg);
        log(Level.SEVERE, msg);
        // ---------- Original Method ----------
        //log(Level.SEVERE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "2CD9EEE6D1B9FCE4D62874538F72ACA1")
    @DSModeled(DSC.SAFE)
    public void warning(String msg) {
        dsTaint.addTaint(msg);
        log(Level.WARNING, msg);
        // ---------- Original Method ----------
        //log(Level.WARNING, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "EB81BE799BE96F148D6942B9DE50ADF5")
    @DSModeled(DSC.SAFE)
    public void info(String msg) {
        dsTaint.addTaint(msg);
        log(Level.INFO, msg);
        // ---------- Original Method ----------
        //log(Level.INFO, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "21D2BE304E1F395769D3CF9AA3767212")
    @DSModeled(DSC.SAFE)
    public void config(String msg) {
        dsTaint.addTaint(msg);
        log(Level.CONFIG, msg);
        // ---------- Original Method ----------
        //log(Level.CONFIG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "3EDF1AFE0818FE87E12D3F9E649FCD83")
    @DSModeled(DSC.SAFE)
    public void fine(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINE, msg);
        // ---------- Original Method ----------
        //log(Level.FINE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "7775F9A6FA247020B8538C73B83DAC5F")
    @DSModeled(DSC.SAFE)
    public void finer(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINER, msg);
        // ---------- Original Method ----------
        //log(Level.FINER, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "D3AB02C8F09003340DB22ECB035515C0")
    @DSModeled(DSC.SAFE)
    public void finest(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINEST, msg);
        // ---------- Original Method ----------
        //log(Level.FINEST, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "FC5B08A4CE44EB779F81562841469386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1960110626 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //dalvikLogHandler.publish(this, androidTag, logLevel, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "1CE46BE0EB998283412DDC093E4B91FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Object param) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_552172844 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "9AA6C8FC440286F90BA1D7904B351667")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Object[] params) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_675907173 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.760 -0400", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "8ED67D965A8C08014F3DA9D801FDCABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Throwable thrown) {
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_911875572 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "6775B68E12B1B2CF55C9E26C95FFB2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(LogRecord record) {
        dsTaint.addTaint(record.dsTaint);
        {
            boolean varCEC80650B67CA406CB8FB2593F3FF49E_608724910 = (!internalIsLoggable(record.getLevel()));
        } //End collapsed parenthetic
        Filter f;
        f = filter;
        {
            boolean varF3C413378DE592F847ABD95948584B3B_1405936859 = (f != null && !f.isLoggable(record));
        } //End collapsed parenthetic
        Handler[] allHandlers;
        allHandlers = getHandlers();
        {
            Iterator<Handler> seatecAstronomy42 = allHandlers.iterator();
            seatecAstronomy42.hasNext();
            Handler element = seatecAstronomy42.next();
            {
                element.publish(record);
            } //End block
        } //End collapsed parenthetic
        Logger temp;
        temp = this;
        Logger theParent;
        theParent = temp.parent;
        {
            boolean varD5B3EB210A5448C5448650FF10241E86_815845841 = (theParent != null && temp.getUseParentHandlers());
            {
                Handler[] ha;
                ha = theParent.getHandlers();
                {
                    Iterator<Handler> seatecAstronomy42 = ha.iterator();
                    seatecAstronomy42.hasNext();
                    Handler element = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "1CB7358BBA6F9FBBB6B42A380D87358D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_2139228166 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "1FF0EF437EB76B1B227A06BA11C5EFBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1522264745 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "CF17910A8873619CA221149643EC4884")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_490548365 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "4EAC64582A99B06F30DDE85197F9C5A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_884452563 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "ABB7883BB8036BB0C96B601FD3CA24D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1623481594 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.761 -0400", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "98A7995A749F37E9172B8F2A6590D009")
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
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_430838160 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.762 -0400", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "3CAF5EE335B16808A992AD325D0C34BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_536400145 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.762 -0400", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "8971C92F3CA5FD5AB8F8C3441C0D3BF8")
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
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1282868967 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.762 -0400", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "E5E4EC5ED61A349DAA8D835A5D0D82F7")
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
                        boolean var59AEFC89230B78799BF76DB8CB63113F_1793105486 = (handlers.remove(handler));
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


