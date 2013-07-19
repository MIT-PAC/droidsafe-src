package java.lang.reflect;

// Droidsafe Imports
import java.lang.annotation.Annotation;

public interface AnnotatedElement {

    
    <T extends Annotation> T getAnnotation(Class<T> annotationType);

    
    Annotation[] getAnnotations();

    
    Annotation[] getDeclaredAnnotations();

    
    boolean isAnnotationPresent(Class<? extends Annotation> annotationType);
}
