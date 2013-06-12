package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Charsets {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "9D5DC2CDE25FE055FB5E2F5C6BA10509", hash_generated_method = "11340C7818BEFF7DA7A317B9C531DBB5")
    @DSModeled(DSC.SAFE)
    private Charsets() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "DD41F531ACAB2A2A86697C645AAD0C54", hash_generated_method = "52C8927E1C12665FC26466391B37B35F")
    public static byte[] toAsciiBytes(char[] chars, int offset, int length) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "219BC0E48A6D682AA9530A35D1E7ACFA", hash_generated_method = "DCC1C42CA6CB060704E3B7731CC686BD")
    public static byte[] toIsoLatin1Bytes(char[] chars, int offset, int length) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "22A1D2E16FCB551F9D6962261F36F929", hash_generated_method = "52B9B23CD44949043F0A426FBCF5F735")
    public static byte[] toUtf8Bytes(char[] chars, int offset, int length) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "5CA5554CE8FD4158388C6D1687495E52", hash_generated_method = "2DE5180C67E6F93D5B4723B0787F66FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "66CC94AE63E57228CA46F4C71E967D95", hash_generated_method = "E0BB3CD7B6301A587DE172A1422E7422")
    public static void asciiBytesToChars(byte[] bytes, int offset, int length, char[] chars) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.553 -0400", hash_original_method = "2F684C992F635FDA99404D5C8F067162", hash_generated_method = "4CEF3DF8152A7F91B95672C84D82D1AF")
    public static void isoLatin1BytesToChars(byte[] bytes, int offset, int length, char[] chars) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


