package org.apache.http.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.params.HttpParams;

public abstract class AbstractHttpParams implements HttpParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.320 -0400", hash_original_method = "A2A1500AC9CF1B321965DC9E32B8AC94", hash_generated_method = "5B65DC7C08874714362B5424DEF66589")
    protected  AbstractHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.320 -0400", hash_original_method = "ABC520F536F6B9249E7F10C3331D9CFF", hash_generated_method = "30F6D43D55089844494409285FC4357D")
    public long getLongParameter(final String name, long defaultValue) {
        Object param;
        param = getParameter(name);
        long var003B16ABF2126A52B7770D2CB3171F67_751713946 = (((Long)param).longValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1781059040 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1781059040;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Long)param).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.321 -0400", hash_original_method = "707F0F50AD946C11EC4F03D4FF24C0BF", hash_generated_method = "E7FD2AE4315CBFD181EB0E6AC761606F")
    public HttpParams setLongParameter(final String name, long value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1170521332 = null; //Variable for return #1
        setParameter(name, new Long(value));
        varB4EAC82CA7396A68D541C85D26508E83_1170521332 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1170521332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170521332;
        // ---------- Original Method ----------
        //setParameter(name, new Long(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.321 -0400", hash_original_method = "FC38355AD8AFE83547775A40AA8286E7", hash_generated_method = "619A0E9BC7B460052C8974CE7FEC8453")
    public int getIntParameter(final String name, int defaultValue) {
        Object param;
        param = getParameter(name);
        int varAA0278D705FC0116BAA8BDD33786007B_1207088886 = (((Integer)param).intValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106573595 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106573595;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Integer)param).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.329 -0400", hash_original_method = "96343DB864AD4997F691AF608DE2D190", hash_generated_method = "5BE452DCB362E5A0A04FE5EEA4E02C49")
    public HttpParams setIntParameter(final String name, int value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_2010235172 = null; //Variable for return #1
        setParameter(name, new Integer(value));
        varB4EAC82CA7396A68D541C85D26508E83_2010235172 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2010235172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010235172;
        // ---------- Original Method ----------
        //setParameter(name, new Integer(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.330 -0400", hash_original_method = "B3915F7C4095D2BECFA83FAD119B9A71", hash_generated_method = "86EBA97F4C9B1627F8C182E3D3AE4258")
    public double getDoubleParameter(final String name, double defaultValue) {
        Object param;
        param = getParameter(name);
        double varADC7348B03C7DF0A97F6FFD3704E0310_1660442744 = (((Double)param).doubleValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_2095831190 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2095831190;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Double)param).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.331 -0400", hash_original_method = "463E9092B81310E5E36DE5B6EDA46056", hash_generated_method = "0D34AAF048293EDB6DAA47932283B65D")
    public HttpParams setDoubleParameter(final String name, double value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1502740936 = null; //Variable for return #1
        setParameter(name, new Double(value));
        varB4EAC82CA7396A68D541C85D26508E83_1502740936 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1502740936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1502740936;
        // ---------- Original Method ----------
        //setParameter(name, new Double(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.332 -0400", hash_original_method = "EE3E41732A5BC182F80D452656C028BA", hash_generated_method = "447BDEAC6C57AC4947C8BA365C4159C7")
    public boolean getBooleanParameter(final String name, boolean defaultValue) {
        Object param;
        param = getParameter(name);
        boolean varBA30A38804648349330429D2BE04FDC2_1088675946 = (((Boolean)param).booleanValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456870461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456870461;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Boolean)param).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.333 -0400", hash_original_method = "E4FF8AAC25178FB9DD8E5DC61133723C", hash_generated_method = "F390CD9DC9F9B317C10C65176B21921F")
    public HttpParams setBooleanParameter(final String name, boolean value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_128959540 = null; //Variable for return #1
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        varB4EAC82CA7396A68D541C85D26508E83_128959540 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_128959540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_128959540;
        // ---------- Original Method ----------
        //setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.334 -0400", hash_original_method = "77AC0729B60E14850AEA6A580DC038BB", hash_generated_method = "5B93E8455B8C7B98D74C067B231422B4")
    public boolean isParameterTrue(final String name) {
        boolean var01F4B15B93748E43AA8AA113D34BA3EB_630728110 = (getBooleanParameter(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_507252981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_507252981;
        // ---------- Original Method ----------
        //return getBooleanParameter(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.334 -0400", hash_original_method = "2D51442B2D208BB7E61338E9C424C3DA", hash_generated_method = "6C119C87781E2C1C746D8E7788032526")
    public boolean isParameterFalse(final String name) {
        boolean var45A595A03689AA090C5BEF8BBA2D1984_1086067760 = (!getBooleanParameter(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210724610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_210724610;
        // ---------- Original Method ----------
        //return !getBooleanParameter(name, false);
    }

    
}

