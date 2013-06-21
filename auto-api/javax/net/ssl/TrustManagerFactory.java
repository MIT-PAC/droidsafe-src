package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

public class TrustManagerFactory {
    private Provider provider;
    private TrustManagerFactorySpi spiImpl;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.116 -0400", hash_original_method = "81FA874689999FD0B2AD42BDFAAB958E", hash_generated_method = "57EA7C39D3474390ED00E273CF328240")
    @DSModeled(DSC.SAFE)
    protected TrustManagerFactory(TrustManagerFactorySpi factorySpi, Provider provider,
            String algorithm) {
        dsTaint.addTaint(factorySpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = factorySpi;
    }

    
        public static final String getDefaultAlgorithm() {
        return Security.getProperty(PROPERTYNAME);
    }

    
        public static final TrustManagerFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new TrustManagerFactory((TrustManagerFactorySpi) sap.spi, sap.provider, algorithm);
    }

    
        public static final TrustManagerFactory getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if ((provider == null) || (provider.length() == 0)) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
        public static final TrustManagerFactory getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new TrustManagerFactory((TrustManagerFactorySpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.118 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.118 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.118 -0400", hash_original_method = "1CCCB741740FE2D73909FD97A8BDB662", hash_generated_method = "4209BBD6D08ADBE4B2B704716402C69D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(KeyStore ks) throws KeyStoreException {
        dsTaint.addTaint(ks.dsTaint);
        spiImpl.engineInit(ks);
        // ---------- Original Method ----------
        //spiImpl.engineInit(ks);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.118 -0400", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "0DAC6470F94627FFC7E5F7EB31F72C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(spec.dsTaint);
        spiImpl.engineInit(spec);
        // ---------- Original Method ----------
        //spiImpl.engineInit(spec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.119 -0400", hash_original_method = "9A37AD00FB926A5C41BF7A3778BB3A49", hash_generated_method = "0BF7523F3120F49182E2F906213E14B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TrustManager[] getTrustManagers() {
        TrustManager[] var2880F0CEF093B4840CCB83C9CDC8DE24_962849931 = (spiImpl.engineGetTrustManagers());
        return (TrustManager[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetTrustManagers();
    }

    
    private static final String SERVICE = "TrustManagerFactory";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final String PROPERTYNAME = "ssl.TrustManagerFactory.algorithm";
}

