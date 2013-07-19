package java.lang.reflect;

// Droidsafe Imports

public interface WildcardType extends Type {
    
    Type[] getUpperBounds();

    
    Type[] getLowerBounds();
}
