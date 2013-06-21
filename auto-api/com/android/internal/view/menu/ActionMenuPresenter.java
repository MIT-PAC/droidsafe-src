package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private View mOverflowButton;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private int mWidthLimit;
    private int mActionItemWidthLimit;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private boolean mStrictWidthLimit;
    private boolean mWidthLimitSet;
    private boolean mExpandedActionViewsExclusive;
    private int mMinCellSize;
    private SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private View mScrapActionButtonView;
    private OverflowPopup mOverflowPopup;
    private ActionButtonSubmenu mActionButtonPopup;
    private OpenOverflowRunnable mPostedOpenRunnable;
    PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    int mOpenSubMenuId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.394 -0400", hash_original_method = "D92A82193E3FCDED5C9710083B861A1F", hash_generated_method = "E74DE91CDFFB45AB293484FE5CC105C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuPresenter(Context context) {
        super(context, com.android.internal.R.layout.action_menu_layout,
                com.android.internal.R.layout.action_menu_item_layout);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.394 -0400", hash_original_method = "BC9545155A7D6BD0732B2C48FEAAA115", hash_generated_method = "3ECEE77ED652B6E9FB3E4812A9F06D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        super.initForMenu(context, menu);
        Resources res;
        res = context.getResources();
        {
            mReserveOverflow = !ViewConfiguration.get(context).hasPermanentMenuKey();
        } //End block
        {
            mWidthLimit = res.getDisplayMetrics().widthPixels / 2;
        } //End block
        {
            mMaxItems = res.getInteger(com.android.internal.R.integer.max_action_buttons);
        } //End block
        int width;
        width = mWidthLimit;
        {
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                int spec;
                spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                mOverflowButton.measure(spec, spec);
            } //End block
            width -= mOverflowButton.getMeasuredWidth();
        } //End block
        {
            mOverflowButton = null;
        } //End block
        mActionItemWidthLimit = width;
        mMinCellSize = (int) (ActionMenuView.MIN_CELL_SIZE * res.getDisplayMetrics().density);
        mScrapActionButtonView = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.395 -0400", hash_original_method = "A17C8C9C29C5D048821A272E4E211244", hash_generated_method = "4CB23B97EB4481015410B0221EA222B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        {
            mMaxItems = mContext.getResources().getInteger(
                    com.android.internal.R.integer.max_action_buttons);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.395 -0400", hash_original_method = "EDE1166C9C5D6E2371538FA8BF1D31B5", hash_generated_method = "4F159867ED86A5DDDFD2C1BB01C0A6F3")
    @DSModeled(DSC.SAFE)
    public void setWidthLimit(int width, boolean strict) {
        dsTaint.addTaint(width);
        dsTaint.addTaint(strict);
        mWidthLimitSet = true;
        // ---------- Original Method ----------
        //mWidthLimit = width;
        //mStrictWidthLimit = strict;
        //mWidthLimitSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.395 -0400", hash_original_method = "9F648716EF61D229ED05FF998E104A97", hash_generated_method = "C72F60F700AD8EE52762A4FC77835092")
    @DSModeled(DSC.SAFE)
    public void setReserveOverflow(boolean reserveOverflow) {
        dsTaint.addTaint(reserveOverflow);
        mReserveOverflowSet = true;
        // ---------- Original Method ----------
        //mReserveOverflow = reserveOverflow;
        //mReserveOverflowSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.395 -0400", hash_original_method = "481A608E0CFB48388247866BAE1C540A", hash_generated_method = "A716AA4F3249A622BA931B4E6B0DC72D")
    @DSModeled(DSC.SAFE)
    public void setItemLimit(int itemCount) {
        dsTaint.addTaint(itemCount);
        mMaxItemsSet = true;
        // ---------- Original Method ----------
        //mMaxItems = itemCount;
        //mMaxItemsSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.395 -0400", hash_original_method = "28685D1CD5555D455AA1245A08028303", hash_generated_method = "A31F17BE270289A88F8B672BF00BE4E7")
    @DSModeled(DSC.SAFE)
    public void setExpandedActionViewsExclusive(boolean isExclusive) {
        dsTaint.addTaint(isExclusive);
        // ---------- Original Method ----------
        //mExpandedActionViewsExclusive = isExclusive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.395 -0400", hash_original_method = "AD0B74E3B833D08F8481D15CB97EDB86", hash_generated_method = "72B4E05DD85AF4668B8D89451942AF1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MenuView getMenuView(ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        MenuView result;
        result = super.getMenuView(root);
        ((ActionMenuView) result).setPresenter(this);
        return (MenuView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MenuView result = super.getMenuView(root);
        //((ActionMenuView) result).setPresenter(this);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.396 -0400", hash_original_method = "59BA3C56A8058A32CF9B2FCB0A0B5507", hash_generated_method = "0FA0943101F5EA6412A6380EF68C5E46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        View actionView;
        actionView = item.getActionView();
        {
            boolean var042A2602C5874EB8C3227D44BE9ADF6F_1309800119 = (actionView == null || item.hasCollapsibleActionView());
            {
                {
                    convertView = null;
                } //End block
                actionView = super.getItemView(item, convertView, parent);
            } //End block
        } //End collapsed parenthetic
        actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);
        ActionMenuView menuParent;
        menuParent = (ActionMenuView) parent;
        ViewGroup.LayoutParams lp;
        lp = actionView.getLayoutParams();
        {
            boolean var3F4E8E87992AC39D78E62AD5C121760F_864346429 = (!menuParent.checkLayoutParams(lp));
            {
                actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.396 -0400", hash_original_method = "2F59AFEB76404A397084655FE3C87387", hash_generated_method = "FEB99F123A9D28D92503D1833B0227C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {
        dsTaint.addTaint(itemView.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        itemView.initialize(item, 0);
        ActionMenuView menuView;
        menuView = (ActionMenuView) mMenuView;
        ActionMenuItemView actionItemView;
        actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
        // ---------- Original Method ----------
        //itemView.initialize(item, 0);
        //final ActionMenuView menuView = (ActionMenuView) mMenuView;
        //ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        //actionItemView.setItemInvoker(menuView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.397 -0400", hash_original_method = "CF6FF79E1183E432FB7F279F6A955298", hash_generated_method = "2378BC38702D94DDBA55D93BF3CC00D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(childIndex);
        boolean var63CDEDD9ADF2A3E4CD65B5345E84754D_177358459 = (item.isActionButton());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return item.isActionButton();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.397 -0400", hash_original_method = "675BFE60E67D99082131CDB4BA0667CE", hash_generated_method = "C942430081BA838B36369D1792735627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMenuView(boolean cleared) {
        dsTaint.addTaint(cleared);
        super.updateMenuView(cleared);
        {
            ArrayList<MenuItemImpl> actionItems;
            actionItems = mMenu.getActionItems();
            int count;
            count = actionItems.size();
            {
                int i;
                i = 0;
                {
                    ActionProvider provider;
                    provider = actionItems.get(i).getActionProvider();
                    {
                        provider.setSubUiVisibilityListener(this);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        ArrayList<MenuItemImpl> nonActionItems;
        nonActionItems = mMenu.getNonActionItems();
        nonActionItems = null;
        boolean hasOverflow;
        hasOverflow = false;
        {
            int count;
            count = nonActionItems.size();
            {
                hasOverflow = !nonActionItems.get(0).isActionViewExpanded();
            } //End block
            {
                hasOverflow = count > 0;
            } //End block
        } //End block
        {
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
            } //End block
            ViewGroup parent;
            parent = (ViewGroup) mOverflowButton.getParent();
            {
                {
                    parent.removeView(mOverflowButton);
                } //End block
                ActionMenuView menuView;
                menuView = (ActionMenuView) mMenuView;
                menuView.addView(mOverflowButton, menuView.generateOverflowButtonLayoutParams());
            } //End block
        } //End block
        {
            boolean var636A254D04624E67B4E275AE8C012F60_1073230642 = (mOverflowButton != null && mOverflowButton.getParent() == mMenuView);
            {
                ((ViewGroup) mMenuView).removeView(mOverflowButton);
            } //End block
        } //End collapsed parenthetic
        ((ActionMenuView) mMenuView).setOverflowReserved(mReserveOverflow);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.398 -0400", hash_original_method = "9D8FC445B750A9A2E8805EF185920422", hash_generated_method = "5C160D89728A79E24D7EC8D4A36719B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(childIndex);
        {
            boolean var2C5D3A435D4B7C5FC7DF763D994EC999_1982885294 = (parent.getChildAt(childIndex) == mOverflowButton);
        } //End collapsed parenthetic
        boolean var7C223E5B8CEAE7D7BF100F1F8A9FA1B9_2081453206 = (super.filterLeftoverView(parent, childIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (parent.getChildAt(childIndex) == mOverflowButton) return false;
        //return super.filterLeftoverView(parent, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.399 -0400", hash_original_method = "37299DBD51D21A28CE7BE5283912D693", hash_generated_method = "41345BCC1B82EAA4AFDE375567621D27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(subMenu.dsTaint);
        {
            boolean var89D6F494337AE8363DF4B82D8D3CD4B2_402098060 = (!subMenu.hasVisibleItems());
        } //End collapsed parenthetic
        SubMenuBuilder topSubMenu;
        topSubMenu = subMenu;
        {
            boolean var3070E3EF1FB105EFCC31C47F14EB2042_847770046 = (topSubMenu.getParentMenu() != mMenu);
            {
                topSubMenu = (SubMenuBuilder) topSubMenu.getParentMenu();
            } //End block
        } //End collapsed parenthetic
        View anchor;
        anchor = findViewForItem(topSubMenu.getItem());
        {
            anchor = mOverflowButton;
        } //End block
        mOpenSubMenuId = subMenu.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, subMenu);
        mActionButtonPopup.setAnchorView(anchor);
        mActionButtonPopup.show();
        super.onSubMenuSelected(subMenu);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.400 -0400", hash_original_method = "D21215C119A8C9273D02F36683639F77", hash_generated_method = "2FBD3F713C6C85CFCF44EF8BE6AF7684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findViewForItem(MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        ViewGroup parent;
        parent = (ViewGroup) mMenuView;
        int count;
        count = parent.getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = parent.getChildAt(i);
                {
                    boolean var6A79BB2D965C162A835EA9549023D9A8_616590881 = (child instanceof MenuView.ItemView &&
                    ((MenuView.ItemView) child).getItemData() == item);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.400 -0400", hash_original_method = "51D4B09F0769DB498C88D93C1DD1D610", hash_generated_method = "9A4AABBF9872FB7975614D2727383F06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showOverflowMenu() {
        {
            boolean varA5B27DD56A8D2501A2BC1F22BE54417E_439325576 = (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
                mPostedOpenRunnable == null);
            {
                OverflowPopup popup;
                popup = new OverflowPopup(mContext, mMenu, mOverflowButton, true);
                mPostedOpenRunnable = new OpenOverflowRunnable(popup);
                ((View) mMenuView).post(mPostedOpenRunnable);
                super.onSubMenuSelected(null);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.400 -0400", hash_original_method = "F07D2B002CE8D32774BDF7E27A216F8A", hash_generated_method = "8C259084C5E0213BC66E0F0B0875D2FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideOverflowMenu() {
        {
            ((View) mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
        } //End block
        MenuPopupHelper popup;
        popup = mOverflowPopup;
        {
            popup.dismiss();
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.400 -0400", hash_original_method = "048650AFF94B01A571A17F813CE8142B", hash_generated_method = "BEEA48D5CEDFE1EDE3D420D17955DB13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dismissPopupMenus() {
        boolean result;
        result = hideOverflowMenu();
        result |= hideSubMenus();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = hideOverflowMenu();
        //result |= hideSubMenus();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.401 -0400", hash_original_method = "86830002AFDFBC8C0790A0C80E395F68", hash_generated_method = "B2516D1FBF98229B05473E7ED654FCDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hideSubMenus() {
        {
            mActionButtonPopup.dismiss();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActionButtonPopup != null) {
            //mActionButtonPopup.dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.401 -0400", hash_original_method = "EDFA99D71A654F51EBF8F88159FF0AE5", hash_generated_method = "36711C1CD98C512B65AFE268FE182AFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOverflowMenuShowing() {
        boolean varDDE92196405694CCE3B775C2D317192F_599299793 = (mOverflowPopup != null && mOverflowPopup.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.401 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "80374BA640797FE3A442BB5CD0497E41")
    @DSModeled(DSC.SAFE)
    public boolean isOverflowReserved() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mReserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.402 -0400", hash_original_method = "3161CCF567C7C41004F1DD2E1141CBA5", hash_generated_method = "C9C81AF043F5246A4D2A3359FB80E76A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems;
        visibleItems = mMenu.getVisibleItems();
        int itemsSize;
        itemsSize = visibleItems.size();
        int maxActions;
        maxActions = mMaxItems;
        int widthLimit;
        widthLimit = mActionItemWidthLimit;
        int querySpec;
        querySpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        ViewGroup parent;
        parent = (ViewGroup) mMenuView;
        int requiredItems;
        requiredItems = 0;
        int requestedItems;
        requestedItems = 0;
        int firstActionWidth;
        firstActionWidth = 0;
        boolean hasOverflow;
        hasOverflow = false;
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = visibleItems.get(i);
                {
                    boolean varD0608EF2260E1F8B9264901745B3863A_811362208 = (item.requiresActionButton());
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_1793839435 = (item.requestsActionButton());
                        {
                            hasOverflow = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    boolean varBBBF1208950B60080E53B87439022606_22746695 = (mExpandedActionViewsExclusive && item.isActionViewExpanded());
                    {
                        maxActions = 0;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        maxActions -= requiredItems;
        SparseBooleanArray seenGroups;
        seenGroups = mActionButtonGroups;
        seenGroups.clear();
        int cellSize;
        cellSize = 0;
        int cellsRemaining;
        cellsRemaining = 0;
        {
            cellsRemaining = widthLimit / mMinCellSize;
            int cellSizeRemaining;
            cellSizeRemaining = widthLimit % mMinCellSize;
            cellSize = mMinCellSize + cellSizeRemaining / cellsRemaining;
        } //End block
        {
            int i;
            i = 0;
            {
                MenuItemImpl item;
                item = visibleItems.get(i);
                {
                    boolean varD0608EF2260E1F8B9264901745B3863A_577760298 = (item.requiresActionButton());
                    {
                        View v;
                        v = getItemView(item, mScrapActionButtonView, parent);
                        {
                            mScrapActionButtonView = v;
                        } //End block
                        {
                            cellsRemaining -= ActionMenuView.measureChildForCells(v,
                            cellSize, cellsRemaining, querySpec, 0);
                        } //End block
                        {
                            v.measure(querySpec, querySpec);
                        } //End block
                        int measuredWidth;
                        measuredWidth = v.getMeasuredWidth();
                        widthLimit -= measuredWidth;
                        {
                            firstActionWidth = measuredWidth;
                        } //End block
                        int groupId;
                        groupId = item.getGroupId();
                        {
                            seenGroups.put(groupId, true);
                        } //End block
                        item.setIsActionButton(true);
                    } //End block
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_2042159307 = (item.requestsActionButton());
                        {
                            int groupId;
                            groupId = item.getGroupId();
                            boolean inGroup;
                            inGroup = seenGroups.get(groupId);
                            boolean isAction;
                            isAction = (maxActions > 0 || inGroup) && widthLimit > 0 &&
                        (!mStrictWidthLimit || cellsRemaining > 0);
                            {
                                View v;
                                v = getItemView(item, mScrapActionButtonView, parent);
                                {
                                    mScrapActionButtonView = v;
                                } //End block
                                {
                                    int cells;
                                    cells = ActionMenuView.measureChildForCells(v,
                                cellSize, cellsRemaining, querySpec, 0);
                                    cellsRemaining -= cells;
                                    {
                                        isAction = false;
                                    } //End block
                                } //End block
                                {
                                    v.measure(querySpec, querySpec);
                                } //End block
                                int measuredWidth;
                                measuredWidth = v.getMeasuredWidth();
                                widthLimit -= measuredWidth;
                                {
                                    firstActionWidth = measuredWidth;
                                } //End block
                                {
                                    isAction &= widthLimit >= 0;
                                } //End block
                                {
                                    isAction &= widthLimit + firstActionWidth > 0;
                                } //End block
                            } //End block
                            {
                                seenGroups.put(groupId, true);
                            } //End block
                            {
                                seenGroups.put(groupId, false);
                                {
                                    int j;
                                    j = 0;
                                    {
                                        MenuItemImpl areYouMyGroupie;
                                        areYouMyGroupie = visibleItems.get(j);
                                        {
                                            boolean var58D13C27DFD727DA00E5820FA84F8A98_29343590 = (areYouMyGroupie.getGroupId() == groupId);
                                            {
                                                {
                                                    boolean var3845F6435C6D2EFBC5673BCA3826363D_258407743 = (areYouMyGroupie.isActionButton());
                                                } //End collapsed parenthetic
                                                areYouMyGroupie.setIsActionButton(false);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            item.setIsActionButton(isAction);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.402 -0400", hash_original_method = "C8ECD6F76386581509465FBD82905343", hash_generated_method = "769666037AA735813CC2A06D0F3DA63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(allMenusAreClosing);
        dsTaint.addTaint(menu.dsTaint);
        dismissPopupMenus();
        super.onCloseMenu(menu, allMenusAreClosing);
        // ---------- Original Method ----------
        //dismissPopupMenus();
        //super.onCloseMenu(menu, allMenusAreClosing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.402 -0400", hash_original_method = "06AD8BBBF679989CAE04F426A0FFC61D", hash_generated_method = "DAB5D97E9C3C1D1FD1A3D0B0F3BE9564")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState state;
        state = new SavedState();
        state.openSubMenuId = mOpenSubMenuId;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SavedState state = new SavedState();
        //state.openSubMenuId = mOpenSubMenuId;
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.403 -0400", hash_original_method = "56321A468C9EBB2A9C3695363B6A634B", hash_generated_method = "B219E9CCC35EE4EBE4D124B8A3E139C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        SavedState saved;
        saved = (SavedState) state;
        {
            MenuItem item;
            item = mMenu.findItem(saved.openSubMenuId);
            {
                SubMenuBuilder subMenu;
                subMenu = (SubMenuBuilder) item.getSubMenu();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.403 -0400", hash_original_method = "E6B8634A947A629174EE0649ED3769CC", hash_generated_method = "9BA5E212C04AC379335F290B6B12DA30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onSubUiVisibilityChanged(boolean isVisible) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isVisible);
        {
            super.onSubMenuSelected(null);
        } //End block
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
        public int openSubMenuId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.403 -0400", hash_original_method = "5B86CE655F475C08F177FDB52AD9ECFE", hash_generated_method = "4573F1D4704340137C4835179DE848FD")
        @DSModeled(DSC.SAFE)
         SavedState() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.403 -0400", hash_original_method = "10B6E86FE11BCC070EDA2136A91ED86D", hash_generated_method = "DB046390D2673B12E2F96E28799DA805")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            openSubMenuId = in.readInt();
            // ---------- Original Method ----------
            //openSubMenuId = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.403 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
        @DSModeled(DSC.SAFE)
        @Override
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.404 -0400", hash_original_method = "4E7F3A208B8DADACA56997D8D1B3C90C", hash_generated_method = "D6B985AF4F473E98F69BBA351E5E6D18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(openSubMenuId);
            // ---------- Original Method ----------
            //dest.writeInt(openSubMenuId);
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.404 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "2DC4A957974D6EFC18C9B883F02C35BE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_706964071 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.404 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "5EB88F90C9109A2FC98F71A58A30FAAD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_216429407 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.404 -0400", hash_original_method = "1337D4EFD3D7C8CDCFFFFAE2F6FA113A", hash_generated_method = "41CA7F10527F24B3FBF0370E588CBB52")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OverflowMenuButton(Context context) {
            super(context, null, com.android.internal.R.attr.actionOverflowButtonStyle);
            dsTaint.addTaint(context.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.404 -0400", hash_original_method = "133A6BF2CD1B819427A8C49FA8B8E865", hash_generated_method = "83BFBCC4670F27879E592EA38101DC88")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean performClick() {
            {
                boolean var6267028C3644B44519A636F6B5EF90B1_1544285543 = (super.performClick());
            } //End collapsed parenthetic
            playSoundEffect(SoundEffectConstants.CLICK);
            showOverflowMenu();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (super.performClick()) {
                //return true;
            //}
            //playSoundEffect(SoundEffectConstants.CLICK);
            //showOverflowMenu();
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.405 -0400", hash_original_method = "6BA15F1E8189A4801AF337396791DD31", hash_generated_method = "F432B5B624C732B6CEC5E9F869791403")
        @DSModeled(DSC.SAFE)
        public boolean needsDividerBefore() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.405 -0400", hash_original_method = "CA065FAE0BB06CECFBFA2C36E268A066", hash_generated_method = "C2A120F65C9A388ACBD2AFB9F4A69DE2")
        @DSModeled(DSC.SAFE)
        public boolean needsDividerAfter() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    private class OverflowPopup extends MenuPopupHelper {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.405 -0400", hash_original_method = "FA0F7CD1552EAFA7C13929825A8B2112", hash_generated_method = "E6584EF1D393D2C80949EEBD5AF8AA6B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OverflowPopup(Context context, MenuBuilder menu, View anchorView,
                boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly);
            dsTaint.addTaint(anchorView.dsTaint);
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(overflowOnly);
            setCallback(mPopupPresenterCallback);
            // ---------- Original Method ----------
            //setCallback(mPopupPresenterCallback);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.405 -0400", hash_original_method = "F12BAE7D751DC96E6D1F67F68EBC9919", hash_generated_method = "C0B66E552A56F943AE8D17ED4BE5D635")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private SubMenuBuilder mSubMenu;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.405 -0400", hash_original_method = "E276DF3AF8ED38FB9CAF2E195F32B2B4", hash_generated_method = "48BEC463CC125185C84E9BDC30200E84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenu) {
            super(context, subMenu);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(subMenu.dsTaint);
            MenuItemImpl item;
            item = (MenuItemImpl) subMenu.getItem();
            {
                boolean var578FB4F95786C0DE176C492E48EDBCE4_1645266618 = (!item.isActionButton());
                {
                    setAnchorView(mOverflowButton == null ? (View) mMenuView : mOverflowButton);
                } //End block
            } //End collapsed parenthetic
            setCallback(mPopupPresenterCallback);
            boolean preserveIconSpacing;
            preserveIconSpacing = false;
            int count;
            count = subMenu.size();
            {
                int i;
                i = 0;
                {
                    MenuItem childItem;
                    childItem = subMenu.getItem(i);
                    {
                        boolean var85A149AB5F872C1FDE25CE93041B2D49_1064679422 = (childItem.isVisible() && childItem.getIcon() != null);
                        {
                            preserveIconSpacing = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.406 -0400", hash_original_method = "69C0D5A7A155D8F50134B9E617767128", hash_generated_method = "351F511E80FA2706234E40E36A6C89F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.406 -0400", hash_original_method = "DBA98A0039B6F74919D43193A2C10A72", hash_generated_method = "DBA98A0039B6F74919D43193A2C10A72")
                public PopupPresenterCallback ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.406 -0400", hash_original_method = "29547EA8801B28CE842E58C3B2A91712", hash_generated_method = "6B94F9DD05F0781092B2784B4E6C7662")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(subMenu.dsTaint);
            mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (subMenu == null) return false;
            //mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.406 -0400", hash_original_method = "847A197D3775740590913F0AAA0D3207", hash_generated_method = "DE568BA17E748D5A26509D442F330EBC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(allMenusAreClosing);
            dsTaint.addTaint(menu.dsTaint);
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
        private OverflowPopup mPopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.406 -0400", hash_original_method = "599E88E0D73270F72B5C8D6A6C7D2ACA", hash_generated_method = "557EE90184C8EF55310D9AE5F2CC6FE7")
        @DSModeled(DSC.SAFE)
        public OpenOverflowRunnable(OverflowPopup popup) {
            dsTaint.addTaint(popup.dsTaint);
            // ---------- Original Method ----------
            //mPopup = popup;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.407 -0400", hash_original_method = "A205A4B8116FA6A00F9203B1BEAEE8C7", hash_generated_method = "F7B47517B0BC8FBFD59E77DC05F0FAF6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            mMenu.changeMenuMode();
            View menuView;
            menuView = (View) mMenuView;
            {
                boolean var3552093DD787185B5C9D0DFE6D6F1BD0_578488457 = (menuView != null && menuView.getWindowToken() != null && mPopup.tryShow());
                {
                    mOverflowPopup = mPopup;
                } //End block
            } //End collapsed parenthetic
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


    
    private static final String TAG = "ActionMenuPresenter";
}

