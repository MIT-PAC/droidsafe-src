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
  * 1. The class extends the PrivateKeyImpl class in "org.apache.harmony.security" package.
  *
  * 2. See a compatibility with RI comments
  *    in the below "DSAPrivateKeyImpl(PKCS8EncodedKeySpec keySpec)" constructor.
  */


package org.apache.harmony.security.provider.crypto;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.NotActiveException;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.harmony.security.PrivateKeyImpl;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.pkcs8.PrivateKeyInfo;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/**
 * The class provides DSAPrivateKey functionality by extending a class implementing PrivateKey
 * and implementing methods defined in both interfaces, DSAKey and DSAPrivateKey
 */
public class DSAPrivateKeyImpl extends PrivateKeyImpl implements DSAPrivateKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.059 -0400", hash_original_field = "0B391B6D731F3C2ABB84D6E1ADC4BB66", hash_generated_field = "36F51AC38F1DF0774E9EFC3EE0B35D09")

    private static final long serialVersionUID = -4716227614104950081L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.060 -0400", hash_original_field = "CA6C313B3D369866F1618EBB330A5284", hash_generated_field = "5C791039D82B347F6C0003A53B18FE19")


    private BigInteger x, g, p, q;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.060 -0400", hash_original_field = "8D522B4B65693839F4E2E5FAE1E0C771", hash_generated_field = "709C246A6619A82DE0494FAF1667DC5F")


    private transient DSAParams params;

    /**
     * Creates object from DSAPrivateKeySpec.
     *
     * @param keySpec - a DSAPrivateKeySpec object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.061 -0400", hash_original_method = "94714D6AF1AD7651029C5EBF06AD34A8", hash_generated_method = "2BB496CFDDC5DAE90582DEA99219ACA9")
    
public DSAPrivateKeyImpl(DSAPrivateKeySpec keySpec) {

        super("DSA");

        PrivateKeyInfo pki;

        g = keySpec.getG();
        p = keySpec.getP();
        q = keySpec.getQ();

        ThreeIntegerSequence threeInts = new ThreeIntegerSequence(p
                .toByteArray(), q.toByteArray(), g.toByteArray());

        AlgorithmIdentifier ai = new AlgorithmIdentifier(AlgNameMapper
                .map2OID("DSA"),
                threeInts.getEncoded());
        x = keySpec.getX();

        pki = new PrivateKeyInfo(0, ai, ASN1Integer.getInstance().encode(
                x.toByteArray()), null);

        setEncoding(pki.getEncoded());

        params = new DSAParameterSpec(p, q, g);
    }

    /**
     * Creates object from PKCS8EncodedKeySpec.
     *
     * @param keySpec - a XPKCS8EncodedKeySpec object
     *
     * @throws InvalidKeySpecException - if key data cannot be obtain from encoded format
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.062 -0400", hash_original_method = "32C24B2CF557E0D0099C886AAC112577", hash_generated_method = "009BD546487B1FA8F6E49F0554F2D42A")
    
public DSAPrivateKeyImpl(PKCS8EncodedKeySpec keySpec)
            throws InvalidKeySpecException {

        super("DSA");

        AlgorithmIdentifier ai;
        ThreeIntegerSequence threeInts = null;

        String alg, algName;

        byte[] encoding = keySpec.getEncoded();

        PrivateKeyInfo privateKeyInfo = null;

        try {
            privateKeyInfo = (PrivateKeyInfo) PrivateKeyInfo.ASN1
                    .decode(encoding);
        } catch (IOException e) {
            throw new InvalidKeySpecException("Failed to decode keySpec encoding: " + e);
        }

        try {
            x = new BigInteger((byte[]) ASN1Integer.getInstance().decode(
                    privateKeyInfo.getPrivateKey()));
        } catch (IOException e) {
            throw new InvalidKeySpecException("Failed to decode parameters: " + e);
        }

        ai = privateKeyInfo.getAlgorithmIdentifier();
        try {
            threeInts = (ThreeIntegerSequence) ThreeIntegerSequence.ASN1
                    .decode(ai.getParameters());
        } catch (IOException e) {
            throw new InvalidKeySpecException("Failed to decode parameters: " + e);
        }
        p = new BigInteger(threeInts.p);
        q = new BigInteger(threeInts.q);
        g = new BigInteger(threeInts.g);
        params = new DSAParameterSpec(p, q, g);
        setEncoding(encoding);

        /*
         * the following code implements RI behavior
         */
        alg = ai.getAlgorithm();
        algName = AlgNameMapper.map2AlgName(alg);
        setAlgorithm(algName == null ? alg : algName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.063 -0400", hash_original_method = "67A367EC1A42595A125F9EA99F2EC9F5", hash_generated_method = "B144ED3669B4AEF784786CAB344FA847")
    
public BigInteger getX() {
        return x;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.063 -0400", hash_original_method = "2D817E93DBDD33B47843C3A6DE30BAA8", hash_generated_method = "4B5BF1196D64639F92126200B0F20348")
    
public DSAParams getParams() {
        return params;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:05.064 -0400", hash_original_method = "6ED6114E95F606AE9552005720EC5FC8", hash_generated_method = "6E3DA77FB6ABFBCC49C4DF012FC064ED")
    
private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        in.defaultReadObject();
        params = new DSAParameterSpec(p, q, g);
    }

}
