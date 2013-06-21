package java.lang.annotation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Annotation {

    
    Class<? extends Annotation> annotationType();

    
    boolean equals(Object obj);

    
    int hashCode();

    
    String toString();
}
