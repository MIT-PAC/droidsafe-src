package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.BasicPermission;
import java.security.Permission;

public final class NetPermission extends BasicPermission {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.853 -0400", hash_original_method = "AF713E88B3605596EC00E48857DBF46B", hash_generated_method = "22029A9060BD82AE8B431C814816C00A")
    public  NetPermission(String name) {
        super("");
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.854 -0400", hash_original_method = "342AA26435633C300D2029E398212CA8", hash_generated_method = "99DD392E001019940A45BBDD05BF76CE")
    public  NetPermission(String name, String actions) {
        super("", "");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.854 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "7DF8D11D95E851D48B5F029A9215A5BA")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_423366120 =         null;
        var540C13E9E156B687226421B24F2DF178_423366120.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_423366120;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.862 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "24213AE6C90AF4D4C58B99CBAFF2EEE3")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1051475253 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899026157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899026157;
        
        
    }

    
}

