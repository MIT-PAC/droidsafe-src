package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;

import libcore.io.IoBridge;

public class Socket {

    /**
     * Sets the internal factory for creating socket implementations. This may
     * only be executed once during the lifetime of the application.
     *
     * @param fac
     *            the socket implementation factory to be set.
     * @throws IOException
     *             if the factory has been already set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.795 -0500", hash_original_method = "7DC30A2B7ED25A0941F90DF00E383A5A", hash_generated_method = "BAB4AF5A16325664A126C9AF8B2CAB2E")
    
public static synchronized void setSocketImplFactory(SocketImplFactory fac)
            throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.702 -0500", hash_original_field = "D13BB32EBB2361D82290016DAD496DC0", hash_generated_field = "ABE875F9FF8F88D9D548D2F2A5A13861")

    private static SocketImplFactory factory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.705 -0500", hash_original_field = "76382137C184A183F2BF2D8583A90AEC", hash_generated_field = "76382137C184A183F2BF2D8583A90AEC")

    @DSVAModeled
     SocketImpl impl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.707 -0500", hash_original_field = "CA775536D3A7F4013C2E9C464BE24463", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private  Proxy proxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.709 -0500", hash_original_field = "271B073974464C9D5A15CF255DE64C37", hash_generated_field = "FEFE85DE55A57D0EBA9EA9B6592B8458")

    volatile boolean isCreated = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.712 -0500", hash_original_field = "F9AB7682F64A4F93F6F4A7A435A5AA53", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.715 -0500", hash_original_field = "B48043272C25E776A9FBEC8A0B198F87", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.717 -0500", hash_original_field = "79ECB5C84997278EAA42676EDFBD1FF8", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.719 -0500", hash_original_field = "A64BD5C1D5BD7FB7156CD3DBC32D26FB", hash_generated_field = "7BF3C47813946CC98E6B4F51776BE0B2")

    private boolean isInputShutdown = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.721 -0500", hash_original_field = "7D3A2E95845B96489626D2BDCB5B7F23", hash_generated_field = "155847C1017F44FA011CC3F03B209D80")

    private boolean isOutputShutdown = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.723 -0500", hash_original_field = "0B4773EA0A3167016F59761BAEB913EF", hash_generated_field = "A8E9D68398963C6A7BD51AC2BEC0E3CA")

    private InetAddress localAddress = Inet4Address.ANY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.726 -0500", hash_original_field = "99DA49219FBE84DB37A0CF6E89AC6E90", hash_generated_field = "574736669071BAC15E2D1E76082A2D20")

    private final Object connectLock = new Object();

    /**
     * Creates a new unconnected socket. When a SocketImplFactory is defined it
     * creates the internal socket implementation, otherwise the default socket
     * implementation will be used for this socket.
     *
     * @see SocketImplFactory
     * @see SocketImpl
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.729 -0500", hash_original_method = "DE6B6B5588954C6A35AB00A23B1617FE", hash_generated_method = "24D8AF97881FC81FD7824F1A915C2F48")
    
public Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
    }

    /**
     * Creates a new unconnected socket using the given proxy type. When a
     * {@code SocketImplFactory} is defined it creates the internal socket
     * implementation, otherwise the default socket implementation will be used
     * for this socket.
     * <p>
     * Example that will create a socket connection through a {@code SOCKS}
     * proxy server: <br>
     * {@code Socket sock = new Socket(new Proxy(Proxy.Type.SOCKS, new
     * InetSocketAddress("test.domain.org", 2130)));}
     *
     * @param proxy
     *            the specified proxy for this socket.
     * @throws IllegalArgumentException
     *             if the argument {@code proxy} is {@code null} or of an
     *             invalid type.
     * @see SocketImplFactory
     * @see SocketImpl
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.732 -0500", hash_original_method = "903F698227E2205A08AC4EC3E6D912C3", hash_generated_method = "D980E618455C5863EA3B58E2F36FDB40")
    
public Socket(Proxy proxy) {
        if (proxy == null || proxy.type() == Proxy.Type.HTTP) {
            throw new IllegalArgumentException("Invalid proxy: " + proxy);
        }
        this.proxy = proxy;
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
    }

    /**
     * Creates a new streaming socket connected to the target host specified by
     * the parameters {@code dstName} and {@code dstPort}. The socket is bound
     * to any available port on the local host.
     *
     * <p>This implementation tries each IP address for the given hostname (in
     * <a href="http://www.ietf.org/rfc/rfc3484.txt">RFC 3484</a> order)
     * until it either connects successfully or it exhausts the set.
     *
     * @param dstName
     *            the target host name or IP address to connect to.
     * @param dstPort
     *            the port on the target host to connect to.
     * @throws UnknownHostException
     *             if the host name could not be resolved into an IP address.
     * @throws IOException
     *             if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.737 -0500", hash_original_method = "59B1F76D08717F2A7DB6178659D1BD4D", hash_generated_method = "6316CA7E40A21D61D9B9CAFA97BA22ED")
    
public Socket(String dstName, int dstPort) throws UnknownHostException, IOException {
        this(dstName, dstPort, null, 0);
    }

    /**
     * Creates a new streaming socket connected to the target host specified by
     * the parameters {@code dstName} and {@code dstPort}. On the local endpoint
     * the socket is bound to the given address {@code localAddress} on port
     * {@code localPort}. If {@code host} is {@code null} a loopback address is used to connect to.
     *
     * <p>This implementation tries each IP address for the given hostname (in
     * <a href="http://www.ietf.org/rfc/rfc3484.txt">RFC 3484</a> order)
     * until it either connects successfully or it exhausts the set.
     *
     * @param dstName
     *            the target host name or IP address to connect to.
     * @param dstPort
     *            the port on the target host to connect to.
     * @param localAddress
     *            the address on the local host to bind to.
     * @param localPort
     *            the port on the local host to bind to.
     * @throws UnknownHostException
     *             if the host name could not be resolved into an IP address.
     * @throws IOException
     *             if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.740 -0500", hash_original_method = "7A6ED28BC12F5ABFF2F2CE0F9C5717C0", hash_generated_method = "9C677317C87580468FBBC3BC25BFED31")
    
public Socket(String dstName, int dstPort, InetAddress localAddress, int localPort) throws IOException {
        this();
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
    }

    /**
     * Creates a new streaming or datagram socket connected to the target host
     * specified by the parameters {@code hostName} and {@code port}. The socket
     * is bound to any available port on the local host.
     *
     * <p>This implementation tries each IP address for the given hostname (in
     * <a href="http://www.ietf.org/rfc/rfc3484.txt">RFC 3484</a> order)
     * until it either connects successfully or it exhausts the set.
     *
     * @param hostName
     *            the target host name or IP address to connect to.
     * @param port
     *            the port on the target host to connect to.
     * @param streaming
     *            if {@code true} a streaming socket is returned, a datagram
     *            socket otherwise.
     * @throws UnknownHostException
     *             if the host name could not be resolved into an IP address.
     * @throws IOException
     *             if an error occurs while creating the socket.
     * @deprecated Use {@code Socket(String, int)} instead of this for streaming
     *             sockets or an appropriate constructor of {@code
     *             DatagramSocket} for UDP transport.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.744 -0500", hash_original_method = "1948ABC1DE3B1C37A63093E998C50FE7", hash_generated_method = "C650B30E681882C8D76DB812E2F56676")
    
@Deprecated
    public Socket(String hostName, int port, boolean streaming) throws IOException {
        this();
        tryAllAddresses(hostName, port, null, 0, streaming);
    }

    /**
     * Creates a new streaming socket connected to the target host specified by
     * the parameters {@code dstAddress} and {@code dstPort}. The socket is
     * bound to any available port on the local host.
     *
     * @param dstAddress
     *            the target host address to connect to.
     * @param dstPort
     *            the port on the target host to connect to.
     * @throws IOException
     *             if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.747 -0500", hash_original_method = "A1767A7E1F84ED40BDB339014C4851EF", hash_generated_method = "80204189B6A824DCFD0C9110D1ADFD5C")
    
public Socket(InetAddress dstAddress, int dstPort) throws IOException {
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, null, 0, true);
    }

    /**
     * Creates a new streaming socket connected to the target host specified by
     * the parameters {@code dstAddress} and {@code dstPort}. On the local
     * endpoint the socket is bound to the given address {@code localAddress} on
     * port {@code localPort}.
     *
     * @param dstAddress
     *            the target host address to connect to.
     * @param dstPort
     *            the port on the target host to connect to.
     * @param localAddress
     *            the address on the local host to bind to.
     * @param localPort
     *            the port on the local host to bind to.
     * @throws IOException
     *             if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.749 -0500", hash_original_method = "BE0D4569A05DA3EF578449A5DA65F5E7", hash_generated_method = "0E8F2DC694F5FBD63C66F979FDE19EBD")
    
public Socket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort) throws IOException {
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
    }

    /**
     * Creates a new streaming or datagram socket connected to the target host
     * specified by the parameters {@code addr} and {@code port}. The socket is
     * bound to any available port on the local host.
     *
     * @param addr
     *            the Internet address to connect to.
     * @param port
     *            the port on the target host to connect to.
     * @param streaming
     *            if {@code true} a streaming socket is returned, a datagram
     *            socket otherwise.
     * @throws IOException
     *             if an error occurs while creating the socket.
     * @deprecated Use {@code Socket(InetAddress, int)} instead of this for
     *             streaming sockets or an appropriate constructor of {@code
     *             DatagramSocket} for UDP transport.
     */
    @DSComment("constructor")
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.752 -0500", hash_original_method = "D85BA2D34027734E343FA152CA6CE177", hash_generated_method = "6B14DA291D9EF1DF9AC5EA862FF0318C")
    
@Deprecated
    public Socket(InetAddress addr, int port, boolean streaming) throws IOException {
        this();
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
    }

