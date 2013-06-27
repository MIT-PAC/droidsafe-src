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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.169 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.169 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.179 -0400", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "979538191227C77E80CD6A7FCD22681F")
    public  OpenSSLSocketFactoryImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.179 -0400", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "F977EBEDD1EBB8F226355D7FF351DF06")
    public  OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.180 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "0086BCC2CD8C3156B518E7D882B3A57F")
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1828604138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1828604138 = NativeCrypto.getDefaultCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1828604138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1828604138;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.180 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "044D2161E9214AD18163C2016E629370")
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2141991750 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2141991750 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_2141991750.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2141991750;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.181 -0400", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "13FB96FF1C1C28B1408C4A37B76454C4")
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_388210733 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_388210733 = new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_388210733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388210733;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.189 -0400", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "639DFF917F8F4DC762347C9DD12F73D0")
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_262980673 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_262980673 = new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_262980673.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262980673;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.211 -0400", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "A76C6CF22C22B8BAE655159D7E728E0A")
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1048540125 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1048540125 = new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1048540125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048540125;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host,
                                     //port,
                                     //localHost,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.212 -0400", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "DBA7F23CB00117566E554D2B2C695891")
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2102640870 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2102640870 = new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_2102640870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2102640870;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.215 -0400", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "A8143FB56868324153F508C5D57A2C55")
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_683447805 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_683447805 = new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_683447805.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_683447805;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(address,
                                     //port,
                                     //localAddress,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.215 -0400", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "B665CD6D3E64BB8DD4E5B3871F706388")
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_276813054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_276813054 = new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone());
        addTaint(s.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        varB4EAC82CA7396A68D541C85D26508E83_276813054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_276813054;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImplWrapper(s,
                                            //host,
                                            //port,
                                            //autoClose,
                                            //(SSLParametersImpl) sslParameters.clone());
    }

    
}

