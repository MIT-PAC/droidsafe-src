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
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.005 -0500", hash_original_field = "2F267CA136EFF023C15D428EECFA7FDB", hash_generated_field = "B688976E864DC479F82CA018B4928BF6")

    /*
     * We have "diamond" multiple interface/abstract class inheritance
     * here, and that introduces ambiguities. Often we want the
     * BlockingDeque javadoc combined with the AbstractQueue
     * implementation, so a lot of method specs are duplicated here.
     */

    private static final long serialVersionUID = -387911632671998426L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.020 -0500", hash_original_field = "B9D8A84E47F69091F85507218703CD58", hash_generated_field = "B953F2DA9AB6C212A9E3462BBC6D0DD3")

    transient Node<E> first;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.022 -0500", hash_original_field = "5BD668C51B6C07553DEA981067DC22EE", hash_generated_field = "68FEEFB065E74B1419C2CD65ECD35DDE")

    transient Node<E> last;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.024 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "FF3E1C3A7415684C56884C6A4B36275E")

    private transient int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.027 -0500", hash_original_field = "0B1D26332B4020647655E70C20DE6D8D", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private  int capacity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.029 -0500", hash_original_field = "1400DAF04929C6FE417E223B70E97891", hash_generated_field = "B0934DA6255E093761388B9A5B38B6D7")

    final ReentrantLock lock = new ReentrantLock();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.032 -0500", hash_original_field = "C144C4C100A3C73E703CB797DC9884A6", hash_generated_field = "9FD9379D1FC8CCF1865C665664A25E7F")

    private final Condition notEmpty = lock.newCondition();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.035 -0500", hash_original_field = "FCB3ECEC78A42C34E55B88293B032866", hash_generated_field = "19093F87C48F83B3E20DD52DF9B24BF6")

    private final Condition notFull = lock.newCondition();

    /**
     * Creates a {@code LinkedBlockingDeque} with a capacity of
     * {@link Integer#MAX_VALUE}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.037 -0500", hash_original_method = "249100E9D6D687E7D39D2C34E44C91A8", hash_generated_method = "0E969802D4C2AA199D566860C788FF9E")
    
public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    /**
     * Creates a {@code LinkedBlockingDeque} with the given (fixed) capacity.
     *
     * @param capacity the capacity of this deque
     * @throws IllegalArgumentException if {@code capacity} is less than 1
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.040 -0500", hash_original_method = "FF241F26E4F2B23472530DEBE913F0CA", hash_generated_method = "2C299096E74EE02CD5BE8283B05E283C")
    
public LinkedBlockingDeque(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
    }

    /**
     * Creates a {@code LinkedBlockingDeque} with a capacity of
     * {@link Integer#MAX_VALUE}, initially containing the elements of
     * the given collection, added in traversal order of the
     * collection's iterator.
     *
     * @param c the collection of elements to initially contain
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.043 -0500", hash_original_method = "439D82303085A1CC8269C4DDD811FDB3", hash_generated_method = "AA706706285A7231ABFE5B34332F902C")
    
public LinkedBlockingDeque(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        final ReentrantLock lock = this.lock;
        lock.lock(); // Never contended, but necessary for visibility
        try {
            for (E e : c) {
                if (e == null)
                    throw new NullPointerException();
                if (!linkLast(new Node<E>(e)))
                    throw new IllegalStateException("Deque full");
            }
        } finally {
            lock.unlock();
        }
    }

    // Basic linking and unlinking operations, called only while holding lock

    /**
     * Links node as first element, or returns false if full.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.046 -0500", hash_original_method = "F1FEA35FDC461C140B4532DA56C7987F", hash_generated_method = "748F31744C91A093895EAC0F6D92534E")
    
private boolean linkFirst(Node<E> node) {
        // assert lock.isHeldByCurrentThread();
        if (count >= capacity)
            return false;
        Node<E> f = first;
        node.next = f;
        first = node;
        if (last == null)
            last = node;
        else
            f.prev = node;
        ++count;
        notEmpty.signal();
        return true;
    }

    /**
     * Links node as last element, or returns false if full.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.048 -0500", hash_original_method = "A7FA4F0AF7ECA6F754653DE93F8ED423", hash_generated_method = "75EFD61F22AE3C167054A454B0EEE999")
    
private boolean linkLast(Node<E> node) {
        // assert lock.isHeldByCurrentThread();
        if (count >= capacity)
            return false;
        Node<E> l = last;
        node.prev = l;
        last = node;
        if (first == null)
            first = node;
        else
            l.next = node;
        ++count;
        notEmpty.signal();
        return true;
    }

    /**
     * Removes and returns first element, or null if empty.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.051 -0500", hash_original_method = "B7345027764D354450098F40DD004B57", hash_generated_method = "9CB1B92D0DE227C38E1040FC851A8E4C")
    
private E unlinkFirst() {
        // assert lock.isHeldByCurrentThread();
        Node<E> f = first;
        if (f == null)
            return null;
        Node<E> n = f.next;
        E item = f.item;
        f.item = null;
        f.next = f; // help GC
        first = n;
        if (n == null)
            last = null;
        else
            n.prev = null;
        --count;
        notFull.signal();
        return item;
    }

    /**
     * Removes and returns last element, or null if empty.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.053 -0500", hash_original_method = "AF190978DF5C122F110919244C9479F2", hash_generated_method = "10214E84CF113D9E05168FCBA12692D6")
    
private E unlinkLast() {
        // assert lock.isHeldByCurrentThread();
        Node<E> l = last;
        if (l == null)
            return null;
        Node<E> p = l.prev;
        E item = l.item;
        l.item = null;
        l.prev = l; // help GC
        last = p;
        if (p == null)
            first = null;
        else
            p.next = null;
        --count;
        notFull.signal();
        return item;
    }

    /**
     * Unlinks x.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.055 -0500", hash_original_method = "1D9FD16EE202C66D2F53FBE6A3602BA7", hash_generated_method = "CC2CE91AAC3AB88A9C4950E024D3368F")
    
void unlink(Node<E> x) {
        // assert lock.isHeldByCurrentThread();
        Node<E> p = x.prev;
        Node<E> n = x.next;
        if (p == null) {
            unlinkFirst();
        } else if (n == null) {
            unlinkLast();
        } else {
            p.next = n;
            n.prev = p;
            x.item = null;
            // Don't mess with x's links.  They may still be in use by
            // an iterator.
            --count;
            notFull.signal();
        }
    }

    // BlockingDeque methods

    /**
     * @throws IllegalStateException {@inheritDoc}
     * @throws NullPointerException  {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.057 -0500", hash_original_method = "E867E212B6967896682403DEE3888034", hash_generated_method = "A5B961A03BAECE29CD1E3A5D03DAA1A0")
    
public void addFirst(E e) {
        if (!offerFirst(e))
            throw new IllegalStateException("Deque full");
    }

    /**
     * @throws IllegalStateException {@inheritDoc}
     * @throws NullPointerException  {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.060 -0500", hash_original_method = "B487A5071408DAF9039EED205B0601B1", hash_generated_method = "4C4C1F0940817E06CFBEFFF2FF35036C")
    
public void addLast(E e) {
        if (!offerLast(e))
            throw new IllegalStateException("Deque full");
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.064 -0500", hash_original_method = "BE955938F466098B732744A4435FF66E", hash_generated_method = "D6F68B801FB816B15205900CA3F0C7EF")
    
public boolean offerFirst(E e) {
        if (e == null) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return linkFirst(node);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.066 -0500", hash_original_method = "1944181CAD6733F95AAB9BA74E74F57C", hash_generated_method = "314BDD0ACD07FE407DDA0212FF388726")
    
public boolean offerLast(E e) {
        if (e == null) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return linkLast(node);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @throws InterruptedException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.069 -0500", hash_original_method = "C2A955C9F8C1BE3FAF21A972EF83A87B", hash_generated_method = "5EDCE496C9A5B09A53D6486A1EA96C22")
    
public void putFirst(E e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (!linkFirst(node))
                notFull.await();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @throws InterruptedException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.071 -0500", hash_original_method = "90F899FEDAEBCF4E183EEEA72670B0D4", hash_generated_method = "F7A22B7C43CC13F62A2BEC4841DF5FC3")
    
public void putLast(E e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (!linkLast(node))
                notFull.await();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @throws InterruptedException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.074 -0500", hash_original_method = "14A0E8066E53E8F404179324D8A2A7E0", hash_generated_method = "F5124ED44D846506E7AE17DF1CDEEAFF")
    
public boolean offerFirst(E e, long timeout, TimeUnit unit)
        throws InterruptedException {
        if (e == null) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (!linkFirst(node)) {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @throws InterruptedException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.077 -0500", hash_original_method = "D6F2690B9DE8E1D2C78F1E640A084B19", hash_generated_method = "C8AE174DDEE10DE092972EC811061FF8")
    
public boolean offerLast(E e, long timeout, TimeUnit unit)
        throws InterruptedException {
        if (e == null) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (!linkLast(node)) {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.080 -0500", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "33889137BDA4646A9361CB9125B9A446")
    
public E removeFirst() {
        E x = pollFirst();
        if (x == null) throw new NoSuchElementException();
        return x;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.083 -0500", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "5994715E76E59F5586780093061EC479")
    
public E removeLast() {
        E x = pollLast();
        if (x == null) throw new NoSuchElementException();
        return x;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.085 -0500", hash_original_method = "4BCCC1BED6E23489D206E4138D3675FF", hash_generated_method = "8D2BAF0057FA830C85491EBB1535AD5E")
    
public E pollFirst() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return unlinkFirst();
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.087 -0500", hash_original_method = "D2B0F76144A8C0FD857C7F3A67B82206", hash_generated_method = "842534B2006AB751D28F4EE5FF5C92F4")
    
public E pollLast() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return unlinkLast();
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.089 -0500", hash_original_method = "AF3CDBD12E7133B877B3C968B0B44866", hash_generated_method = "27103BDF71571C59AE2BAB56309B0861")
    
public E takeFirst() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            E x;
            while ( (x = unlinkFirst()) == null)
                notEmpty.await();
            return x;
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.092 -0500", hash_original_method = "FB7D91E8092FFF58EBD05C4560E68DC5", hash_generated_method = "60C52DC39A766A17CE413D2DFA77D4C2")
    
public E takeLast() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            E x;
            while ( (x = unlinkLast()) == null)
                notEmpty.await();
            return x;
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.095 -0500", hash_original_method = "F9AABEF2F1BCB257250D3454F49A6E99", hash_generated_method = "1CC0AFBCCF92C7AAB621DAFC39001CB2")
    
public E pollFirst(long timeout, TimeUnit unit)
        throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            E x;
            while ( (x = unlinkFirst()) == null) {
                if (nanos <= 0)
                    return null;
                nanos = notEmpty.awaitNanos(nanos);
            }
            return x;
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.098 -0500", hash_original_method = "441DC167F175C62B6ECB09DED87CDC8D", hash_generated_method = "4665E55D8BBA7B8307712605C3A8D238")
    
public E pollLast(long timeout, TimeUnit unit)
        throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            E x;
            while ( (x = unlinkLast()) == null) {
                if (nanos <= 0)
                    return null;
                nanos = notEmpty.awaitNanos(nanos);
            }
            return x;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.101 -0500", hash_original_method = "F4DA2AE3D58549E0544F32F7ECC367F9", hash_generated_method = "26C5260C199D4EF0AFEA8B70E71D813F")
    
public E getFirst() {
        E x = peekFirst();
        if (x == null) throw new NoSuchElementException();
        return x;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.103 -0500", hash_original_method = "CA6BD988176C06418CE77F8F50D6B256", hash_generated_method = "95E0A3265E6F0C5703DBFAF6C0834A56")
    
public E getLast() {
        E x = peekLast();
        if (x == null) throw new NoSuchElementException();
        return x;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.105 -0500", hash_original_method = "61802C5E2F0A50DC70950560F84AD209", hash_generated_method = "28570317932A3A840B24E47D5FE09612")
    
public E peekFirst() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (first == null) ? null : first.item;
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.108 -0500", hash_original_method = "0A003440458459B8BB085FC2BE3ABB07", hash_generated_method = "F8CCEA90A0539ABEFFBDDB3A9B64A426")
    
public E peekLast() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (last == null) ? null : last.item;
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.111 -0500", hash_original_method = "73CE4C57004AC162E8700E668E08F7DA", hash_generated_method = "BC42A416F5118F66DD66A7F615811DC3")
    
public boolean removeFirstOccurrence(Object o) {
        if (o == null) return false;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> p = first; p != null; p = p.next) {
                if (o.equals(p.item)) {
                    unlink(p);
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.113 -0500", hash_original_method = "D957C1235A0ED720512232AF3579C614", hash_generated_method = "DD3959B5E4D6F09468BC99652AA75A33")
    
public boolean removeLastOccurrence(Object o) {
        if (o == null) return false;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> p = last; p != null; p = p.prev) {
                if (o.equals(p.item)) {
                    unlink(p);
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    // BlockingQueue methods

    /**
     * Inserts the specified element at the end of this deque unless it would
     * violate capacity restrictions.  When using a capacity-restricted deque,
     * it is generally preferable to use method {@link #offer offer}.
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.116 -0500", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "358E992871DB0DF233264CEDEE0FBEF3")
    
public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.118 -0500", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "326965DBCAC0F913D90C3A41623502D9")
    
public boolean offer(E e) {
        return offerLast(e);
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @throws InterruptedException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.121 -0500", hash_original_method = "091B896CDB22071FD0356886E4E18520", hash_generated_method = "B0E7AA872AD45CE71D83168E578BD322")
    
public void put(E e) throws InterruptedException {
        putLast(e);
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @throws InterruptedException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.123 -0500", hash_original_method = "04D6F44E140F1E68CFC8217F9A649648", hash_generated_method = "AF982E7A70CB003BC4EC4BBF68C98B64")
    
public boolean offer(E e, long timeout, TimeUnit unit)
        throws InterruptedException {
        return offerLast(e, timeout, unit);
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque.
     * This method differs from {@link #poll poll} only in that it throws an
     * exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #removeFirst() removeFirst}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.125 -0500", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "E7EA57F8F5A1DC7F659D2407501F5651")
    
public E remove() {
        return removeFirst();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.127 -0500", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "D92F2CAF590F842165119B6D24004B40")
    
public E poll() {
        return pollFirst();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.129 -0500", hash_original_method = "71C603C063999AE26BDD685834231EF7", hash_generated_method = "0FE7E536C364116106ECDC7054EE0455")
    
public E take() throws InterruptedException {
        return takeFirst();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.132 -0500", hash_original_method = "1736A91E2A3C93B5CBB10674E58366F8", hash_generated_method = "B474389BD206F5ED8BABF06430DB614A")
    
public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return pollFirst(timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque.  This method differs from {@link #peek peek} only in that
     * it throws an exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #getFirst() getFirst}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.134 -0500", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "BC6239B4A9B6D00FE072E062B112C82B")
    
public E element() {
        return getFirst();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.137 -0500", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "C49BD63C2CFF13F7E18F5863A21DF3DB")
    
public E peek() {
        return peekFirst();
    }

    /**
     * Returns the number of additional elements that this deque can ideally
     * (in the absence of memory or resource constraints) accept without
     * blocking. This is always equal to the initial capacity of this deque
     * less the current {@code size} of this deque.
     *
     * <p>Note that you <em>cannot</em> always tell if an attempt to insert
     * an element will succeed by inspecting {@code remainingCapacity}
     * because it may be the case that another thread is about to
     * insert or remove an element.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.140 -0500", hash_original_method = "04FC8DBE8B6CF08AC1A142B1DC50B6B4", hash_generated_method = "ADC75641DE4C1F6424AB29B050FD72A1")
    
public int remainingCapacity() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return capacity - count;
        } finally {
            lock.unlock();
        }
    }

    /**
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.142 -0500", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "EB9FFDC2CB18F728010F3227114BF0A5")
    
public int drainTo(Collection<? super E> c) {
        return drainTo(c, Integer.MAX_VALUE);
    }

    /**
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.145 -0500", hash_original_method = "8D6DC3C307065A1D2B18F15D4F19D5EE", hash_generated_method = "9268A420D3D32995A8128B64C11657A1")
    
public int drainTo(Collection<? super E> c, int maxElements) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n = Math.min(maxElements, count);
            for (int i = 0; i < n; i++) {
                c.add(first.item);   // In this order, in case add() throws.
                unlinkFirst();
            }
            return n;
        } finally {
            lock.unlock();
        }
    }

    // Stack methods

    /**
     * @throws IllegalStateException {@inheritDoc}
     * @throws NullPointerException  {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.148 -0500", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "57FDC65A59ACBA2985AC790990989FF0")
    
public void push(E e) {
        addFirst(e);
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.150 -0500", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "58A444C456B794DA9A4C54CC4CC88A2E")
    
public E pop() {
        return removeFirst();
    }

    // Collection methods

    /**
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element {@code e} such that
     * {@code o.equals(e)} (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * <p>This method is equivalent to
     * {@link #removeFirstOccurrence(Object) removeFirstOccurrence}.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if this deque changed as a result of the call
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.152 -0500", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "67436633CF4F0B184E774FE8B1646BF7")
    
public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.155 -0500", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "1C306A20DEB9E71EFEE80C2F18DCAEC3")
    
public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns {@code true} if this deque contains the specified element.
     * More formally, returns {@code true} if and only if this deque contains
     * at least one element {@code e} such that {@code o.equals(e)}.
     *
     * @param o object to be checked for containment in this deque
     * @return {@code true} if this deque contains the specified element
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.157 -0500", hash_original_method = "682A3652CE664466B96C29E268D51A9E", hash_generated_method = "392EC44614A3AE02652F6EE3B08B5A0A")
    
public boolean contains(Object o) {
        if (o == null) return false;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> p = first; p != null; p = p.next)
                if (o.equals(p.item))
                    return true;
            return false;
        } finally {
            lock.unlock();
        }
    }

    /*
     * TODO: Add support for more efficient bulk operations.
     *
     * We don't want to acquire the lock for every iteration, but we
     * also want other threads a chance to interact with the
     * collection, especially when count is close to capacity.
     */

