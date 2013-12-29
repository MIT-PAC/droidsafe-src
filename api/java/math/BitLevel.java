package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




class BitLevel {

    /** @see BigInteger#bitLength() */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.243 -0500", hash_original_method = "2F7599C32F2FAEF59189399723BAD228", hash_generated_method = "72CB16BF55ED2F3ECE35F7218708DFCF")
    static int bitLength(BigInteger val) {
        val.prepareJavaRepresentation();
        if (val.sign == 0) {
            return 0;
        }
        int bLength = (val.numberLength << 5);
        int highDigit = val.digits[val.numberLength - 1];

        if (val.sign < 0) {
            int i = val.getFirstNonzeroDigit();
            // We reduce the problem to the positive case.
            if (i == val.numberLength - 1) {
                highDigit--;
            }
        }
        // Subtracting all sign bits
        bLength -= Integer.numberOfLeadingZeros(highDigit);
        return bLength;
    }

    /** @see BigInteger#bitCount() */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.244 -0500", hash_original_method = "1CAE1E4F93461B8C16860426843CE467", hash_generated_method = "2FB08135846134084293FF49F808EDD2")
    static int bitCount(BigInteger val) {
        val.prepareJavaRepresentation();
        int bCount = 0;

        if (val.sign == 0) {
            return 0;
        }

        int i = val.getFirstNonzeroDigit();
        if (val.sign > 0) {
            for ( ; i < val.numberLength; i++) {
                bCount += Integer.bitCount(val.digits[i]);
            }
        } else {// (sign < 0)
            // this digit absorbs the carry
            bCount += Integer.bitCount(-val.digits[i]);
            for (i++; i < val.numberLength; i++) {
                bCount += Integer.bitCount(~val.digits[i]);
            }
            // We take the complement sum:
            bCount = (val.numberLength << 5) - bCount;
        }
        return bCount;
    }

    /**
     * Performs a fast bit testing for positive numbers. The bit to to be tested
     * must be in the range {@code [0, val.bitLength()-1]}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.244 -0500", hash_original_method = "7EEFC94F9285122B25B4A50FCB40668F", hash_generated_method = "7063A00711C2AFDF8C3CD8177B2DB9EB")
    static boolean testBit(BigInteger val, int n) {
        val.prepareJavaRepresentation();
        // PRE: 0 <= n < val.bitLength()
        return ((val.digits[n >> 5] & (1 << (n & 31))) != 0);
    }

    /**
     * Check if there are 1s in the lowest bits of this BigInteger
     *
     * @param numberOfBits the number of the lowest bits to check
     * @return false if all bits are 0s, true otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.245 -0500", hash_original_method = "B955791C600CF45FD34660F52B29F1B8", hash_generated_method = "F7DC2D7AD973E0F4C209F9249226E78D")
    static boolean nonZeroDroppedBits(int numberOfBits, int[] digits) {
        int intCount = numberOfBits >> 5;
        int bitCount = numberOfBits & 31;
        int i;

        for (i = 0; (i < intCount) && (digits[i] == 0); i++) {
            ;
        }
        return ((i != intCount) || (digits[i] << (32 - bitCount) != 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.246 -0500", hash_original_method = "F0ED4B2FB109B86B7608CBC5C4FC2788", hash_generated_method = "FE7D7A182CA425C17D8E692F46C58C85")
    static void shiftLeftOneBit(int[] result, int[] source, int srcLen) {
        int carry = 0;
        for (int i = 0; i < srcLen; i++) {
            int val = source[i];
            result[i] = (val << 1) | carry;
            carry = val >>> 31;
        }
        if(carry != 0) {
            result[srcLen] = carry;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.247 -0500", hash_original_method = "ACB848E4EB2EF5584AA5A58340191858", hash_generated_method = "66CB73735CC02178EEFF9CC16D7D17A0")
    static BigInteger shiftLeftOneBit(BigInteger source) {
        source.prepareJavaRepresentation();
        int srcLen = source.numberLength;
        int resLen = srcLen + 1;
        int[] resDigits = new int[resLen];
        shiftLeftOneBit(resDigits, source.digits, srcLen);
        return new BigInteger(source.sign, resLen, resDigits);
    }

    /** @see BigInteger#shiftRight(int) */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.248 -0500", hash_original_method = "0CAF49D8BF0C1F380E0449E5FD0E2C1B", hash_generated_method = "343FA97311263B42F11D358B8B436B13")
    static BigInteger shiftRight(BigInteger source, int count) {
        source.prepareJavaRepresentation();
        int intCount = count >> 5; // count of integers
        count &= 31; // count of remaining bits
        if (intCount >= source.numberLength) {
            return ((source.sign < 0) ? BigInteger.MINUS_ONE : BigInteger.ZERO);
        }
        int i;
        int resLength = source.numberLength - intCount;
        int[] resDigits = new int[resLength + 1];

        shiftRight(resDigits, resLength, source.digits, intCount, count);
        if (source.sign < 0) {
            // Checking if the dropped bits are zeros (the remainder equals to
            // 0)
            for (i = 0; (i < intCount) && (source.digits[i] == 0); i++) {
                ;
            }
            // If the remainder is not zero, add 1 to the result
            if ((i < intCount)
                    || ((count > 0) && ((source.digits[i] << (32 - count)) != 0))) {
                for (i = 0; (i < resLength) && (resDigits[i] == -1); i++) {
                    resDigits[i] = 0;
                }
                if (i == resLength) {
                    resLength++;
                }
                resDigits[i]++;
            }
        }
        return new BigInteger(source.sign, resLength, resDigits);
    }

