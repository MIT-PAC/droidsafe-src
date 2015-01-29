/*
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

package java.security.spec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * An Elliptic Curve with its necessary values.
 */
public class EllipticCurve {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.338 -0400", hash_original_field = "3A928E43184BA707551936914262C296", hash_generated_field = "17CA07527118E71873471E571CA99A35")

    private  ECField field;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.339 -0400", hash_original_field = "DD2D29CC730A41473CC13E5798EF130A", hash_generated_field = "65816F05574951D1D7B2D2163E56C1B6")

    private  BigInteger a;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.341 -0400", hash_original_field = "3E481B1C200FB49E4C2487A27257AA77", hash_generated_field = "E9F5C1A290006B1D2102DA368FAA08C2")

    private  BigInteger b;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.342 -0400", hash_original_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17", hash_generated_field = "EE2C61070B87A8C373B02DC1A752C7E6")

    // if it was generated randomly
    private  byte[] seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.343 -0400", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "14BD22BAF6A8C3C793BBFB6A883EDD7D")

    private volatile int hash;

    /**
     * Creates a new {@code EllipticCurve} with the specified field,
     * coefficients and seed.
     *
     * @param field
     *            the finite field of this elliptic curve.
     * @param a
     *            the coefficient {@code a}.
     * @param b
     *            the coefficient {@code b}.
     * @param seed
     *            the seed used for the generation of the curve.
     * @throws IllegalArgumentException
     *             if the specified coefficients are not in the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.346 -0400", hash_original_method = "02F3239FC377A60C1F83CDCE175A93F7", hash_generated_method = "4EF30A376E0B3528DC6BD3A3513B5D64")
    
public EllipticCurve(ECField field, BigInteger a, BigInteger b, byte[] seed) {
        this.field = field;
        if (this.field == null) {
            throw new NullPointerException("field == null");
        }
        this.a = a;
        if (this.a == null) {
            throw new NullPointerException("a == null");
        }
        this.b = b;
        if (this.b == null) {
            throw new NullPointerException("b == null");
        }
        // make defensive copy
        if (seed == null) {
            this.seed = null;
        } else {
            this.seed = new byte[seed.length];
            System.arraycopy(seed, 0, this.seed, 0, this.seed.length);
        }
        // check parameters for ECFieldFp and ECFieldF2m.
        // Check invariant: a and b must be in the field.
        // Check conditions for custom ECField are not specified.
        if (this.field instanceof ECFieldFp) {
            BigInteger p = ((ECFieldFp) this.field).getP();
            if (this.a.signum() < 0 || this.a.compareTo(p) >= 0) {
                throw new IllegalArgumentException("the a is not in the field");
            }
            if (this.b.signum() < 0 || this.b.compareTo(p) >= 0) {
                throw new IllegalArgumentException("the b is not in the field");
            }
        } else if (this.field instanceof ECFieldF2m) {
            int fieldSizeInBits = this.field.getFieldSize();
            if (!(this.a.bitLength() <= fieldSizeInBits)) {
                throw new IllegalArgumentException("the a is not in the field");
            }
            if (!(this.b.bitLength() <= fieldSizeInBits)) {
                throw new IllegalArgumentException("the b is not in the field");
            }
        }
    }

    /**
     * Creates a new {@code EllipticCurve} with the specified field and
     * coefficients.
     *
     * @param field
     *            the finite field of this elliptic curve.
     * @param a
     *            the coefficient {@code a}.
     * @param b
     *            the coefficient {@code b}.
     * @throws IllegalArgumentException
     *             if the specified coefficients are not in the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.347 -0400", hash_original_method = "0CC97C4B45737BED49AA36F95042ACBB", hash_generated_method = "624F6C02619D4FA24D5ABDD3EE736136")
    
public EllipticCurve(ECField field, BigInteger a, BigInteger b) {
        this(field, a, b, null);
    }

    /**
     * Returns the coefficient {@code a} of this elliptic curve.
     *
     * @return the coefficient {@code a} of this elliptic curve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.349 -0400", hash_original_method = "EB5E8F397FB3CCF8205B39F0C7368595", hash_generated_method = "F52EF4E20E375859EAA48C0C6B824745")
    
public BigInteger getA() {
        return a;
    }

    /**
     * Returns the coefficient {@code b} of this elliptic curve.
     *
     * @return the coefficient {@code b} of this elliptic curve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.350 -0400", hash_original_method = "3C16C10709B515B82ED3AC6927D4DFC3", hash_generated_method = "3BC60A62CB3F9CB23EC47EBFCB261A01")
    
public BigInteger getB() {
        return b;
    }

    /**
     * Returns the finite field of this elliptic curve.
     *
     * @return the finite field of this elliptic curve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.351 -0400", hash_original_method = "3B41B7185EA799A7F6988669D1B2C2C8", hash_generated_method = "3B089EC7F10DCC14CE02FB1448BFF606")
    
public ECField getField() {
        return field;
    }

    /**
     * Returns a copy of the seed that was used to generate this elliptic curve.
     *
     * @return a copy of the seed that was used to generate this elliptic curve,
     *         or {@code null} if none specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.353 -0400", hash_original_method = "CBD9DE7927E2D8828C9C4B09B87710E6", hash_generated_method = "133DA1AF9F2A6EAF46F42EE6A6FF4651")
    
public byte[] getSeed() {
        if (seed == null) {
            return null;
        } else {
            // return copy
            byte[] ret = new byte[seed.length];
            System.arraycopy(seed, 0, ret, 0, ret.length);
            return ret;
        }
    }

    /**
     * Returns whether the specified object equals to this elliptic curve.
     *
     * @param other
     *            the object to compare.
     * @return {@code true} if the specified object is equal to this elliptic
     *         curve, otherwise {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.354 -0400", hash_original_method = "5D2797A6208FC694571C407EACBBC5A4", hash_generated_method = "E680E45CF3598570AE16BFCD7E30D451")
    
public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EllipticCurve)) {
            return false;
        }
        EllipticCurve otherEc = (EllipticCurve) other;
        return this.field.equals(otherEc.field) && this.a.equals(otherEc.a)
                && this.b.equals(otherEc.b)
                && Arrays.equals(this.seed, otherEc.seed);
    }

    /**
     * Returns the hashcode of this elliptic curve.
     *
     * @return the hashcode of this elliptic curve.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.356 -0400", hash_original_method = "8D22C024576C73F0E98A887CEA3397A0", hash_generated_method = "DE1F7BF161A1D9CBBDF3DB1F51D1C6A1")
    
public int hashCode() {
        // hash init is delayed
        if (hash == 0) {
            int hash0 = 11;
            hash0 = hash0 * 31 + field.hashCode();
            hash0 = hash0 * 31 + a.hashCode();
            hash0 = hash0 * 31 + b.hashCode();
            if (seed != null) {
                for (int i = 0; i < seed.length; i++) {
                    hash0 = hash0 * 31 + seed[i];
                }
            } else {
                hash0 = hash0 * 31;
            }
            hash = hash0;
        }
        return hash;
    }
}
