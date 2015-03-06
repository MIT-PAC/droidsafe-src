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


package java.security.spec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * The parameters specifying a <i>characteristic 2 finite field</i> of an
 * elliptic curve.
 */
public class ECFieldF2m implements ECField {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.004 -0400", hash_original_field = "F86FAFB37E9E8062391522DA54A8DE5E", hash_generated_field = "EEAA1E04FBCD7620C8A7B87316F027C1")

    private static final int TPB_MID_LEN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.006 -0400", hash_original_field = "E541D99F3F262A36E9208180BB45E4B7", hash_generated_field = "F373AFF66D5FD1BEF30D8BBCB4D41BDC")

    private static final int PPB_MID_LEN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.008 -0400", hash_original_field = "659AB3E35352A6FB4A8553D0047F3BD9", hash_generated_field = "A1D7FABC9AA525018F628CA19D467FE3")

    private static final int TPB_LEN = TPB_MID_LEN + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.009 -0400", hash_original_field = "9903D27D71A738EA1D2171C983A880B9", hash_generated_field = "E808333BFBF3C9FF8FA8ABD962A9A7F7")

    private static final int PPB_LEN = PPB_MID_LEN + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.011 -0400", hash_original_field = "2E6007DAD305AA160976D52F2273ECD5", hash_generated_field = "86DFB4F628B6595CA77F01EE34E06F32")

    private  int m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.012 -0400", hash_original_field = "17CFC82D508C643832AC068A11F89612", hash_generated_field = "6221E58C20961CBBEB4390CC826FC1EB")

    private  BigInteger rp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.013 -0400", hash_original_field = "5C5D44ADA5E1F46CD8EC3C62E2972CEA", hash_generated_field = "AB98B3BCBF8D6DFE0211148C51567499")

    private  int[] ks;

