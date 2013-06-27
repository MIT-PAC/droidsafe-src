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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.118 -0400", hash_original_method = "49660D4D996C1CD70562D31B56A71F27", hash_generated_method = "5DFB6A03F554DD955546DDD62149463D")
    public  LoggingPermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.119 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "13887CF7B3BB5FE194D41CD4A1FB12B6")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_69662357 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_69662357 = null;
        varB4EAC82CA7396A68D541C85D26508E83_69662357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_69662357;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.119 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "1C93D7C226117B9F55295D01A5DFC376")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300573124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300573124;
        // ---------- Original Method ----------
        //return true;
    }

    
}

