/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.*;

// BEGIN android-note
// removed link to collections framework docs
// END android-note

/**
 * A scalable concurrent {@link NavigableSet} implementation based on
 * a {@link ConcurrentSkipListMap}.  The elements of the set are kept
 * sorted according to their {@linkplain Comparable natural ordering},
 * or by a {@link Comparator} provided at set creation time, depending
 * on which constructor is used.
 *
 * <p>This implementation provides expected average <i>log(n)</i> time
 * cost for the {@code contains}, {@code add}, and {@code remove}
 * operations and their variants.  Insertion, removal, and access
 * operations safely execute concurrently by multiple threads.
 * Iterators are <i>weakly consistent</i>, returning elements
 * reflecting the state of the set at some point at or since the
 * creation of the iterator.  They do <em>not</em> throw {@link
 * ConcurrentModificationException}, and may proceed concurrently with
 * other operations.  Ascending ordered views and their iterators are
 * faster than descending ones.
 *
 * <p>Beware that, unlike in most collections, the {@code size}
 * method is <em>not</em> a constant-time operation. Because of the
 * asynchronous nature of these sets, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * concurrently with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterators implement all of the
 * <em>optional</em> methods of the {@link Set} and {@link Iterator}
 * interfaces. Like most other concurrent collection implementations,
 * this class does not permit the use of {@code null} elements,
 * because {@code null} arguments and return values cannot be reliably
 * distinguished from the absence of elements.
 *
 * @author Doug Lea
 * @param <E> the type of elements maintained by this set
 * @since 1.6
 */
