package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;




class ListOfVariables {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.128 -0500", hash_original_field = "A17304FEBED4ADC14900CE4BD8265A40", hash_generated_field = "D64E397C4F832C91E31EE342BD369971")

    public static final TypeVariable[] EMPTY = new ImplForVariable[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.130 -0500", hash_original_field = "ADB884948D4C2258B0B63DC54D3E2A0F", hash_generated_field = "ADB884948D4C2258B0B63DC54D3E2A0F")


    ArrayList<TypeVariable<?>> array = new ArrayList<TypeVariable<?>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.025 -0400", hash_original_method = "41422E53316C05168ACE5C5221EA93B8", hash_generated_method = "41422E53316C05168ACE5C5221EA93B8")
    public ListOfVariables ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.132 -0500", hash_original_method = "E8D6FFF820F0D97573E6E2C017665088", hash_generated_method = "E8D6FFF820F0D97573E6E2C017665088")
    
void add (TypeVariable<?> elem) {
        array.add(elem);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.134 -0500", hash_original_method = "89100BC351666DED1BC5DAB11AB3C4DD", hash_generated_method = "89100BC351666DED1BC5DAB11AB3C4DD")
    
TypeVariable<?>[] getArray() {
        TypeVariable<?>[] a = new TypeVariable[array.size()];
        return array.toArray(a);
    }
}

