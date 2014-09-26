/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * An {@link ExecutorService} for running {@link ForkJoinTask}s.
 * A {@code ForkJoinPool} provides the entry point for submissions
 * from non-{@code ForkJoinTask} clients, as well as management and
 * monitoring operations.
 *
 * <p>A {@code ForkJoinPool} differs from other kinds of {@link
 * ExecutorService} mainly by virtue of employing
 * <em>work-stealing</em>: all threads in the pool attempt to find and
 * execute tasks submitted to the pool and/or created by other active
 * tasks (eventually blocking waiting for work if none exist). This
 * enables efficient processing when most tasks spawn other subtasks
 * (as do most {@code ForkJoinTask}s), as well as when many small
 * tasks are submitted to the pool from external clients.  Especially
 * when setting <em>asyncMode</em> to true in constructors, {@code
 * ForkJoinPool}s may also be appropriate for use with event-style
 * tasks that are never joined.
 *
 * <p>A static {@link #commonPool()} is available and appropriate for
 * most applications. The common pool is used by any ForkJoinTask that
 * is not explicitly submitted to a specified pool. Using the common
 * pool normally reduces resource usage (its threads are slowly
 * reclaimed during periods of non-use, and reinstated upon subsequent
 * use).
 *
 * <p>For applications that require separate or custom pools, a {@code
 * ForkJoinPool} may be constructed with a given target parallelism
 * level; by default, equal to the number of available processors. The
 * pool attempts to maintain enough active (or available) threads by
 * dynamically adding, suspending, or resuming internal worker
 * threads, even if some tasks are stalled waiting to join
 * others. However, no such adjustments are guaranteed in the face of
 * blocked I/O or other unmanaged synchronization. The nested {@link
 * ManagedBlocker} interface enables extension of the kinds of
 * synchronization accommodated.
 *
 * <p>In addition to execution and lifecycle control methods, this
 * class provides status check methods (for example
 * {@link #getStealCount}) that are intended to aid in developing,
 * tuning, and monitoring fork/join applications. Also, method
 * {@link #toString} returns indications of pool state in a
 * convenient form for informal monitoring.
 *
 * <p>As is the case with other ExecutorServices, there are three
 * main task execution methods summarized in the following table.
 * These are designed to be used primarily by clients not already
 * engaged in fork/join computations in the current pool.  The main
 * forms of these methods accept instances of {@code ForkJoinTask},
 * but overloaded forms also allow mixed execution of plain {@code
 * Runnable}- or {@code Callable}- based activities as well.  However,
 * tasks that are already executing in a pool should normally instead
 * use the within-computation forms listed in the table unless using
 * async event-style tasks that are not usually joined, in which case
 * there is little difference among choice of methods.
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER> <b>Call from non-fork/join clients</b></td>
 *    <td ALIGN=CENTER> <b>Call from within fork/join computations</b></td>
 *  </tr>
 *  <tr>
 *    <td> <b>Arrange async execution</td>
 *    <td> {@link #execute(ForkJoinTask)}</td>
 *    <td> {@link ForkJoinTask#fork}</td>
 *  </tr>
 *  <tr>
 *    <td> <b>Await and obtain result</td>
 *    <td> {@link #invoke(ForkJoinTask)}</td>
 *    <td> {@link ForkJoinTask#invoke}</td>
 *  </tr>
 *  <tr>
 *    <td> <b>Arrange exec and obtain Future</td>
 *    <td> {@link #submit(ForkJoinTask)}</td>
 *    <td> {@link ForkJoinTask#fork} (ForkJoinTasks <em>are</em> Futures)</td>
 *  </tr>
 * </table>
 *
 * <p>The common pool is by default constructed with default
 * parameters, but these may be controlled by setting three {@link
 * System#getProperty system properties} with prefix {@code
 * java.util.concurrent.ForkJoinPool.common}: {@code parallelism} --
 * an integer greater than zero, {@code threadFactory} -- the class
 * name of a {@link ForkJoinWorkerThreadFactory}, and {@code
 * exceptionHandler} -- the class name of a {@link
 * java.lang.Thread.UncaughtExceptionHandler
 * Thread.UncaughtExceptionHandler}. Upon any error in establishing
 * these settings, default parameters are used.
 *
 * <p><b>Implementation notes</b>: This implementation restricts the
 * maximum number of running threads to 32767. Attempts to create
 * pools with greater than the maximum number result in
 * {@code IllegalArgumentException}.
 *
 * <p>This implementation rejects submitted tasks (that is, by throwing
 * {@link RejectedExecutionException}) only when the pool is shut down
 * or internal resources have been exhausted.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
public class ForkJoinPool extends AbstractExecutorService {

    /*
     * Implementation Overview
     *
     * This class and its nested classes provide the main
     * functionality and control for a set of worker threads:
     * Submissions from non-FJ threads enter into submission queues.
     * Workers take these tasks and typically split them into subtasks
     * that may be stolen by other workers.  Preference rules give
     * first priority to processing tasks from their own queues (LIFO
     * or FIFO, depending on mode), then to randomized FIFO steals of
     * tasks in other queues.
     *
     * WorkQueues
     * ==========
     *
     * Most operations occur within work-stealing queues (in nested
     * class WorkQueue).  These are special forms of Deques that
     * support only three of the four possible end-operations -- push,
     * pop, and poll (aka steal), under the further constraints that
     * push and pop are called only from the owning thread (or, as
     * extended here, under a lock), while poll may be called from
     * other threads.  (If you are unfamiliar with them, you probably
     * want to read Herlihy and Shavit's book "The Art of
     * Multiprocessor programming", chapter 16 describing these in
     * more detail before proceeding.)  The main work-stealing queue
     * design is roughly similar to those in the papers "Dynamic
     * Circular Work-Stealing Deque" by Chase and Lev, SPAA 2005
     * (http://research.sun.com/scalable/pubs/index.html) and
     * "Idempotent work stealing" by Michael, Saraswat, and Vechev,
     * PPoPP 2009 (http://portal.acm.org/citation.cfm?id=1504186).
     * The main differences ultimately stem from GC requirements that
     * we null out taken slots as soon as we can, to maintain as small
     * a footprint as possible even in programs generating huge
     * numbers of tasks. To accomplish this, we shift the CAS
     * arbitrating pop vs poll (steal) from being on the indices
     * ("base" and "top") to the slots themselves.  So, both a
     * successful pop and poll mainly entail a CAS of a slot from
     * non-null to null.  Because we rely on CASes of references, we
     * do not need tag bits on base or top.  They are simple ints as
     * used in any circular array-based queue (see for example
     * ArrayDeque).  Updates to the indices must still be ordered in a
     * way that guarantees that top == base means the queue is empty,
     * but otherwise may err on the side of possibly making the queue
     * appear nonempty when a push, pop, or poll have not fully
     * committed. Note that this means that the poll operation,
     * considered individually, is not wait-free. One thief cannot
     * successfully continue until another in-progress one (or, if
     * previously empty, a push) completes.  However, in the
     * aggregate, we ensure at least probabilistic non-blockingness.
     * If an attempted steal fails, a thief always chooses a different
     * random victim target to try next. So, in order for one thief to
     * progress, it suffices for any in-progress poll or new push on
     * any empty queue to complete. (This is why we normally use
     * method pollAt and its variants that try once at the apparent
     * base index, else consider alternative actions, rather than
     * method poll.)
     *
     * This approach also enables support of a user mode in which local
     * task processing is in FIFO, not LIFO order, simply by using
     * poll rather than pop.  This can be useful in message-passing
     * frameworks in which tasks are never joined.  However neither
     * mode considers affinities, loads, cache localities, etc, so
     * rarely provide the best possible performance on a given
     * machine, but portably provide good throughput by averaging over
     * these factors.  (Further, even if we did try to use such
     * information, we do not usually have a basis for exploiting it.
     * For example, some sets of tasks profit from cache affinities,
     * but others are harmed by cache pollution effects.)
     *
     * WorkQueues are also used in a similar way for tasks submitted
     * to the pool. We cannot mix these tasks in the same queues used
     * for work-stealing (this would contaminate lifo/fifo
     * processing). Instead, we randomly associate submission queues
     * with submitting threads, using a form of hashing.  The
     * ThreadLocal Submitter class contains a value initially used as
     * a hash code for choosing existing queues, but may be randomly
     * repositioned upon contention with other submitters.  In
     * essence, submitters act like workers except that they are
     * restricted to executing local tasks that they submitted (or in
     * the case of CountedCompleters, others with the same root task).
     * However, because most shared/external queue operations are more
     * expensive than internal, and because, at steady state, external
     * submitters will compete for CPU with workers, ForkJoinTask.join
     * and related methods disable them from repeatedly helping to
     * process tasks if all workers are active.  Insertion of tasks in
     * shared mode requires a lock (mainly to protect in the case of
     * resizing) but we use only a simple spinlock (using bits in
     * field qlock), because submitters encountering a busy queue move
     * on to try or create other queues -- they block only when
     * creating and registering new queues.
     *
     * Management
     * ==========
     *
     * The main throughput advantages of work-stealing stem from
     * decentralized control -- workers mostly take tasks from
     * themselves or each other. We cannot negate this in the
     * implementation of other management responsibilities. The main
     * tactic for avoiding bottlenecks is packing nearly all
     * essentially atomic control state into two volatile variables
     * that are by far most often read (not written) as status and
     * consistency checks.
     *
     * Field "ctl" contains 64 bits holding all the information needed
     * to atomically decide to add, inactivate, enqueue (on an event
     * queue), dequeue, and/or re-activate workers.  To enable this
     * packing, we restrict maximum parallelism to (1<<15)-1 (which is
     * far in excess of normal operating range) to allow ids, counts,
     * and their negations (used for thresholding) to fit into 16bit
     * fields.
     *
     * Field "plock" is a form of sequence lock with a saturating
     * shutdown bit (similarly for per-queue "qlocks"), mainly
     * protecting updates to the workQueues array, as well as to
     * enable shutdown.  When used as a lock, it is normally only very
     * briefly held, so is nearly always available after at most a
     * brief spin, but we use a monitor-based backup strategy to
     * block when needed.
     *
     * Recording WorkQueues.  WorkQueues are recorded in the
     * "workQueues" array that is created upon first use and expanded
     * if necessary.  Updates to the array while recording new workers
     * and unrecording terminated ones are protected from each other
     * by a lock but the array is otherwise concurrently readable, and
     * accessed directly.  To simplify index-based operations, the
     * array size is always a power of two, and all readers must
     * tolerate null slots. Worker queues are at odd indices. Shared
     * (submission) queues are at even indices, up to a maximum of 64
     * slots, to limit growth even if array needs to expand to add
     * more workers. Grouping them together in this way simplifies and
     * speeds up task scanning.
     *
     * All worker thread creation is on-demand, triggered by task
     * submissions, replacement of terminated workers, and/or
     * compensation for blocked workers. However, all other support
     * code is set up to work with other policies.  To ensure that we
     * do not hold on to worker references that would prevent GC, ALL
     * accesses to workQueues are via indices into the workQueues
     * array (which is one source of some of the messy code
     * constructions here). In essence, the workQueues array serves as
     * a weak reference mechanism. Thus for example the wait queue
     * field of ctl stores indices, not references.  Access to the
     * workQueues in associated methods (for example signalWork) must
     * both index-check and null-check the IDs. All such accesses
     * ignore bad IDs by returning out early from what they are doing,
     * since this can only be associated with termination, in which
     * case it is OK to give up.  All uses of the workQueues array
     * also check that it is non-null (even if previously
     * non-null). This allows nulling during termination, which is
     * currently not necessary, but remains an option for
     * resource-revocation-based shutdown schemes. It also helps
     * reduce JIT issuance of uncommon-trap code, which tends to
     * unnecessarily complicate control flow in some methods.
     *
     * Event Queuing. Unlike HPC work-stealing frameworks, we cannot
     * let workers spin indefinitely scanning for tasks when none can
     * be found immediately, and we cannot start/resume workers unless
     * there appear to be tasks available.  On the other hand, we must
     * quickly prod them into action when new tasks are submitted or
     * generated. In many usages, ramp-up time to activate workers is
     * the main limiting factor in overall performance (this is
     * compounded at program start-up by JIT compilation and
     * allocation). So we try to streamline this as much as possible.
     * We park/unpark workers after placing in an event wait queue
     * when they cannot find work. This "queue" is actually a simple
     * Treiber stack, headed by the "id" field of ctl, plus a 15bit
     * counter value (that reflects the number of times a worker has
     * been inactivated) to avoid ABA effects (we need only as many
     * version numbers as worker threads). Successors are held in
     * field WorkQueue.nextWait.  Queuing deals with several intrinsic
     * races, mainly that a task-producing thread can miss seeing (and
     * signalling) another thread that gave up looking for work but
     * has not yet entered the wait queue. We solve this by requiring
     * a full sweep of all workers (via repeated calls to method
     * scan()) both before and after a newly waiting worker is added
     * to the wait queue. During a rescan, the worker might release
     * some other queued worker rather than itself, which has the same
     * net effect. Because enqueued workers may actually be rescanning
     * rather than waiting, we set and clear the "parker" field of
     * WorkQueues to reduce unnecessary calls to unpark.  (This
     * requires a secondary recheck to avoid missed signals.)  Note
     * the unusual conventions about Thread.interrupts surrounding
     * parking and other blocking: Because interrupts are used solely
     * to alert threads to check termination, which is checked anyway
     * upon blocking, we clear status (using Thread.interrupted)
     * before any call to park, so that park does not immediately
     * return due to status being set via some other unrelated call to
     * interrupt in user code.
     *
     * Signalling.  We create or wake up workers only when there
     * appears to be at least one task they might be able to find and
     * execute. However, many other threads may notice the same task
     * and each signal to wake up a thread that might take it. So in
     * general, pools will be over-signalled.  When a submission is
     * added or another worker adds a task to a queue that has fewer
     * than two tasks, they signal waiting workers (or trigger
     * creation of new ones if fewer than the given parallelism level
     * -- signalWork), and may leave a hint to the unparked worker to
     * help signal others upon wakeup).  These primary signals are
     * buttressed by others (see method helpSignal) whenever other
     * threads scan for work or do not have a task to process.  On
     * most platforms, signalling (unpark) overhead time is noticeably
     * long, and the time between signalling a thread and it actually
     * making progress can be very noticeably long, so it is worth
     * offloading these delays from critical paths as much as
     * possible.
     *
     * Trimming workers. To release resources after periods of lack of
     * use, a worker starting to wait when the pool is quiescent will
     * time out and terminate if the pool has remained quiescent for a
     * given period -- a short period if there are more threads than
     * parallelism, longer as the number of threads decreases. This
     * will slowly propagate, eventually terminating all workers after
     * periods of non-use.
     *
     * Shutdown and Termination. A call to shutdownNow atomically sets
     * a plock bit and then (non-atomically) sets each worker's
     * qlock status, cancels all unprocessed tasks, and wakes up
     * all waiting workers.  Detecting whether termination should
     * commence after a non-abrupt shutdown() call requires more work
     * and bookkeeping. We need consensus about quiescence (i.e., that
     * there is no more work). The active count provides a primary
     * indication but non-abrupt shutdown still requires a rechecking
     * scan for any workers that are inactive but not queued.
     *
     * Joining Tasks
     * =============
     *
     * Any of several actions may be taken when one worker is waiting
     * to join a task stolen (or always held) by another.  Because we
     * are multiplexing many tasks on to a pool of workers, we can't
     * just let them block (as in Thread.join).  We also cannot just
     * reassign the joiner's run-time stack with another and replace
     * it later, which would be a form of "continuation", that even if
     * possible is not necessarily a good idea since we sometimes need
     * both an unblocked task and its continuation to progress.
     * Instead we combine two tactics:
     *
     *   Helping: Arranging for the joiner to execute some task that it
     *      would be running if the steal had not occurred.
     *
     *   Compensating: Unless there are already enough live threads,
     *      method tryCompensate() may create or re-activate a spare
     *      thread to compensate for blocked joiners until they unblock.
     *
     * A third form (implemented in tryRemoveAndExec) amounts to
     * helping a hypothetical compensator: If we can readily tell that
     * a possible action of a compensator is to steal and execute the
     * task being joined, the joining thread can do so directly,
     * without the need for a compensation thread (although at the
     * expense of larger run-time stacks, but the tradeoff is
     * typically worthwhile).
     *
     * The ManagedBlocker extension API can't use helping so relies
     * only on compensation in method awaitBlocker.
     *
     * The algorithm in tryHelpStealer entails a form of "linear"
     * helping: Each worker records (in field currentSteal) the most
     * recent task it stole from some other worker. Plus, it records
     * (in field currentJoin) the task it is currently actively
     * joining. Method tryHelpStealer uses these markers to try to
     * find a worker to help (i.e., steal back a task from and execute
     * it) that could hasten completion of the actively joined task.
     * In essence, the joiner executes a task that would be on its own
     * local deque had the to-be-joined task not been stolen. This may
     * be seen as a conservative variant of the approach in Wagner &
     * Calder "Leapfrogging: a portable technique for implementing
     * efficient futures" SIGPLAN Notices, 1993
     * (http://portal.acm.org/citation.cfm?id=155354). It differs in
     * that: (1) We only maintain dependency links across workers upon
     * steals, rather than use per-task bookkeeping.  This sometimes
     * requires a linear scan of workQueues array to locate stealers,
     * but often doesn't because stealers leave hints (that may become
     * stale/wrong) of where to locate them.  It is only a hint
     * because a worker might have had multiple steals and the hint
     * records only one of them (usually the most current).  Hinting
     * isolates cost to when it is needed, rather than adding to
     * per-task overhead.  (2) It is "shallow", ignoring nesting and
     * potentially cyclic mutual steals.  (3) It is intentionally
     * racy: field currentJoin is updated only while actively joining,
     * which means that we miss links in the chain during long-lived
     * tasks, GC stalls etc (which is OK since blocking in such cases
     * is usually a good idea).  (4) We bound the number of attempts
     * to find work (see MAX_HELP) and fall back to suspending the
     * worker and if necessary replacing it with another.
     *
     * Helping actions for CountedCompleters are much simpler: Method
     * helpComplete can take and execute any task with the same root
     * as the task being waited on. However, this still entails some
     * traversal of completer chains, so is less efficient than using
     * CountedCompleters without explicit joins.
     *
     * It is impossible to keep exactly the target parallelism number
     * of threads running at any given time.  Determining the
     * existence of conservatively safe helping targets, the
     * availability of already-created spares, and the apparent need
     * to create new spares are all racy, so we rely on multiple
     * retries of each.  Compensation in the apparent absence of
     * helping opportunities is challenging to control on JVMs, where
     * GC and other activities can stall progress of tasks that in
     * turn stall out many other dependent tasks, without us being
     * able to determine whether they will ever require compensation.
     * Even though work-stealing otherwise encounters little
     * degradation in the presence of more threads than cores,
     * aggressively adding new threads in such cases entails risk of
     * unwanted positive feedback control loops in which more threads
     * cause more dependent stalls (as well as delayed progress of
     * unblocked threads to the point that we know they are available)
     * leading to more situations requiring more threads, and so
     * on. This aspect of control can be seen as an (analytically
     * intractable) game with an opponent that may choose the worst
     * (for us) active thread to stall at any time.  We take several
     * precautions to bound losses (and thus bound gains), mainly in
     * methods tryCompensate and awaitJoin.
     *
     * Common Pool
     * ===========
     *
     * The static commonPool always exists after static
     * initialization.  Since it (or any other created pool) need
     * never be used, we minimize initial construction overhead and
     * footprint to the setup of about a dozen fields, with no nested
     * allocation. Most bootstrapping occurs within method
     * fullExternalPush during the first submission to the pool.
     *
     * When external threads submit to the common pool, they can
     * perform some subtask processing (see externalHelpJoin and
     * related methods).  We do not need to record whether these
     * submissions are to the common pool -- if not, externalHelpJoin
     * returns quickly (at the most helping to signal some common pool
     * workers). These submitters would otherwise be blocked waiting
     * for completion, so the extra effort (with liberally sprinkled
     * task status checks) in inapplicable cases amounts to an odd
     * form of limited spin-wait before blocking in ForkJoinTask.join.
     *
     * Style notes
     * ===========
     *
     * There is a lot of representation-level coupling among classes
     * ForkJoinPool, ForkJoinWorkerThread, and ForkJoinTask.  The
     * fields of WorkQueue maintain data structures managed by
     * ForkJoinPool, so are directly accessed.  There is little point
     * trying to reduce this, since any associated future changes in
     * representations will need to be accompanied by algorithmic
     * changes anyway. Several methods intrinsically sprawl because
     * they must accumulate sets of consistent reads of volatiles held
     * in local variables.  Methods signalWork() and scan() are the
     * main bottlenecks, so are especially heavily
     * micro-optimized/mangled.  There are lots of inline assignments
     * (of form "while ((local = field) != 0)") which are usually the
     * simplest way to ensure the required read orderings (which are
     * sometimes critical). This leads to a "C"-like style of listing
     * declarations of these locals at the heads of methods or blocks.
     * There are several occurrences of the unusual "do {} while
     * (!cas...)"  which is the simplest way to force an update of a
     * CAS'ed variable. There are also other coding oddities (including
     * several unnecessary-looking hoisted null checks) that help
     * some methods perform reasonably even when interpreted (not
     * compiled).
     *
     * The order of declarations in this file is:
     * (1) Static utility functions
     * (2) Nested (static) classes
     * (3) Static fields
     * (4) Fields, along with constants used when unpacking some of them
     * (5) Internal control methods
     * (6) Callbacks and other support for ForkJoinTask methods
     * (7) Exported methods
     * (8) Static block initializing statics in minimally dependent order
     */

    // Static utilities

    /**
     * If there is a security manager, makes sure caller has
     * permission to modify threads.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.878 -0400", hash_original_method = "AE012463877A0ADB827143E6C6B2560C", hash_generated_method = "B462B7CBD44CA25E992A0F44E641BCCA")
    
private static void checkPermission() {
        SecurityManager security = System.getSecurityManager();
        if (security != null)
            security.checkPermission(modifyThreadPermission);
    }

    // Nested classes

    /**
     * Factory for creating new {@link ForkJoinWorkerThread}s.
     * A {@code ForkJoinWorkerThreadFactory} must be defined and used
     * for {@code ForkJoinWorkerThread} subclasses that extend base
     * functionality or initialize threads with different contexts.
     */
    public static interface ForkJoinWorkerThreadFactory {
        /**
         * Returns a new worker thread operating in the given pool.
         *
         * @param pool the pool this thread works in
         * @throws NullPointerException if the pool is null
         */
        public ForkJoinWorkerThread newThread(ForkJoinPool pool);
    }

    /**
     * Default ForkJoinWorkerThreadFactory implementation; creates a
     * new ForkJoinWorkerThread.
     */
    static final class DefaultForkJoinWorkerThreadFactory
        implements ForkJoinWorkerThreadFactory {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.879 -0400", hash_original_method = "0E2E90FD964756C16A4C5011A0293420", hash_generated_method = "7F73E758EE4E46DED84A2A2BCBE55DD1")
        
public final ForkJoinWorkerThread newThread(ForkJoinPool pool) {
            return new ForkJoinWorkerThread(pool);
        }
    }

    /**
     * Per-thread records for threads that submit to pools. Currently
     * holds only pseudo-random seed / index that is used to choose
     * submission queues in method externalPush. In the future, this may
     * also incorporate a means to implement different task rejection
     * and resubmission policies.
     *
     * Seeds for submitters and workers/workQueues work in basically
     * the same way but are initialized and updated using slightly
     * different mechanics. Both are initialized using the same
     * approach as in class ThreadLocal, where successive values are
     * unlikely to collide with previous values. Seeds are then
     * randomly modified upon collisions using xorshifts, which
     * requires a non-zero seed.
     */
    static final class Submitter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.880 -0400", hash_original_field = "CFBFD2C5E2E26F8CE5AEE6B20558FC7E", hash_generated_field = "CFBFD2C5E2E26F8CE5AEE6B20558FC7E")

        int seed;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.880 -0400", hash_original_method = "C8F562808CA3E14FC4C166BD42F30341", hash_generated_method = "C8F562808CA3E14FC4C166BD42F30341")
        
Submitter(int s) { seed = s; }
    }

    /**
     * Class for artificial tasks that are used to replace the target
     * of local joins if they are removed from an interior queue slot
     * in WorkQueue.tryRemoveAndExec. We don't need the proxy to
     * actually do anything beyond having a unique identity.
     */
    static final class EmptyTask extends ForkJoinTask<Void> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.881 -0400", hash_original_field = "8A999C2B6C1E353D8BBBE70F270C889C", hash_generated_field = "C78CDE4A9B2BA35F7E2E7C42BDBB7E01")

        private static final long serialVersionUID = -7721805057305804111L;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.881 -0400", hash_original_method = "C3192D6BFFCAF40A78BEB9420C2C9AF4", hash_generated_method = "C3192D6BFFCAF40A78BEB9420C2C9AF4")
        
EmptyTask() { status = ForkJoinTask.NORMAL; } // force done
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.882 -0400", hash_original_method = "3DE82AA92F6CBDFB2CF4126D370439F9", hash_generated_method = "3F97477252B0C202F30FC22FA92A0B8B")
        
public final Void getRawResult() { return null; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.882 -0400", hash_original_method = "B73F2AC0E5FD3D5603762A299DA219EC", hash_generated_method = "5B13BFF3F115F222B2129DE151B2EA95")
        
public final void setRawResult(Void x) {}
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.882 -0400", hash_original_method = "FAE099A9CC16659D7966552713C7F574", hash_generated_method = "4DB6DDBC3A18A387A7211D75E5F5378F")
        
public final boolean exec() { return true; }
    }

    /**
     * Queues supporting work-stealing as well as external task
     * submission. See above for main rationale and algorithms.
     * Implementation relies heavily on "Unsafe" intrinsics
     * and selective use of "volatile":
     *
     * Field "base" is the index (mod array.length) of the least valid
     * queue slot, which is always the next position to steal (poll)
     * from if nonempty. Reads and writes require volatile orderings
     * but not CAS, because updates are only performed after slot
     * CASes.
     *
     * Field "top" is the index (mod array.length) of the next queue
     * slot to push to or pop from. It is written only by owner thread
     * for push, or under lock for external/shared push, and accessed
     * by other threads only after reading (volatile) base.  Both top
     * and base are allowed to wrap around on overflow, but (top -
     * base) (or more commonly -(base - top) to force volatile read of
     * base before top) still estimates size. The lock ("qlock") is
     * forced to -1 on termination, causing all further lock attempts
     * to fail. (Note: we don't need CAS for termination state because
     * upon pool shutdown, all shared-queues will stop being used
     * anyway.)  Nearly all lock bodies are set up so that exceptions
     * within lock bodies are "impossible" (modulo JVM errors that
     * would cause failure anyway.)
     *
     * The array slots are read and written using the emulation of
     * volatiles/atomics provided by Unsafe. Insertions must in
     * general use putOrderedObject as a form of releasing store to
     * ensure that all writes to the task object are ordered before
     * its publication in the queue.  All removals entail a CAS to
     * null.  The array is always a power of two. To ensure safety of
     * Unsafe array operations, all accesses perform explicit null
     * checks and implicit bounds checks via power-of-two masking.
     *
     * In addition to basic queuing support, this class contains
     * fields described elsewhere to control execution. It turns out
     * to work better memory-layout-wise to include them in this class
     * rather than a separate class.
     *
     * Performance on most platforms is very sensitive to placement of
     * instances of both WorkQueues and their arrays -- we absolutely
     * do not want multiple WorkQueue instances or multiple queue
     * arrays sharing cache lines. (It would be best for queue objects
     * and their arrays to share, but there is nothing available to
     * help arrange that).  Unfortunately, because they are recorded
     * in a common array, WorkQueue instances are often moved to be
     * adjacent by garbage collectors. To reduce impact, we use field
     * padding that works OK on common platforms; this effectively
     * trades off slightly slower average field access for the sake of
     * avoiding really bad worst-case access. (Until better JVM
     * support is in place, this padding is dependent on transient
     * properties of JVM field layout rules.) We also take care in
     * allocating, sizing and resizing the array. Non-shared queue
     * arrays are initialized by workers before use. Others are
     * allocated on first use.
     */
    static final class WorkQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.883 -0400", hash_original_field = "286DF847927D1CB2F1C1BB7767534617", hash_generated_field = "863C969D1B956CFE51968F2445AFF604")

        static final int INITIAL_QUEUE_CAPACITY = 1 << 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.884 -0400", hash_original_field = "49E2E5CD81885F68D8AF62F3713ACA9C", hash_generated_field = "205A4F6EDCB0C47022E182DAC7580660")

        static final int MAXIMUM_QUEUE_CAPACITY = 1 << 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.903 -0400", hash_original_field = "71C0AF9A8855A18D8CEED7E5A0A347BB", hash_generated_field = "E1D673985FF3F8FAC5355C138B0EC615")

        private static  sun.misc.Unsafe U;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.903 -0400", hash_original_field = "E2B16DA0DD2B90E7320F7F1EAEFD8AA6", hash_generated_field = "55C1498F41B220E854B6C9BD4611D7EF")

        private static  long QLOCK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.903 -0400", hash_original_field = "3CFF53E9BC4F219A09E37ED9E57FDDC7", hash_generated_field = "56217E0DD027DEF6800960E32975566B")

        private static  int ABASE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.904 -0400", hash_original_field = "7F39A4CD5B41868790DF88BDE6645DC3", hash_generated_field = "04EDD707481EF51802E0CCDAE61FC7EB")

        private static  int ASHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.884 -0400", hash_original_field = "486EDA6F14076C8F4882BBF512C34711", hash_generated_field = "6D3620C2C6758B9F8EDB68BA2BB57951")

        // Heuristic padding to ameliorate unfortunate memory placements
        volatile long pad00, pad01, pad02, pad03, pad04, pad05, pad06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.885 -0400", hash_original_field = "CFBFD2C5E2E26F8CE5AEE6B20558FC7E", hash_generated_field = "CFBFD2C5E2E26F8CE5AEE6B20558FC7E")

        int seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.885 -0400", hash_original_field = "86A6BEB1EA994119F2A123DB11474A5A", hash_generated_field = "6E32761F938EB8228609999731A1F885")

        volatile int eventCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.885 -0400", hash_original_field = "34EBE8CC2AA73C489D077D3D79A94631", hash_generated_field = "34EBE8CC2AA73C489D077D3D79A94631")

        int nextWait;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.886 -0400", hash_original_field = "D925F41209D36A3A9638E6F55EB95FC2", hash_generated_field = "D925F41209D36A3A9638E6F55EB95FC2")

        int hint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.886 -0400", hash_original_field = "F24ED07E759E62CF73A2E7A8BBDE2B36", hash_generated_field = "F24ED07E759E62CF73A2E7A8BBDE2B36")

        int poolIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.886 -0400", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "462D02655D7DD7DF6E5BA12D65851DD2")

         int mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.887 -0400", hash_original_field = "EFE3153FBED0E9B3F76453717FAF77C0", hash_generated_field = "EFE3153FBED0E9B3F76453717FAF77C0")

        int nsteals;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.887 -0400", hash_original_field = "190A0B82B6F2A863FE84F8D37F345C61", hash_generated_field = "C219699CF6D3DA054372F722D7E98609")

        volatile int qlock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.887 -0400", hash_original_field = "E557BC1AC704FEEC83B0EF5D1FA054AB", hash_generated_field = "FBA450FBD52A9DE4FE67D1D3BFCCB540")

        volatile int base;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.887 -0400", hash_original_field = "9620536E5A5D6E12CC93092A5EBB857E", hash_generated_field = "9620536E5A5D6E12CC93092A5EBB857E")

        int top;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.888 -0400", hash_original_field = "DE6E867846ABBFC26713BE3BCAD9DB70", hash_generated_field = "DE6E867846ABBFC26713BE3BCAD9DB70")

        ForkJoinTask<?>[] array;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.888 -0400", hash_original_field = "6D1EBEC5292A0D06AAA30D30D556DA9B", hash_generated_field = "6D1EBEC5292A0D06AAA30D30D556DA9B")

         ForkJoinPool pool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.888 -0400", hash_original_field = "04E73B023907875A4DDF94479634B2CF", hash_generated_field = "04E73B023907875A4DDF94479634B2CF")

         ForkJoinWorkerThread owner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.889 -0400", hash_original_field = "1214EA6A7A46C3515AFBB899A8C356A7", hash_generated_field = "61BEB0EB4C2E958CF25A8F4F2E3B281F")

        volatile Thread parker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.889 -0400", hash_original_field = "BE9EE105807A4820D3B9A110FA17EDD2", hash_generated_field = "7BDC1155CEB043DA6E2F4A0444D2C0E5")

        volatile ForkJoinTask<?> currentJoin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.890 -0400", hash_original_field = "A0011BCB9305815D36D99BAACF8EA98D", hash_generated_field = "A0011BCB9305815D36D99BAACF8EA98D")

        ForkJoinTask<?> currentSteal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.890 -0400", hash_original_field = "DA09CDCE49A78C4AC01C65A3624B5DB3", hash_generated_field = "A9AF993CF3BAB463EDD07523A8F5766D")

        volatile Object pad10, pad11, pad12, pad13, pad14, pad15, pad16, pad17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.890 -0400", hash_original_field = "6E1A1E5A823656777FB6784512D7EF0D", hash_generated_field = "CCB249FF3CAE73559D57B8C89DC58EC8")

        volatile Object pad18, pad19, pad1a, pad1b, pad1c, pad1d;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.891 -0400", hash_original_method = "EDD59903E4E57365ADA47820CD83C8BE", hash_generated_method = "FE3DE44A7A861B0774C4D9B051EBC911")
        
WorkQueue(ForkJoinPool pool, ForkJoinWorkerThread owner, int mode,
                  int seed) {
            this.pool = pool;
            this.owner = owner;
            this.mode = mode;
            this.seed = seed;
            // Place indices in the center of array (that is not yet allocated)
            base = top = INITIAL_QUEUE_CAPACITY >>> 1;
        }

        /**
         * Returns the approximate number of tasks in the queue.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.891 -0400", hash_original_method = "7914D223A90CF80005DE632C2F134CA8", hash_generated_method = "96509DF67FABE18FE7910F4EF71C370A")
        
final int queueSize() {
            int n = base - top;       // non-owner callers must read base first
            return (n >= 0) ? 0 : -n; // ignore transient negative
        }

       /**
         * Provides a more accurate estimate of whether this queue has
         * any tasks than does queueSize, by checking whether a
         * near-empty queue has at least one unclaimed task.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.892 -0400", hash_original_method = "A9187A3CDC39C20DFB05E735AD6EA68E", hash_generated_method = "82C614477BC48D71A25A7D1B36400BA8")
        
final boolean isEmpty() {
            ForkJoinTask<?>[] a; int m, s;
            int n = base - (s = top);
            return (n >= 0 ||
                    (n == -1 &&
                     ((a = array) == null ||
                      (m = a.length - 1) < 0 ||
                      U.getObject
                      (a, (long)((m & (s - 1)) << ASHIFT) + ABASE) == null)));
        }

        /**
         * Pushes a task. Call only by owner in unshared queues.  (The
         * shared-queue version is embedded in method externalPush.)
         *
         * @param task the task. Caller must ensure non-null.
         * @throws RejectedExecutionException if array cannot be resized
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.892 -0400", hash_original_method = "90E57225575598874B9FFFF14F200A2E", hash_generated_method = "A8B2D4061F4B6E70EE3C6BAAD179F218")
        
final void push(ForkJoinTask<?> task) {
            ForkJoinTask<?>[] a; ForkJoinPool p;
            int s = top, m, n;
            if ((a = array) != null) {    // ignore if queue removed
                int j = (((m = a.length - 1) & s) << ASHIFT) + ABASE;
                U.putOrderedObject(a, j, task);
                if ((n = (top = s + 1) - base) <= 2) {
                    if ((p = pool) != null)
                        p.signalWork(this);
                }
                else if (n >= m)
                    growArray();
            }
        }

       /**
         * Initializes or doubles the capacity of array. Call either
         * by owner or with lock held -- it is OK for base, but not
         * top, to move while resizings are in progress.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.893 -0400", hash_original_method = "5CF85C13B8380769E2AD358FAD5A7E4B", hash_generated_method = "47E9B2929324D2EC928E762E96476042")
        
final ForkJoinTask<?>[] growArray() {
            ForkJoinTask<?>[] oldA = array;
            int size = oldA != null ? oldA.length << 1 : INITIAL_QUEUE_CAPACITY;
            if (size > MAXIMUM_QUEUE_CAPACITY)
                throw new RejectedExecutionException("Queue capacity exceeded");
            int oldMask, t, b;
            ForkJoinTask<?>[] a = array = new ForkJoinTask<?>[size];
            if (oldA != null && (oldMask = oldA.length - 1) >= 0 &&
                (t = top) - (b = base) > 0) {
                int mask = size - 1;
                do {
                    ForkJoinTask<?> x;
                    int oldj = ((b & oldMask) << ASHIFT) + ABASE;
                    int j    = ((b &    mask) << ASHIFT) + ABASE;
                    x = (ForkJoinTask<?>)U.getObjectVolatile(oldA, oldj);
                    if (x != null &&
                        U.compareAndSwapObject(oldA, oldj, x, null))
                        U.putObjectVolatile(a, j, x);
                } while (++b != t);
            }
            return a;
        }

        /**
         * Takes next task, if one exists, in LIFO order.  Call only
         * by owner in unshared queues.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.894 -0400", hash_original_method = "9794469BE8D4779076F438FC67F4D8EF", hash_generated_method = "CCDA7A5DAE01D684FD472C4ECCD4AFFC")
        
final ForkJoinTask<?> pop() {
            ForkJoinTask<?>[] a; ForkJoinTask<?> t; int m;
            if ((a = array) != null && (m = a.length - 1) >= 0) {
                for (int s; (s = top - 1) - base >= 0;) {
                    long j = ((m & s) << ASHIFT) + ABASE;
                    if ((t = (ForkJoinTask<?>)U.getObject(a, j)) == null)
                        break;
                    if (U.compareAndSwapObject(a, j, t, null)) {
                        top = s;
                        return t;
                    }
                }
            }
            return null;
        }

        /**
         * Takes a task in FIFO order if b is base of queue and a task
         * can be claimed without contention. Specialized versions
         * appear in ForkJoinPool methods scan and tryHelpStealer.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.894 -0400", hash_original_method = "4D3D39B1BB8CB65CB10C53B54EB7C37A", hash_generated_method = "9DAEA5EC5F3C088E3669E45EFE204D37")
        
final ForkJoinTask<?> pollAt(int b) {
            ForkJoinTask<?> t; ForkJoinTask<?>[] a;
            if ((a = array) != null) {
                int j = (((a.length - 1) & b) << ASHIFT) + ABASE;
                if ((t = (ForkJoinTask<?>)U.getObjectVolatile(a, j)) != null &&
                    base == b &&
                    U.compareAndSwapObject(a, j, t, null)) {
                    base = b + 1;
                    return t;
                }
            }
            return null;
        }

        /**
         * Takes next task, if one exists, in FIFO order.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.895 -0400", hash_original_method = "1DC538970F899DD518346E80A7EEA2AC", hash_generated_method = "8F54B0CF211B97B2B4693E08602B7CFF")
        
final ForkJoinTask<?> poll() {
            ForkJoinTask<?>[] a; int b; ForkJoinTask<?> t;
            while ((b = base) - top < 0 && (a = array) != null) {
                int j = (((a.length - 1) & b) << ASHIFT) + ABASE;
                t = (ForkJoinTask<?>)U.getObjectVolatile(a, j);
                if (t != null) {
                    if (base == b &&
                        U.compareAndSwapObject(a, j, t, null)) {
                        base = b + 1;
                        return t;
                    }
                }
                else if (base == b) {
                    if (b + 1 == top)
                        break;
                    Thread.yield(); // wait for lagging update (very rare)
                }
            }
            return null;
        }

        /**
         * Takes next task, if one exists, in order specified by mode.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.895 -0400", hash_original_method = "78C5B3350E89ACC69FC582D0CA40768B", hash_generated_method = "D495D37712FD0F5D34FD1D62620A71FD")
        
final ForkJoinTask<?> nextLocalTask() {
            return mode == 0 ? pop() : poll();
        }

        /**
         * Returns next task, if one exists, in order specified by mode.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.896 -0400", hash_original_method = "A3F8C048BFEBF0568F95CF5CD2AD31BD", hash_generated_method = "BC6F3C0367E5E20460C2D0EA8013951A")
        
final ForkJoinTask<?> peek() {
            ForkJoinTask<?>[] a = array; int m;
            if (a == null || (m = a.length - 1) < 0)
                return null;
            int i = mode == 0 ? top - 1 : base;
            int j = ((i & m) << ASHIFT) + ABASE;
            return (ForkJoinTask<?>)U.getObjectVolatile(a, j);
        }

        /**
         * Pops the given task only if it is at the current top.
         * (A shared version is available only via FJP.tryExternalUnpush)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.896 -0400", hash_original_method = "AF41D19FC6C0BA2894472D82D2BBEF1C", hash_generated_method = "E05932CA9E1CCEBBBBFFE1A2B9B6B0BF")
        
final boolean tryUnpush(ForkJoinTask<?> t) {
            ForkJoinTask<?>[] a; int s;
            if ((a = array) != null && (s = top) != base &&
                U.compareAndSwapObject
                (a, (((a.length - 1) & --s) << ASHIFT) + ABASE, t, null)) {
                top = s;
                return true;
            }
            return false;
        }

        /**
         * Removes and cancels all known tasks, ignoring any exceptions.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.897 -0400", hash_original_method = "8A41AD65C2E1A48AA140D484E84169A6", hash_generated_method = "5EFC5716E3C6FA0686FEF9C51C8F2C25")
        
final void cancelAll() {
            ForkJoinTask.cancelIgnoringExceptions(currentJoin);
            ForkJoinTask.cancelIgnoringExceptions(currentSteal);
            for (ForkJoinTask<?> t; (t = poll()) != null; )
                ForkJoinTask.cancelIgnoringExceptions(t);
        }

        /**
         * Computes next value for random probes.  Scans don't require
         * a very high quality generator, but also not a crummy one.
         * Marsaglia xor-shift is cheap and works well enough.  Note:
         * This is manually inlined in its usages in ForkJoinPool to
         * avoid writes inside busy scan loops.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.897 -0400", hash_original_method = "B9DC20239F985A3D5175AFC78A2A1C21", hash_generated_method = "336422B3FC1DA85EE7AAF1275AA19D25")
        
final int nextSeed() {
            int r = seed;
            r ^= r << 13;
            r ^= r >>> 17;
            return seed = r ^= r << 5;
        }

        // Specialized execution methods

        /**
         * Pops and runs tasks until empty.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.898 -0400", hash_original_method = "13EC2AA95F22AD911619016CADD38530", hash_generated_method = "CEB5DC5F1B85AACC846FB1B01F556F79")
        
private void popAndExecAll() {
            // A bit faster than repeated pop calls
            ForkJoinTask<?>[] a; int m, s; long j; ForkJoinTask<?> t;
            while ((a = array) != null && (m = a.length - 1) >= 0 &&
                   (s = top - 1) - base >= 0 &&
                   (t = ((ForkJoinTask<?>)
                         U.getObject(a, j = ((m & s) << ASHIFT) + ABASE)))
                   != null) {
                if (U.compareAndSwapObject(a, j, t, null)) {
                    top = s;
                    t.doExec();
                }
            }
        }

        /**
         * Polls and runs tasks until empty.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.899 -0400", hash_original_method = "39785603783DBCD784A83E22E5CA2615", hash_generated_method = "7E6B6D193648770AC18DAF5FC549E997")
        
private void pollAndExecAll() {
            for (ForkJoinTask<?> t; (t = poll()) != null;)
                t.doExec();
        }

        /**
         * If present, removes from queue and executes the given task,
         * or any other cancelled task. Returns (true) on any CAS
         * or consistency check failure so caller can retry.
         *
         * @return false if no progress can be made, else true
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.900 -0400", hash_original_method = "D92F964987E952EFF77EF454B7D10BD9", hash_generated_method = "F7211ECD2E1C9C62A16528370328FDFD")
        
final boolean tryRemoveAndExec(ForkJoinTask<?> task) {
            boolean stat = true, removed = false, empty = true;
            ForkJoinTask<?>[] a; int m, s, b, n;
            if ((a = array) != null && (m = a.length - 1) >= 0 &&
                (n = (s = top) - (b = base)) > 0) {
                for (ForkJoinTask<?> t;;) {           // traverse from s to b
                    int j = ((--s & m) << ASHIFT) + ABASE;
                    t = (ForkJoinTask<?>)U.getObjectVolatile(a, j);
                    if (t == null)                    // inconsistent length
                        break;
                    else if (t == task) {
                        if (s + 1 == top) {           // pop
                            if (!U.compareAndSwapObject(a, j, task, null))
                                break;
                            top = s;
                            removed = true;
                        }
                        else if (base == b)           // replace with proxy
                            removed = U.compareAndSwapObject(a, j, task,
                                                             new EmptyTask());
                        break;
                    }
                    else if (t.status >= 0)
                        empty = false;
                    else if (s + 1 == top) {          // pop and throw away
                        if (U.compareAndSwapObject(a, j, t, null))
                            top = s;
                        break;
                    }
                    if (--n == 0) {
                        if (!empty && base == b)
                            stat = false;
                        break;
                    }
                }
            }
            if (removed)
                task.doExec();
            return stat;
        }

        /**
         * Polls for and executes the given task or any other task in
         * its CountedCompleter computation.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.901 -0400", hash_original_method = "873FE019EDF0E8D6E564E1B96C30BB12", hash_generated_method = "F409720CE565C144152087ED32EFAFEC")
        
final boolean pollAndExecCC(ForkJoinTask<?> root) {
            ForkJoinTask<?>[] a; int b; Object o;
            outer: while ((b = base) - top < 0 && (a = array) != null) {
                long j = (((a.length - 1) & b) << ASHIFT) + ABASE;
                if ((o = U.getObject(a, j)) == null ||
                    !(o instanceof CountedCompleter))
                    break;
                for (CountedCompleter<?> t = (CountedCompleter<?>)o, r = t;;) {
                    if (r == root) {
                        if (base == b &&
                            U.compareAndSwapObject(a, j, t, null)) {
                            base = b + 1;
                            t.doExec();
                            return true;
                        }
                        else
                            break; // restart
                    }
                    if ((r = r.completer) == null)
                        break outer; // not part of root computation
                }
            }
            return false;
        }

        /**
         * Executes a top-level task and any local tasks remaining
         * after execution.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.901 -0400", hash_original_method = "360F30971790A4A5AC910B84DE8A8410", hash_generated_method = "FEBEEED87AC8949324E0AB8CD6D0A728")
        
final void runTask(ForkJoinTask<?> t) {
            if (t != null) {
                (currentSteal = t).doExec();
                currentSteal = null;
                ++nsteals;
                if (base - top < 0) {       // process remaining local tasks
                    if (mode == 0)
                        popAndExecAll();
                    else
                        pollAndExecAll();
                }
            }
        }

        /**
         * Executes a non-top-level (stolen) task.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.902 -0400", hash_original_method = "B0038814552A9EC143295310A3E701D4", hash_generated_method = "4D7D8D8FEAD280A8749D628474B1D7FE")
        
final void runSubtask(ForkJoinTask<?> t) {
            if (t != null) {
                ForkJoinTask<?> ps = currentSteal;
                (currentSteal = t).doExec();
                currentSteal = ps;
            }
        }

        /**
         * Returns true if owned and not known to be blocked.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.902 -0400", hash_original_method = "45141B78A135D7CA658F71161A179C6E", hash_generated_method = "433FA1963459010D8AEC705B6E3136C5")
        
final boolean isApparentlyUnblocked() {
            Thread wt; Thread.State s;
            return (eventCount >= 0 &&
                    (wt = owner) != null &&
                    (s = wt.getState()) != Thread.State.BLOCKED &&
                    s != Thread.State.WAITING &&
                    s != Thread.State.TIMED_WAITING);
        }
        static {
            try {
                U = sun.misc.Unsafe.getUnsafe();
                Class<?> k = WorkQueue.class;
                Class<?> ak = ForkJoinTask[].class;
                QLOCK = U.objectFieldOffset
                    (k.getDeclaredField("qlock"));
                ABASE = U.arrayBaseOffset(ak);
                int scale = U.arrayIndexScale(ak);
                if ((scale & (scale - 1)) != 0)
                    throw new Error("data type scale not a power of two");
                ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.909 -0400", hash_original_field = "763064307044A7200F6EB21FEE15CB59", hash_generated_field = "67D3B0866C3BECCE3104323581EF0E70")

    /**
     * Creates a new ForkJoinWorkerThread. This factory is used unless
     * overridden in ForkJoinPool constructors.
     */
    public static  ForkJoinWorkerThreadFactory
        defaultForkJoinWorkerThreadFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.910 -0400", hash_original_field = "D1CA15CBC16FBE49EB9CF47926271AD1", hash_generated_field = "A2B30580206890129E0E0B1E6B7A0ED9")

    static  ThreadLocal<Submitter> submitters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.910 -0400", hash_original_field = "D3595EA9B8D88C24F19409DC5DA62A41", hash_generated_field = "3A38CA9A7E16E50910A04FE211BBED58")

    private static  RuntimePermission modifyThreadPermission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.910 -0400", hash_original_field = "FF60F7CDD21443E4AE37800CD9F3B532", hash_generated_field = "11A1A2D7B7D705CEA61B144337738C5D")

    static  ForkJoinPool commonPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.911 -0400", hash_original_field = "82CDCBD1CE9491CF05641CFBC2E9E7A4", hash_generated_field = "EBF73A92AB22198D8A7BCE363B09ABB4")

    static  int commonPoolParallelism;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.911 -0400", hash_original_field = "B965A2FA7F4F035E6320803C8BD544FC", hash_generated_field = "70DEA86632B6A6B18822932F87F6081A")

    private static int poolNumberSequence;

    /**
     * Returns the next sequence number. We don't expect this to
     * ever contend, so use simple builtin sync.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.911 -0400", hash_original_method = "448D54D778219EE6A58618CFA3DDD1F5", hash_generated_method = "7460A489B012383F37D3097CC199D9A5")
    
private static final synchronized int nextPoolId() {
        return ++poolNumberSequence;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.912 -0400", hash_original_field = "D61183B6AB37F2D1E49F613C82BE4048", hash_generated_field = "501535C299BBF14B2852D72CC3FFAF0A")

    /**
     * Initial timeout value (in nanoseconds) for the thread
     * triggering quiescence to park waiting for new work. On timeout,
     * the thread will instead try to shrink the number of
     * workers. The value should be large enough to avoid overly
     * aggressive shrinkage during most transient stalls (long GCs
     * etc).
     */
    private static final long IDLE_TIMEOUT      = 2000L * 1000L * 1000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.912 -0400", hash_original_field = "AE615F760A16E0F4A5A6F85CFD6C77C4", hash_generated_field = "253E4355BFA7F6AE6F26F5E0A230E79A")

    /**
     * Timeout value when there are more threads than parallelism level
     */
    private static final long FAST_IDLE_TIMEOUT =  200L * 1000L * 1000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.913 -0400", hash_original_field = "3F25D855AE6A4BAA80BADEEF4BD2DBB9", hash_generated_field = "276CE91550FE15CA8FDB3AE9E8223F92")

    private static final long TIMEOUT_SLOP = 2000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.913 -0400", hash_original_field = "25D8F4061B10FC1868CDC76152194C44", hash_generated_field = "CF14348137ED4A64307777C2C45534F1")

    /**
     * The maximum stolen->joining link depth allowed in method
     * tryHelpStealer.  Must be a power of two.  Depths for legitimate
     * chains are unbounded, but we use a fixed constant to avoid
     * (otherwise unchecked) cycles and to bound staleness of
     * traversal parameters at the expense of sometimes blocking when
     * we could be helping.
     */
    private static final int MAX_HELP = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.914 -0400", hash_original_field = "490BA1E60B4F204A5BCF134AECBF8B2D", hash_generated_field = "05B6AF4B46550C725DFAA8394540DA53")

    private static final int SEED_INCREMENT = 0x61c88647;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.914 -0400", hash_original_field = "8855A60D60F1E2C2DEF71F3C8F8C14D3", hash_generated_field = "B64D32205E33C6E5632EE7A727B66C87")

    // bit positions/shifts for fields
    private static final int  AC_SHIFT   = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.915 -0400", hash_original_field = "833E4A2426219EF5394EAE7EFAF2B1E1", hash_generated_field = "57B62FED0AC6EF1CB0C7EE3D8E5F175B")

    private static final int  TC_SHIFT   = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.915 -0400", hash_original_field = "7F03FFA7B92980A339BE16F2F63B7C36", hash_generated_field = "085561965AB01CA7816E22108F825777")

    private static final int  ST_SHIFT   = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.915 -0400", hash_original_field = "AA91F988BC8C9E33C3CB603F6CA2465B", hash_generated_field = "25D9C805740CB7B48BBDC7DCDEB035A1")

    private static final int  EC_SHIFT   = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.916 -0400", hash_original_field = "98F4D9695321EF68E2FFCD01A6412800", hash_generated_field = "C05DFF12AAD284EF8F980D82A60B456D")

    private static final int  SMASK      = 0xffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.916 -0400", hash_original_field = "496EED2B5F9962632B900E99B4834004", hash_generated_field = "A6116366F64B1E9F7BBB732321BE5899")

    private static final int  MAX_CAP    = 0x7fff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.916 -0400", hash_original_field = "A7A26EC52D1EC3BE82F34D591B23F793", hash_generated_field = "C793D9D8347A89C8DCA3249E829B4069")

    private static final int  EVENMASK   = 0xfffe;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.917 -0400", hash_original_field = "257B2B26BB9525B87D47EDF2C5BF089D", hash_generated_field = "5C9F0D3DFE09F7EC90E9D907971C4372")

    private static final int  SQMASK     = 0x007e;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.917 -0400", hash_original_field = "FA04115860F25CC6B33C24F1EF4B5B5E", hash_generated_field = "02A59D00EE871120636459F4AA3739AC")

    private static final int  SHORT_SIGN = 1 << 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.918 -0400", hash_original_field = "B83675F1936C79520B581F5CEBDD140D", hash_generated_field = "802133F3404BF94814AFECACFE19F146")

    private static final int  INT_SIGN   = 1 << 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.918 -0400", hash_original_field = "79B32179C596CE99CDAC2C208D9C2CCA", hash_generated_field = "2DBD52E0A886A9A6321BA06E3D659E1D")

    private static final long STOP_BIT   = 0x0001L << ST_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.918 -0400", hash_original_field = "CDC0A3B41F9A1E0F7045C47C65316A63", hash_generated_field = "FCE8F7B906BF5394E153ECC57646ECDE")

    private static final long AC_MASK    = ((long)SMASK) << AC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.919 -0400", hash_original_field = "28742BE6F43C56A33A4A797E40AD3FCC", hash_generated_field = "3FB594675681E8DCE3FB2F4A36E31060")

    private static final long TC_MASK    = ((long)SMASK) << TC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.919 -0400", hash_original_field = "16112F1F6485EBFED840B9342E4658F1", hash_generated_field = "09512A5B560CB6C055CEB62B50B05DCE")

    private static final long TC_UNIT    = 1L << TC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.919 -0400", hash_original_field = "B87EB8C15515C11F6D643049FDC79942", hash_generated_field = "507061AFD3358BB52D3CDB8AEBF8CCE7")

    private static final long AC_UNIT    = 1L << AC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.920 -0400", hash_original_field = "CEB7CDBA14634AB168B216EC678BE476", hash_generated_field = "836FA0717C4F56E53E08E4F707F99C18")

    private static final int  UAC_SHIFT  = AC_SHIFT - 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.920 -0400", hash_original_field = "B995477F75F79F87F4ADD4EFF603C083", hash_generated_field = "B98A941B9667884F440957F1768FA669")

    private static final int  UTC_SHIFT  = TC_SHIFT - 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.921 -0400", hash_original_field = "1C072C41496B6D324E21BA6189562B08", hash_generated_field = "44802BC0286434A7FEC06879DA7B9A5C")

    private static final int  UAC_MASK   = SMASK << UAC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.921 -0400", hash_original_field = "9FCE49889BEA6E6023B91645DC8EFB70", hash_generated_field = "50DD9AB3B5313C12683E82D954929FF9")

    private static final int  UTC_MASK   = SMASK << UTC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.921 -0400", hash_original_field = "231E852B294A8BD54C014688B2E8DCC5", hash_generated_field = "E589C4B29064E7C64C20F5BAE82E35D2")

    private static final int  UAC_UNIT   = 1 << UAC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.922 -0400", hash_original_field = "A42800E399CEBEE3A0EC575E00DFCAAE", hash_generated_field = "2412A5308B4D8B881105A689C8E5729E")

    private static final int  UTC_UNIT   = 1 << UTC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.922 -0400", hash_original_field = "E58F7B516A56FF0BC4288D02DAC262DC", hash_generated_field = "1D4BF6B3C1EAF8451F3CBAF98B8F18BA")

    private static final int E_MASK      = 0x7fffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.922 -0400", hash_original_field = "D0CCACD7E521B7D74F20FF6C5D1E483C", hash_generated_field = "F0FFEA86E8868CEA658D7DA25320E405")

    private static final int E_SEQ       = 1 << EC_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.923 -0400", hash_original_field = "EA59FF62154B3AB0B8A37EB8A6529AD1", hash_generated_field = "9C244FF297D9D8221316B7966E648D5D")

    private static final int SHUTDOWN    = 1 << 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.923 -0400", hash_original_field = "AAC75C028119245B62794C369CF2735A", hash_generated_field = "C5E58574E21E698C653C349919950246")

    private static final int PL_LOCK     = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.924 -0400", hash_original_field = "DDED09F667D309723B2A668EA809D76A", hash_generated_field = "C931CDED46945B3026C2F1A1D50D9693")

    private static final int PL_SIGNAL   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.924 -0400", hash_original_field = "CEB5008A69A6498BC14CC553F4F19C0A", hash_generated_field = "EC5A35A7591EBA4A8B573F8E2BFB2DD0")

    private static final int PL_SPINS    = 1 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.924 -0400", hash_original_field = "AF07D74F9A61D3A048C039D841054E14", hash_generated_field = "8F525632D93DD35784563F9DAA3C46BC")

    static final int LIFO_QUEUE          =  0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.925 -0400", hash_original_field = "D3540B680E682F7E21C9EE0337CFC63B", hash_generated_field = "4F410C543D16FA2C6397B48449D9A4CD")

    static final int FIFO_QUEUE          =  1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.925 -0400", hash_original_field = "D0B03884678C5EF9B9167A51CA6DC9D5", hash_generated_field = "2A2DDB7B1E89450325F7493705B5673A")

    static final int SHARED_QUEUE        = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.926 -0400", hash_original_field = "9B7EE24E729EAA0411CB75D4EABEDDBC", hash_generated_field = "FA2B4D262F71EE90C809CB69C6365BE5")

    private static final int MIN_SCAN    = 0x1ff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.926 -0400", hash_original_field = "346F04B322D65F325A4E06DAC146E09A", hash_generated_field = "08A29CC795E9F6110B4335A535AD25F5")

    private static final int MAX_SCAN    = 0x1ffff;

    /**
     * Returns a cheap heuristic guide for task partitioning when
     * programmers, frameworks, tools, or languages have little or no
     * idea about task granularity.  In essence by offering this
     * method, we ask users only about tradeoffs in overhead vs
     * expected throughput and its variance, rather than how finely to
     * partition tasks.
     *
     * In a steady state strict (tree-structured) computation, each
     * thread makes available for stealing enough tasks for other
     * threads to remain active. Inductively, if all threads play by
     * the same rules, each thread should make available only a
     * constant number of tasks.
     *
     * The minimum useful constant is just 1. But using a value of 1
     * would require immediate replenishment upon each steal to
     * maintain enough tasks, which is infeasible.  Further,
     * partitionings/granularities of offered tasks should minimize
     * steal rates, which in general means that threads nearer the top
     * of computation tree should generate more than those nearer the
     * bottom. In perfect steady state, each thread is at
     * approximately the same level of computation tree. However,
     * producing extra tasks amortizes the uncertainty of progress and
     * diffusion assumptions.
     *
     * So, users will want to use values larger (but not much larger)
     * than 1 to both smooth over transient shortages and hedge
     * against uneven progress; as traded off against the cost of
     * extra task overhead. We leave the user to pick a threshold
     * value to compare with the results of this call to guide
     * decisions, but recommend values such as 3.
     *
     * When all threads are active, it is on average OK to estimate
     * surplus strictly locally. In steady-state, if one thread is
     * maintaining say 2 surplus tasks, then so are others. So we can
     * just use estimated queue length.  However, this strategy alone
     * leads to serious mis-estimates in some non-steady-state
     * conditions (ramp-up, ramp-down, other stalls). We can detect
     * many of these by further considering the number of "idle"
     * threads, that are known to have zero queued tasks, so
     * compensate by a factor of (#idle/#active) threads.
     *
     * Note: The approximation of #busy workers as #active workers is
     * not very good under current signalling scheme, and should be
     * improved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.955 -0400", hash_original_method = "BB3B6ECFF3B17EA1B33F165723AE6517", hash_generated_method = "5BC85C941B9EE71136E7C99C39AA6205")
    
static int getSurplusQueuedTaskCount() {
        Thread t; ForkJoinWorkerThread wt; ForkJoinPool pool; WorkQueue q;
        if (((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)) {
            int p = (pool = (wt = (ForkJoinWorkerThread)t).pool).config & SMASK;
            int n = (q = wt.workQueue).top - q.base;
            int a = (int)(pool.ctl >> AC_SHIFT) + p;
            return n - (a > (p >>>= 1) ? 0 :
                        a > (p >>>= 1) ? 1 :
                        a > (p >>>= 1) ? 2 :
                        a > (p >>>= 1) ? 4 :
                        8);
        }
        return 0;
    }

    // external operations on common pool

    /**
     * Returns common pool queue for a thread that has submitted at
     * least one task.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.959 -0400", hash_original_method = "1C1FFDC1B0A44D074A772FCA51CC9C09", hash_generated_method = "F9726986CC3EBE47BC44FAA8B4A50A18")
    
static WorkQueue commonSubmitterQueue() {
        ForkJoinPool p; WorkQueue[] ws; int m; Submitter z;
        return ((z = submitters.get()) != null &&
                (p = commonPool) != null &&
                (ws = p.workQueues) != null &&
                (m = ws.length - 1) >= 0) ?
            ws[m & z.seed & SQMASK] : null;
    }

    /**
     * Tries to pop the given task from submitter's queue in common pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.959 -0400", hash_original_method = "067EBF50E697A80439E173C89DBCEDC2", hash_generated_method = "24B6BB8152D9D97428EB674C75822991")
    
static boolean tryExternalUnpush(ForkJoinTask<?> t) {
        ForkJoinPool p; WorkQueue[] ws; WorkQueue q; Submitter z;
        ForkJoinTask<?>[] a;  int m, s;
        if (t != null &&
            (z = submitters.get()) != null &&
            (p = commonPool) != null &&
            (ws = p.workQueues) != null &&
            (m = ws.length - 1) >= 0 &&
            (q = ws[m & z.seed & SQMASK]) != null &&
            (s = q.top) != q.base &&
            (a = q.array) != null) {
            long j = (((a.length - 1) & (s - 1)) << ASHIFT) + ABASE;
            if (U.getObject(a, j) == t &&
                U.compareAndSwapInt(q, QLOCK, 0, 1)) {
                if (q.array == a && q.top == s && // recheck
                    U.compareAndSwapObject(a, j, t, null)) {
                    q.top = s - 1;
                    q.qlock = 0;
                    return true;
                }
                q.qlock = 0;
            }
        }
        return false;
    }

    /**
     * Tries to help execute or signal availability of the given task
     * from submitter's queue in common pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.962 -0400", hash_original_method = "0349CBBB3880FF27B30068B9E84B580F", hash_generated_method = "4C20A232A6F821603CD1FE0715E9D852")
    
static void externalHelpJoin(ForkJoinTask<?> t) {
        // Some hard-to-avoid overlap with tryExternalUnpush
        ForkJoinPool p; WorkQueue[] ws; WorkQueue q, w; Submitter z;
        ForkJoinTask<?>[] a;  int m, s, n;
        if (t != null &&
            (z = submitters.get()) != null &&
            (p = commonPool) != null &&
            (ws = p.workQueues) != null &&
            (m = ws.length - 1) >= 0 &&
            (q = ws[m & z.seed & SQMASK]) != null &&
            (a = q.array) != null) {
            int am = a.length - 1;
            if ((s = q.top) != q.base) {
                long j = ((am & (s - 1)) << ASHIFT) + ABASE;
                if (U.getObject(a, j) == t &&
                    U.compareAndSwapInt(q, QLOCK, 0, 1)) {
                    if (q.array == a && q.top == s &&
                        U.compareAndSwapObject(a, j, t, null)) {
                        q.top = s - 1;
                        q.qlock = 0;
                        t.doExec();
                    }
                    else
                        q.qlock = 0;
                }
            }
            if (t.status >= 0) {
                if (t instanceof CountedCompleter)
                    p.externalHelpComplete(q, t);
                else
                    p.helpSignal(t, q.poolIndex);
            }
        }
    }

    /**
     * Restricted version of helpQuiescePool for external callers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.962 -0400", hash_original_method = "BEFB0ABCFE5DC7F3B13CFCF627ADD6BB", hash_generated_method = "6F3DE37B5F9CDC0D311DA07F58613449")
    
static void externalHelpQuiescePool() {
        ForkJoinPool p; ForkJoinTask<?> t; WorkQueue q; int b;
        if ((p = commonPool) != null &&
            (q = p.findNonEmptyStealQueue(1)) != null &&
            (b = q.base) - q.top < 0 &&
            (t = q.pollAt(b)) != null)
            t.doExec();
    }

    /**
     * Returns the common pool instance.
     *
     * @return the common pool instance
     * @since 1.8
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.965 -0400", hash_original_method = "6B7AE7E95DC77B2045403E390238A0EB", hash_generated_method = "54AE5111BF89A5ADD7B460C76BC35333")
    
public static ForkJoinPool commonPool() {
        // assert commonPool != null : "static init error";
        return commonPool;
    }

    /**
     * Returns the targeted parallelism level of the common pool.
     *
     * @return the targeted parallelism level of the common pool
     * @since 1.8
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.970 -0400", hash_original_method = "C7F41D0F8829EB85C79C03368F57D94A", hash_generated_method = "C933A2AD975E8B7D6281B4E7D12CFDFD")
    
public static int getCommonPoolParallelism() {
        return commonPoolParallelism;
    }

    /**
     * Blocks in accord with the given blocker.  If the current thread
     * is a {@link ForkJoinWorkerThread}, this method possibly
     * arranges for a spare thread to be activated if necessary to
     * ensure sufficient parallelism while the current thread is blocked.
     *
     * <p>If the caller is not a {@link ForkJoinTask}, this method is
     * behaviorally equivalent to
     *  <pre> {@code
     * while (!blocker.isReleasable())
     *   if (blocker.block())
     *     return;
     * }</pre>
     *
     * If the caller is a {@code ForkJoinTask}, then the pool may
     * first be expanded to ensure parallelism, and later adjusted.
     *
     * @param blocker the blocker
     * @throws InterruptedException if blocker.block did so
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.980 -0400", hash_original_method = "61F7444F0EDA72892787FBAB932F5283", hash_generated_method = "AAC6986E5ED9143AEBD55DAFC857555E")
    
public static void managedBlock(ManagedBlocker blocker)
        throws InterruptedException {
        Thread t = Thread.currentThread();
        if (t instanceof ForkJoinWorkerThread) {
            ForkJoinPool p = ((ForkJoinWorkerThread)t).pool;
            while (!blocker.isReleasable()) { // variant of helpSignal
                WorkQueue[] ws; WorkQueue q; int m, u;
                if ((ws = p.workQueues) != null && (m = ws.length - 1) >= 0) {
                    for (int i = 0; i <= m; ++i) {
                        if (blocker.isReleasable())
                            return;
                        if ((q = ws[i]) != null && q.base - q.top < 0) {
                            p.signalWork(q);
                            if ((u = (int)(p.ctl >>> 32)) >= 0 ||
                                (u >> UAC_SHIFT) >= 0)
                                break;
                        }
                    }
                }
                if (p.tryCompensate()) {
                    try {
                        do {} while (!blocker.isReleasable() &&
                                     !blocker.block());
                    } finally {
                        p.incrementActiveCount();
                    }
                    break;
                }
            }
        }
        else {
            do {} while (!blocker.isReleasable() &&
                         !blocker.block());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.982 -0400", hash_original_field = "71C0AF9A8855A18D8CEED7E5A0A347BB", hash_generated_field = "E1D673985FF3F8FAC5355C138B0EC615")

    private static  sun.misc.Unsafe U;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.982 -0400", hash_original_field = "F55AD324590E31AFD96FC4ED69577590", hash_generated_field = "3654586848598005021ACE6AD11C6443")

    private static  long CTL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.982 -0400", hash_original_field = "DCF844DC1D595B5A36B2B3D3B36F270B", hash_generated_field = "0A7F701D05318A3070C61E6B2F950259")

    private static  long PARKBLOCKER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.983 -0400", hash_original_field = "3CFF53E9BC4F219A09E37ED9E57FDDC7", hash_generated_field = "56217E0DD027DEF6800960E32975566B")

    private static  int ABASE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.983 -0400", hash_original_field = "7F39A4CD5B41868790DF88BDE6645DC3", hash_generated_field = "04EDD707481EF51802E0CCDAE61FC7EB")

    private static  int ASHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.983 -0400", hash_original_field = "198E43C7EAAED685824597DA027194AF", hash_generated_field = "A858CA85B69E0A613DBBFD2EF6EC824E")

    private static  long STEALCOUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.984 -0400", hash_original_field = "107D39B04D766C3E29F956E8345B78E6", hash_generated_field = "2208634C888BB97B2076C7C440091959")

    private static  long PLOCK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.984 -0400", hash_original_field = "9B229296F768844C2662BC10C068DFE0", hash_generated_field = "D26937368BB81798806596119F137B25")

    private static  long INDEXSEED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.984 -0400", hash_original_field = "E2B16DA0DD2B90E7320F7F1EAEFD8AA6", hash_generated_field = "55C1498F41B220E854B6C9BD4611D7EF")

    private static  long QLOCK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.926 -0400", hash_original_field = "486EDA6F14076C8F4882BBF512C34711", hash_generated_field = "83A57DBD186EAC159D18D96EEDC8005E")

    // Instance fields

    /*
     * Field layout of this class tends to matter more than one would
     * like. Runtime layout order is only loosely related to
     * declaration order and may differ across JVMs, but the following
     * empirically works OK on current JVMs.
     */

    // Heuristic padding to ameliorate unfortunate memory placements
    volatile long pad00, pad01, pad02, pad03, pad04, pad05, pad06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.927 -0400", hash_original_field = "1AC72445B7EDB69BF3B170891DC34129", hash_generated_field = "5580A2711623D982506A13FEFF4768DB")

    volatile long stealCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.927 -0400", hash_original_field = "80711E2281D7B4FC1922AE30BF7FBDB9", hash_generated_field = "3C842F1DC0BFD02458240EE2B701C638")

    volatile long ctl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.927 -0400", hash_original_field = "E6C229E3DE131089CFF7390DFEC310FE", hash_generated_field = "642BF0CCB069580885FAB46FC5A4E353")

    volatile int plock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.928 -0400", hash_original_field = "DDC2F8EA1C773D01D50EDA78A127559B", hash_generated_field = "0B6D0C06D6409CA0DF2CA04AA82057E7")

    volatile int indexSeed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.928 -0400", hash_original_field = "BC9A593C78922072B6EF6D68C29448A8", hash_generated_field = "BC9A593C78922072B6EF6D68C29448A8")

     int config;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.928 -0400", hash_original_field = "CB2550DA9B355002E3B70EB3A9A7A2D6", hash_generated_field = "CB2550DA9B355002E3B70EB3A9A7A2D6")

    WorkQueue[] workQueues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.929 -0400", hash_original_field = "AFC3692BAFF4252F34D281C883E951FF", hash_generated_field = "AFC3692BAFF4252F34D281C883E951FF")

     ForkJoinWorkerThreadFactory factory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.929 -0400", hash_original_field = "CC5567B3A472ACDD4FCBC142E1875807", hash_generated_field = "CC5567B3A472ACDD4FCBC142E1875807")

     Thread.UncaughtExceptionHandler ueh;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.929 -0400", hash_original_field = "650D3096BE0D42924A28C1C3B242296D", hash_generated_field = "650D3096BE0D42924A28C1C3B242296D")

     String workerNamePrefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.930 -0400", hash_original_field = "DA09CDCE49A78C4AC01C65A3624B5DB3", hash_generated_field = "A9AF993CF3BAB463EDD07523A8F5766D")

    volatile Object pad10, pad11, pad12, pad13, pad14, pad15, pad16, pad17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.930 -0400", hash_original_field = "E2E3FD7D277B40A24F93879E591E8389", hash_generated_field = "DC82C42DC19EEC16B823A65AE70C6B05")

    volatile Object pad18, pad19, pad1a, pad1b;

    // Exported methods

    // Constructors

    /**
     * Creates a {@code ForkJoinPool} with parallelism equal to {@link
     * java.lang.Runtime#availableProcessors}, using the {@linkplain
     * #defaultForkJoinWorkerThreadFactory default thread factory},
     * no UncaughtExceptionHandler, and non-async LIFO processing mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.963 -0400", hash_original_method = "39BBD151CE06FA05B192682311DCAE55", hash_generated_method = "411A22E82907713C0683EBEA869DEEA7")
    
public ForkJoinPool() {
        this(Math.min(MAX_CAP, Runtime.getRuntime().availableProcessors()),
             defaultForkJoinWorkerThreadFactory, null, false);
    }

    /**
     * Creates a {@code ForkJoinPool} with the indicated parallelism
     * level, the {@linkplain
     * #defaultForkJoinWorkerThreadFactory default thread factory},
     * no UncaughtExceptionHandler, and non-async LIFO processing mode.
     *
     * @param parallelism the parallelism level
     * @throws IllegalArgumentException if parallelism less than or
     *         equal to zero, or greater than implementation limit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.963 -0400", hash_original_method = "FCFB84EB41616087EEA05CA157A95DBE", hash_generated_method = "B693603C6EDC6664181F3345C77C4CFA")
    
public ForkJoinPool(int parallelism) {
        this(parallelism, defaultForkJoinWorkerThreadFactory, null, false);
    }

    /**
     * Creates a {@code ForkJoinPool} with the given parameters.
     *
     * @param parallelism the parallelism level. For default value,
     * use {@link java.lang.Runtime#availableProcessors}.
     * @param factory the factory for creating new threads. For default value,
     * use {@link #defaultForkJoinWorkerThreadFactory}.
     * @param handler the handler for internal worker threads that
     * terminate due to unrecoverable errors encountered while executing
     * tasks. For default value, use {@code null}.
     * @param asyncMode if true,
     * establishes local first-in-first-out scheduling mode for forked
     * tasks that are never joined. This mode may be more appropriate
     * than default locally stack-based mode in applications in which
     * worker threads only process event-style asynchronous tasks.
     * For default value, use {@code false}.
     * @throws IllegalArgumentException if parallelism less than or
     *         equal to zero, or greater than implementation limit
     * @throws NullPointerException if the factory is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.964 -0400", hash_original_method = "7D79EAF54523EFC00F79261DB23E5CE8", hash_generated_method = "ED14023B3D67F8495ED4032496C1627C")
    
public ForkJoinPool(int parallelism,
                        ForkJoinWorkerThreadFactory factory,
                        Thread.UncaughtExceptionHandler handler,
                        boolean asyncMode) {
        checkPermission();
        if (factory == null)
            throw new NullPointerException();
        if (parallelism <= 0 || parallelism > MAX_CAP)
            throw new IllegalArgumentException();
        this.factory = factory;
        this.ueh = handler;
        this.config = parallelism | (asyncMode ? (FIFO_QUEUE << 16) : 0);
        long np = (long)(-parallelism); // offset ctl counts
        this.ctl = ((np << AC_SHIFT) & AC_MASK) | ((np << TC_SHIFT) & TC_MASK);
        int pn = nextPoolId();
        StringBuilder sb = new StringBuilder("ForkJoinPool-");
        sb.append(Integer.toString(pn));
        sb.append("-worker-");
        this.workerNamePrefix = sb.toString();
    }

    /**
     * Constructor for common pool, suitable only for static initialization.
     * Basically the same as above, but uses smallest possible initial footprint.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.964 -0400", hash_original_method = "75226CFD441CB6A4015DD162509D015B", hash_generated_method = "75226CFD441CB6A4015DD162509D015B")
    
ForkJoinPool(int parallelism, long ctl,
                 ForkJoinWorkerThreadFactory factory,
                 Thread.UncaughtExceptionHandler handler) {
        this.config = parallelism;
        this.ctl = ctl;
        this.factory = factory;
        this.ueh = handler;
        this.workerNamePrefix = "ForkJoinPool.commonPool-worker-";
    }

    /**
     * Acquires the plock lock to protect worker array and related
     * updates. This method is called only if an initial CAS on plock
     * fails. This acts as a spinlock for normal cases, but falls back
     * to builtin monitor to block when (rarely) needed. This would be
     * a terrible idea for a highly contended lock, but works fine as
     * a more conservative alternative to a pure spinlock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.931 -0400", hash_original_method = "F3C59968943CBD731FF7A2C5D7B5D119", hash_generated_method = "B870B803E0FB9087478D746C6F0756BE")
    
private int acquirePlock() {
        int spins = PL_SPINS, r = 0, ps, nps;
        for (;;) {
            if (((ps = plock) & PL_LOCK) == 0 &&
                U.compareAndSwapInt(this, PLOCK, ps, nps = ps + PL_LOCK))
                return nps;
            else if (r == 0) { // randomize spins if possible
                Thread t = Thread.currentThread(); WorkQueue w; Submitter z;
                if ((t instanceof ForkJoinWorkerThread) &&
                    (w = ((ForkJoinWorkerThread)t).workQueue) != null)
                    r = w.seed;
                else if ((z = submitters.get()) != null)
                    r = z.seed;
                else
                    r = 1;
            }
            else if (spins >= 0) {
                r ^= r << 1; r ^= r >>> 3; r ^= r << 10; // xorshift
                if (r >= 0)
                    --spins;
            }
            else if (U.compareAndSwapInt(this, PLOCK, ps, ps | PL_SIGNAL)) {
                synchronized (this) {
                    if ((plock & PL_SIGNAL) != 0) {
                        try {
                            wait();
                        } catch (InterruptedException ie) {
                            try {
                                Thread.currentThread().interrupt();
                            } catch (SecurityException ignore) {
                            }
                        }
                    }
                    else
                        notifyAll();
                }
            }
        }
    }

    /**
     * Unlocks and signals any thread waiting for plock. Called only
     * when CAS of seq value for unlock fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.932 -0400", hash_original_method = "7252C0CD8B0B2E34402EE5124A334449", hash_generated_method = "5642796F91C0FCFD77AD4324DDDD7D76")
    
private void releasePlock(int ps) {
        plock = ps;
        synchronized (this) { notifyAll(); }
    }

    /**
     * Performs secondary initialization, called when plock is zero.
     * Creates workQueue array and sets plock to a valid value.  The
     * lock body must be exception-free (so no try/finally) so we
     * optimistically allocate new array outside the lock and throw
     * away if (very rarely) not needed. (A similar tactic is used in
     * fullExternalPush.)  Because the plock seq value can eventually
     * wrap around zero, this method harmlessly fails to reinitialize
     * if workQueues exists, while still advancing plock.
     *
     * Additionally tries to create the first worker.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.932 -0400", hash_original_method = "9E27514539FEBC48A95BEC4A3CF1EE30", hash_generated_method = "FDC56E800950DA911E1F29FE4360592E")
    
private void initWorkers() {
        WorkQueue[] ws, nws; int ps;
        int p = config & SMASK;        // find power of two table size
        int n = (p > 1) ? p - 1 : 1;   // ensure at least 2 slots
        n |= n >>> 1; n |= n >>> 2; n |= n >>> 4; n |= n >>> 8; n |= n >>> 16;
        n = (n + 1) << 1;
        if ((ws = workQueues) == null || ws.length == 0)
            nws = new WorkQueue[n];
        else
            nws = null;
        if (((ps = plock) & PL_LOCK) != 0 ||
            !U.compareAndSwapInt(this, PLOCK, ps, ps += PL_LOCK))
            ps = acquirePlock();
        if (((ws = workQueues) == null || ws.length == 0) && nws != null)
            workQueues = nws;
        int nps = (ps & SHUTDOWN) | ((ps + PL_LOCK) & ~SHUTDOWN);
        if (!U.compareAndSwapInt(this, PLOCK, ps, nps))
            releasePlock(nps);
        tryAddWorker();
    }

    /**
     * Tries to create and start one worker if fewer than target
     * parallelism level exist. Adjusts counts etc on failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.933 -0400", hash_original_method = "7FB52E0F72F41F02F0EA84690C6904EB", hash_generated_method = "F128E0807CE01A0E9DA599712BF4B3C5")
    
private void tryAddWorker() {
        long c; int u;
        while ((u = (int)((c = ctl) >>> 32)) < 0 &&
               (u & SHORT_SIGN) != 0 && (int)c == 0) {
            long nc = (long)(((u + UTC_UNIT) & UTC_MASK) |
                             ((u + UAC_UNIT) & UAC_MASK)) << 32;
            if (U.compareAndSwapLong(this, CTL, c, nc)) {
                ForkJoinWorkerThreadFactory fac;
                Throwable ex = null;
                ForkJoinWorkerThread wt = null;
                try {
                    if ((fac = factory) != null &&
                        (wt = fac.newThread(this)) != null) {
                        wt.start();
                        break;
                    }
                } catch (Throwable e) {
                    ex = e;
                }
                deregisterWorker(wt, ex);
                break;
            }
        }
    }

    //  Registering and deregistering workers

    /**
     * Callback from ForkJoinWorkerThread to establish and record its
     * WorkQueue. To avoid scanning bias due to packing entries in
     * front of the workQueues array, we treat the array as a simple
     * power-of-two hash table using per-thread seed as hash,
     * expanding as needed.
     *
     * @param wt the worker thread
     * @return the worker's queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.934 -0400", hash_original_method = "466A85D6357C046FA6ECFB038D3A1C61", hash_generated_method = "EAB1AF25C01E3E452EB8B2F9EE126820")
    
final WorkQueue registerWorker(ForkJoinWorkerThread wt) {
        Thread.UncaughtExceptionHandler handler; WorkQueue[] ws; int s, ps;
        wt.setDaemon(true);
        if ((handler = ueh) != null)
            wt.setUncaughtExceptionHandler(handler);
        do {} while (!U.compareAndSwapInt(this, INDEXSEED, s = indexSeed,
                                          s += SEED_INCREMENT) ||
                     s == 0); // skip 0
        WorkQueue w = new WorkQueue(this, wt, config >>> 16, s);
        if (((ps = plock) & PL_LOCK) != 0 ||
            !U.compareAndSwapInt(this, PLOCK, ps, ps += PL_LOCK))
            ps = acquirePlock();
        int nps = (ps & SHUTDOWN) | ((ps + PL_LOCK) & ~SHUTDOWN);
        try {
            if ((ws = workQueues) != null) {    // skip if shutting down
                int n = ws.length, m = n - 1;
                int r = (s << 1) | 1;           // use odd-numbered indices
                if (ws[r &= m] != null) {       // collision
                    int probes = 0;             // step by approx half size
                    int step = (n <= 4) ? 2 : ((n >>> 1) & EVENMASK) + 2;
                    while (ws[r = (r + step) & m] != null) {
                        if (++probes >= n) {
                            workQueues = ws = Arrays.copyOf(ws, n <<= 1);
                            m = n - 1;
                            probes = 0;
                        }
                    }
                }
                w.eventCount = w.poolIndex = r; // volatile write orders
                ws[r] = w;
            }
        } finally {
            if (!U.compareAndSwapInt(this, PLOCK, ps, nps))
                releasePlock(nps);
        }
        wt.setName(workerNamePrefix.concat(Integer.toString(w.poolIndex)));
        return w;
    }

    /**
     * Final callback from terminating worker, as well as upon failure
     * to construct or start a worker.  Removes record of worker from
     * array, and adjusts counts. If pool is shutting down, tries to
     * complete termination.
     *
     * @param wt the worker thread or null if construction failed
     * @param ex the exception causing failure, or null if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.936 -0400", hash_original_method = "B270AAF1753B4B046BCA2C02D2D7B885", hash_generated_method = "C3263A2C5FCBA412E762BC06B0243B73")
    
final void deregisterWorker(ForkJoinWorkerThread wt, Throwable ex) {
        WorkQueue w = null;
        if (wt != null && (w = wt.workQueue) != null) {
            int ps;
            w.qlock = -1;                // ensure set
            long ns = w.nsteals, sc;     // collect steal count
            do {} while (!U.compareAndSwapLong(this, STEALCOUNT,
                                               sc = stealCount, sc + ns));
            if (((ps = plock) & PL_LOCK) != 0 ||
                !U.compareAndSwapInt(this, PLOCK, ps, ps += PL_LOCK))
                ps = acquirePlock();
            int nps = (ps & SHUTDOWN) | ((ps + PL_LOCK) & ~SHUTDOWN);
            try {
                int idx = w.poolIndex;
                WorkQueue[] ws = workQueues;
                if (ws != null && idx >= 0 && idx < ws.length && ws[idx] == w)
                    ws[idx] = null;
            } finally {
                if (!U.compareAndSwapInt(this, PLOCK, ps, nps))
                    releasePlock(nps);
            }
        }

        long c;                          // adjust ctl counts
        do {} while (!U.compareAndSwapLong
                     (this, CTL, c = ctl, (((c - AC_UNIT) & AC_MASK) |
                                           ((c - TC_UNIT) & TC_MASK) |
                                           (c & ~(AC_MASK|TC_MASK)))));

        if (!tryTerminate(false, false) && w != null && w.array != null) {
            w.cancelAll();               // cancel remaining tasks
            WorkQueue[] ws; WorkQueue v; Thread p; int u, i, e;
            while ((u = (int)((c = ctl) >>> 32)) < 0 && (e = (int)c) >= 0) {
                if (e > 0) {             // activate or create replacement
                    if ((ws = workQueues) == null ||
                        (i = e & SMASK) >= ws.length ||
                        (v = ws[i]) != null)
                        break;
                    long nc = (((long)(v.nextWait & E_MASK)) |
                               ((long)(u + UAC_UNIT) << 32));
                    if (v.eventCount != (e | INT_SIGN))
                        break;
                    if (U.compareAndSwapLong(this, CTL, c, nc)) {
                        v.eventCount = (e + E_SEQ) & E_MASK;
                        if ((p = v.parker) != null)
                            U.unpark(p);
                        break;
                    }
                }
                else {
                    if ((short)u < 0)
                        tryAddWorker();
                    break;
                }
            }
        }
        if (ex == null)                     // help clean refs on way out
            ForkJoinTask.helpExpungeStaleExceptions();
        else                                // rethrow
            ForkJoinTask.rethrow(ex);
    }

    // Submissions

    /**
     * Unless shutting down, adds the given task to a submission queue
     * at submitter's current queue index (modulo submission
     * range). Only the most common path is directly handled in this
     * method. All others are relayed to fullExternalPush.
     *
     * @param task the task. Caller must ensure non-null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.937 -0400", hash_original_method = "20C147F6C4886C0748CCBA0B7272FF84", hash_generated_method = "8421D66C873BC8B25DE93C693570390E")
    
final void externalPush(ForkJoinTask<?> task) {
        WorkQueue[] ws; WorkQueue q; Submitter z; int m; ForkJoinTask<?>[] a;
        if ((z = submitters.get()) != null && plock > 0 &&
            (ws = workQueues) != null && (m = (ws.length - 1)) >= 0 &&
            (q = ws[m & z.seed & SQMASK]) != null &&
            U.compareAndSwapInt(q, QLOCK, 0, 1)) { // lock
            int b = q.base, s = q.top, n, an;
            if ((a = q.array) != null && (an = a.length) > (n = s + 1 - b)) {
                int j = (((an - 1) & s) << ASHIFT) + ABASE;
                U.putOrderedObject(a, j, task);
                q.top = s + 1;                     // push on to deque
                q.qlock = 0;
                if (n <= 2)
                    signalWork(q);
                return;
            }
            q.qlock = 0;
        }
        fullExternalPush(task);
    }

    /**
     * Full version of externalPush. This method is called, among
     * other times, upon the first submission of the first task to the
     * pool, so must perform secondary initialization (via
     * initWorkers). It also detects first submission by an external
     * thread by looking up its ThreadLocal, and creates a new shared
     * queue if the one at index if empty or contended. The plock lock
     * body must be exception-free (so no try/finally) so we
     * optimistically allocate new queues outside the lock and throw
     * them away if (very rarely) not needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.938 -0400", hash_original_method = "DCC1C6316DEC8437AAF6FC93BEF20665", hash_generated_method = "4CA1FD1B137A3E4921611E33693E2DCF")
    
private void fullExternalPush(ForkJoinTask<?> task) {
        int r = 0; // random index seed
        for (Submitter z = submitters.get();;) {
            WorkQueue[] ws; WorkQueue q; int ps, m, k;
            if (z == null) {
                if (U.compareAndSwapInt(this, INDEXSEED, r = indexSeed,
                                        r += SEED_INCREMENT) && r != 0)
                    submitters.set(z = new Submitter(r));
            }
            else if (r == 0) {               // move to a different index
                r = z.seed;
                r ^= r << 13;                // same xorshift as WorkQueues
                r ^= r >>> 17;
                z.seed = r ^ (r << 5);
            }
            else if ((ps = plock) < 0)
                throw new RejectedExecutionException();
            else if (ps == 0 || (ws = workQueues) == null ||
                     (m = ws.length - 1) < 0)
                initWorkers();
            else if ((q = ws[k = r & m & SQMASK]) != null) {
                if (q.qlock == 0 && U.compareAndSwapInt(q, QLOCK, 0, 1)) {
                    ForkJoinTask<?>[] a = q.array;
                    int s = q.top;
                    boolean submitted = false;
                    try {                      // locked version of push
                        if ((a != null && a.length > s + 1 - q.base) ||
                            (a = q.growArray()) != null) {   // must presize
                            int j = (((a.length - 1) & s) << ASHIFT) + ABASE;
                            U.putOrderedObject(a, j, task);
                            q.top = s + 1;
                            submitted = true;
                        }
                    } finally {
                        q.qlock = 0;  // unlock
                    }
                    if (submitted) {
                        signalWork(q);
                        return;
                    }
                }
                r = 0; // move on failure
            }
            else if (((ps = plock) & PL_LOCK) == 0) { // create new queue
                q = new WorkQueue(this, null, SHARED_QUEUE, r);
                if (((ps = plock) & PL_LOCK) != 0 ||
                    !U.compareAndSwapInt(this, PLOCK, ps, ps += PL_LOCK))
                    ps = acquirePlock();
                if ((ws = workQueues) != null && k < ws.length && ws[k] == null)
                    ws[k] = q;
                int nps = (ps & SHUTDOWN) | ((ps + PL_LOCK) & ~SHUTDOWN);
                if (!U.compareAndSwapInt(this, PLOCK, ps, nps))
                    releasePlock(nps);
            }
            else
                r = 0; // try elsewhere while lock held
        }
    }

    // Maintaining ctl counts

    /**
     * Increments active count; mainly called upon return from blocking.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.939 -0400", hash_original_method = "6BAA05133FBF254E6C9A976878E1A1CB", hash_generated_method = "A2C1C9727E194C2EE9D129776BA61BDD")
    
final void incrementActiveCount() {
        long c;
        do {} while (!U.compareAndSwapLong(this, CTL, c = ctl, c + AC_UNIT));
    }

    /**
     * Tries to create or activate a worker if too few are active.
     *
     * @param q the (non-null) queue holding tasks to be signalled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.940 -0400", hash_original_method = "194F70BAE9B5858CF1A11B4075B6DAE3", hash_generated_method = "26602FCD25DBAFB2092C967C8FE8499D")
    
final void signalWork(WorkQueue q) {
        int hint = q.poolIndex;
        long c; int e, u, i, n; WorkQueue[] ws; WorkQueue w; Thread p;
        while ((u = (int)((c = ctl) >>> 32)) < 0) {
            if ((e = (int)c) > 0) {
                if ((ws = workQueues) != null && ws.length > (i = e & SMASK) &&
                    (w = ws[i]) != null && w.eventCount == (e | INT_SIGN)) {
                    long nc = (((long)(w.nextWait & E_MASK)) |
                               ((long)(u + UAC_UNIT) << 32));
                    if (U.compareAndSwapLong(this, CTL, c, nc)) {
                        w.hint = hint;
                        w.eventCount = (e + E_SEQ) & E_MASK;
                        if ((p = w.parker) != null)
                            U.unpark(p);
                        break;
                    }
                    if (q.top - q.base <= 0)
                        break;
                }
                else
                    break;
            }
            else {
                if ((short)u < 0)
                    tryAddWorker();
                break;
            }
        }
    }

    // Scanning for tasks

    /**
     * Top-level runloop for workers, called by ForkJoinWorkerThread.run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.941 -0400", hash_original_method = "DD736095295E26C9EF55404E67A534BB", hash_generated_method = "69D6F1497460A2046BC5D6C61C830C69")
    
final void runWorker(WorkQueue w) {
        w.growArray(); // allocate queue
        do { w.runTask(scan(w)); } while (w.qlock >= 0);
    }

    /**
     * Scans for and, if found, returns one task, else possibly
     * inactivates the worker. This method operates on single reads of
     * volatile state and is designed to be re-invoked continuously,
     * in part because it returns upon detecting inconsistencies,
     * contention, or state changes that indicate possible success on
     * re-invocation.
     *
     * The scan searches for tasks across queues (starting at a random
     * index, and relying on registerWorker to irregularly scatter
     * them within array to avoid bias), checking each at least twice.
     * The scan terminates upon either finding a non-empty queue, or
     * completing the sweep. If the worker is not inactivated, it
     * takes and returns a task from this queue. Otherwise, if not
     * activated, it signals workers (that may include itself) and
     * returns so caller can retry. Also returns for true if the
     * worker array may have changed during an empty scan.  On failure
     * to find a task, we take one of the following actions, after
     * which the caller will retry calling this method unless
     * terminated.
     *
     * * If pool is terminating, terminate the worker.
     *
     * * If not already enqueued, try to inactivate and enqueue the
     * worker on wait queue. Or, if inactivating has caused the pool
     * to be quiescent, relay to idleAwaitWork to possibly shrink
     * pool.
     *
     * * If already enqueued and none of the above apply, possibly
     * park awaiting signal, else lingering to help scan and signal.
     *
     * * If a non-empty queue discovered or left as a hint,
     * help wake up other workers before return.
     *
     * @param w the worker (via its WorkQueue)
     * @return a task or null if none found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.944 -0400", hash_original_method = "2BCC58D8E5EAB7B7BC72071E0D3F9A9E", hash_generated_method = "4B0EF4B72D7C5EBB72CFC2F264EA95D9")
    
private final ForkJoinTask<?> scan(WorkQueue w) {
        WorkQueue[] ws; int m;
        int ps = plock;                          // read plock before ws
        if (w != null && (ws = workQueues) != null && (m = ws.length - 1) >= 0) {
            int ec = w.eventCount;               // ec is negative if inactive
            int r = w.seed; r ^= r << 13; r ^= r >>> 17; w.seed = r ^= r << 5;
            w.hint = -1;                         // update seed and clear hint
            int j = ((m + m + 1) | MIN_SCAN) & MAX_SCAN;
            do {
                WorkQueue q; ForkJoinTask<?>[] a; int b;
                if ((q = ws[(r + j) & m]) != null && (b = q.base) - q.top < 0 &&
                    (a = q.array) != null) {     // probably nonempty
                    int i = (((a.length - 1) & b) << ASHIFT) + ABASE;
                    ForkJoinTask<?> t = (ForkJoinTask<?>)
                        U.getObjectVolatile(a, i);
                    if (q.base == b && ec >= 0 && t != null &&
                        U.compareAndSwapObject(a, i, t, null)) {
                        if ((q.base = b + 1) - q.top < 0)
                            signalWork(q);
                        return t;                // taken
                    }
                    else if ((ec < 0 || j < m) && (int)(ctl >> AC_SHIFT) <= 0) {
                        w.hint = (r + j) & m;    // help signal below
                        break;                   // cannot take
                    }
                }
            } while (--j >= 0);

            int h, e, ns; long c, sc; WorkQueue q;
            if ((ns = w.nsteals) != 0) {
                if (U.compareAndSwapLong(this, STEALCOUNT,
                                         sc = stealCount, sc + ns))
                    w.nsteals = 0;               // collect steals and rescan
            }
            else if (plock != ps)                // consistency check
                ;                                // skip
            else if ((e = (int)(c = ctl)) < 0)
                w.qlock = -1;                    // pool is terminating
            else {
                if ((h = w.hint) < 0) {
                    if (ec >= 0) {               // try to enqueue/inactivate
                        long nc = (((long)ec |
                                    ((c - AC_UNIT) & (AC_MASK|TC_MASK))));
                        w.nextWait = e;          // link and mark inactive
                        w.eventCount = ec | INT_SIGN;
                        if (ctl != c || !U.compareAndSwapLong(this, CTL, c, nc))
                            w.eventCount = ec;   // unmark on CAS failure
                        else if ((int)(c >> AC_SHIFT) == 1 - (config & SMASK))
                            idleAwaitWork(w, nc, c);
                    }
                    else if (w.eventCount < 0 && !tryTerminate(false, false) &&
                             ctl == c) {         // block
                        Thread wt = Thread.currentThread();
                        Thread.interrupted();    // clear status
                        U.putObject(wt, PARKBLOCKER, this);
                        w.parker = wt;           // emulate LockSupport.park
                        if (w.eventCount < 0)    // recheck
                            U.park(false, 0L);
                        w.parker = null;
                        U.putObject(wt, PARKBLOCKER, null);
                    }
                }
                if ((h >= 0 || (h = w.hint) >= 0) &&
                    (ws = workQueues) != null && h < ws.length &&
                    (q = ws[h]) != null) {      // signal others before retry
                    WorkQueue v; Thread p; int u, i, s;
                    for (int n = (config & SMASK) >>> 1;;) {
                        int idleCount = (w.eventCount < 0) ? 0 : -1;
                        if (((s = idleCount - q.base + q.top) <= n &&
                             (n = s) <= 0) ||
                            (u = (int)((c = ctl) >>> 32)) >= 0 ||
                            (e = (int)c) <= 0 || m < (i = e & SMASK) ||
                            (v = ws[i]) == null)
                            break;
                        long nc = (((long)(v.nextWait & E_MASK)) |
                                   ((long)(u + UAC_UNIT) << 32));
                        if (v.eventCount != (e | INT_SIGN) ||
                            !U.compareAndSwapLong(this, CTL, c, nc))
                            break;
                        v.hint = h;
                        v.eventCount = (e + E_SEQ) & E_MASK;
                        if ((p = v.parker) != null)
                            U.unpark(p);
                        if (--n <= 0)
                            break;
                    }
                }
            }
        }
        return null;
    }

    /**
     * If inactivating worker w has caused the pool to become
     * quiescent, checks for pool termination, and, so long as this is
     * not the only worker, waits for event for up to a given
     * duration.  On timeout, if ctl has not changed, terminates the
     * worker, which will in turn wake up another worker to possibly
     * repeat this process.
     *
     * @param w the calling worker
     * @param currentCtl the ctl value triggering possible quiescence
     * @param prevCtl the ctl value to restore if thread is terminated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.945 -0400", hash_original_method = "0C41676070B9833533B11DDEB29B5898", hash_generated_method = "EADAC0E04A33E359F25D631D544CE574")
    
private void idleAwaitWork(WorkQueue w, long currentCtl, long prevCtl) {
        if (w != null && w.eventCount < 0 &&
            !tryTerminate(false, false) && (int)prevCtl != 0) {
            int dc = -(short)(currentCtl >>> TC_SHIFT);
            long parkTime = dc < 0 ? FAST_IDLE_TIMEOUT: (dc + 1) * IDLE_TIMEOUT;
            long deadline = System.nanoTime() + parkTime - TIMEOUT_SLOP;
            Thread wt = Thread.currentThread();
            while (ctl == currentCtl) {
                Thread.interrupted();  // timed variant of version in scan()
                U.putObject(wt, PARKBLOCKER, this);
                w.parker = wt;
                if (ctl == currentCtl)
                    U.park(false, parkTime);
                w.parker = null;
                U.putObject(wt, PARKBLOCKER, null);
                if (ctl != currentCtl)
                    break;
                if (deadline - System.nanoTime() <= 0L &&
                    U.compareAndSwapLong(this, CTL, currentCtl, prevCtl)) {
                    w.eventCount = (w.eventCount + E_SEQ) | E_MASK;
                    w.qlock = -1;   // shrink
                    break;
                }
            }
        }
    }

    /**
     * Scans through queues looking for work while joining a task; if
     * any present, signals. May return early if more signalling is
     * detectably unneeded.
     *
     * @param task return early if done
     * @param origin an index to start scan
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.946 -0400", hash_original_method = "D0C6D7F570D0FD340243FC413F907F4D", hash_generated_method = "218ECE92EDBB6267F8CACCB83DE982FA")
    
private void helpSignal(ForkJoinTask<?> task, int origin) {
        WorkQueue[] ws; WorkQueue w; Thread p; long c; int m, u, e, i, s;
        if (task != null && task.status >= 0 &&
            (u = (int)(ctl >>> 32)) < 0 && (u >> UAC_SHIFT) < 0 &&
            (ws = workQueues) != null && (m = ws.length - 1) >= 0) {
            outer: for (int k = origin, j = m; j >= 0; --j) {
                WorkQueue q = ws[k++ & m];
                for (int n = m;;) { // limit to at most m signals
                    if (task.status < 0)
                        break outer;
                    if (q == null ||
                        ((s = -q.base + q.top) <= n && (n = s) <= 0))
                        break;
                    if ((u = (int)((c = ctl) >>> 32)) >= 0 ||
                        (e = (int)c) <= 0 || m < (i = e & SMASK) ||
                        (w = ws[i]) == null)
                        break outer;
                    long nc = (((long)(w.nextWait & E_MASK)) |
                               ((long)(u + UAC_UNIT) << 32));
                    if (w.eventCount != (e | INT_SIGN))
                        break outer;
                    if (U.compareAndSwapLong(this, CTL, c, nc)) {
                        w.eventCount = (e + E_SEQ) & E_MASK;
                        if ((p = w.parker) != null)
                            U.unpark(p);
                        if (--n <= 0)
                            break;
                    }
                }
            }
        }
    }

    /**
     * Tries to locate and execute tasks for a stealer of the given
     * task, or in turn one of its stealers, Traces currentSteal ->
     * currentJoin links looking for a thread working on a descendant
     * of the given task and with a non-empty queue to steal back and
     * execute tasks from. The first call to this method upon a
     * waiting join will often entail scanning/search, (which is OK
     * because the joiner has nothing better to do), but this method
     * leaves hints in workers to speed up subsequent calls. The
     * implementation is very branchy to cope with potential
     * inconsistencies or loops encountering chains that are stale,
     * unknown, or so long that they are likely cyclic.
     *
     * @param joiner the joining worker
     * @param task the task to join
     * @return 0 if no progress can be made, negative if task
     * known complete, else positive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.948 -0400", hash_original_method = "262F9E54D6D8B00531D76B367974EFAE", hash_generated_method = "11594571762475744EAF07852D9CC819")
    
private int tryHelpStealer(WorkQueue joiner, ForkJoinTask<?> task) {
        int stat = 0, steps = 0;                    // bound to avoid cycles
        if (joiner != null && task != null) {       // hoist null checks
            restart: for (;;) {
                ForkJoinTask<?> subtask = task;     // current target
                for (WorkQueue j = joiner, v;;) {   // v is stealer of subtask
                    WorkQueue[] ws; int m, s, h;
                    if ((s = task.status) < 0) {
                        stat = s;
                        break restart;
                    }
                    if ((ws = workQueues) == null || (m = ws.length - 1) <= 0)
                        break restart;              // shutting down
                    if ((v = ws[h = (j.hint | 1) & m]) == null ||
                        v.currentSteal != subtask) {
                        for (int origin = h;;) {    // find stealer
                            if (((h = (h + 2) & m) & 15) == 1 &&
                                (subtask.status < 0 || j.currentJoin != subtask))
                                continue restart;   // occasional staleness check
                            if ((v = ws[h]) != null &&
                                v.currentSteal == subtask) {
                                j.hint = h;        // save hint
                                break;
                            }
                            if (h == origin)
                                break restart;      // cannot find stealer
                        }
                    }
                    for (;;) { // help stealer or descend to its stealer
                        ForkJoinTask[] a;  int b;
                        if (subtask.status < 0)     // surround probes with
                            continue restart;       //   consistency checks
                        if ((b = v.base) - v.top < 0 && (a = v.array) != null) {
                            int i = (((a.length - 1) & b) << ASHIFT) + ABASE;
                            ForkJoinTask<?> t =
                                (ForkJoinTask<?>)U.getObjectVolatile(a, i);
                            if (subtask.status < 0 || j.currentJoin != subtask ||
                                v.currentSteal != subtask)
                                continue restart;   // stale
                            stat = 1;               // apparent progress
                            if (t != null && v.base == b &&
                                U.compareAndSwapObject(a, i, t, null)) {
                                v.base = b + 1;     // help stealer
                                joiner.runSubtask(t);
                            }
                            else if (v.base == b && ++steps == MAX_HELP)
                                break restart;      // v apparently stalled
                        }
                        else {                      // empty -- try to descend
                            ForkJoinTask<?> next = v.currentJoin;
                            if (subtask.status < 0 || j.currentJoin != subtask ||
                                v.currentSteal != subtask)
                                continue restart;   // stale
                            else if (next == null || ++steps == MAX_HELP)
                                break restart;      // dead-end or maybe cyclic
                            else {
                                subtask = next;
                                j = v;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return stat;
    }

    /**
     * Analog of tryHelpStealer for CountedCompleters. Tries to steal
     * and run tasks within the target's computation.
     *
     * @param task the task to join
     * @param mode if shared, exit upon completing any task
     * if all workers are active
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.949 -0400", hash_original_method = "CDA7EF57ED5F59F3502F7C22449A2DBF", hash_generated_method = "E46ECCBD7EFD00557433C735662D937D")
    
private int helpComplete(ForkJoinTask<?> task, int mode) {
        WorkQueue[] ws; WorkQueue q; int m, n, s, u;
        if (task != null && (ws = workQueues) != null &&
            (m = ws.length - 1) >= 0) {
            for (int j = 1, origin = j;;) {
                if ((s = task.status) < 0)
                    return s;
                if ((q = ws[j & m]) != null && q.pollAndExecCC(task)) {
                    origin = j;
                    if (mode == SHARED_QUEUE &&
                        ((u = (int)(ctl >>> 32)) >= 0 || (u >> UAC_SHIFT) >= 0))
                        break;
                }
                else if ((j = (j + 2) & m) == origin)
                    break;
            }
        }
        return 0;
    }

    /**
     * Tries to decrement active count (sometimes implicitly) and
     * possibly release or create a compensating worker in preparation
     * for blocking. Fails on contention or termination. Otherwise,
     * adds a new thread if no idle workers are available and pool
     * may become starved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.950 -0400", hash_original_method = "94856999314F690C757DD1923B4949E2", hash_generated_method = "380910E249594B0B47739C3A9B52CA46")
    
final boolean tryCompensate() {
        int pc = config & SMASK, e, i, tc; long c;
        WorkQueue[] ws; WorkQueue w; Thread p;
        if ((ws = workQueues) != null && (e = (int)(c = ctl)) >= 0) {
            if (e != 0 && (i = e & SMASK) < ws.length &&
                (w = ws[i]) != null && w.eventCount == (e | INT_SIGN)) {
                long nc = ((long)(w.nextWait & E_MASK) |
                           (c & (AC_MASK|TC_MASK)));
                if (U.compareAndSwapLong(this, CTL, c, nc)) {
                    w.eventCount = (e + E_SEQ) & E_MASK;
                    if ((p = w.parker) != null)
                        U.unpark(p);
                    return true;   // replace with idle worker
                }
            }
            else if ((tc = (short)(c >>> TC_SHIFT)) >= 0 &&
                     (int)(c >> AC_SHIFT) + pc > 1) {
                long nc = ((c - AC_UNIT) & AC_MASK) | (c & ~AC_MASK);
                if (U.compareAndSwapLong(this, CTL, c, nc))
                    return true;   // no compensation
            }
            else if (tc + pc < MAX_CAP) {
                long nc = ((c + TC_UNIT) & TC_MASK) | (c & ~TC_MASK);
                if (U.compareAndSwapLong(this, CTL, c, nc)) {
                    ForkJoinWorkerThreadFactory fac;
                    Throwable ex = null;
                    ForkJoinWorkerThread wt = null;
                    try {
                        if ((fac = factory) != null &&
                            (wt = fac.newThread(this)) != null) {
                            wt.start();
                            return true;
                        }
                    } catch (Throwable rex) {
                        ex = rex;
                    }
                    deregisterWorker(wt, ex); // clean up and return false
                }
            }
        }
        return false;
    }

    /**
     * Helps and/or blocks until the given task is done.
     *
     * @param joiner the joining worker
     * @param task the task
     * @return task status on exit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.951 -0400", hash_original_method = "9496D717B1D39778355BB97B79000495", hash_generated_method = "D6FC871CF3E8612CA21916A5B27A471D")
    
final int awaitJoin(WorkQueue joiner, ForkJoinTask<?> task) {
        int s = 0;
        if (joiner != null && task != null && (s = task.status) >= 0) {
            ForkJoinTask<?> prevJoin = joiner.currentJoin;
            joiner.currentJoin = task;
            do {} while ((s = task.status) >= 0 && !joiner.isEmpty() &&
                         joiner.tryRemoveAndExec(task)); // process local tasks
            if (s >= 0 && (s = task.status) >= 0) {
                helpSignal(task, joiner.poolIndex);
                if ((s = task.status) >= 0 &&
                    (task instanceof CountedCompleter))
                    s = helpComplete(task, LIFO_QUEUE);
            }
            while (s >= 0 && (s = task.status) >= 0) {
                if ((!joiner.isEmpty() ||           // try helping
                     (s = tryHelpStealer(joiner, task)) == 0) &&
                    (s = task.status) >= 0) {
                    helpSignal(task, joiner.poolIndex);
                    if ((s = task.status) >= 0 && tryCompensate()) {
                        if (task.trySetSignal() && (s = task.status) >= 0) {
                            synchronized (task) {
                                if (task.status >= 0) {
                                    try {                // see ForkJoinTask
                                        task.wait();     //  for explanation
                                    } catch (InterruptedException ie) {
                                    }
                                }
                                else
                                    task.notifyAll();
                            }
                        }
                        long c;                          // re-activate
                        do {} while (!U.compareAndSwapLong
                                     (this, CTL, c = ctl, c + AC_UNIT));
                    }
                }
            }
            joiner.currentJoin = prevJoin;
        }
        return s;
    }

    /**
     * Stripped-down variant of awaitJoin used by timed joins. Tries
     * to help join only while there is continuous progress. (Caller
     * will then enter a timed wait.)
     *
     * @param joiner the joining worker
     * @param task the task
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.952 -0400", hash_original_method = "9BCF4AF256390151CD469BFDA1F4BED9", hash_generated_method = "B2F11EB02D522FC30BCE5650EE443CCB")
    
final void helpJoinOnce(WorkQueue joiner, ForkJoinTask<?> task) {
        int s;
        if (joiner != null && task != null && (s = task.status) >= 0) {
            ForkJoinTask<?> prevJoin = joiner.currentJoin;
            joiner.currentJoin = task;
            do {} while ((s = task.status) >= 0 && !joiner.isEmpty() &&
                         joiner.tryRemoveAndExec(task));
            if (s >= 0 && (s = task.status) >= 0) {
                helpSignal(task, joiner.poolIndex);
                if ((s = task.status) >= 0 &&
                    (task instanceof CountedCompleter))
                    s = helpComplete(task, LIFO_QUEUE);
            }
            if (s >= 0 && joiner.isEmpty()) {
                do {} while (task.status >= 0 &&
                             tryHelpStealer(joiner, task) > 0);
            }
            joiner.currentJoin = prevJoin;
        }
    }

    /**
     * Returns a (probably) non-empty steal queue, if one is found
     * during a random, then cyclic scan, else null.  This method must
     * be retried by caller if, by the time it tries to use the queue,
     * it is empty.
     * @param r a (random) seed for scanning
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.953 -0400", hash_original_method = "18204777A5E8FA5B3C0C6BE729CCC5C7", hash_generated_method = "115788383F393ED67C0E0BA2F8530FAE")
    
private WorkQueue findNonEmptyStealQueue(int r) {
        for (WorkQueue[] ws;;) {
            int ps = plock, m, n;
            if ((ws = workQueues) == null || (m = ws.length - 1) < 1)
                return null;
            for (int j = (m + 1) << 2; ;) {
                WorkQueue q = ws[(((r + j) << 1) | 1) & m];
                if (q != null && (n = q.base - q.top) < 0) {
                    if (n < -1)
                        signalWork(q);
                    return q;
                }
                else if (--j < 0) {
                    if (plock == ps)
                        return null;
                    break;
                }
            }
        }
    }

    /**
     * Runs tasks until {@code isQuiescent()}. We piggyback on
     * active count ctl maintenance, but rather than blocking
     * when tasks cannot be found, we rescan until all others cannot
     * find tasks either.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.954 -0400", hash_original_method = "8015E5BFFE0BD4923D8CC2B245A5D8D1", hash_generated_method = "A1BC532602084F6CD4C43646EDC181BA")
    
final void helpQuiescePool(WorkQueue w) {
        for (boolean active = true;;) {
            ForkJoinTask<?> localTask; // exhaust local queue
            while ((localTask = w.nextLocalTask()) != null)
                localTask.doExec();
            // Similar to loop in scan(), but ignoring submissions
            WorkQueue q = findNonEmptyStealQueue(w.nextSeed());
            if (q != null) {
                ForkJoinTask<?> t; int b;
                if (!active) {      // re-establish active count
                    long c;
                    active = true;
                    do {} while (!U.compareAndSwapLong
                                 (this, CTL, c = ctl, c + AC_UNIT));
                }
                if ((b = q.base) - q.top < 0 && (t = q.pollAt(b)) != null)
                    w.runSubtask(t);
            }
            else {
                long c;
                if (active) {       // decrement active count without queuing
                    active = false;
                    do {} while (!U.compareAndSwapLong
                                 (this, CTL, c = ctl, c -= AC_UNIT));
                }
                else
                    c = ctl;        // re-increment on exit
                if ((int)(c >> AC_SHIFT) + (config & SMASK) == 0) {
                    do {} while (!U.compareAndSwapLong
                                 (this, CTL, c = ctl, c + AC_UNIT));
                    break;
                }
            }
        }
    }

    /**
     * Gets and removes a local or stolen task for the given worker.
     *
     * @return a task, if available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.954 -0400", hash_original_method = "28C5B97F3683A95912C479FE15A02881", hash_generated_method = "B0D7EE0383A63BD29738722CB08061BD")
    
final ForkJoinTask<?> nextTaskFor(WorkQueue w) {
        for (ForkJoinTask<?> t;;) {
            WorkQueue q; int b;
            if ((t = w.nextLocalTask()) != null)
                return t;
            if ((q = findNonEmptyStealQueue(w.nextSeed())) == null)
                return null;
            if ((b = q.base) - q.top < 0 && (t = q.pollAt(b)) != null)
                return t;
        }
    }

    //  Termination

    /**
     * Possibly initiates and/or completes termination.  The caller
     * triggering termination runs three passes through workQueues:
     * (0) Setting termination status, followed by wakeups of queued
     * workers; (1) cancelling all tasks; (2) interrupting lagging
     * threads (likely in external tasks, but possibly also blocked in
     * joins).  Each pass repeats previous steps because of potential
     * lagging thread creation.
     *
     * @param now if true, unconditionally terminate, else only
     * if no work and no active workers
     * @param enable if true, enable shutdown when next possible
     * @return true if now terminating or terminated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.958 -0400", hash_original_method = "624A5019B9ADE0A821980A4D645720D1", hash_generated_method = "98FB3C817D3A81B081F070B93E9CE1DE")
    
private boolean tryTerminate(boolean now, boolean enable) {
        if (this == commonPool)                     // cannot shut down
            return false;
        for (long c;;) {
            if (((c = ctl) & STOP_BIT) != 0) {      // already terminating
                if ((short)(c >>> TC_SHIFT) == -(config & SMASK)) {
                    synchronized (this) {
                        notifyAll();                // signal when 0 workers
                    }
                }
                return true;
            }
            if (plock >= 0) {                       // not yet enabled
                int ps;
                if (!enable)
                    return false;
                if (((ps = plock) & PL_LOCK) != 0 ||
                    !U.compareAndSwapInt(this, PLOCK, ps, ps += PL_LOCK))
                    ps = acquirePlock();
                if (!U.compareAndSwapInt(this, PLOCK, ps, SHUTDOWN))
                    releasePlock(SHUTDOWN);
            }
            if (!now) {                             // check if idle & no tasks
                if ((int)(c >> AC_SHIFT) != -(config & SMASK) ||
                    hasQueuedSubmissions())
                    return false;
                // Check for unqueued inactive workers. One pass suffices.
                WorkQueue[] ws = workQueues; WorkQueue w;
                if (ws != null) {
                    for (int i = 1; i < ws.length; i += 2) {
                        if ((w = ws[i]) != null && w.eventCount >= 0)
                            return false;
                    }
                }
            }
            if (U.compareAndSwapLong(this, CTL, c, c | STOP_BIT)) {
                for (int pass = 0; pass < 3; ++pass) {
                    WorkQueue[] ws = workQueues;
                    if (ws != null) {
                        WorkQueue w; Thread wt;
                        int n = ws.length;
                        for (int i = 0; i < n; ++i) {
                            if ((w = ws[i]) != null) {
                                w.qlock = -1;
                                if (pass > 0) {
                                    w.cancelAll();
                                    if (pass > 1 && (wt = w.owner) != null) {
                                        if (!wt.isInterrupted()) {
                                            try {
                                                wt.interrupt();
                                            } catch (SecurityException ignore) {
                                            }
                                        }
                                        U.unpark(wt);
                                    }
                                }
                            }
                        }
                        // Wake up workers parked on event queue
                        int i, e; long cc; Thread p;
                        while ((e = (int)(cc = ctl) & E_MASK) != 0 &&
                               (i = e & SMASK) < n &&
                               (w = ws[i]) != null) {
                            long nc = ((long)(w.nextWait & E_MASK) |
                                       ((cc + AC_UNIT) & AC_MASK) |
                                       (cc & (TC_MASK|STOP_BIT)));
                            if (w.eventCount == (e | INT_SIGN) &&
                                U.compareAndSwapLong(this, CTL, cc, nc)) {
                                w.eventCount = (e + E_SEQ) & E_MASK;
                                w.qlock = -1;
                                if ((p = w.parker) != null)
                                    U.unpark(p);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Tries to pop and run local tasks within the same computation
     * as the given root. On failure, tries to help complete from
     * other queues via helpComplete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.961 -0400", hash_original_method = "F88F7CA78822B77F12652F1E9CE5EE79", hash_generated_method = "D38E27C4B986E47E56B692319503782D")
    
private void externalHelpComplete(WorkQueue q, ForkJoinTask<?> root) {
        ForkJoinTask<?>[] a; int m;
        if (q != null && (a = q.array) != null && (m = (a.length - 1)) >= 0 &&
            root != null && root.status >= 0) {
            for (;;) {
                int s, u; Object o; CountedCompleter<?> task = null;
                if ((s = q.top) - q.base > 0) {
                    long j = ((m & (s - 1)) << ASHIFT) + ABASE;
                    if ((o = U.getObject(a, j)) != null &&
                        (o instanceof CountedCompleter)) {
                        CountedCompleter<?> t = (CountedCompleter<?>)o, r = t;
                        do {
                            if (r == root) {
                                if (U.compareAndSwapInt(q, QLOCK, 0, 1)) {
                                    if (q.array == a && q.top == s &&
                                        U.compareAndSwapObject(a, j, t, null)) {
                                        q.top = s - 1;
                                        task = t;
                                    }
                                    q.qlock = 0;
                                }
                                break;
                            }
                        } while ((r = r.completer) != null);
                    }
                }
                if (task != null)
                    task.doExec();
                if (root.status < 0 ||
                    (u = (int)(ctl >>> 32)) >= 0 || (u >> UAC_SHIFT) >= 0)
                    break;
                if (task == null) {
                    helpSignal(root, q.poolIndex);
                    if (root.status >= 0)
                        helpComplete(root, SHARED_QUEUE);
                    break;
                }
            }
        }
    }

    // Execution methods

    /**
     * Performs the given task, returning its result upon completion.
     * If the computation encounters an unchecked Exception or Error,
     * it is rethrown as the outcome of this invocation.  Rethrown
     * exceptions behave in the same way as regular exceptions, but,
     * when possible, contain stack traces (as displayed for example
     * using {@code ex.printStackTrace()}) of both the current thread
     * as well as the thread actually encountering the exception;
     * minimally only the latter.
     *
     * @param task the task
     * @return the task's result
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    public <T> T invoke(ForkJoinTask<T> task) {
        if (task == null)
            throw new NullPointerException();
        externalPush(task);
        return task.join();
    }

    /**
     * Arranges for (asynchronous) execution of the given task.
     *
     * @param task the task
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.966 -0400", hash_original_method = "FCD0471AE3D6BA8280EE0A9C2A42AADB", hash_generated_method = "3BA3B11880CCB6BF48996A45DDDF5E36")
    
public void execute(ForkJoinTask<?> task) {
        if (task == null)
            throw new NullPointerException();
        externalPush(task);
    }

    // AbstractExecutorService methods

    /**
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.966 -0400", hash_original_method = "698926B422931FDEA21840143F195B4F", hash_generated_method = "370D82990C064CD4B2F3382F282B515D")
    
public void execute(Runnable task) {
        if (task == null)
            throw new NullPointerException();
        ForkJoinTask<?> job;
        if (task instanceof ForkJoinTask<?>) // avoid re-wrap
            job = (ForkJoinTask<?>) task;
        else
            job = new ForkJoinTask.AdaptedRunnableAction(task);
        externalPush(job);
    }

    /**
     * Submits a ForkJoinTask for execution.
     *
     * @param task the task to submit
     * @return the task
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    @DSSpec(DSCat.THREADING)
    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> task) {
        if (task == null)
            throw new NullPointerException();
        externalPush(task);
        return task;
    }

    /**
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    @DSSpec(DSCat.THREADING)
    public <T> ForkJoinTask<T> submit(Callable<T> task) {
        ForkJoinTask<T> job = new ForkJoinTask.AdaptedCallable<T>(task);
        externalPush(job);
        return job;
    }

    /**
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    @DSSpec(DSCat.THREADING)
    public <T> ForkJoinTask<T> submit(Runnable task, T result) {
        ForkJoinTask<T> job = new ForkJoinTask.AdaptedRunnable<T>(task, result);
        externalPush(job);
        return job;
    }

    /**
     * @throws NullPointerException if the task is null
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.968 -0400", hash_original_method = "5B40D2F541E3E41BD944A78F5DBE79C0", hash_generated_method = "AF7BC3439C9AEDDB7444FB0BCEE77B76")
    
public ForkJoinTask<?> submit(Runnable task) {
        if (task == null)
            throw new NullPointerException();
        ForkJoinTask<?> job;
        if (task instanceof ForkJoinTask<?>) // avoid re-wrap
            job = (ForkJoinTask<?>) task;
        else
            job = new ForkJoinTask.AdaptedRunnableAction(task);
        externalPush(job);
        return job;
    }

    /**
     * @throws NullPointerException       {@inheritDoc}
     * @throws RejectedExecutionException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        // In previous versions of this class, this method constructed
        // a task to run ForkJoinTask.invokeAll, but now external
        // invocation of multiple tasks is at least as efficient.
        ArrayList<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());

        boolean done = false;
        try {
            for (Callable<T> t : tasks) {
                ForkJoinTask<T> f = new ForkJoinTask.AdaptedCallable<T>(t);
                futures.add(f);
                externalPush(f);
            }
            for (int i = 0, size = futures.size(); i < size; i++)
                ((ForkJoinTask<?>)futures.get(i)).quietlyJoin();
            done = true;
            return futures;
        } finally {
            if (!done)
                for (int i = 0, size = futures.size(); i < size; i++)
                    futures.get(i).cancel(false);
        }
    }

    /**
     * Returns the factory used for constructing new workers.
     *
     * @return the factory used for constructing new workers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.969 -0400", hash_original_method = "3050EE5EB78A107C0E1F874BC41A2138", hash_generated_method = "A075ECF87C5CA505360E4E0E3C4761CE")
    
public ForkJoinWorkerThreadFactory getFactory() {
        return factory;
    }

    /**
     * Returns the handler for internal worker threads that terminate
     * due to unrecoverable errors encountered while executing tasks.
     *
     * @return the handler, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.969 -0400", hash_original_method = "71527B2928DEC71D7DC4F4814E6AA694", hash_generated_method = "EAA9D063AC320DF1AAE2C44D17A22325")
    
public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return ueh;
    }

    /**
     * Returns the targeted parallelism level of this pool.
     *
     * @return the targeted parallelism level of this pool
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.970 -0400", hash_original_method = "825ECC9570B85A1ECD6C85D4F6D82572", hash_generated_method = "BB52DCDC378CCF810DF238B7DA1B8E96")
    
public int getParallelism() {
        return config & SMASK;
    }

    /**
     * Returns the number of worker threads that have started but not
     * yet terminated.  The result returned by this method may differ
     * from {@link #getParallelism} when threads are created to
     * maintain parallelism when others are cooperatively blocked.
     *
     * @return the number of worker threads
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.970 -0400", hash_original_method = "8200ED5FC34874C1F4F84D9A7DC66BB6", hash_generated_method = "D34CA454056BBBABFF694F6EF07707A6")
    
public int getPoolSize() {
        return (config & SMASK) + (short)(ctl >>> TC_SHIFT);
    }

    /**
     * Returns {@code true} if this pool uses local first-in-first-out
     * scheduling mode for forked tasks that are never joined.
     *
     * @return {@code true} if this pool uses async mode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.971 -0400", hash_original_method = "42B12741537A4680F8D25C79D1742318", hash_generated_method = "604AB7378C255CFDACEAF5FD8A172D83")
    
public boolean getAsyncMode() {
        return (config >>> 16) == FIFO_QUEUE;
    }

    /**
     * Returns an estimate of the number of worker threads that are
     * not blocked waiting to join tasks or for other managed
     * synchronization. This method may overestimate the
     * number of running threads.
     *
     * @return the number of worker threads
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.971 -0400", hash_original_method = "7A90959321C7FDAD7119D1908CDEF23D", hash_generated_method = "7D14DA7D100072F83E503F1739788F8A")
    
public int getRunningThreadCount() {
        int rc = 0;
        WorkQueue[] ws; WorkQueue w;
        if ((ws = workQueues) != null) {
            for (int i = 1; i < ws.length; i += 2) {
                if ((w = ws[i]) != null && w.isApparentlyUnblocked())
                    ++rc;
            }
        }
        return rc;
    }

    /**
     * Returns an estimate of the number of threads that are currently
     * stealing or executing tasks. This method may overestimate the
     * number of active threads.
     *
     * @return the number of active threads
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.972 -0400", hash_original_method = "EF872E51A15CEE487EE02B4795D98748", hash_generated_method = "DFF307781E3B4001545CAA8FE166BB03")
    
public int getActiveThreadCount() {
        int r = (config & SMASK) + (int)(ctl >> AC_SHIFT);
        return (r <= 0) ? 0 : r; // suppress momentarily negative values
    }

    /**
     * Returns {@code true} if all worker threads are currently idle.
     * An idle worker is one that cannot obtain a task to execute
     * because none are available to steal from other threads, and
     * there are no pending submissions to the pool. This method is
     * conservative; it might not return {@code true} immediately upon
     * idleness of all threads, but will eventually become true if
     * threads remain inactive.
     *
     * @return {@code true} if all threads are currently idle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.972 -0400", hash_original_method = "509C1DC331ADAFD61A8181AFAA2D0C9F", hash_generated_method = "6ED906B9FE133FF768BE2B7D5D91B979")
    
public boolean isQuiescent() {
        return (int)(ctl >> AC_SHIFT) + (config & SMASK) == 0;
    }

    /**
     * Returns an estimate of the total number of tasks stolen from
     * one thread's work queue by another. The reported value
     * underestimates the actual total number of steals when the pool
     * is not quiescent. This value may be useful for monitoring and
     * tuning fork/join programs: in general, steal counts should be
     * high enough to keep threads busy, but low enough to avoid
     * overhead and contention across threads.
     *
     * @return the number of steals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.973 -0400", hash_original_method = "2E2E6A7167D0B0A1FA0D64B2AB88E28F", hash_generated_method = "0936A7389E25811344B9BF232999EE1A")
    
public long getStealCount() {
        long count = stealCount;
        WorkQueue[] ws; WorkQueue w;
        if ((ws = workQueues) != null) {
            for (int i = 1; i < ws.length; i += 2) {
                if ((w = ws[i]) != null)
                    count += w.nsteals;
            }
        }
        return count;
    }

    /**
     * Returns an estimate of the total number of tasks currently held
     * in queues by worker threads (but not including tasks submitted
     * to the pool that have not begun executing). This value is only
     * an approximation, obtained by iterating across all threads in
     * the pool. This method may be useful for tuning task
     * granularities.
     *
     * @return the number of queued tasks
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.973 -0400", hash_original_method = "AD72E6F2F1464DF98A4DA91F651C400E", hash_generated_method = "2EAEB41DA74CE913739EFCC1EDBDA7CD")
    
public long getQueuedTaskCount() {
        long count = 0;
        WorkQueue[] ws; WorkQueue w;
        if ((ws = workQueues) != null) {
            for (int i = 1; i < ws.length; i += 2) {
                if ((w = ws[i]) != null)
                    count += w.queueSize();
            }
        }
        return count;
    }

    /**
     * Returns an estimate of the number of tasks submitted to this
     * pool that have not yet begun executing.  This method may take
     * time proportional to the number of submissions.
     *
     * @return the number of queued submissions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.974 -0400", hash_original_method = "41571F9BC9946FCF5FE4EB2002591D8B", hash_generated_method = "2DE4B2D2081C8726CC6B9193A9EF8DAD")
    
public int getQueuedSubmissionCount() {
        int count = 0;
        WorkQueue[] ws; WorkQueue w;
        if ((ws = workQueues) != null) {
            for (int i = 0; i < ws.length; i += 2) {
                if ((w = ws[i]) != null)
                    count += w.queueSize();
            }
        }
        return count;
    }

    /**
     * Interface for extending managed parallelism for tasks running
     * in {@link ForkJoinPool}s.
     *
     * <p>A {@code ManagedBlocker} provides two methods.  Method
     * {@code isReleasable} must return {@code true} if blocking is
     * not necessary. Method {@code block} blocks the current thread
     * if necessary (perhaps internally invoking {@code isReleasable}
     * before actually blocking). These actions are performed by any
     * thread invoking {@link ForkJoinPool#managedBlock}.  The
     * unusual methods in this API accommodate synchronizers that may,
     * but don't usually, block for long periods. Similarly, they
     * allow more efficient internal handling of cases in which
     * additional workers may be, but usually are not, needed to
     * ensure sufficient parallelism.  Toward this end,
     * implementations of method {@code isReleasable} must be amenable
     * to repeated invocation.
     *
     * <p>For example, here is a ManagedBlocker based on a
     * ReentrantLock:
     *  <pre> {@code
     * class ManagedLocker implements ManagedBlocker {
     *   final ReentrantLock lock;
     *   boolean hasLock = false;
     *   ManagedLocker(ReentrantLock lock) { this.lock = lock; }
     *   public boolean block() {
     *     if (!hasLock)
     *       lock.lock();
     *     return true;
     *   }
     *   public boolean isReleasable() {
     *     return hasLock || (hasLock = lock.tryLock());
     *   }
     * }}</pre>
     *
     * <p>Here is a class that possibly blocks waiting for an
     * item on a given queue:
     *  <pre> {@code
     * class QueueTaker<E> implements ManagedBlocker {
     *   final BlockingQueue<E> queue;
     *   volatile E item = null;
     *   QueueTaker(BlockingQueue<E> q) { this.queue = q; }
     *   public boolean block() throws InterruptedException {
     *     if (item == null)
     *       item = queue.take();
     *     return true;
     *   }
     *   public boolean isReleasable() {
     *     return item != null || (item = queue.poll()) != null;
     *   }
     *   public E getItem() { // call after pool.managedBlock completes
     *     return item;
     *   }
     * }}</pre>
     */
    public static interface ManagedBlocker {
        /**
         * Possibly blocks the current thread, for example waiting for
         * a lock or condition.
         *
         * @return {@code true} if no additional blocking is necessary
         * (i.e., if isReleasable would return true)
         * @throws InterruptedException if interrupted while waiting
         * (the method is not required to do so, but is allowed to)
         */
        boolean block() throws InterruptedException;

        /**
         * Returns {@code true} if blocking is unnecessary.
         */
        boolean isReleasable();
    }

    /**
     * Returns {@code true} if there are any tasks submitted to this
     * pool that have not yet begun executing.
     *
     * @return {@code true} if there are any queued submissions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.975 -0400", hash_original_method = "264EA673A56667DE857DD86EAC4F4E41", hash_generated_method = "A6DF25BBB59E80D07FC506664DE27818")
    
public boolean hasQueuedSubmissions() {
        WorkQueue[] ws; WorkQueue w;
        if ((ws = workQueues) != null) {
            for (int i = 0; i < ws.length; i += 2) {
                if ((w = ws[i]) != null && !w.isEmpty())
                    return true;
            }
        }
        return false;
    }

    /**
     * Removes and returns the next unexecuted submission if one is
     * available.  This method may be useful in extensions to this
     * class that re-assign work in systems with multiple pools.
     *
     * @return the next submission, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.975 -0400", hash_original_method = "8AED64B541CDA0D103D1C4E7D25E9253", hash_generated_method = "4B258AE6A8A0C75A426D8931187DF3C7")
    
protected ForkJoinTask<?> pollSubmission() {
        WorkQueue[] ws; WorkQueue w; ForkJoinTask<?> t;
        if ((ws = workQueues) != null) {
            for (int i = 0; i < ws.length; i += 2) {
                if ((w = ws[i]) != null && (t = w.poll()) != null)
                    return t;
            }
        }
        return null;
    }

    /**
     * Removes all available unexecuted submitted and forked tasks
     * from scheduling queues and adds them to the given collection,
     * without altering their execution status. These may include
     * artificially generated or wrapped tasks. This method is
     * designed to be invoked only when the pool is known to be
     * quiescent. Invocations at other times may not remove all
     * tasks. A failure encountered while attempting to add elements
     * to collection {@code c} may result in elements being in
     * neither, either or both collections when the associated
     * exception is thrown.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.
     *
     * @param c the collection to transfer elements into
     * @return the number of elements transferred
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.976 -0400", hash_original_method = "7A0161E6C6B280B5C3B1C892F013D65C", hash_generated_method = "30B70299FAE803CFC082A4379E4621FB")
    
protected int drainTasksTo(Collection<? super ForkJoinTask<?>> c) {
        int count = 0;
        WorkQueue[] ws; WorkQueue w; ForkJoinTask<?> t;
        if ((ws = workQueues) != null) {
            for (int i = 0; i < ws.length; ++i) {
                if ((w = ws[i]) != null) {
                    while ((t = w.poll()) != null) {
                        c.add(t);
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Returns a string identifying this pool, as well as its state,
     * including indications of run state, parallelism level, and
     * worker and task counts.
     *
     * @return a string identifying this pool, as well as its state
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.977 -0400", hash_original_method = "0DA1B408C6755F1ABED27ED61B694061", hash_generated_method = "FC10265F076A394781E8505F58261B8D")
    
public String toString() {
        // Use a single pass through workQueues to collect counts
        long qt = 0L, qs = 0L; int rc = 0;
        long st = stealCount;
        long c = ctl;
        WorkQueue[] ws; WorkQueue w;
        if ((ws = workQueues) != null) {
            for (int i = 0; i < ws.length; ++i) {
                if ((w = ws[i]) != null) {
                    int size = w.queueSize();
                    if ((i & 1) == 0)
                        qs += size;
                    else {
                        qt += size;
                        st += w.nsteals;
                        if (w.isApparentlyUnblocked())
                            ++rc;
                    }
                }
            }
        }
        int pc = (config & SMASK);
        int tc = pc + (short)(c >>> TC_SHIFT);
        int ac = pc + (int)(c >> AC_SHIFT);
        if (ac < 0) // ignore transient negative
            ac = 0;
        String level;
        if ((c & STOP_BIT) != 0)
            level = (tc == 0) ? "Terminated" : "Terminating";
        else
            level = plock < 0 ? "Shutting down" : "Running";
        return super.toString() +
            "[" + level +
            ", parallelism = " + pc +
            ", size = " + tc +
            ", active = " + ac +
            ", running = " + rc +
            ", steals = " + st +
            ", tasks = " + qt +
            ", submissions = " + qs +
            "]";
    }

    /**
     * Possibly initiates an orderly shutdown in which previously
     * submitted tasks are executed, but no new tasks will be
     * accepted. Invocation has no effect on execution state if this
     * is the {@link #commonPool()}, and no additional effect if
     * already shut down.  Tasks that are in the process of being
     * submitted concurrently during the course of this method may or
     * may not be rejected.
     *
     * @throws SecurityException if a security manager exists and
     *         the caller is not permitted to modify threads
     *         because it does not hold {@link
     *         java.lang.RuntimePermission}{@code ("modifyThread")}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.977 -0400", hash_original_method = "DC97D4DB34E30B9530DE4466BFC812AC", hash_generated_method = "7E3D47A777E6E6B461470DAC733755DF")
    
public void shutdown() {
        checkPermission();
        tryTerminate(false, true);
    }

    /**
     * Possibly attempts to cancel and/or stop all tasks, and reject
     * all subsequently submitted tasks.  Invocation has no effect on
     * execution state if this is the {@link #commonPool()}, and no
     * additional effect if already shut down. Otherwise, tasks that
     * are in the process of being submitted or executed concurrently
     * during the course of this method may or may not be
     * rejected. This method cancels both existing and unexecuted
     * tasks, in order to permit termination in the presence of task
     * dependencies. So the method always returns an empty list
     * (unlike the case for some other Executors).
     *
     * @return an empty list
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.978 -0400", hash_original_method = "3E8FDF9988BAB8B7A4DF16BF7ABEFEB0", hash_generated_method = "F320037D266CDC2CAFA9A728C49B6ACC")
    
public List<Runnable> shutdownNow() {
        checkPermission();
        tryTerminate(true, true);
        return Collections.emptyList();
    }

    /**
     * Returns {@code true} if all tasks have completed following shut down.
     *
     * @return {@code true} if all tasks have completed following shut down
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.978 -0400", hash_original_method = "74884CE7610B47231B000511924050E4", hash_generated_method = "721B9802B1E97C149FE2ECB448B1C8B1")
    
public boolean isTerminated() {
        long c = ctl;
        return ((c & STOP_BIT) != 0L &&
                (short)(c >>> TC_SHIFT) == -(config & SMASK));
    }

    /**
     * Returns {@code true} if the process of termination has
     * commenced but not yet completed.  This method may be useful for
     * debugging. A return of {@code true} reported a sufficient
     * period after shutdown may indicate that submitted tasks have
     * ignored or suppressed interruption, or are waiting for I/O,
     * causing this executor not to properly terminate. (See the
     * advisory notes for class {@link ForkJoinTask} stating that
     * tasks should not normally entail blocking operations.  But if
     * they do, they must abort them on interrupt.)
     *
     * @return {@code true} if terminating but not yet terminated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.978 -0400", hash_original_method = "40D660B1CA872102C5EBB88760E6ACAA", hash_generated_method = "D72C4AC0B2FD0CA89F762029649DFC18")
    
public boolean isTerminating() {
        long c = ctl;
        return ((c & STOP_BIT) != 0L &&
                (short)(c >>> TC_SHIFT) != -(config & SMASK));
    }

    /**
     * Returns {@code true} if this pool has been shut down.
     *
     * @return {@code true} if this pool has been shut down
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.979 -0400", hash_original_method = "879E82102F85FC41808D0846EB302932", hash_generated_method = "B82AB54A26F4DA7CBE7CA009B561B4EB")
    
public boolean isShutdown() {
        return plock < 0;
    }

    /**
     * Blocks until all tasks have completed execution after a
     * shutdown request, or the timeout occurs, or the current thread
     * is interrupted, whichever happens first. Note that the {@link
     * #commonPool()} never terminates until program shutdown so
     * this method will always time out.
     *
     * @param timeout the maximum time to wait
     * @param unit the time unit of the timeout argument
     * @return {@code true} if this executor terminated and
     *         {@code false} if the timeout elapsed before termination
     * @throws InterruptedException if interrupted while waiting
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:12.979 -0400", hash_original_method = "146413C981D1BADFB1D8203194C1AD61", hash_generated_method = "C95F1CB5809A8AFB9A7C913DE28DCD43")
    
public boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        if (isTerminated())
            return true;
        if (nanos <= 0L)
            return false;
        long deadline = System.nanoTime() + nanos;
        synchronized (this) {
            for (;;) {
                if (isTerminated())
                    return true;
                if (nanos <= 0L)
                    return false;
                long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
                wait(millis > 0L ? millis : 1L);
                nanos = deadline - System.nanoTime();
            }
        }
    }

    // AbstractExecutorService overrides.  These rely on undocumented
    // fact that ForkJoinTask.adapt returns ForkJoinTasks that also
    // implement RunnableFuture.

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new ForkJoinTask.AdaptedRunnable<T>(runnable, value);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ForkJoinTask.AdaptedCallable<T>(callable);
    }

    static {
        // initialize field offsets for CAS etc
        try {
            U = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ForkJoinPool.class;
            CTL = U.objectFieldOffset
                (k.getDeclaredField("ctl"));
            STEALCOUNT = U.objectFieldOffset
                (k.getDeclaredField("stealCount"));
            PLOCK = U.objectFieldOffset
                (k.getDeclaredField("plock"));
            INDEXSEED = U.objectFieldOffset
                (k.getDeclaredField("indexSeed"));
            Class<?> tk = Thread.class;
            PARKBLOCKER = U.objectFieldOffset
                (tk.getDeclaredField("parkBlocker"));
            Class<?> wk = WorkQueue.class;
            QLOCK = U.objectFieldOffset
                (wk.getDeclaredField("qlock"));
            Class<?> ak = ForkJoinTask[].class;
            ABASE = U.arrayBaseOffset(ak);
            int scale = U.arrayIndexScale(ak);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }

        submitters = new ThreadLocal<Submitter>();
        ForkJoinWorkerThreadFactory fac = defaultForkJoinWorkerThreadFactory =
            new DefaultForkJoinWorkerThreadFactory();
        modifyThreadPermission = new RuntimePermission("modifyThread");

        /*
         * Establish common pool parameters.  For extra caution,
         * computations to set up common pool state are here; the
         * constructor just assigns these values to fields.
         */

        int par = 0;
        Thread.UncaughtExceptionHandler handler = null;
        try {  // TBD: limit or report ignored exceptions?
            String pp = System.getProperty
                ("java.util.concurrent.ForkJoinPool.common.parallelism");
            String hp = System.getProperty
                ("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            String fp = System.getProperty
                ("java.util.concurrent.ForkJoinPool.common.threadFactory");
            if (fp != null)
                fac = ((ForkJoinWorkerThreadFactory)ClassLoader.
                       getSystemClassLoader().loadClass(fp).newInstance());
            if (hp != null)
                handler = ((Thread.UncaughtExceptionHandler)ClassLoader.
                           getSystemClassLoader().loadClass(hp).newInstance());
            if (pp != null)
                par = Integer.parseInt(pp);
        } catch (Exception ignore) {
        }

        if (par <= 0)
            par = Runtime.getRuntime().availableProcessors();
        if (par > MAX_CAP)
            par = MAX_CAP;
        commonPoolParallelism = par;
        long np = (long)(-par); // precompute initial ctl value
        long ct = ((np << AC_SHIFT) & AC_MASK) | ((np << TC_SHIFT) & TC_MASK);

        commonPool = new ForkJoinPool(par, ct, fac, handler);
    }

}
