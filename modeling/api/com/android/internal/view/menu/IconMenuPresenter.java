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
 * Copyright (C) 2011 The Android Open Source Project
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


package com.android.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.android.internal.view.menu.MenuView.ItemView;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * MenuPresenter for the classic "six-pack" icon menu.
 */
public class IconMenuPresenter extends BaseMenuPresenter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.311 -0400", hash_original_field = "623F33053CB26381252015F3273A2C3C", hash_generated_field = "418DB3B9077FA3302EC427CEE064CE9D")


    private static final String VIEWS_TAG = "android:menu:icon";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.312 -0400", hash_original_field = "029970B8B07121DA468430EC3D2A4071", hash_generated_field = "7B5C5EAA7487ECA2ECB05CE6847FA554")

    private static final String OPEN_SUBMENU_KEY = "android:menu:icon:submenu";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.304 -0400", hash_original_field = "D42E9EF8A5D06A42E5B9874B240D2D43", hash_generated_field = "10DFB69FB3DA0930CA6D1E515C9607B5")

    private IconMenuItemView mMoreView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.305 -0400", hash_original_field = "5AEEE353BF90146E0A95E5C306666CD7", hash_generated_field = "D8A94B6E010E956EDCB35B4666C445EA")

    private int mMaxItems = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.307 -0400", hash_original_field = "0BCBB7C2003D06DDB90F4DA92F90C05F", hash_generated_field = "0BCBB7C2003D06DDB90F4DA92F90C05F")


    int mOpenSubMenuId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.308 -0400", hash_original_field = "F22E56ED0ECFA1D7E2D0DEE95D8F2988", hash_generated_field = "F22E56ED0ECFA1D7E2D0DEE95D8F2988")

    SubMenuPresenterCallback mSubMenuPresenterCallback = new SubMenuPresenterCallback();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.309 -0400", hash_original_field = "7CDFADF0043D8FA5089C3DFB49F6FBB0", hash_generated_field = "7CDFADF0043D8FA5089C3DFB49F6FBB0")

    MenuDialogHelper mOpenSubMenu;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.313 -0400", hash_original_method = "EAE51773EBE43F906BD717B06D1E13A8", hash_generated_method = "A3A914DFF13660863EA3FF8FE8DF62CE")
    
