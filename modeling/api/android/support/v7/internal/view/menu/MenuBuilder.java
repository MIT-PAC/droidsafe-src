// Copyright 2012 Google Inc. All Rights Reserved.

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v4.view.ActionProvider;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implementation of the {@link android.support.v4.internal.view.SupportMenu} interface for creating a
 * standard menu UI.
 *
 * @hide
 */
public class MenuBuilder implements SupportMenu {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.328 -0400", hash_original_field = "BDD8B6571C6EB31A875D2F348D7E8662", hash_generated_field = "48BEB4E811675B80200D5876BA18B494")

    private static final String TAG = "MenuBuilder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.331 -0400", hash_original_field = "988B00FA75BE60B28470E3561592BB66", hash_generated_field = "FAB6E9F72A015338D850F86B06EED585")

    private static final String PRESENTER_KEY = "android:menu:presenters";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.333 -0400", hash_original_field = "B1339C8C444716D52ABC8AE8B49B2B00", hash_generated_field = "59CB259DC04AF6A04E6B27242510F0F4")

    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.336 -0400", hash_original_field = "EDC6A91F051E6665F116FC47BD204CF0", hash_generated_field = "6F05FC8F413331D8887456984C7CE03C")

    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.339 -0400", hash_original_field = "49EC880223B98573B4C42ED0487AD41C", hash_generated_field = "8C6B059AB28D1ED398AA9094CC2817C5")

    private static final int[] sCategoryToOrder = new int[]{
            1, /* No category */
            4, /* CONTAINER */
            5, /* SYSTEM */
            3, /* SECONDARY */
            2, /* ALTERNATIVE */
            0, /* SELECTED_ALTERNATIVE */
    };

    /**
     * Returns the ordering across all items. This will grab the category from the upper bits, find
     * out how to order the category with respect to other categories, and combine it with the lower
     * bits.
     *
     * @param categoryOrder The category order for a particular item (if it has not been or/add with
     *                      a category, the default category is assumed).
     * @return An ordering integer that can be used to order this item across all the items (even
     *         from other categories).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.583 -0400", hash_original_method = "AB4BDD448F86ABCFB5158EE9473B24E9", hash_generated_method = "749D3AC8FC13FC40D005BC6946D4BD4B")
            
private static int getOrdering(int categoryOrder) {
        final int index = (categoryOrder & CATEGORY_MASK) >> CATEGORY_SHIFT;

        if (index < 0 || index >= sCategoryToOrder.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }

        return (sCategoryToOrder[index] << CATEGORY_SHIFT) | (categoryOrder & USER_MASK);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.608 -0400", hash_original_method = "4FB64200000A934D5859B371B8C54153", hash_generated_method = "BA923F54AF7E62E51A93225456EF376E")
            
private static int findInsertIndex(ArrayList<MenuItemImpl> items, int ordering) {
        for (int i = items.size() - 1; i >= 0; i--) {
            MenuItemImpl item = items.get(i);
            if (item.getOrdering() <= ordering) {
                return i + 1;
            }
        }

        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.342 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.345 -0400", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private  Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.348 -0400", hash_original_field = "6DE08912B7AC8BA99390E81C7E985A72", hash_generated_field = "95645DEF322B7192EFD2A867453899EE")

    private boolean mQwertyMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.350 -0400", hash_original_field = "8C86C3A410DAB8B057DC68A0935F6DA1", hash_generated_field = "F96F6064EBE78C516E4D1B26D5D6F308")

    private boolean mShortcutsVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.352 -0400", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.354 -0400", hash_original_field = "B064CC9F30A0A61D7B162FDCFC9E561D", hash_generated_field = "BD34AA609B2F1444C5802546CAFD9E2E")

    private ArrayList<MenuItemImpl> mItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.357 -0400", hash_original_field = "4B84153216C97DA5ECCFAAA99EDA9B6C", hash_generated_field = "D9641413264F8197F037C6D0C97110BC")

    private ArrayList<MenuItemImpl> mVisibleItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.360 -0400", hash_original_field = "76E21189510B375C91C61089582693D2", hash_generated_field = "542DEB4B44629FB64BB72A2F9FFA719F")

    private boolean mIsVisibleItemsStale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.362 -0400", hash_original_field = "595D56539175C97D688489A54DBAE528", hash_generated_field = "922EA5B66BFB13CAC326F75845DC9FBF")

    private ArrayList<MenuItemImpl> mActionItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.365 -0400", hash_original_field = "C5A1CC7E3A0FB6AC4A306EEA5ED63847", hash_generated_field = "4FA8D7123D10D7FB60C3300B4743B5E4")

    private ArrayList<MenuItemImpl> mNonActionItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.367 -0400", hash_original_field = "5468810A44AF440BE3DF7AB90D4252A4", hash_generated_field = "4672D8DE4A1D2EDA6E7A30F19E847512")

    private boolean mIsActionItemsStale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.370 -0400", hash_original_field = "0D6BC88F2983DE6630CECABD3413130D", hash_generated_field = "C0B5E3F86F65C8B41C33B0FFD3B13580")

    private int mDefaultShowAsAction = SupportMenuItem.SHOW_AS_ACTION_NEVER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.373 -0400", hash_original_field = "B1B21C154FA738F40C21D6C582E7E21F", hash_generated_field = "8B3A10295627AD38D9FFEA3ACD1C61E3")

    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.376 -0400", hash_original_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566", hash_generated_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566")

    CharSequence mHeaderTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.378 -0400", hash_original_field = "1F64D0B7244E48B7E3E328CABEC4A309", hash_generated_field = "1F64D0B7244E48B7E3E328CABEC4A309")

    Drawable mHeaderIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.381 -0400", hash_original_field = "B9C114F754E53BD7622DBFFDE976E899", hash_generated_field = "B9C114F754E53BD7622DBFFDE976E899")

    View mHeaderView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.384 -0400", hash_original_field = "33AF1DD80D160BF46B46C85FDF163FF5", hash_generated_field = "42D2AC432A6B8C4EEEB5401ED2AFDB89")

    private boolean mPreventDispatchingItemsChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.390 -0400", hash_original_field = "8596036781596F1ADB4BA5C0692ACE1B", hash_generated_field = "2CD250962FDCC7A99FD4076F077F63F8")

    private boolean mItemsChangedWhileDispatchPrevented = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.392 -0400", hash_original_field = "ED3FC13AC0D4AD6DD100D365A6D47297", hash_generated_field = "726E83C5EC3729E7BB3D264007C90B65")

    private boolean mOptionalIconsVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.394 -0400", hash_original_field = "81FDF82A7F114B07DA6345D2295B16E7", hash_generated_field = "BCD7139A79D8D9F3133E20DC6D3F207A")

    private boolean mIsClosing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.397 -0400", hash_original_field = "112BE6FD20171B89FC965EBA7D30760E", hash_generated_field = "42C64CF6E53F14390A86902028B317E2")

    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();

    /**
     * Called by menu to notify of close and selection changes.
     * @hide
     */
    public interface Callback {

        /**
         * Called when a menu item is selected.
         *
         * @param menu The menu that is the parent of the item
         * @param item The menu item that is selected
         * @return whether the menu item selection was handled
         */
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item);

        /**
         * Called when the mode of the menu changes (for example, from icon to expanded).
         *
         * @param menu the menu that has changed modes
         */
        public void onMenuModeChange(MenuBuilder menu);
    }

    /**
     * Called by menu items to execute their associated action
     * @hide
     */
    public interface ItemInvoker {

        public boolean invokeItem(MenuItemImpl item);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.400 -0400", hash_original_field = "1852CECD5CE8910E5BBD86A0AF88A964", hash_generated_field = "AFD9B193D2ECD6C8B664F5067DC23F76")

    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters =
            new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.402 -0400", hash_original_field = "F853FB8CC741C8B524802BF1D4AFE330", hash_generated_field = "E6D19EE97CF34609C2DF041F94F84AE4")

    private MenuItemImpl mExpandedItem;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.412 -0400", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "59A0269E249008BB4C8B590C34F4642E")
            
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.415 -0400", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "ED3D0FEB6FFF316D780AAF232450A4A9")
            
public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        mDefaultShowAsAction = defaultShowAsAction;
        return this;
    }

    /**
     * Add a presenter to this menu. This will only hold a WeakReference; you do not need to
     * explicitly remove a presenter, but you can using {@link #removeMenuPresenter(MenuPresenter)}.
     *
     * @param presenter The presenter to add
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.418 -0400", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "2E2F0876382AFBD0F22E50C17DD7444F")
            
public void addMenuPresenter(MenuPresenter presenter) {
        mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        presenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
    }

    /**
     * Remove a presenter from this menu. That presenter will no longer receive notifications of
     * updates to this menu's data.
     *
     * @param presenter The presenter to remove
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.421 -0400", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "F9B3116187B6D06C2296FD9FCA5447FC")
            
public void removeMenuPresenter(MenuPresenter presenter) {
        for (WeakReference<MenuPresenter> ref : mPresenters) {
            final MenuPresenter item = ref.get();
            if (item == null || item == presenter) {
                mPresenters.remove(ref);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.425 -0400", hash_original_method = "6A7FCB8EFBC104ADF7A61F09BDCD059E", hash_generated_method = "9DB3EF39748FC052591F266FE1481917")
            
private void dispatchPresenterUpdate(boolean cleared) {
        if (mPresenters.isEmpty()) {
            return;
        }

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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.428 -0400", hash_original_method = "AB9F088E4C3FEAC9D6545EEA3E98EB57", hash_generated_method = "57B3756DF998F99861AD5F0C9982D6B5")
            
private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        if (mPresenters.isEmpty()) {
            return false;
        }

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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.431 -0400", hash_original_method = "A7CBFC9845872F088F72C97F4CCA99E2", hash_generated_method = "A417C81AFE5244B66EE3D97BCD4D7802")
            
private void dispatchSaveInstanceState(Bundle outState) {
        if (mPresenters.isEmpty()) {
            return;
        }

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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.436 -0400", hash_original_method = "CD0434B477CDBD34F2CD0AEF2E36C145", hash_generated_method = "E7E4266F35F04BC6CF7E40731961CD90")
            
private void dispatchRestoreInstanceState(Bundle state) {
        SparseArray<Parcelable> presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);

        if (presenterStates == null || mPresenters.isEmpty()) {
            return;
        }

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.439 -0400", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "10914D084BED81458B281AE0F0579247")
            
public void savePresenterStates(Bundle outState) {
        dispatchSaveInstanceState(outState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.443 -0400", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "C716D2B5336C95886B8DFE9CEDDBF31D")
            
public void restorePresenterStates(Bundle state) {
        dispatchRestoreInstanceState(state);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.450 -0400", hash_original_method = "B8EAF6975CAFEC8EC0502C4A4FA53EE9", hash_generated_method = "E87699C02E61EB4914608C1FB9803B9D")
            
public void saveActionViewStates(Bundle outStates) {
        SparseArray<Parcelable> viewStates = null;

        final int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            final MenuItem item = getItem(i);
            final View v = MenuItemCompat.getActionView(item);
            if (v != null && v.getId() != View.NO_ID) {
                if (viewStates == null) {
                    viewStates = new SparseArray<Parcelable>();
                }
                v.saveHierarchyState(viewStates);
                if (MenuItemCompat.isActionViewExpanded(item)) {
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.454 -0400", hash_original_method = "3F82381BF42B21857297FAF86ECB2FA9", hash_generated_method = "5FE8D969E586CF0F512A2CDFC6908042")
            
public void restoreActionViewStates(Bundle states) {
        if (states == null) {
            return;
        }

        SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(
                getActionViewStatesKey());

        final int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            final MenuItem item = getItem(i);
            final View v = MenuItemCompat.getActionView(item);
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
                MenuItemCompat.expandActionView(itemToExpand);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.457 -0400", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "C43FBFF198D09072C15469EDE5FE6A8E")
            
protected String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.459 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "EAFBC13B735460C43524285DBFE0E8D5")
            
public void setCallback(Callback cb) {
        mCallback = cb;
    }

    /**
     * Adds an item to the menu.  The other add methods funnel to this.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.465 -0400", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "740C6E67CE35529F8AA48D4F89695092")
            
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.469 -0400", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "2CD33531FE9166CFC7B1D453AE7DE139")
            
@Override
    public MenuItem add(CharSequence title) {
        return addInternal(0, 0, 0, title);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.474 -0400", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "7F9DA03F08B99271C68E1E1707ABF857")
            
@Override
    public MenuItem add(int titleRes) {
        return addInternal(0, 0, 0, mResources.getString(titleRes));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.481 -0400", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "D1DBAC7101AAFD7EED08772449D712B8")
            
@Override
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        return addInternal(group, id, categoryOrder, title);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.486 -0400", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "FB0EDD1F3B22EC875BD3850085E4CBE6")
            
@Override
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        return addInternal(group, id, categoryOrder, mResources.getString(title));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.490 -0400", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "280DB06ABD8A4D7B6E908AD67ADCAF92")
            
@Override
    public SubMenu addSubMenu(CharSequence title) {
        return addSubMenu(0, 0, 0, title);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.494 -0400", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "52128ECD3571BA01802AFBE75016C8F3")
            
@Override
    public SubMenu addSubMenu(int titleRes) {
        return addSubMenu(0, 0, 0, mResources.getString(titleRes));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.498 -0400", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "A69CF915DF2720EF4B0D2F466A74FD68")
            
@Override
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);

        return subMenu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.502 -0400", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "8B25D3B973C59FAF04E81C2A1ED2344B")
            
@Override
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        return addSubMenu(group, id, categoryOrder, mResources.getString(title));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.511 -0400", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "E0D25CF14AC6065CF6BA1911C2384FAB")
            
@Override
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri =
                pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        final int N = lri != null ? lri.size() : 0;

        if ((flags & FLAG_APPEND_TO_GROUP) == 0) {
            removeGroup(group);
        }

        for (int i = 0; i < N; i++) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.516 -0400", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "FA62200EDDBD589D0253C371DFEA12C2")
            
@Override
    public void removeItem(int id) {
        removeItemAtInt(findItemIndex(id), true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.522 -0400", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "8A696858E83B675F40DC92C126A4AF97")
            
@Override
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
     * Remove the item at the given index and optionally forces menu views to update.
     *
     * @param index                     The index of the item to be removed. If this index is
     *                                  invalid an exception is thrown.
     * @param updateChildrenOnMenuViews Whether to force update on menu views. Please make sure you
     *                                  eventually call this after your batch of removals.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.529 -0400", hash_original_method = "41B895CE80639E34E3CE4B7FFDFD8F80", hash_generated_method = "83CDFE5BA69CCCF76ABDC2E3DF4267AC")
            
private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        if ((index < 0) || (index >= mItems.size())) {
            return;
        }

        mItems.remove(index);

        if (updateChildrenOnMenuViews) {
            onItemsChanged(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.533 -0400", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "AD00C6B6791898002D4D4D5B573A42A6")
            
public void removeItemAt(int index) {
        removeItemAtInt(index, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.536 -0400", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "900546F8F30E94ACE2073AEB7E354AF2")
            
public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.539 -0400", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "66E503536029364747F38A86AB050A67")
            
@Override
    public void clear() {
        if (mExpandedItem != null) {
            collapseItemActionView(mExpandedItem);
        }
        mItems.clear();

        onItemsChanged(true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.542 -0400", hash_original_method = "FE8766668277A9DD2E4AB8B1825EE046", hash_generated_method = "06B57CAB8FECB9F97CF30256C4BA989C")
            
void setExclusiveItemChecked(MenuItem item) {
        final int group = item.getGroupId();

        final int N = mItems.size();
        for (int i = 0; i < N; i++) {
            MenuItemImpl curItem = mItems.get(i);
            if (curItem.getGroupId() == group) {
                if (!curItem.isExclusiveCheckable()) {
                    continue;
                }
                if (!curItem.isCheckable()) {
                    continue;
                }

                // Check the item meant to be checked, uncheck the others (that are in the group)
                curItem.setCheckedInt(curItem == item);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.545 -0400", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "56E4D88BC26CBFFF6B4B83289FE5AEDE")
            
@Override
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.549 -0400", hash_original_method = "3E3BCCE290F94F3AEFDFFCDEDA285819", hash_generated_method = "A894552F788821FE18C0FE01F3E1D0F4")
            
@Override
    public void setGroupVisible(int group, boolean visible) {
        final int N = mItems.size();

        // We handle the notification of items being changed ourselves, so we use setVisibleInt
        // rather than setVisible and at the end notify of items being changed

        boolean changedAtLeastOneItem = false;
        for (int i = 0; i < N; i++) {
            MenuItemImpl item = mItems.get(i);
            if (item.getGroupId() == group) {
                if (item.setVisibleInt(visible)) {
                    changedAtLeastOneItem = true;
                }
            }
        }

        if (changedAtLeastOneItem) {
            onItemsChanged(true);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.553 -0400", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "006D3FDEB16C135F4CECAF301B6D0BBC")
            
@Override
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.556 -0400", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "BE26A978CDF68413B2AFFA75A7FB3E05")
            
@Override
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.559 -0400", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "8F9EDA6322076EEAD6D857E27C5FAE0F")
            
@Override
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.561 -0400", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "00D3433F0B6E8F7FA43DD813BE5215D9")
            
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.564 -0400", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "09BA772E4661ADD350F6B6F99AB6D8CB")
            
public int findGroupIndex(int group) {
        return findGroupIndex(group, 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.567 -0400", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "637EC233308C7B244D24DD157A068E09")
            
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.571 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "9742E041DB544DD623A201A0E8AD292C")
            
@Override
    public int size() {
        return mItems.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.574 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "9E1C907418E23C59B330F27938E038AF")
            
@Override
    public MenuItem getItem(int index) {
        return mItems.get(index);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.577 -0400", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "1BBDECD9136000C2D19D7C671BE50986")
            
@Override
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return findItemWithShortcutForKey(keyCode, event) != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.579 -0400", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "B4A27D4BC2D7569B003019A7D30EB1D1")
            
@Override
    public void setQwertyMode(boolean isQwerty) {
        mQwertyMode = isQwerty;

        onItemsChanged(false);
    }

    /**
     * @return whether the menu shortcuts are in qwerty mode or not
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.586 -0400", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "D1F1AC187BB0F0066C68CB94F0A9F578")
            
boolean isQwertyMode() {
        return mQwertyMode;
    }

    /**
     * Sets whether the shortcuts should be visible on menus.  Devices without hardware key input
     * will never make shortcuts visible even if this method is passed 'true'.
     *
     * @param shortcutsVisible Whether shortcuts should be visible (if true and a menu item does not
     *                         have a shortcut defined, that item will still NOT show a shortcut)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.588 -0400", hash_original_method = "C768D847DAB5A948632F683BF3DED61F", hash_generated_method = "37A4F42DACBE25756354D10F26043166")
            
public void setShortcutsVisible(boolean shortcutsVisible) {
        if (mShortcutsVisible == shortcutsVisible) {
            return;
        }

        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.591 -0400", hash_original_method = "2F74CC7330395BE592FBC0E8CE7E0755", hash_generated_method = "022C7AE607668FED4F38DE38E13B5899")
            
private void setShortcutsVisibleInner(boolean shortcutsVisible) {
        mShortcutsVisible = shortcutsVisible
                && mResources.getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS
                && mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent);
    }

    /**
     * @return Whether shortcuts should be visible on menus.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.594 -0400", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "9A195667D33C28DCD8CF543587A8CABA")
            
public boolean isShortcutsVisible() {
        return mShortcutsVisible;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.596 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "9FEC9CB1792EB215E49CBF732B0DBF5B")
            
Resources getResources() {
        return mResources;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.599 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
            
public Context getContext() {
        return mContext;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.602 -0400", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E")
            
boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return mCallback != null && mCallback.onMenuItemSelected(menu, item);
    }

    /**
     * Dispatch a mode change event to this menu's callback.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.605 -0400", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "04332EC9E81435A1752168590F49EE52")
            
public void changeMenuMode() {
        if (mCallback != null) {
            mCallback.onMenuModeChange(this);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.611 -0400", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "A091F920F88808F91549D0D92BCC5BEA")
            
@Override
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.617 -0400", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "0975003E4716B59F14690DD1EA291A43")
            
@SuppressWarnings("deprecation")
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
                ((MenuBuilder) item.getSubMenu())
                        .findItemsWithShortcutForKey(items, keyCode, event);
            }
            final char shortcutChar = qwerty ? item.getAlphabeticShortcut()
                    : item.getNumericShortcut();
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.622 -0400", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "E7C00DF1D6E3F24C836C48104B1A020E")
            
@SuppressWarnings("deprecation")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.625 -0400", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "9AE122A8245AD0D8982DD1C1B60A5CE2")
            
@Override
    public boolean performIdentifierAction(int id, int flags) {
        // Look for an item whose identifier is the id.
        return performItemAction(findItem(id), flags);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.629 -0400", hash_original_method = "51A4715497FAA54F774AA9824996A424", hash_generated_method = "E0983AA5436C821A3CEEAB79D86541AF")
            
public boolean performItemAction(MenuItem item, int flags) {
        MenuItemImpl itemImpl = (MenuItemImpl) item;

        if (itemImpl == null || !itemImpl.isEnabled()) {
            return false;
        }

        boolean invoked = itemImpl.invoke();

        final ActionProvider provider = itemImpl.getSupportActionProvider();
        final boolean providerHasSubMenu = provider != null && provider.hasSubMenu();
        if (itemImpl.hasCollapsibleActionView()) {
            invoked |= itemImpl.expandActionView();
            if (invoked) {
                close(true);
            }
        } else if (itemImpl.hasSubMenu() || providerHasSubMenu) {
            close(false);

            if (!itemImpl.hasSubMenu()) {
                itemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, itemImpl));
            }

            final SubMenuBuilder subMenu = (SubMenuBuilder) itemImpl.getSubMenu();
            if (providerHasSubMenu) {
                provider.onPrepareSubMenu(subMenu);
            }
            invoked |= dispatchSubMenuSelected(subMenu);
            if (!invoked) {
                close(true);
            }
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
     * @param allMenusAreClosing Whether the menus are completely closing (true), or whether there
     *                           is another menu coming in this menu's place (false). For example,
     *                           if the menu is closing because a sub menu is about to be shown,
     *                           <var>allMenusAreClosing</var> is false.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.632 -0400", hash_original_method = "085C1FEA0D2D2296DC9281AFE30BBC31", hash_generated_method = "AB6FDCDE3EBEC9E15145B2F69C83632C")
            
final void close(boolean allMenusAreClosing) {
        if (mIsClosing) {
            return;
        }

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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.635 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "6EB69B13BFBC308B983BCCCD1DE39952")
            
@Override
    public void close() {
        close(true);
    }

    /**
     * Called when an item is added or removed.
     *
     * @param structureChanged true if the menu structure changed, false if only item properties
     *                         changed. (Visibility is a structural property since it affects
     *                         layout.)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.638 -0400", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "5A795AB2D4E1ABD04FD81F99B25E4230")
            
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
     * Stop dispatching item changed events to presenters until {@link
     * #startDispatchingItemsChanged()} is called. Useful when many menu operations are going to be
     * performed as a batch.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.641 -0400", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "54B49F152368499C228B25909249F559")
            
public void stopDispatchingItemsChanged() {
        if (!mPreventDispatchingItemsChanged) {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.644 -0400", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "EC57A12CA4341BF10C223A5029126181")
            
public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;

        if (mItemsChangedWhileDispatchPrevented) {
            mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        }
    }

    /**
     * Called by {@link MenuItemImpl} when its visible flag is changed.
     *
     * @param item The item that has gone through a visibility change.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.646 -0400", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "FC8365D69C1929C714BDAF678F9DEAAB")
            
void onItemVisibleChanged(MenuItemImpl item) {
        // Notify of items being changed
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    /**
     * Called by {@link MenuItemImpl} when its action request status is changed.
     *
     * @param item The item that has gone through a change in action request status.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.649 -0400", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "5BE5B811E0A15BA5DFF4B297A55C9C11")
            
void onItemActionRequestChanged(MenuItemImpl item) {
        // Notify of items being changed
        mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.651 -0400", hash_original_method = "93A8FB20DB91F2E754D6D769CB84270C", hash_generated_method = "BFBB907312DBA6DE3CCF2C0B2E30574D")
            
ArrayList<MenuItemImpl> getVisibleItems() {
        if (!mIsVisibleItemsStale) {
            return mVisibleItems;
        }

        // Refresh the visible items
        mVisibleItems.clear();

        final int itemsSize = mItems.size();
        MenuItemImpl item;
        for (int i = 0; i < itemsSize; i++) {
            item = mItems.get(i);
            if (item.isVisible()) {
                mVisibleItems.add(item);
            }
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.656 -0400", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "819D674D4BF35BB2826B689834C10848")
            
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.658 -0400", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D")
            
ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return mActionItems;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.661 -0400", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "B350BF5A73D0E23634B50CFF93D74F82")
            
ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return mNonActionItems;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.664 -0400", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "1E8846ADB7D3682B77181A0DD3F79587")
            
public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;

        onItemsChanged(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.668 -0400", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "B6D889A1AEA91E81BADED2B7F96A4B64")
            
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
     * Sets the header's title. This replaces the header view. Called by the builder-style methods
     * of subclasses.
     *
     * @param title The new title.
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.671 -0400", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "93E73DB410B322A2E8CB22BFA0534195")
            
protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        setHeaderInternal(0, title, 0, null, null);
        return this;
    }

    /**
     * Sets the header's title. This replaces the header view. Called by the builder-style methods
     * of subclasses.
     *
     * @param titleRes The new title (as a resource ID).
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.673 -0400", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "1D147CC8A2A32A42BF2325E3C8A6710C")
            
protected MenuBuilder setHeaderTitleInt(int titleRes) {
        setHeaderInternal(titleRes, null, 0, null, null);
        return this;
    }

    /**
     * Sets the header's icon. This replaces the header view. Called by the builder-style methods of
     * subclasses.
     *
     * @param icon The new icon.
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.676 -0400", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "D590294212DB66D75A31666770D0F68B")
            
protected MenuBuilder setHeaderIconInt(Drawable icon) {
        setHeaderInternal(0, null, 0, icon, null);
        return this;
    }

    /**
     * Sets the header's icon. This replaces the header view. Called by the builder-style methods of
     * subclasses.
     *
     * @param iconRes The new icon (as a resource ID).
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.680 -0400", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "C85E93E0AB88405DDF9B79047F9F0BDF")
            
protected MenuBuilder setHeaderIconInt(int iconRes) {
        setHeaderInternal(0, null, iconRes, null, null);
        return this;
    }

    /**
     * Sets the header's view. This replaces the title and icon. Called by the builder-style methods
     * of subclasses.
     *
     * @param view The new view.
     * @return This MenuBuilder so additional setters can be called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.683 -0400", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "069FA8DC507DEE97E9170C7B4812D0F5")
            
protected MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.685 -0400", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "4971B8046CA65437C4A89E8856DA0C5F")
            
public CharSequence getHeaderTitle() {
        return mHeaderTitle;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.688 -0400", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "1695283F922A56D19F4CDB805DB5B953")
            
public Drawable getHeaderIcon() {
        return mHeaderIcon;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.691 -0400", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "E4FB4C66A0CBA192257FE6D3538CD4CE")
            
public View getHeaderView() {
        return mHeaderView;
    }

    /**
     * Gets the root menu (if this is a submenu, find its root menu).
     *
     * @return The root menu.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.693 -0400", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "61A49898FE7D323B9B36916018F4AD53")
            
public MenuBuilder getRootMenu() {
        return this;
    }

    /**
     * Sets the current menu info that is set on all items added to this menu (until this is called
     * again with different menu info, in which case that one will be added to all subsequent item
     * additions).
     *
     * @param menuInfo The extra menu information to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.696 -0400", hash_original_method = "1A3794875FE90D21944B817521BE4F83", hash_generated_method = "B061E441B7BD73B4B19B0ACBE2A25AD4")
            
public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo menuInfo) {
        mCurrentMenuInfo = menuInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.698 -0400", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "5006D7919DE7388D9F9EDDAFF142B475")
            
void setOptionalIconsVisible(boolean visible) {
        mOptionalIconsVisible = visible;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.701 -0400", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "E16B8D475B8F5B112A4C02A29314D988")
            
boolean getOptionalIconsVisible() {
        return mOptionalIconsVisible;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.705 -0400", hash_original_method = "441FE8C2718F3E9158B694B9F6106AB1", hash_generated_method = "96BA6EE3FB0C2DB16D7AE1A6BEDCC02F")
            
public boolean expandItemActionView(MenuItemImpl item) {
        if (mPresenters.isEmpty()) {
            return false;
        }

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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.708 -0400", hash_original_method = "2CA52514903041F342C41FB211AC3671", hash_generated_method = "5F78DA1068B96615F91441002EAAAEE3")
            
public boolean collapseItemActionView(MenuItemImpl item) {
        if (mPresenters.isEmpty() || mExpandedItem != item) {
            return false;
        }

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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:38.710 -0400", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "A6B23AF14DD01F8979C2D36F12D52037")
            
public MenuItemImpl getExpandedItem() {
        return mExpandedItem;
    }
}

