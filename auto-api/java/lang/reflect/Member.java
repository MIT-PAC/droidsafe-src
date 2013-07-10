package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Member {

    
    public static final int PUBLIC = 0;

    
    public static final int DECLARED = 1;

    
    @SuppressWarnings("unchecked")
    Class<?> getDeclaringClass();

    
    int getModifiers();

    
    String getName();

    
    boolean isSynthetic();
}
