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
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;

public final class SubjectKeyIdentifier extends ExtensionValue {

    /**
     * Creates an object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.112 -0500", hash_original_method = "D7BFACA82671057310D9C36F7CB9679A", hash_generated_method = "75384C91D2280B56E0B05ACDF140B3B6")
    
public static SubjectKeyIdentifier decode(byte[] encoding)
            throws IOException {
        SubjectKeyIdentifier res = new SubjectKeyIdentifier((byte[])
                ASN1OctetString.getInstance().decode(encoding));
        res.encoding = encoding;
        return res;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.107 -0500", hash_original_field = "006F8ED4DDFE79900363291BA15E74FC", hash_generated_field = "8624F6D40EA85567CEFE871C2375AD75")

    private  byte[] keyIdentifier;

    /**
     * Creates the object on the base of the value of key identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.110 -0500", hash_original_method = "98097DD6E6764877F7A5356FC5E050F1", hash_generated_method = "34F7F61637DBA8B7EB4DE3C660C7B1B6")
    
public SubjectKeyIdentifier(byte[] keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.115 -0500", hash_original_method = "17F99A1E4EF8655788B38E4E26DB47E6", hash_generated_method = "38288AA2E9620D0D5ABDEDEE6B2C8B72")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.117 -0500", hash_original_method = "0AA50EADEBB05513FDAD39FEE021DBF0", hash_generated_method = "C160BB75C8922D77374A78FD3B7E467A")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        sb.append(Array.toString(keyIdentifier, prefix));
        sb.append(prefix).append("]\n");
    }
    
}

