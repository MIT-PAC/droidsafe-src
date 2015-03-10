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


package org.apache.harmony.security.x509.tsp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/**
 * As defined in Time-Stamp Protocol (TSP)
 * (http://www.ietf.org/rfc/rfc3161.txt)
 *
 * MessageImprint ::= SEQUENCE  {
 *      hashAlgorithm                AlgorithmIdentifier,
 *      hashedMessage                OCTET STRING
 * }
 *
 */
public class MessageImprint {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.411 -0400", hash_original_field = "F2EB274E9371C9E6EE56ADBBE7643EAA", hash_generated_field = "FC1F83E0F506BFF68A860E7604692507")


    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
        AlgorithmIdentifier.ASN1,
        ASN1OctetString.getInstance()}) {

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new MessageImprint(
                    (AlgorithmIdentifier)values[0],
                    (byte[])values[1]);
        }

        protected void getValues(Object object, Object[] values) {
            MessageImprint mi = (MessageImprint) object;
            values[0] = mi.algId;
            values[1] = mi.hashedMessage;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.407 -0400", hash_original_field = "77AE1AC968895C7830B8ADE3B24ECA2A", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private  AlgorithmIdentifier algId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.408 -0400", hash_original_field = "18284FB7DA966087B8EC9BB96048057F", hash_generated_field = "056D2C2230A5AE1EBF3563B3635125D1")

    private  byte [] hashedMessage;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.408 -0400", hash_original_method = "90E8ADD99AFC9CA1EE80A513F3B8A3D2", hash_generated_method = "16922D15FF02CC73C9FFE3D831D513B5")
    
public MessageImprint(AlgorithmIdentifier algId, byte [] hashedMessage){
        this.algId = algId;
        this.hashedMessage = hashedMessage;
    }
}

