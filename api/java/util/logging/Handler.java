package java.util.logging;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;






public abstract class Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.103 -0400", hash_original_field = "64F93D01E165083D0DC505B68AA2262A", hash_generated_field = "DEE7EAAE0C2AC4A8B1FAFE0F9E9DFB7A")

    private ErrorManager errorMan;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.104 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.104 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.104 -0400", hash_original_field = "F2FFC59487832CBAD265A8FEF2133592", hash_generated_field = "83002D5DCA7A99652BD6403E70FD4EB0")

    private Formatter formatter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.104 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.104 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.105 -0400", hash_original_method = "E5C195C4F6A42ED3922A908BC2F6920A", hash_generated_method = "4AD38258785274DDA54C2318D34742C6")
    protected  Handler() {
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.106 -0400", hash_original_method = "505322F9A2F9CDB1C20F31F6B7CB4718", hash_generated_method = "7C698E7776B961B2E958904B8924A0C3")
    private Object getDefaultInstance(String className) {
        addTaint(className.getTaint());
        Object result = null;
        if(className == null)        
        {
Object varDC838461EE2FA0CA4C9BBB70A15456B0_346059724 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_346059724.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_346059724;
        } //End block
        try 
        {
            result = Class.forName(className).newInstance();
        } //End block
        catch (Exception e)
        {
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_457755045 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_457755045.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_457755045;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.107 -0400", hash_original_method = "B808F11DA6FC61C942B2D7F2A86E3C09", hash_generated_method = "84ED8BF4B111FA0EF381A5FC5215950A")
    private Object getCustomizeInstance(final String className) throws Exception {
        addTaint(className.getTaint());
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader == null)        
        {
            loader = ClassLoader.getSystemClassLoader();
        } //End block
        Class<?> c = loader.loadClass(className);
Object var8501EF1A6479596C53E60F4A91E85184_295018790 =         c.newInstance();
        var8501EF1A6479596C53E60F4A91E85184_295018790.addTaint(taint);
        return var8501EF1A6479596C53E60F4A91E85184_295018790;
        // ---------- Original Method ----------
        //ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //if (loader == null) {
            //loader = ClassLoader.getSystemClassLoader();
        //}
        //Class<?> c = loader.loadClass(className);
        //return c.newInstance();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.107 -0400", hash_original_method = "B5D56DC5C4B8FE4C311A48E44264ABBB", hash_generated_method = "B262BADC73DEF43D1C64BE8A86BACE2A")
     void printInvalidPropMessage(String key, String value, Exception e) {
        addTaint(e.getTaint());
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        String msg = "Invalid property value for " + prefix + ":" + key + "/" + value;
        errorMan.error(msg, e, ErrorManager.GENERIC_FAILURE);
        // ---------- Original Method ----------
        //String msg = "Invalid property value for " + prefix + ":" + key + "/" + value;
        //errorMan.error(msg, e, ErrorManager.GENERIC_FAILURE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.110 -0400", hash_original_method = "329775ED115F17D9C0AB62A79233F4A6", hash_generated_method = "E5EAE4715211E51AF106B36F55A04863")
     void initProperties(String defaultLevel, String defaultFilter,
            String defaultFormatter, String defaultEncoding) {
        addTaint(defaultEncoding.getTaint());
        LogManager manager = LogManager.getLogManager();
        final String filterName = manager.getProperty(prefix + ".filter");
        if(filterName != null)        
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
        else
        {
            filter = (Filter) getDefaultInstance(defaultFilter);
        } //End block
        String levelName = manager.getProperty(prefix + ".level");
        if(levelName != null)        
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
        else
        {
            level = Level.parse(defaultLevel);
        } //End block
        final String formatterName = manager.getProperty(prefix + ".formatter");
        if(formatterName != null)        
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
        else
        {
            formatter = (Formatter) getDefaultInstance(defaultFormatter);
        } //End block
        final String encodingName = manager.getProperty(prefix + ".encoding");
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

    
    @DSModeled(DSC.SAFE)
    public abstract void close();

    
    @DSModeled(DSC.SAFE)
    public abstract void flush();

    
    @DSModeled(DSC.SAFE)
    public abstract void publish(LogRecord record);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.112 -0400", hash_original_method = "B6DA448E779CA9929D0D7B4D988D1AFB", hash_generated_method = "154BC5EB7C01278DBDBB6E4C77E85DB9")
    public String getEncoding() {
String varA498384F8F847576463EF4FF247934DD_1309409086 =         this.encoding;
        varA498384F8F847576463EF4FF247934DD_1309409086.addTaint(taint);
        return varA498384F8F847576463EF4FF247934DD_1309409086;
        // ---------- Original Method ----------
        //return this.encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.113 -0400", hash_original_method = "E0C8CBFEDB627F2BA4CE76D0A71E633A", hash_generated_method = "2CDE1C3D26C81BED087075F1DC34C239")
    public ErrorManager getErrorManager() {
        LogManager.getLogManager().checkAccess();
ErrorManager varDC0DB3B2F6F9CFE0B48E09E1FB7A56FC_1986953924 =         this.errorMan;
        varDC0DB3B2F6F9CFE0B48E09E1FB7A56FC_1986953924.addTaint(taint);
        return varDC0DB3B2F6F9CFE0B48E09E1FB7A56FC_1986953924;
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //return this.errorMan;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.113 -0400", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "1355AFE30E23AB73E0BC9E63C433B8E0")
    public Filter getFilter() {
Filter varF4BCC990D13B6FB90061D986D6021A1C_1775466934 =         this.filter;
        varF4BCC990D13B6FB90061D986D6021A1C_1775466934.addTaint(taint);
        return varF4BCC990D13B6FB90061D986D6021A1C_1775466934;
        // ---------- Original Method ----------
        //return this.filter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.113 -0400", hash_original_method = "A74BB1584114C9889E52E1E2254AF36C", hash_generated_method = "2102123B701AAA31D8CA604FC0DF5807")
    public Formatter getFormatter() {
Formatter var4201E23B52038F1A9E1FF0526F113251_1177360547 =         this.formatter;
        var4201E23B52038F1A9E1FF0526F113251_1177360547.addTaint(taint);
        return var4201E23B52038F1A9E1FF0526F113251_1177360547;
        // ---------- Original Method ----------
        //return this.formatter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.114 -0400", hash_original_method = "56C01E3C36F1CAAB6EC71D0FEE2F8D34", hash_generated_method = "A16906D8845E303D4921CA1063CF8AE7")
    public Level getLevel() {
Level varD3219067F4C112409126B4317B90C6BA_962687280 =         this.level;
        varD3219067F4C112409126B4317B90C6BA_962687280.addTaint(taint);
        return varD3219067F4C112409126B4317B90C6BA_962687280;
        // ---------- Original Method ----------
        //return this.level;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.115 -0400", hash_original_method = "CE8301478397D9840767CF11CB8E453A", hash_generated_method = "AE5A2B892884496AC6AC32B309E5D536")
    public boolean isLoggable(LogRecord record) {
        addTaint(record.getTaint());
        if(record == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_331434909 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_331434909.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_331434909;
        } //End block
        if(this.level.intValue() == Level.OFF.intValue())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1081505260 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2080597230 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2080597230;
        } //End block
        else
        if(record.getLevel().intValue() >= this.level.intValue())        
        {
            boolean var42B1D7C11A7E8AD5A7D27ACDE8CFA74E_1832088515 = (this.filter == null || this.filter.isLoggable(record));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942940217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_942940217;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_139904792 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_357431292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_357431292;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.116 -0400", hash_original_method = "F62113B5966ABE7DC6200BD5FC9C8FC5", hash_generated_method = "17D07D66E68D4C96BD546C60044E64BA")
    protected void reportError(String msg, Exception ex, int code) {
        addTaint(code);
        addTaint(ex.getTaint());
        addTaint(msg.getTaint());
        this.errorMan.error(msg, ex, code);
        // ---------- Original Method ----------
        //this.errorMan.error(msg, ex, code);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.116 -0400", hash_original_method = "DC978F88261D557C3638CA74D49294AA", hash_generated_method = "E86C277C930C6E6BF3A8A52614ADA621")
     void internalSetEncoding(String newEncoding) throws UnsupportedEncodingException {
        if(newEncoding == null)        
        {
            this.encoding = null;
        } //End block
        else
        {
            if(Charset.isSupported(newEncoding))            
            {
                this.encoding = newEncoding;
            } //End block
            else
            {
                UnsupportedEncodingException var4CDA8C1227D9D4E1E2D4F21421D603AF_1507433832 = new UnsupportedEncodingException(newEncoding);
                var4CDA8C1227D9D4E1E2D4F21421D603AF_1507433832.addTaint(taint);
                throw var4CDA8C1227D9D4E1E2D4F21421D603AF_1507433832;
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.117 -0400", hash_original_method = "E46261745C62E25D2001A68F77BA37B9", hash_generated_method = "A8838E1FB5BB6EDE9FEF200FA6EAAE25")
    public void setEncoding(String encoding) throws UnsupportedEncodingException {
        addTaint(encoding.getTaint());
        LogManager.getLogManager().checkAccess();
        internalSetEncoding(encoding);
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //internalSetEncoding(encoding);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.117 -0400", hash_original_method = "041C6EB6ECB5770848F1CB62B0AB93B7", hash_generated_method = "0479293560EA0063D6CBE75F3301F181")
    public void setErrorManager(ErrorManager em) {
        LogManager.getLogManager().checkAccess();
        if(em == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1536333000 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1536333000.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1536333000;
        } //End block
        this.errorMan = em;
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //if (em == null) {
            //throw new NullPointerException();
        //}
        //this.errorMan = em;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.118 -0400", hash_original_method = "18CF3005E196F8EBECF3068D37979086", hash_generated_method = "D619F8118A4E49CDEA2B68F72F4125AC")
    public void setFilter(Filter newFilter) {
        LogManager.getLogManager().checkAccess();
        this.filter = newFilter;
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //this.filter = newFilter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.119 -0400", hash_original_method = "DEDBD4D0DEEB998F333BEBDE35469176", hash_generated_method = "C75E96A2146488177C23C70C1CA13E01")
     void internalSetFormatter(Formatter newFormatter) {
        if(newFormatter == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1450205082 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1450205082.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1450205082;
        } //End block
        this.formatter = newFormatter;
        // ---------- Original Method ----------
        //if (newFormatter == null) {
            //throw new NullPointerException();
        //}
        //this.formatter = newFormatter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.120 -0400", hash_original_method = "C9CA011EA2B703B6BFC998B221D30A9E", hash_generated_method = "65E8C6CCB8F59323720DEDF850C31A8D")
    public void setFormatter(Formatter newFormatter) {
        addTaint(newFormatter.getTaint());
        LogManager.getLogManager().checkAccess();
        internalSetFormatter(newFormatter);
        // ---------- Original Method ----------
        //LogManager.getLogManager().checkAccess();
        //internalSetFormatter(newFormatter);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.120 -0400", hash_original_method = "AEDF55860BF7C8EC74AABF9FCD3CABC4", hash_generated_method = "E45C4F6FD852E90590BE3F2C179C68E1")
    public void setLevel(Level newLevel) {
        if(newLevel == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_704753365 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_704753365.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_704753365;
        } //End block
        LogManager.getLogManager().checkAccess();
        this.level = newLevel;
        // ---------- Original Method ----------
        //if (newLevel == null) {
            //throw new NullPointerException();
        //}
        //LogManager.getLogManager().checkAccess();
        //this.level = newLevel;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.120 -0400", hash_original_field = "4CA0C5D4254FCFAD767C165981DA6256", hash_generated_field = "0B783B0E3115CE13A6D1488431F3D781")

    private static final Level DEFAULT_LEVEL = Level.ALL;
}