    /**
     * Creates an unconnected socket with the given socket implementation.
     *
     * @param impl
     *            the socket implementation to be used.
     * @throws SocketException
     *             if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.755 -0500", hash_original_method = "3BE6817A95031499261EFB4432AAFCBF", hash_generated_method = "DD263612467E12256A9D2943B451B889")
    
protected Socket(SocketImpl impl) throws SocketException {
        this.impl = impl;
        this.proxy = null;
    }

    /**
     * Tries to connect a socket to all IP addresses of the given hostname.
     *
     * @param dstName
     *            the target host name or IP address to connect to.
     * @param dstPort
     *            the port on the target host to connect to.
     * @param localAddress
     *            the address on the local host to bind to.
     * @param localPort
     *            the port on the local host to bind to.
     * @param streaming
     *            if {@code true} a streaming socket is returned, a datagram
     *            socket otherwise.
     * @throws UnknownHostException
     *             if the host name could not be resolved into an IP address.
     * @throws IOException
     *             if an error occurs while creating the socket.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.735 -0500", hash_original_method = "FE893551BF445ECD0CF959494571F82D", hash_generated_method = "8F0D47E467026B0C124288864DEB5D88")
    
private void tryAllAddresses(String dstName, int dstPort, InetAddress
            localAddress, int localPort, boolean streaming) throws IOException {
        InetAddress[] dstAddresses = InetAddress.getAllByName(dstName);
        // Loop through all the destination addresses except the last, trying to
        // connect to each one and ignoring errors. There must be at least one
        // address, or getAllByName would have thrown UnknownHostException.
        InetAddress dstAddress;
        for (int i = 0; i < dstAddresses.length - 1; i++) {
            dstAddress = dstAddresses[i];
            try {
                checkDestination(dstAddress, dstPort);
                startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
                return;
            } catch (IOException ex) {
            }
        }

        // Now try to connect to the last address in the array, handing back to
        // the caller any exceptions that are thrown.
        dstAddress = dstAddresses[dstAddresses.length - 1];
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, streaming);
    }

    /**
     * Checks whether the connection destination satisfies the security policy
     * and the validity of the port range.
     *
     * @param destAddr
     *            the destination host address.
     * @param dstPort
     *            the port on the destination host.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.758 -0500", hash_original_method = "B238EF3FEB62ADA205D3F3298560A137", hash_generated_method = "BAAC5EC1F498C64E9C7C929F02966619")
    
private void checkDestination(InetAddress destAddr, int dstPort) {
        if (dstPort < 0 || dstPort > 65535) {
            throw new IllegalArgumentException("Port out of range: " + dstPort);
        }
    }

    /**
     * Closes the socket. It is not possible to reconnect or rebind to this
     * socket thereafter which means a new socket instance has to be created.
     *
     * @throws IOException
     *             if an error occurs while closing the socket.
     */
    @DSComment("no info leak")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.760 -0500", hash_original_method = "6609A304DB40C6FFC8F6AC783F01FDAC", hash_generated_method = "ED7C68A509180A9A266A476496F0821D")
    
public synchronized void close() throws IOException {
        isClosed = true;
        // RI compatibility: the RI returns the any address (but the original local port) after close.
        localAddress = Inet4Address.ANY;
        impl.close();
    }

