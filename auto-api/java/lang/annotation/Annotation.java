package java.lang.annotation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Annotation {

    
    Class<? extends Annotation> annotationType();

    
    boolean equals(Object obj);

    
    int hashCode();

    
    String toString();
}

