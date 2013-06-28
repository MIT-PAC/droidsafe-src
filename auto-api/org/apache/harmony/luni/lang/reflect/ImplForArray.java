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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.131 -0400", hash_original_field = "2B3D37BF85E68F44CAF08F0E8BE5B871", hash_generated_field = "E5C2178136BA4F8025942E6B948C4074")

    private Type componentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.132 -0400", hash_original_method = "2027F862B9235E5067268A95F39519F4", hash_generated_method = "FF0AF6F4DC1AD0565714CE91EA701306")
    public  ImplForArray(Type componentType) {
        this.componentType = componentType;
        // ---------- Original Method ----------
        //this.componentType = componentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.133 -0400", hash_original_method = "DF2F4D0FDA59F8B376BF76172F429ABC", hash_generated_method = "E1427792D371EBA6265AFC78E9AE43ED")
    public Type getGenericComponentType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_970968190 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_1904245660 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_970968190 = ((ImplForType)componentType).getResolvedType();
        } //End block
        catch (ClassCastException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1904245660 = componentType;
        } //End block
        Type varA7E53CE21691AB073D9660D615818899_1772325560; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1772325560 = varB4EAC82CA7396A68D541C85D26508E83_970968190;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1772325560 = varB4EAC82CA7396A68D541C85D26508E83_1904245660;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1772325560.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1772325560;
        // ---------- Original Method ----------
        //try {
            //return ((ImplForType)componentType).getResolvedType();
        //} catch (ClassCastException e) {
            //return componentType;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.134 -0400", hash_original_method = "4E93C574A33186DE87D5834EAA369B51", hash_generated_method = "7816B5B1909EB82836BBF689D96F53BA")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_614611500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_614611500 = componentType.toString() + "[]";
        varB4EAC82CA7396A68D541C85D26508E83_614611500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614611500;
        // ---------- Original Method ----------
        //return componentType.toString() + "[]";
    }

    
}

