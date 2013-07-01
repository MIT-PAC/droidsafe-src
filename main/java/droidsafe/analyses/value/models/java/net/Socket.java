package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.ValueAnalysisModelingSet;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Set;
import soot.jimple.spark.pag.AllocNode;

public class Socket extends ValueAnalysisModeledObject {

    private InetAddress localAddress; //  = Inet4Address.ANY;
    private InetSocketAddress destAddress; 

    public Socket(AllocNode allocNode) {
        super(allocNode);
    }

    
    public void _init_() {
        invalidate();
        /*
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
        */
    }

//    
//    public void _init_(Proxy proxy) {
//        invalidate();
//        /*
//        if (proxy == null || proxy.type() == Proxy.Type.HTTP) {
//            throw new IllegalArgumentException("Invalid proxy: " + proxy);
//        }
//        this.proxy = proxy;
//        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
//        */
//    }

    
    public void _init_(Set<String> dstName, Set<ValueAnalysisInt> dstPort) throws UnknownHostException, IOException {
        Set<ValueAnalysisInt> zeroSet = new ValueAnalysisModelingSet<ValueAnalysisInt>();
        zeroSet.add(new ValueAnalysisInt(0));
        this._init_(dstName, dstPort, null, zeroSet);
    }

    
    public void _init_(Set<String> dstName, Set<ValueAnalysisInt> dstPort, InetAddress localAddress, Set<ValueAnalysisInt> localPort) throws IOException {
        this.localAddress = localAddress;
        this.destAddress = new InetSocketAddress(null);
        destAddress._init_(dstName,dstPort);
        // invalidate();
        /*
        this();
        tryAllAddresses(dstName, dstPort, localAddress, localPort, true);
        */
    }

    
    public void _init_(Set<String> hostName, Set<ValueAnalysisInt> port, Set<ValueAnalysisBoolean> streaming) throws IOException {
        invalidate();
        /*
        this();
        tryAllAddresses(hostName, port, null, 0, streaming);
        */
    }

    
    public void _init_(InetAddress dstAddress, Set<ValueAnalysisInt> dstPort) throws IOException {
        invalidate();
        /*
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, null, 0, true);
        */
    }

    
    public void _init_(InetAddress dstAddress, Set<ValueAnalysisInt> dstPort, InetAddress localAddress, Set<ValueAnalysisInt> localPort) throws IOException {
        invalidate();
        /*
        this();
        checkDestination(dstAddress, dstPort);
        startupSocket(dstAddress, dstPort, localAddress, localPort, true);
        */
    }

    
    public void _init_(InetAddress addr, Set<ValueAnalysisInt> port, Set<ValueAnalysisBoolean> streaming) throws IOException {
        invalidate();
        /*
        this();
        checkDestination(addr, port);
        startupSocket(addr, port, null, 0, streaming);
        */
    }

    
    protected void _init_(SocketImpl impl) throws SocketException {
        invalidate();
        /*
        this.impl = impl;
        this.proxy = null;
        */
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
    
    private void tryAllAddresses(Set<String> dstName, Set<ValueAnalysisInt> dstPort, InetAddress localAddress, Set<ValueAnalysisInt> localPort, Set<ValueAnalysisBoolean> streaming) throws IOException {
        invalidate();
        /*
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
        */
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
    
    private void checkDestination(InetAddress destAddr, Set<ValueAnalysisInt> dstPort) {
        invalidate();
        /*
        if (dstPort < 0 || dstPort > 65535) {
            throw new IllegalArgumentException("Port out of range: " + dstPort);
        }
        */
    }

    /**
     * Closes the socket. It is not possible to reconnect or rebind to this
     * socket thereafter which means a new socket instance has to be created.
     *
     * @throws IOException
     *             if an error occurs while closing the socket.
     */
    
    public synchronized void close() throws IOException {
        invalidate();
        /*
        isClosed = true;
        // RI compatibility: the RI returns the any address (but the original local port) after close.
        localAddress = Inet4Address.ANY;
        impl.close();
        */
    }

    /**
     * Returns the IP address of the target host this socket is connected to, or null if this
     * socket is not yet connected.
     */
    
    public InetAddress getInetAddress() {
        invalidate();
        return null;
        /*
        if (!isConnected()) {
            return null;
        }
        return impl.getInetAddress();
        */
    }

    /**
     * Returns an input stream to read data from this socket.
     *
     * @return the byte-oriented input stream.
     * @throws IOException
     *             if an error occurs while creating the input stream or the
     *             socket is in an invalid state.
     */
    
    public InputStream getInputStream() throws IOException {
        invalidate();
        return null;
        /*
        checkOpenAndCreate(false);
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        return impl.getInputStream();
        */
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_KEEPALIVE} setting.
     */
    
    public boolean getKeepAlive() throws SocketException {
        invalidate();
        return false;
        /*
        checkOpenAndCreate(true);
        return (Boolean) impl.getOption(SocketOptions.SO_KEEPALIVE);
        */
    }

    /**
     * Returns the local IP address this socket is bound to, or {@code InetAddress.ANY} if
     * the socket is unbound.
     */
    
    public InetAddress getLocalAddress() {
        invalidate();
        return null;
        /*
        return localAddress;
        */
    }

    /**
     * Returns the local port this socket is bound to, or -1 if the socket is unbound.
     */
    
    public int getLocalPort() {
        invalidate();
        return 0;
        /*
        if (!isBound()) {
            return -1;
        }
        return impl.getLocalPort();
        */
    }

    /**
     * Returns an output stream to write data into this socket.
     *
     * @return the byte-oriented output stream.
     * @throws IOException
     *             if an error occurs while creating the output stream or the
     *             socket is in an invalid state.
     */
    
    public OutputStream getOutputStream() throws IOException {
        invalidate();
        return null;
        /*
        checkOpenAndCreate(false);
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        return impl.getOutputStream();
        */
    }

    /**
     * Returns the port number of the target host this socket is connected to, or 0 if this socket
     * is not yet connected.
     */
    
    public int getPort() {
        invalidate();
        return 0;
        /*
        if (!isConnected()) {
            return 0;
        }
        return impl.getPort();
        */
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_LINGER linger} timeout in seconds, or -1
     * for no linger (i.e. {@code close} will return immediately).
     */
    
    public int getSoLinger() throws SocketException {
        invalidate();
        return 0;
        /*
        checkOpenAndCreate(true);
        // The RI explicitly guarantees this idiocy in the SocketOptions.setOption documentation.
        Object value = impl.getOption(SocketOptions.SO_LINGER);
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            return -1;
        }
        */
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_RCVBUF receive buffer size}.
     */
    
    public synchronized int getReceiveBufferSize() throws SocketException {
        invalidate();
        return 0;
        /*
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.SO_RCVBUF);
        */
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_SNDBUF send buffer size}.
     */
    
    public synchronized int getSendBufferSize() throws SocketException {
        invalidate();
        return 0;
        /*
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.SO_SNDBUF);
        */
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_TIMEOUT receive timeout}.
     */
    
    public synchronized int getSoTimeout() throws SocketException {
        invalidate();
        return 0;
        /*
        checkOpenAndCreate(true);
        return (Integer) impl.getOption(SocketOptions.SO_TIMEOUT);
        */
    }

    /**
     * Returns this socket's {@code SocketOptions#TCP_NODELAY} setting.
     */
    
    public boolean getTcpNoDelay() throws SocketException {
        invalidate();
        return false;
        /*
        checkOpenAndCreate(true);
        return (Boolean) impl.getOption(SocketOptions.TCP_NODELAY);
        */
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_KEEPALIVE} option.
     */
    
    public void setKeepAlive(Set<ValueAnalysisBoolean> keepAlive) throws SocketException {
        invalidate();
        /*
        if (impl != null) {
            checkOpenAndCreate(true);
            impl.setOption(SocketOptions.SO_KEEPALIVE, Boolean.valueOf(keepAlive));
        }
        */
    }

    /**
     * Sets the internal factory for creating socket implementations. This may
     * only be executed once during the lifetime of the application.
     *
     * @param fac
     *            the socket implementation factory to be set.
     * @throws IOException
     *             if the factory has been already set.
     */
    
    public static synchronized void setSocketImplFactory(SocketImplFactory fac) throws IOException {
        /*
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
        */
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF send buffer size}.
     */
    
    public synchronized void setSendBufferSize(Set<ValueAnalysisInt> size) throws SocketException {
        invalidate();
        /*
        checkOpenAndCreate(true);
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
        */
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF receive buffer size}.
     */
    
    public synchronized void setReceiveBufferSize(Set<ValueAnalysisInt> size) throws SocketException {
        invalidate();
        /*
        checkOpenAndCreate(true);
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
        */
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_LINGER linger} timeout in seconds.
     * If {@code on} is false, {@code timeout} is irrelevant.
     */
    
    public void setSoLinger(Set<ValueAnalysisBoolean> on, Set<ValueAnalysisInt> timeout) throws SocketException {
        invalidate();
        /*
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
        */
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_TIMEOUT read timeout} in milliseconds.
     * Use 0 for no timeout.
     * To take effect, this option must be set before the blocking method was called.
     */
    
    public synchronized void setSoTimeout(Set<ValueAnalysisInt> timeout) throws SocketException {
        invalidate();
        /*
        checkOpenAndCreate(true);
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
        */
    }

    /**
     * Sets this socket's {@link SocketOptions#TCP_NODELAY} option.
     */
    
    public void setTcpNoDelay(Set<ValueAnalysisBoolean> on) throws SocketException {
        invalidate();
        /*
        checkOpenAndCreate(true);
        impl.setOption(SocketOptions.TCP_NODELAY, Boolean.valueOf(on));
        */
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
    
    private void startupSocket(InetAddress dstAddress, Set<ValueAnalysisInt> dstPort, InetAddress localAddress, Set<ValueAnalysisInt> localPort, Set<ValueAnalysisBoolean> streaming) throws IOException {
        invalidate();
        /*
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
        */
    }

    
    private boolean usingSocks() {
        invalidate();
        return false;
        /*
        return proxy != null && proxy.type() == Proxy.Type.SOCKS;
        */
    }

    /**
     * Returns a {@code String} containing a concise, human-readable description of the
     * socket.
     *
     * @return the textual representation of this socket.
     */
    @Override
    
    public String toString() {
        invalidate();
        return null;
        /*
        if (!isConnected()) {
            return "Socket[unconnected]";
        }
        return impl.toString();
        */
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
    
    public void shutdownInput() throws IOException {
        invalidate();
        /*
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        checkOpenAndCreate(false);
        impl.shutdownInput();
        isInputShutdown = true;
        */
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
    
    public void shutdownOutput() throws IOException {
        invalidate();
        /*
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        checkOpenAndCreate(false);
        impl.shutdownOutput();
        isOutputShutdown = true;
        */
    }

    /**
     * Checks whether the socket is closed, and throws an exception. Otherwise
     * creates the underlying SocketImpl.
     *
     * @throws SocketException
     *             if the socket is closed.
     */
    
    private void checkOpenAndCreate(Set<ValueAnalysisBoolean> create) throws SocketException {
        invalidate();
        /*
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!create) {
            if (!isConnected()) {
                throw new SocketException("Socket is not connected");
                // a connected socket must be created
            }

            //
            // return directly to fix a possible bug, if !create, should return
            // here
            //
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
        */
    }

    /**
     * Returns the local address and port of this socket as a SocketAddress or
     * null if the socket is unbound. This is useful on multihomed
     * hosts.
     */
    
    public SocketAddress getLocalSocketAddress() {
        invalidate();
        return null;
        /*
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getLocalAddress(), getLocalPort());
        */
    }

    /**
     * Returns the remote address and port of this socket as a {@code
     * SocketAddress} or null if the socket is not connected.
     *
     * @return the remote socket address and port.
     */
    
    public SocketAddress getRemoteSocketAddress() {
        invalidate();
        return null;
        /*
        if (!isConnected()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getPort());
        */
    }

    /**
     * Returns whether this socket is bound to a local address and port.
     *
     * @return {@code true} if the socket is bound to a local address, {@code
     *         false} otherwise.
     */
//    
//    public boolean isBound() {
//        invalidate();
//        return false;
//        /*
//        return isBound;
//        */
//    }
//
    /**
     * Returns whether this socket is connected to a remote host.
     *
     * @return {@code true} if the socket is connected, {@code false} otherwise.
     */
//    
//    public boolean isConnected() {
//        invalidate();
//        return false;
//        /*
//        return isConnected;
//        */
//    }

    /**
     * Returns whether this socket is closed.
     *
     * @return {@code true} if the socket is closed, {@code false} otherwise.
     */
//    
//    public boolean isClosed() {
//        invalidate();
//        return false;
//        /*
//        return isClosed;
//        */
//    }

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
//    
//    public void bind(SocketAddress localAddr) throws IOException {
//        invalidate();
//        /*
//        checkOpenAndCreate(true);
//        if (isBound()) {
//            throw new BindException("Socket is already bound");
//        }
//
//        int port = 0;
//        InetAddress addr = Inet4Address.ANY;
//        if (localAddr != null) {
//            if (!(localAddr instanceof InetSocketAddress)) {
//                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
//                        localAddr.getClass());
//            }
//            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
//            if ((addr = inetAddr.getAddress()) == null) {
//                throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
//            }
//            port = inetAddr.getPort();
//        }
//
//        synchronized (this) {
//            try {
//                impl.bind(addr, port);
//                isBound = true;
//                cacheLocalAddress();
//            } catch (IOException e) {
//                impl.close();
//                throw e;
//            }
//        }
//        */
//    }

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
//    
//    public void connect(SocketAddress remoteAddr) throws IOException {
//        invalidate();
//        /*
//        connect(remoteAddr, 0);
//        */
//    }

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
//    
//    public void connect(SocketAddress remoteAddr, Set<ValueAnalysisInt> timeout) throws IOException {
//        invalidate();
//        /*
//        checkOpenAndCreate(true);
//        if (timeout < 0) {
//            throw new IllegalArgumentException("timeout < 0");
//        }
//        if (isConnected()) {
//            throw new SocketException("Already connected");
//        }
//        if (remoteAddr == null) {
//            throw new IllegalArgumentException("remoteAddr == null");
//        }
//
//        if (!(remoteAddr instanceof InetSocketAddress)) {
//            throw new IllegalArgumentException("Remote address not an InetSocketAddress: " +
//                    remoteAddr.getClass());
//        }
//        InetSocketAddress inetAddr = (InetSocketAddress) remoteAddr;
//        InetAddress addr;
//        if ((addr = inetAddr.getAddress()) == null) {
//            throw new UnknownHostException("Host is unresolved: " + inetAddr.getHostName());
//        }
//        int port = inetAddr.getPort();
//
//        checkDestination(addr, port);
//        synchronized (connectLock) {
//            try {
//                if (!isBound()) {
//                    // socket already created at this point by earlier call or
//                    // checkOpenAndCreate this caused us to lose socket
//                    // options on create
//                    // impl.create(true);
//                    if (!usingSocks()) {
//                        impl.bind(Inet4Address.ANY, 0);
//                    }
//                    isBound = true;
//                }
//                impl.connect(remoteAddr, timeout);
//                isConnected = true;
//                cacheLocalAddress();
//            } catch (IOException e) {
//                impl.close();
//                throw e;
//            }
//        }
//        */
//    }

    /**
     * Returns whether the incoming channel of the socket has already been
     * closed.
     *
     * @return {@code true} if reading from this socket is not possible anymore,
     *         {@code false} otherwise.
     */
//    
//    public boolean isInputShutdown() {
//        invalidate();
//        return false;
//        /*
//        return isInputShutdown;
//        */
//    }

    /**
     * Returns whether the outgoing channel of the socket has already been
     * closed.
     *
     * @return {@code true} if writing to this socket is not possible anymore,
     *         {@code false} otherwise.
     */
//    
//    public boolean isOutputShutdown() {
//        invalidate();
//        return false;
//        /*
//        return isOutputShutdown;
//        */
//    }

    /**
     * Sets this socket's {@link SocketOptions#SO_REUSEADDR} option.
     */
//    
//    public void setReuseAddress(Set<ValueAnalysisBoolean> reuse) throws SocketException {
//        invalidate();
//        /*
//        checkOpenAndCreate(true);
//        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
//        */
//    }

    /**
     * Returns this socket's {@link SocketOptions#SO_REUSEADDR} setting.
     */
//    
//    public boolean getReuseAddress() throws SocketException {
//        invalidate();
//        return false;
//        /*
//        checkOpenAndCreate(true);
//        return (Boolean) impl.getOption(SocketOptions.SO_REUSEADDR);
//        */
//    }

    /**
     * Sets this socket's {@link SocketOptions#SO_OOBINLINE} option.
     */
//    
//    public void setOOBInline(Set<ValueAnalysisBoolean> oobinline) throws SocketException {
//        invalidate();
//        /*
//        checkOpenAndCreate(true);
//        impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(oobinline));
//        */
//    }

    /**
     * Returns this socket's {@link SocketOptions#SO_OOBINLINE} setting.
     */
//    
//    public boolean getOOBInline() throws SocketException {
//        invalidate();
//        return false;
//        /*
//        checkOpenAndCreate(true);
//        return (Boolean) impl.getOption(SocketOptions.SO_OOBINLINE);
//        */
//    }

    /**
     * Sets this socket's {@link SocketOptions#IP_TOS} value for every packet sent by this socket.
     */
//    
//    public void setTrafficClass(Set<ValueAnalysisInt> value) throws SocketException {
//        invalidate();
//        /*
//        checkOpenAndCreate(true);
//        if (value < 0 || value > 255) {
//            throw new IllegalArgumentException();
//        }
//        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
//        */
//    }

    /**
     * Returns this socket's {@see SocketOptions#IP_TOS} setting.
     */
//    
//    public int getTrafficClass() throws SocketException {
//        invalidate();
//        return 0;
//        /*
//        checkOpenAndCreate(true);
//        return (Integer) impl.getOption(SocketOptions.IP_TOS);
//        */
//    }

    /**
     * Sends the given single byte data which is represented by the lowest octet
     * of {@code value} as "TCP urgent data".
     *
     * @param value
     *            the byte of urgent data to be sent.
     * @throws IOException
     *             if an error occurs while sending urgent data.
     */
//    
//    public void sendUrgentData(Set<ValueAnalysisInt> value) throws IOException {
//        invalidate();
//        /*
//        impl.sendUrgentData(value);
//        */
//    }

    /**
     * Set the appropriate flags for a socket created by {@code
     * ServerSocket.accept()}.
     *
     * @see ServerSocket#implAccept
     */
//    
//    void accepted() {
//        invalidate();
//        /*
//        isCreated = isBound = isConnected = true;
//        cacheLocalAddress();
//        */
//    }

//    
//    private void cacheLocalAddress() {
//        invalidate();
//        /*
//        this.localAddress = IoBridge.getSocketLocalAddress(impl.fd);
//        */
//    }

    /**
     * Returns this socket's {@code SocketChannel}, if one exists. A channel is
     * available only if this socket wraps a channel. (That is, you can go from a
     * channel to a socket and back again, but you can't go from an arbitrary socket to a channel.)
     * In practice, this means that the socket must have been created by
     * {@link java.nio.channels.ServerSocketChannel#accept} or
     * {@link java.nio.channels.SocketChannel#open}.
     */
//    
//    public SocketChannel getChannel() {
//        invalidate();
//        return null;
//        /*
//        return null;
//        */
//    }

    /**
     * @hide internal use only
     */
//    
//    public FileDescriptor getFileDescriptor$() {
//        invalidate();
//        return null;
//        /*
//        return impl.fd;
//        */
//    }

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
//    
//    public void setPerformancePreferences(Set<ValueAnalysisInt> connectionTime, Set<ValueAnalysisInt> latency, Set<ValueAnalysisInt> bandwidth) {
//        invalidate();
//    }
}
