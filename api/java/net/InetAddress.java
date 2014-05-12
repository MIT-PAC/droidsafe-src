package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET;
import static libcore.io.OsConstants.AF_UNSPEC;
import static libcore.io.OsConstants.AI_ADDRCONFIG;
import static libcore.io.OsConstants.AI_NUMERICHOST;
import static libcore.io.OsConstants.ECONNREFUSED;
import static libcore.io.OsConstants.NI_NAMEREQD;
import static libcore.io.OsConstants.NI_NUMERICHOST;
import static libcore.io.OsConstants.SOCK_STREAM;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import libcore.io.ErrnoException;
import libcore.io.GaiException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.StructAddrinfo;
import dalvik.system.BlockGuard;

public class InetAddress implements Serializable {

    /**
     * Converts an array of byte arrays representing raw IP addresses of a host
     * to an array of InetAddress objects.
     *
     * @param rawAddresses the raw addresses to convert.
     * @param hostName the hostname corresponding to the IP address.
     * @return the corresponding InetAddresses, appropriately sorted.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.217 -0500", hash_original_method = "C098D3724E09EEC45853C7E5DAED7824", hash_generated_method = "C6B35AE2FA29E9467645051E8EE6EECF")
    
private static InetAddress[] bytesToInetAddresses(byte[][] rawAddresses, String hostName)
            throws UnknownHostException {
        // Convert the byte arrays to InetAddresses.
        InetAddress[] returnedAddresses = new InetAddress[rawAddresses.length];
        for (int i = 0; i < rawAddresses.length; i++) {
            returnedAddresses[i] = makeInetAddress(rawAddresses[i], hostName);
        }
        return returnedAddresses;
    }

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
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.221 -0500", hash_original_method = "FB551EC28630FE6F0C2EF7814F81623E", hash_generated_method = "ACE15F490E4BD0A3B86FEF53D4EFC7AC")
    
public static InetAddress[] getAllByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host).clone();
    }

    /**
     * Returns the InetAddresses for {@code host}. The returned array is shared
     * and must be cloned before it is returned to application code.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.223 -0500", hash_original_method = "246D92EAF0F98E04427CC0512E8DD56F", hash_generated_method = "B8D2624A0D74BA243001C4FC7E42FD18")
    
private static InetAddress[] getAllByNameImpl(String host) throws UnknownHostException {
        if (host == null || host.isEmpty()) {
            return loopbackAddresses();
        }

        // Is it a numeric address?
        InetAddress result = parseNumericAddressNoThrow(host);
        if (result != null) {
            result = disallowDeprecatedFormats(host, result);
            if (result == null) {
                throw new UnknownHostException("Deprecated IPv4 address format: " + host);
            }
            return new InetAddress[] { result };
        }

        return lookupHostByName(host).clone();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.226 -0500", hash_original_method = "CB8F6EAC24B3C3F95717D807E1D14C33", hash_generated_method = "FBE29A04B92154FCDCE4BABDD598B24E")
    
private static InetAddress makeInetAddress(byte[] bytes, String hostName) throws UnknownHostException {
        if (bytes.length == 4) {
            return new Inet4Address(bytes, hostName);
        } else if (bytes.length == 16) {
            return new Inet6Address(bytes, hostName, 0);
        } else {
            throw badAddressLength(bytes);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.230 -0500", hash_original_method = "7257BB04AFE16B3CCE24EF2723A03805", hash_generated_method = "5D891E9367533A1DC52C8213611309BD")
    
private static InetAddress disallowDeprecatedFormats(String address, InetAddress inetAddress) {
        // Only IPv4 addresses are problematic.
        if (!(inetAddress instanceof Inet4Address) || address.indexOf(':') != -1) {
            return inetAddress;
        }
        // If inet_pton(3) can't parse it, it must have been a deprecated format.
        // We need to return inet_pton(3)'s result to ensure that numbers assumed to be octal
        // by getaddrinfo(3) are reinterpreted by inet_pton(3) as decimal.
        return Libcore.os.inet_pton(AF_INET, address);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.233 -0500", hash_original_method = "13D428EED9E34243733FECE30A32A88B", hash_generated_method = "699B2C4562AA4A7C273787E9923B81EC")
    
private static InetAddress parseNumericAddressNoThrow(String address) {
        // Accept IPv6 addresses (only) in square brackets for compatibility.
        if (address.startsWith("[") && address.endsWith("]") && address.indexOf(':') != -1) {
            address = address.substring(1, address.length() - 1);
        }
        StructAddrinfo hints = new StructAddrinfo();
        hints.ai_flags = AI_NUMERICHOST;
        InetAddress[] addresses = null;
        try {
            addresses = Libcore.os.getaddrinfo(address, hints);
        } catch (GaiException ignored) {
        }
        return (addresses != null) ? addresses[0] : null;
    }

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
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.235 -0500", hash_original_method = "DD1533442534100575D70C182ADE1C96", hash_generated_method = "042C59E72021E1834F301CC5C89036C8")
    
public static InetAddress getByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host)[0];
    }

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
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.245 -0500", hash_original_method = "E79319E7983FFD892480819C6E838DC2", hash_generated_method = "42A32443A0500AD60A3EF761DA43EF92")
    
public static InetAddress getLocalHost() throws UnknownHostException {
        String host = Libcore.os.uname().nodename;
        return lookupHostByName(host)[0];
    }

    /**
     * Resolves a hostname to its IP addresses using a cache.
     *
     * @param host the hostname to resolve.
     * @return the IP addresses of the host.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.252 -0500", hash_original_method = "9A18BDA9B7320ADFBD057B8A639BF335", hash_generated_method = "C7C17F28CB7AE80D1B93EFAD44AA3AD8")
    
private static InetAddress[] lookupHostByName(String host) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        // Do we have a result cached?
        Object cachedResult = addressCache.get(host);
        if (cachedResult != null) {
            if (cachedResult instanceof InetAddress[]) {
                // A cached positive result.
                return (InetAddress[]) cachedResult;
            } else {
                // A cached negative result.
                throw new UnknownHostException((String) cachedResult);
            }
        }
        try {
            StructAddrinfo hints = new StructAddrinfo();
            hints.ai_flags = AI_ADDRCONFIG;
            hints.ai_family = AF_UNSPEC;
            // If we don't specify a socket type, every address will appear twice, once
            // for SOCK_STREAM and one for SOCK_DGRAM. Since we do not return the family
            // anyway, just pick one.
            hints.ai_socktype = SOCK_STREAM;
            InetAddress[] addresses = Libcore.os.getaddrinfo(host, hints);
            // TODO: should getaddrinfo set the hostname of the InetAddresses it returns?
            for (InetAddress address : addresses) {
                address.hostName = host;
            }
            addressCache.put(host, addresses);
            return addresses;
        } catch (GaiException gaiException) {
            // TODO: bionic currently returns EAI_NODATA, which is indistinguishable from a real
            // failure. We need to fix bionic before we can report a more useful error.
            // if (gaiException.error == EAI_SYSTEM) {
            //    throw new SecurityException("Permission denied (missing INTERNET permission?)");
            // }
            String detailMessage = "Unable to resolve host \"" + host + "\": " + Libcore.os.gai_strerror(gaiException.error);
            addressCache.putUnknownHost(host, detailMessage);
            throw gaiException.rethrowAsUnknownHostException(detailMessage);
        }
    }

    /**
     * Removes all entries from the VM's DNS cache. This does not affect the C library's DNS
     * cache, nor any caching DNS servers between you and the canonical server.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.254 -0500", hash_original_method = "10AA1BA0464BE4692583736E1FB9D6CA", hash_generated_method = "A3387316C83FBF149BB8EE16153566EB")
    
public static void clearDnsCache() {
        addressCache.clear();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.256 -0500", hash_original_method = "52AE02939059AD17567A159306895CC4", hash_generated_method = "FAB60AFCEE7C37B239B874D1CAF9F245")
    
private static InetAddress getHostByAddrImpl(InetAddress address) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        try {
            String hostname = Libcore.os.getnameinfo(address, NI_NAMEREQD);
            return makeInetAddress(address.ipaddress.clone(), hostname);
        } catch (GaiException gaiException) {
            throw gaiException.rethrowAsUnknownHostException();
        }
    }

    /**
     * Returns true if the string is a valid numeric IPv4 or IPv6 address (such as "192.168.0.1").
     * This copes with all forms of address that Java supports, detailed in the {@link InetAddress}
     * class documentation.
     *
     * @hide used by frameworks/base to ensure that a getAllByName won't cause a DNS lookup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.261 -0500", hash_original_method = "AB06389E4D3099E4980AF28625DCA9DF", hash_generated_method = "DEF063CE0317DDDAF52DF39E0A608218")
    
public static boolean isNumeric(String address) {
        InetAddress inetAddress = parseNumericAddressNoThrow(address);
        return inetAddress != null && disallowDeprecatedFormats(address, inetAddress) != null;
    }

    /**
     * Returns an InetAddress corresponding to the given numeric address (such
     * as {@code "192.168.0.1"} or {@code "2001:4860:800d::68"}).
     * This method will never do a DNS lookup. Non-numeric addresses are errors.
     *
     * @hide used by frameworks/base's NetworkUtils.numericToInetAddress
     * @throws IllegalArgumentException if {@code numericAddress} is not a numeric address
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.264 -0500", hash_original_method = "9B702BA41E49A0B2D54CFA8AA4B75EEF", hash_generated_method = "C13DCB4F953031846E02483ABE8CCBC4")
    
public static InetAddress parseNumericAddress(String numericAddress) {
        if (numericAddress == null || numericAddress.isEmpty()) {
            return Inet6Address.LOOPBACK;
        }
        InetAddress result = parseNumericAddressNoThrow(numericAddress);
        result = disallowDeprecatedFormats(numericAddress, result);
        if (result == null) {
            throw new IllegalArgumentException("Not a numeric address: " + numericAddress);
        }
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.267 -0500", hash_original_method = "89B71749F6D1ED2E70A746BF0E6C21BC", hash_generated_method = "720D5C7EF54D55F3A03C431CCB43DEB2")
    
private static InetAddress[] loopbackAddresses() {
        return new InetAddress[] { Inet6Address.LOOPBACK, Inet4Address.LOOPBACK };
    }

    /**
     * Returns the IPv6 loopback address {@code ::1} or the IPv4 loopback address {@code 127.0.0.1}.
     * @since 1.7
     * @hide 1.7
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.269 -0500", hash_original_method = "7F38E98A384441E9C595E5B09E3332A9", hash_generated_method = "2684BAE775A83394D81BEA27B9D16514")
    
public static InetAddress getLoopbackAddress() {
        return Inet6Address.LOOPBACK;
    }

    /**
     * Equivalent to {@code getByAddress(null, ipAddress)}. Handy for addresses with
     * no associated hostname.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.307 -0500", hash_original_method = "62A7C11189E68648BE032AAAC357AEAD", hash_generated_method = "6640896F14B26720B73658FB0E72D38B")
    
public static InetAddress getByAddress(byte[] ipAddress) throws UnknownHostException {
        return getByAddress(null, ipAddress, 0);
    }

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
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.309 -0500", hash_original_method = "AB1313B483280B6D95EFD60881636E2E", hash_generated_method = "B1DCEB660FD15C7469EB114D8BBE6FC4")
    
public static InetAddress getByAddress(String hostName, byte[] ipAddress) throws UnknownHostException {
        return getByAddress(hostName, ipAddress, 0);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.312 -0500", hash_original_method = "92BD61B54A32FD10D3456FBE907A2602", hash_generated_method = "7DF91EF802DBF81C0EFB976DEC45B6D1")
    
private static InetAddress getByAddress(String hostName, byte[] ipAddress, int scopeId) throws UnknownHostException {
        if (ipAddress == null) {
            throw new UnknownHostException("ipAddress == null");
        }
        if (ipAddress.length == 4) {
            return new Inet4Address(ipAddress.clone(), hostName);
        } else if (ipAddress.length == 16) {
            // First check to see if the address is an IPv6-mapped
            // IPv4 address. If it is, then we can make it a IPv4
            // address, otherwise, we'll create an IPv6 address.
            if (isIPv4MappedAddress(ipAddress)) {
                return new Inet4Address(ipv4MappedToIPv4(ipAddress), hostName);
            } else {
                return new Inet6Address(ipAddress.clone(), hostName, scopeId);
            }
        } else {
            throw badAddressLength(ipAddress);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.315 -0500", hash_original_method = "816D2EFAAEB973A2F6F408B300A22DDF", hash_generated_method = "6765381FFF68B17C9B4D8BFF63CC0A6A")
    
private static UnknownHostException badAddressLength(byte[] bytes) throws UnknownHostException {
        throw new UnknownHostException("Address is neither 4 or 16 bytes: " + Arrays.toString(bytes));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.317 -0500", hash_original_method = "976F5692DBFDF51A2ADCA4E3FA07B136", hash_generated_method = "EE241AABD532AD61C0482DFB82156C56")
    
private static boolean isIPv4MappedAddress(byte[] ipAddress) {
        // Check if the address matches ::FFFF:d.d.d.d
        // The first 10 bytes are 0. The next to are -1 (FF).
        // The last 4 bytes are varied.
        if (ipAddress == null || ipAddress.length != 16) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (ipAddress[i] != 0) {
                return false;
            }
        }
        if (ipAddress[10] != -1 || ipAddress[11] != -1) {
            return false;
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.321 -0500", hash_original_method = "76C3DB48DD3809B5557BF6F40359BC2C", hash_generated_method = "61CAD9059146DB1956372921747CDB86")
    
private static byte[] ipv4MappedToIPv4(byte[] mappedAddress) {
        byte[] ipv4Address = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipv4Address[i] = mappedAddress[12 + i];
        }
        return ipv4Address;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.195 -0500", hash_original_field = "9561D711FC7CE7C028D8485B0507E63B", hash_generated_field = "B26AF2805292D25D065DC27D7F380542")

    private static final AddressCache addressCache = new AddressCache();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.198 -0500", hash_original_field = "C90A358F9020B90EC2F318C027EBE50C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.208 -0500", hash_original_field = "848C801A8B22D5A47B6F2AACCDFAF7C4", hash_generated_field = "119C92FDA430C8C47E72137BCDA943A4")

    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.323 -0500", hash_original_field = "9BC29E296D6746AF176C53F70F3E06D8", hash_generated_field = "550C29BECD712FE70617B34B15180466")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.200 -0500", hash_original_field = "C09CA1CD37DDEDAAB2023089C696B143", hash_generated_field = "630495C0099FA460C912B67A0FCAD3C7")

    private int family;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.203 -0500", hash_original_field = "90EA25AB4D338372155DC6F7EC59D04E", hash_generated_field = "90EA25AB4D338372155DC6F7EC59D04E")

    byte[] ipaddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.205 -0500", hash_original_field = "1B7A53B08CE768344D84B69A12503624", hash_generated_field = "1B7A53B08CE768344D84B69A12503624")

    @DSVAModeled
    String hostName;

    /**
     * Constructs an {@code InetAddress}.
     *
     * Note: this constructor is for subclasses only.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.211 -0500", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "D743789B4770A2F65AD981CCEDC5E9F2")
    
InetAddress(int family, byte[] ipaddress, String hostName) {
        this.family = family;
        this.ipaddress = ipaddress;
        this.hostName = hostName;
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
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.213 -0500", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "D103773655A1C519BA125A1827E9D90D")
    
@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InetAddress)) {
            return false;
        }
        return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
    }

    /**
     * Returns the IP address represented by this {@code InetAddress} instance
     * as a byte array. The elements are in network order (the highest order
     * address byte is in the zeroth element).
     *
     * @return the address in form of a byte array.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.215 -0500", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "E4CE6EB2E4BD87D82969FEB5079B693F")
    
public byte[] getAddress() {
        return ipaddress.clone();
    }

    /**
     * Returns the numeric representation of this IP address (such as "127.0.0.1").
     */
    @DSComment("Data structure only")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.237 -0500", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "ADD427568CF99A3804F95D4B04F03648")
    
public String getHostAddress() {
        return Libcore.os.getnameinfo(this, NI_NUMERICHOST); // Can't throw.
    }

