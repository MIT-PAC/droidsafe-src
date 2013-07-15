package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Type;

public class Types {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.385 -0400", hash_original_method = "EB242658FEF62ED6B0CFC2AEE4C919C1", hash_generated_method = "EB242658FEF62ED6B0CFC2AEE4C919C1")
    public Types ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
    public static Type[] getClonedTypeArray(ListOfTypes types) {
        return types.getResolvedTypes().clone();
    }

    
        @DSModeled(DSC.SPEC)
    public static Type getType(Type type) {
        if (type instanceof ImplForType) {
            return ((ImplForType)type).getResolvedType();
        } else {
            return type;
        }
    }

    
}

