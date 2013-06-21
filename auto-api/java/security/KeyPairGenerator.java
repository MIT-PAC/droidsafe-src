package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

public abstract class KeyPairGenerator extends KeyPairGeneratorSpi {
    private Provider provider;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.334 -0400", hash_original_method = "5546FFAC9B42B6F49AEA710C665EF80A", hash_generated_method = "3E83CF3EACBD49218331292C84E55C63")
    @DSModeled(DSC.SAFE)
    protected KeyPairGenerator(String algorithm) {
        dsTaint.addTaint(algorithm);
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.334 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "AB6B64DEEAE2006CFA3127C5F18A75FB")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
        public static KeyPairGenerator getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof KeyPairGenerator) {
            KeyPairGenerator result = (KeyPairGenerator) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new KeyPairGeneratorImpl((KeyPairGeneratorSpi) spi, provider, algorithm);
    }

    
        public static KeyPairGenerator getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
        public static KeyPairGenerator getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof KeyPairGenerator) {
            KeyPairGenerator result = (KeyPairGenerator) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new KeyPairGeneratorImpl((KeyPairGeneratorSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.335 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.335 -0400", hash_original_method = "63D58B7A783E5CA62351478BDCD64960", hash_generated_method = "0549CC45AEE2DD647B6375677EC85FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initialize(int keysize) {
        dsTaint.addTaint(keysize);
        initialize(keysize, RANDOM);
        // ---------- Original Method ----------
        //initialize(keysize, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.335 -0400", hash_original_method = "505B12303F8A8E9420867471775AD0AC", hash_generated_method = "84A8801E60F0E8BE6B22D1B41FB23D87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initialize(AlgorithmParameterSpec param) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(param.dsTaint);
        initialize(param, RANDOM);
        // ---------- Original Method ----------
        //initialize(param, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.335 -0400", hash_original_method = "0A0D3545CE028F03545250CE4A841A43", hash_generated_method = "6F83D6668CA92E070548E3438EBAFA32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final KeyPair genKeyPair() {
        KeyPair var3CEA8F7A2AD542093EE116FD72E9AE05_1489334589 = (generateKeyPair());
        return (KeyPair)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return generateKeyPair();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.335 -0400", hash_original_method = "7972015D8BC3BAE6F8655706849D6EC4", hash_generated_method = "2AB0B10DDE66D08A3862922939354B14")
    @DSModeled(DSC.SAFE)
    @Override
    public KeyPair generateKeyPair() {
        return (KeyPair)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.336 -0400", hash_original_method = "C1E2700C4D7C78BCD077B4B9FB70A89A", hash_generated_method = "AFCA02D3B9A2CB57E75A5C528F117A24")
    @DSModeled(DSC.SAFE)
    @Override
    public void initialize(int keysize, SecureRandom random) {
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(keysize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.336 -0400", hash_original_method = "3E787A500B01324B444CF13BE7390B3D", hash_generated_method = "BE1E5F258CEE42A0464C8F7B2E5F17D1")
    @DSModeled(DSC.SAFE)
    @Override
    public void initialize(AlgorithmParameterSpec param, SecureRandom random) throws InvalidAlgorithmParameterException {
        dsTaint.addTaint(param.dsTaint);
        dsTaint.addTaint(random.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static class KeyPairGeneratorImpl extends KeyPairGenerator {
        private KeyPairGeneratorSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.336 -0400", hash_original_method = "31255CF8BFD3D1E3DCC08215387BB12A", hash_generated_method = "7B755033A2FF5CB10C35BD6BCBC6B8A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private KeyPairGeneratorImpl(KeyPairGeneratorSpi keyPairGeneratorSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            dsTaint.addTaint(keyPairGeneratorSpi.dsTaint);
            dsTaint.addTaint(provider.dsTaint);
            dsTaint.addTaint(algorithm);
            super.provider = provider;
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = keyPairGeneratorSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.336 -0400", hash_original_method = "A4E5201D8A18A75F2C72ED6B7363B7D6", hash_generated_method = "CC0D0A6A31338BB3EEA454ED41005F28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void initialize(int keysize, SecureRandom random) {
            dsTaint.addTaint(random.dsTaint);
            dsTaint.addTaint(keysize);
            spiImpl.initialize(keysize, random);
            // ---------- Original Method ----------
            //spiImpl.initialize(keysize, random);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.336 -0400", hash_original_method = "44E6103A9DEB6D889A2EDBD2D91F5661", hash_generated_method = "A8E5DBB306AE617C582972D6DED70A19")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public KeyPair generateKeyPair() {
            KeyPair var0F58981B65C8E1457EE0D7DD4B1305F8_652675471 = (spiImpl.generateKeyPair());
            return (KeyPair)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return spiImpl.generateKeyPair();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.336 -0400", hash_original_method = "4494520DAC0042C0E4EFE59D1D9956AB", hash_generated_method = "F6BBA6D536B029373DB7A34CFEF2574E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void initialize(AlgorithmParameterSpec param, SecureRandom random) throws InvalidAlgorithmParameterException {
            dsTaint.addTaint(param.dsTaint);
            dsTaint.addTaint(random.dsTaint);
            spiImpl.initialize(param, random);
            // ---------- Original Method ----------
            //spiImpl.initialize(param, random);
        }

        
    }


    
    private static final String SERVICE = "KeyPairGenerator";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final SecureRandom RANDOM = new SecureRandom();
}

