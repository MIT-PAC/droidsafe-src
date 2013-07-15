package javax.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public abstract class SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.697 -0400", hash_original_method = "558E5CF77A92B4D322EAE73AA7FC9ED5", hash_generated_method = "49A83C6EA0E2C7D8DB87841B35CCED46")
    protected  SocketFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultSocketFactory();
        }
        return defaultFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.698 -0400", hash_original_method = "237BDA73790E5091959E59275734231E", hash_generated_method = "21EB0CF58885A21F6A7B5926A8A74EA6")
    public Socket createSocket() throws IOException {
        SocketException var017B431FE5380BEF3661A8EE7F89DBAD_447729864 = new SocketException("Unconnected sockets not implemented");
        var017B431FE5380BEF3661A8EE7F89DBAD_447729864.addTaint(taint);
        throw var017B431FE5380BEF3661A8EE7F89DBAD_447729864;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.699 -0400", hash_original_field = "AD51BE9B54CCA5A60660866B8F47D2A3", hash_generated_field = "56F0D4B4CAC1522C61207F4CDB9A2E1E")

    private static SocketFactory defaultFactory;
}

