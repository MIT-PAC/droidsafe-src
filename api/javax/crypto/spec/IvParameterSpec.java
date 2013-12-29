package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;






public class IvParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.846 -0500", hash_original_field = "E884C91B0186461100A61CCE6B0406E0", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")


    private  byte[] iv;

    /**
     * Creates a new <code>IvParameterSpec</code> instance with the bytes from
     * the specified buffer <i>iv</i> used as <i>initialization vector</i>.
     *
     * @param iv
     *            the buffer used as initialization vector.
     * @throws NullPointerException
     *             if the specified buffer is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.847 -0500", hash_original_method = "D9A5990E9ED63A0A9D454C79A44593C3", hash_generated_method = "AC521883E3CA4ADEFFD9410ACEB1F335")
    public IvParameterSpec(byte[] iv) {
        if (iv == null) {
            throw new NullPointerException("iv == null");
        }
        this.iv = new byte[iv.length];
        System.arraycopy(iv, 0, this.iv, 0, iv.length);
    }

    /**
     * Creates a new <code>IvParameterSpec</code> instance with <code>byteCount</code>
     * bytes from the specified buffer <code>iv</code> starting at
     * <code>offset</code>.
     *
     * @throws IllegalArgumentException
     *             if the specified buffer is null or <code>offset</code> and
     *             <code>byteCount</code> do not specify a valid chunk in the
     *             specified buffer.
     * @throws ArrayIndexOutOfBoundsException
     *             if <code>offset</code> or <code>byteCount</code> are negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.848 -0500", hash_original_method = "60CA42675AB74B8A2A3519AD856C2D26", hash_generated_method = "ACA8F4A04230827D73D348D0F6DD0A14")
    public IvParameterSpec(byte[] iv, int offset, int byteCount) {
        if ((iv == null) || (iv.length - offset < byteCount)) {
            throw new IllegalArgumentException();
        }
        Arrays.checkOffsetAndCount(iv.length, offset, byteCount);
        this.iv = new byte[byteCount];
        System.arraycopy(iv, offset, this.iv, 0, byteCount);
    }

    /**
     * Returns a copy of the <i>initialization vector</i> data.
     *
     * @return a copy of the initialization vector data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.849 -0500", hash_original_method = "A92FDD2E910AFCA63CE828A3161FD7A9", hash_generated_method = "56715BBA579DEC6E511E589A31103886")
    public byte[] getIV() {
        byte[] res = new byte[iv.length];
        System.arraycopy(iv, 0, res, 0, iv.length);
        return res;
    }

    
}

