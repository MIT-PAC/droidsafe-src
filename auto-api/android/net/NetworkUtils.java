package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.Collection;
import android.util.Log;

public class NetworkUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.548 -0400", hash_original_method = "F1C492907C316113D8B010C69392B76F", hash_generated_method = "F1C492907C316113D8B010C69392B76F")
    public NetworkUtils ()
    {
        //Synthesized constructor
    }


        public static int enableInterface(String interfaceName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int disableInterface(String interfaceName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int resetConnections(String interfaceName, int mask) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static boolean runDhcp(String interfaceName, DhcpInfoInternal ipInfo) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean runDhcpRenew(String interfaceName, DhcpInfoInternal ipInfo) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean stopDhcp(String interfaceName) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean releaseDhcpLease(String interfaceName) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static String getDhcpError() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
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

    
        public static int inetAddressToInt(InetAddress inetAddr) throws IllegalArgumentException {
        byte [] addr = inetAddr.getAddress();
        if (addr.length != 4) {
            throw new IllegalArgumentException("Not an IPv4 address");
        }
        return ((addr[3] & 0xff) << 24) | ((addr[2] & 0xff) << 16) |
                ((addr[1] & 0xff) << 8) | (addr[0] & 0xff);
    }

    
        public static int prefixLengthToNetmaskInt(int prefixLength) throws IllegalArgumentException {
        if (prefixLength < 0 || prefixLength > 32) {
            throw new IllegalArgumentException("Invalid prefix length (0 <= prefix <= 32)");
        }
        int value = 0xffffffff << (32 - prefixLength);
        return Integer.reverseBytes(value);
    }

    
        public static int netmaskIntToPrefixLength(int netmask) {
        return Integer.bitCount(netmask);
    }

    
        public static InetAddress numericToInetAddress(String addrString) throws IllegalArgumentException {
        return InetAddress.parseNumericAddress(addrString);
    }

    
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

    
        public static boolean addressTypeMatches(InetAddress left, InetAddress right) {
        return (((left instanceof Inet4Address) && (right instanceof Inet4Address)) ||
                ((left instanceof Inet6Address) && (right instanceof Inet6Address)));
    }

    
        public static InetAddress hexToInet6Address(String addrHexString) throws IllegalArgumentException {
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

    
        public static String[] makeStrings(Collection<InetAddress> addrs) {
        String[] result = new String[addrs.size()];
        int i = 0;
        for (InetAddress addr : addrs) {
            result[i++] = addr.getHostAddress();
        }
        return result;
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.572 -0400", hash_original_field = "EFD2DD51969EAC667D6C714A3D10B805", hash_generated_field = "A54E2C5A3DF486072264FCC4278FF8ED")

    private static String TAG = "NetworkUtils";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.572 -0400", hash_original_field = "18B1CA92461CE22E7B205EC8EE808BF5", hash_generated_field = "8527B95E11967191DF76627972EC8F1C")

    public static final int RESET_IPV4_ADDRESSES = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.572 -0400", hash_original_field = "AAE4005003B639A4069F3999D66E8066", hash_generated_field = "EEC5561B124BB21A0A9EE1CFD725F6EF")

    public static final int RESET_IPV6_ADDRESSES = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.572 -0400", hash_original_field = "04DACDA903C1AF2936B97BED81ED3BA0", hash_generated_field = "658E35BA939EA603B8ACD3CD0142AFF1")

    public static final int RESET_ALL_ADDRESSES = RESET_IPV4_ADDRESSES | RESET_IPV6_ADDRESSES;
}

