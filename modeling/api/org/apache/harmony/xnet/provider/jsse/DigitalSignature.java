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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLException;

import libcore.util.EmptyArray;

public class DigitalSignature {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.081 -0500", hash_original_field = "7CC4ADADCF5B81E1EEBC5F8C930336A6", hash_generated_field = "B22BEAD2E03E6DC9EC1B452A01F5C921")

    private  MessageDigest md5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.084 -0500", hash_original_field = "592D6316376DEACF69E66590DC353E6F", hash_generated_field = "4A489BD95B8D8991536BCB0FDC9BD1C9")

    private  MessageDigest sha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.086 -0500", hash_original_field = "EC06E323FECB8C62AEE073552BA8B997", hash_generated_field = "EDE925851E2EC9CBDC61CDF457BBC562")

    private  Signature signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.088 -0500", hash_original_field = "250DADA90730C7EEAE534A8757581875", hash_generated_field = "2FF9F58B969F4213F59ABA296D3A8FC3")

    private  Cipher cipher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.090 -0500", hash_original_field = "6D7F1C9781B034E9B4D3A26FE78DE093", hash_generated_field = "ECDEF14A5FC64303858BAA6FBF50E641")

    private byte[] md5_hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.092 -0500", hash_original_field = "8A714E63FEDBB082B1F2333567E3203D", hash_generated_field = "433DF2E11EA67703110F7E1DEC3E0303")

    private byte[] sha_hash;

    /**
     * Create Signature type
     * @param keyExchange
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.095 -0500", hash_original_method = "038F050AED1C1465ECEA892ABE879633", hash_generated_method = "37D3615CD89AA875D9B50012D35E60C5")
    
public DigitalSignature(String authType) {
        try {
            sha = MessageDigest.getInstance("SHA-1");

            if ("RSA".equals(authType)) {
                md5 = MessageDigest.getInstance("MD5");
                cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                signature = null;
            } else if ("DSA".equals(authType)) {
                // SignatureAlgorithm is dsa
                signature = Signature.getInstance("NONEwithDSA");
                cipher = null;
                md5 = null;
            } else {
                cipher = null;
                signature = null;
                md5 = null;
            }
        } catch (NoSuchAlgorithmException e) {
            // this should never happen
            throw new AssertionError(e);
        } catch (NoSuchPaddingException e) {
            // this should never happen
            throw new AssertionError(e);
        }
    }

    /**
     * Initiate Signature type by private key
     * @param key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.098 -0500", hash_original_method = "63DCB38A03804A8CF42B493B58B13DDC", hash_generated_method = "AEAC4FC839166262D33179B9687CDBAA")
    
public void init(PrivateKey key) {
        try {
            if (signature != null) {
                signature.initSign(key);
            } else if (cipher != null) {
                cipher.init(Cipher.ENCRYPT_MODE, key);
            }
        } catch (InvalidKeyException e){
            throw new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    new SSLException("init - invalid private key", e));
        }
    }

    /**
     * Initiate Signature type by certificate
     * @param cert
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.100 -0500", hash_original_method = "E5B57B76E0D4C32AD6E030FA95B32ACD", hash_generated_method = "4E152530A4BFC5427EA9048E249667F3")
    
public void init(Certificate cert) {
        try {
            if (signature != null) {
                signature.initVerify(cert);
            } else if (cipher != null) {
                cipher.init(Cipher.DECRYPT_MODE, cert);
            }
        } catch (InvalidKeyException e){
            throw new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    new SSLException("init - invalid certificate", e));
        }
    }

    /**
     * Update Signature hash
     * @param data
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.102 -0500", hash_original_method = "D74E9B3F4153C40FBC49F204F5B3A569", hash_generated_method = "861F80BA57DAB6188BC7528574E17ECD")
    
public void update(byte[] data) {
        if (sha != null) {
            sha.update(data);
        }
        if (md5 != null) {
            md5.update(data);
        }
    }

    /**
     * Sets MD5 hash
     * @param data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.104 -0500", hash_original_method = "B9CA7162ECD9A3463C27E4B77DAB6CBA", hash_generated_method = "B2C997D93DF7FF92764956BED0EE6FC9")
    
public void setMD5(byte[] data) {
        md5_hash = data;
    }

    /**
     * Sets SHA hash
     * @param data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.106 -0500", hash_original_method = "3BA66B7FA2FDB006FB2AA15DCD71C98C", hash_generated_method = "A70140005B1087EEEFD34FD7110702AF")
    
public void setSHA(byte[] data) {
        sha_hash = data;
    }

    /**
     * Sign hash
     * @return Signature bytes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.109 -0500", hash_original_method = "15C049C524B86A812CBA705875D88ECC", hash_generated_method = "BD32B7EA335E67CCD4B57B00481C37AC")
    
public byte[] sign() {
        try {
            if (md5 != null && md5_hash == null) {
                md5_hash = new byte[16];
                md5.digest(md5_hash, 0, md5_hash.length);
            }
            if (md5_hash != null) {
                if (signature != null) {
                    signature.update(md5_hash);
                } else if (cipher != null) {
                    cipher.update(md5_hash);
                }
            }
            if (sha != null && sha_hash == null) {
                sha_hash = new byte[20];
                sha.digest(sha_hash, 0, sha_hash.length);
            }
            if (sha_hash != null) {
                if (signature != null) {
                    signature.update(sha_hash);
                } else if (cipher != null) {
                    cipher.update(sha_hash);
                }
            }
            if (signature != null) {
                return signature.sign();
            } else if (cipher != null) {
                return cipher.doFinal();
            }
            return EmptyArray.BYTE;
        } catch (DigestException e){
            return EmptyArray.BYTE;
        } catch (SignatureException e){
            return EmptyArray.BYTE;
        } catch (BadPaddingException e){
            return EmptyArray.BYTE;
        } catch (IllegalBlockSizeException e){
            return EmptyArray.BYTE;
        }
    }

    /**
     * Verifies the signature data.
     * @param data - the signature bytes
     * @return true if verified
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.112 -0500", hash_original_method = "19503CD9A5095168C8826497974984EF", hash_generated_method = "3B202AB2B61DB7B9D4BF59F0F08CBF8C")
    
public boolean verifySignature(byte[] data) {
        if (signature != null) {
            try {
                signature.update(sha_hash);
                return signature.verify(data);
            } catch (SignatureException e) {
                return false;
            }
        }

        if (cipher != null) {
            final byte[] decrypt;
            try {
                decrypt = cipher.doFinal(data);
            } catch (IllegalBlockSizeException e) {
                return false;
            } catch (BadPaddingException e) {
                return false;
            }

            final byte[] md5_sha;
            if (md5_hash != null && sha_hash != null) {
                md5_sha = new byte[md5_hash.length + sha_hash.length];
                System.arraycopy(md5_hash, 0, md5_sha, 0, md5_hash.length);
                System.arraycopy(sha_hash, 0, md5_sha, md5_hash.length, sha_hash.length);
            } else if (md5_hash != null) {
                md5_sha = md5_hash;
            } else {
                md5_sha = sha_hash;
            }

            return Arrays.equals(decrypt, md5_sha);
        } else if (data == null || data.length == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}

