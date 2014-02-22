package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InetSocketAddress extends SocketAddress {

    /**
     * Creates an {@code InetSocketAddress} without trying to resolve the
     * hostname into an {@code InetAddress}. The address field is marked as
     * unresolved.
     *
     * @param host
     *            the specified hostname to which this socket is bound.
     * @param port
     *            the specified port number to which this socket is bound.
     * @return the created InetSocketAddress instance.
     * @throws IllegalArgumentException
     *             if the hostname {@code host} is {@code null} or the port is
     *             not in the range between 0 and 65535.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.641 -0500", hash_original_method = "D59CB5797FE9FDEEAB13B54DF3C64F08", hash_generated_method = "B3021AE91BF852E930D2D98E82380796")
    
public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(host, port, false);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.617 -0500", hash_original_field = "7F743DE8058FB2755DC0C37C7CC9A08D", hash_generated_field = "CA65D985F490176D565176BDD0E73685")

    private static final long serialVersionUID = 5076001401234631237L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.619 -0500", hash_original_field = "AD87F1710B0BBE13E418BD36FE4E24C7", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    @DSVAModeled
    private  InetAddress addr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.622 -0500", hash_original_field = "6B66041FD39815DF98C48C22668D1653", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    @DSVAModeled
    private  String hostname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.624 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    @DSVAModeled
    private  int port;

    /**
     * @hide internal use only
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.627 -0500", hash_original_method = "E61EEABC5DF9527410338B11302226FE", hash_generated_method = "4D6101AB37389FFA45490C9C535069AE")
    
public InetSocketAddress() {
        // These will be filled in the native implementation of recvfrom.
        this.addr = null;
        this.hostname = null;
        this.port = -1;
    }

    /**
     * Creates a socket endpoint with the given port number {@code port} and
     * no specified address. The range for valid port numbers is between 0 and
     * 65535 inclusive.
     *
     * @param port
     *            the specified port number to which this socket is bound.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.629 -0500", hash_original_method = "95F398A6CE4FD1305EED1666777F8263", hash_generated_method = "CD33CA8FB1F3123A4A03C02AA3494ECC")
    
public InetSocketAddress(int port) {
        this((InetAddress) null, port);
    }

    /**
     * Creates a socket endpoint with the given port number {@code port} and
     * {@code address}. The range for valid port numbers is between 0 and 65535
     * inclusive. If {@code address} is {@code null} this socket is bound to the
     * IPv4 wildcard address.
     *
     * @param port
     *            the specified port number to which this socket is bound.
     * @param address
     *            the specified address to which this socket is bound.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.632 -0500", hash_original_method = "9F6BF484BF454F89FD6A310ADFCD9122", hash_generated_method = "A3FF0FE93DD89D7DDA0D00CCF9EE59E9")
    
public InetSocketAddress(InetAddress address, int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("port=" + port);
        }
        this.addr = (address == null) ? Inet4Address.ANY : address;
        this.hostname = null;
        this.port = port;
    }

    /**
     * Creates a socket endpoint with the given port number {@code port} and the
     * hostname {@code host}. The hostname is tried to be resolved and cannot be
     * {@code null}. The range for valid port numbers is between 0 and 65535
     * inclusive.
     *
     * @param port
     *            the specified port number to which this socket is bound.
     * @param host
     *            the specified hostname to which this socket is bound.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.635 -0500", hash_original_method = "6C9F5B77CD6EF4C5F038F88B12F1FECD", hash_generated_method = "71E9E971E7D0422D05092181F52B89E1")
    
public InetSocketAddress(String host, int port) {
        this(host, port, true);
    }

    /*
     * Internal constructor for InetSocketAddress(String, int) and
     * createUnresolved(String, int);
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.638 -0500", hash_original_method = "10794513C1E3AAEE9C124882A7C67C11", hash_generated_method = "10794513C1E3AAEE9C124882A7C67C11")
    
InetSocketAddress(String hostname, int port, boolean needResolved) {
        if (hostname == null || port < 0 || port > 65535) {
            throw new IllegalArgumentException("host=" + hostname + ", port=" + port);
        }

        InetAddress addr = null;
        if (needResolved) {
            try {
                addr = InetAddress.getByName(hostname);
                hostname = null;
            } catch (UnknownHostException ignored) {
            }
        }
        this.addr = addr;
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Gets the port number of this socket.
     *
     * @return the socket endpoint port number.
     */
    @DSSpec(DSCat.NETWORKING)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.643 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "E126B6DCEFD20BABFE67A5DF1C3260B4")
    
