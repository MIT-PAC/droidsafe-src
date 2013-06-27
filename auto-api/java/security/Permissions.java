package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Enumeration;

public final class Permissions extends PermissionCollection implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.374 -0400", hash_original_method = "AF860FC2E8812E80F290B49FE2A41126", hash_generated_method = "AF860FC2E8812E80F290B49FE2A41126")
    public Permissions ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.377 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "ECE2B96F5A9914468145E1A1BFE50E5E")
    public void add(Permission permission) {
        addTaint(permission.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.385 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "A0B3BF7A337098F988A46E416A28E311")
    public Enumeration<Permission> elements() {
        Enumeration<Permission> varB4EAC82CA7396A68D541C85D26508E83_1205843143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1205843143 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1205843143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1205843143;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.386 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "0E0111D24D20B9121B6CA495997EFFE7")
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686765857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686765857;
        // ---------- Original Method ----------
        //return true;
    }

    
}

