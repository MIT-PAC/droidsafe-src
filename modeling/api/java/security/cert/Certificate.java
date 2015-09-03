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


package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

public abstract class Certificate implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.469 -0500", hash_original_field = "8E6CD851C821763F93F2E7105A2055E8", hash_generated_field = "F128B9ED7E1B9361939A91BA465EE1B0")

    private static final long serialVersionUID = -3585440601605666277L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.472 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private  String type;

    /**
     * Creates a new {@code Certificate} with the specified type.
     *
     * @param type
     *        the certificate type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.475 -0500", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "7E6AB88BF20FAB0DC3B4C8921EFB4576")
    
protected Certificate(String type) {
        this.type = type;
    }

    /**
     * Returns the certificate type.
     *
     * @return the certificate type.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.477 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B5025B3379E65F477B29B0C5C8B783DF")
    
public final String getType() {
        return type;
    }

    /**
     * Compares the argument to the certificate, and returns {@code true} if they
     * represent the <em>same</em> object using a class specific comparison. The
     * implementation in Object returns {@code true} only if the argument is the
     * exact same object as the callee (==).
     *
     * @param other
     *            the object to compare with this object.
     * @return {@code true} if the object is the same as this object, {@code
     *         false} if it is different from this object.
     * @see #hashCode
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.480 -0500", hash_original_method = "34CF5F66357C97013C2BECCDE3CD7868", hash_generated_method = "CB7A0637A804C1CA7A3D3549848E7BED")
    
public boolean equals(Object other) {
        // obj equal to itself
        if (this == other) {
            return true;
        }
        if (other instanceof Certificate) {
            try {
                // check that encoded forms match
                return Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded());
            } catch (CertificateEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    /**
     * Returns an integer hash code for the certificate. Any two objects which
     * return {@code true} when passed to {@code equals} must return the same
     * value for this method.
     *
     * @return the certificate's hash
     * @see #equals
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.482 -0500", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "5D55046C19366A7C7BE7FE5BAB364BD7")
    
public int hashCode() {
        try {
            byte[] encoded = getEncoded();
            int hash = 0;
            for (int i=0; i<encoded.length; i++) {
                hash += i*encoded[i];
            }
            return hash;
        } catch (CertificateEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the encoded representation for this certificate.
     *
     * @return the encoded representation for this certificate.
     * @throws CertificateEncodingException
     *             if the encoding fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.484 -0500", hash_original_method = "97985BC010DD1187CA9D18F27C6321CC", hash_generated_method = "967CA908BE3445AA84C7FF1C69EFF907")
    
public abstract byte[] getEncoded() throws CertificateEncodingException;

    /**
     * Verifies that this certificate was signed with the given public key.
     *
     * @param key
     *            PublicKey public key for which verification should be
     *            performed.
     * @throws CertificateException
     *             if encoding errors are detected.
     * @throws NoSuchAlgorithmException
     *             if an unsupported algorithm is detected.
     * @throws InvalidKeyException
     *             if an invalid key is detected.
     * @throws NoSuchProviderException
     *             if there is no default provider.
     * @throws SignatureException
     *             if signature errors are detected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.487 -0500", hash_original_method = "B83CE65D5C6D1244820061871FC42D24", hash_generated_method = "25F475487B3388B4A59788D7DA6ADFA1")
    
public abstract void verify(PublicKey key)
        throws CertificateException,
               NoSuchAlgorithmException,
               InvalidKeyException,
               NoSuchProviderException,
               SignatureException;

    /**
     * Verifies that this certificate was signed with the given public key. It
     * Uses the signature algorithm given by the provider.
     *
     * @param key
     *            PublicKey public key for which verification should be
     *            performed.
     * @param sigProvider
     *            String the name of the signature provider.
     * @exception CertificateException
     *                if encoding errors are detected.
     * @exception NoSuchAlgorithmException
     *                if an unsupported algorithm is detected.
     * @exception InvalidKeyException
     *                if an invalid key is detected.
     * @exception NoSuchProviderException
     *                if the specified provider does not exists.
     * @exception SignatureException
     *                if signature errors are detected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.490 -0500", hash_original_method = "206D0A21D5BAE0F83A1719C1D14A7E35", hash_generated_method = "D17B985B54E602C77696D4D138B8890E")
    
public abstract void verify(PublicKey key, String sigProvider)
        throws CertificateException,
               NoSuchAlgorithmException,
               InvalidKeyException,
               NoSuchProviderException,
               SignatureException;

    /**
     * Returns a string containing a concise, human-readable description of the
     * certificate.
     *
     * @return a printable representation for the certificate.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.492 -0500", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "7EA90E50E51652C3FF11C3BD32031D10")
    
public abstract String toString();

    /**
     * Returns the public key corresponding to this certificate.
     *
     * @return the public key corresponding to this certificate.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.495 -0500", hash_original_method = "F2C717FDFBF8A1EA046A033A3AA9C5CC", hash_generated_method = "D544FA3197F301F074C9140DD12C3EA0")
    
public abstract PublicKey getPublicKey();
    
    protected static class CertificateRep implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.501 -0500", hash_original_field = "F30BFE25CCAFE9B43B2B3628B004F6F9", hash_generated_field = "945034F4E24059F289CC97EFC7BB0CA4")

        private static final long serialVersionUID = -8563758940495660020L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.508 -0500", hash_original_field = "F5371AF1F17086E8835088DFDB9C2730", hash_generated_field = "711682546E3189478C2A696C169FECF1")

        // for the certificate data
        private static final ObjectStreamField[] serialPersistentFields = {
             new ObjectStreamField("type", String.class),
             new ObjectStreamField("data", byte[].class, true)
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.503 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private  String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.505 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private  byte[] data;

        /**
         * Creates a new {@code CertificateRep} instance with the specified
         * certificate type and encoded data.
         *
         * @param type
         *            the certificate type.
         * @param data
         *            the encoded data.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.512 -0500", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "76D1E475C5E55E2415D3D023DC543D55")
        
protected CertificateRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
        }

        /**
         * Deserializes a {@code Certificate} from a serialized {@code
         * CertificateRep} object.
         *
         * @return the deserialized {@code Certificate}.
         * @throws ObjectStreamException
         *             if deserialization fails.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.516 -0500", hash_original_method = "4FCDFCCBC9683C8411983C8346CDCC6D", hash_generated_method = "A662305A92047A8E4F6EEC5411D6840B")
        
protected Object readResolve() throws ObjectStreamException {
            try {
                CertificateFactory cf = CertificateFactory.getInstance(type);
                return cf.generateCertificate(new ByteArrayInputStream(data));
            } catch (Throwable t) {
                throw new NotSerializableException("Could not resolve certificate: " + t);
            }
        }
    }

    /**
     * Returns an alternate object to be serialized.
     *
     * @return the object to serialize.
     * @throws ObjectStreamException
     *             if the creation of the alternate object fails.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.497 -0500", hash_original_method = "99E789CC29F8A2F97D8F3F24132FD9A6", hash_generated_method = "27FE5217C5BD51037D61E9067A177D34")
    
protected Object writeReplace() throws ObjectStreamException {
        try {
            return new CertificateRep(getType(), getEncoded());
        } catch (CertificateEncodingException e) {
            throw new NotSerializableException("Could not create serialization object: " + e);
        }
    }
}

