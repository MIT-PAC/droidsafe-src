package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface GenericArrayType extends Type {
    
    Type getGenericComponentType();
}
