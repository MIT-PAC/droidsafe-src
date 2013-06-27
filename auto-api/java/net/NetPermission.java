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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.540 -0400", hash_original_method = "AF713E88B3605596EC00E48857DBF46B", hash_generated_method = "22029A9060BD82AE8B431C814816C00A")
    public  NetPermission(String name) {
        super("");
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.541 -0400", hash_original_method = "342AA26435633C300D2029E398212CA8", hash_generated_method = "412B3069D7370994E058AA7931226586")
    public  NetPermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.541 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "CDB77A539B984E265A33FC323B9AA0F2")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1704703584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1704703584 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1704703584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1704703584;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.542 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "EBBAE7DCD098696EA1E5707B2D3917FD")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1004902299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1004902299;
        // ---------- Original Method ----------
        //return true;
    }

    
}

