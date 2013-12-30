package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class Multiplication {

    // BEGIN android-note: multiply has been removed in favor of using OpenSSL BIGNUM
    // END android-note

    /**
     * Multiplies a number by a positive integer.
     * @param val an arbitrary {@code BigInteger}
     * @param factor a positive {@code int} number
     * @return {@code val * factor}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.021 -0500", hash_original_method = "D1D350F2DDD3147BCAFA3C9F1D37A8D5", hash_generated_method = "69BD9BFC77D63852CB66187408365DAF")
    
static BigInteger multiplyByPositiveInt(BigInteger val, int factor) {
        BigInt bi = val.getBigInt().copy();
        bi.multiplyByPositiveInt(factor);
        return new BigInteger(bi);
    }

    /**
     * Multiplies a number by a power of ten.
     * This method is used in {@code BigDecimal} class.
     * @param val the number to be multiplied
     * @param exp a positive {@code long} exponent
     * @return {@code val * 10<sup>exp</sup>}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.024 -0500", hash_original_method = "546ADD18DFC665D3BFD1EC85F053ED92", hash_generated_method = "9625348A961D86F15E58A5E05C374BB1")
    
static BigInteger multiplyByTenPow(BigInteger val, long exp) {
        // PRE: exp >= 0
        return ((exp < tenPows.length)
        ? multiplyByPositiveInt(val, tenPows[(int)exp])
        : val.multiply(powerOf10(exp)));
    }

    /**
     * It calculates a power of ten, which exponent could be out of 32-bit range.
     * Note that internally this method will be used in the worst case with
     * an exponent equals to: {@code Integer.MAX_VALUE - Integer.MIN_VALUE}.
     * @param exp the exponent of power of ten, it must be positive.
     * @return a {@code BigInteger} with value {@code 10<sup>exp</sup>}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.027 -0500", hash_original_method = "2834F7E1D24878B9AB4D87659676BBDC", hash_generated_method = "41389D46E9EA9428D832026CA4A66826")
    
static BigInteger powerOf10(long exp) {
        // PRE: exp >= 0
        int intExp = (int)exp;
        // "SMALL POWERS"
        if (exp < bigTenPows.length) {
            // The largest power that fit in 'long' type
            return bigTenPows[intExp];
        } else if (exp <= 50) {
            // To calculate:    10^exp
            return BigInteger.TEN.pow(intExp);
        } else if (exp <= 1000) {
            // To calculate:    5^exp * 2^exp
            return bigFivePows[1].pow(intExp).shiftLeft(intExp);
        }
        // "LARGE POWERS"
        /*
         * To check if there is free memory to allocate a BigInteger of the
         * estimated size, measured in bytes: 1 + [exp / log10(2)]
         */
        long byteArraySize = 1 + (long)(exp / 2.4082399653118496);

        if (byteArraySize > Runtime.getRuntime().freeMemory()) {
            throw new ArithmeticException();
        }
        if (exp <= Integer.MAX_VALUE) {
            // To calculate:    5^exp * 2^exp
            return bigFivePows[1].pow(intExp).shiftLeft(intExp);
        }
        /*
         * "HUGE POWERS"
         *
         * This branch probably won't be executed since the power of ten is too
         * big.
         */
        // To calculate:    5^exp
        BigInteger powerOfFive = bigFivePows[1].pow(Integer.MAX_VALUE);
        BigInteger res = powerOfFive;
        long longExp = exp - Integer.MAX_VALUE;

        intExp = (int)(exp % Integer.MAX_VALUE);
        while (longExp > Integer.MAX_VALUE) {
            res = res.multiply(powerOfFive);
            longExp -= Integer.MAX_VALUE;
        }
        res = res.multiply(bigFivePows[1].pow(intExp));
        // To calculate:    5^exp << exp
        res = res.shiftLeft(Integer.MAX_VALUE);
        longExp = exp - Integer.MAX_VALUE;
        while (longExp > Integer.MAX_VALUE) {
            res = res.shiftLeft(Integer.MAX_VALUE);
            longExp -= Integer.MAX_VALUE;
        }
        res = res.shiftLeft(intExp);
        return res;
    }

    /**
     * Multiplies a number by a power of five.
     * This method is used in {@code BigDecimal} class.
     * @param val the number to be multiplied
     * @param exp a positive {@code int} exponent
     * @return {@code val * 5<sup>exp</sup>}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.030 -0500", hash_original_method = "DACF258463E816AF2E85D9BE7940A118", hash_generated_method = "1CDECBF10F6A15E44A7BD3691A4DDB13")
    
static BigInteger multiplyByFivePow(BigInteger val, int exp) {
        // PRE: exp >= 0
        if (exp < fivePows.length) {
            return multiplyByPositiveInt(val, fivePows[exp]);
        } else if (exp < bigFivePows.length) {
            return val.multiply(bigFivePows[exp]);
        } else {// Large powers of five
            return val.multiply(bigFivePows[1].pow(exp));
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.010 -0500", hash_original_field = "1850E48814F4623DD9E50F0CC854E005", hash_generated_field = "C62E9E46C29087DCE458B5F6F490C3C3")

    // /**
    //  * Break point in digits (number of {@code int} elements)
    //  * between Karatsuba and Pencil and Paper multiply.
    //  */
    // static final int whenUseKaratsuba = 63; // an heuristic value
    // END android-removed

    /**
     * An array with powers of ten that fit in the type {@code int}.
     * ({@code 10^0,10^1,...,10^9})
     */
    static final int[] tenPows = {
        1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.013 -0500", hash_original_field = "9137FA2EA0A151E9BB637201953058C3", hash_generated_field = "D326483DE454C972EE7633CD9D18E72D")

    static final int[] fivePows = {
        1, 5, 25, 125, 625, 3125, 15625, 78125, 390625,
        1953125, 9765625, 48828125, 244140625, 1220703125
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.015 -0500", hash_original_field = "8FBC6B3C74CCA7314360D25104ECC6C6", hash_generated_field = "EB8D9193DD0597CA202E65272FAA716C")

    static final BigInteger[] bigTenPows = new BigInteger[32];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.018 -0500", hash_original_field = "707B82BF5B5C4D56BFC99F1D55C0BF60", hash_generated_field = "E7F9D2BF2ACA064B6E42E8C0B0CF0EF9")

    static final BigInteger bigFivePows[] = new BigInteger[32];

    /** Just to denote that this class can't be instantiated. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.008 -0500", hash_original_method = "CE81298360999BF52006386DE7E36DBD", hash_generated_method = "3C7B22114503E6EA0B68A72F303C2BF0")
    
private Multiplication() {}
    static {
        int i;
        long fivePow = 1L;
        for (i = 0; i <= 18; i++) {
            bigFivePows[i] = BigInteger.valueOf(fivePow);
            bigTenPows[i] = BigInteger.valueOf(fivePow << i);
            fivePow *= 5;
        }
        for (; i < bigTenPows.length; i++) {
            bigFivePows[i] = bigFivePows[i - 1].multiply(bigFivePows[1]);
            bigTenPows[i] = bigTenPows[i - 1].multiply(BigInteger.TEN);
        }
    }
    
}

