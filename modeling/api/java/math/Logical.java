/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class Logical {

    /** @see BigInteger#not() */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.008 -0500", hash_original_method = "392AFC3BDADB24DC195370AE34B72ED7", hash_generated_method = "EE559654C2007CDF8FB59F6C5F0BB36B")
    
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
            // ~val = -val + 1
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
            // Here a carry 1 was generated
        } else {// (val.sign < 0)
            // ~val = -val - 1
            for (i = 0; val.digits[i] == 0; i++) {
                resDigits[i] = -1;
            }
            // Here a borrow -1 was generated
        }
        // Now, the carry/borrow can be absorbed
        resDigits[i] = val.digits[i] + val.sign;
        // Copying the remaining unchanged digit
        for (i++; i < val.numberLength; i++) {
            resDigits[i] = val.digits[i];
        }
        return new BigInteger(-val.sign, i, resDigits);
    }

    /** @see BigInteger#and(BigInteger) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.010 -0500", hash_original_method = "2C8DC85E0E1CCD004FAAD21C9629C260", hash_generated_method = "A6E1EF5B13BCCC1070AF257A88240E7E")
    
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

    /** @return sign = 1, magnitude = val.magnitude & that.magnitude*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.013 -0500", hash_original_method = "7F3EB0E904FF3E9DD99368007D6C9B81", hash_generated_method = "AE5E29782941B2940AE2AF6FDFBDFDDF")
    
static BigInteger andPositive(BigInteger val, BigInteger that) {
        // PRE: both arguments are positive
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

    /** @return sign = positive.magnitude & magnitude = -negative.magnitude */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.016 -0500", hash_original_method = "D4ADDF36FE9698AFC6A4BD65552D080E", hash_generated_method = "F9731EA323E9DF142F65C996737B4DA4")
    
