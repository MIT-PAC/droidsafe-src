package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface NavigableMap<K,V> extends SortedMap<K,V> {
    
    Map.Entry<K,V> lowerEntry(K key);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    K lowerKey(K key);
    
    Map.Entry<K,V> floorEntry(K key);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    K floorKey(K key);
    
    Map.Entry<K,V> ceilingEntry(K key);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    K ceilingKey(K key);
    
    Map.Entry<K,V> higherEntry(K key);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    K higherKey(K key);
    
    Map.Entry<K,V> firstEntry();
    
    Map.Entry<K,V> lastEntry();
    
    Map.Entry<K,V> pollFirstEntry();
    
    Map.Entry<K,V> pollLastEntry();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    NavigableMap<K,V> descendingMap();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    NavigableSet<K> navigableKeySet();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    NavigableSet<K> descendingKeySet();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                             K toKey,   boolean toInclusive);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    NavigableMap<K,V> headMap(K toKey, boolean inclusive);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SortedMap<K,V> subMap(K fromKey, K toKey);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SortedMap<K,V> headMap(K toKey);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SortedMap<K,V> tailMap(K fromKey);
}
