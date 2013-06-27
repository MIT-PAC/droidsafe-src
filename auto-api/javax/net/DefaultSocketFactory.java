package javax.net;

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

final class DefaultSocketFactory extends SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.073 -0400", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "027CB46FE2CBA12105D59EC97E29AE07")
      DefaultSocketFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.074 -0400", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "EE169CBF89A825FA47096EA2665AECCE")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_38811014 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_38811014 = new Socket();
        varB4EAC82CA7396A68D541C85D26508E83_38811014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_38811014;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.081 -0400", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "232A6AEF243D9DDAB998700A39D3B251")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_311716606 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_311716606 = new Socket(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_311716606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_311716606;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.081 -0400", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "1A385949108A65DBE8B2B0B737BBA395")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1058136303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1058136303 = new Socket(host, port, localHost, localPort);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1058136303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1058136303;
        // ---------- Original Method ----------
        //return new Socket(host, port, localHost, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.082 -0400", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "399602303D4897AFD42623FDE4C71981")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2036910077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2036910077 = new Socket(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_2036910077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2036910077;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.082 -0400", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "6CC2117B778262AD83F6717650FDC587")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1907662741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1907662741 = new Socket(address, port, localAddress, localPort);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1907662741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1907662741;
        // ---------- Original Method ----------
        //return new Socket(address, port, localAddress, localPort);
    }

    
}

