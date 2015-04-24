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

import java.lang.reflect.Array;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractCollection<E> implements Collection<E> {
	
	@DSModeled(DSC.SAFE)
	protected AbstractCollection() {
    }
	
	public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                result = true;
            }
        }
        return result;
	}
	
	public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                result = true;
            }
        }
        return result;
    }
	
	public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }
	
	public boolean remove(Object object) {
        Iterator<?> it = iterator();
        if (object != null) {
            while (it.hasNext()) {
                if (object.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }
	
	public Object[] toArray() {
        int size = size(), index = 0;
        Iterator<?> it = iterator();
        Object[] array = new Object[size];
        while (index < size) {
            array[index++] = it.next();
        }
        return array;
    }
	
	@SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        int size = size(), index = 0;
        if (size > contents.length) {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        }
        for (E entry : this) {
            contents[index++] = (T) entry;
        }
        if (index < contents.length) {
            contents[index] = null;
        }
        return contents;
    }
	
	public boolean isEmpty() {
        return size() == 0;
    }
	
	@Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != this) {
                buffer.append(next);
            } else {
                buffer.append("(this Collection)");
            }
            if (it.hasNext()) {
                buffer.append(", ");
            }
        }
        buffer.append(']');
        return buffer.toString();
    }
	
	public boolean contains(Object object) {
        Iterator<E> it = iterator();
        if (object != null) {
            while (it.hasNext()) {
                if (object.equals(it.next())) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public boolean addAll(Collection<? extends E> collection) {
        boolean result = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            if (add(it.next())) {
                result = true;
            }
        }
        return result;
    }
    
	public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
	
	public boolean add(E object) {
        throw new UnsupportedOperationException();
    }
	
	public abstract Iterator<E> iterator();
	public abstract int size();
}
