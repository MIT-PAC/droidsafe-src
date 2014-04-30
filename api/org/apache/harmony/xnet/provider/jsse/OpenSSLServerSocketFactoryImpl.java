package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;

public class OpenSSLServerSocketFactoryImpl extends javax.net.ssl.SSLServerSocketFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.411 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.413 -0500", hash_original_field = "4B271BE77FE082BAEDB0CC3C06D67CEA", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.416 -0500", hash_original_method = "661B740306EF729B03E756D73006DD97", hash_generated_method = "18B9D603F837039F3EF9D063619A5F6F")
    
public OpenSSLServerSocketFactoryImpl() {
        try {
            this.sslParameters = SSLParametersImpl.getDefault();
            this.sslParameters.setUseClientMode(false);
        } catch (KeyManagementException e) {
            instantiationException =
                new IOException("Delayed instantiation exception:");
            instantiationException.initCause(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.419 -0500", hash_original_method = "6C0182FC3112F46DBF9FF9E1060447FC", hash_generated_method = "92080E6EA597F4882D73E80418052412")
    
public OpenSSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.421 -0500", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "9FD76030E98DF5EC3E130ABDB050FF21")
    
public String[] getDefaultCipherSuites() {
        return NativeCrypto.getDefaultCipherSuites();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.423 -0500", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "F00706CA72F49A75DCD594C7E421B0AE")
    
public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.426 -0500", hash_original_method = "DD3C3F79E346D7A01595E9F060B2D5FB", hash_generated_method = "DC70BAF25070CC9C8167CF3889D4C2BB")
    
public ServerSocket createServerSocket() throws IOException {
        return new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.428 -0500", hash_original_method = "4D548A9DDA0E958E6B561F7581D51C7D", hash_generated_method = "39270C43962D0C53F5049CAF09417C15")
    
public ServerSocket createServerSocket(int port) throws IOException {
        return new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.430 -0500", hash_original_method = "CC5D3001B29102E2FC7CEFEB262BA8A8", hash_generated_method = "D3C1E741710B8F914D2DCD0EC302CEE8")
    
public ServerSocket createServerSocket(int port, int backlog)
            throws IOException {
        return new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           (SSLParametersImpl) sslParameters.clone());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.432 -0500", hash_original_method = "978BD167D218C30F2EBF39FB52A220C5", hash_generated_method = "06E1B9AFB2EEC66B708154A25E4D4012")
    
public ServerSocket createServerSocket(int port,
                                           int backlog,
                                           InetAddress iAddress) throws IOException {
        return new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           iAddress,
                                           (SSLParametersImpl) sslParameters.clone());
    }
    
}

