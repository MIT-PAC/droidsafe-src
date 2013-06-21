package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class Multiplication {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.718 -0400", hash_original_method = "CE81298360999BF52006386DE7E36DBD", hash_generated_method = "C1903448A4FC57F0699C8C4004F3EB1D")
    @DSModeled(DSC.SAFE)
    private Multiplication() {
        // ---------- Original Method ----------
    }

    
        static BigInteger multiplyByPositiveInt(BigInteger val, int factor) {
        BigInt bi = val.getBigInt().copy();
        bi.multiplyByPositiveInt(factor);
        return new BigInteger(bi);
    }

    
        static BigInteger multiplyByTenPow(BigInteger val, long exp) {
        return ((exp < tenPows.length)
        ? multiplyByPositiveInt(val, tenPows[(int)exp])
        : val.multiply(powerOf10(exp)));
    }

    
        static BigInteger powerOf10(long exp) {
        int intExp = (int)exp;
        if (exp < bigTenPows.length) {
            return bigTenPows[intExp];
        } else if (exp <= 50) {
            return BigInteger.TEN.pow(intExp);
        } else if (exp <= 1000) {
            return bigFivePows[1].pow(intExp).shiftLeft(intExp);
        }
        long byteArraySize = 1 + (long)(exp / 2.4082399653118496);
        if (byteArraySize > Runtime.getRuntime().freeMemory()) {
            throw new ArithmeticException();
        }
        if (exp <= Integer.MAX_VALUE) {
            return bigFivePows[1].pow(intExp).shiftLeft(intExp);
        }
        BigInteger powerOfFive = bigFivePows[1].pow(Integer.MAX_VALUE);
        BigInteger res = powerOfFive;
        long longExp = exp - Integer.MAX_VALUE;
        intExp = (int)(exp % Integer.MAX_VALUE);
        while (longExp > Integer.MAX_VALUE) {
            res = res.multiply(powerOfFive);
            longExp -= Integer.MAX_VALUE;
        }
        res = res.multiply(bigFivePows[1].pow(intExp));
        res = res.shiftLeft(Integer.MAX_VALUE);
        longExp = exp - Integer.MAX_VALUE;
        while (longExp > Integer.MAX_VALUE) {
            res = res.shiftLeft(Integer.MAX_VALUE);
            longExp -= Integer.MAX_VALUE;
        }
        res = res.shiftLeft(intExp);
        return res;
    }

    
        static BigInteger multiplyByFivePow(BigInteger val, int exp) {
        if (exp < fivePows.length) {
            return multiplyByPositiveInt(val, fivePows[exp]);
        } else if (exp < bigFivePows.length) {
            return val.multiply(bigFivePows[exp]);
        } else {
            return val.multiply(bigFivePows[1].pow(exp));
        }
    }

    
    static final int[] tenPows = {
        1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
    };
    static final int[] fivePows = {
        1, 5, 25, 125, 625, 3125, 15625, 78125, 390625,
        1953125, 9765625, 48828125, 244140625, 1220703125
    };
    static final BigInteger[] bigTenPows = new BigInteger[32];
    static final BigInteger bigFivePows[] = new BigInteger[32];
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

