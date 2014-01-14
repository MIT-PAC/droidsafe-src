package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* ---------------- Small Utilities -------------- */

    /**
     * Applies a supplemental hash function to a given hashCode, which
     * defends against poor quality hash functions.  This is critical
     * because ConcurrentHashMap uses power-of-two length hash tables,
     * that otherwise encounter collisions for hashCodes that do not
     * differ in lower or upper bits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.175 -0500", hash_original_method = "AE4C70F7AA3BE069BFD471F033424C08", hash_generated_method = "FA3E9EFE37ED47F9FCA29E09A1225220")
    
private static int hash(int h) {
        // Spread bits to regularize both segment and index locations,
        // using variant of single-word Wang/Jenkins hash.
        h += (h <<  15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h <<   3);
        h ^= (h >>>  6);
        h += (h <<   2) + (h << 14);
        return h ^ (h >>> 16);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.143 -0500", hash_original_field = "09260ACB4C2FB340781AA3ADD06EF1A8", hash_generated_field = "CFEA0CB484FBA67AE2EE2BC289FD3823")

    private static final long serialVersionUID = 7249069246763182397L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.145 -0500", hash_original_field = "5C6358F3EE542D2E9840880E94213970", hash_generated_field = "73D731B147597FD5BDB2BB8E9AD216B8")

    /* ---------------- Constants -------------- */

    /**
     * The default initial capacity for this table,
     * used when not otherwise specified in a constructor.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.149 -0500", hash_original_field = "C1C76A87F655C174D217EA23B00CC6D8", hash_generated_field = "A8CC9CBDCFEE884AAACD2650D6276B04")

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.151 -0500", hash_original_field = "88A8F54BFAA7133EAC029A87A2C20221", hash_generated_field = "6CEFE70232E37AD1C46346373D85BAC4")

    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.153 -0500", hash_original_field = "8450B9285BE1BB97BF823A8DA56CC45D", hash_generated_field = "F5FAB930A5B7C8AC42E4718B6294507D")

    static final int MAXIMUM_CAPACITY = 1 << 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.156 -0500", hash_original_field = "2363CBFE8CC4D81C19768ABA9172DEF4", hash_generated_field = "7552200CFB9EB51127B30554F45C2149")

    static final int MAX_SEGMENTS = 1 << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.158 -0500", hash_original_field = "2AB727D902A76BDD93D9849A34A614E9", hash_generated_field = "7716F2D4D0784E4AF38900D3F3CFF51F")

    /**
     * Number of unsynchronized retries in size and containsValue
     * methods before resorting to locking. This is used to avoid
     * unbounded retries if tables undergo continuous modification
     * which would make it impossible to obtain an accurate result.
     */
    static final int RETRIES_BEFORE_LOCK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.161 -0500", hash_original_field = "4BE7BE92627D08015B3B3DAF23AD6BAD", hash_generated_field = "FB2EEE3C1CA932EB5B8A4D2B2897701A")

    /**
     * Mask value for indexing into segments. The upper bits of a
     * key's hash code are used to choose the segment.
     */
     int segmentMask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.163 -0500", hash_original_field = "306EF00C73243987FA23D1582323C779", hash_generated_field = "306EF00C73243987FA23D1582323C779")

     int segmentShift;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.166 -0500", hash_original_field = "8FCA8AAE37A6D97176077745C90AB57A", hash_generated_field = "8FCA8AAE37A6D97176077745C90AB57A")

     Segment<K,V>[] segments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.168 -0500", hash_original_field = "8E2B51CCF89ADF7243D25312F0ABCDAC", hash_generated_field = "B015B4740FB481B602A7C5EA08044E34")

    transient Set<K> keySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.170 -0500", hash_original_field = "679197F35762BD01568998E78245F4E3", hash_generated_field = "8070B936D9AF3972F9E8198F31643848")

    transient Set<Map.Entry<K,V>> entrySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.172 -0500", hash_original_field = "66FC55BC3FE3DFC76C7BE5EAF459710C", hash_generated_field = "1963670AE696FF62CC56DF446CAA129C")

    transient Collection<V> values;

    /* ---------------- Public operations -------------- */

    /**
     * Creates a new, empty map with the specified initial
     * capacity, load factor and concurrency level.
     *
     * @param initialCapacity the initial capacity. The implementation
     * performs internal sizing to accommodate this many elements.
     * @param loadFactor  the load factor threshold, used to control resizing.
     * Resizing may be performed when the average number of elements per
     * bin exceeds this threshold.
     * @param concurrencyLevel the estimated number of concurrently
     * updating threads. The implementation performs internal sizing
     * to try to accommodate this many threads.
     * @throws IllegalArgumentException if the initial capacity is
     * negative or the load factor or concurrencyLevel are
     * nonpositive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.258 -0500", hash_original_method = "E1CECF835D0BD6DA840C10527C435227", hash_generated_method = "8BC6D71D6B7864BBA3033121A0297448")
    
public ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
        if (!(loadFactor > 0) || initialCapacity < 0 || concurrencyLevel <= 0)
            throw new IllegalArgumentException();

        if (concurrencyLevel > MAX_SEGMENTS)
            concurrencyLevel = MAX_SEGMENTS;

        // Find power-of-two sizes best matching arguments
        int sshift = 0;
        int ssize = 1;
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }
        segmentShift = 32 - sshift;
        segmentMask = ssize - 1;
        this.segments = Segment.newArray(ssize);

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        int c = initialCapacity / ssize;
        if (c * ssize < initialCapacity)
            ++c;
        int cap = 1;
        while (cap < c)
            cap <<= 1;

        for (int i = 0; i < this.segments.length; ++i)
            this.segments[i] = new Segment<K,V>(cap, loadFactor);
    }

    /**
     * Creates a new, empty map with the specified initial capacity
     * and load factor and with the default concurrencyLevel (16).
     *
     * @param initialCapacity The implementation performs internal
     * sizing to accommodate this many elements.
     * @param loadFactor  the load factor threshold, used to control resizing.
     * Resizing may be performed when the average number of elements per
     * bin exceeds this threshold.
     * @throws IllegalArgumentException if the initial capacity of
     * elements is negative or the load factor is nonpositive
     *
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.260 -0500", hash_original_method = "1B0A2C6B75A6C9CD77B06A2BA6F95389", hash_generated_method = "BE20E5B7DA6B7B84DF20C85A63BAC432")
    
public ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
    }

    /**
     * Creates a new, empty map with the specified initial capacity,
     * and with default load factor (0.75) and concurrencyLevel (16).
     *
     * @param initialCapacity the initial capacity. The implementation
     * performs internal sizing to accommodate this many elements.
     * @throws IllegalArgumentException if the initial capacity of
     * elements is negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.264 -0500", hash_original_method = "FC082FCC77B50E96B6B6DB58BAB97957", hash_generated_method = "1868059E578F334541C694CC2C8E1356")
    
public ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
    }

    /**
     * Creates a new, empty map with a default initial capacity (16),
     * load factor (0.75) and concurrencyLevel (16).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.266 -0500", hash_original_method = "DFADDF9198F2268E7EB2B4F062BE54B9", hash_generated_method = "D67688F0DFF5DC08C72EB2B9294A3593")
    
public ConcurrentHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
    }

    /**
     * Creates a new map with the same mappings as the given map.
     * The map is created with a capacity of 1.5 times the number
     * of mappings in the given map or 16 (whichever is greater),
     * and a default load factor (0.75) and concurrencyLevel (16).
     *
     * @param m the map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.269 -0500", hash_original_method = "485F32D8EAC40E4F4B6CB1DCBDB98D35", hash_generated_method = "B3E15975F95E46A025B1FE5211A37494")
    
public ConcurrentHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                      DEFAULT_INITIAL_CAPACITY),
             DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
        putAll(m);
    }

    /**
     * Returns the segment that should be used for key with given hash
     * @param hash the hash code for the key
     * @return the segment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.177 -0500", hash_original_method = "9480E4BE528687F57BD0A5E0057A4838", hash_generated_method = "F54C80ECC216888F4BACE2C30A5CB57E")
    
final Segment<K,V> segmentFor(int hash) {
        return segments[(hash >>> segmentShift) & segmentMask];
    }

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.272 -0500", hash_original_method = "1D5F6259D73E7678D3D06BFBE271A26B", hash_generated_method = "977930B97BBB4E4BBE639EFAC3F7FF54")
    
public boolean isEmpty() {
        final Segment<K,V>[] segments = this.segments;
        /*
         * We keep track of per-segment modCounts to avoid ABA
         * problems in which an element in one segment was added and
         * in another removed during traversal, in which case the
         * table was never actually empty at any point. Note the
         * similar use of modCounts in the size() and containsValue()
         * methods, which are the only other methods also susceptible
         * to ABA problems.
         */
        int[] mc = new int[segments.length];
        int mcsum = 0;
        for (int i = 0; i < segments.length; ++i) {
            if (segments[i].count != 0)
                return false;
            else
                mcsum += mc[i] = segments[i].modCount;
        }
        // If mcsum happens to be zero, then we know we got a snapshot
        // before any modifications at all were made.  This is
        // probably common enough to bother tracking.
        if (mcsum != 0) {
            for (int i = 0; i < segments.length; ++i) {
                if (segments[i].count != 0 ||
                    mc[i] != segments[i].modCount)
                    return false;
            }
        }
        return true;
    }

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of key-value mappings in this map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.276 -0500", hash_original_method = "BA4A00EBCDE2550C0DA253B4E73A18FB", hash_generated_method = "38B795634F770FA47A02F27708EA88F1")
    
