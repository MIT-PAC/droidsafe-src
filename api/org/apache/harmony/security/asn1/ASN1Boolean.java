package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;






public final class ASN1Boolean extends ASN1Primitive {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.199 -0400", hash_original_method = "FD99504F4E1A7A3268A56063556CF13F", hash_generated_method = "02BFB4CEBA233BD3B2DAAA4AB6F0DE78")
    public  ASN1Boolean() {
        super(TAG_BOOLEAN);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1Boolean getInstance() {
        return ASN1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.200 -0400", hash_original_method = "4CABEEE4334687B876309AFB865CC60D", hash_generated_method = "89B46C60D49A068719D7F9C2196A597E")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readBoolean();
        if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_667034237 =             null;
            var540C13E9E156B687226421B24F2DF178_667034237.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_667034237;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_2028991308 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_2028991308.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_2028991308;
        // ---------- Original Method ----------
        //in.readBoolean();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.200 -0400", hash_original_method = "61E80FB6E60B72FAF41ECC8283C8390E", hash_generated_method = "5103535B137F8D18009E5F1668A3FA67")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        if(in.buffer[in.contentOffset] == 0)        
        {
Object var33A5A714C164AB3D0DEA28EF1768B6A3_698150539 =             Boolean.FALSE;
            var33A5A714C164AB3D0DEA28EF1768B6A3_698150539.addTaint(taint);
            return var33A5A714C164AB3D0DEA28EF1768B6A3_698150539;
        } //End block
Object varA0859487E5CB2E75775DF67E6DA72EE1_1331205913 =         Boolean.TRUE;
        varA0859487E5CB2E75775DF67E6DA72EE1_1331205913.addTaint(taint);
        return varA0859487E5CB2E75775DF67E6DA72EE1_1331205913;
        // ---------- Original Method ----------
        //if (in.buffer[in.contentOffset] == 0) {
            //return Boolean.FALSE;
        //}
        //return Boolean.TRUE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.201 -0400", hash_original_method = "6CB7A1753C32BDECF173E6F0AF328B6D", hash_generated_method = "22584134D30D47A04B1F047243E2E798")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeBoolean();
        // ---------- Original Method ----------
        //out.encodeBoolean();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.201 -0400", hash_original_method = "E10D3150F01479FE85EBF9E119EE1844", hash_generated_method = "ADD6B66DD5F7D62A67493A1B7F36DBC6")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.length = 1;
        // ---------- Original Method ----------
        //out.length = 1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.201 -0400", hash_original_field = "7BCAFF74B89ECED52EBB0375DE737548", hash_generated_field = "7128E6C29F8DA081B0F9E7466343FAEE")

    private static final ASN1Boolean ASN1 = new ASN1Boolean();
}

