package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET;
import static libcore.io.OsConstants.EADDRNOTAVAIL;
import static libcore.io.OsConstants.IFF_LOOPBACK;
import static libcore.io.OsConstants.IFF_MULTICAST;
import static libcore.io.OsConstants.IFF_POINTOPOINT;
import static libcore.io.OsConstants.IFF_UP;
import static libcore.io.OsConstants.SIOCGIFADDR;
import static libcore.io.OsConstants.SIOCGIFBRDADDR;
import static libcore.io.OsConstants.SIOCGIFNETMASK;
import static libcore.io.OsConstants.SOCK_DGRAM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;

public final class NetworkInterface extends Object {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.629 -0500", hash_original_method = "B221CC75BF34BFBFBAF89FBF07707022", hash_generated_method = "39A35D04694321A6A7B0D56952040B32")
    
static NetworkInterface forUnboundMulticastSocket() {
        // This is what the RI returns for a MulticastSocket that hasn't been constrained
        // to a specific interface.
        return new NetworkInterface(null, -1,
                Arrays.asList(Inet6Address.ANY), Collections.<InterfaceAddress>emptyList());
    }

    /**
     * Returns the {@code NetworkInterface} corresponding to the named network interface, or null
     * if no interface has this name.
     *
     * @throws SocketException if an error occurs.
     * @throws NullPointerException if {@code interfaceName == null}.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Network interface accessing")
    @DSSpec(DSCat.NETWORK)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.641 -0500", hash_original_method = "EC81104C8006573D0B5015A0AF9F06F0", hash_generated_method = "EF8E107A0F265E928EBACFC41E9A3312")
    
public static NetworkInterface getByName(String interfaceName) throws SocketException {
        if (interfaceName == null) {
            throw new NullPointerException("interfaceName == null");
        }
        if (!isValidInterfaceName(interfaceName)) {
            return null;
        }

        int interfaceIndex = readIntFile("/sys/class/net/" + interfaceName + "/ifindex");
        List<InetAddress> addresses = new ArrayList<InetAddress>();
        List<InterfaceAddress> interfaceAddresses = new ArrayList<InterfaceAddress>();
        collectIpv6Addresses(interfaceName, interfaceIndex, addresses, interfaceAddresses);
        collectIpv4Address(interfaceName, addresses, interfaceAddresses);

        return new NetworkInterface(interfaceName, interfaceIndex, addresses, interfaceAddresses);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.644 -0500", hash_original_method = "DF0FB38845F1D102FDFDE7ACAB39C1AC", hash_generated_method = "DD27B9020CA861CB583E10298E34C3BC")
    
private static void collectIpv6Addresses(String interfaceName, int interfaceIndex,
            List<InetAddress> addresses, List<InterfaceAddress> interfaceAddresses) throws SocketException {
        // Format of /proc/net/if_inet6 (all numeric fields are implicit hex).
        // 1. IPv6 address
        // 2. interface index
        // 3. prefix length
        // 4. scope
        // 5. flags
        // 6. interface name
        // "00000000000000000000000000000001 01 80 10 80       lo"
       /* BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("/proc/net/if_inet6"));
            String suffix = " " + interfaceName;
            String line;
            while ((line = in.readLine()) != null) {
                if (!line.endsWith(suffix)) {
                    continue;
                }
                byte[] addressBytes = new byte[16];
                for (int i = 0; i < addressBytes.length; ++i) {
                    addressBytes[i] = (byte) Integer.parseInt(line.substring(2*i, 2*i + 2), 16);
                }
                short prefixLength = Short.parseShort(line.substring(36, 38), 16);
                Inet6Address inet6Address = new Inet6Address(addressBytes, null, interfaceIndex);

                addresses.add(inet6Address);
                interfaceAddresses.add(new InterfaceAddress(inet6Address, prefixLength));
            }
        } catch (Exception ex) {
            throw rethrowAsSocketException(ex);
        } finally {
            IoUtils.closeQuietly(in);
        }*/
        
