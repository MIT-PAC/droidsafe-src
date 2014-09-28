/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.*;

// BEGIN android-note
// removed link to collections framework docs
// END android-note

/**
 * A scalable concurrent {@link ConcurrentNavigableMap} implementation.
 * The map is sorted according to the {@linkplain Comparable natural
 * ordering} of its keys, or by a {@link Comparator} provided at map
 * creation time, depending on which constructor is used.
 *
 * <p>This class implements a concurrent variant of <a
 * href="http://en.wikipedia.org/wiki/Skip_list" target="_top">SkipLists</a>
 * providing expected average <i>log(n)</i> time cost for the
 * {@code containsKey}, {@code get}, {@code put} and
 * {@code remove} operations and their variants.  Insertion, removal,
 * update, and access operations safely execute concurrently by
 * multiple threads.  Iterators are <i>weakly consistent</i>, returning
 * elements reflecting the state of the map at some point at or since
 * the creation of the iterator.  They do <em>not</em> throw {@link
 * ConcurrentModificationException}, and may proceed concurrently with
 * other operations. Ascending key ordered views and their iterators
 * are faster than descending ones.
 *
 * <p>All {@code Map.Entry} pairs returned by methods in this class
 * and its views represent snapshots of mappings at the time they were
 * produced. They do <em>not</em> support the {@code Entry.setValue}
 * method. (Note however that it is possible to change mappings in the
 * associated map using {@code put}, {@code putIfAbsent}, or
 * {@code replace}, depending on exactly which effect you need.)
 *
 * <p>Beware that, unlike in most collections, the {@code size}
 * method is <em>not</em> a constant-time operation. Because of the
 * asynchronous nature of these maps, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code putAll}, {@code equals},
 * {@code toArray}, {@code containsValue}, and {@code clear} are
 * <em>not</em> guaranteed to be performed atomically. For example, an
 * iterator operating concurrently with a {@code putAll} operation
 * might view only some of the added elements.
 *
 * <p>This class and its views and iterators implement all of the
 * <em>optional</em> methods of the {@link Map} and {@link Iterator}
 * interfaces. Like most other concurrent collections, this class does
 * <em>not</em> permit the use of {@code null} keys or values because some
 * null return values cannot be reliably distinguished from the absence of
 * elements.
 *
 * @author Doug Lea
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * @since 1.6
 */
@SuppressWarnings("unchecked")
public class ConcurrentSkipListMap<K,V> extends AbstractMap<K,V>
    implements ConcurrentNavigableMap<K,V>,
               Cloneable,
               java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.235 -0400", hash_original_field = "D570ABCF6153CAB45715C954DB330430", hash_generated_field = "0294B296462B5B3664F1F32022C082A9")

    private static final long serialVersionUID = -8627078645895051609L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.235 -0400", hash_original_field = "CDE41E0315E6D5F8B10DEEF88247B82A", hash_generated_field = "A277F9B5E9FB9BCDA506AA1EDE12CA97")

    private static final Random seedGenerator = new Random();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.236 -0400", hash_original_field = "851BCB269EE1D94208399F1B537A9F4C", hash_generated_field = "827BFBF6D914DBCE673537BAB380DDD8")

    private static final Object BASE_HEADER = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.270 -0400", hash_original_field = "58D699279C73F98E565B4B4C330E1371", hash_generated_field = "DE7AB917D52050C7B1C6E3F7B764BCBE")

    // Control values OR'ed as arguments to findNear

    private static final int EQ = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.271 -0400", hash_original_field = "D49567240ECE474E5711CA351F363A98", hash_generated_field = "22AAEDDE50B455547176322F2A0C77A2")

    private static final int LT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.271 -0400", hash_original_field = "4E36282279AF86B89214E7936CD02126", hash_generated_field = "67BD72902657A220B4F0112E23803C79")

    private static final int GT = 0;

    /* ---------------- View Classes -------------- */

    /*
     * View classes are static, delegating to a ConcurrentNavigableMap
     * to allow use by SubMaps, which outweighs the ugliness of
     * needing type-tests for Iterator methods.
     */

    static final <E> List<E> toList(Collection<E> c) {
        // Using size() here would be a pessimization.
        ArrayList<E> list = new ArrayList<E>();
        for (E e : c)
            list.add(e);
        return list;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.370 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

    private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.370 -0400", hash_original_field = "3706253715619D88D23853C13B9CE0EE", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static  long headOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.236 -0400", hash_original_field = "9F16FD5A7BDDB42FD1310194543D2C74", hash_generated_field = "2AD9FB3801580507524F83B1B4B3367C")

    private transient volatile HeadIndex<K,V> head;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.237 -0400", hash_original_field = "10E826BC31BCAB9BF3EF3CC29146C2D4", hash_generated_field = "47DA7D347F0758745E1F9CA2436B13FE")

    private  Comparator<? super K> comparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.237 -0400", hash_original_field = "691D5392B4A352B7A23523C2D63056B6", hash_generated_field = "77B9802A55F5C1CA5488534032C55952")

    private transient int randomSeed;

    /* ---------------- Nodes -------------- */

    /**
     * Nodes hold keys and values, and are singly linked in sorted
     * order, possibly with some intervening marker nodes. The list is
     * headed by a dummy node accessible as head.node. The value field
     * is declared only as Object because it takes special non-V
     * values for marker and header nodes.
     */
    static final class Node<K,V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.245 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

        private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.245 -0400", hash_original_field = "2B4D3697B0BD0FB4DB161026EA588EEA", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

        private static  long valueOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.246 -0400", hash_original_field = "3EFA6AE93B76F6C9D723C832889F59D2", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

        private static  long nextOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.240 -0400", hash_original_field = "F780C5984CF24E477CB9559E91475987", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

         K key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.240 -0400", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "4F68C8E44A7D2CE48F4B7383EF4B6307")

        volatile Object value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.241 -0400", hash_original_field = "D1C8B20089B08F3F6EDCF099CD3F45A9", hash_generated_field = "6742B0D5A56B6DECF92CCD1C7746E04A")

        volatile Node<K,V> next;

        /**
         * Creates a new regular node.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.241 -0400", hash_original_method = "2107F052F31CECF3C9BB5E0EAD7C1BC1", hash_generated_method = "2107F052F31CECF3C9BB5E0EAD7C1BC1")
        
Node(K key, Object value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Creates a new marker node. A marker is distinguished by
         * having its value field point to itself.  Marker nodes also
         * have null keys, a fact that is exploited in a few places,
         * but this doesn't distinguish markers from the base-level
         * header node (head.node), which also has a null key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.241 -0400", hash_original_method = "DAA57512F350005E028FADEF77972821", hash_generated_method = "DAA57512F350005E028FADEF77972821")
        
Node(Node<K,V> next) {
            this.key = null;
            this.value = this;
            this.next = next;
        }

        /**
         * compareAndSet value field
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.242 -0400", hash_original_method = "AB1C74DEAB6F5AB0D41867881F076BB6", hash_generated_method = "AB1C74DEAB6F5AB0D41867881F076BB6")
        
boolean casValue(Object cmp, Object val) {
            return UNSAFE.compareAndSwapObject(this, valueOffset, cmp, val);
        }

        /**
         * compareAndSet next field
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.242 -0400", hash_original_method = "7F7D78C5226303C119BFA9695D906BC1", hash_generated_method = "7F7D78C5226303C119BFA9695D906BC1")
        
boolean casNext(Node<K,V> cmp, Node<K,V> val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        /**
         * Returns true if this node is a marker. This method isn't
         * actually called in any current code checking for markers
         * because callers will have already read value field and need
         * to use that read (not another done here) and so directly
         * test if value points to node.
         *
         * @return true if this node is a marker node
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.243 -0400", hash_original_method = "BDA0A1485C06EBB2E0A6D334D1656ED0", hash_generated_method = "BDA0A1485C06EBB2E0A6D334D1656ED0")
        
boolean isMarker() {
            return value == this;
        }

        /**
         * Returns true if this node is the header of base-level list.
         * @return true if this node is header node
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.243 -0400", hash_original_method = "3A2EF1D44B41CB7EE71623CBE9404B85", hash_generated_method = "3A2EF1D44B41CB7EE71623CBE9404B85")
        
boolean isBaseHeader() {
            return value == BASE_HEADER;
        }

        /**
         * Tries to append a deletion marker to this node.
         * @param f the assumed current successor of this node
         * @return true if successful
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.243 -0400", hash_original_method = "8927FBFC8F292D43723C1D48447E8FED", hash_generated_method = "8927FBFC8F292D43723C1D48447E8FED")
        
boolean appendMarker(Node<K,V> f) {
            return casNext(f, new Node<K,V>(f));
        }

        /**
         * Helps out a deletion by appending marker or unlinking from
         * predecessor. This is called during traversals when value
         * field seen to be null.
         * @param b predecessor
         * @param f successor
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.244 -0400", hash_original_method = "193FE4558996330A10B670A31489B53D", hash_generated_method = "DDE7348136F2CFFC73C4692EC1789378")
        
void helpDelete(Node<K,V> b, Node<K,V> f) {
            /*
             * Rechecking links and then doing only one of the
             * help-out stages per call tends to minimize CAS
             * interference among helping threads.
             */
            if (f == next && this == b.next) {
                if (f == null || f.value != f) // not already marked
                    appendMarker(f);
                else
                    b.casNext(this, f.next);
            }
        }

        /**
         * Returns value if this node contains a valid key-value pair,
         * else null.
         * @return this node's value if it isn't a marker or header or
         * is deleted, else null
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.244 -0400", hash_original_method = "13803B309451A8368144EA4F4F698F30", hash_generated_method = "13803B309451A8368144EA4F4F698F30")
        
V getValidValue() {
            Object v = value;
            if (v == this || v == BASE_HEADER)
                return null;
            return (V)v;
        }

        /**
         * Creates and returns a new SimpleImmutableEntry holding current
         * mapping if this node holds a valid value, else null.
         * @return new entry or null
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.244 -0400", hash_original_method = "AE9D1970F62CF6B7B0F35C4F3A804205", hash_generated_method = "AE9D1970F62CF6B7B0F35C4F3A804205")
        
AbstractMap.SimpleImmutableEntry<K,V> createSnapshot() {
            V v = getValidValue();
            if (v == null)
                return null;
            return new AbstractMap.SimpleImmutableEntry<K,V>(key, v);
        }

        static {
            try {
                UNSAFE = sun.misc.Unsafe.getUnsafe();
                Class<?> k = Node.class;
                valueOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("value"));
                nextOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    /* ---------------- Indexing -------------- */

    /**
     * Index nodes represent the levels of the skip list.  Note that
     * even though both Nodes and Indexes have forward-pointing
     * fields, they have different types and are handled in different
     * ways, that can't nicely be captured by placing field in a
     * shared abstract class.
     */
    static class Index<K,V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.251 -0400", hash_original_field = "8D6DE690AED35F26F78C7E63CD3F73E7", hash_generated_field = "E7ED6ED2850DA758D244111BA43A3B2F")

        private static  sun.misc.Unsafe UNSAFE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.251 -0400", hash_original_field = "F8465305E6AB0224FB0875E3C3793E1A", hash_generated_field = "279F60D6EB01A2E023DA2B307AD1B1C8")

        private static  long rightOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.248 -0400", hash_original_field = "624F71481761A2C421D65B82B8FB1FA2", hash_generated_field = "624F71481761A2C421D65B82B8FB1FA2")

         Node<K,V> node;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.248 -0400", hash_original_field = "45244B3EDF1E6E41DFF0A7EBD4D8708C", hash_generated_field = "45244B3EDF1E6E41DFF0A7EBD4D8708C")

         Index<K,V> down;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.248 -0400", hash_original_field = "9912D7554CB6F616CA8654ADDE1BBFFD", hash_generated_field = "21356ACB7E7E8403B8FC146FE9D5C6C8")

        volatile Index<K,V> right;

        /**
         * Creates index node with given values.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.249 -0400", hash_original_method = "7361C97DE18BBD90CCD2423C0E727D3D", hash_generated_method = "7361C97DE18BBD90CCD2423C0E727D3D")
        
Index(Node<K,V> node, Index<K,V> down, Index<K,V> right) {
            this.node = node;
            this.down = down;
            this.right = right;
        }

        /**
         * compareAndSet right field
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.249 -0400", hash_original_method = "58C3F19A1FFEE19F2AC6D03793C0E59C", hash_generated_method = "CE915835F21DC41ECBD20F7163348532")
        
final boolean casRight(Index<K,V> cmp, Index<K,V> val) {
            return UNSAFE.compareAndSwapObject(this, rightOffset, cmp, val);
        }

        /**
         * Returns true if the node this indexes has been deleted.
         * @return true if indexed node is known to be deleted
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.250 -0400", hash_original_method = "5093036CEC1CC826DFFC999519A73E58", hash_generated_method = "1B7C9BC5926E0950A359CD212B31464E")
        
final boolean indexesDeletedNode() {
            return node.value == null;
        }

        /**
         * Tries to CAS newSucc as successor.  To minimize races with
         * unlink that may lose this index node, if the node being
         * indexed is known to be deleted, it doesn't try to link in.
         * @param succ the expected current successor
         * @param newSucc the new successor
         * @return true if successful
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.250 -0400", hash_original_method = "21FAB374CD1C2C82C29BC885824E546F", hash_generated_method = "30A7AC9B50C584CD38B98C36A8ED2C2A")
        
final boolean link(Index<K,V> succ, Index<K,V> newSucc) {
            Node<K,V> n = node;
            newSucc.right = succ;
            return n.value != null && casRight(succ, newSucc);
        }

        /**
         * Tries to CAS right field to skip over apparent successor
         * succ.  Fails (forcing a retraversal by caller) if this node
         * is known to be deleted.
         * @param succ the expected current successor
         * @return true if successful
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.250 -0400", hash_original_method = "721D9E4B3E01AE935EF1F89789CA6337", hash_generated_method = "B64F8EC69B91C0CCEA03E71C6B4B7057")
        
final boolean unlink(Index<K,V> succ) {
            return !indexesDeletedNode() && casRight(succ, succ.right);
        }
        static {
            try {
                UNSAFE = sun.misc.Unsafe.getUnsafe();
                Class<?> k = Index.class;
                rightOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("right"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    /* ---------------- Head nodes -------------- */

    /**
     * Nodes heading each level keep track of their level.
     */
    static final class HeadIndex<K,V> extends Index<K,V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.253 -0400", hash_original_field = "6C23DC7E65CEAB9FBA953CF49B6B6875", hash_generated_field = "6C23DC7E65CEAB9FBA953CF49B6B6875")

         int level;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.253 -0400", hash_original_method = "79B63BA3680A80ABAAB371DB876D9091", hash_generated_method = "79B63BA3680A80ABAAB371DB876D9091")
        
