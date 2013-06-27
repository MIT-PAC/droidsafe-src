package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProtectionDomain {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.398 -0400", hash_original_method = "5891D211AA04A5FA0D83B61A16578B35", hash_generated_method = "F0CB7AFA4B39E240210C3F5E9206C81B")
    public  ProtectionDomain(CodeSource cs, PermissionCollection permissions) {
        addTaint(cs.getTaint());
        addTaint(permissions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.398 -0400", hash_original_method = "8AF9E2C6AF4543AE654FB8AC965041A0", hash_generated_method = "8DB5148A001DC1FAA27F7DC4F3BF8177")
    public  ProtectionDomain(CodeSource cs, PermissionCollection permissions, ClassLoader cl, Principal[] principals) {
        addTaint(cs.getTaint());
        addTaint(permissions.getTaint());
        addTaint(cl.getTaint());
        addTaint(principals[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.399 -0400", hash_original_method = "36D40DB51CE149D4D173272547E45D89", hash_generated_method = "907DC383C710515609092E20574F7411")
    public final ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1270870579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1270870579 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1270870579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1270870579;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.399 -0400", hash_original_method = "65FBCDB1EF6730AA4782FE733CA5126A", hash_generated_method = "4797AA6C488AB753775AC60195A87485")
    public final CodeSource getCodeSource() {
        CodeSource varB4EAC82CA7396A68D541C85D26508E83_777930996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_777930996 = null;
        varB4EAC82CA7396A68D541C85D26508E83_777930996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_777930996;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.414 -0400", hash_original_method = "CFFE4D5B0E68CF921A8B9CFC68B153D5", hash_generated_method = "D0F606949D46721631184DF9F96F536A")
    public final PermissionCollection getPermissions() {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_2063985941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2063985941 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2063985941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2063985941;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.415 -0400", hash_original_method = "FC0016516B863D9708ADC9DFA60C3A75", hash_generated_method = "21029C13E2125C613611B0178523C54D")
    public final Principal[] getPrincipals() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_2084941216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2084941216 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2084941216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2084941216;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.415 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "26DD2432F5F7253F263C48A75EF72CA4")
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977706807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_977706807;
        // ---------- Original Method ----------
        //return true;
    }

    
}

