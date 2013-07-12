package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.ValueAnalysisModelingSet;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
// import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import soot.jimple.spark.pag.AllocNode;
import java.util.Set;

public class InetAddress extends ValueAnalysisModeledObject {

    Set<String> hostName = new ValueAnalysisModelingSet<String>();
    Set<ValueAnalysisInt> family = new ValueAnalysisModelingSet<ValueAnalysisInt>();

    public InetAddress(AllocNode allocNode) {
        super(allocNode);
    }

    /**
     * Constructs an {@code InetAddress}.
     *
     * Note: this constructor is for subclasses only.
     */
    void _init_(Set<ValueAnalysisInt> family, byte[] ipaddress, Set<String> hostName) {
        this.family.addAll(family);
        this.hostName.addAll(hostName);
    }

    /**
     * Compares this {@code InetAddress} instance against the specified address
     * in {@code obj}. Two addresses are equal if their address byte arrays have
     * the same length and if the bytes in the arrays are equal.
     *
     * @param obj
     *            the object to be tested for equality.
     * @return {@code true} if both objects are equal, {@code false} otherwise.
     */
//    @Override
//    public boolean equals(Object obj) {
//        return false;
//    }

    /**
     * Returns the IP address represented by this {@code InetAddress} instance
     * as a byte array. The elements are in network order (the highest order
     * address byte is in the zeroth element).
     *
     * @return the address in form of a byte array.
     */
//    public byte[] getAddress() {
//        __ds__invalidate();
//        return null;
//    }

    /**
     * Converts an array of byte arrays representing raw IP addresses of a host
     * to an array of InetAddress objects.
     *
     * @param rawAddresses the raw addresses to convert.
     * @param hostName the hostname corresponding to the IP address.
     * @return the corresponding InetAddresses, appropriately sorted.
     */
//    private static InetAddress[] bytesToInetAddresses(byte[][] rawAddresses, Set<String> hostName) throws UnknownHostException {
//        return null;
//    }

    /**
     * Gets all IP addresses associated with the given {@code host} identified
     * by name or literal IP address. The IP address is resolved by the
     * configured name service. If the host name is empty or {@code null} an
     * {@code UnknownHostException} is thrown. If the host name is a literal IP
     * address string an array with the corresponding single {@code InetAddress}
     * is returned.
     *
     * @param host the hostname or literal IP string to be resolved.
     * @return the array of addresses associated with the specified host.
     * @throws UnknownHostException if the address lookup fails.
     */
//    public static InetAddress[] getAllByName(Set<String> host) throws UnknownHostException {
//        return null;
//    }

    /**
     * Returns the InetAddresses for {@code host}. The returned array is shared
     * and must be cloned before it is returned to application code.
     */
//    private static InetAddress[] getAllByNameImpl(Set<String> host) throws UnknownHostException {
//        return null;
//    }
//
//    private static InetAddress makeInetAddress(byte[] bytes, Set<String> hostName) throws UnknownHostException {
//        return null;
//    }
//
//    private static InetAddress disallowDeprecatedFormats(Set<String> address, InetAddress inetAddress) {
//        return null;
//    }
//
//    private static InetAddress parseNumericAddressNoThrow(Set<String> address) {
//        return null;
//    }

    /**
     * Returns the address of a host according to the given host string name
     * {@code host}. The host string may be either a machine name or a dotted
     * string IP address. If the latter, the {@code hostName} field is
     * determined upon demand. {@code host} can be {@code null} which means that
     * an address of the loopback interface is returned.
     *
     * @param host
     *            the hostName to be resolved to an address or {@code null}.
     * @return the {@code InetAddress} instance representing the host.
     * @throws UnknownHostException
     *             if the address lookup fails.
     */
//    public static InetAddress getByName(Set<String> host) throws UnknownHostException {
//        return null;
//    }

    /**
     * Returns the numeric representation of this IP address (such as "127.0.0.1").
     */
//    public Set<String> getHostAddress() {
//        __ds__invalidate();
//        return null;
//    }

