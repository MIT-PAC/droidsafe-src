package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;






public class BasicRequestLine implements RequestLine, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.034 -0400", hash_original_field = "F9B1081663AF351C5C340BD27A8FEE5E", hash_generated_field = "FB524F3C45513827A3D0C2FF3CDC9338")

    private ProtocolVersion protoversion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.034 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.034 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private String uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.036 -0400", hash_original_method = "C975E0C09D0E2EF1EBE9CA9605A59CBA", hash_generated_method = "0F6C377F32F7531C4989380D9879D81E")
    public  BasicRequestLine(final String method,
                            final String uri,
                            final ProtocolVersion version) {
        super();
        if(method == null)        
        {
            IllegalArgumentException varD5D9D1D40D0012AA2C44DC6CA1E33A76_1769415448 = new IllegalArgumentException
                ("Method must not be null.");
            varD5D9D1D40D0012AA2C44DC6CA1E33A76_1769415448.addTaint(taint);
            throw varD5D9D1D40D0012AA2C44DC6CA1E33A76_1769415448;
        } //End block
        if(uri == null)        
        {
            IllegalArgumentException var06308F82F62FFA3A1EB8E50C498C074F_980324914 = new IllegalArgumentException
                ("URI must not be null.");
            var06308F82F62FFA3A1EB8E50C498C074F_980324914.addTaint(taint);
            throw var06308F82F62FFA3A1EB8E50C498C074F_980324914;
        } //End block
        if(version == null)        
        {
            IllegalArgumentException varED1AFF25625857E84D7E852ADCFA2EED_1384715012 = new IllegalArgumentException
                ("Protocol version must not be null.");
            varED1AFF25625857E84D7E852ADCFA2EED_1384715012.addTaint(taint);
            throw varED1AFF25625857E84D7E852ADCFA2EED_1384715012;
        } //End block
        this.method = method;
        this.uri = uri;
        this.protoversion = version;
        // ---------- Original Method ----------
        //if (method == null) {
            //throw new IllegalArgumentException
                //("Method must not be null.");
        //}
        //if (uri == null) {
            //throw new IllegalArgumentException
                //("URI must not be null.");
        //}
        //if (version == null) {
            //throw new IllegalArgumentException
                //("Protocol version must not be null.");
        //}
        //this.method = method;
        //this.uri = uri;
        //this.protoversion = version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.036 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "9B8363BA6200F0532D8EB9FF09A60F6C")
    public String getMethod() {
String varB88046C53AB584448F89DD952FF416E1_1502240570 =         this.method;
        varB88046C53AB584448F89DD952FF416E1_1502240570.addTaint(taint);
        return varB88046C53AB584448F89DD952FF416E1_1502240570;
        // ---------- Original Method ----------
        //return this.method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.036 -0400", hash_original_method = "96B8CBD1E6801618947DE1A14DEAA69F", hash_generated_method = "59614AFE8EC2022BFD3E70DECFC87C40")
    public ProtocolVersion getProtocolVersion() {
ProtocolVersion varEABA99A6EF8BF747C858263A803E170A_441712373 =         this.protoversion;
        varEABA99A6EF8BF747C858263A803E170A_441712373.addTaint(taint);
        return varEABA99A6EF8BF747C858263A803E170A_441712373;
        // ---------- Original Method ----------
        //return this.protoversion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.037 -0400", hash_original_method = "638E54DC35C58AE1ED57DF94E885B4C7", hash_generated_method = "6803D19B7682618E73B19B418C1AA284")
    public String getUri() {
String varF8A43570A6D9CE873AAA24BBE28B6265_1822290007 =         this.uri;
        varF8A43570A6D9CE873AAA24BBE28B6265_1822290007.addTaint(taint);
        return varF8A43570A6D9CE873AAA24BBE28B6265_1822290007;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.037 -0400", hash_original_method = "DE48B9AC65FB9CF013FEA7278BE0E864", hash_generated_method = "3BBE9E59AD914BEF7E93A39DE8BF630B")
    public String toString() {
String var1C720FE9918AD554D33B74B2356310B2_230054062 =         BasicLineFormatter.DEFAULT
            .formatRequestLine(null, this).toString();
        var1C720FE9918AD554D33B74B2356310B2_230054062.addTaint(taint);
        return var1C720FE9918AD554D33B74B2356310B2_230054062;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT
            //.formatRequestLine(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.037 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "F358D7A36A14D841A413802BDCFEDF06")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_11652342 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_11652342.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_11652342;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

