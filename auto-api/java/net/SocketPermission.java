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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.899 -0400", hash_original_method = "7248A57D7E8DCE007CEC41DE038EC206", hash_generated_method = "A3D124ACE4F077E1D9511E625BAD7335")
    public  SocketPermission(String host, String action) {
        super("");
        addTaint(host.getTaint());
        addTaint(action.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.901 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "57EF4AA86BAEA98ECE5BE7D701FB1F8C")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1531123173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1531123173 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1531123173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1531123173;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.902 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "1721D6D54BB97711F2E99AFF854D32D4")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161261612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161261612;
        // ---------- Original Method ----------
        //return true;
    }

    
}

