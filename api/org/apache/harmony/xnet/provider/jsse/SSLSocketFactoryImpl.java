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

import javax.net.ssl.SSLSocketFactory;

import libcore.util.EmptyArray;





public class SSLSocketFactoryImpl extends SSLSocketFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.117 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")


    private  SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.117 -0500", hash_original_field = "4B271BE77FE082BAEDB0CC3C06D67CEA", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private  IOException instantiationException;

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.118 -0500", hash_original_method = "3B70F1FB7142745DE6253CA770AA85DF", hash_generated_method = "9D44063F9C2F23EC5F27E497F6609A78")
    public SSLSocketFactoryImpl() {
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

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.119 -0500", hash_original_method = "BC2150A7C00CB445EF2AA02677D69C68", hash_generated_method = "62A56D1DC940FCC3E7AA4A3E633BDE64")
    protected SSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
    }

    /**
     * @see javax.net.ssl.SSLSocketFactory#getDefaultCipherSuites()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.120 -0500", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "F28A7F75D17BAB5AF6CF7A48106E8A68")
    @Override
public String[] getDefaultCipherSuites() {
        if (instantiationException != null) {
            return EmptyArray.STRING;
        }
        return sslParameters.getEnabledCipherSuites();
    }

    /**
     * @see javax.net.ssl.SSLSocketFactory#getSupportedCipherSuites()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.121 -0500", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "ADFA088456815838E904E8BFB04AE9AA")
    @Override
public String[] getSupportedCipherSuites() {
        if (instantiationException != null) {
            return EmptyArray.STRING;
        }
        return CipherSuite.getSupportedCipherSuiteNames();
    }

    /**
     * @see javax.net.ssl.SSLSocketFactory#createSocket(Socket,String,int,boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.122 -0500", hash_original_method = "770FADDB251D7948083EF0D02F3938EE", hash_generated_method = "47DB59EFC93728293397F19E50A6A0FF")
    @Override
public Socket createSocket(Socket s, String host, int port,
            boolean autoClose) throws IOException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                .clone());
    }

    // -------------- Methods inherided from SocketFactory --------------

    /**
     * @see javax.net.SocketFactory#createSocket()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.123 -0500", hash_original_method = "0CDA18BD18854D909AC84115F509C8F0", hash_generated_method = "5B384C3D5BC4EBB4D530E8B127FA82F4")
    @Override
public Socket createSocket() throws IOException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    /**
     * @see javax.net.SocketFactory#createSocket(String,int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.123 -0500", hash_original_method = "F68AAAAA9B8D61B174802E7029AF7953", hash_generated_method = "70E9C65BF222BBCD3CD112AD5F4E2D1A")
    @Override
public Socket createSocket(String host, int port)
            throws IOException, UnknownHostException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
    }

    /**
     * @see javax.net.SocketFactory#createSocket(String,int,InetAddress,int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.124 -0500", hash_original_method = "53A1989EA3FBEE45809A2C11EADE957A", hash_generated_method = "F5843F8C84E8E691449B80BB1D9E4567")
    @Override
public Socket createSocket(String host, int port,
            InetAddress localHost, int localPort) throws IOException,
            UnknownHostException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new SSLSocketImpl(host, port, localHost, localPort,
                (SSLParametersImpl) sslParameters.clone());
    }

    /**
     * @see javax.net.SocketFactory#createSocket(InetAddress,int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.126 -0500", hash_original_method = "FD8C4D4ADA3C87BB97218603199064D4", hash_generated_method = "1AFE2C8D3EC2179E5203862FF87C2433")
    @Override
public Socket createSocket(InetAddress host, int port)
            throws IOException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
    }

    /**
     * @see javax.net.SocketFactory#createSocket(InetAddress,int,InetAddress,int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.127 -0500", hash_original_method = "3B16D41EDAC8F54354185F57BF630F58", hash_generated_method = "1BD1606CF0A8D09533E3BE2AB84C5D75")
    @Override
public Socket createSocket(InetAddress address, int port,
            InetAddress localAddress, int localPort) throws IOException {
        if (instantiationException != null) {
            throw instantiationException;
        }
        return new SSLSocketImpl(address, port, localAddress, localPort,
                (SSLParametersImpl) sslParameters.clone());
    }

    
}

