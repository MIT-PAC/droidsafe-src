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


package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * {@code KeyRep} is a standardized representation for serialized {@link Key}
 * objects.
 */
public class KeyRep implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.760 -0400", hash_original_field = "2CBEF3131E96EA654DEDB867795D45DC", hash_generated_field = "2F80997D6C7F6B6754AEE791AE657F45")


    private static final long serialVersionUID = -4757683898830641853L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.761 -0400", hash_original_field = "8D59E72BAC96AD5D9B93B2A1A838C343", hash_generated_field = "0EA6067652BA1144AB67210AF024CE3F")

    private  Type type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.763 -0400", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.764 -0400", hash_original_field = "9E5B91A51CAB853C854D305CDF095F62", hash_generated_field = "3AFBEC2146BDEA5BFCBD2772D27C43DD")

    private  String format;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.765 -0400", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;

    /**
     * Constructs a new instance of {@code KeyRep} with the specified arguments.
     * The arguments should be obtained from the {@code Key} object that has to
     * be serialized.
     *
     * @param type
     *            the type of the key.
     * @param algorithm
     *            the algorithm (obtained by {@link Key#getAlgorithm()}).
     * @param format
     *            the format of the key (obtained by {@link Key#getFormat()}).
     * @param encoded
     *            the encoded {@code byte[]} (obtained by
     *            {@link Key#getEncoded()}).
     * @throws NullPointerException
     *             if {@code type, algorithm, format or encoded} is {@code null}
     *             .
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.767 -0400", hash_original_method = "CD8370052B3BD111EE6EBF04B8052940", hash_generated_method = "4E6B0C239617486F655E89366CFEBF1B")
    
public KeyRep(Type type, String algorithm, String format, byte[] encoded) {
        this.type = type;
        this.algorithm = algorithm;
        this.format = format;
        this.encoded = encoded;
        if(this.type == null) {
            throw new NullPointerException("type == null");
        }
        if(this.algorithm == null) {
            throw new NullPointerException("algorithm == null");
        }
        if(this.format == null) {
            throw new NullPointerException("format == null");
        }
        if(this.encoded == null) {
            throw new NullPointerException("encoded == null");
        }
    }

    /**
     * Resolves and returns the {@code Key} object. Three {@link Type}|format
     * combinations are supported:
     * <ul>
     * <li> {@code Type.PRIVATE} | "PKCS#8" : returns a {@link PrivateKey}
     * instance, generated from a key factory (suitable for the algorithm) that
     * is initialized with a {@link PKCS8EncodedKeySpec} using the encoded key
     * bytes.
     * <li> {@code Type.SECRET} | "RAW" : returns a {@link SecretKeySpec}
     * instance, created with the encoded key bytes and the algorithm.
     * <li> {@code Type.PUBLIC} | "X.509": returns a {@link PublicKey} instance,
     * generated from a key factory (suitable for the algorithm) that is
     * initialized with a {@link X509EncodedKeySpec} using the encoded key
     * bytes.
     * </ul>
     *
     * @return the resolved {@code Key} object.
     * @throws ObjectStreamException
     *             if the {@code Type}|format combination is not recognized, or
     *             the resolution of any key parameter fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.769 -0400", hash_original_method = "4959E3ED7A27DA0C6C35CD7899904292", hash_generated_method = "EA0AF6B5616A2A7B9B9E13FB35CAFB9C")
    
protected Object readResolve() throws ObjectStreamException {
        switch (type) {
        case SECRET:
            if ("RAW".equals(format)) {
                try {
                    return new SecretKeySpec(encoded, algorithm);
                } catch (IllegalArgumentException e) {
                    throw new NotSerializableException("Could not create SecretKeySpec: " + e);
                }
            }
            throw new NotSerializableException("unrecognized type/format combination: " + type + "/" + format);
        case PUBLIC:
            if ("X.509".equals(format)) {
                try {
                    KeyFactory kf = KeyFactory.getInstance(algorithm);
                    return kf.generatePublic(new X509EncodedKeySpec(encoded));
                } catch (NoSuchAlgorithmException e) {
                    throw new NotSerializableException("Could not resolve key: " + e);
                }
                catch (InvalidKeySpecException e) {
                    throw new NotSerializableException("Could not resolve key: " + e);
                }
            }
            throw new NotSerializableException("unrecognized type/format combination: " + type + "/" + format);
        case PRIVATE:
            if ("PKCS#8".equals(format)) {
                try {
                    KeyFactory kf = KeyFactory.getInstance(algorithm);
                    return kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
                } catch (NoSuchAlgorithmException e) {
                    throw new NotSerializableException("Could not resolve key: " + e);
                }
                catch (InvalidKeySpecException e) {
                    throw new NotSerializableException("Could not resolve key: " + e);
                }
            }
            throw new NotSerializableException("unrecognized type/format combination: " + type + "/" + format);
        }
        throw new NotSerializableException("unrecognized key type: " + type);
    }

    // Makes defensive copy of key encoding
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.771 -0400", hash_original_method = "A4D43A24FB2F5401E0E2550D5B1CE4B4", hash_generated_method = "438823C01CB0F9ABE91BEB629CA8063E")
    
private void readObject(ObjectInputStream is)
        throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        byte[] new_encoded = new byte[encoded.length];
        System.arraycopy(encoded, 0, new_encoded, 0, new_encoded.length);
        encoded = new_encoded;
    }

    /**
     * {@code Type} enumerates the supported key types.
     */
    public static enum Type {
        /**
         * Type for secret keys.
         */
        SECRET,
        /**
         * Type for public keys.
         */
        PUBLIC,
        /**
         * Type for private keys.
         */
        PRIVATE
    }
}
