package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface WildcardType extends Type {
    
    Type[] getUpperBounds();

    
    Type[] getLowerBounds();
}
