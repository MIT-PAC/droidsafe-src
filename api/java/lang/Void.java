package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Method;

import libcore.util.EmptyArray;





public final class Void {
    // Note: Void.TYPE can't be set to "void.class", since *that* is
    // defined to be "java.lang.Void.TYPE";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.173 -0500", hash_original_method = "7E53958CBB184FD7233970E2C31DD404", hash_generated_method = "C3A9E1C7C72BAAA0669E7E85385E207C")
    
@SuppressWarnings("unchecked")
    private static Class<Void> lookupType() {
        try {
            Method method = Runnable.class.getMethod("run", EmptyArray.CLASS);
            return (Class<Void>) method.getReturnType();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.170 -0500", hash_original_field = "6F8EC39E5E5D2BDC209EECC2D9F1929A", hash_generated_field = "BDCEB7646E33E9181F674146F1170597")

    public static final Class<Void> TYPE = lookupType();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.176 -0500", hash_original_method = "CD8BC0E717D271B8A5F5646E1CE2D7A5", hash_generated_method = "596E76E5C23C1135C1628068130DAAA6")
    
private Void() {
    }
}

