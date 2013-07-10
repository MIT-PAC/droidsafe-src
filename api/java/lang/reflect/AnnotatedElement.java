package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.annotation.Annotation;

public interface AnnotatedElement {

    
    <T extends Annotation> T getAnnotation(Class<T> annotationType);

    
    Annotation[] getAnnotations();

    
    Annotation[] getDeclaredAnnotations();

    
    boolean isAnnotationPresent(Class<? extends Annotation> annotationType);
}
