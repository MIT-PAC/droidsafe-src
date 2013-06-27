package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PathClassLoader extends BaseDexClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.963 -0400", hash_original_method = "6258BA858F35AE5BE1B00C9FC6B3D2A7", hash_generated_method = "423A7A614C059B61AAE8881FD3A75337")
    public  PathClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, null, null, parent);
        addTaint(dexPath.getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.963 -0400", hash_original_method = "48893E9E3C874E5568FFBA369F8C7532", hash_generated_method = "58F146743E954705CDE5CEFFB74E605C")
    public  PathClassLoader(String dexPath, String libraryPath,
            ClassLoader parent) {
        super(dexPath, null, libraryPath, parent);
        addTaint(dexPath.getTaint());
        addTaint(libraryPath.getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
}

