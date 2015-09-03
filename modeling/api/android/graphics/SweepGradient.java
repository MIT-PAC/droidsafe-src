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

public class SweepGradient extends Shader {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate1(float x, float y, int colors[], float positions[]) {
        positions[0] = (colors[0]  + x + y); 
        positions.addTaint( x + y + colors[0] + colors.getTaintInt());
        return positions.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate2(float x, float y, int color0, int color1) {
        return (int)(x + y + color1 + color0);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativePostCreate1(int native_shader, float cx, float cy,
            int[] colors, float[] positions) {

        float temp = (native_shader + cx + cy);
        positions.addTaint(temp);
        colors.addTaint(temp);
        return (int)(native_shader + cx + cy + colors.getTaintInt() + positions.getTaintInt());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativePostCreate2(int native_shader, float cx, float cy,
            int color0, int color1) {
        return (int)(native_shader + cx + cy + color0 + color1);
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
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.024 -0500", hash_original_method = "1126924377A1AF5E908D05CFB28B37FF", hash_generated_method = "4CF24E78B398EE3E254FEEF5DF20DD61")
    
public SweepGradient(float cx, float cy, int color0, int color1) {
        native_instance = nativeCreate2(cx, cy, color0, color1);
        native_shader = nativePostCreate2(native_instance, cx, cy, color0, color1);
    }
    
}

