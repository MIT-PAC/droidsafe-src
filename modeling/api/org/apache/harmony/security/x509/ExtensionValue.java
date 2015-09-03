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


package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.harmony.security.utils.Array;

public class ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.592 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "D780785EF370A874C4FD0A663CBEE653")

    protected byte[] encoding;

    /** Default constructor. */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.595 -0500", hash_original_method = "92B36A954C74D787717A80E6E1DCF4CB", hash_generated_method = "D1D0CC2F98E8E8D6230AA8A987B52F25")
    
public ExtensionValue() {}

    /** Creates the object on the base of its encoded form. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.597 -0500", hash_original_method = "92F18F58E02D664C24F95F43BB13284A", hash_generated_method = "34EA0CB7FE2D52EF5B3AFE41A5C11766")
    
public ExtensionValue(byte[] encoding) {
        this.encoding = encoding;
    }

    /** Returns encoded form of the object. */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.599 -0500", hash_original_method = "377D44A9A27BF814250295098F20477B", hash_generated_method = "1FAC514B8B58DEE35114AACC993B54AF")
    
public byte[] getEncoded() {
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.602 -0500", hash_original_method = "EBD96CEB228F4E98BF0AC3D53A96C792", hash_generated_method = "03A992F1793712A41C66624428C4CBB2")
    
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Unparseable extension value:\n");
        if (encoding == null) {
            encoding = getEncoded();
        }
        if (encoding == null) {
            sb.append("NULL\n");
        } else {
            sb.append(Array.toString(encoding, prefix));
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.604 -0500", hash_original_method = "6724193923CC6FF1B2BB2E93A0E55B86", hash_generated_method = "D296D2692AE900133BEA982B0CB51ACB")
    
public void dumpValue(StringBuilder sb) {
        dumpValue(sb, "");
    }
    
}

