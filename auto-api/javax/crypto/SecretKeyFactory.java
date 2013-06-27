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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.230 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.230 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "79A1051781D270F714DE1FB341564966")

    private SecretKeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.230 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.251 -0400", hash_original_method = "3C76CE2839A142E4DF9C7001A6A7FCB1", hash_generated_method = "B27AD49FCAEADB0E1BFABD281B4FCF93")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.252 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "12EF7CC9FB8E4A30F48EAF08A4ED1D27")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1021366506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1021366506 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1021366506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1021366506;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.252 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "F4997948077268D0AC7B175061890E6E")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_183107654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_183107654 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_183107654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183107654;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.254 -0400", hash_original_method = "F35C5482AA0FDE82A0C15F5E475C73A0", hash_generated_method = "9D1A18615E0EA82625910EA5EDB9BB68")
    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_444973552 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_444973552 = spiImpl.engineGenerateSecret(keySpec);
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_444973552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_444973552;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.254 -0400", hash_original_method = "A1C05AB5848F28D95DBE9FF597A00F29", hash_generated_method = "4451285DA262282838E7D48681FB5DB9")
    @SuppressWarnings("unchecked")
    public final KeySpec getKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        KeySpec varB4EAC82CA7396A68D541C85D26508E83_1396061941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1396061941 = spiImpl.engineGetKeySpec(key, keySpec);
        addTaint(key.getTaint());
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1396061941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1396061941;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.255 -0400", hash_original_method = "DE7905EDF6B0EF2B9BB95373F14A9269", hash_generated_method = "DFF7F16C8BDA3C6B6BDCD3F4AD62EEC0")
    public final SecretKey translateKey(SecretKey key) throws InvalidKeyException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_960895743 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_960895743 = spiImpl.engineTranslateKey(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_960895743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_960895743;
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.255 -0400", hash_original_field = "7F21E2ECB12B8BA88E2DF58C9B24D58A", hash_generated_field = "B691EA12EBC633655BEE85D2FDC1B0CA")

    private static Engine ENGINE = new Engine("SecretKeyFactory");
}

