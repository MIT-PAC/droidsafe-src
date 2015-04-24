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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Written by Doug Lea, Bill Scherer, and Michael Scott with
 * assistance from members of JCP JSR-166 Expert Group and released to
 * the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;

import java.util.LinkedList;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.LockSupport;

public class Exchanger<V> {

    /**
     * Tries to cancel a wait for the given node waiting in the given
     * slot, if so, helping clear the node from its slot to avoid
     * garbage retention.
     *
     * @param node the waiting node
     * @param slot the slot it is waiting in
     * @return true if successfully cancelled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.295 -0500", hash_original_method = "B32071C09A97DFFF75EFFCE89615F3EB", hash_generated_method = "61FD94E30A48F185E47B147315A3A09A")
    
private static boolean tryCancel(Node node, Slot slot) {
        if (!node.compareAndSet(null, CANCEL))
            return false;
        if (slot.get() == node) // pre-check to minimize contention
            slot.compareAndSet(node, null);
        return true;
    }

    // Three forms of waiting. Each just different enough not to merge
    // code with others.

    /**
     * Spin-waits for hole for a non-0 slot.  Fails if spin elapses
     * before hole filled.  Does not check interrupt, relying on check
     * in public exchange method to abort if interrupted on entry.
     *
     * @param node the waiting node
     * @return on success, the hole; on failure, CANCEL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.298 -0500", hash_original_method = "CB278E99E24B4E735DC62BFED6C8971E", hash_generated_method = "7C09908AD80CEF2B2706D012825CE5C7")
    
private static Object spinWait(Node node, Slot slot) {
        int spins = SPINS;
        for (;;) {
            Object v = node.get();
            if (v != null)
                return v;
            else if (spins > 0)
                --spins;
            else
                tryCancel(node, slot);
        }
    }

    /**
     * Waits for (by spinning and/or blocking) and gets the hole
     * filled in by another thread.  Fails if interrupted before
     * hole filled.
     *
     * When a node/thread is about to block, it sets its waiter field
     * and then rechecks state at least one more time before actually
     * parking, thus covering race vs fulfiller noticing that waiter
     * is non-null so should be woken.
     *
     * Thread interruption status is checked only surrounding calls to
     * park.  The caller is assumed to have checked interrupt status
     * on entry.
     *
     * @param node the waiting node
     * @return on success, the hole; on failure, CANCEL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.301 -0500", hash_original_method = "4A9417958994593B8563D558E999EFC3", hash_generated_method = "452593542D6F488C7C8A4B5BED4615B3")
    
private static Object await(Node node, Slot slot) {
        Thread w = Thread.currentThread();
        int spins = SPINS;
        for (;;) {
            Object v = node.get();
            if (v != null)
                return v;
            else if (spins > 0)                 // Spin-wait phase
                --spins;
            else if (node.waiter == null)       // Set up to block next
                node.waiter = w;
            else if (w.isInterrupted())         // Abort on interrupt
                tryCancel(node, slot);
            else                                // Block
                LockSupport.park(node);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.238 -0500", hash_original_field = "75EA46F781370128B90C88B0C6C4F82B", hash_generated_field = "1914937029C009DA607D29A4480902A4")

    /** The number of CPUs, for sizing and spin control */
    private static final int NCPU = Runtime.getRuntime().availableProcessors();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.241 -0500", hash_original_field = "658001A3F32BFA905BFADA170C70835F", hash_generated_field = "E87A8F05D56205E03FD465D71DDC4E64")

    private static final int CAPACITY = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.244 -0500", hash_original_field = "490AEE0E797EC12921D65510D2246EF8", hash_generated_field = "19CBB79F5BAC3C02E55420AC3E96D83F")

