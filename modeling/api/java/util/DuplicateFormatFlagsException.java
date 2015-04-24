/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DuplicateFormatFlagsException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.992 -0500", hash_original_field = "69212B48BC641C20E2E5ACE6CED63595", hash_generated_field = "4C0E6AE2289782AA658DEA3E3AFA2999")

    private static final long serialVersionUID = 18890531L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.994 -0500", hash_original_field = "806B57DB0428E85D2726FB0E46248D66", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private  String flags;

    /**
     * Constructs a new {@code DuplicateFormatFlagsException} with the flags
     * containing duplicates.
     *
     * @param f
     *           the format flags that contain a duplicate flag.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.997 -0500", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "83F4CCFB7ED7CF4F9ACCFE23B4350C57")
    
public DuplicateFormatFlagsException(String f) {
        if (f == null) {
            throw new NullPointerException();
        }
        flags = f;
    }

    /**
     * Returns the format flags that contain a duplicate flag.
     *
     * @return the format flags that contain a duplicate flag.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:48.000 -0500", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "755C27A527F4F0B24180AE62DAAD9815")
    
public String getFlags() {
        return flags;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:48.002 -0500", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D3CC7E01EA9B8CB8A8BD4B18FB45E983")
    
@Override
    public String getMessage() {
        return flags;
    }
}

