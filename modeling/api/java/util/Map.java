package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Map<K,V> {
    
    public static interface Entry<K,V> {
        
        public boolean equals(Object object);
        
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public K getKey();
        
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public V getValue();
        
        public int hashCode();
        
        public V setValue(V object);
    };
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean containsKey(Object key);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean containsValue(Object value);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Set<Map.Entry<K,V>> entrySet();
    
    public boolean equals(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public V get(Object key);
    
    public int hashCode();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Set<K> keySet();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public V put(K key, V value);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public void putAll(Map<? extends K,? extends V> map);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public V remove(Object key);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Collection<V> values();
}
