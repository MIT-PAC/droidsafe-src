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

/**
 * {@link Signer} represents an identity (individual or corporation) that owns a
 * private key and the corresponding public key.
 *
 * @deprecated Replaced by behavior in {@link java.security.cert
 *             java.security.cert} package and {@link java.security.Principal
 *             Principal}
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
@Deprecated
public abstract class Signer extends Identity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.969 -0400", hash_original_field = "53464C55A6A5739555CD227DC8D06068", hash_generated_field = "F2B3E66AA7C5D1FF1DD85B70BC3246E1")

    private static final long serialVersionUID = -1763464102261361480L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.971 -0400", hash_original_field = "E343478F4FCDDE86054B291B9794F31B", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

    private PrivateKey privateKey;

    /**
     * Constructs a new instance of {@code Signer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.972 -0400", hash_original_method = "37F2D6D084D82406B06E388B40ED7EAC", hash_generated_method = "71CA7D8497E27FFA5E27CA34EEFC8502")
    
protected Signer() {
    }

    /**
     * Constructs a new instance of {@code Signer} with the given name.
     *
     * @param name
     *            the name of the signer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.973 -0400", hash_original_method = "40CBB300727A1EB2F4BB532FC4A9CF18", hash_generated_method = "44EA4AFF29AC65158D62450B1D28C4B8")
    
public Signer(String name) {
        super(name);
    }

    /**
     * Constructs a new instance of {@code Signer} with the given name in the
     * given scope.
     *
     * @param name
     *            the name of the signer.
     * @param scope
     *            the scope of the signer.
     * @throws KeyManagementException
     *             if a signer with the specified name already exists in the
     *             provided scope.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.975 -0400", hash_original_method = "7F390DC9969EAE7A8FFB4122B940EDB9", hash_generated_method = "5BE5B4E0C29450C20B84F097A5C8FFA8")
    
public Signer(String name, IdentityScope scope) throws KeyManagementException {
        super(name, scope);
    }

    /**
     * Returns the private key of this {@code Signer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.976 -0400", hash_original_method = "20D5E1BC38F4066008A03A45816FEC0F", hash_generated_method = "5B753A9A2F3D9D0C05D9306EEE56584A")
    
public PrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * Associates the specified key pair with this {@code Signer}.
     *
     * @param pair
     *            the key pair to associate with this {@code Signer}.
     * @throws InvalidParameterException
     *             if the key pair is invalid.
     * @throws KeyException
     *             if any other key related problem occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.977 -0400", hash_original_method = "D677CD4D80BFEFDE4D8933A3011AD497", hash_generated_method = "F8E1A81BEF39BFECF015B0C3A8325B43")
    
public final void setKeyPair(KeyPair pair) throws InvalidParameterException, KeyException {
        if (pair == null) {
            throw new NullPointerException();
        }

        if (pair.getPrivate() == null || pair.getPublic() == null) {
            throw new InvalidParameterException();
        }
        setPublicKey(pair.getPublic());
        this.privateKey = pair.getPrivate();
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code Signer} including its name and its scope if present.
     *
     * @return a printable representation for this {@code Signer}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.979 -0400", hash_original_method = "9C760CA5169F00FD53FF6DD39F166B45", hash_generated_method = "5017F1E9EEBBA91BB03F7D0B76FAD44B")
    
@Override
    public String toString() {
        String s = "[Signer]" + getName();
        if (getScope() != null) {
            s = s + '[' + getScope().toString() + ']';
        }
        return s;
    }
}
