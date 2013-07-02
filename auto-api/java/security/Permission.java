package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public abstract class Permission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.404 -0400", hash_original_method = "A3ABD4D844A912132701BDB49CC172D4", hash_generated_method = "60BBD61DE20E08273982FAC06D418A9B")
    public  Permission(String name) {
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.407 -0400", hash_original_method = "BD1D69B57EF82CC836CADC372B210DA8", hash_generated_method = "92DC9C0CF00D91E1F61ECC8405D853DB")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1088885645 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1088885645 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1088885645.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1088885645;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.408 -0400", hash_original_method = "C84962AC42FE97CD37014EB04A226348", hash_generated_method = "7B46358E0B69DA0AB94C3564AB046E79")
    public void checkGuard(Object obj) throws SecurityException {
        addTaint(obj.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.409 -0400", hash_original_method = "3B418AF4D3F113F25455A16498EE96FC", hash_generated_method = "CA2DC16A1F0FFFC87307FA6C30E7E682")
    public PermissionCollection newPermissionCollection() {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_428491840 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_428491840 = new AllPermissionCollection();
        varB4EAC82CA7396A68D541C85D26508E83_428491840.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_428491840;
        
        
    }

    
    public abstract String getActions();

    
    public abstract boolean implies(Permission permission);

    
}