public IconMenuPresenter(Context context) {
        super(new ContextThemeWrapper(context, com.android.internal.R.style.Theme_IconMenu),
                com.android.internal.R.layout.icon_menu_layout,
                com.android.internal.R.layout.icon_menu_item_layout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.314 -0400", hash_original_method = "0C671CFCCE8440DF664FCFC418CDEFDA", hash_generated_method = "8239268EEAB78461253CD0C2B05DD3C9")
    
@Override
    public void initForMenu(Context context, MenuBuilder menu) {
        super.initForMenu(context, menu);
        mMaxItems = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.315 -0400", hash_original_method = "893BCB99609444F1E1525BDBE5A6099D", hash_generated_method = "CA2AD700248F009BE6D4C4BDCBEC2306")
    
@Override
    public void bindItemView(MenuItemImpl item, ItemView itemView) {
        final IconMenuItemView view = (IconMenuItemView) itemView;
        view.setItemData(item);

        view.initialize(item.getTitleForItemView(view), item.getIcon());

        view.setVisibility(item.isVisible() ? View.VISIBLE : View.GONE);
        view.setEnabled(view.isEnabled());
        view.setLayoutParams(view.getTextAppropriateLayoutParams());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.317 -0400", hash_original_method = "570C3DBAE1FE511DD264FFF410D2CDDB", hash_generated_method = "90980F90319BFB1DCFC28C2DE24AB219")
    
@Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        final ArrayList<MenuItemImpl> itemsToShow = mMenu.getNonActionItems();
        boolean fits = (itemsToShow.size() == mMaxItems && childIndex < mMaxItems) ||
                childIndex < mMaxItems - 1;
        return fits && !item.isActionButton();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.318 -0400", hash_original_method = "6CA4A93A96CF1611921D3C27246B0489", hash_generated_method = "5250B73A9EFB20DB04F7454AA72EFEBA")
    
@Override
    protected void addItemView(View itemView, int childIndex) {
        final IconMenuItemView v = (IconMenuItemView) itemView;
        final IconMenuView parent = (IconMenuView) mMenuView;

        v.setIconMenuView(parent);
        v.setItemInvoker(parent);
        v.setBackgroundDrawable(parent.getItemBackgroundDrawable());
        super.addItemView(itemView, childIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.319 -0400", hash_original_method = "2D39A72F4AC5AEEEE45D5ABB44847752", hash_generated_method = "E5868AB0D1561C1DA09EEA9F00BFC9F0")
    
@Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (!subMenu.hasVisibleItems()) return false;

        // The window manager will give us a token.
        MenuDialogHelper helper = new MenuDialogHelper(subMenu);
        helper.setPresenterCallback(mSubMenuPresenterCallback);
        helper.show(null);
        mOpenSubMenu = helper;
        mOpenSubMenuId = subMenu.getItem().getItemId();
        super.onSubMenuSelected(subMenu);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.321 -0400", hash_original_method = "64E1DE5861651788730CD2BF0B7FDECA", hash_generated_method = "F495261A9A0318CE7A2F35E2823B46C0")
    
@Override
    public void updateMenuView(boolean cleared) {
        final IconMenuView menuView = (IconMenuView) mMenuView;
        if (mMaxItems < 0) mMaxItems = menuView.getMaxItems();
        final ArrayList<MenuItemImpl> itemsToShow = mMenu.getNonActionItems();
        final boolean needsMore = itemsToShow.size() > mMaxItems;
        super.updateMenuView(cleared);

        if (needsMore && (mMoreView == null || mMoreView.getParent() != menuView)) {
            if (mMoreView == null) {
                mMoreView = menuView.createMoreItemView();
                mMoreView.setBackgroundDrawable(menuView.getItemBackgroundDrawable());
            }
            menuView.addView(mMoreView);
        } else if (!needsMore && mMoreView != null) {
            menuView.removeView(mMoreView);
        }

        menuView.setNumActualItemsShown(needsMore ? mMaxItems - 1 : itemsToShow.size());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.322 -0400", hash_original_method = "2B5E56C6CC939040511DDEDD9074D027", hash_generated_method = "38631FFEDF939048C5E8FDEAB50D4F54")
    
@Override
    protected boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) != mMoreView) {
            return super.filterLeftoverView(parent, childIndex);
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.323 -0400", hash_original_method = "1FE2F6FBA9303F4E72CC9CD6E3B7E748", hash_generated_method = "CAD210E7CFDDEC420033D71C8D5E6945")
    
public int getNumActualItemsShown() {
        return ((IconMenuView) mMenuView).getNumActualItemsShown();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.325 -0400", hash_original_method = "0B368829F15D6906C64A9F7093B6493E", hash_generated_method = "E2D182ABBF8575D0C08F2BC9BB5AED96")
    
public void saveHierarchyState(Bundle outState) {
        SparseArray<Parcelable> viewStates = new SparseArray<Parcelable>();
        if (mMenuView != null) {
            ((View) mMenuView).saveHierarchyState(viewStates);
        }
        outState.putSparseParcelableArray(VIEWS_TAG, viewStates);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.326 -0400", hash_original_method = "DEC28830089F716CE0B9EDF8807D3BAF", hash_generated_method = "BF154AA8C7C44F7B11E22864839553EC")
    
public void restoreHierarchyState(Bundle inState) {
        SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        if (viewStates != null) {
            ((View) mMenuView).restoreHierarchyState(viewStates);
        }
        int subMenuId = inState.getInt(OPEN_SUBMENU_KEY, 0);
        if (subMenuId > 0 && mMenu != null) {
            MenuItem item = mMenu.findItem(subMenuId);
            if (item != null) {
                onSubMenuSelected((SubMenuBuilder) item.getSubMenu());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.327 -0400", hash_original_method = "2355ABB79B16A9A5BCFFE2F83402755D", hash_generated_method = "FA200E8757A13B60B7490778B0734249")
    
@Override
    public Parcelable onSaveInstanceState() {
        if (mMenuView == null) {
            return null;
        }

        Bundle state = new Bundle();
        saveHierarchyState(state);
        if (mOpenSubMenuId > 0) {
            state.putInt(OPEN_SUBMENU_KEY, mOpenSubMenuId);
        }
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.329 -0400", hash_original_method = "4E57F37A0749F365E081EFA3C3A26D3A", hash_generated_method = "4B003FD3C48144E4D83B6FD446FFEF9F")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        restoreHierarchyState((Bundle) state);
    }

    class SubMenuPresenterCallback implements MenuPresenter.Callback {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.330 -0400", hash_original_method = "FE674E083F828944040D0AC17B315A9A", hash_generated_method = "8CFF1610E77F8700BE9471CB650D7EE8")
        
@Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            mOpenSubMenuId = 0;
            if (mOpenSubMenu != null) {
                mOpenSubMenu.dismiss();
                mOpenSubMenu = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.331 -0400", hash_original_method = "9FC917267C34B7141471BDE830C1C7EE", hash_generated_method = "A642F019B2CF3ED2F94B002EB36573DE")
        
@Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (subMenu != null) {
                mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            }
            return false;
        }

    }
}
