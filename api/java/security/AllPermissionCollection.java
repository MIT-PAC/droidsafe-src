package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Enumeration;

final class AllPermissionCollection extends PermissionCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.930 -0400", hash_original_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF", hash_generated_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF")
    public AllPermissionCollection ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.930 -0400", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "2DA957CCF02054264CF9F3317D87298E")
    @Override
    public void add(Permission permission) {
        addTaint(permission.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.931 -0400", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "68F76004B3AC2729BD3DFDB584B482EF")
    @Override
    public Enumeration<Permission> elements() {
Enumeration<Permission> var540C13E9E156B687226421B24F2DF178_1901498150 =         null;
        var540C13E9E156B687226421B24F2DF178_1901498150.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1901498150;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.931 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "42B16832E612D65F9F4DBA3FCD6C3E06")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1242894470 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729807768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_729807768;
        // ---------- Original Method ----------
        //return true;
    }

    
}

