package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;






public class OpenSSLSocketFactoryImpl extends javax.net.ssl.SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.865 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.865 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.866 -0400", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "05D07D434E5984350F4E08FF662C3AFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.867 -0400", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "F977EBEDD1EBB8F226355D7FF351DF06")
    public  OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.867 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "64FA7A0318C27BA2918C127BFD141B61")
    public String[] getDefaultCipherSuites() {
String[] var82D10C47ABE9DD1DDD091B4BC41FC622_397919770 =         NativeCrypto.getDefaultCipherSuites();
        var82D10C47ABE9DD1DDD091B4BC41FC622_397919770.addTaint(taint);
        return var82D10C47ABE9DD1DDD091B4BC41FC622_397919770;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.868 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "0CEE6D2CB3C54D50DEEE7D2C37E86FCE")
    public String[] getSupportedCipherSuites() {
String[] var0633111015CD199BA68A1C170162F6EA_264839186 =         NativeCrypto.getSupportedCipherSuites();
        var0633111015CD199BA68A1C170162F6EA_264839186.addTaint(taint);
        return var0633111015CD199BA68A1C170162F6EA_264839186;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.868 -0400", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "294E6C61D44A6F77DFDA64243C699A96")
    public Socket createSocket() throws IOException {
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket varB21EA82A3B7E560674E2865BCBD5375E_1267395092 =         new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB21EA82A3B7E560674E2865BCBD5375E_1267395092.addTaint(taint);
        return varB21EA82A3B7E560674E2865BCBD5375E_1267395092;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.868 -0400", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "6EB3AB60C5B1982D455EE6676A73446E")
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var63D456C6F0A907D6D02C7774FD1DD5AD_1505707013 =         new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        var63D456C6F0A907D6D02C7774FD1DD5AD_1505707013.addTaint(taint);
        return var63D456C6F0A907D6D02C7774FD1DD5AD_1505707013;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.869 -0400", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "C374913F7B77749D805994FC4BEDE39D")
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
Socket varD55A0D254F337F166D47150294048CDD_1935758856 =         new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        varD55A0D254F337F166D47150294048CDD_1935758856.addTaint(taint);
        return varD55A0D254F337F166D47150294048CDD_1935758856;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host,
                                     //port,
                                     //localHost,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.869 -0400", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "176D4E0936FBCEDB6B3DD1ACFE490C15")
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var63D456C6F0A907D6D02C7774FD1DD5AD_267206682 =         new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        var63D456C6F0A907D6D02C7774FD1DD5AD_267206682.addTaint(taint);
        return var63D456C6F0A907D6D02C7774FD1DD5AD_267206682;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.870 -0400", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "2AF55A549ABFD08F843A20C7286EDCF9")
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
Socket varB6BB2BF7A9EA2DC81133AEB71C0BFB45_1229250567 =         new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        varB6BB2BF7A9EA2DC81133AEB71C0BFB45_1229250567.addTaint(taint);
        return varB6BB2BF7A9EA2DC81133AEB71C0BFB45_1229250567;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImpl(address,
                                     //port,
                                     //localAddress,
                                     //localPort,
                                     //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.870 -0400", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "87483BAD5CECFB8DB43A4212E7143D1A")
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(s.getTaint());
Socket var69265E76FA8CF94DBD3F36BD84E69EFA_1205581250 =         new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone());
        var69265E76FA8CF94DBD3F36BD84E69EFA_1205581250.addTaint(taint);
        return var69265E76FA8CF94DBD3F36BD84E69EFA_1205581250;
        // ---------- Original Method ----------
        //return new OpenSSLSocketImplWrapper(s,
                                            //host,
                                            //port,
                                            //autoClose,
                                            //(SSLParametersImpl) sslParameters.clone());
    }

    
}

