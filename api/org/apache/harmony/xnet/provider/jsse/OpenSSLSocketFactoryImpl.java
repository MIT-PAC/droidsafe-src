package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;






public class OpenSSLSocketFactoryImpl extends javax.net.ssl.SSLSocketFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.338 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")


    private  SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.339 -0500", hash_original_field = "4B271BE77FE082BAEDB0CC3C06D67CEA", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private  IOException instantiationException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.340 -0500", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "E519A9E864F8B77F1FDD8245DAFBF33B")
    public OpenSSLSocketFactoryImpl() {
        SSLParametersImpl sslParametersLocal = null;
        IOException instantiationExceptionLocal = null;
        try {
            sslParametersLocal = SSLParametersImpl.getDefault();
        } catch (KeyManagementException e) {
            instantiationExceptionLocal = new IOException("Delayed instantiation exception:");
            instantiationExceptionLocal.initCause(e);
        }
        this.sslParameters = sslParametersLocal;
        this.instantiationException = instantiationExceptionLocal;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.341 -0500", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "F164B8732E5EE1B349AAB5031B49328B")
    public OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.342 -0500", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "9FD76030E98DF5EC3E130ABDB050FF21")
    public String[] getDefaultCipherSuites() {
        return NativeCrypto.getDefaultCipherSuites();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.342 -0500", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "F00706CA72F49A75DCD594C7E421B0AE")
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.343 -0500", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "7B1C7226CE81BA953CE437975B268D6F")
    public Socket createSocket() throws IOException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.344 -0500", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "93727CD85D6533BAB18FCD21617E57E3")
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.345 -0500", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "533CB9088932A524A3416171EA6F3BD4")
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException {
        return new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.346 -0500", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "9C048432C1AD71B955BCA12873552EE8")
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.347 -0500", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "259AF6BF85DBFB89A5A83DD9697DFB65")
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort)
            throws IOException {
        return new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:10.348 -0500", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "FC3466E18A80523D42C102FA35B68F64")
    public Socket createSocket(Socket s, String host, int port, boolean autoClose)
            throws IOException {
        return new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone());
    }

    
}

