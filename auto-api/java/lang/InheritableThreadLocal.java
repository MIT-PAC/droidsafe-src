package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.114 -0400", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E069ECF21285DFACCB09CA4095DD4CD7")
    public  InheritableThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.114 -0400", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "E3303AD0DB6630111D771E15DA4DFF92")
    protected T childValue(T parentValue) {
        T varB4EAC82CA7396A68D541C85D26508E83_1914217841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1914217841 = parentValue;
        addTaint(parentValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1914217841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1914217841;
        // ---------- Original Method ----------
        //return parentValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.115 -0400", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "947D2C144F8969B96FD8FD475874E342")
    @Override
     Values values(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_2013309752 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2013309752 = current.inheritableValues;
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2013309752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2013309752;
        // ---------- Original Method ----------
        //return current.inheritableValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.115 -0400", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "B29636AF7A3785FEADEB1AB67FA5134C")
    @Override
     Values initializeValues(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_649213872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_649213872 = current.inheritableValues = new Values();
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_649213872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649213872;
        // ---------- Original Method ----------
        //return current.inheritableValues = new Values();
    }

    
}

