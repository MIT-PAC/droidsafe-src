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
import java.security.GeneralSecurityException;

public class InvalidKeySpecException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.743 -0500", hash_original_field = "D10DD266BED1F65632E35B339736B40D", hash_generated_field = "6D03A6CA7C55F9BE4515461FA68F5D3F")

    private static final long serialVersionUID = 3546139293998810778L;

    /**
     * Creates a new {@code InvalidKeySpecException} with the specified message.
     *
     * @param msg
     *            the detail message of this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.746 -0500", hash_original_method = "DB6EC4555D24FA0B7F53C3D0CF9817D1", hash_generated_method = "9844F12B8D48A3614195EB71FC4321CC")
    
public InvalidKeySpecException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code InvalidKeySpecException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.749 -0500", hash_original_method = "62E7948E21963822758AD86C4EE61479", hash_generated_method = "289791F291E22122005330909940434E")
    
public InvalidKeySpecException() {
    }

    /**
     * Creates a new {@code InvalidKeySpecException} with the specified message
     * and cause.
     *
     * @param message
     *            the detail message of this exception.
     * @param cause
     *            the cause of this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.752 -0500", hash_original_method = "164335802BFF46F4D28D2A0D3E3265D8", hash_generated_method = "99C047DD964F6FEF601C2C0B8FCF29EB")
    
public InvalidKeySpecException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code InvalidKeySpecException} with the specified cause.
     *
     * @param cause
     *            the cause of this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.754 -0500", hash_original_method = "64F8C7884589B108D58D14C2DB6A45FC", hash_generated_method = "1DA7F5ED7792E666257CF6102B4069F1")
    
public InvalidKeySpecException(Throwable cause) {
        super(cause);
    }
}

