package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Charsets {
    public static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static Charset US_ASCII = Charset.forName("US-ASCII");
    public static Charset UTF_8 = Charset.forName("UTF-8");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.133 -0400", hash_original_method = "9D5DC2CDE25FE055FB5E2F5C6BA10509", hash_generated_method = "11340C7818BEFF7DA7A317B9C531DBB5")
    @DSModeled(DSC.SAFE)
    private Charsets() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.135 -0400", hash_original_method = "DD41F531ACAB2A2A86697C645AAD0C54", hash_generated_method = "16052B2BA5D47325D64DCF372A7C71CB")
    public static byte[] toAsciiBytes(char[] chars, int offset, int length) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.136 -0400", hash_original_method = "219BC0E48A6D682AA9530A35D1E7ACFA", hash_generated_method = "F62C6DDF6F73D070A035656BC6744794")
    public static byte[] toIsoLatin1Bytes(char[] chars, int offset, int length) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.138 -0400", hash_original_method = "22A1D2E16FCB551F9D6962261F36F929", hash_generated_method = "F2EDEF03494058EEAA9B3E9C0EC25C19")
    public static byte[] toUtf8Bytes(char[] chars, int offset, int length) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.139 -0400", hash_original_method = "5CA5554CE8FD4158388C6D1687495E52", hash_generated_method = "2DE5180C67E6F93D5B4723B0787F66FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.143 -0400", hash_original_method = "66CC94AE63E57228CA46F4C71E967D95", hash_generated_method = "9A01CC419C0CCEE88D5957298A1AA5D1")
    public static void asciiBytesToChars(byte[] bytes, int offset, int length, char[] chars) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:59:49.144 -0400", hash_original_method = "2F684C992F635FDA99404D5C8F067162", hash_generated_method = "BF2107CF983A8B202C52CE8B7D659650")
    public static void isoLatin1BytesToChars(byte[] bytes, int offset, int length, char[] chars) {
    }

    
}


