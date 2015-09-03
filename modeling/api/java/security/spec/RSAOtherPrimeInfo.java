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

/**
 * The additional prime information specified as triplet of primes, a prime
 * exponent, and a Chinese Remainder Theorem (CRT) coefficient.
 * <p>
 * Defined in the <a
 * href="http://www.rsa.com/rsalabs/pubs/PKCS/html/pkcs-1.html">PKCS #1 v2.1</a>
 * standard.
 */
public class RSAOtherPrimeInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.502 -0400", hash_original_field = "CEC513C942C55A8532AD40AE78E3CD6C", hash_generated_field = "EEE40888455DE03944359062DBAD7873")

    private  BigInteger prime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.503 -0400", hash_original_field = "347D289DCC418AB09405C868ABAB5E3D", hash_generated_field = "061A50B5C8269EF1237A091960708952")

    private  BigInteger primeExponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.505 -0400", hash_original_field = "A68F5C4250913ADDC701F6FCEA9C0282", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private  BigInteger crtCoefficient;

    /**
     * Creates a new {@code RSAOtherPrimeInfo} with the specified prime,
     * exponent, and CRT coefficient.
     *
     * @param prime
     *            the prime factor.
     * @param primeExponent
     *            the prime exponent.
     * @param crtCoefficient
     *            the CRT coefficient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.506 -0400", hash_original_method = "F6E1993B742624CC8C60C5BBF10EE9D7", hash_generated_method = "581E176BD6649CCB52AC502F64A3C26F")
    
public RSAOtherPrimeInfo(BigInteger prime,
            BigInteger primeExponent, BigInteger crtCoefficient) {
        if (prime == null) {
            throw new NullPointerException("prime == null");
        }
        if (primeExponent == null) {
            throw new NullPointerException("primeExponent == null");
        }
        if (crtCoefficient == null) {
            throw new NullPointerException("crtCoefficient == null");
        }
        this.prime = prime;
        this.primeExponent = primeExponent;
        this.crtCoefficient = crtCoefficient;
    }

    /**
     * Returns the CRT coefficient.
     *
     * @return the CRT coefficient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.508 -0400", hash_original_method = "ACBFCDB81BF18ABF0A77938A5EED41BC", hash_generated_method = "3DBFA82A631A02E800F11EDEAD54CF97")
    
public final BigInteger getCrtCoefficient() {
        return crtCoefficient;
    }

    /**
     * Returns the prime factor.
     *
     * @return the prime factor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.509 -0400", hash_original_method = "654E358F6C0618DDC55CCAE2111CE6D4", hash_generated_method = "FBF2AF1BBAECD1AE2C4167EDEFCC02D1")
    
public final BigInteger getPrime() {
        return prime;
    }

    /**
     * Returns the exponent.
     *
     * @return the exponent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.510 -0400", hash_original_method = "6C0BAD7D5D53FD747C282AB034B4ADD5", hash_generated_method = "3652EDB251C42E6A6ECC876EA2187653")
    
public final BigInteger getExponent() {
        return primeExponent;
    }
}
