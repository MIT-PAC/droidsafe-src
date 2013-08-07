package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.harmony.security.fortress.Engine;






public abstract class KeyPairGenerator extends KeyPairGeneratorSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.942 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.942 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.942 -0400", hash_original_method = "5546FFAC9B42B6F49AEA710C665EF80A", hash_generated_method = "934C359343DE9AB631BA86A99151E869")
    protected  KeyPairGenerator(String algorithm) {
        this.algorithm = algorithm;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.943 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "70DF59C264851AFCF31BBADC77D1023F")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_738953698 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_738953698.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_738953698;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.945 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "B509EE86C851775B6127179C0C8ACD9F")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_2145995178 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_2145995178.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_2145995178;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.945 -0400", hash_original_method = "63D58B7A783E5CA62351478BDCD64960", hash_generated_method = "5D488A6D8ED37B8C596F1608602ABECF")
    public void initialize(int keysize) {
        addTaint(keysize);
        initialize(keysize, RANDOM);
        // ---------- Original Method ----------
        //initialize(keysize, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.945 -0400", hash_original_method = "505B12303F8A8E9420867471775AD0AC", hash_generated_method = "5D2148C8BF7941483E8F1F8874FCA211")
    public void initialize(AlgorithmParameterSpec param) throws InvalidAlgorithmParameterException {
        addTaint(param.getTaint());
        initialize(param, RANDOM);
        // ---------- Original Method ----------
        //initialize(param, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.946 -0400", hash_original_method = "0A0D3545CE028F03545250CE4A841A43", hash_generated_method = "7F67EE7919A376E79F73FB81C960D1DA")
    public final KeyPair genKeyPair() {
KeyPair var7EF0CBCA1B0CA80E47B1AE4032BB7E5C_697940814 =         generateKeyPair();
        var7EF0CBCA1B0CA80E47B1AE4032BB7E5C_697940814.addTaint(taint);
        return var7EF0CBCA1B0CA80E47B1AE4032BB7E5C_697940814;
        // ---------- Original Method ----------
        //return generateKeyPair();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.946 -0400", hash_original_method = "7972015D8BC3BAE6F8655706849D6EC4", hash_generated_method = "5212BD82AA49DF800D118CCDCA131888")
    @Override
    public KeyPair generateKeyPair() {
KeyPair var540C13E9E156B687226421B24F2DF178_1490885900 =         null;
        var540C13E9E156B687226421B24F2DF178_1490885900.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1490885900;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.946 -0400", hash_original_method = "C1E2700C4D7C78BCD077B4B9FB70A89A", hash_generated_method = "1E8E4750002A943752775DFA2D8B52A0")
    @Override
    public void initialize(int keysize, SecureRandom random) {
        addTaint(random.getTaint());
        addTaint(keysize);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.947 -0400", hash_original_method = "3E787A500B01324B444CF13BE7390B3D", hash_generated_method = "D43A9F4E58FDFBDDD4BDF1CFC44F4964")
    @Override
    public void initialize(AlgorithmParameterSpec param, SecureRandom random) throws InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(param.getTaint());
        // ---------- Original Method ----------
    }

    
    private static class KeyPairGeneratorImpl extends KeyPairGenerator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.947 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "5688209BF362571C922D334A44DFEAF3")

        private KeyPairGeneratorSpi spiImpl;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.948 -0400", hash_original_method = "31255CF8BFD3D1E3DCC08215387BB12A", hash_generated_method = "6BD3E1E93444A1203A29C1758097E109")
        private  KeyPairGeneratorImpl(KeyPairGeneratorSpi keyPairGeneratorSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            addTaint(algorithm.getTaint());
            addTaint(provider.getTaint());
            super.provider = provider;
            spiImpl = keyPairGeneratorSpi;
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = keyPairGeneratorSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.948 -0400", hash_original_method = "A4E5201D8A18A75F2C72ED6B7363B7D6", hash_generated_method = "99F29767E1EFAD8AD355A16C70513F13")
        @Override
        public void initialize(int keysize, SecureRandom random) {
            addTaint(random.getTaint());
            addTaint(keysize);
            spiImpl.initialize(keysize, random);
            // ---------- Original Method ----------
            //spiImpl.initialize(keysize, random);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.948 -0400", hash_original_method = "44E6103A9DEB6D889A2EDBD2D91F5661", hash_generated_method = "F223D83E3F84EA2E23F6A7E0B9E2C89B")
        @Override
        public KeyPair generateKeyPair() {
KeyPair var7EFEDE5F49B93533C358711F7FDA93A1_99617471 =             spiImpl.generateKeyPair();
            var7EFEDE5F49B93533C358711F7FDA93A1_99617471.addTaint(taint);
            return var7EFEDE5F49B93533C358711F7FDA93A1_99617471;
            // ---------- Original Method ----------
            //return spiImpl.generateKeyPair();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.949 -0400", hash_original_method = "4494520DAC0042C0E4EFE59D1D9956AB", hash_generated_method = "BB09A91F704409875F06B7B681529C33")
        @Override
        public void initialize(AlgorithmParameterSpec param, SecureRandom random) throws InvalidAlgorithmParameterException {
            addTaint(random.getTaint());
            addTaint(param.getTaint());
            spiImpl.initialize(param, random);
            // ---------- Original Method ----------
            //spiImpl.initialize(param, random);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.949 -0400", hash_original_field = "FD77708FE383F4AF449FA1A24C39E286", hash_generated_field = "F51DFBA48E1CBE1BD95133B2C4AEE495")

    private static final String SERVICE = "KeyPairGenerator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.949 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.950 -0400", hash_original_field = "9AE708A2321B1D064045F8FC9B284C5C", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
}

