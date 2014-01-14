package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, java.io.Serializable {

    /**
     * Throws NullPointerException if argument is null.
     *
     * @param v the element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.814 -0500", hash_original_method = "BBA8F566F6EBBAE4E624DE5E2288492A", hash_generated_method = "5E8CAC32EF86836AAB409F83647A3C3E")
    
private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.829 -0500", hash_original_method = "AB96ED97F4B21B8760238DEC7BD056B4", hash_generated_method = "2DEA2A5047BC334C40FA23467D30FC1B")
    
static long objectFieldOffset(sun.misc.Unsafe UNSAFE,
                                  String field, Class<?> klazz) {
        try {
            return UNSAFE.objectFieldOffset(klazz.getDeclaredField(field));
        } catch (NoSuchFieldException e) {
            // Convert Exception to corresponding Error
            NoSuchFieldError error = new NoSuchFieldError(field);
            error.initCause(e);
            throw error;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.707 -0500", hash_original_field = "2DC2000B89BA4649105478D1A83FB5CA", hash_generated_field = "552079242BF4D3962F1F3E89C3B525FA")

    private static final long serialVersionUID = 196745693267521676L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.816 -0500", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.819 -0500", hash_original_field = "CAC71C97168C08066A0751C53920A8EA", hash_generated_field = "9EFA27FCA31FFA33F7E605E12104104C")

    private static final long headOffset =
        objectFieldOffset(UNSAFE, "head", ConcurrentLinkedQueue.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.821 -0500", hash_original_field = "4A8772D2EA45DDC4EE7E990E1E9D8562", hash_generated_field = "B885C4C60FF837953D19E1C9D06EABC1")

    private static final long tailOffset =
        objectFieldOffset(UNSAFE, "tail", ConcurrentLinkedQueue.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.735 -0500", hash_original_field = "AF17874DDDE4597EF645F8BFBDDE5272", hash_generated_field = "B57EDCA0C5D8B188A31356A19160405D")

    private transient volatile Node<E> head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.737 -0500", hash_original_field = "A5E4BAC07874F33303440A161800C0F9", hash_generated_field = "44C1E7DD6E43696E7B1931FD10B83ECF")

    private transient volatile Node<E> tail;

    /**
     * Creates a {@code ConcurrentLinkedQueue} that is initially empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.740 -0500", hash_original_method = "6A57FB745E5D860E38239AF0DB1591EF", hash_generated_method = "D1746736EE12BF8D23599CAA7240438E")
    
public ConcurrentLinkedQueue() {
        head = tail = new Node<E>(null);
    }

    /**
     * Creates a {@code ConcurrentLinkedQueue}
     * initially containing the elements of the given collection,
     * added in traversal order of the collection's iterator.
     *
     * @param c the collection of elements to initially contain
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.743 -0500", hash_original_method = "6F01EA166BC3601049062B90A5587D9E", hash_generated_method = "37A1684F14F56F9CBFB4E509295953F6")
    
public ConcurrentLinkedQueue(Collection<? extends E> c) {
        Node<E> h = null, t = null;
        for (E e : c) {
            checkNotNull(e);
            Node<E> newNode = new Node<E>(e);
            if (h == null)
                h = t = newNode;
            else {
                t.lazySetNext(newNode);
                t = newNode;
            }
        }
        if (h == null)
            h = t = new Node<E>(null);
        head = h;
        tail = t;
    }

    // Have to override just to update the javadoc

    /**
     * Inserts the specified element at the tail of this queue.
     * As the queue is unbounded, this method will never throw
     * {@link IllegalStateException} or return {@code false}.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.746 -0500", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "5AEDC89A183EF5E6538093DA8AE2F21F")
    
public boolean add(E e) {
        return offer(e);
    }

    /**
     * Try to CAS head to p. If successful, repoint old head to itself
     * as sentinel for succ(), below.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.748 -0500", hash_original_method = "73F32BBDAFE1515404B45EC2F1869A3A", hash_generated_method = "FCD28EBA9B9CE91E3996D097D38A8FA2")
    
final void updateHead(Node<E> h, Node<E> p) {
        if (h != p && casHead(h, p))
            h.lazySetNext(h);
    }

    /**
     * Returns the successor of p, or the head node if p.next has been
     * linked to self, which will only be true if traversing with a
     * stale pointer that is now off the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.751 -0500", hash_original_method = "FA81D040C1BC0670D20AF3D93B255BE4", hash_generated_method = "034E9B15950FC1F0DC2137E90D14CF99")
    
final Node<E> succ(Node<E> p) {
        Node<E> next = p.next;
        return (p == next) ? head : next;
    }

    /**
     * Inserts the specified element at the tail of this queue.
     * As the queue is unbounded, this method will never return {@code false}.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.753 -0500", hash_original_method = "6C2ABD9F3905A9D98C3CBF8AF5320B8C", hash_generated_method = "AB60E658250AACAEC31816F45BA0E150")
    
public boolean offer(E e) {
        checkNotNull(e);
        final Node<E> newNode = new Node<E>(e);

        for (Node<E> t = tail, p = t;;) {
            Node<E> q = p.next;
            if (q == null) {
                // p is last node
                if (p.casNext(null, newNode)) {
                    // Successful CAS is the linearization point
                    // for e to become an element of this queue,
                    // and for newNode to become "live".
                    if (p != t) // hop two nodes at a time
                        casTail(t, newNode);  // Failure is OK.
                    return true;
                }
                // Lost CAS race to another thread; re-read next
            }
            else if (p == q)
                // We have fallen off list.  If tail is unchanged, it
                // will also be off-list, in which case we need to
                // jump to head, from which all live nodes are always
                // reachable.  Else the new tail is a better bet.
                p = (t != (t = tail)) ? t : head;
            else
                // Check for tail updates after two hops.
                p = (p != t && t != (t = tail)) ? t : q;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.756 -0500", hash_original_method = "1F662EFABD15CE7BE1315E55CBBE7D30", hash_generated_method = "9AF7B22733C69CCDE065F58231731D12")
    
public E poll() {
        restartFromHead:
        for (;;) {
            for (Node<E> h = head, p = h, q;;) {
                E item = p.item;

                if (item != null && p.casItem(item, null)) {
                    // Successful CAS is the linearization point
                    // for item to be removed from this queue.
                    if (p != h) // hop two nodes at a time
                        updateHead(h, ((q = p.next) != null) ? q : p);
                    return item;
                }
                else if ((q = p.next) == null) {
                    updateHead(h, p);
                    return null;
                }
                else if (p == q)
                    continue restartFromHead;
                else
                    p = q;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.758 -0500", hash_original_method = "61FBF64CA94D04AD27A6643CEF7D7285", hash_generated_method = "B27BEF2FCBE36929DB44B2C40A3A3C09")
    
public E peek() {
        restartFromHead:
        for (;;) {
            for (Node<E> h = head, p = h, q;;) {
                E item = p.item;
                if (item != null || (q = p.next) == null) {
                    updateHead(h, p);
                    return item;
                }
                else if (p == q)
                    continue restartFromHead;
                else
                    p = q;
            }
        }
    }

    /**
     * Returns the first live (non-deleted) node on list, or null if none.
     * This is yet another variant of poll/peek; here returning the
     * first node, not element.  We could make peek() a wrapper around
     * first(), but that would cost an extra volatile read of item,
     * and the need to add a retry loop to deal with the possibility
     * of losing a race to a concurrent poll().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.761 -0500", hash_original_method = "0B74804F51F2B061D3EF3D31C957BAFB", hash_generated_method = "0B74804F51F2B061D3EF3D31C957BAFB")
    
Node<E> first() {
        restartFromHead:
        for (;;) {
            for (Node<E> h = head, p = h, q;;) {
                boolean hasItem = (p.item != null);
                if (hasItem || (q = p.next) == null) {
                    updateHead(h, p);
                    return hasItem ? p : null;
                }
                else if (p == q)
                    continue restartFromHead;
                else
                    p = q;
            }
        }
    }

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if this queue contains no elements
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.763 -0500", hash_original_method = "5BBCBCAD5CC8F01475F9C33B1A8BDA76", hash_generated_method = "4E85F053E74AB3FEF852FB2933EBC4F7")
    
public boolean isEmpty() {
        return first() == null;
    }

    /**
     * Returns the number of elements in this queue.  If this queue
     * contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * <p>Beware that, unlike in most collections, this method is
     * <em>NOT</em> a constant-time operation. Because of the
     * asynchronous nature of these queues, determining the current
     * number of elements requires an O(n) traversal.
     * Additionally, if elements are added or removed during execution
     * of this method, the returned result may be inaccurate.  Thus,
     * this method is typically not very useful in concurrent
     * applications.
     *
     * @return the number of elements in this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.766 -0500", hash_original_method = "8378A4BA724609F4EE8D701FE95A4146", hash_generated_method = "B3986D8D35FCEA705CE19E049D534B6B")
    
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
     * Returns {@code true} if this queue contains the specified element.
     * More formally, returns {@code true} if and only if this queue contains
     * at least one element {@code e} such that {@code o.equals(e)}.
     *
     * @param o object to be checked for containment in this queue
     * @return {@code true} if this queue contains the specified element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.768 -0500", hash_original_method = "D3CFD955C2206E78AC2D6D0AA96542FF", hash_generated_method = "A8666B247011B410F30626CB4D5504E0")
    
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
     * Removes a single instance of the specified element from this queue,
     * if it is present.  More formally, removes an element {@code e} such
     * that {@code o.equals(e)}, if this queue contains one or more such
     * elements.
     * Returns {@code true} if this queue contained the specified element
     * (or equivalently, if this queue changed as a result of the call).
     *
     * @param o element to be removed from this queue, if present
     * @return {@code true} if this queue changed as a result of the call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.772 -0500", hash_original_method = "47B1B9EE8A66BF6628AC85F9580DDA03", hash_generated_method = "9580346F405E36F21A2BEFA78B3E0A5C")
    
public boolean remove(Object o) {
        if (o == null) return false;
        Node<E> pred = null;
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null &&
                o.equals(item) &&
                p.casItem(item, null)) {
                Node<E> next = succ(p);
                if (pred != null && next != null)
                    pred.casNext(p, next);
                return true;
            }
            pred = p;
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this queue, in the order that they are returned by the specified
     * collection's iterator.  Attempts to {@code addAll} of a queue to
     * itself result in {@code IllegalArgumentException}.
     *
     * @param c the elements to be inserted into this queue
     * @return {@code true} if this queue changed as a result of the call
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     * @throws IllegalArgumentException if the collection is this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.775 -0500", hash_original_method = "C76E29CF6BEEA629C4456D9BD8199C10", hash_generated_method = "7386589E0B4ABFD0CC3B008A28998348")
    
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
                last = newNode;
            }
        }
        if (beginningOfTheEnd == null)
            return false;

        // Atomically append the chain at the tail of this collection
        for (Node<E> t = tail, p = t;;) {
            Node<E> q = p.next;
            if (q == null) {
                // p is last node
                if (p.casNext(null, beginningOfTheEnd)) {
                    // Successful CAS is the linearization point
                    // for all elements to be added to this queue.
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
            else if (p == q)
                // We have fallen off list.  If tail is unchanged, it
                // will also be off-list, in which case we need to
                // jump to head, from which all live nodes are always
                // reachable.  Else the new tail is a better bet.
                p = (t != (t = tail)) ? t : head;
            else
                // Check for tail updates after two hops.
                p = (p != t && t != (t = tail)) ? t : q;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.777 -0500", hash_original_method = "9AE75EDD15A5D634A14FDDC5ABF53B75", hash_generated_method = "385399E68448223FBC64104F00D1AF03")
    
public Object[] toArray() {
        // Use ArrayList to deal with resizing.
        ArrayList<E> al = new ArrayList<E>();
        for (Node<E> p = first(); p != null; p = succ(p)) {
            E item = p.item;
            if (item != null)
                al.add(item);
        }
        return al.toArray();
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.721 -0400", hash_original_method = "1B34191977E7D82DF73C99DC22E56270", hash_generated_method = "083DB23FA5D6BA154941AB836C30B5AA")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        int k = 0;
        Node<E> p;
for(p = first();p != null && k < a.length;p = succ(p))
        {
            E item = p.item;
            if(item != null)            
            a[k++] = (T)item;
        } //End block
        if(p == null)        
        {
            if(k < a.length)            
            a[k] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_1239886747 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_1239886747.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_1239886747;
        } //End block
        ArrayList<E> al = new ArrayList<E>();
for(Node<E> q = first();q != null;q = succ(q))
        {
            E item = q.item;
            if(item != null)            
            al.add(item);
        } //End block
T[] varAA44379FEF6B0261A49B4F9151CB856C_1343847510 =         al.toArray(a);
        varAA44379FEF6B0261A49B4F9151CB856C_1343847510.addTaint(taint);
        return varAA44379FEF6B0261A49B4F9151CB856C_1343847510;
        // ---------- Original Method ----------
        //int k = 0;
        //Node<E> p;
        //for (p = first(); p != null && k < a.length; p = succ(p)) {
            //E item = p.item;
            //if (item != null)
                //a[k++] = (T)item;
        //}
        //if (p == null) {
            //if (k < a.length)
                //a[k] = null;
            //return a;
        //}
        //ArrayList<E> al = new ArrayList<E>();
        //for (Node<E> q = first(); q != null; q = succ(q)) {
            //E item = q.item;
            //if (item != null)
                //al.add(item);
        //}
        //return al.toArray(a);
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * <p>The returned iterator is a "weakly consistent" iterator that
     * will never throw {@link java.util.ConcurrentModificationException
     * ConcurrentModificationException}, and guarantees to traverse
     * elements as they existed upon construction of the iterator, and
     * may (but is not guaranteed to) reflect any modifications
     * subsequent to construction.
     *
     * @return an iterator over the elements in this queue in proper sequence
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.782 -0500", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "B0FB44010E28764F5FA2B4AB0E8E15C1")
    
public Iterator<E> iterator() {
        return new Itr();
    }
    
    private static class Node<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.725 -0500", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE =
            sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.728 -0500", hash_original_field = "C5B47A2E9B21336EE0021DE6B943B18F", hash_generated_field = "D9FDE22F87B42653A7025C63A9991763")

        private static final long nextOffset =
            objectFieldOffset(UNSAFE, "next", Node.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.731 -0500", hash_original_field = "9281F58398F24BD492C4B8262E2CA8E9", hash_generated_field = "E138439E2B895339EC3451FCFE9CA960")

        private static final long itemOffset =
            objectFieldOffset(UNSAFE, "item", Node.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.710 -0500", hash_original_field = "25C1B4BE35B7528A52E74D8E56CE9F0B", hash_generated_field = "10095ABA73A923383E44F968C6C62945")

        volatile E item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.712 -0500", hash_original_field = "A089DAAEF049057EDB97CA1342EE38E4", hash_generated_field = "7BB4D15B501C737F5EC180DC75EDF910")

        volatile Node<E> next;

        /**
         * Constructs a new node.  Uses relaxed write because item can
         * only be seen after publication via casNext.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.715 -0500", hash_original_method = "368F2FAFC4A206C09EED76798A5342BA", hash_generated_method = "368F2FAFC4A206C09EED76798A5342BA")
        
Node(E item) {
            UNSAFE.putObject(this, itemOffset, item);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.717 -0500", hash_original_method = "51A0AA76262E736F2E39BE7CE12CF006", hash_generated_method = "51A0AA76262E736F2E39BE7CE12CF006")
        
boolean casItem(E cmp, E val) {
            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.720 -0500", hash_original_method = "E78DBD679DC5F596F67B7449AE69FAB3", hash_generated_method = "E78DBD679DC5F596F67B7449AE69FAB3")
        
void lazySetNext(Node<E> val) {
            UNSAFE.putOrderedObject(this, nextOffset, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.722 -0500", hash_original_method = "C86D1E5E3D7752CB8E68445595A8E8EC", hash_generated_method = "C86D1E5E3D7752CB8E68445595A8E8EC")
        
boolean casNext(Node<E> cmp, Node<E> val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }
    }
    
    private class Itr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.785 -0500", hash_original_field = "138F1A36912062F45403BBEDD9B8281D", hash_generated_field = "BD45C7FA08D8C17CC087E2A8B9D2DBAA")

        private Node<E> nextNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.788 -0500", hash_original_field = "FC047D97EB4DD102072D6594B14B8B33", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.791 -0500", hash_original_field = "93698314F06F14B80EF688D146BA679D", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.793 -0500", hash_original_method = "A56873641F7861FCF92703A510E041DF", hash_generated_method = "A56873641F7861FCF92703A510E041DF")
        
Itr() {
            advance();
        }

        /**
         * Moves to next valid node and returns item to return for
         * next(), or null if no such.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.796 -0500", hash_original_method = "530B75A5B8DF2D5033AF3BE4C3DEE1C2", hash_generated_method = "C5553EAD5AC36701780B043AC98912EE")
        
private E advance() {
            lastRet = nextNode;
            E x = nextItem;

            Node<E> pred, p;
            if (nextNode == null) {
                p = first();
                pred = null;
            } else {
                pred = nextNode;
                p = succ(nextNode);
            }

            for (;;) {
                if (p == null) {
                    nextNode = null;
                    nextItem = null;
                    return x;
                }
                E item = p.item;
                if (item != null) {
                    nextNode = p;
                    nextItem = item;
                    return x;
                } else {
                    // skip over nulls
                    Node<E> next = succ(p);
                    if (pred != null && next != null)
                        pred.casNext(p, next);
                    p = next;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.798 -0500", hash_original_method = "F3203522041DB53AA10973946A26B4E6", hash_generated_method = "0CE7AB64F14A3A8431434F0197BFFCA6")
        
public boolean hasNext() {
            return nextNode != null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.801 -0500", hash_original_method = "0C68CBDEA1D7969059001FABF149348A", hash_generated_method = "DB69FF76B32A8E8E884F805DCD7E6FB7")
        
public E next() {
            if (nextNode == null) throw new NoSuchElementException();
            return advance();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.803 -0500", hash_original_method = "4D06856C6560F115B6FF7F073DDF82B7", hash_generated_method = "78A2193CDF1ABB9F4A5B94F29BE9C278")
        
public void remove() {
            Node<E> l = lastRet;
            if (l == null) throw new IllegalStateException();
            // rely on a future traversal to relink.
            l.item = null;
            lastRet = null;
        }
        
    }

    /**
     * Saves the state to a stream (that is, serializes it).
     *
     * @serialData All of the elements (each an {@code E}) in
     * the proper order, followed by a null
     * @param s the stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.808 -0500", hash_original_method = "2DB3995911F14A1266042DB21211C241", hash_generated_method = "450A8DC28F0797E0CC68180DE79FD145")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {

        // Write out any hidden stuff
        s.defaultWriteObject();

        // Write out all elements in the proper order.
        for (Node<E> p = first(); p != null; p = succ(p)) {
            Object item = p.item;
            if (item != null)
                s.writeObject(item);
        }

        // Use trailing null as sentinel
        s.writeObject(null);
    }

    /**
     * Reconstitutes the instance from a stream (that is, deserializes it).
     * @param s the stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.811 -0500", hash_original_method = "4C4E4F1C2555347B7DA11DAA134BF488", hash_generated_method = "98812E5EC8FF51B6B8FADC4EC4D13DA0")
    
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
                t = newNode;
            }
        }
        if (h == null)
            h = t = new Node<E>(null);
        head = h;
        tail = t;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.824 -0500", hash_original_method = "691EF799FFE1B91CC4D8DBAB0EEF43D5", hash_generated_method = "A93F53BA0D8A63AFA1FA8565CC11D3B2")
    
private boolean casTail(Node<E> cmp, Node<E> val) {
        return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:22.826 -0500", hash_original_method = "BC5855BB8BED9A25EA66B96BB6A04937", hash_generated_method = "3B755D3C35A6E32CBB6B8B9A8AD6318E")
    
private boolean casHead(Node<E> cmp, Node<E> val) {
        return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
    }
}

