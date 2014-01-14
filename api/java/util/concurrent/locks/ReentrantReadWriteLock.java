package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.781 -0500", hash_original_field = "5125F3CA0DED7D5C54780956A89AA642", hash_generated_field = "97706C97453A3073601BD3C0219ECA94")

    private static final long serialVersionUID = -6992448646407690164L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.783 -0500", hash_original_field = "5405B3C353BE92755DCB85A636E2B95C", hash_generated_field = "8F79220737B731E52680B143D15FE029")

    private  ReentrantReadWriteLock.ReadLock readerLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.786 -0500", hash_original_field = "C5207098B70E906FA382536F059E39FC", hash_generated_field = "1E1067A0A17FE39A5B241BAB85413180")

    private  ReentrantReadWriteLock.WriteLock writerLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.788 -0500", hash_original_field = "791C2888A6F5CDC158445182FD1E3538", hash_generated_field = "791C2888A6F5CDC158445182FD1E3538")

     Sync sync;

    /**
     * Creates a new {@code ReentrantReadWriteLock} with
     * default (nonfair) ordering properties.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.792 -0500", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "69758B01510A7D7577C7DBEF09A98D66")
    
public ReentrantReadWriteLock() {
        this(false);
    }

    /**
     * Creates a new {@code ReentrantReadWriteLock} with
     * the given fairness policy.
     *
     * @param fair {@code true} if this lock should use a fair ordering policy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.795 -0500", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "B36353190569D687506C14387FE90257")
    
public ReentrantReadWriteLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.797 -0500", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "0A3ACCFFDE9D727FD4D1A017A5E8C71A")
    
public ReentrantReadWriteLock.WriteLock writeLock() { return writerLock; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.799 -0500", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "15D9C8959D307D72A44851BD830CC7F8")
    
public ReentrantReadWriteLock.ReadLock  readLock()  { return readerLock; }

    // Instrumentation and status

    /**
     * Returns {@code true} if this lock has fairness set true.
     *
     * @return {@code true} if this lock has fairness set true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.992 -0500", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "FD5B86C0AAA17846C7B1961516E570A6")
    
public final boolean isFair() {
        return sync instanceof FairSync;
    }

    /**
     * Returns the thread that currently owns the write lock, or
     * {@code null} if not owned. When this method is called by a
     * thread that is not the owner, the return value reflects a
     * best-effort approximation of current lock status. For example,
     * the owner may be momentarily {@code null} even if there are
     * threads trying to acquire the lock but have not yet done so.
     * This method is designed to facilitate construction of
     * subclasses that provide more extensive lock monitoring
     * facilities.
     *
     * @return the owner, or {@code null} if not owned
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.994 -0500", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "7D809D9725AEBCF90CFF1BEB201EC3EB")
    
protected Thread getOwner() {
        return sync.getOwner();
    }

    /**
     * Queries the number of read locks held for this lock. This
     * method is designed for use in monitoring system state, not for
     * synchronization control.
     * @return the number of read locks held.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.996 -0500", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "81D4728E1A8C21835B677C243A85E9DF")
    
public int getReadLockCount() {
        return sync.getReadLockCount();
    }

    /**
     * Queries if the write lock is held by any thread. This method is
     * designed for use in monitoring system state, not for
     * synchronization control.
     *
     * @return {@code true} if any thread holds the write lock and
     *         {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.999 -0500", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "2117D05BC797B7F9D458E14615160048")
    
public boolean isWriteLocked() {
        return sync.isWriteLocked();
    }

    /**
     * Queries if the write lock is held by the current thread.
     *
     * @return {@code true} if the current thread holds the write lock and
     *         {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.001 -0500", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "21A737727C553D707D4315ADABED88D6")
    
public boolean isWriteLockedByCurrentThread() {
        return sync.isHeldExclusively();
    }

    /**
     * Queries the number of reentrant write holds on this lock by the
     * current thread.  A writer thread has a hold on a lock for
     * each lock action that is not matched by an unlock action.
     *
     * @return the number of holds on the write lock by the current thread,
     *         or zero if the write lock is not held by the current thread
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.003 -0500", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "66EE792F97EF9FE380B4508044D76586")
    
public int getWriteHoldCount() {
        return sync.getWriteHoldCount();
    }

    /**
     * Queries the number of reentrant read holds on this lock by the
     * current thread.  A reader thread has a hold on a lock for
     * each lock action that is not matched by an unlock action.
     *
     * @return the number of holds on the read lock by the current thread,
     *         or zero if the read lock is not held by the current thread
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.006 -0500", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "40B0904C050C4F8C0386824FA31AF296")
    
public int getReadHoldCount() {
        return sync.getReadHoldCount();
    }

    /**
     * Returns a collection containing threads that may be waiting to
     * acquire the write lock.  Because the actual set of threads may
     * change dynamically while constructing this result, the returned
     * collection is only a best-effort estimate.  The elements of the
     * returned collection are in no particular order.  This method is
     * designed to facilitate construction of subclasses that provide
     * more extensive lock monitoring facilities.
     *
     * @return the collection of threads
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.008 -0500", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "DC057A4F8539B23B41B665ED2F68A369")
    
protected Collection<Thread> getQueuedWriterThreads() {
        return sync.getExclusiveQueuedThreads();
    }

    /**
     * Returns a collection containing threads that may be waiting to
     * acquire the read lock.  Because the actual set of threads may
     * change dynamically while constructing this result, the returned
     * collection is only a best-effort estimate.  The elements of the
     * returned collection are in no particular order.  This method is
     * designed to facilitate construction of subclasses that provide
     * more extensive lock monitoring facilities.
     *
     * @return the collection of threads
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.010 -0500", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "30845F8CD401249AD93F35EA7713DA47")
    
protected Collection<Thread> getQueuedReaderThreads() {
        return sync.getSharedQueuedThreads();
    }

    /**
     * Queries whether any threads are waiting to acquire the read or
     * write lock. Note that because cancellations may occur at any
     * time, a {@code true} return does not guarantee that any other
     * thread will ever acquire a lock.  This method is designed
     * primarily for use in monitoring of the system state.
     *
     * @return {@code true} if there may be other threads waiting to
     *         acquire the lock
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.012 -0500", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "C7584A6E76176296EE4C3AD9AFE15C2D")
    
public final boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    /**
     * Queries whether the given thread is waiting to acquire either
     * the read or write lock. Note that because cancellations may
     * occur at any time, a {@code true} return does not guarantee
     * that this thread will ever acquire a lock.  This method is
     * designed primarily for use in monitoring of the system state.
     *
     * @param thread the thread
     * @return {@code true} if the given thread is queued waiting for this lock
     * @throws NullPointerException if the thread is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.015 -0500", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "CAF9172ED60C1F675B6C52C2952927BD")
    
public final boolean hasQueuedThread(Thread thread) {
        return sync.isQueued(thread);
    }

    /**
     * Returns an estimate of the number of threads waiting to acquire
     * either the read or write lock.  The value is only an estimate
     * because the number of threads may change dynamically while this
     * method traverses internal data structures.  This method is
     * designed for use in monitoring of the system state, not for
     * synchronization control.
     *
     * @return the estimated number of threads waiting for this lock
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.018 -0500", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "EA91B63888B7C015D6A36669988D4E4A")
    
public final int getQueueLength() {
        return sync.getQueueLength();
    }

    /**
     * Returns a collection containing threads that may be waiting to
     * acquire either the read or write lock.  Because the actual set
     * of threads may change dynamically while constructing this
     * result, the returned collection is only a best-effort estimate.
     * The elements of the returned collection are in no particular
     * order.  This method is designed to facilitate construction of
     * subclasses that provide more extensive monitoring facilities.
     *
     * @return the collection of threads
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.020 -0500", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "D67E7603910B1CF790C49F196A7D918E")
    
protected Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }

    /**
     * Queries whether any threads are waiting on the given condition
     * associated with the write lock. Note that because timeouts and
     * interrupts may occur at any time, a {@code true} return does
     * not guarantee that a future {@code signal} will awaken any
     * threads.  This method is designed primarily for use in
     * monitoring of the system state.
     *
     * @param condition the condition
     * @return {@code true} if there are any waiting threads
     * @throws IllegalMonitorStateException if this lock is not held
     * @throws IllegalArgumentException if the given condition is
     *         not associated with this lock
     * @throws NullPointerException if the condition is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.023 -0500", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "D8A38DC1495D3D0A873765D6F9A8A45B")
    
public boolean hasWaiters(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    /**
     * Returns an estimate of the number of threads waiting on the
     * given condition associated with the write lock. Note that because
     * timeouts and interrupts may occur at any time, the estimate
     * serves only as an upper bound on the actual number of waiters.
     * This method is designed for use in monitoring of the system
     * state, not for synchronization control.
     *
     * @param condition the condition
     * @return the estimated number of waiting threads
     * @throws IllegalMonitorStateException if this lock is not held
     * @throws IllegalArgumentException if the given condition is
     *         not associated with this lock
     * @throws NullPointerException if the condition is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.025 -0500", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "40766DA87AAD6F72617A1756D40A4217")
    
public int getWaitQueueLength(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    /**
     * Returns a collection containing those threads that may be
     * waiting on the given condition associated with the write lock.
     * Because the actual set of threads may change dynamically while
     * constructing this result, the returned collection is only a
     * best-effort estimate. The elements of the returned collection
     * are in no particular order.  This method is designed to
     * facilitate construction of subclasses that provide more
     * extensive condition monitoring facilities.
     *
     * @param condition the condition
     * @return the collection of threads
     * @throws IllegalMonitorStateException if this lock is not held
     * @throws IllegalArgumentException if the given condition is
     *         not associated with this lock
     * @throws NullPointerException if the condition is null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.028 -0500", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "5F349F071ADC291E2ABB5B930AB4DBAB")
    
protected Collection<Thread> getWaitingThreads(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }
    
    abstract static class Sync extends AbstractQueuedSynchronizer {

        /** Returns the number of shared holds represented in count  */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.815 -0500", hash_original_method = "DDE7ADD45E524E72C4E1EDD9156B853C", hash_generated_method = "1440F90E58EAA76F027CC9D33EF31FD7")
        
