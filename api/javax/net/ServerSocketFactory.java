package javax.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public abstract class ServerSocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.519 -0400", hash_original_method = "50A5AD4489C33A1F5479F4B6ACCE6C5A", hash_generated_method = "93523426EE53B436B1AC84C7AA84A8F5")
    protected  ServerSocketFactory() {
        
    }

    
        public static synchronized ServerSocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultServerSocketFactory();
        }
        return defaultFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.520 -0400", hash_original_method = "698CB8A5B4145A1BDB9AB7D216CE6832", hash_generated_method = "6ADFEF797EDD3FDA533D9186715B5D4B")
    public ServerSocket createServerSocket() throws IOException {
        SocketException varDA6818F72EC9252110B74ED429FAE910_1771899893 = new SocketException("Unbound server sockets not implemented");
        varDA6818F72EC9252110B74ED429FAE910_1771899893.addTaint(taint);
        throw varDA6818F72EC9252110B74ED429FAE910_1771899893;
        
        
    }

    
    public abstract ServerSocket createServerSocket(int port) throws IOException;

    
    public abstract ServerSocket createServerSocket(int port, int backlog) throws IOException;

    
    public abstract ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress)
            throws IOException;

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.520 -0400", hash_original_field = "AD51BE9B54CCA5A60660866B8F47D2A3", hash_generated_field = "91CFD533A1679FDB7589B0B5E4967C1D")

    private static ServerSocketFactory defaultFactory;
}

