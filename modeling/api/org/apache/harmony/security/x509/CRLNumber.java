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
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
import org.apache.harmony.security.asn1.ASN1Type;

public final class CRLNumber extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.355 -0500", hash_original_field = "CC5D8764BBAD99198237F31D02B97898", hash_generated_field = "7B920D394449223FD2E6E364A4B27926")

    public static final ASN1Type ASN1 = ASN1Integer.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.343 -0500", hash_original_field = "368C254C5AE70D812371AB837F173C30", hash_generated_field = "74AD3D429EE1BAEF847B6467FE79538D")

    private  BigInteger number;

    /**
     * Constructs the object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.346 -0500", hash_original_method = "F2D26D3BB1859BB9D7AC567B8EA30F7D", hash_generated_method = "D63FC22CD5BA247533281126B37F5678")
    
public CRLNumber(byte[] encoding) throws IOException {
        super(encoding);
        number = new BigInteger((byte[]) ASN1.decode(encoding));
    }

    /**
     * Returns the invalidity date.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.348 -0500", hash_original_method = "ABBA63B4278019F3F838A8B1357B04F0", hash_generated_method = "E37AC206F1FC9EAF282C8DCD0787C41D")
    
public BigInteger getNumber() {
        return number;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 CRLNumber value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.350 -0500", hash_original_method = "264373D11CB6B7A95DC9A45E336ACDCB", hash_generated_method = "06E3593BD04818F66D486922BDEB8794")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(number.toByteArray());
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.352 -0500", hash_original_method = "C82E67A30D76F52198943C49A8E53C0F", hash_generated_method = "4DBCBD5E9954A0C1219BA485E58B0911")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
    }
}

