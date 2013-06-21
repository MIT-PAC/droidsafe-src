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
import javax.net.ssl.SSLServerSocketFactory;
import libcore.util.EmptyArray;

public class SSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    private SSLParametersImpl sslParameters;
    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.176 -0400", hash_original_method = "73CB7C407A43304FA150044B815B6A46", hash_generated_method = "DA509C88D8CBE2F9A5C5ADAE49E05105")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLServerSocketFactoryImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.177 -0400", hash_original_method = "76241236FAFD17D5464286E69E45CFDE", hash_generated_method = "2F04A234242E76EB70E5C220D27A76D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        dsTaint.addTaint(sslParameters.dsTaint);
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.177 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "8435528020FA3379A457B17B65901846")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varC3ED4EB907904E69984EFC846C8D14D7_875106258 = (sslParameters.getEnabledCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.177 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "A35D9FAEB8922DC8FCE9DA8CAF541146")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var7538431C68A39BDF527B3279B9F226C5_1182216261 = (CipherSuite.getSupportedCipherSuiteNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.177 -0400", hash_original_method = "8CBCDC02B624BDC3EBB9915D8C4D504E", hash_generated_method = "8809E5088898AB2DBF63C123D4EBD82C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        ServerSocket var51285FD75453AC49A33A48BF761B748F_1003581501 = (new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.178 -0400", hash_original_method = "38B1F9FB8A801D54D6140D98F9574C0C", hash_generated_method = "981B8614078C2FC366331D83F2369F6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        dsTaint.addTaint(port);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        ServerSocket var86AC53EB1DB8BE4DF3E35FF8BCF26367_780469867 = (new SSLServerSocketImpl(port,
                (SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.178 -0400", hash_original_method = "DB92DF56A4C60994E7A02C3BBC7271E4", hash_generated_method = "E10671347A38866AD23020C465D06AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(backlog);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        ServerSocket var539639286468742E9918EB40E4D93786_166003612 = (new SSLServerSocketImpl(port, backlog,
                (SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.178 -0400", hash_original_method = "05EB93BEC7CA6CC8959662993B7E734B", hash_generated_method = "217BE7603FCD799FE30A089403E7E7DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress iAddress) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(iAddress.dsTaint);
        dsTaint.addTaint(backlog);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        ServerSocket var965D1FCA157BFAFFE5AC97A18C46CB79_1761090883 = (new SSLServerSocketImpl(port, backlog, iAddress,
                (SSLParametersImpl) sslParameters.clone()));
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog, iAddress,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

