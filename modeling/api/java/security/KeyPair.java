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
import java.io.Serializable;

public final class KeyPair implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.981 -0500", hash_original_field = "023CECE5F37B287B37A790157CE63873", hash_generated_field = "07AAFE09296E79DE4CD9DDFF85CB5BFC")

    private static final long serialVersionUID = -7565189502268009837L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.983 -0500", hash_original_field = "E343478F4FCDDE86054B291B9794F31B", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

    private  PrivateKey privateKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.986 -0500", hash_original_field = "B73719A7AAE8E737607C294F86B7D620", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private  PublicKey publicKey;

    /**
     * Constructs a new instance of {@code KeyPair} with a public key and the
     * corresponding private key.
     *
     * @param publicKey
     *            the public key.
     * @param privateKey
     *            the private key.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.988 -0500", hash_original_method = "283304EE488E7CC511471A1BB564958E", hash_generated_method = "86C254513ECA923A9F08846838AF5892")
    
public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    /**
     * Returns the private key.
     *
     * @return the private key.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.990 -0500", hash_original_method = "3FFC913C725561B27B9684931E08C69F", hash_generated_method = "84368FE1E2A592A7742CA323B46771F5")
    
public PrivateKey getPrivate() {
        return privateKey;
    }

    /**
     * Returns the public key.
     *
     * @return the public key.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.993 -0500", hash_original_method = "6C6DB8409915627C7F2AEC2B5C46974F", hash_generated_method = "96498FAE112785B7A14D5367EC416CAF")
    
public PublicKey getPublic() {
        return publicKey;
    }
}

