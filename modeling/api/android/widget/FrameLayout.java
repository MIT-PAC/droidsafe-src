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

import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

public class FrameLayout extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.196 -0500", hash_original_field = "69CB3F187311FBAD10FED23A88C41309", hash_generated_field = "CA0D915EE28CB56486F6429E0B657866")

    private static final int DEFAULT_CHILD_GRAVITY = Gravity.TOP | Gravity.LEFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.199 -0500", hash_original_field = "44AFCD8DDBB37631367557976155DF2E", hash_generated_field = "CB728A1909AFA591F1BDDDA61ED16AE9")

    @ViewDebug.ExportedProperty(category = "measurement")
    boolean mMeasureAllChildren = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.201 -0500", hash_original_field = "FFE475FB338E6871288D478F63360C0F", hash_generated_field = "A72F2658D002524E6BC635CECCB7A486")

    @ViewDebug.ExportedProperty(category = "drawing")
    private Drawable mForeground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.203 -0500", hash_original_field = "962E045788D6DC5F92A15F09B0CC6F0B", hash_generated_field = "953C36407EBD0C47819218A9CD301BFA")

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingLeft = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.205 -0500", hash_original_field = "DC7468BD1BED53E7991ECA6F4B14DF55", hash_generated_field = "79EB2E4D0FF51658B0F50685CFDA1E31")

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingTop = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.207 -0500", hash_original_field = "66DE0B6225EF6FCC278B367BF785A480", hash_generated_field = "41B6F60E8078397FAD791043A7BFAB92")

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingRight = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.210 -0500", hash_original_field = "E5A2A0CEF6709EB3DDB658289269DD4B", hash_generated_field = "309B58BFECE3A3BF4BE0489CD3C93C7D")

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingBottom = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.212 -0500", hash_original_field = "AEBFB1CC0E9149E5984F190C14B99AED", hash_generated_field = "3B16C2D681BFC370000C0D459ADC9C55")

    private final Rect mSelfBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.215 -0500", hash_original_field = "474A43DE222740BF8AAFC880A3B17B07", hash_generated_field = "4286A209A554CAE5005A36CB62FE41EF")

    private final Rect mOverlayBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.217 -0500", hash_original_field = "D61B405209C6A46304F72DCFEA2F02A5", hash_generated_field = "59774B948EFD2881A9D01560DFF26466")

    @ViewDebug.ExportedProperty(category = "drawing")
    private int mForegroundGravity = Gravity.FILL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.219 -0500", hash_original_field = "FDCAF8B98532929D6F32AEC7747D3086", hash_generated_field = "5A930F164A8718372DFF326C35C33BAD")

    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean mForegroundInPadding = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.221 -0500", hash_original_field = "706D65F3F8C11FED0C0076CC57F566C1", hash_generated_field = "706D65F3F8C11FED0C0076CC57F566C1")

    boolean mForegroundBoundsChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.223 -0500", hash_original_field = "6EECA1C29EFD760FEA6C8BD1FE393EDA", hash_generated_field = "FB43AE3265D5C9BEBAAE4EDDB542A554")
    
    private final ArrayList<View> mMatchParentChildren = new ArrayList<View>(1);
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.226 -0500", hash_original_method = "C65968E2416D9A27DB8533C5F0C75B69", hash_generated_method = "56CE05F95766EDEA6C59829992E21F3F")
    
