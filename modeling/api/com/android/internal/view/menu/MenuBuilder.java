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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class MenuBuilder implements Menu {

    /**
     * Returns the ordering across all items. This will grab the category from
     * the upper bits, find out how to order the category with respect to other
     * categories, and combine it with the lower bits.
     * 
     * @param categoryOrder The category order for a particular item (if it has
     *            not been or/add with a category, the default category is
     *            assumed).
     * @return An ordering integer that can be used to order this item across
     *         all the items (even from other categories).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.372 -0500", hash_original_method = "AB4BDD448F86ABCFB5158EE9473B24E9", hash_generated_method = "749D3AC8FC13FC40D005BC6946D4BD4B")
    
private static int getOrdering(int categoryOrder) {
        final int index = (categoryOrder & CATEGORY_MASK) >> CATEGORY_SHIFT;
        
        if (index < 0 || index >= sCategoryToOrder.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        
        return (sCategoryToOrder[index] << CATEGORY_SHIFT) | (categoryOrder & USER_MASK);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.393 -0500", hash_original_method = "4FB64200000A934D5859B371B8C54153", hash_generated_method = "BA923F54AF7E62E51A93225456EF376E")
    
private static int findInsertIndex(ArrayList<MenuItemImpl> items, int ordering) {
        for (int i = items.size() - 1; i >= 0; i--) {
            MenuItemImpl item = items.get(i);
            if (item.getOrdering() <= ordering) {
                return i + 1;
            }
        }
        
        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.165 -0500", hash_original_field = "BDD8B6571C6EB31A875D2F348D7E8662", hash_generated_field = "48BEB4E811675B80200D5876BA18B494")

    private static final String TAG = "MenuBuilder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.168 -0500", hash_original_field = "988B00FA75BE60B28470E3561592BB66", hash_generated_field = "FAB6E9F72A015338D850F86B06EED585")

    private static final String PRESENTER_KEY = "android:menu:presenters";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.171 -0500", hash_original_field = "B1339C8C444716D52ABC8AE8B49B2B00", hash_generated_field = "59CB259DC04AF6A04E6B27242510F0F4")

    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.174 -0500", hash_original_field = "EDC6A91F051E6665F116FC47BD204CF0", hash_generated_field = "6F05FC8F413331D8887456984C7CE03C")

    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.177 -0500", hash_original_field = "49EC880223B98573B4C42ED0487AD41C", hash_generated_field = "8C6B059AB28D1ED398AA9094CC2817C5")

    private static final int[]  sCategoryToOrder = new int[] {
        1, /* No category */
        4, /* CONTAINER */
        5, /* SYSTEM */
        3, /* SECONDARY */
        2, /* ALTERNATIVE */
        0, /* SELECTED_ALTERNATIVE */
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.179 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.182 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private  Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.185 -0500", hash_original_field = "6DE08912B7AC8BA99390E81C7E985A72", hash_generated_field = "95645DEF322B7192EFD2A867453899EE")

    private boolean mQwertyMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.188 -0500", hash_original_field = "8C86C3A410DAB8B057DC68A0935F6DA1", hash_generated_field = "F96F6064EBE78C516E4D1B26D5D6F308")
 
    private boolean mShortcutsVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.192 -0500", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.196 -0500", hash_original_field = "B064CC9F30A0A61D7B162FDCFC9E561D", hash_generated_field = "BD34AA609B2F1444C5802546CAFD9E2E")

    private ArrayList<MenuItemImpl> mItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.200 -0500", hash_original_field = "4B84153216C97DA5ECCFAAA99EDA9B6C", hash_generated_field = "D9641413264F8197F037C6D0C97110BC")

    private ArrayList<MenuItemImpl> mVisibleItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.203 -0500", hash_original_field = "76E21189510B375C91C61089582693D2", hash_generated_field = "542DEB4B44629FB64BB72A2F9FFA719F")
 
    private boolean mIsVisibleItemsStale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.206 -0500", hash_original_field = "595D56539175C97D688489A54DBAE528", hash_generated_field = "922EA5B66BFB13CAC326F75845DC9FBF")

    private ArrayList<MenuItemImpl> mActionItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.208 -0500", hash_original_field = "C5A1CC7E3A0FB6AC4A306EEA5ED63847", hash_generated_field = "4FA8D7123D10D7FB60C3300B4743B5E4")

    private ArrayList<MenuItemImpl> mNonActionItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.211 -0500", hash_original_field = "5468810A44AF440BE3DF7AB90D4252A4", hash_generated_field = "4672D8DE4A1D2EDA6E7A30F19E847512")

    private boolean mIsActionItemsStale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.213 -0500", hash_original_field = "09AA30116CCD21FFD0B325DD88D77072", hash_generated_field = "99953610D3798A1652245FC37A11148F")

    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.216 -0500", hash_original_field = "33FACA628FD9887B13FA7E04A3787639", hash_generated_field = "F71D241D22C847CB73D168C1498D3662")

    private ContextMenuInfo mCurrentMenuInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.218 -0500", hash_original_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566", hash_generated_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566")

    CharSequence mHeaderTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.220 -0500", hash_original_field = "1F64D0B7244E48B7E3E328CABEC4A309", hash_generated_field = "1F64D0B7244E48B7E3E328CABEC4A309")

    Drawable mHeaderIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.222 -0500", hash_original_field = "B9C114F754E53BD7622DBFFDE976E899", hash_generated_field = "B9C114F754E53BD7622DBFFDE976E899")

    View mHeaderView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.224 -0500", hash_original_field = "95EA3CA920336810575444591F0711EC", hash_generated_field = "C1392DA651B1F71540302368BB665E1C")

    private SparseArray<Parcelable> mFrozenViewStates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.227 -0500", hash_original_field = "33AF1DD80D160BF46B46C85FDF163FF5", hash_generated_field = "42D2AC432A6B8C4EEEB5401ED2AFDB89")

    private boolean mPreventDispatchingItemsChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.229 -0500", hash_original_field = "8596036781596F1ADB4BA5C0692ACE1B", hash_generated_field = "2CD250962FDCC7A99FD4076F077F63F8")

    private boolean mItemsChangedWhileDispatchPrevented = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.233 -0500", hash_original_field = "ED3FC13AC0D4AD6DD100D365A6D47297", hash_generated_field = "726E83C5EC3729E7BB3D264007C90B65")
    
    private boolean mOptionalIconsVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.235 -0500", hash_original_field = "81FDF82A7F114B07DA6345D2295B16E7", hash_generated_field = "BCD7139A79D8D9F3133E20DC6D3F207A")

    private boolean mIsClosing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.238 -0500", hash_original_field = "112BE6FD20171B89FC965EBA7D30760E", hash_generated_field = "42C64CF6E53F14390A86902028B317E2")

    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.241 -0500", hash_original_field = "1852CECD5CE8910E5BBD86A0AF88A964", hash_generated_field = "AFD9B193D2ECD6C8B664F5067DC23F76")

    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters =
            new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.243 -0500", hash_original_field = "F853FB8CC741C8B524802BF1D4AFE330", hash_generated_field = "E6D19EE97CF34609C2DF041F94F84AE4")

    private MenuItemImpl mExpandedItem;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.252 -0500", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "59A0269E249008BB4C8B590C34F4642E")
    
