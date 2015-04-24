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

public class IOException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.987 -0500", hash_original_field = "B1489E9C2F91511CC7ABA4754C388294", hash_generated_field = "E1BB06D1BDEDB21E301ADD66B95C6A57")

    private static final long serialVersionUID = 7818375828146090155L;

    /**
     * Constructs a new {@code IOException} with its stack trace filled in.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.989 -0500", hash_original_method = "4DDFF90B7CF8CD74272BB60235E66E65", hash_generated_method = "2B20F6BC5311851A287D855E8383F8C8")
    
public IOException() {
    }

    /**
     * Constructs a new {@code IOException} with its stack trace and detail
     * message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.992 -0500", hash_original_method = "240D0BB3974E5D097E21F85B24F6FB44", hash_generated_method = "6B62B2903FC8CDC509B50797A6D8D38A")
    
public IOException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance of this class with detail message and cause
     * filled in.
     *
     * @param message
     *            The detail message for the exception.
     * @param cause
     *            The detail cause for the exception.
     * @since 1.6
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.995 -0500", hash_original_method = "D16D4F9A4DF133858001870C6413D65C", hash_generated_method = "9EE73FDB0C546D60128128DD662DBF63")
    
public IOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of this class with its detail cause filled in.
     *
     * @param cause
     *            The detail cause for the exception.
     * @since 1.6
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.997 -0500", hash_original_method = "653E955146B329965A610B3602D07E3E", hash_generated_method = "5FC282426A31CD7F17EA87DB0C0514BE")
    
public IOException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }
}

