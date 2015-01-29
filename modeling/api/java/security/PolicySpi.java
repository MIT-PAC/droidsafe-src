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

package java.security;

/**
 * Represents the Service Provider Interface (SPI) for java.security.Policy
 * class.
 *
 * <p>If there is any class that wants to provide a Policy implementation, all
 * abstract methods in this SPI should be implemented.
 *
 * <p>The detailed implementations should offer a public constructor, in which a
 * Policy.Paramters implementation acts as an input parameter.If the
 * Policy.Paramters input cannot by understood by the constructor, an
 * IllegalArgumentException will be thrown.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class PolicySpi {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.849 -0400", hash_original_method = "9A3A889B4EB1F8633221D38DEAF37957", hash_generated_method = "5D3BCF228B5490CDBCDCED62ED9B21AB")
    
public PolicySpi() {
        // default constructor
    }

    /**
     * Answers if the policy has granted a Permission to a
     * ProtectionDomain.
     *
     * @param domain -
     *            the domain to check.
     * @param permission -
     *            check whether this permission is granted to the specified
     *            domain.
     * @return - true if the permission is granted to the domain.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.851 -0400", hash_original_method = "5BE7FB017E7C88A542F925F21C554C7C", hash_generated_method = "5E39C84F7033C4144D637B4DA923A0DC")
    
protected abstract boolean engineImplies(ProtectionDomain domain,
            Permission permission);

    /**
     * Refreshes/reloads the policy configuration. The behavior of this method
     * depends on the implementation. For example, calling refresh on a
     * file-based policy will cause the file to be re-read.
     *
     * The default implementation of this method does nothing. This method
     * should be overridden if a refresh operation is supported by the policy
     * implementation.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.852 -0400", hash_original_method = "876312CC00F357A663A826C85F47F357", hash_generated_method = "28F69F5D8F5AA05B491F9AD5EA373E07")
    
protected void engineRefresh() {
        // do nothing in default implementation
    }

    /**
     * Answers a PermissionCollection object containing the set of permissions
     * granted to the specified CodeSource.
     *
     * The default implementation of this method returns
     * Policy.UNSUPPORTED_EMPTY_COLLECTION object. This method can be overridden
     * if the policy implementation can return a set of permissions granted to a
     * CodeSource.
     *
     * @param codesource -
     *            the CodeSource to which the returned PermissionCollection has
     *            been granted.
     * @return a set of permissions granted to the specified CodeSource. If this
     *         operation is supported, the returned set of permissions must be a
     *         new mutable instance and it must support heterogeneous Permission
     *         types. If this operation is not supported,
     *         Policy.UNSUPPORTED_EMPTY_COLLECTION is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.853 -0400", hash_original_method = "94ADB2AE4BA33A8D3F64585509DECF25", hash_generated_method = "257F0DF9142D9495A720252B996C56EA")
    
protected PermissionCollection engineGetPermissions(CodeSource codesource) {
        return Policy.UNSUPPORTED_EMPTY_COLLECTION;
    }

    /**
     * Answers a PermissionCollection object containing the set of permissions
     * granted to the specified ProtectionDomain.
     *
     * The default implementation of this method returns
     * Policy.UNSUPPORTED_EMPTY_COLLECTION object. This method can be overridden
     * if the policy implementation can return a set of permissions granted to a
     * ProtectionDomain.
     *
     * @param domain -
     *            the ProtectionDomain to which the returned
     *            PermissionCollection has been granted.
     * @return a set of permissions granted to the specified ProtectionDomain.
     *         If this operation is supported, the returned set of permissions
     *         must be a new mutable instance and it must support heterogeneous
     *         Permission types. If this operation is not supported,
     *         Policy.UNSUPPORTED_EMPTY_COLLECTION is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.855 -0400", hash_original_method = "FA8FA46992A861D2F8285BCC05F52E81", hash_generated_method = "A14A3A54532DA195505F279DAC093E46")
    
protected PermissionCollection engineGetPermissions(ProtectionDomain domain) {
        return Policy.UNSUPPORTED_EMPTY_COLLECTION;
    }
}
