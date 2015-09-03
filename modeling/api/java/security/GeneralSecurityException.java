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

public class GeneralSecurityException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.930 -0500", hash_original_field = "405DD9FBA96A0927742ABBB449405C20", hash_generated_field = "F3DAE821DA81007CC901C8C9F2AFD853")

    private static final long serialVersionUID = 894798122053539237L;

    /**
     * Constructs a new instance of {@code GeneralSecurityException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.933 -0500", hash_original_method = "DF58B5CAF337DE33E44F54F447F733AD", hash_generated_method = "E776BAAF24977B6ADD7C2CEE90496CE9")
    
public GeneralSecurityException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code GeneralSecurityException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.936 -0500", hash_original_method = "F9327F749082DE23B0685F6DD902B858", hash_generated_method = "DEFCDA2D930C1A41C786D9F4C49800BB")
    
public GeneralSecurityException() {
    }

    /**
     * Constructs a new instance of {@code GeneralSecurityException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.938 -0500", hash_original_method = "577694F56592C068A46C118A7E1B2604", hash_generated_method = "63A4DF5B3964856330EFF449BF86AAA0")
    
public GeneralSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code GeneralSecurityException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.941 -0500", hash_original_method = "44918F9A2CF16E0F2387B03C3A16E529", hash_generated_method = "AA74B500A81C814BDD18224634889196")
    
public GeneralSecurityException(Throwable cause) {
        super(cause);
    }
}

