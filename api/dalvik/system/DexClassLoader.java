package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;

public class DexClassLoader extends BaseDexClassLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.640 -0400", hash_original_method = "0E54801097DD3CB2DCA8F1C7661C6431", hash_generated_method = "9EB1E9BB8017CE870F7360833904BB9B")
    public  DexClassLoader(String dexPath, String optimizedDirectory,
            String libraryPath, ClassLoader parent) {
        super(dexPath, new File(optimizedDirectory), libraryPath, parent);
        addTaint(parent.getTaint());
        addTaint(libraryPath.getTaint());
        addTaint(optimizedDirectory.getTaint());
        addTaint(dexPath.getTaint());
        // ---------- Original Method ----------
    }

    
}

