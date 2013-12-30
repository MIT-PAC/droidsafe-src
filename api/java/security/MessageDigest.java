package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

import org.apache.harmony.security.fortress.Engine;






public abstract class MessageDigest extends MessageDigestSpi {

    /**
     * Returns a new instance of {@code MessageDigest} that utilizes the
     * specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use
     * @return a new instance of {@code MessageDigest} that utilizes the
     *         specified algorithm
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.388 -0500", hash_original_method = "5C601ADA1D2E18CF500EF6D66253600E", hash_generated_method = "7136D7DF10FBBCC2A23B2BFE80B5FAB3")
    
public static MessageDigest getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof MessageDigest) {
            MessageDigest result = (MessageDigest) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new MessageDigestImpl((MessageDigestSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Returns a new instance of {@code MessageDigest} that utilizes the
     * specified algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use
     * @param provider
     *            the name of the provider
     * @return a new instance of {@code MessageDigest} that utilizes the
     *         specified algorithm from the specified provider
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available
     * @throws NoSuchProviderException
     *             if the specified provider is not available
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.391 -0500", hash_original_method = "4A47CCCAB9E7CA50F3AD4953C61AD60D", hash_generated_method = "E109005BEF06DBB9107F58DD5DA16131")
    
public static MessageDigest getInstance(String algorithm, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    /**
     * Returns a new instance of {@code MessageDigest} that utilizes the
     * specified algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use
     * @param provider
     *            the provider
     * @return a new instance of {@code MessageDigest} that utilizes the
     *         specified algorithm from the specified provider
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.393 -0500", hash_original_method = "723C5C1CC0AC6B47325C4EFD63C83CA5", hash_generated_method = "FB6253B2AEE8F1F7762F8C00D3303C27")
    
public static MessageDigest getInstance(String algorithm, Provider provider)
            throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof MessageDigest) {
            MessageDigest result = (MessageDigest) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new MessageDigestImpl((MessageDigestSpi) spi, provider, algorithm);
    }

    /**
     * Indicates whether to digest are equal by performing a simply
     * byte-per-byte compare of the two digests.
     *
     * @param digesta
     *            the first digest to be compared
     * @param digestb
     *            the second digest to be compared
     * @return {@code true} if the two hashes are equal, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.417 -0500", hash_original_method = "8E343D7D0CF266D2D2F5F12353F2E5FB", hash_generated_method = "3F0DC5CF6405BEFFC970BFCD2FEB88B1")
    
public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta.length != digestb.length) {
            return false;
        }
        for (int i = 0; i < digesta.length; i++) {
            if (digesta[i] != digestb[i]) {
                return false;
            }
        }
        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.377 -0500", hash_original_field = "26264D8773397FEE93E8A143F53644F1", hash_generated_field = "D5F8A930AD592F3B05EEB634AF2D6E2F")

    private static final Engine ENGINE = new Engine("MessageDigest");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.379 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.381 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;

    /**
     * Constructs a new instance of {@code MessageDigest} with the name of
     * the algorithm to use.
     *
     * @param algorithm
     *            the name of algorithm to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.384 -0500", hash_original_method = "DA3220D378CF53A8E8D20808A7040AB6", hash_generated_method = "CBE0705C545531FEB57C67F84C2D39AA")
    
protected MessageDigest(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Puts this {@code MessageDigest} back in an initial state, such that it is
     * ready to compute a one way hash value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.396 -0500", hash_original_method = "E1E123B455D04188508A4B0941F355AE", hash_generated_method = "6475A21B64EEE073D559B4CF586A6890")
    
public void reset() {
        engineReset();
    }

    /**
     * Updates this {@code MessageDigest} using the given {@code byte}.
     *
     * @param arg0
     *            the {@code byte} to update this {@code MessageDigest} with
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.398 -0500", hash_original_method = "5D76F053E1EB2FF1CE017209E211EA20", hash_generated_method = "791DEE263418D919F257C0DEEEE6FDB0")
    
public void update(byte arg0) {
        engineUpdate(arg0);
    }

    /**
     * Updates this {@code MessageDigest} using the given {@code byte[]}.
     *
     * @param input
     *            the {@code byte} array
     * @param offset
     *            the index of the first byte in {@code input} to update from
     * @param len
     *            the number of bytes in {@code input} to update from
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code len} are not valid in respect to
     *             {@code input}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.401 -0500", hash_original_method = "4F50D6AF2B6F6CC75F087F1B36C7BEE9", hash_generated_method = "B66BC348C8FC54F3413C24B481506829")
    
public void update(byte[] input, int offset, int len) {
        if (input == null ||
        // offset < 0 || len < 0 ||
                // checks for negative values are commented out intentionally
                // see HARMONY-1120 for details
                (long) offset + (long) len > input.length) {
            throw new IllegalArgumentException();
        }
        engineUpdate(input, offset, len);
    }

    /**
     * Updates this {@code MessageDigest} using the given {@code byte[]}.
     *
     * @param input
     *            the {@code byte} array
     * @throws NullPointerException
     *             if {@code input} is {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.403 -0500", hash_original_method = "2D0F4C2E65A537F2694C1C3FF3BB32CC", hash_generated_method = "E30CF82352DABF728C05F31DB8FAC659")
    
public void update(byte[] input) {
        if (input == null) {
            throw new NullPointerException();
        }
        engineUpdate(input, 0, input.length);
    }

    /**
     * Computes and returns the final hash value for this {@link MessageDigest}.
     * After the digest is computed the receiver is reset.
     *
     * @return the computed one way hash value
     * @see #reset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.405 -0500", hash_original_method = "BFC8812962D9635EA2DD9DD3F9DF8CCE", hash_generated_method = "D12C891E70E59E44A3EA8AAE84399358")
    
public byte[] digest() {
        return engineDigest();
    }

    /**
     * Computes and stores the final hash value for this {@link MessageDigest}.
     * After the digest is computed the receiver is reset.
     *
     * @param buf
     *            the buffer to store the result
     * @param offset
     *            the index of the first byte in {@code buf} to store
     * @param len
     *            the number of bytes allocated for the digest
     * @return the number of bytes written to {@code buf}
     * @throws DigestException
     *             if an error occurs
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code len} are not valid in respect to
     *             {@code buf}
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.408 -0500", hash_original_method = "427D2D0CC508C9C4E8BC486441041E72", hash_generated_method = "4224D6AC70D62E706B8319BA24B874F8")
    
public int digest(byte[] buf, int offset, int len) throws DigestException {
        if (buf == null ||
        // offset < 0 || len < 0 ||
                // checks for negative values are commented out intentionally
                // see HARMONY-1148 for details
                (long) offset + (long) len > buf.length) {
            throw new IllegalArgumentException();
        }
        return engineDigest(buf, offset, len);
    }

    /**
     * Performs the final update and then computes and returns the final hash
     * value for this {@link MessageDigest}. After the digest is computed the
     * receiver is reset.
     *
     * @param input
     *            the {@code byte} array
     * @return the computed one way hash value
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.410 -0500", hash_original_method = "C04191B06E52578EA4C996F47114224E", hash_generated_method = "7A58DB51A97D433F63CE5548A9BE7778")
    
public byte[] digest(byte[] input) {
        update(input);
        return digest();
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code MessageDigest} including the name of its algorithm.
     *
     * @return a printable representation for this {@code MessageDigest}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.413 -0500", hash_original_method = "67B827C914C444116C889B9B936D23D1", hash_generated_method = "CB63A8F85874C335D55E50A42A6C113B")
    
@Override
    public String toString() {
        return "MESSAGE DIGEST " + algorithm;
    }

    /**
     * Returns the name of the algorithm of this {@code MessageDigest}.
     *
     * @return the name of the algorithm of this {@code MessageDigest}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.419 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider associated with this {@code MessageDigest}.
     *
     * @return the provider associated with this {@code MessageDigest}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.421 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the engine digest length in bytes. If the implementation does not
     * implement this function or is not an instance of {@code Cloneable},
     * {@code 0} is returned.
     *
     * @return the digest length in bytes, or {@code 0}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.424 -0500", hash_original_method = "CB1E3F95FB76C6289C61CD25B71DC6B2", hash_generated_method = "88911DEE53843AD051BBEE6C556BB1DD")
    
public final int getDigestLength() {
        int l = engineGetDigestLength();
        if (l != 0) {
            return l;
        }
        if (!(this instanceof Cloneable)) {
            return 0;
        }
        try {
            MessageDigest md = (MessageDigest) clone();
            return md.digest().length;
        } catch (CloneNotSupportedException e) {
            return 0;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.426 -0500", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "3129F61A1AC4738DC9444626172FE7E6")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }

    
    private static class MessageDigestImpl extends MessageDigest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.432 -0500", hash_original_field = "E6E12CFDFE440D94658B0BABDE3D1B1F", hash_generated_field = "13EF455E6884522AF3C11AFF102361CB")

        private MessageDigestSpi spiImpl;

        // MessageDigestImpl ctor
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.435 -0500", hash_original_method = "AF4F6C5934F11306EFBE5B299B5A2B9A", hash_generated_method = "0AA75E449A13074AFEAFAD1E5BE776CA")
        
private MessageDigestImpl(MessageDigestSpi messageDigestSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            super.provider = provider;
            spiImpl = messageDigestSpi;
        }

        // engineReset() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.438 -0500", hash_original_method = "7B2BEE5C01EE533E37620968FDA4C371", hash_generated_method = "2560337037C8A49F02C0A7F0962FDD9F")
        
@Override
        protected void engineReset() {
            spiImpl.engineReset();
        }

        // engineDigest() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.440 -0500", hash_original_method = "F90FDD38A509FFE526728E64881BF6E1", hash_generated_method = "EFB143DA3D4BFC5CF135EA88531A82EE")
        
@Override
        protected byte[] engineDigest() {
            return spiImpl.engineDigest();
        }

        // engineGetDigestLength() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.443 -0500", hash_original_method = "A58BB0AA00BEE25A1A003BC1A1C82C78", hash_generated_method = "15ACA2354062D5E57DF8D229B6C3E546")
        
@Override
        protected int engineGetDigestLength() {
            return spiImpl.engineGetDigestLength();
        }

        // engineUpdate() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.446 -0500", hash_original_method = "D358F15D417A4020320217683B1513E5", hash_generated_method = "ED43C033856D1E287F93322D957E76A4")
        
@Override
        protected void engineUpdate(byte arg0) {
            spiImpl.engineUpdate(arg0);
        }

        // engineUpdate() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.449 -0500", hash_original_method = "A2CCF3CCE76988A3320BAC87F00B4D63", hash_generated_method = "6E25058A3EAB4458EB77993D690BFA8A")
        
@Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) {
            spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        // Returns a clone if the spiImpl is cloneable
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.452 -0500", hash_original_method = "C83E6E6E4FE5D7C377E3AA33AF7D3FC4", hash_generated_method = "DB11166414C7472E644DB2777B97DE11")
        
@Override
        public Object clone() throws CloneNotSupportedException {
            if (spiImpl instanceof Cloneable) {
                MessageDigestSpi spi = (MessageDigestSpi) spiImpl.clone();
                return new MessageDigestImpl(spi, getProvider(), getAlgorithm());
            }

            throw new CloneNotSupportedException();
        }

        
    }

    /**
     * Updates this {@code MessageDigest} using the given {@code input}.
     *
     * @param input
     *            the {@code ByteBuffer}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.429 -0500", hash_original_method = "8AF1ACEDEB3ACC905C3D0DD872BD7C78", hash_generated_method = "D53B69CF8BDE63A44A79B25F760A0FD2")
    
public final void update(ByteBuffer input) {
        engineUpdate(input);
    }
}

