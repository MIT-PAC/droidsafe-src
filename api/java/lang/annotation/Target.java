package java.lang.annotation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.ANNOTATION_TYPE) public @interface Target {
    ElementType[] value();
}
