package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Executors {

    /**
     * Creates a thread pool that reuses a fixed number of threads
     * operating off a shared unbounded queue.  At any point, at most
     * <tt>nThreads</tt> threads will be active processing tasks.
     * If additional tasks are submitted when all threads are active,
     * they will wait in the queue until a thread is available.
     * If any thread terminates due to a failure during execution
     * prior to shutdown, a new one will take its place if needed to
     * execute subsequent tasks.  The threads in the pool will exist
     * until it is explicitly {@link ExecutorService#shutdown shutdown}.
     *
     * @param nThreads the number of threads in the pool
     * @return the newly created thread pool
     * @throws IllegalArgumentException if {@code nThreads <= 0}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.737 -0500", hash_original_method = "4E40ED8EF1E85B572E2151F7FE652635", hash_generated_method = "24FC77A84622C7E6D132714BA0E4E804")
    
public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }

    /**
     * Creates a thread pool that reuses a fixed number of threads
     * operating off a shared unbounded queue, using the provided
     * ThreadFactory to create new threads when needed.  At any point,
     * at most <tt>nThreads</tt> threads will be active processing
     * tasks.  If additional tasks are submitted when all threads are
     * active, they will wait in the queue until a thread is
     * available.  If any thread terminates due to a failure during
     * execution prior to shutdown, a new one will take its place if
     * needed to execute subsequent tasks.  The threads in the pool will
     * exist until it is explicitly {@link ExecutorService#shutdown
     * shutdown}.
     *
     * @param nThreads the number of threads in the pool
     * @param threadFactory the factory to use when creating new threads
     * @return the newly created thread pool
     * @throws NullPointerException if threadFactory is null
     * @throws IllegalArgumentException if {@code nThreads <= 0}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.740 -0500", hash_original_method = "B4B819B5FCF44407B1B16756E048CBA8", hash_generated_method = "E3B00C6A4203188D2006ED62C0A7DE75")
    
public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
    }

    /**
     * Creates an Executor that uses a single worker thread operating
     * off an unbounded queue. (Note however that if this single
     * thread terminates due to a failure during execution prior to
     * shutdown, a new one will take its place if needed to execute
     * subsequent tasks.)  Tasks are guaranteed to execute
     * sequentially, and no more than one task will be active at any
     * given time. Unlike the otherwise equivalent
     * <tt>newFixedThreadPool(1)</tt> the returned executor is
     * guaranteed not to be reconfigurable to use additional threads.
     *
     * @return the newly created single-threaded Executor
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.743 -0500", hash_original_method = "C1C113EB7A09B292CF1C69F4CC48EB73", hash_generated_method = "9221D76F05BD5816E653D4B3D94FCBF6")
    
public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }

    /**
     * Creates an Executor that uses a single worker thread operating
     * off an unbounded queue, and uses the provided ThreadFactory to
     * create a new thread when needed. Unlike the otherwise
     * equivalent <tt>newFixedThreadPool(1, threadFactory)</tt> the
     * returned executor is guaranteed not to be reconfigurable to use
     * additional threads.
     *
     * @param threadFactory the factory to use when creating new
     * threads
     *
     * @return the newly created single-threaded Executor
     * @throws NullPointerException if threadFactory is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.745 -0500", hash_original_method = "B2D89085FD1440204585B1FDE708D472", hash_generated_method = "0DB1D891C4BC734697C61313156F9928")
    
public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
    }

    /**
     * Creates a thread pool that creates new threads as needed, but
     * will reuse previously constructed threads when they are
     * available.  These pools will typically improve the performance
     * of programs that execute many short-lived asynchronous tasks.
     * Calls to <tt>execute</tt> will reuse previously constructed
     * threads if available. If no existing thread is available, a new
     * thread will be created and added to the pool. Threads that have
     * not been used for sixty seconds are terminated and removed from
     * the cache. Thus, a pool that remains idle for long enough will
     * not consume any resources. Note that pools with similar
     * properties but different details (for example, timeout parameters)
     * may be created using {@link ThreadPoolExecutor} constructors.
     *
     * @return the newly created thread pool
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.748 -0500", hash_original_method = "F8AEA60969AF891BED1528CB27A5B3DF", hash_generated_method = "5531971EB656A2DB0F9493BF080E0215")
    
public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }

    /**
     * Creates a thread pool that creates new threads as needed, but
     * will reuse previously constructed threads when they are
     * available, and uses the provided
     * ThreadFactory to create new threads when needed.
     * @param threadFactory the factory to use when creating new threads
     * @return the newly created thread pool
     * @throws NullPointerException if threadFactory is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.751 -0500", hash_original_method = "75C2AC8A8F418D624F70F1077C2FBC95", hash_generated_method = "A546D36DD3CD43F0C743AE5AE607FB0C")
    
public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>(),
                                      threadFactory);
    }

    /**
     * Creates a single-threaded executor that can schedule commands
     * to run after a given delay, or to execute periodically.
     * (Note however that if this single
     * thread terminates due to a failure during execution prior to
     * shutdown, a new one will take its place if needed to execute
     * subsequent tasks.)  Tasks are guaranteed to execute
     * sequentially, and no more than one task will be active at any
     * given time. Unlike the otherwise equivalent
     * <tt>newScheduledThreadPool(1)</tt> the returned executor is
     * guaranteed not to be reconfigurable to use additional threads.
     * @return the newly created scheduled executor
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.754 -0500", hash_original_method = "3B8D30E77CB845E3C376AA2B983070C1", hash_generated_method = "55D57A7E9E195C304A2DD55867C5D9F9")
    
public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1));
    }

    /**
     * Creates a single-threaded executor that can schedule commands
     * to run after a given delay, or to execute periodically.  (Note
     * however that if this single thread terminates due to a failure
     * during execution prior to shutdown, a new one will take its
     * place if needed to execute subsequent tasks.)  Tasks are
     * guaranteed to execute sequentially, and no more than one task
     * will be active at any given time. Unlike the otherwise
     * equivalent <tt>newScheduledThreadPool(1, threadFactory)</tt>
     * the returned executor is guaranteed not to be reconfigurable to
     * use additional threads.
     * @param threadFactory the factory to use when creating new
     * threads
     * @return a newly created scheduled executor
     * @throws NullPointerException if threadFactory is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.756 -0500", hash_original_method = "662E48DC77F0E634963E4AF8B4B2319F", hash_generated_method = "3031A768012849957C19B4921EB5DA3F")
    
public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    /**
     * Creates a thread pool that can schedule commands to run after a
     * given delay, or to execute periodically.
     * @param corePoolSize the number of threads to keep in the pool,
     * even if they are idle.
     * @return a newly created scheduled thread pool
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.759 -0500", hash_original_method = "27FBCCF1D4D5EC0F51777630C21B1B2E", hash_generated_method = "D472E85837C5D4BE96BA90F2DAE0F3A5")
    
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    /**
     * Creates a thread pool that can schedule commands to run after a
     * given delay, or to execute periodically.
     * @param corePoolSize the number of threads to keep in the pool,
     * even if they are idle.
     * @param threadFactory the factory to use when the executor
     * creates a new thread.
     * @return a newly created scheduled thread pool
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @throws NullPointerException if threadFactory is null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.761 -0500", hash_original_method = "D2C28C34E5EB211F6345884E8C056637", hash_generated_method = "5881D63D11562D74770FEB0EA1531801")
    
public static ScheduledExecutorService newScheduledThreadPool(
            int corePoolSize, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    /**
     * Returns an object that delegates all defined {@link
     * ExecutorService} methods to the given executor, but not any
     * other methods that might otherwise be accessible using
     * casts. This provides a way to safely "freeze" configuration and
     * disallow tuning of a given concrete implementation.
     * @param executor the underlying implementation
     * @return an <tt>ExecutorService</tt> instance
     * @throws NullPointerException if executor null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.764 -0500", hash_original_method = "70EF475EAD59784B9F4988C66F330DB5", hash_generated_method = "11F8FC8C39CCEECCB7A9FB73F6C578A4")
    
public static ExecutorService unconfigurableExecutorService(ExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedExecutorService(executor);
    }

    /**
     * Returns an object that delegates all defined {@link
     * ScheduledExecutorService} methods to the given executor, but
     * not any other methods that might otherwise be accessible using
     * casts. This provides a way to safely "freeze" configuration and
     * disallow tuning of a given concrete implementation.
     * @param executor the underlying implementation
     * @return a <tt>ScheduledExecutorService</tt> instance
     * @throws NullPointerException if executor null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.767 -0500", hash_original_method = "CB4FE1F500230F7BE13AAEEB48858B34", hash_generated_method = "BA534C9653084D895D901BCD16036D28")
    
public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedScheduledExecutorService(executor);
    }

    /**
     * Returns a default thread factory used to create new threads.
     * This factory creates all new threads used by an Executor in the
     * same {@link ThreadGroup}. If there is a {@link
     * java.lang.SecurityManager}, it uses the group of {@link
     * System#getSecurityManager}, else the group of the thread
     * invoking this <tt>defaultThreadFactory</tt> method. Each new
     * thread is created as a non-daemon thread with priority set to
     * the smaller of <tt>Thread.NORM_PRIORITY</tt> and the maximum
     * priority permitted in the thread group.  New threads have names
     * accessible via {@link Thread#getName} of
     * <em>pool-N-thread-M</em>, where <em>N</em> is the sequence
     * number of this factory, and <em>M</em> is the sequence number
     * of the thread created by this factory.
     * @return a thread factory
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.769 -0500", hash_original_method = "B7AE3746CAE0BF4DA70BB99A06CCB766", hash_generated_method = "FF7C731BBAD164B6710B160D5B3024B5")
    
public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    /**
     * Returns a thread factory used to create new threads that
     * have the same permissions as the current thread.
     * This factory creates threads with the same settings as {@link
     * Executors#defaultThreadFactory}, additionally setting the
     * AccessControlContext and contextClassLoader of new threads to
     * be the same as the thread invoking this
     * <tt>privilegedThreadFactory</tt> method.  A new
     * <tt>privilegedThreadFactory</tt> can be created within an
     * {@link AccessController#doPrivileged} action setting the
     * current thread's access control context to create threads with
     * the selected permission settings holding within that action.
     *
     * <p> Note that while tasks running within such threads will have
     * the same access control and class loader settings as the
     * current thread, they need not have the same {@link
     * java.lang.ThreadLocal} or {@link
     * java.lang.InheritableThreadLocal} values. If necessary,
     * particular values of thread locals can be set or reset before
     * any task runs in {@link ThreadPoolExecutor} subclasses using
     * {@link ThreadPoolExecutor#beforeExecute}. Also, if it is
     * necessary to initialize worker threads to have the same
     * InheritableThreadLocal settings as some other designated
     * thread, you can create a custom ThreadFactory in which that
     * thread waits for and services requests to create others that
     * will inherit its values.
     *
     * @return a thread factory
     * @throws AccessControlException if the current access control
     * context does not have permission to both get and set context
     * class loader.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.771 -0500", hash_original_method = "B9A1CBBC5DC86C417067189200E34377", hash_generated_method = "78C9982FEA6BC9F8BF1266665F95D38E")
    
public static ThreadFactory privilegedThreadFactory() {
        return new PrivilegedThreadFactory();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Callable<T> callable(Runnable task, T result) {
        if (task == null)
            throw new NullPointerException();
        return new RunnableAdapter<T>(task, result);
    }

    /**
     * Returns a {@link Callable} object that, when
     * called, runs the given task and returns <tt>null</tt>.
     * @param task the task to run
     * @return a callable object
     * @throws NullPointerException if task null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.776 -0500", hash_original_method = "B54692C5F74502C1CEAE2E6CE0A90F1F", hash_generated_method = "8E843E3A5EF673FDB9702C5AAD91BD00")
    
public static Callable<Object> callable(Runnable task) {
        if (task == null)
            throw new NullPointerException();
        return new RunnableAdapter<Object>(task, null);
    }

    /**
     * Returns a {@link Callable} object that, when
     * called, runs the given privileged action and returns its result.
     * @param action the privileged action to run
     * @return a callable object
     * @throws NullPointerException if action null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.783 -0500", hash_original_method = "F6FC70FD2057C587C6268022A75CFBC6", hash_generated_method = "0069F1EAA731D9CB4AE019BB10DF004D")
    
public static Callable<Object> callable(final PrivilegedAction<?> action) {
        if (action == null)
            throw new NullPointerException();
        return new Callable<Object>() {
            public Object call() { return action.run(); }};
    }

    /**
     * Returns a {@link Callable} object that, when
     * called, runs the given privileged exception action and returns
     * its result.
     * @param action the privileged exception action to run
     * @return a callable object
     * @throws NullPointerException if action null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.788 -0500", hash_original_method = "359460025258D9D5DCCDA9E43BB1EDE6", hash_generated_method = "E46C05FBDBDD6F6AACF28A3DBB02B0C1")
    
public static Callable<Object> callable(final PrivilegedExceptionAction<?> action) {
        if (action == null)
            throw new NullPointerException();
        return new Callable<Object>() {
            public Object call() throws Exception { return action.run(); }};
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Callable<T> privilegedCallable(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallable<T>(callable);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static <T> Callable<T> privilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallableUsingCurrentClassLoader<T>(callable);
    }

    /** Cannot instantiate. */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.947 -0500", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "55D2E894E200221966BF60F73B91F1CC")
    
private Executors() {}
    
    static final class RunnableAdapter<T> implements Callable<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.797 -0500", hash_original_field = "3B9DB014EA5583311EF52FFA01325C0E", hash_generated_field = "3B9DB014EA5583311EF52FFA01325C0E")

         Runnable task;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.799 -0500", hash_original_field = "8B901F4123EF91F350535EEC5A55F787", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

         T result;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.801 -0500", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "39BEB710EA675D51CD733BCB993FC74E")
        
RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.804 -0500", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "1ED27E33BE4D8610214F7F251DDF57E0")
        
public T call() {
            task.run();
            return result;
        }
        
    }
    
    static final class PrivilegedCallable<T> implements Callable<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.808 -0500", hash_original_field = "780677264D34CF51811BA7D1F20EC905", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private  Callable<T> task;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.811 -0500", hash_original_field = "3C9C860D07F2335269AAFCB6082358FF", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private  AccessControlContext acc;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.815 -0500", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "12C65A09BA65E906C8B3945E2B4DB442")
        
