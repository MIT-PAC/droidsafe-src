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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "7A5D05E188FBFEFD2A6CD8C4F3BE55EF", hash_generated_field = "95645DEF322B7192EFD2A867453899EE")

    private boolean mQwertyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "30F8E95083FD70AE11D91E338148BC3B", hash_generated_field = "F96F6064EBE78C516E4D1B26D5D6F308")

    private boolean mShortcutsVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "BD34AA609B2F1444C5802546CAFD9E2E")

    private ArrayList<MenuItemImpl> mItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "A3FBDEDF325DB017B2A028D8843D3A09", hash_generated_field = "D9641413264F8197F037C6D0C97110BC")

    private ArrayList<MenuItemImpl> mVisibleItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "C67DC7FD766EB504ADF36E9A3CE0C111", hash_generated_field = "542DEB4B44629FB64BB72A2F9FFA719F")

    private boolean mIsVisibleItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "7D1513D823124F3D32B4FC834B5B8CB8", hash_generated_field = "922EA5B66BFB13CAC326F75845DC9FBF")

    private ArrayList<MenuItemImpl> mActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "E0A10BB2538038AA25598A6124DCADDA", hash_generated_field = "4FA8D7123D10D7FB60C3300B4743B5E4")

    private ArrayList<MenuItemImpl> mNonActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "18F6104DD929A80984779A51B33529C5", hash_generated_field = "4672D8DE4A1D2EDA6E7A30F19E847512")

    private boolean mIsActionItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "38B00EB3AE2F97D7D4C3A7D6702A29C9", hash_generated_field = "99953610D3798A1652245FC37A11148F")

    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "F0F73BE0CFC128F21644E09022BFDB5F", hash_generated_field = "F71D241D22C847CB73D168C1498D3662")

    private ContextMenuInfo mCurrentMenuInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "C1CCD656768F0F81BE2BB78E3AA63E1D", hash_generated_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566")

    CharSequence mHeaderTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "23E59940389E4E411553D10969622DA9", hash_generated_field = "1F64D0B7244E48B7E3E328CABEC4A309")

    Drawable mHeaderIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "9AD5F9977C84732F8447E1A8FA73384D", hash_generated_field = "B9C114F754E53BD7622DBFFDE976E899")

    View mHeaderView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "13C697CF832FB88504F822C5877322BE", hash_generated_field = "C1392DA651B1F71540302368BB665E1C")

    private SparseArray<Parcelable> mFrozenViewStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "F2D7884C9E09EDA0D21EDDA033D4CA5F", hash_generated_field = "42D2AC432A6B8C4EEEB5401ED2AFDB89")

    private boolean mPreventDispatchingItemsChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "1CF0B2A4175BDCEB5A15E99C5927876A", hash_generated_field = "2CD250962FDCC7A99FD4076F077F63F8")

    private boolean mItemsChangedWhileDispatchPrevented = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "E37DE1D7A2E8152AA3413A383EAA7C8D", hash_generated_field = "726E83C5EC3729E7BB3D264007C90B65")

    private boolean mOptionalIconsVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "D0F023C09A6729446D2A2C606F365FCB", hash_generated_field = "BCD7139A79D8D9F3133E20DC6D3F207A")

    private boolean mIsClosing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "CB08465A8B1AD1C8F82C6BD49F6A5824", hash_generated_field = "42C64CF6E53F14390A86902028B317E2")

    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "F05E7F7EED7161EAC2E8B160F25C396A", hash_generated_field = "AFD9B193D2ECD6C8B664F5067DC23F76")

    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.636 -0400", hash_original_field = "FC1533ACA08DCD52B7AC7DADED834BA2", hash_generated_field = "E6D19EE97CF34609C2DF041F94F84AE4")

    private MenuItemImpl mExpandedItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.639 -0400", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "C1D57B83660DAEFC2F4CD6A8D35E9B2C")
    public  MenuBuilder(Context context) {
        mContext = context;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.639 -0400", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "446B9C7CF20E0E3E54C6F31C2CD243C5")
    public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1578223952 = null; //Variable for return #1
        mDefaultShowAsAction = defaultShowAsAction;
        varB4EAC82CA7396A68D541C85D26508E83_1578223952 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1578223952.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1578223952;
        // ---------- Original Method ----------
        //mDefaultShowAsAction = defaultShowAsAction;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.639 -0400", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "322E6294CFFE4A944F88ECCC0D937BCB")
    public void addMenuPresenter(MenuPresenter presenter) {
        mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        presenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
        addTaint(presenter.getTaint());
        // ---------- Original Method ----------
        //mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        //presenter.initForMenu(mContext, this);
        //mIsActionItemsStale = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.669 -0400", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "38DEFDE5E52DA81B8C746DAB290813BA")
    public void removeMenuPresenter(MenuPresenter presenter) {
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_984137835 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_984137835.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_984137835.next();
            {
                MenuPresenter item;
                item = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(presenter.getTaint());
        // ---------- Original Method ----------
        //for (WeakReference<MenuPresenter> ref : mPresenters) {
            //final MenuPresenter item = ref.get();
            //if (item == null || item == presenter) {
                //mPresenters.remove(ref);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.679 -0400", hash_original_method = "54D4EF8A00AA3736A7301B3768CF2956", hash_generated_method = "DCCFB7485A9FB83F6DE3E02CD385F26F")
    private void dispatchPresenterUpdate(boolean cleared) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_608784051 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_421231075 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_421231075.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_421231075.next();
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
        addTaint(cleared);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.707 -0400", hash_original_method = "972C883CEABE6EAECC969B119D377700", hash_generated_method = "26070E81A9FC7C45E429FBEA8E66EC1C")
    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_2093806180 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        boolean result;
        result = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1670691061 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1670691061.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1670691061.next();
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
        addTaint(subMenu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95423767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_95423767;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.739 -0400", hash_original_method = "8458F949934B8A3332FB7D785BD3E421", hash_generated_method = "6759C7EC6D3C61CB293B1C178B2EBDEF")
    private void dispatchSaveInstanceState(Bundle outState) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_1821237439 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        SparseArray<Parcelable> presenterStates;
        presenterStates = new SparseArray<Parcelable>();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1049294969 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1049294969.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1049294969.next();
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
        addTaint(outState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.826 -0400", hash_original_method = "4E7750A20EC8141646D41AE332CEFE6A", hash_generated_method = "52651C3566C625F68C5ED9488066C7C7")
    private void dispatchRestoreInstanceState(Bundle state) {
        SparseArray<Parcelable> presenterStates;
        presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);
        {
            boolean var978B5CD1AF436AE76C6FB0F45B00B46D_45828018 = (presenterStates == null || mPresenters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1663808704 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1663808704.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1663808704.next();
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
        addTaint(state.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.827 -0400", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "6EDC0C0B67D1FCB9B378B7774F277AE0")
    public void savePresenterStates(Bundle outState) {
        dispatchSaveInstanceState(outState);
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.841 -0400", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "1512E4DB524A6EAEFFA3F5E20287517E")
    public void restorePresenterStates(Bundle state) {
        dispatchRestoreInstanceState(state);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.842 -0400", hash_original_method = "A8F0361C85125DA8A38A18412990521E", hash_generated_method = "B0AB47E3E9C87516065C07B200CD438C")
    public void saveActionViewStates(Bundle outStates) {
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
                    boolean var094D712B8F5F2BE1027DB368EC41F641_1027777027 = (v != null && v.getId() != View.NO_ID);
                    {
                        {
                            viewStates = new SparseArray<Parcelable>();
                        } //End block
                        v.saveHierarchyState(viewStates);
                        {
                            boolean varD2DC871025EA5DE67B1C85EF2817DBBE_1576333260 = (item.isActionViewExpanded());
                            {
                                outStates.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_938645530 = (item.hasSubMenu());
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
        addTaint(outStates.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.852 -0400", hash_original_method = "B3A4CB3CCE0DD38C30DBEC80F125B14F", hash_generated_method = "4C942F58A5FC5627A2D7D71A5FC9D8BA")
    public void restoreActionViewStates(Bundle states) {
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
                    boolean var094D712B8F5F2BE1027DB368EC41F641_1396432760 = (v != null && v.getId() != View.NO_ID);
                    {
                        v.restoreHierarchyState(viewStates);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_1161086087 = (item.hasSubMenu());
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
        addTaint(states.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.852 -0400", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "298ABAEC15D73ACB784509B8C4825F00")
    protected String getActionViewStatesKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_397758432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_397758432 = ACTION_VIEW_STATES_KEY;
        varB4EAC82CA7396A68D541C85D26508E83_397758432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_397758432;
        // ---------- Original Method ----------
        //return ACTION_VIEW_STATES_KEY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.855 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.855 -0400", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "1CBB2205FD326F7947E043C2DF2FE75B")
    private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1677783694 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1677783694 = item;
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1677783694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677783694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.863 -0400", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "4C3B8AF1E09F65CF2B56579BD0A0907A")
    public MenuItem add(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_492833059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_492833059 = addInternal(0, 0, 0, title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_492833059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492833059;
        // ---------- Original Method ----------
        //return addInternal(0, 0, 0, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.864 -0400", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "701F673E8E20848EDB89F14C61134336")
    public MenuItem add(int titleRes) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_62370939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_62370939 = addInternal(0, 0, 0, mResources.getString(titleRes));
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_62370939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_62370939;
        // ---------- Original Method ----------
        //return addInternal(0, 0, 0, mResources.getString(titleRes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.865 -0400", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "C86FFE46DA24795B864924CE11CB7BBE")
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_820164524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_820164524 = addInternal(group, id, categoryOrder, title);
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_820164524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_820164524;
        // ---------- Original Method ----------
        //return addInternal(group, id, categoryOrder, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.865 -0400", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "5DFC90970649FFA0E28111921CF79B4C")
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1148324471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1148324471 = addInternal(group, id, categoryOrder, mResources.getString(title));
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_1148324471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1148324471;
        // ---------- Original Method ----------
        //return addInternal(group, id, categoryOrder, mResources.getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.885 -0400", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "84330EB1837D4CF02106B966DB00BC76")
    public SubMenu addSubMenu(CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1568807565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1568807565 = addSubMenu(0, 0, 0, title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1568807565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568807565;
        // ---------- Original Method ----------
        //return addSubMenu(0, 0, 0, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.887 -0400", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "137A9D5D14C6978F041BFDC372574026")
    public SubMenu addSubMenu(int titleRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_300434243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_300434243 = addSubMenu(0, 0, 0, mResources.getString(titleRes));
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_300434243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_300434243;
        // ---------- Original Method ----------
        //return addSubMenu(0, 0, 0, mResources.getString(titleRes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.887 -0400", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "1371D763517A8DE08EEAAA3AC227025B")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_453524642 = null; //Variable for return #1
        MenuItemImpl item;
        item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        SubMenuBuilder subMenu;
        subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);
        varB4EAC82CA7396A68D541C85D26508E83_453524642 = subMenu;
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_453524642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453524642;
        // ---------- Original Method ----------
        //final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        //final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        //item.setSubMenu(subMenu);
        //return subMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.888 -0400", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "3C9EE58D2C7A4DE36F95DA6AC31162FC")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_340878290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_340878290 = addSubMenu(group, id, categoryOrder, mResources.getString(title));
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_340878290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340878290;
        // ---------- Original Method ----------
        //return addSubMenu(group, id, categoryOrder, mResources.getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.888 -0400", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "0F5460883DE5CF4FBCD7E3595CA24BBD")
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
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
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(caller.getTaint());
        addTaint(specifics[0].getTaint());
        addTaint(intent.getTaint());
        addTaint(flags);
        addTaint(outSpecificItems[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795018502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795018502;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.891 -0400", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "FBDE2F1A6AE885630DD91F19E98167B9")
    public void removeItem(int id) {
        removeItemAtInt(findItemIndex(id), true);
        addTaint(id);
        // ---------- Original Method ----------
        //removeItemAtInt(findItemIndex(id), true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.891 -0400", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "0C2EF9CAE0B0E83BD768C276BD035768")
    public void removeGroup(int group) {
        int i;
        i = findGroupIndex(group);
        {
            int maxRemovable;
            maxRemovable = mItems.size() - i;
            int numRemoved;
            numRemoved = 0;
            {
                boolean varB635114C3F531E77FD0C631F7E17EB16_1231493331 = ((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group));
                {
                    removeItemAtInt(i, false);
                } //End block
            } //End collapsed parenthetic
            onItemsChanged(true);
        } //End block
        addTaint(group);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.892 -0400", hash_original_method = "B04372368F85324A2D15939652770F19", hash_generated_method = "415731E03C30F6C565C915328E01902E")
    private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        {
            boolean var338D9D416353CE7F8A425352D2B29717_1062762053 = ((index < 0) || (index >= mItems.size()));
        } //End collapsed parenthetic
        mItems.remove(index);
        onItemsChanged(true);
        addTaint(index);
        addTaint(updateChildrenOnMenuViews);
        // ---------- Original Method ----------
        //if ((index < 0) || (index >= mItems.size())) return;
        //mItems.remove(index);
        //if (updateChildrenOnMenuViews) onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.892 -0400", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "516CE6CEA2C84AA7026941E518891C48")
    public void removeItemAt(int index) {
        removeItemAtInt(index, true);
        addTaint(index);
        // ---------- Original Method ----------
        //removeItemAtInt(index, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.892 -0400", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "EE1F5DE30C303F3D28461F50B1CD8998")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.906 -0400", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "FF7B938D8B551DFA519348BF50A383E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.907 -0400", hash_original_method = "46B444F22731C330EF8C5DDD6085B819", hash_generated_method = "B53B774659FE6EAF759EFC599C7B7905")
     void setExclusiveItemChecked(MenuItem item) {
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
                    boolean var8EE8AC9535910453B171626ECFBE2970_1031775769 = (curItem.getGroupId() == group);
                    {
                        {
                            boolean var7E3666046252DE45A97E32C83CBBDAF4_943037044 = (!curItem.isExclusiveCheckable());
                        } //End collapsed parenthetic
                        {
                            boolean var8CDB89E4B55B2B7E8661481E53525A9E_629054057 = (!curItem.isCheckable());
                        } //End collapsed parenthetic
                        curItem.setCheckedInt(curItem == item);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(item.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.908 -0400", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "DF4633EC80294990863DFD028D3124F5")
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        int N;
        N = mItems.size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1917300772 = (item.getGroupId() == group);
                    {
                        item.setExclusiveCheckable(exclusive);
                        item.setCheckable(checkable);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(group);
        addTaint(checkable);
        addTaint(exclusive);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.915 -0400", hash_original_method = "4EDC76E82EDC17A472BC69BB1B6E7C6A", hash_generated_method = "EF8DF29E95C0F6BA0701F9641A401F88")
    public void setGroupVisible(int group, boolean visible) {
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
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_504644834 = (item.getGroupId() == group);
                    {
                        {
                            boolean var4DB4446F3346E01932ADAD4B5683F498_1453911604 = (item.setVisibleInt(visible));
                            changedAtLeastOneItem = true;
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        onItemsChanged(true);
        addTaint(group);
        addTaint(visible);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.917 -0400", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "479C4C06455FEF45DCC57E09DE44CD1E")
    public void setGroupEnabled(int group, boolean enabled) {
        int N;
        N = mItems.size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_630198766 = (item.getGroupId() == group);
                    {
                        item.setEnabled(enabled);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(group);
        addTaint(enabled);
        // ---------- Original Method ----------
        //final int N = mItems.size();
        //for (int i = 0; i < N; i++) {
            //MenuItemImpl item = mItems.get(i);
            //if (item.getGroupId() == group) {
                //item.setEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.918 -0400", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "B9777853D0665836F85E9AA6F15917DC")
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
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_904374656 = (item.isVisible());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105777914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105777914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.919 -0400", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "353B595B703EE09513481523DF60D7F7")
    public MenuItem findItem(int id) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1711264249 = null; //Variable for return #1
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_141313568 = null; //Variable for return #2
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2036254986 = null; //Variable for return #3
        int size;
        size = size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_1498679518 = (item.getItemId() == id);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1711264249 = item;
                    } //End block
                    {
                        boolean var2A76345EF62F0728C298DB442BA98AFC_753359639 = (item.hasSubMenu());
                        {
                            MenuItem possibleItem;
                            possibleItem = item.getSubMenu().findItem(id);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_141313568 = possibleItem;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2036254986 = null;
        addTaint(id);
        MenuItem varA7E53CE21691AB073D9660D615818899_1429269186; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1429269186 = varB4EAC82CA7396A68D541C85D26508E83_1711264249;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1429269186 = varB4EAC82CA7396A68D541C85D26508E83_141313568;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1429269186 = varB4EAC82CA7396A68D541C85D26508E83_2036254986;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1429269186.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1429269186;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.922 -0400", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "E73844FFFFD84868CE25A54EF4036BD0")
    public int findItemIndex(int id) {
        int size;
        size = size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_1612747044 = (item.getItemId() == id);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_946482083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_946482083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.922 -0400", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "104B4395A481EE4A134EFFA96B986547")
    public int findGroupIndex(int group) {
        int varF2F0AE9233F1B982D371F99153BF98DC_34954622 = (findGroupIndex(group, 0));
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136273392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136273392;
        // ---------- Original Method ----------
        //return findGroupIndex(group, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.923 -0400", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "9C7BF6AA474C52DE96435FCB90F7928E")
    public int findGroupIndex(int group, int start) {
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
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_544642888 = (item.getGroupId() == group);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(group);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886961322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886961322;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.924 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "656FC0BE4C1CBDCC1A0C0815701A8D30")
    public int size() {
        int var903E593E570CF8A7196E435EA30221CF_1073114087 = (mItems.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459515025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459515025;
        // ---------- Original Method ----------
        //return mItems.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.936 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "A975935E1B30D20812865F26EE70C0AD")
    public MenuItem getItem(int index) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_528649895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_528649895 = mItems.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_528649895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_528649895;
        // ---------- Original Method ----------
        //return mItems.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.936 -0400", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "6C9C3F962DE4AC5ECE74BFF66238E613")
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        boolean var83E816433D6C5D634DA5F2A1F1927716_1869091661 = (findItemWithShortcutForKey(keyCode, event) != null);
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850225893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850225893;
        // ---------- Original Method ----------
        //return findItemWithShortcutForKey(keyCode, event) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.937 -0400", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "4EF925579ED2A5FE24BA9D877FE5657E")
    public void setQwertyMode(boolean isQwerty) {
        mQwertyMode = isQwerty;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.937 -0400", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "4F7FF534C5F43CE01EEB5D38DC7D5941")
     boolean isQwertyMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19387386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19387386;
        // ---------- Original Method ----------
        //return mQwertyMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.937 -0400", hash_original_method = "5CCA4A69E642C22AB6858AA5EF093CEB", hash_generated_method = "46BD00A9D878E1A6DC21A4E21F8540AD")
    public void setShortcutsVisible(boolean shortcutsVisible) {
        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
        addTaint(shortcutsVisible);
        // ---------- Original Method ----------
        //if (mShortcutsVisible == shortcutsVisible) return;
        //setShortcutsVisibleInner(shortcutsVisible);
        //onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.938 -0400", hash_original_method = "BCC95ACBA680BEE1F3E7AD661CBC9615", hash_generated_method = "5F1306E253C0176589E31B06AFE8A16B")
    private void setShortcutsVisibleInner(boolean shortcutsVisible) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.938 -0400", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "B6E623BBB13FC1779FB8F1FFC1BDB6DF")
    public boolean isShortcutsVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867320626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867320626;
        // ---------- Original Method ----------
        //return mShortcutsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.938 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "01A9AB4A727D9A54DEEFB00F71F816B6")
     Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_808450963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_808450963 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_808450963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_808450963;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.951 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "FF5A2A513BB70559932F1E68BC7F5E19")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1845881989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1845881989 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1845881989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1845881989;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.951 -0400", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "7A0048940AA2ECAFCEFEEA7E49BE91D7")
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        boolean var4651BA2AB2CDEB5FBB4C6B09193CF147_406848943 = (mCallback != null && mCallback.onMenuItemSelected(menu, item));
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160543948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160543948;
        // ---------- Original Method ----------
        //return mCallback != null && mCallback.onMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.954 -0400", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "FDB098940DBBCEA38E17715D59A20179")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.955 -0400", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "66BBDF2DD8737FA63B051AB16511BF8F")
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
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
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482843515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482843515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.966 -0400", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "1CCC598D8D9BBD46E8C9CA24F1B4A779")
     void findItemsWithShortcutForKey(List<MenuItemImpl> items, int keyCode, KeyEvent event) {
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
                    boolean varABB06CC79DFE43B426156FAD8042633B_1563167410 = (item.hasSubMenu());
                    {
                        ((MenuBuilder)item.getSubMenu()).findItemsWithShortcutForKey(items, keyCode, event);
                    } //End block
                } //End collapsed parenthetic
                char shortcutChar;
                shortcutChar = item.getAlphabeticShortcut();
                shortcutChar = item.getNumericShortcut();
                {
                    boolean var4B1C4B88C00B83DF48844FF91D97425B_954122329 = (((metaState & (KeyEvent.META_SHIFT_ON | KeyEvent.META_SYM_ON)) == 0) &&
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
        addTaint(items.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.967 -0400", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "593DBF6F01F6FF9A7A8338D13A412D88")
     MenuItemImpl findItemWithShortcutForKey(int keyCode, KeyEvent event) {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1240474607 = null; //Variable for return #1
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_782010324 = null; //Variable for return #2
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_421922613 = null; //Variable for return #3
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_583022133 = null; //Variable for return #4
        ArrayList<MenuItemImpl> items;
        items = mTempShortcutItemList;
        items.clear();
        findItemsWithShortcutForKey(items, keyCode, event);
        {
            boolean varDC7DD6E6607E60D056C701649F2FCC72_146348629 = (items.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1240474607 = null;
            } //End block
        } //End collapsed parenthetic
        int metaState;
        metaState = event.getMetaState();
        KeyCharacterMap.KeyData possibleChars;
        possibleChars = new KeyCharacterMap.KeyData();
        event.getKeyData(possibleChars);
        int size;
        size = items.size();
        {
            varB4EAC82CA7396A68D541C85D26508E83_782010324 = items.get(0);
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
                {
                    varB4EAC82CA7396A68D541C85D26508E83_421922613 = item;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_583022133 = null;
        addTaint(keyCode);
        addTaint(event.getTaint());
        MenuItemImpl varA7E53CE21691AB073D9660D615818899_1772695413; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1772695413 = varB4EAC82CA7396A68D541C85D26508E83_1240474607;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1772695413 = varB4EAC82CA7396A68D541C85D26508E83_782010324;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1772695413 = varB4EAC82CA7396A68D541C85D26508E83_421922613;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1772695413 = varB4EAC82CA7396A68D541C85D26508E83_583022133;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1772695413.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1772695413;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.968 -0400", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "03B54D34CF57C328C42221854EFFDE61")
    public boolean performIdentifierAction(int id, int flags) {
        boolean varC0CA7E336E0E2B8E0733C1AA972420EC_1140293108 = (performItemAction(findItem(id), flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1027508668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1027508668;
        // ---------- Original Method ----------
        //return performItemAction(findItem(id), flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.982 -0400", hash_original_method = "35FE8CE6C993B07CD0CB9DB44F8CBE25", hash_generated_method = "8633614CF2FB906A39FE584F7719D395")
    public boolean performItemAction(MenuItem item, int flags) {
        MenuItemImpl itemImpl;
        itemImpl = (MenuItemImpl) item;
        {
            boolean var4046EFD8ABBFFA045BEA239ADDC2688E_1809887483 = (itemImpl == null || !itemImpl.isEnabled());
        } //End collapsed parenthetic
        boolean invoked;
        invoked = itemImpl.invoke();
        {
            boolean varB2A71AC4CF06459A52AAFC8C1B2AA2A9_627235448 = (itemImpl.hasCollapsibleActionView());
            {
                invoked |= itemImpl.expandActionView();
                close(true);
            } //End block
            {
                boolean var5D978436017CCBE177EE4E51CAD278B4_974876062 = (item.hasSubMenu());
                {
                    close(false);
                    SubMenuBuilder subMenu;
                    subMenu = (SubMenuBuilder) item.getSubMenu();
                    ActionProvider provider;
                    provider = item.getActionProvider();
                    {
                        boolean var2102918082958942CF9C792E151F0C24_1431191257 = (provider != null && provider.hasSubMenu());
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
        addTaint(item.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324690577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324690577;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.040 -0400", hash_original_method = "95071F981B5536F482A785105041F83F", hash_generated_method = "D06D660585AC28D42721A6658013EB2A")
    final void close(boolean allMenusAreClosing) {
        mIsClosing = true;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1779445837 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1779445837.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1779445837.next();
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
        addTaint(allMenusAreClosing);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.040 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        // ---------- Original Method ----------
        //close(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.052 -0400", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "1166675B6D8C3C88D7696455EBDC7C04")
     void onItemsChanged(boolean structureChanged) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(structureChanged);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.052 -0400", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "9C920614B8D86D336BB2A3CBA43EF20D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.053 -0400", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "7BDF5DE5A18E4A87DFF9992D7EFE1939")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.054 -0400", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "33982F2357D1AF78560384DB30B2D092")
     void onItemVisibleChanged(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //mIsVisibleItemsStale = true;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.054 -0400", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "3086273B28105BE1A09378D2580E2297")
     void onItemActionRequestChanged(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsActionItemsStale = true;
        onItemsChanged(true);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //mIsActionItemsStale = true;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.055 -0400", hash_original_method = "66450A6B071A6D6254ADE6AFA4286392", hash_generated_method = "A13E42BDE9F44CDBDCA8D8CB3A88145B")
     ArrayList<MenuItemImpl> getVisibleItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1167895047 = null; //Variable for return #1
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_952412565 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1167895047 = mVisibleItems;
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
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_1058056035 = (item.isVisible());
                    mVisibleItems.add(item);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
        varB4EAC82CA7396A68D541C85D26508E83_952412565 = mVisibleItems;
        ArrayList<MenuItemImpl> varA7E53CE21691AB073D9660D615818899_1138133819; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1138133819 = varB4EAC82CA7396A68D541C85D26508E83_1167895047;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1138133819 = varB4EAC82CA7396A68D541C85D26508E83_952412565;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1138133819.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1138133819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.167 -0400", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "3C6CE128CFD893EA61F373F540BF9C80")
    public void flagActionItems() {
        boolean flagged;
        flagged = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1797703866 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1797703866.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1797703866.next();
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
                        boolean var8C7900E5A6181E1C7522686688712CC9_2330610 = (item.isActionButton());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.169 -0400", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "9AF021736F3D879CE666E22B9C7543E1")
     ArrayList<MenuItemImpl> getActionItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_983704961 = null; //Variable for return #1
        flagActionItems();
        varB4EAC82CA7396A68D541C85D26508E83_983704961 = mActionItems;
        varB4EAC82CA7396A68D541C85D26508E83_983704961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_983704961;
        // ---------- Original Method ----------
        //flagActionItems();
        //return mActionItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.170 -0400", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "592FA9477778093B282D1DEAA2C6B12A")
     ArrayList<MenuItemImpl> getNonActionItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_691159573 = null; //Variable for return #1
        flagActionItems();
        varB4EAC82CA7396A68D541C85D26508E83_691159573 = mNonActionItems;
        varB4EAC82CA7396A68D541C85D26508E83_691159573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_691159573;
        // ---------- Original Method ----------
        //flagActionItems();
        //return mNonActionItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.174 -0400", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "5040574501D06F18CD7ADF0F855D53F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.174 -0400", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "C5D8E0A87809B5CAA00033D322BFBEFB")
    private void setHeaderInternal(final int titleRes, final CharSequence title, final int iconRes,
            final Drawable icon, final View view) {
        Resources r;
        r = getResources();
        {
            mHeaderView = view;
            mHeaderTitle = null;
            mHeaderIcon = null;
        } //End block
        {
            {
                mHeaderTitle = r.getText(titleRes);
            } //End block
            {
                mHeaderTitle = title;
            } //End block
            {
                mHeaderIcon = r.getDrawable(iconRes);
            } //End block
            {
                mHeaderIcon = icon;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.175 -0400", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "C33138C14BB3C33ED2FE6AC8682DC2CA")
    protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1288070695 = null; //Variable for return #1
        setHeaderInternal(0, title, 0, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_1288070695 = this;
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1288070695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1288070695;
        // ---------- Original Method ----------
        //setHeaderInternal(0, title, 0, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.175 -0400", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "CDF966A202E40D1420BCCE509A745040")
    protected MenuBuilder setHeaderTitleInt(int titleRes) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_170507837 = null; //Variable for return #1
        setHeaderInternal(titleRes, null, 0, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_170507837 = this;
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_170507837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170507837;
        // ---------- Original Method ----------
        //setHeaderInternal(titleRes, null, 0, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.176 -0400", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "4E7DA7187F7D564A411D9FB27274D2EA")
    protected MenuBuilder setHeaderIconInt(Drawable icon) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1557416591 = null; //Variable for return #1
        setHeaderInternal(0, null, 0, icon, null);
        varB4EAC82CA7396A68D541C85D26508E83_1557416591 = this;
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1557416591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1557416591;
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, 0, icon, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.176 -0400", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "DF4028DE3CFD48E81A37CD9C283081B3")
    protected MenuBuilder setHeaderIconInt(int iconRes) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_519314909 = null; //Variable for return #1
        setHeaderInternal(0, null, iconRes, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_519314909 = this;
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_519314909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_519314909;
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, iconRes, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.183 -0400", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "016320F9DB214C66AC97A880734980CB")
    protected MenuBuilder setHeaderViewInt(View view) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1015436578 = null; //Variable for return #1
        setHeaderInternal(0, null, 0, null, view);
        varB4EAC82CA7396A68D541C85D26508E83_1015436578 = this;
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1015436578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015436578;
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, 0, null, view);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.198 -0400", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "6E1C0CBA80A4497C29B8574258ECAEF5")
    public CharSequence getHeaderTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1283087328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1283087328 = mHeaderTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1283087328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1283087328;
        // ---------- Original Method ----------
        //return mHeaderTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.199 -0400", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "C8A4DF9074187A8EE241461EC135B8DA")
    public Drawable getHeaderIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_106121943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_106121943 = mHeaderIcon;
        varB4EAC82CA7396A68D541C85D26508E83_106121943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106121943;
        // ---------- Original Method ----------
        //return mHeaderIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.199 -0400", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "EC9B26C137E59C59693F606126E82D8D")
    public View getHeaderView() {
        View varB4EAC82CA7396A68D541C85D26508E83_291034280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_291034280 = mHeaderView;
        varB4EAC82CA7396A68D541C85D26508E83_291034280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_291034280;
        // ---------- Original Method ----------
        //return mHeaderView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.200 -0400", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "EC74B1B0B669C9301C638A4049F55AE5")
    public MenuBuilder getRootMenu() {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1352898351 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1352898351 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1352898351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352898351;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.200 -0400", hash_original_method = "8B5C0DAA8A7CB0B223A94346B39E6366", hash_generated_method = "44FD6FA0FC67E1F797EECB25B51E33BF")
    public void setCurrentMenuInfo(ContextMenuInfo menuInfo) {
        mCurrentMenuInfo = menuInfo;
        // ---------- Original Method ----------
        //mCurrentMenuInfo = menuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.200 -0400", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "E45EEED5BD943ACCCE728FF6AF008161")
     void setOptionalIconsVisible(boolean visible) {
        mOptionalIconsVisible = visible;
        // ---------- Original Method ----------
        //mOptionalIconsVisible = visible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.200 -0400", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "E32B477C635EB25FB999071855334BC0")
     boolean getOptionalIconsVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731542432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731542432;
        // ---------- Original Method ----------
        //return mOptionalIconsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.268 -0400", hash_original_method = "EE8D5D3489A1A55A6EA94D4BFD84A637", hash_generated_method = "0BED03EAC182A5A943D467084B219412")
    public boolean expandItemActionView(MenuItemImpl item) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_127111097 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        boolean expanded;
        expanded = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_551531962 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_551531962.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_551531962.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    boolean varBD9D44B19AD05CF02357248B9F10B593_909662793 = ((expanded = presenter.expandItemActionView(this, item)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        {
            mExpandedItem = item;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461963197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461963197;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.375 -0400", hash_original_method = "06F25D2FDACA8E4F633278E442B2C78B", hash_generated_method = "A8733FBCB66D159168C2996F534B05BA")
    public boolean collapseItemActionView(MenuItemImpl item) {
        {
            boolean var4FBADF22E53236C3688D67048889C135_1013741450 = (mPresenters.isEmpty() || mExpandedItem != item);
        } //End collapsed parenthetic
        boolean collapsed;
        collapsed = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_291986702 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_291986702.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_291986702.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    boolean varE23C44F770E395CB54AA09B45593018D_1765742961 = ((collapsed = presenter.collapseItemActionView(this, item)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        {
            mExpandedItem = null;
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517667713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517667713;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.375 -0400", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "B59ECAC837C56CB43111A154501F2AEA")
    public MenuItemImpl getExpandedItem() {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1169369190 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1169369190 = mExpandedItem;
        varB4EAC82CA7396A68D541C85D26508E83_1169369190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1169369190;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.375 -0400", hash_original_field = "BB6CD346D213200830556CD1DC16291F", hash_generated_field = "1125ADEBFEC174C894F1A8A085279424")

    private static String TAG = "MenuBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.376 -0400", hash_original_field = "B1647BCC76A3DEF9EA1440031CF86BB7", hash_generated_field = "56B86460F10C1920390B189F45BF42CF")

    private static String PRESENTER_KEY = "android:menu:presenters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.376 -0400", hash_original_field = "F6032A2BB65ECFD85343DA439A98DAFE", hash_generated_field = "1264C5214F80D901B1D728BA45B6DF45")

    private static String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.376 -0400", hash_original_field = "86D3690E30D6D0F2F4756FB1BF14DA51", hash_generated_field = "57697A209F0C3A92B476B4FAC4085AF6")

    private static String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.376 -0400", hash_original_field = "CB8E4B88C807FCCC22D973064080953E", hash_generated_field = "CFE51F782288D26701634F3589713DDA")

    private static int[] sCategoryToOrder = new int[] {
        1, 
        4, 
        5, 
        3, 
        2, 
        0, 
    };
}

