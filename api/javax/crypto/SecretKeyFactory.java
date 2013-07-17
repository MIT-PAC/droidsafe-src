package javax.crypto;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.310 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.310 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "79A1051781D270F714DE1FB341564966")

    private SecretKeyFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.311 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.313 -0400", hash_original_method = "3C76CE2839A142E4DF9C7001A6A7FCB1", hash_generated_method = "B27AD49FCAEADB0E1BFABD281B4FCF93")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.314 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "B33FFEC4B0B12187CE31235F832326D0")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1210439744 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1210439744.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1210439744;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.314 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "BF822E2B024E7C06BA902685EC33B8EF")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_356439642 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_356439642.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_356439642;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.317 -0400", hash_original_method = "F35C5482AA0FDE82A0C15F5E475C73A0", hash_generated_method = "0EF542D9EF5BC3F8E83C4A1BB1712CB8")
    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
SecretKey var3861BB99F9AC266732858E78F76FFBEA_168255324 =         spiImpl.engineGenerateSecret(keySpec);
        var3861BB99F9AC266732858E78F76FFBEA_168255324.addTaint(taint);
        return var3861BB99F9AC266732858E78F76FFBEA_168255324;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.318 -0400", hash_original_method = "A1C05AB5848F28D95DBE9FF597A00F29", hash_generated_method = "F7861466A837C6498169DE47724BC7DB")
    @SuppressWarnings("unchecked")
    public final KeySpec getKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        addTaint(keySpec.getTaint());
        addTaint(key.getTaint());
KeySpec var8F4D81791C8180D9CBCF44423DBEC0F6_1207074692 =         spiImpl.engineGetKeySpec(key, keySpec);
        var8F4D81791C8180D9CBCF44423DBEC0F6_1207074692.addTaint(taint);
        return var8F4D81791C8180D9CBCF44423DBEC0F6_1207074692;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.318 -0400", hash_original_method = "DE7905EDF6B0EF2B9BB95373F14A9269", hash_generated_method = "E681CE47F793B35BB7CD8F5AB43182A9")
    public final SecretKey translateKey(SecretKey key) throws InvalidKeyException {
        addTaint(key.getTaint());
SecretKey var5A62A18468446B86D5F9E15687E1B90C_272760878 =         spiImpl.engineTranslateKey(key);
        var5A62A18468446B86D5F9E15687E1B90C_272760878.addTaint(taint);
        return var5A62A18468446B86D5F9E15687E1B90C_272760878;
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.318 -0400", hash_original_field = "7F21E2ECB12B8BA88E2DF58C9B24D58A", hash_generated_field = "6E247A48EBB8DC98BDBEC2A4DB1C6ED9")

    private static final Engine ENGINE = new Engine("SecretKeyFactory");
}

