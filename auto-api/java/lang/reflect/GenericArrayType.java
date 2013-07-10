package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface GenericArrayType extends Type {
    
    Type getGenericComponentType();
}
