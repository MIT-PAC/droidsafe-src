package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class SweepGradient extends Shader {
    
    private static int nativeCreate1(float x, float y, int colors[], float positions[]) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativeCreate2(float x, float y, int color0, int color1) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativePostCreate1(int native_shader, float cx, float cy,
            int[] colors, float[] positions) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativePostCreate2(int native_shader, float cx, float cy,
            int color0, int color1) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * A subclass of Shader that draws a sweep gradient around a center point.
     *
     * @param cx       The x-coordinate of the center
     * @param cy       The y-coordinate of the center
     * @param colors   The colors to be distributed between around the center.
     *                 There must be at least 2 colors in the array.
     * @param positions May be NULL. The relative position of
     *                 each corresponding color in the colors array, beginning
     *                 with 0 and ending with 1.0. If the values are not
     *                 monotonic, the drawing may produce unexpected results.
     *                 If positions is NULL, then the colors are automatically
     *                 spaced evenly.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.021 -0500", hash_original_method = "64A53BB5A652BD9568EA8C5A648F5375", hash_generated_method = "5BEBAF1A7FAB96AAD815EDC1971E51C1")
    
public SweepGradient(float cx, float cy,
                         int colors[], float positions[]) {
        if (colors.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        if (positions != null && colors.length != positions.length) {
            throw new IllegalArgumentException(
                        "color and position arrays must be of equal length");
        }
        native_instance = nativeCreate1(cx, cy, colors, positions);
        native_shader = nativePostCreate1(native_instance, cx, cy, colors, positions);
    }

    /**
     * A subclass of Shader that draws a sweep gradient around a center point.
     *
     * @param cx       The x-coordinate of the center
     * @param cy       The y-coordinate of the center
     * @param color0   The color to use at the start of the sweep
     * @param color1   The color to use at the end of the sweep
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.024 -0500", hash_original_method = "1126924377A1AF5E908D05CFB28B37FF", hash_generated_method = "4CF24E78B398EE3E254FEEF5DF20DD61")
    
public SweepGradient(float cx, float cy, int color0, int color1) {
        native_instance = nativeCreate2(cx, cy, color0, color1);
        native_shader = nativePostCreate2(native_instance, cx, cy, color0, color1);
    }
    
}

