/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.reflect.Constructor;

/**
 * Abstract base class for tasks that run within a {@link ForkJoinPool}.
 * A {@code ForkJoinTask} is a thread-like entity that is much
 * lighter weight than a normal thread.  Huge numbers of tasks and
 * subtasks may be hosted by a small number of actual threads in a
 * ForkJoinPool, at the price of some usage limitations.
 *
 * <p>A "main" {@code ForkJoinTask} begins execution when it is
 * explicitly submitted to a {@link ForkJoinPool}, or, if not already
 * engaged in a ForkJoin computation, commenced in the {@link
 * ForkJoinPool#commonPool()} via {@link #fork}, {@link #invoke}, or
 * related methods.  Once started, it will usually in turn start other
 * subtasks.  As indicated by the name of this class, many programs
 * using {@code ForkJoinTask} employ only methods {@link #fork} and
 * {@link #join}, or derivatives such as {@link
 * #invokeAll(ForkJoinTask...) invokeAll}.  However, this class also
 * provides a number of other methods that can come into play in
 * advanced usages, as well as extension mechanics that allow support
 * of new forms of fork/join processing.
 *
 * <p>A {@code ForkJoinTask} is a lightweight form of {@link Future}.
 * The efficiency of {@code ForkJoinTask}s stems from a set of
 * restrictions (that are only partially statically enforceable)
 * reflecting their main use as computational tasks calculating pure
 * functions or operating on purely isolated objects.  The primary
 * coordination mechanisms are {@link #fork}, that arranges
 * asynchronous execution, and {@link #join}, that doesn't proceed
 * until the task's result has been computed.  Computations should
 * ideally avoid {@code synchronized} methods or blocks, and should
 * minimize other blocking synchronization apart from joining other
 * tasks or using synchronizers such as Phasers that are advertised to
 * cooperate with fork/join scheduling. Subdividable tasks should also
 * not perform blocking I/O, and should ideally access variables that
 * are completely independent of those accessed by other running
 * tasks. These guidelines are loosely enforced by not permitting
 * checked exceptions such as {@code IOExceptions} to be
 * thrown. However, computations may still encounter unchecked
 * exceptions, that are rethrown to callers attempting to join
 * them. These exceptions may additionally include {@link
 * RejectedExecutionException} stemming from internal resource
 * exhaustion, such as failure to allocate internal task
 * queues. Rethrown exceptions behave in the same way as regular
 * exceptions, but, when possible, contain stack traces (as displayed
 * for example using {@code ex.printStackTrace()}) of both the thread
 * that initiated the computation as well as the thread actually
 * encountering the exception; minimally only the latter.
 *
 * <p>It is possible to define and use ForkJoinTasks that may block,
 * but doing do requires three further considerations: (1) Completion
 * of few if any <em>other</em> tasks should be dependent on a task
 * that blocks on external synchronization or I/O. Event-style async
 * tasks that are never joined (for example, those subclassing {@link
 * CountedCompleter}) often fall into this category.  (2) To minimize
 * resource impact, tasks should be small; ideally performing only the
 * (possibly) blocking action. (3) Unless the {@link
 * ForkJoinPool.ManagedBlocker} API is used, or the number of possibly
 * blocked tasks is known to be less than the pool's {@link
 * ForkJoinPool#getParallelism} level, the pool cannot guarantee that
 * enough threads will be available to ensure progress or good
 * performance.
 *
 * <p>The primary method for awaiting completion and extracting
 * results of a task is {@link #join}, but there are several variants:
 * The {@link Future#get} methods support interruptible and/or timed
 * waits for completion and report results using {@code Future}
 * conventions. Method {@link #invoke} is semantically
 * equivalent to {@code fork(); join()} but always attempts to begin
 * execution in the current thread. The "<em>quiet</em>" forms of
 * these methods do not extract results or report exceptions. These
 * may be useful when a set of tasks are being executed, and you need
 * to delay processing of results or exceptions until all complete.
 * Method {@code invokeAll} (available in multiple versions)
 * performs the most common form of parallel invocation: forking a set
 * of tasks and joining them all.
 *
 * <p>In the most typical usages, a fork-join pair act like a call
 * (fork) and return (join) from a parallel recursive function. As is
 * the case with other forms of recursive calls, returns (joins)
 * should be performed innermost-first. For example, {@code a.fork();
 * b.fork(); b.join(); a.join();} is likely to be substantially more
 * efficient than joining {@code a} before {@code b}.
 *
 * <p>The execution status of tasks may be queried at several levels
 * of detail: {@link #isDone} is true if a task completed in any way
 * (including the case where a task was cancelled without executing);
 * {@link #isCompletedNormally} is true if a task completed without
 * cancellation or encountering an exception; {@link #isCancelled} is
 * true if the task was cancelled (in which case {@link #getException}
 * returns a {@link java.util.concurrent.CancellationException}); and
 * {@link #isCompletedAbnormally} is true if a task was either
 * cancelled or encountered an exception, in which case {@link
 * #getException} will return either the encountered exception or
 * {@link java.util.concurrent.CancellationException}.
 *
 * <p>The ForkJoinTask class is not usually directly subclassed.
 * Instead, you subclass one of the abstract classes that support a
 * particular style of fork/join processing, typically {@link
 * RecursiveAction} for most computations that do not return results,
 * {@link RecursiveTask} for those that do, and {@link
 * CountedCompleter} for those in which completed actions trigger
 * other actions.  Normally, a concrete ForkJoinTask subclass declares
 * fields comprising its parameters, established in a constructor, and
 * then defines a {@code compute} method that somehow uses the control
 * methods supplied by this base class.
 *
 * <p>Method {@link #join} and its variants are appropriate for use
 * only when completion dependencies are acyclic; that is, the
 * parallel computation can be described as a directed acyclic graph
 * (DAG). Otherwise, executions may encounter a form of deadlock as
 * tasks cyclically wait for each other.  However, this framework
 * supports other methods and techniques (for example the use of
 * {@link Phaser}, {@link #helpQuiesce}, and {@link #complete}) that
 * may be of use in constructing custom subclasses for problems that
 * are not statically structured as DAGs. To support such usages a
 * ForkJoinTask may be atomically <em>tagged</em> with a {@code short}
 * value using {@link #setForkJoinTaskTag} or {@link
 * #compareAndSetForkJoinTaskTag} and checked using {@link
 * #getForkJoinTaskTag}. The ForkJoinTask implementation does not use
 * these {@code protected} methods or tags for any purpose, but they
 * may be of use in the construction of specialized subclasses.  For
 * example, parallel graph traversals can use the supplied methods to
 * avoid revisiting nodes/tasks that have already been processed.
 * (Method names for tagging are bulky in part to encourage definition
 * of methods that reflect their usage patterns.)
 *
 * <p>Most base support methods are {@code final}, to prevent
 * overriding of implementations that are intrinsically tied to the
 * underlying lightweight task scheduling framework.  Developers
 * creating new basic styles of fork/join processing should minimally
 * implement {@code protected} methods {@link #exec}, {@link
 * #setRawResult}, and {@link #getRawResult}, while also introducing
 * an abstract computational method that can be implemented in its
 * subclasses, possibly relying on other {@code protected} methods
 * provided by this class.
 *
 * <p>ForkJoinTasks should perform relatively small amounts of
 * computation. Large tasks should be split into smaller subtasks,
 * usually via recursive decomposition. As a very rough rule of thumb,
 * a task should perform more than 100 and less than 10000 basic
 * computational steps, and should avoid indefinite looping. If tasks
 * are too big, then parallelism cannot improve throughput. If too
 * small, then memory and internal task maintenance overhead may
 * overwhelm processing.
 *
 * <p>This class provides {@code adapt} methods for {@link Runnable}
 * and {@link Callable}, that may be of use when mixing execution of
 * {@code ForkJoinTasks} with other kinds of tasks. When all tasks are
 * of this form, consider using a pool constructed in <em>asyncMode</em>.
 *
 * <p>ForkJoinTasks are {@code Serializable}, which enables them to be
 * used in extensions such as remote execution frameworks. It is
 * sensible to serialize tasks only before or after, but not during,
 * execution. Serialization is not relied on during execution itself.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
public abstract class ForkJoinTask<V> implements Future<V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.950 -0400", hash_original_field = "4A3005E3C64686DA9EF2F1775AF465C3", hash_generated_field = "5678B60DAD16463BC73EBAB071678063")

    static final int DONE_MASK   = 0xf0000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.951 -0400", hash_original_field = "7D9EF79755F9CECEEBD1758CBB0D9815", hash_generated_field = "607569EA703FAEE6904E6FB316DDDA44")

    static final int NORMAL      = 0xf0000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.951 -0400", hash_original_field = "75319DA7D56E3C0464CC1E09E645DE1E", hash_generated_field = "AE22FB3BE23CD5C75A8CC53AF2D44F12")

    static final int CANCELLED   = 0xc0000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.952 -0400", hash_original_field = "82438D55FF6F48F8740B3AA1F1DF09BA", hash_generated_field = "CEEF0B066FA48547D83AB49F4C765CA6")

    static final int EXCEPTIONAL = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.952 -0400", hash_original_field = "57F3D049F20BF8A38C943CEFC9CE8260", hash_generated_field = "7C1D4BA9D5BACDC12245452F6719D99A")

    static final int SIGNAL      = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.952 -0400", hash_original_field = "53461BC7E3A4DD5D4E1A5DBECB687633", hash_generated_field = "35E2F22BEC2659AEF0AC1A2D1000D78B")

    static final int SMASK       = 0x0000ffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.957 -0400", hash_original_field = "3AE4ACCF763B92D2E443B1DD3C9C38AA", hash_generated_field = "C7BDE20637C6596F3D36CB6B9BE2C741")

    /**
     * Table of exceptions thrown by tasks, to enable reporting by
     * callers. Because exceptions are rare, we don't directly keep
     * them with task objects, but instead use a weak ref table.  Note
     * that cancellation exceptions don't appear in the table, but are
     * instead recorded as status values.
     *
     * Note: These statics are initialized below in static block.
     */
    private static  ExceptionNode[] exceptionTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.958 -0400", hash_original_field = "06A7C778BB32B303B212B47778EA5964", hash_generated_field = "4A36DB228D269972472998B55367A7B4")

    private static  ReentrantLock exceptionTableLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.958 -0400", hash_original_field = "73FA7A9FE83E0389765646C088A5AE37", hash_generated_field = "C1CC3DED471337FF41D700F0D93683BC")

    private static  ReferenceQueue<Object> exceptionTableRefQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.958 -0400", hash_original_field = "BD0951F25E2DD5EA3837054A50C80704", hash_generated_field = "37E96376CBB36F7E56F0ADB8DF564164")

    private static final int EXCEPTION_MAP_CAPACITY = 32;

    /**
     * Cancels, ignoring any exceptions thrown by cancel. Used during
     * worker and pool shutdown. Cancel is spec'ed not to throw any
     * exceptions, but if it does anyway, we have no recourse during
     * shutdown, so guard against this case.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.963 -0400", hash_original_method = "78EED22D93DE7B89C3D2901F057A4A9A", hash_generated_method = "8B3883365C58AF562223BD13D71B2F02")
    
static final void cancelIgnoringExceptions(ForkJoinTask<?> t) {
        if (t != null && t.status >= 0) {
            try {
                t.cancel(false);
            } catch (Throwable ignore) {
            }
        }
    }

    /**
     * Poll stale refs and remove them. Call only while holding lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.967 -0400", hash_original_method = "0C99B9A09DEA9F4F808BC04161654536", hash_generated_method = "6CA2D5B82F81AF449D937376EBB1C7FB")
    
private static void expungeStaleExceptions() {
        for (Object x; (x = exceptionTableRefQueue.poll()) != null;) {
            if (x instanceof ExceptionNode) {
                ForkJoinTask<?> key = ((ExceptionNode)x).get();
                ExceptionNode[] t = exceptionTable;
                int i = System.identityHashCode(key) & (t.length - 1);
                ExceptionNode e = t[i];
                ExceptionNode pred = null;
                while (e != null) {
                    ExceptionNode next = e.next;
                    if (e == x) {
                        if (pred == null)
                            t[i] = next;
                        else
                            pred.next = next;
                        break;
                    }
                    pred = e;
                    e = next;
                }
            }
        }
    }

    /**
     * If lock is available, poll stale refs and remove them.
     * Called from ForkJoinPool when pools become quiescent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.968 -0400", hash_original_method = "8DBDB9490CAE132A7E03863C0FF2FE54", hash_generated_method = "676659302D99F3F20F30C884DE2A827F")
    
static final void helpExpungeStaleExceptions() {
        final ReentrantLock lock = exceptionTableLock;
        if (lock.tryLock()) {
            try {
                expungeStaleExceptions();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * A version of "sneaky throw" to relay exceptions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.968 -0400", hash_original_method = "39D23C0DF9583B6A7125FB203F20B6A3", hash_generated_method = "08010DE70FED86DB2C10AED408C95E50")
    
static void rethrow(final Throwable ex) {
        if (ex != null) {
            if (ex instanceof Error)
                throw (Error)ex;
            if (ex instanceof RuntimeException)
                throw (RuntimeException)ex;
            throw uncheckedThrowable(ex, RuntimeException.class);
        }
    }

    /**
     * The sneaky part of sneaky throw, relying on generics
     * limitations to evade compiler complaints about rethrowing
     * unchecked exceptions
     */
    @SuppressWarnings("unchecked") static <T extends Throwable>
        T uncheckedThrowable(final Throwable t, final Class<T> c) {
        return (T)t; // rely on vacuous cast
    }

    /**
     * Forks the given tasks, returning when {@code isDone} holds for
     * each task or an (unchecked) exception is encountered, in which
     * case the exception is rethrown. If more than one task
     * encounters an exception, then this method throws any one of
     * these exceptions. If any task encounters an exception, the
     * other may be cancelled. However, the execution status of
     * individual tasks is not guaranteed upon exceptional return. The
     * status of each task may be obtained using {@link
     * #getException()} and related methods to check if they have been
     * cancelled, completed normally or exceptionally, or left
     * unprocessed.
     *
     * @param t1 the first task
     * @param t2 the second task
     * @throws NullPointerException if any task is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.971 -0400", hash_original_method = "130428290F79BD9F3B3F9A5CB09D37D5", hash_generated_method = "8A5E3008D954A2EF406BF62D16B1045F")
    
public static void invokeAll(ForkJoinTask<?> t1, ForkJoinTask<?> t2) {
        int s1, s2;
        t2.fork();
        if ((s1 = t1.doInvoke() & DONE_MASK) != NORMAL)
            t1.reportException(s1);
        if ((s2 = t2.doJoin() & DONE_MASK) != NORMAL)
            t2.reportException(s2);
    }

    /**
     * Forks the given tasks, returning when {@code isDone} holds for
     * each task or an (unchecked) exception is encountered, in which
     * case the exception is rethrown. If more than one task
     * encounters an exception, then this method throws any one of
     * these exceptions. If any task encounters an exception, others
     * may be cancelled. However, the execution status of individual
     * tasks is not guaranteed upon exceptional return. The status of
     * each task may be obtained using {@link #getException()} and
     * related methods to check if they have been cancelled, completed
     * normally or exceptionally, or left unprocessed.
     *
     * @param tasks the tasks
     * @throws NullPointerException if any task is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.972 -0400", hash_original_method = "A3D8EA87F05226287137825539B70999", hash_generated_method = "F6B208AB4CCF147B01A2F50096E58102")
    
public static void invokeAll(ForkJoinTask<?>... tasks) {
        Throwable ex = null;
        int last = tasks.length - 1;
        for (int i = last; i >= 0; --i) {
            ForkJoinTask<?> t = tasks[i];
            if (t == null) {
                if (ex == null)
                    ex = new NullPointerException();
            }
            else if (i != 0)
                t.fork();
            else if (t.doInvoke() < NORMAL && ex == null)
                ex = t.getException();
        }
        for (int i = 1; i <= last; ++i) {
            ForkJoinTask<?> t = tasks[i];
            if (t != null) {
                if (ex != null)
                    t.cancel(false);
                else if (t.doJoin() < NORMAL)
                    ex = t.getException();
            }
        }
        if (ex != null)
            rethrow(ex);
    }

    /**
     * Forks all tasks in the specified collection, returning when
     * {@code isDone} holds for each task or an (unchecked) exception
     * is encountered, in which case the exception is rethrown. If
     * more than one task encounters an exception, then this method
     * throws any one of these exceptions. If any task encounters an
     * exception, others may be cancelled. However, the execution
     * status of individual tasks is not guaranteed upon exceptional
     * return. The status of each task may be obtained using {@link
     * #getException()} and related methods to check if they have been
     * cancelled, completed normally or exceptionally, or left
     * unprocessed.
     *
     * @param tasks the collection of tasks
     * @return the tasks argument, to simplify usage
     * @throws NullPointerException if tasks or any element are null

     * @hide
     */
    public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T> tasks) {
        if (!(tasks instanceof RandomAccess) || !(tasks instanceof List<?>)) {
            invokeAll(tasks.toArray(new ForkJoinTask<?>[tasks.size()]));
            return tasks;
        }
        @SuppressWarnings("unchecked")
        List<? extends ForkJoinTask<?>> ts =
            (List<? extends ForkJoinTask<?>>) tasks;
        Throwable ex = null;
        int last = ts.size() - 1;
        for (int i = last; i >= 0; --i) {
            ForkJoinTask<?> t = ts.get(i);
            if (t == null) {
                if (ex == null)
                    ex = new NullPointerException();
            }
            else if (i != 0)
                t.fork();
            else if (t.doInvoke() < NORMAL && ex == null)
                ex = t.getException();
        }
        for (int i = 1; i <= last; ++i) {
            ForkJoinTask<?> t = ts.get(i);
            if (t != null) {
                if (ex != null)
                    t.cancel(false);
                else if (t.doJoin() < NORMAL)
                    ex = t.getException();
            }
        }
        if (ex != null)
            rethrow(ex);
        return tasks;
    }

    /**
     * Key-value nodes for exception table.  The chained hash table
     * uses identity comparisons, full locking, and weak references
     * for keys. The table has a fixed capacity because it only
     * maintains task exceptions long enough for joiners to access
     * them, so should never become very large for sustained
     * periods. However, since we do not know when the last joiner
     * completes, we must use weak references and expunge them. We do
     * so on each operation (hence full locking). Also, some thread in
     * any ForkJoinPool will call helpExpungeStaleExceptions when its
     * pool becomes isQuiescent.
     */
    static final class ExceptionNode extends WeakReference<ForkJoinTask<?>> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.959 -0400", hash_original_field = "1681A14450382F5ED1D23C2523918CE1", hash_generated_field = "1681A14450382F5ED1D23C2523918CE1")

         Throwable ex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.959 -0400", hash_original_field = "5FDD13790631380906FFFD0C5B006776", hash_generated_field = "5FDD13790631380906FFFD0C5B006776")

        ExceptionNode next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.959 -0400", hash_original_field = "D872081FAFDDE0B2DDA7A9ECBB440A7D", hash_generated_field = "D872081FAFDDE0B2DDA7A9ECBB440A7D")

         long thrower;  // use id not ref to avoid weak cycles
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.960 -0400", hash_original_method = "7C7762070675518F0427A689EB968846", hash_generated_method = "7C7762070675518F0427A689EB968846")
        
