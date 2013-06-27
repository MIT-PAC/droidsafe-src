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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.063 -0400", hash_original_method = "8A4D96D5B28C2AFD105167087B65524F", hash_generated_method = "8A4D96D5B28C2AFD105167087B65524F")
    public DefaultServerSocketFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.064 -0400", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "F61A7B548E551C5A26D95E2E231D658C")
    @Override
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_626575563 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_626575563 = new ServerSocket();
        varB4EAC82CA7396A68D541C85D26508E83_626575563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_626575563;
        // ---------- Original Method ----------
        //return new ServerSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.065 -0400", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "7E4B2808CD5C8CE2F40B352CEBE50641")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1404403201 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1404403201 = new ServerSocket(port);
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_1404403201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1404403201;
        // ---------- Original Method ----------
        //return new ServerSocket(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.066 -0400", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "FBA82539A17702E8C9523A3BADB655C6")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1392635772 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1392635772 = new ServerSocket(port, backlog);
        addTaint(port);
        addTaint(backlog);
        varB4EAC82CA7396A68D541C85D26508E83_1392635772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1392635772;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.067 -0400", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "F69068BF10E107FD5B3D68B411669D0A")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1772448468 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1772448468 = new ServerSocket(port, backlog, iAddress);
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1772448468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1772448468;
        // ---------- Original Method ----------
        //return new ServerSocket(port, backlog, iAddress);
    }

    
}

