package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PKCS8EncodedKeySpec extends EncodedKeySpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.643 -0400", hash_original_method = "EEE3491490D4DFB630EB03F68D682F22", hash_generated_method = "116F2CBFD2ACAA1C3D72AC9168CF0699")
    public  PKCS8EncodedKeySpec(byte[] encodedKey) {
        super(encodedKey);
        addTaint(encodedKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.643 -0400", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "799322E2E8502C6CEB32D129C12A1EFC")
    public byte[] getEncoded() {
        byte[] var0AFBA75A2C6754ACFF8759A1F1214E22_397125622 = (super.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1844641659 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1844641659;
        // ---------- Original Method ----------
        //return super.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.644 -0400", hash_original_method = "CC009CA66A5AFAFE0E87AA4EEC147948", hash_generated_method = "311BDA14641CB7888508AC017B37E6B6")
    public final String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_1525532210 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1525532210 = "PKCS#8";
        varB4EAC82CA7396A68D541C85D26508E83_1525532210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1525532210;
        // ---------- Original Method ----------
        //return "PKCS#8";
    }

    
}

