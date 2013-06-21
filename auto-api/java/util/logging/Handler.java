package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class Handler {
    private ErrorManager errorMan;
    private String encoding;
    private Level level;
    private Formatter formatter;
    private Filter filter;
    private String prefix;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.421 -0400", hash_original_method = "E5C195C4F6A42ED3922A908BC2F6920A", hash_generated_method = "4AD38258785274DDA54C2318D34742C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Handler() {
        this.errorMan = new ErrorManager();
        this.level = DEFAULT_LEVEL;
        this.encoding = null;
        this.filter = null;
        this.formatter = null;
        this.prefix = this.getClass().getName();
        // ---------- Original Method ----------
        //this.errorMan = new ErrorManager();
        //this.level = DEFAULT_LEVEL;
        //this.encoding = null;
        //this.filter = null;
        //this.formatter = null;
        //this.prefix = this.getClass().getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.422 -0400", hash_original_method = "505322F9A2F9CDB1C20F31F6B7CB4718", hash_generated_method = "F10335BFC01ACA9ECCC5E866B0DF04DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getDefaultInstance(String className) {
        dsTaint.addTaint(className);
        Object result;
        result = null;
        try 
        {
            result = Class.forName(className).newInstance();
        } //End block
        catch (Exception e)
        { }
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object result = null;
        //if (className == null) {
            //return result;
        //}
        //try {
            //result = Class.forName(className).newInstance();
        //} catch (Exception e) {
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.422 -0400", hash_original_method = "B808F11DA6FC61C942B2D7F2A86E3C09", hash_generated_method = "9C6E313632C771A812DCB6C26E1225D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getCustomizeInstance(final String className) throws Exception {
        dsTaint.addTaint(className);
        ClassLoader loader;
        loader = Thread.currentThread().getContextClassLoader();
        {
            loader = ClassLoader.getSystemClassLoader();
        } //End block
        Class<?> c;
        c = loader.loadClass(className);
        Object varFDB410FB4D12942CC087014B995E817F_1200603613 = (c.newInstance());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //if (loader == null) {
            //loader = ClassLoader.getSystemClassLoader();
        //}
        //Class<?> c = loader.loadClass(className);
        //return c.newInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.422 -0400", hash_original_method = "B5D56DC5C4B8FE4C311A48E44264ABBB", hash_generated_method = "3394E0E6C6E7D9979DE0BF5168FA96F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void printInvalidPropMessage(String key, String value, Exception e) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        String msg;
        msg = "Invalid property value for " + prefix + ":" + key + "/" + value;
        errorMan.error(msg, e, ErrorManager.GENERIC_FAILURE);
        // ---------- Original Method ----------
        //String msg = "Invalid property value for " + prefix + ":" + key + "/" + value;
        //errorMan.error(msg, e, ErrorManager.GENERIC_FAILURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.422 -0400", hash_original_method = "329775ED115F17D9C0AB62A79233F4A6", hash_generated_method = "BA5AB92777D297791DA248AA8CC19E23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initProperties(String defaultLevel, String defaultFilter,
            String defaultFormatter, String defaultEncoding) {
        dsTaint.addTaint(defaultFormatter);
        dsTaint.addTaint(defaultLevel);
        dsTaint.addTaint(defaultFilter);
        dsTaint.addTaint(defaultEncoding);
        LogManager manager;
        manager = LogManager.getLogManager();
        String filterName;
        filterName = manager.getProperty(prefix + ".filter");
        {
            try 
            {
                filter = (Filter) getCustomizeInstance(filterName);
            } //End block
            catch (Exception e1)
            {
                printInvalidPropMessage("filter", filterName, e1);
                filter = (Filter) getDefaultInstance(defaultFilter);
            } //End block
        } //End block
        {
            filter = (Filter) getDefaultInstance(defaultFilter);
        } //End block
        String levelName;
        levelName = manager.getProperty(prefix + ".level");
        {
            try 
            {
                level = Level.parse(levelName);
            } //End block
            catch (Exception e)
            {
                printInvalidPropMessage("level", levelName, e);
                level = Level.parse(defaultLevel);
            } //End block
        } //End block
        {
            level = Level.parse(defaultLevel);
        } //End block
        String formatterName;
        formatterName = manager.getProperty(prefix + ".formatter");
        {
            try 
            {
                formatter = (Formatter) getCustomizeInstance(formatterName);
            } //End block
            catch (Exception e)
            {
                printInvalidPropMessage("formatter", formatterName, e);
                formatter = (Formatter) getDefaultInstance(defaultFormatter);
            } //End block
        } //End block
        {
            formatter = (Formatter) getDefaultInstance(defaultFormatter);
        } //End block
        String encodingName;
        encodingName = manager.getProperty(prefix + ".encoding");
        try 
        {
            internalSetEncoding(encodingName);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            printInvalidPropMessage("encoding", encodingName, e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract void close();

    
    public abstract void flush();

    
    public abstract void publish(LogRecord record);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.423 -0400", hash_original_method = "B6DA448E779CA9929D0D7B4D988D1AFB", hash_generated_method = "F36F9E1DD0B9ED8FAF92AA505F851EF6")
    @DSModeled(DSC.SAFE)
    public String getEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.423 -0400", hash_original_method = "E0C8CBFEDB627F2BA4CE76D0A71E633A", hash_generated_method = "26024D074456280A1C91BADFB5DCA729")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorManager getErrorManager() {
        LogManager.getLogManager().checkAccess();
        return (ErrorManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //return this.errorMan;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.423 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "D8A8AF43B6C8B000F5C5653B78CB536B")
    @DSModeled(DSC.SAFE)
    public Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.423 -0400", hash_original_method = "A74BB1584114C9889E52E1E2254AF36C", hash_generated_method = "F24394AAD27C61D2320C0F9B30F389AF")
    @DSModeled(DSC.SAFE)
    public Formatter getFormatter() {
        return (Formatter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.formatter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.424 -0400", hash_original_method = "56C01E3C36F1CAAB6EC71D0FEE2F8D34", hash_generated_method = "435BAE91C8EBE1B3E39E5C4EDF561CA1")
    @DSModeled(DSC.SAFE)
    public Level getLevel() {
        return (Level)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.424 -0400", hash_original_method = "CE8301478397D9840767CF11CB8E453A", hash_generated_method = "2150E767F6394C3C72015BF340058B73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoggable(LogRecord record) {
        dsTaint.addTaint(record.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varC6DC5D3408E80ECFA7CEDDE0672ABB7E_766848662 = (this.level.intValue() == Level.OFF.intValue());
            {
                boolean var1D4F55F3574EBE2A94BF6ED5EDA0E7EA_658513810 = (record.getLevel().intValue() >= this.level.intValue());
                {
                    boolean varFF0BDF006199A98020A7674169EB5A36_1427709842 = (this.filter == null || this.filter.isLoggable(record));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (record == null) {
            //throw new NullPointerException();
        //}
        //if (this.level.intValue() == Level.OFF.intValue()) {
            //return false;
        //} else if (record.getLevel().intValue() >= this.level.intValue()) {
            //return this.filter == null || this.filter.isLoggable(record);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.424 -0400", hash_original_method = "F62113B5966ABE7DC6200BD5FC9C8FC5", hash_generated_method = "336BFB52F5630832F553976F4105CD0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void reportError(String msg, Exception ex, int code) {
        dsTaint.addTaint(ex.dsTaint);
        dsTaint.addTaint(code);
        dsTaint.addTaint(msg);
        this.errorMan.error(msg, ex, code);
        // ---------- Original Method ----------
        //this.errorMan.error(msg, ex, code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.424 -0400", hash_original_method = "DC978F88261D557C3638CA74D49294AA", hash_generated_method = "9302996C8BF8DFCA136AD93064592C06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void internalSetEncoding(String newEncoding) throws UnsupportedEncodingException {
        dsTaint.addTaint(newEncoding);
        {
            this.encoding = null;
        } //End block
        {
            {
                boolean var11B098441035F08402D4AF053DB3FE19_874293148 = (Charset.isSupported(newEncoding));
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedEncodingException(newEncoding);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (newEncoding == null) {
            //this.encoding = null;
        //} else {
            //if (Charset.isSupported(newEncoding)) {
                //this.encoding = newEncoding;
            //} else {
                //throw new UnsupportedEncodingException(newEncoding);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.424 -0400", hash_original_method = "E46261745C62E25D2001A68F77BA37B9", hash_generated_method = "154139BA6B418E04B1B8CFB461E0A9CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncoding(String encoding) throws UnsupportedEncodingException {
        dsTaint.addTaint(encoding);
        LogManager.getLogManager().checkAccess();
        internalSetEncoding(encoding);
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //internalSetEncoding(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.425 -0400", hash_original_method = "041C6EB6ECB5770848F1CB62B0AB93B7", hash_generated_method = "1C9CCDB5811DB533757FD94DA56F9736")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setErrorManager(ErrorManager em) {
        dsTaint.addTaint(em.dsTaint);
        LogManager.getLogManager().checkAccess();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //if (em == null) {
            //throw new NullPointerException();
        //}
        //this.errorMan = em;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.425 -0400", hash_original_method = "18CF3005E196F8EBECF3068D37979086", hash_generated_method = "A0D587868967B4B937599C2F0E75F6D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilter(Filter newFilter) {
        dsTaint.addTaint(newFilter.dsTaint);
        LogManager.getLogManager().checkAccess();
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //this.filter = newFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.425 -0400", hash_original_method = "DEDBD4D0DEEB998F333BEBDE35469176", hash_generated_method = "9AE1B26751E6B6680BCE8581ADE862CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void internalSetFormatter(Formatter newFormatter) {
        dsTaint.addTaint(newFormatter.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (newFormatter == null) {
            //throw new NullPointerException();
        //}
        //this.formatter = newFormatter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.425 -0400", hash_original_method = "C9CA011EA2B703B6BFC998B221D30A9E", hash_generated_method = "94E55A9D5076184B50B237BBEC96E67E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFormatter(Formatter newFormatter) {
        dsTaint.addTaint(newFormatter.dsTaint);
        LogManager.getLogManager().checkAccess();
        internalSetFormatter(newFormatter);
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //internalSetFormatter(newFormatter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.425 -0400", hash_original_method = "AEDF55860BF7C8EC74AABF9FCD3CABC4", hash_generated_method = "FE382E8D3C0199260608B4A844F5F5F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLevel(Level newLevel) {
        dsTaint.addTaint(newLevel.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        LogManager.getLogManager().checkAccess();
        // ---------- Original Method ----------
        //if (newLevel == null) {
            //throw new NullPointerException();
        //}
        //LogManager.getLogManager().checkAccess();
        //this.level = newLevel;
    }

    
    private static final Level DEFAULT_LEVEL = Level.ALL;
}

