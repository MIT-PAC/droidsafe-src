package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface TypeVariable<D extends GenericDeclaration> extends Type {

    
    Type[] getBounds();

    
    D getGenericDeclaration();

    
    String getName();
}
