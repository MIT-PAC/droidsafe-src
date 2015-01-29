package org.apache.http.conn.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.regex.Pattern;

public class InetAddressUtils {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.597 -0500", hash_original_method = "DF653F39A4EE510DCB67FF01D9B95AA6", hash_generated_method = "3C58C22B0ECE1BF275BD9A2E9C45E186")
    
public static boolean isIPv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.599 -0500", hash_original_method = "CC49973A351B0E9B4BC563DD7F50F8E2", hash_generated_method = "DB99B2CB8181929C877CF80C0C520080")
    
public static boolean isIPv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.602 -0500", hash_original_method = "467207AC3746C0545B1ED0C1902A46EB", hash_generated_method = "8B7DB0ABD06CB8A2AAD0342CFB15861E")
    
public static boolean isIPv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.604 -0500", hash_original_method = "B811D05406688B0E02AA8A77B84C6B3D", hash_generated_method = "57836C93F1A1C45325F4E29A39BBADA5")
    
public static boolean isIPv6Address(final String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input); 
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.587 -0500", hash_original_field = "B70FFF3D197D06F69CC3D43CB1A86031", hash_generated_field = "D0C9D77FE5A639F9FAA340B00BEFC215")
    
    private static final Pattern IPV4_PATTERN = 
        Pattern.compile(
                "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.590 -0500", hash_original_field = "608C4D6CA8FFCD0D7215F69358EC6EFA", hash_generated_field = "BA6A5C2466D4E519989C288953266743")

    private static final Pattern IPV6_STD_PATTERN = 
        Pattern.compile(
                "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.594 -0500", hash_original_field = "40471935FCD89E251A3B5A9C94D48BBD", hash_generated_field = "EDB2842294B5CD52B4CCBD18E419E3DA")

    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = 
        Pattern.compile(
                "^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:29.584 -0500", hash_original_method = "E7DF1187E83FF322875E27EB624FDD7F", hash_generated_method = "C8B61B33A4339708E005B942B448DBE4")
    
private InetAddressUtils() {
    }
}

