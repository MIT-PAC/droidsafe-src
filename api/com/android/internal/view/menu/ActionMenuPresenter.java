package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;

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

import com.android.internal.view.menu.ActionMenuView.ActionMenuChildView;






public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "18A904A5C0CC1E1FE45C814D28B71B26", hash_generated_field = "62B115CA56547ACC4395C5191DCAFA48")

    private View mOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "0E213F9463B6EFE55ADA2109C5E5DC56", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "FF60A156CE7AD39BD5FB673AFD302D5B", hash_generated_field = "8AA1ADBD5C3D9FA8BD4CE08655C7BAEC")

    private boolean mReserveOverflowSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "83EF65FD766EAC154AE5FEA63E2CE25A", hash_generated_field = "D519A6354FF6027B8318E0E8A1847729")

    private int mWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "A7E9006F830347B6496E603E3A3EFC82", hash_generated_field = "EE263C3BDAD9F74C57B87B4D53F4A7F2")

    private int mActionItemWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "0FFA0622B0631C3E765DE6810D1D5BEE", hash_generated_field = "46A54E1F46C2CF0E99FFE4A07B201C3C")

    private int mMaxItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "0EBB7A0928E7934DA0F5EC0C1A2EF0AA", hash_generated_field = "E8BC6B5172B218C6C49A6690AFA86C5B")

    private boolean mMaxItemsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "428FC947ACD187E12AF96B1282A02E84", hash_generated_field = "5992037AC4E6034F7F17925E51ACE390")

    private boolean mStrictWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "BEC7BC02B14F4AE2D2525ECA9C34A88C", hash_generated_field = "896F729C22C3B090A4F37324F1470F98")

    private boolean mWidthLimitSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "B912C176D59A2C01DCA72A9AB2E2D62B", hash_generated_field = "609B8E14C3F57F0FDE596A9E3115E316")

    private boolean mExpandedActionViewsExclusive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "C0CB7E511A75AFCB98C3B0342F6802E9", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "4A448DC9861F25A2BD03E23A029BD7C0", hash_generated_field = "AB745D0096A474765505150A34296B41")

    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "86CDD986D39C84A497FF93C26971615A", hash_generated_field = "62CE63FA1996B79D9E9EE4493D96FB92")

    private View mScrapActionButtonView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "12E0F70E3294B5917D9DCD47A20C5330", hash_generated_field = "73011FFFEE53F9056EE81430FCFEDF05")

    private OverflowPopup mOverflowPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "8A4CED1EBB8A308B59EEEF4C102ECD26", hash_generated_field = "BAF3D98693011134EB1620D1BA22CC15")

    private ActionButtonSubmenu mActionButtonPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "8BA73CE13504EDF3C97248A329A63C0D", hash_generated_field = "33AD605615015FDD75E5D9A4D89E75A5")

    private OpenOverflowRunnable mPostedOpenRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "ACE338A85A5CA6F16ACDF484D88C2420", hash_generated_field = "FEC720003D50479950C7720E8FE0EC06")

    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.981 -0400", hash_original_field = "69B273247C1407653A216446C3964BA2", hash_generated_field = "0BCBB7C2003D06DDB90F4DA92F90C05F")

    int mOpenSubMenuId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.982 -0400", hash_original_method = "D92A82193E3FCDED5C9710083B861A1F", hash_generated_method = "E6DCC516EF7D40A6DADCD5498BA431E1")
    public  ActionMenuPresenter(Context context) {
        super(context, com.android.internal.R.layout.action_menu_layout,
                com.android.internal.R.layout.action_menu_item_layout);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.983 -0400", hash_original_method = "BC9545155A7D6BD0732B2C48FEAAA115", hash_generated_method = "950D19F648EEAB27054A68D49D9BC992")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        addTaint(menu.getTaint());
        super.initForMenu(context, menu);
        final Resources res = context.getResources();
        if(!mReserveOverflowSet)        
        {
            mReserveOverflow = !ViewConfiguration.get(context).hasPermanentMenuKey();
        } //End block
        if(!mWidthLimitSet)        
        {
            mWidthLimit = res.getDisplayMetrics().widthPixels / 2;
        } //End block
        if(!mMaxItemsSet)        
        {
            mMaxItems = res.getInteger(com.android.internal.R.integer.max_action_buttons);
        } //End block
        int width = mWidthLimit;
        if(mReserveOverflow)        
        {
            if(mOverflowButton == null)            
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                final int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                mOverflowButton.measure(spec, spec);
            } //End block
            width -= mOverflowButton.getMeasuredWidth();
        } //End block
        else
        {
            mOverflowButton = null;
        } //End block
        mActionItemWidthLimit = width;
        mMinCellSize = (int) (ActionMenuView.MIN_CELL_SIZE * res.getDisplayMetrics().density);
        mScrapActionButtonView = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.985 -0400", hash_original_method = "A17C8C9C29C5D048821A272E4E211244", hash_generated_method = "7B14B2091BFBADDDF655305027558A71")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        if(!mMaxItemsSet)        
        {
            mMaxItems = mContext.getResources().getInteger(
                    com.android.internal.R.integer.max_action_buttons);
            if(mMenu != null)            
            {
                mMenu.onItemsChanged(true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!mMaxItemsSet) {
            //mMaxItems = mContext.getResources().getInteger(
                    //com.android.internal.R.integer.max_action_buttons);
            //if (mMenu != null) {
                //mMenu.onItemsChanged(true);
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.986 -0400", hash_original_method = "EDE1166C9C5D6E2371538FA8BF1D31B5", hash_generated_method = "89721D0CEA79F09D9C0737AC06DA189B")
    public void setWidthLimit(int width, boolean strict) {
        mWidthLimit = width;
        mStrictWidthLimit = strict;
        mWidthLimitSet = true;
        // ---------- Original Method ----------
        //mWidthLimit = width;
        //mStrictWidthLimit = strict;
        //mWidthLimitSet = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.986 -0400", hash_original_method = "9F648716EF61D229ED05FF998E104A97", hash_generated_method = "B64A2DDCBD4CDF5CA323C99F8D98CF86")
    public void setReserveOverflow(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        mReserveOverflowSet = true;
        // ---------- Original Method ----------
        //mReserveOverflow = reserveOverflow;
        //mReserveOverflowSet = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.987 -0400", hash_original_method = "481A608E0CFB48388247866BAE1C540A", hash_generated_method = "87E2B32D1F0B97A5238894F1E0A59883")
    public void setItemLimit(int itemCount) {
        mMaxItems = itemCount;
        mMaxItemsSet = true;
        // ---------- Original Method ----------
        //mMaxItems = itemCount;
        //mMaxItemsSet = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.987 -0400", hash_original_method = "28685D1CD5555D455AA1245A08028303", hash_generated_method = "DA8155DF8D4813D0B03173FE5C681E23")
    public void setExpandedActionViewsExclusive(boolean isExclusive) {
        mExpandedActionViewsExclusive = isExclusive;
        // ---------- Original Method ----------
        //mExpandedActionViewsExclusive = isExclusive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.987 -0400", hash_original_method = "AD0B74E3B833D08F8481D15CB97EDB86", hash_generated_method = "BCFC1E2356B6EAA63C1AD1273E7CE1A6")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        addTaint(root.getTaint());
        MenuView result = super.getMenuView(root);
        ((ActionMenuView) result).setPresenter(this);
MenuView varDC838461EE2FA0CA4C9BBB70A15456B0_1652482953 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1652482953.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1652482953;
        // ---------- Original Method ----------
        //MenuView result = super.getMenuView(root);
        //((ActionMenuView) result).setPresenter(this);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.988 -0400", hash_original_method = "59BA3C56A8058A32CF9B2FCB0A0B5507", hash_generated_method = "2ECBFC3F16E547903AF5FA1E78612B56")
    @Override
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(item.getTaint());
        View actionView = item.getActionView();
        if(actionView == null || item.hasCollapsibleActionView())        
        {
            if(!(convertView instanceof ActionMenuItemView))            
            {
                convertView = null;
            } //End block
            actionView = super.getItemView(item, convertView, parent);
        } //End block
        actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);
        final ActionMenuView menuParent = (ActionMenuView) parent;
        final ViewGroup.LayoutParams lp = actionView.getLayoutParams();
        if(!menuParent.checkLayoutParams(lp))        
        {
            actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
        } //End block
View var9FA9E3D1D53E248EBA38D0D6FCF32267_1268371811 =         actionView;
        var9FA9E3D1D53E248EBA38D0D6FCF32267_1268371811.addTaint(taint);
        return var9FA9E3D1D53E248EBA38D0D6FCF32267_1268371811;
        // ---------- Original Method ----------
        //View actionView = item.getActionView();
        //if (actionView == null || item.hasCollapsibleActionView()) {
            //if (!(convertView instanceof ActionMenuItemView)) {
                //convertView = null;
            //}
            //actionView = super.getItemView(item, convertView, parent);
        //}
        //actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);
        //final ActionMenuView menuParent = (ActionMenuView) parent;
        //final ViewGroup.LayoutParams lp = actionView.getLayoutParams();
        //if (!menuParent.checkLayoutParams(lp)) {
            //actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
        //}
        //return actionView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.989 -0400", hash_original_method = "2F59AFEB76404A397084655FE3C87387", hash_generated_method = "BFE9CF3E08C0DBA3AD7CBCEB4F9B5B16")
    @Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {
        addTaint(itemView.getTaint());
        addTaint(item.getTaint());
        itemView.initialize(item, 0);
        final ActionMenuView menuView = (ActionMenuView) mMenuView;
        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
        // ---------- Original Method ----------
        //itemView.initialize(item, 0);
        //final ActionMenuView menuView = (ActionMenuView) mMenuView;
        //ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        //actionItemView.setItemInvoker(menuView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.989 -0400", hash_original_method = "CF6FF79E1183E432FB7F279F6A955298", hash_generated_method = "C1E53B4E4F5241F8DC4D74A662DD83A1")
    @Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(childIndex);
        boolean varF2B5E9D02E6FD6281C5F58A7FE7E4A26_776085089 = (item.isActionButton());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370414460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370414460;
        // ---------- Original Method ----------
        //return item.isActionButton();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.990 -0400", hash_original_method = "675BFE60E67D99082131CDB4BA0667CE", hash_generated_method = "D0D7EE23EED2D2F2A26E9BCDDE68CAC3")
    @Override
    public void updateMenuView(boolean cleared) {
        addTaint(cleared);
        super.updateMenuView(cleared);
        if(mMenu != null)        
        {
            final ArrayList<MenuItemImpl> actionItems = mMenu.getActionItems();
            final int count = actionItems.size();
for(int i = 0;i < count;i++)
            {
                final ActionProvider provider = actionItems.get(i).getActionProvider();
                if(provider != null)                
                {
                    provider.setSubUiVisibilityListener(this);
                } //End block
            } //End block
        } //End block
        final ArrayList<MenuItemImpl> nonActionItems = mMenu != null ?
                mMenu.getNonActionItems() : null;
        boolean hasOverflow = false;
        if(mReserveOverflow && nonActionItems != null)        
        {
            final int count = nonActionItems.size();
            if(count == 1)            
            {
                hasOverflow = !nonActionItems.get(0).isActionViewExpanded();
            } //End block
            else
            {
                hasOverflow = count > 0;
            } //End block
        } //End block
        if(hasOverflow)        
        {
            if(mOverflowButton == null)            
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
            } //End block
            ViewGroup parent = (ViewGroup) mOverflowButton.getParent();
            if(parent != mMenuView)            
            {
                if(parent != null)                
                {
                    parent.removeView(mOverflowButton);
                } //End block
                ActionMenuView menuView = (ActionMenuView) mMenuView;
                menuView.addView(mOverflowButton, menuView.generateOverflowButtonLayoutParams());
            } //End block
        } //End block
        else
        if(mOverflowButton != null && mOverflowButton.getParent() == mMenuView)        
        {
            ((ViewGroup) mMenuView).removeView(mOverflowButton);
        } //End block
        ((ActionMenuView) mMenuView).setOverflowReserved(mReserveOverflow);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.991 -0400", hash_original_method = "9D8FC445B750A9A2E8805EF185920422", hash_generated_method = "E3275C856CFAEAC3B6C95A1DA608CB73")
    @Override
    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        addTaint(childIndex);
        addTaint(parent.getTaint());
        if(parent.getChildAt(childIndex) == mOverflowButton)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1168166526 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225470328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225470328;
        }
        boolean varBB0CCEB8105BB714C10CAE9AFBF070E5_13393341 = (super.filterLeftoverView(parent, childIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806784120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806784120;
        // ---------- Original Method ----------
        //if (parent.getChildAt(childIndex) == mOverflowButton) return false;
        //return super.filterLeftoverView(parent, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.991 -0400", hash_original_method = "37299DBD51D21A28CE7BE5283912D693", hash_generated_method = "3FB204B1584B4D50B5696CB7B4FA8A08")
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(!subMenu.hasVisibleItems())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1391082887 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849728395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849728395;
        }
        SubMenuBuilder topSubMenu = subMenu;
        while
(topSubMenu.getParentMenu() != mMenu)        
        {
            topSubMenu = (SubMenuBuilder) topSubMenu.getParentMenu();
        } //End block
        View anchor = findViewForItem(topSubMenu.getItem());
        if(anchor == null)        
        {
            if(mOverflowButton == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_777507575 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076669450 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076669450;
            }
            anchor = mOverflowButton;
        } //End block
        mOpenSubMenuId = subMenu.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, subMenu);
        mActionButtonPopup.setAnchorView(anchor);
        mActionButtonPopup.show();
        super.onSubMenuSelected(subMenu);
        boolean varB326B5062B2F0E69046810717534CB09_1802107975 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779459412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779459412;
        // ---------- Original Method ----------
        //if (!subMenu.hasVisibleItems()) return false;
        //SubMenuBuilder topSubMenu = subMenu;
        //while (topSubMenu.getParentMenu() != mMenu) {
            //topSubMenu = (SubMenuBuilder) topSubMenu.getParentMenu();
        //}
        //View anchor = findViewForItem(topSubMenu.getItem());
        //if (anchor == null) {
            //if (mOverflowButton == null) return false;
            //anchor = mOverflowButton;
        //}
        //mOpenSubMenuId = subMenu.getItem().getItemId();
        //mActionButtonPopup = new ActionButtonSubmenu(mContext, subMenu);
        //mActionButtonPopup.setAnchorView(anchor);
        //mActionButtonPopup.show();
        //super.onSubMenuSelected(subMenu);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.992 -0400", hash_original_method = "D21215C119A8C9273D02F36683639F77", hash_generated_method = "E0C051D7F445AE6F94210E095DE93C38")
    private View findViewForItem(MenuItem item) {
        addTaint(item.getTaint());
        final ViewGroup parent = (ViewGroup) mMenuView;
        if(parent == null)        
        {
View var540C13E9E156B687226421B24F2DF178_653922811 =         null;
        var540C13E9E156B687226421B24F2DF178_653922811.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_653922811;
        }
        final int count = parent.getChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = parent.getChildAt(i);
            if(child instanceof MenuView.ItemView &&
                    ((MenuView.ItemView) child).getItemData() == item)            
            {
View var73902FD3E151130B4329B76EF04D2A54_2116692691 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_2116692691.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_2116692691;
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_1887737141 =         null;
        var540C13E9E156B687226421B24F2DF178_1887737141.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1887737141;
        // ---------- Original Method ----------
        //final ViewGroup parent = (ViewGroup) mMenuView;
        //if (parent == null) return null;
        //final int count = parent.getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View child = parent.getChildAt(i);
            //if (child instanceof MenuView.ItemView &&
                    //((MenuView.ItemView) child).getItemData() == item) {
                //return child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.993 -0400", hash_original_method = "51D4B09F0769DB498C88D93C1DD1D610", hash_generated_method = "1F9E73E3D447B394FBE8F62E6F1B1348")
    public boolean showOverflowMenu() {
        if(mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
                mPostedOpenRunnable == null)        
        {
            OverflowPopup popup = new OverflowPopup(mContext, mMenu, mOverflowButton, true);
            mPostedOpenRunnable = new OpenOverflowRunnable(popup);
            ((View) mMenuView).post(mPostedOpenRunnable);
            super.onSubMenuSelected(null);
            boolean varB326B5062B2F0E69046810717534CB09_1367411358 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249456849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_249456849;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_466914534 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451889245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451889245;
        // ---------- Original Method ----------
        //if (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
                //mPostedOpenRunnable == null) {
            //OverflowPopup popup = new OverflowPopup(mContext, mMenu, mOverflowButton, true);
            //mPostedOpenRunnable = new OpenOverflowRunnable(popup);
            //((View) mMenuView).post(mPostedOpenRunnable);
            //super.onSubMenuSelected(null);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.994 -0400", hash_original_method = "F07D2B002CE8D32774BDF7E27A216F8A", hash_generated_method = "BD8DF62350FDFB66832CE3295FD8A887")
    public boolean hideOverflowMenu() {
        if(mPostedOpenRunnable != null && mMenuView != null)        
        {
            ((View) mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
            boolean varB326B5062B2F0E69046810717534CB09_1814369821 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69528885 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_69528885;
        } //End block
        MenuPopupHelper popup = mOverflowPopup;
        if(popup != null)        
        {
            popup.dismiss();
            boolean varB326B5062B2F0E69046810717534CB09_1123677956 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987423565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_987423565;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1459003544 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094531648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094531648;
        // ---------- Original Method ----------
        //if (mPostedOpenRunnable != null && mMenuView != null) {
            //((View) mMenuView).removeCallbacks(mPostedOpenRunnable);
            //mPostedOpenRunnable = null;
            //return true;
        //}
        //MenuPopupHelper popup = mOverflowPopup;
        //if (popup != null) {
            //popup.dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.995 -0400", hash_original_method = "048650AFF94B01A571A17F813CE8142B", hash_generated_method = "BE59D21A77896E88ECF08F5E3EA40D7B")
    public boolean dismissPopupMenus() {
        boolean result = hideOverflowMenu();
        result |= hideSubMenus();
        boolean varB4A88417B3D0170D754C647C30B7216A_1010283914 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001860558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001860558;
        // ---------- Original Method ----------
        //boolean result = hideOverflowMenu();
        //result |= hideSubMenus();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.995 -0400", hash_original_method = "86830002AFDFBC8C0790A0C80E395F68", hash_generated_method = "B4AAA3DF0901852A2EBEEEABFFF88FCF")
    public boolean hideSubMenus() {
        if(mActionButtonPopup != null)        
        {
            mActionButtonPopup.dismiss();
            boolean varB326B5062B2F0E69046810717534CB09_396599831 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971205237 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971205237;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_760710695 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_365149559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_365149559;
        // ---------- Original Method ----------
        //if (mActionButtonPopup != null) {
            //mActionButtonPopup.dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.996 -0400", hash_original_method = "EDFA99D71A654F51EBF8F88159FF0AE5", hash_generated_method = "4BEFCC588AC5F07C38FFC13DDDD3A1BA")
    public boolean isOverflowMenuShowing() {
        boolean varB58C7D4F238868837BE1D2E02537B024_109768731 = (mOverflowPopup != null && mOverflowPopup.isShowing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114223154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114223154;
        // ---------- Original Method ----------
        //return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.996 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "F2051EB377843FAC784DEC5C4C9ED344")
    public boolean isOverflowReserved() {
        boolean var0E213F9463B6EFE55ADA2109C5E5DC56_578898718 = (mReserveOverflow);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2080031756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2080031756;
        // ---------- Original Method ----------
        //return mReserveOverflow;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.999 -0400", hash_original_method = "3161CCF567C7C41004F1DD2E1141CBA5", hash_generated_method = "55525A6B4CD2AEEBE9DC95CD0A84D64A")
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
for(int i = 0;i < itemsSize;i++)
        {
            MenuItemImpl item = visibleItems.get(i);
            if(item.requiresActionButton())            
            {
                requiredItems++;
            } //End block
            else
            if(item.requestsActionButton())            
            {
                requestedItems++;
            } //End block
            else
            {
                hasOverflow = true;
            } //End block
            if(mExpandedActionViewsExclusive && item.isActionViewExpanded())            
            {
                maxActions = 0;
            } //End block
        } //End block
        if(mReserveOverflow &&
                (hasOverflow || requiredItems + requestedItems > maxActions))        
        {
            maxActions--;
        } //End block
        maxActions -= requiredItems;
        final SparseBooleanArray seenGroups = mActionButtonGroups;
        seenGroups.clear();
        int cellSize = 0;
        int cellsRemaining = 0;
        if(mStrictWidthLimit)        
        {
            cellsRemaining = widthLimit / mMinCellSize;
            final int cellSizeRemaining = widthLimit % mMinCellSize;
            cellSize = mMinCellSize + cellSizeRemaining / cellsRemaining;
        } //End block
for(int i = 0;i < itemsSize;i++)
        {
            MenuItemImpl item = visibleItems.get(i);
            if(item.requiresActionButton())            
            {
                View v = getItemView(item, mScrapActionButtonView, parent);
                if(mScrapActionButtonView == null)                
                {
                    mScrapActionButtonView = v;
                } //End block
                if(mStrictWidthLimit)                
                {
                    cellsRemaining -= ActionMenuView.measureChildForCells(v,
                            cellSize, cellsRemaining, querySpec, 0);
                } //End block
                else
                {
                    v.measure(querySpec, querySpec);
                } //End block
                final int measuredWidth = v.getMeasuredWidth();
                widthLimit -= measuredWidth;
                if(firstActionWidth == 0)                
                {
                    firstActionWidth = measuredWidth;
                } //End block
                final int groupId = item.getGroupId();
                if(groupId != 0)                
                {
                    seenGroups.put(groupId, true);
                } //End block
                item.setIsActionButton(true);
            } //End block
            else
            if(item.requestsActionButton())            
            {
                final int groupId = item.getGroupId();
                final boolean inGroup = seenGroups.get(groupId);
                boolean isAction = (maxActions > 0 || inGroup) && widthLimit > 0 &&
                        (!mStrictWidthLimit || cellsRemaining > 0);
                if(isAction)                
                {
                    View v = getItemView(item, mScrapActionButtonView, parent);
                    if(mScrapActionButtonView == null)                    
                    {
                        mScrapActionButtonView = v;
                    } //End block
                    if(mStrictWidthLimit)                    
                    {
                        final int cells = ActionMenuView.measureChildForCells(v,
                                cellSize, cellsRemaining, querySpec, 0);
                        cellsRemaining -= cells;
                        if(cells == 0)                        
                        {
                            isAction = false;
                        } //End block
                    } //End block
                    else
                    {
                        v.measure(querySpec, querySpec);
                    } //End block
                    final int measuredWidth = v.getMeasuredWidth();
                    widthLimit -= measuredWidth;
                    if(firstActionWidth == 0)                    
                    {
                        firstActionWidth = measuredWidth;
                    } //End block
                    if(mStrictWidthLimit)                    
                    {
                        isAction &= widthLimit >= 0;
                    } //End block
                    else
                    {
                        isAction &= widthLimit + firstActionWidth > 0;
                    } //End block
                } //End block
                if(isAction && groupId != 0)                
                {
                    seenGroups.put(groupId, true);
                } //End block
                else
                if(inGroup)                
                {
                    seenGroups.put(groupId, false);
for(int j = 0;j < i;j++)
                    {
                        MenuItemImpl areYouMyGroupie = visibleItems.get(j);
                        if(areYouMyGroupie.getGroupId() == groupId)                        
                        {
                            if(areYouMyGroupie.isActionButton())                            
                            maxActions++;
                            areYouMyGroupie.setIsActionButton(false);
                        } //End block
                    } //End block
                } //End block
                if(isAction)                
                maxActions--;
                item.setIsActionButton(isAction);
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_909547203 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630349934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_630349934;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.000 -0400", hash_original_method = "C8ECD6F76386581509465FBD82905343", hash_generated_method = "53CDA7B39B2D084C41A6AD952CE25F93")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
        dismissPopupMenus();
        super.onCloseMenu(menu, allMenusAreClosing);
        // ---------- Original Method ----------
        //dismissPopupMenus();
        //super.onCloseMenu(menu, allMenusAreClosing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.000 -0400", hash_original_method = "06AD8BBBF679989CAE04F426A0FFC61D", hash_generated_method = "0B9D79C66D75C8C3FD44ACDD131F3AC5")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState state = new SavedState();
        state.openSubMenuId = mOpenSubMenuId;
Parcelable var37C56C9D63C623261861C16DCFB73F6D_1863703179 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1863703179.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1863703179;
        // ---------- Original Method ----------
        //SavedState state = new SavedState();
        //state.openSubMenuId = mOpenSubMenuId;
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.001 -0400", hash_original_method = "56321A468C9EBB2A9C3695363B6A634B", hash_generated_method = "6395FECB88E35C3CA9A72BD51549D49B")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState saved = (SavedState) state;
        if(saved.openSubMenuId > 0)        
        {
            MenuItem item = mMenu.findItem(saved.openSubMenuId);
            if(item != null)            
            {
                SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                onSubMenuSelected(subMenu);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //SavedState saved = (SavedState) state;
        //if (saved.openSubMenuId > 0) {
            //MenuItem item = mMenu.findItem(saved.openSubMenuId);
            //if (item != null) {
                //SubMenuBuilder subMenu = (SubMenuBuilder) item.getSubMenu();
                //onSubMenuSelected(subMenu);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.001 -0400", hash_original_method = "E6B8634A947A629174EE0649ED3769CC", hash_generated_method = "44133104A4FD8F668C3FCB608ACDA093")
    @Override
    public void onSubUiVisibilityChanged(boolean isVisible) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(isVisible);
        if(isVisible)        
        {
            super.onSubMenuSelected(null);
        } //End block
        else
        {
            mMenu.close(false);
        } //End block
        // ---------- Original Method ----------
        //if (isVisible) {
            //super.onSubMenuSelected(null);
        //} else {
            //mMenu.close(false);
        //}
    }

    
    private static class SavedState implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.001 -0400", hash_original_field = "8151AAC0E48C8BC3EA418271F6C25581", hash_generated_field = "D108CA8004A7040C71E1AF0A426FBA46")

        public int openSubMenuId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.001 -0400", hash_original_method = "5B86CE655F475C08F177FDB52AD9ECFE", hash_generated_method = "4573F1D4704340137C4835179DE848FD")
          SavedState() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.002 -0400", hash_original_method = "10B6E86FE11BCC070EDA2136A91ED86D", hash_generated_method = "FC0C0D4D8A2B76282E9B2EAAF3EB5917")
          SavedState(Parcel in) {
            openSubMenuId = in.readInt();
            // ---------- Original Method ----------
            //openSubMenuId = in.readInt();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.002 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0768DA889234ABA98B4E9E6A4EE21E33")
        @Override
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_952362257 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010217730 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1010217730;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.002 -0400", hash_original_method = "4E7F3A208B8DADACA56997D8D1B3C90C", hash_generated_method = "44572D25927B82A3F70CAE1291043BCC")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(openSubMenuId);
            // ---------- Original Method ----------
            //dest.writeInt(openSubMenuId);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.002 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.002 -0400", hash_original_method = "1337D4EFD3D7C8CDCFFFFAE2F6FA113A", hash_generated_method = "4DB9263AE780AEA93B9544E1C269216A")
        public  OverflowMenuButton(Context context) {
            super(context, null, com.android.internal.R.attr.actionOverflowButtonStyle);
            addTaint(context.getTaint());
            setClickable(true);
            setFocusable(true);
            setVisibility(VISIBLE);
            setEnabled(true);
            // ---------- Original Method ----------
            //setClickable(true);
            //setFocusable(true);
            //setVisibility(VISIBLE);
            //setEnabled(true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.003 -0400", hash_original_method = "133A6BF2CD1B819427A8C49FA8B8E865", hash_generated_method = "7A09BDCF93BB7FC3A41D01833456308A")
        @Override
        public boolean performClick() {
            if(super.performClick())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_816793243 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229083836 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_229083836;
            } //End block
            playSoundEffect(SoundEffectConstants.CLICK);
            showOverflowMenu();
            boolean varB326B5062B2F0E69046810717534CB09_335857677 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85803648 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_85803648;
            // ---------- Original Method ----------
            //if (super.performClick()) {
                //return true;
            //}
            //playSoundEffect(SoundEffectConstants.CLICK);
            //showOverflowMenu();
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.003 -0400", hash_original_method = "6BA15F1E8189A4801AF337396791DD31", hash_generated_method = "6159CBB70BEAD06EB97C60A2D02094EC")
        public boolean needsDividerBefore() {
            boolean var68934A3E9455FA72420237EB05902327_469294093 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47774397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_47774397;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.003 -0400", hash_original_method = "CA065FAE0BB06CECFBFA2C36E268A066", hash_generated_method = "6694F9FB547FF02043404AB863333223")
        public boolean needsDividerAfter() {
            boolean var68934A3E9455FA72420237EB05902327_1952161692 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073237500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073237500;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    private class OverflowPopup extends MenuPopupHelper {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.003 -0400", hash_original_method = "FA0F7CD1552EAFA7C13929825A8B2112", hash_generated_method = "6F3A8882B5EC6D92C00AC88F561558AF")
        public  OverflowPopup(Context context, MenuBuilder menu, View anchorView,
                boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly);
            addTaint(overflowOnly);
            addTaint(anchorView.getTaint());
            addTaint(menu.getTaint());
            addTaint(context.getTaint());
            setCallback(mPopupPresenterCallback);
            // ---------- Original Method ----------
            //setCallback(mPopupPresenterCallback);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.003 -0400", hash_original_method = "F12BAE7D751DC96E6D1F67F68EBC9919", hash_generated_method = "C0B66E552A56F943AE8D17ED4BE5D635")
        @Override
        public void onDismiss() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onDismiss();
            mMenu.close();
            mOverflowPopup = null;
            // ---------- Original Method ----------
            //super.onDismiss();
            //mMenu.close();
            //mOverflowPopup = null;
        }

        
    }


    
    private class ActionButtonSubmenu extends MenuPopupHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.003 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

        private SubMenuBuilder mSubMenu;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.004 -0400", hash_original_method = "E276DF3AF8ED38FB9CAF2E195F32B2B4", hash_generated_method = "CF93AE7D6738F2E0B1F5EF3A1BAF12CF")
        public  ActionButtonSubmenu(Context context, SubMenuBuilder subMenu) {
            super(context, subMenu);
            addTaint(context.getTaint());
            mSubMenu = subMenu;
            MenuItemImpl item = (MenuItemImpl) subMenu.getItem();
            if(!item.isActionButton())            
            {
                setAnchorView(mOverflowButton == null ? (View) mMenuView : mOverflowButton);
            } //End block
            setCallback(mPopupPresenterCallback);
            boolean preserveIconSpacing = false;
            final int count = subMenu.size();
for(int i = 0;i < count;i++)
            {
                MenuItem childItem = subMenu.getItem(i);
                if(childItem.isVisible() && childItem.getIcon() != null)                
                {
                    preserveIconSpacing = true;
                    break;
                } //End block
            } //End block
            setForceShowIcon(preserveIconSpacing);
            // ---------- Original Method ----------
            //mSubMenu = subMenu;
            //MenuItemImpl item = (MenuItemImpl) subMenu.getItem();
            //if (!item.isActionButton()) {
                //setAnchorView(mOverflowButton == null ? (View) mMenuView : mOverflowButton);
            //}
            //setCallback(mPopupPresenterCallback);
            //boolean preserveIconSpacing = false;
            //final int count = subMenu.size();
            //for (int i = 0; i < count; i++) {
                //MenuItem childItem = subMenu.getItem(i);
                //if (childItem.isVisible() && childItem.getIcon() != null) {
                    //preserveIconSpacing = true;
                    //break;
                //}
            //}
            //setForceShowIcon(preserveIconSpacing);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.004 -0400", hash_original_method = "69C0D5A7A155D8F50134B9E617767128", hash_generated_method = "351F511E80FA2706234E40E36A6C89F9")
        @Override
        public void onDismiss() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onDismiss();
            mActionButtonPopup = null;
            mOpenSubMenuId = 0;
            // ---------- Original Method ----------
            //super.onDismiss();
            //mActionButtonPopup = null;
            //mOpenSubMenuId = 0;
        }

        
    }


    
    private class PopupPresenterCallback implements MenuPresenter.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.004 -0400", hash_original_method = "094885FACF5CDEF923542BEFD4BC4936", hash_generated_method = "094885FACF5CDEF923542BEFD4BC4936")
        public PopupPresenterCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.004 -0400", hash_original_method = "29547EA8801B28CE842E58C3B2A91712", hash_generated_method = "D12666668D16AB8C38D6340DED8F2AFC")
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            if(subMenu == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1979983874 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_967331371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_967331371;
            }
            mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            boolean var68934A3E9455FA72420237EB05902327_436377661 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961218459 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_961218459;
            // ---------- Original Method ----------
            //if (subMenu == null) return false;
            //mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.005 -0400", hash_original_method = "847A197D3775740590913F0AAA0D3207", hash_generated_method = "1FC4CFB91DADCA791D26F62584024818")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(allMenusAreClosing);
            addTaint(menu.getTaint());
            if(menu instanceof SubMenuBuilder)            
            {
                ((SubMenuBuilder) menu).getRootMenu().close(false);
            } //End block
            // ---------- Original Method ----------
            //if (menu instanceof SubMenuBuilder) {
                //((SubMenuBuilder) menu).getRootMenu().close(false);
            //}
        }

        
    }


    
    private class OpenOverflowRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.005 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "A7832614732810CD7F68AEA244EAE6B6")

        private OverflowPopup mPopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.005 -0400", hash_original_method = "599E88E0D73270F72B5C8D6A6C7D2ACA", hash_generated_method = "83EF72038C4C6F336D91E4FDD7DBA957")
        public  OpenOverflowRunnable(OverflowPopup popup) {
            mPopup = popup;
            // ---------- Original Method ----------
            //mPopup = popup;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.005 -0400", hash_original_method = "A205A4B8116FA6A00F9203B1BEAEE8C7", hash_generated_method = "41E13E2E3C047A6D56AB94640E2B0824")
        public void run() {
            mMenu.changeMenuMode();
            final View menuView = (View) mMenuView;
            if(menuView != null && menuView.getWindowToken() != null && mPopup.tryShow())            
            {
                mOverflowPopup = mPopup;
            } //End block
            mPostedOpenRunnable = null;
            // ---------- Original Method ----------
            //mMenu.changeMenuMode();
            //final View menuView = (View) mMenuView;
            //if (menuView != null && menuView.getWindowToken() != null && mPopup.tryShow()) {
                //mOverflowPopup = mPopup;
            //}
            //mPostedOpenRunnable = null;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.005 -0400", hash_original_field = "E83447013E3A959D82815F43151988FB", hash_generated_field = "365B884CA8B9956B388F21B4CE2AED12")

    private static final String TAG = "ActionMenuPresenter";
}

