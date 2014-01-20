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
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.522 -0500", hash_original_method = "E21158B8192A6A62E47E5DB23E5C8298", hash_generated_method = "C0B1919E289E1D1CD148CF74042E6B33")
    
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
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.524 -0500", hash_original_method = "138E7D6C6B15213658AC13EABF129E3A", hash_generated_method = "A9BFE4F88C6D703CA9290EE77B65E0C4")
    
public LinearGradient(float x0, float y0, float x1, float y1,
                          int color0, int color1, TileMode tile) {
        native_instance = nativeCreate2(x0, y0, x1, y1, color0, color1, tile.nativeInt);
        native_shader = nativePostCreate2(native_instance, x0, y0, x1, y1, color0, color1,
                tile.nativeInt);
    }

	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.528 -0500", hash_original_method = "B94A77D14C5B8671FB729EA28F4EAAD5", hash_generated_method = "D0F325390B0EC6A2BB0E7BCA81E91771")
    
    private int nativeCreate1(float x0, float y0, float x1, float y1,
                int colors[], float positions[], int tileMode){
    	//Formerly a native method
    	addTaint(x0);
    	addTaint(y0);
    	addTaint(x1);
    	addTaint(y1);
    	addTaint(colors.getTaint());
    	addTaint(positions.getTaint());
    	addTaint(tileMode);
    	return getTaintInt();
    }

	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.532 -0500", hash_original_method = "CCD3C7044708751014C9FDE6E03EC148", hash_generated_method = "97A46A89528DF4AAEDF635E546FA6A0A")
    
    private int nativeCreate2(float x0, float y0, float x1, float y1,
                int color0, int color1, int tileMode){
    	//Formerly a native method
    	addTaint(x0);
    	addTaint(y0);
    	addTaint(x1);
    	addTaint(y1);
    	addTaint(color0);
    	addTaint(color1);
    	addTaint(tileMode);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.536 -0500", hash_original_method = "3D4FC89E238038D87C8D1AA41C910405", hash_generated_method = "94488BC5223A1862048AC3E8637F2B4A")
    
    private int nativePostCreate1(int native_shader, float x0, float y0, float x1, float y1,
                int colors[], float positions[], int tileMode){
    	//Formerly a native method
    	addTaint(native_shader);
    	addTaint(x0);
    	addTaint(y0);
    	addTaint(x1);
    	addTaint(y1);
    	addTaint(colors.getTaint());
    	addTaint(positions.getTaint());
    	addTaint(tileMode);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.539 -0500", hash_original_method = "9C29B9E72B1A16A8D3A2370F81F87105", hash_generated_method = "56A83CD8B20F47EA60DD56782E16B5C9")
    
    private int nativePostCreate2(int native_shader, float x0, float y0, float x1, float y1,
                int color0, int color1, int tileMode){
    	//Formerly a native method
    	addTaint(native_shader);
    	addTaint(x0);
    	addTaint(y0);
    	addTaint(x1);
    	addTaint(y1);
    	addTaint(color0);
    	addTaint(color1);
    	addTaint(tileMode);
    	return getTaintInt();
    }
    
}

