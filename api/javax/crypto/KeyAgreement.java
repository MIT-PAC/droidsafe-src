package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.harmony.security.fortress.Engine;

public class KeyAgreement {

    /**
     * Creates a new {@code KeyAgreement} for the specified algorithm.
     *
     * @param algorithm
     *            the name of the key agreement algorithm to create.
     * @return a key agreement for the specified algorithm.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the requested algorithm.
     * @throws NullPointerException
     *             if the specified algorithm is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.685 -0500", hash_original_method = "B47A219740118586666CCD69CC49496A", hash_generated_method = "A616473F2F51BF7BCB33E64B5A8E59FD")
    
public static final KeyAgreement getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyAgreement((KeyAgreementSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code KeyAgreement} for the specified algorithm from the
     * specified provider.
     *
     * @param algorithm
     *            the name of the key agreement algorithm to create.
     * @param provider
     *            the name of the provider that provides the requested
     *            algorithm.
     * @return a key agreement for the specified algorithm from the specified
     *         provider.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws NoSuchProviderException
     *             if the specified provider does not exist.
     * @throws IllegalArgumentException
     *             if the specified provider name is {@code null} or empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.687 -0500", hash_original_method = "15E32742E48F2C4FCE8AA21BACC6497C", hash_generated_method = "84B2BAB8B2D9436C5CB25AF797E95ADD")
    
public static final KeyAgreement getInstance(String algorithm,
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
     * Create a new {@code KeyAgreement} for the specified algorithm from the
     * specified provider.
     *
     * @param algorithm
     *            the name of the key agreement algorithm to create.
     * @param provider
     *            the provider that provides the requested algorithm.
     * @return a key agreement for the specified algorithm from the specified
     *         provider.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws IllegalArgumentException
     *             if the specified provider is {@code null}.
     * @throws NullPointerException
     *             if the specified algorithm name is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.691 -0500", hash_original_method = "55D6E810A87A15B14474891528748502", hash_generated_method = "AC7909B2DEC44CA4C961892CAD2F01CD")
    
public static final KeyAgreement getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyAgreement((KeyAgreementSpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.664 -0500", hash_original_field = "58A6ABCCD3D7DFC225FAF493E2154822", hash_generated_field = "13EC579A2F79ADB4E1474BB593ACB93B")

    private static final Engine ENGINE = new Engine("KeyAgreement");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.667 -0500", hash_original_field = "FDD9E227182999EA06EE5AF5CE50D8B1", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.669 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.672 -0500", hash_original_field = "1098332B1307531C14C649DE3A7D8102", hash_generated_field = "7AE48DE8A3744D2D52151DAA301986BC")

    private  KeyAgreementSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.675 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code KeyAgreement} instance.
     *
     * @param keyAgreeSpi
     *            the <b>SPI</b> delegate.
     * @param provider
     *            the provider providing this KeyAgreement.
     * @param algorithm
     *            the name of the key agreement algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.677 -0500", hash_original_method = "0900837118FEE4DAFDEFCB258925423D", hash_generated_method = "B879D97A23F4EB81C19623B441B6448A")
    
protected KeyAgreement(KeyAgreementSpi keyAgreeSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyAgreeSpi;
    }

    /**
     * Returns the name of the key agreement algorithm.
     *
     * @return the name of the key agreement algorithm.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.680 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider for this {@code KeyAgreement} instance.
     *
     * @return the provider for this {@code KeyAgreement} instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.682 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Initializes this {@code KeyAgreement} with the specified key.
     *
     * @param key
     *            the key to initialize this key agreement.
     * @throws InvalidKeyException
     *             if the specified key cannot be used to initialize this key
     *             agreement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.693 -0500", hash_original_method = "D4F5C8E3486A3AF707B3A0052AE97F9F", hash_generated_method = "82B813F732E2303AFE9018B61838FDF6")
    
public final void init(Key key) throws InvalidKeyException {
        spiImpl.engineInit(key, RANDOM);//new SecureRandom());
    }

    /**
     * Initializes this {@code KeyAgreement} with the specified key and the
     * specified randomness source.
     *
     * @param key
     *            the key to initialize this key agreement.
     * @param random
     *            the source for any randomness needed.
     * @throws InvalidKeyException
     *             if the specified key cannot be used to initialize this key
     *             agreement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.695 -0500", hash_original_method = "B560CE194C80427D06320AB3301AD531", hash_generated_method = "1E85CA9693E4B8209D6DBE63E8A49A5A")
    
public final void init(Key key, SecureRandom random)
            throws InvalidKeyException {
        spiImpl.engineInit(key, random);
    }

    /**
     * Initializes this {@code KeyAgreement} with the specified key and the
     * algorithm parameters.
     *
     * @param key
     *            the key to initialize this key agreement.
     * @param params
     *            the parameters for this key agreement algorithm.
     * @throws InvalidKeyException
     *             if the specified key cannot be used to initialize this key
     *             agreement.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are invalid for this key
     *             agreement algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.698 -0500", hash_original_method = "45385F3B8A57987C5A6F500929E2FE45", hash_generated_method = "EFEAD487057AEBB56C96BE6816979A80")
    
public final void init(Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        spiImpl.engineInit(key, params, RANDOM);//new SecureRandom());
    }

    /**
     * Initializes this {@code KeyAgreement} with the specified key, algorithm
     * parameters and randomness source.
     *
     * @param key
     *            the key to initialize this key agreement.
     * @param params
     *            the parameters for this key agreement algorithm.
     * @param random
     *            the source for any randomness needed.
     * @throws InvalidKeyException
     *             if the specified key cannot be used to initialize this key
     *             agreement.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are invalid for this key
     *             agreement algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.700 -0500", hash_original_method = "04B90A53EC2A8EFB98D3E5D98D18DD54", hash_generated_method = "F002222551AF9055DF12D7D0FADCDC93")
    
public final void init(Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        spiImpl.engineInit(key, params, random);
    }

    /**
     * Does the next (or the last) phase of the key agreement, using the
     * specified key.
     *
     * @param key
     *            the key received from the other party for this phase.
     * @param lastPhase
     *            set to {@code true} if this is the last phase of this key
     *            agreement.
     * @return the intermediate key from this phase or {@code null} if there is
     *         no intermediate key for this phase.
     * @throws InvalidKeyException
     *             if the specified key cannot be used in this key agreement or
     *             this phase,
     * @throws IllegalStateException
     *             if this instance has not been initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.702 -0500", hash_original_method = "BB12C4D69D38F4161821D54CA8CAAD00", hash_generated_method = "CA67A7465EC0007AFC6782CFBB480377")
    
public final Key doPhase(Key key, boolean lastPhase)
            throws InvalidKeyException, IllegalStateException {
        return spiImpl.engineDoPhase(key, lastPhase);
    }

    /**
     * Generates the shared secret.
     *
     * @return the generated shared secret.
     * @throws IllegalStateException
     *             if this key agreement is not complete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.705 -0500", hash_original_method = "A2824ED5DB0FCCB2C192A225E52EA88C", hash_generated_method = "D836B75E16EC26E91DC8D560B1AA7650")
    
public final byte[] generateSecret() throws IllegalStateException {
        return spiImpl.engineGenerateSecret();
    }

    /**
     * Generates the shared secret and stores it into the buffer {@code
     * sharedSecred} at {@code offset}.
     *
     * @param sharedSecret
     *            the buffer to store the shared secret.
     * @param offset
     *            the offset in the buffer.
     * @return the number of bytes stored in the buffer.
     * @throws IllegalStateException
     *             if this key agreement is not complete.
     * @throws ShortBufferException
     *             if the specified buffer is too small for the shared secret.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.708 -0500", hash_original_method = "7B919BB67435CAC1AF727C4D009370B1", hash_generated_method = "7CC0610A91F2EB77C23511B65EA46F89")
    
public final int generateSecret(byte[] sharedSecret, int offset)
            throws IllegalStateException, ShortBufferException {
        return spiImpl.engineGenerateSecret(sharedSecret, offset);
    }

    /**
     * Generates the shared secret.
     *
     * @param algorithm
     *            the algorithm to for the {@code SecretKey}
     * @return the shared secret as a {@code SecretKey} of the specified
     *         algorithm.
     * @throws IllegalStateException
     *             if this key agreement is not complete.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm for the secret key does not
     *             exists.
     * @throws InvalidKeyException
     *             if a {@code SecretKey} with the specified algorithm cannot be
     *             created using the generated shared secret.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.710 -0500", hash_original_method = "0E820F09DB891E9F2C0C31F49AA44F05", hash_generated_method = "C0876CAC578C9B7DED5DAE98E528571A")
    
public final SecretKey generateSecret(String algorithm)
            throws IllegalStateException, NoSuchAlgorithmException,
            InvalidKeyException {
        return spiImpl.engineGenerateSecret(algorithm);
    }
}

