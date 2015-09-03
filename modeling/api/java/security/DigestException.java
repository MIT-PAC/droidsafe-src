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

public class DigestException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.003 -0500", hash_original_field = "E452B9EC58667CE2A5F7CBB9D62299F3", hash_generated_field = "853F3DF1FAC804A2D310C3B47CFD7996")

    private static final long serialVersionUID = 5821450303093652515L;

    /**
     * Constructs a new instance of {@code DigestException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.006 -0500", hash_original_method = "5DAAB61061CBFECD5A1E1A61BC7BAA88", hash_generated_method = "0DBA4FCDF31281A92C6AF2C31935DF04")
    
public DigestException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code DigestException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.009 -0500", hash_original_method = "4BFD0A9812571E805B2B692917954A18", hash_generated_method = "37A829DB0B3E723B4558F5F7D4508D49")
    
public DigestException() {
    }

    /**
     * Constructs a new instance of {@code DigestException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.012 -0500", hash_original_method = "BCC7846DF9BFB7C5F5EA1087695CCF8F", hash_generated_method = "EE670F61890C190CF353A5C9C0CA66C7")
    
public DigestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code DigestException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.015 -0500", hash_original_method = "57079B2A067E95F6018E75F3448CD9E3", hash_generated_method = "6F48F0842ACE830A7DA85EC097885ACA")
    
public DigestException(Throwable cause) {
        super(cause);
    }
}

