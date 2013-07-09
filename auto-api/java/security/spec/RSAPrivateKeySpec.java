package java.security.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;

public class RSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.135 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.135 -0400", hash_original_field = "956D8366F7FF863766B65FA6712484C9", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.136 -0400", hash_original_method = "F40385EC5FF36FD091AB4B014FD09334", hash_generated_method = "D5151A6066191075353C70F915958A85")
    public  RSAPrivateKeySpec(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.136 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "4BE7263C90E04767D981FB9396836A66")
    public BigInteger getModulus() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_550690109 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_550690109 = modulus;
        varB4EAC82CA7396A68D541C85D26508E83_550690109.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_550690109;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.137 -0400", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "9C7E2F545F013EC10AC520FBA836ABEE")
    public BigInteger getPrivateExponent() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1013748224 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1013748224 = privateExponent;
        varB4EAC82CA7396A68D541C85D26508E83_1013748224.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1013748224;
        
        
    }

    
}

