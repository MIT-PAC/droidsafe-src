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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.423 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.423 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.423 -0400", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "05D07D434E5984350F4E08FF662C3AFC")
    public  OpenSSLSocketFactoryImpl() {
        SSLParametersImpl sslParametersLocal = null;
        IOException instantiationExceptionLocal = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.424 -0400", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "F977EBEDD1EBB8F226355D7FF351DF06")
    public  OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.425 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "696EF195E0DD6FDB326BCE29540DF1E9")
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2129613893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2129613893 = NativeCrypto.getDefaultCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_2129613893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2129613893;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.425 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "140DC7D149C3B3A5E311FAD12159F66E")
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_419490168 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_419490168 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_419490168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_419490168;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.426 -0400", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "696B88829233EEEC5D88F3ADF6EDE0BF")
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_461913512 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_461913512 = new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_461913512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_461913512;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.426 -0400", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "1E3410253419A54B7C6372E56D4D0522")
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_671638856 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_671638856 = new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_671638856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_671638856;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.427 -0400", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "8B95BD3C273F8870C4636A6E51112455")
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1391793791 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1391793791 = new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1391793791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391793791;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host,
                                     //port,
                                     //localHost,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.428 -0400", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "D1AA6935EAB27C284338AE8E5C6A3828")
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_442879513 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_442879513 = new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_442879513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_442879513;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.429 -0400", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "EEEC5CB5CD0FF7450E554F8553F19119")
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_143226332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_143226332 = new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_143226332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_143226332;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(address,
                                     //port,
                                     //localAddress,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.430 -0400", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "D555D0F3A99FE633619B66CFDD93AE72")
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1414353404 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1414353404 = new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone());
        addTaint(s.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        varB4EAC82CA7396A68D541C85D26508E83_1414353404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1414353404;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImplWrapper(s,
                                            //host,
                                            //port,
                                            //autoClose,
                                            //(SSLParametersImpl) sslParameters.clone());
    }

    
}