    /**
     * Shifts right an array of integers. Total shift distance in bits is
     * intCount * 32 + count.
     *
     * @param result
     *            the destination array
     * @param resultLen
     *            the destination array's length
     * @param source
     *            the source array
     * @param intCount
     *            the number of elements to be shifted
     * @param count
     *            the number of bits to be shifted
     * @return dropped bit's are all zero (i.e. remaider is zero)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.249 -0500", hash_original_method = "A35A1609E030A9DBE1C939F4F901D824", hash_generated_method = "FB5D0521166E9471DD89C7CA421592ED")
    static boolean shiftRight(int[] result, int resultLen, int[] source, int intCount, int count) {
        int i;
        boolean allZero = true;
        for (i = 0; i < intCount; i++)
            allZero &= source[i] == 0;
        if (count == 0) {
            System.arraycopy(source, intCount, result, 0, resultLen);
            i = resultLen;
        } else {
            int leftShiftCount = 32 - count;

            allZero &= ( source[i] << leftShiftCount ) == 0;
            for (i = 0; i < resultLen - 1; i++) {
                result[i] = ( source[i + intCount] >>> count )
                | ( source[i + intCount + 1] << leftShiftCount );
            }
            result[i] = ( source[i + intCount] >>> count );
            i++;
        }

        return allZero;
    }


    /**
     * Performs a flipBit on the BigInteger, returning a BigInteger with the the
     * specified bit flipped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.250 -0500", hash_original_method = "BE8327B0577A60EC2E498BB75874DAB6", hash_generated_method = "9E401BE439EAF230A739D78ABA17C0AD")
    static BigInteger flipBit(BigInteger val, int n){
        val.prepareJavaRepresentation();
        int resSign = (val.sign == 0) ? 1 : val.sign;
        int intCount = n >> 5;
        int bitN = n & 31;
        int resLength = Math.max(intCount + 1, val.numberLength) + 1;
        int[] resDigits = new int[resLength];
        int i;

        int bitNumber = 1 << bitN;
        System.arraycopy(val.digits, 0, resDigits, 0, val.numberLength);

        if (val.sign < 0) {
            if (intCount >= val.numberLength) {
                resDigits[intCount] = bitNumber;
            } else {
                //val.sign<0 y intCount < val.numberLength
                int firstNonZeroDigit = val.getFirstNonzeroDigit();
                if (intCount > firstNonZeroDigit) {
                    resDigits[intCount] ^= bitNumber;
                } else if (intCount < firstNonZeroDigit) {
                    resDigits[intCount] = -bitNumber;
                    for (i=intCount + 1; i < firstNonZeroDigit; i++) {
                        resDigits[i]=-1;
                    }
                    resDigits[i] = resDigits[i]--;
                } else {
                    i = intCount;
                    resDigits[i] = -((-resDigits[intCount]) ^ bitNumber);
                    if (resDigits[i] == 0) {
                        for (i++; resDigits[i] == -1 ; i++) {
                            resDigits[i] = 0;
                        }
                        resDigits[i]++;
                    }
                }
            }
        } else {//case where val is positive
            resDigits[intCount] ^= bitNumber;
        }
        return new BigInteger(resSign, resLength, resDigits);
    }

    /** Just to denote that this class can't be instantiated. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:28.242 -0500", hash_original_method = "128537E4DA15C667DA21928E26685CE7", hash_generated_method = "0C4F5730701BF797962122ED4C2B7AFF")
    private BitLevel() {}

    
}

