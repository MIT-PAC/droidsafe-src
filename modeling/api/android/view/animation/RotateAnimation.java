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


package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;


public class RotateAnimation extends Animation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.155 -0500", hash_original_field = "179D120EA21717CC6A9EB6675A09E18B", hash_generated_field = "F09C4FDC9F6C8A1D9CB749F5F6E5EB01")

    private float mFromDegrees;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.158 -0500", hash_original_field = "D04BBDA5B46FF274C82326C147187C72", hash_generated_field = "A38FA34A09FF84CE5329199DB304846C")

    private float mToDegrees;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.160 -0500", hash_original_field = "35319F0004C491BB80D5F1742219F20C", hash_generated_field = "EC74AC06B5691B47A1AD5BBF6B15ECE3")


    private int mPivotXType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.162 -0500", hash_original_field = "15AA19B564953B2E92DF57FC0E988FB4", hash_generated_field = "C9A99ED0A354C0C74E5E29006BD9ED31")

    private int mPivotYType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.164 -0500", hash_original_field = "DAF37BA52463794A2FC8056AA3E095AA", hash_generated_field = "AF755B8408C979E36D20FBC0A81E876D")

    private float mPivotXValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.166 -0500", hash_original_field = "53742362BBA0945C7FD67A0E0C9C324E", hash_generated_field = "E9B533B02C8C2E2321EBFE6D7C3F6C50")

    private float mPivotYValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.169 -0500", hash_original_field = "5936761CCB9106C6D82A6436A57EC343", hash_generated_field = "D5598B4EF8A215EC3A51B2F400B272F3")


    private float mPivotX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.171 -0500", hash_original_field = "6CE864DEEFD86BFE91AA6D818A7F55C0", hash_generated_field = "0971400EDE5A41D2136C532E521A2E57")

    private float mPivotY;

    /**
     * Constructor used when a RotateAnimation is loaded from a resource.
     * 
     * @param context Application context to use
     * @param attrs Attribute set from which to read values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.174 -0500", hash_original_method = "B7950BF16E5DA5C93A26B94851E70CDD", hash_generated_method = "52EEDE385CFC08A689EFB3013B63E7DC")
    
public RotateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.RotateAnimation);

        mFromDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateAnimation_fromDegrees, 0.0f);
        mToDegrees = a.getFloat(com.android.internal.R.styleable.RotateAnimation_toDegrees, 0.0f);

        Description d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.RotateAnimation_pivotX));
        mPivotXType = d.type;
        mPivotXValue = d.value;

        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.RotateAnimation_pivotY));
        mPivotYType = d.type;
        mPivotYValue = d.value;

        a.recycle();
    }

    /**
     * Constructor to use when building a RotateAnimation from code.
     * Default pivotX/pivotY point is (0,0).
     * 
     * @param fromDegrees Rotation offset to apply at the start of the
     *        animation.
     * 
     * @param toDegrees Rotation offset to apply at the end of the animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.177 -0500", hash_original_method = "F93E828358C80C590EEB448A5EA60EF3", hash_generated_method = "0AE8262F364252F9E65D18B2EE829D77")
    
public RotateAnimation(float fromDegrees, float toDegrees) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mPivotX = 0.0f;
        mPivotY = 0.0f;
    }

    /**
     * Constructor to use when building a RotateAnimation from code
     * 
     * @param fromDegrees Rotation offset to apply at the start of the
     *        animation.
     * 
     * @param toDegrees Rotation offset to apply at the end of the animation.
     * 
     * @param pivotX The X coordinate of the point about which the object is
     *        being rotated, specified as an absolute number where 0 is the left
     *        edge.
     * @param pivotY The Y coordinate of the point about which the object is
     *        being rotated, specified as an absolute number where 0 is the top
     *        edge.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.180 -0500", hash_original_method = "19A86326052CAD17DE162EF74120BA6A", hash_generated_method = "96FE3A541D2FC01403C17BE4E0AA0B1D")
    
public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;

        mPivotXType = ABSOLUTE;
        mPivotYType = ABSOLUTE;
        mPivotXValue = pivotX;
        mPivotYValue = pivotY;
    }

    /**
     * Constructor to use when building a RotateAnimation from code
     * 
     * @param fromDegrees Rotation offset to apply at the start of the
     *        animation.
     * 
     * @param toDegrees Rotation offset to apply at the end of the animation.
     * 
     * @param pivotXType Specifies how pivotXValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param pivotXValue The X coordinate of the point about which the object
     *        is being rotated, specified as an absolute number where 0 is the
     *        left edge. This value can either be an absolute number if
     *        pivotXType is ABSOLUTE, or a percentage (where 1.0 is 100%)
     *        otherwise.
     * @param pivotYType Specifies how pivotYValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param pivotYValue The Y coordinate of the point about which the object
     *        is being rotated, specified as an absolute number where 0 is the
     *        top edge. This value can either be an absolute number if
     *        pivotYType is ABSOLUTE, or a percentage (where 1.0 is 100%)
     *        otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.183 -0500", hash_original_method = "72ECE06422A744A3901DF4DB74918F78", hash_generated_method = "2253DE5FC74E79DEE25AE7A01044CE79")
    
public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
            int pivotYType, float pivotYValue) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;

        mPivotXValue = pivotXValue;
        mPivotXType = pivotXType;
        mPivotYValue = pivotYValue;
        mPivotYType = pivotYType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.186 -0500", hash_original_method = "194AFADB87C10F3B1916BACFE93A5B2C", hash_generated_method = "33504093F3FEBC967B213DA69D033CEB")
    
@Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        float scale = getScaleFactor();
        
        if (mPivotX == 0.0f && mPivotY == 0.0f) {
            t.getMatrix().setRotate(degrees);
        } else {
            t.getMatrix().setRotate(degrees, mPivotX * scale, mPivotY * scale);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:57.188 -0500", hash_original_method = "45493CF0F005891678EBD20A791168F1", hash_generated_method = "AAE094287E8A90269C5F776FD3311007")
    
@Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
    }

    
}

