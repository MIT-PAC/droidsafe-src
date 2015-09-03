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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.android.internal.view.menu.ActionMenuView.ActionMenuChildView;

public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.127 -0500", hash_original_field = "386D9EF4C6B912223014D74F821BB6A4", hash_generated_field = "365B884CA8B9956B388F21B4CE2AED12")

    private static final String TAG = "ActionMenuPresenter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.129 -0500", hash_original_field = "8A3C259DCC249CAE53CCDEB6CE2BEACF", hash_generated_field = "62B115CA56547ACC4395C5191DCAFA48")

    private View mOverflowButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.132 -0500", hash_original_field = "E5A9CB2F2F54CC6E136BCFE6856F2EC9", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.135 -0500", hash_original_field = "D3015E5C4B3934121C6929A56FBDD038", hash_generated_field = "8AA1ADBD5C3D9FA8BD4CE08655C7BAEC")

    private boolean mReserveOverflowSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.137 -0500", hash_original_field = "EA1F9BD6C3891F5C6BDC7965F8B6F2CC", hash_generated_field = "D519A6354FF6027B8318E0E8A1847729")

    private int mWidthLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.139 -0500", hash_original_field = "4B5BD4017E8C305B53E4472A1ED344FC", hash_generated_field = "EE263C3BDAD9F74C57B87B4D53F4A7F2")

    private int mActionItemWidthLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.141 -0500", hash_original_field = "6A5D0A43C7A85FA86E1168FC496915AF", hash_generated_field = "46A54E1F46C2CF0E99FFE4A07B201C3C")

    private int mMaxItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.143 -0500", hash_original_field = "D5A2CCF2075BA90CADF868FBA386ACD8", hash_generated_field = "E8BC6B5172B218C6C49A6690AFA86C5B")

    private boolean mMaxItemsSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.145 -0500", hash_original_field = "2776040A8B6698915E5067F6DEA6939F", hash_generated_field = "5992037AC4E6034F7F17925E51ACE390")

    private boolean mStrictWidthLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.147 -0500", hash_original_field = "BD2C7DA551D0B45E7B25F606B8C5FFB5", hash_generated_field = "896F729C22C3B090A4F37324F1470F98")

    private boolean mWidthLimitSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.149 -0500", hash_original_field = "003BD9511B16227E99EE7EACE6EA9D6F", hash_generated_field = "609B8E14C3F57F0FDE596A9E3115E316")

    private boolean mExpandedActionViewsExclusive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.152 -0500", hash_original_field = "D89719B11B3D07DF5BEDF9A3B5892A7C", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.154 -0500", hash_original_field = "6F2E37C26263D6D74CD7167367E39094", hash_generated_field = "AB745D0096A474765505150A34296B41")

    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.156 -0500", hash_original_field = "96C7ECC79D38C33876B0A3F399663721", hash_generated_field = "62CE63FA1996B79D9E9EE4493D96FB92")

    private View mScrapActionButtonView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.158 -0500", hash_original_field = "3E86BCA5DFAB0798DFA9FD07D00D676F", hash_generated_field = "73011FFFEE53F9056EE81430FCFEDF05")

    private OverflowPopup mOverflowPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.160 -0500", hash_original_field = "DBBC5F31D31932D489B4061F327751B8", hash_generated_field = "BAF3D98693011134EB1620D1BA22CC15")

    private ActionButtonSubmenu mActionButtonPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.163 -0500", hash_original_field = "EC20812F1207265230D4DB87C3970C6E", hash_generated_field = "33AD605615015FDD75E5D9A4D89E75A5")

    private OpenOverflowRunnable mPostedOpenRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.165 -0500", hash_original_field = "EAA5F1B1764DB3A287DDA9679D0A36F8", hash_generated_field = "FEC720003D50479950C7720E8FE0EC06")

    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.167 -0500", hash_original_field = "0BCBB7C2003D06DDB90F4DA92F90C05F", hash_generated_field = "0BCBB7C2003D06DDB90F4DA92F90C05F")

    int mOpenSubMenuId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.169 -0500", hash_original_method = "D92A82193E3FCDED5C9710083B861A1F", hash_generated_method = "52D884277840A3B089808E769F98111D")
    
