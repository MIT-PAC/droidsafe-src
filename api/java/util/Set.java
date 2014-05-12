package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Set<E> extends Collection<E> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean add(E object);
    
    public boolean addAll(Collection<? extends E> collection);
    
    public void clear();
    
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean contains(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean containsAll(Collection<?> collection);
    
    public boolean equals(Object object);
    
    public int hashCode();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Iterator<E> iterator();
    
    public boolean remove(Object object);
    
    public boolean removeAll(Collection<?> collection);
    
    public boolean retainAll(Collection<?> collection);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public Object[] toArray();
    
    @DSSafe(DSCat.DATA_STRUCTURE)
    public <T> T[] toArray(T[] array);
}
