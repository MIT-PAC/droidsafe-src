package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class PermissionCollection implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.414 -0400", hash_original_method = "9068D0108294B13066862778786146D9", hash_generated_method = "9068D0108294B13066862778786146D9")
    public PermissionCollection ()
    {
        
    }


    public abstract void add(Permission permission);

    
    public abstract Enumeration<Permission> elements();

    
    public abstract boolean implies(Permission permission);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.417 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "585E8CCCAA12C83A3CFC3BFF7587C4DF")
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772585485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_772585485;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.417 -0400", hash_original_method = "32FE512F278ECF7FA2513E0F8F8332CC", hash_generated_method = "A55E7890182104F16935D6993243BDE8")
    public void setReadOnly() {
        
    }

    
}

