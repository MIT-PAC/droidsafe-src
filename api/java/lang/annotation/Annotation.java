package java.lang.annotation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Annotation {

    
    Class<? extends Annotation> annotationType();

    
    boolean equals(Object obj);

    
    int hashCode();

    
    String toString();
}
