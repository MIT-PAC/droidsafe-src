package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

public class SSLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.576 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.576 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "35670434E65BDBAFCC16200249E01B00")

    private SSLContextSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.576 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.577 -0400", hash_original_method = "C804D9011355FC1C1182E28B9F55F9CC", hash_generated_method = "088B0261D1EFCD8A932AF0AD4ED02EB8")
    protected  SSLContext(SSLContextSpi contextSpi, Provider provider, String protocol) {
        this.provider = provider;
        this.protocol = protocol;
        this.spiImpl = contextSpi;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SSLContext getDefault() throws NoSuchAlgorithmException {
        synchronized (ENGINE) {
            if (DEFAULT == null) {
                DEFAULT = SSLContext.getInstance("Default");
            }
            return DEFAULT;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefault(SSLContext sslContext) {
        if (sslContext == null) {
            throw new NullPointerException("sslContext == null");
        }
        synchronized (ENGINE) {
            DEFAULT = sslContext;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static SSLContext getInstance(String protocol) throws NoSuchAlgorithmException {
        if (protocol == null) {
            throw new NullPointerException("protocol is null");
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(protocol, null);
        return new SSLContext((SSLContextSpi) sap.spi, sap.provider, protocol);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.579 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "1F17BEF91976D1A78200AE3330CD4F20")
    public final String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_2014159604 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2014159604 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_2014159604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2014159604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.580 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "08103DB296240024D774FB4F7DB04FCE")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_56168954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_56168954 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_56168954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_56168954;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.580 -0400", hash_original_method = "862C6735087482F43EE162F8A0522BCE", hash_generated_method = "E37945FD2D89607009AC8249D3674400")
    public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException {
        spiImpl.engineInit(km, tm, sr);
        addTaint(km[0].getTaint());
        addTaint(tm[0].getTaint());
        addTaint(sr.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.581 -0400", hash_original_method = "B0765B951456A1F8D049DA95DEF67C61", hash_generated_method = "3FDF82B41EAEB3D8DD94CAF3DA53A027")
    public final SSLSocketFactory getSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_370737753 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_370737753 = spiImpl.engineGetSocketFactory();
        varB4EAC82CA7396A68D541C85D26508E83_370737753.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_370737753;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.581 -0400", hash_original_method = "6B854724B17F4BE278032C18BCD40494", hash_generated_method = "BCD3E493FD5BD43594C045E04C41066A")
    public final SSLServerSocketFactory getServerSocketFactory() {
        SSLServerSocketFactory varB4EAC82CA7396A68D541C85D26508E83_2097313328 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2097313328 = spiImpl.engineGetServerSocketFactory();
        varB4EAC82CA7396A68D541C85D26508E83_2097313328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2097313328;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.582 -0400", hash_original_method = "9326AAD5FC0B444F9C3CCC582EB8A84C", hash_generated_method = "7C864AA268ACCA72888FF51897F89ADC")
    public final SSLEngine createSSLEngine() {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_999027170 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_999027170 = spiImpl.engineCreateSSLEngine();
        varB4EAC82CA7396A68D541C85D26508E83_999027170.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_999027170;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.582 -0400", hash_original_method = "4AC4A8F933626C577BD77D72E35BEF87", hash_generated_method = "D26CE2AB31FA49E28FDD6CE3A8D8D55E")
    public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_483358354 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_483358354 = spiImpl.engineCreateSSLEngine(peerHost, peerPort);
        addTaint(peerHost.getTaint());
        addTaint(peerPort);
        varB4EAC82CA7396A68D541C85D26508E83_483358354.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_483358354;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.583 -0400", hash_original_method = "13CFBFF97EBEA17DB24F1E636C863192", hash_generated_method = "B30D728C34831CA26B902FD5881C9D5F")
    public final SSLSessionContext getServerSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_340078579 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_340078579 = spiImpl.engineGetServerSessionContext();
        varB4EAC82CA7396A68D541C85D26508E83_340078579.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_340078579;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.583 -0400", hash_original_method = "ECC6F07A2C60018ED286E62595778908", hash_generated_method = "FF0585F486554E8C130D80ED713914F4")
    public final SSLSessionContext getClientSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_397744403 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_397744403 = spiImpl.engineGetClientSessionContext();
        varB4EAC82CA7396A68D541C85D26508E83_397744403.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_397744403;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.584 -0400", hash_original_method = "EF50F11BBBC92F54F2BB8CD8681E5FD1", hash_generated_method = "B2D251F60E718C95B0CD4C501DCC3F8D")
    public final SSLParameters getDefaultSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_510468701 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_510468701 = spiImpl.engineGetDefaultSSLParameters();
        varB4EAC82CA7396A68D541C85D26508E83_510468701.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_510468701;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.584 -0400", hash_original_method = "B61455860318644024B430BCDF123BB8", hash_generated_method = "91C5D6827FD1121C750EAFFB2EFC98BA")
    public final SSLParameters getSupportedSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_679292246 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_679292246 = spiImpl.engineGetSupportedSSLParameters();
        varB4EAC82CA7396A68D541C85D26508E83_679292246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_679292246;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.584 -0400", hash_original_field = "CB44F3776B2B98508777FFCDA5461DA4", hash_generated_field = "F9968588171E1F6215F8BDC43FEE8F36")

    private static final String SERVICE = "SSLContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.584 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.584 -0400", hash_original_field = "5B39C8B553C821E7CDDC6DA64B5BD2EE", hash_generated_field = "2B7DA749EDE2455861561266A5813438")

    private static SSLContext DEFAULT;
}

