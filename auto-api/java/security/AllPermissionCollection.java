package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Enumeration;

final class AllPermissionCollection extends PermissionCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.295 -0400", hash_original_method = "F97C7C45DBD48D09E4398E99F573D081", hash_generated_method = "F97C7C45DBD48D09E4398E99F573D081")
        public AllPermissionCollection ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.295 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "D4E79C1AE20A703DFE29EB7E7DC6E946")
    @DSModeled(DSC.SAFE)
    @Override
    public void add(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.295 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "5BDAE76F15FD41975463437CAEA9B972")
    @DSModeled(DSC.SAFE)
    @Override
    public Enumeration<Permission> elements() {
        return (Enumeration<Permission>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.303 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "83CC2500DF371EE023C9FE28ADE5B8AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean implies(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

