package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
    protected Context mSystemContext;
    protected Context mContext;
    protected MenuBuilder mMenu;
    protected LayoutInflater mSystemInflater;
    protected LayoutInflater mInflater;
    private Callback mCallback;
    private int mMenuLayoutRes;
    private int mItemLayoutRes;
    protected MenuView mMenuView;
    private int mId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.480 -0400", hash_original_method = "0D2E3D4A8E23D7091EB09B3013BF35EA", hash_generated_method = "10F3FF23139EA3F33A2F93C0A71CB180")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BaseMenuPresenter(Context context, int menuLayoutRes, int itemLayoutRes) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(itemLayoutRes);
        dsTaint.addTaint(menuLayoutRes);
        mSystemInflater = LayoutInflater.from(context);
        // ---------- Original Method ----------
        //mSystemContext = context;
        //mSystemInflater = LayoutInflater.from(context);
        //mMenuLayoutRes = menuLayoutRes;
        //mItemLayoutRes = itemLayoutRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.480 -0400", hash_original_method = "132A0398F4F3F28C73E120DA24E1764B", hash_generated_method = "ED1BF4C59420F72619D813D3AF03D420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mInflater = LayoutInflater.from(mContext);
        // ---------- Original Method ----------
        //mContext = context;
        //mInflater = LayoutInflater.from(mContext);
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.481 -0400", hash_original_method = "5077062D5DDD15E91EAE389A4058EA7D", hash_generated_method = "C21DEC9F80775F347E50A6520F045DC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MenuView getMenuView(ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        {
            mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        } //End block
        return (MenuView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mMenuView == null) {
            //mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            //mMenuView.initialize(mMenu);
            //updateMenuView(true);
        //}
        //return mMenuView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.481 -0400", hash_original_method = "F8C2A52598BC4F88A553A5E9C0F208E1", hash_generated_method = "37D292AA05BF4EFAF36901AE9E7E4A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateMenuView(boolean cleared) {
        dsTaint.addTaint(cleared);
        ViewGroup parent;
        parent = (ViewGroup) mMenuView;
        int childIndex;
        childIndex = 0;
        {
            mMenu.flagActionItems();
            ArrayList<MenuItemImpl> visibleItems;
            visibleItems = mMenu.getVisibleItems();
            int itemCount;
            itemCount = visibleItems.size();
            {
                int i;
                i = 0;
                {
                    MenuItemImpl item;
                    item = visibleItems.get(i);
                    {
                        boolean var8FAAFC2CB6919A314C82FB40D92D5E22_873144194 = (shouldIncludeItem(childIndex, item));
                        {
                            View convertView;
                            convertView = parent.getChildAt(childIndex);
                            MenuItemImpl oldItem;
                            oldItem = ((MenuView.ItemView) convertView).getItemData();
                            oldItem = null;
                            View itemView;
                            itemView = getItemView(item, convertView, parent);
                            {
                                itemView.setPressed(false);
                                itemView.jumpDrawablesToCurrentState();
                            } //End block
                            {
                                addItemView(itemView, childIndex);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varE47128A75854566F278F8B3A88B9440E_1608357674 = (childIndex < parent.getChildCount());
            {
                {
                    boolean var415BB4664FBEE66A045289027C617A74_1917498368 = (!filterLeftoverView(parent, childIndex));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.481 -0400", hash_original_method = "131BFAEC8D945AEDE48A08C61CFE6B46", hash_generated_method = "CB9FA45CFCEBB6292865C03DAF827B60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void addItemView(View itemView, int childIndex) {
        dsTaint.addTaint(itemView.dsTaint);
        dsTaint.addTaint(childIndex);
        ViewGroup currentParent;
        currentParent = (ViewGroup) itemView.getParent();
        {
            currentParent.removeView(itemView);
        } //End block
        ((ViewGroup) mMenuView).addView(itemView, childIndex);
        // ---------- Original Method ----------
        //final ViewGroup currentParent = (ViewGroup) itemView.getParent();
        //if (currentParent != null) {
            //currentParent.removeView(itemView);
        //}
        //((ViewGroup) mMenuView).addView(itemView, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.482 -0400", hash_original_method = "2A7E19722F4165D83150E5278582AE5B", hash_generated_method = "A69673703950CB0273F742EC52649817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(childIndex);
        parent.removeViewAt(childIndex);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //parent.removeViewAt(childIndex);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.482 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "483F9A7853B90884DAE3779BB5D6B837")
    @DSModeled(DSC.SAFE)
    public void setCallback(Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.482 -0400", hash_original_method = "D134EE9C84D0511ABB405D2C10EDC1CD", hash_generated_method = "E6DE6E2DD38EF3F516F3369474D81C35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuView.ItemView createItemView(ViewGroup parent) {
        dsTaint.addTaint(parent.dsTaint);
        MenuView.ItemView varFD55C8496ED6B44430C583A71EED3574_2024285724 = ((MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false));
        return (MenuView.ItemView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.482 -0400", hash_original_method = "4524E542CCB3CEBB00AD430A4F472D75", hash_generated_method = "7CC7F4DE65D71F3CD42AE95D850A93F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        MenuView.ItemView itemView;
        {
            itemView = (MenuView.ItemView) convertView;
        } //End block
        {
            itemView = createItemView(parent);
        } //End block
        bindItemView(item, itemView);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MenuView.ItemView itemView;
        //if (convertView instanceof MenuView.ItemView) {
            //itemView = (MenuView.ItemView) convertView;
        //} else {
            //itemView = createItemView(parent);
        //}
        //bindItemView(item, itemView);
        //return (View) itemView;
    }

    
    public abstract void bindItemView(MenuItemImpl item, MenuView.ItemView itemView);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.482 -0400", hash_original_method = "87E28A5B278A6CA733508943AA98463C", hash_generated_method = "0F5A184FC796D2D3E37653365AC0766A")
    @DSModeled(DSC.SAFE)
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(childIndex);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.483 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "2B68ED97B6E7482D57F83545D88A9C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(allMenusAreClosing);
        dsTaint.addTaint(menu.dsTaint);
        {
            mCallback.onCloseMenu(menu, allMenusAreClosing);
        } //End block
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //mCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.483 -0400", hash_original_method = "A5E8641CBC0C1B6BF90AAD3ACE718984", hash_generated_method = "E04576EEF417115DBAEC17874BC8DB3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onSubMenuSelected(SubMenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        {
            boolean var034DCB93A413DF52AE77850DCBE2A226_1402824670 = (mCallback.onOpenSubMenu(menu));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.onOpenSubMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.483 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "998FDDEAA46F7F6B0FBC1A1183D7CB9D")
    @DSModeled(DSC.SAFE)
    public boolean flagActionItems() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.483 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "06D6DEB17F54430F48CC6A143A52D4D4")
    @DSModeled(DSC.SAFE)
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.483 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "AAEF088C5F287CE2BA804A19EDA68A41")
    @DSModeled(DSC.SAFE)
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.483 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "8621FE03FADC0A3000742A4E8AF6A961")
    @DSModeled(DSC.SAFE)
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.484 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "5CBFA290FAF766BB14EA9091D58249BC")
    @DSModeled(DSC.SAFE)
    public void setId(int id) {
        dsTaint.addTaint(id);
        // ---------- Original Method ----------
        //mId = id;
    }

    
}

