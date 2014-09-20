/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

// BEGIN android-note
// removed link to collections framework docs
// END android-note

/**
 * An unbounded {@linkplain BlockingQueue blocking queue} that uses
 * the same ordering rules as class {@link PriorityQueue} and supplies
 * blocking retrieval operations.  While this queue is logically
 * unbounded, attempted additions may fail due to resource exhaustion
 * (causing {@code OutOfMemoryError}). This class does not permit
 * {@code null} elements.  A priority queue relying on {@linkplain
 * Comparable natural ordering} also does not permit insertion of
 * non-comparable objects (doing so results in
 * {@code ClassCastException}).
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.  The Iterator provided in method {@link
 * #iterator()} is <em>not</em> guaranteed to traverse the elements of
 * the PriorityBlockingQueue in any particular order. If you need
 * ordered traversal, consider using
 * {@code Arrays.sort(pq.toArray())}.  Also, method {@code drainTo}
 * can be used to <em>remove</em> some or all elements in priority
 * order and place them in another collection.
 *
 * <p>Operations on this class make no guarantees about the ordering
 * of elements with equal priority. If you need to enforce an
 * ordering, you can define custom classes or comparators that use a
 * secondary key to break ties in primary priority values.  For
 * example, here is a class that applies first-in-first-out
 * tie-breaking to comparable elements. To use it, you would insert a
 * {@code new FIFOEntry(anEntry)} instead of a plain entry object.
 *
 *  <pre> {@code
 * class FIFOEntry<E extends Comparable<? super E>>
 *     implements Comparable<FIFOEntry<E>> {
 *   static final AtomicLong seq = new AtomicLong(0);
 *   final long seqNum;
 *   final E entry;
 *   public FIFOEntry(E entry) {
 *     seqNum = seq.getAndIncrement();
 *     this.entry = entry;
 *   }
 *   public E getEntry() { return entry; }
 *   public int compareTo(FIFOEntry<E> other) {
 *     int res = entry.compareTo(other.entry);
 *     if (res == 0 && other.entry != this.entry)
 *       res = (seqNum < other.seqNum ? -1 : 1);
 *     return res;
 *   }
 * }}</pre>
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
@SuppressWarnings("unchecked")
public class PriorityBlockingQueue<E> extends AbstractQueue<E>
    implements BlockingQueue<E>, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.691 -0400", hash_original_field = "0A951697462A337B75D6D75365727486", hash_generated_field = "811DD10CE0D7C0A698CE066ABFB4BD09")

    private static final long serialVersionUID = 5595510919245408276L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.692 -0400", hash_original_field = "20CF5A9DE6923AB9AA9B43A7EED465FC", hash_generated_field = "85B516297E09015E5D3C0754FE73505C")


    /**
     * Default array capacity.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.692 -0400", hash_original_field = "C76E68A693B15D09286A26B80DD2C7EA", hash_generated_field = "FA2406BBBB27AB0C01366DB7BFD361CA")

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * To simplify and speed up coercions and comparisons. the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     * These methods are static, with heap state as arguments, to
     * simplify use in light of possible comparator exceptions.
     *
     * @param k the position to fill
     * @param x the item to insert
     * @param array the heap array
     */
    private static <T> void siftUpComparable(int k, T x, Object[] array) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = array[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            array[k] = e;
            k = parent;
        }
        array[k] = key;
    }

    private static <T> void siftUpUsingComparator(int k, T x, Object[] array,
                                       Comparator<? super T> cmp) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = array[parent];
            if (cmp.compare(x, (T) e) >= 0)
                break;
            array[k] = e;
            k = parent;
        }
        array[k] = x;
    }

    /**
     * Inserts item x at position k, maintaining heap invariant by
     * demoting x down the tree repeatedly until it is less than or
     * equal to its children or is a leaf.
     *
     * @param k the position to fill
     * @param x the item to insert
     * @param array the heap array
     * @param n heap size
     */
    private static <T> void siftDownComparable(int k, T x, Object[] array,
                                               int n) {
        if (n > 0) {
            Comparable<? super T> key = (Comparable<? super T>)x;
            int half = n >>> 1;           // loop while a non-leaf
            while (k < half) {
                int child = (k << 1) + 1; // assume left child is least
                Object c = array[child];
                int right = child + 1;
                if (right < n &&
                    ((Comparable<? super T>) c).compareTo((T) array[right]) > 0)
                    c = array[child = right];
                if (key.compareTo((T) c) <= 0)
                    break;
                array[k] = c;
                k = child;
            }
            array[k] = key;
        }
    }

    private static <T> void siftDownUsingComparator(int k, T x, Object[] array,
                                                    int n,
                                                    Comparator<? super T> cmp) {
        if (n > 0) {
            int half = n >>> 1;
            while (k < half) {
                int child = (k << 1) + 1;
                Object c = array[child];
                int right = child + 1;
                if (right < n && cmp.compare((T) c, (T) array[right]) > 0)
                    c = array[child = right];
                if (cmp.compare(x, (T) c) <= 0)
                    break;
                array[k] = c;
                k = child;
            }
            array[k] = x;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.719 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

    private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.719 -0400", hash_original_field = "71A091A8435B107ADBC230AA96DA7B07", hash_generated_field = "A13187DA8A7DB587AFC159EF969E97FB")

    private static  long allocationSpinLockOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.693 -0400", hash_original_field = "E9C4A342EAC2A72A804E74A87F8B89E3", hash_generated_field = "BA6E9BA522BED220E542D0B7B7CCF63A")

    private transient Object[] queue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.693 -0400", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.693 -0400", hash_original_field = "8A6D4A83EE849067F115B399ECC3CAB1", hash_generated_field = "5D5D7D779E97F5198B6F4EBA3322C270")

    private transient Comparator<? super E> comparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.694 -0400", hash_original_field = "684903DA26FF3CD98DD43FF6C66C5020", hash_generated_field = "DFE928B318585A72A4580EF29A43B994")

    private  ReentrantLock lock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.694 -0400", hash_original_field = "3FEF871F6B25ED22395C8C69263C4728", hash_generated_field = "6208B332BB61DB5EFD3387E35BF3069A")

    private  Condition notEmpty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.695 -0400", hash_original_field = "C7700BC5A90578927B7863B93E15BC76", hash_generated_field = "36643E2CE9D2E85479B8D7D985E5BE19")

    private transient volatile int allocationSpinLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.695 -0400", hash_original_field = "05815EDC2891480A07AFE6D3DA9C63BF", hash_generated_field = "1CD0E79330E51FE172B8E2089B627734")

    private PriorityQueue<E> q;

    /**
     * Creates a {@code PriorityBlockingQueue} with the default
     * initial capacity (11) that orders its elements according to
     * their {@linkplain Comparable natural ordering}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.695 -0400", hash_original_method = "7097644646C71112C54FBC7AFE99B502", hash_generated_method = "E02ACDA2BFF8F7D939439CE38DC1CC4B")
    
public PriorityBlockingQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    /**
     * Creates a {@code PriorityBlockingQueue} with the specified
     * initial capacity that orders its elements according to their
     * {@linkplain Comparable natural ordering}.
     *
     * @param initialCapacity the initial capacity for this priority queue
     * @throws IllegalArgumentException if {@code initialCapacity} is less
     *         than 1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.696 -0400", hash_original_method = "9FD50C62507B9B1E2683A0AA12E68611", hash_generated_method = "DB69939E215E21FA9F1AE3F98141614D")
    
public PriorityBlockingQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    /**
     * Creates a {@code PriorityBlockingQueue} with the specified initial
     * capacity that orders its elements according to the specified
     * comparator.
     *
     * @param initialCapacity the initial capacity for this priority queue
     * @param  comparator the comparator that will be used to order this
     *         priority queue.  If {@code null}, the {@linkplain Comparable
     *         natural ordering} of the elements will be used.
     * @throws IllegalArgumentException if {@code initialCapacity} is less
     *         than 1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.696 -0400", hash_original_method = "DD3F77DD82D0390F8152735FEB2697B3", hash_generated_method = "0155520B4A75E151D70340AFA43BDF32")
    
public PriorityBlockingQueue(int initialCapacity,
                                 Comparator<? super E> comparator) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.comparator = comparator;
        this.queue = new Object[initialCapacity];
    }

    /**
     * Creates a {@code PriorityBlockingQueue} containing the elements
     * in the specified collection.  If the specified collection is a
     * {@link SortedSet} or a {@link PriorityQueue},  this
     * priority queue will be ordered according to the same ordering.
     * Otherwise, this priority queue will be ordered according to the
     * {@linkplain Comparable natural ordering} of its elements.
     *
     * @param  c the collection whose elements are to be placed
     *         into this priority queue
     * @throws ClassCastException if elements of the specified collection
     *         cannot be compared to one another according to the priority
     *         queue's ordering
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.698 -0400", hash_original_method = "39ADFE75332ACE4FAADBC9E7644F48C0", hash_generated_method = "BA7D65F03C2D86DFE179FA7455F618D0")
    
public PriorityBlockingQueue(Collection<? extends E> c) {
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        boolean heapify = true; // true if not known to be in heap order
        boolean screen = true;  // true if must screen for nulls
        if (c instanceof SortedSet<?>) {
            SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
            this.comparator = (Comparator<? super E>) ss.comparator();
            heapify = false;
        }
        else if (c instanceof PriorityBlockingQueue<?>) {
            PriorityBlockingQueue<? extends E> pq =
                (PriorityBlockingQueue<? extends E>) c;
            this.comparator = (Comparator<? super E>) pq.comparator();
            screen = false;
            if (pq.getClass() == PriorityBlockingQueue.class) // exact match
                heapify = false;
        }
        Object[] a = c.toArray();
        int n = a.length;
        // If c.toArray incorrectly doesn't return Object[], copy it.
        if (a.getClass() != Object[].class)
            a = Arrays.copyOf(a, n, Object[].class);
        if (screen && (n == 1 || this.comparator != null)) {
            for (int i = 0; i < n; ++i)
                if (a[i] == null)
                    throw new NullPointerException();
        }
        this.queue = a;
        this.size = n;
        if (heapify)
            heapify();
    }

    /**
     * Tries to grow array to accommodate at least one more element
     * (but normally expand by about 50%), giving up (allowing retry)
     * on contention (which we expect to be rare). Call only while
     * holding lock.
     *
     * @param array the heap array
     * @param oldCap the length of the array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.698 -0400", hash_original_method = "4FD20927C2E38EB86416DF04242C2C20", hash_generated_method = "6D228AD5403D64D87AD2A559B240F277")
    
private void tryGrow(Object[] array, int oldCap) {
        lock.unlock(); // must release and then re-acquire main lock
        Object[] newArray = null;
        if (allocationSpinLock == 0 &&
            UNSAFE.compareAndSwapInt(this, allocationSpinLockOffset,
                                     0, 1)) {
            try {
                int newCap = oldCap + ((oldCap < 64) ?
                                       (oldCap + 2) : // grow faster if small
                                       (oldCap >> 1));
                if (newCap - MAX_ARRAY_SIZE > 0) {    // possible overflow
                    int minCap = oldCap + 1;
                    if (minCap < 0 || minCap > MAX_ARRAY_SIZE)
                        throw new OutOfMemoryError();
                    newCap = MAX_ARRAY_SIZE;
                }
                if (newCap > oldCap && queue == array)
                    newArray = new Object[newCap];
            } finally {
                allocationSpinLock = 0;
            }
        }
        if (newArray == null) // back off if another thread is allocating
            Thread.yield();
        lock.lock();
        if (newArray != null && queue == array) {
            queue = newArray;
            System.arraycopy(array, 0, newArray, 0, oldCap);
        }
    }

    /**
     * Mechanics for poll().  Call only while holding lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.700 -0400", hash_original_method = "A2516B3812C963387C40C18723815185", hash_generated_method = "D7D63D77D784D0605D795F5ECDE2F841")
    
private E dequeue() {
        int n = size - 1;
        if (n < 0)
            return null;
        else {
            Object[] array = queue;
            E result = (E) array[0];
            E x = (E) array[n];
            array[n] = null;
            Comparator<? super E> cmp = comparator;
            if (cmp == null)
                siftDownComparable(0, x, array, n);
            else
                siftDownUsingComparator(0, x, array, n, cmp);
            size = n;
            return result;
        }
    }

    /**
     * Establishes the heap invariant (described above) in the entire tree,
     * assuming nothing about the order of the elements prior to the call.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.702 -0400", hash_original_method = "EE7D24D9E196708648F7B6757F98A148", hash_generated_method = "0C5935FE6BFAC081460AB6D04D25D4FF")
    
private void heapify() {
        Object[] array = queue;
        int n = size;
        int half = (n >>> 1) - 1;
        Comparator<? super E> cmp = comparator;
        if (cmp == null) {
            for (int i = half; i >= 0; i--)
                siftDownComparable(i, (E) array[i], array, n);
        }
        else {
            for (int i = half; i >= 0; i--)
                siftDownUsingComparator(i, (E) array[i], array, n, cmp);
        }
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws ClassCastException if the specified element cannot be compared
     *         with elements currently in the priority queue according to the
     *         priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.703 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "5AEDC89A183EF5E6538093DA8AE2F21F")
    
public boolean add(E e) {
        return offer(e);
    }

    /**
     * Inserts the specified element into this priority queue.
     * As the queue is unbounded, this method will never return {@code false}.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws ClassCastException if the specified element cannot be compared
     *         with elements currently in the priority queue according to the
     *         priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.703 -0400", hash_original_method = "775A55093A20D9C3EB5D5F7F7F70C525", hash_generated_method = "A5CEE207B5BB001A0040D0672FD5E2F8")
    
public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        final ReentrantLock lock = this.lock;
        lock.lock();
        int n, cap;
        Object[] array;
        while ((n = size) >= (cap = (array = queue).length))
            tryGrow(array, cap);
        try {
            Comparator<? super E> cmp = comparator;
            if (cmp == null)
                siftUpComparable(n, e, array);
            else
                siftUpUsingComparator(n, e, array, cmp);
            size = n + 1;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        return true;
    }

    /**
     * Inserts the specified element into this priority queue.
     * As the queue is unbounded, this method will never block.
     *
     * @param e the element to add
     * @throws ClassCastException if the specified element cannot be compared
     *         with elements currently in the priority queue according to the
     *         priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.704 -0400", hash_original_method = "C9D180903A7CC0CD8F17729AA0E80F49", hash_generated_method = "5306CC2905386E87E60064522DE0CAF1")
    
public void put(E e) {
        offer(e); // never need to block
    }

    /**
     * Inserts the specified element into this priority queue.
     * As the queue is unbounded, this method will never block or
     * return {@code false}.
     *
     * @param e the element to add
     * @param timeout This parameter is ignored as the method never blocks
     * @param unit This parameter is ignored as the method never blocks
     * @return {@code true} (as specified by
     *  {@link BlockingQueue#offer(Object,long,TimeUnit) BlockingQueue.offer})
     * @throws ClassCastException if the specified element cannot be compared
     *         with elements currently in the priority queue according to the
     *         priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.704 -0400", hash_original_method = "BFDD71499687D637F57FF5151EA7665D", hash_generated_method = "EE0C0B08C755E1765F0560A66A1B5024")
    
public boolean offer(E e, long timeout, TimeUnit unit) {
        return offer(e); // never need to block
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.705 -0400", hash_original_method = "59D0010E7EBBB06B90B045B323E3F663", hash_generated_method = "7BDE1A32D53CC383D4CD0B7886EDC3CE")
    
public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.705 -0400", hash_original_method = "08C75D347B84BC2555A313E86C64A028", hash_generated_method = "5C4027A4A241EAA34D9D05A9547FB742")
    
public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        E result;
        try {
            while ( (result = dequeue()) == null)
                notEmpty.await();
        } finally {
            lock.unlock();
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.706 -0400", hash_original_method = "672B1E53046918F59D0E7B1072E51CC3", hash_generated_method = "C0A001B22CC1792119614E726D1B5B76")
    
public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        E result;
        try {
            while ( (result = dequeue()) == null && nanos > 0)
                nanos = notEmpty.awaitNanos(nanos);
        } finally {
            lock.unlock();
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.706 -0400", hash_original_method = "4F5492299324118E21582D0DF3C46716", hash_generated_method = "BED98FA652DAD0DA7040918FC0654DE3")
    
public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (size == 0) ? null : (E) queue[0];
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns the comparator used to order the elements in this queue,
     * or {@code null} if this queue uses the {@linkplain Comparable
     * natural ordering} of its elements.
     *
     * @return the comparator used to order the elements in this queue,
     *         or {@code null} if this queue uses the natural
     *         ordering of its elements
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.706 -0400", hash_original_method = "83ACC201A16F2FDDF97B6B07FFFB2168", hash_generated_method = "8947A54D644B196B7F9AE181D44586AE")
    
public Comparator<? super E> comparator() {
        return comparator;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.707 -0400", hash_original_method = "FB53A461CD3B1BACC3DB27D415F5CC64", hash_generated_method = "B56E45E790072F25BF00ED5C82A3937D")
    
public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Always returns {@code Integer.MAX_VALUE} because
     * a {@code PriorityBlockingQueue} is not capacity constrained.
     * @return {@code Integer.MAX_VALUE} always
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.707 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "33BD29B45C0B302F31D1F275110E0FF5")
    
public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.708 -0400", hash_original_method = "EC3B7D586FF4D36081EA6F7D19ADE62F", hash_generated_method = "4E6D4AD5E80133F9EF1D69CDAC1F00A9")
    
private int indexOf(Object o) {
        if (o != null) {
            Object[] array = queue;
            int n = size;
            for (int i = 0; i < n; i++)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Removes the ith element from queue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.708 -0400", hash_original_method = "9D73270D970CE651CDDED76CEC412EF8", hash_generated_method = "872CEA5703FF32831EF4AB7103C20BC2")
    
private void removeAt(int i) {
        Object[] array = queue;
        int n = size - 1;
        if (n == i) // removed last element
            array[i] = null;
        else {
            E moved = (E) array[n];
            array[n] = null;
            Comparator<? super E> cmp = comparator;
            if (cmp == null)
                siftDownComparable(i, moved, array, n);
            else
                siftDownUsingComparator(i, moved, array, n, cmp);
            if (array[i] == moved) {
                if (cmp == null)
                    siftUpComparable(i, moved, array);
                else
                    siftUpUsingComparator(i, moved, array, cmp);
            }
        }
        size = n;
    }

    /**
     * Removes a single instance of the specified element from this queue,
     * if it is present.  More formally, removes an element {@code e} such
     * that {@code o.equals(e)}, if this queue contains one or more such
     * elements.  Returns {@code true} if and only if this queue contained
     * the specified element (or equivalently, if this queue changed as a
     * result of the call).
     *
     * @param o element to be removed from this queue, if present
     * @return {@code true} if this queue changed as a result of the call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.709 -0400", hash_original_method = "1B3DD0BFA7256BBA6CA6FFDADC947234", hash_generated_method = "6D3C37DB5B2039DEEDE722745F40A0C3")
    
public boolean remove(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int i = indexOf(o);
            if (i == -1)
                return false;
            removeAt(i);
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Identity-based version for use in Itr.remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.709 -0400", hash_original_method = "4DEFC33B4F4669D519B2C732A89B9C70", hash_generated_method = "4DEFC33B4F4669D519B2C732A89B9C70")
    
void removeEQ(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] array = queue;
            for (int i = 0, n = size; i < n; i++) {
                if (o == array[i]) {
                    removeAt(i);
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns {@code true} if this queue contains the specified element.
     * More formally, returns {@code true} if and only if this queue contains
     * at least one element {@code e} such that {@code o.equals(e)}.
     *
     * @param o object to be checked for containment in this queue
     * @return {@code true} if this queue contains the specified element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.710 -0400", hash_original_method = "E861F89903D743D843110F1384A3CD98", hash_generated_method = "0DD579FBC583A3DEF0A176F9F41AE8C6")
    
public boolean contains(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return indexOf(o) != -1;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns an array containing all of the elements in this queue.
     * The returned array elements are in no particular order.
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this queue.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.710 -0400", hash_original_method = "8A09FBF09ED2852585642BCE8CE60ACB", hash_generated_method = "891D10478196629BFF2049839AF1F4C7")
    
public Object[] toArray() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return Arrays.copyOf(queue, size);
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.711 -0400", hash_original_method = "6AA104B626560293168E68B9AD148A59", hash_generated_method = "B709C64FA7EDA0A0F5FFC4988FF4BD43")
    
public String toString() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n = size;
            if (n == 0)
                return "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < n; ++i) {
                Object e = queue[i];
                sb.append(e == this ? "(this Collection)" : e);
                if (i != n - 1)
                    sb.append(',').append(' ');
            }
            return sb.append(']').toString();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.711 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "EB9FFDC2CB18F728010F3227114BF0A5")
    
public int drainTo(Collection<? super E> c) {
        return drainTo(c, Integer.MAX_VALUE);
    }

    /**
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.712 -0400", hash_original_method = "CA2EA4BBDBFEB6FE1F91637E1D111CDF", hash_generated_method = "752791354A95F446001EE282DC69C9F8")
    
public int drainTo(Collection<? super E> c, int maxElements) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        if (maxElements <= 0)
            return 0;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n = Math.min(size, maxElements);
            for (int i = 0; i < n; i++) {
                c.add((E) queue[0]); // In this order, in case add() throws.
                dequeue();
            }
            return n;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Atomically removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.712 -0400", hash_original_method = "D7ED8780EA10829FC69FCC0BE368EAAC", hash_generated_method = "81445DFC34CE6798AF01D55349AA8152")
    
public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] array = queue;
            int n = size;
            size = 0;
            for (int i = 0; i < n; i++)
                array[i] = null;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Snapshot iterator that works off copy of underlying q array.
     */
    final class Itr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.714 -0400", hash_original_field = "3E4C52F6F0428C39E4E692D20A9AA9AA", hash_generated_field = "3E4C52F6F0428C39E4E692D20A9AA9AA")

         Object[] array;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.715 -0400", hash_original_field = "574451AF3BDD0EC887A8F04530DC95F1", hash_generated_field = "574451AF3BDD0EC887A8F04530DC95F1")

        int cursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.715 -0400", hash_original_field = "8BE11FCC759F9AA5663F1AF67D0DDBCD", hash_generated_field = "8BE11FCC759F9AA5663F1AF67D0DDBCD")

        int lastRet;          // index of last element, or -1 if no such

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.715 -0400", hash_original_method = "3D5D0E3420638FA7514533715C7FD5D4", hash_generated_method = "3D5D0E3420638FA7514533715C7FD5D4")
        
Itr(Object[] array) {
            lastRet = -1;
            this.array = array;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.716 -0400", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "CDE3CA7472C460360713EEDFAECC9D23")
        
public boolean hasNext() {
            return cursor < array.length;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.716 -0400", hash_original_method = "F81A0847679B1E16464240B404F27074", hash_generated_method = "8446C6F9F74FBCE3BB1FF3FD70990E1D")
        
public E next() {
            if (cursor >= array.length)
                throw new NoSuchElementException();
            lastRet = cursor;
            return (E)array[cursor++];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.717 -0400", hash_original_method = "1F047BB3E034A57C737F1A0202C892CE", hash_generated_method = "B4834007EE8190B0571AD4806F849A99")
        
public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            removeEQ(array[lastRet]);
            lastRet = -1;
        }
    }

    /**
     * Returns an array containing all of the elements in this queue; the
     * runtime type of the returned array is that of the specified array.
     * The returned array elements are in no particular order.
     * If the queue fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this queue.
     *
     * <p>If this queue fits in the specified array with room to spare
     * (i.e., the array has more elements than this queue), the element in
     * the array immediately following the end of the queue is set to
     * {@code null}.
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose {@code x} is a queue known to contain only strings.
     * The following code can be used to dump the queue into a newly
     * allocated array of {@code String}:
     *
     *  <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
     *
     * Note that {@code toArray(new Object[0])} is identical in function to
     * {@code toArray()}.
     *
     * @param a the array into which the elements of the queue are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose
     * @return an array containing all of the elements in this queue
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this queue
     * @throws NullPointerException if the specified array is null
     */
    public <T> T[] toArray(T[] a) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n = size;
            if (a.length < n)
                // Make a new array of a's runtime type, but my contents:
                return (T[]) Arrays.copyOf(queue, size, a.getClass());
            System.arraycopy(queue, 0, a, 0, n);
            if (a.length > n)
                a[n] = null;
            return a;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns an iterator over the elements in this queue. The
     * iterator does not return the elements in any particular order.
     *
     * <p>The returned iterator is a "weakly consistent" iterator that
     * will never throw {@link java.util.ConcurrentModificationException
     * ConcurrentModificationException}, and guarantees to traverse
     * elements as they existed upon construction of the iterator, and
     * may (but is not guaranteed to) reflect any modifications
     * subsequent to construction.
     *
     * @return an iterator over the elements in this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.714 -0400", hash_original_method = "42CB3EDA719DA2D528DF0D9481F5BC1E", hash_generated_method = "65282ABD79DA1B1618CD7D7834524202")
    
public Iterator<E> iterator() {
        return new Itr(toArray());
    }

    /**
     * Saves this queue to a stream (that is, serializes it).
     *
     * For compatibility with previous version of this class, elements
     * are first copied to a java.util.PriorityQueue, which is then
     * serialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.718 -0400", hash_original_method = "F95CEBBCA311BD93B971DCD0A421E5DC", hash_generated_method = "3DE9CC338BC26C5299037CD3D98482D5")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        lock.lock();
        try {
            // avoid zero capacity argument
            q = new PriorityQueue<E>(Math.max(size, 1), comparator);
            q.addAll(this);
            s.defaultWriteObject();
        } finally {
            q = null;
            lock.unlock();
        }
    }

    /**
     * Reconstitutes this queue from a stream (that is, deserializes it).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:14.718 -0400", hash_original_method = "29A8172D11EE1F6C2B41EDC469205BD4", hash_generated_method = "59F81D826E94B385983D565339AE7DB1")
    
private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        try {
            s.defaultReadObject();
            this.queue = new Object[q.size()];
            comparator = q.comparator();
            addAll(q);
        } finally {
            q = null;
        }
    }
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = PriorityBlockingQueue.class;
            allocationSpinLockOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("allocationSpinLock"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
