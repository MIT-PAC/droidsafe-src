package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Type;

public class Types {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.855 -0400", hash_original_method = "CD940E849A691E79E0914199B0E636D8", hash_generated_method = "CD940E849A691E79E0914199B0E636D8")
        public Types ()
    {
    }


        public static Type[] getClonedTypeArray(ListOfTypes types) {
        return types.getResolvedTypes().clone();
    }

    
        public static Type getType(Type type) {
        if (type instanceof ImplForType) {
            return ((ImplForType)type).getResolvedType();
        } else {
            return type;
        }
    }

    
}

