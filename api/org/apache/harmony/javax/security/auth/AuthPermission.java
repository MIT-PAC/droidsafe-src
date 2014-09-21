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
import java.security.BasicPermission;



/**
 * Governs the use of methods in this package and also its subpackages. A
 * <i>target name</i> of the permission specifies which methods are allowed
 * without specifying the concrete action lists. Possible target names and
 * associated authentication permissions are:
 *
 * <pre>
 *    doAs                      invoke Subject.doAs methods.
 *    doAsPrivileged            invoke the Subject.doAsPrivileged methods.
 *    getSubject                invoke Subject.getSubject().
 *    getSubjectFromDomainCombiner    invoke SubjectDomainCombiner.getSubject().
 *    setReadOnly               invoke Subject.setReadonly().
 *    modifyPrincipals          modify the set of principals
 *                              associated with a Subject.
 *    modifyPublicCredentials   modify the set of public credentials
 *                              associated with a Subject.
 *    modifyPrivateCredentials  modify the set of private credentials
 *                              associated with a Subject.
 *    refreshCredential         invoke the refresh method on a credential of a
 *                              refreshable credential class.
 *    destroyCredential         invoke the destroy method on a credential of a
 *                              destroyable credential class.
 *    createLoginContext.<i>name</i>   instantiate a LoginContext with the
 *                              specified name. The wildcard name ('*')
 *                              allows to a LoginContext of any name.
 *    getLoginConfiguration     invoke the getConfiguration method of
 *                              javax.security.auth.login.Configuration.
 *    refreshLoginConfiguration Invoke the refresh method of
 *                              javax.security.auth.login.Configuration.
 * </pre>
 */
public final class AuthPermission extends BasicPermission {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.084 -0400", hash_original_field = "B86BA7BFD4F5BA4E8C2E8EC38CF13C94", hash_generated_field = "6A560F38E497E0B5864148F29E68A289")


    private static final long serialVersionUID = 5806031445061587174L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.085 -0400", hash_original_field = "E6F8779C1656F66AF8E4E1643C20DC17", hash_generated_field = "8A47B958B5E9BBB327BBC5A7CB245F96")


    private static final String CREATE_LOGIN_CONTEXT = "createLoginContext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.085 -0400", hash_original_field = "49F1CF68D13C881582C0BF0095A6F002", hash_generated_field = "896D3AA8309564D6E72D0E5BF92E52E1")


    private static final String CREATE_LOGIN_CONTEXT_ANY = "createLoginContext.*"; //$NON-NLS-1$

    // inits permission name.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.086 -0400", hash_original_method = "622A2B393A4176C15B5D9B111355BD29", hash_generated_method = "715872AC95817349428A07E0F77AA1A3")
    
private static String init(String name) {

        if (name == null) {
            throw new NullPointerException("auth.13"); //$NON-NLS-1$
        }

        if (CREATE_LOGIN_CONTEXT.equals(name)) {
            return CREATE_LOGIN_CONTEXT_ANY;
        }
        return name;
    }

    /**
     * Creates an authentication permission with the specified target name.
     *
     * @param name
     *            the target name of this authentication permission.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.087 -0400", hash_original_method = "3B8B551D72194C8E1B5051D5750E6C6C", hash_generated_method = "C2101100E8D6999FBB1ACDAF078A24B7")
    
public AuthPermission(String name) {
        super(init(name));
    }

    /**
     * Creates an authentication permission with the specified target name.
     *
     * @param name
     *            the target name of this authentication permission.
     * @param actions
     *            this parameter is ignored and should be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.087 -0400", hash_original_method = "717E7D891ADBD4AB422EF144CDA66EDD", hash_generated_method = "7612E3DFB2196C0574EEE2BCF97A472E")
    
public AuthPermission(String name, String actions) {
        super(init(name), actions);
    }
}