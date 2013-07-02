package java.security.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class X509EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.150 -0400", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "ECC9E13798F16EAF312A2831A733D588")
    public  X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.151 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "C15633F70959A8C05D7D5830B0F109D1")
    public byte[] getEncoded() {
        byte[] var0AFBA75A2C6754ACFF8759A1F1214E22_759993658 = (super.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1007115427 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1007115427;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.152 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "B41B024FD2FD14AEB5FE22BB54920495")
    public final String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_393916371 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_393916371 = "X.509";
        varB4EAC82CA7396A68D541C85D26508E83_393916371.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_393916371;
        
        
    }

    
}

