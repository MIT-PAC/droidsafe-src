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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.538 -0400", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "CF9D229FFEC38946499DD549583A41ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.542 -0400", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "A3DC2AB809B6BB104F876175A3B56912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler;
        newLogHandler = GENERAL_LOG_HANDLER;
        Logger parent;
        parent = this.parent;
        {
            boolean var8082E9C2DB777313295DD7C5CCA58548_793109111 = (getClass() != Logger.class);
            {
                Iterator<Handler> h;
                h = handlers.iterator();
                {
                    boolean var0E8FA01F9947A2DBD8802083FE3B9D0A_2035091828 = (h.hasNext());
                    {
                        Handler firstHandler;
                        firstHandler = h.next();
                        {
                            boolean var231B03ECF0BC670BB0F6657D7D9E7FC1_1809894709 = (!h.hasNext() && firstHandler instanceof DalvikLogHandler);
                            {
                                newLogHandler = (DalvikLogHandler) firstHandler;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE3FD279FB120B7A5C3226227F0A90695_1123258938 = (handlers.isEmpty() && notifyParentHandlers);
                {
                    newLogHandler = parent.dalvikLogHandler;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        this.dalvikLogHandler = newLogHandler;
        {
            Iterator<Logger> var3219E9B080A57B4A0BB66CAE1B39DF50_973718901 = (children).iterator();
            var3219E9B080A57B4A0BB66CAE1B39DF50_973718901.hasNext();
            Logger logger = var3219E9B080A57B4A0BB66CAE1B39DF50_973718901.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.543 -0400", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "5B4BE61702D725868BC55599A0A473E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void initResourceBundle(String resourceBundleName) {
        dsTaint.addTaint(resourceBundleName);
        String current;
        current = this.resourceBundleName;
        {
            {
                boolean var216EDF683781EB220AA7EF22E244048D_1983842793 = (current.equals(resourceBundleName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.544 -0400", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "53F595D225670473324B7964FE91D746")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.572 -0400", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "638393408927323363FEEE0C2F4A9811")
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
        boolean var0EDE97A700956C6503647468C3ED00AB_2020236286 = (name.isEmpty());
        handlersPropertyName = "handlers";
        handlersPropertyName = name + ".handlers";
        String handlersProperty;
        handlersProperty = manager.getProperty(handlersPropertyName);
        {
            {
                String handlerName = handlersProperty.split(",|\\s")[0];
                {
                    {
                        boolean var75740153E91B33587E112AFB85404C96_1930164256 = (handlerName.isEmpty());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.573 -0400", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "D28C79C94CC2ED9255D51F23A24153C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler[] getHandlers() {
        Handler[] var91DE5C8B84311275A8DA7D2CA750457C_965630729 = (handlers.toArray(EMPTY_HANDLERS_ARRAY));
        return (Handler[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.573 -0400", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "7BB90B712C43355AAC248CECF854E5F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.573 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "D8A8AF43B6C8B000F5C5653B78CB536B")
    @DSModeled(DSC.SAFE)
    public Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.573 -0400", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "D3F5F13E3BFE17A1519DE4C97D9E6FDD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.573 -0400", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "7CE413F9D2CA15B62B7F1610E870A54C")
    @DSModeled(DSC.SAFE)
    public Level getLevel() {
        return (Level)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return levelObjVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.574 -0400", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "E05DEE310A0AE60E6335E1C0EF84E20A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.585 -0400", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "7A0E1A44AC1850CA63EBEA67C392EE39")
    @DSModeled(DSC.SAFE)
    public boolean getUseParentHandlers() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.notifyParentHandlers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.586 -0400", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "6D6DA2ADDC86F0A2D5A6E8D5D85A434B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.586 -0400", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "B41CD9CD4A8FE21DF5E6E06F053A8530")
    @DSModeled(DSC.SAFE)
    public Logger getParent() {
        return (Logger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.587 -0400", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "645A55E5DA685FCA36F4A3E37BC9E708")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.588 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "D0204CF69F339F288BA81592D96CB511")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.588 -0400", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "EF1115534C302815AF5DA3A83F8DA2B8")
    @DSModeled(DSC.SAFE)
    public ResourceBundle getResourceBundle() {
        return (ResourceBundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.588 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "D0F1094615BC29A067FA3283598F1536")
    @DSModeled(DSC.SAFE)
    public String getResourceBundleName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.590 -0400", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "2927A190451703C51FC2625CF8D33120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean internalIsLoggable(Level l) {
        dsTaint.addTaint(l.dsTaint);
        int effectiveLevel;
        effectiveLevel = levelIntVal;
        {
            boolean var3BA3DAFD15E9AE35A708BCDFA8AF3F3D_380612952 = (effectiveLevel == Level.OFF.intValue());
        } //End collapsed parenthetic
        boolean var4DE3913B1115D82F6261A3311500085D_1128347575 = (l.intValue() >= effectiveLevel);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int effectiveLevel = levelIntVal;
        //if (effectiveLevel == Level.OFF.intValue()) {
            //return false;
        //}
        //return l.intValue() >= effectiveLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.591 -0400", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "30DB9FE59255BF5256BE3E2E0B44A702")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoggable(Level l) {
        dsTaint.addTaint(l.dsTaint);
        boolean var7D8A791108905A03A9325B0476185D5F_807499848 = (internalIsLoggable(l));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return internalIsLoggable(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.591 -0400", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "E6C706BA2178A11B3FD81804D2B2A041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.591 -0400", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "9D7F3AB027EADD3ECAC6EF5303975730")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_376270422 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.597 -0400", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "8E109387AC217D3E9DB1FCFA3DB964F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(param.dsTaint);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_672970735 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.597 -0400", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "BF338C6E0979F6E77A98EACEB664559A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(params[0].dsTaint);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_255553051 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.598 -0400", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "C256E8AAD8296968339C1C392892DBA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exiting(String sourceClass, String sourceMethod) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_1434558574 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.598 -0400", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "2CF33BE8DC1B048291D0054CE442E4E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exiting(String sourceClass, String sourceMethod, Object result) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_910398658 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.598 -0400", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "DA9F4557D04DCD215F143A091EC7B043")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        {
            boolean var0C803763CEE485D1F9F8913EE26EDCA8_91905912 = (!internalIsLoggable(Level.FINER));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "C8A37B8FBB503EE429231FA531515353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void severe(String msg) {
        dsTaint.addTaint(msg);
        log(Level.SEVERE, msg);
        // ---------- Original Method ----------
        //log(Level.SEVERE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "16327836D1EEFA33A96836C89C2AA23F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void warning(String msg) {
        dsTaint.addTaint(msg);
        log(Level.WARNING, msg);
        // ---------- Original Method ----------
        //log(Level.WARNING, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "9E86BF36A39E95CA825047DFF57BCEB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void info(String msg) {
        dsTaint.addTaint(msg);
        log(Level.INFO, msg);
        // ---------- Original Method ----------
        //log(Level.INFO, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "48FD199363BD4F31F1690F1E6BAD8F7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void config(String msg) {
        dsTaint.addTaint(msg);
        log(Level.CONFIG, msg);
        // ---------- Original Method ----------
        //log(Level.CONFIG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "C21E62B8F97F89A9A65FED8480EDE73C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fine(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINE, msg);
        // ---------- Original Method ----------
        //log(Level.FINE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "B0862A2B83204859873D378FCA16BE16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finer(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINER, msg);
        // ---------- Original Method ----------
        //log(Level.FINER, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.599 -0400", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "3FD6CB8D04CC7D10CB1CB47D9AF71CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finest(String msg) {
        dsTaint.addTaint(msg);
        log(Level.FINEST, msg);
        // ---------- Original Method ----------
        //log(Level.FINEST, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.600 -0400", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "AC6054A8E1E84EE6BACAC1990FEED520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_120479650 = (!internalIsLoggable(logLevel));
        } //End collapsed parenthetic
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //dalvikLogHandler.publish(this, androidTag, logLevel, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.600 -0400", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "591F369D729DDAAB6CCCC105CC16C5C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Object param) {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_622983533 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.600 -0400", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "EB7C8A8D7DDEA5EC9033AFCEADCBA7CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Object[] params) {
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params[0].dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_456836844 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.600 -0400", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "4FCDB6EB0B569F3AA36FAA9CAF8F1D25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(Level logLevel, String msg, Throwable thrown) {
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1895272651 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.613 -0400", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "BD5E7FC3B181F1B956D9232EDB3C9613")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void log(LogRecord record) {
        dsTaint.addTaint(record.dsTaint);
        {
            boolean varCEC80650B67CA406CB8FB2593F3FF49E_1984971054 = (!internalIsLoggable(record.getLevel()));
        } //End collapsed parenthetic
        Filter f;
        f = filter;
        {
            boolean varF3C413378DE592F847ABD95948584B3B_43940779 = (f != null && !f.isLoggable(record));
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
            boolean varD5B3EB210A5448C5448650FF10241E86_552670429 = (theParent != null && temp.getUseParentHandlers());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.618 -0400", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "C67A88609833A5165E5739209CCC610D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1639234747 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.618 -0400", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "CCEAC4E80AD082A2ECB12D3B20AF4CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_421102221 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.621 -0400", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "1377E7FD007E25CD3BE0A530558EEB03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(params[0].dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1241868957 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.621 -0400", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "5CA3ABA4E188658B9344485DCB9C2722")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(thrown.dsTaint);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_912660099 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.621 -0400", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "4E3C26AA9D5AAE7C8968699806EBB563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_2069812812 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.622 -0400", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "13DC2AB08D3E4DB51C950800C8CAAF6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object param) {
        dsTaint.addTaint(sourceClass);
        dsTaint.addTaint(sourceMethod);
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(logLevel.dsTaint);
        dsTaint.addTaint(bundleName);
        dsTaint.addTaint(msg);
        {
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1636405662 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.622 -0400", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "AF723C16964D211D09081A9F923EA265")
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
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_570082158 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.623 -0400", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "4F44109CF1D84ACAA175F02C099823B8")
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
            boolean varA3B4B40B24BEAEBBCE610018F7D9BCAC_1188327097 = (!internalIsLoggable(logLevel));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.629 -0400", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "46BE3280E71B9C03B7EB023DB41077F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reset() {
        levelObjVal = null;
        levelIntVal = Level.INFO.intValue();
        {
            Iterator<Handler> varD29CF3B96A4E0273C37FDD7A1457F1B2_1086218314 = (handlers).iterator();
            varD29CF3B96A4E0273C37FDD7A1457F1B2_1086218314.hasNext();
            Handler handler = varD29CF3B96A4E0273C37FDD7A1457F1B2_1086218314.next();
            {
                try 
                {
                    {
                        boolean var59AEFC89230B78799BF76DB8CB63113F_1469456936 = (handlers.remove(handler));
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

    
    private static final DalvikLogHandler GENERAL_LOG_HANDLER = new DalvikLogHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.629 -0400", hash_original_method = "EC3A1A4621BA8EF22A571BDE68197799", hash_generated_method = "AEDFB32978E05A676E749178762CD7D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
    @Deprecated public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    private static final Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
}

