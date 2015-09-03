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
* @author Alexander V. Esin
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Comparator;

import org.apache.harmony.security.utils.ObjectIdentifier;

public class AttributeTypeAndValueComparator implements Comparator, Serializable {

    /**
     * compares two Object identifiers
     *
     * @param oid1
     *            first OID
     * @param oid2
     *            second OID
     * @return -1 of first OID "less" than second OID 1 otherwise, 0 if they are
     *         equal
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.273 -0500", hash_original_method = "B35DA3AB8471E98A0F9901B66FBBA5C9", hash_generated_method = "7557328DF4D4A138F8EF4FFB2D8845C4")
    
private static int compateOids(ObjectIdentifier oid1, ObjectIdentifier oid2) {
        if (oid1 == oid2) {
            return 0;
        }

        int[] ioid1 = oid1.getOid();
        int[] ioid2 = oid2.getOid();
        int min = ioid1.length < ioid2.length ? ioid1.length : ioid2.length;
        for (int i = 0; i < min; ++i) {
            if (ioid1[i] < ioid2[i]) {
                return -1;
            }
            if (ioid1[i] > ioid2[i]) {
                return 1;
            }
            if ((i + 1) == ioid1.length && (i + 1) < ioid2.length) {
                return -1;
            }
            if ((i + 1) < ioid1.length && (i + 1) == ioid2.length) {
                return 1;
            }
        }
        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.268 -0500", hash_original_field = "B4233DEB3183D4BBD895A0DA12ED5529", hash_generated_field = "D4ECDC5A87F7ADFE1C3A33CD3F11715D")

    private static final long serialVersionUID = -1286471842007103132L;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.531 -0400", hash_original_method = "A875CA77DCF86273FF83ADF73F0AA798", hash_generated_method = "A875CA77DCF86273FF83ADF73F0AA798")
    public AttributeTypeAndValueComparator ()
    {
        //Synthesized constructor
    }

    /**
     * compares two AttributeTypeAndValues
     *
     * @param obj1
     *            first AttributeTypeAndValue
     * @param obj2
     *            second AttributeTypeAndValue
     * @return -1 of first AttributeTypeAndValue "less" than second
     *         AttributeTypeAndValue 1 otherwise, 0 if they are equal
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.270 -0500", hash_original_method = "3F7D901C5D2A92F81B8BE7A716DA67AE", hash_generated_method = "FED4FBCEA05778094376463F7BBF91F1")
    
public int compare(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return 0;
        }

        AttributeTypeAndValue atav1 = (AttributeTypeAndValue) obj1;
        AttributeTypeAndValue atav2 = (AttributeTypeAndValue) obj2;
        String kw1 = atav1.getType().getName();
        String kw2 = atav2.getType().getName();
        if (kw1 != null && kw2 == null) {
            return -1;
        }
        if (kw1 == null && kw2 != null) {
            return 1;
        }
        if (kw1 != null && kw2 != null) {
            return kw1.compareTo(kw2);
        }

        return compateOids(atav1.getType(), atav2.getType());
    }
}

