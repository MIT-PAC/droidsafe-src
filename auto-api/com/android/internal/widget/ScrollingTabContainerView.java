package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "ScrollingTabContainerView";
    Runnable mTabSelector;
    private TabClickListener mTabClickListener;
    private LinearLayout mTabLayout;
    private Spinner mTabSpinner;
    private boolean mAllowCollapse;
    int mMaxTabWidth;
    private int mContentHeight;
    private int mSelectedTabIndex;
    protected Animator mVisibilityAnim;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    private static final int FADE_DURATION = 200;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.299 -0400", hash_original_method = "B354C67837F2A6192494F63E2EFB003B", hash_generated_method = "D9294E7495049F2DF8BAD97B2F5334AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "3098621744ABB84E77F43010FB80D748", hash_generated_method = "298FF5A381DC056CEA4A11A0515D222F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        final int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final boolean lockedExpanded;
        lockedExpanded = widthMode == MeasureSpec.EXACTLY;
        setFillViewport(lockedExpanded);
        final int childCount;
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
        final boolean canCollapse;
        canCollapse = !lockedExpanded && mAllowCollapse;
        {
            mTabLayout.measure(MeasureSpec.UNSPECIFIED, heightMeasureSpec);
            {
                boolean varA52158B277B4AE6568D7696673BFD35D_1733999570 = (mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec));
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
        final int oldWidth;
        oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int newWidth;
        newWidth = getMeasuredWidth();
        {
            setTabSelected(mSelectedTabIndex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "933D15861518C4BDC6EDA9867B851994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCollapsed() {
        boolean var551CC5E5B099A7CFD71A28BD56D945DE_1947072831 = (mTabSpinner != null && mTabSpinner.getParent() == this);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "7110FD7D2BA1DAC326B035538CBEB333")
    @DSModeled(DSC.SAFE)
    public void setAllowCollapse(boolean allowCollapse) {
        dsTaint.addTaint(allowCollapse);
        // ---------- Original Method ----------
        //mAllowCollapse = allowCollapse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "002FC4053C0D51D3D52C5463A6463800", hash_generated_method = "4ABD808708C86E8A516CEFF50B6C1F7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performCollapse() {
        {
            boolean var6B72A0690292269FB07D412474ADE825_749979646 = (isCollapsed());
        } //End collapsed parenthetic
        {
            mTabSpinner = createSpinner();
        } //End block
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        {
            boolean varD90AE433F33EF1BFD3982D954DB10099_1810003397 = (mTabSpinner.getAdapter() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "DC1833D7C81A29FFDE1BB4D9BF0A022D", hash_generated_method = "FDFD1551D8482035D8C9D2EE9A9EBB04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean performExpand() {
        {
            boolean varFE3D7FC075FB72514E33588859243326_436939396 = (!isCollapsed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "2880D1017429231FB4C783DE8155FB40", hash_generated_method = "0779B67EE1A5492EFA9FF40BA079704C")
    @DSModeled(DSC.SAFE)
    public void setTabSelected(int position) {
        dsTaint.addTaint(position);
        final int tabCount;
        tabCount = mTabLayout.getChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = mTabLayout.getChildAt(i);
                final boolean isSelected;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "65E68EE4B4B3E132BEE97D4D12F0A063")
    @DSModeled(DSC.SAFE)
    public void setContentHeight(int contentHeight) {
        dsTaint.addTaint(contentHeight);
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = contentHeight;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "5C02AED63A2A4EB9B288612999968966", hash_generated_method = "84933B9498B725A73D8B2C1967CAD300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LinearLayout createTabLayout() {
        final LinearLayout tabLayout;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.300 -0400", hash_original_method = "37274689DF291E70B964F7E850308591", hash_generated_method = "434C413545D025FBC7D294BCE13D25B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Spinner createSpinner() {
        final Spinner spinner;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "DD246DFC5FD99F8FA7C3003D550B61F7", hash_generated_method = "DA3513B53D1DC057A156B83622C95FBE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "69157A480990C0D905A38CA00057780E", hash_generated_method = "AF1400BD1A42BF43A887D1D0EC54886C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void animateToVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        {
            mVisibilityAnim.cancel();
        } //End block
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_931150574 = (getVisibility() != VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "F838B40357EF140BE58C0FB6D2BEEE4D")
    @DSModeled(DSC.SAFE)
    public void animateToTab(final int position) {
        dsTaint.addTaint(position);
        final View tabView;
        tabView = mTabLayout.getChildAt(position);
        {
            removeCallbacks(mTabSelector);
        } //End block
        mTabSelector = new Runnable() {
            public void run() {
                final int scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
                smoothScrollTo(scrollPos, 0);
                mTabSelector = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "CD29DCC6DE058B1BE5157F858D5ECDF5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "4DD6289EA7508EB5D78EBDE7604E8072")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "450EFC0E420D351EC7204D6D5C8D9AC6", hash_generated_method = "1F5F0E09B06FB2ABD7E7BC3F67FF5BF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(forAdapter);
        final TabView tabView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "21975DD541C9968A5D84261D431559E1", hash_generated_method = "7D7DAB98151E5CFC13ECF5AE3ECD099F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.301 -0400", hash_original_method = "120AD652FAF12AEC39493BA97DDC8DBA", hash_generated_method = "8894748DA42213DCB7C7CEF54ABAC5CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(tab.dsTaint);
        dsTaint.addTaint(setSelected);
        final TabView tabView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "8E7B6C003AF19F3AF2B580FFC3084A77")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "1DD58A95621CE0FF54C2CBCA9CE25A1F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "73E473C7CC5AC653E35159F785B6F67D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "1E807444FE245168D5D160AA45CB2236", hash_generated_method = "CDEACD4859221ACCED6CF3DE32C88D85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(position);
        dsTaint.addTaint(id);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        TabView tabView;
        tabView = (TabView) view;
        tabView.getTab().select();
        // ---------- Original Method ----------
        //TabView tabView = (TabView) view;
        //tabView.getTab().select();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "8197721D260305AB85A1A2663FB8E834")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "B5DB6118A5A739AD937742D1C44B643E", hash_generated_method = "6CA5C0E174CA9BCF9F20483E82170F20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TabView(Context context, ActionBar.Tab tab, boolean forList) {
            super(context, null, com.android.internal.R.attr.actionBarTabStyle);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(tab.dsTaint);
            dsTaint.addTaint(forList);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "F47DC88329E05996F10046ACC14BB8E5", hash_generated_method = "828CCF8CA45A5B7C71E70AA339AF640D")
        @DSModeled(DSC.SAFE)
        public void bindTab(ActionBar.Tab tab) {
            dsTaint.addTaint(tab.dsTaint);
            update();
            // ---------- Original Method ----------
            //mTab = tab;
            //update();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.302 -0400", hash_original_method = "FFA211085DE297C0E0EC5011B4DE8B57", hash_generated_method = "C4F99EF7D77AA8B82F7D9CC4447BE7E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(heightMeasureSpec);
            dsTaint.addTaint(widthMeasureSpec);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            {
                boolean var324CF3D70AA77B616B77CDF8D6A963D0_561645117 = (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "0AA8F20782F60FCDEB51E2F40EEE8538", hash_generated_method = "0C11C6D96B4FA5B5ED25E6E0D3FF191B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void update() {
            final ActionBar.Tab tab;
            tab = mTab;
            final View custom;
            custom = tab.getCustomView();
            {
                final ViewParent customParent;
                customParent = custom.getParent();
                {
                    ((ViewGroup) customParent).removeView(custom);
                    addView(custom);
                } //End block
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
                final Drawable icon;
                icon = tab.getIcon();
                final CharSequence text;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "8ACD8C7DACBB258E07DA374214A46BC1", hash_generated_method = "62977A3FAB0606D6D6E9D5DAF45E709B")
        @DSModeled(DSC.SAFE)
        public ActionBar.Tab getTab() {
            return (ActionBar.Tab)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mTab;
        }

        
    }


    
    private class TabAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "8A8A2A6470BE340ED0660B0DF0493034", hash_generated_method = "CD4EF9FA2728C1AC36F1ADF640CC6C77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getCount() {
            int var05B9487F20C1BA2A8719F1ECE24F801B_1130353424 = (mTabLayout.getChildCount());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mTabLayout.getChildCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "A98679EF5D46D1EF9814D015704A8113", hash_generated_method = "7F96335C9E21672951D9A04A150C9C14")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getItem(int position) {
            dsTaint.addTaint(position);
            Object var07605BB39FB0E555B28B0D43F3BA8A92_1431745794 = (((TabView) mTabLayout.getChildAt(position)).getTab());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((TabView) mTabLayout.getChildAt(position)).getTab();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "ECCA4BEA619FBCD3F1E9C47E7B671689")
        @DSModeled(DSC.SAFE)
        @Override
        public long getItemId(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "C541E21433CF0B8E7E2EE0D1C892D4E4", hash_generated_method = "BF1F4D2CFF3080452FC2ADF8BF534EBB")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "024B6ED45DE6B4C8643F8BD12AD99CDA", hash_generated_method = "FB2084AFD47AE7B1FA95496ADA730D85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(view.dsTaint);
            TabView tabView;
            tabView = (TabView) view;
            tabView.getTab().select();
            final int tabCount;
            tabCount = mTabLayout.getChildCount();
            {
                int i;
                i = 0;
                {
                    final View child;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "1280A3E9D7144E6C91453BA1499F1CC3")
        @DSModeled(DSC.SAFE)
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            dsTaint.addTaint(visibility);
            return (VisibilityAnimListener)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "BD00BCAE2AB5EB8ACE46991AFDCC5093")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "FCD0A8E872EDB46A2BFC14B31FFA43CC", hash_generated_method = "62111BFC69F275DDCE939D543160B513")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "87338A0AE17B72148398A1A0FE6DD53B")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            mCanceled = true;
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.303 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "75FF296FC60604A343A82AB9CB8690F0")
        @DSModeled(DSC.SAFE)
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}


