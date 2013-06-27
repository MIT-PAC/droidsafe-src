package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

public class SSLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.231 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.231 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "35670434E65BDBAFCC16200249E01B00")

    private SSLContextSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.231 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.232 -0400", hash_original_method = "C804D9011355FC1C1182E28B9F55F9CC", hash_generated_method = "088B0261D1EFCD8A932AF0AD4ED02EB8")
    protected  SSLContext(SSLContextSpi contextSpi, Provider provider, String protocol) {
        this.provider = provider;
        this.protocol = protocol;
        this.spiImpl = contextSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.protocol = protocol;
        //this.spiImpl = contextSpi;
    }

    
        public static SSLContext getDefault() throws NoSuchAlgorithmException {
        synchronized (ENGINE) {
            if (DEFAULT == null) {
                DEFAULT = SSLContext.getInstance("Default");
            }
            return DEFAULT;
        }
    }

    
        public static void setDefault(SSLContext sslContext) {
        if (sslContext == null) {
            throw new NullPointerException("sslContext == null");
        }
        synchronized (ENGINE) {
            DEFAULT = sslContext;
        }
    }

    
        public static SSLContext getInstance(String protocol) throws NoSuchAlgorithmException {
        if (protocol == null) {
            throw new NullPointerException("protocol is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(protocol, null);
        return new SSLContext((SSLContextSpi) sap.spi, sap.provider, protocol);
    }

    
        public static SSLContext getInstance(String protocol, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (provider.length() == 0) {
            throw new IllegalArgumentException("Provider is empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(protocol, impProvider);
    }

    
        public static SSLContext getInstance(String protocol, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider is null");
        }
        if (protocol == null) {
            throw new NullPointerException("protocol is null");
        }
        Object spi = ENGINE.getInstance(protocol, provider, null);
        return new SSLContext((SSLContextSpi) spi, provider, protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.237 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "5FD0499BBA123F8EC4498C962E28546A")
    public final String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_244379931 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_244379931 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_244379931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_244379931;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.238 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "6BBC16487C3F71CDAA8CE296BFD6B806")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_222433448 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_222433448 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_222433448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_222433448;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.239 -0400", hash_original_method = "862C6735087482F43EE162F8A0522BCE", hash_generated_method = "E37945FD2D89607009AC8249D3674400")
    public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException {
        spiImpl.engineInit(km, tm, sr);
        addTaint(km[0].getTaint());
        addTaint(tm[0].getTaint());
        addTaint(sr.getTaint());
        // ---------- Original Method ----------
        //spiImpl.engineInit(km, tm, sr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.239 -0400", hash_original_method = "B0765B951456A1F8D049DA95DEF67C61", hash_generated_method = "3B3699B87C02A34C5FB8CE69EFB1652C")
    public final SSLSocketFactory getSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_346591244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_346591244 = spiImpl.engineGetSocketFactory();
        varB4EAC82CA7396A68D541C85D26508E83_346591244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_346591244;
        // ---------- Original Method ----------
        //return spiImpl.engineGetSocketFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.240 -0400", hash_original_method = "6B854724B17F4BE278032C18BCD40494", hash_generated_method = "FF2012FF9A18CCCFF4A94A9E5488A700")
    public final SSLServerSocketFactory getServerSocketFactory() {
        SSLServerSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1405953074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1405953074 = spiImpl.engineGetServerSocketFactory();
        varB4EAC82CA7396A68D541C85D26508E83_1405953074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1405953074;
        // ---------- Original Method ----------
        //return spiImpl.engineGetServerSocketFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.240 -0400", hash_original_method = "9326AAD5FC0B444F9C3CCC582EB8A84C", hash_generated_method = "E7FE5EB7328631E5AAEA9AD17C0F6329")
    public final SSLEngine createSSLEngine() {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_1396566627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1396566627 = spiImpl.engineCreateSSLEngine();
        varB4EAC82CA7396A68D541C85D26508E83_1396566627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1396566627;
        // ---------- Original Method ----------
        //return spiImpl.engineCreateSSLEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.243 -0400", hash_original_method = "4AC4A8F933626C577BD77D72E35BEF87", hash_generated_method = "D45CE7163F507E1F9F7251ACC8513667")
    public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_1118124144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1118124144 = spiImpl.engineCreateSSLEngine(peerHost, peerPort);
        addTaint(peerHost.getTaint());
        addTaint(peerPort);
        varB4EAC82CA7396A68D541C85D26508E83_1118124144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1118124144;
        // ---------- Original Method ----------
        //return spiImpl.engineCreateSSLEngine(peerHost, peerPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.255 -0400", hash_original_method = "13CFBFF97EBEA17DB24F1E636C863192", hash_generated_method = "1262512863C16C46F8CF79CF69089E78")
    public final SSLSessionContext getServerSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_2003859734 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003859734 = spiImpl.engineGetServerSessionContext();
        varB4EAC82CA7396A68D541C85D26508E83_2003859734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003859734;
        // ---------- Original Method ----------
        //return spiImpl.engineGetServerSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.260 -0400", hash_original_method = "ECC6F07A2C60018ED286E62595778908", hash_generated_method = "5471CFF4B2CC3538CB89A9CAE96D14CB")
    public final SSLSessionContext getClientSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_1418609681 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1418609681 = spiImpl.engineGetClientSessionContext();
        varB4EAC82CA7396A68D541C85D26508E83_1418609681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418609681;
        // ---------- Original Method ----------
        //return spiImpl.engineGetClientSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.261 -0400", hash_original_method = "EF50F11BBBC92F54F2BB8CD8681E5FD1", hash_generated_method = "70CBB025940CCA1EEC484D5E06450AEA")
    public final SSLParameters getDefaultSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_782863266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_782863266 = spiImpl.engineGetDefaultSSLParameters();
        varB4EAC82CA7396A68D541C85D26508E83_782863266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_782863266;
        // ---------- Original Method ----------
        //return spiImpl.engineGetDefaultSSLParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.261 -0400", hash_original_method = "B61455860318644024B430BCDF123BB8", hash_generated_method = "221045DF1F485981CC10935920B048D7")
    public final SSLParameters getSupportedSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1780425076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1780425076 = spiImpl.engineGetSupportedSSLParameters();
        varB4EAC82CA7396A68D541C85D26508E83_1780425076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1780425076;
        // ---------- Original Method ----------
        //return spiImpl.engineGetSupportedSSLParameters();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.261 -0400", hash_original_field = "CB44F3776B2B98508777FFCDA5461DA4", hash_generated_field = "0F2D0111C26600221DDA3BF581183FA6")

    private static String SERVICE = "SSLContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.261 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.261 -0400", hash_original_field = "5B39C8B553C821E7CDDC6DA64B5BD2EE", hash_generated_field = "2B7DA749EDE2455861561266A5813438")

    private static SSLContext DEFAULT;
}

