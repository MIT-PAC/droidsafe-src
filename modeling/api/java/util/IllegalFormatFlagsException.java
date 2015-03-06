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
import java.io.Serializable;

public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.863 -0500", hash_original_field = "21095941128B6129DEC37CD978EFF0FA", hash_generated_field = "3B223E7F26C32E3992CEACF94EAB3E33")

    private static final long serialVersionUID = 790824L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.866 -0500", hash_original_field = "806B57DB0428E85D2726FB0E46248D66", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private  String flags;

    /**
     * Constructs a new {@code IllegalFormatFlagsException} with the specified
     * flags.
     *
     * @param flags
     *           the specified flags.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.868 -0500", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "D0C22EC43D8E60BFD62B1C1311A559D1")
    
public IllegalFormatFlagsException(String flags) {
        if (flags == null) {
            throw new NullPointerException();
        }
        this.flags = flags;
    }

    /**
     * Returns the flags that are illegal.
     *
     * @return the flags that are illegal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.871 -0500", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "755C27A527F4F0B24180AE62DAAD9815")
    
public String getFlags() {
        return flags;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.873 -0500", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D3CC7E01EA9B8CB8A8BD4B18FB45E983")
    
@Override
    public String getMessage() {
        return flags;
    }
}

