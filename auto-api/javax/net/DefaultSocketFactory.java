package javax.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

final class DefaultSocketFactory extends SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.419 -0400", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "027CB46FE2CBA12105D59EC97E29AE07")
      DefaultSocketFactory() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.419 -0400", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "A4C7F8DE1462AC8F085013B6F99EBB37")
    @Override
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2071764856 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2071764856 = new Socket();
        varB4EAC82CA7396A68D541C85D26508E83_2071764856.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2071764856;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.419 -0400", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "394A0C7FD839C8DAB908C5755183E4ED")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1019868137 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1019868137 = new Socket(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1019868137.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1019868137;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.420 -0400", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "9AECB0630980D4E2815B6F796593D160")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1932653993 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1932653993 = new Socket(host, port, localHost, localPort);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1932653993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1932653993;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.420 -0400", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "3006E2A141204401602C6906BA948C17")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_742096966 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_742096966 = new Socket(host, port);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_742096966.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_742096966;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.421 -0400", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "BFB2D16FC866BF337724EDBE17587CA4")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_183159674 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_183159674 = new Socket(address, port, localAddress, localPort);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_183159674.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_183159674;
        
        
    }

    
}

