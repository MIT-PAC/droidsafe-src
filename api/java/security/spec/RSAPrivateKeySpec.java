package java.security.spec;

// Droidsafe Imports
import java.math.BigInteger;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RSAPrivateKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.115 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.115 -0400", hash_original_field = "956D8366F7FF863766B65FA6712484C9", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.116 -0400", hash_original_method = "F40385EC5FF36FD091AB4B014FD09334", hash_generated_method = "D5151A6066191075353C70F915958A85")
    public  RSAPrivateKeySpec(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.privateExponent = privateExponent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.116 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "8BBC3DB8459FEE7FACD27F50D811A7D0")
    public BigInteger getModulus() {
BigInteger varCC3CF2CBE0D806C40D550889F76A52A1_1256416908 =         modulus;
        varCC3CF2CBE0D806C40D550889F76A52A1_1256416908.addTaint(taint);
        return varCC3CF2CBE0D806C40D550889F76A52A1_1256416908;
        // ---------- Original Method ----------
        //return modulus;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.116 -0400", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "328B737E2CFD2C9A2A351941098CCAAE")
    public BigInteger getPrivateExponent() {
BigInteger varC820A65540BECD18FC145C33971A13B0_216408808 =         privateExponent;
        varC820A65540BECD18FC145C33971A13B0_216408808.addTaint(taint);
        return varC820A65540BECD18FC145C33971A13B0_216408808;
        // ---------- Original Method ----------
        //return privateExponent;
    }

    
}

