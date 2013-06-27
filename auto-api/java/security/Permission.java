package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.068 -0400", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "60BBD61DE20E08273982FAC06D418A9B")
    public  Permission(String name) {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.069 -0400", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "44980253F7475E5AD79E8D97619E0A42")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1488452296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1488452296 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1488452296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1488452296;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.069 -0400", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "7B46358E0B69DA0AB94C3564AB046E79")
    public void checkGuard(Object obj) throws SecurityException {
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.073 -0400", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "16EA492ED036F08A6CEFA12EC0DA1956")
    public PermissionCollection newPermissionCollection() {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_2031279167 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2031279167 = new AllPermissionCollection();
        varB4EAC82CA7396A68D541C85D26508E83_2031279167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2031279167;
        // ---------- Original Method ----------
        //return new AllPermissionCollection();
    }

    
    public abstract String getActions();

    
    public abstract boolean implies(Permission permission);

    
}

