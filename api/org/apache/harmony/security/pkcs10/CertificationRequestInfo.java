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
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.Name;
import org.apache.harmony.security.x509.SubjectPublicKeyInfo;

/**
 * CertificationRequestInfo ::= SEQUENCE {
 *   version Version,
 *   subject Name,
 *   subjectPublicKeyInfo SubjectPublicKeyInfo,
 *   attributes [0] IMPLICIT Attributes }
 *
 * Version ::= INTEGER
 *
 * Attributes ::= SET OF Attribute
 */
public final class CertificationRequestInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.866 -0400", hash_original_field = "D57C21E33284CB74D7A81C435FB7BC9B", hash_generated_field = "5575EB445B1E76509F0CA4CA9B935A87")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(),              // version
            Name.ASN1,                              // subject
            SubjectPublicKeyInfo.ASN1,              // subjectPublicKeyInfo
            new ASN1Implicit(0, new ASN1SetOf(
                    AttributeTypeAndValue.ASN1))    // attributes
            }) {

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new CertificationRequestInfo(
                    ASN1Integer.toIntValue(values[0]),
                    (Name) values[1],
                    (SubjectPublicKeyInfo) values[2],
                    (List<?>) values[3],
                    in.getEncoded());
        }

        @Override protected void getValues(Object object, Object[] values) {
            CertificationRequestInfo certReqInfo = (CertificationRequestInfo) object;
            values[0] = ASN1Integer.fromIntValue(certReqInfo.version);
            values[1] = certReqInfo.subject;
            values[2] = certReqInfo.subjectPublicKeyInfo;
            values[3] = certReqInfo.attributes;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.858 -0400", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.859 -0400", hash_original_field = "62128280F9439E84A11C8FD57836730A", hash_generated_field = "74A60B29582F19500BDD9E22B68B11F7")

    private  Name subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.859 -0400", hash_original_field = "B0B8278CF79DE1BD38516FAC424CAD16", hash_generated_field = "FFF504BB80D284CF6640975B8E382935")

    private  SubjectPublicKeyInfo subjectPublicKeyInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.860 -0400", hash_original_field = "7BCDFC21A583830475B5EDCA6B9D1D3C", hash_generated_field = "10B2734C32F00310D96D6B9F095C534A")

    private  List<?> attributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.860 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.861 -0400", hash_original_method = "72DBAB03CD7542A5F322B8E54927C676", hash_generated_method = "FC67DB91EF1F92BCF8DB4C1A01BD3522")
    
private CertificationRequestInfo(int version, Name subject,
            SubjectPublicKeyInfo subjectPublicKeyInfo, List<?> attributes, byte [] encoding) {
        this.version = version;
        this.subject = subject;
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
        this.attributes = attributes;
        this.encoding = encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.861 -0400", hash_original_method = "01CA74A643B409E53785F17175CB2AB2", hash_generated_method = "7037021A45CF98F236A339130B97E1E4")
    
public Name getSubject() {
        return subject;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.862 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

    /**
     * Returns ASN.1 encoded form of this CertificationRequestInfo.
     * @return a byte array containing ASN.1 encode form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.862 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.863 -0400", hash_original_method = "D28709CA99B97B72BA9F98E7200568E8", hash_generated_method = "74D3A79044A0CDCF2408CE4C7C2EB90B")
    
@Override public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-- CertificationRequestInfo:");
        res.append("\n version: ");
        res.append(version);
        res.append("\n subject: ");
        res.append(subject.getName(X500Principal.CANONICAL));
        res.append("\n subjectPublicKeyInfo: ");
        res.append("\n\t algorithm: ");
        res.append(subjectPublicKeyInfo.getAlgorithmIdentifier().getAlgorithm());
        res.append("\n\t public key: ").append(subjectPublicKeyInfo.getPublicKey());
        res.append("\n attributes: ");
        if (attributes != null) {
            res.append(attributes.toString());
        } else {
            res.append("none");
        }
        res.append("\n-- CertificationRequestInfo End\n");
        return res.toString();
    }
}

