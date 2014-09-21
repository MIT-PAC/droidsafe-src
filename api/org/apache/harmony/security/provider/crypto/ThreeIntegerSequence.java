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


package org.apache.harmony.security.provider.crypto;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;


/**
 * The auxiliary class providing means to process ASN1Sequence of three Integers.
 * Such sequences are parts of ASN1 encoded formats for DSA private and public keys.
 */
class ThreeIntegerSequence {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.174 -0400", hash_original_field = "ACF45A1B46707A88E82D6597AB7EFDBD", hash_generated_field = "75948C5B082C823390E2781AA4626402")


    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(), ASN1Integer.getInstance(),
            ASN1Integer.getInstance() }) {

        protected Object getDecodedObject(BerInputStream in) {

            Object[] values = (Object[]) in.content;

            return new ThreeIntegerSequence((byte[]) values[0],
                    (byte[]) values[1], (byte[]) values[2]);
        }

        protected void getValues(Object object, Object[] values) {

            ThreeIntegerSequence mySeq = (ThreeIntegerSequence) object;

            values[0] = mySeq.p;
            values[1] = mySeq.q;
            values[2] = mySeq.g;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.170 -0400", hash_original_field = "C32F911995843B7FF6D232578057F97A", hash_generated_field = "C32F911995843B7FF6D232578057F97A")


    byte[] p, q, g;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.170 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")


    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.171 -0400", hash_original_method = "CAF158C5FD57CA56D7E23D22266EBF46", hash_generated_method = "CAF158C5FD57CA56D7E23D22266EBF46")
    
ThreeIntegerSequence(byte[] p, byte[] q, byte[] g) {

        this.p = p;
        this.q = q;
        this.g = g;
        encoding = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:04.171 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}
