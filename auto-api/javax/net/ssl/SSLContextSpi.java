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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.602 -0400", hash_original_method = "C071A8DB81BAA2AB9BA30E20CDF7E4D3", hash_generated_method = "540369CB178536FB780D6C1CC0EB32F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.605 -0400", hash_original_method = "38369B007DD3DFBC2F17B36F6861DA09", hash_generated_method = "8795FA3A45FF71888AFF2A06A1275614")
    protected javax.net.ssl.SSLParameters engineGetDefaultSSLParameters() {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_241838325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_241838325 = createSSLParameters(false);
        varB4EAC82CA7396A68D541C85D26508E83_241838325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_241838325;
        // ---------- Original Method ----------
        //return createSSLParameters(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.616 -0400", hash_original_method = "86210C07C6F5D2D352BAF9AB53AE79CE", hash_generated_method = "F66B606FE8FD4A7F9DBAD0976CD0F176")
    protected javax.net.ssl.SSLParameters engineGetSupportedSSLParameters() {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_871414418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_871414418 = createSSLParameters(true);
        varB4EAC82CA7396A68D541C85D26508E83_871414418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_871414418;
        // ---------- Original Method ----------
        //return createSSLParameters(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.636 -0400", hash_original_method = "511D5113A1843E08B751FF4FDB4F02E4", hash_generated_method = "764305559E05C323E527CFA3EE0066C5")
    private javax.net.ssl.SSLParameters createSSLParameters(boolean supported) {
        javax.net.ssl.SSLParameters varB4EAC82CA7396A68D541C85D26508E83_239582487 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_239582487 = p;
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Could not access supported SSL parameters");
        } //End block
        addTaint(supported);
        varB4EAC82CA7396A68D541C85D26508E83_239582487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_239582487;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

