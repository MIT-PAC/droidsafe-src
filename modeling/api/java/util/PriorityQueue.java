/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A PriorityQueue holds elements on a priority heap, which orders the elements
 * according to their natural order or according to the comparator specified at
 * construction time. If the queue uses natural ordering, only elements that are
 * comparable are permitted to be inserted into the queue.
 * <p>
 * The least element of the specified ordering is the first retrieved with
 * {@link #poll()} and the greatest element is the last.
 * <p>
 * A PriorityQueue is not synchronized. If multiple threads will have to access
 * it concurrently, use the {@link java.util.concurrent.PriorityBlockingQueue}.
 */
public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.256 -0400", hash_original_field = "C0505051CB4AF87D4D0B5E3B5D00F481", hash_generated_field = "6ED9460F7E864D123E91629C31FC972F")

    private static final long serialVersionUID = -7720805057305804111L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.256 -0400", hash_original_field = "0AA68DF9541775CC38D5BA0045D2CD51", hash_generated_field = "BCEA1D95B9B50E0A58555DB49184C7B7")

    private static final int DEFAULT_CAPACITY = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.257 -0400", hash_original_field = "2ED392F7E0CACAFE2E295C909D1C2D83", hash_generated_field = "B4498717B3B173B14E1D93EC7A27ECD2")

    private static final double DEFAULT_INIT_CAPACITY_RATIO = 1.1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.257 -0400", hash_original_field = "29809995778CB7C1598602D1BECE6D34", hash_generated_field = "406B4BAD8512687AA764242F2E961671")

    private static final int DEFAULT_CAPACITY_RATIO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.258 -0400", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.258 -0400", hash_original_field = "8A6D4A83EE849067F115B399ECC3CAB1", hash_generated_field = "0E313AD6D66C4F0B00F12D6B16E96047")

    private Comparator<? super E> comparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.258 -0400", hash_original_field = "FB10D604B5E15C042369D34E470EFDCF", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;

    /**
     * Constructs a priority queue with an initial capacity of 11 and natural
     * ordering.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.259 -0400", hash_original_method = "58E13E76C10508B840C89750DBA2F694", hash_generated_method = "130A5B6E47822D08977C6D5311FCEB4E")
    
public PriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a priority queue with the specified capacity and natural
     * ordering.
     *
     * @param initialCapacity
     *            the specified capacity.
     * @throws IllegalArgumentException
     *             if the initialCapacity is less than 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.259 -0400", hash_original_method = "911F14A3F7F22EFA3B185959CB78D2B3", hash_generated_method = "A0609E5877C66A204139C3D4F1E21A11")
    
public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    /**
     * Constructs a priority queue with the specified capacity and comparator.
     *
     * @param initialCapacity
     *            the specified capacity.
     * @param comparator
     *            the specified comparator. If it is null, the natural ordering
     *            will be used.
     * @throws IllegalArgumentException
     *             if the initialCapacity is less than 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.259 -0400", hash_original_method = "ED4FF9FF056952A274F56A12F7DFED33", hash_generated_method = "7BBB6519E109483C139357277A6925C9")
    
public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("initialCapacity < 1: " + initialCapacity);
        }
        elements = newElementArray(initialCapacity);
        this.comparator = comparator;
    }

    /**
     * Constructs a priority queue that contains the elements of a collection.
     * The constructed priority queue has the initial capacity of 110% of the
     * size of the collection. The queue uses natural ordering to order its
     * elements.
     *
     * @param c
     *            the collection whose elements will be added to the priority
     *            queue to be constructed.
     * @throws ClassCastException
     *             if any of the elements in the collection are not comparable.
     * @throws NullPointerException
     *             if any of the elements in the collection are null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.260 -0400", hash_original_method = "C29AE678CCE898A5EAC5F93683C50E53", hash_generated_method = "246A16E42283A6F4E2576D311979E793")
    
public PriorityQueue(Collection<? extends E> c) {
        if (c instanceof PriorityQueue) {
            getFromPriorityQueue((PriorityQueue<? extends E>) c);
        } else if (c instanceof SortedSet) {
            getFromSortedSet((SortedSet<? extends E>) c);
        } else {
            initSize(c);
            addAll(c);
        }
    }

    /**
     * Constructs a priority queue that contains the elements of another
     * priority queue. The constructed priority queue has the initial capacity
     * of 110% of the specified one. Both priority queues have the same
     * comparator.
     *
     * @param c
     *            the priority queue whose elements will be added to the
     *            priority queue to be constructed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.260 -0400", hash_original_method = "DE95FDD082B572F7824AA76C4D6C59F3", hash_generated_method = "CAAF121C4D18B79BC883EE1541D5BF95")
    
public PriorityQueue(PriorityQueue<? extends E> c) {
        getFromPriorityQueue(c);
    }

    /**
     * Constructs a priority queue that contains the elements of a sorted set.
     * The constructed priority queue has the initial capacity of 110% of the
     * size of the sorted set. The priority queue will have the same comparator
     * as the sorted set.
     *
     * @param c
     *            the sorted set whose elements will be added to the priority
     *            queue to be constructed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.261 -0400", hash_original_method = "2B1757BB83768A507629744C75B61CCF", hash_generated_method = "809F87E71C146CA59AD758D8D6626C52")
    
public PriorityQueue(SortedSet<? extends E> c) {
        getFromSortedSet(c);
    }

    /**
     * Gets the iterator of the priority queue, which will not return elements
     * in any specified ordering.
     *
     * @return the iterator of the priority queue.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.261 -0400", hash_original_method = "29E42406182AF866EF1235165AD5E16B", hash_generated_method = "76BEFB22B5B643507DF59704E807DC6D")
    
@Override
    public Iterator<E> iterator() {
        return new PriorityIterator();
    }

    /**
     * Gets the size of the priority queue. If the size of the queue is greater
     * than the Integer.MAX, then it returns Integer.MAX.
     *
     * @return the size of the priority queue.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.262 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1B1551AD543164CCE8ABE887F4733D99")
    
@Override
    public int size() {
        return size;
    }

    /**
     * Removes all the elements of the priority queue.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.262 -0400", hash_original_method = "B6F04CCC5A967411777D1204AE8409FD", hash_generated_method = "B0D015CB3EFF6E3C666C56C09DE25494")
    
@Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    /**
     * Inserts the element to the priority queue.
     *
     * @param o
     *            the element to add to the priority queue.
     * @return always true
     * @throws ClassCastException
     *             if the element cannot be compared with the elements in the
     *             priority queue using the ordering of the priority queue.
     * @throws NullPointerException
     *             if {@code o} is {@code null}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.263 -0400", hash_original_method = "69BCB75C298B3958E4BBBB9CEEF789D4", hash_generated_method = "82CD08FCC775B8E80097AADB10CADF7B")
    
public boolean offer(E o) {
        if (o == null) {
            throw new NullPointerException("o == null");
        }
        growToSize(size + 1);
        elements[size] = o;
        siftUp(size++);
        return true;
    }

    /**
     * Gets and removes the head of the queue.
     *
     * @return the head of the queue or null if the queue is empty.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.264 -0400", hash_original_method = "A38C03A45CA3873EDA3CC27F4EA1E154", hash_generated_method = "5550CB025B19BB6CAE3B6DEDECB45746")
    
public E poll() {
        if (isEmpty()) {
            return null;
        }
        E result = elements[0];
        removeAt(0);
        return result;
    }

    /**
     * Gets but does not remove the head of the queue.
     *
     * @return the head of the queue or null if the queue is empty.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.264 -0400", hash_original_method = "E20ADCFD9D589330A90956929B5E43AA", hash_generated_method = "85EAB1802F1E02890842596320011877")
    
public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[0];
    }

    /**
     * Gets the comparator of the priority queue.
     *
     * @return the comparator of the priority queue or null if the natural
     *         ordering is used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.265 -0400", hash_original_method = "83ACC201A16F2FDDF97B6B07FFFB2168", hash_generated_method = "8947A54D644B196B7F9AE181D44586AE")
    
public Comparator<? super E> comparator() {
        return comparator;
    }

    /**
     * Removes the specified object from the priority queue.
     *
     * @param o
     *            the object to be removed.
     * @return true if the object was in the priority queue, false if the object
     *         was not in the priority queue.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.266 -0400", hash_original_method = "688475050D9EB13B173156735A8487EC", hash_generated_method = "F90EC3649C5AC8A1A6F2B99AB83215CB")
    
@Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
        for (int targetIndex = 0; targetIndex < size; targetIndex++) {
            if (o.equals(elements[targetIndex])) {
                removeAt(targetIndex);
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the specified object to the priority queue.
     *
     * @param o
     *            the object to be added.
     * @return always true.
     * @throws ClassCastException
     *             if the element cannot be compared with the elements in the
     *             priority queue using the ordering of the priority queue.
     * @throws NullPointerException
     *             if {@code o} is {@code null}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.266 -0400", hash_original_method = "B47D74753BC2900138E758F55799A6CE", hash_generated_method = "6AFB3137308F7AC6F6478F4022BD5090")
    
@Override
    public boolean add(E o) {
        return offer(o);
    }

    private class PriorityIterator implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.267 -0400", hash_original_field = "144936C3916E6D215B5611AC9E06D054", hash_generated_field = "930A7091E390C9A7E80CCAF83CF059FC")

        private int currentIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.267 -0400", hash_original_field = "6818254E023E7C64BE3DD521F7CD71AA", hash_generated_field = "46337D80FA4CAC78540F7C8D494816D7")

        private boolean allowRemove = false;

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.267 -0400", hash_original_method = "0FB46E9366D1118FDBE303EE479D4896", hash_generated_method = "1CF7CC7E962EEB3BFD463E0009EF5D8C")
        
public boolean hasNext() {
            return currentIndex < size - 1;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.268 -0400", hash_original_method = "23667DB5E37E55798D44E0D3057B4835", hash_generated_method = "7BBE240170C623E54ECE4879EA46535D")
        
public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            allowRemove = true;
            return elements[++currentIndex];
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.268 -0400", hash_original_method = "DB2903D95C50C28D70F9F205A7F7C8FE", hash_generated_method = "357EC057B9E5CB9E89A91130ABD6ECC8")
        
public void remove() {
            if (!allowRemove) {
                throw new IllegalStateException();
            }
            allowRemove = false;
            removeAt(currentIndex--);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.269 -0400", hash_original_method = "21BC9CFA0DCB43D7F88609A00A8387EA", hash_generated_method = "1E5DE6CEFA8D224A3B90129159C7F943")
    
@SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        elements = newElementArray(capacity);
        for (int i = 0; i < size; i++) {
            elements[i] = (E) in.readObject();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.270 -0400", hash_original_method = "AD595EBD68A8B9AE564B2F0FB242243F", hash_generated_method = "35224AFBB27134D61C2C03C2E3CFB9CD")
    
@SuppressWarnings("unchecked")
    private E[] newElementArray(int capacity) {
        return (E[]) new Object[capacity];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.270 -0400", hash_original_method = "B9F4F56172F737D7C7C85B3EBC28F8E6", hash_generated_method = "BAE6A29601E738AC1420C9B3991C8E1A")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(elements.length);
        for (int i = 0; i < size; i++) {
            out.writeObject(elements[i]);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.271 -0400", hash_original_method = "D14ABECCFCD1D91F89D634472CAA5A57", hash_generated_method = "F96609BCB6694BB23EB37B253FFA7B4B")
    
@SuppressWarnings("unchecked")
    private void getFromPriorityQueue(PriorityQueue<? extends E> c) {
        initSize(c);
        comparator = (Comparator<? super E>) c.comparator();
        System.arraycopy(c.elements, 0, elements, 0, c.size());
        size = c.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.271 -0400", hash_original_method = "4C352FE9F3E754E26A0F4A78FD0E430D", hash_generated_method = "AB9D8D3B4CA3AA116DBC775E4F426589")
    
@SuppressWarnings("unchecked")
    private void getFromSortedSet(SortedSet<? extends E> c) {
        initSize(c);
        comparator = (Comparator<? super E>) c.comparator();
        Iterator<? extends E> iter = c.iterator();
        while (iter.hasNext()) {
            elements[size++] = iter.next();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.272 -0400", hash_original_method = "75514930FE2128DC8F7C573995104279", hash_generated_method = "BD6F0AD05000E045B1C613BFD86964D8")
    
private void removeAt(int index) {
        size--;
        E moved = elements[size];
        elements[index] = moved;
        siftDown(index);
        elements[size] = null;
        if (moved == elements[index]) {
            siftUp(index);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.272 -0400", hash_original_method = "A0927ACC17EA40D5CE28A0E243882DFA", hash_generated_method = "62E34AC62BBED3E6B12F2BBEEA086807")
    
private int compare(E o1, E o2) {
        if (comparator != null) {
            return comparator.compare(o1, o2);
        }
        return ((Comparable<? super E>) o1).compareTo(o2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.273 -0400", hash_original_method = "800D9111DE2C548E56C8C7DBADDE1532", hash_generated_method = "03FA16D3BBF9ABE0875D44D06FF0408F")
    
private void siftUp(int childIndex) {
        E target = elements[childIndex];
        int parentIndex;
        while (childIndex > 0) {
            parentIndex = (childIndex - 1) / 2;
            E parent = elements[parentIndex];
            if (compare(parent, target) <= 0) {
                break;
            }
            elements[childIndex] = parent;
            childIndex = parentIndex;
        }
        elements[childIndex] = target;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.273 -0400", hash_original_method = "1734F3496FF56F66F4EE0A19F9B9DAC6", hash_generated_method = "F60669B535DD003CA96753BE0C274294")
    
private void siftDown(int rootIndex) {
        E target = elements[rootIndex];
        int childIndex;
        while ((childIndex = rootIndex * 2 + 1) < size) {
            if (childIndex + 1 < size
                    && compare(elements[childIndex + 1], elements[childIndex]) < 0) {
                childIndex++;
            }
            if (compare(target, elements[childIndex]) <= 0) {
                break;
            }
            elements[rootIndex] = elements[childIndex];
            rootIndex = childIndex;
        }
        elements[rootIndex] = target;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.274 -0400", hash_original_method = "6421CDDCB4ED28AE73207228DF9202CA", hash_generated_method = "C0639A91D1102F2212B70BDCE5AAC121")
    
private void initSize(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("c == null");
        }
        if (c.isEmpty()) {
            elements = newElementArray(1);
        } else {
            int capacity = (int) Math.ceil(c.size()
                    * DEFAULT_INIT_CAPACITY_RATIO);
            elements = newElementArray(capacity);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.275 -0400", hash_original_method = "69C661AD3CEEB8E6AEE784D427C4FE57", hash_generated_method = "A3FA20DB279D0C3D6B712B00240D95B3")
    
private void growToSize(int size) {
        if (size > elements.length) {
            E[] newElements = newElementArray(size * DEFAULT_CAPACITY_RATIO);
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
}
