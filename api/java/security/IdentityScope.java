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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Enumeration;


/**
 * {@code IdentityScope} represents a scope for {@link Identity} objects.
 *
 * @deprecated The functionality of this class has been replace by
 *             {@link Principal}, {@link KeyStore} and the {@code
 *             java.security.cert} package.
 */
@Deprecated
public abstract class IdentityScope extends Identity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.697 -0400", hash_original_field = "08A0F27CD0562B7CD7AA92BE24CD0E4F", hash_generated_field = "34216120030945EDA63A23E7691520EE")


    private static final long serialVersionUID = -2337346281189773310L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.698 -0400", hash_original_field = "6A3034E5FE10947D39746BC34158A299", hash_generated_field = "90C51CD9A0315A6B29F7769C04740F7D")

    private static IdentityScope systemScope;

    /**
     * Returns the system's scope.
     *
     * @return the system's scope.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.704 -0400", hash_original_method = "1C1C1338A58A9F6F46936F043801EE4E", hash_generated_method = "1AA1DC8DF1A5BB2DEA0960BF908439D4")
    
public static IdentityScope getSystemScope() {
        /*
         * Test shows that the implementation class name is read from security property
         * "system.scope", and the class is only loaded from boot classpath. No default
         * implementation as fallback, i.e., return null if fails to init an instance.
         */
        if (systemScope == null) {
            String className = Security.getProperty("system.scope");
            if(className != null){
                try {
                    systemScope = (IdentityScope) Class.forName(className).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return systemScope;
    }

    /**
     * Sets the system's scope.
     *
     * @param scope
     *            the scope to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.706 -0400", hash_original_method = "3FA8BFD9A5B0451ECDEC98E50D234314", hash_generated_method = "9DC12561E28D1327CB56B1DE776AACAE")
    
protected static void setSystemScope(IdentityScope scope) {
        systemScope = scope;
    }

    /**
     * Constructs a new instance of {@code IdentityScope}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.700 -0400", hash_original_method = "D3DB05C7367527094743952BE47CA2E9", hash_generated_method = "E37CDE490F14D973A253459EE0DDB78A")
    
protected IdentityScope() {
    }

    /**
     * Constructs a new instance of {@code IdentityScope} with the specified
     * name.
     *
     * @param name
     *            the name of this {@code IdentityScope}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.701 -0400", hash_original_method = "8A0C164D65FA41989C449B8EA1CC3963", hash_generated_method = "8771DCCBDCA0BAB798E6FB2E1D45F9AB")
    
public IdentityScope(String name) {
        super(name);
    }

    /**
     * Constructs a new instance of {@code IdentityScope} with the specified
     * name and the specified scope.
     *
     * @param name
     *            the name of this {@code IdentityScope}.
     * @param scope
     *            the scope of this {@code IdentityScope}.
     * @throws KeyManagementException
     *             if an identity with the same key already exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.702 -0400", hash_original_method = "786AC1A4AAEF12C18C76E5D607944894", hash_generated_method = "F7A970DB9127402431D37CB465568F23")
    
public IdentityScope(String name, IdentityScope scope)
            throws KeyManagementException {
        super(name, scope);
    }

    /**
     * Returns the number of {@code Identity} objects in this scope.
     *
     * @return the number of {@code Identity} objects in this scope.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.707 -0400", hash_original_method = "9059BAA01A6DF8FE6EC9ED95D6860211", hash_generated_method = "28E434F824F1ADE6246D326A37A67206")
    
public abstract int size();

    /**
     * Returns the {@code Identity} with the specified name or {@code null} if
     * no {@code Identity} with the specified name is present in this scope.
     *
     * @param name
     *            the name of the {@code Identity} to be returned.
     * @return the {@code Identity} with the specified name or {@code null} if
     *         not present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.708 -0400", hash_original_method = "81FB5CE03E5A0A96D1F99CF356B0B89F", hash_generated_method = "AC7F7B3E6B7442500857263FF8CDBA04")
    
public abstract Identity getIdentity(String name);

    /**
     * Returns the {@code Identity} with the name of the specified principal or
     * {@code null} if no {@code Identity} with the name of the specified
     * principal is present in this scope.
     *
     * @param principal
     *            the {@code Principal} whose name is used to lookup the {@code
     *            Identity} to be returned.
     * @return the {@code Identity} with the specified name or {@code null} if
     *         not present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.710 -0400", hash_original_method = "62F72EAE350A8B10A43FADBF6F78BFE0", hash_generated_method = "78ED85AA05F34B8A15C0A0311951C52C")
    
public Identity getIdentity(Principal principal) {
        return getIdentity(principal.getName());
    }

    /**
     * Returns the {@code Identity} which is associated with the specified key
     * or {@code null} if no {@code Identity} associated with the specified key
     * is present in this scope.
     *
     * @param key
     *            the {@code PublicKey} of the {@code Identity} to be returned.
     * @return the {@code Identity} associated with the specified key or {@code
     *         null} if not present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.713 -0400", hash_original_method = "68A76186669F719BB720A064AF055BE8", hash_generated_method = "A7D5E9B4202D4999C00300F8F2D11323")
    
public abstract Identity getIdentity(PublicKey key);

    /**
     * Adds an {@code Identity} to this {@code IdentityScope}.
     *
     * @param identity
     *            the {@code Identity} to be added.
     * @throws KeyManagementException
     *             if the specified {@code Identity} is invalid or an identity
     *             with the same key already exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.714 -0400", hash_original_method = "FC83CC6812B378BE08C8698A06376B8A", hash_generated_method = "2D7ACDF132ABC87C9A31AFCF15B0CE34")
    
public abstract void addIdentity(Identity identity)
            throws KeyManagementException;

    /**
     * Removes an {@code Identity} from this {@code IdentityScope}.
     *
     * @param identity
     *            the {@code Identity} to be removed.
     * @throws KeyManagementException
     *             if the {@code Identity} is not present in this scope.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.715 -0400", hash_original_method = "8B1B36D0D2229CB00CA66360369563F0", hash_generated_method = "5DF7AD22B108A2D53CCAEDA7BA8CF080")
    
public abstract void removeIdentity(Identity identity)
            throws KeyManagementException;

    /**
     * Returns an {@code Enumeration} over the {@code Identity} objects in this
     * {@code IdentityScope}.
     *
     * @return an {@code Enumeration} over the {@code Identity} objects in this
     *         {@code IdentityScope}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.716 -0400", hash_original_method = "5FB76C7BEF173244499DBD63DCAFEBFD", hash_generated_method = "EB3DA348190FC3EA76CD7260574701B5")
    
public abstract Enumeration<Identity> identities();

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code IdentityScope}.
     *
     * @return a printable representation for this {@code IdentityScope}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.718 -0400", hash_original_method = "CDC23327B4FD60E22B509260E7012F1C", hash_generated_method = "0748E3B19E2379312F3AEB28D15877E9")
    
@Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("[").append(size()).append("]").toString();
    }
}
