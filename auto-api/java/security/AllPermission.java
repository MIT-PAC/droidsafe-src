package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class AllPermission extends Permission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.102 -0400", hash_original_method = "09A3FF901F6A2CF2EED3134C2EAC6A79", hash_generated_method = "55EBFC859296AF62F7B911EAC43CE8F0")
    public  AllPermission(String name, String actions) {
        super("");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.104 -0400", hash_original_method = "8D01BAC0F6DD766A4223D24BBCA0691E", hash_generated_method = "DA55DE73D4BB8B2A20910679600CE1D4")
    public  AllPermission() {
        super("");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.105 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "011EED8576B35F37CF5943DD89620527")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1277029672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1277029672 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1277029672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277029672;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.105 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "F362A99C840BF040B1BCB1218A75DE31")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749599483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749599483;
        // ---------- Original Method ----------
        //return true;
    }

    
}

