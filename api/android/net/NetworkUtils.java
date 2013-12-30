package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import android.util.Log;




import droidsafe.helpers.DSUtils;

public class NetworkUtils {


    @DSModeled(DSC.SAFE)
    public static int enableInterface(String interfaceName) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119625488 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119625488;
    }

    
    @DSModeled(DSC.SAFE)
    public static int disableInterface(String interfaceName) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319418608 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319418608;
    }

    
    @DSModeled(DSC.SAFE)
    public static int resetConnections(String interfaceName, int mask) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255618748 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255618748;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean runDhcp(String interfaceName, DhcpInfoInternal ipInfo) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243915330 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243915330;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean runDhcpRenew(String interfaceName, DhcpInfoInternal ipInfo) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115115336 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115115336;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean stopDhcp(String interfaceName) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048450172 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048450172;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean releaseDhcpLease(String interfaceName) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70583775 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70583775;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getDhcpError() {
    	return new String();
    }

    /**
     * Convert a IPv4 address from an integer to an InetAddress.
     * @param hostAddress an int corresponding to the IPv4 address in network byte order
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.610 -0500", hash_original_method = "BC6E8B68589B7C543EAC83AF07FC9FE2", hash_generated_method = "0999843FE66D63264190DC8C4B9716DA")
    
public static InetAddress intToInetAddress(int hostAddress) {
        byte[] addressBytes = { (byte)(0xff & hostAddress),
                                (byte)(0xff & (hostAddress >> 8)),
                                (byte)(0xff & (hostAddress >> 16)),
                                (byte)(0xff & (hostAddress >> 24)) };

        try {
           return InetAddress.getByAddress(addressBytes);
        } catch (UnknownHostException e) {
           throw new AssertionError();
        }
    }

    /**
     * Convert a IPv4 address from an InetAddress to an integer
     * @param inetAddr is an InetAddress corresponding to the IPv4 address
     * @return the IP address as an integer in network byte order
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.612 -0500", hash_original_method = "29FE1AB089B612793C16268CF801AE87", hash_generated_method = "C0FD8627D669BC453F0DCE0DC8809499")
    
public static int inetAddressToInt(InetAddress inetAddr)
            throws IllegalArgumentException {
        byte [] addr = inetAddr.getAddress();
        if (addr.length != 4) {
            throw new IllegalArgumentException("Not an IPv4 address");
        }
        return ((addr[3] & 0xff) << 24) | ((addr[2] & 0xff) << 16) |
                ((addr[1] & 0xff) << 8) | (addr[0] & 0xff);
    }

    /**
     * Convert a network prefix length to an IPv4 netmask integer
     * @param prefixLength
     * @return the IPv4 netmask as an integer in network byte order
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.614 -0500", hash_original_method = "5FB2AC2DAB8927FC79F4C27D714B8493", hash_generated_method = "B6B7B84B337EEC41B6A7400A1AB00FA3")
    
public static int prefixLengthToNetmaskInt(int prefixLength)
            throws IllegalArgumentException {
        if (prefixLength < 0 || prefixLength > 32) {
            throw new IllegalArgumentException("Invalid prefix length (0 <= prefix <= 32)");
        }
        int value = 0xffffffff << (32 - prefixLength);
        return Integer.reverseBytes(value);
    }

    /**
     * Convert a IPv4 netmask integer to a prefix length
     * @param netmask as an integer in network byte order
     * @return the network prefix length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.616 -0500", hash_original_method = "F5BF0DDF083843E14FDE0C117BAE250E", hash_generated_method = "E1C3BB6772CE07721D8608A1E4D81EE1")
    
public static int netmaskIntToPrefixLength(int netmask) {
        return Integer.bitCount(netmask);
    }

    /**
     * Create an InetAddress from a string where the string must be a standard
     * representation of a V4 or V6 address.  Avoids doing a DNS lookup on failure
     * but it will throw an IllegalArgumentException in that case.
     * @param addrString
     * @return the InetAddress
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.619 -0500", hash_original_method = "B42BAA7CA831052E65FB5E10D3C90FD1", hash_generated_method = "0CD4E585E4DC666D5D0957FDE81F8DF0")
    
public static InetAddress numericToInetAddress(String addrString)
            throws IllegalArgumentException {
        return InetAddress.parseNumericAddress(addrString);
    }

    /**
     * Get InetAddress masked with prefixLength.  Will never return null.
     * @param IP address which will be masked with specified prefixLength
     * @param prefixLength the prefixLength used to mask the IP
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.622 -0500", hash_original_method = "65C7A9BF428499CDC3CDD8BE5BFA9B7C", hash_generated_method = "95520860E69A928A2FA7A3D43EA79CF1")
    
public static InetAddress getNetworkPart(InetAddress address, int prefixLength) {
        if (address == null) {
            throw new RuntimeException("getNetworkPart doesn't accept null address");
        }

        byte[] array = address.getAddress();

        if (prefixLength < 0 || prefixLength > array.length * 8) {
            throw new RuntimeException("getNetworkPart - bad prefixLength");
        }

        int offset = prefixLength / 8;
        int reminder = prefixLength % 8;
        byte mask = (byte)(0xFF << (8 - reminder));

        if (offset < array.length) array[offset] = (byte)(array[offset] & mask);

        offset++;

        for (; offset < array.length; offset++) {
            array[offset] = 0;
        }

        InetAddress netPart = null;
        try {
            netPart = InetAddress.getByAddress(array);
        } catch (UnknownHostException e) {
            throw new RuntimeException("getNetworkPart error - " + e.toString());
        }
        return netPart;
    }

    /**
     * Check if IP address type is consistent between two InetAddress.
     * @return true if both are the same type.  False otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.624 -0500", hash_original_method = "6C2592B3CD6F53864B4519754098E028", hash_generated_method = "FE5DDA1B1C9BF428E2686AE2FB35F724")
    
public static boolean addressTypeMatches(InetAddress left, InetAddress right) {
        return (((left instanceof Inet4Address) && (right instanceof Inet4Address)) ||
                ((left instanceof Inet6Address) && (right instanceof Inet6Address)));
    }

    /**
     * Convert a 32 char hex string into a Inet6Address.
     * throws a runtime exception if the string isn't 32 chars, isn't hex or can't be
     * made into an Inet6Address
     * @param addrHexString a 32 character hex string representing an IPv6 addr
     * @return addr an InetAddress representation for the string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.627 -0500", hash_original_method = "40C6B3C0AD37CA3D6312A539EC9021CF", hash_generated_method = "5A9FD878E1A9A54582C4F8A0679BB7D8")
    
public static InetAddress hexToInet6Address(String addrHexString)
            throws IllegalArgumentException {
        try {
            return numericToInetAddress(String.format("%s:%s:%s:%s:%s:%s:%s:%s",
                    addrHexString.substring(0,4),   addrHexString.substring(4,8),
                    addrHexString.substring(8,12),  addrHexString.substring(12,16),
                    addrHexString.substring(16,20), addrHexString.substring(20,24),
                    addrHexString.substring(24,28), addrHexString.substring(28,32)));
        } catch (Exception e) {
            Log.e("NetworkUtils", "error in hexToInet6Address(" + addrHexString + "): " + e);
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Create a string array of host addresses from a collection of InetAddresses
     * @param addrs a Collection of InetAddresses
     * @return an array of Strings containing their host addresses
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.630 -0500", hash_original_method = "90CCF6EED6ECF06B8A0ACB9E5CF21EA6", hash_generated_method = "FD471B1E125744525FF1C71DCA18C5CB")
    
public static String[] makeStrings(Collection<InetAddress> addrs) {
        String[] result = new String[addrs.size()];
        int i = 0;
        for (InetAddress addr : addrs) {
            result[i++] = addr.getHostAddress();
        }
        return result;
    }

    /**
     * Trim leading zeros from IPv4 address strings
     * Our base libraries will interpret that as octel..
     * Must leave non v4 addresses and host names alone.
     * For example, 192.168.000.010 -> 192.168.0.10
     * TODO - fix base libraries and remove this function
     * @param addr a string representing an ip addr
     * @return a string propertly trimmed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.633 -0500", hash_original_method = "1AF6724BA85578FFBC777CD5B6E926DF", hash_generated_method = "72E8E1C7369662580FDD8179D7091D4B")
    
public static String trimV4AddrZeros(String addr) {
        if (addr == null) return null;
        String[] octets = addr.split("\\.");
        if (octets.length != 4) return addr;
        StringBuilder builder = new StringBuilder(16);
        String result = null;
        for (int i = 0; i < 4; i++) {
            try {
                if (octets[i].length() > 3) return addr;
                builder.append(Integer.parseInt(octets[i]));
            } catch (NumberFormatException e) {
                return addr;
            }
            if (i < 3) builder.append('.');
        }
        result = builder.toString();
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.569 -0500", hash_original_field = "8BDDD5DB6E447C5F0F3AC195BF790C52", hash_generated_field = "1105638891056CB5B9AE23205F9644BD")


    private static final String TAG = "NetworkUtils";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.580 -0500", hash_original_field = "AF5A4C356BA68EF6DCCBB0AB7A9A8046", hash_generated_field = "8527B95E11967191DF76627972EC8F1C")

    public static final int RESET_IPV4_ADDRESSES = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.583 -0500", hash_original_field = "614F89582BC20DA429A500DA113A320D", hash_generated_field = "EEC5561B124BB21A0A9EE1CFD725F6EF")

    public static final int RESET_IPV6_ADDRESSES = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.585 -0500", hash_original_field = "6894F8CA0BD49308B017A1268F5725E9", hash_generated_field = "658E35BA939EA603B8ACD3CD0142AFF1")

    public static final int RESET_ALL_ADDRESSES = RESET_IPV4_ADDRESSES | RESET_IPV6_ADDRESSES;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.046 -0400", hash_original_method = "F1C492907C316113D8B010C69392B76F", hash_generated_method = "F1C492907C316113D8B010C69392B76F")
    public NetworkUtils ()
    {
        //Synthesized constructor
    }
}

