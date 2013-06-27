package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLSocketFactory;
import libcore.util.EmptyArray;

public class SSLSocketFactoryImpl extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.879 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.879 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.880 -0400", hash_original_method = "3B70F1FB7142745DE6253CA770AA85DF", hash_generated_method = "AFAFC10411E0805BF7CA29F98654EB70")
    public  SSLSocketFactoryImpl() {
        SSLParametersImpl sslParametersLocal;
        sslParametersLocal = null;
        IOException instantiationExceptionLocal;
        instantiationExceptionLocal = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.882 -0400", hash_original_method = "BC2150A7C00CB445EF2AA02677D69C68", hash_generated_method = "146D5A1E985B15C74A3455531EFFAA78")
    protected  SSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.891 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "66A86EFB191111FA12A5850CF2ADF598")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_968324999 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_948667352 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_968324999 = EmptyArray.STRING;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_948667352 = sslParameters.getEnabledCipherSuites();
        String[] varA7E53CE21691AB073D9660D615818899_1802894137; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1802894137 = varB4EAC82CA7396A68D541C85D26508E83_968324999;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1802894137 = varB4EAC82CA7396A68D541C85D26508E83_948667352;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1802894137.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1802894137;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.892 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "1F86EEC7A3B115C5996E6A8E04E3A33B")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_490185611 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1857723608 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_490185611 = EmptyArray.STRING;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1857723608 = CipherSuite.getSupportedCipherSuiteNames();
        String[] varA7E53CE21691AB073D9660D615818899_640197342; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_640197342 = varB4EAC82CA7396A68D541C85D26508E83_490185611;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_640197342 = varB4EAC82CA7396A68D541C85D26508E83_1857723608;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_640197342.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_640197342;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.892 -0400", hash_original_method = "770FADDB251D7948083EF0D02F3938EE", hash_generated_method = "21B5AAC4872D1989693805A99D62CEF5")
    @Override
    public Socket createSocket(Socket s, String host, int port,
            boolean autoClose) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1555310360 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1555310360 = new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                .clone());
        addTaint(s.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        varB4EAC82CA7396A68D541C85D26508E83_1555310360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1555310360;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                //.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.900 -0400", hash_original_method = "0CDA18BD18854D909AC84115F509C8F0", hash_generated_method = "253C2195600765F1A08924BF5444FF0C")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_863688288 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_863688288 = new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_863688288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_863688288;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.900 -0400", hash_original_method = "F68AAAAA9B8D61B174802E7029AF7953", hash_generated_method = "6003C168C9618AF83FE23DD135AE1408")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1920027819 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1920027819 = new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1920027819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1920027819;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.904 -0400", hash_original_method = "53A1989EA3FBEE45809A2C11EADE957A", hash_generated_method = "C9056DA11423320F73F7303958903010")
    @Override
    public Socket createSocket(String host, int port,
            InetAddress localHost, int localPort) throws IOException,
            UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1189843961 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1189843961 = new SSLSocketImpl(host, port, localHost, localPort,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1189843961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1189843961;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port, localHost, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.905 -0400", hash_original_method = "FD8C4D4ADA3C87BB97218603199064D4", hash_generated_method = "46FAA552BBD18291F8952D34A1A548D7")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1628553463 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1628553463 = new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1628553463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1628553463;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.914 -0400", hash_original_method = "3B16D41EDAC8F54354185F57BF630F58", hash_generated_method = "B4A2A77892F711BC2043D2E52D51EB52")
    @Override
    public Socket createSocket(InetAddress address, int port,
            InetAddress localAddress, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1946998524 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1946998524 = new SSLSocketImpl(address, port, localAddress, localPort,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1946998524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1946998524;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(address, port, localAddress, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

