/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplBase extends ActionBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.432 -0400", hash_original_field = "AD3E987A5876382CCE7F079E5DCBC2CC", hash_generated_field = "EA2D03099DA79401859240172CAF107E")

    private static final int CONTEXT_DISPLAY_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.436 -0400", hash_original_field = "93177A4A4122221255692B108704BB68", hash_generated_field = "ABD10F36CA3AAC8E102F094B8BBAC3E9")

    private static final int CONTEXT_DISPLAY_SPLIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.440 -0400", hash_original_field = "08744EB4FDECE919536D545565C93AB6", hash_generated_field = "573F42E475AF4A1C9735B52864183D48")

    private static final int INVALID_POSITION = -1;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.934 -0400", hash_original_method = "4B4645B5DB8D05CA8E59B593A8ABD20B", hash_generated_method = "3B5932F0AA0351E97E60414CC14AF99F")
    
private static boolean checkShowingFlags(boolean hiddenByApp, boolean hiddenBySystem,
            boolean showingForMode) {
        if (showingForMode) {
            return true;
        } else if (hiddenByApp || hiddenBySystem) {
            return false;
        } else {
            return true;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.353 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.356 -0400", hash_original_field = "70A2FBA0D93CC365683A79AD410E3736", hash_generated_field = "A1CC5C58DF7C0DCCCCFFCA493E0A62F0")

    private Context mThemedContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.360 -0400", hash_original_field = "BA6F7673D5979BBA8C21EC95A05E041C", hash_generated_field = "611AA455DC4EC3E0A8066F2B4A4581C2")

    private ActionBarActivity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.364 -0400", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.367 -0400", hash_original_field = "6AF3FBB9AC557BEE651C9AF529BEE4F9", hash_generated_field = "366FF52FC1D532CC2EB581C6B64EE05C")

    private ActionBarOverlayLayout mOverlayLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.372 -0400", hash_original_field = "F0835DDC82578A0109B84C7705D73E6A", hash_generated_field = "3B5102E8A4555D5377D5546AD36E30EF")

    private ActionBarContainer mContainerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.376 -0400", hash_original_field = "518D06E8E9B4387F0E05D8A641FB2BD9", hash_generated_field = "0052212E00D68AE7263FF53E81F0EAAE")

    private ViewGroup mTopVisibilityView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.380 -0400", hash_original_field = "426FC35843B14572D6FBC98B9C012094", hash_generated_field = "435589A395F4655E845140B48CC5DD82")

    private ActionBarView mActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.383 -0400", hash_original_field = "A5A9EDF61C66A197D158B006E66DA25C", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.386 -0400", hash_original_field = "697914BCC588648A228AE86640E2671D", hash_generated_field = "4B2A718FB491B6DDCF6D6F12DBDA30A4")

    private ActionBarContainer mSplitView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.390 -0400", hash_original_field = "A280952DD6B837BA6E44884878875510", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.394 -0400", hash_original_field = "AD923D267EC0F804E578816407CA8B0F", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.397 -0400", hash_original_field = "85D7A3B52766582FC03BE416751B5626", hash_generated_field = "2DE8BE827BC107C008436B0209722BF6")

    private ArrayList<TabImpl> mTabs = new ArrayList<TabImpl>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.402 -0400", hash_original_field = "64AFDC4EE8A1E19C4D1160B75369A9BF", hash_generated_field = "E2A3DD52B8E79318754411772B5ABC7F")

    private TabImpl mSelectedTab;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.407 -0400", hash_original_field = "F101AA52AECD1137CEF54BC2A4EA05DB", hash_generated_field = "2822997A4E0CF16ED36F9B5F7F7F88DD")

    private int mSavedTabPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.411 -0400", hash_original_field = "9E994AB8A883EB68259E4A8B680B2444", hash_generated_field = "5EE77C76B1EEF3FB04A69D947EE78307")

    private boolean mDisplayHomeAsUpSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.414 -0400", hash_original_field = "C88A4C5DD17B0498252830DDAB04C8E1", hash_generated_field = "C88A4C5DD17B0498252830DDAB04C8E1")

    ActionModeImpl mActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.417 -0400", hash_original_field = "BEDD9228BA62217EC5EC4E12ED60D452", hash_generated_field = "BEDD9228BA62217EC5EC4E12ED60D452")

    ActionMode mDeferredDestroyActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.421 -0400", hash_original_field = "DF2EF7E0E1A5263A29433A4282D9458F", hash_generated_field = "DF2EF7E0E1A5263A29433A4282D9458F")

    ActionMode.Callback mDeferredModeDestroyCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.424 -0400", hash_original_field = "6AF7E2610AF4B9BC0DC4CBF1DF822922", hash_generated_field = "E1595EB11EBE3E17FC85A0C8B6399279")

    private boolean mLastMenuVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.428 -0400", hash_original_field = "B6827A82094CD8EB8867EC01ACF68BD5", hash_generated_field = "11BF511A20694B14557F30E21D03698F")

    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners =
            new ArrayList<OnMenuVisibilityListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.443 -0400", hash_original_field = "254D9CB3C873B32AD6B7B63E2DD14FD4", hash_generated_field = "C12FFA93FDEE59EC3B20F05029DA9108")

    private int mContextDisplayMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.446 -0400", hash_original_field = "0AC89FE842E4BEB96AB08849C05310B7", hash_generated_field = "11F23D5F4B9A4FEB27E5A49E7106FEF0")

    private boolean mHasEmbeddedTabs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.450 -0400", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

    final Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.454 -0400", hash_original_field = "E682310941753B94BE1FECAC9286C6E9", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.457 -0400", hash_original_field = "BC850F7FB8F545FF1B0F9D1F20C0BB4B", hash_generated_field = "9A789C4171CD9664D5132D25837B637C")

    private int mCurWindowVisibility = View.VISIBLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.461 -0400", hash_original_field = "D0D50ACE555C4CD3B7A0281C8FA68938", hash_generated_field = "953C29A0670945D3D39C3D8F163CC32A")

    private boolean mHiddenByApp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.465 -0400", hash_original_field = "98645B54985147E0B7B46861131D20B6", hash_generated_field = "8ECCDEDD5AFF12A31EBB697CE05413B2")

    private boolean mHiddenBySystem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.468 -0400", hash_original_field = "3818147978856536DE096CA24F32A25A", hash_generated_field = "B9A337419D7ACD2F9B531235C4E5C445")

    private boolean mShowingForMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.471 -0400", hash_original_field = "02CA146327F5CD0BF8BA4C742106B4E3", hash_generated_field = "BCD27FA119929EFACDCBB524F7829E52")

    private boolean mNowShowing = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.475 -0400", hash_original_field = "7C3E06C81F4C9BD654B5C3575C5F179A", hash_generated_field = "C93BEC8818A2F937EE0E6D7461D0E0FD")

    private boolean mShowHideAnimationEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.478 -0400", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.483 -0400", hash_original_method = "BA184EACCA7F936A666A0A7DBAA929EF", hash_generated_method = "C58695332178A4BFE2921873FCB64739")
    
    public ActionBarImplBase(ActionBarActivity activity, Callback callback) {
        mActivity = activity;
        mContext = activity;
        mCallback = callback;
        init(mActivity);
    }
    
    public ActionBarImplBase(ActionBarActivity activity, DSOnlyType dsonly) {
        mActivity = activity;
        mContext = activity;
        mCallback = null;
        init(mActivity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.488 -0400", hash_original_method = "BF5885D2B5FDFB8898701EA3F9AEEABF", hash_generated_method = "BCFE326357755157B898DD276A61C749")
    
private void init(ActionBarActivity activity) {
        mOverlayLayout = (ActionBarOverlayLayout) activity.findViewById(
                R.id.action_bar_overlay_layout);
        if (mOverlayLayout != null) {
            mOverlayLayout.setActionBar(this);
        }
        mActionView = (ActionBarView) activity.findViewById(R.id.action_bar);
        mContextView = (ActionBarContextView) activity.findViewById(R.id.action_context_bar);
        mContainerView = (ActionBarContainer) activity.findViewById(R.id.action_bar_container);
        mTopVisibilityView = (ViewGroup) activity.findViewById(R.id.top_action_bar);
        if (mTopVisibilityView == null) {
            mTopVisibilityView = mContainerView;
        }
        mSplitView = (ActionBarContainer) activity.findViewById(R.id.split_action_bar);

        if (mActionView == null || mContextView == null || mContainerView == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with a compatible window decor layout");
        }

        mActionView.setContextView(mContextView);
        mContextDisplayMode = mActionView.isSplitActionBar() ?
                CONTEXT_DISPLAY_SPLIT : CONTEXT_DISPLAY_NORMAL;

        // This was initially read from the action bar style
        final int current = mActionView.getDisplayOptions();
        final boolean homeAsUp = (current & DISPLAY_HOME_AS_UP) != 0;
        if (homeAsUp) {
            mDisplayHomeAsUpSet = true;
        }

        ActionBarPolicy abp = ActionBarPolicy.get(mContext);
        setHomeButtonEnabled(abp.enableHomeButtonByDefault() || homeAsUp);
        setHasEmbeddedTabs(abp.hasEmbeddedTabs());
        setTitle(mActivity.getTitle());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.492 -0400", hash_original_method = "6F7F2B35B9C2027A004C6D677654C097", hash_generated_method = "21ADCBB9DF36E3E82A933A6199D558B5")
    
public void onConfigurationChanged(Configuration newConfig) {
        setHasEmbeddedTabs(ActionBarPolicy.get(mContext).hasEmbeddedTabs());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.496 -0400", hash_original_method = "127B5236DFE6EE1335586FD606253B6B", hash_generated_method = "9BBB512555EC9D51A341F7BA07B7B0B9")
    
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
            if (isInTabMode) {
                mTabScrollView.setVisibility(View.VISIBLE);
            } else {
                mTabScrollView.setVisibility(View.GONE);
            }
        }
        mActionView.setCollapsable(!mHasEmbeddedTabs && isInTabMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.500 -0400", hash_original_method = "E8FAF5F30EDC3989BF71D1D5B79892E5", hash_generated_method = "4ED828FCB12AA328660158DA12881AA9")
    
public boolean hasNonEmbeddedTabs() {
        return !mHasEmbeddedTabs && getNavigationMode() == NAVIGATION_MODE_TABS;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.504 -0400", hash_original_method = "82CB01F3A317C5518DAD7B810C7481F9", hash_generated_method = "662AC26A7B76CEB9BDE72E37DFE47CDB")
    
@Override
    public void setCustomView(View view) {
        mActionView.setCustomNavigationView(view);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.508 -0400", hash_original_method = "D405B9340EEDF523A821CB828A77247A", hash_generated_method = "80AEE5122E402264EB1CD37050263FDD")
    
@Override
    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        mActionView.setCustomNavigationView(view);

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.511 -0400", hash_original_method = "B07E8854D08E9349BCA465572774AD05", hash_generated_method = "B49168F02C21AB34A15EBD2EDF29B0F8")
    
@Override
    public void setCustomView(int resId) {
        setCustomView(LayoutInflater.from(getThemedContext())
                .inflate(resId, mActionView, false));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.514 -0400", hash_original_method = "246181C3E410F19AA68D711311C45E89", hash_generated_method = "E16D88CE4898A29D4E621C68C71644D5")
    
@Override
    public void setIcon(int resId) {
        mActionView.setIcon(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.518 -0400", hash_original_method = "976AFC7A654132AA465D788A8B684BD0", hash_generated_method = "4899649FBCC36499092C67F5180B2E33")
    
@Override
    public void setIcon(Drawable icon) {
        mActionView.setIcon(icon);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.521 -0400", hash_original_method = "629A6907FC2030BF835EC3846EE4C4B9", hash_generated_method = "8B6EDE821A5D90178C18D6F8A3D0EB86")
    
@Override
    public void setLogo(int resId) {
        mActionView.setLogo(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.526 -0400", hash_original_method = "563E995ECF1A81A300841064D1D1EC89", hash_generated_method = "139CCE34C27B19F0D8B455860355231B")
    
@Override
    public void setLogo(Drawable logo) {
        mActionView.setLogo(logo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.529 -0400", hash_original_method = "DE3A042A48DE08AEC88EC1C0AD695D6F", hash_generated_method = "CAFD72557CCD1E6EA0BF01F1E84C7307")
    
@Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        mActionView.setDropdownAdapter(adapter);
        mActionView.setCallback(callback);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.533 -0400", hash_original_method = "11EA30EC8C9A94D19D07ED1EA15B77B1", hash_generated_method = "A263C575E28F68F3633464C281BB2290")
    
@Override
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.536 -0400", hash_original_method = "DA5FE7663B58F3C2464F93A06566CD8E", hash_generated_method = "10ACC50765C56476404AE0E3B9E81032")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.540 -0400", hash_original_method = "29C3EDF1B0696DD606C19CEF5DFCB27A", hash_generated_method = "7A1E5EA2901F73070A757CC2FBB0154B")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.544 -0400", hash_original_method = "2496AA6E0C686AA709C048B4D9A978B1", hash_generated_method = "E1C95AB977F6B4A656DF65F72BA7A064")
    
@Override
    public void setTitle(CharSequence title) {
        mActionView.setTitle(title);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.550 -0400", hash_original_method = "93A6ED10F8DC44A47D2A5E40CE348C6E", hash_generated_method = "B0C8AA82AB93128DA6CA0FE0886B046F")
    
@Override
    public void setTitle(int resId) {
        setTitle(mContext.getString(resId));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.554 -0400", hash_original_method = "51EFE4022329006F8B97012193639D8C", hash_generated_method = "F08465EF5B67028ED9709F6D6B13BE6A")
    
@Override
    public void setSubtitle(CharSequence subtitle) {
        mActionView.setSubtitle(subtitle);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.557 -0400", hash_original_method = "28BA950963DD65E7A01A305F037657F9", hash_generated_method = "6DF2D207489563A6B6D5C90516E2A6F7")
    
@Override
    public void setSubtitle(int resId) {
        setSubtitle(mContext.getString(resId));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.560 -0400", hash_original_method = "B1C55AA0F5B49B1332FF570B7B2F36EB", hash_generated_method = "42B8181F32DDCA393BAB5C3C73DC6338")
    
@Override
    public void setDisplayOptions(int options) {
        if ((options & DISPLAY_HOME_AS_UP) != 0) {
            mDisplayHomeAsUpSet = true;
        }
        mActionView.setDisplayOptions(options);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.564 -0400", hash_original_method = "FE5D3F3DAF9278FF1716E5B750F98001", hash_generated_method = "3680ED37DE173B98AE20099B2FE95B9A")
    
@Override
    public void setDisplayOptions(int options, int mask) {
        final int current = mActionView.getDisplayOptions();
        if ((mask & DISPLAY_HOME_AS_UP) != 0) {
            mDisplayHomeAsUpSet = true;
        }
        mActionView.setDisplayOptions((options & mask) | (current & ~mask));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.567 -0400", hash_original_method = "7B32C43910C34545BE6AF1945BAD78C2", hash_generated_method = "5E0076A2852A2A1633A21F72CF443B57")
    
@Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? DISPLAY_USE_LOGO : 0, DISPLAY_USE_LOGO);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.572 -0400", hash_original_method = "7F0843FA34DCBF9EB20E04642D9BA553", hash_generated_method = "FE2A74D74A735F887DE69B2249DDCB2E")
    
@Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? DISPLAY_SHOW_HOME : 0, DISPLAY_SHOW_HOME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.576 -0400", hash_original_method = "F859D1EA93554E58B56470BC246367BB", hash_generated_method = "C23D1F263C58701F98F5E5BE42CC59CF")
    
@Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? DISPLAY_HOME_AS_UP : 0, DISPLAY_HOME_AS_UP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.579 -0400", hash_original_method = "6C96766F23C0B7039876B0F0E23B9AFF", hash_generated_method = "09A4DE75683954287726F9E14A82C10C")
    
@Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? DISPLAY_SHOW_TITLE : 0, DISPLAY_SHOW_TITLE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.583 -0400", hash_original_method = "C60EF70FF87399C557FC41651D29083C", hash_generated_method = "06F8DA8437D55536E6D1F97E24138F1C")
    
@Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? DISPLAY_SHOW_CUSTOM : 0, DISPLAY_SHOW_CUSTOM);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.586 -0400", hash_original_method = "4D222159BA92CC275B5D5CB9ADE89E45", hash_generated_method = "823E952543E2C7D5FEA9BD33D02B4BB5")
    
@Override
    public void setHomeButtonEnabled(boolean enable) {
        mActionView.setHomeButtonEnabled(enable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.599 -0400", hash_original_method = "61B3599899498272F50206755C75E2FF", hash_generated_method = "32475A890CC41EA1B7B12A7556E3E586")
    
@Override
    public void setBackgroundDrawable(Drawable d) {
        mContainerView.setPrimaryBackground(d);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.602 -0400", hash_original_method = "1D010261269A6D78FBB7E8684C141376", hash_generated_method = "0FF0A29B82110F2EE9DA1B078DB9A45B")
    
@Override
    public View getCustomView() {
        return mActionView.getCustomNavigationView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.606 -0400", hash_original_method = "2440C8680C5986DA6B98061A5444C3DF", hash_generated_method = "EFFF82669C7C6DC7BE17C6B999D6667D")
    
@Override
    public CharSequence getTitle() {
        return mActionView.getTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.609 -0400", hash_original_method = "7C309AA3715DBCB025C148B6DD4FF98A", hash_generated_method = "3AB3562AEFA6597836C935738B5B199B")
    
@Override
    public CharSequence getSubtitle() {
        return mActionView.getSubtitle();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.613 -0400", hash_original_method = "3CF23CB733C1A66BA695174D1D5C90F5", hash_generated_method = "C8DC6AD91FF3895695F8D3EEB3C1A8FA")
    
@Override
    public int getNavigationMode() {
        return mActionView.getNavigationMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.617 -0400", hash_original_method = "2CF769A940AAC419EB99620655E4C93A", hash_generated_method = "8B20EE5BD126170C63D6927F5EB20101")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.621 -0400", hash_original_method = "FB6F75E61CAD1294F319FE9A20EDC0AA", hash_generated_method = "2EC56944B893417EFD1535CEB1F347EF")
    
@Override
    public int getDisplayOptions() {
        return mActionView.getDisplayOptions();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.624 -0400", hash_original_method = "086373AB3E22E85AEE50C2F735BD106D", hash_generated_method = "9D5C866B00C7B3361F7D3ADAAEAB1705")
    
@Override
    public Tab newTab() {
        return new TabImpl();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.628 -0400", hash_original_method = "1EECF05398B0BE8AB00F4615B5278612", hash_generated_method = "B000A8E351EB9373FC821CB94ABC9FE7")
    
@Override
    public void addTab(Tab tab) {
        addTab(tab, mTabs.isEmpty());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.633 -0400", hash_original_method = "89408631A5DFBB8696DA15288AA15329", hash_generated_method = "A7D0C1B20548F4B7FDA1E0EC71D3FE64")
    
@Override
    public void addTab(Tab tab, boolean setSelected) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, setSelected);
        configureTab(tab, mTabs.size());
        if (setSelected) {
            selectTab(tab);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.638 -0400", hash_original_method = "654B3E709639F944F902BA5D9B821C89", hash_generated_method = "A8D86E8DE1F71F00DDABAE3C04E1B026")
    
@Override
    public void addTab(Tab tab, int position) {
        addTab(tab, position, mTabs.isEmpty());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.642 -0400", hash_original_method = "041C4C5A1F00C6CFE52123DF1D5CFA62", hash_generated_method = "C8915EBC4EA2A4A10C780127CA89C807")
    
@Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        ensureTabsExist();
        mTabScrollView.addTab(tab, position, setSelected);
        configureTab(tab, position);
        if (setSelected) {
            selectTab(tab);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.646 -0400", hash_original_method = "D97BFE7F24375737332EF4EB210BF330", hash_generated_method = "8FD5BF8357B1A35912B20AE108A8748D")
    
@Override
    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.650 -0400", hash_original_method = "B3645E4F4AB7E9BBDE0315AEF0157D54", hash_generated_method = "0364B6548ED33538CDC52665C277B169")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.653 -0400", hash_original_method = "B97B28074DE5FCD367C21E021091BD45", hash_generated_method = "BC6B70C25928D03A41301AAD1370B9DC")
    
@Override
    public void removeAllTabs() {
        cleanupTabs();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.658 -0400", hash_original_method = "263E8ED7D5D087E56B00A8441B92995D", hash_generated_method = "3212401A2AD06A20E79CD938152E2E82")
    
@Override
    public void selectTab(Tab tab) {
        if (getNavigationMode() != NAVIGATION_MODE_TABS) {
            mSavedTabPosition = tab != null ? tab.getPosition() : INVALID_POSITION;
            return;
        }

        final FragmentTransaction trans = mActivity.getSupportFragmentManager().beginTransaction()
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.661 -0400", hash_original_method = "2AD2D5B38A8D730799170A69D020CCD7", hash_generated_method = "0BC25F24D3538E9BEA3EC00122537CA1")
    
@Override
    public Tab getSelectedTab() {
        return mSelectedTab;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.666 -0400", hash_original_method = "389BF0B1EF97627FAF399E95ED0D1079", hash_generated_method = "50CE8D6AAADFE72BE0440C67F4304056")
    
@Override
    public Tab getTabAt(int index) {
        return mTabs.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.669 -0400", hash_original_method = "44E873137D601CC44196E7945B5F3744", hash_generated_method = "48D098F3AA342AED1DA251A75DB322F0")
    
@Override
    public int getTabCount() {
        return mTabs.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.674 -0400", hash_original_method = "63AEFF4A40454743B95ACDDAE36CDEEA", hash_generated_method = "08AFAF64BFE6972636D30F7EF267570F")
    
@Override
    public Context getThemedContext() {
        if (mThemedContext == null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme currentTheme = mContext.getTheme();
            currentTheme.resolveAttribute(R.attr.actionBarWidgetTheme, outValue, true);
            final int targetThemeRes = outValue.resourceId;

            if (targetThemeRes != 0) {
                mThemedContext = new ContextThemeWrapper(mContext, targetThemeRes);
            } else {
                mThemedContext = mContext;
            }
        }
        return mThemedContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.677 -0400", hash_original_method = "7329EA59D7EBE41DA23E0A3E55EEA1A2", hash_generated_method = "E566B12BB6F9E949129FCEA1D2F3D107")
    
@Override
    public int getHeight() {
        return mContainerView.getHeight();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.681 -0400", hash_original_method = "15EF335C95E8EEE0A5A4C04DF47D0AA2", hash_generated_method = "9F5E4DAE117D2CF821BD2609EF7A7D21")
    
@Override
    public void show() {
        if (mHiddenByApp) {
            mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.684 -0400", hash_original_method = "A6F5A04C4349EE01BBAF30D3C974DE75", hash_generated_method = "A6F5A04C4349EE01BBAF30D3C974DE75")
    
void showForActionMode() {
        if (!mShowingForMode) {
            mShowingForMode = true;
            updateVisibility(false);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.687 -0400", hash_original_method = "F4D9AFB0103DA7FE46E1E3DD2F36F561", hash_generated_method = "5931CB1648ABC269FC3DB3211001275C")
    
@Override
    public void hide() {
        if (!mHiddenByApp) {
            mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.691 -0400", hash_original_method = "F8AE9280C44DD2793A40202BC881E13C", hash_generated_method = "F8AE9280C44DD2793A40202BC881E13C")
    
void hideForActionMode() {
        if (mShowingForMode) {
            mShowingForMode = false;
            updateVisibility(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.695 -0400", hash_original_method = "60A70F7FAF1D62B70DD55EF8D0802088", hash_generated_method = "EEB646CA4070AC79F692A69D2DCA9CB8")
    
@Override
    public boolean isShowing() {
        return mNowShowing;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.699 -0400", hash_original_method = "432643F5D3E1C75318DA649F07995AE5", hash_generated_method = "9ECDC13D566BB9CF736CFC723E9FF958")
    
@Override
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mMenuVisibilityListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.703 -0400", hash_original_method = "602CC871D8636269B09601DAE53B0892", hash_generated_method = "D35534EA94FC6998D25841E0A2AEA113")
    
@Override
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        mMenuVisibilityListeners.remove(listener);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.707 -0400", hash_original_method = "1D126FCCD0DB3235557CB463AEF534E8", hash_generated_method = "3B43DDBADDB96CA70DD5FE3037078CF5")
    
public ActionMode startActionMode(ActionMode.Callback callback) {
        if (mActionMode != null) {
            mActionMode.finish();
        }

        mContextView.killMode();
        ActionModeImpl mode = new ActionModeImpl(callback);
        if (mode.dispatchOnCreate()) {
            mode.invalidate();
            mContextView.initForMode(mode);
            animateToMode(true);
            if (mSplitView != null && mContextDisplayMode == CONTEXT_DISPLAY_SPLIT) {
                if (mSplitView.getVisibility() != View.VISIBLE) {
                    mSplitView.setVisibility(View.VISIBLE);
                }
            }
            mContextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            mActionMode = mode;
            return mode;
        }
        return null;
    }

    /**
     * @hide
     */
    public class TabImpl extends ActionBar.Tab {

        private ActionBar.TabListener mCallback;
        private Object mTag;
        private Drawable mIcon;
        private CharSequence mText;
        private CharSequence mContentDesc;
        private int mPosition = -1;
        private View mCustomView;

        @Override
        public Object getTag() {
            return mTag;
        }

        @Override
        public Tab setTag(Object tag) {
            mTag = tag;
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public ActionBar.TabListener getCallback() {
            return mCallback;
        }

        @Override
        public Tab setTabListener(ActionBar.TabListener callback) {
            mCallback = callback;
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public View getCustomView() {
            return mCustomView;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setCustomView(View view) {
            mCustomView = view;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setCustomView(int layoutResId) {
            return setCustomView(LayoutInflater.from(getThemedContext())
                    .inflate(layoutResId, null));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Drawable getIcon() {
            return mIcon;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getPosition() {
            return mPosition;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setPosition(int position) {
            mPosition = position;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getText() {
            return mText;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setIcon(Drawable icon) {
            mIcon = icon;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setIcon(int resId) {
            return setIcon(mContext.getResources().getDrawable(resId));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setText(CharSequence text) {
            mText = text;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setText(int resId) {
            return setText(mContext.getResources().getText(resId));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void select() {
            selectTab(this);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setContentDescription(int resId) {
            return setContentDescription(mContext.getResources().getText(resId));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Tab setContentDescription(CharSequence contentDesc) {
            mContentDesc = contentDesc;
            if (mPosition >= 0) {
                mTabScrollView.updateTab(mPosition);
            }
            return this;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public CharSequence getContentDescription() {
            return mContentDesc;
        }
    }

    class ActionModeImpl extends ActionMode //implements android.support.v7.internal.view.menu.MenuBuilder.Callback 
    {

        private ActionMode.Callback mCallback;
        private MenuBuilder mMenu;
        private WeakReference<View> mCustomView;

        public ActionModeImpl(ActionMode.Callback callback) {
            mCallback = callback;
            mMenu = new MenuBuilder(getThemedContext())
                    .setDefaultShowAsAction(SupportMenuItem.SHOW_AS_ACTION_IF_ROOM);
            //mMenu.setCallback(callback);
        }

        @Override
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(getThemedContext());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Menu getMenu() {
            return (Menu) mMenu;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void finish() {
            if (mActionMode != this) {
                // Not the active action mode - no-op
                return;
            }

            // If this change in state is going to cause the action bar
            // to be hidden, defer the onDestroy callback until the animation
            // is finished and associated relayout is about to happen. This lets
            // apps better anticipate visibility and layout behavior.
            if (!checkShowingFlags(mHiddenByApp, mHiddenBySystem, false)) {
                // With the current state but the action bar hidden, our
                // overall showing state is going to be false.
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
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try {
                mCallback.onPrepareActionMode(this, getMenu());
            } finally {
                mMenu.startDispatchingItemsChanged();
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try {
                return mCallback.onCreateActionMode(this, getMenu());
            } finally {
                mMenu.startDispatchingItemsChanged();
            }
        }

        @Override
        public void setCustomView(View view) {
            mContextView.setCustomView(view);
            mCustomView = new WeakReference<View>(view);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSubtitle(CharSequence subtitle) {
            mContextView.setSubtitle(subtitle);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setTitle(CharSequence title) {
            mContextView.setTitle(title);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setTitle(int resId) {
            setTitle(mContext.getResources().getString(resId));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setSubtitle(int resId) {
            setSubtitle(mContext.getResources().getString(resId));
        }

        @Override
        public CharSequence getTitle() {
            return mContextView.getTitle();
        }

        @Override
        public CharSequence getSubtitle() {
            return mContextView.getSubtitle();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setTitleOptionalHint(boolean titleOptional) {
            super.setTitleOptionalHint(titleOptional);
            mContextView.setTitleOptional(titleOptional);
        }

        @Override
        public boolean isTitleOptional() {
            return mContextView.isTitleOptional();
        }

        @Override
        public View getCustomView() {
            return mCustomView != null ? mCustomView.get() : null;
        }

        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            if (mCallback != null) {
                return mCallback.onActionItemClicked(this, item);
            } else {
                return false;
            }
        }

        public void onMenuModeChange(MenuBuilder menu) {
            if (mCallback == null) {
                return;
            }
            invalidate();
            mContextView.showOverflowMenu();
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            if (mCallback == null) {
                return false;
            }

            if (!subMenu.hasVisibleItems()) {
                return true;
            }

            //new MenuPopupHelper(getThemedContext(), subMenu).show();
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder menu) {
        }

        public void onMenuModeChange(Menu menu) {
            if (mCallback == null) {
                return;
            }
            invalidate();
            mContextView.showOverflowMenu();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.711 -0400", hash_original_method = "597343B38125CE3B07C85278A379C0F2", hash_generated_method = "597343B38125CE3B07C85278A379C0F2")
    
void animateToMode(boolean toActionMode) {
        if (toActionMode) {
            showForActionMode();
        } else {
            hideForActionMode();
        }

        mActionView.animateToVisibility(toActionMode ? View.INVISIBLE : View.VISIBLE);
        mContextView.animateToVisibility(toActionMode ? View.VISIBLE : View.GONE);
        if (mTabScrollView != null && !mActionView.hasEmbeddedTabs() && mActionView.isCollapsed()) {
            mTabScrollView.setVisibility(toActionMode ? View.GONE : View.VISIBLE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.921 -0400", hash_original_method = "B332EADF2157A08D36981BA5E17CDEF5", hash_generated_method = "ABEE066E77E42A0111DD15965B7E5689")
    
private void ensureTabsExist() {
        if (mTabScrollView != null) {
            return;
        }

        ScrollingTabContainerView tabScroller = new ScrollingTabContainerView(mContext);

        if (mHasEmbeddedTabs) {
            tabScroller.setVisibility(View.VISIBLE);
            mActionView.setEmbeddedTabView(tabScroller);
        } else {
            if (getNavigationMode() == NAVIGATION_MODE_TABS) {
                tabScroller.setVisibility(View.VISIBLE);
            } else {
                tabScroller.setVisibility(View.GONE);
            }
            mContainerView.setTabContainer(tabScroller);
        }
        mTabScrollView = tabScroller;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.926 -0400", hash_original_method = "4981E6F1136ACFE06B622EFDD1F32611", hash_generated_method = "F942E13C8E11E0D9C18AEAB7106FEC54")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.929 -0400", hash_original_method = "62AE76DE88CDD8F4A1D9D70F05364203", hash_generated_method = "1CC92F98F3B0A9B5EC5EA91E374B2E31")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.938 -0400", hash_original_method = "72EDA51412A154FA3B8BAA6258ADAFDD", hash_generated_method = "8415BCEA0304BC119E79CD592D3F4AD7")
    
private void updateVisibility(boolean fromSystem) {
        // Based on the current state, should we be hidden or shown?
        final boolean shown = checkShowingFlags(mHiddenByApp, mHiddenBySystem, mShowingForMode);

        if (shown) {
            if (!mNowShowing) {
                mNowShowing = true;
                doShow(fromSystem);
            }
        } else {
            if (mNowShowing) {
                mNowShowing = false;
                doHide(fromSystem);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.941 -0400", hash_original_method = "80F9F5782C0BAE22246AB8B618FD1E14", hash_generated_method = "806321EF6CFBDA2BD9B100AEA8038757")
    
public void setShowHideAnimationEnabled(boolean enabled) {
        mShowHideAnimationEnabled = enabled;
        if (!enabled) {
            mTopVisibilityView.clearAnimation();
            if (mSplitView != null) {
                mSplitView.clearAnimation();
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.946 -0400", hash_original_method = "EF15E219957C67E4D430BEF7178B6725", hash_generated_method = "B8EBE83054F74150CEF5D4E3A5672A02")
    
public void doShow(boolean fromSystem) {
        mTopVisibilityView.clearAnimation();
        if (mTopVisibilityView.getVisibility() == View.VISIBLE) {
            return;
        }

        final boolean animate = isShowHideAnimationEnabled() || fromSystem;

        if (animate) {
            Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.abc_slide_in_top);
            mTopVisibilityView.startAnimation(anim);
        }
        mTopVisibilityView.setVisibility(View.VISIBLE);

        if (mSplitView != null && mSplitView.getVisibility() != View.VISIBLE) {
            if (animate) {
                Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.abc_slide_in_bottom);
                mSplitView.startAnimation(anim);
            }
            mSplitView.setVisibility(View.VISIBLE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.951 -0400", hash_original_method = "FD7AE9DE0B70B38235481D0FA9BB181C", hash_generated_method = "19FD657B8C59C9036FB85F52BAA17600")
    
public void doHide(boolean fromSystem) {
        mTopVisibilityView.clearAnimation();
        if (mTopVisibilityView.getVisibility() == View.GONE) {
            return;
        }

        final boolean animate = isShowHideAnimationEnabled() || fromSystem;

        if (animate) {
            Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.abc_slide_out_top);
            mTopVisibilityView.startAnimation(anim);
        }
        mTopVisibilityView.setVisibility(View.GONE);

        if (mSplitView != null && mSplitView.getVisibility() != View.GONE) {
            if (animate) {
                Animation anim = AnimationUtils
                        .loadAnimation(mContext, R.anim.abc_slide_out_bottom);
                mSplitView.startAnimation(anim);
            }
            mSplitView.setVisibility(View.GONE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:32.954 -0400", hash_original_method = "C79F71853A69FFA087B571C35943DB45", hash_generated_method = "C79F71853A69FFA087B571C35943DB45")
    
boolean isShowHideAnimationEnabled() {
        return mShowHideAnimationEnabled;
    }

}
