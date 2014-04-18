package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Set<E> extends Collection<E> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean add(E object);
    
    public boolean addAll(Collection<? extends E> collection);
    
    public void clear();
    
    public boolean contains(Object object);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean containsAll(Collection<?> collection);
    
    public boolean equals(Object object);
    
    public int hashCode();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Iterator<E> iterator();
    
    public boolean remove(Object object);
    
    public boolean removeAll(Collection<?> collection);
    
    public boolean retainAll(Collection<?> collection);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Object[] toArray();
    
    public <T> T[] toArray(T[] array);
}
