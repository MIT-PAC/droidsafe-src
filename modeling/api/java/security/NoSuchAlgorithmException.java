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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NoSuchAlgorithmException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.523 -0500", hash_original_field = "9168C4DE150E2C2219985B5C6CE39AED", hash_generated_field = "6FE1C320D9DA70D0E4A8AE85FC938A15")

    private static final long serialVersionUID = -7443947487218346562L;

    /**
     * Constructs a new instance of {@code NoSuchAlgorithmException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.526 -0500", hash_original_method = "8378123FC231FFDF9C6899E890D8DBB0", hash_generated_method = "9120FC834265F0B8C34CB49D0087ECAA")
    
public NoSuchAlgorithmException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code NoSuchAlgorithmException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.529 -0500", hash_original_method = "BDAEA1DD03CDDD29A73CAE9E450C10A2", hash_generated_method = "9106D90C77013696391DACCE1BCE4848")
    
public NoSuchAlgorithmException() {
    }

    /**
     * Constructs a new instance of {@code NoSuchAlgorithmException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.532 -0500", hash_original_method = "738326F937D05503D0FB4C9FA84CE359", hash_generated_method = "006AFCDFEE5BFFFFB552A872739FE891")
    
public NoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code NoSuchAlgorithmException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.534 -0500", hash_original_method = "24E352B1812045F462874BBBC93C9102", hash_generated_method = "239CE1DE571F8A982A309EB323FEF0C1")
    
public NoSuchAlgorithmException(Throwable cause) {
        super(cause);
    }
}

