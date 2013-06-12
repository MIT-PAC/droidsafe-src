package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface TypeVariable<D extends GenericDeclaration> extends Type {

    
    Type[] getBounds();

    
    D getGenericDeclaration();

    
    String getName();
}

