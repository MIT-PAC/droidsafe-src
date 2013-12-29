package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;






public class PBEParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.889 -0500", hash_original_field = "E37DC2BC2509FBBDB9429277FE4D77AB", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")


    private  byte[] salt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.890 -0500", hash_original_field = "63985F5D8355AAA3166FE055813432C8", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private  int iterationCount;

    /**
     * Creates a new <code>PBEParameterSpec</code> with the specified salt and
     * iteration count.
     *
     * @param salt
     *            the salt.
     * @param iterationCount
     *            the iteration count.
     * @throws NullPointerException
     *             if salt is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.891 -0500", hash_original_method = "E4AD3F6E1F8504EC055E33BFD3FD6D04", hash_generated_method = "E8D546866AF64A65F678EC41E51DF1E7")
    public PBEParameterSpec(byte[] salt, int iterationCount) {
        if (salt == null) {
            throw new NullPointerException("salt == null");
        }
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
    }

    /**
     * Returns a copy to the salt.
     *
     * @return a copy to the salt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.892 -0500", hash_original_method = "DE7716C6003A9CBA24C4421C19D5F40E", hash_generated_method = "D0ED991A2E5BCB96A35AFED4AC0BCA82")
    public byte[] getSalt() {
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        return result;
    }

    /**
     * Returns the iteration count.
     *
     * @return the iteration count.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.893 -0500", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "583EA89A4A01F3B828D69488C83B2B0E")
    public int getIterationCount() {
        return iterationCount;
    }

    
}

