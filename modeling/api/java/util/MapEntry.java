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


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.561 -0500", hash_original_field = "F780C5984CF24E477CB9559E91475987", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

    K key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.564 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

    V value;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.568 -0500", hash_original_method = "1776FA5E19E8D82B200F9151CF90A74A", hash_generated_method = "1776FA5E19E8D82B200F9151CF90A74A")
    
MapEntry(K theKey) {
        key = theKey;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.571 -0500", hash_original_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42", hash_generated_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42")
    
MapEntry(K theKey, V theValue) {
        key = theKey;
        value = theValue;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.573 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.576 -0500", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "905555CEA4EF740508EE8D4A3655FE25")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map.Entry) {
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            return (key == null ? entry.getKey() == null : key.equals(entry
                    .getKey()))
                    && (value == null ? entry.getValue() == null : value
                            .equals(entry.getValue()));
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.579 -0500", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "70BBB2F2B97930263570BF1F94F8248D")
    
public K getKey() {
        return key;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.581 -0500", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "95D4F56CA118DD7517C6CA2E4A00FE92")
    
public V getValue() {
        return value;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.584 -0500", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "5C9EDD5B771CD9A47AFF55CF54BFB883")
    
@Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.586 -0500", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "F9467D3B60D7F9589C17103B5B4486CB")
    
public V setValue(V object) {
        V result = value;
        value = object;
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.588 -0500", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "EDF37FB38FD11F88857163FA6E2BE31B")
    
@Override
    public String toString() {
        return key + "=" + value;
    }
    
    interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> entry);
    }
    
}

