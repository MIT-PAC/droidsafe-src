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
 * Written by Doug Lea and Martin Buchholz with assistance from members of
 * JCP JSR-166 Expert Group and released to the public domain, as explained
 * at http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


/*
 * Written by Doug Lea and Martin Buchholz with assistance from members of
 * JCP JSR-166 Expert Group and released to the public domain, as explained
 * at http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

// BEGIN android-note
// removed link to collections framework docs
// END android-note

/**
 * An unbounded concurrent {@linkplain Deque deque} based on linked nodes.
 * Concurrent insertion, removal, and access operations execute safely
 * across multiple threads.
 * A {@code ConcurrentLinkedDeque} is an appropriate choice when
 * many threads will share access to a common collection.
 * Like most other concurrent collection implementations, this class
 * does not permit the use of {@code null} elements.
 *
 * <p>Iterators are <i>weakly consistent</i>, returning elements
 * reflecting the state of the deque at some point at or since the
 * creation of the iterator.  They do <em>not</em> throw {@link
 * java.util.ConcurrentModificationException
 * ConcurrentModificationException}, and may proceed concurrently with
 * other operations.
 *
 * <p>Beware that, unlike in most collections, the {@code size} method
 * is <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these deques, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * concurrently with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterator implement all of the <em>optional</em>
 * methods of the {@link Deque} and {@link Iterator} interfaces.
 *
 * <p>Memory consistency effects: As with other concurrent collections,
 * actions in a thread prior to placing an object into a
 * {@code ConcurrentLinkedDeque}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code ConcurrentLinkedDeque} in another thread.
 *
 * @hide
 *
 * @since 1.7
 * @author Doug Lea
 * @author Martin Buchholz
 * @param <E> the type of elements held in this collection
 */
