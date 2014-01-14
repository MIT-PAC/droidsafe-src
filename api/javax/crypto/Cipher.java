package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Set;

import org.apache.harmony.crypto.internal.NullCipherSpi;
import org.apache.harmony.security.fortress.Engine;

public class Cipher {

    /**
     * Creates a new Cipher for the specified transformation. The installed
     * providers are searched in order for an implementation of the specified
     * transformation. The first found provider providing the transformation is
     * used to create the cipher. If no provider is found an exception is
     * thrown.
     *
     * @param transformation
     *            the name of the transformation to create a cipher for.
     * @return a cipher for the requested transformation.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the
     *             <i>transformation</i>, or it is {@code null}, empty or in an
     *             invalid format.
     * @throws NoSuchPaddingException
     *             if no installed provider can provide the padding scheme in
     *             the <i>transformation</i>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.176 -0500", hash_original_method = "47D9CD504ED20085CFDD80DDD8609D02", hash_generated_method = "7A7BA9C960480382009236B5807FDC04")
    
public static final Cipher getInstance(String transformation)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        return getCipher(transformation, null);
    }

    /**
     * Creates a new cipher for the specified transformation provided by the
     * specified provider.
     *
     * @param transformation
     *            the name of the transformation to create a cipher for.
     * @param provider
     *            the name of the provider to ask for the transformation.
     * @return a cipher for the requested transformation.
     * @throws NoSuchAlgorithmException
     *             if the specified provider can not provide the
     *             <i>transformation</i>, or it is {@code null}, empty or in an
     *             invalid format.
     * @throws NoSuchProviderException
     *             if no provider with the specified name can be found.
     * @throws NoSuchPaddingException
     *             if the requested padding scheme in the <i>transformation</i>
     *             is not available.
     * @throws IllegalArgumentException
     *             if the specified provider is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.179 -0500", hash_original_method = "C2D2096568C68F5A71EDB8A2129CC4CE", hash_generated_method = "2AD0AAF98ABD33E1D5EB4B040D89828D")
    
public static final Cipher getInstance(String transformation,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException, NoSuchPaddingException {

        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }

        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException("Provider not available: " + provider);
        }
        return getInstance(transformation, p);
    }

    /**
     * Creates a new cipher for the specified transformation.
     *
     * @param transformation
     *            the name of the transformation to create a cipher for.
     * @param provider
     *            the provider to ask for the transformation.
     * @return a cipher for the requested transformation.
     * @throws NoSuchAlgorithmException
     *             if the specified provider can not provide the
     *             <i>transformation</i>, or it is {@code null}, empty or in an
     *             invalid format.
     * @throws NoSuchPaddingException
     *             if the requested padding scheme in the <i>transformation</i>
     *             is not available.
     * @throws IllegalArgumentException
     *             if the provider is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.182 -0500", hash_original_method = "799187ABBBF244571009789D513A15DA", hash_generated_method = "B92DA7B99FB412ECBF1AC0F6121D73FF")
    
public static final Cipher getInstance(String transformation,
            Provider provider) throws NoSuchAlgorithmException,
            NoSuchPaddingException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        Cipher c = getCipher(transformation, provider);
        return c;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.185 -0500", hash_original_method = "31B6CB29ED2F5413954ED45B70CE7980", hash_generated_method = "286B4EF9ED3C09E27A6A02D565EE55F7")
    
private static NoSuchAlgorithmException invalidTransformation(String transformation)
            throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("Invalid transformation: " + transformation);
    }

    /**
     * Find appropriate Cipher according the specification rules
     *
     * @param transformation
     * @param provider
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.189 -0500", hash_original_method = "339FD1DB95451DD24CDE548E6DAA85EE", hash_generated_method = "A579FA8061BF3808C4D5023922279285")
    
private static synchronized Cipher getCipher(String transformation, Provider provider)
            throws NoSuchAlgorithmException, NoSuchPaddingException {

        if (transformation == null || transformation.isEmpty()) {
            throw invalidTransformation(transformation);
        }

        String[] transf = checkTransformation(transformation);

        boolean needSetPadding = false;
        boolean needSetMode = false;
        Object engineSpi = null;
        Provider engineProvider = provider;
        if (transf[1] == null && transf[2] == null) { // "algorithm"
            if (provider == null) {
                Engine.SpiAndProvider sap = ENGINE.getInstance(transf[0], null);
                engineSpi = sap.spi;
                engineProvider = sap.provider;
            } else {
                engineSpi = ENGINE.getInstance(transf[0], provider, null);
            }
        } else {
            String[] searchOrder = {
                transf[0] + "/" + transf[1] + "/" + transf[2], // "algorithm/mode/padding"
                transf[0] + "/" + transf[1], // "algorithm/mode"
                transf[0] + "//" + transf[2], // "algorithm//padding"
                transf[0] // "algorithm"
            };
            int i;
            for (i = 0; i < searchOrder.length; i++) {
                try {
                    if (provider == null) {
                        Engine.SpiAndProvider sap = ENGINE.getInstance(searchOrder[i], null);
                        engineSpi = sap.spi;
                        engineProvider = sap.provider;
                    } else {
                        engineSpi = ENGINE.getInstance(searchOrder[i], provider, null);
                    }
                    break;
                } catch (NoSuchAlgorithmException e) {
                    if (i == searchOrder.length-1) {
                        throw new NoSuchAlgorithmException(transformation, e);
                    }
                }
            }
            switch (i) {
                case 1: // "algorithm/mode"
                    needSetPadding = true;
                    break;
                case 2: // "algorithm//padding"
                    needSetMode = true;
                    break;
                case 3: // "algorithm"
                    needSetPadding = true;
                    needSetMode = true;
            }
        }
        if (engineSpi == null || engineProvider == null) {
            throw new NoSuchAlgorithmException(transformation);
        }
        if (!(engineSpi instanceof CipherSpi)) {
            throw new NoSuchAlgorithmException(engineSpi.getClass().getName());
        }
        CipherSpi cspi = (CipherSpi) engineSpi;
        Cipher c = new Cipher(cspi, engineProvider, transformation);
        if (needSetMode) {
            c.spiImpl.engineSetMode(transf[1]);
        }
        if (needSetPadding) {
            c.spiImpl.engineSetPadding(transf[2]);
        }
        return c;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.192 -0500", hash_original_method = "CBDBE8535C51B6F20B21C297E0737B0F", hash_generated_method = "278111CE9992CA4C7A69117568A0F6D4")
    
private static String[] checkTransformation(String transformation) throws NoSuchAlgorithmException {
        // ignore an extra prefix / characters such as in
        // "/DES/CBC/PKCS5Paddin" http://b/3387688
        if (transformation.startsWith("/")) {
            transformation = transformation.substring(1);
        }
        // 'transformation' should be of the form "algorithm/mode/padding".
        String[] pieces = transformation.split("/");
        if (pieces.length > 3) {
            throw invalidTransformation(transformation);
        }
        // Empty or missing pieces are represented by null.
        String[] result = new String[3];
        for (int i = 0; i < pieces.length; ++i) {
            String piece = pieces[i].trim();
            if (!piece.isEmpty()) {
                result[i] = piece;
            }
        }
        // You MUST specify an algorithm.
        if (result[0] == null) {
            throw invalidTransformation(transformation);
        }
        if (!(result[1] == null && result[2] == null) && (result[1] == null || result[2] == null)) {
            throw invalidTransformation(transformation);
        }
        return result;
    }

    /**
     * Returns the maximum key length for the specified transformation.
     *
     * @param transformation
     *            the transformation name.
     * @return the maximum key length, currently {@code Integer.MAX_VALUE}.
     * @throws NoSuchAlgorithmException
     *             if no provider for the specified {@code transformation} can
     *             be found.
     * @throws NullPointerException
     *             if {@code transformation} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.272 -0500", hash_original_method = "207830FDF048D662A60B871B6CF83B6F", hash_generated_method = "48B81DBED41AEA934F93239C5BB46767")
    
public static final int getMaxAllowedKeyLength(String transformation)
            throws NoSuchAlgorithmException {
        if (transformation == null) {
            throw new NullPointerException();
        }
        checkTransformation(transformation);
        //FIXME jurisdiction policy files
        return Integer.MAX_VALUE;
    }

    /**
     * Returns the maximum cipher parameter value for the specified
     * transformation. If there is no maximum limit, {@code null} is returned.
     *
     * @param transformation
     *            the transformation name.
     * @return a parameter spec holding the maximum value or {@code null}.
     *         Currently {@code null}.
     * @throws NoSuchAlgorithmException
     *             if no provider for the specified {@code transformation} can
     *             be found.
     * @throws NullPointerException
     *             if {@code transformation} is {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.275 -0500", hash_original_method = "45AE9081BC51DBA62F011B19097CAB7A", hash_generated_method = "481A4F2FE711850D3EFD32E1BDBBB018")
    
public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(
            String transformation) throws NoSuchAlgorithmException {
        if (transformation == null) {
            throw new NullPointerException();
        }
        checkTransformation(transformation);
        //FIXME jurisdiction policy files
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.139 -0500", hash_original_field = "CC1967510BDB7F49B3D05DC53D3FF2B2", hash_generated_field = "2F15DC862DF8E709496A189635636236")

    public static final int DECRYPT_MODE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.142 -0500", hash_original_field = "59CC23DB87698F655871D56C4E846AF8", hash_generated_field = "A83EC5987C5AA77E22791E25CFA393A2")

    public static final int ENCRYPT_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.144 -0500", hash_original_field = "10092EED0AD9897466ECA3F11006BDF8", hash_generated_field = "0081C7108661D39138574156E05B2FCD")

    public static final int PRIVATE_KEY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.147 -0500", hash_original_field = "BE08D3986BDDF7CAA45CA2F12D22E27C", hash_generated_field = "295FEA31A43E6359048D4E46607B1E49")

    public static final int PUBLIC_KEY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.149 -0500", hash_original_field = "EA3A7DEF127205D2877643B56EF4A8FB", hash_generated_field = "677CDE87FE6610FD7AB080651DB96E2F")

    public static final int SECRET_KEY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.152 -0500", hash_original_field = "869E9B819E892CF0B3E01CEBDD89952F", hash_generated_field = "9CA0A457708663E8B7EA225ECB1B0CA6")

    public static final int UNWRAP_MODE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.155 -0500", hash_original_field = "EAC160105E7BF8809010513C4D6754E5", hash_generated_field = "04C8E84D8FBFED46FA7E0F269D64C2EB")

    public static final int WRAP_MODE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.159 -0500", hash_original_field = "C02C5556BE8062A628A495F209E9014B", hash_generated_field = "A6EBFC9B978978AEFD771859660D05E3")

    private static final String SERVICE = "Cipher";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.162 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.171 -0500", hash_original_field = "34751ECE59C87D5C11B7F66A26E0E74E", hash_generated_field = "09B90F530A62DA10A38CA3C1F3C2FAB8")

    private static SecureRandom secureRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.157 -0500", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.164 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.167 -0500", hash_original_field = "676371C3679E2138944B904312A9D3FD", hash_generated_field = "609F6DC57B3704B1B8111A24F710F199")

    private CipherSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.169 -0500", hash_original_field = "D91869C9C7BB10C6FF2D94561E15F783", hash_generated_field = "2B831647F5B0DC5F72250AEA4C817CDC")

    private String transformation;

    /**
     * Creates a new Cipher instance.
     *
     * @param cipherSpi
     *            the implementation delegate of the cipher.
     * @param provider
     *            the provider of the implementation of this cipher.
     * @param transformation
     *            the name of the transformation that this cipher performs.
     * @throws NullPointerException
     *             if either cipherSpi is {@code null} or provider is {@code
     *             null} and {@code cipherSpi} is a {@code NullCipherSpi}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.174 -0500", hash_original_method = "169E8725E31AA026BEEB43CC41C0DB25", hash_generated_method = "2A11FEF793F95F530D012A8DAC187222")
    
protected Cipher(CipherSpi cipherSpi, Provider provider,
            String transformation) {
        if (cipherSpi == null) {
            throw new NullPointerException();
        }
        if (!(cipherSpi instanceof NullCipherSpi) && provider == null) {
            throw new NullPointerException();
        }
        this.provider = provider;
        this.transformation = transformation;
        this.spiImpl = cipherSpi;
    }

    /**
     * Returns the provider of this cipher instance.
     *
     * @return the provider of this cipher instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.194 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the name of the algorithm of this cipher instance.
     * <p>
     * This is the name of the <i>transformation</i> argument used in the
     * {@code getInstance} call creating this object.
     *
     * @return the name of the algorithm of this cipher instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.197 -0500", hash_original_method = "8DF6BCF87B142C85CC5BB8E6263E3718", hash_generated_method = "BD8C21552E6E90777E0930CD67C9B03B")
    
public final String getAlgorithm() {
        return transformation;
    }

    /**
     * Returns this ciphers block size (in bytes).
     *
     * @return this ciphers block size.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.199 -0500", hash_original_method = "D9E2BEA1F59A5109A8382C65AF7F31D0", hash_generated_method = "A8949AAF0844A0CD122CC658F600A160")
    
public final int getBlockSize() {
        return spiImpl.engineGetBlockSize();
    }

    /**
     * Returns the length in bytes an output buffer needs to be when this cipher
     * is updated with {@code inputLen} bytes.
     *
     * @param inputLen
     *            the number of bytes of the input.
     * @return the output buffer length for the input length.
     * @throws IllegalStateException
     *             if this cipher instance is in an invalid state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.201 -0500", hash_original_method = "AA8C5558649103E88A25D53E8218E1F5", hash_generated_method = "FFAB2FE31163CBE3C13A798514DBE09B")
    
public final int getOutputSize(int inputLen) {
        if (mode == 0) {
            throw new IllegalStateException("Cipher has not yet been initialized");
        }
        return spiImpl.engineGetOutputSize(inputLen);
    }

    /**
     * Returns the <i>initialization vector</i> for this cipher instance.
     *
     * @return the <i>initialization vector</i> for this cipher instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.204 -0500", hash_original_method = "99DAD5FABE956FC53B6CC59AB3BC8215", hash_generated_method = "98791FB7D71F2BF1ACECB15A3059B7CE")
    
public final byte[] getIV() {
        return spiImpl.engineGetIV();
    }

    /**
     * Returns the parameters that where used to create this cipher instance.
     * <p>
     * These may be a the same parameters that were used to create this cipher
     * instance, or may be a combination of default and random parameters,
     * depending on the underlying cipher implementation.
     *
     * @return the parameters that where used to create this cipher instance, or
     *         {@code null} if this cipher instance does not have any
     *         parameters.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.206 -0500", hash_original_method = "1EF273790A635FFB8595723F2B2D47C7", hash_generated_method = "1CFAA2312177A93B935AB4BE6AC4E7BA")
    
public final AlgorithmParameters getParameters() {
        return spiImpl.engineGetParameters();
    }

    /**
     * Returns the exemption mechanism associated with this cipher.
     *
     * @return currently {@code null}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.209 -0500", hash_original_method = "8BD6E3BF151C3D35A58DA717088B655C", hash_generated_method = "22B367A99BB69123C0F178793A90EC19")
    
public final ExemptionMechanism getExemptionMechanism() {
        //FIXME implement getExemptionMechanism

        //        try {
        //            return ExemptionMechanism.getInstance(transformation, provider);
        //        } catch (NoSuchAlgorithmException e) {
        return null;
        //        }

    }

    /**
     * Initializes this cipher instance with the specified key.
     * <p>
     * The cipher is initialized for the specified operational mode (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * If this cipher instance needs any algorithm parameters or random values
     * that the specified key can not provide, the underlying implementation of
     * this cipher is supposed to generate the required parameters (using its
     * provider or random values).
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, meaning that it
     * is equivalent to creating a new instance and calling its {@code init}
     * method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param key
     *            the input key for the operation.
     * @throws InvalidKeyException
     *             if the specified key can not be used to initialize this
     *             cipher instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.212 -0500", hash_original_method = "429E4D2BD5B61AF47430304468140423", hash_generated_method = "521DA08B31618FB4D102310808011570")
    
public final void init(int opmode, Key key) throws InvalidKeyException {
        if (secureRandom == null) {
            // In theory it might be thread-unsafe but in the given case it's OK
            // since it does not matter which SecureRandom instance is passed
            // to the init()
            secureRandom = new SecureRandom();
        }
        init(opmode, key, secureRandom);
    }

    /**
     * Initializes this cipher instance with the specified key and a source of
     * randomness.
     * <p>
     * The cipher is initialized for the specified operational mode (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * If this cipher instance needs any algorithm parameters or random values
     * that the specified key can not provide, the underlying implementation of
     * this cipher is supposed to generate the required parameters (using its
     * provider or random values). Random values are generated using {@code
     * random};
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, means it is
     * equivalent to creating a new instance and calling it {@code init} method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param key
     *            the input key for the operation.
     * @param random
     *            the source of randomness to use.
     * @throws InvalidKeyException
     *             if the specified key can not be used to initialize this
     *             cipher instance.
     * @throws InvalidParameterException
     *             if the specified opmode is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.214 -0500", hash_original_method = "0BCC9283EB770D83968E2D5392900813", hash_generated_method = "F0434CE3494002EC26F18FCC50A2C4CD")
    
public final void init(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        checkMode(opmode);
        //        FIXME InvalidKeyException
        //        if keysize exceeds the maximum allowable keysize
        //        (jurisdiction policy files)
        spiImpl.engineInit(opmode, key, random);
        mode = opmode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.216 -0500", hash_original_method = "09F21B40649178B5CD7EDFF6A1F24869", hash_generated_method = "9EE2533A8E8FA6D0BDC78251310E65E9")
    
private void checkMode(int mode) {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE
            && mode != UNWRAP_MODE && mode != WRAP_MODE) {
            throw new InvalidParameterException("Invalid mode: " + mode);
        }
    }

    /**
     * Initializes this cipher instance with the specified key and algorithm
     * parameters.
     * <p>
     * The cipher is initialized for the specified operational mode (one of:
     * encryption, decryption, key wrapping or key unwrapping).
     * <p>
     * If this cipher instance needs any algorithm parameters and {@code params}
     * is {@code null}, the underlying implementation of this cipher is supposed
     * to generate the required parameters (using its provider or random
     * values).
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, means it is
     * equivalent to creating a new instance and calling it {@code init} method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param key
     *            the input key for the operation.
     * @param params
     *            the algorithm parameters.
     * @throws InvalidKeyException
     *             if the specified key can not be used to initialize this
     *             cipher instance.
     * @throws InvalidAlgorithmParameterException
     *             it the specified parameters are inappropriate for this
     *             cipher.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.219 -0500", hash_original_method = "BBC8C1A41A2EA4CA6303B616FCC7D14B", hash_generated_method = "F0AD7A3188CC71BBE28E7C61DB009F54")
    
public final void init(int opmode, Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(opmode, key, params, secureRandom);
    }

    /**
     * Initializes this cipher instance with the specified key, algorithm
     * parameters and a source of randomness.
     * <p>
     * The cipher is initialized for the specified operational mode (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * If this cipher instance needs any algorithm parameters and {@code params}
     * is {@code null}, the underlying implementation of this cipher is supposed
     * to generate the required parameters (using its provider or random
     * values). Random values are generated using {@code random};
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, meaning that it
     * is equivalent to creating a new instance and calling it {@code init}
     * method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param key
     *            the input key for the operation.
     * @param params
     *            the algorithm parameters.
     * @param random
     *            the source of randomness to use.
     * @throws InvalidKeyException
     *             if the specified key can not be used to initialize this
     *             cipher instance.
     * @throws InvalidAlgorithmParameterException
     *             it the specified parameters are inappropriate for this
     *             cipher.
     * @throws InvalidParameterException
     *             if the specified {@code opmode} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.221 -0500", hash_original_method = "8E7DC73E6E4E585B73E6EA7E879FC58B", hash_generated_method = "22D55C9A4FEF462385A1500BE80AA527")
    
public final void init(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        checkMode(opmode);
        //        FIXME InvalidKeyException
        //        if keysize exceeds the maximum allowable keysize
        //        (jurisdiction policy files)
        //        FIXME InvalidAlgorithmParameterException
        //        cryptographic strength exceed the legal limits
        //        (jurisdiction policy files)
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
    }

    /**
     * Initializes this cipher instance with the specified key and algorithm
     * parameters.
     * <p>
     * The cipher is initialized for the specified operation (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * If this cipher instance needs any algorithm parameters and {@code params}
     * is {@code null}, the underlying implementation of this cipher is supposed
     * to generate the required parameters (using its provider or random
     * values).
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, meaning that it
     * is equivalent to creating a new instance and calling it {@code init}
     * method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param key
     *            the input key for the operation.
     * @param params
     *            the algorithm parameters.
     * @throws InvalidKeyException
     *             if the specified key can not be used to initialize this
     *             cipher instance.
     * @throws InvalidAlgorithmParameterException
     *             it the specified parameters are inappropriate for this
     *             cipher.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.223 -0500", hash_original_method = "BF9CD5FCB5A2729A943C192A3430B212", hash_generated_method = "65FB7F143990D8CDB9814002FF8745AC")
    
public final void init(int opmode, Key key, AlgorithmParameters params)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(opmode, key, params, secureRandom);
    }

    /**
     * Initializes this cipher instance with the specified key, algorithm
     * parameters and a source of randomness.
     * <p>
     * The cipher will be initialized for the specified operation (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * If this cipher instance needs any algorithm parameters and {@code params}
     * is {@code null}, the underlying implementation of this cipher is supposed
     * to generate the required parameters (using its provider or random
     * values). Random values are generated using {@code random}.
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, means it is
     * equivalent to creating a new instance and calling it {@code init} method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param key
     *            the input key for the operation.
     * @param params
     *            the algorithm parameters.
     * @param random
     *            the source of randomness to use.
     * @throws InvalidKeyException
     *             if the specified key can not be used to initialize this
     *             cipher instance.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are inappropriate for this
     *             cipher.
     * @throws InvalidParameterException
     *             if the specified {@code opmode} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.227 -0500", hash_original_method = "807F390A384AF896657386359C87C81B", hash_generated_method = "C7B3400F29B65C61B9DF9EBACD463B2A")
    
public final void init(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        checkMode(opmode);
        //        FIXME InvalidKeyException
        //        if keysize exceeds the maximum allowable keysize
        //        (jurisdiction policy files)
        //        FIXME InvalidAlgorithmParameterException
        //        cryptographic strength exceed the legal limits
        //        (jurisdiction policy files)
        spiImpl.engineInit(opmode, key, params, random);
        mode = opmode;
    }

    /**
     * Initializes this cipher instance with the public key from the specified
     * certificate.
     * <p>
     * The cipher will be initialized for the specified operation (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * It the type of the certificate is X.509 and the certificate has a <i>key
     * usage</i> extension field marked as critical, the specified {@code
     * opmode} has the be enabled for this key, otherwise an {@code
     * InvalidKeyException} is thrown.
     * <p>
     * If this cipher instance needs any algorithm parameters that the key in
     * the certificate can not provide, the underlying implementation of this
     * cipher is supposed to generate the required parameters (using its
     * provider or random values).
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, means it is
     * equivalent to creating a new instance and calling it {@code init} method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param certificate
     *            the certificate.
     * @throws InvalidKeyException
     *             if the public key in the certificate can not be used to
     *             initialize this cipher instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.229 -0500", hash_original_method = "D1B8B02AA4362AEA38C29780F594C5E0", hash_generated_method = "64938EA585612C18F2DBCB88DFBA6A92")
    
public final void init(int opmode, Certificate certificate)
            throws InvalidKeyException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(opmode, certificate, secureRandom);
    }

    /**
     * Initializes this cipher instance with the public key from the specified
     * certificate and a source of randomness.
     * <p>
     * The cipher will be initialized for the specified operation (one of:
     * encryption, decryption, key wrapping or key unwrapping) depending on
     * {@code opmode}.
     * <p>
     * It the type of the certificate is X.509 and the certificate has a <i>key
     * usage</i> extension field marked as critical, the specified {@code
     * opmode} has the be enabled for this key, otherwise an {@code
     * InvalidKeyException} is thrown.
     * <p>
     * If this cipher instance needs any algorithm parameters that the key in
     * the certificate can not provide, the underlying implementation of this
     * cipher is supposed to generate the required parameters (using its
     * provider or random values). Random values are generated using {@code
     * random}.
     * <p>
     * When a cipher instance is initialized by a call to any of the {@code
     * init} methods, the state of the instance is overridden, means it is
     * equivalent to creating a new instance and calling it {@code init} method.
     *
     * @param opmode
     *            the operation this cipher instance should be initialized for
     *            (one of: {@code ENCRYPT_MODE}, {@code DECRYPT_MODE}, {@code
     *            WRAP_MODE} or {@code UNWRAP_MODE}).
     * @param certificate
     *            the certificate.
     * @param random
     *            the source of randomness to be used.
     * @throws InvalidKeyException
     *             if the public key in the certificate can not be used to
     *             initialize this cipher instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.232 -0500", hash_original_method = "CF5B7C36D9EDA90E4E4A39DDF2F721FD", hash_generated_method = "8243EB2A4C12601286260F1106AB882F")
    
public final void init(int opmode, Certificate certificate,
            SecureRandom random) throws InvalidKeyException {
        checkMode(opmode);
        if (certificate instanceof X509Certificate) {
            Set<String> ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical = false;
            if (ce != null && !ce.isEmpty()) {
                for (String oid : ce) {
                    if (oid.equals("2.5.29.15")) { // KeyUsage OID = 2.5.29.15
                        critical = true;
                        break;
                    }
                }
                if (critical) {
                    boolean[] keyUsage = ((X509Certificate) certificate).getKeyUsage();
                    // As specified in RFC 3280:
                    //   Internet X.509 Public Key Infrastructure
                    //   Certificate and Certificate Revocation List (CRL) Profile.
                    // Section 4.2.1.3  Key Usage
                    // http://www.ietf.org/rfc/rfc3280.txt
                    //
                    // KeyUsage ::= BIT STRING {digitalSignature (0),
                    //                          nonRepudiation   (1),
                    //                          keyEncipherment  (2),
                    //                          dataEncipherment (3),
                    //                          keyAgreement     (4),
                    //                          keyCertSign      (5),
                    //                          cRLSign          (6),
                    //                          encipherOnly     (7),
                    //                          decipherOnly     (8) }
                    if (keyUsage != null) {
                        if (opmode == ENCRYPT_MODE && !keyUsage[3]) {
                            throw new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for ENCRYPT_MODE");
                        } else if (opmode == WRAP_MODE && !keyUsage[2]) {
                            throw new InvalidKeyException("The public key in the certificate "
                                                          + "cannot be used for WRAP_MODE");
                        }
                    }
                }
            }
        }
        //        FIXME InvalidKeyException
        //        if keysize exceeds the maximum allowable keysize
        //        (jurisdiction policy files)
        spiImpl.engineInit(opmode, certificate.getPublicKey(), random);
        mode = opmode;
    }

    /**
     * Continues a multi-part transformation (encryption or decryption). The
     * transformed bytes are returned.
     *
     * @param input
     *            the input bytes to transform.
     * @return the transformed bytes in a new buffer, or {@code null} if the
     *         input has zero length.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if the input is {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.236 -0500", hash_original_method = "D2539732F50CEA46903EFE3EE2FFBB7D", hash_generated_method = "08D5F86E631D94343F37D23A8C84BEB9")
    
public final byte[] update(byte[] input) {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (input == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (input.length == 0) {
            return null;
        }
        return spiImpl.engineUpdate(input, 0, input.length);
    }

    /**
     * Continues a multi-part transformation (encryption or decryption). The
     * transformed bytes are returned.
     *
     * @param input
     *            the input bytes to transform.
     * @param inputOffset
     *            the offset in the input to start.
     * @param inputLen
     *            the length of the input to transform.
     * @return the transformed bytes in a new buffer, or {@code null} if the
     *         input has zero length.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if the input is {@code null}, or if {@code inputOffset} and
     *             {@code inputLen} do not specify a valid chunk in the input
     *             buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.238 -0500", hash_original_method = "6B0ED73318E2DF96B368CBFEB9D8FD9F", hash_generated_method = "4796F139349A7DF8E05A6ADB42FE147C")
    
public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (input == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (inputOffset < 0 || inputLen < 0
                || inputLen > input.length
                || inputOffset > input.length - inputLen) {
            throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        }
        if (input.length == 0) {
            return null;
        }
        return spiImpl.engineUpdate(input, inputOffset, inputLen);
    }

    /**
     * Continues a multi-part transformation (encryption or decryption). The
     * transformed bytes are stored in the {@code output} buffer.
     * <p>
     * If the size of the {@code output} buffer is too small to hold the result,
     * a {@code ShortBufferException} is thrown. Use
     * {@link Cipher#getOutputSize getOutputSize} to check for the size of the
     * output buffer.
     *
     * @param input
     *            the input bytes to transform.
     * @param inputOffset
     *            the offset in the input to start.
     * @param inputLen
     *            the length of the input to transform.
     * @param output
     *            the output buffer.
     * @return the number of bytes placed in output.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if the input is {@code null}, the output is {@code null}, or
     *             if {@code inputOffset} and {@code inputLen} do not specify a
     *             valid chunk in the input buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.241 -0500", hash_original_method = "851A7508725C6167E01999D358074612", hash_generated_method = "CC7922A9B009171A43FB8D1459659BE1")
    
public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException {
        return update(input, inputOffset, inputLen, output, 0);
    }

    /**
     * Continues a multi-part transformation (encryption or decryption). The
     * transformed bytes are stored in the {@code output} buffer.
     * <p>
     * If the size of the {@code output} buffer is too small to hold the result,
     * a {@code ShortBufferException} is thrown. Use
     * {@link Cipher#getOutputSize getOutputSize} to check for the size of the
     * output buffer.
     *
     * @param input
     *            the input bytes to transform.
     * @param inputOffset
     *            the offset in the input to start.
     * @param inputLen
     *            the length of the input to transform.
     * @param output
     *            the output buffer.
     * @param outputOffset
     *            the offset in the output buffer.
     * @return the number of bytes placed in output.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if the input is {@code null}, the output is {@code null}, or
     *             if {@code inputOffset} and {@code inputLen} do not specify a
     *             valid chunk in the input buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.244 -0500", hash_original_method = "43E41610DEFFC00737E44CA5E5476BCF", hash_generated_method = "4C5A23C2BD099A5DF0CA4DB0810977C3")
    
public final int update(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (input == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (output == null) {
            throw new IllegalArgumentException("output == null");
        }
        if (outputOffset < 0) {
            throw new IllegalArgumentException("outputOffset < 0");
        }
        if (inputOffset < 0 || inputLen < 0 || inputLen > input.length
                || inputOffset > input.length - inputLen) {
            throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        }
        if (input.length == 0) {
            return 0;
        }
        return spiImpl.engineUpdate(input, inputOffset, inputLen, output,
                outputOffset);
    }

    /**
     * Continues a multi-part transformation (encryption or decryption). The
     * {@code input.remaining()} bytes starting at {@code input.position()} are
     * transformed and stored in the {@code output} buffer.
     * <p>
     * If the {@code output.remaining()} is too small to hold the transformed
     * bytes a {@code ShortBufferException} is thrown. Use
     * {@link Cipher#getOutputSize getOutputSize} to check for the size of the
     * output buffer.
     *
     * @param input
     *            the input buffer to transform.
     * @param output
     *            the output buffer to store the result within.
     * @return the number of bytes stored in the output buffer.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if the input buffer and the output buffer are the identical
     *             object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.246 -0500", hash_original_method = "3650ED22F64FB3DE8113B7C668BA6C70", hash_generated_method = "9AD099D9D75C140803A1351F7E3E19A3")
    
public final int update(ByteBuffer input, ByteBuffer output)
            throws ShortBufferException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (input == output) {
            throw new IllegalArgumentException("input == output");
        }
        return spiImpl.engineUpdate(input, output);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes any bytes that may have been buffered in previous {@code
     * update} calls.
     *
     * @return the final bytes from the transformation.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.249 -0500", hash_original_method = "F0FEA4F0F73707A698ECC32C0962F654", hash_generated_method = "3D0FB34E4A2756F232DFAB6041E899F8")
    
public final byte[] doFinal() throws IllegalBlockSizeException,
            BadPaddingException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        return spiImpl.engineDoFinal(null, 0, 0);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes any bytes that may have been buffered in previous {@code
     * update} calls.
     * <p>
     * The final transformed bytes are stored in the {@code output} buffer.
     *
     * @param output
     *            the output buffer.
     * @param outputOffset
     *            the offset in the output buffer.
     * @return the number of bytes placed in the output buffer.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.251 -0500", hash_original_method = "93AA6B063068AA94349A945C7753479D", hash_generated_method = "2C9A2F3C59A5D43FF6129B05CABF6E77")
    
public final int doFinal(byte[] output, int outputOffset)
            throws IllegalBlockSizeException, ShortBufferException,
            BadPaddingException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (outputOffset < 0) {
            throw new IllegalArgumentException("outputOffset < 0");
        }
        return spiImpl.engineDoFinal(null, 0, 0, output, outputOffset);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes the bytes in {@code input} buffer, and any bytes that have been
     * buffered in previous {@code update} calls.
     *
     * @param input
     *            the input buffer.
     * @return the final bytes from the transformation.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.254 -0500", hash_original_method = "ED0F518E6798AF2EE42518F6A3E77904", hash_generated_method = "2B362B7F94558CDBD22CAC4F5C37AC52")
    
public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException,
            BadPaddingException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        return spiImpl.engineDoFinal(input, 0, input.length);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes the {@code inputLen} bytes in {@code input} buffer at {@code
     * inputOffset}, and any bytes that have been buffered in previous {@code
     * update} calls.
     *
     * @param input
     *            the input buffer.
     * @param inputOffset
     *            the offset in the input buffer.
     * @param inputLen
     *            the length of the input
     * @return the final bytes from the transformation.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if {@code inputOffset} and {@code inputLen} do not specify an
     *             valid chunk in the input buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.257 -0500", hash_original_method = "6B1737194DBFF54F3884AE72A596BA42", hash_generated_method = "2CCDDBB8351C7557D1F3B4C0573D273C")
    
public final byte[] doFinal(byte[] input, int inputOffset, int inputLen)
            throws IllegalBlockSizeException, BadPaddingException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length) {
            throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        }
        return spiImpl.engineDoFinal(input, inputOffset, inputLen);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes the {@code inputLen} bytes in {@code input} buffer at {@code
     * inputOffset}, and any bytes that have been buffered in previous {@code
     * update} calls.
     *
     * @param input
     *            the input buffer.
     * @param inputOffset
     *            the offset in the input buffer.
     * @param inputLen
     *            the length of the input.
     * @param output
     *            the output buffer for the transformed bytes.
     * @return the number of bytes placed in the output buffer.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if {@code inputOffset} and {@code inputLen} do not specify an
     *             valid chunk in the input buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.259 -0500", hash_original_method = "A6D208F07F7B0D8A8A4180809C2EF479", hash_generated_method = "8488D6B16DF79546B439605B820C9B3A")
    
public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        return doFinal(input, inputOffset, inputLen, output, 0);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes the {@code inputLen} bytes in {@code input} buffer at {@code
     * inputOffset}, and any bytes that have been buffered in previous {@code
     * update} calls.
     *
     * @param input
     *            the input buffer.
     * @param inputOffset
     *            the offset in the input buffer.
     * @param inputLen
     *            the length of the input.
     * @param output
     *            the output buffer for the transformed bytes.
     * @param outputOffset
     *            the offset in the output buffer.
     * @return the number of bytes placed in the output buffer.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     * @throws IllegalArgumentException
     *             if {@code inputOffset} and {@code inputLen} do not specify an
     *             valid chunk in the input buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.262 -0500", hash_original_method = "46F54FF2783CE552AE826C81B354A349", hash_generated_method = "13E829A86E9B515D76C1D3373DDD511E")
    
public final int doFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (inputOffset < 0 || inputLen < 0 || inputOffset + inputLen > input.length) {
            throw new IllegalArgumentException("Incorrect inputOffset/inputLen parameters");
        }
        return spiImpl.engineDoFinal(input, inputOffset, inputLen, output,
                outputOffset);
    }

    /**
     * Finishes a multi-part transformation (encryption or decryption).
     * <p>
     * Processes the {@code input.remaining()} bytes in {@code input} buffer at
     * {@code input.position()}, and any bytes that have been buffered in
     * previous {@code update} calls. The transformed bytes are placed into
     * {@code output} buffer.
     *
     * @param input
     *            the input buffer.
     * @param output
     *            the output buffer.
     * @return the number of bytes placed into the output buffer.
     * @throws ShortBufferException
     *             if the size of the {@code output} buffer is too small.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws BadPaddingException
     *             if the padding of the data does not match the padding scheme.
     * @throws IllegalArgumentException
     *             if the input buffer and the output buffer are the same
     *             object.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for encryption or
     *             decryption.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.264 -0500", hash_original_method = "90770161074657C0B33458A086574F5B", hash_generated_method = "D5EA3E337FBD7055FD13C143E1CBD026")
    
public final int doFinal(ByteBuffer input, ByteBuffer output)
            throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        if (mode != ENCRYPT_MODE && mode != DECRYPT_MODE) {
            throw new IllegalStateException();
        }
        if (input == output) {
            throw new IllegalArgumentException("input == output");
        }
        return spiImpl.engineDoFinal(input, output);
    }

    /**
     * Wraps a key using this cipher instance.
     *
     * @param key
     *            the key to wrap.
     * @return the wrapped key.
     * @throws IllegalBlockSizeException
     *             if the size of the resulting bytes is not a multiple of the
     *             cipher block size.
     * @throws InvalidKeyException
     *             if this cipher instance can not wrap this key.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for wrapping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.266 -0500", hash_original_method = "6E0DA752A02639D8B96D35F2A60D917D", hash_generated_method = "6A8137C15B985EDA25A40EAE7F2F579A")
    
public final byte[] wrap(Key key) throws IllegalBlockSizeException,
            InvalidKeyException {
        if (mode != WRAP_MODE) {
            throw new IllegalStateException();
        }
        return spiImpl.engineWrap(key);
    }

    /**
     * Unwraps a key using this cipher instance.
     *
     * @param wrappedKey
     *            the wrapped key to unwrap.
     * @param wrappedKeyAlgorithm
     *            the algorithm for the wrapped key.
     * @param wrappedKeyType
     *            the type of the wrapped key (one of: {@code SECRET_KEY
     *            <code>, <code>PRIVATE_KEY} or {@code PUBLIC_KEY})
     * @return the unwrapped key
     * @throws InvalidKeyException
     *             if the {@code wrappedKey} can not be unwrapped to a key of
     *             type {@code wrappedKeyType} for the {@code
     *             wrappedKeyAlgorithm}.
     * @throws NoSuchAlgorithmException
     *             if no provider can be found that can create a key of type
     *             {@code wrappedKeyType} for the {@code wrappedKeyAlgorithm}.
     * @throws IllegalStateException
     *             if this cipher instance is not initialized for unwrapping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.269 -0500", hash_original_method = "601EF7D9B28B5898301EBC35141803DA", hash_generated_method = "413F0C46D488B56F71E26B18C416D817")
    
public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        if (mode != UNWRAP_MODE) {
            throw new IllegalStateException();
        }
        return spiImpl.engineUnwrap(wrappedKey, wrappedKeyAlgorithm,
                wrappedKeyType);
    }
}

