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


package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;

public class CRLException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.159 -0500", hash_original_field = "0B2010087B3EB14709BBD1AB3CDBEBC1", hash_generated_field = "D0A7C8EE3531577BE0E356C190759BFC")

    private static final long serialVersionUID = -6694728944094197147L;

    /**
     * Creates a new {@code CRLException} with the specified message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.161 -0500", hash_original_method = "60672CA36668A1D34242C570333ABE8C", hash_generated_method = "136E7E2655495075C1E045E6967FB193")
    
public CRLException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CRLException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.164 -0500", hash_original_method = "5E03B595357100C7FE02CA0C3CD0CBF1", hash_generated_method = "C983FAF8908CFDB233B424BE26E1E163")
    
public CRLException() {
    }

    /**
     * Creates a new {@code CRLException} with the specified message and cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.167 -0500", hash_original_method = "529EF340AA7D68AE4AFE9D9F624919F8", hash_generated_method = "D5B6C74A410633040CBF634B88A8D9B1")
    
public CRLException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code CRLException} with the specified cause.
     *
     * @param cause
     *            the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.170 -0500", hash_original_method = "DFA7CB52116B1FBFC93D3E254D1E3FDD", hash_generated_method = "069B2ED493F791E443EB750457C913C1")
    
public CRLException(Throwable cause) {
        super(cause);
    }
}

