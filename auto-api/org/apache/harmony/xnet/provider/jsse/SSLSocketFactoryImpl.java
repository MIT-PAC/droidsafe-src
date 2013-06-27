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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.655 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.655 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.656 -0400", hash_original_method = "3B70F1FB7142745DE6253CA770AA85DF", hash_generated_method = "AFAFC10411E0805BF7CA29F98654EB70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.668 -0400", hash_original_method = "BC2150A7C00CB445EF2AA02677D69C68", hash_generated_method = "146D5A1E985B15C74A3455531EFFAA78")
    protected  SSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.668 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "9478BFDBBDAF736698D416D9A8477426")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1162741495 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_693760459 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1162741495 = EmptyArray.STRING;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_693760459 = sslParameters.getEnabledCipherSuites();
        String[] varA7E53CE21691AB073D9660D615818899_1858562526; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1858562526 = varB4EAC82CA7396A68D541C85D26508E83_1162741495;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1858562526 = varB4EAC82CA7396A68D541C85D26508E83_693760459;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1858562526.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1858562526;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.669 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "353B2B6CFC4051D83ABB8355A0EF2695")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1700031206 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_71982741 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1700031206 = EmptyArray.STRING;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_71982741 = CipherSuite.getSupportedCipherSuiteNames();
        String[] varA7E53CE21691AB073D9660D615818899_1775035288; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1775035288 = varB4EAC82CA7396A68D541C85D26508E83_1700031206;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1775035288 = varB4EAC82CA7396A68D541C85D26508E83_71982741;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1775035288.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1775035288;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.684 -0400", hash_original_method = "770FADDB251D7948083EF0D02F3938EE", hash_generated_method = "C7FE1578C5206256407E23179CD9F3AE")
    @Override
    public Socket createSocket(Socket s, String host, int port,
            boolean autoClose) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1764419624 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1764419624 = new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                .clone());
        addTaint(s.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        varB4EAC82CA7396A68D541C85D26508E83_1764419624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764419624;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                //.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.684 -0400", hash_original_method = "0CDA18BD18854D909AC84115F509C8F0", hash_generated_method = "E7302C3C8ECFAFD3BE8E5D0EB5DE77DD")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1346143816 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1346143816 = new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_1346143816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346143816;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.685 -0400", hash_original_method = "F68AAAAA9B8D61B174802E7029AF7953", hash_generated_method = "5D9F4C8D6143978F1FF8B5D0A6C0F52D")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_680587556 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_680587556 = new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_680587556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680587556;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.686 -0400", hash_original_method = "53A1989EA3FBEE45809A2C11EADE957A", hash_generated_method = "233B9201E884BEB65A61AC0C1F18DF35")
    @Override
    public Socket createSocket(String host, int port,
            InetAddress localHost, int localPort) throws IOException,
            UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1131099018 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1131099018 = new SSLSocketImpl(host, port, localHost, localPort,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1131099018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1131099018;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port, localHost, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.687 -0400", hash_original_method = "FD8C4D4ADA3C87BB97218603199064D4", hash_generated_method = "7652F6B1749F544A56C87B7B33F9A3B8")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_915854141 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_915854141 = new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_915854141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915854141;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.687 -0400", hash_original_method = "3B16D41EDAC8F54354185F57BF630F58", hash_generated_method = "C1CBB5EB1151D92FC85B1C3810A8587F")
    @Override
    public Socket createSocket(InetAddress address, int port,
            InetAddress localAddress, int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2100628248 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2100628248 = new SSLSocketImpl(address, port, localAddress, localPort,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_2100628248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100628248;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(address, port, localAddress, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

