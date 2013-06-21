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
import java.net.SocketException;
import java.net.UnknownHostException;

public abstract class SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.024 -0400", hash_original_method = "558E5CF77A92B4D322EAE73AA7FC9ED5", hash_generated_method = "49A83C6EA0E2C7D8DB87841B35CCED46")
    @DSModeled(DSC.SAFE)
    protected SocketFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultSocketFactory();
        }
        return defaultFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.025 -0400", hash_original_method = "237BDA73790E5091959E59275734231E", hash_generated_method = "09EFC61ED2D69A169616269AEF3C7200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socket createSocket() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Unconnected sockets not implemented");
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException("Unconnected sockets not implemented");
    }

    
    public abstract Socket createSocket(String host, int port) throws IOException,
            UnknownHostException;

    
    public abstract Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException;

    
    public abstract Socket createSocket(InetAddress host, int port) throws IOException;

    
    public abstract Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException;

    
    private static SocketFactory defaultFactory;
}

