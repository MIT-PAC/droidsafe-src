package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

public class KeyGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.174 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.174 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "062ACE2CCE472120F5290B09DE19D1CD")

    private KeyGeneratorSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.174 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.175 -0400", hash_original_method = "CDE5B5D4C1159ABF8B3201BF166F4FB3", hash_generated_method = "C1D3A09E78029A99A573BDB52F727B3D")
    protected  KeyGenerator(KeyGeneratorSpi keyGenSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyGenSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = keyGenSpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.175 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "C54E08098643A5D16943C4477138BDE9")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_918605177 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_918605177 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_918605177.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_918605177;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.196 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "8B0ED2781BE91126BE97CE346ADD0184")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1622676454 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1622676454 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1622676454.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1622676454;
        // ---------- Original Method ----------
        //return provider;
    }

    
        public static final KeyGenerator getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyGenerator((KeyGeneratorSpi) sap.spi, sap.provider, algorithm);
    }

    
        public static final KeyGenerator getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
        public static final KeyGenerator getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyGenerator((KeyGeneratorSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.197 -0400", hash_original_method = "0D649746A13B62933617343FF6CF66A5", hash_generated_method = "96673297B65C8B72291D7C1C502AAF2C")
    public final SecretKey generateKey() {
        SecretKey varB4EAC82CA7396A68D541C85D26508E83_101554835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_101554835 = spiImpl.engineGenerateKey();
        varB4EAC82CA7396A68D541C85D26508E83_101554835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_101554835;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.198 -0400", hash_original_method = "17294700B35C898F2BBCFAFBE5495088", hash_generated_method = "C5CCB594359EEC484476CFFC9A769137")
    public final void init(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(params, RANDOM);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(params, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.198 -0400", hash_original_method = "EA2F3DD217CBA336387110AFDED2F185", hash_generated_method = "6AE8F9B2B3A5BC2E4EA848D56AA28BC6")
    public final void init(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(params, random);
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(params, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.210 -0400", hash_original_method = "6A1F56561EFECC925D99D4402BD46267", hash_generated_method = "FFB3B1891E13FA0474D4BC7F88ED83E4")
    public final void init(int keysize) {
        spiImpl.engineInit(keysize, RANDOM);
        addTaint(keysize);
        // ---------- Original Method ----------
        //spiImpl.engineInit(keysize, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.210 -0400", hash_original_method = "CF9BC038E48C7FD5928A7551030B0A46", hash_generated_method = "1BF507580C86D99EC98F57F166DDDC9F")
    public final void init(int keysize, SecureRandom random) {
        spiImpl.engineInit(keysize, random);
        addTaint(keysize);
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(keysize, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.211 -0400", hash_original_method = "E0B65F149BDE3033A715A5DC9A4C8256", hash_generated_method = "B1AD01FF3E3EC3A159600AAD9C17B58F")
    public final void init(SecureRandom random) {
        spiImpl.engineInit(random);
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(random);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.211 -0400", hash_original_field = "29AE157B38F3DDC8818475091B725813", hash_generated_field = "88D86B0568C87F66C44D2F86CCAEFF20")

    private static Engine ENGINE = new Engine("KeyGenerator");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.211 -0400", hash_original_field = "9AE708A2321B1D064045F8FC9B284C5C", hash_generated_field = "473A20CDE6EFEE7D42F595BA5492FFB7")

    private static SecureRandom RANDOM = new SecureRandom();
}

