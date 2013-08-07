package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;





public abstract class SSLSocket extends Socket {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.805 -0400", hash_original_method = "65A9306BD8ABF19429A09B81D2DB8751", hash_generated_method = "EAC140E24487698B2C738A891B9338D9")
    protected  SSLSocket() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.805 -0400", hash_original_method = "7A9B2251249D4A1F85A734BE270C0240", hash_generated_method = "EFD1BE3806F0F3EF8903B3BE533B9F7E")
    protected  SSLSocket(String host, int port) throws IOException, UnknownHostException {
        super(host, port);
        addTaint(port);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.805 -0400", hash_original_method = "E1BBFC80ACA37B77A62FE55F8E5644EC", hash_generated_method = "A56A2FF4824D197F0E142A320DCA3543")
    protected  SSLSocket(InetAddress address, int port) throws IOException {
        super(address, port);
        addTaint(port);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.806 -0400", hash_original_method = "A98E3D3F4703F52B86E74E8B006B047C", hash_generated_method = "141819BDDB2FEEB3CF5777BFF125B1C7")
    protected  SSLSocket(String host, int port, InetAddress clientAddress, int clientPort) throws IOException, UnknownHostException {
        super(host, port, clientAddress, clientPort);
        addTaint(clientPort);
        addTaint(clientAddress.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.806 -0400", hash_original_method = "0B70D3C7F543DCBA51EA559CD021E805", hash_generated_method = "2438CF150CC953A82F3616B29494AD20")
    protected  SSLSocket(InetAddress address, int port, InetAddress clientAddress, int clientPort) throws IOException {
        super(address, port, clientAddress, clientPort);
        addTaint(clientPort);
        addTaint(clientAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.806 -0400", hash_original_method = "E0A9F4BE9C470EB91D47ECD4E4371B30", hash_generated_method = "421FB18D387B1BAE68D546296AB50702")
    @Override
    public void shutdownInput() throws IOException {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1746954287 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1746954287.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1746954287;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.807 -0400", hash_original_method = "70C01DEF86829F68F838E9F8223EE1C9", hash_generated_method = "A44E0503F6C6D6F8EDE36605174B1986")
    @Override
    public void shutdownOutput() throws IOException {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1767729649 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1767729649.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1767729649;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getSupportedCipherSuites();

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getEnabledCipherSuites();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEnabledCipherSuites(String[] suites);

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getSupportedProtocols();

    
    @DSModeled(DSC.SAFE)
    public abstract String[] getEnabledProtocols();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEnabledProtocols(String[] protocols);

    
    @DSModeled(DSC.SAFE)
    public abstract SSLSession getSession();

    
    @DSModeled(DSC.SAFE)
    public abstract void addHandshakeCompletedListener(HandshakeCompletedListener listener);

    
    @DSModeled(DSC.SAFE)
    public abstract void removeHandshakeCompletedListener(HandshakeCompletedListener listener);

    
    @DSModeled(DSC.SAFE)
    public abstract void startHandshake() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract void setUseClientMode(boolean mode);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getUseClientMode();

    
    @DSModeled(DSC.SAFE)
    public abstract void setNeedClientAuth(boolean need);

    
    @DSModeled(DSC.SAFE)
    public abstract void setWantClientAuth(boolean want);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getNeedClientAuth();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getWantClientAuth();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEnableSessionCreation(boolean flag);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getEnableSessionCreation();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.810 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "2B30451B0FDEF761B6E580BA2C6E71A9")
    public SSLParameters getSSLParameters() {
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
SSLParameters var74E4690D9F2A026504928C017944E149_683083298 =         p;
        var74E4690D9F2A026504928C017944E149_683083298.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_683083298;
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.810 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "27EFFE024357E2EEA5E53D9F242DF898")
    public void setSSLParameters(SSLParameters p) {
        addTaint(p.getTaint());
        String[] cipherSuites = p.getCipherSuites();
        if(cipherSuites != null)        
        {
            setEnabledCipherSuites(cipherSuites);
        } //End block
        String[] protocols = p.getProtocols();
        if(protocols != null)        
        {
            setEnabledProtocols(protocols);
        } //End block
        if(p.getNeedClientAuth())        
        {
            setNeedClientAuth(true);
        } //End block
        else
        if(p.getWantClientAuth())        
        {
            setWantClientAuth(true);
        } //End block
        else
        {
            setWantClientAuth(false);
        } //End block
        // ---------- Original Method ----------
        //String[] cipherSuites = p.getCipherSuites();
        //if (cipherSuites != null) {
            //setEnabledCipherSuites(cipherSuites);
        //}
        //String[] protocols = p.getProtocols();
        //if (protocols != null) {
            //setEnabledProtocols(protocols);
        //}
        //if (p.getNeedClientAuth()) {
            //setNeedClientAuth(true);
        //} else if (p.getWantClientAuth()) {
            //setWantClientAuth(true);
        //} else {
            //setWantClientAuth(false);
        //}
    }

    
}