//     /**
//      * Adds all of the elements in the specified collection to this
//      * queue.  Attempts to addAll of a queue to itself result in
//      * {@code IllegalArgumentException}. Further, the behavior of
//      * this operation is undefined if the specified collection is
//      * modified while the operation is in progress.
//      *
//      * @param c collection containing elements to be added to this queue
//      * @return {@code true} if this queue changed as a result of the call
//      * @throws ClassCastException            {@inheritDoc}
//      * @throws NullPointerException          {@inheritDoc}
//      * @throws IllegalArgumentException      {@inheritDoc}
//      * @throws IllegalStateException         {@inheritDoc}
//      * @see #add(Object)
//      */
//     public boolean addAll(Collection<? extends E> c) {
//         if (c == null)
//             throw new NullPointerException();
//         if (c == this)
//             throw new IllegalArgumentException();
//         final ReentrantLock lock = this.lock;
//         lock.lock();
//         try {
//             boolean modified = false;
//             for (E e : c)
//                 if (linkLast(e))
//                     modified = true;
//             return modified;
//         } finally {
//             lock.unlock();
//         }
//     }

    /**
     * Returns an array containing all of the elements in this deque, in
     * proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this deque.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this deque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.160 -0500", hash_original_method = "6060745C6F54AC5BF252877A9090AD60", hash_generated_method = "5F4F0488E9D7A3249598C912129C1993")
    
@SuppressWarnings("unchecked")
    public Object[] toArray() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] a = new Object[count];
            int k = 0;
            for (Node<E> p = first; p != null; p = p.next)
                a[k++] = p.item;
            return a;
        } finally {
            lock.unlock();
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.949 -0400", hash_original_method = "ED2A1A13D07CD52AFD81A3297D99D370", hash_generated_method = "8A8E855B9D909F40908C749AED694946")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            if(a.length < count)            
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), count);
            int k = 0;
for(Node<E> p = first;p != null;p = p.next)
            a[k++] = (T)p.item;
            if(a.length > k)            
            a[k] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_2033373084 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_2033373084.addTaint(getTaint());
            return var3F5343BF1D849954A73F0BB303805FFD_2033373084;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //if (a.length < count)
                //a = (T[])java.lang.reflect.Array.newInstance
                    //(a.getClass().getComponentType(), count);
            //int k = 0;
            //for (Node<E> p = first; p != null; p = p.next)
                //a[k++] = (T)p.item;
            //if (a.length > k)
                //a[k] = null;
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.165 -0500", hash_original_method = "C6BF4E291CC9ACD611C7F11D96A47702", hash_generated_method = "8F431A71EC021A4B14A2D0A9F5FFB08E")
    
public String toString() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Node<E> p = first;
            if (p == null)
                return "[]";

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (;;) {
                E e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                if (p == null)
                    return sb.append(']').toString();
                sb.append(',').append(' ');
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Atomically removes all of the elements from this deque.
     * The deque will be empty after this call returns.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.168 -0500", hash_original_method = "1459F438368C53F5F75C3D780C8B3096", hash_generated_method = "2921FF04F91299FAC45A1A77B41CA313")
    
public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> f = first; f != null; ) {
                f.item = null;
                Node<E> n = f.next;
                f.prev = null;
                f.next = null;
                f = n;
            }
            first = last = null;
            count = 0;
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * <p>The returned iterator is a "weakly consistent" iterator that
     * will never throw {@link java.util.ConcurrentModificationException
     * ConcurrentModificationException}, and guarantees to traverse
     * elements as they existed upon construction of the iterator, and
     * may (but is not guaranteed to) reflect any modifications
     * subsequent to construction.
     *
     * @return an iterator over the elements in this deque in proper sequence
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.170 -0500", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "B0FB44010E28764F5FA2B4AB0E8E15C1")
    
public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * Returns an iterator over the elements in this deque in reverse
     * sequential order.  The elements will be returned in order from
     * last (tail) to first (head).
     *
     * <p>The returned iterator is a "weakly consistent" iterator that
     * will never throw {@link java.util.ConcurrentModificationException
     * ConcurrentModificationException}, and guarantees to traverse
     * elements as they existed upon construction of the iterator, and
     * may (but is not guaranteed to) reflect any modifications
     * subsequent to construction.
     *
     * @return an iterator over the elements in this deque in reverse order
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.172 -0500", hash_original_method = "E2FFEA86BDF1CF0D788CD9C05CB28749", hash_generated_method = "D7F10C1829A3BC2581C201228B7412A7")
    
public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    /**
     * Save the state of this deque to a stream (that is, serialize it).
     *
     * @serialData The capacity (int), followed by elements (each an
     * {@code Object}) in the proper order, followed by a null
     * @param s the stream
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.220 -0500", hash_original_method = "00D32B8E76B917A114B33777EC6C582C", hash_generated_method = "D37C8B8A4A81CD31EFF033469750104F")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            // Write out capacity and any hidden stuff
            s.defaultWriteObject();
            // Write out all elements in the proper order.
            for (Node<E> p = first; p != null; p = p.next)
                s.writeObject(p.item);
            // Use trailing null as sentinel
            s.writeObject(null);
        } finally {
            lock.unlock();
        }
    }
    
    static final class Node<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.008 -0500", hash_original_field = "25C1B4BE35B7528A52E74D8E56CE9F0B", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.011 -0500", hash_original_field = "7FBB8703B6D1E4FD63D7312AF905F1D0", hash_generated_field = "7FBB8703B6D1E4FD63D7312AF905F1D0")

        Node<E> prev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.013 -0500", hash_original_field = "A089DAAEF049057EDB97CA1342EE38E4", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.016 -0500", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "E24CFB813CF8D6D3545154C1747D57F8")
        
Node(E x) {
            item = x;
        }
        
    }
    
    private abstract class AbstractItr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.175 -0500", hash_original_field = "A089DAAEF049057EDB97CA1342EE38E4", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

         Node<E> next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.177 -0500", hash_original_field = "FC047D97EB4DD102072D6594B14B8B33", hash_generated_field = "FC047D97EB4DD102072D6594B14B8B33")

        E nextItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.181 -0500", hash_original_field = "93698314F06F14B80EF688D146BA679D", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.189 -0500", hash_original_method = "D7A0B463A5093578F0D94B98618BF3C0", hash_generated_method = "28BBB2CA01DA3BB5FD5A053E1EBA2D22")
        
AbstractItr() {
            // set to initial position
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try {
                next = firstNode();
                nextItem = (next == null) ? null : next.item;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.183 -0500", hash_original_method = "E80ED2AE4D6E0A197DA3D2FEF15A6B49", hash_generated_method = "534DF80273D935AE6925FBD6EF7AC00B")
        
abstract Node<E> firstNode();
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.186 -0500", hash_original_method = "9F717E7E725E26B6BCD476E32AAC180D", hash_generated_method = "62DE858066BE8A3D50921CEF31ADA99C")
        
abstract Node<E> nextNode(Node<E> n);

        /**
         * Returns the successor node of the given non-null, but
         * possibly previously deleted, node.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.191 -0500", hash_original_method = "D73368529643E6DA5D3CCB05A337F2C2", hash_generated_method = "06AA28CB6A50D76CE6352D10A6F03C05")
        
private Node<E> succ(Node<E> n) {
            // Chains of deleted nodes ending in null or self-links
            // are possible if multiple interior nodes are removed.
            for (;;) {
                Node<E> s = nextNode(n);
                if (s == null)
                    return null;
                else if (s.item != null)
                    return s;
                else if (s == n)
                    return firstNode();
                else
                    n = s;
            }
        }

        /**
         * Advances next.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.194 -0500", hash_original_method = "2DD616E77FD4CF0B4B36F4DDA6D06963", hash_generated_method = "49FEE913965804786FBC2DCF58B6212C")
        
void advance() {
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try {
                // assert next != null;
                next = succ(next);
                nextItem = (next == null) ? null : next.item;
            } finally {
                lock.unlock();
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.197 -0500", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "D9921E6F8BA4DD3AB60D42D0725CBAC4")
        
public boolean hasNext() {
            return next != null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.199 -0500", hash_original_method = "A893921D404CCDA66FADBF0BB5913A0B", hash_generated_method = "19288D8FBFED98522523829809ED1040")
        
public E next() {
            if (next == null)
                throw new NoSuchElementException();
            lastRet = next;
            E x = nextItem;
            advance();
            return x;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.202 -0500", hash_original_method = "91F393F6D6922E17D234B4F4A87152D4", hash_generated_method = "5CAF7685D60076EA66500E59D3657FC8")
        
public void remove() {
            Node<E> n = lastRet;
            if (n == null)
                throw new IllegalStateException();
            lastRet = null;
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try {
                if (n.item != null)
                    unlink(n);
            } finally {
                lock.unlock();
            }
        }
        
    }
    
    private class Itr extends AbstractItr {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.014 -0400", hash_original_method = "2FF8F1B9AF2988B00A6C7863D292475A", hash_generated_method = "2FF8F1B9AF2988B00A6C7863D292475A")
        public Itr ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.207 -0500", hash_original_method = "F5496DA38BC198471A9339E337F6A141", hash_generated_method = "F5496DA38BC198471A9339E337F6A141")
        
Node<E> firstNode() { return first; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.209 -0500", hash_original_method = "7337A72D0DFE873C08C820C315C83AB4", hash_generated_method = "7337A72D0DFE873C08C820C315C83AB4")
        
Node<E> nextNode(Node<E> n) { return n.next; }
        
    }
    
    private class DescendingItr extends AbstractItr {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.023 -0400", hash_original_method = "0432E36D4F5ED7D39A08DA6620AAF627", hash_generated_method = "0432E36D4F5ED7D39A08DA6620AAF627")
        public DescendingItr ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.214 -0500", hash_original_method = "935F8554484A3F626F85F03E205FB5CA", hash_generated_method = "935F8554484A3F626F85F03E205FB5CA")
        
Node<E> firstNode() { return last; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.216 -0500", hash_original_method = "A98E9809BC87B643D4F952FCC7CB50C4", hash_generated_method = "A98E9809BC87B643D4F952FCC7CB50C4")
        
Node<E> nextNode(Node<E> n) { return n.prev; }
        
    }

    /**
     * Reconstitute this deque from a stream (that is,
     * deserialize it).
     * @param s the stream
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:17.223 -0500", hash_original_method = "56ED7CDA4A1F5E7C2D4B953EF10E899A", hash_generated_method = "02C1F3C489D84081DDFE53C794CEF665")
    
private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        count = 0;
        first = null;
        last = null;
        // Read in all elements and place in queue
        for (;;) {
            @SuppressWarnings("unchecked")
            E item = (E)s.readObject();
            if (item == null)
                break;
            add(item);
        }
    }
}

