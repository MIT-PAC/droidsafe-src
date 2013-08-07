package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface TypeVariable<D extends GenericDeclaration> extends Type {

    
    Type[] getBounds();

    
    D getGenericDeclaration();

    
    String getName();
}
