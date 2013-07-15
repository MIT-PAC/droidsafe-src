package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class RSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.007 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.007 -0400", hash_original_field = "956D8366F7FF863766B65FA6712484C9", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.008 -0400", hash_original_method = "F40385EC5FF36FD091AB4B014FD09334", hash_generated_method = "D5151A6066191075353C70F915958A85")
    public  RSAPrivateKeySpec(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.privateExponent = privateExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.009 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "3941DBAF8C7AE4FCA21B57D99B7DA324")
    public BigInteger getModulus() {
BigInteger varCC3CF2CBE0D806C40D550889F76A52A1_1183354799 =         modulus;
        varCC3CF2CBE0D806C40D550889F76A52A1_1183354799.addTaint(taint);
        return varCC3CF2CBE0D806C40D550889F76A52A1_1183354799;
        // ---------- Original Method ----------
        //return modulus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.009 -0400", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "C1EA012181EFD3FB9BC6AF3DBDC6B563")
    public BigInteger getPrivateExponent() {
BigInteger varC820A65540BECD18FC145C33971A13B0_1125456945 =         privateExponent;
        varC820A65540BECD18FC145C33971A13B0_1125456945.addTaint(taint);
        return varC820A65540BECD18FC145C33971A13B0_1125456945;
        // ---------- Original Method ----------
        //return privateExponent;
    }

    
}

