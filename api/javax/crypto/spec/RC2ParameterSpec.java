package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;






public class RC2ParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.213 -0500", hash_original_field = "28D53E7400C0A531DBB5CFA9D420D399", hash_generated_field = "AC6861D88456BB5E6B8CBF2574EE2E67")


    private  int effectiveKeyBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.215 -0500", hash_original_field = "E884C91B0186461100A61CCE6B0406E0", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private  byte[] iv;

    /**
     * Creates a new <code>RC2ParameterSpec</code> instance with the specified
     * effective key length (in bits),
     *
     * @param effectiveKeyBits
     *            the effective key length (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.217 -0500", hash_original_method = "981D6EF1132B7EAC7AA89C92203BA1A2", hash_generated_method = "F39ECEA021ACCE7E5DF0B3EDAD33CAD7")
    
public RC2ParameterSpec(int effectiveKeyBits) {
        this.effectiveKeyBits = effectiveKeyBits;
        iv = null;
    }

    /**
     * Creates a new <code>RC2ParameterSpec</code> instance with the specified
     * effective key length (in bits) and <i>initialization vector</i>.
     * <p>
     * The size of the <i>initialization vector</i> must be at least 8 bytes
     * which are copied to protect them against modification.
     *
     * @param effectiveKeyBits
     *            the effective key length (in bits).
     * @param iv
     *            the initialization vector.
     * @throws IllegalArgumentException
     *             if the initialization vector is null or shorter than 8 bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.221 -0500", hash_original_method = "66EC02A60547F68FA7875E0B5CB3BCDA", hash_generated_method = "FFBEE79BB4001BF36F516D3A3F9118AC")
    
public RC2ParameterSpec(int effectiveKeyBits, byte[] iv) {
        if (iv == null) {
            throw new IllegalArgumentException("iv == null");
        }
        if (iv.length < 8) {
            throw new IllegalArgumentException("iv.length < 8");
        }
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, 0, this.iv, 0, 8);
    }

    /**
     * Creates a new <code>RC2ParameterSpec</code> instance with the specified
     * effective key length (in bits) and <i>initialization vector<i>.
     * <p>
     * The size of the <i>initialization vector</i> starting at
     * <code>offset</code> must be at least 8 bytes which are copied to protect
     * them against modification.
     *
     * @param effectiveKeyBits
     *            the effective key length (in bits).
     * @param iv
     *            the initialization vector.
     * @param offset
     *            the offset in the initialization vector to start at.
     * @throws IllegalArgumentException
     *             if the initialization vector is null or starting at
     *             <code>offset</code> is shorter than 8 bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.224 -0500", hash_original_method = "F8E908A70E700CBC7624EF366C4425D3", hash_generated_method = "AEFF8E84E95C023F6D8865FE889AC2AA")
    
public RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) {
        if (iv == null) {
            throw new IllegalArgumentException("iv == null");
        }
        if (iv.length - offset < 8) {
            throw new IllegalArgumentException("iv.length - offset < 8");
        }
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, offset, this.iv, 0, 8);
    }

    /**
     * Returns the effective key length (in bits).
     *
     * @return the effective key length (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.226 -0500", hash_original_method = "1ACACD69299A3BB8DC7106B43ACB3CF4", hash_generated_method = "C603A355B8F4AAE24A24C3D1867627A6")
    
public int getEffectiveKeyBits() {
        return effectiveKeyBits;
    }

    /**
     * Returns a copy of the initialization vector.
     *
     * @return a copy of the initialization vector, or null if none specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.228 -0500", hash_original_method = "462AE8FB0DAC66A27C950BA3964C530D", hash_generated_method = "C6D6D74BC87A4D97FDA1CACFCE456E88")
    
public byte[] getIV() {
        if (iv == null) {
            return null;
        }
        byte[] result = new byte[iv.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        return result;
    }

    /**
     * Compares the specified object to this <code>RC2ParameterSpec</code>
     * instance.
     *
     * @param obj
     *            the object to compare.
     * @return true if the effective key length and the initialization vector of
     *         both objects are equal, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.231 -0500", hash_original_method = "054E5AEB74111DBC68AB791919DED60A", hash_generated_method = "92502B57C99C64E2794D9E013E4AE9B3")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RC2ParameterSpec)) {
            return false;
        }
        RC2ParameterSpec ps = (RC2ParameterSpec) obj;
        return (effectiveKeyBits == ps.effectiveKeyBits)
            && (Arrays.equals(iv, ps.iv));
    }

    /**
     * Returns the hash code of this <code>RC2ParameterSpec</code> instance.
     *
     * @return the hash code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.233 -0500", hash_original_method = "006AB7CB427D2D70245D98F537F7CF42", hash_generated_method = "BFD824D09553C899DB5EF18CDC25D772")
    
@Override
    public int hashCode() {
        int result = effectiveKeyBits;
        if (iv == null) {
            return result;
        }
        for (byte element : iv) {
            result += element;
        }
        return result;
    }

    
}

