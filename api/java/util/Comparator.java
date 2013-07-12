package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Comparator<T> {
    
    public int compare(T lhs, T rhs);

    
    public boolean equals(Object object);
}
