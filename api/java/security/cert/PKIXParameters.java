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
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class implements the parameters for the {@code PKIX CertPathValidator}.
 * <p>
 * The parameters must be created with <i>trusted</i> certificate authorities
 * (trust anchors).
 *
 * @see CertPathValidator
 * @see CertPathParameters
 */
public class PKIXParameters implements CertPathParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.723 -0400", hash_original_field = "7F74E902223F2005AF9420C573A1959B", hash_generated_field = "2A9B25F7D20A29424FF061AFE2D17119")

    private Set<TrustAnchor> trustAnchors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.724 -0400", hash_original_field = "0932C0F89887F2169E8456287EBA3ECD", hash_generated_field = "6D7C64AF87663F25B981D769A359C5D1")

    private Set<String> initialPolicies;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.725 -0400", hash_original_field = "69A2E93E2614979E07917D1EF9419E96", hash_generated_field = "4EFB25FAD627109026879F36F055F64C")

    private List<CertStore> certStores;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.727 -0400", hash_original_field = "DF617643B30A379B8E57A39F8DB3C6E0", hash_generated_field = "FEBC8D20B7EDABFA793A130D8AB543C6")

    // patch should be determined
    private Date date;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.728 -0400", hash_original_field = "45D6995DEDC1DE804E127A0CCF687749", hash_generated_field = "F979BFF399E5BB50206D88A373192E2A")

    private List<PKIXCertPathChecker> certPathCheckers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.729 -0400", hash_original_field = "BBC7690C3BC878633377529338C91EAC", hash_generated_field = "E9DAF6C1EA543CC7E1CD3D7F615EAA4C")

    private String sigProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.730 -0400", hash_original_field = "9ABE89A872779B5B3A0CB55E0FEF8E97", hash_generated_field = "596391B3177F705D353701C22584DB02")

    private CertSelector targetCertConstraints;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.732 -0400", hash_original_field = "DC4813D27FBB93B44E888C70CE17BA4F", hash_generated_field = "0341CD890EA659BD803BA6082FC8258D")

    private boolean revocationEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.733 -0400", hash_original_field = "2221DFC3DFE34E449010B4891FD69619", hash_generated_field = "DB4EA61CD258EAA92AE6B56F586D6CFB")

    private boolean explicitPolicyRequired = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.734 -0400", hash_original_field = "0071D9C9FC909C63C597D19347CA8941", hash_generated_field = "38A93617B9E8C0971C2616921E69DE5D")

    private boolean policyMappingInhibited = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.735 -0400", hash_original_field = "600089D219A5AC8702C141B25D5F3EDC", hash_generated_field = "3B600CB1283ADBF76968BE3B24FD4727")

    private boolean anyPolicyInhibited = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.737 -0400", hash_original_field = "388179DBED8B3141ED26DF7F61835102", hash_generated_field = "11218B96089F478F48D93CBEB81082DC")

    // qualifiers in a certificate policies extension that
    // is marked critical must be rejected or not
    private boolean policyQualifiersRejected = true;

    /**
     * Creates a new {@code PKIXParameters} instance with the specified set of
     * <i>trusted</i> certificate authorities.
     *
     * @param trustAnchors
     *            the trusted CAs.
     * @throws InvalidAlgorithmParameterException
     *             if {@code trustAnchors} is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.738 -0400", hash_original_method = "92679B9D95C41A32ED1FA2AC427B6AAC", hash_generated_method = "EE6BE3F708142292E20C4CBD6EC5883B")
    
public PKIXParameters(Set<TrustAnchor> trustAnchors)
        throws InvalidAlgorithmParameterException {
        if (trustAnchors == null) {
            throw new NullPointerException("trustAnchors == null");
        }
        checkTrustAnchors(trustAnchors);
        this.trustAnchors = new HashSet<TrustAnchor>(trustAnchors);
    }

    /**
     * Creates a new {@code PKIXParameters} instance with the trusted {@code
     * X509Certificate} entries from the specified {@code KeyStore}.
     *
     * @param keyStore
     *            the key store containing trusted certificates.
     * @throws KeyStoreException
     *             if the {@code keyStore} is not initialized.
     * @throws InvalidAlgorithmParameterException
     *             if {@code keyStore} does not contained any trusted
     *             certificate entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.740 -0400", hash_original_method = "6A91CDD541AA07F2464054A397376CB9", hash_generated_method = "EDE495D68669A47ECA5CD1DBD6EAEE84")
    
public PKIXParameters(KeyStore keyStore)
        throws KeyStoreException,
               InvalidAlgorithmParameterException {
        if (keyStore == null) {
            throw new NullPointerException("keyStore == null");
        }
        // Will throw KeyStoreException if
        // keyStore has not been initialized (loaded)
        if (keyStore.size() == 0) {
            throw new InvalidAlgorithmParameterException("keyStore.size() == 0");
        }
        // keyStore is not null and loaded
        trustAnchors = new HashSet<TrustAnchor>();
        for (Enumeration i = keyStore.aliases(); i.hasMoreElements();) {
            String alias = (String) i.nextElement();
            if (keyStore.isCertificateEntry(alias)) {
                // this is trusted certificate entry
                // check if it is X509Certificate
                Certificate c = keyStore.getCertificate(alias);
                // add only X509Certificate
                // ignore all other types
                if (c instanceof X509Certificate) {
                    trustAnchors.add(new TrustAnchor((X509Certificate)c, null));
                }
            }
        }
        checkTrustAnchors(trustAnchors);
    }

    /**
     * Returns a unmodifiable set of the <i>trusted</i> certificate authorities.
     *
     * @return a unmodifiable set of the <i>trusted</i> certificate authorities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.741 -0400", hash_original_method = "B6A15115C9B73A65AFA1063A2FFDD4CC", hash_generated_method = "404246AEC3EA7B419D13C51F0E4E8549")
    
public Set<TrustAnchor> getTrustAnchors() {
        return Collections.unmodifiableSet(trustAnchors);
    }

    /**
     * Sets the set of <i>trusted</i> certificate authorities.
     *
     * @param trustAnchors
     *            the set of <i>trusted</i> certificate authorities.
     * @throws InvalidAlgorithmParameterException
     *             if {@code trustAnchors} is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.743 -0400", hash_original_method = "52F8C11552AC32DACAF80A62114BEB71", hash_generated_method = "C96E742ACF10A5D5C2B05B28171B7039")
    
public void setTrustAnchors(Set<TrustAnchor> trustAnchors)
        throws InvalidAlgorithmParameterException {
        if (trustAnchors == null) {
            throw new NullPointerException("trustAnchors == null");
        }
        checkTrustAnchors(trustAnchors);
        // make shallow copy
        this.trustAnchors = new HashSet<TrustAnchor>(trustAnchors);
    }

    /**
     * Returns whether the <i>any policy OID</i> will be inhibited if it's
     * included in a certificate.
     *
     * @return {@code true} if the <i>any policy OID</i> will be inhibited,
     *         otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.744 -0400", hash_original_method = "BAE6EA6BA1425326A5C650D851AFDCAB", hash_generated_method = "A7E9D4FA49FCC1694165AA2047E22405")
    
public boolean isAnyPolicyInhibited() {
        return anyPolicyInhibited;
    }

    /**
     * Sets whether the <i>any policy OID</i> should be inhibited if it's
     * included in a certificate.
     *
     * @param anyPolicyInhibited
     *            {@code true} if the <i>any policy OID</i> should be inhibited,
     *            otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.745 -0400", hash_original_method = "0AE7496E4E70004F314800835EEEAC09", hash_generated_method = "94BBE588E615041F06D5A1D808AA3CF1")
    
public void setAnyPolicyInhibited(boolean anyPolicyInhibited) {
        this.anyPolicyInhibited = anyPolicyInhibited;
    }

    /**
     * Returns the list of checkers for the certification path.
     * <p>
     * The list is unmodifiable and the entries in the list are cloned.
     *
     * @return the list of checkers for the certification path.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.747 -0400", hash_original_method = "4D1D220C5F6A0612D7595B68E8277AA5", hash_generated_method = "7C3EDAB28696CD9D55D834BEEAC423DA")
    
public List<PKIXCertPathChecker> getCertPathCheckers() {
        if (certPathCheckers == null) {
            // set to empty List if has not been set yet
            certPathCheckers = new ArrayList<PKIXCertPathChecker>();
        }
        if (certPathCheckers.isEmpty()) {
            // no content - no need to copy,
            // just return immutable view of the same
            // empty List each time
            return Collections.unmodifiableList(certPathCheckers);
        }
        // List is not empty - do deep copy
        ArrayList<PKIXCertPathChecker> modifiableList = new ArrayList<PKIXCertPathChecker>();
        for (PKIXCertPathChecker certPathChecker : certPathCheckers) {
            modifiableList.add((PKIXCertPathChecker) certPathChecker.clone());
        }
        return Collections.unmodifiableList(modifiableList);
    }

    /**
     * Sets the list of checkers for the certification path.
     * <p>
     * The list is copied and the entries are cloned.
     *
     * @param certPathCheckers
     *            the list of checkers for the certification path, or {@code
     *            null} to clear the checkers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.749 -0400", hash_original_method = "9E3F16F2A04B1B4B72B8E7D339DD67D4", hash_generated_method = "E3C5275343F2598980F42A56E726C15A")
    
public void setCertPathCheckers(List<PKIXCertPathChecker> certPathCheckers) {
        if (certPathCheckers == null || certPathCheckers.isEmpty()) {
            // empty list or null provided
            if (this.certPathCheckers != null &&
               !this.certPathCheckers.isEmpty()) {
                // discard non-empty list
                this.certPathCheckers = null;
            }
            return;
        }
        // non-empty list provided - do deep copy
        this.certPathCheckers = new ArrayList<PKIXCertPathChecker>();
        for (PKIXCertPathChecker certPathChecker : certPathCheckers) {
            this.certPathCheckers.add((PKIXCertPathChecker) certPathChecker.clone());
        }
    }

    /**
     * Adds the specified {@code PKIXCertPathChecker} to the list of
     * certification path checkers.
     *
     * @param checker
     *            the {@code PKIXCertPathChecker} to add, if {@code null}, it
     *            will be ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.750 -0400", hash_original_method = "F9E5740787798DBF0530F9F6BB1FD2E5", hash_generated_method = "9AD7AFE915A7DBA1E85CCD5D9105CA43")
    
public void addCertPathChecker(PKIXCertPathChecker checker) {
        if (checker == null) {
            // do nothing if null provided
            return;
        }
        if (certPathCheckers == null) {
            // set to empty List if has not been set yet
            certPathCheckers = new ArrayList<PKIXCertPathChecker>();
        }
        // add a copy to avoid possible modifications
        certPathCheckers.add((PKIXCertPathChecker) checker.clone());
    }

    /**
     * Returns the list of certificate stores that are used to find certificates
     * and CRLs.
     *
     * @return an immutable list of certificate stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.752 -0400", hash_original_method = "571325436A4CAE93B10DAED920DE23D3", hash_generated_method = "B7367EE14D2F92AF9FD7DD3CDB280522")
    
public List<CertStore> getCertStores() {
        if (certStores == null) {
            // set to empty List if has not been set yet
            certStores = new ArrayList<CertStore>();
        }
        if (certStores.isEmpty()) {
            // no content - no need to copy,
            // just return immutable view of the same
            // empty List each time
            return Collections.unmodifiableList(certStores);
        }
        // List is not empty - do shallow copy
        ArrayList<CertStore> modifiableList
            = new ArrayList<CertStore>(certStores);
        return Collections.unmodifiableList(modifiableList);
    }

    /**
     * Set the list of certificate stores that are used to find certificates and
     * CRLs.
     *
     * @param certStores the list of certificate stores.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.753 -0400", hash_original_method = "D1B2FA0E4373EEA238E3B1324BE447D2", hash_generated_method = "8C3003072AB79BAFDAC898DA0248C356")
    
public void setCertStores(List<CertStore> certStores) {
        if (certStores == null || certStores.isEmpty()) {
            // empty list or null provided
            if (this.certStores != null && !this.certStores.isEmpty()) {
                // discard non-empty list
                this.certStores = null;
            }
            return;
        }
        // non-empty list provided - do shallow copy
        this.certStores = new ArrayList<CertStore>(certStores);
    }

    /**
     * Adds a certificate store to the list of certificate stores that are used
     * to find certificates and CRLs.
     *
     * @param store
     *            the store to add, if {@code null}, it will be ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.754 -0400", hash_original_method = "69D946FD97044C86CE0465D31431BEE8", hash_generated_method = "B8A799CD62E8854F6C88BB7FED1CBA85")
    
public void addCertStore(CertStore store) {
        if (store == null) {
            // do nothing if null provided
            return;
        }
        if (certStores == null) {
            // set to empty List if has not been set yet
            certStores = new ArrayList<CertStore>();
        }
        // add store
        certStores.add(store);
    }

    /**
     * Returns the time for which the validation of the certification path
     * should be evaluated.
     *
     * @return the time for the validation, or {@code null} for the current
     *         time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.755 -0400", hash_original_method = "394BC3E2671732D994BD378FD91ED538", hash_generated_method = "797DD8487E0437765DD11AAFF9A77D2E")
    
public Date getDate() {
        return date == null ? null : (Date)date.clone();
    }

    /**
     * Sets the time for which the validation of the certification path should be
     * evaluated.
     *
     * @param date
     *            the time for the validation, or {@code null} for the current
     *            time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.757 -0400", hash_original_method = "DE754D6A7D7A661325110349918334C8", hash_generated_method = "C33A790BA97F5AA70A73FE72A5C2A911")
    
public void setDate(Date date) {
        this.date = (date == null ? null : new Date(date.getTime()));
    }

    /**
     * Returns whether an acceptable policy needs to be explicit identified in
     * every certificate.
     *
     * @return {@code true} if an explicit policy is required, otherwise {@code
     *         false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.758 -0400", hash_original_method = "A362BC8E40D9F298E8A1FE201159EF3E", hash_generated_method = "7CB0DF6A2C66B38B5610F3CF5DE43592")
    
public boolean isExplicitPolicyRequired() {
        return explicitPolicyRequired;
    }

    /**
     * Sets whether an an acceptable policy needs to be explicit identified in
     * every certificate.
     *
     * @param explicitPolicyRequired
     *            {@code true} if an explicit policy is required, otherwise
     *            {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.759 -0400", hash_original_method = "E8FB60E3D69A4D8D392DE4DE046180AD", hash_generated_method = "065D1761833587FC571F162E6B007632")
    
public void setExplicitPolicyRequired(boolean explicitPolicyRequired) {
        this.explicitPolicyRequired = explicitPolicyRequired;
    }

    /**
     * Returns the list of policies (as OID strings) that would be acceptable
     * for the purpose of certification path processing.
     *
     * @return the unmodifiable list of policies, or an empty set if any policy
     *         is acceptable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.761 -0400", hash_original_method = "0D853D66CE3432BF70A6005547BFA4AE", hash_generated_method = "82857593DBEBF4F84DF868C73F6B0881")
    
public Set<String> getInitialPolicies() {
        if (initialPolicies == null) {
            // set to empty Set if has not been set yet
            initialPolicies = new HashSet<String>();
        }
        if (initialPolicies.isEmpty()) {
            // no content - no need to copy,
            // just return immutable view of the same
            // empty Set each time
            return Collections.unmodifiableSet(initialPolicies);
        }
        // List is not empty - do shallow copy
        HashSet<String> modifiableSet = new HashSet<String>(initialPolicies);
        return Collections.unmodifiableSet(modifiableSet);
    }

    /**
     * Sets the list of policies (as OID strings) that would be acceptable for
     * the purpose of certification path processing.
     *
     * @param initialPolicies
     *            the list of policies, or an empty set or {@code null} if any
     *            policy is acceptable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.763 -0400", hash_original_method = "E8194BB331A291574F656D968F16AF56", hash_generated_method = "6B671457B5DF66D6F3265A1625E6D395")
    
public void setInitialPolicies(Set<String> initialPolicies) {
        if (initialPolicies == null || initialPolicies.isEmpty()) {
            // empty list or null provided
            if (this.initialPolicies != null && !this.initialPolicies.isEmpty()) {
                // discard non-empty list
                this.initialPolicies = null;
            }
            return;
        }
        // non-empty list provided - do shallow copy
        this.initialPolicies = new HashSet<String>(initialPolicies);
    }

    /**
     * Returns whether policy mapping is inhibited.
     *
     * @return {@code true} if policy mapping is inhibited, otherwise {@code
     *         false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.764 -0400", hash_original_method = "A24C126CA58586506004D30D2299C1FC", hash_generated_method = "D9917D4338E17AFB6F5BEBDDB87888D1")
    
public boolean isPolicyMappingInhibited() {
        return policyMappingInhibited;
    }

    /**
     * Sets whether policy mapping is to be inhibited.
     *
     * @param policyMappingInhibited
     *            {@code true} if policy mapping is to be inhibited, otherwise
     *            {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.765 -0400", hash_original_method = "BCDB922B2793BB70805BA73599998A80", hash_generated_method = "13FFDF3D158718C703A3FF5CE90F7522")
    
public void setPolicyMappingInhibited(boolean policyMappingInhibited) {
        this.policyMappingInhibited = policyMappingInhibited;
    }

    /**
     * Returns whether certificates are rejected that include policy
     * qualifiers in a certificate policy extension that is marked as critical.
     *
     * @return {@code true} if the certificates should be rejected, otherwise
     *         {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.766 -0400", hash_original_method = "A8EF50EA3B1A8D888DF95ADA601EA34C", hash_generated_method = "3B5C88241A56EAD06D1966AEB186D1F6")
    
public boolean getPolicyQualifiersRejected() {
        return policyQualifiersRejected;
    }

    /**
     * Sets whether certificates should be rejected that include policy
     * qualifiers in a certificate policy extension that is marked as critical.
     *
     * @param policyQualifiersRejected
     *            {@code true} if the certificates should be rejected, otherwise
     *            {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.769 -0400", hash_original_method = "49B15592D1DB504265B4E83FA79A9F4C", hash_generated_method = "69D7C9D099B569DE9F44A676651A71EF")
    
public void setPolicyQualifiersRejected(boolean policyQualifiersRejected) {
        this.policyQualifiersRejected = policyQualifiersRejected;
    }

    /**
     * Returns whether the default revocation checking mechanism of the
     * underlying service provider is used.
     *
     * @return {@code true} if the default revocation checking mechanism is
     *         used, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.770 -0400", hash_original_method = "9EE4178A3B2FA68701FDBB69893D1895", hash_generated_method = "D3B494722F010F58D7C0A5115E2F613B")
    
public boolean isRevocationEnabled() {
        return revocationEnabled;
    }

    /**
     * Sets whether the default revocation checking mechanism of the underlying
     * service provider should be used.
     *
     * @param revocationEnabled
     *            {@code true} id the default revocation checking mechanism
     *            should be used, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.771 -0400", hash_original_method = "BC658EE7244E969B58B5CE58E9FEBFD2", hash_generated_method = "CC832808BDE0FA9E1944B1872EB16532")
    
public void setRevocationEnabled(boolean revocationEnabled) {
        this.revocationEnabled = revocationEnabled;
    }

    /**
     * Returns the name of the signature provider.
     *
     * @return the name of the signature provider, or {@code null} if none is
     *         set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.773 -0400", hash_original_method = "BB5D7D1179BC0A4F95413913A5E9E2C4", hash_generated_method = "4EB238A3E9A01C340C4964B0F248637D")
    
public String getSigProvider() {
        return sigProvider;
    }

    /**
     * Sets the name of the preferred signature provider.
     * <p>
     * If set, the specified provider will be preferred for creating signatures.
     * If not set, the first provider found supporting creation of signatures
     * will be used.
     *
     * @param sigProvider
     *            the name of the preferred signature provider, or {@code null}
     *            if none is preferred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.774 -0400", hash_original_method = "9D1B044631B07A73E19C645E47AE1381", hash_generated_method = "251F9F7092B9462E9829645F3986309C")
    
public void setSigProvider(String sigProvider) {
        this.sigProvider = sigProvider;
    }

    /**
     * Returns the constraints that are required for the target certificate.
     *
     * @return the constraints for the target certificate, or {@code null} if
     *         none are set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.775 -0400", hash_original_method = "8E3C60CC048BC1BAEC71CDB41A59903C", hash_generated_method = "062C7592CAA12F5CECBE6EE2B513E24B")
    
public CertSelector getTargetCertConstraints() {
        return (targetCertConstraints == null ? null
                :(CertSelector)targetCertConstraints.clone());
    }

    /**
     * Sets the constraints that are required for the target certificate.
     *
     * @param targetCertConstraints
     *            the constraints for the target certificate, or {@code null} if
     *            none should be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.776 -0400", hash_original_method = "76B809DE0AF75E278C5B6C993A61492C", hash_generated_method = "40D5163D112489A64D462F2DE6B28E5E")
    
public void setTargetCertConstraints(CertSelector targetCertConstraints) {
        this.targetCertConstraints = (targetCertConstraints == null ? null
                : (CertSelector)targetCertConstraints.clone());
    }

    /**
     * Clones this {@code PKIXParameters} instance.
     *
     * @return the cloned instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.778 -0400", hash_original_method = "85D8432A891D0E2C2230EA01D5B002E2", hash_generated_method = "CFEEACD5CD1BA84BEFF059F7725138D4")
    
public Object clone() {
        try {
            // do shallow copy first
            PKIXParameters ret = (PKIXParameters)super.clone();
            // copy fields containing references to mutable objects
            if (this.certStores != null) {
                ret.certStores = new ArrayList<CertStore>(this.certStores);
            }
            if (this.certPathCheckers != null) {
                ret.certPathCheckers = new ArrayList<PKIXCertPathChecker>(this.certPathCheckers);
            }
            return ret;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns a string representation of this {@code PKIXParameters} instance.
     *
     * @return a string representation of this {@code PKIXParameters} instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.780 -0400", hash_original_method = "825D9864B961C064BE999896EC76C33C", hash_generated_method = "EC328CA4CFFDC6ABE4EBC2500072AC50")
    
public String toString() {
        StringBuilder sb =
            new StringBuilder("[\n Trust Anchors: ");
        sb.append(trustAnchors);
        sb.append("\n Revocation Enabled: ");
        sb.append(revocationEnabled);
        sb.append("\n Explicit Policy Required: ");
        sb.append(explicitPolicyRequired);
        sb.append("\n Policy Mapping Inhibited: ");
        sb.append(policyMappingInhibited);
        sb.append("\n Any Policy Inhibited: ");
        sb.append(anyPolicyInhibited);
        sb.append("\n Policy Qualifiers Rejected: ");
        sb.append(policyQualifiersRejected);
        sb.append("\n Initial Policy OIDs: ");
        sb.append((initialPolicies == null || initialPolicies.isEmpty())
                ? "any" : initialPolicies.toString());
        sb.append("\n Cert Stores: ");
        sb.append((certStores==null||certStores.isEmpty())?
                "no":certStores.toString());
        sb.append("\n Validity Date: ");
        sb.append(date);
        sb.append("\n Cert Path Checkers: ");
        sb.append((certPathCheckers==null||certPathCheckers.isEmpty())?
                "no":certPathCheckers.toString());
        sb.append("\n Signature Provider: ");
        sb.append(sigProvider);
        sb.append("\n Target Certificate Constraints: ");
        sb.append(targetCertConstraints);
        sb.append("\n]");
        return sb.toString();
    }

    /**
     * Checks that {@code trustAnchors} contains only {@code
     * TrustAnchor} instances.
     *
     * @throws InvalidAlgorithmParameterException if trustAnchors set is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.781 -0400", hash_original_method = "B3A58203AAFF01DCC3DA3D407CA16D49", hash_generated_method = "2C888F6BD31754E515F8A1BC7BA2B17B")
    
private void checkTrustAnchors(Set<TrustAnchor> trustAnchors)
            throws InvalidAlgorithmParameterException {
        if (trustAnchors.isEmpty()) {
            throw new InvalidAlgorithmParameterException("trustAnchors.isEmpty()");
        }
    }
}
