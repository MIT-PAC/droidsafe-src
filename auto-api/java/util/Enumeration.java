package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Enumeration<E> {

    
    public boolean hasMoreElements();

    
    public E nextElement();
}

