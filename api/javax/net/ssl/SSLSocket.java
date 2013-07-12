package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class SSLSocket extends Socket {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.961 -0400", hash_original_method = "65A9306BD8ABF19429A09B81D2DB8751", hash_generated_method = "EAC140E24487698B2C738A891B9338D9")
    protected  SSLSocket() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.961 -0400", hash_original_method = "7A9B2251249D4A1F85A734BE270C0240", hash_generated_method = "EFD1BE3806F0F3EF8903B3BE533B9F7E")
    protected  SSLSocket(String host, int port) throws IOException, UnknownHostException {
        super(host, port);
        addTaint(port);
        addTaint(host.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.961 -0400", hash_original_method = "E1BBFC80ACA37B77A62FE55F8E5644EC", hash_generated_method = "A56A2FF4824D197F0E142A320DCA3543")
    protected  SSLSocket(InetAddress address, int port) throws IOException {
        super(address, port);
        addTaint(port);
        addTaint(address.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.962 -0400", hash_original_method = "A98E3D3F4703F52B86E74E8B006B047C", hash_generated_method = "141819BDDB2FEEB3CF5777BFF125B1C7")
    protected  SSLSocket(String host, int port, InetAddress clientAddress, int clientPort) throws IOException, UnknownHostException {
        super(host, port, clientAddress, clientPort);
        addTaint(clientPort);
        addTaint(clientAddress.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.962 -0400", hash_original_method = "0B70D3C7F543DCBA51EA559CD021E805", hash_generated_method = "2438CF150CC953A82F3616B29494AD20")
    protected  SSLSocket(InetAddress address, int port, InetAddress clientAddress, int clientPort) throws IOException {
        super(address, port, clientAddress, clientPort);
        addTaint(clientPort);
        addTaint(clientAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.962 -0400", hash_original_method = "E0A9F4BE9C470EB91D47ECD4E4371B30", hash_generated_method = "69DD64E09E5FB23B02CAF8AC09ADB34A")
    @Override
    public void shutdownInput() throws IOException {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1118327563 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1118327563.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1118327563;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.962 -0400", hash_original_method = "70C01DEF86829F68F838E9F8223EE1C9", hash_generated_method = "61DE2A83BA5688E5B67498132570AF2F")
    @Override
    public void shutdownOutput() throws IOException {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_686745982 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_686745982.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_686745982;
        
        
    }

    
    public abstract String[] getSupportedCipherSuites();

    
    public abstract String[] getEnabledCipherSuites();

    
    public abstract void setEnabledCipherSuites(String[] suites);

    
    public abstract String[] getSupportedProtocols();

    
    public abstract String[] getEnabledProtocols();

    
    public abstract void setEnabledProtocols(String[] protocols);

    
    public abstract SSLSession getSession();

    
    public abstract void addHandshakeCompletedListener(HandshakeCompletedListener listener);

    
    public abstract void removeHandshakeCompletedListener(HandshakeCompletedListener listener);

    
    public abstract void startHandshake() throws IOException;

    
    public abstract void setUseClientMode(boolean mode);

    
    public abstract boolean getUseClientMode();

    
    public abstract void setNeedClientAuth(boolean need);

    
    public abstract void setWantClientAuth(boolean want);

    
    public abstract boolean getNeedClientAuth();

    
    public abstract boolean getWantClientAuth();

    
    public abstract void setEnableSessionCreation(boolean flag);

    
    public abstract boolean getEnableSessionCreation();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.963 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "63C8D91FD9AE7C7A294CBE77E55446CE")
    public SSLParameters getSSLParameters() {
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
SSLParameters var74E4690D9F2A026504928C017944E149_1964446758 =         p;
        var74E4690D9F2A026504928C017944E149_1964446758.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1964446758;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.963 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "27EFFE024357E2EEA5E53D9F242DF898")
    public void setSSLParameters(SSLParameters p) {
        addTaint(p.getTaint());
        String[] cipherSuites = p.getCipherSuites();
    if(cipherSuites != null)        
        {
            setEnabledCipherSuites(cipherSuites);
        } 
        String[] protocols = p.getProtocols();
    if(protocols != null)        
        {
            setEnabledProtocols(protocols);
        } 
    if(p.getNeedClientAuth())        
        {
            setNeedClientAuth(true);
        } 
        else
    if(p.getWantClientAuth())        
        {
            setWantClientAuth(true);
        } 
        else
        {
            setWantClientAuth(false);
        } 
        
        
        
            
        
        
        
            
        
        
            
        
            
        
            
        
    }

    
}

