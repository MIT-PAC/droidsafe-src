package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.399 -0500", hash_original_field = "F06A04FC92EF3A2281A9A5BE149F46FD", hash_generated_field = "9C3B8B7AFE1FAFCE87E9784F2B7C8D5F")

    private static final int MIN_INITIAL_CAPACITY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.540 -0500", hash_original_field = "A8C1363F3252A21DCD0B0759A113F4AC", hash_generated_field = "7C4DAA612FFE9A2D14BBB1700B6F7B63")

    private static final long serialVersionUID = 2340985798034038923L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.392 -0500", hash_original_field = "FB10D604B5E15C042369D34E470EFDCF", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.394 -0500", hash_original_field = "A1048D3759E63B671CF9C4A68B95CC77", hash_generated_field = "C80FE6D9E9CF1E423738D59094B3A099")

    private transient int head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.397 -0500", hash_original_field = "5515FBC63ED2C8744EFACAED3C91D22E", hash_generated_field = "993ACFB1D5CE316FEA289C1E850AAC75")

    private transient int tail;

    /**
     * Constructs an empty array deque with an initial capacity
     * sufficient to hold 16 elements.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.410 -0500", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "366EB0889C106AAC3E31EE9BAED51380")
    
public ArrayDeque() {
        elements = (E[]) new Object[16];
    }

    /**
     * Constructs an empty array deque with an initial capacity
     * sufficient to hold the specified number of elements.
     *
     * @param numElements  lower bound on initial capacity of the deque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.412 -0500", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "246273E126350628D3C7920EF6CDCCD5")
    
public ArrayDeque(int numElements) {
        allocateElements(numElements);
    }

    /**
     * Constructs a deque containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.  (The first element returned by the collection's
     * iterator becomes the first element, or <i>front</i> of the
     * deque.)
     *
     * @param c the collection whose elements are to be placed into the deque
     * @throws NullPointerException if the specified collection is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.416 -0500", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "AA1896D162B72EAE3EDE1B373974C833")
    
public ArrayDeque(Collection<? extends E> c) {
        allocateElements(c.size());
        addAll(c);
    }

    // ******  Array allocation and resizing utilities ******

    /**
     * Allocate empty array to hold the given number of elements.
     *
     * @param numElements  the number of elements to hold
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.402 -0500", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "8691D52DF6C22B1E74077E39B1BA1993")
    
private void allocateElements(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        elements = (E[]) new Object[initialCapacity];
    }

    /**
     * Double the capacity of this deque.  Call only when full, i.e.,
     * when head and tail have wrapped around to become equal.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.404 -0500", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "477BB45AE156B2746D84F4B04582837E")
    
private void doubleCapacity() {
        assert head == tail;
        int p = head;
        int n = elements.length;
        int r = n - p; // number of elements to the right of p
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] a = new Object[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = (E[])a;
        head = 0;
        tail = n;
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.729 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "A27DAFB69608B631E191921E359A6DED")
    private <T> T[] copyElements(T[] a) {
        addTaint(a[0].getTaint());
        if(head < tail)        
        {
            System.arraycopy(elements, head, a, 0, size());
        } //End block
        else
        if(head > tail)        
        {
            int headPortionLen = elements.length - head;
            System.arraycopy(elements, head, a, 0, headPortionLen);
            System.arraycopy(elements, 0, a, headPortionLen, tail);
        } //End block
T[] var3F5343BF1D849954A73F0BB303805FFD_458471027 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_458471027.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_458471027;
        // ---------- Original Method ----------
        //if (head < tail) {
            //System.arraycopy(elements, head, a, 0, size());
        //} else if (head > tail) {
            //int headPortionLen = elements.length - head;
            //System.arraycopy(elements, head, a, 0, headPortionLen);
            //System.arraycopy(elements, 0, a, headPortionLen, tail);
        //}
        //return a;
    }

    // The main insertion and extraction methods are addFirst,
    // addLast, pollFirst, pollLast. The other methods are defined in
    // terms of these.

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param e the element to add
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.418 -0500", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "248FDBA375E3BBC8FDC6E6B6D66C9BAE")
    
public void addFirst(E e) {
        if (e == null)
            throw new NullPointerException();
        elements[head = (head - 1) & (elements.length - 1)] = e;
        if (head == tail)
            doubleCapacity();
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.421 -0500", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "D56E4DBE1551D0F08F06BC7AEF20E523")
    
public void addLast(E e) {
        if (e == null)
            throw new NullPointerException();
        elements[tail] = e;
        if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            doubleCapacity();
    }

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Deque#offerFirst})
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.423 -0500", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "4EF58F4341E85B06DAFB5DACE21A07F8")
    
public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Deque#offerLast})
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.426 -0500", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "5259D04831CFBC97FA07B15139C69FAD")
    
public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.428 -0500", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "33889137BDA4646A9361CB9125B9A446")
    
public E removeFirst() {
        E x = pollFirst();
        if (x == null)
            throw new NoSuchElementException();
        return x;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.430 -0500", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "5994715E76E59F5586780093061EC479")
    
public E removeLast() {
        E x = pollLast();
        if (x == null)
            throw new NoSuchElementException();
        return x;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.433 -0500", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "D441E229978055821D8C1725DE1CBAA5")
    
public E pollFirst() {
        int h = head;
        E result = elements[h]; // Element is null if deque empty
        if (result == null)
            return null;
        elements[h] = null;     // Must null out slot
        head = (h + 1) & (elements.length - 1);
        return result;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.435 -0500", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "CDEB2CE80CF838F560C95B8A81E467A4")
    
public E pollLast() {
        int t = (tail - 1) & (elements.length - 1);
        E result = elements[t];
        if (result == null)
            return null;
        elements[t] = null;
        tail = t;
        return result;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.438 -0500", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "BAE6C0F205BAEF2617D0EA50ACC9C5B1")
    
public E getFirst() {
        E x = elements[head];
        if (x == null)
            throw new NoSuchElementException();
        return x;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.440 -0500", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "7736EF3A646AF2E7EFE23EC6AD7231AB")
    
public E getLast() {
        E x = elements[(tail - 1) & (elements.length - 1)];
        if (x == null)
            throw new NoSuchElementException();
        return x;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.443 -0500", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "96BE96FF70322C9C6A3B11CA12656F1D")
    
public E peekFirst() {
        return elements[head]; // elements[head] is null if deque empty
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.445 -0500", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "CD016E2C5C6514C04B6BE87AF68AA0B7")
    
public E peekLast() {
        return elements[(tail - 1) & (elements.length - 1)];
    }

    /**
     * Removes the first occurrence of the specified element in this
     * deque (when traversing the deque from head to tail).
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element <tt>e</tt> such that
     * <tt>o.equals(e)</tt> (if such an element exists).
     * Returns <tt>true</tt> if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return <tt>true</tt> if the deque contained the specified element
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.448 -0500", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "8951C539A9C2F41CB574489BCEB168EB")
    
public boolean removeFirstOccurrence(Object o) {
        if (o == null)
            return false;
        int mask = elements.length - 1;
        int i = head;
        E x;
        while ( (x = elements[i]) != null) {
            if (o.equals(x)) {
                delete(i);
                return true;
            }
            i = (i + 1) & mask;
        }
        return false;
    }

    /**
     * Removes the last occurrence of the specified element in this
     * deque (when traversing the deque from head to tail).
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the last element <tt>e</tt> such that
     * <tt>o.equals(e)</tt> (if such an element exists).
     * Returns <tt>true</tt> if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return <tt>true</tt> if the deque contained the specified element
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.451 -0500", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "EF5DB267C8A8988D02B3BB6553CAEF03")
    
public boolean removeLastOccurrence(Object o) {
        if (o == null)
            return false;
        int mask = elements.length - 1;
        int i = (tail - 1) & mask;
        E x;
        while ( (x = elements[i]) != null) {
            if (o.equals(x)) {
                delete(i);
                return true;
            }
            i = (i - 1) & mask;
        }
        return false;
    }

    // *** Queue methods ***

    /**
     * Inserts the specified element at the end of this deque.
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.453 -0500", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "358E992871DB0DF233264CEDEE0FBEF3")
    
public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * <p>This method is equivalent to {@link #offerLast}.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Queue#offer})
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.455 -0500", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "326965DBCAC0F913D90C3A41623502D9")
    
public boolean offer(E e) {
        return offerLast(e);
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque.
     *
     * This method differs from {@link #poll poll} only in that it throws an
     * exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #removeFirst}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.458 -0500", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "E7EA57F8F5A1DC7F659D2407501F5651")
    
public E remove() {
        return removeFirst();
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns
     * <tt>null</tt> if this deque is empty.
     *
     * <p>This method is equivalent to {@link #pollFirst}.
     *
     * @return the head of the queue represented by this deque, or
     *         <tt>null</tt> if this deque is empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.460 -0500", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "D92F2CAF590F842165119B6D24004B40")
    
public E poll() {
        return pollFirst();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque.  This method differs from {@link #peek peek} only in
     * that it throws an exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #getFirst}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.463 -0500", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "BC6239B4A9B6D00FE072E062B112C82B")
    
public E element() {
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque, or returns <tt>null</tt> if this deque is empty.
     *
     * <p>This method is equivalent to {@link #peekFirst}.
     *
     * @return the head of the queue represented by this deque, or
     *         <tt>null</tt> if this deque is empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.465 -0500", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "C49BD63C2CFF13F7E18F5863A21DF3DB")
    
public E peek() {
        return peekFirst();
    }

    // *** Stack methods ***

    /**
     * Pushes an element onto the stack represented by this deque.  In other
     * words, inserts the element at the front of this deque.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     * @throws NullPointerException if the specified element is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.468 -0500", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "57FDC65A59ACBA2985AC790990989FF0")
    
public void push(E e) {
        addFirst(e);
    }

    /**
     * Pops an element from the stack represented by this deque.  In other
     * words, removes and returns the first element of this deque.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this deque (which is the top
     *         of the stack represented by this deque)
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.470 -0500", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "58A444C456B794DA9A4C54CC4CC88A2E")
    
public E pop() {
        return removeFirst();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.472 -0500", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "9EF537CBD9594CE558F22F47C8575E46")
    
private void checkInvariants() {
        assert elements[tail] == null;
        assert head == tail ? elements[head] == null :
            (elements[head] != null &&
             elements[(tail - 1) & (elements.length - 1)] != null);
        assert elements[(head - 1) & (elements.length - 1)] == null;
    }

    /**
     * Removes the element at the specified position in the elements array,
     * adjusting head and tail as necessary.  This can result in motion of
     * elements backwards or forwards in the array.
     *
     * <p>This method is called delete rather than remove to emphasize
     * that its semantics differ from those of {@link List#remove(int)}.
     *
     * @return true if elements moved backwards
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.476 -0500", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "FFDE6A4E0C742CDC537A1D3DBACFBC23")
    
private boolean delete(int i) {
        checkInvariants();
        final E[] elements = this.elements;
        final int mask = elements.length - 1;
        final int h = head;
        final int t = tail;
        final int front = (i - h) & mask;
        final int back  = (t - i) & mask;

        // Invariant: head <= i < tail mod circularity
        if (front >= ((t - h) & mask))
            throw new ConcurrentModificationException();

        // Optimize for least element motion
        if (front < back) {
            if (h <= i) {
                System.arraycopy(elements, h, elements, h + 1, front);
            } else { // Wrap around
                System.arraycopy(elements, 0, elements, 1, i);
                elements[0] = elements[mask];
                System.arraycopy(elements, h, elements, h + 1, mask - h);
            }
            elements[h] = null;
            head = (h + 1) & mask;
            return false;
        } else {
            if (i < t) { // Copy the null tail as well
                System.arraycopy(elements, i + 1, elements, i, back);
                tail = t - 1;
            } else { // Wrap around
                System.arraycopy(elements, i + 1, elements, i, mask - i);
                elements[mask] = elements[0];
                System.arraycopy(elements, 1, elements, 0, t);
                tail = (t - 1) & mask;
            }
            return true;
        }
    }

    // *** Collection Methods ***

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.478 -0500", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "7FAD54397B43C86DCD5A7A4349735CAE")
    
public int size() {
        return (tail - head) & (elements.length - 1);
    }

    /**
     * Returns <tt>true</tt> if this deque contains no elements.
     *
     * @return <tt>true</tt> if this deque contains no elements
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.480 -0500", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "1EAFA6B363821B49200357A12D6C9ECB")
    
public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Returns an iterator over the elements in this deque.  The elements
     * will be ordered from first (head) to last (tail).  This is the same
     * order that elements would be dequeued (via successive calls to
     * {@link #remove} or popped (via successive calls to {@link #pop}).
     *
     * @return an iterator over the elements in this deque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.483 -0500", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "42CC1BF67230F6FEE01F919C054C1B03")
    
public Iterator<E> iterator() {
        return new DeqIterator();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.485 -0500", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "DF2DCA109E7F97F8219DD979442A2134")
    
public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    /**
     * Returns <tt>true</tt> if this deque contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this deque contains
     * at least one element <tt>e</tt> such that <tt>o.equals(e)</tt>.
     *
     * @param o object to be checked for containment in this deque
     * @return <tt>true</tt> if this deque contains the specified element
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.526 -0500", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "3845385B9FADAA47A4B502A9AE94271B")
    
public boolean contains(Object o) {
        if (o == null)
            return false;
        int mask = elements.length - 1;
        int i = head;
        E x;
        while ( (x = elements[i]) != null) {
            if (o.equals(x))
                return true;
            i = (i + 1) & mask;
        }
        return false;
    }

    /**
     * Removes a single instance of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element <tt>e</tt> such that
     * <tt>o.equals(e)</tt> (if such an element exists).
     * Returns <tt>true</tt> if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * <p>This method is equivalent to {@link #removeFirstOccurrence}.
     *
     * @param o element to be removed from this deque, if present
     * @return <tt>true</tt> if this deque contained the specified element
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.528 -0500", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "67436633CF4F0B184E774FE8B1646BF7")
    
public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * Removes all of the elements from this deque.
     * The deque will be empty after this call returns.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.531 -0500", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "D50F57134197BEE6FB2911B164F0AB96")
    
public void clear() {
        int h = head;
        int t = tail;
        if (h != t) { // clear all cells
            head = tail = 0;
            int i = h;
            int mask = elements.length - 1;
            do {
                elements[i] = null;
                i = (i + 1) & mask;
            } while (i != t);
        }
    }

    /**
     * Returns an array containing all of the elements in this deque
     * in proper sequence (from first to last element).
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.533 -0500", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "41D29D99AB26FD6A8622374ECAAA3B64")
    
public Object[] toArray() {
        return copyElements(new Object[size()]);
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.744 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "06E5913149E402B6AB4BF8BCBD73C8FC")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        int size = size();
        if(a.length < size)        
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        if(a.length > size)        
        a[size] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_87702147 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_87702147.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_87702147;
        // ---------- Original Method ----------
        //int size = size();
        //if (a.length < size)
            //a = (T[])java.lang.reflect.Array.newInstance(
                    //a.getClass().getComponentType(), size);
        //copyElements(a);
        //if (a.length > size)
            //a[size] = null;
        //return a;
    }

    // *** Object methods ***

    /**
     * Returns a copy of this deque.
     *
     * @return a copy of this deque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.537 -0500", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "AB2508B38E8C1608EABB345765468735")
    
public ArrayDeque<E> clone() {
        try {
            ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
            return result;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    private class DeqIterator implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.488 -0500", hash_original_field = "C2F8ABCBCF42E4DD9BE7A8903244BCB5", hash_generated_field = "44DF51687F75FF9B360C641B654097EA")

        private int cursor = head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.491 -0500", hash_original_field = "FA17B216C1ADDC053B56E89EEBAC8C21", hash_generated_field = "CD264196D1FE9C34BAABF3EB22B1DEF4")

        private int fence = tail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.494 -0500", hash_original_field = "9128B9A3EF0151CBF070702BF3C62C66", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.749 -0400", hash_original_method = "8F728FEBD0A799A5BB08E38FDCDEB966", hash_generated_method = "8F728FEBD0A799A5BB08E38FDCDEB966")
        public DeqIterator ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.496 -0500", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "14F395F1FB532AA100EDE22B37B73640")
        
public boolean hasNext() {
            return cursor != fence;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.498 -0500", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "9478BC2439BF4281FF464F7B91049C65")
        
public E next() {
            if (cursor == fence)
                throw new NoSuchElementException();
            E result = elements[cursor];
            // This check doesn't catch all possible comodifications,
            // but does catch the ones that corrupt traversal
            if (tail != fence || result == null)
                throw new ConcurrentModificationException();
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.501 -0500", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "1A6384CA52F898C554E9D51E252271AD")
        
public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            if (delete(lastRet)) { // if left-shifted, undo increment in next()
                cursor = (cursor - 1) & (elements.length - 1);
                fence = tail;
            }
            lastRet = -1;
        }
        
    }
    
    private class DescendingIterator implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.507 -0500", hash_original_field = "F1C9B03A213CA00D0DD27DF17F2962FE", hash_generated_field = "9C757AFC9A7098F996E37879537F5728")

        private int cursor = tail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.510 -0500", hash_original_field = "4C3AEA0997E028616987716396A36DD3", hash_generated_field = "EB9AC1D6784E298C35CBEF17C766890F")

        private int fence = head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.513 -0500", hash_original_field = "9128B9A3EF0151CBF070702BF3C62C66", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.751 -0400", hash_original_method = "EFD23C54297A65B9A603FACFE0E34AA6", hash_generated_method = "EFD23C54297A65B9A603FACFE0E34AA6")
        public DescendingIterator ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.515 -0500", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "14F395F1FB532AA100EDE22B37B73640")
        
public boolean hasNext() {
            return cursor != fence;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.518 -0500", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "BB66E305793B464C8437CE6ADB8BA16A")
        
public E next() {
            if (cursor == fence)
                throw new NoSuchElementException();
            cursor = (cursor - 1) & (elements.length - 1);
            E result = elements[cursor];
            if (head != fence || result == null)
                throw new ConcurrentModificationException();
            lastRet = cursor;
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.520 -0500", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "1E8559E3007914F062C8C373AC943D56")
        
public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            if (!delete(lastRet)) {
                cursor = (cursor + 1) & (elements.length - 1);
                fence = head;
            }
            lastRet = -1;
        }
        
    }

    /**
     * Serialize this deque.
     *
     * @serialData The current size (<tt>int</tt>) of the deque,
     * followed by all of its elements (each an object reference) in
     * first-to-last order.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.543 -0500", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "5B39CF3A953CC5CBC19C522FEA0C7488")
    
private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        // Write out size
        s.writeInt(size());

        // Write out elements in order.
        int mask = elements.length - 1;
        for (int i = head; i != tail; i = (i + 1) & mask)
            s.writeObject(elements[i]);
    }

    /**
     * Deserialize this deque.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.546 -0500", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "9AA95114BF009330E84F00F61CE83031")
    
private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        // Read in size and allocate array
        int size = s.readInt();
        allocateElements(size);
        head = 0;
        tail = size;

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++)
            elements[i] = (E)s.readObject();
    }
}