ExceptionNode(ForkJoinTask<?> task, Throwable ex, ExceptionNode next) {
            super(task, exceptionTableRefQueue);
            this.ex = ex;
            this.next = next;
            this.thrower = Thread.currentThread().getId();
        }
    }

    /**
     * Possibly executes tasks until the pool hosting the current task
     * {@link ForkJoinPool#isQuiescent is quiescent}. This method may
     * be of use in designs in which many tasks are forked, but none
     * are explicitly joined, instead executing them until all are
     * processed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.980 -0400", hash_original_method = "7CBCBD78AD5A7E49166CB92964FC1850", hash_generated_method = "77E70E27E283710A93318D0FCEA6B0E7")
    
public static void helpQuiesce() {
        Thread t;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread wt = (ForkJoinWorkerThread)t;
            wt.pool.helpQuiescePool(wt.workQueue);
        }
        else
            ForkJoinPool.externalHelpQuiescePool();
    }

    /**
     * Returns the pool hosting the current task execution, or null
     * if this task is executing outside of any ForkJoinPool.
     *
     * @see #inForkJoinPool
     * @return the pool, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.981 -0400", hash_original_method = "3D7EEEBF0D60F34747A5888074992A65", hash_generated_method = "DE7C986339FED4BF2C4A9DA740A7A64D")
    
public static ForkJoinPool getPool() {
        Thread t = Thread.currentThread();
        return (t instanceof ForkJoinWorkerThread) ?
            ((ForkJoinWorkerThread) t).pool : null;
    }

    /**
     * Returns {@code true} if the current thread is a {@link
     * ForkJoinWorkerThread} executing as a ForkJoinPool computation.
     *
     * @return {@code true} if the current thread is a {@link
     * ForkJoinWorkerThread} executing as a ForkJoinPool computation,
     * or {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.982 -0400", hash_original_method = "5B33B1D3C65446A76923EB1D27F6C52B", hash_generated_method = "C677D7E491F91406EB48DBDBA35F1EE3")
    
public static boolean inForkJoinPool() {
        return Thread.currentThread() instanceof ForkJoinWorkerThread;
    }

    /**
     * Returns an estimate of the number of tasks that have been
     * forked by the current worker thread but not yet executed. This
     * value may be useful for heuristic decisions about whether to
     * fork other tasks.
     *
     * @return the number of tasks
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.982 -0400", hash_original_method = "2629BC464CD76374F10E6059C8ACAC93", hash_generated_method = "FDA9D7DD8BFCE5C17B079F87A87EAF68")
    
public static int getQueuedTaskCount() {
        Thread t; ForkJoinPool.WorkQueue q;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
            q = ((ForkJoinWorkerThread)t).workQueue;
        else
            q = ForkJoinPool.commonSubmitterQueue();
        return (q == null) ? 0 : q.queueSize();
    }

    /**
     * Returns an estimate of how many more locally queued tasks are
     * held by the current worker thread than there are other worker
     * threads that might steal them, or zero if this thread is not
     * operating in a ForkJoinPool. This value may be useful for
     * heuristic decisions about whether to fork other tasks. In many
     * usages of ForkJoinTasks, at steady state, each worker should
     * aim to maintain a small constant surplus (for example, 3) of
     * tasks, and to process computations locally if this threshold is
     * exceeded.
     *
     * @return the surplus number of tasks, which may be negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.983 -0400", hash_original_method = "10D3793DFA1FB91433527F9E16EF413C", hash_generated_method = "39BB1A4902A104FF3BDC43BB69FF56CE")
    
public static int getSurplusQueuedTaskCount() {
        return ForkJoinPool.getSurplusQueuedTaskCount();
    }

    /**
     * Returns, but does not unschedule or execute, a task queued by
     * the current thread but not yet executed, if one is immediately
     * available. There is no guarantee that this task will actually
     * be polled or executed next. Conversely, this method may return
     * null even if a task exists but cannot be accessed without
     * contention with other threads.  This method is designed
     * primarily to support extensions, and is unlikely to be useful
     * otherwise.
     *
     * @return the next task, or {@code null} if none are available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.984 -0400", hash_original_method = "51E5EB5D2BE33644B18FEBAFAC5843D0", hash_generated_method = "3BE4A36E89F65D31FFAA65059CDB5C94")
    
protected static ForkJoinTask<?> peekNextLocalTask() {
        Thread t; ForkJoinPool.WorkQueue q;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
            q = ((ForkJoinWorkerThread)t).workQueue;
        else
            q = ForkJoinPool.commonSubmitterQueue();
        return (q == null) ? null : q.peek();
    }

    /**
     * Unschedules and returns, without executing, the next task
     * queued by the current thread but not yet executed, if the
     * current thread is operating in a ForkJoinPool.  This method is
     * designed primarily to support extensions, and is unlikely to be
     * useful otherwise.
     *
     * @return the next task, or {@code null} if none are available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.985 -0400", hash_original_method = "0E9CC935A223785121E87F6F0C87D2B0", hash_generated_method = "0619741798C60049560D1E607D838195")
    
protected static ForkJoinTask<?> pollNextLocalTask() {
        Thread t;
        return ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
            ((ForkJoinWorkerThread)t).workQueue.nextLocalTask() :
            null;
    }

    /**
     * If the current thread is operating in a ForkJoinPool,
     * unschedules and returns, without executing, the next task
     * queued by the current thread but not yet executed, if one is
     * available, or if not available, a task that was forked by some
     * other thread, if available. Availability may be transient, so a
     * {@code null} result does not necessarily imply quiescence of
     * the pool this task is operating in.  This method is designed
     * primarily to support extensions, and is unlikely to be useful
     * otherwise.
     *
     * @return a task, or {@code null} if none are available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.985 -0400", hash_original_method = "9D052156671EAC91D6D5A95841268256", hash_generated_method = "2C78F7253EA08CD2B483F5A64FC110DD")
    
protected static ForkJoinTask<?> pollTask() {
        Thread t; ForkJoinWorkerThread wt;
        return ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
            (wt = (ForkJoinWorkerThread)t).pool.nextTaskFor(wt.workQueue) :
            null;
    }

    /**
     * Returns a new {@code ForkJoinTask} that performs the {@code run}
     * method of the given {@code Runnable} as its action, and returns
     * a null result upon {@link #join}.
     *
     * @param runnable the runnable action
     * @return the task
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.998 -0400", hash_original_method = "FB47C81933038B39D3403D632134D8EC", hash_generated_method = "3118C8668620FF63589D8833E4F1A716")
    
public static ForkJoinTask<?> adapt(Runnable runnable) {
        return new AdaptedRunnableAction(runnable);
    }

    /**
     * Returns a new {@code ForkJoinTask} that performs the {@code run}
     * method of the given {@code Runnable} as its action, and returns
     * the given result upon {@link #join}.
     *
     * @param runnable the runnable action
     * @param result the result upon completion
     * @return the task
     */
    public static <T> ForkJoinTask<T> adapt(Runnable runnable, T result) {
        return new AdaptedRunnable<T>(runnable, result);
    }

    /**
     * Returns a new {@code ForkJoinTask} that performs the {@code call}
     * method of the given {@code Callable} as its action, and returns
     * its result upon {@link #join}, translating any checked exceptions
     * encountered into {@code RuntimeException}.
     *
     * @param callable the callable action
     * @return the task
     */
    public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
        return new AdaptedCallable<T>(callable);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.999 -0400", hash_original_field = "8A999C2B6C1E353D8BBBE70F270C889C", hash_generated_field = "C78CDE4A9B2BA35F7E2E7C42BDBB7E01")

    private static final long serialVersionUID = -7721805057305804111L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.000 -0400", hash_original_field = "71C0AF9A8855A18D8CEED7E5A0A347BB", hash_generated_field = "E1D673985FF3F8FAC5355C138B0EC615")

    private static  sun.misc.Unsafe U;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.001 -0400", hash_original_field = "4DD2025E432330C05508A1BF0A26687F", hash_generated_field = "BD291F09ACFE5B75B0D62C08099B08F8")

    private static  long STATUS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.950 -0400", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "EFA0C478934201BDF4B89E187356FAD2")

    /*
     * The status field holds run control status bits packed into a
     * single int to minimize footprint and to ensure atomicity (via
     * CAS).  Status is initially zero, and takes on nonnegative
     * values until completed, upon which status (anded with
     * DONE_MASK) holds value NORMAL, CANCELLED, or EXCEPTIONAL. Tasks
     * undergoing blocking waits by other threads have the SIGNAL bit
     * set.  Completion of a stolen task with SIGNAL set awakens any
     * waiters via notifyAll. Even though suboptimal for some
     * purposes, we use basic builtin wait/notify to take advantage of
     * "monitor inflation" in JVMs that we would otherwise need to
     * emulate to avoid adding further per-task bookkeeping overhead.
     * We want these monitors to be "fat", i.e., not use biasing or
     * thin-lock techniques, so use some odd coding idioms that tend
     * to avoid them, mainly by arranging that every synchronized
     * block performs a wait, notifyAll or both.
     *
     * These control bits occupy only (some of) the upper half (16
     * bits) of status field. The lower bits are used for user-defined
     * tags.
     */

    /** The run status of this task */
    volatile int status;  // short bits for tags

    /**
     * Marks completion and wakes up threads waiting to join this
     * task.
     *
     * @param completion one of NORMAL, CANCELLED, EXCEPTIONAL
     * @return completion status on exit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.953 -0400", hash_original_method = "0AFCB72D8BFF442D1067CB00AA850C14", hash_generated_method = "E47FAB7BAC4B6A521D4520C77E98B2F6")
    
private int setCompletion(int completion) {
        for (int s;;) {
            if ((s = status) < 0)
                return s;
            if (U.compareAndSwapInt(this, STATUS, s, s | completion)) {
                if ((s >>> 16) != 0)
                    synchronized (this) { notifyAll(); }
                return completion;
            }
        }
    }

    /**
     * Primary execution method for stolen tasks. Unless done, calls
     * exec and records status if completed, but doesn't wait for
     * completion otherwise.
     *
     * @return status on exit from this method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.954 -0400", hash_original_method = "63AA3F5F1D74FF4B8DAC35E62B3B8C3E", hash_generated_method = "D3E8F3AA0E23D9E49D7270B11079AA8F")
    
final int doExec() {
        int s; boolean completed;
        if ((s = status) >= 0) {
            try {
                completed = exec();
            } catch (Throwable rex) {
                return setExceptionalCompletion(rex);
            }
            if (completed)
                s = setCompletion(NORMAL);
        }
        return s;
    }

    /**
     * Tries to set SIGNAL status unless already completed. Used by
     * ForkJoinPool. Other variants are directly incorporated into
     * externalAwaitDone etc.
     *
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.954 -0400", hash_original_method = "0FB044FD4D65FA889C8B9722042499AF", hash_generated_method = "FCC68759A3486E53096BE59DAD4F4C01")
    
final boolean trySetSignal() {
        int s = status;
        return s >= 0 && U.compareAndSwapInt(this, STATUS, s, s | SIGNAL);
    }

    /**
     * Blocks a non-worker-thread until completion.
     * @return status upon completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.955 -0400", hash_original_method = "FD86EB9E7A00979E50E916949BFBCA82", hash_generated_method = "D2D9EEB53F63DB950FEB95AD4B2D1677")
    
private int externalAwaitDone() {
        int s;
        ForkJoinPool.externalHelpJoin(this);
        boolean interrupted = false;
        while ((s = status) >= 0) {
            if (U.compareAndSwapInt(this, STATUS, s, s | SIGNAL)) {
                synchronized (this) {
                    if (status >= 0) {
                        try {
                            wait();
                        } catch (InterruptedException ie) {
                            interrupted = true;
                        }
                    }
                    else
                        notifyAll();
                }
            }
        }
        if (interrupted)
            Thread.currentThread().interrupt();
        return s;
    }

    /**
     * Blocks a non-worker-thread until completion or interruption.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.955 -0400", hash_original_method = "279A624BE1522B3C9BD9FB83EFD1274C", hash_generated_method = "1FFDD57C8FB4D999BFC242677290591C")
    
private int externalInterruptibleAwaitDone() throws InterruptedException {
        int s;
        if (Thread.interrupted())
            throw new InterruptedException();
        ForkJoinPool.externalHelpJoin(this);
        while ((s = status) >= 0) {
            if (U.compareAndSwapInt(this, STATUS, s, s | SIGNAL)) {
                synchronized (this) {
                    if (status >= 0)
                        wait();
                    else
                        notifyAll();
                }
            }
        }
        return s;
    }

    /**
     * Implementation for join, get, quietlyJoin. Directly handles
     * only cases of already-completed, external wait, and
     * unfork+exec.  Others are relayed to ForkJoinPool.awaitJoin.
     *
     * @return status upon completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.956 -0400", hash_original_method = "0F5BDACC91AF828CB63F4A3408F69539", hash_generated_method = "D12F7C342AD1A5D2F665A60407BCF228")
    
private int doJoin() {
        int s; Thread t; ForkJoinWorkerThread wt; ForkJoinPool.WorkQueue w;
        return (s = status) < 0 ? s :
            ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
            (w = (wt = (ForkJoinWorkerThread)t).workQueue).
            tryUnpush(this) && (s = doExec()) < 0 ? s :
            wt.pool.awaitJoin(w, this) :
            externalAwaitDone();
    }

    /**
     * Implementation for invoke, quietlyInvoke.
     *
     * @return status upon completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.956 -0400", hash_original_method = "5C068C115B08E9ED32EC148A8D6C62ED", hash_generated_method = "DE9B2B3C1454E2A31F3A11FD53ACBFA2")
    
private int doInvoke() {
        int s; Thread t; ForkJoinWorkerThread wt;
        return (s = doExec()) < 0 ? s :
            ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
            (wt = (ForkJoinWorkerThread)t).pool.awaitJoin(wt.workQueue, this) :
            externalAwaitDone();
    }

    /**
     * Records exception and sets status.
     *
     * @return status on exit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.961 -0400", hash_original_method = "48955F5796F9AC60CB2008558D7FFADD", hash_generated_method = "7972AA33A1C89EC567A05950E77464EF")
    
final int recordExceptionalCompletion(Throwable ex) {
        int s;
        if ((s = status) >= 0) {
            int h = System.identityHashCode(this);
            final ReentrantLock lock = exceptionTableLock;
            lock.lock();
            try {
                expungeStaleExceptions();
                ExceptionNode[] t = exceptionTable;
                int i = h & (t.length - 1);
                for (ExceptionNode e = t[i]; ; e = e.next) {
                    if (e == null) {
                        t[i] = new ExceptionNode(this, ex, t[i]);
                        break;
                    }
                    if (e.get() == this) // already present
                        break;
                }
            } finally {
                lock.unlock();
            }
            s = setCompletion(EXCEPTIONAL);
        }
        return s;
    }

    /**
     * Records exception and possibly propagates.
     *
     * @return status on exit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.962 -0400", hash_original_method = "84D64620D9C9FB6EDB20B35AE2A1FAF4", hash_generated_method = "743FFD33F16A4965994DB2B858F90929")
    
private int setExceptionalCompletion(Throwable ex) {
        int s = recordExceptionalCompletion(ex);
        if ((s & DONE_MASK) == EXCEPTIONAL)
            internalPropagateException(ex);
        return s;
    }

    /**
     * Hook for exception propagation support for tasks with completers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.962 -0400", hash_original_method = "0035CD39DC67FA5F01DCD8C81892B1DB", hash_generated_method = "0035CD39DC67FA5F01DCD8C81892B1DB")
    
void internalPropagateException(Throwable ex) {
    }

    /**
     * Removes exception node and clears status.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.963 -0400", hash_original_method = "685D7276C0D6116991D9737BFCAD99CC", hash_generated_method = "697CD1802F2B9FE11C1BBD11F66D7591")
    
private void clearExceptionalCompletion() {
        int h = System.identityHashCode(this);
        final ReentrantLock lock = exceptionTableLock;
        lock.lock();
        try {
            ExceptionNode[] t = exceptionTable;
            int i = h & (t.length - 1);
            ExceptionNode e = t[i];
            ExceptionNode pred = null;
            while (e != null) {
                ExceptionNode next = e.next;
                if (e.get() == this) {
                    if (pred == null)
                        t[i] = next;
                    else
                        pred.next = next;
                    break;
                }
                pred = e;
                e = next;
            }
            expungeStaleExceptions();
            status = 0;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns a rethrowable exception for the given task, if
     * available. To provide accurate stack traces, if the exception
     * was not thrown by the current thread, we try to create a new
     * exception of the same type as the one thrown, but with the
     * recorded exception as its cause. If there is no such
     * constructor, we instead try to use a no-arg constructor,
     * followed by initCause, to the same effect. If none of these
     * apply, or any fail due to other exceptions, we return the
     * recorded exception, which is still correct, although it may
     * contain a misleading stack trace.
     *
     * @return the exception, or null if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.964 -0400", hash_original_method = "7C0E75BC1CB6EA342787808207ABE365", hash_generated_method = "D9940C714F19FBD32B792B6EA6369298")
    
private Throwable getThrowableException() {
        if ((status & DONE_MASK) != EXCEPTIONAL)
            return null;
        int h = System.identityHashCode(this);
        ExceptionNode e;
        final ReentrantLock lock = exceptionTableLock;
        lock.lock();
        try {
            expungeStaleExceptions();
            ExceptionNode[] t = exceptionTable;
            e = t[h & (t.length - 1)];
            while (e != null && e.get() != this)
                e = e.next;
        } finally {
            lock.unlock();
        }
        Throwable ex;
        if (e == null || (ex = e.ex) == null)
            return null;
        if (false && e.thrower != Thread.currentThread().getId()) {
            Class<? extends Throwable> ec = ex.getClass();
            try {
                Constructor<?> noArgCtor = null;
                Constructor<?>[] cs = ec.getConstructors();// public ctors only
                for (int i = 0; i < cs.length; ++i) {
                    Constructor<?> c = cs[i];
                    Class<?>[] ps = c.getParameterTypes();
                    if (ps.length == 0)
                        noArgCtor = c;
                    else if (ps.length == 1 && ps[0] == Throwable.class)
                        return (Throwable)(c.newInstance(ex));
                }
                if (noArgCtor != null) {
                    Throwable wx = (Throwable)(noArgCtor.newInstance());
                    wx.initCause(ex);
                    return wx;
                }
            } catch (Exception ignore) {
            }
        }
        return ex;
    }

    /**
     * Throws exception, if any, associated with the given status.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.969 -0400", hash_original_method = "C0BA8A3D97CEC55CDB70BABAF2089505", hash_generated_method = "F7F1BAE68ACF7667790283C6CD24A6D9")
    
private void reportException(int s) {
        if (s == CANCELLED)
            throw new CancellationException();
        if (s == EXCEPTIONAL)
            rethrow(getThrowableException());
    }

    // public methods

    /**
     * Arranges to asynchronously execute this task in the pool the
     * current task is running in, if applicable, or using the {@link
     * ForkJoinPool#commonPool()} if not {@link #inForkJoinPool}.  While
     * it is not necessarily enforced, it is a usage error to fork a
     * task more than once unless it has completed and been
     * reinitialized.  Subsequent modifications to the state of this
     * task or any data it operates on are not necessarily
     * consistently observable by any thread other than the one
     * executing it unless preceded by a call to {@link #join} or
     * related methods, or a call to {@link #isDone} returning {@code
     * true}.
     *
     * @return {@code this}, to simplify usage
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.970 -0400", hash_original_method = "7102315CD7874246164310C2C3BA3D7B", hash_generated_method = "89FC9E034E44E5B16872E5F367662FD9")
    
public final ForkJoinTask<V> fork() {
        Thread t;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
            ((ForkJoinWorkerThread)t).workQueue.push(this);
        else
            ForkJoinPool.commonPool.externalPush(this);
        return this;
    }

    /**
     * Returns the result of the computation when it {@link #isDone is
     * done}.  This method differs from {@link #get()} in that
     * abnormal completion results in {@code RuntimeException} or
     * {@code Error}, not {@code ExecutionException}, and that
     * interrupts of the calling thread do <em>not</em> cause the
     * method to abruptly return by throwing {@code
     * InterruptedException}.
     *
     * @return the computed result
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.970 -0400", hash_original_method = "20AF7CEA70F337D4299257AF557B0E69", hash_generated_method = "E3209668F21BE718619360674061633F")
    
public final V join() {
        int s;
        if ((s = doJoin() & DONE_MASK) != NORMAL)
            reportException(s);
        return getRawResult();
    }

    /**
     * Commences performing this task, awaits its completion if
     * necessary, and returns its result, or throws an (unchecked)
     * {@code RuntimeException} or {@code Error} if the underlying
     * computation did so.
     *
     * @return the computed result
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.970 -0400", hash_original_method = "99F1E740A7B8DCFD873C4B88B1A253A1", hash_generated_method = "266BA5291F52BCFF0CAC159DFAD3F4FE")
    
public final V invoke() {
        int s;
        if ((s = doInvoke() & DONE_MASK) != NORMAL)
            reportException(s);
        return getRawResult();
    }

    /**
     * Attempts to cancel execution of this task. This attempt will
     * fail if the task has already completed or could not be
     * cancelled for some other reason. If successful, and this task
     * has not started when {@code cancel} is called, execution of
     * this task is suppressed. After this method returns
     * successfully, unless there is an intervening call to {@link
     * #reinitialize}, subsequent calls to {@link #isCancelled},
     * {@link #isDone}, and {@code cancel} will return {@code true}
     * and calls to {@link #join} and related methods will result in
     * {@code CancellationException}.
     *
     * <p>This method may be overridden in subclasses, but if so, must
     * still ensure that these properties hold. In particular, the
     * {@code cancel} method itself must not throw exceptions.
     *
     * <p>This method is designed to be invoked by <em>other</em>
     * tasks. To terminate the current task, you can just return or
     * throw an unchecked exception from its computation method, or
     * invoke {@link #completeExceptionally}.
     *
     * @param mayInterruptIfRunning this value has no effect in the
     * default implementation because interrupts are not used to
     * control cancellation.
     *
     * @return {@code true} if this task is now cancelled
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.973 -0400", hash_original_method = "9571ACD38494F0A33B32B1368AC6AFF0", hash_generated_method = "ED230A2E98E5A92EBB2141AD3D76AD1F")
    
public boolean cancel(boolean mayInterruptIfRunning) {
        return (setCompletion(CANCELLED) & DONE_MASK) == CANCELLED;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.974 -0400", hash_original_method = "D86D1628DDB7005DE62E8914ED8025FD", hash_generated_method = "1280750305EBAE832030F993D5F85279")
    
public final boolean isDone() {
        return status < 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.975 -0400", hash_original_method = "E61C112762E4C75C4159D697C2E7D6C5", hash_generated_method = "4AA5ADAEC12FF88E105965DA930F652B")
    
public final boolean isCancelled() {
        return (status & DONE_MASK) == CANCELLED;
    }

    /**
     * Returns {@code true} if this task threw an exception or was cancelled.
     *
     * @return {@code true} if this task threw an exception or was cancelled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.975 -0400", hash_original_method = "028B92C82138C7037B3A1ED96EA4659A", hash_generated_method = "866BBAF0F59C23B0516C4CC0B6C74B06")
    
public final boolean isCompletedAbnormally() {
        return status < NORMAL;
    }

    /**
     * Returns {@code true} if this task completed without throwing an
     * exception and was not cancelled.
     *
     * @return {@code true} if this task completed without throwing an
     * exception and was not cancelled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.975 -0400", hash_original_method = "2301F3CBDB61F43D07BDA723608A5F1C", hash_generated_method = "22BD1FEB359FF481B00F65A299B2DF53")
    
public final boolean isCompletedNormally() {
        return (status & DONE_MASK) == NORMAL;
    }

    /**
     * Returns the exception thrown by the base computation, or a
     * {@code CancellationException} if cancelled, or {@code null} if
     * none or if the method has not yet completed.
     *
     * @return the exception, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.976 -0400", hash_original_method = "A227BFCF59B8E0C5944438FC7259A8F9", hash_generated_method = "7528F4F72CA9E591FBAAF128ABF50E66")
    
public final Throwable getException() {
        int s = status & DONE_MASK;
        return ((s >= NORMAL)    ? null :
                (s == CANCELLED) ? new CancellationException() :
                getThrowableException());
    }

    /**
     * Completes this task abnormally, and if not already aborted or
     * cancelled, causes it to throw the given exception upon
     * {@code join} and related operations. This method may be used
     * to induce exceptions in asynchronous tasks, or to force
     * completion of tasks that would not otherwise complete.  Its use
     * in other situations is discouraged.  This method is
     * overridable, but overridden versions must invoke {@code super}
     * implementation to maintain guarantees.
     *
     * @param ex the exception to throw. If this exception is not a
     * {@code RuntimeException} or {@code Error}, the actual exception
     * thrown will be a {@code RuntimeException} with cause {@code ex}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.976 -0400", hash_original_method = "7F9B169927BBB7D65B61EB4E90A47781", hash_generated_method = "0D11C4C9B1D675F42B3F4FB210460E46")
    
public void completeExceptionally(Throwable ex) {
        setExceptionalCompletion((ex instanceof RuntimeException) ||
                                 (ex instanceof Error) ? ex :
                                 new RuntimeException(ex));
    }

    /**
     * Completes this task, and if not already aborted or cancelled,
     * returning the given value as the result of subsequent
     * invocations of {@code join} and related operations. This method
     * may be used to provide results for asynchronous tasks, or to
     * provide alternative handling for tasks that would not otherwise
     * complete normally. Its use in other situations is
     * discouraged. This method is overridable, but overridden
     * versions must invoke {@code super} implementation to maintain
     * guarantees.
     *
     * @param value the result value for this task
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.977 -0400", hash_original_method = "EFD83A63EE7F7297EC4CB296D71A3A48", hash_generated_method = "36CF559C685E543B014E02493270BF30")
    
public void complete(V value) {
        try {
            setRawResult(value);
        } catch (Throwable rex) {
            setExceptionalCompletion(rex);
            return;
        }
        setCompletion(NORMAL);
    }

    /**
     * Completes this task normally without setting a value. The most
     * recent value established by {@link #setRawResult} (or {@code
     * null} by default) will be returned as the result of subsequent
     * invocations of {@code join} and related operations.
     *
     * @since 1.8
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.977 -0400", hash_original_method = "4F10C0D8663008030E5302F256EE0773", hash_generated_method = "0B08E2F415951CACDB33342C39815AF7")
    
public final void quietlyComplete() {
        setCompletion(NORMAL);
    }

    /**
     * Waits if necessary for the computation to complete, and then
     * retrieves its result.
     *
     * @return the computed result
     * @throws CancellationException if the computation was cancelled
     * @throws ExecutionException if the computation threw an
     * exception
     * @throws InterruptedException if the current thread is not a
     * member of a ForkJoinPool and was interrupted while waiting
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.978 -0400", hash_original_method = "00D952B3ACE6B039BC98B31B44D9796C", hash_generated_method = "39CBC14E149C302FB6E211FC37D1AF67")
    
public final V get() throws InterruptedException, ExecutionException {
        int s = (Thread.currentThread() instanceof ForkJoinWorkerThread) ?
            doJoin() : externalInterruptibleAwaitDone();
        Throwable ex;
        if ((s &= DONE_MASK) == CANCELLED)
            throw new CancellationException();
        if (s == EXCEPTIONAL && (ex = getThrowableException()) != null)
            throw new ExecutionException(ex);
        return getRawResult();
    }

    /**
     * Waits if necessary for at most the given time for the computation
     * to complete, and then retrieves its result, if available.
     *
     * @param timeout the maximum time to wait
     * @param unit the time unit of the timeout argument
     * @return the computed result
     * @throws CancellationException if the computation was cancelled
     * @throws ExecutionException if the computation threw an
     * exception
     * @throws InterruptedException if the current thread is not a
     * member of a ForkJoinPool and was interrupted while waiting
     * @throws TimeoutException if the wait timed out
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.979 -0400", hash_original_method = "6D8A147E2AA6D126583CA17D42160A97", hash_generated_method = "7E2FCEC4661804231A635633C2CDB5BD")
    
public final V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException {
        if (Thread.interrupted())
            throw new InterruptedException();
        // Messy in part because we measure in nanosecs, but wait in millisecs
        int s; long ms;
        long ns = unit.toNanos(timeout);
        if ((s = status) >= 0 && ns > 0L) {
            long deadline = System.nanoTime() + ns;
            ForkJoinPool p = null;
            ForkJoinPool.WorkQueue w = null;
            Thread t = Thread.currentThread();
            if (t instanceof ForkJoinWorkerThread) {
                ForkJoinWorkerThread wt = (ForkJoinWorkerThread)t;
                p = wt.pool;
                w = wt.workQueue;
                p.helpJoinOnce(w, this); // no retries on failure
            }
            else
                ForkJoinPool.externalHelpJoin(this);
            boolean canBlock = false;
            boolean interrupted = false;
            try {
                while ((s = status) >= 0) {
                    if (w != null && w.qlock < 0)
                        cancelIgnoringExceptions(this);
                    else if (!canBlock) {
                        if (p == null || p.tryCompensate())
                            canBlock = true;
                    }
                    else {
                        if ((ms = TimeUnit.NANOSECONDS.toMillis(ns)) > 0L &&
                            U.compareAndSwapInt(this, STATUS, s, s | SIGNAL)) {
                            synchronized (this) {
                                if (status >= 0) {
                                    try {
                                        wait(ms);
                                    } catch (InterruptedException ie) {
                                        if (p == null)
                                            interrupted = true;
                                    }
                                }
                                else
                                    notifyAll();
                            }
                        }
                        if ((s = status) < 0 || interrupted ||
                            (ns = deadline - System.nanoTime()) <= 0L)
                            break;
                    }
                }
            } finally {
                if (p != null && canBlock)
                    p.incrementActiveCount();
            }
            if (interrupted)
                throw new InterruptedException();
        }
        if ((s &= DONE_MASK) != NORMAL) {
            Throwable ex;
            if (s == CANCELLED)
                throw new CancellationException();
            if (s != EXCEPTIONAL)
                throw new TimeoutException();
            if ((ex = getThrowableException()) != null)
                throw new ExecutionException(ex);
        }
        return getRawResult();
    }

    /**
     * Joins this task, without returning its result or throwing its
     * exception. This method may be useful when processing
     * collections of tasks when some have been cancelled or otherwise
     * known to have aborted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.979 -0400", hash_original_method = "ED8831CBD1682BD3D130A30E565B25EE", hash_generated_method = "5AD71C00B71CF9CDA755B4C5C96701F7")
    
public final void quietlyJoin() {
        doJoin();
    }

    /**
     * Commences performing this task and awaits its completion if
     * necessary, without returning its result or throwing its
     * exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.980 -0400", hash_original_method = "971A37209724E0B5EE10AD9FB03E30A3", hash_generated_method = "16591E37B0E2B6323148D7837D5CEC31")
    
public final void quietlyInvoke() {
        doInvoke();
    }

    /**
     * Resets the internal bookkeeping state of this task, allowing a
     * subsequent {@code fork}. This method allows repeated reuse of
     * this task, but only if reuse occurs when this task has either
     * never been forked, or has been forked, then completed and all
     * outstanding joins of this task have also completed. Effects
     * under any other usage conditions are not guaranteed.
     * This method may be useful when executing
     * pre-constructed trees of subtasks in loops.
     *
     * <p>Upon completion of this method, {@code isDone()} reports
     * {@code false}, and {@code getException()} reports {@code
     * null}. However, the value returned by {@code getRawResult} is
     * unaffected. To clear this value, you can invoke {@code
     * setRawResult(null)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.981 -0400", hash_original_method = "F15D341972D18CC277AE4077B8DA588B", hash_generated_method = "8EE43CA222B47B11F03D206AB565325B")
    
public void reinitialize() {
        if ((status & DONE_MASK) == EXCEPTIONAL)
            clearExceptionalCompletion();
        else
            status = 0;
    }

    /**
     * Tries to unschedule this task for execution. This method will
     * typically (but is not guaranteed to) succeed if this task is
     * the most recently forked task by the current thread, and has
     * not commenced executing in another thread.  This method may be
     * useful when arranging alternative local processing of tasks
     * that could have been, but were not, stolen.
     *
     * @return {@code true} if unforked
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.982 -0400", hash_original_method = "F9E996348FA355313A5F787CB0E78A90", hash_generated_method = "84CB869B5EC3EB1DAD9D0A4F401596B9")
    
public boolean tryUnfork() {
        Thread t;
        return (((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
                ((ForkJoinWorkerThread)t).workQueue.tryUnpush(this) :
                ForkJoinPool.tryExternalUnpush(this));
    }

    /**
     * Adaptor for Runnables. This implements RunnableFuture
     * to be compliant with AbstractExecutorService constraints
     * when used in ForkJoinPool.
     */
    static final class AdaptedRunnable<T> extends ForkJoinTask<T>
        implements RunnableFuture<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.990 -0400", hash_original_field = "B11275085B996519751B382FD79C8610", hash_generated_field = "353F55E1158E469CECEF202F9D0099A5")

        private static final long serialVersionUID = 5232453952276885070L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.987 -0400", hash_original_field = "4117C8DC82346F93DA34D082B62134E4", hash_generated_field = "4117C8DC82346F93DA34D082B62134E4")

         Runnable runnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.987 -0400", hash_original_field = "8B901F4123EF91F350535EEC5A55F787", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

        T result;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.987 -0400", hash_original_method = "87FB609412CBA6E16A82FB257E02A3B4", hash_generated_method = "7669E728D1884790617007849EA710C5")
        
