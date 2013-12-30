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

import org.apache.harmony.security.fortress.Engine;






public class TrustManagerFactory {

    /**
     * Returns the default algorithm name for the {@code TrustManagerFactory}. The
     * default algorithm name is specified by the security property
     * {@code 'ssl.TrustManagerFactory.algorithm'}.
     *
     * @return the default algorithm name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.786 -0500", hash_original_method = "5F5D549BD7868B08A395443DE4B6DFCC", hash_generated_method = "406F76C43B4C94BE46DE98CB0AFCD063")
    
public static final String getDefaultAlgorithm() {
        return Security.getProperty(PROPERTYNAME);
    }

    /**
     * Creates a new {@code TrustManagerFactory} instance for the specified
     * trust management algorithm.
     *
     * @param algorithm
     *            the name of the requested trust management algorithm.
     * @return a trust manager factory for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the requested algorithm.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.788 -0500", hash_original_method = "76ACD885B5FBDCE3E02DFAFDEBB1EED8", hash_generated_method = "D3D52D144D09C460DBB9E0EF659275D1")
    
public static final TrustManagerFactory getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new TrustManagerFactory((TrustManagerFactorySpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code TrustManagerFactory} instance for the specified
     * trust management algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested trust management algorithm name.
     * @param provider
     *            the name of the provider that provides the requested
     *            algorithm.
     * @return a trust manager factory for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws NoSuchProviderException
     *             if the specified provider does not exist.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.792 -0500", hash_original_method = "CA8CE730029FFF207B383EF3D0E045FB", hash_generated_method = "A635E6593D764E408387CF138EF61216")
    
public static final TrustManagerFactory getInstance(String algorithm, String provider)
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
     * Creates a new {@code TrustManagerFactory} instance for the specified
     * trust management algorithm from the specified provider.
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.794 -0500", hash_original_method = "949C075854D4042CB83122B74716FE40", hash_generated_method = "81DBBEE5CE37AFF2A5227CEB448DE6A8")
    
public static final TrustManagerFactory getInstance(String algorithm, Provider provider)
            throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new TrustManagerFactory((TrustManagerFactorySpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.778 -0500", hash_original_field = "F3654785F83CE2546FB02D2564DA64DE", hash_generated_field = "32B824317E2E7AE3C2672EA0BF3EE3F6")

    private static final String SERVICE = "TrustManagerFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.781 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.783 -0500", hash_original_field = "B1ED699CCE50980B82EB22A4D4859C50", hash_generated_field = "04A5913ADF56B6B4919B16CFB81F6A6C")

    private static final String PROPERTYNAME = "ssl.TrustManagerFactory.algorithm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.797 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.799 -0500", hash_original_field = "E0834D113D8E39D3D438F40AC3FE0CC0", hash_generated_field = "67A82D02C7DA28DAA4DC3F8908EABD14")

    private  TrustManagerFactorySpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.801 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code TrustManagerFactory} instance.
     *
     * @param factorySpi
     *            the implementation delegate.
     * @param provider
     *            the provider
     * @param algorithm
     *            the algorithm name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.804 -0500", hash_original_method = "81FA874689999FD0B2AD42BDFAAB958E", hash_generated_method = "9628A448CECD9C1DB0DA2065F7A029DC")
    
protected TrustManagerFactory(TrustManagerFactorySpi factorySpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = factorySpi;
    }

    /**
     * Returns the name of this {@code TrustManagerFactory} algorithm
     * implementation.
     *
     * @return the name of this {@code TrustManagerFactory} algorithm
     *         implementation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.807 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider for this {@code TrustManagerFactory} instance.
     *
     * @return the provider for this {@code TrustManagerFactory} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.809 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Initializes this factory instance with the specified keystore as source
     * of certificate authorities and trust material.
     *
     * @param ks
     *            the keystore or {@code null}.
     * @throws KeyStoreException
     *             if the initialization fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.811 -0500", hash_original_method = "1CCCB741740FE2D73909FD97A8BDB662", hash_generated_method = "FDF998D8D13F7B931F0040281BA3C263")
    
public final void init(KeyStore ks) throws KeyStoreException {
        spiImpl.engineInit(ks);
    }

    /**
     * Initializes this factory instance with the specified provider-specific
     * parameters for a source of trust material.
     *
     * @param spec
     *            the provider-specific parameters.
     * @throws InvalidAlgorithmParameterException
     *             if the initialization fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.813 -0500", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "CD3068A149CCD5B39C06926A2722E3EE")
    
public final void init(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(spec);
    }

    /**
     * Returns the list of {@code TrustManager}s with one entry for each type
     * of trust material.
     *
     * @return the list of {@code TrustManager}s
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.816 -0500", hash_original_method = "9A37AD00FB926A5C41BF7A3778BB3A49", hash_generated_method = "70BBD1A6BDB47F34912027230F26DDDE")
    
public final TrustManager[] getTrustManagers() {
        return spiImpl.engineGetTrustManagers();
    }
}