PrivilegedCallable(Callable<T> task) {
            this.task = task;
            this.acc = AccessController.getContext();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.949 -0400", hash_original_method = "9B84B0D9F1F9FF2095D253EA33535221", hash_generated_method = "E14DBC5527319FD92CE738D97A5FE7C1")
        public T call() throws Exception {
            try 
            {
T var8C0E7955A367AA4C5A2C7492B4312867_977516067 =                 AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.818 -0500", hash_original_method = "2C30E1492126DFE1004B0460419644DD", hash_generated_method = "4464CE67F8386D29E6467A911100C39C")
                    
public T run() throws Exception {
                            return task.call();
                        }
}, acc);
                var8C0E7955A367AA4C5A2C7492B4312867_977516067.addTaint(getTaint());
                return var8C0E7955A367AA4C5A2C7492B4312867_977516067;
            } //End block
            catch (PrivilegedActionException e)
            {
                Exception varB727EB75A5923A25079A15DB07B65969_1926769963 = e.getException();
                varB727EB75A5923A25079A15DB07B65969_1926769963.addTaint(getTaint());
                throw varB727EB75A5923A25079A15DB07B65969_1926769963;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return AccessController.doPrivileged(
                    //new PrivilegedExceptionAction<T>() {
                        //public T run() throws Exception {
                            //return task.call();
                        //}
                    //}, acc);
            //} catch (PrivilegedActionException e) {
                //throw e.getException();
            //}
        }
        
        // orphaned legacy method
        public T run() throws Exception {
                            return task.call();
                        }
        
    }
    
    static final class PrivilegedCallableUsingCurrentClassLoader<T> implements Callable<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.826 -0500", hash_original_field = "780677264D34CF51811BA7D1F20EC905", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private  Callable<T> task;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.828 -0500", hash_original_field = "3C9C860D07F2335269AAFCB6082358FF", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private  AccessControlContext acc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.831 -0500", hash_original_field = "CE6C80FF459328C5008A9F8AE52A22C6", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private  ClassLoader ccl;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.834 -0500", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "EA5A282813953A9987262FF68D975AD1")
        
