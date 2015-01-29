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

package java.security.acl;

/**
 * The exception that is thrown when an action that requires ownership is
 * attempted by a principal that is not an owner of the object for which
 * ownership is required.
 *
 * @see Acl
 * @see Owner
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class NotOwnerException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.064 -0400", hash_original_field = "137E2DD4D6276ACD918F1BA2413E9816", hash_generated_field = "692A69987BD8576DEBB8305AB2A33E31")


    private static final long serialVersionUID = -5555597911163362399L;

    /**
     * Creates a new {@code NotOwnerException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.066 -0400", hash_original_method = "C97FBD586EAFEC3FFBDCA967F6100C89", hash_generated_method = "7C662097E04BD91BAC48C7CFB9A6F572")
    
public NotOwnerException() {
    }
}
