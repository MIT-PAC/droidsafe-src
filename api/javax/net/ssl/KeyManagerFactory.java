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
import java.security.UnrecoverableKeyException;
import org.apache.harmony.security.fortress.Engine;

public class KeyManagerFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.635 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.636 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "66956FA0EC6E90989FDF6ECA22799199")

    private KeyManagerFactorySpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.636 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.637 -0400", hash_original_method = "70F84550962AE46163866D0A34314F54", hash_generated_method = "5C23709F478D6E8DB18309E3BC6E3412")
    protected  KeyManagerFactory(KeyManagerFactorySpi factorySpi, Provider provider,
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
        return Security.getProperty(PROPERTY_NAME);
    }

    
    public static final KeyManagerFactory getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyManagerFactory((KeyManagerFactorySpi) sap.spi, sap.provider, algorithm);
    }

    
    public static final KeyManagerFactory getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if ((provider == null) || (provider.length() == 0)) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
    public static final KeyManagerFactory getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (algorithm == null) {
            throw new NullPointerException("algorithm is null");
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyManagerFactory((KeyManagerFactorySpi) spi, provider, algorithm);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.639 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "C71E59FB3989A55CFC75FA7643564BA3")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1159921851 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1159921851.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1159921851;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.639 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "EDF2A1D76775B60CC2921FFF8D4E3480")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1227211053 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1227211053.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1227211053;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.639 -0400", hash_original_method = "4FB19D2B9D9DA541468809C3D1BCD49A", hash_generated_method = "A92F5467E8AD0998DF83B09295BABF15")
    public final void init(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException {
        addTaint(password[0]);
        addTaint(ks.getTaint());
        spiImpl.engineInit(ks, password);
        // ---------- Original Method ----------
        //spiImpl.engineInit(ks, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.639 -0400", hash_original_method = "968F65DD7A0A827F06FAF23F78E04C48", hash_generated_method = "4D82229B6FEB6970720AB6BBDA0089BB")
    public final void init(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {
        addTaint(spec.getTaint());
        spiImpl.engineInit(spec);
        // ---------- Original Method ----------
        //spiImpl.engineInit(spec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.640 -0400", hash_original_method = "B9A1EAEE9A7433E4D131EF6C1483617B", hash_generated_method = "86A8F30358E9A68976012ECC5FDF06F7")
    public final KeyManager[] getKeyManagers() {
KeyManager[] var955490AC7A1924D012F4879486E1856B_963617442 =         spiImpl.engineGetKeyManagers();
        var955490AC7A1924D012F4879486E1856B_963617442.addTaint(taint);
        return var955490AC7A1924D012F4879486E1856B_963617442;
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeyManagers();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.640 -0400", hash_original_field = "B523D7CACD97A95D3A027A66B5B1FC09", hash_generated_field = "6093E7EBB23B13F23E0C67DF945E7DAF")

    private static final String SERVICE = "KeyManagerFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.640 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.640 -0400", hash_original_field = "1C1253A0AF67FF4DEB3E6B71E8A225D4", hash_generated_field = "A8EB468D11DCED53A26B66B0AF22B9BA")

    private static final String PROPERTY_NAME = "ssl.KeyManagerFactory.algorithm";
}