HeadIndex(Node<K,V> node, Index<K,V> down, Index<K,V> right, int level) {
            super(node, down, right);
            this.level = level;
        }
    }

    /* ---------------- Comparison utilities -------------- */

    /**
     * Represents a key with a comparator as a Comparable.
     *
     * Because most sorted collections seem to use natural ordering on
     * Comparables (Strings, Integers, etc), most internal methods are
     * geared to use them. This is generally faster than checking
     * per-comparison whether to use comparator or comparable because
     * it doesn't require a (Comparable) cast for each comparison.
     * (Optimizers can only sometimes remove such redundant checks
     * themselves.) When Comparators are used,
     * ComparableUsingComparators are created so that they act in the
     * same way as natural orderings. This penalizes use of
     * Comparators vs Comparables, which seems like the right
     * tradeoff.
     */
    static final class ComparableUsingComparator<K> implements Comparable<K> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.254 -0400", hash_original_field = "34F484C2A448454D89623D60B060BB59", hash_generated_field = "34F484C2A448454D89623D60B060BB59")

         K actualKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.255 -0400", hash_original_field = "3C36FF187F4F8518FBA94A81C3026CFA", hash_generated_field = "3C36FF187F4F8518FBA94A81C3026CFA")

         Comparator<? super K> cmp;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.255 -0400", hash_original_method = "23788127AE597714311250AFC335DFAA", hash_generated_method = "23788127AE597714311250AFC335DFAA")
        
