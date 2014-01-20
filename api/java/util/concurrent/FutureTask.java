package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class FutureTask<V> implements RunnableFuture<V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.307 -0500", hash_original_field = "791C2888A6F5CDC158445182FD1E3538", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private  Sync sync;

    /**
     * Creates a <tt>FutureTask</tt> that will, upon running, execute the
     * given <tt>Callable</tt>.
     *
     * @param  callable the callable task
     * @throws NullPointerException if callable is null
     */
    @DSComment("callback needs to be called")
    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.310 -0500", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "7BD296EDBFF52128CD69A980B4707200")
    
public FutureTask(Callable<V> callable) {
        if (callable == null)
            throw new NullPointerException();
        sync = new Sync(callable);
    }

    /**
     * Creates a <tt>FutureTask</tt> that will, upon running, execute the
     * given <tt>Runnable</tt>, and arrange that <tt>get</tt> will return the
     * given result on successful completion.
     *
     * @param runnable the runnable task
     * @param result the result to return on successful completion. If
     * you don't need a particular result, consider using
     * constructions of the form:
     * {@code Future<?> f = new FutureTask<Void>(runnable, null)}
     * @throws NullPointerException if runnable is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.313 -0500", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "F35D99CC429422B5DF255E078F6CB9B6")
    
public FutureTask(Runnable runnable, V result) {
        sync = new Sync(Executors.callable(runnable, result));
    }

    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.315 -0500", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "4C5742613CCA16D20CDA018ADC844780")
    
public boolean isCancelled() {
        return sync.innerIsCancelled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.317 -0500", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "1F4DEE056801950293E35EAEE5791B9F")
    
public boolean isDone() {
        return sync.innerIsDone();
    }

    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.320 -0500", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "2B9A6D8E962965597198EE7EF5CC30EB")
    
public boolean cancel(boolean mayInterruptIfRunning) {
        return sync.innerCancel(mayInterruptIfRunning);
    }

    /**
     * @throws CancellationException {@inheritDoc}
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.322 -0500", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "4BA8D097AA6015B36B09431BCBD339FE")
    
public V get() throws InterruptedException, ExecutionException {
        return sync.innerGet();
    }

    /**
     * @throws CancellationException {@inheritDoc}
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.324 -0500", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "F2C4282953312CB1FC8BB08A4E7F5CE4")
    
public V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException {
        return sync.innerGet(unit.toNanos(timeout));
    }

    /**
     * Protected method invoked when this task transitions to state
     * <tt>isDone</tt> (whether normally or via cancellation). The
     * default implementation does nothing.  Subclasses may override
     * this method to invoke completion callbacks or perform
     * bookkeeping. Note that you can query status inside the
     * implementation of this method to determine whether this task
     * has been cancelled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.327 -0500", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "60BE5CDE27841B3EA519B90ADA5D01AD")
    
protected void done() { }

    /**
     * Sets the result of this Future to the given value unless
     * this future has already been set or has been cancelled.
     * This method is invoked internally by the <tt>run</tt> method
     * upon successful completion of the computation.
     * @param v the value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.329 -0500", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "515CC38CCFBEC8579D8943A564BF12D3")
    
protected void set(V v) {
        sync.innerSet(v);
    }

    /**
     * Causes this future to report an <tt>ExecutionException</tt>
     * with the given throwable as its cause, unless this Future has
     * already been set or has been cancelled.
     * This method is invoked internally by the <tt>run</tt> method
     * upon failure of the computation.
     * @param t the cause of failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.331 -0500", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "58941F7DC5FC1C049366AC59BFB88535")
    
protected void setException(Throwable t) {
        sync.innerSetException(t);
    }

    // The following (duplicated) doc comment can be removed once
    //
    // 6270645: Javadoc comments should be inherited from most derived
    //          superinterface or superclass
    // is fixed.
    /**
     * Sets this Future to the result of its computation
     * unless it has been cancelled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.334 -0500", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "D3AE039B798452ECC87270B249B0B99C")
    
public void run() {
        sync.innerRun();
    }

    /**
     * Executes the computation without setting its result, and then
     * resets this Future to initial state, failing to do so if the
     * computation encounters an exception or is cancelled.  This is
     * designed for use with tasks that intrinsically execute more
     * than once.
     * @return true if successfully run and reset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.336 -0500", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "3278A0298FB24C6CFC126977D6045B40")
    
protected boolean runAndReset() {
        return sync.innerRunAndReset();
    }
    
    private final class Sync extends AbstractQueuedSynchronizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.340 -0500", hash_original_field = "48283B78DFDDDD24606FBF66FAFFFB12", hash_generated_field = "A00041810A819D5E857048CB950A7783")

        private static final long serialVersionUID = -7828117401763700385L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.343 -0500", hash_original_field = "B76CDD71E689972A5BDDB24204A777AF", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

        private static final int READY     = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.345 -0500", hash_original_field = "B0A82E5010AD92FAB1CEC138864B21D3", hash_generated_field = "051A4B9B2D44F7620AA6A669FD31AABF")

        private static final int RUNNING   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.348 -0500", hash_original_field = "083CAED77EFD25DE427521777A46D6DD", hash_generated_field = "B92FE57A7EFAB742112B6F9BC9D5B492")

        private static final int RAN       = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.351 -0500", hash_original_field = "E9E2BBB19DD52ACDA240B407F459667A", hash_generated_field = "28A434F6555460870A9E786CF0B89DF4")

        private static final int CANCELLED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.353 -0500", hash_original_field = "2F11D0A262F3A7D0B7D20CF5462E5428", hash_generated_field = "B86134CFEB8FBFA3192E582367273039")

        private  Callable<V> callable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.356 -0500", hash_original_field = "D7604DFAA500A27AADFB727128D5C70F", hash_generated_field = "48DD7F9F3DDF2001AA8AEF95D0F84BB9")

        private V result;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.358 -0500", hash_original_field = "ED6B643F1012B300A602DEA8C7E5C621", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

        private Throwable exception;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.361 -0500", hash_original_field = "639B156CB59CD1476FC1A9C00886E477", hash_generated_field = "93A1C41CF6D42E56BD1E63B8EC2F515C")

        private volatile Thread runner;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.363 -0500", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F")
        
Sync(Callable<V> callable) {
            this.callable = callable;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.365 -0500", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "FCBC3293724673E03B89D5B3E326E5BC")
        
private boolean ranOrCancelled(int state) {
            return (state & (RAN | CANCELLED)) != 0;
        }

        /**
         * Implements AQS base acquire to succeed if ran or cancelled
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.368 -0500", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "20E6E3A8ED32C619C18A9D0CB16FE443")
        
protected int tryAcquireShared(int ignore) {
            return innerIsDone() ? 1 : -1;
        }

        /**
         * Implements AQS base release to always signal after setting
         * final done status by nulling runner thread.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.371 -0500", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "8799397ACB923924360E86C38C6E53CC")
        
protected boolean tryReleaseShared(int ignore) {
            runner = null;
            return true;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.373 -0500", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "D8E0DD690F3527605076B5F197BA585A")
        
boolean innerIsCancelled() {
            return getState() == CANCELLED;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.375 -0500", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "3CE62A51F6A5DB16A8E43D03725714DF")
        
boolean innerIsDone() {
            return ranOrCancelled(getState()) && runner == null;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.378 -0500", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "E3CC861BC123329FE0CD5116647662CC")
        
V innerGet() throws InterruptedException, ExecutionException {
            acquireSharedInterruptibly(0);
            if (getState() == CANCELLED)
                throw new CancellationException();
            if (exception != null)
                throw new ExecutionException(exception);
            return result;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.380 -0500", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "C6C2CADBDD008A3436D4C69E1505E94B")
        
V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            if (!tryAcquireSharedNanos(0, nanosTimeout))
                throw new TimeoutException();
            if (getState() == CANCELLED)
                throw new CancellationException();
            if (exception != null)
                throw new ExecutionException(exception);
            return result;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.383 -0500", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "036A999C1B79070240AA9AE9C6B6861F")
        
void innerSet(V v) {
            for (;;) {
                int s = getState();
                if (s == RAN)
                    return;
                if (s == CANCELLED) {
                    // aggressively release to set runner to null,
                    // in case we are racing with a cancel request
                    // that will try to interrupt runner
                    releaseShared(0);
                    return;
                }
                if (compareAndSetState(s, RAN)) {
                    result = v;
                    releaseShared(0);
                    done();
                    return;
                }
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.385 -0500", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "32F7320837548FDF0411DADDCE439C88")
        
void innerSetException(Throwable t) {
            for (;;) {
                int s = getState();
                if (s == RAN)
                    return;
                if (s == CANCELLED) {
                    // aggressively release to set runner to null,
                    // in case we are racing with a cancel request
                    // that will try to interrupt runner
                    releaseShared(0);
                    return;
                }
                if (compareAndSetState(s, RAN)) {
                    exception = t;
                    releaseShared(0);
                    done();
                    return;
                }
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.388 -0500", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "8B39040A94FB4A11910F39A32682A441")
        
boolean innerCancel(boolean mayInterruptIfRunning) {
            for (;;) {
                int s = getState();
                if (ranOrCancelled(s))
                    return false;
                if (compareAndSetState(s, CANCELLED))
                    break;
            }
            if (mayInterruptIfRunning) {
                Thread r = runner;
                if (r != null)
                    r.interrupt();
            }
            releaseShared(0);
            done();
            return true;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.390 -0500", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "CDA9DC46DC81CC76B78BF4811C4AC373")
        
void innerRun() {
            if (!compareAndSetState(READY, RUNNING))
                return;

            runner = Thread.currentThread();
            if (getState() == RUNNING) { // recheck after setting thread
                V result;
                try {
                    result = callable.call();
                } catch (Throwable ex) {
                    setException(ex);
                    return;
                }
                set(result);
            } else {
                releaseShared(0); // cancel
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:19.393 -0500", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "89D379E7603CB7FC6255B77371E79540")
        
boolean innerRunAndReset() {
            if (!compareAndSetState(READY, RUNNING))
                return false;
            try {
                runner = Thread.currentThread();
                if (getState() == RUNNING)
                    callable.call(); // don't set result
                runner = null;
                return compareAndSetState(RUNNING, READY);
            } catch (Throwable ex) {
                setException(ex);
                return false;
            }
        }
    }
    
}

