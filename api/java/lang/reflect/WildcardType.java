package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface WildcardType extends Type {
    
    Type[] getUpperBounds();

    
    Type[] getLowerBounds();
}
