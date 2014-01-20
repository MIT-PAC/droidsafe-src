package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

public abstract class SignatureSpi {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.396 -0500", hash_original_field = "71BC67A1107D981E6D602A0FBDE54913", hash_generated_field = "179FDAA6281D622A7488CD99E06D8FD3")

    protected SecureRandom appRandom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.541 -0400", hash_original_method = "579C0D6C0992E59A5D82007FD2101B72", hash_generated_method = "579C0D6C0992E59A5D82007FD2101B72")
    public SignatureSpi ()
    {
        //Synthesized constructor
    }

    /**
     * Initializes this {@code SignatureSpi} instance for signature
     * verification, using the public key of the identity whose signature is
     * going to be verified.
     *
     * @param publicKey
     *            the public key.
     * @throws InvalidKeyException
     *             if {@code publicKey} is not valid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.399 -0500", hash_original_method = "2F7C46BC33967B72BDDA1650DD795367", hash_generated_method = "3EE7039E2FB0AC9DDCF24652B84C3E27")
    
protected abstract void engineInitVerify(PublicKey publicKey)
            throws InvalidKeyException;

    /**
     * Initializes this {@code SignatureSpi} instance for signing, using the
     * private key of the identity whose signature is going to be generated.
     *
     * @param privateKey
     *            the private key.
     * @throws InvalidKeyException
     *             if {@code privateKey} is not valid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.401 -0500", hash_original_method = "B3A2136B9FA8AF07EB22DCB5975F1190", hash_generated_method = "1A2E49F77F2A1AB56E1706F96E75DF08")
    
protected abstract void engineInitSign(PrivateKey privateKey)
            throws InvalidKeyException;

    /**
     * Initializes this {@code SignatureSpi} instance for signing, using the
     * private key of the identity whose signature is going to be generated and
     * the specified source of randomness.
     *
     * @param privateKey
     *            the private key.
     * @param random
     *            the {@code SecureRandom} to use.
     * @throws InvalidKeyException
     *             if {@code privateKey} is not valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.403 -0500", hash_original_method = "B296906AC674D1ED6BCB89B75E33BE26", hash_generated_method = "8AD77B5716AC94CA088FC045716E4F42")
    
protected void engineInitSign(PrivateKey privateKey, SecureRandom random)
            throws InvalidKeyException {
        appRandom = random;
        engineInitSign(privateKey);
    }

    /**
     * Updates the data to be verified or to be signed, using the specified
     * {@code byte}.
     *
     * @param b
     *            the byte to update with.
     * @throws SignatureException
     *             if this {@code SignatureSpi} instance is not initialized
     *             properly.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.406 -0500", hash_original_method = "B13EF1CE2365AEE09FF9414CC65FCD43", hash_generated_method = "FBAAD32A72301A01D444A93F2BF169D5")
    
protected abstract void engineUpdate(byte b) throws SignatureException;

    /**
     * Updates the data to be verified or to be signed, using the given {@code
     * byte[]}, starting form the specified index for the specified length.
     *
     * @param b
     *            the byte array to update with.
     * @param off
     *            the start index in {@code b} of the data.
     * @param len
     *            the number of bytes to use.
     * @throws SignatureException
     *             if this {@code SignatureSpi} instance is not initialized
     *             properly.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.408 -0500", hash_original_method = "659386D9FA79C56AE6BF1A6762347A80", hash_generated_method = "BDBD947A3B2476216488A96F82C1BF77")
    
protected abstract void engineUpdate(byte[] b, int off, int len)
            throws SignatureException;

    /**
     * Updates the data to be verified or to be signed, using the specified
     * {@code ByteBuffer}.
     *
     * @param input
     *            the {@code ByteBuffer} to update with.
     * @throws RuntimeException
     *             since {@code SignatureException} is not specified for this
     *             method it throws a {@code RuntimeException} if underlying
     *             {@link #engineUpdate(byte[], int, int)} throws {@code
     *             SignatureException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.411 -0500", hash_original_method = "71C4E934CEE377EFD0E73DFCB679FE83", hash_generated_method = "C9C5866F4F23A9B1BBA631131AA1FF3E")
    
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
            try {
                engineUpdate(tmp, offset + position, limit - position);
            } catch (SignatureException e) {
                throw new RuntimeException(e); //Wrap SignatureException
            }
            input.position(limit);
        } else {
            tmp = new byte[input.limit() - input.position()];
            input.get(tmp);
            try {
                engineUpdate(tmp, 0, tmp.length);
            } catch (SignatureException e) {
                throw new RuntimeException(e); //Wrap SignatureException
            }
        }
    }

    /**
     * Generates and returns the signature of all updated data.
     * <p>
     * This {@code SignatureSpi} instance is reset to the state of its last
     * initialization for signing and thus can be used for another signature
     * from the same identity.
     *
     * @return the signature of all updated data.
     * @throws SignatureException
     *             if this {@code SignatureSpi} instance is not initialized
     *             properly.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.413 -0500", hash_original_method = "06CD0E816E68A7CE27B7DF90D5DC8A65", hash_generated_method = "1FE9803DB2BB5A5BD7ED55316EFFB086")
    
protected abstract byte[] engineSign() throws SignatureException;

    /**
     * Generates and stores the signature of all updated data in the provided
     * {@code byte[]} at the specified position with the specified length.
     * <p>
     * This {@code SignatureSpi} instance is reset to the state of its last
     * initialization for signing and thus can be used for another signature
     * from the same identity.
     *
     * @param outbuf
     *            the buffer to store the signature.
     * @param offset
     *            the index of the first byte in {@code outbuf} to store.
     * @param len
     *            the number of bytes allocated for the signature.
     * @return the number of bytes stored in {@code outbuf}.
     * @throws SignatureException
     *             if this {@code SignatureSpi} instance is not initialized
     *             properly.
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code len} are not valid in respect to
     *             {@code outbuf}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.416 -0500", hash_original_method = "1C34A6699CF243CE14ADEEFCA006987F", hash_generated_method = "B85E0961F98FF679EE20A558EFC8726A")
    
protected int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
        byte[] tmp = engineSign();
        if (tmp == null) {
            return 0;
        }
        if (len < tmp.length) {
            throw new SignatureException("The value of len parameter is less than the actual signature length");
        }
        if (offset < 0) {
            throw new SignatureException("offset < 0");
        }
        if (offset + len > outbuf.length) {
            throw new SignatureException("offset + len > outbuf.length");
        }
        System.arraycopy(tmp, 0, outbuf, offset, tmp.length);
        return tmp.length;
    }

    /**
     * Indicates whether the given {@code sigBytes} can be verified using the
     * public key or a certificate of the signer.
     * <p>
     * This {@code SignatureSpi} instance is reset to the state of its last
     * initialization for verifying and thus can be used to verify another
     * signature of the same signer.
     *
     * @param sigBytes
     *            the signature to verify.
     * @return {@code true} if the signature was verified, {@code false}
     *         otherwise.
     * @throws SignatureException
     *             if this {@code SignatureSpi} instance is not initialized
     *             properly.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.419 -0500", hash_original_method = "1CDA63D177F24DA89AAED94D12310BE1", hash_generated_method = "4402435A255EF1BCDDA72A2A6E5BA076")
    
protected abstract boolean engineVerify(byte[] sigBytes)
            throws SignatureException;

    /**
     * Indicates whether the given {@code sigBytes} starting at index {@code
     * offset} with {@code length} bytes can be verified using the public key or
     * a certificate of the signer.
     * <p>
     * This {@code SignatureSpi} instance is reset to the state of its last
     * initialization for verifying and thus can be used to verify another
     * signature of the same signer.
     *
     * @param sigBytes
     *            the {@code byte[]} containing the signature to verify.
     * @param offset
     *            the start index in {@code sigBytes} of the signature
     * @param length
     *            the number of bytes allocated for the signature.
     * @return {@code true} if the signature was verified, {@code false}
     *         otherwise.
     * @throws SignatureException
     *             if this {@code SignatureSpi} instance is not initialized
     *             properly.
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code length} are not valid in respect
     *             to {@code sigBytes}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.421 -0500", hash_original_method = "1A108B8DE7E13E12F61358DC32E2687B", hash_generated_method = "A6858671EBBF425C76A8934B55E73ABB")
    
protected boolean engineVerify(byte[] sigBytes, int offset, int length)
            throws SignatureException {
        byte[] tmp = new byte[length];
        System.arraycopy(sigBytes, offset, tmp, 0, length);
        return engineVerify(tmp);
    }

    /**
     * Sets the specified parameter to the given value.
     *
     * @param param
     *            the name of the parameter.
     * @param value
     *            the parameter value.
     * @throws InvalidParameterException
     *             if the parameter is invalid, already set or is not allowed to
     *             be changed.
     * @deprecated Use {@link #engineSetParameter(AlgorithmParameterSpec)}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.424 -0500", hash_original_method = "D9E7F345C7F688C847C024069F6DBDB4", hash_generated_method = "93E2B5FB62DDAE4E1A2CFF86E13C38A0")
    
@Deprecated
    protected abstract void engineSetParameter(String param, Object value)
            throws InvalidParameterException;

    /**
     * Sets the specified {@code AlgorithmParameterSpec}.
     *
     * @param params
     *            the parameter to set.
     * @throws InvalidAlgorithmParameterException
     *             if the parameter is invalid, already set or is not allowed to
     *             be changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.426 -0500", hash_original_method = "09773BC31BC521068D3A412C371D22F3", hash_generated_method = "BA0F6DA8F18BA5D7371FD9A3523E21C3")
    
protected void engineSetParameter(AlgorithmParameterSpec params)
            throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the {@code AlgorithmParameters} of this {@link SignatureSpi}
     * instance.
     *
     * @return the {@code AlgorithmParameters} of this {@link SignatureSpi}
     *         instance, maybe {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.429 -0500", hash_original_method = "8524B01EC33E60B2ED7B8CC70F0D409D", hash_generated_method = "990E9C35DED06E56DA23CE6170848F44")
    
protected AlgorithmParameters engineGetParameters() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the value of the parameter with the specified name.
     *
     * @param param
     *            the name of the requested parameter value.
     * @return the value of the parameter with the specified name, maybe {@code
     *         null}.
     * @throws InvalidParameterException
     *             if {@code param} is not a valid parameter for this {@code
     *             SignatureSpi} or an other error occurs.
     * @deprecated There is no generally accepted parameter naming convention.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.431 -0500", hash_original_method = "1335CBC91320D4F205434409B2D1458E", hash_generated_method = "227563F6E5B8957B70DCAC31731EF84B")
    
@Deprecated
    protected abstract Object engineGetParameter(String param)
            throws InvalidParameterException;

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.434 -0500", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "3129F61A1AC4738DC9444626172FE7E6")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }
    
}

