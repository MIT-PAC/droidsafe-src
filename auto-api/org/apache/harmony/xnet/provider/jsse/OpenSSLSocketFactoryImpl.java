package org.apache.harmony.xnet.provider.jsse;

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
import java.security.KeyManagementException;

public class OpenSSLSocketFactoryImpl extends javax.net.ssl.SSLSocketFactory {
    private SSLParametersImpl sslParameters;
    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.904 -0400", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "979538191227C77E80CD6A7FCD22681F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OpenSSLSocketFactoryImpl() {
        SSLParametersImpl sslParametersLocal;
        sslParametersLocal = null;
        IOException instantiationExceptionLocal;
        instantiationExceptionLocal = null;
        try 
        {
            sslParametersLocal = SSLParametersImpl.getDefault();
        } //End block
        catch (KeyManagementException e)
        {
            instantiationExceptionLocal = new IOException("Delayed instantiation exception:");
            instantiationExceptionLocal.initCause(e);
        } //End block
        this.sslParameters = sslParametersLocal;
        this.instantiationException = instantiationExceptionLocal;
        // ---------- Original Method ----------
        //SSLParametersImpl sslParametersLocal = null;
        //IOException instantiationExceptionLocal = null;
        //try {
            //sslParametersLocal = SSLParametersImpl.getDefault();
        //} catch (KeyManagementException e) {
            //instantiationExceptionLocal = new IOException("Delayed instantiation exception:");
            //instantiationExceptionLocal.initCause(e);
        //}
        //this.sslParameters = sslParametersLocal;
        //this.instantiationException = instantiationExceptionLocal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.904 -0400", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "A90C64F5236D9C5B33917F6464591504")
    @DSModeled(DSC.SAFE)
    public OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        dsTaint.addTaint(sslParameters.dsTaint);
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.904 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "EFB9A46FFFABB22615BA00319D7847E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getDefaultCipherSuites() {
        String[] varF7015EEB50403F5EADC161F0F4BD6399_1425856075 = (NativeCrypto.getDefaultCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.904 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "12F70270157B67AB6DE49FBCBD80CCE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getSupportedCipherSuites() {
        String[] var4A8488CAA4D902DCFD3A82F559450276_1934862865 = (NativeCrypto.getSupportedCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.904 -0400", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "215DB5C079576F72047319252FA1F884")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket varC9A6E14FBAE1D8D0C6075E5A1CB8C1F8_436349362 = (new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.905 -0400", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "05B425C23ED94AD5E51548BDFB6B4AC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        Socket varF15EF8C2195E31B3BDB2AEF045BFB47A_1470319401 = (new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.905 -0400", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "5CFEACCD507285EBFFC52BE111042664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(localHost.dsTaint);
        Socket var57CA04A1C4B6C1DD072BCA0FF97A98DE_1098493344 = (new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host,
                                     //port,
                                     //localHost,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.905 -0400", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "D0FF2C3BF141A38963DD7D5A853BED7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        Socket varF15EF8C2195E31B3BDB2AEF045BFB47A_712613588 = (new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.905 -0400", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "838F0A72EAB41ED73761B986DA1FAFEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        Socket var550A954FD79EB499786815405AA8EAC9_1091535814 = (new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(address,
                                     //port,
                                     //localAddress,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.905 -0400", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "0FBF8D8809A1985FA348BD6E9B59B018")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(autoClose);
        Socket varBF6C1426C65E182D868B08E8D10C0107_2094933455 = (new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLSocketImplWrapper(s,
                                            //host,
                                            //port,
                                            //autoClose,
                                            //(SSLParametersImpl) sslParameters.clone());
    }

    
}

