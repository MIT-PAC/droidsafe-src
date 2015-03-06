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


package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class SSLException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.787 -0500", hash_original_field = "EF8FC78292841774D3D1555DB7B301C1", hash_generated_field = "E1A5658E80377BA2C7164C30C5149FA7")

    private static final long serialVersionUID = 4511006460650708967L;

    /**
     * Creates a new {@code SSLException} with the specified reason.
     *
     * @param reason
     *            the reason for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.791 -0500", hash_original_method = "767432C29D53FDFEE031F1BE821865F4", hash_generated_method = "1E377BFA8712A67ED08005B350F50442")
    
public SSLException(String reason) {
        super(reason);
    }

    /**
     * Creates a new {@code SSLException} with the specified message and cause.
     *
     * @param message
     *            the detail message for the exception.
     * @param cause
     *            the cause.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.793 -0500", hash_original_method = "5FF36E085E786A28DDEEC1EBE169EDD3", hash_generated_method = "62E00E815D798736CF38F05BC33176D1")
    
public SSLException(String message, Throwable cause) {
        super(message);
        super.initCause(cause);
    }

    /**
     * Creates a new {@code SSLException} with the specified cause.
     *
     * @param cause
     *            the cause
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.796 -0500", hash_original_method = "1E7679A49A32A86556807238CABB4D3B", hash_generated_method = "CD65939416DAD8F4A12A52BBF0391ED0")
    
public SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        super.initCause(cause);
    }
}

