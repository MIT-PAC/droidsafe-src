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

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

public final class CertificateIssuer extends ExtensionValue {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.907 -0400", hash_original_field = "26467BCE56C2E2E5052FBB838762A5FF", hash_generated_field = "FE3BF8D4A6349EB434E9E8BE6B183663")

    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[] { GeneralName.ASN1 }) {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.673 -0500", hash_original_method = "B2A2BF1AEEB9B5ED68F04D56AA862E02", hash_generated_method = "E61AB4676D073F9A810BB220F7B3A9C6")
        
@Override public Object getDecodedObject(BerInputStream in) {
            return ((Name) ((GeneralName) ((Object[]) in.content)[0])
                    .getName()).getX500Principal();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.676 -0500", hash_original_method = "F62248487F946226E81F44B251123553", hash_generated_method = "2061B2BAEFFF6C6ADEE928DA223F54D3")
        
@Override protected void getValues(Object object, Object[] values) {
            values[0] = object;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.662 -0500", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;

    /**
     * Creates an object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.664 -0500", hash_original_method = "DA4BDBC496D2A998B5C29C74B17A91EA", hash_generated_method = "4F10A592A481471502293BBFC0BAA01E")
    
public CertificateIssuer(byte[] encoding) {
        super(encoding);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.667 -0500", hash_original_method = "A624F7DB93A0D045C3602F26988D09C5", hash_generated_method = "71D4683950BC980DAB492FDD9601ACCC")
    
public X500Principal getIssuer() throws IOException {
        if (issuer == null) {
            issuer = (X500Principal) ASN1.decode(getEncoded());
        }
        return issuer;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.669 -0500", hash_original_method = "50826A9F4B6111EEE8495EBA7ED178B7", hash_generated_method = "31B66B38912D363E4867D0FC5B57864C")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Certificate Issuer: ");
        if (issuer == null) {
            try {
                issuer = getIssuer();
            } catch (IOException e) {
                // incorrect extension value encoding
                sb.append("Unparseable (incorrect!) extension value:\n");
                super.dumpValue(sb);
            }
        }
        sb.append(issuer).append('\n');
    }
}

