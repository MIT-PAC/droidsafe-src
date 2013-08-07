package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SortedSet<E> extends Set<E> {

    
    public Comparator<? super E> comparator();

    
    public E first();

    
    public SortedSet<E> headSet(E end);

    
    public E last();

    
    public SortedSet<E> subSet(E start, E end);

    
    public SortedSet<E> tailSet(E start);
}
