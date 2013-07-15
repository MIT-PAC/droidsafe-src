package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.BasicPermission;
import java.security.Permission;

public final class RuntimePermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.321 -0400", hash_original_method = "4B2115E5C37ED723471172D5C8F80B46", hash_generated_method = "152F2835EE644AC6F0BD82FFF888E07E")
    public  RuntimePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.321 -0400", hash_original_method = "E2D7FAA6FF83E30EF411D458EDB8F08D", hash_generated_method = "FAFA1A47962316FEAD3E99C5FBE31749")
    public  RuntimePermission(String name, String actions) {
        super("", "");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.322 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "FA7527EA861289A532080D87D5AA6A5E")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_2015637563 =         null;
        var540C13E9E156B687226421B24F2DF178_2015637563.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2015637563;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.322 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "A965153DE5A7FE8AC267ED372FDA9915")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1688022152 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711904597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711904597;
        // ---------- Original Method ----------
        //return true;
    }

    
}

