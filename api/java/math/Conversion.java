package java.math;

// Droidsafe Imports
import droidsafe.annotations.*;





class Conversion {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.883 -0400", hash_original_method = "A600C72BC77DD5DD4F1CBED3B2E3D2F0", hash_generated_method = "80546BF6DE416F93FA5C3272886F6955")
    private  Conversion() {
        // ---------- Original Method ----------
    }

    
    static String bigInteger2String(BigInteger val, int radix) {
        val.prepareJavaRepresentation();
        int sign = val.sign;
        int numberLength = val.numberLength;
        int[] digits = val.digits;
        if (sign == 0) {
            return "0";
        }
        if (numberLength == 1) {
            int highDigit = digits[numberLength - 1];
            long v = highDigit & 0xFFFFFFFFL;
            if (sign < 0) {
                v = -v;
            }
            return Long.toString(v, radix);
        }
        if ((radix == 10) || (radix < Character.MIN_RADIX)
                || (radix > Character.MAX_RADIX)) {
            return val.toString();
        }
        double bitsForRadixDigit;
        bitsForRadixDigit = Math.log(radix) / Math.log(2);
        int resLengthInChars = (int) (val.abs().bitLength() / bitsForRadixDigit + ((sign < 0) ? 1
                : 0)) + 1;
        char[] result = new char[resLengthInChars];
        int currentChar = resLengthInChars;
        int resDigit;
        if (radix != 16) {
            int[] temp = new int[numberLength];
            System.arraycopy(digits, 0, temp, 0, numberLength);
            int tempLen = numberLength;
            int charsPerInt = digitFitInInt[radix];
            int i;
            int bigRadix = bigRadices[radix - 2];
            while (true) {
                resDigit = Division.divideArrayByInt(temp, temp, tempLen,
                        bigRadix);
                int previous = currentChar;
                do {
                    result[--currentChar] = Character.forDigit(
                            resDigit % radix, radix);
                } while (((resDigit /= radix) != 0) && (currentChar != 0));
                int delta = charsPerInt - previous + currentChar;
                for (i = 0; i < delta && currentChar > 0; i++) {
                    result[--currentChar] = '0';
                }
                for (i = tempLen - 1; (i > 0) && (temp[i] == 0); i--) {
                    ;
                }
                tempLen = i + 1;
                if ((tempLen == 1) && (temp[0] == 0)) { 
                    break;
                }
            }
        } else {
            for (int i = 0; i < numberLength; i++) {
                for (int j = 0; (j < 8) && (currentChar > 0); j++) {
                    resDigit = digits[i] >> (j << 2) & 0xf;
                    result[--currentChar] = Character.forDigit(resDigit, 16);
                }
            }
        }
        while (result[currentChar] == '0') {
            currentChar++;
        }
        if (sign == -1) {
            result[--currentChar] = '-';
        }
        return new String(result, currentChar, resLengthInChars - currentChar);
    }

    
    static String toDecimalScaledString(BigInteger val, int scale) {
        val.prepareJavaRepresentation();
        int sign = val.sign;
        int numberLength = val.numberLength;
        int[] digits = val.digits;
        int resLengthInChars;
        int currentChar;
        char[] result;
        if (sign == 0) {
            switch (scale) {
                case 0:
                    return "0";
                case 1:
                    return "0.0";
                case 2:
                    return "0.00";
                case 3:
                    return "0.000";
                case 4:
                    return "0.0000";
                case 5:
                    return "0.00000";
                case 6:
                    return "0.000000";
                default:
                    StringBuilder result1 = new StringBuilder();
                    if (scale < 0) {
                        result1.append("0E+");
                    } else {
                        result1.append("0E");
                    }
                    result1.append(-scale);
                    return result1.toString();
            }
        }
        resLengthInChars = numberLength * 10 + 1 + 7;
        result = new char[resLengthInChars + 1];
        currentChar = resLengthInChars;
        if (numberLength == 1) {
            int highDigit = digits[0];
            if (highDigit < 0) {
                long v = highDigit & 0xFFFFFFFFL;
                do {
                    long prev = v;
                    v /= 10;
                    result[--currentChar] = (char) (0x0030 + ((int) (prev - v * 10)));
                } while (v != 0);
            } else {
                int v = highDigit;
                do {
                    int prev = v;
                    v /= 10;
                    result[--currentChar] = (char) (0x0030 + (prev - v * 10));
                } while (v != 0);
            }
        } else {
            int[] temp = new int[numberLength];
            int tempLen = numberLength;
            System.arraycopy(digits, 0, temp, 0, tempLen);
            BIG_LOOP: while (true) {
                long result11 = 0;
                for (int i1 = tempLen - 1; i1 >= 0; i1--) {
                    long temp1 = (result11 << 32)
                            + (temp[i1] & 0xFFFFFFFFL);
                    long res = divideLongByBillion(temp1);
                    temp[i1] = (int) res;
                    result11 = (int) (res >> 32);
                }
                int resDigit = (int) result11;
                int previous = currentChar;
                do {
                    result[--currentChar] = (char) (0x0030 + (resDigit % 10));
                } while (((resDigit /= 10) != 0) && (currentChar != 0));
                int delta = 9 - previous + currentChar;
                for (int i = 0; (i < delta) && (currentChar > 0); i++) {
                    result[--currentChar] = '0';
                }
                int j = tempLen - 1;
                for (; temp[j] == 0; j--) {
                    if (j == 0) { 
                        break BIG_LOOP;
                    }
                }
                tempLen = j + 1;
            }
            while (result[currentChar] == '0') {
                currentChar++;
            }
        }
        boolean negNumber = (sign < 0);
        int exponent = resLengthInChars - currentChar - scale - 1;
        if (scale == 0) {
            if (negNumber) {
                result[--currentChar] = '-';
            }
            return new String(result, currentChar, resLengthInChars
                    - currentChar);
        }
        if ((scale > 0) && (exponent >= -6)) {
            if (exponent >= 0) {
                int insertPoint = currentChar + exponent;
                for (int j = resLengthInChars - 1; j >= insertPoint; j--) {
                    result[j + 1] = result[j];
                }
                result[++insertPoint] = '.';
                if (negNumber) {
                    result[--currentChar] = '-';
                }
                return new String(result, currentChar, resLengthInChars
                        - currentChar + 1);
            }
            for (int j = 2; j < -exponent + 1; j++) {
                result[--currentChar] = '0';
            }
            result[--currentChar] = '.';
            result[--currentChar] = '0';
            if (negNumber) {
                result[--currentChar] = '-';
            }
            return new String(result, currentChar, resLengthInChars
                    - currentChar);
        }
        int startPoint = currentChar + 1;
        int endPoint = resLengthInChars;
        StringBuilder result1 = new StringBuilder(16 + endPoint - startPoint);
        if (negNumber) {
            result1.append('-');
        }
        if (endPoint - startPoint >= 1) {
            result1.append(result[currentChar]);
            result1.append('.');
            result1.append(result, currentChar + 1, resLengthInChars
                    - currentChar - 1);
        } else {
            result1.append(result, currentChar, resLengthInChars
                    - currentChar);
        }
        result1.append('E');
        if (exponent > 0) {
            result1.append('+');
        }
        result1.append(Integer.toString(exponent));
        return result1.toString();
    }

    
    static String toDecimalScaledString(long value, int scale) {
        int resLengthInChars;
        int currentChar;
        char[] result;
        boolean negNumber = value < 0;
        if(negNumber) {
            value = -value;
        }
        if (value == 0) {
            switch (scale) {
                case 0: return "0";
                case 1: return "0.0";
                case 2: return "0.00";
                case 3: return "0.000";
                case 4: return "0.0000";
                case 5: return "0.00000";
                case 6: return "0.000000";
                default:
                    StringBuilder result1 = new StringBuilder();
                    if (scale  < 0) {
                        result1.append("0E+");
                    } else {
                        result1.append("0E");
                    }
                    result1.append( (scale == Integer.MIN_VALUE) ? "2147483648" : Integer.toString(-scale));
                    return result1.toString();
            }
        }
        resLengthInChars = 18;
        result = new char[resLengthInChars+1];
        currentChar = resLengthInChars;
        long v = value;
        do {
            long prev = v;
            v /= 10;
            result[--currentChar] = (char) (0x0030 + (prev - v * 10));
        } while (v != 0);
        long exponent = (long)resLengthInChars - (long)currentChar - scale - 1L;
        if (scale == 0) {
            if (negNumber) {
                result[--currentChar] = '-';
            }
            return new String(result, currentChar, resLengthInChars - currentChar);
        }
        if (scale > 0 && exponent >= -6) {
            if (exponent >= 0) {
                int insertPoint = currentChar + (int) exponent ;
                for (int j=resLengthInChars-1; j>=insertPoint; j--) {
                    result[j+1] = result[j];
                }
                result[++insertPoint]='.';
                if (negNumber) {
                    result[--currentChar] = '-';
                }
                return new String(result, currentChar, resLengthInChars - currentChar + 1);
            }
            for (int j = 2; j < -exponent + 1; j++) {
                result[--currentChar] = '0';
            }
            result[--currentChar] = '.';
            result[--currentChar] = '0';
            if (negNumber) {
                result[--currentChar] = '-';
            }
            return new String(result, currentChar, resLengthInChars - currentChar);
        }
        int startPoint = currentChar + 1;
        int endPoint = resLengthInChars;
        StringBuilder result1 = new StringBuilder(16 + endPoint - startPoint);
        if (negNumber) {
            result1.append('-');
        }
        if (endPoint - startPoint >= 1) {
            result1.append(result[currentChar]);
            result1.append('.');
            result1.append(result,currentChar+1,resLengthInChars - currentChar-1);
        } else {
            result1.append(result,currentChar,resLengthInChars - currentChar);
        }
        result1.append('E');
        if (exponent > 0) {
            result1.append('+');
        }
        result1.append(Long.toString(exponent));
        return result1.toString();
    }

    
    @DSModeled(DSC.SAFE)
    static long divideLongByBillion(long a) {
        long quot;
        long rem;
        if (a >= 0) {
            long bLong = 1000000000L;
            quot = (a / bLong);
            rem = (a % bLong);
        } else {
            long aPos = a >>> 1;
            long bPos = 1000000000L >>> 1;
            quot = aPos / bPos;
            rem = aPos % bPos;
            rem = (rem << 1) + (a & 1);
        }
        return ((rem << 32) | (quot & 0xFFFFFFFFL));
    }

    
    static double bigInteger2Double(BigInteger val) {
        val.prepareJavaRepresentation();
        if ((val.numberLength < 2)
                || ((val.numberLength == 2) && (val.digits[1] > 0))) {
            return val.longValue();
        }
        if (val.numberLength > 32) {
            return ((val.sign > 0) ? Double.POSITIVE_INFINITY
                    : Double.NEGATIVE_INFINITY);
        }
        int bitLen = val.abs().bitLength();
        long exponent = bitLen - 1;
        int delta = bitLen - 54;
        long lVal = val.abs().shiftRight(delta).longValue();
        long mantissa = lVal & 0x1FFFFFFFFFFFFFL;
        if (exponent == 1023) {
            if (mantissa == 0X1FFFFFFFFFFFFFL) {
                return ((val.sign > 0) ? Double.POSITIVE_INFINITY
                        : Double.NEGATIVE_INFINITY);
            }
            if (mantissa == 0x1FFFFFFFFFFFFEL) {
                return ((val.sign > 0) ? Double.MAX_VALUE : -Double.MAX_VALUE);
            }
        }
        if (((mantissa & 1) == 1)
                && (((mantissa & 2) == 2) || BitLevel.nonZeroDroppedBits(delta,
                        val.digits))) {
            mantissa += 2;
        }
        mantissa >>= 1;
        long resSign = (val.sign < 0) ? 0x8000000000000000L : 0;
        exponent = ((1023 + exponent) << 52) & 0x7FF0000000000000L;
        long result = resSign | exponent | mantissa;
        return Double.longBitsToDouble(result);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.885 -0400", hash_original_field = "79CEEB0B96E31706DC35916021293954", hash_generated_field = "84ACB74AE0C2E46DB3D63D4F9B7B0A72")

    static final int[] digitFitInInt = { -1, -1, 31, 19, 15, 13, 11,
            11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 5 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.885 -0400", hash_original_field = "FC1884A674814367F99D68DA056FBF33", hash_generated_field = "BD1A65B06765EC59F73D0719049ECD1B")

    static final int[] bigRadices = { -2147483648, 1162261467,
            1073741824, 1220703125, 362797056, 1977326743, 1073741824,
            387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056,
            170859375, 268435456, 410338673, 612220032, 893871739, 1280000000,
            1801088541, 113379904, 148035889, 191102976, 244140625, 308915776,
            387420489, 481890304, 594823321, 729000000, 887503681, 1073741824,
            1291467969, 1544804416, 1838265625, 60466176 };
}