    /**
     * Returns the host name corresponding to this IP address. This may or may not be a
     * fully-qualified name. If the IP address could not be resolved, the numeric representation
     * is returned instead (see {@link #getHostAddress}).
     */
    public Set<String> getHostName() {
        return this.hostName;
    }

    /**
     * Returns the fully qualified hostname corresponding to this IP address.
     */
//    public String getCanonicalHostName() {
//        __ds__invalidate();
//        return null;
//    }

    /**
     * Returns an {@code InetAddress} for the local host if possible, or the
     * loopback address otherwise. This method works by getting the hostname,
     * performing a DNS lookup, and then taking the first returned address.
     * For devices with multiple network interfaces and/or multiple addresses
     * per interface, this does not necessarily return the {@code InetAddress}
     * you want.
     *
     * <p>Multiple interface/address configurations were relatively rare
     * when this API was designed, but multiple interfaces are the default for
     * modern mobile devices (with separate wifi and radio interfaces), and
     * the need to support both IPv4 and IPv6 has made multiple addresses
     * commonplace. New code should thus avoid this method except where it's
     * basically being used to get a loopback address or equivalent.
     *
     * <p>There are two main ways to get a more specific answer:
     * <ul>
     * <li>If you have a connected socket, you should probably use
     * {@link Socket#getLocalAddress} instead: that will give you the address
     * that's actually in use for that connection. (It's not possible to ask
     * the question "what local address would a connection to a given remote
     * address use?"; you have to actually make the connection and see.)</li>
     * <li>For other use cases, see {@link NetworkInterface}, which lets you
     * enumerate all available network interfaces and their addresses.</li>
     * </ul>
     *
     * <p>Note that if the host doesn't have a hostname set&nbsp;&ndash; as
     * Android devices typically don't&nbsp;&ndash; this method will
     * effectively return the loopback address, albeit by getting the name
     * {@code localhost} and then doing a lookup to translate that to
     * {@code 127.0.0.1}.
     *
     * @return an {@code InetAddress} representing the local host, or the
     * loopback address.
     * @throws UnknownHostException
     *             if the address lookup fails.
     */
//    public static InetAddress getLocalHost() throws UnknownHostException {
//        return null;
//    }

    /**
     * Gets the hashcode of the represented IP address.
     *
     * @return the appropriate hashcode value.
     */
//    @Override
//    public int hashCode() {
//        __ds__invalidate();
//        return 0;
//    }

    /**
     * Resolves a hostname to its IP addresses using a cache.
     *
     * @param host the hostname to resolve.
     * @return the IP addresses of the host.
     */
//    private static InetAddress[] lookupHostByName(Set<String> host) throws UnknownHostException {
//        return null;
//    }

    /**
     * Removes all entries from the VM's DNS cache. This does not affect the C library's DNS
     * cache, nor any caching DNS servers between you and the canonical server.
     * @hide
     */
//    public static void clearDnsCache() {
//    }

//    private static InetAddress getHostByAddrImpl(InetAddress address) throws UnknownHostException {
//        return null;
//    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * IP address.
     *
     * @return the description, as host/address.
     */
//    @Override
//    public String toString() {
//        __ds__invalidate();
//        return null;
//    }

    /**
     * Returns true if the string is a valid numeric IPv4 or IPv6 address (such as "192.168.0.1").
     * This copes with all forms of address that Java supports, detailed in the {@link InetAddress}
     * class documentation.
     *
     * @hide used by frameworks/base to ensure that a getAllByName won't cause a DNS lookup.
     */
//    public static boolean isNumeric(Set<String> address) {
//        return false;
//    }

    /**
     * Returns an InetAddress corresponding to the given numeric address (such
     * as {@code "192.168.0.1"} or {@code "2001:4860:800d::68"}).
     * This method will never do a DNS lookup. Non-numeric addresses are errors.
     *
     * @hide used by frameworks/base's NetworkUtils.numericToInetAddress
     * @throws IllegalArgumentException if {@code numericAddress} is not a numeric address
     */
//    public static InetAddress parseNumericAddress(Set<String> numericAddress) {
//        return null;
//    }

//    private static InetAddress[] loopbackAddresses() {
//        return null;
//    }

