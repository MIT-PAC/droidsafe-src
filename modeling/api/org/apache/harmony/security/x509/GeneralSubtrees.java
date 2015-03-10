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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralSubtrees {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.385 -0400", hash_original_field = "0799060D53393B92181BE0F337148C10", hash_generated_field = "E8931CE4F0A844140DFFB6382D546C0B")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralSubtree.ASN1) {
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.464 -0500", hash_original_method = "2D9DF534E99C5FC68E76E143BAF9A37A", hash_generated_method = "D16B5939118BF36E824BFC240BA00D2E")
        
@Override public Object getDecodedObject(BerInputStream in) {
            return new GeneralSubtrees((List<GeneralSubtree>) in.content);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.467 -0500", hash_original_method = "2D1C7EBFAAEEE93820419C378A46DB40", hash_generated_method = "BF9B3282E73A8D0A88B679DE55F82D69")
        
@Override public Collection getValues(Object object) {
            GeneralSubtrees gss = (GeneralSubtrees) object;
            return (gss.generalSubtrees == null)
                    ? new ArrayList<GeneralSubtree>()
                    : gss.generalSubtrees;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.451 -0500", hash_original_field = "7578CFDDA1800C1F9139FA6424455B12", hash_generated_field = "C2874F586CC3974C74476D82AF1EF2DD")

    private List<GeneralSubtree> generalSubtrees;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.453 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.456 -0500", hash_original_method = "2635B7CAB7F4197126741D8B5E9A6725", hash_generated_method = "FF3ADF87E9A693DA60886EDB826D7DD3")
    
public GeneralSubtrees(List<GeneralSubtree> generalSubtrees) {
        // TODO: the size should not be less than one
        this.generalSubtrees = generalSubtrees;
    }

    /**
     * Returns the list of values of subtrees.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.458 -0500", hash_original_method = "B39087273D015207EFED9684375F7A9C", hash_generated_method = "9A155A8E90EFDC0C080CCA536A562BAC")
    
public List<GeneralSubtree> getSubtrees() {
        return generalSubtrees;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 AlgorithmIdentifier value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.460 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}

