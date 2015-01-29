package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers {

    /**
     * Return the passed in value as an unsigned byte array.
     * 
     * @param value value to be converted.
     * @return a byte array without a leading zero byte if present in the signed encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.410 -0500", hash_original_method = "979A867C88CED149A8B0CC0C806AA09A", hash_generated_method = "37BDC297138C5562FDE593E32F4BDB8E")
    
public static byte[] asUnsignedByteArray(
        BigInteger value)
    {
        byte[] bytes = value.toByteArray();
        
        if (bytes[0] == 0)
        {
            byte[] tmp = new byte[bytes.length - 1];
            
            System.arraycopy(bytes, 1, tmp, 0, tmp.length);
            
            return tmp;
        }
        
        return bytes;
    }

    /**
     * Return a random BigInteger not less than 'min' and not greater than 'max'
     * 
     * @param min the least value that may be generated
     * @param max the greatest value that may be generated
     * @param random the source of randomness
     * @return a random BigInteger value in the range [min,max]
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.413 -0500", hash_original_method = "53B55470D05734C403FE921C557119F5", hash_generated_method = "F2963150F2456D21A09B08F298769583")
    
public static BigInteger createRandomInRange(
        BigInteger      min,
        BigInteger      max,
        SecureRandom    random)
    {
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

        // fall back to a faster (restricted) method
        return new BigInteger(max.subtract(min).bitLength() - 1, random).add(min);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.405 -0500", hash_original_field = "1D0D46B958439834140E299F6789A7DD", hash_generated_field = "859C82FDE2952F49F9B9C155801362CA")

    private static final int MAX_ITERATIONS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.407 -0500", hash_original_field = "022E24154725CD5F5585BBEA8F639A54", hash_generated_field = "751997057E9748B7597C8C19A2A57677")

    private static final BigInteger ZERO = BigInteger.valueOf(0);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.169 -0400", hash_original_method = "25F257C0960313729C88DA7CF764C995", hash_generated_method = "25F257C0960313729C88DA7CF764C995")
    public BigIntegers ()
    {
        //Synthesized constructor
    }
}

