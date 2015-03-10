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


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InterruptedIOException;

public class SocketTimeoutException extends InterruptedIOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.050 -0500", hash_original_field = "D93F9799DEBA44686D0657CA13AF8ABA", hash_generated_field = "8C635471367BCD967F4DCF81C8430878")

    private static final long serialVersionUID = -8846654841826352300L;

    /**
     * Constructs a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.053 -0500", hash_original_method = "4A11638BF238EC4AAC97B2692C051A84", hash_generated_method = "8903FA48DC3DA7ABC8ACEDC2841258A0")
    
public SocketTimeoutException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSComment("no suspicious activity, just sets class variable")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.055 -0500", hash_original_method = "09713AE8E462C0BAD085649F546AAF7D", hash_generated_method = "55E366EE8A7AA79983A756D644DF43C1")
    
public SocketTimeoutException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.058 -0500", hash_original_method = "154D3A6011E860B522250E3541FB283D", hash_generated_method = "ECA46341136F35A0D143427AC23AAAC1")
    
public SocketTimeoutException(Throwable cause) {
        super(null, cause);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.061 -0500", hash_original_method = "A2F64A06EC646B0B6CC4F19E5E317D3C", hash_generated_method = "B65CC9595F8C152168EA0D7A0AF56977")
    
public SocketTimeoutException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

