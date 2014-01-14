package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import org.apache.harmony.security.fortress.Engine;

public class KeyFactory {

    /**
     * Returns a new instance of {@code KeyFactory} that utilizes the specified
     * algorithm.
     *
     * @param algorithm
     *            the name of the algorithm.
     * @return a new instance of {@code KeyFactory} that utilizes the specified
     *         algorithm.
     * @throws NoSuchAlgorithmException
     *             if no provider provides the requested algorithm.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.721 -0500", hash_original_method = "882DD4EE2378CFA4943241FF4B933992", hash_generated_method = "10B19BA66738F202BDDE27A56E3667FC")
    
public static KeyFactory getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyFactory((KeyFactorySpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Returns a new instance of {@code KeyFactory} that utilizes the specified
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm.
     * @param provider
     *            the name of the provider.
     * @return a new instance of {@code KeyFactory} that utilizes the specified
     *         algorithm from the specified provider.
     * @throws NoSuchAlgorithmException
     *             if the provider does not provide the requested algorithm.
     * @throws NoSuchProviderException
     *             if the requested provider is not available.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.724 -0500", hash_original_method = "264444E5DC777949A2E14EADBD48C9C0", hash_generated_method = "3883A5E8F99BAA5F25879D71D842A529")
    
public static KeyFactory getInstance(String algorithm, String provider)
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
     * Returns a new instance of {@code KeyFactory} that utilizes the specified
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm.
     * @param provider
     *            the security provider.
     * @return a new instance of {@code KeyFactory} that utilizes the specified
     *         algorithm from the specified provider.
     * @throws NoSuchAlgorithmException
     *             if the provider does not provide the requested algorithm.
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.727 -0500", hash_original_method = "9DE9D482115D17A2D144E89EDB9BAAF8", hash_generated_method = "CAC24CAF03C2D579F076AF77F0988A41")
    
public static KeyFactory getInstance(String algorithm, Provider provider)
                                 throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyFactory((KeyFactorySpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.705 -0500", hash_original_field = "BD15E5C8E05C6B6C4C34768EF61C15AF", hash_generated_field = "24EFDD4E9206D29CCB161FC64C16C64A")

    private static final String SERVICE = "KeyFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.708 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.710 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.713 -0500", hash_original_field = "A2DCF3A96E98D7518F87DD2329FDE179", hash_generated_field = "CA0FD322067E5C95477D77E0231B374A")

    private  KeyFactorySpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.715 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Constructs a new instance of {@code KeyFactory} with the specified
     * arguments.
     *
     * @param keyFacSpi
     *            the concrete key factory service.
     * @param provider
     *            the provider.
     * @param algorithm
     *            the algorithm to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.718 -0500", hash_original_method = "8C178BBFD1FCE7A7C88CEB58B900756B", hash_generated_method = "F5AE21F9E82814DE9B4F05B39765AB26")
    
protected KeyFactory(KeyFactorySpi keyFacSpi,
                         Provider provider,
                         String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyFacSpi;
    }

    /**
     * Returns the provider associated with this {@code KeyFactory}.
     *
     * @return the provider associated with this {@code KeyFactory}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.729 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the name of the algorithm associated with this {@code
     * KeyFactory}.
     *
     * @return the name of the algorithm associated with this {@code
     *         KeyFactory}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.731 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Generates a instance of {@code PublicKey} from the given key
     * specification.
     *
     * @param keySpec
     *            the specification of the public key
     * @return the public key
     * @throws InvalidKeySpecException
     *             if the specified {@code keySpec} is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.733 -0500", hash_original_method = "D16F4EDBCE8E03F680EB7C937E0DCCC9", hash_generated_method = "102444EC2B52369C13232B3079E12538")
    
public final PublicKey generatePublic(KeySpec keySpec)
                                throws InvalidKeySpecException {
        return spiImpl.engineGeneratePublic(keySpec);
    }

    /**
     * Generates a instance of {@code PrivateKey} from the given key
     * specification.
     *
     * @param keySpec
     *            the specification of the private key.
     * @return the private key.
     * @throws InvalidKeySpecException
     *             if the specified {@code keySpec} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.736 -0500", hash_original_method = "56D108179E38B3C9859C6FCAEB589129", hash_generated_method = "5F9FEBC8492D7B5FA3559058A80AC133")
    
public final PrivateKey generatePrivate(KeySpec keySpec)
                                throws InvalidKeySpecException {
        return spiImpl.engineGeneratePrivate(keySpec);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.898 -0400", hash_original_method = "7B77F80B2A4A2C9E7EABE7EB820F4781", hash_generated_method = "2C9D88F6A5AEBE43B5C8DFAB3749E023")
    public final <T extends KeySpec> T getKeySpec(Key key,
                                    Class<T> keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
        addTaint(key.getTaint());
T var8F4D81791C8180D9CBCF44423DBEC0F6_77754240 =         spiImpl.engineGetKeySpec(key, keySpec);
        var8F4D81791C8180D9CBCF44423DBEC0F6_77754240.addTaint(taint);
        return var8F4D81791C8180D9CBCF44423DBEC0F6_77754240;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    /**
     * Translates the given key into a key from this key factory.
     *
     * @param key
     *            the key to translate.
     * @return the translated key.
     * @throws InvalidKeyException
     *             if the specified key can not be translated by this key
     *             factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.741 -0500", hash_original_method = "23F9E5F6A6B9FC183E94A65D97880068", hash_generated_method = "260BB15ED7C570368B6A69B586403BAC")
    
public final Key translateKey(Key key)
                        throws InvalidKeyException {
        return spiImpl.engineTranslateKey(key);
    }
}

