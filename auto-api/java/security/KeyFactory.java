package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.harmony.security.fortress.Engine;

public class KeyFactory {
    private Provider provider;
    private KeyFactorySpi spiImpl;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.327 -0400", hash_original_method = "8C178BBFD1FCE7A7C88CEB58B900756B", hash_generated_method = "9363F770C23E6BC6140C8DAE2A4CF04B")
    @DSModeled(DSC.SAFE)
    protected KeyFactory(KeyFactorySpi keyFacSpi,
                         Provider provider,
                         String algorithm) {
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(keyFacSpi.dsTaint);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = keyFacSpi;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.328 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.328 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.328 -0400", hash_original_method = "D16F4EDBCE8E03F680EB7C937E0DCCC9", hash_generated_method = "BBA3D2BB5A19F37EDB85AB77A68DC0C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final PublicKey generatePublic(KeySpec keySpec) throws InvalidKeySpecException {
        dsTaint.addTaint(keySpec.dsTaint);
        PublicKey var1DF9D792F2F740CEF95D18F48C46515C_998731153 = (spiImpl.engineGeneratePublic(keySpec));
        return (PublicKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGeneratePublic(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.328 -0400", hash_original_method = "56D108179E38B3C9859C6FCAEB589129", hash_generated_method = "F78A5EF6AA79AB16A24E2869B4677896")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final PrivateKey generatePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        dsTaint.addTaint(keySpec.dsTaint);
        PrivateKey var58E2ADEEC634D5AB274ABBA5EE80FF15_116369463 = (spiImpl.engineGeneratePrivate(keySpec));
        return (PrivateKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGeneratePrivate(keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.328 -0400", hash_original_method = "7B77F80B2A4A2C9E7EABE7EB820F4781", hash_generated_method = "C7D8FCEE4482F1F8EE534D4B1A727249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T extends KeySpec> T getKeySpec(Key key,
                                    Class<T> keySpec) throws InvalidKeySpecException {
        dsTaint.addTaint(keySpec.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        T var0B908CAD63B16EBBDB50408D5E553615_5313749 = (spiImpl.engineGetKeySpec(key, keySpec));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetKeySpec(key, keySpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.328 -0400", hash_original_method = "23F9E5F6A6B9FC183E94A65D97880068", hash_generated_method = "22DE011E34C7CA2B331BBA1A0E6FAE73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Key translateKey(Key key) throws InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        Key var4E28BE4C53870695ACCFC1F1D8FF6229_762906739 = (spiImpl.engineTranslateKey(key));
        return (Key)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineTranslateKey(key);
    }

    
    private static final String SERVICE = "KeyFactory";
    private static final Engine ENGINE = new Engine(SERVICE);
}

