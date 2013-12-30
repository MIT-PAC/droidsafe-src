package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import libcore.util.EmptyArray;





public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {

    // Unsafe mechanics
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.215 -0500", hash_original_method = "AB96ED97F4B21B8760238DEC7BD056B4", hash_generated_method = "2DEA2A5047BC334C40FA23467D30FC1B")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.952 -0500", hash_original_field = "D05A7E9A1950F325B120E64C6656BBF1", hash_generated_field = "1E3367DE63E4A43E00AB1E404902880B")

    private static final long serialVersionUID = -3223113410248163686L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.960 -0500", hash_original_field = "22299F79E78D5E2CC61E565F83079B57", hash_generated_field = "EB1423FF544459B29A17FADE8C5125D9")

    static final int NCPUS = Runtime.getRuntime().availableProcessors();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.963 -0500", hash_original_field = "5FD9088099A6671C4C592ECF85DD77EC", hash_generated_field = "EFDB8C9AF5E428D3578BEE68452C22B2")

    static final int maxTimedSpins = (NCPUS < 2) ? 0 : 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.965 -0500", hash_original_field = "B438F5B8521A1C36D2CDA5138402BE25", hash_generated_field = "616785537C813125BAC1A7A01A65BE67")

    static final int maxUntimedSpins = maxTimedSpins * 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.968 -0500", hash_original_field = "31EF0FD32B41579996230BE158DB7639", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.133 -0500", hash_original_field = "05D30D9DE085068CA54BCBB0A05E1253", hash_generated_field = "93A6B6C7FD7700420692EFD74AC915AE")

    private transient volatile Transferer transferer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.204 -0500", hash_original_field = "99C83703D8D6A45A5E05CD58E7143D8F", hash_generated_field = "E2A217843A6D418FDE83E1DD89178FFA")

    private ReentrantLock qlock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.206 -0500", hash_original_field = "F14441E67D69D3D7428B828859803154", hash_generated_field = "9EC2490AD04FFD57826C64D62CD6D006")

    private WaitQueue waitingProducers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.208 -0500", hash_original_field = "1BE85A4B1371BF33107851D79DE31028", hash_generated_field = "4EC4B53B46775F740D025ADAAB977973")

    private WaitQueue waitingConsumers;

    /**
     * Creates a <tt>SynchronousQueue</tt> with nonfair access policy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.136 -0500", hash_original_method = "CA3CB3D951221FCCF0DFF3BB5DF12346", hash_generated_method = "E23F8FBF3183C654BC9B4775FD2BD4CE")
    
public SynchronousQueue() {
        this(false);
    }

    /**
     * Creates a <tt>SynchronousQueue</tt> with the specified fairness policy.
     *
     * @param fair if true, waiting threads contend in FIFO order for
     *        access; otherwise the order is unspecified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.139 -0500", hash_original_method = "2A4F416DA0F8363F009FD8DA8EB74A84", hash_generated_method = "9539059980CCB6C614D40B91261D83AF")
    
public SynchronousQueue(boolean fair) {
        transferer = fair ? new TransferQueue() : new TransferStack();
    }

    /**
     * Adds the specified element to this queue, waiting if necessary for
     * another thread to receive it.
     *
     * @throws InterruptedException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.141 -0500", hash_original_method = "C65E97EC40BB31D50DB029B0D4F47DF5", hash_generated_method = "9CC0BF89AD950BDE709300CC99D3A0BF")
    
public void put(E o) throws InterruptedException {
        if (o == null) throw new NullPointerException();
        if (transferer.transfer(o, false, 0) == null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    /**
     * Inserts the specified element into this queue, waiting if necessary
     * up to the specified wait time for another thread to receive it.
     *
     * @return <tt>true</tt> if successful, or <tt>false</tt> if the
     *         specified waiting time elapses before a consumer appears.
     * @throws InterruptedException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.144 -0500", hash_original_method = "3A6AFFAA000C17EA73FBC10B0EC018FD", hash_generated_method = "738D41720291FF1364283806590CFFEB")
    
public boolean offer(E o, long timeout, TimeUnit unit)
        throws InterruptedException {
        if (o == null) throw new NullPointerException();
        if (transferer.transfer(o, true, unit.toNanos(timeout)) != null)
            return true;
        if (!Thread.interrupted())
            return false;
        throw new InterruptedException();
    }

    /**
     * Inserts the specified element into this queue, if another thread is
     * waiting to receive it.
     *
     * @param e the element to add
     * @return <tt>true</tt> if the element was added to this queue, else
     *         <tt>false</tt>
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.146 -0500", hash_original_method = "A4F84C12941B1214559E662FB5D2360B", hash_generated_method = "3D3E592520992E8DBD962B76E11D2872")
    
public boolean offer(E e) {
        if (e == null) throw new NullPointerException();
        return transferer.transfer(e, true, 0) != null;
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * for another thread to insert it.
     *
     * @return the head of this queue
     * @throws InterruptedException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.148 -0500", hash_original_method = "A59182A477060C80E9C0D7B7DD2CA2C3", hash_generated_method = "93A6E4AB23030359EBB29CE077FDAFC8")
    
public E take() throws InterruptedException {
        Object e = transferer.transfer(null, false, 0);
        if (e != null)
            return (E)e;
        Thread.interrupted();
        throw new InterruptedException();
    }

    /**
     * Retrieves and removes the head of this queue, waiting
     * if necessary up to the specified wait time, for another thread
     * to insert it.
     *
     * @return the head of this queue, or <tt>null</tt> if the
     *         specified waiting time elapses before an element is present.
     * @throws InterruptedException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.152 -0500", hash_original_method = "F80BFD27E2D553DA44FF7C91997050D6", hash_generated_method = "544F470CBEBB43E8344C12B13EC2505A")
    
public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        if (e != null || !Thread.interrupted())
            return (E)e;
        throw new InterruptedException();
    }

    /**
     * Retrieves and removes the head of this queue, if another thread
     * is currently making an element available.
     *
     * @return the head of this queue, or <tt>null</tt> if no
     *         element is available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.154 -0500", hash_original_method = "1663F66628103F625AD11623448BFB1D", hash_generated_method = "FAFBCCE68A58CF9DE90F2063B67A65BE")
    
public E poll() {
        return (E)transferer.transfer(null, true, 0);
    }

    /**
     * Always returns <tt>true</tt>.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @return <tt>true</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.156 -0500", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "9B3F6821F5C7059CC31D26D1C7422DBE")
    
public boolean isEmpty() {
        return true;
    }

    /**
     * Always returns zero.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @return zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.159 -0500", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "8243D2C5FD3470DD5994015C24633E41")
    
public int size() {
        return 0;
    }

    /**
     * Always returns zero.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @return zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.161 -0500", hash_original_method = "859254362B8CFD4ECD77710B77AC10ED", hash_generated_method = "12683E16E91ECC200D3CBA80068F4AA5")
    
public int remainingCapacity() {
        return 0;
    }

    /**
     * Does nothing.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.163 -0500", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "732183AF6E98AAFD21F340F23D9F33E5")
    
public void clear() {
    }

    /**
     * Always returns <tt>false</tt>.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @param o the element
     * @return <tt>false</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.165 -0500", hash_original_method = "133415712E6841A0903588DC5D4862AA", hash_generated_method = "791B9B7417FB700D1EC5C6542CC452AF")
    
public boolean contains(Object o) {
        return false;
    }

    /**
     * Always returns <tt>false</tt>.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @param o the element to remove
     * @return <tt>false</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.168 -0500", hash_original_method = "6081257F3AE1D633C77BCA63D6F77CB7", hash_generated_method = "6FA7B4C17CE8A4CB239AB9E80728C47A")
    
public boolean remove(Object o) {
        return false;
    }

    /**
     * Returns <tt>false</tt> unless the given collection is empty.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @param c the collection
     * @return <tt>false</tt> unless given collection is empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.170 -0500", hash_original_method = "C503BED5AF377C63A87B0C398CACB95B", hash_generated_method = "46D57487A7938C83B502487EB7BCE166")
    
public boolean containsAll(Collection<?> c) {
        return c.isEmpty();
    }

    /**
     * Always returns <tt>false</tt>.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @param c the collection
     * @return <tt>false</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.172 -0500", hash_original_method = "EC0A570B588D76D8968190A1BD3D4040", hash_generated_method = "B2EBC8AD42CFC98090B1CA993AAE6BC5")
    
public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Always returns <tt>false</tt>.
     * A <tt>SynchronousQueue</tt> has no internal capacity.
     *
     * @param c the collection
     * @return <tt>false</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.174 -0500", hash_original_method = "13D5AD766AE77320C3CF56AB2E9E5FB4", hash_generated_method = "CDEB13A1528202741B9BC06A42E72953")
    
public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Always returns <tt>null</tt>.
     * A <tt>SynchronousQueue</tt> does not return elements
     * unless actively waited on.
     *
     * @return <tt>null</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.177 -0500", hash_original_method = "2DC914F9B3C538818482710C9EAD9EFB", hash_generated_method = "CA61106B7ACCB6666EE0F4EDBC5B71C7")
    
public E peek() {
        return null;
    }

    /**
     * Returns an empty iterator in which <tt>hasNext</tt> always returns
     * <tt>false</tt>.
     *
     * @return an empty iterator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.179 -0500", hash_original_method = "0BB2C5BB97AA1323E2FE15E87216E7E9", hash_generated_method = "C6921D01F5B0E2E4BE383880F9853B69")
    
public Iterator<E> iterator() {
        return Collections.<E>emptySet().iterator(); // android-changed
    }

    /**
     * Returns a zero-length array.
     * @return a zero-length array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.182 -0500", hash_original_method = "AAA5D1CBE91ADDEA174F65821E23BE58", hash_generated_method = "5B67F014864DC22E3DE7832358EFB295")
    
public Object[] toArray() {
        return EmptyArray.OBJECT; // android-changed
    }

    
    abstract static class Transferer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.924 -0400", hash_original_method = "09F8B62CD164A65EFE70D215172CE3CA", hash_generated_method = "09F8B62CD164A65EFE70D215172CE3CA")
        public Transferer ()
        {
            //Synthesized constructor
        }
        /**
         * Performs a put or take.
         *
         * @param e if non-null, the item to be handed to a consumer;
         *          if null, requests that transfer return an item
         *          offered by producer.
         * @param timed if this operation should timeout
         * @param nanos the timeout, in nanoseconds
         * @return if non-null, the item provided or received; if null,
         *         the operation failed due to timeout or interrupt --
         *         the caller can distinguish which of these occurred
         *         by checking Thread.interrupted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.955 -0500", hash_original_method = "BF5DAA3C17059334AA730DEFF3D7565C", hash_generated_method = "4BE78679C8E4E7D3A940B4FC71A6124B")
        
abstract Object transfer(Object e, boolean timed, long nanos);

        
    }


    
    static final class TransferStack extends Transferer {

        /** Return true if m has fulfilling bit set */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.979 -0500", hash_original_method = "D958261B93E9F7BA45445938E2ACC9FB", hash_generated_method = "D2D2D9610DA7F2251492DA68B1054834")
        
