package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Comparator<T> {
    
    public int compare(T lhs, T rhs);

    
    public boolean equals(Object object);
}
