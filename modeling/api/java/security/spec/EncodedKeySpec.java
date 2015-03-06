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

public abstract class EncodedKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.675 -0500", hash_original_field = "946CEA61F16F102AC83919F94FFB7B9D", hash_generated_field = "3144F97D80A45FCBB127B551D71851A1")

    private  byte[] encodedKey;

    /**
     * Creates a new {@code EncodedKeySpec} with the specified encoded key bytes.
     *
     * @param encodedKey
     *            the encoded key bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.678 -0500", hash_original_method = "AB5BB16CE68A0965872FC49BB9877C19", hash_generated_method = "C499631DD03306D7F40E7DE6314423B1")
    
public EncodedKeySpec(byte[] encodedKey) {
        // Defensively copies parameter
        // to prevent subsequent modification
        this.encodedKey = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0,
                this.encodedKey, 0, this.encodedKey.length);
    }

    /**
     * Returns the encoded key bytes.
     *
     * @return the encoded key bytes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.681 -0500", hash_original_method = "F8B261F87BF90DD753274675BF9DA222", hash_generated_method = "37C9E1C39B1D282064DBB6F77791FC6D")
    
public byte[] getEncoded() {
        // Defensively copies private array
        // to prevent subsequent modification
        byte[] ret = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        return ret;
    }

    /**
     * Returns the name of the encoding format of this encoded key
     * specification.
     *
     * @return the name of the encoding format of this encoded key
     *         specification.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.684 -0500", hash_original_method = "CA7EFC56395807F5B08C2CDFF0DEE77B", hash_generated_method = "090623DDECB8BCC454E2F65967F71FC5")
    
public abstract String getFormat();
    
}

