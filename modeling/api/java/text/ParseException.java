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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ParseException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.772 -0500", hash_original_field = "8981FBE471D806A7618236C22EA1A6C5", hash_generated_field = "5A7101C6E28567B3F3B659C16DEAC630")

    private static final long serialVersionUID = 2703218443322787634L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.775 -0500", hash_original_field = "B788853ABE9B2871E364B41F20C8C424", hash_generated_field = "258A596A4575EE51D9F18F048FF1B7C5")

    private int errorOffset;

    /**
     * Constructs a new instance of this class with its stack trace, detail
     * message and the location of the error filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param location
     *            the index at which the parse exception occurred.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.778 -0500", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "8CD4FC8E1AC9ABF55C88FFAC857144E0")
    
public ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        errorOffset = location;
    }

    /**
     * Returns the index at which this parse exception occurred.
     *
     * @return the location of this exception in the parsed string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.781 -0500", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "5D59C3F156DEF1986BBF400D3ABFD44F")
    
public int getErrorOffset() {
        return errorOffset;
    }
}

