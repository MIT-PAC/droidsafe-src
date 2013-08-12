package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;





public abstract class BaseMenuPresenter implements MenuPresenter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.143 -0400", hash_original_field = "A0F03383C9D11CB5B436FDD418A9C4FE", hash_generated_field = "9BBD2C5E70A5CAEEE85328B585C6EDD6")

    protected Context mSystemContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "FD524EB2A4E22F4B2E2213811669D12E")

    protected MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "F49E034E895E82C1925C0FB9A906E108", hash_generated_field = "9175061DB185D7353CA0BE481FFC4473")

    protected LayoutInflater mSystemInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "76F426D24BEF6D52944D0403F5710568")

    protected LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "8D1C5FC738EA58636C70F8500B791027", hash_generated_field = "4FE937236E901E4D73D88B87E9D305E0")

    private int mMenuLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.144 -0400", hash_original_field = "DAA48533FE83262630AE429727835DDE", hash_generated_field = "C816B664A95F5226F0E062333FAD6D81")

    private int mItemLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.145 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "09958BB4E6973250CC3EA4C3B0BA7E7B")

    protected MenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.145 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.146 -0400", hash_original_method = "0D2E3D4A8E23D7091EB09B3013BF35EA", hash_generated_method = "EFC8E55D6915876AF3E5840EE23B1AEB")
    public  BaseMenuPresenter(Context context, int menuLayoutRes, int itemLayoutRes) {
        mSystemContext = context;
        mSystemInflater = LayoutInflater.from(context);
        mMenuLayoutRes = menuLayoutRes;
        mItemLayoutRes = itemLayoutRes;
        // ---------- Original Method ----------
        //mSystemContext = context;
        //mSystemInflater = LayoutInflater.from(context);
        //mMenuLayoutRes = menuLayoutRes;
        //mItemLayoutRes = itemLayoutRes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.147 -0400", hash_original_method = "132A0398F4F3F28C73E120DA24E1764B", hash_generated_method = "E01E7C26740154C462790FD515E64B6D")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mMenu = menu;
        // ---------- Original Method ----------
        //mContext = context;
        //mInflater = LayoutInflater.from(mContext);
        //mMenu = menu;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.148 -0400", hash_original_method = "5077062D5DDD15E91EAE389A4058EA7D", hash_generated_method = "2EAA2587D85BA2E4BB4CFEAE6E987F06")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        if(mMenuView == null)        
        {
            mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        } //End block
MenuView var7E140BC01DB9AC7A99D01C4BFF6F142B_1180237723 =         mMenuView;
        var7E140BC01DB9AC7A99D01C4BFF6F142B_1180237723.addTaint(taint);
        return var7E140BC01DB9AC7A99D01C4BFF6F142B_1180237723;
        // ---------- Original Method ----------
        //if (mMenuView == null) {
            //mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            //mMenuView.initialize(mMenu);
            //updateMenuView(true);
        //}
        //return mMenuView;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.149 -0400", hash_original_method = "F8C2A52598BC4F88A553A5E9C0F208E1", hash_generated_method = "B0A9DCAB9E0324778FAD4CBE867821DD")
    public void updateMenuView(boolean cleared) {
        addTaint(cleared);
        final ViewGroup parent = (ViewGroup) mMenuView;
        if(parent == null)        
        return;
        int childIndex = 0;
        if(mMenu != null)        
        {
            mMenu.flagActionItems();
            ArrayList<MenuItemImpl> visibleItems = mMenu.getVisibleItems();
            final int itemCount = visibleItems.size();
for(int i = 0;i < itemCount;i++)
            {
                MenuItemImpl item = visibleItems.get(i);
                if(shouldIncludeItem(childIndex, item))                
                {
                    final View convertView = parent.getChildAt(childIndex);
                    final MenuItemImpl oldItem = convertView instanceof MenuView.ItemView ?
                            ((MenuView.ItemView) convertView).getItemData() : null;
                    final View itemView = getItemView(item, convertView, parent);
                    if(item != oldItem)                    
                    {
                        itemView.setPressed(false);
                        itemView.jumpDrawablesToCurrentState();
                    } //End block
                    if(itemView != convertView)                    
                    {
                        addItemView(itemView, childIndex);
                    } //End block
                    childIndex++;
                } //End block
            } //End block
        } //End block
        while
(childIndex < parent.getChildCount())        
        {
            if(!filterLeftoverView(parent, childIndex))            
            {
                childIndex++;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.150 -0400", hash_original_method = "131BFAEC8D945AEDE48A08C61CFE6B46", hash_generated_method = "3C69ACA94D06C87685B05A31DCA3D4DE")
    protected void addItemView(View itemView, int childIndex) {
        addTaint(childIndex);
        addTaint(itemView.getTaint());
        final ViewGroup currentParent = (ViewGroup) itemView.getParent();
        if(currentParent != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.151 -0400", hash_original_method = "2A7E19722F4165D83150E5278582AE5B", hash_generated_method = "AE2747C33CB663FDA188E13722D9EB33")
    protected boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        addTaint(childIndex);
        addTaint(parent.getTaint());
        parent.removeViewAt(childIndex);
        boolean varB326B5062B2F0E69046810717534CB09_1684667763 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042847183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042847183;
        // ---------- Original Method ----------
        //parent.removeViewAt(childIndex);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.152 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.152 -0400", hash_original_method = "D134EE9C84D0511ABB405D2C10EDC1CD", hash_generated_method = "772D2675B04A4FE424B4B7E221119BA3")
    public MenuView.ItemView createItemView(ViewGroup parent) {
        addTaint(parent.getTaint());
MenuView.ItemView varEEF290D4AF2FD2B99EA512C39FD6E4DC_197011519 =         (MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false);
        varEEF290D4AF2FD2B99EA512C39FD6E4DC_197011519.addTaint(taint);
        return varEEF290D4AF2FD2B99EA512C39FD6E4DC_197011519;
        // ---------- Original Method ----------
        //return (MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.153 -0400", hash_original_method = "4524E542CCB3CEBB00AD430A4F472D75", hash_generated_method = "A74DFC3D06A716D50AF1896254DF5309")
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(item.getTaint());
        MenuView.ItemView itemView;
        if(convertView instanceof MenuView.ItemView)        
        {
            itemView = (MenuView.ItemView) convertView;
        } //End block
        else
        {
            itemView = createItemView(parent);
        } //End block
        bindItemView(item, itemView);
View var71C21EAF51F71E74CDDCB5F8C6AA9443_1843933953 =         (View) itemView;
        var71C21EAF51F71E74CDDCB5F8C6AA9443_1843933953.addTaint(taint);
        return var71C21EAF51F71E74CDDCB5F8C6AA9443_1843933953;
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

    
    @DSModeled(DSC.SAFE)
    public abstract void bindItemView(MenuItemImpl item, MenuView.ItemView itemView);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.153 -0400", hash_original_method = "87E28A5B278A6CA733508943AA98463C", hash_generated_method = "A1536F497529D91E6AC6F8FF638398CD")
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(childIndex);
        boolean varB326B5062B2F0E69046810717534CB09_1991528076 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235054513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235054513;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.154 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "14AC8FDD08577D1D1AB5D57A2105137A")
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
        if(mCallback != null)        
        {
            mCallback.onCloseMenu(menu, allMenusAreClosing);
        } //End block
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //mCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.154 -0400", hash_original_method = "A5E8641CBC0C1B6BF90AAD3ACE718984", hash_generated_method = "4850AE6F435E97FF120579232FE82D0B")
    public boolean onSubMenuSelected(SubMenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        if(mCallback != null)        
        {
            boolean varDFC01D4E870A39F9B742CDA339844616_241130102 = (mCallback.onOpenSubMenu(menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287103382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287103382;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2064750579 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723313057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_723313057;
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.onOpenSubMenu(menu);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.155 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "325E8A0D6B1E27DDEE0CEC015D673125")
    public boolean flagActionItems() {
        boolean var68934A3E9455FA72420237EB05902327_1527370899 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238705754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238705754;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.155 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "E7AE2D2E20BA59975EC798B60E240910")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_606255064 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156901366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156901366;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.155 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "CC40FE3382182A2E53FE4AFAD4903539")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_853792628 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153497843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153497843;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.156 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "FD5E1BD13A6693909D0F478069162659")
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_1674371861 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48328814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48328814;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.156 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "0D5694E56798677AE48CDBAFFCA223E5")
    public void setId(int id) {
        mId = id;
        // ---------- Original Method ----------
        //mId = id;
    }

    
}

