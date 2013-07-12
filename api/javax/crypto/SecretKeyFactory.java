package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.harmony.security.fortress.Engine;

public class SecretKeyFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.360 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.360 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "79A1051781D270F714DE1FB341564966")

    private SecretKeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.360 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.362 -0400", hash_original_method = "3C76CE2839A142E4DF9C7001A6A7FCB1", hash_generated_method = "B27AD49FCAEADB0E1BFABD281B4FCF93")
    protected  SecretKeyFactory(SecretKeyFactorySpi keyFacSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyFacSpi;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.362 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "AE0CB52FA27BC9088D273491FF1A9818")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_570839155 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_570839155.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_570839155;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.363 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "6649EC82AB335EF1E3147141BBBAC690")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_737224965 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_737224965.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_737224965;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.364 -0400", hash_original_method = "F35C5482AA0FDE82A0C15F5E475C73A0", hash_generated_method = "97ECB1C6A1084851257F84DC6ABC4130")
    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
SecretKey var3861BB99F9AC266732858E78F76FFBEA_1163962985 =         spiImpl.engineGenerateSecret(keySpec);
        var3861BB99F9AC266732858E78F76FFBEA_1163962985.addTaint(taint);
        return var3861BB99F9AC266732858E78F76FFBEA_1163962985;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.365 -0400", hash_original_method = "A1C05AB5848F28D95DBE9FF597A00F29", hash_generated_method = "BCB9D7F8FBA0F34DDEE960E07C9CFA30")
    @SuppressWarnings("unchecked")
    public final KeySpec getKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
        addTaint(key.getTaint());
KeySpec var8F4D81791C8180D9CBCF44423DBEC0F6_180357779 =         spiImpl.engineGetKeySpec(key, keySpec);
        var8F4D81791C8180D9CBCF44423DBEC0F6_180357779.addTaint(taint);
        return var8F4D81791C8180D9CBCF44423DBEC0F6_180357779;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.365 -0400", hash_original_method = "DE7905EDF6B0EF2B9BB95373F14A9269", hash_generated_method = "3E66A18DFE12F8AA14B453CD3C5EF3AB")
    public final SecretKey translateKey(SecretKey key) throws InvalidKeyException {
        addTaint(key.getTaint());
SecretKey var5A62A18468446B86D5F9E15687E1B90C_1428507850 =         spiImpl.engineTranslateKey(key);
        var5A62A18468446B86D5F9E15687E1B90C_1428507850.addTaint(taint);
        return var5A62A18468446B86D5F9E15687E1B90C_1428507850;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.365 -0400", hash_original_field = "7F21E2ECB12B8BA88E2DF58C9B24D58A", hash_generated_field = "6E247A48EBB8DC98BDBEC2A4DB1C6ED9")

    private static final Engine ENGINE = new Engine("SecretKeyFactory");
}

