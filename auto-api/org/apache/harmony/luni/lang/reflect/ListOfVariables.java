package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

class ListOfVariables {
    ArrayList<TypeVariable<?>> array = new ArrayList<TypeVariable<?>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.854 -0400", hash_original_method = "376142BE17F6CACC5E32DB40D10D6694", hash_generated_method = "376142BE17F6CACC5E32DB40D10D6694")
        public ListOfVariables ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.854 -0400", hash_original_method = "E8D6FFF820F0D97573E6E2C017665088", hash_generated_method = "7164CD7BBD67E862A4C9C17E57FD48FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void add(TypeVariable<?> elem) {
        dsTaint.addTaint(elem.dsTaint);
        array.add(elem);
        // ---------- Original Method ----------
        //array.add(elem);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.855 -0400", hash_original_method = "89100BC351666DED1BC5DAB11AB3C4DD", hash_generated_method = "6B40D558E016EBAA2E211C9FDC9D1912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     TypeVariable<?>[] getArray() {
        TypeVariable<?>[] a;
        a = new TypeVariable[array.size()];
        TypeVariable<?>[] var77EF65E90EFBBA7CA99DF169BC1482E6_1239245765 = (array.toArray(a));
        return (TypeVariable<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //TypeVariable<?>[] a = new TypeVariable[array.size()];
        //return array.toArray(a);
    }

    
    public static final TypeVariable[] EMPTY = new ImplForVariable[0];
}

