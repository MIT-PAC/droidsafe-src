package org.bouncycastle.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class Arrays {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.164 -0400", hash_original_method = "F55A33B7721183458366770FE1A5E43D", hash_generated_method = "49F223D555836B7BADC6EB97733A13D3")
    private  Arrays() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean areEqual(
        boolean[]  a,
        boolean[]  b) {
        if (a == b)
        {
            return true;
        }
        if (a == null || b == null)
        {
            return false;
        }
        if (a.length != b.length)
        {
            return false;
        }
        for (int i = 0; i != a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean areEqual(
        char[]  a,
        char[]  b) {
        if (a == b)
        {
            return true;
        }
        if (a == null || b == null)
        {
            return false;
        }
        if (a.length != b.length)
        {
            return false;
        }
        for (int i = 0; i != a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean areEqual(
        byte[]  a,
        byte[]  b) {
        if (a == b)
        {
            return true;
        }
        if (a == null || b == null)
        {
            return false;
        }
        if (a.length != b.length)
        {
            return false;
        }
        for (int i = 0; i != a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean constantTimeAreEqual(
        byte[]  a,
        byte[]  b) {
        if (a == b)
        {
            return true;
        }
        if (a == null || b == null)
        {
            return false;
        }
        if (a.length != b.length)
        {
            return false;
        }
        int nonEqual = 0;
        for (int i = 0; i != a.length; i++)
        {
            nonEqual |= (a[i] ^ b[i]);
        }
        return nonEqual == 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean areEqual(
        int[]  a,
        int[]  b) {
        if (a == b)
        {
            return true;
        }
        if (a == null || b == null)
        {
            return false;
        }
        if (a.length != b.length)
        {
            return false;
        }
        for (int i = 0; i != a.length; i++)
        {
            if (a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(
        byte[] array,
        byte value) {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(
        long[] array,
        long value) {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(
        short[] array, 
        short value) {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(byte[] data) {
        if (data == null)
        {
            return 0;
        }
        int i = data.length;
        int hc = i + 1;
        while (--i >= 0)
        {
            hc *= 257;
            hc ^= data[i];
        }
        return hc;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] clone(byte[] data) {
        if (data == null)
        {
            return null;
        }
        byte[] copy = new byte[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return copy;
    }

    
    @DSModeled(DSC.SAFE)
    public static int[] clone(int[] data) {
        if (data == null)
        {
            return null;
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return copy;
    }

    
}

