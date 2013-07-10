package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ListIterator<E> extends Iterator<E> {

    
    void add(E object);

    
    public boolean hasNext();

    
    public boolean hasPrevious();

    
    public E next();

    
    public int nextIndex();

    
    public E previous();

    
    public int previousIndex();

    
    public void remove();

    
    void set(E object);
}