    /**
     * Returns the IPv6 loopback address {@code ::1} or the IPv4 loopback address {@code 127.0.0.1}.
     * @since 1.7
     * @hide 1.7
     */
//    public static InetAddress getLoopbackAddress() {
//        return null;
//    }

    /**
     * Returns whether this is the IPv6 unspecified wildcard address {@code ::}
     * or the IPv4 "any" address, {@code 0.0.0.0}.
     */
    public boolean isAnyLocalAddress() {
        __ds__invalidate();
        return false;
    }

    /**
     * Returns whether this address is a link-local address or not.
     *
     * <p>Valid IPv6 link-local addresses have the prefix {@code fe80::/10}.
     *
     * <p><a href="http://www.ietf.org/rfc/rfc3484.txt">RFC 3484</a>
     * "Default Address Selection for Internet Protocol Version 6 (IPv6)" states
     * that both IPv4 auto-configuration addresses (prefix {@code 169.254/16}) and
     * IPv4 loopback addresses (prefix {@code 127/8}) have link-local scope, but
     * {@link Inet4Address} only considers the auto-configuration addresses
     * to have link-local scope. That is: the IPv4 loopback address returns false.
     */
//    public boolean isLinkLocalAddress() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a loopback address or not.
     *
     * <p>Valid IPv4 loopback addresses have the prefix {@code 127/8}.
     *
     * <p>The only valid IPv6 loopback address is {@code ::1}.
     */
//    public boolean isLoopbackAddress() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a global multicast address or not.
     *
     * <p>Valid IPv6 global multicast addresses have the prefix {@code ffxe::/16},
     * where {@code x} is a set of flags and the additional 112 bits make
     * up the global multicast address space.
     *
     * <p>Valid IPv4 global multicast addresses are the range of addresses
     * from {@code 224.0.1.0} to {@code 238.255.255.255}.
     */
//    public boolean isMCGlobal() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a link-local multicast address or not.
     *
     * <p>Valid IPv6 link-local multicast addresses have the prefix {@code ffx2::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>Valid IPv4 link-local multicast addresses have the prefix {@code 224.0.0/24}.
     */
//    public boolean isMCLinkLocal() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a node-local multicast address or not.
     *
     * <p>Valid IPv6 node-local multicast addresses have the prefix {@code ffx1::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>There are no valid IPv4 node-local multicast addresses.
     */
//    public boolean isMCNodeLocal() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a organization-local multicast address or not.
     *
     * <p>Valid IPv6 organization-local multicast addresses have the prefix {@code ffx8::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>Valid IPv4 organization-local multicast addresses have the prefix {@code 239.192/14}.
     */
//    public boolean isMCOrgLocal() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a site-local multicast address or not.
     *
     * <p>Valid IPv6 site-local multicast addresses have the prefix {@code ffx5::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>Valid IPv4 site-local multicast addresses have the prefix {@code 239.255/16}.
     */
//    public boolean isMCSiteLocal() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a multicast address or not.
     *
     * <p>Valid IPv6 multicast addresses have the prefix {@code ff::/8}.
     *
     * <p>Valid IPv4 multicast addresses have the prefix {@code 224/4}.
     */
//    public boolean isMulticastAddress() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Returns whether this address is a site-local address or not.
     *
     * <p>For the purposes of this method, valid IPv6 site-local addresses have
     * the deprecated prefix {@code fec0::/10} from
     * <a href="http://www.ietf.org/rfc/rfc1884.txt">RFC 1884</a>,
     * <i>not</i> the modern prefix {@code fc00::/7} from
     * <a href="http://www.ietf.org/rfc/rfc4193.txt">RFC 4193</a>.
     *
     * <p><a href="http://www.ietf.org/rfc/rfc3484.txt">RFC 3484</a>
     * "Default Address Selection for Internet Protocol Version 6 (IPv6)" states
     * that IPv4 private addresses have the prefix {@code 10/8}, {@code 172.16/12},
     * or {@code 192.168/16}.
     *
     * @return {@code true} if this instance represents a site-local address,
     *         {@code false} otherwise.
     */
//    public boolean isSiteLocalAddress() {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Tries to reach this {@code InetAddress}. This method first tries to use
     * ICMP <i>(ICMP ECHO REQUEST)</i>, falling back to a TCP connection
     * on port 7 (Echo) of the remote host.
     *
     * @param timeout
     *            timeout in milliseconds before the test fails if no connection
     *            could be established.
     * @return {@code true} if this address is reachable, {@code false}
     *         otherwise.
     * @throws IOException
     *             if an error occurs during an I/O operation.
     * @throws IllegalArgumentException
     *             if timeout is less than zero.
     */
//    public boolean isReachable(Set<ValueAnalysisInt> timeout) throws IOException {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Tries to reach this {@code InetAddress}. This method first tries to use
     * ICMP <i>(ICMP ECHO REQUEST)</i>, falling back to a TCP connection
     * on port 7 (Echo) of the remote host.
     *
     * @param networkInterface
     *            the network interface on which to connection should be
     *            established.
     * @param ttl
     *            the maximum count of hops (time-to-live).
     * @param timeout
     *            timeout in milliseconds before the test fails if no connection
     *            could be established.
     * @return {@code true} if this address is reachable, {@code false}
     *         otherwise.
     * @throws IOException
     *             if an error occurs during an I/O operation.
     * @throws IllegalArgumentException
     *             if ttl or timeout is less than zero.
     */
//    public boolean isReachable(NetworkInterface networkInterface, final Set<ValueAnalysisInt> ttl, final Set<ValueAnalysisInt> timeout) throws IOException {
//        __ds__invalidate();
//        return false;
//    }

//    private boolean isReachable(InetAddress destination, InetAddress source, Set<ValueAnalysisInt> timeout) throws IOException {
//        __ds__invalidate();
//        return false;
//    }

    /**
     * Equivalent to {@code getByAddress(null, ipAddress)}. Handy for addresses with
     * no associated hostname.
     */
//    public static InetAddress getByAddress(byte[] ipAddress) throws UnknownHostException {
//        return null;
//    }

    /**
     * Returns an {@code InetAddress} corresponding to the given network-order
     * bytes {@code ipAddress} and {@code scopeId}.
     *
     * <p>For an IPv4 address, the byte array must be of length 4.
     * For IPv6, the byte array must be of length 16. Any other length will cause an {@code
     * UnknownHostException}.
     *
     * <p>No reverse lookup is performed. The given {@code hostName} (which may be null) is
     * associated with the new {@code InetAddress} with no validation done.
     *
     * <p>(Note that numeric addresses such as {@code "127.0.0.1"} are names for the
     * purposes of this API. Most callers probably want {@link #getAllByName} instead.)
     *
     * @throws UnknownHostException if {@code ipAddress} is null or the wrong length.
     */
//    public static InetAddress getByAddress(Set<String> hostName, byte[] ipAddress) throws UnknownHostException {
//        return null;
//    }
//
//    private static InetAddress getByAddress(Set<String> hostName, byte[] ipAddress, Set<ValueAnalysisInt> scopeId) throws UnknownHostException {
//        return null;
//    }
//
//    private static UnknownHostException badAddressLength(byte[] bytes) throws UnknownHostException {
//        return null;
//    }
//
//    private static boolean isIPv4MappedAddress(byte[] ipAddress) {
//        return false;
//    }
//
//    private static byte[] ipv4MappedToIPv4(byte[] mappedAddress) {
//        return null;
//    }
//
//    private void writeObject(ObjectOutputStream stream) throws IOException {
//        __ds__invalidate();
//    }
//
//    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//        __ds__invalidate();
//    }
//
//    private Object readResolve() throws ObjectStreamException {
//        __ds__invalidate();
//        return null;
//    }
}