    private static final int FULL =
        Math.max(0, Math.min(CAPACITY, NCPU / 2) - 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.254 -0500", hash_original_field = "A79899B0496423503C40E0DB439585BC", hash_generated_field = "DD5CFF62634AED5D259CB7E2ADD5133B")

    private static final int SPINS = (NCPU == 1) ? 0 : 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.257 -0500", hash_original_field = "A1D76156212CB35F4354BE922ECF1337", hash_generated_field = "76DBAB4631B1B171678A47C88BDDACA5")

    private static final int TIMED_SPINS = SPINS / 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.260 -0500", hash_original_field = "33C4533570ECDEC04E31CD62F398FAA0", hash_generated_field = "3B0C3CB8323B5C5F4FF4411ED327CEBB")

    private static final Object CANCEL = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.263 -0500", hash_original_field = "48EA6DDAF5010A87C48D3E20E00C1EFD", hash_generated_field = "C3444CF75E87B7410DAF194724DC011B")

    private static final Object NULL_ITEM = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.281 -0500", hash_original_field = "7BF435916F51C391155FF09EF03DE51E", hash_generated_field = "A4DE78C80A44A9FFB485B1FA97067F63")

    private volatile Slot[] arena = new Slot[CAPACITY];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.283 -0500", hash_original_field = "9FCE23DBEF09FBDEB8B4170F4CDBBBED", hash_generated_field = "C753B28A7DF93AEB959426A931313902")

    private final AtomicInteger max = new AtomicInteger();

	LinkedList<Object> droidsafeData;

    /**
     * Creates a new Exchanger.
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.309 -0500", hash_original_method = "7EAF111F5AA6799458B5BA4ED6EF193C", hash_generated_method = "F3DE1CB784C5627EDBD69D821D89A075")
    
public Exchanger() {
    	droidsafeData = new LinkedList<Object>();
    }
    
    private static final class Node extends AtomicReference<Object> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.266 -0500", hash_original_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB", hash_generated_field = "534A9EAE4E6170E4619513891411852D")

        public  Object item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.269 -0500", hash_original_field = "4DB9CE87B9CCE3428476BDB51EBE9EF1", hash_generated_field = "CD33F33C6B06BD5F7A2A693861D1129D")

        public volatile Thread waiter;

        /**
         * Creates node with given item and empty hole.
         * @param item the item
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.272 -0500", hash_original_method = "8076C86F5BED3901532DF78458E5A05E", hash_generated_method = "8E524DAF36E4E0F50709434963804CC6")
        
public Node(Object item) {
            this.item = item;
        }
        
    }
    
    private static final class Slot extends AtomicReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.499 -0400", hash_original_field = "61E23FC401E882840B471B3B125A68A9", hash_generated_field = "1AE1EC9FE6B62D9AC31A8484951D02A5")

        long q0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.500 -0400", hash_original_field = "FF33F1B12213E021C2C4A888141953BA", hash_generated_field = "9D63817BCE5C08A3499D963BC29E7F66")

        long q1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.501 -0400", hash_original_field = "74D502A7131CDAC90EECDFB0531C4E87", hash_generated_field = "4096B7091287D3D68D867A6771897C4F")

        long q2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.502 -0400", hash_original_field = "69855EDA6D7282DE712FEE7EB5235AB1", hash_generated_field = "E82AB112AC9A149E44FB6E32C8E09E74")

        long q3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.503 -0400", hash_original_field = "681568000CC3A37334495EF38FF48282", hash_generated_field = "B4D9EE16DDBAB58D380983755645DB49")

        long q4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.504 -0400", hash_original_field = "352DDE4B72AE781FA1E061FE65EA7251", hash_generated_field = "DBDFEC8FB0C7ECD3F3CA2A742D957B97")

        long q5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.505 -0400", hash_original_field = "794222D5B33EDD2899D9F35E54CE966D", hash_generated_field = "4C9823271DD5F4B81133463A0FEDC422")

        long q6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.506 -0400", hash_original_field = "D65D03B02D5E9DD09DC19AD398987C61", hash_generated_field = "B772E7DFC6765B74FB0E3747F9735B14")

        long q7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.508 -0400", hash_original_field = "AD09072A2B3DA610E4D7180D6B833BC6", hash_generated_field = "B8CFD15EAF457DFB518AC3E77AFD5E83")

        long q8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.509 -0400", hash_original_field = "F9734637B58C055CE3ED8E38B41D0E17", hash_generated_field = "2D39EC99CB4E8C24CEB9642AF7C84A0E")

        long q9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.510 -0400", hash_original_field = "8264EE52F589F4C0191AA94F87AA1AEB", hash_generated_field = "180A8E76D6A8305349F33B06C403CD60")

        long qa;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.511 -0400", hash_original_field = "0D47B8346D57B12A5807C36FB1F14F3C", hash_generated_field = "691C04E05AC23F83FF5C8CDB3328B8ED")

        long qb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.513 -0400", hash_original_field = "9300C96AAEC324987EA5CA6E13A02EDA", hash_generated_field = "C837DB7B40EE95DCD5A34423EAF7C2B6")

        long qc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.515 -0400", hash_original_field = "98877902E81C1A83B58EEE2FF38DD17B", hash_generated_field = "91773591A5407D8E2D5234C2E0661439")

        long qd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.517 -0400", hash_original_field = "4D6E7051B02397D7733EA9A222FDB8E0", hash_generated_field = "2E6D34B3E7F049D1453E6B068E27473D")

        long qe;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.518 -0400", hash_original_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F", hash_generated_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F")
        public Slot ()
        {
            //Synthesized constructor
        }

    }

    /**
     * Main exchange function, handling the different policy variants.
     * Uses Object, not "V" as argument and return value to simplify
     * handling of sentinel values.  Callers from public methods decode
     * and cast accordingly.
     *
     * @param item the (non-null) item to exchange
     * @param timed true if the wait is timed
     * @param nanos if timed, the maximum wait time
     * @return the other thread's item, or CANCEL if interrupted or timed out
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.288 -0500", hash_original_method = "85CC613BF9709593CA039307E2227217", hash_generated_method = "F999AB1DA8ED0568D23A16ABFD90AFE4")
    
private Object doExchange(Object item, boolean timed, long nanos) {
    	/*
        Node me = new Node(item);                 // Create in case occupying
        int index = hashIndex();                  // Index of current slot
        int fails = 0;                            // Number of CAS failures

        for (;;) {
            Object y;                             // Contents of current slot
            Slot slot = arena[index];
            if (slot == null)                     // Lazily initialize slots
                createSlot(index);                // Continue loop to reread
            else if ((y = slot.get()) != null &&  // Try to fulfill
                     slot.compareAndSet(y, null)) {
                Node you = (Node)y;               // Transfer item
                if (you.compareAndSet(null, item)) {
                    LockSupport.unpark(you.waiter);
                    return you.item;
                }                                 // Else cancelled; continue
            }
            else if (y == null &&                 // Try to occupy
                     slot.compareAndSet(null, me)) {
                if (index == 0)                   // Blocking wait for slot 0
                    return timed ?
                        awaitNanos(me, slot, nanos) :
                        await(me, slot);
                Object v = spinWait(me, slot);    // Spin wait for non-0
                if (v != CANCEL)
                    return v;
                me = new Node(item);              // Throw away cancelled node
                int m = max.get();
                if (m > (index >>>= 1))           // Decrease index
                    max.compareAndSet(m, m - 1);  // Maybe shrink table
            }
            else if (++fails > 1) {               // Allow 2 fails on 1st slot
                int m = max.get();
                if (fails > 3 && m < FULL && max.compareAndSet(m, m + 1))
                    index = m + 1;                // Grow on 3rd failed slot
                else if (--index < 0)
                    index = m;                    // Circularly traverse
            }
        }
        */
    	droidsafeData.add(item);
    	
    	return droidsafeData.getFirst();
    	
    }

