package java.util.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.280 -0400", hash_original_field = "64F93D01E165083D0DC505B68AA2262A", hash_generated_field = "DEE7EAAE0C2AC4A8B1FAFE0F9E9DFB7A")

    private ErrorManager errorMan;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.280 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.280 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.280 -0400", hash_original_field = "F2FFC59487832CBAD265A8FEF2133592", hash_generated_field = "83002D5DCA7A99652BD6403E70FD4EB0")

    private Formatter formatter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.280 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.280 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.281 -0400", hash_original_method = "E5C195C4F6A42ED3922A908BC2F6920A", hash_generated_method = "4AD38258785274DDA54C2318D34742C6")
    protected  Handler() {
        this.errorMan = new ErrorManager();
        this.level = DEFAULT_LEVEL;
        this.encoding = null;
        this.filter = null;
        this.formatter = null;
        this.prefix = this.getClass().getName();
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.282 -0400", hash_original_method = "505322F9A2F9CDB1C20F31F6B7CB4718", hash_generated_method = "E9AAED0AD020D617F6A6E7C522973F04")
    private Object getDefaultInstance(String className) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1562340984 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1441143102 = null; 
        Object result = null;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1562340984 = result;
        } 
        try 
        {
            result = Class.forName(className).newInstance();
        } 
        catch (Exception e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1441143102 = result;
        addTaint(className.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_378450998; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_378450998 = varB4EAC82CA7396A68D541C85D26508E83_1562340984;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_378450998 = varB4EAC82CA7396A68D541C85D26508E83_1441143102;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_378450998.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_378450998;
        
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.282 -0400", hash_original_method = "B808F11DA6FC61C942B2D7F2A86E3C09", hash_generated_method = "8C745396CDB30E87FE8D7FF4512DF8ED")
    private Object getCustomizeInstance(final String className) throws Exception {
        Object varB4EAC82CA7396A68D541C85D26508E83_372246163 = null; 
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        {
            loader = ClassLoader.getSystemClassLoader();
        } 
        Class<?> c = loader.loadClass(className);
        varB4EAC82CA7396A68D541C85D26508E83_372246163 = c.newInstance();
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_372246163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_372246163;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.283 -0400", hash_original_method = "B5D56DC5C4B8FE4C311A48E44264ABBB", hash_generated_method = "6679F9FC9DC88EA3BF1188FD5FC10571")
     void printInvalidPropMessage(String key, String value, Exception e) {
        String msg = "Invalid property value for " + prefix + ":" + key + "/" + value;
        errorMan.error(msg, e, ErrorManager.GENERIC_FAILURE);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(e.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.284 -0400", hash_original_method = "329775ED115F17D9C0AB62A79233F4A6", hash_generated_method = "99BC144239965C33C2088CD3805B8676")
     void initProperties(String defaultLevel, String defaultFilter,
            String defaultFormatter, String defaultEncoding) {
        LogManager manager = LogManager.getLogManager();
        final String filterName = manager.getProperty(prefix + ".filter");
        {
            try 
            {
                filter = (Filter) getCustomizeInstance(filterName);
            } 
            catch (Exception e1)
            {
                printInvalidPropMessage("filter", filterName, e1);
                filter = (Filter) getDefaultInstance(defaultFilter);
            } 
        } 
        {
            filter = (Filter) getDefaultInstance(defaultFilter);
        } 
        String levelName = manager.getProperty(prefix + ".level");
        {
            try 
            {
                level = Level.parse(levelName);
            } 
            catch (Exception e)
            {
                printInvalidPropMessage("level", levelName, e);
                level = Level.parse(defaultLevel);
            } 
        } 
        {
            level = Level.parse(defaultLevel);
        } 
        final String formatterName = manager.getProperty(prefix + ".formatter");
        {
            try 
            {
                formatter = (Formatter) getCustomizeInstance(formatterName);
            } 
            catch (Exception e)
            {
                printInvalidPropMessage("formatter", formatterName, e);
                formatter = (Formatter) getDefaultInstance(defaultFormatter);
            } 
        } 
        {
            formatter = (Formatter) getDefaultInstance(defaultFormatter);
        } 
        final String encodingName = manager.getProperty(prefix + ".encoding");
        try 
        {
            internalSetEncoding(encodingName);
        } 
        catch (UnsupportedEncodingException e)
        {
            printInvalidPropMessage("encoding", encodingName, e);
        } 
        addTaint(defaultEncoding.getTaint());
        
        
    }

    
    public abstract void close();

    
    public abstract void flush();

    
    public abstract void publish(LogRecord record);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.286 -0400", hash_original_method = "B6DA448E779CA9929D0D7B4D988D1AFB", hash_generated_method = "2B465FB2EC2304C8C92BA239AF2DA806")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_213616959 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_213616959 = this.encoding;
        varB4EAC82CA7396A68D541C85D26508E83_213616959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_213616959;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.286 -0400", hash_original_method = "E0C8CBFEDB627F2BA4CE76D0A71E633A", hash_generated_method = "B185C46F1FF146DF799328E12C68C397")
    public ErrorManager getErrorManager() {
        ErrorManager varB4EAC82CA7396A68D541C85D26508E83_1507677762 = null; 
        LogManager.getLogManager().checkAccess();
        varB4EAC82CA7396A68D541C85D26508E83_1507677762 = this.errorMan;
        varB4EAC82CA7396A68D541C85D26508E83_1507677762.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1507677762;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.287 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "89C80595C6194687AD8168416B4CAA4A")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1291064065 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1291064065 = this.filter;
        varB4EAC82CA7396A68D541C85D26508E83_1291064065.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1291064065;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.287 -0400", hash_original_method = "A74BB1584114C9889E52E1E2254AF36C", hash_generated_method = "2F2C9B21ECE82FE4B5E38967C899ACDD")
    public Formatter getFormatter() {
        Formatter varB4EAC82CA7396A68D541C85D26508E83_1215426474 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1215426474 = this.formatter;
        varB4EAC82CA7396A68D541C85D26508E83_1215426474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1215426474;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.287 -0400", hash_original_method = "56C01E3C36F1CAAB6EC71D0FEE2F8D34", hash_generated_method = "2CF964BE7E2422B76C30059CC5F819AD")
    public Level getLevel() {
        Level varB4EAC82CA7396A68D541C85D26508E83_1321869484 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1321869484 = this.level;
        varB4EAC82CA7396A68D541C85D26508E83_1321869484.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1321869484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.288 -0400", hash_original_method = "CE8301478397D9840767CF11CB8E453A", hash_generated_method = "618BB109E6D415D38353E1446AA20312")
    public boolean isLoggable(LogRecord record) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean varC6DC5D3408E80ECFA7CEDDE0672ABB7E_681228805 = (this.level.intValue() == Level.OFF.intValue());
            {
                boolean var1D4F55F3574EBE2A94BF6ED5EDA0E7EA_1875602549 = (record.getLevel().intValue() >= this.level.intValue());
                {
                    boolean varFF0BDF006199A98020A7674169EB5A36_1402922486 = (this.filter == null || this.filter.isLoggable(record));
                } 
            } 
        } 
        addTaint(record.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449643756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449643756;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.288 -0400", hash_original_method = "F62113B5966ABE7DC6200BD5FC9C8FC5", hash_generated_method = "0CC409114E4194617957DA8F5E99F18C")
    protected void reportError(String msg, Exception ex, int code) {
        this.errorMan.error(msg, ex, code);
        addTaint(msg.getTaint());
        addTaint(ex.getTaint());
        addTaint(code);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.288 -0400", hash_original_method = "DC978F88261D557C3638CA74D49294AA", hash_generated_method = "4FFAE80C2424B02F8743DCF8362F9C9F")
     void internalSetEncoding(String newEncoding) throws UnsupportedEncodingException {
        {
            this.encoding = null;
        } 
        {
            {
                boolean var11B098441035F08402D4AF053DB3FE19_1375965314 = (Charset.isSupported(newEncoding));
                {
                    this.encoding = newEncoding;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedEncodingException(newEncoding);
                } 
            } 
        } 
        
        
            
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.289 -0400", hash_original_method = "E46261745C62E25D2001A68F77BA37B9", hash_generated_method = "5335FEA30ADD49670765F935CE552975")
    public void setEncoding(String encoding) throws UnsupportedEncodingException {
        LogManager.getLogManager().checkAccess();
        internalSetEncoding(encoding);
        addTaint(encoding.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.289 -0400", hash_original_method = "041C6EB6ECB5770848F1CB62B0AB93B7", hash_generated_method = "EC2127C7CB48AD3BB9F5E432C54B7F80")
    public void setErrorManager(ErrorManager em) {
        LogManager.getLogManager().checkAccess();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.errorMan = em;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.289 -0400", hash_original_method = "18CF3005E196F8EBECF3068D37979086", hash_generated_method = "D619F8118A4E49CDEA2B68F72F4125AC")
    public void setFilter(Filter newFilter) {
        LogManager.getLogManager().checkAccess();
        this.filter = newFilter;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.290 -0400", hash_original_method = "DEDBD4D0DEEB998F333BEBDE35469176", hash_generated_method = "907885E8382BD589AB4167E0CA5C56E1")
     void internalSetFormatter(Formatter newFormatter) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.formatter = newFormatter;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.290 -0400", hash_original_method = "C9CA011EA2B703B6BFC998B221D30A9E", hash_generated_method = "C0C64348FB7ED6D228D512F36F513360")
    public void setFormatter(Formatter newFormatter) {
        LogManager.getLogManager().checkAccess();
        internalSetFormatter(newFormatter);
        addTaint(newFormatter.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.290 -0400", hash_original_method = "AEDF55860BF7C8EC74AABF9FCD3CABC4", hash_generated_method = "5196F74A613B6D919A6565569D709A9E")
    public void setLevel(Level newLevel) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        LogManager.getLogManager().checkAccess();
        this.level = newLevel;
        
        
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.290 -0400", hash_original_field = "4CA0C5D4254FCFAD767C165981DA6256", hash_generated_field = "0B783B0E3115CE13A6D1488431F3D781")

    private static final Level DEFAULT_LEVEL = Level.ALL;
}

