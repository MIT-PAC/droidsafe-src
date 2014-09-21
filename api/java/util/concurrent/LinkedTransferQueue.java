/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

// BEGIN android-note
// removed link to collections framework docs
// END android-note

/**
 * An unbounded {@link TransferQueue} based on linked nodes.
 * This queue orders elements FIFO (first-in-first-out) with respect
 * to any given producer.  The <em>head</em> of the queue is that
 * element that has been on the queue the longest time for some
 * producer.  The <em>tail</em> of the queue is that element that has
 * been on the queue the shortest time for some producer.
 *
 * <p>Beware that, unlike in most collections, the {@code size} method
 * is <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these queues, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * concurrently with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.
 *
 * <p>Memory consistency effects: As with other concurrent
 * collections, actions in a thread prior to placing an object into a
 * {@code LinkedTransferQueue}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code LinkedTransferQueue} in another thread.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public class LinkedTransferQueue<E> extends AbstractQueue<E>
    implements TransferQueue<E>, java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.692 -0400", hash_original_field = "D05A7E9A1950F325B120E64C6656BBF1", hash_generated_field = "1E3367DE63E4A43E00AB1E404902880B")

    private static final long serialVersionUID = -3223113410248163686L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.694 -0400", hash_original_field = "F5A2EA00E5A87C0D5118101266B15567", hash_generated_field = "7CBB8D55F3CB2736D499977E99BF34E7")


    /** True if on multiprocessor */
    private static final boolean MP =
        Runtime.getRuntime().availableProcessors() > 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.694 -0400", hash_original_field = "0D42A6E8040F57BEC0464C349C4149B4", hash_generated_field = "57D10DFD9E24564B539CB70669883FE7")

    private static final int FRONT_SPINS   = 1 << 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.695 -0400", hash_original_field = "75CE84D97AFD3F654327FAA7A6557EE0", hash_generated_field = "A3E33A9993CBDEC2FF08E5833B0953C8")

    private static final int CHAINED_SPINS = FRONT_SPINS >>> 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.695 -0400", hash_original_field = "460C1ED602A46C50AD83FD82379D56AF", hash_generated_field = "83FB11E5CCE17667988EFA23994E854F")

    static final int SWEEP_THRESHOLD = 32;

    /**
     * Queue nodes. Uses Object, not E, for items to allow forgetting
     * them after use.  Relies heavily on Unsafe mechanics to minimize
     * unnecessary ordering constraints: Writes that are intrinsically
     * ordered wrt other accesses or CASes use simple relaxed forms.
     */
    static final class Node {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.701 -0400", hash_original_field = "F98008B543A0AC1B6CA4437D71C7B396", hash_generated_field = "2D526A695C4A7304F08467EA6C8FD880")


        private static final long serialVersionUID = -3375979862319811754L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.702 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

        private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.702 -0400", hash_original_field = "45136B470DA210012D0F0A8256A63486", hash_generated_field = "E48E252FA32E9E911DB7C7CDABFD5883")

        private static  long itemOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.703 -0400", hash_original_field = "3EFA6AE93B76F6C9D723C832889F59D2", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

        private static  long nextOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.703 -0400", hash_original_field = "421074D9060E35A7841B8F47194B5A42", hash_generated_field = "80B7D59F10EDA521F564F258CC5FF260")

        private static  long waiterOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.696 -0400", hash_original_field = "13998CD9DB54AD99E9DAFA28EE2691E9", hash_generated_field = "13998CD9DB54AD99E9DAFA28EE2691E9")

         boolean isData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.696 -0400", hash_original_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB", hash_generated_field = "572C92874AD4D49E8D97420DECC4EA3C")

        volatile Object item;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.696 -0400", hash_original_field = "84BAF34C0651B62073EBAA871E7E586B", hash_generated_field = "495F81DE1A0BB70B1CC0F10199933490")

        volatile Node next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.697 -0400", hash_original_field = "4DB9CE87B9CCE3428476BDB51EBE9EF1", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

        volatile Thread waiter;

        /**
         * Constructs a new node.  Uses relaxed write because item can
         * only be seen after publication via casNext.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.698 -0400", hash_original_method = "930BFD52E6B403D3AE39B0DCC1C0944A", hash_generated_method = "9D853BB59F90A873BD76A19D9B80C5CF")
        
Node(Object item, boolean isData) {
            UNSAFE.putObject(this, itemOffset, item); // relaxed write
            this.isData = isData;
        } // null until waiting

        // CAS methods for fields
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.697 -0400", hash_original_method = "DCAE3E2B6BDA422C30635CEB011B79DF", hash_generated_method = "9B1A4751328F9CA0C424736F5A7BCC50")
        
final boolean casNext(Node cmp, Node val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.698 -0400", hash_original_method = "00790FF0C4FFC132FBD18DB52BB4154B", hash_generated_method = "4E4B2E64FE294D4A492C2FF47F3ECC8F")
        
final boolean casItem(Object cmp, Object val) {
            // assert cmp == null || cmp.getClass() != Node.class;
            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        /**
         * Links node to itself to avoid garbage retention.  Called
         * only after CASing head field, so uses relaxed write.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.699 -0400", hash_original_method = "01C3313BC37C00736B149DF30B7D5941", hash_generated_method = "A0FFC05DE73F23FB5C1C61C551AC1D19")
        
final void forgetNext() {
            UNSAFE.putObject(this, nextOffset, this);
        }

        /**
         * Sets item to self and waiter to null, to avoid garbage
         * retention after matching or cancelling. Uses relaxed writes
         * because order is already constrained in the only calling
         * contexts: item is forgotten only after volatile/atomic
         * mechanics that extract items.  Similarly, clearing waiter
         * follows either CAS or return from park (if ever parked;
         * else we don't care).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.699 -0400", hash_original_method = "E9955A41F5CD18488E47A96E9C7926C7", hash_generated_method = "CACC204822DEFCDB40E799536686DC22")
        
final void forgetContents() {
            UNSAFE.putObject(this, itemOffset, this);
            UNSAFE.putObject(this, waiterOffset, null);
        }

        /**
         * Returns true if this node has been matched, including the
         * case of artificial matches due to cancellation.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.700 -0400", hash_original_method = "945094A2860DB0150C551BBD80B2236C", hash_generated_method = "68A9701D706038934E9E38AFAF37DD61")
        
final boolean isMatched() {
            Object x = item;
            return (x == this) || ((x == null) == isData);
        }

        /**
         * Returns true if this is an unmatched request node.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.700 -0400", hash_original_method = "0193751AAA804ED5CB76B9DFD0A89C43", hash_generated_method = "4C177C435DD368C07D0A28449E0D2EEB")
        
final boolean isUnmatchedRequest() {
            return !isData && item == null;
        }

        /**
         * Returns true if a node with the given mode cannot be
         * appended to this node because this node is unmatched and
         * has opposite data mode.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.701 -0400", hash_original_method = "D0DBD07AC167C30966D96C90DE90DB8C", hash_generated_method = "DD11EE338892C8EC3BBB15C8DF3CA3E3")
        
final boolean cannotPrecede(boolean haveData) {
            boolean d = isData;
            Object x;
            return d != haveData && (x = item) != this && (x != null) == d;
        }

        /**
         * Tries to artificially match a data node -- used by remove.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.701 -0400", hash_original_method = "A6FCE67D86594262DC3C3EA8CFE3DAB5", hash_generated_method = "264A4E2C06ABA90BE2217E4E86052987")
        
final boolean tryMatchData() {
            // assert isData;
            Object x = item;
            if (x != null && x != this && casItem(x, null)) {
                LockSupport.unpark(waiter);
                return true;
            }
            return false;
        }
        static {
            try {
                UNSAFE = sun.misc.Unsafe.getUnsafe();
                Class<?> k = Node.class;
                itemOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("next"));
                waiterOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("waiter"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.707 -0400", hash_original_field = "D11DD64CDAFC295651A2AF0786B616E1", hash_generated_field = "B5628CF639F6CA1B67C8B16E483ED9F4")

    private static final int NOW   = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.708 -0400", hash_original_field = "5844354E8A55596EA78C03A5F56BD4C9", hash_generated_field = "EE86F142C65DDABBEB43EBA380E888BF")

    private static final int ASYNC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.708 -0400", hash_original_field = "8F85EECECA5A1B9C70BFCEE6E9799D16", hash_generated_field = "740944DDBCAE305C772108B6610B8871")

    private static final int SYNC  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.709 -0400", hash_original_field = "89A8539E232916E0AE373E2C7B49ADBD", hash_generated_field = "2D2BB45C12E26BBFE09E6FF1E3973C06")

    private static final int TIMED = 3; // for timed poll, tryTransfer

    @SuppressWarnings("unchecked")
    static <E> E cast(Object item) {
        // assert item == null || item.getClass() != Node.class;
        return (E) item;
    }

    /**
     * Returns spin/yield value for a node with given predecessor and
     * data mode. See above for explanation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.714 -0400", hash_original_method = "BE83EA2C9E1EB2EC29161E3DAD228061", hash_generated_method = "D922373678E66612A09917D044B663EA")
    
private static int spinsFor(Node pred, boolean haveData) {
        if (MP && pred != null) {
            if (pred.isData != haveData)      // phase change
                return FRONT_SPINS + CHAINED_SPINS;
            if (pred.isMatched())             // probably at front
                return FRONT_SPINS;
            if (pred.waiter == null)          // pred apparently spinning
                return CHAINED_SPINS;
        }
        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.735 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")


    private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.736 -0400", hash_original_field = "3706253715619D88D23853C13B9CE0EE", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static  long headOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.736 -0400", hash_original_field = "4A1CAF0399870C61B250285BB267C733", hash_generated_field = "8B58E2B37A159AAD83A5260C2F388DB2")

    private static  long tailOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.737 -0400", hash_original_field = "39C8D2FA98B6F44BDB9225757C1895EB", hash_generated_field = "FA61B413F1CFCFC225268ECDB98C3607")

    private static  long sweepVotesOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.705 -0400", hash_original_field = "4F8EFB280F1E129CD523B8D361F8E738", hash_generated_field = "03D73E19AF0AF828B29B4624A65CF8B6")

    transient volatile Node head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.705 -0400", hash_original_field = "6A84217F0ED80447129807E1F9968FC6", hash_generated_field = "AD93D08E1C37116EBC071C3224E8414A")

    private transient volatile Node tail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.706 -0400", hash_original_field = "5343B377080276306581A8F628BD174A", hash_generated_field = "C3E4F35689DC9E39D5927B92B6EFA7F0")

    private transient volatile int sweepVotes;

    /**
     * Creates an initially empty {@code LinkedTransferQueue}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.725 -0400", hash_original_method = "572F52060198FE14B3AA06AD9DC079DE", hash_generated_method = "25B8B2FA7FD608039AC1089F37046784")
    
public LinkedTransferQueue() {
    }

    /**
     * Creates a {@code LinkedTransferQueue}
     * initially containing the elements of the given collection,
     * added in traversal order of the collection's iterator.
     *
     * @param c the collection of elements to initially contain
     * @throws NullPointerException if the specified collection or any
     *         of its elements are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.725 -0400", hash_original_method = "3D55809F9FDA8C076DBBCBE8F3424A26", hash_generated_method = "265F00388BEE3D1E6BFD158C19511FF3")
    
public LinkedTransferQueue(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    // CAS methods for fields
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.706 -0400", hash_original_method = "6CDBAE33BFFAD59994A05C472F734484", hash_generated_method = "782AB16D42BDBFB0CDC4C2245536332B")
    
private boolean casTail(Node cmp, Node val) {
        return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.707 -0400", hash_original_method = "F564EE6ACC6B9E78C64B7CE5F295AF6D", hash_generated_method = "FFA0084B202B715DCD2B6BA8BE242E4C")
    
private boolean casHead(Node cmp, Node val) {
        return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.707 -0400", hash_original_method = "1DAA2BF5FF945F32A3CD0FF1D1DCD53F", hash_generated_method = "5A2514272B39D7592D78F0B67928FF00")
    
private boolean casSweepVotes(int cmp, int val) {
        return UNSAFE.compareAndSwapInt(this, sweepVotesOffset, cmp, val);
    }

    /**
     * Implements all queuing methods. See above for explanation.
     *
     * @param e the item or null for take
     * @param haveData true if this is a put, else a take
     * @param how NOW, ASYNC, SYNC, or TIMED
     * @param nanos timeout in nanosecs, used only if mode is TIMED
     * @return an item if matched, else e
     * @throws NullPointerException if haveData mode but e is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.711 -0400", hash_original_method = "FD0D5D22615AC7853E0B6C93B9E217EA", hash_generated_method = "4E080F4EA3D4D9809C54BD628B1E45C3")
    
private E xfer(E e, boolean haveData, int how, long nanos) {
        if (haveData && (e == null))
            throw new NullPointerException();
        Node s = null;                        // the node to append, if needed

        retry:
        for (;;) {                            // restart on append race

            for (Node h = head, p = h; p != null;) { // find & match first node
                boolean isData = p.isData;
                Object item = p.item;
                if (item != p && (item != null) == isData) { // unmatched
                    if (isData == haveData)   // can't match
                        break;
                    if (p.casItem(item, e)) { // match
                        for (Node q = p; q != h;) {
                            Node n = q.next;  // update by 2 unless singleton
                            if (head == h && casHead(h, n == null ? q : n)) {
                                h.forgetNext();
                                break;
                            }                 // advance and retry
                            if ((h = head)   == null ||
                                (q = h.next) == null || !q.isMatched())
                                break;        // unless slack < 2
                        }
                        LockSupport.unpark(p.waiter);
                        return LinkedTransferQueue.<E>cast(item);
                    }
                }
                Node n = p.next;
                p = (p != n) ? n : (h = head); // Use head if p offlist
            }

            if (how != NOW) {                 // No matches available
                if (s == null)
                    s = new Node(e, haveData);
                Node pred = tryAppend(s, haveData);
                if (pred == null)
                    continue retry;           // lost race vs opposite mode
                if (how != ASYNC)
                    return awaitMatch(s, pred, e, (how == TIMED), nanos);
            }
            return e; // not waiting
        }
    }

    final class Itr implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.717 -0400", hash_original_field = "B98C618EDE71B27165B3AD24CD1F5C37", hash_generated_field = "98C87982C4E0F85C37135C54BAA241B2")

        private Node nextNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.717 -0400", hash_original_field = "FC047D97EB4DD102072D6594B14B8B33", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.718 -0400", hash_original_field = "FB8CCD62D631AC774FD7D648DD2010B6", hash_generated_field = "71F42332A10F1D597DC7016844610A30")

        private Node lastRet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.718 -0400", hash_original_field = "376D51D119AD6956A88F044A444371FC", hash_generated_field = "552A6F43B71E3DE404AE00F3305F24ED")

        private Node lastPred;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.720 -0400", hash_original_method = "D66E8C5D511AFC39F0DAC827C4911DE9", hash_generated_method = "D66E8C5D511AFC39F0DAC827C4911DE9")
        
Itr() {
            advance(null);
        }   // predecessor to unlink lastRet

        /**
         * Moves to next node after prev, or first node if prev null.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.719 -0400", hash_original_method = "60588CD85133525EB441900D3924F379", hash_generated_method = "832E4C766BD95727C78233D06694A8D6")
        
private void advance(Node prev) {
            /*
             * To track and avoid buildup of deleted nodes in the face
             * of calls to both Queue.remove and Itr.remove, we must
             * include variants of unsplice and sweep upon each
             * advance: Upon Itr.remove, we may need to catch up links
             * from lastPred, and upon other removes, we might need to
             * skip ahead from stale nodes and unsplice deleted ones
             * found while advancing.
             */

            Node r, b; // reset lastPred upon possible deletion of lastRet
            if ((r = lastRet) != null && !r.isMatched())
                lastPred = r;    // next lastPred is old lastRet
            else if ((b = lastPred) == null || b.isMatched())
                lastPred = null; // at start of list
            else {
                Node s, n;       // help with removal of lastPred.next
                while ((s = b.next) != null &&
                       s != b && s.isMatched() &&
                       (n = s.next) != null && n != s)
                    b.casNext(s, n);
            }

            this.lastRet = prev;

            for (Node p = prev, s, n;;) {
                s = (p == null) ? head : p.next;
                if (s == null)
                    break;
                else if (s == p) {
                    p = null;
                    continue;
                }
                Object item = s.item;
                if (s.isData) {
                    if (item != null && item != s) {
                        nextItem = LinkedTransferQueue.<E>cast(item);
                        nextNode = s;
                        return;
                    }
                }
                else if (item == null)
                    break;
                // assert s.isMatched();
                if (p == null)
                    p = s;
                else if ((n = s.next) == null)
                    break;
                else if (s == n)
                    p = null;
                else
                    p.casNext(s, n);
            }
            nextNode = null;
            nextItem = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.720 -0400", hash_original_method = "F3203522041DB53AA10973946A26B4E6", hash_generated_method = "B4E6B3B7E281EEA5CF8CB2E9E4936AF8")
        
