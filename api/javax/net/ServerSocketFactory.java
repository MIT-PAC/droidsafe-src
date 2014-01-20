package javax.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public abstract class ServerSocketFactory {

    /**
     * Gets the default server socket factory of the system which can be used to
     * create new server sockets without creating a subclass of this factory.
     *
     * @return the system default server socket factory.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.867 -0500", hash_original_method = "C92005BA8F3770F4486A33380A281994", hash_generated_method = "6378783AC72B921B197960106AE63FE3")
    
public static synchronized ServerSocketFactory getDefault() {
        if (defaultFactory == null) {
            defaultFactory = new DefaultServerSocketFactory();
        }
        return defaultFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.865 -0500", hash_original_field = "60505F218A5F254ADAD956EB183827B6", hash_generated_field = "91CFD533A1679FDB7589B0B5E4967C1D")

    private static ServerSocketFactory defaultFactory;

    /**
     * Creates a new {@code ServerSocketFactory} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.870 -0500", hash_original_method = "50A5AD4489C33A1F5479F4B6ACCE6C5A", hash_generated_method = "F66458F9D1456DEE896C0D9D4A2BB371")
    
protected ServerSocketFactory() {
    }

    /**
     * Creates a new server socket which is not bound to any local address. This
     * method has to be overridden by a subclass otherwise a {@code
     * SocketException} is thrown.
     *
     * @return the created unbound server socket.
     * @throws IOException
     *             if an error occurs while creating a new server socket.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.872 -0500", hash_original_method = "698CB8A5B4145A1BDB9AB7D216CE6832", hash_generated_method = "645F49532259ED5D3E10FF5BC0C9C237")
    
public ServerSocket createServerSocket() throws IOException {
        // follow RI's behavior
        throw new SocketException("Unbound server sockets not implemented");
    }

    /**
     * Creates a new server socket which is bound to the given port with a
     * maximum backlog of 50 unaccepted connections.
     *
     * @param port the port on which the created socket has to listen.
     * @return the created bound server socket.
     * @throws IOException
     *             if an error occurs while creating a new server socket.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.874 -0500", hash_original_method = "A19234449E0EC19C7E9ADEE610921D3B", hash_generated_method = "7D0FDB739D3EAEBE1857913E45DE578C")
    
public abstract ServerSocket createServerSocket(int port) throws IOException;

    /**
     * Creates a new server socket which is bound to the given port and
     * configures its maximum of queued connections.
     *
     * @param port the port on which the created socket has to listen.
     * @param backlog the maximum number of unaccepted connections. Passing 0 or
     *     a negative value yields the default backlog of 50.
     * @return the created bound server socket.
     * @throws IOException if an error occurs while creating a new server socket.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.876 -0500", hash_original_method = "110023DB1A72EAF80EE003D87EE55FF8", hash_generated_method = "4B9A1248B71A9A33BF54AE190BCB8ADC")
    
public abstract ServerSocket createServerSocket(int port, int backlog) throws IOException;

    /**
     * Creates a new server socket which is bound to the given address on the
     * specified port and configures its maximum of queued connections.
     *
     * @param port the port on which the created socket has to listen.
     * @param backlog the maximum number of unaccepted connections. Passing 0 or
     *     a negative value yields the default backlog of 50.
     * @param iAddress the address of the network interface which is used by the
     *     created socket.
     * @return the created bound server socket.
     * @throws IOException if an error occurs while creating a new server socket.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.879 -0500", hash_original_method = "ED335FF1D7604977C78C3FC5EF0DE0C4", hash_generated_method = "C9707838AAD058E99D35EB1E4455E2A9")
    
public abstract ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress)
            throws IOException;
}