static BigInteger andDiffSigns(BigInteger positive, BigInteger negative) {
        // PRE: positive is positive and negative is negative
        int iPos = positive.getFirstNonzeroDigit();
        int iNeg = negative.getFirstNonzeroDigit();

        // Look if the trailing zeros of the negative will "blank" all
        // the positive digits
        if (iNeg >= positive.numberLength) {
            return BigInteger.ZERO;
        }
        int resLength = positive.numberLength;
        int[] resDigits = new int[resLength];

        // Must start from max(iPos, iNeg)
        int i = Math.max(iPos, iNeg);
        if (i == iNeg) {
            resDigits[i] = -negative.digits[i] & positive.digits[i];
            i++;
        }
        int limit = Math.min(negative.numberLength, positive.numberLength);
        for ( ; i < limit; i++) {
            resDigits[i] = ~negative.digits[i] & positive.digits[i];
        }
        // if the negative was shorter must copy the remaining digits
        // from positive
        if (i >= negative.numberLength) {
            for ( ; i < positive.numberLength; i++) {
                resDigits[i] = positive.digits[i];
            }
        } // else positive ended and must "copy" virtual 0's, do nothing then

        return new BigInteger(1, resLength, resDigits);
    }

    /** @return sign = -1, magnitude = -(-longer.magnitude & -shorter.magnitude)*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.019 -0500", hash_original_method = "4BA9A3F2357E229226C0FDBBF26C29A3", hash_generated_method = "B4B1EBF48EC15332B07C45037F6BD707")
    
static BigInteger andNegative(BigInteger longer, BigInteger shorter) {
        // PRE: longer and shorter are negative
        // PRE: longer has at least as many digits as shorter
        int iLonger = longer.getFirstNonzeroDigit();
        int iShorter = shorter.getFirstNonzeroDigit();

        // Does shorter matter?
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
                ;  // digit = ~longer.digits[i] & ~shorter.digits[i]
            if (digit == 0) {
                // shorter has only the remaining virtual sign bits
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
            // resDigits[i] = ~(~longer.digits[i] & ~shorter.digits[i];)
            resDigits[i] = longer.digits[i] | shorter.digits[i];
        }
        // shorter has only the remaining virtual sign bits
        for ( ; i < longer.numberLength; i++){
            resDigits[i] = longer.digits[i];
        }

        return new BigInteger(-1, resLength, resDigits);
    }

    /** @see BigInteger#andNot(BigInteger) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.022 -0500", hash_original_method = "FFE149F0CA07D5DDAB8B34E15CBB188E", hash_generated_method = "7A4116E6DB1FE2D05FD59C5571D0563A")
    
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

        //if val == that, return 0

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

    /** @return sign = 1, magnitude = val.magnitude & ~that.magnitude*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.025 -0500", hash_original_method = "C0E54D558D226B234C4AF57127F55347", hash_generated_method = "DFAC7F613E03603AE640C401A858F3AF")
    
static BigInteger andNotPositive(BigInteger val, BigInteger that) {
        // PRE: both arguments are positive
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

    /** @return sign = 1, magnitude = positive.magnitude & ~(-negative.magnitude)*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.027 -0500", hash_original_method = "3369F881491DAA5EA286C0C2A65C4740", hash_generated_method = "CAB55BB40A9374C3CDC62CA4F7FC0760")
    
static BigInteger andNotPositiveNegative(BigInteger positive, BigInteger negative) {
        // PRE: positive > 0 && negative < 0
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();

        if (iNeg >= positive.numberLength) {
            return positive;
        }

        int resLength = Math.min(positive.numberLength, negative.numberLength);
        int[] resDigits = new int[resLength];

        // Always start from first non zero of positive
        int i = iPos;
        for ( ; i < iNeg; i++) {
            // resDigits[i] = positive.digits[i] & -1 (~0)
            resDigits[i] = positive.digits[i];
        }
        if (i == iNeg) {
            resDigits[i] = positive.digits[i] & (negative.digits[i] - 1);
            i++;
        }
        for ( ; i < resLength; i++) {
            // resDigits[i] = positive.digits[i] & ~(~negative.digits[i]);
            resDigits[i] = positive.digits[i] & negative.digits[i];
        }

        return new BigInteger(1, resLength, resDigits);
    }

    /** @return sign = -1, magnitude = -(-negative.magnitude & ~positive.magnitude)*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.031 -0500", hash_original_method = "DD119577D67A3E7BD795D9D09EFDA25B", hash_generated_method = "079FA99B4F273C98C10B5B0D5A00B7E0")
    
static BigInteger andNotNegativePositive(BigInteger negative, BigInteger positive) {
        // PRE: negative < 0 && positive > 0
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
                // 1st case:  resDigits [i] = -(-negative.digits[i] & (~0))
                // otherwise: resDigits[i] = ~(~negative.digits[i] & ~0)  ;
                resDigits[i] = negative.digits[i];
            }
            if (i == negative.numberLength) {
                for (i = iPos; i < positive.numberLength; i++) {
                    // resDigits[i] = ~(~positive.digits[i] & -1);
                    resDigits[i] = positive.digits[i];
                }
            }
        } else {
            digit = -negative.digits[i] & ~positive.digits[i];
            if (digit == 0) {
                limit = Math.min(positive.numberLength, negative.numberLength);
                for (i++; i < limit && (digit = ~(negative.digits[i] | positive.digits[i])) == 0; i++)
                    ; // digit = ~negative.digits[i] & ~positive.digits[i]
                if (digit == 0) {
                    // the shorter has only the remaining virtual sign bits
                    for ( ; i < positive.numberLength && (digit = ~positive.digits[i]) == 0; i++)
                        ; // digit = -1 & ~positive.digits[i]
                    for ( ; i < negative.numberLength && (digit = ~negative.digits[i]) == 0; i++)
                        ; // digit = ~negative.digits[i] & ~0
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
            //resDigits[i] = ~(~negative.digits[i] & ~positive.digits[i]);
            resDigits[i] = negative.digits[i] | positive.digits[i];
        }
        // Actually one of the next two cycles will be executed
        for ( ; i < negative.numberLength; i++) {
            resDigits[i] = negative.digits[i];
                }
        for ( ; i < positive.numberLength; i++) {
            resDigits[i] = positive.digits[i];
        }

        return new BigInteger(-1, resLength, resDigits);
    }

    /** @return sign = 1, magnitude = -val.magnitude & ~(-that.magnitude)*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.035 -0500", hash_original_method = "B3B8A3E928EA206167CF1C5192B047DF", hash_generated_method = "78AEE2D4AE5CCC92371A8E41899EE777")
    
static BigInteger andNotNegative(BigInteger val, BigInteger that) {
        // PRE: val < 0 && that < 0
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
            // resDigits[i] = -val.digits[i] & -1;
            resDigits[i] = -val.digits[i];
            limit = Math.min(val.numberLength, iThat);
            for (i++; i < limit; i++) {
                // resDigits[i] = ~val.digits[i] & -1;
                resDigits[i] = ~val.digits[i];
            }
            if (i == val.numberLength) {
                for ( ; i < iThat; i++) {
                    // resDigits[i] = -1 & -1;
                    resDigits[i] = -1;
                }
                // resDigits[i] = -1 & ~-that.digits[i];
                resDigits[i] = that.digits[i] - 1;
        } else {
                // resDigits[i] = ~val.digits[i] & ~-that.digits[i];
                resDigits[i] = ~val.digits[i] & (that.digits[i] - 1);
            }
        } else if (iThat < iVal ) {
            // resDigits[i] = -val.digits[i] & ~~that.digits[i];
            resDigits[i] = -val.digits[i] & that.digits[i];
        } else {
            // resDigits[i] = -val.digits[i] & ~-that.digits[i];
            resDigits[i] = -val.digits[i] & (that.digits[i] - 1);
            }

        limit = Math.min(val.numberLength, that.numberLength);
        for (i++; i < limit; i++) {
            // resDigits[i] = ~val.digits[i] & ~~that.digits[i];
            resDigits[i] = ~val.digits[i] & that.digits[i];
        }
        for ( ; i < that.numberLength; i++) {
            // resDigits[i] = -1 & ~~that.digits[i];
            resDigits[i] = that.digits[i];
        }

        return new BigInteger(1, resLength, resDigits);
    }

    /** @see BigInteger#or(BigInteger) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.038 -0500", hash_original_method = "E26D488F3AAB4CDC413B1181E2CD9C21", hash_generated_method = "EA3D26D70594626EBA130E26FF9BAC1C")
    
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

    /** @return sign = 1, magnitude = longer.magnitude | shorter.magnitude*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.041 -0500", hash_original_method = "E1A52B0EEA69860CA581AD315054499A", hash_generated_method = "9016A128788D0A4570A9797EA91F4B40")
    
static BigInteger orPositive(BigInteger longer, BigInteger shorter) {
        // PRE: longer and shorter are positive;
        // PRE: longer has at least as many digits as shorter
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

    /** @return sign = -1, magnitude = -(-val.magnitude | -that.magnitude) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.044 -0500", hash_original_method = "260F2451AD2E052F4E7F80E194494B56", hash_generated_method = "F3A064319B9501202717A6BAC5674F9C")
    
static BigInteger orNegative(BigInteger val, BigInteger that){
        // PRE: val and that are negative;
        // PRE: val has at least as many trailing zeros digits as that
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

        //Looking for the first non-zero digit of the result
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

    /** @return sign = -1, magnitude = -(positive.magnitude | -negative.magnitude) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.047 -0500", hash_original_method = "A13CE9D347F1A0B9FB1AE680E2818289", hash_generated_method = "04A4455207987297C5176168225A2C25")
    
static BigInteger orDiffSigns(BigInteger positive, BigInteger negative){
        // Jumping over the least significant zero bits
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();
        int i;
        int limit;

        // Look if the trailing zeros of the positive will "copy" all
        // the negative digits
        if (iPos >= negative.numberLength) {
            return negative;
        }
        int resLength = negative.numberLength;
        int[] resDigits = new int[resLength];

        if (iNeg < iPos ) {
            // We know for sure that this will
            // be the first non zero digit in the result
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
                  // resDigits[i] = ~(-negative.digits[i] | 0);
                  resDigits[i] = negative.digits[i] - 1;
            }
            i++;
        } else {// iNeg == iPos
            // Applying two complement to negative and to result
            i = iPos;
            resDigits[i] = -(-negative.digits[i] | positive.digits[i]);
            i++;
        }
        limit = Math.min(negative.numberLength, positive.numberLength);
        for (; i < limit; i++) {
            // Applying two complement to negative and to result
            // resDigits[i] = ~(~negative.digits[i] | positive.digits[i] );
            resDigits[i] = negative.digits[i] & ~positive.digits[i];
        }
        for ( ; i < negative.numberLength; i++) {
            resDigits[i] = negative.digits[i];
        }

        return new BigInteger(-1, resLength, resDigits);
    }

    /** @see BigInteger#xor(BigInteger) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.050 -0500", hash_original_method = "1821B11966444E78361FC548F4258C0F", hash_generated_method = "A768D5C8C525E6ACFEBC4AA7AE1CF6E1")
    
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

    /** @return sign = 0, magnitude = longer.magnitude | shorter.magnitude */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.053 -0500", hash_original_method = "189DD0842BC0FB3122036364D7D12A46", hash_generated_method = "6787C77786A7156D1D47603FAE8F9B62")
    
