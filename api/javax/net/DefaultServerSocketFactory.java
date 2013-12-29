package javax.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;



final class DefaultServerSocketFactory extends ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.506 -0400", hash_original_method = "8A4D96D5B28C2AFD105167087B65524F", hash_generated_method = "8A4D96D5B28C2AFD105167087B65524F")
    public DefaultServerSocketFactory ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.681 -0500", hash_original_method = "09A32D8E0ECF3B35B71EC41FF4A7A4A5", hash_generated_method = "0A40A4E97AE52FA3C07572A613C2C656")
    @Override
public ServerSocket createServerSocket() throws IOException {
        return new ServerSocket();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.682 -0500", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "FFD335EB14F1B83EB64D6E3BE1585504")
    @Override
public ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.682 -0500", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "E5E3865F24746E56584B46602EE73C0D")
    @Override
public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        return new ServerSocket(port, backlog);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.683 -0500", hash_original_method = "A38ABA8DDEB89B029728737B9173480B", hash_generated_method = "CB843C94D01F9C23D0066D526414C279")
    @Override
public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress)
            throws IOException {
        return new ServerSocket(port, backlog, iAddress);
    }

    
}