static int sharedCount(int c)    { return c >>> SHARED_SHIFT; }
        /** Returns the number of exclusive holds represented in count  */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.818 -0500", hash_original_method = "B9F2E25335CFA4041C18F9D081EBA76A", hash_generated_method = "1DBB44439BE4E94543DE542D67E42F8C")
        
static int exclusiveCount(int c) { return c & EXCLUSIVE_MASK; }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.802 -0500", hash_original_field = "45270D46260F0F93203EA89F9836E03F", hash_generated_field = "7C931A0AA0CAF43860EA5D05E5F8B303")

        private static final long serialVersionUID = 6317671515068378041L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.805 -0500", hash_original_field = "514ED55D75AE61BDC86BAC43C31A8A6F", hash_generated_field = "1BECA78E8EF9C81EDFA90AF6033A5F51")

        static final int SHARED_SHIFT   = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.808 -0500", hash_original_field = "6E6B641264DAB0F7A92817D961797A22", hash_generated_field = "C8AB687482F52B5D1545D9BC8249F0D6")

        static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.810 -0500", hash_original_field = "DF361478EECF13C7A7E6055F127DD620", hash_generated_field = "921A8713594E39243E9A93B111B6F582")

        static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.813 -0500", hash_original_field = "27BD638A0981EFFCC9379B5A29D421FB", hash_generated_field = "060B47E79661495F6885046EB813A43B")

        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.834 -0500", hash_original_field = "AAD12A111502ABF23CA7847F1248ABAE", hash_generated_field = "8C4B3BD798FE5D7E8EB3D0536576D262")

        private transient ThreadLocalHoldCounter readHolds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.837 -0500", hash_original_field = "238858AB3A924B4CD05963E367F0BFF1", hash_generated_field = "2EE67430D3D959E367F77E7EF6425C16")

        private transient HoldCounter cachedHoldCounter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.839 -0500", hash_original_field = "FB72E357297A1373725828687312783B", hash_generated_field = "A011FC8C4363F320801F082EF2C621C1")

        private transient Thread firstReader = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.841 -0500", hash_original_field = "35CBDC48BEFADBF1F5A8DF640D1FDFF9", hash_generated_field = "D6E4ACE63DE2E9B4DD29D78376D1F793")

        private transient int firstReaderHoldCount;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.844 -0500", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "949C34BABE6CCFC193480D877210A394")
        
