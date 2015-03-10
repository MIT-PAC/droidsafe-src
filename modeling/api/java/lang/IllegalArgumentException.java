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


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IllegalArgumentException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.618 -0500", hash_original_field = "8DEEE63FE04A48E614A2AE98B906C1D0", hash_generated_field = "A3B01955C80211826C1EDBC7C3F56AAA")

    private static final long serialVersionUID = -5365630128856068164L;

    /**
     * Constructs a new {@code IllegalArgumentException} that includes the
     * current stack trace.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.620 -0500", hash_original_method = "BA7A8F41F569FABF17AACC9F2A0F75BC", hash_generated_method = "108225E116CCD19305134C87B93E06AB")
    
public IllegalArgumentException() {
    }

    /**
     * Constructs a new {@code IllegalArgumentException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.623 -0500", hash_original_method = "D7D337F40643B35AC799AE8640B0B8F6", hash_generated_method = "9562BB172BC5C2EDC30D6E00CCDF876E")
    
public IllegalArgumentException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code IllegalArgumentException} with the current stack
     * trace, the specified detail message and the specified cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.625 -0500", hash_original_method = "7E098EA3EF50B45CC4772F0CD835FBB7", hash_generated_method = "B91024B75E52AFAC1BF8C2E01D1C72EE")
    
public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code IllegalArgumentException} with the current stack
     * trace and the specified cause.
     *
     * @param cause
     *            the cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.628 -0500", hash_original_method = "F1590E7EC4D7642CCEBCDC7875206A8D", hash_generated_method = "617ADCCDB708FBFF48044B80AD1463C6")
    
public IllegalArgumentException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}