public FrameLayout(Context context) {
        super(context);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.228 -0500", hash_original_method = "874EEAD1D73BF9A0D133CBC5B921EDD8", hash_generated_method = "FF55F416DA7E947AAABEB5F1EE958BA3")
    
public FrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.231 -0500", hash_original_method = "CEC811F1E2979D1B9B78B672C02AD5D3", hash_generated_method = "2876C720C009F1994502A44CB01D12FF")
    
public FrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout,
                    defStyle, 0);

        mForegroundGravity = a.getInt(
                com.android.internal.R.styleable.FrameLayout_foregroundGravity, mForegroundGravity);

        final Drawable d = a.getDrawable(com.android.internal.R.styleable.FrameLayout_foreground);
        if (d != null) {
            setForeground(d);
        }
        
        if (a.getBoolean(com.android.internal.R.styleable.FrameLayout_measureAllChildren, false)) {
            setMeasureAllChildren(true);
        }

        mForegroundInPadding = a.getBoolean(
                com.android.internal.R.styleable.FrameLayout_foregroundInsidePadding, true);

        a.recycle();
    }

    /**
     * Describes how the foreground is positioned. Defaults to START and TOP.
     *
     * @param foregroundGravity See {@link android.view.Gravity}
     *
     * @attr ref android.R.styleable#FrameLayout_foregroundGravity
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.233 -0500", hash_original_method = "8BC875BA00D5710711DB00A919CACCE0", hash_generated_method = "0F71A9ECB7CAE98192D6DEE3DEEC3003")
    
@android.view.RemotableViewMethod
    public void setForegroundGravity(int foregroundGravity) {
        if (mForegroundGravity != foregroundGravity) {
            if ((foregroundGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
                foregroundGravity |= Gravity.START;
            }

            if ((foregroundGravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
                foregroundGravity |= Gravity.TOP;
            }

            mForegroundGravity = foregroundGravity;

            if (mForegroundGravity == Gravity.FILL && mForeground != null) {
                Rect padding = new Rect();
                if (mForeground.getPadding(padding)) {
                    mForegroundPaddingLeft = padding.left;
                    mForegroundPaddingTop = padding.top;
                    mForegroundPaddingRight = padding.right;
                    mForegroundPaddingBottom = padding.bottom;
                }
            } else {
                mForegroundPaddingLeft = 0;
                mForegroundPaddingTop = 0;
                mForegroundPaddingRight = 0;
                mForegroundPaddingBottom = 0;
            }

            requestLayout();
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.236 -0500", hash_original_method = "10BAAC6631BEDC803E3228221401304B", hash_generated_method = "F61FAD8A9ECAD033A5BDF639AB6EA201")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || (who == mForeground);
    }

    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.238 -0500", hash_original_method = "583607554001D9F198CD54104E44B797", hash_generated_method = "F80F39CA9334FBBF992A837FB306DE61")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mForeground != null) mForeground.jumpToCurrentState();
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.240 -0500", hash_original_method = "D0BDA221075CF616F9E9A9FBE3F4B88A", hash_generated_method = "23CDAF6F76C881F0681B93F68496C590")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mForeground != null && mForeground.isStateful()) {
            mForeground.setState(getDrawableState());
        }
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT},
     * and a height of {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.243 -0500", hash_original_method = "988BCAE6A6E42EFDC25DEBC315DD1190", hash_generated_method = "CADC75AAFCCB94FC4F5E213BEDA2A2F9")
    
@Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    /**
     * Supply a Drawable that is to be rendered on top of all of the child
     * views in the frame layout.  Any padding in the Drawable will be taken
     * into account by ensuring that the children are inset to be placed
     * inside of the padding area.
     * 
     * @param drawable The Drawable to be drawn on top of the children.
     * 
     * @attr ref android.R.styleable#FrameLayout_foreground
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.245 -0500", hash_original_method = "9754375AE3C405E0761F3FE1F1DE65D9", hash_generated_method = "B5826E0BC4CB4DE4E2556EA4F533EE48")
    
public void setForeground(Drawable drawable) {
        if (mForeground != drawable) {
            if (mForeground != null) {
                mForeground.setCallback(null);
                unscheduleDrawable(mForeground);
            }

            mForeground = drawable;
            mForegroundPaddingLeft = 0;
            mForegroundPaddingTop = 0;
            mForegroundPaddingRight = 0;
            mForegroundPaddingBottom = 0;

            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (mForegroundGravity == Gravity.FILL) {
                    Rect padding = new Rect();
                    if (drawable.getPadding(padding)) {
                        mForegroundPaddingLeft = padding.left;
                        mForegroundPaddingTop = padding.top;
                        mForegroundPaddingRight = padding.right;
                        mForegroundPaddingBottom = padding.bottom;
                    }
                }
            }  else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }
    
    /**
     * Returns the drawable used as the foreground of this FrameLayout. The
     * foreground drawable, if non-null, is always drawn on top of the children.
     *
     * @return A Drawable or null if no foreground was set.
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.248 -0500", hash_original_method = "8DDBBCB9F2E6942D000521EEF66C0D86", hash_generated_method = "B8836093CA85C1BE27579C5E3631457B")
    
public Drawable getForeground() {
        return mForeground;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.250 -0500", hash_original_method = "FF3A696BD56D74C1EF72BB71EC65ECEC", hash_generated_method = "630187FC7DD6A6D668815543C727147C")
    
private int getPaddingLeftWithForeground() {
        return mForegroundInPadding ? Math.max(mPaddingLeft, mForegroundPaddingLeft) :
            mPaddingLeft + mForegroundPaddingLeft;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.253 -0500", hash_original_method = "6F38D617A9DA11062600EF5C115E1518", hash_generated_method = "04FEAA4594C7B4A8D2AFD4C4521E22CB")
    
private int getPaddingRightWithForeground() {
        return mForegroundInPadding ? Math.max(mPaddingRight, mForegroundPaddingRight) :
            mPaddingRight + mForegroundPaddingRight;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.255 -0500", hash_original_method = "9A91E9D92D71EE5460C3A06ABC1FBD77", hash_generated_method = "B3406FF80CF764671FA88F0F5517A404")
    
private int getPaddingTopWithForeground() {
        return mForegroundInPadding ? Math.max(mPaddingTop, mForegroundPaddingTop) :
            mPaddingTop + mForegroundPaddingTop;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.257 -0500", hash_original_method = "6BA199CF08BDB4F9A10CECB43AC6A7C1", hash_generated_method = "B8EF8ACEC8788156C8B3506CB86D7DE6")
    
private int getPaddingBottomWithForeground() {
        return mForegroundInPadding ? Math.max(mPaddingBottom, mForegroundPaddingBottom) :
            mPaddingBottom + mForegroundPaddingBottom;
    }

    /**
     * {@inheritDoc}
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.261 -0500", hash_original_method = "5535255FB97D5EBC35FC058E1C30F774", hash_generated_method = "C21EB1396DF9DAB9EB7F658ABB029C9C")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();

        final boolean measureMatchParentChildren =
                MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY ||
                MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY;
        mMatchParentChildren.clear();

        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (mMeasureAllChildren || child.getVisibility() != GONE) {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                maxWidth = Math.max(maxWidth,
                        child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
                maxHeight = Math.max(maxHeight,
                        child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                if (measureMatchParentChildren) {
                    if (lp.width == LayoutParams.MATCH_PARENT ||
                            lp.height == LayoutParams.MATCH_PARENT) {
                        mMatchParentChildren.add(child);
                    }
                }
            }
        }

        // Account for padding too
        maxWidth += getPaddingLeftWithForeground() + getPaddingRightWithForeground();
        maxHeight += getPaddingTopWithForeground() + getPaddingBottomWithForeground();

        // Check against our minimum height and width
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());

        // Check against our foreground's minimum height and width
        final Drawable drawable = getForeground();
        if (drawable != null) {
            maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
            maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
        }

        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));

        count = mMatchParentChildren.size();
        if (count > 1) {
            for (int i = 0; i < count; i++) {
                final View child = mMatchParentChildren.get(i);

                final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int childWidthMeasureSpec;
                int childHeightMeasureSpec;
                
                if (lp.width == LayoutParams.MATCH_PARENT) {
                    childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth() -
                            getPaddingLeftWithForeground() - getPaddingRightWithForeground() -
                            lp.leftMargin - lp.rightMargin,
                            MeasureSpec.EXACTLY);
                } else {
                    childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            getPaddingLeftWithForeground() + getPaddingRightWithForeground() +
                            lp.leftMargin + lp.rightMargin,
                            lp.width);
                }
                
                if (lp.height == LayoutParams.MATCH_PARENT) {
                    childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight() -
                            getPaddingTopWithForeground() - getPaddingBottomWithForeground() -
                            lp.topMargin - lp.bottomMargin,
                            MeasureSpec.EXACTLY);
                } else {
                    childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                            getPaddingTopWithForeground() + getPaddingBottomWithForeground() +
                            lp.topMargin + lp.bottomMargin,
                            lp.height);
                }

                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }
 
    /**
     * {@inheritDoc}
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.265 -0500", hash_original_method = "E7FA69BF1895927226A22DFF32FA5B4F", hash_generated_method = "7D1AF926E83B8728A0E4B048BAB4C51D")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int count = getChildCount();

        final int parentLeft = getPaddingLeftWithForeground();
        final int parentRight = right - left - getPaddingRightWithForeground();

        final int parentTop = getPaddingTopWithForeground();
        final int parentBottom = bottom - top - getPaddingBottomWithForeground();

        mForegroundBoundsChanged = true;
        
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                final int width = child.getMeasuredWidth();
                final int height = child.getMeasuredHeight();

                int childLeft;
                int childTop;

                int gravity = lp.gravity;
                if (gravity == -1) {
                    gravity = DEFAULT_CHILD_GRAVITY;
                }

                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                final int verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;

                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.LEFT:
                        childLeft = parentLeft + lp.leftMargin;
                        break;
                    case Gravity.CENTER_HORIZONTAL:
                        childLeft = parentLeft + (parentRight - parentLeft - width) / 2 +
                        lp.leftMargin - lp.rightMargin;
                        break;
                    case Gravity.RIGHT:
                        childLeft = parentRight - width - lp.rightMargin;
                        break;
                    default:
                        childLeft = parentLeft + lp.leftMargin;
                }

                switch (verticalGravity) {
                    case Gravity.TOP:
                        childTop = parentTop + lp.topMargin;
                        break;
                    case Gravity.CENTER_VERTICAL:
                        childTop = parentTop + (parentBottom - parentTop - height) / 2 +
                        lp.topMargin - lp.bottomMargin;
                        break;
                    case Gravity.BOTTOM:
                        childTop = parentBottom - height - lp.bottomMargin;
                        break;
                    default:
                        childTop = parentTop + lp.topMargin;
                }

                child.layout(childLeft, childTop, childLeft + width, childTop + height);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.267 -0500", hash_original_method = "4AC6B20E904606B8A51AEBBB15006C72", hash_generated_method = "8FF8EF22EB12948F745B962F7B5EBFF3")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mForegroundBoundsChanged = true;
    }

    /**
     * {@inheritDoc}
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.270 -0500", hash_original_method = "6D753914B55367AEDC866ACE8B2692D8", hash_generated_method = "3F08B8E47FEEEE197D9440EEA9077882")
    
@Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (mForeground != null) {
            final Drawable foreground = mForeground;

            if (mForegroundBoundsChanged) {
                mForegroundBoundsChanged = false;
                final Rect selfBounds = mSelfBounds;
                final Rect overlayBounds = mOverlayBounds;

                final int w = mRight-mLeft;
                final int h = mBottom-mTop;

                if (mForegroundInPadding) {
                    selfBounds.set(0, 0, w, h);
                } else {
                    selfBounds.set(mPaddingLeft, mPaddingTop, w - mPaddingRight, h - mPaddingBottom);
                }

                final int layoutDirection = getResolvedLayoutDirection();
                Gravity.apply(mForegroundGravity, foreground.getIntrinsicWidth(),
                        foreground.getIntrinsicHeight(), selfBounds, overlayBounds,
                        layoutDirection);
                foreground.setBounds(overlayBounds);
            }
            
            foreground.draw(canvas);
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.272 -0500", hash_original_method = "89E57DF442BD7C3C4F7FCB93934115A6", hash_generated_method = "B2C91ED4D4FABE7DFB474A8C9CA23BA0")
    
@Override
    public boolean gatherTransparentRegion(Region region) {
        boolean opaque = super.gatherTransparentRegion(region);
        if (region != null && mForeground != null) {
            applyDrawableToTransparentRegion(mForeground, region);
        }
        return opaque;
    }

    /**
     * Sets whether to consider all children, or just those in
     * the VISIBLE or INVISIBLE state, when measuring. Defaults to false.
     *
     * @param measureAll true to consider children marked GONE, false otherwise.
     * Default value is false.
     *
     * @attr ref android.R.styleable#FrameLayout_measureAllChildren
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.275 -0500", hash_original_method = "F157652BCC07DCD3C1A1E63F95BA7504", hash_generated_method = "F93C1EB7BB08DA8FFA2FD9969CB892CD")
    
@android.view.RemotableViewMethod
    public void setMeasureAllChildren(boolean measureAll) {
        mMeasureAllChildren = measureAll;
    }

    /**
     * Determines whether all children, or just those in the VISIBLE or
     * INVISIBLE state, are considered when measuring.
     *
     * @return Whether all children are considered when measuring.
     *
     * @deprecated This method is deprecated in favor of
     * {@link #getMeasureAllChildren() getMeasureAllChildren()}, which was
     * renamed for consistency with
     * {@link #setMeasureAllChildren(boolean) setMeasureAllChildren()}.
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.277 -0500", hash_original_method = "E2FDB5CCBB08727222AD77E37CF74AF8", hash_generated_method = "B5055E338253FEF06E8446C66C57834E")
    
@Deprecated
    public boolean getConsiderGoneChildrenWhenMeasuring() {
        return getMeasureAllChildren();
    }

    /**
     * Determines whether all children, or just those in the VISIBLE or
     * INVISIBLE state, are considered when measuring.
     *
     * @return Whether all children are considered when measuring.
     */
    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.279 -0500", hash_original_method = "52ECFF8459DAA24A15017A3D3C6FE0BF", hash_generated_method = "EEFAB5EBB55BEF305B915C7C7FF71CCE")
    
