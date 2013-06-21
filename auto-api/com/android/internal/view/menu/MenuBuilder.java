package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements Menu {
    private Context mContext;
    private Resources mResources;
    private boolean mQwertyMode;
    private boolean mShortcutsVisible;
    private Callback mCallback;
    private ArrayList<MenuItemImpl> mItems;
    private ArrayList<MenuItemImpl> mVisibleItems;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mActionItems;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mIsActionItemsStale;
    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;
    private ContextMenuInfo mCurrentMenuInfo;
    CharSequence mHeaderTitle;
    Drawable mHeaderIcon;
    View mHeaderView;
    private SparseArray<Parcelable> mFrozenViewStates;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private boolean mOptionalIconsVisible = false;
    private boolean mIsClosing = false;
    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters =
            new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
    private MenuItemImpl mExpandedItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.579 -0400", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "04FC6C9E37CD8FC3CE1CBC73CD782713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuBuilder(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mResources = context.getResources();
        mItems = new ArrayList<MenuItemImpl>();
        mVisibleItems = new ArrayList<MenuItemImpl>();
        mIsVisibleItemsStale = true;
        mActionItems = new ArrayList<MenuItemImpl>();
        mNonActionItems = new ArrayList<MenuItemImpl>();
        mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
        // ---------- Original Method ----------
        //mContext = context;
        //mResources = context.getResources();
        //mItems = new ArrayList<MenuItemImpl>();
        //mVisibleItems = new ArrayList<MenuItemImpl>();
        //mIsVisibleItemsStale = true;
        //mActionItems = new ArrayList<MenuItemImpl>();
        //mNonActionItems = new ArrayList<MenuItemImpl>();
        //mIsActionItemsStale = true;
        //setShortcutsVisibleInner(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.579 -0400", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "97E318FAB0D3BB9D1E6F31F10BD4BE3E")
    @DSModeled(DSC.SAFE)
    public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        dsTaint.addTaint(defaultShowAsAction);
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mDefaultShowAsAction = defaultShowAsAction;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.580 -0400", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "B38B99E1E0B951E38F84A88773E51E0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addMenuPresenter(MenuPresenter presenter) {
        dsTaint.addTaint(presenter.dsTaint);
        mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        presenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
        // ---------- Original Method ----------
        //mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        //presenter.initForMenu(mContext, this);
        //mIsActionItemsStale = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.582 -0400", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "AB4D57F645B4A857B059B1CC30E54E21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMenuPresenter(MenuPresenter presenter) {
        dsTaint.addTaint(presenter.dsTaint);
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1464477948 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1464477948.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1464477948.next();
            {
                MenuPresenter item;
                item = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter item = ref.get();
            //if (item == null || item == presenter) {
                //mPresenters.remove(ref);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.585 -0400", hash_original_method = "54D4EF8A00AA3736A7301B3768CF2956", hash_generated_method = "25C941EDB55C5053CC36061EE2B68390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchPresenterUpdate(boolean cleared) {
        dsTaint.addTaint(cleared);
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_765954716 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1164134169 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1164134169.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1164134169.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    presenter.updateMenuView(cleared);
                } //End block
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        // ---------- Original Method ----------
        //if (mPresenters.isEmpty()) return;
        //stopDispatchingItemsChanged();
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else {
                //presenter.updateMenuView(cleared);
            //}
        //}
        //startDispatchingItemsChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.588 -0400", hash_original_method = "972C883CEABE6EAECC969B119D377700", hash_generated_method = "424F14D6B435125A5C2C917CED2A4CFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        dsTaint.addTaint(subMenu.dsTaint);
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_1352678760 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        boolean result;
        result = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_2046472055 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_2046472055.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_2046472055.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    result = presenter.onSubMenuSelected(subMenu);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mPresenters.isEmpty()) return false;
        //boolean result = false;
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else if (!result) {
                //result = presenter.onSubMenuSelected(subMenu);
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.591 -0400", hash_original_method = "8458F949934B8A3332FB7D785BD3E421", hash_generated_method = "16BC585970B3719A40F3B1AB5D9A2443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchSaveInstanceState(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_1724349780 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        SparseArray<Parcelable> presenterStates;
        presenterStates = new SparseArray<Parcelable>();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_980984952 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_980984952.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_980984952.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    int id;
                    id = presenter.getId();
                    {
                        Parcelable state;
                        state = presenter.onSaveInstanceState();
                        {
                            presenterStates.put(id, state);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        outState.putSparseParcelableArray(PRESENTER_KEY, presenterStates);
        // ---------- Original Method ----------
        //if (mPresenters.isEmpty()) return;
        //SparseArray<Parcelable> presenterStates = new SparseArray<Parcelable>();
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else {
                //final int id = presenter.getId();
                //if (id > 0) {
                    //final Parcelable state = presenter.onSaveInstanceState();
                    //if (state != null) {
                        //presenterStates.put(id, state);
                    //}
                //}
            //}
        //}
        //outState.putSparseParcelableArray(PRESENTER_KEY, presenterStates);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.594 -0400", hash_original_method = "4E7750A20EC8141646D41AE332CEFE6A", hash_generated_method = "689780DE61C7C9A1D3D4DDDCAA6A647E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchRestoreInstanceState(Bundle state) {
        dsTaint.addTaint(state.dsTaint);
        SparseArray<Parcelable> presenterStates;
        presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);
        {
            boolean var978B5CD1AF436AE76C6FB0F45B00B46D_1192442121 = (presenterStates == null || mPresenters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1204314749 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1204314749.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1204314749.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    int id;
                    id = presenter.getId();
                    {
                        Parcelable parcel;
                        parcel = presenterStates.get(id);
                        {
                            presenter.onRestoreInstanceState(parcel);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SparseArray<Parcelable> presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);
        //if (presenterStates == null || mPresenters.isEmpty()) return;
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else {
                //final int id = presenter.getId();
                //if (id > 0) {
                    //Parcelable parcel = presenterStates.get(id);
                    //if (parcel != null) {
                        //presenter.onRestoreInstanceState(parcel);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.595 -0400", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "4EE614D58FD18A0FD100C945E2DF6081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void savePresenterStates(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        dispatchSaveInstanceState(outState);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.595 -0400", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "C4FA6A5E6E43D987AB29EEF3CC8ECBCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restorePresenterStates(Bundle state) {
        dsTaint.addTaint(state.dsTaint);
        dispatchRestoreInstanceState(state);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.595 -0400", hash_original_method = "A8F0361C85125DA8A38A18412990521E", hash_generated_method = "EFF1D41D42910C9100261D6A204E2CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveActionViewStates(Bundle outStates) {
        dsTaint.addTaint(outStates.dsTaint);
        SparseArray<Parcelable> viewStates;
        viewStates = null;
        int itemCount;
        itemCount = size();
        {
            int i;
            i = 0;
            {
                MenuItem item;
                item = getItem(i);
                View v;
                v = item.getActionView();
                {
                    boolean var094D712B8F5F2BE1027DB368EC41F641_1148490997 = (v != null && v.getId() != View.NO_ID);
                    {
                        {
                            viewStates = new SparseArray<Parcelable>();
                        } //End block
                        v.saveHierarchyState(viewStates);
                        {
                            boolean varD2DC871025EA5DE67B1C85EF2817DBBE_1766923 = (item.isActionViewExpanded());
                            {
                                outStates.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_1366654264 = (item.hasSubMenu());
                    {
                        SubMenuBuilder subMenu;
                        subMenu = (SubMenuBuilder) item.getSubMenu();
                        subMenu.saveActionViewStates(outStates);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            outStates.putSparseParcelableArray(getActionViewStatesKey(), viewStates);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.596 -0400", hash_original_method = "B3A4CB3CCE0DD38C30DBEC80F125B14F", hash_generated_method = "43BD97F6AA2F882465DC7F435275470A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreActionViewStates(Bundle states) {
        dsTaint.addTaint(states.dsTaint);
        SparseArray<Parcelable> viewStates;
        viewStates = states.getSparseParcelableArray(
                getActionViewStatesKey());
        int itemCount;
        itemCount = size();
        {
            int i;
            i = 0;
            {
                MenuItem item;
                item = getItem(i);
                View v;
                v = item.getActionView();
                {
                    boolean var094D712B8F5F2BE1027DB368EC41F641_409097288 = (v != null && v.getId() != View.NO_ID);
                    {
                        v.restoreHierarchyState(viewStates);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_1512290856 = (item.hasSubMenu());
                    {
                        SubMenuBuilder subMenu;
                        subMenu = (SubMenuBuilder) item.getSubMenu();
                        subMenu.restoreActionViewStates(states);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int expandedId;
        expandedId = states.getInt(EXPANDED_ACTION_VIEW_ID);
        {
            MenuItem itemToExpand;
            itemToExpand = findItem(expandedId);
            {
                itemToExpand.expandActionView();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.596 -0400", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "06343A2DA5ABE9F7424199E092D03DA3")
    @DSModeled(DSC.SAFE)
    protected String getActionViewStatesKey() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ACTION_VIEW_STATES_KEY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.596 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "483F9A7853B90884DAE3779BB5D6B837")
    @DSModeled(DSC.SAFE)
    public void setCallback(Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.596 -0400", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "CBA5FF0E2A2DB83DD8ED5CD27446EFF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(group);
        int ordering;
        ordering = getOrdering(categoryOrder);
        MenuItemImpl item;
        item = new MenuItemImpl(this, group, id, categoryOrder,
                ordering, title, mDefaultShowAsAction);
        {
            item.setMenuInfo(mCurrentMenuInfo);
        } //End block
        mItems.add(findInsertIndex(mItems, ordering), item);
        onItemsChanged(true);
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int ordering = getOrdering(categoryOrder);
        //final MenuItemImpl item = new MenuItemImpl(this, group, id, categoryOrder,
                //ordering, title, mDefaultShowAsAction);
        //if (mCurrentMenuInfo != null) {
            //item.setMenuInfo(mCurrentMenuInfo);
        //}
        //mItems.add(findInsertIndex(mItems, ordering), item);
        //onItemsChanged(true);
        //return item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.596 -0400", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "92322FDE29C919B0AAF277839A1FCCA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem add(CharSequence title) {
        dsTaint.addTaint(title);
        MenuItem var7C557EB87D275F7D8A84179204316D03_607871531 = (addInternal(0, 0, 0, title));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addInternal(0, 0, 0, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.597 -0400", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "E9B3190108B38BBEC085B1D19D2C7543")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem add(int titleRes) {
        dsTaint.addTaint(titleRes);
        MenuItem var4F6485471DE0001D3856F04F9CAB3E16_775157926 = (addInternal(0, 0, 0, mResources.getString(titleRes)));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addInternal(0, 0, 0, mResources.getString(titleRes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.597 -0400", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "5F8B2A98DBFB7025C4A454342E761101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(group);
        MenuItem varBD43A230A2D75889A5F6D7057AF887F1_1642983377 = (addInternal(group, id, categoryOrder, title));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addInternal(group, id, categoryOrder, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.597 -0400", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "8CA72002DBD8C005DE4881C98A757011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(group);
        MenuItem varB8C9448E68B5A99A4335A4E11FD88214_12605562 = (addInternal(group, id, categoryOrder, mResources.getString(title)));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addInternal(group, id, categoryOrder, mResources.getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.597 -0400", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "6A229434083D8ED9EC8DC5B397F8A8A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu addSubMenu(CharSequence title) {
        dsTaint.addTaint(title);
        SubMenu var9F133C10E772CABCAC32E29D8C39D3BE_2080285816 = (addSubMenu(0, 0, 0, title));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addSubMenu(0, 0, 0, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.597 -0400", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "3A33068CFCD734B25840654A3919F8B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu addSubMenu(int titleRes) {
        dsTaint.addTaint(titleRes);
        SubMenu var10A3BDDA87A6958A653BD1719C90D70C_1288259254 = (addSubMenu(0, 0, 0, mResources.getString(titleRes)));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addSubMenu(0, 0, 0, mResources.getString(titleRes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.598 -0400", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "620501A361BC6D1D6D5E69246E1C897D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(group);
        MenuItemImpl item;
        item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        SubMenuBuilder subMenu;
        subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        //final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        //item.setSubMenu(subMenu);
        //return subMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.598 -0400", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "74FD49E355E23DCC9D0CD6443A5418A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(group);
        SubMenu var42AE2CAB309BEBF497D2204BD9B963A5_1223967860 = (addSubMenu(group, id, categoryOrder, mResources.getString(title)));
        return (SubMenu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addSubMenu(group, id, categoryOrder, mResources.getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.598 -0400", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "7DBE7AC5A48A04D74202264EC24FBACF")
    @DSModeled(DSC.SPEC)
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(categoryOrder);
        dsTaint.addTaint(outSpecificItems[0].dsTaint);
        dsTaint.addTaint(specifics[0].dsTaint);
        dsTaint.addTaint(group);
        dsTaint.addTaint(intent.dsTaint);
        PackageManager pm;
        pm = mContext.getPackageManager();
        List<ResolveInfo> lri;
        lri = pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        int N;
        N = lri.size();
        N = 0;
        {
            removeGroup(group);
        } //End block
        {
            int i;
            i = 0;
            {
                ResolveInfo ri;
                ri = lri.get(i);
                Intent rintent;
                rintent = new Intent(
                ri.specificIndex < 0 ? intent : specifics[ri.specificIndex]);//DSFIXME:  CODE0008: Nested ternary operator in expression
                rintent.setComponent(new ComponentName(
                    ri.activityInfo.applicationInfo.packageName,
                    ri.activityInfo.name));
                MenuItem item;
                item = add(group, id, categoryOrder, ri.loadLabel(pm))
                    .setIcon(ri.loadIcon(pm))
                    .setIntent(rintent);
                {
                    outSpecificItems[ri.specificIndex] = item;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.598 -0400", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "D73DBF2848CD231054BB7D70E1828569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeItem(int id) {
        dsTaint.addTaint(id);
        removeItemAtInt(findItemIndex(id), true);
        // ---------- Original Method ----------
        //removeItemAtInt(findItemIndex(id), true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.599 -0400", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "AFD54BBC58E9AF21DA5A19767A5C2915")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeGroup(int group) {
        dsTaint.addTaint(group);
        int i;
        i = findGroupIndex(group);
        {
            int maxRemovable;
            maxRemovable = mItems.size() - i;
            int numRemoved;
            numRemoved = 0;
            {
                boolean varB635114C3F531E77FD0C631F7E17EB16_1427808585 = ((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group));
                {
                    removeItemAtInt(i, false);
                } //End block
            } //End collapsed parenthetic
            onItemsChanged(true);
        } //End block
        // ---------- Original Method ----------
        //final int i = findGroupIndex(group);
        //if (i >= 0) {
            //final int maxRemovable = mItems.size() - i;
            //int numRemoved = 0;
            //while ((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group)) {
                //removeItemAtInt(i, false);
            //}
            //onItemsChanged(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.599 -0400", hash_original_method = "B04372368F85324A2D15939652770F19", hash_generated_method = "B05CD69B03156C001DCE899A8EC328DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(updateChildrenOnMenuViews);
        {
            boolean var338D9D416353CE7F8A425352D2B29717_323451990 = ((index < 0) || (index >= mItems.size()));
        } //End collapsed parenthetic
        mItems.remove(index);
        onItemsChanged(true);
        // ---------- Original Method ----------
        //if ((index < 0) || (index >= mItems.size())) return;
        //mItems.remove(index);
        //if (updateChildrenOnMenuViews) onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.600 -0400", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "F42A42070E2BBD7060CFE22D28DD67E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeItemAt(int index) {
        dsTaint.addTaint(index);
        removeItemAtInt(index, true);
        // ---------- Original Method ----------
        //removeItemAtInt(index, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.600 -0400", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "EE1F5DE30C303F3D28461F50B1CD8998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
        // ---------- Original Method ----------
        //mPreventDispatchingItemsChanged = true;
        //clear();
        //clearHeader();
        //mPreventDispatchingItemsChanged = false;
        //mItemsChangedWhileDispatchPrevented = false;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.600 -0400", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "FF7B938D8B551DFA519348BF50A383E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        {
            collapseItemActionView(mExpandedItem);
        } //End block
        mItems.clear();
        onItemsChanged(true);
        // ---------- Original Method ----------
        //if (mExpandedItem != null) {
            //collapseItemActionView(mExpandedItem);
        //}
        //mItems.clear();
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.601 -0400", hash_original_method = "46B444F22731C330EF8C5DDD6085B819", hash_generated_method = "42CDCD51CA25EC85A3AAF4BF86711EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setExclusiveItemChecked(MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        int group;
        group = item.getGroupId();
        int N;
        N = mItems.size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl curItem;
                curItem = mItems.get(i);
                {
                    boolean var8EE8AC9535910453B171626ECFBE2970_1555859952 = (curItem.getGroupId() == group);
                    {
                        {
                            boolean var7E3666046252DE45A97E32C83CBBDAF4_10714955 = (!curItem.isExclusiveCheckable());
                        } //End collapsed parenthetic
                        {
                            boolean var8CDB89E4B55B2B7E8661481E53525A9E_913146883 = (!curItem.isCheckable());
                        } //End collapsed parenthetic
                        curItem.setCheckedInt(curItem == item);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int group = item.getGroupId();
        //final int N = mItems.size();
        //for (int i = 0; i < N; i++) {
            //MenuItemImpl curItem = mItems.get(i);
            //if (curItem.getGroupId() == group) {
                //if (!curItem.isExclusiveCheckable()) continue;
                //if (!curItem.isCheckable()) continue;
                //curItem.setCheckedInt(curItem == item);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.601 -0400", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "FE6157924B2AFF0726B70561EB75702A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        dsTaint.addTaint(checkable);
        dsTaint.addTaint(exclusive);
        dsTaint.addTaint(group);
        int N;
        N = mItems.size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1551248565 = (item.getGroupId() == group);
                    {
                        item.setExclusiveCheckable(exclusive);
                        item.setCheckable(checkable);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int N = mItems.size();
        //for (int i = 0; i < N; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.getGroupId() == group) {
                //item.setExclusiveCheckable(exclusive);
                //item.setCheckable(checkable);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.601 -0400", hash_original_method = "4EDC76E82EDC17A472BC69BB1B6E7C6A", hash_generated_method = "F63CC11648A59E177B3BDA3CB548E216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGroupVisible(int group, boolean visible) {
        dsTaint.addTaint(visible);
        dsTaint.addTaint(group);
        int N;
        N = mItems.size();
        boolean changedAtLeastOneItem;
        changedAtLeastOneItem = false;
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1117264252 = (item.getGroupId() == group);
                    {
                        {
                            boolean var4DB4446F3346E01932ADAD4B5683F498_718816657 = (item.setVisibleInt(visible));
                            changedAtLeastOneItem = true;
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        onItemsChanged(true);
        // ---------- Original Method ----------
        //final int N = mItems.size();
        //boolean changedAtLeastOneItem = false;
        //for (int i = 0; i < N; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.getGroupId() == group) {
                //if (item.setVisibleInt(visible)) changedAtLeastOneItem = true;
            //}
        //}
        //if (changedAtLeastOneItem) onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.602 -0400", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "51DAA8DD6F5811EECCFE82D25DED9809")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGroupEnabled(int group, boolean enabled) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(group);
        int N;
        N = mItems.size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_889757911 = (item.getGroupId() == group);
                    {
                        item.setEnabled(enabled);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int N = mItems.size();
        //for (int i = 0; i < N; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.getGroupId() == group) {
                //item.setEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.602 -0400", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "2528F67659740A9D9F9C00BD57509B95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVisibleItems() {
        int size;
        size = size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_571480998 = (item.isVisible());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int size = size();
        //for (int i = 0; i < size; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.isVisible()) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.602 -0400", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "4CAF3F5D56CA326606624736D0C10D4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem findItem(int id) {
        dsTaint.addTaint(id);
        int size;
        size = size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_125476406 = (item.getItemId() == id);
                    {
                        boolean var2A76345EF62F0728C298DB442BA98AFC_1537152367 = (item.hasSubMenu());
                        {
                            MenuItem possibleItem;
                            possibleItem = item.getSubMenu().findItem(id);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int size = size();
        //for (int i = 0; i < size; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.getItemId() == id) {
                //return item;
            //} else if (item.hasSubMenu()) {
                //MenuItem possibleItem = item.getSubMenu().findItem(id);
                //if (possibleItem != null) {
                    //return possibleItem;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.602 -0400", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "8A0D9A64F2CEF2714DD49F37740A2267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findItemIndex(int id) {
        dsTaint.addTaint(id);
        int size;
        size = size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_312306321 = (item.getItemId() == id);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int size = size();
        //for (int i = 0; i < size; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.getItemId() == id) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.603 -0400", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "99A198FD96AC573CD1FA2AD16382A8EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findGroupIndex(int group) {
        dsTaint.addTaint(group);
        int varF2F0AE9233F1B982D371F99153BF98DC_1323370487 = (findGroupIndex(group, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return findGroupIndex(group, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.603 -0400", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "ECA620A925AC2BD8FD3922E1DE6BDD77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findGroupIndex(int group, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(group);
        int size;
        size = size();
        {
            start = 0;
        } //End block
        {
            int i;
            i = start;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_92469457 = (item.getGroupId() == group);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int size = size();
        //if (start < 0) {
            //start = 0;
        //}
        //for (int i = start; i < size; i++) {
            //final MenuItemImpl item = mItems.get(i);
            //if (item.getGroupId() == group) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.603 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "C1B929226C49651E695FAF22619FC587")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var903E593E570CF8A7196E435EA30221CF_1730903620 = (mItems.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mItems.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.603 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "9205F608514E197A47F4F8990AF0BB9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuItem getItem(int index) {
        dsTaint.addTaint(index);
        MenuItem var50B6C60F66EE15A22205325C098ECD35_1029828858 = (mItems.get(index));
        return (MenuItem)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItems.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.603 -0400", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "64E26AA6107C6A95CB8967D0702C4DC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean var83E816433D6C5D634DA5F2A1F1927716_1225702700 = (findItemWithShortcutForKey(keyCode, event) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return findItemWithShortcutForKey(keyCode, event) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.604 -0400", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "7039B9DDC7F481456B72C71AC92E9D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQwertyMode(boolean isQwerty) {
        dsTaint.addTaint(isQwerty);
        onItemsChanged(false);
        // ---------- Original Method ----------
        //mQwertyMode = isQwerty;
        //onItemsChanged(false);
    }

    
        private static int getOrdering(int categoryOrder) {
        final int index = (categoryOrder & CATEGORY_MASK) >> CATEGORY_SHIFT;
        if (index < 0 || index >= sCategoryToOrder.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (sCategoryToOrder[index] << CATEGORY_SHIFT) | (categoryOrder & USER_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.604 -0400", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "33EFF1D766B7D0D3A18185D6A9C5BDB8")
    @DSModeled(DSC.SAFE)
     boolean isQwertyMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQwertyMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.604 -0400", hash_original_method = "5CCA4A69E642C22AB6858AA5EF093CEB", hash_generated_method = "7773D9B00321C00CA7AF7E7C3FB6A798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShortcutsVisible(boolean shortcutsVisible) {
        dsTaint.addTaint(shortcutsVisible);
        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
        // ---------- Original Method ----------
        //if (mShortcutsVisible == shortcutsVisible) return;
        //setShortcutsVisibleInner(shortcutsVisible);
        //onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.604 -0400", hash_original_method = "BCC95ACBA680BEE1F3E7AD661CBC9615", hash_generated_method = "31D8BDD92FB08703E2E82ED0964FD4A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setShortcutsVisibleInner(boolean shortcutsVisible) {
        dsTaint.addTaint(shortcutsVisible);
        mShortcutsVisible = shortcutsVisible
                && mResources.getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS
                && mResources.getBoolean(
                        com.android.internal.R.bool.config_showMenuShortcutsWhenKeyboardPresent);
        // ---------- Original Method ----------
        //mShortcutsVisible = shortcutsVisible
                //&& mResources.getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS
                //&& mResources.getBoolean(
                        //com.android.internal.R.bool.config_showMenuShortcutsWhenKeyboardPresent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.605 -0400", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "9787898344F9CF01D5769B3086F6D15B")
    @DSModeled(DSC.SAFE)
    public boolean isShortcutsVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShortcutsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.605 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "76828C3BBA04CC0041C898A570938724")
    @DSModeled(DSC.SAFE)
     Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.605 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.605 -0400", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "5435CB7BA8E6A43F8FA9F35E4C767C69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        boolean var4651BA2AB2CDEB5FBB4C6B09193CF147_961183688 = (mCallback != null && mCallback.onMenuItemSelected(menu, item));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCallback != null && mCallback.onMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.605 -0400", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "FDB098940DBBCEA38E17715D59A20179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeMenuMode() {
        {
            mCallback.onMenuModeChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //mCallback.onMenuModeChange(this);
        //}
    }

    
        private static int findInsertIndex(ArrayList<MenuItemImpl> items, int ordering) {
        for (int i = items.size() - 1; i >= 0; i--) {
            MenuItemImpl item = items.get(i);
            if (item.getOrdering() <= ordering) {
                return i + 1;
            }
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.606 -0400", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "B35322E14D6FD4E2CB8CF81F293FB99C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(event.dsTaint);
        MenuItemImpl item;
        item = findItemWithShortcutForKey(keyCode, event);
        boolean handled;
        handled = false;
        {
            handled = performItemAction(item, flags);
        } //End block
        {
            close(true);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final MenuItemImpl item = findItemWithShortcutForKey(keyCode, event);
        //boolean handled = false;
        //if (item != null) {
            //handled = performItemAction(item, flags);
        //}
        //if ((flags & FLAG_ALWAYS_PERFORM_CLOSE) != 0) {
            //close(true);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.606 -0400", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "A8E3A666A2CDF8ED61D3962F94394390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void findItemsWithShortcutForKey(List<MenuItemImpl> items, int keyCode, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(items.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        boolean qwerty;
        qwerty = isQwertyMode();
        int metaState;
        metaState = event.getMetaState();
        KeyCharacterMap.KeyData possibleChars;
        possibleChars = new KeyCharacterMap.KeyData();
        boolean isKeyCodeMapped;
        isKeyCodeMapped = event.getKeyData(possibleChars);
        int N;
        N = mItems.size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_690748245 = (item.hasSubMenu());
                    {
                        ((MenuBuilder)item.getSubMenu()).findItemsWithShortcutForKey(items, keyCode, event);
                    } //End block
                } //End collapsed parenthetic
                char shortcutChar;
                shortcutChar = item.getAlphabeticShortcut();
                shortcutChar = item.getNumericShortcut();
                {
                    boolean var4B1C4B88C00B83DF48844FF91D97425B_1814219103 = (((metaState & (KeyEvent.META_SHIFT_ON | KeyEvent.META_SYM_ON)) == 0) &&
                  (shortcutChar != 0) &&
                  (shortcutChar == possibleChars.meta[0]
                      || shortcutChar == possibleChars.meta[2]
                      || (qwerty && shortcutChar == '\b' &&
                          keyCode == KeyEvent.KEYCODE_DEL)) &&
                  item.isEnabled());
                    {
                        items.add(item);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.606 -0400", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "8AFC88C3400E24DAD1373814B44B1042")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MenuItemImpl findItemWithShortcutForKey(int keyCode, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        ArrayList<MenuItemImpl> items;
        items = mTempShortcutItemList;
        items.clear();
        findItemsWithShortcutForKey(items, keyCode, event);
        {
            boolean varDC7DD6E6607E60D056C701649F2FCC72_1781245713 = (items.isEmpty());
        } //End collapsed parenthetic
        int metaState;
        metaState = event.getMetaState();
        KeyCharacterMap.KeyData possibleChars;
        possibleChars = new KeyCharacterMap.KeyData();
        event.getKeyData(possibleChars);
        int size;
        size = items.size();
        {
            MenuItemImpl var77C01F49A7B879FA199E2441F37A3934_1995949360 = (items.get(0));
        } //End block
        boolean qwerty;
        qwerty = isQwertyMode();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = items.get(i);
                char shortcutChar;
                shortcutChar = item.getAlphabeticShortcut();
                shortcutChar = item.getNumericShortcut();
            } //End block
        } //End collapsed parenthetic
        return (MenuItemImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.607 -0400", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "6A472B0ABCEE294C57B3BF960D593D7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performIdentifierAction(int id, int flags) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        boolean varC0CA7E336E0E2B8E0733C1AA972420EC_1449936937 = (performItemAction(findItem(id), flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return performItemAction(findItem(id), flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.607 -0400", hash_original_method = "35FE8CE6C993B07CD0CB9DB44F8CBE25", hash_generated_method = "F3C869F96196769DA730E1D3BEAC29FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performItemAction(MenuItem item, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(item.dsTaint);
        MenuItemImpl itemImpl;
        itemImpl = (MenuItemImpl) item;
        {
            boolean var4046EFD8ABBFFA045BEA239ADDC2688E_2102795911 = (itemImpl == null || !itemImpl.isEnabled());
        } //End collapsed parenthetic
        boolean invoked;
        invoked = itemImpl.invoke();
        {
            boolean varB2A71AC4CF06459A52AAFC8C1B2AA2A9_589505308 = (itemImpl.hasCollapsibleActionView());
            {
                invoked |= itemImpl.expandActionView();
                close(true);
            } //End block
            {
                boolean var5D978436017CCBE177EE4E51CAD278B4_1181491698 = (item.hasSubMenu());
                {
                    close(false);
                    SubMenuBuilder subMenu;
                    subMenu = (SubMenuBuilder) item.getSubMenu();
                    ActionProvider provider;
                    provider = item.getActionProvider();
                    {
                        boolean var2102918082958942CF9C792E151F0C24_267899184 = (provider != null && provider.hasSubMenu());
                        {
                            provider.onPrepareSubMenu(subMenu);
                        } //End block
                    } //End collapsed parenthetic
                    invoked |= dispatchSubMenuSelected(subMenu);
                    close(true);
                } //End block
                {
                    {
                        close(true);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.612 -0400", hash_original_method = "95071F981B5536F482A785105041F83F", hash_generated_method = "312704A54505AAFAC15563700E2E044B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void close(boolean allMenusAreClosing) {
        dsTaint.addTaint(allMenusAreClosing);
        mIsClosing = true;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1329607044 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1329607044.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1329607044.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    presenter.onCloseMenu(this, allMenusAreClosing);
                } //End block
            } //End block
        } //End collapsed parenthetic
        mIsClosing = false;
        // ---------- Original Method ----------
        //if (mIsClosing) return;
        //mIsClosing = true;
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else {
                //presenter.onCloseMenu(this, allMenusAreClosing);
            //}
        //}
        //mIsClosing = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.613 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        close(true);
        // ---------- Original Method ----------
        //close(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.613 -0400", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "89FC4A638633A19437E06A61E70F70DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onItemsChanged(boolean structureChanged) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(structureChanged);
        {
            {
                mIsVisibleItemsStale = true;
                mIsActionItemsStale = true;
            } //End block
            dispatchPresenterUpdate(structureChanged);
        } //End block
        {
            mItemsChangedWhileDispatchPrevented = true;
        } //End block
        // ---------- Original Method ----------
        //if (!mPreventDispatchingItemsChanged) {
            //if (structureChanged) {
                //mIsVisibleItemsStale = true;
                //mIsActionItemsStale = true;
            //}
            //dispatchPresenterUpdate(structureChanged);
        //} else {
            //mItemsChangedWhileDispatchPrevented = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.613 -0400", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "9C920614B8D86D336BB2A3CBA43EF20D")
    @DSModeled(DSC.SAFE)
    public void stopDispatchingItemsChanged() {
        {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        } //End block
        // ---------- Original Method ----------
        //if (!mPreventDispatchingItemsChanged) {
            //mPreventDispatchingItemsChanged = true;
            //mItemsChangedWhileDispatchPrevented = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.613 -0400", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "7BDF5DE5A18E4A87DFF9992D7EFE1939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;
        {
            mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        } //End block
        // ---------- Original Method ----------
        //mPreventDispatchingItemsChanged = false;
        //if (mItemsChangedWhileDispatchPrevented) {
            //mItemsChangedWhileDispatchPrevented = false;
            //onItemsChanged(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.614 -0400", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "A901F9FA9AF89687B6ED3E3C4EF54297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onItemVisibleChanged(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
        // ---------- Original Method ----------
        //mIsVisibleItemsStale = true;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.614 -0400", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "8E89DCFB2172BF15C5D80F6BF2311D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onItemActionRequestChanged(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        mIsActionItemsStale = true;
        onItemsChanged(true);
        // ---------- Original Method ----------
        //mIsActionItemsStale = true;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.614 -0400", hash_original_method = "66450A6B071A6D6254ADE6AFA4286392", hash_generated_method = "82B97DCEF256C02ADD65AAE297CCE269")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<MenuItemImpl> getVisibleItems() {
        mVisibleItems.clear();
        int itemsSize;
        itemsSize = mItems.size();
        MenuItemImpl item;
        {
            int i;
            i = 0;
            {
                item = mItems.get(i);
                {
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_973665745 = (item.isVisible());
                    mVisibleItems.add(item);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
        return (ArrayList<MenuItemImpl>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mIsVisibleItemsStale) return mVisibleItems;
        //mVisibleItems.clear();
        //final int itemsSize = mItems.size();
        //MenuItemImpl item;
        //for (int i = 0; i < itemsSize; i++) {
            //item = mItems.get(i);
            //if (item.isVisible()) mVisibleItems.add(item);
        //}
        //mIsVisibleItemsStale = false;
        //mIsActionItemsStale = true;
        //return mVisibleItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.623 -0400", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "1DC985DE64601655D29213ABDC3481C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flagActionItems() {
        boolean flagged;
        flagged = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_232329134 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_232329134.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_232329134.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    flagged |= presenter.flagActionItems();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mActionItems.clear();
            mNonActionItems.clear();
            ArrayList<MenuItemImpl> visibleItems;
            visibleItems = getVisibleItems();
            int itemsSize;
            itemsSize = visibleItems.size();
            {
                int i;
                i = 0;
                {
                    MenuItemImpl item;
                    item = visibleItems.get(i);
                    {
                        boolean var8C7900E5A6181E1C7522686688712CC9_738954937 = (item.isActionButton());
                        {
                            mActionItems.add(item);
                        } //End block
                        {
                            mNonActionItems.add(item);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mActionItems.clear();
            mNonActionItems.clear();
            mNonActionItems.addAll(getVisibleItems());
        } //End block
        mIsActionItemsStale = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.624 -0400", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "02D8D59B12921EDF31EF642CB093F77C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return (ArrayList<MenuItemImpl>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //flagActionItems();
        //return mActionItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.624 -0400", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "F30090FA876978F4D16D68909ED9727E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return (ArrayList<MenuItemImpl>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //flagActionItems();
        //return mNonActionItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.624 -0400", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "5040574501D06F18CD7ADF0F855D53F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;
        onItemsChanged(false);
        // ---------- Original Method ----------
        //mHeaderIcon = null;
        //mHeaderTitle = null;
        //mHeaderView = null;
        //onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.625 -0400", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "EFAEAA4F9B317CD297E81F7DA60C705C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setHeaderInternal(final int titleRes, final CharSequence title, final int iconRes,
            final Drawable icon, final View view) {
        dsTaint.addTaint(icon.dsTaint);
        dsTaint.addTaint(title);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(titleRes);
        dsTaint.addTaint(iconRes);
        Resources r;
        r = getResources();
        {
            mHeaderTitle = null;
            mHeaderIcon = null;
        } //End block
        {
            {
                mHeaderTitle = r.getText(titleRes);
            } //End block
            {
                mHeaderIcon = r.getDrawable(iconRes);
            } //End block
            mHeaderView = null;
        } //End block
        onItemsChanged(false);
        // ---------- Original Method ----------
        //final Resources r = getResources();
        //if (view != null) {
            //mHeaderView = view;
            //mHeaderTitle = null;
            //mHeaderIcon = null;
        //} else {
            //if (titleRes > 0) {
                //mHeaderTitle = r.getText(titleRes);
            //} else if (title != null) {
                //mHeaderTitle = title;
            //}
            //if (iconRes > 0) {
                //mHeaderIcon = r.getDrawable(iconRes);
            //} else if (icon != null) {
                //mHeaderIcon = icon;
            //}
            //mHeaderView = null;
        //}
        //onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.625 -0400", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "4011B5535F60554E5287F11E01256000")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        dsTaint.addTaint(title);
        setHeaderInternal(0, title, 0, null, null);
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setHeaderInternal(0, title, 0, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.626 -0400", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "27246E09B557A44AB96A2A341C83508F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MenuBuilder setHeaderTitleInt(int titleRes) {
        dsTaint.addTaint(titleRes);
        setHeaderInternal(titleRes, null, 0, null, null);
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setHeaderInternal(titleRes, null, 0, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.626 -0400", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "CE596D1C93DC4D6EF826D9D0A59D168E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MenuBuilder setHeaderIconInt(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        setHeaderInternal(0, null, 0, icon, null);
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, 0, icon, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.626 -0400", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "D8EC52B22CFF1B3AB624E240B9520876")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MenuBuilder setHeaderIconInt(int iconRes) {
        dsTaint.addTaint(iconRes);
        setHeaderInternal(0, null, iconRes, null, null);
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, iconRes, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.626 -0400", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "9D50E11D0B285A158FBCE09383D91461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MenuBuilder setHeaderViewInt(View view) {
        dsTaint.addTaint(view.dsTaint);
        setHeaderInternal(0, null, 0, null, view);
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, 0, null, view);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.627 -0400", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "334B4B9C04BFE78D8EE98DD4B0CDB4F3")
    @DSModeled(DSC.SAFE)
    public CharSequence getHeaderTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaderTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.627 -0400", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "D533139BCEDE5860AD913A2242909ED8")
    @DSModeled(DSC.SAFE)
    public Drawable getHeaderIcon() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHeaderIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.627 -0400", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "686DEFE6DEE4F0CD737439C9FF9BE847")
    @DSModeled(DSC.SAFE)
    public View getHeaderView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHeaderView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.627 -0400", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "7DA9A041841E4B56228E6225DBE1B9D3")
    @DSModeled(DSC.SAFE)
    public MenuBuilder getRootMenu() {
        return (MenuBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.627 -0400", hash_original_method = "8B5C0DAA8A7CB0B223A94346B39E6366", hash_generated_method = "927FCEBBE2A067CFA1F7DA4266E89D65")
    @DSModeled(DSC.SAFE)
    public void setCurrentMenuInfo(ContextMenuInfo menuInfo) {
        dsTaint.addTaint(menuInfo.dsTaint);
        // ---------- Original Method ----------
        //mCurrentMenuInfo = menuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.627 -0400", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "6FBD03118E693F9EFD49D5686A3A5D77")
    @DSModeled(DSC.SAFE)
     void setOptionalIconsVisible(boolean visible) {
        dsTaint.addTaint(visible);
        // ---------- Original Method ----------
        //mOptionalIconsVisible = visible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.628 -0400", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "2668B086705E133AA7D0165FFE1200FB")
    @DSModeled(DSC.SAFE)
     boolean getOptionalIconsVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOptionalIconsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.636 -0400", hash_original_method = "EE8D5D3489A1A55A6EA94D4BFD84A637", hash_generated_method = "7E4EC3ACDCA938F7AE0C8BDC3560AC0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean expandItemActionView(MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_934003638 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        boolean expanded;
        expanded = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_2027097800 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_2027097800.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_2027097800.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    boolean varBD9D44B19AD05CF02357248B9F10B593_1741451941 = ((expanded = presenter.expandItemActionView(this, item)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mPresenters.isEmpty()) return false;
        //boolean expanded = false;
        //stopDispatchingItemsChanged();
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else if ((expanded = presenter.expandItemActionView(this, item))) {
                //break;
            //}
        //}
        //startDispatchingItemsChanged();
        //if (expanded) {
            //mExpandedItem = item;
        //}
        //return expanded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.642 -0400", hash_original_method = "06F25D2FDACA8E4F633278E442B2C78B", hash_generated_method = "F663CD1D04F488D7387205EEA2C77FE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean collapseItemActionView(MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        {
            boolean var4FBADF22E53236C3688D67048889C135_1031547441 = (mPresenters.isEmpty() || mExpandedItem != item);
        } //End collapsed parenthetic
        boolean collapsed;
        collapsed = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_266380037 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_266380037.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_266380037.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    boolean varE23C44F770E395CB54AA09B45593018D_463586894 = ((collapsed = presenter.collapseItemActionView(this, item)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        {
            mExpandedItem = null;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mPresenters.isEmpty() || mExpandedItem != item) return false;
        //boolean collapsed = false;
        //stopDispatchingItemsChanged();
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter presenter = ref.get();
            //if (presenter == null) {
                //mPresenters.remove(ref);
            //} else if ((collapsed = presenter.collapseItemActionView(this, item))) {
                //break;
            //}
        //}
        //startDispatchingItemsChanged();
        //if (collapsed) {
            //mExpandedItem = null;
        //}
        //return collapsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.643 -0400", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "C555E2BB21E4418CD4E217710A520624")
    @DSModeled(DSC.SAFE)
    public MenuItemImpl getExpandedItem() {
        return (MenuItemImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExpandedItem;
    }

    
    public interface Callback {
        
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item);
        
        
        public void onMenuModeChange(MenuBuilder menu);
    }
    
    public interface ItemInvoker {
        public boolean invokeItem(MenuItemImpl item);
    }
    
    private static final String TAG = "MenuBuilder";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final int[]  sCategoryToOrder = new int[] {
        1, 
        4, 
        5, 
        3, 
        2, 
        0, 
    };
}