    /**
     * Returns a hash index for the current thread.  Uses a one-step
     * FNV-1a hash code (http://www.isthe.com/chongo/tech/comp/fnv/)
     * based on the current thread's Thread.getId().  These hash codes
     * have more uniform distribution properties with respect to small
     * moduli (here 1-31) than do other simple hashing functions.
     *
     * <p>To return an index between 0 and max, we use a cheap
     * approximation to a mod operation, that also corrects for bias
     * due to non-power-of-2 remaindering (see {@link
     * java.util.Random#nextInt}).  Bits of the hashcode are masked
     * with "nbits", the ceiling power of two of table size (looked up
     * in a table packed into three ints).  If too large, this is
     * retried after rotating the hash by nbits bits, while forcing new
     * top bit to 0, which guarantees eventual termination (although
     * with a non-random-bias).  This requires an average of less than
     * 2 tries for all table sizes, and has a maximum 2% difference
     * from perfectly uniform slot probabilities when applied to all
     * possible hash codes for sizes less than 32.
     *
     * @return a per-thread-random index, 0 <= index < max
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.290 -0500", hash_original_method = "81A7A8FE33AEB39DC2465115E332A8B2", hash_generated_method = "E307B358374E191481F8EF8CDC8D99E6")
    
private final int hashIndex() {
        long id = Thread.currentThread().getId();
        int hash = (((int)(id ^ (id >>> 32))) ^ 0x811c9dc5) * 0x01000193;

        int m = max.get();
        int nbits = (((0xfffffc00  >> m) & 4) | // Compute ceil(log2(m+1))
                     ((0x000001f8 >>> m) & 2) | // The constants hold
                     ((0xffff00f2 >>> m) & 1)); // a lookup table
        int index;
        while ((index = hash & ((1 << nbits) - 1)) > m)       // May retry on
            hash = (hash >>> nbits) | (hash << (33 - nbits)); // non-power-2 m
        return index;
    }

    /**
     * Creates a new slot at given index.  Called only when the slot
     * appears to be null.  Relies on double-check using builtin
     * locks, since they rarely contend.  This in turn relies on the
     * arena array being declared volatile.
     *
     * @param index the index to add slot at
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.293 -0500", hash_original_method = "710CA77564EC78E634B8090E5C600333", hash_generated_method = "F86F43D6D2A26E9F7B2A2BE42B2598B8")
    
private void createSlot(int index) {
        // Create slot outside of lock to narrow sync region
        Slot newSlot = new Slot();
        Slot[] a = arena;
        synchronized (a) {
            if (a[index] == null)
                a[index] = newSlot;
        }
    }

    /**
     * Waits for (at index 0) and gets the hole filled in by another
     * thread.  Fails if timed out or interrupted before hole filled.
     * Same basic logic as untimed version, but a bit messier.
     *
     * @param node the waiting node
     * @param nanos the wait time
     * @return on success, the hole; on failure, CANCEL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.304 -0500", hash_original_method = "B05B09390509B455A836B09E2A65E5D4", hash_generated_method = "B303ADC082E4C769878DBBA7904F78F9")
    
private Object awaitNanos(Node node, Slot slot, long nanos) {
        int spins = TIMED_SPINS;
        long lastTime = 0;
        Thread w = null;
        for (;;) {
            Object v = node.get();
            if (v != null)
                return v;
            long now = System.nanoTime();
            if (w == null)
                w = Thread.currentThread();
            else
                nanos -= now - lastTime;
            lastTime = now;
            if (nanos > 0) {
                if (spins > 0)
                    --spins;
                else if (node.waiter == null)
                    node.waiter = w;
                else if (w.isInterrupted())
                    tryCancel(node, slot);
                else
                    LockSupport.parkNanos(node, nanos);
            }
            else if (tryCancel(node, slot) && !w.isInterrupted())
                return scanOnTimeout(node);
        }
    }

    /**
     * Sweeps through arena checking for any waiting threads.  Called
     * only upon return from timeout while waiting in slot 0.  When a
     * thread gives up on a timed wait, it is possible that a
     * previously-entered thread is still waiting in some other
     * slot.  So we scan to check for any.  This is almost always
     * overkill, but decreases the likelihood of timeouts when there
     * are other threads present to far less than that in lock-based
     * exchangers in which earlier-arriving threads may still be
     * waiting on entry locks.
     *
     * @param node the waiting node
     * @return another thread's item, or CANCEL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.307 -0500", hash_original_method = "968A2928C62BC7FCD22DA53EF68519F2", hash_generated_method = "A1337444E5DDD8166BCC5747E4B6D72D")
    
private Object scanOnTimeout(Node node) {
        Object y;
        for (int j = arena.length - 1; j >= 0; --j) {
            Slot slot = arena[j];
            if (slot != null) {
                while ((y = slot.get()) != null) {
                    if (slot.compareAndSet(y, null)) {
                        Node you = (Node)y;
                        if (you.compareAndSet(null, node.item)) {
                            LockSupport.unpark(you.waiter);
                            return you.item;
                        }
                    }
                }
            }
        }
        return CANCEL;
    }

    /**
     * Waits for another thread to arrive at this exchange point (unless
     * the current thread is {@linkplain Thread#interrupt interrupted}),
     * and then transfers the given object to it, receiving its object
     * in return.
     *
     * <p>If another thread is already waiting at the exchange point then
     * it is resumed for thread scheduling purposes and receives the object
     * passed in by the current thread.  The current thread returns immediately,
     * receiving the object passed to the exchange by that other thread.
     *
     * <p>If no other thread is already waiting at the exchange then the
     * current thread is disabled for thread scheduling purposes and lies
     * dormant until one of two things happens:
     * <ul>
     * <li>Some other thread enters the exchange; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts}
     * the current thread.
     * </ul>
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while waiting
     * for the exchange,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     *
     * @param x the object to exchange
     * @return the object provided by the other thread
     * @throws InterruptedException if the current thread was
     *         interrupted while waiting
     */
    @DSComment("General android/java operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.312 -0500", hash_original_method = "01BD898C994460F5196927F0C5114F9E", hash_generated_method = "43B9B19E5F9A3C4248EA65E9663E2CE1")
    
public V exchange(V x) throws InterruptedException {
        if (!Thread.interrupted()) {
            Object v = doExchange((x == null) ? NULL_ITEM : x, false, 0);
            if (v == NULL_ITEM)
                return null;
            if (v != CANCEL)
                return (V)v;
            Thread.interrupted(); // Clear interrupt status on IE throw
        }
        throw new InterruptedException();
    }

