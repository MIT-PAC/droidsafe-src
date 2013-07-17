package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PathClassLoader extends BaseDexClassLoader {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.813 -0400", hash_original_method = "6258BA858F35AE5BE1B00C9FC6B3D2A7", hash_generated_method = "46593A9F5FFFC37FC8D9DF009479B52A")
    public  PathClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, null, null, parent);
        addTaint(parent.getTaint());
        addTaint(dexPath.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.813 -0400", hash_original_method = "48893E9E3C874E5568FFBA369F8C7532", hash_generated_method = "B8A78930F0DDC2CC58CF5D73F38285A8")
    public  PathClassLoader(String dexPath, String libraryPath,
            ClassLoader parent) {
        super(dexPath, null, libraryPath, parent);
        addTaint(parent.getTaint());
        addTaint(libraryPath.getTaint());
        addTaint(dexPath.getTaint());
        // ---------- Original Method ----------
    }

    
}

