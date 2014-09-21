/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

/**
 * A {@link ForkJoinTask} with a completion action performed when
 * triggered and there are no remaining pending
 * actions. CountedCompleters are in general more robust in the
 * presence of subtask stalls and blockage than are other forms of
 * ForkJoinTasks, but are less intuitive to program.  Uses of
 * CountedCompleter are similar to those of other completion based
 * components (such as {@link java.nio.channels.CompletionHandler})
 * except that multiple <em>pending</em> completions may be necessary
 * to trigger the completion action {@link #onCompletion}, not just one.
 * Unless initialized otherwise, the {@linkplain #getPendingCount pending
 * count} starts at zero, but may be (atomically) changed using
 * methods {@link #setPendingCount}, {@link #addToPendingCount}, and
 * {@link #compareAndSetPendingCount}. Upon invocation of {@link
 * #tryComplete}, if the pending action count is nonzero, it is
 * decremented; otherwise, the completion action is performed, and if
 * this completer itself has a completer, the process is continued
 * with its completer.  As is the case with related synchronization
 * components such as {@link java.util.concurrent.Phaser Phaser} and
 * {@link java.util.concurrent.Semaphore Semaphore}, these methods
 * affect only internal counts; they do not establish any further
 * internal bookkeeping. In particular, the identities of pending
 * tasks are not maintained. As illustrated below, you can create
 * subclasses that do record some or all pending tasks or their
 * results when needed.  As illustrated below, utility methods
 * supporting customization of completion traversals are also
 * provided. However, because CountedCompleters provide only basic
 * synchronization mechanisms, it may be useful to create further
 * abstract subclasses that maintain linkages, fields, and additional
 * support methods appropriate for a set of related usages.
 *
 * <p>A concrete CountedCompleter class must define method {@link
 * #compute}, that should in most cases (as illustrated below), invoke
 * {@code tryComplete()} once before returning. The class may also
 * optionally override method {@link #onCompletion} to perform an
 * action upon normal completion, and method {@link
 * #onExceptionalCompletion} to perform an action upon any exception.
 *
 * <p>CountedCompleters most often do not bear results, in which case
 * they are normally declared as {@code CountedCompleter<Void>}, and
 * will always return {@code null} as a result value.  In other cases,
 * you should override method {@link #getRawResult} to provide a
 * result from {@code join(), invoke()}, and related methods.  In
 * general, this method should return the value of a field (or a
 * function of one or more fields) of the CountedCompleter object that
 * holds the result upon completion. Method {@link #setRawResult} by
 * default plays no role in CountedCompleters.  It is possible, but
 * rarely applicable, to override this method to maintain other
 * objects or fields holding result data.
 *
 * <p>A CountedCompleter that does not itself have a completer (i.e.,
 * one for which {@link #getCompleter} returns {@code null}) can be
 * used as a regular ForkJoinTask with this added functionality.
 * However, any completer that in turn has another completer serves
 * only as an internal helper for other computations, so its own task
 * status (as reported in methods such as {@link ForkJoinTask#isDone})
 * is arbitrary; this status changes only upon explicit invocations of
 * {@link #complete}, {@link ForkJoinTask#cancel}, {@link
 * ForkJoinTask#completeExceptionally} or upon exceptional completion
 * of method {@code compute}. Upon any exceptional completion, the
 * exception may be relayed to a task's completer (and its completer,
 * and so on), if one exists and it has not otherwise already
 * completed. Similarly, cancelling an internal CountedCompleter has
 * only a local effect on that completer, so is not often useful.
 *
 * <p><b>Sample Usages.</b>
 *
 * <p><b>Parallel recursive decomposition.</b> CountedCompleters may
 * be arranged in trees similar to those often used with {@link
 * RecursiveAction}s, although the constructions involved in setting
 * them up typically vary. Here, the completer of each task is its
 * parent in the computation tree. Even though they entail a bit more
 * bookkeeping, CountedCompleters may be better choices when applying
 * a possibly time-consuming operation (that cannot be further
 * subdivided) to each element of an array or collection; especially
 * when the operation takes a significantly different amount of time
 * to complete for some elements than others, either because of
 * intrinsic variation (for example I/O) or auxiliary effects such as
 * garbage collection.  Because CountedCompleters provide their own
 * continuations, other threads need not block waiting to perform
 * them.
 *
 * <p>For example, here is an initial version of a class that uses
 * divide-by-two recursive decomposition to divide work into single
 * pieces (leaf tasks). Even when work is split into individual calls,
 * tree-based techniques are usually preferable to directly forking
 * leaf tasks, because they reduce inter-thread communication and
 * improve load balancing. In the recursive case, the second of each
 * pair of subtasks to finish triggers completion of its parent
 * (because no result combination is performed, the default no-op
 * implementation of method {@code onCompletion} is not overridden). A
 * static utility method sets up the base task and invokes it
 * (here, implicitly using the {@link ForkJoinPool#commonPool()}).
 *
 * <pre> {@code
 * class MyOperation<E> { void apply(E e) { ... }  }
 *
 * class ForEach<E> extends CountedCompleter<Void> {
 *
 *   public static <E> void forEach(E[] array, MyOperation<E> op) {
 *     new ForEach<E>(null, array, op, 0, array.length).invoke();
 *   }
 *
 *   final E[] array; final MyOperation<E> op; final int lo, hi;
 *   ForEach(CountedCompleter<?> p, E[] array, MyOperation<E> op, int lo, int hi) {
 *     super(p);
 *     this.array = array; this.op = op; this.lo = lo; this.hi = hi;
 *   }
 *
 *   public void compute() { // version 1
 *     if (hi - lo >= 2) {
 *       int mid = (lo + hi) >>> 1;
 *       setPendingCount(2); // must set pending count before fork
 *       new ForEach(this, array, op, mid, hi).fork(); // right child
 *       new ForEach(this, array, op, lo, mid).fork(); // left child
 *     }
 *     else if (hi > lo)
 *       op.apply(array[lo]);
 *     tryComplete();
 *   }
 * }}</pre>
 *
 * This design can be improved by noticing that in the recursive case,
 * the task has nothing to do after forking its right task, so can
 * directly invoke its left task before returning. (This is an analog
 * of tail recursion removal.)  Also, because the task returns upon
 * executing its left task (rather than falling through to invoke
 * {@code tryComplete}) the pending count is set to one:
 *
 * <pre> {@code
 * class ForEach<E> ...
 *   public void compute() { // version 2
 *     if (hi - lo >= 2) {
 *       int mid = (lo + hi) >>> 1;
 *       setPendingCount(1); // only one pending
 *       new ForEach(this, array, op, mid, hi).fork(); // right child
 *       new ForEach(this, array, op, lo, mid).compute(); // direct invoke
 *     }
 *     else {
 *       if (hi > lo)
 *         op.apply(array[lo]);
 *       tryComplete();
 *     }
 *   }
 * }</pre>
 *
 * As a further improvement, notice that the left task need not even
 * exist.  Instead of creating a new one, we can iterate using the
 * original task, and add a pending count for each fork. Additionally,
 * because no task in this tree implements an {@link #onCompletion}
 * method, {@code tryComplete()} can be replaced with {@link
 * #propagateCompletion}.
 *
 * <pre> {@code
 * class ForEach<E> ...
 *   public void compute() { // version 3
 *     int l = lo,  h = hi;
 *     while (h - l >= 2) {
 *       int mid = (l + h) >>> 1;
 *       addToPendingCount(1);
 *       new ForEach(this, array, op, mid, h).fork(); // right child
 *       h = mid;
 *     }
 *     if (h > l)
 *       op.apply(array[l]);
 *     propagateCompletion();
 *   }
 * }</pre>
 *
 * Additional improvements of such classes might entail precomputing
 * pending counts so that they can be established in constructors,
 * specializing classes for leaf steps, subdividing by say, four,
 * instead of two per iteration, and using an adaptive threshold
 * instead of always subdividing down to single elements.
 *
 * <p><b>Searching.</b> A tree of CountedCompleters can search for a
 * value or property in different parts of a data structure, and
 * report a result in an {@link
 * java.util.concurrent.atomic.AtomicReference AtomicReference} as
 * soon as one is found. The others can poll the result to avoid
 * unnecessary work. (You could additionally {@linkplain #cancel
 * cancel} other tasks, but it is usually simpler and more efficient
 * to just let them notice that the result is set and if so skip
 * further processing.)  Illustrating again with an array using full
 * partitioning (again, in practice, leaf tasks will almost always
 * process more than one element):
 *
 * <pre> {@code
 * class Searcher<E> extends CountedCompleter<E> {
 *   final E[] array; final AtomicReference<E> result; final int lo, hi;
 *   Searcher(CountedCompleter<?> p, E[] array, AtomicReference<E> result, int lo, int hi) {
 *     super(p);
 *     this.array = array; this.result = result; this.lo = lo; this.hi = hi;
 *   }
 *   public E getRawResult() { return result.get(); }
 *   public void compute() { // similar to ForEach version 3
 *     int l = lo,  h = hi;
 *     while (result.get() == null && h >= l) {
 *       if (h - l >= 2) {
 *         int mid = (l + h) >>> 1;
 *         addToPendingCount(1);
 *         new Searcher(this, array, result, mid, h).fork();
 *         h = mid;
 *       }
 *       else {
 *         E x = array[l];
 *         if (matches(x) && result.compareAndSet(null, x))
 *           quietlyCompleteRoot(); // root task is now joinable
 *         break;
 *       }
 *     }
 *     tryComplete(); // normally complete whether or not found
 *   }
 *   boolean matches(E e) { ... } // return true if found
 *
 *   public static <E> E search(E[] array) {
 *       return new Searcher<E>(null, array, new AtomicReference<E>(), 0, array.length).invoke();
 *   }
 * }}</pre>
 *
 * In this example, as well as others in which tasks have no other
 * effects except to compareAndSet a common result, the trailing
 * unconditional invocation of {@code tryComplete} could be made
 * conditional ({@code if (result.get() == null) tryComplete();})
 * because no further bookkeeping is required to manage completions
 * once the root task completes.
 *
 * <p><b>Recording subtasks.</b> CountedCompleter tasks that combine
 * results of multiple subtasks usually need to access these results
 * in method {@link #onCompletion}. As illustrated in the following
 * class (that performs a simplified form of map-reduce where mappings
 * and reductions are all of type {@code E}), one way to do this in
 * divide and conquer designs is to have each subtask record its
 * sibling, so that it can be accessed in method {@code onCompletion}.
 * This technique applies to reductions in which the order of
 * combining left and right results does not matter; ordered
 * reductions require explicit left/right designations.  Variants of
 * other streamlinings seen in the above examples may also apply.
 *
 * <pre> {@code
 * class MyMapper<E> { E apply(E v) {  ...  } }
 * class MyReducer<E> { E apply(E x, E y) {  ...  } }
 * class MapReducer<E> extends CountedCompleter<E> {
 *   final E[] array; final MyMapper<E> mapper;
 *   final MyReducer<E> reducer; final int lo, hi;
 *   MapReducer<E> sibling;
 *   E result;
 *   MapReducer(CountedCompleter<?> p, E[] array, MyMapper<E> mapper,
 *              MyReducer<E> reducer, int lo, int hi) {
 *     super(p);
 *     this.array = array; this.mapper = mapper;
 *     this.reducer = reducer; this.lo = lo; this.hi = hi;
 *   }
 *   public void compute() {
 *     if (hi - lo >= 2) {
 *       int mid = (lo + hi) >>> 1;
 *       MapReducer<E> left = new MapReducer(this, array, mapper, reducer, lo, mid);
 *       MapReducer<E> right = new MapReducer(this, array, mapper, reducer, mid, hi);
 *       left.sibling = right;
 *       right.sibling = left;
 *       setPendingCount(1); // only right is pending
 *       right.fork();
 *       left.compute();     // directly execute left
 *     }
 *     else {
 *       if (hi > lo)
 *           result = mapper.apply(array[lo]);
 *       tryComplete();
 *     }
 *   }
 *   public void onCompletion(CountedCompleter<?> caller) {
 *     if (caller != this) {
 *       MapReducer<E> child = (MapReducer<E>)caller;
 *       MapReducer<E> sib = child.sibling;
 *       if (sib == null || sib.result == null)
 *         result = child.result;
 *       else
 *         result = reducer.apply(child.result, sib.result);
 *     }
 *   }
 *   public E getRawResult() { return result; }
 *
 *   public static <E> E mapReduce(E[] array, MyMapper<E> mapper, MyReducer<E> reducer) {
 *     return new MapReducer<E>(null, array, mapper, reducer,
 *                              0, array.length).invoke();
 *   }
 * }}</pre>
 *
 * Here, method {@code onCompletion} takes a form common to many
 * completion designs that combine results. This callback-style method
 * is triggered once per task, in either of the two different contexts
 * in which the pending count is, or becomes, zero: (1) by a task
 * itself, if its pending count is zero upon invocation of {@code
 * tryComplete}, or (2) by any of its subtasks when they complete and
 * decrement the pending count to zero. The {@code caller} argument
 * distinguishes cases.  Most often, when the caller is {@code this},
 * no action is necessary. Otherwise the caller argument can be used
 * (usually via a cast) to supply a value (and/or links to other
 * values) to be combined.  Assuming proper use of pending counts, the
 * actions inside {@code onCompletion} occur (once) upon completion of
 * a task and its subtasks. No additional synchronization is required
 * within this method to ensure thread safety of accesses to fields of
 * this task or other completed tasks.
 *
 * <p><b>Completion Traversals</b>. If using {@code onCompletion} to
 * process completions is inapplicable or inconvenient, you can use
 * methods {@link #firstComplete} and {@link #nextComplete} to create
 * custom traversals.  For example, to define a MapReducer that only
 * splits out right-hand tasks in the form of the third ForEach
 * example, the completions must cooperatively reduce along
 * unexhausted subtask links, which can be done as follows:
 *
 * <pre> {@code
 * class MapReducer<E> extends CountedCompleter<E> { // version 2
 *   final E[] array; final MyMapper<E> mapper;
 *   final MyReducer<E> reducer; final int lo, hi;
 *   MapReducer<E> forks, next; // record subtask forks in list
 *   E result;
 *   MapReducer(CountedCompleter<?> p, E[] array, MyMapper<E> mapper,
 *              MyReducer<E> reducer, int lo, int hi, MapReducer<E> next) {
 *     super(p);
 *     this.array = array; this.mapper = mapper;
 *     this.reducer = reducer; this.lo = lo; this.hi = hi;
 *     this.next = next;
 *   }
 *   public void compute() {
 *     int l = lo,  h = hi;
 *     while (h - l >= 2) {
 *       int mid = (l + h) >>> 1;
 *       addToPendingCount(1);
 *       (forks = new MapReducer(this, array, mapper, reducer, mid, h, forks)).fork();
 *       h = mid;
 *     }
 *     if (h > l)
 *       result = mapper.apply(array[l]);
 *     // process completions by reducing along and advancing subtask links
 *     for (CountedCompleter<?> c = firstComplete(); c != null; c = c.nextComplete()) {
 *       for (MapReducer t = (MapReducer)c, s = t.forks;  s != null; s = t.forks = s.next)
 *         t.result = reducer.apply(t.result, s.result);
 *     }
 *   }
 *   public E getRawResult() { return result; }
 *
 *   public static <E> E mapReduce(E[] array, MyMapper<E> mapper, MyReducer<E> reducer) {
 *     return new MapReducer<E>(null, array, mapper, reducer,
 *                              0, array.length, null).invoke();
 *   }
 * }}</pre>
 *
 * <p><b>Triggers.</b> Some CountedCompleters are themselves never
 * forked, but instead serve as bits of plumbing in other designs;
 * including those in which the completion of one of more async tasks
 * triggers another async task. For example:
 *
 * <pre> {@code
 * class HeaderBuilder extends CountedCompleter<...> { ... }
 * class BodyBuilder extends CountedCompleter<...> { ... }
 * class PacketSender extends CountedCompleter<...> {
 *   PacketSender(...) { super(null, 1); ... } // trigger on second completion
 *   public void compute() { } // never called
 *   public void onCompletion(CountedCompleter<?> caller) { sendPacket(); }
 * }
 * // sample use:
 * PacketSender p = new PacketSender();
 * new HeaderBuilder(p, ...).fork();
 * new BodyBuilder(p, ...).fork();
 * }</pre>
 *
 * @since 1.8
 * @hide
 * @author Doug Lea
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class CountedCompleter<T> extends ForkJoinTask<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.887 -0400", hash_original_field = "8F48F2F9CC1C134D01BD7FD533AE0769", hash_generated_field = "91836EC85879D023FC7B96F7809E4FC7")

    private static final long serialVersionUID = 5232453752276485070L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.897 -0400", hash_original_field = "71C0AF9A8855A18D8CEED7E5A0A347BB", hash_generated_field = "E1D673985FF3F8FAC5355C138B0EC615")

    private static  sun.misc.Unsafe U;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.898 -0400", hash_original_field = "F59A6E9578B8371AC7AC2C5186AABC01", hash_generated_field = "9AF59CF5590958ABDD3D90E00E730449")

    private static  long PENDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.887 -0400", hash_original_field = "31226D59BD15E19F984965E72746DFD4", hash_generated_field = "31226D59BD15E19F984965E72746DFD4")

     CountedCompleter<?> completer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.887 -0400", hash_original_field = "90596AD6C3A72AF917407764D52AC94C", hash_generated_field = "A9E4B10484AAA38312699D5569D6FB3E")

    volatile int pending;

    /**
     * Creates a new CountedCompleter with the given completer
     * and initial pending count.
     *
     * @param completer this task's completer, or {@code null} if none
     * @param initialPendingCount the initial pending count
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.888 -0400", hash_original_method = "C8E3587DA0CD5323690D8772DFCF51A1", hash_generated_method = "17EC10977D3957090CBDB6011DFB5FEC")
    
protected CountedCompleter(CountedCompleter<?> completer,
                               int initialPendingCount) {
        this.completer = completer;
        this.pending = initialPendingCount;
    }

    /**
     * Creates a new CountedCompleter with the given completer
     * and an initial pending count of zero.
     *
     * @param completer this task's completer, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.888 -0400", hash_original_method = "6C126C0B10CB0EA89F99786C02A81989", hash_generated_method = "DBAAFC9DCC5AD22702E1E2C13877432A")
    
protected CountedCompleter(CountedCompleter<?> completer) {
        this.completer = completer;
    }

    /**
     * Creates a new CountedCompleter with no completer
     * and an initial pending count of zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.889 -0400", hash_original_method = "79CEFF419DD418AEF7FB0BB15414856A", hash_generated_method = "856B0A2463D95BCDA405444DDA518FAF")
    
protected CountedCompleter() {
        this.completer = null;
    }

    /**
     * The main computation performed by this task.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.890 -0400", hash_original_method = "3472BCA0870D21FCBDB4784495B49568", hash_generated_method = "F2EDEB236AE00C012E742E66443BAD1E")
    
public abstract void compute();

    /**
     * Performs an action when method {@link #tryComplete} is invoked
     * and the pending count is zero, or when the unconditional
     * method {@link #complete} is invoked.  By default, this method
     * does nothing. You can distinguish cases by checking the
     * identity of the given caller argument. If not equal to {@code
     * this}, then it is typically a subtask that may contain results
     * (and/or links to other results) to combine.
     *
     * @param caller the task invoking this method (which may
     * be this task itself)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.890 -0400", hash_original_method = "CD6A77A861EB82BECC50EE17FB3320CE", hash_generated_method = "5AAEEA4DC20DB3CEE0FF57D82B611DE6")
    
public void onCompletion(CountedCompleter<?> caller) {
    }

    /**
     * Performs an action when method {@link #completeExceptionally}
     * is invoked or method {@link #compute} throws an exception, and
     * this task has not otherwise already completed normally. On
     * entry to this method, this task {@link
     * ForkJoinTask#isCompletedAbnormally}.  The return value of this
     * method controls further propagation: If {@code true} and this
     * task has a completer, then this completer is also completed
     * exceptionally.  The default implementation of this method does
     * nothing except return {@code true}.
     *
     * @param ex the exception
     * @param caller the task invoking this method (which may
     * be this task itself)
     * @return true if this exception should be propagated to this
     * task's completer, if one exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.890 -0400", hash_original_method = "26A2D043FC51EECD91A891B0755BEB93", hash_generated_method = "456A39AAD397113A67E2BF581BD12CCE")
    
public boolean onExceptionalCompletion(Throwable ex, CountedCompleter<?> caller) {
        return true;
    }

    /**
     * Returns the completer established in this task's constructor,
     * or {@code null} if none.
     *
     * @return the completer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.891 -0400", hash_original_method = "47E856C1A8FD81B2A45ED2B1BB141CF3", hash_generated_method = "6EC1D18716BAC523DAC0197AEE13FC37")
    
public final CountedCompleter<?> getCompleter() {
        return completer;
    }

    /**
     * Returns the current pending count.
     *
     * @return the current pending count
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.891 -0400", hash_original_method = "78331CA0E9D34FD6C44DC5ED0770737E", hash_generated_method = "E06406F1D29996B2A4F01F7497AF9C7C")
    
public final int getPendingCount() {
        return pending;
    }

    /**
     * Sets the pending count to the given value.
     *
     * @param count the count
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.891 -0400", hash_original_method = "12A3F390B28EB9547AC4DFC5F6ADF995", hash_generated_method = "9804A5DE2FC81BDD29DBC6B2252194E6")
    
public final void setPendingCount(int count) {
        pending = count;
    }

    /**
     * Adds (atomically) the given value to the pending count.
     *
     * @param delta the value to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.892 -0400", hash_original_method = "29C17F44894B0CBE4A730B9B9B786E49", hash_generated_method = "FADF473A446B69DF98DA6944FA78CF91")
    
public final void addToPendingCount(int delta) {
        int c; // note: can replace with intrinsic in jdk8
        do {} while (!U.compareAndSwapInt(this, PENDING, c = pending, c+delta));
    }

    /**
     * Sets (atomically) the pending count to the given count only if
     * it currently holds the given expected value.
     *
     * @param expected the expected value
     * @param count the new value
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.892 -0400", hash_original_method = "5C9F021321A647F993211B2744EBDFC7", hash_generated_method = "3190D0F15C65C1FA5B254438030D2A57")
    
public final boolean compareAndSetPendingCount(int expected, int count) {
        return U.compareAndSwapInt(this, PENDING, expected, count);
    }

    /**
     * If the pending count is nonzero, (atomically) decrements it.
     *
     * @return the initial (undecremented) pending count holding on entry
     * to this method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.892 -0400", hash_original_method = "EA1BAF3B68F54B54735553BEA631BA54", hash_generated_method = "81DB7E7C219E7257F0D611F53A61F02A")
    
public final int decrementPendingCountUnlessZero() {
        int c;
        do {} while ((c = pending) != 0 &&
                     !U.compareAndSwapInt(this, PENDING, c, c - 1));
        return c;
    }

    /**
     * Returns the root of the current computation; i.e., this
     * task if it has no completer, else its completer's root.
     *
     * @return the root of the current computation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.893 -0400", hash_original_method = "88B4036BD4063959D1A0B9FC5170C12B", hash_generated_method = "80C38E3FFE27F83DD707EA5DB1D08C05")
    
public final CountedCompleter<?> getRoot() {
        CountedCompleter<?> a = this, p;
        while ((p = a.completer) != null)
            a = p;
        return a;
    }

    /**
     * If the pending count is nonzero, decrements the count;
     * otherwise invokes {@link #onCompletion} and then similarly
     * tries to complete this task's completer, if one exists,
     * else marks this task as complete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.893 -0400", hash_original_method = "DD7ED8407242C7FDFB8B339498DB0444", hash_generated_method = "A83B0FC739C230926762CB7D7E81BC7E")
    
public final void tryComplete() {
        CountedCompleter<?> a = this, s = a;
        for (int c;;) {
            if ((c = a.pending) == 0) {
                a.onCompletion(s);
                if ((a = (s = a).completer) == null) {
                    s.quietlyComplete();
                    return;
                }
            }
            else if (U.compareAndSwapInt(a, PENDING, c, c - 1))
                return;
        }
    }

    /**
     * Equivalent to {@link #tryComplete} but does not invoke {@link
     * #onCompletion} along the completion path: If the pending count
     * is nonzero, decrements the count; otherwise, similarly tries to
     * complete this task's completer, if one exists, else marks this
     * task as complete. This method may be useful in cases where
     * {@code onCompletion} should not, or need not, be invoked for
     * each completer in a computation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.894 -0400", hash_original_method = "D84A2AF634EB593671EA3E0B03405A30", hash_generated_method = "5C4680A70C1557E9C8100A1E64A354B8")
    
public final void propagateCompletion() {
        CountedCompleter<?> a = this, s = a;
        for (int c;;) {
            if ((c = a.pending) == 0) {
                if ((a = (s = a).completer) == null) {
                    s.quietlyComplete();
                    return;
                }
            }
            else if (U.compareAndSwapInt(a, PENDING, c, c - 1))
                return;
        }
    }

    /**
     * Regardless of pending count, invokes {@link #onCompletion},
     * marks this task as complete and further triggers {@link
     * #tryComplete} on this task's completer, if one exists.  The
     * given rawResult is used as an argument to {@link #setRawResult}
     * before invoking {@link #onCompletion} or marking this task as
     * complete; its value is meaningful only for classes overriding
     * {@code setRawResult}.
     *
     * <p>This method may be useful when forcing completion as soon as
     * any one (versus all) of several subtask results are obtained.
     * However, in the common (and recommended) case in which {@code
     * setRawResult} is not overridden, this effect can be obtained
     * more simply using {@code quietlyCompleteRoot();}.
     *
     * @param rawResult the raw result
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.894 -0400", hash_original_method = "7F17DA0616B82D46C228880BB83D6C25", hash_generated_method = "8272E70E4D6CAB3B80CD4757E7E32336")
    
public void complete(T rawResult) {
        CountedCompleter<?> p;
        setRawResult(rawResult);
        onCompletion(this);
        quietlyComplete();
        if ((p = completer) != null)
            p.tryComplete();
    }


    /**
     * If this task's pending count is zero, returns this task;
     * otherwise decrements its pending count and returns {@code
     * null}. This method is designed to be used with {@link
     * #nextComplete} in completion traversal loops.
     *
     * @return this task, if pending count was zero, else {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.895 -0400", hash_original_method = "32B3B0807B79FE324E4B25391AFF0DF2", hash_generated_method = "0CC1C59E76F121BA847C42DC89A83A02")
    
public final CountedCompleter<?> firstComplete() {
        for (int c;;) {
            if ((c = pending) == 0)
                return this;
            else if (U.compareAndSwapInt(this, PENDING, c, c - 1))
                return null;
        }
    }

    /**
     * If this task does not have a completer, invokes {@link
     * ForkJoinTask#quietlyComplete} and returns {@code null}.  Or, if
     * the completer's pending count is non-zero, decrements that
     * pending count and returns {@code null}.  Otherwise, returns the
     * completer.  This method can be used as part of a completion
     * traversal loop for homogeneous task hierarchies:
     *
     * <pre> {@code
     * for (CountedCompleter<?> c = firstComplete();
     *      c != null;
     *      c = c.nextComplete()) {
     *   // ... process c ...
     * }}</pre>
     *
     * @return the completer, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.895 -0400", hash_original_method = "E107358FAD4988E2D00C12FD2E72E56C", hash_generated_method = "29BA11CF60A37C7E0B9B46403BED7DEF")
    
public final CountedCompleter<?> nextComplete() {
        CountedCompleter<?> p;
        if ((p = completer) != null)
            return p.firstComplete();
        else {
            quietlyComplete();
            return null;
        }
    }

    /**
     * Equivalent to {@code getRoot().quietlyComplete()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.896 -0400", hash_original_method = "8ADCC406347085863735B3A73261BCB2", hash_generated_method = "B93C27C7AF4664BA83A619D3F059164B")
    
public final void quietlyCompleteRoot() {
        for (CountedCompleter<?> a = this, p;;) {
            if ((p = a.completer) == null) {
                a.quietlyComplete();
                return;
            }
            a = p;
        }
    }

    /**
     * Supports ForkJoinTask exception propagation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.896 -0400", hash_original_method = "44499474D80008737ED92B2380EA48EA", hash_generated_method = "44499474D80008737ED92B2380EA48EA")
    
void internalPropagateException(Throwable ex) {
        CountedCompleter<?> a = this, s = a;
        while (a.onExceptionalCompletion(ex, s) &&
               (a = (s = a).completer) != null && a.status >= 0)
            a.recordExceptionalCompletion(ex);
    }

    /**
     * Implements execution conventions for CountedCompleters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.896 -0400", hash_original_method = "4E25DCCE1FC3152150F6343F481D8594", hash_generated_method = "7BE331AB42528749A550F45F3FEADEEE")
    
protected final boolean exec() {
        compute();
        return false;
    }

    /**
     * Returns the result of the computation. By default
     * returns {@code null}, which is appropriate for {@code Void}
     * actions, but in other cases should be overridden, almost
     * always to return a field or function of a field that
     * holds the result upon completion.
     *
     * @return the result of the computation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.897 -0400", hash_original_method = "9420BB467A0EB2049ADC68ADAF3FBF3E", hash_generated_method = "41B5CD0705243DD07E04CFD5EC29B0A1")
    
public T getRawResult() { return null; }

    /**
     * A method that result-bearing CountedCompleters may optionally
     * use to help maintain result data.  By default, does nothing.
     * Overrides are not recommended. However, if this method is
     * overridden to update existing objects or fields, then it must
     * in general be defined to be thread-safe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.897 -0400", hash_original_method = "A6AF789CEB317BFC0DB0E939E140EB85", hash_generated_method = "B8C765330921A4A29C59727B1D966FD1")
    
protected void setRawResult(T t) { }
    static {
        try {
            U = sun.misc.Unsafe.getUnsafe();
            PENDING = U.objectFieldOffset
                (CountedCompleter.class.getDeclaredField("pending"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
