package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProtectionDomain {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.121 -0400", hash_original_method = "5891D211AA04A5FA0D83B61A16578B35", hash_generated_method = "F0CB7AFA4B39E240210C3F5E9206C81B")
    public  ProtectionDomain(CodeSource cs, PermissionCollection permissions) {
        addTaint(cs.getTaint());
        addTaint(permissions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.122 -0400", hash_original_method = "8AF9E2C6AF4543AE654FB8AC965041A0", hash_generated_method = "8DB5148A001DC1FAA27F7DC4F3BF8177")
    public  ProtectionDomain(CodeSource cs, PermissionCollection permissions, ClassLoader cl, Principal[] principals) {
        addTaint(cs.getTaint());
        addTaint(permissions.getTaint());
        addTaint(cl.getTaint());
        addTaint(principals[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.122 -0400", hash_original_method = "36D40DB51CE149D4D173272547E45D89", hash_generated_method = "CD05E8C5DCD8410A2E292A7784395A61")
    public final ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_136999848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_136999848 = null;
        varB4EAC82CA7396A68D541C85D26508E83_136999848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136999848;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.123 -0400", hash_original_method = "65FBCDB1EF6730AA4782FE733CA5126A", hash_generated_method = "3F68655789F12FB7E6B2A928FA1CF6F9")
    public final CodeSource getCodeSource() {
        CodeSource varB4EAC82CA7396A68D541C85D26508E83_1508058404 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1508058404 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1508058404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1508058404;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.124 -0400", hash_original_method = "CFFE4D5B0E68CF921A8B9CFC68B153D5", hash_generated_method = "F3EF063E4D6B43637A33AEF1FA9DB6D4")
    public final PermissionCollection getPermissions() {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_1903930434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1903930434 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1903930434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1903930434;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.130 -0400", hash_original_method = "FC0016516B863D9708ADC9DFA60C3A75", hash_generated_method = "B6716702ED501FF5F6B6489F882B09DF")
    public final Principal[] getPrincipals() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_474592090 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_474592090 = null;
        varB4EAC82CA7396A68D541C85D26508E83_474592090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474592090;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.131 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "AAD5D2781943CAE6256279BC515583A4")
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783988467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783988467;
        // ---------- Original Method ----------
        //return true;
    }

    
}

