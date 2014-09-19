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

package android.support.v7.internal.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.appcompat.R;

/**
 * Allows components to query for various configuration policy decisions about how the action bar
 * should lay out and behave on the current device.
 *
 * @hide
 */
public class ActionBarPolicy {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.913 -0400", hash_original_method = "C1AE9658A8F4E26920FC7E273B7656D0", hash_generated_method = "5D3126A6749C3F75B77E964EE56D57BE")
    
public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.902 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.921 -0400", hash_original_method = "A9C94CFF6A985FD76F935292CB342CB3", hash_generated_method = "6725EE42E7E26FF883AEBAF96B3F2F10")
    
private ActionBarPolicy(Context context) {
        mContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.929 -0400", hash_original_method = "F3903847D57E123FDE0C65542F74E6AD", hash_generated_method = "51C88424D53CCA2411CAC60E92D0AC3B")
    
public int getMaxActionButtons() {
        return mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.936 -0400", hash_original_method = "BF2D98EF8212828E2A7EE2CC042DB644", hash_generated_method = "7B99AE19194027B7E9FCA4599D8E7DBE")
    
public boolean showsOverflowMenuButton() {
        // Only show overflow on HC+ devices
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.944 -0400", hash_original_method = "97BDEC56FEC78BFFF3A1600BF4379389", hash_generated_method = "C18A9995FD3B9FADBBD0A260F92BDFE2")
    
public int getEmbeddedMenuWidthLimit() {
        return mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.953 -0400", hash_original_method = "0315A136F1B98326243B053612D86DF2", hash_generated_method = "125BB3792FB842305DA0D3424FF08F2A")
    
public boolean hasEmbeddedTabs() {
        // The embedded tabs policy changed in Jellybean; give older apps the old policy
        // so they get what they expect.
        return mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.978 -0400", hash_original_method = "2AD7C367393D2ED850FF1565D5AEDC2D", hash_generated_method = "90819A371822F0301F15297B01732168")
    
public int getTabContainerHeight() {
/*        TypedArray a = mContext.obtainStyledAttributes(null, R.styleable.ActionBar,
                R.attr.actionBarStyle, 0);*/
        TypedArray a = mContext.obtainStyledAttributes(null, null, R.styleable.ActionBar, R.attr.actionBarStyle);
        int height = a.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources r = mContext.getResources();
        if (!hasEmbeddedTabs()) {
            // Stacked tabs; limit the height
            height = Math.min(height,
                    r.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        a.recycle();
        return height;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:27.990 -0400", hash_original_method = "6B0CA88554A6D82A9E25DDF5AB8D3204", hash_generated_method = "5A034CE1874F1050209F5581980F6C33")
    
public boolean enableHomeButtonByDefault() {
        // Older apps get the home button interaction enabled by default.
        // Newer apps need to enable it explicitly.
        return mContext.getApplicationInfo().targetSdkVersion < 14; // ICE_CREAM_SANDWICH
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 13:22:28.002 -0400", hash_original_method = "4EE8069C949D485C17AF0FF4596259DA", hash_generated_method = "0674D1CDFE501DA0C700B8E16E143BB6")
    
public int getStackedTabMaxWidth() {
        return mContext.getResources().getDimensionPixelSize(
                R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
