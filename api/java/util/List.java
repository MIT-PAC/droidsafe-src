package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface List<E> extends Collection<E> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public void add(int location, E object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean add(E object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean addAll(int location, Collection<? extends E> collection);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean addAll(Collection<? extends E> collection);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean contains(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean containsAll(Collection<?> collection);
    
    public boolean equals(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public E get(int location);
    
    public int hashCode();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public int indexOf(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean isEmpty();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public Iterator<E> iterator();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public int lastIndexOf(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public ListIterator<E> listIterator();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public ListIterator<E> listIterator(int location);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public E remove(int location);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean remove(Object object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean removeAll(Collection<?> collection);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public boolean retainAll(Collection<?> collection);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public E set(int location, E object);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public int size();
    
    public List<E> subList(int start, int end);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public Object[] toArray();
    
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public <T> T[] toArray(T[] array);
}
