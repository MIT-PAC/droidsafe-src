package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Semaphore implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.433 -0500", hash_original_field = "166E94449C29806B2B13C7F250519C8B", hash_generated_field = "B51BFB8167C0871125DF74AE3E8AFF72")

    private static final long serialVersionUID = -3222578661600680210L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.435 -0500", hash_original_field = "791C2888A6F5CDC158445182FD1E3538", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private  Sync sync;

    /**
     * Creates a {@code Semaphore} with the given number of
     * permits and nonfair fairness setting.
     *
     * @param permits the initial number of permits available.
     *        This value may be negative, in which case releases
     *        must occur before any acquires will be granted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.482 -0500", hash_original_method = "1D09FBBC41D290488B50FAB01D9EE120", hash_generated_method = "C04686D0D19E5E671D3B80A0912BCDBD")
    
public Semaphore(int permits) {
        sync = new NonfairSync(permits);
    }

    /**
     * Creates a {@code Semaphore} with the given number of
     * permits and the given fairness setting.
     *
     * @param permits the initial number of permits available.
     *        This value may be negative, in which case releases
     *        must occur before any acquires will be granted.
     * @param fair {@code true} if this semaphore will guarantee
     *        first-in first-out granting of permits under contention,
     *        else {@code false}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.485 -0500", hash_original_method = "EDA1419EB058A316E989F6F201EF4313", hash_generated_method = "A1A0BA6EC5BC5C6538BBAE2E2744E06F")
    
public Semaphore(int permits, boolean fair) {
        sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    /**
     * Acquires a permit from this semaphore, blocking until one is
     * available, or the thread is {@linkplain Thread#interrupt interrupted}.
     *
     * <p>Acquires a permit, if one is available and returns immediately,
     * reducing the number of available permits by one.
     *
     * <p>If no permit is available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until
     * one of two things happens:
     * <ul>
     * <li>Some other thread invokes the {@link #release} method for this
     * semaphore and the current thread is next to be assigned a permit; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts}
     * the current thread.
     * </ul>
     *
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while waiting
     * for a permit,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     *
     * @throws InterruptedException if the current thread is interrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.487 -0500", hash_original_method = "36195816327B5FFC3BDF4AB88B23D805", hash_generated_method = "0879DE2D2AB95600C627F707F4C94E6D")
    
public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    /**
     * Acquires a permit from this semaphore, blocking until one is
     * available.
     *
     * <p>Acquires a permit, if one is available and returns immediately,
     * reducing the number of available permits by one.
     *
     * <p>If no permit is available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until
     * some other thread invokes the {@link #release} method for this
     * semaphore and the current thread is next to be assigned a permit.
     *
     * <p>If the current thread is {@linkplain Thread#interrupt interrupted}
     * while waiting for a permit then it will continue to wait, but the
     * time at which the thread is assigned a permit may change compared to
     * the time it would have received the permit had no interruption
     * occurred.  When the thread does return from this method its interrupt
     * status will be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.490 -0500", hash_original_method = "EECA708F1A8CDD46B9FED024EA3B107E", hash_generated_method = "D880AB5846066F63338B8758634177AD")
    
public void acquireUninterruptibly() {
        sync.acquireShared(1);
    }

    /**
     * Acquires a permit from this semaphore, only if one is available at the
     * time of invocation.
     *
     * <p>Acquires a permit, if one is available and returns immediately,
     * with the value {@code true},
     * reducing the number of available permits by one.
     *
     * <p>If no permit is available then this method will return
     * immediately with the value {@code false}.
     *
     * <p>Even when this semaphore has been set to use a
     * fair ordering policy, a call to {@code tryAcquire()} <em>will</em>
     * immediately acquire a permit if one is available, whether or not
     * other threads are currently waiting.
     * This &quot;barging&quot; behavior can be useful in certain
     * circumstances, even though it breaks fairness. If you want to honor
     * the fairness setting, then use
     * {@link #tryAcquire(long, TimeUnit) tryAcquire(0, TimeUnit.SECONDS) }
     * which is almost equivalent (it also detects interruption).
     *
     * @return {@code true} if a permit was acquired and {@code false}
     *         otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.492 -0500", hash_original_method = "81DB55A43E3FEF36A7D7A44C596F2527", hash_generated_method = "1644C4714DD0E21602763EB12FAA9231")
    
public boolean tryAcquire() {
        return sync.nonfairTryAcquireShared(1) >= 0;
    }

    /**
     * Acquires a permit from this semaphore, if one becomes available
     * within the given waiting time and the current thread has not
     * been {@linkplain Thread#interrupt interrupted}.
     *
     * <p>Acquires a permit, if one is available and returns immediately,
     * with the value {@code true},
     * reducing the number of available permits by one.
     *
     * <p>If no permit is available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until
     * one of three things happens:
     * <ul>
     * <li>Some other thread invokes the {@link #release} method for this
     * semaphore and the current thread is next to be assigned a permit; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts}
     * the current thread; or
     * <li>The specified waiting time elapses.
     * </ul>
     *
     * <p>If a permit is acquired then the value {@code true} is returned.
     *
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while waiting
     * to acquire a permit,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     *
     * <p>If the specified waiting time elapses then the value {@code false}
     * is returned.  If the time is less than or equal to zero, the method
     * will not wait at all.
     *
     * @param timeout the maximum time to wait for a permit
     * @param unit the time unit of the {@code timeout} argument
     * @return {@code true} if a permit was acquired and {@code false}
     *         if the waiting time elapsed before a permit was acquired
     * @throws InterruptedException if the current thread is interrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.495 -0500", hash_original_method = "ABEC3704F68F4BA58C5E653A10F8C77A", hash_generated_method = "CEE445590380B39A08035C1580EAEDED")
    
public boolean tryAcquire(long timeout, TimeUnit unit)
        throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    /**
     * Releases a permit, returning it to the semaphore.
     *
     * <p>Releases a permit, increasing the number of available permits by
     * one.  If any threads are trying to acquire a permit, then one is
     * selected and given the permit that was just released.  That thread
     * is (re)enabled for thread scheduling purposes.
     *
     * <p>There is no requirement that a thread that releases a permit must
     * have acquired that permit by calling {@link #acquire}.
     * Correct usage of a semaphore is established by programming convention
     * in the application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.497 -0500", hash_original_method = "A31CF20052BB7332FF63483E272EE6FB", hash_generated_method = "016B3CE7EBD7F76ED8157DCE4AF6A4C2")
    
public void release() {
        sync.releaseShared(1);
    }

    /**
     * Acquires the given number of permits from this semaphore,
     * blocking until all are available,
     * or the thread is {@linkplain Thread#interrupt interrupted}.
     *
     * <p>Acquires the given number of permits, if they are available,
     * and returns immediately, reducing the number of available permits
     * by the given amount.
     *
     * <p>If insufficient permits are available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until
     * one of two things happens:
     * <ul>
     * <li>Some other thread invokes one of the {@link #release() release}
     * methods for this semaphore, the current thread is next to be assigned
     * permits and the number of available permits satisfies this request; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts}
     * the current thread.
     * </ul>
     *
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while waiting
     * for a permit,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     * Any permits that were to be assigned to this thread are instead
     * assigned to other threads trying to acquire permits, as if
     * permits had been made available by a call to {@link #release()}.
     *
     * @param permits the number of permits to acquire
     * @throws InterruptedException if the current thread is interrupted
     * @throws IllegalArgumentException if {@code permits} is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.500 -0500", hash_original_method = "7B985EDB9B3C3368A9FFE0EA00FDC854", hash_generated_method = "7575346F096F2E84F6B8BF1FB0976378")
    
public void acquire(int permits) throws InterruptedException {
        if (permits < 0) throw new IllegalArgumentException();
        sync.acquireSharedInterruptibly(permits);
    }

    /**
     * Acquires the given number of permits from this semaphore,
     * blocking until all are available.
     *
     * <p>Acquires the given number of permits, if they are available,
     * and returns immediately, reducing the number of available permits
     * by the given amount.
     *
     * <p>If insufficient permits are available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until
     * some other thread invokes one of the {@link #release() release}
     * methods for this semaphore, the current thread is next to be assigned
     * permits and the number of available permits satisfies this request.
     *
     * <p>If the current thread is {@linkplain Thread#interrupt interrupted}
     * while waiting for permits then it will continue to wait and its
     * position in the queue is not affected.  When the thread does return
     * from this method its interrupt status will be set.
     *
     * @param permits the number of permits to acquire
     * @throws IllegalArgumentException if {@code permits} is negative
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.502 -0500", hash_original_method = "AED087DD2B1BE9707E61AD056A232C9F", hash_generated_method = "D91903C7A4A95CF1021F1C95A87EE0A4")
    
public void acquireUninterruptibly(int permits) {
        if (permits < 0) throw new IllegalArgumentException();
        sync.acquireShared(permits);
    }

    /**
     * Acquires the given number of permits from this semaphore, only
     * if all are available at the time of invocation.
     *
     * <p>Acquires the given number of permits, if they are available, and
     * returns immediately, with the value {@code true},
     * reducing the number of available permits by the given amount.
     *
     * <p>If insufficient permits are available then this method will return
     * immediately with the value {@code false} and the number of available
     * permits is unchanged.
     *
     * <p>Even when this semaphore has been set to use a fair ordering
     * policy, a call to {@code tryAcquire} <em>will</em>
     * immediately acquire a permit if one is available, whether or
     * not other threads are currently waiting.  This
     * &quot;barging&quot; behavior can be useful in certain
     * circumstances, even though it breaks fairness. If you want to
     * honor the fairness setting, then use {@link #tryAcquire(int,
     * long, TimeUnit) tryAcquire(permits, 0, TimeUnit.SECONDS) }
     * which is almost equivalent (it also detects interruption).
     *
     * @param permits the number of permits to acquire
     * @return {@code true} if the permits were acquired and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code permits} is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.511 -0500", hash_original_method = "9FDABFB6FA908071648B312E27A5D44A", hash_generated_method = "06B463C02D0194BFB90BDEBE13213D47")
    
public boolean tryAcquire(int permits) {
        if (permits < 0) throw new IllegalArgumentException();
        return sync.nonfairTryAcquireShared(permits) >= 0;
    }

    /**
     * Acquires the given number of permits from this semaphore, if all
     * become available within the given waiting time and the current
     * thread has not been {@linkplain Thread#interrupt interrupted}.
     *
     * <p>Acquires the given number of permits, if they are available and
     * returns immediately, with the value {@code true},
     * reducing the number of available permits by the given amount.
     *
     * <p>If insufficient permits are available then
     * the current thread becomes disabled for thread scheduling
     * purposes and lies dormant until one of three things happens:
     * <ul>
     * <li>Some other thread invokes one of the {@link #release() release}
     * methods for this semaphore, the current thread is next to be assigned
     * permits and the number of available permits satisfies this request; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts}
     * the current thread; or
     * <li>The specified waiting time elapses.
     * </ul>
     *
     * <p>If the permits are acquired then the value {@code true} is returned.
     *
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while waiting
     * to acquire the permits,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     * Any permits that were to be assigned to this thread, are instead
     * assigned to other threads trying to acquire permits, as if
     * the permits had been made available by a call to {@link #release()}.
     *
     * <p>If the specified waiting time elapses then the value {@code false}
     * is returned.  If the time is less than or equal to zero, the method
     * will not wait at all.  Any permits that were to be assigned to this
     * thread, are instead assigned to other threads trying to acquire
     * permits, as if the permits had been made available by a call to
     * {@link #release()}.
     *
     * @param permits the number of permits to acquire
     * @param timeout the maximum time to wait for the permits
     * @param unit the time unit of the {@code timeout} argument
     * @return {@code true} if all permits were acquired and {@code false}
     *         if the waiting time elapsed before all permits were acquired
     * @throws InterruptedException if the current thread is interrupted
     * @throws IllegalArgumentException if {@code permits} is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.513 -0500", hash_original_method = "80ECB8EBF7BA66409D7CA6C7FAEA0198", hash_generated_method = "50E27474D5744915A462D80E19D27975")
    
public boolean tryAcquire(int permits, long timeout, TimeUnit unit)
        throws InterruptedException {
        if (permits < 0) throw new IllegalArgumentException();
        return sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout));
    }

    /**
     * Releases the given number of permits, returning them to the semaphore.
     *
     * <p>Releases the given number of permits, increasing the number of
     * available permits by that amount.
     * If any threads are trying to acquire permits, then one
     * is selected and given the permits that were just released.
     * If the number of available permits satisfies that thread's request
     * then that thread is (re)enabled for thread scheduling purposes;
     * otherwise the thread will wait until sufficient permits are available.
     * If there are still permits available
     * after this thread's request has been satisfied, then those permits
     * are assigned in turn to other threads trying to acquire permits.
     *
     * <p>There is no requirement that a thread that releases a permit must
     * have acquired that permit by calling {@link Semaphore#acquire acquire}.
     * Correct usage of a semaphore is established by programming convention
     * in the application.
     *
     * @param permits the number of permits to release
     * @throws IllegalArgumentException if {@code permits} is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.516 -0500", hash_original_method = "86FDC777B5FFBB0166AB6B40E9CBCA0F", hash_generated_method = "FFC414346719443481D4593FE03A94F1")
    
public void release(int permits) {
        if (permits < 0) throw new IllegalArgumentException();
        sync.releaseShared(permits);
    }

    /**
     * Returns the current number of permits available in this semaphore.
     *
     * <p>This method is typically used for debugging and testing purposes.
     *
     * @return the number of permits available in this semaphore
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.518 -0500", hash_original_method = "A0D0E9E456108DB04A370C1A3BAF302D", hash_generated_method = "39458AA765F91D22BA56260E20A8A0E7")
    
public int availablePermits() {
        return sync.getPermits();
    }

    /**
     * Acquires and returns all permits that are immediately available.
     *
     * @return the number of permits acquired
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.520 -0500", hash_original_method = "262F2C65B1D17DEC110169282F777115", hash_generated_method = "E0D410D96FAD25CF1F031A6FCA6B9863")
    
public int drainPermits() {
        return sync.drainPermits();
    }

    /**
     * Shrinks the number of available permits by the indicated
     * reduction. This method can be useful in subclasses that use
     * semaphores to track resources that become unavailable. This
     * method differs from {@code acquire} in that it does not block
     * waiting for permits to become available.
     *
     * @param reduction the number of permits to remove
     * @throws IllegalArgumentException if {@code reduction} is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.523 -0500", hash_original_method = "98D8F44FFB6E2B81C61D6FB2F4F416AF", hash_generated_method = "14350D53AA2ADF2CC7F748BE36EED6D5")
    
protected void reducePermits(int reduction) {
        if (reduction < 0) throw new IllegalArgumentException();
        sync.reducePermits(reduction);
    }

    /**
     * Returns {@code true} if this semaphore has fairness set true.
     *
     * @return {@code true} if this semaphore has fairness set true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.526 -0500", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "A7E9C12C51C218820226EA09837CCA9F")
    
public boolean isFair() {
        return sync instanceof FairSync;
    }

    /**
     * Queries whether any threads are waiting to acquire. Note that
     * because cancellations may occur at any time, a {@code true}
     * return does not guarantee that any other thread will ever
     * acquire.  This method is designed primarily for use in
     * monitoring of the system state.
     *
     * @return {@code true} if there may be other threads waiting to
     *         acquire the lock
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.529 -0500", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "C7584A6E76176296EE4C3AD9AFE15C2D")
    
public final boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    /**
     * Returns an estimate of the number of threads waiting to acquire.
     * The value is only an estimate because the number of threads may
     * change dynamically while this method traverses internal data
     * structures.  This method is designed for use in monitoring of the
     * system state, not for synchronization control.
     *
     * @return the estimated number of threads waiting for this lock
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.531 -0500", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "EA91B63888B7C015D6A36669988D4E4A")
    
public final int getQueueLength() {
        return sync.getQueueLength();
    }

    /**
     * Returns a collection containing threads that may be waiting to acquire.
     * Because the actual set of threads may change dynamically while
     * constructing this result, the returned collection is only a best-effort
     * estimate.  The elements of the returned collection are in no particular
     * order.  This method is designed to facilitate construction of
     * subclasses that provide more extensive monitoring facilities.
     *
     * @return the collection of threads
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.533 -0500", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "D67E7603910B1CF790C49F196A7D918E")
    
protected Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }
    
    abstract static class Sync extends AbstractQueuedSynchronizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.438 -0500", hash_original_field = "09459329E159C1C425A38C58E358F421", hash_generated_field = "A656A5C20233C00BCDB91774C38EC514")

        private static final long serialVersionUID = 1192457210091910933L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.441 -0500", hash_original_method = "40565DEBA5724270F81AA15CDC452278", hash_generated_method = "40565DEBA5724270F81AA15CDC452278")
        
Sync(int permits) {
            setState(permits);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.444 -0500", hash_original_method = "932F869D56214E546755CFC45FDC49E6", hash_generated_method = "D0FD346268DF6B23252F8754EA5A64ED")
        
final int getPermits() {
            return getState();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.446 -0500", hash_original_method = "38128BDDEF18CD48BAE30B545E1D6E2D", hash_generated_method = "924C255F7648DC137D2A5BB2CF93C45F")
        
final int nonfairTryAcquireShared(int acquires) {
            for (;;) {
                int available = getState();
                int remaining = available - acquires;
                if (remaining < 0 ||
                    compareAndSetState(available, remaining))
                    return remaining;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.449 -0500", hash_original_method = "E4485505685AAE5BA8902CEC7119047D", hash_generated_method = "4188F2F9B490875B1CD93410C2BFB54D")
        
protected final boolean tryReleaseShared(int releases) {
            for (;;) {
                int current = getState();
                int next = current + releases;
                if (next < current) // overflow
                    throw new Error("Maximum permit count exceeded");
                if (compareAndSetState(current, next))
                    return true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.452 -0500", hash_original_method = "EF09815047CF337EE6F8F6B76E860F15", hash_generated_method = "7CED8334D0D3544240714C09A5FD25C0")
        
final void reducePermits(int reductions) {
            for (;;) {
                int current = getState();
                int next = current - reductions;
                if (next > current) // underflow
                    throw new Error("Permit count underflow");
                if (compareAndSetState(current, next))
                    return;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.455 -0500", hash_original_method = "B47D637533AD6479C19BA02673B291F3", hash_generated_method = "EC3002043DB7DCAC0929D71BE129EB38")
        
final int drainPermits() {
            for (;;) {
                int current = getState();
                if (current == 0 || compareAndSetState(current, 0))
                    return current;
            }
        }
    }
    
    static final class NonfairSync extends Sync {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.460 -0500", hash_original_field = "049C97470894859EC090BCA877D76DE9", hash_generated_field = "AF8D9D2DFF309778F150C3E144D5488E")

        private static final long serialVersionUID = -2694183684443567898L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.463 -0500", hash_original_method = "AB02276AF05DB48D17C9E59129A0533C", hash_generated_method = "AB02276AF05DB48D17C9E59129A0533C")
        
NonfairSync(int permits) {
            super(permits);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.466 -0500", hash_original_method = "2824818F1E688287ED8D5382B9F9370B", hash_generated_method = "23F4A61D514FCF5E981CC4B1106BA11B")
        
protected int tryAcquireShared(int acquires) {
            return nonfairTryAcquireShared(acquires);
        }
    }
    
    static final class FairSync extends Sync {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.471 -0500", hash_original_field = "1DD078BB5E5059FF630B3049C620347E", hash_generated_field = "7955A4226A8EE675254DC7AB4392270B")

        private static final long serialVersionUID = 2014338818796000944L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.473 -0500", hash_original_method = "1546A983167A4F32841E77BDDAC1FABE", hash_generated_method = "1546A983167A4F32841E77BDDAC1FABE")
        
FairSync(int permits) {
            super(permits);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.477 -0500", hash_original_method = "33A8BA33CEB07226CB7C962FD4989C27", hash_generated_method = "8DE826122782442887D21F26BF8150E6")
        
protected int tryAcquireShared(int acquires) {
            for (;;) {
                if (hasQueuedPredecessors())
                    return -1;
                int available = getState();
                int remaining = available - acquires;
                if (remaining < 0 ||
                    compareAndSetState(available, remaining))
                    return remaining;
            }
        }
    }

    /**
     * Returns a string identifying this semaphore, as well as its state.
     * The state, in brackets, includes the String {@code "Permits ="}
     * followed by the number of permits.
     *
     * @return a string identifying this semaphore, as well as its state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.536 -0500", hash_original_method = "28E11779691509B84604A2532741810B", hash_generated_method = "C4AD3FA919494B334FA1A01AC988E92C")
    
public String toString() {
        return super.toString() + "[Permits = " + sync.getPermits() + "]";
    }
}

