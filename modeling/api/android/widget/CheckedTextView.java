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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.android.internal.R;

public class CheckedTextView extends TextView implements Checkable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.345 -0500", hash_original_field = "73791D998AED7A27216E6912B00269F9", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.332 -0500", hash_original_field = "2095822BEB25A977611B30C48AE7794D", hash_generated_field = "5B3EF9355FF9C7031B185F0E3C8A05A3")

    private boolean mChecked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.334 -0500", hash_original_field = "F6CDCDDCAFD3C2BB1559252A8F667AF0", hash_generated_field = "56D9A5B5697E1794767C7AC768CAFE0C")

    private int mCheckMarkResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.337 -0500", hash_original_field = "6E4D05290BF9452D0F6C42EC3E581056", hash_generated_field = "C10062341C3645D6C852294631265BE5")

    private Drawable mCheckMarkDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.339 -0500", hash_original_field = "44FFF8E594601B15DBBEAEC30973434F", hash_generated_field = "79F756395206E1EEB26019E0D87C14AB")

    private int mBasePadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.341 -0500", hash_original_field = "B642F7B3F18EDCFEA925FAD92F4B2C4A", hash_generated_field = "66183B11F152F514120E9BC4BB1F25CE")

    private int mCheckMarkWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.343 -0500", hash_original_field = "745B3AACC524453B0FE162E692BC051E", hash_generated_field = "C623C63EB2FF5407B90C6E9E1CE126E8")

    private boolean mNeedRequestlayout;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.348 -0500", hash_original_method = "D98B8279143D8DB42D11ECE4C668DA6C", hash_generated_method = "60B4C5D328B63E776B25C5B794E14856")
    
public CheckedTextView(Context context) {
        this(context, null);
    }

    @DSComment("CheckedTextView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.351 -0500", hash_original_method = "36596E5D7755B07B6F1DB63ABEA718CD", hash_generated_method = "1D0CEB24B3000B72361CD7EB9709FE25")
    
public CheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.354 -0500", hash_original_method = "B58B3AE8D95B44872F8433BF803A9C37", hash_generated_method = "9B7B6ACD5749F41A993994BA38B9308F")
    
public CheckedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.CheckedTextView, defStyle, 0);

        Drawable d = a.getDrawable(R.styleable.CheckedTextView_checkMark);
        if (d != null) {
            setCheckMarkDrawable(d);
        }

        boolean checked = a.getBoolean(R.styleable.CheckedTextView_checked, false);
        setChecked(checked);

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.356 -0500", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "A3C4A23427194F6EB8A02F7BC58C147C")
    
public void toggle() {
        setChecked(!mChecked);
    }

    @DSComment("CheckedTextView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.358 -0500", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "6384B5CB9EB85B7EDD0B1D464AE9B509")
    
@ViewDebug.ExportedProperty
    public boolean isChecked() {
        return mChecked;
    }

    /**
     * <p>Changes the checked state of this text view.</p>
     *
     * @param checked true to check the text, false to uncheck it
     */
    @DSComment("CheckedTextView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.360 -0500", hash_original_method = "F58397C66404D0D65BC532CFA70D8C12", hash_generated_method = "9CAEA12A6EBD7CB2BE19312A12A237AC")
    
public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
        }
    }

    /**
     * Set the checkmark to a given Drawable, identified by its resourece id. This will be drawn
     * when {@link #isChecked()} is true.
     * 
     * @param resid The Drawable to use for the checkmark.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.362 -0500", hash_original_method = "3FCCCD2AA960312D010B10C25B3E1D95", hash_generated_method = "6C92F8510D9F341B4F96F23301C82790")
    
public void setCheckMarkDrawable(int resid) {
        if (resid != 0 && resid == mCheckMarkResource) {
            return;
        }

        mCheckMarkResource = resid;

        Drawable d = null;
        if (mCheckMarkResource != 0) {
            d = getResources().getDrawable(mCheckMarkResource);
        }
        setCheckMarkDrawable(d);
    }

    /**
     * Set the checkmark to a given Drawable. This will be drawn when {@link #isChecked()} is true.
     *
     * @param d The Drawable to use for the checkmark.
     */
    @DSComment("CheckedTextView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.365 -0500", hash_original_method = "93DA6C15D035807E73845CA0E25952EE", hash_generated_method = "8FC52121B0E09B5222D817EAA98458BD")
    @DSVerified