ComparableUsingComparator(K key, Comparator<? super K> cmp) {
            this.actualKey = key;
            this.cmp = cmp;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.255 -0400", hash_original_method = "CC21065DAD0A58A5B913D23B69485307", hash_generated_method = "078692B76C7A4F61D23D97062F88EFFE")
        
public int compareTo(K k2) {
            return cmp.compare(actualKey, k2);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.237 -0400", hash_original_field = "7FC6BD14E99B7B9D56BB04D0F3005AA9", hash_generated_field = "37E8792802DCFFB288894B679DF4D087")

    private transient KeySet<K> keySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.238 -0400", hash_original_field = "CB18093CCBFA988F6FFF1ED9F7DF8C7D", hash_generated_field = "BC34AE372A240052C3BF190AB0ABE8B6")

    private transient EntrySet<K,V> entrySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.238 -0400", hash_original_field = "BD8981709B0DCD31EB424B414E940DC2", hash_generated_field = "D5B02224526CF18E27C3698544B7159C")

    private transient Values<V> values;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.239 -0400", hash_original_field = "061ECA21A7E45D276A7DE5D8F0365D12", hash_generated_field = "731C8718304BE5B5D6977223CCD1D9C0")

    private transient ConcurrentNavigableMap<K,V> descendingMap;

    /* ---------------- Constructors -------------- */

    /**
     * Constructs a new, empty map, sorted according to the
     * {@linkplain Comparable natural ordering} of the keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.273 -0400", hash_original_method = "9DFB31044826912DA0A162256C816EDF", hash_generated_method = "379DA242604A85F2875087DC3671F7B7")
    
public ConcurrentSkipListMap() {
        this.comparator = null;
        initialize();
    }

    /**
     * Constructs a new, empty map, sorted according to the specified
     * comparator.
     *
     * @param comparator the comparator that will be used to order this map.
     *        If {@code null}, the {@linkplain Comparable natural
     *        ordering} of the keys will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.274 -0400", hash_original_method = "E93907B75ED7A65211A3C3477C909B28", hash_generated_method = "66CEAFC8E05C8AAC050CE9D359E72F60")
    
public ConcurrentSkipListMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
        initialize();
    }

    /**
     * Constructs a new map containing the same mappings as the given map,
     * sorted according to the {@linkplain Comparable natural ordering} of
     * the keys.
     *
     * @param  m the map whose mappings are to be placed in this map
     * @throws ClassCastException if the keys in {@code m} are not
     *         {@link Comparable}, or are not mutually comparable
     * @throws NullPointerException if the specified map or any of its keys
     *         or values are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.274 -0400", hash_original_method = "41D496E752AE1105B70FBB88B1ED7CC7", hash_generated_method = "F7FC66CF9193C7291B2F5E96E88ED53A")
    
public ConcurrentSkipListMap(Map<? extends K, ? extends V> m) {
        this.comparator = null;
        initialize();
        putAll(m);
    }

    /**
     * Constructs a new map containing the same mappings and using the
     * same ordering as the specified sorted map.
     *
     * @param m the sorted map whose mappings are to be placed in this
     *        map, and whose comparator is to be used to sort this map
     * @throws NullPointerException if the specified sorted map or any of
     *         its keys or values are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.274 -0400", hash_original_method = "655B1AE9ACF0DD48CFC5F4BF8909FA7B", hash_generated_method = "B19AF574353C38598D11E17BD8E85B1E")
    
public ConcurrentSkipListMap(SortedMap<K, ? extends V> m) {
        this.comparator = m.comparator();
        initialize();
        buildFromSorted(m);
    }

    /**
     * Initializes or resets state. Needed by constructors, clone,
     * clear, readObject. and ConcurrentSkipListSet.clone.
     * (Note that comparator must be separately initialized.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.239 -0400", hash_original_method = "C71F5C8FC5A0E0411E381F6B5555CECF", hash_generated_method = "3B417D09B2749E71F66E77A10872E4A7")
    
final void initialize() {
        keySet = null;
        entrySet = null;
        values = null;
        descendingMap = null;
        randomSeed = seedGenerator.nextInt() | 0x0100; // ensure nonzero
        head = new HeadIndex<K,V>(new Node<K,V>(null, BASE_HEADER, null),
                                  null, null, 1);
    }

    /**
     * compareAndSet head node
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.239 -0400", hash_original_method = "F690B877344E7DD2303BCB23C8C7DA32", hash_generated_method = "8B39F86C40BF11E1628A04566097572F")
    
private boolean casHead(HeadIndex<K,V> cmp, HeadIndex<K,V> val) {
        return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
    }

    /**
     * If using comparator, return a ComparableUsingComparator, else
     * cast key as Comparable, which may cause ClassCastException,
     * which is propagated back to caller.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.256 -0400", hash_original_method = "57A7B93C54DE606B88D21BB5B70A1986", hash_generated_method = "796F8DC669CDBAEECBF0B712EB668290")
    
private Comparable<? super K> comparable(Object key)
            throws ClassCastException {
        if (key == null)
            throw new NullPointerException();
        if (comparator != null)
            return new ComparableUsingComparator<K>((K)key, comparator);
        else
            return (Comparable<? super K>)key;
    }

    /**
     * Compares using comparator or natural ordering. Used when the
     * ComparableUsingComparator approach doesn't apply.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.257 -0400", hash_original_method = "2AE20F60A8F17E979B7932BF34829741", hash_generated_method = "2AE20F60A8F17E979B7932BF34829741")
    
int compare(K k1, K k2) throws ClassCastException {
        Comparator<? super K> cmp = comparator;
        if (cmp != null)
            return cmp.compare(k1, k2);
        else
            return ((Comparable<? super K>)k1).compareTo(k2);
    }

    /**
     * Returns true if given key greater than or equal to least and
     * strictly less than fence, bypassing either test if least or
     * fence are null. Needed mainly in submap operations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.257 -0400", hash_original_method = "AC2D9AECE0766CF1B720C1F0AF234F2A", hash_generated_method = "AC2D9AECE0766CF1B720C1F0AF234F2A")
    
boolean inHalfOpenRange(K key, K least, K fence) {
        if (key == null)
            throw new NullPointerException();
        return ((least == null || compare(key, least) >= 0) &&
                (fence == null || compare(key, fence) <  0));
    }

    /**
     * Returns true if given key greater than or equal to least and less
     * or equal to fence. Needed mainly in submap operations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.258 -0400", hash_original_method = "939173B17A4E542E965C87886AEB52AA", hash_generated_method = "939173B17A4E542E965C87886AEB52AA")
    
boolean inOpenRange(K key, K least, K fence) {
        if (key == null)
            throw new NullPointerException();
        return ((least == null || compare(key, least) >= 0) &&
                (fence == null || compare(key, fence) <= 0));
    }

    /* ---------------- Traversal -------------- */

    /**
     * Returns a base-level node with key strictly less than given key,
     * or the base-level header if there is no such node.  Also
     * unlinks indexes to deleted nodes found along the way.  Callers
     * rely on this side-effect of clearing indices to deleted nodes.
     * @param key the key
     * @return a predecessor of key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.258 -0400", hash_original_method = "34E090FC5E2F0D70541D5EF28EF411C0", hash_generated_method = "86E463B7E3BC73EE1AF9E7024F121820")
    
private Node<K,V> findPredecessor(Comparable<? super K> key) {
        if (key == null)
            throw new NullPointerException(); // don't postpone errors
        for (;;) {
            Index<K,V> q = head;
            Index<K,V> r = q.right;
            for (;;) {
                if (r != null) {
                    Node<K,V> n = r.node;
                    K k = n.key;
                    if (n.value == null) {
                        if (!q.unlink(r))
                            break;           // restart
                        r = q.right;         // reread r
                        continue;
                    }
                    if (key.compareTo(k) > 0) {
                        q = r;
                        r = r.right;
                        continue;
                    }
                }
                Index<K,V> d = q.down;
                if (d != null) {
                    q = d;
                    r = d.right;
                } else
                    return q.node;
            }
        }
    }

    /**
     * Returns node holding key or null if no such, clearing out any
     * deleted nodes seen along the way.  Repeatedly traverses at
     * base-level looking for key starting at predecessor returned
     * from findPredecessor, processing base-level deletions as
     * encountered. Some callers rely on this side-effect of clearing
     * deleted nodes.
     *
     * Restarts occur, at traversal step centered on node n, if:
     *
     *   (1) After reading n's next field, n is no longer assumed
     *       predecessor b's current successor, which means that
     *       we don't have a consistent 3-node snapshot and so cannot
     *       unlink any subsequent deleted nodes encountered.
     *
     *   (2) n's value field is null, indicating n is deleted, in
     *       which case we help out an ongoing structural deletion
     *       before retrying.  Even though there are cases where such
     *       unlinking doesn't require restart, they aren't sorted out
     *       here because doing so would not usually outweigh cost of
     *       restarting.
     *
     *   (3) n is a marker or n's predecessor's value field is null,
     *       indicating (among other possibilities) that
     *       findPredecessor returned a deleted node. We can't unlink
     *       the node because we don't know its predecessor, so rely
     *       on another call to findPredecessor to notice and return
     *       some earlier predecessor, which it will do. This check is
     *       only strictly needed at beginning of loop, (and the
     *       b.value check isn't strictly needed at all) but is done
     *       each iteration to help avoid contention with other
     *       threads by callers that will fail to be able to change
     *       links, and so will retry anyway.
     *
     * The traversal loops in doPut, doRemove, and findNear all
     * include the same three kinds of checks. And specialized
     * versions appear in findFirst, and findLast and their
     * variants. They can't easily share code because each uses the
     * reads of fields held in locals occurring in the orders they
     * were performed.
     *
     * @param key the key
     * @return node holding key, or null if no such
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.259 -0400", hash_original_method = "0F9B01024D57A40518D48F0508A35A8A", hash_generated_method = "2BF66D02D99CF00172DE0386D01CDE0C")
    
private Node<K,V> findNode(Comparable<? super K> key) {
        for (;;) {
            Node<K,V> b = findPredecessor(key);
            Node<K,V> n = b.next;
            for (;;) {
                if (n == null)
                    return null;
                Node<K,V> f = n.next;
                if (n != b.next)                // inconsistent read
                    break;
                Object v = n.value;
                if (v == null) {                // n is deleted
                    n.helpDelete(b, f);
                    break;
                }
                if (v == n || b.value == null)  // b is deleted
                    break;
                int c = key.compareTo(n.key);
                if (c == 0)
                    return n;
                if (c < 0)
                    return null;
                b = n;
                n = f;
            }
        }
    }

    /**
     * Gets value for key using findNode.
     * @param okey the key
     * @return the value, or null if absent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.260 -0400", hash_original_method = "C83A00D221FC807590F43A94A3765337", hash_generated_method = "3515D48B6E5859755E965F86CACE23C1")
    
private V doGet(Object okey) {
        Comparable<? super K> key = comparable(okey);
        /*
         * Loop needed here and elsewhere in case value field goes
         * null just as it is about to be returned, in which case we
         * lost a race with a deletion, so must retry.
         */
        for (;;) {
            Node<K,V> n = findNode(key);
            if (n == null)
                return null;
            Object v = n.value;
            if (v != null)
                return (V)v;
        }
    }

    /* ---------------- Insertion -------------- */

    /**
     * Main insertion method.  Adds element if not present, or
     * replaces value if present and onlyIfAbsent is false.
     * @param kkey the key
     * @param value the value that must be associated with key
     * @param onlyIfAbsent if should not insert if already present
     * @return the old value, or null if newly inserted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.261 -0400", hash_original_method = "0A1C1768846EB684D4983B5FA0FE432E", hash_generated_method = "133FB815D550EF807B30CBCE8CF1C7B5")
    
private V doPut(K kkey, V value, boolean onlyIfAbsent) {
        Comparable<? super K> key = comparable(kkey);
        for (;;) {
            Node<K,V> b = findPredecessor(key);
            Node<K,V> n = b.next;
            for (;;) {
                if (n != null) {
                    Node<K,V> f = n.next;
                    if (n != b.next)               // inconsistent read
                        break;
                    Object v = n.value;
                    if (v == null) {               // n is deleted
                        n.helpDelete(b, f);
                        break;
                    }
                    if (v == n || b.value == null) // b is deleted
                        break;
                    int c = key.compareTo(n.key);
                    if (c > 0) {
                        b = n;
                        n = f;
                        continue;
                    }
                    if (c == 0) {
                        if (onlyIfAbsent || n.casValue(v, value))
                            return (V)v;
                        else
                            break; // restart if lost race to replace value
                    }
                    // else c < 0; fall through
                }

                Node<K,V> z = new Node<K,V>(kkey, value, n);
                if (!b.casNext(n, z))
                    break;         // restart if lost race to append to b
                int level = randomLevel();
                if (level > 0)
                    insertIndex(z, level);
                return null;
            }
        }
    }

    /**
     * Returns a random level for inserting a new node.
     * Hardwired to k=1, p=0.5, max 31 (see above and
     * Pugh's "Skip List Cookbook", sec 3.4).
     *
     * This uses the simplest of the generators described in George
     * Marsaglia's "Xorshift RNGs" paper.  This is not a high-quality
     * generator but is acceptable here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.261 -0400", hash_original_method = "88FB75CF2804164884F1D713C392175B", hash_generated_method = "C8968A8473FCAC734706FB1E81FCACC0")
    
private int randomLevel() {
        int x = randomSeed;
        x ^= x << 13;
        x ^= x >>> 17;
        randomSeed = x ^= x << 5;
        if ((x & 0x80000001) != 0) // test highest and lowest bits
            return 0;
        int level = 1;
        while (((x >>>= 1) & 1) != 0) ++level;
        return level;
    }

    /**
     * Creates and adds index nodes for the given node.
     * @param z the node
     * @param level the level of the index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.262 -0400", hash_original_method = "62BDD93087776E98D3A2E48C7C1EDD64", hash_generated_method = "B95685F9BFFF7CB0A56ACC5B76A57166")
    
private void insertIndex(Node<K,V> z, int level) {
        HeadIndex<K,V> h = head;
        int max = h.level;

        if (level <= max) {
            Index<K,V> idx = null;
            for (int i = 1; i <= level; ++i)
                idx = new Index<K,V>(z, idx, null);
            addIndex(idx, h, level);

        } else { // Add a new level
            /*
             * To reduce interference by other threads checking for
             * empty levels in tryReduceLevel, new levels are added
             * with initialized right pointers. Which in turn requires
             * keeping levels in an array to access them while
             * creating new head index nodes from the opposite
             * direction.
             */
            level = max + 1;
            Index<K,V>[] idxs = (Index<K,V>[])new Index<?,?>[level+1];
            Index<K,V> idx = null;
            for (int i = 1; i <= level; ++i)
                idxs[i] = idx = new Index<K,V>(z, idx, null);

            HeadIndex<K,V> oldh;
            int k;
            for (;;) {
                oldh = head;
                int oldLevel = oldh.level;
                if (level <= oldLevel) { // lost race to add level
                    k = level;
                    break;
                }
                HeadIndex<K,V> newh = oldh;
                Node<K,V> oldbase = oldh.node;
                for (int j = oldLevel+1; j <= level; ++j)
                    newh = new HeadIndex<K,V>(oldbase, newh, idxs[j], j);
                if (casHead(oldh, newh)) {
                    k = oldLevel;
                    break;
                }
            }
            addIndex(idxs[k], oldh, k);
        }
    }

    /**
     * Adds given index nodes from given level down to 1.
     * @param idx the topmost index node being inserted
     * @param h the value of head to use to insert. This must be
     * snapshotted by callers to provide correct insertion level.
     * @param indexLevel the level of the index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.264 -0400", hash_original_method = "48E9953E5ABFFECEE441290BB1EC6E5E", hash_generated_method = "B433D0EE54A3BE547F9E4EAB8F43DF64")
    
private void addIndex(Index<K,V> idx, HeadIndex<K,V> h, int indexLevel) {
        // Track next level to insert in case of retries
        int insertionLevel = indexLevel;
        Comparable<? super K> key = comparable(idx.node.key);
        if (key == null) throw new NullPointerException();

        // Similar to findPredecessor, but adding index nodes along
        // path to key.
        for (;;) {
            int j = h.level;
            Index<K,V> q = h;
            Index<K,V> r = q.right;
            Index<K,V> t = idx;
            for (;;) {
                if (r != null) {
                    Node<K,V> n = r.node;
                    // compare before deletion check avoids needing recheck
                    int c = key.compareTo(n.key);
                    if (n.value == null) {
                        if (!q.unlink(r))
                            break;
                        r = q.right;
                        continue;
                    }
                    if (c > 0) {
                        q = r;
                        r = r.right;
                        continue;
                    }
                }

                if (j == insertionLevel) {
                    // Don't insert index if node already deleted
                    if (t.indexesDeletedNode()) {
                        findNode(key); // cleans up
                        return;
                    }
                    if (!q.link(r, t))
                        break; // restart
                    if (--insertionLevel == 0) {
                        // need final deletion check before return
                        if (t.indexesDeletedNode())
                            findNode(key);
                        return;
                    }
                }

                if (--j >= insertionLevel && j < indexLevel)
                    t = t.down;
                q = q.down;
                r = q.right;
            }
        }
    }

    /* ---------------- Deletion -------------- */

    /**
     * Main deletion method. Locates node, nulls value, appends a
     * deletion marker, unlinks predecessor, removes associated index
     * nodes, and possibly reduces head index level.
     *
     * Index nodes are cleared out simply by calling findPredecessor.
     * which unlinks indexes to deleted nodes found along path to key,
     * which will include the indexes to this node.  This is done
     * unconditionally. We can't check beforehand whether there are
     * index nodes because it might be the case that some or all
     * indexes hadn't been inserted yet for this node during initial
     * search for it, and we'd like to ensure lack of garbage
     * retention, so must call to be sure.
     *
     * @param okey the key
     * @param value if non-null, the value that must be
     * associated with key
     * @return the node, or null if not found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.265 -0400", hash_original_method = "D7C4BC88C6659B291F078CA33E2EF349", hash_generated_method = "241FB6143D16409D34DFFAEAADC71973")
    
final V doRemove(Object okey, Object value) {
        Comparable<? super K> key = comparable(okey);
        for (;;) {
            Node<K,V> b = findPredecessor(key);
            Node<K,V> n = b.next;
            for (;;) {
                if (n == null)
                    return null;
                Node<K,V> f = n.next;
                if (n != b.next)                    // inconsistent read
                    break;
                Object v = n.value;
                if (v == null) {                    // n is deleted
                    n.helpDelete(b, f);
                    break;
                }
                if (v == n || b.value == null)      // b is deleted
                    break;
                int c = key.compareTo(n.key);
                if (c < 0)
                    return null;
                if (c > 0) {
                    b = n;
                    n = f;
                    continue;
                }
                if (value != null && !value.equals(v))
                    return null;
                if (!n.casValue(v, null))
                    break;
                if (!n.appendMarker(f) || !b.casNext(n, f))
                    findNode(key);                  // Retry via findNode
                else {
                    findPredecessor(key);           // Clean index
                    if (head.right == null)
                        tryReduceLevel();
                }
                return (V)v;
            }
        }
    }

    /**
     * Possibly reduce head level if it has no nodes.  This method can
     * (rarely) make mistakes, in which case levels can disappear even
     * though they are about to contain index nodes. This impacts
     * performance, not correctness.  To minimize mistakes as well as
     * to reduce hysteresis, the level is reduced by one only if the
     * topmost three levels look empty. Also, if the removed level
     * looks non-empty after CAS, we try to change it back quick
     * before anyone notices our mistake! (This trick works pretty
     * well because this method will practically never make mistakes
     * unless current thread stalls immediately before first CAS, in
     * which case it is very unlikely to stall again immediately
     * afterwards, so will recover.)
     *
     * We put up with all this rather than just let levels grow
     * because otherwise, even a small map that has undergone a large
     * number of insertions and removals will have a lot of levels,
     * slowing down access more than would an occasional unwanted
     * reduction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.265 -0400", hash_original_method = "3C083AD2868479DECE8F9AED46625365", hash_generated_method = "F2A938346A1855C7329EB78BF96D8371")
    
private void tryReduceLevel() {
        HeadIndex<K,V> h = head;
        HeadIndex<K,V> d;
        HeadIndex<K,V> e;
        if (h.level > 3 &&
            (d = (HeadIndex<K,V>)h.down) != null &&
            (e = (HeadIndex<K,V>)d.down) != null &&
            e.right == null &&
            d.right == null &&
            h.right == null &&
            casHead(h, d) && // try to set
            h.right != null) // recheck
            casHead(d, h);   // try to backout
    }

    /* ---------------- Finding and removing first element -------------- */

    /**
     * Specialized variant of findNode to get first valid node.
     * @return first node or null if empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.266 -0400", hash_original_method = "786CA87D0A59CA2245AACFD4BA15681F", hash_generated_method = "786CA87D0A59CA2245AACFD4BA15681F")
    
Node<K,V> findFirst() {
        for (;;) {
            Node<K,V> b = head.node;
            Node<K,V> n = b.next;
            if (n == null)
                return null;
            if (n.value != null)
                return n;
            n.helpDelete(b, n.next);
        }
    }

    /**
     * Removes first entry; returns its snapshot.
     * @return null if empty, else snapshot of first entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.267 -0400", hash_original_method = "F5DCF3E68EF346372384DED9B98D68C9", hash_generated_method = "BA31934C4B705BA970E96C59FEA290E8")
    
Map.Entry<K,V> doRemoveFirstEntry() {
        for (;;) {
            Node<K,V> b = head.node;
            Node<K,V> n = b.next;
            if (n == null)
                return null;
            Node<K,V> f = n.next;
            if (n != b.next)
                continue;
            Object v = n.value;
            if (v == null) {
                n.helpDelete(b, f);
                continue;
            }
            if (!n.casValue(v, null))
                continue;
            if (!n.appendMarker(f) || !b.casNext(n, f))
                findFirst(); // retry
            clearIndexToFirst();
            return new AbstractMap.SimpleImmutableEntry<K,V>(n.key, (V)v);
        }
    }

    /**
     * Clears out index nodes associated with deleted first entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.267 -0400", hash_original_method = "E5475A05CDD9177DE75AFB14EE0048FD", hash_generated_method = "830D524B6766D1E16A0D086A85A876F1")
    
private void clearIndexToFirst() {
        for (;;) {
            Index<K,V> q = head;
            for (;;) {
                Index<K,V> r = q.right;
                if (r != null && r.indexesDeletedNode() && !q.unlink(r))
                    break;
                if ((q = q.down) == null) {
                    if (head.right == null)
                        tryReduceLevel();
                    return;
                }
            }
        }
    }

    /* ---------------- Finding and removing last element -------------- */

    /**
     * Specialized version of find to get last valid node.
     * @return last node or null if empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.268 -0400", hash_original_method = "F1254340946A24B6B351EA7534A8F562", hash_generated_method = "4A149002C870D7F82179D5A1AE75A1D4")
    
Node<K,V> findLast() {
        /*
         * findPredecessor can't be used to traverse index level
         * because this doesn't use comparisons.  So traversals of
         * both levels are folded together.
         */
        Index<K,V> q = head;
        for (;;) {
            Index<K,V> d, r;
            if ((r = q.right) != null) {
                if (r.indexesDeletedNode()) {
                    q.unlink(r);
                    q = head; // restart
                }
                else
                    q = r;
            } else if ((d = q.down) != null) {
                q = d;
            } else {
                Node<K,V> b = q.node;
                Node<K,V> n = b.next;
                for (;;) {
                    if (n == null)
                        return b.isBaseHeader() ? null : b;
                    Node<K,V> f = n.next;            // inconsistent read
                    if (n != b.next)
                        break;
                    Object v = n.value;
                    if (v == null) {                 // n is deleted
                        n.helpDelete(b, f);
                        break;
                    }
                    if (v == n || b.value == null)   // b is deleted
                        break;
                    b = n;
                    n = f;
                }
                q = head; // restart
            }
        }
    }

    /**
     * Specialized variant of findPredecessor to get predecessor of last
     * valid node.  Needed when removing the last entry.  It is possible
     * that all successors of returned node will have been deleted upon
     * return, in which case this method can be retried.
     * @return likely predecessor of last node
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.269 -0400", hash_original_method = "9234FBC8642D46D6E91A113BC1D36B8B", hash_generated_method = "125D2D0142FD09F62D1AFAA27ED893B7")
    
private Node<K,V> findPredecessorOfLast() {
        for (;;) {
            Index<K,V> q = head;
            for (;;) {
                Index<K,V> d, r;
                if ((r = q.right) != null) {
                    if (r.indexesDeletedNode()) {
                        q.unlink(r);
                        break;    // must restart
                    }
                    // proceed as far across as possible without overshooting
                    if (r.node.next != null) {
                        q = r;
                        continue;
                    }
                }
                if ((d = q.down) != null)
                    q = d;
                else
                    return q.node;
            }
        }
    }

    /**
     * Removes last entry; returns its snapshot.
     * Specialized variant of doRemove.
     * @return null if empty, else snapshot of last entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.270 -0400", hash_original_method = "B476CF905D5D518F58BD8550D788EA68", hash_generated_method = "E5E3A4C0A1E0E950891E347AE6281BCC")
    
Map.Entry<K,V> doRemoveLastEntry() {
        for (;;) {
            Node<K,V> b = findPredecessorOfLast();
            Node<K,V> n = b.next;
            if (n == null) {
                if (b.isBaseHeader())               // empty
                    return null;
                else
                    continue; // all b's successors are deleted; retry
            }
            for (;;) {
                Node<K,V> f = n.next;
                if (n != b.next)                    // inconsistent read
                    break;
                Object v = n.value;
                if (v == null) {                    // n is deleted
                    n.helpDelete(b, f);
                    break;
                }
                if (v == n || b.value == null)      // b is deleted
                    break;
                if (f != null) {
                    b = n;
                    n = f;
                    continue;
                }
                if (!n.casValue(v, null))
                    break;
                K key = n.key;
                Comparable<? super K> ck = comparable(key);
                if (!n.appendMarker(f) || !b.casNext(n, f))
                    findNode(ck);                  // Retry via findNode
                else {
                    findPredecessor(ck);           // Clean index
                    if (head.right == null)
                        tryReduceLevel();
                }
                return new AbstractMap.SimpleImmutableEntry<K,V>(key, (V)v);
            }
        }
    } // Actually checked as !LT

    /**
     * Utility for ceiling, floor, lower, higher methods.
     * @param kkey the key
     * @param rel the relation -- OR'ed combination of EQ, LT, GT
     * @return nearest node fitting relation, or null if no such
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.272 -0400", hash_original_method = "C646D0163855D571424284A7112C5149", hash_generated_method = "11589AAF8778A39B9A9F2E352222AD5F")
    
Node<K,V> findNear(K kkey, int rel) {
        Comparable<? super K> key = comparable(kkey);
        for (;;) {
            Node<K,V> b = findPredecessor(key);
            Node<K,V> n = b.next;
            for (;;) {
                if (n == null)
                    return ((rel & LT) == 0 || b.isBaseHeader()) ? null : b;
                Node<K,V> f = n.next;
                if (n != b.next)                  // inconsistent read
                    break;
                Object v = n.value;
                if (v == null) {                  // n is deleted
                    n.helpDelete(b, f);
                    break;
                }
                if (v == n || b.value == null)    // b is deleted
                    break;
                int c = key.compareTo(n.key);
                if ((c == 0 && (rel & EQ) != 0) ||
                    (c <  0 && (rel & LT) == 0))
                    return n;
                if ( c <= 0 && (rel & LT) != 0)
                    return b.isBaseHeader() ? null : b;
                b = n;
                n = f;
            }
        }
    }

    /**
     * Returns SimpleImmutableEntry for results of findNear.
     * @param key the key
     * @param rel the relation -- OR'ed combination of EQ, LT, GT
     * @return Entry fitting relation, or null if no such
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.273 -0400", hash_original_method = "018EDA1F5C8C181D07C408637AAC9179", hash_generated_method = "018EDA1F5C8C181D07C408637AAC9179")
    
AbstractMap.SimpleImmutableEntry<K,V> getNear(K key, int rel) {
        for (;;) {
            Node<K,V> n = findNear(key, rel);
            if (n == null)
                return null;
            AbstractMap.SimpleImmutableEntry<K,V> e = n.createSnapshot();
            if (e != null)
                return e;
        }
    }

    /**
     * Returns a shallow copy of this {@code ConcurrentSkipListMap}
     * instance. (The keys and values themselves are not cloned.)
     *
     * @return a shallow copy of this map
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.275 -0400", hash_original_method = "A98D94B351023EC620C473F0B7356583", hash_generated_method = "35BF09A13C52CEFB67FCACF7EA7C342A")
    
public ConcurrentSkipListMap<K,V> clone() {
        try {
            @SuppressWarnings("unchecked")
            ConcurrentSkipListMap<K,V> clone =
                (ConcurrentSkipListMap<K,V>) super.clone();
            clone.initialize();
            clone.buildFromSorted(this);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /**
     * Streamlined bulk insertion to initialize from elements of
     * given sorted map.  Call only from constructor or clone
     * method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.276 -0400", hash_original_method = "2DDDA9B463008021C410E41B1AF2FDA2", hash_generated_method = "B87F20D994691B1456F8E7890722AC55")
    
private void buildFromSorted(SortedMap<K, ? extends V> map) {
        if (map == null)
            throw new NullPointerException();

        HeadIndex<K,V> h = head;
        Node<K,V> basepred = h.node;

        // Track the current rightmost node at each level. Uses an
        // ArrayList to avoid committing to initial or maximum level.
        ArrayList<Index<K,V>> preds = new ArrayList<Index<K,V>>();

        // initialize
        for (int i = 0; i <= h.level; ++i)
            preds.add(null);
        Index<K,V> q = h;
        for (int i = h.level; i > 0; --i) {
            preds.set(i, q);
            q = q.down;
        }

        Iterator<? extends Map.Entry<? extends K, ? extends V>> it =
            map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<? extends K, ? extends V> e = it.next();
            int j = randomLevel();
            if (j > h.level) j = h.level + 1;
            K k = e.getKey();
            V v = e.getValue();
            if (k == null || v == null)
                throw new NullPointerException();
            Node<K,V> z = new Node<K,V>(k, v, null);
            basepred.next = z;
            basepred = z;
            if (j > 0) {
                Index<K,V> idx = null;
                for (int i = 1; i <= j; ++i) {
                    idx = new Index<K,V>(z, idx, null);
                    if (i > h.level)
                        h = new HeadIndex<K,V>(h.node, h, idx, i);

                    if (i < preds.size()) {
                        preds.get(i).right = idx;
                        preds.set(i, idx);
                    } else
                        preds.add(idx);
                }
            }
        }
        head = h;
    }

    /* ---------------- Serialization -------------- */

    /**
     * Saves this map to a stream (that is, serializes it).
     *
     * @serialData The key (Object) and value (Object) for each
     * key-value mapping represented by the map, followed by
     * {@code null}. The key-value mappings are emitted in key-order
     * (as determined by the Comparator, or by the keys' natural
     * ordering if no Comparator).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.277 -0400", hash_original_method = "2E63AFB3890721DC23A1D2577002C0D4", hash_generated_method = "CD825C828EB1BE52BC49F9B18474D5D3")
    
private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        // Write out the Comparator and any hidden stuff
        s.defaultWriteObject();

        // Write out keys and values (alternating)
        for (Node<K,V> n = findFirst(); n != null; n = n.next) {
            V v = n.getValidValue();
            if (v != null) {
                s.writeObject(n.key);
                s.writeObject(v);
            }
        }
        s.writeObject(null);
    }

    /**
     * Reconstitutes this map from a stream (that is, deserializes it).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.278 -0400", hash_original_method = "A5789DEAABDFD4C8D732F9FE94502DA7", hash_generated_method = "2A6109C914C6CBB7A381AD40D20E29DA")
    
private void readObject(final java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        // Read in the Comparator and any hidden stuff
        s.defaultReadObject();
        // Reset transients
        initialize();

        /*
         * This is nearly identical to buildFromSorted, but is
         * distinct because readObject calls can't be nicely adapted
         * as the kind of iterator needed by buildFromSorted. (They
         * can be, but doing so requires type cheats and/or creation
         * of adaptor classes.) It is simpler to just adapt the code.
         */

        HeadIndex<K,V> h = head;
        Node<K,V> basepred = h.node;
        ArrayList<Index<K,V>> preds = new ArrayList<Index<K,V>>();
        for (int i = 0; i <= h.level; ++i)
            preds.add(null);
        Index<K,V> q = h;
        for (int i = h.level; i > 0; --i) {
            preds.set(i, q);
            q = q.down;
        }

        for (;;) {
            Object k = s.readObject();
            if (k == null)
                break;
            Object v = s.readObject();
            if (v == null)
                throw new NullPointerException();
            K key = (K) k;
            V val = (V) v;
            int j = randomLevel();
            if (j > h.level) j = h.level + 1;
            Node<K,V> z = new Node<K,V>(key, val, null);
            basepred.next = z;
            basepred = z;
            if (j > 0) {
                Index<K,V> idx = null;
                for (int i = 1; i <= j; ++i) {
                    idx = new Index<K,V>(z, idx, null);
                    if (i > h.level)
                        h = new HeadIndex<K,V>(h.node, h, idx, i);

                    if (i < preds.size()) {
                        preds.get(i).right = idx;
                        preds.set(i, idx);
                    } else
                        preds.add(idx);
                }
            }
        }
        head = h;
    }

    /* ------ Map API methods ------ */

    /**
     * Returns {@code true} if this map contains a mapping for the specified
     * key.
     *
     * @param key key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.279 -0400", hash_original_method = "347E515BFB1FA41ED23B66811952D89B", hash_generated_method = "2558C2B698E7AAB2D71121BB28EB70E1")
    
public boolean containsKey(Object key) {
        return doGet(key) != null;
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code key} compares
     * equal to {@code k} according to the map's ordering, then this
     * method returns {@code v}; otherwise it returns {@code null}.
     * (There can be at most one such mapping.)
     *
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.279 -0400", hash_original_method = "D7326245B60CD8E224C8A927210BBF7F", hash_generated_method = "12A821FA966DE1472208B8DE6E87FE2F")
    
public V get(Object key) {
        return doGet(key);
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no mapping for the key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key or value is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.279 -0400", hash_original_method = "C9A6323D3BA7CB7A5EE47D73A9DDDABE", hash_generated_method = "A0963F5476A8C96D4BE368C106BF9C8F")
    
public V put(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        return doPut(key, value, false);
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param  key key for which mapping should be removed
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no mapping for the key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.280 -0400", hash_original_method = "E35E62D29EF3FAA3F823A024032BC8E2", hash_generated_method = "FC4FC6DB57BD8FD1ED23AD32CA2BEE03")
    
public V remove(Object key) {
        return doRemove(key, null);
    }

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.  This operation requires time linear in the
     * map size. Additionally, it is possible for the map to change
     * during execution of this method, in which case the returned
     * result may be inaccurate.
     *
     * @param value value whose presence in this map is to be tested
     * @return {@code true} if a mapping to {@code value} exists;
     *         {@code false} otherwise
     * @throws NullPointerException if the specified value is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.280 -0400", hash_original_method = "4D825860CA60882A06BD0852FD05725B", hash_generated_method = "CCD57CE994AA3EB26EAD837A138465D6")
    
public boolean containsValue(Object value) {
        if (value == null)
            throw new NullPointerException();
        for (Node<K,V> n = findFirst(); n != null; n = n.next) {
            V v = n.getValidValue();
            if (v != null && value.equals(v))
                return true;
        }
        return false;
    }

    /**
     * Returns the number of key-value mappings in this map.  If this map
     * contains more than {@code Integer.MAX_VALUE} elements, it
     * returns {@code Integer.MAX_VALUE}.
     *
     * <p>Beware that, unlike in most collections, this method is
     * <em>NOT</em> a constant-time operation. Because of the
     * asynchronous nature of these maps, determining the current
     * number of elements requires traversing them all to count them.
     * Additionally, it is possible for the size to change during
     * execution of this method, in which case the returned result
     * will be inaccurate. Thus, this method is typically not very
     * useful in concurrent applications.
     *
     * @return the number of elements in this map
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.281 -0400", hash_original_method = "D6ACCD92CE1076E021FB937CF44AE4FA", hash_generated_method = "0F790F3F9D18FEE7259EC5E8D08603A5")
    
public int size() {
        long count = 0;
        for (Node<K,V> n = findFirst(); n != null; n = n.next) {
            if (n.getValidValue() != null)
                ++count;
        }
        return (count >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) count;
    }

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     * @return {@code true} if this map contains no key-value mappings
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.281 -0400", hash_original_method = "A13ED8DC1AC785082DDDB288022A12E1", hash_generated_method = "F140D5B224CF2175153C15646D4437DB")
    
public boolean isEmpty() {
        return findFirst() == null;
    }

    /**
     * Removes all of the mappings from this map.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.282 -0400", hash_original_method = "BC991485BBA1DBDB0B4ABE6F7B6B2027", hash_generated_method = "DD4F3C636A4675243747EAD20501E686")
    
public void clear() {
        initialize();
    }

    /* ---------------- View methods -------------- */

    /*
     * Note: Lazy initialization works for views because view classes
     * are stateless/immutable so it doesn't matter wrt correctness if
     * more than one is created (which will only rarely happen).  Even
     * so, the following idiom conservatively ensures that the method
     * returns the one it created if it does so, not one created by
     * another racing thread.
     */

    /**
     * Returns a {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in ascending order.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  The set supports element
     * removal, which removes the corresponding mapping from the map,
     * via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear}
     * operations.  It does not support the {@code add} or {@code addAll}
     * operations.
     *
     * <p>The view's {@code iterator} is a "weakly consistent" iterator
     * that will never throw {@link ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     *
     * <p>This method is equivalent to method {@code navigableKeySet}.
     *
     * @return a navigable set view of the keys in this map
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.282 -0400", hash_original_method = "A5B21ABED5CA7C2779F7212D59B9D6F4", hash_generated_method = "4D74A77DF9250C0B2B8A5B79E1E30477")
    
public NavigableSet<K> keySet() {
        KeySet<K> ks = keySet;
        return (ks != null) ? ks : (keySet = new KeySet<K>(this));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.282 -0400", hash_original_method = "F69400CE1920E8F2F25F5B2A9072B490", hash_generated_method = "F4ACF165781634FCCAB960FDDDAECBBD")
    
public NavigableSet<K> navigableKeySet() {
        KeySet<K> ks = keySet;
        return (ks != null) ? ks : (keySet = new KeySet<K>(this));
    }

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     * The collection's iterator returns the values in ascending order
     * of the corresponding keys.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the {@code Iterator.remove},
     * {@code Collection.remove}, {@code removeAll},
     * {@code retainAll} and {@code clear} operations.  It does not
     * support the {@code add} or {@code addAll} operations.
     *
     * <p>The view's {@code iterator} is a "weakly consistent" iterator
     * that will never throw {@link ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.283 -0400", hash_original_method = "9818E9E33112B61F46CDD060782C8D17", hash_generated_method = "B7E502B8221CC9A35F931CA9234CAC71")
    
public Collection<V> values() {
        Values<V> vs = values;
        return (vs != null) ? vs : (values = new Values<V>(this));
    }

    /**
     * Returns a {@link Set} view of the mappings contained in this map.
     * The set's iterator returns the entries in ascending key order.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  The set supports element
     * removal, which removes the corresponding mapping from the map,
     * via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll} and {@code clear}
     * operations.  It does not support the {@code add} or
     * {@code addAll} operations.
     *
     * <p>The view's {@code iterator} is a "weakly consistent" iterator
     * that will never throw {@link ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     *
     * <p>The {@code Map.Entry} elements returned by
     * {@code iterator.next()} do <em>not</em> support the
     * {@code setValue} operation.
     *
     * @return a set view of the mappings contained in this map,
     *         sorted in ascending key order
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.283 -0400", hash_original_method = "C503A617C586A3413993BFB7EF8E43EE", hash_generated_method = "CCC961CFFD47A0251DE00AFB86440095")
    
public Set<Map.Entry<K,V>> entrySet() {
        EntrySet<K,V> es = entrySet;
        return (es != null) ? es : (entrySet = new EntrySet<K,V>(this));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.284 -0400", hash_original_method = "BFA70088913CCCA23DC241F62B414891", hash_generated_method = "E853A92DCCA84C8DF30E4EB5705E31E7")
    
public ConcurrentNavigableMap<K,V> descendingMap() {
        ConcurrentNavigableMap<K,V> dm = descendingMap;
        return (dm != null) ? dm : (descendingMap = new SubMap<K,V>
                                    (this, null, false, null, false, true));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.284 -0400", hash_original_method = "2E36263FBE3C4B8B29F84A4A65158DFE", hash_generated_method = "44E87D6B7201CC2393E65C036BAEB42D")
    
public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    /* ---------------- AbstractMap Overrides -------------- */

    /**
     * Compares the specified object with this map for equality.
     * Returns {@code true} if the given object is also a map and the
     * two maps represent the same mappings.  More formally, two maps
     * {@code m1} and {@code m2} represent the same mappings if
     * {@code m1.entrySet().equals(m2.entrySet())}.  This
     * operation may return misleading results if either map is
     * concurrently modified during execution of this method.
     *
     * @param o object to be compared for equality with this map
     * @return {@code true} if the specified object is equal to this map
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.285 -0400", hash_original_method = "B6E2B22FAFB6B16A3B3D16BEDFE019AB", hash_generated_method = "CABF3D3D733DA47FC6FB38D669B99A74")
    
public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map))
            return false;
        Map<?,?> m = (Map<?,?>) o;
        try {
            for (Map.Entry<K,V> e : this.entrySet())
                if (! e.getValue().equals(m.get(e.getKey())))
                    return false;
            for (Map.Entry<?,?> e : m.entrySet()) {
                Object k = e.getKey();
                Object v = e.getValue();
                if (k == null || v == null || !v.equals(get(k)))
                    return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* ------ ConcurrentMap API methods ------ */

    /**
     * {@inheritDoc}
     *
     * @return the previous value associated with the specified key,
     *         or {@code null} if there was no mapping for the key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key or value is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.285 -0400", hash_original_method = "4230857AFCAD261FDE6D170D9C4106F9", hash_generated_method = "3A48115E1192EE916FF42856B5728ED2")
    
public V putIfAbsent(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        return doPut(key, value, true);
    }

    /**
     * {@inheritDoc}
     *
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.286 -0400", hash_original_method = "183609B9944F732A90127A7F716012EB", hash_generated_method = "CBF52B543BCB85C78AA7ED31442DF291")
    
public boolean remove(Object key, Object value) {
        if (key == null)
            throw new NullPointerException();
        if (value == null)
            return false;
        return doRemove(key, value) != null;
    }

    /**
     * {@inheritDoc}
     *
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if any of the arguments are null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.287 -0400", hash_original_method = "FD554C1C707AE691E1D70DC776546382", hash_generated_method = "74ED2570D326E023FB436F31AF1D1A3F")
    
public boolean replace(K key, V oldValue, V newValue) {
        if (oldValue == null || newValue == null)
            throw new NullPointerException();
        Comparable<? super K> k = comparable(key);
        for (;;) {
            Node<K,V> n = findNode(k);
            if (n == null)
                return false;
            Object v = n.value;
            if (v != null) {
                if (!oldValue.equals(v))
                    return false;
                if (n.casValue(v, newValue))
                    return true;
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return the previous value associated with the specified key,
     *         or {@code null} if there was no mapping for the key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key or value is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.287 -0400", hash_original_method = "DE908CC3D12F50D838EAFCAF65E6FED0", hash_generated_method = "BFD2FD1395605C77A87588739836A799")
    
public V replace(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        Comparable<? super K> k = comparable(key);
        for (;;) {
            Node<K,V> n = findNode(k);
            if (n == null)
                return null;
            Object v = n.value;
            if (v != null && n.casValue(v, value))
                return (V)v;
        }
    }

    /* ------ SortedMap API methods ------ */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.288 -0400", hash_original_method = "D72D249945D6B0E3F50F6EA5908FDAD4", hash_generated_method = "B0C7E9BCFFD99983A776C85A5B26EE62")
    
