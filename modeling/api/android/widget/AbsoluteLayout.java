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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class AbsoluteLayout extends ViewGroup {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.350 -0500", hash_original_method = "5954FDB18E14B0E14B8E157FD227CC59", hash_generated_method = "A7C45DA430A7B42C1B84E6A031A7B645")
    
public AbsoluteLayout(Context context) {
        super(context);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.352 -0500", hash_original_method = "B433FCC2495B1A37134076C038FD96A0", hash_generated_method = "08FD635A9C3578232FE0538924C4248E")
    
public AbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.355 -0500", hash_original_method = "153087F001B91B4A777A0B839E669EB1", hash_generated_method = "2A1FAF1BD1202129629A928A9283D870")
    
public AbsoluteLayout(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.357 -0500", hash_original_method = "54761EA789A74CBDB221271FE56469B7", hash_generated_method = "E7611AB8CAE9AE8E995ADFFA7F36EF69")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();

        int maxHeight = 0;
        int maxWidth = 0;

        // Find out how big everyone wants to be
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        // Find rightmost and bottom-most child
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                int childRight;
                int childBottom;

                AbsoluteLayout.LayoutParams lp
                        = (AbsoluteLayout.LayoutParams) child.getLayoutParams();

                childRight = lp.x + child.getMeasuredWidth();
                childBottom = lp.y + child.getMeasuredHeight();

                maxWidth = Math.max(maxWidth, childRight);
                maxHeight = Math.max(maxHeight, childBottom);
            }
        }

        // Account for padding too
        maxWidth += mPaddingLeft + mPaddingRight;
        maxHeight += mPaddingTop + mPaddingBottom;

        // Check against minimum height and width
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
                resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT},
     * a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}
     * and with the coordinates (0, 0).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.360 -0500", hash_original_method = "383A977BED79B1C96577C54DB1D6FA6E", hash_generated_method = "69C6657C787052D1277E810061E51E86")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.363 -0500", hash_original_method = "CB6E73396546FC793F7584A7D119E869", hash_generated_method = "531A45C525E4DC6D5B260730B8B79298")
    
@Override
    protected void onLayout(boolean changed, int l, int t,
            int r, int b) {
        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {

                AbsoluteLayout.LayoutParams lp =
                        (AbsoluteLayout.LayoutParams) child.getLayoutParams();

                int childLeft = mPaddingLeft + lp.x;
                int childTop = mPaddingTop + lp.y;
                child.layout(childLeft, childTop,
                        childLeft + child.getMeasuredWidth(),
                        childTop + child.getMeasuredHeight());

            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.365 -0500", hash_original_method = "D0490D2D5B80C9DD3F55B366503982A5", hash_generated_method = "E2FCB38942F31C54BDBF6CFEF8DB47B2")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new AbsoluteLayout.LayoutParams(getContext(), attrs);
    }

    // Override to allow type-checking of LayoutParams. 
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.367 -0500", hash_original_method = "E121C7CF679CE7DED988221EA3AFEDE0", hash_generated_method = "4368BF6C9449F4440D3B3E8FD84AF06B")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof AbsoluteLayout.LayoutParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.369 -0500", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "F04F425EAA932DD15846B3A8E447FBE2")
    
@Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.371 -0500", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "FF1288C9953DCFF93F8070857A51FACB")
    
@Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    public static class LayoutParams extends ViewGroup.LayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.376 -0500", hash_original_field = "3ECDEC351FCE13CBA8A59E38409B3C9E", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

        public int x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.378 -0500", hash_original_field = "93D19118DABD6AC5BACF335A34537CEB", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

        public int y;

        /**
         * Creates a new set of layout parameters with the specified width,
         * height and location.
         *
         * @param width the width, either {@link #MATCH_PARENT},
                  {@link #WRAP_CONTENT} or a fixed size in pixels
         * @param height the height, either {@link #MATCH_PARENT},
                  {@link #WRAP_CONTENT} or a fixed size in pixels
         * @param x the X location of the child
         * @param y the Y location of the child
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.381 -0500", hash_original_method = "82F5809A27EA13ABE8A026DC04B05568", hash_generated_method = "452ADD8EF65A743CE8FA60E253163698")
        
public LayoutParams(int width, int height, int x, int y) {
            super(width, height);
            this.x = x;
            this.y = y;
        }

        /**
         * Creates a new set of layout parameters. The values are extracted from
         * the supplied attributes set and context. The XML attributes mapped
         * to this set of layout parameters are:
         *
         * <ul>
         *   <li><code>layout_x</code>: the X location of the child</li>
         *   <li><code>layout_y</code>: the Y location of the child</li>
         *   <li>All the XML attributes from
         *   {@link android.view.ViewGroup.LayoutParams}</li>
         * </ul>
         *
         * @param c the application environment
         * @param attrs the set of attributes from which to extract the layout
         *              parameters values
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.384 -0500", hash_original_method = "4740233E31DF015F5CE2A2D25007B918", hash_generated_method = "64B72C41FA5D3EDA06CB5C69505EFF3E")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.AbsoluteLayout_Layout);
            x = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_x, 0);
            y = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.AbsoluteLayout_Layout_layout_y, 0);
            a.recycle();
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.386 -0500", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "35FAB65EFD30EE5BC910187CB4DA6F67")
        
public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.389 -0500", hash_original_method = "E94865805207BE74BD20D805DD96D818", hash_generated_method = "226B1EB2EFDCD5B3555CC829D2DEE32C")
        
@Override
        public String debug(String output) {
            return output + "Absolute.LayoutParams={width="
                    + sizeToString(width) + ", height=" + sizeToString(height)
                    + " x=" + x + " y=" + y + "}";
        }
        
    }
    
}

