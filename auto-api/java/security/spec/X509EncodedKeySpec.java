package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class X509EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.686 -0400", hash_original_method = "653C2DD285722882E5BF9CD68F7E16B1", hash_generated_method = "ECC9E13798F16EAF312A2831A733D588")
    public  X509EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.686 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "31E4AE7F415E8506C983066A216F1E3B")
    public byte[] getEncoded() {
        byte[] var0AFBA75A2C6754ACFF8759A1F1214E22_1161564983 = (super.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2019229396 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2019229396;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.687 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "A632EF4E667753129619F823C0CBF1A8")
    public final String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_650659656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_650659656 = "X.509";
        varB4EAC82CA7396A68D541C85D26508E83_650659656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650659656;
        // ---------- Original Method ----------
        //return "X.509";
    }

    
}

