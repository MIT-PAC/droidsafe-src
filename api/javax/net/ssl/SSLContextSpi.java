package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.SecureRandom;





public abstract class SSLContextSpi {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.676 -0400", hash_original_method = "C071A8DB81BAA2AB9BA30E20CDF7E4D3", hash_generated_method = "540369CB178536FB780D6C1CC0EB32F7")
    public  SSLContextSpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(KeyManager[] km, TrustManager[] tm, SecureRandom sr)
            throws KeyManagementException;

    
    @DSModeled(DSC.SAFE)
    protected abstract SSLSocketFactory engineGetSocketFactory();

    
    @DSModeled(DSC.SAFE)
    protected abstract SSLServerSocketFactory engineGetServerSocketFactory();

    
    @DSModeled(DSC.SAFE)
    protected abstract SSLEngine engineCreateSSLEngine(String host, int port);

    
    @DSModeled(DSC.SAFE)
    protected abstract SSLEngine engineCreateSSLEngine();

    
    @DSModeled(DSC.SAFE)
    protected abstract SSLSessionContext engineGetServerSessionContext();

    
    @DSModeled(DSC.SAFE)
    protected abstract SSLSessionContext engineGetClientSessionContext();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.678 -0400", hash_original_method = "38369B007DD3DFBC2F17B36F6861DA09", hash_generated_method = "4B1320EE5532E7833AAA253CD56F0C28")
    protected javax.net.ssl.SSLParameters engineGetDefaultSSLParameters() {
javax.net.ssl.SSLParameters var0D24C82A180A38AA13BFD398679AE174_468131076 =         createSSLParameters(false);
        var0D24C82A180A38AA13BFD398679AE174_468131076.addTaint(taint);
        return var0D24C82A180A38AA13BFD398679AE174_468131076;
        // ---------- Original Method ----------
        //return createSSLParameters(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.678 -0400", hash_original_method = "86210C07C6F5D2D352BAF9AB53AE79CE", hash_generated_method = "3ACD0A776DDE06BAF90B1ACB72137489")
    protected javax.net.ssl.SSLParameters engineGetSupportedSSLParameters() {
javax.net.ssl.SSLParameters varFE76CDC4E3DE17434647E2DDA62A2469_1739572272 =         createSSLParameters(true);
        varFE76CDC4E3DE17434647E2DDA62A2469_1739572272.addTaint(taint);
        return varFE76CDC4E3DE17434647E2DDA62A2469_1739572272;
        // ---------- Original Method ----------
        //return createSSLParameters(true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.679 -0400", hash_original_method = "511D5113A1843E08B751FF4FDB4F02E4", hash_generated_method = "E8E626D7AA884C3764AAAF0B3C5E2EFE")
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
javax.net.ssl.SSLParameters var74E4690D9F2A026504928C017944E149_987211852 =             p;
            var74E4690D9F2A026504928C017944E149_987211852.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_987211852;
        } //End block
        catch (IOException e)
        {
            UnsupportedOperationException varE5FD55B20B4036F962796E854825EB0C_763853301 = new UnsupportedOperationException("Could not access supported SSL parameters");
            varE5FD55B20B4036F962796E854825EB0C_763853301.addTaint(taint);
            throw varE5FD55B20B4036F962796E854825EB0C_763853301;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

