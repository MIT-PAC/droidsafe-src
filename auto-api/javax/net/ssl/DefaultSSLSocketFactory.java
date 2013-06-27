package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import libcore.util.EmptyArray;

class DefaultSSLSocketFactory extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.103 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.103 -0400", hash_original_method = "518A173F954BA705CC3BF505F9E13E1E", hash_generated_method = "5F8808C0137C671CECF9FCB4803684EB")
      DefaultSSLSocketFactory(String mes) {
        errMessage = mes;
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.105 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "F77D377B98CC2081B2DBE6528B3FD3D7")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1714794050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1714794050 = EmptyArray.STRING;
        varB4EAC82CA7396A68D541C85D26508E83_1714794050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1714794050;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.105 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "6A63D82FDD9621FF1A64135B21DC7200")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_557664682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_557664682 = EmptyArray.STRING;
        varB4EAC82CA7396A68D541C85D26508E83_557664682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_557664682;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.105 -0400", hash_original_method = "80973C4D16E76F8CBD9DC9AFB2C6FFD0", hash_generated_method = "3D7D477365F0D2FD7CDB9AE71F501847")
    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(s.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.107 -0400", hash_original_method = "DA3DD563FBA8107A1A984067F5EE0D59", hash_generated_method = "13266D8DB93DC91D064EDC48625FB745")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.112 -0400", hash_original_method = "8FF7B0825A4C1BFCEAEA97A8A771852A", hash_generated_method = "4C691C4237B2212CAFBF644211E3D7A7")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.112 -0400", hash_original_method = "F1FA6E0F26B33554BE365A5605459FC6", hash_generated_method = "76EDCD58FD496DE1B63D4A11ED982D17")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.113 -0400", hash_original_method = "5A01435F50BC90BAF50A86E164E9FD29", hash_generated_method = "2B140B6CA7BF7309D246E8256206159F")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

