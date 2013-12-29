package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;






public class MulticastSocket extends DatagramSocket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.682 -0500", hash_original_field = "8405AE2A3D1666EB56E8105B1F31EECE", hash_generated_field = "FA21EF96F67F8787C26D586D454C48A6")

    private InetAddress setAddress;

    /**
     * Constructs a multicast socket, bound to any available port on the
     * local host.
     *
     * @throws IOException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.683 -0500", hash_original_method = "E00E381299DD101E8388BF5692519367", hash_generated_method = "9B8253BC9D1C81B18F2BAC30CDA612F3")
    public MulticastSocket() throws IOException {
        setReuseAddress(true);
    }

    /**
     * Constructs a multicast socket, bound to the specified {@code port} on the
     * local host.
     *
     * @throws IOException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.684 -0500", hash_original_method = "AEBFC898C5450F1ABC3134E881783937", hash_generated_method = "11CFA2DF20D7A17268C97729453FFBB5")
    public MulticastSocket(int port) throws IOException {
        super(port);
        setReuseAddress(true);
    }

    /**
     * Constructs a {@code MulticastSocket} bound to the address and port specified by
     * {@code localAddress}, or an unbound {@code MulticastSocket} if {@code localAddress == null}.
     *
     * @throws IllegalArgumentException if {@code localAddress} is not supported (because it's not
     * an {@code InetSocketAddress}, say).
     * @throws IOException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.685 -0500", hash_original_method = "04DD868DCBB43DC9F285487EAD012BAF", hash_generated_method = "2D7146D92DFA7317318A1D2FC98B3D06")
    public MulticastSocket(SocketAddress localAddress) throws IOException {
        super(localAddress);
        setReuseAddress(true);
    }

    /**
     * Returns an address of the outgoing network interface used by this socket. To avoid
     * inherent unpredictability, new code should use {@link #getNetworkInterface} instead.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.686 -0500", hash_original_method = "467AD7DD9552F52C52E1B541B5F40FE0", hash_generated_method = "EA4814C5533FFA8A0F06701FD31762DC")
    public InetAddress getInterface() throws SocketException {
        checkOpen();
        if (setAddress != null) {
            return setAddress;
        }
        InetAddress ipvXaddress = (InetAddress) impl.getOption(SocketOptions.IP_MULTICAST_IF);
        if (ipvXaddress.isAnyLocalAddress()) {
            // the address was not set at the IPv4 level so check the IPv6
            // level
            NetworkInterface theInterface = getNetworkInterface();
            if (theInterface != null) {
                Enumeration<InetAddress> addresses = theInterface.getInetAddresses();
                if (addresses != null) {
                    while (addresses.hasMoreElements()) {
                        InetAddress nextAddress = addresses.nextElement();
                        if (nextAddress instanceof Inet6Address) {
                            return nextAddress;
                        }
                    }
                }
            }
        }
        return ipvXaddress;
    }

    /**
     * Returns the outgoing network interface used by this socket.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.687 -0500", hash_original_method = "9619F0CC924DAE776456EC0CB550E95C", hash_generated_method = "F3F65DF4747873DB2B1D2EAF827AF55D")
    public NetworkInterface getNetworkInterface() throws SocketException {
        checkOpen();
        int index = (Integer) impl.getOption(SocketOptions.IP_MULTICAST_IF2);
        if (index != 0) {
            return NetworkInterface.getByIndex(index);
        }
        return NetworkInterface.forUnboundMulticastSocket();
    }

    /**
     * Returns the time-to-live (TTL) for multicast packets sent on this socket.
     *
     * @throws IOException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.688 -0500", hash_original_method = "115D2F8953DD08E8766DFC64CC7C212D", hash_generated_method = "636822C75062B12E8A2C2D0B150F08B0")
    public int getTimeToLive() throws IOException {
        checkOpen();
        return impl.getTimeToLive();
    }

    /**
     * Returns the time-to-live (TTL) for multicast packets sent on this socket.
     *
     * @throws IOException if an error occurs.
     * @deprecated Replaced by {@link #getTimeToLive}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.688 -0500", hash_original_method = "2ED04886DDF130567B09FF7DB10BF58C", hash_generated_method = "6487B674C1A308ACB7821CC5ABF9E624")
    @Deprecated
public byte getTTL() throws IOException {
        checkOpen();
        return impl.getTTL();
    }

    /**
     * Adds this socket to the specified multicast group. A socket must join a
     * group before data may be received. A socket may be a member of multiple
     * groups but may join any group only once.
     *
     * @param groupAddr
     *            the multicast group to be joined.
     * @throws IOException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.689 -0500", hash_original_method = "2A9249956792D7D287EC6DE49DBB9AA1", hash_generated_method = "AA4E0CC7FC8A3431B9D334D1E230E385")
    public void joinGroup(InetAddress groupAddr) throws IOException {
        checkJoinOrLeave(groupAddr);
        impl.join(groupAddr);
    }

    /**
     * Adds this socket to the specified multicast group. A socket must join a
     * group before data may be received. A socket may be a member of multiple
     * groups but may join any group only once.
     *
     * @param groupAddress
     *            the multicast group to be joined.
     * @param netInterface
     *            the network interface on which the datagram packets will be
     *            received.
     * @throws IOException
     *                if the specified address is not a multicast address.
     * @throws IllegalArgumentException
     *                if no multicast group is specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.690 -0500", hash_original_method = "E3A8AF53901269F90797322614E1EFAB", hash_generated_method = "D3098C42F37B6011CB4E0F35D59D626A")
    public void joinGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        checkJoinOrLeave(groupAddress, netInterface);
        impl.joinGroup(groupAddress, netInterface);
    }

    /**
     * Removes this socket from the specified multicast group.
     *
     * @param groupAddr
     *            the multicast group to be left.
     * @throws NullPointerException
     *                if {@code groupAddr} is {@code null}.
     * @throws IOException
     *                if the specified group address is not a multicast address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.691 -0500", hash_original_method = "84DF9FB54D017E3534FF7B79FFC861AD", hash_generated_method = "129C6A5A4A216AF1392AE40988B38CC5")
    public void leaveGroup(InetAddress groupAddr) throws IOException {
        checkJoinOrLeave(groupAddr);
        impl.leave(groupAddr);
    }

    /**
     * Removes this socket from the specified multicast group.
     *
     * @param groupAddress
     *            the multicast group to be left.
     * @param netInterface
     *            the network interface on which the addresses should be
     *            dropped.
     * @throws IOException
     *                if the specified group address is not a multicast address.
     * @throws IllegalArgumentException
     *                if {@code groupAddress} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.692 -0500", hash_original_method = "5C672C91FEA72835E9232D6CA28DF6E9", hash_generated_method = "4F90151B53B06D4F1352D9ED9196E45E")
    public void leaveGroup(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        checkJoinOrLeave(groupAddress, netInterface);
        impl.leaveGroup(groupAddress, netInterface);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.693 -0500", hash_original_method = "5D3737731721260F57AF95D7810519A1", hash_generated_method = "BE6D5906A27A20F91153C7ACFC899E5F")
    private void checkJoinOrLeave(SocketAddress groupAddress, NetworkInterface netInterface) throws IOException {
        checkOpen();
        if (groupAddress == null) {
            throw new IllegalArgumentException("groupAddress == null");
        }

        if (netInterface != null && !netInterface.getInetAddresses().hasMoreElements()) {
            throw new SocketException("No address associated with interface: " + netInterface);
        }

        if (!(groupAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Group address not an InetSocketAddress: " +
                    groupAddress.getClass());
        }

        InetAddress groupAddr = ((InetSocketAddress) groupAddress).getAddress();
        if (groupAddr == null) {
            throw new SocketException("Group address has no address: " + groupAddress);
        }

        if (!groupAddr.isMulticastAddress()) {
            throw new IOException("Not a multicast group: " + groupAddr);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.694 -0500", hash_original_method = "6596B4EA78B0ED28321084C8CA9DCC77", hash_generated_method = "7C391F04DE09282EA07355A617CC217F")
    private void checkJoinOrLeave(InetAddress groupAddr) throws IOException {
        checkOpen();
        if (!groupAddr.isMulticastAddress()) {
            throw new IOException("Not a multicast group: " + groupAddr);
        }
    }

    /**
     * Sends the given {@code packet} on this socket, using the given {@code ttl}. This method is
     * deprecated because it modifies the TTL socket option for this socket twice on each call.
     *
     * @throws IOException if an error occurs.
     * @deprecated use {@link #setTimeToLive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.695 -0500", hash_original_method = "B2C00FA361C879157E99EDF94577EB31", hash_generated_method = "D399416A40635AF894745C2EFC98E153")
    @Deprecated
public void send(DatagramPacket packet, byte ttl) throws IOException {
        checkOpen();
        InetAddress packAddr = packet.getAddress();
        int currTTL = getTimeToLive();
        if (packAddr.isMulticastAddress() && (byte) currTTL != ttl) {
            try {
                setTimeToLive(ttl & 0xff);
                impl.send(packet);
            } finally {
                setTimeToLive(currTTL);
            }
        } else {
            impl.send(packet);
        }
    }

    /**
     * Sets the outgoing network interface used by this socket. The interface used is the first
     * interface found to have the given {@code address}. To avoid inherent unpredictability,
     * new code should use {@link #getNetworkInterface} instead.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.696 -0500", hash_original_method = "89C8198F5D22E8812FC96CB1AE49CBE2", hash_generated_method = "8F329DF56ADDDD979EBB0C14E191B1FB")
    public void setInterface(InetAddress address) throws SocketException {
        checkOpen();
        if (address == null) {
            throw new NullPointerException("address == null");
        }

        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
        if (networkInterface == null) {
            throw new SocketException("Address not associated with an interface: " + address);
        }
        impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        this.setAddress = address;
    }

    /**
     * Sets the outgoing network interface used by this socket to the given
     * {@code networkInterface}.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.697 -0500", hash_original_method = "103D9F8CED47CA1D8B78CD3F071983B8", hash_generated_method = "61C4B4BB58AEB688F76D3698EEA04576")
    public void setNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        checkOpen();
        if (networkInterface == null) {
            throw new SocketException("networkInterface == null");
        }

        impl.setOption(SocketOptions.IP_MULTICAST_IF2, networkInterface.getIndex());
        this.setAddress = null;
    }

    /**
     * Sets the time-to-live (TTL) for multicast packets sent on this socket.
     * Valid TTL values are between 0 and 255 inclusive.
     *
     * @throws IOException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.698 -0500", hash_original_method = "87E1DCD7CA258C3733B679C47E824196", hash_generated_method = "F93790A0722C5493E51C191EEC988AE0")
    public void setTimeToLive(int ttl) throws IOException {
        checkOpen();
        if (ttl < 0 || ttl > 255) {
            throw new IllegalArgumentException("TimeToLive out of bounds: " + ttl);
        }
        impl.setTimeToLive(ttl);
    }

    /**
     * Sets the time-to-live (TTL) for multicast packets sent on this socket.
     * Valid TTL values are between 0 and 255 inclusive.
     *
     * @throws IOException if an error occurs.
     * @deprecated Replaced by {@link #setTimeToLive}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.699 -0500", hash_original_method = "5513CDD24FF579269A679F40508B01F6", hash_generated_method = "153EA4F07F6DA6A6A096D6E089E52F7C")
    @Deprecated
public void setTTL(byte ttl) throws IOException {
        checkOpen();
        impl.setTTL(ttl);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.700 -0500", hash_original_method = "EBCEB6AAB2ED917FE096C1D1630BA905", hash_generated_method = "B8910BDDD82261F958A35850A4498C3E")
    @Override
synchronized void createSocket(int aPort, InetAddress addr) throws SocketException {
        impl = factory != null ? factory.createDatagramSocketImpl() : new PlainDatagramSocketImpl();
        impl.create();
        try {
            impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.TRUE);
            impl.bind(aPort, addr);
            isBound = true;
        } catch (SocketException e) {
            close();
            throw e;
        }
    }

    /**
     * Returns true if multicast loopback is <i>disabled</i>.
     * See {@link SocketOptions#IP_MULTICAST_LOOP}, and note that the sense of this is the
     * opposite of the underlying Unix {@code IP_MULTICAST_LOOP}.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.701 -0500", hash_original_method = "DC4B33B8ADF09E78AF384B12E0911A9B", hash_generated_method = "681905D13265AB2174A0DFA3517D1DF8")
    public boolean getLoopbackMode() throws SocketException {
        checkOpen();
        return !((Boolean) impl.getOption(SocketOptions.IP_MULTICAST_LOOP)).booleanValue();
    }

    /**
     * Disables multicast loopback if {@code disable == true}.
     * See {@link SocketOptions#IP_MULTICAST_LOOP}, and note that the sense of this is the
     * opposite of the underlying Unix {@code IP_MULTICAST_LOOP}.
     *
     * @throws SocketException if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:04.701 -0500", hash_original_method = "3AC1197302083655B98FC683162962C9", hash_generated_method = "07FDB573A41CFAD5F4F15DFD6B8A0330")
    public void setLoopbackMode(boolean disable) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.IP_MULTICAST_LOOP, Boolean.valueOf(!disable));
    }

    
}

