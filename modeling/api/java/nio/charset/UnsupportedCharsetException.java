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


package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnsupportedCharsetException extends IllegalArgumentException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.557 -0500", hash_original_field = "9843EE09562B3583D5D7BDAFF370AD63", hash_generated_field = "355A963C969FC3135246825E305C339D")

    private static final long serialVersionUID = 1490765524727386367L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.559 -0500", hash_original_field = "5E24356DE8A42080D6D8EE74FC7DBA00", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")

    private String charsetName;

    /**
     * Constructs a new {@code UnsupportedCharsetException} with the supplied
     * charset name.
     *
     * @param charsetName
     *            the encountered unsupported charset name.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.562 -0500", hash_original_method = "EF2B407E9854D147BA5248D252ABFDC1", hash_generated_method = "B4FDE7E2EC7B1837A116402CE571ED86")
    
public UnsupportedCharsetException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        this.charsetName = charsetName;
    }

    /**
     * Gets the encountered unsupported charset name.
     *
     * @return the encountered unsupported charset name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.565 -0500", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "C3E3B8FCC038ED1DFB7C6F3AF5424FEA")
    
public String getCharsetName() {
        return charsetName;
    }
}

