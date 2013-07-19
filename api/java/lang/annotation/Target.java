package java.lang.annotation;

// Droidsafe Imports

@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.ANNOTATION_TYPE) public @interface Target {
    ElementType[] value();
}
