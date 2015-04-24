/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class AccessControlException extends SecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.396 -0500", hash_original_field = "54E8C24FCF6CFD54FFC5B6B6120A79FC", hash_generated_field = "4AA6B8D54659D529BB431D0B0283E12C")

    private static final long serialVersionUID = 5138225684096988535L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.398 -0500", hash_original_field = "57D305BA6D64CF4ACA3634A44615AA8A", hash_generated_field = "0D97B5BAB4B6DEEFD11C532A3D968D06")

    private Permission perm; // Named as demanded by Serialized Form.

    /**
     * Constructs a new instance of {@code AccessControlException} with the
     * given message.
     *
     * @param message
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.401 -0500", hash_original_method = "A915208612B5792FCAB4EB90528BDE0E", hash_generated_method = "D739F9EC186CFA800C2855DE03A4C4B5")
    
public AccessControlException(String message) {
        super(message);
    }

    /**
     * Constructs a new instance of {@code AccessControlException} with the
     * given message and the requested {@code Permission} which was not granted.
     *
     * @param message
     *            the detail message for the exception.
     * @param perm
     *            the requested {@code Permission} which was not granted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.404 -0500", hash_original_method = "A181D272E1BB95B67E0A8B120C2E59F9", hash_generated_method = "6F812DEF6F46ED317AB279E7022E00EF")
    
public AccessControlException(String message, Permission perm) {
        super(message);
        this.perm = perm;
    }

    /**
     * Returns the requested permission that caused this Exception or {@code
     * null} if there is no corresponding {@code Permission}.
     *
     * @return the requested permission that caused this Exception, maybe {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.406 -0500", hash_original_method = "DFDCEBDA71EECDB1948D7EAD61470F05", hash_generated_method = "BA2AFF3DF53689AE5557C64D56724207")
    
public Permission getPermission() {
        return perm;
    }
}

