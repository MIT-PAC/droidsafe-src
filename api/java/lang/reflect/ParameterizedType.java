package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ParameterizedType extends Type {

    
    Type[] getActualTypeArguments();

    
    Type getOwnerType();

    
    Type getRawType();
}
