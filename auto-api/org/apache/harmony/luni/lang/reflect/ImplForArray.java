package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class ImplForArray implements GenericArrayType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.869 -0400", hash_original_field = "2B3D37BF85E68F44CAF08F0E8BE5B871", hash_generated_field = "E5C2178136BA4F8025942E6B948C4074")

    private Type componentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.870 -0400", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "FF0AF6F4DC1AD0565714CE91EA701306")
    public  ImplForArray(Type componentType) {
        this.componentType = componentType;
        // ---------- Original Method ----------
        //this.componentType = componentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.871 -0400", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "1D92F77ED87D420C8C2907ED4DB873A0")
    public Type getGenericComponentType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_818487172 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_1544878103 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_818487172 = ((ImplForType)componentType).getResolvedType();
        } //End block
        catch (ClassCastException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1544878103 = componentType;
        } //End block
        Type varA7E53CE21691AB073D9660D615818899_1236443882; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1236443882 = varB4EAC82CA7396A68D541C85D26508E83_818487172;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1236443882 = varB4EAC82CA7396A68D541C85D26508E83_1544878103;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1236443882.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1236443882;
        // ---------- Original Method ----------
        //try {
            //return ((ImplForType)componentType).getResolvedType();
        //} catch (ClassCastException e) {
            //return componentType;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.871 -0400", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "C0BB695A4CF6B0F83F9EE177E4A031FD")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1216382095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1216382095 = componentType.toString() + "[]";
        varB4EAC82CA7396A68D541C85D26508E83_1216382095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216382095;
        // ---------- Original Method ----------
        //return componentType.toString() + "[]";
    }

    
}

