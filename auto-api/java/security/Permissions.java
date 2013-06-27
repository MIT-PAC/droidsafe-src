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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.087 -0400", hash_original_method = "AF860FC2E8812E80F290B49FE2A41126", hash_generated_method = "AF860FC2E8812E80F290B49FE2A41126")
    public Permissions ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.087 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "ECE2B96F5A9914468145E1A1BFE50E5E")
    public void add(Permission permission) {
        addTaint(permission.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.088 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "633BF2C5F6470A518BA199DC915ABEEA")
    public Enumeration<Permission> elements() {
        Enumeration<Permission> varB4EAC82CA7396A68D541C85D26508E83_1525827463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1525827463 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1525827463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1525827463;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.093 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "101BCFFF14B96DCFC81AA65EC2151F2D")
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_420284752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_420284752;
        // ---------- Original Method ----------
        //return true;
    }

    
}