AdaptedRunnable(Runnable runnable, T result) {
            if (runnable == null) throw new NullPointerException();
            this.runnable = runnable;
            this.result = result; // OK to set this even before completion
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.988 -0400", hash_original_method = "A849226714E8F5D6D33CBC798602A34C", hash_generated_method = "05540C6CE10E431938F18B376B801E71")
        
public final T getRawResult() { return result; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.989 -0400", hash_original_method = "1211CDEF0D6DEE1A109C46FBD1722EE6", hash_generated_method = "7ED10FE187D61EE060A144A85BAF63F6")
        
public final void setRawResult(T v) { result = v; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.989 -0400", hash_original_method = "289A5CFDA72934865A52E399F9C60D22", hash_generated_method = "D8C5948E09C39FE557D82784D2707D6B")
        
public final boolean exec() { runnable.run(); return true; }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.989 -0400", hash_original_method = "D190CF0A5358D62BF7A95C7D675551E8", hash_generated_method = "8B592C61A703DD1A610CFFAD9C49A547")
        
public final void run() { invoke(); }
    }

    /**
     * Adaptor for Runnables without results
     */
    static final class AdaptedRunnableAction extends ForkJoinTask<Void>
        implements RunnableFuture<Void> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.993 -0400", hash_original_field = "B11275085B996519751B382FD79C8610", hash_generated_field = "353F55E1158E469CECEF202F9D0099A5")

        private static final long serialVersionUID = 5232453952276885070L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.991 -0400", hash_original_field = "4117C8DC82346F93DA34D082B62134E4", hash_generated_field = "4117C8DC82346F93DA34D082B62134E4")

         Runnable runnable;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.991 -0400", hash_original_method = "16B754A745EE56278AE50A12CD7A7FD8", hash_generated_method = "16B754A745EE56278AE50A12CD7A7FD8")
        
AdaptedRunnableAction(Runnable runnable) {
            if (runnable == null) throw new NullPointerException();
            this.runnable = runnable;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.992 -0400", hash_original_method = "3DE82AA92F6CBDFB2CF4126D370439F9", hash_generated_method = "3F97477252B0C202F30FC22FA92A0B8B")
        
public final Void getRawResult() { return null; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.992 -0400", hash_original_method = "3BA30920313CDC29C96647ED1B942491", hash_generated_method = "F1FC992E8CB1699E649A565812CB9650")
        
public final void setRawResult(Void v) { }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.992 -0400", hash_original_method = "289A5CFDA72934865A52E399F9C60D22", hash_generated_method = "D8C5948E09C39FE557D82784D2707D6B")
        
public final boolean exec() { runnable.run(); return true; }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.993 -0400", hash_original_method = "D190CF0A5358D62BF7A95C7D675551E8", hash_generated_method = "8B592C61A703DD1A610CFFAD9C49A547")
        
public final void run() { invoke(); }
    }

    /**
     * Adaptor for Callables
     */
    static final class AdaptedCallable<T> extends ForkJoinTask<T>
        implements RunnableFuture<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.997 -0400", hash_original_field = "44C63BAE7BA2B1137C2D63E169FE178F", hash_generated_field = "72AC738511B0E61ACBCE35E10DEB946B")

        private static final long serialVersionUID = 2838392045355241008L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.994 -0400", hash_original_field = "FA994FEF02A383E82D4565B31BBC66DF", hash_generated_field = "FA994FEF02A383E82D4565B31BBC66DF")

         Callable<? extends T> callable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.995 -0400", hash_original_field = "8B901F4123EF91F350535EEC5A55F787", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

        T result;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.995 -0400", hash_original_method = "7A00E1616C83D5B72703C8E243CCC2FF", hash_generated_method = "7A00E1616C83D5B72703C8E243CCC2FF")
        
AdaptedCallable(Callable<? extends T> callable) {
            if (callable == null) throw new NullPointerException();
            this.callable = callable;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.995 -0400", hash_original_method = "A849226714E8F5D6D33CBC798602A34C", hash_generated_method = "05540C6CE10E431938F18B376B801E71")
        
public final T getRawResult() { return result; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.996 -0400", hash_original_method = "1211CDEF0D6DEE1A109C46FBD1722EE6", hash_generated_method = "7ED10FE187D61EE060A144A85BAF63F6")
        
public final void setRawResult(T v) { result = v; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.996 -0400", hash_original_method = "DE6E23BBB38B574761E25CA3B7C59A95", hash_generated_method = "C41B3DFACA4769811472DD86B5972F8A")
        
public final boolean exec() {
            try {
                result = callable.call();
                return true;
            } catch (Error err) {
                throw err;
            } catch (RuntimeException rex) {
                throw rex;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.996 -0400", hash_original_method = "D190CF0A5358D62BF7A95C7D675551E8", hash_generated_method = "8B592C61A703DD1A610CFFAD9C49A547")
        
public final void run() { invoke(); }
    }

    // Extension methods

    /**
     * Returns the result that would be returned by {@link #join}, even
     * if this task completed abnormally, or {@code null} if this task
     * is not known to have been completed.  This method is designed
     * to aid debugging, as well as to support extensions. Its use in
     * any other context is discouraged.
     *
     * @return the result, or {@code null} if not completed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.983 -0400", hash_original_method = "C8927AF4AE39B87CDDF52D74D1711D68", hash_generated_method = "A3ECB1951BC62912C64F9444BCE4931F")
    
public abstract V getRawResult();

    /**
     * Forces the given value to be returned as a result.  This method
     * is designed to support extensions, and should not in general be
     * called otherwise.
     *
     * @param value the value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.983 -0400", hash_original_method = "441F3C64C560777CDE429F9E475A46AA", hash_generated_method = "E27B2B389C93689A2C37134B92687C7B")
    
protected abstract void setRawResult(V value);

    /**
     * Immediately performs the base action of this task and returns
     * true if, upon return from this method, this task is guaranteed
     * to have completed normally. This method may return false
     * otherwise, to indicate that this task is not necessarily
     * complete (or is not known to be complete), for example in
     * asynchronous actions that require explicit invocations of
     * completion methods. This method may also throw an (unchecked)
     * exception to indicate abnormal exit. This method is designed to
     * support extensions, and should not in general be called
     * otherwise.
     *
     * @return {@code true} if this task is known to have completed normally
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.984 -0400", hash_original_method = "78BAC18068E36E7B1F46CE1882891FF1", hash_generated_method = "9237D37B1CC27BFA7EA04F95F41AA0CD")
    
protected abstract boolean exec();

    // tag operations

    /**
     * Returns the tag for this task.
     *
     * @return the tag for this task
     * @since 1.8
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.985 -0400", hash_original_method = "0CB9C49E6C1B90326E3DF8541F99A5C8", hash_generated_method = "231D0857155558C7B871CF9870504246")
    
public final short getForkJoinTaskTag() {
        return (short)status;
    }

    /**
     * Atomically sets the tag value for this task.
     *
     * @param tag the tag value
     * @return the previous value of the tag
     * @since 1.8
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.986 -0400", hash_original_method = "AC37481DED91787CCB4BA76F6D6D6B96", hash_generated_method = "39FDC7FA0515A941B0D7FA0747CE5DCF")
    
public final short setForkJoinTaskTag(short tag) {
        for (int s;;) {
            if (U.compareAndSwapInt(this, STATUS, s = status,
                                    (s & ~SMASK) | (tag & SMASK)))
                return (short)s;
        }
    }

    /**
     * Atomically conditionally sets the tag value for this task.
     * Among other applications, tags can be used as visit markers
     * in tasks operating on graphs, as in methods that check: {@code
     * if (task.compareAndSetForkJoinTaskTag((short)0, (short)1))}
     * before processing, otherwise exiting because the node has
     * already been visited.
     *
     * @param e the expected tag value
     * @param tag the new tag value
     * @return true if successful; i.e., the current value was
     * equal to e and is now tag.
     * @since 1.8
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.986 -0400", hash_original_method = "FF2F5F4D0C1318C7E587B0BB55991972", hash_generated_method = "2A073B74D608653A2445C8C92CD33993")
    
public final boolean compareAndSetForkJoinTaskTag(short e, short tag) {
        for (int s;;) {
            if ((short)(s = status) != e)
                return false;
            if (U.compareAndSwapInt(this, STATUS, s,
                                    (s & ~SMASK) | (tag & SMASK)))
                return true;
        }
    }

    /**
     * Saves this task to a stream (that is, serializes it).
     *
     * @serialData the current run status and the exception thrown
     * during execution, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:18.999 -0400", hash_original_method = "8F5BD14A66EE7B44655B971A6D72FEFB", hash_generated_method = "0048D2B159F962CF5C22A8C49B120F39")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        s.defaultWriteObject();
        s.writeObject(getException());
    }

    /**
     * Reconstitutes this task from a stream (that is, deserializes it).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.000 -0400", hash_original_method = "D3B1CEBE62AA967C97F907B53EBD5BC4", hash_generated_method = "C5E5CBB3ED7E5CF28F0359C0614B9E66")
    
private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        Object ex = s.readObject();
        if (ex != null)
            setExceptionalCompletion((Throwable)ex);
    }

    static {
        exceptionTableLock = new ReentrantLock();
        exceptionTableRefQueue = new ReferenceQueue<Object>();
        exceptionTable = new ExceptionNode[EXCEPTION_MAP_CAPACITY];
        try {
            U = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ForkJoinTask.class;
            STATUS = U.objectFieldOffset
                (k.getDeclaredField("status"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

}
