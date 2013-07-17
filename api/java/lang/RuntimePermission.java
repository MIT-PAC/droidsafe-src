package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.BasicPermission;
import java.security.Permission;

public final class RuntimePermission extends BasicPermission {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.585 -0400", hash_original_method = "4B2115E5C37ED723471172D5C8F80B46", hash_generated_method = "152F2835EE644AC6F0BD82FFF888E07E")
    public  RuntimePermission(String permissionName) {
        super("");
        addTaint(permissionName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.585 -0400", hash_original_method = "E2D7FAA6FF83E30EF411D458EDB8F08D", hash_generated_method = "FAFA1A47962316FEAD3E99C5FBE31749")
    public  RuntimePermission(String name, String actions) {
        super("", "");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.585 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "653A7B28DBF4EF67930E10DCBA67FEEA")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1073300702 =         null;
        var540C13E9E156B687226421B24F2DF178_1073300702.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1073300702;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.586 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "B5BC7C0188162752BFDC8BE7E4CDE913")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_142882645 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564970189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564970189;
        // ---------- Original Method ----------
        //return true;
    }

    
}