Sync() {
            readHolds = new ThreadLocalHoldCounter();
            setState(getState()); // ensures visibility of readHolds
        }

        /*
         * Acquires and releases use the same code for fair and
         * nonfair locks, but differ in whether/how they allow barging
         * when queues are non-empty.
         */

        /**
         * Returns true if the current thread, when trying to acquire
         * the read lock, and otherwise eligible to do so, should block
         * because of policy for overtaking other waiting threads.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.846 -0500", hash_original_method = "201F9826B03823A5A29F5AEBB37490EC", hash_generated_method = "77898C42969EABF3C3D5D162CFA48CDB")
        
abstract boolean readerShouldBlock();

        /**
         * Returns true if the current thread, when trying to acquire
         * the write lock, and otherwise eligible to do so, should block
         * because of policy for overtaking other waiting threads.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.849 -0500", hash_original_method = "E8357FCECBEFA04C31CAFC447C5F8BBA", hash_generated_method = "C8595BDC04181682726D0E455F65F9E9")
        
abstract boolean writerShouldBlock();

        /*
         * Note that tryRelease and tryAcquire can be called by
         * Conditions. So it is possible that their arguments contain
         * both read and write holds that are all released during a
         * condition wait and re-established in tryAcquire.
         */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.852 -0500", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "08E0DE05E78B4E48A96964139FB87021")
        
