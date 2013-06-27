package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "A75260FCE4EB84735EF4F8857FDD8871", hash_generated_field = "D7021ACCA51C37141CA5A3F0F0CB8D58")

    private int mNavigationMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "BFBD8ECCDDBCEF28ABBDF656C8D14C5F", hash_generated_field = "B097184BD65EEF760AB4457269F41FCE")

    private int mDisplayOptions = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "6EDD40BFDEB251E34BDCB1CE9C263665", hash_generated_field = "775125B4EBC8ED0F3E5FBA051277E18D")

    private CharSequence mSubtitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "27B9A7E56DA043F1C0A8546AD189F637", hash_generated_field = "6A8F8D16CE24865FF96256279C68A01A")

    private Drawable mLogo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.926 -0400", hash_original_field = "AAD87B797B16DEFE209BDDFA30686832", hash_generated_field = "D44BE31A0DA12240E9EFFCC7D25F51CC")

    private HomeView mHomeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "B57377976AD5D47F5FD05AD762068D75", hash_generated_field = "E38B6AFC0FF7040E207A508974C7E25A")

    private HomeView mExpandedHomeLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "E04DEDB0B406830A59065795F4A530C9", hash_generated_field = "53515DAB03CBCC904881F85C0D0B24F4")

    private LinearLayout mTitleLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "68B3FAC852E3272F9F54C6B1610054DA", hash_generated_field = "5B91EC47B0CD462AA7928A5697458750")

    private TextView mSubtitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "0A8A8271B4B28788D8A6C7232D2983D2", hash_generated_field = "F5B3209E54DA151E61A314A7F4D53CEE")

    private View mTitleUpView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "626AE3D18AA769A97988FB49E282FC0A", hash_generated_field = "11476E269EBDAE78EE3F499A710729B2")

    private Spinner mSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "A9C6CF7981E33FA053868DB1F1880979", hash_generated_field = "3E145BA83F7246824E728DD8C128F1DB")

    private LinearLayout mListNavLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "79971B4F2D39C7D687D7922DF67CCF83", hash_generated_field = "4E98814F423997944D2E7DAA5264BF48")

    private ScrollingTabContainerView mTabScrollView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "83D8120DFA8ECB9C20ED77AB33236FFB", hash_generated_field = "43AC585897322F8F4F6B26FAA521DECA")

    private View mCustomNavView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "356BEA1A72BD3DB0203E9E44A65DA2AB", hash_generated_field = "20EB404BC594BDA3F66199C58EE5FBA2")

    private ProgressBar mProgressView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "DF38520CBF4259BF7B0123D79EF1394F", hash_generated_field = "7A5992B35882BB2A0D60B38B106CC08B")

    private ProgressBar mIndeterminateProgressView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "771CB7FAE5982467E651DA9700D79132", hash_generated_field = "A3B6EB195053EBD51627D7173A9AE65D")

    private int mProgressBarPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "BC2F3DA2B5A01B28AEEE241AD26D0666", hash_generated_field = "F1455EFA6BE686E648B8E824CB9E4B81")

    private int mItemPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "F00D2B188EA8D8F58E0764D2012CA069", hash_generated_field = "CFEDF1432A06310A2FB06B788CC20410")

    private int mTitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "C0606F823BBDDA71B84334C05C268230", hash_generated_field = "9FA8532B8CB2D1269C79565E301C661F")

    private int mSubtitleStyleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "831CE0908E95C588131354EF3D249340", hash_generated_field = "18CB7C9B43E54A91185B83C5D14435FA")

    private int mProgressStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "8C381CD7C33B0DCE995BA02CBD02A306", hash_generated_field = "083E8134CFA4F8973249802B9A98C1E8")

    private int mIndeterminateProgressStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "5CF48434F2A8FB54D4F7A3EA3B9C8FC1", hash_generated_field = "0BAF72C7FF2EC45DE525F98CE324593F")

    private boolean mUserTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "C284BD664AB1FBB24C29B0515A0317FA", hash_generated_field = "968C4A904AD7ABC6144B6FCA2B427A80")

    private boolean mIncludeTabs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "DC3BE9CCFD3B9F2FED00A485BAD55556", hash_generated_field = "C0F5A22B3AA8A56D9DDAD5EF854478D3")

    private boolean mIsCollapsable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "1B035D60CEACF54763DA96643872A434", hash_generated_field = "3AD368D522924E6E03967F9DD95F2CBA")

    private boolean mIsCollapsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "C7532194647AFC2D4421630DA1B6C766", hash_generated_field = "4278A1A241D9B74448B2E547C0296095")

    private MenuBuilder mOptionsMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "13165738652608F9EE0CDB1A8EC90D22", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "51657654E85DFF84F82CA0D6D5EAD65D", hash_generated_field = "8C99101FC0313C08F73DD333D1CB1634")

    private ActionMenuItem mLogoNavItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "64E51C6821D8C1C9F3A28A738127D0DF", hash_generated_field = "3A2C8F67A3FD8ED91EC78875AB208830")

    private SpinnerAdapter mSpinnerAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "7A41771A4BE9BD1204FF01614115DD99")

    private OnNavigationListener mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "85B61EC738F2056493BB5A07F48F6CE2", hash_generated_field = "4C6A10C066298B16934A9F20792BEABB")

    private Runnable mTabSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.927 -0400", hash_original_field = "33DAF914C6A7B8055DA026382A6F67C5", hash_generated_field = "87262EFC15C41A276BFA5FD764A20EF4")

    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.928 -0400", hash_original_field = "A40A6F86F2AE21B265A171C20ACB9886", hash_generated_field = "5B0D453753A571590EA0325BAB8050A5")

    View mExpandedActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.928 -0400", hash_original_field = "ED8A48B4D3FB1C138C7CDF1360EBB754", hash_generated_field = "27B4F279DA726B6E62F72C86D786B686")

    Window.Callback mWindowCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.932 -0400", hash_original_field = "6570369C5D002BA40F3205CA42EDA077", hash_generated_field = "E4D6D27A5C1B00323F4BAEC34C799A92")

    private AdapterView.OnItemSelectedListener mNavItemSelectedListener = new AdapterView.OnItemSelectedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.931 -0400", hash_original_method = "1DD2DCAB9C51672A3484006095504705", hash_generated_method = "546EE63100CD77A2ECCDAFF19BF96005")
        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mCallback.onNavigationItemSelected(position, id);
            } //End block
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //mCallback.onNavigationItemSelected(position, id);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.932 -0400", hash_original_method = "B71B11696BC75696BC2C4386B1729546", hash_generated_method = "CCFF701FC5F6240EA1EEF39B88699599")
        public void onNothingSelected(AdapterView parent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(parent.getTaint());
            // ---------- Original Method ----------
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.946 -0400", hash_original_field = "130B48D14DC4F38293644D9F1154245C", hash_generated_field = "3C75925E30A5F06D375F8DC9DCE77108")

    private OnClickListener mExpandedActionViewUpListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.945 -0400", hash_original_method = "71D7F82DC843779588A8591EEB5DDE73", hash_generated_method = "A056795DE5C9B854C63B506BF3D9B8BD")
        @Override
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            MenuItemImpl item;
            item = mExpandedMenuPresenter.mCurrentExpandedItem;
            {
                item.collapseActionView();
            } //End block
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //final MenuItemImpl item = mExpandedMenuPresenter.mCurrentExpandedItem;
            //if (item != null) {
                //item.collapseActionView();
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.947 -0400", hash_original_field = "4C4D79526CBF782D76A61735F6EF945A", hash_generated_field = "7FE2CD8F8758A383B10B19832D1F6825")

    private OnClickListener mUpClickListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.947 -0400", hash_original_method = "19F57545305850BD0BBBD46104CC0B01", hash_generated_method = "7301E7CA22EE1FF39CCAA39323935474")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mWindowCallback.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, mLogoNavItem);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //mWindowCallback.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, mLogoNavItem);
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.960 -0400", hash_original_method = "29E0288B7F0720C76BE42483EEC0C7FB", hash_generated_method = "8715A55ACE9DC73EE60675619F6475A8")
    public  ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        LayoutInflater inflater;
        inflater = LayoutInflater.from(context);
        int homeResId;
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
        int customNavId;
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
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.962 -0400", hash_original_method = "2EBE795462E90C610435C294048EA12C", hash_generated_method = "4E7C4B158AB007765E8DF1EBFBA21574")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onConfigurationChanged(newConfig);
        mTitleView = null;
        mSubtitleView = null;
        mTitleUpView = null;
        {
            boolean varB8DBCA008916A21ADE49FDAE8A9163B8_389956301 = (mTitleLayout != null && mTitleLayout.getParent() == this);
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
        addTaint(newConfig.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.962 -0400", hash_original_method = "3A6246ABFAB05CB7EB83E9ECE73695AD", hash_generated_method = "6E28EC11FE705A7FCC9A34CE65DD4AA2")
    public void setWindowCallback(Window.Callback cb) {
        mWindowCallback = cb;
        // ---------- Original Method ----------
        //mWindowCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.978 -0400", hash_original_method = "B71E506A9F91C1AD992AA849BAEDAF37", hash_generated_method = "A4DEEBCE245362D878B36503836868A6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.978 -0400", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "BB5FFD5D60AB48F9B463AB502E6F4E96")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898619880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898619880;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.979 -0400", hash_original_method = "B34BEF81F3C7DDE70AA74FE44CD8EB1E", hash_generated_method = "810713CD928115B1FCC63244F35F9A90")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.979 -0400", hash_original_method = "19799DC3DC7751972B9DF9EE182F1D74", hash_generated_method = "3481A653820E0E31F3A19F10332F0CE7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.994 -0400", hash_original_method = "268F2B84CAE6E37FD4EC6111E5C155B1", hash_generated_method = "9CE68548809411E79424A4835202A270")
    @Override
    public void setSplitActionBar(boolean splitActionBar) {
        {
            {
                ViewGroup oldParent;
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
        addTaint(splitActionBar);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.994 -0400", hash_original_method = "D1A0823C6A31D8186A466BCCCE11ADAA", hash_generated_method = "E8942D98380AA29EEF0DFB6EC4352039")
    public boolean isSplitActionBar() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667668149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667668149;
        // ---------- Original Method ----------
        //return mSplitActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.994 -0400", hash_original_method = "24672C2D43139828573B39E460E47DBC", hash_generated_method = "471A2767C137F05FF4F05827D7123D0F")
    public boolean hasEmbeddedTabs() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2124509392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2124509392;
        // ---------- Original Method ----------
        //return mIncludeTabs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.995 -0400", hash_original_method = "8DB0348F40E3331B8E5DC32ABABAB86E", hash_generated_method = "5DB7A59AAB78EA3A5887AF2BA36232A6")
    public void setEmbeddedTabView(ScrollingTabContainerView tabs) {
        {
            removeView(mTabScrollView);
        } //End block
        mTabScrollView = tabs;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.995 -0400", hash_original_method = "0457D3AD4F802E9E3CD470071939A6F3", hash_generated_method = "1D5D0E55A3097020CCF1A8E557F79F64")
    public void setCallback(OnNavigationListener callback) {
        mCallback = callback;
        // ---------- Original Method ----------
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.996 -0400", hash_original_method = "FFAF505C90B4E5149598A1AECE2C3213", hash_generated_method = "9F7760BDFC358E68A973A6B4DEF04655")
    public void setMenu(Menu menu, MenuPresenter.Callback cb) {
        {
            mOptionsMenu.removeMenuPresenter(mActionMenuPresenter);
            mOptionsMenu.removeMenuPresenter(mExpandedMenuPresenter);
        } //End block
        MenuBuilder builder;
        builder = (MenuBuilder) menu;
        mOptionsMenu = builder;
        {
            ViewGroup oldParent;
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
        LayoutParams layoutParams;
        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        {
            mActionMenuPresenter.setExpandedActionViewsExclusive(
                    getResources().getBoolean(
                    com.android.internal.R.bool.action_bar_expanded_action_views_exclusive));
            configPresenters(builder);
            menuView = (ActionMenuView) mActionMenuPresenter.getMenuView(this);
            ViewGroup oldParent;
            oldParent = (ViewGroup) menuView.getParent();
            {
                boolean var08DC231001F8E4208C059DF922330B6C_220220347 = (oldParent != null && oldParent != this);
                {
                    oldParent.removeView(menuView);
                } //End block
            } //End collapsed parenthetic
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
                ViewGroup oldParent;
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
        addTaint(menu.getTaint());
        addTaint(cb.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.997 -0400", hash_original_method = "962CA6D106A54FF8005566B234E49437", hash_generated_method = "A2172076F4E370F39AD4D32F57CF090A")
    private void configPresenters(MenuBuilder builder) {
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
        addTaint(builder.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.997 -0400", hash_original_method = "8730ED187B27F4DCB92C97E3B6342387", hash_generated_method = "1DE1C0918717435B611613165401DF64")
    public boolean hasExpandedActionView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064087088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064087088;
        // ---------- Original Method ----------
        //return mExpandedMenuPresenter != null &&
                //mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.998 -0400", hash_original_method = "E064456058852E66BECDCC9D9AA06FF8", hash_generated_method = "255D9ECCBD2DB8E1D49BF03FDD99A4F7")
    public void collapseActionView() {
        MenuItemImpl item;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.998 -0400", hash_original_method = "A015B4577A897E6E7B62945B8635CEDC", hash_generated_method = "8055D813FCE8C2BC76D680C128DE28C5")
    public void setCustomNavigationView(View view) {
        boolean showCustom;
        showCustom = (mDisplayOptions & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;
        {
            removeView(mCustomNavView);
        } //End block
        mCustomNavView = view;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.021 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "19A36D20B01701EE07884FA2E7D12BFD")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_469425966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_469425966 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_469425966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_469425966;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.021 -0400", hash_original_method = "777E3F031124EBDDD3E24D756483B885", hash_generated_method = "10013BDA5ECA4640ECF1DD54D36B844F")
    public void setTitle(CharSequence title) {
        mUserTitle = true;
        setTitleImpl(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //mUserTitle = true;
        //setTitleImpl(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.021 -0400", hash_original_method = "193CF6C8B49C81B5000EB0B0B9EF604D", hash_generated_method = "C1796AAF546A85FEBADABF79DB26341D")
    public void setWindowTitle(CharSequence title) {
        {
            setTitleImpl(title);
        } //End block
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //if (!mUserTitle) {
            //setTitleImpl(title);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.022 -0400", hash_original_method = "CA4194BA53EDB0AC58DD1582B0D957BD", hash_generated_method = "26AC4FAFB9C01BB6F11B22952778E10E")
    private void setTitleImpl(CharSequence title) {
        mTitle = title;
        {
            mTitleView.setText(title);
            boolean visible;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.022 -0400", hash_original_method = "8334E54E49A430BB5E2CB9D01857CDC7", hash_generated_method = "6267604B3DE670841B0AE88801A7BCA2")
    public CharSequence getSubtitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_898637486 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898637486 = mSubtitle;
        varB4EAC82CA7396A68D541C85D26508E83_898637486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898637486;
        // ---------- Original Method ----------
        //return mSubtitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.023 -0400", hash_original_method = "ECDAA3B767FC89031E52906AD709A8B9", hash_generated_method = "817A795009E6BC5A152E36935F77530A")
    public void setSubtitle(CharSequence subtitle) {
        mSubtitle = subtitle;
        {
            mSubtitleView.setText(subtitle);
            mSubtitleView.setVisibility(subtitle != null ? VISIBLE : GONE);
            boolean visible;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.023 -0400", hash_original_method = "BA9334347A50C815DACE5C734F6D1CA6", hash_generated_method = "4BABD9A42BF97ED72C789C2173BEF938")
    public void setHomeButtonEnabled(boolean enable) {
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
        addTaint(enable);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.025 -0400", hash_original_method = "729D65DF169EDB552B2DB5DF7F633BF2", hash_generated_method = "C27451B05560627A6B35CE22AB350607")
    public void setDisplayOptions(int options) {
        int flagsChanged;
        flagsChanged = -1;
        flagsChanged = options ^ mDisplayOptions;
        mDisplayOptions = options;
        {
            boolean showHome;
            showHome = (options & ActionBar.DISPLAY_SHOW_HOME) != 0;
            int vis;
            vis = VISIBLE;
            vis = GONE;
            mHomeLayout.setVisibility(vis);
            {
                boolean setUp;
                setUp = (options & ActionBar.DISPLAY_HOME_AS_UP) != 0;
                mHomeLayout.setUp(setUp);
                {
                    setHomeButtonEnabled(true);
                } //End block
            } //End block
            {
                boolean logoVis;
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
                boolean homeAsUp;
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
            boolean var8FC373AFA9358E12A30E37AB5AA630D0_1675532141 = (!mHomeLayout.isEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.026 -0400", hash_original_method = "030F447392EAF535A82C251E2DB0C9D4", hash_generated_method = "66A4AFC7A2C0886D0A9C89069EE21D05")
    public void setIcon(Drawable icon) {
        mIcon = icon;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.026 -0400", hash_original_method = "7424D4DE12B074743D84FF4154B309BA", hash_generated_method = "AC9161FCD9F16272E0901FB2A0D4B7AD")
    public void setIcon(int resId) {
        setIcon(mContext.getResources().getDrawable(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setIcon(mContext.getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.026 -0400", hash_original_method = "6239F067617389BCFA9336EB6940A154", hash_generated_method = "14B36BF1EF7B170FF654B50C19DD0D7A")
    public void setLogo(Drawable logo) {
        mLogo = logo;
        {
            mHomeLayout.setIcon(logo);
        } //End block
        // ---------- Original Method ----------
        //mLogo = logo;
        //if (logo != null && (mDisplayOptions & ActionBar.DISPLAY_USE_LOGO) != 0) {
            //mHomeLayout.setIcon(logo);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.046 -0400", hash_original_method = "8F48D1A1BD2CE39E1CCC3DD41DD8DBB5", hash_generated_method = "34E1BDBA4CA93EB1FAE62797B1580E2D")
    public void setLogo(int resId) {
        setLogo(mContext.getResources().getDrawable(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setLogo(mContext.getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.059 -0400", hash_original_method = "7C440BC8D2AAA3D5B444BDD726AE7ED7", hash_generated_method = "868A7631F86203491858D82F76088007")
    public void setNavigationMode(int mode) {
        int oldMode;
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
                boolean var52395F21CD7D9E73DAD0C4C932A32AD1_1681945092 = (mSpinner.getAdapter() != mSpinnerAdapter);
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
            mNavigationMode = mode;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.060 -0400", hash_original_method = "89B6C7658DAE063C75647F5ADF8E9216", hash_generated_method = "1BEF52038A9FEDBC8029657A4AE32BBB")
    public void setDropdownAdapter(SpinnerAdapter adapter) {
        mSpinnerAdapter = adapter;
        {
            mSpinner.setAdapter(adapter);
        } //End block
        // ---------- Original Method ----------
        //mSpinnerAdapter = adapter;
        //if (mSpinner != null) {
            //mSpinner.setAdapter(adapter);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.060 -0400", hash_original_method = "1A4098174F41A05D8E016C60876697BD", hash_generated_method = "7422B97FAD3D877A48CC85CB2817719E")
    public SpinnerAdapter getDropdownAdapter() {
        SpinnerAdapter varB4EAC82CA7396A68D541C85D26508E83_1847817119 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1847817119 = mSpinnerAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1847817119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847817119;
        // ---------- Original Method ----------
        //return mSpinnerAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.061 -0400", hash_original_method = "AD9310333D391F8A81F374E0D04AD8BB", hash_generated_method = "14107C938D0AE55E9B4140FF46EB8292")
    public void setDropdownSelectedPosition(int position) {
        mSpinner.setSelection(position);
        addTaint(position);
        // ---------- Original Method ----------
        //mSpinner.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.061 -0400", hash_original_method = "434984419C6BB9581BBBAD71AB1CA07D", hash_generated_method = "FE9BC7C18F36B4054055395C4E2530F7")
    public int getDropdownSelectedPosition() {
        int var1650F6FEAE0120B0496D88EF942CC734_1515718134 = (mSpinner.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792379792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792379792;
        // ---------- Original Method ----------
        //return mSpinner.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.062 -0400", hash_original_method = "1544DDF36E6082443A2EF4ED7A4DF538", hash_generated_method = "33A989D0A45642D9AA45E04DF866ED11")
    public View getCustomNavigationView() {
        View varB4EAC82CA7396A68D541C85D26508E83_743394735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_743394735 = mCustomNavView;
        varB4EAC82CA7396A68D541C85D26508E83_743394735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_743394735;
        // ---------- Original Method ----------
        //return mCustomNavView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.062 -0400", hash_original_method = "14AA191B691A51A87445A62103C542CB", hash_generated_method = "6BAD0B9F8F4899DD9A7A4674079D4E10")
    public int getNavigationMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247346020 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247346020;
        // ---------- Original Method ----------
        //return mNavigationMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.062 -0400", hash_original_method = "7126F05C057CF7F499EBFF9A1F4C4A02", hash_generated_method = "9FBF54953817F5BF92CE5F26595309AF")
    public int getDisplayOptions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955831336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955831336;
        // ---------- Original Method ----------
        //return mDisplayOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.072 -0400", hash_original_method = "CC715ED5E40E0E0CF6C0353136D75335", hash_generated_method = "F040E57F424079B2630D5A3C01E67770")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1758525818 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1758525818 = new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
        varB4EAC82CA7396A68D541C85D26508E83_1758525818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1758525818;
        // ---------- Original Method ----------
        //return new ActionBar.LayoutParams(DEFAULT_CUSTOM_GRAVITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.076 -0400", hash_original_method = "5C54848E55EB765D8F0ED5A386E76AE7", hash_generated_method = "717C9C85349E790F703F387723B3C2F7")
    @Override
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        addView(mHomeLayout);
        {
            ViewParent parent;
            parent = mCustomNavView.getParent();
            {
                boolean var553E916236956A1869B5724F2A801563_77122429 = (parent != this);
                {
                    {
                        ((ViewGroup) parent).removeView(mCustomNavView);
                    } //End block
                    addView(mCustomNavView);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.078 -0400", hash_original_method = "CF8F187E9CF2FA51D65633927C0BE8F6", hash_generated_method = "7253D5AEA7BE6CBAFDAF9CA2E6102752")
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
            boolean homeAsUp;
            homeAsUp = (mDisplayOptions & ActionBar.DISPLAY_HOME_AS_UP) != 0;
            boolean showHome;
            showHome = (mDisplayOptions & ActionBar.DISPLAY_SHOW_HOME) != 0;
            mTitleUpView.setVisibility(!showHome ? (homeAsUp ? VISIBLE : INVISIBLE) : GONE);
            mTitleLayout.setEnabled(homeAsUp && !showHome);
        } //End block
        addView(mTitleLayout);
        {
            boolean var1049AFB1933262799884B2BE4492C363_1512751053 = (mExpandedActionView != null ||
                (TextUtils.isEmpty(mTitle) && TextUtils.isEmpty(mSubtitle)));
            {
                mTitleLayout.setVisibility(GONE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.078 -0400", hash_original_method = "F623B40982707A8AF90610858040ED3E", hash_generated_method = "D4BCFE83BC3C16939B58F9C8F60CB578")
    public void setContextView(ActionBarContextView view) {
        mContextView = view;
        // ---------- Original Method ----------
        //mContextView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.078 -0400", hash_original_method = "4C7B7DAEF91C23BA8E2CF63957DDD2D5", hash_generated_method = "D1B4B964836E41A41374E901B2F6E0A6")
    public void setCollapsable(boolean collapsable) {
        mIsCollapsable = collapsable;
        // ---------- Original Method ----------
        //mIsCollapsable = collapsable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.079 -0400", hash_original_method = "85F70991FC3EED5A4EDF0B8F79DFC73E", hash_generated_method = "8FA58EB855A176868B2ACA46B01ECEF8")
    public boolean isCollapsed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981146479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981146479;
        // ---------- Original Method ----------
        //return mIsCollapsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.118 -0400", hash_original_method = "EDE59536C59F48F9C9A7E58A0D736A35", hash_generated_method = "475CFAA0C8F271EA05CC9C6C8EF7C7B2")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int childCount;
        childCount = getChildCount();
        {
            int visibleChildren;
            visibleChildren = 0;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    {
                        boolean var7DAF9176C442508CDC90616FB4E12787_1809107223 = (child.getVisibility() != GONE &&
                        !(child == mMenuView && mMenuView.getChildCount() == 0));
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
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_width=\"match_parent\" (or fill_parent)");
        } //End block
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(getClass().getSimpleName() + " can only be used " +
                    "with android:layout_height=\"wrap_content\"");
        } //End block
        int contentWidth;
        contentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight;
        maxHeight = mContentHeight;
        maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        int verticalPadding;
        verticalPadding = getPaddingTop() + getPaddingBottom();
        int paddingLeft;
        paddingLeft = getPaddingLeft();
        int paddingRight;
        paddingRight = getPaddingRight();
        int height;
        height = maxHeight - verticalPadding;
        int childSpecHeight;
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
            boolean var69FA44B1FF5F26DD82195316B3CBA4FD_771714553 = (homeLayout.getVisibility() != GONE);
            {
                ViewGroup.LayoutParams lp;
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
                int homeWidth;
                homeWidth = homeLayout.getMeasuredWidth() + homeLayout.getLeftOffset();
                availableWidth = Math.max(0, availableWidth - homeWidth);
                leftOfCenter = Math.max(0, availableWidth - homeWidth);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1178C40D6B4B3394C757D204E5BDCC27_414344515 = (mMenuView != null && mMenuView.getParent() == this);
            {
                availableWidth = measureChildView(mMenuView, availableWidth,
                    childSpecHeight, 0);
                rightOfCenter = Math.max(0, rightOfCenter - mMenuView.getMeasuredWidth());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6150CF4CAC1097FD770B8EA55CD0A539_1223881698 = (mIndeterminateProgressView != null &&
                mIndeterminateProgressView.getVisibility() != GONE);
            {
                availableWidth = measureChildView(mIndeterminateProgressView, availableWidth,
                    childSpecHeight, 0);
                rightOfCenter = Math.max(0,
                    rightOfCenter - mIndeterminateProgressView.getMeasuredWidth());
            } //End block
        } //End collapsed parenthetic
        boolean showTitle;
        showTitle = mTitleLayout != null && mTitleLayout.getVisibility() != GONE &&
                (mDisplayOptions & ActionBar.DISPLAY_SHOW_TITLE) != 0;
        {
            //Begin case ActionBar.NAVIGATION_MODE_LIST 
            {
                int itemPaddingSize;
                itemPaddingSize = mItemPadding * 2;
                itemPaddingSize = mItemPadding;
                availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                mListNavLayout.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                int listNavWidth;
                listNavWidth = mListNavLayout.getMeasuredWidth();
                availableWidth = Math.max(0, availableWidth - listNavWidth);
                leftOfCenter = Math.max(0, leftOfCenter - listNavWidth);
            } //End block
            //End case ActionBar.NAVIGATION_MODE_LIST 
            //Begin case ActionBar.NAVIGATION_MODE_TABS 
            {
                int itemPaddingSize;
                itemPaddingSize = mItemPadding * 2;
                itemPaddingSize = mItemPadding;
                availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                mTabScrollView.measure(
                                MeasureSpec.makeMeasureSpec(availableWidth, MeasureSpec.AT_MOST),
                                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                int tabWidth;
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
            ViewGroup.LayoutParams lp;
            lp = generateLayoutParams(customView.getLayoutParams());
            ActionBar.LayoutParams ablp;
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
            int customNavHeight;
            customNavHeight = Math.max(0,
                    (lp.height >= 0 ? Math.min(lp.height, height) : height) - verticalMargin);//DSFIXME:  CODE0008: Nested ternary operator in expression
            int customNavWidthMode;
            customNavWidthMode = MeasureSpec.EXACTLY;
            customNavWidthMode = MeasureSpec.AT_MOST;
            int customNavWidth;
            customNavWidth = Math.max(0,
                    (lp.width >= 0 ? Math.min(lp.width, availableWidth) : availableWidth)
                    - horizontalMargin);//DSFIXME:  CODE0008: Nested ternary operator in expression
            int hgrav;
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
            boolean var1E5A6DD9EDF6AF1A1E51C13CC8FC6B74_1464799754 = (mProgressView != null && mProgressView.getVisibility() != GONE);
            {
                mProgressView.measure(MeasureSpec.makeMeasureSpec(
                    contentWidth - mProgressBarPadding * 2, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.AT_MOST));
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.131 -0400", hash_original_method = "632E55F727AC38C1F794E2370B6AE161", hash_generated_method = "9CF62E4019E2B9A83BCBB7D76345836B")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int x;
        x = getPaddingLeft();
        int y;
        y = getPaddingTop();
        int contentHeight;
        contentHeight = b - t - getPaddingTop() - getPaddingBottom();
        HomeView homeLayout;
        homeLayout = mExpandedHomeLayout;
        homeLayout = mHomeLayout;
        {
            boolean var69FA44B1FF5F26DD82195316B3CBA4FD_309009578 = (homeLayout.getVisibility() != GONE);
            {
                int leftOffset;
                leftOffset = homeLayout.getLeftOffset();
                x += positionChild(homeLayout, x + leftOffset, y, contentHeight) + leftOffset;
            } //End block
        } //End collapsed parenthetic
        {
            boolean showTitle;
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
            boolean var1178C40D6B4B3394C757D204E5BDCC27_1140905010 = (mMenuView != null && mMenuView.getParent() == this);
            {
                positionChildInverse(mMenuView, menuLeft, y, contentHeight);
                menuLeft -= mMenuView.getMeasuredWidth();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6150CF4CAC1097FD770B8EA55CD0A539_1052712957 = (mIndeterminateProgressView != null &&
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
            ActionBar.LayoutParams ablp;
            ablp = (ActionBar.LayoutParams) lp;
            ablp = null;
            int gravity;
            gravity = ablp.gravity;
            gravity = DEFAULT_CUSTOM_GRAVITY;
            int navWidth;
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
                int centeredLeft;
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
            int paddedTop;
            paddedTop = getPaddingTop();
            //End case Gravity.CENTER_VERTICAL 
            //Begin case Gravity.CENTER_VERTICAL 
            int paddedBottom;
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
            int customWidth;
            customWidth = customView.getMeasuredWidth();
            customView.layout(xpos, ypos, xpos + customWidth,
                    ypos + customView.getMeasuredHeight());
            x += customWidth;
        } //End block
        {
            mProgressView.bringToFront();
            int halfProgressHeight;
            halfProgressHeight = mProgressView.getMeasuredHeight() / 2;
            mProgressView.layout(mProgressBarPadding, -halfProgressHeight,
                    mProgressBarPadding + mProgressView.getMeasuredWidth(), halfProgressHeight);
        } //End block
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.152 -0400", hash_original_method = "5CAA9C4F0891E70178B26E7CA87F1572", hash_generated_method = "1A70D87717FE99F77A05D87FD9C9BFB2")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_887948955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_887948955 = new ActionBar.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_887948955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_887948955;
        // ---------- Original Method ----------
        //return new ActionBar.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.153 -0400", hash_original_method = "19310F391EC0B469A38234970BA36DD5", hash_generated_method = "089C8625B06E4E115C6DEC8E751706F0")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_140461000 = null; //Variable for return #1
        {
            lp = generateDefaultLayoutParams();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_140461000 = lp;
        addTaint(lp.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_140461000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_140461000;
        // ---------- Original Method ----------
        //if (lp == null) {
            //lp = generateDefaultLayoutParams();
        //}
        //return lp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.170 -0400", hash_original_method = "F7EC1EBD6989B5AFA75F6EFE3D4C9302", hash_generated_method = "91993D417A112951EBD5EA8A718114B4")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_292257216 = null; //Variable for return #1
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState state;
        state = new SavedState(superState);
        {
            state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        } //End block
        state.isOverflowOpen = isOverflowMenuShowing();
        varB4EAC82CA7396A68D541C85D26508E83_292257216 = state;
        varB4EAC82CA7396A68D541C85D26508E83_292257216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292257216;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState state = new SavedState(superState);
        //if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            //state.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        //}
        //state.isOverflowOpen = isOverflowMenuShowing();
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.170 -0400", hash_original_method = "2EB5982AB19EADE49A68C3033BC69293", hash_generated_method = "B3949FBBA6A3079A034E71F0EB6D3070")
    @Override
    public void onRestoreInstanceState(Parcelable p) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState state;
        state = (SavedState) p;
        super.onRestoreInstanceState(state.getSuperState());
        {
            MenuItem item;
            item = mOptionsMenu.findItem(state.expandedMenuItemId);
            {
                item.expandActionView();
            } //End block
        } //End block
        {
            postShowOverflowMenu();
        } //End block
        addTaint(p.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.170 -0400", hash_original_field = "EE14F5C44A696F8B73591580BE4F36E7", hash_generated_field = "1334451307EEF9508F4B4B5CDDD0EBC6")

        int expandedMenuItemId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.170 -0400", hash_original_field = "BAE3AD1B58151E7EE32BBC5FF6A6F925", hash_generated_field = "3F39ED06F388CD8B0407CDFD8FFF841F")

        boolean isOverflowOpen;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.171 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.172 -0400", hash_original_method = "D55BB2752CF51EBBB8F6639920409E43", hash_generated_method = "3EA29AE7506DED4645FE200C48D239D9")
        private  SavedState(Parcel in) {
            super(in);
            expandedMenuItemId = in.readInt();
            isOverflowOpen = in.readInt() != 0;
            // ---------- Original Method ----------
            //expandedMenuItemId = in.readInt();
            //isOverflowOpen = in.readInt() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.178 -0400", hash_original_method = "515851E7BACA5483746DDD359AD42324", hash_generated_method = "9AC96C63F5E1CDCD5CF892B3010E92D9")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(expandedMenuItemId);
            out.writeInt(isOverflowOpen ? 1 : 0);
            addTaint(out.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(expandedMenuItemId);
            //out.writeInt(isOverflowOpen ? 1 : 0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.178 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.178 -0400", hash_original_field = "028BB75B6148CFB069BFBB8534930FDF", hash_generated_field = "71A4D5441609517C4A8996E66BF5980D")

        private View mUpView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.178 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.178 -0400", hash_original_field = "257C568B847B7929D699DFC14C6DFB3A", hash_generated_field = "C112C51C138E32E2EAD57FF4525D9B75")

        private int mUpWidth;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.195 -0400", hash_original_method = "D411D61D16BBF4279D3867C1E411F377", hash_generated_method = "8545F9EADFE61A27DD7D7349B028BF53")
        public  HomeView(Context context) {
            this(context, null);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.196 -0400", hash_original_method = "A7CE440DF9BFAF8E10FD8D594704D071", hash_generated_method = "FE32AD87A266E538FC175BD587F7D54C")
        public  HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.196 -0400", hash_original_method = "9F32A31FB673DE4EC8BCDCE1EEBEDDFA", hash_generated_method = "C5FAECDE8ED1DD073B9B388055C8CCD3")
        public void setUp(boolean isUp) {
            mUpView.setVisibility(isUp ? VISIBLE : GONE);
            addTaint(isUp);
            // ---------- Original Method ----------
            //mUpView.setVisibility(isUp ? VISIBLE : GONE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.196 -0400", hash_original_method = "F0A9CABDEAA57DB9E5ACC2CB832FAA3E", hash_generated_method = "9B57DB7ABC228AFB1395FD587CAE938E")
        public void setIcon(Drawable icon) {
            mIconView.setImageDrawable(icon);
            addTaint(icon.getTaint());
            // ---------- Original Method ----------
            //mIconView.setImageDrawable(icon);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.197 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "5C71F4F872FD2F6F4715505994B85A4B")
        @Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            onPopulateAccessibilityEvent(event);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015046420 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015046420;
            // ---------- Original Method ----------
            //onPopulateAccessibilityEvent(event);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.213 -0400", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "24E7D3C0732C824C73E856D5B6A16B03")
        @Override
        public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onPopulateAccessibilityEvent(event);
            CharSequence cdesc;
            cdesc = getContentDescription();
            {
                boolean var2867030CDEABDD91B93106875518E0B9_1885327167 = (!TextUtils.isEmpty(cdesc));
                {
                    event.getText().add(cdesc);
                } //End block
            } //End collapsed parenthetic
            addTaint(event.getTaint());
            // ---------- Original Method ----------
            //super.onPopulateAccessibilityEvent(event);
            //final CharSequence cdesc = getContentDescription();
            //if (!TextUtils.isEmpty(cdesc)) {
                //event.getText().add(cdesc);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.213 -0400", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "EB8B96B80C9110EBDD378FFEA8DFDC18")
        @Override
        public boolean dispatchHoverEvent(MotionEvent event) {
            boolean var493B0665694C63B1B269F548FEE919AB_742273660 = (onHoverEvent(event));
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451757360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451757360;
            // ---------- Original Method ----------
            //return onHoverEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.214 -0400", hash_original_method = "2B32BD9128787E0840E1C599EF5CB94E", hash_generated_method = "5EC2FAF832A2B3F6243B07B3538B4611")
        @Override
        protected void onFinishInflate() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mUpView = findViewById(com.android.internal.R.id.up);
            mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
            // ---------- Original Method ----------
            //mUpView = findViewById(com.android.internal.R.id.up);
            //mIconView = (ImageView) findViewById(com.android.internal.R.id.home);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.214 -0400", hash_original_method = "782BC6B05C8AB6ECAC8D4CC02CB172F4", hash_generated_method = "43EDA1D258211C7016B04E6C4F3EC327")
        public int getLeftOffset() {
            {
                boolean var2AB0E93DC2FD2F6FCFF12E2D10799B12_1729395354 = (mUpView.getVisibility() == GONE);
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54165465 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54165465;
            // ---------- Original Method ----------
            //return mUpView.getVisibility() == GONE ? mUpWidth : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.226 -0400", hash_original_method = "1194BB929AE595B65CC6F2F618759EC2", hash_generated_method = "D3E9396BF28E92A9D81F98FECBFCAA52")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            measureChildWithMargins(mUpView, widthMeasureSpec, 0, heightMeasureSpec, 0);
            LayoutParams upLp;
            upLp = (LayoutParams) mUpView.getLayoutParams();
            mUpWidth = upLp.leftMargin + mUpView.getMeasuredWidth() + upLp.rightMargin;
            int width;
            boolean var6F7FB5A2512F4A9FD1F89B251120F547_1794167787 = (mUpView.getVisibility() == GONE);
            width = 0;
            width = mUpWidth;
            int height;
            height = upLp.topMargin + mUpView.getMeasuredHeight() + upLp.bottomMargin;
            measureChildWithMargins(mIconView, widthMeasureSpec, width, heightMeasureSpec, 0);
            LayoutParams iconLp;
            iconLp = (LayoutParams) mIconView.getLayoutParams();
            width += iconLp.leftMargin + mIconView.getMeasuredWidth() + iconLp.rightMargin;
            height = Math.max(height,
                    iconLp.topMargin + mIconView.getMeasuredHeight() + iconLp.bottomMargin);
            int widthMode;
            widthMode = MeasureSpec.getMode(widthMeasureSpec);
            int heightMode;
            heightMode = MeasureSpec.getMode(heightMeasureSpec);
            int widthSize;
            widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSize;
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
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.228 -0400", hash_original_method = "7C995435E08D7DDC1C5A7F44746F458B", hash_generated_method = "B9CF2E6FADC46F1634C7072A02C9CBB3")
        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int vCenter;
            vCenter = (b - t) / 2;
            int width;
            width = r - l;
            int upOffset;
            upOffset = 0;
            {
                boolean varAE3FC7AE078D2248073FC8A7AF801B0F_876809521 = (mUpView.getVisibility() != GONE);
                {
                    LayoutParams upLp;
                    upLp = (LayoutParams) mUpView.getLayoutParams();
                    int upHeight;
                    upHeight = mUpView.getMeasuredHeight();
                    int upWidth;
                    upWidth = mUpView.getMeasuredWidth();
                    int upTop;
                    upTop = vCenter - upHeight / 2;
                    mUpView.layout(0, upTop, upWidth, upTop + upHeight);
                    upOffset = upLp.leftMargin + upWidth + upLp.rightMargin;
                    width -= upOffset;
                    l += upOffset;
                } //End block
            } //End collapsed parenthetic
            LayoutParams iconLp;
            iconLp = (LayoutParams) mIconView.getLayoutParams();
            int iconHeight;
            iconHeight = mIconView.getMeasuredHeight();
            int iconWidth;
            iconWidth = mIconView.getMeasuredWidth();
            int hCenter;
            hCenter = (r - l) / 2;
            int iconLeft;
            iconLeft = upOffset + Math.max(iconLp.leftMargin, hCenter - iconWidth / 2);
            int iconTop;
            iconTop = Math.max(iconLp.topMargin, vCenter - iconHeight / 2);
            mIconView.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
            addTaint(changed);
            addTaint(l);
            addTaint(t);
            addTaint(r);
            addTaint(b);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.228 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

        MenuBuilder mMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.228 -0400", hash_original_field = "BC831032B38D382EFD9082CD42011025", hash_generated_field = "A676BA3A3A833708C675CD6BF9D53F5E")

        MenuItemImpl mCurrentExpandedItem;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.228 -0400", hash_original_method = "D410F59FE51D215F3243D59D73778180", hash_generated_method = "D410F59FE51D215F3243D59D73778180")
        public ExpandedActionViewMenuPresenter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.229 -0400", hash_original_method = "792819F971142AF5AE41DA85E214C5C9", hash_generated_method = "85556B21885D0E9DD7B0A716FEE0B225")
        @Override
        public void initForMenu(Context context, MenuBuilder menu) {
            {
                mMenu.collapseItemActionView(mCurrentExpandedItem);
            } //End block
            mMenu = menu;
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //if (mMenu != null && mCurrentExpandedItem != null) {
                //mMenu.collapseItemActionView(mCurrentExpandedItem);
            //}
            //mMenu = menu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.229 -0400", hash_original_method = "C60404B6CC35B9780D9F9822482B710D", hash_generated_method = "94A32A85B38B5C3CB61BC157150BA366")
        @Override
        public MenuView getMenuView(ViewGroup root) {
            MenuView varB4EAC82CA7396A68D541C85D26508E83_877452612 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_877452612 = null;
            addTaint(root.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_877452612.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_877452612;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.249 -0400", hash_original_method = "226E9F894ABBAE0501C29D5C6F0FF83B", hash_generated_method = "A5EB0AE073FCC17A1FD44233BDF4ABBB")
        @Override
        public void updateMenuView(boolean cleared) {
            {
                boolean found;
                found = false;
                {
                    int count;
                    count = mMenu.size();
                    {
                        int i;
                        i = 0;
                        {
                            MenuItem item;
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
            addTaint(cleared);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.250 -0400", hash_original_method = "C83F707E18EA3360FADD00AE5C28CDF5", hash_generated_method = "91C24072A9EDE4FB74D3CC5F1FE81127")
        @Override
        public void setCallback(Callback cb) {
            addTaint(cb.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.250 -0400", hash_original_method = "7065AC4BF04829F4DD8494E3AEDE278B", hash_generated_method = "63B29C47C6EFA2E830C636042A4371B7")
        @Override
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995532728 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_995532728;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.251 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "15DD56E801446E62CB8AD586B99C35C7")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            addTaint(allMenusAreClosing);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.260 -0400", hash_original_method = "4C665EA7F97447510193964EEFD645AE", hash_generated_method = "B605E8AC3CA0F1F67B5B8E93DB1F3BEC")
        @Override
        public boolean flagActionItems() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900022667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_900022667;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.261 -0400", hash_original_method = "995B7A71D6CB331F5D54C3F6E2CEFCD4", hash_generated_method = "5E7FA8321C784EF3A98EC668AD92E1A6")
        @Override
        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            mExpandedActionView = item.getActionView();
            mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
            mCurrentExpandedItem = item;
            {
                boolean var7811D6348E8E8927920AD531ECB22264_1826043116 = (mExpandedActionView.getParent() != ActionBarView.this);
                {
                    addView(mExpandedActionView);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCD5AB96D29ED8937C8936431173407E1_2059591485 = (mExpandedHomeLayout.getParent() != ActionBarView.this);
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
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072373727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072373727;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.262 -0400", hash_original_method = "91D41E28867193763062F9A55820BEE2", hash_generated_method = "1653A7F84D679990573577663FCA37B7")
        @Override
        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
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
            addTaint(menu.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156359961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_156359961;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.262 -0400", hash_original_method = "B74F33F41EA76949D2B7FFC2C0C48D8F", hash_generated_method = "895A0166A472CFB478753B81259C07C4")
        @Override
        public int getId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066849708 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066849708;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.263 -0400", hash_original_method = "F5855573BDD3346EB58FBC078F0D1E94", hash_generated_method = "43423712DED86E958690665A4DAAFE55")
        @Override
        public Parcelable onSaveInstanceState() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Parcelable varB4EAC82CA7396A68D541C85D26508E83_879489355 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_879489355 = null;
            varB4EAC82CA7396A68D541C85D26508E83_879489355.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_879489355;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.263 -0400", hash_original_method = "0C3EAD71D41C59A31F244EC76F29937C", hash_generated_method = "121C283A529B0D7F6A336D6D29A15283")
        @Override
        public void onRestoreInstanceState(Parcelable state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(state.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.263 -0400", hash_original_field = "CB6443DBE28157770714C1106DE615CA", hash_generated_field = "F68B0E0A29085C58E1E8FEE3E42E3EEA")

    private static String TAG = "ActionBarView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.263 -0400", hash_original_field = "6F6030D90CE7DC995900436D8BC936E2", hash_generated_field = "4A3C78D8B3B7DF5E626E3E97B7B40810")

    public static final int DISPLAY_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.263 -0400", hash_original_field = "B58CEC5EF27B51C142E556F5EEFFC55D", hash_generated_field = "7AAC5066F64117745658657CF86A53B2")

    private static int DISPLAY_RELAYOUT_MASK = ActionBar.DISPLAY_SHOW_HOME |
            ActionBar.DISPLAY_USE_LOGO |
            ActionBar.DISPLAY_HOME_AS_UP |
            ActionBar.DISPLAY_SHOW_CUSTOM |
            ActionBar.DISPLAY_SHOW_TITLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.267 -0400", hash_original_field = "AF4DF1B5C59571F3AE05F695061834CE", hash_generated_field = "22C38968D31A6AA64FB2ED98DE77374C")

    private static int DEFAULT_CUSTOM_GRAVITY = Gravity.LEFT | Gravity.CENTER_VERTICAL;
}