public void setCheckMarkDrawable(Drawable d) {
        if (mCheckMarkDrawable != null) {
            mCheckMarkDrawable.setCallback(null);
            unscheduleDrawable(mCheckMarkDrawable);
        }
        mNeedRequestlayout = (d != mCheckMarkDrawable);
        if (d != null) {
            d.setCallback(this);
            d.setVisible(getVisibility() == VISIBLE, false);
            d.setState(CHECKED_STATE_SET);
            setMinHeight(d.getIntrinsicHeight());
            
            mCheckMarkWidth = d.getIntrinsicWidth();
            d.setState(getDrawableState());
        } else {
            mCheckMarkWidth = 0;
        }
        mCheckMarkDrawable = d;
        // Do padding resolution. This will call setPadding() and do a requestLayout() if needed.
        resolvePadding();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.368 -0500", hash_original_method = "7617145132345CC873AC9F4B73DFB7CD", hash_generated_method = "EBCB8F49AAB0D8F9AF070308738C3746")
    
@Override
    protected void resolvePadding() {
        super.resolvePadding();
        int newPadding = (mCheckMarkDrawable != null) ?
                mCheckMarkWidth + mBasePadding : mBasePadding;
        mNeedRequestlayout |= (mPaddingRight != newPadding);
        mPaddingRight = newPadding;
        if (mNeedRequestlayout) {
            requestLayout();
            mNeedRequestlayout = false;
        }
    }
    
    @DSComment("CheckedTextView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.370 -0500", hash_original_method = "7A1CD8A3A060B0E646E3DFF2DD87386A", hash_generated_method = "6BE7CB3B07281F5F2E48813DA5A8CE9F")
    
@Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        mBasePadding = mPaddingRight;
    }

    @DSVerified("Called from View")
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.372 -0500", hash_original_method = "B19E130BF4CF411642FF2978EAC8260B", hash_generated_method = "5283734485D27F5C9072751F8356F5BA")
    
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final Drawable checkMarkDrawable = mCheckMarkDrawable;
        if (checkMarkDrawable != null) {
            final int verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            final int height = checkMarkDrawable.getIntrinsicHeight();

            int y = 0;

            switch (verticalGravity) {
                case Gravity.BOTTOM:
                    y = getHeight() - height;
                    break;
                case Gravity.CENTER_VERTICAL:
                    y = (getHeight() - height) / 2;
                    break;
            }
            
            int right = getWidth();
            checkMarkDrawable.setBounds(
                    right - mPaddingRight,
                    y, 
                    right - mPaddingRight + mCheckMarkWidth,
                    y + height);
            checkMarkDrawable.draw(canvas);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.375 -0500", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "5E8E36BFCD9C1913662CF74C63EBB21F")
    
@Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.377 -0500", hash_original_method = "856DABB8A541BB631DA077FA70F1A5D5", hash_generated_method = "7320FEC9D00974E6AA7959C14068BB00")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        
        if (mCheckMarkDrawable != null) {
            int[] myDrawableState = getDrawableState();
            
            // Set the state of the Drawable
            mCheckMarkDrawable.setState(myDrawableState);
            
            invalidate();
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.379 -0500", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "E0A307C13A2B0EF8859DF8BD8C2E8931")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.382 -0500", hash_original_method = "800F92BFA9EDE937B28EAF651D664B90", hash_generated_method = "4788EAEF4BDBCFDCBBBE5CEFA99C5E9D")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (isChecked()) {
            event.getText().add(mContext.getString(R.string.radiobutton_selected));
        } else {
            event.getText().add(mContext.getString(R.string.radiobutton_not_selected));
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.384 -0500", hash_original_method = "31E71954214D2E567F10971C83F42BE3", hash_generated_method = "2075A46C2E8F301CC0F3B5E8E3561DBD")
    
@Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setChecked(mChecked);
    }
}

