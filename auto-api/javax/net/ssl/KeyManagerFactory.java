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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.520 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.520 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "66956FA0EC6E90989FDF6ECA22799199")

    private KeyManagerFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.520 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.520 -0400", hash_original_method = "70F84550962AE46163866D0A34314F54", hash_generated_method = "5C23709F478D6E8DB18309E3BC6E3412")
    protected  KeyManagerFactory(KeyManagerFactorySpi factorySpi, Provider provider,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.522 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "21597F5401A47CD8615818BEA33E0BCB")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1602227758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1602227758 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1602227758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1602227758;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.522 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "133235291F0AF6B0867E5A5693A6A7CE")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1555371857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1555371857 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1555371857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1555371857;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.522 -0400", hash_original_method = "4FB19D2B9D9DA541468809C3D1BCD49A", hash_generated_method = "880D8BDF513653C14CD120FEA036C6FA")
    public final void init(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException {
        spiImpl.engineInit(ks, password);
        addTaint(ks.getTaint());
        addTaint(password[0]);
        // ---------- Original Method ----------
        //spiImpl.engineInit(ks, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.537 -0400", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "C3F1A9FB374E809B00D24B346DF858FD")
    public final void init(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(spec);
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(spec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.539 -0400", hash_original_method = "B9A1EAEE9A7433E4D131EF6C1483617B", hash_generated_method = "9FF647528EBF61F5ED0B844C74C177BA")
    public final KeyManager[] getKeyManagers() {
        KeyManager[] varB4EAC82CA7396A68D541C85D26508E83_2089210766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2089210766 = spiImpl.engineGetKeyManagers();
        varB4EAC82CA7396A68D541C85D26508E83_2089210766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2089210766;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeyManagers();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.539 -0400", hash_original_field = "B523D7CACD97A95D3A027A66B5B1FC09", hash_generated_field = "DB8321332FBA82D496C4A88968DE5E9A")

    private static String SERVICE = "KeyManagerFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.539 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.539 -0400", hash_original_field = "1C1253A0AF67FF4DEB3E6B71E8A225D4", hash_generated_field = "015E8B54D57BD6B205FE0EAA19E91826")

    private static String PROPERTY_NAME = "ssl.KeyManagerFactory.algorithm";
}

