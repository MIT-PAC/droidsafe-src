package libcore.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;

public abstract class UriCodec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.025 -0400", hash_original_method = "4BF02B8F3FC732245257150462C2453A", hash_generated_method = "4BF02B8F3FC732245257150462C2453A")
    public UriCodec ()
    {
        //Synthesized constructor
    }


    protected abstract boolean isRetained(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.026 -0400", hash_original_method = "F141B1647AA9A55C59B7CEA66DF70E00", hash_generated_method = "22ACF2C4C30F8F424E7377F30B564841")
    public final String validate(String uri, int start, int end, String name) throws URISyntaxException {
        addTaint(name.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(uri.getTaint());
for(int i = start;i < end;)
        {
            char ch = uri.charAt(i);
    if((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9')
                    || isRetained(ch))            
            {
                i++;
            } //End block
            else
    if(ch == '%')            
            {
    if(i + 2 >= end)                
                {
                    URISyntaxException var2051C8B4935F2FD625B8599DFE00E440_696286503 = new URISyntaxException(uri, "Incomplete % sequence in " + name, i);
                    var2051C8B4935F2FD625B8599DFE00E440_696286503.addTaint(taint);
                    throw var2051C8B4935F2FD625B8599DFE00E440_696286503;
                } //End block
                int d1 = hexToInt(uri.charAt(i + 1));
                int d2 = hexToInt(uri.charAt(i + 2));
    if(d1 == -1 || d2 == -1)                
                {
                    URISyntaxException varFE39BA79E51C59BE2596FD64022B6F4E_1772336622 = new URISyntaxException(uri, "Invalid % sequence: "
                            + uri.substring(i, i + 3) + " in " + name, i);
                    varFE39BA79E51C59BE2596FD64022B6F4E_1772336622.addTaint(taint);
                    throw varFE39BA79E51C59BE2596FD64022B6F4E_1772336622;
                } //End block
                i += 3;
            } //End block
            else
            {
                URISyntaxException var7BBBBB6DDBB5BADEE4A4A0A58340C037_647431964 = new URISyntaxException(uri, "Illegal character in " + name, i);
                var7BBBBB6DDBB5BADEE4A4A0A58340C037_647431964.addTaint(taint);
                throw var7BBBBB6DDBB5BADEE4A4A0A58340C037_647431964;
            } //End block
        } //End block
String var83F838AFDFF49EDFAA9A2F840A0E32DF_1245407574 =         uri.substring(start, end);
        var83F838AFDFF49EDFAA9A2F840A0E32DF_1245407574.addTaint(taint);
        return var83F838AFDFF49EDFAA9A2F840A0E32DF_1245407574;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.028 -0400", hash_original_method = "7FC39F773DF770E48BBB73C216A59F70", hash_generated_method = "49736DF14B1E2DF1FC1EA51927048A0C")
    private void appendEncoded(StringBuilder builder, String s, Charset charset,
            boolean isPartiallyEncoded) {
        addTaint(isPartiallyEncoded);
        addTaint(charset.getTaint());
        addTaint(s.getTaint());
        addTaint(builder.getTaint());
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2021882153 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2021882153.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2021882153;
        } //End block
        int escapeStart = -1;
for(int i = 0;i < s.length();i++)
        {
            char c = s.charAt(i);
    if((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || isRetained(c)
                    || (c == '%' && isPartiallyEncoded))            
            {
    if(escapeStart != -1)                
                {
                    appendHex(builder, s.substring(escapeStart, i), charset);
                    escapeStart = -1;
                } //End block
    if(c == '%' && isPartiallyEncoded)                
                {
                    builder.append(s, i, i + 3);
                    i += 2;
                } //End block
                else
    if(c == ' ')                
                {
                    builder.append('+');
                } //End block
                else
                {
                    builder.append(c);
                } //End block
            } //End block
            else
    if(escapeStart == -1)            
            {
                escapeStart = i;
            } //End block
        } //End block
    if(escapeStart != -1)        
        {
            appendHex(builder, s.substring(escapeStart, s.length()), charset);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.029 -0400", hash_original_method = "F07BB214CFA4248E3F52B7C20E4073AE", hash_generated_method = "D8E0E519B99D35BAC8D89A5FFAD0B827")
    public final String encode(String s, Charset charset) {
        addTaint(charset.getTaint());
        addTaint(s.getTaint());
        StringBuilder builder = new StringBuilder(s.length() + 16);
        appendEncoded(builder, s, charset, false);
String varF4CF030572656354ACFDF83FEE21D7A6_800660205 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_800660205.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_800660205;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder(s.length() + 16);
        //appendEncoded(builder, s, charset, false);
        //return builder.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.029 -0400", hash_original_method = "718B3A047F245697E7F44FEAF3256360", hash_generated_method = "8BDDFF8EBD1A839191A04A74A2FC7809")
    public final void appendEncoded(StringBuilder builder, String s) {
        addTaint(s.getTaint());
        addTaint(builder.getTaint());
        appendEncoded(builder, s, Charsets.UTF_8, false);
        // ---------- Original Method ----------
        //appendEncoded(builder, s, Charsets.UTF_8, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.029 -0400", hash_original_method = "9FEB097DD7C595E776FA816DF15836E6", hash_generated_method = "FAFEDADF6AE1359D5FE5498461C980DB")
    public final void appendPartiallyEncoded(StringBuilder builder, String s) {
        addTaint(s.getTaint());
        addTaint(builder.getTaint());
        appendEncoded(builder, s, Charsets.UTF_8, true);
        // ---------- Original Method ----------
        //appendEncoded(builder, s, Charsets.UTF_8, true);
    }

    
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

    
        public static String decode(String s) {
        return decode(s, false, Charsets.UTF_8);
    }

    
        private static void appendHex(StringBuilder builder, String s, Charset charset) {
        for (byte b : s.getBytes(charset)) {
            appendHex(builder, b);
        }
    }

    
        private static void appendHex(StringBuilder sb, byte b) {
        sb.append('%');
        sb.append(Byte.toHexString(b, true));
    }

    
}

