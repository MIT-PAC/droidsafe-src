package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.350 -0400", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "60BBD61DE20E08273982FAC06D418A9B")
    public  Permission(String name) {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.350 -0400", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "1D9FA4D9432D91914D30F2AD92B6907F")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_614481360 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_614481360 = null;
        varB4EAC82CA7396A68D541C85D26508E83_614481360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614481360;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.351 -0400", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "7B46358E0B69DA0AB94C3564AB046E79")
    public void checkGuard(Object obj) throws SecurityException {
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.351 -0400", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "65A7D9D9374B88881FC453337AF0F5C9")
    public PermissionCollection newPermissionCollection() {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_500701183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_500701183 = new AllPermissionCollection();
        varB4EAC82CA7396A68D541C85D26508E83_500701183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_500701183;
        // ---------- Original Method ----------
        //return new AllPermissionCollection();
    }

    
    public abstract String getActions();

    
    public abstract boolean implies(Permission permission);

    
}

