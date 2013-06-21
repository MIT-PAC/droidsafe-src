package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Iterator<E> {
    
    public boolean hasNext();

    
    public E next();

    
    public void remove();
}
