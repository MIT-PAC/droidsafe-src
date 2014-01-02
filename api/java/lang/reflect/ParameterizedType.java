package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ParameterizedType extends Type {

    
    Type[] getActualTypeArguments();

    
    Type getOwnerType();

    
    Type getRawType();
}
