package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;






public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.975 -0500", hash_original_field = "4E0BEBC3D3501BB2B76D034A8EFB299C", hash_generated_field = "09EC8D93792C347004E9D906B28CD479")

    private static final AtomicLong sequencer = new AtomicLong(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.968 -0500", hash_original_field = "AA1A6DFC0A9DF3A217B9D3AC88B61125", hash_generated_field = "B67CDA7A6617E68750D7D9507E18E1D5")


    /**
     * False if should cancel/suppress periodic tasks on shutdown.
     */
    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.970 -0500", hash_original_field = "3B5443B7C004C2B1C06B3F37C2BE3FD6", hash_generated_field = "D4D52A1567899065AB02C507D671256E")

    private volatile boolean executeExistingDelayedTasksAfterShutdown = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.973 -0500", hash_original_field = "3277AE3927ABC3A3E8A8D2199A3CDD29", hash_generated_field = "396CDA7B171456B549FE026890B28734")

    private volatile boolean removeOnCancel = false;

    /**
     * Creates a new {@code ScheduledThreadPoolExecutor} with the
     * given core pool size.
     *
     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.036 -0500", hash_original_method = "D36047D4322FE6F8EBCA30AB15266BC6", hash_generated_method = "C6D051EFB4F60DCEAE37DBBD3B0B07F6")
    
public ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue());
    }

    /**
     * Creates a new {@code ScheduledThreadPoolExecutor} with the
     * given initial parameters.
     *
     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param threadFactory the factory to use when the executor
     *        creates a new thread
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @throws NullPointerException if {@code threadFactory} is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.039 -0500", hash_original_method = "ABDCD4F10C893856EFE26F2C021D677A", hash_generated_method = "892194900DE3EA2EBEB941F9ECC2BB94")
    
public ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory);
    }

    /**
     * Creates a new ScheduledThreadPoolExecutor with the given
     * initial parameters.
     *
     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param handler the handler to use when execution is blocked
     *        because the thread bounds and queue capacities are reached
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @throws NullPointerException if {@code handler} is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.042 -0500", hash_original_method = "15AFC792EAFAB8847ABF7F7AA1CDCAAC", hash_generated_method = "98D5DA14F077B7BB106076B3A41BFB2D")
    
public ScheduledThreadPoolExecutor(int corePoolSize,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), handler);
    }

    /**
     * Creates a new ScheduledThreadPoolExecutor with the given
     * initial parameters.
     *
     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param threadFactory the factory to use when the executor
     *        creates a new thread
     * @param handler the handler to use when execution is blocked
     *        because the thread bounds and queue capacities are reached
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @throws NullPointerException if {@code threadFactory} or
     *         {@code handler} is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.045 -0500", hash_original_method = "FA0219710575675561B4DC7EAFAB1D1D", hash_generated_method = "F65B3DEBD2C9206A45EB1AC4993FE24B")
    
public ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory, handler);
    }

    /**
     * Returns current nanosecond time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.978 -0500", hash_original_method = "5D4518F727B3B1C5CE98EBC039D9AF6B", hash_generated_method = "5086D8F7DF5A22081C0AACC30CB43003")
    
final long now() {
        return System.nanoTime();
    }

    /**
     * Returns true if can run a task given current run state
     * and run-after-shutdown parameters.
     *
     * @param periodic true if this task periodic, false if delayed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.021 -0500", hash_original_method = "43122228A318CAFA2BE5FD8EB8B7119A", hash_generated_method = "43122228A318CAFA2BE5FD8EB8B7119A")
    
boolean canRunInCurrentRunState(boolean periodic) {
        return isRunningOrShutdown(periodic ?
                                   continueExistingPeriodicTasksAfterShutdown :
                                   executeExistingDelayedTasksAfterShutdown);
    }

    /**
     * Main execution method for delayed or periodic tasks.  If pool
     * is shut down, rejects the task. Otherwise adds task to queue
     * and starts a thread, if necessary, to run it.  (We cannot
     * prestart the thread to run the task because the task (probably)
     * shouldn't be run yet,) If the pool is shut down while the task
     * is being added, cancel and remove it if required by state and
     * run-after-shutdown parameters.
     *
     * @param task the task
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.023 -0500", hash_original_method = "74BC2A8347918586B07692C369988E7C", hash_generated_method = "A12A0E4E338A558BFD3C45A30B84EC64")
    
private void delayedExecute(RunnableScheduledFuture<?> task) {
        if (isShutdown())
            reject(task);
        else {
            super.getQueue().add(task);
            if (isShutdown() &&
                !canRunInCurrentRunState(task.isPeriodic()) &&
                remove(task))
                task.cancel(false);
            else
                prestartCoreThread();
        }
    }

    /**
     * Requeues a periodic task unless current run state precludes it.
     * Same idea as delayedExecute except drops task rather than rejecting.
     *
     * @param task the task
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.026 -0500", hash_original_method = "0C685B50A598B045820F5EF901D2AED6", hash_generated_method = "0C685B50A598B045820F5EF901D2AED6")
    
void reExecutePeriodic(RunnableScheduledFuture<?> task) {
        if (canRunInCurrentRunState(true)) {
            super.getQueue().add(task);
            if (!canRunInCurrentRunState(true) && remove(task))
                task.cancel(false);
            else
                prestartCoreThread();
        }
    }

    /**
     * Cancels and clears the queue of all tasks that should not be run
     * due to shutdown policy.  Invoked within super.shutdown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.029 -0500", hash_original_method = "64FA3598D4BDF802451AB41ACA7E6BE8", hash_generated_method = "0EA178E08FD7931EFBC285084C821B60")
    
@Override void onShutdown() {
        BlockingQueue<Runnable> q = super.getQueue();
        boolean keepDelayed =
            getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean keepPeriodic =
            getContinueExistingPeriodicTasksAfterShutdownPolicy();
        if (!keepDelayed && !keepPeriodic) {
            for (Object e : q.toArray())
                if (e instanceof RunnableScheduledFuture<?>)
                    ((RunnableScheduledFuture<?>) e).cancel(false);
            q.clear();
        }
        else {
            // Traverse snapshot to avoid iterator exceptions
            for (Object e : q.toArray()) {
                if (e instanceof RunnableScheduledFuture) {
                    RunnableScheduledFuture<?> t =
                        (RunnableScheduledFuture<?>)e;
                    if ((t.isPeriodic() ? !keepPeriodic : !keepDelayed) ||
                        t.isCancelled()) { // also remove if already cancelled
                        if (q.remove(t))
                            t.cancel(false);
                    }
                }
            }
        }
        tryTerminate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.763 -0400", hash_original_method = "2D7E8C9964120FA3F638C1BFE2958CB1", hash_generated_method = "5F49DDDEC173AD0B54FE56A5933B2845")
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Runnable runnable, RunnableScheduledFuture<V> task) {
        addTaint(task.getTaint());
        addTaint(runnable.getTaint());
RunnableScheduledFuture<V> varE3FBC805688C6CF32CF252D3CB460B3C_1944033159 =         task;
        varE3FBC805688C6CF32CF252D3CB460B3C_1944033159.addTaint(taint);
        return varE3FBC805688C6CF32CF252D3CB460B3C_1944033159;
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.763 -0400", hash_original_method = "5DBE5BBA8D9EF484681F4C8336F1600B", hash_generated_method = "9EC184181CC9726195E7337F6486E70D")
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Callable<V> callable, RunnableScheduledFuture<V> task) {
        addTaint(task.getTaint());
        addTaint(callable.getTaint());
RunnableScheduledFuture<V> varE3FBC805688C6CF32CF252D3CB460B3C_535228177 =         task;
        varE3FBC805688C6CF32CF252D3CB460B3C_535228177.addTaint(taint);
        return varE3FBC805688C6CF32CF252D3CB460B3C_535228177;
        // ---------- Original Method ----------
        //return task;
    }

    /**
     * Returns the trigger time of a delayed action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.047 -0500", hash_original_method = "14F5A42293D1200CF8E952E9DCB67B90", hash_generated_method = "1563039CF8B017832FF7961F544396AE")
    
private long triggerTime(long delay, TimeUnit unit) {
        return triggerTime(unit.toNanos((delay < 0) ? 0 : delay));
    }

    /**
     * Returns the trigger time of a delayed action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.049 -0500", hash_original_method = "43548DFC0EE197F487A673EC89A4A123", hash_generated_method = "43548DFC0EE197F487A673EC89A4A123")
    
long triggerTime(long delay) {
        return now() +
            ((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay));
    }

    /**
     * Constrains the values of all delays in the queue to be within
     * Long.MAX_VALUE of each other, to avoid overflow in compareTo.
     * This may occur if a task is eligible to be dequeued, but has
     * not yet been, while some other task is added with a delay of
     * Long.MAX_VALUE.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.051 -0500", hash_original_method = "7169306CF31D42FCC72896372081E078", hash_generated_method = "F5F77E79FD679044009DB5ACA7481F3F")
    
private long overflowFree(long delay) {
        Delayed head = (Delayed) super.getQueue().peek();
        if (head != null) {
            long headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            if (headDelay < 0 && (delay - headDelay < 0))
                delay = Long.MAX_VALUE + headDelay;
        }
        return delay;
    }

    /**
     * @throws RejectedExecutionException {@inheritDoc}
     * @throws NullPointerException       {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.054 -0500", hash_original_method = "E8C91BC5CFBE81CC8958800A4E70C4DA", hash_generated_method = "70153009D30555822A21DF4C467D0B90")
    
public ScheduledFuture<?> schedule(Runnable command,
                                       long delay,
                                       TimeUnit unit) {
        if (command == null || unit == null)
            throw new NullPointerException();
        RunnableScheduledFuture<?> t = decorateTask(command,
            new ScheduledFutureTask<Void>(command, null,
                                          triggerTime(delay, unit)));
        delayedExecute(t);
        return t;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.765 -0400", hash_original_method = "3CA816B6292CC3DABD4A8E9E190B6332", hash_generated_method = "378062D887D87CBDB8AFDA6DE196F7A4")
    public <V> ScheduledFuture<V> schedule(Callable<V> callable,
                                           long delay,
                                           TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(delay);
        addTaint(callable.getTaint());
        if(callable == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2104150494 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2104150494.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2104150494;
        }
        RunnableScheduledFuture<V> t = decorateTask(callable,
            new ScheduledFutureTask<V>(callable,
                                       triggerTime(delay, unit)));
        delayedExecute(t);
ScheduledFuture<V> varE0D714D758F1540A8DF364A965AF9150_13040699 =         t;
        varE0D714D758F1540A8DF364A965AF9150_13040699.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_13040699;
        // ---------- Original Method ----------
        //if (callable == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<V> t = decorateTask(callable,
            //new ScheduledFutureTask<V>(callable,
                                       //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    /**
     * @throws RejectedExecutionException {@inheritDoc}
     * @throws NullPointerException       {@inheritDoc}
     * @throws IllegalArgumentException   {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.060 -0500", hash_original_method = "8D8E5BFEEBAD4838EB16FA502AD719D4", hash_generated_method = "3EA20E3F4382D0EDE6092893EF206FDF")
    
public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit) {
        if (command == null || unit == null)
            throw new NullPointerException();
        if (period <= 0)
            throw new IllegalArgumentException();
        ScheduledFutureTask<Void> sft =
            new ScheduledFutureTask<Void>(command,
                                          null,
                                          triggerTime(initialDelay, unit),
                                          unit.toNanos(period));
        RunnableScheduledFuture<Void> t = decorateTask(command, sft);
        sft.outerTask = t;
        delayedExecute(t);
        return t;
    }

    /**
     * @throws RejectedExecutionException {@inheritDoc}
     * @throws NullPointerException       {@inheritDoc}
     * @throws IllegalArgumentException   {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.062 -0500", hash_original_method = "F8BFEFA210F26533C5765CF5137E2FD3", hash_generated_method = "80657F904A418F9ACEEDC8127E1116FB")
    
public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                                     long initialDelay,
                                                     long delay,
                                                     TimeUnit unit) {
        if (command == null || unit == null)
            throw new NullPointerException();
        if (delay <= 0)
            throw new IllegalArgumentException();
        ScheduledFutureTask<Void> sft =
            new ScheduledFutureTask<Void>(command,
                                          null,
                                          triggerTime(initialDelay, unit),
                                          unit.toNanos(-delay));
        RunnableScheduledFuture<Void> t = decorateTask(command, sft);
        sft.outerTask = t;
        delayedExecute(t);
        return t;
    }

    /**
     * Executes {@code command} with zero required delay.
     * This has effect equivalent to
     * {@link #schedule(Runnable,long,TimeUnit) schedule(command, 0, anyUnit)}.
     * Note that inspections of the queue and of the list returned by
     * {@code shutdownNow} will access the zero-delayed
     * {@link ScheduledFuture}, not the {@code command} itself.
     *
     * <p>A consequence of the use of {@code ScheduledFuture} objects is
     * that {@link ThreadPoolExecutor#afterExecute afterExecute} is always
     * called with a null second {@code Throwable} argument, even if the
     * {@code command} terminated abruptly.  Instead, the {@code Throwable}
     * thrown by such a task can be obtained via {@link Future#get}.
     *
     * @throws RejectedExecutionException at discretion of
     *         {@code RejectedExecutionHandler}, if the task
     *         cannot be accepted for execution because the
     *         executor has been shut down
     * @throws NullPointerException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.065 -0500", hash_original_method = "106B54169234F208DA4A1738F707D69C", hash_generated_method = "E3A52ADE61F54682CF44ABE8A3326258")
    
public void execute(Runnable command) {
        schedule(command, 0, TimeUnit.NANOSECONDS);
    }

    // Override AbstractExecutorService methods

    /**
     * @throws RejectedExecutionException {@inheritDoc}
     * @throws NullPointerException       {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.067 -0500", hash_original_method = "71AB87E2E6647A80EF75456B59FD870B", hash_generated_method = "3800342DFE8696C11E2AE454E3078C85")
    
public Future<?> submit(Runnable task) {
        return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.767 -0400", hash_original_method = "A2BAF492547813A1B4B6DC556E74F888", hash_generated_method = "CAC525EA0E485EE36D0C77239CB125EE")
    public <T> Future<T> submit(Runnable task, T result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
Future<T> var5F143B3617D15E425694BCB00707B794_1636405938 =         schedule(Executors.callable(task, result),
                        0, TimeUnit.NANOSECONDS);
        var5F143B3617D15E425694BCB00707B794_1636405938.addTaint(taint);
        return var5F143B3617D15E425694BCB00707B794_1636405938;
        // ---------- Original Method ----------
        //return schedule(Executors.callable(task, result),
                        //0, TimeUnit.NANOSECONDS);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.768 -0400", hash_original_method = "7532879CEC1557BEB821686E164CE854", hash_generated_method = "1F446E1DBA15F7EB3F5AB789BFCC5574")
    public <T> Future<T> submit(Callable<T> task) {
        addTaint(task.getTaint());
Future<T> varC033FC2530DBD28BB1831A9C4CE5DB45_4715437 =         schedule(task, 0, TimeUnit.NANOSECONDS);
        varC033FC2530DBD28BB1831A9C4CE5DB45_4715437.addTaint(taint);
        return varC033FC2530DBD28BB1831A9C4CE5DB45_4715437;
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    /**
     * Sets the policy on whether to continue executing existing
     * periodic tasks even when this executor has been {@code shutdown}.
     * In this case, these tasks will only terminate upon
     * {@code shutdownNow} or after setting the policy to
     * {@code false} when already shutdown.
     * This value is by default {@code false}.
     *
     * @param value if {@code true}, continue after shutdown, else don't.
     * @see #getContinueExistingPeriodicTasksAfterShutdownPolicy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.074 -0500", hash_original_method = "4AFC27553B47AB13DBA25E0474D83429", hash_generated_method = "18143D52445CCB29F3A9E20F56652FF9")
    
public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) {
        continueExistingPeriodicTasksAfterShutdown = value;
        if (!value && isShutdown())
            onShutdown();
    }

    /**
     * Gets the policy on whether to continue executing existing
     * periodic tasks even when this executor has been {@code shutdown}.
     * In this case, these tasks will only terminate upon
     * {@code shutdownNow} or after setting the policy to
     * {@code false} when already shutdown.
     * This value is by default {@code false}.
     *
     * @return {@code true} if will continue after shutdown
     * @see #setContinueExistingPeriodicTasksAfterShutdownPolicy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.077 -0500", hash_original_method = "23365684DD383694198E6F21D088C23A", hash_generated_method = "3948A3ACE4F6203C67D666D3E68B424A")
    
public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        return continueExistingPeriodicTasksAfterShutdown;
    }

    /**
     * Sets the policy on whether to execute existing delayed
     * tasks even when this executor has been {@code shutdown}.
     * In this case, these tasks will only terminate upon
     * {@code shutdownNow}, or after setting the policy to
     * {@code false} when already shutdown.
     * This value is by default {@code true}.
     *
     * @param value if {@code true}, execute after shutdown, else don't.
     * @see #getExecuteExistingDelayedTasksAfterShutdownPolicy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.079 -0500", hash_original_method = "DDF8C3EFAF4531B367BDE4CC570E21D4", hash_generated_method = "A2675CE46F6B5D3F768DE6C6745F7621")
    
public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) {
        executeExistingDelayedTasksAfterShutdown = value;
        if (!value && isShutdown())
            onShutdown();
    }

    /**
     * Gets the policy on whether to execute existing delayed
     * tasks even when this executor has been {@code shutdown}.
     * In this case, these tasks will only terminate upon
     * {@code shutdownNow}, or after setting the policy to
     * {@code false} when already shutdown.
     * This value is by default {@code true}.
     *
     * @return {@code true} if will execute after shutdown
     * @see #setExecuteExistingDelayedTasksAfterShutdownPolicy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.081 -0500", hash_original_method = "691F6AED1700735267010AB69287CBB5", hash_generated_method = "D15EDED9EC9A06D04D037B40461AB525")
    
public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        return executeExistingDelayedTasksAfterShutdown;
    }

    /**
     * Sets the policy on whether cancelled tasks should be immediately
     * removed from the work queue at time of cancellation.  This value is
     * by default {@code false}.
     *
     * @param value if {@code true}, remove on cancellation, else don't
     * @see #getRemoveOnCancelPolicy
     * @since 1.7
     */
    /*public*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.084 -0500", hash_original_method = "C989154112CE4F835859D145255931FC", hash_generated_method = "E2D3F1695A01B0F9F9B0921F1BAF9960")
    
void setRemoveOnCancelPolicy(boolean value) { // android-changed
        removeOnCancel = value;
    }

    /**
     * Gets the policy on whether cancelled tasks should be immediately
     * removed from the work queue at time of cancellation.  This value is
     * by default {@code false}.
     *
     * @return {@code true} if cancelled tasks are immediately removed
     *         from the queue
     * @see #setRemoveOnCancelPolicy
     * @since 1.7
     */
    /*public*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.086 -0500", hash_original_method = "3215CF4E7E81ACD4FCE62CEA9B692D35", hash_generated_method = "5620BD1526ADD0251D340D253A9E0017")
    
boolean getRemoveOnCancelPolicy() { // android-changed
        return removeOnCancel;
    }

    /**
     * Initiates an orderly shutdown in which previously submitted
     * tasks are executed, but no new tasks will be accepted.
     * Invocation has no additional effect if already shut down.
     *
     * <p>This method does not wait for previously submitted tasks to
     * complete execution.  Use {@link #awaitTermination awaitTermination}
     * to do that.
     *
     * <p>If the {@code ExecuteExistingDelayedTasksAfterShutdownPolicy}
     * has been set {@code false}, existing delayed tasks whose delays
     * have not yet elapsed are cancelled.  And unless the {@code
     * ContinueExistingPeriodicTasksAfterShutdownPolicy} has been set
     * {@code true}, future executions of existing periodic tasks will
     * be cancelled.
     *
     * @throws SecurityException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.089 -0500", hash_original_method = "06AE3A71ACDF5D94BFF2BA3486ECC61C", hash_generated_method = "EECA67464F24515745E21751DF906EFD")
    
public void shutdown() {
        super.shutdown();
    }

    /**
     * Attempts to stop all actively executing tasks, halts the
     * processing of waiting tasks, and returns a list of the tasks
     * that were awaiting execution.
     *
     * <p>This method does not wait for actively executing tasks to
     * terminate.  Use {@link #awaitTermination awaitTermination} to
     * do that.
     *
     * <p>There are no guarantees beyond best-effort attempts to stop
     * processing actively executing tasks.  This implementation
     * cancels tasks via {@link Thread#interrupt}, so any task that
     * fails to respond to interrupts may never terminate.
     *
     * @return list of tasks that never commenced execution.
     *         Each element of this list is a {@link ScheduledFuture},
     *         including those tasks submitted using {@code execute},
     *         which are for scheduling purposes used as the basis of a
     *         zero-delay {@code ScheduledFuture}.
     * @throws SecurityException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.091 -0500", hash_original_method = "58CAE4CD18062B6710EA14E24E67D3BE", hash_generated_method = "4310F6E0C68CEDEE4A0BB22C75A7B842")
    
public List<Runnable> shutdownNow() {
        return super.shutdownNow();
    }

    
    private class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.981 -0500", hash_original_field = "581F60A6D443ADFC2ED9EAB5D0FA287B", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

        private  long sequenceNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.983 -0500", hash_original_field = "FB68C26D0BB5DD6577F61578B9AE66A8", hash_generated_field = "2D21F2B1A6174F407FDE900F8B752B4F")

        private long time;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.986 -0500", hash_original_field = "21C6B258F031958D40A6DAC5279E0EE8", hash_generated_field = "9B4C1F15D97D513A97EBCE4E8EF81345")

        private  long period;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.988 -0500", hash_original_field = "98CF25F8111133A7EC779F1A91CDBA76", hash_generated_field = "98CF25F8111133A7EC779F1A91CDBA76")

        RunnableScheduledFuture<V> outerTask = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.991 -0500", hash_original_field = "B9E65256978F8C0BE4352922F453397A", hash_generated_field = "B9E65256978F8C0BE4352922F453397A")

        int heapIndex;

        /**
         * Creates a one-shot action with given nanoTime-based trigger time.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.994 -0500", hash_original_method = "6D6FE21BC02E4EEDE50A66A758AADBC3", hash_generated_method = "6D6FE21BC02E4EEDE50A66A758AADBC3")
        
ScheduledFutureTask(Runnable r, V result, long ns) {
            super(r, result);
            this.time = ns;
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        /**
         * Creates a periodic action with given nano time and period.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:15.997 -0500", hash_original_method = "E04B804C1814B5C9E0689952B28AE769", hash_generated_method = "E04B804C1814B5C9E0689952B28AE769")
        
ScheduledFutureTask(Runnable r, V result, long ns, long period) {
            super(r, result);
            this.time = ns;
            this.period = period;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        /**
         * Creates a one-shot action with given nanoTime-based trigger.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.000 -0500", hash_original_method = "E88D028A2F4D25267A398506CBA854E6", hash_generated_method = "E88D028A2F4D25267A398506CBA854E6")
        
ScheduledFutureTask(Callable<V> callable, long ns) {
            super(callable);
            this.time = ns;
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.002 -0500", hash_original_method = "EA844DF3AD76AAE2032057524EEDD497", hash_generated_method = "47A643D671F395286C05C1E1DFD7C686")
        
public long getDelay(TimeUnit unit) {
            return unit.convert(time - now(), TimeUnit.NANOSECONDS);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.005 -0500", hash_original_method = "3DDFB5C452DB9F58801DAD45AC132180", hash_generated_method = "06CD2249C487800DED7B1BE8D3707E6E")
        
public int compareTo(Delayed other) {
            if (other == this) // compare zero ONLY if same object
                return 0;
            if (other instanceof ScheduledFutureTask) {
                ScheduledFutureTask<?> x = (ScheduledFutureTask<?>)other;
                long diff = time - x.time;
                if (diff < 0)
                    return -1;
                else if (diff > 0)
                    return 1;
                else if (sequenceNumber < x.sequenceNumber)
                    return -1;
                else
                    return 1;
            }
            long d = (getDelay(TimeUnit.NANOSECONDS) -
                      other.getDelay(TimeUnit.NANOSECONDS));
            return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
        }

        /**
         * Returns true if this is a periodic (not a one-shot) action.
         *
         * @return true if periodic
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.008 -0500", hash_original_method = "28936E7BC66C2ACF8A84332D0E4F56D6", hash_generated_method = "A43046EEA3EDBAE0E71246E123FF2A01")
        
public boolean isPeriodic() {
            return period != 0;
        }

        /**
         * Sets the next time to run for a periodic task.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.011 -0500", hash_original_method = "AD0F8B1CE8B17F01519D37E93CCE792B", hash_generated_method = "84CD17B038E98EC06CAE4DFAB9D41BCD")
        
private void setNextRunTime() {
            long p = period;
            if (p > 0)
                time += p;
            else
                time = triggerTime(-p);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.013 -0500", hash_original_method = "A46BB14AFBF2EAB15C2BA654B07B241E", hash_generated_method = "C04EF1B521A1B72CD11AF6E937E1C11E")
        
public boolean cancel(boolean mayInterruptIfRunning) {
            boolean cancelled = super.cancel(mayInterruptIfRunning);
            if (cancelled && removeOnCancel && heapIndex >= 0)
                remove(this);
            return cancelled;
        }

        /**
         * Overrides FutureTask version so as to reset/requeue if periodic.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.016 -0500", hash_original_method = "A673F57B6994AD18C8F1F59AB6BC8846", hash_generated_method = "E25D2BC752A0A896AEF831675748C4CA")
        
public void run() {
            boolean periodic = isPeriodic();
            if (!canRunInCurrentRunState(periodic))
                cancel(false);
            else if (!periodic)
                ScheduledFutureTask.super.run();
            else if (ScheduledFutureTask.super.runAndReset()) {
                setNextRunTime();
                reExecutePeriodic(outerTask);
            }
        }

        
    }


    
    static class DelayedWorkQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.096 -0500", hash_original_field = "F46BD29C6E17578C395874054BC81C6E", hash_generated_field = "3F2F6BC48DD22A811C2EB325F2D915D6")


        private static final int INITIAL_CAPACITY = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.099 -0500", hash_original_field = "63B93331B2A7B37C520F2D8D1A4B6AD0", hash_generated_field = "7E3ECE26F4AF2143E2D648A19C272D90")

        private RunnableScheduledFuture[] queue =
            new RunnableScheduledFuture[INITIAL_CAPACITY];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.103 -0500", hash_original_field = "1400DAF04929C6FE417E223B70E97891", hash_generated_field = "8AC82AC4B8DAC99417915B9333B3E7C3")

        private final ReentrantLock lock = new ReentrantLock();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.106 -0500", hash_original_field = "689FC3CB9A887B5817C15E9CFDD066DB", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

        private int size = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.108 -0500", hash_original_field = "32BD64945396C441E3F4E832CE5F820D", hash_generated_field = "F986E3D55ACB2544F93BB697B2C53FDD")

        private Thread leader = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.111 -0500", hash_original_field = "04965D14F491494D58AA489186AE0DED", hash_generated_field = "8F68EB44F62428E1E0B61A4952227D3F")

        private final Condition available = lock.newCondition();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.774 -0400", hash_original_method = "5917AE9375A9F0D7E6AA869E9A88CC5E", hash_generated_method = "5917AE9375A9F0D7E6AA869E9A88CC5E")
        public DelayedWorkQueue ()
        {
            //Synthesized constructor
        }

        /**
         * Set f's heapIndex if it is a ScheduledFutureTask.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.113 -0500", hash_original_method = "871562DD277C0AC8BA441D82903E861A", hash_generated_method = "18070A55AC6452590B1CFCDCCF04E6BB")
        
private void setIndex(RunnableScheduledFuture f, int idx) {
            if (f instanceof ScheduledFutureTask)
                ((ScheduledFutureTask)f).heapIndex = idx;
        }

        /**
         * Sift element added at bottom up to its heap-ordered spot.
         * Call only when holding lock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.116 -0500", hash_original_method = "82039C4DF7CA25BEE85708617CA17C0A", hash_generated_method = "BBE1D43AB052D751607921804C6D353A")
        
private void siftUp(int k, RunnableScheduledFuture key) {
            while (k > 0) {
                int parent = (k - 1) >>> 1;
                RunnableScheduledFuture e = queue[parent];
                if (key.compareTo(e) >= 0)
                    break;
                queue[k] = e;
                setIndex(e, k);
                k = parent;
            }
            queue[k] = key;
            setIndex(key, k);
        }

        /**
         * Sift element added at top down to its heap-ordered spot.
         * Call only when holding lock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.119 -0500", hash_original_method = "2B1F11A0F086CDEBFE52E8E81BF54F43", hash_generated_method = "9B6FC43D5E854AA12235EBDC0D9134EC")
        
private void siftDown(int k, RunnableScheduledFuture key) {
            int half = size >>> 1;
            while (k < half) {
                int child = (k << 1) + 1;
                RunnableScheduledFuture c = queue[child];
                int right = child + 1;
                if (right < size && c.compareTo(queue[right]) > 0)
                    c = queue[child = right];
                if (key.compareTo(c) <= 0)
                    break;
                queue[k] = c;
                setIndex(c, k);
                k = child;
            }
            queue[k] = key;
            setIndex(key, k);
        }

        /**
         * Resize the heap array.  Call only when holding lock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.121 -0500", hash_original_method = "A3FC13DF1E683960EBCF25B1C68B6117", hash_generated_method = "30891C70FD2F977FC1621D90F9DB3D9C")
        
private void grow() {
            int oldCapacity = queue.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1); // grow 50%
            if (newCapacity < 0) // overflow
                newCapacity = Integer.MAX_VALUE;
            queue = Arrays.copyOf(queue, newCapacity);
        }

        /**
         * Find index of given object, or -1 if absent
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.124 -0500", hash_original_method = "C580641A4A2388B58215BACCB42FFCE3", hash_generated_method = "EFFB58FCEBC512A5D266AB90B7608F70")
        
private int indexOf(Object x) {
            if (x != null) {
                if (x instanceof ScheduledFutureTask) {
                    int i = ((ScheduledFutureTask) x).heapIndex;
                    // Sanity check; x could conceivably be a
                    // ScheduledFutureTask from some other pool.
                    if (i >= 0 && i < size && queue[i] == x)
                        return i;
                } else {
                    for (int i = 0; i < size; i++)
                        if (x.equals(queue[i]))
                            return i;
                }
            }
            return -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.127 -0500", hash_original_method = "5E09E7103DB0A49A13B2DDAFBB485D60", hash_generated_method = "216ADB959F030AF53493922AF9B0DA76")
        
public boolean contains(Object x) {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return indexOf(x) != -1;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.129 -0500", hash_original_method = "BE80A65233BEEC20C44EE13577B8F6B3", hash_generated_method = "081C631E4CD8E775DAE7DFF253834F3F")
        
public boolean remove(Object x) {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                int i = indexOf(x);
                if (i < 0)
                    return false;

                setIndex(queue[i], -1);
                int s = --size;
                RunnableScheduledFuture replacement = queue[s];
                queue[s] = null;
                if (s != i) {
                    siftDown(i, replacement);
                    if (queue[i] == replacement)
                        siftUp(i, replacement);
                }
                return true;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.133 -0500", hash_original_method = "FB53A461CD3B1BACC3DB27D415F5CC64", hash_generated_method = "B56E45E790072F25BF00ED5C82A3937D")
        
public int size() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return size;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.135 -0500", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "256A93293017E0D3462837D06A518E42")
        
public boolean isEmpty() {
            return size() == 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.138 -0500", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "33BD29B45C0B302F31D1F275110E0FF5")
        
public int remainingCapacity() {
            return Integer.MAX_VALUE;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.140 -0500", hash_original_method = "71D771244E4BD1C0173C42068DB81D51", hash_generated_method = "4A3670E928D2014D2B82EDD165E0BA3E")
        
public RunnableScheduledFuture peek() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return queue[0];
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.143 -0500", hash_original_method = "A5863DDF2D55F0A792F5570CB9552D10", hash_generated_method = "C57E67538FFFE9DF9BACEF49FAF500DE")
        
public boolean offer(Runnable x) {
            if (x == null)
                throw new NullPointerException();
            RunnableScheduledFuture e = (RunnableScheduledFuture)x;
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                int i = size;
                if (i >= queue.length)
                    grow();
                size = i + 1;
                if (i == 0) {
                    queue[0] = e;
                    setIndex(e, 0);
                } else {
                    siftUp(i, e);
                }
                if (queue[0] == e) {
                    leader = null;
                    available.signal();
                }
            } finally {
                lock.unlock();
            }
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.146 -0500", hash_original_method = "4080BF206CA14D39406126FB9F6C27D2", hash_generated_method = "A69DA435D04D9547DAD0E800C49751A1")
        
public void put(Runnable e) {
            offer(e);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.148 -0500", hash_original_method = "AD0F5DE8A091A43B7107BCF4BE0853B5", hash_generated_method = "3911745853F8759B8217277BA7FB95FB")
        
public boolean add(Runnable e) {
            return offer(e);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.151 -0500", hash_original_method = "C6567B4A0AA1C7B283CF9843CADA74F7", hash_generated_method = "C992739CC8D27680B9B33505533DE685")
        
public boolean offer(Runnable e, long timeout, TimeUnit unit) {
            return offer(e);
        }

        /**
         * Performs common bookkeeping for poll and take: Replaces
         * first element with last and sifts it down.  Call only when
         * holding lock.
         * @param f the task to remove and return
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.153 -0500", hash_original_method = "95AFA75D0998C104C226840186514FC9", hash_generated_method = "A4C2EED943B41B751F9ED084A5D45341")
        
private RunnableScheduledFuture finishPoll(RunnableScheduledFuture f) {
            int s = --size;
            RunnableScheduledFuture x = queue[s];
            queue[s] = null;
            if (s != 0)
                siftDown(0, x);
            setIndex(f, -1);
            return f;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.156 -0500", hash_original_method = "8EBCD245EA652A524E679A63C787A99C", hash_generated_method = "0C6444231D8803864F44A89D449E3521")
        
public RunnableScheduledFuture poll() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                RunnableScheduledFuture first = queue[0];
                if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)
                    return null;
                else
                    return finishPoll(first);
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.160 -0500", hash_original_method = "C35B04B198E2C5886DA81FEFBA3F2D77", hash_generated_method = "EAD227B6DEC0BF18B08A7940F1BAA829")
        
public RunnableScheduledFuture take() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                for (;;) {
                    RunnableScheduledFuture first = queue[0];
                    if (first == null)
                        available.await();
                    else {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
                        if (delay <= 0)
                            return finishPoll(first);
                        else if (leader != null)
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
                if (leader == null && queue[0] != null)
                    available.signal();
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.163 -0500", hash_original_method = "72DE523456D313A78DBDBA042B83CE23", hash_generated_method = "6E04C9D6A79DC43E11C8384AD88A31CF")
        
public RunnableScheduledFuture poll(long timeout, TimeUnit unit)
            throws InterruptedException {
            long nanos = unit.toNanos(timeout);
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                for (;;) {
                    RunnableScheduledFuture first = queue[0];
                    if (first == null) {
                        if (nanos <= 0)
                            return null;
                        else
                            nanos = available.awaitNanos(nanos);
                    } else {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
                        if (delay <= 0)
                            return finishPoll(first);
                        if (nanos <= 0)
                            return null;
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
                if (leader == null && queue[0] != null)
                    available.signal();
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.165 -0500", hash_original_method = "B7A92D7F07FC88CC462E2031E3EC4D97", hash_generated_method = "A5013E936BFCBC1CCBA88FD69D609D33")
        
public void clear() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                for (int i = 0; i < size; i++) {
                    RunnableScheduledFuture t = queue[i];
                    if (t != null) {
                        queue[i] = null;
                        setIndex(t, -1);
                    }
                }
                size = 0;
            } finally {
                lock.unlock();
            }
        }

        /**
         * Return and remove first element only if it is expired.
         * Used only by drainTo.  Call only when holding lock.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.168 -0500", hash_original_method = "2FE630D35A7B40B0A6753A3386B27535", hash_generated_method = "84F92E20F9A31E5E6E1F47A404965C54")
        
private RunnableScheduledFuture pollExpired() {
            RunnableScheduledFuture first = queue[0];
            if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)
                return null;
            return finishPoll(first);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.170 -0500", hash_original_method = "A0CF55F6497A110CDDFF356DE0AE8664", hash_generated_method = "CC1EECF0CA9F5BE88A87C537E0EE218E")
        
public int drainTo(Collection<? super Runnable> c) {
            if (c == null)
                throw new NullPointerException();
            if (c == this)
                throw new IllegalArgumentException();
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                RunnableScheduledFuture first;
                int n = 0;
                while ((first = pollExpired()) != null) {
                    c.add(first);
                    ++n;
                }
                return n;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.173 -0500", hash_original_method = "0279366BCBF84614051CBA5B08204A0A", hash_generated_method = "A1D4E25C904A65FFBC36870A29413B77")
        
public int drainTo(Collection<? super Runnable> c, int maxElements) {
            if (c == null)
                throw new NullPointerException();
            if (c == this)
                throw new IllegalArgumentException();
            if (maxElements <= 0)
                return 0;
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                RunnableScheduledFuture first;
                int n = 0;
                while (n < maxElements && (first = pollExpired()) != null) {
                    c.add(first);
                    ++n;
                }
                return n;
            } finally {
                lock.unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.176 -0500", hash_original_method = "7408B58852530A87736A5AD8CAD9599F", hash_generated_method = "76FFD2DB2227DB664664E22C9C3E0846")
        
public Object[] toArray() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return Arrays.copyOf(queue, size, Object[].class);
            } finally {
                lock.unlock();
            }
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.783 -0400", hash_original_method = "C537847CD06DB8C82AFD734BEA1D62C4", hash_generated_method = "7CB70BD5E875B7DC6412AAF27CBC5613")
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                if(a.length < size)                
                {
T[] varD7F9E2498EEEC82C28C16468811B6DF2_24220868 =                 (T[]) Arrays.copyOf(queue, size, a.getClass());
                varD7F9E2498EEEC82C28C16468811B6DF2_24220868.addTaint(taint);
                return varD7F9E2498EEEC82C28C16468811B6DF2_24220868;
                }
                System.arraycopy(queue, 0, a, 0, size);
                if(a.length > size)                
                a[size] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_99574316 =                 a;
                var3F5343BF1D849954A73F0BB303805FFD_99574316.addTaint(taint);
                return var3F5343BF1D849954A73F0BB303805FFD_99574316;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //if (a.length < size)
                    //return (T[]) Arrays.copyOf(queue, size, a.getClass());
                //System.arraycopy(queue, 0, a, 0, size);
                //if (a.length > size)
                    //a[size] = null;
                //return a;
            //} finally {
                //lock.unlock();
            //}
        }

        
        private class Itr implements Iterator<Runnable> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.184 -0500", hash_original_field = "81254B9FC545B41C37906F59020B61EA", hash_generated_field = "81254B9FC545B41C37906F59020B61EA")

             RunnableScheduledFuture[] array;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.187 -0500", hash_original_field = "EF6EF07B89CC96321B7CFBEF54BCF418", hash_generated_field = "EF6EF07B89CC96321B7CFBEF54BCF418")

            int cursor = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.189 -0500", hash_original_field = "9128B9A3EF0151CBF070702BF3C62C66", hash_generated_field = "9128B9A3EF0151CBF070702BF3C62C66")

            int lastRet = -1;   // index of last element, or -1 if no such

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.193 -0500", hash_original_method = "78BE11BC04A59F667BA3E745B91EA864", hash_generated_method = "78BE11BC04A59F667BA3E745B91EA864")
            
Itr(RunnableScheduledFuture[] array) {
                this.array = array;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.195 -0500", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "CDE3CA7472C460360713EEDFAECC9D23")
            
public boolean hasNext() {
                return cursor < array.length;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.198 -0500", hash_original_method = "3D0866C62F631AE1F3281A9951BE6C06", hash_generated_method = "4B6DACAD5F05336E081AADDDA2E83D77")
            
public Runnable next() {
                if (cursor >= array.length)
                    throw new NoSuchElementException();
                lastRet = cursor;
                return array[cursor++];
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.201 -0500", hash_original_method = "560EEAA350DF5EAA4CBD4C138A91D642", hash_generated_method = "BC30726115F8B70642607811DF4303C7")
            
public void remove() {
                if (lastRet < 0)
                    throw new IllegalStateException();
                DelayedWorkQueue.this.remove(array[lastRet]);
                lastRet = -1;
            }

            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.181 -0500", hash_original_method = "46B1FB64DFD489BA9D84B29257E9B6C6", hash_generated_method = "965D27A073ACACB5FE04A64C9147DBC4")
        
public Iterator<Runnable> iterator() {
            return new Itr(Arrays.copyOf(queue, size));
        }
    }

    /**
     * Returns the task queue used by this executor.  Each element of
     * this queue is a {@link ScheduledFuture}, including those
     * tasks submitted using {@code execute} which are for scheduling
     * purposes used as the basis of a zero-delay
     * {@code ScheduledFuture}.  Iteration over this queue is
     * <em>not</em> guaranteed to traverse tasks in the order in
     * which they will execute.
     *
     * @return the task queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:16.093 -0500", hash_original_method = "161D6A52B7D27778B4A9C4AAA82FE7A8", hash_generated_method = "14F2FC0C0EDEB99502501B879860D8E2")
    
public BlockingQueue<Runnable> getQueue() {
        return super.getQueue();
    }
}

