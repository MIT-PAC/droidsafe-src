package com.android.internal.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import com.android.internal.view.menu.SubMenuBuilder;
import com.android.internal.widget.ActionBarContainer;
import com.android.internal.widget.ActionBarContextView;
import com.android.internal.widget.ActionBarView;
import com.android.internal.widget.ScrollingTabContainerView;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarImpl extends ActionBar {
    private Context mContext;
    private Context mThemedContext;
    private Activity mActivity;
    private Dialog mDialog;
    private ActionBarContainer mContainerView;
    private ActionBarView mActionView;
    private ActionBarContextView mContextView;
    private ActionBarContainer mSplitView;
    private View mContentView;
    private ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs = new ArrayList<TabImpl>();
    private TabImpl mSelectedTab;
    private int mSavedTabPosition = INVALID_POSITION;
    ActionModeImpl mActionMode;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mLastMenuVisibility;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners =
            new ArrayList<OnMenuVisibilityListener>();
    private int mContextDisplayMode;
    private boolean mHasEmbeddedTabs;
    Handler mHandler = new Handler();
    Runnable mTabSelector;
    private Animator mCurrentShowAnim;
    private Animator mCurrentModeAnim;
    private boolean mShowHideAnimationEnabled;
    boolean mWasHiddenBeforeMode;
    final AnimatorListener mHideListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.888 -0400", hash_original_method = "F963BB61325C11416F39E483670ED211", hash_generated_method = "412DBA2AA272AC6311C82BA1C26A2B75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                mContentView.setTranslationY(0);
                mContainerView.setTranslationY(0);
            } //End block
            {
                mSplitView.setVisibility(View.GONE);
            } //End block
            mContainerView.setVisibility(View.GONE);
            mContainerView.setTransitioning(false);
            mCurrentShowAnim = null;
            completeDeferredDestroyActionMode();
            // ---------- Original Method ----------
            //if (mContentView != null) {
                //mContentView.setTranslationY(0);
                //mContainerView.setTranslationY(0);
            //}
            //if (mSplitView != null && mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
                //mSplitView.setVisibility(View.GONE);
            //}
            //mContainerView.setVisibility(View.GONE);
            //mContainerView.setTransitioning(false);
            //mCurrentShowAnim = null;
            //completeDeferredDestroyActionMode();
        }

        
}; //Transformed anonymous class
    final AnimatorListener mShowListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.888 -0400", hash_original_method = "CA861A0A44A2878B5B0D20FC92104D63", hash_generated_method = "7053464758544E202CFF55E2A58AFC46")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mCurrentShowAnim = null;
            mContainerView.requestLayout();
            // ---------- Original Method ----------
            //mCurrentShowAnim = null;
            //mContainerView.requestLayout();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.888 -0400", hash_original_method = "59F98BFDF3B79CD734A4E0F1D5C36E49", hash_generated_method = "82CF13281EB592411AAEE0B4B37A84E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarImpl(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Window window;
        window = activity.getWindow();
        View decor;
        decor = window.getDecorView();
        init(decor);
        {
            boolean var95A05EC5BBC3BEEE196E68366EEE801B_755286898 = (!mActivity.getWindow().hasFeature(Window.FEATURE_ACTION_BAR_OVERLAY));
            {
                mContentView = decor.findViewById(android.R.id.content);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mActivity = activity;
        //Window window = activity.getWindow();
        //View decor = window.getDecorView();
        //init(decor);
        //if (!mActivity.getWindow().hasFeature(Window.FEATURE_ACTION_BAR_OVERLAY)) {
            //mContentView = decor.findViewById(android.R.id.content);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.889 -0400", hash_original_method = "8749FCFE1A7B0A0EC82F09729A7EA1FF", hash_generated_method = "E3F8DD33EFF499DD17DBD6565F529F03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarImpl(Dialog dialog) {
        dsTaint.addTaint(dialog.dsTaint);
        init(dialog.getWindow().getDecorView());
        // ---------- Original Method ----------
        //mDialog = dialog;
        //init(dialog.getWindow().getDecorView());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.889 -0400", hash_original_method = "CD1B24EA492A78A5E57A77E5FDC89AEF", hash_generated_method = "0B2A56B67B37FD93E78EAF394FDF7765")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(View decor) {
        dsTaint.addTaint(decor.dsTaint);
        mContext = decor.getContext();
        mActionView = (ActionBarView) decor.findViewById(com.android.internal.R.id.action_bar);
        mContextView = (ActionBarContextView) decor.findViewById(
                com.android.internal.R.id.action_context_bar);
        mContainerView = (ActionBarContainer) decor.findViewById(
                com.android.internal.R.id.action_bar_container);
        mSplitView = (ActionBarContainer) decor.findViewById(
                com.android.internal.R.id.split_action_bar);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with a compatible window decor layout");
        } //End block
        mActionView.setContextView(mContextView);
        mContextDisplayMode = mActionView.isSplitActionBar() ?
                CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL;
        setHomeButtonEnabled(mContext.getApplicationInfo().targetSdkVersion <
                Build.VERSION_CODES.ICE_CREAM_SANDWICH);
        setHasEmbeddedTabs(mContext.getResources().getBoolean(
                com.android.internal.R.bool.action_bar_embed_tabs));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.890 -0400", hash_original_method = "988D25E4BF24BB800BD6556DCD183591", hash_generated_method = "C37C3753FF477D78CBDBC79E6D77DBCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        setHasEmbeddedTabs(mContext.getResources().getBoolean(
                com.android.internal.R.bool.action_bar_embed_tabs));
        // ---------- Original Method ----------
        //setHasEmbeddedTabs(mContext.getResources().getBoolean(
                //com.android.internal.R.bool.action_bar_embed_tabs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.890 -0400", hash_original_method = "05911004B37CFCA0E1E3075964BC3E46", hash_generated_method = "833AC35AAF3C1103057FE9FA50AAA3A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setHasEmbeddedTabs(boolean hasEmbeddedTabs) {
        dsTaint.addTaint(hasEmbeddedTabs);
        {
            mActionView.setEmbeddedTabView(null);
            mContainerView.setTabContainer(mTabScrollView);
        } //End block
        {
            mContainerView.setTabContainer(null);
            mActionView.setEmbeddedTabView(mTabScrollView);
        } //End block
        boolean isInTabMode;
        isInTabMode = getNavigationMode() == NAVIGATION_MODE_TABS;
        {
            mTabScrollView.setVisibility(isInTabMode ? View.VISIBLE : View.GONE);
        } //End block
        mActionView.setCollapsable(!mHasEmbeddedTabs && isInTabMode);
        // ---------- Original Method ----------
        //mHasEmbeddedTabs = hasEmbeddedTabs;
        //if (!mHasEmbeddedTabs) {
            //mActionView.setEmbeddedTabView(null);
            //mContainerView.setTabContainer(mTabScrollView);
        //} else {
            //mContainerView.setTabContainer(null);
            //mActionView.setEmbeddedTabView(mTabScrollView);
        //}
        //final boolean isInTabMode = getNavigationMode() == NAVIGATION_MODE_TABS;
        //if (mTabScrollView != null) {
            //mTabScrollView.setVisibility(isInTabMode ? View.VISIBLE : View.GONE);
        //}
        //mActionView.setCollapsable(!mHasEmbeddedTabs && isInTabMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.890 -0400", hash_original_method = "04F31515B176FCA9797E5A3B1AE2D925", hash_generated_method = "EE560EFCD2D03DA47191BFAD6BFF74A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureTabsExist() {
        ScrollingTabContainerView tabScroller;
        tabScroller = new ScrollingTabContainerView(mContext);
        {
            tabScroller.setVisibility(View.VISIBLE);
            mActionView.setEmbeddedTabView(tabScroller);
        } //End block
        {
            tabScroller.setVisibility(getNavigationMode() == NAVIGATION_MODE_TABS ?
                    View.VISIBLE : View.GONE);
            mContainerView.setTabContainer(tabScroller);
        } //End block
        mTabScrollView = tabScroller;
        // ---------- Original Method ----------
        //if (mTabScrollView != null) {
            //return;
        //}
        //ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(mContext);
        //if (mHasEmbeddedTabs) {
            //tabScroller.setVisibility(View.VISIBLE);
            //mActionView.setEmbeddedTabView(tabScroller);
        //} else {
            //tabScroller.setVisibility(getNavigationMode() == NAVIGATION_MODE_TABS ?
                    //View.VISIBLE : View.GONE);
            //mContainerView.setTabContainer(tabScroller);
        //}
        //mTabScrollView = tabScroller;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.891 -0400", hash_original_method = "FB60553060C0CBA07AA4AE6F5834D888", hash_generated_method = "F6E44B1CBFFEFB4CAE23BC4F3A6C11A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void completeDeferredDestroyActionMode() {
        {
            mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
            mDeferredDestroyActionMode = null;
            mDeferredModeDestroyCallback = null;
        } //End block
        // ---------- Original Method ----------
        //if (mDeferredModeDestroyCallback != null) {
            //mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
            //mDeferredDestroyActionMode = null;
            //mDeferredModeDestroyCallback = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.891 -0400", hash_original_method = "F176835B5C4C66FE158A96087EB7976E", hash_generated_method = "7E7904715D84D6FB409CEFFA7F65C0AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShowHideAnimationEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            mCurrentShowAnim.end();
        } //End block
        // ---------- Original Method ----------
        //mShowHideAnimationEnabled = enabled;
        //if (!enabled && mCurrentShowAnim != null) {
            //mCurrentShowAnim.end();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.891 -0400", hash_original_method = "432643F5D3E1C75318DA649F07995AE5", hash_generated_method = "85DCCA072ACF0C7EBBFA31A521DCB904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mMenuVisibilityListeners.add(listener);
        // ---------- Original Method ----------
        //mMenuVisibilityListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.892 -0400", hash_original_method = "602CC871D8636269B09601DAE53B0892", hash_generated_method = "A96B1817B977EB335AA4343A7ADC6C18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mMenuVisibilityListeners.remove(listener);
        // ---------- Original Method ----------
        //mMenuVisibilityListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.892 -0400", hash_original_method = "459C6E3BA33A1A612E205065B1C3E1DC", hash_generated_method = "1ECBA59F70FC26D597311FACABECFAF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        dsTaint.addTaint(isVisible);
        int count;
        count = mMenuVisibilityListeners.size();
        {
            int i;
            i = 0;
            {
                mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(isVisible);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isVisible == mLastMenuVisibility) {
            //return;
        //}
        //mLastMenuVisibility = isVisible;
        //final int count = mMenuVisibilityListeners.size();
        //for (int i = 0; i < count; i++) {
            //mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(isVisible);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.892 -0400", hash_original_method = "B07E8854D08E9349BCA465572774AD05", hash_generated_method = "5CA196FFFD186A4C7D52C0E64D32FA5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setCustomView(int resId) {
        dsTaint.addTaint(resId);
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
        // ---------- Original Method ----------
        //setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.892 -0400", hash_original_method = "7B32C43910C34545BE6AF1945BAD78C2", hash_generated_method = "A361F7D7D7B8EF33927DD254B1A6C1FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        dsTaint.addTaint(useLogo);
        setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
        // ---------- Original Method ----------
        //setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.893 -0400", hash_original_method = "7F0843FA34DCBF9EB20E04642D9BA553", hash_generated_method = "4809D9EDBD2D531F71624D26FECC222D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        dsTaint.addTaint(showHome);
        setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
        // ---------- Original Method ----------
        //setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.893 -0400", hash_original_method = "F859D1EA93554E58B56470BC246367BB", hash_generated_method = "477DF670BC74CE065875D1B8099814CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        dsTaint.addTaint(showHomeAsUp);
        setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
        // ---------- Original Method ----------
        //setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.893 -0400", hash_original_method = "6C96766F23C0B7039876B0F0E23B9AFF", hash_generated_method = "103174FF55A1342E4B8C998A8A8984F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        dsTaint.addTaint(showTitle);
        setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
        // ---------- Original Method ----------
        //setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.893 -0400", hash_original_method = "C60EF70FF87399C557FC41651D29083C", hash_generated_method = "F67037765CD5A96CE08A883B0ABDB2E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        dsTaint.addTaint(showCustom);
        setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
        // ---------- Original Method ----------
        //setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.894 -0400", hash_original_method = "4D222159BA92CC275B5D5CB9ADE89E45", hash_generated_method = "BB5C7FF62CC8BB9D568A9753ADB679F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setHomeButtonEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        mActionView.setHomeButtonEnabled(enable);
        // ---------- Original Method ----------
        //mActionView.setHomeButtonEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.895 -0400", hash_original_method = "93A6ED10F8DC44A47D2A5E40CE348C6E", hash_generated_method = "D1ABB06A1C75B7D692BB733D09B600C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTitle(int resId) {
        dsTaint.addTaint(resId);
        setTitle(mContext.getString(resId));
        // ---------- Original Method ----------
        //setTitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.895 -0400", hash_original_method = "28BA950963DD65E7A01A305F037657F9", hash_generated_method = "7856E9689BEFE7E17C7A75EE31F088B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSubtitle(int resId) {
        dsTaint.addTaint(resId);
        setSubtitle(mContext.getString(resId));
        // ---------- Original Method ----------
        //setSubtitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.896 -0400", hash_original_method = "11EA30EC8C9A94D19D07ED1EA15B77B1", hash_generated_method = "526C3B7D77961F522E0E74C17BCF430E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelectedNavigationItem(int position) {
        dsTaint.addTaint(position);
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_343016279 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            selectTab(mTabs.get(position));
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            mActionView.setDropdownSelectedPosition(position);
            //End case NAVIGATION_MODE_LIST 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "setSelectedNavigationIndex not valid for current navigation mode");
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //switch (mActionView.getNavigationMode()) {
        //case NAVIGATION_MODE_TABS:
            //selectTab(mTabs.get(position));
            //break;
        //case NAVIGATION_MODE_LIST:
            //mActionView.setDropdownSelectedPosition(position);
            //break;
        //default:
            //throw new IllegalStateException(
                    //"setSelectedNavigationIndex not valid for current navigation mode");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.896 -0400", hash_original_method = "B97B28074DE5FCD367C21E021091BD45", hash_generated_method = "18F3DD1B438293814EC931E00EFDC066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllTabs() {
        cleanupTabs();
        // ---------- Original Method ----------
        //cleanupTabs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.896 -0400", hash_original_method = "62AE76DE88CDD8F4A1D9D70F05364203", hash_generated_method = "2876F52F172304588585ECF93C6BA287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cleanupTabs() {
        {
            selectTab(null);
        } //End block
        mTabs.clear();
        {
            mTabScrollView.removeAllTabs();
        } //End block
        mSavedTabPosition = INVALID_POSITION;
        // ---------- Original Method ----------
        //if (mSelectedTab != null) {
            //selectTab(null);
        //}
        //mTabs.clear();
        //if (mTabScrollView != null) {
            //mTabScrollView.removeAllTabs();
        //}
        //mSavedTabPosition = INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.896 -0400", hash_original_method = "2496AA6E0C686AA709C048B4D9A978B1", hash_generated_method = "205B1E59D942EC23586BF13EFA172954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mActionView.setTitle(title);
        // ---------- Original Method ----------
        //mActionView.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.896 -0400", hash_original_method = "51EFE4022329006F8B97012193639D8C", hash_generated_method = "8798E0056DD042C46C03EC8D820906F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubtitle(CharSequence subtitle) {
        dsTaint.addTaint(subtitle);
        mActionView.setSubtitle(subtitle);
        // ---------- Original Method ----------
        //mActionView.setSubtitle(subtitle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.897 -0400", hash_original_method = "3F11889B61BC98E428CD1B2A494BFC53", hash_generated_method = "150B9081FD08E133113C076549D15515")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDisplayOptions(int options) {
        dsTaint.addTaint(options);
        mActionView.setDisplayOptions(options);
        // ---------- Original Method ----------
        //mActionView.setDisplayOptions(options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.897 -0400", hash_original_method = "728BC8FE52686E77081ACD4BE860295D", hash_generated_method = "99008D8CA35DD3AB3EB10AB709D1F982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDisplayOptions(int options, int mask) {
        dsTaint.addTaint(mask);
        dsTaint.addTaint(options);
        int current;
        current = mActionView.getDisplayOptions();
        mActionView.setDisplayOptions((options & mask) | (current & ~mask));
        // ---------- Original Method ----------
        //final int current = mActionView.getDisplayOptions();
        //mActionView.setDisplayOptions((options & mask) | (current & ~mask));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.897 -0400", hash_original_method = "61B3599899498272F50206755C75E2FF", hash_generated_method = "2DED8656144AFF255537336D5F2C291F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        mContainerView.setPrimaryBackground(d);
        // ---------- Original Method ----------
        //mContainerView.setPrimaryBackground(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.897 -0400", hash_original_method = "71E64D08C4AF72E9E040B3394527D26B", hash_generated_method = "07ED27DA3E697D5BC1428B2AFCD98F90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStackedBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        mContainerView.setStackedBackground(d);
        // ---------- Original Method ----------
        //mContainerView.setStackedBackground(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.897 -0400", hash_original_method = "228BA16930C30CB95A53923FA275FB3B", hash_generated_method = "C6DAD5865375776F83D58FA7717523D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSplitBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        {
            mSplitView.setSplitBackground(d);
        } //End block
        // ---------- Original Method ----------
        //if (mSplitView != null) {
            //mSplitView.setSplitBackground(d);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.898 -0400", hash_original_method = "1D010261269A6D78FBB7E8684C141376", hash_generated_method = "FBA9E050165CA705B1D93D6551F161A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getCustomView() {
        View var63A4410BAFC226D1557535FE92D83B75_1340767228 = (mActionView.getCustomNavigationView());
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActionView.getCustomNavigationView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.898 -0400", hash_original_method = "2440C8680C5986DA6B98061A5444C3DF", hash_generated_method = "89998FD4188E2EF850BB69C518495054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTitle() {
        CharSequence var3E1FFB55D6CD6E3E017B909355FE2AFA_131870427 = (mActionView.getTitle());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActionView.getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.898 -0400", hash_original_method = "7C309AA3715DBCB025C148B6DD4FF98A", hash_generated_method = "628330B4390BD16F9DC1C954895923BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getSubtitle() {
        CharSequence var6386D2A981DD4D2EB12AAC1A3849EB77_576529883 = (mActionView.getSubtitle());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActionView.getSubtitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.898 -0400", hash_original_method = "3CF23CB733C1A66BA695174D1D5C90F5", hash_generated_method = "D50CAD8C48345A6EBD36916EAD3D922A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNavigationMode() {
        int varEAA142AE97CC923611CFEB4857969BEA_1491497268 = (mActionView.getNavigationMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActionView.getNavigationMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.898 -0400", hash_original_method = "FB6F75E61CAD1294F319FE9A20EDC0AA", hash_generated_method = "AA4E5D20AC0D061CDE712B8865A5E9C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDisplayOptions() {
        int var0A196B6A925A1050E71EDF1CA21BAA1C_1458994573 = (mActionView.getDisplayOptions());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActionView.getDisplayOptions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.899 -0400", hash_original_method = "6F680EB91F7327296F43077A9CFCB9CD", hash_generated_method = "39FCDD52B9CB8706EF9DBBBE3B96E0D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionMode(ActionMode.Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        boolean wasHidden;
        wasHidden = false;
        {
            wasHidden = mWasHiddenBeforeMode;
            mActionMode.finish();
        } //End block
        mContextView.killMode();
        ActionModeImpl mode;
        mode = new ActionModeImpl(callback);
        {
            boolean var2B92093546C2716C766BC5924D507852_1891517419 = (mode.dispatchOnCreate());
            {
                mWasHiddenBeforeMode = !isShowing() || wasHidden;
                mode.invalidate();
                mContextView.initForMode(mode);
                animateToMode(true);
                {
                    mSplitView.setVisibility(View.VISIBLE);
                } //End block
                mContextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
                mActionMode = mode;
            } //End block
        } //End collapsed parenthetic
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //boolean wasHidden = false;
        //if (mActionMode != null) {
            //wasHidden = mWasHiddenBeforeMode;
            //mActionMode.finish();
        //}
        //mContextView.killMode();
        //ActionModeImpl mode = new ActionModeImpl(callback);
        //if (mode.dispatchOnCreate()) {
            //mWasHiddenBeforeMode = !isShowing() || wasHidden;
            //mode.invalidate();
            //mContextView.initForMode(mode);
            //animateToMode(true);
            //if (mSplitView != null && mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
                //mSplitView.setVisibility(View.VISIBLE);
            //}
            //mContextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            //mActionMode = mode;
            //return mode;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.899 -0400", hash_original_method = "4981E6F1136ACFE06B622EFDD1F32611", hash_generated_method = "A2E0F2053339575B8BECE50BC6669286")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void configureTab(Tab tab, int position) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        TabImpl tabi;
        tabi = (TabImpl) tab;
        ActionBar.TabListener callback;
        callback = tabi.getCallback();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Action Bar Tab must have a Callback");
        } //End block
        tabi.setPosition(position);
        mTabs.add(position, tabi);
        int count;
        count = mTabs.size();
        {
            int i;
            i = position + 1;
            {
                mTabs.get(i).setPosition(i);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final TabImpl tabi = (TabImpl) tab;
        //final ActionBar.TabListener callback = tabi.getCallback();
        //if (callback == null) {
            //throw new IllegalStateException("Action Bar Tab must have a Callback");
        //}
        //tabi.setPosition(position);
        //mTabs.add(position, tabi);
        //final int count = mTabs.size();
        //for (int i = position + 1; i < count; i++) {
            //mTabs.get(i).setPosition(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.899 -0400", hash_original_method = "1EECF05398B0BE8AB00F4615B5278612", hash_generated_method = "E121B9862421D22E2347F869AEF0CD3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTab(Tab tab) {
        dsTaint.addTaint(tab.dsTaint);
        addTab(tab, mTabs.isEmpty());
        // ---------- Original Method ----------
        //addTab(tab, mTabs.isEmpty());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.899 -0400", hash_original_method = "654B3E709639F944F902BA5D9B821C89", hash_generated_method = "42781F96798C49EC5336480DF5002970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTab(Tab tab, int position) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        addTab(tab, position, mTabs.isEmpty());
        // ---------- Original Method ----------
        //addTab(tab, position, mTabs.isEmpty());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.900 -0400", hash_original_method = "89408631A5DFBB8696DA15288AA15329", hash_generated_method = "1E2457B1BE8E83716A0CC7D2339E7CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTab(Tab tab, boolean setSelected) {
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(setSelected);
        ensureTabsExist();
        mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, mTabs.size());
        {
            selectTab(tab);
        } //End block
        // ---------- Original Method ----------
        //ensureTabsExist();
        //mTabScrollView.addTab(tab, setSelected);
        //configureTab(tab, mTabs.size());
        //if (setSelected) {
            //selectTab(tab);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.900 -0400", hash_original_method = "041C4C5A1F00C6CFE52123DF1D5CFA62", hash_generated_method = "D75E0659990BA100305106554614134C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(setSelected);
        ensureTabsExist();
        mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        {
            selectTab(tab);
        } //End block
        // ---------- Original Method ----------
        //ensureTabsExist();
        //mTabScrollView.addTab(tab, position, setSelected);
        //configureTab(tab, position);
        //if (setSelected) {
            //selectTab(tab);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.900 -0400", hash_original_method = "086373AB3E22E85AEE50C2F735BD106D", hash_generated_method = "A2014ECE193F1BD0A0BC9DD51561097B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Tab newTab() {
        Tab var0C6B733558DD8328F4B67280AFEF2A28_1895565674 = (new TabImpl());
        return (Tab)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new TabImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.900 -0400", hash_original_method = "D97BFE7F24375737332EF4EB210BF330", hash_generated_method = "E98B0DC133B991C62229846B79DB6B5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeTab(Tab tab) {
        dsTaint.addTaint(tab.dsTaint);
        removeTabAt(tab.getPosition());
        // ---------- Original Method ----------
        //removeTabAt(tab.getPosition());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.901 -0400", hash_original_method = "B3645E4F4AB7E9BBDE0315AEF0157D54", hash_generated_method = "81E976612B39EEDF07B2E0B2A02D0FBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeTabAt(int position) {
        dsTaint.addTaint(position);
        int selectedTabPosition;
        selectedTabPosition = mSelectedTab.getPosition();
        selectedTabPosition = mSavedTabPosition;
        mTabScrollView.removeTabAt(position);
        TabImpl removedTab;
        removedTab = mTabs.remove(position);
        {
            removedTab.setPosition(-1);
        } //End block
        int newTabCount;
        newTabCount = mTabs.size();
        {
            int i;
            i = position;
            {
                mTabs.get(i).setPosition(i);
            } //End block
        } //End collapsed parenthetic
        {
            selectTab(mTabs.isEmpty() ? null : mTabs.get(Math.max(0, position - 1)));
        } //End block
        // ---------- Original Method ----------
        //if (mTabScrollView == null) {
            //return;
        //}
        //int selectedTabPosition = mSelectedTab != null
                //? mSelectedTab.getPosition() : mSavedTabPosition;
        //mTabScrollView.removeTabAt(position);
        //TabImpl removedTab = mTabs.remove(position);
        //if (removedTab != null) {
            //removedTab.setPosition(-1);
        //}
        //final int newTabCount = mTabs.size();
        //for (int i = position; i < newTabCount; i++) {
            //mTabs.get(i).setPosition(i);
        //}
        //if (selectedTabPosition == position) {
            //selectTab(mTabs.isEmpty() ? null : mTabs.get(Math.max(0, position - 1)));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.901 -0400", hash_original_method = "08E647315276EA6EFD361EFCDF66D68C", hash_generated_method = "6995975C0A3C4C56833B50B1AA28FCBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void selectTab(Tab tab) {
        dsTaint.addTaint(tab.dsTaint);
        {
            boolean var0D865F05ACCA97EEC09A4D554FCE6944_127267657 = (getNavigationMode() != NAVIGATION_MODE_TABS);
            {
                mSavedTabPosition = tab != null ? tab.getPosition() : INVALID_POSITION;
            } //End block
        } //End collapsed parenthetic
        FragmentTransaction trans;
        trans = mActivity.getFragmentManager().beginTransaction()
                .disallowAddToBackStack();
        {
            {
                mSelectedTab.getCallback().onTabReselected(mSelectedTab, trans);
                mTabScrollView.animateToTab(tab.getPosition());
            } //End block
        } //End block
        {
            mTabScrollView.setTabSelected(tab != null ? tab.getPosition() : Tab.INVALID_POSITION);
            {
                mSelectedTab.getCallback().onTabUnselected(mSelectedTab, trans);
            } //End block
            mSelectedTab = (TabImpl) tab;
            {
                mSelectedTab.getCallback().onTabSelected(mSelectedTab, trans);
            } //End block
        } //End block
        {
            boolean var0609B2E91FA97D998D43ECA1A4058103_1166887730 = (!trans.isEmpty());
            {
                trans.commit();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.901 -0400", hash_original_method = "2AD2D5B38A8D730799170A69D020CCD7", hash_generated_method = "BA4CDDD9AD1C2FC0D3F430DB5BF1F476")
    @DSModeled(DSC.SAFE)
    @Override
    public Tab getSelectedTab() {
        return (Tab)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSelectedTab;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.901 -0400", hash_original_method = "7329EA59D7EBE41DA23E0A3E55EEA1A2", hash_generated_method = "304C938795D68587FE545441E2649A66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getHeight() {
        int varB6E80F54C86C59EC88E3A5A42628443F_614811707 = (mContainerView.getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContainerView.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.902 -0400", hash_original_method = "546A4715540EEE6F49A6EAAEA56C241C", hash_generated_method = "9B6F5E1BBF9ED1EA79DF35779E1A9F3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void show() {
        show(true);
        // ---------- Original Method ----------
        //show(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.902 -0400", hash_original_method = "B9AB02E6F73BE3423F7A7521B424A639", hash_generated_method = "81C90B557C9F29ECFC3814FE4EF9A1A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void show(boolean markHiddenBeforeMode) {
        dsTaint.addTaint(markHiddenBeforeMode);
        {
            mCurrentShowAnim.end();
        } //End block
        {
            boolean varA04FE79F70596AEDDC366BB1F9C953E0_29500308 = (mContainerView.getVisibility() == View.VISIBLE);
            {
                mWasHiddenBeforeMode = false;
            } //End block
        } //End collapsed parenthetic
        mContainerView.setVisibility(View.VISIBLE);
        {
            mContainerView.setAlpha(0);
            AnimatorSet anim;
            anim = new AnimatorSet();
            AnimatorSet.Builder b;
            b = anim.play(ObjectAnimator.ofFloat(mContainerView, "alpha", 1));
            {
                b.with(ObjectAnimator.ofFloat(mContentView, "translationY",
                        -mContainerView.getHeight(), 0));
                mContainerView.setTranslationY(-mContainerView.getHeight());
                b.with(ObjectAnimator.ofFloat(mContainerView, "translationY", 0));
            } //End block
            {
                mSplitView.setAlpha(0);
                mSplitView.setVisibility(View.VISIBLE);
                b.with(ObjectAnimator.ofFloat(mSplitView, "alpha", 1));
            } //End block
            anim.addListener(mShowListener);
            mCurrentShowAnim = anim;
            anim.start();
        } //End block
        {
            mContainerView.setAlpha(1);
            mContainerView.setTranslationY(0);
            mShowListener.onAnimationEnd(null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.902 -0400", hash_original_method = "F98E692B5353704914249A64080F4E16", hash_generated_method = "50B667FB037B017CED6010EB733196C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void hide() {
        {
            mCurrentShowAnim.end();
        } //End block
        {
            boolean varADDBB77A9CB269D2E537C6D87A9B8737_71207703 = (mContainerView.getVisibility() == View.GONE);
        } //End collapsed parenthetic
        {
            mContainerView.setAlpha(1);
            mContainerView.setTransitioning(true);
            AnimatorSet anim;
            anim = new AnimatorSet();
            AnimatorSet.Builder b;
            b = anim.play(ObjectAnimator.ofFloat(mContainerView, "alpha", 0));
            {
                b.with(ObjectAnimator.ofFloat(mContentView, "translationY",
                        0, -mContainerView.getHeight()));
                b.with(ObjectAnimator.ofFloat(mContainerView, "translationY",
                        -mContainerView.getHeight()));
            } //End block
            {
                boolean varF225B1267295DB8E06979CA78868E507_2101896371 = (mSplitView != null && mSplitView.getVisibility() == View.VISIBLE);
                {
                    mSplitView.setAlpha(1);
                    b.with(ObjectAnimator.ofFloat(mSplitView, "alpha", 0));
                } //End block
            } //End collapsed parenthetic
            anim.addListener(mHideListener);
            mCurrentShowAnim = anim;
            anim.start();
        } //End block
        {
            mHideListener.onAnimationEnd(null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.903 -0400", hash_original_method = "02F75CA35AA01FBE52A717B38FA758F7", hash_generated_method = "587569ABEC767528D23AA4824A4EAFC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShowing() {
        boolean varFABAF10FC87FB52E607ED88B31859D35_942230672 = (mContainerView.getVisibility() == View.VISIBLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mContainerView.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.903 -0400", hash_original_method = "6F997D5B2915B28943A5CB4BD830D4B2", hash_generated_method = "E38D9C76296DDE2D17330C370E7E80F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void animateToMode(boolean toActionMode) {
        dsTaint.addTaint(toActionMode);
        {
            show(false);
        } //End block
        {
            mCurrentModeAnim.end();
        } //End block
        mActionView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
        mContextView.animateToVisibility(toActionMode ? View.VISIBLE : View.GONE);
        {
            boolean varFBD93DC9D1D6299B253C2D05796D3D2B_810513131 = (mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed());
            {
                mTabScrollView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (toActionMode) {
            //show(false);
        //}
        //if (mCurrentModeAnim != null) {
            //mCurrentModeAnim.end();
        //}
        //mActionView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
        //mContextView.animateToVisibility(toActionMode ? View.VISIBLE : View.GONE);
        //if (mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed()) {
            //mTabScrollView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.903 -0400", hash_original_method = "3EA212821B302B1822414F8223429D93", hash_generated_method = "DAAA1CF808987F81D6C100722217D63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getThemedContext() {
        {
            TypedValue outValue;
            outValue = new TypedValue();
            Resources.Theme currentTheme;
            currentTheme = mContext.getTheme();
            currentTheme.resolveAttribute(com.android.internal.R.attr.actionBarWidgetTheme,
                    outValue, true);
            int targetThemeRes;
            targetThemeRes = outValue.resourceId;
            {
                boolean varDD6A9FFA4382518FE4FB51366D933575_1690203945 = (targetThemeRes != 0 && mContext.getThemeResId() != targetThemeRes);
                {
                    mThemedContext = new ContextThemeWrapper(mContext, targetThemeRes);
                } //End block
                {
                    mThemedContext = mContext;
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mThemedContext == null) {
            //TypedValue outValue = new TypedValue();
            //Resources.Theme currentTheme = mContext.getTheme();
            //currentTheme.resolveAttribute(com.android.internal.R.attr.actionBarWidgetTheme,
                    //outValue, true);
            //final int targetThemeRes = outValue.resourceId;
            //if (targetThemeRes != 0 && mContext.getThemeResId() != targetThemeRes) {
                //mThemedContext = new ContextThemeWrapper(mContext, targetThemeRes);
            //} else {
                //mThemedContext = mContext;
            //}
        //}
        //return mThemedContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.904 -0400", hash_original_method = "82CB01F3A317C5518DAD7B810C7481F9", hash_generated_method = "48D649F7DA2988157561702B2D223AA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setCustomView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mActionView.setCustomNavigationView(view);
        // ---------- Original Method ----------
        //mActionView.setCustomNavigationView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.904 -0400", hash_original_method = "D405B9340EEDF523A821CB828A77247A", hash_generated_method = "9676191D3ACC1DE8DC28E33D61085507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setCustomView(View view, LayoutParams layoutParams) {
        dsTaint.addTaint(layoutParams.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        view.setLayoutParams(layoutParams);
        mActionView.setCustomNavigationView(view);
        // ---------- Original Method ----------
        //view.setLayoutParams(layoutParams);
        //mActionView.setCustomNavigationView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.904 -0400", hash_original_method = "DE3A042A48DE08AEC88EC1C0AD695D6F", hash_generated_method = "7113141F8A71632AE4E7FB02678F1566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(adapter.dsTaint);
        mActionView.setDropdownAdapter(adapter);
        mActionView.setCallback(callback);
        // ---------- Original Method ----------
        //mActionView.setDropdownAdapter(adapter);
        //mActionView.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.904 -0400", hash_original_method = "DA5FE7663B58F3C2464F93A06566CD8E", hash_generated_method = "F5499C6AA0779ABA686DEBFD9834B4F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSelectedNavigationIndex() {
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_988338793 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            {
                Object var9E0D618A4EE8CC879C5AC350775986E3_1460872226 = (mSelectedTab.getPosition());
            } //End flattened ternary
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            int var0DAE3350C64D0906A58D53288479EA2D_1619104603 = (mActionView.getDropdownSelectedPosition());
            //End case NAVIGATION_MODE_LIST 
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (mActionView.getNavigationMode()) {
            //case NAVIGATION_MODE_TABS:
                //return mSelectedTab != null ? mSelectedTab.getPosition() : -1;
            //case NAVIGATION_MODE_LIST:
                //return mActionView.getDropdownSelectedPosition();
            //default:
                //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.905 -0400", hash_original_method = "29C3EDF1B0696DD606C19CEF5DFCB27A", hash_generated_method = "75301D813C072368A72BED92A4645FEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getNavigationItemCount() {
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_1662080246 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            int var81340BC1C620E3820A05E23DEE8223AF_2129597935 = (mTabs.size());
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            SpinnerAdapter adapter;
            adapter = mActionView.getDropdownAdapter();
            //End case NAVIGATION_MODE_LIST 
            //Begin case NAVIGATION_MODE_LIST 
            {
                Object varF7742EA74032E62C939C320B7B8C4E62_60266634 = (adapter.getCount());
            } //End flattened ternary
            //End case NAVIGATION_MODE_LIST 
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (mActionView.getNavigationMode()) {
            //case NAVIGATION_MODE_TABS:
                //return mTabs.size();
            //case NAVIGATION_MODE_LIST:
                //SpinnerAdapter adapter = mActionView.getDropdownAdapter();
                //return adapter != null ? adapter.getCount() : 0;
            //default:
                //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.905 -0400", hash_original_method = "44E873137D601CC44196E7945B5F3744", hash_generated_method = "5D35553BD31F84072B6A72487F3C16F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getTabCount() {
        int varA0AA69837201731921DCB8C161D1B5BD_1846981727 = (mTabs.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTabs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.905 -0400", hash_original_method = "2CF769A940AAC419EB99620655E4C93A", hash_generated_method = "F7AA220DD0A6813A92DF28B949BDB35F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNavigationMode(int mode) {
        dsTaint.addTaint(mode);
        int oldMode;
        oldMode = mActionView.getNavigationMode();
        //Begin case NAVIGATION_MODE_TABS 
        mSavedTabPosition = getSelectedNavigationIndex();
        //End case NAVIGATION_MODE_TABS 
        //Begin case NAVIGATION_MODE_TABS 
        selectTab(null);
        //End case NAVIGATION_MODE_TABS 
        //Begin case NAVIGATION_MODE_TABS 
        mTabScrollView.setVisibility(View.GONE);
        //End case NAVIGATION_MODE_TABS 
        mActionView.setNavigationMode(mode);
        //Begin case NAVIGATION_MODE_TABS 
        ensureTabsExist();
        //End case NAVIGATION_MODE_TABS 
        //Begin case NAVIGATION_MODE_TABS 
        mTabScrollView.setVisibility(View.VISIBLE);
        //End case NAVIGATION_MODE_TABS 
        //Begin case NAVIGATION_MODE_TABS 
        {
            setSelectedNavigationItem(mSavedTabPosition);
            mSavedTabPosition = INVALID_POSITION;
        } //End block
        //End case NAVIGATION_MODE_TABS 
        mActionView.setCollapsable(mode == NAVIGATION_MODE_TABS && !mHasEmbeddedTabs);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.905 -0400", hash_original_method = "389BF0B1EF97627FAF399E95ED0D1079", hash_generated_method = "8795E05CAEFEECA550C1618CD16FFDE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Tab getTabAt(int index) {
        dsTaint.addTaint(index);
        Tab varB7E13A6D717ABD72B52ABD6601F96C76_1955803552 = (mTabs.get(index));
        return (Tab)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTabs.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.905 -0400", hash_original_method = "246181C3E410F19AA68D711311C45E89", hash_generated_method = "154F75905AD3B73D60CAA83EC79B1B19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setIcon(int resId) {
        dsTaint.addTaint(resId);
        mActionView.setIcon(resId);
        // ---------- Original Method ----------
        //mActionView.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.906 -0400", hash_original_method = "976AFC7A654132AA465D788A8B684BD0", hash_generated_method = "2C1DB674C62358D0E4DDDD7D33EEDBE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mActionView.setIcon(icon);
        // ---------- Original Method ----------
        //mActionView.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.906 -0400", hash_original_method = "629A6907FC2030BF835EC3846EE4C4B9", hash_generated_method = "A91920B951C387F7633A34D4DA2C2DDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setLogo(int resId) {
        dsTaint.addTaint(resId);
        mActionView.setLogo(resId);
        // ---------- Original Method ----------
        //mActionView.setLogo(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.906 -0400", hash_original_method = "563E995ECF1A81A300841064D1D1EC89", hash_generated_method = "F1951A6A2888A33D941EEA82BE56FF22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setLogo(Drawable logo) {
        dsTaint.addTaint(logo.dsTaint);
        mActionView.setLogo(logo);
        // ---------- Original Method ----------
        //mActionView.setLogo(logo);
    }

    
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        private MenuBuilder mMenu;
        private WeakReference<View> mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.906 -0400", hash_original_method = "329ADB94B68F012647BA8B5F412D446E", hash_generated_method = "5810DAA861C503685050DBEFC5C970BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ActionModeImpl(ActionMode.Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            mMenu = new MenuBuilder(getThemedContext())
                    .setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            mMenu.setCallback(this);
            // ---------- Original Method ----------
            //mCallback = callback;
            //mMenu = new MenuBuilder(getThemedContext())
                    //.setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            //mMenu.setCallback(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.906 -0400", hash_original_method = "51A0980A38EB9FD2F0CEA8B2697D7721", hash_generated_method = "95196AF4F6131B879E8ED5D014E0FCB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public MenuInflater getMenuInflater() {
            MenuInflater varF9B66260E46C1B7864ADC7C530140DAE_475963129 = (new MenuInflater(getThemedContext()));
            return (MenuInflater)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MenuInflater(getThemedContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.906 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "86A6A00CD1F7DBD5751DEFC4177523B8")
        @DSModeled(DSC.SAFE)
        @Override
        public Menu getMenu() {
            return (Menu)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMenu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.913 -0400", hash_original_method = "55BDAC29AF3CEA463BE5A1AC1715A820", hash_generated_method = "33E2414AC5B8AD4C759153ED4898A4C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void finish() {
            {
                boolean var830761C64F0699CF4AD2D4B7B4D7E08E_1176764243 = (mActionMode != this);
            } //End collapsed parenthetic
            {
                mDeferredDestroyActionMode = this;
                mDeferredModeDestroyCallback = mCallback;
            } //End block
            {
                mCallback.onDestroyActionMode(this);
            } //End block
            mCallback = null;
            animateToMode(false);
            mContextView.closeMode();
            mActionView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            mActionMode = null;
            {
                hide();
            } //End block
            // ---------- Original Method ----------
            //if (mActionMode != this) {
                //return;
            //}
            //if (mWasHiddenBeforeMode) {
                //mDeferredDestroyActionMode = this;
                //mDeferredModeDestroyCallback = mCallback;
            //} else {
                //mCallback.onDestroyActionMode(this);
            //}
            //mCallback = null;
            //animateToMode(false);
            //mContextView.closeMode();
            //mActionView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            //mActionMode = null;
            //if (mWasHiddenBeforeMode) {
                //hide();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.913 -0400", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "09CD291F58A645AF3A8E9CF913126DF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                mCallback.onPrepareActionMode(this, mMenu);
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //mCallback.onPrepareActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.914 -0400", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "C6D9838B9AE1B80EE3715A6269F38C4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                boolean var8B33BA39C48AC4211B5B4A48DBAC6104_2095083445 = (mCallback.onCreateActionMode(this, mMenu));
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //return mCallback.onCreateActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.914 -0400", hash_original_method = "D05FE6927B0D6D37D4F8F8E54FD54AC2", hash_generated_method = "6B163051A2CBD13EFBDA953BF593519F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setCustomView(View view) {
            dsTaint.addTaint(view.dsTaint);
            mContextView.setCustomView(view);
            mCustomView = new WeakReference<View>(view);
            // ---------- Original Method ----------
            //mContextView.setCustomView(view);
            //mCustomView = new WeakReference<View>(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.914 -0400", hash_original_method = "EDCF93193B842CC10D4874A3847ED8B0", hash_generated_method = "D6B78C8E941FD412F6AB11F2334556D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSubtitle(CharSequence subtitle) {
            dsTaint.addTaint(subtitle);
            mContextView.setSubtitle(subtitle);
            // ---------- Original Method ----------
            //mContextView.setSubtitle(subtitle);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.914 -0400", hash_original_method = "A400678911C36F7EF5F4C53636B8794A", hash_generated_method = "9D41B88ED356623792BFA7DD99C5023C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setTitle(CharSequence title) {
            dsTaint.addTaint(title);
            mContextView.setTitle(title);
            // ---------- Original Method ----------
            //mContextView.setTitle(title);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.914 -0400", hash_original_method = "47F5B9C8307FB4AF11C6A2812A14A860", hash_generated_method = "19B2B9C5F5B9DA0121AA428418FB543C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setTitle(int resId) {
            dsTaint.addTaint(resId);
            setTitle(mContext.getResources().getString(resId));
            // ---------- Original Method ----------
            //setTitle(mContext.getResources().getString(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.914 -0400", hash_original_method = "0B3678050067173199BE985BD486C4DF", hash_generated_method = "806B11D5B24C561734B775988CA4497B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSubtitle(int resId) {
            dsTaint.addTaint(resId);
            setSubtitle(mContext.getResources().getString(resId));
            // ---------- Original Method ----------
            //setSubtitle(mContext.getResources().getString(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.915 -0400", hash_original_method = "B7C7D06E8A777BBCD952F14E250A3EF1", hash_generated_method = "043CA3F602C81FE4563F9D1D17A29D65")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharSequence getTitle() {
            CharSequence var4D565D7941BFC0DF9FA61E6599C78CC7_2129730373 = (mContextView.getTitle());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mContextView.getTitle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.915 -0400", hash_original_method = "117FD7BAEF9CDB7B98041D8B7F2D9548", hash_generated_method = "4EFCD5FD6928582C4596FE4E396686D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharSequence getSubtitle() {
            CharSequence var323A94BE4C3330C9ED37AB394DCD096A_2008846853 = (mContextView.getSubtitle());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mContextView.getSubtitle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.916 -0400", hash_original_method = "6445ACEDBE83E3C2D5AD83B96CDE83BC", hash_generated_method = "51488D105CBEAF6E2B926F6EDFB66A31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public View getCustomView() {
            {
                Object var76AC8278B5ED6A4B0B49993BD6F5CE8F_693164313 = (mCustomView.get());
            } //End flattened ternary
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCustomView != null ? mCustomView.get() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.916 -0400", hash_original_method = "811C79E6E9EF223E39B6355E1D511C3E", hash_generated_method = "36ACE2E54569B2BBA8B5597FB6C9C28B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(item.dsTaint);
            dsTaint.addTaint(menu.dsTaint);
            {
                boolean varEDF93C5517A51BAAA6230A19AB6D2347_1366712413 = (mCallback.onActionItemClicked(this, item));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //return mCallback.onActionItemClicked(this, item);
            //} else {
                //return false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.917 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "44081F968D2D24B7AB35F5F8D4FF9C63")
        @DSModeled(DSC.SAFE)
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(allMenusAreClosing);
            dsTaint.addTaint(menu.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.917 -0400", hash_original_method = "7D886846B59E57EE3CE79C98862AC926", hash_generated_method = "E22F8E9E06C52A76F1C838CAC577983D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(subMenu.dsTaint);
            {
                boolean varF5ECE34C03DAB72F995F7F65544DBA24_572279158 = (!subMenu.hasVisibleItems());
            } //End collapsed parenthetic
            new MenuPopupHelper(getThemedContext(), subMenu).show();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCallback == null) {
                //return false;
            //}
            //if (!subMenu.hasVisibleItems()) {
                //return true;
            //}
            //new MenuPopupHelper(getThemedContext(), subMenu).show();
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.918 -0400", hash_original_method = "6B692B27380EC4C10CDFFF60DC2D0482", hash_generated_method = "514D7FC257B31650736719C52D26C82F")
        @DSModeled(DSC.SAFE)
        public void onCloseSubMenu(SubMenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.919 -0400", hash_original_method = "5641671D684852B976991F51D9F0AB3E", hash_generated_method = "F3B80848CCD635570A26D7652A449752")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onMenuModeChange(MenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            invalidate();
            mContextView.showOverflowMenu();
            // ---------- Original Method ----------
            //if (mCallback == null) {
                //return;
            //}
            //invalidate();
            //mContextView.showOverflowMenu();
        }

        
    }


    
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private Object mTag;
        private Drawable mIcon;
        private CharSequence mText;
        private CharSequence mContentDesc;
        private int mPosition = -1;
        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.920 -0400", hash_original_method = "F89A1CC5A4F21612A21BAFD80A90163A", hash_generated_method = "F89A1CC5A4F21612A21BAFD80A90163A")
                public TabImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.920 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "AB7D78E1807551822FD27490BF55519E")
        @DSModeled(DSC.SAFE)
        @Override
        public Object getTag() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mTag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.921 -0400", hash_original_method = "BB14A4918D906598A88E3D6A8128EA77", hash_generated_method = "9085E6368D0C4B5BEB2A5C685DDE4F7D")
        @DSModeled(DSC.SAFE)
        @Override
        public Tab setTag(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mTag = tag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.921 -0400", hash_original_method = "E24F48568604237F2413A93282202AA0", hash_generated_method = "5D1CBDB8A49099656503A08C157BC76C")
        @DSModeled(DSC.SAFE)
        public ActionBar.TabListener getCallback() {
            return (ActionBar.TabListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.921 -0400", hash_original_method = "464280ABF8AEC5C77A1E9FBBDE9C172D", hash_generated_method = "C101EF0AFB2F665718BC0463123356E4")
        @DSModeled(DSC.SAFE)
        @Override
        public Tab setTabListener(ActionBar.TabListener callback) {
            dsTaint.addTaint(callback.dsTaint);
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mCallback = callback;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.921 -0400", hash_original_method = "564891C70D3FD9FDA6B8DDF54A8A1C12", hash_generated_method = "008C594B5F51F153DDC49447F5129FFE")
        @DSModeled(DSC.SAFE)
        @Override
        public View getCustomView() {
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCustomView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.922 -0400", hash_original_method = "0927DBCB7C9D04ABD72A572D4EBE85DC", hash_generated_method = "365EEC6EFBB39E9482E370AB136B61C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setCustomView(View view) {
            dsTaint.addTaint(view.dsTaint);
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mCustomView = view;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.922 -0400", hash_original_method = "AB0A301D41389C31F697384DEDEE9E45", hash_generated_method = "8DA17BE16573FBC865710793EC6CACC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setCustomView(int layoutResId) {
            dsTaint.addTaint(layoutResId);
            Tab varC6930A1035298017905D68E65DCEE19C_1154104731 = (setCustomView(LayoutInflater.from(getThemedContext())
                    .inflate(layoutResId, null)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setCustomView(LayoutInflater.from(getThemedContext())
                    //.inflate(layoutResId, null));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.922 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "F57EA5214A8E044262746183C71A5E02")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable getIcon() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIcon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.923 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "7B0D252BF372B462C0C71625B4E7859C")
        @DSModeled(DSC.SAFE)
        @Override
        public int getPosition() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPosition;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.923 -0400", hash_original_method = "3F4169F86E913801B39145F8B5F1CF4A", hash_generated_method = "5218586C57AB702B2FF9CE6938C1EF7A")
        @DSModeled(DSC.SAFE)
        public void setPosition(int position) {
            dsTaint.addTaint(position);
            // ---------- Original Method ----------
            //mPosition = position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.923 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "E0BF6314535C334F5C39EDBF310C8AAE")
        @DSModeled(DSC.SAFE)
        @Override
        public CharSequence getText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.924 -0400", hash_original_method = "E054EF134439DF27250AEE851BCF79C2", hash_generated_method = "1212B15112CA644934B75642C65BCD5B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setIcon(Drawable icon) {
            dsTaint.addTaint(icon.dsTaint);
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mIcon = icon;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.924 -0400", hash_original_method = "95CB6D2B1B424F33C131278F8466F7F6", hash_generated_method = "2C3F379E80F5781C6BC0CBBF15692F36")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setIcon(int resId) {
            dsTaint.addTaint(resId);
            Tab varD58AB34A07AD86284B49D21CAAFD24F7_1207448509 = (setIcon(mContext.getResources().getDrawable(resId)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setIcon(mContext.getResources().getDrawable(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.925 -0400", hash_original_method = "7912BF664F58A4FFF0C4F40EE3B2F065", hash_generated_method = "0430AF6C2172BD1C50B92C23CB10A0BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setText(CharSequence text) {
            dsTaint.addTaint(text);
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mText = text;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.926 -0400", hash_original_method = "593BCE41C6DE3623B8717D7BF5F8858F", hash_generated_method = "42B40A2055FDA901352B61007645FF39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setText(int resId) {
            dsTaint.addTaint(resId);
            Tab varE1553F8688A0A0C590F4136D1DE8A23E_1078836687 = (setText(mContext.getResources().getText(resId)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setText(mContext.getResources().getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.926 -0400", hash_original_method = "10821E84B4BC38351A9F8E96F9552B43", hash_generated_method = "5116FF2EF6D66BA582D4CB8F63A2B26D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void select() {
            selectTab(this);
            // ---------- Original Method ----------
            //selectTab(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.926 -0400", hash_original_method = "64BDEA3E085EE551443B27403AA215D4", hash_generated_method = "38E56B3B54E4CD7508140A30E108F737")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setContentDescription(int resId) {
            dsTaint.addTaint(resId);
            Tab varDA1A6C846147BFB127F4F43C0023FBE0_1091391203 = (setContentDescription(mContext.getResources().getText(resId)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setContentDescription(mContext.getResources().getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.926 -0400", hash_original_method = "DB5D720F6039044C737BC09541B22E5C", hash_generated_method = "6A81B452042B5E5D13BB1678C6CAA087")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setContentDescription(CharSequence contentDesc) {
            dsTaint.addTaint(contentDesc);
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mContentDesc = contentDesc;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.927 -0400", hash_original_method = "637498C982C6D53C6EA2D802031901B7", hash_generated_method = "2637B8605F454EE32CC2ADD3D3BB1473")
        @DSModeled(DSC.SAFE)
        @Override
        public CharSequence getContentDescription() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mContentDesc;
        }

        
    }


    
    private static final String TAG = "ActionBarImpl";
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
}

