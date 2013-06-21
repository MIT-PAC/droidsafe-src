package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

public class RSAPublicKeySpec implements KeySpec {
    private BigInteger modulus;
    private BigInteger publicExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.664 -0400", hash_original_method = "02D2E2047B69666CD33836F402773F8F", hash_generated_method = "C0F74B1DACB3E005A09FE709520CF696")
    @DSModeled(DSC.SAFE)
    public RSAPublicKeySpec(BigInteger modulus, BigInteger publicExponent) {
        dsTaint.addTaint(publicExponent.dsTaint);
        dsTaint.addTaint(modulus.dsTaint);
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.publicExponent = publicExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.664 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "CC1E8C684F42A2A86D83C27199C25BC2")
    @DSModeled(DSC.SAFE)
    public BigInteger getModulus() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return modulus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.664 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "7B05A052AE831E8699C169AA24D4D045")
    @DSModeled(DSC.SAFE)
    public BigInteger getPublicExponent() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
}

