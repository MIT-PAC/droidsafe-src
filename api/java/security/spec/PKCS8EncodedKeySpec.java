package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PKCS8EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.074 -0400", hash_original_method = "EEE3491490D4DFB630EB03F68D682F22", hash_generated_method = "116F2CBFD2ACAA1C3D72AC9168CF0699")
    public  PKCS8EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.074 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "CCFF7098826AF8590F95630A688FC3BD")
    public byte[] getEncoded() {
        byte[] varE852F609BBA3F241A4F96363DE8BC6BE_1955459698 = (super.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_984961436 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_984961436;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.075 -0400", hash_original_method = "CC009CA66A5AFAFE0E87AA4EEC147948", hash_generated_method = "04BBF7E378F94502BC297EB00C879AFD")
    public final String getFormat() {
String var686AFE2B0ECF96FA2A9E09461660945E_1857855840 =         "PKCS#8";
        var686AFE2B0ECF96FA2A9E09461660945E_1857855840.addTaint(taint);
        return var686AFE2B0ECF96FA2A9E09461660945E_1857855840;
        // ---------- Original Method ----------
        //return "PKCS#8";
    }

    
}

