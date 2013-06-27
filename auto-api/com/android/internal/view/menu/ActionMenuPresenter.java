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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.273 -0400", hash_original_field = "18A904A5C0CC1E1FE45C814D28B71B26", hash_generated_field = "62B115CA56547ACC4395C5191DCAFA48")

    private View mOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.273 -0400", hash_original_field = "0E213F9463B6EFE55ADA2109C5E5DC56", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.273 -0400", hash_original_field = "FF60A156CE7AD39BD5FB673AFD302D5B", hash_generated_field = "8AA1ADBD5C3D9FA8BD4CE08655C7BAEC")

    private boolean mReserveOverflowSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.273 -0400", hash_original_field = "83EF65FD766EAC154AE5FEA63E2CE25A", hash_generated_field = "D519A6354FF6027B8318E0E8A1847729")

    private int mWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.273 -0400", hash_original_field = "A7E9006F830347B6496E603E3A3EFC82", hash_generated_field = "EE263C3BDAD9F74C57B87B4D53F4A7F2")

    private int mActionItemWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.273 -0400", hash_original_field = "0FFA0622B0631C3E765DE6810D1D5BEE", hash_generated_field = "46A54E1F46C2CF0E99FFE4A07B201C3C")

    private int mMaxItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.279 -0400", hash_original_field = "0EBB7A0928E7934DA0F5EC0C1A2EF0AA", hash_generated_field = "E8BC6B5172B218C6C49A6690AFA86C5B")

    private boolean mMaxItemsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.279 -0400", hash_original_field = "428FC947ACD187E12AF96B1282A02E84", hash_generated_field = "5992037AC4E6034F7F17925E51ACE390")

    private boolean mStrictWidthLimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.279 -0400", hash_original_field = "BEC7BC02B14F4AE2D2525ECA9C34A88C", hash_generated_field = "896F729C22C3B090A4F37324F1470F98")

    private boolean mWidthLimitSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "B912C176D59A2C01DCA72A9AB2E2D62B", hash_generated_field = "609B8E14C3F57F0FDE596A9E3115E316")

    private boolean mExpandedActionViewsExclusive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "C0CB7E511A75AFCB98C3B0342F6802E9", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "4A448DC9861F25A2BD03E23A029BD7C0", hash_generated_field = "F1F56EB4985BCD6343DA193331270307")

    private SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "86CDD986D39C84A497FF93C26971615A", hash_generated_field = "62CE63FA1996B79D9E9EE4493D96FB92")

    private View mScrapActionButtonView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "12E0F70E3294B5917D9DCD47A20C5330", hash_generated_field = "73011FFFEE53F9056EE81430FCFEDF05")

    private OverflowPopup mOverflowPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "8A4CED1EBB8A308B59EEEF4C102ECD26", hash_generated_field = "BAF3D98693011134EB1620D1BA22CC15")

    private ActionButtonSubmenu mActionButtonPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "8BA73CE13504EDF3C97248A329A63C0D", hash_generated_field = "33AD605615015FDD75E5D9A4D89E75A5")

    private OpenOverflowRunnable mPostedOpenRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "ACE338A85A5CA6F16ACDF484D88C2420", hash_generated_field = "EAA5F1B1764DB3A287DDA9679D0A36F8")

    PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.280 -0400", hash_original_field = "69B273247C1407653A216446C3964BA2", hash_generated_field = "0BCBB7C2003D06DDB90F4DA92F90C05F")

    int mOpenSubMenuId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.285 -0400", hash_original_method = "D92A82193E3FCDED5C9710083B861A1F", hash_generated_method = "E6DCC516EF7D40A6DADCD5498BA431E1")
    public  ActionMenuPresenter(Context context) {
        super(context, com.android.internal.R.layout.action_menu_layout,
                com.android.internal.R.layout.action_menu_item_layout);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.286 -0400", hash_original_method = "BC9545155A7D6BD0732B2C48FEAAA115", hash_generated_method = "63CA0CA16AEC9CB01445D528B6CFEF50")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
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
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.287 -0400", hash_original_method = "A17C8C9C29C5D048821A272E4E211244", hash_generated_method = "5102132AC300187B1AC034673FEADE8C")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mMaxItems = mContext.getResources().getInteger(
                    com.android.internal.R.integer.max_action_buttons);
            {
                mMenu.onItemsChanged(true);
            } //End block
        } //End block
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //if (!mMaxItemsSet) {
            //mMaxItems = mContext.getResources().getInteger(
                    //com.android.internal.R.integer.max_action_buttons);
            //if (mMenu != null) {
                //mMenu.onItemsChanged(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.287 -0400", hash_original_method = "EDE1166C9C5D6E2371538FA8BF1D31B5", hash_generated_method = "89721D0CEA79F09D9C0737AC06DA189B")
    public void setWidthLimit(int width, boolean strict) {
        mWidthLimit = width;
        mStrictWidthLimit = strict;
        mWidthLimitSet = true;
        // ---------- Original Method ----------
        //mWidthLimit = width;
        //mStrictWidthLimit = strict;
        //mWidthLimitSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.288 -0400", hash_original_method = "9F648716EF61D229ED05FF998E104A97", hash_generated_method = "B64A2DDCBD4CDF5CA323C99F8D98CF86")
    public void setReserveOverflow(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        mReserveOverflowSet = true;
        // ---------- Original Method ----------
        //mReserveOverflow = reserveOverflow;
        //mReserveOverflowSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.288 -0400", hash_original_method = "481A608E0CFB48388247866BAE1C540A", hash_generated_method = "87E2B32D1F0B97A5238894F1E0A59883")
    public void setItemLimit(int itemCount) {
        mMaxItems = itemCount;
        mMaxItemsSet = true;
        // ---------- Original Method ----------
        //mMaxItems = itemCount;
        //mMaxItemsSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.289 -0400", hash_original_method = "28685D1CD5555D455AA1245A08028303", hash_generated_method = "DA8155DF8D4813D0B03173FE5C681E23")
    public void setExpandedActionViewsExclusive(boolean isExclusive) {
        mExpandedActionViewsExclusive = isExclusive;
        // ---------- Original Method ----------
        //mExpandedActionViewsExclusive = isExclusive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.293 -0400", hash_original_method = "AD0B74E3B833D08F8481D15CB97EDB86", hash_generated_method = "52703A51F61154D58F50EE9BEBD244B3")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        MenuView varB4EAC82CA7396A68D541C85D26508E83_2029885621 = null; //Variable for return #1
        MenuView result;
        result = super.getMenuView(root);
        ((ActionMenuView) result).setPresenter(this);
        varB4EAC82CA7396A68D541C85D26508E83_2029885621 = result;
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2029885621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2029885621;
        // ---------- Original Method ----------
        //MenuView result = super.getMenuView(root);
        //((ActionMenuView) result).setPresenter(this);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.319 -0400", hash_original_method = "59BA3C56A8058A32CF9B2FCB0A0B5507", hash_generated_method = "01BBF480A13DC4B2AF42B5F9F2B57E4F")
    @Override
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_390507179 = null; //Variable for return #1
        View actionView;
        actionView = item.getActionView();
        {
            boolean var042A2602C5874EB8C3227D44BE9ADF6F_1141022737 = (actionView == null || item.hasCollapsibleActionView());
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
            boolean var3F4E8E87992AC39D78E62AD5C121760F_1333577331 = (!menuParent.checkLayoutParams(lp));
            {
                actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_390507179 = actionView;
        addTaint(item.getTaint());
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_390507179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_390507179;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.320 -0400", hash_original_method = "2F59AFEB76404A397084655FE3C87387", hash_generated_method = "CD92F10F3B85C08A0D679F902ED7AC4C")
    @Override
    public void bindItemView(MenuItemImpl item, MenuView.ItemView itemView) {
        itemView.initialize(item, 0);
        ActionMenuView menuView;
        menuView = (ActionMenuView) mMenuView;
        ActionMenuItemView actionItemView;
        actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
        addTaint(item.getTaint());
        addTaint(itemView.getTaint());
        // ---------- Original Method ----------
        //itemView.initialize(item, 0);
        //final ActionMenuView menuView = (ActionMenuView) mMenuView;
        //ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        //actionItemView.setItemInvoker(menuView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.321 -0400", hash_original_method = "CF6FF79E1183E432FB7F279F6A955298", hash_generated_method = "1BE68F1FDE09F2019637B3B925C64C41")
    @Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        boolean var63CDEDD9ADF2A3E4CD65B5345E84754D_2062417434 = (item.isActionButton());
        addTaint(childIndex);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353762787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353762787;
        // ---------- Original Method ----------
        //return item.isActionButton();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.331 -0400", hash_original_method = "675BFE60E67D99082131CDB4BA0667CE", hash_generated_method = "F4EAD038EEA5075A2A02062A8B4F68C8")
    @Override
    public void updateMenuView(boolean cleared) {
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
            boolean var636A254D04624E67B4E275AE8C012F60_734234776 = (mOverflowButton != null && mOverflowButton.getParent() == mMenuView);
            {
                ((ViewGroup) mMenuView).removeView(mOverflowButton);
            } //End block
        } //End collapsed parenthetic
        ((ActionMenuView) mMenuView).setOverflowReserved(mReserveOverflow);
        addTaint(cleared);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.332 -0400", hash_original_method = "9D8FC445B750A9A2E8805EF185920422", hash_generated_method = "D0A34DEF7F78E24E0F18E7BF888FED7A")
    @Override
    public boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        {
            boolean var2C5D3A435D4B7C5FC7DF763D994EC999_1409734022 = (parent.getChildAt(childIndex) == mOverflowButton);
        } //End collapsed parenthetic
        boolean var7C223E5B8CEAE7D7BF100F1F8A9FA1B9_940676649 = (super.filterLeftoverView(parent, childIndex));
        addTaint(parent.getTaint());
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141620330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141620330;
        // ---------- Original Method ----------
        //if (parent.getChildAt(childIndex) == mOverflowButton) return false;
        //return super.filterLeftoverView(parent, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.333 -0400", hash_original_method = "37299DBD51D21A28CE7BE5283912D693", hash_generated_method = "551D9DB6D8BC93961B4C0435AD58B71A")
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var89D6F494337AE8363DF4B82D8D3CD4B2_2062101139 = (!subMenu.hasVisibleItems());
        } //End collapsed parenthetic
        SubMenuBuilder topSubMenu;
        topSubMenu = subMenu;
        {
            boolean var3070E3EF1FB105EFCC31C47F14EB2042_258170153 = (topSubMenu.getParentMenu() != mMenu);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235426153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235426153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.337 -0400", hash_original_method = "D21215C119A8C9273D02F36683639F77", hash_generated_method = "32696DF1E4983E58D9B1251FC5C8CAEC")
    private View findViewForItem(MenuItem item) {
        View varB4EAC82CA7396A68D541C85D26508E83_1774006131 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_948832864 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_959244374 = null; //Variable for return #3
        ViewGroup parent;
        parent = (ViewGroup) mMenuView;
        varB4EAC82CA7396A68D541C85D26508E83_1774006131 = null;
        int count;
        count = parent.getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = parent.getChildAt(i);
                {
                    boolean var6A79BB2D965C162A835EA9549023D9A8_1376776608 = (child instanceof MenuView.ItemView &&
                    ((MenuView.ItemView) child).getItemData() == item);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_948832864 = child;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_959244374 = null;
        addTaint(item.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1614908893; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1614908893 = varB4EAC82CA7396A68D541C85D26508E83_1774006131;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1614908893 = varB4EAC82CA7396A68D541C85D26508E83_948832864;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1614908893 = varB4EAC82CA7396A68D541C85D26508E83_959244374;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1614908893.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1614908893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.350 -0400", hash_original_method = "51D4B09F0769DB498C88D93C1DD1D610", hash_generated_method = "6FC822DCEEA3C83CD3BD8F6BAE4B5923")
    public boolean showOverflowMenu() {
        {
            boolean varA5B27DD56A8D2501A2BC1F22BE54417E_1526440896 = (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null &&
                mPostedOpenRunnable == null);
            {
                OverflowPopup popup;
                popup = new OverflowPopup(mContext, mMenu, mOverflowButton, true);
                mPostedOpenRunnable = new OpenOverflowRunnable(popup);
                ((View) mMenuView).post(mPostedOpenRunnable);
                super.onSubMenuSelected(null);
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974789134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974789134;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.351 -0400", hash_original_method = "F07D2B002CE8D32774BDF7E27A216F8A", hash_generated_method = "ECED486C6458C64AC81D250C0C77EE1E")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032162736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032162736;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.351 -0400", hash_original_method = "048650AFF94B01A571A17F813CE8142B", hash_generated_method = "2E76A345C0251E1A5CEE7F7CD9775B1F")
    public boolean dismissPopupMenus() {
        boolean result;
        result = hideOverflowMenu();
        result |= hideSubMenus();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507794465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507794465;
        // ---------- Original Method ----------
        //boolean result = hideOverflowMenu();
        //result |= hideSubMenus();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.352 -0400", hash_original_method = "86830002AFDFBC8C0790A0C80E395F68", hash_generated_method = "A9C2E2BE898EBDEAF8D458F7DCE8F0B8")
    public boolean hideSubMenus() {
        {
            mActionButtonPopup.dismiss();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677872337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_677872337;
        // ---------- Original Method ----------
        //if (mActionButtonPopup != null) {
            //mActionButtonPopup.dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.352 -0400", hash_original_method = "EDFA99D71A654F51EBF8F88159FF0AE5", hash_generated_method = "7B653D6D9C96CFA47902AAC22A231156")
    public boolean isOverflowMenuShowing() {
        boolean varDDE92196405694CCE3B775C2D317192F_1689039850 = (mOverflowPopup != null && mOverflowPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12980536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_12980536;
        // ---------- Original Method ----------
        //return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.353 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "39DDED826696458BD1EF3CA88A5DD775")
    public boolean isOverflowReserved() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421494495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421494495;
        // ---------- Original Method ----------
        //return mReserveOverflow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.407 -0400", hash_original_method = "3161CCF567C7C41004F1DD2E1141CBA5", hash_generated_method = "928932C7E96C2FA9F7B48F9F869DF980")
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
                    boolean varD0608EF2260E1F8B9264901745B3863A_63496722 = (item.requiresActionButton());
                    {
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_2010170644 = (item.requestsActionButton());
                        {
                            hasOverflow = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    boolean varBBBF1208950B60080E53B87439022606_1386740604 = (mExpandedActionViewsExclusive && item.isActionViewExpanded());
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
                    boolean varD0608EF2260E1F8B9264901745B3863A_26744109 = (item.requiresActionButton());
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
                        boolean varD8421CC750216F5C60B46CDFDEBDEB05_1858796816 = (item.requestsActionButton());
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
                                            boolean var58D13C27DFD727DA00E5820FA84F8A98_1449506225 = (areYouMyGroupie.getGroupId() == groupId);
                                            {
                                                {
                                                    boolean var3845F6435C6D2EFBC5673BCA3826363D_1566333992 = (areYouMyGroupie.isActionButton());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019138707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019138707;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.408 -0400", hash_original_method = "C8ECD6F76386581509465FBD82905343", hash_generated_method = "04D5B832D8761AB87A15C6C47BBAACC6")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dismissPopupMenus();
        super.onCloseMenu(menu, allMenusAreClosing);
        addTaint(menu.getTaint());
        addTaint(allMenusAreClosing);
        // ---------- Original Method ----------
        //dismissPopupMenus();
        //super.onCloseMenu(menu, allMenusAreClosing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.434 -0400", hash_original_method = "06AD8BBBF679989CAE04F426A0FFC61D", hash_generated_method = "A705DC63C18C54029D84086B79709B62")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1051035757 = null; //Variable for return #1
        SavedState state;
        state = new SavedState();
        state.openSubMenuId = mOpenSubMenuId;
        varB4EAC82CA7396A68D541C85D26508E83_1051035757 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1051035757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1051035757;
        // ---------- Original Method ----------
        //SavedState state = new SavedState();
        //state.openSubMenuId = mOpenSubMenuId;
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.434 -0400", hash_original_method = "56321A468C9EBB2A9C3695363B6A634B", hash_generated_method = "FC866C0BA3C6C4A38724929BF90B9827")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(state.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.434 -0400", hash_original_method = "E6B8634A947A629174EE0649ED3769CC", hash_generated_method = "9038CE0FD8695612220BCFDB890B51CF")
    @Override
    public void onSubUiVisibilityChanged(boolean isVisible) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            super.onSubMenuSelected(null);
        } //End block
        {
            mMenu.close(false);
        } //End block
        addTaint(isVisible);
        // ---------- Original Method ----------
        //if (isVisible) {
            //super.onSubMenuSelected(null);
        //} else {
            //mMenu.close(false);
        //}
    }

    
    private static class SavedState implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.434 -0400", hash_original_field = "8151AAC0E48C8BC3EA418271F6C25581", hash_generated_field = "D108CA8004A7040C71E1AF0A426FBA46")

        public int openSubMenuId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.434 -0400", hash_original_method = "5B86CE655F475C08F177FDB52AD9ECFE", hash_generated_method = "4573F1D4704340137C4835179DE848FD")
          SavedState() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.435 -0400", hash_original_method = "10B6E86FE11BCC070EDA2136A91ED86D", hash_generated_method = "FC0C0D4D8A2B76282E9B2EAAF3EB5917")
          SavedState(Parcel in) {
            openSubMenuId = in.readInt();
            // ---------- Original Method ----------
            //openSubMenuId = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.435 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1DBF69FA9C5AC70EA40C1A48F0465BDF")
        @Override
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654867134 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654867134;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.435 -0400", hash_original_method = "4E7F3A208B8DADACA56997D8D1B3C90C", hash_generated_method = "9DC85952E0B3AADEAFEA647BBFB0F735")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(openSubMenuId);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //dest.writeInt(openSubMenuId);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.435 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    private class OverflowMenuButton extends ImageButton implements ActionMenuChildView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.435 -0400", hash_original_method = "1337D4EFD3D7C8CDCFFFFAE2F6FA113A", hash_generated_method = "C2CDE96F90A37867B61B1172B38B0583")
        public  OverflowMenuButton(Context context) {
            super(context, null, com.android.internal.R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(VISIBLE);
            setEnabled(true);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //setClickable(true);
            //setFocusable(true);
            //setVisibility(VISIBLE);
            //setEnabled(true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.436 -0400", hash_original_method = "133A6BF2CD1B819427A8C49FA8B8E865", hash_generated_method = "6BD11340412E7070DAFE19816ECE6EC9")
        @Override
        public boolean performClick() {
            {
                boolean var6267028C3644B44519A636F6B5EF90B1_1548624670 = (super.performClick());
            } //End collapsed parenthetic
            playSoundEffect(SoundEffectConstants.CLICK);
            showOverflowMenu();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305123645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_305123645;
            // ---------- Original Method ----------
            //if (super.performClick()) {
                //return true;
            //}
            //playSoundEffect(SoundEffectConstants.CLICK);
            //showOverflowMenu();
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.436 -0400", hash_original_method = "6BA15F1E8189A4801AF337396791DD31", hash_generated_method = "8384C88B66AB99F856C522A829817433")
        public boolean needsDividerBefore() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997142382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_997142382;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.436 -0400", hash_original_method = "CA065FAE0BB06CECFBFA2C36E268A066", hash_generated_method = "2A5A227C532E4F9ACC7B3AED01B6838D")
        public boolean needsDividerAfter() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750701409 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750701409;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    private class OverflowPopup extends MenuPopupHelper {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.436 -0400", hash_original_method = "FA0F7CD1552EAFA7C13929825A8B2112", hash_generated_method = "A93A3B40EFAA7FACDC4053B7602AAE67")
        public  OverflowPopup(Context context, MenuBuilder menu, View anchorView,
                boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly);
            setCallback(mPopupPresenterCallback);
            addTaint(context.getTaint());
            addTaint(menu.getTaint());
            addTaint(anchorView.getTaint());
            addTaint(overflowOnly);
            // ---------- Original Method ----------
            //setCallback(mPopupPresenterCallback);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.437 -0400", hash_original_method = "F12BAE7D751DC96E6D1F67F68EBC9919", hash_generated_method = "C0B66E552A56F943AE8D17ED4BE5D635")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.437 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

        private SubMenuBuilder mSubMenu;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.458 -0400", hash_original_method = "E276DF3AF8ED38FB9CAF2E195F32B2B4", hash_generated_method = "CF2113E41D7434478CC5D7953FC56703")
        public  ActionButtonSubmenu(Context context, SubMenuBuilder subMenu) {
            super(context, subMenu);
            mSubMenu = subMenu;
            MenuItemImpl item;
            item = (MenuItemImpl) subMenu.getItem();
            {
                boolean var578FB4F95786C0DE176C492E48EDBCE4_264840361 = (!item.isActionButton());
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
                        boolean var85A149AB5F872C1FDE25CE93041B2D49_1292695351 = (childItem.isVisible() && childItem.getIcon() != null);
                        {
                            preserveIconSpacing = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            setForceShowIcon(preserveIconSpacing);
            addTaint(context.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.459 -0400", hash_original_method = "69C0D5A7A155D8F50134B9E617767128", hash_generated_method = "351F511E80FA2706234E40E36A6C89F9")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.459 -0400", hash_original_method = "094885FACF5CDEF923542BEFD4BC4936", hash_generated_method = "094885FACF5CDEF923542BEFD4BC4936")
        public PopupPresenterCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.460 -0400", hash_original_method = "29547EA8801B28CE842E58C3B2A91712", hash_generated_method = "36CA4E7D8A8775F86F44722A9E3F2B9C")
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            addTaint(subMenu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_973316182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_973316182;
            // ---------- Original Method ----------
            //if (subMenu == null) return false;
            //mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.460 -0400", hash_original_method = "847A197D3775740590913F0AAA0D3207", hash_generated_method = "346D48DB65EC536A8B0327D580C6F3D2")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                ((SubMenuBuilder) menu).getRootMenu().close(false);
            } //End block
            addTaint(menu.getTaint());
            addTaint(allMenusAreClosing);
            // ---------- Original Method ----------
            //if (menu instanceof SubMenuBuilder) {
                //((SubMenuBuilder) menu).getRootMenu().close(false);
            //}
        }

        
    }


    
    private class OpenOverflowRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.474 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "A7832614732810CD7F68AEA244EAE6B6")

        private OverflowPopup mPopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.474 -0400", hash_original_method = "599E88E0D73270F72B5C8D6A6C7D2ACA", hash_generated_method = "83EF72038C4C6F336D91E4FDD7DBA957")
        public  OpenOverflowRunnable(OverflowPopup popup) {
            mPopup = popup;
            // ---------- Original Method ----------
            //mPopup = popup;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.475 -0400", hash_original_method = "A205A4B8116FA6A00F9203B1BEAEE8C7", hash_generated_method = "B54BC1385F06A3FB8F1F776897E3CAA8")
        public void run() {
            mMenu.changeMenuMode();
            View menuView;
            menuView = (View) mMenuView;
            {
                boolean var3552093DD787185B5C9D0DFE6D6F1BD0_94071821 = (menuView != null && menuView.getWindowToken() != null && mPopup.tryShow());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.475 -0400", hash_original_field = "E83447013E3A959D82815F43151988FB", hash_generated_field = "38F1E97CFD6B2A5E26842C4C4B34A730")

    private static String TAG = "ActionMenuPresenter";
}

