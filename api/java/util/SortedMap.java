package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface SortedMap<K,V> extends Map<K,V> {

    
    public Comparator<? super K> comparator();

    
    public K firstKey();

    
    public SortedMap<K,V> headMap(K endKey);

    
    public K lastKey();

    
    public SortedMap<K,V> subMap(K startKey, K endKey);

    
    public SortedMap<K,V> tailMap(K startKey);
}
