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


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InvalidClassException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.095 -0500", hash_original_field = "CE9324389034A94C9C02CEA22CFA031E", hash_generated_field = "D4E2FCFAAD906D95CB6BCEB015D3083F")

    private static final long serialVersionUID = -4333316296251054416L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.097 -0500", hash_original_field = "837D2AD61CB6DC3091BDAA053A2A4BD3", hash_generated_field = "B0C75E444ABFD30811DA4022885A4FE7")

    public String classname;

    /**
     * Constructs a new {@code InvalidClassException} with its stack trace and
     * detailed message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.100 -0500", hash_original_method = "EFF9B20162E74D1DBB80ACE44E70A573", hash_generated_method = "CAD53EAF9451EB48A06C746A30654AAE")
    
public InvalidClassException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code InvalidClassException} with its stack trace,
     * detail message and the fully qualified name of the class which caused the
     * exception filled in.
     *
     * @param className
     *            the name of the class that caused the exception.
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.102 -0500", hash_original_method = "A0014C5B63B7954D0D217FAB7EAA1F21", hash_generated_method = "B230E2C7B35102A647A7A9B3EC3660D1")
    
public InvalidClassException(String className, String detailMessage) {
        super(detailMessage);
        this.classname = className;
    }

    /**
     * Returns the detail message which was provided when the exception was
     * created. {@code null} is returned if no message was provided at creation
     * time. If a detail message as well as a class name are provided, then the
     * values are concatenated and returned.
     *
     * @return the detail message, possibly concatenated with the name of the
     *         class that caused the problem.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.106 -0500", hash_original_method = "F4D165DC6F6D9B89EF49B0E2E4445877", hash_generated_method = "C3EFF5E4545BA4F4FBD2F58729C9703A")
    
@Override
    public String getMessage() {
        String msg = super.getMessage();
        if (classname != null) {
            msg = classname + "; " + msg;
        }
        return msg;
    }
}