PrivilegedCallableUsingCurrentClassLoader(Callable<T> task) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                // Calls to getContextClassLoader from this class
                // never trigger a security check, but we check
                // whether our callers have this permission anyways.
                sm.checkPermission(new RuntimePermission("getContextClassLoader")); // android-changed

                // Whether setContextClassLoader turns out to be necessary
                // or not, we fail fast if permission is not available.
                sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            }
            this.task = task;
            this.acc = AccessController.getContext();
            this.ccl = Thread.currentThread().getContextClassLoader();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.953 -0400", hash_original_method = "083E1FD40613168D34C9FEEE9DFC0EBD", hash_generated_method = "A36CDEF7A248443757048A585C2D137C")
        public T call() throws Exception {
            try 
            {
T varBCBFD1547E568D77EC8B60D97435E881_964807118 =                 AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.838 -0500", hash_original_method = "EAF5A8360517EEB3FD91B09A069198A5", hash_generated_method = "A29A67C4510C62A18A915200C80CAF23")
                    
public T run() throws Exception {
                            ClassLoader savedcl = null;
                            Thread t = Thread.currentThread();
                            try {
                                ClassLoader cl = t.getContextClassLoader();
                                if (ccl != cl) {
                                    t.setContextClassLoader(ccl);
                                    savedcl = cl;
                                }
                                return task.call();
                            } finally {
                                if (savedcl != null)
                                    t.setContextClassLoader(savedcl);
                            }
                        }
}, acc);
                varBCBFD1547E568D77EC8B60D97435E881_964807118.addTaint(getTaint());
                return varBCBFD1547E568D77EC8B60D97435E881_964807118;
            } //End block
            catch (PrivilegedActionException e)
            {
                Exception varB727EB75A5923A25079A15DB07B65969_1592493440 = e.getException();
                varB727EB75A5923A25079A15DB07B65969_1592493440.addTaint(getTaint());
                throw varB727EB75A5923A25079A15DB07B65969_1592493440;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        
        // orphaned legacy method
        public T run() throws Exception {
                            ClassLoader savedcl = null;
                            Thread t = Thread.currentThread();
                            try {
                                ClassLoader cl = t.getContextClassLoader();
                                if (ccl != cl) {
                                    t.setContextClassLoader(ccl);
                                    savedcl = cl;
                                }
                                return task.call();
                            } finally {
                                if (savedcl != null)
                                    t.setContextClassLoader(savedcl);
                            }
                        }
        
    }
    
    static class DefaultThreadFactory implements ThreadFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.845 -0500", hash_original_field = "A0056246F2A3A019EB9FCA2BF1F518E1", hash_generated_field = "4D1AD706E0B207CD49EDE0FDF77D35E3")

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.848 -0500", hash_original_field = "33105990A6F540695DACD98BC18B81F7", hash_generated_field = "6F10AD05CE1F57FC2F4A5DF43A505F99")

        private  ThreadGroup group;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.850 -0500", hash_original_field = "ADA893980418D1565C4EC870C7176866", hash_generated_field = "1DD6DDF0F67F2F10AA2E1938FCC29304")

        private final AtomicInteger threadNumber = new AtomicInteger(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.853 -0500", hash_original_field = "0CFF1478A396C5BC6613DA2AC8C37504", hash_generated_field = "2F76B01D831BB088ADF19AC1319DB54D")

        private  String namePrefix;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.857 -0500", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "6C4DB34AB218BB8D6524A59E94717A2E")
        
DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                                  Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                          poolNumber.getAndIncrement() +
                         "-thread-";
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.860 -0500", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "CA56EC83A1C3C9C968761B032ADA6C4A")
        
public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.864 -0500", hash_original_field = "3C9C860D07F2335269AAFCB6082358FF", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private  AccessControlContext acc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.867 -0500", hash_original_field = "CE6C80FF459328C5008A9F8AE52A22C6", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private  ClassLoader ccl;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.870 -0500", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "B8E6825D1EEB42C0F8FEB349B83C6704")
        
PrivilegedThreadFactory() {
            super();
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                // Calls to getContextClassLoader from this class
                // never trigger a security check, but we check
                // whether our callers have this permission anyways.
                sm.checkPermission(new RuntimePermission("getContextClassLoader")); // android-changed

                // Fail fast
                sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            }
            this.acc = AccessController.getContext();
            this.ccl = Thread.currentThread().getContextClassLoader();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.879 -0500", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "F4714F7F7A9925E5C69E3F074A70A72A")
        
public Thread newThread(final Runnable r) {
            return super.newThread(new Runnable() {
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Void>() {
                        public Void run() {
                            Thread.currentThread().setContextClassLoader(ccl);
                            r.run();
                            return null;
                        }
                    }, acc);
                }
            });
        }
        
    }
    
    static class DelegatedExecutorService extends AbstractExecutorService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.884 -0500", hash_original_field = "08308C1E09B9F16E16C40112958058EB", hash_generated_field = "11B8F83ADD158AE4ADD1E7AA1252842D")

        private  ExecutorService e;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.887 -0500", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "69B8656E71D4B49ACEB9CE44B20A63F5")
        