public int size() {
        final Segment<K,V>[] segments = this.segments;
        long sum = 0;
        long check = 0;
        int[] mc = new int[segments.length];
        // Try a few times to get accurate count. On failure due to
        // continuous async changes in table, resort to locking.
        for (int k = 0; k < RETRIES_BEFORE_LOCK; ++k) {
            check = 0;
            sum = 0;
            int mcsum = 0;
            for (int i = 0; i < segments.length; ++i) {
                sum += segments[i].count;
                mcsum += mc[i] = segments[i].modCount;
            }
            if (mcsum != 0) {
                for (int i = 0; i < segments.length; ++i) {
                    check += segments[i].count;
                    if (mc[i] != segments[i].modCount) {
                        check = -1; // force retry
                        break;
                    }
                }
            }
            if (check == sum)
                break;
        }
        if (check != sum) { // Resort to locking all segments
            sum = 0;
            for (int i = 0; i < segments.length; ++i)
                segments[i].lock();
            for (int i = 0; i < segments.length; ++i)
                sum += segments[i].count;
            for (int i = 0; i < segments.length; ++i)
                segments[i].unlock();
        }
        if (sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)sum;
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code key.equals(k)},
     * then this method returns {@code v}; otherwise it returns
     * {@code null}.  (There can be at most one such mapping.)
     *
     * @throws NullPointerException if the specified key is null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.278 -0500", hash_original_method = "332CB84E85FBD8A2CB62BBB184B280CA", hash_generated_method = "7EE66C4B254D275ACADB7E36512FEADD")
    
