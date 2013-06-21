package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class PermissionCollection implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.401 -0400", hash_original_method = "644242D0C0EF5A64328E7E3269265F7A", hash_generated_method = "644242D0C0EF5A64328E7E3269265F7A")
        public PermissionCollection ()
    {
    }


    public abstract void add(Permission permission);

    
    public abstract Enumeration<Permission> elements();

    
    public abstract boolean implies(Permission permission);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.402 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "4AA79CDFB3AF0BB4712028D1C18A980A")
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.402 -0400", hash_original_method = "32FE512F278ECF7FA2513E0F8F8332CC", hash_generated_method = "A55E7890182104F16935D6993243BDE8")
    @DSModeled(DSC.SAFE)
    public void setReadOnly() {
        // ---------- Original Method ----------
    }

    
}

