package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import javax.net.ssl.SSLServerSocketFactory;
import libcore.util.EmptyArray;

public class SSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.213 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.213 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.214 -0400", hash_original_method = "73CB7C407A43304FA150044B815B6A46", hash_generated_method = "DA509C88D8CBE2F9A5C5ADAE49E05105")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.215 -0400", hash_original_method = "76241236FAFD17D5464286E69E45CFDE", hash_generated_method = "BC3AAD450653E595B44F6BC12859BFC7")
    protected  SSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.215 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "BF7925E413D65E4C763822EC0C2C41DD")
    @Override
    public String[] getDefaultCipherSuites() {
    if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_159709287 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_159709287.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_159709287;
        } //End block
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_1977019595 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_1977019595.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_1977019595;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.216 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "9CBC941F702745C66B1C8A9E9A6B65C7")
    @Override
    public String[] getSupportedCipherSuites() {
    if(instantiationException != null)        
        {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_975544308 =             EmptyArray.STRING;
            var46F61E348BE3BFB8B0571B04F2FE2C80_975544308.addTaint(taint);
            return var46F61E348BE3BFB8B0571B04F2FE2C80_975544308;
        } //End block
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_1910428765 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_1910428765.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_1910428765;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.216 -0400", hash_original_method = "8CBCDC02B624BDC3EBB9915D8C4D504E", hash_generated_method = "B896A079D1F901E8A9C78785A8220F22")
    @Override
    public ServerSocket createServerSocket() throws IOException {
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket var86527CE368486504962A0DA665B63240_1086280781 =         new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
        var86527CE368486504962A0DA665B63240_1086280781.addTaint(taint);
        return var86527CE368486504962A0DA665B63240_1086280781;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.217 -0400", hash_original_method = "38B1F9FB8A801D54D6140D98F9574C0C", hash_generated_method = "A7F23BF0FECBA8568D5D58D28491A79F")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket var7CE2FAD1FAA4191304ED54A5E79AABB8_149123605 =         new SSLServerSocketImpl(port,
                (SSLParametersImpl) sslParameters.clone());
        var7CE2FAD1FAA4191304ED54A5E79AABB8_149123605.addTaint(taint);
        return var7CE2FAD1FAA4191304ED54A5E79AABB8_149123605;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.217 -0400", hash_original_method = "DB92DF56A4C60994E7A02C3BBC7271E4", hash_generated_method = "1F1F624CFEB4ABD770776ADFD8C7FA0E")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
    if(instantiationException != null)        
        {
            instantiationException.addTaint(taint);
            throw instantiationException;
        } //End block
ServerSocket var2BDCD37DE1607D996E9E2DDBD7BF73A6_1519784126 =         new SSLServerSocketImpl(port, backlog,
                (SSLParametersImpl) sslParameters.clone());
        var2BDCD37DE1607D996E9E2DDBD7BF73A6_1519784126.addTaint(taint);
        return var2BDCD37DE1607D996E9E2DDBD7BF73A6_1519784126;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.218 -0400", hash_original_method = "05EB93BEC7CA6CC8959662993B7E734B", hash_generated_method = "886F74C7FE925884F25C05CAB6FCA448")
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
ServerSocket varBEA4788B5FF819FA3B95CCC32873F13D_1732496262 =         new SSLServerSocketImpl(port, backlog, iAddress,
                (SSLParametersImpl) sslParameters.clone());
        varBEA4788B5FF819FA3B95CCC32873F13D_1732496262.addTaint(taint);
        return varBEA4788B5FF819FA3B95CCC32873F13D_1732496262;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog, iAddress,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