DelegatedExecutorService(ExecutorService executor) { e = executor; }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.889 -0500", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "5FF620BA750B9AA4D5060F4389C28B45")
        
public void execute(Runnable command) { e.execute(command); }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.892 -0500", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "47459E05F3A9A2C970C5C1FE50023241")
        
public void shutdown() { e.shutdown(); }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.894 -0500", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "A990C9CB1A96368BDFAA077334BA9CB2")
        
public List<Runnable> shutdownNow() { return e.shutdownNow(); }
        @DSSafe(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.896 -0500", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "3ED36EAA0FDD5A7DA2E3DB880E4255AC")
        
public boolean isShutdown() { return e.isShutdown(); }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.898 -0500", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "431E04F8EFA8337811BFB175053A048A")
        
public boolean isTerminated() { return e.isTerminated(); }
        @DSSafe(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.902 -0500", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "73417C1B12A9F316B0A3C9BA038DEE1D")
        
public boolean awaitTermination(long timeout, TimeUnit unit)
            throws InterruptedException {
            return e.awaitTermination(timeout, unit);
        }
        @DSSpec(DSCat.EXEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.905 -0500", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "B1E20F9363F4AD28BDBD861F9CB91AD2")
        
public Future<?> submit(Runnable task) {
            return e.submit(task);
        }
        
        @DSSpec(DSCat.EXEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "AA01AE8CA15C63BFFFD6A901646BAC26")
        public <T> Future<T> submit(Callable<T> task) {
            addTaint(task.getTaint());
Future<T> var3A821B5C48F3C73F2F85580271A54221_1800187115 =             e.submit(task);
            var3A821B5C48F3C73F2F85580271A54221_1800187115.addTaint(getTaint());
            return var3A821B5C48F3C73F2F85580271A54221_1800187115;
            // ---------- Original Method ----------
            //return e.submit(task);
        }
        
        @DSSpec(DSCat.EXEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "0AA752005320E5BA2422D1327FD79FC5")
        public <T> Future<T> submit(Runnable task, T result) {
            addTaint(result.getTaint());
            addTaint(task.getTaint());
Future<T> varEAF64FBE2776E66AA7D7A86DC0368144_678840174 =             e.submit(task, result);
            varEAF64FBE2776E66AA7D7A86DC0368144_678840174.addTaint(getTaint());
            return varEAF64FBE2776E66AA7D7A86DC0368144_678840174;
            // ---------- Original Method ----------
            //return e.submit(task, result);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "763A8BDAED7E7F87F7780CC06FF23828")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            addTaint(tasks.getTaint());
List<Future<T>> var501DF73082C68D7843A2F94A5A9D39DE_125190879 =             e.invokeAll(tasks);
            var501DF73082C68D7843A2F94A5A9D39DE_125190879.addTaint(getTaint());
            return var501DF73082C68D7843A2F94A5A9D39DE_125190879;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "F4AC9DAD7CAA5186CA2E4402CBC77145")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(tasks.getTaint());
List<Future<T>> var87E281F68E17B3CFFAEC895C8A8BFC68_708146293 =             e.invokeAll(tasks, timeout, unit);
            var87E281F68E17B3CFFAEC895C8A8BFC68_708146293.addTaint(getTaint());
            return var87E281F68E17B3CFFAEC895C8A8BFC68_708146293;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks, timeout, unit);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "8B5EE102BC34D4E24BA7EFBB0665BD75")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            addTaint(tasks.getTaint());
T var7ECF5F9BD3788A61679614FEA5EAB1C2_271945437 =             e.invokeAny(tasks);
            var7ECF5F9BD3788A61679614FEA5EAB1C2_271945437.addTaint(getTaint());
            return var7ECF5F9BD3788A61679614FEA5EAB1C2_271945437;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "C9B006B0B01AB1143ACEE71469CEF48F")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(tasks.getTaint());
