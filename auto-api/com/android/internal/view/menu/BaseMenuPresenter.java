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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.038 -0400", hash_original_field = "A0F03383C9D11CB5B436FDD418A9C4FE", hash_generated_field = "9BBD2C5E70A5CAEEE85328B585C6EDD6")

    protected Context mSystemContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "FD524EB2A4E22F4B2E2213811669D12E")

    protected MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "F49E034E895E82C1925C0FB9A906E108", hash_generated_field = "9175061DB185D7353CA0BE481FFC4473")

    protected LayoutInflater mSystemInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "76F426D24BEF6D52944D0403F5710568")

    protected LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "8D1C5FC738EA58636C70F8500B791027", hash_generated_field = "4FE937236E901E4D73D88B87E9D305E0")

    private int mMenuLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "DAA48533FE83262630AE429727835DDE", hash_generated_field = "C816B664A95F5226F0E062333FAD6D81")

    private int mItemLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "09958BB4E6973250CC3EA4C3B0BA7E7B")

    protected MenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.039 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.044 -0400", hash_original_method = "0D2E3D4A8E23D7091EB09B3013BF35EA", hash_generated_method = "EFC8E55D6915876AF3E5840EE23B1AEB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.044 -0400", hash_original_method = "132A0398F4F3F28C73E120DA24E1764B", hash_generated_method = "E01E7C26740154C462790FD515E64B6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.045 -0400", hash_original_method = "5077062D5DDD15E91EAE389A4058EA7D", hash_generated_method = "37578DA0EEE8E38B3F0DBB49E98A0ACF")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        MenuView varB4EAC82CA7396A68D541C85D26508E83_1043904928 = null; //Variable for return #1
        {
            mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            mMenuView.initialize(mMenu);
            updateMenuView(true);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1043904928 = mMenuView;
        varB4EAC82CA7396A68D541C85D26508E83_1043904928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1043904928;
        // ---------- Original Method ----------
        //if (mMenuView == null) {
            //mMenuView = (MenuView) mSystemInflater.inflate(mMenuLayoutRes, root, false);
            //mMenuView.initialize(mMenu);
            //updateMenuView(true);
        //}
        //return mMenuView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.050 -0400", hash_original_method = "F8C2A52598BC4F88A553A5E9C0F208E1", hash_generated_method = "15617527659024CF18CB3661C7C7AEF8")
    public void updateMenuView(boolean cleared) {
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
                        boolean var8FAAFC2CB6919A314C82FB40D92D5E22_1741543665 = (shouldIncludeItem(childIndex, item));
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
            boolean varE47128A75854566F278F8B3A88B9440E_1206003825 = (childIndex < parent.getChildCount());
            {
                {
                    boolean var415BB4664FBEE66A045289027C617A74_498999758 = (!filterLeftoverView(parent, childIndex));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cleared);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.051 -0400", hash_original_method = "131BFAEC8D945AEDE48A08C61CFE6B46", hash_generated_method = "88FDE4D75CCE28826CA853B37DEA980C")
    protected void addItemView(View itemView, int childIndex) {
        ViewGroup currentParent;
        currentParent = (ViewGroup) itemView.getParent();
        {
            currentParent.removeView(itemView);
        } //End block
        ((ViewGroup) mMenuView).addView(itemView, childIndex);
        addTaint(itemView.getTaint());
        addTaint(childIndex);
        // ---------- Original Method ----------
        //final ViewGroup currentParent = (ViewGroup) itemView.getParent();
        //if (currentParent != null) {
            //currentParent.removeView(itemView);
        //}
        //((ViewGroup) mMenuView).addView(itemView, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.057 -0400", hash_original_method = "2A7E19722F4165D83150E5278582AE5B", hash_generated_method = "3499B438709E1D4A059F2A049DEBE2CB")
    protected boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        parent.removeViewAt(childIndex);
        addTaint(parent.getTaint());
        addTaint(childIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91160196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_91160196;
        // ---------- Original Method ----------
        //parent.removeViewAt(childIndex);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.057 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "00DC0446DE1FD15986660B6447845996")
    public void setCallback(Callback cb) {
        mCallback = cb;
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.057 -0400", hash_original_method = "D134EE9C84D0511ABB405D2C10EDC1CD", hash_generated_method = "6BA3938B6E62A7C3C0F815FE7886938A")
    public MenuView.ItemView createItemView(ViewGroup parent) {
        MenuView.ItemView varB4EAC82CA7396A68D541C85D26508E83_1647414866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1647414866 = (MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false);
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1647414866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1647414866;
        // ---------- Original Method ----------
        //return (MenuView.ItemView) mSystemInflater.inflate(mItemLayoutRes, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.058 -0400", hash_original_method = "4524E542CCB3CEBB00AD430A4F472D75", hash_generated_method = "EF994BBD06FB55F3D28453B47B06074E")
    public View getItemView(MenuItemImpl item, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_716431224 = null; //Variable for return #1
        MenuView.ItemView itemView;
        {
            itemView = (MenuView.ItemView) convertView;
        } //End block
        {
            itemView = createItemView(parent);
        } //End block
        bindItemView(item, itemView);
        varB4EAC82CA7396A68D541C85D26508E83_716431224 = (View) itemView;
        addTaint(item.getTaint());
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_716431224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_716431224;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.058 -0400", hash_original_method = "87E28A5B278A6CA733508943AA98463C", hash_generated_method = "F585B50945518B1E93E710CFEF7E29ED")
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        addTaint(childIndex);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935120569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_935120569;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.061 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "33930FD46871BDD0EFC9769E3AB32D65")
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mCallback.onCloseMenu(menu, allMenusAreClosing);
        } //End block
        addTaint(menu.getTaint());
        addTaint(allMenusAreClosing);
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //mCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.061 -0400", hash_original_method = "A5E8641CBC0C1B6BF90AAD3ACE718984", hash_generated_method = "77AFAE7E664E8B09AD787C54198FC083")
    public boolean onSubMenuSelected(SubMenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var034DCB93A413DF52AE77850DCBE2A226_486430030 = (mCallback.onOpenSubMenu(menu));
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1291517442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1291517442;
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.onOpenSubMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.061 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "96C41ECC77D504AFA9A81D523B335DFC")
    public boolean flagActionItems() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660536076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_660536076;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.066 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "AC6710E367144CC80869CBE530FCB964")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267539428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_267539428;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.074 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "2901525C9593549203EB6DC55FC4CEA2")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887699993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887699993;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.074 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "669E86F5A0989CB2DB6FB05BEEFCA13E")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132266442 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132266442;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.075 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "0D5694E56798677AE48CDBAFFCA223E5")
    public void setId(int id) {
        mId = id;
        // ---------- Original Method ----------
        //mId = id;
    }

    
}

