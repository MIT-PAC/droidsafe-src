package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;

import org.apache.harmony.security.fortress.Engine;

public class KeyManagerFactory {

    /**
     * Returns the default key manager factory algorithm name.
     * <p>
     * The default algorithm name is specified by the security property:
     * {@code 'ssl.KeyManagerFactory.algorithm'}.
     *
     * @return the default algorithm name.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.560 -0500", hash_original_method = "229F778B6859CA40FB26009475BD7F6B", hash_generated_method = "63A460C369E77C59BCBD879DCA470902")
    
public static final String getDefaultAlgorithm() {
        return Security.getProperty(PROPERTY_NAME);
    }

    /**
     * Creates a new {@code KeyManagerFactory} instance for the specified key
     * management algorithm.
     *
     * @param algorithm
     *            the name of the requested key management algorithm.
     * @return a key manager factory for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the requested algorithm.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.563 -0500", hash_original_method = "E63256820D6255DA21EC6D0F4E72AFE8", hash_generated_method = "521B22CFC36AF78835953775476F27E6")
    
public static final KeyManagerFactory getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyManagerFactory((KeyManagerFactorySpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code KeyManagerFactory} instance for the specified key
     * management algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested key management algorithm name.
     * @param provider
     *            the name of the provider that provides the requested
     *            algorithm.
     * @return a key manager factory for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws NoSuchProviderException
     *             if the specified provider does not exist.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.565 -0500", hash_original_method = "1A5F334DDA4579EEFE002DF3CAD51E71", hash_generated_method = "01A81A0372C47326F3AA22B38C99184A")
    
public static final KeyManagerFactory getInstance(String algorithm, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        if ((provider == null) || (provider.length() == 0)) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    /**
     * Creates a new {@code KeyManagerFactory} instance for the specified key
     * management algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested key management algorithm name.
     * @param provider
     *            the provider that provides the requested algorithm.
     * @return a key manager factory for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.568 -0500", hash_original_method = "6EB88896F6D847F6C0CAAE1039AFE4F4", hash_generated_method = "FE349362A35154F40C4D2B4AF247D37C")
    
public static final KeyManagerFactory getInstance(String algorithm, Provider provider)
            throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyManagerFactory((KeyManagerFactorySpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.553 -0500", hash_original_field = "A083BE378C85C3968EAA8ABFD427A60B", hash_generated_field = "6093E7EBB23B13F23E0C67DF945E7DAF")

    private static final String SERVICE = "KeyManagerFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.556 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.558 -0500", hash_original_field = "37C92183297706DDA09B6589A1DCC53F", hash_generated_field = "A8EB468D11DCED53A26B66B0AF22B9BA")

    private static final String PROPERTY_NAME = "ssl.KeyManagerFactory.algorithm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.571 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.574 -0500", hash_original_field = "82085D514628EB639E883641A9EA9AAA", hash_generated_field = "66956FA0EC6E90989FDF6ECA22799199")

    private  KeyManagerFactorySpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.576 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code KeyManagerFactory}.
     *
     * @param factorySpi
     *            the implementation delegate.
     * @param provider
     *            the provider.
     * @param algorithm
     *            the key management algorithm name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.578 -0500", hash_original_method = "70F84550962AE46163866D0A34314F54", hash_generated_method = "9C64671A9E5207F99CC510E2ABE3AA92")
    
protected KeyManagerFactory(KeyManagerFactorySpi factorySpi, Provider provider,
                                String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = factorySpi;
    }

    /**
     * Returns the name of the key management algorithm.
     *
     * @return the name of the key management algorithm.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.580 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider for this {@code KeyManagerFactory} instance.
     *
     * @return the provider for this {@code KeyManagerFactory} instance.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.582 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Initializes this instance with the specified key store and password.
     *
     * @param ks
     *            the key store or {@code null} to use the default key store.
     * @param password
     *            the password for the specified key store or {@code null} if no
     *            key store is provided.
     * @throws KeyStoreException
     *             if initializing this key manager factory fails.
     * @throws NoSuchAlgorithmException
     *             if a required algorithm is not available.
     * @throws UnrecoverableKeyException
     *             if a key cannot be recovered.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.585 -0500", hash_original_method = "4FB19D2B9D9DA541468809C3D1BCD49A", hash_generated_method = "1CCC7F83B16C24862DDDC8F2F73E2FD5")
    
public final void init(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException {
        spiImpl.engineInit(ks, password);
    }

    /**
     * Initializes this instance with the specified factory parameters.
     *
     * @param spec
     *            the factory parameters.
     * @throws InvalidAlgorithmParameterException
     *             if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.588 -0500", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "CD3068A149CCD5B39C06926A2722E3EE")
    
public final void init(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(spec);
    }

    /**
     * Returns a list of key managers, one instance for each type of key in the
     * key store.
     *
     * @return a list of key managers.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.590 -0500", hash_original_method = "B9A1EAEE9A7433E4D131EF6C1483617B", hash_generated_method = "62540848042C144645818B31EA640557")
    
public final KeyManager[] getKeyManagers() {
        return spiImpl.engineGetKeyManagers();
    }
}

