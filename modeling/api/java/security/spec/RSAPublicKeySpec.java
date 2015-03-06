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


package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

public class RSAPublicKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.045 -0500", hash_original_field = "D547DBA0A38067ABD647006ED77692E3", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private  BigInteger modulus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.048 -0500", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private  BigInteger publicExponent;

    /**
     * Creates a new {@code RSAPublicKeySpec} with the specified modulus and
     * public exponent.
     *
     * @param modulus
     *            the modulus {@code n}.
     * @param publicExponent
     *            the public exponent {@code d}.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.050 -0500", hash_original_method = "02D2E2047B69666CD33836F402773F8F", hash_generated_method = "B51095546205823CB493C74D968A6814")
    
public RSAPublicKeySpec(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
    }

    /**
     * Returns the modulus {@code n}.
     *
     * @return the modulus {@code n}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.053 -0500", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "BDBC223BE67D236DB2FEEE4215FA313B")
    
public BigInteger getModulus() {
        return modulus;
    }

    /**
     * Returns the public exponent {@code d}.
     *
     * @return the public exponent {@code d}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.055 -0500", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "CDD9969A60E00BAEF22FCCEA56318047")
    
public BigInteger getPublicExponent() {
        return publicExponent;
    }
    
}

