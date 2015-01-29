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

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/

package org.apache.harmony.security.x509;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/**
 * The class encapsulates the ASN.1 DER encoding/decoding work
 * with the following certificate extension (OID: 2.5.29.16)
 * (as specified in RFC 3280 -
 *  Internet X.509 Public Key Infrastructure.
 *  Certificate and Certificate Revocation List (CRL) Profile.
 *  http://www.ietf.org/rfc/rfc3280.txt):
 *
 * <pre>
 * PrivateKeyUsagePeriod ::= SEQUENCE {
 *      notBefore       [0]     GeneralizedTime OPTIONAL,
 *      notAfter        [1]     GeneralizedTime OPTIONAL
 * }
 * </pre>
 */
public final class PrivateKeyUsagePeriod {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.505 -0400", hash_original_field = "CC5BA562F23D6DC1B1158A2350AA6737", hash_generated_field = "4EF5B96535321F66656663AA283AEBF0")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Implicit(0, ASN1GeneralizedTime.getInstance()),
            new ASN1Implicit(1, ASN1GeneralizedTime.getInstance()) }) {
        {
            setOptional(0);
            setOptional(1);
        }

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[])in.content;
            return new PrivateKeyUsagePeriod((Date) values[0], (Date) values[1], in.getEncoded());
        }

        @Override protected void getValues(Object object, Object[] values) {
            PrivateKeyUsagePeriod pkup = (PrivateKeyUsagePeriod) object;
            values[0] = pkup.notBeforeDate;
            values[1] = pkup.notAfterDate;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.499 -0400", hash_original_field = "8FF88C850EA4D60143033229F064BB9F", hash_generated_field = "39DB6FD0B596A697A926A41299AAB01A")

    private  Date notBeforeDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.500 -0400", hash_original_field = "6E70488354283C22D84DB7C843E4B67B", hash_generated_field = "DBE97E823AD76D5AF8D466820EB89B15")

    private  Date notAfterDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.500 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.500 -0400", hash_original_method = "DD744F1D241DD3F8F3D85028F7A4A9A8", hash_generated_method = "5E135D08E622FE6D07E73650935F0CE6")
    
public PrivateKeyUsagePeriod(Date notBeforeDate, Date notAfterDate) {
        this(notBeforeDate, notAfterDate, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.501 -0400", hash_original_method = "D906EB871E1087333DEFF06A06BEEA6F", hash_generated_method = "40DA309C932BC1FE7B78E5F5256556DA")
    
private PrivateKeyUsagePeriod(Date notBeforeDate, Date notAfterDate, byte[] encoding) {
        this.notBeforeDate = notBeforeDate;
        this.notAfterDate = notAfterDate;
        this.encoding = encoding;
    }

    /**
     * Returns the value of notBefore field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.502 -0400", hash_original_method = "A456DD355E5EF3AFF61A785321347B38", hash_generated_method = "91EEF812E9ABBC4DA7CED4AE7A08FE39")
    
public Date getNotBefore() {
        return notBeforeDate;
    }

    /**
     * Returns the value of notAfter field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.502 -0400", hash_original_method = "9F0CC8F22CFB31A4D24DF34FD4BC97AB", hash_generated_method = "9D9B4ABD78F268511357194C06A4644A")
    
public Date getNotAfter() {
        return notAfterDate;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 PrivateKeyUsagePeriod value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:59.503 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}