public final boolean hasNext() {
            return nextNode != null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.720 -0400", hash_original_method = "73A7683D5791FAEB9AA3EBAB43D3F6C8", hash_generated_method = "9E1B095B965E9216A0F2D03BC8201C6A")
        
public final E next() {
            Node p = nextNode;
            if (p == null) throw new NoSuchElementException();
            E e = nextItem;
            advance(p);
            return e;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.721 -0400", hash_original_method = "DAB6CC7909F5460D548223E7B485BEBB", hash_generated_method = "1B348FE03E9C5E77415E24573150093B")
        
public final void remove() {
            final Node lastRet = this.lastRet;
            if (lastRet == null)
                throw new IllegalStateException();
            this.lastRet = null;
            if (lastRet.tryMatchData())
                unsplice(lastPred, lastRet);
        }
    }

    /**
     * Tries to append node s as tail.
     *
     * @param s the node to append
     * @param haveData true if appending in data mode
     * @return null on failure due to losing race with append in
     * different mode, else s's predecessor, or s itself if no
     * predecessor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.712 -0400", hash_original_method = "17BEC7AD4EF43697B3AF7D584BCB72F9", hash_generated_method = "3D2CC343A41576EE2BAAF63930DC03F0")
    
private Node tryAppend(Node s, boolean haveData) {
        for (Node t = tail, p = t;;) {        // move p to last node and append
            Node n, u;                        // temps for reads of next & tail
            if (p == null && (p = head) == null) {
                if (casHead(null, s))
                    return s;                 // initialize
            }
            else if (p.cannotPrecede(haveData))
                return null;                  // lost race vs opposite mode
            else if ((n = p.next) != null)    // not last; keep traversing
                p = p != t && t != (u = tail) ? (t = u) : // stale tail
                    (p != n) ? n : null;      // restart if off list
            else if (!p.casNext(null, s))
                p = p.next;                   // re-read on CAS failure
            else {
                if (p != t) {                 // update if slack now >= 2
                    while ((tail != t || !casTail(t, s)) &&
                           (t = tail)   != null &&
                           (s = t.next) != null && // advance and retry
                           (s = s.next) != null && s != t);
                }
                return p;
            }
        }
    }

    /**
     * Spins/yields/blocks until node s is matched or caller gives up.
     *
     * @param s the waiting node
     * @param pred the predecessor of s, or s itself if it has no
     * predecessor, or null if unknown (the null case does not occur
     * in any current calls but may in possible future extensions)
     * @param e the comparison value for checking match
     * @param timed if true, wait only until timeout elapses
     * @param nanos timeout in nanosecs, used only if timed is true
     * @return matched item, or e if unmatched on interrupt or timeout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.714 -0400", hash_original_method = "B75985DBE9C86276C11F49FADAAE7988", hash_generated_method = "E604835DDFDA05A5751CD0F5EBE56E60")
    
private E awaitMatch(Node s, Node pred, E e, boolean timed, long nanos) {
        final long deadline = timed ? System.nanoTime() + nanos : 0L;
        Thread w = Thread.currentThread();
        int spins = -1; // initialized after first item and cancel checks
        ThreadLocalRandom randomYields = null; // bound if needed

        for (;;) {
            Object item = s.item;
            if (item != e) {                  // matched
                // assert item != s;
                s.forgetContents();           // avoid garbage
                return LinkedTransferQueue.<E>cast(item);
            }
            if ((w.isInterrupted() || (timed && nanos <= 0)) &&
                    s.casItem(e, s)) {        // cancel
                unsplice(pred, s);
                return e;
            }

            if (spins < 0) {                  // establish spins at/near front
                if ((spins = spinsFor(pred, s.isData)) > 0)
                    randomYields = ThreadLocalRandom.current();
            }
            else if (spins > 0) {             // spin
                --spins;
                if (randomYields.nextInt(CHAINED_SPINS) == 0)
                    Thread.yield();           // occasionally yield
            }
            else if (s.waiter == null) {
                s.waiter = w;                 // request unpark then recheck
            }
            else if (timed) {
                nanos = deadline - System.nanoTime();
                if (nanos > 0L)
                    LockSupport.parkNanos(this, nanos);
            }
            else {
                LockSupport.park(this);
            }
        }
    }

    /* -------------- Traversal methods -------------- */

    /**
     * Returns the successor of p, or the head node if p.next has been
     * linked to self, which will only be true if traversing with a
     * stale pointer that is now off the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.715 -0400", hash_original_method = "26D13C01C28656EED46780E05D03A406", hash_generated_method = "E69081FA623E19CCD4887F078C148295")
    
final Node succ(Node p) {
        Node next = p.next;
        return (p == next) ? head : next;
    }

    /**
     * Returns the first unmatched node of the given mode, or null if
     * none.  Used by methods isEmpty, hasWaitingConsumer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.715 -0400", hash_original_method = "BDDB4C21EB61EAF0B9C254BC012558D2", hash_generated_method = "5632AA010137C3098D55DA2C3B5E845F")
    
private Node firstOfMode(boolean isData) {
        for (Node p = head; p != null; p = succ(p)) {
            if (!p.isMatched())
                return (p.isData == isData) ? p : null;
        }
        return null;
    }

    /**
     * Returns the item in the first unmatched node with isData; or
     * null if none.  Used by peek.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.716 -0400", hash_original_method = "E9F5B62F706233C2ADF039E35300834B", hash_generated_method = "152218E268EE18A51688E0EF9E7A2E28")
    
private E firstDataItem() {
        for (Node p = head; p != null; p = succ(p)) {
            Object item = p.item;
            if (p.isData) {
                if (item != null && item != p)
                    return LinkedTransferQueue.<E>cast(item);
            }
            else if (item == null)
                return null;
        }
        return null;
    }

    /**
     * Traverses and counts unmatched nodes of the given mode.
     * Used by methods size and getWaitingConsumerCount.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.716 -0400", hash_original_method = "E10BC923F0B48F117C617A8C2999379D", hash_generated_method = "4EC571B131DC589BBDD2D0EDB3F98B9C")
    
private int countOfMode(boolean data) {
        int count = 0;
        for (Node p = head; p != null; ) {
            if (!p.isMatched()) {
                if (p.isData != data)
                    return 0;
                if (++count == Integer.MAX_VALUE) // saturated
                    break;
            }
            Node n = p.next;
            if (n != p)
                p = n;
            else {
                count = 0;
                p = head;
            }
        }
        return count;
    }

    /* -------------- Removal methods -------------- */

    /**
     * Unsplices (now or later) the given deleted/cancelled node with
     * the given predecessor.
     *
     * @param pred a node that was at one time known to be the
     * predecessor of s, or null or s itself if s is/was at head
     * @param s the node to be unspliced
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.723 -0400", hash_original_method = "E76D6159725CEBB486CB0BAB91729041", hash_generated_method = "FAD7F25542D518C23F190AC1C8A02A15")
    
final void unsplice(Node pred, Node s) {
        s.forgetContents(); // forget unneeded fields
        /*
         * See above for rationale. Briefly: if pred still points to
         * s, try to unlink s.  If s cannot be unlinked, because it is
         * trailing node or pred might be unlinked, and neither pred
         * nor s are head or offlist, add to sweepVotes, and if enough
         * votes have accumulated, sweep.
         */
        if (pred != null && pred != s && pred.next == s) {
            Node n = s.next;
            if (n == null ||
                (n != s && pred.casNext(s, n) && pred.isMatched())) {
                for (;;) {               // check if at, or could be, head
                    Node h = head;
                    if (h == pred || h == s || h == null)
                        return;          // at head or list empty
                    if (!h.isMatched())
                        break;
                    Node hn = h.next;
                    if (hn == null)
                        return;          // now empty
                    if (hn != h && casHead(h, hn))
                        h.forgetNext();  // advance head
                }
                if (pred.next != pred && s.next != s) { // recheck if offlist
                    for (;;) {           // sweep now if enough votes
                        int v = sweepVotes;
                        if (v < SWEEP_THRESHOLD) {
                            if (casSweepVotes(v, v + 1))
                                break;
                        }
                        else if (casSweepVotes(v, 0)) {
                            sweep();
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Unlinks matched (typically cancelled) nodes encountered in a
     * traversal from head.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.724 -0400", hash_original_method = "51800EEA0E375B7213B9A1C6559BB395", hash_generated_method = "12A99DE7C70348477D87DC04DC2E4110")
    
private void sweep() {
        for (Node p = head, s, n; p != null && (s = p.next) != null; ) {
            if (!s.isMatched())
                // Unmatched nodes are never self-linked
                p = s;
            else if ((n = s.next) == null) // trailing node is pinned
                break;
            else if (s == n)    // stale
                // No need to also check for p == s, since that implies s == n
                p = head;
            else
                p.casNext(s, n);
        }
    }

    /**
     * Main implementation of remove(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.725 -0400", hash_original_method = "8B71D39574F4373108A5D4807832741B", hash_generated_method = "A34E94818810C8365002C7DE63734330")
    
private boolean findAndRemove(Object e) {
        if (e != null) {
            for (Node pred = null, p = head; p != null; ) {
                Object item = p.item;
                if (p.isData) {
                    if (item != null && item != p && e.equals(item) &&
                        p.tryMatchData()) {
                        unsplice(pred, p);
                        return true;
                    }
                }
                else if (item == null)
                    break;
                pred = p;
                if ((p = p.next) == pred) { // stale
                    pred = null;
                    p = head;
                }
            }
        }
        return false;
    }

    /**
     * Inserts the specified element at the tail of this queue.
     * As the queue is unbounded, this method will never block.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.726 -0400", hash_original_method = "7C8019D6604584E009EB0124C639B76A", hash_generated_method = "29905B04AC538F168D8CAD6D1310CB3D")
    
public void put(E e) {
        xfer(e, true, ASYNC, 0);
    }

    /**
     * Inserts the specified element at the tail of this queue.
     * As the queue is unbounded, this method will never block or
     * return {@code false}.
     *
     * @return {@code true} (as specified by
     *  {@link java.util.concurrent.BlockingQueue#offer(Object,long,TimeUnit)
     *  BlockingQueue.offer})
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.726 -0400", hash_original_method = "C315976C2333B24BCD256EF160BF6025", hash_generated_method = "97DB39201364CAE14C440ECF3231BA5F")
    
public boolean offer(E e, long timeout, TimeUnit unit) {
        xfer(e, true, ASYNC, 0);
        return true;
    }

    /**
     * Inserts the specified element at the tail of this queue.
     * As the queue is unbounded, this method will never return {@code false}.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.727 -0400", hash_original_method = "A2F661C1ED946B4F1E8F2E35B62359C8", hash_generated_method = "50DB1CF2FB0CD4C8231651E6D6EF5EE6")
    
public boolean offer(E e) {
        xfer(e, true, ASYNC, 0);
        return true;
    }

    /**
     * Inserts the specified element at the tail of this queue.
     * As the queue is unbounded, this method will never throw
     * {@link IllegalStateException} or return {@code false}.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.727 -0400", hash_original_method = "3FD4824249312F65A7A154FBDA257ECB", hash_generated_method = "1296D4A0E668AC8D7D083C11EFC83834")
    
public boolean add(E e) {
        xfer(e, true, ASYNC, 0);
        return true;
    }

    /**
     * Transfers the element to a waiting consumer immediately, if possible.
     *
     * <p>More precisely, transfers the specified element immediately
     * if there exists a consumer already waiting to receive it (in
     * {@link #take} or timed {@link #poll(long,TimeUnit) poll}),
     * otherwise returning {@code false} without enqueuing the element.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.727 -0400", hash_original_method = "295AEC1456B0EC05294181FF38C38ADC", hash_generated_method = "7638282AC053C850216C66E30C922FC4")
    
public boolean tryTransfer(E e) {
        return xfer(e, true, NOW, 0) == null;
    }

    /**
     * Transfers the element to a consumer, waiting if necessary to do so.
     *
     * <p>More precisely, transfers the specified element immediately
     * if there exists a consumer already waiting to receive it (in
     * {@link #take} or timed {@link #poll(long,TimeUnit) poll}),
     * else inserts the specified element at the tail of this queue
     * and waits until the element is received by a consumer.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.728 -0400", hash_original_method = "B3DB78D76B45A37772A8278750BAF8BA", hash_generated_method = "D986E8D7A75A571B111270786B4906CE")
    
public void transfer(E e) throws InterruptedException {
        if (xfer(e, true, SYNC, 0) != null) {
            Thread.interrupted(); // failure possible only due to interrupt
            throw new InterruptedException();
        }
    }

    /**
     * Transfers the element to a consumer if it is possible to do so
     * before the timeout elapses.
     *
     * <p>More precisely, transfers the specified element immediately
     * if there exists a consumer already waiting to receive it (in
     * {@link #take} or timed {@link #poll(long,TimeUnit) poll}),
     * else inserts the specified element at the tail of this queue
     * and waits until the element is received by a consumer,
     * returning {@code false} if the specified wait time elapses
     * before the element can be transferred.
     *
     * @throws NullPointerException if the specified element is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.728 -0400", hash_original_method = "7FD998EF8C5D85C3A4E7BA1855DE4B24", hash_generated_method = "DBC745BE4BDC7AA5301BD10BBDAFBC64")
    
public boolean tryTransfer(E e, long timeout, TimeUnit unit)
        throws InterruptedException {
        if (xfer(e, true, TIMED, unit.toNanos(timeout)) == null)
            return true;
        if (!Thread.interrupted())
            return false;
        throw new InterruptedException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.729 -0400", hash_original_method = "08A57AFD87B4609A4B85B9E72519C38B", hash_generated_method = "CED3A7289E6FE4AF9AB1860FDBA946A7")
    
public E take() throws InterruptedException {
        E e = xfer(null, false, SYNC, 0);
        if (e != null)
            return e;
        Thread.interrupted();
        throw new InterruptedException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.729 -0400", hash_original_method = "07F73E62902A3D319F0343FF4AB24382", hash_generated_method = "FAA7F702DE62BFA05A48AEC31633D466")
    
public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E e = xfer(null, false, TIMED, unit.toNanos(timeout));
        if (e != null || !Thread.interrupted())
            return e;
        throw new InterruptedException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.730 -0400", hash_original_method = "81693630391A2625100F17ABA1A18EA3", hash_generated_method = "AB3E39F5FB44E5E5CEE9797C34D7FCD5")
    
public E poll() {
        return xfer(null, false, NOW, 0);
    }

    /**
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.730 -0400", hash_original_method = "07AC519A3CA54B90CDD42C729D844ED4", hash_generated_method = "FD3DE90C82DC8171CE3F546FB485D377")
    
public int drainTo(Collection<? super E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        int n = 0;
        for (E e; (e = poll()) != null;) {
            c.add(e);
            ++n;
        }
        return n;
    }

    /**
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.731 -0400", hash_original_method = "B5D0C7ABC38F76B1C5C4AF6FE4CBCB0B", hash_generated_method = "C441FDA7ED859AE3C58D0DAE13279B37")
    
public int drainTo(Collection<? super E> c, int maxElements) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        int n = 0;
        for (E e; n < maxElements && (e = poll()) != null;) {
            c.add(e);
            ++n;
        }
        return n;
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * <p>The returned iterator is a "weakly consistent" iterator that
     * will never throw {@link java.util.ConcurrentModificationException
     * ConcurrentModificationException}, and guarantees to traverse
     * elements as they existed upon construction of the iterator, and
     * may (but is not guaranteed to) reflect any modifications
     * subsequent to construction.
     *
     * @return an iterator over the elements in this queue in proper sequence
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.731 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "B0FB44010E28764F5FA2B4AB0E8E15C1")
    
public Iterator<E> iterator() {
        return new Itr();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.731 -0400", hash_original_method = "0575396BFCC1B084238E80B4CD997EFE", hash_generated_method = "AAE1B66895AB4FB4C57F9BBBA5CD3308")
    
public E peek() {
        return firstDataItem();
    }

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if this queue contains no elements
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.732 -0400", hash_original_method = "E936CFA99887ECA1533642D7776C7A38", hash_generated_method = "810987672669CE86A3B952664591765F")
    
public boolean isEmpty() {
        for (Node p = head; p != null; p = succ(p)) {
            if (!p.isMatched())
                return !p.isData;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.732 -0400", hash_original_method = "82BC43129F6B019BED019F80919F3AE9", hash_generated_method = "7C9F12E310E2EF8291C8C217F46DE7C4")
    
public boolean hasWaitingConsumer() {
        return firstOfMode(false) != null;
    }

    /**
     * Returns the number of elements in this queue.  If this queue
     * contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * <p>Beware that, unlike in most collections, this method is
     * <em>NOT</em> a constant-time operation. Because of the
     * asynchronous nature of these queues, determining the current
     * number of elements requires an O(n) traversal.
     *
     * @return the number of elements in this queue
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.732 -0400", hash_original_method = "0B4BEB0889797AE69764207ED3A80F6C", hash_generated_method = "D3542F21B4DF283F6D9B731E5E29CA6C")
    
public int size() {
        return countOfMode(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.733 -0400", hash_original_method = "4E8BF42445CD6E003C9018E19378C737", hash_generated_method = "C58E5C3AF89E5F9D1AA4AFB99EE3EA81")
    
public int getWaitingConsumerCount() {
        return countOfMode(false);
    }

    /**
     * Removes a single instance of the specified element from this queue,
     * if it is present.  More formally, removes an element {@code e} such
     * that {@code o.equals(e)}, if this queue contains one or more such
     * elements.
     * Returns {@code true} if this queue contained the specified element
     * (or equivalently, if this queue changed as a result of the call).
     *
     * @param o element to be removed from this queue, if present
     * @return {@code true} if this queue changed as a result of the call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.733 -0400", hash_original_method = "42C72D45D0E7E31CD600954DB12DC0DC", hash_generated_method = "86AEE2A91DB0845CC0F7DD9D96188BAD")
    
public boolean remove(Object o) {
        return findAndRemove(o);
    }

    /**
     * Returns {@code true} if this queue contains the specified element.
     * More formally, returns {@code true} if and only if this queue contains
     * at least one element {@code e} such that {@code o.equals(e)}.
     *
     * @param o object to be checked for containment in this queue
     * @return {@code true} if this queue contains the specified element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.734 -0400", hash_original_method = "7E688AC86CB840CA5E6B1A92085AEFF0", hash_generated_method = "F90E356E25E8D66C86A25BE83C31F44B")
    
public boolean contains(Object o) {
        if (o == null) return false;
        for (Node p = head; p != null; p = succ(p)) {
            Object item = p.item;
            if (p.isData) {
                if (item != null && item != p && o.equals(item))
                    return true;
            }
            else if (item == null)
                break;
        }
        return false;
    }

    /**
     * Always returns {@code Integer.MAX_VALUE} because a
     * {@code LinkedTransferQueue} is not capacity constrained.
     *
     * @return {@code Integer.MAX_VALUE} (as specified by
     *         {@link java.util.concurrent.BlockingQueue#remainingCapacity()
     *         BlockingQueue.remainingCapacity})
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.734 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "33BD29B45C0B302F31D1F275110E0FF5")
    
public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    /**
     * Saves this queue to a stream (that is, serializes it).
     *
     * @serialData All of the elements (each an {@code E}) in
     * the proper order, followed by a null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.735 -0400", hash_original_method = "657F50EA293E77A87DF434319FAB5240", hash_generated_method = "D23741D5C17118EAA0FE41298AF4EB27")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        s.defaultWriteObject();
        for (E e : this)
            s.writeObject(e);
        // Use trailing null as sentinel
        s.writeObject(null);
    }

    /**
     * Reconstitutes this queue from a stream (that is, deserializes it).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:17.735 -0400", hash_original_method = "3B5128F5D5DD4E4E295E15D46241A9A9", hash_generated_method = "EDF3F1563D27654C0E93C85F3F867146")
    
private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        for (;;) {
            @SuppressWarnings("unchecked")
            E item = (E) s.readObject();
            if (item == null)
                break;
            else
                offer(item);
        }
    }
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = LinkedTransferQueue.class;
            headOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("head"));
            tailOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("tail"));
            sweepVotesOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("sweepVotes"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
