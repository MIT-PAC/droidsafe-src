package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PathClassLoader extends BaseDexClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.269 -0400", hash_original_method = "6258BA858F35AE5BE1B00C9FC6B3D2A7", hash_generated_method = "029E2B021A3726E4FECB0F3F5656801B")
    @DSModeled(DSC.BAN)
    public PathClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, null, null, parent);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(dexPath);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.269 -0400", hash_original_method = "48893E9E3C874E5568FFBA369F8C7532", hash_generated_method = "87E785F01B064F4A561B4100E1C08F89")
    @DSModeled(DSC.BAN)
    public PathClassLoader(String dexPath, String libraryPath,
            ClassLoader parent) {
        super(dexPath, null, libraryPath, parent);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(dexPath);
        dsTaint.addTaint(libraryPath);
        // ---------- Original Method ----------
    }

    
}