public boolean getMeasureAllChildren() {
        return mMeasureAllChildren;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.281 -0500", hash_original_method = "A40DD32EC45E4EF4D9BB874732A909D0", hash_generated_method = "8B4D801D33A7A8F021A0A7031DD76513")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new FrameLayout.LayoutParams(getContext(), attrs);        
    }

    @DSComment("GUI/FrameLayout, check callbacks")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.283 -0500", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "FF1288C9953DCFF93F8070857A51FACB")
    
@Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.286 -0500", hash_original_method = "E5E3FCBA546B7CFE2F525BEFE910A396", hash_generated_method = "8E8F0BEBF3E59660E5FA9B2761F7834C")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }
    
    public static class LayoutParams extends MarginLayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.291 -0500", hash_original_field = "017EB0E7305475871AC6C45F0E01F5D9", hash_generated_field = "5DA573F10ADDA42A543DD86752A07C7B")

        public int gravity = -1;

        /**
         * {@inheritDoc}
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.293 -0500", hash_original_method = "8477494D7C126F8EB5E8F09916E06813", hash_generated_method = "4C5925BDD528440CB965B692C5AF6D7A")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            TypedArray a = c.obtainStyledAttributes(attrs, com.android.internal.R.styleable.FrameLayout_Layout);
            gravity = a.getInt(com.android.internal.R.styleable.FrameLayout_Layout_layout_gravity, -1);
            a.recycle();
        }

        /**
         * {@inheritDoc}
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.296 -0500", hash_original_method = "B179862558DB9232A546423CE2E9C45B", hash_generated_method = "5618D547D1ACB51021D28AF4BAF9972B")
        
public LayoutParams(int width, int height) {
            super(width, height);
        }

        /**
         * Creates a new set of layout parameters with the specified width, height
         * and weight.
         *
         * @param width the width, either {@link #MATCH_PARENT},
         *        {@link #WRAP_CONTENT} or a fixed size in pixels
         * @param height the height, either {@link #MATCH_PARENT},
         *        {@link #WRAP_CONTENT} or a fixed size in pixels
         * @param gravity the gravity
         *
         * @see android.view.Gravity
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.299 -0500", hash_original_method = "DAE5F643078D3DA273ACC6BEF5E44EF2", hash_generated_method = "310A384600384362731FCC25D2DE3D0C")
        
public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.gravity = gravity;
        }

        /**
         * {@inheritDoc}
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.302 -0500", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "35FAB65EFD30EE5BC910187CB4DA6F67")
        
public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        /**
         * {@inheritDoc}
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.305 -0500", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "DB62CC5C6AE5A2357A6BB246E8789BF6")
        
public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:14.288 -0500", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "F04F425EAA932DD15846B3A8E447FBE2")
    
@Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void childHasTransientStateChanged(View view,
            boolean hasTransientState) {
        // TODO Auto-generated method stub
        
    }
}

