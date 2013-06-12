package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Comparator<T> {
    
    public int compare(T lhs, T rhs);

    
    public boolean equals(Object object);
}

