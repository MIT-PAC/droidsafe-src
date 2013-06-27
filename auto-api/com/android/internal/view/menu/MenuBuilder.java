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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "7A5D05E188FBFEFD2A6CD8C4F3BE55EF", hash_generated_field = "95645DEF322B7192EFD2A867453899EE")

    private boolean mQwertyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "30F8E95083FD70AE11D91E338148BC3B", hash_generated_field = "F96F6064EBE78C516E4D1B26D5D6F308")

    private boolean mShortcutsVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "BD34AA609B2F1444C5802546CAFD9E2E")

    private ArrayList<MenuItemImpl> mItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "A3FBDEDF325DB017B2A028D8843D3A09", hash_generated_field = "D9641413264F8197F037C6D0C97110BC")

    private ArrayList<MenuItemImpl> mVisibleItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "C67DC7FD766EB504ADF36E9A3CE0C111", hash_generated_field = "542DEB4B44629FB64BB72A2F9FFA719F")

    private boolean mIsVisibleItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "7D1513D823124F3D32B4FC834B5B8CB8", hash_generated_field = "922EA5B66BFB13CAC326F75845DC9FBF")

    private ArrayList<MenuItemImpl> mActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "E0A10BB2538038AA25598A6124DCADDA", hash_generated_field = "4FA8D7123D10D7FB60C3300B4743B5E4")

    private ArrayList<MenuItemImpl> mNonActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "18F6104DD929A80984779A51B33529C5", hash_generated_field = "4672D8DE4A1D2EDA6E7A30F19E847512")

    private boolean mIsActionItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "38B00EB3AE2F97D7D4C3A7D6702A29C9", hash_generated_field = "99953610D3798A1652245FC37A11148F")

    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "F0F73BE0CFC128F21644E09022BFDB5F", hash_generated_field = "F71D241D22C847CB73D168C1498D3662")

    private ContextMenuInfo mCurrentMenuInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "C1CCD656768F0F81BE2BB78E3AA63E1D", hash_generated_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566")

    CharSequence mHeaderTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "23E59940389E4E411553D10969622DA9", hash_generated_field = "1F64D0B7244E48B7E3E328CABEC4A309")

    Drawable mHeaderIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "9AD5F9977C84732F8447E1A8FA73384D", hash_generated_field = "B9C114F754E53BD7622DBFFDE976E899")

    View mHeaderView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.133 -0400", hash_original_field = "13C697CF832FB88504F822C5877322BE", hash_generated_field = "C1392DA651B1F71540302368BB665E1C")

    private SparseArray<Parcelable> mFrozenViewStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "F2D7884C9E09EDA0D21EDDA033D4CA5F", hash_generated_field = "42D2AC432A6B8C4EEEB5401ED2AFDB89")

    private boolean mPreventDispatchingItemsChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "1CF0B2A4175BDCEB5A15E99C5927876A", hash_generated_field = "2CD250962FDCC7A99FD4076F077F63F8")

    private boolean mItemsChangedWhileDispatchPrevented = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "E37DE1D7A2E8152AA3413A383EAA7C8D", hash_generated_field = "726E83C5EC3729E7BB3D264007C90B65")

    private boolean mOptionalIconsVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "D0F023C09A6729446D2A2C606F365FCB", hash_generated_field = "BCD7139A79D8D9F3133E20DC6D3F207A")

    private boolean mIsClosing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "CB08465A8B1AD1C8F82C6BD49F6A5824", hash_generated_field = "42C64CF6E53F14390A86902028B317E2")

    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "F05E7F7EED7161EAC2E8B160F25C396A", hash_generated_field = "AFD9B193D2ECD6C8B664F5067DC23F76")

    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.134 -0400", hash_original_field = "FC1533ACA08DCD52B7AC7DADED834BA2", hash_generated_field = "E6D19EE97CF34609C2DF041F94F84AE4")

    private MenuItemImpl mExpandedItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.142 -0400", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "C1D57B83660DAEFC2F4CD6A8D35E9B2C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.143 -0400", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "4BCA4400B35C6574D40AD4C8FC3C6051")
    public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_94991280 = null; //Variable for return #1
        mDefaultShowAsAction = defaultShowAsAction;
        varB4EAC82CA7396A68D541C85D26508E83_94991280 = this;
        varB4EAC82CA7396A68D541C85D26508E83_94991280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_94991280;
        // ---------- Original Method ----------
        //mDefaultShowAsAction = defaultShowAsAction;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.143 -0400", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "322E6294CFFE4A944F88ECCC0D937BCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.175 -0400", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "9CEF8A38BFBDB8F13F9875365D67E371")
    public void removeMenuPresenter(MenuPresenter presenter) {
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1395731811 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1395731811.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1395731811.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.206 -0400", hash_original_method = "54D4EF8A00AA3736A7301B3768CF2956", hash_generated_method = "53EEBE802F6420AA18E452CAED7D6C07")
    private void dispatchPresenterUpdate(boolean cleared) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_1517919743 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1525719838 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1525719838.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1525719838.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.244 -0400", hash_original_method = "972C883CEABE6EAECC969B119D377700", hash_generated_method = "50DF4616863308ABDD295252920B0819")
    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_958261730 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        boolean result;
        result = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_2057726434 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_2057726434.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_2057726434.next();
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037315030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037315030;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.291 -0400", hash_original_method = "8458F949934B8A3332FB7D785BD3E421", hash_generated_method = "176AE3AB8C5AFAD5B253BC11653A7AC0")
    private void dispatchSaveInstanceState(Bundle outState) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_1201821303 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        SparseArray<Parcelable> presenterStates;
        presenterStates = new SparseArray<Parcelable>();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1684300669 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1684300669.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1684300669.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.345 -0400", hash_original_method = "4E7750A20EC8141646D41AE332CEFE6A", hash_generated_method = "4525A420336E90E816C5C1673F59E3AB")
    private void dispatchRestoreInstanceState(Bundle state) {
        SparseArray<Parcelable> presenterStates;
        presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);
        {
            boolean var978B5CD1AF436AE76C6FB0F45B00B46D_1490649150 = (presenterStates == null || mPresenters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1598734338 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1598734338.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1598734338.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.346 -0400", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "6EDC0C0B67D1FCB9B378B7774F277AE0")
    public void savePresenterStates(Bundle outState) {
        dispatchSaveInstanceState(outState);
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.346 -0400", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "1512E4DB524A6EAEFFA3F5E20287517E")
    public void restorePresenterStates(Bundle state) {
        dispatchRestoreInstanceState(state);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.357 -0400", hash_original_method = "A8F0361C85125DA8A38A18412990521E", hash_generated_method = "DEE812B2EB4C81D68DD87433284C8A18")
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
                    boolean var094D712B8F5F2BE1027DB368EC41F641_2056489449 = (v != null && v.getId() != View.NO_ID);
                    {
                        {
                            viewStates = new SparseArray<Parcelable>();
                        } //End block
                        v.saveHierarchyState(viewStates);
                        {
                            boolean varD2DC871025EA5DE67B1C85EF2817DBBE_1423789264 = (item.isActionViewExpanded());
                            {
                                outStates.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_1022298950 = (item.hasSubMenu());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.358 -0400", hash_original_method = "B3A4CB3CCE0DD38C30DBEC80F125B14F", hash_generated_method = "40E6AF13C105365FB9910A05F77BDC7F")
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
                    boolean var094D712B8F5F2BE1027DB368EC41F641_457741437 = (v != null && v.getId() != View.NO_ID);
                    {
                        v.restoreHierarchyState(viewStates);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_932494473 = (item.hasSubMenu());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.370 -0400", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "E197871743B016BF00F7AFB13D646D95")
    protected String getActionViewStatesKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_8141938 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_8141938 = ACTION_VIEW_STATES_KEY;
        varB4EAC82CA7396A68D541C85D26508E83_8141938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_8141938;
        // ---------- Original Method ----------
        //return ACTION_VIEW_STATES_KEY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.371 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.372 -0400", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "3F02AA0C9CF836490FC51E95AEDBB094")
    private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_767966186 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_767966186 = item;
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_767966186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767966186;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.372 -0400", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "CB7943DCBA880C0657DD7CD73C5D0EE5")
    public MenuItem add(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_279968847 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_279968847 = addInternal(0, 0, 0, title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_279968847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_279968847;
        // ---------- Original Method ----------
        //return addInternal(0, 0, 0, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.373 -0400", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "3E463CABEF4BF7D7A375BDF06BA5C649")
    public MenuItem add(int titleRes) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1311261740 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1311261740 = addInternal(0, 0, 0, mResources.getString(titleRes));
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_1311261740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1311261740;
        // ---------- Original Method ----------
        //return addInternal(0, 0, 0, mResources.getString(titleRes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.390 -0400", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "39AD047E0B7599AC518DFA0C0DAD826F")
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_818334624 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_818334624 = addInternal(group, id, categoryOrder, title);
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_818334624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_818334624;
        // ---------- Original Method ----------
        //return addInternal(group, id, categoryOrder, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.392 -0400", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "EA9389A169CFD9D32F07E8AEAE5AD620")
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_51659375 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_51659375 = addInternal(group, id, categoryOrder, mResources.getString(title));
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_51659375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51659375;
        // ---------- Original Method ----------
        //return addInternal(group, id, categoryOrder, mResources.getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.402 -0400", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "56100E85D0C991C967616783DEC223B7")
    public SubMenu addSubMenu(CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1748499265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748499265 = addSubMenu(0, 0, 0, title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1748499265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748499265;
        // ---------- Original Method ----------
        //return addSubMenu(0, 0, 0, title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.402 -0400", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "04569EADC17A8E5E6D727C6CC5743BC6")
    public SubMenu addSubMenu(int titleRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_520872030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_520872030 = addSubMenu(0, 0, 0, mResources.getString(titleRes));
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_520872030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_520872030;
        // ---------- Original Method ----------
        //return addSubMenu(0, 0, 0, mResources.getString(titleRes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.403 -0400", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "26C5AA2FF4BDC8A88F7CFD0B0D1D3424")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1755562291 = null; //Variable for return #1
        MenuItemImpl item;
        item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        SubMenuBuilder subMenu;
        subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);
        varB4EAC82CA7396A68D541C85D26508E83_1755562291 = subMenu;
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1755562291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1755562291;
        // ---------- Original Method ----------
        //final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        //final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        //item.setSubMenu(subMenu);
        //return subMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.418 -0400", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "B93DF979C1F143DD6D234B3ADA3DF42C")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1363589263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1363589263 = addSubMenu(group, id, categoryOrder, mResources.getString(title));
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_1363589263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363589263;
        // ---------- Original Method ----------
        //return addSubMenu(group, id, categoryOrder, mResources.getString(title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.419 -0400", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "7CF407A17DBBA8A8CF44068026B9ACC2")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027390070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027390070;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.420 -0400", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "FBDE2F1A6AE885630DD91F19E98167B9")
    public void removeItem(int id) {
        removeItemAtInt(findItemIndex(id), true);
        addTaint(id);
        // ---------- Original Method ----------
        //removeItemAtInt(findItemIndex(id), true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.420 -0400", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "601132598EBCF50A5B2ACADFA62E9CF1")
    public void removeGroup(int group) {
        int i;
        i = findGroupIndex(group);
        {
            int maxRemovable;
            maxRemovable = mItems.size() - i;
            int numRemoved;
            numRemoved = 0;
            {
                boolean varB635114C3F531E77FD0C631F7E17EB16_17250230 = ((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.420 -0400", hash_original_method = "B04372368F85324A2D15939652770F19", hash_generated_method = "FC762FED6FA3A3FF7C0BA57E41A238CD")
    private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        {
            boolean var338D9D416353CE7F8A425352D2B29717_1691013296 = ((index < 0) || (index >= mItems.size()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.421 -0400", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "516CE6CEA2C84AA7026941E518891C48")
    public void removeItemAt(int index) {
        removeItemAtInt(index, true);
        addTaint(index);
        // ---------- Original Method ----------
        //removeItemAtInt(index, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.421 -0400", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "EE1F5DE30C303F3D28461F50B1CD8998")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.421 -0400", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "FF7B938D8B551DFA519348BF50A383E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.423 -0400", hash_original_method = "46B444F22731C330EF8C5DDD6085B819", hash_generated_method = "E31A3CF9488D9F3BE88666998D0CBC21")
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
                    boolean var8EE8AC9535910453B171626ECFBE2970_1667048900 = (curItem.getGroupId() == group);
                    {
                        {
                            boolean var7E3666046252DE45A97E32C83CBBDAF4_271046721 = (!curItem.isExclusiveCheckable());
                        } //End collapsed parenthetic
                        {
                            boolean var8CDB89E4B55B2B7E8661481E53525A9E_161469701 = (!curItem.isCheckable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.441 -0400", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "F9F45059BAD52CBBF68DB7A2698F458A")
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
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1644236694 = (item.getGroupId() == group);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.442 -0400", hash_original_method = "4EDC76E82EDC17A472BC69BB1B6E7C6A", hash_generated_method = "2F5598FB3167AC97C111C698C35236A3")
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
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_380418169 = (item.getGroupId() == group);
                    {
                        {
                            boolean var4DB4446F3346E01932ADAD4B5683F498_901772507 = (item.setVisibleInt(visible));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.443 -0400", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "922CD0E5CC2992FA69934683FCD07CFA")
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
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1429314393 = (item.getGroupId() == group);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.443 -0400", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "EE8C75518B28AA92F4C0FFFF2B626E16")
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
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_1825703525 = (item.isVisible());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961896647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_961896647;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.460 -0400", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "871BB0F961A21F41E8BE204783D58F4C")
    public MenuItem findItem(int id) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_566407098 = null; //Variable for return #1
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1423668239 = null; //Variable for return #2
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_884526526 = null; //Variable for return #3
        int size;
        size = size();
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_686293795 = (item.getItemId() == id);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_566407098 = item;
                    } //End block
                    {
                        boolean var2A76345EF62F0728C298DB442BA98AFC_328675321 = (item.hasSubMenu());
                        {
                            MenuItem possibleItem;
                            possibleItem = item.getSubMenu().findItem(id);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1423668239 = possibleItem;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_884526526 = null;
        addTaint(id);
        MenuItem varA7E53CE21691AB073D9660D615818899_1968949248; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1968949248 = varB4EAC82CA7396A68D541C85D26508E83_566407098;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1968949248 = varB4EAC82CA7396A68D541C85D26508E83_1423668239;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1968949248 = varB4EAC82CA7396A68D541C85D26508E83_884526526;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1968949248.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1968949248;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.461 -0400", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "9DA5707EF3F8F6A22921A0E014E977E1")
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
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_609224813 = (item.getItemId() == id);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616458843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616458843;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.461 -0400", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "0A4C96728F5CBD6AB3957E8A2F7BE44E")
    public int findGroupIndex(int group) {
        int varF2F0AE9233F1B982D371F99153BF98DC_1169618005 = (findGroupIndex(group, 0));
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741802140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741802140;
        // ---------- Original Method ----------
        //return findGroupIndex(group, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.462 -0400", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "248DA8D2893097747E1B9EA52216520C")
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
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_113822465 = (item.getGroupId() == group);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(group);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537941358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537941358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.462 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "00F7F858C6CB31763C84E106DAFA8984")
    public int size() {
        int var903E593E570CF8A7196E435EA30221CF_700756405 = (mItems.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859137560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859137560;
        // ---------- Original Method ----------
        //return mItems.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.462 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "04D4338D12EBBD2CA453375FE9478277")
    public MenuItem getItem(int index) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1916355633 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1916355633 = mItems.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1916355633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1916355633;
        // ---------- Original Method ----------
        //return mItems.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.462 -0400", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "00E1D3D25EEA03BFDC095EF753F806CA")
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        boolean var83E816433D6C5D634DA5F2A1F1927716_623435990 = (findItemWithShortcutForKey(keyCode, event) != null);
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1760236548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1760236548;
        // ---------- Original Method ----------
        //return findItemWithShortcutForKey(keyCode, event) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.463 -0400", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "4EF925579ED2A5FE24BA9D877FE5657E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.463 -0400", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "D87ED285609E347E4FAFA111872522CC")
     boolean isQwertyMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291276939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291276939;
        // ---------- Original Method ----------
        //return mQwertyMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.463 -0400", hash_original_method = "5CCA4A69E642C22AB6858AA5EF093CEB", hash_generated_method = "46BD00A9D878E1A6DC21A4E21F8540AD")
    public void setShortcutsVisible(boolean shortcutsVisible) {
        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
        addTaint(shortcutsVisible);
        // ---------- Original Method ----------
        //if (mShortcutsVisible == shortcutsVisible) return;
        //setShortcutsVisibleInner(shortcutsVisible);
        //onItemsChanged(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.466 -0400", hash_original_method = "BCC95ACBA680BEE1F3E7AD661CBC9615", hash_generated_method = "5F1306E253C0176589E31B06AFE8A16B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.467 -0400", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "A72E30B31AF31D1E1D22F90E33C42480")
    public boolean isShortcutsVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679749063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679749063;
        // ---------- Original Method ----------
        //return mShortcutsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.467 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "936C38C22DBFC5B8A005811EF6F221F3")
     Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_530072299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530072299 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_530072299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530072299;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.476 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "119B4DA74B1BC4F516185FD9EB64495C")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_514545342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_514545342 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_514545342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514545342;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.477 -0400", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "4B41F23501886C02DB6B18708B821683")
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        boolean var4651BA2AB2CDEB5FBB4C6B09193CF147_320426715 = (mCallback != null && mCallback.onMenuItemSelected(menu, item));
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303173743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303173743;
        // ---------- Original Method ----------
        //return mCallback != null && mCallback.onMenuItemSelected(menu, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.477 -0400", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "FDB098940DBBCEA38E17715D59A20179")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.478 -0400", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "A5DF4173555CE9A56E0B20DB32DB0BBD")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147695912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147695912;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.495 -0400", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "58F6F2F0DF2D4C4F4291AD771809D31F")
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
                    boolean varABB06CC79DFE43B426156FAD8042633B_672596533 = (item.hasSubMenu());
                    {
                        ((MenuBuilder)item.getSubMenu()).findItemsWithShortcutForKey(items, keyCode, event);
                    } //End block
                } //End collapsed parenthetic
                char shortcutChar;
                shortcutChar = item.getAlphabeticShortcut();
                shortcutChar = item.getNumericShortcut();
                {
                    boolean var4B1C4B88C00B83DF48844FF91D97425B_1307206486 = (((metaState & (KeyEvent.META_SHIFT_ON | KeyEvent.META_SYM_ON)) == 0) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.496 -0400", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "2C412ED8BA49DB18B63F84613E648D0E")
     MenuItemImpl findItemWithShortcutForKey(int keyCode, KeyEvent event) {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_2135042622 = null; //Variable for return #1
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1208963823 = null; //Variable for return #2
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1706546482 = null; //Variable for return #3
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_138388178 = null; //Variable for return #4
        ArrayList<MenuItemImpl> items;
        items = mTempShortcutItemList;
        items.clear();
        findItemsWithShortcutForKey(items, keyCode, event);
        {
            boolean varDC7DD6E6607E60D056C701649F2FCC72_1277633513 = (items.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2135042622 = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_1208963823 = items.get(0);
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
                    varB4EAC82CA7396A68D541C85D26508E83_1706546482 = item;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_138388178 = null;
        addTaint(keyCode);
        addTaint(event.getTaint());
        MenuItemImpl varA7E53CE21691AB073D9660D615818899_1914653800; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1914653800 = varB4EAC82CA7396A68D541C85D26508E83_2135042622;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1914653800 = varB4EAC82CA7396A68D541C85D26508E83_1208963823;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1914653800 = varB4EAC82CA7396A68D541C85D26508E83_1706546482;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1914653800 = varB4EAC82CA7396A68D541C85D26508E83_138388178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1914653800.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1914653800;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.496 -0400", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "5F564257CEFC18E9A87682116C42BF0B")
    public boolean performIdentifierAction(int id, int flags) {
        boolean varC0CA7E336E0E2B8E0733C1AA972420EC_535741682 = (performItemAction(findItem(id), flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757269496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757269496;
        // ---------- Original Method ----------
        //return performItemAction(findItem(id), flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.497 -0400", hash_original_method = "35FE8CE6C993B07CD0CB9DB44F8CBE25", hash_generated_method = "53138628F84B50877521EB927E9A9EE3")
    public boolean performItemAction(MenuItem item, int flags) {
        MenuItemImpl itemImpl;
        itemImpl = (MenuItemImpl) item;
        {
            boolean var4046EFD8ABBFFA045BEA239ADDC2688E_117824385 = (itemImpl == null || !itemImpl.isEnabled());
        } //End collapsed parenthetic
        boolean invoked;
        invoked = itemImpl.invoke();
        {
            boolean varB2A71AC4CF06459A52AAFC8C1B2AA2A9_984712848 = (itemImpl.hasCollapsibleActionView());
            {
                invoked |= itemImpl.expandActionView();
                close(true);
            } //End block
            {
                boolean var5D978436017CCBE177EE4E51CAD278B4_1149504522 = (item.hasSubMenu());
                {
                    close(false);
                    SubMenuBuilder subMenu;
                    subMenu = (SubMenuBuilder) item.getSubMenu();
                    ActionProvider provider;
                    provider = item.getActionProvider();
                    {
                        boolean var2102918082958942CF9C792E151F0C24_117246056 = (provider != null && provider.hasSubMenu());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940769509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940769509;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.558 -0400", hash_original_method = "95071F981B5536F482A785105041F83F", hash_generated_method = "693E8F0A0DAF5B10FB804091A9654FCE")
    final void close(boolean allMenusAreClosing) {
        mIsClosing = true;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1801526960 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1801526960.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1801526960.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.559 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        // ---------- Original Method ----------
        //close(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.560 -0400", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "1166675B6D8C3C88D7696455EBDC7C04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.560 -0400", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "9C920614B8D86D336BB2A3CBA43EF20D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.640 -0400", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "7BDF5DE5A18E4A87DFF9992D7EFE1939")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.640 -0400", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "33982F2357D1AF78560384DB30B2D092")
     void onItemVisibleChanged(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //mIsVisibleItemsStale = true;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.640 -0400", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "3086273B28105BE1A09378D2580E2297")
     void onItemActionRequestChanged(MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mIsActionItemsStale = true;
        onItemsChanged(true);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //mIsActionItemsStale = true;
        //onItemsChanged(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.641 -0400", hash_original_method = "66450A6B071A6D6254ADE6AFA4286392", hash_generated_method = "AAA0202AF67E2975E325F178E2CAEC78")
     ArrayList<MenuItemImpl> getVisibleItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1083543468 = null; //Variable for return #1
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1205292082 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1083543468 = mVisibleItems;
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
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_4207191 = (item.isVisible());
                    mVisibleItems.add(item);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
        varB4EAC82CA7396A68D541C85D26508E83_1205292082 = mVisibleItems;
        ArrayList<MenuItemImpl> varA7E53CE21691AB073D9660D615818899_1105588267; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1105588267 = varB4EAC82CA7396A68D541C85D26508E83_1083543468;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1105588267 = varB4EAC82CA7396A68D541C85D26508E83_1205292082;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1105588267.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1105588267;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.749 -0400", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "C8D9E6E944C7192C32B9265FC3625FEB")
    public void flagActionItems() {
        boolean flagged;
        flagged = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1703688155 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1703688155.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1703688155.next();
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
                        boolean var8C7900E5A6181E1C7522686688712CC9_718085212 = (item.isActionButton());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.750 -0400", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "439FF5838EB2435C339A855A8B468537")
     ArrayList<MenuItemImpl> getActionItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_2018738510 = null; //Variable for return #1
        flagActionItems();
        varB4EAC82CA7396A68D541C85D26508E83_2018738510 = mActionItems;
        varB4EAC82CA7396A68D541C85D26508E83_2018738510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2018738510;
        // ---------- Original Method ----------
        //flagActionItems();
        //return mActionItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.750 -0400", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "2DAD9D617680FFB030A1BDB165E1572E")
     ArrayList<MenuItemImpl> getNonActionItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_615520285 = null; //Variable for return #1
        flagActionItems();
        varB4EAC82CA7396A68D541C85D26508E83_615520285 = mNonActionItems;
        varB4EAC82CA7396A68D541C85D26508E83_615520285.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_615520285;
        // ---------- Original Method ----------
        //flagActionItems();
        //return mNonActionItems;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.758 -0400", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "5040574501D06F18CD7ADF0F855D53F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.760 -0400", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "C5D8E0A87809B5CAA00033D322BFBEFB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.761 -0400", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "F0C575634C392B5BBEFFD6871E2DF8A5")
    protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1566126137 = null; //Variable for return #1
        setHeaderInternal(0, title, 0, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_1566126137 = this;
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1566126137.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566126137;
        // ---------- Original Method ----------
        //setHeaderInternal(0, title, 0, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.761 -0400", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "0C82F62355A6BD631A959FE3E200A2A4")
    protected MenuBuilder setHeaderTitleInt(int titleRes) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_777450442 = null; //Variable for return #1
        setHeaderInternal(titleRes, null, 0, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_777450442 = this;
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_777450442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_777450442;
        // ---------- Original Method ----------
        //setHeaderInternal(titleRes, null, 0, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.769 -0400", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "EA867239F78618B2B515D199BB2EB329")
    protected MenuBuilder setHeaderIconInt(Drawable icon) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_289925169 = null; //Variable for return #1
        setHeaderInternal(0, null, 0, icon, null);
        varB4EAC82CA7396A68D541C85D26508E83_289925169 = this;
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_289925169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289925169;
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, 0, icon, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.769 -0400", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "F4F49F9679B9E126F035D0206A6EEDA4")
    protected MenuBuilder setHeaderIconInt(int iconRes) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_592708963 = null; //Variable for return #1
        setHeaderInternal(0, null, iconRes, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_592708963 = this;
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_592708963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592708963;
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, iconRes, null, null);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.770 -0400", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "6DD85A2F364D063745844BF01AA23F8D")
    protected MenuBuilder setHeaderViewInt(View view) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1952393573 = null; //Variable for return #1
        setHeaderInternal(0, null, 0, null, view);
        varB4EAC82CA7396A68D541C85D26508E83_1952393573 = this;
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1952393573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1952393573;
        // ---------- Original Method ----------
        //setHeaderInternal(0, null, 0, null, view);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.776 -0400", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "DDA5B47F1D97EF0DD74054C923626283")
    public CharSequence getHeaderTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_860345065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_860345065 = mHeaderTitle;
        varB4EAC82CA7396A68D541C85D26508E83_860345065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_860345065;
        // ---------- Original Method ----------
        //return mHeaderTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.777 -0400", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "9964A3E989B8F2CC837D801D9C73B6D7")
    public Drawable getHeaderIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2144802260 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2144802260 = mHeaderIcon;
        varB4EAC82CA7396A68D541C85D26508E83_2144802260.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2144802260;
        // ---------- Original Method ----------
        //return mHeaderIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.781 -0400", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "536EEB4B1BD22C1EEDBA93DB2AE23DFD")
    public View getHeaderView() {
        View varB4EAC82CA7396A68D541C85D26508E83_944088282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_944088282 = mHeaderView;
        varB4EAC82CA7396A68D541C85D26508E83_944088282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_944088282;
        // ---------- Original Method ----------
        //return mHeaderView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.782 -0400", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "1E10C03F78D17963A80060E70BD8BFED")
    public MenuBuilder getRootMenu() {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_259970335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_259970335 = this;
        varB4EAC82CA7396A68D541C85D26508E83_259970335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_259970335;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.782 -0400", hash_original_method = "8B5C0DAA8A7CB0B223A94346B39E6366", hash_generated_method = "44FD6FA0FC67E1F797EECB25B51E33BF")
    public void setCurrentMenuInfo(ContextMenuInfo menuInfo) {
        mCurrentMenuInfo = menuInfo;
        // ---------- Original Method ----------
        //mCurrentMenuInfo = menuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.782 -0400", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "E45EEED5BD943ACCCE728FF6AF008161")
     void setOptionalIconsVisible(boolean visible) {
        mOptionalIconsVisible = visible;
        // ---------- Original Method ----------
        //mOptionalIconsVisible = visible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.783 -0400", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "99A6A7AC8C7EB7712D375FD1C8A8729E")
     boolean getOptionalIconsVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254060185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254060185;
        // ---------- Original Method ----------
        //return mOptionalIconsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.852 -0400", hash_original_method = "EE8D5D3489A1A55A6EA94D4BFD84A637", hash_generated_method = "AF76A7893CB48E5711CAE04F0CC18F35")
    public boolean expandItemActionView(MenuItemImpl item) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_186894706 = (mPresenters.isEmpty());
        } //End collapsed parenthetic
        boolean expanded;
        expanded = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1907489027 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1907489027.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1907489027.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    boolean varBD9D44B19AD05CF02357248B9F10B593_1592308134 = ((expanded = presenter.expandItemActionView(this, item)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        {
            mExpandedItem = item;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803098653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803098653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.940 -0400", hash_original_method = "06F25D2FDACA8E4F633278E442B2C78B", hash_generated_method = "26D18067CAF9E2FBE5DF166C5D284221")
    public boolean collapseItemActionView(MenuItemImpl item) {
        {
            boolean var4FBADF22E53236C3688D67048889C135_1131175092 = (mPresenters.isEmpty() || mExpandedItem != item);
        } //End collapsed parenthetic
        boolean collapsed;
        collapsed = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_107690690 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_107690690.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_107690690.next();
            {
                MenuPresenter presenter;
                presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } //End block
                {
                    boolean varE23C44F770E395CB54AA09B45593018D_1243044120 = ((collapsed = presenter.collapseItemActionView(this, item)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        startDispatchingItemsChanged();
        {
            mExpandedItem = null;
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590302474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590302474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.941 -0400", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "0FFACE251C53776808C1E61A23F22710")
    public MenuItemImpl getExpandedItem() {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1314334556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1314334556 = mExpandedItem;
        varB4EAC82CA7396A68D541C85D26508E83_1314334556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1314334556;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.941 -0400", hash_original_field = "BB6CD346D213200830556CD1DC16291F", hash_generated_field = "1125ADEBFEC174C894F1A8A085279424")

    private static String TAG = "MenuBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.941 -0400", hash_original_field = "B1647BCC76A3DEF9EA1440031CF86BB7", hash_generated_field = "56B86460F10C1920390B189F45BF42CF")

    private static String PRESENTER_KEY = "android:menu:presenters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.941 -0400", hash_original_field = "F6032A2BB65ECFD85343DA439A98DAFE", hash_generated_field = "1264C5214F80D901B1D728BA45B6DF45")

    private static String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.941 -0400", hash_original_field = "86D3690E30D6D0F2F4756FB1BF14DA51", hash_generated_field = "57697A209F0C3A92B476B4FAC4085AF6")

    private static String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.941 -0400", hash_original_field = "CB8E4B88C807FCCC22D973064080953E", hash_generated_field = "CFE51F782288D26701634F3589713DDA")

    private static int[] sCategoryToOrder = new int[] {
        1, 
        4, 
        5, 
        3, 
        2, 
        0, 
    };
}

