package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Map;

public interface ConcurrentMap<K, V> extends Map<K, V> {
    
    V putIfAbsent(K key, V value);

    
    boolean remove(Object key, Object value);

    
    boolean replace(K key, V oldValue, V newValue);

    
    V replace(K key, V value);
}
