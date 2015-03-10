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
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class PolicyInformation {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.662 -0400", hash_original_field = "5F2D8C5221F74D1DF86123C2DA677D6B", hash_generated_field = "BFFF063EC30CEABB951E1244D2EB5617")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(
            new ASN1Type[] { ASN1Oid.getInstance(), ASN1Any.getInstance() }) {
        {
            setOptional(1);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.527 -0500", hash_original_method = "8501EA7BFA173E6518BAFB2356927122", hash_generated_method = "09D687E9F905A831F5B25FAAFF17A479")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new PolicyInformation(ObjectIdentifier.toString((int[]) values[0]));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.530 -0500", hash_original_method = "0627C35F4A048D619EB92B23493B5466", hash_generated_method = "3A58122F2D5CFA5A8FDBF58E91D783DC")
        
@Override protected void getValues(Object object, Object[] values) {
            PolicyInformation pi = (PolicyInformation) object;
            values[0] = ObjectIdentifier.toIntArray(pi.policyIdentifier);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.513 -0500", hash_original_field = "A9ABC7EE563DCA91222939281867AAC8", hash_generated_field = "9775983C00DA46C6C34065F5DC2DC5C0")

    private  String policyIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.515 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.517 -0500", hash_original_method = "97521BA30F23785F6A554ACA63DC6021", hash_generated_method = "833091C6C18CA140FD7DE85A57DDDAB7")
    
public PolicyInformation(String policyIdentifier) {
        this.policyIdentifier = policyIdentifier;
    }

    /**
     * Returns the value of policyIdentifier field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.519 -0500", hash_original_method = "012FFA67DCC82ECD3E1505D0CB12E6E1", hash_generated_method = "637BB49A56CB3A3EEA0763BCBC98422F")
    
public String getPolicyIdentifier() {
        return policyIdentifier;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 PolicyInformation value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.521 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.523 -0500", hash_original_method = "76E469F93D4AF204B8C17A8AD4618A81", hash_generated_method = "9EC1E0EA0EE52F366308126A8C4FEA58")
    
public void dumpValue(StringBuilder sb) {
        sb.append("Policy Identifier [").append(policyIdentifier).append(']');
    }
}

