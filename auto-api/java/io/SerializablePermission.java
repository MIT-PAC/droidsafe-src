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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.849 -0400", hash_original_method = "059CB3A47A80651C55222CAAC7D4899E", hash_generated_method = "8977553150B52363546EFB53D9BA8F9C")
    public  SerializablePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.849 -0400", hash_original_method = "817285F0A88BCE83A5485E1175378F5A", hash_generated_method = "D576FB1CFBCFDE1CCB816D5038C7D32E")
    public  SerializablePermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.850 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "02F4FB495040D2B1921DD2BDC324F0E5")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1874052328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1874052328 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1874052328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1874052328;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.850 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "3AE2339B9AA95839904058D88FE2AA62")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746525072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746525072;
        // ---------- Original Method ----------
        //return true;
    }

    
}

