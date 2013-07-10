package org.apache.http.params;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.params.HttpParams;

public abstract class AbstractHttpParams implements HttpParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.395 -0400", hash_original_method = "A2A1500AC9CF1B321965DC9E32B8AC94", hash_generated_method = "5B65DC7C08874714362B5424DEF66589")
    protected  AbstractHttpParams() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.395 -0400", hash_original_method = "ABC520F536F6B9249E7F10C3331D9CFF", hash_generated_method = "920F49D278AA2E09971DE11F074ABDE3")
    public long getLongParameter(final String name, long defaultValue) {
        Object param = getParameter(name);
        long var003B16ABF2126A52B7770D2CB3171F67_1753181210 = (((Long)param).longValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2098477878 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2098477878;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.396 -0400", hash_original_method = "707F0F50AD946C11EC4F03D4FF24C0BF", hash_generated_method = "D7496521C7CDFBA3EB0D1EE55D748EDA")
    public HttpParams setLongParameter(final String name, long value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1746152157 = null; 
        setParameter(name, new Long(value));
        varB4EAC82CA7396A68D541C85D26508E83_1746152157 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1746152157.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1746152157;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.396 -0400", hash_original_method = "FC38355AD8AFE83547775A40AA8286E7", hash_generated_method = "5BE676D063F5F0A2792B89F85B2003ED")
    public int getIntParameter(final String name, int defaultValue) {
        Object param = getParameter(name);
        int varAA0278D705FC0116BAA8BDD33786007B_436973520 = (((Integer)param).intValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800347259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800347259;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.397 -0400", hash_original_method = "96343DB864AD4997F691AF608DE2D190", hash_generated_method = "6999EF0A03DB5D69465F11BB1A87016B")
    public HttpParams setIntParameter(final String name, int value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1176945915 = null; 
        setParameter(name, new Integer(value));
        varB4EAC82CA7396A68D541C85D26508E83_1176945915 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1176945915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1176945915;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.397 -0400", hash_original_method = "B3915F7C4095D2BECFA83FAD119B9A71", hash_generated_method = "F8A8A5A72FDBDF75AAC985FBAA11A6DF")
    public double getDoubleParameter(final String name, double defaultValue) {
        Object param = getParameter(name);
        double varADC7348B03C7DF0A97F6FFD3704E0310_1766728874 = (((Double)param).doubleValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1640313282 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1640313282;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.398 -0400", hash_original_method = "463E9092B81310E5E36DE5B6EDA46056", hash_generated_method = "00E6B2AF1EDFDC23EE5506457FBB3F7D")
    public HttpParams setDoubleParameter(final String name, double value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1456104970 = null; 
        setParameter(name, new Double(value));
        varB4EAC82CA7396A68D541C85D26508E83_1456104970 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1456104970.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1456104970;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.399 -0400", hash_original_method = "EE3E41732A5BC182F80D452656C028BA", hash_generated_method = "A6D167B2736D830B537D8BF01F1C22DF")
    public boolean getBooleanParameter(final String name, boolean defaultValue) {
        Object param = getParameter(name);
        boolean varBA30A38804648349330429D2BE04FDC2_429483360 = (((Boolean)param).booleanValue());
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679378095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679378095;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.400 -0400", hash_original_method = "E4FF8AAC25178FB9DD8E5DC61133723C", hash_generated_method = "6F1E05A00385C424F7F8081CA365BECC")
    public HttpParams setBooleanParameter(final String name, boolean value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1305137421 = null; 
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        varB4EAC82CA7396A68D541C85D26508E83_1305137421 = this;
        addTaint(name.getTaint());
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1305137421.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1305137421;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.400 -0400", hash_original_method = "77AC0729B60E14850AEA6A580DC038BB", hash_generated_method = "DFFB5BBE7EEEB3DA4F45ED60C647B5A9")
    public boolean isParameterTrue(final String name) {
        boolean var01F4B15B93748E43AA8AA113D34BA3EB_2053223431 = (getBooleanParameter(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476735320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476735320;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.401 -0400", hash_original_method = "2D51442B2D208BB7E61338E9C424C3DA", hash_generated_method = "0900E928F00371D1C8250B282382B237")
    public boolean isParameterFalse(final String name) {
        boolean var45A595A03689AA090C5BEF8BBA2D1984_1259200646 = (!getBooleanParameter(name, false));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400623641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400623641;
        
        
    }

    
}

