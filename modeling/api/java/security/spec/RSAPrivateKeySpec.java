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

public class RSAPrivateKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.204 -0500", hash_original_field = "D547DBA0A38067ABD647006ED77692E3", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private  BigInteger modulus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.207 -0500", hash_original_field = "9D6B5BA90FEDFF37C5B6F5CC23882550", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private  BigInteger privateExponent;

    /**
     * Creates a new {@code RSAPrivateKeySpec} with the specified modulus and
     * private exponent.
     *
     * @param modulus
     *            the modulus {@code n}.
     * @param privateExponent
     *            the private exponent {@code e}
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.210 -0500", hash_original_method = "F40385EC5FF36FD091AB4B014FD09334", hash_generated_method = "4C6C6A838705FADC091BB6706470A9F3")
    
public RSAPrivateKeySpec(BigInteger modulus, BigInteger privateExponent) {
        this.modulus = modulus;
        this.privateExponent = privateExponent;
    }

    /**
     * Returns the modulus {@code n}.
     *
     * @return the modulus {@code n}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.212 -0500", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "BDBC223BE67D236DB2FEEE4215FA313B")
    
public BigInteger getModulus() {
        return modulus;
    }

    /**
     * Returns the private exponent {@code e}.
     *
     * @return the private exponent {@code e}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.214 -0500", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "7923099ACFD3EE53AD0BB19048D39349")
    
public BigInteger getPrivateExponent() {
        return privateExponent;
    }
    
}