public Comparator<? super K> comparator() {
        return comparator;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.288 -0400", hash_original_method = "536685B8EFBF42425E17F562E3D7EF18", hash_generated_method = "B867C69A45D72AB071364008F2DC7980")
    
public K firstKey() {
        Node<K,V> n = findFirst();
        if (n == null)
            throw new NoSuchElementException();
        return n.key;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.288 -0400", hash_original_method = "0CC90464C86915708FFB0DF983E8430F", hash_generated_method = "FF1000BEF7FCB672AA9112D814E9CBB6")
    
public K lastKey() {
        Node<K,V> n = findLast();
        if (n == null)
            throw new NoSuchElementException();
        return n.key;
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromKey} or {@code toKey} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.289 -0400", hash_original_method = "05D68035FD8534E29A6E489528A05C32", hash_generated_method = "C59525624DC1451304CFEB6EF6AC2537")
    
public ConcurrentNavigableMap<K,V> subMap(K fromKey,
                                              boolean fromInclusive,
                                              K toKey,
                                              boolean toInclusive) {
        if (fromKey == null || toKey == null)
            throw new NullPointerException();
        return new SubMap<K,V>
            (this, fromKey, fromInclusive, toKey, toInclusive, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code toKey} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.289 -0400", hash_original_method = "9ED8F79A9B359A3BDC55D09A11CDB012", hash_generated_method = "3159AAD1D1FFB4630E529ED46176EDE7")
    
public ConcurrentNavigableMap<K,V> headMap(K toKey,
                                               boolean inclusive) {
        if (toKey == null)
            throw new NullPointerException();
        return new SubMap<K,V>
            (this, null, false, toKey, inclusive, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromKey} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.290 -0400", hash_original_method = "086943226EC5638AE07DE39F7B0725D3", hash_generated_method = "B1BFA3B9A49A5FAA77B88E801911BCD6")
    
public ConcurrentNavigableMap<K,V> tailMap(K fromKey,
                                               boolean inclusive) {
        if (fromKey == null)
            throw new NullPointerException();
        return new SubMap<K,V>
            (this, fromKey, inclusive, null, false, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromKey} or {@code toKey} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.290 -0400", hash_original_method = "B001826297CF57607D56AB5CF96B8582", hash_generated_method = "CE8C6EEC4E85B0500F13ECFE5EE1770F")
    
public ConcurrentNavigableMap<K,V> subMap(K fromKey, K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code toKey} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.291 -0400", hash_original_method = "E4E9536541098D8FBE38B4D964A5139F", hash_generated_method = "F56D87DA299D0D9AA20911D72860AF54")
    
public ConcurrentNavigableMap<K,V> headMap(K toKey) {
        return headMap(toKey, false);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if {@code fromKey} is null
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.291 -0400", hash_original_method = "F0F30FD040C14BE514A88EC018A1E227", hash_generated_method = "91CF833BB3032B6F4B9271719C9AC10E")
    
public ConcurrentNavigableMap<K,V> tailMap(K fromKey) {
        return tailMap(fromKey, true);
    }

    /* ---------------- Relational operations -------------- */

    /**
     * Returns a key-value mapping associated with the greatest key
     * strictly less than the given key, or {@code null} if there is
     * no such key. The returned entry does <em>not</em> support the
     * {@code Entry.setValue} method.
     *
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.291 -0400", hash_original_method = "5B266C0986D42F429B11236FF18CCAF8", hash_generated_method = "D1BAE2585C3E117AC2F098DB40765344")
    
public Map.Entry<K,V> lowerEntry(K key) {
        return getNear(key, LT);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.292 -0400", hash_original_method = "D7085BE7E0884AB2D6ED6AE7F719551A", hash_generated_method = "E85E390557022F4F422049295A716CDC")
    
public K lowerKey(K key) {
        Node<K,V> n = findNear(key, LT);
        return (n == null) ? null : n.key;
    }

    /**
     * Returns a key-value mapping associated with the greatest key
     * less than or equal to the given key, or {@code null} if there
     * is no such key. The returned entry does <em>not</em> support
     * the {@code Entry.setValue} method.
     *
     * @param key the key
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.292 -0400", hash_original_method = "5941F7764588D6CCBECEEF8A78C667E8", hash_generated_method = "DED869E56C69F2DED5D01E42103A7647")
    
public Map.Entry<K,V> floorEntry(K key) {
        return getNear(key, LT|EQ);
    }

    /**
     * @param key the key
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.293 -0400", hash_original_method = "E6E8BBC02314C7CA58126CF3AD7B6663", hash_generated_method = "C97088A0D900B684CA732EB779F79407")
    
public K floorKey(K key) {
        Node<K,V> n = findNear(key, LT|EQ);
        return (n == null) ? null : n.key;
    }

    /**
     * Returns a key-value mapping associated with the least key
     * greater than or equal to the given key, or {@code null} if
     * there is no such entry. The returned entry does <em>not</em>
     * support the {@code Entry.setValue} method.
     *
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.293 -0400", hash_original_method = "31960ED48CA366694A6258C4DECE1B78", hash_generated_method = "008102E7B276EBB58E5D5EAB1C58975C")
    
public Map.Entry<K,V> ceilingEntry(K key) {
        return getNear(key, GT|EQ);
    }

    /**
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.293 -0400", hash_original_method = "3AECA8C6A8B718F6C7379372A090CC43", hash_generated_method = "2391B2295AA27D1DD0CBE69C22AB8A78")
    
public K ceilingKey(K key) {
        Node<K,V> n = findNear(key, GT|EQ);
        return (n == null) ? null : n.key;
    }

    /**
     * Returns a key-value mapping associated with the least key
     * strictly greater than the given key, or {@code null} if there
     * is no such key. The returned entry does <em>not</em> support
     * the {@code Entry.setValue} method.
     *
     * @param key the key
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.294 -0400", hash_original_method = "19411F2EE0CF54FB31E2A203A052BEA6", hash_generated_method = "D59BD36C72CCD426F3DB5C54CC7B89F3")
    
public Map.Entry<K,V> higherEntry(K key) {
        return getNear(key, GT);
    }

    /**
     * @param key the key
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException if the specified key is null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.294 -0400", hash_original_method = "55C7F6AAD7EAA15B785710148F0FF678", hash_generated_method = "4CD4E36F5415B201BE6DDCCAC13DC70C")
    
public K higherKey(K key) {
        Node<K,V> n = findNear(key, GT);
        return (n == null) ? null : n.key;
    }

    /**
     * Returns a key-value mapping associated with the least
     * key in this map, or {@code null} if the map is empty.
     * The returned entry does <em>not</em> support
     * the {@code Entry.setValue} method.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.295 -0400", hash_original_method = "884AD13FFBF6D547351EDBDC8347D70F", hash_generated_method = "B2C88DDCF1FA0ADCD70A81BBD012FA29")
    
public Map.Entry<K,V> firstEntry() {
        for (;;) {
            Node<K,V> n = findFirst();
            if (n == null)
                return null;
            AbstractMap.SimpleImmutableEntry<K,V> e = n.createSnapshot();
            if (e != null)
                return e;
        }
    }

    /* ---------------- Iterators -------------- */

    /**
     * Base of iterator classes:
     */
    abstract class Iter<T> implements Iterator<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.296 -0400", hash_original_field = "A61618791A3339D56E39272FB473E5C8", hash_generated_field = "A61618791A3339D56E39272FB473E5C8")

        Node<K,V> lastReturned;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.297 -0400", hash_original_field = "D1C8B20089B08F3F6EDCF099CD3F45A9", hash_generated_field = "D1C8B20089B08F3F6EDCF099CD3F45A9")

        Node<K,V> next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.297 -0400", hash_original_field = "185FAE73D6299E494AB7E80388AD47EC", hash_generated_field = "185FAE73D6299E494AB7E80388AD47EC")

        V nextValue;

        /** Initializes ascending iterator for entire range. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.298 -0400", hash_original_method = "39DAA14D954D9E54B8393718BBB5F22E", hash_generated_method = "39DAA14D954D9E54B8393718BBB5F22E")
        
Iter() {
            for (;;) {
                next = findFirst();
                if (next == null)
                    break;
                Object x = next.value;
                if (x != null && x != next) {
                    nextValue = (V) x;
                    break;
                }
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.298 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "ACD421FE635E107B761C79834D492449")
        
public final boolean hasNext() {
            return next != null;
        }

        /** Advances next to higher entry. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.299 -0400", hash_original_method = "B494848479781580D469120D32A92415", hash_generated_method = "365FDE2A6C2A205DBB00FE193E53680D")
        
final void advance() {
            if (next == null)
                throw new NoSuchElementException();
            lastReturned = next;
            for (;;) {
                next = next.next;
                if (next == null)
                    break;
                Object x = next.value;
                if (x != null && x != next) {
                    nextValue = (V) x;
                    break;
                }
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.299 -0400", hash_original_method = "07ED6DADA064BFE7DB17055926457D27", hash_generated_method = "66E38EB300265EECCB78DED98DE82AA5")
        
public void remove() {
            Node<K,V> l = lastReturned;
            if (l == null)
                throw new IllegalStateException();
            // It would not be worth all of the overhead to directly
            // unlink from here. Using remove is fast enough.
            ConcurrentSkipListMap.this.remove(l.key);
            lastReturned = null;
        }

    }

    final class ValueIterator extends Iter<V> {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.300 -0400", hash_original_method = "DC4893657DB230E9949864D6AB52BE41", hash_generated_method = "C51919C60238A714A084E53419FE9821")
        
public V next() {
            V v = nextValue;
            advance();
            return v;
        }
    }

    final class KeyIterator extends Iter<K> {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.301 -0400", hash_original_method = "BB69EE7005851DCF2320672553D16AC3", hash_generated_method = "815DBC7F50E7E17EB5F37486E0B6D5D9")
        
public K next() {
            Node<K,V> n = next;
            advance();
            return n.key;
        }
    }

    final class EntryIterator extends Iter<Map.Entry<K,V>> {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.302 -0400", hash_original_method = "CF862345FA84B63897E1591A1341E3A2", hash_generated_method = "C790AC6DE49939DFD7E09E32550670D0")
        
public Map.Entry<K,V> next() {
            Node<K,V> n = next;
            V v = nextValue;
            advance();
            return new AbstractMap.SimpleImmutableEntry<K,V>(n.key, v);
        }
    }

    /**
     * Returns a key-value mapping associated with the greatest
     * key in this map, or {@code null} if the map is empty.
     * The returned entry does <em>not</em> support
     * the {@code Entry.setValue} method.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.295 -0400", hash_original_method = "8B2F0FFA802D17611A4395C2AC8FB574", hash_generated_method = "9823404D25942D7B6C24D558ED47EDF1")
    
public Map.Entry<K,V> lastEntry() {
        for (;;) {
            Node<K,V> n = findLast();
            if (n == null)
                return null;
            AbstractMap.SimpleImmutableEntry<K,V> e = n.createSnapshot();
            if (e != null)
                return e;
        }
    }

    /**
     * Removes and returns a key-value mapping associated with
     * the least key in this map, or {@code null} if the map is empty.
     * The returned entry does <em>not</em> support
     * the {@code Entry.setValue} method.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.295 -0400", hash_original_method = "8742E1F0759B337AF13BCCA1D7B4426A", hash_generated_method = "3DFF46C004E242A6615C62706B2DEE32")
    
public Map.Entry<K,V> pollFirstEntry() {
        return doRemoveFirstEntry();
    }

    /**
     * Removes and returns a key-value mapping associated with
     * the greatest key in this map, or {@code null} if the map is empty.
     * The returned entry does <em>not</em> support
     * the {@code Entry.setValue} method.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.296 -0400", hash_original_method = "730CB01F5653582082CD9EFD4889D727", hash_generated_method = "CC5C9EF9F81DD24060A26E266167D4E3")
    
public Map.Entry<K,V> pollLastEntry() {
        return doRemoveLastEntry();
    }

    // Factory methods for iterators needed by ConcurrentSkipListSet etc

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.303 -0400", hash_original_method = "BF0F2BB402B08B2CA609B2CA844CABC3", hash_generated_method = "BF0F2BB402B08B2CA609B2CA844CABC3")
    
Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    static final class KeySet<E>
            extends AbstractSet<E> implements NavigableSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.304 -0400", hash_original_field = "E9F6C0ADFCB1A1699772C3C2599A1C0B", hash_generated_field = "940AFCBABEA01D2E80BB51E86AE99FE8")

        private  ConcurrentNavigableMap<E,?> m;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.304 -0400", hash_original_method = "A7459AA686A5C9CBD3691465FB1225D8", hash_generated_method = "A7459AA686A5C9CBD3691465FB1225D8")
        
KeySet(ConcurrentNavigableMap<E,?> map) { m = map; }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.305 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "B6A481AB385BBDAEA9A99BEF48697907")
        
public int size() { return m.size(); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.305 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "34A044B85338F80AC374E61345D72801")
        
public boolean isEmpty() { return m.isEmpty(); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.306 -0400", hash_original_method = "93D27F83E886B31790810958F2BFC989", hash_generated_method = "B5A050C42D8B6E4A1BCB73C685ADB7FC")
        
public boolean contains(Object o) { return m.containsKey(o); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.306 -0400", hash_original_method = "75727FBBAACB7F01962781CF241F44AB", hash_generated_method = "78414177A11D1C23C82621C0F4BE4CAF")
        
public boolean remove(Object o) { return m.remove(o) != null; }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.306 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "2176D445272406688DBDA5C0282AE3E2")
        
public void clear() { m.clear(); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.306 -0400", hash_original_method = "10F5AE4F9BF066ED54975005050E0A23", hash_generated_method = "D32FEA92767C3F39B1D28E106F859C25")
        
public E lower(E e) { return m.lowerKey(e); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.307 -0400", hash_original_method = "2C2553165E35C727802F311B361A1F6C", hash_generated_method = "07B1A5896D91EAC9ADADDF8A6E5E462D")
        
public E floor(E e) { return m.floorKey(e); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.307 -0400", hash_original_method = "772A3530FF9574E83AE3BF5219D76116", hash_generated_method = "860BE16303AEA4625B9BFF80822A414C")
        
public E ceiling(E e) { return m.ceilingKey(e); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.307 -0400", hash_original_method = "DB19F68E3F0204E010448E0B14609A4A", hash_generated_method = "DC75F8BD2213EAF1F10ED1C10B480C5A")
        
public E higher(E e) { return m.higherKey(e); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.308 -0400", hash_original_method = "820C6AEF3954D2EE59DA490481F0B7A1", hash_generated_method = "4B36A3158C155E201AC90E71446E8FDF")
        
public Comparator<? super E> comparator() { return m.comparator(); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.308 -0400", hash_original_method = "5D8C9DE6ABA3C57BE67F77FBFD9DC6D8", hash_generated_method = "8618BF77DA48B7C5ACF4105D185DC131")
        
public E first() { return m.firstKey(); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.308 -0400", hash_original_method = "D0E174621F7616B481FD7AB7D93D10A3", hash_generated_method = "D18FF8A99CFBC6921AD15151C6B94B9E")
        
public E last() { return m.lastKey(); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.309 -0400", hash_original_method = "0C8C5EC81225A505AEB197606936C5BF", hash_generated_method = "A7CAE3CA0449AA6674D76D49E85C70EE")
        
public E pollFirst() {
            Map.Entry<E,?> e = m.pollFirstEntry();
            return (e == null) ? null : e.getKey();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.309 -0400", hash_original_method = "9B2C965F249CFB69C42C2A51E0CA9712", hash_generated_method = "FE32F28E3DD71F91EC2D549452AE77F4")
        
public E pollLast() {
            Map.Entry<E,?> e = m.pollLastEntry();
            return (e == null) ? null : e.getKey();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.310 -0400", hash_original_method = "AA614EF0DA7FE804984D56C7EE6A7862", hash_generated_method = "E2E03633344F98C7E09AA84B197AD02E")
        
public Iterator<E> iterator() {
            if (m instanceof ConcurrentSkipListMap)
                return ((ConcurrentSkipListMap<E,Object>)m).keyIterator();
            else
                return ((ConcurrentSkipListMap.SubMap<E,Object>)m).keyIterator();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.310 -0400", hash_original_method = "6A0DE4C77139F252A7F681C504B1BD64", hash_generated_method = "EF316C654A3B2A87F306E467B2EDEAE0")
        
public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Set))
                return false;
            Collection<?> c = (Collection<?>) o;
            try {
                return containsAll(c) && c.containsAll(this);
            } catch (ClassCastException unused) {
                return false;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.310 -0400", hash_original_method = "D138E4E1D4A552AFDB5EABDD2C630E5D", hash_generated_method = "861705CB4BD74D1F8CDEC771C101F9D3")
        
public Object[] toArray()     { return toList(this).toArray();  }
        @DSSafe(DSCat.SAFE_LIST)
        public <T> T[] toArray(T[] a) { return toList(this).toArray(a); }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.311 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "AE8E2BDAEFE60A685698B1D5135080A2")
        
public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.311 -0400", hash_original_method = "367FDB8AA1AFE39D7C76154D8FCF91E0", hash_generated_method = "BA37C7AF8446B41985BB43675622F824")
        
public NavigableSet<E> subSet(E fromElement,
                                      boolean fromInclusive,
                                      E toElement,
                                      boolean toInclusive) {
            return new KeySet<E>(m.subMap(fromElement, fromInclusive,
                                          toElement,   toInclusive));
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.312 -0400", hash_original_method = "82B3E92DCE808CCB91503D8EFC006A4E", hash_generated_method = "36C266F3051B6531950B2861D88DBC6A")
        
public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return new KeySet<E>(m.headMap(toElement, inclusive));
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.312 -0400", hash_original_method = "3BA2DA613388A9C2B1EDEECC93CA7708", hash_generated_method = "2FE59D5900956C7FB3724F2F07C80321")
        
public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return new KeySet<E>(m.tailMap(fromElement, inclusive));
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.312 -0400", hash_original_method = "BA767B7DA98792FEF815295972E2FEB5", hash_generated_method = "68608E59C890095F14A3380248DB46DA")
        
public NavigableSet<E> subSet(E fromElement, E toElement) {
            return subSet(fromElement, true, toElement, false);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.314 -0400", hash_original_method = "46ABB76D7FEEBB9F7E3797A8C60354C5", hash_generated_method = "D61B6C1A1BFD365C1936C8DCE2AC410A")
        
public NavigableSet<E> headSet(E toElement) {
            return headSet(toElement, false);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.315 -0400", hash_original_method = "33B2FADE88BACD2AE867FBAD0F2395D8", hash_generated_method = "7BFF6469941869BFE6B08369B59A6B2E")
        
public NavigableSet<E> tailSet(E fromElement) {
            return tailSet(fromElement, true);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.315 -0400", hash_original_method = "A9B54B6EC3543B77690AB5910B7FB24A", hash_generated_method = "42F2A7CF71964DDEDB5FDC631B055F74")
        
public NavigableSet<E> descendingSet() {
            return new KeySet<E>(m.descendingMap());
        }
    }

    static final class Values<E> extends AbstractCollection<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.317 -0400", hash_original_field = "71841526F8EE93D4BF9E7BA41CA324DF", hash_generated_field = "4D7CEFD32C10F5BC80A04AC64F17366E")

        private  ConcurrentNavigableMap<?, E> m;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.317 -0400", hash_original_method = "36CF1C44FAE174FAB740BE7B35EA481F", hash_generated_method = "36CF1C44FAE174FAB740BE7B35EA481F")
        
Values(ConcurrentNavigableMap<?, E> map) {
            m = map;
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.318 -0400", hash_original_method = "8D19B2FB454FF7080A681FC4EC1C598C", hash_generated_method = "3EEBCAC0D9E593AD3A08420913DEC1B2")
        
public Iterator<E> iterator() {
            if (m instanceof ConcurrentSkipListMap)
                return ((ConcurrentSkipListMap<?,E>)m).valueIterator();
            else
                return ((SubMap<?,E>)m).valueIterator();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.318 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "34A044B85338F80AC374E61345D72801")
        
public boolean isEmpty() {
            return m.isEmpty();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.318 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "B6A481AB385BBDAEA9A99BEF48697907")
        
public int size() {
            return m.size();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.319 -0400", hash_original_method = "443995FA6506EA4CFB17E3B6459BE961", hash_generated_method = "F52EEBE02BE601F10AD975BB666F7380")
        
public boolean contains(Object o) {
            return m.containsValue(o);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.319 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "2176D445272406688DBDA5C0282AE3E2")
        
public void clear() {
            m.clear();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.319 -0400", hash_original_method = "D138E4E1D4A552AFDB5EABDD2C630E5D", hash_generated_method = "861705CB4BD74D1F8CDEC771C101F9D3")
        
public Object[] toArray()     { return toList(this).toArray();  }
        @DSSafe(DSCat.SAFE_LIST)
        public <T> T[] toArray(T[] a) { return toList(this).toArray(a); }
    }

    static final class EntrySet<K1,V1> extends AbstractSet<Map.Entry<K1,V1>> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.321 -0400", hash_original_field = "F1C2FD822D0A682D8FC7D2F3318A0975", hash_generated_field = "30FC06F28BBE369552FD019EC5D754AA")

        private  ConcurrentNavigableMap<K1, V1> m;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.321 -0400", hash_original_method = "04EFD07A06735BE45354333F11D604F7", hash_generated_method = "04EFD07A06735BE45354333F11D604F7")
        
EntrySet(ConcurrentNavigableMap<K1, V1> map) {
            m = map;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.322 -0400", hash_original_method = "891233B026985D5F8D25668E05AE0BA0", hash_generated_method = "E385135B2775C9A851A814ED28B4395B")
        
public Iterator<Map.Entry<K1,V1>> iterator() {
            if (m instanceof ConcurrentSkipListMap)
                return ((ConcurrentSkipListMap<K1,V1>)m).entryIterator();
            else
                return ((SubMap<K1,V1>)m).entryIterator();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.322 -0400", hash_original_method = "5CD3AE3789A3428E468E154DAF129D78", hash_generated_method = "DE31B0913292778F0017FC09427B7D00")
        
public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            V1 v = m.get(e.getKey());
            return v != null && v.equals(e.getValue());
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.323 -0400", hash_original_method = "E25D68C9779FF0F16828DD782E4DF2FA", hash_generated_method = "B1CA0A62C69C0604574AD5DA6830C433")
        
public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            return m.remove(e.getKey(),
                            e.getValue());
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.323 -0400", hash_original_method = "B9E63D3C52241E7E917CB1416ABA36E5", hash_generated_method = "34A044B85338F80AC374E61345D72801")
        
public boolean isEmpty() {
            return m.isEmpty();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.323 -0400", hash_original_method = "A04EE09DEB6F21FAA6A7E10DF6401CD1", hash_generated_method = "B6A481AB385BBDAEA9A99BEF48697907")
        
public int size() {
            return m.size();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.324 -0400", hash_original_method = "5163CA2ED3AD9C66F2BDAFB902590115", hash_generated_method = "2176D445272406688DBDA5C0282AE3E2")
        
public void clear() {
            m.clear();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.324 -0400", hash_original_method = "6A0DE4C77139F252A7F681C504B1BD64", hash_generated_method = "EF316C654A3B2A87F306E467B2EDEAE0")
        
public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Set))
                return false;
            Collection<?> c = (Collection<?>) o;
            try {
                return containsAll(c) && c.containsAll(this);
            } catch (ClassCastException unused) {
                return false;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.324 -0400", hash_original_method = "D138E4E1D4A552AFDB5EABDD2C630E5D", hash_generated_method = "861705CB4BD74D1F8CDEC771C101F9D3")
        
public Object[] toArray()     { return toList(this).toArray();  }
        @DSSafe(DSCat.SAFE_LIST)
        public <T> T[] toArray(T[] a) { return toList(this).toArray(a); }
    }

    /**
     * Submaps returned by {@link ConcurrentSkipListMap} submap operations
     * represent a subrange of mappings of their underlying
     * maps. Instances of this class support all methods of their
     * underlying maps, differing in that mappings outside their range are
     * ignored, and attempts to add mappings outside their ranges result
     * in {@link IllegalArgumentException}.  Instances of this class are
     * constructed only using the {@code subMap}, {@code headMap}, and
     * {@code tailMap} methods of their underlying maps.
     *
     * @serial include
     */
    static final class SubMap<K,V> extends AbstractMap<K,V>
        implements ConcurrentNavigableMap<K,V>, Cloneable,
                   java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.326 -0400", hash_original_field = "2C6B209825E238B60940D9A0A6226690", hash_generated_field = "62922C9EE6A6C69045429610CD8EA2A7")

        private static final long serialVersionUID = -7647078645895051609L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.327 -0400", hash_original_field = "A8ABF104FB10D907A2D72650ACCBAEDD", hash_generated_field = "CFB51DB77D16F1D0CE9B9CAACAC29A75")

        private  ConcurrentSkipListMap<K,V> m;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.327 -0400", hash_original_field = "8F7C97310A6420BA161F93A57A97C08C", hash_generated_field = "D4668468FEA54ACC926D8372A5F358AC")

        private  K lo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.327 -0400", hash_original_field = "44CA701EDB521D99BD9606E4885C79E8", hash_generated_field = "5EA893562A93C354F64AEC7AD0ED5D01")

        private  K hi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.328 -0400", hash_original_field = "21B44DD2A9CF91217A1B213D6DC61745", hash_generated_field = "B2FA0E60607CC72B3B2FE0E35E808DCE")

        private  boolean loInclusive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.328 -0400", hash_original_field = "B6BC458569D2A14CE4BE7D6F92D77203", hash_generated_field = "536ADA5B7C6D17EBC52BFA040960AACF")

        private  boolean hiInclusive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.329 -0400", hash_original_field = "137BB81FDC510CD7BC6835D84C7626F1", hash_generated_field = "78677C2393C3D7958B773F873DB31A98")

        private  boolean isDescending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.329 -0400", hash_original_field = "FCC89A79221CCE6F162F8922865D2323", hash_generated_field = "F1D2592FD03AA52C58BB2CC8E6777ABF")

        private transient KeySet<K> keySetView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.329 -0400", hash_original_field = "ABB4133A8E98E40A25257DCA7A382CE9", hash_generated_field = "67101C8FDA6E0C91BC7E0912C4580266")

        private transient Set<Map.Entry<K,V>> entrySetView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.330 -0400", hash_original_field = "B797671E35EBB41F8E1A207454BB34A0", hash_generated_field = "2FBCBA6119ECD1816161D5D6724F2DA2")

        private transient Collection<V> valuesView;

        /**
         * Creates a new submap, initializing all fields.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.331 -0400", hash_original_method = "142B9ECADA30F41695AEA5471DF0DE21", hash_generated_method = "142B9ECADA30F41695AEA5471DF0DE21")
        
SubMap(ConcurrentSkipListMap<K,V> map,
               K fromKey, boolean fromInclusive,
               K toKey, boolean toInclusive,
               boolean isDescending) {
            if (fromKey != null && toKey != null &&
                map.compare(fromKey, toKey) > 0)
                throw new IllegalArgumentException("inconsistent range");
            this.m = map;
            this.lo = fromKey;
            this.hi = toKey;
            this.loInclusive = fromInclusive;
            this.hiInclusive = toInclusive;
            this.isDescending = isDescending;
        }

        /* ----------------  Utilities -------------- */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.331 -0400", hash_original_method = "23FC1246F13AB11404022C160271BD48", hash_generated_method = "908D5AE08A9AF7C53E7E533FC2D79EE8")
        
private boolean tooLow(K key) {
            if (lo != null) {
                int c = m.compare(key, lo);
                if (c < 0 || (c == 0 && !loInclusive))
                    return true;
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.332 -0400", hash_original_method = "82BCD46FE8D114ADDCFB70A6201952F5", hash_generated_method = "8EEBDF3FA9ED3F170101376FD0A0AF68")
        
private boolean tooHigh(K key) {
            if (hi != null) {
                int c = m.compare(key, hi);
                if (c > 0 || (c == 0 && !hiInclusive))
                    return true;
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.332 -0400", hash_original_method = "92F21F5CBCB43090561F98B639D88B60", hash_generated_method = "1C20A5FAAE80EC3FB588524336B5762A")
        
private boolean inBounds(K key) {
            return !tooLow(key) && !tooHigh(key);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.332 -0400", hash_original_method = "87D03D8A99CD286902A7E21B62D52A60", hash_generated_method = "893C2F30B83DC31E7859ABFD1B89D971")
        
private void checkKeyBounds(K key) throws IllegalArgumentException {
            if (key == null)
                throw new NullPointerException();
            if (!inBounds(key))
                throw new IllegalArgumentException("key out of range");
        }

        /**
         * Returns true if node key is less than upper bound of range.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.333 -0400", hash_original_method = "04A5EF324FF7075A4D71ED932007FA11", hash_generated_method = "32884BC722F0D7A896496B0BFB4CF57B")
        
private boolean isBeforeEnd(ConcurrentSkipListMap.Node<K,V> n) {
            if (n == null)
                return false;
            if (hi == null)
                return true;
            K k = n.key;
            if (k == null) // pass by markers and headers
                return true;
            int c = m.compare(k, hi);
            if (c > 0 || (c == 0 && !hiInclusive))
                return false;
            return true;
        }

        /**
         * Returns lowest node. This node might not be in range, so
         * most usages need to check bounds.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.333 -0400", hash_original_method = "C4C497FE1F717FAF9D81F857B4C33DF8", hash_generated_method = "B6658BAC938DB8A45641F694ECFCEAA0")
        
private ConcurrentSkipListMap.Node<K,V> loNode() {
            if (lo == null)
                return m.findFirst();
            else if (loInclusive)
                return m.findNear(lo, GT|EQ);
            else
                return m.findNear(lo, GT);
        }

        /**
         * Returns highest node. This node might not be in range, so
         * most usages need to check bounds.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.334 -0400", hash_original_method = "7FA7B038BD0112092FF3B5CFF2FD8ABC", hash_generated_method = "B91D0758DD984328EF609D5B8A403672")
        
private ConcurrentSkipListMap.Node<K,V> hiNode() {
            if (hi == null)
                return m.findLast();
            else if (hiInclusive)
                return m.findNear(hi, LT|EQ);
            else
                return m.findNear(hi, LT);
        }

        /**
         * Returns lowest absolute key (ignoring directonality).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.334 -0400", hash_original_method = "567906B7B519F9A9A16432ADEC0EAB91", hash_generated_method = "B899414B748EDC4978993F8A34171827")
        
private K lowestKey() {
            ConcurrentSkipListMap.Node<K,V> n = loNode();
            if (isBeforeEnd(n))
                return n.key;
            else
                throw new NoSuchElementException();
        }

        /**
         * Returns highest absolute key (ignoring directonality).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.335 -0400", hash_original_method = "2820A155EE0C032E379B42463D0F7CBC", hash_generated_method = "DFE485655B8BE3A5F7EA901213D7FC8C")
        
private K highestKey() {
            ConcurrentSkipListMap.Node<K,V> n = hiNode();
            if (n != null) {
                K last = n.key;
                if (inBounds(last))
                    return last;
            }
            throw new NoSuchElementException();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.335 -0400", hash_original_method = "7D5FBAA38256D505C95BCF4AD1397D7E", hash_generated_method = "C118974440219C9F8CE288B0E71322D7")
        
private Map.Entry<K,V> lowestEntry() {
            for (;;) {
                ConcurrentSkipListMap.Node<K,V> n = loNode();
                if (!isBeforeEnd(n))
                    return null;
                Map.Entry<K,V> e = n.createSnapshot();
                if (e != null)
                    return e;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.336 -0400", hash_original_method = "D1232CF1DDE53B904C28BAFFFB0515DC", hash_generated_method = "AE6777B0FF998EB3D598DCDFAF51876A")
        
private Map.Entry<K,V> highestEntry() {
            for (;;) {
                ConcurrentSkipListMap.Node<K,V> n = hiNode();
                if (n == null || !inBounds(n.key))
                    return null;
                Map.Entry<K,V> e = n.createSnapshot();
                if (e != null)
                    return e;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.336 -0400", hash_original_method = "9DEDCFFD7141C8913AB9FD736B014CFB", hash_generated_method = "F0955D1BA1499F6A77EC6E60520C9F9F")
        
private Map.Entry<K,V> removeLowest() {
            for (;;) {
                Node<K,V> n = loNode();
                if (n == null)
                    return null;
                K k = n.key;
                if (!inBounds(k))
                    return null;
                V v = m.doRemove(k, null);
                if (v != null)
                    return new AbstractMap.SimpleImmutableEntry<K,V>(k, v);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.337 -0400", hash_original_method = "746007CC46AF7C4F4C06BFFC954F32C0", hash_generated_method = "BCFB9125CE26AE6D806860FF378ED56F")
        
private Map.Entry<K,V> removeHighest() {
            for (;;) {
                Node<K,V> n = hiNode();
                if (n == null)
                    return null;
                K k = n.key;
                if (!inBounds(k))
                    return null;
                V v = m.doRemove(k, null);
                if (v != null)
                    return new AbstractMap.SimpleImmutableEntry<K,V>(k, v);
            }
        }

        /**
         * Submap version of ConcurrentSkipListMap.getNearEntry
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.338 -0400", hash_original_method = "61EAFF1792A39BCCFBC7525DE8B0F031", hash_generated_method = "9BF897A5B2EFE9164A1159CC45D317F7")
        
private Map.Entry<K,V> getNearEntry(K key, int rel) {
            if (isDescending) { // adjust relation for direction
                if ((rel & LT) == 0)
                    rel |= LT;
                else
                    rel &= ~LT;
            }
            if (tooLow(key))
                return ((rel & LT) != 0) ? null : lowestEntry();
            if (tooHigh(key))
                return ((rel & LT) != 0) ? highestEntry() : null;
            for (;;) {
                Node<K,V> n = m.findNear(key, rel);
                if (n == null || !inBounds(n.key))
                    return null;
                K k = n.key;
                V v = n.getValidValue();
                if (v != null)
                    return new AbstractMap.SimpleImmutableEntry<K,V>(k, v);
            }
        }

        // Almost the same as getNearEntry, except for keys
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.339 -0400", hash_original_method = "75A831BC015DDDF1C23CF68921933DDF", hash_generated_method = "079A964BD547182E8E6A97C3E2727BD3")
        
private K getNearKey(K key, int rel) {
            if (isDescending) { // adjust relation for direction
                if ((rel & LT) == 0)
                    rel |= LT;
                else
                    rel &= ~LT;
            }
            if (tooLow(key)) {
                if ((rel & LT) == 0) {
                    ConcurrentSkipListMap.Node<K,V> n = loNode();
                    if (isBeforeEnd(n))
                        return n.key;
                }
                return null;
            }
            if (tooHigh(key)) {
                if ((rel & LT) != 0) {
                    ConcurrentSkipListMap.Node<K,V> n = hiNode();
                    if (n != null) {
                        K last = n.key;
                        if (inBounds(last))
                            return last;
                    }
                }
                return null;
            }
            for (;;) {
                Node<K,V> n = m.findNear(key, rel);
                if (n == null || !inBounds(n.key))
                    return null;
                K k = n.key;
                V v = n.getValidValue();
                if (v != null)
                    return k;
            }
        }

        /* ----------------  Map API methods -------------- */

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.339 -0400", hash_original_method = "4131F0A0CF85034A2FBF41E104CCE4CC", hash_generated_method = "8A1D2EEC48200D5CC1A0BE2E5F99F7E2")
        
public boolean containsKey(Object key) {
            if (key == null) throw new NullPointerException();
            K k = (K)key;
            return inBounds(k) && m.containsKey(k);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.339 -0400", hash_original_method = "D65DED8989E5682E214AD0A347023F0F", hash_generated_method = "92D1B474B3AEF5F0DC0C85BE60F79E6D")
        
public V get(Object key) {
            if (key == null) throw new NullPointerException();
            K k = (K)key;
            return (!inBounds(k)) ? null : m.get(k);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.340 -0400", hash_original_method = "22F4B2A1B816B785A79B6EE9C7EF70C6", hash_generated_method = "47D4BBD41CB709713EED74396CFB1256")
        
public V put(K key, V value) {
            checkKeyBounds(key);
            return m.put(key, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.340 -0400", hash_original_method = "F93203F046A271CF70F49E1638C9D76E", hash_generated_method = "FE1DB92380A8A9484FCCA466EB02F0F6")
        
public V remove(Object key) {
            K k = (K)key;
            return (!inBounds(k)) ? null : m.remove(k);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.341 -0400", hash_original_method = "24CDF00227D433318CBA3136A5C1CDF0", hash_generated_method = "DBDE119B4AB2D73CAC30C0A5182C5090")
        
public int size() {
            long count = 0;
            for (ConcurrentSkipListMap.Node<K,V> n = loNode();
                 isBeforeEnd(n);
                 n = n.next) {
                if (n.getValidValue() != null)
                    ++count;
            }
            return count >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)count;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.341 -0400", hash_original_method = "0429D3B02E6239EC48D83D1C990354F1", hash_generated_method = "9549ADBF722ACD5059F58A959CCA633A")
        
public boolean isEmpty() {
            return !isBeforeEnd(loNode());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.342 -0400", hash_original_method = "C40DA07B033BC3629CA58CC7FA875DBC", hash_generated_method = "196C29AE8ADA8F173C3480418945687D")
        
public boolean containsValue(Object value) {
            if (value == null)
                throw new NullPointerException();
            for (ConcurrentSkipListMap.Node<K,V> n = loNode();
                 isBeforeEnd(n);
                 n = n.next) {
                V v = n.getValidValue();
                if (v != null && value.equals(v))
                    return true;
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.342 -0400", hash_original_method = "7B335DFDB82C765E241767EDB3C9A3A5", hash_generated_method = "C56CAEBB6B52C7C2A6FF234113B40624")
        
public void clear() {
            for (ConcurrentSkipListMap.Node<K,V> n = loNode();
                 isBeforeEnd(n);
                 n = n.next) {
                if (n.getValidValue() != null)
                    m.remove(n.key);
            }
        }

        /* ----------------  ConcurrentMap API methods -------------- */

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.343 -0400", hash_original_method = "9945794FB73BDD7766FCE0355E651FC6", hash_generated_method = "2984817100B745EA21045644EA83FE5C")
        
public V putIfAbsent(K key, V value) {
            checkKeyBounds(key);
            return m.putIfAbsent(key, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.343 -0400", hash_original_method = "5BC0F82875BE6261DE40A5F4D9B46612", hash_generated_method = "7296CD4FB67FCE8392BD8325C1E372C0")
        
public boolean remove(Object key, Object value) {
            K k = (K)key;
            return inBounds(k) && m.remove(k, value);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.343 -0400", hash_original_method = "CDE6457CB4AE4AA66D95DDBE89911FEB", hash_generated_method = "7F536C7BD4D66533F3019B9D5019361C")
        
public boolean replace(K key, V oldValue, V newValue) {
            checkKeyBounds(key);
            return m.replace(key, oldValue, newValue);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.344 -0400", hash_original_method = "B8CFAAEA04D773E4C1BB045FA30C8C26", hash_generated_method = "F30B2B23575B51ADD913EB744DEB669B")
        
public V replace(K key, V value) {
            checkKeyBounds(key);
            return m.replace(key, value);
        }

        /* ----------------  SortedMap API methods -------------- */

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.345 -0400", hash_original_method = "DAFF5E10D9D2EA1B7244DFCC8DCAAA02", hash_generated_method = "B2EABE140509724C265DB201576AE7F3")
        
public Comparator<? super K> comparator() {
            Comparator<? super K> cmp = m.comparator();
            if (isDescending)
                return Collections.reverseOrder(cmp);
            else
                return cmp;
        }

        /**
         * Utility to create submaps, where given bounds override
         * unbounded(null) ones and/or are checked against bounded ones.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.345 -0400", hash_original_method = "B019DAECB2569BDAA496465AA5D658BF", hash_generated_method = "1AC2F6DCC09FB7F84D0EBB90CAFCEC43")
        
private SubMap<K,V> newSubMap(K fromKey,
                                      boolean fromInclusive,
                                      K toKey,
                                      boolean toInclusive) {
            if (isDescending) { // flip senses
                K tk = fromKey;
                fromKey = toKey;
                toKey = tk;
                boolean ti = fromInclusive;
                fromInclusive = toInclusive;
                toInclusive = ti;
            }
            if (lo != null) {
                if (fromKey == null) {
                    fromKey = lo;
                    fromInclusive = loInclusive;
                }
                else {
                    int c = m.compare(fromKey, lo);
                    if (c < 0 || (c == 0 && !loInclusive && fromInclusive))
                        throw new IllegalArgumentException("key out of range");
                }
            }
            if (hi != null) {
                if (toKey == null) {
                    toKey = hi;
                    toInclusive = hiInclusive;
                }
                else {
                    int c = m.compare(toKey, hi);
                    if (c > 0 || (c == 0 && !hiInclusive && toInclusive))
                        throw new IllegalArgumentException("key out of range");
                }
            }
            return new SubMap<K,V>(m, fromKey, fromInclusive,
                                   toKey, toInclusive, isDescending);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.346 -0400", hash_original_method = "49CF0361711D05779A82FDD8EFC28BFC", hash_generated_method = "8DD89AA2447201C26EFB17488C5E3565")
        
public SubMap<K,V> subMap(K fromKey,
                                  boolean fromInclusive,
                                  K toKey,
                                  boolean toInclusive) {
            if (fromKey == null || toKey == null)
                throw new NullPointerException();
            return newSubMap(fromKey, fromInclusive, toKey, toInclusive);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.346 -0400", hash_original_method = "93D3DFFDF7834E43DA249099B0B715CB", hash_generated_method = "59FA7E8BDA1E45C33FB13927E3CE41B2")
        
public SubMap<K,V> headMap(K toKey,
                                   boolean inclusive) {
            if (toKey == null)
                throw new NullPointerException();
            return newSubMap(null, false, toKey, inclusive);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.347 -0400", hash_original_method = "3B30E098BD58E382AFC336526F7A9CA0", hash_generated_method = "05D987EDD9BDEC14EE94141AA1858D74")
        
public SubMap<K,V> tailMap(K fromKey,
                                   boolean inclusive) {
            if (fromKey == null)
                throw new NullPointerException();
            return newSubMap(fromKey, inclusive, null, false);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.347 -0400", hash_original_method = "C074D3F70EBB15CB07533C654F831243", hash_generated_method = "A73A84D696BE4A23C88E01BB2DC368EF")
        
public SubMap<K,V> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.347 -0400", hash_original_method = "67DBABDA4E041D1CE45CE738612528B5", hash_generated_method = "D3080F745FB8A57CE792C98EBAB98D10")
        
public SubMap<K,V> headMap(K toKey) {
            return headMap(toKey, false);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.348 -0400", hash_original_method = "0E132DCE890F25EFC426F0C3A5C96265", hash_generated_method = "A1EBA47472D1012043BC89D746F06ABC")
        
public SubMap<K,V> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.348 -0400", hash_original_method = "17081A492B6AB984B20C35FE5DDA3797", hash_generated_method = "965241F3270DA64EF2B441F81AD7E3D8")
        
public SubMap<K,V> descendingMap() {
            return new SubMap<K,V>(m, lo, loInclusive,
                                   hi, hiInclusive, !isDescending);
        }

        /* ----------------  Relational methods -------------- */

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.348 -0400", hash_original_method = "FA55E4A4707F29DB1381D841282F9E90", hash_generated_method = "A554E1674B57BA79CDE733F73424620F")
        
public Map.Entry<K,V> ceilingEntry(K key) {
            return getNearEntry(key, GT|EQ);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.349 -0400", hash_original_method = "991EAB812B5B696B7979E224F0435700", hash_generated_method = "587CF9DCD4BB840D8A369FA70A10F1F4")
        
public K ceilingKey(K key) {
            return getNearKey(key, GT|EQ);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.349 -0400", hash_original_method = "9645C6E719DAD3ED9D8671E35C727FE0", hash_generated_method = "E94784DECBC01A4D2B2FDF00AC1EFCE5")
        
public Map.Entry<K,V> lowerEntry(K key) {
            return getNearEntry(key, LT);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.349 -0400", hash_original_method = "5ECF12DB6C4280E859325DDC487361DA", hash_generated_method = "AEF083947062B9B9DD690183FC7E3C58")
        
public K lowerKey(K key) {
            return getNearKey(key, LT);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.350 -0400", hash_original_method = "6587D1B6455DB5348527169BB1059F92", hash_generated_method = "B76468F06834AE8AD3FE6D312E32A6EC")
        
public Map.Entry<K,V> floorEntry(K key) {
            return getNearEntry(key, LT|EQ);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.350 -0400", hash_original_method = "B34D6D6844ADBCFFFA901ABFEF38D98B", hash_generated_method = "B32C5088CBE6920587B33E18908C0848")
        
public K floorKey(K key) {
            return getNearKey(key, LT|EQ);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.350 -0400", hash_original_method = "2E8E9AECE4F9AE2D363CAE2A1F56F493", hash_generated_method = "CC2F25DDD07B74F330E5C93D302CCEAC")
        
public Map.Entry<K,V> higherEntry(K key) {
            return getNearEntry(key, GT);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.351 -0400", hash_original_method = "2DFCC56EB087BDBD762842B20498A438", hash_generated_method = "E42793F3B7C34911B2FB95EB4FB4493C")
        
public K higherKey(K key) {
            return getNearKey(key, GT);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.351 -0400", hash_original_method = "017D21CF189D7D0F5D9CDD2F13312B6D", hash_generated_method = "7F589E27BB2D2898DF2AF25875D56160")
        
public K firstKey() {
            return isDescending ? highestKey() : lowestKey();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.351 -0400", hash_original_method = "1658535BB0C11FAA7F4872F4A9D6F18C", hash_generated_method = "6BA299F75B6C3DC44C38010C45AF6EDB")
        
public K lastKey() {
            return isDescending ? lowestKey() : highestKey();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.352 -0400", hash_original_method = "8FC2D1E35C03976B98EA087895C99260", hash_generated_method = "238D6F51350F38FA07D71804AB868618")
        
public Map.Entry<K,V> firstEntry() {
            return isDescending ? highestEntry() : lowestEntry();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.352 -0400", hash_original_method = "057F426260737D33082D900C1705C3CD", hash_generated_method = "ED7FBE2350350A9C0C4A08D8EC083388")
        
public Map.Entry<K,V> lastEntry() {
            return isDescending ? lowestEntry() : highestEntry();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.352 -0400", hash_original_method = "0CD2A70C1A41E282469785650C0B9DB0", hash_generated_method = "B2B919168CCD24A0BFE0BF19A2BEA672")
        
public Map.Entry<K,V> pollFirstEntry() {
            return isDescending ? removeHighest() : removeLowest();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.353 -0400", hash_original_method = "C511DFBA6387EEFEDB83FC77CB2E6C42", hash_generated_method = "C7E5A04BFD66DAF3364CE1EFE3AA9801")
        
public Map.Entry<K,V> pollLastEntry() {
            return isDescending ? removeLowest() : removeHighest();
        }

        /* ---------------- Submap Views -------------- */

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.353 -0400", hash_original_method = "6715CB4D544D768DEC674AFDC0D158D0", hash_generated_method = "C204DC4585874956812D14960741152E")
        
public NavigableSet<K> keySet() {
            KeySet<K> ks = keySetView;
            return (ks != null) ? ks : (keySetView = new KeySet<K>(this));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.353 -0400", hash_original_method = "BFC5B60E2EEB0D312F2330EE88819E25", hash_generated_method = "4364EFF551C1FA1A3AE97E4A2E145481")
        
public NavigableSet<K> navigableKeySet() {
            KeySet<K> ks = keySetView;
            return (ks != null) ? ks : (keySetView = new KeySet<K>(this));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.354 -0400", hash_original_method = "6DA81136318EE0A620F8C9887F8F6446", hash_generated_method = "3C7AE7F6EFFDBE430A5B534D88EF82AD")
        
public Collection<V> values() {
            Collection<V> vs = valuesView;
            return (vs != null) ? vs : (valuesView = new Values<V>(this));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.354 -0400", hash_original_method = "71D89CAC4B12076C6342623D2BCF9194", hash_generated_method = "9B46E189FE6826E385416B89ED1EFE49")
        
public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es = entrySetView;
            return (es != null) ? es : (entrySetView = new EntrySet<K,V>(this));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.354 -0400", hash_original_method = "2E36263FBE3C4B8B29F84A4A65158DFE", hash_generated_method = "44E87D6B7201CC2393E65C036BAEB42D")
        
public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.355 -0400", hash_original_method = "08CA57F29E4BEEC640EE736E5052F583", hash_generated_method = "08CA57F29E4BEEC640EE736E5052F583")
        
Iterator<K> keyIterator() {
            return new SubMapKeyIterator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.355 -0400", hash_original_method = "E1787E2F300D04ADBF62DA5D2A8E0A15", hash_generated_method = "E1787E2F300D04ADBF62DA5D2A8E0A15")
        
Iterator<V> valueIterator() {
            return new SubMapValueIterator();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.355 -0400", hash_original_method = "4386BE10A6C90989D97083DF25A4272D", hash_generated_method = "4386BE10A6C90989D97083DF25A4272D")
        
Iterator<Map.Entry<K,V>> entryIterator() {
            return new SubMapEntryIterator();
        }

        /**
         * Variant of main Iter class to traverse through submaps.
         */
        abstract class SubMapIter<T> implements Iterator<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.356 -0400", hash_original_field = "A61618791A3339D56E39272FB473E5C8", hash_generated_field = "A61618791A3339D56E39272FB473E5C8")

            Node<K,V> lastReturned;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.356 -0400", hash_original_field = "D1C8B20089B08F3F6EDCF099CD3F45A9", hash_generated_field = "D1C8B20089B08F3F6EDCF099CD3F45A9")

            Node<K,V> next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.356 -0400", hash_original_field = "185FAE73D6299E494AB7E80388AD47EC", hash_generated_field = "185FAE73D6299E494AB7E80388AD47EC")

            V nextValue;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.357 -0400", hash_original_method = "02832B9ADBE5E75B8B5B27FC95138873", hash_generated_method = "02832B9ADBE5E75B8B5B27FC95138873")
            
SubMapIter() {
                for (;;) {
                    next = isDescending ? hiNode() : loNode();
                    if (next == null)
                        break;
                    Object x = next.value;
                    if (x != null && x != next) {
                        if (! inBounds(next.key))
                            next = null;
                        else
                            nextValue = (V) x;
                        break;
                    }
                }
            }

            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.357 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "ACD421FE635E107B761C79834D492449")
            
public final boolean hasNext() {
                return next != null;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.358 -0400", hash_original_method = "45A53F7DBA59F0A3DD81A8F5E61E489E", hash_generated_method = "C1C93397820CB99564A25F460A77B5D6")
            
final void advance() {
                if (next == null)
                    throw new NoSuchElementException();
                lastReturned = next;
                if (isDescending)
                    descend();
                else
                    ascend();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.359 -0400", hash_original_method = "7C4C4395DA11811A6E73F0228DC9B079", hash_generated_method = "82960F0D1087E00C5B0FF58465960A00")
            
private void ascend() {
                for (;;) {
                    next = next.next;
                    if (next == null)
                        break;
                    Object x = next.value;
                    if (x != null && x != next) {
                        if (tooHigh(next.key))
                            next = null;
                        else
                            nextValue = (V) x;
                        break;
                    }
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.359 -0400", hash_original_method = "87CD83030AB058687D5E87A13E72BCD5", hash_generated_method = "8A111569E98235D8FF5BD5C2219AE64C")
            
private void descend() {
                for (;;) {
                    next = m.findNear(lastReturned.key, LT);
                    if (next == null)
                        break;
                    Object x = next.value;
                    if (x != null && x != next) {
                        if (tooLow(next.key))
                            next = null;
                        else
                            nextValue = (V) x;
                        break;
                    }
                }
            }

            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.360 -0400", hash_original_method = "D924E76AD4C0338EF5228943EA60E784", hash_generated_method = "4E637FAE081E5714E6901F67E5160003")
            
public void remove() {
                Node<K,V> l = lastReturned;
                if (l == null)
                    throw new IllegalStateException();
                m.remove(l.key);
                lastReturned = null;
            }

        }

        final class SubMapValueIterator extends SubMapIter<V> {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.361 -0400", hash_original_method = "DC4893657DB230E9949864D6AB52BE41", hash_generated_method = "C51919C60238A714A084E53419FE9821")
            
public V next() {
                V v = nextValue;
                advance();
                return v;
            }
        }

        final class SubMapKeyIterator extends SubMapIter<K> {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.362 -0400", hash_original_method = "BB69EE7005851DCF2320672553D16AC3", hash_generated_method = "815DBC7F50E7E17EB5F37486E0B6D5D9")
            
public K next() {
                Node<K,V> n = next;
                advance();
                return n.key;
            }
        }

        final class SubMapEntryIterator extends SubMapIter<Map.Entry<K,V>> {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.363 -0400", hash_original_method = "CF862345FA84B63897E1591A1341E3A2", hash_generated_method = "C790AC6DE49939DFD7E09E32550670D0")
            
public Map.Entry<K,V> next() {
                Node<K,V> n = next;
                V v = nextValue;
                advance();
                return new AbstractMap.SimpleImmutableEntry<K,V>(n.key, v);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.303 -0400", hash_original_method = "009F631392C1368741DC1D17E1864108", hash_generated_method = "009F631392C1368741DC1D17E1864108")
    
Iterator<V> valueIterator() {
        return new ValueIterator();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:21.303 -0400", hash_original_method = "47D247695506BA5C155EBD11BC0A6D15", hash_generated_method = "47D247695506BA5C155EBD11BC0A6D15")
    
Iterator<Map.Entry<K,V>> entryIterator() {
        return new EntryIterator();
    }
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ConcurrentSkipListMap.class;
            headOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("head"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
