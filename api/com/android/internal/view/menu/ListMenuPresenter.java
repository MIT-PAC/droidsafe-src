package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.util.SparseArray;
import android.widget.AdapterView;
import android.view.LayoutInflater;
import android.os.Bundle;
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.447 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.447 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.447 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

    MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.447 -0400", hash_original_field = "4301CED8C5B8959C82A54CDC142B837C", hash_generated_field = "B73614E12B984F9819EE1358997EAA4E")

    ExpandedMenuView mMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.448 -0400", hash_original_field = "473475179E5B8394888872F8261BCF2E", hash_generated_field = "1847A8F34C35735278587A63D3DF790A")

    private int mItemIndexOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.448 -0400", hash_original_field = "4E00A7722C86453DDDE70A3B3990B68F", hash_generated_field = "3CCC257450CEEDF9DF4A1B3B44C1CD16")

    int mThemeRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.448 -0400", hash_original_field = "DAA48533FE83262630AE429727835DDE", hash_generated_field = "892636E3A464AFFB770DCFC2EBD216F3")

    int mItemLayoutRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.448 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.448 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "85BD8C2F470603886C61D670BD662E5D")

    MenuAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.448 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.449 -0400", hash_original_method = "4092EC8E340C70347418ABF573D4B0FE", hash_generated_method = "4EB17F570DE2A6DED90E8360925DEEC8")
    public  ListMenuPresenter(Context context, int itemLayoutRes) {
        this(itemLayoutRes, 0);
        addTaint(itemLayoutRes);
        addTaint(context.getTaint());
mContext=contextmInflater=LayoutInflater.from(mContext)
        // ---------- Original Method ----------
        //mContext = context;
        //mInflater = LayoutInflater.from(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.449 -0400", hash_original_method = "1CC41FC150F37B76A5F679E2DF486BF3", hash_generated_method = "165BAFD3609E7C0B3401A03EC5B5A7E9")
    public  ListMenuPresenter(int itemLayoutRes, int themeRes) {
        addTaint(themeRes);
        addTaint(itemLayoutRes);
mItemLayoutRes=itemLayoutResmThemeRes=themeRes
        // ---------- Original Method ----------
        //mItemLayoutRes = itemLayoutRes;
        //mThemeRes = themeRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.450 -0400", hash_original_method = "41B8179DE0AE53E84551731A0EA1D070", hash_generated_method = "30F052AE3F570D5DD4B22FE19F8F6194")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        addTaint(menu.getTaint());
        addTaint(context.getTaint());
        if(mThemeRes!=0)        
        {
mContext=new ContextThemeWrapper(context, mThemeRes)mInflater=LayoutInflater.from(mContext)
        } //End block
        else
        if(mContext!=null)        
        {
mContext=context            if(mInflater==null)            
            {
mInflater=LayoutInflater.from(mContext)
            } //End block
        } //End block
mMenu=menu
        // ---------- Original Method ----------
        //if (mThemeRes != 0) {
            //mContext = new ContextThemeWrapper(context, mThemeRes);
            //mInflater = LayoutInflater.from(mContext);
        //} else if (mContext != null) {
            //mContext = context;
            //if (mInflater == null) {
                //mInflater = LayoutInflater.from(mContext);
            //}
        //}
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.451 -0400", hash_original_method = "3C96043E10907F3E55134DF1DC938116", hash_generated_method = "5890E41711DB2962B8B91221DE75DC58")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        addTaint(root.getTaint());
        if(mMenuView==null)        
        {
mMenuView=(ExpandedMenuView) mInflater.inflate(com.android.internal.R.layout.expanded_menu_layout, root, false)            if(mAdapter==null)            
            {
mAdapter=new MenuAdapter()
            } //End block
mMenuView.setAdapter(mAdapter)mMenuView.setOnItemClickListener(this)
        } //End block
MenuView var7E140BC01DB9AC7A99D01C4BFF6F142B_897961162 = mMenuView        var7E140BC01DB9AC7A99D01C4BFF6F142B_897961162.addTaint(taint);
        return var7E140BC01DB9AC7A99D01C4BFF6F142B_897961162;
        // ---------- Original Method ----------
        //if (mMenuView == null) {
            //mMenuView = (ExpandedMenuView) mInflater.inflate(
                    //com.android.internal.R.layout.expanded_menu_layout, root, false);
            //if (mAdapter == null) {
                //mAdapter = new MenuAdapter();
            //}
            //mMenuView.setAdapter(mAdapter);
            //mMenuView.setOnItemClickListener(this);
        //}
        //return mMenuView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.451 -0400", hash_original_method = "0BC897630B7168BFB6657AF356C42C40", hash_generated_method = "732188AB538E570617E8B5128CCA010A")
    public ListAdapter getAdapter() {
        if(mAdapter==null)        
        {
mAdapter=new MenuAdapter()
        } //End block
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_1980823951 = mAdapter        varD72668EDE5E63ADF9340F3D8A19FD205_1980823951.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1980823951;
        // ---------- Original Method ----------
        //if (mAdapter == null) {
            //mAdapter = new MenuAdapter();
        //}
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.452 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "E7E39DD334DC061E014574AEB021C099")
    @Override
    public void updateMenuView(boolean cleared) {
        addTaint(cleared);
        if(mAdapter!=null)        
mAdapter.notifyDataSetChanged()
        // ---------- Original Method ----------
        //if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.452 -0400", hash_original_method = "80E7AE02A73BB486D54AC38F406B92BB", hash_generated_method = "298AF8648541151EAB643428BBCFDDFC")
    @Override
    public void setCallback(Callback cb) {
        addTaint(cb.getTaint());
mCallback=cb
        // ---------- Original Method ----------
        //mCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.453 -0400", hash_original_method = "A83D74A7B8E34BCB39AA6BC5FD37D18B", hash_generated_method = "586E35BD00B10AF12C96E64AF6A592C1")
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        if(!subMenu.hasVisibleItems())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1830190099 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967774132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967774132;
        }
new MenuDialogHelper(subMenu).show(null)        if(mCallback!=null)        
        {
mCallback.onOpenSubMenu(subMenu)
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1754790080 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666902775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666902775;
        // ---------- Original Method ----------
        //if (!subMenu.hasVisibleItems()) return false;
        //new MenuDialogHelper(subMenu).show(null);
        //if (mCallback != null) {
            //mCallback.onOpenSubMenu(subMenu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.453 -0400", hash_original_method = "722067599CD4502E441718E90CBC0EB7", hash_generated_method = "592A2F0F1EBB60EE3C8B5D773BF8E9FA")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
        if(mCallback!=null)        
        {
mCallback.onCloseMenu(menu, allMenusAreClosing)
        } //End block
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //mCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.454 -0400", hash_original_method = "475203F60353F2870A802829EBCF2C85", hash_generated_method = "6FA80B8C15201DCCB405B30B96446050")
     int getItemIndexOffset() {
        int var473475179E5B8394888872F8261BCF2E_1776008056 = (mItemIndexOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868673589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868673589;
        // ---------- Original Method ----------
        //return mItemIndexOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.454 -0400", hash_original_method = "F1BE2800305805802DC3B629A73BA0A1", hash_generated_method = "11F189CE3C847D06C5EE76B40A2186DA")
    public void setItemIndexOffset(int offset) {
        addTaint(offset);
mItemIndexOffset=offset        if(mMenuView!=null)        
        {
updateMenuView(false)
        } //End block
        // ---------- Original Method ----------
        //mItemIndexOffset = offset;
        //if (mMenuView != null) {
            //updateMenuView(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.455 -0400", hash_original_method = "152ABD8D418D655B6A8705FC87F24FDD", hash_generated_method = "592612DBE304D77171715C5C5FD05B83")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
mMenu.performItemAction(mAdapter.getItem(position), 0)
        // ---------- Original Method ----------
        //mMenu.performItemAction(mAdapter.getItem(position), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.455 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "2A7D9F6AF498AAD3543C5E7FA4806D60")
    @Override
    public boolean flagActionItems() {
        boolean var68934A3E9455FA72420237EB05902327_1932642814 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410588057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_410588057;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.455 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "7E6CA341C0FCF7A4C370AB4AB803BB3A")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_825023479 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_430236260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_430236260;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.456 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "10F3516D2A59D4BF741B006ACDF133AF")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_331509706 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383916812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383916812;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.456 -0400", hash_original_method = "0B368829F15D6906C64A9F7093B6493E", hash_generated_method = "70CD77063EB4F782F37C96C160F09D82")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.456 -0400", hash_original_method = "E2F747E0F2ADA663434186ED511D575C", hash_generated_method = "8755D0EA48C1C38238A671FE9D224399")
    public void restoreHierarchyState(Bundle inState) {
        addTaint(inState.getTaint());
        SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        if(viewStates!=null)        
        {
((View) mMenuView).restoreHierarchyState(viewStates)
        } //End block
        // ---------- Original Method ----------
        //SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray(VIEWS_TAG);
        //if (viewStates != null) {
            //((View) mMenuView).restoreHierarchyState(viewStates);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.457 -0400", hash_original_method = "97D2A517E68B7CE37726268CF0899D78", hash_generated_method = "B658149A6C248506759EEB8390269A5A")
    public void setId(int id) {
        addTaint(id);
mId=id
        // ---------- Original Method ----------
        //mId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.457 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "9240E2467D79967D6FBD4C9DD656F8ED")
    @Override
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_2093032866 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425172390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425172390;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.457 -0400", hash_original_method = "C6EC2F945334B683C122C10C6725C92E", hash_generated_method = "5823EC800D52C56D28CAA87F093ECA3B")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mMenuView==null)        
        {
Parcelable var540C13E9E156B687226421B24F2DF178_1055699042 = null            var540C13E9E156B687226421B24F2DF178_1055699042.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1055699042;
        } //End block
        Bundle state = new Bundle();
saveHierarchyState(state)Parcelable var37C56C9D63C623261861C16DCFB73F6D_853782678 = state        var37C56C9D63C623261861C16DCFB73F6D_853782678.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_853782678;
        // ---------- Original Method ----------
        //if (mMenuView == null) {
            //return null;
        //}
        //Bundle state = new Bundle();
        //saveHierarchyState(state);
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.458 -0400", hash_original_method = "4E57F37A0749F365E081EFA3C3A26D3A", hash_generated_method = "8BA6CBBA300C6A2B379FB4E4D28075D1")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
restoreHierarchyState((Bundle) state)
        // ---------- Original Method ----------
        //restoreHierarchyState((Bundle) state);
    }

    
    private class MenuAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.458 -0400", hash_original_field = "A7164A6DD256737B4893392B74FEF490", hash_generated_field = "368B0C631D5267EB3E3C8F80E65C4B4E")

        private int mExpandedIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.458 -0400", hash_original_method = "ABCEFA626F143922FD6B0198F9257B42", hash_generated_method = "863803EFE1295AAC097A5302C7F7E2FE")
        public  MenuAdapter() {
registerDataSetObserver(new ExpandedIndexObserver())findExpandedIndex()
            // ---------- Original Method ----------
            //registerDataSetObserver(new ExpandedIndexObserver());
            //findExpandedIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.459 -0400", hash_original_method = "B075C2C9F817A6815A344733B4AD8984", hash_generated_method = "D2491E2DE7D59041DA202DC7FA931493")
        public int getCount() {
            ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            int count = items.size() - mItemIndexOffset;
            if(mExpandedIndex<0)            
            {
                int varE2942A04780E223B215EB8B663CF5353_1787351931 = (count);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227217224 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227217224;
            } //End block
            int var818BECE218CFB073254CBDCBA750E382_2049921104 = (count-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372872812 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372872812;
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            //int count = items.size() - mItemIndexOffset;
            //if (mExpandedIndex < 0) {
                //return count;
            //}
            //return count - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.459 -0400", hash_original_method = "73E2A4B1E49DC28C05ECD9BBA4CB2D70", hash_generated_method = "BA203C1014A34E880A46BFA3C51769AA")
        public MenuItemImpl getItem(int position) {
            addTaint(position);
            ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
position+=mItemIndexOffset            if(mExpandedIndex>=0&&position>=mExpandedIndex)            
            {
position
            } //End block
MenuItemImpl var45A5A1B112F38793ADCDCC674FFCFA90_299899266 = items.get(position)            var45A5A1B112F38793ADCDCC674FFCFA90_299899266.addTaint(taint);
            return var45A5A1B112F38793ADCDCC674FFCFA90_299899266;
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
            //position += mItemIndexOffset;
            //if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                //position++;
            //}
            //return items.get(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.460 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "29D53D014113E870BE9EB5E74E61CDBB")
        public long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_648785308 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1985105799 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1985105799;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.461 -0400", hash_original_method = "C1F4941101A1C702C14329F2D59B1A57", hash_generated_method = "E8F7887CC1ED1B447557DE0F4A0B97E7")
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            if(convertView==null)            
            {
convertView=mInflater.inflate(mItemLayoutRes, parent, false)
            } //End block
            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
itemView.initialize(getItem(position), 0)View var78FE9B874BBEC69B62B43EE963245978_1420724049 = convertView            var78FE9B874BBEC69B62B43EE963245978_1420724049.addTaint(taint);
            return var78FE9B874BBEC69B62B43EE963245978_1420724049;
            // ---------- Original Method ----------
            //if (convertView == null) {
                //convertView = mInflater.inflate(mItemLayoutRes, parent, false);
            //}
            //MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            //itemView.initialize(getItem(position), 0);
            //return convertView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.461 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "BEF840CD8FF9254DC8F6DE4A25E6F6FB")
         void findExpandedIndex() {
            final MenuItemImpl expandedItem = mMenu.getExpandedItem();
            if(expandedItem!=null)            
            {
                final ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
                final int count = items.size();
for(int i = 0;i<count;i)
                {
                    final MenuItemImpl item = items.get(i);
                    if(item==expandedItem)                    
                    {
mExpandedIndex=i                        return;
                    } //End block
                } //End block
            } //End block
mExpandedIndex=-1
            // ---------- Original Method ----------
            //final MenuItemImpl expandedItem = mMenu.getExpandedItem();
            //if (expandedItem != null) {
                //final ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
                //final int count = items.size();
                //for (int i = 0; i < count; i++) {
                    //final MenuItemImpl item = items.get(i);
                    //if (item == expandedItem) {
                        //mExpandedIndex = i;
                        //return;
                    //}
                //}
            //}
            //mExpandedIndex = -1;
        }

        
    }


    
    private class ExpandedIndexObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.462 -0400", hash_original_method = "DA0B5F8D0AA73F545611139AD30FA95D", hash_generated_method = "DA0B5F8D0AA73F545611139AD30FA95D")
        public ExpandedIndexObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.462 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "FEF18D552FEE1470C976E4FADBE963F1")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
mAdapter.findExpandedIndex()
            // ---------- Original Method ----------
            //mAdapter.findExpandedIndex();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.462 -0400", hash_original_field = "9A95D1AA2099F93E2F2671DDF5D2C171", hash_generated_field = "717D86C38917E4DCC5244607A47388C8")

    private static final String TAG = "ListMenuPresenter";

