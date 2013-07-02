package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

public class KeyAgreement {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.078 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.078 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "7AE48DE8A3744D2D52151DAA301986BC")

    private KeyAgreementSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.078 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.079 -0400", hash_original_method = "0900837118FEE4DAFDEFCB258925423D", hash_generated_method = "BE6FD806775D52D1C521D5CA2E7D117E")
    protected  KeyAgreement(KeyAgreementSpi keyAgreeSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyAgreeSpi;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.079 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8FF8C1A065699CB3E203AA97D3047581")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_504796002 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_504796002 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_504796002.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_504796002;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.080 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "16ACFB74A5384B172686524D20E46B4E")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_777289513 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_777289513 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_777289513.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_777289513;
        
        
    }

    
    public static final KeyAgreement getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyAgreement((KeyAgreementSpi) sap.spi, sap.provider, algorithm);
    }

    
    public static final KeyAgreement getInstance(String algorithm,
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

    
    public static final KeyAgreement getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyAgreement((KeyAgreementSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.082 -0400", hash_original_method = "D4F5C8E3486A3AF707B3A0052AE97F9F", hash_generated_method = "0AF9243355FF3CD91E0A40F03141E674")
    public final void init(Key key) throws InvalidKeyException {
        spiImpl.engineInit(key, RANDOM);
        addTaint(key.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.082 -0400", hash_original_method = "B560CE194C80427D06320AB3301AD531", hash_generated_method = "34AFB2BD7A6B0ACE4266AF02A86126B5")
    public final void init(Key key, SecureRandom random) throws InvalidKeyException {
        spiImpl.engineInit(key, random);
        addTaint(key.getTaint());
        addTaint(random.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.083 -0400", hash_original_method = "45385F3B8A57987C5A6F500929E2FE45", hash_generated_method = "8B5B74CC22D068D216F36A3B382C5A34")
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        spiImpl.engineInit(key, params, RANDOM);
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.083 -0400", hash_original_method = "04B90A53EC2A8EFB98D3E5D98D18DD54", hash_generated_method = "168CFC2053A2949530455AA3D11AE1F2")
    public final void init(Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        spiImpl.engineInit(key, params, random);
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.085 -0400", hash_original_method = "BB12C4D69D38F4161821D54CA8CAAD00", hash_generated_method = "F90060EB87FAED8FB4003816300913B5")
    public final Key doPhase(Key key, boolean lastPhase) throws InvalidKeyException, IllegalStateException {
        Key varB4EAC82CA7396A68D541C85D26508E83_1931756607 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1931756607 = spiImpl.engineDoPhase(key, lastPhase);
        addTaint(key.getTaint());
        addTaint(lastPhase);
        varB4EAC82CA7396A68D541C85D26508E83_1931756607.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1931756607;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.086 -0400", hash_original_method = "A2824ED5DB0FCCB2C192A225E52EA88C", hash_generated_method = "EA1CF9C18A348C2D194108F895240EF0")
    public final byte[] generateSecret() throws IllegalStateException {
        byte[] varA8BB6E6E942BEB9835A7817272D04164_1531619103 = (spiImpl.engineGenerateSecret());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1358453015 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1358453015;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.086 -0400", hash_original_method = "7B919BB67435CAC1AF727C4D009370B1", hash_generated_method = "967B3B9F898B1DC5CF2692BAB7DE878A")
    public final int generateSecret(byte[] sharedSecret, int offset) throws IllegalStateException, ShortBufferException {
        int varABD732903B431C7D9F1A169C9C636E3D_1127655290 = (spiImpl.engineGenerateSecret(sharedSecret, offset));
        addTaint(sharedSecret[0]);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329854210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329854210;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.087 -0400", hash_original_method = "0E820F09DB891E9F2C0C31F49AA44F05", hash_generated_method = "802746EBDFB85D065C92A2AF18ED4FD4")
    public final SecretKey generateSecret(String algorithm) throws IllegalStateException, NoSuchAlgorithmException,
            InvalidKeyException {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_1940585500 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1940585500 = spiImpl.engineGenerateSecret(algorithm);
        addTaint(algorithm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1940585500.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1940585500;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.087 -0400", hash_original_field = "5C827DA0251DEB12ED9F2D33FC9D2FA6", hash_generated_field = "13EC579A2F79ADB4E1474BB593ACB93B")

    private static final Engine ENGINE = new Engine("KeyAgreement");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.087 -0400", hash_original_field = "9AE708A2321B1D064045F8FC9B284C5C", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
}

