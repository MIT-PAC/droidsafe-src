package libcore.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;

public abstract class UriCodec {

    /**
     * Throws if {@code s} contains characters that are not letters, digits or
     * in {@code legal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.378 -0500", hash_original_method = "181D72A2209D840D07CA2C50875CB8AF", hash_generated_method = "6F629466D5256ED64F28F46143E8DD76")
    
public static void validateSimple(String s, String legal)
            throws URISyntaxException {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9')
                    || legal.indexOf(ch) > -1)) {
                throw new URISyntaxException(s, "Illegal character", i);
            }
        }
    }

    /**
     * @param convertPlus true to convert '+' to ' '.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.392 -0500", hash_original_method = "D42ED385C72D36F3791E3A3CA5AE2B50", hash_generated_method = "36D21E6226432C2E78E2377B0E9583DB")
    
public static String decode(String s, boolean convertPlus, Charset charset) {
        if (s.indexOf('%') == -1 && (!convertPlus || s.indexOf('+') == -1)) {
            return s;
        }

        StringBuilder result = new StringBuilder(s.length());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c == '%') {
                do {
                    if (i + 2 >= s.length()) {
                        throw new IllegalArgumentException("Incomplete % sequence at: " + i);
                    }
                    int d1 = hexToInt(s.charAt(i + 1));
                    int d2 = hexToInt(s.charAt(i + 2));
                    if (d1 == -1 || d2 == -1) {
                        throw new IllegalArgumentException("Invalid % sequence " +
                                s.substring(i, i + 3) + " at " + i);
                    }
                    out.write((byte) ((d1 << 4) + d2));
                    i += 3;
                } while (i < s.length() && s.charAt(i) == '%');
                result.append(new String(out.toByteArray(), charset));
                out.reset();
            } else {
                if (convertPlus && c == '+') {
                    c = ' ';
                }
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }

    /**
     * Like {@link Character#digit}, but without support for non-ASCII
     * characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.395 -0500", hash_original_method = "76CEABA5F78D1B7C2E24392FFD6655D0", hash_generated_method = "EC68D3DE13E4F0BFEE8EE6AD07B85B3A")
    
private static int hexToInt(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('a' <= c && c <= 'f') {
            return 10 + (c - 'a');
        } else if ('A' <= c && c <= 'F') {
            return 10 + (c - 'A');
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.398 -0500", hash_original_method = "85646295C49D20CEC5AAEC936FF0DDBE", hash_generated_method = "11B83CE81DCF2F920B8A0B5D216B648E")
    
public static String decode(String s) {
        return decode(s, false, Charsets.UTF_8);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.400 -0500", hash_original_method = "E9F136CB11807D6535BCD4A061FBC37D", hash_generated_method = "FBABD2BE64FE1261CCF2AF7EE23B9308")
    
private static void appendHex(StringBuilder builder, String s, Charset charset) {
        for (byte b : s.getBytes(charset)) {
            appendHex(builder, b);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.402 -0500", hash_original_method = "A304BB6B333CCE47620C2E0D28BC85CC", hash_generated_method = "839C3FDB280437B10551E427ECA4E89A")
    
private static void appendHex(StringBuilder sb, byte b) {
        sb.append('%');
        sb.append(Byte.toHexString(b, true));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.874 -0400", hash_original_method = "4BF02B8F3FC732245257150462C2453A", hash_generated_method = "4BF02B8F3FC732245257150462C2453A")
    public UriCodec ()
    {
        //Synthesized constructor
    }

    /**
     * Returns true if {@code c} does not need to be escaped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.373 -0500", hash_original_method = "4E8831F3AC7981E695BD544C8DFD7574", hash_generated_method = "B04EF2371FE03B993D1CCF174E51EBCC")
    
protected abstract boolean isRetained(char c);

    /**
     * Throws if {@code s} is invalid according to this encoder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.376 -0500", hash_original_method = "F141B1647AA9A55C59B7CEA66DF70E00", hash_generated_method = "BE4A58F776D7DEFE3035FA9B3E9D24D3")
    
public final String validate(String uri, int start, int end, String name)
            throws URISyntaxException {
        for (int i = start; i < end; ) {
            char ch = uri.charAt(i);
            if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9')
                    || isRetained(ch)) {
                i++;
            } else if (ch == '%') {
                if (i + 2 >= end) {
                    throw new URISyntaxException(uri, "Incomplete % sequence in " + name, i);
                }
                int d1 = hexToInt(uri.charAt(i + 1));
                int d2 = hexToInt(uri.charAt(i + 2));
                if (d1 == -1 || d2 == -1) {
                    throw new URISyntaxException(uri, "Invalid % sequence: "
                            + uri.substring(i, i + 3) + " in " + name, i);
                }
                i += 3;
            } else {
                throw new URISyntaxException(uri, "Illegal character in " + name, i);
            }
        }
        return uri.substring(start, end);
    }

    /**
     * Encodes {@code s} and appends the result to {@code builder}.
     *
     * @param isPartiallyEncoded true to fix input that has already been
     *     partially or fully encoded. For example, input of "hello%20world" is
     *     unchanged with isPartiallyEncoded=true but would be double-escaped to
     *     "hello%2520world" otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.382 -0500", hash_original_method = "7FC39F773DF770E48BBB73C216A59F70", hash_generated_method = "A709178A851E864AECBF954F3AD0D643")
    
private void appendEncoded(StringBuilder builder, String s, Charset charset,
            boolean isPartiallyEncoded) {
        if (s == null) {
            throw new NullPointerException();
        }

        int escapeStart = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || isRetained(c)
                    || (c == '%' && isPartiallyEncoded)) {
                if (escapeStart != -1) {
                    appendHex(builder, s.substring(escapeStart, i), charset);
                    escapeStart = -1;
                }
                if (c == '%' && isPartiallyEncoded) {
                    // this is an encoded 3-character sequence like "%20"
                    builder.append(s, i, i + 3);
                    i += 2;
                } else if (c == ' ') {
                    builder.append('+');
                } else {
                    builder.append(c);
                }
            } else if (escapeStart == -1) {
                escapeStart = i;
            }
        }
        if (escapeStart != -1) {
            appendHex(builder, s.substring(escapeStart, s.length()), charset);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.384 -0500", hash_original_method = "F07BB214CFA4248E3F52B7C20E4073AE", hash_generated_method = "BB8F83FC6301C99017EA5E5F3DAEB77A")
    
public final String encode(String s, Charset charset) {
        // Guess a bit larger for encoded form
        StringBuilder builder = new StringBuilder(s.length() + 16);
        appendEncoded(builder, s, charset, false);
        return builder.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.387 -0500", hash_original_method = "718B3A047F245697E7F44FEAF3256360", hash_generated_method = "1AF46C8332DCF965273E1341FF040DD3")
    
public final void appendEncoded(StringBuilder builder, String s) {
        appendEncoded(builder, s, Charsets.UTF_8, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.389 -0500", hash_original_method = "9FEB097DD7C595E776FA816DF15836E6", hash_generated_method = "B751933DE1F2F0DF8B0CEB68F55089CA")
    
public final void appendPartiallyEncoded(StringBuilder builder, String s) {
        appendEncoded(builder, s, Charsets.UTF_8, true);
    }
    
}

