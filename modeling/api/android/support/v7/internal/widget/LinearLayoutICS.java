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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @hide
 */
public class LinearLayoutICS extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.806 -0400", hash_original_field = "21A2B4E635B02DE3A8DFECE4AA9F6A02", hash_generated_field = "001A474F66D5883929C126962A9BC4F7")

    private static final int SHOW_DIVIDER_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.808 -0400", hash_original_field = "83900B28DFF569B2150EC91C47B4702D", hash_generated_field = "9B141D2F4D77BCBAE93F2F8C47CC7206")

    private static final int SHOW_DIVIDER_BEGINNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.811 -0400", hash_original_field = "5DD8CCF0EFC92980FB5EDA457B109763", hash_generated_field = "63406AD6F2833FB99ABC6995C6A2BB53")

    private static final int SHOW_DIVIDER_MIDDLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.813 -0400", hash_original_field = "3BB0A6F5679029320550BF3D05B95F10", hash_generated_field = "0975D89B4E0E54F8E759517609700D86")

    private static final int SHOW_DIVIDER_END = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.815 -0400", hash_original_field = "3837E71D24376BABDBC6EE7CD182AABB", hash_generated_field = "D73292FD603C307DCBB538076F31C80F")

    private  Drawable mDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.818 -0400", hash_original_field = "597BC3499B057C8706FE3F8982F46EF2", hash_generated_field = "5BCE586F78F70C393B0BFF3471A83208")

    private  int mDividerWidth, mDividerHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.820 -0400", hash_original_field = "4942877A1F996F87A9355AD13582E61B", hash_generated_field = "1313B8BA9906A262CF63E7F9653AB503")

    private  int mShowDividers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.822 -0400", hash_original_field = "A85C191D0DE66B2E0F1EF12653C3612C", hash_generated_field = "8407F81B00C5F4756EECF88D42950A05")

    private  int mDividerPadding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.826 -0400", hash_original_method = "33A68D9277C5BDA152B0107BBAA17BE3", hash_generated_method = "AF8143BF0760C33CF3856D39F9A5D3A6")
    
