package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.233 -0500", hash_original_field = "C1EA1E037942401E0AF0EDC51327A696", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private  LinkedHashMap<K, V> map;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.235 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.237 -0500", hash_original_field = "D24CE561B21BA3B5E8E43ADD45E2BD99", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.239 -0500", hash_original_field = "B1E5BEE9659097DCF237F8BA067DB04D", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.241 -0500", hash_original_field = "1EE7D4A33EF6B95A69235617BE51276B", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.243 -0500", hash_original_field = "56957F74239A5DCE16D02607F9A4A48E", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.246 -0500", hash_original_field = "FCE59D97ECFE49E968FF90BAA339A9B5", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.248 -0500", hash_original_field = "EB717B3BAEC77037413B67E13D5FFFB7", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;

    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *     the maximum number of entries in the cache. For all other caches,
     *     this is the maximum sum of the sizes of the entries in this cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.250 -0500", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "72EC14E4BD7692A51F425CC6CD10293D")
    
public LruCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    /**
     * Returns the value for {@code key} if it exists in the cache or can be
     * created by {@code #create}. If a value was returned, it is moved to the
     * head of the queue. This returns null if a value is not cached and cannot
     * be created.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.253 -0500", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "DF0EFD5D6877CFCED8EDA9D52C3D1B08")
    
public final V get(K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }

        V mapValue;
        synchronized (this) {
            mapValue = map.get(key);
            if (mapValue != null) {
                hitCount++;
                return mapValue;
            }
            missCount++;
        }

        /*
         * Attempt to create a value. This may take a long time, and the map
         * may be different when create() returns. If a conflicting value was
         * added to the map while create() was working, we leave that value in
         * the map and release the created value.
         */

        V createdValue = create(key);
        if (createdValue == null) {
            return null;
        }

        synchronized (this) {
            createCount++;
            mapValue = map.put(key, createdValue);

            if (mapValue != null) {
                // There was a conflict so undo that last put
                map.put(key, mapValue);
            } else {
                size += safeSizeOf(key, createdValue);
            }
        }

        if (mapValue != null) {
            entryRemoved(false, key, createdValue, mapValue);
            return mapValue;
        } else {
            trimToSize(maxSize);
            return createdValue;
        }
    }

    /**
     * Caches {@code value} for {@code key}. The value is moved to the head of
     * the queue.
     *
     * @return the previous value mapped by {@code key}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.256 -0500", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "91BCFF884C516191B3AE67ECFA06A0ED")
    
public final V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }

        V previous;
        synchronized (this) {
            putCount++;
            size += safeSizeOf(key, value);
            previous = map.put(key, value);
            if (previous != null) {
                size -= safeSizeOf(key, previous);
            }
        }

        if (previous != null) {
            entryRemoved(false, key, previous, value);
        }

        trimToSize(maxSize);
        return previous;
    }

    /**
     * @param maxSize the maximum size of the cache before returning. May be -1
     *     to evict even 0-sized elements.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.258 -0500", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "37AFB714E52833F666C67A891B7919B5")
    
private void trimToSize(int maxSize) {
        while (true) {
            K key;
            V value;
            synchronized (this) {
                if (size < 0 || (map.isEmpty() && size != 0)) {
                    throw new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                }

                if (size <= maxSize) {
                    break;
                }

                Map.Entry<K, V> toEvict = map.eldest();
                if (toEvict == null) {
                    break;
                }

                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
                evictionCount++;
            }

            entryRemoved(true, key, value, null);
        }
    }

    /**
     * Removes the entry for {@code key} if it exists.
     *
     * @return the previous value mapped by {@code key}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.261 -0500", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "7E74DE4ED9F20295579ACD181025B17C")
    
public final V remove(K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }

        V previous;
        synchronized (this) {
            previous = map.remove(key);
            if (previous != null) {
                size -= safeSizeOf(key, previous);
            }
        }

        if (previous != null) {
            entryRemoved(false, key, previous, null);
        }

        return previous;
    }

    /**
     * Called for entries that have been evicted or removed. This method is
     * invoked when a value is evicted to make space, removed by a call to
     * {@link #remove}, or replaced by a call to {@link #put}. The default
     * implementation does nothing.
     *
     * <p>The method is called without synchronization: other threads may
     * access the cache while this method is executing.
     *
     * @param evicted true if the entry is being removed to make space, false
     *     if the removal was caused by a {@link #put} or {@link #remove}.
     * @param newValue the new value for {@code key}, if it exists. If non-null,
     *     this removal was caused by a {@link #put}. Otherwise it was caused by
     *     an eviction or a {@link #remove}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.263 -0500", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "5B6A09477D1BDADD16F8B3F7C5F48AC9")
    
protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {}

    /**
     * Called after a cache miss to compute a value for the corresponding key.
     * Returns the computed value or null if no value can be computed. The
     * default implementation returns null.
     *
     * <p>The method is called without synchronization: other threads may
     * access the cache while this method is executing.
     *
     * <p>If a value for {@code key} exists in the cache when this method
     * returns, the created value will be released with {@link #entryRemoved}
     * and discarded. This can occur when multiple threads request the same key
     * at the same time (causing multiple values to be created), or when one
     * thread calls {@link #put} while another is creating a value for the same
     * key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.265 -0500", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "FD8F5FB3995F1C5733A5EBC7107F06D5")
    
protected V create(K key) {
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.268 -0500", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "C15F98F8088B2F6FFC9871ACE2669840")
    
private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return result;
    }

    /**
     * Returns the size of the entry for {@code key} and {@code value} in
     * user-defined units.  The default implementation returns 1 so that size
     * is the number of entries and max size is the maximum number of entries.
     *
     * <p>An entry's size must not change while it is in the cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.270 -0500", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "26549C27E3B12BABE3CC5B53132BA4E4")
    
protected int sizeOf(K key, V value) {
        return 1;
    }

    /**
     * Clear the cache, calling {@link #entryRemoved} on each removed entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.272 -0500", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "8A526200C6412E80DAFC46AAE53299DD")
    
public final void evictAll() {
        trimToSize(-1); // -1 will evict 0-sized elements
    }

    /**
     * For caches that do not override {@link #sizeOf}, this returns the number
     * of entries in the cache. For all other caches, this returns the sum of
     * the sizes of the entries in this cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.274 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "251BCAAAE7DD00F876082F11CC9C175A")
    
public synchronized final int size() {
        return size;
    }

    /**
     * For caches that do not override {@link #sizeOf}, this returns the maximum
     * number of entries in the cache. For all other caches, this returns the
     * maximum sum of the sizes of the entries in this cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.277 -0500", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "5380E80E98CD3F719EFACEA366719E0E")
    
public synchronized final int maxSize() {
        return maxSize;
    }

    /**
     * Returns the number of times {@link #get} returned a value that was
     * already present in the cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.279 -0500", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "F4C81E5317028B725F5E79B63544368A")
    
public synchronized final int hitCount() {
        return hitCount;
    }

    /**
     * Returns the number of times {@link #get} returned null or required a new
     * value to be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.281 -0500", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "F9FA5D622DDF76D0B515E267813A5ED0")
    
public synchronized final int missCount() {
        return missCount;
    }

    /**
     * Returns the number of times {@link #create(Object)} returned a value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.284 -0500", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "800882FD1921762C526139E61ED25F2B")
    
public synchronized final int createCount() {
        return createCount;
    }

    /**
     * Returns the number of times {@link #put} was called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.286 -0500", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "66F99B91A3D7C77D9D07E5BFD3B65B45")
    
public synchronized final int putCount() {
        return putCount;
    }

    /**
     * Returns the number of values that have been evicted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.289 -0500", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "88B5C779B056CC5DB7C5AB8E75A56537")
    
public synchronized final int evictionCount() {
        return evictionCount;
    }

    /**
     * Returns a copy of the current contents of the cache, ordered from least
     * recently accessed to most recently accessed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.291 -0500", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "83C5A9A53DA3465E2C66ACC70037B43D")
    
public synchronized final Map<K, V> snapshot() {
        return new LinkedHashMap<K, V>(map);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.294 -0500", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "95BF13012A117056FE5CFCE2E7234EC1")
    
@Override public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
    }
    
}

