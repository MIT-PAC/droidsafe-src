package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class LinearGradient extends Shader {
	/**	Create a shader that draws a linear gradient along a line.
        @param x0           The x-coordinate for the start of the gradient line
        @param y0           The y-coordinate for the start of the gradient line
        @param x1           The x-coordinate for the end of the gradient line
        @param y1           The y-coordinate for the end of the gradient line
        @param  colors      The colors to be distributed along the gradient line
        @param  positions   May be null. The relative positions [0..1] of
                            each corresponding color in the colors array. If this is null,
                            the the colors are distributed evenly along the gradient line.
        @param  tile        The Shader tiling mode
	*/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.922 -0500", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "C0B1919E289E1D1CD148CF74042E6B33")
    public LinearGradient(float x0, float y0, float x1, float y1,
                          int colors[], float positions[], TileMode tile) {
        if (colors.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        if (positions != null && colors.length != positions.length) {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        }
        native_instance = nativeCreate1(x0, y0, x1, y1, colors, positions, tile.nativeInt);
        native_shader = nativePostCreate1(native_instance, x0, y0, x1, y1, colors, positions,
                tile.nativeInt);
    }

	/**	Create a shader that draws a linear gradient along a line.
        @param x0       The x-coordinate for the start of the gradient line
        @param y0       The y-coordinate for the start of the gradient line
        @param x1       The x-coordinate for the end of the gradient line
        @param y1       The y-coordinate for the end of the gradient line
        @param  color0  The color at the start of the gradient line.
        @param  color1  The color at the end of the gradient line.
        @param  tile    The Shader tiling mode
	*/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.923 -0500", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "A9BFE4F88C6D703CA9290EE77B65E0C4")
    public LinearGradient(float x0, float y0, float x1, float y1,
                          int color0, int color1, TileMode tile) {
        native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                tile.nativeInt);
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:39.759 -0500", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "D0F325390B0EC6A2BB0E7BCA81E91771")
    private native int nativeCreate1(float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode);
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:39.761 -0500", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "97A46A89528DF4AAEDF635E546FA6A0A")
    private native int nativeCreate2(float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:39.762 -0500", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "94488BC5223A1862048AC3E8637F2B4A")
    private native int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
            int colors[], float positions[], int tileMode);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:39.764 -0500", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "56A83CD8B20F47EA60DD56782E16B5C9")
    private native int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
            int color0, int color1, int tileMode);

    
}

