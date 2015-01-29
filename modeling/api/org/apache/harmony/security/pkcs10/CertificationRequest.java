/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.apache.harmony.security.pkcs10;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/**
 * The class implements the ASN.1 DER encoding and decoding of the PKCS#10
 * Certificate Signing Request (CSR). Its ASN notation is as follows:
 *
 * CertificationRequest ::= SEQUENCE {
 *   certificationRequestInfo CertificationRequestInfo,
 *   signatureAlgorithm SignatureAlgorithmIdentifier,
 *   signature Signature
 * }
 *
 * SignatureAlgorithmIdentifier ::= AlgorithmIdentifier
 *
 * Signature ::= BIT STRING
 */
public final class CertificationRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.908 -0400", hash_original_field = "3AB5D4718235CD99B12E476A36044B51", hash_generated_field = "816B4D50DEEB0F3E198A4E27B9143E68")


    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            CertificationRequestInfo.ASN1,  // info
            AlgorithmIdentifier.ASN1,       // signatureAlgorithm
            ASN1BitString.getInstance() })  // signature
    {

        public Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new CertificationRequest(
                    (CertificationRequestInfo) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes,
                    in.getEncoded());
        }

        protected void getValues(Object object, Object[] values) {
            CertificationRequest certReq = (CertificationRequest) object;
            values[0] = certReq.info;
            values[1] = certReq.algId;
            values[2] = new BitString(certReq.signature, 0);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.902 -0400", hash_original_field = "C3343109C828AFF8F61860B025922DEC", hash_generated_field = "9C4588E3C971A790248F1BB594CC52C5")

    private CertificationRequestInfo info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.902 -0400", hash_original_field = "77AE1AC968895C7830B8ADE3B24ECA2A", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.903 -0400", hash_original_field = "89CE5EB976882E5EBBD495E98D430D47", hash_generated_field = "0DB6F7EB15A1BDD9737913A895BFEA57")

    private byte[] signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.903 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.903 -0400", hash_original_method = "45358DB9ABC9DA19710E31FA9959CE82", hash_generated_method = "2CEE668B4A08CF315FDFE23208D30DC0")
    
public CertificationRequest(CertificationRequestInfo info,
            AlgorithmIdentifier algId, byte[] signature) {
        this.info = info;
        this.algId = algId;
        this.signature = signature.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.904 -0400", hash_original_method = "943EC6DB5ED1DB2179738DF04DC7DF76", hash_generated_method = "5A1E0F5A0E31681E0B222BFD612D610B")
    
private CertificationRequest(CertificationRequestInfo info,
            AlgorithmIdentifier algId, byte[] signature, byte[] encoding) {
        this(info, algId, signature);
        this.encoding = encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.905 -0400", hash_original_method = "B5D6D794206380DD4BD5D42A60FB0ED1", hash_generated_method = "F2387BAF772488D195496CAA37B10CCF")
    
public CertificationRequestInfo getInfo() {
        return info;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.906 -0400", hash_original_method = "3CA288AC5164D2F92319FEEABB2663B1", hash_generated_method = "3D4F606431139F03315C1F32AE0ADD6E")
    
public byte[] getSignature() {
        byte[] result = new byte[signature.length];
        System.arraycopy(signature, 0, result, 0, signature.length);
        return result;
    }

    /**
     * Returns ASN.1 encoded form of this CertificationRequest value.
     * @return a byte array containing ASN.1 encode form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.906 -0400", hash_original_method = "66C81055A4F56D65DE0200C4A3FCE883", hash_generated_method = "FDF051C7DDC7A1EDCD12E18C57BFA391")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = CertificationRequest.ASN1.encode(this);
        }
        return encoding;
    }
}

