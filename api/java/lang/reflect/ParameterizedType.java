package java.lang.reflect;

// Droidsafe Imports

public interface ParameterizedType extends Type {

    
    Type[] getActualTypeArguments();

    
    Type getOwnerType();

    
    Type getRawType();
}
