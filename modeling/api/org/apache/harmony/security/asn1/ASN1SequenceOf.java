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
* @author Vladimir N. Molotkov, Stepan M. Mishura
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class ASN1SequenceOf extends ASN1ValueCollection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.235 -0500", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "28F0507C604F5C4BE98AE0CA1099D33F")
    
public ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.237 -0500", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "CF5C0F855DCE81C9078A88235FF086BB")
    
public Object decode(BerInputStream in) throws IOException {
        in.readSequenceOf(this);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.239 -0500", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "077A0FAA50EB2178BACD7C41ECD63043")
    
public final void encodeContent(BerOutputStream out) {
        out.encodeSequenceOf(this);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.242 -0500", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "202739F43D683D12F71DF173F0563480")
    
public final void setEncodingContent(BerOutputStream out) {
        out.getSequenceOfLength(this);
    }
    
}

