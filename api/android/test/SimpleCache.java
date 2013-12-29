package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;



abstract class SimpleCache<K, V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.600 -0500", hash_original_field = "E2EBCB9E510A68D89235063BE410BEB8", hash_generated_field = "F44EFF3B1199C5E87D4423C4F1F5A40F")

    private Map<K, V> map = new HashMap<K, V>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.888 -0400", hash_original_method = "B9E87204655C6A026C6C2BCEB338A844", hash_generated_method = "B9E87204655C6A026C6C2BCEB338A844")
    public SimpleCache ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.600 -0500", hash_original_method = "409928FA1E32C1F645716709A9C29ECC", hash_generated_method = "D1758DFC1BD4F8CD915B5594B48E2926")
    protected abstract V load(K key);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:42.601 -0500", hash_original_method = "74016580A84D30BA8D414209F3F20310", hash_generated_method = "D35E0FFD7869C6117E72DAEA89786D50")
    final V get(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        V value = load(key);
        map.put(key, value);
        return value;
    }

    
}

