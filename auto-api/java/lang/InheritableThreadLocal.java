package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.788 -0400", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E069ECF21285DFACCB09CA4095DD4CD7")
    public  InheritableThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.788 -0400", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "6735B2AA1BB3A72091178B107D5A98BD")
    protected T childValue(T parentValue) {
        T varB4EAC82CA7396A68D541C85D26508E83_1817078543 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1817078543 = parentValue;
        addTaint(parentValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1817078543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1817078543;
        // ---------- Original Method ----------
        //return parentValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.789 -0400", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "A468A52D4DD339AB61D5F4AFD4D0DA0E")
    @Override
     Values values(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_569498954 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_569498954 = current.inheritableValues;
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_569498954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_569498954;
        // ---------- Original Method ----------
        //return current.inheritableValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.790 -0400", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "B46AC714AB89996F6F04CD6D3164B1D2")
    @Override
     Values initializeValues(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_1193092845 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1193092845 = current.inheritableValues = new Values();
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1193092845.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1193092845;
        // ---------- Original Method ----------
        //return current.inheritableValues = new Values();
    }

    
}

