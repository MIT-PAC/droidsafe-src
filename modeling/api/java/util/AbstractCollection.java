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

public abstract class AbstractCollection<E> implements Collection<E> {
    
    public static final int DEF_COLLECTION_SIZE = 16;
    
    protected E[] collectionData = (E[])new Object[DEF_COLLECTION_SIZE];
    
    protected int len = 0;
    
    protected int capacity = DEF_COLLECTION_SIZE;

    /**
     * Constructs a new instance of this AbstractCollection.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.257 -0500", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "B9D20D5CAAC3B1D2299D4DA211653336")
    
protected AbstractCollection() {
    }
    
    public void requestCapacity(int capacity) {
        if (capacity > this.capacity) {
            incrementCapacity(capacity - this.capacity);
        }
        addTaint(capacity);
    }
    
    protected void incrementCapacity(int additional) {
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.345 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "8275414EBF339E8E1A38339518310828")
    public boolean add(E object) {
        if (DroidSafeAndroidRuntime.control) {
            UnsupportedOperationException ex = new UnsupportedOperationException();
            throw ex;
        }

        collectionData[len++] = (E) object;
        addTaint(object.getTaint());

        return getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.346 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "3A9BC82846A9A65648AEDC64EA165A5D")
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        for (E item: collection) {
            add(item);
            addTaint(item.getTaint());
        }
        return getTaintBoolean();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.346 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "94B53645345716ACF0F00CE71C5A8EA8")
    public void clear() {
        for (int i = 0; i < len-1; i++) 
            collectionData[i] = null;  
        len = 0;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.347 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "AB29316BF38F2A7F7FF285294AD0586B")
    public boolean contains(Object object) {
        return getTaintBoolean();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.348 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "D9488CE0E9092353E75E56A47831CB4C")
    public boolean containsAll(Collection<?> collection) {
        return getTaintBoolean();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.348 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "8CE042654B5192EFCE000048B14B8C75")
    public boolean isEmpty() {
        if (len == 0)
            return true;
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    /**
     * Returns an instance of {@link Iterator} that may be used to access the
     * objects contained by this {@code Collection}. The order in which the elements are
     * returned by the {@link Iterator} is not defined unless the instance of the
     * {@code Collection} has a defined order.  In that case, the elements are returned in that order.
     * <p>
     * In this class this method is declared abstract and has to be implemented
     * by concrete {@code Collection} implementations.
     *
     * @return an iterator for accessing the {@code Collection} contents.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:55.278 -0500", hash_original_method = "38DA4AD00F2312AF1AD3CD50855F4F5F", hash_generated_method = "04D077BF385AFE862B82A3802F213294")
    
public abstract Iterator<E> iterator();
        
    @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.349 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "FCC356F1E2BB914CD3D0E5867CDC0F78")
    public boolean remove(Object object) {
        //addTaint(object.getTaint());
        int index = getIndexOf(object);
        if (index != -1)
            removeElementAt(index);
        return getTaintBoolean();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.351 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "F4694D15E6EF1ADFE917C25C5B193155")
    public boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        for (Object item: collection) {
            remove(item);
            addTaint(item.getTaint());
        }
        return getTaintBoolean();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.352 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "750649923756B11C00466003C8100284")
    public boolean retainAll(Collection<?> collection) {
        clear();
        for (Object item: collection) {
            add((E)item);
            addTaint(item.getTaint());
        }
        return getTaintBoolean();
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
    public int size() {
        return len;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.354 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "C6CD7F0B998F77F8945194CAF8E4BBFE")
    public Object[] toArray() {
        int size = size();
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = collectionData[i];
        }
        return array;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.356 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "97B4512438CD40845A961D9D17114AEE")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {

    //contents.addTaint(getTaint());

        int size = size();
        for (int i = 0; i < size; i++) {
            contents[i] = (T)collectionData[i];
        }

        return contents; 
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //if (size > contents.length) {
            //Class<?> ct = contents.getClass().getComponentType();
            //contents = (T[]) Array.newInstance(ct, size);
        //}
        //for (E entry : this) {
            //contents[index++] = (T) entry;
        //}
        //if (index < contents.length) {
            //contents[index] = null;
        //}
        //return contents;
    }

    /*************************************************************************
     * Additional Method facilitating subclass implementation/reuse
     *************************************************************************/
    
    protected E getElementAt(int index) {
        if (index >= len || index < 0) {
            IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            //ex.addTaint(getTaint());
            //ex.addTaint(index);
            throw ex; 
        }
        return collectionData[index];
    }
    
    protected void setElementAt(int index, E obj) {
        if (index >= len || index < 0) {
            IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            //ex.addTaint(getTaint());
            //ex.addTaint(index);
            //ex.addTaint(obj.getTaint());
            throw ex;
        }
        
        //addTaint(index);
        //addTaint(obj.getTaint());
        collectionData[index] = obj;
    }
    
    protected E removeElementAt(int index) {
        E retElem = getElementAt(index);
        for (int i = index; i < len-1; i++) {
            collectionData[i] = collectionData[i+1];
        }
        len -= 1;
        //retElem.addTaint(getTaint());
        return retElem;
    }
    
    protected boolean addElementAt(int index, E object) {
        //addTaint(index);
        //addTaint(object.getTaint());
        
        if (index > len) {
            IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            //ex.addTaint(getTaint());
            throw ex; 
        }

        for (int i = len; i > index ; i--) {
            collectionData[i] = collectionData[i-1];
        }
        collectionData[index] = object; 
        len++;
        return true;
    }
    
