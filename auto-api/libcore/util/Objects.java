package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Objects {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.312 -0400", hash_original_method = "C158E75DF9842308E7411AE8FDFF45DA", hash_generated_method = "C61A67785C5C32A70AED7267E09F32D9")
    private  Objects() {
        // ---------- Original Method ----------
    }

    
        public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    
        public static int hashCode(Object o) {
        return (o == null) ? 0 : o.hashCode();
    }

    
}