    /**
     * Waits for another thread to arrive at this exchange point (unless
     * the current thread is {@linkplain Thread#interrupt interrupted} or
     * the specified waiting time elapses), and then transfers the given
     * object to it, receiving its object in return.
     *
     * <p>If another thread is already waiting at the exchange point then
     * it is resumed for thread scheduling purposes and receives the object
     * passed in by the current thread.  The current thread returns immediately,
     * receiving the object passed to the exchange by that other thread.
     *
     * <p>If no other thread is already waiting at the exchange then the
     * current thread is disabled for thread scheduling purposes and lies
     * dormant until one of three things happens:
     * <ul>
     * <li>Some other thread enters the exchange; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts}
     * the current thread; or
     * <li>The specified waiting time elapses.
     * </ul>
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while waiting
     * for the exchange,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     *
     * <p>If the specified waiting time elapses then {@link
     * TimeoutException} is thrown.  If the time is less than or equal
     * to zero, the method will not wait at all.
     *
     * @param x the object to exchange
     * @param timeout the maximum time to wait
     * @param unit the time unit of the <tt>timeout</tt> argument
     * @return the object provided by the other thread
     * @throws InterruptedException if the current thread was
     *         interrupted while waiting
     * @throws TimeoutException if the specified waiting time elapses
     *         before another thread enters the exchange
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.316 -0500", hash_original_method = "32FED615BD7111CFC755561A988F29C6", hash_generated_method = "353387BCE1C0F5CE7848F502F5F2B44A")
    
public V exchange(V x, long timeout, TimeUnit unit)
        throws InterruptedException, TimeoutException {
        if (!Thread.interrupted()) {
            Object v = doExchange((x == null) ? NULL_ITEM : x,
                                  true, unit.toNanos(timeout));
            if (v == NULL_ITEM)
                return null;
            if (v != CANCEL)
                return (V)v;
            if (!Thread.interrupted())
                throw new TimeoutException();
        }
        throw new InterruptedException();
    }
}

