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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    protected transient int modCount;
	
    private int pos = -1; // Was package
    private int expectedModCount;   // Was package
    private int lastPosition = -1;   // Was package
	
    @DSModeled(DSC.SAFE)
	protected AbstractList() {
    }
	
    @Override
        public void clear() {
        removeRange(0, size());
    }
	
    public E set(int location, E object) {
        throw new UnsupportedOperationException();
    }
	
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
	
    public ListIterator<E> listIterator(int location) {
        return listIterator(0);
    }
	
    protected void removeRange(int start, int end) {
        Iterator<?> it = listIterator(start);
        for (int i = start; i < end; i++) {
            it.next();
            it.remove();
        }
    }
	
    @DSModeled(DSC.SAFE)
	public List<E> subList(int start, int end) {
        return new ArrayList();
    }
	
    public int indexOf(Object object) {
        ListIterator<?> it = listIterator();
        if (object != null) {
            while (it.hasNext()) {
                if (object.equals(it.next())) {
                    return it.previousIndex();
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return it.previousIndex();
                }
            }
        }
        return -1;
    }
	
    public int lastIndexOf(Object object) {
        ListIterator<?> it = listIterator(size());
        if (object != null) {
            while (it.hasPrevious()) {
                if (object.equals(it.previous())) {
                    return it.nextIndex();
                }
            }
        } else {
            while (it.hasPrevious()) {
                if (it.previous() == null) {
                    return it.nextIndex();
                }
            }
        }
        return -1;
    }
	
    public boolean addAll(int location, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            add(location++, it.next());
        }
        return !collection.isEmpty();
    }
	
    @DSModeled(DSC.SAFE)
	public boolean add(E object) {
        addTaint(object.getTaint());
        return getTaintBoolean();
    }
	
    @DSModeled(DSC.SAFE)
	public void add(int location, E object) {
        throw new UnsupportedOperationException();
    }
    
    @DSModeled(DSC.SAFE)
	public Iterator<E> iterator() {
        /* FIXME: this should be reimplemented so that it uses SimpleListIterator. */
        Object obj = new Object();
        obj.addTaint(getTaint());
        return (Iterator<E>)obj;
     }
	
    @DSModeled(DSC.SAFE)
	public E remove(int location) {
        throw new UnsupportedOperationException();
    }
    // ---------------- Inner Classes --------------------

}
