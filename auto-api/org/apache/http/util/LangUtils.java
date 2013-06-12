package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class LangUtils {
    public static final int HASH_SEED = 17;
    public static final int HASH_OFFSET = 37;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.050 -0400", hash_original_method = "BC85A4AC258097A2ABE3F2013DFA665D", hash_generated_method = "A56B0805BD6CA9C830567ADA51309A39")
    @DSModeled(DSC.SAFE)
    private LangUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.050 -0400", hash_original_method = "4BAA05D6FB6EFA3A6E3E32018F906181", hash_generated_method = "9A9656373F7774B0B5757C699BADA23E")
    public static int hashCode(final int seed, final int hashcode) {
        return seed * HASH_OFFSET + hashcode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.050 -0400", hash_original_method = "ABECF8129381FA6304C48F58C00AA3D3", hash_generated_method = "2E89EFEF01F821987D596B929EE8C401")
    public static int hashCode(final int seed, final boolean b) {
        return hashCode(seed, b ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.050 -0400", hash_original_method = "4A4BDE44A209776107FD46A2C36E522F", hash_generated_method = "59A52AD98ADCD6D24BD41157A2FCE4C9")
    public static int hashCode(final int seed, final Object obj) {
        return hashCode(seed, obj != null ? obj.hashCode() : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.050 -0400", hash_original_method = "E808088E5812E77CA3573972FC5F685F", hash_generated_method = "823FC271EEB07F23E492F5906E00709A")
    public static boolean equals(final Object obj1, final Object obj2) {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.050 -0400", hash_original_method = "C34736B9B6546D2994DA44841954C95E", hash_generated_method = "EDA987A3A61E81E1315402793C1CD532")
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

    
}


