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
    private static String TAG = "MenuPopupHelper";
    static int ITEM_LAYOUT = com.android.internal.R.layout.popup_menu_item_layout;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.777 -0400", hash_original_method = "C3DA46F0C09C9CD41823ACFF5374F9FC", hash_generated_method = "CAFD06AFBA9324A9FE7E6BA431D793B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.785 -0400", hash_original_method = "8F0CC2E15AEA57BCE457471285201A3F", hash_generated_method = "68988484C702C111CE230040B5E70025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
        dsTaint.addTaint(anchorView.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.811 -0400", hash_original_method = "DE5696D44D81E870285CDC89381852D9", hash_generated_method = "87849089B9A57889F5DD19D8D9FD579D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.838 -0400", hash_original_method = "2004F2F21A84D03A526AC70184547D5A", hash_generated_method = "B1B3FA762CA75E40F30F546578A3517C")
    @DSModeled(DSC.SAFE)
    public void setAnchorView(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        // ---------- Original Method ----------
        //mAnchorView = anchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.843 -0400", hash_original_method = "DBE6A6207EE05003848472E8CEC3C651", hash_generated_method = "A88058EADDFE21E4499354B7A99EC388")
    @DSModeled(DSC.SAFE)
    public void setForceShowIcon(boolean forceShow) {
        dsTaint.addTaint(forceShow);
        // ---------- Original Method ----------
        //mForceShowIcon = forceShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.864 -0400", hash_original_method = "8955EF8FDCAE4E81ACF8C17A7D97E901", hash_generated_method = "424C63667EFC1E7F32C9D35D91C94A28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            boolean var66A25B8C94477A21E76AC807AC3D0EEF_142140289 = (!tryShow());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!tryShow()) {
            //throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.031 -0400", hash_original_method = "C1B8B868BBC5EDAD3C0317341FA2A494", hash_generated_method = "CD681C5A170784EC93E5FC4B92737B6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.045 -0400", hash_original_method = "E9FEE97D49E51EA661DEC346433EEFC8", hash_generated_method = "8255E2AFD99749FD16F5C868DE8EE5E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismiss() {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_725776633 = (isShowing());
            {
                mPopup.dismiss();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShowing()) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.069 -0400", hash_original_method = "7397A4058C634C2C06C80EFBB0CF76A6", hash_generated_method = "AFBE82ABCC87B186164FC15DB7CC672E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDismiss() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPopup = null;
        mMenu.close();
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_1953527334 = (!mTreeObserver.isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.090 -0400", hash_original_method = "063A1DE93E3AAE9F6194B4EEC84DC023", hash_generated_method = "9260F145E88847EC45EDAFA208707EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShowing() {
        boolean var406C1C230C41C83FD431B50CF286B0C4_897991244 = (mPopup != null && mPopup.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup != null && mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.114 -0400", hash_original_method = "CC543C30CFA85AC204B1A7C4ADC5298F", hash_generated_method = "4B91D67BE73F7BCE1CFE5038934FCBE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(position);
        dsTaint.addTaint(id);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        MenuAdapter adapter;
        adapter = mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
        // ---------- Original Method ----------
        //MenuAdapter adapter = mAdapter;
        //adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.133 -0400", hash_original_method = "5530A17DF0C464E4D3DE3D685535DA7D", hash_generated_method = "E4109C9361866F7432BFC420DD69ADC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var0760CB052AD389AD2AA0628DE5DBFBCD_950636913 = (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.165 -0400", hash_original_method = "E67C1B003E378A3103858A8D234C2EBA", hash_generated_method = "AB84301FE4EAFD1D6813A5A2A6D6A40A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.197 -0400", hash_original_method = "C6EC024B4EC2712488353CA11D4CBD8A", hash_generated_method = "A677090681AE3C41D8EB5CC03A211422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onGlobalLayout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_33172752 = (isShowing());
            {
                View anchor;
                anchor = mAnchorView;
                {
                    boolean var5B0207CEC87DA9AFBDB06670D9DEF01D_707370213 = (anchor == null || !anchor.isShown());
                    {
                        dismiss();
                    } //End block
                    {
                        boolean varB9D013B33293D3B01C6FE320FA1E1E67_2024463697 = (isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.237 -0400", hash_original_method = "F8871633F0D16FC506B109A82F589F71", hash_generated_method = "03DA0B3C0FF0FDC44219C35762D10118")
    @DSModeled(DSC.SAFE)
    @Override
    public void onViewAttachedToWindow(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.253 -0400", hash_original_method = "7EBF0DC32FD04FEC4EE8E1A868297E4F", hash_generated_method = "628EB2FB815EA027BF583B23F7864776")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onViewDetachedFromWindow(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_208883407 = (!mTreeObserver.isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.274 -0400", hash_original_method = "596FF06362BA36AEC7FC1AB43ADB5BB8", hash_generated_method = "F480826EAFE1ED7D8A92B244AB6FD011")
    @DSModeled(DSC.SAFE)
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.282 -0400", hash_original_method = "763B49CF567916F2535D5913B399980B", hash_generated_method = "48D1BBB99CABD8966FD75FAD6D8F6D11")
    @DSModeled(DSC.SAFE)
    @Override
    public MenuView getMenuView(ViewGroup root) {
        dsTaint.addTaint(root.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
        return (MenuView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.303 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "9B230527B98F1031598F1C802083B492")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateMenuView(boolean cleared) {
        dsTaint.addTaint(cleared);
        mAdapter.notifyDataSetChanged();
        // ---------- Original Method ----------
        //if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.316 -0400", hash_original_method = "10FF3E14371A7D0CA3058A6B9B33844C", hash_generated_method = "9CDB0285CA2719E969588F3406B824A8")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCallback(Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        // ---------- Original Method ----------
        //mPresenterCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.387 -0400", hash_original_method = "248A3012A015004678EE499361542EC2", hash_generated_method = "C58FA5EF5D5BD54211311B640557225B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(subMenu.dsTaint);
        {
            boolean varE454A931263098A462ADD15A6E18C84D_1554921878 = (subMenu.hasVisibleItems());
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
                            boolean var11255FC25E31B9FD4DF8CC3E52970C12_101431963 = (childItem.isVisible() && childItem.getIcon() != null);
                            {
                                preserveIconSpacing = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                subPopup.setForceShowIcon(preserveIconSpacing);
                {
                    boolean varC3DA1F29D27EF7E1357093EA0530B6B6_504048143 = (subPopup.tryShow());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.442 -0400", hash_original_method = "1BC820400AE9FB8BFD96C3A130B646DF", hash_generated_method = "EB1FB95DAFEAA75608183CADC63E63A3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.461 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "761071654EC1C62DB275D4D4771F344C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean flagActionItems() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.468 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "FBED4046DDB1D1C623755A28F09DF91E")
    @DSModeled(DSC.SAFE)
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.488 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "1066E74078A7BFCD7BA3892D5FBEDBA0")
    @DSModeled(DSC.SAFE)
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.499 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "68706D134060346AA722E022B5A59EB2")
    @DSModeled(DSC.SAFE)
    @Override
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.504 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "AA51845457A002146B2A835A71E90C33")
    @DSModeled(DSC.SAFE)
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.523 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "5D07BACF361215F340B62618883EE831")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.527 -0400", hash_original_method = "EDA6CC9674181A05B80522E55458D685", hash_generated_method = "89BC390881A209A612ECC518787515B9")
        @DSModeled(DSC.SAFE)
        public MenuAdapter(MenuBuilder menu) {
            dsTaint.addTaint(menu.dsTaint);
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
            // ---------- Original Method ----------
            //mAdapterMenu = menu;
            //registerDataSetObserver(new ExpandedIndexObserver());
            //findExpandedIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.573 -0400", hash_original_method = "A184D01EFF77484135B24A56DB5CEE5C", hash_generated_method = "3CF267EE2CC1E25AA1649EB05B9CE189")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getCount() {
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            {
                int varE00BAF8570A06A861BDF45AD47729C60_2141444991 = (items.size());
            } //End block
            int var3364632669B4E36C7733C64F7E025DA0_2136018710 = (items.size() - 1);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    //mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            //if (mExpandedIndex < 0) {
                //return items.size();
            //}
            //return items.size() - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.600 -0400", hash_original_method = "007AF294AD9B69A523B4CB65CF7063F8", hash_generated_method = "EE6655DCFDAC810CF9EA00F655E1110D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MenuItemImpl getItem(int position) {
            dsTaint.addTaint(position);
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            {
                position++;
            } //End block
            MenuItemImpl var5375D5A49F7AF99246F3D61CAD53E2B4_1022113148 = (items.get(position));
            return (MenuItemImpl)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    //mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            //if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                //position++;
            //}
            //return items.get(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.616 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "E1F85E478999F8205E674BD281EA9CFE")
        @DSModeled(DSC.SAFE)
        public long getItemId(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.651 -0400", hash_original_method = "D8FCA6D369D77459F33FFA03EFE73A9B", hash_generated_method = "76DD00E9D7FD61FBA1FED6ADDE681BD8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.689 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "50AB4AB9FBE6C7AA3A0831D3531AD347")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:51.706 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "5E498E8E6180B88D45BCA64CCB32056B")
        @DSModeled(DSC.SAFE)
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mAdapter.findExpandedIndex();
            // ---------- Original Method ----------
            //mAdapter.findExpandedIndex();
        }

        
    }


    
}


