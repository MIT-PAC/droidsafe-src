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
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class PathDashPathEffect extends PathEffect {
    
        @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate(int native_path, float advance,
                                           float phase, int native_style) {
    return (int)(native_path + advance + phase + native_style);
    }

    /**
     * Dash the drawn path by stamping it with the specified shape. This only
     * applies to drawings when the paint's style is STROKE or STROKE_AND_FILL.
     * If the paint's style is FILL, then this effect is ignored. The paint's
     * strokeWidth does not affect the results.
     * @param shape The path to stamp along
     * @param advance spacing between each stamp of shape
     * @param phase amount to offset before the first shape is stamped
     * @param style how to transform the shape at each position as it is stamped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.297 -0500", hash_original_method = "6D89CA8874EF35472879901FA64C2E5A", hash_generated_method = "5879D45E355D495249CD670791BC6A7B")
    
public PathDashPathEffect(Path shape, float advance, float phase,
                              Style style) {
        native_instance = nativeCreate(shape.ni(), advance, phase,
                                       style.native_style);
    }
    
    public enum Style {
        TRANSLATE(0),   
        ROTATE(1),      
        MORPH(2);       //!< transform each point, and turn lines into curves
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.291 -0500", hash_original_method = "FE5718A34605E3CA4B3E114290B9F7F7", hash_generated_method = "FE5718A34605E3CA4B3E114290B9F7F7")
            
Style(int value) {
            native_style = value;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.293 -0500", hash_original_field = "2075EBCD7FB14ACD06824A3FECFF1C8D", hash_generated_field = "2075EBCD7FB14ACD06824A3FECFF1C8D")

        int native_style;
    }
    
}

