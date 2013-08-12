package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;

import javax.net.ssl.SSLServerSocketFactory;

import libcore.util.EmptyArray;





public class SSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.393 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.393 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.393 -0400", hash_original_method = "73CB7C407A43304FA150044B815B6A46", hash_generated_method = "DA509C88D8CBE2F9A5C5ADAE49E05105")
    public  SSLServerSocketFactoryImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.394 -0400", hash_original_method = "76241236FAFD17D5464286E69E45CFDE", hash_generated_method = "BC3AAD450653E595B44F6BC12859BFC7")
    protected  SSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.394 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "63C870F7FEFA8C44AFE0A40281C6A74E")
    @Override
    public String[] getDefaultCipherSuites() {
        if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_1318661546 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_1318661546.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_1318661546;
        } //End block
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_1214971692 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_1214971692.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_1214971692;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.395 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "576D1F746176A37DB2B9C36F2482C442")
    @Override
    public String[] getSupportedCipherSuites() {
        if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_1282516658 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_1282516658.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_1282516658;
        } //End block
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_404122685 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_404122685.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_404122685;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.395 -0400", hash_original_method = "8CBCDC02B624BDC3EBB9915D8C4D504E", hash_generated_method = "AEB32DE12B889087AC2DADDA5E7C8B1B")
    @Override
    public ServerSocket createServerSocket() throws IOException {
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket var86527CE368486504962A0DA665B63240_362655678 =         new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
        var86527CE368486504962A0DA665B63240_362655678.addTaint(taint);
        return var86527CE368486504962A0DA665B63240_362655678;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.396 -0400", hash_original_method = "38B1F9FB8A801D54D6140D98F9574C0C", hash_generated_method = "44D724D8FA350E84BD69B2022528991D")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket var7CE2FAD1FAA4191304ED54A5E79AABB8_1748732306 =         new SSLServerSocketImpl(port,
                (SSLParametersImpl) sslParameters.clone());
        var7CE2FAD1FAA4191304ED54A5E79AABB8_1748732306.addTaint(taint);
        return var7CE2FAD1FAA4191304ED54A5E79AABB8_1748732306;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.396 -0400", hash_original_method = "DB92DF56A4C60994E7A02C3BBC7271E4", hash_generated_method = "6ECC8C361903D457C61A8816F8040CC9")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket var2BDCD37DE1607D996E9E2DDBD7BF73A6_936939033 =         new SSLServerSocketImpl(port, backlog,
                (SSLParametersImpl) sslParameters.clone());
        var2BDCD37DE1607D996E9E2DDBD7BF73A6_936939033.addTaint(taint);
        return var2BDCD37DE1607D996E9E2DDBD7BF73A6_936939033;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.397 -0400", hash_original_method = "05EB93BEC7CA6CC8959662993B7E734B", hash_generated_method = "27C22F100C692C87AC8CAFF78778B96A")
    @Override
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress iAddress) throws IOException {
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
        if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket varBEA4788B5FF819FA3B95CCC32873F13D_131450900 =         new SSLServerSocketImpl(port, backlog, iAddress,
                (SSLParametersImpl) sslParameters.clone());
        varBEA4788B5FF819FA3B95CCC32873F13D_131450900.addTaint(taint);
        return varBEA4788B5FF819FA3B95CCC32873F13D_131450900;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog, iAddress,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