public LinearLayoutICS(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LinearLayoutICS);

        mDivider = a.getDrawable(R.styleable.LinearLayoutICS_divider);
        if (mDivider != null) {
            mDividerWidth = mDivider.getIntrinsicWidth();
            mDividerHeight = mDivider.getIntrinsicHeight();
        } else {
            mDividerHeight = mDividerWidth = 0;
        }

        mShowDividers = a.getInt(R.styleable.LinearLayoutICS_showDividers, SHOW_DIVIDER_NONE);
        mDividerPadding = a.getDimensionPixelSize(R.styleable.LinearLayoutICS_dividerPadding, 0);

        a.recycle();

        setWillNotDraw(mDivider == null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.828 -0400", hash_original_method = "0C913462126427A4134EECB9432CF10B", hash_generated_method = "8C9390965F0AF325754A532A0ADF58E3")
    
public int getSupportDividerWidth() {
        return mDividerWidth;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.831 -0400", hash_original_method = "42F4973FEEAA63E467AEC6AF3F58C9D1", hash_generated_method = "4BD4D143F356B15B9808336977402B25")
    
@Override
    protected void onDraw(Canvas canvas) {
        if (mDivider == null) {
            return;
        }

        if (getOrientation() == VERTICAL) {
            drawSupportDividersVertical(canvas);
        } else {
            drawSupportDividersHorizontal(canvas);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.834 -0400", hash_original_method = "3696FC25D94D6988022EACB22384243D", hash_generated_method = "4EF2220F3304F1E20CBA0BE995E8201A")
    
@Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {

        if (mDivider != null) {
            final int childIndex = indexOfChild(child);
            final int count = getChildCount();
            final LayoutParams params = (LayoutParams) child.getLayoutParams();

            // To display the dividers in-between the child views, we modify their margins
            // to create space.
            if (getOrientation() == VERTICAL) {
                if (hasSupportDividerBeforeChildAt(childIndex)) {
                    params.topMargin = mDividerHeight;
                } else if (childIndex == count - 1 && hasSupportDividerBeforeChildAt(count)) {
                    params.bottomMargin = mDividerHeight;
                }
            } else {
                if (hasSupportDividerBeforeChildAt(childIndex)) {
                    params.leftMargin = mDividerWidth;
                } else if (childIndex == count - 1 && hasSupportDividerBeforeChildAt(count)) {
                    params.rightMargin = mDividerWidth;
                }
            }
        }

        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed,
                parentHeightMeasureSpec, heightUsed);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.837 -0400", hash_original_method = "EDE8FB80E830B12698730C9DB4611F11", hash_generated_method = "EDE8FB80E830B12698730C9DB4611F11")
    
void drawSupportDividersVertical(Canvas canvas) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child != null && child.getVisibility() != GONE &&
                    hasSupportDividerBeforeChildAt(i)) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                drawSupportHorizontalDivider(canvas, child.getTop() - lp.topMargin);
            }
        }

        if (hasSupportDividerBeforeChildAt(count)) {
            final View child = getChildAt(count - 1);
            int bottom = 0;
            if (child == null) {
                bottom = getHeight() - getPaddingBottom() - mDividerHeight;
            } else {
                bottom = child.getBottom();
            }
            drawSupportHorizontalDivider(canvas, bottom);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.839 -0400", hash_original_method = "210F617D0E8448517AEE54F27B30D75D", hash_generated_method = "210F617D0E8448517AEE54F27B30D75D")
    
void drawSupportDividersHorizontal(Canvas canvas) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child != null && child.getVisibility() != GONE &&
                    hasSupportDividerBeforeChildAt(i)) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                drawSupportVerticalDivider(canvas, child.getLeft() - lp.leftMargin);
            }
        }

        if (hasSupportDividerBeforeChildAt(count)) {
            final View child = getChildAt(count - 1);
            int right = 0;
            if (child == null) {
                right = getWidth() - getPaddingRight() - mDividerWidth;
            } else {
                right = child.getRight();
            }
            drawSupportVerticalDivider(canvas, right);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.842 -0400", hash_original_method = "3121C4E5C42C6D14E3DCC662B7CB6D59", hash_generated_method = "3121C4E5C42C6D14E3DCC662B7CB6D59")
    
void drawSupportHorizontalDivider(Canvas canvas, int top) {
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, top,
                getWidth() - getPaddingRight() - mDividerPadding, top + mDividerHeight);
        mDivider.draw(canvas);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.844 -0400", hash_original_method = "D47715CC902B99CA03ABB3CEF0124B21", hash_generated_method = "D47715CC902B99CA03ABB3CEF0124B21")
    
void drawSupportVerticalDivider(Canvas canvas, int left) {
        mDivider.setBounds(left, getPaddingTop() + mDividerPadding,
                left + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
    }

    /**
     * Determines where to position dividers between children.
     *
     * @param childIndex Index of child to check for preceding divider
     * @return true if there should be a divider before the child at childIndex
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.847 -0400", hash_original_method = "B68F83839432088DEBC23D7BB0EB72B3", hash_generated_method = "EBBA55875E8D704BFD90E4E01B3377FC")
    
protected boolean hasSupportDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            return (mShowDividers & SHOW_DIVIDER_BEGINNING) != 0;
        } else if (childIndex == getChildCount()) {
            return (mShowDividers & SHOW_DIVIDER_END) != 0;
        } else if ((mShowDividers & SHOW_DIVIDER_MIDDLE) != 0) {
            boolean hasVisibleViewBefore = false;
            for (int i = childIndex - 1; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != GONE) {
                    hasVisibleViewBefore = true;
                    break;
                }
            }
            return hasVisibleViewBefore;
        }
        return false;
    }

}
