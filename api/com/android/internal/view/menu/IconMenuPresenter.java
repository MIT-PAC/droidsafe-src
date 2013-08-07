package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import android.view.MenuItem;
import android.os.Parcelable;
import com.android.internal.view.menu.MenuView.ItemView;
import android.view.ContextThemeWrapper;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.util.SparseArray;
import android.os.Bundle;
public class IconMenuPresenter extends BaseMenuPresenter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.342 -0400", hash_original_field = "9B1F10A2F0A7D370A982868A4E00614C", hash_generated_field = "10DFB69FB3DA0930CA6D1E515C9607B5")

    private IconMenuItemView mMoreView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.343 -0400", hash_original_field = "E30EA73178BDB5EBD4209D3CBB421189", hash_generated_field = "D8A94B6E010E956EDCB35B4666C445EA")

    private int mMaxItems = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.343 -0400", hash_original_field = "69B273247C1407653A216446C3964BA2", hash_generated_field = "0BCBB7C2003D06DDB90F4DA92F90C05F")

    int mOpenSubMenuId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.343 -0400", hash_original_field = "7C9F6DCE953D3DE00D70A1DF37F25CC1", hash_generated_field = "F22E56ED0ECFA1D7E2D0DEE95D8F2988")

    SubMenuPresenterCallback mSubMenuPresenterCallback = new SubMenuPresenterCallback();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.343 -0400", hash_original_field = "33524290C9DF8D1726C53CCEFA9BEDF5", hash_generated_field = "7CDFADF0043D8FA5089C3DFB49F6FBB0")

    MenuDialogHelper mOpenSubMenu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.344 -0400", hash_original_method = "EAE51773EBE43F906BD717B06D1E13A8", hash_generated_method = "C32A3AA93B60CC70985E564469B1D0C1")
    public  IconMenuPresenter(Context context) {
        super(new ContextThemeWrapper(context, com.android.internal.R.style.Theme_IconMenu),
                com.android.internal.R.layout.icon_menu_layout,
                com.android.internal.R.layout.icon_menu_item_layout);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.345 -0400", hash_original_method = "0C671CFCCE8440DF664FCFC418CDEFDA", hash_generated_method = "48A9BB55BF49175B29A358A364FE6EDC")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        addTaint(menu.getTaint());
        addTaint(context.getTaint());
super.initForMenu(context, menu)mMaxItems=-1
        // ---------- Original Method ----------
        //super.initForMenu(context, menu);
        //mMaxItems = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.346 -0400", hash_original_method = "893BCB99609444F1E1525BDBE5A6099D", hash_generated_method = "FFD03DD434FA6C1B4A075D28E01AB4E4")
    @Override
    public void bindItemView(MenuItemImpl item, ItemView itemView) {
        addTaint(itemView.getTaint());
        addTaint(item.getTaint());
        final IconMenuItemView view = (IconMenuItemView) itemView;
view.setItemData(item)view.initialize(item.getTitleForItemView(view), item.getIcon())view.setVisibility(item.isVisible()?View.VISIBLE:View.VISIBLE)view.setEnabled(view.isEnabled())view.setLayoutParams(view.getTextAppropriateLayoutParams())
        // ---------- Original Method ----------
        //final IconMenuItemView view = (IconMenuItemView) itemView;
        //view.setItemData(item);
        //view.initialize(item.getTitleForItemView(view), item.getIcon());
        //view.setVisibility(item.isVisible() ? View.VISIBLE : View.GONE);
        //view.setEnabled(view.isEnabled());
        //view.setLayoutParams(view.getTextAppropriateLayoutParams());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.346 -0400", hash_original_method = "570C3DBAE1FE511DD264FFF410D2CDDB", hash_generated_method = "EB9BE53CE28D6170EF425BFE48F2E80C")
    @Override
    public boolean shouldIncludeItem(int childIndex, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(childIndex);
        final ArrayList<MenuItemImpl> itemsToShow = mMenu.getNonActionItems();
        boolean fits = (itemsToShow.size() == mMaxItems && childIndex < mMaxItems) ||
                childIndex < mMaxItems - 1;
        boolean var444D6F1874CF4FE7E7AE20DDDECF0417_518825387 = (fits&&!item.isActionButton());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437963158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_437963158;
        // ---------- Original Method ----------
        //final ArrayList<MenuItemImpl> itemsToShow = mMenu.getNonActionItems();
        //boolean fits = (itemsToShow.size() == mMaxItems && childIndex < mMaxItems) ||
                //childIndex < mMaxItems - 1;
        //return fits && !item.isActionButton();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.347 -0400", hash_original_method = "6CA4A93A96CF1611921D3C27246B0489", hash_generated_method = "98A7799C0D8C50A1446557E1463828B6")
    @Override
    protected void addItemView(View itemView, int childIndex) {
        addTaint(childIndex);
        addTaint(itemView.getTaint());
        final IconMenuItemView v = (IconMenuItemView) itemView;
        final IconMenuView parent = (IconMenuView) mMenuView;
v.setIconMenuView(parent)v.setItemInvoker(parent)v.setBackgroundDrawable(parent.getItemBackgroundDrawable())super.addItemView(itemView, childIndex)
        // ---------- Original Method ----------
        //final IconMenuItemView v = (IconMenuItemView) itemView;
        //final IconMenuView parent = (IconMenuView) mMenuView;
        //v.setIconMenuView(parent);
        //v.setItemInvoker(parent);
        //v.setBackgroundDrawable(parent.getItemBackgroundDrawable());
        //super.addItemView(itemView, childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.348 -0400", hash_original_method = "2D39A72F4AC5AEEEE45D5ABB44847752", hash_generated_method = "55D6192F0AD775EE775D6790F24BED0F")
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        if(!subMenu.hasVisibleItems())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1269034649 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_716212819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_716212819;
        }
        MenuDialogHelper helper = new MenuDialogHelper(subMenu);
helper.setPresenterCallback(mSubMenuPresenterCallback)helper.show(null)mOpenSubMenu=helpermOpenSubMenuId=subMenu.getItem().getItemId()super.onSubMenuSelected(subMenu)        boolean varB326B5062B2F0E69046810717534CB09_516168237 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806226477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806226477;
        // ---------- Original Method ----------
        //if (!subMenu.hasVisibleItems()) return false;
        //MenuDialogHelper helper = new MenuDialogHelper(subMenu);
        //helper.setPresenterCallback(mSubMenuPresenterCallback);
        //helper.show(null);
        //mOpenSubMenu = helper;
        //mOpenSubMenuId = subMenu.getItem().getItemId();
        //super.onSubMenuSelected(subMenu);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.348 -0400", hash_original_method = "64E1DE5861651788730CD2BF0B7FDECA", hash_generated_method = "311CD9D9D8DAD765B9357EF546917B24")
    @Override
    public void updateMenuView(boolean cleared) {
        addTaint(cleared);
        final IconMenuView menuView = (IconMenuView) mMenuView;
        if(mMaxItems<0)        
mMaxItems=menuView.getMaxItems()
        final ArrayList<MenuItemImpl> itemsToShow = mMenu.getNonActionItems();
        final boolean needsMore = itemsToShow.size() > mMaxItems;
super.updateMenuView(cleared)        if(needsMore&&(mMoreView==null||mMoreView.getParent()!=menuView))        
        {
            if(mMoreView==null)            
            {
mMoreView=menuView.createMoreItemView()mMoreView.setBackgroundDrawable(menuView.getItemBackgroundDrawable())
            } //End block
menuView.addView(mMoreView)
        } //End block
        else
        if(!needsMore&&mMoreView!=null)        
        {
menuView.removeView(mMoreView)
        } //End block
menuView.setNumActualItemsShown(needsMore?mMaxItems-1:mMaxItems-1)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.349 -0400", hash_original_method = "2B5E56C6CC939040511DDEDD9074D027", hash_generated_method = "5193A71B5426D08160A20DE67706DF36")
    @Override
    protected boolean filterLeftoverView(ViewGroup parent, int childIndex) {
        addTaint(childIndex);
        addTaint(parent.getTaint());
        if(parent.getChildAt(childIndex)!=mMoreView)        
        {
            boolean varBB0CCEB8105BB714C10CAE9AFBF070E5_747304754 = (super.filterLeftoverView(parent, childIndex));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283376643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_283376643;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_259831637 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313974975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313974975;
        // ---------- Original Method ----------
        //if (parent.getChildAt(childIndex) != mMoreView) {
            //return super.filterLeftoverView(parent, childIndex);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.350 -0400", hash_original_method = "1FE2F6FBA9303F4E72CC9CD6E3B7E748", hash_generated_method = "8B1F29D09DE4F8D0929F07201895E72F")
    public int getNumActualItemsShown() {
        int var272E9DA5983F3E80CD0C874F28CE358A_1530233472 = (((IconMenuView) mMenuView).getNumActualItemsShown());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625410712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625410712;
        // ---------- Original Method ----------
        //return ((IconMenuView) mMenuView).getNumActualItemsShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.350 -0400", hash_original_method = "0B368829F15D6906C64A9F7093B6493E", hash_generated_method = "70CD77063EB4F782F37C96C160F09D82")
    public void saveHierarchyState(Bundle outState) {
        addTaint(outState.getTaint());
        SparseArray<Parcelable> viewStates = new SparseArray<Parcelable>();
        if(mMenuView!=null)        
        {
((View) mMenuView).saveHierarchyState(viewStates)
        } //End block
outState.putSparseParcelableArray(VIEWS_TAG, viewStates)
        // ---------- Original Method ----------
        //SparseArray<Parcelable> viewStates = new SparseArray<Parcelable>();
        //if (mMenuView != null) {
            //((View) mMenuView).saveHierarchyState(viewStates);
        //}
        //outState.putSparseParcelableArray(VIEWS_TAG, viewStates);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.351 -0400", hash_original_method = "DEC28830089F716CE0B9EDF8807D3BAF", hash_generated_method = "0309A973DD2E99A799576C7D1C0EE329")
    public void restoreHierarchyState(Bundle inState) {
        addTaint(inState.getTaint());
        SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        if(viewStates!=null)        
        {
((View) mMenuView).restoreHierarchyState(viewStates)
        } //End block
        int subMenuId = inState.getInt(OPEN_SUBMENU_KEY, 0);
        if(subMenuId>0&&mMenu!=null)        
        {
            MenuItem item = mMenu.findItem(subMenuId);
            if(item!=null)            
            {
onSubMenuSelected((SubMenuBuilder) item.getSubMenu())
            } //End block
        } //End block
        // ---------- Original Method ----------
        //SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        //if (viewStates != null) {
            //((View) mMenuView).restoreHierarchyState(viewStates);
        //}
        //int subMenuId = inState.getInt(OPEN_SUBMENU_KEY, 0);
        //if (subMenuId > 0 && mMenu != null) {
            //MenuItem item = mMenu.findItem(subMenuId);
            //if (item != null) {
                //onSubMenuSelected((SubMenuBuilder) item.getSubMenu());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.351 -0400", hash_original_method = "2355ABB79B16A9A5BCFFE2F83402755D", hash_generated_method = "ED70C055088D97969A911E2F90EA6F23")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mMenuView==null)        
        {
Parcelable var540C13E9E156B687226421B24F2DF178_2039455006 = null            var540C13E9E156B687226421B24F2DF178_2039455006.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2039455006;
        } //End block
        Bundle state = new Bundle();
saveHierarchyState(state)        if(mOpenSubMenuId>0)        
        {
state.putInt(OPEN_SUBMENU_KEY, mOpenSubMenuId)
        } //End block
Parcelable var37C56C9D63C623261861C16DCFB73F6D_158628090 = state        var37C56C9D63C623261861C16DCFB73F6D_158628090.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_158628090;
        // ---------- Original Method ----------
        //if (mMenuView == null) {
            //return null;
        //}
        //Bundle state = new Bundle();
        //saveHierarchyState(state);
        //if (mOpenSubMenuId > 0) {
            //state.putInt(OPEN_SUBMENU_KEY, mOpenSubMenuId);
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.352 -0400", hash_original_method = "4E57F37A0749F365E081EFA3C3A26D3A", hash_generated_method = "8BA6CBBA300C6A2B379FB4E4D28075D1")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
restoreHierarchyState((Bundle) state)
        // ---------- Original Method ----------
        //restoreHierarchyState((Bundle) state);
    }

    
    class SubMenuPresenterCallback implements MenuPresenter.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.352 -0400", hash_original_method = "44A2219569C40DD54A4DC607A8601AB4", hash_generated_method = "44A2219569C40DD54A4DC607A8601AB4")
        public SubMenuPresenterCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.352 -0400", hash_original_method = "FE674E083F828944040D0AC17B315A9A", hash_generated_method = "E1656470194594E6FB4CB1EB580A78F4")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(allMenusAreClosing);
            addTaint(menu.getTaint());
mOpenSubMenuId=0            if(mOpenSubMenu!=null)            
            {
mOpenSubMenu.dismiss()mOpenSubMenu=null
            } //End block
            // ---------- Original Method ----------
            //mOpenSubMenuId = 0;
            //if (mOpenSubMenu != null) {
                //mOpenSubMenu.dismiss();
                //mOpenSubMenu = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.353 -0400", hash_original_method = "9FC917267C34B7141471BDE830C1C7EE", hash_generated_method = "E851BF779673284C8255A8A77C39C85E")
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            if(subMenu!=null)            
            {
mOpenSubMenuId=((SubMenuBuilder) subMenu).getItem().getItemId()
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1618218324 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453816474 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453816474;
            // ---------- Original Method ----------
            //if (subMenu != null) {
                //mOpenSubMenuId = ((SubMenuBuilder) subMenu).getItem().getItemId();
            //}
            //return false;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.353 -0400", hash_original_field = "38DA10990B0001A48A6398BFFAF30BA2", hash_generated_field = "418DB3B9077FA3302EC427CEE064CE9D")

    private static final String VIEWS_TAG = "android:menu:icon";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.353 -0400", hash_original_field = "80F48CE00CB200EB9221E3B25CF78798", hash_generated_field = "7B5C5EAA7487ECA2ECB05CE6847FA554")

    private static final String OPEN_SUBMENU_KEY = "android:menu:icon:submenu";
}

