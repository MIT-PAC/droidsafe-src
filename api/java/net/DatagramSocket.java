package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.SOL_SOCKET;
import static libcore.io.OsConstants.SO_BINDTODEVICE;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import libcore.io.ErrnoException;
import libcore.io.Libcore;

public class DatagramSocket {

    /**
     * Sets the socket implementation factory. This may only be invoked once
     * over the lifetime of the application. This factory is used to create
     * a new datagram socket implementation.
     *
     * @param fac
     *            the socket factory to use.
     * @throws IOException
     *                if the factory has already been set.
     * @see DatagramSocketImplFactory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.660 -0500", hash_original_method = "337B8C84F2B3E10DBD586CDE880C9EA3", hash_generated_method = "683BB4EB4831349482C70992DF5D1120")
    
public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac)
            throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = fac;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.590 -0500", hash_original_field = "8C151F5CDE68CF92C1CEDCEB9BAA4B33", hash_generated_field = "E43EB19BC3390384071AA64E51712EB7")

    static DatagramSocketImplFactory factory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.584 -0500", hash_original_field = "0E47AFFF5CC1F2155F99BECA6A70C2D2", hash_generated_field = "0E47AFFF5CC1F2155F99BECA6A70C2D2")

    DatagramSocketImpl impl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.586 -0500", hash_original_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4", hash_generated_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4")

    InetAddress address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.588 -0500", hash_original_field = "BAF684EECB20D799A434AFCF1B13F01D", hash_generated_field = "BAF684EECB20D799A434AFCF1B13F01D")

    int port = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.592 -0500", hash_original_field = "F9AB7682F64A4F93F6F4A7A435A5AA53", hash_generated_field = "F9AB7682F64A4F93F6F4A7A435A5AA53")

    boolean isBound = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.595 -0500", hash_original_field = "B48043272C25E776A9FBEC8A0B198F87", hash_generated_field = "058DE1E699A3B3D187FC9E15DB7EC3B5")

    private boolean isConnected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.598 -0500", hash_original_field = "C893CD23B6DA0F4ED6ABF661D11E983F", hash_generated_field = "BBB4D111812AF32431191097BEE30ACB")

    private SocketException pendingConnectException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.600 -0500", hash_original_field = "79ECB5C84997278EAA42676EDFBD1FF8", hash_generated_field = "2CBEAC942D14DA48C324142BCB214C18")

    private boolean isClosed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.603 -0500", hash_original_field = "DA2A3FDBCC0B9B91674644DF55F373AF", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();

    /**
     * Constructs a UDP datagram socket which is bound to any available port on
     * the localhost.
     *
     * @throws SocketException
     *             if an error occurs while creating or binding the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.606 -0500", hash_original_method = "600D2DC769AA1337C3E52515B77C9BA6", hash_generated_method = "E20B11B2B01A755621C765189DBA41B7")
    
public DatagramSocket() throws SocketException {
        this(0);
    }

    /**
     * Constructs a UDP datagram socket which is bound to the specific port
     * {@code aPort} on the localhost. Valid values for {@code aPort} are
     * between 0 and 65535 inclusive.
     *
     * @param aPort
     *            the port to bind on the localhost.
     * @throws SocketException
     *             if an error occurs while creating or binding the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.608 -0500", hash_original_method = "5C9F869A9F8E783507AEDF83BF8CB0B7", hash_generated_method = "23C824DFE2FE70E29B80EE8001A33850")
    
public DatagramSocket(int aPort) throws SocketException {
        checkPort(aPort);
        createSocket(aPort, Inet4Address.ANY);
    }

    /**
     * Constructs a UDP datagram socket which is bound to the specific local
     * address {@code addr} on port {@code aPort}. Valid values for {@code
     * aPort} are between 0 and 65535 inclusive.
     *
     * @param aPort
     *            the port to bind on the localhost.
     * @param addr
     *            the address to bind on the localhost.
     * @throws SocketException
     *             if an error occurs while creating or binding the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.611 -0500", hash_original_method = "CB0AFEB195CAFC978B9076AC8691C2BF", hash_generated_method = "4F66F1E6A00EEDD5800A398FCFF396DF")
    
public DatagramSocket(int aPort, InetAddress addr) throws SocketException {
        checkPort(aPort);
        createSocket(aPort, (addr == null) ? Inet4Address.ANY : addr);
    }

    /**
     * Constructs a new {@code DatagramSocket} using the specific datagram
     * socket implementation {@code socketImpl}. The created {@code
     * DatagramSocket} will not be bound.
     *
     * @param socketImpl
     *            the DatagramSocketImpl to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.663 -0500", hash_original_method = "8791E60C190AA1CE5F0CD19BC0C9D10B", hash_generated_method = "91EEF7B95468F3757EC43B665D181C21")
    
protected DatagramSocket(DatagramSocketImpl socketImpl) {
        if (socketImpl == null) {
            throw new NullPointerException();
        }
        impl = socketImpl;
    }

    /**
     * Constructs a new {@code DatagramSocket} bound to the host/port specified
     * by the {@code SocketAddress} {@code localAddr} or an unbound {@code
     * DatagramSocket} if the {@code SocketAddress} is {@code null}.
     *
     * @param localAddr
     *            the local machine address and port to bind to.
     * @throws IllegalArgumentException
     *             if the SocketAddress is not supported
     * @throws SocketException
     *             if a problem occurs creating or binding the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.666 -0500", hash_original_method = "F9D705BC16951CA970DD006A85C9F283", hash_generated_method = "6FAE8D45786083F9DDDF00C32DCF8DA9")
    
public DatagramSocket(SocketAddress localAddr) throws SocketException {
        if (localAddr != null) {
            if (!(localAddr instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            }
            checkPort(((InetSocketAddress) localAddr).getPort());
        }
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
        if (localAddr != null) {
            try {
                bind(localAddr);
            } catch (SocketException e) {
                close();
                throw e;
            }
        }
        // SocketOptions.SO_BROADCAST is set by default for DatagramSocket
        setBroadcast(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.614 -0500", hash_original_method = "70ACB9C2984CE075C85AFFAB4CC3F2C3", hash_generated_method = "4A0CD7F4145B8CB13F85031F53729D5A")
    
private void checkPort(int aPort) {
        if (aPort < 0 || aPort > 65535) {
            throw new IllegalArgumentException("Port out of range: " + aPort);
        }
    }

    /**
     * Closes this UDP datagram socket and all possibly associated channels.
     */
    // In the documentation jdk1.1.7a/guide/net/miscNet.html, this method is
    // noted as not being synchronized.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.616 -0500", hash_original_method = "613628CBB35065AE6B36DA8B5C0D3152", hash_generated_method = "E07D13A40AAA8AE3C1C1A83EBE240501")
    
public void close() {
        isClosed = true;
        impl.close();
    }

