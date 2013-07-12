package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "3177B39F7D83A11176DBA029A0EA4BCE", hash_generated_field = "F982842F2F505023DF351AAF684D021D")

    private int mPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "1111294825848EEA1A0BB76F85231708", hash_generated_field = "1F46EB1972E66D7ECC71598AAEEB2646")

    private View mAnchorView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "404B6414C399F211A9BD8E2CB863EB9B", hash_generated_field = "69DC0C00C8279C1071B6F44DC82CC746")

    private boolean mOverflowOnly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "F282E398CDA5B9A83923A8B4334A7A51", hash_generated_field = "4344B66A35B67D43C67B896B6E6F574E")

    private ViewTreeObserver mTreeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "70EF1FC230E0951E3D83E696BE279410")

    private MenuAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "64B773BD800647AE257B13A75F1C94CE", hash_generated_field = "1CD6F63E5806E04B51B62E75FCD724F8")

    private Callback mPresenterCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "EB2F9A6DA3D97AE9E64619D6EA497A82", hash_generated_field = "346196818A9B2A3ADB36739C20BD24C8")

    boolean mForceShowIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_field = "0B22C4EC51102FB72DC8629EBC5DC563", hash_generated_field = "E84D2043C556E9480A2C4C979E61DFD1")

    private ViewGroup mMeasureParent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.485 -0400", hash_original_method = "C3DA46F0C09C9CD41823ACFF5374F9FC", hash_generated_method = "7FC55E5630D4FAEABC941E223BF4349E")
    public  MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
        addTaint(menu.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.486 -0400", hash_original_method = "8F0CC2E15AEA57BCE457471285201A3F", hash_generated_method = "C1A5DF259C847A8BB85BC7D3BE956DC0")
    public  MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
        addTaint(anchorView.getTaint());
        addTaint(menu.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.488 -0400", hash_original_method = "DE5696D44D81E870285CDC89381852D9", hash_generated_method = "C2B28599F417ED9BC241C22F936C9583")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.488 -0400", hash_original_method = "2004F2F21A84D03A526AC70184547D5A", hash_generated_method = "0710CCB8429C117DCC4BCE13AE2B0253")
    public void setAnchorView(View anchor) {
        mAnchorView = anchor;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.489 -0400", hash_original_method = "DBE6A6207EE05003848472E8CEC3C651", hash_generated_method = "C9635FB89EA1428BE4DC6AB8F19B0163")
    public void setForceShowIcon(boolean forceShow) {
        mForceShowIcon = forceShow;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.489 -0400", hash_original_method = "8955EF8FDCAE4E81ACF8C17A7D97E901", hash_generated_method = "C7B0EFC2BF399F1CF74BBCE5C5BCC824")
    public void show() {
    if(!tryShow())        
        {
            IllegalStateException varF7A06F50D112064BC85F51A09E8D2BB0_1960750550 = new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            varF7A06F50D112064BC85F51A09E8D2BB0_1960750550.addTaint(taint);
            throw varF7A06F50D112064BC85F51A09E8D2BB0_1960750550;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.490 -0400", hash_original_method = "C1B8B868BBC5EDAD3C0317341FA2A494", hash_generated_method = "3AB6FC584499A07E8178AB59CACA7F92")
    public boolean tryShow() {
        mPopup = new ListPopupWindow(mContext, null, com.android.internal.R.attr.popupMenuStyle);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);
        View anchor = mAnchorView;
    if(anchor != null)        
        {
            final boolean addGlobalListener = mTreeObserver == null;
            mTreeObserver = anchor.getViewTreeObserver();
    if(addGlobalListener)            
            mTreeObserver.addOnGlobalLayoutListener(this);
            anchor.addOnAttachStateChangeListener(this);
            mPopup.setAnchorView(anchor);
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1715319755 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886588615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_886588615;
        } 
        mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
        mPopup.show();
        mPopup.getListView().setOnKeyListener(this);
        boolean varB326B5062B2F0E69046810717534CB09_833243184 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225537765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225537765;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.490 -0400", hash_original_method = "E9FEE97D49E51EA661DEC346433EEFC8", hash_generated_method = "E051AE0BBB0C7D0FB3438722E74A3416")
    public void dismiss() {
    if(isShowing())        
        {
            mPopup.dismiss();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.491 -0400", hash_original_method = "7397A4058C634C2C06C80EFBB0CF76A6", hash_generated_method = "79BE928332BBAE60AEFF982A969F8ED3")
    public void onDismiss() {
        
        mPopup = null;
        mMenu.close();
    if(mTreeObserver != null)        
        {
    if(!mTreeObserver.isAlive())            
            mTreeObserver = mAnchorView.getViewTreeObserver();
            mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        } 
        mAnchorView.removeOnAttachStateChangeListener(this);
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.491 -0400", hash_original_method = "063A1DE93E3AAE9F6194B4EEC84DC023", hash_generated_method = "783534559A0FE695D16BC16892B1901A")
    public boolean isShowing() {
        boolean varA3C6B8331EA46D668564ABB666AF5579_1974908228 = (mPopup != null && mPopup.isShowing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138929614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138929614;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.491 -0400", hash_original_method = "CC543C30CFA85AC204B1A7C4ADC5298F", hash_generated_method = "EA4E23FC605865C0ADC2FB5F6D9E4EF5")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
        MenuAdapter adapter = mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.492 -0400", hash_original_method = "5530A17DF0C464E4D3DE3D685535DA7D", hash_generated_method = "7C169517B3D705F403D6FD491CEA43B0")
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(v.getTaint());
    if(event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU)        
        {
            dismiss();
            boolean varB326B5062B2F0E69046810717534CB09_919680661 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1248142221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1248142221;
        } 
        boolean var68934A3E9455FA72420237EB05902327_528578567 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781938746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781938746;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.492 -0400", hash_original_method = "E67C1B003E378A3103858A8D234C2EBA", hash_generated_method = "3D4B823FD84E6B39E631D43E67F533F7")
    private int measureContentWidth(ListAdapter adapter) {
        addTaint(adapter.getTaint());
        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int count = adapter.getCount();
for(int i = 0;i < count;i++)
        {
            final int positionType = adapter.getItemViewType(i);
    if(positionType != itemType)            
            {
                itemType = positionType;
                itemView = null;
            } 
    if(mMeasureParent == null)            
            {
                mMeasureParent = new FrameLayout(mContext);
            } 
            itemView = adapter.getView(i, itemView, mMeasureParent);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        } 
        int varEAAE26A6FB20ED3EF54FB23BFA0B1FCC_1545361673 = (width);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999227963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999227963;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.505 -0400", hash_original_method = "C6EC024B4EC2712488353CA11D4CBD8A", hash_generated_method = "BFF73939EF2AC9F8B9B61C2BE3B80933")
    @Override
    public void onGlobalLayout() {
        
    if(isShowing())        
        {
            final View anchor = mAnchorView;
    if(anchor == null || !anchor.isShown())            
            {
                dismiss();
            } 
            else
    if(isShowing())            
            {
                mPopup.show();
            } 
        } 
        
        
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.506 -0400", hash_original_method = "F8871633F0D16FC506B109A82F589F71", hash_generated_method = "07DDEA36766AB113F870E845C6726299")
    @Override
    public void onViewAttachedToWindow(View v) {
        
        addTaint(v.getTaint());
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.506 -0400", hash_original_method = "7EBF0DC32FD04FEC4EE8E1A868297E4F", hash_generated_method = "F7D9519C6ED4823649FD414DC1A22CEF")
    @Override
    public void onViewDetachedFromWindow(View v) {
        
    if(mTreeObserver != null)        
        {
    if(!mTreeObserver.isAlive())            
            mTreeObserver = v.getViewTreeObserver();
            mTreeObserver.removeGlobalOnLayoutListener(this);
        } 
        v.removeOnAttachStateChangeListener(this);
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.506 -0400", hash_original_method = "596FF06362BA36AEC7FC1AB43ADB5BB8", hash_generated_method = "5935D2339CB8A414622C76842E4D52B8")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        addTaint(menu.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.506 -0400", hash_original_method = "763B49CF567916F2535D5913B399980B", hash_generated_method = "C53D79A372DF3D3524506B95D1740D76")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        addTaint(root.getTaint());
        UnsupportedOperationException var54394A8AB0FFC853E336C95A6243AB15_475043190 = new UnsupportedOperationException("MenuPopupHelpers manage their own views");
        var54394A8AB0FFC853E336C95A6243AB15_475043190.addTaint(taint);
        throw var54394A8AB0FFC853E336C95A6243AB15_475043190;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.506 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "9F02CC5F4FB30F9A637250FB9C78B73C")
    @Override
    public void updateMenuView(boolean cleared) {
        addTaint(cleared);
    if(mAdapter != null)        
        mAdapter.notifyDataSetChanged();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.506 -0400", hash_original_method = "10FF3E14371A7D0CA3058A6B9B33844C", hash_generated_method = "683D39E515D828F3DB31688688C9D775")
    @Override
    public void setCallback(Callback cb) {
        mPresenterCallback = cb;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "248A3012A015004678EE499361542EC2", hash_generated_method = "AB2948F148DE8A7BEA133A31F3E2940F")
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        
        addTaint(subMenu.getTaint());
    if(subMenu.hasVisibleItems())        
        {
            MenuPopupHelper subPopup = new MenuPopupHelper(mContext, subMenu, mAnchorView, false);
            subPopup.setCallback(mPresenterCallback);
            boolean preserveIconSpacing = false;
            final int count = subMenu.size();
for(int i = 0;i < count;i++)
            {
                MenuItem childItem = subMenu.getItem(i);
    if(childItem.isVisible() && childItem.getIcon() != null)                
                {
                    preserveIconSpacing = true;
                    break;
                } 
            } 
            subPopup.setForceShowIcon(preserveIconSpacing);
    if(subPopup.tryShow())            
            {
    if(mPresenterCallback != null)                
                {
                    mPresenterCallback.onOpenSubMenu(subMenu);
                } 
                boolean varB326B5062B2F0E69046810717534CB09_1566277927 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383438283 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_383438283;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_514450467 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244227755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244227755;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "1BC820400AE9FB8BFD96C3A130B646DF", hash_generated_method = "B4B69FA923CB82F6F68E865F8540E40C")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
    if(menu != mMenu)        
        return;
        dismiss();
    if(mPresenterCallback != null)        
        {
            mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "6E9C4C4E5D2E8526663FBEC92AA31DC5")
    @Override
    public boolean flagActionItems() {
        boolean var68934A3E9455FA72420237EB05902327_1562055599 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691208017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691208017;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "1F8071E6B45E6D518177C03E3C1A291A")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_648339039 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287327500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287327500;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "9655E0F4525153171D166413481D37F8")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1343153695 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607364391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607364391;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "FB027C1DA38C65A326B9D3A4C89E052E")
    @Override
    public int getId() {
        int varCFCD208495D565EF66E7DFF9F98764DA_650460948 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312465659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312465659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "B508E285DA520A584F9B9E6B26C42C64")
    @Override
    public Parcelable onSaveInstanceState() {
        
Parcelable var540C13E9E156B687226421B24F2DF178_661258684 =         null;
        var540C13E9E156B687226421B24F2DF178_661258684.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_661258684;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "121C283A529B0D7F6A336D6D29A15283")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        addTaint(state.getTaint());
        
    }

    
    private class MenuAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_field = "D7EB11368C1BAB933D31ADF3CCA750CD", hash_generated_field = "CDC3157ECB79F38E247155B4DAD83C83")

        private MenuBuilder mAdapterMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.507 -0400", hash_original_field = "A7164A6DD256737B4893392B74FEF490", hash_generated_field = "368B0C631D5267EB3E3C8F80E65C4B4E")

        private int mExpandedIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.508 -0400", hash_original_method = "EDA6CC9674181A05B80522E55458D685", hash_generated_method = "D6EC85FCC76EDFF5FC12571AE4A29E85")
        public  MenuAdapter(MenuBuilder menu) {
            mAdapterMenu = menu;
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.508 -0400", hash_original_method = "A184D01EFF77484135B24A56DB5CEE5C", hash_generated_method = "5F22A87167646097FD0719FFDA93C540")
        public int getCount() {
            ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
    if(mExpandedIndex < 0)            
            {
                int varE8E55A9D9925C7FF8B7D83A9E24296C4_2014398483 = (items.size());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490047874 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490047874;
            } 
            int var7F7D3A494EF50B0A4DA30B0FC972EC13_125756854 = (items.size() - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728870080 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728870080;
            
            
                    
            
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.508 -0400", hash_original_method = "007AF294AD9B69A523B4CB65CF7063F8", hash_generated_method = "3F4F93ECFD9BBD9185460329D74FA57C")
        public MenuItemImpl getItem(int position) {
            addTaint(position);
            ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
    if(mExpandedIndex >= 0 && position >= mExpandedIndex)            
            {
                position++;
            } 
MenuItemImpl var45A5A1B112F38793ADCDCC674FFCFA90_725979761 =             items.get(position);
            var45A5A1B112F38793ADCDCC674FFCFA90_725979761.addTaint(taint);
            return var45A5A1B112F38793ADCDCC674FFCFA90_725979761;
            
            
                    
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.508 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "F78620F0146D7F453F72ED7C9A3177B3")
        public long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_1499623311 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1504639506 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1504639506;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.508 -0400", hash_original_method = "D8FCA6D369D77459F33FFA03EFE73A9B", hash_generated_method = "54D384D5B404B09A355EE0E534EB25E4")
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
    if(convertView == null)            
            {
                convertView = mInflater.inflate(ITEM_LAYOUT, parent, false);
            } 
            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
    if(mForceShowIcon)            
            {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            } 
            itemView.initialize(getItem(position), 0);
View var78FE9B874BBEC69B62B43EE963245978_1761818811 =             convertView;
            var78FE9B874BBEC69B62B43EE963245978_1761818811.addTaint(taint);
            return var78FE9B874BBEC69B62B43EE963245978_1761818811;
            
            
                
            
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.508 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "5B50CAB8DBCE6471DDF22B00405DDD7F")
         void findExpandedIndex() {
            final MenuItemImpl expandedItem = mMenu.getExpandedItem();
    if(expandedItem != null)            
            {
                final ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
                final int count = items.size();
for(int i = 0;i < count;i++)
                {
                    final MenuItemImpl item = items.get(i);
    if(item == expandedItem)                    
                    {
                        mExpandedIndex = i;
                        return;
                    } 
                } 
            } 
            mExpandedIndex = -1;
            
            
            
                
                
                
                    
                    
                        
                        
                    
                
            
            
        }

        
    }


    
    private class ExpandedIndexObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.509 -0400", hash_original_method = "DA0B5F8D0AA73F545611139AD30FA95D", hash_generated_method = "DA0B5F8D0AA73F545611139AD30FA95D")
        public ExpandedIndexObserver ()
        {
            
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.509 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "51B792B1C3D711BA95FF92B803E8A157")
        @Override
        public void onChanged() {
            
            mAdapter.findExpandedIndex();
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.509 -0400", hash_original_field = "2792A5823BDD2CB6BABA7B27508FA7B5", hash_generated_field = "6C9DFC256D4283331236FE5061F62A3A")

    private static final String TAG = "MenuPopupHelper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.509 -0400", hash_original_field = "6350B4ED61E41182CFAD26661264962A", hash_generated_field = "AAC4D87FB214431216863D160D58133B")

    static final int ITEM_LAYOUT = com.android.internal.R.layout.popup_menu_item_layout;
}

