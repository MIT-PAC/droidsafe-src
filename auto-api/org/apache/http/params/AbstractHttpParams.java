package org.apache.http.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.params.HttpParams;

public abstract class AbstractHttpParams implements HttpParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.135 -0400", hash_original_method = "A2A1500AC9CF1B321965DC9E32B8AC94", hash_generated_method = "5B65DC7C08874714362B5424DEF66589")
    protected  AbstractHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.135 -0400", hash_original_method = "ABC520F536F6B9249E7F10C3331D9CFF", hash_generated_method = "5ED2CA670293AA43E0A6828767B5E16C")
    public long getLongParameter(final String name, long defaultValue) {
        Object param;
        param = getParameter(name);
        long var003B16ABF2126A52B7770D2CB3171F67_470561100 = (((Long)param).longValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1530099041 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1530099041;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Long)param).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.136 -0400", hash_original_method = "707F0F50AD946C11EC4F03D4FF24C0BF", hash_generated_method = "3D63F9B6E6CD2A5E62B02038600EB1C5")
    public HttpParams setLongParameter(final String name, long value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1941930186 = null; //Variable for return #1
        setParameter(name, new Long(value));
        varB4EAC82CA7396A68D541C85D26508E83_1941930186 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1941930186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1941930186;
        // ---------- Original Method ----------
        //setParameter(name, new Long(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.136 -0400", hash_original_method = "FC38355AD8AFE83547775A40AA8286E7", hash_generated_method = "11DF47AAD000EF2DCE2384FB1B6A55FA")
    public int getIntParameter(final String name, int defaultValue) {
        Object param;
        param = getParameter(name);
        int varAA0278D705FC0116BAA8BDD33786007B_980947003 = (((Integer)param).intValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051089112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051089112;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Integer)param).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.136 -0400", hash_original_method = "96343DB864AD4997F691AF608DE2D190", hash_generated_method = "2E0DB2EA2FA4678502C2864563444147")
    public HttpParams setIntParameter(final String name, int value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_751506008 = null; //Variable for return #1
        setParameter(name, new Integer(value));
        varB4EAC82CA7396A68D541C85D26508E83_751506008 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_751506008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_751506008;
        // ---------- Original Method ----------
        //setParameter(name, new Integer(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.152 -0400", hash_original_method = "B3915F7C4095D2BECFA83FAD119B9A71", hash_generated_method = "7520640899666D15CE3B60587FF354F8")
    public double getDoubleParameter(final String name, double defaultValue) {
        Object param;
        param = getParameter(name);
        double varADC7348B03C7DF0A97F6FFD3704E0310_874974299 = (((Double)param).doubleValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_922563943 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_922563943;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Double)param).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.153 -0400", hash_original_method = "463E9092B81310E5E36DE5B6EDA46056", hash_generated_method = "415F573376475A19F99CA4155FE8C159")
    public HttpParams setDoubleParameter(final String name, double value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_913523504 = null; //Variable for return #1
        setParameter(name, new Double(value));
        varB4EAC82CA7396A68D541C85D26508E83_913523504 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_913523504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_913523504;
        // ---------- Original Method ----------
        //setParameter(name, new Double(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.153 -0400", hash_original_method = "EE3E41732A5BC182F80D452656C028BA", hash_generated_method = "EF1599F8B585E2ED03D1A698A139B46B")
    public boolean getBooleanParameter(final String name, boolean defaultValue) {
        Object param;
        param = getParameter(name);
        boolean varBA30A38804648349330429D2BE04FDC2_933532802 = (((Boolean)param).booleanValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053556867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053556867;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Boolean)param).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.154 -0400", hash_original_method = "E4FF8AAC25178FB9DD8E5DC61133723C", hash_generated_method = "B9CE2C2C054535F55D9E3364CC594E11")
    public HttpParams setBooleanParameter(final String name, boolean value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1427688397 = null; //Variable for return #1
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        varB4EAC82CA7396A68D541C85D26508E83_1427688397 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1427688397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1427688397;
        // ---------- Original Method ----------
        //setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.154 -0400", hash_original_method = "77AC0729B60E14850AEA6A580DC038BB", hash_generated_method = "E1B8146A39364D51E993BB25F4612771")
    public boolean isParameterTrue(final String name) {
        boolean var01F4B15B93748E43AA8AA113D34BA3EB_1063950360 = (getBooleanParameter(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1566670324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1566670324;
        // ---------- Original Method ----------
        //return getBooleanParameter(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.154 -0400", hash_original_method = "2D51442B2D208BB7E61338E9C424C3DA", hash_generated_method = "2104D10BAC3D5A81BA7AF4046FD9BC48")
    public boolean isParameterFalse(final String name) {
        boolean var45A595A03689AA090C5BEF8BBA2D1984_1886398954 = (!getBooleanParameter(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940990305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940990305;
        // ---------- Original Method ----------
        //return !getBooleanParameter(name, false);
    }

    
}

