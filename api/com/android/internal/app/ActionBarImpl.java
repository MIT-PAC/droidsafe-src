package com.android.internal.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
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

import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import com.android.internal.view.menu.SubMenuBuilder;
import com.android.internal.widget.ActionBarContainer;
import com.android.internal.widget.ActionBarContextView;
import com.android.internal.widget.ActionBarView;
import com.android.internal.widget.ScrollingTabContainerView;

public class ActionBarImpl extends ActionBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.744 -0500", hash_original_field = "589587D96FFD75D97CAAB5CCF8A42FC4", hash_generated_field = "A902B2C04198EA61AF7D192A6DA0056B")

    private static final String TAG = "ActionBarImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.788 -0500", hash_original_field = "AD3E987A5876382CCE7F079E5DCBC2CC", hash_generated_field = "EA2D03099DA79401859240172CAF107E")

    private static final int CONTEXT_DISPLAY_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.791 -0500", hash_original_field = "93177A4A4122221255692B108704BB68", hash_generated_field = "ABD10F36CA3AAC8E102F094B8BBAC3E9")

    private static final int CONTEXT_DISPLAY_SPLIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.793 -0500", hash_original_field = "08744EB4FDECE919536D545565C93AB6", hash_generated_field = "573F42E475AF4A1C9735B52864183D48")
    
    private static final int INVALID_POSITION = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.746 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.749 -0500", hash_original_field = "70A2FBA0D93CC365683A79AD410E3736", hash_generated_field = "A1CC5C58DF7C0DCCCCFFCA493E0A62F0")

    private Context mThemedContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.751 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

    private Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.753 -0500", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.756 -0500", hash_original_field = "F0835DDC82578A0109B84C7705D73E6A", hash_generated_field = "3B5102E8A4555D5377D5546AD36E30EF")

    private ActionBarContainer mContainerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.758 -0500", hash_original_field = "426FC35843B14572D6FBC98B9C012094", hash_generated_field = "435589A395F4655E845140B48CC5DD82")

    private ActionBarView mActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.760 -0500", hash_original_field = "A5A9EDF61C66A197D158B006E66DA25C", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.762 -0500", hash_original_field = "697914BCC588648A228AE86640E2671D", hash_generated_field = "4B2A718FB491B6DDCF6D6F12DBDA30A4")

    private ActionBarContainer mSplitView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.764 -0500", hash_original_field = "A280952DD6B837BA6E44884878875510", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.766 -0500", hash_original_field = "AD923D267EC0F804E578816407CA8B0F", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.769 -0500", hash_original_field = "85D7A3B52766582FC03BE416751B5626", hash_generated_field = "2DE8BE827BC107C008436B0209722BF6")

    private ArrayList<TabImpl> mTabs = new ArrayList<TabImpl>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.772 -0500", hash_original_field = "64AFDC4EE8A1E19C4D1160B75369A9BF", hash_generated_field = "E2A3DD52B8E79318754411772B5ABC7F")

    private TabImpl mSelectedTab;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.775 -0500", hash_original_field = "F101AA52AECD1137CEF54BC2A4EA05DB", hash_generated_field = "2822997A4E0CF16ED36F9B5F7F7F88DD")

    private int mSavedTabPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.777 -0500", hash_original_field = "C88A4C5DD17B0498252830DDAB04C8E1", hash_generated_field = "C88A4C5DD17B0498252830DDAB04C8E1")
    
    ActionModeImpl mActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.779 -0500", hash_original_field = "BEDD9228BA62217EC5EC4E12ED60D452", hash_generated_field = "BEDD9228BA62217EC5EC4E12ED60D452")

    ActionMode mDeferredDestroyActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.781 -0500", hash_original_field = "DF2EF7E0E1A5263A29433A4282D9458F", hash_generated_field = "DF2EF7E0E1A5263A29433A4282D9458F")

    ActionMode.Callback mDeferredModeDestroyCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.783 -0500", hash_original_field = "6AF7E2610AF4B9BC0DC4CBF1DF822922", hash_generated_field = "E1595EB11EBE3E17FC85A0C8B6399279")
    
    private boolean mLastMenuVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.786 -0500", hash_original_field = "B6827A82094CD8EB8867EC01ACF68BD5", hash_generated_field = "11BF511A20694B14557F30E21D03698F")

    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners =
            new ArrayList<OnMenuVisibilityListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.796 -0500", hash_original_field = "254D9CB3C873B32AD6B7B63E2DD14FD4", hash_generated_field = "C12FFA93FDEE59EC3B20F05029DA9108")

    private int mContextDisplayMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.798 -0500", hash_original_field = "0AC89FE842E4BEB96AB08849C05310B7", hash_generated_field = "11F23D5F4B9A4FEB27E5A49E7106FEF0")

    private boolean mHasEmbeddedTabs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.801 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

    final Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.803 -0500", hash_original_field = "E682310941753B94BE1FECAC9286C6E9", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.805 -0500", hash_original_field = "26558BDB7224FB7C6975E0429964B985", hash_generated_field = "A15ADDA5892591962A8310C80A51790F")

    private Animator mCurrentShowAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.807 -0500", hash_original_field = "121E0F1A6E1EF2DFB1654BAF840D3BF4", hash_generated_field = "6CA587E5D3B3F2540E397F3FD2FB959C")

    private Animator mCurrentModeAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.809 -0500", hash_original_field = "7C3E06C81F4C9BD654B5C3575C5F179A", hash_generated_field = "C93BEC8818A2F937EE0E6D7461D0E0FD")

    private boolean mShowHideAnimationEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.811 -0500", hash_original_field = "B2D34DAB28A6988D84FE0BB74C5C7E9B", hash_generated_field = "B2D34DAB28A6988D84FE0BB74C5C7E9B")

    boolean mWasHiddenBeforeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.715 -0400", hash_original_field = "FCB094484C39025804ED780EC0133250", hash_generated_field = "5D15DFDE7BDCFD7555F6EB75013038EC")

    final AnimatorListener mHideListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.715 -0400", hash_original_method = "F963BB61325C11416F39E483670ED211", hash_generated_method = "B390DFB722C7C46D4BDE52128B843793")
        @Override
        public void onAnimationEnd(Animator animation) {
            
            {
                mContentView.setTranslationY(0);
                mContainerView.setTranslationY(0);
            } 
            {
                mSplitView.setVisibility(View.GONE);
            } 
            mContainerView.setVisibility(View.GONE);
            mContainerView.setTransitioning(false);
            mCurrentShowAnim = null;
            completeDeferredDestroyActionMode();
            addTaint(animation.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.716 -0400", hash_original_field = "D5E7E0178A4C43DE90969C434EEC1CD9", hash_generated_field = "694FC00EDEB7498761672131BAC2ADA2")

    final AnimatorListener mShowListener = new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.716 -0400", hash_original_method = "CA861A0A44A2878B5B0D20FC92104D63", hash_generated_method = "EF2053B78441E1DD818B82BE72053BC0")
        @Override
        public void onAnimationEnd(Animator animation) {
            
            mCurrentShowAnim = null;
            mContainerView.requestLayout();
            addTaint(animation.getTaint());
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.826 -0500", hash_original_method = "59F98BFDF3B79CD734A4E0F1D5C36E49", hash_generated_method = "69F2050FFD96847127CB5665DCEDDACD")
    
public ActionBarImpl(Activity activity) {
        mActivity = activity;
        Window window = activity.getWindow();
        View decor = window.getDecorView();
        init(decor);
        if (!mActivity.getWindow().hasFeature(Window.FEATURE_ACTION_BAR_OVERLAY)) {
            mContentView = decor.findViewById(android.R.id.content);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.829 -0500", hash_original_method = "8749FCFE1A7B0A0EC82F09729A7EA1FF", hash_generated_method = "43A927175507CC1CADECB64699784137")
    
public ActionBarImpl(Dialog dialog) {
        mDialog = dialog;
        init(dialog.getWindow().getDecorView());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.833 -0500", hash_original_method = "CD1B24EA492A78A5E57A77E5FDC89AEF", hash_generated_method = "AE61CA9AB4C4A9D8ED8CE7DAC2B5B53B")
    
private void init(View decor) {
        mContext = decor.getContext();
        mActionView = (ActionBarView) decor.findViewById(com.android.internal.R.id.action_bar);
        mContextView = (ActionBarContextView) decor.findViewById(
                com.android.internal.R.id.action_context_bar);
        mContainerView = (ActionBarContainer) decor.findViewById(
                com.android.internal.R.id.action_bar_container);
        mSplitView = (ActionBarContainer) decor.findViewById(
                com.android.internal.R.id.split_action_bar);

        if (mActionView == null || mContextView == null || mContainerView == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with a compatible window decor layout");
        }

        mActionView.setContextView(mContextView);
        mContextDisplayMode = mActionView.isSplitActionBar() ?
                CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL;

        // Older apps get the home button interaction enabled by default.
        // Newer apps need to enable it explicitly.
        setHomeButtonEnabled(mContext.getApplicationInfo().targetSdkVersion <
                Build.VERSION_CODES.ICE_CREAM_SANDWICH);

        setHasEmbeddedTabs(mContext.getResources().getBoolean(
                com.android.internal.R.bool.action_bar_embed_tabs));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.835 -0500", hash_original_method = "988D25E4BF24BB800BD6556DCD183591", hash_generated_method = "6D84C6D5CCDC88DDCC3F8AB0F56039C0")
    
public void onConfigurationChanged(Configuration newConfig) {
        setHasEmbeddedTabs(mContext.getResources().getBoolean(
                com.android.internal.R.bool.action_bar_embed_tabs));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.838 -0500", hash_original_method = "05911004B37CFCA0E1E3075964BC3E46", hash_generated_method = "01B4E351654E9CD2115F2EEC8CF19EA8")
    
private void setHasEmbeddedTabs(boolean hasEmbeddedTabs) {
        mHasEmbeddedTabs = hasEmbeddedTabs;
        // Switch tab layout configuration if needed
        if (!mHasEmbeddedTabs) {
            mActionView.setEmbeddedTabView(null);
            mContainerView.setTabContainer(mTabScrollView);
        } else {
            mContainerView.setTabContainer(null);
            mActionView.setEmbeddedTabView(mTabScrollView);
        }
        final boolean isInTabMode = getNavigationMode() == NAVIGATION_MODE_TABS;
        if (mTabScrollView != null) {
            mTabScrollView.setVisibility(isInTabMode ? View.VISIBLE : View.GONE);
        }
        mActionView.setCollapsable(!mHasEmbeddedTabs && isInTabMode);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.840 -0500", hash_original_method = "04F31515B176FCA9797E5A3B1AE2D925", hash_generated_method = "BD7672C45C085371D67A1A0A7EFCA934")
    
private void ensureTabsExist() {
        if (mTabScrollView != null) {
            return;
        }

        ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(mContext);

        if (mHasEmbeddedTabs) {
            tabScroller.setVisibility(View.VISIBLE);
            mActionView.setEmbeddedTabView(tabScroller);
        } else {
            tabScroller.setVisibility(getNavigationMode() == NAVIGATION_MODE_TABS ?
                    View.VISIBLE : View.GONE);
            mContainerView.setTabContainer(tabScroller);
        }
        mTabScrollView = tabScroller;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.842 -0500", hash_original_method = "FB60553060C0CBA07AA4AE6F5834D888", hash_generated_method = "FB60553060C0CBA07AA4AE6F5834D888")
    
void completeDeferredDestroyActionMode() {
        if (mDeferredModeDestroyCallback != null) {
            mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
            mDeferredDestroyActionMode = null;
            mDeferredModeDestroyCallback = null;
        }
    }

    /**
     * Enables or disables animation between show/hide states.
     * If animation is disabled using this method, animations in progress
     * will be finished.
     *
     * @param enabled true to animate, false to not animate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.845 -0500", hash_original_method = "F176835B5C4C66FE158A96087EB7976E", hash_generated_method = "90554C44D8E06A30046D0381F327F5B0")
    
public void setShowHideAnimationEnabled(boolean enabled) {
        mShowHideAnimationEnabled = enabled;
        if (!enabled && mCurrentShowAnim != null) {
            mCurrentShowAnim.end();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.847 -0500", hash_original_method = "432643F5D3E1C75318DA649F07995AE5", hash_generated_method = "06FE8914B1EB0BF5AD10C4C3AA614A5B")
    
public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mMenuVisibilityListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.849 -0500", hash_original_method = "602CC871D8636269B09601DAE53B0892", hash_generated_method = "D34717D95A6E49B45AE7686D9A6AE59B")
    
public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mMenuVisibilityListeners.remove(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.852 -0500", hash_original_method = "459C6E3BA33A1A612E205065B1C3E1DC", hash_generated_method = "F2EB8BDCC76C187C5D5584320C4540A6")
    
public void dispatchMenuVisibilityChanged(boolean isVisible) {
        if (isVisible == mLastMenuVisibility) {
            return;
        }
        mLastMenuVisibility = isVisible;

        final int count = mMenuVisibilityListeners.size();
        for (int i = 0; i < count; i++) {
            mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(isVisible);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.854 -0500", hash_original_method = "B07E8854D08E9349BCA465572774AD05", hash_generated_method = "B49168F02C21AB34A15EBD2EDF29B0F8")
    
@Override
    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(resId, mActionView, false));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.856 -0500", hash_original_method = "7B32C43910C34545BE6AF1945BAD78C2", hash_generated_method = "5E0076A2852A2A1633A21F72CF443B57")
    
@Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.859 -0500", hash_original_method = "7F0843FA34DCBF9EB20E04642D9BA553", hash_generated_method = "FE2A74D74A735F887DE69B2249DDCB2E")
    
@Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.862 -0500", hash_original_method = "F859D1EA93554E58B56470BC246367BB", hash_generated_method = "C23D1F263C58701F98F5E5BE42CC59CF")
    
@Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.865 -0500", hash_original_method = "6C96766F23C0B7039876B0F0E23B9AFF", hash_generated_method = "09A4DE75683954287726F9E14A82C10C")
    
@Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.868 -0500", hash_original_method = "C60EF70FF87399C557FC41651D29083C", hash_generated_method = "06F8DA8437D55536E6D1F97E24138F1C")
    
@Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.870 -0500", hash_original_method = "4D222159BA92CC275B5D5CB9ADE89E45", hash_generated_method = "823E952543E2C7D5FEA9BD33D02B4BB5")
    
@Override
    public void setHomeButtonEnabled(boolean enable) {
        mActionView.setHomeButtonEnabled(enable);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.872 -0500", hash_original_method = "93A6ED10F8DC44A47D2A5E40CE348C6E", hash_generated_method = "B0C8AA82AB93128DA6CA0FE0886B046F")
    
@Override
    public void setTitle(int resId) {
        setTitle(mContext.getString(resId));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.875 -0500", hash_original_method = "28BA950963DD65E7A01A305F037657F9", hash_generated_method = "6DF2D207489563A6B6D5C90516E2A6F7")
    
@Override
    public void setSubtitle(int resId) {
        setSubtitle(mContext.getString(resId));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.877 -0500", hash_original_method = "11EA30EC8C9A94D19D07ED1EA15B77B1", hash_generated_method = "9010AC61A7D12E25793655C9E61534CF")
    
public void setSelectedNavigationItem(int position) {
        switch (mActionView.getNavigationMode()) {
        case NAVIGATION_MODE_TABS:
            selectTab(mTabs.get(position));
            break;
        case NAVIGATION_MODE_LIST:
            mActionView.setDropdownSelectedPosition(position);
            break;
        default:
            throw new IllegalStateException(
                    "setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.879 -0500", hash_original_method = "B97B28074DE5FCD367C21E021091BD45", hash_generated_method = "7AD87EACB0D67CA074659FFC0D035990")
    
public void removeAllTabs() {
        cleanupTabs();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.882 -0500", hash_original_method = "62AE76DE88CDD8F4A1D9D70F05364203", hash_generated_method = "1CC92F98F3B0A9B5EC5EA91E374B2E31")
    
private void cleanupTabs() {
        if (mSelectedTab != null) {
            selectTab(null);
        }
        mTabs.clear();
        if (mTabScrollView != null) {
            mTabScrollView.removeAllTabs();
        }
        mSavedTabPosition = INVALID_POSITION;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.884 -0500", hash_original_method = "2496AA6E0C686AA709C048B4D9A978B1", hash_generated_method = "C8105AACBC3205B7DAE237AF5628B762")
    
public void setTitle(CharSequence title) {
        mActionView.setTitle(title);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.886 -0500", hash_original_method = "51EFE4022329006F8B97012193639D8C", hash_generated_method = "011B6F0B9961C315DDE5BA40AFF01FAD")
    
public void setSubtitle(CharSequence subtitle) {
        mActionView.setSubtitle(subtitle);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.888 -0500", hash_original_method = "3F11889B61BC98E428CD1B2A494BFC53", hash_generated_method = "C6AA158528894ABE9DF8EFA189E04194")
    
public void setDisplayOptions(int options) {
        mActionView.setDisplayOptions(options);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.891 -0500", hash_original_method = "728BC8FE52686E77081ACD4BE860295D", hash_generated_method = "9DDA303B71B4E583C8EEE7944DF19DFE")
    
public void setDisplayOptions(int options, int mask) {
        final int current = mActionView.getDisplayOptions(); 
        mActionView.setDisplayOptions((options & mask) | (current & ~mask));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.893 -0500", hash_original_method = "61B3599899498272F50206755C75E2FF", hash_generated_method = "BA5D648B283EA51E716AF550C3642D8C")
    
public void setBackgroundDrawable(Drawable d) {
        mContainerView.setPrimaryBackground(d);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.895 -0500", hash_original_method = "71E64D08C4AF72E9E040B3394527D26B", hash_generated_method = "CBA601994C0B9165D5346C41C3C4C8BD")
    
public void setStackedBackgroundDrawable(Drawable d) {
        mContainerView.setStackedBackground(d);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.898 -0500", hash_original_method = "228BA16930C30CB95A53923FA275FB3B", hash_generated_method = "4A9089FFA6288D4CA834C35EBF71F919")
    
public void setSplitBackgroundDrawable(Drawable d) {
        if (mSplitView != null) {
            mSplitView.setSplitBackground(d);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.900 -0500", hash_original_method = "1D010261269A6D78FBB7E8684C141376", hash_generated_method = "9A2AF51C7C5040F5D339D04CBCA0D797")
    
public View getCustomView() {
        return mActionView.getCustomNavigationView();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.902 -0500", hash_original_method = "2440C8680C5986DA6B98061A5444C3DF", hash_generated_method = "F7770439DDA936046EEE9C363F6579E9")
    
public CharSequence getTitle() {
        return mActionView.getTitle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.904 -0500", hash_original_method = "7C309AA3715DBCB025C148B6DD4FF98A", hash_generated_method = "F4A42BFA93C0DC5F321A12C6F6CCB2C9")
    
public CharSequence getSubtitle() {
        return mActionView.getSubtitle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.907 -0500", hash_original_method = "3CF23CB733C1A66BA695174D1D5C90F5", hash_generated_method = "87E2BC485374AD3DA29C87E180986AC9")
    
public int getNavigationMode() {
        return mActionView.getNavigationMode();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.909 -0500", hash_original_method = "FB6F75E61CAD1294F319FE9A20EDC0AA", hash_generated_method = "2346DD64CACD0ACED918230D22A18FE6")
    
public int getDisplayOptions() {
        return mActionView.getDisplayOptions();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.912 -0500", hash_original_method = "6F680EB91F7327296F43077A9CFCB9CD", hash_generated_method = "31E1BF4DC6AC888D27BC61BCC6D31BC0")
    
public ActionMode startActionMode(ActionMode.Callback callback) {
        boolean wasHidden = false;
        if (mActionMode != null) {
            wasHidden = mWasHiddenBeforeMode;
            mActionMode.finish();
        }

        mContextView.killMode();
        ActionModeImpl mode = new ActionModeImpl(callback);
        if (mode.dispatchOnCreate()) {
            mWasHiddenBeforeMode = !isShowing() || wasHidden;
            mode.invalidate();
            mContextView.initForMode(mode);
            animateToMode(true);
            if (mSplitView != null && mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
                // TODO animate this
                mSplitView.setVisibility(View.VISIBLE);
            }
            mContextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            mActionMode = mode;
            return mode;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.915 -0500", hash_original_method = "4981E6F1136ACFE06B622EFDD1F32611", hash_generated_method = "F942E13C8E11E0D9C18AEAB7106FEC54")
    
private void configureTab(Tab tab, int position) {
        final TabImpl tabi = (TabImpl) tab;
        final ActionBar.TabListener callback = tabi.getCallback();

        if (callback == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }

        tabi.setPosition(position);
        mTabs.add(position, tabi);

        final int count = mTabs.size();
        for (int i = position + 1; i < count; i++) {
            mTabs.get(i).setPosition(i);
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.917 -0500", hash_original_method = "1EECF05398B0BE8AB00F4615B5278612", hash_generated_method = "B000A8E351EB9373FC821CB94ABC9FE7")
    
@Override
    public void addTab(Tab tab) {
        addTab(tab, mTabs.isEmpty());
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.920 -0500", hash_original_method = "654B3E709639F944F902BA5D9B821C89", hash_generated_method = "A8D86E8DE1F71F00DDABAE3C04E1B026")
    
@Override
    public void addTab(Tab tab, int position) {
        addTab(tab, position, mTabs.isEmpty());
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.922 -0500", hash_original_method = "89408631A5DFBB8696DA15288AA15329", hash_generated_method = "A7D0C1B20548F4B7FDA1E0EC71D3FE64")
    
@Override
    public void addTab(Tab tab, boolean setSelected) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, mTabs.size());
        if (setSelected) {
            selectTab(tab);
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.925 -0500", hash_original_method = "041C4C5A1F00C6CFE52123DF1D5CFA62", hash_generated_method = "C8915EBC4EA2A4A10C780127CA89C807")
    
@Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        if (setSelected) {
            selectTab(tab);
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.927 -0500", hash_original_method = "086373AB3E22E85AEE50C2F735BD106D", hash_generated_method = "9D5C866B00C7B3361F7D3ADAAEAB1705")
    
@Override
    public Tab newTab() {
        return new TabImpl();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.929 -0500", hash_original_method = "D97BFE7F24375737332EF4EB210BF330", hash_generated_method = "8FD5BF8357B1A35912B20AE108A8748D")
    
@Override
    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.933 -0500", hash_original_method = "B3645E4F4AB7E9BBDE0315AEF0157D54", hash_generated_method = "0364B6548ED33538CDC52665C277B169")
    
@Override
    public void removeTabAt(int position) {
        if (mTabScrollView == null) {
            // No tabs around to remove
            return;
        }

        int selectedTabPosition = mSelectedTab != null
                ? mSelectedTab.getPosition() : mSavedTabPosition;
        mTabScrollView.removeTabAt(position);
        TabImpl removedTab = mTabs.remove(position);
        if (removedTab != null) {
            removedTab.setPosition(-1);
        }

        final int newTabCount = mTabs.size();
        for (int i = position; i < newTabCount; i++) {
            mTabs.get(i).setPosition(i);
        }

        if (selectedTabPosition == position) {
            selectTab(mTabs.isEmpty() ? null : mTabs.get(Math.max(0, position - 1)));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.936 -0500", hash_original_method = "08E647315276EA6EFD361EFCDF66D68C", hash_generated_method = "B48CDD815A64CE8C7C14E64631138814")
    
@Override
    public void selectTab(Tab tab) {
        if (getNavigationMode() != NAVIGATION_MODE_TABS) {
            mSavedTabPosition = tab != null ? tab.getPosition() : INVALID_POSITION;
            return;
        }

        final FragmentTransaction trans = mActivity.getFragmentManager().beginTransaction()
                .disallowAddToBackStack();

        if (mSelectedTab == tab) {
            if (mSelectedTab != null) {
                mSelectedTab.getCallback().onTabReselected(mSelectedTab, trans);
                mTabScrollView.animateToTab(tab.getPosition());
            }
        } else {
            mTabScrollView.setTabSelected(tab != null ? tab.getPosition() : Tab.INVALID_POSITION);
            if (mSelectedTab != null) {
                mSelectedTab.getCallback().onTabUnselected(mSelectedTab, trans);
            }
            mSelectedTab = (TabImpl) tab;
            if (mSelectedTab != null) {
                mSelectedTab.getCallback().onTabSelected(mSelectedTab, trans);
            }
        }

        if (!trans.isEmpty()) {
            trans.commit();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.939 -0500", hash_original_method = "2AD2D5B38A8D730799170A69D020CCD7", hash_generated_method = "0BC25F24D3538E9BEA3EC00122537CA1")
    
@Override
    public Tab getSelectedTab() {
        return mSelectedTab;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.941 -0500", hash_original_method = "7329EA59D7EBE41DA23E0A3E55EEA1A2", hash_generated_method = "E566B12BB6F9E949129FCEA1D2F3D107")
    
@Override
    public int getHeight() {
        return mContainerView.getHeight();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.943 -0500", hash_original_method = "546A4715540EEE6F49A6EAAEA56C241C", hash_generated_method = "16A3477A5FD6C20C11597D7130F84995")
    
@Override
    public void show() {
        show(true);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.945 -0500", hash_original_method = "B9AB02E6F73BE3423F7A7521B424A639", hash_generated_method = "B9AB02E6F73BE3423F7A7521B424A639")
    
void show(boolean markHiddenBeforeMode) {
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.end();
        }
        if (mContainerView.getVisibility() == View.VISIBLE) {
            if (markHiddenBeforeMode) mWasHiddenBeforeMode = false;
            return;
        }
        mContainerView.setVisibility(View.VISIBLE);

        if (mShowHideAnimationEnabled) {
            mContainerView.setAlpha(0);
            AnimatorSet anim = new AnimatorSet();
            AnimatorSet.Builder b = anim.play(ObjectAnimator.ofFloat(mContainerView, "alpha", 1));
            if (mContentView != null) {
                b.with(ObjectAnimator.ofFloat(mContentView, "translationY",
                        -mContainerView.getHeight(), 0));
                mContainerView.setTranslationY(-mContainerView.getHeight());
                b.with(ObjectAnimator.ofFloat(mContainerView, "translationY", 0));
            }
            if (mSplitView != null && mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
                mSplitView.setAlpha(0);
                mSplitView.setVisibility(View.VISIBLE);
                b.with(ObjectAnimator.ofFloat(mSplitView, "alpha", 1));
            }
            anim.addListener(mShowListener);
            mCurrentShowAnim = anim;
            anim.start();
        } else {
            mContainerView.setAlpha(1);
            mContainerView.setTranslationY(0);
            mShowListener.onAnimationEnd(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.948 -0500", hash_original_method = "F98E692B5353704914249A64080F4E16", hash_generated_method = "DA4776B9E167DFD9E29E523A885B4E15")
    
@Override
    public void hide() {
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.end();
        }
        if (mContainerView.getVisibility() == View.GONE) {
            return;
        }

        if (mShowHideAnimationEnabled) {
            mContainerView.setAlpha(1);
            mContainerView.setTransitioning(true);
            AnimatorSet anim = new AnimatorSet();
            AnimatorSet.Builder b = anim.play(ObjectAnimator.ofFloat(mContainerView, "alpha", 0));
            if (mContentView != null) {
                b.with(ObjectAnimator.ofFloat(mContentView, "translationY",
                        0, -mContainerView.getHeight()));
                b.with(ObjectAnimator.ofFloat(mContainerView, "translationY",
                        -mContainerView.getHeight()));
            }
            if (mSplitView != null && mSplitView.getVisibility() == View.VISIBLE) {
                mSplitView.setAlpha(1);
                b.with(ObjectAnimator.ofFloat(mSplitView, "alpha", 0));
            }
            anim.addListener(mHideListener);
            mCurrentShowAnim = anim;
            anim.start();
        } else {
            mHideListener.onAnimationEnd(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.951 -0500", hash_original_method = "02F75CA35AA01FBE52A717B38FA758F7", hash_generated_method = "2F9BA336B239F27FB6853846F398B7B7")
    
public boolean isShowing() {
        return mContainerView.getVisibility() == View.VISIBLE;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.954 -0500", hash_original_method = "6F997D5B2915B28943A5CB4BD830D4B2", hash_generated_method = "6F997D5B2915B28943A5CB4BD830D4B2")
    
void animateToMode(boolean toActionMode) {
        if (toActionMode) {
            show(false);
        }
        if (mCurrentModeAnim != null) {
            mCurrentModeAnim.end();
        }

        mActionView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
        mContextView.animateToVisibility(toActionMode ? View.VISIBLE : View.GONE);
        if (mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed()) {
            mTabScrollView.animateToVisibility(toActionMode ? View.GONE : View.VISIBLE);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.956 -0500", hash_original_method = "3EA212821B302B1822414F8223429D93", hash_generated_method = "10A02A47A5C0776B31F50B6F4879E5B9")
    
public Context getThemedContext() {
        if (mThemedContext == null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme currentTheme = mContext.getTheme();
            currentTheme.resolveAttribute(com.android.internal.R.attr.actionBarWidgetTheme,
                    outValue, true);
            final int targetThemeRes = outValue.resourceId;
            
            if (targetThemeRes != 0 && mContext.getThemeResId() != targetThemeRes) {
                mThemedContext = new ContextThemeWrapper(mContext, targetThemeRes);
            } else {
                mThemedContext = mContext;
            }
        }
        return mThemedContext;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.093 -0500", hash_original_method = "82CB01F3A317C5518DAD7B810C7481F9", hash_generated_method = "662AC26A7B76CEB9BDE72E37DFE47CDB")
    
@Override
    public void setCustomView(View view) {
        mActionView.setCustomNavigationView(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.095 -0500", hash_original_method = "D405B9340EEDF523A821CB828A77247A", hash_generated_method = "80AEE5122E402264EB1CD37050263FDD")
    
@Override
    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        mActionView.setCustomNavigationView(view);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.097 -0500", hash_original_method = "DE3A042A48DE08AEC88EC1C0AD695D6F", hash_generated_method = "CAFD72557CCD1E6EA0BF01F1E84C7307")
    
@Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        mActionView.setDropdownAdapter(adapter);
        mActionView.setCallback(callback);

        callback.onNavigationItemSelected(0, 0);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.100 -0500", hash_original_method = "DA5FE7663B58F3C2464F93A06566CD8E", hash_generated_method = "10ACC50765C56476404AE0E3B9E81032")
    
@Override
    public int getSelectedNavigationIndex() {
        switch (mActionView.getNavigationMode()) {
            case NAVIGATION_MODE_TABS:
                return mSelectedTab != null ? mSelectedTab.getPosition() : -1;
            case NAVIGATION_MODE_LIST:
                return mActionView.getDropdownSelectedPosition();
            default:
                return -1;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.103 -0500", hash_original_method = "29C3EDF1B0696DD606C19CEF5DFCB27A", hash_generated_method = "7A1E5EA2901F73070A757CC2FBB0154B")
    
@Override
    public int getNavigationItemCount() {
        switch (mActionView.getNavigationMode()) {
            case NAVIGATION_MODE_TABS:
                return mTabs.size();
            case NAVIGATION_MODE_LIST:
                SpinnerAdapter adapter = mActionView.getDropdownAdapter();
                return adapter != null ? adapter.getCount() : 0;
            default:
                return 0;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.105 -0500", hash_original_method = "44E873137D601CC44196E7945B5F3744", hash_generated_method = "48D098F3AA342AED1DA251A75DB322F0")
    
@Override
    public int getTabCount() {
        return mTabs.size();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.108 -0500", hash_original_method = "2CF769A940AAC419EB99620655E4C93A", hash_generated_method = "8B20EE5BD126170C63D6927F5EB20101")
    
@Override
    public void setNavigationMode(int mode) {
        final int oldMode = mActionView.getNavigationMode();
        switch (oldMode) {
            case NAVIGATION_MODE_TABS:
                mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                mTabScrollView.setVisibility(View.GONE);
                break;
        }
        mActionView.setNavigationMode(mode);
        switch (mode) {
            case NAVIGATION_MODE_TABS:
                ensureTabsExist();
                mTabScrollView.setVisibility(View.VISIBLE);
                if (mSavedTabPosition != INVALID_POSITION) {
                    setSelectedNavigationItem(mSavedTabPosition);
                    mSavedTabPosition = INVALID_POSITION;
                }
                break;
        }
        mActionView.setCollapsable(mode == NAVIGATION_MODE_TABS && !mHasEmbeddedTabs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.111 -0500", hash_original_method = "389BF0B1EF97627FAF399E95ED0D1079", hash_generated_method = "50CE8D6AAADFE72BE0440C67F4304056")
    
@Override
    public Tab getTabAt(int index) {
        return mTabs.get(index);
    }
    
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.960 -0500", hash_original_field = "E2F920D760DEB2BCDAE7988D1DB3FA5A", hash_generated_field = "8F251D8FB2618CB877D06AB4E966D630")

        private ActionMode.Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.963 -0500", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

        private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.965 -0500", hash_original_field = "C906BD4540B62EAD5CC30546138AD174", hash_generated_field = "E98181B1669419FD7A308D60329FDF80")

        private WeakReference<View> mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.968 -0500", hash_original_method = "329ADB94B68F012647BA8B5F412D446E", hash_generated_method = "BFA9BEB4EB63236782D0109DC312DCE8")
        
public ActionModeImpl(ActionMode.Callback callback) {
            mCallback = callback;
            mMenu = new MenuBuilder(getThemedContext())
                    .setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            mMenu.setCallback(this);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.970 -0500", hash_original_method = "51A0980A38EB9FD2F0CEA8B2697D7721", hash_generated_method = "8B211486757DCD8FDBE89D66FD590DC6")
        
@Override
        public MenuInflater getMenuInflater() {
            return new MenuInflater(getThemedContext());
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.973 -0500", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "7AE22C739145027C00A176505D582411")
        
@Override
        public Menu getMenu() {
            return mMenu;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.976 -0500", hash_original_method = "55BDAC29AF3CEA463BE5A1AC1715A820", hash_generated_method = "2702B1B1958DFACDF786B304EC007ABE")
        
@Override
        public void finish() {
            if (mActionMode != this) {
                // Not the active action mode - no-op
                return;
            }

            // If we were hidden before the mode was shown, defer the onDestroy
            // callback until the animation is finished and associated relayout
            // is about to happen. This lets apps better anticipate visibility
            // and layout behavior.
            if (mWasHiddenBeforeMode) {
                mDeferredDestroyActionMode = this;
                mDeferredModeDestroyCallback = mCallback;
            } else {
                mCallback.onDestroyActionMode(this);
            }
            mCallback = null;
            animateToMode(false);

            // Clear out the context mode views after the animation finishes
            mContextView.closeMode();
            mActionView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);

            mActionMode = null;

            if (mWasHiddenBeforeMode) {
                hide();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.978 -0500", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "C7B93D882D43833903DA2C39ACBD8C5D")
        
@Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try {
                mCallback.onPrepareActionMode(this, mMenu);
            } finally {
                mMenu.startDispatchingItemsChanged();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.982 -0500", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "E6E10873790E802AB877A4675CDF0495")
        
public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try {
                return mCallback.onCreateActionMode(this, mMenu);
            } finally {
                mMenu.startDispatchingItemsChanged();
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.984 -0500", hash_original_method = "D05FE6927B0D6D37D4F8F8E54FD54AC2", hash_generated_method = "1FBE61DE5F83816F3ECADB1955A1A484")
        
@Override
        public void setCustomView(View view) {
            mContextView.setCustomView(view);
            mCustomView = new WeakReference<View>(view);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.987 -0500", hash_original_method = "EDCF93193B842CC10D4874A3847ED8B0", hash_generated_method = "2D8D62586374446E891CDCA0A4F3E5C2")
        
@Override
        public void setSubtitle(CharSequence subtitle) {
            mContextView.setSubtitle(subtitle);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.989 -0500", hash_original_method = "A400678911C36F7EF5F4C53636B8794A", hash_generated_method = "6FE956AD2E17F967C12914B8118E1056")
        
@Override
        public void setTitle(CharSequence title) {
            mContextView.setTitle(title);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.991 -0500", hash_original_method = "47F5B9C8307FB4AF11C6A2812A14A860", hash_generated_method = "8E8ABBBF28FC67BB40A8E773C0F996BA")
        
@Override
        public void setTitle(int resId) {
            setTitle(mContext.getResources().getString(resId));
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.994 -0500", hash_original_method = "0B3678050067173199BE985BD486C4DF", hash_generated_method = "5245609E990180EBD76FC0E8670A75E2")
        
@Override
        public void setSubtitle(int resId) {
            setSubtitle(mContext.getResources().getString(resId));
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.997 -0500", hash_original_method = "B7C7D06E8A777BBCD952F14E250A3EF1", hash_generated_method = "4DD6D44CA88ED674917C081E92FEAA02")
        
@Override
        public CharSequence getTitle() {
            return mContextView.getTitle();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:57.999 -0500", hash_original_method = "117FD7BAEF9CDB7B98041D8B7F2D9548", hash_generated_method = "293EA2C2F70781D8C1C2FAD8E8E2C091")
        
@Override
        public CharSequence getSubtitle() {
            return mContextView.getSubtitle();
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.002 -0500", hash_original_method = "6445ACEDBE83E3C2D5AD83B96CDE83BC", hash_generated_method = "B56B34EEE770AB2EAC40C80C0C9FF4E4")
        
@Override
        public View getCustomView() {
            return mCustomView != null ? mCustomView.get() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.005 -0500", hash_original_method = "811C79E6E9EF223E39B6355E1D511C3E", hash_generated_method = "D4C015DD6BE05239AA42D07B61329435")
        
public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            if (mCallback != null) {
                return mCallback.onActionItemClicked(this, item);
            } else {
                return false;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.007 -0500", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "4D4803CF510865F4B4AFFF9A54E896F6")
        
public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.010 -0500", hash_original_method = "7D886846B59E57EE3CE79C98862AC926", hash_generated_method = "89A8DAA8441F6F57B67CD05CC89D26D2")
        
public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            if (mCallback == null) {
                return false;
            }

            if (!subMenu.hasVisibleItems()) {
                return true;
            }

            new MenuPopupHelper(getThemedContext(), subMenu).show();
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.012 -0500", hash_original_method = "6B692B27380EC4C10CDFFF60DC2D0482", hash_generated_method = "CCFD8A6AE905FBA10074FF834353817F")
        
public void onCloseSubMenu(SubMenuBuilder menu) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.015 -0500", hash_original_method = "5641671D684852B976991F51D9F0AB3E", hash_generated_method = "F4A7ECD466AC84F01B70E032EF3B74F1")
        
public void onMenuModeChange(MenuBuilder menu) {
            if (mCallback == null) {
                return;
            }
            invalidate();
            mContextView.showOverflowMenu();
        }
        
    }
    
    public class TabImpl extends ActionBar.Tab {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.021 -0500", hash_original_field = "081D189AB17477B95A9E0A1239036FAE", hash_generated_field = "A287CCE930216100007A4CB68C5B72FA")

        private ActionBar.TabListener mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.023 -0500", hash_original_field = "87CC02BABEBC2A0BC6D4C7D0ADFF58E9", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

        private Object mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.026 -0500", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

        private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.028 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "E579ED9F2DADADEB46C981CAFDEE5BA5")

        private CharSequence mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.031 -0500", hash_original_field = "CC57F53C911C650722642EE6265199E9", hash_generated_field = "F05F3F248129871C9794FE1C8A5F9774")

        private CharSequence mContentDesc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.033 -0500", hash_original_field = "C2FFC66869228F7A048120289D108DB1", hash_generated_field = "C9775047302D5C5D2E659A086E1EFAE7")

        private int mPosition = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.035 -0500", hash_original_field = "ADD711F109703E2EAF61E2AD917F3FB6", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.774 -0400", hash_original_method = "6BCFC14B7595CFA31D582BF6176C023E", hash_generated_method = "6BCFC14B7595CFA31D582BF6176C023E")
        public TabImpl ()
        {
            //Synthesized constructor
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.038 -0500", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "DCC8ACEA9A5B231434FD66ADDF1B8C79")
        
@Override
        public Object getTag() {
            return mTag;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.041 -0500", hash_original_method = "BB14A4918D906598A88E3D6A8128EA77", hash_generated_method = "B20A855FA7B582BFB52453C85E611299")
        
@Override
        public Tab setTag(Object tag) {
            mTag = tag;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.043 -0500", hash_original_method = "E24F48568604237F2413A93282202AA0", hash_generated_method = "32C6BE84F04436F3677790E8804C0DA1")
        
public ActionBar.TabListener getCallback() {
            return mCallback;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.046 -0500", hash_original_method = "464280ABF8AEC5C77A1E9FBBDE9C172D", hash_generated_method = "3E8C5211C65E6ADE3E320A4B82D8E94A")
        @DSVerified
        @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
        public Tab setTabListener(ActionBar.TabListener callback) {
            mCallback = callback;
            FragmentManager fragmentManager = mActivity.getFragmentManager();
            callback.onTabSelected(getSelectedTab(), fragmentManager.beginTransaction()); 
            callback.onTabReselected(getSelectedTab(), fragmentManager.beginTransaction()); 
            callback.onTabUnselected(getSelectedTab(), fragmentManager.beginTransaction()); 
            return this;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.048 -0500", hash_original_method = "564891C70D3FD9FDA6B8DDF54A8A1C12", hash_generated_method = "EE615B985899230FF1A357791D20A997")
        
@Override
        public View getCustomView() {
            return mCustomView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.051 -0500", hash_original_method = "0927DBCB7C9D04ABD72A572D4EBE85DC", hash_generated_method = "633D424826C66B1ECA9B33DAC59CC3D5")
        
@Override
        public Tab setCustomView(View view) {
            mCustomView = view;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.054 -0500", hash_original_method = "AB0A301D41389C31F697384DEDEE9E45", hash_generated_method = "AE2B8B9639C822685362F3B5F39395C5")
        
@Override
        public Tab setCustomView(int layoutResId) {
            return setCustomView(LayoutInflater.from(getThemedContext())
                    .inflate(layoutResId, null));
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.057 -0500", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "2D4BF89F1DD6498E5C4BF0AF82795BD2")
        
@Override
        public Drawable getIcon() {
            return mIcon;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.060 -0500", hash_original_method = "88750DD9C7394A9CF6B657A7AF77F3EB", hash_generated_method = "4026820EBAF439592E54F198E42D289A")
        
@Override
        public int getPosition() {
            return mPosition;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.062 -0500", hash_original_method = "3F4169F86E913801B39145F8B5F1CF4A", hash_generated_method = "972973E6BF0687258C59BB9115998DF2")
        
public void setPosition(int position) {
            mPosition = position;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.065 -0500", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "77BAE6FE5EC9BD84AD78FB3001D2FC2D")
        
@Override
        public CharSequence getText() {
            return mText;
        }

        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.068 -0500", hash_original_method = "E054EF134439DF27250AEE851BCF79C2", hash_generated_method = "AB9E1C266740CED185E4A8A4D5C413A1")
        
@Override
        public Tab setIcon(Drawable icon) {
            mIcon = icon;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.070 -0500", hash_original_method = "95CB6D2B1B424F33C131278F8466F7F6", hash_generated_method = "4511505DFCFFA54B9E489ACD56E87DC3")
        
@Override
        public Tab setIcon(int resId) {
            return setIcon(mContext.getResources().getDrawable(resId));
        }

        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.073 -0500", hash_original_method = "7912BF664F58A4FFF0C4F40EE3B2F065", hash_generated_method = "D5E996199A3A836F90CE1310E9966D09")
        
@Override
        public Tab setText(CharSequence text) {
            mText = text;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.076 -0500", hash_original_method = "593BCE41C6DE3623B8717D7BF5F8858F", hash_generated_method = "EF76288B367CC2EFB3DF33A055A9E723")
        
@Override
        public Tab setText(int resId) {
            return setText(mContext.getResources().getText(resId));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.079 -0500", hash_original_method = "10821E84B4BC38351A9F8E96F9552B43", hash_generated_method = "DB6E401D4A4D05CBBAFB2993189095C3")
        
@Override
        public void select() {
            selectTab(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.081 -0500", hash_original_method = "64BDEA3E085EE551443B27403AA215D4", hash_generated_method = "BE498C476E560CE35A53903E8B58D967")
        
@Override
        public Tab setContentDescription(int resId) {
            return setContentDescription(mContext.getResources().getText(resId));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.084 -0500", hash_original_method = "DB5D720F6039044C737BC09541B22E5C", hash_generated_method = "A5CE53A10416040DF87A1AF00601331E")
        
@Override
        public Tab setContentDescription(CharSequence contentDesc) {
            mContentDesc = contentDesc;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.087 -0500", hash_original_method = "637498C982C6D53C6EA2D802031901B7", hash_generated_method = "183EED2227C807332D563C22A6557EF9")
        
@Override
        public CharSequence getContentDescription() {
            return mContentDesc;
        }
        
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.113 -0500", hash_original_method = "246181C3E410F19AA68D711311C45E89", hash_generated_method = "E16D88CE4898A29D4E621C68C71644D5")
    
@Override
    public void setIcon(int resId) {
        mActionView.setIcon(resId);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.116 -0500", hash_original_method = "976AFC7A654132AA465D788A8B684BD0", hash_generated_method = "4899649FBCC36499092C67F5180B2E33")
    
@Override
    public void setIcon(Drawable icon) {
        mActionView.setIcon(icon);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.118 -0500", hash_original_method = "629A6907FC2030BF835EC3846EE4C4B9", hash_generated_method = "8B6EDE821A5D90178C18D6F8A3D0EB86")
    
@Override
    public void setLogo(int resId) {
        mActionView.setLogo(resId);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.120 -0500", hash_original_method = "563E995ECF1A81A300841064D1D1EC89", hash_generated_method = "139CCE34C27B19F0D8B455860355231B")
    
@Override
    public void setLogo(Drawable logo) {
        mActionView.setLogo(logo);
    }
}