public ActionMenuPresenter(Context context) {
        super(context, com.android.internal.R.layout.action_menu_layout,
                com.android.internal.R.layout.action_menu_item_layout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.172 -0500", hash_original_method = "BC9545155A7D6BD0732B2C48FEAAA115", hash_generated_method = "570F84851BDB51A8EE121DDC86FBA7FB")
    
@Override
    public void initForMenu(Context context, MenuBuilder menu) {
        super.initForMenu(context, menu);

        final Resources res = context.getResources();

        if (!mReserveOverflowSet) {
            mReserveOverflow = !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        if (!mWidthLimitSet) {
            mWidthLimit = res.getDisplayMetrics().widthPixels / 2;
        }

        // Measure for initial configuration
        if (!mMaxItemsSet) {
            mMaxItems = res.getInteger(com.android.internal.R.integer.max_action_buttons);
        }

        int width = mWidthLimit;
        if (mReserveOverflow) {
            if (mOverflowButton == null) {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                final int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                mOverflowButton.measure(spec, spec);
            }
            width -= mOverflowButton.getMeasuredWidth();
        } else {
            mOverflowButton = null;
        }

        mActionItemWidthLimit = width;

        mMinCellSize = (int) (ActionMenuView.MIN_CELL_SIZE * res.getDisplayMetrics().density);

        // Drop a scrap view as it may no longer reflect the proper context/config.
        mScrapActionButtonView = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.175 -0500", hash_original_method = "A17C8C9C29C5D048821A272E4E211244", hash_generated_method = "B2ADF13DE9F721F2A67FCB5778B0185F")
    
public void onConfigurationChanged(Configuration newConfig) {
        if (!mMaxItemsSet) {
            mMaxItems = mContext.getResources().getInteger(
                    com.android.internal.R.integer.max_action_buttons);
            if (mMenu != null) {
                mMenu.onItemsChanged(true);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.178 -0500", hash_original_method = "EDE1166C9C5D6E2371538FA8BF1D31B5", hash_generated_method = "51BF3D2138A1C7079B0FD6271DC72110")
    
public void setWidthLimit(int width, boolean strict) {
        mWidthLimit = width;
        mStrictWidthLimit = strict;
        mWidthLimitSet = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.180 -0500", hash_original_method = "9F648716EF61D229ED05FF998E104A97", hash_generated_method = "FF495116FFDC4DE5946D2982FFB37D0B")
    
public void setReserveOverflow(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        mReserveOverflowSet = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.182 -0500", hash_original_method = "481A608E0CFB48388247866BAE1C540A", hash_generated_method = "CBADC8E02449773C818914E12DD5423D")
    
public void setItemLimit(int itemCount) {
        mMaxItems = itemCount;
        mMaxItemsSet = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.185 -0500", hash_original_method = "28685D1CD5555D455AA1245A08028303", hash_generated_method = "16190EBABD958670C1DADD2B46887DBA")
    
public void setExpandedActionViewsExclusive(boolean isExclusive) {
        mExpandedActionViewsExclusive = isExclusive;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.187 -0500", hash_original_method = "AD0B74E3B833D08F8481D15CB97EDB86", hash_generated_method = "4EB992F1843AEE2E970782E0DD05D572")
    
@Override
    public MenuView getMenuView(ViewGroup root) {
        MenuView result = super.getMenuView(root);
        ((ActionMenuView) result).setPresenter(this);
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.189 -0500", hash_original_method = "59BA3C56A8058A32CF9B2FCB0A0B5507", hash_generated_method = "684116B23E2F855BA7843E02D5E266D1")
    
@Override
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        View actionView = item.getActionView();
        if (actionView == null || item.hasCollapsibleActionView()) {
            if (!(convertView instanceof ActionMenuItemView)) {
                convertView = null;
            }
            actionView = super.getItemView(item, convertView, parent);
        }
        actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);

        final ActionMenuView menuParent = (ActionMenuView) parent;
        final ViewGroup.LayoutParams lp = actionView.getLayoutParams();
        if (!menuParent.checkLayoutParams(lp)) {
            actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
        }
        return actionView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.192 -0500", hash_original_method = "2F59AFEB76404A397084655FE3C87387", hash_generated_method = "863CB45216E59ED0430665AD9CF14C18")
    
@Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {
        itemView.initialize(item, 0);

        final ActionMenuView menuView = (ActionMenuView) mMenuView;
        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.194 -0500", hash_original_method = "CF6FF79E1183E432FB7F279F6A955298", hash_generated_method = "379E338C9673BE2A3C50AC064BF35C99")
    
@Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        return item.isActionButton();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.198 -0500", hash_original_method = "675BFE60E67D99082131CDB4BA0667CE", hash_generated_method = "F989DFE031E1CCB81138A8427788CAE1")
    
@Override
    public void updateMenuView(boolean cleared) {
        super.updateMenuView(cleared);

        if (mMenu != null) {
            final ArrayList<MenuItemImpl> actionItems = mMenu.getActionItems();
            final int count = actionItems.size();
            for (int i = 0; i < count; i++) {
                final ActionProvider provider = actionItems.get(i).getActionProvider();
                if (provider != null) {
                    provider.setSubUiVisibilityListener(this);
                }
            }
        }

        final ArrayList<MenuItemImpl> nonActionItems = mMenu != null ?
                mMenu.getNonActionItems() : null;

        boolean hasOverflow = false;
        if (mReserveOverflow && nonActionItems != null) {
            final int count = nonActionItems.size();
            if (count == 1) {
                hasOverflow = !nonActionItems.get(0).isActionViewExpanded();
            } else {
                hasOverflow = count > 0;
            }
        }

        if (hasOverflow) {
            if (mOverflowButton == null) {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
            }
            ViewGroup parent = (ViewGroup) mOverflowButton.getParent();
            if (parent != mMenuView) {
                if (parent != null) {
                    parent.removeView(mOverflowButton);
                }
                ActionMenuView menuView = (ActionMenuView) mMenuView;
                menuView.addView(mOverflowButton, menuView.generateOverflowButtonLayoutParams());
            }
        } else if (mOverflowButton != null && mOverflowButton.getParent() == mMenuView) {
            ((ViewGroup) mMenuView).removeView(mOverflowButton);
        }

        ((ActionMenuView) mMenuView).setOverflowReserved(mReserveOverflow);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.200 -0500", hash_original_method = "9D8FC445B750A9A2E8805EF185920422", hash_generated_method = "820C812697396EBBFEB10998F63C83B7")
    
@Override
    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) == mOverflowButton) return false;
        return super.filterLeftoverView(parent, childIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.203 -0500", hash_original_method = "37299DBD51D21A28CE7BE5283912D693", hash_generated_method = "002C11251EAAB652D72B94152F26F3B3")
    
public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (!subMenu.hasVisibleItems()) return false;

        SubMenuBuilder topSubMenu = subMenu;
        while (topSubMenu.getParentMenu() != mMenu) {
            topSubMenu = (SubMenuBuilder) topSubMenu.getParentMenu();
        }
        View anchor = findViewForItem(topSubMenu.getItem());
        if (anchor == null) {
            if (mOverflowButton == null) return false;
            anchor = mOverflowButton;
        }

        mOpenSubMenuId = subMenu.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, subMenu);
        mActionButtonPopup.setAnchorView(anchor);
        mActionButtonPopup.show();
        super.onSubMenuSelected(subMenu);
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.205 -0500", hash_original_method = "D21215C119A8C9273D02F36683639F77", hash_generated_method = "341EFA87BE3CA56FD6887969373BCF41")
    
private View findViewForItem(MenuItem item) {
        final ViewGroup parent = (ViewGroup) mMenuView;
        if (parent == null) return null;

        final int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = parent.getChildAt(i);
            if (child instanceof MenuView.ItemView &&
                    ((MenuView.ItemView) child).getItemData() == item) {
                return child;
            }
        }
        return null;
    }

    /**
     * Display the overflow menu if one is present.
     * @return true if the overflow menu was shown, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.208 -0500", hash_original_method = "51D4B09F0769DB498C88D93C1DD1D610", hash_generated_method = "51243C913151924050D95A4116E417C8")
    
public boolean showOverflowMenu() {
        if (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
                mPostedOpenRunnable == null) {
            OverflowPopup popup = new OverflowPopup(mContext, mMenu, mOverflowButton, true);
            mPostedOpenRunnable = new OpenOverflowRunnable(popup);
            // Post this for later; we might still need a layout for the anchor to be right.
            ((View) mMenuView).post(mPostedOpenRunnable);

            // ActionMenuPresenter uses null as a callback argument here
            // to indicate overflow is opening.
            super.onSubMenuSelected(null);

            return true;
        }
        return false;
    }

    /**
     * Hide the overflow menu if it is currently showing.
     *
     * @return true if the overflow menu was hidden, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.210 -0500", hash_original_method = "F07D2B002CE8D32774BDF7E27A216F8A", hash_generated_method = "142BEDC549A1782A1BD4D492BEFB1726")
    
public boolean hideOverflowMenu() {
        if (mPostedOpenRunnable != null && mMenuView != null) {
            ((View) mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
            return true;
        }

        MenuPopupHelper popup = mOverflowPopup;
        if (popup != null) {
            popup.dismiss();
            return true;
        }
        return false;
    }

    /**
     * Dismiss all popup menus - overflow and submenus.
     * @return true if popups were dismissed, false otherwise. (This can be because none were open.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.212 -0500", hash_original_method = "048650AFF94B01A571A17F813CE8142B", hash_generated_method = "570265486E6BAC8556276C3D4D46AB4B")
    
public boolean dismissPopupMenus() {
        boolean result = hideOverflowMenu();
        result |= hideSubMenus();
        return result;
    }

    /**
     * Dismiss all submenu popups.
     *
     * @return true if popups were dismissed, false otherwise. (This can be because none were open.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.214 -0500", hash_original_method = "86830002AFDFBC8C0790A0C80E395F68", hash_generated_method = "5BBC0ADA5FC6500FBA53DE1267B5D0C6")
    
public boolean hideSubMenus() {
        if (mActionButtonPopup != null) {
            mActionButtonPopup.dismiss();
            return true;
        }
        return false;
    }

    /**
     * @return true if the overflow menu is currently showing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.217 -0500", hash_original_method = "EDFA99D71A654F51EBF8F88159FF0AE5", hash_generated_method = "C48BAAA0060F86CCE0E822412273EF79")
    
public boolean isOverflowMenuShowing() {
        return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    /**
     * @return true if space has been reserved in the action menu for an overflow item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.219 -0500", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "139EA482158AF5CCB7770B48716B0B5E")
    
public boolean isOverflowReserved() {
        return mReserveOverflow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.224 -0500", hash_original_method = "3161CCF567C7C41004F1DD2E1141CBA5", hash_generated_method = "4146624E45734BDD85A5880B7B63ED48")
    
public boolean flagActionItems() {
        final ArrayList<MenuItemImpl> visibleItems = mMenu.getVisibleItems();
        final int itemsSize = visibleItems.size();
        int maxActions = mMaxItems;
        int widthLimit = mActionItemWidthLimit;
        final int querySpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final ViewGroup parent = (ViewGroup) mMenuView;

        int requiredItems = 0;
        int requestedItems = 0;
        int firstActionWidth = 0;
        boolean hasOverflow = false;
        for (int i = 0; i < itemsSize; i++) {
            MenuItemImpl item = visibleItems.get(i);
            if (item.requiresActionButton()) {
                requiredItems++;
            } else if (item.requestsActionButton()) {
                requestedItems++;
            } else {
                hasOverflow = true;
            }
            if (mExpandedActionViewsExclusive && item.isActionViewExpanded()) {
                // Overflow everything if we have an expanded action view and we're
                // space constrained.
                maxActions = 0;
            }
        }

        // Reserve a spot for the overflow item if needed.
        if (mReserveOverflow &&
                (hasOverflow || requiredItems + requestedItems > maxActions)) {
            maxActions--;
        }
        maxActions -= requiredItems;

        final SparseBooleanArray seenGroups = mActionButtonGroups;
        seenGroups.clear();

        int cellSize = 0;
        int cellsRemaining = 0;
        if (mStrictWidthLimit) {
            cellsRemaining = widthLimit / mMinCellSize;
            final int cellSizeRemaining = widthLimit % mMinCellSize;
            cellSize = mMinCellSize + cellSizeRemaining / cellsRemaining;
        }

        // Flag as many more requested items as will fit.
        for (int i = 0; i < itemsSize; i++) {
            MenuItemImpl item = visibleItems.get(i);

            if (item.requiresActionButton()) {
                View v = getItemView(item, mScrapActionButtonView, parent);
                if (mScrapActionButtonView == null) {
                    mScrapActionButtonView = v;
                }
                if (mStrictWidthLimit) {
                    cellsRemaining -= ActionMenuView.measureChildForCells(v,
                            cellSize, cellsRemaining, querySpec, 0);
                } else {
                    v.measure(querySpec, querySpec);
                }
                final int measuredWidth = v.getMeasuredWidth();
                widthLimit -= measuredWidth;
                if (firstActionWidth == 0) {
                    firstActionWidth = measuredWidth;
                }
                final int groupId = item.getGroupId();
                if (groupId != 0) {
                    seenGroups.put(groupId, true);
                }
                item.setIsActionButton(true);
            } else if (item.requestsActionButton()) {
                // Items in a group with other items that already have an action slot
                // can break the max actions rule, but not the width limit.
                final int groupId = item.getGroupId();
                final boolean inGroup = seenGroups.get(groupId);
                boolean isAction = (maxActions > 0 || inGroup) && widthLimit > 0 &&
                        (!mStrictWidthLimit || cellsRemaining > 0);

                if (isAction) {
                    View v = getItemView(item, mScrapActionButtonView, parent);
                    if (mScrapActionButtonView == null) {
                        mScrapActionButtonView = v;
                    }
                    if (mStrictWidthLimit) {
                        final int cells = ActionMenuView.measureChildForCells(v,
                                cellSize, cellsRemaining, querySpec, 0);
                        cellsRemaining -= cells;
                        if (cells == 0) {
                            isAction = false;
                        }
                    } else {
                        v.measure(querySpec, querySpec);
                    }
                    final int measuredWidth = v.getMeasuredWidth();
                    widthLimit -= measuredWidth;
                    if (firstActionWidth == 0) {
                        firstActionWidth = measuredWidth;
                    }

                    if (mStrictWidthLimit) {
                        isAction &= widthLimit >= 0;
                    } else {
                        // Did this push the entire first item past the limit?
                        isAction &= widthLimit + firstActionWidth > 0;
                    }
                }

                if (isAction && groupId != 0) {
                    seenGroups.put(groupId, true);
                } else if (inGroup) {
                    // We broke the width limit. Demote the whole group, they all overflow now.
                    seenGroups.put(groupId, false);
                    for (int j = 0; j < i; j++) {
                        MenuItemImpl areYouMyGroupie = visibleItems.get(j);
                        if (areYouMyGroupie.getGroupId() == groupId) {
                            // Give back the action slot
                            if (areYouMyGroupie.isActionButton()) maxActions++;
                            areYouMyGroupie.setIsActionButton(false);
                        }
                    }
                }

                if (isAction) maxActions--;

                item.setIsActionButton(isAction);
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.227 -0500", hash_original_method = "C8ECD6F76386581509465FBD82905343", hash_generated_method = "5B787987BE6C9A7C09E8CBA0DE108234")
    
@Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        dismissPopupMenus();
        super.onCloseMenu(menu, allMenusAreClosing);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.229 -0500", hash_original_method = "06AD8BBBF679989CAE04F426A0FFC61D", hash_generated_method = "A31FC16AFA84949190C53DC7D8F9E45A")
    
@Override
    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState();
        state.openSubMenuId = mOpenSubMenuId;
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.231 -0500", hash_original_method = "56321A468C9EBB2A9C3695363B6A634B", hash_generated_method = "B35E35D50EE2AB7C662BE1A1C4F24CC3")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState saved = (SavedState) state;
        if (saved.openSubMenuId > 0) {
            MenuItem item = mMenu.findItem(saved.openSubMenuId);
            if (item != null) {
                SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                onSubMenuSelected(subMenu);
            }
        }
    }
    
    private static class SavedState implements Parcelable {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.002 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.250 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.252 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.236 -0500", hash_original_field = "2689B6143FEBC208E56111E3C6631C9E", hash_generated_field = "D108CA8004A7040C71E1AF0A426FBA46")

        public int openSubMenuId;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.239 -0500", hash_original_method = "5B86CE655F475C08F177FDB52AD9ECFE", hash_generated_method = "5B86CE655F475C08F177FDB52AD9ECFE")
        
SavedState() {
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.242 -0500", hash_original_method = "10B6E86FE11BCC070EDA2136A91ED86D", hash_generated_method = "10B6E86FE11BCC070EDA2136A91ED86D")
        
SavedState(Parcel in) {
            openSubMenuId = in.readInt();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.244 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
        
@Override
        public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.246 -0500", hash_original_method = "4E7F3A208B8DADACA56997D8D1B3C90C", hash_generated_method = "B78E689229BD35516F3FA9DA9B38746D")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(openSubMenuId);
        }
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }
    
    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.260 -0500", hash_original_method = "1337D4EFD3D7C8CDCFFFFAE2F6FA113A", hash_generated_method = "7DC0260A6D76294CFEBDFC4B1AC9FB0A")
        
public OverflowMenuButton(Context context) {
            super(context, null, com.android.internal.R.attr.actionOverflowButtonStyle);

            setClickable(true);
            setFocusable(true);
            setVisibility(VISIBLE);
            setEnabled(true);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.263 -0500", hash_original_method = "133A6BF2CD1B819427A8C49FA8B8E865", hash_generated_method = "6743C1E8CB3F9B4E3F7C6883745F5CBC")
        
@Override
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }

            playSoundEffect(SoundEffectConstants.CLICK);
            showOverflowMenu();
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.265 -0500", hash_original_method = "6BA15F1E8189A4801AF337396791DD31", hash_generated_method = "CC3DD861FEA1A38FCFF69A283472F6F5")
        
public boolean needsDividerBefore() {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.267 -0500", hash_original_method = "CA065FAE0BB06CECFBFA2C36E268A066", hash_generated_method = "714C6BA2903F43C62FEF12EE5E8569E4")
        
public boolean needsDividerAfter() {
            return false;
        }
        
    }
    
    private class OverflowPopup extends MenuPopupHelper {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.271 -0500", hash_original_method = "FA0F7CD1552EAFA7C13929825A8B2112", hash_generated_method = "159F59B5A34857AB2D87D358B73DF257")
        
public OverflowPopup(Context context, MenuBuilder menu, View anchorView,
                boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly);
            setCallback(mPopupPresenterCallback);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.274 -0500", hash_original_method = "F12BAE7D751DC96E6D1F67F68EBC9919", hash_generated_method = "1DE680E8854A7E0EF4B0C6880535ABDA")
        
@Override
        public void onDismiss() {
            super.onDismiss();
            mMenu.close();
            mOverflowPopup = null;
        }
        
    }
    
    private class ActionButtonSubmenu extends MenuPopupHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.279 -0500", hash_original_field = "F72B98E23896D66B33476F874979B6CA", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

        private SubMenuBuilder mSubMenu;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.281 -0500", hash_original_method = "E276DF3AF8ED38FB9CAF2E195F32B2B4", hash_generated_method = "533B694A352C06A5548939C9DE953A38")
        
public ActionButtonSubmenu(Context context, SubMenuBuilder subMenu) {
            super(context, subMenu);
            mSubMenu = subMenu;

            MenuItemImpl item = (MenuItemImpl) subMenu.getItem();
            if (!item.isActionButton()) {
                // Give a reasonable anchor to nested submenus.
                setAnchorView(mOverflowButton == null ? (View) mMenuView : mOverflowButton);
            }

            setCallback(mPopupPresenterCallback);

            boolean preserveIconSpacing = false;
            final int count = subMenu.size();
            for (int i = 0; i < count; i++) {
                MenuItem childItem = subMenu.getItem(i);
                if (childItem.isVisible() && childItem.getIcon() != null) {
                    preserveIconSpacing = true;
                    break;
                }
            }
            setForceShowIcon(preserveIconSpacing);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.284 -0500", hash_original_method = "69C0D5A7A155D8F50134B9E617767128", hash_generated_method = "3A0B0C423896B781BFA2BBA0112C7310")
        
@Override
        public void onDismiss() {
            super.onDismiss();
            mActionButtonPopup = null;
            mOpenSubMenuId = 0;
        }
        
    }
    
    private class PopupPresenterCallback implements MenuPresenter.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.004 -0400", hash_original_method = "094885FACF5CDEF923542BEFD4BC4936", hash_generated_method = "094885FACF5CDEF923542BEFD4BC4936")
        public PopupPresenterCallback ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.289 -0500", hash_original_method = "29547EA8801B28CE842E58C3B2A91712", hash_generated_method = "3E39D19E4C09FC9E3D1CF8F0EA546FDA")
        
@Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (subMenu == null) return false;

            mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.292 -0500", hash_original_method = "847A197D3775740590913F0AAA0D3207", hash_generated_method = "C129A652FE06B93F127434FBC47595B8")
        
@Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            if (menu instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menu).getRootMenu().close(false);
            }
        }
        
    }
    
    private class OpenOverflowRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.296 -0500", hash_original_field = "15DB0E22071AD2DFB4134423692CDBA2", hash_generated_field = "A7832614732810CD7F68AEA244EAE6B6")

        private OverflowPopup mPopup;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.299 -0500", hash_original_method = "599E88E0D73270F72B5C8D6A6C7D2ACA", hash_generated_method = "1E3ED073332B87774B5A0425ABB4E93F")
        
public OpenOverflowRunnable(OverflowPopup popup) {
            mPopup = popup;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.302 -0500", hash_original_method = "A205A4B8116FA6A00F9203B1BEAEE8C7", hash_generated_method = "666E18EB4FD5778233B2875D55F6E054")
        
public void run() {
            mMenu.changeMenuMode();
            final View menuView = (View) mMenuView;
            if (menuView != null && menuView.getWindowToken() != null && mPopup.tryShow()) {
                mOverflowPopup = mPopup;
            }
            mPostedOpenRunnable = null;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:35.233 -0500", hash_original_method = "E6B8634A947A629174EE0649ED3769CC", hash_generated_method = "47CD3F74684B41A48211D2248ED03DCC")
    
@Override
    public void onSubUiVisibilityChanged(boolean isVisible) {
        if (isVisible) {
            // Not a submenu, but treat it like one.
            super.onSubMenuSelected(null);
        } else {
            mMenu.close(false);
        }
    }
}

