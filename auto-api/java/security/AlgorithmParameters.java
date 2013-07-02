package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.apache.harmony.security.fortress.Engine;

public class AlgorithmParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.083 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.083 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "9D41D4F6030CE195996EC7214F8C92A4")

    private AlgorithmParametersSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.083 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.083 -0400", hash_original_field = "84D10A1ED612E61DBF6880F6E3EE533A", hash_generated_field = "D96AC35F2092AB08D47BC799DE8F3A01")

    private boolean initialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.084 -0400", hash_original_method = "8DBC0799ED7E4900EBC29238B9DE7938", hash_generated_method = "FC9EF5F3B00E0445DB638E5CE884E307")
    protected  AlgorithmParameters(AlgorithmParametersSpi algPramSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = algPramSpi;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static AlgorithmParameters getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) sap.spi, sap.provider, algorithm);
    }

    
    @DSModeled(DSC.SAFE)
    public static AlgorithmParameters getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    
    @DSModeled(DSC.SAFE)
    public static AlgorithmParameters getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.085 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "4D346C9FCF003B6CE935712FE10F3942")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_374143840 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_374143840 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_374143840.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_374143840;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.085 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "B3736989121ACB589CFDEC10567B8A8B")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_931175589 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_931175589 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_931175589.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_931175589;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.086 -0400", hash_original_method = "7E6C59119732596BEFEB2E6E8A90EC10", hash_generated_method = "AD93E5A461AD0CC5BCE035C353F9DB4D")
    public final void init(AlgorithmParameterSpec paramSpec) throws InvalidParameterSpecException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidParameterSpecException("Parameter has already been initialized");
        } 
        spiImpl.engineInit(paramSpec);
        initialized = true;
        addTaint(paramSpec.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.086 -0400", hash_original_method = "617D5B707C3D1A91A18634DFC0D9F364", hash_generated_method = "367FEE9FFDB5AC220EECDEFA8D421FCC")
    public final void init(byte[] params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has already been initialized");
        } 
        spiImpl.engineInit(params);
        initialized = true;
        addTaint(params[0]);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.087 -0400", hash_original_method = "7B3B0E8CD7575D668CB68D6510D827CC", hash_generated_method = "2C5BCFAF58357EFDCEB021812B44AC31")
    public final void init(byte[] params, String format) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has already been initialized");
        } 
        spiImpl.engineInit(params, format);
        initialized = true;
        addTaint(params[0]);
        addTaint(format.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.088 -0400", hash_original_method = "9BE0AC13DE94D992E08BA6CD89DD9D38", hash_generated_method = "93EED655EDC7C836AA8831316E2B3043")
    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> paramSpec) throws InvalidParameterSpecException {
        T varB4EAC82CA7396A68D541C85D26508E83_1340680911 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidParameterSpecException("Parameter has not been initialized");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1340680911 = spiImpl.engineGetParameterSpec(paramSpec);
        addTaint(paramSpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1340680911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1340680911;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.088 -0400", hash_original_method = "2345D83B19F14D228FA4A748BB5C0696", hash_generated_method = "BE87C38307B1ACC3EFC6BC89DB9AA5EA")
    public final byte[] getEncoded() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has not been initialized");
        } 
        byte[] var71FE8FA1349A7263D1CF718AD61F0E29_1033703084 = (spiImpl.engineGetEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1424084869 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1424084869;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.088 -0400", hash_original_method = "5F0B9F7B1E2AFA510F6DA0646E7306FA", hash_generated_method = "9B2F77A321320FCBBA768565C6681754")
    public final byte[] getEncoded(String format) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has not been initialized");
        } 
        byte[] varAB1997B2C1685ABABFB8C83A59472A88_892997565 = (spiImpl.engineGetEncoded(format));
        addTaint(format.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1346824373 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1346824373;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.089 -0400", hash_original_method = "3487587F52CF5404E8DAC6B47C5FD08C", hash_generated_method = "CC70D09F416E2ACFD424044ED758C8B5")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1856960063 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1868523269 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1856960063 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1868523269 = spiImpl.engineToString();
        String varA7E53CE21691AB073D9660D615818899_1292383686; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1292383686 = varB4EAC82CA7396A68D541C85D26508E83_1856960063;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1292383686 = varB4EAC82CA7396A68D541C85D26508E83_1868523269;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1292383686.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1292383686;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.089 -0400", hash_original_field = "BD287EEC5C314A263C8A703B0C369591", hash_generated_field = "2A5FC69C67235739D89B6E72871223E3")

    private static final String SEVICE = "AlgorithmParameters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.089 -0400", hash_original_field = "F520423B8D44D86CE24ED3349D3881B9", hash_generated_field = "00A78935B1DF849DB7CCEEA674A30AFE")

    private static final Engine ENGINE = new Engine(SEVICE);
}

