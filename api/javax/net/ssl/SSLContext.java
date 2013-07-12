package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

public class SSLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.818 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.818 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "35670434E65BDBAFCC16200249E01B00")

    private SSLContextSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.818 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.819 -0400", hash_original_method = "C804D9011355FC1C1182E28B9F55F9CC", hash_generated_method = "088B0261D1EFCD8A932AF0AD4ED02EB8")
    protected  SSLContext(SSLContextSpi contextSpi, Provider provider, String protocol) {
        this.provider = provider;
        this.protocol = protocol;
        this.spiImpl = contextSpi;
        
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.821 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "EF3EAF103B618993B7D61DB4967A4BD8")
    public final String getProtocol() {
String varDD56EE388A0FA5696BF9686AC14D2DB9_2090572277 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_2090572277.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_2090572277;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.821 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "EF2DE8932C2DBDC60CA185F358BA1F18")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1605342160 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1605342160.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1605342160;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.821 -0400", hash_original_method = "862C6735087482F43EE162F8A0522BCE", hash_generated_method = "9DB40518B1CA450F0326073A8F9BE4F8")
    public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException {
        addTaint(sr.getTaint());
        addTaint(tm[0].getTaint());
        addTaint(km[0].getTaint());
        spiImpl.engineInit(km, tm, sr);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.822 -0400", hash_original_method = "B0765B951456A1F8D049DA95DEF67C61", hash_generated_method = "29C874AFCE3A5C4D8F56216D2A53825B")
    public final SSLSocketFactory getSocketFactory() {
SSLSocketFactory var2D18C46B5E469E561E5021C32B0BF794_46818049 =         spiImpl.engineGetSocketFactory();
        var2D18C46B5E469E561E5021C32B0BF794_46818049.addTaint(taint);
        return var2D18C46B5E469E561E5021C32B0BF794_46818049;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.822 -0400", hash_original_method = "6B854724B17F4BE278032C18BCD40494", hash_generated_method = "7F30E0D9B5512DFB49A1E95186A3ECBA")
    public final SSLServerSocketFactory getServerSocketFactory() {
SSLServerSocketFactory var7E9BC44DA92239FF15F8006EC182721D_1760267611 =         spiImpl.engineGetServerSocketFactory();
        var7E9BC44DA92239FF15F8006EC182721D_1760267611.addTaint(taint);
        return var7E9BC44DA92239FF15F8006EC182721D_1760267611;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.822 -0400", hash_original_method = "9326AAD5FC0B444F9C3CCC582EB8A84C", hash_generated_method = "9C69369D6AA4919C91231B5837B385F2")
    public final SSLEngine createSSLEngine() {
SSLEngine varCD10BF3495E7A8E52EEE8B2C72D42FD5_907377943 =         spiImpl.engineCreateSSLEngine();
        varCD10BF3495E7A8E52EEE8B2C72D42FD5_907377943.addTaint(taint);
        return varCD10BF3495E7A8E52EEE8B2C72D42FD5_907377943;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.823 -0400", hash_original_method = "4AC4A8F933626C577BD77D72E35BEF87", hash_generated_method = "F5F1F299B838D2C57567A32C253DB0CB")
    public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        addTaint(peerPort);
        addTaint(peerHost.getTaint());
SSLEngine var1A76A595CAF981399E8C7C474C6E2206_294115325 =         spiImpl.engineCreateSSLEngine(peerHost, peerPort);
        var1A76A595CAF981399E8C7C474C6E2206_294115325.addTaint(taint);
        return var1A76A595CAF981399E8C7C474C6E2206_294115325;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.823 -0400", hash_original_method = "13CFBFF97EBEA17DB24F1E636C863192", hash_generated_method = "DA6F8C1EE237AB3E338F3F2077C14098")
    public final SSLSessionContext getServerSessionContext() {
SSLSessionContext var59E3C7B53100428E09253F19A434260D_1499047124 =         spiImpl.engineGetServerSessionContext();
        var59E3C7B53100428E09253F19A434260D_1499047124.addTaint(taint);
        return var59E3C7B53100428E09253F19A434260D_1499047124;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.823 -0400", hash_original_method = "ECC6F07A2C60018ED286E62595778908", hash_generated_method = "FB89E31AD6FB09ECB28EF253649DEC62")
    public final SSLSessionContext getClientSessionContext() {
SSLSessionContext varB643B89BF4ED54EBAC6544846113C8F8_1162510885 =         spiImpl.engineGetClientSessionContext();
        varB643B89BF4ED54EBAC6544846113C8F8_1162510885.addTaint(taint);
        return varB643B89BF4ED54EBAC6544846113C8F8_1162510885;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.824 -0400", hash_original_method = "EF50F11BBBC92F54F2BB8CD8681E5FD1", hash_generated_method = "E275F9656D3ACE3F91A4E8570141FBF6")
    public final SSLParameters getDefaultSSLParameters() {
SSLParameters varB426CDA0AACA982014D2DC2AF001398D_308829526 =         spiImpl.engineGetDefaultSSLParameters();
        varB426CDA0AACA982014D2DC2AF001398D_308829526.addTaint(taint);
        return varB426CDA0AACA982014D2DC2AF001398D_308829526;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.824 -0400", hash_original_method = "B61455860318644024B430BCDF123BB8", hash_generated_method = "4EF9CF455ADD14672B7E26722C65DEDA")
    public final SSLParameters getSupportedSSLParameters() {
SSLParameters varA10A0D98761882C3BD5659C2844BAF6F_1832744141 =         spiImpl.engineGetSupportedSSLParameters();
        varA10A0D98761882C3BD5659C2844BAF6F_1832744141.addTaint(taint);
        return varA10A0D98761882C3BD5659C2844BAF6F_1832744141;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.824 -0400", hash_original_field = "CB44F3776B2B98508777FFCDA5461DA4", hash_generated_field = "F9968588171E1F6215F8BDC43FEE8F36")

    private static final String SERVICE = "SSLContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.824 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.824 -0400", hash_original_field = "5B39C8B553C821E7CDDC6DA64B5BD2EE", hash_generated_field = "2B7DA749EDE2455861561266A5813438")

    private static SSLContext DEFAULT;
}