public class ConcurrentSkipListSet<E>
    extends AbstractSet<E>
    implements NavigableSet<E>, Cloneable, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.511 -0400", hash_original_field = "227CB222B26308336F72E5CEE874DBAB", hash_generated_field = "7381407C50BEAC7DF41E14CF3A10E102")

    private static final long serialVersionUID = -2479143111061671589L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.526 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

    private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.527 -0400", hash_original_field = "106366ADA5B07C073CE922CE3F382D34", hash_generated_field = "50722348F52364D6E15050AD3663E214")

    private static  long mapOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.512 -0400", hash_original_field = "D62AC6366BF6F6C1013F6A8445F57DE9", hash_generated_field = "017405684BAB1714992E9A5C494E82CB")

    private  ConcurrentNavigableMap<E,Object> m;

    /**
     * Constructs a new, empty set that orders its elements according to
     * their {@linkplain Comparable natural ordering}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.512 -0400", hash_original_method = "1CDFCF42F65B6E8E3D2BA58DE326AF58", hash_generated_method = "E5E26D78C2A184953BF3F57042ADF6FC")
    
public ConcurrentSkipListSet() {
        m = new ConcurrentSkipListMap<E,Object>();
    }

    /**
     * Constructs a new, empty set that orders its elements according to
     * the specified comparator.
     *
     * @param comparator the comparator that will be used to order this set.
     *        If {@code null}, the {@linkplain Comparable natural
     *        ordering} of the elements will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.512 -0400", hash_original_method = "9BAF96B4D9E8101BDDD78FF605269055", hash_generated_method = "341BEB56629B11E0EB997F8D19E408F8")
    
public ConcurrentSkipListSet(Comparator<? super E> comparator) {
        m = new ConcurrentSkipListMap<E,Object>(comparator);
    }

    /**
     * Constructs a new set containing the elements in the specified
     * collection, that orders its elements according to their
     * {@linkplain Comparable natural ordering}.
     *
     * @param c The elements that will comprise the new set
     * @throws ClassCastException if the elements in {@code c} are
     *         not {@link Comparable}, or are not mutually comparable
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.513 -0400", hash_original_method = "430417B0E725C1242C8F46DCC675F98D", hash_generated_method = "4BF5D44262211EB82489CD6ECBCB0948")
    
public ConcurrentSkipListSet(Collection<? extends E> c) {
        m = new ConcurrentSkipListMap<E,Object>();
        addAll(c);
    }

    /**
     * Constructs a new set containing the same elements and using the
     * same ordering as the specified sorted set.
     *
     * @param s sorted set whose elements will comprise the new set
     * @throws NullPointerException if the specified sorted set or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.513 -0400", hash_original_method = "448F37F06446E11947B66F9E829FA97B", hash_generated_method = "03E758798E9DAFE7951BC7E492BB9453")
    
public ConcurrentSkipListSet(SortedSet<E> s) {
        m = new ConcurrentSkipListMap<E,Object>(s.comparator());
        addAll(s);
    }

    /**
     * For use by submaps
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.514 -0400", hash_original_method = "4316092F2544918F0321F7854295EA91", hash_generated_method = "4316092F2544918F0321F7854295EA91")
    
ConcurrentSkipListSet(ConcurrentNavigableMap<E,Object> m) {
        this.m = m;
    }

    /**
     * Returns a shallow copy of this {@code ConcurrentSkipListSet}
     * instance. (The elements themselves are not cloned.)
     *
     * @return a shallow copy of this set
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.514 -0400", hash_original_method = "4E2D77CA0A7AED8150CFDE8A40970703", hash_generated_method = "6F64CA2F2078C9BD8F96D3917F4280D4")
    
public ConcurrentSkipListSet<E> clone() {
        try {
            @SuppressWarnings("unchecked")
            ConcurrentSkipListSet<E> clone =
                (ConcurrentSkipListSet<E>) super.clone();
            clone.setMap(new ConcurrentSkipListMap<E,Object>(m));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /* ---------------- Set operations -------------- */

    /**
     * Returns the number of elements in this set.  If this set
     * contains more than {@code Integer.MAX_VALUE} elements, it
     * returns {@code Integer.MAX_VALUE}.
     *
     * <p>Beware that, unlike in most collections, this method is
     * <em>NOT</em> a constant-time operation. Because of the
     * asynchronous nature of these sets, determining the current
     * number of elements requires traversing them all to count them.
     * Additionally, it is possible for the size to change during
     * execution of this method, in which case the returned result
     * will be inaccurate. Thus, this method is typically not very
     * useful in concurrent applications.
     *
     * @return the number of elements in this set
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.515 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "B6A481AB385BBDAEA9A99BEF48697907")
    
public int size() {
        return m.size();
    }

    /**
     * Returns {@code true} if this set contains no elements.
     * @return {@code true} if this set contains no elements
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.515 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "34A044B85338F80AC374E61345D72801")
    
public boolean isEmpty() {
        return m.isEmpty();
    }

    /**
     * Returns {@code true} if this set contains the specified element.
     * More formally, returns {@code true} if and only if this set
     * contains an element {@code e} such that {@code o.equals(e)}.
     *
     * @param o object to be checked for containment in this set
     * @return {@code true} if this set contains the specified element
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in this set
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.516 -0400", hash_original_method = "93D27F83E886B31790810958F2BFC989", hash_generated_method = "B5A050C42D8B6E4A1BCB73C685ADB7FC")
    
public boolean contains(Object o) {
        return m.containsKey(o);
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element {@code e} to this set if
     * the set contains no element {@code e2} such that {@code e.equals(e2)}.
     * If this set already contains the element, the call leaves the set
     * unchanged and returns {@code false}.
     *
     * @param e element to be added to this set
     * @return {@code true} if this set did not already contain the
     *         specified element
     * @throws ClassCastException if {@code e} cannot be compared
     *         with the elements currently in this set
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.516 -0400", hash_original_method = "7053BB540B23AA007CAB16D68CED10A9", hash_generated_method = "D71B721DEE5A9263CE631D391755A82F")
    
public boolean add(E e) {
        return m.putIfAbsent(e, Boolean.TRUE) == null;
    }

    /**
     * Removes the specified element from this set if it is present.
     * More formally, removes an element {@code e} such that
     * {@code o.equals(e)}, if this set contains such an element.
     * Returns {@code true} if this set contained the element (or
     * equivalently, if this set changed as a result of the call).
     * (This set will not contain the element once the call returns.)
     *
     * @param o object to be removed from this set, if present
     * @return {@code true} if this set contained the specified element
     * @throws ClassCastException if {@code o} cannot be compared
     *         with the elements currently in this set
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.516 -0400", hash_original_method = "4C7571A8157A33D092CC5E3D15E28866", hash_generated_method = "EFED1E1AE3FFB3EE331ED3151DA7ED37")
    
public boolean remove(Object o) {
        return m.remove(o, Boolean.TRUE);
    }

    /**
     * Removes all of the elements from this set.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.517 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "2176D445272406688DBDA5C0282AE3E2")
    
public void clear() {
        m.clear();
    }

    /**
     * Returns an iterator over the elements in this set in ascending order.
     *
     * @return an iterator over the elements in this set in ascending order
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.517 -0400", hash_original_method = "5F71C7E0A5593F392A0806A3CE200AF9", hash_generated_method = "3D876F5F04348BCFF0BE874605FB00BE")
    
public Iterator<E> iterator() {
        return m.navigableKeySet().iterator();
    }

    /**
     * Returns an iterator over the elements in this set in descending order.
     *
     * @return an iterator over the elements in this set in descending order
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.517 -0400", hash_original_method = "96729D330B50C97FB26BF1BC1C614850", hash_generated_method = "032464C45B3CAA034D193D61203514F6")
    
public Iterator<E> descendingIterator() {
        return m.descendingKeySet().iterator();
    }

    /* ---------------- AbstractSet Overrides -------------- */

    /**
     * Compares the specified object with this set for equality.  Returns
     * {@code true} if the specified object is also a set, the two sets
     * have the same size, and every member of the specified set is
     * contained in this set (or equivalently, every member of this set is
     * contained in the specified set).  This definition ensures that the
     * equals method works properly across different implementations of the
     * set interface.
     *
     * @param o the object to be compared for equality with this set
     * @return {@code true} if the specified object is equal to this set
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.518 -0400", hash_original_method = "6A0DE4C77139F252A7F681C504B1BD64", hash_generated_method = "4974694F8B03380E373BDBC2F21688C4")
    
public boolean equals(Object o) {
        // Override AbstractSet version to avoid calling size()
        if (o == this)
            return true;
        if (!(o instanceof Set))
            return false;
        Collection<?> c = (Collection<?>) o;
        try {
            return containsAll(c) && c.containsAll(this);
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /**
     * Removes from this set all of its elements that are contained in
     * the specified collection.  If the specified collection is also
     * a set, this operation effectively modifies this set so that its
     * value is the <i>asymmetric set difference</i> of the two sets.
     *
     * @param  c collection containing elements to be removed from this set
     * @return {@code true} if this set changed as a result of the call
     * @throws ClassCastException if the types of one or more elements in this
     *         set are incompatible with the specified collection
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.518 -0400", hash_original_method = "8ECA317C2A378F8F7993EF4F47C37092", hash_generated_method = "AC5113B7E13A02E185A7C44CDFF0597D")
    
public boolean removeAll(Collection<?> c) {
        // Override AbstractSet version to avoid unnecessary call to size()
        boolean modified = false;
        for (Object e : c)
            if (remove(e))
                modified = true;
        return modified;
    }

    /* ---------------- Relational operations -------------- */

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.519 -0400", hash_original_method = "10F5AE4F9BF066ED54975005050E0A23", hash_generated_method = "D32FEA92767C3F39B1D28E106F859C25")
    
