package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.SecureRandom;

public abstract class SSLContextSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.832 -0400", hash_original_method = "C071A8DB81BAA2AB9BA30E20CDF7E4D3", hash_generated_method = "540369CB178536FB780D6C1CC0EB32F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.834 -0400", hash_original_method = "38369B007DD3DFBC2F17B36F6861DA09", hash_generated_method = "9EAD4FD9B08BBF9C3C0087E095B6EE3D")
    protected javax.net.ssl.SSLParameters engineGetDefaultSSLParameters() {
javax.net.ssl.SSLParameters var0D24C82A180A38AA13BFD398679AE174_1912972933 =         createSSLParameters(false);
        var0D24C82A180A38AA13BFD398679AE174_1912972933.addTaint(taint);
        return var0D24C82A180A38AA13BFD398679AE174_1912972933;
        // ---------- Original Method ----------
        //return createSSLParameters(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.834 -0400", hash_original_method = "86210C07C6F5D2D352BAF9AB53AE79CE", hash_generated_method = "009369EE41D5EB1B6F8CB4CC45FBF365")
    protected javax.net.ssl.SSLParameters engineGetSupportedSSLParameters() {
javax.net.ssl.SSLParameters varFE76CDC4E3DE17434647E2DDA62A2469_571315456 =         createSSLParameters(true);
        varFE76CDC4E3DE17434647E2DDA62A2469_571315456.addTaint(taint);
        return varFE76CDC4E3DE17434647E2DDA62A2469_571315456;
        // ---------- Original Method ----------
        //return createSSLParameters(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.835 -0400", hash_original_method = "511D5113A1843E08B751FF4FDB4F02E4", hash_generated_method = "9F2196358A7FA9F18F2885F8784583E3")
    private javax.net.ssl.SSLParameters createSSLParameters(boolean supported) {
        addTaint(supported);
        try 
        {
            SSLSocket s = (SSLSocket) engineGetSocketFactory().createSocket();
            javax.net.ssl.SSLParameters p = new javax.net.ssl.SSLParameters();
            String[] cipherSuites;
            String[] protocols;
    if(supported)            
            {
                cipherSuites = s.getSupportedCipherSuites();
                protocols = s.getSupportedProtocols();
            } //End block
            else
            {
                cipherSuites = s.getEnabledCipherSuites();
                protocols = s.getEnabledProtocols();
            } //End block
            p.setCipherSuites(cipherSuites);
            p.setProtocols(protocols);
            p.setNeedClientAuth(s.getNeedClientAuth());
            p.setWantClientAuth(s.getWantClientAuth());
javax.net.ssl.SSLParameters var74E4690D9F2A026504928C017944E149_184850854 =             p;
            var74E4690D9F2A026504928C017944E149_184850854.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_184850854;
        } //End block
        catch (IOException e)
        {
            UnsupportedOperationException varE5FD55B20B4036F962796E854825EB0C_532410159 = new UnsupportedOperationException("Could not access supported SSL parameters");
            varE5FD55B20B4036F962796E854825EB0C_532410159.addTaint(taint);
            throw varE5FD55B20B4036F962796E854825EB0C_532410159;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

