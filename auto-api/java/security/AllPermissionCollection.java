package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Enumeration;

final class AllPermissionCollection extends PermissionCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.102 -0400", hash_original_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF", hash_generated_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF")
    public AllPermissionCollection ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.103 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "2DA957CCF02054264CF9F3317D87298E")
    @Override
    public void add(Permission permission) {
        addTaint(permission.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.104 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "871070B925C101E3861986DBE4D9C6B9")
    @Override
    public Enumeration<Permission> elements() {
        Enumeration<Permission> varB4EAC82CA7396A68D541C85D26508E83_683230481 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_683230481 = null;
        varB4EAC82CA7396A68D541C85D26508E83_683230481.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_683230481;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.104 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "490EFE0058A748F2B94FF5C56D98106C")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255138918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255138918;
        // ---------- Original Method ----------
        //return true;
    }

    
}

