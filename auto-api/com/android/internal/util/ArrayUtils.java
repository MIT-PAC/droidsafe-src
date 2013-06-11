package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.reflect.Array;
import java.util.Collection;

public class ArrayUtils {
    private static Object[] EMPTY = new Object[0];
    private static final int CACHE_SIZE = 73;
    private static Object[] sCache = new Object[CACHE_SIZE];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "43AFEF6A809467B8D7C7F671BE94BA32", hash_generated_method = "6AA4F36C764BE2C6671BD0548AAEAA8D")
    @DSModeled(DSC.SAFE)
    private ArrayUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "78F4782A9945BD922AE4F703F6706A7E", hash_generated_method = "476E3135F747B27C638A7747394DD781")
    public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;
        return need;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "E5CBE1305B9841D5F7520AE554A1D771", hash_generated_method = "DCFB8C1110EF7315C14FAA4BC3983217")
    public static int idealBooleanArraySize(int need) {
        return idealByteArraySize(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "476179F248591310A63873FA4BFE1795", hash_generated_method = "7826F968441D7C8EC5C0457AAE9A8D6F")
    public static int idealShortArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "240EA87D06DB1A06FA20089690ED1FAF", hash_generated_method = "B001DEBADBDCF7D7CFC433939B7F8AC1")
    public static int idealCharArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "C5D38D95B60B446AE8BAAF7982426E2B", hash_generated_method = "89087E12BD5927700561885B368C654D")
    public static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "B1C460BE3C0CE188069E0284191F28C6", hash_generated_method = "485A9FDB237656EFE65F1CBBCCED859F")
    public static int idealFloatArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "BE75264EB1A403EA3326DE788095D988", hash_generated_method = "8D2AA51E9F953BB025F52FB38D39073B")
    public static int idealObjectArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "81E7FAA327416436814745B8BDC163E2", hash_generated_method = "7A7A55B2D3E16E87C86D175661E4F019")
    public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.632 -0400", hash_original_method = "F616355A61EDB472AF49A2D85F949B07", hash_generated_method = "FC9D3D53408896E06586C68BE0F93BE5")
    public static boolean equals(byte[] array1, byte[] array2, int length) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length < length || array2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.633 -0400", hash_original_method = "E8AC23ECD737592F4E458340FA4F1721", hash_generated_method = "DBACFD74CFC0F700C6C849F652368398")
    public static <T> T[] emptyArray(Class<T> kind) {
        if (kind == Object.class) {
            return (T[]) EMPTY;
        }
        int bucket = ((System.identityHashCode(kind) / 8) & 0x7FFFFFFF) % CACHE_SIZE;
        Object cache = sCache[bucket];
        if (cache == null || cache.getClass().getComponentType() != kind) {
            cache = Array.newInstance(kind, 0);
            sCache[bucket] = cache;
        }
        return (T[]) cache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.633 -0400", hash_original_method = "7C504EF6537379D7F6CD8E7EE5DFCFA0", hash_generated_method = "E3523E5A2BE0CF4FF9475E7D6ACE6958")
    public static <T> boolean contains(T[] array, T value) {
        for (T element : array) {
            if (element == null) {
                if (value == null) return true;
            } else {
                if (value != null && element.equals(value)) return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.633 -0400", hash_original_method = "380B6F6F5CAD5A5F28E260C7C7025807", hash_generated_method = "C2659EBCE20AF2B2BB1B07D4A48CE398")
    public static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    
}


