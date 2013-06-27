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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "F5C37C4F8245D2D147B5F954C98598CD", hash_generated_field = "A1CC5C58DF7C0DCCCCFFCA493E0A62F0")

    private Context mThemedContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

    private Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "E9D2C5D306B865C46CCA3CA1F1920C28", hash_generated_field = "3B5102E8A4555D5377D5546AD36E30EF")

    private ActionBarContainer mContainerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "42ED82821F0D805CE8C635AE635639B9", hash_generated_field = "435589A395F4655E845140B48CC5DD82")

    private ActionBarView mActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "13165738652608F9EE0CDB1A8EC90D22", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "1D151831F4C7E78E301ECA2DDA3CAED0", hash_generated_field = "4B2A718FB491B6DDCF6D6F12DBDA30A4")

    private ActionBarContainer mSplitView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.380 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "79971B4F2D39C7D687D7922DF67CCF83", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "E0236F65D62F98CFEACE8B9791BC6DFE", hash_generated_field = "2DE8BE827BC107C008436B0209722BF6")

    private ArrayList<TabImpl> mTabs = new ArrayList<TabImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "7AB2B74DF2A193B0C68E51A8508488A0", hash_generated_field = "E2A3DD52B8E79318754411772B5ABC7F")

    private TabImpl mSelectedTab;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "428613F2A4EC86480847E5DA42526736", hash_generated_field = "2822997A4E0CF16ED36F9B5F7F7F88DD")

    private int mSavedTabPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "C88A4C5DD17B0498252830DDAB04C8E1")

    ActionModeImpl mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "5180A3EB7DC7F36C82A2BD53BB6E22F5", hash_generated_field = "BEDD9228BA62217EC5EC4E12ED60D452")

    ActionMode mDeferredDestroyActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "9546024210C24CA70960554BD24D9005", hash_generated_field = "DF2EF7E0E1A5263A29433A4282D9458F")

    ActionMode.Callback mDeferredModeDestroyCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "44A3A545246AFAA5F22D3E94D1DC0DDD", hash_generated_field = "E1595EB11EBE3E17FC85A0C8B6399279")

    private boolean mLastMenuVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "2C9F8D0C1FC6546CBA36AF4EFC26A494", hash_generated_field = "11BF511A20694B14557F30E21D03698F")

    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<OnMenuVisibilityListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "CBEE79C0E03F33BC4AED6CFBC2EB379F", hash_generated_field = "C12FFA93FDEE59EC3B20F05029DA9108")

    private int mContextDisplayMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "4084EE71243F09CF6499828ED0C843C4", hash_generated_field = "11F23D5F4B9A4FEB27E5A49E7106FEF0")

    private boolean mHasEmbeddedTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "AD9C3D1E48D73BF1547D53C4C62401B2")

    Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "85B61EC738F2056493BB5A07F48F6CE2", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "70690A02AD9E3C259E20A2FF977496E4", hash_generated_field = "A15ADDA5892591962A8310C80A51790F")

    private Animator mCurrentShowAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "010D01D139412B6E9660288D10EE556E", hash_generated_field = "6CA587E5D3B3F2540E397F3FD2FB959C")

    private Animator mCurrentModeAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "890E564069855FDC1EF47F290C02A110", hash_generated_field = "C93BEC8818A2F937EE0E6D7461D0E0FD")

    private boolean mShowHideAnimationEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.381 -0400", hash_original_field = "E8024699D94A8BEFD0D705A9675F8CED", hash_generated_field = "B2D34DAB28A6988D84FE0BB74C5C7E9B")

    boolean mWasHiddenBeforeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.382 -0400", hash_original_field = "FCB094484C39025804ED780EC0133250", hash_generated_field = "0430C0271CC20A6BC958CE3C8F830BDF")

    AnimatorListener mHideListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.382 -0400", hash_original_method = "F963BB61325C11416F39E483670ED211", hash_generated_method = "B390DFB722C7C46D4BDE52128B843793")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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
            addTaint(animation.getTaint());
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.382 -0400", hash_original_field = "D5E7E0178A4C43DE90969C434EEC1CD9", hash_generated_field = "ECBBD38602AEE27452359B3B2C978A8E")

    AnimatorListener mShowListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.382 -0400", hash_original_method = "CA861A0A44A2878B5B0D20FC92104D63", hash_generated_method = "EF2053B78441E1DD818B82BE72053BC0")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mCurrentShowAnim = null;
            mContainerView.requestLayout();
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //mCurrentShowAnim = null;
            //mContainerView.requestLayout();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.385 -0400", hash_original_method = "59F98BFDF3B79CD734A4E0F1D5C36E49", hash_generated_method = "D50AA8B8C162ADCACE1FD3500C84CB47")
    public  ActionBarImpl(Activity activity) {
        mActivity = activity;
        Window window;
        window = activity.getWindow();
        View decor;
        decor = window.getDecorView();
        init(decor);
        {
            boolean var95A05EC5BBC3BEEE196E68366EEE801B_187910217 = (!mActivity.getWindow().hasFeature(Window.FEATURE_ACTION_BAR_OVERLAY));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.385 -0400", hash_original_method = "8749FCFE1A7B0A0EC82F09729A7EA1FF", hash_generated_method = "ABD82B745CE6FBD975A8B09752DAC6AC")
    public  ActionBarImpl(Dialog dialog) {
        mDialog = dialog;
        init(dialog.getWindow().getDecorView());
        // ---------- Original Method ----------
        //mDialog = dialog;
        //init(dialog.getWindow().getDecorView());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.386 -0400", hash_original_method = "CD1B24EA492A78A5E57A77E5FDC89AEF", hash_generated_method = "7621594127F3B6153EAC7EF4B58820FC")
    private void init(View decor) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.386 -0400", hash_original_method = "988D25E4BF24BB800BD6556DCD183591", hash_generated_method = "6157D10E87FCD72FD6A9C3BDDBEF785A")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setHasEmbeddedTabs(mContext.getResources().getBoolean(
                com.android.internal.R.bool.action_bar_embed_tabs));
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //setHasEmbeddedTabs(mContext.getResources().getBoolean(
                //com.android.internal.R.bool.action_bar_embed_tabs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.400 -0400", hash_original_method = "05911004B37CFCA0E1E3075964BC3E46", hash_generated_method = "64F9DEE9536750F5685D25D76E90FAB6")
    private void setHasEmbeddedTabs(boolean hasEmbeddedTabs) {
        mHasEmbeddedTabs = hasEmbeddedTabs;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.401 -0400", hash_original_method = "04F31515B176FCA9797E5A3B1AE2D925", hash_generated_method = "EE560EFCD2D03DA47191BFAD6BFF74A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.401 -0400", hash_original_method = "FB60553060C0CBA07AA4AE6F5834D888", hash_generated_method = "F6E44B1CBFFEFB4CAE23BC4F3A6C11A3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.402 -0400", hash_original_method = "F176835B5C4C66FE158A96087EB7976E", hash_generated_method = "F01BABF4974F0DC1B997F072C6F5EEFA")
    public void setShowHideAnimationEnabled(boolean enabled) {
        mShowHideAnimationEnabled = enabled;
        {
            mCurrentShowAnim.end();
        } //End block
        // ---------- Original Method ----------
        //mShowHideAnimationEnabled = enabled;
        //if (!enabled && mCurrentShowAnim != null) {
            //mCurrentShowAnim.end();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.402 -0400", hash_original_method = "432643F5D3E1C75318DA649F07995AE5", hash_generated_method = "2913F3F7BCA46568007835BE8190ED78")
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mMenuVisibilityListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mMenuVisibilityListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.402 -0400", hash_original_method = "602CC871D8636269B09601DAE53B0892", hash_generated_method = "CB121F845C04220FCA2A6F9B3FAB6B01")
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mMenuVisibilityListeners.remove(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mMenuVisibilityListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.403 -0400", hash_original_method = "459C6E3BA33A1A612E205065B1C3E1DC", hash_generated_method = "B8799801BF35CC1FFDD640A809DC6885")
    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        mLastMenuVisibility = isVisible;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.403 -0400", hash_original_method = "B07E8854D08E9349BCA465572774AD05", hash_generated_method = "91DD3F56E013E72FAB7452FAA6E20095")
    @Override
    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
        addTaint(resId);
        // ---------- Original Method ----------
        //setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.410 -0400", hash_original_method = "7B32C43910C34545BE6AF1945BAD78C2", hash_generated_method = "45162C8E0F12FA3379E248A48E315EC5")
    @Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
        addTaint(useLogo);
        // ---------- Original Method ----------
        //setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.410 -0400", hash_original_method = "7F0843FA34DCBF9EB20E04642D9BA553", hash_generated_method = "77AF66A4081B57D19A0162C83A8A2947")
    @Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
        addTaint(showHome);
        // ---------- Original Method ----------
        //setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.410 -0400", hash_original_method = "F859D1EA93554E58B56470BC246367BB", hash_generated_method = "A14E2B162ED5F9F1194A39DEE855239C")
    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
        addTaint(showHomeAsUp);
        // ---------- Original Method ----------
        //setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.411 -0400", hash_original_method = "6C96766F23C0B7039876B0F0E23B9AFF", hash_generated_method = "345384BA3C6D5BBB3359229F0517D195")
    @Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
        addTaint(showTitle);
        // ---------- Original Method ----------
        //setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.416 -0400", hash_original_method = "C60EF70FF87399C557FC41651D29083C", hash_generated_method = "BBAC1A647A0E1E51BB945477DD02AA1E")
    @Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
        addTaint(showCustom);
        // ---------- Original Method ----------
        //setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.416 -0400", hash_original_method = "4D222159BA92CC275B5D5CB9ADE89E45", hash_generated_method = "20CE5649E5AF3952E376BADF5E9867B3")
    @Override
    public void setHomeButtonEnabled(boolean enable) {
        mActionView.setHomeButtonEnabled(enable);
        addTaint(enable);
        // ---------- Original Method ----------
        //mActionView.setHomeButtonEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.417 -0400", hash_original_method = "93A6ED10F8DC44A47D2A5E40CE348C6E", hash_generated_method = "E4970BD8AF05390D270B4130B9DF8834")
    @Override
    public void setTitle(int resId) {
        setTitle(mContext.getString(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setTitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.417 -0400", hash_original_method = "28BA950963DD65E7A01A305F037657F9", hash_generated_method = "F78BB9C2EEBDCF78AEFE9DD35A852241")
    @Override
    public void setSubtitle(int resId) {
        setSubtitle(mContext.getString(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setSubtitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.417 -0400", hash_original_method = "11EA30EC8C9A94D19D07ED1EA15B77B1", hash_generated_method = "1B47A1B20E16FA55374BC96CA7B18380")
    public void setSelectedNavigationItem(int position) {
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_1021765694 = (mActionView.getNavigationMode());
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
        addTaint(position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.426 -0400", hash_original_method = "B97B28074DE5FCD367C21E021091BD45", hash_generated_method = "18F3DD1B438293814EC931E00EFDC066")
    public void removeAllTabs() {
        cleanupTabs();
        // ---------- Original Method ----------
        //cleanupTabs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.427 -0400", hash_original_method = "62AE76DE88CDD8F4A1D9D70F05364203", hash_generated_method = "2876F52F172304588585ECF93C6BA287")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.427 -0400", hash_original_method = "2496AA6E0C686AA709C048B4D9A978B1", hash_generated_method = "E78EF245AE6B7472B7951F58BC812630")
    public void setTitle(CharSequence title) {
        mActionView.setTitle(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //mActionView.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.427 -0400", hash_original_method = "51EFE4022329006F8B97012193639D8C", hash_generated_method = "8EC4E0C37E994FBE03A720F03567FDDA")
    public void setSubtitle(CharSequence subtitle) {
        mActionView.setSubtitle(subtitle);
        addTaint(subtitle.getTaint());
        // ---------- Original Method ----------
        //mActionView.setSubtitle(subtitle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.427 -0400", hash_original_method = "3F11889B61BC98E428CD1B2A494BFC53", hash_generated_method = "E3E153D08C74571AFD2B7407C364343E")
    public void setDisplayOptions(int options) {
        mActionView.setDisplayOptions(options);
        addTaint(options);
        // ---------- Original Method ----------
        //mActionView.setDisplayOptions(options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.427 -0400", hash_original_method = "728BC8FE52686E77081ACD4BE860295D", hash_generated_method = "B8E9251F7EEC60E1304666FFE33D11CA")
    public void setDisplayOptions(int options, int mask) {
        int current;
        current = mActionView.getDisplayOptions();
        mActionView.setDisplayOptions((options & mask) | (current & ~mask));
        addTaint(options);
        addTaint(mask);
        // ---------- Original Method ----------
        //final int current = mActionView.getDisplayOptions();
        //mActionView.setDisplayOptions((options & mask) | (current & ~mask));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.428 -0400", hash_original_method = "61B3599899498272F50206755C75E2FF", hash_generated_method = "4C48377B1AAE181071764FCB21AD1B54")
    public void setBackgroundDrawable(Drawable d) {
        mContainerView.setPrimaryBackground(d);
        addTaint(d.getTaint());
        // ---------- Original Method ----------
        //mContainerView.setPrimaryBackground(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.428 -0400", hash_original_method = "71E64D08C4AF72E9E040B3394527D26B", hash_generated_method = "018B3C1CFF34E23A23B1734B25D3016A")
    public void setStackedBackgroundDrawable(Drawable d) {
        mContainerView.setStackedBackground(d);
        addTaint(d.getTaint());
        // ---------- Original Method ----------
        //mContainerView.setStackedBackground(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.428 -0400", hash_original_method = "228BA16930C30CB95A53923FA275FB3B", hash_generated_method = "DF8A2EBDFAFD41174C0D511EB0828866")
    public void setSplitBackgroundDrawable(Drawable d) {
        {
            mSplitView.setSplitBackground(d);
        } //End block
        addTaint(d.getTaint());
        // ---------- Original Method ----------
        //if (mSplitView != null) {
            //mSplitView.setSplitBackground(d);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.434 -0400", hash_original_method = "1D010261269A6D78FBB7E8684C141376", hash_generated_method = "695085B234CA0DA33558E2844A8BE646")
    public View getCustomView() {
        View varB4EAC82CA7396A68D541C85D26508E83_340003600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_340003600 = mActionView.getCustomNavigationView();
        varB4EAC82CA7396A68D541C85D26508E83_340003600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340003600;
        // ---------- Original Method ----------
        //return mActionView.getCustomNavigationView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.434 -0400", hash_original_method = "2440C8680C5986DA6B98061A5444C3DF", hash_generated_method = "CAA1EE4EC2E1B5B6AEC6B2AE2B4EB472")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1246821094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1246821094 = mActionView.getTitle();
        varB4EAC82CA7396A68D541C85D26508E83_1246821094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246821094;
        // ---------- Original Method ----------
        //return mActionView.getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.439 -0400", hash_original_method = "7C309AA3715DBCB025C148B6DD4FF98A", hash_generated_method = "77938F508F5E7DF726D78EEFE918F153")
    public CharSequence getSubtitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_964189725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_964189725 = mActionView.getSubtitle();
        varB4EAC82CA7396A68D541C85D26508E83_964189725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964189725;
        // ---------- Original Method ----------
        //return mActionView.getSubtitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.439 -0400", hash_original_method = "3CF23CB733C1A66BA695174D1D5C90F5", hash_generated_method = "82195CA4C4B6D1A9E78D6954821A4057")
    public int getNavigationMode() {
        int varEAA142AE97CC923611CFEB4857969BEA_1044656078 = (mActionView.getNavigationMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224436645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224436645;
        // ---------- Original Method ----------
        //return mActionView.getNavigationMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.440 -0400", hash_original_method = "FB6F75E61CAD1294F319FE9A20EDC0AA", hash_generated_method = "75D58070DC49BC4053170211083BBA57")
    public int getDisplayOptions() {
        int var0A196B6A925A1050E71EDF1CA21BAA1C_1102719737 = (mActionView.getDisplayOptions());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501331415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501331415;
        // ---------- Original Method ----------
        //return mActionView.getDisplayOptions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.442 -0400", hash_original_method = "6F680EB91F7327296F43077A9CFCB9CD", hash_generated_method = "4D06BE242EB3511185B729E05A76BED5")
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1030051082 = null; //Variable for return #1
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_438039314 = null; //Variable for return #2
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
            boolean var2B92093546C2716C766BC5924D507852_284316250 = (mode.dispatchOnCreate());
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
                varB4EAC82CA7396A68D541C85D26508E83_1030051082 = mode;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_438039314 = null;
        addTaint(callback.getTaint());
        ActionMode varA7E53CE21691AB073D9660D615818899_80543534; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_80543534 = varB4EAC82CA7396A68D541C85D26508E83_1030051082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_80543534 = varB4EAC82CA7396A68D541C85D26508E83_438039314;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_80543534.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_80543534;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.443 -0400", hash_original_method = "4981E6F1136ACFE06B622EFDD1F32611", hash_generated_method = "0E560677DF447E0C3890334A60593381")
    private void configureTab(Tab tab, int position) {
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
        addTaint(tab.getTaint());
        addTaint(position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.446 -0400", hash_original_method = "1EECF05398B0BE8AB00F4615B5278612", hash_generated_method = "DF854CE8649E1DA2F3E8FD271CADD779")
    @Override
    public void addTab(Tab tab) {
        addTab(tab, mTabs.isEmpty());
        addTaint(tab.getTaint());
        // ---------- Original Method ----------
        //addTab(tab, mTabs.isEmpty());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.448 -0400", hash_original_method = "654B3E709639F944F902BA5D9B821C89", hash_generated_method = "24FFC59B29B2791554A8C8337235B53E")
    @Override
    public void addTab(Tab tab, int position) {
        addTab(tab, position, mTabs.isEmpty());
        addTaint(tab.getTaint());
        addTaint(position);
        // ---------- Original Method ----------
        //addTab(tab, position, mTabs.isEmpty());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.459 -0400", hash_original_method = "89408631A5DFBB8696DA15288AA15329", hash_generated_method = "6894FE0DA72315361E2E4321D8BE02D3")
    @Override
    public void addTab(Tab tab, boolean setSelected) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, mTabs.size());
        {
            selectTab(tab);
        } //End block
        addTaint(tab.getTaint());
        addTaint(setSelected);
        // ---------- Original Method ----------
        //ensureTabsExist();
        //mTabScrollView.addTab(tab, setSelected);
        //configureTab(tab, mTabs.size());
        //if (setSelected) {
            //selectTab(tab);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.460 -0400", hash_original_method = "041C4C5A1F00C6CFE52123DF1D5CFA62", hash_generated_method = "1E61C3A9F584BCEDF75A485129FFA3C4")
    @Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        {
            selectTab(tab);
        } //End block
        addTaint(tab.getTaint());
        addTaint(position);
        addTaint(setSelected);
        // ---------- Original Method ----------
        //ensureTabsExist();
        //mTabScrollView.addTab(tab, position, setSelected);
        //configureTab(tab, position);
        //if (setSelected) {
            //selectTab(tab);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.482 -0400", hash_original_method = "086373AB3E22E85AEE50C2F735BD106D", hash_generated_method = "D65CD72F91ADD5A664104C8472EDC5FC")
    @Override
    public Tab newTab() {
        Tab varB4EAC82CA7396A68D541C85D26508E83_1441451303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1441451303 = new TabImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1441451303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441451303;
        // ---------- Original Method ----------
        //return new TabImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.482 -0400", hash_original_method = "D97BFE7F24375737332EF4EB210BF330", hash_generated_method = "D768F8C8B25606A13B01D9177D9D5ED5")
    @Override
    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
        addTaint(tab.getTaint());
        // ---------- Original Method ----------
        //removeTabAt(tab.getPosition());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.483 -0400", hash_original_method = "B3645E4F4AB7E9BBDE0315AEF0157D54", hash_generated_method = "42D2C43AC8C0B1E9CA4BBE96AE4CDE79")
    @Override
    public void removeTabAt(int position) {
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
        addTaint(position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.485 -0400", hash_original_method = "08E647315276EA6EFD361EFCDF66D68C", hash_generated_method = "EBDF2A35A72B4A105716B556726598E9")
    @Override
    public void selectTab(Tab tab) {
        {
            boolean var0D865F05ACCA97EEC09A4D554FCE6944_1146515818 = (getNavigationMode() != NAVIGATION_MODE_TABS);
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
            boolean var0609B2E91FA97D998D43ECA1A4058103_1221752184 = (!trans.isEmpty());
            {
                trans.commit();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.485 -0400", hash_original_method = "2AD2D5B38A8D730799170A69D020CCD7", hash_generated_method = "7157105383D7EAA14EC4C377656876D8")
    @Override
    public Tab getSelectedTab() {
        Tab varB4EAC82CA7396A68D541C85D26508E83_478207205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_478207205 = mSelectedTab;
        varB4EAC82CA7396A68D541C85D26508E83_478207205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_478207205;
        // ---------- Original Method ----------
        //return mSelectedTab;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.485 -0400", hash_original_method = "7329EA59D7EBE41DA23E0A3E55EEA1A2", hash_generated_method = "89C52738F3F16F9DBC1CC352AC4E6E84")
    @Override
    public int getHeight() {
        int varB6E80F54C86C59EC88E3A5A42628443F_1655669455 = (mContainerView.getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315307454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315307454;
        // ---------- Original Method ----------
        //return mContainerView.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.486 -0400", hash_original_method = "546A4715540EEE6F49A6EAAEA56C241C", hash_generated_method = "9B6F5E1BBF9ED1EA79DF35779E1A9F3A")
    @Override
    public void show() {
        show(true);
        // ---------- Original Method ----------
        //show(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.493 -0400", hash_original_method = "B9AB02E6F73BE3423F7A7521B424A639", hash_generated_method = "C73D4FD3DEA319CC97C26646FDED5A7C")
     void show(boolean markHiddenBeforeMode) {
        {
            mCurrentShowAnim.end();
        } //End block
        {
            boolean varA04FE79F70596AEDDC366BB1F9C953E0_1956859202 = (mContainerView.getVisibility() == View.VISIBLE);
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
        addTaint(markHiddenBeforeMode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.494 -0400", hash_original_method = "F98E692B5353704914249A64080F4E16", hash_generated_method = "809EDE9EA7E86B295613716B5BE48E04")
    @Override
    public void hide() {
        {
            mCurrentShowAnim.end();
        } //End block
        {
            boolean varADDBB77A9CB269D2E537C6D87A9B8737_697107913 = (mContainerView.getVisibility() == View.GONE);
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
                boolean varF225B1267295DB8E06979CA78868E507_1642526444 = (mSplitView != null && mSplitView.getVisibility() == View.VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.494 -0400", hash_original_method = "02F75CA35AA01FBE52A717B38FA758F7", hash_generated_method = "74CC1A611B10BD0F0C6A0271F96F40C5")
    public boolean isShowing() {
        boolean varFABAF10FC87FB52E607ED88B31859D35_496791375 = (mContainerView.getVisibility() == View.VISIBLE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49007320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_49007320;
        // ---------- Original Method ----------
        //return mContainerView.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.499 -0400", hash_original_method = "6F997D5B2915B28943A5CB4BD830D4B2", hash_generated_method = "2744289CB13921963AE2FCD07340B152")
     void animateToMode(boolean toActionMode) {
        {
            show(false);
        } //End block
        {
            mCurrentModeAnim.end();
        } //End block
        mActionView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
        mContextView.animateToVisibility(toActionMode ? View.VISIBLE : View.GONE);
        {
            boolean varFBD93DC9D1D6299B253C2D05796D3D2B_1079091020 = (mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed());
            {
                mTabScrollView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
            } //End block
        } //End collapsed parenthetic
        addTaint(toActionMode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.504 -0400", hash_original_method = "3EA212821B302B1822414F8223429D93", hash_generated_method = "D70D197866F2B2A0883BBB6BE40EC126")
    public Context getThemedContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_268474769 = null; //Variable for return #1
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
                boolean varDD6A9FFA4382518FE4FB51366D933575_17163756 = (targetThemeRes != 0 && mContext.getThemeResId() != targetThemeRes);
                {
                    mThemedContext = new ContextThemeWrapper(mContext, targetThemeRes);
                } //End block
                {
                    mThemedContext = mContext;
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_268474769 = mThemedContext;
        varB4EAC82CA7396A68D541C85D26508E83_268474769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_268474769;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.504 -0400", hash_original_method = "82CB01F3A317C5518DAD7B810C7481F9", hash_generated_method = "F19D492ACDDC38876E3FA77CC4A23850")
    @Override
    public void setCustomView(View view) {
        mActionView.setCustomNavigationView(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mActionView.setCustomNavigationView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.505 -0400", hash_original_method = "D405B9340EEDF523A821CB828A77247A", hash_generated_method = "838105C427C6D87EA1B82E3C5023CBD6")
    @Override
    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        mActionView.setCustomNavigationView(view);
        addTaint(view.getTaint());
        addTaint(layoutParams.getTaint());
        // ---------- Original Method ----------
        //view.setLayoutParams(layoutParams);
        //mActionView.setCustomNavigationView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.505 -0400", hash_original_method = "DE3A042A48DE08AEC88EC1C0AD695D6F", hash_generated_method = "1EF6672E48BAC8935F7834BAB430F750")
    @Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        mActionView.setDropdownAdapter(adapter);
        mActionView.setCallback(callback);
        addTaint(adapter.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mActionView.setDropdownAdapter(adapter);
        //mActionView.setCallback(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.506 -0400", hash_original_method = "DA5FE7663B58F3C2464F93A06566CD8E", hash_generated_method = "E67227602D7F58C8B60E8CE35F26E683")
    @Override
    public int getSelectedNavigationIndex() {
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_806446493 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            {
                Object var9E0D618A4EE8CC879C5AC350775986E3_990958193 = (mSelectedTab.getPosition());
            } //End flattened ternary
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            int var0DAE3350C64D0906A58D53288479EA2D_1809177020 = (mActionView.getDropdownSelectedPosition());
            //End case NAVIGATION_MODE_LIST 
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306905557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306905557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.526 -0400", hash_original_method = "29C3EDF1B0696DD606C19CEF5DFCB27A", hash_generated_method = "0459AB5A32F814F155979B4C0B50FF58")
    @Override
    public int getNavigationItemCount() {
        {
            Object var89E2E10FCA0BD2AE4927F6837981B59A_1844937552 = (mActionView.getNavigationMode());
            //Begin case NAVIGATION_MODE_TABS 
            int var81340BC1C620E3820A05E23DEE8223AF_136200270 = (mTabs.size());
            //End case NAVIGATION_MODE_TABS 
            //Begin case NAVIGATION_MODE_LIST 
            SpinnerAdapter adapter;
            adapter = mActionView.getDropdownAdapter();
            //End case NAVIGATION_MODE_LIST 
            //Begin case NAVIGATION_MODE_LIST 
            {
                Object varF7742EA74032E62C939C320B7B8C4E62_357183493 = (adapter.getCount());
            } //End flattened ternary
            //End case NAVIGATION_MODE_LIST 
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290743776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290743776;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.527 -0400", hash_original_method = "44E873137D601CC44196E7945B5F3744", hash_generated_method = "120CBDCD5E353F2FA4E0A53351AB247B")
    @Override
    public int getTabCount() {
        int varA0AA69837201731921DCB8C161D1B5BD_1472800292 = (mTabs.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869611025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869611025;
        // ---------- Original Method ----------
        //return mTabs.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.527 -0400", hash_original_method = "2CF769A940AAC419EB99620655E4C93A", hash_generated_method = "07FFFE552203FCD312AFEB2759610C96")
    @Override
    public void setNavigationMode(int mode) {
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
        addTaint(mode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.528 -0400", hash_original_method = "389BF0B1EF97627FAF399E95ED0D1079", hash_generated_method = "C2E37AECEB6996ECC17C1ECF3DE18397")
    @Override
    public Tab getTabAt(int index) {
        Tab varB4EAC82CA7396A68D541C85D26508E83_1771496613 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1771496613 = mTabs.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1771496613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1771496613;
        // ---------- Original Method ----------
        //return mTabs.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.528 -0400", hash_original_method = "246181C3E410F19AA68D711311C45E89", hash_generated_method = "5C44AB310152040AFE34D4DAE8CC2099")
    @Override
    public void setIcon(int resId) {
        mActionView.setIcon(resId);
        addTaint(resId);
        // ---------- Original Method ----------
        //mActionView.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.529 -0400", hash_original_method = "976AFC7A654132AA465D788A8B684BD0", hash_generated_method = "EB250D01167AF2BC68BAB1DADC9103F7")
    @Override
    public void setIcon(Drawable icon) {
        mActionView.setIcon(icon);
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //mActionView.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.529 -0400", hash_original_method = "629A6907FC2030BF835EC3846EE4C4B9", hash_generated_method = "218A843EBF7FEA3D733E5F202EC45E25")
    @Override
    public void setLogo(int resId) {
        mActionView.setLogo(resId);
        addTaint(resId);
        // ---------- Original Method ----------
        //mActionView.setLogo(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.529 -0400", hash_original_method = "563E995ECF1A81A300841064D1D1EC89", hash_generated_method = "437A2B058E64ACC79A4ECDC1B4F7E300")
    @Override
    public void setLogo(Drawable logo) {
        mActionView.setLogo(logo);
        addTaint(logo.getTaint());
        // ---------- Original Method ----------
        //mActionView.setLogo(logo);
    }

    
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.538 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "8F251D8FB2618CB877D06AB4E966D630")

        private ActionMode.Callback mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.539 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

        private MenuBuilder mMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.539 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "E98181B1669419FD7A308D60329FDF80")

        private WeakReference<View> mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.539 -0400", hash_original_method = "329ADB94B68F012647BA8B5F412D446E", hash_generated_method = "EB690C59C99DA9C6D91EA9F49BC255A4")
        public  ActionModeImpl(ActionMode.Callback callback) {
            mCallback = callback;
            mMenu = new MenuBuilder(getThemedContext())
                    .setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            mMenu.setCallback(this);
            // ---------- Original Method ----------
            //mCallback = callback;
            //mMenu = new MenuBuilder(getThemedContext())
                    //.setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            //mMenu.setCallback(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.540 -0400", hash_original_method = "51A0980A38EB9FD2F0CEA8B2697D7721", hash_generated_method = "A97AB569400D56EE8A4EB61B34E8DDB0")
        @Override
        public MenuInflater getMenuInflater() {
            MenuInflater varB4EAC82CA7396A68D541C85D26508E83_178292591 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_178292591 = new MenuInflater(getThemedContext());
            varB4EAC82CA7396A68D541C85D26508E83_178292591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_178292591;
            // ---------- Original Method ----------
            //return new MenuInflater(getThemedContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.540 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "5FC8863C73BC2979E4EDDD5ADB5FB0B2")
        @Override
        public Menu getMenu() {
            Menu varB4EAC82CA7396A68D541C85D26508E83_532244244 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_532244244 = mMenu;
            varB4EAC82CA7396A68D541C85D26508E83_532244244.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_532244244;
            // ---------- Original Method ----------
            //return mMenu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.551 -0400", hash_original_method = "55BDAC29AF3CEA463BE5A1AC1715A820", hash_generated_method = "41FFD3DFC622E45FCF410E1972BD0A6F")
        @Override
        public void finish() {
            {
                boolean var830761C64F0699CF4AD2D4B7B4D7E08E_685311347 = (mActionMode != this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.552 -0400", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "09CD291F58A645AF3A8E9CF913126DF5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.553 -0400", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "D652DC6F147721AAA063CDC00464DB91")
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                boolean var8B33BA39C48AC4211B5B4A48DBAC6104_706271831 = (mCallback.onCreateActionMode(this, mMenu));
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084639047 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084639047;
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //return mCallback.onCreateActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.553 -0400", hash_original_method = "D05FE6927B0D6D37D4F8F8E54FD54AC2", hash_generated_method = "5D17C2BEE0021A167441AF485D9BBF01")
        @Override
        public void setCustomView(View view) {
            mContextView.setCustomView(view);
            mCustomView = new WeakReference<View>(view);
            // ---------- Original Method ----------
            //mContextView.setCustomView(view);
            //mCustomView = new WeakReference<View>(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.553 -0400", hash_original_method = "EDCF93193B842CC10D4874A3847ED8B0", hash_generated_method = "52BE07C8D5DCC2CC3A61B2FB4480D0B7")
        @Override
        public void setSubtitle(CharSequence subtitle) {
            mContextView.setSubtitle(subtitle);
            addTaint(subtitle.getTaint());
            // ---------- Original Method ----------
            //mContextView.setSubtitle(subtitle);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.564 -0400", hash_original_method = "A400678911C36F7EF5F4C53636B8794A", hash_generated_method = "5E271C17E5CBFEB053CC011721A6D82E")
        @Override
        public void setTitle(CharSequence title) {
            mContextView.setTitle(title);
            addTaint(title.getTaint());
            // ---------- Original Method ----------
            //mContextView.setTitle(title);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.564 -0400", hash_original_method = "47F5B9C8307FB4AF11C6A2812A14A860", hash_generated_method = "12B649311EA5564B0D0292D4C3A6A0E4")
        @Override
        public void setTitle(int resId) {
            setTitle(mContext.getResources().getString(resId));
            addTaint(resId);
            // ---------- Original Method ----------
            //setTitle(mContext.getResources().getString(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.565 -0400", hash_original_method = "0B3678050067173199BE985BD486C4DF", hash_generated_method = "3E00FBD2E9936B4FECA817B91ED397FB")
        @Override
        public void setSubtitle(int resId) {
            setSubtitle(mContext.getResources().getString(resId));
            addTaint(resId);
            // ---------- Original Method ----------
            //setSubtitle(mContext.getResources().getString(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.565 -0400", hash_original_method = "B7C7D06E8A777BBCD952F14E250A3EF1", hash_generated_method = "E2C99BFB8E2D2580E7F6C31D4386C288")
        @Override
        public CharSequence getTitle() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_336555640 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_336555640 = mContextView.getTitle();
            varB4EAC82CA7396A68D541C85D26508E83_336555640.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_336555640;
            // ---------- Original Method ----------
            //return mContextView.getTitle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.566 -0400", hash_original_method = "117FD7BAEF9CDB7B98041D8B7F2D9548", hash_generated_method = "856C12336A9F3AFE481F10862F22F7CC")
        @Override
        public CharSequence getSubtitle() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1827729920 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1827729920 = mContextView.getSubtitle();
            varB4EAC82CA7396A68D541C85D26508E83_1827729920.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1827729920;
            // ---------- Original Method ----------
            //return mContextView.getSubtitle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.566 -0400", hash_original_method = "6445ACEDBE83E3C2D5AD83B96CDE83BC", hash_generated_method = "5A235470B6D1114D07467A7C00830239")
        @Override
        public View getCustomView() {
            View varB4EAC82CA7396A68D541C85D26508E83_2067467717 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2067467717 = mCustomView != null ? mCustomView.get() : null;
            varB4EAC82CA7396A68D541C85D26508E83_2067467717.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2067467717;
            // ---------- Original Method ----------
            //return mCustomView != null ? mCustomView.get() : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.566 -0400", hash_original_method = "811C79E6E9EF223E39B6355E1D511C3E", hash_generated_method = "97F30BD9F9B9AF11DC71997DE48A4B79")
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varEDF93C5517A51BAAA6230A19AB6D2347_204603792 = (mCallback.onActionItemClicked(this, item));
            } //End block
            addTaint(menu.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106342359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106342359;
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //return mCallback.onActionItemClicked(this, item);
            //} else {
                //return false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.567 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "A2CF4D0437BFEF81F64A913714948494")
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            addTaint(allMenusAreClosing);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.567 -0400", hash_original_method = "7D886846B59E57EE3CE79C98862AC926", hash_generated_method = "BFA1E9F71B9A1E17442BD704BAE5ABD2")
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varF5ECE34C03DAB72F995F7F65544DBA24_1153848643 = (!subMenu.hasVisibleItems());
            } //End collapsed parenthetic
            new MenuPopupHelper(getThemedContext(), subMenu).show();
            addTaint(subMenu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499844150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499844150;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.567 -0400", hash_original_method = "6B692B27380EC4C10CDFFF60DC2D0482", hash_generated_method = "2074465CD9A30183B1E5202C403E062E")
        public void onCloseSubMenu(SubMenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_method = "5641671D684852B976991F51D9F0AB3E", hash_generated_method = "E3A317673E8B22EAA6643922166D5730")
        public void onMenuModeChange(MenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            invalidate();
            mContextView.showOverflowMenu();
            addTaint(menu.getTaint());
            // ---------- Original Method ----------
            //if (mCallback == null) {
                //return;
            //}
            //invalidate();
            //mContextView.showOverflowMenu();
        }

        
    }


    
    public class TabImpl extends ActionBar.Tab {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "A287CCE930216100007A4CB68C5B72FA")

        private ActionBar.TabListener mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

        private Object mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

        private Drawable mIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

        private CharSequence mText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "174B31BAC3CD311BC4B15E933A0A1C91", hash_generated_field = "F05F3F248129871C9794FE1C8A5F9774")

        private CharSequence mContentDesc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "63D25B66A694A0AFDF9B25838EF1ADAD", hash_generated_field = "C9775047302D5C5D2E659A086E1EFAE7")

        private int mPosition = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.568 -0400", hash_original_method = "6BCFC14B7595CFA31D582BF6176C023E", hash_generated_method = "6BCFC14B7595CFA31D582BF6176C023E")
        public TabImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.579 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "8C8B8C1F0DE7199FCC5E3DD592A4ECDD")
        @Override
        public Object getTag() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1941179345 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1941179345 = mTag;
            varB4EAC82CA7396A68D541C85D26508E83_1941179345.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1941179345;
            // ---------- Original Method ----------
            //return mTag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.579 -0400", hash_original_method = "BB14A4918D906598A88E3D6A8128EA77", hash_generated_method = "CD3E0BC0FBD1B091D8986C5839EAB9DD")
        @Override
        public Tab setTag(Object tag) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_505659208 = null; //Variable for return #1
            mTag = tag;
            varB4EAC82CA7396A68D541C85D26508E83_505659208 = this;
            varB4EAC82CA7396A68D541C85D26508E83_505659208.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_505659208;
            // ---------- Original Method ----------
            //mTag = tag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.580 -0400", hash_original_method = "E24F48568604237F2413A93282202AA0", hash_generated_method = "7D05AD23FBE64D837B14A1CDFFAECAEB")
        public ActionBar.TabListener getCallback() {
            ActionBar.TabListener varB4EAC82CA7396A68D541C85D26508E83_1291791370 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1291791370 = mCallback;
            varB4EAC82CA7396A68D541C85D26508E83_1291791370.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1291791370;
            // ---------- Original Method ----------
            //return mCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.638 -0400", hash_original_method = "464280ABF8AEC5C77A1E9FBBDE9C172D", hash_generated_method = "3081AA7341D544488D427106D2A336F0")
        @Override
        public Tab setTabListener(ActionBar.TabListener callback) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_1968949715 = null; //Variable for return #1
            mCallback = callback;
            varB4EAC82CA7396A68D541C85D26508E83_1968949715 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1968949715.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1968949715;
            // ---------- Original Method ----------
            //mCallback = callback;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.639 -0400", hash_original_method = "564891C70D3FD9FDA6B8DDF54A8A1C12", hash_generated_method = "9A1DF22C263A6E33359B6936DEE35B93")
        @Override
        public View getCustomView() {
            View varB4EAC82CA7396A68D541C85D26508E83_1599952760 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1599952760 = mCustomView;
            varB4EAC82CA7396A68D541C85D26508E83_1599952760.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1599952760;
            // ---------- Original Method ----------
            //return mCustomView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.639 -0400", hash_original_method = "0927DBCB7C9D04ABD72A572D4EBE85DC", hash_generated_method = "D3EC6D8345134337B3B1A60011DCB8EE")
        @Override
        public Tab setCustomView(View view) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_1331831750 = null; //Variable for return #1
            mCustomView = view;
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1331831750 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1331831750.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1331831750;
            // ---------- Original Method ----------
            //mCustomView = view;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.640 -0400", hash_original_method = "AB0A301D41389C31F697384DEDEE9E45", hash_generated_method = "7F771533C5CB842202DE511E28F8E462")
        @Override
        public Tab setCustomView(int layoutResId) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_1282703179 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1282703179 = setCustomView(LayoutInflater.from(getThemedContext())
                    .inflate(layoutResId, null));
            addTaint(layoutResId);
            varB4EAC82CA7396A68D541C85D26508E83_1282703179.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1282703179;
            // ---------- Original Method ----------
            //return setCustomView(LayoutInflater.from(getThemedContext())
                    //.inflate(layoutResId, null));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.640 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "7A588BA856DC8EA61FCAFBA550081176")
        @Override
        public Drawable getIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1463388686 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1463388686 = mIcon;
            varB4EAC82CA7396A68D541C85D26508E83_1463388686.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1463388686;
            // ---------- Original Method ----------
            //return mIcon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.658 -0400", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "57869BAB6F36A51326C4A00D6DEAD2E3")
        @Override
        public int getPosition() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294913860 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294913860;
            // ---------- Original Method ----------
            //return mPosition;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.661 -0400", hash_original_method = "3F4169F86E913801B39145F8B5F1CF4A", hash_generated_method = "9BE30D60DD8D509C2095B8721378C660")
        public void setPosition(int position) {
            mPosition = position;
            // ---------- Original Method ----------
            //mPosition = position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.661 -0400", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "AE8995D3C92E44168F35F7368C628483")
        @Override
        public CharSequence getText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1020689649 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1020689649 = mText;
            varB4EAC82CA7396A68D541C85D26508E83_1020689649.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1020689649;
            // ---------- Original Method ----------
            //return mText;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.662 -0400", hash_original_method = "E054EF134439DF27250AEE851BCF79C2", hash_generated_method = "BCD3F544C3BF1F31D9F59CA99FC4B476")
        @Override
        public Tab setIcon(Drawable icon) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_984548191 = null; //Variable for return #1
            mIcon = icon;
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_984548191 = this;
            varB4EAC82CA7396A68D541C85D26508E83_984548191.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_984548191;
            // ---------- Original Method ----------
            //mIcon = icon;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.662 -0400", hash_original_method = "95CB6D2B1B424F33C131278F8466F7F6", hash_generated_method = "8C8C910A4C2D547CC23E2C2D0B31ED2D")
        @Override
        public Tab setIcon(int resId) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_927292624 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_927292624 = setIcon(mContext.getResources().getDrawable(resId));
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_927292624.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_927292624;
            // ---------- Original Method ----------
            //return setIcon(mContext.getResources().getDrawable(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.663 -0400", hash_original_method = "7912BF664F58A4FFF0C4F40EE3B2F065", hash_generated_method = "02C76F9A41B540189F64FD6E9EE4C24D")
        @Override
        public Tab setText(CharSequence text) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_870227028 = null; //Variable for return #1
            mText = text;
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_870227028 = this;
            varB4EAC82CA7396A68D541C85D26508E83_870227028.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_870227028;
            // ---------- Original Method ----------
            //mText = text;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.663 -0400", hash_original_method = "593BCE41C6DE3623B8717D7BF5F8858F", hash_generated_method = "B724496F87F9E3600DF8C1FC943C6123")
        @Override
        public Tab setText(int resId) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_572877478 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_572877478 = setText(mContext.getResources().getText(resId));
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_572877478.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_572877478;
            // ---------- Original Method ----------
            //return setText(mContext.getResources().getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.664 -0400", hash_original_method = "10821E84B4BC38351A9F8E96F9552B43", hash_generated_method = "5116FF2EF6D66BA582D4CB8F63A2B26D")
        @Override
        public void select() {
            selectTab(this);
            // ---------- Original Method ----------
            //selectTab(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.664 -0400", hash_original_method = "64BDEA3E085EE551443B27403AA215D4", hash_generated_method = "874A1C35AA541F5E1BC85843AF24B831")
        @Override
        public Tab setContentDescription(int resId) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_22837833 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_22837833 = setContentDescription(mContext.getResources().getText(resId));
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_22837833.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_22837833;
            // ---------- Original Method ----------
            //return setContentDescription(mContext.getResources().getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.671 -0400", hash_original_method = "DB5D720F6039044C737BC09541B22E5C", hash_generated_method = "F4D4D08FC9C46FBB9B40D27E0A3B88DD")
        @Override
        public Tab setContentDescription(CharSequence contentDesc) {
            Tab varB4EAC82CA7396A68D541C85D26508E83_515430635 = null; //Variable for return #1
            mContentDesc = contentDesc;
            {
                mTabScrollView.updateTab(mPosition);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_515430635 = this;
            varB4EAC82CA7396A68D541C85D26508E83_515430635.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_515430635;
            // ---------- Original Method ----------
            //mContentDesc = contentDesc;
            //if (mPosition >= 0) {
                //mTabScrollView.updateTab(mPosition);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.672 -0400", hash_original_method = "637498C982C6D53C6EA2D802031901B7", hash_generated_method = "6A3E607D645BA4AD3F71F7D44ACB5238")
        @Override
        public CharSequence getContentDescription() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_316159796 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_316159796 = mContentDesc;
            varB4EAC82CA7396A68D541C85D26508E83_316159796.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_316159796;
            // ---------- Original Method ----------
            //return mContentDesc;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.672 -0400", hash_original_field = "1DAB7A5A4134C7F1043C5C1922174FBD", hash_generated_field = "9F3E79EB7D1E278DB20A5BAE3BE7A3D3")

    private static String TAG = "ActionBarImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.672 -0400", hash_original_field = "F02C776F4DE519D379C4AB89E2307688", hash_generated_field = "922DD50457817C86B95E4BA329E92D4C")

    private static int CONTEXT_DISPLAY_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.672 -0400", hash_original_field = "23048044AB5ACB8CF5850D95EA35E50F", hash_generated_field = "AB4E24EB2B0905A4FEF91CF72EF1ABD6")

    private static int CONTEXT_DISPLAY_SPLIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.672 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "77C1039E64E2B0539E0B073E2A613D53")

    private static int INVALID_POSITION = -1;
}

