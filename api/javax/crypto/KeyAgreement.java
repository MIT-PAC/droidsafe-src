package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.209 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.209 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "7AE48DE8A3744D2D52151DAA301986BC")

    private KeyAgreementSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.209 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.209 -0400", hash_original_method = "0900837118FEE4DAFDEFCB258925423D", hash_generated_method = "BE6FD806775D52D1C521D5CA2E7D117E")
    protected  KeyAgreement(KeyAgreementSpi keyAgreeSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyAgreeSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = keyAgreeSpi;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.210 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "2916234D4716AAC353BA86F2185D0DF4")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1630062590 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1630062590.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1630062590;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.210 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "153DCC04C3AE423B76B7AC52B466D792")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_296691054 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_296691054.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_296691054;
        // ---------- Original Method ----------
        //return provider;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.212 -0400", hash_original_method = "D4F5C8E3486A3AF707B3A0052AE97F9F", hash_generated_method = "2738EE57D3A0CA62DF6A4E9E5D57E7E3")
    public final void init(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        spiImpl.engineInit(key, RANDOM);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.212 -0400", hash_original_method = "B560CE194C80427D06320AB3301AD531", hash_generated_method = "54298711A73E3C566F7646B334A4EDD3")
    public final void init(Key key, SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(key.getTaint());
        spiImpl.engineInit(key, random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.213 -0400", hash_original_method = "45385F3B8A57987C5A6F500929E2FE45", hash_generated_method = "058D84EE40C0C868FD6BA6562757C734")
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        spiImpl.engineInit(key, params, RANDOM);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, params, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.213 -0400", hash_original_method = "04B90A53EC2A8EFB98D3E5D98D18DD54", hash_generated_method = "494B430C7BF4E6433ACD30AC4B833BAC")
    public final void init(Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        spiImpl.engineInit(key, params, random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, params, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.214 -0400", hash_original_method = "BB12C4D69D38F4161821D54CA8CAAD00", hash_generated_method = "40DBB9DFE93002B562A01AB23E8939E1")
    public final Key doPhase(Key key, boolean lastPhase) throws InvalidKeyException, IllegalStateException {
        addTaint(lastPhase);
        addTaint(key.getTaint());
Key varB62898BED1697BBBFDF7E5E5CA1F56DF_1303043209 =         spiImpl.engineDoPhase(key, lastPhase);
        varB62898BED1697BBBFDF7E5E5CA1F56DF_1303043209.addTaint(taint);
        return varB62898BED1697BBBFDF7E5E5CA1F56DF_1303043209;
        // ---------- Original Method ----------
        //return spiImpl.engineDoPhase(key, lastPhase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.214 -0400", hash_original_method = "A2824ED5DB0FCCB2C192A225E52EA88C", hash_generated_method = "F57F86D750835A564BDB2ADC53913023")
    public final byte[] generateSecret() throws IllegalStateException {
        byte[] varD6D437FCE0CD160B5DC1C3574E8E0598_725095147 = (spiImpl.engineGenerateSecret());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1746666200 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1746666200;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.214 -0400", hash_original_method = "7B919BB67435CAC1AF727C4D009370B1", hash_generated_method = "334301357DB210C451BF36609AB206A5")
    public final int generateSecret(byte[] sharedSecret, int offset) throws IllegalStateException, ShortBufferException {
        addTaint(offset);
        addTaint(sharedSecret[0]);
        int varC3C648AD799297422873F27AADD5E7D3_1997470380 = (spiImpl.engineGenerateSecret(sharedSecret, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198132892 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198132892;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(sharedSecret, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.215 -0400", hash_original_method = "0E820F09DB891E9F2C0C31F49AA44F05", hash_generated_method = "306835A4BC508266D387AFA0B21C5417")
    public final SecretKey generateSecret(String algorithm) throws IllegalStateException, NoSuchAlgorithmException,
            InvalidKeyException {
        addTaint(algorithm.getTaint());
SecretKey var17EFC49D73EE8712B77591CBAACDA6A4_1017526657 =         spiImpl.engineGenerateSecret(algorithm);
        var17EFC49D73EE8712B77591CBAACDA6A4_1017526657.addTaint(taint);
        return var17EFC49D73EE8712B77591CBAACDA6A4_1017526657;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(algorithm);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.215 -0400", hash_original_field = "5C827DA0251DEB12ED9F2D33FC9D2FA6", hash_generated_field = "13EC579A2F79ADB4E1474BB593ACB93B")

    private static final Engine ENGINE = new Engine("KeyAgreement");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.215 -0400", hash_original_field = "9AE708A2321B1D064045F8FC9B284C5C", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
}

