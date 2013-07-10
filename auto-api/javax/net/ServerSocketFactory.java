package javax.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public abstract class ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.425 -0400", hash_original_method = "50A5AD4489C33A1F5479F4B6ACCE6C5A", hash_generated_method = "93523426EE53B436B1AC84C7AA84A8F5")
    protected  ServerSocketFactory() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized ServerSocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultServerSocketFactory();
        }
        return defaultFactory;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.426 -0400", hash_original_method = "698CB8A5B4145A1BDB9AB7D216CE6832", hash_generated_method = "E17B1C6F11E272EF5328B87C8A39725D")
    public ServerSocket createServerSocket() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Unbound server sockets not implemented");
        
        
        return new ServerSocket();
    }

    
    public abstract ServerSocket createServerSocket(int port) throws IOException;

    
    public abstract ServerSocket createServerSocket(int port, int backlog) throws IOException;

    
    public abstract ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress)
            throws IOException;

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.426 -0400", hash_original_field = "AD51BE9B54CCA5A60660866B8F47D2A3", hash_generated_field = "91CFD533A1679FDB7589B0B5E4967C1D")

    private static ServerSocketFactory defaultFactory;
}

