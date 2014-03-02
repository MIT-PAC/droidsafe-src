package javax.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public abstract class SocketFactory {

    /**
     * Gets the default socket factory of the system which can be used to create
     * new sockets without creating a subclass of this factory.
     *
     * @return the system default socket factory.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.805 -0500", hash_original_method = "94A92FA9F3862BBC2F949BB5EF556892", hash_generated_method = "77B5BFA33B79EE4E2EC4F32DFDC5EB44")
    
public static synchronized SocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultSocketFactory();
        }
        return defaultFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.803 -0500", hash_original_field = "7E3B37F826EA75D27C247D416E7C0D99", hash_generated_field = "56F0D4B4CAC1522C61207F4CDB9A2E1E")

    private static SocketFactory defaultFactory;

    /**
     * Creates a new {@code SocketFactory} instance.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.808 -0500", hash_original_method = "558E5CF77A92B4D322EAE73AA7FC9ED5", hash_generated_method = "FF97926B4FA8C53D65322F48A6AC6EB4")
    
protected SocketFactory() {
    }

    /**
     * Creates a new socket which is not connected to any remote host. This
     * method has to be overridden by a subclass otherwise a {@code
     * SocketException} is thrown.
     *
     * @return the created unconnected socket.
     * @throws IOException
     *             if an error occurs while creating a new socket.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.810 -0500", hash_original_method = "237BDA73790E5091959E59275734231E", hash_generated_method = "3223CC07973034D16BC112F67CE7D73F")
    
public Socket createSocket() throws IOException {
        // follow RI's behavior
        throw new SocketException("Unconnected sockets not implemented");
    }

    /**
     * Creates a new socket which is connected to the remote host specified by
     * the parameters {@code host} and {@code port}. The socket is bound to any
     * available local address and port.
     *
     * @param host
     *            the remote host address the socket has to be connected to.
     * @param port
     *            the port number of the remote host at which the socket is
     *            connected.
     * @return the created connected socket.
     * @throws IOException
     *             if an error occurs while creating a new socket.
     * @throws UnknownHostException
     *             if the specified host is unknown or the IP address could not
     *             be resolved.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.812 -0500", hash_original_method = "C95CA781A864BA87FB97D9FD6525423C", hash_generated_method = "98A3CD8FE02D9C8C3BA2DDCCC69A24C2")
    
public abstract Socket createSocket(String host, int port) throws IOException,
            UnknownHostException;

    /**
     * Creates a new socket which is connected to the remote host specified by
     * the parameters {@code host} and {@code port}. The socket is bound to the
     * local network interface specified by the InetAddress {@code localHost} on
     * port {@code localPort}.
     *
     * @param host
     *            the remote host address the socket has to be connected to.
     * @param port
     *            the port number of the remote host at which the socket is
     *            connected.
     * @param localHost
     *            the local host address the socket is bound to.
     * @param localPort
     *            the port number of the local host at which the socket is
     *            bound.
     * @return the created connected socket.
     * @throws IOException
     *             if an error occurs while creating a new socket.
     * @throws UnknownHostException
     *             if the specified host is unknown or the IP address could not
     *             be resolved.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.814 -0500", hash_original_method = "A1DC492B94BC729FC090E1C6AD76416C", hash_generated_method = "F32C32B0894205694B4E47BCFD04E606")
    
public abstract Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException;

    /**
     * Creates a new socket which is connected to the remote host specified by
     * the InetAddress {@code host}. The socket is bound to any available local
     * address and port.
     *
     * @param host
     *            the host address the socket has to be connected to.
     * @param port
     *            the port number of the remote host at which the socket is
     *            connected.
     * @return the created connected socket.
     * @throws IOException
     *             if an error occurs while creating a new socket.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.817 -0500", hash_original_method = "B9B39D1CB99FF18D629D38672F44F910", hash_generated_method = "66B94998F53DC6534AACD9B3518B694E")
    
public abstract Socket createSocket(InetAddress host, int port) throws IOException;

    /**
     * Creates a new socket which is connected to the remote host specified by
     * the InetAddress {@code address}. The socket is bound to the local network
     * interface specified by the InetAddress {@code localHost} on port {@code
     * localPort}.
     *
     * @param address
     *            the remote host address the socket has to be connected to.
     * @param port
     *            the port number of the remote host at which the socket is
     *            connected.
     * @param localAddress
     *            the local host address the socket is bound to.
     * @param localPort
     *            the port number of the local host at which the socket is
     *            bound.
     * @return the created connected socket.
     * @throws IOException
     *             if an error occurs while creating a new socket.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.819 -0500", hash_original_method = "898886BBDBE8C5251E28416FF4767287", hash_generated_method = "FE34E03AF12C3D8151725C29B50001CD")
    
public abstract Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException;
}

