package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class AccessControlException extends SecurityException {
    private static final long serialVersionUID = 5138225684096988535L;
    private Permission perm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.589 -0400", hash_original_method = "A915208612B5792FCAB4EB90528BDE0E", hash_generated_method = "BD4841B22EFAE0A3C9262B05A36260C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessControlException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.589 -0400", hash_original_method = "A181D272E1BB95B67E0A8B120C2E59F9", hash_generated_method = "8F79BE31701DA4560DC64B787E4277FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessControlException(String message, Permission perm) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(perm.dsTaint);
        // ---------- Original Method ----------
        //this.perm = perm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.590 -0400", hash_original_method = "DFDCEBDA71EECDB1948D7EAD61470F05", hash_generated_method = "C9FF7FA4F3E96D564326BDC575556547")
    @DSModeled(DSC.SAFE)
    public Permission getPermission() {
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return perm;
    }

    
}


