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

public interface Map<K,V> {
    
    public static interface Entry<K,V> {
        
        public boolean equals(Object object);
        
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public K getKey();
        
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public V getValue();
        
        public int hashCode();
        
        public V setValue(V object);
    };
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean containsKey(Object key);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean containsValue(Object value);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Set<Map.Entry<K,V>> entrySet();
    
    public boolean equals(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public V get(Object key);
    
    public int hashCode();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Set<K> keySet();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public V put(K key, V value);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public void putAll(Map<? extends K,? extends V> map);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public V remove(Object key);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Collection<V> values();
}