    /**
     * Returns the IP address of the target host this socket is connected to, or null if this
     * socket is not yet connected.
     */
    @DSComment("potential info leak")
    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.762 -0500", hash_original_method = "084821CC0A1E0331CE4D2BB5EC46E415", hash_generated_method = "035752FAFAA541B776502AEB7625AC4B")
    
public InetAddress getInetAddress() {
        if (!isConnected()) {
            return null;
        }
        return impl.getInetAddress();
    }

    /**
     * Returns an input stream to read data from this socket.
     *
     * @return the byte-oriented input stream.
     * @throws IOException
     *             if an error occurs while creating the input stream or the
     *             socket is in an invalid state.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.764 -0500", hash_original_method = "83F4AB21434B41B13879E1F39D268878", hash_generated_method = "6A888960A97927C9FE7BA113727A3BC0")
    
public InputStream getInputStream() throws IOException {
        checkOpenAndCreate(false);
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        return impl.getInputStream();
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_KEEPALIVE} setting.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.767 -0500", hash_original_method = "CB6F12AE5628FD4A044BF4AD41BFB963", hash_generated_method = "B7F0F19C2A20C66ABC7FE8AC44F97F4C")
    
public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        return (Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE);
    }

    /**
     * Returns the local IP address this socket is bound to, or {@code InetAddress.ANY} if
     * the socket is unbound.
     */
    @DSComment("potential info leak")
    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.769 -0500", hash_original_method = "B81D9B2A12700622583B88DBCF07EC2E", hash_generated_method = "E7886D89DC17F90FB319BF6401B5F681")
    
public InetAddress getLocalAddress() {
        return localAddress;
    }