protected final boolean tryRelease(int releases) {
            if (!isHeldExclusively())
                throw new IllegalMonitorStateException();
            int nextc = getState() - releases;
            boolean free = exclusiveCount(nextc) == 0;
            if (free)
                setExclusiveOwnerThread(null);
            setState(nextc);
            return free;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.855 -0500", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "E3D23A731FF03427729213A4FBB69103")
        
protected final boolean tryAcquire(int acquires) {
            /*
             * Walkthrough:
             * 1. If read count nonzero or write count nonzero
             *    and owner is a different thread, fail.
             * 2. If count would saturate, fail. (This can only
             *    happen if count is already nonzero.)
             * 3. Otherwise, this thread is eligible for lock if
             *    it is either a reentrant acquire or
             *    queue policy allows it. If so, update state
             *    and set owner.
             */
            Thread current = Thread.currentThread();
            int c = getState();
            int w = exclusiveCount(c);
            if (c != 0) {
                // (Note: if c != 0 and w == 0 then shared count != 0)
                if (w == 0 || current != getExclusiveOwnerThread())
                    return false;
                if (w + exclusiveCount(acquires) > MAX_COUNT)
                    throw new Error("Maximum lock count exceeded");
                // Reentrant acquire
                setState(c + acquires);
                return true;
            }
            if (writerShouldBlock() ||
                !compareAndSetState(c, c + acquires))
                return false;
            setExclusiveOwnerThread(current);
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.859 -0500", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "AC92006BA155D030233EBB5989F410FF")
        
protected final boolean tryReleaseShared(int unused) {
            Thread current = Thread.currentThread();
            if (firstReader == current) {
                // assert firstReaderHoldCount > 0;
                if (firstReaderHoldCount == 1)
                    firstReader = null;
                else
                    firstReaderHoldCount--;
            } else {
                HoldCounter rh = cachedHoldCounter;
                if (rh == null || rh.tid != current.getId())
                    rh = readHolds.get();
                int count = rh.count;
                if (count <= 1) {
                    readHolds.remove();
                    if (count <= 0)
                        throw unmatchedUnlockException();
                }
                --rh.count;
            }
            for (;;) {
                int c = getState();
                int nextc = c - SHARED_UNIT;
                if (compareAndSetState(c, nextc))
                    // Releasing the read lock has no effect on readers,
                    // but it may allow waiting writers to proceed if
                    // both read and write locks are now free.
                    return nextc == 0;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.861 -0500", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "45FF0780BFBC1D461B46EBE7B649EDDE")
        
private IllegalMonitorStateException unmatchedUnlockException() {
            return new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.864 -0500", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "5020C5EB19617E63722653A6BC5C9951")
        
protected final int tryAcquireShared(int unused) {
            /*
             * Walkthrough:
             * 1. If write lock held by another thread, fail.
             * 2. Otherwise, this thread is eligible for
             *    lock wrt state, so ask if it should block
             *    because of queue policy. If not, try
             *    to grant by CASing state and updating count.
             *    Note that step does not check for reentrant
             *    acquires, which is postponed to full version
             *    to avoid having to check hold count in
             *    the more typical non-reentrant case.
             * 3. If step 2 fails either because thread
             *    apparently not eligible or CAS fails or count
             *    saturated, chain to version with full retry loop.
             */
            Thread current = Thread.currentThread();
            int c = getState();
            if (exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current)
                return -1;
            int r = sharedCount(c);
            if (!readerShouldBlock() &&
                r < MAX_COUNT &&
                compareAndSetState(c, c + SHARED_UNIT)) {
                if (r == 0) {
                    firstReader = current;
                    firstReaderHoldCount = 1;
                } else if (firstReader == current) {
                    firstReaderHoldCount++;
                } else {
                    HoldCounter rh = cachedHoldCounter;
                    if (rh == null || rh.tid != current.getId())
                        cachedHoldCounter = rh = readHolds.get();
                    else if (rh.count == 0)
                        readHolds.set(rh);
                    rh.count++;
                }
                return 1;
            }
            return fullTryAcquireShared(current);
        }

        /**
         * Full version of acquire for reads, that handles CAS misses
         * and reentrant reads not dealt with in tryAcquireShared.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.868 -0500", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "CEC6FDF9AC0F545126E9D95E870B551C")
        
final int fullTryAcquireShared(Thread current) {
            /*
             * This code is in part redundant with that in
             * tryAcquireShared but is simpler overall by not
             * complicating tryAcquireShared with interactions between
             * retries and lazily reading hold counts.
             */
            HoldCounter rh = null;
            for (;;) {
                int c = getState();
                if (exclusiveCount(c) != 0) {
                    if (getExclusiveOwnerThread() != current)
                        return -1;
                    // else we hold the exclusive lock; blocking here
                    // would cause deadlock.
                } else if (readerShouldBlock()) {
                    // Make sure we're not acquiring read lock reentrantly
                    if (firstReader == current) {
                        // assert firstReaderHoldCount > 0;
                    } else {
                        if (rh == null) {
                            rh = cachedHoldCounter;
                            if (rh == null || rh.tid != current.getId()) {
                                rh = readHolds.get();
                                if (rh.count == 0)
                                    readHolds.remove();
                            }
                        }
                        if (rh.count == 0)
                            return -1;
                    }
                }
                if (sharedCount(c) == MAX_COUNT)
                    throw new Error("Maximum lock count exceeded");
                if (compareAndSetState(c, c + SHARED_UNIT)) {
                    if (sharedCount(c) == 0) {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } else if (firstReader == current) {
                        firstReaderHoldCount++;
                    } else {
                        if (rh == null)
                            rh = cachedHoldCounter;
                        if (rh == null || rh.tid != current.getId())
                            rh = readHolds.get();
                        else if (rh.count == 0)
                            readHolds.set(rh);
                        rh.count++;
                        cachedHoldCounter = rh; // cache for release
                    }
                    return 1;
                }
            }
        }

        /**
         * Performs tryLock for write, enabling barging in both modes.
         * This is identical in effect to tryAcquire except for lack
         * of calls to writerShouldBlock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.871 -0500", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "3177059FA0974AB49198E3DBBAFCAE8D")
        
final boolean tryWriteLock() {
            Thread current = Thread.currentThread();
            int c = getState();
            if (c != 0) {
                int w = exclusiveCount(c);
                if (w == 0 || current != getExclusiveOwnerThread())
                    return false;
                if (w == MAX_COUNT)
                    throw new Error("Maximum lock count exceeded");
            }
            if (!compareAndSetState(c, c + 1))
                return false;
            setExclusiveOwnerThread(current);
            return true;
        }

        /**
         * Performs tryLock for read, enabling barging in both modes.
         * This is identical in effect to tryAcquireShared except for
         * lack of calls to readerShouldBlock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.873 -0500", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "B464259909393965EF4FCB5D7D4BB70F")
        
final boolean tryReadLock() {
            Thread current = Thread.currentThread();
            for (;;) {
                int c = getState();
                if (exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current)
                    return false;
                int r = sharedCount(c);
                if (r == MAX_COUNT)
                    throw new Error("Maximum lock count exceeded");
                if (compareAndSetState(c, c + SHARED_UNIT)) {
                    if (r == 0) {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } else if (firstReader == current) {
                        firstReaderHoldCount++;
                    } else {
                        HoldCounter rh = cachedHoldCounter;
                        if (rh == null || rh.tid != current.getId())
                            cachedHoldCounter = rh = readHolds.get();
                        else if (rh.count == 0)
                            readHolds.set(rh);
                        rh.count++;
                    }
                    return true;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.876 -0500", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "F9F3075EA01C68039167225BB13CE9C6")
        
protected final boolean isHeldExclusively() {
            // While we must in general read state before owner,
            // we don't need to do so to check if current thread is owner
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        // Methods relayed to outer class

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.878 -0500", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "2CCC1BFDC1E662866A1BCF57D99E767B")
        
final ConditionObject newCondition() {
            return new ConditionObject();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.881 -0500", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "2A81C91C9CF4977398262F45A15F123C")
        
final Thread getOwner() {
            // Must read state before owner to ensure memory consistency
            return ((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread());
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.885 -0500", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "70B1017DC4573EE88B0D7E61602E41E3")
        
final int getReadLockCount() {
            return sharedCount(getState());
        }
        
        static final class HoldCounter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.821 -0500", hash_original_field = "B524E41AA0CF6AD39267F32C8C687778", hash_generated_field = "B524E41AA0CF6AD39267F32C8C687778")

            int count = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.824 -0500", hash_original_field = "0A37A20E7316460B86A4063014209DB0", hash_generated_field = "B08EBA558D35D7351A04ACA0D52B3632")

            final long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_method = "F1D8E352EDEF0AB237A69949FE7423C4", hash_generated_method = "F1D8E352EDEF0AB237A69949FE7423C4")
            public HoldCounter ()
            {
                //Synthesized constructor
            }

        }
        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_method = "2811BFD99460ECBD8E7948B925FFB736", hash_generated_method = "2811BFD99460ECBD8E7948B925FFB736")
            public ThreadLocalHoldCounter ()
            {
                //Synthesized constructor
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.829 -0500", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "2E449DB80E85BE633320A832E307DE2A")
            
public HoldCounter initialValue() {
                return new HoldCounter();
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.887 -0500", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "C8CCB07F6B73252A5A6DEBDD95C0D903")
        
final boolean isWriteLocked() {
            return exclusiveCount(getState()) != 0;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.890 -0500", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "1A5CD41D0F54331F3DA170A7F5F382C9")
        
final int getWriteHoldCount() {
            return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.892 -0500", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "3734AFA67585F383C17722410DF855E0")
        
final int getReadHoldCount() {
            if (getReadLockCount() == 0)
                return 0;

            Thread current = Thread.currentThread();
            if (firstReader == current)
                return firstReaderHoldCount;

            HoldCounter rh = cachedHoldCounter;
            if (rh != null && rh.tid == current.getId())
                return rh.count;

            int count = readHolds.get().count;
            if (count == 0) readHolds.remove();
            return count;
        }

        /**
         * Reconstitute this lock instance from a stream
         * @param s the stream
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.895 -0500", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "68324843DD5986460A47B84AF40ED1F8")
        
private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            readHolds = new ThreadLocalHoldCounter();
            setState(0); // reset to unlocked state
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.897 -0500", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "B311E96C96E5C2D7A37352E387E7596A")
        
final int getCount() { return getState(); }
    }
    
    static final class NonfairSync extends Sync {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.906 -0500", hash_original_field = "AFC6039745D03A04E531905884C8B23E", hash_generated_field = "F3A4EB2F8018DB6E004273D21E41E16C")

        private static final long serialVersionUID = -8159625535654395037L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.605 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.909 -0500", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "806D88B36E0818E3049D1A0CD79944C1")
        
final boolean writerShouldBlock() {
            return false; // writers can always barge
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.912 -0500", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "CBD5356C26087F941C0097E7D8C1F976")
        
final boolean readerShouldBlock() {
            /* As a heuristic to avoid indefinite writer starvation,
             * block if the thread that momentarily appears to be head
             * of queue, if one exists, is a waiting writer.  This is
             * only a probabilistic effect since a new reader will not
             * block if there is a waiting writer behind other enabled
             * readers that have not yet drained from the queue.
             */
            return apparentlyFirstQueuedIsExclusive();
        }
    }
    
    static final class FairSync extends Sync {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.917 -0500", hash_original_field = "C6D8E4EA97857146A2123FB8B84335BB", hash_generated_field = "076791917E0837F6FCF483EA9968303D")

        private static final long serialVersionUID = -2274990926593161451L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.919 -0500", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "F886287F89CC912AECC6FC9BF120BE79")
        
final boolean writerShouldBlock() {
            return hasQueuedPredecessors();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.921 -0500", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "5FD407394D01BD8359285FC93C35B196")
        
final boolean readerShouldBlock() {
            return hasQueuedPredecessors();
        }
    }
    
    public static class ReadLock implements Lock, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.927 -0500", hash_original_field = "69EEF10B0BBA63D3F12F2D7C00D388EC", hash_generated_field = "86BBAC3B6DE594ADDDD3BFD814E519BB")

        private static final long serialVersionUID = -5992448646407690164L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.930 -0500", hash_original_field = "791C2888A6F5CDC158445182FD1E3538", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private  Sync sync;

        /**
         * Constructor for use by subclasses
         *
         * @param lock the outer lock object
         * @throws NullPointerException if the lock is null
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.933 -0500", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "296C51F1422A862B006DED3F1273D51C")
        
protected ReadLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
        }

        /**
         * Acquires the read lock.
         *
         * <p>Acquires the read lock if the write lock is not held by
         * another thread and returns immediately.
         *
         * <p>If the write lock is held by another thread then
         * the current thread becomes disabled for thread scheduling
         * purposes and lies dormant until the read lock has been acquired.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.935 -0500", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "769F611D35BC72B43B277CCC24256709")
        
public void lock() {
            sync.acquireShared(1);
        }

        /**
         * Acquires the read lock unless the current thread is
         * {@linkplain Thread#interrupt interrupted}.
         *
         * <p>Acquires the read lock if the write lock is not held
         * by another thread and returns immediately.
         *
         * <p>If the write lock is held by another thread then the
         * current thread becomes disabled for thread scheduling
         * purposes and lies dormant until one of two things happens:
         *
         * <ul>
         *
         * <li>The read lock is acquired by the current thread; or
         *
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread.
         *
         * </ul>
         *
         * <p>If the current thread:
         *
         * <ul>
         *
         * <li>has its interrupted status set on entry to this method; or
         *
         * <li>is {@linkplain Thread#interrupt interrupted} while
         * acquiring the read lock,
         *
         * </ul>
         *
         * then {@link InterruptedException} is thrown and the current
         * thread's interrupted status is cleared.
         *
         * <p>In this implementation, as this method is an explicit
         * interruption point, preference is given to responding to
         * the interrupt over normal or reentrant acquisition of the
         * lock.
         *
         * @throws InterruptedException if the current thread is interrupted
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.938 -0500", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "EE8113F787291DE8349F7130EAC23868")
        
public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
        }

        /**
         * Acquires the read lock only if the write lock is not held by
         * another thread at the time of invocation.
         *
         * <p>Acquires the read lock if the write lock is not held by
         * another thread and returns immediately with the value
         * {@code true}. Even when this lock has been set to use a
         * fair ordering policy, a call to {@code tryLock()}
         * <em>will</em> immediately acquire the read lock if it is
         * available, whether or not other threads are currently
         * waiting for the read lock.  This &quot;barging&quot; behavior
         * can be useful in certain circumstances, even though it
         * breaks fairness. If you want to honor the fairness setting
         * for this lock, then use {@link #tryLock(long, TimeUnit)
         * tryLock(0, TimeUnit.SECONDS) } which is almost equivalent
         * (it also detects interruption).
         *
         * <p>If the write lock is held by another thread then
         * this method will return immediately with the value
         * {@code false}.
         *
         * @return {@code true} if the read lock was acquired
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.940 -0500", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "922205F316BADD52FE72F8405B07147F")
        
public  boolean tryLock() {
            return sync.tryReadLock();
        }

        /**
         * Acquires the read lock if the write lock is not held by
         * another thread within the given waiting time and the
         * current thread has not been {@linkplain Thread#interrupt
         * interrupted}.
         *
         * <p>Acquires the read lock if the write lock is not held by
         * another thread and returns immediately with the value
         * {@code true}. If this lock has been set to use a fair
         * ordering policy then an available lock <em>will not</em> be
         * acquired if any other threads are waiting for the
         * lock. This is in contrast to the {@link #tryLock()}
         * method. If you want a timed {@code tryLock} that does
         * permit barging on a fair lock then combine the timed and
         * un-timed forms together:
         *
         * <pre>if (lock.tryLock() || lock.tryLock(timeout, unit) ) { ... }
         * </pre>
         *
         * <p>If the write lock is held by another thread then the
         * current thread becomes disabled for thread scheduling
         * purposes and lies dormant until one of three things happens:
         *
         * <ul>
         *
         * <li>The read lock is acquired by the current thread; or
         *
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread; or
         *
         * <li>The specified waiting time elapses.
         *
         * </ul>
         *
         * <p>If the read lock is acquired then the value {@code true} is
         * returned.
         *
         * <p>If the current thread:
         *
         * <ul>
         *
         * <li>has its interrupted status set on entry to this method; or
         *
         * <li>is {@linkplain Thread#interrupt interrupted} while
         * acquiring the read lock,
         *
         * </ul> then {@link InterruptedException} is thrown and the
         * current thread's interrupted status is cleared.
         *
         * <p>If the specified waiting time elapses then the value
         * {@code false} is returned.  If the time is less than or
         * equal to zero, the method will not wait at all.
         *
         * <p>In this implementation, as this method is an explicit
         * interruption point, preference is given to responding to
         * the interrupt over normal or reentrant acquisition of the
         * lock, and over reporting the elapse of the waiting time.
         *
         * @param timeout the time to wait for the read lock
         * @param unit the time unit of the timeout argument
         * @return {@code true} if the read lock was acquired
         * @throws InterruptedException if the current thread is interrupted
         * @throws NullPointerException if the time unit is null
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.943 -0500", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "D334E7A8BE3D3DC56FBD75FBF77F3F0B")
        
public boolean tryLock(long timeout, TimeUnit unit)
                throws InterruptedException {
            return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        /**
         * Attempts to release this lock.
         *
         * <p> If the number of readers is now zero then the lock
         * is made available for write lock attempts.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.946 -0500", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "82E12AC0FA5A076FD53B26E249AF894E")
        
public  void unlock() {
            sync.releaseShared(1);
        }

        /**
         * Throws {@code UnsupportedOperationException} because
         * {@code ReadLocks} do not support conditions.
         *
         * @throws UnsupportedOperationException always
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.948 -0500", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "52C706F22DB50CE110DADAEB9C11BD24")
        
public Condition newCondition() {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns a string identifying this lock, as well as its lock state.
         * The state, in brackets, includes the String {@code "Read locks ="}
         * followed by the number of held read locks.
         *
         * @return a string identifying this lock, as well as its lock state
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.951 -0500", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "FD220944E14D3FC19B755610A77E9D75")
        
public String toString() {
            int r = sync.getReadLockCount();
            return super.toString() +
                "[Read locks = " + r + "]";
        }
    }
    
    public static class WriteLock implements Lock, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.957 -0500", hash_original_field = "3D8CBE12F4BBAC86739C1B5BE42FCFCB", hash_generated_field = "91D8216ACB8E5ABFDC6C81788A99A4AB")

        private static final long serialVersionUID = -4992448646407690164L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.960 -0500", hash_original_field = "791C2888A6F5CDC158445182FD1E3538", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private  Sync sync;

        /**
         * Constructor for use by subclasses
         *
         * @param lock the outer lock object
         * @throws NullPointerException if the lock is null
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.962 -0500", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "9B795EF11BD261A20423A4FFD5389B2C")
        
protected WriteLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
        }

        /**
         * Acquires the write lock.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately, setting the write lock hold count to
         * one.
         *
         * <p>If the current thread already holds the write lock then the
         * hold count is incremented by one and the method returns
         * immediately.
         *
         * <p>If the lock is held by another thread then the current
         * thread becomes disabled for thread scheduling purposes and
         * lies dormant until the write lock has been acquired, at which
         * time the write lock hold count is set to one.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.965 -0500", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "8D087EDFDCF1D880293070705EAF5998")
        
public void lock() {
            sync.acquire(1);
        }

        /**
         * Acquires the write lock unless the current thread is
         * {@linkplain Thread#interrupt interrupted}.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately, setting the write lock hold count to
         * one.
         *
         * <p>If the current thread already holds this lock then the
         * hold count is incremented by one and the method returns
         * immediately.
         *
         * <p>If the lock is held by another thread then the current
         * thread becomes disabled for thread scheduling purposes and
         * lies dormant until one of two things happens:
         *
         * <ul>
         *
         * <li>The write lock is acquired by the current thread; or
         *
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread.
         *
         * </ul>
         *
         * <p>If the write lock is acquired by the current thread then the
         * lock hold count is set to one.
         *
         * <p>If the current thread:
         *
         * <ul>
         *
         * <li>has its interrupted status set on entry to this method;
         * or
         *
         * <li>is {@linkplain Thread#interrupt interrupted} while
         * acquiring the write lock,
         *
         * </ul>
         *
         * then {@link InterruptedException} is thrown and the current
         * thread's interrupted status is cleared.
         *
         * <p>In this implementation, as this method is an explicit
         * interruption point, preference is given to responding to
         * the interrupt over normal or reentrant acquisition of the
         * lock.
         *
         * @throws InterruptedException if the current thread is interrupted
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.967 -0500", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "99377CF76908D3005FAA9EC94629A986")
        
public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
        }

        /**
         * Acquires the write lock only if it is not held by another thread
         * at the time of invocation.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately with the value {@code true},
         * setting the write lock hold count to one. Even when this lock has
         * been set to use a fair ordering policy, a call to
         * {@code tryLock()} <em>will</em> immediately acquire the
         * lock if it is available, whether or not other threads are
         * currently waiting for the write lock.  This &quot;barging&quot;
         * behavior can be useful in certain circumstances, even
         * though it breaks fairness. If you want to honor the
         * fairness setting for this lock, then use {@link
         * #tryLock(long, TimeUnit) tryLock(0, TimeUnit.SECONDS) }
         * which is almost equivalent (it also detects interruption).
         *
         * <p> If the current thread already holds this lock then the
         * hold count is incremented by one and the method returns
         * {@code true}.
         *
         * <p>If the lock is held by another thread then this method
         * will return immediately with the value {@code false}.
         *
         * @return {@code true} if the lock was free and was acquired
         * by the current thread, or the write lock was already held
         * by the current thread; and {@code false} otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.969 -0500", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "430545547505370C0D0D0AAB416072E7")
        
public boolean tryLock( ) {
            return sync.tryWriteLock();
        }

        /**
         * Acquires the write lock if it is not held by another thread
         * within the given waiting time and the current thread has
         * not been {@linkplain Thread#interrupt interrupted}.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately with the value {@code true},
         * setting the write lock hold count to one. If this lock has been
         * set to use a fair ordering policy then an available lock
         * <em>will not</em> be acquired if any other threads are
         * waiting for the write lock. This is in contrast to the {@link
         * #tryLock()} method. If you want a timed {@code tryLock}
         * that does permit barging on a fair lock then combine the
         * timed and un-timed forms together:
         *
         * <pre>if (lock.tryLock() || lock.tryLock(timeout, unit) ) { ... }
         * </pre>
         *
         * <p>If the current thread already holds this lock then the
         * hold count is incremented by one and the method returns
         * {@code true}.
         *
         * <p>If the lock is held by another thread then the current
         * thread becomes disabled for thread scheduling purposes and
         * lies dormant until one of three things happens:
         *
         * <ul>
         *
         * <li>The write lock is acquired by the current thread; or
         *
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread; or
         *
         * <li>The specified waiting time elapses
         *
         * </ul>
         *
         * <p>If the write lock is acquired then the value {@code true} is
         * returned and the write lock hold count is set to one.
         *
         * <p>If the current thread:
         *
         * <ul>
         *
         * <li>has its interrupted status set on entry to this method;
         * or
         *
         * <li>is {@linkplain Thread#interrupt interrupted} while
         * acquiring the write lock,
         *
         * </ul>
         *
         * then {@link InterruptedException} is thrown and the current
         * thread's interrupted status is cleared.
         *
         * <p>If the specified waiting time elapses then the value
         * {@code false} is returned.  If the time is less than or
         * equal to zero, the method will not wait at all.
         *
         * <p>In this implementation, as this method is an explicit
         * interruption point, preference is given to responding to
         * the interrupt over normal or reentrant acquisition of the
         * lock, and over reporting the elapse of the waiting time.
         *
         * @param timeout the time to wait for the write lock
         * @param unit the time unit of the timeout argument
         *
         * @return {@code true} if the lock was free and was acquired
         * by the current thread, or the write lock was already held by the
         * current thread; and {@code false} if the waiting time
         * elapsed before the lock could be acquired.
         *
         * @throws InterruptedException if the current thread is interrupted
         * @throws NullPointerException if the time unit is null
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.972 -0500", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "92FB83CD2DA5E6669041C98D4CCA1701")
        
public boolean tryLock(long timeout, TimeUnit unit)
                throws InterruptedException {
            return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        /**
         * Attempts to release this lock.
         *
         * <p>If the current thread is the holder of this lock then
         * the hold count is decremented. If the hold count is now
         * zero then the lock is released.  If the current thread is
         * not the holder of this lock then {@link
         * IllegalMonitorStateException} is thrown.
         *
         * @throws IllegalMonitorStateException if the current thread does not
         * hold this lock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.975 -0500", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "B39A8E8B3E8EC93EC8CE2E174E9F2264")
        
public void unlock() {
            sync.release(1);
        }

        /**
         * Returns a {@link Condition} instance for use with this
         * {@link Lock} instance.
         * <p>The returned {@link Condition} instance supports the same
         * usages as do the {@link Object} monitor methods ({@link
         * Object#wait() wait}, {@link Object#notify notify}, and {@link
         * Object#notifyAll notifyAll}) when used with the built-in
         * monitor lock.
         *
         * <ul>
         *
         * <li>If this write lock is not held when any {@link
         * Condition} method is called then an {@link
         * IllegalMonitorStateException} is thrown.  (Read locks are
         * held independently of write locks, so are not checked or
         * affected. However it is essentially always an error to
         * invoke a condition waiting method when the current thread
         * has also acquired read locks, since other threads that
         * could unblock it will not be able to acquire the write
         * lock.)
         *
         * <li>When the condition {@linkplain Condition#await() waiting}
         * methods are called the write lock is released and, before
         * they return, the write lock is reacquired and the lock hold
         * count restored to what it was when the method was called.
         *
         * <li>If a thread is {@linkplain Thread#interrupt interrupted} while
         * waiting then the wait will terminate, an {@link
         * InterruptedException} will be thrown, and the thread's
         * interrupted status will be cleared.
         *
         * <li> Waiting threads are signalled in FIFO order.
         *
         * <li>The ordering of lock reacquisition for threads returning
         * from waiting methods is the same as for threads initially
         * acquiring the lock, which is in the default case not specified,
         * but for <em>fair</em> locks favors those threads that have been
         * waiting the longest.
         *
         * </ul>
         *
         * @return the Condition object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.977 -0500", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "9A27C3A2232E4D573B7235B3026E7892")
        
public Condition newCondition() {
            return sync.newCondition();
        }

        /**
         * Returns a string identifying this lock, as well as its lock
         * state.  The state, in brackets includes either the String
         * {@code "Unlocked"} or the String {@code "Locked by"}
         * followed by the {@linkplain Thread#getName name} of the owning thread.
         *
         * @return a string identifying this lock, as well as its lock state
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.980 -0500", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "548B061ACBA6E1F017C0D4DB8D3F0A12")
        
public String toString() {
            Thread o = sync.getOwner();
            return super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]");
        }

        /**
         * Queries if this write lock is held by the current thread.
         * Identical in effect to {@link
         * ReentrantReadWriteLock#isWriteLockedByCurrentThread}.
         *
         * @return {@code true} if the current thread holds this lock and
         *         {@code false} otherwise
         * @since 1.6
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.983 -0500", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "93633AA15B4127B7EA873FEBBE9E9F86")
        
public boolean isHeldByCurrentThread() {
            return sync.isHeldExclusively();
        }

        /**
         * Queries the number of holds on this write lock by the current
         * thread.  A thread has a hold on a lock for each lock action
         * that is not matched by an unlock action.  Identical in effect
         * to {@link ReentrantReadWriteLock#getWriteHoldCount}.
         *
         * @return the number of holds on this lock by the current thread,
         *         or zero if this lock is not held by the current thread
         * @since 1.6
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.985 -0500", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "749BB503111FF2DBBF8177D617605606")
        
public int getHoldCount() {
            return sync.getWriteHoldCount();
        }
    }

    /**
     * Returns a string identifying this lock, as well as its lock state.
     * The state, in brackets, includes the String {@code "Write locks ="}
     * followed by the number of reentrantly held write locks, and the
     * String {@code "Read locks ="} followed by the number of held
     * read locks.
     *
     * @return a string identifying this lock, as well as its lock state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:20.030 -0500", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "FFF2268DE8C84CD4B5498E6820607DC1")
    
public String toString() {
        int c = sync.getCount();
        int w = Sync.exclusiveCount(c);
        int r = Sync.sharedCount(c);

        return super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]";
    }
}

