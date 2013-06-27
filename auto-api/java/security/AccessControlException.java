package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AccessControlException extends SecurityException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.072 -0400", hash_original_field = "CA659200663CF654DC4410ED494451EE", hash_generated_field = "0D97B5BAB4B6DEEFD11C532A3D968D06")

    private Permission perm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.075 -0400", hash_original_method = "A915208612B5792FCAB4EB90528BDE0E", hash_generated_method = "60BF9D6410DA7631A4C4D7B6548393BD")
    public  AccessControlException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.075 -0400", hash_original_method = "A181D272E1BB95B67E0A8B120C2E59F9", hash_generated_method = "31762FD52C16D3CD4B10BF0B7F46D7CE")
    public  AccessControlException(String message, Permission perm) {
        super(message);
        this.perm = perm;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.perm = perm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.076 -0400", hash_original_method = "DFDCEBDA71EECDB1948D7EAD61470F05", hash_generated_method = "4E29778F483DC20DBF9CBD86D9F83B17")
    public Permission getPermission() {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1599510271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1599510271 = perm;
        varB4EAC82CA7396A68D541C85D26508E83_1599510271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1599510271;
        // ---------- Original Method ----------
        //return perm;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.076 -0400", hash_original_field = "EBFCD6A160C456AB04995295838A0FCE", hash_generated_field = "CD7765A21EFC9E546F4E7691AE09B13F")

    private static long serialVersionUID = 5138225684096988535L;
}