static BigInteger xorPositive(BigInteger longer, BigInteger shorter) {
        // PRE: longer and shorter are positive;
        // PRE: longer has at least as many digits as shorter
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

    /** @return sign = 0, magnitude = -val.magnitude ^ -that.magnitude */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.057 -0500", hash_original_method = "8F87E09A5F75207496657A0F33C785A9", hash_generated_method = "719F646D47E7CF47CCF977B0DC7EE88B")
    
static BigInteger xorNegative(BigInteger val, BigInteger that){
        // PRE: val and that are negative
        // PRE: val has at least as many trailing zero digits as that
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
            // Remains digits in that?
            if (i == that.numberLength) {
                //Jumping over the remaining zero to the first non one
                for ( ;i < iVal; i++) {
                    //resDigits[i] = 0 ^ -1;
                    resDigits[i] = -1;
                }
                //resDigits[i] = -val.digits[i] ^ -1;
                resDigits[i] = val.digits[i] - 1;
            } else {
                resDigits[i] = -val.digits[i] ^ ~that.digits[i];
            }
        }

        limit = Math.min(val.numberLength, that.numberLength);
        //Perform ^ between that al val until that ends
        for (i++; i < limit; i++) {
            //resDigits[i] = ~val.digits[i] ^ ~that.digits[i];
            resDigits[i] = val.digits[i] ^ that.digits[i];
        }
        //Perform ^ between val digits and -1 until val ends
        for ( ; i < val.numberLength; i++) {
            //resDigits[i] = ~val.digits[i] ^ -1  ;
            resDigits[i] = val.digits[i] ;
        }
        for ( ; i < that.numberLength; i++) {
            //resDigits[i] = -1 ^ ~that.digits[i] ;
            resDigits[i] = that.digits[i];
        }

        return new BigInteger(1, resLength, resDigits);
    }

    /** @return sign = 1, magnitude = -(positive.magnitude ^ -negative.magnitude)*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.061 -0500", hash_original_method = "3948FB7D779F1B72187D779FDF9029B7", hash_generated_method = "30400D7C3287C536DD1449A48E158514")
    
static BigInteger xorDiffSigns(BigInteger positive, BigInteger negative){
        int resLength = Math.max(negative.numberLength, positive.numberLength);
        int[] resDigits;
        int iNeg = negative.getFirstNonzeroDigit();
        int iPos = positive.getFirstNonzeroDigit();
        int i;
        int limit;

        //The first
        if (iNeg < iPos) {
            resDigits = new int[resLength];
            i = iNeg;
            //resDigits[i] = -(-negative.digits[i]);
            resDigits[i] = negative.digits[i];
            limit = Math.min(negative.numberLength, iPos);
            //Skip the positive digits while they are zeros
            for (i++; i < limit; i++) {
                //resDigits[i] = ~(~negative.digits[i]);
                resDigits[i] = negative.digits[i];
            }
            //if the negative has no more elements, must fill the
            //result with the remaining digits of the positive
            if (i == negative.numberLength) {
                for ( ; i < positive.numberLength; i++) {
                    //resDigits[i] = ~(positive.digits[i] ^ -1) -> ~(~positive.digits[i])
                    resDigits[i] = positive.digits[i];
                }
            }
        } else if (iPos < iNeg) {
            resDigits = new int[resLength];
            i = iPos;
            //Applying two complement to the first non-zero digit of the result
            resDigits[i] = -positive.digits[i];
            limit = Math.min(positive.numberLength, iNeg);
            for (i++; i < limit; i++) {
                //Continue applying two complement the result
                resDigits[i] = ~positive.digits[i];
            }
            //When the first non-zero digit of the negative is reached, must apply
            //two complement (arithmetic negation) to it, and then operate
            if (i == iNeg) {
                resDigits[i] = ~(positive.digits[i] ^ -negative.digits[i]);
                i++;
            } else {
                //if the positive has no more elements must fill the remaining digits with
                //the negative ones
                for ( ; i < iNeg; i++) {
                    // resDigits[i] = ~(0 ^ 0)
                    resDigits[i] = -1;
                }
                for ( ; i < negative.numberLength; i++) {
                    //resDigits[i] = ~(~negative.digits[i] ^ 0)
                    resDigits[i] = negative.digits[i];
                }
            }
                } else {
            //The first non-zero digit of the positive and negative are the same
            i = iNeg;
            int digit = positive.digits[i] ^ -negative.digits[i];
            if (digit == 0) {
                limit = Math.min(positive.numberLength, negative.numberLength);
                for (i++; i < limit && (digit = positive.digits[i] ^ ~negative.digits[i]) == 0; i++)
                    ;
                if (digit == 0) {
                    // shorter has only the remaining virtual sign bits
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
            // resDigits[i] = ~(positive.digits[i] ^ -1)
            resDigits[i] = positive.digits[i];
        }
        for ( ; i < negative.numberLength; i++) {
            // resDigits[i] = ~(0 ^ ~negative.digits[i])
            resDigits[i] = negative.digits[i];
        }

        return new BigInteger(-1, resLength, resDigits);
    }

    /** Just to denote that this class can't be instantiated. */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.005 -0500", hash_original_method = "E0A3DE35724A26B6DFF41660E2732E13", hash_generated_method = "70AB7B0A4996E44234A828B6E1A790AE")
    
private Logical() {}
    
}

