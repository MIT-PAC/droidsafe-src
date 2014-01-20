package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class AvoidXfermode extends Xfermode {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate(int opColor, int tolerance,
                                           int nativeMode) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613288083 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613288083;
    }
    
    /** This xfermode draws, or doesn't draw, based on the destination's
     * distance from an op-color.
     *
     * There are two modes, and each mode interprets a tolerance value.
     *
     * Avoid: In this mode, drawing is allowed only on destination pixels that
     * are different from the op-color.
     * Tolerance near 0: avoid any colors even remotely similar to the op-color
     * Tolerance near 255: avoid only colors nearly identical to the op-color
     
     * Target: In this mode, drawing only occurs on destination pixels that
     * are similar to the op-color
     * Tolerance near 0: draw only on colors that are nearly identical to the op-color
     * Tolerance near 255: draw on any colors even remotely similar to the op-color
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.813 -0500", hash_original_method = "293A98A7728721725813AFA29BD3A029", hash_generated_method = "1A9288452227195915AFBE2EAC7AB1E4")
    
public AvoidXfermode(int opColor, int tolerance, Mode mode) {
        if (tolerance < 0 || tolerance > 255) {
            throw new IllegalArgumentException("tolerance must be 0..255");
        }
        native_instance = nativeCreate(opColor, tolerance, mode.nativeInt);
    }
    
    public enum Mode {
        AVOID   (0),    
        TARGET  (1);    //!< draw only on top of the opColor
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.807 -0500", hash_original_method = "787C81E539A7EA8A7036FAB09EA6039E", hash_generated_method = "787C81E539A7EA8A7036FAB09EA6039E")
            
Mode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.809 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
}

