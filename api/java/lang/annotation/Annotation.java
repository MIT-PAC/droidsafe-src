package java.lang.annotation;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Annotation {

    
    Class<? extends Annotation> annotationType();

    
    boolean equals(Object obj);

    
    int hashCode();

    
    String toString();
}
