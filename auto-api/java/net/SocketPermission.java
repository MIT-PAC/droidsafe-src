package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.security.Permission;

public final class SocketPermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.137 -0400", hash_original_method = "7248A57D7E8DCE007CEC41DE038EC206", hash_generated_method = "33BAFB24BCA87FA690F7FE866CDCAF3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketPermission(String host, String action) {
        super("");
        dsTaint.addTaint(host);
        dsTaint.addTaint(action);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.138 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "78D5B880748AF30E3541B5048A11E963")
    @DSModeled(DSC.SAFE)
    @Override
    public String getActions() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.138 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "83CC2500DF371EE023C9FE28ADE5B8AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean implies(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

