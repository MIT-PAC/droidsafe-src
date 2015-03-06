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
import java.math.BigInteger;

import org.apache.harmony.security.asn1.ASN1Integer;

public final class InhibitAnyPolicy extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.006 -0500", hash_original_field = "E50BA320A230875E33FBEB8EC9831240", hash_generated_field = "34CEC7EBF0D69FDD5ECCA6C7F25F7FAF")

    private  int skipCerts;

    /**
     * Creates an object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.008 -0500", hash_original_method = "1933FA0EC9823F8DA6E27E5F5995EEC8", hash_generated_method = "06B1380EF934ABD70BE5159A4A384BE7")
    
public InhibitAnyPolicy(byte[] encoding) throws IOException {
        super(encoding);
        this.skipCerts = new BigInteger((byte[])
                ASN1Integer.getInstance().decode(encoding)).intValue();
    }

    /**
     * Returns ASN.1 encoded form of the object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.011 -0500", hash_original_method = "3EBD51C43A05A1E4C8002DD6E78AE310", hash_generated_method = "93B1342ED85B3B9C4E78A3017E567EEB")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1Integer.getInstance()
                .encode(ASN1Integer.fromIntValue(skipCerts));
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.013 -0500", hash_original_method = "25B8E258E2717A4BB370159BACC96911", hash_generated_method = "5780D4B0AC51CDC952FBC456DCD1973E")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
    }
    
}

