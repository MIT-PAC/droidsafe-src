package com.android.internal.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "ActionBarImpl";
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
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    private int mContextDisplayMode;
    private boolean mHasEmbeddedTabs;
    final Handler mHandler = new Handler();
    Runnable mTabSelector;
    private Animator mCurrentShowAnim;
    private Animator mCurrentModeAnim;
    private boolean mShowHideAnimationEnabled;
    boolean mWasHiddenBeforeMode;
    final AnimatorListener mHideListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.406 -0400", hash_original_method = "F963BB61325C11416F39E483670ED211", hash_generated_method = "11763F28950C50B318C5099CEE201BCC")
        @DSModeled(DSC.SAFE)
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.406 -0400", hash_original_method = "CA861A0A44A2878B5B0D20FC92104D63", hash_generated_method = "674B14A57688624CB1402D0C561B7662")
        @DSModeled(DSC.SAFE)
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.406 -0400", hash_original_method = "59F98BFDF3B79CD734A4E0F1D5C36E49", hash_generated_method = "A5E5B8B7B8442FA8E39E2E50ADE01C3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarImpl(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Window window;
        window = activity.getWindow();
        View decor;
        decor = window.getDecorView();
        init(decor);
        {
            boolean var95A05EC5BBC3BEEE196E68366EEE801B_1625630670 = (!mActivity.getWindow().hasFeature(Window.FEATURE_ACTION_BAR_OVERLAY));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.406 -0400", hash_original_method = "8749FCFE1A7B0A0EC82F09729A7EA1FF", hash_generated_method = "B2E0CFC801E41A201344BE76A6D18E12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarImpl(Dialog dialog) {
        dsTaint.addTaint(dialog.dsTaint);
        init(dialog.getWindow().getDecorView());
        // ---------- Original Method ----------
        //mDialog = dialog;
        //init(dialog.getWindow().getDecorView());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.406 -0400", hash_original_method = "CD1B24EA492A78A5E57A77E5FDC89AEF", hash_generated_method = "56F6EE4ABF22BC67E84BFB757734D823")
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
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "988D25E4BF24BB800BD6556DCD183591", hash_generated_method = "C37E3BDE2AF4CE60E531F13410049F47")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "05911004B37CFCA0E1E3075964BC3E46", hash_generated_method = "07212A49EC25D29850F3008191D516CC")
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
        final boolean isInTabMode;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "04F31515B176FCA9797E5A3B1AE2D925", hash_generated_method = "AE20F557F23BF043796E41DCFBBD73B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "FB60553060C0CBA07AA4AE6F5834D888", hash_generated_method = "B447B485019419FAE7E92515D14DFC9C")
    @DSModeled(DSC.SAFE)
     void completeDeferredDestroyActionMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "F176835B5C4C66FE158A96087EB7976E", hash_generated_method = "92141AF957340B5FAC0FC4BA4C3D221F")
    @DSModeled(DSC.SAFE)
    public void setShowHideAnimationEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "432643F5D3E1C75318DA649F07995AE5", hash_generated_method = "D536309E2A7853FEAB6F0981EFEA3FC7")
    @DSModeled(DSC.SAFE)
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mMenuVisibilityListeners.add(listener);
        // ---------- Original Method ----------
        //mMenuVisibilityListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "602CC871D8636269B09601DAE53B0892", hash_generated_method = "3DF819966F92F3039F46DE56B6F11128")
    @DSModeled(DSC.SAFE)
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mMenuVisibilityListeners.remove(listener);
        // ---------- Original Method ----------
        //mMenuVisibilityListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "459C6E3BA33A1A612E205065B1C3E1DC", hash_generated_method = "9167167D5C55C59549BF618C8F3CEC1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        dsTaint.addTaint(isVisible);
        final int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "B07E8854D08E9349BCA465572774AD05", hash_generated_method = "53E1B0C9F8F1C1A9A6EA3E5F2FA6F22B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setCustomView(int resId) {
        dsTaint.addTaint(resId);
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
        // ---------- Original Method ----------
        //setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "7B32C43910C34545BE6AF1945BAD78C2", hash_generated_method = "2417397C02C19C300FF90286212562BF")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        dsTaint.addTaint(useLogo);
        setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
        // ---------- Original Method ----------
        //setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "7F0843FA34DCBF9EB20E04642D9BA553", hash_generated_method = "26025C68B14E4FBF55F75A377FA09DE0")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        dsTaint.addTaint(showHome);
        setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
        // ---------- Original Method ----------
        //setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.407 -0400", hash_original_method = "F859D1EA93554E58B56470BC246367BB", hash_generated_method = "0993F948982379C8EF5674E1145C63F4")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        dsTaint.addTaint(showHomeAsUp);
        setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
        // ---------- Original Method ----------
        //setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "6C96766F23C0B7039876B0F0E23B9AFF", hash_generated_method = "22915841E32EB306D65F0892CEFDFB90")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        dsTaint.addTaint(showTitle);
        setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
        // ---------- Original Method ----------
        //setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "C60EF70FF87399C557FC41651D29083C", hash_generated_method = "F28917EBBA19B1A26820455DB5D3DE5C")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        dsTaint.addTaint(showCustom);
        setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
        // ---------- Original Method ----------
        //setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "4D222159BA92CC275B5D5CB9ADE89E45", hash_generated_method = "2B4496F6BE3CC5D640449587DBDACBD4")
    @DSModeled(DSC.SAFE)
    @Override
    public void setHomeButtonEnabled(boolean enable) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enable);
        mActionView.setHomeButtonEnabled(enable);
        // ---------- Original Method ----------
        //mActionView.setHomeButtonEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "93A6ED10F8DC44A47D2A5E40CE348C6E", hash_generated_method = "CE2BDF9E007035620FECCB2CA2932AC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTitle(int resId) {
        dsTaint.addTaint(resId);
        setTitle(mContext.getString(resId));
        // ---------- Original Method ----------
        //setTitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "28BA950963DD65E7A01A305F037657F9", hash_generated_method = "CFDBBAF5CFDAF8098BBD4ACEC9EFA46C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSubtitle(int resId) {
        dsTaint.addTaint(resId);
        setSubtitle(mContext.getString(resId));
        // ---------- Original Method ----------
        //setSubtitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "11EA30EC8C9A94D19D07ED1EA15B77B1", hash_generated_method = "FCAFED6DE24CF0B1820C14AFF57A7182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelectedNavigationItem(int position) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(position);
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_838627718 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            selectTab(mTabs.get(position));
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            mActionView.setDropdownSelectedPosition(position);
            //End case NAVIGATION_MODE_LIST 
            //Begin case default 
            throw new IllegalStateException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "B97B28074DE5FCD367C21E021091BD45", hash_generated_method = "677363014A3844CCB8E1A5049F3BF5AD")
    @DSModeled(DSC.SAFE)
    public void removeAllTabs() {
        cleanupTabs();
        // ---------- Original Method ----------
        //cleanupTabs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "62AE76DE88CDD8F4A1D9D70F05364203", hash_generated_method = "DCC649293A8A8D6503F0AD499556D7A5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "2496AA6E0C686AA709C048B4D9A978B1", hash_generated_method = "A7D7EFDE0FA8D723C9B28B5A385CA17A")
    @DSModeled(DSC.SAFE)
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mActionView.setTitle(title);
        // ---------- Original Method ----------
        //mActionView.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "51EFE4022329006F8B97012193639D8C", hash_generated_method = "DDB6220854336156971A17A2B7BDDB1F")
    @DSModeled(DSC.SAFE)
    public void setSubtitle(CharSequence subtitle) {
        dsTaint.addTaint(subtitle);
        mActionView.setSubtitle(subtitle);
        // ---------- Original Method ----------
        //mActionView.setSubtitle(subtitle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "3F11889B61BC98E428CD1B2A494BFC53", hash_generated_method = "A1B37ADC3A2B37905E8A5986A55E2AD2")
    @DSModeled(DSC.SAFE)
    public void setDisplayOptions(int options) {
        dsTaint.addTaint(options);
        mActionView.setDisplayOptions(options);
        // ---------- Original Method ----------
        //mActionView.setDisplayOptions(options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "728BC8FE52686E77081ACD4BE860295D", hash_generated_method = "FF3A819A7CFDB38C5A3504019946E337")
    @DSModeled(DSC.SAFE)
    public void setDisplayOptions(int options, int mask) {
        dsTaint.addTaint(mask);
        dsTaint.addTaint(options);
        final int current;
        current = mActionView.getDisplayOptions();
        mActionView.setDisplayOptions((options & mask) | (current & ~mask));
        // ---------- Original Method ----------
        //final int current = mActionView.getDisplayOptions();
        //mActionView.setDisplayOptions((options & mask) | (current & ~mask));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "61B3599899498272F50206755C75E2FF", hash_generated_method = "9750460CAAE24E8B61C72807DD65894E")
    @DSModeled(DSC.SAFE)
    public void setBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        mContainerView.setPrimaryBackground(d);
        // ---------- Original Method ----------
        //mContainerView.setPrimaryBackground(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "71E64D08C4AF72E9E040B3394527D26B", hash_generated_method = "8EDB2EF1D8B7AF3245B3BE2228196181")
    @DSModeled(DSC.SAFE)
    public void setStackedBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        mContainerView.setStackedBackground(d);
        // ---------- Original Method ----------
        //mContainerView.setStackedBackground(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "228BA16930C30CB95A53923FA275FB3B", hash_generated_method = "BBE692B6D8BA8752FFFE21FB7CD5091B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.408 -0400", hash_original_method = "1D010261269A6D78FBB7E8684C141376", hash_generated_method = "998ABCECC0B5848BB63A41C1DF078CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getCustomView() {
        View var63A4410BAFC226D1557535FE92D83B75_1486725554 = (mActionView.getCustomNavigationView());
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActionView.getCustomNavigationView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "2440C8680C5986DA6B98061A5444C3DF", hash_generated_method = "46F49E548BE1893A460EC6E0582C9419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTitle() {
        CharSequence var3E1FFB55D6CD6E3E017B909355FE2AFA_1411657383 = (mActionView.getTitle());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActionView.getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "7C309AA3715DBCB025C148B6DD4FF98A", hash_generated_method = "3479EE7D88DA5ADA78B5F8A7892066F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getSubtitle() {
        CharSequence var6386D2A981DD4D2EB12AAC1A3849EB77_446348444 = (mActionView.getSubtitle());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActionView.getSubtitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "3CF23CB733C1A66BA695174D1D5C90F5", hash_generated_method = "7990F423E7759C7A27E45B9E37AC8E42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNavigationMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int varEAA142AE97CC923611CFEB4857969BEA_8265281 = (mActionView.getNavigationMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActionView.getNavigationMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "FB6F75E61CAD1294F319FE9A20EDC0AA", hash_generated_method = "12C6EB8E4786AF97695E3698619CD4BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDisplayOptions() {
        int var0A196B6A925A1050E71EDF1CA21BAA1C_1657559803 = (mActionView.getDisplayOptions());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActionView.getDisplayOptions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "6F680EB91F7327296F43077A9CFCB9CD", hash_generated_method = "A4E941F9C9CFF9E71D7895A7C276A1D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
            boolean var2B92093546C2716C766BC5924D507852_860503538 = (mode.dispatchOnCreate());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "4981E6F1136ACFE06B622EFDD1F32611", hash_generated_method = "CD3BF20700549859D33A164C53E333DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void configureTab(Tab tab, int position) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        final TabImpl tabi;
        tabi = (TabImpl) tab;
        final ActionBar.TabListener callback;
        callback = tabi.getCallback();
        {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        } //End block
        tabi.setPosition(position);
        mTabs.add(position, tabi);
        final int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "1EECF05398B0BE8AB00F4615B5278612", hash_generated_method = "A02D6ACEA3297E80C6E195726D755350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTab(Tab tab) {
        dsTaint.addTaint(tab.dsTaint);
        addTab(tab, mTabs.isEmpty());
        // ---------- Original Method ----------
        //addTab(tab, mTabs.isEmpty());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "654B3E709639F944F902BA5D9B821C89", hash_generated_method = "5242DA8B9F277AF13AC9EA623A4B08E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTab(Tab tab, int position) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        addTab(tab, position, mTabs.isEmpty());
        // ---------- Original Method ----------
        //addTab(tab, position, mTabs.isEmpty());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "89408631A5DFBB8696DA15288AA15329", hash_generated_method = "8929926D51585D9158D9981951335CBC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "041C4C5A1F00C6CFE52123DF1D5CFA62", hash_generated_method = "1CFF066985ACAF996F07D351BFCD97AE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "086373AB3E22E85AEE50C2F735BD106D", hash_generated_method = "D573FCCE46516B48D552BD3A45D8DECD")
    @DSModeled(DSC.SAFE)
    @Override
    public Tab newTab() {
        return (Tab)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new TabImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.409 -0400", hash_original_method = "D97BFE7F24375737332EF4EB210BF330", hash_generated_method = "ABEB35CEAE5A4CA68181FE16479BA0F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeTab(Tab tab) {
        dsTaint.addTaint(tab.dsTaint);
        removeTabAt(tab.getPosition());
        // ---------- Original Method ----------
        //removeTabAt(tab.getPosition());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "B3645E4F4AB7E9BBDE0315AEF0157D54", hash_generated_method = "C692FDBADEB875803216FF00EBBD107B")
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
        final int newTabCount;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "08E647315276EA6EFD361EFCDF66D68C", hash_generated_method = "F92BAC5F095D99595783A48388484AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void selectTab(Tab tab) {
        dsTaint.addTaint(tab.dsTaint);
        {
            boolean var0D865F05ACCA97EEC09A4D554FCE6944_1762965159 = (getNavigationMode() != NAVIGATION_MODE_TABS);
            {
                mSavedTabPosition = tab != null ? tab.getPosition() : INVALID_POSITION;
            } //End block
        } //End collapsed parenthetic
        final FragmentTransaction trans;
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
            boolean var0609B2E91FA97D998D43ECA1A4058103_1108293923 = (!trans.isEmpty());
            {
                trans.commit();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "2AD2D5B38A8D730799170A69D020CCD7", hash_generated_method = "18EB07A2088BABD7CDE92184F486EAB6")
    @DSModeled(DSC.SAFE)
    @Override
    public Tab getSelectedTab() {
        return (Tab)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSelectedTab;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "7329EA59D7EBE41DA23E0A3E55EEA1A2", hash_generated_method = "58FBB0499315B00CA7D0E4AE2CE3ACC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getHeight() {
        int varB6E80F54C86C59EC88E3A5A42628443F_1168101656 = (mContainerView.getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContainerView.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "546A4715540EEE6F49A6EAAEA56C241C", hash_generated_method = "6DBAC31D8B52ECD7539385722F5DC356")
    @DSModeled(DSC.SAFE)
    @Override
    public void show() {
        show(true);
        // ---------- Original Method ----------
        //show(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "B9AB02E6F73BE3423F7A7521B424A639", hash_generated_method = "96DC7D2AB9EA31675AFE64789D43E78C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void show(boolean markHiddenBeforeMode) {
        dsTaint.addTaint(markHiddenBeforeMode);
        {
            mCurrentShowAnim.end();
        } //End block
        {
            boolean varA04FE79F70596AEDDC366BB1F9C953E0_1569562341 = (mContainerView.getVisibility() == View.VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.410 -0400", hash_original_method = "F98E692B5353704914249A64080F4E16", hash_generated_method = "09AD5C05B960FADD6608E20F70BB7DAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void hide() {
        {
            mCurrentShowAnim.end();
        } //End block
        {
            boolean varADDBB77A9CB269D2E537C6D87A9B8737_646571259 = (mContainerView.getVisibility() == View.GONE);
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
                boolean varF225B1267295DB8E06979CA78868E507_1776333775 = (mSplitView != null && mSplitView.getVisibility() == View.VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "02F75CA35AA01FBE52A717B38FA758F7", hash_generated_method = "358AC28F7B96FFCE97EA9B4182D95452")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShowing() {
        boolean varFABAF10FC87FB52E607ED88B31859D35_133795509 = (mContainerView.getVisibility() == View.VISIBLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mContainerView.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "6F997D5B2915B28943A5CB4BD830D4B2", hash_generated_method = "C8E94ED89036F88A643BA2323868E25C")
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
            boolean varFBD93DC9D1D6299B253C2D05796D3D2B_1311026612 = (mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "3EA212821B302B1822414F8223429D93", hash_generated_method = "19F8F5F0DE2F833572FFCD9D822F68E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getThemedContext() {
        {
            TypedValue outValue;
            outValue = new TypedValue();
            Resources.Theme currentTheme;
            currentTheme = mContext.getTheme();
            currentTheme.resolveAttribute(com.android.internal.R.attr.actionBarWidgetTheme,
                    outValue, true);
            final int targetThemeRes;
            targetThemeRes = outValue.resourceId;
            {
                boolean varDD6A9FFA4382518FE4FB51366D933575_2101689002 = (targetThemeRes != 0 && mContext.getThemeResId() != targetThemeRes);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "82CB01F3A317C5518DAD7B810C7481F9", hash_generated_method = "A6174745CD53015D08C5809088BB666C")
    @DSModeled(DSC.SAFE)
    @Override
    public void setCustomView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mActionView.setCustomNavigationView(view);
        // ---------- Original Method ----------
        //mActionView.setCustomNavigationView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "D405B9340EEDF523A821CB828A77247A", hash_generated_method = "C8F26E69F7463AC487A8A664EE3F9BBD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "DE3A042A48DE08AEC88EC1C0AD695D6F", hash_generated_method = "95024FFC08BE6777BD56399A9AFE8198")
    @DSModeled(DSC.SAFE)
    @Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(adapter.dsTaint);
        mActionView.setDropdownAdapter(adapter);
        mActionView.setCallback(callback);
        // ---------- Original Method ----------
        //mActionView.setDropdownAdapter(adapter);
        //mActionView.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "DA5FE7663B58F3C2464F93A06566CD8E", hash_generated_method = "E02F2EAE5B781EE6A8A727EA85AD914D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSelectedNavigationIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_422227451 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            {
                Object var9E0D618A4EE8CC879C5AC350775986E3_599807457 = (mSelectedTab.getPosition());
            } //End flattened ternary
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            int var0DAE3350C64D0906A58D53288479EA2D_651490157 = (mActionView.getDropdownSelectedPosition());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.411 -0400", hash_original_method = "29C3EDF1B0696DD606C19CEF5DFCB27A", hash_generated_method = "33ACBF05F5245A346B035F9E5099B8B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getNavigationItemCount() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_1328933280 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            int var81340BC1C620E3820A05E23DEE8223AF_1700489336 = (mTabs.size());
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            SpinnerAdapter adapter;
            adapter = mActionView.getDropdownAdapter();
            //End case NAVIGATION_MODE_LIST 
            //Begin case NAVIGATION_MODE_LIST 
            {
                Object varF7742EA74032E62C939C320B7B8C4E62_177433836 = (adapter.getCount());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "44E873137D601CC44196E7945B5F3744", hash_generated_method = "905D48C6C6A4C22DD931C68633042771")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getTabCount() {
        int varA0AA69837201731921DCB8C161D1B5BD_115020816 = (mTabs.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTabs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "2CF769A940AAC419EB99620655E4C93A", hash_generated_method = "DF615B89A248823BF3522F89A6B76976")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNavigationMode(int mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode);
        final int oldMode;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "389BF0B1EF97627FAF399E95ED0D1079", hash_generated_method = "234E3E2841D52E557E2105845076376D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Tab getTabAt(int index) {
        dsTaint.addTaint(index);
        Tab varB7E13A6D717ABD72B52ABD6601F96C76_179869913 = (mTabs.get(index));
        return (Tab)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTabs.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "246181C3E410F19AA68D711311C45E89", hash_generated_method = "B705F8D5916C4969D9965F26A86EF326")
    @DSModeled(DSC.SAFE)
    @Override
    public void setIcon(int resId) {
        dsTaint.addTaint(resId);
        mActionView.setIcon(resId);
        // ---------- Original Method ----------
        //mActionView.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "976AFC7A654132AA465D788A8B684BD0", hash_generated_method = "064866A85400188A2C1E4D07DA6D3FF1")
    @DSModeled(DSC.SAFE)
    @Override
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mActionView.setIcon(icon);
        // ---------- Original Method ----------
        //mActionView.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "629A6907FC2030BF835EC3846EE4C4B9", hash_generated_method = "59A43A4DD6093243AB97B84A5926985E")
    @DSModeled(DSC.SAFE)
    @Override
    public void setLogo(int resId) {
        dsTaint.addTaint(resId);
        mActionView.setLogo(resId);
        // ---------- Original Method ----------
        //mActionView.setLogo(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "563E995ECF1A81A300841064D1D1EC89", hash_generated_method = "C4EC4A5B9F6C5BB1F010497BE9706A25")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "329ADB94B68F012647BA8B5F412D446E", hash_generated_method = "00B1154371F15E766660C3B2861D2EEC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "51A0980A38EB9FD2F0CEA8B2697D7721", hash_generated_method = "BA0054C5A153ADE4B87789F9269B1B11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public MenuInflater getMenuInflater() {
            MenuInflater varF9B66260E46C1B7864ADC7C530140DAE_1152659871 = (new MenuInflater(getThemedContext()));
            return (MenuInflater)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MenuInflater(getThemedContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "E77E2ECF2B505AC90BA58E75AA3B3394")
        @DSModeled(DSC.SAFE)
        @Override
        public Menu getMenu() {
            return (Menu)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMenu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "55BDAC29AF3CEA463BE5A1AC1715A820", hash_generated_method = "E4DFC5D25B4FEF80715FC27C6355E370")
        @DSModeled(DSC.SAFE)
        @Override
        public void finish() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "C320A5CA6675E6D398D9808F5A54D03E")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.412 -0400", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "5172E09295F1027D38B0BB56F7F22CAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                boolean var8B33BA39C48AC4211B5B4A48DBAC6104_2066840136 = (mCallback.onCreateActionMode(this, mMenu));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "D05FE6927B0D6D37D4F8F8E54FD54AC2", hash_generated_method = "D7FFF73B75E22B5510DEF93E0CE4A28F")
        @DSModeled(DSC.SAFE)
        @Override
        public void setCustomView(View view) {
            dsTaint.addTaint(view.dsTaint);
            mContextView.setCustomView(view);
            mCustomView = new WeakReference<View>(view);
            // ---------- Original Method ----------
            //mContextView.setCustomView(view);
            //mCustomView = new WeakReference<View>(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "EDCF93193B842CC10D4874A3847ED8B0", hash_generated_method = "D46EBC6442F1EDC2BD156272485E724E")
        @DSModeled(DSC.SAFE)
        @Override
        public void setSubtitle(CharSequence subtitle) {
            dsTaint.addTaint(subtitle);
            mContextView.setSubtitle(subtitle);
            // ---------- Original Method ----------
            //mContextView.setSubtitle(subtitle);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "A400678911C36F7EF5F4C53636B8794A", hash_generated_method = "FDFA28BF87CFC7EFB3D636E9D2D14E9A")
        @DSModeled(DSC.SAFE)
        @Override
        public void setTitle(CharSequence title) {
            dsTaint.addTaint(title);
            mContextView.setTitle(title);
            // ---------- Original Method ----------
            //mContextView.setTitle(title);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "47F5B9C8307FB4AF11C6A2812A14A860", hash_generated_method = "17F876A97CF226217536E85FA67C968A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setTitle(int resId) {
            dsTaint.addTaint(resId);
            setTitle(mContext.getResources().getString(resId));
            // ---------- Original Method ----------
            //setTitle(mContext.getResources().getString(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "0B3678050067173199BE985BD486C4DF", hash_generated_method = "41D7E3B06F420EAA82B0BCDDE2915441")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setSubtitle(int resId) {
            dsTaint.addTaint(resId);
            setSubtitle(mContext.getResources().getString(resId));
            // ---------- Original Method ----------
            //setSubtitle(mContext.getResources().getString(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "B7C7D06E8A777BBCD952F14E250A3EF1", hash_generated_method = "73B226A0D379A446C422F1E0C52C3468")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharSequence getTitle() {
            CharSequence var4D565D7941BFC0DF9FA61E6599C78CC7_2060786291 = (mContextView.getTitle());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mContextView.getTitle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "117FD7BAEF9CDB7B98041D8B7F2D9548", hash_generated_method = "12C0D7B749B12EACD52FD1C277C614A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharSequence getSubtitle() {
            CharSequence var323A94BE4C3330C9ED37AB394DCD096A_435973778 = (mContextView.getSubtitle());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mContextView.getSubtitle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "6445ACEDBE83E3C2D5AD83B96CDE83BC", hash_generated_method = "8E799393F9C8BAE61C02B54BD106ED01")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public View getCustomView() {
            {
                Object var76AC8278B5ED6A4B0B49993BD6F5CE8F_1224945211 = (mCustomView.get());
            } //End flattened ternary
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCustomView != null ? mCustomView.get() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "811C79E6E9EF223E39B6355E1D511C3E", hash_generated_method = "63246A493D978307908748FF6222482E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(item.dsTaint);
            {
                boolean varEDF93C5517A51BAAA6230A19AB6D2347_346005299 = (mCallback.onActionItemClicked(this, item));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //return mCallback.onActionItemClicked(this, item);
            //} else {
                //return false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "51B4AE5322EC0FC6EC9D00F4534057C2")
        @DSModeled(DSC.SAFE)
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(allMenusAreClosing);
            dsTaint.addTaint(menu.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "7D886846B59E57EE3CE79C98862AC926", hash_generated_method = "96E4EE59178B29AD26C14C9FB87D291C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(subMenu.dsTaint);
            {
                boolean varF5ECE34C03DAB72F995F7F65544DBA24_1179477833 = (!subMenu.hasVisibleItems());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "6B692B27380EC4C10CDFFF60DC2D0482", hash_generated_method = "62276DB74D7112BFC4559E1C93E9716B")
        @DSModeled(DSC.SAFE)
        public void onCloseSubMenu(SubMenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "5641671D684852B976991F51D9F0AB3E", hash_generated_method = "4BE9C4FB11FF6A5F4F3CC43234AC04E4")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "5BCA7A357F207952FC431D1B0AFC8C4C")
        @DSModeled(DSC.SAFE)
        @Override
        public Object getTag() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mTag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.413 -0400", hash_original_method = "BB14A4918D906598A88E3D6A8128EA77", hash_generated_method = "09F58D6A00995E50790A33BEA36AF965")
        @DSModeled(DSC.SAFE)
        @Override
        public Tab setTag(Object tag) {
            dsTaint.addTaint(tag.dsTaint);
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mTag = tag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "E24F48568604237F2413A93282202AA0", hash_generated_method = "3D3FD5F101CDD8E90143BEAEBFC8F499")
        @DSModeled(DSC.SAFE)
        public ActionBar.TabListener getCallback() {
            return (ActionBar.TabListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "464280ABF8AEC5C77A1E9FBBDE9C172D", hash_generated_method = "8B2AD0B4945EEC03E4E9476F59B57693")
        @DSModeled(DSC.SAFE)
        @Override
        public Tab setTabListener(ActionBar.TabListener callback) {
            dsTaint.addTaint(callback.dsTaint);
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mCallback = callback;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "564891C70D3FD9FDA6B8DDF54A8A1C12", hash_generated_method = "8F413873FA2DF72395000E7C163B73EC")
        @DSModeled(DSC.SAFE)
        @Override
        public View getCustomView() {
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCustomView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "0927DBCB7C9D04ABD72A572D4EBE85DC", hash_generated_method = "8A9119455427C7982299E3A9EE6617FF")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "AB0A301D41389C31F697384DEDEE9E45", hash_generated_method = "3C64BFF9A37F873C5043F711FF4928D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setCustomView(int layoutResId) {
            dsTaint.addTaint(layoutResId);
            Tab varC6930A1035298017905D68E65DCEE19C_1733164862 = (setCustomView(LayoutInflater.from(getThemedContext())
                    .inflate(layoutResId, null)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setCustomView(LayoutInflater.from(getThemedContext())
                    //.inflate(layoutResId, null));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "C7A2F06CDC69A05932B3B90D734C9C08")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable getIcon() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mIcon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "738FDBCC28BFE2B84880515C01118946")
        @DSModeled(DSC.SAFE)
        @Override
        public int getPosition() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPosition;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "3F4169F86E913801B39145F8B5F1CF4A", hash_generated_method = "2750DFA45446544943B25553F11F1DCA")
        @DSModeled(DSC.SAFE)
        public void setPosition(int position) {
            dsTaint.addTaint(position);
            // ---------- Original Method ----------
            //mPosition = position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "6DA2BD7579180037B3DEE43A543BB484")
        @DSModeled(DSC.SAFE)
        @Override
        public CharSequence getText() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "E054EF134439DF27250AEE851BCF79C2", hash_generated_method = "68272EB5F788C21D8370EE0445D765A3")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "95CB6D2B1B424F33C131278F8466F7F6", hash_generated_method = "2948AE6B9BCAB0D9C9119305B279A985")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setIcon(int resId) {
            dsTaint.addTaint(resId);
            Tab varD58AB34A07AD86284B49D21CAAFD24F7_1816204217 = (setIcon(mContext.getResources().getDrawable(resId)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setIcon(mContext.getResources().getDrawable(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "7912BF664F58A4FFF0C4F40EE3B2F065", hash_generated_method = "952EB185E372287A5D498AD9366618F9")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "593BCE41C6DE3623B8717D7BF5F8858F", hash_generated_method = "6F23DD7BBFF683134D3644F02242357F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setText(int resId) {
            dsTaint.addTaint(resId);
            Tab varE1553F8688A0A0C590F4136D1DE8A23E_2125522685 = (setText(mContext.getResources().getText(resId)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setText(mContext.getResources().getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "10821E84B4BC38351A9F8E96F9552B43", hash_generated_method = "C8A9EBDAF777E360ECAACBA9F013C366")
        @DSModeled(DSC.SAFE)
        @Override
        public void select() {
            selectTab(this);
            // ---------- Original Method ----------
            //selectTab(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "64BDEA3E085EE551443B27403AA215D4", hash_generated_method = "8698B2212361E9D081EAF3E4123F4E34")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tab setContentDescription(int resId) {
            dsTaint.addTaint(resId);
            Tab varDA1A6C846147BFB127F4F43C0023FBE0_1915081531 = (setContentDescription(mContext.getResources().getText(resId)));
            return (Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return setContentDescription(mContext.getResources().getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "DB5D720F6039044C737BC09541B22E5C", hash_generated_method = "70505733AEB6D32DF3D02A260A904B88")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.414 -0400", hash_original_method = "637498C982C6D53C6EA2D802031901B7", hash_generated_method = "EA88400806CCBDE49A3D313F7F4231C0")
        @DSModeled(DSC.SAFE)
        @Override
        public CharSequence getContentDescription() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mContentDesc;
        }

        
    }


    
}


