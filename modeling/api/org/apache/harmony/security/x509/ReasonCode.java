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

import org.apache.harmony.security.asn1.ASN1Enumerated;
import org.apache.harmony.security.asn1.ASN1Type;

public final class ReasonCode extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.304 -0500", hash_original_field = "7F9D9C29CB293F4A4F060B1EA2611944", hash_generated_field = "FC9B9354EEC4DDC14F6C969560681A6C")

    public static final byte UNSPECIFIED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.307 -0500", hash_original_field = "77419538B0813F4506C3F05D5FDE0711", hash_generated_field = "57753DF43B94713A71E3FED437583FD7")

    public static final byte KEY_COMPROMISE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.310 -0500", hash_original_field = "9E5C09F2AD99695431C75BD0F9694412", hash_generated_field = "06909C5AF2A63D587073F1A46DC9C51A")

    public static final byte CA_COMPROMISE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.312 -0500", hash_original_field = "F0DF5093C8BA1BA3B24187C0121DB9A4", hash_generated_field = "DC5D635D8C5080986F86797396F3F90A")

    public static final byte AFFILIATION_CHANGED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.315 -0500", hash_original_field = "EBFA45976BB6BE590F201754B934B51B", hash_generated_field = "713395AB4EA284591E642556D26A3288")

    public static final byte SUPERSEDED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.318 -0500", hash_original_field = "D599B891A7DCCFFF032ACAA5FEE13EE9", hash_generated_field = "FFB0D097194866B6C27F979225C7A60B")

    public static final byte CESSATION_OF_OPERATION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.320 -0500", hash_original_field = "DADFB229DFE0372BC6B3553FDE1E5E1C", hash_generated_field = "5BA983A7D28016C12332BEC19DC1198F")

    public static final byte CERTIFICATE_HOLD = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.322 -0500", hash_original_field = "CB6AF9AC505311A48A9CC559BD3F1010", hash_generated_field = "3A87D7BBDAFC3B4B671B1E694BDE6D46")

    public static final byte REMOVE_FROM_CRL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.325 -0500", hash_original_field = "1B3CCE71638274120E424073C8DA87A0", hash_generated_field = "1180757F90A87B0B34CE627BB704EC5E")

    public static final byte PRIVILEGE_WITHDRAWN = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.327 -0500", hash_original_field = "8FF64D09813CAB4832D496704ADC2F46", hash_generated_field = "5282872BE9B89D0419CDE70E41F096CB")

    public static final byte AA_COMPROMISE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.340 -0500", hash_original_field = "4A4CF832E22B3F25F49D9909D0B0DC26", hash_generated_field = "36DF4BBF2E7BB18F36AA22BFE20AF0DE")

    public static final ASN1Type ASN1 = ASN1Enumerated.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.330 -0500", hash_original_field = "FF64CFDF26E4827D529634E09A411821", hash_generated_field = "38BD380FAFFB7B224FC85C442EDC81E3")

    private  byte code;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.332 -0500", hash_original_method = "82F7372CC184C4A16042B3B65BCB1447", hash_generated_method = "E490809007D95175C20EBAC5166B0707")
    
public ReasonCode(byte[] encoding) throws IOException {
        super(encoding);
        this.code = ((byte[]) ASN1.decode(encoding))[0];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.334 -0500", hash_original_method = "410E015295E6E50D0A716577DAE7F9D9", hash_generated_method = "77CC6166D02C02F0CA98A03ED2E931F1")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(new byte[] { code });
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:57.337 -0500", hash_original_method = "12E79139137D00D785F5C6D5EDD972F8", hash_generated_method = "6C34A8436B3A4AB901145790E3231321")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Reason Code: [ ");
        switch (code) {
        case UNSPECIFIED:
            sb.append("unspecified");
            break;
        case KEY_COMPROMISE:
            sb.append("keyCompromise");
            break;
        case CA_COMPROMISE:
            sb.append("cACompromise");
            break;
        case AFFILIATION_CHANGED:
            sb.append("affiliationChanged");
            break;
        case SUPERSEDED:
            sb.append("superseded");
            break;
        case CESSATION_OF_OPERATION:
            sb.append("cessationOfOperation");
            break;
        case CERTIFICATE_HOLD:
            sb.append("certificateHold");
            break;
        case REMOVE_FROM_CRL:
            sb.append("removeFromCRL");
            break;
        case PRIVILEGE_WITHDRAWN:
            sb.append("privilegeWithdrawn");
            break;
        case AA_COMPROMISE:
            sb.append("aACompromise");
            break;
        }
        sb.append(" ]\n");
    }
}

