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


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Error extends Throwable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.157 -0500", hash_original_field = "386A00E1E27E51DFD74AF81FF1E097A4", hash_generated_field = "0C6BB99ACF2AC755166A071BFA44B261")

    private static final long serialVersionUID = 4980196508277280342L;

    /**
     * Constructs a new {@code Error} that includes the current stack trace.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.159 -0500", hash_original_method = "7D5BF5C7538ED3BFC2F69913B33169E2", hash_generated_method = "6D0C6454BB9469EF1C0429926C620B4F")
    
public Error() {
    }

    /**
     * Constructs a new {@code Error} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.163 -0500", hash_original_method = "C6CAA4A4AF257044103CFF33D3E9FE9A", hash_generated_method = "E3D8165277FA6D50061AAC001F58C19C")
    
public Error(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code Error} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param detailMessage
     *            the detail message for this error.
     * @param throwable
     *            the cause of this error.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.165 -0500", hash_original_method = "66AA244741442CFF9E9D4A286C858491", hash_generated_method = "86EF41D4B1FADF17B10BB3876C7BF584")
    
public Error(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new {@code Error} with the current stack trace and the
     * specified cause.
     *
     * @param throwable
     *            the cause of this error.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.168 -0500", hash_original_method = "4F891171DD00932FF603BE77BF813093", hash_generated_method = "A653D91049E5B51F33565FEFBC98BB1E")
    
public Error(Throwable throwable) {
        super(throwable);
    }
}

