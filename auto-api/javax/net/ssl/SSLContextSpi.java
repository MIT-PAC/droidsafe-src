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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.247 -0400", hash_original_method = "C071A8DB81BAA2AB9BA30E20CDF7E4D3", hash_generated_method = "540369CB178536FB780D6C1CC0EB32F7")
    public  SSLContextSpi() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.253 -0400", hash_original_method = "38369B007DD3DFBC2F17B36F6861DA09", hash_generated_method = "294F68BE1AE046D6940576268B193F34")
    protected javax.net.ssl.SSLParameters engineGetDefaultSSLParameters() {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1703829155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1703829155 = createSSLParameters(false);
        varB4EAC82CA7396A68D541C85D26508E83_1703829155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703829155;
        // ---------- Original Method ----------
        //return createSSLParameters(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.256 -0400", hash_original_method = "86210C07C6F5D2D352BAF9AB53AE79CE", hash_generated_method = "A02CE5C4926A4229864892329F9D66A4")
    protected javax.net.ssl.SSLParameters engineGetSupportedSSLParameters() {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_200564123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_200564123 = createSSLParameters(true);
        varB4EAC82CA7396A68D541C85D26508E83_200564123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_200564123;
        // ---------- Original Method ----------
        //return createSSLParameters(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.264 -0400", hash_original_method = "511D5113A1843E08B751FF4FDB4F02E4", hash_generated_method = "990D14BED1F182BF57BD7AFFEB01B760")
    private javax.net.ssl.SSLParameters createSSLParameters(boolean supported) {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1526508938 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1526508938 = p;
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Could not access supported SSL parameters");
        } //End block
        addTaint(supported);
        varB4EAC82CA7396A68D541C85D26508E83_1526508938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1526508938;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

