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

package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;

/**
 * This class implements a policy qualifier as defined by the ASN.1
 * {@code PolicyQualifierInfo} structure.
 */
public class PolicyQualifierInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.909 -0400", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private  byte[] encoded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.910 -0400", hash_original_field = "0E5E0B1DA941A7273EE1FA3277B3FC1D", hash_generated_field = "C8966E1271D15AC8C6CD886529E6351B")

    // OID represented as String containing non-negative integers
    // separated by periods
    private  String policyQualifierId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.912 -0400", hash_original_field = "065ECBD4AC2BE5C099229F2850799A3D", hash_generated_field = "E161E043C1046C222693BE26B48389E3")

    private  byte[] policyQualifier;

    /**
     * Creates a new {@code PolicyQualifierInfo} from the specified encoded
     * form.
     *
     * @param encoded
     *            the DER encoded policy qualifier.
     * @throws IOException
     *             the policy qualifier cannot be decoded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.913 -0400", hash_original_method = "F13781A41B44E1C9E635675392F23477", hash_generated_method = "0D902C4AD899CE8881F32739766B3620")
    
public PolicyQualifierInfo(byte[] encoded) throws IOException {
        if (encoded == null) {
            throw new NullPointerException("encoded == null");
        }
        if (encoded.length == 0) {
            throw new IOException("encoded.length == 0");
        }
        this.encoded = new byte[encoded.length];
        System.arraycopy(encoded, 0, this.encoded, 0, this.encoded.length);

        // DER Decoding:
        Object[] decoded = (Object[]) org.apache.harmony.security.x509.PolicyQualifierInfo.ASN1
                .decode(this.encoded);
        policyQualifierId = ObjectIdentifier.toString((int[]) decoded[0]);
        policyQualifier = (byte[]) decoded[1];
    }

    /**
     * Returns a ASN.1 DER encoded copy of policy qualifier info.
     *
     * @return a ASN.1 DER encoded copy of policy qualifier info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.915 -0400", hash_original_method = "4F14FFFA2494251050856628251113E3", hash_generated_method = "5B6D1854CB0AF7DE9E660DDA9C9A317C")
    
public final byte[] getEncoded() {
        byte[] ret = new byte[encoded.length];
        System.arraycopy(encoded, 0, ret, 0, encoded.length);
        return ret;
    }

    /**
     * Returns the identifier (an OID) of this policy qualifier info.
     *
     * @return the identifier of this policy qualifier info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.916 -0400", hash_original_method = "D1DE711D66E9CF16CC1093022018BB07", hash_generated_method = "A1686EA8D18256C6E0F84BC6E44AEECD")
    
public final String getPolicyQualifierId() {
        return policyQualifierId;
    }

    /**
     * Returns a ASN.1 DER encoded copy of the qualifier of this policy
     * qualifier info.
     *
     * @return a ASN.1 DER encoded copy of the qualifier of this policy
     *         qualifier info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.918 -0400", hash_original_method = "EABC634414738B51829A882FEEDF6484", hash_generated_method = "8C3A3199A9AF2F56AEDDC94174BAD48A")
    
public final byte[] getPolicyQualifier() {
        if (policyQualifier == null) {
            return null;
        }
        byte[] ret = new byte[policyQualifier.length];
        System.arraycopy(policyQualifier, 0, ret, 0, policyQualifier.length);
        return ret;
    }

    /**
     * Returns a string representation of this {@code PolicyQualifierInfo}
     * instance.
     *
     * @return a string representation of this {@code PolicyQualifierInfo}
     *         instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.919 -0400", hash_original_method = "2F3DFC9CAA3972F022EB5AA11F0288FE", hash_generated_method = "CF4E9A37660086CB7B1AE27EB3C80111")
    
public String toString() {
        StringBuilder sb =
            new StringBuilder("PolicyQualifierInfo: [\npolicyQualifierId: ");
        sb.append(policyQualifierId);
        sb.append("\npolicyQualifier: \n");
        sb.append(Array.toString(policyQualifier, " "));
        sb.append("]");
        return sb.toString();
    }
}
