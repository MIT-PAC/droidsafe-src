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


package org.apache.harmony.security.pkcs8;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/**
 * The class implements the ASN.1 DER encoding and decoding of the PKCS#8
 * PrivateKeyInfo having the following ASN.1 notation:
 *
 *  PrivateKeyInfo ::= SEQUENCE {
 *      version Version,
 *      privateKeyAlgorithm PrivateKeyAlgorithmIdentifier,
 *      privateKey PrivateKey,
 *      attributes [0] IMPLICIT Attributes OPTIONAL }
 *
 *  Version ::= INTEGER
 *
 *  PrivateKeyAlgorithmIdentifier ::= AlgorithmIdentifier
 *
 *  PrivateKey ::= OCTET STRING
 *
 *  Attributes ::= SET OF Attribute
 */
public final class PrivateKeyInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.214 -0400", hash_original_field = "1FECAF96956EA878FD49F6C600AE1D5C", hash_generated_field = "BD3FAA5022846C815B0A74BA86B59AF8")


    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {

    ASN1Integer.getInstance(), // version
            AlgorithmIdentifier.ASN1, // AlgorithmIdentifier
            ASN1OctetString.getInstance(), // privateKey

            new ASN1Implicit(0, new ASN1SetOf(AttributeTypeAndValue.ASN1)) // attributes
            }) {

        {
            setOptional(3); // attributes are OPTIONAL
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new PrivateKeyInfo(ASN1Integer.toIntValue(values[0]),
                    (AlgorithmIdentifier) values[1], (byte[]) values[2],
                    (List) values[3], in.getEncoded());
        }

        protected void getValues(Object object, Object[] values) {
            PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) object;
            values[0] = ASN1Integer.fromIntValue(privateKeyInfo.version);
            values[1] = privateKeyInfo.privateKeyAlgorithm;
            values[2] = privateKeyInfo.privateKey;
            values[3] = privateKeyInfo.attributes;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.206 -0400", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.207 -0400", hash_original_field = "C816AA7A290047B17069BF3982D13392", hash_generated_field = "DCD3FF760285546392B86AC51876294F")

    private  AlgorithmIdentifier privateKeyAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.207 -0400", hash_original_field = "7A31E7F1B6EDE6AF4E1B19DF01434D38", hash_generated_field = "BE60EF378C9319B2F8E46070FC6BDEBB")

    private  byte[] privateKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.208 -0400", hash_original_field = "7BCDFC21A583830475B5EDCA6B9D1D3C", hash_generated_field = "10B2734C32F00310D96D6B9F095C534A")

    private  List<?> attributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.208 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.209 -0400", hash_original_method = "72E5143C8B758399E246DB8527983580", hash_generated_method = "B389821D41CD1FEACEE59827E61CDABD")
    
public PrivateKeyInfo(int version, AlgorithmIdentifier privateKeyAlgorithm,
            byte[] privateKey, List attributes) {
        this.version = version;
        this.privateKeyAlgorithm = privateKeyAlgorithm;
        this.privateKey = privateKey;
        this.attributes = attributes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.209 -0400", hash_original_method = "483FE5935161FE6ED11A94BB2D029842", hash_generated_method = "A922CF58E8049944B8443F74C9DFC937")
    
private PrivateKeyInfo(int version,
            AlgorithmIdentifier privateKeyAlgorithm, byte[] privateKey,
            List attributes, byte[] encoding) {
        this(version, privateKeyAlgorithm, privateKey, attributes);
        this.encoding = encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.210 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.210 -0400", hash_original_method = "F0A3A67DA6A3A100CC10D421033CBDA4", hash_generated_method = "771BFA8AF9D6E108561665875C604B4F")
    
public AlgorithmIdentifier getAlgorithmIdentifier() {
        return privateKeyAlgorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.211 -0400", hash_original_method = "73E4CF055C095B483D0087EB85C8A3A3", hash_generated_method = "328C6022A032159699873879D3373B45")
    
public List getAttributes() {
        return attributes;
    }

    /**
     * Returns the OCTET STRING.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.211 -0400", hash_original_method = "73895E5BEC60560AAD9781607DEA7F24", hash_generated_method = "B1F437780C907D0D6ECCC6186C5A881F")
    
public byte[] getPrivateKey() {
        return privateKey;
    }

    /**
     * Returns ASN.1 encoded form of this PrivateKeyInfo.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.211 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}
