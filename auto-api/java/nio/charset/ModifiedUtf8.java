package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.UTFDataFormatException;
import java.nio.ByteOrder;
import libcore.io.Memory;
import libcore.io.SizeOf;

public class ModifiedUtf8 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.565 -0400", hash_original_method = "64489454DCC17A9858C56DA9699AAAE7", hash_generated_method = "589841C442F74E225BEB9A7B8E00D29D")
    @DSModeled(DSC.SAFE)
    private ModifiedUtf8() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.565 -0400", hash_original_method = "5393979ADC62E28ADD27F66A98DE94B1", hash_generated_method = "E5BF9B5D16592C07021AAD713B61E5BA")
    public static String decode(byte[] in, char[] out, int offset, int utfSize) throws UTFDataFormatException {
        int count = 0, s = 0, a;
        while (count < utfSize) {
            if ((out[s] = (char) in[offset + count++]) < '\u0080') {
                s++;
            } else if (((a = out[s]) & 0xe0) == 0xc0) {
                if (count >= utfSize) {
                    throw new UTFDataFormatException("bad second byte at " + count);
                }
                int b = in[offset + count++];
                if ((b & 0xC0) != 0x80) {
                    throw new UTFDataFormatException("bad second byte at " + (count - 1));
                }
                out[s++] = (char) (((a & 0x1F) << 6) | (b & 0x3F));
            } else if ((a & 0xf0) == 0xe0) {
                if (count + 1 >= utfSize) {
                    throw new UTFDataFormatException("bad third byte at " + (count + 1));
                }
                int b = in[offset + count++];
                int c = in[offset + count++];
                if (((b & 0xC0) != 0x80) || ((c & 0xC0) != 0x80)) {
                    throw new UTFDataFormatException("bad second or third byte at " + (count - 2));
                }
                out[s++] = (char) (((a & 0x0F) << 12) | ((b & 0x3F) << 6) | (c & 0x3F));
            } else {
                throw new UTFDataFormatException("bad byte at " + (count - 1));
            }
        }
        return new String(out, 0, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.566 -0400", hash_original_method = "27037B6AE773D08320C8E234F08B9D01", hash_generated_method = "40EBC4A94C8BE7E449CAD50FD1E7C88E")
    public static long countBytes(String s, boolean shortLength) throws UTFDataFormatException {
        long result = 0;
        final int length = s.length();
        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            if (ch != 0 && ch <= 127) { 
                ++result;
            } else if (ch <= 2047) {
                result += 2;
            } else {
                result += 3;
            }
            if (shortLength && result > 65535) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.566 -0400", hash_original_method = "08FFAD61125D208C57B7F98D1BD8BCF0", hash_generated_method = "A0EFF6301360D6EE85BBE0A4DE8CE3AB")
    public static void encode(byte[] dst, int offset, String s) {
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch != 0 && ch <= 127) { 
                dst[offset++] = (byte) ch;
            } else if (ch <= 2047) {
                dst[offset++] = (byte) (0xc0 | (0x1f & (ch >> 6)));
                dst[offset++] = (byte) (0x80 | (0x3f & ch));
            } else {
                dst[offset++] = (byte) (0xe0 | (0x0f & (ch >> 12)));
                dst[offset++] = (byte) (0x80 | (0x3f & (ch >> 6)));
                dst[offset++] = (byte) (0x80 | (0x3f & ch));
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.566 -0400", hash_original_method = "C3E6BB1DD42E4EBE7B80ABC48FCD6E53", hash_generated_method = "33B14CD4DA61BCF290C46EBC50DE517C")
    public static byte[] encode(String s) throws UTFDataFormatException {
        int utfCount = (int) ModifiedUtf8.countBytes(s, true);
        byte[] result = new byte[SizeOf.SHORT + utfCount];
        Memory.pokeShort(result, 0, (short) utfCount, ByteOrder.BIG_ENDIAN);
        ModifiedUtf8.encode(result, SizeOf.SHORT, s);
        return result;
    }

    
}


