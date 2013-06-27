package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class Logical {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.429 -0400", hash_original_method = "E0A3DE35724A26B6DFF41660E2732E13", hash_generated_method = "F49FF7A55DC565304B6F8190D337CD80")
    private  Logical() {
        // ---------- Original Method ----------
    }

    
        static BigInteger not(BigInteger val) {
        if (val.sign == 0) {
            return BigInteger.MINUS_ONE;
        }
        if (val.equals(BigInteger.MINUS_ONE)) {
            return BigInteger.ZERO;
        }
        int[] resDigits = new int[val.numberLength + 1];
        int i;
        if (val.sign > 0) {
            if (val.digits[val.numberLength - 1] != -1) {
                for (i = 0; val.digits[i] == -1; i++) {
                    ;
                }
            } else {
                for (i = 0; (i < val.numberLength) && (val.digits[i] == -1); i++) {
                    ;
                }
                if (i == val.numberLength) {
                    resDigits[i] = 1;
                    return new BigInteger(-val.sign, i + 1, resDigits);
                }
            }
        } else {
            for (i = 0; val.digits[i] == 0; i++) {
                resDigits[i] = -1;
            }
        }
        resDigits[i] = val.digits[i] + val.sign;
        for (i++; i < val.numberLength; i++) {
            resDigits[i] = val.digits[i];
        }
        return new BigInteger(-val.sign, i, resDigits);
    }

    
        static BigInteger and(BigInteger val, BigInteger that) {
        if (that.sign == 0 || val.sign == 0) {
            return BigInteger.ZERO;
        }
        if (that.equals(BigInteger.MINUS_ONE)){
            return val;
        }
        if (val.equals(BigInteger.MINUS_ONE)) {
            return that;
        }
        if (val.sign > 0) {
            if (that.sign > 0) {
                return andPositive(val, that);
            } else {
                return andDiffSigns(val, that);
            }
        } else {
            if (that.sign > 0) {
                return andDiffSigns(that, val);
            } else if (val.numberLength > that.numberLength) {
                return andNegative(val, that);
            } else {
                return andNegative(that, val);
            }
        }
    }

    
        static BigInteger andPositive(BigInteger val, BigInteger that) {
        int resLength = Math.min(val.numberLength, that.numberLength);
        int i = Math.max(val.getFirstNonzeroDigit(), that.getFirstNonzeroDigit());
        if (i >= resLength) {
            return BigInteger.ZERO;
        }
        int[] resDigits = new int[resLength];
        for ( ; i < resLength; i++) {
            resDigits[i] = val.digits[i] & that.digits[i];
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger andDiffSigns(BigInteger positive, BigInteger negative) {
        int iPos = positive.getFirstNonzeroDigit();
        int iNeg = negative.getFirstNonzeroDigit();
        if (iNeg >= positive.numberLength) {
            return BigInteger.ZERO;
        }
        int resLength = positive.numberLength;
        int[] resDigits = new int[resLength];
        int i = Math.max(iPos, iNeg);
        if (i == iNeg) {
            resDigits[i] = -negative.digits[i] & positive.digits[i];
            i++;
        }
        int limit = Math.min(negative.numberLength, positive.numberLength);
        for ( ; i < limit; i++) {
            resDigits[i] = ~negative.digits[i] & positive.digits[i];
        }
        if (i >= negative.numberLength) {
            for ( ; i < positive.numberLength; i++) {
                resDigits[i] = positive.digits[i];
            }
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger andNegative(BigInteger longer, BigInteger shorter) {
        int iLonger = longer.getFirstNonzeroDigit();
        int iShorter = shorter.getFirstNonzeroDigit();
        if (iLonger >= shorter.numberLength) {
            return longer;
        }
        int resLength;
        int[] resDigits;
        int i = Math.max(iShorter, iLonger);
        int digit;
        if (iShorter > iLonger) {
            digit = -shorter.digits[i] & ~longer.digits[i];
        } else if (iShorter < iLonger) {
            digit = ~shorter.digits[i] & -longer.digits[i];
        } else {
            digit = -shorter.digits[i] & -longer.digits[i];
        }
        if (digit == 0) {
            for (i++; i < shorter.numberLength && (digit = ~(longer.digits[i] | shorter.digits[i])) == 0; i++)
                ;  
            if (digit == 0) {
                for ( ; i < longer.numberLength && (digit = ~longer.digits[i]) == 0; i++)
                    ;
                if (digit == 0) {
                    resLength = longer.numberLength + 1;
                    resDigits = new int[resLength];
                    resDigits[resLength - 1] = 1;
                    return new BigInteger(-1, resLength, resDigits);
                }
            }
        }
        resLength = longer.numberLength;
        resDigits = new int[resLength];
        resDigits[i] = -digit;
        for (i++; i < shorter.numberLength; i++){
            resDigits[i] = longer.digits[i] | shorter.digits[i];
        }
        for ( ; i < longer.numberLength; i++){
            resDigits[i] = longer.digits[i];
        }
        return new BigInteger(-1, resLength, resDigits);
    }

    
        static BigInteger andNot(BigInteger val, BigInteger that) {
        if (that.sign == 0 ) {
            return val;
        }
        if (val.sign == 0) {
            return BigInteger.ZERO;
        }
        if (val.equals(BigInteger.MINUS_ONE)) {
            return that.not();
        }
        if (that.equals(BigInteger.MINUS_ONE)){
            return BigInteger.ZERO;
        }
        if (val.sign > 0) {
            if (that.sign > 0) {
                return andNotPositive(val, that);
            } else {
                return andNotPositiveNegative(val, that);
                    }
                } else {
            if (that.sign > 0) {
                return andNotNegativePositive(val, that);
            } else  {
                return andNotNegative(val, that);
            }
        }
    }

    
        static BigInteger andNotPositive(BigInteger val, BigInteger that) {
        int[] resDigits = new int[val.numberLength];
        int limit = Math.min(val.numberLength, that.numberLength);
        int i;
        for (i = val.getFirstNonzeroDigit(); i < limit; i++) {
            resDigits[i] = val.digits[i] & ~that.digits[i];
        }
        for ( ; i < val.numberLength; i++) {
            resDigits[i] = val.digits[i];
        }
        return new BigInteger(1, val.numberLength, resDigits);
    }

    
        static BigInteger andNotPositiveNegative(BigInteger positive, BigInteger negative) {
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();
        if (iNeg >= positive.numberLength) {
            return positive;
        }
        int resLength = Math.min(positive.numberLength, negative.numberLength);
        int[] resDigits = new int[resLength];
        int i = iPos;
        for ( ; i < iNeg; i++) {
            resDigits[i] = positive.digits[i];
        }
        if (i == iNeg) {
            resDigits[i] = positive.digits[i] & (negative.digits[i] - 1);
            i++;
        }
        for ( ; i < resLength; i++) {
            resDigits[i] = positive.digits[i] & negative.digits[i];
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger andNotNegativePositive(BigInteger negative, BigInteger positive) {
        int resLength;
        int[] resDigits;
        int limit;
        int digit;
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();
        if (iNeg >= positive.numberLength) {
            return negative;
        }
        resLength = Math.max(negative.numberLength, positive.numberLength);
        int i = iNeg;
        if (iPos > iNeg) {
            resDigits = new int[resLength];
            limit = Math.min(negative.numberLength, iPos);
            for ( ; i < limit; i++) {
                resDigits[i] = negative.digits[i];
            }
            if (i == negative.numberLength) {
                for (i = iPos; i < positive.numberLength; i++) {
                    resDigits[i] = positive.digits[i];
                }
            }
        } else {
            digit = -negative.digits[i] & ~positive.digits[i];
            if (digit == 0) {
                limit = Math.min(positive.numberLength, negative.numberLength);
                for (i++; i < limit && (digit = ~(negative.digits[i] | positive.digits[i])) == 0; i++)
                    ; 
                if (digit == 0) {
                    for ( ; i < positive.numberLength && (digit = ~positive.digits[i]) == 0; i++)
                        ; 
                    for ( ; i < negative.numberLength && (digit = ~negative.digits[i]) == 0; i++)
                        ; 
                    if (digit == 0) {
                        resLength++;
                        resDigits = new int[resLength];
                        resDigits[resLength - 1] = 1;
                        return new BigInteger(-1, resLength, resDigits);
                    }
                }
            }
                        resDigits = new int[resLength];
            resDigits[i] = -digit;
            i++;
                    }
        limit = Math.min(positive.numberLength, negative.numberLength);
        for ( ; i < limit; i++) {
            resDigits[i] = negative.digits[i] | positive.digits[i];
        }
        for ( ; i < negative.numberLength; i++) {
            resDigits[i] = negative.digits[i];
                }
        for ( ; i < positive.numberLength; i++) {
            resDigits[i] = positive.digits[i];
        }
        return new BigInteger(-1, resLength, resDigits);
    }

    
        static BigInteger andNotNegative(BigInteger val, BigInteger that) {
        int iVal = val.getFirstNonzeroDigit();
        int iThat = that.getFirstNonzeroDigit();
        if (iVal >= that.numberLength) {
            return BigInteger.ZERO;
        }
        int resLength = that.numberLength;
        int[] resDigits = new int[resLength];
        int limit;
        int i = iVal;
        if (iVal < iThat) {
            resDigits[i] = -val.digits[i];
            limit = Math.min(val.numberLength, iThat);
            for (i++; i < limit; i++) {
                resDigits[i] = ~val.digits[i];
            }
            if (i == val.numberLength) {
                for ( ; i < iThat; i++) {
                    resDigits[i] = -1;
                }
                resDigits[i] = that.digits[i] - 1;
        } else {
                resDigits[i] = ~val.digits[i] & (that.digits[i] - 1);
            }
        } else if (iThat < iVal ) {
            resDigits[i] = -val.digits[i] & that.digits[i];
        } else {
            resDigits[i] = -val.digits[i] & (that.digits[i] - 1);
            }
        limit = Math.min(val.numberLength, that.numberLength);
        for (i++; i < limit; i++) {
            resDigits[i] = ~val.digits[i] & that.digits[i];
        }
        for ( ; i < that.numberLength; i++) {
            resDigits[i] = that.digits[i];
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger or(BigInteger val, BigInteger that) {
        if (that.equals(BigInteger.MINUS_ONE) || val.equals(BigInteger.MINUS_ONE)) {
            return BigInteger.MINUS_ONE;
        }
        if (that.sign == 0) {
            return val;
        }
        if (val.sign == 0) {
            return that;
        }
        if (val.sign > 0) {
            if (that.sign > 0) {
                if (val.numberLength > that.numberLength) {
                    return orPositive(val, that);
                } else {
                    return orPositive(that, val);
                }
            } else {
                return orDiffSigns(val, that);
            }
        } else {
            if (that.sign > 0) {
                return orDiffSigns(that, val);
            } else if (that.getFirstNonzeroDigit() > val.getFirstNonzeroDigit()) {
                return orNegative(that, val);
            } else {
                return orNegative(val, that);
            }
        }
    }

    
        static BigInteger orPositive(BigInteger longer, BigInteger shorter) {
        int resLength = longer.numberLength;
        int[] resDigits = new int[resLength];
        int i;
        for (i = 0; i < shorter.numberLength; i++) {
            resDigits[i] = longer.digits[i] | shorter.digits[i];
        }
        for ( ; i < resLength; i++) {
            resDigits[i] = longer.digits[i];
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger orNegative(BigInteger val, BigInteger that) {
        int iThat = that.getFirstNonzeroDigit();
        int iVal = val.getFirstNonzeroDigit();
        int i;
        if (iVal >= that.numberLength) {
            return that;
        }else if (iThat >= val.numberLength) {
            return val;
        }
        int resLength = Math.min(val.numberLength, that.numberLength);
        int[] resDigits = new int[resLength];
        if (iThat == iVal) {
            resDigits[iVal] = -(-val.digits[iVal] | -that.digits[iVal]);
            i = iVal;
        } else {
            for (i = iThat; i < iVal; i++) {
                resDigits[i] = that.digits[i];
            }
            resDigits[i] = that.digits[i] & (val.digits[i] - 1);
        }
        for (i++; i < resLength; i++) {
            resDigits[i] = val.digits[i] & that.digits[i];
        }
        return new BigInteger(-1, resLength, resDigits);
    }

    
        static BigInteger orDiffSigns(BigInteger positive, BigInteger negative) {
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();
        int i;
        int limit;
        if (iPos >= negative.numberLength) {
            return negative;
        }
        int resLength = negative.numberLength;
        int[] resDigits = new int[resLength];
        if (iNeg < iPos ) {
            for (i = iNeg; i < iPos; i++) {
            resDigits[i] = negative.digits[i];
            }
        } else if (iPos < iNeg) {
            i = iPos;
            resDigits[i] = -positive.digits[i];
            limit = Math.min(positive.numberLength, iNeg);
            for (i++; i < limit; i++ ) {
                resDigits[i] = ~positive.digits[i];
            }
            if (i != positive.numberLength) {
                resDigits[i] = ~(-negative.digits[i] | positive.digits[i]);
            } else{
                  for (; i<iNeg; i++) {
                      resDigits[i] = -1;
                  }
                  resDigits[i] = negative.digits[i] - 1;
            }
            i++;
        } else {
            i = iPos;
            resDigits[i] = -(-negative.digits[i] | positive.digits[i]);
            i++;
        }
        limit = Math.min(negative.numberLength, positive.numberLength);
        for (; i < limit; i++) {
            resDigits[i] = negative.digits[i] & ~positive.digits[i];
        }
        for ( ; i < negative.numberLength; i++) {
            resDigits[i] = negative.digits[i];
        }
        return new BigInteger(-1, resLength, resDigits);
    }

    
        static BigInteger xor(BigInteger val, BigInteger that) {
        if (that.sign == 0) {
            return val;
        }
        if (val.sign == 0) {
            return that;
        }
        if (that.equals(BigInteger.MINUS_ONE)) {
            return val.not();
        }
        if (val.equals(BigInteger.MINUS_ONE)) {
            return that.not();
        }
        if (val.sign > 0) {
            if (that.sign > 0) {
                if (val.numberLength > that.numberLength) {
                    return xorPositive(val, that);
                } else {
                    return xorPositive(that, val);
                }
            } else {
                return xorDiffSigns(val, that);
            }
        } else {
            if (that.sign > 0) {
                return xorDiffSigns(that, val);
            } else if (that.getFirstNonzeroDigit() > val.getFirstNonzeroDigit()) {
                return xorNegative(that, val);
            } else {
                return xorNegative(val, that);
            }
        }
    }

    
        static BigInteger xorPositive(BigInteger longer, BigInteger shorter) {
        int resLength = longer.numberLength;
        int[] resDigits = new int[resLength];
        int i = Math.min(longer.getFirstNonzeroDigit(), shorter.getFirstNonzeroDigit());
        for ( ; i < shorter.numberLength; i++) {
            resDigits[i] = longer.digits[i] ^ shorter.digits[i];
        }
        for ( ; i < longer.numberLength; i++ ){
            resDigits[i] = longer.digits[i];
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger xorNegative(BigInteger val, BigInteger that) {
        int resLength = Math.max(val.numberLength, that.numberLength);
        int[] resDigits = new int[resLength];
        int iVal = val.getFirstNonzeroDigit();
        int iThat = that.getFirstNonzeroDigit();
        int i = iThat;
        int limit;
        if (iVal == iThat) {
            resDigits[i] = -val.digits[i] ^ -that.digits[i];
        } else {
            resDigits[i] = -that.digits[i];
            limit = Math.min(that.numberLength, iVal);
            for (i++; i < limit; i++) {
                resDigits[i] = ~that.digits[i];
            }
            if (i == that.numberLength) {
                for ( ;i < iVal; i++) {
                    resDigits[i] = -1;
                }
                resDigits[i] = val.digits[i] - 1;
            } else {
                resDigits[i] = -val.digits[i] ^ ~that.digits[i];
            }
        }
        limit = Math.min(val.numberLength, that.numberLength);
        for (i++; i < limit; i++) {
            resDigits[i] = val.digits[i] ^ that.digits[i];
        }
        for ( ; i < val.numberLength; i++) {
            resDigits[i] = val.digits[i] ;
        }
        for ( ; i < that.numberLength; i++) {
            resDigits[i] = that.digits[i];
        }
        return new BigInteger(1, resLength, resDigits);
    }

    
        static BigInteger xorDiffSigns(BigInteger positive, BigInteger negative) {
        int resLength = Math.max(negative.numberLength, positive.numberLength);
        int[] resDigits;
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();
        int i;
        int limit;
        if (iNeg < iPos) {
            resDigits = new int[resLength];
            i = iNeg;
            resDigits[i] = negative.digits[i];
            limit = Math.min(negative.numberLength, iPos);
            for (i++; i < limit; i++) {
                resDigits[i] = negative.digits[i];
            }
            if (i == negative.numberLength) {
                for ( ; i < positive.numberLength; i++) {
                    resDigits[i] = positive.digits[i];
                }
            }
        } else if (iPos < iNeg) {
            resDigits = new int[resLength];
            i = iPos;
            resDigits[i] = -positive.digits[i];
            limit = Math.min(positive.numberLength, iNeg);
            for (i++; i < limit; i++) {
                resDigits[i] = ~positive.digits[i];
            }
            if (i == iNeg) {
                resDigits[i] = ~(positive.digits[i] ^ -negative.digits[i]);
                i++;
            } else {
                for ( ; i < iNeg; i++) {
                    resDigits[i] = -1;
                }
                for ( ; i < negative.numberLength; i++) {
                    resDigits[i] = negative.digits[i];
                }
            }
                } else {
            i = iNeg;
            int digit = positive.digits[i] ^ -negative.digits[i];
            if (digit == 0) {
                limit = Math.min(positive.numberLength, negative.numberLength);
                for (i++; i < limit && (digit = positive.digits[i] ^ ~negative.digits[i]) == 0; i++)
                    ;
                if (digit == 0) {
                    for ( ; i < positive.numberLength && (digit = ~positive.digits[i]) == 0; i++)
                        ;
                    for ( ; i < negative.numberLength && (digit = ~negative.digits[i]) == 0; i++)
                        ;
                    if (digit == 0) {
                        resLength = resLength + 1;
                        resDigits = new int[resLength];
                        resDigits[resLength - 1] = 1;
                        return new BigInteger(-1, resLength, resDigits);
                }
            }
        }
            resDigits = new int[resLength];
            resDigits[i] = -digit;
            i++;
        }
        limit = Math.min(negative.numberLength, positive.numberLength);
        for ( ; i < limit; i++) {
            resDigits[i] = ~(~negative.digits[i] ^ positive.digits[i]);
        }
        for ( ; i < positive.numberLength; i++) {
            resDigits[i] = positive.digits[i];
        }
        for ( ; i < negative.numberLength; i++) {
            resDigits[i] = negative.digits[i];
        }
        return new BigInteger(-1, resLength, resDigits);
    }

    
}

