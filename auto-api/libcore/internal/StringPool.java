package libcore.internal;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class StringPool {
    private final String[] pool = new String[512];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.430 -0400", hash_original_method = "9B32FE5AB257BF8F1743169E9DF2009F", hash_generated_method = "A73EDA67461E9FEFF0B0297D0C357EB1")
    private static boolean contentEquals(String s, char[] chars, int start, int length) {
        if (s.length() != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (chars[start + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.430 -0400", hash_original_method = "84455256120C340B9F8A0E1FDB3B796B", hash_generated_method = "7C8E2BBC19C4A4C01E10669EA9894063")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String get(char[] array, int start, int length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        dsTaint.addTaint(array);
        int hashCode;
        hashCode = 0;
        {
            int i;
            i = start;
            {
                hashCode = (hashCode * 31) + array[i];
            } //End block
        } //End collapsed parenthetic
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        hashCode ^= (hashCode >>> 7) ^ (hashCode >>> 4);
        int index;
        index = hashCode & (pool.length - 1);
        String pooled;
        pooled = pool[index];
        {
            boolean var0E29A3BBD67CCC228CA6E68E863F0F24_148518681 = (pooled != null && contentEquals(pooled, array, start, length));
        } //End collapsed parenthetic
        String result;
        result = new String(array, start, length);
        pool[index] = result;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int hashCode = 0;
        //for (int i = start; i < start + length; i++) {
            //hashCode = (hashCode * 31) + array[i];
        //}
        //hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        //hashCode ^= (hashCode >>> 7) ^ (hashCode >>> 4);
        //int index = hashCode & (pool.length - 1);
        //String pooled = pool[index];
        //if (pooled != null && contentEquals(pooled, array, start, length)) {
            //return pooled;
        //}
        //String result = new String(array, start, length);
        //pool[index] = result;
        //return result;
    }

    
}


