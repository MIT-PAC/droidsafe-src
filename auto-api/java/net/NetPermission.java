package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.BasicPermission;
import java.security.Permission;

public final class NetPermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.955 -0400", hash_original_method = "AF713E88B3605596EC00E48857DBF46B", hash_generated_method = "43D8C6C7DD044204FED3833488A77CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetPermission(String name) {
        super("");
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.956 -0400", hash_original_method = "342AA26435633C300D2029E398212CA8", hash_generated_method = "CD3A0DCD1F8E7FF7F567F6E3AAF8593B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetPermission(String name, String actions) {
        super("", "");
        dsTaint.addTaint(name);
        dsTaint.addTaint(actions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.956 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "78D5B880748AF30E3541B5048A11E963")
    @DSModeled(DSC.SAFE)
    @Override
    public String getActions() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.956 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "83CC2500DF371EE023C9FE28ADE5B8AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean implies(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

