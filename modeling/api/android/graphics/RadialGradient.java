/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class RadialGradient extends Shader {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate1(float x, float y, float radius,
            int colors[], float positions[], int tileMode) {
        float temp = (x + y + radius + tileMode);
        positions[0] = (colors[0] + colors.getTaintInt() + temp);
        positions.addTaint(colors.getTaint());
        return positions.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate2(float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return (int)((int)x + (int)y + radius + color0 + color1 + tileMode);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativePostCreate1(int native_shader, float x, float y, float radius,
            int colors[], float positions[], int tileMode) {

        float temp = (x + y + radius + tileMode);
        positions[0] = (colors[0] + colors.getTaintInt() + temp);
        positions.addTaint(colors.getTaint());
        return positions.getTaintInt();

    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativePostCreate2(int native_shader, float x, float y, float radius,
            int color0, int color1, int tileMode) {
        return (int)((int)x + (int)y + radius + color0 + color1 + tileMode);
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

