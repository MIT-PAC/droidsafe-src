package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.BasicPermission;
import java.security.Permission;

public final class SerializablePermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.967 -0400", hash_original_method = "059CB3A47A80651C55222CAAC7D4899E", hash_generated_method = "8977553150B52363546EFB53D9BA8F9C")
    public  SerializablePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.967 -0400", hash_original_method = "817285F0A88BCE83A5485E1175378F5A", hash_generated_method = "75BDE36F4A2A093A55A72DA182214573")
    public  SerializablePermission(String name, String actions) {
        super("", "");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.968 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "A5003EA72F15CBC7D2B52214B7FFB78B")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1791004587 =         null;
        var540C13E9E156B687226421B24F2DF178_1791004587.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1791004587;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.968 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "5C311B249386E485472F30D55C7DA1B5")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1037970755 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803596172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803596172;
        // ---------- Original Method ----------
        //return true;
    }

    
}

