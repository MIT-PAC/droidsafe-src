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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.355 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.355 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "67A82D02C7DA28DAA4DC3F8908EABD14")

    private TrustManagerFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.356 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.356 -0400", hash_original_method = "81FA874689999FD0B2AD42BDFAAB958E", hash_generated_method = "2D5C3C05CC2E3E097EAF8178DBC90951")
    protected  TrustManagerFactory(TrustManagerFactorySpi factorySpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = factorySpi;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.357 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "DAD2BF260734E3EE0C28D7C2CECAE178")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1231845311 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1231845311 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1231845311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1231845311;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.358 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "CE1F0225D7AB24FD28B3E7707D72FC6D")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_243257630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_243257630 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_243257630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_243257630;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.359 -0400", hash_original_method = "1CCCB741740FE2D73909FD97A8BDB662", hash_generated_method = "463B7A55E3947CE704DE2D9497361954")
    public final void init(KeyStore ks) throws KeyStoreException {
        spiImpl.engineInit(ks);
        addTaint(ks.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(ks);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.359 -0400", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "C3F1A9FB374E809B00D24B346DF858FD")
    public final void init(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(spec);
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(spec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.367 -0400", hash_original_method = "9A37AD00FB926A5C41BF7A3778BB3A49", hash_generated_method = "8A1C8576D96A2D80CC91B5E078DBD7D9")
    public final TrustManager[] getTrustManagers() {
        TrustManager[] varB4EAC82CA7396A68D541C85D26508E83_264397985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_264397985 = spiImpl.engineGetTrustManagers();
        varB4EAC82CA7396A68D541C85D26508E83_264397985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_264397985;
        // ---------- Original Method ----------
        //return spiImpl.engineGetTrustManagers();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.367 -0400", hash_original_field = "79D8D6233AF387675C88C124668A47A5", hash_generated_field = "C9043ED867666FC605DBCDCDD22FD0ED")

    private static String SERVICE = "TrustManagerFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.367 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.367 -0400", hash_original_field = "1AD9833D0DE170E73BE85775A2603A23", hash_generated_field = "805474BB8E4C155EA29D0D9E45F7D71B")

    private static String PROPERTYNAME = "ssl.TrustManagerFactory.algorithm";
}

