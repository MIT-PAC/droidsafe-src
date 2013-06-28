package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;
import java.util.Collection;

public class ArrayUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.533 -0400", hash_original_method = "43AFEF6A809467B8D7C7F671BE94BA32", hash_generated_method = "C31BA8013CD1B4E5DD8E143F798814CA")
    private  ArrayUtils() {
        // ---------- Original Method ----------
    }

    
    public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;
        return need;
    }

    
    public static int idealBooleanArraySize(int need) {
        return idealByteArraySize(need);
    }

    
    public static int idealShortArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    
    public static int idealCharArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    
    public static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    public static int idealFloatArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    public static int idealObjectArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    
    public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    
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

    
    public static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.534 -0400", hash_original_field = "29B703ACBB9AD25AEF5009A0607792DF", hash_generated_field = "CBCBEA4E00AB156D53E8DE38652C837E")

    private static Object[] EMPTY = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.534 -0400", hash_original_field = "4A01C4C4ED3CD14A1D7897F8E92E5430", hash_generated_field = "35AC3362FFA6CCFAF15BB1672E810254")

    private static final int CACHE_SIZE = 73;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.534 -0400", hash_original_field = "3C6439824DAF4ABE939B8A6B4B36D0E7", hash_generated_field = "6DA94EC2F9AC0A3F496BD3D98ACB6E01")

    private static Object[] sCache = new Object[CACHE_SIZE];
}