T varE9E99FB5B2AB72C024FC741DCEE9DEC0_196926114 =             e.invokeAny(tasks, timeout, unit);
            varE9E99FB5B2AB72C024FC741DCEE9DEC0_196926114.addTaint(getTaint());
            return varE9E99FB5B2AB72C024FC741DCEE9DEC0_196926114;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks, timeout, unit);
        }
        
    }
    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.923 -0500", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "0BC6912A00A2948375A36BA345B953A1")
        
FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.925 -0500", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "EEFE217E73A2E39A61F93BFB37D862D9")
        
protected void finalize() {
            super.shutdown();
        }
        
    }
    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.930 -0500", hash_original_field = "B6F2D26F7E5AC760D384D7FDFDC2C7DA", hash_generated_field = "3D78CFB93E5EA21FD7B6DC753DB36818")

        private  ScheduledExecutorService e;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.933 -0500", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "B9414E1A08721941535D3112D446A4F5")
        
DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            e = executor;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.935 -0500", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "800F163B0A4827257227764561C1138C")
        
public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            return e.schedule(command, delay, unit);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.438 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "10925EFC86BE3C187277C3C9203C26A9")
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(callable.getTaint());
ScheduledFuture<V> var25477A3DA2D98386CF98CD42AD75D94E_288143507 =             e.schedule(callable, delay, unit);
            var25477A3DA2D98386CF98CD42AD75D94E_288143507.addTaint(getTaint());
            return var25477A3DA2D98386CF98CD42AD75D94E_288143507;
            // ---------- Original Method ----------
            //return e.schedule(callable, delay, unit);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.940 -0500", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "FA48FD12BC63B95A262BD259B0E1DCE7")
        
public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            return e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:08.942 -0500", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "18AC7CB4833D2DB4EE9FF9D76BB649E5")
        
public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            return e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }
        
    }
    
}