public final int getPort() {
        return port;
    }

    /**
     * Gets the address of this socket.
     *
     * @return the socket endpoint address.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.646 -0500", hash_original_method = "EBC0D8AF364C08270D1E1C0275ACCE70", hash_generated_method = "58EFD60573CF340F0B118334D4223CC2")
    
public final InetAddress getAddress() {
        return addr;
    }

    /**
     * Returns the hostname, doing a reverse lookup on the {@code InetAddress} if no
     * hostname string was provided at construction time.
     */
    @DSSpec(DSCat.NETWORKING)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.648 -0500", hash_original_method = "6B2BE268DC286B10AABA01E5C61B1025", hash_generated_method = "47DBD0EB47A52E31FF9344CBBA2DA06B")
    
public final String getHostName() {
        return (addr != null) ? addr.getHostName() : hostname;
    }

    /**
     * Returns the hostname if known, or the result of {@code InetAddress.getHostAddress}.
     * Unlike {@link #getHostName}, this method will never cause a DNS lookup.
     * @since 1.7
     * @hide 1.7 - remember to add a link in the getHostName documentation!
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.650 -0500", hash_original_method = "152FB4941FA191CB3163ABC6AAB86F6D", hash_generated_method = "B696DAEE59E1EF2DF1031EFD69771561")
    
public final String getHostString() {
        return (hostname != null) ? hostname : addr.getHostAddress();
    }

    /**
     * Returns whether this socket address is unresolved or not.
     *
     * @return {@code true} if this socket address is unresolved, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.653 -0500", hash_original_method = "516016D8DE08604CF0F5A3746D5ACA08", hash_generated_method = "F7284E3F9F89FE40660E3A9EBEBCC085")
    
public final boolean isUnresolved() {
        return addr == null;
    }

    /**
     * Gets a string representation of this socket included the address and the
     * port number.
     *
     * @return the address and port number as a textual representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.655 -0500", hash_original_method = "B37E37F388D00532D9BE005F391E9AE5", hash_generated_method = "783EE48230B34BDEE2030AD8909E7990")
    
@Override
    public String toString() {
        return ((addr != null) ? addr.toString() : hostname) + ":" + port;
    }

    /**
     * Compares two socket endpoints and returns true if they are equal. Two
     * socket endpoints are equal if the IP address or the hostname of both are
     * equal and they are bound to the same port.
     *
     * @param socketAddr
     *            the object to be tested for equality.
     * @return {@code true} if this socket and the given socket object {@code
     *         socketAddr} are equal, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.658 -0500", hash_original_method = "A55E654199D420BD447FD45C56E388DE", hash_generated_method = "04E26C740CBB268443E88B1C4173063B")
    
@Override
    public final boolean equals(Object socketAddr) {
        if (this == socketAddr) {
            return true;
        }
        if (!(socketAddr instanceof InetSocketAddress)) {
            return false;
        }
        InetSocketAddress iSockAddr = (InetSocketAddress) socketAddr;

        // check the ports as we always need to do this
        if (port != iSockAddr.port) {
            return false;
        }

        // we only use the hostnames in the comparison if the addrs were not
        // resolved
        if ((addr == null) && (iSockAddr.addr == null)) {
            return hostname.equals(iSockAddr.hostname);
        }

        // addrs were resolved so use them for the comparison
        if (addr == null) {
            // if we are here we know iSockAddr is not null so just return
            // false
            return false;
        }
        return addr.equals(iSockAddr.addr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.661 -0500", hash_original_method = "65AE406344FAC31F9ADA9FAD1BC1AA72", hash_generated_method = "5E6C36BD731406DA9ACC181859B04F7D")
    
@Override
    public final int hashCode() {
        if (addr == null) {
            return hostname.hashCode() + port;
        }
        return addr.hashCode() + port;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.663 -0500", hash_original_method = "A70A079C45F63B1946A4E7EB22F91BB3", hash_generated_method = "A4B6EECE5542ADD758A9646D60C4E193")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
    }
}

