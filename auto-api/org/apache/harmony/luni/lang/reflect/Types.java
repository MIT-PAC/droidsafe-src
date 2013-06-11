package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.reflect.Type;

public class Types {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.587 -0400", hash_original_method = "FE711A690BFEA310062513D9F7BBC1B7", hash_generated_method = "791549CCA3F40BCAC475218C2EE092DE")
    public static Type[] getClonedTypeArray(ListOfTypes types) {
        return types.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.587 -0400", hash_original_method = "54B4B3680CC50F86109F2F537C471955", hash_generated_method = "33A028F7297D2B3871BBFEC64AA70029")
    public static Type getType(Type type) {
        if (type instanceof ImplForType) {
            return ((ImplForType)type).getResolvedType();
        } else {
            return type;
        }
    }

    
}


