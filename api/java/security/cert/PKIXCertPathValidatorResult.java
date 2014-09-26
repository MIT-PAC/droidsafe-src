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
import java.security.PublicKey;

/**
 * The implementation of the result of the PKIX certification path validation.
 *
 * @see CertPathValidator
 * @see CertPathValidator#validate(CertPath, CertPathParameters)
 */
public class PKIXCertPathValidatorResult implements CertPathValidatorResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.596 -0400", hash_original_field = "BAE829E585E5CDD6E4E26D216B026CFC", hash_generated_field = "46D18713FAEE02605D75652C5C3CF1C0")

    private  TrustAnchor trustAnchor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.597 -0400", hash_original_field = "460E6806A7083265F2554467FBD3F43E", hash_generated_field = "1EF08A179270181BB27588D487CF64CE")

    // certification path validation algorithm
    private  PolicyNode policyTree;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.599 -0400", hash_original_field = "3713361A2D19F07ED6464F68285A4038", hash_generated_field = "43E30E46502C13B5C796FA685BE9C1A3")

    private  PublicKey subjectPublicKey;

    /**
     * Creates a new {@code PKIXCertPathValidatorResult} with the specified
     * trust anchor, the valid policy tree and the subject public key.
     *
     * @param trustAnchor
     *            the trust anchor describing the certification authority (CA)
     *            that served as trust anchor for the certification path.
     * @param policyTree
     *            the valid policy tree from the validation.
     * @param subjectPublicKey
     *            the subject public key from the validation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.600 -0400", hash_original_method = "B5E33F82A9EDD65F744335CFFED59B5F", hash_generated_method = "AF0549990E76A7B3AF839FDBD962CD3A")
    
public PKIXCertPathValidatorResult(TrustAnchor trustAnchor,
            PolicyNode policyTree, PublicKey subjectPublicKey) {
        this.trustAnchor = trustAnchor;
        this.policyTree = policyTree;
        this.subjectPublicKey = subjectPublicKey;
        if (this.trustAnchor == null) {
            throw new NullPointerException("trustAnchor == null");
        }
        if (this.subjectPublicKey == null) {
            throw new NullPointerException("subjectPublicKey == null");
        }
    }

    /**
     * Returns the valid policy tree from the validation.
     *
     * @return the valid policy tree from the validation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.602 -0400", hash_original_method = "4B5496A79468DEC2FA84449A5CCBD295", hash_generated_method = "06016682917508DEF780A2C1DA1531D4")
    
public PolicyNode getPolicyTree() {
        return policyTree;
    }

    /**
     * Returns the subject public key from the validation.
     *
     * @return the subject public key from the validation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.603 -0400", hash_original_method = "9CA51125BBD9928A127E75CF99CB1D14", hash_generated_method = "10D7CA0C3FC5B5A6A133BC7DAAF5C8C5")
    
public PublicKey getPublicKey() {
        return subjectPublicKey;
    }

    /**
     * Returns the trust anchor describing the certification authority (CA) that
     * served as trust anchor for this certification path.
     *
     * @return the trust anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.604 -0400", hash_original_method = "D53C3DAE7394798EE5A7C498CACBD5AF", hash_generated_method = "13DD0364106557B654A3555DA9860FB0")
    
public TrustAnchor getTrustAnchor() {
        return trustAnchor;
    }

    /**
     * Clones this {@code PKIXCertPathValidatorResult} instance.
     *
     * @return the cloned instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.606 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "41C79547FB941C1E5EE1054506CEE879")
    
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns a string representation for this {@code
     * PKIXCertPathValidatorResult} instance.
     *
     * @return a string representation for this {@code
     *         PKIXCertPathValidatorResult} instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.607 -0400", hash_original_method = "78C98486B5FE58C8BE8EFB699D0B14C0", hash_generated_method = "52CA5847918CCA070375401EB7519FEC")
    
public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(": [\n Trust Anchor: ");
        sb.append(trustAnchor.toString());
        sb.append("\n Policy Tree: ");
        sb.append(policyTree == null ? "no valid policy tree\n"
                                     : policyTree.toString());
        sb.append("\n Subject Public Key: ");
        sb.append(subjectPublicKey.toString());
        sb.append("\n]");
        return sb.toString();
    }
}
