package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Method;
import libcore.util.EmptyArray;

public final class Void {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.683 -0400", hash_original_method = "CD8BC0E717D271B8A5F5646E1CE2D7A5", hash_generated_method = "824764433804841F8B24CCE495EAD381")
    @DSModeled(DSC.SAFE)
    private Void() {
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

    
    public static final Class<Void> TYPE = lookupType();
}

