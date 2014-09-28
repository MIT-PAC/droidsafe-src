/*
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

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * The expanded menu view is a list-like menu with all of the available menu items.  It is opened
 * by the user clicking no the 'More' button on the icon menu view.
 *
 * @hide
 */
public final class ExpandedMenuView extends ListView
        implements ItemInvoker, MenuView, OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.260 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.263 -0400", hash_original_field = "06D2B11117F79E7BF1AD7D0C4D350D47", hash_generated_field = "BE32B37325C289EA5DB8A350DE8A52C6")

    private int mAnimations;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.267 -0400", hash_original_method = "E5A6D4AA18F514FE2B76C94A8AD6FEE3", hash_generated_method = "89F583C04AEF4114B54F6B6211AED4DA")
    
public ExpandedMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnItemClickListener(this);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.269 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "8C5044F8CB626DD3FF17E33FE647A547")
    
@Override
    public void initialize(MenuBuilder menu) {
        mMenu = menu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.273 -0400", hash_original_method = "16FE2D47FED77BBFC2DAF1EAFCBDD67E", hash_generated_method = "A6EE6C079726EBB08F6C0A6F948B6DC5")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        // Clear the cached bitmaps of children
        setChildrenDrawingCacheEnabled(false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.276 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "3EF784071FFCABC376B8BA97B2D8D2B9")
    
@Override
    public boolean invokeItem(MenuItemImpl item) {
        return mMenu.performItemAction(item, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.279 -0400", hash_original_method = "07EFE645E03814FCA0C371AE468C693E", hash_generated_method = "7F8029E903CCA99AF8BD191FE5041784")
    
@Override
    @SuppressWarnings("rawtypes")
    public void onItemClick(AdapterView parent, View v, int position, long id) {
        invokeItem((MenuItemImpl) getAdapter().getItem(position));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.283 -0400", hash_original_method = "02CB30F0EA5DFC81374866D1443F8CD5", hash_generated_method = "5B4992BFBA1B3DB0ACC6FF52BAB06A0D")
    
@Override
    public int getWindowAnimations() {
        return mAnimations;
    }

}
