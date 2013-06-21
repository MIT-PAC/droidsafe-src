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
import java.security.UnrecoverableKeyException;
import org.apache.harmony.security.fortress.Engine;

public class KeyManagerFactory {
    private Provider provider;
    private KeyManagerFactorySpi spiImpl;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.061 -0400", hash_original_method = "70F84550962AE46163866D0A34314F54", hash_generated_method = "E6763F4ADE8260D51A7BB84392B6348E")
    @DSModeled(DSC.SAFE)
    protected KeyManagerFactory(KeyManagerFactorySpi factorySpi, Provider provider,
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
        return Security.getProperty(PROPERTY_NAME);
    }

    
        public static final KeyManagerFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyManagerFactory((KeyManagerFactorySpi) sap.spi, sap.provider, algorithm);
    }

    
        public static final KeyManagerFactory getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if ((provider == null) || (provider.length() == 0)) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
        public static final KeyManagerFactory getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyManagerFactory((KeyManagerFactorySpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.061 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.062 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.062 -0400", hash_original_method = "4FB19D2B9D9DA541468809C3D1BCD49A", hash_generated_method = "23AD729E33A16509080BFEFBC7BDC69C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException {
        dsTaint.addTaint(ks.dsTaint);
        dsTaint.addTaint(password[0]);
        spiImpl.engineInit(ks, password);
        // ---------- Original Method ----------
        //spiImpl.engineInit(ks, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.063 -0400", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "0DAC6470F94627FFC7E5F7EB31F72C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(spec.dsTaint);
        spiImpl.engineInit(spec);
        // ---------- Original Method ----------
        //spiImpl.engineInit(spec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.063 -0400", hash_original_method = "B9A1EAEE9A7433E4D131EF6C1483617B", hash_generated_method = "C829C7A2635CC7F4D253643E1ECF357C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final KeyManager[] getKeyManagers() {
        KeyManager[] varB72ADCFB484A82B8BBBC4EEA1BF79226_1682926410 = (spiImpl.engineGetKeyManagers());
        return (KeyManager[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeyManagers();
    }

    
    private static final String SERVICE = "KeyManagerFactory";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final String PROPERTY_NAME = "ssl.KeyManagerFactory.algorithm";
}

