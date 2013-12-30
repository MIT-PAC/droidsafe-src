package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;






public class RSAPrivateKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.204 -0500", hash_original_field = "D547DBA0A38067ABD647006ED77692E3", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private  BigInteger modulus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.207 -0500", hash_original_field = "9D6B5BA90FEDFF37C5B6F5CC23882550", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private  BigInteger privateExponent;

    /**
     * Creates a new {@code RSAPrivateKeySpec} with the specified modulus and
     * private exponent.
     *
     * @param modulus
     *            the modulus {@code n}.
     * @param privateExponent
     *            the private exponent {@code e}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.210 -0500", hash_original_method = "F40385EC5FF36FD091AB4B014FD09334", hash_generated_method = "4C6C6A838705FADC091BB6706470A9F3")
    
public RSAPrivateKeySpec(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
    }

    /**
     * Returns the modulus {@code n}.
     *
     * @return the modulus {@code n}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.212 -0500", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "BDBC223BE67D236DB2FEEE4215FA313B")
    
public BigInteger getModulus() {
        return modulus;
    }

    /**
     * Returns the private exponent {@code e}.
     *
     * @return the private exponent {@code e}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.214 -0500", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "7923099ACFD3EE53AD0BB19048D39349")
    
public BigInteger getPrivateExponent() {
        return privateExponent;
    }

    
}

