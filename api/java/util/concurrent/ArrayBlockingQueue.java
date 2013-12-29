package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;






public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    static <E> E cast(Object item) {
        return (E) item;
    }

    /**
     * Throws NullPointerException if argument is null.
     *
     * @param v the element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.836 -0500", hash_original_method = "BBA8F566F6EBBAE4E624DE5E2288492A", hash_generated_method = "5E8CAC32EF86836AAB409F83647A3C3E")
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.826 -0500", hash_original_field = "F04C226C8AA44F8A580B9E40EF820A64", hash_generated_field = "0F849197A37E65A00343ED59063639C5")

    private static final long serialVersionUID = -817911632652898426L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.827 -0500", hash_original_field = "BAB14770993D8E8C5F571816E68BB451", hash_generated_field = "BAB14770993D8E8C5F571816E68BB451")

     Object[] items;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.828 -0500", hash_original_field = "155CD9B83999F44788DDAFF138F1D62C", hash_generated_field = "155CD9B83999F44788DDAFF138F1D62C")

    int takeIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.829 -0500", hash_original_field = "C304AC129AAA2CC4EBBA14BAA5601D08", hash_generated_field = "C304AC129AAA2CC4EBBA14BAA5601D08")

    int putIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.830 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

    int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.830 -0500", hash_original_field = "684903DA26FF3CD98DD43FF6C66C5020", hash_generated_field = "FDF5D711B301AAD6E43D42E6280BCF83")


    /** Main lock guarding all access */
     ReentrantLock lock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.831 -0500", hash_original_field = "3FEF871F6B25ED22395C8C69263C4728", hash_generated_field = "6208B332BB61DB5EFD3387E35BF3069A")

    private  Condition notEmpty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.832 -0500", hash_original_field = "0DC277B9B63B9C555E751FDC05B97159", hash_generated_field = "9BD2EF78405D878781918D2C46F5ACCE")

    private  Condition notFull;

    /**
     * Creates an {@code ArrayBlockingQueue} with the given (fixed)
     * capacity and default access policy.
     *
     * @param capacity the capacity of this queue
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.840 -0500", hash_original_method = "989EAF8314C95E2BC3034097E1831933", hash_generated_method = "2C52861D2300CD5655FBC5D396102FAF")
    public ArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }

    /**
     * Creates an {@code ArrayBlockingQueue} with the given (fixed)
     * capacity and the specified access policy.
     *
     * @param capacity the capacity of this queue
     * @param fair if {@code true} then queue accesses for threads blocked
     *        on insertion or removal, are processed in FIFO order;
     *        if {@code false} the access order is unspecified.
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.841 -0500", hash_original_method = "D00F5C645B4A4E3D47EB794330FD0093", hash_generated_method = "0066915398E1BE14FB4EAD0DF7E0B621")
    public ArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }

    /**
     * Creates an {@code ArrayBlockingQueue} with the given (fixed)
     * capacity, the specified access policy and initially containing the
     * elements of the given collection,
     * added in traversal order of the collection's iterator.
     *
     * @param capacity the capacity of this queue
     * @param fair if {@code true} then queue accesses for threads blocked
     *        on insertion or removal, are processed in FIFO order;
     *        if {@code false} the access order is unspecified.
     * @param c the collection of elements to initially contain
     * @throws IllegalArgumentException if {@code capacity} is less than
     *         {@code c.size()}, or less than 1.
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.842 -0500", hash_original_method = "27F14E8862A13463ECADB9F13ABB8363", hash_generated_method = "6BD9391880E738BD4E5732E84326A7D1")
    public ArrayBlockingQueue(int capacity, boolean fair,
                              Collection<? extends E> c) {
        this(capacity, fair);

        final ReentrantLock lock = this.lock;
        lock.lock(); // Lock only for visibility, not mutual exclusion
        try {
            int i = 0;
            try {
                for (E e : c) {
                    checkNotNull(e);
                    items[i++] = e;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new IllegalArgumentException();
            }
            count = i;
            putIndex = (i == capacity) ? 0 : i;
        } finally {
            lock.unlock();
        }
    }

    // Internal helper methods

    /**
     * Circularly increment i.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.833 -0500", hash_original_method = "225BF2AA9DF4D481E4497FC0C844BC07", hash_generated_method = "19782F09BA8930DFEC3DA1762203EB56")
    final int inc(int i) {
        return (++i == items.length) ? 0 : i;
    }

    /**
     * Circularly decrement i.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.834 -0500", hash_original_method = "3E735D41E2F85E8ACC700EB7ACA7DBFD", hash_generated_method = "B3F6A2BE158A305318889C961631C794")
    final int dec(int i) {
        return ((i == 0) ? items.length : i) - 1;
    }

    /**
     * Returns item at index i.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.835 -0500", hash_original_method = "D27765FC19695D3D1037FEAF928DE057", hash_generated_method = "8B1BEE45B5D6B721C342C65FB1EE3E1A")
    final E itemAt(int i) {
        return this.<E>cast(items[i]);
    }

    /**
     * Inserts element at current put position, advances, and signals.
     * Call only when holding lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.837 -0500", hash_original_method = "7F66A086F3C39CFEE464DF3F42EF745A", hash_generated_method = "152ACD5881167BAF4D8198736BB8899F")
    private void insert(E x) {
        items[putIndex] = x;
        putIndex = inc(putIndex);
        ++count;
        notEmpty.signal();
    }

    /**
     * Extracts element at current take position, advances, and signals.
     * Call only when holding lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.838 -0500", hash_original_method = "FAA6B2CA6161B01EDCE06644087258E9", hash_generated_method = "52595FBB3CA5DCD9DAAC24C36F9F10F5")
    private E extract() {
        final Object[] items = this.items;
        E x = this.<E>cast(items[takeIndex]);
        items[takeIndex] = null;
        takeIndex = inc(takeIndex);
        --count;
        notFull.signal();
        return x;
    }

    /**
     * Deletes item at position i.
     * Utility for remove and iterator.remove.
     * Call only when holding lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.839 -0500", hash_original_method = "94E6DD980D252AA320ADEF879614EDE5", hash_generated_method = "838942D4CF7C1958BF7C064541CBB8E5")
    void removeAt(int i) {
        final Object[] items = this.items;
        // if removing front item, just advance
        if (i == takeIndex) {
            items[takeIndex] = null;
            takeIndex = inc(takeIndex);
        } else {
            // slide over all others up through putIndex.
            for (;;) {
                int nexti = inc(i);
                if (nexti != putIndex) {
                    items[i] = items[nexti];
                    i = nexti;
                } else {
                    items[i] = null;
                    putIndex = i;
                    break;
                }
            }
        }
        --count;
        notFull.signal();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is
     * possible to do so immediately without exceeding the queue's capacity,
     * returning {@code true} upon success and throwing an
     * {@code IllegalStateException} if this queue is full.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if this queue is full
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.843 -0500", hash_original_method = "656D7386EF8E1EB18507F4383E955E73", hash_generated_method = "38E1848299251A492EC5C52BCD02B8AB")
    public boolean add(E e) {
        return super.add(e);
    }

    /**
     * Inserts the specified element at the tail of this queue if it is
     * possible to do so immediately without exceeding the queue's capacity,
     * returning {@code true} upon success and {@code false} if this queue
     * is full.  This method is generally preferable to method {@link #add},
     * which can fail to insert an element only by throwing an exception.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.844 -0500", hash_original_method = "9E7F5A1AF35EF2F840CAB652EE8C4445", hash_generated_method = "1859AFB1B760971AA22F3AEF4C51CDB1")
    public boolean offer(E e) {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length)
                return false;
            else {
                insert(e);
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting
     * for space to become available if the queue is full.
     *
     * @throws InterruptedException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.844 -0500", hash_original_method = "5E01CBD1D1D4C5DC328EF4CF7109CA33", hash_generated_method = "F94E8CCB859AE7B3EAA845C3FC6659EA")
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length)
                notFull.await();
            insert(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting
     * up to the specified wait time for space to become available if
     * the queue is full.
     *
     * @throws InterruptedException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.845 -0500", hash_original_method = "B8C47E86765DFB497203F72EAEF6D248", hash_generated_method = "55F2E9D8B0B03C6A6B5FF47DDA34BEBB")
    public boolean offer(E e, long timeout, TimeUnit unit)
        throws InterruptedException {

        checkNotNull(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            insert(e);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.846 -0500", hash_original_method = "0415B543E2D9F81F71C1F297B3EB3C5B", hash_generated_method = "BA0F37CD553C57DCE977BE8A2A7576B1")
    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (count == 0) ? null : extract();
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.847 -0500", hash_original_method = "30071A1958BC767E727888E18C86B273", hash_generated_method = "239EBCAC1BA310F7200CD320FC2BABBB")
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0)
                notEmpty.await();
            return extract();
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.848 -0500", hash_original_method = "9A4759FF3B4CF20FAA7F6E911397CD3E", hash_generated_method = "B4D46D10019CAD6F53C8B287B6CB8843")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                if (nanos <= 0)
                    return null;
                nanos = notEmpty.awaitNanos(nanos);
            }
            return extract();
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.849 -0500", hash_original_method = "36198DC803CD2F28AA6354324378D8A6", hash_generated_method = "C15DA83AE88F5544BD267DBCEFE88A5D")
    public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (count == 0) ? null : itemAt(takeIndex);
        } finally {
            lock.unlock();
        }
    }

    // this doc comment is overridden to remove the reference to collections
    // greater in size than Integer.MAX_VALUE
    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.850 -0500", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "1C306A20DEB9E71EFEE80C2F18DCAEC3")
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    // this doc comment is a modified copy of the inherited doc comment,
    // without the reference to unlimited queues.
    /**
     * Returns the number of additional elements that this queue can ideally
     * (in the absence of memory or resource constraints) accept without
     * blocking. This is always equal to the initial capacity of this queue
     * less the current {@code size} of this queue.
     *
     * <p>Note that you <em>cannot</em> always tell if an attempt to insert
     * an element will succeed by inspecting {@code remainingCapacity}
     * because it may be the case that another thread is about to
     * insert or remove an element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.851 -0500", hash_original_method = "93162D5A121913041A27A55F13ABACF8", hash_generated_method = "7F87B2D7530A0155ABCBF88C33F97CEB")
    public int remainingCapacity() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return items.length - count;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Removes a single instance of the specified element from this queue,
     * if it is present.  More formally, removes an element {@code e} such
     * that {@code o.equals(e)}, if this queue contains one or more such
     * elements.
     * Returns {@code true} if this queue contained the specified element
     * (or equivalently, if this queue changed as a result of the call).
     *
     * <p>Removal of interior elements in circular array based queues
     * is an intrinsically slow and disruptive operation, so should
     * be undertaken only in exceptional circumstances, ideally
     * only when the queue is known not to be accessible by other
     * threads.
     *
     * @param o element to be removed from this queue, if present
     * @return {@code true} if this queue changed as a result of the call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.852 -0500", hash_original_method = "DAEECD7AA7FBEB0DFD3FA22914451AA9", hash_generated_method = "FC09B7D6B79E0712E9F2734D0DE24175")
    public boolean remove(Object o) {
        if (o == null) return false;
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (int i = takeIndex, k = count; k > 0; i = inc(i), k--) {
                if (o.equals(items[i])) {
                    removeAt(i);
                    return true;
                }
            }
            return false;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.852 -0500", hash_original_method = "BABF8DBF8C2C3831FF0E73AA93059482", hash_generated_method = "BAC32D41688D3585025F090BD028247E")
    public boolean contains(Object o) {
        if (o == null) return false;
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (int i = takeIndex, k = count; k > 0; i = inc(i), k--)
                if (o.equals(items[i]))
                    return true;
            return false;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns an array containing all of the elements in this queue, in
     * proper sequence.
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.853 -0500", hash_original_method = "75EA37BFFAA918A3594F9496C85F47EF", hash_generated_method = "D5FCAC53DF2CC1B2A069EBC5B89D20B4")
    public Object[] toArray() {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            final int count = this.count;
            Object[] a = new Object[count];
            for (int i = takeIndex, k = 0; k < count; i = inc(i), k++)
                a[k] = items[i];
            return a;
        } finally {
            lock.unlock();
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.290 -0400", hash_original_method = "95E1CD553E699913E584434D85EF3537", hash_generated_method = "5C2B2E0C8958A722ACF17A9AFE742A50")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            final int count = this.count;
            final int len = a.length;
            if(len < count)            
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), count);
for(int i = takeIndex, k = 0;k < count;i = inc(i),k++)
            a[k] = (T) items[i];
            if(len > count)            
            a[count] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_969682730 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_969682730.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_969682730;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //final int count = this.count;
            //final int len = a.length;
            //if (len < count)
                //a = (T[])java.lang.reflect.Array.newInstance(
                    //a.getClass().getComponentType(), count);
            //for (int i = takeIndex, k = 0; k < count; i = inc(i), k++)
                //a[k] = (T) items[i];
            //if (len > count)
                //a[count] = null;
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.856 -0500", hash_original_method = "21683449F727FF2B89133F444D211102", hash_generated_method = "9A172DEA2E16CC5D5BE11EA0B0437BBF")
    public String toString() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int k = count;
            if (k == 0)
                return "[]";

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = takeIndex; ; i = inc(i)) {
                Object e = items[i];
                sb.append(e == this ? "(this Collection)" : e);
                if (--k == 0)
                    return sb.append(']').toString();
                sb.append(',').append(' ');
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Atomically removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.857 -0500", hash_original_method = "F51B80356A627C7A0236999C18E5CD11", hash_generated_method = "9B32DD15E18B215F93A633951BC1B4CB")
    public void clear() {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (int i = takeIndex, k = count; k > 0; i = inc(i), k--)
                items[i] = null;
            count = 0;
            putIndex = 0;
            takeIndex = 0;
            notFull.signalAll();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.858 -0500", hash_original_method = "9E472A4F64A42299055CA91AF4F47C7E", hash_generated_method = "87B5CA1820C4C5D77F898FEF9E9E46FF")
    public int drainTo(Collection<? super E> c) {
        checkNotNull(c);
        if (c == this)
            throw new IllegalArgumentException();
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int i = takeIndex;
            int n = 0;
            int max = count;
            while (n < max) {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
                ++n;
            }
            if (n > 0) {
                count = 0;
                putIndex = 0;
                takeIndex = 0;
                notFull.signalAll();
            }
            return n;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.859 -0500", hash_original_method = "0815910D9B0DDA035601CF2006E12E28", hash_generated_method = "B822B89BBCFE404801B0F345B20953FE")
    public int drainTo(Collection<? super E> c, int maxElements) {
        checkNotNull(c);
        if (c == this)
            throw new IllegalArgumentException();
        if (maxElements <= 0)
            return 0;
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int i = takeIndex;
            int n = 0;
            int max = (maxElements < count) ? maxElements : count;
            while (n < max) {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
                ++n;
            }
            if (n > 0) {
                count -= n;
                takeIndex = i;
                notFull.signalAll();
            }
            return n;
        } finally {
            lock.unlock();
        }
    }

    
    private class Itr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.861 -0500", hash_original_field = "3807DA1D584295977EB0367721D9BE66", hash_generated_field = "08CB7792A99A5A14518905B73B1C610C")

        private int remaining;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.861 -0500", hash_original_field = "04911A8A6B33F6D23811475122C95D0E", hash_generated_field = "034BA54D940F805E8FC30757D561B54A")

        private int nextIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.862 -0500", hash_original_field = "FC047D97EB4DD102072D6594B14B8B33", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.863 -0500", hash_original_field = "47CEBC26AC08B3600B0A40B7CCC32373", hash_generated_field = "5341FD00C1AC5699186B67EAA1884C7B")

        private E lastItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.864 -0500", hash_original_field = "8BE11FCC759F9AA5663F1AF67D0DDBCD", hash_generated_field = "E31E901BD2416B5BAAA1A584141A7427")

        private int lastRet;   // Index of last element returned, or -1 if none

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.865 -0500", hash_original_method = "34A8A1361DC6E07DEA1D770580A406E1", hash_generated_method = "34A8A1361DC6E07DEA1D770580A406E1")
        Itr() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try {
                lastRet = -1;
                if ((remaining = count) > 0)
                    nextItem = itemAt(nextIndex = takeIndex);
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.865 -0500", hash_original_method = "BD6D3436A392753337E742307DB75B57", hash_generated_method = "15CE72712ECCDEB0AEF2B96998165717")
        public boolean hasNext() {
            return remaining > 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.866 -0500", hash_original_method = "707282FAA8902CEC9C63EE3C89931C62", hash_generated_method = "BCDD13E9C1E812E6AE4384F5C204D758")
        public E next() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try {
                if (remaining <= 0)
                    throw new NoSuchElementException();
                lastRet = nextIndex;
                E x = itemAt(nextIndex);  // check for fresher value
                if (x == null) {
                    x = nextItem;         // we are forced to report old value
                    lastItem = null;      // but ensure remove fails
                }
                else
                    lastItem = x;
                while (--remaining > 0 && // skip over nulls
                       (nextItem = itemAt(nextIndex = inc(nextIndex))) == null)
                    ;
                return x;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.867 -0500", hash_original_method = "E7345F06EBC3C2DA4E698FB7A5897ADC", hash_generated_method = "B073914706CA35E16EABFB7B3B630ABD")
        public void remove() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try {
                int i = lastRet;
                if (i == -1)
                    throw new IllegalStateException();
                lastRet = -1;
                E x = lastItem;
                lastItem = null;
                // only remove if item still at index
                if (x != null && x == items[i]) {
                    boolean removingHead = (i == takeIndex);
                    removeAt(i);
                    if (!removingHead)
                        nextIndex = dec(nextIndex);
                }
            } finally {
                lock.unlock();
            }
        }

        
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * <p>The returned {@code Iterator} is a "weakly consistent" iterator that
     * will never throw {@link java.util.ConcurrentModificationException
     * ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     *
     * @return an iterator over the elements in this queue in proper sequence
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:43.860 -0500", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "B0FB44010E28764F5FA2B4AB0E8E15C1")
    public Iterator<E> iterator() {
        return new Itr();
    }
}

