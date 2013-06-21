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
import java.net.SocketException;

public abstract class ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.023 -0400", hash_original_method = "50A5AD4489C33A1F5479F4B6ACCE6C5A", hash_generated_method = "93523426EE53B436B1AC84C7AA84A8F5")
    @DSModeled(DSC.SAFE)
    protected ServerSocketFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized ServerSocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultServerSocketFactory();
        }
        return defaultFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.023 -0400", hash_original_method = "698CB8A5B4145A1BDB9AB7D216CE6832", hash_generated_method = "4847E6D5CBF01E646CEF1D18F7D5946B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocket createServerSocket() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Unbound server sockets not implemented");
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException("Unbound server sockets not implemented");
    }

    
    public abstract ServerSocket createServerSocket(int port) throws IOException;

    
    public abstract ServerSocket createServerSocket(int port, int backlog) throws IOException;

    
    public abstract ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress)
            throws IOException;

    
    private static ServerSocketFactory defaultFactory;
}

