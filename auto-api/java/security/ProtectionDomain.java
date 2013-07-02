package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ProtectionDomain {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.439 -0400", hash_original_method = "5891D211AA04A5FA0D83B61A16578B35", hash_generated_method = "F0CB7AFA4B39E240210C3F5E9206C81B")
    public  ProtectionDomain(CodeSource cs, PermissionCollection permissions) {
        addTaint(cs.getTaint());
        addTaint(permissions.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.441 -0400", hash_original_method = "8AF9E2C6AF4543AE654FB8AC965041A0", hash_generated_method = "8DB5148A001DC1FAA27F7DC4F3BF8177")
    public  ProtectionDomain(CodeSource cs, PermissionCollection permissions, ClassLoader cl, Principal[] principals) {
        addTaint(cs.getTaint());
        addTaint(permissions.getTaint());
        addTaint(cl.getTaint());
        addTaint(principals[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.443 -0400", hash_original_method = "36D40DB51CE149D4D173272547E45D89", hash_generated_method = "D3DFA334D10A46D2CF73C2D81302C3E3")
    public final ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_2126291282 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2126291282 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2126291282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2126291282;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.444 -0400", hash_original_method = "65FBCDB1EF6730AA4782FE733CA5126A", hash_generated_method = "1F6137D3DD0FB67534DFACB022B7F0E4")
    public final CodeSource getCodeSource() {
        CodeSource varB4EAC82CA7396A68D541C85D26508E83_1553979299 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1553979299 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1553979299.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1553979299;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.445 -0400", hash_original_method = "CFFE4D5B0E68CF921A8B9CFC68B153D5", hash_generated_method = "5F194F2E519FF2A13AEEA91672702382")
    public final PermissionCollection getPermissions() {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_1166624656 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1166624656 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1166624656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1166624656;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.445 -0400", hash_original_method = "FC0016516B863D9708ADC9DFA60C3A75", hash_generated_method = "D32D9A70275FD9AFD6649C8DA649340F")
    public final Principal[] getPrincipals() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_559462469 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_559462469 = null;
        varB4EAC82CA7396A68D541C85D26508E83_559462469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_559462469;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.445 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "839545923C1D074F3C222B36EE3EC448")
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108023809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108023809;
        
        
    }

    
}

