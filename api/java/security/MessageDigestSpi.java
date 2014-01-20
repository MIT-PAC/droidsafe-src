package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

public abstract class MessageDigestSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.096 -0400", hash_original_method = "1CC69EEF55221D742AA45996503C6E66", hash_generated_method = "1CC69EEF55221D742AA45996503C6E66")
    public MessageDigestSpi ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the engine digest length in bytes. If the implementation does not
     * implement this function {@code 0} is returned.
     *
     * @return the digest length in bytes, or {@code 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.049 -0500", hash_original_method = "3B6B0B894EAF70FF02C9B2DD93EC82F9", hash_generated_method = "9280EABD96E85C7D2D946820656DD1C5")
    
protected int engineGetDigestLength() {
        return 0;
    }

    /**
     * Updates this {@code MessageDigestSpi} using the given {@code byte}.
     *
     * @param input
     *            the {@code byte} to update this {@code MessageDigestSpi} with.
     * @see #engineReset()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.052 -0500", hash_original_method = "EE7CB55D816CEA85C7F30A7FB4116D00", hash_generated_method = "666D34AAE8FBE723D1C8C6942DC9E06A")
    
protected abstract void engineUpdate(byte input);

    /**
     * Updates this {@code MessageDigestSpi} using the given {@code byte[]}.
     *
     * @param input
     *            the {@code byte} array.
     * @param offset
     *            the index of the first byte in {@code input} to update from.
     * @param len
     *            the number of bytes in {@code input} to update from.
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code len} are not valid in respect to
     *             {@code input}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.055 -0500", hash_original_method = "FB6A24CDBE91E42610788BB9B481679E", hash_generated_method = "31553A0D775F703B278C127F92BB5A74")
    
protected abstract void engineUpdate(byte[] input, int offset, int len);

    /**
     * Updates this {@code MessageDigestSpi} using the given {@code input}.
     *
     * @param input
     *            the {@code ByteBuffer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.058 -0500", hash_original_method = "63E93F26D259525D134C674633CD9D02", hash_generated_method = "72BCF8FFC66FE144EE5910CA31FB222A")
    
protected void engineUpdate(ByteBuffer input) {
        if (!input.hasRemaining()) {
            return;
        }
        byte[] tmp;
        if (input.hasArray()) {
            tmp = input.array();
            int offset = input.arrayOffset();
            int position = input.position();
            int limit = input.limit();
            engineUpdate(tmp, offset+position, limit - position);
            input.position(limit);
        } else {
            tmp = new byte[input.limit() - input.position()];
            input.get(tmp);
            engineUpdate(tmp, 0, tmp.length);
        }
    }

    /**
     * Computes and returns the final hash value for this
     * {@link MessageDigestSpi}. After the digest is computed the receiver is
     * reset.
     *
     * @return the computed one way hash value.
     * @see #engineReset()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.060 -0500", hash_original_method = "CEA88A783175745149D390015100AA3F", hash_generated_method = "DCE83104DFD81C1C8822D10C2908CFEA")
    
protected abstract byte[] engineDigest();

    /**
     * Computes and stores the final hash value for this
     * {@link MessageDigestSpi}. After the digest is computed the receiver is
     * reset.
     *
     * @param buf
     *            the buffer to store the result in.
     * @param offset
     *            the index of the first byte in {@code buf} to store in.
     * @param len
     *            the number of bytes allocated for the digest.
     * @return the number of bytes written to {@code buf}.
     * @throws DigestException
     *             if an error occures.
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code len} are not valid in respect to
     *             {@code buf}.
     * @see #engineReset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.063 -0500", hash_original_method = "D264912F1C73FF5788F885ED0FD28756", hash_generated_method = "BACEEF056C2325DE520EE38A3DF2C3BA")
    
protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        if (len < engineGetDigestLength()) {
            engineReset();
            throw new DigestException("The value of len parameter is less than the actual digest length");
        }
        if (offset < 0) {
            engineReset();
            throw new DigestException("offset < 0");
        }
        if (offset + len > buf.length) {
            engineReset();
            throw new DigestException("offset + len > buf.length");
        }
        byte[] tmp = engineDigest();
        if (len < tmp.length) {
            throw new DigestException("The value of len parameter is less than the actual digest length");
        }
        System.arraycopy(tmp, 0, buf, offset, tmp.length);
        return tmp.length;
    }

    /**
     * Puts this {@code MessageDigestSpi} back in an initial state, such that it
     * is ready to compute a one way hash value.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.066 -0500", hash_original_method = "2CE2783EC20BF3FC5EB60024C206E82E", hash_generated_method = "9AB089269F09C306053CFC686CB22F51")
    
protected abstract void engineReset();

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.068 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "49055EB107CA2B05DED5ACBCE67DF575")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}

