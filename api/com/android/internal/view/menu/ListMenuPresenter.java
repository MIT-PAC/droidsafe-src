/*
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

package com.android.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
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
 */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.892 -0400", hash_original_field = "7453D58C6323935315116FAB26C94EF3", hash_generated_field = "717D86C38917E4DCC5244607A47388C8")

    private static final String TAG = "ListMenuPresenter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.903 -0400", hash_original_field = "CE5F39C1E0AB5F760958B607370926F1", hash_generated_field = "1DC12F3A8197BE0E527127C9DFF8EC62")

    public static final String VIEWS_TAG = "android:menu:list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.893 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.894 -0400", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.895 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

    MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.896 -0400", hash_original_field = "B73614E12B984F9819EE1358997EAA4E", hash_generated_field = "B73614E12B984F9819EE1358997EAA4E")

    ExpandedMenuView mMenuView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.897 -0400", hash_original_field = "3244934A1DA054EDA8D434D3E5715CE4", hash_generated_field = "1847A8F34C35735278587A63D3DF790A")

    private int mItemIndexOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.898 -0400", hash_original_field = "3CCC257450CEEDF9DF4A1B3B44C1CD16", hash_generated_field = "3CCC257450CEEDF9DF4A1B3B44C1CD16")

    int mThemeRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.899 -0400", hash_original_field = "892636E3A464AFFB770DCFC2EBD216F3", hash_generated_field = "892636E3A464AFFB770DCFC2EBD216F3")

    int mItemLayoutRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.900 -0400", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.901 -0400", hash_original_field = "85BD8C2F470603886C61D670BD662E5D", hash_generated_field = "85BD8C2F470603886C61D670BD662E5D")

    MenuAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.902 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;

    /**
     * Construct a new ListMenuPresenter.
     * @param context Context to use for theming. This will supersede the context provided
     *                to initForMenu when this presenter is added.
     * @param itemLayoutRes Layout resource for individual item views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.904 -0400", hash_original_method = "4092EC8E340C70347418ABF573D4B0FE", hash_generated_method = "1BDE95FC60192E649C7C7C15075C5612")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.905 -0400", hash_original_method = "1CC41FC150F37B76A5F679E2DF486BF3", hash_generated_method = "EDE18B9709DE172DB1C2EBF463B76758")
    
public ListMenuPresenter(int itemLayoutRes, int themeRes) {
        mItemLayoutRes = itemLayoutRes;
        mThemeRes = themeRes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.906 -0400", hash_original_method = "41B8179DE0AE53E84551731A0EA1D070", hash_generated_method = "9A6B51A176564BAF8CFBD5611D14B0FF")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.908 -0400", hash_original_method = "3C96043E10907F3E55134DF1DC938116", hash_generated_method = "6051E7B8239906C09308EDD03BCEDDA8")
    
@Override
    public MenuView getMenuView(ViewGroup root) {
        if (mMenuView == null) {
            mMenuView = (ExpandedMenuView) mInflater.inflate(
                    com.android.internal.R.layout.expanded_menu_layout, root, false);
            if (mAdapter == null) {
                mAdapter = new MenuAdapter();
            }
            mMenuView.setAdapter(mAdapter);
            mMenuView.setOnItemClickListener(this);
        }
        return mMenuView;
    }

    /**
     * Call this instead of getMenuView if you want to manage your own ListView.
     * For proper operation, the ListView hosting this adapter should add
     * this presenter as an OnItemClickListener.
     *
     * @return A ListAdapter containing the items in the menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.909 -0400", hash_original_method = "0BC897630B7168BFB6657AF356C42C40", hash_generated_method = "B4E5B75BF7091EBDFCCF01FFF7B9AB1A")
    
public ListAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new MenuAdapter();
        }
        return mAdapter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.910 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "A036D0BC4ABD4D3959577205F0CFFCB5")
    
@Override
    public void updateMenuView(boolean cleared) {
        if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.911 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "134C4ECD69F6A8E80406A6DEB25A8FB6")
    
@Override
    public void setCallback(Callback cb) {
        mCallback = cb;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.911 -0400", hash_original_method = "A83D74A7B8E34BCB39AA6BC5FD37D18B", hash_generated_method = "D23A503D4380391CFAA054E7CBC2D8E0")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.912 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "FAC3A559CFAC6E70555799B58C4E2B3C")
    
@Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (mCallback != null) {
            mCallback.onCloseMenu(menu, allMenusAreClosing);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.913 -0400", hash_original_method = "475203F60353F2870A802829EBCF2C85", hash_generated_method = "475203F60353F2870A802829EBCF2C85")
    
int getItemIndexOffset() {
        return mItemIndexOffset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.914 -0400", hash_original_method = "F1BE2800305805802DC3B629A73BA0A1", hash_generated_method = "970FABEE9D6B119A3AF41B9086838175")
    
public void setItemIndexOffset(int offset) {
        mItemIndexOffset = offset;
        if (mMenuView != null) {
            updateMenuView(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.915 -0400", hash_original_method = "152ABD8D418D655B6A8705FC87F24FDD", hash_generated_method = "C23174075F4BD3CD98CC0820B18C480F")
    
@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mMenu.performItemAction(mAdapter.getItem(position), 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.916 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "53EA63F11892B6B76B90A02A4F7BB199")
    
@Override
    public boolean flagActionItems() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.917 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "1AC0563B74EC3CB7F8AA75918408F79E")
    
public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.918 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "7FACC901E2C2CF1ADC66B0D53290352D")
    
public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.918 -0400", hash_original_method = "0B368829F15D6906C64A9F7093B6493E", hash_generated_method = "E2D182ABBF8575D0C08F2BC9BB5AED96")
    
public void saveHierarchyState(Bundle outState) {
        SparseArray<Parcelable> viewStates = new SparseArray<Parcelable>();
        if (mMenuView != null) {
            ((View) mMenuView).saveHierarchyState(viewStates);
        }
        outState.putSparseParcelableArray(VIEWS_TAG, viewStates);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.919 -0400", hash_original_method = "E2F747E0F2ADA663434186ED511D575C", hash_generated_method = "6EF6D2B19884659420CC23ADA7EC2F0B")
    
public void restoreHierarchyState(Bundle inState) {
        SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        if (viewStates != null) {
            ((View) mMenuView).restoreHierarchyState(viewStates);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.920 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "2C930A8D49DAA23CEDA00223A5DAF654")
    
public void setId(int id) {
        mId = id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.921 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "BC4C27E4438CAC23C8715847D5623BF8")
    
@Override
    public int getId() {
        return mId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.923 -0400", hash_original_method = "C6EC2F945334B683C122C10C6725C92E", hash_generated_method = "F55B563C9EADDCBF46B7CC2E23275808")
    
@Override
    public Parcelable onSaveInstanceState() {
        if (mMenuView == null) {
            return null;
        }

        Bundle state = new Bundle();
        saveHierarchyState(state);
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.924 -0400", hash_original_method = "4E57F37A0749F365E081EFA3C3A26D3A", hash_generated_method = "4B003FD3C48144E4D83B6FD446FFEF9F")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        restoreHierarchyState((Bundle) state);
    }

    private class MenuAdapter extends BaseAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.925 -0400", hash_original_field = "7E186A2BE2043157042746F1BCB8A7FE", hash_generated_field = "368B0C631D5267EB3E3C8F80E65C4B4E")

        private int mExpandedIndex = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.926 -0400", hash_original_method = "ABCEFA626F143922FD6B0198F9257B42", hash_generated_method = "A387D4FE30169DC6B4DB9CFBE3B8A7D4")
        
public MenuAdapter() {
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.927 -0400", hash_original_method = "B075C2C9F817A6815A344733B4AD8984", hash_generated_method = "96013AFE965FFA9318D08CC5ABAC40B9")
        
public int getCount() {
            ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            int count = items.size() - mItemIndexOffset;
            if (mExpandedIndex < 0) {
                return count;
            }
            return count - 1;
        }

        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSSpec(DSCat.DB_CURSOR)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.928 -0400", hash_original_method = "73E2A4B1E49DC28C05ECD9BBA4CB2D70", hash_generated_method = "5EB7275EFDB5148D4A8658694B6545B8")
        
public MenuItemImpl getItem(int position) {
            ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            position += mItemIndexOffset;
            if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                position++;
            }
            return items.get(position);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.929 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "8CA03C062FFB619062E87AB7922D9645")
        
public long getItemId(int position) {
            // Since a menu item's ID is optional, we'll use the position as an
            // ID for the item in the AdapterView
            return position;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.930 -0400", hash_original_method = "C1F4941101A1C702C14329F2D59B1A57", hash_generated_method = "2FC6379C887290ED4CD90E26BC1D2347")
        
public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(mItemLayoutRes, parent, false);
            }

            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            itemView.initialize(getItem(position), 0);
            return convertView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.931 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "8514B841FB70F13278F6FFF144403E57")
        
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
    }

    private class ExpandedIndexObserver extends DataSetObserver {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:23.933 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "03DDDCD5D2F2E75C2A869506E1006BA0")
        
@Override
        public void onChanged() {
            mAdapter.findExpandedIndex();
        }
    }
}
