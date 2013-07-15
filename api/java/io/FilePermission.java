package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Permission;

public final class FilePermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.623 -0400", hash_original_method = "59DC5A74444A3A71F70AFFCCC541A824", hash_generated_method = "E8079AF0636A74EB86728A5D631EEA07")
    public  FilePermission(String path, String actions) {
        super("");
        addTaint(actions.getTaint());
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.625 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "B446E61D83215F93454BB4FADADD2629")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_222397642 =         null;
        var540C13E9E156B687226421B24F2DF178_222397642.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_222397642;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.631 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "2CEB255CC5DA0568CE8BCA64C780B818")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_171199377 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1478805866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1478805866;
        // ---------- Original Method ----------
        //return true;
    }

    
}

