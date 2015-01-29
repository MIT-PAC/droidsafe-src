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

/**
 * The key specification of a RSA multi-prime private key with the Chinese
 * Remainder Theorem (CRT) information values used.
 * <p>
 * Defined in the <a
 * href="http://www.rsa.com/rsalabs/pubs/PKCS/html/pkcs-1.html">PKCS #1 v2.1</a>
 * standard.
 */
public class RSAMultiPrimePrivateCrtKeySpec extends RSAPrivateKeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.450 -0400", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private  BigInteger publicExponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.452 -0400", hash_original_field = "7A3E1BB8B91AABDAC8096A6AF946B79F", hash_generated_field = "9A9C713E9D8E7513F2417C506E73722A")

    private  BigInteger primeP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.453 -0400", hash_original_field = "1C81CE9A16FD4AC10BD085B1B94422AB", hash_generated_field = "9F91AA93693120FB89947F1BE699F0CA")

    private  BigInteger primeQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.454 -0400", hash_original_field = "40B3FB6881B01131E42A79EC00848D20", hash_generated_field = "D5FB562D58D86204E98F2195C5586E56")

    private  BigInteger primeExponentP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.457 -0400", hash_original_field = "6467AFAE24BDCED779196424DCB2176F", hash_generated_field = "1ACB6AF17AD2472C87AB927F2F837C22")

    private  BigInteger primeExponentQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.458 -0400", hash_original_field = "A68F5C4250913ADDC701F6FCEA9C0282", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private  BigInteger crtCoefficient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.459 -0400", hash_original_field = "530F9D690E2E601307B6F450AFEF1B83", hash_generated_field = "54C1B0D4F2BF702AEDA6F94C9BE7396C")

    private  RSAOtherPrimeInfo[] otherPrimeInfo;

    /**
     * Creates a new {@code RSAMultiPrimePrivateCrtKeySpec} with the specified
     * modulus, public exponent, private exponent, prime factors, prime
     * exponents, crt coefficient, and additional primes.
     *
     * @param modulus
     *            the modulus {@code n}.
     * @param publicExponent
     *            the public exponent {@code e}.
     * @param privateExponent
     *            the private exponent {@code d}.
     * @param primeP
     *            the prime factor {@code p} of {@code n}.
     * @param primeQ
     *            the prime factor {@code q} of {@code n}.
     * @param primeExponentP
     *            the exponent of the prime {@code p}.
     * @param primeExponentQ
     *            the exponent of the prime {@code q}.
     * @param crtCoefficient
     *            the CRT coefficient {@code q^-1 mod p}.
     * @param otherPrimeInfo
     *            the information for the additional primes or {@code null} if
     *            there are only the two primes ({@code p, q}).
     * @throws IllegalArgumentException
     *             if {@code otherPrimeInfo} is not null but empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.462 -0400", hash_original_method = "0EA8EF9BEED27C1197BBA8CA0C86D1AB", hash_generated_method = "46983A5E444AA98BB030ED75AE9E98AD")
    
public RSAMultiPrimePrivateCrtKeySpec(
            BigInteger modulus,
            BigInteger publicExponent,
            BigInteger privateExponent,
            BigInteger primeP,
            BigInteger primeQ,
            BigInteger primeExponentP,
            BigInteger primeExponentQ,
            BigInteger crtCoefficient,
            RSAOtherPrimeInfo[] otherPrimeInfo) {

        super(modulus, privateExponent);

        // Perform checks specified
        if (modulus == null) {
            throw new NullPointerException("modulus == null");
        }
        if (privateExponent == null) {
            throw new NullPointerException("privateExponent == null");
        }
        if (publicExponent == null) {
            throw new NullPointerException("publicExponent == null");
        }
        if (primeP == null) {
            throw new NullPointerException("primeP == null");
        }
        if (primeQ == null) {
            throw new NullPointerException("primeQ == null");
        }
        if (primeExponentP == null) {
            throw new NullPointerException("primeExponentP == null");
        }
        if (primeExponentQ == null) {
            throw new NullPointerException("primeExponentQ == null");
        }
        if (crtCoefficient == null) {
            throw new NullPointerException("crtCoefficient == null");
        }

        if (otherPrimeInfo != null) {
            if (otherPrimeInfo.length == 0) {
                throw new IllegalArgumentException("otherPrimeInfo.length == 0");
            }
            // Clone array to prevent subsequent modification
            this.otherPrimeInfo = new RSAOtherPrimeInfo[otherPrimeInfo.length];
            System.arraycopy(otherPrimeInfo, 0,
                    this.otherPrimeInfo, 0, this.otherPrimeInfo.length);
        } else {
            this.otherPrimeInfo = null;
        }
        this.publicExponent = publicExponent;
        this.primeP = primeP;
        this.primeQ = primeQ;
        this.primeExponentP = primeExponentP;
        this.primeExponentQ = primeExponentQ;
        this.crtCoefficient = crtCoefficient;
    }

    /**
     * Returns the CRT coefficient, {@code q^-1 mod p}.
     *
     * @return the CRT coefficient, {@code q^-1 mod p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.463 -0400", hash_original_method = "ACBFCDB81BF18ABF0A77938A5EED41BC", hash_generated_method = "97EDEC99BD89F3C3B898907864A5969A")
    
public BigInteger getCrtCoefficient() {
        return crtCoefficient;
    }

    /**
     * Returns the information for the additional primes.
     *
     * @return the information for the additional primes, or {@code null} if
     *         there are only the two primes ({@code p, q}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.464 -0400", hash_original_method = "A85B8D85BEC324270B8CD38C41C43E60", hash_generated_method = "43F851B65A545F2AF536E0D947AFC190")
    
public RSAOtherPrimeInfo[] getOtherPrimeInfo() {
        // Clone array (if not null) to prevent subsequent modification
        if (otherPrimeInfo == null) {
            return null;
        } else {
            RSAOtherPrimeInfo[] ret =
                new RSAOtherPrimeInfo[otherPrimeInfo.length];
            System.arraycopy(otherPrimeInfo, 0, ret, 0, ret.length);
            return ret;
        }
    }

    /**
     * Returns the exponent of the prime {@code p}.
     *
     * @return the exponent of the prime {@code p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.466 -0400", hash_original_method = "F0E07FFA226AFDFA80184533230F10C0", hash_generated_method = "B8F125E28DD971AB2A14227701C3ACA8")
    
public BigInteger getPrimeExponentP() {
        return primeExponentP;
    }

    /**
     * Returns the exponent of the prime {@code q}.
     *
     * @return the exponent of the prime {@code q}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.467 -0400", hash_original_method = "E723F3703FB87A9BEB77BD8EB83B9C01", hash_generated_method = "DB4AA43C17AF6D85BD5E97574992AC14")
    
public BigInteger getPrimeExponentQ() {
        return primeExponentQ;
    }

    /**
     * Returns the prime factor {@code p}.
     *
     * @return the prime factor {@code p}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.468 -0400", hash_original_method = "6B317E4DBB0CE4C27ED249BB287307E9", hash_generated_method = "C754147F7132081FF985241C8123FDC5")
    
public BigInteger getPrimeP() {
        return primeP;
    }

    /**
     * Returns the prime factor {@code q}.
     *
     * @return the prime factor {@code q}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.470 -0400", hash_original_method = "A63916054BB1CFBFE5DBD277F62696D2", hash_generated_method = "A67CBA40F2C5DB2C9FE6FFCCBCB86CBC")
    
public BigInteger getPrimeQ() {
        return primeQ;
    }

    /**
     * Returns the public exponent {@code e}.
     *
     * @return the public exponent {@code e}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.471 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "CDD9969A60E00BAEF22FCCEA56318047")
    
public BigInteger getPublicExponent() {
        return publicExponent;
    }
}
