

package com.google.android.collect;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import droidsafe.annotations.*;


public class Sets {
    
    
    @DSModeled(DSC.SAFE)
    public static <K> HashSet<K> newHashSet() {
        return new HashSet<K>();
    }

    
    public static <E> HashSet<E> newHashSet(E... elements) {
        int capacity = elements.length * 4 / 3 + 1;
        HashSet<E> set = new HashSet<E>(capacity);
        Collections.addAll(set, elements);
        return set;
    }

    
    @DSModeled(DSC.SAFE)
    public static <E> SortedSet<E> newSortedSet() {
        return new TreeSet<E>();
    }

    
    public static <E> SortedSet<E> newSortedSet(E... elements) {
        SortedSet<E> set = new TreeSet<E>();
        Collections.addAll(set, elements);
        return set;
    }

}
