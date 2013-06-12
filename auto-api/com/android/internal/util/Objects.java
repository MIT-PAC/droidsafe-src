package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class Objects {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.069 -0400", hash_original_method = "F296275000E1AA53C7B464F5FDA7A4B5", hash_generated_method = "F1FE59F254185FB0421C417ADE74E86C")
    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.083 -0400", hash_original_method = "5906F045128166A9E56FF6FDE6E49CCD", hash_generated_method = "88A9EA0CDDBC5F37AABAE9F35B6F717C")
    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }

    
}


