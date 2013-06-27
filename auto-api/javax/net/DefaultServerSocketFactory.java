package javax.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

final class DefaultServerSocketFactory extends ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.424 -0400", hash_original_method = "8A4D96D5B28C2AFD105167087B65524F", hash_generated_method = "8A4D96D5B28C2AFD105167087B65524F")
    public DefaultServerSocketFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.426 -0400", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "8DC7E7D3987531C6CB019CC714A9A28E")
    @Override
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1083734139 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1083734139 = new ServerSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1083734139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1083734139;
        // ---------- Original Method ----------
        //return new ServerSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.426 -0400", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "2E391BFA937238EFBD7680A34E06ED53")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_926787412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_926787412 = new ServerSocket(port);
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_926787412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_926787412;
        // ---------- Original Method ----------
        //return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.445 -0400", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "DA27802F6FB2141B12F8BECABAAA8BD8")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1141291950 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1141291950 = new ServerSocket(port, backlog);
        addTaint(port);
        addTaint(backlog);
        varB4EAC82CA7396A68D541C85D26508E83_1141291950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141291950;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.446 -0400", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "6A599EE54FD0049E2D54231FE5EAA528")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1233059406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1233059406 = new ServerSocket(port, backlog, iAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1233059406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1233059406;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, iAddress);
    }

    
}

