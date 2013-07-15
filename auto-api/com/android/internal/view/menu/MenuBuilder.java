package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "7A5D05E188FBFEFD2A6CD8C4F3BE55EF", hash_generated_field = "95645DEF322B7192EFD2A867453899EE")

    private boolean mQwertyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "30F8E95083FD70AE11D91E338148BC3B", hash_generated_field = "F96F6064EBE78C516E4D1B26D5D6F308")

    private boolean mShortcutsVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "BD34AA609B2F1444C5802546CAFD9E2E")

    private ArrayList<MenuItemImpl> mItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "A3FBDEDF325DB017B2A028D8843D3A09", hash_generated_field = "D9641413264F8197F037C6D0C97110BC")

    private ArrayList<MenuItemImpl> mVisibleItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "C67DC7FD766EB504ADF36E9A3CE0C111", hash_generated_field = "542DEB4B44629FB64BB72A2F9FFA719F")

    private boolean mIsVisibleItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "7D1513D823124F3D32B4FC834B5B8CB8", hash_generated_field = "922EA5B66BFB13CAC326F75845DC9FBF")

    private ArrayList<MenuItemImpl> mActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "E0A10BB2538038AA25598A6124DCADDA", hash_generated_field = "4FA8D7123D10D7FB60C3300B4743B5E4")

    private ArrayList<MenuItemImpl> mNonActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "18F6104DD929A80984779A51B33529C5", hash_generated_field = "4672D8DE4A1D2EDA6E7A30F19E847512")

    private boolean mIsActionItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "38B00EB3AE2F97D7D4C3A7D6702A29C9", hash_generated_field = "99953610D3798A1652245FC37A11148F")

    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "F0F73BE0CFC128F21644E09022BFDB5F", hash_generated_field = "F71D241D22C847CB73D168C1498D3662")

    private ContextMenuInfo mCurrentMenuInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "C1CCD656768F0F81BE2BB78E3AA63E1D", hash_generated_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566")

    CharSequence mHeaderTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "23E59940389E4E411553D10969622DA9", hash_generated_field = "1F64D0B7244E48B7E3E328CABEC4A309")

    Drawable mHeaderIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "9AD5F9977C84732F8447E1A8FA73384D", hash_generated_field = "B9C114F754E53BD7622DBFFDE976E899")

    View mHeaderView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.290 -0400", hash_original_field = "13C697CF832FB88504F822C5877322BE", hash_generated_field = "C1392DA651B1F71540302368BB665E1C")

    private SparseArray<Parcelable> mFrozenViewStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "F2D7884C9E09EDA0D21EDDA033D4CA5F", hash_generated_field = "42D2AC432A6B8C4EEEB5401ED2AFDB89")

    private boolean mPreventDispatchingItemsChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "1CF0B2A4175BDCEB5A15E99C5927876A", hash_generated_field = "2CD250962FDCC7A99FD4076F077F63F8")

    private boolean mItemsChangedWhileDispatchPrevented = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "E37DE1D7A2E8152AA3413A383EAA7C8D", hash_generated_field = "726E83C5EC3729E7BB3D264007C90B65")

    private boolean mOptionalIconsVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "D0F023C09A6729446D2A2C606F365FCB", hash_generated_field = "BCD7139A79D8D9F3133E20DC6D3F207A")

    private boolean mIsClosing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "CB08465A8B1AD1C8F82C6BD49F6A5824", hash_generated_field = "42C64CF6E53F14390A86902028B317E2")

    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "F05E7F7EED7161EAC2E8B160F25C396A", hash_generated_field = "AFD9B193D2ECD6C8B664F5067DC23F76")

    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_field = "FC1533ACA08DCD52B7AC7DADED834BA2", hash_generated_field = "E6D19EE97CF34609C2DF041F94F84AE4")

    private MenuItemImpl mExpandedItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.291 -0400", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "C1D57B83660DAEFC2F4CD6A8D35E9B2C")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.292 -0400", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "9F214C0DDFD1CAB5F5B13510B86BC249")
    public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_107679363 = null; 
        mDefaultShowAsAction = defaultShowAsAction;
        varB4EAC82CA7396A68D541C85D26508E83_107679363 = this;
        varB4EAC82CA7396A68D541C85D26508E83_107679363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_107679363;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.292 -0400", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "322E6294CFFE4A944F88ECCC0D937BCB")
    public void addMenuPresenter(MenuPresenter presenter) {
        mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        presenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
        addTaint(presenter.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.296 -0400", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "50C0658BF9060A53ABF3678778314DEF")
    public void removeMenuPresenter(MenuPresenter presenter) {
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_551964352 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_551964352.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_551964352.next();
            {
                final MenuPresenter item = ref.get();
                {
                    mPresenters.remove(ref);
                } 
            } 
        } 
        addTaint(presenter.getTaint());
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.299 -0400", hash_original_method = "54D4EF8A00AA3736A7301B3768CF2956", hash_generated_method = "025DCC825CA73C20B78C618197455E42")
    private void dispatchPresenterUpdate(boolean cleared) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_661528731 = (mPresenters.isEmpty());
        } 
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1512722229 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1512722229.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1512722229.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    presenter.updateMenuView(cleared);
                } 
            } 
        } 
        startDispatchingItemsChanged();
        addTaint(cleared);
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.302 -0400", hash_original_method = "972C883CEABE6EAECC969B119D377700", hash_generated_method = "489F546091AF6819A2B2922599D84610")
    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_1642222390 = (mPresenters.isEmpty());
        } 
        boolean result = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1261969069 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1261969069.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1261969069.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    result = presenter.onSubMenuSelected(subMenu);
                } 
            } 
        } 
        addTaint(subMenu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346028490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_346028490;
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.307 -0400", hash_original_method = "8458F949934B8A3332FB7D785BD3E421", hash_generated_method = "185F0B16D82D59B40109E6F665A334D9")
    private void dispatchSaveInstanceState(Bundle outState) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_659297937 = (mPresenters.isEmpty());
        } 
        SparseArray<Parcelable> presenterStates = new SparseArray<Parcelable>();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1995495137 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1995495137.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1995495137.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    final int id = presenter.getId();
                    {
                        final Parcelable state = presenter.onSaveInstanceState();
                        {
                            presenterStates.put(id, state);
                        } 
                    } 
                } 
            } 
        } 
        outState.putSparseParcelableArray(PRESENTER_KEY, presenterStates);
        addTaint(outState.getTaint());
        
        
        
        
            
            
                
            
                
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.312 -0400", hash_original_method = "4E7750A20EC8141646D41AE332CEFE6A", hash_generated_method = "B75C780CC62D7FD93B878C3A61047E7F")
    private void dispatchRestoreInstanceState(Bundle state) {
        SparseArray<Parcelable> presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);
        {
            boolean var978B5CD1AF436AE76C6FB0F45B00B46D_1373774037 = (presenterStates == null || mPresenters.isEmpty());
        } 
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_561513009 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_561513009.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_561513009.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    final int id = presenter.getId();
                    {
                        Parcelable parcel = presenterStates.get(id);
                        {
                            presenter.onRestoreInstanceState(parcel);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(state.getTaint());
        
        
        
        
            
            
                
            
                
                
                    
                    
                        
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.312 -0400", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "6EDC0C0B67D1FCB9B378B7774F277AE0")
    public void savePresenterStates(Bundle outState) {
        dispatchSaveInstanceState(outState);
        addTaint(outState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.313 -0400", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "1512E4DB524A6EAEFFA3F5E20287517E")
    public void restorePresenterStates(Bundle state) {
        dispatchRestoreInstanceState(state);
        addTaint(state.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.313 -0400", hash_original_method = "A8F0361C85125DA8A38A18412990521E", hash_generated_method = "3F46AA6CEA0CFC43DD46806DF6EAD955")
    public void saveActionViewStates(Bundle outStates) {
        SparseArray<Parcelable> viewStates = null;
        final int itemCount = size();
        {
            int i = 0;
            {
                final MenuItem item = getItem(i);
                final View v = item.getActionView();
                {
                    boolean var094D712B8F5F2BE1027DB368EC41F641_550014465 = (v != null && v.getId() != View.NO_ID);
                    {
                        {
                            viewStates = new SparseArray<Parcelable>();
                        } 
                        v.saveHierarchyState(viewStates);
                        {
                            boolean varD2DC871025EA5DE67B1C85EF2817DBBE_1818766084 = (item.isActionViewExpanded());
                            {
                                outStates.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                            } 
                        } 
                    } 
                } 
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_1948640648 = (item.hasSubMenu());
                    {
                        final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                        subMenu.saveActionViewStates(outStates);
                    } 
                } 
            } 
        } 
        {
            outStates.putSparseParcelableArray(getActionViewStatesKey(), viewStates);
        } 
        addTaint(outStates.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.314 -0400", hash_original_method = "B3A4CB3CCE0DD38C30DBEC80F125B14F", hash_generated_method = "AAF7C3EA36CF7BE5A76E1AA836905E5E")
    public void restoreActionViewStates(Bundle states) {
        SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(
                getActionViewStatesKey());
        final int itemCount = size();
        {
            int i = 0;
            {
                final MenuItem item = getItem(i);
                final View v = item.getActionView();
                {
                    boolean var094D712B8F5F2BE1027DB368EC41F641_823519862 = (v != null && v.getId() != View.NO_ID);
                    {
                        v.restoreHierarchyState(viewStates);
                    } 
                } 
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_953226065 = (item.hasSubMenu());
                    {
                        final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                        subMenu.restoreActionViewStates(states);
                    } 
                } 
            } 
        } 
        final int expandedId = states.getInt(EXPANDED_ACTION_VIEW_ID);
        {
            MenuItem itemToExpand = findItem(expandedId);
            {
                itemToExpand.expandActionView();
            } 
        } 
        addTaint(states.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.315 -0400", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "8C7409FD5A3B28AEF529D793490818C3")
    protected String getActionViewStatesKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1716548442 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1716548442 = ACTION_VIEW_STATES_KEY;
        varB4EAC82CA7396A68D541C85D26508E83_1716548442.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1716548442;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.315 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.316 -0400", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "3E4F614E1154D2E428B4221EB5D05FD7")
    private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1920156721 = null; 
        final int ordering = getOrdering(categoryOrder);
        final MenuItemImpl item = new MenuItemImpl(this, group, id, categoryOrder,
                ordering, title, mDefaultShowAsAction);
        {
            item.setMenuInfo(mCurrentMenuInfo);
        } 
        mItems.add(findInsertIndex(mItems, ordering), item);
        onItemsChanged(true);
        varB4EAC82CA7396A68D541C85D26508E83_1920156721 = item;
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1920156721.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1920156721;
        
        
        
                
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.317 -0400", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "0B9003D2677CC324BB0F73D6C1A97C33")
    public MenuItem add(CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_327582381 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_327582381 = addInternal(0, 0, 0, title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_327582381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_327582381;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.318 -0400", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "004D8A8F0B7F1BE51EE5B2CDC1CFB617")
    public MenuItem add(int titleRes) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_500537132 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_500537132 = addInternal(0, 0, 0, mResources.getString(titleRes));
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_500537132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_500537132;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.319 -0400", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "841D31D9922A8CFA89D9B5141CE1FB87")
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_2067083345 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2067083345 = addInternal(group, id, categoryOrder, title);
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2067083345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2067083345;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.320 -0400", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "78C040C82597DA394D97D73057AC2210")
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_873433495 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_873433495 = addInternal(group, id, categoryOrder, mResources.getString(title));
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_873433495.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_873433495;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.320 -0400", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "F9F06EEFBB17462E9060681102058CA4")
    public SubMenu addSubMenu(CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1855174926 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1855174926 = addSubMenu(0, 0, 0, title);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1855174926.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1855174926;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.321 -0400", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "760CB74B9256AEC8B61D0F0A281596EF")
    public SubMenu addSubMenu(int titleRes) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1313853800 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1313853800 = addSubMenu(0, 0, 0, mResources.getString(titleRes));
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_1313853800.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1313853800;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.321 -0400", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "EDA586B4C3F754B703BFAFD93C98586F")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1502023991 = null; 
        final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);
        varB4EAC82CA7396A68D541C85D26508E83_1502023991 = subMenu;
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1502023991.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1502023991;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.322 -0400", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "3402E53A6261D458F048C9F0034BFA37")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        SubMenu varB4EAC82CA7396A68D541C85D26508E83_1799224866 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1799224866 = addSubMenu(group, id, categoryOrder, mResources.getString(title));
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(title);
        varB4EAC82CA7396A68D541C85D26508E83_1799224866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1799224866;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.322 -0400", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "F3224FE4F5CDAE3EC8CA4819ED1C8786")
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri = pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        int N;
        N = lri.size();
        N = 0;
        {
            removeGroup(group);
        } 
        {
            int i = 0;
            {
                final ResolveInfo ri = lri.get(i);
                Intent rintent = new Intent(
                ri.specificIndex < 0 ? intent : specifics[ri.specificIndex]);
                rintent.setComponent(new ComponentName(
                    ri.activityInfo.applicationInfo.packageName,
                    ri.activityInfo.name));
                final MenuItem item = add(group, id, categoryOrder, ri.loadLabel(pm))
                    .setIcon(ri.loadIcon(pm))
                    .setIntent(rintent);
                {
                    outSpecificItems[ri.specificIndex] = item;
                } 
            } 
        } 
        addTaint(group);
        addTaint(id);
        addTaint(categoryOrder);
        addTaint(caller.getTaint());
        addTaint(specifics[0].getTaint());
        addTaint(intent.getTaint());
        addTaint(flags);
        addTaint(outSpecificItems[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489239926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489239926;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.323 -0400", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "FBDE2F1A6AE885630DD91F19E98167B9")
    public void removeItem(int id) {
        removeItemAtInt(findItemIndex(id), true);
        addTaint(id);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.324 -0400", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "38124533399C94BD0C4927A6CF189016")
    public void removeGroup(int group) {
        final int i = findGroupIndex(group);
        {
            final int maxRemovable = mItems.size() - i;
            int numRemoved = 0;
            {
                boolean varB635114C3F531E77FD0C631F7E17EB16_486917413 = ((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group));
                {
                    removeItemAtInt(i, false);
                } 
            } 
            onItemsChanged(true);
        } 
        addTaint(group);
        
        
        
            
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.325 -0400", hash_original_method = "B04372368F85324A2D15939652770F19", hash_generated_method = "127E19BE736F7E15EF8390722BD1ADE6")
    private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        {
            boolean var338D9D416353CE7F8A425352D2B29717_186964366 = ((index < 0) || (index >= mItems.size()));
        } 
        mItems.remove(index);
        onItemsChanged(true);
        addTaint(index);
        addTaint(updateChildrenOnMenuViews);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.325 -0400", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "516CE6CEA2C84AA7026941E518891C48")
    public void removeItemAt(int index) {
        removeItemAtInt(index, true);
        addTaint(index);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.326 -0400", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "EE1F5DE30C303F3D28461F50B1CD8998")
    public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.327 -0400", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "FF7B938D8B551DFA519348BF50A383E2")
    public void clear() {
        {
            collapseItemActionView(mExpandedItem);
        } 
        mItems.clear();
        onItemsChanged(true);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.329 -0400", hash_original_method = "46B444F22731C330EF8C5DDD6085B819", hash_generated_method = "5F4DCEDF5531944A8760011D4A7583EA")
     void setExclusiveItemChecked(MenuItem item) {
        final int group = item.getGroupId();
        final int N = mItems.size();
        {
            int i = 0;
            {
                MenuItemImpl curItem = mItems.get(i);
                {
                    boolean var8EE8AC9535910453B171626ECFBE2970_675931979 = (curItem.getGroupId() == group);
                    {
                        {
                            boolean var7E3666046252DE45A97E32C83CBBDAF4_1874576738 = (!curItem.isExclusiveCheckable());
                        } 
                        {
                            boolean var8CDB89E4B55B2B7E8661481E53525A9E_1558542916 = (!curItem.isCheckable());
                        } 
                        curItem.setCheckedInt(curItem == item);
                    } 
                } 
            } 
        } 
        addTaint(item.getTaint());
        
        
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.331 -0400", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "523AD21C5303EAB81C323E90ED90AAF5")
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        final int N = mItems.size();
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1512951534 = (item.getGroupId() == group);
                    {
                        item.setExclusiveCheckable(exclusive);
                        item.setCheckable(checkable);
                    } 
                } 
            } 
        } 
        addTaint(group);
        addTaint(checkable);
        addTaint(exclusive);
        
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.332 -0400", hash_original_method = "4EDC76E82EDC17A472BC69BB1B6E7C6A", hash_generated_method = "FBAD9E34FDE9443C5AD1E0E1839CC799")
    public void setGroupVisible(int group, boolean visible) {
        final int N = mItems.size();
        boolean changedAtLeastOneItem = false;
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_868461932 = (item.getGroupId() == group);
                    {
                        {
                            boolean var4DB4446F3346E01932ADAD4B5683F498_1796942471 = (item.setVisibleInt(visible));
                            changedAtLeastOneItem = true;
                        } 
                    } 
                } 
            } 
        } 
        onItemsChanged(true);
        addTaint(group);
        addTaint(visible);
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.332 -0400", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "97CF8D71805E6A884822E78E54F04F4E")
    public void setGroupEnabled(int group, boolean enabled) {
        final int N = mItems.size();
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1331585995 = (item.getGroupId() == group);
                    {
                        item.setEnabled(enabled);
                    } 
                } 
            } 
        } 
        addTaint(group);
        addTaint(enabled);
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.333 -0400", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "EEF7A24384CC56C09F20407F23809FB5")
    public boolean hasVisibleItems() {
        final int size = size();
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_1764711670 = (item.isVisible());
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_869815045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_869815045;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.334 -0400", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "8166B164606EABE51BD2E9793AA80AF4")
    public MenuItem findItem(int id) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1377172457 = null; 
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_796733880 = null; 
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_1370782502 = null; 
        final int size = size();
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_500721342 = (item.getItemId() == id);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1377172457 = item;
                    } 
                    {
                        boolean var2A76345EF62F0728C298DB442BA98AFC_519462951 = (item.hasSubMenu());
                        {
                            MenuItem possibleItem = item.getSubMenu().findItem(id);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_796733880 = possibleItem;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1370782502 = null;
        addTaint(id);
        MenuItem varA7E53CE21691AB073D9660D615818899_1532005496; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1532005496 = varB4EAC82CA7396A68D541C85D26508E83_1377172457;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1532005496 = varB4EAC82CA7396A68D541C85D26508E83_796733880;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1532005496 = varB4EAC82CA7396A68D541C85D26508E83_1370782502;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1532005496.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1532005496;
        
        
        
            
            
                
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.335 -0400", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "3CB61E772262107960E33CA6C13F011D")
    public int findItemIndex(int id) {
        final int size = size();
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean var8803F9788733AE69332B1E6E9B5CF0BC_82346017 = (item.getItemId() == id);
                } 
            } 
        } 
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060659342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060659342;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.335 -0400", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "2C5D385FA4E74F2B8F475EF1CBF30E0C")
    public int findGroupIndex(int group) {
        int varF2F0AE9233F1B982D371F99153BF98DC_279589827 = (findGroupIndex(group, 0));
        addTaint(group);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14461050 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14461050;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.336 -0400", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "28C0E87F714A9711039D17C7B21DF5F2")
    public int findGroupIndex(int group, int start) {
        final int size = size();
        {
            start = 0;
        } 
        {
            int i = start;
            {
                final MenuItemImpl item = mItems.get(i);
                {
                    boolean var60E55E09E9993EB5B4D188D37C1FF4C0_1661013751 = (item.getGroupId() == group);
                } 
            } 
        } 
        addTaint(group);
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349503973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349503973;
        
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.336 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "199AB35F4EC8DC703F8FA2DE35450738")
    public int size() {
        int var903E593E570CF8A7196E435EA30221CF_1377113550 = (mItems.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147811628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147811628;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.338 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "0D4BEF1ADA358BF51CFCD1FDB1ADA645")
    public MenuItem getItem(int index) {
        MenuItem varB4EAC82CA7396A68D541C85D26508E83_506952539 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_506952539 = mItems.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_506952539.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_506952539;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.338 -0400", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "297586C81A14D3D6EA327B0A6220E7A5")
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        boolean var83E816433D6C5D634DA5F2A1F1927716_108992156 = (findItemWithShortcutForKey(keyCode, event) != null);
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1724654717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1724654717;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.339 -0400", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "4EF925579ED2A5FE24BA9D877FE5657E")
    public void setQwertyMode(boolean isQwerty) {
        mQwertyMode = isQwerty;
        onItemsChanged(false);
        
        
        
    }

    
    private static int getOrdering(int categoryOrder) {
        final int index = (categoryOrder & CATEGORY_MASK) >> CATEGORY_SHIFT;
        if (index < 0 || index >= sCategoryToOrder.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (sCategoryToOrder[index] << CATEGORY_SHIFT) | (categoryOrder & USER_MASK);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.340 -0400", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "5B91221A3F764275F1150A0D78D509C2")
     boolean isQwertyMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948158918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_948158918;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.340 -0400", hash_original_method = "5CCA4A69E642C22AB6858AA5EF093CEB", hash_generated_method = "46BD00A9D878E1A6DC21A4E21F8540AD")
    public void setShortcutsVisible(boolean shortcutsVisible) {
        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
        addTaint(shortcutsVisible);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.340 -0400", hash_original_method = "BCC95ACBA680BEE1F3E7AD661CBC9615", hash_generated_method = "5F1306E253C0176589E31B06AFE8A16B")
    private void setShortcutsVisibleInner(boolean shortcutsVisible) {
        mShortcutsVisible = shortcutsVisible
                && mResources.getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS
                && mResources.getBoolean(
                        com.android.internal.R.bool.config_showMenuShortcutsWhenKeyboardPresent);
        
        
                
                
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.341 -0400", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "059BB93274116EC044D0B4DF9F0060B9")
    public boolean isShortcutsVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496485075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_496485075;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.341 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "B0362249D2C4AB8C5E366AC059D7D6E3")
     Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_383574173 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_383574173 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_383574173.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_383574173;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.342 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "A45DF9D39B25DAD4957BC171B1C22160")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1003459278 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1003459278 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1003459278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1003459278;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.342 -0400", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "33CE3A458604E4E2D70B42883CBB5498")
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        boolean var4651BA2AB2CDEB5FBB4C6B09193CF147_10865742 = (mCallback != null && mCallback.onMenuItemSelected(menu, item));
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091082523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091082523;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.343 -0400", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "FDB098940DBBCEA38E17715D59A20179")
    public void changeMenuMode() {
        {
            mCallback.onMenuModeChange(this);
        } 
        
        
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.343 -0400", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "75534E5368305028BBA5968F503DEC50")
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        final MenuItemImpl item = findItemWithShortcutForKey(keyCode, event);
        boolean handled = false;
        {
            handled = performItemAction(item, flags);
        } 
        {
            close(true);
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434123345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434123345;
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.344 -0400", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "039CA6DFD2F808A12193B906007B5AE9")
     void findItemsWithShortcutForKey(List<MenuItemImpl> items, int keyCode, KeyEvent event) {
        final boolean qwerty = isQwertyMode();
        final int metaState = event.getMetaState();
        final KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        final boolean isKeyCodeMapped = event.getKeyData(possibleChars);
        final int N = mItems.size();
        {
            int i = 0;
            {
                MenuItemImpl item = mItems.get(i);
                {
                    boolean varABB06CC79DFE43B426156FAD8042633B_433775717 = (item.hasSubMenu());
                    {
                        ((MenuBuilder)item.getSubMenu()).findItemsWithShortcutForKey(items, keyCode, event);
                    } 
                } 
                char shortcutChar;
                shortcutChar = item.getAlphabeticShortcut();
                shortcutChar = item.getNumericShortcut();
                {
                    boolean var4B1C4B88C00B83DF48844FF91D97425B_989120337 = (((metaState & (KeyEvent.META_SHIFT_ON | KeyEvent.META_SYM_ON)) == 0) &&
                  (shortcutChar != 0) &&
                  (shortcutChar == possibleChars.meta[0]
                      || shortcutChar == possibleChars.meta[2]
                      || (qwerty && shortcutChar == '\b' &&
                          keyCode == KeyEvent.KEYCODE_DEL)) &&
                  item.isEnabled());
                    {
                        items.add(item);
                    } 
                } 
            } 
        } 
        addTaint(items.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.346 -0400", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "A911319C2A94DEB9683413CA79CFF248")
     MenuItemImpl findItemWithShortcutForKey(int keyCode, KeyEvent event) {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1544654241 = null; 
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_883662 = null; 
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1428236279 = null; 
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_425721551 = null; 
        ArrayList<MenuItemImpl> items = mTempShortcutItemList;
        items.clear();
        findItemsWithShortcutForKey(items, keyCode, event);
        {
            boolean varDC7DD6E6607E60D056C701649F2FCC72_1883808532 = (items.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1544654241 = null;
            } 
        } 
        final int metaState = event.getMetaState();
        final KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        event.getKeyData(possibleChars);
        final int size = items.size();
        {
            varB4EAC82CA7396A68D541C85D26508E83_883662 = items.get(0);
        } 
        final boolean qwerty = isQwertyMode();
        {
            int i = 0;
            {
                final MenuItemImpl item = items.get(i);
                char shortcutChar;
                shortcutChar = item.getAlphabeticShortcut();
                shortcutChar = item.getNumericShortcut();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1428236279 = item;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_425721551 = null;
        addTaint(keyCode);
        addTaint(event.getTaint());
        MenuItemImpl varA7E53CE21691AB073D9660D615818899_500523331; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_500523331 = varB4EAC82CA7396A68D541C85D26508E83_1544654241;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_500523331 = varB4EAC82CA7396A68D541C85D26508E83_883662;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_500523331 = varB4EAC82CA7396A68D541C85D26508E83_1428236279;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_500523331 = varB4EAC82CA7396A68D541C85D26508E83_425721551;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_500523331.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_500523331;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.347 -0400", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "0292067E143E09C4EF9CD15AD2BC32B5")
    public boolean performIdentifierAction(int id, int flags) {
        boolean varC0CA7E336E0E2B8E0733C1AA972420EC_1134361626 = (performItemAction(findItem(id), flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363007370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363007370;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.348 -0400", hash_original_method = "35FE8CE6C993B07CD0CB9DB44F8CBE25", hash_generated_method = "7F9D98084AFB26B1BBDC0E8553E83B3A")
    public boolean performItemAction(MenuItem item, int flags) {
        MenuItemImpl itemImpl = (MenuItemImpl) item;
        {
            boolean var4046EFD8ABBFFA045BEA239ADDC2688E_115424074 = (itemImpl == null || !itemImpl.isEnabled());
        } 
        boolean invoked = itemImpl.invoke();
        {
            boolean varB2A71AC4CF06459A52AAFC8C1B2AA2A9_1266785549 = (itemImpl.hasCollapsibleActionView());
            {
                invoked |= itemImpl.expandActionView();
                close(true);
            } 
            {
                boolean var5D978436017CCBE177EE4E51CAD278B4_2060355565 = (item.hasSubMenu());
                {
                    close(false);
                    final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                    final ActionProvider provider = item.getActionProvider();
                    {
                        boolean var2102918082958942CF9C792E151F0C24_570586349 = (provider != null && provider.hasSubMenu());
                        {
                            provider.onPrepareSubMenu(subMenu);
                        } 
                    } 
                    invoked |= dispatchSubMenuSelected(subMenu);
                    close(true);
                } 
                {
                    {
                        close(true);
                    } 
                } 
            } 
        } 
        addTaint(item.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315260468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315260468;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.362 -0400", hash_original_method = "95071F981B5536F482A785105041F83F", hash_generated_method = "4B652357C53809868F4FB0B1B124F710")
    final void close(boolean allMenusAreClosing) {
        mIsClosing = true;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_2008813478 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_2008813478.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_2008813478.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    presenter.onCloseMenu(this, allMenusAreClosing);
                } 
            } 
        } 
        mIsClosing = false;
        addTaint(allMenusAreClosing);
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.362 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.363 -0400", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "1166675B6D8C3C88D7696455EBDC7C04")
     void onItemsChanged(boolean structureChanged) {
        
        {
            {
                mIsVisibleItemsStale = true;
                mIsActionItemsStale = true;
            } 
            dispatchPresenterUpdate(structureChanged);
        } 
        {
            mItemsChangedWhileDispatchPrevented = true;
        } 
        addTaint(structureChanged);
        
        
            
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.363 -0400", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "9C920614B8D86D336BB2A3CBA43EF20D")
    public void stopDispatchingItemsChanged() {
        {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.364 -0400", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "7BDF5DE5A18E4A87DFF9992D7EFE1939")
    public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;
        {
            mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.364 -0400", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "33982F2357D1AF78560384DB30B2D092")
     void onItemVisibleChanged(MenuItemImpl item) {
        
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
        addTaint(item.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.364 -0400", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "3086273B28105BE1A09378D2580E2297")
     void onItemActionRequestChanged(MenuItemImpl item) {
        
        mIsActionItemsStale = true;
        onItemsChanged(true);
        addTaint(item.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.365 -0400", hash_original_method = "66450A6B071A6D6254ADE6AFA4286392", hash_generated_method = "7300ED4E09B7EDF196DA353C4DEF60C8")
     ArrayList<MenuItemImpl> getVisibleItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1471134530 = null; 
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1634642245 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1471134530 = mVisibleItems;
        mVisibleItems.clear();
        final int itemsSize = mItems.size();
        MenuItemImpl item;
        {
            int i = 0;
            {
                item = mItems.get(i);
                {
                    boolean var70CFAC39E5CE5BE6471838F19CCC35B2_2110621197 = (item.isVisible());
                    mVisibleItems.add(item);
                } 
            } 
        } 
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
        varB4EAC82CA7396A68D541C85D26508E83_1634642245 = mVisibleItems;
        ArrayList<MenuItemImpl> varA7E53CE21691AB073D9660D615818899_990754789; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_990754789 = varB4EAC82CA7396A68D541C85D26508E83_1471134530;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_990754789 = varB4EAC82CA7396A68D541C85D26508E83_1634642245;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_990754789.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_990754789;
        
        
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.376 -0400", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "7402D08CB46174E9BA154D9169F6F2BE")
    public void flagActionItems() {
        boolean flagged = false;
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_883125855 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_883125855.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_883125855.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    flagged |= presenter.flagActionItems();
                } 
            } 
        } 
        {
            mActionItems.clear();
            mNonActionItems.clear();
            ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
            final int itemsSize = visibleItems.size();
            {
                int i = 0;
                {
                    MenuItemImpl item = visibleItems.get(i);
                    {
                        boolean var8C7900E5A6181E1C7522686688712CC9_640523405 = (item.isActionButton());
                        {
                            mActionItems.add(item);
                        } 
                        {
                            mNonActionItems.add(item);
                        } 
                    } 
                } 
            } 
        } 
        {
            mActionItems.clear();
            mNonActionItems.clear();
            mNonActionItems.addAll(getVisibleItems());
        } 
        mIsActionItemsStale = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.379 -0400", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "DEC8F1DCDEB1C7EEED5C2A52415062E3")
     ArrayList<MenuItemImpl> getActionItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1782590088 = null; 
        flagActionItems();
        varB4EAC82CA7396A68D541C85D26508E83_1782590088 = mActionItems;
        varB4EAC82CA7396A68D541C85D26508E83_1782590088.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1782590088;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.380 -0400", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "161B3F35FC5D8A7020BB5BC3AD131DEC")
     ArrayList<MenuItemImpl> getNonActionItems() {
        ArrayList<MenuItemImpl> varB4EAC82CA7396A68D541C85D26508E83_1457187699 = null; 
        flagActionItems();
        varB4EAC82CA7396A68D541C85D26508E83_1457187699 = mNonActionItems;
        varB4EAC82CA7396A68D541C85D26508E83_1457187699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1457187699;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.380 -0400", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "5040574501D06F18CD7ADF0F855D53F0")
    public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;
        onItemsChanged(false);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.381 -0400", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "08682BC1B3522BA593F501FCBCCA5ECA")
    private void setHeaderInternal(final int titleRes, final CharSequence title, final int iconRes,
            final Drawable icon, final View view) {
        final Resources r = getResources();
        {
            mHeaderView = view;
            mHeaderTitle = null;
            mHeaderIcon = null;
        } 
        {
            {
                mHeaderTitle = r.getText(titleRes);
            } 
            {
                mHeaderTitle = title;
            } 
            {
                mHeaderIcon = r.getDrawable(iconRes);
            } 
            {
                mHeaderIcon = icon;
            } 
            mHeaderView = null;
        } 
        onItemsChanged(false);
        
        
        
            
            
            
        
            
                
            
                
            
            
                
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.382 -0400", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "04D8C8B029B7C59A526C11D8A52A899C")
    protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_59741446 = null; 
        setHeaderInternal(0, title, 0, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_59741446 = this;
        addTaint(title.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_59741446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_59741446;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.383 -0400", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "4A590670F299F8CDD36D7FF096DA81D1")
    protected MenuBuilder setHeaderTitleInt(int titleRes) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1947714815 = null; 
        setHeaderInternal(titleRes, null, 0, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_1947714815 = this;
        addTaint(titleRes);
        varB4EAC82CA7396A68D541C85D26508E83_1947714815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1947714815;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.384 -0400", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "0B7C0B196F23FC2CBF6F3D75FA4602A8")
    protected MenuBuilder setHeaderIconInt(Drawable icon) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_143960260 = null; 
        setHeaderInternal(0, null, 0, icon, null);
        varB4EAC82CA7396A68D541C85D26508E83_143960260 = this;
        addTaint(icon.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_143960260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_143960260;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.385 -0400", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "BEB0E781D1C60EFE3E53C687D971D80B")
    protected MenuBuilder setHeaderIconInt(int iconRes) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1627696029 = null; 
        setHeaderInternal(0, null, iconRes, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_1627696029 = this;
        addTaint(iconRes);
        varB4EAC82CA7396A68D541C85D26508E83_1627696029.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1627696029;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.386 -0400", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "DEBCA1A94110C74F80828BC770260BC7")
    protected MenuBuilder setHeaderViewInt(View view) {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_1617458036 = null; 
        setHeaderInternal(0, null, 0, null, view);
        varB4EAC82CA7396A68D541C85D26508E83_1617458036 = this;
        addTaint(view.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1617458036.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1617458036;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.386 -0400", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "1F61B622340B4524C58CAF2002474D3C")
    public CharSequence getHeaderTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_946139323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_946139323 = mHeaderTitle;
        varB4EAC82CA7396A68D541C85D26508E83_946139323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_946139323;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.387 -0400", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "12EF779F8D4EFCE62418018D368D729D")
    public Drawable getHeaderIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_335475240 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_335475240 = mHeaderIcon;
        varB4EAC82CA7396A68D541C85D26508E83_335475240.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335475240;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.387 -0400", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "747DDD17035B80EDB7DF9CF50792D979")
    public View getHeaderView() {
        View varB4EAC82CA7396A68D541C85D26508E83_44494550 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_44494550 = mHeaderView;
        varB4EAC82CA7396A68D541C85D26508E83_44494550.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_44494550;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.388 -0400", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "14B2B9851DBABB80CDA0B699F3CA6BFF")
    public MenuBuilder getRootMenu() {
        MenuBuilder varB4EAC82CA7396A68D541C85D26508E83_530549906 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_530549906 = this;
        varB4EAC82CA7396A68D541C85D26508E83_530549906.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_530549906;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.388 -0400", hash_original_method = "8B5C0DAA8A7CB0B223A94346B39E6366", hash_generated_method = "44FD6FA0FC67E1F797EECB25B51E33BF")
    public void setCurrentMenuInfo(ContextMenuInfo menuInfo) {
        mCurrentMenuInfo = menuInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.388 -0400", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "E45EEED5BD943ACCCE728FF6AF008161")
     void setOptionalIconsVisible(boolean visible) {
        mOptionalIconsVisible = visible;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.388 -0400", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "62A7AB6436F17264AE0E4976E690C730")
     boolean getOptionalIconsVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390813029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390813029;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.395 -0400", hash_original_method = "EE8D5D3489A1A55A6EA94D4BFD84A637", hash_generated_method = "5B442A0C237E820EA02DC6989852CE79")
    public boolean expandItemActionView(MenuItemImpl item) {
        {
            boolean varB4818F7125D0746E7BA6EB04973614A6_597441949 = (mPresenters.isEmpty());
        } 
        boolean expanded = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_1664502146 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_1664502146.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_1664502146.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    boolean varBD9D44B19AD05CF02357248B9F10B593_182647859 = ((expanded = presenter.expandItemActionView(this, item)));
                } 
            } 
        } 
        startDispatchingItemsChanged();
        {
            mExpandedItem = item;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309863084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309863084;
        
        
        
        
        
            
            
                
            
                
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.407 -0400", hash_original_method = "06F25D2FDACA8E4F633278E442B2C78B", hash_generated_method = "DAEBF35BFCA32DA75038F15E14E2A42B")
    public boolean collapseItemActionView(MenuItemImpl item) {
        {
            boolean var4FBADF22E53236C3688D67048889C135_938849649 = (mPresenters.isEmpty() || mExpandedItem != item);
        } 
        boolean collapsed = false;
        stopDispatchingItemsChanged();
        {
            Iterator<WeakReference<MenuPresenter>> var33E25BC7B2904909A3C06F4839DBF6EA_678506478 = (mPresenters).iterator();
            var33E25BC7B2904909A3C06F4839DBF6EA_678506478.hasNext();
            WeakReference<MenuPresenter> ref = var33E25BC7B2904909A3C06F4839DBF6EA_678506478.next();
            {
                final MenuPresenter presenter = ref.get();
                {
                    mPresenters.remove(ref);
                } 
                {
                    boolean varE23C44F770E395CB54AA09B45593018D_1946046054 = ((collapsed = presenter.collapseItemActionView(this, item)));
                } 
            } 
        } 
        startDispatchingItemsChanged();
        {
            mExpandedItem = null;
        } 
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971485883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971485883;
        
        
        
        
        
            
            
                
            
                
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.408 -0400", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "2B6E63CEAA9A34DB77A1FC8C44063EB6")
    public MenuItemImpl getExpandedItem() {
        MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_2120589182 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2120589182 = mExpandedItem;
        varB4EAC82CA7396A68D541C85D26508E83_2120589182.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2120589182;
        
        
    }

    
    public interface Callback {
        
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item);
        
        
        public void onMenuModeChange(MenuBuilder menu);
    }
    
    public interface ItemInvoker {
        public boolean invokeItem(MenuItemImpl item);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.408 -0400", hash_original_field = "BB6CD346D213200830556CD1DC16291F", hash_generated_field = "48BEB4E811675B80200D5876BA18B494")

    private static final String TAG = "MenuBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.408 -0400", hash_original_field = "B1647BCC76A3DEF9EA1440031CF86BB7", hash_generated_field = "FAB6E9F72A015338D850F86B06EED585")

    private static final String PRESENTER_KEY = "android:menu:presenters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.408 -0400", hash_original_field = "F6032A2BB65ECFD85343DA439A98DAFE", hash_generated_field = "59CB259DC04AF6A04E6B27242510F0F4")

    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.408 -0400", hash_original_field = "86D3690E30D6D0F2F4756FB1BF14DA51", hash_generated_field = "6F05FC8F413331D8887456984C7CE03C")

    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.409 -0400", hash_original_field = "CB8E4B88C807FCCC22D973064080953E", hash_generated_field = "EB8D6F1FBF8BEBDFF8B3B7802168C511")

    private static final int[] sCategoryToOrder = new int[] {
        1, 
        4, 
        5, 
        3, 
        2, 
        0, 
    };
}