static boolean isFulfilling(int m) { return (m & FULFILLING) != 0; }

        /**
         * Creates or resets fields of a node. Called only from transfer
         * where the node to push on stack is lazily created and
         * reused when possible to help reduce intervals between reads
         * and CASes of head and to avoid surges of garbage when CASes
         * to push nodes fail due to contention.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.024 -0500", hash_original_method = "E549B117679BBEB608208F8B29614DC2", hash_generated_method = "678105BEDC99D29CFFE565EFEB63D68B")
        
static SNode snode(SNode s, Object e, SNode next, int mode) {
            if (s == null) s = new SNode(e);
            s.mode = mode;
            s.next = next;
            return s;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.971 -0500", hash_original_field = "9A8DB646F04D020A52DB67C20C9E991B", hash_generated_field = "956BE152D8E472120194E1D9F8A9E6E2")


        /* Modes for SNodes, ORed together in node fields */
        /** Node represents an unfulfilled consumer */
        static final int REQUEST    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.974 -0500", hash_original_field = "2C5CF8AC292F1C331BF88398AEC3D6D0", hash_generated_field = "839D78410482BFBBC8FD6F80E7B7399B")

        static final int DATA       = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.976 -0500", hash_original_field = "F25F62AA8F8C63797DD620119832E9E4", hash_generated_field = "14F8F9AC365CBCC20FCF4F001AD6990B")

        static final int FULFILLING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.039 -0500", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.042 -0500", hash_original_field = "B359A59C6286848BD139F0359A6C27BC", hash_generated_field = "FDC74C8C46C70DC81257DAB123799A8D")

        private static final long headOffset =
            objectFieldOffset(UNSAFE, "head", TransferStack.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.019 -0500", hash_original_field = "40ADDBC2911BA41EE7CFCF2F8FDA2547", hash_generated_field = "228454E0E0F7F2A4C4B0260AD101A4CF")

        volatile SNode head;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.925 -0400", hash_original_method = "02B0885CE62BE77F872535266EC48EF9", hash_generated_method = "02B0885CE62BE77F872535266EC48EF9")
        public TransferStack ()
        {
            //Synthesized constructor
        }

        
        static final class SNode {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.008 -0500", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.011 -0500", hash_original_field = "9911D9AC086D0DD6A763E8ADE2F96B7E", hash_generated_field = "0D8325461BECB64F10F564BE157F8175")

            private static final long nextOffset =
                objectFieldOffset(UNSAFE, "next", SNode.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.014 -0500", hash_original_field = "74D701CA3A72B9F94DD4D90C85E05AA8", hash_generated_field = "B5BF3FE8CC1DDC4679FEA266AA5E519F")

            private static final long matchOffset =
                objectFieldOffset(UNSAFE, "match", SNode.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.982 -0500", hash_original_field = "39298817676B141F9860D8AA037D7E0C", hash_generated_field = "51B8757B53C140AD03FA5839D28E2835")

            volatile SNode next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.985 -0500", hash_original_field = "20DD1FD1AFEAB31ADE81EC0308C3EB6F", hash_generated_field = "6CEC32C9039E66F4CB3AFBF850A69E68")

            volatile SNode match;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.988 -0500", hash_original_field = "4DB9CE87B9CCE3428476BDB51EBE9EF1", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.990 -0500", hash_original_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB", hash_generated_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB")

            Object item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.992 -0500", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "462D02655D7DD7DF6E5BA12D65851DD2")

            int mode;
            // Note: item and mode fields don't need to be volatile
            // since they are always written before, and read after,
            // other volatile/atomic operations.

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.995 -0500", hash_original_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B", hash_generated_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B")
            
SNode(Object item) {
                this.item = item;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:12.998 -0500", hash_original_method = "265B3E666AD76F55078AE9E7E3AE351C", hash_generated_method = "265B3E666AD76F55078AE9E7E3AE351C")
            
boolean casNext(SNode cmp, SNode val) {
                return cmp == next &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            /**
             * Tries to match node s to this node, if so, waking up thread.
             * Fulfillers call tryMatch to identify their waiters.
             * Waiters block until they have been matched.
             *
             * @param s the node to match
             * @return true if successfully matched to s
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.000 -0500", hash_original_method = "CEB4EA3334013C3454101E56EFA00D65", hash_generated_method = "2F0E38CB24A4CE638207C5268F0DD3FC")
            
boolean tryMatch(SNode s) {
                if (match == null &&
                    UNSAFE.compareAndSwapObject(this, matchOffset, null, s)) {
                    Thread w = waiter;
                    if (w != null) {    // waiters need at most one unpark
                        waiter = null;
                        LockSupport.unpark(w);
                    }
                    return true;
                }
                return match == s;
            }

            /**
             * Tries to cancel a wait by matching node to itself.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.003 -0500", hash_original_method = "4364F2F312C8CE7EEFC1A24A7BE396DF", hash_generated_method = "4364F2F312C8CE7EEFC1A24A7BE396DF")
            
void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.006 -0500", hash_original_method = "BB4CEE3409ECC1A047D42B262CFDD801", hash_generated_method = "BB4CEE3409ECC1A047D42B262CFDD801")
            
boolean isCancelled() {
                return match == this;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.021 -0500", hash_original_method = "F38594CD80446D46D4DC59D46118C84B", hash_generated_method = "F38594CD80446D46D4DC59D46118C84B")
        
boolean casHead(SNode h, SNode nh) {
            return h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh);
        }

        /**
         * Puts or takes an item.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.028 -0500", hash_original_method = "EF565BC8E8F2E2CD3218F549EBA67BF0", hash_generated_method = "D11C13B487E2495C96A587329747C01B")
        
Object transfer(Object e, boolean timed, long nanos) {
            /*
             * Basic algorithm is to loop trying one of three actions:
             *
             * 1. If apparently empty or already containing nodes of same
             *    mode, try to push node on stack and wait for a match,
             *    returning it, or null if cancelled.
             *
             * 2. If apparently containing node of complementary mode,
             *    try to push a fulfilling node on to stack, match
             *    with corresponding waiting node, pop both from
             *    stack, and return matched item. The matching or
             *    unlinking might not actually be necessary because of
             *    other threads performing action 3:
             *
             * 3. If top of stack already holds another fulfilling node,
             *    help it out by doing its match and/or pop
             *    operations, and then continue. The code for helping
             *    is essentially the same as for fulfilling, except
             *    that it doesn't return the item.
             */

            SNode s = null; // constructed/reused as needed
            int mode = (e == null) ? REQUEST : DATA;

            for (;;) {
                SNode h = head;
                if (h == null || h.mode == mode) {  // empty or same-mode
                    if (timed && nanos <= 0) {      // can't wait
                        if (h != null && h.isCancelled())
                            casHead(h, h.next);     // pop cancelled node
                        else
                            return null;
                    } else if (casHead(h, s = snode(s, e, h, mode))) {
                        SNode m = awaitFulfill(s, timed, nanos);
                        if (m == s) {               // wait was cancelled
                            clean(s);
                            return null;
                        }
                        if ((h = head) != null && h.next == s)
                            casHead(h, s.next);     // help s's fulfiller
                        return (mode == REQUEST) ? m.item : s.item;
                    }
                } else if (!isFulfilling(h.mode)) { // try to fulfill
                    if (h.isCancelled())            // already cancelled
                        casHead(h, h.next);         // pop and retry
                    else if (casHead(h, s=snode(s, e, h, FULFILLING|mode))) {
                        for (;;) { // loop until matched or waiters disappear
                            SNode m = s.next;       // m is s's match
                            if (m == null) {        // all waiters are gone
                                casHead(s, null);   // pop fulfill node
                                s = null;           // use new node next time
                                break;              // restart main loop
                            }
                            SNode mn = m.next;
                            if (m.tryMatch(s)) {
                                casHead(s, mn);     // pop both s and m
                                return (mode == REQUEST) ? m.item : s.item;
                            } else                  // lost match
                                s.casNext(m, mn);   // help unlink
                        }
                    }
                } else {                            // help a fulfiller
                    SNode m = h.next;               // m is h's match
                    if (m == null)                  // waiter is gone
                        casHead(h, null);           // pop fulfilling node
                    else {
                        SNode mn = m.next;
                        if (m.tryMatch(h))          // help match
                            casHead(h, mn);         // pop both h and m
                        else                        // lost match
                            h.casNext(m, mn);       // help unlink
                    }
                }
            }
        }

        /**
         * Spins/blocks until node s is matched by a fulfill operation.
         *
         * @param s the waiting node
         * @param timed true if timed wait
         * @param nanos timeout value
         * @return matched node, or s if cancelled
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.031 -0500", hash_original_method = "8450123659E4F3E3FBDDF976A06B7608", hash_generated_method = "4CFFD7D957932A831BE5B3F2C294BBE1")
        
SNode awaitFulfill(SNode s, boolean timed, long nanos) {
            /*
             * When a node/thread is about to block, it sets its waiter
             * field and then rechecks state at least one more time
             * before actually parking, thus covering race vs
             * fulfiller noticing that waiter is non-null so should be
             * woken.
             *
             * When invoked by nodes that appear at the point of call
             * to be at the head of the stack, calls to park are
             * preceded by spins to avoid blocking when producers and
             * consumers are arriving very close in time.  This can
             * happen enough to bother only on multiprocessors.
             *
             * The order of checks for returning out of main loop
             * reflects fact that interrupts have precedence over
             * normal returns, which have precedence over
             * timeouts. (So, on timeout, one last check for match is
             * done before giving up.) Except that calls from untimed
             * SynchronousQueue.{poll/offer} don't check interrupts
             * and don't wait at all, so are trapped in transfer
             * method rather than calling awaitFulfill.
             */
            long lastTime = timed ? System.nanoTime() : 0;
            Thread w = Thread.currentThread();
            SNode h = head;
            int spins = (shouldSpin(s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);
            for (;;) {
                if (w.isInterrupted())
                    s.tryCancel();
                SNode m = s.match;
                if (m != null)
                    return m;
                if (timed) {
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    if (nanos <= 0) {
                        s.tryCancel();
                        continue;
                    }
                }
                if (spins > 0)
                    spins = shouldSpin(s) ? (spins-1) : 0;
                else if (s.waiter == null)
                    s.waiter = w; // establish waiter so can park next iter
                else if (!timed)
                    LockSupport.park(this);
                else if (nanos > spinForTimeoutThreshold)
                    LockSupport.parkNanos(this, nanos);
            }
        }

        /**
         * Returns true if node s is at head or there is an active
         * fulfiller.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.033 -0500", hash_original_method = "C3C9887957CF791F525718002F2944FE", hash_generated_method = "C3C9887957CF791F525718002F2944FE")
        
boolean shouldSpin(SNode s) {
            SNode h = head;
            return (h == s || h == null || isFulfilling(h.mode));
        }

        /**
         * Unlinks s from the stack.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.036 -0500", hash_original_method = "162514ED54A955A73353466B6689AF5B", hash_generated_method = "DFA1E7C4F516DAF0F8034901108EA5AD")
        
void clean(SNode s) {
            s.item = null;   // forget item
            s.waiter = null; // forget thread

            /*
             * At worst we may need to traverse entire stack to unlink
             * s. If there are multiple concurrent calls to clean, we
             * might not see s if another thread has already removed
             * it. But we can stop when we see any node known to
             * follow s. We use s.next unless it too is cancelled, in
             * which case we try the node one past. We don't check any
             * further because we don't want to doubly traverse just to
             * find sentinel.
             */

            SNode past = s.next;
            if (past != null && past.isCancelled())
                past = past.next;

            // Absorb cancelled nodes at head
            SNode p;
            while ((p = head) != null && p != past && p.isCancelled())
                casHead(p, p.next);

            // Unsplice embedded nodes
            while (p != null && p != past) {
                SNode n = p.next;
                if (n != null && n.isCancelled())
                    p.casNext(n, n.next);
                else
                    p = n;
            }
        }
    }


    
    static final class TransferQueue extends Transferer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.118 -0500", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.120 -0500", hash_original_field = "816C475FC510B73188CF5939CA688D61", hash_generated_field = "718DCD1B9965F259ECF13AAC3FDE17B9")

        private static final long headOffset =
            objectFieldOffset(UNSAFE, "head", TransferQueue.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.123 -0500", hash_original_field = "B89F5AFD0EA3AFC9E2E8DE94AC311FCA", hash_generated_field = "125A3490D6DDA910E4EFF8F5BD5EA3A6")

        private static final long tailOffset =
            objectFieldOffset(UNSAFE, "tail", TransferQueue.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.125 -0500", hash_original_field = "714971327CF2E87E3B3F243AB8D909AC", hash_generated_field = "B8C9CACD31C6DFF4CCC160BE1AA5E90A")

        private static final long cleanMeOffset =
            objectFieldOffset(UNSAFE, "cleanMe", TransferQueue.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.088 -0500", hash_original_field = "33F5BB0DA4AC9D8DADFB7348349E0887", hash_generated_field = "8B563AA5A75BA53BC5C38CBCB00877BD")

        transient volatile QNode head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.091 -0500", hash_original_field = "ABE66FB9B121862D115CD61122660397", hash_generated_field = "28504BE4CF28FABF51A5115491756D5B")

        transient volatile QNode tail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.093 -0500", hash_original_field = "D7776EFE5868024D0C1921AF17CD5469", hash_generated_field = "11DAC5D336C0CE8D6AABAA86A736FB77")

        transient volatile QNode cleanMe;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.096 -0500", hash_original_method = "EBB3C2235277D03D49EE8D8BB02DD64A", hash_generated_method = "378ACBA4C76A2AD94F490EFCC6AD2E17")
        
TransferQueue() {
            QNode h = new QNode(null, false); // initialize to dummy node.
            head = h;
            tail = h;
        }

        /**
         * Tries to cas nh as new head; if successful, unlink
         * old head's next node to avoid garbage retention.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.100 -0500", hash_original_method = "80B021B7B5DA5B6F1F69021D0C7D6F89", hash_generated_method = "A8ED009D63AF0DB88B95A1C303815122")
        
void advanceHead(QNode h, QNode nh) {
            if (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh))
                h.next = h; // forget old next
        }

        /**
         * Tries to cas nt as new tail.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.102 -0500", hash_original_method = "8E334B9D021C7CA1D4C0B314F9C4B69F", hash_generated_method = "8E334B9D021C7CA1D4C0B314F9C4B69F")
        
void advanceTail(QNode t, QNode nt) {
            if (tail == t)
                UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
        }

        
        static final class QNode {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.077 -0500", hash_original_field = "3CDC466E57A745145BB720535953BC43", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.080 -0500", hash_original_field = "F3D243BDC8121C1AAE7A329E57715D21", hash_generated_field = "969A31B3082BB4CF0103955413A3CC24")

            private static final long nextOffset =
                objectFieldOffset(UNSAFE, "next", QNode.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.083 -0500", hash_original_field = "B6349B6E3AF9CB27315E7EC69257267A", hash_generated_field = "C54E8DCAC9CD5157F2D50242395059D2")

            private static final long itemOffset =
                objectFieldOffset(UNSAFE, "item", QNode.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.051 -0500", hash_original_field = "883318BF880BC299B37613DB978F7105", hash_generated_field = "98C54C1386619AED777FF36204F4724D")

            volatile QNode next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.053 -0500", hash_original_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB", hash_generated_field = "572C92874AD4D49E8D97420DECC4EA3C")

            volatile Object item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.056 -0500", hash_original_field = "4DB9CE87B9CCE3428476BDB51EBE9EF1", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.059 -0500", hash_original_field = "13998CD9DB54AD99E9DAFA28EE2691E9", hash_generated_field = "13998CD9DB54AD99E9DAFA28EE2691E9")

             boolean isData;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.062 -0500", hash_original_method = "36E0BDE690B9319BBAE39AE7BB5AED99", hash_generated_method = "36E0BDE690B9319BBAE39AE7BB5AED99")
            
QNode(Object item, boolean isData) {
                this.item = item;
                this.isData = isData;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.064 -0500", hash_original_method = "611C5C34CB4DC255784715588EF3B5E5", hash_generated_method = "611C5C34CB4DC255784715588EF3B5E5")
            
boolean casNext(QNode cmp, QNode val) {
                return next == cmp &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.067 -0500", hash_original_method = "3912AD02565B809FB80AB4089D0BD0C1", hash_generated_method = "3912AD02565B809FB80AB4089D0BD0C1")
            
boolean casItem(Object cmp, Object val) {
                return item == cmp &&
                    UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
            }

            /**
             * Tries to cancel by CAS'ing ref to this as item.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.069 -0500", hash_original_method = "99C72522BA0C395099FBEE5F0489DB78", hash_generated_method = "99C72522BA0C395099FBEE5F0489DB78")
            
void tryCancel(Object cmp) {
                UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.072 -0500", hash_original_method = "45E5A9573D9BA1D0D86064CD1643198D", hash_generated_method = "45E5A9573D9BA1D0D86064CD1643198D")
            
boolean isCancelled() {
                return item == this;
            }

            /**
             * Returns true if this node is known to be off the queue
             * because its next pointer has been forgotten due to
             * an advanceHead operation.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.075 -0500", hash_original_method = "355DAB50A3ED00DA4B9C20D2E0EF6792", hash_generated_method = "355DAB50A3ED00DA4B9C20D2E0EF6792")
            
boolean isOffList() {
                return next == this;
            }
        }

        /**
         * Tries to CAS cleanMe slot.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.104 -0500", hash_original_method = "7A9E3B63F4597B524322C45DD727A635", hash_generated_method = "7A9E3B63F4597B524322C45DD727A635")
        
boolean casCleanMe(QNode cmp, QNode val) {
            return cleanMe == cmp &&
                UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val);
        }

        /**
         * Puts or takes an item.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.108 -0500", hash_original_method = "D9295193CC3F280F47A7E51B4594CC44", hash_generated_method = "39597AA0BBFF2E3754808A73732C3B2E")
        
Object transfer(Object e, boolean timed, long nanos) {
            /* Basic algorithm is to loop trying to take either of
             * two actions:
             *
             * 1. If queue apparently empty or holding same-mode nodes,
             *    try to add node to queue of waiters, wait to be
             *    fulfilled (or cancelled) and return matching item.
             *
             * 2. If queue apparently contains waiting items, and this
             *    call is of complementary mode, try to fulfill by CAS'ing
             *    item field of waiting node and dequeuing it, and then
             *    returning matching item.
             *
             * In each case, along the way, check for and try to help
             * advance head and tail on behalf of other stalled/slow
             * threads.
             *
             * The loop starts off with a null check guarding against
             * seeing uninitialized head or tail values. This never
             * happens in current SynchronousQueue, but could if
             * callers held non-volatile/final ref to the
             * transferer. The check is here anyway because it places
             * null checks at top of loop, which is usually faster
             * than having them implicitly interspersed.
             */

            QNode s = null; // constructed/reused as needed
            boolean isData = (e != null);

            for (;;) {
                QNode t = tail;
                QNode h = head;
                if (t == null || h == null)         // saw uninitialized value
                    continue;                       // spin

                if (h == t || t.isData == isData) { // empty or same-mode
                    QNode tn = t.next;
                    if (t != tail)                  // inconsistent read
                        continue;
                    if (tn != null) {               // lagging tail
                        advanceTail(t, tn);
                        continue;
                    }
                    if (timed && nanos <= 0)        // can't wait
                        return null;
                    if (s == null)
                        s = new QNode(e, isData);
                    if (!t.casNext(null, s))        // failed to link in
                        continue;

                    advanceTail(t, s);              // swing tail and wait
                    Object x = awaitFulfill(s, e, timed, nanos);
                    if (x == s) {                   // wait was cancelled
                        clean(t, s);
                        return null;
                    }

                    if (!s.isOffList()) {           // not already unlinked
                        advanceHead(t, s);          // unlink if head
                        if (x != null)              // and forget fields
                            s.item = s;
                        s.waiter = null;
                    }
                    return (x != null) ? x : e;

                } else {                            // complementary-mode
                    QNode m = h.next;               // node to fulfill
                    if (t != tail || m == null || h != head)
                        continue;                   // inconsistent read

                    Object x = m.item;
                    if (isData == (x != null) ||    // m already fulfilled
                        x == m ||                   // m cancelled
                        !m.casItem(x, e)) {         // lost CAS
                        advanceHead(h, m);          // dequeue and retry
                        continue;
                    }

                    advanceHead(h, m);              // successfully fulfilled
                    LockSupport.unpark(m.waiter);
                    return (x != null) ? x : e;
                }
            }
        }

        /**
         * Spins/blocks until node s is fulfilled.
         *
         * @param s the waiting node
         * @param e the comparison value for checking match
         * @param timed true if timed wait
         * @param nanos timeout value
         * @return matched item, or s if cancelled
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.111 -0500", hash_original_method = "90C8A09C09ECF2EF83975D209FFEEF37", hash_generated_method = "A8FDB298C5482FEDD60D2BD2137BB56B")
        
Object awaitFulfill(QNode s, Object e, boolean timed, long nanos) {
            /* Same idea as TransferStack.awaitFulfill */
            long lastTime = timed ? System.nanoTime() : 0;
            Thread w = Thread.currentThread();
            int spins = ((head.next == s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);
            for (;;) {
                if (w.isInterrupted())
                    s.tryCancel(e);
                Object x = s.item;
                if (x != e)
                    return x;
                if (timed) {
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    if (nanos <= 0) {
                        s.tryCancel(e);
                        continue;
                    }
                }
                if (spins > 0)
                    --spins;
                else if (s.waiter == null)
                    s.waiter = w;
                else if (!timed)
                    LockSupport.park(this);
                else if (nanos > spinForTimeoutThreshold)
                    LockSupport.parkNanos(this, nanos);
            }
        }

        /**
         * Gets rid of cancelled node s with original predecessor pred.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.114 -0500", hash_original_method = "6683A876B1B30ADB5D756618BABF762A", hash_generated_method = "7C212AA488F1DA0DC0630122B4E841CA")
        
void clean(QNode pred, QNode s) {
            s.waiter = null; // forget thread
            /*
             * At any given time, exactly one node on list cannot be
             * deleted -- the last inserted node. To accommodate this,
             * if we cannot delete s, we save its predecessor as
             * "cleanMe", deleting the previously saved version
             * first. At least one of node s or the node previously
             * saved can always be deleted, so this always terminates.
             */
            while (pred.next == s) { // Return early if already unlinked
                QNode h = head;
                QNode hn = h.next;   // Absorb cancelled first node as head
                if (hn != null && hn.isCancelled()) {
                    advanceHead(h, hn);
                    continue;
                }
                QNode t = tail;      // Ensure consistent read for tail
                if (t == h)
                    return;
                QNode tn = t.next;
                if (t != tail)
                    continue;
                if (tn != null) {
                    advanceTail(t, tn);
                    continue;
                }
                if (s != t) {        // If not tail, try to unsplice
                    QNode sn = s.next;
                    if (sn == s || pred.casNext(s, sn))
                        return;
                }
                QNode dp = cleanMe;
                if (dp != null) {    // Try unlinking previous cancelled node
                    QNode d = dp.next;
                    QNode dn;
                    if (d == null ||               // d is gone or
                        d == dp ||                 // d is off list or
                        !d.isCancelled() ||        // d not cancelled or
                        (d != t &&                 // d not tail and
                         (dn = d.next) != null &&  //   has successor
                         dn != d &&                //   that is on list
                         dp.casNext(d, dn)))       // d unspliced
                        casCleanMe(dp, null);
                    if (dp == pred)
                        return;      // s is already saved node
                } else if (casCleanMe(null, pred))
                    return;          // Postpone cleaning s
            }
        }
    }


    
    static class WaitQueue implements java.io.Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_method = "A66BE88BE66C40BD12237E932077BBFA", hash_generated_method = "A66BE88BE66C40BD12237E932077BBFA")
        public WaitQueue ()
        {
            //Synthesized constructor
        }


    }


    
    static class LifoWaitQueue extends WaitQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.195 -0500", hash_original_field = "EA76B80F9BB2344BFEDFCA74BB1F79C0", hash_generated_field = "80F144D9FAF7455012BBD899F5164ED8")

        private static final long serialVersionUID = -3633113410248163686L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_method = "2AB7A8E9C876B74C36AEA136750E93EA", hash_generated_method = "2AB7A8E9C876B74C36AEA136750E93EA")
        public LifoWaitQueue ()
        {
            //Synthesized constructor
        }
    }


    
    static class FifoWaitQueue extends WaitQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.200 -0500", hash_original_field = "FE0C5CE142410432BD37B9AE4A45B68F", hash_generated_field = "736A1D17D87D413A39676344D90E22F2")

        private static final long serialVersionUID = -3623113410248163686L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_method = "2B3543573D85E46D74937DE2E36C8335", hash_generated_method = "2B3543573D85E46D74937DE2E36C8335")
        public FifoWaitQueue ()
        {
            //Synthesized constructor
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.922 -0400", hash_original_method = "490A2A0CCABF1E39472F82358B033503", hash_generated_method = "84D7A76F162F1E3F50F4408A8B9D5B39")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        if(a.length > 0)        
        a[0] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_368967572 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_368967572.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_368967572;
        // ---------- Original Method ----------
        //if (a.length > 0)
            //a[0] = null;
        //return a;
    }

    /**
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.186 -0500", hash_original_method = "B59D7BDF727183928F94F36988272CAC", hash_generated_method = "43BA21948B45680B9E3086B2ECBB9193")
    
public int drainTo(Collection<? super E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        int n = 0;
        E e;
        while ( (e = poll()) != null) {
            c.add(e);
            ++n;
        }
        return n;
    }

    /**
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.189 -0500", hash_original_method = "DA549833C1743125BAA2828712BD0C73", hash_generated_method = "9CB2A82E2766C06A7127C78433890D1C")
    
public int drainTo(Collection<? super E> c, int maxElements) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        int n = 0;
        E e;
        while (n < maxElements && (e = poll()) != null) {
            c.add(e);
            ++n;
        }
        return n;
    }

    /**
     * Save the state to a stream (that is, serialize it).
     *
     * @param s the stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.211 -0500", hash_original_method = "7D89BB192BA936EC93EB72454855578A", hash_generated_method = "536B3BAD8C53964A63CBBA94C57AF0BA")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        boolean fair = transferer instanceof TransferQueue;
        if (fair) {
            qlock = new ReentrantLock(true);
            waitingProducers = new FifoWaitQueue();
            waitingConsumers = new FifoWaitQueue();
        }
        else {
            qlock = new ReentrantLock();
            waitingProducers = new LifoWaitQueue();
            waitingConsumers = new LifoWaitQueue();
        }
        s.defaultWriteObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:13.213 -0500", hash_original_method = "E156E82E550566200FEDBE52C0090F6F", hash_generated_method = "169114DD0170E9525D13813F1CB95930")
    
private void readObject(final java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        if (waitingProducers instanceof FifoWaitQueue)
            transferer = new TransferQueue();
        else
            transferer = new TransferStack();
    }
}

