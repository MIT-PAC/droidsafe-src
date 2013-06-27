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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.358 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.358 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.369 -0400", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "979538191227C77E80CD6A7FCD22681F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.369 -0400", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "F977EBEDD1EBB8F226355D7FF351DF06")
    public  OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.370 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "58D036282EA285CBAE2AD3745C0116BE")
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1086754296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1086754296 = NativeCrypto.getDefaultCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1086754296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1086754296;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.370 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "9A5D257300E5451DA40650FF06DB9904")
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_704644124 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_704644124 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_704644124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_704644124;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.371 -0400", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "7E1E7BC1E2DB1F58E5060BEA9F8B3C43")
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_649489290 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_649489290 = new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_649489290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649489290;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.371 -0400", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "8FEFAD79D6DB033BEB578D02EB0E3113")
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_112996351 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_112996351 = new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_112996351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_112996351;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.395 -0400", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "FB39FD0A3B523392FCFD2DD4EFF45260")
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2106659357 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2106659357 = new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_2106659357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2106659357;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host,
                                     //port,
                                     //localHost,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.395 -0400", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "EE054FC536CFCD7049524B74B6BD0C41")
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2005778782 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005778782 = new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_2005778782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005778782;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.396 -0400", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "210A6503B43A3B5FC37E6EDFCFA2BB68")
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1504282626 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1504282626 = new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1504282626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1504282626;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(address,
                                     //port,
                                     //localAddress,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.396 -0400", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "4F5CD515622A24054F52896FB5A9C6CD")
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1704325335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1704325335 = new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone());
        addTaint(s.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        varB4EAC82CA7396A68D541C85D26508E83_1704325335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1704325335;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImplWrapper(s,
                                            //host,
                                            //port,
                                            //autoClose,
                                            //(SSLParametersImpl) sslParameters.clone());
    }

    
}

