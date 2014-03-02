package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Map<K,V> {
    
    public static interface Entry<K,V> {
        
        public boolean equals(Object object);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public K getKey();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public V getValue();
        
        public int hashCode();
        
        public V setValue(V object);
    };
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean containsKey(Object key);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean containsValue(Object value);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Set<Map.Entry<K,V>> entrySet();
    
    public boolean equals(Object object);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public V get(Object key);
    
    public int hashCode();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Set<K> keySet();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public V put(K key, V value);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void putAll(Map<? extends K,? extends V> map);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public V remove(Object key);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Collection<V> values();
}
