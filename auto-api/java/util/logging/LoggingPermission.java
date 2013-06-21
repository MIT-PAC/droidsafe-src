package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Guard;
import java.security.Permission;

public final class LoggingPermission extends BasicPermission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.632 -0400", hash_original_method = "49660D4D996C1CD70562D31B56A71F27", hash_generated_method = "34977BFD00B477D25EE4A9FEF9288BA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LoggingPermission(String name, String actions) {
        super("", "");
        dsTaint.addTaint(name);
        dsTaint.addTaint(actions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.632 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "78D5B880748AF30E3541B5048A11E963")
    @DSModeled(DSC.SAFE)
    @Override
    public String getActions() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.632 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "83CC2500DF371EE023C9FE28ADE5B8AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean implies(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

