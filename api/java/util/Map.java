package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Map<K,V> {

    
    public static interface Entry<K,V> {
        
        public boolean equals(Object object);

        
        public K getKey();

        
        public V getValue();

        
        public int hashCode();

        
        public V setValue(V object);
    };

    
    public void clear();

    
    public boolean containsKey(Object key);

    
    public boolean containsValue(Object value);

    
    public Set<Map.Entry<K,V>> entrySet();

    
    public boolean equals(Object object);

    
    public V get(Object key);

    
    public int hashCode();

    
    public boolean isEmpty();

    
    public Set<K> keySet();

    
    public V put(K key, V value);

    
    public void putAll(Map<? extends K,? extends V> map);

    
    public V remove(Object key);

    
    public int size();

    
    public Collection<V> values();
}
