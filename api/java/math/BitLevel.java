package java.math;

// Droidsafe Imports
import droidsafe.annotations.*;




class BitLevel {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.834 -0400", hash_original_method = "128537E4DA15C667DA21928E26685CE7", hash_generated_method = "8EBB079821786F638DB2E6786CCDDD62")
    private  BitLevel() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    static int bitLength(BigInteger val) {
        val.prepareJavaRepresentation();
        if (val.sign == 0) {
            return 0;
        }
        int bLength = (val.numberLength << 5);
        int highDigit = val.digits[val.numberLength - 1];
        if (val.sign < 0) {
            int i = val.getFirstNonzeroDigit();
            if (i == val.numberLength - 1) {
                highDigit--;
            }
        }
        bLength -= Integer.numberOfLeadingZeros(highDigit);
        return bLength;
    }

    
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
        } else {
            bCount += Integer.bitCount(-val.digits[i]);
            for (i++; i < val.numberLength; i++) {
                bCount += Integer.bitCount(~val.digits[i]);
            }
            bCount = (val.numberLength << 5) - bCount;
        }
        return bCount;
    }

    
    static boolean testBit(BigInteger val, int n) {
        val.prepareJavaRepresentation();
        return ((val.digits[n >> 5] & (1 << (n & 31))) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    static boolean nonZeroDroppedBits(int numberOfBits, int[] digits) {
        int intCount = numberOfBits >> 5;
        int bitCount = numberOfBits & 31;
        int i;
        for (i = 0; (i < intCount) && (digits[i] == 0); i++) {
            ;
        }
        return ((i != intCount) || (digits[i] << (32 - bitCount) != 0));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    static BigInteger shiftLeftOneBit(BigInteger source) {
        source.prepareJavaRepresentation();
        int srcLen = source.numberLength;
        int resLen = srcLen + 1;
        int[] resDigits = new int[resLen];
        shiftLeftOneBit(resDigits, source.digits, srcLen);
        return new BigInteger(source.sign, resLen, resDigits);
    }

    
    @DSModeled(DSC.BAN)
    static BigInteger shiftRight(BigInteger source, int count) {
        source.prepareJavaRepresentation();
        int intCount = count >> 5;
        count &= 31;
        if (intCount >= source.numberLength) {
            return ((source.sign < 0) ? BigInteger.MINUS_ONE : BigInteger.ZERO);
        }
        int i;
        int resLength = source.numberLength - intCount;
        int[] resDigits = new int[resLength + 1];
        shiftRight(resDigits, resLength, source.digits, intCount, count);
        if (source.sign < 0) {
            for (i = 0; (i < intCount) && (source.digits[i] == 0); i++) {
                ;
            }
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

    
    @DSModeled(DSC.BAN)
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

    
    static BigInteger flipBit(BigInteger val, int n) {
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
        } else {
            resDigits[intCount] ^= bitNumber;
        }
        return new BigInteger(resSign, resLength, resDigits);
    }

    
}

