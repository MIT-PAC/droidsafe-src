package java.lang.annotation;

// Droidsafe Imports
import droidsafe.annotations.*;

@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.ANNOTATION_TYPE) public @interface Retention {
    RetentionPolicy value();
}
