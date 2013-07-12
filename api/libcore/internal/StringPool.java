package libcore.internal;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class StringPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.321 -0400", hash_original_field = "AABD10263E22750AD811AC54BA397F4A", hash_generated_field = "2E2D169FE900F8A4284E9ADB2D6BFB44")

    private final String[] pool = new String[512];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.321 -0400", hash_original_method = "47E61A2F931E9ECD5F1435DEB562B68F", hash_generated_method = "47E61A2F931E9ECD5F1435DEB562B68F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.323 -0400", hash_original_method = "84455256120C340B9F8A0E1FDB3B796B", hash_generated_method = "95B57F6885CE28C49DDA312845CB6298")
    public String get(char[] array, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(array[0]);
        int hashCode = 0;
for(int i = start;i < start + length;i++)
        {
            hashCode = (hashCode * 31) + array[i];
        } 
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        hashCode ^= (hashCode >>> 7) ^ (hashCode >>> 4);
        int index = hashCode & (pool.length - 1);
        String pooled = pool[index];
    if(pooled != null && contentEquals(pooled, array, start, length))        
        {
String var0F4C03B2E07844EE7381823BFB463F14_430496182 =             pooled;
            var0F4C03B2E07844EE7381823BFB463F14_430496182.addTaint(taint);
            return var0F4C03B2E07844EE7381823BFB463F14_430496182;
        } 
        String result = new String(array, start, length);
        pool[index] = result;
String varDC838461EE2FA0CA4C9BBB70A15456B0_487775239 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_487775239.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_487775239;
        
        
        
            
        
        
        
        
        
        
            
        
        
        
        
    }

    
}

