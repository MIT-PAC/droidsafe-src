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
import java.util.Iterator;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class ExtendedKeyUsage extends ExtensionValue {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.100 -0400", hash_original_field = "1C1534A2AA96342A497C51FF8E5360A5", hash_generated_field = "BF598BD805210074FAC5B7D06116F7DE")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.276 -0500", hash_original_method = "324291EB7FC29F938FF2822490185CEC", hash_generated_method = "E684176ABDB941BE65FB64FA8A7929E1")
        
public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.261 -0500", hash_original_field = "EE4C3C9982A0696F6D933CC866CBC1C1", hash_generated_field = "B63F3A923567277A38E2C25A71F126D8")

    private List<String> keys;

    /**
     * Creates the extension object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.264 -0500", hash_original_method = "52F4822F456F1C9559212854B99C1B20", hash_generated_method = "5073F3D81BF13EE6AD09EC1D7AF1BEE0")
    
public ExtendedKeyUsage(byte[] encoding) {
        super(encoding);
    }

    /**
     * Returns the list of string representation of OIDs corresponding
     * to key purpose IDs.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.267 -0500", hash_original_method = "EC4A736D051BE2AF82868DFFF88ACC79", hash_generated_method = "C08D8A14C95987A92F34DDD9738ABC4F")
    
public List<String> getExtendedKeyUsage() throws IOException {
        if (keys == null) {
            keys = (List<String>) ASN1.decode(getEncoded());
        }
        return keys;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.269 -0500", hash_original_method = "63AFE39A4816AB8A1F7656BFDDDB680C", hash_generated_method = "C47EC007E48BAD93DD250D3352564B1E")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(keys);
        }
        return encoding;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.272 -0500", hash_original_method = "4F87579E7E9CA4B1B17B20CD410B3E10", hash_generated_method = "76915DB22A600812D57900C98F3F664F")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Extended Key Usage: ");
        if (keys == null) {
            try {
                keys = getExtendedKeyUsage();
            } catch (IOException e) {
                // incorrect extension value encoding
                super.dumpValue(sb);
                return;
            }
        }
        sb.append('[');
        for (Iterator<?> it = keys.iterator(); it.hasNext();) {
            sb.append(" \"").append(it.next()).append('"');
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(" ]\n");
    }
}

