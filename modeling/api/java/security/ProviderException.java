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

public class ProviderException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.527 -0500", hash_original_field = "6E25386BD252D6C891D04F11C860A646", hash_generated_field = "824A5F3D6F682455BB2A1994F230FF51")

    private static final long serialVersionUID = 5256023526693665674L;

    /**
     * Constructs a new instance of {@code ProviderException} with the given
     * message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.529 -0500", hash_original_method = "4F6DF0DF8572865516F19A786749BA2D", hash_generated_method = "8D2DBFEE39A91F52752FE961F075ED33")
    
public ProviderException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code ProviderException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.532 -0500", hash_original_method = "C6FD128032A25223FCE8DF59B6440EFD", hash_generated_method = "A7CAD064E0C0DFEA01146D642750AE5E")
    
public ProviderException() {
    }

    /**
     * Constructs a new instance of {@code ProviderException} with the given
     * message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.535 -0500", hash_original_method = "9D8D611DA847D087295A6CFF5F4EEF0C", hash_generated_method = "F40891BAAD3E5966A39EF052DD6559BF")
    
public ProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code ProviderException} with the cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.537 -0500", hash_original_method = "39103B62643A614FF10A8AB7735F1560", hash_generated_method = "CB6BEB26BB8D901CB7FD49F11A2E9FB4")
    
public ProviderException(Throwable cause) {
        super(cause);
    }
}

