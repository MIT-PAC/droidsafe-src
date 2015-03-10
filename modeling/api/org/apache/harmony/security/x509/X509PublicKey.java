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
import java.security.PublicKey;

public final class X509PublicKey implements PublicKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.987 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.989 -0500", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private  byte[] encoded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.991 -0500", hash_original_field = "C58A3C98BE896932A1CA164990DDB8E6", hash_generated_field = "F8BF44934CF513C25EA736CCFDA9B231")

    private  byte[] keyBytes;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.994 -0500", hash_original_method = "9FD348638D81D976A870B98763E67369", hash_generated_method = "00AE7068999CE575B147DFC448516BAE")
    
public X509PublicKey(String algorithm, byte[] encoded, byte[] keyBytes) {
        this.algorithm = algorithm;
        this.encoded = encoded;
        this.keyBytes = keyBytes;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.996 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.998 -0500", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "7238AE3F6AC2664EEF973F2CB2EA7A49")
    
public String getFormat() {
        return "X.509";
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.001 -0500", hash_original_method = "4EC4E5E78B7F57FB746895217115C4A0", hash_generated_method = "D6850C5A9F5DEB5E23D686FE3D53149E")
    
public byte[] getEncoded() {
        return encoded;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.004 -0500", hash_original_method = "20DEFC617AA5E46ABFC95D3E93C239C4", hash_generated_method = "96DFD8424131B803A4EF93B61EB26A33")
    
@Override
    public String toString() {
        StringBuilder buf = new StringBuilder("algorithm = ");
        buf.append(algorithm);
        buf.append(", params unparsed, unparsed keybits = \n");
        // TODO: implement compatible toString method()
        // buf.append(Arrays.toString(keyBytes));
        return buf.toString();
    }
    
}

