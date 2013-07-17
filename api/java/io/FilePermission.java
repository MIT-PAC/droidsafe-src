package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Permission;

public final class FilePermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.952 -0400", hash_original_method = "59DC5A74444A3A71F70AFFCCC541A824", hash_generated_method = "E8079AF0636A74EB86728A5D631EEA07")
    public  FilePermission(String path, String actions) {
        super("");
        addTaint(actions.getTaint());
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.952 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "EFE98BAD9467B3087E1D1A02CDABCDD6")
    @Override
    public String getActions() {
String var540C13E9E156B687226421B24F2DF178_1894834076 =         null;
        var540C13E9E156B687226421B24F2DF178_1894834076.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1894834076;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.953 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "D567F1C4C6A25033F7DC51DDE8B22E83")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1704120897 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270393412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270393412;
        // ---------- Original Method ----------
        //return true;
    }

    
}

