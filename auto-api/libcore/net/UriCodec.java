package libcore.net;

// Droidsafe Imports
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
// import Iterator to deal with enhanced for loop translation
import droidsafe.runtime.DroidSafeAndroidRuntime;

public abstract class UriCodec {
    
    protected abstract boolean isRetained(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.513 -0400", hash_original_method = "F141B1647AA9A55C59B7CEA66DF70E00", hash_generated_method = "B5A0EC5F3E86198E8C4C431D3779BC7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String validate(String uri, int start, int end, String name) throws URISyntaxException {
        dsTaint.addTaint(start);
        dsTaint.addTaint(name);
        dsTaint.addTaint(uri);
        dsTaint.addTaint(end);
        {
            int i;
            i = start;
            {
                char ch;
                ch = uri.charAt(i);
                {
                    boolean var88D3288C67D30B766BA63886BD67B359_1806364528 = ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9')
                    || isRetained(ch));
                    {
                        i++;
                    } //End block
                    {
                        {
                        	if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Incomplete % sequence in " + name, i);
                        } //End block
                        int d1;
                        d1 = hexToInt(uri.charAt(i + 1));
                        int d2;
                        d2 = hexToInt(uri.charAt(i + 2));
                        {
                        	if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Invalid % sequence: "
                            + uri.substring(i, i + 3) + " in " + name, i);
                        } //End block
                        i += 3;
                    } //End block
                    {
                    	if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in " + name, i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varDFF587D9FF465F5FF109809F3551A536_1576687147 = (uri.substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.513 -0400", hash_original_method = "181D72A2209D840D07CA2C50875CB8AF", hash_generated_method = "6F629466D5256ED64F28F46143E8DD76")
    public static void validateSimple(String s, String legal) throws URISyntaxException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "7FC39F773DF770E48BBB73C216A59F70", hash_generated_method = "02D398C8F31C34FB53BBBAA05E93D8BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendEncoded(StringBuilder builder, String s, Charset charset,
            boolean isPartiallyEncoded) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(isPartiallyEncoded);
        dsTaint.addTaint(builder.dsTaint);
        dsTaint.addTaint(charset.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int escapeStart;
        escapeStart = -1;
        {
            int i;
            i = 0;
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_629982488 = (i < s.length());
            {
                char c;
                c = s.charAt(i);
                {
                    boolean varDF0765B40C88A29FE9945F4345F4A8D4_333669070 = ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || isRetained(c)
                    || (c == '%' && isPartiallyEncoded));
                    {
                        {
                            appendHex(builder, s.substring(escapeStart, i), charset);
                            escapeStart = -1;
                        } //End block
                        {
                            builder.append(s, i, i + 3);
                            i += 2;
                        } //End block
                        {
                            builder.append('+');
                        } //End block
                        {
                            builder.append(c);
                        } //End block
                    } //End block
                    {
                        escapeStart = i;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            appendHex(builder, s.substring(escapeStart, s.length()), charset);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "F07BB214CFA4248E3F52B7C20E4073AE", hash_generated_method = "E5B775A40421A1B49B3CBA1A4BD71D33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String encode(String s, Charset charset) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(charset.dsTaint);
        StringBuilder builder;
        builder = new StringBuilder(s.length() + 16);
        appendEncoded(builder, s, charset, false);
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1554671798 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder(s.length() + 16);
        //appendEncoded(builder, s, charset, false);
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "718B3A047F245697E7F44FEAF3256360", hash_generated_method = "4E128A2B5599C48DBA06491E1BF3244F")
    @DSModeled(DSC.SAFE)
    public final void appendEncoded(StringBuilder builder, String s) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(builder.dsTaint);
        appendEncoded(builder, s, Charsets.UTF_8, false);
        // ---------- Original Method ----------
        //appendEncoded(builder, s, Charsets.UTF_8, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "9FEB097DD7C595E776FA816DF15836E6", hash_generated_method = "DDDED24A2211D4775AAF678A8CAFD040")
    @DSModeled(DSC.SAFE)
    public final void appendPartiallyEncoded(StringBuilder builder, String s) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(builder.dsTaint);
        appendEncoded(builder, s, Charsets.UTF_8, true);
        // ---------- Original Method ----------
        //appendEncoded(builder, s, Charsets.UTF_8, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "D42ED385C72D36F3791E3A3CA5AE2B50", hash_generated_method = "36D21E6226432C2E78E2377B0E9583DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "76CEABA5F78D1B7C2E24392FFD6655D0", hash_generated_method = "EC68D3DE13E4F0BFEE8EE6AD07B85B3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "85646295C49D20CEC5AAEC936FF0DDBE", hash_generated_method = "11B83CE81DCF2F920B8A0B5D216B648E")
    public static String decode(String s) {
        return decode(s, false, Charsets.UTF_8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "E9F136CB11807D6535BCD4A061FBC37D", hash_generated_method = "FBABD2BE64FE1261CCF2AF7EE23B9308")
    private static void appendHex(StringBuilder builder, String s, Charset charset) {
        for (byte b : s.getBytes(charset)) {
            appendHex(builder, b);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.514 -0400", hash_original_method = "A304BB6B333CCE47620C2E0D28BC85CC", hash_generated_method = "839C3FDB280437B10551E427ECA4E89A")
    private static void appendHex(StringBuilder sb, byte b) {
        sb.append('%');
        sb.append(Byte.toHexString(b, true));
    }

    
}


