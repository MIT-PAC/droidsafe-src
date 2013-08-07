package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Enumeration;





public abstract class PermissionCollection implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.124 -0400", hash_original_method = "9068D0108294B13066862778786146D9", hash_generated_method = "9068D0108294B13066862778786146D9")
    public PermissionCollection ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void add(Permission permission);

    
    @DSModeled(DSC.SAFE)
    public abstract Enumeration<Permission> elements();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean implies(Permission permission);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.126 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "3F931B3084501D4664912D95139AB00E")
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1439169395 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983392352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983392352;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.127 -0400", hash_original_method = "32FE512F278ECF7FA2513E0F8F8332CC", hash_generated_method = "A55E7890182104F16935D6993243BDE8")
    public void setReadOnly() {
        // ---------- Original Method ----------
    }

    
}

