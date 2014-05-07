package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

import com.android.internal.R;
import com.android.internal.view.menu.ActionMenuItem;
import com.android.internal.view.menu.ActionMenuPresenter;
import com.android.internal.view.menu.ActionMenuView;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuItemImpl;
import com.android.internal.view.menu.MenuPresenter;
import com.android.internal.view.menu.MenuView;
import com.android.internal.view.menu.SubMenuBuilder;

public class ActionBarView extends AbsActionBarView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.347 -0500", hash_original_field = "13E1B41D73BCA415DCDEC906E8D8082E", hash_generated_field = "CDFB47463B78F3368DF983B3BF1B285F")

    private static final String TAG = "ActionBarView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.350 -0500", hash_original_field = "E138855500438DF0270121A836DCD99E", hash_generated_field = "4A3C78D8B3B7DF5E626E3E97B7B40810")

    public static final int DISPLAY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.353 -0500", hash_original_field = "6638869DCB36083668E658C61CCB8AF0", hash_generated_field = "BC022A419127EDDE4E40524DA912F0E3")

    private static final int DISPLAY_RELAYOUT_MASK =
            ActionBar.DISPLAY_SHOW_HOME |
            ActionBar.DISPLAY_USE_LOGO |
            ActionBar.DISPLAY_HOME_AS_UP |
            ActionBar.DISPLAY_SHOW_CUSTOM |
            ActionBar.DISPLAY_SHOW_TITLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.356 -0500", hash_original_field = "C5C90C1ACEFF6F72E0613A9C2710627A", hash_generated_field = "3E11FBBE13E46A77B28D3C5EFE3B5DF0")

    private static final int DEFAULT_CUSTOM_GRAVITY = Gravity.LEFT | Gravity.CENTER_VERTICAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.359 -0500", hash_original_field = "798106CD7526C2079840C962AA54DB2F", hash_generated_field = "D7021ACCA51C37141CA5A3F0F0CB8D58")
    
    private int mNavigationMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.361 -0500", hash_original_field = "BDA13E1B19CA8C479B2D635CE6A6D5BF", hash_generated_field = "B097184BD65EEF760AB4457269F41FCE")

    private int mDisplayOptions = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.364 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.367 -0500", hash_original_field = "AB153FEBC9BAB866EB9D9BD858F863D7", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.369 -0500", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.372 -0500", hash_original_field = "AD986E3F362B588C5109C09E3AEE3117", hash_generated_field = "6A8F8D16CE24865FF96256279C68A01A")

    private Drawable mLogo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.374 -0500", hash_original_field = "5C0068FACE6B1BBC7F305A960008426B", hash_generated_field = "D44BE31A0DA12240E9EFFCC7D25F51CC")

    private HomeView mHomeLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.376 -0500", hash_original_field = "3959B8ED69EA5F3A81713941FFA2025F", hash_generated_field = "E38B6AFC0FF7040E207A508974C7E25A")

    private HomeView mExpandedHomeLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.378 -0500", hash_original_field = "F5CA594DCFB48DED54369A102A0AE68B", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.380 -0500", hash_original_field = "B3B1177DB6C3A24EAC74C6705FD25300", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.382 -0500", hash_original_field = "913CA974C51FCA87DC9298E376261903", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.384 -0500", hash_original_field = "899838E33DA7E0D538E2361BF0C03A1C", hash_generated_field = "F5B3209E54DA151E61A314A7F4D53CEE")

    private View mTitleUpView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.387 -0500", hash_original_field = "BEBDEDFD11469EABE9181A28E312C20A", hash_generated_field = "11476E269EBDAE78EE3F499A710729B2")

    private Spinner mSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.389 -0500", hash_original_field = "1363E7D01AE8F3E0EBA1B30929D3DD44", hash_generated_field = "3E145BA83F7246824E728DD8C128F1DB")

    private LinearLayout mListNavLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.391 -0500", hash_original_field = "AD923D267EC0F804E578816407CA8B0F", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.393 -0500", hash_original_field = "B005187E132A159D60D4C2C3B609E89E", hash_generated_field = "43AC585897322F8F4F6B26FAA521DECA")

    private View mCustomNavView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.396 -0500", hash_original_field = "BCD42CB43C3FDC6FEDA97EC405C3A28B", hash_generated_field = "20EB404BC594BDA3F66199C58EE5FBA2")

    private ProgressBar mProgressView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.398 -0500", hash_original_field = "88FC74FC0DFBFF7367A7587D4891D6BB", hash_generated_field = "7A5992B35882BB2A0D60B38B106CC08B")

    private ProgressBar mIndeterminateProgressView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.401 -0500", hash_original_field = "5CF83B212FF8552ABAA020AC5D602B28", hash_generated_field = "A3B6EB195053EBD51627D7173A9AE65D")

    private int mProgressBarPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.403 -0500", hash_original_field = "362CD4C51D06AEE140CC6E752ECE8458", hash_generated_field = "F1455EFA6BE686E648B8E824CB9E4B81")

    private int mItemPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.405 -0500", hash_original_field = "91BBE04D928B78D71ACCA8B7A1A78C5D", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")
    
    private int mTitleStyleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.407 -0500", hash_original_field = "1B837B3FAA0F380D6AF3C59E69CB3BE4", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.409 -0500", hash_original_field = "52B5373740A74E22C39A9E940D3C1F8D", hash_generated_field = "18CB7C9B43E54A91185B83C5D14435FA")

    private int mProgressStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.412 -0500", hash_original_field = "EE42873C4DD107ADD1FAB4BE05075814", hash_generated_field = "083E8134CFA4F8973249802B9A98C1E8")

    private int mIndeterminateProgressStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.414 -0500", hash_original_field = "BC597FAE0E0B5099AFFB47470C0E19A8", hash_generated_field = "0BAF72C7FF2EC45DE525F98CE324593F")

    private boolean mUserTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.416 -0500", hash_original_field = "448386E71B11CD06DD441057CF23BBC3", hash_generated_field = "968C4A904AD7ABC6144B6FCA2B427A80")

    private boolean mIncludeTabs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.419 -0500", hash_original_field = "E5BFD7FC9B1E72E91376CDB4B9D64459", hash_generated_field = "C0F5A22B3AA8A56D9DDAD5EF854478D3")

    private boolean mIsCollapsable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.421 -0500", hash_original_field = "AC8405742BFFC628CB21A1C91640FE34", hash_generated_field = "3AD368D522924E6E03967F9DD95F2CBA")

    private boolean mIsCollapsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.423 -0500", hash_original_field = "917FEAD1389D218E4B81B249AD63541D", hash_generated_field = "4278A1A241D9B74448B2E547C0296095")

    private MenuBuilder mOptionsMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.425 -0500", hash_original_field = "A5A9EDF61C66A197D158B006E66DA25C", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")
    
    private ActionBarContextView mContextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.427 -0500", hash_original_field = "D7F65785B7F41E20AE226E6BAF701A6E", hash_generated_field = "8C99101FC0313C08F73DD333D1CB1634")

    private ActionMenuItem mLogoNavItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.430 -0500", hash_original_field = "C6728ABFE96FBC761211FBFCF9FAA627", hash_generated_field = "3A2C8F67A3FD8ED91EC78875AB208830")

    private SpinnerAdapter mSpinnerAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.432 -0500", hash_original_field = "3AA3B40983CB34C0A7CA244F15002B79", hash_generated_field = "7A41771A4BE9BD1204FF01614115DD99")

    private OnNavigationListener mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.434 -0500", hash_original_field = "E682310941753B94BE1FECAC9286C6E9", hash_generated_field = "4C6A10C066298B16934A9F20792BEABB")

    private Runnable mTabSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.437 -0500", hash_original_field = "3A18A0899B7747CAC81D3533E30CC657", hash_generated_field = "87262EFC15C41A276BFA5FD764A20EF4")

    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.439 -0500", hash_original_field = "5B0D453753A571590EA0325BAB8050A5", hash_generated_field = "5B0D453753A571590EA0325BAB8050A5")

    View mExpandedActionView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.441 -0500", hash_original_field = "27B4F279DA726B6E62F72C86D786B686", hash_generated_field = "27B4F279DA726B6E62F72C86D786B686")

    Window.Callback mWindowCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.063 -0400", hash_original_field = "6570369C5D002BA40F3205CA42EDA077", hash_generated_field = "44876E5A80146202CAC9FD16865181DF")

    private final AdapterView.OnItemSelectedListener mNavItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.063 -0400", hash_original_method = "1DD2DCAB9C51672A3484006095504705", hash_generated_method = "546EE63100CD77A2ECCDAFF19BF96005")
        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            
            {
                mCallback.onNavigationItemSelected(position, id);
            } 
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.063 -0400", hash_original_method = "B71B11696BC75696BC2C4386B1729546", hash_generated_method = "CCFF701FC5F6240EA1EEF39B88699599")
        public void onNothingSelected(AdapterView parent) {
            
            addTaint(parent.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.064 -0400", hash_original_field = "130B48D14DC4F38293644D9F1154245C", hash_generated_field = "0D17A254F68203FB51BBDB9F44323A0B")

    private final OnClickListener mExpandedActionViewUpListener = new OnClickListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.064 -0400", hash_original_method = "71D7F82DC843779588A8591EEB5DDE73", hash_generated_method = "A5749FE279B69BB32FF6085A90DA41DC")
        @Override
        public void onClick(View v) {
            
            final MenuItemImpl item = mExpandedMenuPresenter.mCurrentExpandedItem;
            {
                item.collapseActionView();
            } 
            addTaint(v.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.064 -0400", hash_original_field = "4C4D79526CBF782D76A61735F6EF945A", hash_generated_field = "EA0963BA46506750424A660F31C059CE")

    private final OnClickListener mUpClickListener = new OnClickListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.064 -0400", hash_original_method = "19F57545305850BD0BBBD46104CC0B01", hash_generated_method = "7301E7CA22EE1FF39CCAA39323935474")
        public void onClick(View v) {
            
            mWindowCallback.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, mLogoNavItem);
            addTaint(v.getTaint());
            
        }
        
};
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.042 -0400", hash_original_method = "29E0288B7F0720C76BE42483EEC0C7FB", hash_generated_method = "0898DC393C560D3D16DF123CFB75AA46")
    public  ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        setBackgroundResource(0);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        ApplicationInfo appInfo = context.getApplicationInfo();
        PackageManager pm = context.getPackageManager();
        mNavigationMode = a.getInt(R.styleable.ActionBar_navigationMode,
                ActionBar.NAVIGATION_MODE_STANDARD);
        mTitle = a.getText(R.styleable.ActionBar_title);
        mSubtitle = a.getText(R.styleable.ActionBar_subtitle);
        mLogo = a.getDrawable(R.styleable.ActionBar_logo);
        if(mLogo == null)        
        {
            if(context instanceof Activity)            
            {
                try 
                {
                    mLogo = pm.getActivityLogo(((Activity) context).getComponentName());
                } //End block
                catch (NameNotFoundException e)
                {
                } //End block
            } //End block
            if(mLogo == null)            
            {
                mLogo = appInfo.loadLogo(pm);
            } //End block
        } //End block
        mIcon = a.getDrawable(R.styleable.ActionBar_icon);
        if(mIcon == null)        
        {
            if(context instanceof Activity)            
            {
                try 
                {
                    mIcon = pm.getActivityIcon(((Activity) context).getComponentName());
                } //End block
                catch (NameNotFoundException e)
                {
                } //End block
            } //End block
            if(mIcon == null)            
            {
                mIcon = appInfo.loadIcon(pm);
            } //End block
        } //End block
        final LayoutInflater inflater = LayoutInflater.from(context);
        final int homeResId = a.getResourceId(
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
        final int customNavId = a.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
        if(customNavId != 0)        
        {
            mCustomNavView = (View) inflater.inflate(customNavId, this, false);
            mNavigationMode = ActionBar.NAVIGATION_MODE_STANDARD;
            setDisplayOptions(mDisplayOptions | ActionBar.DISPLAY_SHOW_CUSTOM);
        } //End block
        mContentHeight = a.getLayoutDimension(R.styleable.ActionBar_height, 0);
        a.recycle();
        mLogoNavItem = new ActionMenuItem(context, 0, R.id.home, 0, 0, mTitle);
        mHomeLayout.setOnClickListener(mUpClickListener);
        mHomeLayout.setClickable(true);
        mHomeLayout.setFocusable(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.468 -0500", hash_original_method = "2EBE795462E90C610435C294048EA12C", hash_generated_method = "6B905B322231EDACA82D1172A0EDA5D2")
    
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
                lp.height = LayoutParams.MATCH_PARENT;
            }
            mTabScrollView.setAllowCollapse(true);
        }
    }

    /**
     * Set the window callback used to invoke menu items; used for dispatching home button presses.
     * @param cb Window callback to dispatch to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.470 -0500", hash_original_method = "3A6246ABFAB05CB7EB83E9ECE73695AD", hash_generated_method = "698F34FFF9DF6773FE5D3FE0502A0032")
    
public void setWindowCallback(Window.Callback cb) {
        mWindowCallback = cb;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.473 -0500", hash_original_method = "B71E506A9F91C1AD992AA849BAEDAF37", hash_generated_method = "11564454258926541E467EF7D156E0E2")
    
@Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mTabSelector);
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.476 -0500", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "FF1288C9953DCFF93F8070857A51FACB")
    
@Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.478 -0500", hash_original_method = "B34BEF81F3C7DDE70AA74FE44CD8EB1E", hash_generated_method = "F96998F05EC4398AC07936C0AFC0E219")
    
public void initProgress() {
        mProgressView = new ProgressBar(mContext, null, 0, mProgressStyle);
        mProgressView.setId(R.id.progress_horizontal);
        mProgressView.setMax(10000);
        addView(mProgressView);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.480 -0500", hash_original_method = "19799DC3DC7751972B9DF9EE182F1D74", hash_generated_method = "A71F21ED77994B1EAD3EBF731F839B3B")
    
public void initIndeterminateProgress() {
        mIndeterminateProgressView = new ProgressBar(mContext, null, 0,
                mIndeterminateProgressStyle);
        mIndeterminateProgressView.setId(R.id.progress_circular);
        addView(mIndeterminateProgressView);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.483 -0500", hash_original_method = "268F2B84CAE6E37FD4EC6111E5C155B1", hash_generated_method = "CBE3FD0931C814ED6FF7F1AFC55387AE")
    
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
                } else {
                    addView(mMenuView);
                }
            }
            if (mSplitView != null) {
                mSplitView.setVisibility(splitActionBar ? VISIBLE : GONE);
            }
            super.setSplitActionBar(splitActionBar);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.485 -0500", hash_original_method = "D1A0823C6A31D8186A466BCCCE11ADAA", hash_generated_method = "23FF4042628ECB52598485F8A635CED7")
    
public boolean isSplitActionBar() {
        return mSplitActionBar;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.487 -0500", hash_original_method = "24672C2D43139828573B39E460E47DBC", hash_generated_method = "434E54113F8F91662113CEF558A554CE")
    
public boolean hasEmbeddedTabs() {
        return mIncludeTabs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.491 -0500", hash_original_method = "8DB0348F40E3331B8E5DC32ABABAB86E", hash_generated_method = "CD09070E6210A38E7CB3916DD711E368")
    
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
            lp.height = LayoutParams.MATCH_PARENT;
            tabs.setAllowCollapse(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.493 -0500", hash_original_method = "0457D3AD4F802E9E3CD470071939A6F3", hash_generated_method = "57DDF22592ECC2D0A5B67A3F5CEE45B4")
    
public void setCallback(OnNavigationListener callback) {
        mCallback = callback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.497 -0500", hash_original_method = "FFAF505C90B4E5149598A1AECE2C3213", hash_generated_method = "7C3B62F79CF7BD676B16A92E0EB29349")
    
public void setMenu(Menu menu, MenuPresenter.Callback cb) {
        if (menu == mOptionsMenu) return;

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
            mActionMenuPresenter.setId(com.android.internal.R.id.action_menu_presenter);
            mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
        }

        ActionMenuView menuView;
        final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        if (!mSplitActionBar) {
            mActionMenuPresenter.setExpandedActionViewsExclusive(
                    getResources().getBoolean(
                    com.android.internal.R.bool.action_bar_expanded_action_views_exclusive));
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
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
            layoutParams.width = LayoutParams.MATCH_PARENT;
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.499 -0500", hash_original_method = "962CA6D106A54FF8005566B234E49437", hash_generated_method = "6E927733FD5FEC9041391C74480F71E2")
    
private void configPresenters(MenuBuilder builder) {
        if (builder != null) {
            builder.addMenuPresenter(mActionMenuPresenter);
            builder.addMenuPresenter(mExpandedMenuPresenter);
        } else {
            mActionMenuPresenter.initForMenu(mContext, null);
            mExpandedMenuPresenter.initForMenu(mContext, null);
            mActionMenuPresenter.updateMenuView(true);
            mExpandedMenuPresenter.updateMenuView(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.501 -0500", hash_original_method = "8730ED187B27F4DCB92C97E3B6342387", hash_generated_method = "8E450C9CC49CDC39420D68529D8F7C57")
    
public boolean hasExpandedActionView() {
        return mExpandedMenuPresenter != null &&
                mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.504 -0500", hash_original_method = "E064456058852E66BECDCC9D9AA06FF8", hash_generated_method = "935C62C6E3ABB275F854CE35F8704C21")
    
public void collapseActionView() {
        final MenuItemImpl item = mExpandedMenuPresenter == null ? null :
                mExpandedMenuPresenter.mCurrentExpandedItem;
        if (item != null) {
            item.collapseActionView();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.506 -0500", hash_original_method = "A015B4577A897E6E7B62945B8635CEDC", hash_generated_method = "8097342A33A2A7B74C3C1630B69D2DF4")
    
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

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.509 -0500", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E948C46F1704FC1F24545ED5A725BEE6")
    
public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Set the action bar title. This will always replace or override window titles.
     * @param title Title to set
     *
     * @see #setWindowTitle(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.511 -0500", hash_original_method = "777E3F031124EBDDD3E24D756483B885", hash_generated_method = "A635DB7C26E2429EA1B8A9304C9EDDDA")
    
public void setTitle(CharSequence title) {
        mUserTitle = true;
        setTitleImpl(title);
    }

    /**
     * Set the window title. A window title will always be replaced or overridden by a user title.
     * @param title Title to set
     *
     * @see #setTitle(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.513 -0500", hash_original_method = "193CF6C8B49C81B5000EB0B0B9EF604D", hash_generated_method = "7D041DA99A206D5D153585028300D290")
    
public void setWindowTitle(CharSequence title) {
        if (!mUserTitle) {
            setTitleImpl(title);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.515 -0500", hash_original_method = "CA4194BA53EDB0AC58DD1582B0D957BD", hash_generated_method = "6D6C733A34F59C16E124C6E8DD2AE9FF")
    
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

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.517 -0500", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "3773E52DB2B3822F51D6A3F2CB66D7C2")
    
public CharSequence getSubtitle() {
        return mSubtitle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.520 -0500", hash_original_method = "ECDAA3B767FC89031E52906AD709A8B9", hash_generated_method = "87D5DE49CDFD33F80D8B55121DC18BDE")
    
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

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.523 -0500", hash_original_method = "BA9334347A50C815DACE5C734F6D1CA6", hash_generated_method = "6EA9422385DBC3050585D775BA629E07")
    
public void setHomeButtonEnabled(boolean enable) {
        mHomeLayout.setEnabled(enable);
        mHomeLayout.setFocusable(enable);
        // Make sure the home button has an accurate content description for accessibility.
        if (!enable) {
            mHomeLayout.setContentDescription(null);
        } else if ((mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_up_description));
        } else {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_home_description));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.528 -0500", hash_original_method = "729D65DF169EDB552B2DB5DF7F633BF2", hash_generated_method = "5FD069929E95366164AF05012C272C1E")
    
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
                final boolean logoVis = mLogo != null && (options & ActionBar.DISPLAY_USE_LOGO) != 0;
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
                    R.string.action_bar_up_description));
        } else {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_home_description));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.530 -0500", hash_original_method = "030F447392EAF535A82C251E2DB0C9D4", hash_generated_method = "5B202422BF56B2451BF68C5EFA586349")
    
public void setIcon(Drawable icon) {
        mIcon = icon;
        if (icon != null &&
                ((mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) == 0 || mLogo == null)) {
            mHomeLayout.setIcon(icon);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.532 -0500", hash_original_method = "7424D4DE12B074743D84FF4154B309BA", hash_generated_method = "35C4B17B207D3493F49F75BF5BD06EC1")
    
public void setIcon(int resId) {
        setIcon(mContext.getResources().getDrawable(resId));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.535 -0500", hash_original_method = "6239F067617389BCFA9336EB6940A154", hash_generated_method = "59626619B688E0FD2250765B938463FD")
    
public void setLogo(Drawable logo) {
        mLogo = logo;
        if (logo != null && (mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) != 0) {
            mHomeLayout.setIcon(logo);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.537 -0500", hash_original_method = "8F48D1A1BD2CE39E1CCC3DD41DD8DBB5", hash_generated_method = "325D8DDD6B8334C0917A9A92F452998E")
    
public void setLogo(int resId) {
        setLogo(mContext.getResources().getDrawable(resId));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.540 -0500", hash_original_method = "7C440BC8D2AAA3D5B444BDD726AE7ED7", hash_generated_method = "928161B202ACE6E9E371EB40EE27E693")
    
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
                    mSpinner = new Spinner(mContext, null,
                            com.android.internal.R.attr.actionDropDownStyle);
                    mListNavLayout = new LinearLayout(mContext, null,
                            com.android.internal.R.attr.actionBarTabBarStyle);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.542 -0500", hash_original_method = "89B6C7658DAE063C75647F5ADF8E9216", hash_generated_method = "63CAE297B86EAF57E3C02B4590F1C656")
    
public void setDropdownAdapter(SpinnerAdapter adapter) {
        mSpinnerAdapter = adapter;
        if (mSpinner != null) {
            mSpinner.setAdapter(adapter);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.545 -0500", hash_original_method = "1A4098174F41A05D8E016C60876697BD", hash_generated_method = "55894F49F5FBF6100CC1C53E38147B3E")
    
public SpinnerAdapter getDropdownAdapter() {
        return mSpinnerAdapter;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.547 -0500", hash_original_method = "AD9310333D391F8A81F374E0D04AD8BB", hash_generated_method = "622B0A30BA3CF73798E669E09E27D592")
    
public void setDropdownSelectedPosition(int position) {
        mSpinner.setSelection(position);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.549 -0500", hash_original_method = "434984419C6BB9581BBBAD71AB1CA07D", hash_generated_method = "E9F16265F8BF68A09309130DBF94145D")
    
public int getDropdownSelectedPosition() {
        return mSpinner.getSelectedItemPosition();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.552 -0500", hash_original_method = "1544DDF36E6082443A2EF4ED7A4DF538", hash_generated_method = "0A8612C69308687D2CD30E6730C0871D")
    
public View getCustomNavigationView() {
        return mCustomNavView;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.554 -0500", hash_original_method = "14AA191B691A51A87445A62103C542CB", hash_generated_method = "D8E6902A052246660ED32E8D40DCF853")
    
public int getNavigationMode() {
        return mNavigationMode;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.556 -0500", hash_original_method = "7126F05C057CF7F499EBFF9A1F4C4A02", hash_generated_method = "B4E83287FE3A0B3A2131F7F64F8A178F")
    
public int getDisplayOptions() {
        return mDisplayOptions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.558 -0500", hash_original_method = "CC715ED5E40E0E0CF6C0353136D75335", hash_generated_method = "0E24BB9D465AB364636C002C06C2D9ED")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        // Used by custom nav views if they don't supply layout params. Everything else
        // added to an ActionBarView should have them already.
        return new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.561 -0500", hash_original_method = "5C54848E55EB765D8F0ED5A386E76AE7", hash_generated_method = "752F46793BAB47F3F8AA55C10445D8AC")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.564 -0500", hash_original_method = "CF8F187E9CF2FA51D65633927C0BE8F6", hash_generated_method = "1323BBE5C2CB556764AF69F171BAF855")
    
private void initTitle() {
        if (mTitleLayout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            mTitleLayout = (LinearLayout) inflater.inflate(R.layout.action_bar_title_item,
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.567 -0500", hash_original_method = "F623B40982707A8AF90610858040ED3E", hash_generated_method = "597C1542D85C984DDC1C93D329019FF9")
    
public void setContextView(ActionBarContextView view) {
        mContextView = view;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.569 -0500", hash_original_method = "4C7B7DAEF91C23BA8E2CF63957DDD2D5", hash_generated_method = "9C0A455DCFCA2976F747E6DE8D700DEC")
    
public void setCollapsable(boolean collapsable) {
        mIsCollapsable = collapsable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.571 -0500", hash_original_method = "85F70991FC3EED5A4EDF0B8F79DFC73E", hash_generated_method = "DC6000E70971618B215699E4846211E8")
    
public boolean isCollapsed() {
        return mIsCollapsed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.579 -0500", hash_original_method = "EDE59536C59F48F9C9A7E58A0D736A35", hash_generated_method = "01C1BFB3DAA97F06096E038D435E2AFB")
    
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
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
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
            // view to MATCH_PARENT.
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
            if (hgrav == Gravity.CENTER_HORIZONTAL && lp.width == LayoutParams.MATCH_PARENT) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.584 -0500", hash_original_method = "632E55F727AC38C1F794E2370B6AE161", hash_generated_method = "FBDD875FD63A75955B551FC381DE5B62")
    
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
            final boolean showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
            if (showTitle) {
                x += positionChild(mTitleLayout, x, y, contentHeight);
            }

            switch (mNavigationMode) {
                case ActionBar.NAVIGATION_MODE_STANDARD:
                    break;
                case ActionBar.NAVIGATION_MODE_LIST:
                    if (mListNavLayout != null) {
                        if (showTitle) x += mItemPadding;
                        x += positionChild(mListNavLayout, x, y, contentHeight) + mItemPadding;
                    }
                    break;
                case ActionBar.NAVIGATION_MODE_TABS:
                    if (mTabScrollView != null) {
                        if (showTitle) x += mItemPadding;
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
                final int centeredLeft = ((mRight - mLeft) - navWidth) / 2;
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
                    xpos = ((mRight - mLeft) - navWidth) / 2;
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
                    final int paddedBottom = mBottom - mTop - getPaddingBottom();
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
    
    static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.617 -0500", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.598 -0500", hash_original_field = "1334451307EEF9508F4B4B5CDDD0EBC6", hash_generated_field = "1334451307EEF9508F4B4B5CDDD0EBC6")

        int expandedMenuItemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.600 -0500", hash_original_field = "3F39ED06F388CD8B0407CDFD8FFF841F", hash_generated_field = "3F39ED06F388CD8B0407CDFD8FFF841F")

        boolean isOverflowOpen;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.603 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.606 -0500", hash_original_method = "D55BB2752CF51EBBB8F6639920409E43", hash_generated_method = "10724B7B96A85ADDB7EE54601CAFE7CB")
        
private SavedState(Parcel in) {
            super(in);
            expandedMenuItemId = in.readInt();
            isOverflowOpen = in.readInt() != 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.608 -0500", hash_original_method = "515851E7BACA5483746DDD359AD42324", hash_generated_method = "5187780AA67DF6AE317AFBE536A67AD7")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(expandedMenuItemId);
            out.writeInt(isOverflowOpen ? 1 : 0);
        }
    }
    
    private static class HomeView extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.621 -0500", hash_original_field = "65F95FE0CD7209FDABEB24B3AAAED5D5", hash_generated_field = "71A4D5441609517C4A8996E66BF5980D")

        private View mUpView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.624 -0500", hash_original_field = "069158469BB60C88A2C4A541C6AFB8D2", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.626 -0500", hash_original_field = "D8DE382731BC960ABC75D94D42E07344", hash_generated_field = "C112C51C138E32E2EAD57FF4525D9B75")

        private int mUpWidth;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.629 -0500", hash_original_method = "D411D61D16BBF4279D3867C1E411F377", hash_generated_method = "994A25BE7423264B200F6B65997FA7C0")
        
public HomeView(Context context) {
            this(context, null);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.631 -0500", hash_original_method = "A7CE440DF9BFAF8E10FD8D594704D071", hash_generated_method = "A812CA623716D8E85AE1D871C0B5381A")
        
public HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.633 -0500", hash_original_method = "9F32A31FB673DE4EC8BCDCE1EEBEDDFA", hash_generated_method = "C585B0359FC89CFC54CE304FAA65F640")
        
public void setUp(boolean isUp) {
            mUpView.setVisibility(isUp ? VISIBLE : GONE);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.636 -0500", hash_original_method = "F0A9CABDEAA57DB9E5ACC2CB832FAA3E", hash_generated_method = "5452CA065A738DC2BF4BEA31A0A3B24C")
        
public void setIcon(Drawable icon) {
            mIconView.setImageDrawable(icon);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.639 -0500", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "B2DB9880D1A02B35D29BED9E1EE131DA")
        
@Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            onPopulateAccessibilityEvent(event);
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.642 -0500", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "FC7F3A83CEC8ED8AF4EBACB87FAF6207")
        
@Override
        public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
            super.onPopulateAccessibilityEvent(event);
            final CharSequence cdesc = getContentDescription();
            if (!TextUtils.isEmpty(cdesc)) {
                event.getText().add(cdesc);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.644 -0500", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "F90F76EFAEEABFE6AC3C6C9354D0BBCC")
        
@Override
        public boolean dispatchHoverEvent(MotionEvent event) {
            // Don't allow children to hover; we want this to be treated as a single component.
            return onHoverEvent(event);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.647 -0500", hash_original_method = "2B32BD9128787E0840E1C599EF5CB94E", hash_generated_method = "10FD87B39DCD61216653C9A1E54C95DF")
        
@Override
        protected void onFinishInflate() {
            mUpView = findViewById(com.android.internal.R.id.up);
            mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.649 -0500", hash_original_method = "782BC6B05C8AB6ECAC8D4CC02CB172F4", hash_generated_method = "60FFCD248EE521C926D59B4E3DF0432C")
        
public int getLeftOffset() {
            return mUpView.getVisibility() == GONE ? mUpWidth : 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.653 -0500", hash_original_method = "1194BB929AE595B65CC6F2F618759EC2", hash_generated_method = "7651764E45F16A46823CB1094CFC0391")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.655 -0500", hash_original_method = "7C995435E08D7DDC1C5A7F44746F458B", hash_generated_method = "B7702F0F6B462F3700FCA8EF0EC8DBA7")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.662 -0500", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

        MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.664 -0500", hash_original_field = "A676BA3A3A833708C675CD6BF9D53F5E", hash_generated_field = "A676BA3A3A833708C675CD6BF9D53F5E")

        MenuItemImpl mCurrentExpandedItem;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_method = "D410F59FE51D215F3243D59D73778180", hash_generated_method = "D410F59FE51D215F3243D59D73778180")
        public ExpandedActionViewMenuPresenter ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.667 -0500", hash_original_method = "792819F971142AF5AE41DA85E214C5C9", hash_generated_method = "46FE09DD1DA9AC5B1C5E3F5144BC224F")
        
@Override
        public void initForMenu(Context context, MenuBuilder menu) {
            // Clear the expanded action view when menus change.
            if (mMenu != null && mCurrentExpandedItem != null) {
                mMenu.collapseItemActionView(mCurrentExpandedItem);
            }
            mMenu = menu;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.670 -0500", hash_original_method = "C60404B6CC35B9780D9F9822482B710D", hash_generated_method = "4C9D9B351543FAFD07AC3385F3D5E31F")
        
@Override
        public MenuView getMenuView(ViewGroup root) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.673 -0500", hash_original_method = "226E9F894ABBAE0501C29D5C6F0FF83B", hash_generated_method = "5EECAF063F2EF73FB6F3212DFC09E039")
        
@Override
        public void updateMenuView(boolean cleared) {
            // Make sure the expanded item we have is still there.
            if (mCurrentExpandedItem != null) {
                boolean found = false;

                if (mMenu != null) {
                    final int count = mMenu.size();
                    for (int i = 0; i < count; i++) {
                        final MenuItem item = mMenu.getItem(i);
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.675 -0500", hash_original_method = "C83F707E18EA3360FADD00AE5C28CDF5", hash_generated_method = "39977F7EF243BE28A4DF8D79BF83D61F")
        
@Override
        public void setCallback(Callback cb) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.677 -0500", hash_original_method = "7065AC4BF04829F4DD8494E3AEDE278B", hash_generated_method = "43C8A6DE92F290E6C342E82C05B1AC14")
        
@Override
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.680 -0500", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "DD07CEC7EC09520D51BD5EDFE9BFC1A9")
        
@Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.682 -0500", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "53EA63F11892B6B76B90A02A4F7BB199")
        
@Override
        public boolean flagActionItems() {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.685 -0500", hash_original_method = "995B7A71D6CB331F5D54C3F6E2CEFCD4", hash_generated_method = "4AC65E6494E5C7F98D4B56AC73EC08BC")
        
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
            if (mTitleLayout != null) mTitleLayout.setVisibility(GONE);
            if (mTabScrollView != null) mTabScrollView.setVisibility(GONE);
            if (mSpinner != null) mSpinner.setVisibility(GONE);
            if (mCustomNavView != null) mCustomNavView.setVisibility(GONE);
            requestLayout();
            item.setActionViewExpanded(true);

            if (mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) mExpandedActionView).onActionViewExpanded();
            }

            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.689 -0500", hash_original_method = "91D41E28867193763062F9A55820BEE2", hash_generated_method = "0F7C9DF3B61D25963161AAB39E5C63D2")
        
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

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.691 -0500", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "C0CB620CEC980AD85BC1EE1B6EA7B000")
        
@Override
        public int getId() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.693 -0500", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "D7C142582BEA8E084D7F8C19441F7839")
        
@Override
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.697 -0500", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "EA02457E24D7D58E860CD649C8CDC212")
        
@Override
        public void onRestoreInstanceState(Parcelable state) {
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.586 -0500", hash_original_method = "5CAA9C4F0891E70178B26E7CA87F1572", hash_generated_method = "9EBEC5B7DEC53AE841138CE26158B891")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ActionBar.LayoutParams(getContext(), attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.588 -0500", hash_original_method = "19310F391EC0B469A38234970BA36DD5", hash_generated_method = "A756D2D785960C2C4F2452AB82B33BD5")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }
        return lp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.591 -0500", hash_original_method = "F7EC1EBD6989B5AFA75F6EFE3D4C9302", hash_generated_method = "C8427547B2C211AB3A999A7FEC15F01A")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:43.594 -0500", hash_original_method = "2EB5982AB19EADE49A68C3033BC69293", hash_generated_method = "1CA8E45B8A71D1D6D2B7A8D06B45E277")
    
@Override
    public void onRestoreInstanceState(Parcelable p) {
        SavedState state = (SavedState) p;

        super.onRestoreInstanceState(state.getSuperState());

        if (state.expandedMenuItemId != 0 &&
                mExpandedMenuPresenter != null && mOptionsMenu != null) {
            final MenuItem item = mOptionsMenu.findItem(state.expandedMenuItemId);
            if (item != null) {
                item.expandActionView();
            }
        }

        if (state.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }
}

