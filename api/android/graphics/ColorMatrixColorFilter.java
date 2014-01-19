package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class ColorMatrixColorFilter extends ColorFilter {
    
    private static int nativeColorMatrixFilter(float[] array) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207688702 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207688702;
    }
    
    private static int nColorMatrixFilter(int nativeFilter, float[] array) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221975373 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221975373;
    }
    /**
     * Create a colorfilter that transforms colors through a 4x5 color matrix.
     *
     * @param matrix 4x5 matrix used to transform colors. It is copied into
     *               the filter, so changes made to the matrix after the filter
     *               is constructed will not be reflected in the filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.294 -0500", hash_original_method = "92B387BCC5497E96DCF4BCCE85C5A491", hash_generated_method = "E783C853CB2DBC2528530EE61AC0DE37")
    
public ColorMatrixColorFilter(ColorMatrix matrix) {
        final float[] colorMatrix = matrix.getArray();
        native_instance = nativeColorMatrixFilter(colorMatrix);
        nativeColorFilter = nColorMatrixFilter(native_instance, colorMatrix);
    }

    /**
    * Create a colorfilter that transforms colors through a 4x5 color matrix.
     *
     * @param array array of floats used to transform colors, treated as a 4x5
     *              matrix. The first 20 entries of the array are copied into
     *              the filter. See ColorMatrix.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.297 -0500", hash_original_method = "2D0E3EA51658F535A9A5BDBE5AE078D8", hash_generated_method = "CE89804102EE885972F99614C40A8362")
    
public ColorMatrixColorFilter(float[] array) {
        if (array.length < 20) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_instance = nativeColorMatrixFilter(array);
        nativeColorFilter = nColorMatrixFilter(native_instance, array);
    }
    
}

