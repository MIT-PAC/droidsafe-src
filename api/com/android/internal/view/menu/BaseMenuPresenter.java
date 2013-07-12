package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "A0F03383C9D11CB5B436FDD418A9C4FE", hash_generated_field = "9BBD2C5E70A5CAEEE85328B585C6EDD6")

    protected Context mSystemContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "FD524EB2A4E22F4B2E2213811669D12E")

    protected MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "F49E034E895E82C1925C0FB9A906E108", hash_generated_field = "9175061DB185D7353CA0BE481FFC4473")

    protected LayoutInflater mSystemInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "76F426D24BEF6D52944D0403F5710568")

    protected LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "8D1C5FC738EA58636C70F8500B791027", hash_generated_field = "4FE937236E901E4D73D88B87E9D305E0")

    private int mMenuLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "DAA48533FE83262630AE429727835DDE", hash_generated_field = "C816B664A95F5226F0E062333FAD6D81")

    private int mItemLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "09958BB4E6973250CC3EA4C3B0BA7E7B")

    protected MenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.064 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.065 -0400", hash_original_method = "0D2E3D4A8E23D7091EB09B3013BF35EA", hash_generated_method = "EFC8E55D6915876AF3E5840EE23B1AEB")
    public  BaseMenuPresenter(Context context, int menuLayoutRes, int itemLayoutRes) {
        mSystemContext = context;
        mSystemInflater = LayoutInflater.from(context);
        mMenuLayoutRes = menuLayoutRes;
        mItemLayoutRes = itemLayoutRes;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.066 -0400", hash_original_method = "132A0398F4F3F28C73E120DA24E1764B", hash_generated_method = "E01E7C26740154C462790FD515E64B6D")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mMenu = menu;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.066 -0400", hash_original_method = "5077062D5DDD15E91EAE389A4058EA7D", hash_generated_method = "36A4D432ED3636A5520D76F7F573B8B5")
    @Override
    public MenuView getMenuView(ViewGroup root) {
    if(mMenuView == null)        
        {
            mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        } 
MenuView var7E140BC01DB9AC7A99D01C4BFF6F142B_1946454695 =         mMenuView;
        var7E140BC01DB9AC7A99D01C4BFF6F142B_1946454695.addTaint(taint);
        return var7E140BC01DB9AC7A99D01C4BFF6F142B_1946454695;
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.067 -0400", hash_original_method = "F8C2A52598BC4F88A553A5E9C0F208E1", hash_generated_method = "B0A9DCAB9E0324778FAD4CBE867821DD")
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
                    } 
    if(itemView != convertView)                    
                    {
                        addItemView(itemView, childIndex);
                    } 
                    childIndex++;
                } 
            } 
        } 
        while
(childIndex < parent.getChildCount())        
        {
    if(!filterLeftoverView(parent, childIndex))            
            {
                childIndex++;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.067 -0400", hash_original_method = "131BFAEC8D945AEDE48A08C61CFE6B46", hash_generated_method = "3C69ACA94D06C87685B05A31DCA3D4DE")
    protected void addItemView(View itemView, int childIndex) {
        addTaint(childIndex);
        addTaint(itemView.getTaint());
        final ViewGroup currentParent = (ViewGroup) itemView.getParent();
    if(currentParent != null)        
        {
            currentParent.removeView(itemView);
        } 
        ((ViewGroup) mMenuView).addView(itemView, childIndex);
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.068 -0400", hash_original_method = "2A7E19722F4165D83150E5278582AE5B", hash_generated_method = "F1952D7A1747FBB35EC80981B92DABF5")
    protected boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        addTaint(childIndex);
        addTaint(parent.getTaint());
        parent.removeViewAt(childIndex);
        boolean varB326B5062B2F0E69046810717534CB09_1135421223 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436081524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436081524;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.068 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.068 -0400", hash_original_method = "D134EE9C84D0511ABB405D2C10EDC1CD", hash_generated_method = "C4807BD370232A083C9B78F2783D64A0")
    public MenuView.ItemView createItemView(ViewGroup parent) {
        addTaint(parent.getTaint());
MenuView.ItemView varEEF290D4AF2FD2B99EA512C39FD6E4DC_1981676597 =         (MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false);
        varEEF290D4AF2FD2B99EA512C39FD6E4DC_1981676597.addTaint(taint);
        return varEEF290D4AF2FD2B99EA512C39FD6E4DC_1981676597;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.069 -0400", hash_original_method = "4524E542CCB3CEBB00AD430A4F472D75", hash_generated_method = "01D95827008D01266C2F898749CACEE7")
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(item.getTaint());
        MenuView.ItemView itemView;
    if(convertView instanceof MenuView.ItemView)        
        {
            itemView = (MenuView.ItemView) convertView;
        } 
        else
        {
            itemView = createItemView(parent);
        } 
        bindItemView(item, itemView);
View var71C21EAF51F71E74CDDCB5F8C6AA9443_991152127 =         (View) itemView;
        var71C21EAF51F71E74CDDCB5F8C6AA9443_991152127.addTaint(taint);
        return var71C21EAF51F71E74CDDCB5F8C6AA9443_991152127;
        
        
        
            
        
            
        
        
        
    }

    
    public abstract void bindItemView(MenuItemImpl item, MenuView.ItemView itemView);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.070 -0400", hash_original_method = "87E28A5B278A6CA733508943AA98463C", hash_generated_method = "C92F2390A372CFDFD1F4CE26AD4F01C5")
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(childIndex);
        boolean varB326B5062B2F0E69046810717534CB09_667759013 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014995554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014995554;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.071 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "14AC8FDD08577D1D1AB5D57A2105137A")
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
    if(mCallback != null)        
        {
            mCallback.onCloseMenu(menu, allMenusAreClosing);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.071 -0400", hash_original_method = "A5E8641CBC0C1B6BF90AAD3ACE718984", hash_generated_method = "E45A395B320C87081AE8DF2AF4B4A5B5")
    public boolean onSubMenuSelected(SubMenuBuilder menu) {
        
        addTaint(menu.getTaint());
    if(mCallback != null)        
        {
            boolean varDFC01D4E870A39F9B742CDA339844616_455091165 = (mCallback.onOpenSubMenu(menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877821401 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_877821401;
        } 
        boolean var68934A3E9455FA72420237EB05902327_794785054 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388054371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388054371;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.072 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "6FC16F27A0B267DACD8C6724E7C04D54")
    public boolean flagActionItems() {
        boolean var68934A3E9455FA72420237EB05902327_295292153 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286747801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286747801;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.072 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "F26D1D257FBF660CF03101A440EFB287")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_298017828 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153551628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153551628;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.073 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "913A707613635BFA292E2D2A98237FEC")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1444181844 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182372736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182372736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.073 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "2F47F668C1D975E1C43EE18AA031F4D1")
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_1758053383 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528193161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528193161;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.074 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "0D5694E56798677AE48CDBAFFCA223E5")
    public void setId(int id) {
        mId = id;
        
        
    }

    
}

