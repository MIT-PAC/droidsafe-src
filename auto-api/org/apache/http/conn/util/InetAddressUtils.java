package org.apache.http.conn.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.regex.Pattern;

public class InetAddressUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.703 -0400", hash_original_method = "E7DF1187E83FF322875E27EB624FDD7F", hash_generated_method = "888B48C74A32AFD9606BF2D2E8E545B4")
    private  InetAddressUtils() {
        // ---------- Original Method ----------
    }

    
        public static boolean isIPv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    
        public static boolean isIPv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    
        public static boolean isIPv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    
        public static boolean isIPv6Address(final String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.707 -0400", hash_original_field = "BFFDA21CEE65836D5CCBAA77B56BE963", hash_generated_field = "FEE35BDC60E779D8B7D74E0183447856")

    private static Pattern IPV4_PATTERN = Pattern.compile(
                "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.707 -0400", hash_original_field = "970DB7F9B43456362B3AB818CFC6F87B", hash_generated_field = "B4404A1B900CCAA0F058E1DA5DA9F517")

    private static Pattern IPV6_STD_PATTERN = Pattern.compile(
                "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.707 -0400", hash_original_field = "DCE3732E6AED0A78EA3B6762343ADCF4", hash_generated_field = "83F17EFCC69B800D34661B22C95F8A07")

    private static Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile(
                "^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
}

