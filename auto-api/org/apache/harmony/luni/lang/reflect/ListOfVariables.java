package org.apache.harmony.luni.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

class ListOfVariables {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.235 -0400", hash_original_field = "2686711326D110237E3D188B571EE880", hash_generated_field = "ADB884948D4C2258B0B63DC54D3E2A0F")

    ArrayList<TypeVariable<?>> array = new ArrayList<TypeVariable<?>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.236 -0400", hash_original_method = "41422E53316C05168ACE5C5221EA93B8", hash_generated_method = "41422E53316C05168ACE5C5221EA93B8")
    public ListOfVariables ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.236 -0400", hash_original_method = "E8D6FFF820F0D97573E6E2C017665088", hash_generated_method = "1844F08E95892D7BFF450F36C04615B9")
     void add(TypeVariable<?> elem) {
        array.add(elem);
        addTaint(elem.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.238 -0400", hash_original_method = "89100BC351666DED1BC5DAB11AB3C4DD", hash_generated_method = "63804523CE65E8710B2C4B3A78D941C6")
     TypeVariable<?>[] getArray() {
        TypeVariable<?>[] varB4EAC82CA7396A68D541C85D26508E83_964132333 = null; 
        TypeVariable<?>[] a = new TypeVariable[array.size()];
        varB4EAC82CA7396A68D541C85D26508E83_964132333 = array.toArray(a);
        varB4EAC82CA7396A68D541C85D26508E83_964132333.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_964132333;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.238 -0400", hash_original_field = "8EF6D0B688538CBFE894C8FA415FDDF3", hash_generated_field = "D64E397C4F832C91E31EE342BD369971")

    public static final TypeVariable[] EMPTY = new ImplForVariable[0];
}

