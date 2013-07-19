package java.security.spec;

// Droidsafe Imports
import java.math.BigInteger;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RSAPublicKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.122 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.122 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.122 -0400", hash_original_method = "02D2E2047B69666CD33836F402773F8F", hash_generated_method = "55386654FDBA392AC0F435BAE28B6236")
    public  RSAPublicKeySpec(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.publicExponent = publicExponent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.123 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "E9E5804D3B2CCB147F86B2EE2C60BEA5")
    public BigInteger getModulus() {
BigInteger varCC3CF2CBE0D806C40D550889F76A52A1_477037049 =         modulus;
        varCC3CF2CBE0D806C40D550889F76A52A1_477037049.addTaint(taint);
        return varCC3CF2CBE0D806C40D550889F76A52A1_477037049;
        // ---------- Original Method ----------
        //return modulus;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.123 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "80704B7893DB5028D018D256A1BEA4F8")
    public BigInteger getPublicExponent() {
BigInteger varB360105573401CCC465D10C242BA5623_1709732674 =         publicExponent;
        varB360105573401CCC465D10C242BA5623_1709732674.addTaint(taint);
        return varB360105573401CCC465D10C242BA5623_1709732674;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
}

