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
import java.io.Serializable;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.288 -0500", hash_original_field = "A3A620E6BD10FB5E1B95C7C0FE237122", hash_generated_field = "9AC03C289FA70340AC8107CAE1966D0A")

    private static final long serialVersionUID = -2851667679971038690L;
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.760 -0400", hash_original_method = "FA64C9B63CE04BA03B3070651E56EFED", hash_generated_method = "B99E3A755713053C1BCF05A2186909D1")
    public  LinkedHashSet() {
        super();
        // ---------- Original Method ----------
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "D1E784926661CD719EF7E1152646271C", hash_generated_method = "402E1F209664C62953205E8A57DD538F")
    public  LinkedHashSet(int capacity) {
        super(capacity);
        // ---------- Original Method ----------
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "BE6AEEEAC74AB8DE439B6373179C0342", hash_generated_method = "C16BEE166C0FB5ACEED8506BB5C89691")
    public  LinkedHashSet(int capacity, float loadFactor) {
        super(capacity);
        // ---------- Original Method ----------
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.761 -0400", hash_original_method = "04F711D7424A0EA0A6EA304747ABA554", hash_generated_method = "8B59B2B9DCF36FC27AA99B0F9BADC9B8")
    public  LinkedHashSet(Collection<? extends E> collection) {
        super(collection);
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }
}

