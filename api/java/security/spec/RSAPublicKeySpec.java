package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;






public class RSAPublicKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.045 -0500", hash_original_field = "D547DBA0A38067ABD647006ED77692E3", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private  BigInteger modulus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.048 -0500", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private  BigInteger publicExponent;

    /**
     * Creates a new {@code RSAPublicKeySpec} with the specified modulus and
     * public exponent.
     *
     * @param modulus
     *            the modulus {@code n}.
     * @param publicExponent
     *            the public exponent {@code d}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.050 -0500", hash_original_method = "02D2E2047B69666CD33836F402773F8F", hash_generated_method = "B51095546205823CB493C74D968A6814")
    
public RSAPublicKeySpec(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
    }

    /**
     * Returns the modulus {@code n}.
     *
     * @return the modulus {@code n}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.053 -0500", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "BDBC223BE67D236DB2FEEE4215FA313B")
    
public BigInteger getModulus() {
        return modulus;
    }

    /**
     * Returns the public exponent {@code d}.
     *
     * @return the public exponent {@code d}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.055 -0500", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "CDD9969A60E00BAEF22FCCEA56318047")
    
public BigInteger getPublicExponent() {
        return publicExponent;
    }

    
}

