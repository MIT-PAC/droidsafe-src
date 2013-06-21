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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.107 -0400", hash_original_method = "65A9306BD8ABF19429A09B81D2DB8751", hash_generated_method = "EAC140E24487698B2C738A891B9338D9")
    @DSModeled(DSC.SAFE)
    protected SSLSocket() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.107 -0400", hash_original_method = "7A9B2251249D4A1F85A734BE270C0240", hash_generated_method = "3CD36E238851CE6F8572B01D228A9748")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocket(String host, int port) throws IOException, UnknownHostException {
        super(host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.107 -0400", hash_original_method = "E1BBFC80ACA37B77A62FE55F8E5644EC", hash_generated_method = "515F156F85D40AC7C828631C0CCA31FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocket(InetAddress address, int port) throws IOException {
        super(address, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.107 -0400", hash_original_method = "A98E3D3F4703F52B86E74E8B006B047C", hash_generated_method = "D91E2D986605E9D5A78F5D658C8603C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocket(String host, int port, InetAddress clientAddress, int clientPort) throws IOException, UnknownHostException {
        super(host, port, clientAddress, clientPort);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(clientPort);
        dsTaint.addTaint(clientAddress.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.107 -0400", hash_original_method = "0B70D3C7F543DCBA51EA559CD021E805", hash_generated_method = "DAC1353910DE0785A113D4F565963996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLSocket(InetAddress address, int port, InetAddress clientAddress, int clientPort) throws IOException {
        super(address, port, clientAddress, clientPort);
        dsTaint.addTaint(port);
        dsTaint.addTaint(clientPort);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(clientAddress.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.108 -0400", hash_original_method = "E0A9F4BE9C470EB91D47ECD4E4371B30", hash_generated_method = "C78BD42B3DB788C86DAF9FF9CD4891D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void shutdownInput() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.108 -0400", hash_original_method = "70C01DEF86829F68F838E9F8223EE1C9", hash_generated_method = "A9C78C87F0E2A81DCF09B8842676CE01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.109 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "090A23B6E68C3753C70D33B64F3C5183")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLParameters getSSLParameters() {
        SSLParameters p;
        p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        return (SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.110 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "BF6D3CA4741B2CC1F6EA444DC48BBCE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSSLParameters(SSLParameters p) {
        dsTaint.addTaint(p.dsTaint);
        String[] cipherSuites;
        cipherSuites = p.getCipherSuites();
        {
            setEnabledCipherSuites(cipherSuites);
        } //End block
        String[] protocols;
        protocols = p.getProtocols();
        {
            setEnabledProtocols(protocols);
        } //End block
        {
            boolean var6D45BED7515FD6C0BD1ED2BAAE0F632B_955481149 = (p.getNeedClientAuth());
            {
                setNeedClientAuth(true);
            } //End block
            {
                boolean var2FBA481A340F527F533722A37691A0E1_535235367 = (p.getWantClientAuth());
                {
                    setWantClientAuth(true);
                } //End block
                {
                    setWantClientAuth(false);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

