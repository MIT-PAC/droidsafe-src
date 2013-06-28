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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.187 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.187 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "79A1051781D270F714DE1FB341564966")

    private SecretKeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.187 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.187 -0400", hash_original_method = "3C76CE2839A142E4DF9C7001A6A7FCB1", hash_generated_method = "B27AD49FCAEADB0E1BFABD281B4FCF93")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.188 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "EF8FDE5614EBD235551AD3CC1BC8D26B")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_507236724 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_507236724 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_507236724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_507236724;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.188 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "810E5B31EB274A447913835411A0C7C7")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_720709691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_720709691 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_720709691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_720709691;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.189 -0400", hash_original_method = "F35C5482AA0FDE82A0C15F5E475C73A0", hash_generated_method = "8723FFBF458C83CD324FE0F368D1AD57")
    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_580416795 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_580416795 = spiImpl.engineGenerateSecret(keySpec);
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_580416795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_580416795;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.190 -0400", hash_original_method = "A1C05AB5848F28D95DBE9FF597A00F29", hash_generated_method = "3F6E4D6C8E216BA4F801BED4FD554AB4")
    @SuppressWarnings("unchecked")
    public final KeySpec getKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        KeySpec varB4EAC82CA7396A68D541C85D26508E83_1230568497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1230568497 = spiImpl.engineGetKeySpec(key, keySpec);
        addTaint(key.getTaint());
        addTaint(keySpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1230568497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230568497;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.191 -0400", hash_original_method = "DE7905EDF6B0EF2B9BB95373F14A9269", hash_generated_method = "33AA6001859AF72426ACD19DEF782413")
    public final SecretKey translateKey(SecretKey key) throws InvalidKeyException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_2009444594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2009444594 = spiImpl.engineTranslateKey(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2009444594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2009444594;
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.191 -0400", hash_original_field = "7F21E2ECB12B8BA88E2DF58C9B24D58A", hash_generated_field = "6E247A48EBB8DC98BDBEC2A4DB1C6ED9")

    private static final Engine ENGINE = new Engine("SecretKeyFactory");
}

