package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class RadialGradient extends Shader {
    
    private static int nativeCreate1(float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativeCreate2(float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativePostCreate1(int native_shader, float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static int nativePostCreate2(int native_shader, float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return DSUtils.UNKNOWN_INT;
    }

	/**	Create a shader that draws a radial gradient given the center and radius.
        @param x        The x-coordinate of the center of the radius
        @param y        The y-coordinate of the center of the radius
		@param radius   Must be positive. The radius of the circle for this gradient
        @param colors   The colors to be distributed between the center and edge of the circle
        @param positions May be NULL. The relative position of
                        each corresponding color in the colors array. If this is NULL,
                        the the colors are distributed evenly between the center and edge of the circle.
        @param  tile    The Shader tiling mode
	*/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.742 -0500", hash_original_method = "AAECBEFB54B4ACCFD5CA83A095E16729", hash_generated_method = "919F1080491EF19B5BE76556767A792F")
    
public RadialGradient(float x, float y, float radius,
                          int colors[], float positions[], TileMode tile) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        if (colors.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        if (positions != null && colors.length != positions.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        }
        native_instance = nativeCreate1(x, y, radius, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x, y, radius, colors, positions,
                tile.nativeInt);
    }

	/**	Create a shader that draws a radial gradient given the center and radius.
        @param x        The x-coordinate of the center of the radius
        @param y        The y-coordinate of the center of the radius
		@param radius   Must be positive. The radius of the circle for this gradient
        @param color0   The color at the center of the circle.
        @param color1   The color at the edge of the circle.
        @param tile     The Shader tiling mode
	*/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.745 -0500", hash_original_method = "967A1FFF1D78A377DCB1552FAD26240E", hash_generated_method = "B387EDD658B0C0EA1C4E8CB091822B2C")
    
public RadialGradient(float x, float y, float radius,
                          int color0, int color1, TileMode tile) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        native_instance = nativeCreate2(x, y, radius, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x, y, radius, color0, color1,
                tile.nativeInt);
    }
    
}

