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

public class PortUnreachableException extends SocketException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.283 -0500", hash_original_field = "41D437D9DE05E71A1330C5AA4854FB1A", hash_generated_field = "A4906FF1C1D822B7B0B02A02F86BC3CB")

    private static final long serialVersionUID = 8462541992376507323L;

    /**
     * Constructs a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.286 -0500", hash_original_method = "A9512F39350C94C0C69735359EF3AADA", hash_generated_method = "3B672CC1EE5CF4720FA4708FF79B3CB8")
    
public PortUnreachableException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.288 -0500", hash_original_method = "5D984FCFBC4DFCA56D23D59535D24C8C", hash_generated_method = "E2FA9012281FF4E6A4AF0779576B517D")
    
public PortUnreachableException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.291 -0500", hash_original_method = "3045F383C8CE75FC18DF1FE38D9A0FBC", hash_generated_method = "CCAADDDE493FD233E0D76984D43DE6D1")
    
public PortUnreachableException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

