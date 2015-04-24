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
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class KeyChainException extends Exception {

    /**
     * Constructs a new {@code KeyChainException} that includes the
     * current stack trace.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.267 -0500", hash_original_method = "07A073FF0F51A72901A8B28E6AC903AE", hash_generated_method = "02A24FEEB5AC65E638433C51E1C12BE4")
    
public KeyChainException() {
    }

    /**
     * Constructs a new {@code KeyChainException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.270 -0500", hash_original_method = "0A58DB61FCFCEABE9058FC3092E58BF3", hash_generated_method = "87AF306655F017EA667BF87615F03EBC")
    
public KeyChainException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code KeyChainException} with the current stack
     * trace, the specified detail message and the specified cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the cause of this exception, may be {@code null}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.273 -0500", hash_original_method = "3E8EDDC6FC8719784A3F6D961EFA0DBF", hash_generated_method = "0C9C6D90523277E25B3DFDE07B842BE4")
    
public KeyChainException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code KeyChainException} with the current stack
     * trace and the specified cause.
     *
     * @param cause
     *            the cause of this exception, may be {@code null}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.276 -0500", hash_original_method = "8CC23A5EEF616E11C5C7CDC0612B705F", hash_generated_method = "DE1CA4EB68D0FF20D9D270B4A5483195")
    
public KeyChainException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
    
}

