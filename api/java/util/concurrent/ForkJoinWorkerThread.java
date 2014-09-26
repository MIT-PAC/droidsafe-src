/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

/**
 * A thread managed by a {@link ForkJoinPool}, which executes
 * {@link ForkJoinTask}s.
 * This class is subclassable solely for the sake of adding
 * functionality -- there are no overridable methods dealing with
 * scheduling or execution.  However, you can override initialization
 * and termination methods surrounding the main task processing loop.
 * If you do create such a subclass, you will also need to supply a
 * custom {@link ForkJoinPool.ForkJoinWorkerThreadFactory} to use it
 * in a {@code ForkJoinPool}.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ForkJoinWorkerThread extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.677 -0400", hash_original_field = "6D1EBEC5292A0D06AAA30D30D556DA9B", hash_generated_field = "6D1EBEC5292A0D06AAA30D30D556DA9B")

     ForkJoinPool pool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.677 -0400", hash_original_field = "5D3FD1F23DF2E53E5A79A179DA3209AD", hash_generated_field = "5D3FD1F23DF2E53E5A79A179DA3209AD")

     ForkJoinPool.WorkQueue workQueue; // work-stealing mechanics

    /**
     * Creates a ForkJoinWorkerThread operating in the given pool.
     *
     * @param pool the pool this thread works in
     * @throws NullPointerException if pool is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.678 -0400", hash_original_method = "BC19E5D6974D4B9B20F25E42BD4200C9", hash_generated_method = "862EAF4E6CE0FFE06A4D15D2B126DC2E")
    
protected ForkJoinWorkerThread(ForkJoinPool pool) {
        // Use a placeholder until a useful name can be set in registerWorker
        super("aForkJoinWorkerThread");
        this.pool = pool;
        this.workQueue = pool.registerWorker(this);
    }

    /**
     * Returns the pool hosting this thread.
     *
     * @return the pool
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.678 -0400", hash_original_method = "FC74F66C88ECAB482F61FD17FFF07B47", hash_generated_method = "2A80280C91D23BD60598F5AC324838DE")
    
public ForkJoinPool getPool() {
        return pool;
    }

    /**
     * Returns the index number of this thread in its pool.  The
     * returned value ranges from zero to the maximum number of
     * threads (minus one) that have ever been created in the pool.
     * This method may be useful for applications that track status or
     * collect results per-worker rather than per-task.
     *
     * @return the index number
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.678 -0400", hash_original_method = "BBB82A2E84DEEE12FB2C05A7141251FD", hash_generated_method = "48244BEF11DEA85C520D425F44888710")
    
public int getPoolIndex() {
        return workQueue.poolIndex;
    }

    /**
     * Initializes internal state after construction but before
     * processing any tasks. If you override this method, you must
     * invoke {@code super.onStart()} at the beginning of the method.
     * Initialization requires care: Most fields must have legal
     * default values, to ensure that attempted accesses from other
     * threads work correctly even before this thread starts
     * processing tasks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.679 -0400", hash_original_method = "0451E38101EC2D69951E664FB36904F0", hash_generated_method = "9D33ADBA1B132E13D4E0F291B042A6F3")
    
protected void onStart() {
    }

    /**
     * Performs cleanup associated with termination of this worker
     * thread.  If you override this method, you must invoke
     * {@code super.onTermination} at the end of the overridden method.
     *
     * @param exception the exception causing this thread to abort due
     * to an unrecoverable error, or {@code null} if completed normally
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.679 -0400", hash_original_method = "94C69B838EA1FC1C570E3D78145862C8", hash_generated_method = "A223431CD68A3E228114BF1E1D3809C0")
    
protected void onTermination(Throwable exception) {
    }

    /**
     * This method is required to be public, but should never be
     * called explicitly. It performs the main run loop to execute
     * {@link ForkJoinTask}s.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:13.680 -0400", hash_original_method = "9102B033159023A4D18F988913DF1D22", hash_generated_method = "D9090057C8E8F0023EE43FF5B8A69EE3")
    
public void run() {
        Throwable exception = null;
        try {
            onStart();
            pool.runWorker(workQueue);
        } catch (Throwable ex) {
            exception = ex;
        } finally {
            try {
                onTermination(exception);
            } catch (Throwable ex) {
                if (exception == null)
                    exception = ex;
            } finally {
                pool.deregisterWorker(this, exception);
            }
        }
    }
}