public V get(Object key) {
        int hash = hash(key.hashCode());
        return segmentFor(hash).get(key, hash);
    }

    /**
     * Tests if the specified object is a key in this table.
     *
     * @param  key   possible key
     * @return <tt>true</tt> if and only if the specified object
     *         is a key in this table, as determined by the
     *         <tt>equals</tt> method; <tt>false</tt> otherwise.
     * @throws NullPointerException if the specified key is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.281 -0500", hash_original_method = "6145F82DE390788BB7B29DCBC031D263", hash_generated_method = "E4E97F4C3F215E65E2C57219B30401EA")
    
public boolean containsKey(Object key) {
        int hash = hash(key.hashCode());
        return segmentFor(hash).containsKey(key, hash);
    }

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the
     * specified value. Note: This method requires a full internal
     * traversal of the hash table, and so is much slower than
     * method <tt>containsKey</tt>.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     *         specified value
     * @throws NullPointerException if the specified value is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.284 -0500", hash_original_method = "F1AF23545DF8C9E4F21CC9D8D7EE161E", hash_generated_method = "5E9D8CBCBFA5C7025C23AC3E711CF9B2")
    
public boolean containsValue(Object value) {
        if (value == null)
            throw new NullPointerException();

        // See explanation of modCount use above

        final Segment<K,V>[] segments = this.segments;
        int[] mc = new int[segments.length];

        // Try a few times without locking
        for (int k = 0; k < RETRIES_BEFORE_LOCK; ++k) {
            int sum = 0;
            int mcsum = 0;
            for (int i = 0; i < segments.length; ++i) {
                int c = segments[i].count;
                mcsum += mc[i] = segments[i].modCount;
                if (segments[i].containsValue(value))
                    return true;
            }
            boolean cleanSweep = true;
            if (mcsum != 0) {
                for (int i = 0; i < segments.length; ++i) {
                    int c = segments[i].count;
                    if (mc[i] != segments[i].modCount) {
                        cleanSweep = false;
                        break;
                    }
                }
            }
            if (cleanSweep)
                return false;
        }
        // Resort to locking all segments
        for (int i = 0; i < segments.length; ++i)
            segments[i].lock();
        boolean found = false;
        try {
            for (int i = 0; i < segments.length; ++i) {
                if (segments[i].containsValue(value)) {
                    found = true;
                    break;
                }
            }
        } finally {
            for (int i = 0; i < segments.length; ++i)
                segments[i].unlock();
        }
        return found;
    }

    /**
     * Legacy method testing if some key maps into the specified value
     * in this table.  This method is identical in functionality to
     * {@link #containsValue}, and exists solely to ensure
     * full compatibility with class {@link java.util.Hashtable},
     * which supported this method prior to introduction of the
     * Java Collections framework.

     * @param  value a value to search for
     * @return <tt>true</tt> if and only if some key maps to the
     *         <tt>value</tt> argument in this table as
     *         determined by the <tt>equals</tt> method;
     *         <tt>false</tt> otherwise
     * @throws NullPointerException if the specified value is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.287 -0500", hash_original_method = "E610C30BCCE300EF5870BDD2E1DFFA8F", hash_generated_method = "BFEC0E9F88C5F9ED7D2C285E26D3D3C5")
    
public boolean contains(Object value) {
        return containsValue(value);
    }

    /**
     * Maps the specified key to the specified value in this table.
     * Neither the key nor the value can be null.
     *
     * <p> The value can be retrieved by calling the <tt>get</tt> method
     * with a key that is equal to the original key.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>
     * @throws NullPointerException if the specified key or value is null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.289 -0500", hash_original_method = "7B5FF6221D53537744EF141B1F8CB9FD", hash_generated_method = "7BFA11D2C887423F4364FA64BC7ED080")
    
public V put(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        int hash = hash(key.hashCode());
        return segmentFor(hash).put(key, hash, value, false);
    }

    /**
     * {@inheritDoc}
     *
     * @return the previous value associated with the specified key,
     *         or <tt>null</tt> if there was no mapping for the key
     * @throws NullPointerException if the specified key or value is null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.291 -0500", hash_original_method = "667464B5C7B8632F9930C4BABEB48EA8", hash_generated_method = "D7D1028C77FC31ED718B783FE3D514BB")
    
public V putIfAbsent(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        int hash = hash(key.hashCode());
        return segmentFor(hash).put(key, hash, value, true);
    }

    /**
     * Copies all of the mappings from the specified map to this one.
     * These mappings replace any mappings that this map had for any of the
     * keys currently in the specified map.
     *
     * @param m mappings to be stored in this map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.294 -0500", hash_original_method = "B9175F57BE6F5AB8BBC535010119C8D9", hash_generated_method = "0C389A662EDE8299C893E91991E30623")
    
public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }

    /**
     * Removes the key (and its corresponding value) from this map.
     * This method does nothing if the key is not in the map.
     *
     * @param  key the key that needs to be removed
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>
     * @throws NullPointerException if the specified key is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.296 -0500", hash_original_method = "337505C9EECB4FFE48F33491B52A72CA", hash_generated_method = "EB3E9FA2C41C0DB7BE83722D8BD7953C")
    
public V remove(Object key) {
        int hash = hash(key.hashCode());
        return segmentFor(hash).remove(key, hash, null);
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException if the specified key is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.305 -0500", hash_original_method = "B30F0ED29C44EDE9B7A1F9EA4182F243", hash_generated_method = "4E6792FF7951BDBE7AD43F940580B55C")
    
public boolean remove(Object key, Object value) {
        int hash = hash(key.hashCode());
        if (value == null)
            return false;
        return segmentFor(hash).remove(key, hash, value) != null;
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException if any of the arguments are null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.308 -0500", hash_original_method = "FFBE8ED355379D3641A692556CD55FD9", hash_generated_method = "B62D798D13492263351BEA05BD69D7D6")
    
public boolean replace(K key, V oldValue, V newValue) {
        if (oldValue == null || newValue == null)
            throw new NullPointerException();
        int hash = hash(key.hashCode());
        return segmentFor(hash).replace(key, hash, oldValue, newValue);
    }

    /**
     * {@inheritDoc}
     *
     * @return the previous value associated with the specified key,
     *         or <tt>null</tt> if there was no mapping for the key
     * @throws NullPointerException if the specified key or value is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.311 -0500", hash_original_method = "0AA66A0CD7ECE54F0D1BA81883147959", hash_generated_method = "0F60AD396ACE404137B8BF3E5A11AFC3")
    
public V replace(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        int hash = hash(key.hashCode());
        return segmentFor(hash).replace(key, hash, value);
    }

    /**
     * Removes all of the mappings from this map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.313 -0500", hash_original_method = "F4B890B3C1A244A1C39416FB7B7BF8FF", hash_generated_method = "319DD8CC07E19C06E96272BE0679E8DF")
    
public void clear() {
        for (int i = 0; i < segments.length; ++i)
            segments[i].clear();
    }
    
    static final class HashEntry<K,V> {
        
        @SuppressWarnings("unchecked")
        static final <K,V> HashEntry<K,V>[] newArray(int i) {
            return new HashEntry[i];
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.181 -0500", hash_original_field = "F780C5984CF24E477CB9559E91475987", hash_generated_field = "F780C5984CF24E477CB9559E91475987")

         K key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.183 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

         int hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.186 -0500", hash_original_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08", hash_generated_field = "D9A5701E394E22D841141BE91A2D9F15")

        volatile V value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.188 -0500", hash_original_field = "AC47A60384D70A26B3EF9024FD965BF5", hash_generated_field = "AC47A60384D70A26B3EF9024FD965BF5")

         HashEntry<K,V> next;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.191 -0500", hash_original_method = "89FFAB6F57FFB83251DFC8FAF8476851", hash_generated_method = "89FFAB6F57FFB83251DFC8FAF8476851")
        
HashEntry(K key, int hash, HashEntry<K,V> next, V value) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.value = value;
        }
        
    }
    
    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        
        @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.199 -0500", hash_original_field = "59EB42CA6A147AD05286E3F96228C4D7", hash_generated_field = "63C62A82A3FF7049D8720153B66FBF4F")

        private static final long serialVersionUID = 2249069246763182397L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.201 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "A5A8CDA7B0601BDA04B06999B66113E1")

        transient volatile int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.204 -0500", hash_original_field = "52F3DED7388D6DA42BC9C902075440B5", hash_generated_field = "66B0BB3B51ED8DFDAEFDC2833CA7C4AB")

        transient int modCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.207 -0500", hash_original_field = "B212DD967AF5750AEF1DDA2E6D14352F", hash_generated_field = "EBFF2C10A18F7B4BDFBFF5FE82B9E916")

        transient int threshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.209 -0500", hash_original_field = "08330E072EF7BB33A6A7BE6D1E46617C", hash_generated_field = "7AFDE33CE4930D8257094745BD6A1CD4")

        transient volatile HashEntry<K,V>[] table;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.212 -0500", hash_original_field = "9AE85CE37BA4DE356F76E49D73EDA32D", hash_generated_field = "9AE85CE37BA4DE356F76E49D73EDA32D")

         float loadFactor;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.215 -0500", hash_original_method = "467240A23868E01B6F6E31DCEE5330A3", hash_generated_method = "467240A23868E01B6F6E31DCEE5330A3")
        
Segment(int initialCapacity, float lf) {
            loadFactor = lf;
            setTable(HashEntry.<K,V>newArray(initialCapacity));
        }

        /**
         * Sets table to new HashEntry array.
         * Call only while holding lock or in constructor.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.219 -0500", hash_original_method = "76FBB7D49FE13DE65CD87FF1D7913D53", hash_generated_method = "76FBB7D49FE13DE65CD87FF1D7913D53")
        
void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
        }

        /**
         * Returns properly casted first entry of bin for given hash.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.221 -0500", hash_original_method = "526D0582321A198EF4385AC6C7D29654", hash_generated_method = "526D0582321A198EF4385AC6C7D29654")
        
HashEntry<K,V> getFirst(int hash) {
            HashEntry<K,V>[] tab = table;
            return tab[hash & (tab.length - 1)];
        }

        /**
         * Reads value field of an entry under lock. Called if value
         * field ever appears to be null. This is possible only if a
         * compiler happens to reorder a HashEntry initialization with
         * its table assignment, which is legal under memory model
         * but is not known to ever occur.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.224 -0500", hash_original_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54", hash_generated_method = "6C9E8EADE7BF0CF7C06CF8A72D599D54")
        
V readValueUnderLock(HashEntry<K,V> e) {
            lock();
            try {
                return e.value;
            } finally {
                unlock();
            }
        }

        /* Specialized implementations of map methods */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.227 -0500", hash_original_method = "1AC5B4CC2690982021F35FD4CB4FB319", hash_generated_method = "009736D67A6DE43462A99E9D12B51250")
        