        short prefixLength = 0;
        Inet6Address inet6Address = new Inet6Address(new byte[1], null, 0);
        interfaceAddresses.add(new InterfaceAddress(inet6Address, prefixLength));
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.648 -0500", hash_original_method = "94D78D0B75F8342178E142C0650C9826", hash_generated_method = "449E16074333C15C6AB7217B3EC188CF")
    
private static void collectIpv4Address(String interfaceName, List<InetAddress> addresses,
            List<InterfaceAddress> interfaceAddresses) throws SocketException {
       /* FileDescriptor fd = null;
        try {
            fd = Libcore.os.socket(AF_INET, SOCK_DGRAM, 0);
            InetAddress address = Libcore.os.ioctlInetAddress(fd, SIOCGIFADDR, interfaceName);
            InetAddress broadcast = Libcore.os.ioctlInetAddress(fd, SIOCGIFBRDADDR, interfaceName);
            InetAddress netmask = Libcore.os.ioctlInetAddress(fd, SIOCGIFNETMASK, interfaceName);
            if (broadcast.equals(Inet4Address.ANY)) {
                broadcast = null;
            }

            addresses.add(address);
            interfaceAddresses.add(new InterfaceAddress((Inet4Address) address,
                    (Inet4Address) broadcast, (Inet4Address) netmask));
        } catch (ErrnoException errnoException) {
            if (errnoException.errno != EADDRNOTAVAIL) {
                // EADDRNOTAVAIL just means no IPv4 address for this interface.
                // Anything else is a real error.
                throw rethrowAsSocketException(errnoException);
            }
        } catch (Exception ex) {
            throw rethrowAsSocketException(ex);
        } finally {
            IoUtils.closeQuietly(fd);
        }*/
        short prefixLength = 0;
        Inet4Address inet4Address = new Inet4Address(new byte[1], "");
        interfaceAddresses.add(new InterfaceAddress(inet4Address, inet4Address, inet4Address));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.651 -0500", hash_original_method = "A493AF52D537772EC9DA5C5C6A13B9D1", hash_generated_method = "5FA96DEA31793464D6E4A442FEC974A7")
    
@FindBugsSuppressWarnings("DMI_HARDCODED_ABSOLUTE_FILENAME")
    private static boolean isValidInterfaceName(String interfaceName) {
        // Don't just stat because a crafty user might have / or .. in the supposed interface name.
        /*for (String validName : new File("/sys/class/net").list()) {
            if (interfaceName.equals(validName)) {
                return true;
            }
        }
        return false;*/
        return interfaceName.getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.654 -0500", hash_original_method = "7D3B21C401D86D194908014A1A22C808", hash_generated_method = "B96482B7707A80DAE8234FBBB9DCA39A")
    
private static int readIntFile(String path) throws SocketException {
        try {
            String s = IoUtils.readFileAsString(path).trim();
            if (s.startsWith("0x")) {
                return Integer.parseInt(s.substring(2), 16);
            } else {
                return Integer.parseInt(s);
            }
        } catch (Exception ex) {
            throw rethrowAsSocketException(ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.656 -0500", hash_original_method = "FB6FEE373D57A234CE759121C2A038EA", hash_generated_method = "E266CE47973441E942358FEAD2C9DB4C")
    
private static SocketException rethrowAsSocketException(Exception ex) throws SocketException {
        SocketException result = new SocketException();
        result.initCause(ex);
        throw result;
    }

    /**
     * Returns the {@code NetworkInterface} corresponding to the given address, or null if no
     * interface has this address.
     *
     * @throws SocketException if an error occurs.
     * @throws NullPointerException if {@code address == null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.659 -0500", hash_original_method = "C5BED01285EEC8C891B8D4941E84B7EA", hash_generated_method = "442F63E2864AF74B9727B2ACEF63732A")
    
public static NetworkInterface getByInetAddress(InetAddress address) throws SocketException {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        for (NetworkInterface networkInterface : getNetworkInterfacesList()) {
            if (networkInterface.addresses.contains(address)) {
                return networkInterface;
            }
        }
        return null;
    }

    /**
     * Returns the NetworkInterface corresponding to the given interface index, or null if no
     * interface has this index.
     *
     * @throws SocketException if an error occurs.
     * @hide 1.7
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.662 -0500", hash_original_method = "41AD8406050560C493DEC740B62499BB", hash_generated_method = "F8DC51E5076697007446F2CCEEAE6E70")
    
public static NetworkInterface getByIndex(int index) throws SocketException {
        String name = Libcore.os.if_indextoname(index);
        if (name == null) {
            return null;
        }
        return NetworkInterface.getByName(name);
    }

    /**
     * Gets a list of all network interfaces available on the local system or
     * {@code null} if no interface is available.
     *
     * @return the list of {@code NetworkInterface} instances representing the
     *         available interfaces.
     * @throws SocketException
     *             if an error occurs while getting the network interface
     *             information.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Network interface accessing")
    @DSSpec(DSCat.NETWORK)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.664 -0500", hash_original_method = "5454C5CAD241A70EC9EE91DB383A2F54", hash_generated_method = "0CEDC7EDC80F26805703027D51D30853")
    
public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        return Collections.enumeration(getNetworkInterfacesList());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.668 -0500", hash_original_method = "368E4D7FC14C0E393EC78EE372126951", hash_generated_method = "0A7A8F4B7C59A64D69F6657AA1C0A11D")
    
@FindBugsSuppressWarnings("DMI_HARDCODED_ABSOLUTE_FILENAME")
    private static List<NetworkInterface> getNetworkInterfacesList() throws SocketException {
       /* String[] interfaceNames = new File("/sys/class/net").list();
        NetworkInterface[] interfaces = new NetworkInterface[interfaceNames.length];
        for (int i = 0; i < interfaceNames.length; ++i) {
            interfaces[i] = NetworkInterface.getByName(interfaceNames[i]);
        }

        List<NetworkInterface> result = new ArrayList<NetworkInterface>();
        boolean[] peeked = new boolean[interfaces.length];
        for (int counter = 0; counter < interfaces.length; counter++) {
            // If this interface has been touched, continue.
            if (peeked[counter]) {
                continue;
            }
            int counter2 = counter;
            // Checks whether the following interfaces are children.
            for (; counter2 < interfaces.length; counter2++) {
                if (peeked[counter2]) {
                    continue;
                }
                if (interfaces[counter2].name.startsWith(interfaces[counter].name + ":")) {
                    // Tagged as peeked
                    peeked[counter2] = true;
                    interfaces[counter].children.add(interfaces[counter2]);
                    interfaces[counter2].parent = interfaces[counter];
                    interfaces[counter].addresses.addAll(interfaces[counter2].addresses);
                }
            }
            // Tagged as peeked
            result.add(interfaces[counter]);
            peeked[counter] = true;
        }
        return result;*/
        NetworkInterface[] interfaces = new NetworkInterface[1];
        List<NetworkInterface> infList = new LinkedList<NetworkInterface>();
        for (int i = 0; i < interfaces.length; ++i) {
            infList.add(NetworkInterface.getByName(""));
        }
        return infList;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.605 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.607 -0500", hash_original_field = "29180971715624B09B2612B53242528A", hash_generated_field = "14CCD87ECEE8F75EB85BC22ABB3E01CA")

    private  int interfaceIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.609 -0500", hash_original_field = "C96A789826834ED917015F86F48DEEFA", hash_generated_field = "9DB8B5B1A2500F2D3289DAED15877781")

    private  List<InterfaceAddress> interfaceAddresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.612 -0500", hash_original_field = "8A897B4C669F7A3120F974E307FEFA52", hash_generated_field = "4253A4C32D027B8452C3697AE17C333B")

    private  List<InetAddress> addresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.621 -0500", hash_original_field = "F97426977E2DBE85F0038A7093E54A75", hash_generated_field = "E12F20A3F0C19D49814391AB55DB6473")

    private final List<NetworkInterface> children = new LinkedList<NetworkInterface>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.623 -0500", hash_original_field = "1D5ED4A9B03164F6AE1F7A40A4975221", hash_generated_field = "9E46A9600719B02A7A32211C8211AD2B")

    private NetworkInterface parent = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.626 -0500", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "D6EBA576857B5AB766A8F7312CD20831")
    
private NetworkInterface(String name, int interfaceIndex,
            List<InetAddress> addresses, List<InterfaceAddress> interfaceAddresses) {
        this.name = name;
        this.interfaceIndex = interfaceIndex;
        this.addresses = addresses;
        this.interfaceAddresses = interfaceAddresses;
    }

    /**
     * Returns the index for the network interface, or -1 if unknown.
     *
     * @hide 1.7
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.632 -0500", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "7BA355BCFC6851EF3611E71767DEDEFE")
    
public int getIndex() {
        return interfaceIndex;
    }

    /**
     * Returns the name of this network interface (such as "eth0" or "lo").
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Network interface accessing")
    @DSSpec(DSCat.NETWORK)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.634 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns an enumeration of the addresses bound to this network interface.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Network interface accessing")
    @DSSpec(DSCat.NETWORK)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.636 -0500", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "30C46E758838E31C55A96F50F7CEE90F")
    
public Enumeration<InetAddress> getInetAddresses() {
        return Collections.enumeration(addresses);
    }

    /**
     * Returns a human-readable name for this network interface. On Android, this is the same
     * string as returned by {@link #getName}.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Network interface accessing")
    @DSSpec(DSCat.NETWORK)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.638 -0500", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "338C1CAD35E4DEB5DCEAB0CFAAB84764")
    
public String getDisplayName() {
        return name;
    }

    /**
     * Compares the specified object to this {@code NetworkInterface} and
     * returns whether they are equal or not. The object must be an instance of
     * {@code NetworkInterface} with the same name, display name, and list
     * of interface addresses.
     *
     * @param obj
     *            the object to compare with this instance.
     * @return {@code true} if the specified object is equal to this {@code
     *         NetworkInterface}, {@code false} otherwise.
     * @see #hashCode()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.671 -0500", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "FF0A8CB79DD8B3C4F13D775F020963DE")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkInterface)) {
            return false;
        }
        NetworkInterface rhs = (NetworkInterface) obj;
        // TODO: should the order of the addresses matter (we use List.equals)?
        return interfaceIndex == rhs.interfaceIndex &&
                name.equals(rhs.name) &&
                addresses.equals(rhs.addresses);
    }

    /**
     * Returns the hash code for this {@code NetworkInterface}. Since the
     * name should be unique for each network interface the hash code is
     * generated using the name.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.673 -0500", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "79AB96931D4D2744C8AC02B11E3A7517")
    
@Override public int hashCode() {
        return name.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.676 -0500", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "8FF2C959590BE6135D095A2B4564F839")
    
@Override public String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append("[");
        sb.append(name);
        sb.append("][");
        sb.append(interfaceIndex);
        sb.append("]");
        for (InetAddress address : addresses) {
            sb.append("[");
            sb.append(address.toString());
            sb.append("]");
        }
        return sb.toString();
    }

    /**
     * Returns a List of the InterfaceAddresses for this network interface.
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.678 -0500", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "E524A373F799AAA0A73DBE7C320C18D1")
    
public List<InterfaceAddress> getInterfaceAddresses() {
        return Collections.unmodifiableList(interfaceAddresses);
    }

    /**
     * Returns an enumeration of all the sub-interfaces of this network interface.
     * Sub-interfaces are also known as virtual interfaces.
     *
     * <p>For example, {@code eth0:1} would be a sub-interface of {@code eth0}.
     *
     * @return an Enumeration of all the sub-interfaces of this network interface
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.680 -0500", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "29C145CCCEEF98941035E6551C64ED30")
    
public Enumeration<NetworkInterface> getSubInterfaces() {
        return Collections.enumeration(children);
    }

    /**
     * Returns the parent NetworkInterface of this interface if this is a
     * sub-interface, or null if it's a physical (non virtual) interface.
     *
     * @return the NetworkInterface this interface is attached to.
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.683 -0500", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "AF6C158B0323BC64441ED5AB255DC36A")
    
public NetworkInterface getParent() {
        return parent;
    }

    /**
     * Returns true if this network interface is up.
     *
     * @return true if the interface is up.
     * @throws SocketException if an I/O error occurs.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.685 -0500", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "7CAFE071E3C45BF9679B399A53FBEBDC")
    
public boolean isUp() throws SocketException {
        return hasFlag(IFF_UP);
    }

    /**
     * Returns true if this network interface is a loopback interface.
     *
     * @return true if the interface is a loopback interface.
     * @throws SocketException if an I/O error occurs.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.687 -0500", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "D31B0EF2E9A540230850D4E0F43BB51C")
    
public boolean isLoopback() throws SocketException {
        return hasFlag(IFF_LOOPBACK);
    }

    /**
     * Returns true if this network interface is a point-to-point interface.
     * (For example, a PPP connection using a modem.)
     *
     * @return true if the interface is point-to-point.
     * @throws SocketException if an I/O error occurs.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.690 -0500", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "5B5626C5475713791C9CEDB0AAE28C29")
    
public boolean isPointToPoint() throws SocketException {
        return hasFlag(IFF_POINTOPOINT);
    }

    /**
     * Returns true if this network interface supports multicast.
     *
     * @throws SocketException if an I/O error occurs.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.693 -0500", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "2F24B8EC0376259E0CD0882E936B2C9B")
    
public boolean supportsMulticast() throws SocketException {
        return hasFlag(IFF_MULTICAST);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.695 -0500", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "FF52A0778A379010D3D17A6B111C779E")
    
private boolean hasFlag(int mask) throws SocketException {
        /*int flags = readIntFile("/sys/class/net/" + name + "/flags");
        return (flags & mask) != 0;*/
        return (((mask + getTaintInt())) == 1);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.939 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "03D3756D0CCE283A6BBA95B14F88554B")
    public byte[] getHardwareAddress() throws SocketException {
        byte[] bites = new byte[1];
        bites[0] = (byte)getTaintInt();
        return bites;
        /*try 
        {
            String s = IoUtils.readFileAsString("/sys/class/net/" + name + "/address");
            byte[] result = new byte[s.length()/3];
for(int i = 0;i < result.length;++i)
            {
                result[i] = (byte) Integer.parseInt(s.substring(3*i, 3*i + 2), 16);
            } //End block
for(int i = 0;i < result.length;++i)
            {
    if(result[i] != 0)                
                {
                    byte[] varB4A88417B3D0170D754C647C30B7216A_1103439529 = (result);
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_174632909 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_174632909;
                } //End block
            } //End block
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_283865565 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1335534166 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1335534166;
        } //End block
        catch (Exception ex)
        {
            SocketException var8E41BFA796BE9F8FB9DC270405E20F86_1814482532 = rethrowAsSocketException(ex);
            var8E41BFA796BE9F8FB9DC270405E20F86_1814482532.addTaint(getTaint());
            throw var8E41BFA796BE9F8FB9DC270405E20F86_1814482532;
        } //End block
*/        // ---------- Original Method ----------
        //try {
            //String s = IoUtils.readFileAsString("/sys/class/net/" + name + "/address");
            //byte[] result = new byte[s.length()/3];
            //for (int i = 0; i < result.length; ++i) {
                //result[i] = (byte) Integer.parseInt(s.substring(3*i, 3*i + 2), 16);
            //}
            //for (int i = 0; i < result.length; ++i) {
                //if (result[i] != 0) {
                    //return result;
                //}
            //}
            //return null;
        //} catch (Exception ex) {
            //throw rethrowAsSocketException(ex);
        //}
    }

    /**
     * Returns the Maximum Transmission Unit (MTU) of this interface.
     *
     * @return the value of the MTU for the interface.
     * @throws SocketException if an I/O error occurs.
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.700 -0500", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "D889655AAC62B736100BE7BE6B8BE0AD")
    
public int getMTU() throws SocketException {
        //return readIntFile("/sys/class/net/" + name + "/mtu");
        return getTaintInt();
    }

    /**
     * Returns true if this interface is a virtual interface (also called
     * a sub-interface). Virtual interfaces are, on some systems, interfaces
     * created as a child of a physical interface and given different settings
     * (like address or MTU). Usually the name of the interface will the name of
     * the parent followed by a colon (:) and a number identifying the child,
     * since there can be several virtual interfaces attached to a single
     * physical interface.
     *
     * @return true if this interface is a virtual interface.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:05.703 -0500", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "BD415C56DB1063D2DD40FE801D625259")
    
public boolean isVirtual() {
        //return parent != null;
        return getTaintBoolean();
    }
    
}

