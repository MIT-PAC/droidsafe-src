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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.221 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.221 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.222 -0400", hash_original_method = "5546FFAC9B42B6F49AEA710C665EF80A", hash_generated_method = "934C359343DE9AB631BA86A99151E869")
    protected  KeyPairGenerator(String algorithm) {
        this.algorithm = algorithm;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.222 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "216CA4C11A52FFD2EA14408DC358E2DC")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1457807399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1457807399 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1457807399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1457807399;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.223 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "24446844ED9866A8CEB8B5FC89AB26B2")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1868619037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868619037 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1868619037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868619037;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.224 -0400", hash_original_method = "63D58B7A783E5CA62351478BDCD64960", hash_generated_method = "F027C49C85B9842127627030CFC71A4B")
    public void initialize(int keysize) {
        initialize(keysize, RANDOM);
        addTaint(keysize);
        // ---------- Original Method ----------
        //initialize(keysize, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.231 -0400", hash_original_method = "505B12303F8A8E9420867471775AD0AC", hash_generated_method = "000E4A2CAF76FE3864E61EFEF79A069C")
    public void initialize(AlgorithmParameterSpec param) throws InvalidAlgorithmParameterException {
        initialize(param, RANDOM);
        addTaint(param.getTaint());
        // ---------- Original Method ----------
        //initialize(param, RANDOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.253 -0400", hash_original_method = "0A0D3545CE028F03545250CE4A841A43", hash_generated_method = "6CE169046D8CFD53DC1CAD2277FA7F74")
    public final KeyPair genKeyPair() {
        KeyPair varB4EAC82CA7396A68D541C85D26508E83_1393073102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1393073102 = generateKeyPair();
        varB4EAC82CA7396A68D541C85D26508E83_1393073102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393073102;
        // ---------- Original Method ----------
        //return generateKeyPair();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.253 -0400", hash_original_method = "7972015D8BC3BAE6F8655706849D6EC4", hash_generated_method = "822D5D32CDEF49187D048A6C61DCCE49")
    @Override
    public KeyPair generateKeyPair() {
        KeyPair varB4EAC82CA7396A68D541C85D26508E83_1941842935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1941842935 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1941842935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1941842935;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.253 -0400", hash_original_method = "C1E2700C4D7C78BCD077B4B9FB70A89A", hash_generated_method = "0CF416521974AB781EEB36947D155320")
    @Override
    public void initialize(int keysize, SecureRandom random) {
        addTaint(keysize);
        addTaint(random.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.254 -0400", hash_original_method = "3E787A500B01324B444CF13BE7390B3D", hash_generated_method = "36F7E76B48F224D711E2BB416DA5F19B")
    @Override
    public void initialize(AlgorithmParameterSpec param, SecureRandom random) throws InvalidAlgorithmParameterException {
        addTaint(param.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
    }

    
    private static class KeyPairGeneratorImpl extends KeyPairGenerator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.254 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "5688209BF362571C922D334A44DFEAF3")

        private KeyPairGeneratorSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.254 -0400", hash_original_method = "31255CF8BFD3D1E3DCC08215387BB12A", hash_generated_method = "705EBF0A01F9AB77C59B9E360E63312F")
        private  KeyPairGeneratorImpl(KeyPairGeneratorSpi keyPairGeneratorSpi,
                Provider provider, String algorithm) {
            super(algorithm);
            super.provider = provider;
            spiImpl = keyPairGeneratorSpi;
            addTaint(provider.getTaint());
            addTaint(algorithm.getTaint());
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = keyPairGeneratorSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.254 -0400", hash_original_method = "A4E5201D8A18A75F2C72ED6B7363B7D6", hash_generated_method = "A429831EC5B6C4CFA40482F34A8C132B")
        @Override
        public void initialize(int keysize, SecureRandom random) {
            spiImpl.initialize(keysize, random);
            addTaint(keysize);
            addTaint(random.getTaint());
            // ---------- Original Method ----------
            //spiImpl.initialize(keysize, random);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.255 -0400", hash_original_method = "44E6103A9DEB6D889A2EDBD2D91F5661", hash_generated_method = "E058781AD6D2CD7356EE793D8F1500BC")
        @Override
        public KeyPair generateKeyPair() {
            KeyPair varB4EAC82CA7396A68D541C85D26508E83_477640718 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_477640718 = spiImpl.generateKeyPair();
            varB4EAC82CA7396A68D541C85D26508E83_477640718.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_477640718;
            // ---------- Original Method ----------
            //return spiImpl.generateKeyPair();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.255 -0400", hash_original_method = "4494520DAC0042C0E4EFE59D1D9956AB", hash_generated_method = "3915AD0EC50B6DA131F73E3ABC48081A")
        @Override
        public void initialize(AlgorithmParameterSpec param, SecureRandom random) throws InvalidAlgorithmParameterException {
            spiImpl.initialize(param, random);
            addTaint(param.getTaint());
            addTaint(random.getTaint());
            // ---------- Original Method ----------
            //spiImpl.initialize(param, random);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.256 -0400", hash_original_field = "FD77708FE383F4AF449FA1A24C39E286", hash_generated_field = "12167D390B15F8DE4D459C0F3E1715AB")

    private static String SERVICE = "KeyPairGenerator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.256 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.256 -0400", hash_original_field = "9AE708A2321B1D064045F8FC9B284C5C", hash_generated_field = "473A20CDE6EFEE7D42F595BA5492FFB7")

    private static SecureRandom RANDOM = new SecureRandom();
}

