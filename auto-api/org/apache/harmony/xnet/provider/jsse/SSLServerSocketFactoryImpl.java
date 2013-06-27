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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.589 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.589 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.601 -0400", hash_original_method = "73CB7C407A43304FA150044B815B6A46", hash_generated_method = "DA509C88D8CBE2F9A5C5ADAE49E05105")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.602 -0400", hash_original_method = "76241236FAFD17D5464286E69E45CFDE", hash_generated_method = "BC3AAD450653E595B44F6BC12859BFC7")
    protected  SSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        // ---------- Original Method ----------
        //this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        //this.sslParameters.setUseClientMode(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.602 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "99C0EB07BB2268D9FF6E0E3F57175EB8")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_201935715 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_792932647 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_201935715 = EmptyArray.STRING;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_792932647 = sslParameters.getEnabledCipherSuites();
        String[] varA7E53CE21691AB073D9660D615818899_1532393460; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1532393460 = varB4EAC82CA7396A68D541C85D26508E83_201935715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1532393460 = varB4EAC82CA7396A68D541C85D26508E83_792932647;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1532393460.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1532393460;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.608 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "1BCD9FB46BDB328917D6F757B1C9BF17")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1389079602 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1130629050 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1389079602 = EmptyArray.STRING;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1130629050 = CipherSuite.getSupportedCipherSuiteNames();
        String[] varA7E53CE21691AB073D9660D615818899_1215810735; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1215810735 = varB4EAC82CA7396A68D541C85D26508E83_1389079602;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1215810735 = varB4EAC82CA7396A68D541C85D26508E83_1130629050;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1215810735.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1215810735;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.609 -0400", hash_original_method = "8CBCDC02B624BDC3EBB9915D8C4D504E", hash_generated_method = "F258B26BFB18FEAD78E58C27E7AE7117")
    @Override
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1589203939 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1589203939 = new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_1589203939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589203939;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.610 -0400", hash_original_method = "38B1F9FB8A801D54D6140D98F9574C0C", hash_generated_method = "9FD97853628F9CD704267E7F29D986C2")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_445342174 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_445342174 = new SSLServerSocketImpl(port,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_445342174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_445342174;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.610 -0400", hash_original_method = "DB92DF56A4C60994E7A02C3BBC7271E4", hash_generated_method = "AC048FFFFBE7B32DD153A1783B95D033")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_434790011 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_434790011 = new SSLServerSocketImpl(port, backlog,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        addTaint(backlog);
        varB4EAC82CA7396A68D541C85D26508E83_434790011.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_434790011;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.611 -0400", hash_original_method = "05EB93BEC7CA6CC8959662993B7E734B", hash_generated_method = "6948E64E955882E0741CAFFBE90B54CA")
    @Override
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress iAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_113644397 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_113644397 = new SSLServerSocketImpl(port, backlog, iAddress,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_113644397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113644397;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLServerSocketImpl(port, backlog, iAddress,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

