package libcore.internal;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StringPool {
    private String[] pool = new String[512];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.760 -0400", hash_original_method = "749941B62E4E8DBDE326146B3D9E4EF8", hash_generated_method = "749941B62E4E8DBDE326146B3D9E4EF8")
        public StringPool ()
    {
    }


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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.760 -0400", hash_original_method = "84455256120C340B9F8A0E1FDB3B796B", hash_generated_method = "8FC069FAFA27F23D0E0F6300B8C55EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String get(char[] array, int start, int length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        dsTaint.addTaint(array[0]);
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
            boolean var0E29A3BBD67CCC228CA6E68E863F0F24_2100474955 = (pooled != null && contentEquals(pooled, array, start, length));
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

