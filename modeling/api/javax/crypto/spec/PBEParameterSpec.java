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


package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;

public class PBEParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.286 -0500", hash_original_field = "E37DC2BC2509FBBDB9429277FE4D77AB", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private  byte[] salt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.288 -0500", hash_original_field = "63985F5D8355AAA3166FE055813432C8", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private  int iterationCount;

    /**
     * Creates a new <code>PBEParameterSpec</code> with the specified salt and
     * iteration count.
     *
     * @param salt
     *            the salt.
     * @param iterationCount
     *            the iteration count.
     * @throws NullPointerException
     *             if salt is null.
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.291 -0500", hash_original_method = "E4AD3F6E1F8504EC055E33BFD3FD6D04", hash_generated_method = "E8D546866AF64A65F678EC41E51DF1E7")
    
public PBEParameterSpec(byte[] salt, int iterationCount) {
        if (salt == null) {
            throw new NullPointerException("salt == null");
        }
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
    }

    /**
     * Returns a copy to the salt.
     *
     * @return a copy to the salt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.293 -0500", hash_original_method = "DE7716C6003A9CBA24C4421C19D5F40E", hash_generated_method = "D0ED991A2E5BCB96A35AFED4AC0BCA82")
    
public byte[] getSalt() {
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        return result;
    }

    /**
     * Returns the iteration count.
     *
     * @return the iteration count.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.295 -0500", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "583EA89A4A01F3B828D69488C83B2B0E")
    
public int getIterationCount() {
        return iterationCount;
    }
    
}

