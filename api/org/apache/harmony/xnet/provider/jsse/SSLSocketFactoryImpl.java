package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLSocketFactory;
import libcore.util.EmptyArray;

public class SSLSocketFactoryImpl extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.323 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.323 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.324 -0400", hash_original_method = "3B70F1FB7142745DE6253CA770AA85DF", hash_generated_method = "199593CBF37E7BEF756EF1984BCA254B")
    public  SSLSocketFactoryImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.325 -0400", hash_original_method = "BC2150A7C00CB445EF2AA02677D69C68", hash_generated_method = "146D5A1E985B15C74A3455531EFFAA78")
    protected  SSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.325 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "FDE03850AAE66DAD807D12D89CC557B6")
    @Override
    public String[] getDefaultCipherSuites() {
    if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_1655124283 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_1655124283.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_1655124283;
        } 
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_840457193 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_840457193.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_840457193;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.326 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "6EF251AB5CDA66D48B4A47179849EB64")
    @Override
    public String[] getSupportedCipherSuites() {
    if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_932232329 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_932232329.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_932232329;
        } 
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_1156446204 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_1156446204.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_1156446204;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.326 -0400", hash_original_method = "770FADDB251D7948083EF0D02F3938EE", hash_generated_method = "DF563A4AED76E78CD4165C2FB7C375B4")
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
        } 
Socket varB60F6C18128D67E2AF7DE4C05556D019_1592116102 =         new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                .clone());
        varB60F6C18128D67E2AF7DE4C05556D019_1592116102.addTaint(taint);
        return varB60F6C18128D67E2AF7DE4C05556D019_1592116102;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.327 -0400", hash_original_method = "0CDA18BD18854D909AC84115F509C8F0", hash_generated_method = "AF3C7A512DCE4DC2A667818FA1C0CE96")
    @Override
    public Socket createSocket() throws IOException {
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } 
Socket varF585F5C913EA0A8BB66CFC025ED67026_1795044047 =         new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varF585F5C913EA0A8BB66CFC025ED67026_1795044047.addTaint(taint);
        return varF585F5C913EA0A8BB66CFC025ED67026_1795044047;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.327 -0400", hash_original_method = "F68AAAAA9B8D61B174802E7029AF7953", hash_generated_method = "3FB2689D42ECFDD9559C469A5AEE0950")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } 
Socket varF099F73103E10DCDA254E6178668F26C_74346862 =         new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        varF099F73103E10DCDA254E6178668F26C_74346862.addTaint(taint);
        return varF099F73103E10DCDA254E6178668F26C_74346862;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.328 -0400", hash_original_method = "53A1989EA3FBEE45809A2C11EADE957A", hash_generated_method = "C38D2CCE35F3CED70E94800B3BF86B7A")
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
        } 
Socket var8B2D508D0A0F4CCB24C221E5F50135E3_839209242 =         new SSLSocketImpl(host, port, localHost, localPort,
                (SSLParametersImpl) sslParameters.clone());
        var8B2D508D0A0F4CCB24C221E5F50135E3_839209242.addTaint(taint);
        return var8B2D508D0A0F4CCB24C221E5F50135E3_839209242;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.329 -0400", hash_original_method = "FD8C4D4ADA3C87BB97218603199064D4", hash_generated_method = "851A1900725C02B57FF1C04F50F9CCEF")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } 
Socket varF099F73103E10DCDA254E6178668F26C_1736983658 =         new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        varF099F73103E10DCDA254E6178668F26C_1736983658.addTaint(taint);
        return varF099F73103E10DCDA254E6178668F26C_1736983658;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.330 -0400", hash_original_method = "3B16D41EDAC8F54354185F57BF630F58", hash_generated_method = "5231ABB94FA1FE57F0E12059B7AF12FE")
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
        } 
Socket var4B4C81437B56F909D5F0BC85698458C8_705844878 =         new SSLSocketImpl(address, port, localAddress, localPort,
                (SSLParametersImpl) sslParameters.clone());
        var4B4C81437B56F909D5F0BC85698458C8_705844878.addTaint(taint);
        return var4B4C81437B56F909D5F0BC85698458C8_705844878;
        
        
            
        
        
                
    }

    
}

