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


package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class MalformedInputException extends CharacterCodingException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.083 -0500", hash_original_field = "2B7F2530086621A042092B57ACAB6983", hash_generated_field = "AD2DD481E60844E3D7253976946DDA58")

    private static final long serialVersionUID = -3438823399834806194L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.086 -0500", hash_original_field = "755C7B08BD7CC897183CC4B0B5436326", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;

    /**
     * Constructs a new {@code MalformedInputException}.
     *
     * @param length
     *            the length of the malformed input.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.088 -0500", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "9353A0EB2ECDCF84D7E945D0B98F71D8")
    
public MalformedInputException(int length) {
        this.inputLength = length;
    }

    /**
     * Gets the length of the malformed input.
     *
     * @return the length of the malformed input.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.091 -0500", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "FA812069F55585CBB369DCEB6C68F21E")
    
public int getInputLength() {
        return this.inputLength;
    }


    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.093 -0500", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "1857012EE798A7AA3F53EF74BDA89DF6")
    
@Override
    public String getMessage() {
        return "Length: " + inputLength;
    }
}

