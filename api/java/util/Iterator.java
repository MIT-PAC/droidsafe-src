package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Iterator<E> {
    
    public boolean hasNext();

    
    public E next();

    
    public void remove();
}
