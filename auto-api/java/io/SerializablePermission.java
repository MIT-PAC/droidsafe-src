package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.BasicPermission;
import java.security.Permission;

public final class SerializablePermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.028 -0400", hash_original_method = "059CB3A47A80651C55222CAAC7D4899E", hash_generated_method = "8977553150B52363546EFB53D9BA8F9C")
    public  SerializablePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.028 -0400", hash_original_method = "817285F0A88BCE83A5485E1175378F5A", hash_generated_method = "D576FB1CFBCFDE1CCB816D5038C7D32E")
    public  SerializablePermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.030 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "C89855D7E49168C3373CF796D92D26CF")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1939221823 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1939221823 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1939221823.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1939221823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.030 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "9709B7971C39C71C39F292D80441DFDF")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049223436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049223436;
        
        
    }

    
}

