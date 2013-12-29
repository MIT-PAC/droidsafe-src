package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Array;






public class ArrayUtils {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.327 -0500", hash_original_method = "78F4782A9945BD922AE4F703F6706A7E", hash_generated_method = "476E3135F747B27C638A7747394DD781")
    public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;

        return need;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.327 -0500", hash_original_method = "E5CBE1305B9841D5F7520AE554A1D771", hash_generated_method = "DCFB8C1110EF7315C14FAA4BC3983217")
    public static int idealBooleanArraySize(int need) {
        return idealByteArraySize(need);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.328 -0500", hash_original_method = "476179F248591310A63873FA4BFE1795", hash_generated_method = "7826F968441D7C8EC5C0457AAE9A8D6F")
    public static int idealShortArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.329 -0500", hash_original_method = "240EA87D06DB1A06FA20089690ED1FAF", hash_generated_method = "B001DEBADBDCF7D7CFC433939B7F8AC1")
    public static int idealCharArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.330 -0500", hash_original_method = "C5D38D95B60B446AE8BAAF7982426E2B", hash_generated_method = "89087E12BD5927700561885B368C654D")
    public static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.331 -0500", hash_original_method = "B1C460BE3C0CE188069E0284191F28C6", hash_generated_method = "485A9FDB237656EFE65F1CBBCCED859F")
    public static int idealFloatArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.332 -0500", hash_original_method = "BE75264EB1A403EA3326DE788095D988", hash_generated_method = "8D2AA51E9F953BB025F52FB38D39073B")
    public static int idealObjectArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.333 -0500", hash_original_method = "81E7FAA327416436814745B8BDC163E2", hash_generated_method = "7A7A55B2D3E16E87C86D175661E4F019")
    public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    /**
     * Checks if the beginnings of two byte arrays are equal.
     *
     * @param array1 the first byte array
     * @param array2 the second byte array
     * @param length the number of bytes to check
     * @return true if they're equal, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.334 -0500", hash_original_method = "F616355A61EDB472AF49A2D85F949B07", hash_generated_method = "FC9D3D53408896E06586C68BE0F93BE5")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.337 -0500", hash_original_method = "380B6F6F5CAD5A5F28E260C7C7025807", hash_generated_method = "C2659EBCE20AF2B2BB1B07D4A48CE398")
    public static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.323 -0500", hash_original_field = "41605FD9568522F1EC6EA33C9F0B24F1", hash_generated_field = "CBCBEA4E00AB156D53E8DE38652C837E")

    private static Object[] EMPTY = new Object[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.324 -0500", hash_original_field = "B5E3D6A79EEEEAD4123A14A08572DC78", hash_generated_field = "35AC3362FFA6CCFAF15BB1672E810254")

    private static final int CACHE_SIZE = 73;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.325 -0500", hash_original_field = "8F1734AB1FEA635C1BCFBAEFD17414CE", hash_generated_field = "6DA94EC2F9AC0A3F496BD3D98ACB6E01")

    private static Object[] sCache = new Object[CACHE_SIZE];

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.326 -0500", hash_original_method = "43AFEF6A809467B8D7C7F671BE94BA32", hash_generated_method = "89ED7997528D51F882DDEB727ADBF171")
    private ArrayUtils() { /* cannot be instantiated */ }
}

