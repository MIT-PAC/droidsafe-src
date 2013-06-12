package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "ActionMenuPresenter";
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
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private View mScrapActionButtonView;
    private OverflowPopup mOverflowPopup;
    private ActionButtonSubmenu mActionButtonPopup;
    private OpenOverflowRunnable mPostedOpenRunnable;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    int mOpenSubMenuId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "D92A82193E3FCDED5C9710083B861A1F", hash_generated_method = "07C90367946830BE3805D43BCEFA5EFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuPresenter(Context context) {
        super(context, com.android.internal.R.layout.action_menu_layout,
                com.android.internal.R.layout.action_menu_item_layout);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "BC9545155A7D6BD0732B2C48FEAAA115", hash_generated_method = "50A0D1312CABB15D1AA9E0051BD7B592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        super.initForMenu(context, menu);
        final Resources res;
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
                final int spec;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "A17C8C9C29C5D048821A272E4E211244", hash_generated_method = "E29176474F3D87799DAA2158BEDC5A41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "EDE1166C9C5D6E2371538FA8BF1D31B5", hash_generated_method = "4F7C8B529B88B945B20E350D6211E7F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "9F648716EF61D229ED05FF998E104A97", hash_generated_method = "D1632A233D799C0982B964ACCEB2B717")
    @DSModeled(DSC.SAFE)
    public void setReserveOverflow(boolean reserveOverflow) {
        dsTaint.addTaint(reserveOverflow);
        mReserveOverflowSet = true;
        // ---------- Original Method ----------
        //mReserveOverflow = reserveOverflow;
        //mReserveOverflowSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "481A608E0CFB48388247866BAE1C540A", hash_generated_method = "7712232C7B82D74766853F6306A3E865")
    @DSModeled(DSC.SAFE)
    public void setItemLimit(int itemCount) {
        dsTaint.addTaint(itemCount);
        mMaxItemsSet = true;
        // ---------- Original Method ----------
        //mMaxItems = itemCount;
        //mMaxItemsSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "28685D1CD5555D455AA1245A08028303", hash_generated_method = "CA4E76BAC345BD02C00A003147154CE8")
    @DSModeled(DSC.SAFE)
    public void setExpandedActionViewsExclusive(boolean isExclusive) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isExclusive);
        // ---------- Original Method ----------
        //mExpandedActionViewsExclusive = isExclusive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.971 -0400", hash_original_method = "AD0B74E3B833D08F8481D15CB97EDB86", hash_generated_method = "C5D15B7FB142679FA1D55B5BA6FCB131")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.972 -0400", hash_original_method = "59BA3C56A8058A32CF9B2FCB0A0B5507", hash_generated_method = "5741846B4951F11E6C6409162C803B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        View actionView;
        actionView = item.getActionView();
        {
            boolean var042A2602C5874EB8C3227D44BE9ADF6F_1827850720 = (actionView == null || item.hasCollapsibleActionView());
            {
                {
                    convertView = null;
                } //End block
                actionView = super.getItemView(item, convertView, parent);
            } //End block
        } //End collapsed parenthetic
        actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);
        final ActionMenuView menuParent;
        menuParent = (ActionMenuView) parent;
        final ViewGroup.LayoutParams lp;
        lp = actionView.getLayoutParams();
        {
            boolean var3F4E8E87992AC39D78E62AD5C121760F_145442507 = (!menuParent.checkLayoutParams(lp));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.972 -0400", hash_original_method = "2F59AFEB76404A397084655FE3C87387", hash_generated_method = "5CE27D5CF6401950162BD34A83C3A980")
    @DSModeled(DSC.SAFE)
    @Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {
        dsTaint.addTaint(itemView.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        itemView.initialize(item, 0);
        final ActionMenuView menuView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.972 -0400", hash_original_method = "CF6FF79E1183E432FB7F279F6A955298", hash_generated_method = "A43832C991068973FCE578360F86312C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(childIndex);
        boolean var63CDEDD9ADF2A3E4CD65B5345E84754D_1118345512 = (item.isActionButton());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return item.isActionButton();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.972 -0400", hash_original_method = "675BFE60E67D99082131CDB4BA0667CE", hash_generated_method = "C09F46A78B50BD47760D084A492E6A4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMenuView(boolean cleared) {
        dsTaint.addTaint(cleared);
        super.updateMenuView(cleared);
        {
            final ArrayList<MenuItemImpl> actionItems;
            actionItems = mMenu.getActionItems();
            final int count;
            count = actionItems.size();
            {
                int i;
                i = 0;
                {
                    final ActionProvider provider;
                    provider = actionItems.get(i).getActionProvider();
                    {
                        provider.setSubUiVisibilityListener(this);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        final ArrayList<MenuItemImpl> nonActionItems;
        nonActionItems = mMenu.getNonActionItems();
        nonActionItems = null;
        boolean hasOverflow;
        hasOverflow = false;
        {
            final int count;
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
            boolean var636A254D04624E67B4E275AE8C012F60_1368265299 = (mOverflowButton != null && mOverflowButton.getParent() == mMenuView);
            {
                ((ViewGroup) mMenuView).removeView(mOverflowButton);
            } //End block
        } //End collapsed parenthetic
        ((ActionMenuView) mMenuView).setOverflowReserved(mReserveOverflow);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.972 -0400", hash_original_method = "9D8FC445B750A9A2E8805EF185920422", hash_generated_method = "E36FB56C3059C58F079084B585BB0AD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(childIndex);
        {
            boolean var2C5D3A435D4B7C5FC7DF763D994EC999_370005982 = (parent.getChildAt(childIndex) == mOverflowButton);
        } //End collapsed parenthetic
        boolean var7C223E5B8CEAE7D7BF100F1F8A9FA1B9_147228012 = (super.filterLeftoverView(parent, childIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (parent.getChildAt(childIndex) == mOverflowButton) return false;
        //return super.filterLeftoverView(parent, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.972 -0400", hash_original_method = "37299DBD51D21A28CE7BE5283912D693", hash_generated_method = "44E71CBD35933D45CB8B52DB5FBF6E78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(subMenu.dsTaint);
        {
            boolean var89D6F494337AE8363DF4B82D8D3CD4B2_168754746 = (!subMenu.hasVisibleItems());
        } //End collapsed parenthetic
        SubMenuBuilder topSubMenu;
        topSubMenu = subMenu;
        {
            boolean var3070E3EF1FB105EFCC31C47F14EB2042_1735010379 = (topSubMenu.getParentMenu() != mMenu);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "D21215C119A8C9273D02F36683639F77", hash_generated_method = "FAFEBA9C1EDBDD63772BF16ECFA6A16E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findViewForItem(MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        final ViewGroup parent;
        parent = (ViewGroup) mMenuView;
        final int count;
        count = parent.getChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = parent.getChildAt(i);
                {
                    boolean var6A79BB2D965C162A835EA9549023D9A8_881816669 = (child instanceof MenuView.ItemView &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "51D4B09F0769DB498C88D93C1DD1D610", hash_generated_method = "66A1D3A5F9BDC8A8622824A6AFABA49B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showOverflowMenu() {
        {
            boolean varA5B27DD56A8D2501A2BC1F22BE54417E_295105165 = (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "F07D2B002CE8D32774BDF7E27A216F8A", hash_generated_method = "255078108E2750C91D82475C07F3A285")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "048650AFF94B01A571A17F813CE8142B", hash_generated_method = "688E8AB9218FCE3822256A3077FD4B39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "86830002AFDFBC8C0790A0C80E395F68", hash_generated_method = "9A056E4F8A37AC979BBB29ABB31C043E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "EDFA99D71A654F51EBF8F88159FF0AE5", hash_generated_method = "5FCCF28BAF8229683A4268A29A31F74A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOverflowMenuShowing() {
        boolean varDDE92196405694CCE3B775C2D317192F_1125968247 = (mOverflowPopup != null && mOverflowPopup.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.973 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "4D6C1E8FDA41830356B62B44C4D2BBD0")
    @DSModeled(DSC.SAFE)
    public boolean isOverflowReserved() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mReserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "3161CCF567C7C41004F1DD2E1141CBA5", hash_generated_method = "DA505DDB71E61D322AF67CF1508A32BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean flagActionItems() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final ArrayList<MenuItemImpl> visibleItems;
        visibleItems = mMenu.getVisibleItems();
        final int itemsSize;
        itemsSize = visibleItems.size();
        int maxActions;
        maxActions = mMaxItems;
        int widthLimit;
        widthLimit = mActionItemWidthLimit;
        final int querySpec;
        querySpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final ViewGroup parent;
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
                    boolean varD0608EF2260E1F8B9264901745B3863A_451897043 = (item.requiresActionButton());
                    {
                        requiredItems++;
                    } //End block
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_1533658475 = (item.requestsActionButton());
                        {
                            requestedItems++;
                        } //End block
                        {
                            hasOverflow = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    boolean varBBBF1208950B60080E53B87439022606_1588460541 = (mExpandedActionViewsExclusive && item.isActionViewExpanded());
                    {
                        maxActions = 0;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            maxActions--;
        } //End block
        maxActions -= requiredItems;
        final SparseBooleanArray seenGroups;
        seenGroups = mActionButtonGroups;
        seenGroups.clear();
        int cellSize;
        cellSize = 0;
        int cellsRemaining;
        cellsRemaining = 0;
        {
            cellsRemaining = widthLimit / mMinCellSize;
            final int cellSizeRemaining;
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
                    boolean varD0608EF2260E1F8B9264901745B3863A_383979337 = (item.requiresActionButton());
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
                        final int measuredWidth;
                        measuredWidth = v.getMeasuredWidth();
                        widthLimit -= measuredWidth;
                        {
                            firstActionWidth = measuredWidth;
                        } //End block
                        final int groupId;
                        groupId = item.getGroupId();
                        {
                            seenGroups.put(groupId, true);
                        } //End block
                        item.setIsActionButton(true);
                    } //End block
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_1963390340 = (item.requestsActionButton());
                        {
                            final int groupId;
                            groupId = item.getGroupId();
                            final boolean inGroup;
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
                                    final int cells;
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
                                final int measuredWidth;
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
                                            boolean var58D13C27DFD727DA00E5820FA84F8A98_1415392623 = (areYouMyGroupie.getGroupId() == groupId);
                                            {
                                                {
                                                    boolean var3845F6435C6D2EFBC5673BCA3826363D_1516932628 = (areYouMyGroupie.isActionButton());
                                                    maxActions++;
                                                } //End collapsed parenthetic
                                                areYouMyGroupie.setIsActionButton(false);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            maxActions--;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "C8ECD6F76386581509465FBD82905343", hash_generated_method = "EE5F0BB6C71A341A4F499D835D7F64C8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "06AD8BBBF679989CAE04F426A0FFC61D", hash_generated_method = "C087B19011D90201ECA1BE888EBE66EF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "56321A468C9EBB2A9C3695363B6A634B", hash_generated_method = "CCCFA0D6586C138095EA5B0BDFEFE728")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "E6B8634A947A629174EE0649ED3769CC", hash_generated_method = "864D2F45C1B1B0E4EED622F834821D29")
    @DSModeled(DSC.SAFE)
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "6C6B0A873BD52E2752F88E9968D483CA")
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.974 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "1325778BB443F872513E70F9A19C5918")
            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "5B86CE655F475C08F177FDB52AD9ECFE", hash_generated_method = "C090FABA26FDDCA8EDE202C484C72F19")
        @DSModeled(DSC.SAFE)
         SavedState() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "10B6E86FE11BCC070EDA2136A91ED86D", hash_generated_method = "CBF6EEFEE60151DBD123B817844599C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            openSubMenuId = in.readInt();
            // ---------- Original Method ----------
            //openSubMenuId = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
        @DSModeled(DSC.SAFE)
        @Override
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "4E7F3A208B8DADACA56997D8D1B3C90C", hash_generated_method = "F619B06C48E6EBD793509CC6BCD3DB61")
        @DSModeled(DSC.SAFE)
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
            dest.writeInt(openSubMenuId);
            // ---------- Original Method ----------
            //dest.writeInt(openSubMenuId);
        }

        
    }


    
    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "1337D4EFD3D7C8CDCFFFFAE2F6FA113A", hash_generated_method = "AFC0951423AF589C19942F83315A4B9C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "133A6BF2CD1B819427A8C49FA8B8E865", hash_generated_method = "7DEDE994385AC65B1509E8F19D743DD6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean performClick() {
            {
                boolean var6267028C3644B44519A636F6B5EF90B1_703247558 = (super.performClick());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "6BA15F1E8189A4801AF337396791DD31", hash_generated_method = "8737F815DFB5BA0F77D8125E994C5087")
        @DSModeled(DSC.SAFE)
        public boolean needsDividerBefore() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "CA065FAE0BB06CECFBFA2C36E268A066", hash_generated_method = "46D4C978960B79C1590D35276264801D")
        @DSModeled(DSC.SAFE)
        public boolean needsDividerAfter() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    private class OverflowPopup extends MenuPopupHelper {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "FA0F7CD1552EAFA7C13929825A8B2112", hash_generated_method = "885659E676261E0B7FADF677DDE25222")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "F12BAE7D751DC96E6D1F67F68EBC9919", hash_generated_method = "D961AEDFC90511B272F9442CDB781C2F")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "E276DF3AF8ED38FB9CAF2E195F32B2B4", hash_generated_method = "B3F71C83441C4C7D163D51F901AF43C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenu) {
            super(context, subMenu);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(subMenu.dsTaint);
            MenuItemImpl item;
            item = (MenuItemImpl) subMenu.getItem();
            {
                boolean var578FB4F95786C0DE176C492E48EDBCE4_1869016446 = (!item.isActionButton());
                {
                    setAnchorView(mOverflowButton == null ? (View) mMenuView : mOverflowButton);
                } //End block
            } //End collapsed parenthetic
            setCallback(mPopupPresenterCallback);
            boolean preserveIconSpacing;
            preserveIconSpacing = false;
            final int count;
            count = subMenu.size();
            {
                int i;
                i = 0;
                {
                    MenuItem childItem;
                    childItem = subMenu.getItem(i);
                    {
                        boolean var85A149AB5F872C1FDE25CE93041B2D49_350699351 = (childItem.isVisible() && childItem.getIcon() != null);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "69C0D5A7A155D8F50134B9E617767128", hash_generated_method = "B37D5B9E984C9CB5FADA5EC691279C1B")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.975 -0400", hash_original_method = "29547EA8801B28CE842E58C3B2A91712", hash_generated_method = "AD8D26DA2AC1D0B652F0A3218C65CDAD")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.976 -0400", hash_original_method = "847A197D3775740590913F0AAA0D3207", hash_generated_method = "5F1D6D04BA337D6BFCBAB2EF3BDDA3E3")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.976 -0400", hash_original_method = "599E88E0D73270F72B5C8D6A6C7D2ACA", hash_generated_method = "A90C7A5E5A72FA8D9487992CDCF2E3C8")
        @DSModeled(DSC.SAFE)
        public OpenOverflowRunnable(OverflowPopup popup) {
            dsTaint.addTaint(popup.dsTaint);
            // ---------- Original Method ----------
            //mPopup = popup;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.976 -0400", hash_original_method = "A205A4B8116FA6A00F9203B1BEAEE8C7", hash_generated_method = "4AE7600B94B4BCDE896F6CC81A30FD70")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            mMenu.changeMenuMode();
            final View menuView;
            menuView = (View) mMenuView;
            {
                boolean var3552093DD787185B5C9D0DFE6D6F1BD0_1600953604 = (menuView != null && menuView.getWindowToken() != null && mPopup.tryShow());
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


    
}


