package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Type;

public class Types {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.334 -0500", hash_original_method = "FE711A690BFEA310062513D9F7BBC1B7", hash_generated_method = "791549CCA3F40BCAC475218C2EE092DE")
    
public static Type[] getClonedTypeArray(ListOfTypes types) {
        return types.getResolvedTypes().clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.337 -0500", hash_original_method = "54B4B3680CC50F86109F2F537C471955", hash_generated_method = "33A028F7297D2B3871BBFEC64AA70029")
    
public static Type getType(Type type) {
        if (type instanceof ImplForType) {
            return ((ImplForType)type).getResolvedType();
        } else {
            return type;
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.031 -0400", hash_original_method = "EB242658FEF62ED6B0CFC2AEE4C919C1", hash_generated_method = "EB242658FEF62ED6B0CFC2AEE4C919C1")
    public Types ()
    {
        //Synthesized constructor
    }
    
}

