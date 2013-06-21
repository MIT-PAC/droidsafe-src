package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.BasicPermission;
import java.security.Permission;

public final class SerializablePermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.275 -0400", hash_original_method = "059CB3A47A80651C55222CAAC7D4899E", hash_generated_method = "D7B478C3C461BC979490FE22329CE911")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SerializablePermission(String permissionName) {
        super("");
        dsTaint.addTaint(permissionName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.275 -0400", hash_original_method = "817285F0A88BCE83A5485E1175378F5A", hash_generated_method = "A823E9B41B2C9661940C494CB4F3BC4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SerializablePermission(String name, String actions) {
        super("", "");
        dsTaint.addTaint(name);
        dsTaint.addTaint(actions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.276 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "78D5B880748AF30E3541B5048A11E963")
    @DSModeled(DSC.SAFE)
    @Override
    public String getActions() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.276 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "83CC2500DF371EE023C9FE28ADE5B8AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean implies(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
}

