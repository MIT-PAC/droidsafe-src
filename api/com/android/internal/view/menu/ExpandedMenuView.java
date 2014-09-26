/*
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

package com.android.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.android.internal.view.menu.MenuBuilder.ItemInvoker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * The expanded menu view is a list-like menu with all of the available menu items.  It is opened
 * by the user clicking no the 'More' button on the icon menu view.
 */
public final class ExpandedMenuView extends ListView implements ItemInvoker, MenuView, OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.017 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.018 -0400", hash_original_field = "06D2B11117F79E7BF1AD7D0C4D350D47", hash_generated_field = "BE32B37325C289EA5DB8A350DE8A52C6")

    private int mAnimations;
    
    /**
     * Instantiates the ExpandedMenuView that is linked with the provided MenuBuilder.
     * @param menu The model for the menu which this MenuView will display
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.020 -0400", hash_original_method = "2D7D395683AE9CE33D072044336B70BB", hash_generated_method = "59D12AAE3F3B3C5A4F5D7E6DAC60500B")
    
public ExpandedMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.MenuView, 0, 0);
        mAnimations = a.getResourceId(com.android.internal.R.styleable.MenuView_windowAnimationStyle, 0);
        a.recycle();

        setOnItemClickListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.021 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "4239B6BD8C1C7C2E7AC8C3A17352B70E")
    
public void initialize(MenuBuilder menu) {
        mMenu = menu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.022 -0400", hash_original_method = "16FE2D47FED77BBFC2DAF1EAFCBDD67E", hash_generated_method = "A6EE6C079726EBB08F6C0A6F948B6DC5")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        
        // Clear the cached bitmaps of children
        setChildrenDrawingCacheEnabled(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.023 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "E4D0C6B553755CCD3E1324292EB5E10F")
    
public boolean invokeItem(MenuItemImpl item) {
        return mMenu.performItemAction(item, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.024 -0400", hash_original_method = "07EFE645E03814FCA0C371AE468C693E", hash_generated_method = "4966D29B49E0E73A8D0BD923D8B34B84")
    
public void onItemClick(AdapterView parent, View v, int position, long id) {
        invokeItem((MenuItemImpl) getAdapter().getItem(position));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.025 -0400", hash_original_method = "02CB30F0EA5DFC81374866D1443F8CD5", hash_generated_method = "95896EC854DD5E8FA6619C5587BDEDE9")
    
public int getWindowAnimations() {
        return mAnimations;
    }
    
}