    /**
     * Creates a new {@code ECFieldF2m} with {@code 2^m} elements with a normal
     * basis.
     *
     * @param m
     *            the exponent {@code m} for the number of elements.
     * @throws IllegalArgumentException
     *             if {@code m <= zero}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.014 -0400", hash_original_method = "F60D219BA2A5BE70E227258C398DE0FD", hash_generated_method = "83B769D127E71613B52FF946719FABB4")
    
public ECFieldF2m(int m) {
        this.m = m;
        if (this.m <= 0) {
            throw new IllegalArgumentException("m <= 0");
        }
        this.rp = null;
        this.ks = null;
    }

    /**
     * Creates a new {@code ECFieldF2m} with {@code 2^m} elements with a polynomial
     * basis and the reduction polynomial based on {@code rp}.
     * <p>
     * The reduction polynomial must be either <i>trinomial</i> or
     * <i>pentanomial</i>.
     *
     * @param m
     *            the exponent {@code m} for the number of elements.
     * @param rp
     *            the base of the reduction polynomial with the n-th bit
     *            corresponding to the n-th coefficient of the reduction
     *            polynomial.
     * @throws IllegalArgumentException
     *             if {@code m <= zero} or the {@code rp} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.016 -0400", hash_original_method = "891E5AC9475FC95974D419A1E9648C72", hash_generated_method = "0579B1BDA328F8D58CBEC22192B4A4C6")
    
public ECFieldF2m(int m, BigInteger rp) {
        this.m = m;
        if (this.m <= 0) {
            throw new IllegalArgumentException("m <= 0");
        }
        this.rp = rp;
        if (this.rp == null) {
            throw new NullPointerException("rp == null");
        }
        // the leftmost bit must be (m+1)-th one,
        // set bits count must be 3 or 5,
        // bits 0 and m must be set
        int rp_bc = this.rp.bitCount();
        if ((this.rp.bitLength() != (m+1)) ||
            (rp_bc != TPB_LEN && rp_bc != PPB_LEN) ||
            (!this.rp.testBit(0) || !this.rp.testBit(m)) ) {
            throw new IllegalArgumentException("rp is invalid");
        }

        // setup ks using rp:
        // allocate for mid terms only
        ks = new int[rp_bc-2];
        // find midterm orders and set ks accordingly
        BigInteger rpTmp = rp.clearBit(0);
        for (int i=ks.length-1; i>=0; i-- ) {
            ks[i] = rpTmp.getLowestSetBit();
            rpTmp = rpTmp.clearBit(ks[i]);
        }
    }

    /**
     * Creates a new {@code ECFieldF2m} with {@code 2^m} elements with
     * a polynomial basis and the reduction polynomial based on {@code ks}.
     * <p>
     * The reduction polynomial must be either <i>trinomial</i> or
     * <i>pentanomial</i>.
     *
     * @param m
     *            the exponent {@code m} for the number of elements.
     * @param ks
     *            the base of the reduction polynomial with coefficients
     *            given in descending order.
     * @throws IllegalArgumentException
     *             if {@code m <= zero} or the reduction polynomial is not
     *             valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.018 -0400", hash_original_method = "4EFF62B4A2BA96F676B11064080C2448", hash_generated_method = "827299750F1C10742277739FB1B2504D")
    
public ECFieldF2m(int m, int[] ks) {
        this.m = m;
        if (this.m <= 0) {
            throw new IllegalArgumentException("m <= 0");
        }
        // Defensively copies array parameter
        // to prevent subsequent modification.
        // NPE as specified if ks is null
        this.ks = new int[ks.length];
        System.arraycopy(ks, 0, this.ks, 0, this.ks.length);

        // no need to check for null already
        if (this.ks.length != TPB_MID_LEN && this.ks.length != PPB_MID_LEN) {
            // must be either trinomial or pentanomial basis
            throw new IllegalArgumentException("the length of ks is invalid");
        }
        // trinomial basis:
        // check that m > k >= 1, where k is ks[0]
        // pentanomial basis:
        // check that m > k3 > k2 > k1 >= 1
        // and kx in descending order, where
        // k3 is ks[0], k2 is ks[1], k1 is ks[2]
        boolean checkFailed = false;
        int prev = this.m;
        for (int i=0; i<this.ks.length; i++) {
            if (this.ks[i] < prev) {
                prev = this.ks[i];
                continue;
            }
            checkFailed = true;
            break;
        }
        if (checkFailed || prev < 1) {
            throw new IllegalArgumentException("ks is invalid");
        }

        // Setup rp using ks:
        // bits 0 and m always set
        BigInteger rpTmp = BigInteger.ONE.setBit(this.m);
        // set remaining bits according to ks
        for (int i=0; i<this.ks.length; i++) {
            rpTmp = rpTmp.setBit(this.ks[i]);
        }
        rp = rpTmp;
    }

    /**
     * Returns whether the specified object equals to this finite field.
     *
     * @param obj
     *            the object to compare to this finite field.
     * @return {@code true} if the specified object is equal to this finite field,
     *         otherwise {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.021 -0400", hash_original_method = "01933940D580ED8F19E6A1BB69556FC2", hash_generated_method = "54C712F27FA0691D87F4814756698468")
    
public boolean equals(Object obj) {
        // object equals to itself
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECFieldF2m) {
            ECFieldF2m o = (ECFieldF2m)obj;
            // check m
            if (this.m == o.m) {
                // check rp
                if (this.rp == null) {
                    if (o.rp == null) {
                        // fields both with normal basis
                        return true;
                    }
                } else {
                    // at least this field with polynomial basis
                    // check that rp match
                    // return this.rp.equals(o.rp);
                    return Arrays.equals(this.ks, o.ks);
                }
            }
        }
        return false;
    }

    /**
     * Returns the size of this finite field (in bits).
     *
     * @return the size of this finite field (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.022 -0400", hash_original_method = "42523CF7F05F42E24BD30D4320A4984C", hash_generated_method = "EAD5E6876F72339E90584D56D39C2570")
    
public int getFieldSize() {
        return m;
    }

    /**
     * Returns the exponent {@code m} for this finite field, with {@code 2^m} as
     * the number of elements.
     *
     * @return the exponent {@code m} for this finite field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.023 -0400", hash_original_method = "2FA087881284515E1CE9CA954B1F01D0", hash_generated_method = "54631342792286325FB6F9E68ECD4809")
    
public int getM() {
        return m;
    }

    /**
     * Returns a copy of the integer array containing the order of the middle
     * term(s) of the reduction polynomial for a polynomial basis.
     *
     * @return a copy of the integer array containing the order of the middle
     *         term(s) of the reduction polynomial for a polynomial basis or
     *         {@code null} for a normal basis.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.025 -0400", hash_original_method = "008DDB77908B9CDC38D0D65BB84F71E5", hash_generated_method = "F9059865D4E51B4231C2220ED42B62B0")
    
public int[] getMidTermsOfReductionPolynomial() {
        // Defensively copies private array
        // to prevent subsequent modification
        // was: return ks == null ? null : (int[])ks.clone();
        if (ks == null) {
            return null;
        } else {
            int[] ret = new int[ks.length];
            System.arraycopy(ks, 0, ret, 0, ret.length);
            return ret;
        }
    }

    /**
     * Returns the base of the reduction polynomial with the n-th bit
     * corresponding to the n-th coefficient of the reduction polynomial for a
     * polynomial basis.
     *
     * @return the base of the reduction polynomial with the n-th bit
     *         corresponding to the n-th coefficient of the reduction polynomial
     *         for a polynomial basis or {@code null} for a normal basis.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.026 -0400", hash_original_method = "CAF1A9F24DA674FAF56F2474CD7E2C3E", hash_generated_method = "EAB092099CF23800B4245533917DB593")
    
public BigInteger getReductionPolynomial() {
        return rp;
    }

    /**
     * Returns the hashcode value for this finite field.
     *
     * @return the hashcode value for this finite field.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.028 -0400", hash_original_method = "0BA5737D802F499B64A85853275E3368", hash_generated_method = "B9078954865C695972CAFFD384122A35")
    
public int hashCode() {
        return rp == null ? m : m + rp.hashCode();
    }
}
