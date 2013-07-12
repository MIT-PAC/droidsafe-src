package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface NavigableSet<E> extends SortedSet<E> {
    
    E lower(E e);

    
    E floor(E e);

    
    E ceiling(E e);

    
    E higher(E e);

    
    E pollFirst();

    
    E pollLast();

    
    Iterator<E> iterator();

    
    NavigableSet<E> descendingSet();

    
    Iterator<E> descendingIterator();

    
    NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
                           E toElement,   boolean toInclusive);

    
    NavigableSet<E> headSet(E toElement, boolean inclusive);

    
    NavigableSet<E> tailSet(E fromElement, boolean inclusive);

    
    SortedSet<E> subSet(E fromElement, E toElement);

    
    SortedSet<E> headSet(E toElement);

    
    SortedSet<E> tailSet(E fromElement);
}
