package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Guard;
import java.security.Permission;

public final class LoggingPermission extends BasicPermission implements Guard, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.343 -0400", hash_original_method = "49660D4D996C1CD70562D31B56A71F27", hash_generated_method = "744F24E6611D0653BF74F97C773F7339")
    public  LoggingPermission(String name, String actions) {
        super("", "");
        addTaint(actions.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.343 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "47F66278D074DBCDA97820628869F924")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_130709236 =         null;
        var540C13E9E156B687226421B24F2DF178_130709236.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_130709236;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.343 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "E92CA2F1A6B9260B9CA6359F9E48464A")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_2146244708 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632149836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632149836;
        // ---------- Original Method ----------
        //return true;
    }

    
}

