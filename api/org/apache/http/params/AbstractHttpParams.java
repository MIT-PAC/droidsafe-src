package org.apache.http.params;

// Droidsafe Imports
import droidsafe.annotations.*;


public abstract class AbstractHttpParams implements HttpParams {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.168 -0400", hash_original_method = "A2A1500AC9CF1B321965DC9E32B8AC94", hash_generated_method = "5B65DC7C08874714362B5424DEF66589")
    protected  AbstractHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.168 -0400", hash_original_method = "ABC520F536F6B9249E7F10C3331D9CFF", hash_generated_method = "ECBC01BD2C4A4636F2206B45EF28B74F")
    public long getLongParameter(final String name, long defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
        if(param == null)        
        {
            long var16830A58E1E33A4163524366BA7B701B_1891123924 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1481929947 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1481929947;
        } //End block
        long varFEC3808006CE3F331EED8CE670FA08AF_16221313 = (((Long)param).longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2037984976 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2037984976;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Long)param).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.169 -0400", hash_original_method = "707F0F50AD946C11EC4F03D4FF24C0BF", hash_generated_method = "4FE80C8AB8F398E5B71C849617465FD0")
    public HttpParams setLongParameter(final String name, long value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, new Long(value));
HttpParams var72A74007B2BE62B849F475C7BDA4658B_275427395 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_275427395.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_275427395;
        // ---------- Original Method ----------
        //setParameter(name, new Long(value));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.169 -0400", hash_original_method = "FC38355AD8AFE83547775A40AA8286E7", hash_generated_method = "0ECEF55849350FF198B7D0B5EDC9AF90")
    public int getIntParameter(final String name, int defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
        if(param == null)        
        {
            int var16830A58E1E33A4163524366BA7B701B_667122305 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647713242 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647713242;
        } //End block
        int var7613F8A9E258BBDE76FCAFCC2F8CB3F6_926438129 = (((Integer)param).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748319032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748319032;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Integer)param).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.170 -0400", hash_original_method = "96343DB864AD4997F691AF608DE2D190", hash_generated_method = "0FFDCCF51140BE4AC36C4A773E9090CC")
    public HttpParams setIntParameter(final String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, new Integer(value));
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1545297467 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1545297467.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1545297467;
        // ---------- Original Method ----------
        //setParameter(name, new Integer(value));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.170 -0400", hash_original_method = "B3915F7C4095D2BECFA83FAD119B9A71", hash_generated_method = "4C8D034A3FEB6C60E149A481D27A6A30")
    public double getDoubleParameter(final String name, double defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
        if(param == null)        
        {
            double var16830A58E1E33A4163524366BA7B701B_1968824129 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_390435718 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_390435718;
        } //End block
        double var2AD84D71211077721EEB863D0FC8A3E0_862992932 = (((Double)param).doubleValue());
                double varE8CD7DA078A86726031AD64F35F5A6C0_597210261 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_597210261;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Double)param).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.171 -0400", hash_original_method = "463E9092B81310E5E36DE5B6EDA46056", hash_generated_method = "3BAE8790FB5B9D27111104EF8B747F3C")
    public HttpParams setDoubleParameter(final String name, double value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, new Double(value));
HttpParams var72A74007B2BE62B849F475C7BDA4658B_892483360 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_892483360.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_892483360;
        // ---------- Original Method ----------
        //setParameter(name, new Double(value));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.172 -0400", hash_original_method = "EE3E41732A5BC182F80D452656C028BA", hash_generated_method = "0A3481D7DD104116416C8C7ABC222780")
    public boolean getBooleanParameter(final String name, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        Object param = getParameter(name);
        if(param == null)        
        {
            boolean var16830A58E1E33A4163524366BA7B701B_1230723035 = (defaultValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980851897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980851897;
        } //End block
        boolean var33C268572195B3818AC002A924E193EC_1932729571 = (((Boolean)param).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365395565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365395565;
        // ---------- Original Method ----------
        //Object param = getParameter(name);
        //if (param == null) {
            //return defaultValue;
        //}
        //return ((Boolean)param).booleanValue();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.173 -0400", hash_original_method = "E4FF8AAC25178FB9DD8E5DC61133723C", hash_generated_method = "44C012EF24266E717395D9ED1F7BB3F7")
    public HttpParams setBooleanParameter(final String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1113545202 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1113545202.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1113545202;
        // ---------- Original Method ----------
        //setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.173 -0400", hash_original_method = "77AC0729B60E14850AEA6A580DC038BB", hash_generated_method = "68500D1341665E23AE5EF7AEECF7778B")
    public boolean isParameterTrue(final String name) {
        addTaint(name.getTaint());
        boolean var5144B95D7077918AA97AB71B165677C3_1299703767 = (getBooleanParameter(name, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919929548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_919929548;
        // ---------- Original Method ----------
        //return getBooleanParameter(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.173 -0400", hash_original_method = "2D51442B2D208BB7E61338E9C424C3DA", hash_generated_method = "8A990B8D4B23DAB9F76E65D005D42670")
    public boolean isParameterFalse(final String name) {
        addTaint(name.getTaint());
        boolean varA7866A6E783D818EF38087A5C0C0C6B0_1280055265 = (!getBooleanParameter(name, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111889395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111889395;
        // ---------- Original Method ----------
        //return !getBooleanParameter(name, false);
    }

    
}

