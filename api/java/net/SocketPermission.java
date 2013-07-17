package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.security.Permission;

public final class SocketPermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.529 -0400", hash_original_method = "7248A57D7E8DCE007CEC41DE038EC206", hash_generated_method = "1D4130C0E2424B38086F08FD46737C23")
    public  SocketPermission(String host, String action) {
        super("");
        addTaint(action.getTaint());
        addTaint(host.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.529 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "080BDCA04A20C068C450E05C7DE58902")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1980573921 =         null;
        var540C13E9E156B687226421B24F2DF178_1980573921.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1980573921;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.529 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "C9FB74805DEE88C8E69C7E8E2602FFAD")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1132194770 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827702378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827702378;
        // ---------- Original Method ----------
        //return true;
    }

    
}

