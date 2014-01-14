package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements java.io.Serializable {

    /**
     * Test for equality, coping with nulls.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.673 -0500", hash_original_method = "454D6D8A7D641F48CA6B87A071B1615F", hash_generated_method = "0DDF0DBFDE1A6689A83DC6DC03EBC794")
    
private static boolean eq(Object o1, Object o2) {
        return (o1 == null ? o2 == null : o1.equals(o2));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.628 -0500", hash_original_field = "37A814F518B219251AA46BDA21997F4A", hash_generated_field = "B2F6A1A939754D8234C996B8AA693186")

    private static final long serialVersionUID = 5457747651344034263L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.630 -0500", hash_original_field = "273D71B1B710C303797F8830CD9E9627", hash_generated_field = "CEE47592CD991F798055CF00F61D5D32")

    private  CopyOnWriteArrayList<E> al;

    /**
     * Creates an empty set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.633 -0500", hash_original_method = "719CF91FD15681D04C85978CBE8B39AE", hash_generated_method = "3CBB1DE415F0C19FD3572B7CD1FC83A1")
    
public CopyOnWriteArraySet() {
        al = new CopyOnWriteArrayList<E>();
    }

    /**
     * Creates a set containing all of the elements of the specified
     * collection.
     *
     * @param c the collection of elements to initially contain
     * @throws NullPointerException if the specified collection is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.635 -0500", hash_original_method = "A905F7DF70B1EDD8621789C3C3A6CD84", hash_generated_method = "B003E144846289E0AEB6814A85C77E68")
    
public CopyOnWriteArraySet(Collection<? extends E> c) {
        al = new CopyOnWriteArrayList<E>();
        al.addAllAbsent(c);
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.638 -0500", hash_original_method = "3CEC44303CC022BBEC9F119BC403FDBC", hash_generated_method = "FD349EDA389F166F5AB5B32AD7B69928")
    
public int size() {
        return al.size();
    }

    /**
     * Returns <tt>true</tt> if this set contains no elements.
     *
     * @return <tt>true</tt> if this set contains no elements
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.640 -0500", hash_original_method = "3B66E92AC54A2F386067AD3C16431654", hash_generated_method = "B6A29C44E6421DAC7A6BB388191FD1B5")
    
public boolean isEmpty() {
        return al.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this set contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this set
     * contains an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this set is to be tested
     * @return <tt>true</tt> if this set contains the specified element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.642 -0500", hash_original_method = "45B83D89DB9565F8F2123157436CF2DA", hash_generated_method = "C1C2C141E940D6A5568E115AEE5A3968")
    
public boolean contains(Object o) {
        return al.contains(o);
    }

    /**
     * Returns an array containing all of the elements in this set.
     * If this set makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the
     * elements in the same order.
     *
     * <p>The returned array will be "safe" in that no references to it
     * are maintained by this set.  (In other words, this method must
     * allocate a new array even if this set is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all the elements in this set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.644 -0500", hash_original_method = "59659636145935A673C89066DF38E15C", hash_generated_method = "4D665EBC24AE869D73CB844CF0201465")
    
public Object[] toArray() {
        return al.toArray();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.885 -0400", hash_original_method = "611ED93917CDC5DE1AF7714E59426D61", hash_generated_method = "A97A508A6AB1C24B6FB5FCF21A879F6C")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
T[] varAA44379FEF6B0261A49B4F9151CB856C_1385790034 =         al.toArray(a);
        varAA44379FEF6B0261A49B4F9151CB856C_1385790034.addTaint(taint);
        return varAA44379FEF6B0261A49B4F9151CB856C_1385790034;
        // ---------- Original Method ----------
        //return al.toArray(a);
    }

    /**
     * Removes all of the elements from this set.
     * The set will be empty after this call returns.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.649 -0500", hash_original_method = "3A8225B3804E9179BE65F5C2B01036E9", hash_generated_method = "ED19120A679128891E62BAFC6205202D")
    
public void clear() {
        al.clear();
    }

    /**
     * Removes the specified element from this set if it is present.
     * More formally, removes an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>,
     * if this set contains such an element.  Returns <tt>true</tt> if
     * this set contained the element (or equivalently, if this set
     * changed as a result of the call).  (This set will not contain the
     * element once the call returns.)
     *
     * @param o object to be removed from this set, if present
     * @return <tt>true</tt> if this set contained the specified element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.652 -0500", hash_original_method = "4B916DD49AA1C881C6B40C3BB12114A0", hash_generated_method = "E99DE92F5D686004F214CC5A1E5D831F")
    
public boolean remove(Object o) {
        return al.remove(o);
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element <tt>e</tt> to this set if
     * the set contains no element <tt>e2</tt> such that
     * <tt>(e==null&nbsp;?&nbsp;e2==null&nbsp;:&nbsp;e.equals(e2))</tt>.
     * If this set already contains the element, the call leaves the set
     * unchanged and returns <tt>false</tt>.
     *
     * @param e element to be added to this set
     * @return <tt>true</tt> if this set did not already contain the specified
     *         element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.654 -0500", hash_original_method = "C36F2E0651BF3F93251D9AAA1075E241", hash_generated_method = "691DCD4142B8BB56E48201EC4322E72A")
    
public boolean add(E e) {
        return al.addIfAbsent(e);
    }

    /**
     * Returns <tt>true</tt> if this set contains all of the elements of the
     * specified collection.  If the specified collection is also a set, this
     * method returns <tt>true</tt> if it is a <i>subset</i> of this set.
     *
     * @param  c collection to be checked for containment in this set
     * @return <tt>true</tt> if this set contains all of the elements of the
     *         specified collection
     * @throws NullPointerException if the specified collection is null
     * @see #contains(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.656 -0500", hash_original_method = "BAD19EAB09738DBB9663648D63DFE74C", hash_generated_method = "20C24386DF433EE5A344EEACFE69F45D")
    
public boolean containsAll(Collection<?> c) {
        return al.containsAll(c);
    }

    /**
     * Adds all of the elements in the specified collection to this set if
     * they're not already present.  If the specified collection is also a
     * set, the <tt>addAll</tt> operation effectively modifies this set so
     * that its value is the <i>union</i> of the two sets.  The behavior of
     * this operation is undefined if the specified collection is modified
     * while the operation is in progress.
     *
     * @param  c collection containing elements to be added to this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see #add(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.659 -0500", hash_original_method = "B7022E0CB9EF549D20482BA7616126CF", hash_generated_method = "B52446F79F5608D2C75D96940DC21B7C")
    
public boolean addAll(Collection<? extends E> c) {
        return al.addAllAbsent(c) > 0;
    }

    /**
     * Removes from this set all of its elements that are contained in the
     * specified collection.  If the specified collection is also a set,
     * this operation effectively modifies this set so that its value is the
     * <i>asymmetric set difference</i> of the two sets.
     *
     * @param  c collection containing elements to be removed from this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws ClassCastException if the class of an element of this set
     *         is incompatible with the specified collection (optional)
     * @throws NullPointerException if this set contains a null element and the
     *         specified collection does not permit null elements (optional),
     *         or if the specified collection is null
     * @see #remove(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.661 -0500", hash_original_method = "66AA12EE71C1D65DECB2FC917ACDE24D", hash_generated_method = "ED1ECAE0EB0C2B56318148858C23D470")
    
public boolean removeAll(Collection<?> c) {
        return al.removeAll(c);
    }

    /**
     * Retains only the elements in this set that are contained in the
     * specified collection.  In other words, removes from this set all of
     * its elements that are not contained in the specified collection.  If
     * the specified collection is also a set, this operation effectively
     * modifies this set so that its value is the <i>intersection</i> of the
     * two sets.
     *
     * @param  c collection containing elements to be retained in this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws ClassCastException if the class of an element of this set
     *         is incompatible with the specified collection (optional)
     * @throws NullPointerException if this set contains a null element and the
     *         specified collection does not permit null elements (optional),
     *         or if the specified collection is null
     * @see #remove(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.664 -0500", hash_original_method = "D0A4CF23F1E9AE32CFAA8649387F142B", hash_generated_method = "79BF9843443FC370A29F536A14E6646B")
    
public boolean retainAll(Collection<?> c) {
        return al.retainAll(c);
    }

    /**
     * Returns an iterator over the elements contained in this set
     * in the order in which these elements were added.
     *
     * <p>The returned iterator provides a snapshot of the state of the set
     * when the iterator was constructed. No synchronization is needed while
     * traversing the iterator. The iterator does <em>NOT</em> support the
     * <tt>remove</tt> method.
     *
     * @return an iterator over the elements in this set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.667 -0500", hash_original_method = "1D191D7F570684E003696ECD55ECD643", hash_generated_method = "0A46AE5BBA3526BAF33DF6C195CE13E9")
    
public Iterator<E> iterator() {
        return al.iterator();
    }

    /**
     * Compares the specified object with this set for equality.
     * Returns {@code true} if the specified object is the same object
     * as this object, or if it is also a {@link Set} and the elements
     * returned by an {@linkplain List#iterator() iterator} over the
     * specified set are the same as the elements returned by an
     * iterator over this set.  More formally, the two iterators are
     * considered to return the same elements if they return the same
     * number of elements and for every element {@code e1} returned by
     * the iterator over the specified set, there is an element
     * {@code e2} returned by the iterator over this set such that
     * {@code (e1==null ? e2==null : e1.equals(e2))}.
     *
     * @param o object to be compared for equality with this set
     * @return {@code true} if the specified object is equal to this set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.670 -0500", hash_original_method = "EF3132D176498E8C292078B60C02B2A5", hash_generated_method = "D090C344345913673474764ABF474EB7")
    
public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Set))
            return false;
        Set<?> set = (Set<?>)(o);
        Iterator<?> it = set.iterator();

        // Uses O(n^2) algorithm that is only appropriate
        // for small sets, which CopyOnWriteArraySets should be.

        //  Use a single snapshot of underlying array
        Object[] elements = al.getArray();
        int len = elements.length;
        // Mark matched elements to avoid re-checking
        boolean[] matched = new boolean[len];
        int k = 0;
        outer: while (it.hasNext()) {
            if (++k > len)
                return false;
            Object x = it.next();
            for (int i = 0; i < len; ++i) {
                if (!matched[i] && eq(x, elements[i])) {
                    matched[i] = true;
                    continue outer;
                }
            }
            return false;
        }
        return k == len;
    }
}

