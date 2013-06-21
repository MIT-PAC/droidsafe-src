package com.google.android.collect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;

public class Maps {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.137 -0400", hash_original_method = "0EFA0DA8E131A0392B983E5153C2755E", hash_generated_method = "0EFA0DA8E131A0392B983E5153C2755E")
        public Maps ()
    {
    }


        public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    
}

