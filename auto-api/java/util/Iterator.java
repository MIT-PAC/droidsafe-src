package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Iterator<E> {
    
    public boolean hasNext();

    
    public E next();

    
    public void remove();
}
