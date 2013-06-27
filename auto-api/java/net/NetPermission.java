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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.468 -0400", hash_original_method = "AF713E88B3605596EC00E48857DBF46B", hash_generated_method = "22029A9060BD82AE8B431C814816C00A")
    public  NetPermission(String name) {
        super("");
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.468 -0400", hash_original_method = "342AA26435633C300D2029E398212CA8", hash_generated_method = "412B3069D7370994E058AA7931226586")
    public  NetPermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.469 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "2E9D23F9803A39A2443CF75091BF282D")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_278647258 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_278647258 = null;
        varB4EAC82CA7396A68D541C85D26508E83_278647258.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_278647258;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.469 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "95009C2A8AFFAAB6286BF6B22578B5CF")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297893653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297893653;
        // ---------- Original Method ----------
        //return true;
    }

    
}

