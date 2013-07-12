package org.apache.http.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class LangUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.119 -0400", hash_original_method = "BC85A4AC258097A2ABE3F2013DFA665D", hash_generated_method = "0E018D83B4375A17854C491F261E03A8")
    private  LangUtils() {
        
    }

    
        public static int hashCode(final int seed, final int hashcode) {
        return seed * HASH_OFFSET + hashcode;
    }

    
        public static int hashCode(final int seed, final boolean b) {
        return hashCode(seed, b ? 1 : 0);
    }

    
        public static int hashCode(final int seed, final Object obj) {
        return hashCode(seed, obj != null ? obj.hashCode() : 0);
    }

    
        public static boolean equals(final Object obj1, final Object obj2) {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }

    
        public static boolean equals(final Object[] a1, final Object[] a2) {
        if (a1 == null) {
            if (a2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (a2 != null && a1.length == a2.length) {
                for (int i = 0; i < a1.length; i++) {
                    if (!equals(a1[i], a2[i])) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.121 -0400", hash_original_field = "3BA42A17CF3E87F4D3AF7868A72A2240", hash_generated_field = "25B02BFACC7EA9B56C306C172298DCD8")

    public static final int HASH_SEED = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.121 -0400", hash_original_field = "F4D62A4DEF335A94D9905EA2BBF28FC9", hash_generated_field = "E21D1BF64F0022132172445B51E097C8")

    public static final int HASH_OFFSET = 37;
}

