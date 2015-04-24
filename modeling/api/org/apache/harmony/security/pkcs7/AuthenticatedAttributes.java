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
* @author Boris Kuznetsov
* @version $Revision$
*/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;

final class AuthenticatedAttributes {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.042 -0400", hash_original_field = "2611A8BAF0FBA182E1D618DBDEE9F51B", hash_generated_field = "F0C53D8DBCC45A640193D6CD74C62FBF")

    public static final ASN1SetOf ASN1 =
        new ASN1SetOf(AttributeTypeAndValue.ASN1) {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.749 -0500", hash_original_method = "5573740F3DACB7D46EB4DD6230978B94", hash_generated_method = "BEDE3A83699DF511A88E090764D17D0D")
        
@Override public Object getDecodedObject(BerInputStream in) {
            return new AuthenticatedAttributes(in.getEncoded(),
                    (List<AttributeTypeAndValue>) in.content);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.736 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.739 -0500", hash_original_field = "FEEF9ABB7ED1D3CB188A0CF9FFB384E5", hash_generated_field = "147A37554AFD2423D8BB55EBBE06C894")

    private  List<AttributeTypeAndValue> authenticatedAttributes;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.741 -0500", hash_original_method = "56322F0DE2F5B85A8944FA9A9F9F5ADE", hash_generated_method = "41B065CA0420A16A106CA7EC5DE1E0FD")
    
private AuthenticatedAttributes(byte[] encoding,
            List<AttributeTypeAndValue> authenticatedAttributes) {
        this.encoding = encoding;
        this.authenticatedAttributes = authenticatedAttributes;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.743 -0500", hash_original_method = "17512B9B260049DCE667B4C278AB32BC", hash_generated_method = "AEB7DC2CF68F5A1815EA77C7E602B19B")
    
public List<AttributeTypeAndValue> getAttributes() {
        return authenticatedAttributes;
    }

    /**
     * Returns ASN.1 encoded form of this authenticatedAttributes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.746 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}

