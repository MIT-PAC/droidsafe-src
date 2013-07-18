package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Dictionary<K, V> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.095 -0400", hash_original_method = "9548777BBF89E111326DB823D31BF669", hash_generated_method = "14E151CF1CAF4908929119D552F99B0F")
    public  Dictionary() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Enumeration<V> elements();

    
    public abstract V get(Object key);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isEmpty();

    
    @DSModeled(DSC.SAFE)
    public abstract Enumeration<K> keys();

    
    public abstract V put(K key, V value);

    
    public abstract V remove(Object key);

    
    @DSModeled(DSC.SAFE)
    public abstract int size();

    
}

