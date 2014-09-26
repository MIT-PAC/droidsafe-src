package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.util.ArrayList;

import android.app.ContextImpl;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Parcel;
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
import android.widget.ListView;
import android.widget.PopupWindow;

public class MenuPopupHelper implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, View.OnAttachStateChangeListener, MenuPresenter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.014 -0500", hash_original_field = "894DDED20B32A4ACE82E85BB7611CAA8", hash_generated_field = "6C9DFC256D4283331236FE5061F62A3A")

    private static final String TAG = "MenuPopupHelper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.016 -0500", hash_original_field = "E6BF7F7BDDDE6F7E11E4A9B4E440F882", hash_generated_field = "AAC4D87FB214431216863D160D58133B")

    static final int ITEM_LAYOUT = com.android.internal.R.layout.popup_menu_item_layout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.018 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.021 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.024 -0500", hash_original_field = "4DA234AE6542EB8CE34753F7DEA560C5", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.026 -0500", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.028 -0500", hash_original_field = "D7ED6EC8EFB99F63D5936216760E0780", hash_generated_field = "F982842F2F505023DF351AAF684D021D")

    private int mPopupMaxWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.030 -0500", hash_original_field = "1DA73E9C4F5296C4FA8D284B890838EA", hash_generated_field = "1F46EB1972E66D7ECC71598AAEEB2646")

    private View mAnchorView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.032 -0500", hash_original_field = "A7C437F6117979F1931B38A5A96C2B4E", hash_generated_field = "69DC0C00C8279C1071B6F44DC82CC746")

    private boolean mOverflowOnly;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.034 -0500", hash_original_field = "EABCDDE624C741F6732BD5D9ACB9D471", hash_generated_field = "4344B66A35B67D43C67B896B6E6F574E")

    private ViewTreeObserver mTreeObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.036 -0500", hash_original_field = "85BD8C2F470603886C61D670BD662E5D", hash_generated_field = "70EF1FC230E0951E3D83E696BE279410")

    private MenuAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.039 -0500", hash_original_field = "8A90713BA1A114069E13ED2F7302D2FE", hash_generated_field = "1CD6F63E5806E04B51B62E75FCD724F8")

    private Callback mPresenterCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.041 -0500", hash_original_field = "346196818A9B2A3ADB36739C20BD24C8", hash_generated_field = "346196818A9B2A3ADB36739C20BD24C8")

    boolean mForceShowIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.043 -0500", hash_original_field = "0940732891F2298DD930EF9EFFE42842", hash_generated_field = "E84D2043C556E9480A2C4C979E61DFD1")

    private ViewGroup mMeasureParent;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.045 -0500", hash_original_method = "C3DA46F0C09C9CD41823ACFF5374F9FC", hash_generated_method = "92F53DD4AC527ABAF5A36D2FBCC555EA")
    
public MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.047 -0500", hash_original_method = "8F0CC2E15AEA57BCE457471285201A3F", hash_generated_method = "CF52787FD0D73B4BFAFDEA6B76766717")
    
public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.050 -0500", hash_original_method = "DE5696D44D81E870285CDC89381852D9", hash_generated_method = "07CB6C04BE3A9DD905057C9A357E0786")
    
