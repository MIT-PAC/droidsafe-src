package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Method;
import libcore.util.EmptyArray;

public final class Void {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.815 -0400", hash_original_method = "CD8BC0E717D271B8A5F5646E1CE2D7A5", hash_generated_method = "824764433804841F8B24CCE495EAD381")
    private  Void() {
        // ---------- Original Method ----------
    }

    
        @SuppressWarnings("unchecked")
    private static Class<Void> lookupType() {
        try {
            Method method = Runnable.class.getMethod("run", EmptyArray.CLASS);
            return (Class<Void>) method.getReturnType();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.815 -0400", hash_original_field = "8CA08A4D5F410CC809B54293F79FABFA", hash_generated_field = "BDCEB7646E33E9181F674146F1170597")

    public static final Class<Void> TYPE = lookupType();
}

