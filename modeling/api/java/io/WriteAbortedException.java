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

public class WriteAbortedException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.852 -0500", hash_original_field = "5DDCFCD1AC2D4E490B220A176BB0311B", hash_generated_field = "AA38F28709E0DCA1A936B26B13871FE3")

    private static final long serialVersionUID = -3326426625597282442L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.855 -0500", hash_original_field = "95762DE81C5FD7F68C9AFC34598F9FCB", hash_generated_field = "C3243AD40E57E22F6ED814DD71D64096")

    public Exception detail;

    /**
     * Constructs a new {@code WriteAbortedException} with its stack trace,
     * detail message and the exception which caused the underlying problem when
     * serializing the object filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param rootCause
     *            the exception that was thrown when serializing the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.857 -0500", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "457B192167E039B961CCBF6C255CAF6C")
    
public WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        detail = rootCause;
        initCause(rootCause);
    }

    /**
     * Gets the extra information message which was provided when this exception
     * was created. Returns {@code null} if no message was provided at creation
     * time.
     *
     * @return the exception message.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.860 -0500", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "7934F03FD51A9A133A34E4E968483B9C")
    
@Override
    public String getMessage() {
        String msg = super.getMessage();
        if (detail != null) {
            msg = msg + "; " + detail.toString();
        }
        return msg;
    }

    /**
     * Gets the cause of this exception or {@code null} if there is no cause.
     *
     * @return the exception cause.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.862 -0500", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "DC461A0F2F5995A95FCF9140AE6365B6")
    
@Override
    public Throwable getCause() {
        return detail;
    }
}

