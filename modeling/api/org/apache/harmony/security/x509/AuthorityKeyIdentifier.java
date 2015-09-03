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

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.utils.Array;

public final class AuthorityKeyIdentifier extends ExtensionValue {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.012 -0500", hash_original_method = "2C8925F53FCE2757A0E41E22228FD95C", hash_generated_method = "E8AAD59E4FF368F29BAAAFEB23FAE189")
    
public static AuthorityKeyIdentifier decode(byte[] encoding) throws IOException {
        AuthorityKeyIdentifier aki = (AuthorityKeyIdentifier) ASN1.decode(encoding);
        aki.encoding = encoding;
        return aki;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.823 -0400", hash_original_field = "614641B23F87DF30A1DD861AAD515E47", hash_generated_field = "E137446FB1207E7CEC699888878370F5")

    public static final ASN1Type ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                new ASN1Implicit(0, ASN1OctetString.getInstance()),
                new ASN1Implicit(1, GeneralNames.ASN1),
                new ASN1Implicit(2, ASN1Integer.getInstance()),
            }) {
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.021 -0500", hash_original_method = "8440A55DE3509FBE8D7DFB533886663B", hash_generated_method = "E5290763EB1AD0F43939086843EA730B")
        
@Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;

            byte[] enc = (byte[]) values[2];
            BigInteger authorityCertSerialNumber = null;
            if (enc != null) {
                authorityCertSerialNumber = new BigInteger(enc);
            }

            return new AuthorityKeyIdentifier((byte[]) values[0],
                    (GeneralNames) values[1], authorityCertSerialNumber);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.024 -0500", hash_original_method = "060A82E416E41470B7568E6658017C0D", hash_generated_method = "807259EFC028E1F570E10A50F39CFBD2")
        
@Override protected void getValues(Object object, Object[] values) {
            AuthorityKeyIdentifier akid = (AuthorityKeyIdentifier) object;
            values[0] = akid.keyIdentifier;
            values[1] = akid.authorityCertIssuer;
            if (akid.authorityCertSerialNumber != null) {
                values[2] = akid.authorityCertSerialNumber.toByteArray();
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.001 -0500", hash_original_field = "006F8ED4DDFE79900363291BA15E74FC", hash_generated_field = "8624F6D40EA85567CEFE871C2375AD75")

    private  byte[] keyIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.004 -0500", hash_original_field = "842FEF6BC1538786FC4EF70F01F25940", hash_generated_field = "AB8260635016A24FB1B26F25A3A14544")

    private  GeneralNames authorityCertIssuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.007 -0500", hash_original_field = "17ECF19DF307181AA01661590CCE7C4E", hash_generated_field = "FE603145245634792C066DB175A3D8A0")

    private  BigInteger authorityCertSerialNumber;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.009 -0500", hash_original_method = "5D5E1041410A971B297479A3E9285379", hash_generated_method = "0C9E08E5D17229AAC69270FB3C4217A1")
    
public AuthorityKeyIdentifier(byte[] keyIdentifier,
            GeneralNames authorityCertIssuer,
            BigInteger authorityCertSerialNumber) {
        this.keyIdentifier = keyIdentifier;
        this.authorityCertIssuer = authorityCertIssuer;
        this.authorityCertSerialNumber = authorityCertSerialNumber;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.014 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "552F71A862C62513AAC32037F4D2FC1B")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.017 -0500", hash_original_method = "8E2FBEC1389F8AD5C10937DA32053F15", hash_generated_method = "EF17429EA57A95E149D4C834A6D5A4BB")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("AuthorityKeyIdentifier [\n");
        if (keyIdentifier != null) {
            sb.append(prefix).append("  keyIdentifier:\n");
            sb.append(Array.toString(keyIdentifier, prefix + "    "));
        }
        if (authorityCertIssuer != null) {
            sb.append(prefix).append("  authorityCertIssuer: [\n");
            authorityCertIssuer.dumpValue(sb, prefix + "    ");
            sb.append(prefix).append("  ]\n");
        }
        if (authorityCertSerialNumber != null) {
            sb.append(prefix).append("  authorityCertSerialNumber: ");
            sb.append(authorityCertSerialNumber).append('\n');
        }
        sb.append(prefix).append("]\n");
    }
}

