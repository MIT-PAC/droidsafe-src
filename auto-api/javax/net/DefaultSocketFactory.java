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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.441 -0400", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "027CB46FE2CBA12105D59EC97E29AE07")
      DefaultSocketFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.442 -0400", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "59208AB6C6EA3A65DBFB32105175819E")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1206340843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1206340843 = new Socket();
        varB4EAC82CA7396A68D541C85D26508E83_1206340843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206340843;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.442 -0400", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "835D305CE2ACDA1010BCED38654D9D61")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_989203472 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_989203472 = new Socket(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_989203472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_989203472;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.443 -0400", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "E937014C9071DEEB00A144719E8F1D9D")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1998151906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1998151906 = new Socket(host, port, localHost, localPort);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1998151906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1998151906;
        // ---------- Original Method ----------
        //return new Socket(host, port, localHost, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.443 -0400", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "F280525FF9D102B31E1867E395E24AF2")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1284138709 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1284138709 = new Socket(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1284138709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284138709;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.444 -0400", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "6700ECC809CD4067F01AEC64559F2D30")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_305563857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_305563857 = new Socket(address, port, localAddress, localPort);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_305563857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_305563857;
        // ---------- Original Method ----------
        //return new Socket(address, port, localAddress, localPort);
    }

    
}