public E lower(E e) {
        return m.lowerKey(e);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.520 -0400", hash_original_method = "2C2553165E35C727802F311B361A1F6C", hash_generated_method = "07B1A5896D91EAC9ADADDF8A6E5E462D")
    
public E floor(E e) {
        return m.floorKey(e);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.520 -0400", hash_original_method = "772A3530FF9574E83AE3BF5219D76116", hash_generated_method = "860BE16303AEA4625B9BFF80822A414C")
    
public E ceiling(E e) {
        return m.ceilingKey(e);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified element is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.520 -0400", hash_original_method = "DB19F68E3F0204E010448E0B14609A4A", hash_generated_method = "DC75F8BD2213EAF1F10ED1C10B480C5A")
    
public E higher(E e) {
        return m.higherKey(e);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.521 -0400", hash_original_method = "1A080A19D2FCD5FE83F759422097D29B", hash_generated_method = "5EE850936620D6981DF9BAB075F0C2EF")
    
public E pollFirst() {
        Map.Entry<E,Object> e = m.pollFirstEntry();
        return (e == null) ? null : e.getKey();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.521 -0400", hash_original_method = "51F0C8E500BF24296D238A01B696E348", hash_generated_method = "06B70687A43991198738688272E22606")
    
public E pollLast() {
        Map.Entry<E,Object> e = m.pollLastEntry();
        return (e == null) ? null : e.getKey();
    }

    /* ---------------- SortedSet operations -------------- */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.522 -0400", hash_original_method = "820C6AEF3954D2EE59DA490481F0B7A1", hash_generated_method = "4B36A3158C155E201AC90E71446E8FDF")
    
public Comparator<? super E> comparator() {
        return m.comparator();
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.522 -0400", hash_original_method = "5D8C9DE6ABA3C57BE67F77FBFD9DC6D8", hash_generated_method = "8618BF77DA48B7C5ACF4105D185DC131")
    
public E first() {
        return m.firstKey();
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.522 -0400", hash_original_method = "D0E174621F7616B481FD7AB7D93D10A3", hash_generated_method = "D18FF8A99CFBC6921AD15151C6B94B9E")
    
public E last() {
        return m.lastKey();
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromElement} or
     *         {@code toElement} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.523 -0400", hash_original_method = "A87E3BB574A0B39363205DE18EFC2A4E", hash_generated_method = "127F5FE969B85526FD817570C7D3D9FF")
    
public NavigableSet<E> subSet(E fromElement,
                                  boolean fromInclusive,
                                  E toElement,
                                  boolean toInclusive) {
        return new ConcurrentSkipListSet<E>
            (m.subMap(fromElement, fromInclusive,
                      toElement,   toInclusive));
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code toElement} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.523 -0400", hash_original_method = "3B7E920F9D3734EA367AD02EF2477A39", hash_generated_method = "B65C06ED071B3007A3069F09D4AC735D")
    
public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return new ConcurrentSkipListSet<E>(m.headMap(toElement, inclusive));
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromElement} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.523 -0400", hash_original_method = "B1EE3D53365C483650DEFA2A8C83A05F", hash_generated_method = "56DCD1E2DFE3E67B5F9957CAB5F9157E")
    
public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return new ConcurrentSkipListSet<E>(m.tailMap(fromElement, inclusive));
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromElement} or
     *         {@code toElement} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.524 -0400", hash_original_method = "BA767B7DA98792FEF815295972E2FEB5", hash_generated_method = "68608E59C890095F14A3380248DB46DA")
    
public NavigableSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code toElement} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.525 -0400", hash_original_method = "46ABB76D7FEEBB9F7E3797A8C60354C5", hash_generated_method = "D61B6C1A1BFD365C1936C8DCE2AC410A")
    
public NavigableSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromElement} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.525 -0400", hash_original_method = "33B2FADE88BACD2AE867FBAD0F2395D8", hash_generated_method = "7BFF6469941869BFE6B08369B59A6B2E")
    
public NavigableSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    /**
     * Returns a reverse order view of the elements contained in this set.
     * The descending set is backed by this set, so changes to the set are
     * reflected in the descending set, and vice-versa.
     *
     * <p>The returned set has an ordering equivalent to
     * {@link Collections#reverseOrder(Comparator) Collections.reverseOrder}{@code (comparator())}.
     * The expression {@code s.descendingSet().descendingSet()} returns a
     * view of {@code s} essentially equivalent to {@code s}.
     *
     * @return a reverse order view of this set
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.526 -0400", hash_original_method = "EF3AC8EB34C0A4F44BEE725007ACCD08", hash_generated_method = "EBEF81432EC4BC3C9A564317A5D62EEA")
    
public NavigableSet<E> descendingSet() {
        return new ConcurrentSkipListSet<E>(m.descendingMap());
    }

    // Support for resetting map in clone
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.526 -0400", hash_original_method = "94276BC9EC96028CFAE09AC341737D43", hash_generated_method = "C2317D7BD04C7E40F8B35D3D92179FFB")
    
private void setMap(ConcurrentNavigableMap<E,Object> map) {
        UNSAFE.putObjectVolatile(this, mapOffset, map);
    }
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ConcurrentSkipListSet.class;
            mapOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("m"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
