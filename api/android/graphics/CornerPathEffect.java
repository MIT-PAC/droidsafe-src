package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class CornerPathEffect extends PathEffect {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate(float radius) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317499148 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317499148;
    }

    /**
     * Transforms geometries that are drawn (either STROKE or FILL styles) by
     * replacing any sharp angles between line segments into rounded angles of
     * the specified radius.
     * @param radius Amount to round sharp angles between line segments.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.046 -0500", hash_original_method = "1A6DA6E79B72785E2BC38681BFBED33C", hash_generated_method = "40C9F7359A121A96A8F5C41EE4F64F86")
    
public CornerPathEffect(float radius) {
        native_instance = nativeCreate(radius);
    }
    
}

