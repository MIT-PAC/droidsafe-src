package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BasicLruCache<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.899 -0500", hash_original_field = "C1EA1E037942401E0AF0EDC51327A696", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private  LinkedHashMap<K, V> map;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.901 -0500", hash_original_field = "D24CE561B21BA3B5E8E43ADD45E2BD99", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private  int maxSize;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.904 -0500", hash_original_method = "CC3CF8B3D98F4B51DBF91665642387E1", hash_generated_method = "72BDF6C47DEDBFF6864D2A7CE3C2B384")
    
public BasicLruCache(int maxSize) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.907 -0500", hash_original_method = "FDCF7F376F479E894B67671F9DF4B51A", hash_generated_method = "BF6E3499977854564B236E0D4C323B6F")
    
public synchronized final V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        V result = map.get(key);
        if (result != null) {
            return result;
        }

        result = create(key);

        if (result != null) {
            map.put(key, result);
            trimToSize(maxSize);
        }
        return result;
    }

    /**
     * Caches {@code value} for {@code key}. The value is moved to the head of
     * the queue.
     *
     * @return the previous value mapped by {@code key}. Although that entry is
     *     no longer cached, it has not been passed to {@link #entryEvicted}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.909 -0500", hash_original_method = "B215038407F38B18B2F223450263C0DA", hash_generated_method = "312D4B3496AC1A88949D07EE8A791D82")
    
public synchronized final V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }

        V previous = map.put(key, value);
        trimToSize(maxSize);
        return previous;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.911 -0500", hash_original_method = "C2014D558C9CB4AC36D82EB01EFD84A6", hash_generated_method = "D24DFE9261B084794D3ED416285B8E3E")
    
private void trimToSize(int maxSize) {
        while (map.size() > maxSize) {
            Map.Entry<K, V> toEvict = map.eldest();

            K key = toEvict.getKey();
            V value = toEvict.getValue();
            map.remove(key);

            entryEvicted(key, value);
        }
    }

    /**
     * Called for entries that have reached the tail of the least recently used
     * queue and are be removed. The default implementation does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.914 -0500", hash_original_method = "4BE44702079F6982C8F2A1526F7D2A98", hash_generated_method = "35BF11F5FF60BA87520630AA007991D9")
    
protected void entryEvicted(K key, V value) {}

    /**
     * Called after a cache miss to compute a value for the corresponding key.
     * Returns the computed value or null if no value can be computed. The
     * default implementation returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.917 -0500", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "FD8F5FB3995F1C5733A5EBC7107F06D5")
    
protected V create(K key) {
        return null;
    }

    /**
     * Returns a copy of the current contents of the cache, ordered from least
     * recently accessed to most recently accessed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.919 -0500", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "83C5A9A53DA3465E2C66ACC70037B43D")
    
public synchronized final Map<K, V> snapshot() {
        return new LinkedHashMap<K, V>(map);
    }

    /**
     * Clear the cache, calling {@link #entryEvicted} on each removed entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.922 -0500", hash_original_method = "4FACC3280D713DC7A18D1388CFCADEC7", hash_generated_method = "BAA3D1DF853C2C7B0D635A35D52107B9")
    
public synchronized final void evictAll() {
        trimToSize(0);
    }
    
}

