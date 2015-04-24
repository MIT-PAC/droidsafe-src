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

public class InterruptedIOException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.620 -0500", hash_original_field = "D1BB675B1635CBE9F0E1026ABD5ABCD7", hash_generated_field = "00B7350ACE79265F1BE5866C28B5A783")

    private static final long serialVersionUID = 4020568460727500567L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.622 -0500", hash_original_field = "BD85AB55237C037827FEDC1A9DD400CE", hash_generated_field = "ADADEC4FF5BBED2ACE9FA0E36B78EE7E")

    public int bytesTransferred;

    /**
     * Constructs a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.625 -0500", hash_original_method = "BB9DACD07ED93D41347C3772C10021CB", hash_generated_method = "DA2DCBE5F00DBE7618C1F279A9CD37FF")
    
public InterruptedIOException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSComment("exception message, is only a data structure")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.628 -0500", hash_original_method = "9DCF8CB18681541ED5194D8FB0295B7F", hash_generated_method = "837332240A809019E15EECCF3637FEBC")
    
public InterruptedIOException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.630 -0500", hash_original_method = "4976F1F97DF8BBE1F3AC7D56299FEDE9", hash_generated_method = "B7BD75FFB7A63D382828D0D142B70454")
    
public InterruptedIOException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

