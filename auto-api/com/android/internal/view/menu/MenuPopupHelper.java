package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import java.util.ArrayList;

public class MenuPopupHelper implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, View.OnAttachStateChangeListener, MenuPresenter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "3177B39F7D83A11176DBA029A0EA4BCE", hash_generated_field = "F982842F2F505023DF351AAF684D021D")

    private int mPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "1111294825848EEA1A0BB76F85231708", hash_generated_field = "1F46EB1972E66D7ECC71598AAEEB2646")

    private View mAnchorView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "404B6414C399F211A9BD8E2CB863EB9B", hash_generated_field = "69DC0C00C8279C1071B6F44DC82CC746")

    private boolean mOverflowOnly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "F282E398CDA5B9A83923A8B4334A7A51", hash_generated_field = "4344B66A35B67D43C67B896B6E6F574E")

    private ViewTreeObserver mTreeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "70EF1FC230E0951E3D83E696BE279410")

    private MenuAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "64B773BD800647AE257B13A75F1C94CE", hash_generated_field = "1CD6F63E5806E04B51B62E75FCD724F8")

    private Callback mPresenterCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "EB2F9A6DA3D97AE9E64619D6EA497A82", hash_generated_field = "346196818A9B2A3ADB36739C20BD24C8")

    boolean mForceShowIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_field = "0B22C4EC51102FB72DC8629EBC5DC563", hash_generated_field = "E84D2043C556E9480A2C4C979E61DFD1")

    private ViewGroup mMeasureParent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.574 -0400", hash_original_method = "C3DA46F0C09C9CD41823ACFF5374F9FC", hash_generated_method = "A9FE1B050221EEC7B93E570F12FE57EF")
    public  MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
        addTaint(context.getTaint());
        addTaint(menu.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.575 -0400", hash_original_method = "8F0CC2E15AEA57BCE457471285201A3F", hash_generated_method = "0307CDC8F52A9D77ADF4560278E9FFCB")
    public  MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
        addTaint(context.getTaint());
        addTaint(menu.getTaint());
        addTaint(anchorView.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.575 -0400", hash_original_method = "DE5696D44D81E870285CDC89381852D9", hash_generated_method = "C2B28599F417ED9BC241C22F936C9583")
    public  MenuPopupHelper(Context context, MenuBuilder menu,
            View anchorView, boolean overflowOnly) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mMenu = menu;
        mOverflowOnly = overflowOnly;
        final Resources res = context.getResources();
        mPopupMaxWidth = Math.max(res.getDisplayMetrics().widthPixels / 2,
                res.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        mAnchorView = anchorView;
        menu.addMenuPresenter(this);
        
        
        
        
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.576 -0400", hash_original_method = "2004F2F21A84D03A526AC70184547D5A", hash_generated_method = "0710CCB8429C117DCC4BCE13AE2B0253")
    public void setAnchorView(View anchor) {
        mAnchorView = anchor;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.577 -0400", hash_original_method = "DBE6A6207EE05003848472E8CEC3C651", hash_generated_method = "C9635FB89EA1428BE4DC6AB8F19B0163")
    public void setForceShowIcon(boolean forceShow) {
        mForceShowIcon = forceShow;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.577 -0400", hash_original_method = "8955EF8FDCAE4E81ACF8C17A7D97E901", hash_generated_method = "60271AF227235B0F8DE1546ED04A6DFF")
    public void show() {
        {
            boolean var66A25B8C94477A21E76AC807AC3D0EEF_1226780328 = (!tryShow());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.578 -0400", hash_original_method = "C1B8B868BBC5EDAD3C0317341FA2A494", hash_generated_method = "DB428B1146313EC56E2B52EC24E72C7F")
    public boolean tryShow() {
        mPopup = new ListPopupWindow(mContext, null, com.android.internal.R.attr.popupMenuStyle);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);
        View anchor = mAnchorView;
        {
            final boolean addGlobalListener = mTreeObserver == null;
            mTreeObserver = anchor.getViewTreeObserver();
            mTreeObserver.addOnGlobalLayoutListener(this);
            anchor.addOnAttachStateChangeListener(this);
            mPopup.setAnchorView(anchor);
        } 
        mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
        mPopup.show();
        mPopup.getListView().setOnKeyListener(this);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1269173658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1269173658;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.579 -0400", hash_original_method = "E9FEE97D49E51EA661DEC346433EEFC8", hash_generated_method = "78F278840312B4CD7BEDB18D880DC3DD")
    public void dismiss() {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_291421658 = (isShowing());
            {
                mPopup.dismiss();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.580 -0400", hash_original_method = "7397A4058C634C2C06C80EFBB0CF76A6", hash_generated_method = "6F93D0975D918F37A8C2629646FAC083")
    public void onDismiss() {
        
        mPopup = null;
        mMenu.close();
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_158891628 = (!mTreeObserver.isAlive());
                mTreeObserver = mAnchorView.getViewTreeObserver();
            } 
            mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        } 
        mAnchorView.removeOnAttachStateChangeListener(this);
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.580 -0400", hash_original_method = "063A1DE93E3AAE9F6194B4EEC84DC023", hash_generated_method = "FD59C57C92EEA07205CD76051ABD8013")
    public boolean isShowing() {
        boolean var406C1C230C41C83FD431B50CF286B0C4_1772579822 = (mPopup != null && mPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229059662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229059662;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.581 -0400", hash_original_method = "CC543C30CFA85AC204B1A7C4ADC5298F", hash_generated_method = "9524776B7EF4A5AF78168B27F29C2BDE")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
        MenuAdapter adapter = mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.582 -0400", hash_original_method = "5530A17DF0C464E4D3DE3D685535DA7D", hash_generated_method = "9BF8F131C43D7C58DBE26B694C4A40EF")
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        
        {
            boolean var0760CB052AD389AD2AA0628DE5DBFBCD_2078552475 = (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU);
            {
                dismiss();
            } 
        } 
        addTaint(v.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1380097457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1380097457;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.582 -0400", hash_original_method = "E67C1B003E378A3103858A8D234C2EBA", hash_generated_method = "01217AA0FAE3A9DE4AEDC312291272EA")
    private int measureContentWidth(ListAdapter adapter) {
        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int count = adapter.getCount();
        {
            int i = 0;
            {
                final int positionType = adapter.getItemViewType(i);
                {
                    itemType = positionType;
                    itemView = null;
                } 
                {
                    mMeasureParent = new FrameLayout(mContext);
                } 
                itemView = adapter.getView(i, itemView, mMeasureParent);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                width = Math.max(width, itemView.getMeasuredWidth());
            } 
        } 
        addTaint(adapter.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081333632 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081333632;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.584 -0400", hash_original_method = "C6EC024B4EC2712488353CA11D4CBD8A", hash_generated_method = "8D10913A8C906B25EFEBEA997C54AEC7")
    @Override
    public void onGlobalLayout() {
        
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1991564901 = (isShowing());
            {
                final View anchor = mAnchorView;
                {
                    boolean var5B0207CEC87DA9AFBDB06670D9DEF01D_1510011961 = (anchor == null || !anchor.isShown());
                    {
                        dismiss();
                    } 
                    {
                        boolean varB9D013B33293D3B01C6FE320FA1E1E67_1549916859 = (isShowing());
                        {
                            mPopup.show();
                        } 
                    } 
                } 
            } 
        } 
        
        
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.585 -0400", hash_original_method = "F8871633F0D16FC506B109A82F589F71", hash_generated_method = "07DDEA36766AB113F870E845C6726299")
    @Override
    public void onViewAttachedToWindow(View v) {
        
        addTaint(v.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.585 -0400", hash_original_method = "7EBF0DC32FD04FEC4EE8E1A868297E4F", hash_generated_method = "A1C28207ACAEA7996F1BE0E37E51D5FB")
    @Override
    public void onViewDetachedFromWindow(View v) {
        
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_831200471 = (!mTreeObserver.isAlive());
                mTreeObserver = v.getViewTreeObserver();
            } 
            mTreeObserver.removeGlobalOnLayoutListener(this);
        } 
        v.removeOnAttachStateChangeListener(this);
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.586 -0400", hash_original_method = "596FF06362BA36AEC7FC1AB43ADB5BB8", hash_generated_method = "A9861F4973CC25C38BCCDC12EB68EA05")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        addTaint(context.getTaint());
        addTaint(menu.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.586 -0400", hash_original_method = "763B49CF567916F2535D5913B399980B", hash_generated_method = "C5721A9908C237CA78BF248DD1772C1C")
    @Override
    public MenuView getMenuView(ViewGroup root) {
    	throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.587 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "963CA071908CE2C83D0E88D7F1E8A516")
    @Override
    public void updateMenuView(boolean cleared) {
        mAdapter.notifyDataSetChanged();
        addTaint(cleared);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.587 -0400", hash_original_method = "10FF3E14371A7D0CA3058A6B9B33844C", hash_generated_method = "683D39E515D828F3DB31688688C9D775")
    @Override
    public void setCallback(Callback cb) {
        mPresenterCallback = cb;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.588 -0400", hash_original_method = "248A3012A015004678EE499361542EC2", hash_generated_method = "80A89179839A57398B979D96434B4C9E")
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        
        {
            boolean varE454A931263098A462ADD15A6E18C84D_220129026 = (subMenu.hasVisibleItems());
            {
                MenuPopupHelper subPopup = new MenuPopupHelper(mContext, subMenu, mAnchorView, false);
                subPopup.setCallback(mPresenterCallback);
                boolean preserveIconSpacing = false;
                final int count = subMenu.size();
                {
                    int i = 0;
                    {
                        MenuItem childItem = subMenu.getItem(i);
                        {
                            boolean var11255FC25E31B9FD4DF8CC3E52970C12_1400588203 = (childItem.isVisible() && childItem.getIcon() != null);
                            {
                                preserveIconSpacing = true;
                            } 
                        } 
                    } 
                } 
                subPopup.setForceShowIcon(preserveIconSpacing);
                {
                    boolean varC3DA1F29D27EF7E1357093EA0530B6B6_2041858690 = (subPopup.tryShow());
                    {
                        {
                            mPresenterCallback.onOpenSubMenu(subMenu);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(subMenu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461771518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461771518;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.588 -0400", hash_original_method = "1BC820400AE9FB8BFD96C3A130B646DF", hash_generated_method = "4D77E7D54D4AC6EE35F97AB75A15B2A0")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        
        dismiss();
        {
            mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        } 
        addTaint(menu.getTaint());
        addTaint(allMenusAreClosing);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.588 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "737F99E51FBC7EF50FFEDFA143D139CC")
    @Override
    public boolean flagActionItems() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1604225040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1604225040;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.588 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "7B6CE2CF564C94C9AD14F3B590D3B867")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264721774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264721774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.589 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "34BED683F624F97D3A94E0AE6B451D9D")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747671342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747671342;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.589 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "C9544994A750B48106BE915465B31875")
    @Override
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138029659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138029659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.589 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "8E607655F94B08FC5DFB6798B3DDEB13")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1928539166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1928539166 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1928539166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1928539166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.590 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "121C283A529B0D7F6A336D6D29A15283")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        addTaint(state.getTaint());
        
    }

    
    private class MenuAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.590 -0400", hash_original_field = "D7EB11368C1BAB933D31ADF3CCA750CD", hash_generated_field = "CDC3157ECB79F38E247155B4DAD83C83")

        private MenuBuilder mAdapterMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.590 -0400", hash_original_field = "A7164A6DD256737B4893392B74FEF490", hash_generated_field = "368B0C631D5267EB3E3C8F80E65C4B4E")

        private int mExpandedIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.590 -0400", hash_original_method = "EDA6CC9674181A05B80522E55458D685", hash_generated_method = "D6EC85FCC76EDFF5FC12571AE4A29E85")
        public  MenuAdapter(MenuBuilder menu) {
            mAdapterMenu = menu;
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.590 -0400", hash_original_method = "A184D01EFF77484135B24A56DB5CEE5C", hash_generated_method = "429814B5158728BEEF9F959F4F9A9581")
        public int getCount() {
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            {
                int varE00BAF8570A06A861BDF45AD47729C60_1595160254 = (items.size());
            } 
            int var3364632669B4E36C7733C64F7E025DA0_1438990878 = (items.size() - 1);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877132988 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877132988;
            
            
                    
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.591 -0400", hash_original_method = "007AF294AD9B69A523B4CB65CF7063F8", hash_generated_method = "49BAB627AB1A2F1E79983BE9A22680B7")
        public MenuItemImpl getItem(int position) {
            MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1984449278 = null; 
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            varB4EAC82CA7396A68D541C85D26508E83_1984449278 = items.get(position);
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_1984449278.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1984449278;
            
            
                    
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.591 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "B979C5EAFB71E368FFE0471BD4687E43")
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_951902276 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_951902276;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.592 -0400", hash_original_method = "D8FCA6D369D77459F33FFA03EFE73A9B", hash_generated_method = "2A789A19F2D0ECBF6C6ADB8713338C76")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_1496704141 = null; 
            {
                convertView = mInflater.inflate(ITEM_LAYOUT, parent, false);
            } 
            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            } 
            itemView.initialize(getItem(position), 0);
            varB4EAC82CA7396A68D541C85D26508E83_1496704141 = convertView;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1496704141.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1496704141;
            
            
                
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.593 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "D375F41C08C8FC232594E7040849E500")
         void findExpandedIndex() {
            final MenuItemImpl expandedItem = mMenu.getExpandedItem();
            {
                final ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
                final int count = items.size();
                {
                    int i = 0;
                    {
                        final MenuItemImpl item = items.get(i);
                        {
                            mExpandedIndex = i;
                        } 
                    } 
                } 
            } 
            mExpandedIndex = -1;
            
            
            
                
                
                
                    
                    
                        
                        
                    
                
            
            
        }

        
    }


    
    private class ExpandedIndexObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.593 -0400", hash_original_method = "DA0B5F8D0AA73F545611139AD30FA95D", hash_generated_method = "DA0B5F8D0AA73F545611139AD30FA95D")
        public ExpandedIndexObserver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.594 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "51B792B1C3D711BA95FF92B803E8A157")
        @Override
        public void onChanged() {
            
            mAdapter.findExpandedIndex();
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.594 -0400", hash_original_field = "2792A5823BDD2CB6BABA7B27508FA7B5", hash_generated_field = "6C9DFC256D4283331236FE5061F62A3A")

    private static final String TAG = "MenuPopupHelper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:34.594 -0400", hash_original_field = "6350B4ED61E41182CFAD26661264962A", hash_generated_field = "AAC4D87FB214431216863D160D58133B")

    static final int ITEM_LAYOUT = com.android.internal.R.layout.popup_menu_item_layout;
}

