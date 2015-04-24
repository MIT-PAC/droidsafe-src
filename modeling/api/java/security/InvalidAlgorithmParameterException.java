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

public class InvalidAlgorithmParameterException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.957 -0500", hash_original_field = "4A1F897BE08446645911F0327B941CEA", hash_generated_field = "860F70BF4B332299464A61D7F7CDE3BE")

    private static final long serialVersionUID = 2864672297499471472L;

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException}
     * with the given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.960 -0500", hash_original_method = "8764EFDBF443E087329639C5F03FBF33", hash_generated_method = "39F090F307D04B07F933D3B779FE2DFD")
    
public InvalidAlgorithmParameterException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.963 -0500", hash_original_method = "6854FBA50B4775039731A07DEA1BCECF", hash_generated_method = "39BD5A94C30671B897C727ADBCEDD9C9")
    
public InvalidAlgorithmParameterException() {
    }

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.966 -0500", hash_original_method = "8C1684940E5C6F60C794DE0A4727DA86", hash_generated_method = "DCCEDA396C02F815988B8383EFADDCB6")
    
public InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException}
     * with the cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.969 -0500", hash_original_method = "EFB1E846A63455E1688ABC4BA0B50914", hash_generated_method = "709419BDD9594B7652B467D9F2F0C2A5")
    
public InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
    }
}

