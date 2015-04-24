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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * A reusable synchronization barrier, similar in functionality to
 * {@link java.util.concurrent.CyclicBarrier CyclicBarrier} and
 * {@link java.util.concurrent.CountDownLatch CountDownLatch}
 * but supporting more flexible usage.
 *
 * <p><b>Registration.</b> Unlike the case for other barriers, the
 * number of parties <em>registered</em> to synchronize on a phaser
 * may vary over time.  Tasks may be registered at any time (using
 * methods {@link #register}, {@link #bulkRegister}, or forms of
 * constructors establishing initial numbers of parties), and
 * optionally deregistered upon any arrival (using {@link
 * #arriveAndDeregister}).  As is the case with most basic
 * synchronization constructs, registration and deregistration affect
 * only internal counts; they do not establish any further internal
 * bookkeeping, so tasks cannot query whether they are registered.
 * (However, you can introduce such bookkeeping by subclassing this
 * class.)
 *
 * <p><b>Synchronization.</b> Like a {@code CyclicBarrier}, a {@code
 * Phaser} may be repeatedly awaited.  Method {@link
 * #arriveAndAwaitAdvance} has effect analogous to {@link
 * java.util.concurrent.CyclicBarrier#await CyclicBarrier.await}. Each
 * generation of a phaser has an associated phase number. The phase
 * number starts at zero, and advances when all parties arrive at the
 * phaser, wrapping around to zero after reaching {@code
 * Integer.MAX_VALUE}. The use of phase numbers enables independent
 * control of actions upon arrival at a phaser and upon awaiting
 * others, via two kinds of methods that may be invoked by any
 * registered party:
 *
 * <ul>
 *
 *   <li> <b>Arrival.</b> Methods {@link #arrive} and
 *       {@link #arriveAndDeregister} record arrival.  These methods
 *       do not block, but return an associated <em>arrival phase
 *       number</em>; that is, the phase number of the phaser to which
 *       the arrival applied. When the final party for a given phase
 *       arrives, an optional action is performed and the phase
 *       advances.  These actions are performed by the party
 *       triggering a phase advance, and are arranged by overriding
 *       method {@link #onAdvance(int, int)}, which also controls
 *       termination. Overriding this method is similar to, but more
 *       flexible than, providing a barrier action to a {@code
 *       CyclicBarrier}.
 *
 *   <li> <b>Waiting.</b> Method {@link #awaitAdvance} requires an
 *       argument indicating an arrival phase number, and returns when
 *       the phaser advances to (or is already at) a different phase.
 *       Unlike similar constructions using {@code CyclicBarrier},
 *       method {@code awaitAdvance} continues to wait even if the
 *       waiting thread is interrupted. Interruptible and timeout
 *       versions are also available, but exceptions encountered while
 *       tasks wait interruptibly or with timeout do not change the
 *       state of the phaser. If necessary, you can perform any
 *       associated recovery within handlers of those exceptions,
 *       often after invoking {@code forceTermination}.  Phasers may
 *       also be used by tasks executing in a {@link ForkJoinPool},
 *       which will ensure sufficient parallelism to execute tasks
 *       when others are blocked waiting for a phase to advance.
 *
 * </ul>
 *
 * <p><b>Termination.</b> A phaser may enter a <em>termination</em>
 * state, that may be checked using method {@link #isTerminated}. Upon
 * termination, all synchronization methods immediately return without
 * waiting for advance, as indicated by a negative return value.
 * Similarly, attempts to register upon termination have no effect.
 * Termination is triggered when an invocation of {@code onAdvance}
 * returns {@code true}. The default implementation returns {@code
 * true} if a deregistration has caused the number of registered
 * parties to become zero.  As illustrated below, when phasers control
 * actions with a fixed number of iterations, it is often convenient
 * to override this method to cause termination when the current phase
 * number reaches a threshold. Method {@link #forceTermination} is
 * also available to abruptly release waiting threads and allow them
 * to terminate.
 *
 * <p><b>Tiering.</b> Phasers may be <em>tiered</em> (i.e.,
 * constructed in tree structures) to reduce contention. Phasers with
 * large numbers of parties that would otherwise experience heavy
 * synchronization contention costs may instead be set up so that
 * groups of sub-phasers share a common parent.  This may greatly
 * increase throughput even though it incurs greater per-operation
 * overhead.
 *
 * <p>In a tree of tiered phasers, registration and deregistration of
 * child phasers with their parent are managed automatically.
 * Whenever the number of registered parties of a child phaser becomes
 * non-zero (as established in the {@link #Phaser(Phaser,int)}
 * constructor, {@link #register}, or {@link #bulkRegister}), the
 * child phaser is registered with its parent.  Whenever the number of
 * registered parties becomes zero as the result of an invocation of
 * {@link #arriveAndDeregister}, the child phaser is deregistered
 * from its parent.
 *
 * <p><b>Monitoring.</b> While synchronization methods may be invoked
 * only by registered parties, the current state of a phaser may be
 * monitored by any caller.  At any given moment there are {@link
 * #getRegisteredParties} parties in total, of which {@link
 * #getArrivedParties} have arrived at the current phase ({@link
 * #getPhase}).  When the remaining ({@link #getUnarrivedParties})
 * parties arrive, the phase advances.  The values returned by these
 * methods may reflect transient states and so are not in general
 * useful for synchronization control.  Method {@link #toString}
 * returns snapshots of these state queries in a form convenient for
 * informal monitoring.
 *
 * <p><b>Sample usages:</b>
 *
 * <p>A {@code Phaser} may be used instead of a {@code CountDownLatch}
 * to control a one-shot action serving a variable number of parties.
 * The typical idiom is for the method setting this up to first
 * register, then start the actions, then deregister, as in:
 *
 *  <pre> {@code
 * void runTasks(List<Runnable> tasks) {
 *   final Phaser phaser = new Phaser(1); // "1" to register self
 *   // create and start threads
 *   for (final Runnable task : tasks) {
 *     phaser.register();
 *     new Thread() {
 *       public void run() {
 *         phaser.arriveAndAwaitAdvance(); // await all creation
 *         task.run();
 *       }
 *     }.start();
 *   }
 *
 *   // allow threads to start and deregister self
 *   phaser.arriveAndDeregister();
 * }}</pre>
 *
 * <p>One way to cause a set of threads to repeatedly perform actions
 * for a given number of iterations is to override {@code onAdvance}:
 *
 *  <pre> {@code
 * void startTasks(List<Runnable> tasks, final int iterations) {
 *   final Phaser phaser = new Phaser() {
 *     protected boolean onAdvance(int phase, int registeredParties) {
 *       return phase >= iterations || registeredParties == 0;
 *     }
 *   };
 *   phaser.register();
 *   for (final Runnable task : tasks) {
 *     phaser.register();
 *     new Thread() {
 *       public void run() {
 *         do {
 *           task.run();
 *           phaser.arriveAndAwaitAdvance();
 *         } while (!phaser.isTerminated());
 *       }
 *     }.start();
 *   }
 *   phaser.arriveAndDeregister(); // deregister self, don't wait
 * }}</pre>
 *
 * If the main task must later await termination, it
 * may re-register and then execute a similar loop:
 *  <pre> {@code
 *   // ...
 *   phaser.register();
 *   while (!phaser.isTerminated())
 *     phaser.arriveAndAwaitAdvance();}</pre>
 *
 * <p>Related constructions may be used to await particular phase numbers
 * in contexts where you are sure that the phase will never wrap around
 * {@code Integer.MAX_VALUE}. For example:
 *
 *  <pre> {@code
 * void awaitPhase(Phaser phaser, int phase) {
 *   int p = phaser.register(); // assumes caller not already registered
 *   while (p < phase) {
 *     if (phaser.isTerminated())
 *       // ... deal with unexpected termination
 *     else
 *       p = phaser.arriveAndAwaitAdvance();
 *   }
 *   phaser.arriveAndDeregister();
 * }}</pre>
 *
 *
 * <p>To create a set of {@code n} tasks using a tree of phasers, you
 * could use code of the following form, assuming a Task class with a
 * constructor accepting a {@code Phaser} that it registers with upon
 * construction. After invocation of {@code build(new Task[n], 0, n,
 * new Phaser())}, these tasks could then be started, for example by
 * submitting to a pool:
 *
 *  <pre> {@code
 * void build(Task[] tasks, int lo, int hi, Phaser ph) {
 *   if (hi - lo > TASKS_PER_PHASER) {
 *     for (int i = lo; i < hi; i += TASKS_PER_PHASER) {
 *       int j = Math.min(i + TASKS_PER_PHASER, hi);
 *       build(tasks, i, j, new Phaser(ph));
 *     }
 *   } else {
 *     for (int i = lo; i < hi; ++i)
 *       tasks[i] = new Task(ph);
 *       // assumes new Task(ph) performs ph.register()
 *   }
 * }}</pre>
 *
 * The best value of {@code TASKS_PER_PHASER} depends mainly on
 * expected synchronization rates. A value as low as four may
 * be appropriate for extremely small per-phase task bodies (thus
 * high rates), or up to hundreds for extremely large ones.
 *
 * <p><b>Implementation notes</b>: This implementation restricts the
 * maximum number of parties to 65535. Attempts to register additional
 * parties result in {@code IllegalStateException}. However, you can and
 * should create tiered phasers to accommodate arbitrarily large sets
 * of participants.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
public class Phaser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.944 -0400", hash_original_field = "A0889131F1B89C3B305FAF8AC7FB0D40", hash_generated_field = "4578CD0840E752884DCF0DA9220344A4")

    private static final int  MAX_PARTIES     = 0xffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.945 -0400", hash_original_field = "DE49D0BFA45E5B2A5B164DAD79B6FFFF", hash_generated_field = "5511843B64CD257D228CF3E628973122")

    private static final int  MAX_PHASE       = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.945 -0400", hash_original_field = "20FE785C339C5BDDF2803EA00E0D6687", hash_generated_field = "28237A6E8491FDEB890E066C5C6B3611")

    private static final int  PARTIES_SHIFT   = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.946 -0400", hash_original_field = "C81C16BB9762A9A7C74F0219FB76A8CF", hash_generated_field = "E8CAFB8E2719FF5E77C55D07BAD91D8F")

    private static final int  PHASE_SHIFT     = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.946 -0400", hash_original_field = "E40567AC3FA4C411B92F61134CA21861", hash_generated_field = "5AAA06984DB1508172138BB1CCD973C8")

    private static final int  UNARRIVED_MASK  = 0xffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.946 -0400", hash_original_field = "709013D1594253BCA1ED5EE860E2ABE5", hash_generated_field = "7EC194E81949ABC175AD33FB60B69135")

    private static final long PARTIES_MASK    = 0xffff0000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.947 -0400", hash_original_field = "7D940732A9019EC4E4A21E8CCB5D0C20", hash_generated_field = "744CE88F8BE452039631A7E761B5F79A")

    private static final long COUNTS_MASK     = 0xffffffffL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.947 -0400", hash_original_field = "7CC6AFFEFD1EF3B36C712661841F42D4", hash_generated_field = "820F1479C6B0F562F72537E995717B38")

    private static final long TERMINATION_BIT = 1L << 63;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.947 -0400", hash_original_field = "FFB9D9A69AB6E56FFE7363EB324E8658", hash_generated_field = "EE8C100C67F8E2E671085CFF63AD8792")

    private static final int  ONE_ARRIVAL     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.948 -0400", hash_original_field = "CDCB755FF984CD341C6735DB9889A03B", hash_generated_field = "2193ECD5B62984C95610923B4D8499DA")

    private static final int  ONE_PARTY       = 1 << PARTIES_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.949 -0400", hash_original_field = "FCD6E751DA22BEB5CB009F8F55D50C32", hash_generated_field = "91ED3761AFEB064AACD5D9EA73735E8D")

    private static final int  ONE_DEREGISTER  = ONE_ARRIVAL|ONE_PARTY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.949 -0400", hash_original_field = "2327723FD388D16952ED5F9DDF0E519A", hash_generated_field = "EA8EDD0494A54B0E862487765357BE1E")

    private static final int  EMPTY           = 1;

    // The following unpacking methods are usually manually inlined

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.950 -0400", hash_original_method = "FA60D57D301A190FF1AF43BD428DB45C", hash_generated_method = "4E3526D55AEBB46EEC87F21DFF80D084")
    
private static int unarrivedOf(long s) {
        int counts = (int)s;
        return (counts == EMPTY) ? 0 : (counts & UNARRIVED_MASK);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.950 -0400", hash_original_method = "91501F5D3D9DF6EE6933E04967B8CD69", hash_generated_method = "439DDC5D9A3E4882FCA3C4965FDFDD21")
    
private static int partiesOf(long s) {
        return (int)s >>> PARTIES_SHIFT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.951 -0400", hash_original_method = "D0691166BD6F8FB09E558B0C6F1F22A2", hash_generated_method = "4870E8890D7AA7734DF2DEECC1A5C0DC")
    
private static int phaseOf(long s) {
        return (int)(s >>> PHASE_SHIFT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.951 -0400", hash_original_method = "45B2EAD82B3BEC636841C0FEA15F21B0", hash_generated_method = "C7F9F11731A31792BF15782F9E3E9783")
    
private static int arrivedOf(long s) {
        int counts = (int)s;
        return (counts == EMPTY) ? 0 :
            (counts >>> PARTIES_SHIFT) - (counts & UNARRIVED_MASK);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.970 -0400", hash_original_field = "75EA46F781370128B90C88B0C6C4F82B", hash_generated_field = "8FD1D00BA6B52C5E0CB71DFCD385247C")

    private static final int NCPU = Runtime.getRuntime().availableProcessors();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.970 -0400", hash_original_field = "75B967DD73ABA5E5C11A8BC79FA47C5F", hash_generated_field = "9308C994BE158F5E728D354EA6C2CD37")

    static final int SPINS_PER_ARRIVAL = (NCPU < 2) ? 1 : 1 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.978 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

    private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.979 -0400", hash_original_field = "B5D820F28C091A00D3EC28A15A2D716E", hash_generated_field = "162353053FFA573C2A47BACEC7C77131")

    private static  long stateOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.944 -0400", hash_original_field = "A408FF7A0722B52330732DC0BB31F0BA", hash_generated_field = "E9DEF6E020451D815ED65E9D065EADA0")

    /**
     * Primary state representation, holding four bit-fields:
     *
     * unarrived  -- the number of parties yet to hit barrier (bits  0-15)
     * parties    -- the number of parties to wait            (bits 16-31)
     * phase      -- the generation of the barrier            (bits 32-62)
     * terminated -- set if barrier is terminated             (bit  63 / sign)
     *
     * Except that a phaser with no registered parties is
     * distinguished by the otherwise illegal state of having zero
     * parties and one unarrived parties (encoded as EMPTY below).
     *
     * To efficiently maintain atomicity, these values are packed into
     * a single (atomic) long. Good performance relies on keeping
     * state decoding and encoding simple, and keeping race windows
     * short.
     *
     * All state updates are performed via CAS except initial
     * registration of a sub-phaser (i.e., one with a non-null
     * parent).  In this (relatively rare) case, we use built-in
     * synchronization to lock while first registering with its
     * parent.
     *
     * The phase of a subphaser is allowed to lag that of its
     * ancestors until it is actually accessed -- see method
     * reconcileState.
     */
    private volatile long state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.951 -0400", hash_original_field = "00E564F7AD197A1C1E04653E01EC3EF9", hash_generated_field = "87034E57950FDC828B37817D571FA58D")

    private  Phaser parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.952 -0400", hash_original_field = "450208B5B2BF399CB19B48A08F300FD8", hash_generated_field = "5AD7BBDB2D16EF01202BA5C261916905")

    private  Phaser root;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.952 -0400", hash_original_field = "189B2C3B242FBFF4EC12F3A0282BEE77", hash_generated_field = "8048337C357CB8AC9C05C70DE686CB1A")

    private  AtomicReference<QNode> evenQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.952 -0400", hash_original_field = "9DC007D554BD202CED8D029042515EEE", hash_generated_field = "EEDD894C478953736072846644BE83B1")

    private  AtomicReference<QNode> oddQ;

    /**
     * Creates a new phaser with no initially registered parties, no
     * parent, and initial phase number 0. Any thread using this
     * phaser will need to first register for it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.957 -0400", hash_original_method = "F239F6C289BCD2F4BC55F0B83883F380", hash_generated_method = "0B62545A3C3BEE8E8076FDE47AEDF4BD")
    
public Phaser() {
        this(null, 0);
    }

    /**
     * Creates a new phaser with the given number of registered
     * unarrived parties, no parent, and initial phase number 0.
     *
     * @param parties the number of parties required to advance to the
     * next phase
     * @throws IllegalArgumentException if parties less than zero
     * or greater than the maximum number of parties supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.958 -0400", hash_original_method = "8CAF5836E3577FA0F0E1DD21F178AC12", hash_generated_method = "6154750B300ABF4D69C475EC86090BA4")
    
public Phaser(int parties) {
        this(null, parties);
    }

    /**
     * Equivalent to {@link #Phaser(Phaser, int) Phaser(parent, 0)}.
     *
     * @param parent the parent phaser
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.958 -0400", hash_original_method = "E61FE81C81121E86FC28B249B98C4F58", hash_generated_method = "946CE6C12E0FEF9B725F72BAAB740BE1")
    
public Phaser(Phaser parent) {
        this(parent, 0);
    }

    /**
     * Creates a new phaser with the given parent and number of
     * registered unarrived parties.  When the given parent is non-null
     * and the given number of parties is greater than zero, this
     * child phaser is registered with its parent.
     *
     * @param parent the parent phaser
     * @param parties the number of parties required to advance to the
     * next phase
     * @throws IllegalArgumentException if parties less than zero
     * or greater than the maximum number of parties supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.959 -0400", hash_original_method = "51BAA3E17EE281D8C69C752DD3177A5C", hash_generated_method = "762D67DB16D12CF9875B7202BDE6AA91")
    
public Phaser(Phaser parent, int parties) {
        if (parties >>> PARTIES_SHIFT != 0)
            throw new IllegalArgumentException("Illegal number of parties");
        int phase = 0;
        this.parent = parent;
        if (parent != null) {
            final Phaser root = parent.root;
            this.root = root;
            this.evenQ = root.evenQ;
            this.oddQ = root.oddQ;
            if (parties != 0)
                phase = parent.doRegister(1);
        }
        else {
            this.root = this;
            this.evenQ = new AtomicReference<QNode>();
            this.oddQ = new AtomicReference<QNode>();
        }
        this.state = (parties == 0) ? (long)EMPTY :
            ((long)phase << PHASE_SHIFT) |
            ((long)parties << PARTIES_SHIFT) |
            ((long)parties);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.953 -0400", hash_original_method = "A5578E9B84400B13187CD0A4B9ADE6EE", hash_generated_method = "7FE0770479A4169BF6F0BE53F1F5A11B")
    
private AtomicReference<QNode> queueFor(int phase) {
        return ((phase & 1) == 0) ? evenQ : oddQ;
    }

    /**
     * Returns message string for bounds exceptions on arrival.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.953 -0400", hash_original_method = "753A12A98ABED9FC7E2F432395FDFA70", hash_generated_method = "13E906C007B2B64E98EDF6F61A54101F")
    
private String badArrive(long s) {
        return "Attempted arrival of unregistered party for " +
            stateToString(s);
    }

    /**
     * Returns message string for bounds exceptions on registration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.954 -0400", hash_original_method = "1D03AD9F44C5C27A45B59B547810BEB9", hash_generated_method = "7B3E1D2D1F084062EB8A32744432485F")
    
private String badRegister(long s) {
        return "Attempt to register more than " +
            MAX_PARTIES + " parties for " + stateToString(s);
    }

    /**
     * Main implementation for methods arrive and arriveAndDeregister.
     * Manually tuned to speed up and minimize race windows for the
     * common case of just decrementing unarrived field.
     *
     * @param adjust value to subtract from state;
     *               ONE_ARRIVAL for arrive,
     *               ONE_DEREGISTER for arriveAndDeregister
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.955 -0400", hash_original_method = "EEF82CFD9BF09DDA964C2F803A7E7136", hash_generated_method = "13FC2D2C54A6F8A0F7F63524FFF2F2AD")
    
private int doArrive(int adjust) {
        final Phaser root = this.root;
        for (;;) {
            long s = (root == this) ? state : reconcileState();
            int phase = (int)(s >>> PHASE_SHIFT);
            if (phase < 0)
                return phase;
            int counts = (int)s;
            int unarrived = (counts == EMPTY) ? 0 : (counts & UNARRIVED_MASK);
            if (unarrived <= 0)
                throw new IllegalStateException(badArrive(s));
            if (UNSAFE.compareAndSwapLong(this, stateOffset, s, s-=adjust)) {
                if (unarrived == 1) {
                    long n = s & PARTIES_MASK;  // base of next state
                    int nextUnarrived = (int)n >>> PARTIES_SHIFT;
                    if (root == this) {
                        if (onAdvance(phase, nextUnarrived))
                            n |= TERMINATION_BIT;
                        else if (nextUnarrived == 0)
                            n |= EMPTY;
                        else
                            n |= nextUnarrived;
                        int nextPhase = (phase + 1) & MAX_PHASE;
                        n |= (long)nextPhase << PHASE_SHIFT;
                        UNSAFE.compareAndSwapLong(this, stateOffset, s, n);
                        releaseWaiters(phase);
                    }
                    else if (nextUnarrived == 0) { // propagate deregistration
                        phase = parent.doArrive(ONE_DEREGISTER);
                        UNSAFE.compareAndSwapLong(this, stateOffset,
                                                  s, s | EMPTY);
                    }
                    else
                        phase = parent.doArrive(ONE_ARRIVAL);
                }
                return phase;
            }
        }
    }

    /**
     * Implementation of register, bulkRegister
     *
     * @param registrations number to add to both parties and
     * unarrived fields. Must be greater than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.956 -0400", hash_original_method = "4E26E368F0DE6132017E692569B3B9A8", hash_generated_method = "09069326505DC88BD225D86874FBE42A")
    
private int doRegister(int registrations) {
        // adjustment to state
        long adjust = ((long)registrations << PARTIES_SHIFT) | registrations;
        final Phaser parent = this.parent;
        int phase;
        for (;;) {
            long s = (parent == null) ? state : reconcileState();
            int counts = (int)s;
            int parties = counts >>> PARTIES_SHIFT;
            int unarrived = counts & UNARRIVED_MASK;
            if (registrations > MAX_PARTIES - parties)
                throw new IllegalStateException(badRegister(s));
            phase = (int)(s >>> PHASE_SHIFT);
            if (phase < 0)
                break;
            if (counts != EMPTY) {                  // not 1st registration
                if (parent == null || reconcileState() == s) {
                    if (unarrived == 0)             // wait out advance
                        root.internalAwaitAdvance(phase, null);
                    else if (UNSAFE.compareAndSwapLong(this, stateOffset,
                                                       s, s + adjust))
                        break;
                }
            }
            else if (parent == null) {              // 1st root registration
                long next = ((long)phase << PHASE_SHIFT) | adjust;
                if (UNSAFE.compareAndSwapLong(this, stateOffset, s, next))
                    break;
            }
            else {
                synchronized (this) {               // 1st sub registration
                    if (state == s) {               // recheck under lock
                        phase = parent.doRegister(1);
                        if (phase < 0)
                            break;
                        // finish registration whenever parent registration
                        // succeeded, even when racing with termination,
                        // since these are part of the same "transaction".
                        while (!UNSAFE.compareAndSwapLong
                               (this, stateOffset, s,
                                ((long)phase << PHASE_SHIFT) | adjust)) {
                            s = state;
                            phase = (int)(root.state >>> PHASE_SHIFT);
                            // assert (int)s == EMPTY;
                        }
                        break;
                    }
                }
            }
        }
        return phase;
    }

    /**
     * Resolves lagged phase propagation from root if necessary.
     * Reconciliation normally occurs when root has advanced but
     * subphasers have not yet done so, in which case they must finish
     * their own advance by setting unarrived to parties (or if
     * parties is zero, resetting to unregistered EMPTY state).
     *
     * @return reconciled state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.957 -0400", hash_original_method = "F17863C8B98E2C8BC03C7B1A1F59017D", hash_generated_method = "28BC473AA3DB805D1A6E355F281E6189")
    
private long reconcileState() {
        final Phaser root = this.root;
        long s = state;
        if (root != this) {
            int phase, p;
            // CAS to root phase with current parties, tripping unarrived
            while ((phase = (int)(root.state >>> PHASE_SHIFT)) !=
                   (int)(s >>> PHASE_SHIFT) &&
                   !UNSAFE.compareAndSwapLong
                   (this, stateOffset, s,
                    s = (((long)phase << PHASE_SHIFT) |
                         ((phase < 0) ? (s & COUNTS_MASK) :
                          (((p = (int)s >>> PARTIES_SHIFT) == 0) ? EMPTY :
                           ((s & PARTIES_MASK) | p))))))
                s = state;
        }
        return s;
    }

    /**
     * Adds a new unarrived party to this phaser.  If an ongoing
     * invocation of {@link #onAdvance} is in progress, this method
     * may await its completion before returning.  If this phaser has
     * a parent, and this phaser previously had no registered parties,
     * this child phaser is also registered with its parent. If
     * this phaser is terminated, the attempt to register has
     * no effect, and a negative value is returned.
     *
     * @return the arrival phase number to which this registration
     * applied.  If this value is negative, then this phaser has
     * terminated, in which case registration has no effect.
     * @throws IllegalStateException if attempting to register more
     * than the maximum supported number of parties
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.959 -0400", hash_original_method = "9314F550BC0F41DF34ADD92C8B164401", hash_generated_method = "B7143354F22569950DF7FB8480D12D8D")
    
public int register() {
        return doRegister(1);
    }

    /**
     * Adds the given number of new unarrived parties to this phaser.
     * If an ongoing invocation of {@link #onAdvance} is in progress,
     * this method may await its completion before returning.  If this
     * phaser has a parent, and the given number of parties is greater
     * than zero, and this phaser previously had no registered
     * parties, this child phaser is also registered with its parent.
     * If this phaser is terminated, the attempt to register has no
     * effect, and a negative value is returned.
     *
     * @param parties the number of additional parties required to
     * advance to the next phase
     * @return the arrival phase number to which this registration
     * applied.  If this value is negative, then this phaser has
     * terminated, in which case registration has no effect.
     * @throws IllegalStateException if attempting to register more
     * than the maximum supported number of parties
     * @throws IllegalArgumentException if {@code parties < 0}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.960 -0400", hash_original_method = "6F663B24EEDD3F3BB000E5DA941EDD10", hash_generated_method = "D3326032418FACDB37492386B179190C")
    
public int bulkRegister(int parties) {
        if (parties < 0)
            throw new IllegalArgumentException();
        if (parties == 0)
            return getPhase();
        return doRegister(parties);
    }

    /**
     * Arrives at this phaser, without waiting for others to arrive.
     *
     * <p>It is a usage error for an unregistered party to invoke this
     * method.  However, this error may result in an {@code
     * IllegalStateException} only upon some subsequent operation on
     * this phaser, if ever.
     *
     * @return the arrival phase number, or a negative value if terminated
     * @throws IllegalStateException if not terminated and the number
     * of unarrived parties would become negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.960 -0400", hash_original_method = "CE3ED1761C860493AE9640CD4A49B00D", hash_generated_method = "5011DAA2E89078D510FEE4BB535BAF95")
    
public int arrive() {
        return doArrive(ONE_ARRIVAL);
    }

    /**
     * Arrives at this phaser and deregisters from it without waiting
     * for others to arrive. Deregistration reduces the number of
     * parties required to advance in future phases.  If this phaser
     * has a parent, and deregistration causes this phaser to have
     * zero parties, this phaser is also deregistered from its parent.
     *
     * <p>It is a usage error for an unregistered party to invoke this
     * method.  However, this error may result in an {@code
     * IllegalStateException} only upon some subsequent operation on
     * this phaser, if ever.
     *
     * @return the arrival phase number, or a negative value if terminated
     * @throws IllegalStateException if not terminated and the number
     * of registered or unarrived parties would become negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.960 -0400", hash_original_method = "2DEDA011F96C6509AFDC89E4D5559183", hash_generated_method = "7048E435ACE54908C0F765BF3DFAFF70")
    
public int arriveAndDeregister() {
        return doArrive(ONE_DEREGISTER);
    }

    /**
     * Arrives at this phaser and awaits others. Equivalent in effect
     * to {@code awaitAdvance(arrive())}.  If you need to await with
     * interruption or timeout, you can arrange this with an analogous
     * construction using one of the other forms of the {@code
     * awaitAdvance} method.  If instead you need to deregister upon
     * arrival, use {@code awaitAdvance(arriveAndDeregister())}.
     *
     * <p>It is a usage error for an unregistered party to invoke this
     * method.  However, this error may result in an {@code
     * IllegalStateException} only upon some subsequent operation on
     * this phaser, if ever.
     *
     * @return the arrival phase number, or the (negative)
     * {@linkplain #getPhase() current phase} if terminated
     * @throws IllegalStateException if not terminated and the number
     * of unarrived parties would become negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.961 -0400", hash_original_method = "B6FE061AE115A9D1EBFBF4B3D78DC375", hash_generated_method = "DB0F14878B57727AEC986FBA0B374278")
    
public int arriveAndAwaitAdvance() {
        // Specialization of doArrive+awaitAdvance eliminating some reads/paths
        final Phaser root = this.root;
        for (;;) {
            long s = (root == this) ? state : reconcileState();
            int phase = (int)(s >>> PHASE_SHIFT);
            if (phase < 0)
                return phase;
            int counts = (int)s;
            int unarrived = (counts == EMPTY) ? 0 : (counts & UNARRIVED_MASK);
            if (unarrived <= 0)
                throw new IllegalStateException(badArrive(s));
            if (UNSAFE.compareAndSwapLong(this, stateOffset, s,
                                          s -= ONE_ARRIVAL)) {
                if (unarrived > 1)
                    return root.internalAwaitAdvance(phase, null);
                if (root != this)
                    return parent.arriveAndAwaitAdvance();
                long n = s & PARTIES_MASK;  // base of next state
                int nextUnarrived = (int)n >>> PARTIES_SHIFT;
                if (onAdvance(phase, nextUnarrived))
                    n |= TERMINATION_BIT;
                else if (nextUnarrived == 0)
                    n |= EMPTY;
                else
                    n |= nextUnarrived;
                int nextPhase = (phase + 1) & MAX_PHASE;
                n |= (long)nextPhase << PHASE_SHIFT;
                if (!UNSAFE.compareAndSwapLong(this, stateOffset, s, n))
                    return (int)(state >>> PHASE_SHIFT); // terminated
                releaseWaiters(phase);
                return nextPhase;
            }
        }
    }

    /**
     * Awaits the phase of this phaser to advance from the given phase
     * value, returning immediately if the current phase is not equal
     * to the given phase value or this phaser is terminated.
     *
     * @param phase an arrival phase number, or negative value if
     * terminated; this argument is normally the value returned by a
     * previous call to {@code arrive} or {@code arriveAndDeregister}.
     * @return the next arrival phase number, or the argument if it is
     * negative, or the (negative) {@linkplain #getPhase() current phase}
     * if terminated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.962 -0400", hash_original_method = "F3F24C65917C19C44EDF6BFD234E5B72", hash_generated_method = "FFF9AB864A208290BBF93E814AEAAEFD")
    
public int awaitAdvance(int phase) {
        final Phaser root = this.root;
        long s = (root == this) ? state : reconcileState();
        int p = (int)(s >>> PHASE_SHIFT);
        if (phase < 0)
            return phase;
        if (p == phase)
            return root.internalAwaitAdvance(phase, null);
        return p;
    }

    /**
     * Awaits the phase of this phaser to advance from the given phase
     * value, throwing {@code InterruptedException} if interrupted
     * while waiting, or returning immediately if the current phase is
     * not equal to the given phase value or this phaser is
     * terminated.
     *
     * @param phase an arrival phase number, or negative value if
     * terminated; this argument is normally the value returned by a
     * previous call to {@code arrive} or {@code arriveAndDeregister}.
     * @return the next arrival phase number, or the argument if it is
     * negative, or the (negative) {@linkplain #getPhase() current phase}
     * if terminated
     * @throws InterruptedException if thread interrupted while waiting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.963 -0400", hash_original_method = "6918537A607712BC754F2B7606879870", hash_generated_method = "A2A71CA5992A4395C204F7637A90C4CE")
    
public int awaitAdvanceInterruptibly(int phase)
        throws InterruptedException {
        final Phaser root = this.root;
        long s = (root == this) ? state : reconcileState();
        int p = (int)(s >>> PHASE_SHIFT);
        if (phase < 0)
            return phase;
        if (p == phase) {
            QNode node = new QNode(this, phase, true, false, 0L);
            p = root.internalAwaitAdvance(phase, node);
            if (node.wasInterrupted)
                throw new InterruptedException();
        }
        return p;
    }

    /**
     * Awaits the phase of this phaser to advance from the given phase
     * value or the given timeout to elapse, throwing {@code
     * InterruptedException} if interrupted while waiting, or
     * returning immediately if the current phase is not equal to the
     * given phase value or this phaser is terminated.
     *
     * @param phase an arrival phase number, or negative value if
     * terminated; this argument is normally the value returned by a
     * previous call to {@code arrive} or {@code arriveAndDeregister}.
     * @param timeout how long to wait before giving up, in units of
     *        {@code unit}
     * @param unit a {@code TimeUnit} determining how to interpret the
     *        {@code timeout} parameter
     * @return the next arrival phase number, or the argument if it is
     * negative, or the (negative) {@linkplain #getPhase() current phase}
     * if terminated
     * @throws InterruptedException if thread interrupted while waiting
     * @throws TimeoutException if timed out while waiting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.963 -0400", hash_original_method = "87AA4D322287F16B0227E79B22805E32", hash_generated_method = "B0A0789905AB92FBD370603030563782")
    
public int awaitAdvanceInterruptibly(int phase,
                                         long timeout, TimeUnit unit)
        throws InterruptedException, TimeoutException {
        long nanos = unit.toNanos(timeout);
        final Phaser root = this.root;
        long s = (root == this) ? state : reconcileState();
        int p = (int)(s >>> PHASE_SHIFT);
        if (phase < 0)
            return phase;
        if (p == phase) {
            QNode node = new QNode(this, phase, true, true, nanos);
            p = root.internalAwaitAdvance(phase, node);
            if (node.wasInterrupted)
                throw new InterruptedException();
            else if (p == phase)
                throw new TimeoutException();
        }
        return p;
    }

    /**
     * Forces this phaser to enter termination state.  Counts of
     * registered parties are unaffected.  If this phaser is a member
     * of a tiered set of phasers, then all of the phasers in the set
     * are terminated.  If this phaser is already terminated, this
     * method has no effect.  This method may be useful for
     * coordinating recovery after one or more tasks encounter
     * unexpected exceptions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.964 -0400", hash_original_method = "6C20BFD0E455B7843308DBD9944301A2", hash_generated_method = "E010A6AB47E14A97CFDE9B6480119C19")
    
public void forceTermination() {
        // Only need to change root state
        final Phaser root = this.root;
        long s;
        while ((s = root.state) >= 0) {
            if (UNSAFE.compareAndSwapLong(root, stateOffset,
                                          s, s | TERMINATION_BIT)) {
                // signal all threads
                releaseWaiters(0); // Waiters on evenQ
                releaseWaiters(1); // Waiters on oddQ
                return;
            }
        }
    }

    /**
     * Returns the current phase number. The maximum phase number is
     * {@code Integer.MAX_VALUE}, after which it restarts at
     * zero. Upon termination, the phase number is negative,
     * in which case the prevailing phase prior to termination
     * may be obtained via {@code getPhase() + Integer.MIN_VALUE}.
     *
     * @return the phase number, or a negative value if terminated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.964 -0400", hash_original_method = "0883CD54F484BFE30D3D688F133A5FB4", hash_generated_method = "9F6319937568A9F23B3D3D25801BE42B")
    
public final int getPhase() {
        return (int)(root.state >>> PHASE_SHIFT);
    }

    /**
     * Returns the number of parties registered at this phaser.
     *
     * @return the number of parties
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.965 -0400", hash_original_method = "2C756F3514D8B8957A31153D67926672", hash_generated_method = "A8A8E142BE8AC43CB462BF09AE1B604B")
    
public int getRegisteredParties() {
        return partiesOf(state);
    }

    /**
     * Returns the number of registered parties that have arrived at
     * the current phase of this phaser. If this phaser has terminated,
     * the returned value is meaningless and arbitrary.
     *
     * @return the number of arrived parties
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.965 -0400", hash_original_method = "11DA501AA5E5C7D210A095345A36D021", hash_generated_method = "A775F21AB38B9056886E4A2148B971FB")
    
public int getArrivedParties() {
        return arrivedOf(reconcileState());
    }

    /**
     * Returns the number of registered parties that have not yet
     * arrived at the current phase of this phaser. If this phaser has
     * terminated, the returned value is meaningless and arbitrary.
     *
     * @return the number of unarrived parties
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.966 -0400", hash_original_method = "7025488CEF510A894B4DA437EF54F0E0", hash_generated_method = "269304CCA60F4E3C01E680508A467C73")
    
public int getUnarrivedParties() {
        return unarrivedOf(reconcileState());
    }

    /**
     * Returns the parent of this phaser, or {@code null} if none.
     *
     * @return the parent of this phaser, or {@code null} if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.966 -0400", hash_original_method = "607DAA2250A47799E82EE609B4E6F0BB", hash_generated_method = "FF105F764AD843A5E620827F67643CC9")
    
public Phaser getParent() {
        return parent;
    }

    /**
     * Returns the root ancestor of this phaser, which is the same as
     * this phaser if it has no parent.
     *
     * @return the root ancestor of this phaser
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.966 -0400", hash_original_method = "95BBB3776572C01DED50559E803DE243", hash_generated_method = "463904DC28A3C0D97889D734F844AA1B")
    
public Phaser getRoot() {
        return root;
    }

    /**
     * Returns {@code true} if this phaser has been terminated.
     *
     * @return {@code true} if this phaser has been terminated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.967 -0400", hash_original_method = "BDE3B6E80AC7DC59371752B20C73253E", hash_generated_method = "0E73C47A0271040609670E7BAF5B13D0")
    
public boolean isTerminated() {
        return root.state < 0L;
    }

    /**
     * Overridable method to perform an action upon impending phase
     * advance, and to control termination. This method is invoked
     * upon arrival of the party advancing this phaser (when all other
     * waiting parties are dormant).  If this method returns {@code
     * true}, this phaser will be set to a final termination state
     * upon advance, and subsequent calls to {@link #isTerminated}
     * will return true. Any (unchecked) Exception or Error thrown by
     * an invocation of this method is propagated to the party
     * attempting to advance this phaser, in which case no advance
     * occurs.
     *
     * <p>The arguments to this method provide the state of the phaser
     * prevailing for the current transition.  The effects of invoking
     * arrival, registration, and waiting methods on this phaser from
     * within {@code onAdvance} are unspecified and should not be
     * relied on.
     *
     * <p>If this phaser is a member of a tiered set of phasers, then
     * {@code onAdvance} is invoked only for its root phaser on each
     * advance.
     *
     * <p>To support the most common use cases, the default
     * implementation of this method returns {@code true} when the
     * number of registered parties has become zero as the result of a
     * party invoking {@code arriveAndDeregister}.  You can disable
     * this behavior, thus enabling continuation upon future
     * registrations, by overriding this method to always return
     * {@code false}:
     *
     * <pre> {@code
     * Phaser phaser = new Phaser() {
     *   protected boolean onAdvance(int phase, int parties) { return false; }
     * }}</pre>
     *
     * @param phase the current phase number on entry to this method,
     * before this phaser is advanced
     * @param registeredParties the current number of registered parties
     * @return {@code true} if this phaser should terminate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.967 -0400", hash_original_method = "10D9CE144A50B770ACEA01965EC345A1", hash_generated_method = "D2A1FC39C2FF660D05FBA81E4A27668C")
    
protected boolean onAdvance(int phase, int registeredParties) {
        return registeredParties == 0;
    }

    /**
     * Returns a string identifying this phaser, as well as its
     * state.  The state, in brackets, includes the String {@code
     * "phase = "} followed by the phase number, {@code "parties = "}
     * followed by the number of registered parties, and {@code
     * "arrived = "} followed by the number of arrived parties.
     *
     * @return a string identifying this phaser, as well as its state
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.967 -0400", hash_original_method = "228B868C2F3B65EA625E4A6829A2D2AC", hash_generated_method = "FE9BAE5BE16837B3A28B1CD3317F99D8")
    
public String toString() {
        return stateToString(reconcileState());
    }

    /**
     * Implementation of toString and string-based error messages
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.968 -0400", hash_original_method = "C309EEC3E8488BFF25AD77ED1252E8B0", hash_generated_method = "CBE65790B9A76DEB27BFD0984F5DE88A")
    
private String stateToString(long s) {
        return super.toString() +
            "[phase = " + phaseOf(s) +
            " parties = " + partiesOf(s) +
            " arrived = " + arrivedOf(s) + "]";
    }

    // Waiting mechanics

    /**
     * Removes and signals threads from queue for phase.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.968 -0400", hash_original_method = "C601702085B3E2EF52323098724D8EF9", hash_generated_method = "AC3753C6E1AE3DF2C47CC63F86E999F8")
    
private void releaseWaiters(int phase) {
        QNode q;   // first element of queue
        Thread t;  // its thread
        AtomicReference<QNode> head = (phase & 1) == 0 ? evenQ : oddQ;
        while ((q = head.get()) != null &&
               q.phase != (int)(root.state >>> PHASE_SHIFT)) {
            if (head.compareAndSet(q, q.next) &&
                (t = q.thread) != null) {
                q.thread = null;
                LockSupport.unpark(t);
            }
        }
    }

    /**
     * Wait nodes for Treiber stack representing wait queue
     */
    static final class QNode implements ForkJoinPool.ManagedBlocker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.972 -0400", hash_original_field = "A47DC2CDCF86C82CC582020A7D5C051B", hash_generated_field = "A47DC2CDCF86C82CC582020A7D5C051B")

         Phaser phaser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.972 -0400", hash_original_field = "170E0BF536CFC6AE793F3066A3CBB2FA", hash_generated_field = "170E0BF536CFC6AE793F3066A3CBB2FA")

         int phase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.973 -0400", hash_original_field = "F91E3A2A2CBD999A876853A563BB36E7", hash_generated_field = "F91E3A2A2CBD999A876853A563BB36E7")

         boolean interruptible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.974 -0400", hash_original_field = "80F2C9DEA054DF844EF56F6FF954DBA5", hash_generated_field = "80F2C9DEA054DF844EF56F6FF954DBA5")

         boolean timed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.974 -0400", hash_original_field = "BEEAAC669E416AB35AF621F5FA3D61EA", hash_generated_field = "BEEAAC669E416AB35AF621F5FA3D61EA")

        boolean wasInterrupted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.974 -0400", hash_original_field = "3393B365E8B101404D622780C19851C8", hash_generated_field = "3393B365E8B101404D622780C19851C8")

        long nanos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.975 -0400", hash_original_field = "23340FB624B1A8EB01A2BA3E8BBEDC84", hash_generated_field = "23340FB624B1A8EB01A2BA3E8BBEDC84")

         long deadline;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.975 -0400", hash_original_field = "AB87C4F6E5547EBD7483F34732EA576D", hash_generated_field = "3347E7A3168C0A597DE966A2AEA728E2")

        volatile Thread thread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.975 -0400", hash_original_field = "883318BF880BC299B37613DB978F7105", hash_generated_field = "883318BF880BC299B37613DB978F7105")

        QNode next;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.976 -0400", hash_original_method = "3B9BB7B443042C0737A54DDFCC3D98C3", hash_generated_method = "3B9BB7B443042C0737A54DDFCC3D98C3")
        
QNode(Phaser phaser, int phase, boolean interruptible,
              boolean timed, long nanos) {
            this.phaser = phaser;
            this.phase = phase;
            this.interruptible = interruptible;
            this.nanos = nanos;
            this.timed = timed;
            this.deadline = timed ? System.nanoTime() + nanos : 0L;
            thread = Thread.currentThread();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.977 -0400", hash_original_method = "ECDA6E128B84AAAF5C6E28E09951EEE6", hash_generated_method = "299EBCCE93A068DA57AE310169A3A4A1")
        
public boolean isReleasable() {
            if (thread == null)
                return true;
            if (phaser.getPhase() != phase) {
                thread = null;
                return true;
            }
            if (Thread.interrupted())
                wasInterrupted = true;
            if (wasInterrupted && interruptible) {
                thread = null;
                return true;
            }
            if (timed) {
                if (nanos > 0L) {
                    nanos = deadline - System.nanoTime();
                }
                if (nanos <= 0L) {
                    thread = null;
                    return true;
                }
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.977 -0400", hash_original_method = "2CF64276A71EB30A65490FF95ADD3677", hash_generated_method = "9858F545368A432345C2B877B5214254")
        
public boolean block() {
            if (isReleasable())
                return true;
            else if (!timed)
                LockSupport.park(this);
            else if (nanos > 0L)
                LockSupport.parkNanos(this, nanos);
            return isReleasable();
        }
    }

    /**
     * Variant of releaseWaiters that additionally tries to remove any
     * nodes no longer waiting for advance due to timeout or
     * interrupt. Currently, nodes are removed only if they are at
     * head of queue, which suffices to reduce memory footprint in
     * most usages.
     *
     * @return current phase on exit
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.969 -0400", hash_original_method = "4D2E2633ABA84B28EEB30E119DD80274", hash_generated_method = "3E1B338E3F128A996A955FE5E49BBD4A")
    
private int abortWait(int phase) {
        AtomicReference<QNode> head = (phase & 1) == 0 ? evenQ : oddQ;
        for (;;) {
            Thread t;
            QNode q = head.get();
            int p = (int)(root.state >>> PHASE_SHIFT);
            if (q == null || ((t = q.thread) != null && q.phase == p))
                return p;
            if (head.compareAndSet(q, q.next) && t != null) {
                q.thread = null;
                LockSupport.unpark(t);
            }
        }
    }

    /**
     * Possibly blocks and waits for phase to advance unless aborted.
     * Call only on root phaser.
     *
     * @param phase current phase
     * @param node if non-null, the wait node to track interrupt and timeout;
     * if null, denotes noninterruptible wait
     * @return current phase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:22.971 -0400", hash_original_method = "8E86CE3516C821BDCB62BBE2DB825108", hash_generated_method = "936384515711523E10D0690E4675B3CC")
    
private int internalAwaitAdvance(int phase, QNode node) {
        // assert root == this;
        releaseWaiters(phase-1);          // ensure old queue clean
        boolean queued = false;           // true when node is enqueued
        int lastUnarrived = 0;            // to increase spins upon change
        int spins = SPINS_PER_ARRIVAL;
        long s;
        int p;
        while ((p = (int)((s = state) >>> PHASE_SHIFT)) == phase) {
            if (node == null) {           // spinning in noninterruptible mode
                int unarrived = (int)s & UNARRIVED_MASK;
                if (unarrived != lastUnarrived &&
                    (lastUnarrived = unarrived) < NCPU)
                    spins += SPINS_PER_ARRIVAL;
                boolean interrupted = Thread.interrupted();
                if (interrupted || --spins < 0) { // need node to record intr
                    node = new QNode(this, phase, false, false, 0L);
                    node.wasInterrupted = interrupted;
                }
            }
            else if (node.isReleasable()) // done or aborted
                break;
            else if (!queued) {           // push onto queue
                AtomicReference<QNode> head = (phase & 1) == 0 ? evenQ : oddQ;
                QNode q = node.next = head.get();
                if ((q == null || q.phase == phase) &&
                    (int)(state >>> PHASE_SHIFT) == phase) // avoid stale enq
                    queued = head.compareAndSet(q, node);
            }
            else {
                try {
                    ForkJoinPool.managedBlock(node);
                } catch (InterruptedException ie) {
                    node.wasInterrupted = true;
                }
            }
        }

        if (node != null) {
            if (node.thread != null)
                node.thread = null;       // avoid need for unpark()
            if (node.wasInterrupted && !node.interruptible)
                Thread.currentThread().interrupt();
            if (p == phase && (p = (int)(state >>> PHASE_SHIFT)) == phase)
                return abortWait(phase); // possibly clean up on abort
        }
        releaseWaiters(phase);
        return p;
    }
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = Phaser.class;
            stateOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("state"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
