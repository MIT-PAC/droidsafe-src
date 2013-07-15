package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PKCS8EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.977 -0400", hash_original_method = "EEE3491490D4DFB630EB03F68D682F22", hash_generated_method = "116F2CBFD2ACAA1C3D72AC9168CF0699")
    public  PKCS8EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.978 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "2457D936335F0526D10048EA5BE49886")
    public byte[] getEncoded() {
        byte[] varE852F609BBA3F241A4F96363DE8BC6BE_1009403246 = (super.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_543725976 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_543725976;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.978 -0400", hash_original_method = "CC009CA66A5AFAFE0E87AA4EEC147948", hash_generated_method = "668D22220D9B38C7C013C8F76B93D7C5")
    public final String getFormat() {
String var686AFE2B0ECF96FA2A9E09461660945E_641642373 =         "PKCS#8";
        var686AFE2B0ECF96FA2A9E09461660945E_641642373.addTaint(taint);
        return var686AFE2B0ECF96FA2A9E09461660945E_641642373;
        // ---------- Original Method ----------
        //return "PKCS#8";
    }

    
}

