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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.702 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "3177B39F7D83A11176DBA029A0EA4BCE", hash_generated_field = "F982842F2F505023DF351AAF684D021D")

    private int mPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "1111294825848EEA1A0BB76F85231708", hash_generated_field = "1F46EB1972E66D7ECC71598AAEEB2646")

    private View mAnchorView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "404B6414C399F211A9BD8E2CB863EB9B", hash_generated_field = "69DC0C00C8279C1071B6F44DC82CC746")

    private boolean mOverflowOnly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "F282E398CDA5B9A83923A8B4334A7A51", hash_generated_field = "4344B66A35B67D43C67B896B6E6F574E")

    private ViewTreeObserver mTreeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "70EF1FC230E0951E3D83E696BE279410")

    private MenuAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "64B773BD800647AE257B13A75F1C94CE", hash_generated_field = "1CD6F63E5806E04B51B62E75FCD724F8")

    private Callback mPresenterCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "EB2F9A6DA3D97AE9E64619D6EA497A82", hash_generated_field = "346196818A9B2A3ADB36739C20BD24C8")

    boolean mForceShowIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.703 -0400", hash_original_field = "0B22C4EC51102FB72DC8629EBC5DC563", hash_generated_field = "E84D2043C556E9480A2C4C979E61DFD1")

    private ViewGroup mMeasureParent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.713 -0400", hash_original_method = "C3DA46F0C09C9CD41823ACFF5374F9FC", hash_generated_method = "A9FE1B050221EEC7B93E570F12FE57EF")
    public  MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
        addTaint(context.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.713 -0400", hash_original_method = "8F0CC2E15AEA57BCE457471285201A3F", hash_generated_method = "0307CDC8F52A9D77ADF4560278E9FFCB")
    public  MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
        addTaint(context.getTaint());
        addTaint(menu.getTaint());
        addTaint(anchorView.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.725 -0400", hash_original_method = "DE5696D44D81E870285CDC89381852D9", hash_generated_method = "D1836A426CA34C6741BEF9C8AF31B4A5")
    public  MenuPopupHelper(Context context, MenuBuilder menu,
            View anchorView, boolean overflowOnly) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mMenu = menu;
        mOverflowOnly = overflowOnly;
        Resources res;
        res = context.getResources();
        mPopupMaxWidth = Math.max(res.getDisplayMetrics().widthPixels / 2,
                res.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        mAnchorView = anchorView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.725 -0400", hash_original_method = "2004F2F21A84D03A526AC70184547D5A", hash_generated_method = "0710CCB8429C117DCC4BCE13AE2B0253")
    public void setAnchorView(View anchor) {
        mAnchorView = anchor;
        // ---------- Original Method ----------
        //mAnchorView = anchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.726 -0400", hash_original_method = "DBE6A6207EE05003848472E8CEC3C651", hash_generated_method = "C9635FB89EA1428BE4DC6AB8F19B0163")
    public void setForceShowIcon(boolean forceShow) {
        mForceShowIcon = forceShow;
        // ---------- Original Method ----------
        //mForceShowIcon = forceShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.726 -0400", hash_original_method = "8955EF8FDCAE4E81ACF8C17A7D97E901", hash_generated_method = "96D482924C9E438263C7978B9FA16F2C")
    public void show() {
        {
            boolean var66A25B8C94477A21E76AC807AC3D0EEF_410251545 = (!tryShow());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!tryShow()) {
            //throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.730 -0400", hash_original_method = "C1B8B868BBC5EDAD3C0317341FA2A494", hash_generated_method = "4395D43E5806B7B535F0905DE6CF349E")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578482225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578482225;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.735 -0400", hash_original_method = "E9FEE97D49E51EA661DEC346433EEFC8", hash_generated_method = "86AEFA324B1B505FCBFC3CB64FB8AE31")
    public void dismiss() {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1844278231 = (isShowing());
            {
                mPopup.dismiss();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShowing()) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.736 -0400", hash_original_method = "7397A4058C634C2C06C80EFBB0CF76A6", hash_generated_method = "D83CE36816DDFF0EC07D1051D0E8F298")
    public void onDismiss() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPopup = null;
        mMenu.close();
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_1720787043 = (!mTreeObserver.isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.736 -0400", hash_original_method = "063A1DE93E3AAE9F6194B4EEC84DC023", hash_generated_method = "B4212C54497E9563EF4188D9D1AFC644")
    public boolean isShowing() {
        boolean var406C1C230C41C83FD431B50CF286B0C4_1759299009 = (mPopup != null && mPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550015290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_550015290;
        // ---------- Original Method ----------
        //return mPopup != null && mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.737 -0400", hash_original_method = "CC543C30CFA85AC204B1A7C4ADC5298F", hash_generated_method = "27E96D09D1068035677CD63B38399F11")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        MenuAdapter adapter;
        adapter = mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
        //MenuAdapter adapter = mAdapter;
        //adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.737 -0400", hash_original_method = "5530A17DF0C464E4D3DE3D685535DA7D", hash_generated_method = "C1D93312F03FBD40AAA7BDF8AC275CB4")
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var0760CB052AD389AD2AA0628DE5DBFBCD_977809522 = (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU);
            {
                dismiss();
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386293580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_386293580;
        // ---------- Original Method ----------
        //if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU) {
            //dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.742 -0400", hash_original_method = "E67C1B003E378A3103858A8D234C2EBA", hash_generated_method = "8B395DF184953227313F8C062BD7DC5D")
    private int measureContentWidth(ListAdapter adapter) {
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
        addTaint(adapter.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349171309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349171309;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.743 -0400", hash_original_method = "C6EC024B4EC2712488353CA11D4CBD8A", hash_generated_method = "D88BACFBBBCEF6286CD2DA0ACD1F46E1")
    @Override
    public void onGlobalLayout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1989432588 = (isShowing());
            {
                View anchor;
                anchor = mAnchorView;
                {
                    boolean var5B0207CEC87DA9AFBDB06670D9DEF01D_1353241981 = (anchor == null || !anchor.isShown());
                    {
                        dismiss();
                    } //End block
                    {
                        boolean varB9D013B33293D3B01C6FE320FA1E1E67_1896251241 = (isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.758 -0400", hash_original_method = "F8871633F0D16FC506B109A82F589F71", hash_generated_method = "07DDEA36766AB113F870E845C6726299")
    @Override
    public void onViewAttachedToWindow(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.759 -0400", hash_original_method = "7EBF0DC32FD04FEC4EE8E1A868297E4F", hash_generated_method = "0F5A9FA60D5F6CD316528E1A42A99B21")
    @Override
    public void onViewDetachedFromWindow(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean varD9053E01204B262CB9EE82E363B1DD11_774782501 = (!mTreeObserver.isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.759 -0400", hash_original_method = "596FF06362BA36AEC7FC1AB43ADB5BB8", hash_generated_method = "A9861F4973CC25C38BCCDC12EB68EA05")
    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        addTaint(context.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.760 -0400", hash_original_method = "763B49CF567916F2535D5913B399980B", hash_generated_method = "C5721A9908C237CA78BF248DD1772C1C")
    @Override
    public MenuView getMenuView(ViewGroup root) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
        addTaint(root.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.768 -0400", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "963CA071908CE2C83D0E88D7F1E8A516")
    @Override
    public void updateMenuView(boolean cleared) {
        mAdapter.notifyDataSetChanged();
        addTaint(cleared);
        // ---------- Original Method ----------
        //if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.774 -0400", hash_original_method = "10FF3E14371A7D0CA3058A6B9B33844C", hash_generated_method = "683D39E515D828F3DB31688688C9D775")
    @Override
    public void setCallback(Callback cb) {
        mPresenterCallback = cb;
        // ---------- Original Method ----------
        //mPresenterCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.784 -0400", hash_original_method = "248A3012A015004678EE499361542EC2", hash_generated_method = "0DCB0D6F83EFF77B00ED49F223BBBFF9")
    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varE454A931263098A462ADD15A6E18C84D_1484241778 = (subMenu.hasVisibleItems());
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
                            boolean var11255FC25E31B9FD4DF8CC3E52970C12_1414338456 = (childItem.isVisible() && childItem.getIcon() != null);
                            {
                                preserveIconSpacing = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                subPopup.setForceShowIcon(preserveIconSpacing);
                {
                    boolean varC3DA1F29D27EF7E1357093EA0530B6B6_1941305101 = (subPopup.tryShow());
                    {
                        {
                            mPresenterCallback.onOpenSubMenu(subMenu);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(subMenu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303262090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_303262090;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.784 -0400", hash_original_method = "1BC820400AE9FB8BFD96C3A130B646DF", hash_generated_method = "4D77E7D54D4AC6EE35F97AB75A15B2A0")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dismiss();
        {
            mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        } //End block
        addTaint(menu.getTaint());
        addTaint(allMenusAreClosing);
        // ---------- Original Method ----------
        //if (menu != mMenu) return;
        //dismiss();
        //if (mPresenterCallback != null) {
            //mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.790 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "98C43F865C7BB48E32819AA614D1BE3E")
    @Override
    public boolean flagActionItems() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673205302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673205302;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.790 -0400", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "DDA579514AD9FE0D2DB0BC26F3A1D958")
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463166346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_463166346;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.790 -0400", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "E8A3BD88F1870285AC9324C4ED91FB05")
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        addTaint(menu.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919470053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_919470053;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.791 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "63D68E096D0628869ACC4F34E07F8BD8")
    @Override
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691461933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691461933;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.791 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "E53233EF564A6E6AC8EF511A449938C9")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_567152916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_567152916 = null;
        varB4EAC82CA7396A68D541C85D26508E83_567152916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_567152916;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.792 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "121C283A529B0D7F6A336D6D29A15283")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        // ---------- Original Method ----------
    }

    
    private class MenuAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.801 -0400", hash_original_field = "D7EB11368C1BAB933D31ADF3CCA750CD", hash_generated_field = "CDC3157ECB79F38E247155B4DAD83C83")

        private MenuBuilder mAdapterMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.801 -0400", hash_original_field = "A7164A6DD256737B4893392B74FEF490", hash_generated_field = "368B0C631D5267EB3E3C8F80E65C4B4E")

        private int mExpandedIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.802 -0400", hash_original_method = "EDA6CC9674181A05B80522E55458D685", hash_generated_method = "D6EC85FCC76EDFF5FC12571AE4A29E85")
        public  MenuAdapter(MenuBuilder menu) {
            mAdapterMenu = menu;
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
            // ---------- Original Method ----------
            //mAdapterMenu = menu;
            //registerDataSetObserver(new ExpandedIndexObserver());
            //findExpandedIndex();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.802 -0400", hash_original_method = "A184D01EFF77484135B24A56DB5CEE5C", hash_generated_method = "89644C4E19692F21EF7D4662686A42BA")
        public int getCount() {
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            {
                int varE00BAF8570A06A861BDF45AD47729C60_169916323 = (items.size());
            } //End block
            int var3364632669B4E36C7733C64F7E025DA0_1177868346 = (items.size() - 1);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890544657 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890544657;
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    //mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            //if (mExpandedIndex < 0) {
                //return items.size();
            //}
            //return items.size() - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.803 -0400", hash_original_method = "007AF294AD9B69A523B4CB65CF7063F8", hash_generated_method = "9A48B6A2C4EEE1DBEE17E91E85CD999B")
        public MenuItemImpl getItem(int position) {
            MenuItemImpl varB4EAC82CA7396A68D541C85D26508E83_1518886802 = null; //Variable for return #1
            ArrayList<MenuItemImpl> items;
            items = mAdapterMenu.getNonActionItems();
            items = mAdapterMenu.getVisibleItems();
            varB4EAC82CA7396A68D541C85D26508E83_1518886802 = items.get(position);
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_1518886802.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1518886802;
            // ---------- Original Method ----------
            //ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    //mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            //if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                //position++;
            //}
            //return items.get(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.803 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "A852E06E3ADC4218E7311BD51092845A")
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_931818235 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_931818235;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.819 -0400", hash_original_method = "D8FCA6D369D77459F33FFA03EFE73A9B", hash_generated_method = "BE2A31CD66ECAF1ED0A900412F9C40EC")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_216922788 = null; //Variable for return #1
            {
                convertView = mInflater.inflate(ITEM_LAYOUT, parent, false);
            } //End block
            MenuView.ItemView itemView;
            itemView = (MenuView.ItemView) convertView;
            {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            } //End block
            itemView.initialize(getItem(position), 0);
            varB4EAC82CA7396A68D541C85D26508E83_216922788 = convertView;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_216922788.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_216922788;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.820 -0400", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "4A5E232B967ADE81FEFA9891813C024D")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.820 -0400", hash_original_method = "DA0B5F8D0AA73F545611139AD30FA95D", hash_generated_method = "DA0B5F8D0AA73F545611139AD30FA95D")
        public ExpandedIndexObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.828 -0400", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "51B792B1C3D711BA95FF92B803E8A157")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mAdapter.findExpandedIndex();
            // ---------- Original Method ----------
            //mAdapter.findExpandedIndex();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.828 -0400", hash_original_field = "2792A5823BDD2CB6BABA7B27508FA7B5", hash_generated_field = "FA4DE8DE679D5159EEFFA64C4ACD6C5C")

    private static String TAG = "MenuPopupHelper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.828 -0400", hash_original_field = "6350B4ED61E41182CFAD26661264962A", hash_generated_field = "8E42A5732A269194CE59D66494E3584A")

    static int ITEM_LAYOUT = com.android.internal.R.layout.popup_menu_item_layout;
}

