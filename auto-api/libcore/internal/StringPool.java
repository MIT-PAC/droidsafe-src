package libcore.internal;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StringPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.775 -0400", hash_original_field = "AABD10263E22750AD811AC54BA397F4A", hash_generated_field = "2E2D169FE900F8A4284E9ADB2D6BFB44")

    private final String[] pool = new String[512];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.775 -0400", hash_original_method = "47E61A2F931E9ECD5F1435DEB562B68F", hash_generated_method = "47E61A2F931E9ECD5F1435DEB562B68F")
    public StringPool ()
    {
        //Synthesized constructor
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.776 -0400", hash_original_method = "84455256120C340B9F8A0E1FDB3B796B", hash_generated_method = "153F3CB8787B89374850AE43672DA7FB")
    public String get(char[] array, int start, int length) {
        String varB4EAC82CA7396A68D541C85D26508E83_1902705075 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1972401788 = null; //Variable for return #2
        int hashCode = 0;
        {
            int i = start;
            {
                hashCode = (hashCode * 31) + array[i];
            } //End block
        } //End collapsed parenthetic
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        hashCode ^= (hashCode >>> 7) ^ (hashCode >>> 4);
        int index = hashCode & (pool.length - 1);
        String pooled = pool[index];
        {
            boolean var0E29A3BBD67CCC228CA6E68E863F0F24_1173411143 = (pooled != null && contentEquals(pooled, array, start, length));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1902705075 = pooled;
            } //End block
        } //End collapsed parenthetic
        String result = new String(array, start, length);
        pool[index] = result;
        varB4EAC82CA7396A68D541C85D26508E83_1972401788 = result;
        addTaint(array[0]);
        addTaint(start);
        addTaint(length);
        String varA7E53CE21691AB073D9660D615818899_1045840687; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1045840687 = varB4EAC82CA7396A68D541C85D26508E83_1902705075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1045840687 = varB4EAC82CA7396A68D541C85D26508E83_1972401788;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1045840687.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1045840687;
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

