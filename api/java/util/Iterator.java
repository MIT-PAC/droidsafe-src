package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Iterator<E> {
    
    public boolean hasNext();

    
    public E next();

    
    public void remove();
}
