package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface List<E> extends Collection<E> {
    
    public void add(int location, E object);

    
    public boolean add(E object);

    
    public boolean addAll(int location, Collection<? extends E> collection);

    
    public boolean addAll(Collection<? extends E> collection);

    
    public void clear();

    
    public boolean contains(Object object);

    
    public boolean containsAll(Collection<?> collection);

    
    public boolean equals(Object object);

    
    public E get(int location);

    
    public int hashCode();

    
    public int indexOf(Object object);

    
    public boolean isEmpty();

    
    public Iterator<E> iterator();

    
    public int lastIndexOf(Object object);

    
    public ListIterator<E> listIterator();

    
    public ListIterator<E> listIterator(int location);

    
    public E remove(int location);

    
    public boolean remove(Object object);

    
    public boolean removeAll(Collection<?> collection);

    
    public boolean retainAll(Collection<?> collection);

    
    public E set(int location, E object);

    
    public int size();

    
    public List<E> subList(int start, int end);

    
    public Object[] toArray();

    
    public <T> T[] toArray(T[] array);
}
