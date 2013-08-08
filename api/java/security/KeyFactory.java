package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import org.apache.harmony.security.fortress.Engine;






public class KeyFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.893 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.893 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "CA0FD322067E5C95477D77E0231B374A")

    private KeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.893 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.894 -0400", hash_original_method = "8C178BBFD1FCE7A7C88CEB58B900756B", hash_generated_method = "3407D7ACC3A5FF64588D5A45D63E15AB")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.896 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "6E55E4006EBE02521B404F83AF94BF7A")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_410944347 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_410944347.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_410944347;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.896 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "E75948D8CCD6CEB50418C5FA5E54CB98")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1637404213 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1637404213.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1637404213;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.897 -0400", hash_original_method = "D16F4EDBCE8E03F680EB7C937E0DCCC9", hash_generated_method = "DA067B39DEDDEE40DACBE429062F34EB")
    public final PublicKey generatePublic(KeySpec keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
PublicKey var5E879E50CE0F0CDD91A45B72CABFD196_1788748134 =         spiImpl.engineGeneratePublic(keySpec);
        var5E879E50CE0F0CDD91A45B72CABFD196_1788748134.addTaint(taint);
        return var5E879E50CE0F0CDD91A45B72CABFD196_1788748134;
        // ---------- Original Method ----------
        //return spiImpl.engineGeneratePublic(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.897 -0400", hash_original_method = "56D108179E38B3C9859C6FCAEB589129", hash_generated_method = "2EF1D179CA225611E4E6B3E6B281AF81")
    public final PrivateKey generatePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
PrivateKey var3A6E9948BD01B3D0F48394C49C404E2F_434179085 =         spiImpl.engineGeneratePrivate(keySpec);
        var3A6E9948BD01B3D0F48394C49C404E2F_434179085.addTaint(taint);
        return var3A6E9948BD01B3D0F48394C49C404E2F_434179085;
        // ---------- Original Method ----------
        //return spiImpl.engineGeneratePrivate(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.898 -0400", hash_original_method = "7B77F80B2A4A2C9E7EABE7EB820F4781", hash_generated_method = "2C9D88F6A5AEBE43B5C8DFAB3749E023")
    public final <T extends KeySpec> T getKeySpec(Key key,
                                    Class<T> keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
        addTaint(key.getTaint());
T var8F4D81791C8180D9CBCF44423DBEC0F6_77754240 =         spiImpl.engineGetKeySpec(key, keySpec);
        var8F4D81791C8180D9CBCF44423DBEC0F6_77754240.addTaint(taint);
        return var8F4D81791C8180D9CBCF44423DBEC0F6_77754240;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.898 -0400", hash_original_method = "23F9E5F6A6B9FC183E94A65D97880068", hash_generated_method = "857D7400C29CE7FE9B4349AD8D460396")
    public final Key translateKey(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
Key var5A62A18468446B86D5F9E15687E1B90C_112278889 =         spiImpl.engineTranslateKey(key);
        var5A62A18468446B86D5F9E15687E1B90C_112278889.addTaint(taint);
        return var5A62A18468446B86D5F9E15687E1B90C_112278889;
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.898 -0400", hash_original_field = "B53E76D76B9539E1091DC3F22EA2C1E8", hash_generated_field = "24EFDD4E9206D29CCB161FC64C16C64A")

    private static final String SERVICE = "KeyFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.898 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
}

