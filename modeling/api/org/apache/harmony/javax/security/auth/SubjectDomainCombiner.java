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

package org.apache.harmony.javax.security.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.DomainCombiner;
import java.security.Principal;
import java.security.ProtectionDomain;
import java.util.Set;

/**
 * Merges permissions based on code source and code signers with permissions
 * granted to the specified {@link Subject}.
 */
public class SubjectDomainCombiner implements DomainCombiner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.743 -0400", hash_original_field = "CBC7FE764F7C4D3CA28088449C7ED935", hash_generated_field = "44532B62FFC694C102691886B3F99111")

    private static final AuthPermission _GET = new AuthPermission(
            "getSubjectFromDomainCombiner");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.743 -0400", hash_original_field = "30BAA2E2AE0B9CC8117DC874E7246F92", hash_generated_field = "EFE21B59DD4BD4F533148D4E82C7B2AF")

    private Subject subject; //$NON-NLS-1$

    /**
     * Creates a domain combiner for the entity provided in {@code subject}.
     *
     * @param subject
     *            the entity to which this domain combiner is associated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.744 -0400", hash_original_method = "6012699D0A81D573FF0D2ADCC1EE5A85", hash_generated_method = "C8CE1DBD582699AC3E959C58B93B4CA6")
    
public SubjectDomainCombiner(Subject subject) {
        super();
        if (subject == null) {
            throw new NullPointerException();
        }
        this.subject = subject;
    }

    /**
     * Returns the entity to which this domain combiner is associated.
     *
     * @return the entity to which this domain combiner is associated.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.744 -0400", hash_original_method = "8F8546B49FE91B43BAB94BCEBEF4AEC2", hash_generated_method = "C9A8F9D777EF4E434CA26B202936002B")
    
public Subject getSubject() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(_GET);
        }

        return subject;
    }

    /**
     * Merges the {@code ProtectionDomain} with the {@code Principal}s
     * associated with the subject of this {@code SubjectDomainCombiner}.
     *
     * @param currentDomains
     *            the {@code ProtectionDomain}s associated with the context of
     *            the current thread. The domains must be sorted according to
     *            the execution order, the most recent residing at the
     *            beginning.
     * @param assignedDomains
     *            the {@code ProtectionDomain}s from the parent thread based on
     *            code source and signers.
     * @return a single {@code ProtectionDomain} array computed from the two
     *         provided arrays, or {@code null}.
     * @see ProtectionDomain
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.746 -0400", hash_original_method = "57204ADB74212CDB84175135F96B2705", hash_generated_method = "D52874409CE66E45CD58DB8C5DDE19AC")
    
public ProtectionDomain[] combine(ProtectionDomain[] currentDomains,
            ProtectionDomain[] assignedDomains) {
        // get array length for combining protection domains
        int len = 0;
        if (currentDomains != null) {
            len += currentDomains.length;
        }
        if (assignedDomains != null) {
            len += assignedDomains.length;
        }
        if (len == 0) {
            return null;
        }

        ProtectionDomain[] pd = new ProtectionDomain[len];

        // for each current domain substitute set of principal with subject's
        int cur = 0;
        if (currentDomains != null) {

            Set<Principal> s = subject.getPrincipals();
            Principal[] p = s.toArray(new Principal[s.size()]);

            for (cur = 0; cur < currentDomains.length; cur++) {
                if (currentDomains[cur] != null) {
                    ProtectionDomain newPD;
                    newPD = new ProtectionDomain(currentDomains[cur].getCodeSource(),
                            currentDomains[cur].getPermissions(), currentDomains[cur]
                                    .getClassLoader(), p);
                    pd[cur] = newPD;
                }
            }
        }

        // copy assigned domains
        if (assignedDomains != null) {
            System.arraycopy(assignedDomains, 0, pd, cur, assignedDomains.length);
        }

        return pd;
    }
}