    protected int getIndexOf(Object object) {
        for (int i = 0; i < len; i++) {
            if (collectionData[i] == object)
                return i;
        }
        return -1;
    }
    
    protected int getIndexOf(Object object, int loc) {
        for (int i = loc; i < len; i++) {
            if (collectionData[i] == object)
                return i;
        }
        return -1;
    }
    
    protected int getLastIndexOf(Object object) {
        for (int i = len-1; i >= 0; i--) {
            if (collectionData[i] == object)
                return i;
        }
        return -1;
    }
    
    protected int getLastIndexOf(Object object, int loc) {
        for (int i = loc; i >= 0; i--) {
            if (collectionData[i] == object)
                return i;
        }
        return -1;
    }
    
    protected E getFirstElement(){
        //collectionData[0].addTaint(getTaint());
        return collectionData[0];
    }
    
    protected E getLastElement(){
        if (len > 0) {
            //collectionData[len-1].addTaint(getTaint());
            return collectionData[len-1];
        }
        return null;
    }
    
    protected void addFirstElement(E object){
        addElementAt(0, object);
    }
        
    protected void addLastElement(E object){
        addElementAt(size()-1, object);
    }
    
    protected E removeFirstElement(){
        if (size() > 0)
            return removeElementAt(0);
        return null;
    }
        
    protected E removeLastElement() {
        if (size() > 0)
            return removeElementAt(size()-1);
        return null;
    }
    
    protected boolean isEqualTo(Object collection) {
        if (collection instanceof AbstractCollection) {
            AbstractCollection<E> abstractCollect = (AbstractCollection<E>)collection;
            if (abstractCollect.len != len)
                return false;
            
            return (this.containsAll(abstractCollect));
        }
        return getTaintBoolean();
    }
    
    public Iterator<E>getIterator(){
        Iterator<E> iter = new BasicIterator<E>(); 
        //iter.addTaint(getTaint());
        return iter;
    }
    
    public Iterator<E>getReverseIterator(){
        Iterator<E> iter = new BasicReverseIterator<E>(); 
        //iter.addTaint(getTaint());
        return iter;
    }
    
    public ListIterator<E>getListIterator(int location){
        ListIterator<E> iter = new BasicIterator<E>(location); 
        //iter.addTaint(getTaint());
        return iter;
    }
     
    public Enumeration<E> getEnumeration(){
        Enumeration<E> retEnum = new BasicEnumeration<E>(); 
        //retEnum.addTaint(getTaint());
        return retEnum;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.357 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "22C4F41EBA3A6ACE287F6D60148ADCF8")
    @Override
    public String toString() {
        String retStr = new String();
        retStr.addTaint(getTaint());
        retStr.addTaint(collectionData[0].getTaint());
        return retStr;
    }
        
     /*************************************************************************
     * Iterator classes 
     *************************************************************************/
     private class BasicIterator<T> implements ListIterator<T> {     
        int start;
        int current; //current active index
        
        BasicIterator() {
            this(0);
        }
        
        BasicIterator(int location) {
            start = location;
            current = start - 1;
            //addTaint(location);
        }
        
        @Override
            @DSSafe(DSCat.SAFE_OTHERS)
        public boolean hasNext() {
            // TODO Auto-generated method stub
            //return (current < len -1);
            return getTaintBoolean();
        }

        @Override
            @DSSafe(DSCat.SAFE_OTHERS)
        public T next() {
            // TODO Auto-generated method stub
            return (T) collectionData[++current];
        }

        @Override
            @DSSafe(DSCat.DATA_STRUCTURE)
        public void remove() {
            // TODO Auto-generated method stub
            removeElementAt(current);
        }

        @Override
                    @DSSafe(DSCat.SAFE_LIST)
        public void add(Object object) {
            // TODO Auto-generated method stub
            //addElementAt(current, object);
            E tmpObj = (E)object;
            //addElementAt(current, tmpObj);
            addElementAt(current, tmpObj);
            //addTaint(object.getTaint());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            //return (current > start);
            return getTaintBoolean();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        
        public int nextIndex() {
            //return current + 1;
            return getTaintInt();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        
        public T previous() {
            // TODO Auto-generated method stub
            return (T) getElementAt(--current);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        
        public int previousIndex() {
            // TODO Auto-generated method stub
            //return (current - 1);
            return getTaintInt();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        
        public void set(T object) {
            // TODO Auto-generated method stub
            setElementAt(current, (E)object);
            //addTaint(object.getTaint());
        }
     }
     
     private class BasicReverseIterator<T> extends BasicIterator<T>{
        
         public BasicReverseIterator(){
             current = len;
             start = 0;
         }
         
         @DSSafe(DSCat.SAFE_OTHERS)
        @Override
        
         public boolean hasNext(){
             return super.hasPrevious();
         }
         
         @DSSafe(DSCat.SAFE_OTHERS)
        @Override
        
         public T next() {
             return super.previous();
         }
     }
     
     private class BasicEnumeration<T> extends BasicIterator<T> implements Enumeration<T> {
        
         public BasicEnumeration() {
             super();
         }
        @DSSafe(DSCat.SAFE_OTHERS)
        @Override
        
        public boolean hasMoreElements() {
            // TODO Auto-generated method stub
            return hasNext();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @Override
        
        public T nextElement() {
            // TODO Auto-generated method stub
            return next();
        }
     }
}