    /**
     * Returns the local port this socket is bound to, or -1 if the socket is unbound.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.772 -0500", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "7757875108A58B1E253356DE798623DA")
    
public int getLocalPort() {
        if (!isBound()) {
            return -1;
        }
        return impl.getLocalPort();
    }

    /**
     * Returns an output stream to write data into this socket.
     *
     * @return the byte-oriented output stream.
     * @throws IOException
     *             if an error occurs while creating the output stream or the
     *             socket is in an invalid state.
     */
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.774 -0500", hash_original_method = "0AB25EAA0774AA81766D4356986FC34F", hash_generated_method = "7FE0092975A1C779207A619656F7BC91")
    
public OutputStream getOutputStream() throws IOException {
        checkOpenAndCreate(false);
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        return impl.getOutputStream();
    }

    /**
     * Returns the port number of the target host this socket is connected to, or 0 if this socket
     * is not yet connected.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.777 -0500", hash_original_method = "0A0FE55C893091E17125D546A7D59C8C", hash_generated_method = "2CD0DBDC8C6EBD34BBC1C81F3A3F646A")
    
public int getPort() {
        if (!isConnected()) {
            return 0;
        }
        return impl.getPort();
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_LINGER linger} timeout in seconds, or -1
     * for no linger (i.e. {@code close} will return immediately).
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.779 -0500", hash_original_method = "8044EC6E5CF2F698E1FE570A36824B05", hash_generated_method = "DD8C828A10DD4054CE1BA7E30D774692")
    
public int getSoLinger() throws SocketException {
        checkOpenAndCreate(true);
        // The RI explicitly guarantees this idiocy in the SocketOptions.setOption documentation.
        Object value = impl.getOption(SocketOptions.SO_LINGER);
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            return -1;
        }
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_RCVBUF receive buffer size}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.782 -0500", hash_original_method = "49326126DE06A7EC2CFFBD7B3A14AE31", hash_generated_method = "5B9B0491840E0351513757AA16652639")
    
public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.SO_RCVBUF);
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_SNDBUF send buffer size}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.785 -0500", hash_original_method = "9FF5297C2B145A55844611E68CB98459", hash_generated_method = "65FD2B8459D30721899E91FB1B00707B")
    
public synchronized int getSendBufferSize() throws SocketException {
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.SO_SNDBUF);
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_TIMEOUT receive timeout}.
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.788 -0500", hash_original_method = "7DAE79431B5F9BEF40635CDD183C2B59", hash_generated_method = "9E2A63F81E256F78F33E2AEA9CDD43C5")
    
public synchronized int getSoTimeout() throws SocketException {
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.SO_TIMEOUT);
    }

    /**
     * Returns this socket's {@code SocketOptions#TCP_NODELAY} setting.
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.790 -0500", hash_original_method = "3F059C4060D675A8035CAA8B5017EE1E", hash_generated_method = "028D8B84B7562641572ADBA47276ABA8")
    
public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        return (Boolean) impl.getOption(SocketOptions.TCP_NODELAY);
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_KEEPALIVE} option.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.792 -0500", hash_original_method = "B94B1A38E8CA82DAB010EC0768F89732", hash_generated_method = "EF88431EFCC396F01C11E1AE35061AE8")
    
public void setKeepAlive(boolean keepAlive) throws SocketException {
        if (impl != null) {
            checkOpenAndCreate(true);
            impl.setOption(SocketOptions.SO_KEEPALIVE, Boolean.valueOf(keepAlive));
        }
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF send buffer size}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.798 -0500", hash_original_method = "AEB667B5DBC425D73D37135566ECC286", hash_generated_method = "2BACDB608F27E2DA5EA3F1A1CC0AE41C")
    
public synchronized void setSendBufferSize(int size) throws SocketException {
        checkOpenAndCreate(true);
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF receive buffer size}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.801 -0500", hash_original_method = "1376DE896B8682F991877B7A17C5B3A4", hash_generated_method = "E8C94E07AE5129400B83D2720335F5D5")
    
public synchronized void setReceiveBufferSize(int size) throws SocketException {
        checkOpenAndCreate(true);
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_LINGER linger} timeout in seconds.
     * If {@code on} is false, {@code timeout} is irrelevant.
     */
    @DSComment("no info leak")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.803 -0500", hash_original_method = "89C38D96E5FBD4D1BD6CE4BD573A4473", hash_generated_method = "1A27C288186A15DD21BEFF577A37F9F2")
    
public void setSoLinger(boolean on, int timeout) throws SocketException {
        checkOpenAndCreate(true);
        // The RI explicitly guarantees this idiocy in the SocketOptions.setOption documentation.
        if (on && timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (on) {
            impl.setOption(SocketOptions.SO_LINGER, Integer.valueOf(timeout));
        } else {
            impl.setOption(SocketOptions.SO_LINGER, Boolean.FALSE);
        }
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_TIMEOUT read timeout} in milliseconds.
     * Use 0 for no timeout.
     * To take effect, this option must be set before the blocking method was called.
     */
    @DSComment("no info leak")
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.805 -0500", hash_original_method = "EA919996CC1899AC4E781314DA47161A", hash_generated_method = "3DFB1A74D06365DC93C5D8EB35AF634C")
    
public synchronized void setSoTimeout(int timeout) throws SocketException {
        checkOpenAndCreate(true);
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    /**
     * Sets this socket's {@link SocketOptions#TCP_NODELAY} option.
     */
    @DSComment("no info leak")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.808 -0500", hash_original_method = "04E6A4AAAA03D3C2F3E4334A66D2F7A1", hash_generated_method = "D3F378CA149CFF25D39A9240F7510EC4")
    
public void setTcpNoDelay(boolean on) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
    }

    /**
     * Creates a stream socket, binds it to the nominated local address/port,
     * then connects it to the nominated destination address/port.
     *
     * @param dstAddress
     *            the destination host address.
     * @param dstPort
     *            the port on the destination host.
     * @param localAddress
     *            the address on the local machine to bind.
     * @param localPort
     *            the port on the local machine to bind.
     * @throws IOException
     *             thrown if an error occurs during the bind or connect
     *             operations.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.810 -0500", hash_original_method = "20DD1F1CA9EDC17BE2B90F2B7E5FF655", hash_generated_method = "15634D69F6AFF53B8F514BC3002CEC1C")
    
private void startupSocket(InetAddress dstAddress, int dstPort,
            InetAddress localAddress, int localPort, boolean streaming)
            throws IOException {

        if (localPort < 0 || localPort > 65535) {
            throw new IllegalArgumentException("Local port out of range: " + localPort);
        }

        InetAddress addr = localAddress == null ? Inet4Address.ANY : localAddress;
        synchronized (this) {
            impl.create(streaming);
            isCreated = true;
            try {
                if (!streaming || !usingSocks()) {
                    impl.bind(addr, localPort);
                }
                isBound = true;
                impl.connect(dstAddress, dstPort);
                isConnected = true;
                cacheLocalAddress();
            } catch (IOException e) {
                impl.close();
                throw e;
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.812 -0500", hash_original_method = "933F73796CB698722A986AC13FC9BFF8", hash_generated_method = "286D168AC5969CEEC8D7177AFB54002B")
    
private boolean usingSocks() {
        return proxy != null && proxy.type() == Proxy.Type.SOCKS;
    }

    /**
     * Returns a {@code String} containing a concise, human-readable description of the
     * socket.
     *
     * @return the textual representation of this socket.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.816 -0500", hash_original_method = "881D40A46B027F3EDC8B30A9F4F44097", hash_generated_method = "28E5917CBB14515A1B4DB8F75FF70BE0")
    
@Override
    public String toString() {
        if (!isConnected()) {
            return "Socket[unconnected]";
        }
        return impl.toString();
    }

    /**
     * Closes the input stream of this socket. Any further data sent to this
     * socket will be discarded. Reading from this socket after this method has
     * been called will return the value {@code EOF}.
     *
     * @throws IOException
     *             if an error occurs while closing the socket input stream.
     * @throws SocketException
     *             if the input stream is already closed.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.818 -0500", hash_original_method = "D21BBF88E7F4579ADC8933941E3433FA", hash_generated_method = "81C512F189B1182D65AD5E8B04B3BD3A")
    
public void shutdownInput() throws IOException {
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        checkOpenAndCreate(false);
        impl.shutdownInput();
        isInputShutdown = true;
    }

    /**
     * Closes the output stream of this socket. All buffered data will be sent
     * followed by the termination sequence. Writing to the closed output stream
     * will cause an {@code IOException}.
     *
     * @throws IOException
     *             if an error occurs while closing the socket output stream.
     * @throws SocketException
     *             if the output stream is already closed.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.820 -0500", hash_original_method = "1AECC9ACE476BBC93D823FC75BDACBC6", hash_generated_method = "44045D291AD7392C8760F4BF20807225")
    
public void shutdownOutput() throws IOException {
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        checkOpenAndCreate(false);
        impl.shutdownOutput();
        isOutputShutdown = true;
    }

    /**
     * Checks whether the socket is closed, and throws an exception. Otherwise
     * creates the underlying SocketImpl.
     *
     * @throws SocketException
     *             if the socket is closed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.823 -0500", hash_original_method = "80C03A9E4F151BE4271ACE586291D7DE", hash_generated_method = "C6BB1C000EDEB0F6A93654FF0C5C25A9")
    
private void checkOpenAndCreate(boolean create) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!create) {
            if (!isConnected()) {
                throw new SocketException("Socket is not connected");
                // a connected socket must be created
            }

            /*
             * return directly to fix a possible bug, if !create, should return
             * here
             */
            return;
        }
        if (isCreated) {
            return;
        }
        synchronized (this) {
            if (isCreated) {
                return;
            }
            try {
                impl.create(true);
            } catch (SocketException e) {
                throw e;
            } catch (IOException e) {
                throw new SocketException(e.toString());
            }
            isCreated = true;
        }
    }

    /**
     * Returns the local address and port of this socket as a SocketAddress or
     * null if the socket is unbound. This is useful on multihomed
     * hosts.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.826 -0500", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "67B8A39634FC3A72D60F6B588EC9B04B")
    
public SocketAddress getLocalSocketAddress() {
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    /**
     * Returns the remote address and port of this socket as a {@code
     * SocketAddress} or null if the socket is not connected.
     *
     * @return the remote socket address and port.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.829 -0500", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "C1CDFAAC803588FC140B6196FA164411")
    
public SocketAddress getRemoteSocketAddress() {
        if (!isConnected()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getPort());
    }

    /**
     * Returns whether this socket is bound to a local address and port.
     *
     * @return {@code true} if the socket is bound to a local address, {@code
     *         false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.831 -0500", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "A878CB652BF3277F9F7822AB8074E046")
    
public boolean isBound() {
        return isBound;
    }

    /**
     * Returns whether this socket is connected to a remote host.
     *
     * @return {@code true} if the socket is connected, {@code false} otherwise.
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.833 -0500", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "04CA4546F9019A1940AA3235F1228ADE")
    
public boolean isConnected() {
        return isConnected;
    }

    /**
     * Returns whether this socket is closed.
     *
     * @return {@code true} if the socket is closed, {@code false} otherwise.
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.836 -0500", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "10C0B8E2B9DF49DDBC078E9919A022F7")
    
public boolean isClosed() {
        return isClosed;
    }

    /**
     * Binds this socket to the given local host address and port specified by
     * the SocketAddress {@code localAddr}. If {@code localAddr} is set to
     * {@code null}, this socket will be bound to an available local address on
     * any free port.
     *
     * @param localAddr
     *            the specific address and port on the local machine to bind to.
     * @throws IllegalArgumentException
     *             if the given SocketAddress is invalid or not supported.
     * @throws IOException
     *             if the socket is already bound or an error occurs while
     *             binding.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.839 -0500", hash_original_method = "9E3C378994EF9A4091E39D0FA34770F8", hash_generated_method = "D0C31E3A84FEA3EC846026D0B18E8F69")
    
public void bind(SocketAddress localAddr) throws IOException {
        checkOpenAndCreate(true);
        if (isBound()) {
            throw new BindException("Socket is already bound");
        }

        int port = 0;
        InetAddress addr = Inet4Address.ANY;
        if (localAddr != null) {
            if (!(localAddr instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            }
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            if ((addr = inetAddr.getAddress()) == null) {
                throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
            }
            port = inetAddr.getPort();
        }

        synchronized (this) {
            try {
                impl.bind(addr, port);
                isBound = true;
                cacheLocalAddress();
            } catch (IOException e) {
                impl.close();
                throw e;
            }
        }
    }

    /**
     * Connects this socket to the given remote host address and port specified
     * by the SocketAddress {@code remoteAddr}.
     *
     * @param remoteAddr
     *            the address and port of the remote host to connect to.
     * @throws IllegalArgumentException
     *             if the given SocketAddress is invalid or not supported.
     * @throws IOException
     *             if the socket is already connected or an error occurs while
     *             connecting.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.841 -0500", hash_original_method = "B2F3815725658D73C0532A54E6C164BA", hash_generated_method = "AE3DC0528EB0E6538EC2417B0369366A")
    
public void connect(SocketAddress remoteAddr) throws IOException {
        connect(remoteAddr, 0);
    }

    /**
     * Connects this socket to the given remote host address and port specified
     * by the SocketAddress {@code remoteAddr} with the specified timeout. The
     * connecting method will block until the connection is established or an
     * error occurred.
     *
     * @param remoteAddr
     *            the address and port of the remote host to connect to.
     * @param timeout
     *            the timeout value in milliseconds or {@code 0} for an infinite
     *            timeout.
     * @throws IllegalArgumentException
     *             if the given SocketAddress is invalid or not supported or the
     *             timeout value is negative.
     * @throws IOException
     *             if the socket is already connected or an error occurs while
     *             connecting.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.844 -0500", hash_original_method = "45EED4DE787227F7BEC68E335C7AA6E7", hash_generated_method = "7616BDB1DAEC13E9767FAD09B4C3E893")
    
public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        checkOpenAndCreate(true);
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (isConnected()) {
            throw new SocketException("Already connected");
        }
        if (remoteAddr == null) {
            throw new IllegalArgumentException("remoteAddr == null");
        }

        if (!(remoteAddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Remote address not an InetSocketAddress: " +
                    remoteAddr.getClass());
        }
        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
        InetAddress addr;
        if ((addr = inetAddr.getAddress()) == null) {
            throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
        }
        int port = inetAddr.getPort();

        checkDestination(addr, port);
        synchronized (connectLock) {
            try {
                if (!isBound()) {
                    // socket already created at this point by earlier call or
                    // checkOpenAndCreate this caused us to lose socket
                    // options on create
                    // impl.create(true);
                    if (!usingSocks()) {
                        impl.bind(Inet4Address.ANY, 0);
                    }
                    isBound = true;
                }
                impl.connect(remoteAddr, timeout);
                isConnected = true;
                cacheLocalAddress();
            } catch (IOException e) {
                impl.close();
                throw e;
            }
        }
    }

    /**
     * Returns whether the incoming channel of the socket has already been
     * closed.
     *
     * @return {@code true} if reading from this socket is not possible anymore,
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.847 -0500", hash_original_method = "2FA07403172C73A0B79A0DF7F37DEBFB", hash_generated_method = "292ABABAAF94A2EB587343519213959C")
    
public boolean isInputShutdown() {
        return isInputShutdown;
    }

    /**
     * Returns whether the outgoing channel of the socket has already been
     * closed.
     *
     * @return {@code true} if writing to this socket is not possible anymore,
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.849 -0500", hash_original_method = "C1B1C01C4973B5698673C5D09FA67185", hash_generated_method = "9F44FA927E6B01FF6A7180A7E08E5E5B")
    
public boolean isOutputShutdown() {
        return isOutputShutdown;
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_REUSEADDR} option.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.851 -0500", hash_original_method = "6CEA4E5A53899EBE8D1FD08F2FE40675", hash_generated_method = "80DA433489B549F3E709FA7CC0A7329E")
    
public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_REUSEADDR} setting.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.853 -0500", hash_original_method = "8D0919FD23B9A2472FC046E6B1704481", hash_generated_method = "0A7B1D300C8A9F490E2233B15EBFDDBE")
    
public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        return (Boolean) impl.getOption(SocketOptions.SO_REUSEADDR);
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_OOBINLINE} option.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.856 -0500", hash_original_method = "8F9774180DF7F00524B2F69126E7F96E", hash_generated_method = "DCCB6A7C4144E7DA2F10891B3E3BDCC2")
    
public void setOOBInline(boolean oobinline) throws SocketException {
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_OOBINLINE} setting.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.859 -0500", hash_original_method = "A307BAC96AD0AD9185D724CFFBC60918", hash_generated_method = "2C6701919D054DEDDAF840C87A673ACC")
    
public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        return (Boolean) impl.getOption(SocketOptions.SO_OOBINLINE);
    }

    /**
     * Sets this socket's {@link SocketOptions#IP_TOS} value for every packet sent by this socket.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.862 -0500", hash_original_method = "50A48D0E3EC8A723BC37542164C52A31", hash_generated_method = "D137171BCE45E62FCA1247C4D17C5421")
    
public void setTrafficClass(int value) throws SocketException {
        checkOpenAndCreate(true);
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException();
        }
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    /**
     * Returns this socket's {@see SocketOptions#IP_TOS} setting.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.865 -0500", hash_original_method = "D7C7CF134B3FE725817BA2C07D220760", hash_generated_method = "0FEBE53442BBF4E490F037E29AE5534D")
    
public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    /**
     * Sends the given single byte data which is represented by the lowest octet
     * of {@code value} as "TCP urgent data".
     *
     * @param value
     *            the byte of urgent data to be sent.
     * @throws IOException
     *             if an error occurs while sending urgent data.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.867 -0500", hash_original_method = "CBFC447F34929AC991DFFA20015F8279", hash_generated_method = "E055261451665E01A23B7E558AE9D2A4")
    
public void sendUrgentData(int value) throws IOException {
        impl.sendUrgentData(value);
    }

    /**
     * Set the appropriate flags for a socket created by {@code
     * ServerSocket.accept()}.
     *
     * @see ServerSocket#implAccept
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.869 -0500", hash_original_method = "21E3234EAE6C3F4479E6E7944641B8BE", hash_generated_method = "21E3234EAE6C3F4479E6E7944641B8BE")
    
void accepted() {
        isCreated = isBound = isConnected = true;
        cacheLocalAddress();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.872 -0500", hash_original_method = "95A7BF302299AFCDED7970E2F7424717", hash_generated_method = "132FA4135EA46117D9C00DD069A47E16")
    
private void cacheLocalAddress() {
        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
    }

    /**
     * Returns this socket's {@code SocketChannel}, if one exists. A channel is
     * available only if this socket wraps a channel. (That is, you can go from a
     * channel to a socket and back again, but you can't go from an arbitrary socket to a channel.)
     * In practice, this means that the socket must have been created by
     * {@link java.nio.channels.ServerSocketChannel#accept} or
     * {@link java.nio.channels.SocketChannel#open}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.874 -0500", hash_original_method = "A7DB57A03C94477191BD1BBD8D530AC8", hash_generated_method = "A6C9D428F1F990500B452DA7CE711816")
    
public SocketChannel getChannel() {
        return null;
    }

    /**
     * @hide internal use only
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.877 -0500", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "22E2F6090640F07EEA0A28EA56ABF561")
    
public FileDescriptor getFileDescriptor$() {
        return impl.fd;
    }

    /**
     * Sets performance preferences for connectionTime, latency and bandwidth.
     *
     * <p>This method does currently nothing.
     *
     * @param connectionTime
     *            the value representing the importance of a short connecting
     *            time.
     * @param latency
     *            the value representing the importance of low latency.
     * @param bandwidth
     *            the value representing the importance of high bandwidth.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.879 -0500", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "F246F8DA4A0CBB54D188217F5E7B1DB3")
    
public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        // Our socket implementation only provide one protocol: TCP/IP, so
        // we do nothing for this method
    }
}

