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
import java.util.Date;

import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;

public final class InvalidityDate extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.167 -0500", hash_original_field = "CBF43A96A52318A1BBCC94C5214D4B0B", hash_generated_field = "9BCF15C1FFDD11FFF02BAB5AC5C1860B")

    public static final ASN1Type ASN1 = ASN1GeneralizedTime.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.155 -0500", hash_original_field = "DF617643B30A379B8E57A39F8DB3C6E0", hash_generated_field = "64CE46416AB14CBD0C0CFE7A851676E2")

    private  Date date;

    /**
     * Constructs the object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.158 -0500", hash_original_method = "98A9E577A59DEA03C0EE49B7902CB339", hash_generated_method = "449091B95622964E3D2E68F571DEC758")
    
public InvalidityDate(byte[] encoding) throws IOException {
        super(encoding);
        date = (Date) ASN1.decode(encoding);
    }

    /**
     * Returns the invalidity date.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.160 -0500", hash_original_method = "0B806974B94533A41261B38C9B34792D", hash_generated_method = "1C02A6F22AD8A4FEC8E92C05548B2359")
    
public Date getDate() {
        return date;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 InvalidityDate value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.162 -0500", hash_original_method = "B06BF934ECBF90D26364500F0540AD98", hash_generated_method = "D1A6F2820AB92464F78A483D0DF198D2")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(date);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.164 -0500", hash_original_method = "CC2AAAF6B06623B04694869CF132851E", hash_generated_method = "4275FDA41B56AFA612B036D4084F88F2")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
    }
}

