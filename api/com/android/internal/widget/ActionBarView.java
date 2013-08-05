package com.android.internal.widget;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ActionBarView extends AbsActionBarView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.036 -0400", hash_original_field = "A75260FCE4EB84735EF4F8857FDD8871", hash_generated_field = "D7021ACCA51C37141CA5A3F0F0CB8D58")

    private int mNavigationMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.036 -0400", hash_original_field = "BFBD8ECCDDBCEF28ABBDF656C8D14C5F", hash_generated_field = "B097184BD65EEF760AB4457269F41FCE")

    private int mDisplayOptions = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.036 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.036 -0400", hash_original_field = "6EDD40BFDEB251E34BDCB1CE9C263665", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.036 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.036 -0400", hash_original_field = "27B9A7E56DA043F1C0A8546AD189F637", hash_generated_field = "6A8F8D16CE24865FF96256279C68A01A")

    private Drawable mLogo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "AAD87B797B16DEFE209BDDFA30686832", hash_generated_field = "D44BE31A0DA12240E9EFFCC7D25F51CC")

    private HomeView mHomeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "B57377976AD5D47F5FD05AD762068D75", hash_generated_field = "E38B6AFC0FF7040E207A508974C7E25A")

    private HomeView mExpandedHomeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "E04DEDB0B406830A59065795F4A530C9", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "68B3FAC852E3272F9F54C6B1610054DA", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "0A8A8271B4B28788D8A6C7232D2983D2", hash_generated_field = "F5B3209E54DA151E61A314A7F4D53CEE")

    private View mTitleUpView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "626AE3D18AA769A97988FB49E282FC0A", hash_generated_field = "11476E269EBDAE78EE3F499A710729B2")

    private Spinner mSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "A9C6CF7981E33FA053868DB1F1880979", hash_generated_field = "3E145BA83F7246824E728DD8C128F1DB")

    private LinearLayout mListNavLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "79971B4F2D39C7D687D7922DF67CCF83", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "83D8120DFA8ECB9C20ED77AB33236FFB", hash_generated_field = "43AC585897322F8F4F6B26FAA521DECA")

    private View mCustomNavView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "356BEA1A72BD3DB0203E9E44A65DA2AB", hash_generated_field = "20EB404BC594BDA3F66199C58EE5FBA2")

    private ProgressBar mProgressView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "DF38520CBF4259BF7B0123D79EF1394F", hash_generated_field = "7A5992B35882BB2A0D60B38B106CC08B")

    private ProgressBar mIndeterminateProgressView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "771CB7FAE5982467E651DA9700D79132", hash_generated_field = "A3B6EB195053EBD51627D7173A9AE65D")

    private int mProgressBarPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "BC2F3DA2B5A01B28AEEE241AD26D0666", hash_generated_field = "F1455EFA6BE686E648B8E824CB9E4B81")

    private int mItemPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "F00D2B188EA8D8F58E0764D2012CA069", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")

    private int mTitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.037 -0400", hash_original_field = "C0606F823BBDDA71B84334C05C268230", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "831CE0908E95C588131354EF3D249340", hash_generated_field = "18CB7C9B43E54A91185B83C5D14435FA")

    private int mProgressStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "8C381CD7C33B0DCE995BA02CBD02A306", hash_generated_field = "083E8134CFA4F8973249802B9A98C1E8")

    private int mIndeterminateProgressStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "5CF48434F2A8FB54D4F7A3EA3B9C8FC1", hash_generated_field = "0BAF72C7FF2EC45DE525F98CE324593F")

    private boolean mUserTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "C284BD664AB1FBB24C29B0515A0317FA", hash_generated_field = "968C4A904AD7ABC6144B6FCA2B427A80")

    private boolean mIncludeTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "DC3BE9CCFD3B9F2FED00A485BAD55556", hash_generated_field = "C0F5A22B3AA8A56D9DDAD5EF854478D3")

    private boolean mIsCollapsable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "1B035D60CEACF54763DA96643872A434", hash_generated_field = "3AD368D522924E6E03967F9DD95F2CBA")

    private boolean mIsCollapsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "C7532194647AFC2D4421630DA1B6C766", hash_generated_field = "4278A1A241D9B74448B2E547C0296095")

    private MenuBuilder mOptionsMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "13165738652608F9EE0CDB1A8EC90D22", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "51657654E85DFF84F82CA0D6D5EAD65D", hash_generated_field = "8C99101FC0313C08F73DD333D1CB1634")

    private ActionMenuItem mLogoNavItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "64E51C6821D8C1C9F3A28A738127D0DF", hash_generated_field = "3A2C8F67A3FD8ED91EC78875AB208830")

    private SpinnerAdapter mSpinnerAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "7A41771A4BE9BD1204FF01614115DD99")

    private OnNavigationListener mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "85B61EC738F2056493BB5A07F48F6CE2", hash_generated_field = "4C6A10C066298B16934A9F20792BEABB")

    private Runnable mTabSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "33DAF914C6A7B8055DA026382A6F67C5", hash_generated_field = "87262EFC15C41A276BFA5FD764A20EF4")

    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "A40A6F86F2AE21B265A171C20ACB9886", hash_generated_field = "5B0D453753A571590EA0325BAB8050A5")

    View mExpandedActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.038 -0400", hash_original_field = "ED8A48B4D3FB1C138C7CDF1360EBB754", hash_generated_field = "27B4F279DA726B6E62F72C86D786B686")

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
    
    @DSModeled(DSC.BAN)
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
        mLogoNavItem = new ActionMenuItem(context, 0, android.R.id.home, 0, 0, mTitle);
        mHomeLayout.setOnClickListener(mUpClickListener);
        mHomeLayout.setClickable(true);
        mHomeLayout.setFocusable(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.044 -0400", hash_original_method = "2EBE795462E90C610435C294048EA12C", hash_generated_method = "AAE4251C57D430B6C20BBD2B0C9678EF")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        mTitleView = null;
        mSubtitleView = null;
        mTitleUpView = null;
        if(mTitleLayout != null && mTitleLayout.getParent() == this)        
        {
            removeView(mTitleLayout);
        } //End block
        mTitleLayout = null;
        if((mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0)        
        {
            initTitle();
        } //End block
        if(mTabScrollView != null && mIncludeTabs)        
        {
            ViewGroup.LayoutParams lp = mTabScrollView.getLayoutParams();
            if(lp != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.044 -0400", hash_original_method = "3A6246ABFAB05CB7EB83E9ECE73695AD", hash_generated_method = "6E28EC11FE705A7FCC9A34CE65DD4AA2")
    public void setWindowCallback(Window.Callback cb) {
        mWindowCallback = cb;
        // ---------- Original Method ----------
        //mWindowCallback = cb;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.044 -0400", hash_original_method = "B71E506A9F91C1AD992AA849BAEDAF37", hash_generated_method = "6753224CBFF02BCCCF42799A44F41D25")
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        removeCallbacks(mTabSelector);
        if(mActionMenuPresenter != null)        
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.044 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "759CE8EEBEA0E076474E1C26AEAAFEAD")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var68934A3E9455FA72420237EB05902327_1850927261 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074562728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074562728;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.044 -0400", hash_original_method = "B34BEF81F3C7DDE70AA74FE44CD8EB1E", hash_generated_method = "810713CD928115B1FCC63244F35F9A90")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.045 -0400", hash_original_method = "19799DC3DC7751972B9DF9EE182F1D74", hash_generated_method = "3481A653820E0E31F3A19F10332F0CE7")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.045 -0400", hash_original_method = "268F2B84CAE6E37FD4EC6111E5C155B1", hash_generated_method = "2F5D9193597CB185B5E6C7D08065861B")
    @Override
    public void setSplitActionBar(boolean splitActionBar) {
        addTaint(splitActionBar);
        if(mSplitActionBar != splitActionBar)        
        {
            if(mMenuView != null)            
            {
                final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
                if(oldParent != null)                
                {
                    oldParent.removeView(mMenuView);
                } //End block
                if(splitActionBar)                
                {
                    if(mSplitView != null)                    
                    {
                        mSplitView.addView(mMenuView);
                    } //End block
                } //End block
                else
                {
                    addView(mMenuView);
                } //End block
            } //End block
            if(mSplitView != null)            
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.045 -0400", hash_original_method = "D1A0823C6A31D8186A466BCCCE11ADAA", hash_generated_method = "09D38E12E888F9D04E70D494211708A0")
    public boolean isSplitActionBar() {
        boolean var01607C3A00087AF535527D0068A14C4D_1244973008 = (mSplitActionBar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857468801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_857468801;
        // ---------- Original Method ----------
        //return mSplitActionBar;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.045 -0400", hash_original_method = "24672C2D43139828573B39E460E47DBC", hash_generated_method = "524C66EDA3E415B2EACE5D131D4A2717")
    public boolean hasEmbeddedTabs() {
        boolean varC284BD664AB1FBB24C29B0515A0317FA_1569081827 = (mIncludeTabs);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074159608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074159608;
        // ---------- Original Method ----------
        //return mIncludeTabs;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.046 -0400", hash_original_method = "8DB0348F40E3331B8E5DC32ABABAB86E", hash_generated_method = "F0A76D5E03E107DF36A55B0EC73A186B")
    public void setEmbeddedTabView(ScrollingTabContainerView tabs) {
        if(mTabScrollView != null)        
        {
            removeView(mTabScrollView);
        } //End block
        mTabScrollView = tabs;
        mIncludeTabs = tabs != null;
        if(mIncludeTabs && mNavigationMode == ActionBar.NAVIGATION_MODE_TABS)        
        {
            addView(mTabScrollView);
            ViewGroup.LayoutParams lp = mTabScrollView.getLayoutParams();
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.047 -0400", hash_original_method = "0457D3AD4F802E9E3CD470071939A6F3", hash_generated_method = "1D5D0E55A3097020CCF1A8E557F79F64")
    public void setCallback(OnNavigationListener callback) {
        mCallback = callback;
        // ---------- Original Method ----------
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.048 -0400", hash_original_method = "FFAF505C90B4E5149598A1AECE2C3213", hash_generated_method = "EA0A9AA1CF75E695682212EF5C6B717E")
    public void setMenu(Menu menu, MenuPresenter.Callback cb) {
        addTaint(cb.getTaint());
        addTaint(menu.getTaint());
        if(menu == mOptionsMenu)        
        return;
        if(mOptionsMenu != null)        
        {
            mOptionsMenu.removeMenuPresenter(mActionMenuPresenter);
            mOptionsMenu.removeMenuPresenter(mExpandedMenuPresenter);
        } //End block
        MenuBuilder builder = (MenuBuilder) menu;
        mOptionsMenu = builder;
        if(mMenuView != null)        
        {
            final ViewGroup oldParent = (ViewGroup) mMenuView.getParent();
            if(oldParent != null)            
            {
                oldParent.removeView(mMenuView);
            } //End block
        } //End block
        if(mActionMenuPresenter == null)        
        {
            mActionMenuPresenter = new ActionMenuPresenter(mContext);
            mActionMenuPresenter.setCallback(cb);
            mActionMenuPresenter.setId(com.android.internal.R.id.action_menu_presenter);
            mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
        } //End block
        ActionMenuView menuView;
        final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        if(!mSplitActionBar)        
        {
            mActionMenuPresenter.setExpandedActionViewsExclusive(
                    getResources().getBoolean(
                    com.android.internal.R.bool.action_bar_expanded_action_views_exclusive));
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            final ViewGroup oldParent = (ViewGroup) menuView.getParent();
            if(oldParent != null && oldParent != this)            
            {
                oldParent.removeView(menuView);
            } //End block
            addView(menuView, layoutParams);
        } //End block
        else
        {
            mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            mActionMenuPresenter.setWidthLimit(
                    getContext().getResources().getDisplayMetrics().widthPixels, true);
            mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            layoutParams.width = LayoutParams.MATCH_PARENT;
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            if(mSplitView != null)            
            {
                final ViewGroup oldParent = (ViewGroup) menuView.getParent();
                if(oldParent != null && oldParent != mSplitView)                
                {
                    oldParent.removeView(menuView);
                } //End block
                menuView.setVisibility(getAnimatedVisibility());
                mSplitView.addView(menuView, layoutParams);
            } //End block
            else
            {
                menuView.setLayoutParams(layoutParams);
            } //End block
        } //End block
        mMenuView = menuView;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.048 -0400", hash_original_method = "962CA6D106A54FF8005566B234E49437", hash_generated_method = "C2AE564D164A4E097CA3BD5F961DA629")
    private void configPresenters(MenuBuilder builder) {
        addTaint(builder.getTaint());
        if(builder != null)        
        {
            builder.addMenuPresenter(mActionMenuPresenter);
            builder.addMenuPresenter(mExpandedMenuPresenter);
        } //End block
        else
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.048 -0400", hash_original_method = "8730ED187B27F4DCB92C97E3B6342387", hash_generated_method = "385EB0B0F3B8F11511589682B6E6FBAD")
    public boolean hasExpandedActionView() {
        boolean var3C45A6F233002E53CBA4EA8AE13B13B1_1928307548 = (mExpandedMenuPresenter != null &&
                mExpandedMenuPresenter.mCurrentExpandedItem != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182957664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182957664;
        // ---------- Original Method ----------
        //return mExpandedMenuPresenter != null &&
                //mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "E064456058852E66BECDCC9D9AA06FF8", hash_generated_method = "EF0F41B64A65570158F18F8943BAB1F6")
    public void collapseActionView() {
        final MenuItemImpl item = mExpandedMenuPresenter == null ? null :
                mExpandedMenuPresenter.mCurrentExpandedItem;
        if(item != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "A015B4577A897E6E7B62945B8635CEDC", hash_generated_method = "FE90E588559385D128E3D68A2CD69CD2")
    public void setCustomNavigationView(View view) {
        final boolean showCustom = (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;
        if(mCustomNavView != null && showCustom)        
        {
            removeView(mCustomNavView);
        } //End block
        mCustomNavView = view;
        if(mCustomNavView != null && showCustom)        
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "0138EB6F304EAA58F7E5FAF61940B380")
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_19909773 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_19909773.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_19909773;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "777E3F031124EBDDD3E24D756483B885", hash_generated_method = "F3E7C0CE623A7D1DFA8A15C4AD4B5550")
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        mUserTitle = true;
        setTitleImpl(title);
        // ---------- Original Method ----------
        //mUserTitle = true;
        //setTitleImpl(title);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "193CF6C8B49C81B5000EB0B0B9EF604D", hash_generated_method = "1FC9FDD486FD9BBAD40ACDB9F02B3A41")
    public void setWindowTitle(CharSequence title) {
        addTaint(title.getTaint());
        if(!mUserTitle)        
        {
            setTitleImpl(title);
        } //End block
        // ---------- Original Method ----------
        //if (!mUserTitle) {
            //setTitleImpl(title);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "CA4194BA53EDB0AC58DD1582B0D957BD", hash_generated_method = "3DC6F5A9F12D68DF0AC7C861AC610C65")
    private void setTitleImpl(CharSequence title) {
        mTitle = title;
        if(mTitleView != null)        
        {
            mTitleView.setText(title);
            final boolean visible = mExpandedActionView == null &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0 &&
                    (!TextUtils.isEmpty(mTitle) || !TextUtils.isEmpty(mSubtitle));
            mTitleLayout.setVisibility(visible ? VISIBLE : GONE);
        } //End block
        if(mLogoNavItem != null)        
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "22A57514CD19F12D0DD15600537A9BE2")
    public CharSequence getSubtitle() {
CharSequence varB3753FC770C7D70B94AC4A298F41B100_1142964725 =         mSubtitle;
        varB3753FC770C7D70B94AC4A298F41B100_1142964725.addTaint(taint);
        return varB3753FC770C7D70B94AC4A298F41B100_1142964725;
        // ---------- Original Method ----------
        //return mSubtitle;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.049 -0400", hash_original_method = "ECDAA3B767FC89031E52906AD709A8B9", hash_generated_method = "91862A38AA48709D3B154D20B7079339")
    public void setSubtitle(CharSequence subtitle) {
        mSubtitle = subtitle;
        if(mSubtitleView != null)        
        {
            mSubtitleView.setText(subtitle);
            mSubtitleView.setVisibility(subtitle != null ? VISIBLE : GONE);
            final boolean visible = mExpandedActionView == null &&
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.050 -0400", hash_original_method = "BA9334347A50C815DACE5C734F6D1CA6", hash_generated_method = "54639126B1388655134AAD5D22B41DD3")
    public void setHomeButtonEnabled(boolean enable) {
        addTaint(enable);
        mHomeLayout.setEnabled(enable);
        mHomeLayout.setFocusable(enable);
        if(!enable)        
        {
            mHomeLayout.setContentDescription(null);
        } //End block
        else
        if((mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0)        
        {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_up_description));
        } //End block
        else
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.050 -0400", hash_original_method = "729D65DF169EDB552B2DB5DF7F633BF2", hash_generated_method = "6EB723519458A62A5A4F81346E7148A6")
    public void setDisplayOptions(int options) {
        final int flagsChanged = mDisplayOptions == -1 ? -1 : options ^ mDisplayOptions;
        mDisplayOptions = options;
        if((flagsChanged & DISPLAY_RELAYOUT_MASK) != 0)        
        {
            final boolean showHome = (options & ActionBar.DISPLAY_SHOW_HOME) != 0;
            final int vis = showHome && mExpandedActionView == null ? VISIBLE : GONE;
            mHomeLayout.setVisibility(vis);
            if((flagsChanged & ActionBar.DISPLAY_HOME_AS_UP) != 0)            
            {
                final boolean setUp = (options & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mHomeLayout.setUp(setUp);
                if(setUp)                
                {
                    setHomeButtonEnabled(true);
                } //End block
            } //End block
            if((flagsChanged & ActionBar.DISPLAY_USE_LOGO) != 0)            
            {
                final boolean logoVis = mLogo != null && (options & ActionBar.DISPLAY_USE_LOGO) != 0;
                mHomeLayout.setIcon(logoVis ? mLogo : mIcon);
            } //End block
            if((flagsChanged & ActionBar.DISPLAY_SHOW_TITLE) != 0)            
            {
                if((options & ActionBar.DISPLAY_SHOW_TITLE) != 0)                
                {
                    initTitle();
                } //End block
                else
                {
                    removeView(mTitleLayout);
                } //End block
            } //End block
            if(mTitleLayout != null && (flagsChanged &
                    (ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME)) != 0)            
            {
                final boolean homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
                mTitleLayout.setEnabled(!showHome && homeAsUp);
            } //End block
            if((flagsChanged & ActionBar.DISPLAY_SHOW_CUSTOM) != 0 && mCustomNavView != null)            
            {
                if((options & ActionBar.DISPLAY_SHOW_CUSTOM) != 0)                
                {
                    addView(mCustomNavView);
                } //End block
                else
                {
                    removeView(mCustomNavView);
                } //End block
            } //End block
            requestLayout();
        } //End block
        else
        {
            invalidate();
        } //End block
        if(!mHomeLayout.isEnabled())        
        {
            mHomeLayout.setContentDescription(null);
        } //End block
        else
        if((options & ActionBar.DISPLAY_HOME_AS_UP) != 0)        
        {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_up_description));
        } //End block
        else
        {
            mHomeLayout.setContentDescription(mContext.getResources().getText(
                    R.string.action_bar_home_description));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.051 -0400", hash_original_method = "030F447392EAF535A82C251E2DB0C9D4", hash_generated_method = "E13F2C064C2D37D648856C7D1419CF5D")
    public void setIcon(Drawable icon) {
        mIcon = icon;
        if(icon != null &&
                ((mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) == 0 || mLogo == null))        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.051 -0400", hash_original_method = "7424D4DE12B074743D84FF4154B309BA", hash_generated_method = "EA8EB6CE26EE218305E51DCB331171B9")
    public void setIcon(int resId) {
        addTaint(resId);
        setIcon(mContext.getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setIcon(mContext.getResources().getDrawable(resId));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.051 -0400", hash_original_method = "6239F067617389BCFA9336EB6940A154", hash_generated_method = "B4CAB4CACB6E53E2E1E72EF650685C66")
    public void setLogo(Drawable logo) {
        mLogo = logo;
        if(logo != null && (mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) != 0)        
        {
            mHomeLayout.setIcon(logo);
        } //End block
        // ---------- Original Method ----------
        //mLogo = logo;
        //if (logo != null && (mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) != 0) {
            //mHomeLayout.setIcon(logo);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.051 -0400", hash_original_method = "8F48D1A1BD2CE39E1CCC3DD41DD8DBB5", hash_generated_method = "83F4DC777687313EE5FE4B6E3CBAD3BD")
    public void setLogo(int resId) {
        addTaint(resId);
        setLogo(mContext.getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setLogo(mContext.getResources().getDrawable(resId));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.051 -0400", hash_original_method = "7C440BC8D2AAA3D5B444BDD726AE7ED7", hash_generated_method = "6E270B83E8976BD3EC2985D2FD359D8A")
    public void setNavigationMode(int mode) {
        final int oldMode = mNavigationMode;
        if(mode != oldMode)        
        {
switch(oldMode){
            case ActionBar.NAVIGATION_MODE_LIST:
            if(mListNavLayout != null)            
            {
                removeView(mListNavLayout);
            } //End block
            break;
            case ActionBar.NAVIGATION_MODE_TABS:
            if(mTabScrollView != null && mIncludeTabs)            
            {
                removeView(mTabScrollView);
            } //End block
}switch(mode){
            case ActionBar.NAVIGATION_MODE_LIST:
            if(mSpinner == null)            
            {
                mSpinner = new Spinner(mContext, null,
                            com.android.internal.R.attr.actionDropDownStyle);
                mListNavLayout = new LinearLayout(mContext, null,
                            com.android.internal.R.attr.actionBarTabBarStyle);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                params.gravity = Gravity.CENTER;
                mListNavLayout.addView(mSpinner, params);
            } //End block
            if(mSpinner.getAdapter() != mSpinnerAdapter)            
            {
                mSpinner.setAdapter(mSpinnerAdapter);
            } //End block
            mSpinner.setOnItemSelectedListener(mNavItemSelectedListener);
            addView(mListNavLayout);
            break;
            case ActionBar.NAVIGATION_MODE_TABS:
            if(mTabScrollView != null && mIncludeTabs)            
            {
                addView(mTabScrollView);
            } //End block
            break;
}            mNavigationMode = mode;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "89B6C7658DAE063C75647F5ADF8E9216", hash_generated_method = "194FF8C8D208956861201F10CC1D6060")
    public void setDropdownAdapter(SpinnerAdapter adapter) {
        mSpinnerAdapter = adapter;
        if(mSpinner != null)        
        {
            mSpinner.setAdapter(adapter);
        } //End block
        // ---------- Original Method ----------
        //mSpinnerAdapter = adapter;
        //if (mSpinner != null) {
            //mSpinner.setAdapter(adapter);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "1A4098174F41A05D8E016C60876697BD", hash_generated_method = "77E6004BD8B0B7DEA55C18D9D2B2F90B")
    public SpinnerAdapter getDropdownAdapter() {
SpinnerAdapter var79AFBFAED508E1AC19B2F54870F6FE19_1824066454 =         mSpinnerAdapter;
        var79AFBFAED508E1AC19B2F54870F6FE19_1824066454.addTaint(taint);
        return var79AFBFAED508E1AC19B2F54870F6FE19_1824066454;
        // ---------- Original Method ----------
        //return mSpinnerAdapter;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "AD9310333D391F8A81F374E0D04AD8BB", hash_generated_method = "AA935432E20FF42EED4B6AA29C1F5C53")
    public void setDropdownSelectedPosition(int position) {
        addTaint(position);
        mSpinner.setSelection(position);
        // ---------- Original Method ----------
        //mSpinner.setSelection(position);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "434984419C6BB9581BBBAD71AB1CA07D", hash_generated_method = "31DBCC0D55C458E70D1EF6B8A577AAE6")
    public int getDropdownSelectedPosition() {
        int var9E8D3239103059DF20A715201641E197_1957489320 = (mSpinner.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98906111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98906111;
        // ---------- Original Method ----------
        //return mSpinner.getSelectedItemPosition();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "1544DDF36E6082443A2EF4ED7A4DF538", hash_generated_method = "BD5625C1DB0FBDFBD3BAAA65D480D459")
    public View getCustomNavigationView() {
View varA1566A9700A1233FDE78839FC63F371B_1719683740 =         mCustomNavView;
        varA1566A9700A1233FDE78839FC63F371B_1719683740.addTaint(taint);
        return varA1566A9700A1233FDE78839FC63F371B_1719683740;
        // ---------- Original Method ----------
        //return mCustomNavView;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "14AA191B691A51A87445A62103C542CB", hash_generated_method = "EB19D7C6C2FE924502DB1DE26E53D35C")
    public int getNavigationMode() {
        int varA75260FCE4EB84735EF4F8857FDD8871_590180443 = (mNavigationMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126067939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126067939;
        // ---------- Original Method ----------
        //return mNavigationMode;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.052 -0400", hash_original_method = "7126F05C057CF7F499EBFF9A1F4C4A02", hash_generated_method = "EC9ECCBAC005BFCBEEBC5DEE37474E31")
    public int getDisplayOptions() {
        int var428046B06187CDAB69BA94BDD1A9EE1A_201278294 = (mDisplayOptions);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827680338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827680338;
        // ---------- Original Method ----------
        //return mDisplayOptions;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.053 -0400", hash_original_method = "CC715ED5E40E0E0CF6C0353136D75335", hash_generated_method = "0F9BC753D011321A818A0F9CEC08746F")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
ViewGroup.LayoutParams varACCA7D0C461BCFC3C06B8B393FD0A4CF_334761005 =         new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
        varACCA7D0C461BCFC3C06B8B393FD0A4CF_334761005.addTaint(taint);
        return varACCA7D0C461BCFC3C06B8B393FD0A4CF_334761005;
        // ---------- Original Method ----------
        //return new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.053 -0400", hash_original_method = "5C54848E55EB765D8F0ED5A386E76AE7", hash_generated_method = "BCF0431879B20F2275ECC25727077045")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        addView(mHomeLayout);
        if(mCustomNavView != null && (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0)        
        {
            final ViewParent parent = mCustomNavView.getParent();
            if(parent != this)            
            {
                if(parent instanceof ViewGroup)                
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.053 -0400", hash_original_method = "CF8F187E9CF2FA51D65633927C0BE8F6", hash_generated_method = "5070D5F48EDD11EAEFEB14B6C197633A")
    private void initTitle() {
        if(mTitleLayout == null)        
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            mTitleLayout = (LinearLayout) inflater.inflate(R.layout.action_bar_title_item,
                    this, false);
            mTitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_title);
            mSubtitleView = (TextView) mTitleLayout.findViewById(R.id.action_bar_subtitle);
            mTitleUpView = (View) mTitleLayout.findViewById(R.id.up);
            mTitleLayout.setOnClickListener(mUpClickListener);
            if(mTitleStyleRes != 0)            
            {
                mTitleView.setTextAppearance(mContext, mTitleStyleRes);
            } //End block
            if(mTitle != null)            
            {
                mTitleView.setText(mTitle);
            } //End block
            if(mSubtitleStyleRes != 0)            
            {
                mSubtitleView.setTextAppearance(mContext, mSubtitleStyleRes);
            } //End block
            if(mSubtitle != null)            
            {
                mSubtitleView.setText(mSubtitle);
                mSubtitleView.setVisibility(VISIBLE);
            } //End block
            final boolean homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
            final boolean showHome = (mDisplayOptions & ActionBar.DISPLAY_SHOW_HOME) != 0;
            mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
            mTitleLayout.setEnabled(homeAsUp && !showHome);
        } //End block
        addView(mTitleLayout);
        if(mExpandedActionView != null ||
                (TextUtils.isEmpty(mTitle) && TextUtils.isEmpty(mSubtitle)))        
        {
            mTitleLayout.setVisibility(GONE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.053 -0400", hash_original_method = "F623B40982707A8AF90610858040ED3E", hash_generated_method = "D4BCFE83BC3C16939B58F9C8F60CB578")
    public void setContextView(ActionBarContextView view) {
        mContextView = view;
        // ---------- Original Method ----------
        //mContextView = view;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.054 -0400", hash_original_method = "4C7B7DAEF91C23BA8E2CF63957DDD2D5", hash_generated_method = "D1B4B964836E41A41374E901B2F6E0A6")
    public void setCollapsable(boolean collapsable) {
        mIsCollapsable = collapsable;
        // ---------- Original Method ----------
        //mIsCollapsable = collapsable;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.054 -0400", hash_original_method = "85F70991FC3EED5A4EDF0B8F79DFC73E", hash_generated_method = "E5F3499F709A148412635DAA32113CC5")
    public boolean isCollapsed() {
        boolean var1B035D60CEACF54763DA96643872A434_1320992168 = (mIsCollapsed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119704845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_119704845;
        // ---------- Original Method ----------
        //return mIsCollapsed;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.056 -0400", hash_original_method = "EDE59536C59F48F9C9A7E58A0D736A35", hash_generated_method = "25F1D63396D72941CF06D76C3D3BF9AF")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int childCount = getChildCount();
        if(mIsCollapsable)        
        {
            int visibleChildren = 0;
for(int i = 0;i < childCount;i++)
            {
                final View child = getChildAt(i);
                if(child.getVisibility() != GONE &&
                        !(child == mMenuView && mMenuView.getChildCount() == 0))                
                {
                    visibleChildren++;
                } //End block
            } //End block
            if(visibleChildren == 0)            
            {
                setMeasuredDimension(0, 0);
                mIsCollapsed = true;
                return;
            } //End block
        } //End block
        mIsCollapsed = false;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if(widthMode != MeasureSpec.EXACTLY)        
        {
            IllegalStateException var0078FEAADAE205F1DDF3953FFCC7DD03_2055952979 = new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
            var0078FEAADAE205F1DDF3953FFCC7DD03_2055952979.addTaint(taint);
            throw var0078FEAADAE205F1DDF3953FFCC7DD03_2055952979;
        } //End block
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if(heightMode != MeasureSpec.AT_MOST)        
        {
            IllegalStateException var2F6FC63DCF083FE3E3F7F2BC6369EDB9_530130183 = new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
            var2F6FC63DCF083FE3E3F7F2BC6369EDB9_530130183.addTaint(taint);
            throw var2F6FC63DCF083FE3E3F7F2BC6369EDB9_530130183;
        } //End block
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
        if(homeLayout.getVisibility() != GONE)        
        {
            final ViewGroup.LayoutParams lp = homeLayout.getLayoutParams();
            int homeWidthSpec;
            if(lp.width < 0)            
            {
                homeWidthSpec = MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST);
            } //End block
            else
            {
                homeWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
            } //End block
            homeLayout.measure(homeWidthSpec,
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
            final int homeWidth = homeLayout.getMeasuredWidth() + homeLayout.getLeftOffset();
            availableWidth = Math.max(0, availableWidth - homeWidth);
            leftOfCenter = Math.max(0, availableWidth - homeWidth);
        } //End block
        if(mMenuView != null && mMenuView.getParent() == this)        
        {
            availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
            rightOfCenter = Math.max(0, rightOfCenter - mMenuView.getMeasuredWidth());
        } //End block
        if(mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE)        
        {
            availableWidth = measureChildView(mIndeterminateProgressView, availableWidth,
                    childSpecHeight, 0);
            rightOfCenter = Math.max(0,
                    rightOfCenter - mIndeterminateProgressView.getMeasuredWidth());
        } //End block
        final boolean showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
        if(mExpandedActionView == null)        
        {
switch(mNavigationMode){
            case ActionBar.NAVIGATION_MODE_LIST:
            if(mListNavLayout != null)            
            {
                final int itemPaddingSize = showTitle ? mItemPadding * 2 : mItemPadding;
                availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                mListNavLayout.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                final int listNavWidth = mListNavLayout.getMeasuredWidth();
                availableWidth = Math.max(0, availableWidth - listNavWidth);
                leftOfCenter = Math.max(0, leftOfCenter - listNavWidth);
            } //End block
            break;
            case ActionBar.NAVIGATION_MODE_TABS:
            if(mTabScrollView != null)            
            {
                final int itemPaddingSize = showTitle ? mItemPadding * 2 : mItemPadding;
                availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                mTabScrollView.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                final int tabWidth = mTabScrollView.getMeasuredWidth();
                availableWidth = Math.max(0, availableWidth - tabWidth);
                leftOfCenter = Math.max(0, leftOfCenter - tabWidth);
            } //End block
            break;
}
        } //End block
        View customView = null;
        if(mExpandedActionView != null)        
        {
            customView = mExpandedActionView;
        } //End block
        else
        if((mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0 &&
                mCustomNavView != null)        
        {
            customView = mCustomNavView;
        } //End block
        if(customView != null)        
        {
            final ViewGroup.LayoutParams lp = generateLayoutParams(customView.getLayoutParams());
            final ActionBar.LayoutParams ablp = lp instanceof ActionBar.LayoutParams ?
                    (ActionBar.LayoutParams) lp : null;
            int horizontalMargin = 0;
            int verticalMargin = 0;
            if(ablp != null)            
            {
                horizontalMargin = ablp.leftMargin + ablp.rightMargin;
                verticalMargin = ablp.topMargin + ablp.bottomMargin;
            } //End block
            int customNavHeightMode;
            if(mContentHeight <= 0)            
            {
                customNavHeightMode = MeasureSpec.AT_MOST;
            } //End block
            else
            {
                customNavHeightMode = lp.height != LayoutParams.WRAP_CONTENT ?
                        MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            } //End block
            final int customNavHeight = Math.max(0,
                    (lp.height >= 0 ? Math.min(lp.height, height) : height) - verticalMargin);
            final int customNavWidthMode = lp.width != LayoutParams.WRAP_CONTENT ?
                    MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;
            int customNavWidth = Math.max(0,
                    (lp.width >= 0 ? Math.min(lp.width, availableWidth) : availableWidth)
                    - horizontalMargin);
            final int hgrav = (ablp != null ? ablp.gravity : DEFAULT_CUSTOM_GRAVITY) &
                    Gravity.HORIZONTAL_GRAVITY_MASK;
            if(hgrav == Gravity.CENTER_HORIZONTAL && lp.width == LayoutParams.MATCH_PARENT)            
            {
                customNavWidth = Math.min(leftOfCenter, rightOfCenter) * 2;
            } //End block
            customView.measure(
                    MeasureSpec.makeMeasureSpec(customNavWidth, customNavWidthMode),
                    MeasureSpec.makeMeasureSpec(customNavHeight, customNavHeightMode));
            availableWidth -= horizontalMargin + customView.getMeasuredWidth();
        } //End block
        if(mExpandedActionView == null && showTitle)        
        {
            availableWidth = measureChildView(mTitleLayout, availableWidth,
                    MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY), 0);
            leftOfCenter = Math.max(0, leftOfCenter - mTitleLayout.getMeasuredWidth());
        } //End block
        if(mContentHeight <= 0)        
        {
            int measuredHeight = 0;
for(int i = 0;i < childCount;i++)
            {
                View v = getChildAt(i);
                int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                if(paddedViewHeight > measuredHeight)                
                {
                    measuredHeight = paddedViewHeight;
                } //End block
            } //End block
            setMeasuredDimension(contentWidth, measuredHeight);
        } //End block
        else
        {
            setMeasuredDimension(contentWidth, maxHeight);
        } //End block
        if(mContextView != null)        
        {
            mContextView.setContentHeight(getMeasuredHeight());
        } //End block
        if(mProgressView != null && mProgressView.getVisibility() != GONE)        
        {
            mProgressView.measure(MeasureSpec.makeMeasureSpec(
                    contentWidth - mProgressBarPadding * 2, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.AT_MOST));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.059 -0400", hash_original_method = "632E55F727AC38C1F794E2370B6AE161", hash_generated_method = "377552AE47458209C921852D4EFB5C2D")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        int x = getPaddingLeft();
        final int y = getPaddingTop();
        final int contentHeight = b - t - getPaddingTop() - getPaddingBottom();
        if(contentHeight <= 0)        
        {
            return;
        } //End block
        HomeView homeLayout = mExpandedActionView != null ? mExpandedHomeLayout : mHomeLayout;
        if(homeLayout.getVisibility() != GONE)        
        {
            final int leftOffset = homeLayout.getLeftOffset();
            x += positionChild(homeLayout, x + leftOffset, y, contentHeight) + leftOffset;
        } //End block
        if(mExpandedActionView == null)        
        {
            final boolean showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                    (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
            if(showTitle)            
            {
                x += positionChild(mTitleLayout, x, y, contentHeight);
            } //End block
switch(mNavigationMode){
            case ActionBar.NAVIGATION_MODE_STANDARD:
            break;
            case ActionBar.NAVIGATION_MODE_LIST:
            if(mListNavLayout != null)            
            {
                if(showTitle)                
                x += mItemPadding;
                x += positionChild(mListNavLayout, x, y, contentHeight) + mItemPadding;
            } //End block
            break;
            case ActionBar.NAVIGATION_MODE_TABS:
            if(mTabScrollView != null)            
            {
                if(showTitle)                
                x += mItemPadding;
                x += positionChild(mTabScrollView, x, y, contentHeight) + mItemPadding;
            } //End block
            break;
}
        } //End block
        int menuLeft = r - l - getPaddingRight();
        if(mMenuView != null && mMenuView.getParent() == this)        
        {
            positionChildInverse(mMenuView, menuLeft, y, contentHeight);
            menuLeft -= mMenuView.getMeasuredWidth();
        } //End block
        if(mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE)        
        {
            positionChildInverse(mIndeterminateProgressView, menuLeft, y, contentHeight);
            menuLeft -= mIndeterminateProgressView.getMeasuredWidth();
        } //End block
        View customView = null;
        if(mExpandedActionView != null)        
        {
            customView = mExpandedActionView;
        } //End block
        else
        if((mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0 &&
                mCustomNavView != null)        
        {
            customView = mCustomNavView;
        } //End block
        if(customView != null)        
        {
            ViewGroup.LayoutParams lp = customView.getLayoutParams();
            final ActionBar.LayoutParams ablp = lp instanceof ActionBar.LayoutParams ?
                    (ActionBar.LayoutParams) lp : null;
            final int gravity = ablp != null ? ablp.gravity : DEFAULT_CUSTOM_GRAVITY;
            final int navWidth = customView.getMeasuredWidth();
            int topMargin = 0;
            int bottomMargin = 0;
            if(ablp != null)            
            {
                x += ablp.leftMargin;
                menuLeft -= ablp.rightMargin;
                topMargin = ablp.topMargin;
                bottomMargin = ablp.bottomMargin;
            } //End block
            int hgravity = gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
            if(hgravity == Gravity.CENTER_HORIZONTAL)            
            {
                final int centeredLeft = ((mRight - mLeft) - navWidth) / 2;
                if(centeredLeft < x)                
                {
                    hgravity = Gravity.LEFT;
                } //End block
                else
                if(centeredLeft + navWidth > menuLeft)                
                {
                    hgravity = Gravity.RIGHT;
                } //End block
            } //End block
            else
            if(gravity == -1)            
            {
                hgravity = Gravity.LEFT;
            } //End block
            int xpos = 0;
switch(hgravity){
            case Gravity.CENTER_HORIZONTAL:
            xpos = ((mRight - mLeft) - navWidth) / 2;
            break;
            case Gravity.LEFT:
            xpos = x;
            break;
            case Gravity.RIGHT:
            xpos = menuLeft - navWidth;
            break;
}            int vgravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;
            if(gravity == -1)            
            {
                vgravity = Gravity.CENTER_VERTICAL;
            } //End block
            int ypos = 0;
switch(vgravity){
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
}            final int customWidth = customView.getMeasuredWidth();
            customView.layout(xpos, ypos, xpos + customWidth,
                    ypos + customView.getMeasuredHeight());
            x += customWidth;
        } //End block
        if(mProgressView != null)        
        {
            mProgressView.bringToFront();
            final int halfProgressHeight = mProgressView.getMeasuredHeight() / 2;
            mProgressView.layout(mProgressBarPadding, -halfProgressHeight,
                    mProgressBarPadding + mProgressView.getMeasuredWidth(), halfProgressHeight);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.059 -0400", hash_original_method = "5CAA9C4F0891E70178B26E7CA87F1572", hash_generated_method = "4A593FDB6CDBECE0A5C1FA0942757017")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
ViewGroup.LayoutParams var4623C1ABA202AD3CC8A876401C6F2166_162882526 =         new ActionBar.LayoutParams(getContext(), attrs);
        var4623C1ABA202AD3CC8A876401C6F2166_162882526.addTaint(taint);
        return var4623C1ABA202AD3CC8A876401C6F2166_162882526;
        // ---------- Original Method ----------
        //return new ActionBar.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.059 -0400", hash_original_method = "19310F391EC0B469A38234970BA36DD5", hash_generated_method = "A05B227302B47D2BA068999249BF793B")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        addTaint(lp.getTaint());
        if(lp == null)        
        {
            lp = generateDefaultLayoutParams();
        } //End block
ViewGroup.LayoutParams var91B5D28524FC29CFA4C262BA1E7587AA_991914333 =         lp;
        var91B5D28524FC29CFA4C262BA1E7587AA_991914333.addTaint(taint);
        return var91B5D28524FC29CFA4C262BA1E7587AA_991914333;
        // ---------- Original Method ----------
        //if (lp == null) {
            //lp = generateDefaultLayoutParams();
        //}
        //return lp;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.059 -0400", hash_original_method = "F7EC1EBD6989B5AFA75F6EFE3D4C9302", hash_generated_method = "1F842A2C68B55F43E50E65FA01B57739")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
        SavedState state = new SavedState(superState);
        if(mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null)        
        {
            state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        } //End block
        state.isOverflowOpen = isOverflowMenuShowing();
Parcelable var37C56C9D63C623261861C16DCFB73F6D_1908490725 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1908490725.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1908490725;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState state = new SavedState(superState);
        //if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            //state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        //}
        //state.isOverflowOpen = isOverflowMenuShowing();
        //return state;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_method = "2EB5982AB19EADE49A68C3033BC69293", hash_generated_method = "CAB4B48CDD36F9E62F381EA9BBBE4ECE")
    @Override
    public void onRestoreInstanceState(Parcelable p) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(p.getTaint());
        SavedState state = (SavedState) p;
        super.onRestoreInstanceState(state.getSuperState());
        if(state.expandedMenuItemId != 0 &&
                mExpandedMenuPresenter != null && mOptionsMenu != null)        
        {
            final MenuItem item = mOptionsMenu.findItem(state.expandedMenuItemId);
            if(item != null)            
            {
                item.expandActionView();
            } //End block
        } //End block
        if(state.isOverflowOpen)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_field = "EE14F5C44A696F8B73591580BE4F36E7", hash_generated_field = "1334451307EEF9508F4B4B5CDDD0EBC6")

        int expandedMenuItemId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_field = "BAE3AD1B58151E7EE32BBC5FF6A6F925", hash_generated_field = "3F39ED06F388CD8B0407CDFD8FFF841F")

        boolean isOverflowOpen;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_method = "D55BB2752CF51EBBB8F6639920409E43", hash_generated_method = "3EA29AE7506DED4645FE200C48D239D9")
        private  SavedState(Parcel in) {
            super(in);
            expandedMenuItemId = in.readInt();
            isOverflowOpen = in.readInt() != 0;
            // ---------- Original Method ----------
            //expandedMenuItemId = in.readInt();
            //isOverflowOpen = in.readInt() != 0;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_method = "515851E7BACA5483746DDD359AD42324", hash_generated_method = "5E96C9185B8AC3FC83965728212FEF76")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeInt(expandedMenuItemId);
            out.writeInt(isOverflowOpen ? 1 : 0);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(expandedMenuItemId);
            //out.writeInt(isOverflowOpen ? 1 : 0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    private static class HomeView extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_field = "028BB75B6148CFB069BFBB8534930FDF", hash_generated_field = "71A4D5441609517C4A8996E66BF5980D")

        private View mUpView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_field = "257C568B847B7929D699DFC14C6DFB3A", hash_generated_field = "C112C51C138E32E2EAD57FF4525D9B75")

        private int mUpWidth;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_method = "D411D61D16BBF4279D3867C1E411F377", hash_generated_method = "8545F9EADFE61A27DD7D7349B028BF53")
        public  HomeView(Context context) {
            this(context, null);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.060 -0400", hash_original_method = "A7CE440DF9BFAF8E10FD8D594704D071", hash_generated_method = "E57997063656BE688075596B33D505A6")
        public  HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "9F32A31FB673DE4EC8BCDCE1EEBEDDFA", hash_generated_method = "0BE012F76B3BB35DB9C7147DD3E1EE16")
        public void setUp(boolean isUp) {
            addTaint(isUp);
            mUpView.setVisibility(isUp ? VISIBLE : GONE);
            // ---------- Original Method ----------
            //mUpView.setVisibility(isUp ? VISIBLE : GONE);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "F0A9CABDEAA57DB9E5ACC2CB832FAA3E", hash_generated_method = "7107648CDD7AA25F33E4D6E37F51E761")
        public void setIcon(Drawable icon) {
            addTaint(icon.getTaint());
            mIconView.setImageDrawable(icon);
            // ---------- Original Method ----------
            //mIconView.setImageDrawable(icon);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "2C383E8C4E8C189FD39B37A1D14F06F8")
        @Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            addTaint(event.getTaint());
            onPopulateAccessibilityEvent(event);
            boolean varB326B5062B2F0E69046810717534CB09_1967915610 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_669969445 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_669969445;
            // ---------- Original Method ----------
            //onPopulateAccessibilityEvent(event);
            //return true;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "99FC9FA52CFCA1A2C8C1E179E8D834D1")
        @Override
        public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            super.onPopulateAccessibilityEvent(event);
            final CharSequence cdesc = getContentDescription();
            if(!TextUtils.isEmpty(cdesc))            
            {
                event.getText().add(cdesc);
            } //End block
            // ---------- Original Method ----------
            //super.onPopulateAccessibilityEvent(event);
            //final CharSequence cdesc = getContentDescription();
            //if (!TextUtils.isEmpty(cdesc)) {
                //event.getText().add(cdesc);
            //}
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "D04CA0B01E0522B1F3402CA149DE72C9")
        @Override
        public boolean dispatchHoverEvent(MotionEvent event) {
            addTaint(event.getTaint());
            boolean var47449F9991FAD303C66FB26061BA8D47_1249910811 = (onHoverEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359905292 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359905292;
            // ---------- Original Method ----------
            //return onHoverEvent(event);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "2B32BD9128787E0840E1C599EF5CB94E", hash_generated_method = "5EC2FAF832A2B3F6243B07B3538B4611")
        @Override
        protected void onFinishInflate() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mUpView = findViewById(com.android.internal.R.id.up);
            mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
            // ---------- Original Method ----------
            //mUpView = findViewById(com.android.internal.R.id.up);
            //mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.061 -0400", hash_original_method = "782BC6B05C8AB6ECAC8D4CC02CB172F4", hash_generated_method = "0A072248505CF64AB50D68A58DBFD702")
        public int getLeftOffset() {
            int var6CED62AF18CB03EDF0A55BF9F7268474_1341741852 = (mUpView.getVisibility() == GONE ? mUpWidth : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752915955 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752915955;
            // ---------- Original Method ----------
            //return mUpView.getVisibility() == GONE ? mUpWidth : 0;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_method = "1194BB929AE595B65CC6F2F618759EC2", hash_generated_method = "25F8FA0A13FF495DC8D172712D02AA20")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(heightMeasureSpec);
            addTaint(widthMeasureSpec);
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
switch(widthMode){
            case MeasureSpec.AT_MOST:
            width = Math.min(width, widthSize);
            break;
            case MeasureSpec.EXACTLY:
            width = widthSize;
            break;
            case MeasureSpec.UNSPECIFIED:
            default:
            break;
}switch(heightMode){
            case MeasureSpec.AT_MOST:
            height = Math.min(height, heightSize);
            break;
            case MeasureSpec.EXACTLY:
            height = heightSize;
            break;
            case MeasureSpec.UNSPECIFIED:
            default:
            break;
}            setMeasuredDimension(width, height);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_method = "7C995435E08D7DDC1C5A7F44746F458B", hash_generated_method = "80C327B1DB9D65A74D6BA8EF23A3AA70")
        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(b);
            addTaint(r);
            addTaint(t);
            addTaint(l);
            addTaint(changed);
            final int vCenter = (b - t) / 2;
            int width = r - l;
            int upOffset = 0;
            if(mUpView.getVisibility() != GONE)            
            {
                final LayoutParams upLp = (LayoutParams) mUpView.getLayoutParams();
                final int upHeight = mUpView.getMeasuredHeight();
                final int upWidth = mUpView.getMeasuredWidth();
                final int upTop = vCenter - upHeight / 2;
                mUpView.layout(0, upTop, upWidth, upTop + upHeight);
                upOffset = upLp.leftMargin + upWidth + upLp.rightMargin;
                width -= upOffset;
                l += upOffset;
            } //End block
            final LayoutParams iconLp = (LayoutParams) mIconView.getLayoutParams();
            final int iconHeight = mIconView.getMeasuredHeight();
            final int iconWidth = mIconView.getMeasuredWidth();
            final int hCenter = (r - l) / 2;
            final int iconLeft = upOffset + Math.max(iconLp.leftMargin, hCenter - iconWidth / 2);
            final int iconTop = Math.max(iconLp.topMargin, vCenter - iconHeight / 2);
            mIconView.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

        MenuBuilder mMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_field = "BC831032B38D382EFD9082CD42011025", hash_generated_field = "A676BA3A3A833708C675CD6BF9D53F5E")

        MenuItemImpl mCurrentExpandedItem;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_method = "D410F59FE51D215F3243D59D73778180", hash_generated_method = "D410F59FE51D215F3243D59D73778180")
        public ExpandedActionViewMenuPresenter ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_method = "792819F971142AF5AE41DA85E214C5C9", hash_generated_method = "DA84A768DC39736B570D47D817D39E7E")
        @Override
        public void initForMenu(Context context, MenuBuilder menu) {
            addTaint(context.getTaint());
            if(mMenu != null && mCurrentExpandedItem != null)            
            {
                mMenu.collapseItemActionView(mCurrentExpandedItem);
            } //End block
            mMenu = menu;
            // ---------- Original Method ----------
            //if (mMenu != null && mCurrentExpandedItem != null) {
                //mMenu.collapseItemActionView(mCurrentExpandedItem);
            //}
            //mMenu = menu;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.062 -0400", hash_original_method = "C60404B6CC35B9780D9F9822482B710D", hash_generated_method = "AEB3D790066562D6EC3826396AE6B909")
        @Override
        public MenuView getMenuView(ViewGroup root) {
            addTaint(root.getTaint());
MenuView var540C13E9E156B687226421B24F2DF178_1276818029 =             null;
            var540C13E9E156B687226421B24F2DF178_1276818029.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1276818029;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.063 -0400", hash_original_method = "226E9F894ABBAE0501C29D5C6F0FF83B", hash_generated_method = "44A381942D6F4836904D2609F257A9B5")
        @Override
        public void updateMenuView(boolean cleared) {
            addTaint(cleared);
            if(mCurrentExpandedItem != null)            
            {
                boolean found = false;
                if(mMenu != null)                
                {
                    final int count = mMenu.size();
for(int i = 0;i < count;i++)
                    {
                        final MenuItem item = mMenu.getItem(i);
                        if(item == mCurrentExpandedItem)                        
                        {
                            found = true;
                            break;
                        } //End block
                    } //End block
                } //End block
                if(!found)                
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.063 -0400", hash_original_method = "C83F707E18EA3360FADD00AE5C28CDF5", hash_generated_method = "91C24072A9EDE4FB74D3CC5F1FE81127")
        @Override
        public void setCallback(Callback cb) {
            addTaint(cb.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.064 -0400", hash_original_method = "7065AC4BF04829F4DD8494E3AEDE278B", hash_generated_method = "1F299D96A570E915DFE2E4C9C2F0A563")
        @Override
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_92250928 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812495938 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_812495938;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.064 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "7C6E8C3A9C1ECB7BD3164953E00AD02F")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(allMenusAreClosing);
            addTaint(menu.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.064 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "9E5E92A33C3554727CE5D950563EEB1D")
        @Override
        public boolean flagActionItems() {
            boolean var68934A3E9455FA72420237EB05902327_1713136553 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743661124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_743661124;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.065 -0400", hash_original_method = "995B7A71D6CB331F5D54C3F6E2CEFCD4", hash_generated_method = "98BBE7A4E1943258373D38BF78A07993")
        @Override
        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            addTaint(menu.getTaint());
            mExpandedActionView = item.getActionView();
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
            mCurrentExpandedItem = item;
            if(mExpandedActionView.getParent() != ActionBarView.this)            
            {
                addView(mExpandedActionView);
            } //End block
            if(mExpandedHomeLayout.getParent() != ActionBarView.this)            
            {
                addView(mExpandedHomeLayout);
            } //End block
            mHomeLayout.setVisibility(GONE);
            if(mTitleLayout != null)            
            mTitleLayout.setVisibility(GONE);
            if(mTabScrollView != null)            
            mTabScrollView.setVisibility(GONE);
            if(mSpinner != null)            
            mSpinner.setVisibility(GONE);
            if(mCustomNavView != null)            
            mCustomNavView.setVisibility(GONE);
            requestLayout();
            item.setActionViewExpanded(true);
            if(mExpandedActionView instanceof CollapsibleActionView)            
            {
                ((CollapsibleActionView) mExpandedActionView).onActionViewExpanded();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1759255384 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936086061 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936086061;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.065 -0400", hash_original_method = "91D41E28867193763062F9A55820BEE2", hash_generated_method = "32C932B58A6C8B49157AF6A5E8744C88")
        @Override
        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
            addTaint(item.getTaint());
            addTaint(menu.getTaint());
            if(mExpandedActionView instanceof CollapsibleActionView)            
            {
                ((CollapsibleActionView) mExpandedActionView).onActionViewCollapsed();
            } //End block
            removeView(mExpandedActionView);
            removeView(mExpandedHomeLayout);
            mExpandedActionView = null;
            if((mDisplayOptions & ActionBar.DISPLAY_SHOW_HOME) != 0)            
            {
                mHomeLayout.setVisibility(VISIBLE);
            } //End block
            if((mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0)            
            {
                if(mTitleLayout == null)                
                {
                    initTitle();
                } //End block
                else
                {
                    mTitleLayout.setVisibility(VISIBLE);
                } //End block
            } //End block
            if(mTabScrollView != null && mNavigationMode == ActionBar.NAVIGATION_MODE_TABS)            
            {
                mTabScrollView.setVisibility(VISIBLE);
            } //End block
            if(mSpinner != null && mNavigationMode == ActionBar.NAVIGATION_MODE_LIST)            
            {
                mSpinner.setVisibility(VISIBLE);
            } //End block
            if(mCustomNavView != null && (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0)            
            {
                mCustomNavView.setVisibility(VISIBLE);
            } //End block
            mExpandedHomeLayout.setIcon(null);
            mCurrentExpandedItem = null;
            requestLayout();
            item.setActionViewExpanded(false);
            boolean varB326B5062B2F0E69046810717534CB09_725928924 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225963130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225963130;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.066 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "93E4E825FD3EA1091FCC112CEE83C02A")
        @Override
        public int getId() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1359483460 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898043803 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898043803;
            // ---------- Original Method ----------
            //return 0;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.066 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "FEA2046A4BDE22C9F20A45AE0636C800")
        @Override
        public Parcelable onSaveInstanceState() {
            //DSFIXME:  CODE0009: Possible callback target function detected
Parcelable var540C13E9E156B687226421B24F2DF178_1706755332 =             null;
            var540C13E9E156B687226421B24F2DF178_1706755332.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1706755332;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.067 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "121C283A529B0D7F6A336D6D29A15283")
        @Override
        public void onRestoreInstanceState(Parcelable state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(state.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.067 -0400", hash_original_field = "CB6443DBE28157770714C1106DE615CA", hash_generated_field = "CDFB47463B78F3368DF983B3BF1B285F")

    private static final String TAG = "ActionBarView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.067 -0400", hash_original_field = "6F6030D90CE7DC995900436D8BC936E2", hash_generated_field = "4A3C78D8B3B7DF5E626E3E97B7B40810")

    public static final int DISPLAY_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.067 -0400", hash_original_field = "B58CEC5EF27B51C142E556F5EEFFC55D", hash_generated_field = "BC022A419127EDDE4E40524DA912F0E3")

    private static final int DISPLAY_RELAYOUT_MASK = ActionBar.DISPLAY_SHOW_HOME |
            ActionBar.DISPLAY_USE_LOGO |
            ActionBar.DISPLAY_HOME_AS_UP |
            ActionBar.DISPLAY_SHOW_CUSTOM |
            ActionBar.DISPLAY_SHOW_TITLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.067 -0400", hash_original_field = "AF4DF1B5C59571F3AE05F695061834CE", hash_generated_field = "3E11FBBE13E46A77B28D3C5EFE3B5DF0")

    private static final int DEFAULT_CUSTOM_GRAVITY = Gravity.LEFT | Gravity.CENTER_VERTICAL;
}

