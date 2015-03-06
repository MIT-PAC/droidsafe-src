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


package org.apache.harmony.security.provider.crypto;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class SHA1withDSA_SignatureImpl extends Signature {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.652 -0400", hash_original_field = "0589FBAF4C04F77E6E0D17E58D9228AD", hash_generated_field = "69DE41309F19455BFC96CB2C623B1C1D")


    private MessageDigest msgDigest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.652 -0400", hash_original_field = "89BF9DF4891F5EBB6E88C61564D06226", hash_generated_field = "086CF21773ED448323A7027FB688BF33")


    private DSAKey dsaKey;

    /**
     * The solo constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.653 -0400", hash_original_method = "B0AB63040DF3B3E285F6B176F6ADD7AD", hash_generated_method = "A316E2A869FDA2C9B26A0A0E47229C3D")
    
public SHA1withDSA_SignatureImpl() throws NoSuchAlgorithmException {

        super("SHA1withDSA");

        msgDigest = MessageDigest.getInstance("SHA1");
    }

    /**
     * Deprecated method.
     *
     * @return
     *    null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.654 -0400", hash_original_method = "BF22B7A975DB3BA3F07BF46A35715819", hash_generated_method = "F604701E87295F6269AEA64A13C5EBD8")
    
protected Object engineGetParameter(String param)
            throws InvalidParameterException {
        if (param == null) {
            throw new NullPointerException("param == null");
        }
        return null;
    }

    /**
     * Initializes this signature object with PrivateKey object
     * passed as argument to the method.
     *
     * @params
     *    privateKey DSAPrivateKey object
     * @throws
     *    InvalidKeyException if privateKey is not DSAPrivateKey object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.655 -0400", hash_original_method = "497239DE6B1E36E7944859E88C1E1B8A", hash_generated_method = "6DD56130E61191CDAED72D6BEDBB50BC")
    
protected void engineInitSign(PrivateKey privateKey)
            throws InvalidKeyException {

        DSAParams params;

        // parameters and private key
        BigInteger p, q, x;

        int n;

        if (privateKey == null || !(privateKey instanceof DSAPrivateKey)) {
            throw new InvalidKeyException();
        }

        params = ((DSAPrivateKey) privateKey).getParams();
        p = params.getP();
        q = params.getQ();
        x = ((DSAPrivateKey) privateKey).getX();

        // checks described in DSA standard
        n = p.bitLength();
        if (p.compareTo(BigInteger.valueOf(1)) != 1 || n < 512 || n > 1024 || (n & 077) != 0) {
            throw new InvalidKeyException("bad p");
        }
        if (q.signum() != 1 && q.bitLength() != 160) {
            throw new InvalidKeyException("bad q");
        }
        if (x.signum() != 1 || x.compareTo(q) != -1) {
            throw new InvalidKeyException("x <= 0 || x >= q");
        }

        dsaKey = (DSAKey) privateKey;

        msgDigest.reset();
    }

    /**
     * Initializes this signature object with PublicKey object
     * passed as argument to the method.
     *
     * @params
     *    publicKey DSAPublicKey object
     * @throws
     *    InvalidKeyException if publicKey is not DSAPublicKey object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.656 -0400", hash_original_method = "E09FCBCF5B6CC9BA43DA329534B3A534", hash_generated_method = "57CB43660391177D3EF86809A9F80388")
    
protected void engineInitVerify(PublicKey publicKey)
            throws InvalidKeyException {

        // parameters and public key
        BigInteger p, q, y;

        int n1;

        if (publicKey == null || !(publicKey instanceof DSAPublicKey)) {
            throw new InvalidKeyException("publicKey is not an instance of DSAPublicKey");
        }

        DSAParams params = ((DSAPublicKey) publicKey).getParams();
        p = params.getP();
        q = params.getQ();
        y = ((DSAPublicKey) publicKey).getY();

        // checks described in DSA standard
        n1 = p.bitLength();
        if (p.compareTo(BigInteger.valueOf(1)) != 1 || n1 < 512 || n1 > 1024 || (n1 & 077) != 0) {
            throw new InvalidKeyException("bad p");
        }
        if (q.signum() != 1 || q.bitLength() != 160) {
            throw new InvalidKeyException("bad q");
        }
        if (y.signum() != 1) {
            throw new InvalidKeyException("y <= 0");
        }

        dsaKey = (DSAKey) publicKey;

        msgDigest.reset();
    }

    /*
     * Deprecated method.
     *
     * @throws
     *    InvalidParameterException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.656 -0400", hash_original_method = "A71476343C21EE75C86DD9364EF236E7", hash_generated_method = "4F915C4DD8704FCEA5EE59A8206676D6")
    
protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
        if (param == null) {
            throw new NullPointerException("param == null");
        }
        throw new InvalidParameterException("invalid parameter for this engine");
    }

    /**
     * Returns signature bytes as byte array containing
     * ASN1 representation for two BigInteger objects
     * which is SEQUENCE of two INTEGERS.
     * Length of sequence varies from less than 46 to 48.
     *
     * Resets object to the state it was in
     * when previous call to either "initSign" method was called.
     *
     * @return
     *    byte array containing signature in ASN1 representation
     * @throws
     *    SignatureException if object's state is not SIGN or
     *                       signature algorithm cannot process data
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.659 -0400", hash_original_method = "8078F2328D3229D696432FB6A19BC05E", hash_generated_method = "F22BE4BE251A7639CB4383BBA9ADFD13")
    
protected byte[] engineSign() throws SignatureException {

        // names of below BigIntegers are the same as they are defined in DSA standard
        BigInteger r = null;
        BigInteger s = null;
        BigInteger k = null;

        // parameters and private key
        BigInteger p, q, g, x;

        // BigInteger for message digest
        BigInteger digestBI;

        // various byte array being used in computing signature
        byte[] randomBytes;
        byte[] rBytes;
        byte[] sBytes;
        byte[] signature;

        int n, n1, n2;

        DSAParams params;

        if (appRandom == null) {
            appRandom = new SecureRandom();
        }

        params = dsaKey.getParams();
        p = params.getP();
        q = params.getQ();
        g = params.getG();
        x = ((DSAPrivateKey) dsaKey).getX();

        // forming signature according algorithm described in chapter 5 of DSA standard

        digestBI = new BigInteger(1, msgDigest.digest());

        randomBytes = new byte[20];

        for (;;) {

            appRandom.nextBytes(randomBytes);

            k = new BigInteger(1, randomBytes);
            if (k.compareTo(q) != -1) {
                continue;
            }
            r = g.modPow(k, p).mod(q);
            if (r.signum() == 0) {
                continue;
            }

            s = k.modInverse(q).multiply(digestBI.add(x.multiply(r)).mod(q))
                    .mod(q);

            if (s.signum() != 0) {
                break;
            }
        }

        // forming signature's ASN1 representation which is SEQUENCE of two INTEGERs
        //
        rBytes = r.toByteArray();
        n1 = rBytes.length;
        if ((rBytes[0] & 0x80) != 0) {
            n1++;
        }
        sBytes = s.toByteArray();
        n2 = sBytes.length;
        if ((sBytes[0] & 0x80) != 0) {
            n2++;
        }

        signature = new byte[6 + n1 + n2]; // 48 is max. possible length of signature
        signature[0] = (byte) 0x30; // ASN1 SEQUENCE tag
        signature[1] = (byte) (4 + n1 + n2); // total length of two INTEGERs
        signature[2] = (byte) 0x02; // ASN1 INTEGER tag
        signature[3] = (byte) n1; // length of r
        signature[4 + n1] = (byte) 0x02; // ASN1 INTEGER tag
        signature[5 + n1] = (byte) n2; // length of s

        if (n1 == rBytes.length) {
            n = 4;
        } else {
            n = 5;
        }
        System.arraycopy(rBytes, 0, signature, n, rBytes.length);

        if (n2 == sBytes.length) {
            n = 6 + n1;
        } else {
            n = 7 + n1;
        }
        System.arraycopy(sBytes, 0, signature, n, sBytes.length);

        return signature;
    }

    /**
     * Updates data to sign or to verify.
     *
     * @params
     *    b byte to update
     * @throws
     *    SignatureException if object was not initialized for signing or verifying
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.659 -0400", hash_original_method = "25B4B3738F76CD829B542B29AB479C5C", hash_generated_method = "DAB4EDC68A95EDFC0B447329BEC057AA")
    
protected void engineUpdate(byte b) throws SignatureException {

        msgDigest.update(b);
    }

    /**
     * Updates data to sign or to verify.
     *
     * @params
     *    b byte array containing bytes to update
     * @params
     *    off offset in byte array to start from
     * @params
     *    len number of bytes to use for updating
     * @throws
     *    SignatureException if object was not initialized for signing or verifying
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.660 -0400", hash_original_method = "C87C6DB5D39F6DF13239553E585618AB", hash_generated_method = "2FA30129C9F981C834AD25D11A91AD17")
    
protected void engineUpdate(byte[] b, int off, int len)
            throws SignatureException {

        msgDigest.update(b, off, len);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.662 -0400", hash_original_method = "B92CF0B0B88C858A2E924EFFD0F3E4F1", hash_generated_method = "E979E658953323A007DCEF4924D328AE")
    
private boolean checkSignature(byte[] sigBytes, int offset, int length)
            throws SignatureException {

        // names of below BigIntegers are the same as they are defined in DSA standard
        BigInteger r, s, w;
        BigInteger u1, u2, v;

        // parameters and public key
        BigInteger p, q, g, y;

        DSAParams params;

        int n1, n2;

        byte[] bytes;
        byte[] digest;

        // checking up on signature's ASN1
        try {
            byte dummy;
            n1 = sigBytes[offset + 3];
            n2 = sigBytes[offset + n1 + 5];

            if (sigBytes[offset + 0] != 0x30 || sigBytes[offset + 2] != 2
                    || sigBytes[offset + n1 + 4] != 2
                    || sigBytes[offset + 1] != (n1 + n2 + 4) || n1 > 21
                    || n2 > 21
                    || (length != 0 && (sigBytes[offset + 1] + 2) > length)) {
                throw new SignatureException("signature bytes have invalid encoding");
            }

            dummy = sigBytes[5 + n1 + n2]; // to check length of sigBytes
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SignatureException("bad argument: byte[] is too small");
        }

        digest = msgDigest.digest();

        bytes = new byte[n1];
        System.arraycopy(sigBytes, offset + 4, bytes, 0, n1);
        r = new BigInteger(bytes);

        bytes = new byte[n2];
        System.arraycopy(sigBytes, offset + 6 + n1, bytes, 0, n2);
        s = new BigInteger(bytes);

        params = dsaKey.getParams();
        p = params.getP();
        q = params.getQ();
        g = params.getG();
        y = ((DSAPublicKey) dsaKey).getY();

        // forming signature according algorithm described in chapter 6 of DSA standard

        if (r.signum() != 1 || r.compareTo(q) != -1 || s.signum() != 1
                || s.compareTo(q) != -1) {
            return false;
        }

        w = s.modInverse(q);

        u1 = (new BigInteger(1, digest)).multiply(w).mod(q);
        u2 = r.multiply(w).mod(q);

        v = g.modPow(u1, p).multiply(y.modPow(u2, p)).mod(p).mod(q);

        if (v.compareTo(r) != 0) {
            return false;
        }
        return true;
    }

    /**
     * Verifies the signature bytes.
     *
     * @params
     *    sigBytes byte array with signature bytes to verify.
     * @return
     *    true if signature bytes were verified, false otherwise
     * @throws
     *    SignatureException if object's state is not VERIFY or
     *                       signature format is not ASN1 representation or
     *                       signature algorithm cannot process data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.662 -0400", hash_original_method = "BE48E4EE0EF08F7A1FF71FC85496EC61", hash_generated_method = "C5E056556B0ECC757EF8DCAC79048F57")
    
protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        if (sigBytes == null) {
            throw new NullPointerException("sigBytes == null");
        }

        return checkSignature(sigBytes, 0, 0);
    }

    /**
     * Verifies the signature bytes.
     *
     * @params
     *    sigBytes byte array with signature bytes to verify.
     * @params
     *    offset index in sigBytes to start from
     * @params
     *    length number of bytes allotted for signature
     * @return
     *    true if signature bytes were verified, false otherwise
     * @throws
     *    SignatureException if object's state is not VERIFY or
     *                       signature format is not ASN1 representation or
     *                       signature algorithm cannot process data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.663 -0400", hash_original_method = "C785E1255DBAB6B7D98E548DC14AD6C8", hash_generated_method = "474643B385CA82B7220A24627CA94C44")
    
protected boolean engineVerify(byte[] sigBytes, int offset, int length)
            throws SignatureException {
        return checkSignature(sigBytes, offset, length);
    }
}
