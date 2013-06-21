package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Context mContext;
    private LayoutInflater mInflater;
    private ListPopupWindow mPopup;
    private MenuBuilder mMenu;
    private int mPopupMaxWidth;
    private View mAnchorView;
    private boolean mOverflowOnly;
    private ViewTreeObserver mTreeObserver;
    private MenuAdapter mAdapter;
    private Callback mPresenterCallback;
    boolean mForceShowIcon;
    private ViewGroup mMeasureParent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.763 -0400", hash_original_method = "C3DA46F0C09C9CD41823ACFF5374F9FC", hash_generated_method = "4AFE660779623A64FBE1439D511417CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.763 -0400", hash_original_method = "8F0CC2E15AEA57BCE457471285201A3F", hash_generated_method = "FD7805B38F3D37AB8A15EBC2F8487C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
        dsTaint.addTaint(anchorView.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.763 -0400", hash_original_method = "DE5696D44D81E870285CDC89381852D9", hash_generated_method = "D979569D18FD9428C8443A9859360E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuPopupHelper(Context context, MenuBuilder menu,
            View anchorView, boolean overflowOnly) {
        dsTaint.addTaint(anchorView.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(overflowOnly);
        mInflater = LayoutInflater.from(context);
        Resources res;
        res = context.getResources();
        mPopupMaxWidth = Math.max(res.getDisplayMetrics().widthPixels / 2,
                res.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        menu.addMenuPresenter(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mInflater = LayoutInflater.from(context);
        //mMenu = menu;
        //mOverflowOnly = overflowOnly;
        //final Resources res = context.getResources();
        //mPopupMaxWidth = Math.max(res.getDisplayMetrics().widthPixels / 2,
                //res.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        //mAnchorView = anchorView;
        //menu.addMenuPresenter(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.764 -0400", hash_original_method = "2004F2F21A84D03A526AC70184547D5A", hash_generated_method = "2EE1136F00327BFC029BA7AB3330243B")
    @DSModeled(DSC.SAFE)
    public void setAnchorView(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        // ---------- Original Method ----------
        //mAnchorView = anchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.764 -0400", hash_original_method = "DBE6A6207EE05003848472E8CEC3C651", hash_generated_method = "CD2B4E48D7F70BFC9E879033DA5160F0")
    @DSModeled(DSC.SAFE)
    public void setForceShowIcon(boolean forceShow) {
        dsTaint.addTaint(forceShow);
        // ---------- Original Method ----------
        //mForceShowIcon = forceShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.764 -0400", hash_original_method = "8955EF8FDCAE4E81ACF8C17A7D97E901", hash_generated_method = "5498C9B5B2D9AA079D8A261DB4B89D99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            boolean var66A25B8C94477A21E76AC807AC3D0EEF_965729525 = (!tryShow());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!tryShow()) {
            //throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.765 -0400", hash_original_method = "C1B8B868BBC5EDAD3C0317341FA2A494", hash_generated_method = "DC4A3EA43949C789470992618FB90F01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryShow() {
        mPopup = new ListPopupWindow(mContext, null, com.android.internal.R.attr.popupMenuStyle);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);
        View anchor;
        anchor = mAnchorView;
        {
            boolean addGlobalListener;
            addGlobalListener = mTreeObserver == null;
            mTreeObserver = anchor.getViewTreeObserver();
            mTreeObserver.addOnGlobalLayoutListener(this);
            anchor.addOnAttachStateChangeListener(this);
            mPopup.setAnchorView(anchor);
        } //End block
        mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
        mPopup.show();
        mPopup.getListView().setOnKeyListener(this);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.765 -0400", hash_original_method = "E9FEE97D49E51EA661DEC346433EEFC8", hash_generated_method = "D8E333DE360EC365F206122C21DD7503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismiss() {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1686851875 = (isShowing());
            {
                mPopup.dismiss();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShowing()) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.770 -0400", hash_original_method = "7397A4058C634C2C06C80EFBB0CF76A6", hash_generated_method = "DF071962D7C4DD4E2A6FB9BE9DC7B97E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDismiss() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPopup = null;
        mMenu.close();
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_16701712 = (!mTreeObserver.isAlive());
                mTreeObserver = mAnchorView.getViewTreeObserver();
            } //End collapsed parenthetic
            mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        } //End block
        mAnchorView.removeOnAttachStateChangeListener(this);
        // ---------- Original Method ----------
        //mPopup = null;
        //mMenu.close();
        //if (mTreeObserver != null) {
            //if (!mTreeObserver.isAlive()) mTreeObserver = mAnchorView.getViewTreeObserver();
            //mTreeObserver.removeGlobalOnLayoutListener(this);
            //mTreeObserver = null;
        //}
        //mAnchorView.removeOnAttachStateChangeListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.770 -0400", hash_original_method = "063A1DE93E3AAE9F6194B4EEC84DC023", hash_generated_method = "998FEEB9F7C3F7D2B0071CD125792E6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShowing() {
        boolean var406C1C230C41C83FD431B50CF286B0C4_2104165814 = (mPopup != null && mPopup.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup != null && mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.770 -0400", hash_original_method = "CC543C30CFA85AC204B1A7C4ADC5298F", hash_generated_method = "425B3FFB540F5B8BE3F7D8159EE74767")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        MenuAdapter adapter;
        adapter = mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
        // ---------- Original Method ----------
        //MenuAdapter adapter = mAdapter;
        //adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.771 -0400", hash_original_method = "5530A17DF0C464E4D3DE3D685535DA7D", hash_generated_method = "D04D66104CF9DF5311637417D2F9FFAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var0760CB052AD389AD2AA0628DE5DBFBCD_1062180463 = (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU);
            {
                dismiss();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU) {
            //dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.771 -0400", hash_original_method = "E67C1B003E378A3103858A8D234C2EBA", hash_generated_method = "FF46334CC8389795D3BCDF37DF1F1ECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int measureContentWidth(ListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        int width;
        width = 0;
        View itemView;
        itemView = null;
        int itemType;
        itemType = 0;
        int widthMeasureSpec;
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int count;
        count = adapter.getCount();
        {
            int i;
            i = 0;
            {
                int positionType;
                positionType = adapter.getItemViewType(i);
                {
                    itemType = positionType;
                    itemView = null;
                } //End block
                {
                    mMeasureParent = new FrameLayout(mContext);
                } //End block
                itemView = adapter.getView(i, itemView, mMeasureParent);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                width = Math.max(width, itemView.getMeasuredWidth());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.771 -0400", hash_original_method = "C6EC024B4EC2712488353CA11D4CBD8A", hash_generated_method = "247846C467CB0FA8DFAFA0CCB8845B30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onGlobalLayout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1910600726 = (isShowing());
            {
                View anchor;
                anchor = mAnchorView;
                {
                    boolean var5B0207CEC87DA9AFBDB06670D9DEF01D_297402837 = (anchor == null || !anchor.isShown());
                    {
                        dismiss();
                    } //End block
                    {
                        boolean varB9D013B33293D3B01C6FE320FA1E1E67_879356166 = (isShowing());
                        {
                            mPopup.show();
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShowing()) {
            //final View anchor = mAnchorView;
            //if (anchor == null || !anchor.isShown()) {
                //dismiss();
            //} else if (isShowing()) {
                //mPopup.show();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.771 -0400", hash_original_method = "F8871633F0D16FC506B109A82F589F71", hash_generated_method = "9896E660E81B24C9596041F27123C0CC")
    @DSModeled(DSC.SAFE)
    @Override
    public void onViewAttachedToWindow(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.772 -0400", hash_original_method = "7EBF0DC32FD04FEC4EE8E1A868297E4F", hash_generated_method = "946E730FBFEE4C0ECCC7000DFA187930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onViewDetachedFromWindow(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_78673199 = (!mTreeObserver.isAlive());
                mTreeObserver = v.getViewTreeObserver();
            } //End collapsed parenthetic
            mTreeObserver.removeGlobalOnLayoutListener(this);
        } //End block
        v.removeOnAttachStateChangeListener(this);
        // ---------- Original Method ----------
        //if (mTreeObserver != null) {
            //if (!mTreeObserver.isAlive()) mTreeObserver = v.getViewTreeObserver();
            //mTreeObserver.removeGlobalOnLayoutListener(this);
        //}
        //v.removeOnAttachStateChangeListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.772 -0400", hash_original_method = "596FF06362BA36AEC7FC1AB43ADB5BB8", hash_generated_method = "DC657B61132254081E39B5C1867644D1")
    @DSModeled(DSC.SAFE)
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.772 -0400", hash_original_method = "763B49CF567916F2535D5913B399980B", hash_generated_method = "581D6DF23E3FB89AB704682FEC17AC26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MenuView getMenuView(ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
        return (MenuView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.772 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "F401BF3685134B8E1EF7A58577C962C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMenuView(boolean cleared) {
        dsTaint.addTaint(cleared);
        mAdapter.notifyDataSetChanged();
        // ---------- Original Method ----------
        //if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.773 -0400", hash_original_method = "10FF3E14371A7D0CA3058A6B9B33844C", hash_generated_method = "75E6A3729DFFEDCA29657EB64430EF9E")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCallback(Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        // ---------- Original Method ----------
        //mPresenterCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.773 -0400", hash_original_method = "248A3012A015004678EE499361542EC2", hash_generated_method = "642BF6FB58157362639362CC0F96B991")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(subMenu.dsTaint);
        {
            boolean varE454A931263098A462ADD15A6E18C84D_97125918 = (subMenu.hasVisibleItems());
            {
                MenuPopupHelper subPopup;
                subPopup = new MenuPopupHelper(mContext, subMenu, mAnchorView, false);
                subPopup.setCallback(mPresenterCallback);
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
                            boolean var11255FC25E31B9FD4DF8CC3E52970C12_684345453 = (childItem.isVisible() && childItem.getIcon() != null);
                            {
                                preserveIconSpacing = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                subPopup.setForceShowIcon(preserveIconSpacing);
                {
                    boolean varC3DA1F29D27EF7E1357093EA0530B6B6_781895324 = (subPopup.tryShow());
                    {
                        {
                            mPresenterCallback.onOpenSubMenu(subMenu);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.773 -0400", hash_original_method = "1BC820400AE9FB8BFD96C3A130B646DF", hash_generated_method = "92F490B50D0D0C7C2BF3FDDB48DF6B33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(allMenusAreClosing);
        dsTaint.addTaint(menu.dsTaint);
        dismiss();
        {
            mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        } //End block
        // ---------- Original Method ----------
        //if (menu != mMenu) return;
        //dismiss();
        //if (mPresenterCallback != null) {
            //mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.774 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "79FEBE5A4043A1C3A406325B2845DE51")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean flagActionItems() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.774 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "06D6DEB17F54430F48CC6A143A52D4D4")
    @DSModeled(DSC.SAFE)
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.774 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "AAEF088C5F287CE2BA804A19EDA68A41")
    @DSModeled(DSC.SAFE)
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.774 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "3889794031673B0451AEA296765BE9FA")
    @DSModeled(DSC.SAFE)
    @Override
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.774 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "88713AF66C650CC6D8A2367423FD0BF6")
    @DSModeled(DSC.SAFE)
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.775 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "7C0BA3522FD7C368AFE8827BBF47AB17")
    @DSModeled(DSC.SAFE)
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        // ---------- Original Method ----------
    }

    
    private class MenuAdapter extends BaseAdapter {
        private MenuBuilder mAdapterMenu;
        private int mExpandedIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.775 -0400", hash_original_method = "EDA6CC9674181A05B80522E55458D685", hash_generated_method = "5928D1EF821ABE05156C0065E6FEAFCD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MenuAdapter(MenuBuilder menu) {
            dsTaint.addTaint(menu.dsTaint);
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
            // ---------- Original Method ----------
            //mAdapterMenu = menu;
            //registerDataSetObserver(new ExpandedIndexObserver());
            //findExpandedIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.775 -0400", hash_original_method = "A184D01EFF77484135B24A56DB5CEE5C", hash_generated_method = "455CDC9881965E59D3727BFAFCC7650C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getCount() {
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            {
                int varE00BAF8570A06A861BDF45AD47729C60_726010035 = (items.size());
            } //End block
            int var3364632669B4E36C7733C64F7E025DA0_713472608 = (items.size() - 1);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    //mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            //if (mExpandedIndex < 0) {
                //return items.size();
            //}
            //return items.size() - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.776 -0400", hash_original_method = "007AF294AD9B69A523B4CB65CF7063F8", hash_generated_method = "F8B62AB06C99B3A04BF63177D9CC90AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MenuItemImpl getItem(int position) {
            dsTaint.addTaint(position);
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            MenuItemImpl var5375D5A49F7AF99246F3D61CAD53E2B4_2017597086 = (items.get(position));
            return (MenuItemImpl)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    //mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            //if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                //position++;
            //}
            //return items.get(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.776 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "AA5DF335B2BC02EEAA6ECE822AE11A88")
        @DSModeled(DSC.SAFE)
        public long getItemId(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.776 -0400", hash_original_method = "D8FCA6D369D77459F33FFA03EFE73A9B", hash_generated_method = "AB3096A6519909D3FEB1C8AB703CB122")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View getView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            {
                convertView = mInflater.inflate(ITEM_LAYOUT, parent, false);
            } //End block
            MenuView.ItemView itemView;
            itemView = (MenuView.ItemView) convertView;
            {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            } //End block
            itemView.initialize(getItem(position), 0);
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (convertView == null) {
                //convertView = mInflater.inflate(ITEM_LAYOUT, parent, false);
            //}
            //MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            //if (mForceShowIcon) {
                //((ListMenuItemView) convertView).setForceShowIcon(true);
            //}
            //itemView.initialize(getItem(position), 0);
            //return convertView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.776 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "4A5E232B967ADE81FEFA9891813C024D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void findExpandedIndex() {
            MenuItemImpl expandedItem;
            expandedItem = mMenu.getExpandedItem();
            {
                ArrayList<MenuItemImpl> items;
                items = mMenu.getNonActionItems();
                int count;
                count = items.size();
                {
                    int i;
                    i = 0;
                    {
                        MenuItemImpl item;
                        item = items.get(i);
                        {
                            mExpandedIndex = i;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mExpandedIndex = -1;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.777 -0400", hash_original_method = "15BEFF3FCEEBB68C3EC98C4A0980D3F1", hash_generated_method = "15BEFF3FCEEBB68C3EC98C4A0980D3F1")
                public ExpandedIndexObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.777 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "51B792B1C3D711BA95FF92B803E8A157")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mAdapter.findExpandedIndex();
            // ---------- Original Method ----------
            //mAdapter.findExpandedIndex();
        }

        
    }


    
    private static final String TAG = "MenuPopupHelper";
    static final int ITEM_LAYOUT = com.android.internal.R.layout.popup_menu_item_layout;
}

