package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface WildcardType extends Type {
    
    Type[] getUpperBounds();

    
    Type[] getLowerBounds();
}