    /**
     * Disconnects this UDP datagram socket from the remote host. This method
     * called on an unconnected socket does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.619 -0500", hash_original_method = "53DC6FE247829A3F8E1E61F886EC8A69", hash_generated_method = "65643C99224ACA0B92F439A799746A56")
    
public void disconnect() {
        if (isClosed() || !isConnected()) {
            return;
        }
        impl.disconnect();
        address = null;
        port = -1;
        isConnected = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.621 -0500", hash_original_method = "CDBEDFAF0027896E1E3D56B522D080D1", hash_generated_method = "B995B4032CBBFCEDE50138473FC0D1DD")
    
synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        impl = factory != null ? factory.createDatagramSocketImpl()
                : new PlainDatagramSocketImpl();
        impl.create();
        try {
            impl.bind(aPort, addr);
            isBound = true;
        } catch (SocketException e) {
            close();
            throw e;
        }
    }

    /**
     * Gets the {@code InetAddress} instance representing the remote address to
     * which this UDP datagram socket is connected.
     *
     * @return the remote address this socket is connected to or {@code null} if
     *         this socket is not connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.623 -0500", hash_original_method = "9059089CB1C35AC3C53D636B58746A1E", hash_generated_method = "496B242BE9E9241FCB1317169287B698")
    
public InetAddress getInetAddress() {
        return address;
    }

    /**
     * Gets the {@code InetAddress} instance representing the bound local
     * address of this UDP datagram socket.
     *
     * @return the local address to which this socket is bound to or {@code
     *         null} if this socket is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.626 -0500", hash_original_method = "120EDBD12BFFA2CD78689E1CCCEFC0A6", hash_generated_method = "A531F469508AA52D412D092323D2C43A")
    
public InetAddress getLocalAddress() {
        if (isClosed()) {
            return null;
        }
        if (!isBound()) {
            return Inet4Address.ANY;
        }
        return impl.getLocalAddress();
    }

    /**
     * Gets the local port which this socket is bound to.
     *
     * @return the local port of this socket or {@code -1} if this socket is
     *         closed and {@code 0} if it is unbound.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.628 -0500", hash_original_method = "C20A7438B6018D8C8B6C316459831E1B", hash_generated_method = "E91F065498979E799788353E3516CE74")
    
public int getLocalPort() {
        if (isClosed()) {
            return -1;
        }
        if (!isBound()) {
            return 0;
        }
        return impl.getLocalPort();
    }

    /**
     * Gets the remote port which this socket is connected to.
     *
     * @return the remote port of this socket. The return value {@code -1}
     *         indicates that this socket is not connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.631 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8D4984D37D0017078DF4701090E35F25")
    
public int getPort() {
        return port;
    }

    /**
     * Indicates whether this socket is multicast or not.
     *
     * @return the return value is always {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.633 -0500", hash_original_method = "4991C56903C24C085B034589D2617CA7", hash_generated_method = "4991C56903C24C085B034589D2617CA7")
    
boolean isMulticastSocket() {
        return false;
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_RCVBUF receive buffer size}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.635 -0500", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "32F366297DF71FA9F0B2AF234AADD73F")
    
public synchronized int getReceiveBufferSize() throws SocketException {
        checkOpen();
        return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_SNDBUF send buffer size}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.638 -0500", hash_original_method = "D220B9D2C157A98A9F2FC338F369BDAA", hash_generated_method = "86CA95F852B8B49D0A81653B692ADA34")
    
public synchronized int getSendBufferSize() throws SocketException {
        checkOpen();
        return ((Integer) impl.getOption(SocketOptions.SO_SNDBUF)).intValue();
    }

    /**
     * Gets the socket {@link SocketOptions#SO_TIMEOUT receive timeout}.
     *
     * @throws SocketException
     *                if an error occurs while getting the option value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.642 -0500", hash_original_method = "E87267C7B03A68795BE159270DE33B7D", hash_generated_method = "9F7A1F60E76959A75DD2FB96D8E81523")
    
public synchronized int getSoTimeout() throws SocketException {
        checkOpen();
        return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    /**
     * Receives a packet from this socket and stores it in the argument {@code
     * pack}. All fields of {@code pack} must be set according to the data
     * received. If the received data is longer than the packet buffer size it
     * is truncated. This method blocks until a packet is received or a timeout
     * has expired.
     *
     * @param pack
     *            the {@code DatagramPacket} to store the received data.
     * @throws IOException
     *                if an error occurs while receiving the packet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.645 -0500", hash_original_method = "C2244B28A3A8977EAD72461E3F35998B", hash_generated_method = "FA40C6DCB99A1FF924F067925A9AE9BC")
    
public synchronized void receive(DatagramPacket pack) throws IOException {
        checkOpen();
        ensureBound();
        if (pack == null) {
            throw new NullPointerException();
        }
        if (pendingConnectException != null) {
            throw new SocketException("Pending connect failure", pendingConnectException);
        }

        pack.setLength(pack.getCapacity());
        impl.receive(pack);
        // pack's length field is now updated by native code call;
        // pack's capacity field is unchanged
    }

    /**
     * Sends a packet over this socket.
     *
     * @param pack
     *            the {@code DatagramPacket} which has to be sent.
     * @throws IOException
     *                if an error occurs while sending the packet.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.648 -0500", hash_original_method = "F0676E3BCA654DF56D2BFA1EDDBDFD76", hash_generated_method = "2353F46655A0E31C5FAD87BE14A59420")
    
public void send(DatagramPacket pack) throws IOException {
        checkOpen();
        ensureBound();

        InetAddress packAddr = pack.getAddress();
        if (address != null) { // The socket is connected
            if (packAddr != null) {
                if (!address.equals(packAddr) || port != pack.getPort()) {
                    throw new IllegalArgumentException("Packet address mismatch with connected address");
                }
            } else {
                pack.setAddress(address);
                pack.setPort(port);
            }
        } else {
            // not connected so the target address is not allowed to be null
            if (packAddr == null) {
                throw new NullPointerException("Destination address is null");
            }
        }
        impl.send(pack);
    }

    /**
     * Sets the network interface used by this socket.  Any packets sent
     * via this socket are transmitted via the specified interface.  Any
     * packets received by this socket will come from the specified
     * interface.  Broadcast datagrams received on this interface will
     * be processed by this socket. This corresponds to Linux's SO_BINDTODEVICE.
     *
     * @hide used by GoogleTV for DHCP
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.650 -0500", hash_original_method = "3874DFBADA775207309D591B6CC4D492", hash_generated_method = "8FB0E84BB5395FA662620CCDEE80F727")
    
public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        if (netInterface == null) {
            throw new NullPointerException("networkInterface == null");
        }
        try {
            Libcore.os.setsockoptIfreq(impl.fd, SOL_SOCKET, SO_BINDTODEVICE, netInterface.getName());
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF send buffer size}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.653 -0500", hash_original_method = "6C822EF02E72BD5A5151B1066B41A106", hash_generated_method = "968F8F3749FDB53669BF0331D9F4DA54")
    
public synchronized void setSendBufferSize(int size) throws SocketException {
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        checkOpen();
        impl.setOption(SocketOptions.SO_SNDBUF, Integer.valueOf(size));
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF receive buffer size}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.655 -0500", hash_original_method = "568C48DC36A6A663E7303E35F30B9F65", hash_generated_method = "07C9AAD9A4FF8CDB059155C8F2EBFE5C")
    
public synchronized void setReceiveBufferSize(int size) throws SocketException {
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        checkOpen();
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    /**
     * Sets the {@link SocketOptions#SO_TIMEOUT read timeout} in milliseconds for this socket.
     * This receive timeout defines the period the socket will block waiting to
     * receive data before throwing an {@code InterruptedIOException}. The value
     * {@code 0} (default) is used to set an infinite timeout. To have effect
     * this option must be set before the blocking method was called.
     *
     * @param timeout the timeout in milliseconds or 0 for no timeout.
     * @throws SocketException
     *                if an error occurs while setting the option.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.658 -0500", hash_original_method = "FEB39AD74968ADEBB5E7B7804953C3DE", hash_generated_method = "50EB82C7A51A39A5708F4D2AE00058D5")
    
public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        checkOpen();
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.669 -0500", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "8DC54C39C6445BAF3181407C830C5887")
    
void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.672 -0500", hash_original_method = "1B212BFD5D3AE863EDBC7C1325928232", hash_generated_method = "BEA3F843DAE93FC57E382B9F4CCF2185")
    
private void ensureBound() throws SocketException {
        if (!isBound()) {
            impl.bind(0, Inet4Address.ANY);
            isBound = true;
        }
    }

    /**
     * Binds this socket to the local address and port specified by {@code
     * localAddr}. If this value is {@code null} any free port on a valid local
     * address is used.
     *
     * @param localAddr
     *            the local machine address and port to bind on.
     * @throws IllegalArgumentException
     *             if the SocketAddress is not supported
     * @throws SocketException
     *             if the socket is already bound or a problem occurs during
     *             binding.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.674 -0500", hash_original_method = "3D56D66452A7B2D7ED073824CEA46ED8", hash_generated_method = "D83CB0F9F290C713E52F36169140C93D")
    
public void bind(SocketAddress localAddr) throws SocketException {
        checkOpen();
        int localPort = 0;
        InetAddress addr = Inet4Address.ANY;
        if (localAddr != null) {
            if (!(localAddr instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            }
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            addr = inetAddr.getAddress();
            if (addr == null) {
                throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
            }
            localPort = inetAddr.getPort();
            checkPort(localPort);
        }
        impl.bind(localPort, addr);
        isBound = true;
    }

    /**
     * Connects this datagram socket to the address and port specified by {@code peer}.
     * Future calls to {@link #send} will use this as the default target, and {@link #receive}
     * will only accept packets from this source.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.677 -0500", hash_original_method = "3DB10BF2A6A48B73F2119F41843D9D33", hash_generated_method = "0E3AA7BCCF1EAF06C4D710E6CF69FD24")
    
public void connect(SocketAddress peer) throws SocketException {
        if (peer == null) {
            throw new IllegalArgumentException("peer == null");
        }

        if (!(peer instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("peer not an InetSocketAddress: " + peer.getClass());
        }

        InetSocketAddress isa = (InetSocketAddress) peer;
        if (isa.getAddress() == null) {
            throw new SocketException("Host is unresolved: " + isa.getHostName());
        }

        synchronized (lock) {
            checkOpen();
            ensureBound();

            this.address = isa.getAddress();
            this.port = isa.getPort();
            this.isConnected = true;

            impl.connect(address, port);
        }
    }

    /**
     * Connects this datagram socket to the specific {@code address} and {@code port}.
     * Future calls to {@link #send} will use this as the default target, and {@link #receive}
     * will only accept packets from this source.
     *
     * <p>Beware: because it can't throw, this method silently ignores failures.
     * Use {@link #connect(SocketAddress)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.679 -0500", hash_original_method = "9E27C6FD502F0359DB781EB2FF7E2BA4", hash_generated_method = "A935FD122A37CC05E5B1BA77EC4C9D40")
    
public void connect(InetAddress address, int port) {
        if (address == null) {
            throw new IllegalArgumentException("address == null");
        }
        try {
            connect(new InetSocketAddress(address, port));
        } catch (SocketException connectException) {
            // TODO: or just use SneakyThrow? There's a clear API bug here.
            pendingConnectException = connectException;
        }
    }

    /**
     * Returns true if this socket is bound to a local address. See {@link #bind}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.681 -0500", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "A878CB652BF3277F9F7822AB8074E046")
    
public boolean isBound() {
        return isBound;
    }

    /**
     * Returns true if this datagram socket is connected to a remote address. See {@link #connect}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.684 -0500", hash_original_method = "B1255CDE181FFAAB8CB434FB98B99FFF", hash_generated_method = "04CA4546F9019A1940AA3235F1228ADE")
    
public boolean isConnected() {
        return isConnected;
    }

    /**
     * Returns the {@code SocketAddress} this socket is connected to, or null for an unconnected
     * socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.687 -0500", hash_original_method = "7C698472BF26D61A7917F4B5238C5FF7", hash_generated_method = "C1CDFAAC803588FC140B6196FA164411")
    
public SocketAddress getRemoteSocketAddress() {
        if (!isConnected()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getPort());
    }

    /**
     * Returns the {@code SocketAddress} this socket is bound to, or null for an unbound socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.689 -0500", hash_original_method = "AE126A441E32CF7358FEDD7A95BAD391", hash_generated_method = "67B8A39634FC3A72D60F6B588EC9B04B")
    
public SocketAddress getLocalSocketAddress() {
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    /**
     * Sets the socket option {@code SocketOptions.SO_REUSEADDR}. This option
     * has to be enabled if more than one UDP socket wants to be bound to the
     * same address. That could be needed for receiving multicast packets.
     * <p>
     * There is an undefined behavior if this option is set after the socket is
     * already bound.
     *
     * @param reuse
     *            the socket option value to enable or disable this option.
     * @throws SocketException
     *             if the socket is closed or the option could not be set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.692 -0500", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "F94F3DC09B3E131C2F7D5BA39FFC9336")
    
public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    /**
     * Gets the state of the socket option {@code SocketOptions.SO_REUSEADDR}.
     *
     * @return {@code true} if the option is enabled, {@code false} otherwise.
     * @throws SocketException
     *             if the socket is closed or the option is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.695 -0500", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "4750294BF903E7A0F86FCB8F7F2519DE")
    
public boolean getReuseAddress() throws SocketException {
        checkOpen();
        return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    /**
     * Sets the socket option {@code SocketOptions.SO_BROADCAST}. This option
     * must be enabled to send broadcast messages.
     *
     * @param broadcast
     *            the socket option value to enable or disable this option.
     * @throws SocketException
     *             if the socket is closed or the option could not be set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.697 -0500", hash_original_method = "16BACAE92585B22CC8D47D482CFB74B4", hash_generated_method = "80E17E7313B16739DDEA9982B0678291")
    
public void setBroadcast(boolean broadcast) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_BROADCAST, Boolean.valueOf(broadcast));
    }

    /**
     * Gets the state of the socket option {@code SocketOptions.SO_BROADCAST}.
     *
     * @return {@code true} if the option is enabled, {@code false} otherwise.
     * @throws SocketException
     *             if the socket is closed or the option is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.700 -0500", hash_original_method = "2CF01D838FE277D7A2E75EEBFE7DA27F", hash_generated_method = "5364AA70FB3448070A099B225DE96FAD")
    
public boolean getBroadcast() throws SocketException {
        checkOpen();
        return ((Boolean) impl.getOption(SocketOptions.SO_BROADCAST)).booleanValue();
    }

    /**
     * Sets the {@see SocketOptions#IP_TOS} value for every packet sent by this socket.
     *
     * @throws SocketException
     *             if the socket is closed or the option could not be set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.702 -0500", hash_original_method = "2EC80086B0B75FB75EFBAAF12E210751", hash_generated_method = "9A2E1BE643CE564177B5B1FFEBB6DDD9")
    
public void setTrafficClass(int value) throws SocketException {
        checkOpen();
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException();
        }
        impl.setOption(SocketOptions.IP_TOS, Integer.valueOf(value));
    }

    /**
     * Returns this socket's {@see SocketOptions#IP_TOS} setting.
     *
     * @throws SocketException
     *             if the socket is closed or the option is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.704 -0500", hash_original_method = "2A65749565A2F95D7C49F3E7C9DCBDEC", hash_generated_method = "4001FCD91A647FD0257B69CE326B93A5")
    
public int getTrafficClass() throws SocketException {
        checkOpen();
        return (Integer) impl.getOption(SocketOptions.IP_TOS);
    }

    /**
     * Gets the state of this socket.
     *
     * @return {@code true} if the socket is closed, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.707 -0500", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "10C0B8E2B9DF49DDBC078E9919A022F7")
    
public boolean isClosed() {
        return isClosed;
    }

    /**
     * Returns this socket's {@code DatagramChannel}, if one exists. A channel is
     * available only if this socket wraps a channel. (That is, you can go from a
     * channel to a socket and back again, but you can't go from an arbitrary socket to a channel.)
     * In practice, this means that the socket must have been created by
     * {@link java.nio.channels.DatagramChannel#open}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.709 -0500", hash_original_method = "4DA7A00C8A23C7197F09A02190FE9E45", hash_generated_method = "7BD33AE19ADB871FFFC7F122EDF8FC59")
    
public DatagramChannel getChannel() {
        return null;
    }

    /**
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:07.712 -0500", hash_original_method = "90C19CEBA6BBC20B430C1F399D6443A6", hash_generated_method = "703D6C341A8C148AF2135A8461C15924")
    
public final FileDescriptor getFileDescriptor$() {
        return impl.fd;
    }
}

