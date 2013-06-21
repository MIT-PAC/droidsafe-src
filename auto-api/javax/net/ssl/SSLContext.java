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
    private Provider provider;
    private SSLContextSpi spiImpl;
    private String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.067 -0400", hash_original_method = "C804D9011355FC1C1182E28B9F55F9CC", hash_generated_method = "38373BAEBAAED219E7D52E1CC01C0668")
    @DSModeled(DSC.SAFE)
    protected SSLContext(SSLContextSpi contextSpi, Provider provider, String protocol) {
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(contextSpi.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.067 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "DC32C5EEACC304582BCCFD347646592D")
    @DSModeled(DSC.SAFE)
    public final String getProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "862C6735087482F43EE162F8A0522BCE", hash_generated_method = "BE240DF602E0FC7336C603DC058EA2EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException {
        dsTaint.addTaint(tm[0].dsTaint);
        dsTaint.addTaint(sr.dsTaint);
        dsTaint.addTaint(km[0].dsTaint);
        spiImpl.engineInit(km, tm, sr);
        // ---------- Original Method ----------
        //spiImpl.engineInit(km, tm, sr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "B0765B951456A1F8D049DA95DEF67C61", hash_generated_method = "53F6D329195912092B3ABE9C94DC2C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLSocketFactory getSocketFactory() {
        SSLSocketFactory var1E9FBF434873019161CF09FD84A56BF6_1639585686 = (spiImpl.engineGetSocketFactory());
        return (SSLSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetSocketFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "6B854724B17F4BE278032C18BCD40494", hash_generated_method = "0BA264AFB4B7A877D193DA7034684EAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLServerSocketFactory getServerSocketFactory() {
        SSLServerSocketFactory varCF012220C869DC9DD713CEF78D01060E_746854119 = (spiImpl.engineGetServerSocketFactory());
        return (SSLServerSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetServerSocketFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "9326AAD5FC0B444F9C3CCC582EB8A84C", hash_generated_method = "BA0F5CE02BCBC737BC93A861B6273969")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLEngine createSSLEngine() {
        SSLEngine varFC6CA54386735A5102BA8BAF9835EDAB_683002701 = (spiImpl.engineCreateSSLEngine());
        return (SSLEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineCreateSSLEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "4AC4A8F933626C577BD77D72E35BEF87", hash_generated_method = "92D15DD5A2CEA523500BBDFAD482D583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLEngine createSSLEngine(String peerHost, int peerPort) {
        dsTaint.addTaint(peerHost);
        dsTaint.addTaint(peerPort);
        SSLEngine var19F2C698210ECA03A551CDEBF5BF4179_1401002276 = (spiImpl.engineCreateSSLEngine(peerHost, peerPort));
        return (SSLEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineCreateSSLEngine(peerHost, peerPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.068 -0400", hash_original_method = "13CFBFF97EBEA17DB24F1E636C863192", hash_generated_method = "C8900E8F72DE6B4E09AE077EF11E3882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLSessionContext getServerSessionContext() {
        SSLSessionContext var5AEB6854221E3D55B698F8621A26D804_1981161660 = (spiImpl.engineGetServerSessionContext());
        return (SSLSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetServerSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.069 -0400", hash_original_method = "ECC6F07A2C60018ED286E62595778908", hash_generated_method = "F24659961AD7A0146C62E204BB41012A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLSessionContext getClientSessionContext() {
        SSLSessionContext varD6759B73797C016CC35D143B05CE93E5_277898028 = (spiImpl.engineGetClientSessionContext());
        return (SSLSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetClientSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.069 -0400", hash_original_method = "EF50F11BBBC92F54F2BB8CD8681E5FD1", hash_generated_method = "F365D8111E23C67C3493C4D4A3EB2AAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLParameters getDefaultSSLParameters() {
        SSLParameters var982E3DF8948FA16BD7F0B05F21C3BCE9_1329061881 = (spiImpl.engineGetDefaultSSLParameters());
        return (SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetDefaultSSLParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.069 -0400", hash_original_method = "B61455860318644024B430BCDF123BB8", hash_generated_method = "117FF7C598C299B8BF84D61D41579D1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SSLParameters getSupportedSSLParameters() {
        SSLParameters varCA9CE1C984980E3F9D94AB62EB057FC8_1216613938 = (spiImpl.engineGetSupportedSSLParameters());
        return (SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return spiImpl.engineGetSupportedSSLParameters();
    }

    
    private static final String SERVICE = "SSLContext";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static SSLContext DEFAULT;
}

