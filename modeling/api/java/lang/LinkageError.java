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

public class LinkageError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.075 -0500", hash_original_field = "9B44CF72CFEE8E2328FF33B1B1DF2555", hash_generated_field = "26764E9962CE8BCD1CC3E5C82CC971B6")

    private static final long serialVersionUID = 3579600108157160122L;

    /**
     * Constructs a new {@code LinkageError} that includes the current stack
     * trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.077 -0500", hash_original_method = "F8257C8B139D012B1AF21CEDF65AEAF0", hash_generated_method = "39CB35F13B33ABCDCDED8019268A5407")
    
public LinkageError() {
    }

    /**
     * Constructs a new {@code LinkageError} with the current stack trace and
     * the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.080 -0500", hash_original_method = "3F282F39CCEC2A75C9FAEF6579E7409E", hash_generated_method = "7DDBA2430E3ED5C581B26CD61B51F33F")
    
public LinkageError(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code LinkageError} with the given detail message and cause.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.083 -0500", hash_original_method = "EA091AF8CE4C0C3DC980640F02BF597B", hash_generated_method = "F7BDF843E44AC3DDAEC5BE3C74AF0A83")
    
public LinkageError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

