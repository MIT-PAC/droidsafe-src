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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.413 -0400", hash_original_method = "8A4D96D5B28C2AFD105167087B65524F", hash_generated_method = "8A4D96D5B28C2AFD105167087B65524F")
    public DefaultServerSocketFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.414 -0400", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "9422C9B796E5364B91BA6C337CEDAB99")
    @Override
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1148926280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1148926280 = new ServerSocket();
        varB4EAC82CA7396A68D541C85D26508E83_1148926280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1148926280;
        // ---------- Original Method ----------
        //return new ServerSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.414 -0400", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "1C8B8CE35A11C46D7177E3F742A8DD3B")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1363390059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1363390059 = new ServerSocket(port);
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1363390059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363390059;
        // ---------- Original Method ----------
        //return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.415 -0400", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "4F50CFA17922FB0866C6AEF806370163")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1153094209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1153094209 = new ServerSocket(port, backlog);
        addTaint(port);
        addTaint(backlog);
        varB4EAC82CA7396A68D541C85D26508E83_1153094209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1153094209;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.415 -0400", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "F02C3A035E9195029FCA43DDBF2BDD81")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1317212575 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1317212575 = new ServerSocket(port, backlog, iAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1317212575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1317212575;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, iAddress);
    }

    
}

