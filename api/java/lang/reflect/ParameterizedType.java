package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ParameterizedType extends Type {

    
    Type[] getActualTypeArguments();

    
    Type getOwnerType();

    
    Type getRawType();
}
