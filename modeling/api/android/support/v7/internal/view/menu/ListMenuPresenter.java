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


package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * MenuPresenter for list-style menus.
 *
 * @hide
 */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.725 -0400", hash_original_field = "7453D58C6323935315116FAB26C94EF3", hash_generated_field = "717D86C38917E4DCC5244607A47388C8")

    private static final String TAG = "ListMenuPresenter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.753 -0400", hash_original_field = "CE5F39C1E0AB5F760958B607370926F1", hash_generated_field = "1DC12F3A8197BE0E527127C9DFF8EC62")

    public static final String VIEWS_TAG = "android:menu:list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.728 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.731 -0400", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.733 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

    MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.735 -0400", hash_original_field = "B73614E12B984F9819EE1358997EAA4E", hash_generated_field = "B73614E12B984F9819EE1358997EAA4E")

    ExpandedMenuView mMenuView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.738 -0400", hash_original_field = "3244934A1DA054EDA8D434D3E5715CE4", hash_generated_field = "1847A8F34C35735278587A63D3DF790A")

    private int mItemIndexOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.740 -0400", hash_original_field = "3CCC257450CEEDF9DF4A1B3B44C1CD16", hash_generated_field = "3CCC257450CEEDF9DF4A1B3B44C1CD16")

    int mThemeRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.742 -0400", hash_original_field = "892636E3A464AFFB770DCFC2EBD216F3", hash_generated_field = "892636E3A464AFFB770DCFC2EBD216F3")

    int mItemLayoutRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.745 -0400", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.748 -0400", hash_original_field = "85BD8C2F470603886C61D670BD662E5D", hash_generated_field = "85BD8C2F470603886C61D670BD662E5D")

    MenuAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.750 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;

    /**
     * Construct a new ListMenuPresenter.
     * @param context Context to use for theming. This will supersede the context provided
     *                to initForMenu when this presenter is added.
     * @param itemLayoutRes Layout resource for individual item views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.756 -0400", hash_original_method = "4092EC8E340C70347418ABF573D4B0FE", hash_generated_method = "1BDE95FC60192E649C7C7C15075C5612")
    
public ListMenuPresenter(Context context, int itemLayoutRes) {
        this(itemLayoutRes, 0);
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * Construct a new ListMenuPresenter.
     * @param itemLayoutRes Layout resource for individual item views.
     * @param themeRes Resource ID of a theme to use for views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.759 -0400", hash_original_method = "1CC41FC150F37B76A5F679E2DF486BF3", hash_generated_method = "EDE18B9709DE172DB1C2EBF463B76758")
    
public ListMenuPresenter(int itemLayoutRes, int themeRes) {
        mItemLayoutRes = itemLayoutRes;
        mThemeRes = themeRes;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.762 -0400", hash_original_method = "B06876D268F5C42133E0430317BB8CBD", hash_generated_method = "204354E8A96FC3336C52D3A7623F0334")
    
@Override
    public void initForMenu(Context context, MenuBuilder menu) {
        if (mThemeRes != 0) {
            mContext = new ContextThemeWrapper(context, mThemeRes);
            mInflater = LayoutInflater.from(mContext);
        } else if (mContext != null) {
            mContext = context;
            if (mInflater == null) {
                mInflater = LayoutInflater.from(mContext);
            }
        }
        mMenu = menu;
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.766 -0400", hash_original_method = "0C5FC172E40DC5B2165333A64D406B09", hash_generated_method = "827347CCF65995F39B76ED15BE434A84")
    
@Override
    public MenuView getMenuView(ViewGroup root) {
        if (mAdapter == null) {
            mAdapter = new MenuAdapter();
        }

        if (!mAdapter.isEmpty()) {
            if (mMenuView == null) {
                mMenuView = (ExpandedMenuView) mInflater.inflate(
                        R.layout.abc_expanded_menu_layout, root, false);
                mMenuView.setAdapter(mAdapter);
                mMenuView.setOnItemClickListener(this);
            }
            return mMenuView;
        }

        // If we reach here, the Menu is empty so we have nothing to display
        return null;
    }

    /**
     * Call this instead of getMenuView if you want to manage your own ListView.
     * For proper operation, the ListView hosting this adapter should add
     * this presenter as an OnItemClickListener.
     *
     * @return A ListAdapter containing the items in the menu.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.769 -0400", hash_original_method = "0BC897630B7168BFB6657AF356C42C40", hash_generated_method = "B4E5B75BF7091EBDFCCF01FFF7B9AB1A")
    
public ListAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new MenuAdapter();
        }
        return mAdapter;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.773 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "A036D0BC4ABD4D3959577205F0CFFCB5")
    
@Override
    public void updateMenuView(boolean cleared) {
        if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.775 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "134C4ECD69F6A8E80406A6DEB25A8FB6")
    
@Override
    public void setCallback(Callback cb) {
        mCallback = cb;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.778 -0400", hash_original_method = "A83D74A7B8E34BCB39AA6BC5FD37D18B", hash_generated_method = "D23A503D4380391CFAA054E7CBC2D8E0")
    
@Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (!subMenu.hasVisibleItems()) return false;

        // The window manager will give us a token.
        new MenuDialogHelper(subMenu).show(null);
        if (mCallback != null) {
            mCallback.onOpenSubMenu(subMenu);
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.781 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "FAC3A559CFAC6E70555799B58C4E2B3C")
    
@Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (mCallback != null) {
            mCallback.onCloseMenu(menu, allMenusAreClosing);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.783 -0400", hash_original_method = "475203F60353F2870A802829EBCF2C85", hash_generated_method = "475203F60353F2870A802829EBCF2C85")
    
int getItemIndexOffset() {
        return mItemIndexOffset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.785 -0400", hash_original_method = "F1BE2800305805802DC3B629A73BA0A1", hash_generated_method = "970FABEE9D6B119A3AF41B9086838175")
    
public void setItemIndexOffset(int offset) {
        mItemIndexOffset = offset;
        if (mMenuView != null) {
            updateMenuView(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.789 -0400", hash_original_method = "152ABD8D418D655B6A8705FC87F24FDD", hash_generated_method = "C23174075F4BD3CD98CC0820B18C480F")
    
@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mMenu.performItemAction(mAdapter.getItem(position), 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.791 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "53EA63F11892B6B76B90A02A4F7BB199")
    
@Override
    public boolean flagActionItems() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.794 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "1AC0563B74EC3CB7F8AA75918408F79E")
    
public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.797 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "7FACC901E2C2CF1ADC66B0D53290352D")
    
public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.800 -0400", hash_original_method = "0B368829F15D6906C64A9F7093B6493E", hash_generated_method = "E2D182ABBF8575D0C08F2BC9BB5AED96")
    
public void saveHierarchyState(Bundle outState) {
        SparseArray<Parcelable> viewStates = new SparseArray<Parcelable>();
        if (mMenuView != null) {
            ((View) mMenuView).saveHierarchyState(viewStates);
        }
        outState.putSparseParcelableArray(VIEWS_TAG, viewStates);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.803 -0400", hash_original_method = "E2F747E0F2ADA663434186ED511D575C", hash_generated_method = "6EF6D2B19884659420CC23ADA7EC2F0B")
    
public void restoreHierarchyState(Bundle inState) {
        SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        if (viewStates != null) {
            ((View) mMenuView).restoreHierarchyState(viewStates);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.806 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "2C930A8D49DAA23CEDA00223A5DAF654")
    
public void setId(int id) {
        mId = id;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.808 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "BC4C27E4438CAC23C8715847D5623BF8")
    
@Override
    public int getId() {
        return mId;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.811 -0400", hash_original_method = "C6EC2F945334B683C122C10C6725C92E", hash_generated_method = "F55B563C9EADDCBF46B7CC2E23275808")
    
@Override
    public Parcelable onSaveInstanceState() {
        if (mMenuView == null) {
            return null;
        }

        Bundle state = new Bundle();
        saveHierarchyState(state);
        return state;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.814 -0400", hash_original_method = "4E57F37A0749F365E081EFA3C3A26D3A", hash_generated_method = "4B003FD3C48144E4D83B6FD446FFEF9F")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        restoreHierarchyState((Bundle) state);
    }

    private class MenuAdapter extends BaseAdapter {
        private int mExpandedIndex = -1;

        public MenuAdapter() {
            findExpandedIndex();
        }

        @DSSource({DSSourceKind.DATABASE})
        @DSSafe(DSCat.SAFE_LIST)
        public int getCount() {
            ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            int count = items.size() - mItemIndexOffset;
            if (mExpandedIndex < 0) {
                return count;
            }
            return count - 1;
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        public MenuItemImpl getItem(int position) {
            ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            position += mItemIndexOffset;
            if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                position++;
            }
            return items.get(position);
        }

        @DSSource({DSSourceKind.DATABASE})
        @DSSafe(DSCat.SAFE_LIST)
        public long getItemId(int position) {
            // Since a menu item's ID is optional, we'll use the position as an
            // ID for the item in the AdapterView
            return position;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(mItemLayoutRes, parent, false);
            }

            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            itemView.initialize(getItem(position), 0);
            return convertView;
        }

        @DSSafe(DSCat.SAFE_LIST)
        void findExpandedIndex() {
            final MenuItemImpl expandedItem = mMenu.getExpandedItem();
            if (expandedItem != null) {
                final ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
                final int count = items.size();
                for (int i = 0; i < count; i++) {
                    final MenuItemImpl item = items.get(i);
                    if (item == expandedItem) {
                        mExpandedIndex = i;
                        return;
                    }
                }
            }
            mExpandedIndex = -1;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }
}
