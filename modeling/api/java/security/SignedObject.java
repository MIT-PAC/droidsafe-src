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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A {@code SignedObject} instance acts as a container for another object. The
 * {@code SignedObject} contains the target in serialized form along with a
 * digital signature of the serialized data.
 */
public final class SignedObject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.908 -0400", hash_original_field = "F3BCBFBE8D5CC92538045B6C845CD8CE", hash_generated_field = "E23CD058503DDDCB0F629E42713DAB85")


    private static final long serialVersionUID = 720502720485447167L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.909 -0400", hash_original_field = "6A9B1BF6E4F51C5BBC665A9F39B095B2", hash_generated_field = "2AFA79670796B1E0B73AB75D7B8465D5")


    private byte[] content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.910 -0400", hash_original_field = "89CE5EB976882E5EBBD495E98D430D47", hash_generated_field = "0DB6F7EB15A1BDD9737913A895BFEA57")


    private byte[] signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.912 -0400", hash_original_field = "57E31C88FD86CFF8AD0B06124ABC85C5", hash_generated_field = "2DADE07BCC4267DD9749D37F78A792C0")


    private String thealgorithm;

    /**
     * Constructs a new instance of {@code SignedObject} with the target object,
     * the private key and the engine to compute the signature. The given
     * {@code object} is signed with the specified key and engine.
     *
     * @param object
     *            the object to bes signed.
     * @param signingKey
     *            the private key, used to sign the {@code object}.
     * @param signingEngine
     *            the engine that performs the signature generation.
     * @throws IOException
     *             if a serialization error occurs.
     * @throws InvalidKeyException
     *             if the private key is not valid.
     * @throws SignatureException
     *             if signature generation failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.915 -0400", hash_original_method = "AC3D9830E30DA6FF56DE61871655C3EE", hash_generated_method = "C7B21F2D2DF1C79E824D099023737F11")
    
public SignedObject(Serializable object, PrivateKey signingKey,
            Signature signingEngine) throws IOException, InvalidKeyException,
            SignatureException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        try {
            // Serialize
            oos.writeObject(object);
            oos.flush();
        } finally {
            oos.close();
        }
        content = baos.toByteArray();
        signingEngine.initSign(signingKey);
        thealgorithm = signingEngine.getAlgorithm();
        signingEngine.update(content);
        signature = signingEngine.sign();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.913 -0400", hash_original_method = "F35DD3C05C3241E352EE7B732DBB87CC", hash_generated_method = "1B8BB7ADF716C3FB2EDB78F53AE0E1F7")
    
private void readObject(ObjectInputStream s) throws IOException,
            ClassNotFoundException {

        s.defaultReadObject();
        byte[] tmp = new byte[content.length];
        System.arraycopy(content, 0, tmp, 0, content.length);
        content = tmp;
        tmp = new byte[signature.length];
        System.arraycopy(signature, 0, tmp, 0, signature.length);
        signature = tmp;
    }

    /**
     * Returns the encapsulated object. Each time this method is invoked, the
     * encapsulated object is deserialized before it is returned.
     *
     * @return the encapsulated object.
     * @throws IOException
     *             if deserialization failed.
     * @throws ClassNotFoundException
     *             if the class of the encapsulated object can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.916 -0400", hash_original_method = "8DA76A3250AE69A1BE9620787119B810", hash_generated_method = "9398CD29B142E2AAC3582FB4D773DAA1")
    
public Object getObject() throws IOException, ClassNotFoundException {
        // deserialize our object
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
                content));
        try {
            return ois.readObject();
        } finally {
            ois.close();
        }
    }

    /**
     * Returns the signature data of the encapsulated serialized object.
     *
     * @return the signature data of the encapsulated serialized object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.918 -0400", hash_original_method = "4C65C6279B9442C93D1A97184C2C1F3D", hash_generated_method = "85019443CE2128C6022A3FA916D50FB0")
    
public byte[] getSignature() {
        byte[] sig = new byte[signature.length];
        System.arraycopy(signature, 0, sig, 0, signature.length);
        return sig;
    }

    /**
     * Returns the name of the algorithm of this {@code SignedObject}.
     *
     * @return the name of the algorithm of this {@code SignedObject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.919 -0400", hash_original_method = "3CB494C3E34924526F5C60C9A84F77B0", hash_generated_method = "2EBDA1418535A5663B48ADF1DCBC168A")
    
public String getAlgorithm() {
        return thealgorithm;
    }

    /**
     * Indicates whether the contained signature for the encapsulated object is
     * valid.
     *
     * @param verificationKey
     *            the public key to verify the signature.
     * @param verificationEngine
     *            the signature engine.
     * @return {@code true} if the contained signature for the encapsulated
     *         object is valid, {@code false} otherwise.
     * @throws InvalidKeyException
     *             if the public key is invalid.
     * @throws SignatureException
     *             if signature verification failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.921 -0400", hash_original_method = "4D2B03AB36108D48F19C7175F7C0CB28", hash_generated_method = "95976D1ADF890E5B9396DAB65491CE75")
    
public boolean verify(PublicKey verificationKey,
            Signature verificationEngine) throws InvalidKeyException,
            SignatureException {

        verificationEngine.initVerify(verificationKey);
        verificationEngine.update(content);
        return verificationEngine.verify(signature);
    }

}
