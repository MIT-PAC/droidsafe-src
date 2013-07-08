package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.view.menu.ActionMenuView.ActionMenuChildView;
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
import java.util.ArrayList;

public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "18A904A5C0CC1E1FE45C814D28B71B26", hash_generated_field = "62B115CA56547ACC4395C5191DCAFA48")

    private View mOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "0E213F9463B6EFE55ADA2109C5E5DC56", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "FF60A156CE7AD39BD5FB673AFD302D5B", hash_generated_field = "8AA1ADBD5C3D9FA8BD4CE08655C7BAEC")

    private boolean mReserveOverflowSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "83EF65FD766EAC154AE5FEA63E2CE25A", hash_generated_field = "D519A6354FF6027B8318E0E8A1847729")

    private int mWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "A7E9006F830347B6496E603E3A3EFC82", hash_generated_field = "EE263C3BDAD9F74C57B87B4D53F4A7F2")

    private int mActionItemWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "0FFA0622B0631C3E765DE6810D1D5BEE", hash_generated_field = "46A54E1F46C2CF0E99FFE4A07B201C3C")

    private int mMaxItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "0EBB7A0928E7934DA0F5EC0C1A2EF0AA", hash_generated_field = "E8BC6B5172B218C6C49A6690AFA86C5B")

    private boolean mMaxItemsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.931 -0400", hash_original_field = "428FC947ACD187E12AF96B1282A02E84", hash_generated_field = "5992037AC4E6034F7F17925E51ACE390")

    private boolean mStrictWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "BEC7BC02B14F4AE2D2525ECA9C34A88C", hash_generated_field = "896F729C22C3B090A4F37324F1470F98")

    private boolean mWidthLimitSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "B912C176D59A2C01DCA72A9AB2E2D62B", hash_generated_field = "609B8E14C3F57F0FDE596A9E3115E316")

    private boolean mExpandedActionViewsExclusive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "C0CB7E511A75AFCB98C3B0342F6802E9", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "4A448DC9861F25A2BD03E23A029BD7C0", hash_generated_field = "AB745D0096A474765505150A34296B41")

    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "86CDD986D39C84A497FF93C26971615A", hash_generated_field = "62CE63FA1996B79D9E9EE4493D96FB92")

    private View mScrapActionButtonView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "12E0F70E3294B5917D9DCD47A20C5330", hash_generated_field = "73011FFFEE53F9056EE81430FCFEDF05")

    private OverflowPopup mOverflowPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "8A4CED1EBB8A308B59EEEF4C102ECD26", hash_generated_field = "BAF3D98693011134EB1620D1BA22CC15")

    private ActionButtonSubmenu mActionButtonPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "8BA73CE13504EDF3C97248A329A63C0D", hash_generated_field = "33AD605615015FDD75E5D9A4D89E75A5")

    private OpenOverflowRunnable mPostedOpenRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "ACE338A85A5CA6F16ACDF484D88C2420", hash_generated_field = "FEC720003D50479950C7720E8FE0EC06")

    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_field = "69B273247C1407653A216446C3964BA2", hash_generated_field = "0BCBB7C2003D06DDB90F4DA92F90C05F")

    int mOpenSubMenuId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.932 -0400", hash_original_method = "D92A82193E3FCDED5C9710083B861A1F", hash_generated_method = "E6DCC516EF7D40A6DADCD5498BA431E1")
    public  ActionMenuPresenter(Context context) {
        super(context, com.android.internal.R.layout.action_menu_layout,
                com.android.internal.R.layout.action_menu_item_layout);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.933 -0400", hash_original_method = "BC9545155A7D6BD0732B2C48FEAAA115", hash_generated_method = "DD2A7FB36E1178C0183FF14F11A82027")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        super.initForMenu(context, menu);
        final Resources res = context.getResources();
        {
            mReserveOverflow = !ViewConfiguration.get(context).hasPermanentMenuKey();
        } 
        {
            mWidthLimit = res.getDisplayMetrics().widthPixels / 2;
        } 
        {
            mMaxItems = res.getInteger(com.android.internal.R.integer.max_action_buttons);
        } 
        int width = mWidthLimit;
        {
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                final int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                mOverflowButton.measure(spec, spec);
            } 
            width -= mOverflowButton.getMeasuredWidth();
        } 
        {
            mOverflowButton = null;
        } 
        mActionItemWidthLimit = width;
        mMinCellSize = (int) (ActionMenuView.MIN_CELL_SIZE * res.getDisplayMetrics().density);
        mScrapActionButtonView = null;
        addTaint(menu.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.933 -0400", hash_original_method = "A17C8C9C29C5D048821A272E4E211244", hash_generated_method = "5102132AC300187B1AC034673FEADE8C")
    public void onConfigurationChanged(Configuration newConfig) {
        
        {
            mMaxItems = mContext.getResources().getInteger(
                    com.android.internal.R.integer.max_action_buttons);
            {
                mMenu.onItemsChanged(true);
            } 
        } 
        addTaint(newConfig.getTaint());
        
        
            
                    
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.934 -0400", hash_original_method = "EDE1166C9C5D6E2371538FA8BF1D31B5", hash_generated_method = "89721D0CEA79F09D9C0737AC06DA189B")
    public void setWidthLimit(int width, boolean strict) {
        mWidthLimit = width;
        mStrictWidthLimit = strict;
        mWidthLimitSet = true;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.934 -0400", hash_original_method = "9F648716EF61D229ED05FF998E104A97", hash_generated_method = "B64A2DDCBD4CDF5CA323C99F8D98CF86")
    public void setReserveOverflow(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        mReserveOverflowSet = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.934 -0400", hash_original_method = "481A608E0CFB48388247866BAE1C540A", hash_generated_method = "87E2B32D1F0B97A5238894F1E0A59883")
    public void setItemLimit(int itemCount) {
        mMaxItems = itemCount;
        mMaxItemsSet = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.934 -0400", hash_original_method = "28685D1CD5555D455AA1245A08028303", hash_generated_method = "DA8155DF8D4813D0B03173FE5C681E23")
    public void setExpandedActionViewsExclusive(boolean isExclusive) {
        mExpandedActionViewsExclusive = isExclusive;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.935 -0400", hash_original_method = "AD0B74E3B833D08F8481D15CB97EDB86", hash_generated_method = "57EA308F523283FD3D4C056BD5B5F4AD")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        MenuView varB4EAC82CA7396A68D541C85D26508E83_1185942394 = null; 
        MenuView result = super.getMenuView(root);
        ((ActionMenuView) result).setPresenter(this);
        varB4EAC82CA7396A68D541C85D26508E83_1185942394 = result;
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1185942394.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1185942394;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.936 -0400", hash_original_method = "59BA3C56A8058A32CF9B2FCB0A0B5507", hash_generated_method = "34FA694DF67E7C23191DDECE04C15740")
    @Override
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_2041976059 = null; 
        View actionView = item.getActionView();
        {
            boolean var042A2602C5874EB8C3227D44BE9ADF6F_86897841 = (actionView == null || item.hasCollapsibleActionView());
            {
                {
                    convertView = null;
                } 
                actionView = super.getItemView(item, convertView, parent);
            } 
        } 
        actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);
        final ActionMenuView menuParent = (ActionMenuView) parent;
        final ViewGroup.LayoutParams lp = actionView.getLayoutParams();
        {
            boolean var3F4E8E87992AC39D78E62AD5C121760F_988792660 = (!menuParent.checkLayoutParams(lp));
            {
                actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2041976059 = actionView;
        addTaint(item.getTaint());
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2041976059.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2041976059;
        
        
        
            
                
            
            
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.937 -0400", hash_original_method = "2F59AFEB76404A397084655FE3C87387", hash_generated_method = "5312B5449685EB2F76CBCE0D086FA936")
    @Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {
        itemView.initialize(item, 0);
        final ActionMenuView menuView = (ActionMenuView) mMenuView;
        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
        addTaint(item.getTaint());
        addTaint(itemView.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.937 -0400", hash_original_method = "CF6FF79E1183E432FB7F279F6A955298", hash_generated_method = "48870B11852FBA4EA780314C12F8D7CC")
    @Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        boolean var63CDEDD9ADF2A3E4CD65B5345E84754D_1078786556 = (item.isActionButton());
        addTaint(childIndex);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288189721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288189721;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.938 -0400", hash_original_method = "675BFE60E67D99082131CDB4BA0667CE", hash_generated_method = "12168C682F5FFFE3036DF049F5A60313")
    @Override
    public void updateMenuView(boolean cleared) {
        super.updateMenuView(cleared);
        {
            final ArrayList<MenuItemImpl> actionItems = mMenu.getActionItems();
            final int count = actionItems.size();
            {
                int i = 0;
                {
                    final ActionProvider provider = actionItems.get(i).getActionProvider();
                    {
                        provider.setSubUiVisibilityListener(this);
                    } 
                } 
            } 
        } 
        ArrayList<MenuItemImpl> nonActionItems;
        nonActionItems = mMenu.getNonActionItems();
        nonActionItems = null;
        boolean hasOverflow = false;
        {
            final int count = nonActionItems.size();
            {
                hasOverflow = !nonActionItems.get(0).isActionViewExpanded();
            } 
            {
                hasOverflow = count > 0;
            } 
        } 
        {
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
            } 
            ViewGroup parent = (ViewGroup) mOverflowButton.getParent();
            {
                {
                    parent.removeView(mOverflowButton);
                } 
                ActionMenuView menuView = (ActionMenuView) mMenuView;
                menuView.addView(mOverflowButton, menuView.generateOverflowButtonLayoutParams());
            } 
        } 
        {
            boolean var636A254D04624E67B4E275AE8C012F60_1079929534 = (mOverflowButton != null && mOverflowButton.getParent() == mMenuView);
            {
                ((ViewGroup) mMenuView).removeView(mOverflowButton);
            } 
        } 
        ((ActionMenuView) mMenuView).setOverflowReserved(mReserveOverflow);
        addTaint(cleared);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.938 -0400", hash_original_method = "9D8FC445B750A9A2E8805EF185920422", hash_generated_method = "52B524D3FB846E5E307F45FD1B12326A")
    @Override
    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        {
            boolean var2C5D3A435D4B7C5FC7DF763D994EC999_986037013 = (parent.getChildAt(childIndex) == mOverflowButton);
        } 
        boolean var7C223E5B8CEAE7D7BF100F1F8A9FA1B9_1973966938 = (super.filterLeftoverView(parent, childIndex));
        addTaint(parent.getTaint());
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663503313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663503313;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.939 -0400", hash_original_method = "37299DBD51D21A28CE7BE5283912D693", hash_generated_method = "85DAA915A632EAED151ED7607A5D7655")
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        
        {
            boolean var89D6F494337AE8363DF4B82D8D3CD4B2_1721211204 = (!subMenu.hasVisibleItems());
        } 
        SubMenuBuilder topSubMenu = subMenu;
        {
            boolean var3070E3EF1FB105EFCC31C47F14EB2042_265564690 = (topSubMenu.getParentMenu() != mMenu);
            {
                topSubMenu = (SubMenuBuilder) topSubMenu.getParentMenu();
            } 
        } 
        View anchor = findViewForItem(topSubMenu.getItem());
        {
            anchor = mOverflowButton;
        } 
        mOpenSubMenuId = subMenu.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, subMenu);
        mActionButtonPopup.setAnchorView(anchor);
        mActionButtonPopup.show();
        super.onSubMenuSelected(subMenu);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559623163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559623163;
        
        
        
        
            
        
        
        
            
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.940 -0400", hash_original_method = "D21215C119A8C9273D02F36683639F77", hash_generated_method = "2C24B2099874E34A68E5E0777F8BD2EB")
    private View findViewForItem(MenuItem item) {
        View varB4EAC82CA7396A68D541C85D26508E83_24930257 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1108263106 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_847939883 = null; 
        final ViewGroup parent = (ViewGroup) mMenuView;
        varB4EAC82CA7396A68D541C85D26508E83_24930257 = null;
        final int count = parent.getChildCount();
        {
            int i = 0;
            {
                final View child = parent.getChildAt(i);
                {
                    boolean var6A79BB2D965C162A835EA9549023D9A8_99692380 = (child instanceof MenuView.ItemView &&
                    ((MenuView.ItemView) child).getItemData() == item);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1108263106 = child;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_847939883 = null;
        addTaint(item.getTaint());
        View varA7E53CE21691AB073D9660D615818899_134837028; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_134837028 = varB4EAC82CA7396A68D541C85D26508E83_24930257;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_134837028 = varB4EAC82CA7396A68D541C85D26508E83_1108263106;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_134837028 = varB4EAC82CA7396A68D541C85D26508E83_847939883;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_134837028.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_134837028;
        
        
        
        
        
            
            
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.940 -0400", hash_original_method = "51D4B09F0769DB498C88D93C1DD1D610", hash_generated_method = "63726AA1D7E2FEAE9E8C3359909F3F26")
    public boolean showOverflowMenu() {
        {
            boolean varA5B27DD56A8D2501A2BC1F22BE54417E_227860601 = (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
                mPostedOpenRunnable == null);
            {
                OverflowPopup popup = new OverflowPopup(mContext, mMenu, mOverflowButton, true);
                mPostedOpenRunnable = new OpenOverflowRunnable(popup);
                ((View) mMenuView).post(mPostedOpenRunnable);
                super.onSubMenuSelected(null);
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707084742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707084742;
        
        
                
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.941 -0400", hash_original_method = "F07D2B002CE8D32774BDF7E27A216F8A", hash_generated_method = "873B7F2E33D70D0DD59C37B786323781")
    public boolean hideOverflowMenu() {
        {
            ((View) mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
        } 
        MenuPopupHelper popup = mOverflowPopup;
        {
            popup.dismiss();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906480182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906480182;
        
        
            
            
            
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.941 -0400", hash_original_method = "048650AFF94B01A571A17F813CE8142B", hash_generated_method = "56F3C5F6BBB3B18C936D1BA0A0D8CF51")
    public boolean dismissPopupMenus() {
        boolean result = hideOverflowMenu();
        result |= hideSubMenus();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912101406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912101406;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.941 -0400", hash_original_method = "86830002AFDFBC8C0790A0C80E395F68", hash_generated_method = "E1532A5515814EA3424E4F19209F75BB")
    public boolean hideSubMenus() {
        {
            mActionButtonPopup.dismiss();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968229027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968229027;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.942 -0400", hash_original_method = "EDFA99D71A654F51EBF8F88159FF0AE5", hash_generated_method = "8130FC4D8D360621F28F30FDE5EB6C4F")
    public boolean isOverflowMenuShowing() {
        boolean varDDE92196405694CCE3B775C2D317192F_1386735044 = (mOverflowPopup != null && mOverflowPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533050540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533050540;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.942 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "19B17410E4D66B80BBD0559EF9B13F79")
    public boolean isOverflowReserved() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163060282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163060282;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.943 -0400", hash_original_method = "3161CCF567C7C41004F1DD2E1141CBA5", hash_generated_method = "7CCA011B3EAF0A505D3E5480B2D8EBD2")
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
        {
            int i = 0;
            {
                MenuItemImpl item = visibleItems.get(i);
                {
                    boolean varD0608EF2260E1F8B9264901745B3863A_250396788 = (item.requiresActionButton());
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_1500306511 = (item.requestsActionButton());
                        {
                            hasOverflow = true;
                        } 
                    } 
                } 
                {
                    boolean varBBBF1208950B60080E53B87439022606_461713856 = (mExpandedActionViewsExclusive && item.isActionViewExpanded());
                    {
                        maxActions = 0;
                    } 
                } 
            } 
        } 
        maxActions -= requiredItems;
        final SparseBooleanArray seenGroups = mActionButtonGroups;
        seenGroups.clear();
        int cellSize = 0;
        int cellsRemaining = 0;
        {
            cellsRemaining = widthLimit / mMinCellSize;
            final int cellSizeRemaining = widthLimit % mMinCellSize;
            cellSize = mMinCellSize + cellSizeRemaining / cellsRemaining;
        } 
        {
            int i = 0;
            {
                MenuItemImpl item = visibleItems.get(i);
                {
                    boolean varD0608EF2260E1F8B9264901745B3863A_1987037736 = (item.requiresActionButton());
                    {
                        View v = getItemView(item, mScrapActionButtonView, parent);
                        {
                            mScrapActionButtonView = v;
                        } 
                        {
                            cellsRemaining -= ActionMenuView.measureChildForCells(v,
                            cellSize, cellsRemaining, querySpec, 0);
                        } 
                        {
                            v.measure(querySpec, querySpec);
                        } 
                        final int measuredWidth = v.getMeasuredWidth();
                        widthLimit -= measuredWidth;
                        {
                            firstActionWidth = measuredWidth;
                        } 
                        final int groupId = item.getGroupId();
                        {
                            seenGroups.put(groupId, true);
                        } 
                        item.setIsActionButton(true);
                    } 
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_886067665 = (item.requestsActionButton());
                        {
                            final int groupId = item.getGroupId();
                            final boolean inGroup = seenGroups.get(groupId);
                            boolean isAction = (maxActions > 0 || inGroup) && widthLimit > 0 &&
                        (!mStrictWidthLimit || cellsRemaining > 0);
                            {
                                View v = getItemView(item, mScrapActionButtonView, parent);
                                {
                                    mScrapActionButtonView = v;
                                } 
                                {
                                    final int cells = ActionMenuView.measureChildForCells(v,
                                cellSize, cellsRemaining, querySpec, 0);
                                    cellsRemaining -= cells;
                                    {
                                        isAction = false;
                                    } 
                                } 
                                {
                                    v.measure(querySpec, querySpec);
                                } 
                                final int measuredWidth = v.getMeasuredWidth();
                                widthLimit -= measuredWidth;
                                {
                                    firstActionWidth = measuredWidth;
                                } 
                                {
                                    isAction &= widthLimit >= 0;
                                } 
                                {
                                    isAction &= widthLimit + firstActionWidth > 0;
                                } 
                            } 
                            {
                                seenGroups.put(groupId, true);
                            } 
                            {
                                seenGroups.put(groupId, false);
                                {
                                    int j = 0;
                                    {
                                        MenuItemImpl areYouMyGroupie = visibleItems.get(j);
                                        {
                                            boolean var58D13C27DFD727DA00E5820FA84F8A98_1818420071 = (areYouMyGroupie.getGroupId() == groupId);
                                            {
                                                {
                                                    boolean var3845F6435C6D2EFBC5673BCA3826363D_162344842 = (areYouMyGroupie.isActionButton());
                                                } 
                                                areYouMyGroupie.setIsActionButton(false);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                            item.setIsActionButton(isAction);
                        } 
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707649472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707649472;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.944 -0400", hash_original_method = "C8ECD6F76386581509465FBD82905343", hash_generated_method = "04D5B832D8761AB87A15C6C47BBAACC6")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        
        dismissPopupMenus();
        super.onCloseMenu(menu, allMenusAreClosing);
        addTaint(menu.getTaint());
        addTaint(allMenusAreClosing);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.945 -0400", hash_original_method = "06AD8BBBF679989CAE04F426A0FFC61D", hash_generated_method = "C03E4E03D11152E124851403990DB89E")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_414253869 = null; 
        SavedState state = new SavedState();
        state.openSubMenuId = mOpenSubMenuId;
        varB4EAC82CA7396A68D541C85D26508E83_414253869 = state;
        varB4EAC82CA7396A68D541C85D26508E83_414253869.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_414253869;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.945 -0400", hash_original_method = "56321A468C9EBB2A9C3695363B6A634B", hash_generated_method = "1E88F880CC46113D05B455EB11E36CB4")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        SavedState saved = (SavedState) state;
        {
            MenuItem item = mMenu.findItem(saved.openSubMenuId);
            {
                SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                onSubMenuSelected(subMenu);
            } 
        } 
        addTaint(state.getTaint());
        
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.945 -0400", hash_original_method = "E6B8634A947A629174EE0649ED3769CC", hash_generated_method = "9038CE0FD8695612220BCFDB890B51CF")
    @Override
    public void onSubUiVisibilityChanged(boolean isVisible) {
        
        {
            super.onSubMenuSelected(null);
        } 
        {
            mMenu.close(false);
        } 
        addTaint(isVisible);
        
        
            
        
            
        
    }

    
    private static class SavedState implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.946 -0400", hash_original_field = "8151AAC0E48C8BC3EA418271F6C25581", hash_generated_field = "D108CA8004A7040C71E1AF0A426FBA46")

        public int openSubMenuId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.946 -0400", hash_original_method = "5B86CE655F475C08F177FDB52AD9ECFE", hash_generated_method = "4573F1D4704340137C4835179DE848FD")
          SavedState() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.947 -0400", hash_original_method = "10B6E86FE11BCC070EDA2136A91ED86D", hash_generated_method = "FC0C0D4D8A2B76282E9B2EAAF3EB5917")
          SavedState(Parcel in) {
            openSubMenuId = in.readInt();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.947 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FB81FDB4CEB435818762BA1B271FE20C")
        @Override
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426059755 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426059755;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.947 -0400", hash_original_method = "4E7F3A208B8DADACA56997D8D1B3C90C", hash_generated_method = "9DC85952E0B3AADEAFEA647BBFB0F735")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(openSubMenuId);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.948 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.948 -0400", hash_original_method = "1337D4EFD3D7C8CDCFFFFAE2F6FA113A", hash_generated_method = "C2CDE96F90A37867B61B1172B38B0583")
        public  OverflowMenuButton(Context context) {
            super(context, null, com.android.internal.R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(VISIBLE);
            setEnabled(true);
            addTaint(context.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.949 -0400", hash_original_method = "133A6BF2CD1B819427A8C49FA8B8E865", hash_generated_method = "F7777A17804A21A316201921BDE66F5C")
        @Override
        public boolean performClick() {
            {
                boolean var6267028C3644B44519A636F6B5EF90B1_1835876230 = (super.performClick());
            } 
            playSoundEffect(SoundEffectConstants.CLICK);
            showOverflowMenu();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1366599209 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1366599209;
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.950 -0400", hash_original_method = "6BA15F1E8189A4801AF337396791DD31", hash_generated_method = "1F85CFCC7E663C2E73F24AF230EBEBF6")
        public boolean needsDividerBefore() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457165050 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_457165050;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.951 -0400", hash_original_method = "CA065FAE0BB06CECFBFA2C36E268A066", hash_generated_method = "D6B31F1C2C560455C8058C43AB179B91")
        public boolean needsDividerAfter() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402273565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_402273565;
            
            
        }

        
    }


    
    private class OverflowPopup extends MenuPopupHelper {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.952 -0400", hash_original_method = "FA0F7CD1552EAFA7C13929825A8B2112", hash_generated_method = "A93A3B40EFAA7FACDC4053B7602AAE67")
        public  OverflowPopup(Context context, MenuBuilder menu, View anchorView,
                boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly);
            setCallback(mPopupPresenterCallback);
            addTaint(context.getTaint());
            addTaint(menu.getTaint());
            addTaint(anchorView.getTaint());
            addTaint(overflowOnly);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.953 -0400", hash_original_method = "F12BAE7D751DC96E6D1F67F68EBC9919", hash_generated_method = "C0B66E552A56F943AE8D17ED4BE5D635")
        @Override
        public void onDismiss() {
            
            super.onDismiss();
            mMenu.close();
            mOverflowPopup = null;
            
            
            
            
        }

        
    }


    
    private class ActionButtonSubmenu extends MenuPopupHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.953 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

        private SubMenuBuilder mSubMenu;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.954 -0400", hash_original_method = "E276DF3AF8ED38FB9CAF2E195F32B2B4", hash_generated_method = "1F2722F1998F4B569D8A17CF2657114A")
        public  ActionButtonSubmenu(Context context, SubMenuBuilder subMenu) {
            super(context, subMenu);
            mSubMenu = subMenu;
            MenuItemImpl item = (MenuItemImpl) subMenu.getItem();
            {
                boolean var578FB4F95786C0DE176C492E48EDBCE4_911747506 = (!item.isActionButton());
                {
                    setAnchorView(mOverflowButton == null ? (View) mMenuView : mOverflowButton);
                } 
            } 
            setCallback(mPopupPresenterCallback);
            boolean preserveIconSpacing = false;
            final int count = subMenu.size();
            {
                int i = 0;
                {
                    MenuItem childItem = subMenu.getItem(i);
                    {
                        boolean var85A149AB5F872C1FDE25CE93041B2D49_760048271 = (childItem.isVisible() && childItem.getIcon() != null);
                        {
                            preserveIconSpacing = true;
                        } 
                    } 
                } 
            } 
            setForceShowIcon(preserveIconSpacing);
            addTaint(context.getTaint());
            
            
            
            
                
            
            
            
            
            
                
                
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.954 -0400", hash_original_method = "69C0D5A7A155D8F50134B9E617767128", hash_generated_method = "351F511E80FA2706234E40E36A6C89F9")
        @Override
        public void onDismiss() {
            
            super.onDismiss();
            mActionButtonPopup = null;
            mOpenSubMenuId = 0;
            
            
            
            
        }

        
    }


    
    private class PopupPresenterCallback implements MenuPresenter.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.955 -0400", hash_original_method = "094885FACF5CDEF923542BEFD4BC4936", hash_generated_method = "094885FACF5CDEF923542BEFD4BC4936")
        public PopupPresenterCallback ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.955 -0400", hash_original_method = "29547EA8801B28CE842E58C3B2A91712", hash_generated_method = "7D316FA3B5D0E1818D54C041EDD6CAEF")
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            
            mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            addTaint(subMenu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_956704207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_956704207;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.956 -0400", hash_original_method = "847A197D3775740590913F0AAA0D3207", hash_generated_method = "346D48DB65EC536A8B0327D580C6F3D2")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            
            {
                ((SubMenuBuilder) menu).getRootMenu().close(false);
            } 
            addTaint(menu.getTaint());
            addTaint(allMenusAreClosing);
            
            
                
            
        }

        
    }


    
    private class OpenOverflowRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.956 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "A7832614732810CD7F68AEA244EAE6B6")

        private OverflowPopup mPopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.957 -0400", hash_original_method = "599E88E0D73270F72B5C8D6A6C7D2ACA", hash_generated_method = "83EF72038C4C6F336D91E4FDD7DBA957")
        public  OpenOverflowRunnable(OverflowPopup popup) {
            mPopup = popup;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.957 -0400", hash_original_method = "A205A4B8116FA6A00F9203B1BEAEE8C7", hash_generated_method = "6C8248219E3F37877F3CB8395443C87F")
        public void run() {
            mMenu.changeMenuMode();
            final View menuView = (View) mMenuView;
            {
                boolean var3552093DD787185B5C9D0DFE6D6F1BD0_131701573 = (menuView != null && menuView.getWindowToken() != null && mPopup.tryShow());
                {
                    mOverflowPopup = mPopup;
                } 
            } 
            mPostedOpenRunnable = null;
            
            
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.957 -0400", hash_original_field = "E83447013E3A959D82815F43151988FB", hash_generated_field = "365B884CA8B9956B388F21B4CE2AED12")

    private static final String TAG = "ActionMenuPresenter";
}

