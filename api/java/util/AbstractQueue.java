package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {

    /**
     * Constructor for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.067 -0500", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "4C8E29CF93249ABC307875B8F7EAF6A3")
    
protected AbstractQueue() {
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * <tt>true</tt> upon success and throwing an <tt>IllegalStateException</tt>
     * if no space is currently available.
     *
     * <p>This implementation returns <tt>true</tt> if <tt>offer</tt> succeeds,
     * else throws an <tt>IllegalStateException</tt>.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.070 -0500", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "9301EF03F4097022CBB38B7C603C1D58")
    
public boolean add(E e) {
        if (offer(e))
            return true;
        else
            throw new IllegalStateException("Queue full");
    }

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * <p>This implementation returns the result of <tt>poll</tt>
     * unless the queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.072 -0500", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "51202F7E3A2AD9476298446EFBB72638")
    
public E remove() {
        E x = poll();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception if
     * this queue is empty.
     *
     * <p>This implementation returns the result of <tt>peek</tt>
     * unless the queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.074 -0500", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "F95746A63D42A09181D76B9F8FFB9607")
    
public E element() {
        E x = peek();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    /**
     * Removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     *
     * <p>This implementation repeatedly invokes {@link #poll poll} until it
     * returns <tt>null</tt>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.077 -0500", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "750390753AA794A653442C7ECC78CFD3")
    
public void clear() {
        while (poll() != null)
            ;
    }

    /**
     * Adds all of the elements in the specified collection to this
     * queue.  Attempts to addAll of a queue to itself result in
     * <tt>IllegalArgumentException</tt>. Further, the behavior of
     * this operation is undefined if the specified collection is
     * modified while the operation is in progress.
     *
     * <p>This implementation iterates over the specified collection,
     * and adds each element returned by the iterator to this
     * queue, in turn.  A runtime exception encountered while
     * trying to add an element (including, in particular, a
     * <tt>null</tt> element) may result in only some of the elements
     * having been successfully added when the associated exception is
     * thrown.
     *
     * @param c collection containing elements to be added to this queue
     * @return <tt>true</tt> if this queue changed as a result of the call
     * @throws ClassCastException if the class of an element of the specified
     *         collection prevents it from being added to this queue
     * @throws NullPointerException if the specified collection contains a
     *         null element and this queue does not permit null elements,
     *         or if the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     *         specified collection prevents it from being added to this
     *         queue, or if the specified collection is this queue
     * @throws IllegalStateException if not all the elements can be added at
     *         this time due to insertion restrictions
     * @see #add(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.079 -0500", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "188E3C1641DB9ED9F0D08995BAA63E36")
    
public boolean addAll(Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
    
}

