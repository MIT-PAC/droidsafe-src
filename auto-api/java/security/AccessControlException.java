package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AccessControlException extends SecurityException {
    private Permission perm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.290 -0400", hash_original_method = "A915208612B5792FCAB4EB90528BDE0E", hash_generated_method = "59F8D7B4D95EF7FAD3CBB7D2AE5C2411")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessControlException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.291 -0400", hash_original_method = "A181D272E1BB95B67E0A8B120C2E59F9", hash_generated_method = "C58EB98A0119598D1B2781E35B22D44E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessControlException(String message, Permission perm) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(perm.dsTaint);
        // ---------- Original Method ----------
        //this.perm = perm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.291 -0400", hash_original_method = "DFDCEBDA71EECDB1948D7EAD61470F05", hash_generated_method = "A1AEE92E2F80BACF05D80316F43B9F09")
    @DSModeled(DSC.SAFE)
    public Permission getPermission() {
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return perm;
    }

    
    private static final long serialVersionUID = 5138225684096988535L;
}

