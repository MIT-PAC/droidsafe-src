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
import java.util.Collection;
import java.util.Set;

/**
 * The class specifying the interface to extend the certification path
 * validation algorithm by checks to perform on an {@code X509Certificate}.
 * <p>
 * The checks are added to a certification path validation using the
 * {@link PKIXParameters#setCertPathCheckers(java.util.List)
 * setCertPathCheckers} or
 * {@link PKIXBuilderParameters#addCertPathChecker(PKIXCertPathChecker)
 * addCertPathChecker} of the {@code PKIXParameters} and {@code
 * PKIXBuilderParameters} class respectively. The
 * {@link #check(Certificate, Collection) check} method will be called for each
 * certificate processed by a {@code CertPathBuilder} of {@code
 * CertPathValidator}.
 * <p>
 * A {@code PKIXCertPathChecker} implementation <u>must</u> support reverse
 * checking (from trusted CA to target) and <u>may</u> support forward checking
 * (from target to trusted CA). The return value of {@code
 * isForwardCheckingSupported} indicates whether forward checking is supported.
 */
public abstract class PKIXCertPathChecker implements Cloneable {

    /**
     * Creates a new {@code PKIXCertPathChecker} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.567 -0400", hash_original_method = "03EA965C1A36561A9CE8D59DF1746C25", hash_generated_method = "E85E7CA79FE05453EE6359811DCF0D39")
    
protected PKIXCertPathChecker() {}

    /**
     * Clones this {@code PKIXCertPathChecker} instance.
     *
     * @return the cloned instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.568 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "41C79547FB941C1E5EE1054506CEE879")
    
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Initializes this {@code PKIXCertPathChecker} instance for specified
     * <i>checking direction</i>.
     *
     * @param forward
     *            the direction of the certification path processing, {@code
     *            true} if the certificates are processed in forward direction
     *            (from target to trusted CA), {@code false} if processed in
     *            reverse direction (from trusted CA to target).
     * @throws CertPathValidatorException
     *             if initialization of this {@code PKIXCertPathChecker}
     *             instance fails, or if it cannot process certificates in the
     *             specified order.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.569 -0400", hash_original_method = "B14F48A75E15F94382AE9B6234F67616", hash_generated_method = "5AACCC51E178B4849D029E039756BBEE")
    
public abstract void init(boolean forward)
        throws CertPathValidatorException;

    /**
     * Returns whether this {@code PKIXCertPathChecker} instance supports
     * <i>forward checking</i>.
     *
     * @return {@code true} if this {@code PKIXCertPathChecker} instance
     *         supports forward checking, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.571 -0400", hash_original_method = "8BF2367243B6788082A0813C6B1E0860", hash_generated_method = "3BD121F0084B0F4400FD8BA971238823")
    
public abstract boolean isForwardCheckingSupported();

    /**
     * Returns the list of extensions of X.509 certificates that this {@code
     * PKIXCertPathChecker} is able to process.
     *
     * @return the list of extensions of X.509 certificates that this {@code
     *         PKIXCertPathChecker} is able to process, or {@code null} if there
     *         are none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.572 -0400", hash_original_method = "4093278FE1A8F88688FEA83570520BDB", hash_generated_method = "F568466FA76AB0BB09AB559BB9DAAFFC")
    
public abstract Set<String> getSupportedExtensions();

    /**
     * Checks the specified certificate and removes the processed critical
     * extensions from the specified list of X.509 extension <i>OID</i>s.
     *
     * @param cert
     *            the certificate.
     * @param unresolvedCritExts
     *            the list of critical X.509 extension OID strings.
     * @throws CertPathValidatorException
     *             if check(s) fail on the specified certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.574 -0400", hash_original_method = "3B69119323FE9EA5855E1A31FF5DB679", hash_generated_method = "61335E35FBBF90B03ECF08B9F4D0C03C")
    
public abstract void check(Certificate cert, Collection<String> unresolvedCritExts)
        throws CertPathValidatorException;
}