public class ConcurrentLinkedDeque<E>
    extends AbstractCollection<E>
    implements Deque<E>, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.984 -0400", hash_original_field = "D4754C466E323241A04755DA938EB9AF", hash_generated_field = "5F23BECC14072AFC76D2F21910086550")

    private static final long serialVersionUID = 876323262645176354L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.986 -0400", hash_original_field = "8D7FC8569190133A5B78DA5CA08B0A86", hash_generated_field = "A3CDEE7D4EFB61C1D7E5ACE1E53951AA")

    private static  Node<Object> PREV_TERMINATOR, NEXT_TERMINATOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.995 -0400", hash_original_field = "387B9E0FE8FF78244918DB1453F12C82", hash_generated_field = "CD9F62AAEF9CDAE92791F9B9FF131299")

    private static final int HOPS = 2;

    // Minor convenience utilities

    /**
     * Throws NullPointerException if argument is null.
     *
     * @param v the element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.003 -0400", hash_original_method = "BBA8F566F6EBBAE4E624DE5E2288492A", hash_generated_method = "5E8CAC32EF86836AAB409F83647A3C3E")
    
private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.028 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

    private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.029 -0400", hash_original_field = "3706253715619D88D23853C13B9CE0EE", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static  long headOffset;

    static final class Node<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.991 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

        private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.991 -0400", hash_original_field = "06C8F0D8DBE6F0658533D6562E958514", hash_generated_field = "5E317D3F462324E05850BA092BD3C721")

        private static  long prevOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.992 -0400", hash_original_field = "45136B470DA210012D0F0A8256A63486", hash_generated_field = "E48E252FA32E9E911DB7C7CDABFD5883")

        private static  long itemOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.992 -0400", hash_original_field = "3EFA6AE93B76F6C9D723C832889F59D2", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

        private static  long nextOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.987 -0400", hash_original_field = "7FBB8703B6D1E4FD63D7312AF905F1D0", hash_generated_field = "B9B9D5F6B71C6AD4AF1846738AE3EC63")

        volatile Node<E> prev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.987 -0400", hash_original_field = "25C1B4BE35B7528A52E74D8E56CE9F0B", hash_generated_field = "10095ABA73A923383E44F968C6C62945")

        volatile E item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.988 -0400", hash_original_field = "A089DAAEF049057EDB97CA1342EE38E4", hash_generated_field = "7BB4D15B501C737F5EC180DC75EDF910")

        volatile Node<E> next;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.988 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "C4C417D22E28A6EC0ED5CEEBFE02C5A7")
        
Node() {  // default constructor for NEXT_TERMINATOR, PREV_TERMINATOR
        }

        /**
         * Constructs a new node.  Uses relaxed write because item can
         * only be seen after publication via casNext or casPrev.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.988 -0400", hash_original_method = "368F2FAFC4A206C09EED76798A5342BA", hash_generated_method = "368F2FAFC4A206C09EED76798A5342BA")
        
Node(E item) {
            UNSAFE.putObject(this, itemOffset, item);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.989 -0400", hash_original_method = "51A0AA76262E736F2E39BE7CE12CF006", hash_generated_method = "51A0AA76262E736F2E39BE7CE12CF006")
        
boolean casItem(E cmp, E val) {
            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.990 -0400", hash_original_method = "E78DBD679DC5F596F67B7449AE69FAB3", hash_generated_method = "E78DBD679DC5F596F67B7449AE69FAB3")
        
void lazySetNext(Node<E> val) {
            UNSAFE.putOrderedObject(this, nextOffset, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.990 -0400", hash_original_method = "C86D1E5E3D7752CB8E68445595A8E8EC", hash_generated_method = "C86D1E5E3D7752CB8E68445595A8E8EC")
        
boolean casNext(Node<E> cmp, Node<E> val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.990 -0400", hash_original_method = "0BC7BEC179382E78B0478940B6D7E911", hash_generated_method = "0BC7BEC179382E78B0478940B6D7E911")
        
void lazySetPrev(Node<E> val) {
            UNSAFE.putOrderedObject(this, prevOffset, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.991 -0400", hash_original_method = "625EDDE740B0C4BEF5B91F06AE811994", hash_generated_method = "625EDDE740B0C4BEF5B91F06AE811994")
        
boolean casPrev(Node<E> cmp, Node<E> val) {
            return UNSAFE.compareAndSwapObject(this, prevOffset, cmp, val);
        }

        static {
            try {
                UNSAFE = sun.misc.Unsafe.getUnsafe();
                Class<?> k = Node.class;
                prevOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("prev"));
                itemOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.029 -0400", hash_original_field = "4A1CAF0399870C61B250285BB267C733", hash_generated_field = "8B58E2B37A159AAD83A5260C2F388DB2")

    private static  long tailOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.985 -0400", hash_original_field = "AF17874DDDE4597EF645F8BFBDDE5272", hash_generated_field = "B57EDCA0C5D8B188A31356A19160405D")

    private transient volatile Node<E> head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.985 -0400", hash_original_field = "A5E4BAC07874F33303440A161800C0F9", hash_generated_field = "44C1E7DD6E43696E7B1931FD10B83ECF")

    private transient volatile Node<E> tail;

    /**
     * Constructs an empty deque.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.005 -0400", hash_original_method = "DEDD0C6C7565B137149E5F0D58B5EB46", hash_generated_method = "62E4FBB700A8E810595F3DF554670253")
    
public ConcurrentLinkedDeque() {
        head = tail = new Node<E>(null);
    }

    /**
     * Constructs a deque initially containing the elements of
     * the given collection, added in traversal order of the
     * collection's iterator.
     *
     * @param c the collection of elements to initially contain
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.005 -0400", hash_original_method = "91DF8174DD2C6BB933DB9B0AC81E306D", hash_generated_method = "328C70A1B95519C9CCB5A99FCFC359BE")
    
public ConcurrentLinkedDeque(Collection<? extends E> c) {
        // Copy c into a private chain of Nodes
        Node<E> h = null, t = null;
        for (E e : c) {
            checkNotNull(e);
            Node<E> newNode = new Node<E>(e);
            if (h == null)
                h = t = newNode;
            else {
                t.lazySetNext(newNode);
                newNode.lazySetPrev(t);
                t = newNode;
            }
        }
        initHeadTail(h, t);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.986 -0400", hash_original_method = "7F228359741FC0060E83DC41681551F7", hash_generated_method = "3A7E1C89C012FA9D8365916009E35085")
    
@SuppressWarnings("unchecked")
    Node<E> prevTerminator() {
        return (Node<E>) PREV_TERMINATOR;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.987 -0400", hash_original_method = "6DBFEE54918BCB44A0F382A0215CFDAE", hash_generated_method = "1731DAA06AFA70173B03329DF76F496D")
    
@SuppressWarnings("unchecked")
    Node<E> nextTerminator() {
        return (Node<E>) NEXT_TERMINATOR;
    }

    /**
     * Links e as first element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.994 -0400", hash_original_method = "8D84314157A631460F368DD40B866932", hash_generated_method = "293531EA9B0A91DA33022D7978A9A1F1")
    
private void linkFirst(E e) {
        checkNotNull(e);
        final Node<E> newNode = new Node<E>(e);

        restartFromHead:
        for (;;)
            for (Node<E> h = head, p = h, q;;) {
                if ((q = p.prev) != null &&
                    (q = (p = q).prev) != null)
                    // Check for head updates every other hop.
                    // If p == q, we are sure to follow head instead.
                    p = (h != (h = head)) ? h : q;
                else if (p.next == p) // PREV_TERMINATOR
                    continue restartFromHead;
                else {
                    // p is first node
                    newNode.lazySetNext(p); // CAS piggyback
                    if (p.casPrev(null, newNode)) {
                        // Successful CAS is the linearization point
                        // for e to become an element of this deque,
                        // and for newNode to become "live".
                        if (p != h) // hop two nodes at a time
                            casHead(h, newNode);  // Failure is OK.
                        return;
                    }
                    // Lost CAS race to another thread; re-read prev
                }
            }
    }

    /**
     * Links e as last element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.994 -0400", hash_original_method = "DFC9FD6B74B8DCA7B662E1E3A6C4D0DE", hash_generated_method = "B04CCA0B4FD45EF411344467AB01D0D4")
    
private void linkLast(E e) {
        checkNotNull(e);
        final Node<E> newNode = new Node<E>(e);

        restartFromTail:
        for (;;)
            for (Node<E> t = tail, p = t, q;;) {
                if ((q = p.next) != null &&
                    (q = (p = q).next) != null)
                    // Check for tail updates every other hop.
                    // If p == q, we are sure to follow tail instead.
                    p = (t != (t = tail)) ? t : q;
                else if (p.prev == p) // NEXT_TERMINATOR
                    continue restartFromTail;
                else {
                    // p is last node
                    newNode.lazySetPrev(p); // CAS piggyback
                    if (p.casNext(null, newNode)) {
                        // Successful CAS is the linearization point
                        // for e to become an element of this deque,
                        // and for newNode to become "live".
                        if (p != t) // hop two nodes at a time
                            casTail(t, newNode);  // Failure is OK.
                        return;
                    }
                    // Lost CAS race to another thread; re-read next
                }
            }
    }

    /**
     * Unlinks non-null node x.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.996 -0400", hash_original_method = "22DA4086466D86F51E565AC07FB7988C", hash_generated_method = "E7E0A579E82051B8CBFBC12C6C276F0D")
    
void unlink(Node<E> x) {
        // assert x != null;
        // assert x.item == null;
        // assert x != PREV_TERMINATOR;
        // assert x != NEXT_TERMINATOR;

        final Node<E> prev = x.prev;
        final Node<E> next = x.next;
        if (prev == null) {
            unlinkFirst(x, next);
        } else if (next == null) {
            unlinkLast(x, prev);
        } else {
            // Unlink interior node.
            //
            // This is the common case, since a series of polls at the
            // same end will be "interior" removes, except perhaps for
            // the first one, since end nodes cannot be unlinked.
            //
            // At any time, all active nodes are mutually reachable by
            // following a sequence of either next or prev pointers.
            //
            // Our strategy is to find the unique active predecessor
            // and successor of x.  Try to fix up their links so that
            // they point to each other, leaving x unreachable from
            // active nodes.  If successful, and if x has no live
            // predecessor/successor, we additionally try to gc-unlink,
            // leaving active nodes unreachable from x, by rechecking
            // that the status of predecessor and successor are
            // unchanged and ensuring that x is not reachable from
            // tail/head, before setting x's prev/next links to their
            // logical approximate replacements, self/TERMINATOR.
            Node<E> activePred, activeSucc;
            boolean isFirst, isLast;
            int hops = 1;

            // Find active predecessor
            for (Node<E> p = prev; ; ++hops) {
                if (p.item != null) {
                    activePred = p;
                    isFirst = false;
                    break;
                }
                Node<E> q = p.prev;
                if (q == null) {
                    if (p.next == p)
                        return;
                    activePred = p;
                    isFirst = true;
                    break;
                }
                else if (p == q)
                    return;
                else
                    p = q;
            }

            // Find active successor
            for (Node<E> p = next; ; ++hops) {
                if (p.item != null) {
                    activeSucc = p;
                    isLast = false;
                    break;
                }
                Node<E> q = p.next;
                if (q == null) {
                    if (p.prev == p)
                        return;
                    activeSucc = p;
                    isLast = true;
                    break;
                }
                else if (p == q)
                    return;
                else
                    p = q;
            }

            // TODO: better HOP heuristics
            if (hops < HOPS
                // always squeeze out interior deleted nodes
                && (isFirst | isLast))
                return;

            // Squeeze out deleted nodes between activePred and
            // activeSucc, including x.
            skipDeletedSuccessors(activePred);
            skipDeletedPredecessors(activeSucc);

            // Try to gc-unlink, if possible
            if ((isFirst | isLast) &&

                // Recheck expected state of predecessor and successor
                (activePred.next == activeSucc) &&
                (activeSucc.prev == activePred) &&
                (isFirst ? activePred.prev == null : activePred.item != null) &&
                (isLast  ? activeSucc.next == null : activeSucc.item != null)) {

                updateHead(); // Ensure x is not reachable from head
                updateTail(); // Ensure x is not reachable from tail

                // Finally, actually gc-unlink
                x.lazySetPrev(isFirst ? prevTerminator() : x);
                x.lazySetNext(isLast  ? nextTerminator() : x);
            }
        }
    }

    /**
     * Unlinks non-null first node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.997 -0400", hash_original_method = "EAD526F780415386ECECED0C78F7204B", hash_generated_method = "42B2C0FCD0F0BD9B1D97EC4BEBB8C595")
    
private void unlinkFirst(Node<E> first, Node<E> next) {
        // assert first != null;
        // assert next != null;
        // assert first.item == null;
        for (Node<E> o = null, p = next, q;;) {
            if (p.item != null || (q = p.next) == null) {
                if (o != null && p.prev != p && first.casNext(next, p)) {
                    skipDeletedPredecessors(p);
                    if (first.prev == null &&
                        (p.next == null || p.item != null) &&
                        p.prev == first) {

                        updateHead(); // Ensure o is not reachable from head
                        updateTail(); // Ensure o is not reachable from tail

                        // Finally, actually gc-unlink
                        o.lazySetNext(o);
                        o.lazySetPrev(prevTerminator());
                    }
                }
                return;
            }
            else if (p == q)
                return;
            else {
                o = p;
                p = q;
            }
        }
    }

    /**
     * Unlinks non-null last node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.998 -0400", hash_original_method = "CA0AE63D3F048CA263BB61F82A4F5B31", hash_generated_method = "09600F9429F15819887EA0896F28765E")
    
private void unlinkLast(Node<E> last, Node<E> prev) {
        // assert last != null;
        // assert prev != null;
        // assert last.item == null;
        for (Node<E> o = null, p = prev, q;;) {
            if (p.item != null || (q = p.prev) == null) {
                if (o != null && p.next != p && last.casPrev(prev, p)) {
                    skipDeletedSuccessors(p);
                    if (last.next == null &&
                        (p.prev == null || p.item != null) &&
                        p.next == last) {

                        updateHead(); // Ensure o is not reachable from head
                        updateTail(); // Ensure o is not reachable from tail

                        // Finally, actually gc-unlink
                        o.lazySetPrev(o);
                        o.lazySetNext(nextTerminator());
                    }
                }
                return;
            }
            else if (p == q)
                return;
            else {
                o = p;
                p = q;
            }
        }
    }

    /**
     * Guarantees that any node which was unlinked before a call to
     * this method will be unreachable from head after it returns.
     * Does not guarantee to eliminate slack, only that head will
     * point to a node that was active while this method was running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.998 -0400", hash_original_method = "1714F350BAE3E105B129A44C76461EE6", hash_generated_method = "617D935AB49301D88FA89EC46BADF312")
    
private final void updateHead() {
        // Either head already points to an active node, or we keep
        // trying to cas it to the first node until it does.
        Node<E> h, p, q;
        restartFromHead:
        while ((h = head).item == null && (p = h.prev) != null) {
            for (;;) {
                if ((q = p.prev) == null ||
                    (q = (p = q).prev) == null) {
                    // It is possible that p is PREV_TERMINATOR,
                    // but if so, the CAS is guaranteed to fail.
                    if (casHead(h, p))
                        return;
                    else
                        continue restartFromHead;
                }
                else if (h != head)
                    continue restartFromHead;
                else
                    p = q;
            }
        }
    }

    /**
     * Guarantees that any node which was unlinked before a call to
     * this method will be unreachable from tail after it returns.
     * Does not guarantee to eliminate slack, only that tail will
     * point to a node that was active while this method was running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.999 -0400", hash_original_method = "61464717B75D5B61C3A9CAAAA727A09A", hash_generated_method = "49F011E5357DD93565ACD5675090F12B")
    
private final void updateTail() {
        // Either tail already points to an active node, or we keep
        // trying to cas it to the last node until it does.
        Node<E> t, p, q;
        restartFromTail:
        while ((t = tail).item == null && (p = t.next) != null) {
            for (;;) {
                if ((q = p.next) == null ||
                    (q = (p = q).next) == null) {
                    // It is possible that p is NEXT_TERMINATOR,
                    // but if so, the CAS is guaranteed to fail.
                    if (casTail(t, p))
                        return;
                    else
                        continue restartFromTail;
                }
                else if (t != tail)
                    continue restartFromTail;
                else
                    p = q;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.000 -0400", hash_original_method = "BCF0173B33A863F010801DC070A9750E", hash_generated_method = "2065B298FC4E7C28F46FD5D038A3D7A0")
    
private void skipDeletedPredecessors(Node<E> x) {
        whileActive:
        do {
            Node<E> prev = x.prev;
            // assert prev != null;
            // assert x != NEXT_TERMINATOR;
            // assert x != PREV_TERMINATOR;
            Node<E> p = prev;
            findActive:
            for (;;) {
                if (p.item != null)
                    break findActive;
                Node<E> q = p.prev;
                if (q == null) {
                    if (p.next == p)
                        continue whileActive;
                    break findActive;
                }
                else if (p == q)
                    continue whileActive;
                else
                    p = q;
            }

            // found active CAS target
            if (prev == p || x.casPrev(prev, p))
                return;

        } while (x.item != null || x.next == null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.000 -0400", hash_original_method = "2C5024A4C440DC49A7B14B2366C674A7", hash_generated_method = "1060C93B89169483D8625BE9B0E683FD")
    
private void skipDeletedSuccessors(Node<E> x) {
        whileActive:
        do {
            Node<E> next = x.next;
            // assert next != null;
            // assert x != NEXT_TERMINATOR;
            // assert x != PREV_TERMINATOR;
            Node<E> p = next;
            findActive:
            for (;;) {
                if (p.item != null)
                    break findActive;
                Node<E> q = p.next;
                if (q == null) {
                    if (p.prev == p)
                        continue whileActive;
                    break findActive;
                }
                else if (p == q)
                    continue whileActive;
                else
                    p = q;
            }

            // found active CAS target
            if (next == p || x.casNext(next, p))
                return;

        } while (x.item != null || x.prev == null);
    }

    /**
     * Returns the successor of p, or the first node if p.next has been
     * linked to self, which will only be true if traversing with a
     * stale pointer that is now off the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.001 -0400", hash_original_method = "FE72300658586217977B23801529634D", hash_generated_method = "25324A912DB1C187DCA0E4ED332B5B5C")
    
final Node<E> succ(Node<E> p) {
        // TODO: should we skip deleted nodes here?
        Node<E> q = p.next;
        return (p == q) ? first() : q;
    }

    /**
     * Returns the predecessor of p, or the last node if p.prev has been
     * linked to self, which will only be true if traversing with a
     * stale pointer that is now off the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.001 -0400", hash_original_method = "8B3E03F06FB06DCE43C8D5C2160E32B7", hash_generated_method = "71AD55870950E0CDBF1F54D89EFF42B2")
    
final Node<E> pred(Node<E> p) {
        Node<E> q = p.prev;
        return (p == q) ? last() : q;
    }

    /**
     * Returns the first node, the unique node p for which:
     *     p.prev == null && p.next != p
     * The returned node may or may not be logically deleted.
     * Guarantees that head is set to the returned node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.002 -0400", hash_original_method = "6542785C7EA714E21372BDD523FE5461", hash_generated_method = "8455C7F9C923CD856E9FB404136092ED")
    
Node<E> first() {
        restartFromHead:
        for (;;)
            for (Node<E> h = head, p = h, q;;) {
                if ((q = p.prev) != null &&
                    (q = (p = q).prev) != null)
                    // Check for head updates every other hop.
                    // If p == q, we are sure to follow head instead.
                    p = (h != (h = head)) ? h : q;
                else if (p == h
                         // It is possible that p is PREV_TERMINATOR,
                         // but if so, the CAS is guaranteed to fail.
                         || casHead(h, p))
                    return p;
                else
                    continue restartFromHead;
            }
    }

    /**
     * Returns the last node, the unique node p for which:
     *     p.next == null && p.prev != p
     * The returned node may or may not be logically deleted.
     * Guarantees that tail is set to the returned node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.002 -0400", hash_original_method = "2683014636FCF194E6A18BB349D1DBD5", hash_generated_method = "D40E94A261D5CFCFF5691EFFD7B9499B")
    
Node<E> last() {
        restartFromTail:
        for (;;)
            for (Node<E> t = tail, p = t, q;;) {
                if ((q = p.next) != null &&
                    (q = (p = q).next) != null)
                    // Check for tail updates every other hop.
                    // If p == q, we are sure to follow tail instead.
                    p = (t != (t = tail)) ? t : q;
                else if (p == t
                         // It is possible that p is NEXT_TERMINATOR,
                         // but if so, the CAS is guaranteed to fail.
                         || casTail(t, p))
                    return p;
                else
                    continue restartFromTail;
            }
    }

    /**
     * Returns element unless it is null, in which case throws
     * NoSuchElementException.
     *
     * @param v the element
     * @return the element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.004 -0400", hash_original_method = "C08C70E0FEE2977406B622D56AAA7A12", hash_generated_method = "9FBAD924A97884F37C177CD79DD29C5B")
    
private E screenNullResult(E v) {
        if (v == null)
            throw new NoSuchElementException();
        return v;
    }

    /**
     * Creates an array list and fills it with elements of this list.
     * Used by toArray.
     *
     * @return the array list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.004 -0400", hash_original_method = "55B7FDBC3B1FDA0FC90E2422307D4E3A", hash_generated_method = "FF1F55BFBA0B68D0E047B1D8BD68A063")
    
private ArrayList<E> toArrayList() {
        ArrayList<E> list = new ArrayList<E>();
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null)
                list.add(item);
        }
        return list;
    }

    /**
     * Initializes head and tail, ensuring invariants hold.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.006 -0400", hash_original_method = "54D96A0D7C222A3A88210FD783033F1A", hash_generated_method = "2950195B6DA4316FA60426DCC90D18F2")
    
private void initHeadTail(Node<E> h, Node<E> t) {
        if (h == t) {
            if (h == null)
                h = t = new Node<E>(null);
            else {
                // Avoid edge case of a single Node with non-null item.
                Node<E> newNode = new Node<E>(null);
                t.lazySetNext(newNode);
                newNode.lazySetPrev(t);
                t = newNode;
            }
        }
        head = h;
        tail = t;
    }

    /**
     * Inserts the specified element at the front of this deque.
     * As the deque is unbounded, this method will never throw
     * {@link IllegalStateException}.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.006 -0400", hash_original_method = "4AD19758DF6B2A3AC237465E3E2B86CE", hash_generated_method = "F83A247B6E9683C0B4E713E421EDE334")
    
public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * Inserts the specified element at the end of this deque.
     * As the deque is unbounded, this method will never throw
     * {@link IllegalStateException}.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.007 -0400", hash_original_method = "DEF460A3CCF8B7639D9808700B3189CB", hash_generated_method = "2C0C1B35A3E69E2FBA1D173DF21358E3")
    
public void addLast(E e) {
        linkLast(e);
    }

    /**
     * Inserts the specified element at the front of this deque.
     * As the deque is unbounded, this method will never return {@code false}.
     *
     * @return {@code true} (as specified by {@link Deque#offerFirst})
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.007 -0400", hash_original_method = "A4FDEF891EFA8A72A61F4298E3B5A244", hash_generated_method = "C21F983696C3B21BD9D0CA9E97E45E50")
    
public boolean offerFirst(E e) {
        linkFirst(e);
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque.
     * As the deque is unbounded, this method will never return {@code false}.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @return {@code true} (as specified by {@link Deque#offerLast})
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.007 -0400", hash_original_method = "CC1242A3FA0B11229838DFFD334BF8FF", hash_generated_method = "EF9DB2AB801F8091A06AA6892071188F")
    
public boolean offerLast(E e) {
        linkLast(e);
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.008 -0400", hash_original_method = "0B90CFDA0514766B0EF025B49FC521F5", hash_generated_method = "8A1B9FB1A3A9F6D028EE82E372DE5FE5")
    
public E peekFirst() {
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null)
                return item;
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.008 -0400", hash_original_method = "2D056939FE0588456FC2FCFF59292124", hash_generated_method = "379F601FB009AD2A30B37F73A85042A9")
    
public E peekLast() {
        for (Node<E> p = last(); p != null; p = pred(p)) {
            E item = p.item;
            if (item != null)
                return item;
        }
        return null;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.009 -0400", hash_original_method = "8C1F9F3F56ECE202FFD32A8051093FAC", hash_generated_method = "E93DB8E2FB3A0F07AB3A0BCA254232AB")
    
public E getFirst() {
        return screenNullResult(peekFirst());
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.009 -0400", hash_original_method = "0E51C7B53A1640045B8ADBD5402D314B", hash_generated_method = "75A8BFDA3208109C6FDAB237DD906E1E")
    
public E getLast() {
        return screenNullResult(peekLast());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.010 -0400", hash_original_method = "9D090BA47BD4FEA6EA2B2E7B2149FB7B", hash_generated_method = "2E0835C907308A36BE5B0E185C521D7B")
    
public E pollFirst() {
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null && p.casItem(item, null)) {
                unlink(p);
                return item;
            }
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.010 -0400", hash_original_method = "DA9066D6D7BF4AC9DEFC80DC4CD497C3", hash_generated_method = "9BD75066A28B5A04FA01988B0142558A")
    
public E pollLast() {
        for (Node<E> p = last(); p != null; p = pred(p)) {
            E item = p.item;
            if (item != null && p.casItem(item, null)) {
                unlink(p);
                return item;
            }
        }
        return null;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.010 -0400", hash_original_method = "CEC762D7230FDAEB46B53BF38148B624", hash_generated_method = "8D37796ABFD95DA23C27C16E0DBC2394")
    
public E removeFirst() {
        return screenNullResult(pollFirst());
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.011 -0400", hash_original_method = "6ACF88777D39C6D51F6155BE71F73C1B", hash_generated_method = "185FDF06D2ECA91BA67D5AC29635848C")
    
public E removeLast() {
        return screenNullResult(pollLast());
    }

    // *** Queue and stack methods ***

    /**
     * Inserts the specified element at the tail of this deque.
     * As the deque is unbounded, this method will never return {@code false}.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.011 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "326965DBCAC0F913D90C3A41623502D9")
    
public boolean offer(E e) {
        return offerLast(e);
    }

    /**
     * Inserts the specified element at the tail of this deque.
     * As the deque is unbounded, this method will never throw
     * {@link IllegalStateException} or return {@code false}.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.011 -0400", hash_original_method = "E35EE9CFE1BDA07918F74C272B25B9BD", hash_generated_method = "FBF3026FC74B2067E81E344BA69DD10B")
    
public boolean add(E e) {
        return offerLast(e);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.012 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "D92F2CAF590F842165119B6D24004B40")
    
public E poll()           { return pollFirst(); }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.012 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "E7EA57F8F5A1DC7F659D2407501F5651")
    
public E remove()         { return removeFirst(); }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.012 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "C49BD63C2CFF13F7E18F5863A21DF3DB")
    
public E peek()           { return peekFirst(); }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.013 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "BC6239B4A9B6D00FE072E062B112C82B")
    
public E element()        { return getFirst(); }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.013 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "57FDC65A59ACBA2985AC790990989FF0")
    
public void push(E e)     { addFirst(e); }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.013 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "58A444C456B794DA9A4C54CC4CC88A2E")
    
public E pop()            { return removeFirst(); }

    /**
     * Removes the first element {@code e} such that
     * {@code o.equals(e)}, if such an element exists in this deque.
     * If the deque does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if the deque contained the specified element
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.014 -0400", hash_original_method = "444EB81A4F2503FCBB7C579E34553CBB", hash_generated_method = "BC2D5E978C7EAE0B2C32C6BF29B2A4B0")
    
public boolean removeFirstOccurrence(Object o) {
        checkNotNull(o);
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null && o.equals(item) && p.casItem(item, null)) {
                unlink(p);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the last element {@code e} such that
     * {@code o.equals(e)}, if such an element exists in this deque.
     * If the deque does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if the deque contained the specified element
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.014 -0400", hash_original_method = "C342F47BF3C0488111C07445849F0CFB", hash_generated_method = "899A2D2923F0344289A214D3176AA327")
    
public boolean removeLastOccurrence(Object o) {
        checkNotNull(o);
        for (Node<E> p = last(); p != null; p = pred(p)) {
            E item = p.item;
            if (item != null && o.equals(item) && p.casItem(item, null)) {
                unlink(p);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns {@code true} if this deque contains at least one
     * element {@code e} such that {@code o.equals(e)}.
     *
     * @param o element whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.015 -0400", hash_original_method = "D3CFD955C2206E78AC2D6D0AA96542FF", hash_generated_method = "A8666B247011B410F30626CB4D5504E0")
    
public boolean contains(Object o) {
        if (o == null) return false;
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null && o.equals(item))
                return true;
        }
        return false;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.015 -0400", hash_original_method = "ACCC40E4FBCB32455415F81D0DCE4796", hash_generated_method = "56AA37296C327B7EF10B78651FCD4F69")
    
public boolean isEmpty() {
        return peekFirst() == null;
    }

    /**
     * Returns the number of elements in this deque.  If this deque
     * contains more than {@code Integer.MAX_VALUE} elements, it
     * returns {@code Integer.MAX_VALUE}.
     *
     * <p>Beware that, unlike in most collections, this method is
     * <em>NOT</em> a constant-time operation. Because of the
     * asynchronous nature of these deques, determining the current
     * number of elements requires traversing them all to count them.
     * Additionally, it is possible for the size to change during
     * execution of this method, in which case the returned result
     * will be inaccurate. Thus, this method is typically not very
     * useful in concurrent applications.
     *
     * @return the number of elements in this deque
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.016 -0400", hash_original_method = "8378A4BA724609F4EE8D701FE95A4146", hash_generated_method = "B3986D8D35FCEA705CE19E049D534B6B")
    
public int size() {
        int count = 0;
        for (Node<E> p = first(); p != null; p = succ(p))
            if (p.item != null)
                // Collection.size() spec says to max out
                if (++count == Integer.MAX_VALUE)
                    break;
        return count;
    }

    /**
     * Removes the first element {@code e} such that
     * {@code o.equals(e)}, if such an element exists in this deque.
     * If the deque does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if the deque contained the specified element
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.016 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "67436633CF4F0B184E774FE8B1646BF7")
    
public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this deque, in the order that they are returned by the specified
     * collection's iterator.  Attempts to {@code addAll} of a deque to
     * itself result in {@code IllegalArgumentException}.
     *
     * @param c the elements to be inserted into this deque
     * @return {@code true} if this deque changed as a result of the call
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     * @throws IllegalArgumentException if the collection is this deque
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.017 -0400", hash_original_method = "A2F8B4D3DAADBF23E2A6305783505AF2", hash_generated_method = "70123E3DD4C07DE87E99BA2FB987C89D")
    
public boolean addAll(Collection<? extends E> c) {
        if (c == this)
            // As historically specified in AbstractQueue#addAll
            throw new IllegalArgumentException();

        // Copy c into a private chain of Nodes
        Node<E> beginningOfTheEnd = null, last = null;
        for (E e : c) {
            checkNotNull(e);
            Node<E> newNode = new Node<E>(e);
            if (beginningOfTheEnd == null)
                beginningOfTheEnd = last = newNode;
            else {
                last.lazySetNext(newNode);
                newNode.lazySetPrev(last);
                last = newNode;
            }
        }
        if (beginningOfTheEnd == null)
            return false;

        // Atomically append the chain at the tail of this collection
        restartFromTail:
        for (;;)
            for (Node<E> t = tail, p = t, q;;) {
                if ((q = p.next) != null &&
                    (q = (p = q).next) != null)
                    // Check for tail updates every other hop.
                    // If p == q, we are sure to follow tail instead.
                    p = (t != (t = tail)) ? t : q;
                else if (p.prev == p) // NEXT_TERMINATOR
                    continue restartFromTail;
                else {
                    // p is last node
                    beginningOfTheEnd.lazySetPrev(p); // CAS piggyback
                    if (p.casNext(null, beginningOfTheEnd)) {
                        // Successful CAS is the linearization point
                        // for all elements to be added to this deque.
                        if (!casTail(t, last)) {
                            // Try a little harder to update tail,
                            // since we may be adding many elements.
                            t = tail;
                            if (last.next == null)
                                casTail(t, last);
                        }
                        return true;
                    }
                    // Lost CAS race to another thread; re-read next
                }
            }
    }

    /**
     * Removes all of the elements from this deque.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.018 -0400", hash_original_method = "8EE94FDA63B4083FC2600AD6758E669F", hash_generated_method = "AF2B4F810AF86F02C00AE95FEC8D0BF9")
    
public void clear() {
        while (pollFirst() != null)
            ;
    }

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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.018 -0400", hash_original_method = "99EB967DBE69EBFC4522C9287A4F72BD", hash_generated_method = "4B70183C58BB1935749D0D5AC0DFFE66")
    
public Object[] toArray() {
        return toArrayList().toArray();
    }

    private abstract class AbstractItr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.020 -0400", hash_original_field = "138F1A36912062F45403BBEDD9B8281D", hash_generated_field = "BD45C7FA08D8C17CC087E2A8B9D2DBAA")

        private Node<E> nextNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.020 -0400", hash_original_field = "FC047D97EB4DD102072D6594B14B8B33", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.020 -0400", hash_original_field = "93698314F06F14B80EF688D146BA679D", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.021 -0400", hash_original_method = "E973412F1BC7F9577DDB482462C1105E", hash_generated_method = "E973412F1BC7F9577DDB482462C1105E")
        
AbstractItr() {
            advance();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.021 -0400", hash_original_method = "B4918AC2B1E06CB8528B175C285CEC0C", hash_generated_method = "743367B241951FDE85AC490786D83AA5")
        
abstract Node<E> startNode();
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.021 -0400", hash_original_method = "73FAF060E26B4856A430B5B2F04723D1", hash_generated_method = "BDF7C552E9BE93DE4DDD0F3239DF6763")
        
abstract Node<E> nextNode(Node<E> p);

        /**
         * Sets nextNode and nextItem to next valid node, or to null
         * if no such.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.022 -0400", hash_original_method = "7D37FF76FE3DEAA834CA96B3C27E4D22", hash_generated_method = "19094ACBF27931592BBF5DCB24494DBE")
        
private void advance() {
            lastRet = nextNode;

            Node<E> p = (nextNode == null) ? startNode() : nextNode(nextNode);
            for (;; p = nextNode(p)) {
                if (p == null) {
                    // p might be active end or TERMINATOR node; both are OK
                    nextNode = null;
                    nextItem = null;
                    break;
                }
                E item = p.item;
                if (item != null) {
                    nextNode = p;
                    nextItem = item;
                    break;
                }
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.022 -0400", hash_original_method = "C7E0F4F8C5C8A8D55EBC0AC6D94C35A4", hash_generated_method = "6C435BA16F6A89C535895253E46AB965")
        
public boolean hasNext() {
            return nextItem != null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.023 -0400", hash_original_method = "6A4EB79162CB5BAD609CBFF8A90DB7AD", hash_generated_method = "297BA7321C28397AB485143754EF45E2")
        
public E next() {
            E item = nextItem;
            if (item == null) throw new NoSuchElementException();
            advance();
            return item;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.023 -0400", hash_original_method = "9B0791C66CE76C3D1F244FB1435DE96B", hash_generated_method = "36555A0431D4ECA6893B0E0C69D2E299")
        
public void remove() {
            Node<E> l = lastRet;
            if (l == null) throw new IllegalStateException();
            l.item = null;
            unlink(l);
            lastRet = null;
        }
    }

    /** Forward iterator */
    private class Itr extends AbstractItr {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.024 -0400", hash_original_method = "FC1033EB4DCA12DF816FE5F804071FA7", hash_generated_method = "FC1033EB4DCA12DF816FE5F804071FA7")
        
Node<E> startNode() { return first(); }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.025 -0400", hash_original_method = "0E74E1E0AB25FFDC899578F52007E0F5", hash_generated_method = "0E74E1E0AB25FFDC899578F52007E0F5")
        
Node<E> nextNode(Node<E> p) { return succ(p); }
    }

    /** Descending iterator */
    private class DescendingItr extends AbstractItr {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.025 -0400", hash_original_method = "31EE09BA955D3B3C4D86A64C5B079FAC", hash_generated_method = "31EE09BA955D3B3C4D86A64C5B079FAC")
        
Node<E> startNode() { return last(); }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.026 -0400", hash_original_method = "9AE0B01208B1FBA4CAA49820D3692DD6", hash_generated_method = "9AE0B01208B1FBA4CAA49820D3692DD6")
        
Node<E> nextNode(Node<E> p) { return pred(p); }
    }

    /**
     * Returns an array containing all of the elements in this deque,
     * in proper sequence (from first to last element); the runtime
     * type of the returned array is that of the specified array.  If
     * the deque fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of
     * the specified array and the size of this deque.
     *
     * <p>If this deque fits in the specified array with room to spare
     * (i.e., the array has more elements than this deque), the element in
     * the array immediately following the end of the deque is set to
     * {@code null}.
     *
     * <p>Like the {@link #toArray()} method, this method acts as
     * bridge between array-based and collection-based APIs.  Further,
     * this method allows precise control over the runtime type of the
     * output array, and may, under certain circumstances, be used to
     * save allocation costs.
     *
     * <p>Suppose {@code x} is a deque known to contain only strings.
     * The following code can be used to dump the deque into a newly
     * allocated array of {@code String}:
     *
     *  <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
     *
     * Note that {@code toArray(new Object[0])} is identical in function to
     * {@code toArray()}.
     *
     * @param a the array into which the elements of the deque are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose
     * @return an array containing all of the elements in this deque
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this deque
     * @throws NullPointerException if the specified array is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    public <T> T[] toArray(T[] a) {
        return toArrayList().toArray(a);
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.019 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "B0FB44010E28764F5FA2B4AB0E8E15C1")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.019 -0400", hash_original_method = "E2FFEA86BDF1CF0D788CD9C05CB28749", hash_generated_method = "D7F10C1829A3BC2581C201228B7412A7")
    
public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    /**
     * Saves this deque to a stream (that is, serializes it).
     *
     * @serialData All of the elements (each an {@code E}) in
     * the proper order, followed by a null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.027 -0400", hash_original_method = "D828535A67F7A7AF7F22620F1422CB60", hash_generated_method = "3878E5996D45CE19A0B00286A502D0A7")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {

        // Write out any hidden stuff
        s.defaultWriteObject();

        // Write out all elements in the proper order.
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null)
                s.writeObject(item);
        }

        // Use trailing null as sentinel
        s.writeObject(null);
    }

    /**
     * Reconstitutes this deque from a stream (that is, deserializes it).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.027 -0400", hash_original_method = "D375BB7CE67C504F2C0D6BCB63F8E3A2", hash_generated_method = "DD33E98C5788073D57AF2FAC3835826C")
    
private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();

        // Read in elements until trailing null sentinel found
        Node<E> h = null, t = null;
        Object item;
        while ((item = s.readObject()) != null) {
            @SuppressWarnings("unchecked")
            Node<E> newNode = new Node<E>((E) item);
            if (h == null)
                h = t = newNode;
            else {
                t.lazySetNext(newNode);
                newNode.lazySetPrev(t);
                t = newNode;
            }
        }
        initHeadTail(h, t);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.028 -0400", hash_original_method = "BC5855BB8BED9A25EA66B96BB6A04937", hash_generated_method = "3B755D3C35A6E32CBB6B8B9A8AD6318E")
    
private boolean casHead(Node<E> cmp, Node<E> val) {
        return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.028 -0400", hash_original_method = "691EF799FFE1B91CC4D8DBAB0EEF43D5", hash_generated_method = "A93F53BA0D8A63AFA1FA8565CC11D3B2")
    
private boolean casTail(Node<E> cmp, Node<E> val) {
        return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
    }
    static {
        PREV_TERMINATOR = new Node<Object>();
        PREV_TERMINATOR.next = PREV_TERMINATOR;
        NEXT_TERMINATOR = new Node<Object>();
        NEXT_TERMINATOR.prev = NEXT_TERMINATOR;
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ConcurrentLinkedDeque.class;
            headOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("head"));
            tailOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
