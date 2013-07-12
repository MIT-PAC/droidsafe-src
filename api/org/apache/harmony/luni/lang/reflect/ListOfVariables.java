package org.apache.harmony.luni.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

class ListOfVariables {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.383 -0400", hash_original_field = "2686711326D110237E3D188B571EE880", hash_generated_field = "ADB884948D4C2258B0B63DC54D3E2A0F")

    ArrayList<TypeVariable<?>> array = new ArrayList<TypeVariable<?>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.383 -0400", hash_original_method = "41422E53316C05168ACE5C5221EA93B8", hash_generated_method = "41422E53316C05168ACE5C5221EA93B8")
    public ListOfVariables ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.383 -0400", hash_original_method = "E8D6FFF820F0D97573E6E2C017665088", hash_generated_method = "1ACE6DA2E7715840BD0ECE6CC08C88F6")
     void add(TypeVariable<?> elem) {
        addTaint(elem.getTaint());
        array.add(elem);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.384 -0400", hash_original_method = "89100BC351666DED1BC5DAB11AB3C4DD", hash_generated_method = "5DD73B063471A9001FE46B79928B4ABF")
     TypeVariable<?>[] getArray() {
        TypeVariable<?>[] a = new TypeVariable[array.size()];
TypeVariable<?>[] varF96F010B71A4E3E42E8EFB41CD660DA5_240750842 =         array.toArray(a);
        varF96F010B71A4E3E42E8EFB41CD660DA5_240750842.addTaint(taint);
        return varF96F010B71A4E3E42E8EFB41CD660DA5_240750842;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.384 -0400", hash_original_field = "8EF6D0B688538CBFE894C8FA415FDDF3", hash_generated_field = "D64E397C4F832C91E31EE342BD369971")

    public static final TypeVariable[] EMPTY = new ImplForVariable[0];
}

