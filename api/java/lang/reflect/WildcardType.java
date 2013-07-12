package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface WildcardType extends Type {
    
    Type[] getUpperBounds();

    
    Type[] getLowerBounds();
}
