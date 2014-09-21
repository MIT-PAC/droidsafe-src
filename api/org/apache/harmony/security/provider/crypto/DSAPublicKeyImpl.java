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

 /*
  * TODO
  * 1. The class extends the PublicKeyImpl class in "org.apache.harmony.security" package.
  *
  * 2. The class uses methods in the auxiliary non-public "ThreeIntegerSequence" class
  *    defined along with the "DSAPrivateKeyImpl" class.
  *
  * 3. See a compatibility with RI comments
  *    in the below "DSAPublicKeyImpl(X509EncodedKeySpec keySpec)" constructor.
  */

package org.apache.harmony.security.provider.crypto;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.NotActiveException;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.apache.harmony.security.PublicKeyImpl;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.AlgorithmIdentifier;
import org.apache.harmony.security.x509.SubjectPublicKeyInfo;

/**
 * The class provides DSAPublicKey functionality by extending a class implementing PublicKey
 * and implementing methods defined in both interfaces, DSAKey and DSAPublicKey
 */
public class DSAPublicKeyImpl extends PublicKeyImpl implements DSAPublicKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.307 -0400", hash_original_field = "3328B3965FEA56949E85DDBF721026FD", hash_generated_field = "2EB5214174C08F08EEE12B7E5A4729A4")

    private static final long serialVersionUID = -2279672131310978336L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.307 -0400", hash_original_field = "5066445BC4A74C0C3E5F74CB9398ADD2", hash_generated_field = "56D169B0629E43F286E089C0EF358E41")


    private BigInteger y, g, p, q;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.308 -0400", hash_original_field = "8D522B4B65693839F4E2E5FAE1E0C771", hash_generated_field = "709C246A6619A82DE0494FAF1667DC5F")


    private transient DSAParams params;

    /**
     * Creates object from DSAPublicKeySpec.
     *
     * @param keySpec - a DSAPublicKeySpec object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.309 -0400", hash_original_method = "F0725042EAC128B6189CDCD25CBEB8B6", hash_generated_method = "B6E4CB0DC2E4D77BE59ABA74AE5A76C9")
    
public DSAPublicKeyImpl(DSAPublicKeySpec keySpec) {

        super("DSA");

        SubjectPublicKeyInfo spki;

        p = keySpec.getP();
        q = keySpec.getQ();
        g = keySpec.getG();

        ThreeIntegerSequence threeInts = new ThreeIntegerSequence(p
                .toByteArray(), q.toByteArray(), g.toByteArray());

        AlgorithmIdentifier ai = new AlgorithmIdentifier(AlgNameMapper
                .map2OID("DSA"),
                threeInts.getEncoded());

        y = keySpec.getY();

        spki = new SubjectPublicKeyInfo(ai, ASN1Integer.getInstance().encode(
                y.toByteArray()));
        setEncoding(spki.getEncoded());

        params = (DSAParams) (new DSAParameterSpec(p, q, g));
    }

    /**
     * Creates object from X509EncodedKeySpec.
     *
     * @param keySpec - a X509EncodedKeySpec object
     *
     * @throws InvalidKeySpecException - if key data cannot be obtain from encoded format
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.310 -0400", hash_original_method = "9F945461B80E9E8AE77060DD726B4B61", hash_generated_method = "20289F4599D2CA7C7A97594ED47DC465")
    
public DSAPublicKeyImpl(X509EncodedKeySpec keySpec)
            throws InvalidKeySpecException {

        super("DSA");

        AlgorithmIdentifier ai;
        ThreeIntegerSequence threeInts = null;

        SubjectPublicKeyInfo subjectPublicKeyInfo = null;

        byte[] encoding = keySpec.getEncoded();

        String alg, algName;

        try {
            subjectPublicKeyInfo = (SubjectPublicKeyInfo) SubjectPublicKeyInfo.ASN1
                    .decode(encoding);
        } catch (IOException e) {
            throw new InvalidKeySpecException("Failed to decode keySpec encoding: " + e);
        }

        try {
            y = new BigInteger((byte[]) ASN1Integer.getInstance().decode(
                    subjectPublicKeyInfo.getSubjectPublicKey()));
        } catch (IOException e) {
            throw new InvalidKeySpecException("Failed to decode parameters: " + e);
        }

        ai = subjectPublicKeyInfo.getAlgorithmIdentifier();

        try {
            threeInts = (ThreeIntegerSequence) ThreeIntegerSequence.ASN1
                    .decode(ai.getParameters());
        } catch (IOException e) {
            throw new InvalidKeySpecException("Failed to decode parameters: " + e);
        }
        p = new BigInteger(threeInts.p);
        q = new BigInteger(threeInts.q);
        g = new BigInteger(threeInts.g);
        params = (DSAParams) (new DSAParameterSpec(p, q, g));

        setEncoding(encoding);

        /*
         * the following code implements RI behavior
         */
        alg = ai.getAlgorithm();
        algName = AlgNameMapper.map2AlgName(alg);
        setAlgorithm(algName == null ? alg : algName);
    }

    /**
     * @return
     *      a value of a public key (y).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.310 -0400", hash_original_method = "E902D6151D4FD6CFB5C854DFA08B0568", hash_generated_method = "DFB59F5A3C2E9D3EBF4F764FC762B9D4")
    
public BigInteger getY() {
        return y;
    }

    /**
     * @return
     *     DSA key parameters (p, q, g).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.311 -0400", hash_original_method = "2D817E93DBDD33B47843C3A6DE30BAA8", hash_generated_method = "4B5BF1196D64639F92126200B0F20348")
    
public DSAParams getParams() {
        return params;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.312 -0400", hash_original_method = "6ED6114E95F606AE9552005720EC5FC8", hash_generated_method = "6E3DA77FB6ABFBCC49C4DF012FC064ED")
    
private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        in.defaultReadObject();
        params = new DSAParameterSpec(p, q, g);
    }

}
