package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Arrays {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.182 -0500", hash_original_method = "0A5BBE2F40A2BF8386730633F8545D7C", hash_generated_method = "D07E20A7E314AAC5ABD67A774D681E7E")
    
public static boolean areEqual(
        boolean[]  a,
        boolean[]  b)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.184 -0500", hash_original_method = "B189D0388D5D29FD80480A82D08D188D", hash_generated_method = "7727E29C471F7F7F949AC9BDCFFFB5ED")
    
public static boolean areEqual(
        char[]  a,
        char[]  b)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.188 -0500", hash_original_method = "CA13BC2287B7D60011DE188EA9367333", hash_generated_method = "A51B180D0483C08161CF59A6D4ECF9A6")
    
public static boolean areEqual(
        byte[]  a,
        byte[]  b)
    {
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

    /**
     * A constant time equals comparison - does not terminate early if
     * test will fail.
     *
     * @param a first array
     * @param b second array
     * @return true if arrays equal, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.190 -0500", hash_original_method = "9444E4DD6F96D0E4E7D1939FD8BB2A49", hash_generated_method = "61BC4C7C6279566227BA9078B67FA7D5")
    
public static boolean constantTimeAreEqual(
        byte[]  a,
        byte[]  b)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.193 -0500", hash_original_method = "5F7CCAC0CFC7EFDF16A6B78FD876A3EE", hash_generated_method = "2B31B6CDD73242E4585CCA96E8CB6B6A")
    
public static boolean areEqual(
        int[]  a,
        int[]  b)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.195 -0500", hash_original_method = "B36EFEED8A01C5AB548445C2A30D3515", hash_generated_method = "AB254B7381DE3B17EA718AC261CF38C6")
    
public static void fill(
        byte[] array,
        byte value)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.198 -0500", hash_original_method = "8C25963DC1F5FD75F75FC8C46F2D8080", hash_generated_method = "2AECEAB147DF1422DFD870892004A44E")
    
public static void fill(
        long[] array,
        long value)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.200 -0500", hash_original_method = "0C56D37E9DF08871E792A0F50E2C2D13", hash_generated_method = "1CF19802A5E86A6D8957B67EF29CF63E")
    
public static void fill(
        short[] array, 
        short value)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.202 -0500", hash_original_method = "41ED5BDF732370E7DAEC26CE0F888CDF", hash_generated_method = "6F4A8B7D24A95E6A3925C8E871A87F81")
    
public static int hashCode(byte[] data)
    {
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.205 -0500", hash_original_method = "026AC3542A4584C5DCDB37498D68098A", hash_generated_method = "D08B8A223E6B804F20A45133E236DA0D")
    
public static byte[] clone(byte[] data)
    {
        if (data == null)
        {
            return null;
        }
        byte[] copy = new byte[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.207 -0500", hash_original_method = "E3F88A3A23C0DED049A1D137C995F15F", hash_generated_method = "50F610FC6964A220853F3FD0C7421428")
    
public static int[] clone(int[] data)
    {
        if (data == null)
        {
            return null;
        }
        int[] copy = new int[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.180 -0500", hash_original_method = "F55A33B7721183458366770FE1A5E43D", hash_generated_method = "CD4220DCAB9E3401D982212A79ABD6BB")
    
private Arrays() 
    {
        // static class, hide constructor
    }
    
}

