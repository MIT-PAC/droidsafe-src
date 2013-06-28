package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class SSLSocket extends Socket {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.713 -0400", hash_original_method = "65A9306BD8ABF19429A09B81D2DB8751", hash_generated_method = "EAC140E24487698B2C738A891B9338D9")
    protected  SSLSocket() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.714 -0400", hash_original_method = "7A9B2251249D4A1F85A734BE270C0240", hash_generated_method = "A05317DE74A37DDA944D1FD20FAA024D")
    protected  SSLSocket(String host, int port) throws IOException, UnknownHostException {
        super(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.714 -0400", hash_original_method = "E1BBFC80ACA37B77A62FE55F8E5644EC", hash_generated_method = "7F36E05403F9E86F3329BD5895E2F0D3")
    protected  SSLSocket(InetAddress address, int port) throws IOException {
        super(address, port);
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.715 -0400", hash_original_method = "A98E3D3F4703F52B86E74E8B006B047C", hash_generated_method = "FED958774A415770B0B38EF6C57EF3EB")
    protected  SSLSocket(String host, int port, InetAddress clientAddress, int clientPort) throws IOException, UnknownHostException {
        super(host, port, clientAddress, clientPort);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(clientAddress.getTaint());
        addTaint(clientPort);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.715 -0400", hash_original_method = "0B70D3C7F543DCBA51EA559CD021E805", hash_generated_method = "3B598DB59A2B3CA3B0F52F069A0001F5")
    protected  SSLSocket(InetAddress address, int port, InetAddress clientAddress, int clientPort) throws IOException {
        super(address, port, clientAddress, clientPort);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(clientAddress.getTaint());
        addTaint(clientPort);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.716 -0400", hash_original_method = "E0A9F4BE9C470EB91D47ECD4E4371B30", hash_generated_method = "C78BD42B3DB788C86DAF9FF9CD4891D9")
    @Override
    public void shutdownInput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.716 -0400", hash_original_method = "70C01DEF86829F68F838E9F8223EE1C9", hash_generated_method = "A9C78C87F0E2A81DCF09B8842676CE01")
    @Override
    public void shutdownOutput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.721 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "30A9BECA99D708220432172045E7588D")
    public SSLParameters getSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1107056829 = null; //Variable for return #1
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        varB4EAC82CA7396A68D541C85D26508E83_1107056829 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1107056829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1107056829;
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.722 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "22F2BBA240C996F62C93F57FC1940101")
    public void setSSLParameters(SSLParameters p) {
        String[] cipherSuites = p.getCipherSuites();
        {
            setEnabledCipherSuites(cipherSuites);
        } //End block
        String[] protocols = p.getProtocols();
        {
            setEnabledProtocols(protocols);
        } //End block
        {
            boolean var6D45BED7515FD6C0BD1ED2BAAE0F632B_1687319119 = (p.getNeedClientAuth());
            {
                setNeedClientAuth(true);
            } //End block
            {
                boolean var2FBA481A340F527F533722A37691A0E1_402199238 = (p.getWantClientAuth());
                {
                    setWantClientAuth(true);
                } //End block
                {
                    setWantClientAuth(false);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(p.getTaint());
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

