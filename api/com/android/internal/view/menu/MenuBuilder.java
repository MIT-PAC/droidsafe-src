package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "7A5D05E188FBFEFD2A6CD8C4F3BE55EF", hash_generated_field = "95645DEF322B7192EFD2A867453899EE")

    private boolean mQwertyMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "30F8E95083FD70AE11D91E338148BC3B", hash_generated_field = "F96F6064EBE78C516E4D1B26D5D6F308")

    private boolean mShortcutsVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "BD34AA609B2F1444C5802546CAFD9E2E")

    private ArrayList<MenuItemImpl> mItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "A3FBDEDF325DB017B2A028D8843D3A09", hash_generated_field = "D9641413264F8197F037C6D0C97110BC")

    private ArrayList<MenuItemImpl> mVisibleItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "C67DC7FD766EB504ADF36E9A3CE0C111", hash_generated_field = "542DEB4B44629FB64BB72A2F9FFA719F")

    private boolean mIsVisibleItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "7D1513D823124F3D32B4FC834B5B8CB8", hash_generated_field = "922EA5B66BFB13CAC326F75845DC9FBF")

    private ArrayList<MenuItemImpl> mActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "E0A10BB2538038AA25598A6124DCADDA", hash_generated_field = "4FA8D7123D10D7FB60C3300B4743B5E4")

    private ArrayList<MenuItemImpl> mNonActionItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "18F6104DD929A80984779A51B33529C5", hash_generated_field = "4672D8DE4A1D2EDA6E7A30F19E847512")

    private boolean mIsActionItemsStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "38B00EB3AE2F97D7D4C3A7D6702A29C9", hash_generated_field = "99953610D3798A1652245FC37A11148F")

    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "F0F73BE0CFC128F21644E09022BFDB5F", hash_generated_field = "F71D241D22C847CB73D168C1498D3662")

    private ContextMenuInfo mCurrentMenuInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "C1CCD656768F0F81BE2BB78E3AA63E1D", hash_generated_field = "ED12AABB7E4F87DB5BC9D2D45FAAC566")

    CharSequence mHeaderTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "23E59940389E4E411553D10969622DA9", hash_generated_field = "1F64D0B7244E48B7E3E328CABEC4A309")

    Drawable mHeaderIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "9AD5F9977C84732F8447E1A8FA73384D", hash_generated_field = "B9C114F754E53BD7622DBFFDE976E899")

    View mHeaderView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "13C697CF832FB88504F822C5877322BE", hash_generated_field = "C1392DA651B1F71540302368BB665E1C")

    private SparseArray<Parcelable> mFrozenViewStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "F2D7884C9E09EDA0D21EDDA033D4CA5F", hash_generated_field = "42D2AC432A6B8C4EEEB5401ED2AFDB89")

    private boolean mPreventDispatchingItemsChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "1CF0B2A4175BDCEB5A15E99C5927876A", hash_generated_field = "2CD250962FDCC7A99FD4076F077F63F8")

    private boolean mItemsChangedWhileDispatchPrevented = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "E37DE1D7A2E8152AA3413A383EAA7C8D", hash_generated_field = "726E83C5EC3729E7BB3D264007C90B65")

    private boolean mOptionalIconsVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "D0F023C09A6729446D2A2C606F365FCB", hash_generated_field = "BCD7139A79D8D9F3133E20DC6D3F207A")

    private boolean mIsClosing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "CB08465A8B1AD1C8F82C6BD49F6A5824", hash_generated_field = "42C64CF6E53F14390A86902028B317E2")

    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<MenuItemImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.311 -0400", hash_original_field = "F05E7F7EED7161EAC2E8B160F25C396A", hash_generated_field = "AFD9B193D2ECD6C8B664F5067DC23F76")

    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.312 -0400", hash_original_field = "FC1533ACA08DCD52B7AC7DADED834BA2", hash_generated_field = "E6D19EE97CF34609C2DF041F94F84AE4")

    private MenuItemImpl mExpandedItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.312 -0400", hash_original_method = "C2AA5B4E524C0538591F7E534EEF4EDB", hash_generated_method = "C1D57B83660DAEFC2F4CD6A8D35E9B2C")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.312 -0400", hash_original_method = "ED83D8C12D0CC79577D0C9BACE5D12CA", hash_generated_method = "6590D70C835FD67E6508E4DE3A066698")
    public MenuBuilder setDefaultShowAsAction(int defaultShowAsAction) {
        mDefaultShowAsAction = defaultShowAsAction;
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_1631943348 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1631943348.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1631943348;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.312 -0400", hash_original_method = "DC84C1FD4C57BCD11FFC8D5235AEE0E3", hash_generated_method = "922AF312EDFD548714CA772B195EE49C")
    public void addMenuPresenter(MenuPresenter presenter) {
        addTaint(presenter.getTaint());
        mPresenters.add(new WeakReference<MenuPresenter>(presenter));
        presenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.312 -0400", hash_original_method = "960F9CE248E40E78F7D8CEFBA2D0E6DC", hash_generated_method = "E69B45A818FC32B19D4E967C263252C0")
    public void removeMenuPresenter(MenuPresenter presenter) {
        addTaint(presenter.getTaint());
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter item = ref.get();
    if(item == null || item == presenter)            
            {
                mPresenters.remove(ref);
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.312 -0400", hash_original_method = "54D4EF8A00AA3736A7301B3768CF2956", hash_generated_method = "5218770B9C81A96A2967040496DD621E")
    private void dispatchPresenterUpdate(boolean cleared) {
        addTaint(cleared);
    if(mPresenters.isEmpty())        
        return;
        stopDispatchingItemsChanged();
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
            {
                presenter.updateMenuView(cleared);
            } 
        } 
        startDispatchingItemsChanged();
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.313 -0400", hash_original_method = "972C883CEABE6EAECC969B119D377700", hash_generated_method = "502CE294947613DD9DC435FB4E7168E9")
    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenu) {
        addTaint(subMenu.getTaint());
    if(mPresenters.isEmpty())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1866138872 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300209554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300209554;
        }
        boolean result = false;
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
    if(!result)            
            {
                result = presenter.onSubMenuSelected(subMenu);
            } 
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_1931665665 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801858342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_801858342;
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.313 -0400", hash_original_method = "8458F949934B8A3332FB7D785BD3E421", hash_generated_method = "0153124F7BA63243C66BD42805E3308F")
    private void dispatchSaveInstanceState(Bundle outState) {
        addTaint(outState.getTaint());
    if(mPresenters.isEmpty())        
        return;
        SparseArray<Parcelable> presenterStates = new SparseArray<Parcelable>();
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
            {
                final int id = presenter.getId();
    if(id > 0)                
                {
                    final Parcelable state = presenter.onSaveInstanceState();
    if(state != null)                    
                    {
                        presenterStates.put(id, state);
                    } 
                } 
            } 
        } 
        outState.putSparseParcelableArray(PRESENTER_KEY, presenterStates);
        
        
        
        
            
            
                
            
                
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.313 -0400", hash_original_method = "4E7750A20EC8141646D41AE332CEFE6A", hash_generated_method = "3C17C740D57332AFE08760BA6C73033A")
    private void dispatchRestoreInstanceState(Bundle state) {
        addTaint(state.getTaint());
        SparseArray<Parcelable> presenterStates = state.getSparseParcelableArray(PRESENTER_KEY);
    if(presenterStates == null || mPresenters.isEmpty())        
        return;
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
            {
                final int id = presenter.getId();
    if(id > 0)                
                {
                    Parcelable parcel = presenterStates.get(id);
    if(parcel != null)                    
                    {
                        presenter.onRestoreInstanceState(parcel);
                    } 
                } 
            } 
        } 
        
        
        
        
            
            
                
            
                
                
                    
                    
                        
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.313 -0400", hash_original_method = "C07FEF29CEC872A81024F3FE20D651D5", hash_generated_method = "8321276FB3F7B30950316A8C8F7F58E3")
    public void savePresenterStates(Bundle outState) {
        addTaint(outState.getTaint());
        dispatchSaveInstanceState(outState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.314 -0400", hash_original_method = "F9D197F6E38B31BE5F51E70309A70CA9", hash_generated_method = "5A155A6BD78853BABF8DCA7426BC301A")
    public void restorePresenterStates(Bundle state) {
        addTaint(state.getTaint());
        dispatchRestoreInstanceState(state);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.314 -0400", hash_original_method = "A8F0361C85125DA8A38A18412990521E", hash_generated_method = "5E5BFBDBD62102D8645AA44A53E88CCA")
    public void saveActionViewStates(Bundle outStates) {
        addTaint(outStates.getTaint());
        SparseArray<Parcelable> viewStates = null;
        final int itemCount = size();
for(int i = 0;i < itemCount;i++)
        {
            final MenuItem item = getItem(i);
            final View v = item.getActionView();
    if(v != null && v.getId() != View.NO_ID)            
            {
    if(viewStates == null)                
                {
                    viewStates = new SparseArray<Parcelable>();
                } 
                v.saveHierarchyState(viewStates);
    if(item.isActionViewExpanded())                
                {
                    outStates.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                } 
            } 
    if(item.hasSubMenu())            
            {
                final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                subMenu.saveActionViewStates(outStates);
            } 
        } 
    if(viewStates != null)        
        {
            outStates.putSparseParcelableArray(getActionViewStatesKey(), viewStates);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.314 -0400", hash_original_method = "B3A4CB3CCE0DD38C30DBEC80F125B14F", hash_generated_method = "696BAA4135666346456247CD06485DA7")
    public void restoreActionViewStates(Bundle states) {
        addTaint(states.getTaint());
    if(states == null)        
        {
            return;
        } 
        SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(
                getActionViewStatesKey());
        final int itemCount = size();
for(int i = 0;i < itemCount;i++)
        {
            final MenuItem item = getItem(i);
            final View v = item.getActionView();
    if(v != null && v.getId() != View.NO_ID)            
            {
                v.restoreHierarchyState(viewStates);
            } 
    if(item.hasSubMenu())            
            {
                final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                subMenu.restoreActionViewStates(states);
            } 
        } 
        final int expandedId = states.getInt(EXPANDED_ACTION_VIEW_ID);
    if(expandedId > 0)        
        {
            MenuItem itemToExpand = findItem(expandedId);
    if(itemToExpand != null)            
            {
                itemToExpand.expandActionView();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.314 -0400", hash_original_method = "768FCB39246CC7532FBC95D1ED9DB161", hash_generated_method = "982CBC99CDC1AC21909541C6E70AD465")
    protected String getActionViewStatesKey() {
String var7F0932DDA550CC746E0478AD81F1022C_772189511 =         ACTION_VIEW_STATES_KEY;
        var7F0932DDA550CC746E0478AD81F1022C_772189511.addTaint(taint);
        return var7F0932DDA550CC746E0478AD81F1022C_772189511;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.314 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.314 -0400", hash_original_method = "D2F8ABBFA7F348CFE09EC6E4D42923FE", hash_generated_method = "269A7B82E3E91BAF58A3D7114ABD7E7F")
    private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        addTaint(title.getTaint());
        addTaint(categoryOrder);
        addTaint(id);
        addTaint(group);
        final int ordering = getOrdering(categoryOrder);
        final MenuItemImpl item = new MenuItemImpl(this, group, id, categoryOrder,
                ordering, title, mDefaultShowAsAction);
    if(mCurrentMenuInfo != null)        
        {
            item.setMenuInfo(mCurrentMenuInfo);
        } 
        mItems.add(findInsertIndex(mItems, ordering), item);
        onItemsChanged(true);
MenuItem var393CF4FD24220F0ED4B080A1E7108CD3_1446367233 =         item;
        var393CF4FD24220F0ED4B080A1E7108CD3_1446367233.addTaint(taint);
        return var393CF4FD24220F0ED4B080A1E7108CD3_1446367233;
        
        
        
                
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.315 -0400", hash_original_method = "A58C4A0DC6DAE82996B3AAD3FC54097A", hash_generated_method = "B409CF01F456BFE7D96C391BBAE962A6")
    public MenuItem add(CharSequence title) {
        addTaint(title.getTaint());
MenuItem var552DB9240B34AB1019F776DA2C7DE6A1_784952162 =         addInternal(0, 0, 0, title);
        var552DB9240B34AB1019F776DA2C7DE6A1_784952162.addTaint(taint);
        return var552DB9240B34AB1019F776DA2C7DE6A1_784952162;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.315 -0400", hash_original_method = "B1F9DD2456B991DFBE9905F02D8349D4", hash_generated_method = "882A5AF721AE17139FBC5D93691872C5")
    public MenuItem add(int titleRes) {
        addTaint(titleRes);
MenuItem var8E4AE735B91F4378877E460E8B518BDE_42514019 =         addInternal(0, 0, 0, mResources.getString(titleRes));
        var8E4AE735B91F4378877E460E8B518BDE_42514019.addTaint(taint);
        return var8E4AE735B91F4378877E460E8B518BDE_42514019;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.315 -0400", hash_original_method = "8928C392F688DC69E32CE7EA0D0F3896", hash_generated_method = "28EEF9A4F959DE460E313863FFCA2E41")
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        addTaint(title.getTaint());
        addTaint(categoryOrder);
        addTaint(id);
        addTaint(group);
MenuItem varA29D1F492D969C5999D75E14CB65A165_950606807 =         addInternal(group, id, categoryOrder, title);
        varA29D1F492D969C5999D75E14CB65A165_950606807.addTaint(taint);
        return varA29D1F492D969C5999D75E14CB65A165_950606807;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.315 -0400", hash_original_method = "58FC53F709B79AC8AC03457DFC6344A8", hash_generated_method = "617640368520D60C172D73E7D71C89C7")
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        addTaint(title);
        addTaint(categoryOrder);
        addTaint(id);
        addTaint(group);
MenuItem var10AEF6EE9D03725BAC1D293B879788CF_1463439931 =         addInternal(group, id, categoryOrder, mResources.getString(title));
        var10AEF6EE9D03725BAC1D293B879788CF_1463439931.addTaint(taint);
        return var10AEF6EE9D03725BAC1D293B879788CF_1463439931;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.315 -0400", hash_original_method = "FF063921CE164DCDB50DAAE1A235B123", hash_generated_method = "37A7B017884748008A271785BEC8F98F")
    public SubMenu addSubMenu(CharSequence title) {
        addTaint(title.getTaint());
SubMenu varE819D5BD964C892D9F7B9B909973846F_1675690250 =         addSubMenu(0, 0, 0, title);
        varE819D5BD964C892D9F7B9B909973846F_1675690250.addTaint(taint);
        return varE819D5BD964C892D9F7B9B909973846F_1675690250;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.315 -0400", hash_original_method = "5AB5B67F58824EF46C9C8C6E184D5FB6", hash_generated_method = "A60E13EB1362927491034AB2FCB278B2")
    public SubMenu addSubMenu(int titleRes) {
        addTaint(titleRes);
SubMenu varE88EB247E1F54FDF7D689BA2311EE814_1806383650 =         addSubMenu(0, 0, 0, mResources.getString(titleRes));
        varE88EB247E1F54FDF7D689BA2311EE814_1806383650.addTaint(taint);
        return varE88EB247E1F54FDF7D689BA2311EE814_1806383650;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.316 -0400", hash_original_method = "D915559B39DB4724361CCC3B4EDF4118", hash_generated_method = "75E32B76595D8997D008E999EAF56A6B")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        addTaint(title.getTaint());
        addTaint(categoryOrder);
        addTaint(id);
        addTaint(group);
        final MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, item);
        item.setSubMenu(subMenu);
SubMenu var0DB7EBD0BEDE8F5ABDCBBB980827FFD2_1657268298 =         subMenu;
        var0DB7EBD0BEDE8F5ABDCBBB980827FFD2_1657268298.addTaint(taint);
        return var0DB7EBD0BEDE8F5ABDCBBB980827FFD2_1657268298;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.316 -0400", hash_original_method = "AC03AE2386198E2F1FFF6E4670210A15", hash_generated_method = "ED03EA464493E7125D8F76D25A60C69C")
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        addTaint(title);
        addTaint(categoryOrder);
        addTaint(id);
        addTaint(group);
SubMenu varB3D8425F5D7AB7C35917D0BC9146DC84_2075753163 =         addSubMenu(group, id, categoryOrder, mResources.getString(title));
        varB3D8425F5D7AB7C35917D0BC9146DC84_2075753163.addTaint(taint);
        return varB3D8425F5D7AB7C35917D0BC9146DC84_2075753163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.316 -0400", hash_original_method = "F55E03F7468E87D0E7E583D005D452FA", hash_generated_method = "518519D5BBAF201FBAD2EE895ABCBBDF")
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        addTaint(outSpecificItems[0].getTaint());
        addTaint(flags);
        addTaint(intent.getTaint());
        addTaint(specifics[0].getTaint());
        addTaint(caller.getTaint());
        addTaint(categoryOrder);
        addTaint(id);
        addTaint(group);
        PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri = pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        final int N = lri != null ? lri.size() : 0;
    if((flags & FLAG_APPEND_TO_GROUP) == 0)        
        {
            removeGroup(group);
        } 
for(int i=0;i<N;i++)
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
    if(outSpecificItems != null && ri.specificIndex >= 0)            
            {
                outSpecificItems[ri.specificIndex] = item;
            } 
        } 
        int var8D9C307CB7F3C4A32822A51922D1CEAA_1874691062 = (N);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184670038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184670038;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.316 -0400", hash_original_method = "CD40CB8D7701B558D158DB4B227DBE9C", hash_generated_method = "7991AE4304F1865B2FFA7D8FECD65335")
    public void removeItem(int id) {
        addTaint(id);
        removeItemAtInt(findItemIndex(id), true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.316 -0400", hash_original_method = "CB73A0EC2BA8A6DB548593D621DAEDFE", hash_generated_method = "EC13AF0397C1385ABFA1D0487AFD669A")
    public void removeGroup(int group) {
        addTaint(group);
        final int i = findGroupIndex(group);
    if(i >= 0)        
        {
            final int maxRemovable = mItems.size() - i;
            int numRemoved = 0;
            while
((numRemoved++ < maxRemovable) && (mItems.get(i).getGroupId() == group))            
            {
                removeItemAtInt(i, false);
            } 
            onItemsChanged(true);
        } 
        
        
        
            
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.317 -0400", hash_original_method = "B04372368F85324A2D15939652770F19", hash_generated_method = "7CBDB61250B07B7AFAFAED345A625C58")
    private void removeItemAtInt(int index, boolean updateChildrenOnMenuViews) {
        addTaint(updateChildrenOnMenuViews);
        addTaint(index);
    if((index < 0) || (index >= mItems.size()))        
        return;
        mItems.remove(index);
    if(updateChildrenOnMenuViews)        
        onItemsChanged(true);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.317 -0400", hash_original_method = "CCF84DAB4498D26153763C00D389A015", hash_generated_method = "941505C314F2DB301FD9C3EF061D4EEE")
    public void removeItemAt(int index) {
        addTaint(index);
        removeItemAtInt(index, true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.317 -0400", hash_original_method = "D9B89DA7AD2B2AFA9DE110DD3D9C4F62", hash_generated_method = "EE1F5DE30C303F3D28461F50B1CD8998")
    public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.317 -0400", hash_original_method = "342FF024BFE6EC4187DF36B135809AC5", hash_generated_method = "D29B1BC6E92E2F7F3CD2FFAAB34BDD7B")
    public void clear() {
    if(mExpandedItem != null)        
        {
            collapseItemActionView(mExpandedItem);
        } 
        mItems.clear();
        onItemsChanged(true);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.317 -0400", hash_original_method = "46B444F22731C330EF8C5DDD6085B819", hash_generated_method = "35241DDD36028AC7A91E4B443F7E8105")
     void setExclusiveItemChecked(MenuItem item) {
        addTaint(item.getTaint());
        final int group = item.getGroupId();
        final int N = mItems.size();
for(int i = 0;i < N;i++)
        {
            MenuItemImpl curItem = mItems.get(i);
    if(curItem.getGroupId() == group)            
            {
    if(!curItem.isExclusiveCheckable())                
                continue;
    if(!curItem.isCheckable())                
                continue;
                curItem.setCheckedInt(curItem == item);
            } 
        } 
        
        
        
        
            
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.317 -0400", hash_original_method = "617F901519AF5A780BAA79B1FC3B9265", hash_generated_method = "23E01E39741D7F464C802AFED43588A4")
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        addTaint(exclusive);
        addTaint(checkable);
        addTaint(group);
        final int N = mItems.size();
for(int i = 0;i < N;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.getGroupId() == group)            
            {
                item.setExclusiveCheckable(exclusive);
                item.setCheckable(checkable);
            } 
        } 
        
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.318 -0400", hash_original_method = "4EDC76E82EDC17A472BC69BB1B6E7C6A", hash_generated_method = "41A848781406BDD4C44655EC8CC64184")
    public void setGroupVisible(int group, boolean visible) {
        addTaint(visible);
        addTaint(group);
        final int N = mItems.size();
        boolean changedAtLeastOneItem = false;
for(int i = 0;i < N;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.getGroupId() == group)            
            {
    if(item.setVisibleInt(visible))                
                changedAtLeastOneItem = true;
            } 
        } 
    if(changedAtLeastOneItem)        
        onItemsChanged(true);
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.318 -0400", hash_original_method = "7EF09E6D8E231FEB2B973547EA11426B", hash_generated_method = "E2094694E98CA0082C6ECAFBB4DA7774")
    public void setGroupEnabled(int group, boolean enabled) {
        addTaint(enabled);
        addTaint(group);
        final int N = mItems.size();
for(int i = 0;i < N;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.getGroupId() == group)            
            {
                item.setEnabled(enabled);
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.318 -0400", hash_original_method = "3B72BBA33C08D8899AD542CA53217B07", hash_generated_method = "20EE48C7A72F75049ABF6790F52B7B92")
    public boolean hasVisibleItems() {
        final int size = size();
for(int i = 0;i < size;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.isVisible())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1578969247 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224761290 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_224761290;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1375484851 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438277800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438277800;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.318 -0400", hash_original_method = "C4099179C463A7AE36757107136E192F", hash_generated_method = "69EC24EA4050CCBD54C8E5E279B5AD12")
    public MenuItem findItem(int id) {
        addTaint(id);
        final int size = size();
for(int i = 0;i < size;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.getItemId() == id)            
            {
MenuItem var393CF4FD24220F0ED4B080A1E7108CD3_1003006265 =                 item;
                var393CF4FD24220F0ED4B080A1E7108CD3_1003006265.addTaint(taint);
                return var393CF4FD24220F0ED4B080A1E7108CD3_1003006265;
            } 
            else
    if(item.hasSubMenu())            
            {
                MenuItem possibleItem = item.getSubMenu().findItem(id);
    if(possibleItem != null)                
                {
MenuItem varDAE208F95FACCCB174179530B25805B7_229764814 =                     possibleItem;
                    varDAE208F95FACCCB174179530B25805B7_229764814.addTaint(taint);
                    return varDAE208F95FACCCB174179530B25805B7_229764814;
                } 
            } 
        } 
MenuItem var540C13E9E156B687226421B24F2DF178_1746417028 =         null;
        var540C13E9E156B687226421B24F2DF178_1746417028.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1746417028;
        
        
        
            
            
                
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.318 -0400", hash_original_method = "A261F964DDA96C3C6D463268984A697B", hash_generated_method = "41DB91BFF797D71FB1DC862B8451BD09")
    public int findItemIndex(int id) {
        addTaint(id);
        final int size = size();
for(int i = 0;i < size;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.getItemId() == id)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_193543747 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900179307 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900179307;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2000435236 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190505664 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190505664;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.318 -0400", hash_original_method = "1EE87EAF07576D7C1C7EC0FD1C1E2EAD", hash_generated_method = "682917B44B9BD0EEEEC0F8FFC7168BFA")
    public int findGroupIndex(int group) {
        addTaint(group);
        int var6B458BB34938B6D2698FB85C1A9DF35F_766734701 = (findGroupIndex(group, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434526219 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434526219;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "80C34342EB4325A3182DBD2F94EDD656", hash_generated_method = "0CDBD4F196377B3AEC04025749CDA210")
    public int findGroupIndex(int group, int start) {
        addTaint(start);
        addTaint(group);
        final int size = size();
    if(start < 0)        
        {
            start = 0;
        } 
for(int i = start;i < size;i++)
        {
            final MenuItemImpl item = mItems.get(i);
    if(item.getGroupId() == group)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_2003045154 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1020094067 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1020094067;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1221171844 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557536493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557536493;
        
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "C969B332CBABDF99DFFEEA7FFF828500")
    public int size() {
        int var9B434FD456AC2D14B6AB22377BFF1926_45047205 = (mItems.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002412466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002412466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "6E41AAB7DA01440F099326FF7AEF35B5")
    public MenuItem getItem(int index) {
        addTaint(index);
MenuItem var955C9579A8231EA8752336C152243F31_49279496 =         mItems.get(index);
        var955C9579A8231EA8752336C152243F31_49279496.addTaint(taint);
        return var955C9579A8231EA8752336C152243F31_49279496;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "ECF8DA19BC86F4769F2B307E72CF73B2", hash_generated_method = "11A01F535F0D8919D2EF0CCB4DE168AF")
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var544816AF505855E5330ACF6254CC8C80_535649621 = (findItemWithShortcutForKey(keyCode, event) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651903107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651903107;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "2381211E72D0CFF3279FB3F86E943514", hash_generated_method = "4EF925579ED2A5FE24BA9D877FE5657E")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "D1F1AC187BB0F0066C68CB94F0A9F578", hash_generated_method = "2A04F2CA957102C445D682DF3E2B8811")
     boolean isQwertyMode() {
        boolean var7A5D05E188FBFEFD2A6CD8C4F3BE55EF_1585077441 = (mQwertyMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790586038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790586038;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.319 -0400", hash_original_method = "5CCA4A69E642C22AB6858AA5EF093CEB", hash_generated_method = "13ABB4892F8105F592B0FE87023F7A36")
    public void setShortcutsVisible(boolean shortcutsVisible) {
        addTaint(shortcutsVisible);
    if(mShortcutsVisible == shortcutsVisible)        
        return;
        setShortcutsVisibleInner(shortcutsVisible);
        onItemsChanged(false);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.320 -0400", hash_original_method = "BCC95ACBA680BEE1F3E7AD661CBC9615", hash_generated_method = "5F1306E253C0176589E31B06AFE8A16B")
    private void setShortcutsVisibleInner(boolean shortcutsVisible) {
        mShortcutsVisible = shortcutsVisible
                && mResources.getConfiguration().keyboard != Configuration.KEYBOARD_NOKEYS
                && mResources.getBoolean(
                        com.android.internal.R.bool.config_showMenuShortcutsWhenKeyboardPresent);
        
        
                
                
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.320 -0400", hash_original_method = "3D6E88EAA663FB4E0596921B97D4252E", hash_generated_method = "1FD8F801E83FE3FF1DB041BFA0B08766")
    public boolean isShortcutsVisible() {
        boolean var30F8E95083FD70AE11D91E338148BC3B_1361379754 = (mShortcutsVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213329148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213329148;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.320 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "37863C70B9A4F64BC356EB2781C91074")
     Resources getResources() {
Resources var346B953D96D762F7FED561E83C1656CA_952996521 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_952996521.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_952996521;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.320 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "F0B191EB275613DED05D43E9E72DBBEC")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_483091749 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_483091749.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_483091749;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.320 -0400", hash_original_method = "F5303C9B32AC7DFF16FC4A0F6CDD6E5E", hash_generated_method = "3D00E2F070ACBBC0E04197B067EB09A3")
     boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var2C2D8C32C2CAC698FCFE5145125D6C9E_834728028 = (mCallback != null && mCallback.onMenuItemSelected(menu, item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300849514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300849514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.320 -0400", hash_original_method = "FD6A39894A001531BB86BA5F00A5F8F4", hash_generated_method = "F8C532FFA9F4AA51F2955BAB606FE042")
    public void changeMenuMode() {
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.321 -0400", hash_original_method = "9861F924DD1EB593B44131240E8058F2", hash_generated_method = "DC5056DD56882CF67C5630CA844E30F3")
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        addTaint(flags);
        addTaint(event.getTaint());
        addTaint(keyCode);
        final MenuItemImpl item = findItemWithShortcutForKey(keyCode, event);
        boolean handled = false;
    if(item != null)        
        {
            handled = performItemAction(item, flags);
        } 
    if((flags & FLAG_ALWAYS_PERFORM_CLOSE) != 0)        
        {
            close(true);
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_113440599 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246081255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246081255;
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.321 -0400", hash_original_method = "82B9F48D42D65192D5877280D6BB4BB2", hash_generated_method = "3EDEC6CA9DCE739DE4E35462D1D779A9")
     void findItemsWithShortcutForKey(List<MenuItemImpl> items, int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(items.getTaint());
        final boolean qwerty = isQwertyMode();
        final int metaState = event.getMetaState();
        final KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        final boolean isKeyCodeMapped = event.getKeyData(possibleChars);
    if(!isKeyCodeMapped && (keyCode != KeyEvent.KEYCODE_DEL))        
        {
            return;
        } 
        final int N = mItems.size();
for(int i = 0;i < N;i++)
        {
            MenuItemImpl item = mItems.get(i);
    if(item.hasSubMenu())            
            {
                ((MenuBuilder)item.getSubMenu()).findItemsWithShortcutForKey(items, keyCode, event);
            } 
            final char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
    if(((metaState & (KeyEvent.META_SHIFT_ON | KeyEvent.META_SYM_ON)) == 0) &&
                  (shortcutChar != 0) &&
                  (shortcutChar == possibleChars.meta[0]
                      || shortcutChar == possibleChars.meta[2]
                      || (qwerty && shortcutChar == '\b' &&
                          keyCode == KeyEvent.KEYCODE_DEL)) &&
                  item.isEnabled())            
            {
                items.add(item);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.321 -0400", hash_original_method = "249AD997FE7830E8331222B437093C3E", hash_generated_method = "482C82DF1A16574D55E40C12F075582A")
     MenuItemImpl findItemWithShortcutForKey(int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        ArrayList<MenuItemImpl> items = mTempShortcutItemList;
        items.clear();
        findItemsWithShortcutForKey(items, keyCode, event);
    if(items.isEmpty())        
        {
MenuItemImpl var540C13E9E156B687226421B24F2DF178_682536059 =             null;
            var540C13E9E156B687226421B24F2DF178_682536059.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_682536059;
        } 
        final int metaState = event.getMetaState();
        final KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        event.getKeyData(possibleChars);
        final int size = items.size();
    if(size == 1)        
        {
MenuItemImpl var74F894FE91D6EE80B7707D4B19317B89_367342784 =             items.get(0);
            var74F894FE91D6EE80B7707D4B19317B89_367342784.addTaint(taint);
            return var74F894FE91D6EE80B7707D4B19317B89_367342784;
        } 
        final boolean qwerty = isQwertyMode();
for(int i = 0;i < size;i++)
        {
            final MenuItemImpl item = items.get(i);
            final char shortcutChar = qwerty ? item.getAlphabeticShortcut() :
                    item.getNumericShortcut();
    if((shortcutChar == possibleChars.meta[0] &&
                    (metaState & KeyEvent.META_ALT_ON) == 0)
                || (shortcutChar == possibleChars.meta[2] &&
                    (metaState & KeyEvent.META_ALT_ON) != 0)
                || (qwerty && shortcutChar == '\b' &&
                    keyCode == KeyEvent.KEYCODE_DEL))            
            {
MenuItemImpl var393CF4FD24220F0ED4B080A1E7108CD3_887947727 =                 item;
                var393CF4FD24220F0ED4B080A1E7108CD3_887947727.addTaint(taint);
                return var393CF4FD24220F0ED4B080A1E7108CD3_887947727;
            } 
        } 
MenuItemImpl var540C13E9E156B687226421B24F2DF178_897517987 =         null;
        var540C13E9E156B687226421B24F2DF178_897517987.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_897517987;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.322 -0400", hash_original_method = "75DB357B621A78C2320053E458E89B31", hash_generated_method = "5EFF169A965F22DFD111600E00851695")
    public boolean performIdentifierAction(int id, int flags) {
        addTaint(flags);
        addTaint(id);
        boolean varA9BCF1E63C94B27E6CBADA0062DBE721_1268725338 = (performItemAction(findItem(id), flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530791607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530791607;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.322 -0400", hash_original_method = "35FE8CE6C993B07CD0CB9DB44F8CBE25", hash_generated_method = "0C99F3625F206DDF3F67209D16ACC135")
    public boolean performItemAction(MenuItem item, int flags) {
        addTaint(flags);
        addTaint(item.getTaint());
        MenuItemImpl itemImpl = (MenuItemImpl) item;
    if(itemImpl == null || !itemImpl.isEnabled())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1892877150 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057643545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057643545;
        } 
        boolean invoked = itemImpl.invoke();
    if(itemImpl.hasCollapsibleActionView())        
        {
            invoked |= itemImpl.expandActionView();
    if(invoked)            
            close(true);
        } 
        else
    if(item.hasSubMenu())        
        {
            close(false);
            final SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
            final ActionProvider provider = item.getActionProvider();
    if(provider != null && provider.hasSubMenu())            
            {
                provider.onPrepareSubMenu(subMenu);
            } 
            invoked |= dispatchSubMenuSelected(subMenu);
    if(!invoked)            
            close(true);
        } 
        else
        {
    if((flags & FLAG_PERFORM_NO_CLOSE) == 0)            
            {
                close(true);
            } 
        } 
        boolean varFABB19B279DE1E206FA6D493923723BA_513614462 = (invoked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250268533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250268533;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.322 -0400", hash_original_method = "95071F981B5536F482A785105041F83F", hash_generated_method = "BA7C9C7F4D8F68A162A6D31311096DFF")
    final void close(boolean allMenusAreClosing) {
        addTaint(allMenusAreClosing);
    if(mIsClosing)        
        return;
        mIsClosing = true;
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
            {
                presenter.onCloseMenu(this, allMenusAreClosing);
            } 
        } 
        mIsClosing = false;
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.322 -0400", hash_original_method = "597B95CEB5AFD05C977FB508D047C50E", hash_generated_method = "21668DF8FDBDBCA1A469227829ADE78B")
    public void close() {
        close(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.323 -0400", hash_original_method = "5A795AB2D4E1ABD04FD81F99B25E4230", hash_generated_method = "7F166D58154C121D6B00E896143568F4")
     void onItemsChanged(boolean structureChanged) {
        
        addTaint(structureChanged);
    if(!mPreventDispatchingItemsChanged)        
        {
    if(structureChanged)            
            {
                mIsVisibleItemsStale = true;
                mIsActionItemsStale = true;
            } 
            dispatchPresenterUpdate(structureChanged);
        } 
        else
        {
            mItemsChangedWhileDispatchPrevented = true;
        } 
        
        
            
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.323 -0400", hash_original_method = "7EE5FE9E6BBC07EC6A3DE0DDC7903124", hash_generated_method = "C6C34B3ACFB6E10E203EE437E36232E8")
    public void stopDispatchingItemsChanged() {
    if(!mPreventDispatchingItemsChanged)        
        {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.323 -0400", hash_original_method = "7B45ED8DD7A5E8350ED36609A9B02705", hash_generated_method = "8F1AEF7B9C11ADCE26C9AAB4C556698D")
    public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;
    if(mItemsChangedWhileDispatchPrevented)        
        {
            mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.323 -0400", hash_original_method = "35145509C47AC84C9D3AE9A757523F29", hash_generated_method = "87BC14FF3FF6B59C0F43CD242572A1D4")
     void onItemVisibleChanged(MenuItemImpl item) {
        
        addTaint(item.getTaint());
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.324 -0400", hash_original_method = "A132A45384AC6B24ED5C41ACBF0074C1", hash_generated_method = "C71F64C33507DF9A294146BFC5C35934")
     void onItemActionRequestChanged(MenuItemImpl item) {
        
        addTaint(item.getTaint());
        mIsActionItemsStale = true;
        onItemsChanged(true);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.324 -0400", hash_original_method = "66450A6B071A6D6254ADE6AFA4286392", hash_generated_method = "C793598096829F3E9FC9F48588B431A1")
     ArrayList<MenuItemImpl> getVisibleItems() {
    if(!mIsVisibleItemsStale)        
        {
ArrayList<MenuItemImpl> var33FFCE779C9FCF0AFFA1FF6FAAEA0DF9_1616398451 =         mVisibleItems;
        var33FFCE779C9FCF0AFFA1FF6FAAEA0DF9_1616398451.addTaint(taint);
        return var33FFCE779C9FCF0AFFA1FF6FAAEA0DF9_1616398451;
        }
        mVisibleItems.clear();
        final int itemsSize = mItems.size();
        MenuItemImpl item;
for(int i = 0;i < itemsSize;i++)
        {
            item = mItems.get(i);
    if(item.isVisible())            
            mVisibleItems.add(item);
        } 
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
ArrayList<MenuItemImpl> var33FFCE779C9FCF0AFFA1FF6FAAEA0DF9_1395386250 =         mVisibleItems;
        var33FFCE779C9FCF0AFFA1FF6FAAEA0DF9_1395386250.addTaint(taint);
        return var33FFCE779C9FCF0AFFA1FF6FAAEA0DF9_1395386250;
        
        
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.324 -0400", hash_original_method = "D6438F434F829962E80BA6A78BAE5995", hash_generated_method = "974F6DBC8680F88F1766E372DFB21F24")
    public void flagActionItems() {
    if(!mIsActionItemsStale)        
        {
            return;
        } 
        boolean flagged = false;
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
            {
                flagged |= presenter.flagActionItems();
            } 
        } 
    if(flagged)        
        {
            mActionItems.clear();
            mNonActionItems.clear();
            ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
            final int itemsSize = visibleItems.size();
for(int i = 0;i < itemsSize;i++)
            {
                MenuItemImpl item = visibleItems.get(i);
    if(item.isActionButton())                
                {
                    mActionItems.add(item);
                } 
                else
                {
                    mNonActionItems.add(item);
                } 
            } 
        } 
        else
        {
            mActionItems.clear();
            mNonActionItems.clear();
            mNonActionItems.addAll(getVisibleItems());
        } 
        mIsActionItemsStale = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.324 -0400", hash_original_method = "B1634DAD61F1C3BCC25AA2BE8A5F685D", hash_generated_method = "8A29227EB414E26D32D2EDF9D4B1F1DD")
     ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
ArrayList<MenuItemImpl> var4C3BCBFB9C785406A11CA0A78BD89521_1524872493 =         mActionItems;
        var4C3BCBFB9C785406A11CA0A78BD89521_1524872493.addTaint(taint);
        return var4C3BCBFB9C785406A11CA0A78BD89521_1524872493;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.325 -0400", hash_original_method = "B350BF5A73D0E23634B50CFF93D74F82", hash_generated_method = "40153CD5CF6C4E033E265813BE1FEAB6")
     ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
ArrayList<MenuItemImpl> var1BEF02116BD01649FAF4B06AB6C0ADD7_1396391579 =         mNonActionItems;
        var1BEF02116BD01649FAF4B06AB6C0ADD7_1396391579.addTaint(taint);
        return var1BEF02116BD01649FAF4B06AB6C0ADD7_1396391579;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.325 -0400", hash_original_method = "50068C9782E9BFC0D29147CAEDC5BEC3", hash_generated_method = "5040574501D06F18CD7ADF0F855D53F0")
    public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;
        onItemsChanged(false);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.325 -0400", hash_original_method = "186F768E53D647FEAF851BE51616ADE9", hash_generated_method = "D20224C7DAA48B5F1B95A884AF346724")
    private void setHeaderInternal(final int titleRes, final CharSequence title, final int iconRes,
            final Drawable icon, final View view) {
        final Resources r = getResources();
    if(view != null)        
        {
            mHeaderView = view;
            mHeaderTitle = null;
            mHeaderIcon = null;
        } 
        else
        {
    if(titleRes > 0)            
            {
                mHeaderTitle = r.getText(titleRes);
            } 
            else
    if(title != null)            
            {
                mHeaderTitle = title;
            } 
    if(iconRes > 0)            
            {
                mHeaderIcon = r.getDrawable(iconRes);
            } 
            else
    if(icon != null)            
            {
                mHeaderIcon = icon;
            } 
            mHeaderView = null;
        } 
        onItemsChanged(false);
        
        
        
            
            
            
        
            
                
            
                
            
            
                
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.332 -0400", hash_original_method = "FFCF471E8854966199C591D456AD6895", hash_generated_method = "F00F095F95E2CDCBE2934460944FDFF8")
    protected MenuBuilder setHeaderTitleInt(CharSequence title) {
        addTaint(title.getTaint());
        setHeaderInternal(0, title, 0, null, null);
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_844373355 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_844373355.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_844373355;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.332 -0400", hash_original_method = "6FC715913E3FD5981F9DD3E7E4AF3852", hash_generated_method = "C41E8DB52251CAC6B91181C1A58B41C7")
    protected MenuBuilder setHeaderTitleInt(int titleRes) {
        addTaint(titleRes);
        setHeaderInternal(titleRes, null, 0, null, null);
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_1460073449 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1460073449.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1460073449;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.332 -0400", hash_original_method = "0C83E3BE30A13663CEC9D94BD8944336", hash_generated_method = "140FC54A38F229618AA3F2F58432CA82")
    protected MenuBuilder setHeaderIconInt(Drawable icon) {
        addTaint(icon.getTaint());
        setHeaderInternal(0, null, 0, icon, null);
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_1945713 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1945713.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1945713;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.333 -0400", hash_original_method = "253F3D7FA62779562611B9B2A33B995B", hash_generated_method = "68E8E2AFABEFC4974E1DBB995166021F")
    protected MenuBuilder setHeaderIconInt(int iconRes) {
        addTaint(iconRes);
        setHeaderInternal(0, null, iconRes, null, null);
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_1163909941 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1163909941.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1163909941;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.333 -0400", hash_original_method = "9212C1843EBD5F59A89AA2755EC31F21", hash_generated_method = "C9B95EDEAAD517711BBF28196787A445")
    protected MenuBuilder setHeaderViewInt(View view) {
        addTaint(view.getTaint());
        setHeaderInternal(0, null, 0, null, view);
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_960098938 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_960098938.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_960098938;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.333 -0400", hash_original_method = "784130069FD88AACA2FF7E14C3513725", hash_generated_method = "E57B7C839330AE6F45E0179BC15907F1")
    public CharSequence getHeaderTitle() {
CharSequence var7DCC7A2F957B393CB2727C67254C5D1B_411217781 =         mHeaderTitle;
        var7DCC7A2F957B393CB2727C67254C5D1B_411217781.addTaint(taint);
        return var7DCC7A2F957B393CB2727C67254C5D1B_411217781;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.333 -0400", hash_original_method = "2A12D914AC47BF173D916A2E203AB0B5", hash_generated_method = "335E3D8EAE0312D5A1E9E25FBAC994D5")
    public Drawable getHeaderIcon() {
Drawable varCA8B61EFC38E8D748E1BCFE8467D287E_844144013 =         mHeaderIcon;
        varCA8B61EFC38E8D748E1BCFE8467D287E_844144013.addTaint(taint);
        return varCA8B61EFC38E8D748E1BCFE8467D287E_844144013;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.333 -0400", hash_original_method = "05FD519E01712AB41A2C974B75A6F049", hash_generated_method = "46BBE8F6385E1B85DCD775658A89E75A")
    public View getHeaderView() {
View var91C9EF508B9512096DAA858981B9A59A_24702452 =         mHeaderView;
        var91C9EF508B9512096DAA858981B9A59A_24702452.addTaint(taint);
        return var91C9EF508B9512096DAA858981B9A59A_24702452;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.334 -0400", hash_original_method = "1B9A2DEC3BE3351B13A5C4A669F566C3", hash_generated_method = "26E42C0B424C771CA6CE8EBFAB796995")
    public MenuBuilder getRootMenu() {
MenuBuilder var72A74007B2BE62B849F475C7BDA4658B_1800586951 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1800586951.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1800586951;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.334 -0400", hash_original_method = "8B5C0DAA8A7CB0B223A94346B39E6366", hash_generated_method = "44FD6FA0FC67E1F797EECB25B51E33BF")
    public void setCurrentMenuInfo(ContextMenuInfo menuInfo) {
        mCurrentMenuInfo = menuInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.334 -0400", hash_original_method = "5006D7919DE7388D9F9EDDAFF142B475", hash_generated_method = "E45EEED5BD943ACCCE728FF6AF008161")
     void setOptionalIconsVisible(boolean visible) {
        mOptionalIconsVisible = visible;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.334 -0400", hash_original_method = "E16B8D475B8F5B112A4C02A29314D988", hash_generated_method = "264B7397BD2D7462F2911241407AA156")
     boolean getOptionalIconsVisible() {
        boolean varBFBEA2D110892FD684F3E2CEA7E7EEE0_318240777 = (mOptionalIconsVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024902208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024902208;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.334 -0400", hash_original_method = "EE8D5D3489A1A55A6EA94D4BFD84A637", hash_generated_method = "B17EC1D5C42B1BE620DE603B9156F13D")
    public boolean expandItemActionView(MenuItemImpl item) {
    if(mPresenters.isEmpty())        
        {
        boolean var68934A3E9455FA72420237EB05902327_353023460 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548349921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_548349921;
        }
        boolean expanded = false;
        stopDispatchingItemsChanged();
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
    if((expanded = presenter.expandItemActionView(this, item)))            
            {
                break;
            } 
        } 
        startDispatchingItemsChanged();
    if(expanded)        
        {
            mExpandedItem = item;
        } 
        boolean var1A6130A21D7D578D81A168EBCF0D9921_1549382605 = (expanded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208899032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208899032;
        
        
        
        
        
            
            
                
            
                
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_method = "06F25D2FDACA8E4F633278E442B2C78B", hash_generated_method = "8ABB3F56AC99275B8AF72139C01BACD4")
    public boolean collapseItemActionView(MenuItemImpl item) {
        addTaint(item.getTaint());
    if(mPresenters.isEmpty() || mExpandedItem != item)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2019375130 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117737526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117737526;
        }
        boolean collapsed = false;
        stopDispatchingItemsChanged();
for(WeakReference<MenuPresenter> ref : mPresenters)
        {
            final MenuPresenter presenter = ref.get();
    if(presenter == null)            
            {
                mPresenters.remove(ref);
            } 
            else
    if((collapsed = presenter.collapseItemActionView(this, item)))            
            {
                break;
            } 
        } 
        startDispatchingItemsChanged();
    if(collapsed)        
        {
            mExpandedItem = null;
        } 
        boolean var3338C02FE80EF02FC4BFB78F90BF173C_444247874 = (collapsed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21715408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_21715408;
        
        
        
        
        
            
            
                
            
                
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_method = "D7BAB9B2E77DBC9C3D313A6F44451B73", hash_generated_method = "B6017002D2CAAA5776E43428B4B1DB74")
    public MenuItemImpl getExpandedItem() {
MenuItemImpl varC988F696DAE68DCF751841C7BFBE9186_351873205 =         mExpandedItem;
        varC988F696DAE68DCF751841C7BFBE9186_351873205.addTaint(taint);
        return varC988F696DAE68DCF751841C7BFBE9186_351873205;
        
        
    }

    
    public interface Callback {
        
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item);
        
        
        public void onMenuModeChange(MenuBuilder menu);
    }
    
    public interface ItemInvoker {
        public boolean invokeItem(MenuItemImpl item);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_field = "BB6CD346D213200830556CD1DC16291F", hash_generated_field = "48BEB4E811675B80200D5876BA18B494")

    private static final String TAG = "MenuBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_field = "B1647BCC76A3DEF9EA1440031CF86BB7", hash_generated_field = "FAB6E9F72A015338D850F86B06EED585")

    private static final String PRESENTER_KEY = "android:menu:presenters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_field = "F6032A2BB65ECFD85343DA439A98DAFE", hash_generated_field = "59CB259DC04AF6A04E6B27242510F0F4")

    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_field = "86D3690E30D6D0F2F4756FB1BF14DA51", hash_generated_field = "6F05FC8F413331D8887456984C7CE03C")

    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.335 -0400", hash_original_field = "CB8E4B88C807FCCC22D973064080953E", hash_generated_field = "EB8D6F1FBF8BEBDFF8B3B7802168C511")

    private static final int[] sCategoryToOrder = new int[] {
        1, 
        4, 
        5, 
        3, 
        2, 
        0, 
    };
}