    /**
     * Returns the host name corresponding to this IP address. This may or may not be a
     * fully-qualified name. If the IP address could not be resolved, the numeric representation
     * is returned instead (see {@link #getHostAddress}).
     */
    @DSComment("Data structure only")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.240 -0500", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "80EA9719894A32DCFA351AE0D9464A70")
    
public String getHostName() {
        if (hostName == null) {
            try {
                hostName = getHostByAddrImpl(this).hostName;
            } catch (UnknownHostException ex) {
                hostName = getHostAddress();
            }
        }
        return hostName;
    }

    /**
     * Returns the fully qualified hostname corresponding to this IP address.
     */
    @DSComment("Data structure only")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.242 -0500", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "F3D2F0697947A3C6FDC2EB20AA874985")
    
public String getCanonicalHostName() {
        try {
            return getHostByAddrImpl(this).hostName;
        } catch (UnknownHostException ex) {
            return getHostAddress();
        }
    }

    /**
     * Gets the hashcode of the represented IP address.
     *
     * @return the appropriate hashcode value.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.248 -0500", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "433764DDD4E9EAA1E0D1F44F5A4A6BD2")
    
@Override
    public int hashCode() {
        return Arrays.hashCode(ipaddress);
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * IP address.
     *
     * @return the description, as host/address.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSComment("Data structure only")
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.259 -0500", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "BB4B7DC306DE02D48C444870FADF73B1")
    
@Override
    public String toString() {
        return (hostName == null ? "" : hostName) + "/" + getHostAddress();
    }

    /**
     * Returns whether this is the IPv6 unspecified wildcard address {@code ::}
     * or the IPv4 "any" address, {@code 0.0.0.0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.272 -0500", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "228E1761E1CC2FB903683AB5BB9B9E3D")
    
public boolean isAnyLocalAddress() {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.274 -0500", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "BF2B074E7C8F2B4F762FA7848208999A")
    
public boolean isLinkLocalAddress() {
        return false;
    }

    /**
     * Returns whether this address is a loopback address or not.
     *
     * <p>Valid IPv4 loopback addresses have the prefix {@code 127/8}.
     *
     * <p>The only valid IPv6 loopback address is {@code ::1}.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.276 -0500", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "97876E1C76DBC2E80931734755B0C9C6")
    
public boolean isLoopbackAddress() {
        return false;
    }

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.279 -0500", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "F80F80203F06062E9276E74BA2A02D49")
    
public boolean isMCGlobal() {
        return false;
    }

    /**
     * Returns whether this address is a link-local multicast address or not.
     *
     * <p>Valid IPv6 link-local multicast addresses have the prefix {@code ffx2::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>Valid IPv4 link-local multicast addresses have the prefix {@code 224.0.0/24}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.280 -0500", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "699226C71CB982299D5AF22BAE500A4A")
    
public boolean isMCLinkLocal() {
        return false;
    }

    /**
     * Returns whether this address is a node-local multicast address or not.
     *
     * <p>Valid IPv6 node-local multicast addresses have the prefix {@code ffx1::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>There are no valid IPv4 node-local multicast addresses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.283 -0500", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "D497FD6E7012BDB31D9F97430422034D")
    
public boolean isMCNodeLocal() {
        return false;
    }

    /**
     * Returns whether this address is a organization-local multicast address or not.
     *
     * <p>Valid IPv6 organization-local multicast addresses have the prefix {@code ffx8::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>Valid IPv4 organization-local multicast addresses have the prefix {@code 239.192/14}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.285 -0500", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "7B0FAB9159E6959FAD9295DA23FAD4D0")
    
public boolean isMCOrgLocal() {
        return false;
    }

    /**
     * Returns whether this address is a site-local multicast address or not.
     *
     * <p>Valid IPv6 site-local multicast addresses have the prefix {@code ffx5::/16},
     * where x is a set of flags and the additional 112 bits make up the link-local multicast
     * address space.
     *
     * <p>Valid IPv4 site-local multicast addresses have the prefix {@code 239.255/16}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.287 -0500", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "42D3E72CF84B77337888FA9C64EA1126")
    
public boolean isMCSiteLocal() {
        return false;
    }

    /**
     * Returns whether this address is a multicast address or not.
     *
     * <p>Valid IPv6 multicast addresses have the prefix {@code ff::/8}.
     *
     * <p>Valid IPv4 multicast addresses have the prefix {@code 224/4}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.290 -0500", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "29681622669ACED8F568710EB579D322")
    
public boolean isMulticastAddress() {
        return false;
    }

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.292 -0500", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "ED755D60CE8BBFF36FF7D70BBC24BF90")
    
public boolean isSiteLocalAddress() {
        return false;
    }

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
    @DSComment("Data structure only")
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.294 -0500", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "D9B0F0A17C132723F6CC895BD9C5B09E")
    
public boolean isReachable(int timeout) throws IOException {
        return isReachable(null, 0, timeout);
    }
    
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.773 -0400", hash_original_method = "A1A0F0207714140D12E9E4AE2187615D", hash_generated_method = "DA703A9943F73B00CF0C811D2AFDC4FE")
    public boolean isReachable(NetworkInterface networkInterface, final int ttl, final int timeout) throws IOException {
        addTaint(timeout);
        addTaint(ttl);
        addTaint(networkInterface.getTaint());
    if(ttl < 0 || timeout < 0)        
        {
            IllegalArgumentException var40D35409B98F9E8BB904703A1693CF05_433979614 = new IllegalArgumentException("ttl < 0 || timeout < 0");
            var40D35409B98F9E8BB904703A1693CF05_433979614.addTaint(getTaint());
            throw var40D35409B98F9E8BB904703A1693CF05_433979614;
        } //End block
    if(networkInterface == null)        
        {
            boolean varB86BAA1C1B0CF97B2EBB38AFE10F09AD_1138132022 = (isReachable(this, null, timeout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221267299 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221267299;
        } //End block
        List<InetAddress> sourceAddresses = Collections.list(networkInterface.getInetAddresses());
    if(sourceAddresses.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_981190091 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061619282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061619282;
        } //End block
        final InetAddress destinationAddress = this;
        final CountDownLatch latch = new CountDownLatch(sourceAddresses.size());
        final AtomicBoolean isReachable = new AtomicBoolean(false);
for(final InetAddress sourceAddress : sourceAddresses)
        {
            new Thread() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.299 -0500", hash_original_method = "B701C9C990A30C345CD440F261C9D387", hash_generated_method = "D70307131641C58A9098C363244976E7")
                
@Override public void run() {
                    try {
                        if (isReachable(destinationAddress, sourceAddress, timeout)) {
                            isReachable.set(true);
                            // Wake the main thread so it can return success without
                            // waiting for any other threads to time out.
                            while (latch.getCount() > 0) {
                                latch.countDown();
                            }
                        }
                    } catch (IOException ignored) {
                    }
                    latch.countDown();
                }
}.start();
        } //End block
        try 
        {
            latch.await();
        } //End block
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        } //End block
        boolean varDB618C60CB26BA9BBAD361D92C0E612B_243901591 = (isReachable.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713818910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713818910;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("Private Method")
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.305 -0500", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "66D56AEF1B5710B77AD7862267AA381D")
    
private boolean isReachable(InetAddress destination, InetAddress source, int timeout) throws IOException {
        // TODO: try ICMP first (http://code.google.com/p/android/issues/detail?id=20106)
        FileDescriptor fd = IoBridge.socket(true);
        boolean reached = false;
        try {
            if (source != null) {
                IoBridge.bind(fd, source, 0);
            }
            IoBridge.connect(fd, destination, 7, timeout);
            reached = true;
        } catch (IOException e) {
            if (e.getCause() instanceof ErrnoException) {
                // "Connection refused" means the IP address was reachable.
                reached = (((ErrnoException) e.getCause()).errno == ECONNREFUSED);
            }
        }

        IoBridge.closeSocket(fd);

        return reached;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.326 -0500", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "5C57A1D1CAB63432A118D1D074C07BA0")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        if (ipaddress == null) {
            fields.put("address", 0);
        } else {
            fields.put("address", Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN));
        }
        fields.put("family", family);
        fields.put("hostName", hostName);

        stream.writeFields();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.328 -0500", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "2EC13D04E1E401E6F26FA5CA585A0EA9")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        int addr = fields.get("address", 0);
        ipaddress = new byte[4];
        Memory.pokeInt(ipaddress, 0, addr, ByteOrder.BIG_ENDIAN);
        hostName = (String) fields.get("hostName", null);
        family = fields.get("family", 2);
    }

    /*
     * The spec requires that if we encounter a generic InetAddress in
     * serialized form then we should interpret it as an Inet4Address.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.331 -0500", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "CD0E3E4CC1216AEAA55C0790F30B74C9")
    
private Object readResolve() throws ObjectStreamException {
        return new Inet4Address(ipaddress, hostName);
    }
}

