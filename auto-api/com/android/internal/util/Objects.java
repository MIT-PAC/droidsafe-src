package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class Objects {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.736 -0400", hash_original_method = "0DFC3E3C1BDDD21FB9D828F51E15D955", hash_generated_method = "0DFC3E3C1BDDD21FB9D828F51E15D955")
        public Objects ()
    {
    }


        public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    
        public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }

    
}

