package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class RSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.117 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.117 -0400", hash_original_field = "956D8366F7FF863766B65FA6712484C9", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.118 -0400", hash_original_method = "F40385EC5FF36FD091AB4B014FD09334", hash_generated_method = "D5151A6066191075353C70F915958A85")
    public  RSAPrivateKeySpec(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.privateExponent = privateExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.118 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "6207BB00CC5F74A72F07B92A67294465")
    public BigInteger getModulus() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1471241594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1471241594 = modulus;
        varB4EAC82CA7396A68D541C85D26508E83_1471241594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471241594;
        // ---------- Original Method ----------
        //return modulus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.118 -0400", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "D8F04A7C6563829A7527AA2A6DD7B5F2")
    public BigInteger getPrivateExponent() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_385834988 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_385834988 = privateExponent;
        varB4EAC82CA7396A68D541C85D26508E83_385834988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_385834988;
        // ---------- Original Method ----------
        //return privateExponent;
    }

    
}

