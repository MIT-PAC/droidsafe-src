package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.Set;

import org.apache.harmony.security.fortress.Engine;

public abstract class Signature extends SignatureSpi {

    /**
     * Returns a new instance of {@code Signature} that utilizes the specified
     * algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @return a new instance of {@code Signature} that utilizes the specified
     *         algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.515 -0500", hash_original_method = "4B1132236EA3658AFDF6AAF777F4DB3E", hash_generated_method = "0BC0646CA979D25936278C85621B3FDE")
    
public static Signature getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof Signature) {
            Signature result = (Signature) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new SignatureImpl((SignatureSpi) spi, provider, algorithm);
    }

    /**
     * Returns a new instance of {@code Signature} that utilizes the specified
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            the name of the provider.
     * @return a new instance of {@code Signature} that utilizes the specified
     *         algorithm from the specified provider.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.517 -0500", hash_original_method = "38CF846AD141DABFC78B3F3A9BECF440", hash_generated_method = "84FE1D613CEABBA801933A3986010912")
    
public static Signature getInstance(String algorithm, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getSignatureInstance(algorithm, p);
    }

    /**
     * Returns a new instance of {@code Signature} that utilizes the specified
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            the security provider.
     * @return a new instance of {@code Signature} that utilizes the specified
     *         algorithm from the specified provider.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.521 -0500", hash_original_method = "BCEC0D04DA2EAAA5A150C425DE98380C", hash_generated_method = "C0DADB9B24DDAB04166766EA961722A3")
    
public static Signature getInstance(String algorithm, Provider provider)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        return getSignatureInstance(algorithm, provider);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.524 -0500", hash_original_method = "1D4C76885795B6AE74A499923A41E610", hash_generated_method = "409E8726C515B71C7C1FC023C7B197B5")
    
private static Signature getSignatureInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof Signature) {
            Signature result = (Signature) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new SignatureImpl((SignatureSpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.491 -0500", hash_original_field = "AE2DD7C30E170D2FAF1E55B5FBA5DB96", hash_generated_field = "F153FC2145A140C7EE9C30DF2197BDF3")

    private static final String SERVICE = "Signature";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.493 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.501 -0500", hash_original_field = "A7EA8A5BB4DF5F5290D3958FFC1145F9", hash_generated_field = "5981180EC86BD86C5A973C24E0F5F941")

    protected static final int UNINITIALIZED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.504 -0500", hash_original_field = "B2A3B569FD2B3940CF848521334D6275", hash_generated_field = "9C254CF368BDF48B3D83BAA2B82A1195")

    protected static final int SIGN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.506 -0500", hash_original_field = "8BD2A876B5C5C94D878ECDFF2419A1FA", hash_generated_field = "8738159158F0C7B8305EEDB4018256AD")

    protected static final int VERIFY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.496 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.498 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.509 -0500", hash_original_field = "1BA21414CA8B9AEA2A430DA00A3074D6", hash_generated_field = "CDF6660334629CDE27FDB0FE309B0222")

    protected int state = UNINITIALIZED;

    /**
     * Constructs a new instance of {@code Signature} with the name of
     * the algorithm to use.
     *
     * @param algorithm
     *            the name of algorithm to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.512 -0500", hash_original_method = "007DE01FB6A8AC35B06025EDE803711E", hash_generated_method = "ACEB7926671FDF408988DCE197C33435")
    
protected Signature(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Returns the provider associated with this {@code Signature}.
     *
     * @return the provider associated with this {@code Signature}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.526 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the name of the algorithm of this {@code Signature}.
     *
     * @return the name of the algorithm of this {@code Signature}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.528 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Initializes this {@code Signature} instance for signature verification,
     * using the public key of the identity whose signature is going to be
     * verified.
     *
     * @param publicKey
     *            the public key.
     * @throws InvalidKeyException
     *             if {@code publicKey} is not valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.531 -0500", hash_original_method = "6F44917D7B2EA34B37DC316438211882", hash_generated_method = "7AC2C6D9E95974CE38D91A7C3E434C24")
    
public final void initVerify(PublicKey publicKey)
            throws InvalidKeyException {
        engineInitVerify(publicKey);
        state = VERIFY;
    }

    /**
     * Initializes this {@code Signature} instance for signature verification,
     * using the certificate of the identity whose signature is going to be
     * verified.
     * <p>
     * If the given certificate is an instance of {@link X509Certificate} and
     * has a key usage parameter that indicates, that this certificate is not to
     * be used for signing, an {@code InvalidKeyException} is thrown.
     *
     * @param certificate
     *            the certificate used to verify a signature.
     * @throws InvalidKeyException
     *             if the publicKey in the certificate is not valid or not to be
     *             used for signing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.534 -0500", hash_original_method = "D5B41FE621F8332C2172FC7A18EF69C6", hash_generated_method = "DDF556FC8F0D194FA3654C15665AEE50")
    
public final void initVerify(Certificate certificate)
            throws InvalidKeyException {
        if (certificate instanceof X509Certificate) {
            Set ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical = false;
            if (ce != null && !ce.isEmpty()) {
                for (Iterator i = ce.iterator(); i.hasNext();) {
                    if ("2.5.29.15".equals(i.next())) {
                        //KeyUsage OID = 2.5.29.15
                        critical = true;
                        break;
                    }
                }
                if (critical) {
                    boolean[] keyUsage = ((X509Certificate) certificate)
                            .getKeyUsage();
                    // As specified in RFC 3280 -
                    // Internet X.509 Public Key Infrastructure
                    // Certificate and Certificate Revocation List (CRL) Profile.
                    // (http://www.ietf.org/rfc/rfc3280.txt)
                    //
                    // KeyUsage ::= BIT STRING { digitalSignature (0), <skipped> }
                    if ((keyUsage != null) && (!keyUsage[0])) { // digitalSignature
                        throw new InvalidKeyException("The public key in the certificate cannot be used for digital signature purposes");
                    }
                }
            }
        }
        engineInitVerify(certificate.getPublicKey());
        state = VERIFY;
    }

    /**
     * Initializes this {@code Signature} instance for signing, using the
     * private key of the identity whose signature is going to be generated.
     *
     * @param privateKey
     *            the private key.
     * @throws InvalidKeyException
     *             if {@code privateKey} is not valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.537 -0500", hash_original_method = "B6C8D7AE33737E5AFF4E8BA0A220ACB3", hash_generated_method = "3D65D2EBE6315842C68943EE4644E80D")
    
public final void initSign(PrivateKey privateKey)
            throws InvalidKeyException {
        engineInitSign(privateKey);
        state = SIGN;
    }

    /**
     * Initializes this {@code Signature} instance for signing, using the
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.539 -0500", hash_original_method = "94B0D7FD7FB8599FDCD6F4025918B2A9", hash_generated_method = "449474DDB7FA3B6EFC721186B6B8AC32")
    
public final void initSign(PrivateKey privateKey, SecureRandom random)
            throws InvalidKeyException {
        engineInitSign(privateKey, random);
        state = SIGN;
    }

    /**
     * Generates and returns the signature of all updated data.
     * <p>
     * This {@code Signature} instance is reset to the state of its last
     * initialization for signing and thus can be used for another signature
     * from the same identity.
     *
     * @return the signature of all updated data.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.541 -0500", hash_original_method = "1CBD4CB00E49A2B9C590273D2FD8D112", hash_generated_method = "F648DBF6812B9BBA3F208A1D567B6006")
    
public final byte[] sign() throws SignatureException {
        if (state != SIGN) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        return engineSign();
    }

    /**
     * Generates and stores the signature of all updated data in the provided
     * {@code byte[]} at the specified position with the specified length.
     * <p>
     * This {@code Signature} instance is reset to the state of its last
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
     *             if this {@code Signature} instance is not initialized
     *             properly.
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code len} are not valid in respect to
     *             {@code outbuf}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.544 -0500", hash_original_method = "82A870C6C8965CC8E79085F7D8A960EB", hash_generated_method = "0CF31797DBD70D9DCC65BF115CC93754")
    
public final int sign(byte[] outbuf, int offset, int len)
            throws SignatureException {
        if (outbuf == null || offset < 0 || len < 0 ||
                offset + len > outbuf.length) {
            throw new IllegalArgumentException();
        }
        if (state != SIGN) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        return engineSign(outbuf, offset, len);
    }

    /**
     * Indicates whether the given {@code signature} can be verified using the
     * public key or a certificate of the signer.
     * <p>
     * This {@code Signature} instance is reset to the state of its last
     * initialization for verifying and thus can be used to verify another
     * signature of the same signer.
     *
     * @param signature
     *            the signature to verify.
     * @return {@code true} if the signature was verified, {@code false}
     *         otherwise.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.547 -0500", hash_original_method = "C9B26283C94B06BB8BE60C57C40A18DF", hash_generated_method = "C6178168B9E534E03C2854300238FFED")
    
public final boolean verify(byte[] signature) throws SignatureException {
        if (state != VERIFY) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        return engineVerify(signature);
    }

    /**
     * Indicates whether the given {@code signature} starting at index {@code
     * offset} with {@code length} bytes can be verified using the public key or
     * a certificate of the signer.
     * <p>
     * This {@code Signature} instance is reset to the state of its last
     * initialization for verifying and thus can be used to verify another
     * signature of the same signer.
     *
     * @param signature
     *            the {@code byte[]} containing the signature to verify.
     * @param offset
     *            the start index in {@code signature} of the signature.
     * @param length
     *            the number of bytes allocated for the signature.
     * @return {@code true} if the signature was verified, {@code false}
     *         otherwise.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     * @throws IllegalArgumentException
     *             if {@code offset} or {@code length} are not valid in respect
     *             to {@code signature}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.550 -0500", hash_original_method = "59329C8B89ACE0AC6C4DAAF18DA3F3C5", hash_generated_method = "511FF8E21388EE59F7680784D9254081")
    
public final boolean verify(byte[] signature, int offset, int length)
            throws SignatureException {
        if (state != VERIFY) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        if (signature == null || offset < 0 || length < 0 ||
                offset + length > signature.length) {
            throw new IllegalArgumentException();
        }
        return engineVerify(signature, offset, length);
    }

    /**
     * Updates the data to be verified or to be signed, using the specified
     * {@code byte}.
     *
     * @param b
     *            the byte to update with.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.553 -0500", hash_original_method = "79EA6E53B3D29CDFCD3B6E1380EAFC50", hash_generated_method = "68F9AA849CDC5FD1651DFF62727C6D16")
    
public final void update(byte b) throws SignatureException {
        if (state == UNINITIALIZED) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        engineUpdate(b);
    }

    /**
     * Updates the data to be verified or to be signed, using the specified
     * {@code byte[]}.
     *
     * @param data
     *            the byte array to update with.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.556 -0500", hash_original_method = "7FDD4CB7D645E432F89E836C71DCF871", hash_generated_method = "E7518FC75DA191FDACF66EBCFB860ABF")
    
public final void update(byte[] data) throws SignatureException {
        if (state == UNINITIALIZED) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        engineUpdate(data, 0, data.length);
    }

    /**
     * Updates the data to be verified or to be signed, using the given {@code
     * byte[]}, starting form the specified index for the specified length.
     *
     * @param data
     *            the byte array to update with.
     * @param off
     *            the start index in {@code data} of the data.
     * @param len
     *            the number of bytes to use.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.559 -0500", hash_original_method = "935040FEA1E890342F7B1ED90DB7090F", hash_generated_method = "60BEE513AA8FF5BD2E3C2D1289042F40")
    
public final void update(byte[] data, int off, int len)
            throws SignatureException {
        if (state == UNINITIALIZED) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        if (data == null || off < 0 || len < 0 ||
                off + len > data.length) {
            throw new IllegalArgumentException();
        }
        engineUpdate(data, off, len);
    }

    /**
     * Updates the data to be verified or to be signed, using the specified
     * {@code ByteBuffer}.
     *
     * @param data
     *            the {@code ByteBuffer} to update with.
     * @throws SignatureException
     *             if this {@code Signature} instance is not initialized
     *             properly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.561 -0500", hash_original_method = "4D212376BB0D0E0EE1EF0BE20DC8A649", hash_generated_method = "99E561088C80DE19CDBA8295BF4EA8D5")
    
public final void update(ByteBuffer data) throws SignatureException {
        if (state == UNINITIALIZED) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        engineUpdate(data);
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code Signature} including its algorithm and its state.
     *
     * @return a printable representation for this {@code Signature}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.564 -0500", hash_original_method = "300ADD63628A84B0D8F725B1BA1E9A8E", hash_generated_method = "71DB550FD17BA8B81224C927B01BF247")
    
@Override
    public String toString() {
        return "SIGNATURE " + algorithm + " state: " + stateToString(state);
    }

    // Convert state to string
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.566 -0500", hash_original_method = "C1A460A3B710FBA1ED28C52AC5BBE911", hash_generated_method = "98E9662541F0D0D1B3A552EA457578E0")
    
private String stateToString(int state) {
        switch (state) {
        case UNINITIALIZED:
            return "UNINITIALIZED";
        case SIGN:
            return "SIGN";
        case VERIFY:
            return "VERIFY";
        default:
            return "";
        }
    }
    
    private static class SignatureImpl extends Signature {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.586 -0500", hash_original_field = "0B9B4E0CF62C2D7B28F9A6A164E87098", hash_generated_field = "B117D5F80D09F234127E3A3393EBC255")

        private SignatureSpi spiImpl;

        // Constructor
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.589 -0500", hash_original_method = "3E4D7926596EAD873E22E30BA201B1D4", hash_generated_method = "59DCB4F9472E04862ED0A8DD200767FE")
        
public SignatureImpl(SignatureSpi signatureSpi, Provider provider,
                String algorithm) {
            super(algorithm);
            super.provider = provider;
            spiImpl = signatureSpi;
        }

        // engineSign() implementation
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.593 -0500", hash_original_method = "FFC69249636133C4828AD78F0F12AF56", hash_generated_method = "1273A7C32F2094A7E4A551B15E066CF5")
        
@Override
        protected byte[] engineSign() throws SignatureException {
            return spiImpl.engineSign();
        }

        //  engineUpdate() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.596 -0500", hash_original_method = "5E472B7CE8DF4677B6CD62A0BE3E6E55", hash_generated_method = "8C43A13C9884D74E5A20FA39B82A8CD8")
        
@Override
        protected void engineUpdate(byte arg0) throws SignatureException {
            spiImpl.engineUpdate(arg0);
        }

        // engineVerify() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.598 -0500", hash_original_method = "5B50F80B75147450A8AE91D93998317F", hash_generated_method = "2134169A54F1472C1DD9AD9D7ECE7DD0")
        
@Override
        protected boolean engineVerify(byte[] arg0) throws SignatureException {
            return spiImpl.engineVerify(arg0);
        }

        // engineUpdate() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.601 -0500", hash_original_method = "8E9D74168176A196545DE618D70F0045", hash_generated_method = "ACD48FF9A843BFC7A2FDA5299DFA443A")
        
@Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2)
                throws SignatureException {
            spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        // engineInitSign() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.604 -0500", hash_original_method = "8D0AD1B347F88E648DA57C6C188D8255", hash_generated_method = "1D6DBB83DE0A4A2A82C3A6D6A857A704")
        
@Override
        protected void engineInitSign(PrivateKey arg0)
                throws InvalidKeyException {
            spiImpl.engineInitSign(arg0);
        }

        // engineInitVerify() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.606 -0500", hash_original_method = "C51005CD648E9A95CA7D0B48071C4D8E", hash_generated_method = "0926251A0A5CA054F1E480CC81D24609")
        
@Override
        protected void engineInitVerify(PublicKey arg0)
                throws InvalidKeyException {
            spiImpl.engineInitVerify(arg0);
        }

        // engineGetParameter() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.609 -0500", hash_original_method = "BC25730F2F2C84CFB445E50D8EAB3A12", hash_generated_method = "3DF757F82A6F6831B502B2C7B2AC9CB8")
        
@Override
        protected Object engineGetParameter(String arg0)
                throws InvalidParameterException {
            return spiImpl.engineGetParameter(arg0);
        }

        // engineSetParameter() implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.612 -0500", hash_original_method = "2EB6574DEFEEC579E00AC6D7C846FB9A", hash_generated_method = "36EEC423DCCB820DDB6229EB3986CB6F")
        
@Override
        protected void engineSetParameter(String arg0, Object arg1)
                throws InvalidParameterException {
            spiImpl.engineSetParameter(arg0, arg1);
        }

        // Returns a clone if the spiImpl is cloneable
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.617 -0500", hash_original_method = "E18D3A064C93BFFE53C93A44BEF059CB", hash_generated_method = "BC96F9787D1935B44EA995B57271FA47")
        
@Override
        public Object clone() throws CloneNotSupportedException {
            if (spiImpl instanceof Cloneable) {
                SignatureSpi spi = (SignatureSpi) spiImpl.clone();
                return new SignatureImpl(spi, getProvider(), getAlgorithm());
            }
            throw new CloneNotSupportedException();
        }
        
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
     * @deprecated Use {@link #setParameter(AlgorithmParameterSpec)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.569 -0500", hash_original_method = "D52E00AF44B32CEF42E7B7F3CD02413C", hash_generated_method = "0B3D5C6F93B131A73FF182C690F84E67")
    
@Deprecated
    public final void setParameter(String param, Object value)
            throws InvalidParameterException {
        engineSetParameter(param, value);
    }

    /**
     * Sets the specified {@code AlgorithmParameterSpec}.
     *
     * @param params
     *            the parameter to set.
     * @throws InvalidAlgorithmParameterException
     *             if the parameter is invalid, already set or is not allowed to
     *             be changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.572 -0500", hash_original_method = "723DAA3D9E86E61831D60007CF8F8BBA", hash_generated_method = "727D2E23C68C6E1538A7B45ECBE467E9")
    
public final void setParameter(AlgorithmParameterSpec params)
            throws InvalidAlgorithmParameterException {
        engineSetParameter(params);
    }

    /**
     * Returns the {@code AlgorithmParameters} of this {@link Signature}
     * instance.
     *
     * @return the {@code AlgorithmParameters} of this {@link Signature}
     *         instance, maybe {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.578 -0500", hash_original_method = "8EDBC3AD900BE7B10A8F191CA049C5A8", hash_generated_method = "9ACC24FEBBF30B1B2321C458AD29DB35")
    
public final AlgorithmParameters getParameters() {
        return engineGetParameters();
    }

    /**
     * Returns the value of the parameter with the specified name.
     *
     * @param param
     *            the name of the requested parameter value
     * @return the value of the parameter with the specified name, maybe {@code
     *         null}.
     * @throws InvalidParameterException
     *             if {@code param} is not a valid parameter for this {@code
     *             Signature} or an other error occures.
     * @deprecated There is no generally accepted parameter naming convention.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.581 -0500", hash_original_method = "3218EA86DC018EF694546DAFA3BC417D", hash_generated_method = "46BBC64E66C514E5E3B588FA2E97D22F")
    
@Deprecated
    public final Object getParameter(String param)
            throws InvalidParameterException {
        return engineGetParameter(param);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.583 -0500", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "3129F61A1AC4738DC9444626172FE7E6")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }
}

