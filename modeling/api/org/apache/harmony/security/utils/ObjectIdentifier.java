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
* @author Alexander V. Esin, Stepan M. Mishura
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public final class ObjectIdentifier {

    /**
     * Validates ObjectIdentifier (OID).
     *
     * @param oid - oid as array of integers
     * @throws NullPointerException     - if oid is null
     * @throws IllegalArgumentException - if oid is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.706 -0500", hash_original_method = "8A03D4A0A8F771BBDCBB48C7AE384ACF", hash_generated_method = "2F7D3B508C8CE668C31890B26F7A3F6F")
    
public static void validateOid(int[] oid) {

        if (oid == null) {
            throw new NullPointerException("oid == null");
        }

        if (oid.length < 2) {
            throw new IllegalArgumentException("OID MUST have at least 2 subidentifiers");
        }

        if (oid[0] > 2) {
            throw new IllegalArgumentException("Valid values for first subidentifier are 0, 1 and 2");
        } else if (oid[0] != 2 && oid[1] > 39) {
            throw new IllegalArgumentException("If the first subidentifier has 0 or 1 value the second subidentifier value MUST be less than 40");
        }
    }

    /**
     * Returns hash code for array of integers
     *
     * @param oid - array of integers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.709 -0500", hash_original_method = "8BE7213CC6A7767AC7788E8FF7C56936", hash_generated_method = "FD56D70A7777268231EA506342543753")
    
public static int hashIntArray(int[] array) {
        int intHash = 0;
        for (int i = 0; i < array.length && i < 4; i++) {
            intHash += array[i] << (8 * i); //TODO what about to find better one?
        }
        return intHash & 0x7FFFFFFF; // only positive
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.671 -0500", hash_original_field = "82C0B35B7B0E7EF1298A50C60DFA28D7", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private  int[] oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.673 -0500", hash_original_field = "0E9CC8489A4FBB9FA510FC03CD2752A3", hash_generated_field = "D81A83B1820A06AF71E170062C4ECA79")

    private int hash = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.675 -0500", hash_original_field = "6834EE6A69F4CDD499ACBB7835C507E6", hash_generated_field = "B67A2A548CCCA3ABBCDCF1E77441B37F")

    private String soid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.677 -0500", hash_original_field = "93634CE7983F931A535C1EFB096B2C4D", hash_generated_field = "84B9B965B3055F61D4D95D618DA2A1D9")

    private String sOID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.679 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.681 -0500", hash_original_field = "5D82297537D7B27BDF32D691C05D97FA", hash_generated_field = "20B5DD71DC465C0DFA3301CB14EE7FDD")

    private Object group;

    /**
     * Creates ObjectIdentifier(OID) from array of integers.
     *
     * @param oid - array of integers
     * @return - OID object
     * @throws NullPointerException     - if oid is null
     * @throws IllegalArgumentException - if oid is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.684 -0500", hash_original_method = "7ABF15BC63C3D8D706564084308C24AA", hash_generated_method = "8B63F8B806AFB677E63BCABBAD3CA2D8")
    
public ObjectIdentifier(int[] oid) {

        validateOid(oid);

        this.oid = oid;
    }

    /**
     * Creates ObjectIdentifier(OID) from array of integers.
     *
     * @param oid - array of integers
     * @param name - name of OID
     * @param oidGroup - OID's group. Is used to separate different OID's
     * @return - OID object
     * @throws NullPointerException     - if oid is null
     * @throws IllegalArgumentException - if oid is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.687 -0500", hash_original_method = "383F734F3FE5E01DEDB78CACC2759E14", hash_generated_method = "9FE5C18693AF5CF70CDD3301E85F968D")
    
public ObjectIdentifier(int[] oid, String name, Object oidGroup) {
        this(oid);

        if (oidGroup == null) {
            throw new NullPointerException("oidGroup == null");
        }
        this.group = oidGroup;

        this.name = name;
        toOIDString(); // init soid & sOID
    }

    /**
     * Gets OID.
     *
     * @return oid
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.689 -0500", hash_original_method = "30E83D32FBE8DF043D06124E9715286A", hash_generated_method = "8A71FF49FA15C11307B74CA6B18B0ECC")
    
public int[] getOid() {
        return oid;
    }

    /**
     * Gets OID's name.
     *
     * @return name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.692 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Gets OID's group.
     *
     * @return group
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.694 -0500", hash_original_method = "FA340579AD853DABC65F97F27C820CE8", hash_generated_method = "84E594EDE61A2569C84F479C2E3C43BC")
    
public Object getGroup() {
        return group;
    }

    /**
     * Compares object with OID for equality.
     *
     * @return true if object is ObjectIdentifier and it has the same
     *         representation as array of integers, otherwise false
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.696 -0500", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "DBC701613AB8121F89BA676B9E7A66A0")
    
public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return Arrays.equals(oid, ((ObjectIdentifier) o).oid);
    }

    /**
     * Add "OID." to the beginning of string representation.
     *
     * @return oid as string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.698 -0500", hash_original_method = "81F5AC8E69E1A1CBA984F8550D6AF5BD", hash_generated_method = "359C401138D8DF0D69F0B5325E55616C")
    
public String toOIDString() {
        if (sOID == null) {
            sOID = "OID." + toString();
        }
        return sOID;
    }

    /**
     * Overrides Object.toString()
     *
     * @return oid as string
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.701 -0500", hash_original_method = "B22823BCA8FD058C901A741025BA8FB1", hash_generated_method = "92EC2B489D0BE6DE5617D9029E2D7E07")
    
public String toString() {
        if (soid == null) {
            StringBuilder sb = new StringBuilder(4 * oid.length);

            for (int i = 0; i < oid.length - 1; ++i) {
                sb.append(oid[i]);
                sb.append('.');
            }
            sb.append(oid[oid.length - 1]);
            soid = sb.toString();
        }
        return soid;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.703 -0500", hash_original_method = "F5FB24607FBDCD1263609B3FEECCC6D5", hash_generated_method = "D5B8416537B382FD8670A89654FE3AB2")
    
public int hashCode() {
        if (hash == -1) {
            hash = hashIntArray(oid);
        }
        return hash;
    }
    
}

