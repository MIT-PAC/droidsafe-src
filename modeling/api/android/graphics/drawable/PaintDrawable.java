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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xmlpull.v1.XmlPullParser;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;

public class PaintDrawable extends ShapeDrawable {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.206 -0500", hash_original_method = "35894A2FD0CE190FC6DCE9F697221056", hash_generated_method = "EB239EA7E3A1C7969BCE1D083693AE7F")
    
public PaintDrawable() {
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.208 -0500", hash_original_method = "51DC0DAE916B0D4375C00567B21115B1", hash_generated_method = "66B5361B947C282388A1F9D3FC07FE15")
    
public PaintDrawable(int color) {
        getPaint().setColor(color);
    }
    
    /**
     * Specify radius for the corners of the rectangle. If this is > 0, then the
     * drawable is drawn in a round-rectangle, rather than a rectangle.
     * @param radius the radius for the corners of the rectangle
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.210 -0500", hash_original_method = "29D687C39F10D3A684C3799EDBB48EFB", hash_generated_method = "6F40AA935AB00B671F6C53CB6B863A7E")
    
public void setCornerRadius(float radius) {
        float[] radii = null;
        if (radius > 0) {
            radii = new float[8];
            for (int i = 0; i < 8; i++) {
                radii[i] = radius;
            }
        }
        setCornerRadii(radii);
    }
    
    /**
     * Specify radii for each of the 4 corners. For each corner, the array
     * contains 2 values, [X_radius, Y_radius]. The corners are ordered
     * top-left, top-right, bottom-right, bottom-left
     * @param radii the x and y radii of the corners
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.212 -0500", hash_original_method = "458539BDB31F16A86FED0FC05CC292D2", hash_generated_method = "83779F66102631002C7FEC9547C188FF")
    
public void setCornerRadii(float[] radii) {
        if (radii == null) {
            if (getShape() != null) {
                setShape(null);
            }
        } else {
            setShape(new RoundRectShape(radii, null, null));
        }
        invalidateSelf();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.215 -0500", hash_original_method = "B0701038A568952969848F330DE56979", hash_generated_method = "006E78934D7584D196C67FAA0E072C15")
    
@Override
    protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
                                 AttributeSet attrs) {
        if (name.equals("corners")) {
            TypedArray a = r.obtainAttributes(attrs,
                                        com.android.internal.R.styleable.DrawableCorners);
            int radius = a.getDimensionPixelSize(
                                com.android.internal.R.styleable.DrawableCorners_radius, 0);
            setCornerRadius(radius);
            
            // now check of they have any per-corner radii
            
            int topLeftRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.DrawableCorners_topLeftRadius, radius);
            int topRightRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.DrawableCorners_topRightRadius, radius);
            int bottomLeftRadius = a.getDimensionPixelSize(
                com.android.internal.R.styleable.DrawableCorners_bottomLeftRadius, radius);
            int bottomRightRadius = a.getDimensionPixelSize(
                com.android.internal.R.styleable.DrawableCorners_bottomRightRadius, radius);

            if (topLeftRadius != radius || topRightRadius != radius ||
                    bottomLeftRadius != radius || bottomRightRadius != radius) {
                setCornerRadii(new float[] {
                               topLeftRadius, topLeftRadius,
                               topRightRadius, topRightRadius,
                               bottomLeftRadius, bottomLeftRadius,
                               bottomRightRadius, bottomRightRadius
                               });
            }
            a.recycle();
            return true;
        }
        return super.inflateTag(name, r, parser, attrs);
    }
    
}

