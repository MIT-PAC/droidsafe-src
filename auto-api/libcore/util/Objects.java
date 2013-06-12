package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class Objects {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.540 -0400", hash_original_method = "C158E75DF9842308E7411AE8FDFF45DA", hash_generated_method = "77812B689190660EC27E3D334E158E56")
    @DSModeled(DSC.SAFE)
    private Objects() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.540 -0400", hash_original_method = "F296275000E1AA53C7B464F5FDA7A4B5", hash_generated_method = "F1FE59F254185FB0421C417ADE74E86C")
    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.540 -0400", hash_original_method = "970ADDE5DABB38D7F42BDDA2D6B8B600", hash_generated_method = "07A63DF93C922328842C8FA9A58D6EAB")
    public static int hashCode(Object o) {
        return (o == null) ? 0 : o.hashCode();
    }

    
}


