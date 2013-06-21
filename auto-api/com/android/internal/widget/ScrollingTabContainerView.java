package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    Runnable mTabSelector;
    private TabClickListener mTabClickListener;
    private LinearLayout mTabLayout;
    private Spinner mTabSpinner;
    private boolean mAllowCollapse;
    int mMaxTabWidth;
    private int mContentHeight;
    private int mSelectedTabIndex;
    protected Animator mVisibilityAnim;
    protected VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.101 -0400", hash_original_method = "B354C67837F2A6192494F63E2EFB003B", hash_generated_method = "897815BA6F29E4CBEE69CBE13FEC3F34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScrollingTabContainerView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        setHorizontalScrollBarEnabled(false);
        TypedArray a;
        a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        mTabLayout = createTabLayout();
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        // ---------- Original Method ----------
        //setHorizontalScrollBarEnabled(false);
        //TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                //com.android.internal.R.attr.actionBarStyle, 0);
        //setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        //a.recycle();
        //mTabLayout = createTabLayout();
        //addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.MATCH_PARENT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.102 -0400", hash_original_method = "3098621744ABB84E77F43010FB80D748", hash_generated_method = "F1F0E5E9F9965CB977DA3013A7BE6579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        boolean lockedExpanded;
        lockedExpanded = widthMode == MeasureSpec.EXACTLY;
        setFillViewport(lockedExpanded);
        int childCount;
        childCount = mTabLayout.getChildCount();
        {
            {
                mMaxTabWidth = (int) (MeasureSpec.getSize(widthMeasureSpec) * 0.4f);
            } //End block
            {
                mMaxTabWidth = MeasureSpec.getSize(widthMeasureSpec) / 2;
            } //End block
        } //End block
        {
            mMaxTabWidth = -1;
        } //End block
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY);
        boolean canCollapse;
        canCollapse = !lockedExpanded && mAllowCollapse;
        {
            mTabLayout.measure(MeasureSpec.UNSPECIFIED, heightMeasureSpec);
            {
                boolean varA52158B277B4AE6568D7696673BFD35D_547407798 = (mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec));
                {
                    performCollapse();
                } //End block
                {
                    performExpand();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            performExpand();
        } //End block
        int oldWidth;
        oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int newWidth;
        newWidth = getMeasuredWidth();
        {
            setTabSelected(mSelectedTabIndex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.102 -0400", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "9AEC754CCF40831998FC5F3B1CA545BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCollapsed() {
        boolean var551CC5E5B099A7CFD71A28BD56D945DE_1884488573 = (mTabSpinner != null && mTabSpinner.getParent() == this);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.102 -0400", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "80D029598157BCABFDA18EA0EC36134A")
    @DSModeled(DSC.SAFE)
    public void setAllowCollapse(boolean allowCollapse) {
        dsTaint.addTaint(allowCollapse);
        // ---------- Original Method ----------
        //mAllowCollapse = allowCollapse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.103 -0400", hash_original_method = "002FC4053C0D51D3D52C5463A6463800", hash_generated_method = "C9FEB99E145E14A11F590ABB4FAC8604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performCollapse() {
        {
            boolean var6B72A0690292269FB07D412474ADE825_502499015 = (isCollapsed());
        } //End collapsed parenthetic
        {
            mTabSpinner = createSpinner();
        } //End block
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        {
            boolean varD90AE433F33EF1BFD3982D954DB10099_2036028241 = (mTabSpinner.getAdapter() == null);
            {
                mTabSpinner.setAdapter(new TabAdapter());
            } //End block
        } //End collapsed parenthetic
        {
            removeCallbacks(mTabSelector);
            mTabSelector = null;
        } //End block
        mTabSpinner.setSelection(mSelectedTabIndex);
        // ---------- Original Method ----------
        //if (isCollapsed()) return;
        //if (mTabSpinner == null) {
            //mTabSpinner = createSpinner();
        //}
        //removeView(mTabLayout);
        //addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.MATCH_PARENT));
        //if (mTabSpinner.getAdapter() == null) {
            //mTabSpinner.setAdapter(new TabAdapter());
        //}
        //if (mTabSelector != null) {
            //removeCallbacks(mTabSelector);
            //mTabSelector = null;
        //}
        //mTabSpinner.setSelection(mSelectedTabIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.103 -0400", hash_original_method = "DC1833D7C81A29FFDE1BB4D9BF0A022D", hash_generated_method = "82C120E1AEA56C9E7FBB1E46E0B8D803")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean performExpand() {
        {
            boolean varFE3D7FC075FB72514E33588859243326_1530779348 = (!isCollapsed());
        } //End collapsed parenthetic
        removeView(mTabSpinner);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setTabSelected(mTabSpinner.getSelectedItemPosition());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isCollapsed()) return false;
        //removeView(mTabSpinner);
        //addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.MATCH_PARENT));
        //setTabSelected(mTabSpinner.getSelectedItemPosition());
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.103 -0400", hash_original_method = "2880D1017429231FB4C783DE8155FB40", hash_generated_method = "D42A79FB575D8EFF6F0188A838F4D699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTabSelected(int position) {
        dsTaint.addTaint(position);
        int tabCount;
        tabCount = mTabLayout.getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = mTabLayout.getChildAt(i);
                boolean isSelected;
                isSelected = i == position;
                child.setSelected(isSelected);
                {
                    animateToTab(position);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSelectedTabIndex = position;
        //final int tabCount = mTabLayout.getChildCount();
        //for (int i = 0; i < tabCount; i++) {
            //final View child = mTabLayout.getChildAt(i);
            //final boolean isSelected = i == position;
            //child.setSelected(isSelected);
            //if (isSelected) {
                //animateToTab(position);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.104 -0400", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "2DD348FF85F35B1E8911FC135248C790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentHeight(int contentHeight) {
        dsTaint.addTaint(contentHeight);
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = contentHeight;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.104 -0400", hash_original_method = "5C02AED63A2A4EB9B288612999968966", hash_generated_method = "10215DCED8C6F70D47CF686C19205A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LinearLayout createTabLayout() {
        LinearLayout tabLayout;
        tabLayout = new LinearLayout(getContext(), null,
                com.android.internal.R.attr.actionBarTabBarStyle);
        tabLayout.setMeasureWithLargestChildEnabled(true);
        tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return (LinearLayout)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final LinearLayout tabLayout = new LinearLayout(getContext(), null,
                //com.android.internal.R.attr.actionBarTabBarStyle);
        //tabLayout.setMeasureWithLargestChildEnabled(true);
        //tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                //LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //return tabLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.104 -0400", hash_original_method = "37274689DF291E70B964F7E850308591", hash_generated_method = "08A1B70E4108A6A83DA05B1CAF3F55A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Spinner createSpinner() {
        Spinner spinner;
        spinner = new Spinner(getContext(), null,
                com.android.internal.R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        spinner.setOnItemSelectedListener(this);
        return (Spinner)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Spinner spinner = new Spinner(getContext(), null,
                //com.android.internal.R.attr.actionDropDownStyle);
        //spinner.setLayoutParams(new LinearLayout.LayoutParams(
                //LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //spinner.setOnItemSelectedListener(this);
        //return spinner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.104 -0400", hash_original_method = "DD246DFC5FD99F8FA7C3003D550B61F7", hash_generated_method = "9D1A4F55D71ADDB449A6A2DC8B97C939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        super.onConfigurationChanged(newConfig);
        TypedArray a;
        a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                //com.android.internal.R.attr.actionBarStyle, 0);
        //setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.105 -0400", hash_original_method = "69157A480990C0D905A38CA00057780E", hash_generated_method = "74A45862CAA87479CCD82A8FF659B7FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void animateToVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        {
            mVisibilityAnim.cancel();
        } //End block
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_2005208122 = (getVisibility() != VISIBLE);
                {
                    setAlpha(0);
                } //End block
            } //End collapsed parenthetic
            ObjectAnimator anim;
            anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        } //End block
        {
            ObjectAnimator anim;
            anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        } //End block
        // ---------- Original Method ----------
        //if (mVisibilityAnim != null) {
            //mVisibilityAnim.cancel();
        //}
        //if (visibility == VISIBLE) {
            //if (getVisibility() != VISIBLE) {
                //setAlpha(0);
            //}
            //ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            //anim.setDuration(FADE_DURATION);
            //anim.setInterpolator(sAlphaInterpolator);
            //anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            //anim.start();
        //} else {
            //ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
            //anim.setDuration(FADE_DURATION);
            //anim.setInterpolator(sAlphaInterpolator);
            //anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            //anim.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.105 -0400", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "408A5C1F91D7FBA6755170431075AC11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void animateToTab(final int position) {
        dsTaint.addTaint(position);
        View tabView;
        tabView = mTabLayout.getChildAt(position);
        {
            removeCallbacks(mTabSelector);
        } //End block
        mTabSelector = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.105 -0400", hash_original_method = "624465A8A4FF7840574C164453105D67", hash_generated_method = "C126B8E44776A06A3D35D4B101D43300")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                int scrollPos;
                scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                smoothScrollTo(scrollPos, 0);
                mTabSelector = null;
                // ---------- Original Method ----------
                //final int scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                //smoothScrollTo(scrollPos, 0);
                //mTabSelector = null;
            }
};
        post(mTabSelector);
        // ---------- Original Method ----------
        //final View tabView = mTabLayout.getChildAt(position);
        //if (mTabSelector != null) {
            //removeCallbacks(mTabSelector);
        //}
        //mTabSelector = new Runnable() {
            //public void run() {
                //final int scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                //smoothScrollTo(scrollPos, 0);
                //mTabSelector = null;
            //}
        //};
        //post(mTabSelector);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.106 -0400", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "9F62CB462C72183B08CFCFC02D001D3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            post(mTabSelector);
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mTabSelector != null) {
            //post(mTabSelector);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.106 -0400", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "D72DCDA1DCA4C064AC6156264DCE07BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            removeCallbacks(mTabSelector);
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mTabSelector != null) {
            //removeCallbacks(mTabSelector);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.106 -0400", hash_original_method = "450EFC0E420D351EC7204D6D5C8D9AC6", hash_generated_method = "7EC8EBF0E0253D394C35AFB6513C562C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(forAdapter);
        TabView tabView;
        tabView = new TabView(getContext(), tab, forAdapter);
        {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,
                    mContentHeight));
        } //End block
        {
            tabView.setFocusable(true);
            {
                mTabClickListener = new TabClickListener();
            } //End block
            tabView.setOnClickListener(mTabClickListener);
        } //End block
        return (TabView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final TabView tabView = new TabView(getContext(), tab, forAdapter);
        //if (forAdapter) {
            //tabView.setBackgroundDrawable(null);
            //tabView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,
                    //mContentHeight));
        //} else {
            //tabView.setFocusable(true);
            //if (mTabClickListener == null) {
                //mTabClickListener = new TabClickListener();
            //}
            //tabView.setOnClickListener(mTabClickListener);
        //}
        //return tabView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.106 -0400", hash_original_method = "21975DD541C9968A5D84261D431559E1", hash_generated_method = "3B33DE22CC311C65EBF91EA5A8BE62D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(setSelected);
        TabView tabView;
        tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0,
                LayoutParams.MATCH_PARENT, 1));
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            tabView.setSelected(true);
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //TabView tabView = createTabView(tab, false);
        //mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0,
                //LayoutParams.MATCH_PARENT, 1));
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (setSelected) {
            //tabView.setSelected(true);
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.107 -0400", hash_original_method = "120AD652FAF12AEC39493BA97DDC8DBA", hash_generated_method = "FA37BE66575D950C26A6DADC8F1093B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(setSelected);
        TabView tabView;
        tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, position, new LinearLayout.LayoutParams(
                0, LayoutParams.MATCH_PARENT, 1));
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            tabView.setSelected(true);
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //final TabView tabView = createTabView(tab, false);
        //mTabLayout.addView(tabView, position, new LinearLayout.LayoutParams(
                //0, LayoutParams.MATCH_PARENT, 1));
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (setSelected) {
            //tabView.setSelected(true);
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.107 -0400", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "79B37793C90B890C64390109BB167411")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateTab(int position) {
        dsTaint.addTaint(position);
        ((TabView) mTabLayout.getChildAt(position)).update();
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //((TabView) mTabLayout.getChildAt(position)).update();
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.107 -0400", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "935DAFA92ACC8AE94433C269A060F390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTabAt(int position) {
        dsTaint.addTaint(position);
        mTabLayout.removeViewAt(position);
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //mTabLayout.removeViewAt(position);
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.108 -0400", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "3FCAFF75B22CA75D6BD43E12E090EA5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllTabs() {
        mTabLayout.removeAllViews();
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //mTabLayout.removeAllViews();
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.109 -0400", hash_original_method = "1E807444FE245168D5D160AA45CB2236", hash_generated_method = "56185AB1D03D9ACBE339EDA9582B9133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        TabView tabView;
        tabView = (TabView) view;
        tabView.getTab().select();
        // ---------- Original Method ----------
        //TabView tabView = (TabView) view;
        //tabView.getTab().select();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.109 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "A11AFE9C6AAEF778D9039DF580B1C0C2")
    @DSModeled(DSC.SAFE)
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(parent.dsTaint);
        // ---------- Original Method ----------
    }

    
    private class TabView extends LinearLayout {
        private ActionBar.Tab mTab;
        private TextView mTextView;
        private ImageView mIconView;
        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.110 -0400", hash_original_method = "B5DB6118A5A739AD937742D1C44B643E", hash_generated_method = "3EF6347C5C09377D4B0B91A5754D28AA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TabView(Context context, ActionBar.Tab tab, boolean forList) {
            super(context, null, com.android.internal.R.attr.actionBarTabStyle);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(forList);
            dsTaint.addTaint(tab.dsTaint);
            {
                setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            } //End block
            update();
            // ---------- Original Method ----------
            //mTab = tab;
            //if (forList) {
                //setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            //}
            //update();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.110 -0400", hash_original_method = "F47DC88329E05996F10046ACC14BB8E5", hash_generated_method = "D760A12EB8035BC7A6ED1EEA211487EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bindTab(ActionBar.Tab tab) {
            dsTaint.addTaint(tab.dsTaint);
            update();
            // ---------- Original Method ----------
            //mTab = tab;
            //update();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.110 -0400", hash_original_method = "FFA211085DE297C0E0EC5011B4DE8B57", hash_generated_method = "225E1EBCF5B7820A610A969D1D5358BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(heightMeasureSpec);
            dsTaint.addTaint(widthMeasureSpec);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            {
                boolean var324CF3D70AA77B616B77CDF8D6A963D0_1437271597 = (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth);
                {
                    super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        heightMeasureSpec);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            //if (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth) {
                //super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        //heightMeasureSpec);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.111 -0400", hash_original_method = "0AA8F20782F60FCDEB51E2F40EEE8538", hash_generated_method = "B22202C46B7B6C693E74D1C232549FB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void update() {
            ActionBar.Tab tab;
            tab = mTab;
            View custom;
            custom = tab.getCustomView();
            {
                ViewParent customParent;
                customParent = custom.getParent();
                {
                    boolean varA92912C2F8F3D980AAEE4A18A937AA8F_91107978 = (customParent != this);
                    {
                        ((ViewGroup) customParent).removeView(custom);
                        addView(custom);
                    } //End block
                } //End collapsed parenthetic
                mCustomView = custom;
                mTextView.setVisibility(GONE);
                {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                } //End block
            } //End block
            {
                {
                    removeView(mCustomView);
                    mCustomView = null;
                } //End block
                Drawable icon;
                icon = tab.getIcon();
                CharSequence text;
                text = tab.getText();
                {
                    {
                        ImageView iconView;
                        iconView = new ImageView(getContext());
                        LayoutParams lp;
                        lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        iconView.setLayoutParams(lp);
                        addView(iconView, 0);
                        mIconView = iconView;
                    } //End block
                    mIconView.setImageDrawable(icon);
                    mIconView.setVisibility(VISIBLE);
                } //End block
                {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                } //End block
                {
                    {
                        TextView textView;
                        textView = new TextView(getContext(), null,
                                com.android.internal.R.attr.actionBarTabTextStyle);
                        textView.setEllipsize(TruncateAt.END);
                        LayoutParams lp;
                        lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        textView.setLayoutParams(lp);
                        addView(textView);
                        mTextView = textView;
                    } //End block
                    mTextView.setText(text);
                    mTextView.setVisibility(VISIBLE);
                } //End block
                {
                    mTextView.setVisibility(GONE);
                    mTextView.setText(null);
                } //End block
                {
                    mIconView.setContentDescription(tab.getContentDescription());
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.111 -0400", hash_original_method = "8ACD8C7DACBB258E07DA374214A46BC1", hash_generated_method = "07CA92A48527C57B1C1695A7067451C7")
        @DSModeled(DSC.SAFE)
        public ActionBar.Tab getTab() {
            return (ActionBar.Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mTab;
        }

        
    }


    
    private class TabAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.111 -0400", hash_original_method = "C4625763AB86E754A24552005C6813F1", hash_generated_method = "C4625763AB86E754A24552005C6813F1")
                public TabAdapter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.112 -0400", hash_original_method = "8A8A2A6470BE340ED0660B0DF0493034", hash_generated_method = "E0E2AFB35BC61E2054A8AEC74ADB0013")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getCount() {
            int var05B9487F20C1BA2A8719F1ECE24F801B_673816483 = (mTabLayout.getChildCount());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mTabLayout.getChildCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.112 -0400", hash_original_method = "A98679EF5D46D1EF9814D015704A8113", hash_generated_method = "CFCDE09165F24B8F71CD5B0C1CF2EBEA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getItem(int position) {
            dsTaint.addTaint(position);
            Object var07605BB39FB0E555B28B0D43F3BA8A92_1935835757 = (((TabView) mTabLayout.getChildAt(position)).getTab());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((TabView) mTabLayout.getChildAt(position)).getTab();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.112 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "42B7A6F5FB834BAF1538980253DE1EBC")
        @DSModeled(DSC.SAFE)
        @Override
        public long getItemId(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.112 -0400", hash_original_method = "C541E21433CF0B8E7E2EE0D1C892D4E4", hash_generated_method = "24FA962BAAA9C220717138004D7EEA9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            {
                convertView = createTabView((ActionBar.Tab) getItem(position), true);
            } //End block
            {
                ((TabView) convertView).bindTab((ActionBar.Tab) getItem(position));
            } //End block
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (convertView == null) {
                //convertView = createTabView((ActionBar.Tab) getItem(position), true);
            //} else {
                //((TabView) convertView).bindTab((ActionBar.Tab) getItem(position));
            //}
            //return convertView;
        }

        
    }


    
    private class TabClickListener implements OnClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.112 -0400", hash_original_method = "FB90120FB11DABD392D3949CF882B31D", hash_generated_method = "FB90120FB11DABD392D3949CF882B31D")
                public TabClickListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.113 -0400", hash_original_method = "024B6ED45DE6B4C8643F8BD12AD99CDA", hash_generated_method = "9C5ECE453FD3C0469C56CDC0C3535F7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(view.dsTaint);
            TabView tabView;
            tabView = (TabView) view;
            tabView.getTab().select();
            int tabCount;
            tabCount = mTabLayout.getChildCount();
            {
                int i;
                i = 0;
                {
                    View child;
                    child = mTabLayout.getChildAt(i);
                    child.setSelected(child == view);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //TabView tabView = (TabView) view;
            //tabView.getTab().select();
            //final int tabCount = mTabLayout.getChildCount();
            //for (int i = 0; i < tabCount; i++) {
                //final View child = mTabLayout.getChildAt(i);
                //child.setSelected(child == view);
            //}
        }

        
    }


    
    protected class VisibilityAnimListener implements Animator.AnimatorListener {
        private boolean mCanceled = false;
        private int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.113 -0400", hash_original_method = "75ECA60C9F4D40F51E44C573AEFCFF43", hash_generated_method = "75ECA60C9F4D40F51E44C573AEFCFF43")
                public VisibilityAnimListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.113 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "0EB86CF95549717BDD874A96926731C1")
        @DSModeled(DSC.SAFE)
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            dsTaint.addTaint(visibility);
            return (VisibilityAnimListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.113 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "02ED50A540B5E0EF7632FAFCF88A0B8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            // ---------- Original Method ----------
            //setVisibility(VISIBLE);
            //mVisibilityAnim = animation;
            //mCanceled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.113 -0400", hash_original_method = "FCD0A8E872EDB46A2BFC14B31FFA43CC", hash_generated_method = "CDEAE641D758671765107BA25CADE32C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            // ---------- Original Method ----------
            //if (mCanceled) return;
            //mVisibilityAnim = null;
            //setVisibility(mFinalVisibility);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.114 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "D78BD99B7FA096BC0F7A22E022644707")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mCanceled = true;
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.114 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2D32F9A43E5261B156C7705DA49965D8")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static final String TAG = "ScrollingTabContainerView";
    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    private static final int FADE_DURATION = 200;
}

