package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class AllPermission extends Permission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.926 -0400", hash_original_method = "09A3FF901F6A2CF2EED3134C2EAC6A79", hash_generated_method = "E22C358DE3BB8BF580C61BABF15F3F8C")
    public  AllPermission(String name, String actions) {
        super("");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.926 -0400", hash_original_method = "8D01BAC0F6DD766A4223D24BBCA0691E", hash_generated_method = "DA55DE73D4BB8B2A20910679600CE1D4")
    public  AllPermission() {
        super("");
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.926 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "BD2070387C78DAB5F7DE87AF08326B81")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1792339307 =         null;
        var540C13E9E156B687226421B24F2DF178_1792339307.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1792339307;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.926 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "BD2DFEAF688671A9BB75CAE5D9BE412E")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_726913871 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109901184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109901184;
        // ---------- Original Method ----------
        //return true;
    }

    
}

