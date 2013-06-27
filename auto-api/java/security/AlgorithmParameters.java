package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.apache.harmony.security.fortress.Engine;

public class AlgorithmParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "9D41D4F6030CE195996EC7214F8C92A4")

    private AlgorithmParametersSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_field = "84D10A1ED612E61DBF6880F6E3EE533A", hash_generated_field = "D96AC35F2092AB08D47BC799DE8F3A01")

    private boolean initialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.108 -0400", hash_original_method = "8DBC0799ED7E4900EBC29238B9DE7938", hash_generated_method = "FC9EF5F3B00E0445DB638E5CE884E307")
    protected  AlgorithmParameters(AlgorithmParametersSpi algPramSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = algPramSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = algPramSpi;
    }

    
        public static AlgorithmParameters getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) sap.spi, sap.provider, algorithm);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.110 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "CC1DEA7BC97A94C2CA1C38CF77E28EC8")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1824616217 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1824616217 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1824616217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1824616217;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.111 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "9CE4E49D0FE08BD6D629F0161E15131E")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_535437923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_535437923 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_535437923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_535437923;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.111 -0400", hash_original_method = "7E6C59119732596BEFEB2E6E8A90EC10", hash_generated_method = "AD93E5A461AD0CC5BCE035C353F9DB4D")
    public final void init(AlgorithmParameterSpec paramSpec) throws InvalidParameterSpecException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidParameterSpecException("Parameter has already been initialized");
        } //End block
        spiImpl.engineInit(paramSpec);
        initialized = true;
        addTaint(paramSpec.getTaint());
        // ---------- Original Method ----------
        //if (initialized) {
            //throw new InvalidParameterSpecException("Parameter has already been initialized");
        //}
        //spiImpl.engineInit(paramSpec);
        //initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.111 -0400", hash_original_method = "617D5B707C3D1A91A18634DFC0D9F364", hash_generated_method = "367FEE9FFDB5AC220EECDEFA8D421FCC")
    public final void init(byte[] params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has already been initialized");
        } //End block
        spiImpl.engineInit(params);
        initialized = true;
        addTaint(params[0]);
        // ---------- Original Method ----------
        //if (initialized) {
            //throw new IOException("Parameter has already been initialized");
        //}
        //spiImpl.engineInit(params);
        //initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.119 -0400", hash_original_method = "7B3B0E8CD7575D668CB68D6510D827CC", hash_generated_method = "2C5BCFAF58357EFDCEB021812B44AC31")
    public final void init(byte[] params, String format) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has already been initialized");
        } //End block
        spiImpl.engineInit(params, format);
        initialized = true;
        addTaint(params[0]);
        addTaint(format.getTaint());
        // ---------- Original Method ----------
        //if (initialized) {
            //throw new IOException("Parameter has already been initialized");
        //}
        //spiImpl.engineInit(params, format);
        //initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.125 -0400", hash_original_method = "9BE0AC13DE94D992E08BA6CD89DD9D38", hash_generated_method = "F0FD4CDF45AFC5361633D9FFC95BDAF3")
    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> paramSpec) throws InvalidParameterSpecException {
        T varB4EAC82CA7396A68D541C85D26508E83_789499733 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidParameterSpecException("Parameter has not been initialized");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_789499733 = spiImpl.engineGetParameterSpec(paramSpec);
        addTaint(paramSpec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_789499733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789499733;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new InvalidParameterSpecException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetParameterSpec(paramSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.125 -0400", hash_original_method = "2345D83B19F14D228FA4A748BB5C0696", hash_generated_method = "F7C5652AEE0C9AE63171DB4BCFACBA9D")
    public final byte[] getEncoded() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has not been initialized");
        } //End block
        byte[] var71FE8FA1349A7263D1CF718AD61F0E29_29127334 = (spiImpl.engineGetEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1258040074 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1258040074;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new IOException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.130 -0400", hash_original_method = "5F0B9F7B1E2AFA510F6DA0646E7306FA", hash_generated_method = "AF536847129B1A362C1EC752CC109B39")
    public final byte[] getEncoded(String format) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Parameter has not been initialized");
        } //End block
        byte[] varAB1997B2C1685ABABFB8C83A59472A88_1036884105 = (spiImpl.engineGetEncoded(format));
        addTaint(format.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1546329773 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1546329773;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new IOException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetEncoded(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.131 -0400", hash_original_method = "3487587F52CF5404E8DAC6B47C5FD08C", hash_generated_method = "A7F776DBFEA6A781EE56E7969A606847")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1560988371 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1145559008 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1560988371 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1145559008 = spiImpl.engineToString();
        String varA7E53CE21691AB073D9660D615818899_1665979210; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1665979210 = varB4EAC82CA7396A68D541C85D26508E83_1560988371;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1665979210 = varB4EAC82CA7396A68D541C85D26508E83_1145559008;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1665979210.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1665979210;
        // ---------- Original Method ----------
        //if (!initialized) {
            //return null;
        //}
        //return spiImpl.engineToString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.131 -0400", hash_original_field = "BD287EEC5C314A263C8A703B0C369591", hash_generated_field = "1A707C72B140554B04C5AA27C9ADCCE8")

    private static String SEVICE = "AlgorithmParameters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.131 -0400", hash_original_field = "F520423B8D44D86CE24ED3349D3881B9", hash_generated_field = "66CEA345CE83376BEF42DEF9515F0AE8")

    private static Engine ENGINE = new Engine(SEVICE);
}

