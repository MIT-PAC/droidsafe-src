package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SortedSet<E> extends Set<E> {

    
    public Comparator<? super E> comparator();

    
    public E first();

    
    public SortedSet<E> headSet(E end);

    
    public E last();

    
    public SortedSet<E> subSet(E start, E end);

    
    public SortedSet<E> tailSet(E start);
}
