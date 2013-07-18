package java.lang.reflect;

// Droidsafe Imports

public interface TypeVariable<D extends GenericDeclaration> extends Type {

    
    Type[] getBounds();

    
    D getGenericDeclaration();

    
    String getName();
}
