package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;

import javax.net.ssl.SSLSocketFactory;

import libcore.util.EmptyArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SSLSocketFactoryImpl extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.485 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.485 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.486 -0400", hash_original_method = "3B70F1FB7142745DE6253CA770AA85DF", hash_generated_method = "199593CBF37E7BEF756EF1984BCA254B")
    public  SSLSocketFactoryImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.487 -0400", hash_original_method = "BC2150A7C00CB445EF2AA02677D69C68", hash_generated_method = "146D5A1E985B15C74A3455531EFFAA78")
    protected  SSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.487 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "901DC7A5F3DE07A36F238F62D89F9415")
    @Override
    public String[] getDefaultCipherSuites() {
        if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_1173789806 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_1173789806.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_1173789806;
        } //End block
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_1177097999 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_1177097999.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_1177097999;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.488 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "12A3909623381440C68CC88B60741EAD")
    @Override
    public String[] getSupportedCipherSuites() {
        if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_767576645 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_767576645.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_767576645;
        } //End block
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_1272131410 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_1272131410.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_1272131410;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.489 -0400", hash_original_method = "770FADDB251D7948083EF0D02F3938EE", hash_generated_method = "113835079948E93EF9302C9A96E3CEF6")
    @Override
    public Socket createSocket(Socket s, String host, int port,
            boolean autoClose) throws IOException {
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(s.getTaint());
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket varB60F6C18128D67E2AF7DE4C05556D019_1028352280 =         new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                .clone());
        varB60F6C18128D67E2AF7DE4C05556D019_1028352280.addTaint(taint);
        return varB60F6C18128D67E2AF7DE4C05556D019_1028352280;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                //.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.489 -0400", hash_original_method = "0CDA18BD18854D909AC84115F509C8F0", hash_generated_method = "DAF0F42E8C48572784999CE091A38C22")
    @Override
    public Socket createSocket() throws IOException {
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket varF585F5C913EA0A8BB66CFC025ED67026_1385018822 =         new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varF585F5C913EA0A8BB66CFC025ED67026_1385018822.addTaint(taint);
        return varF585F5C913EA0A8BB66CFC025ED67026_1385018822;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.490 -0400", hash_original_method = "F68AAAAA9B8D61B174802E7029AF7953", hash_generated_method = "DD865FFE1F8806028F173BB6F34DF463")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket varF099F73103E10DCDA254E6178668F26C_1758662795 =         new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        varF099F73103E10DCDA254E6178668F26C_1758662795.addTaint(taint);
        return varF099F73103E10DCDA254E6178668F26C_1758662795;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.490 -0400", hash_original_method = "53A1989EA3FBEE45809A2C11EADE957A", hash_generated_method = "CF9E6425C3A5322EBE02BE3A00985662")
    @Override
    public Socket createSocket(String host, int port,
            InetAddress localHost, int localPort) throws IOException,
            UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket var8B2D508D0A0F4CCB24C221E5F50135E3_1266201861 =         new SSLSocketImpl(host, port, localHost, localPort,
                (SSLParametersImpl) sslParameters.clone());
        var8B2D508D0A0F4CCB24C221E5F50135E3_1266201861.addTaint(taint);
        return var8B2D508D0A0F4CCB24C221E5F50135E3_1266201861;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port, localHost, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.491 -0400", hash_original_method = "FD8C4D4ADA3C87BB97218603199064D4", hash_generated_method = "461BDBA5390A1F737C4DC60A4AE84789")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket varF099F73103E10DCDA254E6178668F26C_1526851225 =         new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        varF099F73103E10DCDA254E6178668F26C_1526851225.addTaint(taint);
        return varF099F73103E10DCDA254E6178668F26C_1526851225;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.492 -0400", hash_original_method = "3B16D41EDAC8F54354185F57BF630F58", hash_generated_method = "05D73CA7EDF1B17BB87B7C6055976FE3")
    @Override
    public Socket createSocket(InetAddress address, int port,
            InetAddress localAddress, int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
Socket var4B4C81437B56F909D5F0BC85698458C8_523035388 =         new SSLSocketImpl(address, port, localAddress, localPort,
                (SSLParametersImpl) sslParameters.clone());
        var4B4C81437B56F909D5F0BC85698458C8_523035388.addTaint(taint);
        return var4B4C81437B56F909D5F0BC85698458C8_523035388;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(address, port, localAddress, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

