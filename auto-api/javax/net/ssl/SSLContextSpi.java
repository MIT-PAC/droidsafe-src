package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.SecureRandom;

public abstract class SSLContextSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.072 -0400", hash_original_method = "C071A8DB81BAA2AB9BA30E20CDF7E4D3", hash_generated_method = "540369CB178536FB780D6C1CC0EB32F7")
    @DSModeled(DSC.SAFE)
    public SSLContextSpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract void engineInit(KeyManager[] km, TrustManager[] tm, SecureRandom sr)
            throws KeyManagementException;

    
    protected abstract SSLSocketFactory engineGetSocketFactory();

    
    protected abstract SSLServerSocketFactory engineGetServerSocketFactory();

    
    protected abstract SSLEngine engineCreateSSLEngine(String host, int port);

    
    protected abstract SSLEngine engineCreateSSLEngine();

    
    protected abstract SSLSessionContext engineGetServerSessionContext();

    
    protected abstract SSLSessionContext engineGetClientSessionContext();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.073 -0400", hash_original_method = "38369B007DD3DFBC2F17B36F6861DA09", hash_generated_method = "3A2B12D96133BED7A3B63BF740BBEE60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected javax.net.ssl.SSLParameters engineGetDefaultSSLParameters() {
        javax.net.ssl.SSLParameters varA88690751E6E243921AF7C555FA73EAE_1004956081 = (createSSLParameters(false));
        return (javax.net.ssl.SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createSSLParameters(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.073 -0400", hash_original_method = "86210C07C6F5D2D352BAF9AB53AE79CE", hash_generated_method = "C43E1D8793818F5BA10739796B57A48C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected javax.net.ssl.SSLParameters engineGetSupportedSSLParameters() {
        javax.net.ssl.SSLParameters var9B4B3DA1FAEA114E873DD933F1EEB541_203093169 = (createSSLParameters(true));
        return (javax.net.ssl.SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createSSLParameters(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.073 -0400", hash_original_method = "511D5113A1843E08B751FF4FDB4F02E4", hash_generated_method = "E5BBEF0E30B552A9DF63C351975486A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private javax.net.ssl.SSLParameters createSSLParameters(boolean supported) {
        dsTaint.addTaint(supported);
        try 
        {
            SSLSocket s;
            s = (SSLSocket) engineGetSocketFactory().createSocket();
            javax.net.ssl.SSLParameters p;
            p = new javax.net.ssl.SSLParameters();
            String[] cipherSuites;
            String[] protocols;
            {
                cipherSuites = s.getSupportedCipherSuites();
                protocols = s.getSupportedProtocols();
            } //End block
            {
                cipherSuites = s.getEnabledCipherSuites();
                protocols = s.getEnabledProtocols();
            } //End block
            p.setCipherSuites(cipherSuites);
            p.setProtocols(protocols);
            p.setNeedClientAuth(s.getNeedClientAuth());
            p.setWantClientAuth(s.getWantClientAuth());
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Could not access supported SSL parameters");
        } //End block
        return (javax.net.ssl.SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

