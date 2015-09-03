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
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.281 -0500", hash_original_field = "D4754C466E323241A04755DA938EB9AF", hash_generated_field = "5F23BECC14072AFC76D2F21910086550")

    private static final long serialVersionUID = 876323262645176354L;
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.114 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "8DFD03108CDD2A33CB7D765F5A450A4F")
    public  LinkedList() {
    }

    /**
     * Constructs a new instance of {@code LinkedList} that holds all of the
     * elements contained in the specified {@code collection}. The order of the
     * elements in this new {@code LinkedList} will be determined by the
     * iteration order of {@code collection}.
     *
     * @param collection
     *            the collection of elements to add.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.370 -0500", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "99A0B50156378254E3DBEB1D97EE7EF1")
    
public LinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.121 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "5A556DD598DD4B7AE272E66D69A80C0F")
    public void addFirst(E object) {
        //addTaint(object.getTaint());
        addElementAt(0, object);
        // ---------- Original Method ----------
        //addFirstImpl(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.122 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "5E57D6CF03EA15D68138243087D069FE")
    public void addLast(E object) {
        //addTaint(object.getTaint());
        addElementAt(size()-1, object);
        // ---------- Original Method ----------
        //addLastImpl(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.124 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "2078156C30F179FF53C16F4B21073FEB")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        return this;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.126 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "82AD0E2AD0C962DA96A1294602E8A14B")
    public E getFirst() {
        E var47B6E8AF818F6390E3E49621F01F780F_453290605 =         getElementAt(0);
        //var47B6E8AF818F6390E3E49621F01F780F_453290605.addTaint(getTaint());
        return var47B6E8AF818F6390E3E49621F01F780F_453290605;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.126 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "879D570AE8E3EA434CCC92636D7DC4AE")
    public E getLast() {
        if (DroidSafeAndroidRuntime.control) {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1562898767 = new NoSuchElementException();
            //var28D00AB599969908D71F102AF992D49A_1562898767.addTaint(getTaint());
            throw var28D00AB599969908D71F102AF992D49A_1562898767;
        }

        E lastData = getElementAt(size() -1);
        //lastData.addTaint(getTaint());
        return lastData;

        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
        //return last.data;
        //}
        //throw new NoSuchElementException();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.127 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "14E184305C935AC7BA9BDA89C7D90C6F")
    @Override
    public int indexOf(Object object) {
        return getIndexOf(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.128 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "5E6174B4CB6EE24332958A2B07E85752")
    @Override
    public int lastIndexOf(Object object) {
        return getLastIndexOf(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.131 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "1E330664B0192718A87C4DDD29426DDB")
    public E removeFirst() {
        return removeFirstElement();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.132 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "F8BCF0B3E87B2775ED83E22680730DFF")
    public E removeLast() {
        return removeLastElement();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "5BFD32313DD750C7CA5760471E7BA36B")
    public Iterator<E> descendingIterator() {
        Iterator<E> iter = getReverseIterator();
        //iter.addTaint(getTaint());
        return iter;
        // ---------- Original Method ----------
        //return new ReverseLinkIterator<E>(this);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "78D7639AE5EBC21A98948F5640215680")
    public boolean offerFirst(E e) {
        //addTaint(e.getTaint());
        addFirstElement(e);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421322830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421322830;
        // ---------- Original Method ----------
        //return addFirstImpl(e);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "1E07379150837DD74ABC9481EE0631B5")
    public boolean offerLast(E e) {
        //addTaint(e.getTaint());
        addLastElement(e);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388533516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388533516;
        // ---------- Original Method ----------
        //return addLastImpl(e);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "22691D0470A83276A2325A7168F7857B")
    public E peekFirst() {
        E elem = getFirstElement();
        //elem.addTaint(getTaint());
        return elem;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "024A9E03091FFAC89C64A05EB8A81FCD")
    public E peekLast() {
        E elem = getLastElement();
        //elem.addTaint(getTaint());
        return elem;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //return (last == voidLink) ? null : last.data;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "1A057191B4C5100708D2FBE5065E8D57")
    public E pollFirst() {
        E elem = removeFirstElement();
        //elem.addTaint(getTaint());
        return elem;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeFirstImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "D8A7FF381D9EC211AEFBBB90A4CAA3B0")
    public E pollLast() {
        E elem = removeLastElement();
        //elem.addTaint(getTaint());
        return elem;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeLastImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "B11AB0C013FCB9A8E3C22E5318684A99")
    public E pop() {
        E elem = removeLastElement();
        return elem;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "8E3E5AB8C2EFDDF648D93DCEA06B9D05")
    public void push(E e) {
        //addTaint(e.getTaint());
        addLastElement(e);
        // ---------- Original Method ----------
        //addFirstImpl(e);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "6F4E8A748C546CBF7A9F3CDA57E3F37A")
    public boolean removeFirstOccurrence(Object o) {
        //addTaint(o.getTaint());
        int index = indexOf(o);
        if (index != -1) {
            removeElementAt(index);
            return true;
        }
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(o);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "732CCFFDB97E0915B522A631347B728D")
    public boolean removeLastOccurrence(Object o) {
        //addTaint(o.getTaint());
        int index = lastIndexOf(o);
        if (index != -1) {
            removeElementAt(index);
            return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.477 -0500", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "DDEABE8AC9FFECDA965CB2DE2681E456")
    
private boolean removeOneOccurrence(Object o, Iterator<E> iter) {
        while (iter.hasNext()) {
            E element = iter.next();
            if (o == null ? element == null : o.equals(element)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "DCC9F2A6A9C30329E761FE33538AF32F")
    public boolean offer(E o) {
        //addTaint(o.getTaint());
        addLastElement(o);
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(o);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "4F808C3914D5953ED32384E74C14C1ED")
    public E poll() {
        E elem = removeFirstElement();
        return elem;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "4D9B6E58041F68E73A123755B0BF1FA7")
    public E remove() {
        E elem = removeFirstElement();

        return elem;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "8BE067080E0634A1915D1ADE92056E6F")
    public E peek() {
        return peekFirst();
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "C5FBCDBEC4241ACA2F00E674FB83707A")
    public E element() {
        return peekFirst();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "15C731CFA7712C533369F8FFD15F051E")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(size());
        Iterator<E> it = iterator();
        while
            (it.hasNext())        
        {
            stream.writeObject(it.next());
        } //End block
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(size);
        //Iterator<E> it = iterator();
        //while (it.hasNext()) {
        //stream.writeObject(it.next());
        //}
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "581C710E4AAE3D3860B5F9D074085890")
    private void readObject(ObjectInputStream stream) throws IOException,
    ClassNotFoundException {
        stream.defaultReadObject();
        int size = stream.readInt();
        for(int i = size();--i >= 0;)
        {
            add((E) stream.readObject()); 
        } //End block

    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @Override
    
    public ListIterator<E> listIterator(int location) {
        // TODO Auto-generated method stub
        return getListIterator(location);
    }

}

