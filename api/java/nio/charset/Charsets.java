package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public class Charsets {

    
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

    /**
     * Returns a new byte array containing the bytes corresponding to the given characters,
     * encoded in UTF-16BE. All characters are representable in UTF-16BE.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.173 -0500", hash_original_method = "5CA5554CE8FD4158388C6D1687495E52", hash_generated_method = "2DE5180C67E6F93D5B4723B0787F66FA")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.165 -0500", hash_original_field = "A22CC05BE6CEEE92799923C2424B3CA8", hash_generated_field = "8EC60A36A46A03E488D22699D2DAA981")

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.166 -0500", hash_original_field = "714C63F2B80D1D2AC8056DCAAFF2BD5B", hash_generated_field = "3E3052A707DD298E1FBE7FC8381E1B07")

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.167 -0500", hash_original_field = "81A0A19FF2F5A038281B549B1D0CE3F5", hash_generated_field = "31164D91DD586A365881F2A00F655E8D")

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.176 -0500", hash_original_method = "9D5DC2CDE25FE055FB5E2F5C6BA10509", hash_generated_method = "44460063642E792FB6F57D14866E6745")
    private Charsets() {
    }
}

