package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.util.Enumeration;

public final class Permissions extends PermissionCollection implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.423 -0400", hash_original_method = "AF860FC2E8812E80F290B49FE2A41126", hash_generated_method = "AF860FC2E8812E80F290B49FE2A41126")
    public Permissions ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.423 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "ECE2B96F5A9914468145E1A1BFE50E5E")
    public void add(Permission permission) {
        addTaint(permission.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.423 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "42D7C0796EFC88E1891B239ECBADC33F")
    public Enumeration<Permission> elements() {
        Enumeration<Permission> varB4EAC82CA7396A68D541C85D26508E83_643108373 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_643108373 = null;
        varB4EAC82CA7396A68D541C85D26508E83_643108373.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_643108373;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.424 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "9D03B976E3475A7EDB57F21C7C193C1F")
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729547265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_729547265;
        
        
    }

    
}

