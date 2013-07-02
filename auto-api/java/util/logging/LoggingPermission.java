package java.util.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Guard;
import java.security.Permission;

public final class LoggingPermission extends BasicPermission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.547 -0400", hash_original_method = "49660D4D996C1CD70562D31B56A71F27", hash_generated_method = "5DFB6A03F554DD955546DDD62149463D")
    public  LoggingPermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.550 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "9F031A5201F92DCE4A0AF9867DF8F9D3")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1675733310 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1675733310 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1675733310.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1675733310;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.551 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "3FC6F36DE7B402151D4D36DE6A26CD1A")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_642417869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_642417869;
        
        
    }

    
}

