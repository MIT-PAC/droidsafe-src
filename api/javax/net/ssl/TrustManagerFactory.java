package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

public class TrustManagerFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.985 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.985 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "67A82D02C7DA28DAA4DC3F8908EABD14")

    private TrustManagerFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.985 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.986 -0400", hash_original_method = "81FA874689999FD0B2AD42BDFAAB958E", hash_generated_method = "2D5C3C05CC2E3E097EAF8178DBC90951")
    protected  TrustManagerFactory(TrustManagerFactorySpi factorySpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = factorySpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = factorySpi;
    }

    
        public static final String getDefaultAlgorithm() {
        return Security.getProperty(PROPERTYNAME);
    }

    
        public static final TrustManagerFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new TrustManagerFactory((TrustManagerFactorySpi) sap.spi, sap.provider, algorithm);
    }

    
        public static final TrustManagerFactory getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if ((provider == null) || (provider.length() == 0)) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
        public static final TrustManagerFactory getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new TrustManagerFactory((TrustManagerFactorySpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.987 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "3BAAC72C679B7DDBC94513C0BB930AA9")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1155640350 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1155640350.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1155640350;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.987 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "2D2C11325B2E2F02F3820A58B71EFC14")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_2042764614 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_2042764614.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_2042764614;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.988 -0400", hash_original_method = "1CCCB741740FE2D73909FD97A8BDB662", hash_generated_method = "5A0769B251699DA4A7936857E97932CE")
    public final void init(KeyStore ks) throws KeyStoreException {
        addTaint(ks.getTaint());
        spiImpl.engineInit(ks);
        // ---------- Original Method ----------
        //spiImpl.engineInit(ks);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.988 -0400", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "4D82229B6FEB6970720AB6BBDA0089BB")
    public final void init(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        addTaint(spec.getTaint());
        spiImpl.engineInit(spec);
        // ---------- Original Method ----------
        //spiImpl.engineInit(spec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.989 -0400", hash_original_method = "9A37AD00FB926A5C41BF7A3778BB3A49", hash_generated_method = "045CE1DA4C6269B57442F40A73DB74A8")
    public final TrustManager[] getTrustManagers() {
TrustManager[] var864DD8A2A9CEA759F4550FE28D6AA441_1939815536 =         spiImpl.engineGetTrustManagers();
        var864DD8A2A9CEA759F4550FE28D6AA441_1939815536.addTaint(taint);
        return var864DD8A2A9CEA759F4550FE28D6AA441_1939815536;
        // ---------- Original Method ----------
        //return spiImpl.engineGetTrustManagers();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.989 -0400", hash_original_field = "79D8D6233AF387675C88C124668A47A5", hash_generated_field = "32B824317E2E7AE3C2672EA0BF3EE3F6")

    private static final String SERVICE = "TrustManagerFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.989 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.989 -0400", hash_original_field = "1AD9833D0DE170E73BE85775A2603A23", hash_generated_field = "04A5913ADF56B6B4919B16CFB81F6A6C")

    private static final String PROPERTYNAME = "ssl.TrustManagerFactory.algorithm";
}

