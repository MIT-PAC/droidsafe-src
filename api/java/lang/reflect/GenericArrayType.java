package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface GenericArrayType extends Type {
    
    Type getGenericComponentType();
}