public MenuPopupHelper(Context context, MenuBuilder menu,
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
        
        droidsafeCallbackHooks();
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeCallbackHooks() {
        this.onViewAttachedToWindow(mAnchorView);
        this.onGlobalLayout();
        this.onDismiss();
        Parcelable state = this.onSaveInstanceState();
        this.onRestoreInstanceState(state);
        
        ListView lv = new ListView(mContext);
        this.onItemClick(lv, mAnchorView, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        
        MenuItemImpl menuItemImpl = new MenuItemImpl(mMenu, DSUtils.FAKE_INT,
                DSUtils.FAKE_INT, DSUtils.FAKE_INT, mPopupMaxWidth, new String(), mPopupMaxWidth);
        SubMenuBuilder sb =  new SubMenuBuilder(mContext, mMenu, menuItemImpl);
        this.onSubMenuSelected(sb);

        this.onKey(mAnchorView, DSUtils.FAKE_INT, new KeyEvent());
        this.onCloseMenu(mMenu, DSUtils.UNKNOWN_BOOLEAN);
        this.onViewDetachedFromWindow(mAnchorView);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.052 -0500", hash_original_method = "2004F2F21A84D03A526AC70184547D5A", hash_generated_method = "C1D89E9158410DEE65B49C01493BFD1D")
    @DSSafe(DSCat.SAFE_OTHERS)
public void setAnchorView(View anchor) {
        mAnchorView = anchor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.055 -0500", hash_original_method = "DBE6A6207EE05003848472E8CEC3C651", hash_generated_method = "0FE25DF4DA9F68C2316C8563F150CE74")
    
public void setForceShowIcon(boolean forceShow) {
        mForceShowIcon = forceShow;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.057 -0500", hash_original_method = "8955EF8FDCAE4E81ACF8C17A7D97E901", hash_generated_method = "A2A82048B8BFEC883AC484F934AF2351")
    
public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.060 -0500", hash_original_method = "C1B8B868BBC5EDAD3C0317341FA2A494", hash_generated_method = "A6F9B9C0F7E9F191183F9A74DC02F697")
    
public boolean tryShow() {
        mPopup = new ListPopupWindow(mContext, null, com.android.internal.R.attr.popupMenuStyle);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);

        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);

        View anchor = mAnchorView;
        if (anchor != null) {
            final boolean addGlobalListener = mTreeObserver == null;
            mTreeObserver = anchor.getViewTreeObserver(); // Refresh to latest
            if (addGlobalListener) mTreeObserver.addOnGlobalLayoutListener(this);
            anchor.addOnAttachStateChangeListener(this);
            mPopup.setAnchorView(anchor);
        } else {
            return false;
        }

        mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
        mPopup.show();
        mPopup.getListView().setOnKeyListener(this);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.062 -0500", hash_original_method = "E9FEE97D49E51EA661DEC346433EEFC8", hash_generated_method = "133F656F32D87890156BDE5083D0E03C")
    
public void dismiss() {
        if (isShowing()) {
            mPopup.dismiss();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.064 -0500", hash_original_method = "7397A4058C634C2C06C80EFBB0CF76A6", hash_generated_method = "D46DCFDF7E7EC5C486A2C9AAE9EFE426")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void onDismiss() {
        mPopup = null;
        mMenu.close();
        if (mTreeObserver != null) {
            if (!mTreeObserver.isAlive()) mTreeObserver = mAnchorView.getViewTreeObserver();
            mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        }
        mAnchorView.removeOnAttachStateChangeListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.067 -0500", hash_original_method = "063A1DE93E3AAE9F6194B4EEC84DC023", hash_generated_method = "8FB150C0636C855FDE107610841320C1")
    
public boolean isShowing() {
        return mPopup != null && mPopup.isShowing();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.070 -0500", hash_original_method = "CC543C30CFA85AC204B1A7C4ADC5298F", hash_generated_method = "8064FA4EE09322C88B459DF4BD3026C7")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MenuAdapter adapter = mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.072 -0500", hash_original_method = "5530A17DF0C464E4D3DE3D685535DA7D", hash_generated_method = "E28A3720C7E66B24CAC4E2708B232FF4")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU) {
            dismiss();
            return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.074 -0500", hash_original_method = "E67C1B003E378A3103858A8D234C2EBA", hash_generated_method = "14C21BC89B209B5CE3F5599F8409CB03")
    
private int measureContentWidth(ListAdapter adapter) {
        // Menus don't tend to be long, so this is more sane than it looks.
        int width = 0;
        View itemView = null;
        int itemType = 0;
        final int widthMeasureSpec =
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec =
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            final int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            if (mMeasureParent == null) {
                mMeasureParent = new FrameLayout(mContext);
            }
            itemView = adapter.getView(i, itemView, mMeasureParent);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        return width;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.077 -0500", hash_original_method = "C6EC024B4EC2712488353CA11D4CBD8A", hash_generated_method = "2C8432F731C1ED6580A5EE1417F9855D")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void onGlobalLayout() {
        if (isShowing()) {
            final View anchor = mAnchorView;
            if (anchor == null || !anchor.isShown()) {
                dismiss();
            } else if (isShowing()) {
                // Recompute window size and position
                mPopup.show();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.079 -0500", hash_original_method = "F8871633F0D16FC506B109A82F589F71", hash_generated_method = "A20A8490C2BD8F2DD00AEC089B241615")
    
@Override
    public void onViewAttachedToWindow(View v) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.082 -0500", hash_original_method = "7EBF0DC32FD04FEC4EE8E1A868297E4F", hash_generated_method = "A8A12F960526FF19D364DE4D9694E656")
    
@Override
    public void onViewDetachedFromWindow(View v) {
        if (mTreeObserver != null) {
            if (!mTreeObserver.isAlive()) mTreeObserver = v.getViewTreeObserver();
            mTreeObserver.removeGlobalOnLayoutListener(this);
        }
        v.removeOnAttachStateChangeListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.084 -0500", hash_original_method = "596FF06362BA36AEC7FC1AB43ADB5BB8", hash_generated_method = "10513C7D7E2E54B30F884F764A40E757")
    
@Override
    public void initForMenu(Context context, MenuBuilder menu) {
        // Don't need to do anything; we added as a presenter in the constructor.
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.086 -0500", hash_original_method = "763B49CF567916F2535D5913B399980B", hash_generated_method = "112BC26BB8F44D11AC63C56F0B91CD14")
    
@Override
    public MenuView getMenuView(ViewGroup root) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.089 -0500", hash_original_method = "B269BCE0FCD16A3C9FF695C128351C90", hash_generated_method = "A036D0BC4ABD4D3959577205F0CFFCB5")
    
@Override
    public void updateMenuView(boolean cleared) {
        if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.091 -0500", hash_original_method = "10FF3E14371A7D0CA3058A6B9B33844C", hash_generated_method = "F6C496CC72FE6F7A403B63FD5A754BFF")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void setCallback(Callback cb) {
        mPresenterCallback = cb;
        cb.onCloseMenu(mMenu, DSUtils.UNKNOWN_BOOLEAN);
        
        MenuItemImpl menuItemImpl = new MenuItemImpl(mMenu, DSUtils.FAKE_INT,
                DSUtils.FAKE_INT, DSUtils.FAKE_INT, mPopupMaxWidth, new String(), mPopupMaxWidth);
        SubMenuBuilder sb =  new SubMenuBuilder(mContext, mMenu, menuItemImpl);
        this.onSubMenuSelected(sb);
        
        cb.onOpenSubMenu(sb);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.093 -0500", hash_original_method = "248A3012A015004678EE499361542EC2", hash_generated_method = "B9FA22C810531D832491734E6A46493F")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (subMenu.hasVisibleItems()) {
            MenuPopupHelper subPopup = new MenuPopupHelper(mContext, subMenu, mAnchorView, false);
            subPopup.setCallback(mPresenterCallback);

            boolean preserveIconSpacing = false;
            final int count = subMenu.size();
            for (int i = 0; i < count; i++) {
                MenuItem childItem = subMenu.getItem(i);
                if (childItem.isVisible() && childItem.getIcon() != null) {
                    preserveIconSpacing = true;
                    break;
                }
            }
            subPopup.setForceShowIcon(preserveIconSpacing);

            if (subPopup.tryShow()) {
                if (mPresenterCallback != null) {
                    mPresenterCallback.onOpenSubMenu(subMenu);
                }
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.096 -0500", hash_original_method = "1BC820400AE9FB8BFD96C3A130B646DF", hash_generated_method = "47C7BA0C7FCF250659D3D769A516E4B3")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        // Only care about the (sub)menu we're presenting.
        if (menu != mMenu) return;

        dismiss();
        if (mPresenterCallback != null) {
            mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.098 -0500", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "53EA63F11892B6B76B90A02A4F7BB199")
    
@Override
    public boolean flagActionItems() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.101 -0500", hash_original_method = "5F1249279FE45B816C21E97DA3013708", hash_generated_method = "1AC0563B74EC3CB7F8AA75918408F79E")
    
public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.104 -0500", hash_original_method = "06DF13061AFE044B0D38F9C19B18A57A", hash_generated_method = "7FACC901E2C2CF1ADC66B0D53290352D")
    
public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.106 -0500", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "C0CB620CEC980AD85BC1EE1B6EA7B000")
    
@Override
    public int getId() {
        return 0;
    }
    
    private class MenuAdapter extends BaseAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.113 -0500", hash_original_field = "F443E10B53219295A5CB14FC02A81BF7", hash_generated_field = "CDC3157ECB79F38E247155B4DAD83C83")

        private MenuBuilder mAdapterMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.115 -0500", hash_original_field = "7E186A2BE2043157042746F1BCB8A7FE", hash_generated_field = "368B0C631D5267EB3E3C8F80E65C4B4E")

        private int mExpandedIndex = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.118 -0500", hash_original_method = "EDA6CC9674181A05B80522E55458D685", hash_generated_method = "8826C17DACEC2E0A817787C4AFBE714B")
        
public MenuAdapter(MenuBuilder menu) {
            mAdapterMenu = menu;
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.121 -0500", hash_original_method = "A184D01EFF77484135B24A56DB5CEE5C", hash_generated_method = "B04709EFD607D951E88284934D0100B3")
        
public int getCount() {
            ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            if (mExpandedIndex < 0) {
                return items.size();
            }
            return items.size() - 1;
        }

        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.123 -0500", hash_original_method = "007AF294AD9B69A523B4CB65CF7063F8", hash_generated_method = "63D8E35105523D7DD84EA799E9DF2A2A")
        
public MenuItemImpl getItem(int position) {
            ArrayList<MenuItemImpl> items = mOverflowOnly ?
                    mAdapterMenu.getNonActionItems() : mAdapterMenu.getVisibleItems();
            if (mExpandedIndex >= 0 && position >= mExpandedIndex) {
                position++;
            }
            return items.get(position);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.125 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "8CA03C062FFB619062E87AB7922D9645")
        
public long getItemId(int position) {
            // Since a menu item's ID is optional, we'll use the position as an
            // ID for the item in the AdapterView
            return position;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.128 -0500", hash_original_method = "D8FCA6D369D77459F33FFA03EFE73A9B", hash_generated_method = "50CABC5E5552B27DA5DB2D56AF34E85D")
        
public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(ITEM_LAYOUT, parent, false);
            }

            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            if (mForceShowIcon) {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            }
            itemView.initialize(getItem(position), 0);
            return convertView;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.131 -0500", hash_original_method = "8514B841FB70F13278F6FFF144403E57", hash_generated_method = "8514B841FB70F13278F6FFF144403E57")
        
void findExpandedIndex() {
            final MenuItemImpl expandedItem = mMenu.getExpandedItem();
            if (expandedItem != null) {
                final ArrayList<MenuItemImpl> items = mMenu.getNonActionItems();
                final int count = items.size();
                for (int i = 0; i < count; i++) {
                    final MenuItemImpl item = items.get(i);
                    if (item == expandedItem) {
                        mExpandedIndex = i;
                        return;
                    }
                }
            }
            mExpandedIndex = -1;
        }
        
    }
    
    private class ExpandedIndexObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.580 -0400", hash_original_method = "DA0B5F8D0AA73F545611139AD30FA95D", hash_generated_method = "DA0B5F8D0AA73F545611139AD30FA95D")
        public ExpandedIndexObserver ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.137 -0500", hash_original_method = "1C37910D450C50461EF8022194A48276", hash_generated_method = "03DDDCD5D2F2E75C2A869506E1006BA0")
        
@Override
        public void onChanged() {
            mAdapter.findExpandedIndex();
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.108 -0500", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "D7C142582BEA8E084D7F8C19441F7839")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public Parcelable onSaveInstanceState() {
        return new Parcelable() {
            
            @Override
            @DSVerified
            @DSSpec(DSCat.SERIALIZATION)
            public void writeToParcel(Parcel dest, int flags) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            @DSVerified
            @DSSafe(DSCat.SAFE_OTHERS)
            public int describeContents() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:34.110 -0500", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "EA02457E24D7D58E860CD649C8CDC212")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void onRestoreInstanceState(Parcelable state) {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public ListPopupWindow getPopup() {
        // TODO Auto-generated method stub
        //return null;
        ListPopupWindow popup = new ListPopupWindow(new ContextImpl());
        return popup;
    }
}

