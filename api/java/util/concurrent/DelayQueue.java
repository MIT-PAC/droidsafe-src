/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

// BEGIN android-note
// removed link to collections framework docs
// END android-note

/**
 * An unbounded {@linkplain BlockingQueue blocking queue} of
 * {@code Delayed} elements, in which an element can only be taken
 * when its delay has expired.  The <em>head</em> of the queue is that
 * {@code Delayed} element whose delay expired furthest in the
 * past.  If no delay has expired there is no head and {@code poll}
 * will return {@code null}. Expiration occurs when an element's
 * {@code getDelay(TimeUnit.NANOSECONDS)} method returns a value less
 * than or equal to zero.  Even though unexpired elements cannot be
 * removed using {@code take} or {@code poll}, they are otherwise
 * treated as normal elements. For example, the {@code size} method
 * returns the count of both expired and unexpired elements.
 * This queue does not permit null elements.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.  The Iterator provided in method {@link
 * #iterator()} is <em>not</em> guaranteed to traverse the elements of
 * the DelayQueue in any particular order.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public class DelayQueue<E extends Delayed> extends AbstractQueue<E>
    implements BlockingQueue<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.004 -0400", hash_original_field = "1400DAF04929C6FE417E223B70E97891", hash_generated_field = "A91E49BA413E7F02085410707608ED76")


    private final transient ReentrantLock lock = new ReentrantLock();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.004 -0400", hash_original_field = "9D566EA2FF9C86ACD0BF46F7B00D7E29", hash_generated_field = "FD2585B260DB97BD394405070EF7C2DB")

    private final PriorityQueue<E> q = new PriorityQueue<E>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.005 -0400", hash_original_field = "32BD64945396C441E3F4E832CE5F820D", hash_generated_field = "F986E3D55ACB2544F93BB697B2C53FDD")

    private Thread leader = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.005 -0400", hash_original_field = "04965D14F491494D58AA489186AE0DED", hash_generated_field = "8F68EB44F62428E1E0B61A4952227D3F")

    private final Condition available = lock.newCondition();

    /**
     * Creates a new {@code DelayQueue} that is initially empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.006 -0400", hash_original_method = "291516209D20CCA5C9BFAB58A2163D4F", hash_generated_method = "D68A117E15D1D6C78C983E16E8589504")
    
public DelayQueue() {}

    /**
     * Creates a {@code DelayQueue} initially containing the elements of the
     * given collection of {@link Delayed} instances.
     *
     * @param c the collection of elements to initially contain
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.006 -0400", hash_original_method = "955E5773F6FB4CDFB07A42FD676F38C5", hash_generated_method = "6DADEEA97EE12AD1FADA7839F457F9B2")
    
public DelayQueue(Collection<? extends E> c) {
        this.addAll(c);
    }

    /**
     * Inserts the specified element into this delay queue.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.006 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "5AEDC89A183EF5E6538093DA8AE2F21F")
    
public boolean add(E e) {
        return offer(e);
    }

    /**
     * Inserts the specified element into this delay queue.
     *
     * @param e the element to add
     * @return {@code true}
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.007 -0400", hash_original_method = "A34146943A862D7F5ACB46C703939F78", hash_generated_method = "1263F791E1FEB254368D39F5022D013F")
    
public boolean offer(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            q.offer(e);
            if (q.peek() == e) {
                leader = null;
                available.signal();
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Inserts the specified element into this delay queue. As the queue is
     * unbounded this method will never block.
     *
     * @param e the element to add
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.007 -0400", hash_original_method = "C9D180903A7CC0CD8F17729AA0E80F49", hash_generated_method = "618E78147D566CA48083B5158FE7687B")
    
public void put(E e) {
        offer(e);
    }

    /**
     * Inserts the specified element into this delay queue. As the queue is
     * unbounded this method will never block.
     *
     * @param e the element to add
     * @param timeout This parameter is ignored as the method never blocks
     * @param unit This parameter is ignored as the method never blocks
     * @return {@code true}
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.008 -0400", hash_original_method = "BFDD71499687D637F57FF5151EA7665D", hash_generated_method = "15D875AD3B87D08D9F9ACE2C248B6583")
    
public boolean offer(E e, long timeout, TimeUnit unit) {
        return offer(e);
    }

    /**
     * Retrieves and removes the head of this queue, or returns {@code null}
     * if this queue has no elements with an expired delay.
     *
     * @return the head of this queue, or {@code null} if this
     *         queue has no elements with an expired delay
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.008 -0400", hash_original_method = "026D075C8FD008C7F68599F8D408878C", hash_generated_method = "4CAD2C4CE04F939A8ABD9D9EF7142D59")
    
public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            E first = q.peek();
            if (first == null || first.getDelay(NANOSECONDS) > 0)
                return null;
            else
                return q.poll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element with an expired delay is available on this queue.
     *
     * @return the head of this queue
     * @throws InterruptedException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.009 -0400", hash_original_method = "D6613163721C4C325796538CB0D11D1A", hash_generated_method = "00242F15393602D1E5604DA5E9B350FF")
    
public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            for (;;) {
                E first = q.peek();
                if (first == null)
                    available.await();
                else {
                    long delay = first.getDelay(NANOSECONDS);
                    if (delay <= 0)
                        return q.poll();
                    first = null; // don't retain ref while waiting
                    if (leader != null)
                        available.await();
                    else {
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            available.awaitNanos(delay);
                        } finally {
                            if (leader == thisThread)
                                leader = null;
                        }
                    }
                }
            }
        } finally {
            if (leader == null && q.peek() != null)
                available.signal();
            lock.unlock();
        }
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element with an expired delay is available on this queue,
     * or the specified wait time expires.
     *
     * @return the head of this queue, or {@code null} if the
     *         specified waiting time elapses before an element with
     *         an expired delay becomes available
     * @throws InterruptedException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.010 -0400", hash_original_method = "EB7BB1C25F5D1946BE8A4B7766DB032F", hash_generated_method = "4794EFD0AA9A0858083368DCD03E3B6D")
    
public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            for (;;) {
                E first = q.peek();
                if (first == null) {
                    if (nanos <= 0)
                        return null;
                    else
                        nanos = available.awaitNanos(nanos);
                } else {
                    long delay = first.getDelay(NANOSECONDS);
                    if (delay <= 0)
                        return q.poll();
                    if (nanos <= 0)
                        return null;
                    first = null; // don't retain ref while waiting
                    if (nanos < delay || leader != null)
                        nanos = available.awaitNanos(nanos);
                    else {
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            long timeLeft = available.awaitNanos(delay);
                            nanos -= delay - timeLeft;
                        } finally {
                            if (leader == thisThread)
                                leader = null;
                        }
                    }
                }
            }
        } finally {
            if (leader == null && q.peek() != null)
                available.signal();
            lock.unlock();
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or
     * returns {@code null} if this queue is empty.  Unlike
     * {@code poll}, if no expired elements are available in the queue,
     * this method returns the element that will expire next,
     * if one exists.
     *
     * @return the head of this queue, or {@code null} if this
     *         queue is empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.011 -0400", hash_original_method = "9C881159AB108338D48030BA0A3867B0", hash_generated_method = "6D8DAFA33C6576E59ACD7FD85E6435AD")
    
public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.peek();
        } finally {
            lock.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.011 -0400", hash_original_method = "5E142A407B977683803F274197A8277F", hash_generated_method = "FE3621711FE8CCC35E99737907B9EA5D")
    
public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.size();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns first element only if it is expired.
     * Used only by drainTo.  Call only when holding lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.011 -0400", hash_original_method = "AFE3BCD4E8B82AE73B63E431A1526619", hash_generated_method = "0D454C643B1A3FB3A4A38381938D367F")
    
private E peekExpired() {
        // assert lock.isHeldByCurrentThread();
        E first = q.peek();
        return (first == null || first.getDelay(NANOSECONDS) > 0) ?
            null : first;
    }

    /**
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.012 -0400", hash_original_method = "C453416F564401A18E931B2A15296A49", hash_generated_method = "3FBE48DD33018DD829BB46FD28680297")
    
public int drainTo(Collection<? super E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n = 0;
            for (E e; (e = peekExpired()) != null;) {
                c.add(e);       // In this order, in case add() throws.
                q.poll();
                ++n;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.013 -0400", hash_original_method = "FDC1122A4F84FF9240215C983EC3BB21", hash_generated_method = "AC9048BA59102E5D3BC14492A6932F0A")
    
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
            int n = 0;
            for (E e; n < maxElements && (e = peekExpired()) != null;) {
                c.add(e);       // In this order, in case add() throws.
                q.poll();
                ++n;
            }
            return n;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Atomically removes all of the elements from this delay queue.
     * The queue will be empty after this call returns.
     * Elements with an unexpired delay are not waited for; they are
     * simply discarded from the queue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.013 -0400", hash_original_method = "D974D7C6F8A53DC4C2F23EFB7DA19D0A", hash_generated_method = "D82B58281B0E43EC5A6E27448E111F22")
    
public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            q.clear();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Always returns {@code Integer.MAX_VALUE} because
     * a {@code DelayQueue} is not capacity constrained.
     *
     * @return {@code Integer.MAX_VALUE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.014 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "33BD29B45C0B302F31D1F275110E0FF5")
    
public int remainingCapacity() {
        return Integer.MAX_VALUE;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.014 -0400", hash_original_method = "0E5ACAF6230031E98DA1D296D3786B46", hash_generated_method = "3F65F0D5FD7F2630E6CB680942EDD588")
    
public Object[] toArray() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.toArray();
        } finally {
            lock.unlock();
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
     * <p>The following code can be used to dump a delay queue into a newly
     * allocated array of {@code Delayed}:
     *
     * <pre> {@code Delayed[] a = q.toArray(new Delayed[0]);}</pre>
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
            return q.toArray(a);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Removes a single instance of the specified element from this
     * queue, if it is present, whether or not it has expired.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.015 -0400", hash_original_method = "4771911ED2BF63791776325A4503EB1A", hash_generated_method = "7FC2BCA9A434EC57FCBA20AD30F46DA2")
    
public boolean remove(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.remove(o);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Identity-based version for use in Itr.remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.015 -0400", hash_original_method = "8100634ACF4440638ECC28432AE5429D", hash_generated_method = "8100634ACF4440638ECC28432AE5429D")
    
void removeEQ(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Iterator<E> it = q.iterator(); it.hasNext(); ) {
                if (o == it.next()) {
                    it.remove();
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns an iterator over all the elements (both expired and
     * unexpired) in this queue. The iterator does not return the
     * elements in any particular order.
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.016 -0400", hash_original_method = "42CB3EDA719DA2D528DF0D9481F5BC1E", hash_generated_method = "65282ABD79DA1B1618CD7D7834524202")
    
public Iterator<E> iterator() {
        return new Itr(toArray());
    }

    /**
     * Snapshot iterator that works off copy of underlying q array.
     */
    private class Itr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.016 -0400", hash_original_field = "3E4C52F6F0428C39E4E692D20A9AA9AA", hash_generated_field = "3E4C52F6F0428C39E4E692D20A9AA9AA")

         Object[] array;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.016 -0400", hash_original_field = "574451AF3BDD0EC887A8F04530DC95F1", hash_generated_field = "574451AF3BDD0EC887A8F04530DC95F1")

        int cursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.017 -0400", hash_original_field = "8BE11FCC759F9AA5663F1AF67D0DDBCD", hash_generated_field = "8BE11FCC759F9AA5663F1AF67D0DDBCD")

        int lastRet;          // index of last element, or -1 if no such

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.017 -0400", hash_original_method = "3D5D0E3420638FA7514533715C7FD5D4", hash_generated_method = "3D5D0E3420638FA7514533715C7FD5D4")
        
Itr(Object[] array) {
            lastRet = -1;
            this.array = array;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.018 -0400", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "CDE3CA7472C460360713EEDFAECC9D23")
        
public boolean hasNext() {
            return cursor < array.length;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.018 -0400", hash_original_method = "F81A0847679B1E16464240B404F27074", hash_generated_method = "B4E1EAD4513BC72F9DD720111D452AA6")
        
@SuppressWarnings("unchecked")
        public E next() {
            if (cursor >= array.length)
                throw new NoSuchElementException();
            lastRet = cursor;
            return (E)array[cursor++];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.018 -0400", hash_original_method = "1F047BB3E034A57C737F1A0202C892CE", hash_generated_method = "B4834007EE8190B0571AD4806F849A99")
        
public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            removeEQ(array[lastRet]);
            lastRet = -1;
        }
    }

}
