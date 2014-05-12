package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKey;

public class SecretKeySpec implements SecretKey, KeySpec, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.342 -0500", hash_original_field = "CF2978D77A300F2288929DE02B014AE5", hash_generated_field = "DA1718E019BA5BA63D43B50C98DB7BC3")

    // In order to be compatible it is explicitly declared here
    // for details see HARMONY-233
    private static final long serialVersionUID = 6577238317307289933L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.344 -0500", hash_original_field = "874EBF47D328D135486F03BCE6DDD19A", hash_generated_field = "AEF19C0A7530E140588DCBA91FF66D28")

    private  byte[] key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.346 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new <code>SecretKeySpec</code> for the specified key data and
     * algorithm name.
     *
     * @param key
     *            the key data.
     * @param algorithm
     *            the algorithm name.
     * @throws IllegalArgumentException
     *             if the key data or the algorithm name is null or if the key
     *             data is empty.
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.348 -0500", hash_original_method = "46BCBD91E8C2018C32B65BFBDD14DAE3", hash_generated_method = "94EDA31E0B802545D5ED76E97A38F3EB")
    
public SecretKeySpec(byte[] key, String algorithm) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
        if (key.length == 0) {
            throw new IllegalArgumentException("key.length == 0");
        }
        if (algorithm == null) {
            throw new IllegalArgumentException("algorithm == null");
        }

        this.algorithm = algorithm;
        this.key = new byte[key.length];
        System.arraycopy(key, 0, this.key, 0, key.length);
    }

    /**
     * Creates a new <code>SecretKeySpec</code> for the key data from the
     * specified buffer <code>key</code> starting at <code>offset</code> with
     * length <code>len</code> and the specified <code>algorithm</code> name.
     *
     * @param key
     *            the key data.
     * @param offset
     *            the offset.
     * @param len
     *            the size of the key data.
     * @param algorithm
     *            the algorithm name.
     * @throws IllegalArgumentException
     *             if the key data or the algorithm name is null, the key data
     *             is empty or <code>offset</code> and <code>len</code> do not
     *             specify a valid chunk in the buffer <code>key</code>.
     * @throws ArrayIndexOutOfBoundsException
     *             if <code>offset</code> or <code>len</code> is negative.
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.351 -0500", hash_original_method = "97539A44FE944982691962B490B5A049", hash_generated_method = "CBFA8797FEE471D07D72810BCB736253")
    
public SecretKeySpec(byte[] key, int offset, int len, String algorithm) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
        if (key.length == 0) {
            throw new IllegalArgumentException("key.length == 0");
        }
        if (len < 0 || offset < 0) {
            throw new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
        }
        if (key.length - offset < len) {
            throw new IllegalArgumentException("key too short");
        }
        if (algorithm == null) {
            throw new IllegalArgumentException("algorithm == null");
        }
        this.algorithm = algorithm;
        this.key = new byte[len];
        System.arraycopy(key, offset, this.key, 0, len);
    }

    /**
     * Returns the algorithm name.
     *
     * @return the algorithm name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.353 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the name of the format used to encode the key.
     *
     * @return the format name "RAW".
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.356 -0500", hash_original_method = "DA06499CB28B740B0D3C21B02311BB46", hash_generated_method = "FEA02E291B25C9E5FCD19EC4D87B562C")
    
public String getFormat() {
        return "RAW";
    }

    /**
     * Returns the encoded form of this secret key.
     *
     * @return the encoded form of this secret key.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.358 -0500", hash_original_method = "3F6C1397C7B2518265F6653D66E9AC87", hash_generated_method = "556F207E69FF8E135FD4E6DBE9F6BD56")
    
public byte[] getEncoded() {
        byte[] result = new byte[key.length];
        System.arraycopy(key, 0, result, 0, key.length);
        return result;
    }

    /**
     * Returns the hash code of this <code>SecretKeySpec</code> object.
     *
     * @return the hash code.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.361 -0500", hash_original_method = "561BEB6A8D834A34E4D5A2503144263D", hash_generated_method = "818CA09102D790BE8758F466E76831EF")
    
@Override
    public int hashCode() {
        int result = algorithm.length();
        for (byte element : key) {
            result += element;
        }
        return result;
    }

    /**
     * Compares the specified object with this <code>SecretKeySpec</code>
     * instance.
     *
     * @param obj
     *            the object to compare.
     * @return true if the algorithm name and key of both object are equal,
     *         otherwise false.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.363 -0500", hash_original_method = "7E1551F3E39A01E70E4CFF4FAB6C7AC5", hash_generated_method = "0BEA9D56F8E11881D5EAFC0DB244A1CD")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecretKeySpec)) {
            return false;
        }
        SecretKeySpec ks = (SecretKeySpec) obj;
        return (algorithm.equalsIgnoreCase(ks.algorithm))
            && (Arrays.equals(key, ks.key));
    }
}

