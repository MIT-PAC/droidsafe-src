package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Objects {

    /**
     * Returns true if two possibly-null objects are equal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.006 -0500", hash_original_method = "F296275000E1AA53C7B464F5FDA7A4B5", hash_generated_method = "F1FE59F254185FB0421C417ADE74E86C")
    
public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.009 -0500", hash_original_method = "970ADDE5DABB38D7F42BDDA2D6B8B600", hash_generated_method = "07A63DF93C922328842C8FA9A58D6EAB")
    
public static int hashCode(Object o) {
        return (o == null) ? 0 : o.hashCode();
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.003 -0500", hash_original_method = "C158E75DF9842308E7411AE8FDFF45DA", hash_generated_method = "0C4D37AD1C252B023A4081E65D3CD182")
    
private Objects() {}
    
}

