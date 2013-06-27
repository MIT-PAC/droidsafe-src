package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;

public class OpenSSLServerSocketFactoryImpl extends javax.net.ssl.SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.068 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.068 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.069 -0400", hash_original_method = "661B740306EF729B03E756D73006DD97", hash_generated_method = "2AF29500DDD1D89149A1220D74460495")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.069 -0400", hash_original_method = "6C0182FC3112F46DBF9FF9E1060447FC", hash_generated_method = "136A929783A39ECF3122E80B18483D9B")
    public  OpenSSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.070 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "F0504928BC78155E37D9ABDD8BDB33AF")
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_946101813 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_946101813 = NativeCrypto.getDefaultCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_946101813.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946101813;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.070 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "25B76C27352CA090E1F0104DB791D915")
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_112776458 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_112776458 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_112776458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_112776458;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.071 -0400", hash_original_method = "DD3C3F79E346D7A01595E9F060B2D5FB", hash_generated_method = "74968EDE17768FE1C574ACCC0367790E")
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1469302957 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469302957 = new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_1469302957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469302957;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.071 -0400", hash_original_method = "4D548A9DDA0E958E6B561F7581D51C7D", hash_generated_method = "81BEBA3F4470322E9C152C14E0643A4F")
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_261583920 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_261583920 = new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_261583920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_261583920;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.090 -0400", hash_original_method = "CC5D3001B29102E2FC7CEFEB262BA8A8", hash_generated_method = "2B63503DF7C44D73224CCB578CE323BE")
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_881653116 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_881653116 = new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        addTaint(backlog);
        varB4EAC82CA7396A68D541C85D26508E83_881653116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881653116;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port,
                                           //backlog,
                                           //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.090 -0400", hash_original_method = "978BD167D218C30F2EBF39FB52A220C5", hash_generated_method = "05E8171CB55D3A71D25192F4A30D5C83")
    public ServerSocket createServerSocket(int port,
                                           int backlog,
                                           InetAddress iAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1697738858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1697738858 = new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           iAddress,
                                           (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1697738858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1697738858;
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port,
                                           //backlog,
                                           //iAddress,
                                           //(SSLParametersImpl) sslParameters.clone());
    }

    
}

