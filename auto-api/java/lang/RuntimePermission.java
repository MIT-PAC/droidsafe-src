package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.BasicPermission;
import java.security.Permission;

public final class RuntimePermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.032 -0400", hash_original_method = "4B2115E5C37ED723471172D5C8F80B46", hash_generated_method = "B40FFA7EF1C415A3C596650238FF819B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimePermission(String permissionName) {
        super("");
        dsTaint.addTaint(permissionName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.032 -0400", hash_original_method = "E2D7FAA6FF83E30EF411D458EDB8F08D", hash_generated_method = "75B9A7DF4DBF38F334BA4AF8513694BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuntimePermission(String name, String actions) {
        super("", "");
        dsTaint.addTaint(name);
        dsTaint.addTaint(actions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.032 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "78D5B880748AF30E3541B5048A11E963")
    @DSModeled(DSC.SAFE)
    @Override
    public String getActions() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.032 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "83CC2500DF371EE023C9FE28ADE5B8AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean implies(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

