package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Collection<E> extends Iterable<E> {
    
    public boolean add(E object);
    
    public boolean addAll(Collection<? extends E> collection);
    
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean contains(Object object);
    
    public boolean containsAll(Collection<?> collection);
    
    public boolean equals(Object object);
    
    public int hashCode();
    
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Iterator<E> iterator();
    
    public boolean remove(Object object);
    
    public boolean removeAll(Collection<?> collection);
    
    public boolean retainAll(Collection<?> collection);
    
    public int size();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public Object[] toArray();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public <T> T[] toArray(T[] array);
}
