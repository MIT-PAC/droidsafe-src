package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "927B896D5AC0DD7FBCC14EBF7566F9A4")

    private volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "4AE1F195790419CAC93DADD2BF6962F7")

    Logger parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "7EA955F14604E3FF10814255A6E159E7", hash_generated_field = "A8FA1EF9E438D313624ABCF6D48E27D1")

    volatile Level levelObjVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "BBCCBDCA09CAD3E5F892776736479402", hash_generated_field = "64484DD5AFFDF68559B6EA3E925D55F8")

    volatile int levelIntVal = Level.INFO.intValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "878F5AE2179223671F6F7BF03BBE54A8")

    private volatile String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "228A0F6DF977A45B5000D16BFD04B1D8", hash_generated_field = "D2720EA1493F697783188B90B5C01BC8")

    private volatile ResourceBundle resourceBundle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "D2701D1D83377E9CB140496A5C5A187D", hash_generated_field = "0713314804552265A9281F5BE4F5F4B2")

    private final List<Handler> handlers = new CopyOnWriteArrayList<Handler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.289 -0400", hash_original_field = "E1458F37E6588611AB594CFDB36EC40F", hash_generated_field = "A0A66C106644DF6FD3D6C7A1325B8EE1")

    private boolean notifyParentHandlers = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.290 -0400", hash_original_field = "857D649F32E8DB1CFE2F2EF1136A814E", hash_generated_field = "DF5415EF24FD42F5DFD2A24AF349A364")

    private boolean isNamed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.290 -0400", hash_original_field = "2CBC80B4B3201A743322ACE95290F75E", hash_generated_field = "766EA8FEA2309436285546014402AC5C")

    final List<Logger> children = new ArrayList<Logger>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.290 -0400", hash_original_field = "414C73EC90003063BE63D47C87377D68", hash_generated_field = "0F73A57BF2C3FEF042A9DB67B2E7D8CC")

    private String androidTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.290 -0400", hash_original_field = "2C69CB87427ECB00DBBE3B80E492283E", hash_generated_field = "B5C7FD88BFAFFDC7B0174CF578919C4C")

    private volatile DalvikLogHandler dalvikLogHandler = GENERAL_LOG_HANDLER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.290 -0400", hash_original_method = "1D8BB758275405206E6B2E9C876A4290", hash_generated_method = "13027EFBDA67B26CF1931AEC057D585C")
    protected  Logger(String name, String resourceBundleName) {
        addTaint(resourceBundleName.getTaint());
        this.name = name;
        initResourceBundle(resourceBundleName);
        this.androidTag = DalvikLogging.loggerNameToTag(name);
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        //this.name = name;
        //initResourceBundle(resourceBundleName);
        //this.androidTag = DalvikLogging.loggerNameToTag(name);
        //updateDalvikLogHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.291 -0400", hash_original_method = "A65BD0ACD527953E44A5CA711754E9EF", hash_generated_method = "958FA75C47575C81F7ED3076334849D4")
     void updateDalvikLogHandler() {
        DalvikLogHandler newLogHandler = GENERAL_LOG_HANDLER;
        Logger parent = this.parent;
    if(getClass() != Logger.class)        
        {
        } //End block
        else
    if(parent == null)        
        {
            Iterator<Handler> h = handlers.iterator();
    if(h.hasNext())            
            {
                Handler firstHandler = h.next();
    if(!h.hasNext() && firstHandler instanceof DalvikLogHandler)                
                {
                    newLogHandler = (DalvikLogHandler) firstHandler;
                } //End block
            } //End block
        } //End block
        else
    if(handlers.isEmpty() && notifyParentHandlers)        
        {
            newLogHandler = parent.dalvikLogHandler;
        } //End block
    if(newLogHandler == this.dalvikLogHandler)        
        {
            return;
        } //End block
        this.dalvikLogHandler = newLogHandler;
for(Logger logger : children)
        {
            logger.updateDalvikLogHandler();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.293 -0400", hash_original_method = "D16C95477ED680F14972EC7ADA3B262B", hash_generated_method = "1467EDA43C525691DE2D6609276DBA5C")
    private synchronized void initResourceBundle(String resourceBundleName) {
        String current = this.resourceBundleName;
    if(current != null)        
        {
    if(current.equals(resourceBundleName))            
            {
                return;
            } //End block
            else
            {
                IllegalArgumentException var0C7E4C68E330E9A585ADE61B347002C8_559302358 = new IllegalArgumentException("Resource bundle name '" + resourceBundleName + "' is inconsistent with the existing '" + current + "'");
                var0C7E4C68E330E9A585ADE61B347002C8_559302358.addTaint(taint);
                throw var0C7E4C68E330E9A585ADE61B347002C8_559302358;
            } //End block
        } //End block
    if(resourceBundleName != null)        
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

    
        @DSModeled(DSC.SAFE)
    public static Logger getGlobal() {
        return global;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.294 -0400", hash_original_method = "2FD32B9DFD5DCFE05DC088CD4FA8465B", hash_generated_method = "1337B6BF7F398797817162F414B044CC")
    public void addHandler(Handler handler) {
        addTaint(handler.getTaint());
    if(handler == null)        
        {
            NullPointerException varD94467648DCE8F6C33B5B75FE7E11924_1215272533 = new NullPointerException("handler == null");
            varD94467648DCE8F6C33B5B75FE7E11924_1215272533.addTaint(taint);
            throw varD94467648DCE8F6C33B5B75FE7E11924_1215272533;
        } //End block
    if(this.isNamed)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.295 -0400", hash_original_method = "4498A4914B339ECC6C0CA41B926DD713", hash_generated_method = "F51B3838081615BD6EE153DCE7913CCD")
     void setManager(LogManager manager) {
        addTaint(manager.getTaint());
        String levelProperty = manager.getProperty(name + ".level");
    if(levelProperty != null)        
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
        String handlersPropertyName = name.isEmpty() ? "handlers" : name + ".handlers";
        String handlersProperty = manager.getProperty(handlersPropertyName);
    if(handlersProperty != null)        
        {
for(String handlerName : handlersProperty.split(",|\\s"))
            {
    if(handlerName.isEmpty())                
                {
                    continue;
                } //End block
                Handler handler;
                try 
                {
                    handler = (Handler) LogManager.getInstanceByClass(handlerName);
                } //End block
                catch (Exception invalidHandlerName)
                {
                    invalidHandlerName.printStackTrace();
                    continue;
                } //End block
                try 
                {
                    String level = manager.getProperty(handlerName + ".level");
    if(level != null)                    
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
        } //End block
        updateDalvikLogHandler();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.295 -0400", hash_original_method = "D35F92CFE982311DBD9E9FEE03E15B2B", hash_generated_method = "8D6F3E96DF2CA28D8D5EDFEAB22F10D5")
    public Handler[] getHandlers() {
Handler[] var7DFEE2B406F94D1161333B5592CCF858_674286114 =         handlers.toArray(EMPTY_HANDLERS_ARRAY);
        var7DFEE2B406F94D1161333B5592CCF858_674286114.addTaint(taint);
        return var7DFEE2B406F94D1161333B5592CCF858_674286114;
        // ---------- Original Method ----------
        //return handlers.toArray(EMPTY_HANDLERS_ARRAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.295 -0400", hash_original_method = "A43956F6FF4A555825F3E2E8A2C0DABA", hash_generated_method = "EC30E1D14C225952C44F6D75E4B9E296")
    public void removeHandler(Handler handler) {
        addTaint(handler.getTaint());
    if(this.isNamed)        
        {
            LogManager.getLogManager().checkAccess();
        } //End block
    if(handler == null)        
        {
            return;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.296 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "DDE8C33D47C82F944ADA4B021E92CEEC")
    public Filter getFilter() {
Filter varF4BCC990D13B6FB90061D986D6021A1C_396740250 =         this.filter;
        varF4BCC990D13B6FB90061D986D6021A1C_396740250.addTaint(taint);
        return varF4BCC990D13B6FB90061D986D6021A1C_396740250;
        // ---------- Original Method ----------
        //return this.filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.296 -0400", hash_original_method = "0E2D68C1F12BA79B78C63ABA0F5E7F4B", hash_generated_method = "63B408FE291AFDCB9498115F7EB2C6FF")
    public void setFilter(Filter newFilter) {
    if(this.isNamed)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.296 -0400", hash_original_method = "3F355CE89E0EE57A0DB84D006A07C845", hash_generated_method = "4A8F36CD26EFF2EDB22AE613A17B27C8")
    public Level getLevel() {
Level var19366AD307578EF1EF7369985F45E237_2047053456 =         levelObjVal;
        var19366AD307578EF1EF7369985F45E237_2047053456.addTaint(taint);
        return var19366AD307578EF1EF7369985F45E237_2047053456;
        // ---------- Original Method ----------
        //return levelObjVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.297 -0400", hash_original_method = "A22BCABA235F652C19E494DC3670D961", hash_generated_method = "02C9B200143CD1F75FEF5B5C7BA93092")
    public void setLevel(Level newLevel) {
        addTaint(newLevel.getTaint());
        LogManager logManager = LogManager.getLogManager();
    if(this.isNamed)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.297 -0400", hash_original_method = "CCA5825C72A21AC8149EE8CEDF71F9CA", hash_generated_method = "55CE662247DE22A38D822401F7DACA49")
    public boolean getUseParentHandlers() {
        boolean var359200521EA4AF90F2157461EA3B1156_1775903342 = (this.notifyParentHandlers);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493152438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493152438;
        // ---------- Original Method ----------
        //return this.notifyParentHandlers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.297 -0400", hash_original_method = "E23FE44C48868B5C35BC87B2943F3AE9", hash_generated_method = "C7F0256F72788500B822A5B99FBBDDB5")
    public void setUseParentHandlers(boolean notifyParentHandlers) {
    if(this.isNamed)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.297 -0400", hash_original_method = "D6DD5625D7FB63425531FBDC14C2C588", hash_generated_method = "2BF6FB880FD233A4CEE577E863760CD9")
    public Logger getParent() {
Logger var0F49909EA73F8892C338E4DCA6EB9906_1803805965 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_1803805965.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_1803805965;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.298 -0400", hash_original_method = "CA5B70091ADA98C1F80949A654E9C997", hash_generated_method = "148687FEC2091D0E9BFD11E98B41F519")
    public void setParent(Logger parent) {
        addTaint(parent.getTaint());
    if(parent == null)        
        {
            NullPointerException varED1EDCABC9DE1352BD636F2377072BDB_1783228849 = new NullPointerException("parent == null");
            varED1EDCABC9DE1352BD636F2377072BDB_1783228849.addTaint(taint);
            throw varED1EDCABC9DE1352BD636F2377072BDB_1783228849;
        } //End block
        LogManager logManager = LogManager.getLogManager();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.298 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "72BB82075BA907AC8F1404A72B43C5E3")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_72791942 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_72791942.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_72791942;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.298 -0400", hash_original_method = "F4E0ADD33B644C89C9AC3464A381F4B1", hash_generated_method = "2CFC7F18208A47566476C878512EA40F")
    public ResourceBundle getResourceBundle() {
ResourceBundle varC4BB4F177E4A53F8D883432CFBA5CE1B_2101647147 =         this.resourceBundle;
        varC4BB4F177E4A53F8D883432CFBA5CE1B_2101647147.addTaint(taint);
        return varC4BB4F177E4A53F8D883432CFBA5CE1B_2101647147;
        // ---------- Original Method ----------
        //return this.resourceBundle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.298 -0400", hash_original_method = "6DEDF515FC3DFB06F00973FF806B7B79", hash_generated_method = "47272425B3924D973C2384666499B557")
    public String getResourceBundleName() {
String var7214CEE3997909E522736F52DB465A8B_101628735 =         this.resourceBundleName;
        var7214CEE3997909E522736F52DB465A8B_101628735.addTaint(taint);
        return var7214CEE3997909E522736F52DB465A8B_101628735;
        // ---------- Original Method ----------
        //return this.resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.299 -0400", hash_original_method = "E806564A12DA7CFA1DDB69B8445E1F80", hash_generated_method = "B9BCDB71E015AD0CF74FF6F6E74AEDCE")
    private boolean internalIsLoggable(Level l) {
        addTaint(l.getTaint());
        int effectiveLevel = levelIntVal;
    if(effectiveLevel == Level.OFF.intValue())        
        {
            boolean var68934A3E9455FA72420237EB05902327_981572953 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889639849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889639849;
        } //End block
        boolean varE6D42ED43E0C30A0FA96F3134E36F286_91249247 = (l.intValue() >= effectiveLevel);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763914799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763914799;
        // ---------- Original Method ----------
        //int effectiveLevel = levelIntVal;
        //if (effectiveLevel == Level.OFF.intValue()) {
            //return false;
        //}
        //return l.intValue() >= effectiveLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.299 -0400", hash_original_method = "904F2CC481716D2A69398E078779E717", hash_generated_method = "A4F596E95EE98773BE6DC9A59B2955F7")
    public boolean isLoggable(Level l) {
        addTaint(l.getTaint());
        boolean var056978985C7ABD11CD14A9348214A9F8_994613409 = (internalIsLoggable(l));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298383855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_298383855;
        // ---------- Original Method ----------
        //return internalIsLoggable(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.299 -0400", hash_original_method = "B262787C5366F934ED8D0783BCB7A8ED", hash_generated_method = "FEFFB63644A09559B7B193E945822767")
    private void setResourceBundle(LogRecord record) {
        addTaint(record.getTaint());
for(Logger p = this;p != null;p = p.parent)
        {
            String resourceBundleName = p.resourceBundleName;
    if(resourceBundleName != null)            
            {
                record.setResourceBundle(p.resourceBundle);
                record.setResourceBundleName(resourceBundleName);
                return;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.300 -0400", hash_original_method = "3FDD12BFA1E5F41EFA3DCA8DAF3F8D9F", hash_generated_method = "C159833DE15DCF50165315896344F240")
    public void entering(String sourceClass, String sourceMethod) {
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
    if(!internalIsLoggable(Level.FINER))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(Level.FINER, "ENTRY");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.300 -0400", hash_original_method = "30331B942349E1ED77644344328B24B8", hash_generated_method = "FE9E8FFA4B350158D5F8307138A32649")
    public void entering(String sourceClass, String sourceMethod, Object param) {
        addTaint(param.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
    if(!internalIsLoggable(Level.FINER))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(Level.FINER, "ENTRY" + " {0}");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.301 -0400", hash_original_method = "4CDEB71F3BB68629704CB3C9764A2824", hash_generated_method = "E6674227F34F7EA8E3B71F56B5ACEB07")
    public void entering(String sourceClass, String sourceMethod,
            Object[] params) {
        addTaint(params[0].getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
    if(!internalIsLoggable(Level.FINER))        
        {
            return;
        } //End block
        String msg = "ENTRY";
    if(params != null)        
        {
            StringBuilder msgBuffer = new StringBuilder("ENTRY");
for(int i = 0;i < params.length;i++)
            {
                msgBuffer.append(" {").append(i).append("}");
            } //End block
            msg = msgBuffer.toString();
        } //End block
        LogRecord record = new LogRecord(Level.FINER, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.317 -0400", hash_original_method = "5643A2B1B5FAC235C4DE2EC8C7693844", hash_generated_method = "8BF7212D7590FB65BF3FCE7E278AF76A")
    public void exiting(String sourceClass, String sourceMethod) {
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
    if(!internalIsLoggable(Level.FINER))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(Level.FINER, "RETURN");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.317 -0400", hash_original_method = "A8486907C07CFE595BEA93BBC027D860", hash_generated_method = "50E93B940895FDAEC2A04FC10D334B7E")
    public void exiting(String sourceClass, String sourceMethod, Object result) {
        addTaint(result.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
    if(!internalIsLoggable(Level.FINER))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(Level.FINER, "RETURN" + " {0}");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.317 -0400", hash_original_method = "0F67D7DC907F4143CCD404340D551A9F", hash_generated_method = "0BBD137563D64216703A1443302AB20B")
    public void throwing(String sourceClass, String sourceMethod,
            Throwable thrown) {
        addTaint(thrown.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
    if(!internalIsLoggable(Level.FINER))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(Level.FINER, "THROW");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "39E3D8B91640D479DA185B55C5F18ED7", hash_generated_method = "372EA054B303A093CFBDBC8CB22560DA")
    public void severe(String msg) {
        addTaint(msg.getTaint());
        log(Level.SEVERE, msg);
        // ---------- Original Method ----------
        //log(Level.SEVERE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "9B873E08976E1118628273040FB34C9B", hash_generated_method = "3C8E0E770F394810E2C550810329BFCA")
    public void warning(String msg) {
        addTaint(msg.getTaint());
        log(Level.WARNING, msg);
        // ---------- Original Method ----------
        //log(Level.WARNING, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "A33A2B3E69AB56EF6FB383879DD3AA60", hash_generated_method = "1A061F8BF724B90A5B87596FFD99088D")
    public void info(String msg) {
        addTaint(msg.getTaint());
        log(Level.INFO, msg);
        // ---------- Original Method ----------
        //log(Level.INFO, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "FA1693D82C99B7D6A098E0FAFDF58531", hash_generated_method = "0BB529B0FE138C87671982187916180C")
    public void config(String msg) {
        addTaint(msg.getTaint());
        log(Level.CONFIG, msg);
        // ---------- Original Method ----------
        //log(Level.CONFIG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "F6C08EB4A1B7FF590904F23378CA203B", hash_generated_method = "86BF437236FD9CA4F3E42378E0D65084")
    public void fine(String msg) {
        addTaint(msg.getTaint());
        log(Level.FINE, msg);
        // ---------- Original Method ----------
        //log(Level.FINE, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "BDE1FC441CA35DFD3241F221A003EC65", hash_generated_method = "2B5EC753412ECD9415EBB390D10A92B4")
    public void finer(String msg) {
        addTaint(msg.getTaint());
        log(Level.FINER, msg);
        // ---------- Original Method ----------
        //log(Level.FINER, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "7D6923F097D9A9DF067FAFD9A825154D", hash_generated_method = "F6F204EC3C1AF34025834266E2877CC0")
    public void finest(String msg) {
        addTaint(msg.getTaint());
        log(Level.FINEST, msg);
        // ---------- Original Method ----------
        //log(Level.FINEST, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "0FA200A9B65429375731C8E52EE8CDC0", hash_generated_method = "861C6383E06C7B3CFB316CFE42345E48")
    public void log(Level logLevel, String msg) {
        addTaint(msg.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        dalvikLogHandler.publish(this, androidTag, logLevel, msg);
        // ---------- Original Method ----------
        //if (!internalIsLoggable(logLevel)) {
            //return;
        //}
        //dalvikLogHandler.publish(this, androidTag, logLevel, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "D979CE3AE03009B0125FD7C45D827AC8", hash_generated_method = "C26030A027D81F04EFDBB0A6DFF6C38A")
    public void log(Level logLevel, String msg, Object param) {
        addTaint(param.getTaint());
        addTaint(msg.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.318 -0400", hash_original_method = "ABCEA4F06C4D017F6CAEB91F3D863D84", hash_generated_method = "2E80F8F953E39F0F77C2BF8990A850F5")
    public void log(Level logLevel, String msg, Object[] params) {
        addTaint(params[0].getTaint());
        addTaint(msg.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.319 -0400", hash_original_method = "716D8C8B34FB6F1C9D3989DC5260DE1A", hash_generated_method = "F0AF29C2B9CF9BF7355648ACC56EA949")
    public void log(Level logLevel, String msg, Throwable thrown) {
        addTaint(thrown.getTaint());
        addTaint(msg.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.319 -0400", hash_original_method = "C1F56DDBB680AA085D861AC11B4970DE", hash_generated_method = "1ACCC0556952E37A218283C3CC24F75A")
    public void log(LogRecord record) {
        addTaint(record.getTaint());
    if(!internalIsLoggable(record.getLevel()))        
        {
            return;
        } //End block
        Filter f = filter;
    if(f != null && !f.isLoggable(record))        
        {
            return;
        } //End block
        Handler[] allHandlers = getHandlers();
for(Handler element : allHandlers)
        {
            element.publish(record);
        } //End block
        Logger temp = this;
        Logger theParent = temp.parent;
        while
(theParent != null && temp.getUseParentHandlers())        
        {
            Handler[] ha = theParent.getHandlers();
for(Handler element : ha)
            {
                element.publish(record);
            } //End block
            temp = theParent;
            theParent = temp.parent;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.319 -0400", hash_original_method = "9897CCA73BB03B431F373D7FDD204A5D", hash_generated_method = "4773AD5FDFE4CF4FAD4549C4300A90F1")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg) {
        addTaint(msg.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.319 -0400", hash_original_method = "3CF6FD97C48E1A2587C7ECF97400CD4D", hash_generated_method = "AA2CB3B62FAA3AF5C7774C6F0631CDD0")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object param) {
        addTaint(param.getTaint());
        addTaint(msg.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.319 -0400", hash_original_method = "CBB0C72EDE04C5F3EB469B462BDF9293", hash_generated_method = "64CCAF3F3BFAC143AD726B9DED0DDD0B")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Object[] params) {
        addTaint(params[0].getTaint());
        addTaint(msg.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.320 -0400", hash_original_method = "CB4DA7B8569A107BAA375CB2DC86FFEC", hash_generated_method = "8B599DF21FCF49FAE3D42B51D5D043FA")
    public void logp(Level logLevel, String sourceClass, String sourceMethod,
            String msg, Throwable thrown) {
        addTaint(thrown.getTaint());
        addTaint(msg.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.320 -0400", hash_original_method = "02DB7C0BC37F7C03C24C164F20F39DA2", hash_generated_method = "141D7E2678D9C590FA21ED67476FED17")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg) {
        addTaint(msg.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
    if(bundleName != null)        
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.320 -0400", hash_original_method = "24A5A99D5C84C6396E1D442FACA791DE", hash_generated_method = "20F6D9EF29C4E85AB6E9631DC1CCA487")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object param) {
        addTaint(param.getTaint());
        addTaint(msg.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
    if(bundleName != null)        
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.320 -0400", hash_original_method = "8D3E1EDC8867FE2E8EE3DD95EDB4A603", hash_generated_method = "E2B5CC4ED2522232C6A7881BD491E68E")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Object[] params) {
        addTaint(params[0].getTaint());
        addTaint(msg.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
    if(bundleName != null)        
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.321 -0400", hash_original_method = "5DD73FDA7FC445A1B67C1E7682CA854E", hash_generated_method = "F1F59BF49F52499AD705D828F27CF089")
    public void logrb(Level logLevel, String sourceClass, String sourceMethod,
            String bundleName, String msg, Throwable thrown) {
        addTaint(thrown.getTaint());
        addTaint(msg.getTaint());
        addTaint(bundleName.getTaint());
        addTaint(sourceMethod.getTaint());
        addTaint(sourceClass.getTaint());
        addTaint(logLevel.getTaint());
    if(!internalIsLoggable(logLevel))        
        {
            return;
        } //End block
        LogRecord record = new LogRecord(logLevel, msg);
    if(bundleName != null)        
        {
            try 
            {
                record.setResourceBundle(loadResourceBundle(bundleName));
            } //End block
            catch (MissingResourceException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.321 -0400", hash_original_method = "D14DBD797D15B100512BFD083DBB1EBD", hash_generated_method = "3E977DE6AD15141A1DF02B5187ACFF94")
     void reset() {
        levelObjVal = null;
        levelIntVal = Level.INFO.intValue();
for(Handler handler : handlers)
        {
            try 
            {
    if(handlers.remove(handler))                
                {
                    handler.close();
                } //End block
            } //End block
            catch (Exception ignored)
            {
            } //End block
        } //End block
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.321 -0400", hash_original_field = "A44D841F27C7FAF8E708C936524E3A40", hash_generated_field = "EFFEA762C1908ADB01D1927B32F091A6")

    public static final String GLOBAL_LOGGER_NAME = "global";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.321 -0400", hash_original_field = "5C1000D0986D94450F353B6AB42FC2EC", hash_generated_field = "E7AC46ADB144618E388DFF4E480328CF")

    @Deprecated
    public static final Logger global = new Logger(GLOBAL_LOGGER_NAME, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.321 -0400", hash_original_field = "AECCAFF8A9FCD49B2188D0F2F871F0AF", hash_generated_field = "46E006A6968A44BB222FB4D5DC1F24A5")

    private static final Handler[] EMPTY_HANDLERS_ARRAY = new Handler[0];
}

