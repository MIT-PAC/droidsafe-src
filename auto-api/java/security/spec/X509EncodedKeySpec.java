package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class X509EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.154 -0400", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "ECC9E13798F16EAF312A2831A733D588")
    public  X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.154 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "B5BB1D0A8680E73CE230E993D7C364F9")
    public byte[] getEncoded() {
        byte[] var0AFBA75A2C6754ACFF8759A1F1214E22_851882180 = (super.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1816275847 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1816275847;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.154 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "E32B786DF19C63DC48AD2916C1E1D455")
    public final String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_1811927210 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1811927210 = "X.509";
        varB4EAC82CA7396A68D541C85D26508E83_1811927210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1811927210;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
}

