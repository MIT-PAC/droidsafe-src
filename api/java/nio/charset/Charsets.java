package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Charsets {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.846 -0400", hash_original_method = "9D5DC2CDE25FE055FB5E2F5C6BA10509", hash_generated_method = "E20E44130780AFDA6559CADE58899D8C")
    private  Charsets() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] toAsciiBytes(char[] chars, int offset, int length) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_709532227 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_709532227;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] toIsoLatin1Bytes(char[] chars, int offset, int length) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1419875334 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1419875334;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] toUtf8Bytes(char[] chars, int offset, int length) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_938529096 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_938529096;
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void asciiBytesToChars(byte[] bytes, int offset, int length, char[] chars) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void isoLatin1BytesToChars(byte[] bytes, int offset, int length, char[] chars) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.848 -0400", hash_original_field = "D58744246B267688AF10CAC6B14A6C65", hash_generated_field = "8EC60A36A46A03E488D22699D2DAA981")

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.849 -0400", hash_original_field = "0600F0B856FCF8BDF1D743E87231C60D", hash_generated_field = "3E3052A707DD298E1FBE7FC8381E1B07")

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.849 -0400", hash_original_field = "682D7F045F955F6516043537CA460C17", hash_generated_field = "31164D91DD586A365881F2A00F655E8D")

    public static final Charset UTF_8 = Charset.forName("UTF-8");
}

