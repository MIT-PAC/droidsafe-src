package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Provider provider;
    private KeyAgreementSpi spiImpl;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.973 -0400", hash_original_method = "0900837118FEE4DAFDEFCB258925423D", hash_generated_method = "6CF089C35692D9597597B567FDDBC2EF")
    @DSModeled(DSC.SAFE)
    protected KeyAgreement(KeyAgreementSpi keyAgreeSpi, Provider provider,
            String algorithm) {
        dsTaint.addTaint(keyAgreeSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = keyAgreeSpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.973 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.974 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.974 -0400", hash_original_method = "D4F5C8E3486A3AF707B3A0052AE97F9F", hash_generated_method = "87DB25813A558B0562B788B64BBBEEED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(Key key) throws InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        spiImpl.engineInit(key, RANDOM);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.974 -0400", hash_original_method = "B560CE194C80427D06320AB3301AD531", hash_generated_method = "E7B5EB76614690F3E3D74636E4AA7CC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(Key key, SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        spiImpl.engineInit(key, random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.975 -0400", hash_original_method = "45385F3B8A57987C5A6F500929E2FE45", hash_generated_method = "E83CFD4415B8728609FFAE3C361BEBC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        spiImpl.engineInit(key, params, RANDOM);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, params, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.975 -0400", hash_original_method = "04B90A53EC2A8EFB98D3E5D98D18DD54", hash_generated_method = "B2E6BC88E6B56B94757F21B30262E8BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        spiImpl.engineInit(key, params, random);
        // ---------- Original Method ----------
        //spiImpl.engineInit(key, params, random);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.975 -0400", hash_original_method = "BB12C4D69D38F4161821D54CA8CAAD00", hash_generated_method = "20592C858B04925F7149EA707D86BF14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Key doPhase(Key key, boolean lastPhase) throws InvalidKeyException, IllegalStateException {
        dsTaint.addTaint(lastPhase);
        dsTaint.addTaint(key.dsTaint);
        Key var4590365D54FC21EE144C5E86877F3185_785540185 = (spiImpl.engineDoPhase(key, lastPhase));
        return (Key)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineDoPhase(key, lastPhase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.975 -0400", hash_original_method = "A2824ED5DB0FCCB2C192A225E52EA88C", hash_generated_method = "7AC0F8B6D57176EC748C24EE17028CE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] generateSecret() throws IllegalStateException {
        byte[] varA8BB6E6E942BEB9835A7817272D04164_1612024172 = (spiImpl.engineGenerateSecret());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.975 -0400", hash_original_method = "7B919BB67435CAC1AF727C4D009370B1", hash_generated_method = "E3D6EB62BE479FFBDCE298569CE8EF25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int generateSecret(byte[] sharedSecret, int offset) throws IllegalStateException, ShortBufferException {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(sharedSecret[0]);
        int varABD732903B431C7D9F1A169C9C636E3D_525706903 = (spiImpl.engineGenerateSecret(sharedSecret, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(sharedSecret, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.975 -0400", hash_original_method = "0E820F09DB891E9F2C0C31F49AA44F05", hash_generated_method = "BDCF88EF33863876E0B5274D3CA5CF0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SecretKey generateSecret(String algorithm) throws IllegalStateException, NoSuchAlgorithmException,
            InvalidKeyException {
        dsTaint.addTaint(algorithm);
        SecretKey var2FED20DFC5A665CDF9B6876A3B53DC27_200796716 = (spiImpl.engineGenerateSecret(algorithm));
        return (SecretKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGenerateSecret(algorithm);
    }

    
    private static final Engine ENGINE = new Engine("KeyAgreement");
    private static final SecureRandom RANDOM = new SecureRandom();
}

