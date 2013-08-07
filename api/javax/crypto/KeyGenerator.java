package javax.crypto;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.harmony.security.fortress.Engine;






public class KeyGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.227 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.227 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "062ACE2CCE472120F5290B09DE19D1CD")

    private KeyGeneratorSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.227 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.228 -0400", hash_original_method = "CDE5B5D4C1159ABF8B3201BF166F4FB3", hash_generated_method = "C1D3A09E78029A99A573BDB52F727B3D")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.229 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "3FC927181BC34D86B617F04EAEB11BB9")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1936670887 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1936670887.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1936670887;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.229 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "62C896E6D7DAE75725EF4948D941FF5D")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_859127114 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_859127114.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_859127114;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.230 -0400", hash_original_method = "0D649746A13B62933617343FF6CF66A5", hash_generated_method = "E762451BF7D4533A9AC0E381FB951C2E")
    public final SecretKey generateKey() {
SecretKey var04457856BF7B8B913E518C25CAF747D7_1364054525 =         spiImpl.engineGenerateKey();
        var04457856BF7B8B913E518C25CAF747D7_1364054525.addTaint(taint);
        return var04457856BF7B8B913E518C25CAF747D7_1364054525;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.230 -0400", hash_original_method = "17294700B35C898F2BBCFAFBE5495088", hash_generated_method = "151AD8CE99BCD6170849BA7DAF24FFCE")
    public final void init(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        spiImpl.engineInit(params, RANDOM);
        // ---------- Original Method ----------
        //spiImpl.engineInit(params, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.231 -0400", hash_original_method = "EA2F3DD217CBA336387110AFDED2F185", hash_generated_method = "4FE66B8FE0F3351B93E523D8192CBA85")
    public final void init(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        spiImpl.engineInit(params, random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(params, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.231 -0400", hash_original_method = "6A1F56561EFECC925D99D4402BD46267", hash_generated_method = "96DD3488C617B60A55C2BF79B7E31CDE")
    public final void init(int keysize) {
        addTaint(keysize);
        spiImpl.engineInit(keysize, RANDOM);
        // ---------- Original Method ----------
        //spiImpl.engineInit(keysize, RANDOM);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.231 -0400", hash_original_method = "CF9BC038E48C7FD5928A7551030B0A46", hash_generated_method = "6B3CD5398CFBAACC1F4C7B9A381E92AC")
    public final void init(int keysize, SecureRandom random) {
        addTaint(random.getTaint());
        addTaint(keysize);
        spiImpl.engineInit(keysize, random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(keysize, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.231 -0400", hash_original_method = "E0B65F149BDE3033A715A5DC9A4C8256", hash_generated_method = "ED1DDC5161924C8D115C0DFA49BEB934")
    public final void init(SecureRandom random) {
        addTaint(random.getTaint());
        spiImpl.engineInit(random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(random);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.231 -0400", hash_original_field = "29AE157B38F3DDC8818475091B725813", hash_generated_field = "94DDEF4E1FF385576E6D52DD87DBDCAD")

    private static final Engine ENGINE = new Engine("KeyGenerator");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.231 -0400", hash_original_field = "9AE708A2321B1D064045F8FC9B284C5C", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
}

