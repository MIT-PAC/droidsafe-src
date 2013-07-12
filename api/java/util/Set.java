package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Set<E> extends Collection<E> {

    
    public boolean add(E object);

    
    public boolean addAll(Collection<? extends E> collection);

    
    public void clear();

    
    public boolean contains(Object object);

    
    public boolean containsAll(Collection<?> collection);

    
    public boolean equals(Object object);

    
    public int hashCode();

    
    public boolean isEmpty();

    
    public Iterator<E> iterator();

    
    public boolean remove(Object object);

    
    public boolean removeAll(Collection<?> collection);

    
    public boolean retainAll(Collection<?> collection);

    
    public int size();

    
    public Object[] toArray();

    
    public <T> T[] toArray(T[] array);
}
