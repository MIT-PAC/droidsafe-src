package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Permission;

public final class FilePermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.863 -0400", hash_original_method = "59DC5A74444A3A71F70AFFCCC541A824", hash_generated_method = "1D6ABE28C4E24AF0225E5E4D7FF3E26F")
    public  FilePermission(String path, String actions) {
        super("");
        addTaint(path.getTaint());
        addTaint(actions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.863 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "AA91AAF5DA934DA02D6B73338DF199F1")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_754846047 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_754846047 = null;
        varB4EAC82CA7396A68D541C85D26508E83_754846047.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754846047;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.863 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "D42AA487A8929EFF2959264C44AEF885")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840085767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840085767;
        // ---------- Original Method ----------
        //return true;
    }

    
}

