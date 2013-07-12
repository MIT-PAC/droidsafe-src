package org.apache.http.params;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.params.HttpParams;

public abstract class AbstractHttpParams implements HttpParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.781 -0400", hash_original_method = "A2A1500AC9CF1B321965DC9E32B8AC94", hash_generated_method = "5B65DC7C08874714362B5424DEF66589")
    protected  AbstractHttpParams() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.781 -0400", hash_original_method = "ABC520F536F6B9249E7F10C3331D9CFF", hash_generated_method = "233229B63EF49FF64DC5532201AE02BC")
    public long getLongParameter(final String name, long defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
    if(param == null)        
        {
            long var16830A58E1E33A4163524366BA7B701B_458564308 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2051535471 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2051535471;
        } 
        long varFEC3808006CE3F331EED8CE670FA08AF_2115022153 = (((Long)param).longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_375552216 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_375552216;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.782 -0400", hash_original_method = "707F0F50AD946C11EC4F03D4FF24C0BF", hash_generated_method = "77BD15163A49A464FD87BAF4CE8359A3")
    public HttpParams setLongParameter(final String name, long value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, new Long(value));
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1869094925 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1869094925.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1869094925;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.782 -0400", hash_original_method = "FC38355AD8AFE83547775A40AA8286E7", hash_generated_method = "174BC9AAC5F7EFF2F8669E6F69AD0D64")
    public int getIntParameter(final String name, int defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
    if(param == null)        
        {
            int var16830A58E1E33A4163524366BA7B701B_841689931 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1196749792 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1196749792;
        } 
        int var7613F8A9E258BBDE76FCAFCC2F8CB3F6_1759990052 = (((Integer)param).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517727876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517727876;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.783 -0400", hash_original_method = "96343DB864AD4997F691AF608DE2D190", hash_generated_method = "E35B0A9BE905C757E5E94EBC8A98A373")
    public HttpParams setIntParameter(final String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, new Integer(value));
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1322952520 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1322952520.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1322952520;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.783 -0400", hash_original_method = "B3915F7C4095D2BECFA83FAD119B9A71", hash_generated_method = "FC713957F533497BFDD50AE413A91F38")
    public double getDoubleParameter(final String name, double defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
    if(param == null)        
        {
            double var16830A58E1E33A4163524366BA7B701B_2036403965 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1357378514 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1357378514;
        } 
        double var2AD84D71211077721EEB863D0FC8A3E0_2113459590 = (((Double)param).doubleValue());
                double varE8CD7DA078A86726031AD64F35F5A6C0_332637375 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_332637375;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.784 -0400", hash_original_method = "463E9092B81310E5E36DE5B6EDA46056", hash_generated_method = "EF14779E004E5D40FA2BC6B0076CDD63")
    public HttpParams setDoubleParameter(final String name, double value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, new Double(value));
HttpParams var72A74007B2BE62B849F475C7BDA4658B_88555781 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_88555781.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_88555781;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.784 -0400", hash_original_method = "EE3E41732A5BC182F80D452656C028BA", hash_generated_method = "997E218F5969016E97A722FFB2F84288")
    public boolean getBooleanParameter(final String name, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
    if(param == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_2021642816 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809737888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809737888;
        } 
        boolean var33C268572195B3818AC002A924E193EC_1930741641 = (((Boolean)param).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721163403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721163403;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.785 -0400", hash_original_method = "E4FF8AAC25178FB9DD8E5DC61133723C", hash_generated_method = "4361E3D96E4CBB4B50835F78E9ED6C9B")
    public HttpParams setBooleanParameter(final String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1035804791 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1035804791.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1035804791;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.785 -0400", hash_original_method = "77AC0729B60E14850AEA6A580DC038BB", hash_generated_method = "E2126589B4105B7BEC6ABBFCFF30D923")
    public boolean isParameterTrue(final String name) {
        addTaint(name.getTaint());
        boolean var5144B95D7077918AA97AB71B165677C3_1646341549 = (getBooleanParameter(name, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606176562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606176562;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.785 -0400", hash_original_method = "2D51442B2D208BB7E61338E9C424C3DA", hash_generated_method = "60A31A52379DECA17D2FD23925B01B94")
    public boolean isParameterFalse(final String name) {
        addTaint(name.getTaint());
        boolean varA7866A6E783D818EF38087A5C0C0C6B0_261353615 = (!getBooleanParameter(name, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747429545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747429545;
        
        
    }

    
}

