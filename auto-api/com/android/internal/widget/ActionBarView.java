package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.R;
import com.android.internal.view.menu.ActionMenuItem;
import com.android.internal.view.menu.ActionMenuPresenter;
import com.android.internal.view.menu.ActionMenuView;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuItemImpl;
import com.android.internal.view.menu.MenuPresenter;
import com.android.internal.view.menu.MenuView;
import com.android.internal.view.menu.SubMenuBuilder;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ActionBarView extends AbsActionBarView {
    private static final String TAG = "ActionBarView";
    public static final int DISPLAY_DEFAULT = 0;
    private static final int DISPLAY_RELAYOUT_MASK =
            ActionBar.DISPLAY_SHOW_HOME |
            ActionBar.DISPLAY_USE_LOGO |
            ActionBar.DISPLAY_HOME_AS_UP |
            ActionBar.DISPLAY_SHOW_CUSTOM |
            ActionBar.DISPLAY_SHOW_TITLE;
    private static final int DEFAULT_CUSTOM_GRAVITY = Gravity.LEFT | Gravity.CENTER_VERTICAL;
    private int mNavigationMode;
    private int mDisplayOptions = -1;
    private CharSequence mTitle;
    private CharSequence mSubtitle;
    private Drawable mIcon;
    private Drawable mLogo;
    private HomeView mHomeLayout;
    private HomeView mExpandedHomeLayout;
    private LinearLayout mTitleLayout;
    private TextView mTitleView;
    private TextView mSubtitleView;
    private View mTitleUpView;
    private Spinner mSpinner;
    private LinearLayout mListNavLayout;
    private ScrollingTabContainerView mTabScrollView;
    private View mCustomNavView;
    private ProgressBar mProgressView;
    private ProgressBar mIndeterminateProgressView;
    private int mProgressBarPadding;
    private int mItemPadding;
    private int mTitleStyleRes;
    private int mSubtitleStyleRes;
    private int mProgressStyle;
    private int mIndeterminateProgressStyle;
    private boolean mUserTitle;
    private boolean mIncludeTabs;
    private boolean mIsCollapsable;
    private boolean mIsCollapsed;
    private MenuBuilder mOptionsMenu;
    private ActionBarContextView mContextView;
    private ActionMenuItem mLogoNavItem;
    private SpinnerAdapter mSpinnerAdapter;
    private OnNavigationListener mCallback;
    private Runnable mTabSelector;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    View mExpandedActionView;
    Window.Callback mWindowCallback;
    private final AdapterView.OnItemSelectedListener mNavItemSelectedListener = new AdapterView.OnItemSelectedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.269 -0400", hash_original_method = "1DD2DCAB9C51672A3484006095504705", hash_generated_method = "179961910C87406DE5248B3EEE77B8D7")
        @DSModeled(DSC.SAFE)
        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(position);
            dsTaint.addTaint(id);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            {
                mCallback.onNavigationItemSelected(position, id);
            } //End block
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //mCallback.onNavigationItemSelected(position, id);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.269 -0400", hash_original_method = "B71B11696BC75696BC2C4386B1729546", hash_generated_method = "D2DC5BA00E631069A95A045B3AD62D36")
        @DSModeled(DSC.SAFE)
        public void onNothingSelected(AdapterView parent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(parent.dsTaint);
            // ---------- Original Method ----------
        }

        
}; //Transformed anonymous class
    private final OnClickListener mExpandedActionViewUpListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.269 -0400", hash_original_method = "71D7F82DC843779588A8591EEB5DDE73", hash_generated_method = "79870951AC98B41BE7C89653AB77F446")
        @DSModeled(DSC.SAFE)
        @Override
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            final MenuItemImpl item;
            item = mExpandedMenuPresenter.mCurrentExpandedItem;
            {
                item.collapseActionView();
            } //End block
            // ---------- Original Method ----------
            //final MenuItemImpl item = mExpandedMenuPresenter.mCurrentExpandedItem;
            //if (item != null) {
                //item.collapseActionView();
            //}
        }

        
}; //Transformed anonymous class
    private final OnClickListener mUpClickListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.269 -0400", hash_original_method = "19F57545305850BD0BBBD46104CC0B01", hash_generated_method = "29648FD718A6AE08AD8A2F5702BC5C2A")
        @DSModeled(DSC.SAFE)
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            mWindowCallback.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, mLogoNavItem);
            // ---------- Original Method ----------
            //mWindowCallback.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, mLogoNavItem);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.269 -0400", hash_original_method = "29E0288B7F0720C76BE42483EEC0C7FB", hash_generated_method = "66250B72DB47E7BED12361003E2BC392")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        setBackgroundResource(0);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        ApplicationInfo appInfo;
        appInfo = context.getApplicationInfo();
        PackageManager pm;
        pm = context.getPackageManager();
        mNavigationMode = a.getInt(R.styleable.ActionBar_navigationMode,
                ActionBar.NAVIGATION_MODE_STANDARD);
        mTitle = a.getText(R.styleable.ActionBar_title);
        mSubtitle = a.getText(R.styleable.ActionBar_subtitle);
        mLogo = a.getDrawable(R.styleable.ActionBar_logo);
        {
            {
                try 
                {
                    mLogo = pm.getActivityLogo(((Activity) context).getComponentName());
                } //End block
                catch (NameNotFoundException e)
                { }
            } //End block
            {
                mLogo = appInfo.loadLogo(pm);
            } //End block
        } //End block
        mIcon = a.getDrawable(R.styleable.ActionBar_icon);
        {
            {
                try 
                {
                    mIcon = pm.getActivityIcon(((Activity) context).getComponentName());
                } //End block
                catch (NameNotFoundException e)
                { }
            } //End block
            {
                mIcon = appInfo.loadIcon(pm);
            } //End block
        } //End block
        final LayoutInflater inflater;
        inflater = LayoutInflater.from(context);
        final int homeResId;
        homeResId = a.getResourceId(
                com.android.internal.R.styleable.ActionBar_homeLayout,
                com.android.internal.R.layout.action_bar_home);
        mHomeLayout = (HomeView) inflater.inflate(homeResId, this, false);
        mExpandedHomeLayout = (HomeView) inflater.inflate(homeResId, this, false);
        mExpandedHomeLayout.setUp(true);
        mExpandedHomeLayout.setOnClickListener(mExpandedActionViewUpListener);
        mExpandedHomeLayout.setContentDescription(getResources().getText(
                R.string.action_bar_up_description));
        mTitleStyleRes = a.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
        mSubtitleStyleRes = a.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
        mProgressStyle = a.getResourceId(R.styleable.ActionBar_progressBarStyle, 0);
        mIndeterminateProgressStyle = a.getResourceId(
                R.styleable.ActionBar_indeterminateProgressStyle, 0);
        mProgressBarPadding = a.getDimensionPixelOffset(R.styleable.ActionBar_progressBarPadding, 0);
        mItemPadding = a.getDimensionPixelOffset(R.styleable.ActionBar_itemPadding, 0);
        setDisplayOptions(a.getInt(R.styleable.ActionBar_displayOptions, DISPLAY_DEFAULT));
        final int customNavId;
        customNavId = a.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
        {
            mCustomNavView = (View) inflater.inflate(customNavId, this, false);
            mNavigationMode = ActionBar.NAVIGATION_MODE_STANDARD;
            setDisplayOptions(mDisplayOptions | ActionBar.DISPLAY_SHOW_CUSTOM);
        } //End block
        mContentHeight = a.getLayoutDimension(R.styleable.ActionBar_height, 0);
        a.recycle();
        mLogoNavItem = new ActionMenuItem(context, 0, android.R.id.home, 0, 0, mTitle);
        mHomeLayout.setOnClickListener(mUpClickListener);
        mHomeLayout.setClickable(true);
        mHomeLayout.setFocusable(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "2EBE795462E90C610435C294048EA12C", hash_generated_method = "9F232E3B897F5D2F1C3F3F526EDC0A64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        super.onConfigurationChanged(newConfig);
        mTitleView = null;
        mSubtitleView = null;
        mTitleUpView = null;
        {
            boolean varB8DBCA008916A21ADE49FDAE8A9163B8_474469541 = (mTitleLayout != null && mTitleLayout.getParent() == this);
            {
                removeView(mTitleLayout);
            } //End block
        } //End collapsed parenthetic
        mTitleLayout = null;
        {
            initTitle();
        } //End block
        {
            ViewGroup.LayoutParams lp;
            lp = mTabScrollView.getLayoutParams();
            {
                lp.width = LayoutParams.WRAP_CONTENT;
                lp.height = LayoutParams.MATCH_PARENT;
            } //End block
            mTabScrollView.setAllowCollapse(true);
        } //End block
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //mTitleView = null;
        //mSubtitleView = null;
        //mTitleUpView = null;
        //if (mTitleLayout != null && mTitleLayout.getParent() == this) {
            //removeView(mTitleLayout);
        //}
        //mTitleLayout = null;
        //if ((mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0) {
            //initTitle();
        //}
        //if (mTabScrollView != null && mIncludeTabs) {
            //ViewGroup.LayoutParams lp = mTabScrollView.getLayoutParams();
            //if (lp != null) {
                //lp.width = LayoutParams.WRAP_CONTENT;
                //lp.height = LayoutParams.MATCH_PARENT;
            //}
            //mTabScrollView.setAllowCollapse(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "3A6246ABFAB05CB7EB83E9ECE73695AD", hash_generated_method = "D157F3D93D7260539E2AC71B7B969D16")
    @DSModeled(DSC.SAFE)
    public void setWindowCallback(Window.Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        // ---------- Original Method ----------
        //mWindowCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "B71E506A9F91C1AD992AA849BAEDAF37", hash_generated_method = "1CF70B99B780C50319F2E329D8896459")
    @DSModeled(DSC.SAFE)
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        removeCallbacks(mTabSelector);
        {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //removeCallbacks(mTabSelector);
        //if (mActionMenuPresenter != null) {
            //mActionMenuPresenter.hideOverflowMenu();
            //mActionMenuPresenter.hideSubMenus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "1239C6C76A60BF63BE5F6B305C415611")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "B34BEF81F3C7DDE70AA74FE44CD8EB1E", hash_generated_method = "1315C9B6A12695C4A37CC65052B553E0")
    @DSModeled(DSC.SAFE)
    public void initProgress() {
        mProgressView = new ProgressBar(mContext, null, 0, mProgressStyle);
        mProgressView.setId(R.id.progress_horizontal);
        mProgressView.setMax(10000);
        addView(mProgressView);
        // ---------- Original Method ----------
        //mProgressView = new ProgressBar(mContext, null, 0, mProgressStyle);
        //mProgressView.setId(R.id.progress_horizontal);
        //mProgressView.setMax(10000);
        //addView(mProgressView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "19799DC3DC7751972B9DF9EE182F1D74", hash_generated_method = "6325684FB10BF065FC320EEDA0A10F57")
    @DSModeled(DSC.SAFE)
    public void initIndeterminateProgress() {
        mIndeterminateProgressView = new ProgressBar(mContext, null, 0,
                mIndeterminateProgressStyle);
        mIndeterminateProgressView.setId(R.id.progress_circular);
        addView(mIndeterminateProgressView);
        // ---------- Original Method ----------
        //mIndeterminateProgressView = new ProgressBar(mContext, null, 0,
                //mIndeterminateProgressStyle);
        //mIndeterminateProgressView.setId(R.id.progress_circular);
        //addView(mIndeterminateProgressView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "268F2B84CAE6E37FD4EC6111E5C155B1", hash_generated_method = "83283126EEAB9F7262410F3219494F1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSplitActionBar(boolean splitActionBar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(splitActionBar);
        {
            {
                final ViewGroup oldParent;
                oldParent = (ViewGroup) mMenuView.getParent();
                {
                    oldParent.removeView(mMenuView);
                } //End block
                {
                    {
                        mSplitView.addView(mMenuView);
                    } //End block
                } //End block
                {
                    addView(mMenuView);
                } //End block
            } //End block
            {
                mSplitView.setVisibility(splitActionBar ? VISIBLE : GONE);
            } //End block
            super.setSplitActionBar(splitActionBar);
        } //End block
        // ---------- Original Method ----------
        //if (mSplitActionBar != splitActionBar) {
            //if (mMenuView != null) {
                //final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                //if (oldParent != null) {
                    //oldParent.removeView(mMenuView);
                //}
                //if (splitActionBar) {
                    //if (mSplitView != null) {
                        //mSplitView.addView(mMenuView);
                    //}
                //} else {
                    //addView(mMenuView);
                //}
            //}
            //if (mSplitView != null) {
                //mSplitView.setVisibility(splitActionBar ? VISIBLE : GONE);
            //}
            //super.setSplitActionBar(splitActionBar);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "D1A0823C6A31D8186A466BCCCE11ADAA", hash_generated_method = "E46CE28398193B7235E5782D96CBDAA6")
    @DSModeled(DSC.SAFE)
    public boolean isSplitActionBar() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSplitActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.270 -0400", hash_original_method = "24672C2D43139828573B39E460E47DBC", hash_generated_method = "31888E509F9CC8ECA05E8C8464D7F51C")
    @DSModeled(DSC.SAFE)
    public boolean hasEmbeddedTabs() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIncludeTabs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "8DB0348F40E3331B8E5DC32ABABAB86E", hash_generated_method = "BF5F1D490AC1FF0179C89F3287D9626D")
    @DSModeled(DSC.SAFE)
    public void setEmbeddedTabView(ScrollingTabContainerView tabs) {
        dsTaint.addTaint(tabs.dsTaint);
        {
            removeView(mTabScrollView);
        } //End block
        mIncludeTabs = tabs != null;
        {
            addView(mTabScrollView);
            ViewGroup.LayoutParams lp;
            lp = mTabScrollView.getLayoutParams();
            lp.width = LayoutParams.WRAP_CONTENT;
            lp.height = LayoutParams.MATCH_PARENT;
            tabs.setAllowCollapse(true);
        } //End block
        // ---------- Original Method ----------
        //if (mTabScrollView != null) {
            //removeView(mTabScrollView);
        //}
        //mTabScrollView = tabs;
        //mIncludeTabs = tabs != null;
        //if (mIncludeTabs && mNavigationMode == ActionBar.NAVIGATION_MODE_TABS) {
            //addView(mTabScrollView);
            //ViewGroup.LayoutParams lp = mTabScrollView.getLayoutParams();
            //lp.width = LayoutParams.WRAP_CONTENT;
            //lp.height = LayoutParams.MATCH_PARENT;
            //tabs.setAllowCollapse(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "0457D3AD4F802E9E3CD470071939A6F3", hash_generated_method = "22EDE24903A5808D64673D58295443F3")
    @DSModeled(DSC.SAFE)
    public void setCallback(OnNavigationListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        // ---------- Original Method ----------
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "FFAF505C90B4E5149598A1AECE2C3213", hash_generated_method = "D4527983D93479FAA4A4A79D12B30153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMenu(Menu menu, MenuPresenter.Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        {
            mOptionsMenu.removeMenuPresenter(mActionMenuPresenter);
            mOptionsMenu.removeMenuPresenter(mExpandedMenuPresenter);
        } //End block
        MenuBuilder builder;
        builder = (MenuBuilder) menu;
        mOptionsMenu = builder;
        {
            final ViewGroup oldParent;
            oldParent = (ViewGroup) mMenuView.getParent();
            {
                oldParent.removeView(mMenuView);
            } //End block
        } //End block
        {
            mActionMenuPresenter = new ActionMenuPresenter(mContext);
            mActionMenuPresenter.setCallback(cb);
            mActionMenuPresenter.setId(com.android.internal.R.id.action_menu_presenter);
            mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
        } //End block
        ActionMenuView menuView;
        final LayoutParams layoutParams;
        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        {
            mActionMenuPresenter.setExpandedActionViewsExclusive(
                    getResources().getBoolean(
                    com.android.internal.R.bool.action_bar_expanded_action_views_exclusive));
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            final ViewGroup oldParent;
            oldParent = (ViewGroup) menuView.getParent();
            {
                oldParent.removeView(menuView);
            } //End block
            addView(menuView, layoutParams);
        } //End block
        {
            mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            mActionMenuPresenter.setWidthLimit(
                    getContext().getResources().getDisplayMetrics().widthPixels, true);
            mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            layoutParams.width = LayoutParams.MATCH_PARENT;
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            {
                final ViewGroup oldParent;
                oldParent = (ViewGroup) menuView.getParent();
                {
                    oldParent.removeView(menuView);
                } //End block
                menuView.setVisibility(getAnimatedVisibility());
                mSplitView.addView(menuView, layoutParams);
            } //End block
            {
                menuView.setLayoutParams(layoutParams);
            } //End block
        } //End block
        mMenuView = menuView;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "962CA6D106A54FF8005566B234E49437", hash_generated_method = "665D25ED232E8C175B9297B6D78B9EA8")
    @DSModeled(DSC.SAFE)
    private void configPresenters(MenuBuilder builder) {
        dsTaint.addTaint(builder.dsTaint);
        {
            builder.addMenuPresenter(mActionMenuPresenter);
            builder.addMenuPresenter(mExpandedMenuPresenter);
        } //End block
        {
            mActionMenuPresenter.initForMenu(mContext, null);
            mExpandedMenuPresenter.initForMenu(mContext, null);
            mActionMenuPresenter.updateMenuView(true);
            mExpandedMenuPresenter.updateMenuView(true);
        } //End block
        // ---------- Original Method ----------
        //if (builder != null) {
            //builder.addMenuPresenter(mActionMenuPresenter);
            //builder.addMenuPresenter(mExpandedMenuPresenter);
        //} else {
            //mActionMenuPresenter.initForMenu(mContext, null);
            //mExpandedMenuPresenter.initForMenu(mContext, null);
            //mActionMenuPresenter.updateMenuView(true);
            //mExpandedMenuPresenter.updateMenuView(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "8730ED187B27F4DCB92C97E3B6342387", hash_generated_method = "86E2F893F156C412446D16B5C3E34DE2")
    @DSModeled(DSC.SAFE)
    public boolean hasExpandedActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExpandedMenuPresenter != null &&
                //mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "E064456058852E66BECDCC9D9AA06FF8", hash_generated_method = "05E711CFC37934DE7001982159207FE0")
    @DSModeled(DSC.SAFE)
    public void collapseActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final MenuItemImpl item;
        item = null;
        item = mExpandedMenuPresenter.mCurrentExpandedItem;
        {
            item.collapseActionView();
        } //End block
        // ---------- Original Method ----------
        //final MenuItemImpl item = mExpandedMenuPresenter == null ? null :
                //mExpandedMenuPresenter.mCurrentExpandedItem;
        //if (item != null) {
            //item.collapseActionView();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "A015B4577A897E6E7B62945B8635CEDC", hash_generated_method = "ACE1D79BBFC5D97E88BF23474F7C61F0")
    @DSModeled(DSC.SAFE)
    public void setCustomNavigationView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        final boolean showCustom;
        showCustom = (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;
        {
            removeView(mCustomNavView);
        } //End block
        {
            addView(mCustomNavView);
        } //End block
        // ---------- Original Method ----------
        //final boolean showCustom = (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;
        //if (mCustomNavView != null && showCustom) {
            //removeView(mCustomNavView);
        //}
        //mCustomNavView = view;
        //if (mCustomNavView != null && showCustom) {
            //addView(mCustomNavView);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.271 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "C93F883BAA39D032555C8300A9C50A39")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "777E3F031124EBDDD3E24D756483B885", hash_generated_method = "27C2F27713ABBC900661541D3D086D10")
    @DSModeled(DSC.SAFE)
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mUserTitle = true;
        setTitleImpl(title);
        // ---------- Original Method ----------
        //mUserTitle = true;
        //setTitleImpl(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "193CF6C8B49C81B5000EB0B0B9EF604D", hash_generated_method = "EAACAFB1736E00E1609CDC678A8C506C")
    @DSModeled(DSC.SAFE)
    public void setWindowTitle(CharSequence title) {
        dsTaint.addTaint(title);
        {
            setTitleImpl(title);
        } //End block
        // ---------- Original Method ----------
        //if (!mUserTitle) {
            //setTitleImpl(title);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "CA4194BA53EDB0AC58DD1582B0D957BD", hash_generated_method = "F52AA52C38628C08FBFCDABE99D3C944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setTitleImpl(CharSequence title) {
        dsTaint.addTaint(title);
        {
            mTitleView.setText(title);
            final boolean visible;
            visible = mExpandedActionView == null &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        } //End block
        {
            mLogoNavItem.setTitle(title);
        } //End block
        // ---------- Original Method ----------
        //mTitle = title;
        //if (mTitleView != null) {
            //mTitleView.setText(title);
            //final boolean visible = mExpandedActionView == null &&
                    //(mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    //(!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            //mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        //}
        //if (mLogoNavItem != null) {
            //mLogoNavItem.setTitle(title);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "CFC3036F4184205A3442A189DF537980")
    @DSModeled(DSC.SAFE)
    public CharSequence getSubtitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubtitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "ECDAA3B767FC89031E52906AD709A8B9", hash_generated_method = "A67F7576B7D4F6A558C5BB7FF005B1CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubtitle(CharSequence subtitle) {
        dsTaint.addTaint(subtitle);
        {
            mSubtitleView.setText(subtitle);
            mSubtitleView.setVisibility(subtitle != null ? VISIBLE : GONE);
            final boolean visible;
            visible = mExpandedActionView == null &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        } //End block
        // ---------- Original Method ----------
        //mSubtitle = subtitle;
        //if (mSubtitleView != null) {
            //mSubtitleView.setText(subtitle);
            //mSubtitleView.setVisibility(subtitle != null ? VISIBLE : GONE);
            //final boolean visible = mExpandedActionView == null &&
                    //(mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    //(!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            //mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "BA9334347A50C815DACE5C734F6D1CA6", hash_generated_method = "C2CE2B42206D043E4E1E40E593D20B34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHomeButtonEnabled(boolean enable) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enable);
        mHomeLayout.setEnabled(enable);
        mHomeLayout.setFocusable(enable);
        {
            mHomeLayout.setContentDescription(null);
        } //End block
        {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_up_description));
        } //End block
        {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_home_description));
        } //End block
        // ---------- Original Method ----------
        //mHomeLayout.setEnabled(enable);
        //mHomeLayout.setFocusable(enable);
        //if (!enable) {
            //mHomeLayout.setContentDescription(null);
        //} else if ((mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
            //mHomeLayout.setContentDescription(mContext.getResources().getText(
                    //R.string.action_bar_up_description));
        //} else {
            //mHomeLayout.setContentDescription(mContext.getResources().getText(
                    //R.string.action_bar_home_description));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.272 -0400", hash_original_method = "729D65DF169EDB552B2DB5DF7F633BF2", hash_generated_method = "99C1128DBC47FD9505877E6E152E7BA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDisplayOptions(int options) {
        dsTaint.addTaint(options);
        final int flagsChanged;
        flagsChanged = -1;
        flagsChanged = options ^ mDisplayOptions;
        {
            final boolean showHome;
            showHome = (options & ActionBar.DISPLAY_SHOW_HOME) != 0;
            final int vis;
            vis = VISIBLE;
            vis = GONE;
            mHomeLayout.setVisibility(vis);
            {
                final boolean setUp;
                setUp = (options & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mHomeLayout.setUp(setUp);
                {
                    setHomeButtonEnabled(true);
                } //End block
            } //End block
            {
                final boolean logoVis;
                logoVis = mLogo != null && (options & ActionBar.DISPLAY_USE_LOGO) != 0;
                mHomeLayout.setIcon(logoVis ? mLogo : mIcon);
            } //End block
            {
                {
                    initTitle();
                } //End block
                {
                    removeView(mTitleLayout);
                } //End block
            } //End block
            {
                final boolean homeAsUp;
                homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
                mTitleLayout.setEnabled(!showHome && homeAsUp);
            } //End block
            {
                {
                    addView(mCustomNavView);
                } //End block
                {
                    removeView(mCustomNavView);
                } //End block
            } //End block
            requestLayout();
        } //End block
        {
            invalidate();
        } //End block
        {
            boolean var8FC373AFA9358E12A30E37AB5AA630D0_1623916228 = (!mHomeLayout.isEnabled());
            {
                mHomeLayout.setContentDescription(null);
            } //End block
            {
                mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_up_description));
            } //End block
            {
                mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_home_description));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "030F447392EAF535A82C251E2DB0C9D4", hash_generated_method = "8C2A3215DD7F84710729A3B2B5B02570")
    @DSModeled(DSC.SAFE)
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            mHomeLayout.setIcon(icon);
        } //End block
        // ---------- Original Method ----------
        //mIcon = icon;
        //if (icon != null &&
                //((mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) == 0 || mLogo == null)) {
            //mHomeLayout.setIcon(icon);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "7424D4DE12B074743D84FF4154B309BA", hash_generated_method = "2BC3130D49C517A428AECE0CC5DB40B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(int resId) {
        dsTaint.addTaint(resId);
        setIcon(mContext.getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setIcon(mContext.getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "6239F067617389BCFA9336EB6940A154", hash_generated_method = "D8D6086D0D4F78F33B87F373814707C0")
    @DSModeled(DSC.SAFE)
    public void setLogo(Drawable logo) {
        dsTaint.addTaint(logo.dsTaint);
        {
            mHomeLayout.setIcon(logo);
        } //End block
        // ---------- Original Method ----------
        //mLogo = logo;
        //if (logo != null && (mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) != 0) {
            //mHomeLayout.setIcon(logo);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "8F48D1A1BD2CE39E1CCC3DD41DD8DBB5", hash_generated_method = "E5E0EE12081487F54B6D947E53C681AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLogo(int resId) {
        dsTaint.addTaint(resId);
        setLogo(mContext.getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setLogo(mContext.getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "7C440BC8D2AAA3D5B444BDD726AE7ED7", hash_generated_method = "3693B17D2B0EB422A16E3063C22D6703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNavigationMode(int mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode);
        final int oldMode;
        oldMode = mNavigationMode;
        {
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            {
                removeView(mListNavLayout);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_TABS 
            {
                removeView(mTabScrollView);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_TABS 
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            {
                mSpinner = new Spinner(mContext, null,
                            com.android.internal.R.attr.actionDropDownStyle);
                mListNavLayout = new LinearLayout(mContext, null,
                            com.android.internal.R.attr.actionBarTabBarStyle);
                LinearLayout.LayoutParams params;
                params = new LinearLayout.LayoutParams(
                            LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                params.gravity = Gravity.CENTER;
                mListNavLayout.addView(mSpinner, params);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            {
                boolean var52395F21CD7D9E73DAD0C4C932A32AD1_2111134153 = (mSpinner.getAdapter() != mSpinnerAdapter);
                {
                    mSpinner.setAdapter(mSpinnerAdapter);
                } //End block
            } //End collapsed parenthetic
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            mSpinner.setOnItemSelectedListener(mNavItemSelectedListener);
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            addView(mListNavLayout);
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_TABS 
            {
                addView(mTabScrollView);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_TABS 
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "89B6C7658DAE063C75647F5ADF8E9216", hash_generated_method = "AC74B463FD928A99A857C956253BE771")
    @DSModeled(DSC.SAFE)
    public void setDropdownAdapter(SpinnerAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mSpinner.setAdapter(adapter);
        } //End block
        // ---------- Original Method ----------
        //mSpinnerAdapter = adapter;
        //if (mSpinner != null) {
            //mSpinner.setAdapter(adapter);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "1A4098174F41A05D8E016C60876697BD", hash_generated_method = "5CB03BECF9E33A8B1A9D5C9C965BE6C7")
    @DSModeled(DSC.SAFE)
    public SpinnerAdapter getDropdownAdapter() {
        return (SpinnerAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSpinnerAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "AD9310333D391F8A81F374E0D04AD8BB", hash_generated_method = "5969699996FEB766889DEB8CCA27F22E")
    @DSModeled(DSC.SAFE)
    public void setDropdownSelectedPosition(int position) {
        dsTaint.addTaint(position);
        mSpinner.setSelection(position);
        // ---------- Original Method ----------
        //mSpinner.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "434984419C6BB9581BBBAD71AB1CA07D", hash_generated_method = "C63F862F32FFE441975B3A12133B0079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDropdownSelectedPosition() {
        int var1650F6FEAE0120B0496D88EF942CC734_113618376 = (mSpinner.getSelectedItemPosition());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSpinner.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.273 -0400", hash_original_method = "1544DDF36E6082443A2EF4ED7A4DF538", hash_generated_method = "EA077454E3475B2C02D53FF7FE1B96BC")
    @DSModeled(DSC.SAFE)
    public View getCustomNavigationView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCustomNavView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "14AA191B691A51A87445A62103C542CB", hash_generated_method = "D0DA24EE5F15DE741C775244442638F8")
    @DSModeled(DSC.SAFE)
    public int getNavigationMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNavigationMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "7126F05C057CF7F499EBFF9A1F4C4A02", hash_generated_method = "234C5DEADADD3759CD8A00C841C2F244")
    @DSModeled(DSC.SAFE)
    public int getDisplayOptions() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDisplayOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "CC715ED5E40E0E0CF6C0353136D75335", hash_generated_method = "656D817F98BF53AD8714B2163B47990A")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "5C54848E55EB765D8F0ED5A386E76AE7", hash_generated_method = "555339DCB2602C8BD92DDE48B1320C2D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        addView(mHomeLayout);
        {
            final ViewParent parent;
            parent = mCustomNavView.getParent();
            {
                {
                    ((ViewGroup) parent).removeView(mCustomNavView);
                } //End block
                addView(mCustomNavView);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //addView(mHomeLayout);
        //if (mCustomNavView != null && (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0) {
            //final ViewParent parent = mCustomNavView.getParent();
            //if (parent != this) {
                //if (parent instanceof ViewGroup) {
                    //((ViewGroup) parent).removeView(mCustomNavView);
                //}
                //addView(mCustomNavView);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "CF8F187E9CF2FA51D65633927C0BE8F6", hash_generated_method = "BB885A3AD461187993C2B834BE84FD10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initTitle() {
        {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            mTitleLayout = (LinearLayout) inflater.inflate(R.layout.action_bar_title_item,
                    this, false);
            mTitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_title);
            mSubtitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_subtitle);
            mTitleUpView = (View) mTitleLayout.findViewById(R.id.up);
            mTitleLayout.setOnClickListener(mUpClickListener);
            {
                mTitleView.setTextAppearance(mContext, mTitleStyleRes);
            } //End block
            {
                mTitleView.setText(mTitle);
            } //End block
            {
                mSubtitleView.setTextAppearance(mContext, mSubtitleStyleRes);
            } //End block
            {
                mSubtitleView.setText(mSubtitle);
                mSubtitleView.setVisibility(VISIBLE);
            } //End block
            final boolean homeAsUp;
            homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
            final boolean showHome;
            showHome = (mDisplayOptions & ActionBar.DISPLAY_SHOW_HOME) != 0;
            mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
            mTitleLayout.setEnabled(homeAsUp && !showHome);
        } //End block
        addView(mTitleLayout);
        {
            boolean var1049AFB1933262799884B2BE4492C363_637449432 = (mExpandedActionView != null ||
                (TextUtils.isEmpty(mTitle) && TextUtils.isEmpty(mSubtitle)));
            {
                mTitleLayout.setVisibility(GONE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "F623B40982707A8AF90610858040ED3E", hash_generated_method = "FB31BDB9CEF79B349B5002CA0C30D866")
    @DSModeled(DSC.SAFE)
    public void setContextView(ActionBarContextView view) {
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
        //mContextView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "4C7B7DAEF91C23BA8E2CF63957DDD2D5", hash_generated_method = "E4F1B174D47E470C96BF2101DAE4CF91")
    @DSModeled(DSC.SAFE)
    public void setCollapsable(boolean collapsable) {
        dsTaint.addTaint(collapsable);
        // ---------- Original Method ----------
        //mIsCollapsable = collapsable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.274 -0400", hash_original_method = "85F70991FC3EED5A4EDF0B8F79DFC73E", hash_generated_method = "32A03B1266D774B6851F6CACC9F83BFE")
    @DSModeled(DSC.SAFE)
    public boolean isCollapsed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsCollapsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.275 -0400", hash_original_method = "EDE59536C59F48F9C9A7E58A0D736A35", hash_generated_method = "E5F60B91DD71C099621F67A4648BB19F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        final int childCount;
        childCount = getChildCount();
        {
            int visibleChildren;
            visibleChildren = 0;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = getChildAt(i);
                    {
                        boolean var7DAF9176C442508CDC90616FB4E12787_524148161 = (child.getVisibility() != GONE &&
                        !(child == mMenuView && mMenuView.getChildCount() == 0));
                        {
                            visibleChildren++;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                setMeasuredDimension(0, 0);
                mIsCollapsed = true;
            } //End block
        } //End block
        mIsCollapsed = false;
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
        } //End block
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
        } //End block
        int contentWidth;
        contentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight;
        maxHeight = mContentHeight;
        maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        final int verticalPadding;
        verticalPadding = getPaddingTop() + getPaddingBottom();
        final int paddingLeft;
        paddingLeft = getPaddingLeft();
        final int paddingRight;
        paddingRight = getPaddingRight();
        final int height;
        height = maxHeight - verticalPadding;
        final int childSpecHeight;
        childSpecHeight = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        int availableWidth;
        availableWidth = contentWidth - paddingLeft - paddingRight;
        int leftOfCenter;
        leftOfCenter = availableWidth / 2;
        int rightOfCenter;
        rightOfCenter = leftOfCenter;
        HomeView homeLayout;
        homeLayout = mExpandedHomeLayout;
        homeLayout = mHomeLayout;
        {
            boolean var69FA44B1FF5F26DD82195316B3CBA4FD_1236575352 = (homeLayout.getVisibility() != GONE);
            {
                final ViewGroup.LayoutParams lp;
                lp = homeLayout.getLayoutParams();
                int homeWidthSpec;
                {
                    homeWidthSpec = MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST);
                } //End block
                {
                    homeWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
                } //End block
                homeLayout.measure(homeWidthSpec,
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                final int homeWidth;
                homeWidth = homeLayout.getMeasuredWidth() + homeLayout.getLeftOffset();
                availableWidth = Math.max(0, availableWidth - homeWidth);
                leftOfCenter = Math.max(0, availableWidth - homeWidth);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1178C40D6B4B3394C757D204E5BDCC27_140888510 = (mMenuView != null && mMenuView.getParent() == this);
            {
                availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
                rightOfCenter = Math.max(0, rightOfCenter - mMenuView.getMeasuredWidth());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6150CF4CAC1097FD770B8EA55CD0A539_717996629 = (mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE);
            {
                availableWidth = measureChildView(mIndeterminateProgressView, availableWidth,
                    childSpecHeight, 0);
                rightOfCenter = Math.max(0,
                    rightOfCenter - mIndeterminateProgressView.getMeasuredWidth());
            } //End block
        } //End collapsed parenthetic
        final boolean showTitle;
        showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
        {
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            {
                final int itemPaddingSize;
                itemPaddingSize = mItemPadding * 2;
                itemPaddingSize = mItemPadding;
                availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                mListNavLayout.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                final int listNavWidth;
                listNavWidth = mListNavLayout.getMeasuredWidth();
                availableWidth = Math.max(0, availableWidth - listNavWidth);
                leftOfCenter = Math.max(0, leftOfCenter - listNavWidth);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_TABS 
            {
                final int itemPaddingSize;
                itemPaddingSize = mItemPadding * 2;
                itemPaddingSize = mItemPadding;
                availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                mTabScrollView.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                final int tabWidth;
                tabWidth = mTabScrollView.getMeasuredWidth();
                availableWidth = Math.max(0, availableWidth - tabWidth);
                leftOfCenter = Math.max(0, leftOfCenter - tabWidth);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_TABS 
        } //End block
        View customView;
        customView = null;
        {
            customView = mExpandedActionView;
        } //End block
        {
            customView = mCustomNavView;
        } //End block
        {
            final ViewGroup.LayoutParams lp;
            lp = generateLayoutParams(customView.getLayoutParams());
            final ActionBar.LayoutParams ablp;
            ablp = (ActionBar.LayoutParams) lp;
            ablp = null;
            int horizontalMargin;
            horizontalMargin = 0;
            int verticalMargin;
            verticalMargin = 0;
            {
                horizontalMargin = ablp.leftMargin + ablp.rightMargin;
                verticalMargin = ablp.topMargin + ablp.bottomMargin;
            } //End block
            int customNavHeightMode;
            {
                customNavHeightMode = MeasureSpec.AT_MOST;
            } //End block
            {
                customNavHeightMode = lp.height != LayoutParams.WRAP_CONTENT ?
                        MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            } //End block
            final int customNavHeight;
            customNavHeight = Math.max(0,
                    (lp.height >= 0 ? Math.min(lp.height, height) : height) - verticalMargin);//DSFIXME:  CODE0008: Nested ternary operator in expression
            final int customNavWidthMode;
            customNavWidthMode = MeasureSpec.EXACTLY;
            customNavWidthMode = MeasureSpec.AT_MOST;
            int customNavWidth;
            customNavWidth = Math.max(0,
                    (lp.width >= 0 ? Math.min(lp.width, availableWidth) : availableWidth)
                    - horizontalMargin);//DSFIXME:  CODE0008: Nested ternary operator in expression
            final int hgrav;
            hgrav = (ablp != null ? ablp.gravity : DEFAULT_CUSTOM_GRAVITY) &
                    Gravity.HORIZONTAL_GRAVITY_MASK;//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                customNavWidth = Math.min(leftOfCenter, rightOfCenter) * 2;
            } //End block
            customView.measure(
                    MeasureSpec.makeMeasureSpec(customNavWidth, customNavWidthMode),
                    MeasureSpec.makeMeasureSpec(customNavHeight, customNavHeightMode));
            availableWidth -= horizontalMargin + customView.getMeasuredWidth();
        } //End block
        {
            availableWidth = measureChildView(mTitleLayout, availableWidth,
                    MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY), 0);
            leftOfCenter = Math.max(0, leftOfCenter - mTitleLayout.getMeasuredWidth());
        } //End block
        {
            int measuredHeight;
            measuredHeight = 0;
            {
                int i;
                i = 0;
                {
                    View v;
                    v = getChildAt(i);
                    int paddedViewHeight;
                    paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                    {
                        measuredHeight = paddedViewHeight;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            setMeasuredDimension(contentWidth, measuredHeight);
        } //End block
        {
            setMeasuredDimension(contentWidth, maxHeight);
        } //End block
        {
            mContextView.setContentHeight(getMeasuredHeight());
        } //End block
        {
            boolean var1E5A6DD9EDF6AF1A1E51C13CC8FC6B74_1930890160 = (mProgressView != null && mProgressView.getVisibility() != GONE);
            {
                mProgressView.measure(MeasureSpec.makeMeasureSpec(
                    contentWidth - mProgressBarPadding * 2, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.AT_MOST));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "632E55F727AC38C1F794E2370B6AE161", hash_generated_method = "A9CF1BA27CC656DD8E080C318A25F926")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        int x;
        x = getPaddingLeft();
        final int y;
        y = getPaddingTop();
        final int contentHeight;
        contentHeight = b - t - getPaddingTop() - getPaddingBottom();
        HomeView homeLayout;
        homeLayout = mExpandedHomeLayout;
        homeLayout = mHomeLayout;
        {
            boolean var69FA44B1FF5F26DD82195316B3CBA4FD_1231895807 = (homeLayout.getVisibility() != GONE);
            {
                final int leftOffset;
                leftOffset = homeLayout.getLeftOffset();
                x += positionChild(homeLayout, x + leftOffset, y, contentHeight) + leftOffset;
            } //End block
        } //End collapsed parenthetic
        {
            final boolean showTitle;
            showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
            {
                x += positionChild(mTitleLayout, x, y, contentHeight);
            } //End block
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            {
                x += mItemPadding;
                x += positionChild(mListNavLayout, x, y, contentHeight) + mItemPadding;
            } //End block
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_TABS 
            {
                x += mItemPadding;
                x += positionChild(mTabScrollView, x, y, contentHeight) + mItemPadding;
            } //End block
            //End case ActionBar.NAVIGATION_MODE_TABS 
        } //End block
        int menuLeft;
        menuLeft = r - l - getPaddingRight();
        {
            boolean var1178C40D6B4B3394C757D204E5BDCC27_1025696389 = (mMenuView != null && mMenuView.getParent() == this);
            {
                positionChildInverse(mMenuView, menuLeft, y, contentHeight);
                menuLeft -= mMenuView.getMeasuredWidth();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6150CF4CAC1097FD770B8EA55CD0A539_495043838 = (mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE);
            {
                positionChildInverse(mIndeterminateProgressView, menuLeft, y, contentHeight);
                menuLeft -= mIndeterminateProgressView.getMeasuredWidth();
            } //End block
        } //End collapsed parenthetic
        View customView;
        customView = null;
        {
            customView = mExpandedActionView;
        } //End block
        {
            customView = mCustomNavView;
        } //End block
        {
            ViewGroup.LayoutParams lp;
            lp = customView.getLayoutParams();
            final ActionBar.LayoutParams ablp;
            ablp = (ActionBar.LayoutParams) lp;
            ablp = null;
            final int gravity;
            gravity = ablp.gravity;
            gravity = DEFAULT_CUSTOM_GRAVITY;
            final int navWidth;
            navWidth = customView.getMeasuredWidth();
            int topMargin;
            topMargin = 0;
            int bottomMargin;
            bottomMargin = 0;
            {
                x += ablp.leftMargin;
                menuLeft -= ablp.rightMargin;
                topMargin = ablp.topMargin;
                bottomMargin = ablp.bottomMargin;
            } //End block
            int hgravity;
            hgravity = gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
            {
                final int centeredLeft;
                centeredLeft = ((mRight - mLeft) - navWidth) / 2;
                {
                    hgravity = Gravity.LEFT;
                } //End block
                {
                    hgravity = Gravity.RIGHT;
                } //End block
            } //End block
            {
                hgravity = Gravity.LEFT;
            } //End block
            int xpos;
            xpos = 0;
            //Begin case Gravity.CENTER_HORIZONTAL 
            xpos = ((mRight - mLeft) - navWidth) / 2;
            //End case Gravity.CENTER_HORIZONTAL 
            //Begin case Gravity.LEFT 
            xpos = x;
            //End case Gravity.LEFT 
            //Begin case Gravity.RIGHT 
            xpos = menuLeft - navWidth;
            //End case Gravity.RIGHT 
            int vgravity;
            vgravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;
            {
                vgravity = Gravity.CENTER_VERTICAL;
            } //End block
            int ypos;
            ypos = 0;
            //Begin case Gravity.CENTER_VERTICAL 
            final int paddedTop;
            paddedTop = getPaddingTop();
            //End case Gravity.CENTER_VERTICAL 
            //Begin case Gravity.CENTER_VERTICAL 
            final int paddedBottom;
            paddedBottom = mBottom - mTop - getPaddingBottom();
            //End case Gravity.CENTER_VERTICAL 
            //Begin case Gravity.CENTER_VERTICAL 
            ypos = ((paddedBottom - paddedTop) - customView.getMeasuredHeight()) / 2;
            //End case Gravity.CENTER_VERTICAL 
            //Begin case Gravity.TOP 
            ypos = getPaddingTop() + topMargin;
            //End case Gravity.TOP 
            //Begin case Gravity.BOTTOM 
            ypos = getHeight() - getPaddingBottom() - customView.getMeasuredHeight()
                            - bottomMargin;
            //End case Gravity.BOTTOM 
            final int customWidth;
            customWidth = customView.getMeasuredWidth();
            customView.layout(xpos, ypos, xpos + customWidth,
                    ypos + customView.getMeasuredHeight());
            x += customWidth;
        } //End block
        {
            mProgressView.bringToFront();
            final int halfProgressHeight;
            halfProgressHeight = mProgressView.getMeasuredHeight() / 2;
            mProgressView.layout(mProgressBarPadding, -halfProgressHeight,
                    mProgressBarPadding + mProgressView.getMeasuredWidth(), halfProgressHeight);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "5CAA9C4F0891E70178B26E7CA87F1572", hash_generated_method = "0D6E0FEE13A750E8F6B25A81E9840B96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        ViewGroup.LayoutParams var637EC86D80E484FE2F5A8C4A116C314C_1005269818 = (new ActionBar.LayoutParams(getContext(), attrs));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ActionBar.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "19310F391EC0B469A38234970BA36DD5", hash_generated_method = "B879C60D4C16E1107839785A30693EDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        dsTaint.addTaint(lp.dsTaint);
        {
            lp = generateDefaultLayoutParams();
        } //End block
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (lp == null) {
            //lp = generateDefaultLayoutParams();
        //}
        //return lp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "F7EC1EBD6989B5AFA75F6EFE3D4C9302", hash_generated_method = "23AAB15C81FAB491A8C844807DAC553A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState state;
        state = new SavedState(superState);
        {
            state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        } //End block
        state.isOverflowOpen = isOverflowMenuShowing();
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState state = new SavedState(superState);
        //if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            //state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        //}
        //state.isOverflowOpen = isOverflowMenuShowing();
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "2EB5982AB19EADE49A68C3033BC69293", hash_generated_method = "A8F23CE739D7B21F8430D8C72527D972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable p) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(p.dsTaint);
        SavedState state;
        state = (SavedState) p;
        super.onRestoreInstanceState(state.getSuperState());
        {
            final MenuItem item;
            item = mOptionsMenu.findItem(state.expandedMenuItemId);
            {
                item.expandActionView();
            } //End block
        } //End block
        {
            postShowOverflowMenu();
        } //End block
        // ---------- Original Method ----------
        //SavedState state = (SavedState) p;
        //super.onRestoreInstanceState(state.getSuperState());
        //if (state.expandedMenuItemId != 0 &&
                //mExpandedMenuPresenter != null && mOptionsMenu != null) {
            //final MenuItem item = mOptionsMenu.findItem(state.expandedMenuItemId);
            //if (item != null) {
                //item.expandActionView();
            //}
        //}
        //if (state.isOverflowOpen) {
            //postShowOverflowMenu();
        //}
    }

    
    static class SavedState extends BaseSavedState {
        int expandedMenuItemId;
        boolean isOverflowOpen;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "6C6B0A873BD52E2752F88E9968D483CA")
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "1325778BB443F872513E70F9A19C5918")
            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.277 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "BBD854AA7A117C86D9FBF897ADE36FE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "D55BB2752CF51EBBB8F6639920409E43", hash_generated_method = "94A56002BCD1E41B8AC828F4D47B9E67")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            expandedMenuItemId = in.readInt();
            isOverflowOpen = in.readInt() != 0;
            // ---------- Original Method ----------
            //expandedMenuItemId = in.readInt();
            //isOverflowOpen = in.readInt() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "515851E7BACA5483746DDD359AD42324", hash_generated_method = "8605EC784B088B5686B9E36F995F8C89")
        @DSModeled(DSC.SAFE)
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            super.writeToParcel(out, flags);
            out.writeInt(expandedMenuItemId);
            out.writeInt(isOverflowOpen ? 1 : 0);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(expandedMenuItemId);
            //out.writeInt(isOverflowOpen ? 1 : 0);
        }

        
    }


    
    private static class HomeView extends FrameLayout {
        private View mUpView;
        private ImageView mIconView;
        private int mUpWidth;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "D411D61D16BBF4279D3867C1E411F377", hash_generated_method = "6E336C0572177DBDBC731B231BC927A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public HomeView(Context context) {
            this(context, null);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "A7CE440DF9BFAF8E10FD8D594704D071", hash_generated_method = "B9E133C34B04031A22FDE8C90F59EE0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "9F32A31FB673DE4EC8BCDCE1EEBEDDFA", hash_generated_method = "88441F070C0FDCBB8B3BE88275D5C97D")
        @DSModeled(DSC.SAFE)
        public void setUp(boolean isUp) {
            dsTaint.addTaint(isUp);
            mUpView.setVisibility(isUp ? VISIBLE : GONE);
            // ---------- Original Method ----------
            //mUpView.setVisibility(isUp ? VISIBLE : GONE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "F0A9CABDEAA57DB9E5ACC2CB832FAA3E", hash_generated_method = "BA0B4D25AF4937085132088A5E75DD38")
        @DSModeled(DSC.SAFE)
        public void setIcon(Drawable icon) {
            dsTaint.addTaint(icon.dsTaint);
            mIconView.setImageDrawable(icon);
            // ---------- Original Method ----------
            //mIconView.setImageDrawable(icon);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "70D1D99B57C3B8254D0DF31E105F0F5B")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            dsTaint.addTaint(event.dsTaint);
            onPopulateAccessibilityEvent(event);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //onPopulateAccessibilityEvent(event);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "B4B0FD2B19B7C0DBCF5FF0FDC0B7B20F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            super.onPopulateAccessibilityEvent(event);
            final CharSequence cdesc;
            cdesc = getContentDescription();
            {
                boolean var2867030CDEABDD91B93106875518E0B9_1565591602 = (!TextUtils.isEmpty(cdesc));
                {
                    event.getText().add(cdesc);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //super.onPopulateAccessibilityEvent(event);
            //final CharSequence cdesc = getContentDescription();
            //if (!TextUtils.isEmpty(cdesc)) {
                //event.getText().add(cdesc);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "D09F328AE2A387F63D0FC6E5EFB478A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean dispatchHoverEvent(MotionEvent event) {
            dsTaint.addTaint(event.dsTaint);
            boolean var493B0665694C63B1B269F548FEE919AB_1221902169 = (onHoverEvent(event));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return onHoverEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "2B32BD9128787E0840E1C599EF5CB94E", hash_generated_method = "DA48B55EE85689E5A31514BDA0FF77F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onFinishInflate() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mUpView = findViewById(com.android.internal.R.id.up);
            mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
            // ---------- Original Method ----------
            //mUpView = findViewById(com.android.internal.R.id.up);
            //mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.278 -0400", hash_original_method = "782BC6B05C8AB6ECAC8D4CC02CB172F4", hash_generated_method = "908DE60E108682F39221C41F5CAC4DBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getLeftOffset() {
            {
                boolean var2AB0E93DC2FD2F6FCFF12E2D10799B12_513841366 = (mUpView.getVisibility() == GONE);
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mUpView.getVisibility() == GONE ? mUpWidth : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "1194BB929AE595B65CC6F2F618759EC2", hash_generated_method = "B1180C833435CFCC56FC3DBC40E701DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(heightMeasureSpec);
            dsTaint.addTaint(widthMeasureSpec);
            measureChildWithMargins(mUpView, widthMeasureSpec, 0, heightMeasureSpec, 0);
            final LayoutParams upLp;
            upLp = (LayoutParams) mUpView.getLayoutParams();
            mUpWidth = upLp.leftMargin + mUpView.getMeasuredWidth() + upLp.rightMargin;
            int width;
            boolean var6F7FB5A2512F4A9FD1F89B251120F547_1445447481 = (mUpView.getVisibility() == GONE);
            width = 0;
            width = mUpWidth;
            int height;
            height = upLp.topMargin + mUpView.getMeasuredHeight() + upLp.bottomMargin;
            measureChildWithMargins(mIconView, widthMeasureSpec, width, heightMeasureSpec, 0);
            final LayoutParams iconLp;
            iconLp = (LayoutParams) mIconView.getLayoutParams();
            width += iconLp.leftMargin + mIconView.getMeasuredWidth() + iconLp.rightMargin;
            height = Math.max(height,
                    iconLp.topMargin + mIconView.getMeasuredHeight() + iconLp.bottomMargin);
            final int widthMode;
            widthMode = MeasureSpec.getMode(widthMeasureSpec);
            final int heightMode;
            heightMode = MeasureSpec.getMode(heightMeasureSpec);
            final int widthSize;
            widthSize = MeasureSpec.getSize(widthMeasureSpec);
            final int heightSize;
            heightSize = MeasureSpec.getSize(heightMeasureSpec);
            //Begin case MeasureSpec.AT_MOST 
            width = Math.min(width, widthSize);
            //End case MeasureSpec.AT_MOST 
            //Begin case MeasureSpec.EXACTLY 
            width = widthSize;
            //End case MeasureSpec.EXACTLY 
            //Begin case MeasureSpec.AT_MOST 
            height = Math.min(height, heightSize);
            //End case MeasureSpec.AT_MOST 
            //Begin case MeasureSpec.EXACTLY 
            height = heightSize;
            //End case MeasureSpec.EXACTLY 
            setMeasuredDimension(width, height);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "7C995435E08D7DDC1C5A7F44746F458B", hash_generated_method = "203A75FA7EE4B8C52351DD3AE64F45DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(t);
            dsTaint.addTaint(b);
            dsTaint.addTaint(r);
            dsTaint.addTaint(l);
            dsTaint.addTaint(changed);
            final int vCenter;
            vCenter = (b - t) / 2;
            int width;
            width = r - l;
            int upOffset;
            upOffset = 0;
            {
                boolean varAE3FC7AE078D2248073FC8A7AF801B0F_1512406056 = (mUpView.getVisibility() != GONE);
                {
                    final LayoutParams upLp;
                    upLp = (LayoutParams) mUpView.getLayoutParams();
                    final int upHeight;
                    upHeight = mUpView.getMeasuredHeight();
                    final int upWidth;
                    upWidth = mUpView.getMeasuredWidth();
                    final int upTop;
                    upTop = vCenter - upHeight / 2;
                    mUpView.layout(0, upTop, upWidth, upTop + upHeight);
                    upOffset = upLp.leftMargin + upWidth + upLp.rightMargin;
                    width -= upOffset;
                    l += upOffset;
                } //End block
            } //End collapsed parenthetic
            final LayoutParams iconLp;
            iconLp = (LayoutParams) mIconView.getLayoutParams();
            final int iconHeight;
            iconHeight = mIconView.getMeasuredHeight();
            final int iconWidth;
            iconWidth = mIconView.getMeasuredWidth();
            final int hCenter;
            hCenter = (r - l) / 2;
            final int iconLeft;
            iconLeft = upOffset + Math.max(iconLp.leftMargin, hCenter - iconWidth / 2);
            final int iconTop;
            iconTop = Math.max(iconLp.topMargin, vCenter - iconHeight / 2);
            mIconView.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuBuilder mMenu;
        MenuItemImpl mCurrentExpandedItem;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "792819F971142AF5AE41DA85E214C5C9", hash_generated_method = "421F268CEE9AA80CCEFAAFF6353DFA6E")
        @DSModeled(DSC.SAFE)
        @Override
        public void initForMenu(Context context, MenuBuilder menu) {
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            {
                mMenu.collapseItemActionView(mCurrentExpandedItem);
            } //End block
            // ---------- Original Method ----------
            //if (mMenu != null && mCurrentExpandedItem != null) {
                //mMenu.collapseItemActionView(mCurrentExpandedItem);
            //}
            //mMenu = menu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "C60404B6CC35B9780D9F9822482B710D", hash_generated_method = "A815CA45EFED67325AA820F205E82CF9")
        @DSModeled(DSC.SAFE)
        @Override
        public MenuView getMenuView(ViewGroup root) {
            dsTaint.addTaint(root.dsTaint);
            return (MenuView)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "226E9F894ABBAE0501C29D5C6F0FF83B", hash_generated_method = "ED8F388B3EE1252FF22D592198881D5E")
        @DSModeled(DSC.SAFE)
        @Override
        public void updateMenuView(boolean cleared) {
            dsTaint.addTaint(cleared);
            {
                boolean found;
                found = false;
                {
                    final int count;
                    count = mMenu.size();
                    {
                        int i;
                        i = 0;
                        {
                            final MenuItem item;
                            item = mMenu.getItem(i);
                            {
                                found = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    collapseItemActionView(mMenu, mCurrentExpandedItem);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (mCurrentExpandedItem != null) {
                //boolean found = false;
                //if (mMenu != null) {
                    //final int count = mMenu.size();
                    //for (int i = 0; i < count; i++) {
                        //final MenuItem item = mMenu.getItem(i);
                        //if (item == mCurrentExpandedItem) {
                            //found = true;
                            //break;
                        //}
                    //}
                //}
                //if (!found) {
                    //collapseItemActionView(mMenu, mCurrentExpandedItem);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "C83F707E18EA3360FADD00AE5C28CDF5", hash_generated_method = "3CC7F52A4D17346A7B6A9A2094E4BF0C")
        @DSModeled(DSC.SAFE)
        @Override
        public void setCallback(Callback cb) {
            dsTaint.addTaint(cb.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "7065AC4BF04829F4DD8494E3AEDE278B", hash_generated_method = "33AEEE112574F87886653D18C8237793")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(subMenu.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "580417B4878CA8ACE579C198358BCAAA")
        @DSModeled(DSC.SAFE)
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(allMenusAreClosing);
            dsTaint.addTaint(menu.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.279 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "761071654EC1C62DB275D4D4771F344C")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean flagActionItems() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.280 -0400", hash_original_method = "995B7A71D6CB331F5D54C3F6E2CEFCD4", hash_generated_method = "220C82F0194DBEB9F1223DBFC6EBF0F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(item.dsTaint);
            mExpandedActionView = item.getActionView();
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
            {
                boolean var7811D6348E8E8927920AD531ECB22264_2024314133 = (mExpandedActionView.getParent() != ActionBarView.this);
                {
                    addView(mExpandedActionView);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCD5AB96D29ED8937C8936431173407E1_1941072304 = (mExpandedHomeLayout.getParent() != ActionBarView.this);
                {
                    addView(mExpandedHomeLayout);
                } //End block
            } //End collapsed parenthetic
            mHomeLayout.setVisibility(GONE);
            mTitleLayout.setVisibility(GONE);
            mTabScrollView.setVisibility(GONE);
            mSpinner.setVisibility(GONE);
            mCustomNavView.setVisibility(GONE);
            requestLayout();
            item.setActionViewExpanded(true);
            {
                ((CollapsibleActionView) mExpandedActionView).onActionViewExpanded();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.280 -0400", hash_original_method = "91D41E28867193763062F9A55820BEE2", hash_generated_method = "C893A8808EA5AAD563F07B098F26D726")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(item.dsTaint);
            {
                ((CollapsibleActionView) mExpandedActionView).onActionViewCollapsed();
            } //End block
            removeView(mExpandedActionView);
            removeView(mExpandedHomeLayout);
            mExpandedActionView = null;
            {
                mHomeLayout.setVisibility(VISIBLE);
            } //End block
            {
                {
                    initTitle();
                } //End block
                {
                    mTitleLayout.setVisibility(VISIBLE);
                } //End block
            } //End block
            {
                mTabScrollView.setVisibility(VISIBLE);
            } //End block
            {
                mSpinner.setVisibility(VISIBLE);
            } //End block
            {
                mCustomNavView.setVisibility(VISIBLE);
            } //End block
            mExpandedHomeLayout.setIcon(null);
            mCurrentExpandedItem = null;
            requestLayout();
            item.setActionViewExpanded(false);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.280 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "68706D134060346AA722E022B5A59EB2")
        @DSModeled(DSC.SAFE)
        @Override
        public int getId() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.280 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "AA51845457A002146B2A835A71E90C33")
        @DSModeled(DSC.SAFE)
        @Override
        public Parcelable onSaveInstanceState() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return (Parcelable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.280 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "5D07BACF361215F340B62618883EE831")
        @DSModeled(DSC.SAFE)
        @Override
        public void onRestoreInstanceState(Parcelable state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(state.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}


