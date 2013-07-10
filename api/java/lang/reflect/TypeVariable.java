package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface TypeVariable<D extends GenericDeclaration> extends Type {

    
    Type[] getBounds();

    
    D getGenericDeclaration();

    
    String getName();
}
