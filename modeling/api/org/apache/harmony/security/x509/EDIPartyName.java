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
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.DirectoryString;

public final class EDIPartyName {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.081 -0400", hash_original_field = "F09E30973AEF91130C504D57F6F7184E", hash_generated_field = "69033EAAAFF984476D66802FF78AA0DF")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                new ASN1Explicit(0, DirectoryString.ASN1),
                new ASN1Explicit(1, DirectoryString.ASN1)
            }) {
        {
            setOptional(0);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.135 -0500", hash_original_method = "80CB811341E4F5308AB1A53211E096F1", hash_generated_method = "66598F07319BC5B0DCB1BBFB0D72392B")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new EDIPartyName((String) values[0], (String) values[1],
                    in.getEncoded());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.137 -0500", hash_original_method = "B1C02B42453062F13A81A1B4E1763CE8", hash_generated_method = "CF76873F481061BC844EC7B9D28C2500")
        
@Override protected void getValues(Object object, Object[] values) {
            EDIPartyName epn = (EDIPartyName) object;
            values[0] = epn.nameAssigner;
            values[1] = epn.partyName;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.121 -0500", hash_original_field = "6CF5A35685820BF2E14F95387E355D8F", hash_generated_field = "E531E1267091A670A42BD3F34A2AF2BA")

    private  String nameAssigner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.124 -0500", hash_original_field = "3ADE77679143C302CAD7B16B5F163240", hash_generated_field = "41E7F03877DA6734D1332D3C70A19F95")

    private  String partyName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.126 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.129 -0500", hash_original_method = "2E4835ED3F1B68ED273C9B2B326EFCFA", hash_generated_method = "5CAD23B017BEF927499DE6F26BD8E190")
    
private EDIPartyName(String nameAssigner, String partyName, byte[] encoding) {
        this.nameAssigner = nameAssigner;
        this.partyName = partyName;
        this.encoding = encoding;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 EDIPartyName value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.131 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}

