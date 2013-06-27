package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.610 -0400", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E069ECF21285DFACCB09CA4095DD4CD7")
    public  InheritableThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.611 -0400", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "892F72E41B849578CDD057C5991C3561")
    protected T childValue(T parentValue) {
        T varB4EAC82CA7396A68D541C85D26508E83_1062635613 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1062635613 = parentValue;
        addTaint(parentValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1062635613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1062635613;
        // ---------- Original Method ----------
        //return parentValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.612 -0400", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "AF732ECDB541A2DCB3643FD82BE066FD")
    @Override
     Values values(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_1231197808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1231197808 = current.inheritableValues;
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1231197808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1231197808;
        // ---------- Original Method ----------
        //return current.inheritableValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.612 -0400", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "E43D35A99351E8D2E25C25E3BE68EF5F")
    @Override
     Values initializeValues(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_1455353682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1455353682 = current.inheritableValues = new Values();
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1455353682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455353682;
        // ---------- Original Method ----------
        //return current.inheritableValues = new Values();
    }

    
}

