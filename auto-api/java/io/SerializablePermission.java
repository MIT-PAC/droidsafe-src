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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.712 -0400", hash_original_method = "059CB3A47A80651C55222CAAC7D4899E", hash_generated_method = "8977553150B52363546EFB53D9BA8F9C")
    public  SerializablePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.712 -0400", hash_original_method = "817285F0A88BCE83A5485E1175378F5A", hash_generated_method = "D576FB1CFBCFDE1CCB816D5038C7D32E")
    public  SerializablePermission(String name, String actions) {
        super("", "");
        addTaint(name.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.712 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "151B2381D106D3D0679A9D5CC9228C6C")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_44751146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_44751146 = null;
        varB4EAC82CA7396A68D541C85D26508E83_44751146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44751146;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.712 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "4128DD84E06B12AE574296060BF67B02")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222255068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222255068;
        // ---------- Original Method ----------
        //return true;
    }

    
}

