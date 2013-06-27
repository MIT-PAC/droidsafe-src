package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.harmony.security.fortress.Engine;

public class SecretKeyFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.895 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.895 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "79A1051781D270F714DE1FB341564966")

    private SecretKeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.895 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.903 -0400", hash_original_method = "3C76CE2839A142E4DF9C7001A6A7FCB1", hash_generated_method = "B27AD49FCAEADB0E1BFABD281B4FCF93")
    protected  SecretKeyFactory(SecretKeyFactorySpi keyFacSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyFacSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = keyFacSpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.904 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "257B5CD837362DD7AC05DAE8240F26E9")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1240520500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1240520500 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1240520500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1240520500;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.908 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "F4480290069D933BB07CB1C8E579A8BA")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_87162870 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_87162870 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_87162870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87162870;
        // ---------- Original Method ----------
        //return provider;
    }

    
        public static final SecretKeyFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new SecretKeyFactory((SecretKeyFactorySpi) sap.spi, sap.provider, algorithm);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.927 -0400", hash_original_method = "F35C5482AA0FDE82A0C15F5E475C73A0", hash_generated_method = "9B1446451C74A6D033DB4946EEBBF0D7")
    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_623212308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_623212308 = spiImpl.engineGenerateSecret(keySpec);
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_623212308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_623212308;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.928 -0400", hash_original_method = "A1C05AB5848F28D95DBE9FF597A00F29", hash_generated_method = "1D4BCA5ED35B17C75A5A3107B97BFBE1")
    @SuppressWarnings("unchecked")
    public final KeySpec getKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        KeySpec varB4EAC82CA7396A68D541C85D26508E83_964415200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_964415200 = spiImpl.engineGetKeySpec(key, keySpec);
        addTaint(key.getTaint());
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_964415200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964415200;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.929 -0400", hash_original_method = "DE7905EDF6B0EF2B9BB95373F14A9269", hash_generated_method = "9FB4265341A882258785799A82EC52AB")
    public final SecretKey translateKey(SecretKey key) throws InvalidKeyException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_1994719731 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1994719731 = spiImpl.engineTranslateKey(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1994719731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994719731;
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.929 -0400", hash_original_field = "7F21E2ECB12B8BA88E2DF58C9B24D58A", hash_generated_field = "B691EA12EBC633655BEE85D2FDC1B0CA")

    private static Engine ENGINE = new Engine("SecretKeyFactory");
}

