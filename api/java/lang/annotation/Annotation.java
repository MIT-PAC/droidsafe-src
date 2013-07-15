package java.lang.annotation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Annotation {

    
    Class<? extends Annotation> annotationType();

    
    boolean equals(Object obj);

    
    int hashCode();

    
    String toString();
}
