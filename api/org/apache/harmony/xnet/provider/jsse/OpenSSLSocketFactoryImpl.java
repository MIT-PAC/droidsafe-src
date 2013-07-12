package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;

public class OpenSSLSocketFactoryImpl extends javax.net.ssl.SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.696 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.696 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.697 -0400", hash_original_method = "954C1C672B3FA3A56F7D19D272F9A35A", hash_generated_method = "05D07D434E5984350F4E08FF662C3AFC")
    public  OpenSSLSocketFactoryImpl() {
        SSLParametersImpl sslParametersLocal = null;
        IOException instantiationExceptionLocal = null;
        try 
        {
            sslParametersLocal = SSLParametersImpl.getDefault();
        } 
        catch (KeyManagementException e)
        {
            instantiationExceptionLocal = new IOException("Delayed instantiation exception:");
            instantiationExceptionLocal.initCause(e);
        } 
        this.sslParameters = sslParametersLocal;
        this.instantiationException = instantiationExceptionLocal;
        
        
        
        
            
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.698 -0400", hash_original_method = "ED12E5BC8BFE19F7383AAD2954B3D6F8", hash_generated_method = "F977EBEDD1EBB8F226355D7FF351DF06")
    public  OpenSSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.698 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "DC8ADF0A60E967307D1E4B2E56BEBDCC")
    public String[] getDefaultCipherSuites() {
String[] var82D10C47ABE9DD1DDD091B4BC41FC622_1495921565 =         NativeCrypto.getDefaultCipherSuites();
        var82D10C47ABE9DD1DDD091B4BC41FC622_1495921565.addTaint(taint);
        return var82D10C47ABE9DD1DDD091B4BC41FC622_1495921565;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.699 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "E0C450BFAB2501960B784258D908AEBE")
    public String[] getSupportedCipherSuites() {
String[] var0633111015CD199BA68A1C170162F6EA_921937704 =         NativeCrypto.getSupportedCipherSuites();
        var0633111015CD199BA68A1C170162F6EA_921937704.addTaint(taint);
        return var0633111015CD199BA68A1C170162F6EA_921937704;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.699 -0400", hash_original_method = "5837D32923FC621D416DFAB5F2A31CC3", hash_generated_method = "03EB10FF110300E069175DDAF58B6737")
    public Socket createSocket() throws IOException {
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } 
Socket varB21EA82A3B7E560674E2865BCBD5375E_1810867643 =         new OpenSSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB21EA82A3B7E560674E2865BCBD5375E_1810867643.addTaint(taint);
        return varB21EA82A3B7E560674E2865BCBD5375E_1810867643;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.700 -0400", hash_original_method = "1E52BABAD2D1DFFC783D790A770C62CD", hash_generated_method = "4F37C9B287062CCE60BC0F94132B6722")
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var63D456C6F0A907D6D02C7774FD1DD5AD_452856647 =         new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        var63D456C6F0A907D6D02C7774FD1DD5AD_452856647.addTaint(taint);
        return var63D456C6F0A907D6D02C7774FD1DD5AD_452856647;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.700 -0400", hash_original_method = "446E800FD94AABE8FA87E3DF006FFD83", hash_generated_method = "B30A38A56843DA5D598A949687E8E05A")
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
Socket varD55A0D254F337F166D47150294048CDD_1562977417 =         new OpenSSLSocketImpl(host,
                                     port,
                                     localHost,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        varD55A0D254F337F166D47150294048CDD_1562977417.addTaint(taint);
        return varD55A0D254F337F166D47150294048CDD_1562977417;
        
        
                                     
                                     
                                     
                                     
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.701 -0400", hash_original_method = "8C3F00D4155804449C1F3B4EECD9A781", hash_generated_method = "3488B1F2791FC96B4E1547CDA230EAEA")
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var63D456C6F0A907D6D02C7774FD1DD5AD_1588444762 =         new OpenSSLSocketImpl(host, port, (SSLParametersImpl) sslParameters.clone());
        var63D456C6F0A907D6D02C7774FD1DD5AD_1588444762.addTaint(taint);
        return var63D456C6F0A907D6D02C7774FD1DD5AD_1588444762;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.702 -0400", hash_original_method = "D24DE3B32EF1E2E7C7A21CA7F4DE54C3", hash_generated_method = "B73E4C2EFB1F4C673937D93EDF0666F1")
    public Socket createSocket(InetAddress address,
                               int port,
                               InetAddress localAddress,
                               int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
Socket varB6BB2BF7A9EA2DC81133AEB71C0BFB45_2043139169 =         new OpenSSLSocketImpl(address,
                                     port,
                                     localAddress,
                                     localPort,
                                     (SSLParametersImpl) sslParameters.clone());
        varB6BB2BF7A9EA2DC81133AEB71C0BFB45_2043139169.addTaint(taint);
        return varB6BB2BF7A9EA2DC81133AEB71C0BFB45_2043139169;
        
        
                                     
                                     
                                     
                                     
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.703 -0400", hash_original_method = "DD495B76995C9C69DA63CB41C5B731D2", hash_generated_method = "C4B663CF7F1D82D4424035BD56D44FD5")
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(s.getTaint());
Socket var69265E76FA8CF94DBD3F36BD84E69EFA_1624571144 =         new OpenSSLSocketImplWrapper(s,
                                            host,
                                            port,
                                            autoClose,
                                            (SSLParametersImpl) sslParameters.clone());
        var69265E76FA8CF94DBD3F36BD84E69EFA_1624571144.addTaint(taint);
        return var69265E76FA8CF94DBD3F36BD84E69EFA_1624571144;
        
        
                                            
                                            
                                            
                                            
    }

    
}

