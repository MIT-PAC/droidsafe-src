package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class RSAPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.150 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.150 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.150 -0400", hash_original_method = "02D2E2047B69666CD33836F402773F8F", hash_generated_method = "55386654FDBA392AC0F435BAE28B6236")
    public  RSAPublicKeySpec(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.publicExponent = publicExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.152 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "976E44CDD10C343222D583A4C4AB837E")
    public BigInteger getModulus() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_516116734 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_516116734 = modulus;
        varB4EAC82CA7396A68D541C85D26508E83_516116734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_516116734;
        // ---------- Original Method ----------
        //return modulus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.152 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "7EBAB754DCF481027AE92C5D4C6F7BC1")
    public BigInteger getPublicExponent() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2039656291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2039656291 = publicExponent;
        varB4EAC82CA7396A68D541C85D26508E83_2039656291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2039656291;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
}

