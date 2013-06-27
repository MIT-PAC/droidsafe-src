package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Enumeration;

final class AllPermissionCollection extends PermissionCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.891 -0400", hash_original_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF", hash_generated_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF")
    public AllPermissionCollection ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.903 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "2DA957CCF02054264CF9F3317D87298E")
    @Override
    public void add(Permission permission) {
        addTaint(permission.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.905 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "DE5BEF4DD330AE0BD7E12973E4BAF322")
    @Override
    public Enumeration<Permission> elements() {
        Enumeration<Permission> varB4EAC82CA7396A68D541C85D26508E83_1662781290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1662781290 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1662781290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1662781290;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.905 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "0BBC9D7AB724DCD044EDDBDEC18516F3")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018658625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018658625;
        // ---------- Original Method ----------
        //return true;
    }

    
}

