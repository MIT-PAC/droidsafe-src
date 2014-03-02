package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class Charsets {
    
    public static byte[] toAsciiBytes(char[] chars, int offset, int length) {
        byte[] out = new byte[length];
        for (int i = 0; i < length; i++) {
            out[i] = (byte)chars[i+offset]; 
        }
        return out;
    }
    
    public static byte[] toIsoLatin1Bytes(char[] chars, int offset, int length) {
        byte[] out = new byte[length];
        for (int i = 0; i < length; i++) {
            out[i] = (byte)chars[i+offset]; 
        }
        return out;
    }
    
    public static byte[] toUtf8Bytes(char[] chars, int offset, int length) {
        byte[] out = new byte[length];
        for (int i = 0; i < length; i++) {
            out[i] = (byte)chars[i+offset]; 
        }
        return out;
    }

    /**
     * Returns a new byte array containing the bytes corresponding to the given characters,
     * encoded in UTF-16BE. All characters are representable in UTF-16BE.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.014 -0500", hash_original_method = "5CA5554CE8FD4158388C6D1687495E52", hash_generated_method = "2DE5180C67E6F93D5B4723B0787F66FA")
    
public static byte[] toBigEndianUtf16Bytes(char[] chars, int offset, int length) {
        byte[] result = new byte[length * 2];
        int end = offset + length;
        int resultIndex = 0;
        for (int i = offset; i < end; ++i) {
            char ch = chars[i];
            result[resultIndex++] = (byte) (ch >> 8);
            result[resultIndex++] = (byte) ch;
        }
        return result;
    }
    
    public static void asciiBytesToChars(byte[] bytes, int offset, int length, char[] chars) {
    }
    
    public static void isoLatin1BytesToChars(byte[] bytes, int offset, int length, char[] chars) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.992 -0500", hash_original_field = "A22CC05BE6CEEE92799923C2424B3CA8", hash_generated_field = "8EC60A36A46A03E488D22699D2DAA981")

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.995 -0500", hash_original_field = "714C63F2B80D1D2AC8056DCAAFF2BD5B", hash_generated_field = "3E3052A707DD298E1FBE7FC8381E1B07")

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.998 -0500", hash_original_field = "81A0A19FF2F5A038281B549B1D0CE3F5", hash_generated_field = "31164D91DD586A365881F2A00F655E8D")

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.024 -0500", hash_original_method = "9D5DC2CDE25FE055FB5E2F5C6BA10509", hash_generated_method = "44460063642E792FB6F57D14866E6745")
    
private Charsets() {
    }
}

