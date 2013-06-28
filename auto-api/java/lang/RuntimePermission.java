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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.650 -0400", hash_original_method = "4B2115E5C37ED723471172D5C8F80B46", hash_generated_method = "152F2835EE644AC6F0BD82FFF888E07E")
    public  RuntimePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.650 -0400", hash_original_method = "E2D7FAA6FF83E30EF411D458EDB8F08D", hash_generated_method = "FE97726153430AE1C5C8B8AC13841AB7")
    public  RuntimePermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.651 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "25BB31259E85CDAC04836A67E0D9B2B2")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_488495311 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_488495311 = null;
        varB4EAC82CA7396A68D541C85D26508E83_488495311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_488495311;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.651 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "E66BF99DB71D382DAB71420402125ABD")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650901203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_650901203;
        // ---------- Original Method ----------
        //return true;
    }

    
}

