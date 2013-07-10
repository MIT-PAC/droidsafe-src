package libcore.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;

public abstract class UriCodec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.587 -0400", hash_original_method = "4BF02B8F3FC732245257150462C2453A", hash_generated_method = "4BF02B8F3FC732245257150462C2453A")
    public UriCodec ()
    {
        
    }


    protected abstract boolean isRetained(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.589 -0400", hash_original_method = "F141B1647AA9A55C59B7CEA66DF70E00", hash_generated_method = "2788713128F4BAB86EBC0E1D180AA958")
    public final String validate(String uri, int start, int end, String name) throws URISyntaxException {
        String varB4EAC82CA7396A68D541C85D26508E83_58022438 = null; 
        {
            int i = start;
            {
                char ch = uri.charAt(i);
                {
                    boolean var88D3288C67D30B766BA63886BD67B359_864933994 = ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9')
                    || isRetained(ch));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Incomplete % sequence in " + name, i);
                        } 
                        int d1 = hexToInt(uri.charAt(i + 1));
                        int d2 = hexToInt(uri.charAt(i + 2));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Invalid % sequence: "
                            + uri.substring(i, i + 3) + " in " + name, i);
                        } 
                        i += 3;
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in " + name, i);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_58022438 = uri.substring(start, end);
        addTaint(uri.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_58022438.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_58022438;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.590 -0400", hash_original_method = "7FC39F773DF770E48BBB73C216A59F70", hash_generated_method = "3BA5F7E7102294150C6C104DF8AAEBFD")
    private void appendEncoded(StringBuilder builder, String s, Charset charset,
            boolean isPartiallyEncoded) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int escapeStart = -1;
        {
            int i = 0;
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_1715499941 = (i < s.length());
            {
                char c = s.charAt(i);
                {
                    boolean varDF0765B40C88A29FE9945F4345F4A8D4_447811998 = ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || isRetained(c)
                    || (c == '%' && isPartiallyEncoded));
                    {
                        {
                            appendHex(builder, s.substring(escapeStart, i), charset);
                            escapeStart = -1;
                        } 
                        {
                            builder.append(s, i, i + 3);
                            i += 2;
                        } 
                        {
                            builder.append('+');
                        } 
                        {
                            builder.append(c);
                        } 
                    } 
                    {
                        escapeStart = i;
                    } 
                } 
            } 
        } 
        {
            appendHex(builder, s.substring(escapeStart, s.length()), charset);
        } 
        addTaint(builder.getTaint());
        addTaint(s.getTaint());
        addTaint(charset.getTaint());
        addTaint(isPartiallyEncoded);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.592 -0400", hash_original_method = "F07BB214CFA4248E3F52B7C20E4073AE", hash_generated_method = "CA197B589190E3E0D9331060F90AB1B1")
    public final String encode(String s, Charset charset) {
        String varB4EAC82CA7396A68D541C85D26508E83_793981622 = null; 
        StringBuilder builder = new StringBuilder(s.length() + 16);
        appendEncoded(builder, s, charset, false);
        varB4EAC82CA7396A68D541C85D26508E83_793981622 = builder.toString();
        addTaint(s.getTaint());
        addTaint(charset.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_793981622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_793981622;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.593 -0400", hash_original_method = "718B3A047F245697E7F44FEAF3256360", hash_generated_method = "BBD0D27739D38E7735CDA4AC7BBD343F")
    public final void appendEncoded(StringBuilder builder, String s) {
        appendEncoded(builder, s, Charsets.UTF_8, false);
        addTaint(builder.getTaint());
        addTaint(s.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.594 -0400", hash_original_method = "9FEB097DD7C595E776FA816DF15836E6", hash_generated_method = "A793551A44829153571A79DDE4F5CBF9")
    public final void appendPartiallyEncoded(StringBuilder builder, String s) {
        appendEncoded(builder, s, Charsets.UTF_8, true);
        addTaint(builder.getTaint());
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static String decode(String s) {
        return decode(s, false, Charsets.UTF_8);
    }

    
    @DSModeled(DSC.SAFE)
    private static void appendHex(StringBuilder builder, String s, Charset charset) {
        for (byte b : s.getBytes(charset)) {
            appendHex(builder, b);
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static void appendHex(StringBuilder sb, byte b) {
        sb.append('%');
        sb.append(Byte.toHexString(b, true));
    }

    
}

