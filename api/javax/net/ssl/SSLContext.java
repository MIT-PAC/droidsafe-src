package javax.net.ssl;

// Droidsafe Imports
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

import org.apache.harmony.security.fortress.Engine;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SSLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.657 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.657 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "35670434E65BDBAFCC16200249E01B00")

    private SSLContextSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.657 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.658 -0400", hash_original_method = "C804D9011355FC1C1182E28B9F55F9CC", hash_generated_method = "088B0261D1EFCD8A932AF0AD4ED02EB8")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.660 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "6766F640C3ED7E37C90737EC0D67C5A4")
    public final String getProtocol() {
String varDD56EE388A0FA5696BF9686AC14D2DB9_1743735854 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_1743735854.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_1743735854;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.661 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "C6F3E9C85372A0C4582761018BBE2261")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1853891129 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1853891129.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1853891129;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.661 -0400", hash_original_method = "862C6735087482F43EE162F8A0522BCE", hash_generated_method = "9DB40518B1CA450F0326073A8F9BE4F8")
    public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException {
        addTaint(sr.getTaint());
        addTaint(tm[0].getTaint());
        addTaint(km[0].getTaint());
        spiImpl.engineInit(km, tm, sr);
        // ---------- Original Method ----------
        //spiImpl.engineInit(km, tm, sr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.661 -0400", hash_original_method = "B0765B951456A1F8D049DA95DEF67C61", hash_generated_method = "BAB4A9BB7709BE7446D49C8FF648C0D9")
    public final SSLSocketFactory getSocketFactory() {
SSLSocketFactory var2D18C46B5E469E561E5021C32B0BF794_1294578107 =         spiImpl.engineGetSocketFactory();
        var2D18C46B5E469E561E5021C32B0BF794_1294578107.addTaint(taint);
        return var2D18C46B5E469E561E5021C32B0BF794_1294578107;
        // ---------- Original Method ----------
        //return spiImpl.engineGetSocketFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.662 -0400", hash_original_method = "6B854724B17F4BE278032C18BCD40494", hash_generated_method = "CA2A1FE92DCC61560F6DA55C7657632C")
    public final SSLServerSocketFactory getServerSocketFactory() {
SSLServerSocketFactory var7E9BC44DA92239FF15F8006EC182721D_846160262 =         spiImpl.engineGetServerSocketFactory();
        var7E9BC44DA92239FF15F8006EC182721D_846160262.addTaint(taint);
        return var7E9BC44DA92239FF15F8006EC182721D_846160262;
        // ---------- Original Method ----------
        //return spiImpl.engineGetServerSocketFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.662 -0400", hash_original_method = "9326AAD5FC0B444F9C3CCC582EB8A84C", hash_generated_method = "4DA4AE5B7FA5F5942D35BFEF25DF8E78")
    public final SSLEngine createSSLEngine() {
SSLEngine varCD10BF3495E7A8E52EEE8B2C72D42FD5_905082884 =         spiImpl.engineCreateSSLEngine();
        varCD10BF3495E7A8E52EEE8B2C72D42FD5_905082884.addTaint(taint);
        return varCD10BF3495E7A8E52EEE8B2C72D42FD5_905082884;
        // ---------- Original Method ----------
        //return spiImpl.engineCreateSSLEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.662 -0400", hash_original_method = "4AC4A8F933626C577BD77D72E35BEF87", hash_generated_method = "181CB316045F0B4DD7F010D8C1B9EDB2")
    public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        addTaint(peerPort);
        addTaint(peerHost.getTaint());
SSLEngine var1A76A595CAF981399E8C7C474C6E2206_939520339 =         spiImpl.engineCreateSSLEngine(peerHost, peerPort);
        var1A76A595CAF981399E8C7C474C6E2206_939520339.addTaint(taint);
        return var1A76A595CAF981399E8C7C474C6E2206_939520339;
        // ---------- Original Method ----------
        //return spiImpl.engineCreateSSLEngine(peerHost, peerPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.663 -0400", hash_original_method = "13CFBFF97EBEA17DB24F1E636C863192", hash_generated_method = "5A67C8A4A7728D40C039BD823395D1B6")
    public final SSLSessionContext getServerSessionContext() {
SSLSessionContext var59E3C7B53100428E09253F19A434260D_634818378 =         spiImpl.engineGetServerSessionContext();
        var59E3C7B53100428E09253F19A434260D_634818378.addTaint(taint);
        return var59E3C7B53100428E09253F19A434260D_634818378;
        // ---------- Original Method ----------
        //return spiImpl.engineGetServerSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.663 -0400", hash_original_method = "ECC6F07A2C60018ED286E62595778908", hash_generated_method = "04257303673351A680014D96A31A7F4F")
    public final SSLSessionContext getClientSessionContext() {
SSLSessionContext varB643B89BF4ED54EBAC6544846113C8F8_1676023092 =         spiImpl.engineGetClientSessionContext();
        varB643B89BF4ED54EBAC6544846113C8F8_1676023092.addTaint(taint);
        return varB643B89BF4ED54EBAC6544846113C8F8_1676023092;
        // ---------- Original Method ----------
        //return spiImpl.engineGetClientSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.663 -0400", hash_original_method = "EF50F11BBBC92F54F2BB8CD8681E5FD1", hash_generated_method = "5E65488326509216916F2F94D8470417")
    public final SSLParameters getDefaultSSLParameters() {
SSLParameters varB426CDA0AACA982014D2DC2AF001398D_2109918850 =         spiImpl.engineGetDefaultSSLParameters();
        varB426CDA0AACA982014D2DC2AF001398D_2109918850.addTaint(taint);
        return varB426CDA0AACA982014D2DC2AF001398D_2109918850;
        // ---------- Original Method ----------
        //return spiImpl.engineGetDefaultSSLParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.663 -0400", hash_original_method = "B61455860318644024B430BCDF123BB8", hash_generated_method = "CB38EB3FBB3D73F8F2F239A603F462DD")
    public final SSLParameters getSupportedSSLParameters() {
SSLParameters varA10A0D98761882C3BD5659C2844BAF6F_1515027454 =         spiImpl.engineGetSupportedSSLParameters();
        varA10A0D98761882C3BD5659C2844BAF6F_1515027454.addTaint(taint);
        return varA10A0D98761882C3BD5659C2844BAF6F_1515027454;
        // ---------- Original Method ----------
        //return spiImpl.engineGetSupportedSSLParameters();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.664 -0400", hash_original_field = "CB44F3776B2B98508777FFCDA5461DA4", hash_generated_field = "F9968588171E1F6215F8BDC43FEE8F36")

    private static final String SERVICE = "SSLContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.664 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.664 -0400", hash_original_field = "5B39C8B553C821E7CDDC6DA64B5BD2EE", hash_generated_field = "2B7DA749EDE2455861561266A5813438")

    private static SSLContext DEFAULT;
}

