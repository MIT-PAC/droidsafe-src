package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Map;

public interface ConcurrentMap<K, V> extends Map<K, V> {
    
    V putIfAbsent(K key, V value);

    
    boolean remove(Object key, Object value);

    
    boolean replace(K key, V oldValue, V newValue);

    
    V replace(K key, V value);
}
