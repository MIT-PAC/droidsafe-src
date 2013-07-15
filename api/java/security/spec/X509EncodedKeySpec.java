package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class X509EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.674 -0400", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "ECC9E13798F16EAF312A2831A733D588")
    public  X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.674 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "E9F2A0D08CB781B8C805D5B9BAFB0EC4")
    public byte[] getEncoded() {
        byte[] varE852F609BBA3F241A4F96363DE8BC6BE_285430535 = (super.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1400679346 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1400679346;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.674 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "EDFBE6E55BF89AE78809823484AF4947")
    public final String getFormat() {
String varF820115C876B7F160DE375988A3E1CA1_1368980140 =         "X.509";
        varF820115C876B7F160DE375988A3E1CA1_1368980140.addTaint(taint);
        return varF820115C876B7F160DE375988A3E1CA1_1368980140;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
}

