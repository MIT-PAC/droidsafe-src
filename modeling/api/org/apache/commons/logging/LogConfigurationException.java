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
 * Copyright 2001-2004 The Apache Software Foundation.
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


package org.apache.commons.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class LogConfigurationException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.654 -0500", hash_original_field = "7C503CF3045C4248B962E55347083A4A", hash_generated_field = "79DAA8AEAC199268F25EDA892CFE191F")

    protected Throwable cause = null;

    /**
     * Construct a new exception with <code>null</code> as its detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.644 -0500", hash_original_method = "5BD29D5C4388EC618AF76FB6968F33B3", hash_generated_method = "B17AA50EA89B76D08F40185F34724ACC")
    
public LogConfigurationException() {

        super();

    }

    /**
     * Construct a new exception with the specified detail message.
     *
     * @param message The detail message
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.647 -0500", hash_original_method = "DDAD033C1D6A94945D0EFE9FFDFBD321", hash_generated_method = "5B4389D4B9B55FA9762BA09D54DAC0CC")
    
public LogConfigurationException(String message) {

        super(message);

    }

    /**
     * Construct a new exception with the specified cause and a derived
     * detail message.
     *
     * @param cause The underlying cause
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.649 -0500", hash_original_method = "4454085F5358E0B8D9507639FB30951F", hash_generated_method = "1A9B82FCE81633FF238B936267427CF4")
    
public LogConfigurationException(Throwable cause) {

        this((cause == null) ? null : cause.toString(), cause);

    }

    /**
     * Construct a new exception with the specified detail message and cause.
     *
     * @param message The detail message
     * @param cause The underlying cause
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.652 -0500", hash_original_method = "451E311949AEF6CA521A34CAA7EB210C", hash_generated_method = "71F12EF3151EC3E6B6E3F6468216C725")
    
public LogConfigurationException(String message, Throwable cause) {

        super(message + " (Caused by " + cause + ")");
        this.cause = cause; // Two-argument version requires JDK 1.4 or later

    }

    /**
     * Return the underlying cause of this exception (if any).
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.656 -0500", hash_original_method = "9EB82C3F9FB6AE0D2962237AF0B1061E", hash_generated_method = "D8E404B2144DA9DC918822CCACE81477")
    
public Throwable getCause() {

        return (this.cause);

    }
    
}

