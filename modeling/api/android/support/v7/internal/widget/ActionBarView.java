/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2010 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/**
 * @hide
 */
public class ActionBarView extends AbsActionBarView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.723 -0400", hash_original_field = "13E1B41D73BCA415DCDEC906E8D8082E", hash_generated_field = "CDFB47463B78F3368DF983B3BF1B285F")

    private static final String TAG = "ActionBarView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.733 -0400", hash_original_field = "E138855500438DF0270121A836DCD99E", hash_generated_field = "4A3C78D8B3B7DF5E626E3E97B7B40810")

    public static final int DISPLAY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.743 -0400", hash_original_field = "6638869DCB36083668E658C61CCB8AF0", hash_generated_field = "BC022A419127EDDE4E40524DA912F0E3")

    private static final int DISPLAY_RELAYOUT_MASK =
            ActionBar.DISPLAY_SHOW_HOME |
                    ActionBar.DISPLAY_USE_LOGO |
                    ActionBar.DISPLAY_HOME_AS_UP |
                    ActionBar.DISPLAY_SHOW_CUSTOM |
                    ActionBar.DISPLAY_SHOW_TITLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.751 -0400", hash_original_field = "C5C90C1ACEFF6F72E0613A9C2710627A", hash_generated_field = "3E11FBBE13E46A77B28D3C5EFE3B5DF0")

    private static final int DEFAULT_CUSTOM_GRAVITY = Gravity.LEFT | Gravity.CENTER_VERTICAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.757 -0400", hash_original_field = "798106CD7526C2079840C962AA54DB2F", hash_generated_field = "D7021ACCA51C37141CA5A3F0F0CB8D58")

    private int mNavigationMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.774 -0400", hash_original_field = "BDA13E1B19CA8C479B2D635CE6A6D5BF", hash_generated_field = "B097184BD65EEF760AB4457269F41FCE")

    private int mDisplayOptions = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.781 -0400", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.787 -0400", hash_original_field = "AB153FEBC9BAB866EB9D9BD858F863D7", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.793 -0400", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.799 -0400", hash_original_field = "AD986E3F362B588C5109C09E3AEE3117", hash_generated_field = "6A8F8D16CE24865FF96256279C68A01A")

    private Drawable mLogo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.805 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.811 -0400", hash_original_field = "5C0068FACE6B1BBC7F305A960008426B", hash_generated_field = "D44BE31A0DA12240E9EFFCC7D25F51CC")

    private HomeView mHomeLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.818 -0400", hash_original_field = "3959B8ED69EA5F3A81713941FFA2025F", hash_generated_field = "E38B6AFC0FF7040E207A508974C7E25A")

    private HomeView mExpandedHomeLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.824 -0400", hash_original_field = "F5CA594DCFB48DED54369A102A0AE68B", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.831 -0400", hash_original_field = "B3B1177DB6C3A24EAC74C6705FD25300", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.836 -0400", hash_original_field = "913CA974C51FCA87DC9298E376261903", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.843 -0400", hash_original_field = "899838E33DA7E0D538E2361BF0C03A1C", hash_generated_field = "F5B3209E54DA151E61A314A7F4D53CEE")

    private View mTitleUpView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.849 -0400", hash_original_field = "8C946AAFFF085D39DB4B79A9469FEEA6", hash_generated_field = "BEB9F09082AB4BA9C8AE2B0705289230")

    private SpinnerICS mSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.855 -0400", hash_original_field = "1363E7D01AE8F3E0EBA1B30929D3DD44", hash_generated_field = "3E145BA83F7246824E728DD8C128F1DB")

    private LinearLayout mListNavLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.862 -0400", hash_original_field = "AD923D267EC0F804E578816407CA8B0F", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.867 -0400", hash_original_field = "B005187E132A159D60D4C2C3B609E89E", hash_generated_field = "43AC585897322F8F4F6B26FAA521DECA")

    private View mCustomNavView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.874 -0400", hash_original_field = "47B5A0B4A3895E474CE9136D9F3FF220", hash_generated_field = "92E4A32872D78C504F30080824D1CDB5")

    private ProgressBarICS mProgressView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.879 -0400", hash_original_field = "345E77E9A2B2EABB5E635B0397EB4DC4", hash_generated_field = "2DDA7909E390F0B9DB33E7152CC37EB5")

    private ProgressBarICS mIndeterminateProgressView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.885 -0400", hash_original_field = "5CF83B212FF8552ABAA020AC5D602B28", hash_generated_field = "A3B6EB195053EBD51627D7173A9AE65D")

    private int mProgressBarPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.891 -0400", hash_original_field = "362CD4C51D06AEE140CC6E752ECE8458", hash_generated_field = "F1455EFA6BE686E648B8E824CB9E4B81")

    private int mItemPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.898 -0400", hash_original_field = "91BBE04D928B78D71ACCA8B7A1A78C5D", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")

    private int mTitleStyleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.903 -0400", hash_original_field = "1B837B3FAA0F380D6AF3C59E69CB3BE4", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.909 -0400", hash_original_field = "52B5373740A74E22C39A9E940D3C1F8D", hash_generated_field = "18CB7C9B43E54A91185B83C5D14435FA")

    private int mProgressStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.915 -0400", hash_original_field = "EE42873C4DD107ADD1FAB4BE05075814", hash_generated_field = "083E8134CFA4F8973249802B9A98C1E8")

    private int mIndeterminateProgressStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.921 -0400", hash_original_field = "BC597FAE0E0B5099AFFB47470C0E19A8", hash_generated_field = "0BAF72C7FF2EC45DE525F98CE324593F")

    private boolean mUserTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.926 -0400", hash_original_field = "448386E71B11CD06DD441057CF23BBC3", hash_generated_field = "968C4A904AD7ABC6144B6FCA2B427A80")

    private boolean mIncludeTabs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.933 -0400", hash_original_field = "E5BFD7FC9B1E72E91376CDB4B9D64459", hash_generated_field = "C0F5A22B3AA8A56D9DDAD5EF854478D3")

    private boolean mIsCollapsable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.939 -0400", hash_original_field = "AC8405742BFFC628CB21A1C91640FE34", hash_generated_field = "3AD368D522924E6E03967F9DD95F2CBA")

    private boolean mIsCollapsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.945 -0400", hash_original_field = "917FEAD1389D218E4B81B249AD63541D", hash_generated_field = "4278A1A241D9B74448B2E547C0296095")

    private MenuBuilder mOptionsMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.951 -0400", hash_original_field = "A5A9EDF61C66A197D158B006E66DA25C", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.957 -0400", hash_original_field = "D7F65785B7F41E20AE226E6BAF701A6E", hash_generated_field = "8C99101FC0313C08F73DD333D1CB1634")

    private ActionMenuItem mLogoNavItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.963 -0400", hash_original_field = "C6728ABFE96FBC761211FBFCF9FAA627", hash_generated_field = "3A2C8F67A3FD8ED91EC78875AB208830")

    private SpinnerAdapter mSpinnerAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.969 -0400", hash_original_field = "3AA3B40983CB34C0A7CA244F15002B79", hash_generated_field = "7A41771A4BE9BD1204FF01614115DD99")

    private OnNavigationListener mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.974 -0400", hash_original_field = "E682310941753B94BE1FECAC9286C6E9", hash_generated_field = "4C6A10C066298B16934A9F20792BEABB")

    private Runnable mTabSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.982 -0400", hash_original_field = "3A18A0899B7747CAC81D3533E30CC657", hash_generated_field = "87262EFC15C41A276BFA5FD764A20EF4")

    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.987 -0400", hash_original_field = "5B0D453753A571590EA0325BAB8050A5", hash_generated_field = "5B0D453753A571590EA0325BAB8050A5")

    View mExpandedActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:01.992 -0400", hash_original_field = "27B4F279DA726B6E62F72C86D786B686", hash_generated_field = "27B4F279DA726B6E62F72C86D786B686")

    Window.Callback mWindowCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.019 -0400", hash_original_field = "92FE2E712C1CD0C9BC6A368F916F7E23", hash_generated_field = "D999E1D94001B6EC24D3E8759CDFE494")

    private final AdapterViewICS.OnItemSelectedListener mNavItemSelectedListener =
            new AdapterViewICS.OnItemSelectedListener() {
                public void onItemSelected(AdapterViewICS<?> parent, View view, int position,
                        long id) {
                    if (mCallback != null) {
                        mCallback.onNavigationItemSelected(position, id);
                    }
                }

                @DSSafe(DSCat.SAFE_LIST)
        public void onNothingSelected(AdapterViewICS<?> parent) {
                    // Do nothing
                }
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.037 -0400", hash_original_field = "BF7B126DAE50F71E1CAFD7DED4CE4FE8", hash_generated_field = "B814331D640D6419AC7205B0F6577FF8")

    private final OnClickListener mExpandedActionViewUpListener = new OnClickListener() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onClick(View v) {
            final MenuItemImpl item = mExpandedMenuPresenter.mCurrentExpandedItem;
            if (item != null) {
                item.collapseActionView();
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.052 -0400", hash_original_field = "72E8415DC32241491E779349D13655F2", hash_generated_field = "35C031ACCB194995209632E5B2A494A4")

    private final OnClickListener mUpClickListener = new OnClickListener() {
        @DSSafe(DSCat.SAFE_LIST)
        public void onClick(View v) {
            mWindowCallback.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, mLogoNavItem);
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.078 -0400", hash_original_method = "C3F7A32D26A4879ACA1E6BE66EC54E0D", hash_generated_method = "1916207B86A753E07A917D4B4C9D0757")
    
public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        // Background is always provided by the container.
        setBackgroundResource(0);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionBar,
                R.attr.actionBarStyle, 0);

        ApplicationInfo appInfo = context.getApplicationInfo();
        PackageManager pm = context.getPackageManager();
        mNavigationMode = a.getInt(R.styleable.ActionBar_navigationMode,
                ActionBar.NAVIGATION_MODE_STANDARD);
        mTitle = a.getText(R.styleable.ActionBar_title);
        mSubtitle = a.getText(R.styleable.ActionBar_subtitle);
        mLogo = a.getDrawable(R.styleable.ActionBar_logo);
        if (mLogo == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                if (context instanceof Activity) {
                    try {
                        mLogo = pm.getActivityLogo(((Activity) context).getComponentName());
                    } catch (NameNotFoundException e) {
                        Log.e(TAG, "Activity component name not found!", e);
                    }
                }
                if (mLogo == null) {
                    mLogo = appInfo.loadLogo(pm);
                }
            }
        }

        // TODO(trevorjohns): Should these use the android namespace
        mIcon = a.getDrawable(R.styleable.ActionBar_icon);
        if (mIcon == null) {
            if (context instanceof Activity) {
                try {
                    mIcon = pm.getActivityIcon(((Activity) context).getComponentName());
                } catch (NameNotFoundException e) {
                    Log.e(TAG, "Activity component name not found!", e);
                }
            }
            if (mIcon == null) {
                mIcon = appInfo.loadIcon(pm);
            }
        }

        final LayoutInflater inflater = LayoutInflater.from(context);

        final int homeResId = a.getResourceId(
                R.styleable.ActionBar_homeLayout,
                R.layout.abc_action_bar_home);

        mHomeLayout = (HomeView) inflater.inflate(homeResId, this, false);

        mExpandedHomeLayout = (HomeView) inflater.inflate(homeResId, this, false);
        mExpandedHomeLayout.setUp(true);
        mExpandedHomeLayout.setOnClickListener(mExpandedActionViewUpListener);
        mExpandedHomeLayout.setContentDescription(getResources().getText(
                R.string.abc_action_bar_up_description));

        mTitleStyleRes = a.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
        mSubtitleStyleRes = a.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
        mProgressStyle = a.getResourceId(R.styleable.ActionBar_progressBarStyle, 0);
        mIndeterminateProgressStyle = a.getResourceId(
                R.styleable.ActionBar_indeterminateProgressStyle, 0);

        mProgressBarPadding = a
                .getDimensionPixelOffset(R.styleable.ActionBar_progressBarPadding, 0);
        mItemPadding = a.getDimensionPixelOffset(R.styleable.ActionBar_itemPadding, 0);

        setDisplayOptions(a.getInt(R.styleable.ActionBar_displayOptions, DISPLAY_DEFAULT));

        final int customNavId = a.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
        if (customNavId != 0) {
            mCustomNavView = (View) inflater.inflate(customNavId, this, false);
            mNavigationMode = ActionBar.NAVIGATION_MODE_STANDARD;
            setDisplayOptions(mDisplayOptions | ActionBar.DISPLAY_SHOW_CUSTOM);
        }

        mContentHeight = a.getLayoutDimension(R.styleable.ActionBar_height, 0);
        a.recycle();
        mLogoNavItem = new ActionMenuItem(context, 0, DSUtils.FAKE_INT, 0, 0, mTitle);
        mHomeLayout.setOnClickListener(mUpClickListener);
        mHomeLayout.setClickable(true);
        mHomeLayout.setFocusable(true);

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.090 -0400", hash_original_method = "7150BF92024575439616A8300A00E1C9", hash_generated_method = "ECF214BB23725256A21B6C6C2BA72B2A")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mTitleView = null;
        mSubtitleView = null;
        mTitleUpView = null;
        if (mTitleLayout != null && mTitleLayout.getParent() == this) {
            removeView(mTitleLayout);
        }
        mTitleLayout = null;
        if ((mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0) {
            initTitle();
        }

        if (mTabScrollView != null && mIncludeTabs) {
            ViewGroup.LayoutParams lp = mTabScrollView.getLayoutParams();
            if (lp != null) {
                lp.width = LayoutParams.WRAP_CONTENT;
                lp.height = LayoutParams.FILL_PARENT;
            }
            mTabScrollView.setAllowCollapse(true);
        }

        if (mProgressView != null) {
            removeView(mProgressView);
            initProgress();
        }
        if (mIndeterminateProgressView != null) {
            removeView(mIndeterminateProgressView);
            initIndeterminateProgress();
        }
    }

    /**
     * Set the view callback used to invoke menu items; used for dispatching home button presses.
     *
     * @param cb View callback to dispatch to
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.096 -0400", hash_original_method = "3A6246ABFAB05CB7EB83E9ECE73695AD", hash_generated_method = "698F34FFF9DF6773FE5D3FE0502A0032")
    
public void setWindowCallback(Window.Callback cb) {
        mWindowCallback = cb;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.103 -0400", hash_original_method = "B71E506A9F91C1AD992AA849BAEDAF37", hash_generated_method = "11564454258926541E467EF7D156E0E2")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mTabSelector);
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.108 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "659F6267CAA0F0782AD0A43AF5DFAEC7")
    
public boolean shouldDelayChildPressedState() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.116 -0400", hash_original_method = "075F37076141A6F759D8D3B26C068D27", hash_generated_method = "7624BD5DB0B20135FF5DE94CCC36AA6B")
    
public void initProgress() {
        mProgressView = new ProgressBarICS(mContext, null, 0, mProgressStyle);
        mProgressView.setId(R.id.progress_horizontal);
        mProgressView.setMax(10000);
        mProgressView.setVisibility(GONE);
        addView(mProgressView);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.123 -0400", hash_original_method = "083B9331196A7EC890DBDF44C03C3992", hash_generated_method = "8CEEB2F5DB3B4DD27E13D934D00C1AB2")
    
public void initIndeterminateProgress() {
        mIndeterminateProgressView = new ProgressBarICS(mContext, null, 0,
                mIndeterminateProgressStyle);
        mIndeterminateProgressView.setId(R.id.progress_circular);
        mIndeterminateProgressView.setVisibility(GONE);
        addView(mIndeterminateProgressView);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.134 -0400", hash_original_method = "315C3BEFDAE42A48B0F1E6514B8F23AB", hash_generated_method = "E6138FD81E72F95BD2C5011F1D32F0EE")
    
@Override
    public void setSplitActionBar(boolean splitActionBar) {
        if (mSplitActionBar != splitActionBar) {
            if (mMenuView != null) {
                final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                if (oldParent != null) {
                    oldParent.removeView(mMenuView);
                }
                if (splitActionBar) {
                    if (mSplitView != null) {
                        mSplitView.addView(mMenuView);
                    }
                    mMenuView.getLayoutParams().width = LayoutParams.FILL_PARENT;
                } else {
                    addView(mMenuView);
                    mMenuView.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
                }
                mMenuView.requestLayout();
            }
            if (mSplitView != null) {
                mSplitView.setVisibility(splitActionBar ? VISIBLE : GONE);
            }

            if (mActionMenuPresenter != null) {
                if (!splitActionBar) {
                    mActionMenuPresenter.setExpandedActionViewsExclusive(
                            getResources().getBoolean(
                                    R.bool.abc_action_bar_expanded_action_views_exclusive));
                } else {
                    mActionMenuPresenter.setExpandedActionViewsExclusive(false);
                    // Allow full screen width in split mode.
                    mActionMenuPresenter.setWidthLimit(
                            getContext().getResources().getDisplayMetrics().widthPixels, true);
                    // No limit to the item count; use whatever will fit.
                    mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                }
            }
            super.setSplitActionBar(splitActionBar);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.139 -0400", hash_original_method = "D1A0823C6A31D8186A466BCCCE11ADAA", hash_generated_method = "23FF4042628ECB52598485F8A635CED7")
    
public boolean isSplitActionBar() {
        return mSplitActionBar;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.145 -0400", hash_original_method = "24672C2D43139828573B39E460E47DBC", hash_generated_method = "434E54113F8F91662113CEF558A554CE")
    
public boolean hasEmbeddedTabs() {
        return mIncludeTabs;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.152 -0400", hash_original_method = "F8F4F6F0BFF1822BCEEC06D296040FFB", hash_generated_method = "BE776FF2B73DD086D4DD3CEF1DE74228")
    
public void setEmbeddedTabView(ScrollingTabContainerView tabs) {
        if (mTabScrollView != null) {
            removeView(mTabScrollView);
        }
        mTabScrollView = tabs;
        mIncludeTabs = tabs != null;
        if (mIncludeTabs && mNavigationMode == ActionBar.NAVIGATION_MODE_TABS) {
            addView(mTabScrollView);
            ViewGroup.LayoutParams lp = mTabScrollView.getLayoutParams();
            lp.width = LayoutParams.WRAP_CONTENT;
            lp.height = LayoutParams.FILL_PARENT;
            tabs.setAllowCollapse(true);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.158 -0400", hash_original_method = "0457D3AD4F802E9E3CD470071939A6F3", hash_generated_method = "57DDF22592ECC2D0A5B67A3F5CEE45B4")
    
public void setCallback(OnNavigationListener callback) {
        mCallback = callback;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.173 -0400", hash_original_method = "F11679288C61D22B2D85B559F4F75B49", hash_generated_method = "84C35B8B4F0DC5AF9B807FA0D888BD5C")
    
public void setMenu(SupportMenu menu, MenuPresenter.Callback cb) {
        if (menu == mOptionsMenu) {
            return;
        }

        if (mOptionsMenu != null) {
            mOptionsMenu.removeMenuPresenter(mActionMenuPresenter);
            mOptionsMenu.removeMenuPresenter(mExpandedMenuPresenter);
        }

        MenuBuilder builder = (MenuBuilder) menu;
        mOptionsMenu = builder;
        if (mMenuView != null) {
            final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
            if (oldParent != null) {
                oldParent.removeView(mMenuView);
            }
        }
        if (mActionMenuPresenter == null) {
            mActionMenuPresenter = new ActionMenuPresenter(mContext);
            mActionMenuPresenter.setCallback(cb);
            mActionMenuPresenter.setId(R.id.action_menu_presenter);
            mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
        }

        ActionMenuView menuView;
        final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.FILL_PARENT);
        if (!mSplitActionBar) {
            mActionMenuPresenter.setExpandedActionViewsExclusive(
                    getResources().getBoolean(
                            R.bool.abc_action_bar_expanded_action_views_exclusive));
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            menuView.initialize(builder);
            final ViewGroup oldParent = (ViewGroup) menuView.getParent();
            if (oldParent != null && oldParent != this) {
                oldParent.removeView(menuView);
            }
            addView(menuView, layoutParams);
        } else {
            mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            // Allow full screen width in split mode.
            mActionMenuPresenter.setWidthLimit(
                    getContext().getResources().getDisplayMetrics().widthPixels, true);
            // No limit to the item count; use whatever will fit.
            mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            // Span the whole width
            layoutParams.width = LayoutParams.FILL_PARENT;
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            if (mSplitView != null) {
                final ViewGroup oldParent = (ViewGroup) menuView.getParent();
                if (oldParent != null && oldParent != mSplitView) {
                    oldParent.removeView(menuView);
                }
                menuView.setVisibility(getAnimatedVisibility());
                mSplitView.addView(menuView, layoutParams);
            } else {
                // We'll add this later if we missed it this time.
                menuView.setLayoutParams(layoutParams);
            }
        }
        mMenuView = menuView;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.180 -0400", hash_original_method = "F043B8CF159577B0E62B1E1563FA64AB", hash_generated_method = "2C4130B5B8DB5BAF8BBE8AA45B4ADC62")
    
private void configPresenters(MenuBuilder builder) {
        if (builder != null) {
            builder.addMenuPresenter(mActionMenuPresenter);
            builder.addMenuPresenter(mExpandedMenuPresenter);
        } else {
            mActionMenuPresenter.initForMenu(mContext, null);
            mExpandedMenuPresenter.initForMenu(mContext, null);
        }

        // Make sure the Presenter's View is updated
        mActionMenuPresenter.updateMenuView(true);
        mExpandedMenuPresenter.updateMenuView(true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.186 -0400", hash_original_method = "8730ED187B27F4DCB92C97E3B6342387", hash_generated_method = "8E450C9CC49CDC39420D68529D8F7C57")
    
public boolean hasExpandedActionView() {
        return mExpandedMenuPresenter != null &&
                mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.192 -0400", hash_original_method = "E064456058852E66BECDCC9D9AA06FF8", hash_generated_method = "935C62C6E3ABB275F854CE35F8704C21")
    
public void collapseActionView() {
        final MenuItemImpl item = mExpandedMenuPresenter == null ? null :
                mExpandedMenuPresenter.mCurrentExpandedItem;
        if (item != null) {
            item.collapseActionView();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.198 -0400", hash_original_method = "A015B4577A897E6E7B62945B8635CEDC", hash_generated_method = "8097342A33A2A7B74C3C1630B69D2DF4")
    
public void setCustomNavigationView(View view) {
        final boolean showCustom = (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;
        if (mCustomNavView != null && showCustom) {
            removeView(mCustomNavView);
        }
        mCustomNavView = view;
        if (mCustomNavView != null && showCustom) {
            addView(mCustomNavView);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.203 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E948C46F1704FC1F24545ED5A725BEE6")
    
public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Set the action bar title. This will always replace or override window titles.
     *
     * @param title Title to set
     * @see #setWindowTitle(CharSequence)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.209 -0400", hash_original_method = "777E3F031124EBDDD3E24D756483B885", hash_generated_method = "A635DB7C26E2429EA1B8A9304C9EDDDA")
    
public void setTitle(CharSequence title) {
        mUserTitle = true;
        setTitleImpl(title);
    }

    /**
     * Set the window title. A window title will always be replaced or overridden by a user title.
     *
     * @param title Title to set
     * @see #setTitle(CharSequence)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.214 -0400", hash_original_method = "193CF6C8B49C81B5000EB0B0B9EF604D", hash_generated_method = "7D041DA99A206D5D153585028300D290")
    
public void setWindowTitle(CharSequence title) {
        if (!mUserTitle) {
            setTitleImpl(title);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.220 -0400", hash_original_method = "CA4194BA53EDB0AC58DD1582B0D957BD", hash_generated_method = "6D6C733A34F59C16E124C6E8DD2AE9FF")
    
private void setTitleImpl(CharSequence title) {
        mTitle = title;
        if (mTitleView != null) {
            mTitleView.setText(title);
            final boolean visible = mExpandedActionView == null &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        }
        if (mLogoNavItem != null) {
            mLogoNavItem.setTitle(title);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.225 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "3773E52DB2B3822F51D6A3F2CB66D7C2")
    
public CharSequence getSubtitle() {
        return mSubtitle;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.233 -0400", hash_original_method = "ECDAA3B767FC89031E52906AD709A8B9", hash_generated_method = "87D5DE49CDFD33F80D8B55121DC18BDE")
    
public void setSubtitle(CharSequence subtitle) {
        mSubtitle = subtitle;
        if (mSubtitleView != null) {
            mSubtitleView.setText(subtitle);
            mSubtitleView.setVisibility(subtitle != null ? VISIBLE : GONE);
            final boolean visible = mExpandedActionView == null &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.239 -0400", hash_original_method = "63ABB48EF4BD52C82FDC08430587247B", hash_generated_method = "61FB0237B266309D39898453696C403A")
    
public void setHomeButtonEnabled(boolean enable) {
        mHomeLayout.setEnabled(enable);
        mHomeLayout.setFocusable(enable);
        // Make sure the home button has an accurate content description for accessibility.
        if (!enable) {
            mHomeLayout.setContentDescription(null);
        } else if ((mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.abc_action_bar_up_description));
        } else {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.abc_action_bar_home_description));
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.249 -0400", hash_original_method = "AEA974EFF03A22171C638689B1C27341", hash_generated_method = "0BE7CAC1106A7B1B70568F8057F07E61")
    
public void setDisplayOptions(int options) {
        final int flagsChanged = mDisplayOptions == -1 ? -1 : options ^ mDisplayOptions;
        mDisplayOptions = options;

        if ((flagsChanged & DISPLAY_RELAYOUT_MASK) != 0) {
            final boolean showHome = (options & ActionBar.DISPLAY_SHOW_HOME) != 0;
            final int vis = showHome && mExpandedActionView == null ? VISIBLE : GONE;
            mHomeLayout.setVisibility(vis);

            if ((flagsChanged & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
                final boolean setUp = (options & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mHomeLayout.setUp(setUp);

                // Showing home as up implicitly enables interaction with it.
                // In honeycomb it was always enabled, so make this transition
                // a bit easier for developers in the common case.
                // (It would be silly to show it as up without responding to it.)
                if (setUp) {
                    setHomeButtonEnabled(true);
                }
            }

            if ((flagsChanged & ActionBar.DISPLAY_USE_LOGO) != 0) {
                final boolean logoVis = mLogo != null
                        && (options & ActionBar.DISPLAY_USE_LOGO) != 0;
                mHomeLayout.setIcon(logoVis ? mLogo : mIcon);
            }

            if ((flagsChanged & ActionBar.DISPLAY_SHOW_TITLE) != 0) {
                if ((options & ActionBar.DISPLAY_SHOW_TITLE) != 0) {
                    initTitle();
                } else {
                    removeView(mTitleLayout);
                }
            }

            if (mTitleLayout != null && (flagsChanged &
                    (ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME)) != 0) {
                final boolean homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
                mTitleLayout.setEnabled(!showHome && homeAsUp);
            }

            if ((flagsChanged & ActionBar.DISPLAY_SHOW_CUSTOM) != 0 && mCustomNavView != null) {
                if ((options & ActionBar.DISPLAY_SHOW_CUSTOM) != 0) {
                    addView(mCustomNavView);
                } else {
                    removeView(mCustomNavView);
                }
            }

            requestLayout();
        } else {
            invalidate();
        }

        // Make sure the home button has an accurate content description for accessibility.
        if (!mHomeLayout.isEnabled()) {
            mHomeLayout.setContentDescription(null);
        } else if ((options & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.abc_action_bar_up_description));
        } else {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.abc_action_bar_home_description));
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.255 -0400", hash_original_method = "1AF8380F7CECFBA4529588795F745C19", hash_generated_method = "0BA36FA4A973FAA6BF9DA5A6C64D9E56")
    
public void setIcon(Drawable icon) {
        mIcon = icon;
        if (icon != null &&
                ((mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) == 0 || mLogo == null)) {
            mHomeLayout.setIcon(icon);
        }
        if (mExpandedActionView != null) {
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.261 -0400", hash_original_method = "7424D4DE12B074743D84FF4154B309BA", hash_generated_method = "35C4B17B207D3493F49F75BF5BD06EC1")
    
public void setIcon(int resId) {
        setIcon(mContext.getResources().getDrawable(resId));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.267 -0400", hash_original_method = "6239F067617389BCFA9336EB6940A154", hash_generated_method = "59626619B688E0FD2250765B938463FD")
    
public void setLogo(Drawable logo) {
        mLogo = logo;
        if (logo != null && (mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) != 0) {
            mHomeLayout.setIcon(logo);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.272 -0400", hash_original_method = "8F48D1A1BD2CE39E1CCC3DD41DD8DBB5", hash_generated_method = "325D8DDD6B8334C0917A9A92F452998E")
    
public void setLogo(int resId) {
        setLogo(mContext.getResources().getDrawable(resId));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.280 -0400", hash_original_method = "0F937BF7C128478ED162638EB52BDF62", hash_generated_method = "7E9C36EA1E32553B11820878878C3EF1")
    
public void setNavigationMode(int mode) {
        final int oldMode = mNavigationMode;
        if (mode != oldMode) {
            switch (oldMode) {
                case ActionBar.NAVIGATION_MODE_LIST:
                    if (mListNavLayout != null) {
                        removeView(mListNavLayout);
                    }
                    break;
                case ActionBar.NAVIGATION_MODE_TABS:
                    if (mTabScrollView != null && mIncludeTabs) {
                        removeView(mTabScrollView);
                    }
            }

            switch (mode) {
                case ActionBar.NAVIGATION_MODE_LIST:
                    if (mSpinner == null) {
                        mSpinner = new SpinnerICS(mContext, null,
                                R.attr.actionDropDownStyle);
                        mListNavLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(
                                R.layout.abc_action_bar_view_list_nav_layout, null);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT);
                        params.gravity = Gravity.CENTER;
                        mListNavLayout.addView(mSpinner, params);
                    }
                    if (mSpinner.getAdapter() != mSpinnerAdapter) {
                        mSpinner.setAdapter(mSpinnerAdapter);
                    }
                    mSpinner.setOnItemSelectedListener(mNavItemSelectedListener);
                    addView(mListNavLayout);
                    break;
                case ActionBar.NAVIGATION_MODE_TABS:
                    if (mTabScrollView != null && mIncludeTabs) {
                        addView(mTabScrollView);
                    }
                    break;
            }
            mNavigationMode = mode;
            requestLayout();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.285 -0400", hash_original_method = "89B6C7658DAE063C75647F5ADF8E9216", hash_generated_method = "63CAE297B86EAF57E3C02B4590F1C656")
    
public void setDropdownAdapter(SpinnerAdapter adapter) {
        mSpinnerAdapter = adapter;
        if (mSpinner != null) {
            mSpinner.setAdapter(adapter);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.290 -0400", hash_original_method = "1A4098174F41A05D8E016C60876697BD", hash_generated_method = "55894F49F5FBF6100CC1C53E38147B3E")
    
public SpinnerAdapter getDropdownAdapter() {
        return mSpinnerAdapter;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.295 -0400", hash_original_method = "AD9310333D391F8A81F374E0D04AD8BB", hash_generated_method = "622B0A30BA3CF73798E669E09E27D592")
    
public void setDropdownSelectedPosition(int position) {
        mSpinner.setSelection(position);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.301 -0400", hash_original_method = "434984419C6BB9581BBBAD71AB1CA07D", hash_generated_method = "E9F16265F8BF68A09309130DBF94145D")
    
public int getDropdownSelectedPosition() {
        return mSpinner.getSelectedItemPosition();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.305 -0400", hash_original_method = "1544DDF36E6082443A2EF4ED7A4DF538", hash_generated_method = "0A8612C69308687D2CD30E6730C0871D")
    
public View getCustomNavigationView() {
        return mCustomNavView;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.310 -0400", hash_original_method = "14AA191B691A51A87445A62103C542CB", hash_generated_method = "D8E6902A052246660ED32E8D40DCF853")
    
public int getNavigationMode() {
        return mNavigationMode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.315 -0400", hash_original_method = "7126F05C057CF7F499EBFF9A1F4C4A02", hash_generated_method = "B4E83287FE3A0B3A2131F7F64F8A178F")
    
public int getDisplayOptions() {
        return mDisplayOptions;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.321 -0400", hash_original_method = "CC715ED5E40E0E0CF6C0353136D75335", hash_generated_method = "0E24BB9D465AB364636C002C06C2D9ED")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        // Used by custom nav views if they don't supply layout params. Everything else
        // added to an ActionBarView should have them already.
        return new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.326 -0400", hash_original_method = "5C54848E55EB765D8F0ED5A386E76AE7", hash_generated_method = "752F46793BAB47F3F8AA55C10445D8AC")
    
@Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        addView(mHomeLayout);

        if (mCustomNavView != null && (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0) {
            final ViewParent parent = mCustomNavView.getParent();
            if (parent != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(mCustomNavView);
                }
                addView(mCustomNavView);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.334 -0400", hash_original_method = "6F75DD2129866FA199FB590B4A4A646B", hash_generated_method = "769FA9C318547A527EF394DAB74A9C2F")
    
private void initTitle() {
        if (mTitleLayout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            mTitleLayout = (LinearLayout) inflater.inflate(R.layout.abc_action_bar_title_item,
                    this, false);
            mTitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_title);
            mSubtitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_subtitle);
            mTitleUpView = (View) mTitleLayout.findViewById(R.id.up);

            mTitleLayout.setOnClickListener(mUpClickListener);

            if (mTitleStyleRes != 0) {
                mTitleView.setTextAppearance(mContext, mTitleStyleRes);
            }
            if (mTitle != null) {
                mTitleView.setText(mTitle);
            }

            if (mSubtitleStyleRes != 0) {
                mSubtitleView.setTextAppearance(mContext, mSubtitleStyleRes);
            }
            if (mSubtitle != null) {
                mSubtitleView.setText(mSubtitle);
                mSubtitleView.setVisibility(VISIBLE);
            }

            final boolean homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
            final boolean showHome = (mDisplayOptions & ActionBar.DISPLAY_SHOW_HOME) != 0;
            mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
            mTitleLayout.setEnabled(homeAsUp && !showHome);
        }

        addView(mTitleLayout);
        if (mExpandedActionView != null ||
                (TextUtils.isEmpty(mTitle) && TextUtils.isEmpty(mSubtitle))) {
            // Don't show while in expanded mode or with empty text
            mTitleLayout.setVisibility(GONE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.339 -0400", hash_original_method = "F623B40982707A8AF90610858040ED3E", hash_generated_method = "597C1542D85C984DDC1C93D329019FF9")
    
public void setContextView(ActionBarContextView view) {
        mContextView = view;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.344 -0400", hash_original_method = "4C7B7DAEF91C23BA8E2CF63957DDD2D5", hash_generated_method = "9C0A455DCFCA2976F747E6DE8D700DEC")
    
public void setCollapsable(boolean collapsable) {
        mIsCollapsable = collapsable;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.349 -0400", hash_original_method = "85F70991FC3EED5A4EDF0B8F79DFC73E", hash_generated_method = "DC6000E70971618B215699E4846211E8")
    
public boolean isCollapsed() {
        return mIsCollapsed;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.366 -0400", hash_original_method = "44DEF6DF989E66F3AC70CE8C8C038F81", hash_generated_method = "AA42B507441C1F79DAA6CE25686025CC")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int childCount = getChildCount();
        if (mIsCollapsable) {
            int visibleChildren = 0;
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                if (child.getVisibility() != GONE &&
                        !(child == mMenuView && mMenuView.getChildCount() == 0)) {
                    visibleChildren++;
                }
            }

            if (visibleChildren == 0) {
                // No size for an empty action bar when collapsable.
                setMeasuredDimension(0, 0);
                mIsCollapsed = true;
                return;
            }
        }
        mIsCollapsed = false;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != MeasureSpec.EXACTLY) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)");
        }

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode != MeasureSpec.AT_MOST) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
        }

        int contentWidth = MeasureSpec.getSize(widthMeasureSpec);

        int maxHeight = mContentHeight > 0 ?
                mContentHeight : MeasureSpec.getSize(heightMeasureSpec);

        final int verticalPadding = getPaddingTop() + getPaddingBottom();
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int height = maxHeight - verticalPadding;
        final int childSpecHeight = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);

        int availableWidth = contentWidth - paddingLeft - paddingRight;
        int leftOfCenter = availableWidth / 2;
        int rightOfCenter = leftOfCenter;

        HomeView homeLayout = mExpandedActionView != null ? mExpandedHomeLayout : mHomeLayout;

        if (homeLayout.getVisibility() != GONE) {
            final ViewGroup.LayoutParams lp = homeLayout.getLayoutParams();
            int homeWidthSpec;
            if (lp.width < 0) {
                homeWidthSpec = MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST);
            } else {
                homeWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
            }
            homeLayout.measure(homeWidthSpec,
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
            final int homeWidth = homeLayout.getMeasuredWidth() + homeLayout.getLeftOffset();
            availableWidth = Math.max(0, availableWidth - homeWidth);
            leftOfCenter = Math.max(0, availableWidth - homeWidth);
        }

        if (mMenuView != null && mMenuView.getParent() == this) {
            availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
            rightOfCenter = Math.max(0, rightOfCenter - mMenuView.getMeasuredWidth());
        }

        if (mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE) {
            availableWidth = measureChildView(mIndeterminateProgressView, availableWidth,
                    childSpecHeight, 0);
            rightOfCenter = Math.max(0,
                    rightOfCenter - mIndeterminateProgressView.getMeasuredWidth());
        }

        final boolean showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;

        if (mExpandedActionView == null) {
            switch (mNavigationMode) {
                case ActionBar.NAVIGATION_MODE_LIST:
                    if (mListNavLayout != null) {
                        final int itemPaddingSize = showTitle ? mItemPadding * 2 : mItemPadding;
                        availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                        leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                        mListNavLayout.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                        final int listNavWidth = mListNavLayout.getMeasuredWidth();
                        availableWidth = Math.max(0, availableWidth - listNavWidth);
                        leftOfCenter = Math.max(0, leftOfCenter - listNavWidth);
                    }
                    break;
                case ActionBar.NAVIGATION_MODE_TABS:
                    if (mTabScrollView != null) {
                        final int itemPaddingSize = showTitle ? mItemPadding * 2 : mItemPadding;
                        availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                        leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                        mTabScrollView.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                        final int tabWidth = mTabScrollView.getMeasuredWidth();
                        availableWidth = Math.max(0, availableWidth - tabWidth);
                        leftOfCenter = Math.max(0, leftOfCenter - tabWidth);
                    }
                    break;
            }
        }

        View customView = null;
        if (mExpandedActionView != null) {
            customView = mExpandedActionView;
        } else if ((mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0 &&
                mCustomNavView != null) {
            customView = mCustomNavView;
        }

        if (customView != null) {
            final ViewGroup.LayoutParams lp = generateLayoutParams(customView.getLayoutParams());
            final ActionBar.LayoutParams ablp = lp instanceof ActionBar.LayoutParams ?
                    (ActionBar.LayoutParams) lp : null;

            int horizontalMargin = 0;
            int verticalMargin = 0;
            if (ablp != null) {
                horizontalMargin = ablp.leftMargin + ablp.rightMargin;
                verticalMargin = ablp.topMargin + ablp.bottomMargin;
            }

            // If the action bar is wrapping to its content height, don't allow a custom
            // view to FILL_PARENT.
            int customNavHeightMode;
            if (mContentHeight <= 0) {
                customNavHeightMode = MeasureSpec.AT_MOST;
            } else {
                customNavHeightMode = lp.height != LayoutParams.WRAP_CONTENT ?
                        MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            }
            final int customNavHeight = Math.max(0,
                    (lp.height >= 0 ? Math.min(lp.height, height) : height) - verticalMargin);

            final int customNavWidthMode = lp.width != LayoutParams.WRAP_CONTENT ?
                    MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            int customNavWidth = Math.max(0,
                    (lp.width >= 0 ? Math.min(lp.width, availableWidth) : availableWidth)
                            - horizontalMargin);
            final int hgrav = (ablp != null ? ablp.gravity : DEFAULT_CUSTOM_GRAVITY) &
                    Gravity.HORIZONTAL_GRAVITY_MASK;

            // Centering a custom view is treated specially; we try to center within the whole
            // action bar rather than in the available space.
            if (hgrav == Gravity.CENTER_HORIZONTAL && lp.width == LayoutParams.FILL_PARENT) {
                customNavWidth = Math.min(leftOfCenter, rightOfCenter) * 2;
            }

            customView.measure(
                    MeasureSpec.makeMeasureSpec(customNavWidth, customNavWidthMode),
                    MeasureSpec.makeMeasureSpec(customNavHeight, customNavHeightMode));
            availableWidth -= horizontalMargin + customView.getMeasuredWidth();
        }

        if (mExpandedActionView == null && showTitle) {
            availableWidth = measureChildView(mTitleLayout, availableWidth,
                    MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY), 0);
            leftOfCenter = Math.max(0, leftOfCenter - mTitleLayout.getMeasuredWidth());
        }

        if (mContentHeight <= 0) {
            int measuredHeight = 0;
            for (int i = 0; i < childCount; i++) {
                View v = getChildAt(i);
                int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                if (paddedViewHeight > measuredHeight) {
                    measuredHeight = paddedViewHeight;
                }
            }
            setMeasuredDimension(contentWidth, measuredHeight);
        } else {
            setMeasuredDimension(contentWidth, maxHeight);
        }

        if (mContextView != null) {
            mContextView.setContentHeight(getMeasuredHeight());
        }

        if (mProgressView != null && mProgressView.getVisibility() != GONE) {
            mProgressView.measure(MeasureSpec.makeMeasureSpec(
                    contentWidth - mProgressBarPadding * 2, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.AT_MOST));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.379 -0400", hash_original_method = "F6845CE2E1688FA37DDDA5526B20E21E", hash_generated_method = "02978A29AE60B914715DB702292440AA")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int x = getPaddingLeft();
        final int y = getPaddingTop();
        final int contentHeight = b - t - getPaddingTop() - getPaddingBottom();

        if (contentHeight <= 0) {
            // Nothing to do if we can't see anything.
            return;
        }

        HomeView homeLayout = mExpandedActionView != null ? mExpandedHomeLayout : mHomeLayout;
        if (homeLayout.getVisibility() != GONE) {
            final int leftOffset = homeLayout.getLeftOffset();
            x += positionChild(homeLayout, x + leftOffset, y, contentHeight) + leftOffset;
        }

        if (mExpandedActionView == null) {
            final boolean showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE
                    &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
            if (showTitle) {
                x += positionChild(mTitleLayout, x, y, contentHeight);
            }

            switch (mNavigationMode) {
                case ActionBar.NAVIGATION_MODE_STANDARD:
                    break;
                case ActionBar.NAVIGATION_MODE_LIST:
                    if (mListNavLayout != null) {
                        if (showTitle) {
                            x += mItemPadding;
                        }
                        x += positionChild(mListNavLayout, x, y, contentHeight) + mItemPadding;
                    }
                    break;
                case ActionBar.NAVIGATION_MODE_TABS:
                    if (mTabScrollView != null) {
                        if (showTitle) {
                            x += mItemPadding;
                        }
                        x += positionChild(mTabScrollView, x, y, contentHeight) + mItemPadding;
                    }
                    break;
            }
        }

        int menuLeft = r - l - getPaddingRight();
        if (mMenuView != null && mMenuView.getParent() == this) {
            positionChildInverse(mMenuView, menuLeft, y, contentHeight);
            menuLeft -= mMenuView.getMeasuredWidth();
        }

        if (mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE) {
            positionChildInverse(mIndeterminateProgressView, menuLeft, y, contentHeight);
            menuLeft -= mIndeterminateProgressView.getMeasuredWidth();
        }

        View customView = null;
        if (mExpandedActionView != null) {
            customView = mExpandedActionView;
        } else if ((mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0 &&
                mCustomNavView != null) {
            customView = mCustomNavView;
        }
        if (customView != null) {
            ViewGroup.LayoutParams lp = customView.getLayoutParams();
            final ActionBar.LayoutParams ablp = lp instanceof ActionBar.LayoutParams ?
                    (ActionBar.LayoutParams) lp : null;

            final int gravity = ablp != null ? ablp.gravity : DEFAULT_CUSTOM_GRAVITY;
            final int navWidth = customView.getMeasuredWidth();

            int topMargin = 0;
            int bottomMargin = 0;
            if (ablp != null) {
                x += ablp.leftMargin;
                menuLeft -= ablp.rightMargin;
                topMargin = ablp.topMargin;
                bottomMargin = ablp.bottomMargin;
            }

            int hgravity = gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
            // See if we actually have room to truly center; if not push against left or right.
            if (hgravity == Gravity.CENTER_HORIZONTAL) {
                final int centeredLeft = (getWidth() - navWidth) / 2;
                if (centeredLeft < x) {
                    hgravity = Gravity.LEFT;
                } else if (centeredLeft + navWidth > menuLeft) {
                    hgravity = Gravity.RIGHT;
                }
            } else if (gravity == -1) {
                hgravity = Gravity.LEFT;
            }

            int xpos = 0;
            switch (hgravity) {
                case Gravity.CENTER_HORIZONTAL:
                    xpos = (getWidth() - navWidth) / 2;
                    break;
                case Gravity.LEFT:
                    xpos = x;
                    break;
                case Gravity.RIGHT:
                    xpos = menuLeft - navWidth;
                    break;
            }

            int vgravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;

            if (gravity == -1) {
                vgravity = Gravity.CENTER_VERTICAL;
            }

            int ypos = 0;
            switch (vgravity) {
                case Gravity.CENTER_VERTICAL:
                    final int paddedTop = getPaddingTop();
                    final int paddedBottom = getHeight() - getPaddingBottom();
                    ypos = ((paddedBottom - paddedTop) - customView.getMeasuredHeight()) / 2;
                    break;
                case Gravity.TOP:
                    ypos = getPaddingTop() + topMargin;
                    break;
                case Gravity.BOTTOM:
                    ypos = getHeight() - getPaddingBottom() - customView.getMeasuredHeight()
                            - bottomMargin;
                    break;
            }
            final int customWidth = customView.getMeasuredWidth();
            customView.layout(xpos, ypos, xpos + customWidth,
                    ypos + customView.getMeasuredHeight());
            x += customWidth;
        }

        if (mProgressView != null) {
            mProgressView.bringToFront();
            final int halfProgressHeight = mProgressView.getMeasuredHeight() / 2;
            mProgressView.layout(mProgressBarPadding, -halfProgressHeight,
                    mProgressBarPadding + mProgressView.getMeasuredWidth(), halfProgressHeight);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.386 -0400", hash_original_method = "5CAA9C4F0891E70178B26E7CA87F1572", hash_generated_method = "9EBEC5B7DEC53AE841138CE26158B891")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ActionBar.LayoutParams(getContext(), attrs);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.392 -0400", hash_original_method = "19310F391EC0B469A38234970BA36DD5", hash_generated_method = "A756D2D785960C2C4F2452AB82B33BD5")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }
        return lp;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.397 -0400", hash_original_method = "F7EC1EBD6989B5AFA75F6EFE3D4C9302", hash_generated_method = "C8427547B2C211AB3A999A7FEC15F01A")
    
@Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState state = new SavedState(superState);

        if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }

        state.isOverflowOpen = isOverflowMenuShowing();

        return state;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.403 -0400", hash_original_method = "70CC44C013E5649B526DBB27E55A818B", hash_generated_method = "0777965D03CA325025D100B1755DC03B")
    
@Override
    public void onRestoreInstanceState(Parcelable p) {
        SavedState state = (SavedState) p;

        super.onRestoreInstanceState(state.getSuperState());

        if (state.expandedMenuItemId != 0 &&
                mExpandedMenuPresenter != null && mOptionsMenu != null) {
            final SupportMenuItem item =
                    (SupportMenuItem) mOptionsMenu.findItem(state.expandedMenuItemId);
            if (item != null) {
                item.expandActionView();
            }
        }

        if (state.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.408 -0400", hash_original_method = "00BFD17BA7F19E95960B2CAA718DA76B", hash_generated_method = "79A9968D2710948BB0FFDC37BDE3BACE")
    
public void setHomeAsUpIndicator(Drawable indicator) {
        mHomeLayout.setUpIndicator(indicator);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-19 11:46:02.414 -0400", hash_original_method = "3DA346FB33E45C290F0FB8BE37DC5194", hash_generated_method = "C2C524BBE3BE5F34BF68163D8F48C562")
    
public void setHomeAsUpIndicator(int resId) {
        mHomeLayout.setUpIndicator(resId);
    }

    static class SavedState extends BaseSavedState {

        int expandedMenuItemId;
        boolean isOverflowOpen;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            expandedMenuItemId = in.readInt();
            isOverflowOpen = in.readInt() != 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(expandedMenuItemId);
            out.writeInt(isOverflowOpen ? 1 : 0);
        }

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
                    @DSSafe(DSCat.SAFE_LIST)
            public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    @DSSafe(DSCat.SAFE_LIST)
            public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
    }

    private static class HomeView extends FrameLayout {
        private ImageView mUpView;
        private ImageView mIconView;
        private int mUpWidth;
        private int mUpIndicatorRes;
        private Drawable mDefaultUpIndicator;

        public HomeView(Context context) {
            this(context, null);
        }

        public HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setUp(boolean isUp) {
            mUpView.setVisibility(isUp ? VISIBLE : GONE);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setIcon(Drawable icon) {
            mIconView.setImageDrawable(icon);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setUpIndicator(Drawable d) {
            mUpView.setImageDrawable(d != null ? d : mDefaultUpIndicator);
            mUpIndicatorRes = 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setUpIndicator(int resId) {
            mUpIndicatorRes = resId;
            mUpView.setImageDrawable(resId != 0 ? getResources().getDrawable(resId) : null);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        protected void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            if (mUpIndicatorRes != 0) {
                // Reload for config change
                setUpIndicator(mUpIndicatorRes);
            }
        }

        @DSSpec(DSCat.TO_MODEL)
        @Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            final CharSequence cdesc = getContentDescription();
            if (!TextUtils.isEmpty(cdesc)) {
                event.getText().add(cdesc);
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        protected void onFinishInflate() {
            mUpView = (ImageView) findViewById(R.id.up);
            mIconView = (ImageView) findViewById(R.id.home);
            mDefaultUpIndicator = mUpView.getDrawable();
        }

        @DSSafe(DSCat.SAFE_LIST)
        public int getLeftOffset() {
            return mUpView.getVisibility() == GONE ? mUpWidth : 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            measureChildWithMargins(mUpView, widthMeasureSpec, 0, heightMeasureSpec, 0);
            final LayoutParams upLp = (LayoutParams) mUpView.getLayoutParams();
            mUpWidth = upLp.leftMargin + mUpView.getMeasuredWidth() + upLp.rightMargin;
            int width = mUpView.getVisibility() == GONE ? 0 : mUpWidth;
            int height = upLp.topMargin + mUpView.getMeasuredHeight() + upLp.bottomMargin;
            measureChildWithMargins(mIconView, widthMeasureSpec, width, heightMeasureSpec, 0);
            final LayoutParams iconLp = (LayoutParams) mIconView.getLayoutParams();
            width += iconLp.leftMargin + mIconView.getMeasuredWidth() + iconLp.rightMargin;
            height = Math.max(height,
                    iconLp.topMargin + mIconView.getMeasuredHeight() + iconLp.bottomMargin);

            final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            final int heightSize = MeasureSpec.getSize(heightMeasureSpec);

            switch (widthMode) {
                case MeasureSpec.AT_MOST:
                    width = Math.min(width, widthSize);
                    break;
                case MeasureSpec.EXACTLY:
                    width = widthSize;
                    break;
                case MeasureSpec.UNSPECIFIED:
                default:
                    break;
            }
            switch (heightMode) {
                case MeasureSpec.AT_MOST:
                    height = Math.min(height, heightSize);
                    break;
                case MeasureSpec.EXACTLY:
                    height = heightSize;
                    break;
                case MeasureSpec.UNSPECIFIED:
                default:
                    break;
            }
            setMeasuredDimension(width, height);
        }

        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            final int vCenter = (b - t) / 2;
            int width = r - l;
            int upOffset = 0;
            if (mUpView.getVisibility() != GONE) {
                final LayoutParams upLp = (LayoutParams) mUpView.getLayoutParams();
                final int upHeight = mUpView.getMeasuredHeight();
                final int upWidth = mUpView.getMeasuredWidth();
                final int upTop = vCenter - upHeight / 2;
                mUpView.layout(0, upTop, upWidth, upTop + upHeight);
                upOffset = upLp.leftMargin + upWidth + upLp.rightMargin;
                width -= upOffset;
                l += upOffset;
            }
            final LayoutParams iconLp = (LayoutParams) mIconView.getLayoutParams();
            final int iconHeight = mIconView.getMeasuredHeight();
            final int iconWidth = mIconView.getMeasuredWidth();
            final int hCenter = (r - l) / 2;
            final int iconLeft = upOffset + Math.max(iconLp.leftMargin, hCenter - iconWidth / 2);
            final int iconTop = Math.max(iconLp.topMargin, vCenter - iconHeight / 2);
            mIconView.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {

        MenuBuilder mMenu;
        MenuItemImpl mCurrentExpandedItem;

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void initForMenu(Context context, MenuBuilder menu) {
            // Clear the expanded action view when menus change.
            if (mMenu != null && mCurrentExpandedItem != null) {
                mMenu.collapseItemActionView(mCurrentExpandedItem);
            }
            mMenu = menu;
        }

        @Override
        public MenuView getMenuView(ViewGroup root) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void updateMenuView(boolean cleared) {
            // Make sure the expanded item we have is still there.
            if (mCurrentExpandedItem != null) {
                boolean found = false;

                if (mMenu != null) {
                    final int count = mMenu.size();
                    for (int i = 0; i < count; i++) {
                        final SupportMenuItem item = (SupportMenuItem) mMenu.getItem(i);
                        if (item == mCurrentExpandedItem) {
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    // The item we had expanded disappeared. Collapse.
                    collapseItemActionView(mMenu, mCurrentExpandedItem);
                }
            }
        }

        @Override
        public void setCallback(Callback cb) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean flagActionItems() {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            mExpandedActionView = item.getActionView();
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
            mCurrentExpandedItem = item;
            if (mExpandedActionView.getParent() != ActionBarView.this) {
                addView(mExpandedActionView);
            }
            if (mExpandedHomeLayout.getParent() != ActionBarView.this) {
                addView(mExpandedHomeLayout);
            }
            mHomeLayout.setVisibility(GONE);
            if (mTitleLayout != null) {
                mTitleLayout.setVisibility(GONE);
            }
            if (mTabScrollView != null) {
                mTabScrollView.setVisibility(GONE);
            }
            if (mSpinner != null) {
                mSpinner.setVisibility(GONE);
            }
            if (mCustomNavView != null) {
                mCustomNavView.setVisibility(GONE);
            }
            requestLayout();
            item.setActionViewExpanded(true);

            if (mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) mExpandedActionView).onActionViewExpanded();
            }

            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
            // Do this before detaching the actionview from the hierarchy, in case
            // it needs to dismiss the soft keyboard, etc.
            if (mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) mExpandedActionView).onActionViewCollapsed();
            }

            removeView(mExpandedActionView);
            removeView(mExpandedHomeLayout);
            mExpandedActionView = null;
            if ((mDisplayOptions & ActionBar.DISPLAY_SHOW_HOME) != 0) {
                mHomeLayout.setVisibility(VISIBLE);
            }
            if ((mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0) {
                if (mTitleLayout == null) {
                    initTitle();
                } else {
                    mTitleLayout.setVisibility(VISIBLE);
                }
            }
            if (mTabScrollView != null && mNavigationMode == ActionBar.NAVIGATION_MODE_TABS) {
                mTabScrollView.setVisibility(VISIBLE);
            }
            if (mSpinner != null && mNavigationMode == ActionBar.NAVIGATION_MODE_LIST) {
                mSpinner.setVisibility(VISIBLE);
            }
            if (mCustomNavView != null && (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0) {
                mCustomNavView.setVisibility(VISIBLE);
            }
            mExpandedHomeLayout.setIcon(null);
            mCurrentExpandedItem = null;
            requestLayout();
            item.setActionViewExpanded(false);

            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public int getId() {
            return 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onRestoreInstanceState(Parcelable state) {
        }
    }
}

