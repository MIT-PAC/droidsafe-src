package com.android.internal.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "85B61EC738F2056493BB5A07F48F6CE2", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "7B7BE9A380D80EE64647F123DDF5EE4B", hash_generated_field = "9D65B8DF4295D2997A201C87527D1868")

    private TabClickListener mTabClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "AE6F3073108E075D4F8197E16CD03BFE", hash_generated_field = "E5144854D9186C0CFBAD4E1FE3ACCBAF")

    private LinearLayout mTabLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "19323BA77D1B90D50BDC8C305F409012", hash_generated_field = "992DC55613E9C96C70980F7C6305042C")

    private Spinner mTabSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "1A82A7735BB27C6FDFFDF44101DF2FC1", hash_generated_field = "F02107E932C3D4F526DFB20B4DC44818")

    private boolean mAllowCollapse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "853B3497BE9CA3D38FD649114DCE0E75", hash_generated_field = "2536FBAA8D2459579C241F8EA3302AA1")

    int mMaxTabWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "DD984F5B26439BEE2E88B28167086754", hash_generated_field = "5FAA7FEF18B6FA6D1EC21FF900B235B4")

    private int mSelectedTabIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.235 -0400", hash_original_field = "1CF5159AB7BA0B608B8FD842C6C652D4", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.236 -0400", hash_original_field = "27A07A2C9917014FCD8B9D90F05A92EC", hash_generated_field = "2572558D73FCEA5CB5F54CEC528FD58F")

    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.236 -0400", hash_original_method = "B354C67837F2A6192494F63E2EFB003B", hash_generated_method = "B7E883C2F2F4D40C000F0992021DFADA")
    public  ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        mTabLayout = createTabLayout();
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        addTaint(context.getTaint());
        
        
        
                
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.237 -0400", hash_original_method = "3098621744ABB84E77F43010FB80D748", hash_generated_method = "FC69393D190D098BA0E821F6EDC4111F")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final boolean lockedExpanded = widthMode == MeasureSpec.EXACTLY;
        setFillViewport(lockedExpanded);
        final int childCount = mTabLayout.getChildCount();
        {
            {
                mMaxTabWidth = (int) (MeasureSpec.getSize(widthMeasureSpec) * 0.4f);
            } 
            {
                mMaxTabWidth = MeasureSpec.getSize(widthMeasureSpec) / 2;
            } 
        } 
        {
            mMaxTabWidth = -1;
        } 
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY);
        final boolean canCollapse = !lockedExpanded && mAllowCollapse;
        {
            mTabLayout.measure(MeasureSpec.UNSPECIFIED, heightMeasureSpec);
            {
                boolean varA52158B277B4AE6568D7696673BFD35D_2134065985 = (mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec));
                {
                    performCollapse();
                } 
                {
                    performExpand();
                } 
            } 
        } 
        {
            performExpand();
        } 
        final int oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int newWidth = getMeasuredWidth();
        {
            setTabSelected(mSelectedTabIndex);
        } 
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.237 -0400", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "824621321ABB48D25E69A230211E4272")
    private boolean isCollapsed() {
        boolean var551CC5E5B099A7CFD71A28BD56D945DE_1336055703 = (mTabSpinner != null && mTabSpinner.getParent() == this);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982640167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_982640167;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.237 -0400", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "3CC7274A44B95F0704BA216FDB666531")
    public void setAllowCollapse(boolean allowCollapse) {
        mAllowCollapse = allowCollapse;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.238 -0400", hash_original_method = "002FC4053C0D51D3D52C5463A6463800", hash_generated_method = "3E819D1E5DA5A22D999B7D198DF66408")
    private void performCollapse() {
        {
            boolean var6B72A0690292269FB07D412474ADE825_954727289 = (isCollapsed());
        } 
        {
            mTabSpinner = createSpinner();
        } 
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        {
            boolean varD90AE433F33EF1BFD3982D954DB10099_1054973882 = (mTabSpinner.getAdapter() == null);
            {
                mTabSpinner.setAdapter(new TabAdapter());
            } 
        } 
        {
            removeCallbacks(mTabSelector);
            mTabSelector = null;
        } 
        mTabSpinner.setSelection(mSelectedTabIndex);
        
        
        
            
        
        
        
                
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.239 -0400", hash_original_method = "DC1833D7C81A29FFDE1BB4D9BF0A022D", hash_generated_method = "422B51A57613862F04EE3C51AC57592D")
    private boolean performExpand() {
        {
            boolean varFE3D7FC075FB72514E33588859243326_2097757259 = (!isCollapsed());
        } 
        removeView(mTabSpinner);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setTabSelected(mTabSpinner.getSelectedItemPosition());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722199633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722199633;
        
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.239 -0400", hash_original_method = "2880D1017429231FB4C783DE8155FB40", hash_generated_method = "8E6D49218E4A622F950D5DCA2EA975B1")
    public void setTabSelected(int position) {
        mSelectedTabIndex = position;
        final int tabCount = mTabLayout.getChildCount();
        {
            int i = 0;
            {
                final View child = mTabLayout.getChildAt(i);
                final boolean isSelected = i == position;
                child.setSelected(isSelected);
                {
                    animateToTab(position);
                } 
            } 
        } 
        
        
        
        
            
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.240 -0400", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "26F2E91F17A5314422F78CA7BBBD3619")
    public void setContentHeight(int contentHeight) {
        mContentHeight = contentHeight;
        requestLayout();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.241 -0400", hash_original_method = "5C02AED63A2A4EB9B288612999968966", hash_generated_method = "C792A797525F79BA351A1FC0F7123156")
    private LinearLayout createTabLayout() {
        LinearLayout varB4EAC82CA7396A68D541C85D26508E83_1998295278 = null; 
        final LinearLayout tabLayout = new LinearLayout(getContext(), null,
                com.android.internal.R.attr.actionBarTabBarStyle);
        tabLayout.setMeasureWithLargestChildEnabled(true);
        tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        varB4EAC82CA7396A68D541C85D26508E83_1998295278 = tabLayout;
        varB4EAC82CA7396A68D541C85D26508E83_1998295278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1998295278;
        
        
                
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.242 -0400", hash_original_method = "37274689DF291E70B964F7E850308591", hash_generated_method = "5DCF9E8A38C1208C1FEC94B8BE9B6433")
    private Spinner createSpinner() {
        Spinner varB4EAC82CA7396A68D541C85D26508E83_924463888 = null; 
        final Spinner spinner = new Spinner(getContext(), null,
                com.android.internal.R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        spinner.setOnItemSelectedListener(this);
        varB4EAC82CA7396A68D541C85D26508E83_924463888 = spinner;
        varB4EAC82CA7396A68D541C85D26508E83_924463888.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_924463888;
        
        
                
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.242 -0400", hash_original_method = "DD246DFC5FD99F8FA7C3003D550B61F7", hash_generated_method = "A81DF8FD10BE3CD96E87AC01721BC647")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        addTaint(newConfig.getTaint());
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.242 -0400", hash_original_method = "69157A480990C0D905A38CA00057780E", hash_generated_method = "A795CF789C23C92DE8FF0ACDED7A7074")
    public void animateToVisibility(int visibility) {
        {
            mVisibilityAnim.cancel();
        } 
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_81861987 = (getVisibility() != VISIBLE);
                {
                    setAlpha(0);
                } 
            } 
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        } 
        {
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        } 
        addTaint(visibility);
        
        
            
        
        
            
                
            
            
            
            
            
            
        
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.243 -0400", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "35F01D413025D6752D2EC69EFD5C46AE")
    public void animateToTab(final int position) {
        final View tabView = mTabLayout.getChildAt(position);
        {
            removeCallbacks(mTabSelector);
        } 
        mTabSelector = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.243 -0400", hash_original_method = "624465A8A4FF7840574C164453105D67", hash_generated_method = "7302E1286720D09F48E93DAD199B6162")
            public void run() {
                final int scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                smoothScrollTo(scrollPos, 0);
                mTabSelector = null;
                
                
                
                
            }
};
        post(mTabSelector);
        addTaint(position);
        
        
        
            
        
        
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.244 -0400", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "9F62CB462C72183B08CFCFC02D001D3B")
    @Override
    public void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        {
            post(mTabSelector);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.244 -0400", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "D72DCDA1DCA4C064AC6156264DCE07BD")
    @Override
    public void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        {
            removeCallbacks(mTabSelector);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.245 -0400", hash_original_method = "450EFC0E420D351EC7204D6D5C8D9AC6", hash_generated_method = "5B22F849D0D998D69595D7CF8758C5E6")
    private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        TabView varB4EAC82CA7396A68D541C85D26508E83_1797027381 = null; 
        final TabView tabView = new TabView(getContext(), tab, forAdapter);
        {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,
                    mContentHeight));
        } 
        {
            tabView.setFocusable(true);
            {
                mTabClickListener = new TabClickListener();
            } 
            tabView.setOnClickListener(mTabClickListener);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1797027381 = tabView;
        addTaint(tab.getTaint());
        addTaint(forAdapter);
        varB4EAC82CA7396A68D541C85D26508E83_1797027381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1797027381;
        
        
        
            
            
                    
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.245 -0400", hash_original_method = "21975DD541C9968A5D84261D431559E1", hash_generated_method = "D44AFC2A5A4D6BEC430D78755851006E")
    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0,
                LayoutParams.MATCH_PARENT, 1));
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } 
        {
            tabView.setSelected(true);
        } 
        {
            requestLayout();
        } 
        addTaint(tab.getTaint());
        addTaint(setSelected);
        
        
        
                
        
            
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.245 -0400", hash_original_method = "120AD652FAF12AEC39493BA97DDC8DBA", hash_generated_method = "9A486CB72D95E1E083CE5310140798AC")
    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        final TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, position, new LinearLayout.LayoutParams(
                0, LayoutParams.MATCH_PARENT, 1));
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } 
        {
            tabView.setSelected(true);
        } 
        {
            requestLayout();
        } 
        addTaint(tab.getTaint());
        addTaint(position);
        addTaint(setSelected);
        
        
        
                
        
            
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.246 -0400", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "ACCE0DC04173D004849236FA059E1059")
    public void updateTab(int position) {
        ((TabView) mTabLayout.getChildAt(position)).update();
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } 
        {
            requestLayout();
        } 
        addTaint(position);
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.246 -0400", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "B20B400CB3EFEDBF7C771240FBE94E04")
    public void removeTabAt(int position) {
        mTabLayout.removeViewAt(position);
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } 
        {
            requestLayout();
        } 
        addTaint(position);
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "3FCAFF75B22CA75D6BD43E12E090EA5E")
    public void removeAllTabs() {
        mTabLayout.removeAllViews();
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } 
        {
            requestLayout();
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_method = "1E807444FE245168D5D160AA45CB2236", hash_generated_method = "E11B4B2CD6407E1C2D7C693172770913")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        
        TabView tabView = (TabView) view;
        tabView.getTab().select();
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "62984736880CAC76A8EB431CC994B1B9")
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        
        addTaint(parent.getTaint());
        
    }

    
    private class TabView extends LinearLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_field = "0420CD3815919DD8AB260E6D64B3A15D", hash_generated_field = "3557E0B9D4809295D85BAFD572E62004")

        private ActionBar.Tab mTab;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.247 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.248 -0400", hash_original_method = "B5DB6118A5A739AD937742D1C44B643E", hash_generated_method = "CB9E80A8C3936ACB49750D293196188A")
        public  TabView(Context context, ActionBar.Tab tab, boolean forList) {
            super(context, null, com.android.internal.R.attr.actionBarTabStyle);
            mTab = tab;
            {
                setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            } 
            update();
            addTaint(context.getTaint());
            addTaint(forList);
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.249 -0400", hash_original_method = "F47DC88329E05996F10046ACC14BB8E5", hash_generated_method = "0C984A7EAC8ED88CF651B5BA283C8A73")
        public void bindTab(ActionBar.Tab tab) {
            mTab = tab;
            update();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.249 -0400", hash_original_method = "FFA211085DE297C0E0EC5011B4DE8B57", hash_generated_method = "2037EFAB7EDC4C0D34CFFF2DFA2A64FA")
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            {
                boolean var324CF3D70AA77B616B77CDF8D6A963D0_2107140620 = (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth);
                {
                    super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        heightMeasureSpec);
                } 
            } 
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
            
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.250 -0400", hash_original_method = "0AA8F20782F60FCDEB51E2F40EEE8538", hash_generated_method = "707533EE51E60B56D12493A7D676457E")
        public void update() {
            final ActionBar.Tab tab = mTab;
            final View custom = tab.getCustomView();
            {
                final ViewParent customParent = custom.getParent();
                {
                    boolean varA92912C2F8F3D980AAEE4A18A937AA8F_728253257 = (customParent != this);
                    {
                        ((ViewGroup) customParent).removeView(custom);
                        addView(custom);
                    } 
                } 
                mCustomView = custom;
                mTextView.setVisibility(GONE);
                {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                } 
            } 
            {
                {
                    removeView(mCustomView);
                    mCustomView = null;
                } 
                final Drawable icon = tab.getIcon();
                final CharSequence text = tab.getText();
                {
                    {
                        ImageView iconView = new ImageView(getContext());
                        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        iconView.setLayoutParams(lp);
                        addView(iconView, 0);
                        mIconView = iconView;
                    } 
                    mIconView.setImageDrawable(icon);
                    mIconView.setVisibility(VISIBLE);
                } 
                {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                } 
                {
                    {
                        TextView textView = new TextView(getContext(), null,
                                com.android.internal.R.attr.actionBarTabTextStyle);
                        textView.setEllipsize(TruncateAt.END);
                        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        textView.setLayoutParams(lp);
                        addView(textView);
                        mTextView = textView;
                    } 
                    mTextView.setText(text);
                    mTextView.setVisibility(VISIBLE);
                } 
                {
                    mTextView.setVisibility(GONE);
                    mTextView.setText(null);
                } 
                {
                    mIconView.setContentDescription(tab.getContentDescription());
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.251 -0400", hash_original_method = "8ACD8C7DACBB258E07DA374214A46BC1", hash_generated_method = "E65457772A4680971FD8E5466D29E63A")
        public ActionBar.Tab getTab() {
            ActionBar.Tab varB4EAC82CA7396A68D541C85D26508E83_915223589 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_915223589 = mTab;
            varB4EAC82CA7396A68D541C85D26508E83_915223589.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_915223589;
            
            
        }

        
    }


    
    private class TabAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.251 -0400", hash_original_method = "D47CBC6CCDC74B210F03E0CA569B23D5", hash_generated_method = "D47CBC6CCDC74B210F03E0CA569B23D5")
        public TabAdapter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.252 -0400", hash_original_method = "8A8A2A6470BE340ED0660B0DF0493034", hash_generated_method = "B43BF2DD77CB7E7CC906321DEFB0C82C")
        @Override
        public int getCount() {
            int var05B9487F20C1BA2A8719F1ECE24F801B_434613229 = (mTabLayout.getChildCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285124896 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285124896;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.253 -0400", hash_original_method = "A98679EF5D46D1EF9814D015704A8113", hash_generated_method = "9AC8EADDCE0F7039F0ED21C21D05144C")
        @Override
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_693040799 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_693040799 = ((TabView) mTabLayout.getChildAt(position)).getTab();
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_693040799.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_693040799;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.253 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "1D97DCFD6EA2A8A65734D18585F4833E")
        @Override
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_452324423 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_452324423;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.257 -0400", hash_original_method = "C541E21433CF0B8E7E2EE0D1C892D4E4", hash_generated_method = "6FFC9C3FAAA6FD97FDE37C0F40675504")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_945468098 = null; 
            {
                convertView = createTabView((ActionBar.Tab) getItem(position), true);
            } 
            {
                ((TabView) convertView).bindTab((ActionBar.Tab) getItem(position));
            } 
            varB4EAC82CA7396A68D541C85D26508E83_945468098 = convertView;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_945468098.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_945468098;
            
            
                
            
                
            
            
        }

        
    }


    
    private class TabClickListener implements OnClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.257 -0400", hash_original_method = "4AA29A9A1E8E979F0176DF66C5E11348", hash_generated_method = "4AA29A9A1E8E979F0176DF66C5E11348")
        public TabClickListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.259 -0400", hash_original_method = "024B6ED45DE6B4C8643F8BD12AD99CDA", hash_generated_method = "A99B528FF144D26774456C9273B24CF0")
        public void onClick(View view) {
            
            TabView tabView = (TabView) view;
            tabView.getTab().select();
            final int tabCount = mTabLayout.getChildCount();
            {
                int i = 0;
                {
                    final View child = mTabLayout.getChildAt(i);
                    child.setSelected(child == view);
                } 
            } 
            addTaint(view.getTaint());
            
            
            
            
            
                
                
            
        }

        
    }


    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.259 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.259 -0400", hash_original_field = "270EA634CE9CE51A331284B9E8EB3832", hash_generated_field = "5617DA9FA1009CD83DDE5A46F5134947")

        private int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.259 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.261 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "E71C6EE3209F64754A0EC6B8E76C5900")
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            VisibilityAnimListener varB4EAC82CA7396A68D541C85D26508E83_754674920 = null; 
            mFinalVisibility = visibility;
            varB4EAC82CA7396A68D541C85D26508E83_754674920 = this;
            varB4EAC82CA7396A68D541C85D26508E83_754674920.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_754674920;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.262 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "B818DF791669294EDB0F112B9A238DEF")
        @Override
        public void onAnimationStart(Animator animation) {
            
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            addTaint(animation.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.263 -0400", hash_original_method = "FCD0A8E872EDB46A2BFC14B31FFA43CC", hash_generated_method = "7CA14196F462C97CAADC5EADB176F36A")
        @Override
        public void onAnimationEnd(Animator animation) {
            
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            addTaint(animation.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.264 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "66692DF1E254D3C3C92CC85749BF5C5B")
        @Override
        public void onAnimationCancel(Animator animation) {
            
            mCanceled = true;
            addTaint(animation.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.265 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
        @Override
        public void onAnimationRepeat(Animator animation) {
            
            addTaint(animation.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.265 -0400", hash_original_field = "CFF7D9C1D149B4BB31A82847457DB850", hash_generated_field = "8198E33AEA6A4E67CF498CFCEDA7ACFC")

    private static final String TAG = "ScrollingTabContainerView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.265 -0400", hash_original_field = "58EA75425C7F0D76C382950FFD0E66A6", hash_generated_field = "8547110952636D9B94C38943E41DDC94")

    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.265 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
}

