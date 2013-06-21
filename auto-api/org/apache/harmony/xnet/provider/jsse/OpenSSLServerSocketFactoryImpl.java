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
    private SSLParametersImpl sslParameters;
    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.839 -0400", hash_original_method = "661B740306EF729B03E756D73006DD97", hash_generated_method = "2AF29500DDD1D89149A1220D74460495")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OpenSSLServerSocketFactoryImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.839 -0400", hash_original_method = "6C0182FC3112F46DBF9FF9E1060447FC", hash_generated_method = "2F7373F1AB92A229162389B96D04AD27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OpenSSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        dsTaint.addTaint(sslParameters.dsTaint);
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.839 -0400", hash_original_method = "0281EF5D8B3BC852A1CC14F175899740", hash_generated_method = "A28D5A41CB8DF27F924C19700AADB2C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getDefaultCipherSuites() {
        String[] varF7015EEB50403F5EADC161F0F4BD6399_1153455567 = (NativeCrypto.getDefaultCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getDefaultCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.839 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "3FE0F14452DFE4496D344C06CBD5084C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getSupportedCipherSuites() {
        String[] var4A8488CAA4D902DCFD3A82F559450276_1791998235 = (NativeCrypto.getSupportedCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.839 -0400", hash_original_method = "DD3C3F79E346D7A01595E9F060B2D5FB", hash_generated_method = "3C569E1FFA453DDA9C414D2F74A2DBC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket var01ED3980F415973541C66A2A34BA6416_1813697429 = (new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.840 -0400", hash_original_method = "4D548A9DDA0E958E6B561F7581D51C7D", hash_generated_method = "7B037DB635392A90900D88008584E4C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket(int port) throws IOException {
        dsTaint.addTaint(port);
        ServerSocket var23B1D3CDEF33EA078E3BA5F3589B3647_1291283042 = (new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port, (SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.840 -0400", hash_original_method = "CC5D3001B29102E2FC7CEFEB262BA8A8", hash_generated_method = "4BB0BC089C01C6A1C9A4DB995E449B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        ServerSocket var806C6F198E4869CCB49017289B20F73C_1977607394 = (new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           (SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port,
                                           //backlog,
                                           //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.840 -0400", hash_original_method = "978BD167D218C30F2EBF39FB52A220C5", hash_generated_method = "62F9029F4EE37639997C2821CBE11AC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket(int port,
                                           int backlog,
                                           InetAddress iAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(iAddress.dsTaint);
        dsTaint.addTaint(backlog);
        ServerSocket var7999AEB3B82A78DE79927A5C2486E1DF_477698776 = (new OpenSSLServerSocketImpl(port,
                                           backlog,
                                           iAddress,
                                           (SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new OpenSSLServerSocketImpl(port,
                                           //backlog,
                                           //iAddress,
                                           //(SSLParametersImpl) sslParameters.clone());
    }

    
}

