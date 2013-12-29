package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import org.apache.harmony.security.fortress.Engine;






public class SecretKeyFactory {

    /**
     * Creates a new {@code SecretKeyFactory} instance for the specified key
     * algorithm.
     *
     * @param algorithm
     *            the name of the key algorithm.
     * @return a secret key factory for the specified key algorithm.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the requested algorithm.
     * @throws NullPointerException
     *             if the specified algorithm is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.722 -0500", hash_original_method = "FA63063C6C30A15E13C0EA2583409D62", hash_generated_method = "F47579F88A935F5E8E05DA5C06601FD6")
    public static final SecretKeyFactory getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new SecretKeyFactory((SecretKeyFactorySpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code SecretKeyFactory} instance for the specified key
     * algorithm from the specified {@code provider}.
     *
     * @param algorithm
     *            the name of the key algorithm.
     * @param provider
     *            the name of the provider that provides the requested
     *            algorithm.
     * @return a secret key factory for the specified key algorithm from the
     *         specified provider.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws NoSuchProviderException
     *             if the specified provider does not exist.
     * @throws IllegalArgumentException
     *             if the specified provider name is {@code null} or empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.723 -0500", hash_original_method = "BD88C9F954E8F02EEE2FFD90BA21223E", hash_generated_method = "B374E7357E43E2821C9416AA7A7016B4")
    public static final SecretKeyFactory getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    /**
     * Creates a new {@code SecretKeyFactory} instance for the specified key
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the key algorithm.
     * @param provider
     *            the provider that provides the requested algorithm.
     * @return a secret key factory for the specified key algorithm from the
     *         specified provider.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provider the requested
     *             algorithm.
     * @throws IllegalArgumentException
     *             if the specified provider is {@code null}.
     * @throws NullPointerException
     *             is the specified algorithm name is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.724 -0500", hash_original_method = "203282E1287962AD001C6CC2CF356E7C", hash_generated_method = "8511625231A556A5B2AD5918D566CFF0")
    public static final SecretKeyFactory getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new SecretKeyFactory((SecretKeyFactorySpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.716 -0500", hash_original_field = "9AB4E1C92A388096352EC1258FED95EE", hash_generated_field = "6E247A48EBB8DC98BDBEC2A4DB1C6ED9")

    private static final Engine ENGINE = new Engine("SecretKeyFactory");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.716 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.717 -0500", hash_original_field = "21BDC798C76DAD6CDDB79E40EE66E30A", hash_generated_field = "79A1051781D270F714DE1FB341564966")

    private  SecretKeyFactorySpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.718 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code SecretKeyFactory}
     *
     * @param keyFacSpi
     *            the SPI delegate.
     * @param provider
     *            the provider providing this key factory.
     * @param algorithm
     *            the algorithm name for the secret key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.719 -0500", hash_original_method = "3C76CE2839A142E4DF9C7001A6A7FCB1", hash_generated_method = "B9AC3E6BE6378B2B3FC297A49AC9461E")
    protected SecretKeyFactory(SecretKeyFactorySpi keyFacSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyFacSpi;
    }

    /**
     * Returns the name of the secret key algorithm.
     *
     * @return the name of the secret key algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.720 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider for this {@code SecretKeyFactory} instance.
     *
     * @return the provider for this {@code SecretKeyFactory} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.721 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    public final Provider getProvider() {
        return provider;
    }

    /**
     * Generate a secret key from the specified key specification.
     *
     * @param keySpec
     *            the key specification.
     * @return a secret key.
     * @throws InvalidKeySpecException
     *             if the specified key specification cannot be used to generate
     *             a secret key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.724 -0500", hash_original_method = "F35C5482AA0FDE82A0C15F5E475C73A0", hash_generated_method = "7124C9FED05E541D0F774F22C9866D10")
    public final SecretKey generateSecret(KeySpec keySpec)
            throws InvalidKeySpecException {
        return spiImpl.engineGenerateSecret(keySpec);
    }

    /**
     * Returns the key specification of the specified secret key.
     *
     * @param key
     *            the secret key to get the specification from.
     * @param keySpec
     *            the target key specification class.
     * @return an instance of the specified key specification class.
     * @throws InvalidKeySpecException
     *             if the specified secret key cannot be transformed into the
     *             requested key specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.726 -0500", hash_original_method = "A1C05AB5848F28D95DBE9FF597A00F29", hash_generated_method = "8AE1E6D967D743794FCA493FB3DB98CA")
    @SuppressWarnings("unchecked")
public final KeySpec getKeySpec(SecretKey key, Class keySpec)
            throws InvalidKeySpecException {
        return spiImpl.engineGetKeySpec(key, keySpec);
    }

    /**
     * Translates the specified secret key into an instance of the corresponding
     * key from the provider of this key factory.
     *
     * @param key
     *            the secret key to translate.
     * @return the corresponding translated key.
     * @throws InvalidKeyException
     *             if the specified key cannot be translated using this key
     *             factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:26.726 -0500", hash_original_method = "DE7905EDF6B0EF2B9BB95373F14A9269", hash_generated_method = "1BBDB8944905322C059906793349F99A")
    public final SecretKey translateKey(SecretKey key)
            throws InvalidKeyException {
        return spiImpl.engineTranslateKey(key);

    }
}

