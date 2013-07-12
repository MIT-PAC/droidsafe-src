package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.security.Permission;

public final class SocketPermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.310 -0400", hash_original_method = "7248A57D7E8DCE007CEC41DE038EC206", hash_generated_method = "1D4130C0E2424B38086F08FD46737C23")
    public  SocketPermission(String host, String action) {
        super("");
        addTaint(action.getTaint());
        addTaint(host.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.311 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "C79B065A1222F9A3BC2D14D655264364")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1561332639 =         null;
        var540C13E9E156B687226421B24F2DF178_1561332639.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1561332639;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.311 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "893410A5FA998F27EBE6C53FE79AE3FA")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1560606982 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218010641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_218010641;
        
        
    }

    
}

