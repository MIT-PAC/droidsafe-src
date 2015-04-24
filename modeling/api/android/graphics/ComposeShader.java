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

public class ComposeShader extends Shader {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate1(int native_shaderA, int native_shaderB,
            int native_mode) {
        return native_shaderA + native_shaderB + native_mode;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate2(int native_shaderA, int native_shaderB,
            int porterDuffMode) {
        return native_shaderA + native_shaderB + porterDuffMode; 
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativePostCreate1(int native_shader, int native_skiaShaderA,
            int native_skiaShaderB, int native_mode) {
        return native_shader + native_skiaShaderA + native_skiaShaderB + native_mode;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativePostCreate2(int native_shader, int native_skiaShaderA,
            int native_skiaShaderB, int porterDuffMode) {
        return native_shader + native_skiaShaderA + native_skiaShaderB;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.871 -0500", hash_original_field = "27E69BFD969C4FEF73690310ABD89FC4", hash_generated_field = "9D1A193A171A566C28715B3DF9829B6D")

    @SuppressWarnings({"UnusedDeclaration"})
    private  Shader mShaderA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.874 -0500", hash_original_field = "09FD3D72269AD2B4025D8BB544F1EF34", hash_generated_field = "0BC17BE1D67AE4FB7B6930A577FEA85A")

    @SuppressWarnings({"UnusedDeclaration"})
    private  Shader mShaderB;

    /** Create a new compose shader, given shaders A, B, and a combining mode.
        When the mode is applied, it will be given the result from shader A as its
        "dst", and the result from shader B as its "src".
        @param shaderA  The colors from this shader are seen as the "dst" by the mode
        @param shaderB  The colors from this shader are seen as the "src" by the mode
        @param mode     The mode that combines the colors from the two shaders. If mode
                        is null, then SRC_OVER is assumed.
    */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.876 -0500", hash_original_method = "54479FEAF5918A2D0015420E3AF1868D", hash_generated_method = "70A6BE8E028F56F9FFA10E60669FE620")
    
public ComposeShader(Shader shaderA, Shader shaderB, Xfermode mode) {
        mShaderA = shaderA;
        mShaderB = shaderB;
        native_instance = nativeCreate1(shaderA.native_instance, shaderB.native_instance,
                (mode != null) ? mode.native_instance : 0);
        if (mode instanceof PorterDuffXfermode) {
            PorterDuff.Mode pdMode = ((PorterDuffXfermode) mode).mode;
            native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                    shaderB.native_shader, pdMode != null ? pdMode.nativeInt : 0);
        } else {
            native_shader = nativePostCreate1(native_instance, shaderA.native_shader,
                    shaderB.native_shader, mode != null ? mode.native_instance : 0);
        }
    }

    /** Create a new compose shader, given shaders A, B, and a combining PorterDuff mode.
        When the mode is applied, it will be given the result from shader A as its
        "dst", and the result from shader B as its "src".
        @param shaderA  The colors from this shader are seen as the "dst" by the mode
        @param shaderB  The colors from this shader are seen as the "src" by the mode
        @param mode     The PorterDuff mode that combines the colors from the two shaders.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.879 -0500", hash_original_method = "6DA3793B1F4C3B72942152784A23C545", hash_generated_method = "A66B37B2F23E2B67959A8F5C71554A72")
    
public ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode) {
        mShaderA = shaderA;
        mShaderB = shaderB;
        native_instance = nativeCreate2(shaderA.native_instance, shaderB.native_instance,
                mode.nativeInt);
        native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                shaderB.native_shader, mode.nativeInt);
    }
    
}

