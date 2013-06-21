package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Charsets {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.240 -0400", hash_original_method = "9D5DC2CDE25FE055FB5E2F5C6BA10509", hash_generated_method = "E20E44130780AFDA6559CADE58899D8C")
    @DSModeled(DSC.SAFE)
    private Charsets() {
        // ---------- Original Method ----------
    }

    
        public static byte[] toAsciiBytes(char[] chars, int offset, int length) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
        public static byte[] toIsoLatin1Bytes(char[] chars, int offset, int length) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
        public static byte[] toUtf8Bytes(char[] chars, int offset, int length) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
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

    
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
}

