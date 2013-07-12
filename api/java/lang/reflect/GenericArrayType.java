package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface GenericArrayType extends Type {
    
    Type getGenericComponentType();
}
