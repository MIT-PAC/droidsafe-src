package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;

import libcore.io.IoBridge;





public abstract class DatagramSocketImpl implements SocketOptions {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.705 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "22B1DDEE70BE0A6499271C452045F538")

    protected FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.707 -0500", hash_original_field = "B2492D7ECB702A5F09554B8EDF522849", hash_generated_field = "835B3BA626C36002B6BEC677A2C9AE47")

    protected int localPort;

    /**
     * Constructs an unbound datagram socket implementation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.711 -0500", hash_original_method = "36741B3348F3C30E5BB773EA210AEA7B", hash_generated_method = "E9785178B93C83BC1AE083F584295263")
    
public DatagramSocketImpl() {
        localPort = -1;
    }

    /**
     * Binds the datagram socket to the given localhost/port. Sockets must be
     * bound prior to attempting to send or receive data.
     *
     * @param port
     *            the port on the localhost to bind.
     * @param addr
     *            the address on the multihomed localhost to bind.
     * @throws SocketException
     *                if an error occurs while binding, for example, if the port
     *                has been already bound.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.713 -0500", hash_original_method = "FE8A8A46ED8B7BEC1B130BF00E626B2B", hash_generated_method = "2F9EF19973F199459087B88664C54EB0")
    
protected abstract void bind(int port, InetAddress addr) throws SocketException;

    /**
     * Closes this socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.716 -0500", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "0C36956994211212E0CDECE52E62CAEA")
    
protected abstract void close();

    /**
     * This method allocates the socket descriptor in the underlying operating
     * system.
     *
     * @throws SocketException
     *             if an error occurs while creating the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.718 -0500", hash_original_method = "63069B639E58D5DBC601400937E19710", hash_generated_method = "B3C6E7E8045EE58F1AFB4B797B649F31")
    
protected abstract void create() throws SocketException;

    /**
     * Gets the {@code FileDescriptor} of this datagram socket, which is invalid
     * if the socket is closed or not bound.
     *
     * @return the current file descriptor of this socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.720 -0500", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "C8664C638E6E7676776FC905B50F6CA8")
    
protected FileDescriptor getFileDescriptor() {
        return fd;
    }

    /**
     * Returns the local address to which the socket is bound.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.723 -0500", hash_original_method = "0E5E291FF84E111D5E99E4DCFA7BD180", hash_generated_method = "0E5E291FF84E111D5E99E4DCFA7BD180")
    
InetAddress getLocalAddress() {
        return IoBridge.getSocketLocalAddress(fd);
    }

    /**
     * Returns the local port to which this socket is bound.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.726 -0500", hash_original_method = "85505F9FF32DDEB1685867EF44676F61", hash_generated_method = "EF05AE2861ED9232B1E064D4A2DDDDC5")
    
protected int getLocalPort() {
        return localPort;
    }

    /**
     * Gets the time-to-live (TTL) for multicast packets sent on this socket.
     *
     * @return the time-to-live option as a byte value.
     * @throws IOException
     *             if an error occurs while getting the time-to-live option
     *             value.
     * @deprecated Replaced by {@link #getTimeToLive}
     * @see #getTimeToLive()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.728 -0500", hash_original_method = "F099E1C41B694EAD2D2039587A594DBF", hash_generated_method = "05CCBE891AA15F5247EDEA7226433FB1")
    
@Deprecated
    protected abstract byte getTTL() throws IOException;

    /**
     * Gets the time-to-live (TTL) for multicast packets sent on this socket.
     * The TTL option defines how many routers a packet may be pass before it is
     * discarded.
     *
     * @return the time-to-live option as an integer value.
     * @throws IOException
     *             if an error occurs while getting the time-to-live option
     *             value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.731 -0500", hash_original_method = "D9719A430A5F54FDD1789960993CC8AC", hash_generated_method = "74D63A31CD8C74B09397ED867E75EA4E")
    
protected abstract int getTimeToLive() throws IOException;

    /**
     * Adds this socket to the multicast group {@code addr}. A socket must join
     * a group before being able to receive data. Further, a socket may be a
     * member of multiple groups but may join any group only once.
     *
     * @param addr
     *            the multicast group to which this socket has to be joined.
     * @throws IOException
     *             if an error occurs while joining the specified multicast
     *             group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.733 -0500", hash_original_method = "D49A72B7415DDB957EDFD1E887D2BCA0", hash_generated_method = "FF94A7086BC1F6746454B09A014789DC")
    
protected abstract void join(InetAddress addr) throws IOException;

    /**
     * Adds this socket to the multicast group {@code addr}. A socket must join
     * a group before being able to receive data. Further, a socket may be a
     * member of multiple groups but may join any group only once.
     *
     * @param addr
     *            the multicast group to which this socket has to be joined.
     * @param netInterface
     *            the local network interface which will receive the multicast
     *            datagram packets.
     * @throws IOException
     *             if an error occurs while joining the specified multicast
     *             group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.736 -0500", hash_original_method = "0BC9B33A0D584BD63DDC3207428282C3", hash_generated_method = "486DDFC097C510374AAF67B009FA4689")
    
protected abstract void joinGroup(SocketAddress addr,
            NetworkInterface netInterface) throws IOException;

    /**
     * Removes this socket from the multicast group {@code addr}.
     *
     * @param addr
     *            the multicast group to be left.
     * @throws IOException
     *             if an error occurs while leaving the group or no multicast
     *             address was assigned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.738 -0500", hash_original_method = "9C63FA57009863F9BFCF40E2B8324C1A", hash_generated_method = "0B7ED6E08760E2C4B92DB2004904349D")
    
protected abstract void leave(InetAddress addr) throws IOException;

    /**
     * Removes this socket from the multicast group {@code addr}.
     *
     * @param addr
     *            the multicast group to be left.
     * @param netInterface
     *            the local network interface on which this socket has to be
     *            removed.
     * @throws IOException
     *             if an error occurs while leaving the group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.740 -0500", hash_original_method = "15FC74D8F1A71B68A2456B26D31E60F3", hash_generated_method = "BB3826376034144E4FE74668420A851A")
    
protected abstract void leaveGroup(SocketAddress addr,
            NetworkInterface netInterface) throws IOException;

    /**
     * Peeks at the incoming packet to this socket and returns the address of
     * the {@code sender}. The method will block until a packet is received or
     * timeout expires.
     *
     * @param sender
     *            the origin address of a packet.
     * @return the address of {@code sender} as an integer value.
     * @throws IOException
     *                if an error or a timeout occurs while reading the address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.743 -0500", hash_original_method = "0A55381DC5E8B9E18B2AFA6C4336B550", hash_generated_method = "5DD8A45C640AE6E22F25B85CF2FC2D6D")
    
protected abstract int peek(InetAddress sender) throws IOException;

    /**
     * Receives data and stores it in the supplied datagram packet {@code pack}.
     * This call will block until either data has been received or, if a timeout
     * is set, the timeout has expired. If the timeout expires an {@code
     * InterruptedIOException} is thrown.
     *
     * @param pack
     *            the datagram packet container to fill in the received data.
     * @throws IOException
     *                if an error or timeout occurs while receiving data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.745 -0500", hash_original_method = "7464E8A609D19003F435E467D9EE656D", hash_generated_method = "2FA9C6D18740487C4CBA6B9940169D32")
    
protected abstract void receive(DatagramPacket pack) throws IOException;

    /**
     * Sends the given datagram packet {@code pack}. The packet contains the
     * data and the address and port information of the target host as well.
     *
     * @param pack
     *            the datagram packet to be sent.
     * @throws IOException
     *                if an error occurs while sending the packet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.747 -0500", hash_original_method = "7039A6C69598C650829CBCEB48F7A5DF", hash_generated_method = "90D16BAE394684C1F39DA571F332F072")
    
protected abstract void send(DatagramPacket pack) throws IOException;

    /**
     * Sets the time-to-live (TTL) option for multicast packets sent on this
     * socket.
     *
     * @param ttl
     *            the time-to-live option value. Valid values are 0 &lt; ttl
     *            &lt;= 255.
     * @throws IOException
     *             if an error occurs while setting the option.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.750 -0500", hash_original_method = "FA7BA60D9C75190FDFDD090C2715CA20", hash_generated_method = "44405459E0F685CDE6998C289101CAEA")
    
protected abstract void setTimeToLive(int ttl) throws IOException;

    /**
     * Sets the time-to-live (TTL) option for multicast packets sent on this
     * socket.
     *
     * @param ttl
     *            the time-to-live option value. Valid values are 0 &lt; ttl
     *            &lt;= 255.
     * @throws IOException
     *             if an error occurs while setting the option.
     * @deprecated Replaced by {@link #setTimeToLive}
     * @see #setTimeToLive(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.752 -0500", hash_original_method = "6ADCF6BDAA2EE2F71E55365E5ADD6372", hash_generated_method = "3A9F8E7E78880716E3155881FE1F84E4")
    
@Deprecated
    protected abstract void setTTL(byte ttl) throws IOException;

    /**
     * Connects this socket to the specified remote address and port.
     *
     * @param inetAddr
     *            the address of the target host which has to be connected.
     * @param port
     *            the port on the target host which has to be connected.
     * @throws SocketException
     *                if the datagram socket cannot be connected to the
     *                specified remote address and port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.754 -0500", hash_original_method = "4B57C399BF813581E92D5F53070EA8D4", hash_generated_method = "027F2A2FF6ED7C8BFA4D89927F1A9178")
    
protected void connect(InetAddress inetAddr, int port)
            throws SocketException {
        // do nothing
    }

    /**
     * Disconnects this socket from the remote host.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.757 -0500", hash_original_method = "E948DE2D4A723F3312DB782756156847", hash_generated_method = "8D27A2F900F32936703B722740D16091")
    
protected void disconnect() {
        // do nothing
    }

    /**
     * Receives data into the supplied datagram packet by peeking. The data is
     * not removed from socket buffer and can be received again by another
     * {@code peekData()} or {@code receive()} call. This call blocks until
     * either data has been received or, if a timeout is set, the timeout has
     * been expired.
     *
     * @param pack
     *            the datagram packet used to store the data.
     * @return the port the packet was received from.
     * @throws IOException
     *                if an error occurs while peeking at the data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.759 -0500", hash_original_method = "71AE8210735110F7C36210F87AF8E6BB", hash_generated_method = "29AEA3957A65597E5C2CC5DB836535F8")
    
protected abstract int peekData(DatagramPacket pack) throws IOException;

    
}

