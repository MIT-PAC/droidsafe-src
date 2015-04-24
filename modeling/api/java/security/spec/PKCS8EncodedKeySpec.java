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

public class PKCS8EncodedKeySpec extends EncodedKeySpec {

    /**
     * Creates a new {@code PKCS8EncodedKeySpec} with the specified encoded key
     * bytes.
     *
     * @param encodedKey
     *            the encoded key bytes.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.713 -0500", hash_original_method = "EEE3491490D4DFB630EB03F68D682F22", hash_generated_method = "86C6D6A7BC7FF0954F0F19E99C2DA49F")
    
public PKCS8EncodedKeySpec(byte[] encodedKey) {
        // Super class' ctor makes defensive parameter copy
        super(encodedKey);
    }

    /**
     * Returns a copy of the encoded key bytes.
     *
     * @return a copy of the encoded key bytes.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.715 -0500", hash_original_method = "79A7CC1F7A80EF2ADD7D2AFF5368D500", hash_generated_method = "E32E93258666D229EF01F9B67C223079")
    
public byte[] getEncoded() {
        // Super class' getEncoded() always returns a new array
        return super.getEncoded();
    }

    /**
     * Returns the name of the encoding format of this encoded key
     * specification.
     *
     * @return the string "PKCS#8".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.718 -0500", hash_original_method = "CC009CA66A5AFAFE0E87AA4EEC147948", hash_generated_method = "B50F99C7BAF445D2AA7C64194FE029F2")
    
public final String getFormat() {
        return "PKCS#8";
    }
    
}

