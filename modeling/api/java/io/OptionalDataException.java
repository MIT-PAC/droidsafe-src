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

public class OptionalDataException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.598 -0500", hash_original_field = "FDBC11225C979DE3098287A09D755E2A", hash_generated_field = "DDC830DCF3194537EFCDF0B62E5DB379")

    private static final long serialVersionUID = -8011121865681257820L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.600 -0500", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "A5BD226ED75D266A3BA0CDE2B4165A63")

    public boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.603 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;

    /**
     * Constructs a new {@code OptionalDataException} with its stack trace
     * filled in.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.605 -0500", hash_original_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A", hash_generated_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A")
    
OptionalDataException() {
    }

    /**
     * Constructs a new {@code OptionalDataException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.608 -0500", hash_original_method = "EE3BF9736C6F166E6F73C7336660246A", hash_generated_method = "EE3BF9736C6F166E6F73C7336660246A")
    
OptionalDataException(String detailMessage) {
        super(detailMessage);
    }
}

