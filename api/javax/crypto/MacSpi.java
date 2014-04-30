package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public abstract class MacSpi {

    /**
     * Creates a new {@code MacSpi} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.463 -0500", hash_original_method = "EEBADA04ED7B15342A993162A4F56017", hash_generated_method = "132FD63D4BAF7B3BF5EECA165BAC8542")
    
public MacSpi() {
    }

    /**
     * Returns the length of this MAC (in bytes).
     *
     * @return the length of this MAC (in bytes).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.465 -0500", hash_original_method = "E5EE4E3D529200DA127E29694CDB8928", hash_generated_method = "171056A01B3A57938A6452A54EFDEE0C")
    
protected abstract int engineGetMacLength();

    /**
     * Initializes this {@code MacSpi} instance with the specified key and
     * algorithm parameters.
     *
     * @param key
     *            the key to initialize this algorithm.
     * @param params
     *            the parameters for this algorithm.
     * @throws InvalidKeyException
     *             if the specified key cannot be used to initialize this
     *             algorithm, or it is {@code null}.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to initialize this
     *             algorithm.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.468 -0500", hash_original_method = "A22BD27EF5C096BDC4200799D5CB43E0", hash_generated_method = "5E2EEEB85E1EBAC9690FDF147512AE55")
    
protected abstract void engineInit(Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    /**
     * Updates this {@code MacSpi} instance with the specified byte.
     *
     * @param input
     *            the byte.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.471 -0500", hash_original_method = "EE7CB55D816CEA85C7F30A7FB4116D00", hash_generated_method = "666D34AAE8FBE723D1C8C6942DC9E06A")
    
protected abstract void engineUpdate(byte input);

    /**
     * Updates this {@code MacSpi} instance with the data from the specified
     * buffer {@code input} from the specified {@code offset} and length {@code
     * len}.
     *
     * @param input
     *            the buffer.
     * @param offset
     *            the offset in the buffer.
     * @param len
     *            the length of the data in the buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.473 -0500", hash_original_method = "FB6A24CDBE91E42610788BB9B481679E", hash_generated_method = "31553A0D775F703B278C127F92BB5A74")
    
protected abstract void engineUpdate(byte[] input, int offset, int len);

    /**
     * Updates this {@code MacSpi} instance with the data from the specified
     * buffer, starting at {@link ByteBuffer#position()}, including the next
     * {@link ByteBuffer#remaining()} bytes.
     *
     * @param input
     *            the buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.476 -0500", hash_original_method = "7BFE449B7BFB03ADBCFF5433860FD67B", hash_generated_method = "57BA6652D441251A1BE9A47D69952297")
    
protected void engineUpdate(ByteBuffer input) {
        if (!input.hasRemaining()) {
            return;
        }
        byte[] bInput;
        if (input.hasArray()) {
            bInput = input.array();
            int offset = input.arrayOffset();
            int position = input.position();
            int limit = input.limit();
            engineUpdate(bInput, offset + position, limit - position);
            input.position(limit);
        } else {
            bInput = new byte[input.limit() - input.position()];
            input.get(bInput);
            engineUpdate(bInput, 0, bInput.length);
        }
    }

    /**
     * Computes the digest of this MAC based on the data previously specified in
     * {@link #engineUpdate} calls.
     * <p>
     * This {@code MacSpi} instance is reverted to its initial state and
     * can be used to start the next MAC computation with the same parameters or
     * initialized with different parameters.
     *
     * @return the generated digest.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.478 -0500", hash_original_method = "28E98DE89A8C2A2C7FA6A0C5403AC9E0", hash_generated_method = "DD49CF0D72F140D2D0B5399BA8032066")
    
protected abstract byte[] engineDoFinal();

    /**
     * Resets this {@code MacSpi} instance to its initial state.
     * <p>
     * This {@code MacSpi} instance is reverted to its initial state and can be
     * used to start the next MAC computation with the same parameters or
     * initialized with different parameters.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.480 -0500", hash_original_method = "2CE2783EC20BF3FC5EB60024C206E82E", hash_generated_method = "9AB089269F09C306053CFC686CB22F51")
    
protected abstract void engineReset();

    /**
     * Clones this {@code MacSpi} instance.
     *
     * @return the cloned instance.
     * @throws CloneNotSupportedException
     *             if cloning is not supported.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.482 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "49055EB107CA2B05DED5ACBCE67DF575")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}

