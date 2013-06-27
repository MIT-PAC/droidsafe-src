package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.harmony.security.fortress.Engine;

public class KeyFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.199 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.199 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "CA0FD322067E5C95477D77E0231B374A")

    private KeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.199 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.217 -0400", hash_original_method = "8C178BBFD1FCE7A7C88CEB58B900756B", hash_generated_method = "3407D7ACC3A5FF64588D5A45D63E15AB")
    protected  KeyFactory(KeyFactorySpi keyFacSpi,
                         Provider provider,
                         String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyFacSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = keyFacSpi;
    }

    
        public static KeyFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyFactory((KeyFactorySpi) sap.spi, sap.provider, algorithm);
    }

    
        public static KeyFactory getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    
        public static KeyFactory getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyFactory((KeyFactorySpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.218 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "BE8C0E68F659102BED81B461235B7020")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_4229259 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_4229259 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_4229259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_4229259;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.219 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "7EB3EFE964B67F4862C60E4435644225")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1415052924 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1415052924 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1415052924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1415052924;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.219 -0400", hash_original_method = "D16F4EDBCE8E03F680EB7C937E0DCCC9", hash_generated_method = "3D5D6D2542103CBC5896AF79F0BE69F4")
    public final PublicKey generatePublic(KeySpec keySpec) throws InvalidKeySpecException {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_873360463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_873360463 = spiImpl.engineGeneratePublic(keySpec);
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_873360463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873360463;
        // ---------- Original Method ----------
        //return spiImpl.engineGeneratePublic(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.220 -0400", hash_original_method = "56D108179E38B3C9859C6FCAEB589129", hash_generated_method = "8E9464525054E53D8689DE06FB4B7671")
    public final PrivateKey generatePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        PrivateKey varB4EAC82CA7396A68D541C85D26508E83_439320270 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_439320270 = spiImpl.engineGeneratePrivate(keySpec);
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_439320270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439320270;
        // ---------- Original Method ----------
        //return spiImpl.engineGeneratePrivate(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.237 -0400", hash_original_method = "7B77F80B2A4A2C9E7EABE7EB820F4781", hash_generated_method = "66BB716D59018D5AE41221B1BB629164")
    public final <T extends KeySpec> T getKeySpec(Key key,
                                    Class<T> keySpec) throws InvalidKeySpecException {
        T varB4EAC82CA7396A68D541C85D26508E83_2133015106 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2133015106 = spiImpl.engineGetKeySpec(key, keySpec);
        addTaint(key.getTaint());
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2133015106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2133015106;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.237 -0400", hash_original_method = "23F9E5F6A6B9FC183E94A65D97880068", hash_generated_method = "C0391C13116596B9B81F5AA1439DDD7C")
    public final Key translateKey(Key key) throws InvalidKeyException {
        Key varB4EAC82CA7396A68D541C85D26508E83_1552167182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1552167182 = spiImpl.engineTranslateKey(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1552167182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1552167182;
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.237 -0400", hash_original_field = "B53E76D76B9539E1091DC3F22EA2C1E8", hash_generated_field = "6EF6548704601C691CB685AAD2CDCE1F")

    private static String SERVICE = "KeyFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.237 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
}

