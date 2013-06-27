package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.761 -0400", hash_original_method = "25F257C0960313729C88DA7CF764C995", hash_generated_method = "25F257C0960313729C88DA7CF764C995")
    public BigIntegers ()
    {
        //Synthesized constructor
    }


        public static byte[] asUnsignedByteArray(
        BigInteger value) {
        byte[] bytes = value.toByteArray();
        if (bytes[0] == 0)
        {
            byte[] tmp = new byte[bytes.length - 1];
            System.arraycopy(bytes, 1, tmp, 0, tmp.length);
            return tmp;
        }
        return bytes;
    }

    
        public static BigInteger createRandomInRange(
        BigInteger      min,
        BigInteger      max,
        SecureRandom    random) {
        int cmp = min.compareTo(max);
        if (cmp >= 0)
        {
            if (cmp > 0)
            {
                throw new IllegalArgumentException("'min' may not be greater than 'max'");
            }
            return min;
        }
        if (min.bitLength() > max.bitLength() / 2)
        {
            return createRandomInRange(ZERO, max.subtract(min), random).add(min);
        }
        for (int i = 0; i < MAX_ITERATIONS; ++i)
        {
            BigInteger x = new BigInteger(max.bitLength(), random);
            if (x.compareTo(min) >= 0 && x.compareTo(max) <= 0)
            {
                return x;
            }
        }
        return new BigInteger(max.subtract(min).bitLength() - 1, random).add(min);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.762 -0400", hash_original_field = "AEE001A4600AEC87175F78D964478592", hash_generated_field = "B37656F8214FF2F91927D0ABFDD7EC0F")

    private static int MAX_ITERATIONS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.762 -0400", hash_original_field = "A91935AA575A89027DDF671EC93CB686", hash_generated_field = "3D5B51C5FD7F9AEE6A55D63936A8551D")

    private static BigInteger ZERO = BigInteger.valueOf(0);
}