V get(Object key, int hash) {
            if (count != 0) { // read-volatile
                HashEntry<K,V> e = getFirst(hash);
                while (e != null) {
                    if (e.hash == hash && key.equals(e.key)) {
                        V v = e.value;
                        if (v != null)
                            return v;
                        return readValueUnderLock(e); // recheck
                    }
                    e = e.next;
                }
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.230 -0500", hash_original_method = "4906CD88672F5095094E2A23826E0F83", hash_generated_method = "448C81B15B5938425170C5AB4EADCE8D")
        
boolean containsKey(Object key, int hash) {
            if (count != 0) { // read-volatile
                HashEntry<K,V> e = getFirst(hash);
                while (e != null) {
                    if (e.hash == hash && key.equals(e.key))
                        return true;
                    e = e.next;
                }
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.232 -0500", hash_original_method = "4B02A5A0C6C760AB5CD92802AE9AC755", hash_generated_method = "DAA45DE407753C4B1E1A25A121943FB0")
        
boolean containsValue(Object value) {
            if (count != 0) { // read-volatile
                HashEntry<K,V>[] tab = table;
                int len = tab.length;
                for (int i = 0 ; i < len; i++) {
                    for (HashEntry<K,V> e = tab[i]; e != null; e = e.next) {
                        V v = e.value;
                        if (v == null) // recheck
                            v = readValueUnderLock(e);
                        if (value.equals(v))
                            return true;
                    }
                }
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.236 -0500", hash_original_method = "B03D3F6036D4D187AC672F9D98953439", hash_generated_method = "B03D3F6036D4D187AC672F9D98953439")
        
boolean replace(K key, int hash, V oldValue, V newValue) {
            lock();
            try {
                HashEntry<K,V> e = getFirst(hash);
                while (e != null && (e.hash != hash || !key.equals(e.key)))
                    e = e.next;

                boolean replaced = false;
                if (e != null && oldValue.equals(e.value)) {
                    replaced = true;
                    e.value = newValue;
                }
                return replaced;
            } finally {
                unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.238 -0500", hash_original_method = "496F1B463B31D22372CDAB52F4D749A3", hash_generated_method = "496F1B463B31D22372CDAB52F4D749A3")
        
V replace(K key, int hash, V newValue) {
            lock();
            try {
                HashEntry<K,V> e = getFirst(hash);
                while (e != null && (e.hash != hash || !key.equals(e.key)))
                    e = e.next;

                V oldValue = null;
                if (e != null) {
                    oldValue = e.value;
                    e.value = newValue;
                }
                return oldValue;
            } finally {
                unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.241 -0500", hash_original_method = "F92903F43B391F8F1B397027DA8E7AA9", hash_generated_method = "252CB8C489CE3EB2BCC28E983AD65EE7")
        
V put(K key, int hash, V value, boolean onlyIfAbsent) {
            lock();
            try {
                int c = count;
                if (c++ > threshold) // ensure capacity
                    rehash();
                HashEntry<K,V>[] tab = table;
                int index = hash & (tab.length - 1);
                HashEntry<K,V> first = tab[index];
                HashEntry<K,V> e = first;
                while (e != null && (e.hash != hash || !key.equals(e.key)))
                    e = e.next;

                V oldValue;
                if (e != null) {
                    oldValue = e.value;
                    if (!onlyIfAbsent)
                        e.value = value;
                }
                else {
                    oldValue = null;
                    ++modCount;
                    tab[index] = new HashEntry<K,V>(key, hash, first, value);
                    count = c; // write-volatile
                }
                return oldValue;
            } finally {
                unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.244 -0500", hash_original_method = "7AA7A225DF7E6D5CA86650AFCB7B431B", hash_generated_method = "5F9B18EFA3836677E9FA39415DE7CBB9")
        
void rehash() {
            HashEntry<K,V>[] oldTable = table;
            int oldCapacity = oldTable.length;
            if (oldCapacity >= MAXIMUM_CAPACITY)
                return;

            /*
             * Reclassify nodes in each list to new Map.  Because we are
             * using power-of-two expansion, the elements from each bin
             * must either stay at same index, or move with a power of two
             * offset. We eliminate unnecessary node creation by catching
             * cases where old nodes can be reused because their next
             * fields won't change. Statistically, at the default
             * threshold, only about one-sixth of them need cloning when
             * a table doubles. The nodes they replace will be garbage
             * collectable as soon as they are no longer referenced by any
             * reader thread that may be in the midst of traversing table
             * right now.
             */

            HashEntry<K,V>[] newTable = HashEntry.newArray(oldCapacity<<1);
            threshold = (int)(newTable.length * loadFactor);
            int sizeMask = newTable.length - 1;
            for (int i = 0; i < oldCapacity ; i++) {
                // We need to guarantee that any existing reads of old Map can
                //  proceed. So we cannot yet null out each bin.
                HashEntry<K,V> e = oldTable[i];

                if (e != null) {
                    HashEntry<K,V> next = e.next;
                    int idx = e.hash & sizeMask;

                    //  Single node on list
                    if (next == null)
                        newTable[idx] = e;

                    else {
                        // Reuse trailing consecutive sequence at same slot
                        HashEntry<K,V> lastRun = e;
                        int lastIdx = idx;
                        for (HashEntry<K,V> last = next;
                             last != null;
                             last = last.next) {
                            int k = last.hash & sizeMask;
                            if (k != lastIdx) {
                                lastIdx = k;
                                lastRun = last;
                            }
                        }
                        newTable[lastIdx] = lastRun;

                        // Clone all remaining nodes
                        for (HashEntry<K,V> p = e; p != lastRun; p = p.next) {
                            int k = p.hash & sizeMask;
                            HashEntry<K,V> n = newTable[k];
                            newTable[k] = new HashEntry<K,V>(p.key, p.hash,
                                                             n, p.value);
                        }
                    }
                }
            }
            table = newTable;
        }

        /**
         * Remove; match on key only if value null, else match both.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.248 -0500", hash_original_method = "A22DE89D38A395B57956004D412DD3F5", hash_generated_method = "7A3E52A0FDBC31308A749176B7BE6FB7")
        
V remove(Object key, int hash, Object value) {
            lock();
            try {
                int c = count - 1;
                HashEntry<K,V>[] tab = table;
                int index = hash & (tab.length - 1);
                HashEntry<K,V> first = tab[index];
                HashEntry<K,V> e = first;
                while (e != null && (e.hash != hash || !key.equals(e.key)))
                    e = e.next;

                V oldValue = null;
                if (e != null) {
                    V v = e.value;
                    if (value == null || value.equals(v)) {
                        oldValue = v;
                        // All entries following removed node can stay
                        // in list, but all preceding ones need to be
                        // cloned.
                        ++modCount;
                        HashEntry<K,V> newFirst = e.next;
                        for (HashEntry<K,V> p = first; p != e; p = p.next)
                            newFirst = new HashEntry<K,V>(p.key, p.hash,
                                                          newFirst, p.value);
                        tab[index] = newFirst;
                        count = c; // write-volatile
                    }
                }
                return oldValue;
            } finally {
                unlock();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.250 -0500", hash_original_method = "20609B8FF53EC43AEB5A4460B52EBDFF", hash_generated_method = "3FD5E6060FADB3B7598987FF57C337C9")
        
void clear() {
            if (count != 0) {
                lock();
                try {
                    HashEntry<K,V>[] tab = table;
                    for (int i = 0; i < tab.length ; i++)
                        tab[i] = null;
                    ++modCount;
                    count = 0; // write-volatile
                } finally {
                    unlock();
                }
            }
        }
    }
    
    abstract class HashIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.328 -0500", hash_original_field = "6D9B0937081A44F32DBD7158CFD76C24", hash_generated_field = "6D9B0937081A44F32DBD7158CFD76C24")

        int nextSegmentIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.331 -0500", hash_original_field = "2A2A99ACC13355EBDE9E414F85DC6404", hash_generated_field = "2A2A99ACC13355EBDE9E414F85DC6404")

        int nextTableIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.333 -0500", hash_original_field = "0851F1AD358B7E0A6DDF18DC99A51E84", hash_generated_field = "0851F1AD358B7E0A6DDF18DC99A51E84")

        HashEntry<K,V>[] currentTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.335 -0500", hash_original_field = "34F1B1A1DBD9F7012195EE8A5509C745", hash_generated_field = "34F1B1A1DBD9F7012195EE8A5509C745")

        HashEntry<K, V> nextEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.337 -0500", hash_original_field = "EF55F7F73AA7A34DDB20CE140C1B2DB7", hash_generated_field = "EF55F7F73AA7A34DDB20CE140C1B2DB7")

        HashEntry<K, V> lastReturned;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.339 -0500", hash_original_method = "1331DC8249C406CC83024534A57FEFEB", hash_generated_method = "1331DC8249C406CC83024534A57FEFEB")
        
HashIterator() {
            nextSegmentIndex = segments.length - 1;
            nextTableIndex = -1;
            advance();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.342 -0500", hash_original_method = "00AF58B06A8865C0E6725656CE1DF6CF", hash_generated_method = "0FBD33F84C00D7A0EEE928122149D189")
        
public boolean hasMoreElements() { return hasNext(); }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.345 -0500", hash_original_method = "A06EA4B51D378F01CE00F7FB99A616EF", hash_generated_method = "B1A8D33565C96B09834DCED10AC5DEAB")
        
final void advance() {
            if (nextEntry != null && (nextEntry = nextEntry.next) != null)
                return;

            while (nextTableIndex >= 0) {
                if ( (nextEntry = currentTable[nextTableIndex--]) != null)
                    return;
            }

            while (nextSegmentIndex >= 0) {
                Segment<K,V> seg = segments[nextSegmentIndex--];
                if (seg.count != 0) {
                    currentTable = seg.table;
                    for (int j = currentTable.length - 1; j >= 0; --j) {
                        if ( (nextEntry = currentTable[j]) != null) {
                            nextTableIndex = j - 1;
                            return;
                        }
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.348 -0500", hash_original_method = "F0F1A7352709A4A442C7E6635A47CE9D", hash_generated_method = "939A74F092F379608CA61048568D1336")
        
public boolean hasNext() { return nextEntry != null; }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.350 -0500", hash_original_method = "DB7CF742BB593212DEE9E7DE200FEED8", hash_generated_method = "DB7CF742BB593212DEE9E7DE200FEED8")
        
HashEntry<K,V> nextEntry() {
            if (nextEntry == null)
                throw new NoSuchElementException();
            lastReturned = nextEntry;
            advance();
            return lastReturned;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.353 -0500", hash_original_method = "EB8010C2D5EA80D446C3485BFC85793F", hash_generated_method = "953125EFA17C988EC50B1E7778F2EB20")
        
public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            ConcurrentHashMap.this.remove(lastReturned.key);
            lastReturned = null;
        }
        
    }
    
    final class KeyIterator extends HashIterator implements Iterator<K>, Enumeration<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.359 -0500", hash_original_method = "AC02B860B54618170BE24E50FF82F167", hash_generated_method = "5CE69281687197D974EFA494331617C2")
        
public K next()        { return super.nextEntry().key; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.361 -0500", hash_original_method = "1473F8B0EF10582FE9B24F9D164CBEAD", hash_generated_method = "7817011C4BB28669D0A37EBAAFD7F6F4")
        
public K nextElement() { return super.nextEntry().key; }
        
    }
    
    final class ValueIterator extends HashIterator implements Iterator<V>, Enumeration<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.501 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.366 -0500", hash_original_method = "282B954004CE321F97FD15862590F160", hash_generated_method = "D966FC58251295E5B681672FC4C7796B")
        
public V next()        { return super.nextEntry().value; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.368 -0500", hash_original_method = "95D48303D225ADC424CB718F2FA08908", hash_generated_method = "8ACA7F961BC7A1ADC3E0C4C639563A1F")
        
public V nextElement() { return super.nextEntry().value; }
        
    }
    
    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K,V> {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.373 -0500", hash_original_method = "A56113014EC205E193BCD1C4F8B24855", hash_generated_method = "A56113014EC205E193BCD1C4F8B24855")
        
WriteThroughEntry(K k, V v) {
            super(k,v);
        }

        /**
         * Set our entry's value and write through to the map. The
         * value to return is somewhat arbitrary here. Since a
         * WriteThroughEntry does not necessarily track asynchronous
         * changes, the most recent "previous" value could be
         * different from what we return (or could even have been
         * removed in which case the put will re-establish). We do not
         * and cannot guarantee more.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.376 -0500", hash_original_method = "38F302BB69197C5906EE6F553583F6F9", hash_generated_method = "00CFA85539CBE187D0B73C47ABC5E9F3")
        
public V setValue(V value) {
            if (value == null) throw new NullPointerException();
            V v = super.setValue(value);
            ConcurrentHashMap.this.put(getKey(), value);
            return v;
        }
        
    }
    
    final class EntryIterator extends HashIterator implements Iterator<Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.381 -0500", hash_original_method = "DA1DC8695C9406305A6247D7AF5617DE", hash_generated_method = "D5A9F0B3135B4DCBD24EA27C354955E0")
        
public Map.Entry<K,V> next() {
            HashEntry<K,V> e = super.nextEntry();
            return new WriteThroughEntry(e.key, e.value);
        }
        
    }
    
    final class KeySet extends AbstractSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.502 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.386 -0500", hash_original_method = "29CBC31BB957230FC921EA16C45EAF59", hash_generated_method = "61F74EA37A05E8D255712FAA4565C230")
        
public Iterator<K> iterator() {
            return new KeyIterator();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.388 -0500", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "90E9C2DF329E4562BAFE113BBE53FC84")
        
public int size() {
            return ConcurrentHashMap.this.size();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.392 -0500", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "D0C498395B567F9E0AC1C003E0D96349")
        
public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.395 -0500", hash_original_method = "37248D467FF06BE0B2F5DDC1489510DF", hash_generated_method = "B25E9D2DC769AF5844BC2035A46F9BB4")
        
public boolean contains(Object o) {
            return ConcurrentHashMap.this.containsKey(o);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.397 -0500", hash_original_method = "5AA31A160A27D834D20E2EBCA8B4999F", hash_generated_method = "9E87AC0396E0C02764446ADECBECAE14")
        
public boolean remove(Object o) {
            return ConcurrentHashMap.this.remove(o) != null;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.400 -0500", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "01EC209366AEF3AEDA030D10B50125F3")
        
public void clear() {
            ConcurrentHashMap.this.clear();
        }
        
    }
    
    final class Values extends AbstractCollection<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "8414E1987B9E45F65340921EF84D9A89", hash_generated_method = "8414E1987B9E45F65340921EF84D9A89")
        public Values ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.405 -0500", hash_original_method = "3C7262C80A3C469695720BFA46AA113C", hash_generated_method = "0A1EC37B3F6C24218487D3A0F0D4F696")
        
public Iterator<V> iterator() {
            return new ValueIterator();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.407 -0500", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "90E9C2DF329E4562BAFE113BBE53FC84")
        
public int size() {
            return ConcurrentHashMap.this.size();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.410 -0500", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "D0C498395B567F9E0AC1C003E0D96349")
        
public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.412 -0500", hash_original_method = "6F20D95CF6074119AB0347E3FAAE80A2", hash_generated_method = "1B4240192F6271412D6DDBF2443A864D")
        
public boolean contains(Object o) {
            return ConcurrentHashMap.this.containsValue(o);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.415 -0500", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "01EC209366AEF3AEDA030D10B50125F3")
        
public void clear() {
            ConcurrentHashMap.this.clear();
        }
        
    }
    
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.503 -0400", hash_original_method = "AA90B2AD56C6E037D76F6D8ACC9327A5", hash_generated_method = "AA90B2AD56C6E037D76F6D8ACC9327A5")
        public EntrySet ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.420 -0500", hash_original_method = "A1AF959F7C17DD47B4014053BC413A23", hash_generated_method = "ACF0E92DE808C3C201E913BB3DB81ED0")
        
public Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.422 -0500", hash_original_method = "44CFEB1CC21C67EDDE5E7F2C0FB0C916", hash_generated_method = "945314949C7BBCC6BC20B8234E583793")
        
public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            V v = ConcurrentHashMap.this.get(e.getKey());
            return v != null && v.equals(e.getValue());
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.425 -0500", hash_original_method = "8F57FBEE664B771D5FDC7BC47FB0BA8F", hash_generated_method = "F1C6B537623D38F7759F27242F74D900")
        
public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            return ConcurrentHashMap.this.remove(e.getKey(), e.getValue());
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.428 -0500", hash_original_method = "84790AE556354018FD5A8D95161C900C", hash_generated_method = "90E9C2DF329E4562BAFE113BBE53FC84")
        
public int size() {
            return ConcurrentHashMap.this.size();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.430 -0500", hash_original_method = "BB49B4DE055D4AF23A8AAE749170E176", hash_generated_method = "D0C498395B567F9E0AC1C003E0D96349")
        
public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.432 -0500", hash_original_method = "1F05FD987B33CE5DB834C627215292DB", hash_generated_method = "01EC209366AEF3AEDA030D10B50125F3")
        
public void clear() {
            ConcurrentHashMap.this.clear();
        }
        
    }

    /**
     * Returns a {@link Set} view of the keys contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  The set supports element
     * removal, which removes the corresponding mapping from this map,
     * via the <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * operations.  It does not support the <tt>add</tt> or
     * <tt>addAll</tt> operations.
     *
     * <p>The view's <tt>iterator</tt> is a "weakly consistent" iterator
     * that will never throw {@link ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.315 -0500", hash_original_method = "476F610DDCFF0EB4D26DB47138B4B0A3", hash_generated_method = "5B277F3B62B7D5D3C3C789EA3F3201E6")
    
public Set<K> keySet() {
        Set<K> ks = keySet;
        return (ks != null) ? ks : (keySet = new KeySet());
    }

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  The collection
     * supports element removal, which removes the corresponding
     * mapping from this map, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt>, and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * <p>The view's <tt>iterator</tt> is a "weakly consistent" iterator
     * that will never throw {@link ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.318 -0500", hash_original_method = "04B12ED0E2A0A54B9C93D860501FCFFB", hash_generated_method = "B4CF5BAE019344F0E65A15604E21C049")
    
public Collection<V> values() {
        Collection<V> vs = values;
        return (vs != null) ? vs : (values = new Values());
    }

    /**
     * Returns a {@link Set} view of the mappings contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  The set supports element
     * removal, which removes the corresponding mapping from the map,
     * via the <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * operations.  It does not support the <tt>add</tt> or
     * <tt>addAll</tt> operations.
     *
     * <p>The view's <tt>iterator</tt> is a "weakly consistent" iterator
     * that will never throw {@link ConcurrentModificationException},
     * and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to)
     * reflect any modifications subsequent to construction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.320 -0500", hash_original_method = "A019E2D84135E4E25D7FF3C9850D91E8", hash_generated_method = "7C1D4DE3F4186929E20879DB3613226B")
    
public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> es = entrySet;
        return (es != null) ? es : (entrySet = new EntrySet());
    }

    /**
     * Returns an enumeration of the keys in this table.
     *
     * @return an enumeration of the keys in this table
     * @see #keySet()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.323 -0500", hash_original_method = "1378C07218E9226BC9F7AD403D7C2636", hash_generated_method = "AF102C8B9D9B8D59C4558BD3737378FF")
    
public Enumeration<K> keys() {
        return new KeyIterator();
    }

    /**
     * Returns an enumeration of the values in this table.
     *
     * @return an enumeration of the values in this table
     * @see #values()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.325 -0500", hash_original_method = "5CBB59F043F7E5A98C79AC06A0CCF84B", hash_generated_method = "1BCB3BC4911B7F569816A3A6E46A6CFC")
    
public Enumeration<V> elements() {
        return new ValueIterator();
    }

    /* ---------------- Serialization Support -------------- */

    /**
     * Save the state of the <tt>ConcurrentHashMap</tt> instance to a
     * stream (i.e., serialize it).
     * @param s the stream
     * @serialData
     * the key (Object) and value (Object)
     * for each key-value mapping, followed by a null pair.
     * The key-value mappings are emitted in no particular order.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.438 -0500", hash_original_method = "39AA0B3013D1EF3A3A6D6B7DFFE53DC3", hash_generated_method = "7822822DBB75EDF90FC9C36EAA9B10D3")
    
private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        for (int k = 0; k < segments.length; ++k) {
            Segment<K,V> seg = segments[k];
            seg.lock();
            try {
                HashEntry<K,V>[] tab = seg.table;
                for (int i = 0; i < tab.length; ++i) {
                    for (HashEntry<K,V> e = tab[i]; e != null; e = e.next) {
                        s.writeObject(e.key);
                        s.writeObject(e.value);
                    }
                }
            } finally {
                seg.unlock();
            }
        }
        s.writeObject(null);
        s.writeObject(null);
    }

    /**
     * Reconstitute the <tt>ConcurrentHashMap</tt> instance from a
     * stream (i.e., deserialize it).
     * @param s the stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:14.441 -0500", hash_original_method = "27FA8D459FE7A66670B6D1423BE5DC25", hash_generated_method = "A8F21AA97EE8FD2A25E189C238116F20")
    
private void readObject(java.io.ObjectInputStream s)
        throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        // Initialize each segment to be minimally sized, and let grow.
        for (int i = 0; i < segments.length; ++i) {
            segments[i].setTable(new HashEntry[1]);
        }

        // Read the keys and values, and put the mappings in the table
        for (;;) {
            K key = (K) s.readObject();
            V value = (V) s.readObject();
            if (key == null)
                break;
            put(key, value);
        }
    }
}

