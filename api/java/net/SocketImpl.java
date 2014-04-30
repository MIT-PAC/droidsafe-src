package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class SocketImpl implements SocketOptions {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.273 -0500", hash_original_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4", hash_generated_field = "3EF85E4B8326DFDFB5F1248DB5848FBE")

    @DSVAModeled
    protected InetAddress address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.275 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    @DSVAModeled
    protected int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.277 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "22B1DDEE70BE0A6499271C452045F538")

    @DSVAModeled
    protected FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.279 -0500", hash_original_field = "375BC793FA524CA3913F5FC07B349157", hash_generated_field = "ACF030B7409F7B39EDB4C92454C3B34B")

    @DSVAModeled
    protected int localport;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.521 -0400", hash_original_method = "64E339C1199B48FCA9D5B6162E68A4EE", hash_generated_method = "64E339C1199B48FCA9D5B6162E68A4EE")
    public SocketImpl ()
    {
        //Synthesized constructor
    }

    /**
     * Waits for an incoming request and blocks until the connection is opened
     * on the given socket.
     *
     * @param newSocket
     *            the socket to accept connections on.
     * @throws IOException
     *             if an error occurs while accepting a new connection.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.282 -0500", hash_original_method = "645B5DBF048DCD18F59C6757E454F4D9", hash_generated_method = "BBB92267CBAC43C391E741D88616664E")
    
protected abstract void accept(SocketImpl newSocket) throws IOException;

    /**
     * Returns the available number of bytes which are readable from this socket
     * without blocking.
     *
     * @return the number of bytes that may be read without blocking.
     * @throws IOException
     *             if an error occurs while reading the number of bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.284 -0500", hash_original_method = "475CB5F8D51E2295C86383D238A46C23", hash_generated_method = "5DEFA11F3DB1D1F1EBD0764907987629")
    
protected abstract int available() throws IOException;

    /**
     * Binds this socket to the specified local host address and port number.
     *
     * @param address
     *            the local machine address to bind this socket to.
     * @param port
     *            the port on the local machine to bind this socket to.
     * @throws IOException
     *             if an error occurs while binding this socket.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.287 -0500", hash_original_method = "B35FD8FDDA4392F4983DCA3861EA0A20", hash_generated_method = "7B0636ABD6BAC64FB656EC1E219CCDE6")
    
protected abstract void bind(InetAddress address, int port) throws IOException;

    /**
     * Closes this socket. This makes later access invalid.
     *
     * @throws IOException
     *             if an error occurs while closing this socket.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.289 -0500", hash_original_method = "4E507319564A7E0BFD2A58D57A800811", hash_generated_method = "15CA5096178B277456927E8499C27D0F")
    
protected abstract void close() throws IOException;

    /**
     * Connects this socket to the specified remote host and port number.
     *
     * @param host
     *            the remote host this socket has to be connected to.
     * @param port
     *            the remote port on which this socket has to be connected.
     * @throws IOException
     *             if an error occurs while connecting to the remote host.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.291 -0500", hash_original_method = "38B5A5FB7EFED572FF5EC5E4770CBCFB", hash_generated_method = "83E516264843228C6E92E0DB8302FA82")
    
protected abstract void connect(String host, int port) throws IOException;

    /**
     * Connects this socket to the specified remote host address and port
     * number.
     *
     * @param address
     *            the remote host address this socket has to be connected to.
     * @param port
     *            the remote port on which this socket has to be connected.
     * @throws IOException
     *             if an error occurs while connecting to the remote host.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.294 -0500", hash_original_method = "908ED6130F1E488FED630AF4785D4A89", hash_generated_method = "9B5EF385EE038269353FD4B56E16B17E")
    
protected abstract void connect(InetAddress address, int port)
            throws IOException;

    /**
     * Creates a new unconnected socket. The argument {@code isStreaming}
     * defines whether the new socket is a streaming or a datagram socket.
     *
     * @param isStreaming
     *            defines whether the type of the new socket is streaming or
     *            datagram.
     * @throws IOException
     *             if an error occurs while creating the socket.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.297 -0500", hash_original_method = "7920B6A12583802C29C666184FDA8B00", hash_generated_method = "FDF593B1D2CD3575E63889DB26A2437F")
    
protected abstract void create(boolean isStreaming) throws IOException;

    /**
     * Gets the file descriptor of this socket.
     *
     * @return the file descriptor of this socket.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.299 -0500", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "C8664C638E6E7676776FC905B50F6CA8")
    
protected FileDescriptor getFileDescriptor() {
        return fd;
    }

    /**
     * @hide used by java.nio
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.302 -0500", hash_original_method = "D80DA3748C8C317EA54CA4C7D2D15552", hash_generated_method = "451E90B848B53AC66CF1CF9E4293CFFC")
    
public FileDescriptor getFD$() {
        return fd;
    }

    /**
     * Gets the remote address this socket is connected to.
     *
     * @return the remote address of this socket.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.304 -0500", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "A76BD5A3A0567AC89CB96B150B9A1D96")
    
protected InetAddress getInetAddress() {
        return address;
    }

    /**
     * Gets the input stream of this socket.
     *
     * @return the input stream of this socket.
     * @throws IOException
     *             if an error occurs while accessing the input stream.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.306 -0500", hash_original_method = "52F11B552F1B3154F1756AD14B960B45", hash_generated_method = "96F61ADB722E9F76BE69B063343A5CC4")
    
protected abstract InputStream getInputStream() throws IOException;

    /**
     * Gets the local port number of this socket. The field is initialized to
     * {@code -1} and upon demand will go to the IP stack to get the bound
     * value. See the class comment for the context of the local port.
     *
     * @return the local port number this socket is bound to.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.310 -0500", hash_original_method = "01F8313D57DE36AB40371D3553F872FB", hash_generated_method = "AF64DAFDACDB1E0D6A98E42A80A3630E")
    
protected int getLocalPort() {
        return localport;
    }

    /**
     * Gets the output stream of this socket.
     *
     * @return the output stream of this socket.
     * @throws IOException
     *             if an error occurs while accessing the output stream.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.312 -0500", hash_original_method = "330BE02AC50F8D4A343AF4F02DD1EC2D", hash_generated_method = "5C6182F1AD2C43AE325D52675A84DCB0")
    
protected abstract OutputStream getOutputStream() throws IOException;

    /**
     * Gets the remote port number of this socket. This value is not meaningful
     * when this instance is wrapped by a {@code ServerSocket}.
     *
     * @return the remote port this socket is connected to.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.314 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "FD3C86BDDAB9A6DA7A4F92F97CB82D65")
    
protected int getPort() {
        return port;
    }

    /**
     * Listens for connection requests on this streaming socket. Incoming
     * connection requests are queued up to the limit specified by {@code
     * backlog}. Additional requests are rejected. This method
     * may only be invoked on stream sockets.
     *
     * @param backlog
     *            the maximum number of outstanding connection requests.
     * @throws IOException
     *             if an error occurs while listening.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.317 -0500", hash_original_method = "31E00E585554C3B539DD3819BF57995C", hash_generated_method = "48720B1DA3F6EB43B22414401D4AD857")
    
protected abstract void listen(int backlog) throws IOException;

    /**
     * Returns a string containing a concise, human-readable description of the
     * socket.
     *
     * @return the textual representation of this socket.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.319 -0500", hash_original_method = "2E2A133215115434551D3BB5177B3CB7", hash_generated_method = "F27A04F4DEA11ED1EBC3CB8C865D5A4C")
    
@Override
    public String toString() {
        return "Socket[address=" + getInetAddress() +
                ",port=" + port + ",localPort=" + getLocalPort() + "]";
    }

    /**
     * Closes the input channel of this socket.
     *
     * <p>This default implementation always throws an {@link IOException} to
     * indicate that the subclass should have overridden this method.
     *
     * @throws IOException
     *             always because this method should be overridden.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.322 -0500", hash_original_method = "A81CC3909CCB8928C92493E5F4DBFE10", hash_generated_method = "84C34B734C539D4D4EACD72B5AD3FFC2")
    
protected void shutdownInput() throws IOException {
        throw new IOException("Method has not been implemented");
    }

    /**
     * Closes the output channel of this socket.
     *
     * <p>This default implementation always throws an {@link IOException} to
     * indicate that the subclass should have overridden this method.
     *
     * @throws IOException
     *             always because this method should be overridden.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.324 -0500", hash_original_method = "C4499DE00FFEC19A29C9ABDAA427CE4E", hash_generated_method = "1FA4C9186B33650D09BE292279E5FA8D")
    
protected void shutdownOutput() throws IOException {
        throw new IOException("Method has not been implemented");
    }

    /**
     * Connects this socket to the remote host address and port number specified
     * by the {@code SocketAddress} object with the given timeout. This method
     * will block indefinitely if the timeout is set to zero.
     *
     * @param remoteAddr
     *            the remote host address and port number to connect to.
     * @param timeout
     *            the timeout value in milliseconds.
     * @throws IOException
     *             if an error occurs while connecting.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.327 -0500", hash_original_method = "0938D29B6C6CBAFB749AFF2C51174A7C", hash_generated_method = "D2555095D342CD6F13874B49069CDA71")
    
protected abstract void connect(SocketAddress remoteAddr, int timeout) throws IOException;

    /**
     * Returns whether the socket supports urgent data or not. Subclasses should
     * override this method.
     *
     * @return {@code false} because subclasses must override this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.329 -0500", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "3435B1388EBB6C0D83AB9F72304C63D8")
    
protected boolean supportsUrgentData() {
        return false;
    }

    /**
     * Sends the single byte of urgent data on the socket.
     *
     * @param value
     *            the byte of urgent data.
     * @throws IOException
     *             if an error occurs sending urgent data.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.331 -0500", hash_original_method = "B0A374769C8195FE4D3B843710F3EA68", hash_generated_method = "F7D2890C251A546AC0554DB0E4B6951E")
    
protected abstract void sendUrgentData(int value) throws IOException;

    /**
     * Sets performance preference for connection time, latency and bandwidth.
     * Does nothing by default.
     *
     * @param connectionTime
     *            the importance of connect time.
     * @param latency
     *            the importance of latency.
     * @param bandwidth
     *            the importance of bandwidth.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.333 -0500", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "8007148E8E33A2E2AD01814FEF5B1086")
    
protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
    }
    
}