public MenuBuilder(Context context) {
        mContext = context;
        mResources = context.getResources();
        
        mItems = new ArrayList<MenuItemImpl>();
        
        mVisibleItems = new ArrayList<MenuItemImpl>();
        mIsVisibleItemsStale = true;
        
        mActionItems = new ArrayList<MenuItemImpl>();
        mNonActionItems = new ArrayList<MenuItemImpl>();
        mIsActionItemsStale = true;
        
        setShortcutsVisibleInner(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.254 -0500", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "ED3D0FEB6FFF316D780AAF232450A4A9")
    
public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        mDefaultShowAsAction = defaultShowAsAction;
        return this;
    }

    /**
     * Add a presenter to this menu. This will only hold a WeakReference;
     * you do not need to explicitly remove a presenter, but you can using
     * {@link #removeMenuPresenter(MenuPresenter)}.
     *
     * @param presenter The presenter to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.256 -0500", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "2E2F0876382AFBD0F22E50C17DD7444F")
    
public void addMenuPresenter(MenuPresenter presenter) {
        mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        presenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
    }

    /**
     * Remove a presenter from this menu. That presenter will no longer
     * receive notifications of updates to this menu's data.
     *
     * @param presenter The presenter to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.260 -0500", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "F9B3116187B6D06C2296FD9FCA5447FC")
    
public void removeMenuPresenter(MenuPresenter presenter) {
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter item = ref.get();
            if (item == null || item == presenter) {
                mPresenters.remove(ref);
            }
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.264 -0500", hash_original_method = "54D4EF8A00AA3736A7301B3768CF2956", hash_generated_method = "108C7ABD30363D2CD0440ABCD3CED193")
    
private void dispatchPresenterUpdate(boolean cleared) {
        if (mPresenters.isEmpty()) return;

        stopDispatchingItemsChanged();
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else {
                presenter.updateMenuView(cleared);
            }
        }
        startDispatchingItemsChanged();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.268 -0500", hash_original_method = "972C883CEABE6EAECC969B119D377700", hash_generated_method = "B23BC733CB3766C7C274670D11386FFC")
    
private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        if (mPresenters.isEmpty()) return false;

        boolean result = false;

        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else if (!result) {
                result = presenter.onSubMenuSelected(subMenu);
            }
        }
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.271 -0500", hash_original_method = "8458F949934B8A3332FB7D785BD3E421", hash_generated_method = "1B312263206BF0E774938BDE76C2CC14")
    
private void dispatchSaveInstanceState(Bundle outState) {
        if (mPresenters.isEmpty()) return;

        SparseArray<Parcelable> presenterStates = new SparseArray<Parcelable>();

        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else {
                final int id = presenter.getId();
                if (id > 0) {
                    final Parcelable state = presenter.onSaveInstanceState();
                    if (state != null) {
                        presenterStates.put(id, state);
                    }
                }
            }
        }

        outState.putSparseParcelableArray(PRESENTER_KEY, presenterStates);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.274 -0500", hash_original_method = "4E7750A20EC8141646D41AE332CEFE6A", hash_generated_method = "83AF7BA19DC30BD2F55B5EFB4CF6A7D3")
    
private void dispatchRestoreInstanceState(Bundle state) {
        SparseArray<Parcelable> presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);

        if (presenterStates == null || mPresenters.isEmpty()) return;

        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else {
                final int id = presenter.getId();
                if (id > 0) {
                    Parcelable parcel = presenterStates.get(id);
                    if (parcel != null) {
                        presenter.onRestoreInstanceState(parcel);
                    }
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.277 -0500", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "10914D084BED81458B281AE0F0579247")
    
public void savePresenterStates(Bundle outState) {
        dispatchSaveInstanceState(outState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.280 -0500", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "C716D2B5336C95886B8DFE9CEDDBF31D")
    
public void restorePresenterStates(Bundle state) {
        dispatchRestoreInstanceState(state);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.283 -0500", hash_original_method = "A8F0361C85125DA8A38A18412990521E", hash_generated_method = "5B4BD681FC3DA93D0AEC9C0C2D2AF2B5")
    
public void saveActionViewStates(Bundle outStates) {
        SparseArray<Parcelable> viewStates = null;

        final int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            final MenuItem item = getItem(i);
            final View v = item.getActionView();
            if (v != null && v.getId() != View.NO_ID) {
                if (viewStates == null) {
                    viewStates = new SparseArray<Parcelable>();
                }
                v.saveHierarchyState(viewStates);
                if (item.isActionViewExpanded()) {
                    outStates.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                subMenu.saveActionViewStates(outStates);
            }
        }

        if (viewStates != null) {
            outStates.putSparseParcelableArray(getActionViewStatesKey(), viewStates);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.286 -0500", hash_original_method = "B3A4CB3CCE0DD38C30DBEC80F125B14F", hash_generated_method = "F63AAFD8295050B319BEDBBAD223555D")
    
public void restoreActionViewStates(Bundle states) {
        if (states == null) {
            return;
        }

        SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(
                getActionViewStatesKey());

        final int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            final MenuItem item = getItem(i);
            final View v = item.getActionView();
            if (v != null && v.getId() != View.NO_ID) {
                v.restoreHierarchyState(viewStates);
            }
            if (item.hasSubMenu()) {
                final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                subMenu.restoreActionViewStates(states);
            }
        }

        final int expandedId = states.getInt(EXPANDED_ACTION_VIEW_ID);
        if (expandedId > 0) {
            MenuItem itemToExpand = findItem(expandedId);
            if (itemToExpand != null) {
                itemToExpand.expandActionView();
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.288 -0500", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "C43FBFF198D09072C15469EDE5FE6A8E")
    
protected String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.291 -0500", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "EAFBC13B735460C43524285DBFE0E8D5")
    
public void setCallback(Callback cb) {
        mCallback = cb;
    }
    
    /**
     * Adds an item to the menu.  The other add methods funnel to this.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.294 -0500", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "740C6E67CE35529F8AA48D4F89695092")
    
private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        final int ordering = getOrdering(categoryOrder);
        
        final MenuItemImpl item = new MenuItemImpl(this, group, id, categoryOrder,
                ordering, title, mDefaultShowAsAction);

        if (mCurrentMenuInfo != null) {
            // Pass along the current menu info
            item.setMenuInfo(mCurrentMenuInfo);
        }
        
        mItems.add(findInsertIndex(mItems, ordering), item);
        onItemsChanged(true);
        
        return item;
    }
    
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.297 -0500", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "ECFD1D69981462AED362F22E2C3E516B")
    
public MenuItem add(CharSequence title) {
        return addInternal(0, 0, 0, title);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.300 -0500", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "F91E08CDFC786BE8489CC2DF9AEB7403")
    
public MenuItem add(int titleRes) {
        return addInternal(0, 0, 0, mResources.getString(titleRes));
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.302 -0500", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "1290E718A08BA3BD68F06588BD892D5A")
    
public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        return addInternal(group, id, categoryOrder, title);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.304 -0500", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "1BCE0A389F8E9259A353F1C217B6640D")
    
public MenuItem add(int group, int id, int categoryOrder, int title) {
        return addInternal(group, id, categoryOrder, mResources.getString(title));
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.307 -0500", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "B4429DE02C268E799BB2FA8E818963F6")
    
public SubMenu addSubMenu(CharSequence title) {
        return addSubMenu(0, 0, 0, title);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.310 -0500", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "DE807B64A98409BEBF9BD466957EEB52")
    
public SubMenu addSubMenu(int titleRes) {
        return addSubMenu(0, 0, 0, mResources.getString(titleRes));
    }

    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.313 -0500", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "681ADCB830AC3BBF467B3627BAA4CA65")
    
public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);
        
        return subMenu;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.315 -0500", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "951485A825A0323AD5A418BB1BBE391F")
    
public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        return addSubMenu(group, id, categoryOrder, mResources.getString(title));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.318 -0500", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "09AF5E3235C71C2F158392F5A09134BC")
    
public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri =
                pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        final int N = lri != null ? lri.size() : 0;

        if ((flags & FLAG_APPEND_TO_GROUP) == 0) {
            removeGroup(group);
        }

        for (int i=0; i<N; i++) {
            final ResolveInfo ri = lri.get(i);
            Intent rintent = new Intent(
                ri.specificIndex < 0 ? intent : specifics[ri.specificIndex]);
            rintent.setComponent(new ComponentName(
                    ri.activityInfo.applicationInfo.packageName,
                    ri.activityInfo.name));
            final MenuItem item = add(group, id, categoryOrder, ri.loadLabel(pm))
                    .setIcon(ri.loadIcon(pm))
                    .setIntent(rintent);
            if (outSpecificItems != null && ri.specificIndex >= 0) {
                outSpecificItems[ri.specificIndex] = item;
            }
        }

        return N;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.321 -0500", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "B5477A25C64755562A7A96C9A1AD5B39")
    
public void removeItem(int id) {
        removeItemAtInt(findItemIndex(id), true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.324 -0500", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "CC492E12F387DA815E7E75F9A777D7F7")
    
public void removeGroup(int group) {
        final int i = findGroupIndex(group);

        if (i >= 0) {
            final int maxRemovable = mItems.size() - i;
            int numRemoved = 0;
            while ((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group)) {
                // Don't force update for each one, this method will do it at the end
                removeItemAtInt(i, false);
            }
            
            // Notify menu views
            onItemsChanged(true);
        }
    }

    /**
     * Remove the item at the given index and optionally forces menu views to
     * update.
     * 
     * @param index The index of the item to be removed. If this index is
     *            invalid an exception is thrown.
     * @param updateChildrenOnMenuViews Whether to force update on menu views.
     *            Please make sure you eventually call this after your batch of
     *            removals.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.326 -0500", hash_original_method = "B04372368F85324A2D15939652770F19", hash_generated_method = "E0874B87BD6364048267D6E004DED176")
    
private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        if ((index < 0) || (index >= mItems.size())) return;

        mItems.remove(index);
        
        if (updateChildrenOnMenuViews) onItemsChanged(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.329 -0500", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "AD00C6B6791898002D4D4D5B573A42A6")
    
public void removeItemAt(int index) {
        removeItemAtInt(index, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.332 -0500", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "900546F8F30E94ACE2073AEB7E354AF2")
    
public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }
    
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.335 -0500", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "00DD1BF80D38101BFF904F0C4BEE97AB")
    
public void clear() {
        if (mExpandedItem != null) {
            collapseItemActionView(mExpandedItem);
        }
        mItems.clear();
        
        onItemsChanged(true);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.337 -0500", hash_original_method = "46B444F22731C330EF8C5DDD6085B819", hash_generated_method = "6281679A9C72073D1DB5B0C44DFD1059")
    
void setExclusiveItemChecked(MenuItem item) {
        final int group = item.getGroupId();
        
        final int N = mItems.size();
        for (int i = 0; i < N; i++) {
            MenuItemImpl curItem = mItems.get(i);
            if (curItem.getGroupId() == group) {
                if (!curItem.isExclusiveCheckable()) continue;
                if (!curItem.isCheckable()) continue;
                
                // Check the item meant to be checked, uncheck the others (that are in the group)
                curItem.setCheckedInt(curItem == item);
            }
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.340 -0500", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "83965EA1C3D8BC3C6ED8244E961092ED")
    
public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        final int N = mItems.size();
       
        for (int i = 0; i < N; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.getGroupId() == group) {
                item.setExclusiveCheckable(exclusive);
                item.setCheckable(checkable);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.344 -0500", hash_original_method = "4EDC76E82EDC17A472BC69BB1B6E7C6A", hash_generated_method = "3E44BFF79A1B2D25C56BE88EF657D691")
    
public void setGroupVisible(int group, boolean visible) {
        final int N = mItems.size();

        // We handle the notification of items being changed ourselves, so we use setVisibleInt rather
        // than setVisible and at the end notify of items being changed
        
        boolean changedAtLeastOneItem = false;
        for (int i = 0; i < N; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.getGroupId() == group) {
                if (item.setVisibleInt(visible)) changedAtLeastOneItem = true;
            }
        }

        if (changedAtLeastOneItem) onItemsChanged(true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.346 -0500", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "FCF043D94AF61D6A4EEB39472DC73998")
    
public void setGroupEnabled(int group, boolean enabled) {
        final int N = mItems.size();

        for (int i = 0; i < N; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.349 -0500", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "B179728AD063FFBE23EBEE59141867A2")
    
public boolean hasVisibleItems() {
        final int size = size();

        for (int i = 0; i < size; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.isVisible()) {
                return true;
            }
        }

        return false;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.352 -0500", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "88389DB40EC73A47C02D024091A10CAE")
    
public MenuItem findItem(int id) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.getItemId() == id) {
                return item;
            } else if (item.hasSubMenu()) {
                MenuItem possibleItem = item.getSubMenu().findItem(id);
                
                if (possibleItem != null) {
                    return possibleItem;
                }
            }
        }
        
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.354 -0500", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "00D3433F0B6E8F7FA43DD813BE5215D9")
    
public int findItemIndex(int id) {
        final int size = size();

        for (int i = 0; i < size; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.getItemId() == id) {
                return i;
            }
        }

        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.356 -0500", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "09BA772E4661ADD350F6B6F99AB6D8CB")
    
public int findGroupIndex(int group) {
        return findGroupIndex(group, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.359 -0500", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "637EC233308C7B244D24DD157A068E09")
    
public int findGroupIndex(int group, int start) {
        final int size = size();
        
        if (start < 0) {
            start = 0;
        }
        
        for (int i = start; i < size; i++) {
            final MenuItemImpl item = mItems.get(i);
            
            if (item.getGroupId() == group) {
                return i;
            }
        }

        return -1;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.361 -0500", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "B001909A1E3FF23FBA9BDC7968BCB51C")
    
public int size() {
        return mItems.size();
    }

    /** {@inheritDoc} */
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.363 -0500", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "22137EA46159B80F85AF259824015418")
    
public MenuItem getItem(int index) {
        return mItems.get(index);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.367 -0500", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "38D546BB6324323D246898A2CCF490AD")
    
public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return findItemWithShortcutForKey(keyCode, event) != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.369 -0500", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "342877B2600DCF73EF6B35960EC1CAEE")
    
public void setQwertyMode(boolean isQwerty) {
        mQwertyMode = isQwerty;

        onItemsChanged(false);
    }

    /**
     * @return whether the menu shortcuts are in qwerty mode or not
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.375 -0500", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "D1F1AC187BB0F0066C68CB94F0A9F578")
    
boolean isQwertyMode() {
        return mQwertyMode;
    }

    /**
     * Sets whether the shortcuts should be visible on menus.  Devices without hardware
     * key input will never make shortcuts visible even if this method is passed 'true'.
     * 
     * @param shortcutsVisible Whether shortcuts should be visible (if true and a
     *            menu item does not have a shortcut defined, that item will
     *            still NOT show a shortcut)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.377 -0500", hash_original_method = "5CCA4A69E642C22AB6858AA5EF093CEB", hash_generated_method = "178F4A12ED278BC5FB552551392B7A33")
    
public void setShortcutsVisible(boolean shortcutsVisible) {
        if (mShortcutsVisible == shortcutsVisible) return;

        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.380 -0500", hash_original_method = "BCC95ACBA680BEE1F3E7AD661CBC9615", hash_generated_method = "C0DD107B00063A121E11F1FB11E639C4")
    
private void setShortcutsVisibleInner(boolean shortcutsVisible) {
        mShortcutsVisible = shortcutsVisible
                && mResources.getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS
                && mResources.getBoolean(
                        com.android.internal.R.bool.config_showMenuShortcutsWhenKeyboardPresent);
    }

    /**
     * @return Whether shortcuts should be visible on menus.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.382 -0500", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "9A195667D33C28DCD8CF543587A8CABA")
    
public boolean isShortcutsVisible() {
        return mShortcutsVisible;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.384 -0500", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "9FEC9CB1792EB215E49CBF732B0DBF5B")
    
Resources getResources() {
        return mResources;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.386 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.388 -0500", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E")
    
boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return mCallback != null && mCallback.onMenuItemSelected(menu, item);
    }

    /**
     * Dispatch a mode change event to this menu's callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.391 -0500", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "04332EC9E81435A1752168590F49EE52")
    
public void changeMenuMode() {
        if (mCallback != null) {
            mCallback.onMenuModeChange(this);
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.396 -0500", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "3E58984DE7EFFA8FA7C73309E998FBD1")
    
public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        final MenuItemImpl item = findItemWithShortcutForKey(keyCode, event);

        boolean handled = false;
        
        if (item != null) {
            handled = performItemAction(item, flags);
        }
        
        if ((flags & FLAG_ALWAYS_PERFORM_CLOSE) != 0) {
            close(true);
        }
        
        return handled;
    }

    /*
     * This function will return all the menu and sub-menu items that can
     * be directly (the shortcut directly corresponds) and indirectly
     * (the ALT-enabled char corresponds to the shortcut) associated
     * with the keyCode.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.399 -0500", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "13CBACAD956532D478C62B77A8439F6C")
    
void findItemsWithShortcutForKey(List<MenuItemImpl> items, int keyCode, KeyEvent event) {
        final boolean qwerty = isQwertyMode();
        final int metaState = event.getMetaState();
        final KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        // Get the chars associated with the keyCode (i.e using any chording combo)
        final boolean isKeyCodeMapped = event.getKeyData(possibleChars);
        // The delete key is not mapped to '\b' so we treat it specially
        if (!isKeyCodeMapped && (keyCode != KeyEvent.KEYCODE_DEL)) {
            return;
        }

        // Look for an item whose shortcut is this key.
        final int N = mItems.size();
        for (int i = 0; i < N; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.hasSubMenu()) {
                ((MenuBuilder)item.getSubMenu()).findItemsWithShortcutForKey(items, keyCode, event);
            }
            final char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
            if (((metaState & (KeyEvent.META_SHIFT_ON | KeyEvent.META_SYM_ON)) == 0) &&
                  (shortcutChar != 0) &&
                  (shortcutChar == possibleChars.meta[0]
                      || shortcutChar == possibleChars.meta[2]
                      || (qwerty && shortcutChar == '\b' &&
                          keyCode == KeyEvent.KEYCODE_DEL)) &&
                  item.isEnabled()) {
                items.add(item);
            }
        }
    }

    /*
     * We want to return the menu item associated with the key, but if there is no
     * ambiguity (i.e. there is only one menu item corresponding to the key) we want
     * to return it even if it's not an exact match; this allow the user to
     * _not_ use the ALT key for example, making the use of shortcuts slightly more
     * user-friendly. An example is on the G1, '!' and '1' are on the same key, and
     * in Gmail, Menu+1 will trigger Menu+! (the actual shortcut).
     *
     * On the other hand, if two (or more) shortcuts corresponds to the same key,
     * we have to only return the exact match.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.402 -0500", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "2690F0C745B113B352B8161E2A1D4467")
    
MenuItemImpl findItemWithShortcutForKey(int keyCode, KeyEvent event) {
        // Get all items that can be associated directly or indirectly with the keyCode
        ArrayList<MenuItemImpl> items = mTempShortcutItemList;
        items.clear();
        findItemsWithShortcutForKey(items, keyCode, event);

        if (items.isEmpty()) {
            return null;
        }

        final int metaState = event.getMetaState();
        final KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        // Get the chars associated with the keyCode (i.e using any chording combo)
        event.getKeyData(possibleChars);

        // If we have only one element, we can safely returns it
        final int size = items.size();
        if (size == 1) {
            return items.get(0);
        }

        final boolean qwerty = isQwertyMode();
        // If we found more than one item associated with the key,
        // we have to return the exact match
        for (int i = 0; i < size; i++) {
            final MenuItemImpl item = items.get(i);
            final char shortcutChar = qwerty ? item.getAlphabeticShortcut() :
                    item.getNumericShortcut();
            if ((shortcutChar == possibleChars.meta[0] &&
                    (metaState & KeyEvent.META_ALT_ON) == 0)
                || (shortcutChar == possibleChars.meta[2] &&
                    (metaState & KeyEvent.META_ALT_ON) != 0)
                || (qwerty && shortcutChar == '\b' &&
                    keyCode == KeyEvent.KEYCODE_DEL)) {
                return item;
            }
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.404 -0500", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "2F6A4720A1CA007EBCA1A7580A2401C2")
    
public boolean performIdentifierAction(int id, int flags) {
        // Look for an item whose identifier is the id.
        return performItemAction(findItem(id), flags);           
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.407 -0500", hash_original_method = "35FE8CE6C993B07CD0CB9DB44F8CBE25", hash_generated_method = "BD93F78D9CC3DD5F116A11776F553E97")

    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public boolean performItemAction(MenuItem item, int flags) {
        MenuItemImpl itemImpl = (MenuItemImpl) item;
        
        if (itemImpl == null || !itemImpl.isEnabled()) {
            return false;
        }

        boolean invoked = itemImpl.invoke();

        if (itemImpl.hasCollapsibleActionView()) {
            invoked |= itemImpl.expandActionView();
            if (invoked) close(true);
        } else if (item.hasSubMenu()) {
            close(false);

            final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
            final ActionProvider provider = item.getActionProvider();
            if (provider != null && provider.hasSubMenu()) {
                provider.onPrepareSubMenu(subMenu);
            }
            invoked |= dispatchSubMenuSelected(subMenu);
            if (!invoked) close(true);
        } else {
            if ((flags & FLAG_PERFORM_NO_CLOSE) == 0) {
                close(true);
            }
        }
        
        return invoked;
    }
    
    /**
     * Closes the visible menu.
     * 
     * @param allMenusAreClosing Whether the menus are completely closing (true),
     *            or whether there is another menu coming in this menu's place
     *            (false). For example, if the menu is closing because a
     *            sub menu is about to be shown, <var>allMenusAreClosing</var>
     *            is false.
     */
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.409 -0500", hash_original_method = "95071F981B5536F482A785105041F83F", hash_generated_method = "295FFD5A37903AC0C7BEBC2849AF39BB")
    
final void close(boolean allMenusAreClosing) {
        if (mIsClosing) return;

        mIsClosing = true;
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else {
                presenter.onCloseMenu(this, allMenusAreClosing);
            }
        }
        mIsClosing = false;
    }

    /** {@inheritDoc} */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.413 -0500", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "5A3337BA0DCEE457132408A727907816")
    
public void close() {
        close(true);
    }

    /**
     * Called when an item is added or removed.
     * 
     * @param structureChanged true if the menu structure changed,
     *                         false if only item properties changed.
     *                         (Visibility is a structural property since it affects layout.)
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.415 -0500", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "5A795AB2D4E1ABD04FD81F99B25E4230")
    
void onItemsChanged(boolean structureChanged) {
        if (!mPreventDispatchingItemsChanged) {
            if (structureChanged) {
                mIsVisibleItemsStale = true;
                mIsActionItemsStale = true;
            }

            dispatchPresenterUpdate(structureChanged);
        } else {
            mItemsChangedWhileDispatchPrevented = true;
        }
    }

    /**
     * Stop dispatching item changed events to presenters until
     * {@link #startDispatchingItemsChanged()} is called. Useful when
     * many menu operations are going to be performed as a batch.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.417 -0500", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "54B49F152368499C228B25909249F559")
    
public void stopDispatchingItemsChanged() {
        if (!mPreventDispatchingItemsChanged) {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.420 -0500", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "EC57A12CA4341BF10C223A5029126181")
    
public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;

        if (mItemsChangedWhileDispatchPrevented) {
            mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        }
    }

    /**
     * Called by {@link MenuItemImpl} when its visible flag is changed.
     * @param item The item that has gone through a visibility change.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.422 -0500", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "FC8365D69C1929C714BDAF678F9DEAAB")
    
void onItemVisibleChanged(MenuItemImpl item) {
        // Notify of items being changed
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }
    
    /**
     * Called by {@link MenuItemImpl} when its action request status is changed.
     * @param item The item that has gone through a change in action request status.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.424 -0500", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "5BE5B811E0A15BA5DFF4B297A55C9C11")
    
void onItemActionRequestChanged(MenuItemImpl item) {
        // Notify of items being changed
        mIsActionItemsStale = true;
        onItemsChanged(true);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.426 -0500", hash_original_method = "66450A6B071A6D6254ADE6AFA4286392", hash_generated_method = "16FA5F5FA7B952189FBC4EABDEF0DDE3")
    
ArrayList<MenuItemImpl> getVisibleItems() {
        if (!mIsVisibleItemsStale) return mVisibleItems;
        
        // Refresh the visible items
        mVisibleItems.clear();
        
        final int itemsSize = mItems.size(); 
        MenuItemImpl item;
        for (int i = 0; i < itemsSize; i++) {
            item = mItems.get(i);
            if (item.isVisible()) mVisibleItems.add(item);
        }
        
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
        
        return mVisibleItems;
    }

    /**
     * This method determines which menu items get to be 'action items' that will appear
     * in an action bar and which items should be 'overflow items' in a secondary menu.
     * The rules are as follows:
     *
     * <p>Items are considered for inclusion in the order specified within the menu.
     * There is a limit of mMaxActionItems as a total count, optionally including the overflow
     * menu button itself. This is a soft limit; if an item shares a group ID with an item
     * previously included as an action item, the new item will stay with its group and become
     * an action item itself even if it breaks the max item count limit. This is done to
     * limit the conceptual complexity of the items presented within an action bar. Only a few
     * unrelated concepts should be presented to the user in this space, and groups are treated
     * as a single concept.
     *
     * <p>There is also a hard limit of consumed measurable space: mActionWidthLimit. This
     * limit may be broken by a single item that exceeds the remaining space, but no further
     * items may be added. If an item that is part of a group cannot fit within the remaining
     * measured width, the entire group will be demoted to overflow. This is done to ensure room
     * for navigation and other affordances in the action bar as well as reduce general UI clutter.
     *
     * <p>The space freed by demoting a full group cannot be consumed by future menu items.
     * Once items begin to overflow, all future items become overflow items as well. This is
     * to avoid inadvertent reordering that may break the app's intended design.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.429 -0500", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "819D674D4BF35BB2826B689834C10848")
    
public void flagActionItems() {
        if (!mIsActionItemsStale) {
            return;
        }

        // Presenters flag action items as needed.
        boolean flagged = false;
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else {
                flagged |= presenter.flagActionItems();
            }
        }

        if (flagged) {
            mActionItems.clear();
            mNonActionItems.clear();
            ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
            final int itemsSize = visibleItems.size();
            for (int i = 0; i < itemsSize; i++) {
                MenuItemImpl item = visibleItems.get(i);
                if (item.isActionButton()) {
                    mActionItems.add(item);
                } else {
                    mNonActionItems.add(item);
                }
            }
        } else {
            // Nobody flagged anything, everything is a non-action item.
            // (This happens during a first pass with no action-item presenters.)
            mActionItems.clear();
            mNonActionItems.clear();
            mNonActionItems.addAll(getVisibleItems());
        }
        mIsActionItemsStale = false;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.431 -0500", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D")
    
ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return mActionItems;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.433 -0500", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "B350BF5A73D0E23634B50CFF93D74F82")
    
ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return mNonActionItems;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.436 -0500", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "1E8846ADB7D3682B77181A0DD3F79587")
    
public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;
        
        onItemsChanged(false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.438 -0500", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "B6D889A1AEA91E81BADED2B7F96A4B64")
    
private void setHeaderInternal(final int titleRes, final CharSequence title, final int iconRes,
            final Drawable icon, final View view) {
        final Resources r = getResources();

        if (view != null) {
            mHeaderView = view;
            
            // If using a custom view, then the title and icon aren't used
            mHeaderTitle = null;
            mHeaderIcon = null;
        } else {
            if (titleRes > 0) {
                mHeaderTitle = r.getText(titleRes);
            } else if (title != null) {
                mHeaderTitle = title;
            }
            
            if (iconRes > 0) {
                mHeaderIcon = r.getDrawable(iconRes);
            } else if (icon != null) {
                mHeaderIcon = icon;
            }
            
            // If using the title or icon, then a custom view isn't used
            mHeaderView = null;
        }
        
        // Notify of change
        onItemsChanged(false);
    }

    /**
     * Sets the header's title. This replaces the header view. Called by the
     * builder-style methods of subclasses.
     * 
     * @param title The new title.
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.441 -0500", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "93E73DB410B322A2E8CB22BFA0534195")
    
protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        setHeaderInternal(0, title, 0, null, null);
        return this;
    }
    
    /**
     * Sets the header's title. This replaces the header view. Called by the
     * builder-style methods of subclasses.
     * 
     * @param titleRes The new title (as a resource ID).
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.444 -0500", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "1D147CC8A2A32A42BF2325E3C8A6710C")
    
protected MenuBuilder setHeaderTitleInt(int titleRes) {
        setHeaderInternal(titleRes, null, 0, null, null);
        return this;
    }
    
    /**
     * Sets the header's icon. This replaces the header view. Called by the
     * builder-style methods of subclasses.
     * 
     * @param icon The new icon.
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.446 -0500", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "D590294212DB66D75A31666770D0F68B")
    
protected MenuBuilder setHeaderIconInt(Drawable icon) {
        setHeaderInternal(0, null, 0, icon, null);
        return this;
    }
    
    /**
     * Sets the header's icon. This replaces the header view. Called by the
     * builder-style methods of subclasses.
     * 
     * @param iconRes The new icon (as a resource ID).
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.448 -0500", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "C85E93E0AB88405DDF9B79047F9F0BDF")
    
protected MenuBuilder setHeaderIconInt(int iconRes) {
        setHeaderInternal(0, null, iconRes, null, null);
        return this;
    }
    
    /**
     * Sets the header's view. This replaces the title and icon. Called by the
     * builder-style methods of subclasses.
     * 
     * @param view The new view.
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.450 -0500", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "069FA8DC507DEE97E9170C7B4812D0F5")
    
protected MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.452 -0500", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "4971B8046CA65437C4A89E8856DA0C5F")
    
public CharSequence getHeaderTitle() {
        return mHeaderTitle;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.454 -0500", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "1695283F922A56D19F4CDB805DB5B953")
    
public Drawable getHeaderIcon() {
        return mHeaderIcon;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.457 -0500", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "E4FB4C66A0CBA192257FE6D3538CD4CE")
    
public View getHeaderView() {
        return mHeaderView;
    }
    
    /**
     * Gets the root menu (if this is a submenu, find its root menu).
     * @return The root menu.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.460 -0500", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "61A49898FE7D323B9B36916018F4AD53")
    
public MenuBuilder getRootMenu() {
        return this;
    }
    
    /**
     * Sets the current menu info that is set on all items added to this menu
     * (until this is called again with different menu info, in which case that
     * one will be added to all subsequent item additions).
     * 
     * @param menuInfo The extra menu information to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.462 -0500", hash_original_method = "8B5C0DAA8A7CB0B223A94346B39E6366", hash_generated_method = "FC68554E43902A0F5C30818587AF02DC")
    
public void setCurrentMenuInfo(ContextMenuInfo menuInfo) {
        mCurrentMenuInfo = menuInfo;
    }
    
    public interface Callback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onMenuModeChange(MenuBuilder menu);
    }
    
    public interface ItemInvoker {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean invokeItem(MenuItemImpl item);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.464 -0500", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "5006D7919DE7388D9F9EDDAFF142B475")
    
void setOptionalIconsVisible(boolean visible) {
        mOptionalIconsVisible = visible;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.466 -0500", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "E16B8D475B8F5B112A4C02A29314D988")
    
boolean getOptionalIconsVisible() {
        return mOptionalIconsVisible;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.468 -0500", hash_original_method = "EE8D5D3489A1A55A6EA94D4BFD84A637", hash_generated_method = "2E8B41558356F30E602E1E83EDC2E82E")
    
public boolean expandItemActionView(MenuItemImpl item) {
        if (mPresenters.isEmpty()) return false;

        boolean expanded = false;

        stopDispatchingItemsChanged();
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else if ((expanded = presenter.expandItemActionView(this, item))) {
                break;
            }
        }
        startDispatchingItemsChanged();

        if (expanded) {
            mExpandedItem = item;
        }
        return expanded;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.471 -0500", hash_original_method = "06F25D2FDACA8E4F633278E442B2C78B", hash_generated_method = "8664E45B74632231F3A35BBAD37F330D")
    
public boolean collapseItemActionView(MenuItemImpl item) {
        if (mPresenters.isEmpty() || mExpandedItem != item) return false;

        boolean collapsed = false;

        stopDispatchingItemsChanged();
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter presenter = ref.get();
            if (presenter == null) {
                mPresenters.remove(ref);
            } else if ((collapsed = presenter.collapseItemActionView(this, item))) {
                break;
            }
        }
        startDispatchingItemsChanged();

        if (collapsed) {
            mExpandedItem = null;
        }
        return collapsed;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:36.473 -0500", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "A6B23AF14DD01F8979C2D36F12D52037")
    
public MenuItemImpl getExpandedItem() {
        return mExpandedItem;
    }
}

