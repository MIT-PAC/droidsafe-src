/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Special layout for the containing of an overlay action bar (and its content) to correctly handle
 * fitting system windows when the content has request that its layout ignore them.
 *
 * @hide
 */
public class ActionBarOverlayLayout extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.294 -0400", hash_original_field = "8B9AA64DE0559AE2DDE83CD543EB91AA", hash_generated_field = "3F2DAAE7D4FCE3FD4B025D0C96E78599")

    static final int[] mActionBarSizeAttr = new int[]{
            R.attr.actionBarSize
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.277 -0400", hash_original_field = "3331C193E66804926FFCE834E4CEAA34", hash_generated_field = "0190A10D8C7207CAB2DE904F7B512C63")

    private int mActionBarHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.279 -0400", hash_original_field = "AFDC62FB2771CBC68D8F8907D45F2196", hash_generated_field = "F1560C03BA0B36CA5EB1F5530A3F9251")

    private ActionBar mActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.281 -0400", hash_original_field = "4CE2596198A762943CD94DB82034E59D", hash_generated_field = "4B574DDB85BB6C11F0A70911E19AC509")

    private View mContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.283 -0400", hash_original_field = "6B2B8D60794FBC816425C575E9C39654", hash_generated_field = "7B56912F067E0F2C560B6019F43984DB")

    private View mActionBarTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.285 -0400", hash_original_field = "F0835DDC82578A0109B84C7705D73E6A", hash_generated_field = "3B5102E8A4555D5377D5546AD36E30EF")

    private ActionBarContainer mContainerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.287 -0400", hash_original_field = "426FC35843B14572D6FBC98B9C012094", hash_generated_field = "435589A395F4655E845140B48CC5DD82")

    private ActionBarView mActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.289 -0400", hash_original_field = "BDA72CF99F1ECD2BB1B03E0B25DFB340", hash_generated_field = "DB0A6E96D07B9B2F47520DCF5019F1BC")

    private View mActionBarBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.292 -0400", hash_original_field = "6CE7FB4130D2F13C9F17FAA38DBCF232", hash_generated_field = "E97C0E69D6EE01369B14E5655EE6AE3B")

    private final Rect mZeroRect = new Rect(0, 0, 0, 0);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.297 -0400", hash_original_method = "594CDDE26D064682FA1E17C03B34662C", hash_generated_method = "22DFD02DCB7A3ACFD034B10792BE5091")
    
public ActionBarOverlayLayout(Context context) {
        super(context);
        init(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.299 -0400", hash_original_method = "E73608F5038B846842096447B027F33D", hash_generated_method = "B37DC1A11AB255128D7872DA648BADDA")
    
public ActionBarOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.301 -0400", hash_original_method = "8F6526D6401454D34D0D4C0C094AAD3D", hash_generated_method = "A7EAB12BD27AF92AB08B1C21F91F85DB")
    
private void init(Context context) {
        TypedArray ta = getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
        mActionBarHeight = ta.getDimensionPixelSize(0, 0);
        ta.recycle();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.303 -0400", hash_original_method = "57961BDB1DDB70D7E3CF1C1B9165CEE6", hash_generated_method = "C4E974DC492C111E0F3DE07BB58CE88A")
    
public void setActionBar(ActionBar impl) {
        mActionBar = impl;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.307 -0400", hash_original_method = "1BB99CA9831ACCC4238B511CB6912334", hash_generated_method = "F219DAB58E7F9AAB8CD81BE2CDAFFA4C")
    
private boolean applyInsets(View view, Rect insets, boolean left, boolean top,
            boolean bottom, boolean right) {
        boolean changed = false;
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (left && lp.leftMargin != insets.left) {
            changed = true;
            lp.leftMargin = insets.left;
        }
        if (top && lp.topMargin != insets.top) {
            changed = true;
            lp.topMargin = insets.top;
        }
        if (right && lp.rightMargin != insets.right) {
            changed = true;
            lp.rightMargin = insets.right;
        }
        if (bottom && lp.bottomMargin != insets.bottom) {
            changed = true;
            lp.bottomMargin = insets.bottom;
        }
        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:43.309 -0400", hash_original_method = "CE02B263DF5FE0F39406CBB1E7CBC24F", hash_generated_method = "CE02B263DF5FE0F39406CBB1E7CBC24F")
    
void pullChildren() {
        if (mContent == null) {
            mContent = findViewById(R.id.action_bar_activity_content);
            if (mContent == null) {
                mContent = findViewById(android.R.id.content);
            }
            mActionBarTop = findViewById(R.id.top_action_bar);
            mContainerView = (ActionBarContainer) findViewById(R.id.action_bar_container);
            mActionView = (ActionBarView) findViewById(R.id.action_bar);
            mActionBarBottom = findViewById(R.id.split_action_bar);
        }
    }
}
