package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.BasicPermission;
import java.security.Permission;





public final class NetPermission extends BasicPermission {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.824 -0400", hash_original_method = "AF713E88B3605596EC00E48857DBF46B", hash_generated_method = "22029A9060BD82AE8B431C814816C00A")
    public  NetPermission(String name) {
        super("");
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.825 -0400", hash_original_method = "342AA26435633C300D2029E398212CA8", hash_generated_method = "99DD392E001019940A45BBDD05BF76CE")
    public  NetPermission(String name, String actions) {
        super("", "");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.825 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "527A429B53BE2E6E427A0F7857EC7ECF")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_2140012497 =         null;
        var540C13E9E156B687226421B24F2DF178_2140012497.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2140012497;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.825 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "DC7B5748DB18F4E2B9030109404B54B6")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_470458701 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691685355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691685355;
        // ---------- Original Method ----------
        //return true;
    }

    
}

