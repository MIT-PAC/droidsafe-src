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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.593 -0400", hash_original_method = "C071A8DB81BAA2AB9BA30E20CDF7E4D3", hash_generated_method = "540369CB178536FB780D6C1CC0EB32F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.595 -0400", hash_original_method = "38369B007DD3DFBC2F17B36F6861DA09", hash_generated_method = "A53316C9D13B29B2183A4EA0ABBBD63A")
    protected javax.net.ssl.SSLParameters engineGetDefaultSSLParameters() {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_60797823 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_60797823 = createSSLParameters(false);
        varB4EAC82CA7396A68D541C85D26508E83_60797823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_60797823;
        // ---------- Original Method ----------
        //return createSSLParameters(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.595 -0400", hash_original_method = "86210C07C6F5D2D352BAF9AB53AE79CE", hash_generated_method = "94324C0C306D0384A2880E320F0A07C5")
    protected javax.net.ssl.SSLParameters engineGetSupportedSSLParameters() {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1777360617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1777360617 = createSSLParameters(true);
        varB4EAC82CA7396A68D541C85D26508E83_1777360617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1777360617;
        // ---------- Original Method ----------
        //return createSSLParameters(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.596 -0400", hash_original_method = "511D5113A1843E08B751FF4FDB4F02E4", hash_generated_method = "E041BB198E88EDBEFDFB1E0B3380FFA7")
    private javax.net.ssl.SSLParameters createSSLParameters(boolean supported) {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_286216490 = null; //Variable for return #1
        try 
        {
            SSLSocket s = (SSLSocket) engineGetSocketFactory().createSocket();
            javax.net.ssl.SSLParameters p = new javax.net.ssl.SSLParameters();
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
            varB4EAC82CA7396A68D541C85D26508E83_286216490 = p;
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Could not access supported SSL parameters");
        } //End block
        addTaint(supported);
        varB4EAC82CA7396A68D541C85D26508E83_286216490.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_286216490;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

