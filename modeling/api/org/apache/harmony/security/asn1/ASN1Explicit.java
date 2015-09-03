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

public final class ASN1Explicit extends ASN1Constructed {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.673 -0500", hash_original_field = "43976773C1CAD6B63CB025EEFB3E3545", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public  ASN1Type type;

    /**
     * Constructs explicitly tagged ASN.1 type
     * with context-specific tag class and specified tag number.
     *
     * @param tagNumber - ASN.1 tag number
     * @param type - ASN.1 type to be tagged
     * @throws IllegalArgumentException - if tagNumber is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.675 -0500", hash_original_method = "B0F7BA820AB1A580DEB9F8D4C1B1D195", hash_generated_method = "74CEF01EFCEB89A48790756BCFEDB2B2")
    
public ASN1Explicit(int tagNumber, ASN1Type type) {
        this(CLASS_CONTEXTSPECIFIC, tagNumber, type);
    }

    /**
     * Constructs explicitly tagged ASN.1 type.
     *
     * @param tagClass - ASN.1 tag class.
     * @param tagNumber - ASN.1 tag number
     * @param type - ASN.1 type to be tagged
     * @throws IllegalArgumentException - if tagClass or tagNumber is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.678 -0500", hash_original_method = "3F0FA66BFD46DABED8E86D16322A75CE", hash_generated_method = "701D86AC4DBB869E695FC393A13EE22A")
    
public ASN1Explicit(int tagClass, int tagNumber, ASN1Type type) {
        super(tagClass, tagNumber);
        this.type = type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.680 -0500", hash_original_method = "BF5194A9A90A1C345CA0C933EC20C89E", hash_generated_method = "20DB4555C096AC384567D24D9A7E06F0")
    
public Object decode(BerInputStream in) throws IOException {
        if (constrId != in.tag) {
            throw new ASN1Exception("ASN.1 explicitly tagged type is expected at [" +
                    in.tagOffset + "]. Expected tag: " + Integer.toHexString(constrId) + ", " +
                    "but encountered tag " + Integer.toHexString(in.tag));
        }
        in.next();

        in.content = type.decode(in);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.682 -0500", hash_original_method = "185B9650CC00F76A6008982D1539FA31", hash_generated_method = "889DD71F60A2F60CBE5A637C85F34DE2")
    
public void encodeContent(BerOutputStream out) {
        out.encodeExplicit(this);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.684 -0500", hash_original_method = "8EE64F8332C91721514C0E16F4A7E840", hash_generated_method = "4614AFC8BE55D7627A8EF1B4196E26CB")
    
public void setEncodingContent(BerOutputStream out) {
        out.getExplicitLength(this);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.687 -0500", hash_original_method = "8627A6334FE9B6784BD6CB87A9255671", hash_generated_method = "4A13F8FDE2FBA31C6A8C0A1F177EFB49")
    
@Override public String toString() {
        return super.toString() + " for type " + type;
    }
    
}

