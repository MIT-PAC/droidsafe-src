package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class AllPermission extends Permission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.883 -0400", hash_original_method = "09A3FF901F6A2CF2EED3134C2EAC6A79", hash_generated_method = "55EBFC859296AF62F7B911EAC43CE8F0")
    public  AllPermission(String name, String actions) {
        super("");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.883 -0400", hash_original_method = "8D01BAC0F6DD766A4223D24BBCA0691E", hash_generated_method = "DA55DE73D4BB8B2A20910679600CE1D4")
    public  AllPermission() {
        super("");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.887 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "DEF8DA4E30420A770D0F0426E705C15B")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_483760774 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_483760774 = null;
        varB4EAC82CA7396A68D541C85D26508E83_483760774.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_483760774;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.900 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "AD7FA309555DCCA4A7F6EB44E36BAA02")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572817355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572817355;
        // ---------- Original Method ----------
        //return true;
    }

    
}

