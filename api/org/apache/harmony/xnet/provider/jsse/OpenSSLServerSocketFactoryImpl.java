package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class OpenSSLServerSocketFactoryImpl extends javax.net.ssl.SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.734 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.734 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.734 -0400", hash_original_method = "661B740306EF729B03E756D73006DD97", hash_generated_method = "2AF29500DDD1D89149A1220D74460495")
    public  OpenSSLServerSocketFactoryImpl() {
        try 
        {
            this.sslParameters = SSLParametersImpl.getDefault();
            this.sslParameters.setUseClientMode(false);
        } //End block
        catch (KeyManagementException e)
        {
            instantiationException =
                new IOException("Delayed instantiation exception:");
            instantiationException.initCause(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.sslParameters = SSLParametersImpl.getDefault();
            //this.sslParameters.setUseClientMode(false);
        //} catch (KeyManagementException e) {
            //instantiationException =
                //new IOException("Delayed instantiation exception:");
            //instantiationException.initCause(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.734 -0400", hash_original_method = "6C0182FC3112F46DBF9FF9E1060447FC", hash_generated_method = "136A929783A39ECF3122E80B18483D9B")
    public  OpenSSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.735 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "5F14D71B3FD06AAFECF5CAFD95CC4FC0")
    public String[] getDefaultCipherSuites() {
String[] var82D10C47ABE9DD1DDD091B4BC41FC622_1418083758 =         NativeCrypto.getDefaultCipherSuites();
        var82D10C47ABE9DD1DDD091B4BC41FC622_1418083758.addTaint(taint);
        return var82D10C47ABE9DD1DDD091B4BC41FC622_1418083758;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.735 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "381948872C877C0F493729F1994E3086")
    public String[] getSupportedCipherSuites() {
String[] var0633111015CD199BA68A1C170162F6EA_1174353635 =         NativeCrypto.getSupportedCipherSuites();
        var0633111015CD199BA68A1C170162F6EA_1174353635.addTaint(taint);
        return var0633111015CD199BA68A1C170162F6EA_1174353635;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.735 -0400", hash_original_method = "DD3C3F79E346D7A01595E9F060B2D5FB", hash_generated_method = "6A06B5418D6CBF28650E3D2341422B04")
    public ServerSocket createServerSocket() throws IOException {
ServerSocket varAB777A02E5E4EC7645631A6D6DB618E3_335315797 =         new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
        varAB777A02E5E4EC7645631A6D6DB618E3_335315797.addTaint(taint);
        return varAB777A02E5E4EC7645631A6D6DB618E3_335315797;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.735 -0400", hash_original_method = "4D548A9DDA0E958E6B561F7581D51C7D", hash_generated_method = "1C1DC1726CE455990FA7E3822A62A258")
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
ServerSocket varE20C8707972AA2E55EA91779119BA68D_48505830 =         new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone());
        varE20C8707972AA2E55EA91779119BA68D_48505830.addTaint(taint);
        return varE20C8707972AA2E55EA91779119BA68D_48505830;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.735 -0400", hash_original_method = "CC5D3001B29102E2FC7CEFEB262BA8A8", hash_generated_method = "450E4E65A2BBAAD55ABDEF4E8DD88FF1")
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
ServerSocket varCFB86758BDF5C04809F455AEB84F876F_1871132715 =         new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           (SSLParametersImpl) sslParameters.clone());
        varCFB86758BDF5C04809F455AEB84F876F_1871132715.addTaint(taint);
        return varCFB86758BDF5C04809F455AEB84F876F_1871132715;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port,
                                           //backlog,
                                           //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.735 -0400", hash_original_method = "978BD167D218C30F2EBF39FB52A220C5", hash_generated_method = "EA8612580FC6BCDBF5B4E7CCFD8926A8")
    public ServerSocket createServerSocket(int port,
                                           int backlog,
                                           InetAddress iAddress) throws IOException {
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
ServerSocket var2B649B4E6F13F47CF6D59BBABD7DE65E_1637638499 =         new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           iAddress,
                                           (SSLParametersImpl) sslParameters.clone());
        var2B649B4E6F13F47CF6D59BBABD7DE65E_1637638499.addTaint(taint);
        return var2B649B4E6F13F47CF6D59BBABD7DE65E_1637638499;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port,
                                           //backlog,
                                           //iAddress,
                                           //(SSLParametersImpl) sslParameters.clone());
    }

    
}

