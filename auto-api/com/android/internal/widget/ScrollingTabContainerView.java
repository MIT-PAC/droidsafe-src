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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "85B61EC738F2056493BB5A07F48F6CE2", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "7B7BE9A380D80EE64647F123DDF5EE4B", hash_generated_field = "9D65B8DF4295D2997A201C87527D1868")

    private TabClickListener mTabClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "AE6F3073108E075D4F8197E16CD03BFE", hash_generated_field = "E5144854D9186C0CFBAD4E1FE3ACCBAF")

    private LinearLayout mTabLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "19323BA77D1B90D50BDC8C305F409012", hash_generated_field = "992DC55613E9C96C70980F7C6305042C")

    private Spinner mTabSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "1A82A7735BB27C6FDFFDF44101DF2FC1", hash_generated_field = "F02107E932C3D4F526DFB20B4DC44818")

    private boolean mAllowCollapse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "853B3497BE9CA3D38FD649114DCE0E75", hash_generated_field = "2536FBAA8D2459579C241F8EA3302AA1")

    int mMaxTabWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "DD984F5B26439BEE2E88B28167086754", hash_generated_field = "5FAA7FEF18B6FA6D1EC21FF900B235B4")

    private int mSelectedTabIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "1CF5159AB7BA0B608B8FD842C6C652D4", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.547 -0400", hash_original_field = "27A07A2C9917014FCD8B9D90F05A92EC", hash_generated_field = "086FDC026EF1BFDEA1109A9AB2C496E1")

    protected VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.548 -0400", hash_original_method = "B354C67837F2A6192494F63E2EFB003B", hash_generated_method = "8A897D297D474844C1328615FFBC193D")
    public  ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        TypedArray a;
        a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        mTabLayout = createTabLayout();
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.561 -0400", hash_original_method = "3098621744ABB84E77F43010FB80D748", hash_generated_method = "FA45012C22539EC52BF02E227858044A")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                boolean varA52158B277B4AE6568D7696673BFD35D_1166015985 = (mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec));
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
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.561 -0400", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "BF6AA0F771938B6A2070E812CF8B7F66")
    private boolean isCollapsed() {
        boolean var551CC5E5B099A7CFD71A28BD56D945DE_428747851 = (mTabSpinner != null && mTabSpinner.getParent() == this);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92870542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92870542;
        // ---------- Original Method ----------
        //return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.561 -0400", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "3CC7274A44B95F0704BA216FDB666531")
    public void setAllowCollapse(boolean allowCollapse) {
        mAllowCollapse = allowCollapse;
        // ---------- Original Method ----------
        //mAllowCollapse = allowCollapse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.562 -0400", hash_original_method = "002FC4053C0D51D3D52C5463A6463800", hash_generated_method = "DA5573BD96EE18BBDD95F175C522C465")
    private void performCollapse() {
        {
            boolean var6B72A0690292269FB07D412474ADE825_1939578149 = (isCollapsed());
        } //End collapsed parenthetic
        {
            mTabSpinner = createSpinner();
        } //End block
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        {
            boolean varD90AE433F33EF1BFD3982D954DB10099_856151038 = (mTabSpinner.getAdapter() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.562 -0400", hash_original_method = "DC1833D7C81A29FFDE1BB4D9BF0A022D", hash_generated_method = "96B04F106E2FF64E71AACEF9968CD6E3")
    private boolean performExpand() {
        {
            boolean varFE3D7FC075FB72514E33588859243326_2112164877 = (!isCollapsed());
        } //End collapsed parenthetic
        removeView(mTabSpinner);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setTabSelected(mTabSpinner.getSelectedItemPosition());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741766059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741766059;
        // ---------- Original Method ----------
        //if (!isCollapsed()) return false;
        //removeView(mTabSpinner);
        //addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.MATCH_PARENT));
        //setTabSelected(mTabSpinner.getSelectedItemPosition());
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.563 -0400", hash_original_method = "2880D1017429231FB4C783DE8155FB40", hash_generated_method = "EC514AC9CFD91F2C85BD8B44251F928E")
    public void setTabSelected(int position) {
        mSelectedTabIndex = position;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.563 -0400", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "26F2E91F17A5314422F78CA7BBBD3619")
    public void setContentHeight(int contentHeight) {
        mContentHeight = contentHeight;
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = contentHeight;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.637 -0400", hash_original_method = "5C02AED63A2A4EB9B288612999968966", hash_generated_method = "AC5A9E40FA0D01F34F0C6E6C10CF1DF4")
    private LinearLayout createTabLayout() {
        LinearLayout varB4EAC82CA7396A68D541C85D26508E83_870601396 = null; //Variable for return #1
        LinearLayout tabLayout;
        tabLayout = new LinearLayout(getContext(), null,
                com.android.internal.R.attr.actionBarTabBarStyle);
        tabLayout.setMeasureWithLargestChildEnabled(true);
        tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        varB4EAC82CA7396A68D541C85D26508E83_870601396 = tabLayout;
        varB4EAC82CA7396A68D541C85D26508E83_870601396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_870601396;
        // ---------- Original Method ----------
        //final LinearLayout tabLayout = new LinearLayout(getContext(), null,
                //com.android.internal.R.attr.actionBarTabBarStyle);
        //tabLayout.setMeasureWithLargestChildEnabled(true);
        //tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                //LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //return tabLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.638 -0400", hash_original_method = "37274689DF291E70B964F7E850308591", hash_generated_method = "DCCCB3245560B0CF54E1BEC81F11C4F2")
    private Spinner createSpinner() {
        Spinner varB4EAC82CA7396A68D541C85D26508E83_1933027525 = null; //Variable for return #1
        Spinner spinner;
        spinner = new Spinner(getContext(), null,
                com.android.internal.R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        spinner.setOnItemSelectedListener(this);
        varB4EAC82CA7396A68D541C85D26508E83_1933027525 = spinner;
        varB4EAC82CA7396A68D541C85D26508E83_1933027525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1933027525;
        // ---------- Original Method ----------
        //final Spinner spinner = new Spinner(getContext(), null,
                //com.android.internal.R.attr.actionDropDownStyle);
        //spinner.setLayoutParams(new LinearLayout.LayoutParams(
                //LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //spinner.setOnItemSelectedListener(this);
        //return spinner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.638 -0400", hash_original_method = "DD246DFC5FD99F8FA7C3003D550B61F7", hash_generated_method = "B5B8C2ECAC9033321713EB5559EA3D52")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onConfigurationChanged(newConfig);
        TypedArray a;
        a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                com.android.internal.R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
                //com.android.internal.R.attr.actionBarStyle, 0);
        //setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.639 -0400", hash_original_method = "69157A480990C0D905A38CA00057780E", hash_generated_method = "F843436F3A0E0E0B58FFC472EAFEEF3B")
    public void animateToVisibility(int visibility) {
        {
            mVisibilityAnim.cancel();
        } //End block
        {
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_885127853 = (getVisibility() != VISIBLE);
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
        addTaint(visibility);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.651 -0400", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "6225E34BF7DFAAF6FFE26B6E4AE4A84D")
    public void animateToTab(final int position) {
        View tabView;
        tabView = mTabLayout.getChildAt(position);
        {
            removeCallbacks(mTabSelector);
        } //End block
        mTabSelector = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.650 -0400", hash_original_method = "624465A8A4FF7840574C164453105D67", hash_generated_method = "C126B8E44776A06A3D35D4B101D43300")
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
        addTaint(position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.651 -0400", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "9F62CB462C72183B08CFCFC02D001D3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.651 -0400", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "D72DCDA1DCA4C064AC6156264DCE07BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.661 -0400", hash_original_method = "450EFC0E420D351EC7204D6D5C8D9AC6", hash_generated_method = "56DEEFCCDD2B593570DEFD2E41E0483E")
    private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        TabView varB4EAC82CA7396A68D541C85D26508E83_1570402246 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1570402246 = tabView;
        addTaint(tab.getTaint());
        addTaint(forAdapter);
        varB4EAC82CA7396A68D541C85D26508E83_1570402246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1570402246;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.663 -0400", hash_original_method = "21975DD541C9968A5D84261D431559E1", hash_generated_method = "41A3FD7AB4D9A0609F7F75E090482A8D")
    public void addTab(ActionBar.Tab tab, boolean setSelected) {
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
        addTaint(tab.getTaint());
        addTaint(setSelected);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.663 -0400", hash_original_method = "120AD652FAF12AEC39493BA97DDC8DBA", hash_generated_method = "4E82F553A34B738FB8FC77942A3C6218")
    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
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
        addTaint(tab.getTaint());
        addTaint(position);
        addTaint(setSelected);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.664 -0400", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "ACCE0DC04173D004849236FA059E1059")
    public void updateTab(int position) {
        ((TabView) mTabLayout.getChildAt(position)).update();
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            requestLayout();
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        //((TabView) mTabLayout.getChildAt(position)).update();
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.664 -0400", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "B20B400CB3EFEDBF7C771240FBE94E04")
    public void removeTabAt(int position) {
        mTabLayout.removeViewAt(position);
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        {
            requestLayout();
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        //mTabLayout.removeViewAt(position);
        //if (mTabSpinner != null) {
            //((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        //}
        //if (mAllowCollapse) {
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.696 -0400", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "3FCAFF75B22CA75D6BD43E12E090EA5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.696 -0400", hash_original_method = "1E807444FE245168D5D160AA45CB2236", hash_generated_method = "2E2026476EB426603A1D212192F0CB58")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        TabView tabView;
        tabView = (TabView) view;
        tabView.getTab().select();
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
        //TabView tabView = (TabView) view;
        //tabView.getTab().select();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.696 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "62984736880CAC76A8EB431CC994B1B9")
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    private class TabView extends LinearLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.697 -0400", hash_original_field = "0420CD3815919DD8AB260E6D64B3A15D", hash_generated_field = "3557E0B9D4809295D85BAFD572E62004")

        private ActionBar.Tab mTab;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.697 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.697 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.697 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.697 -0400", hash_original_method = "B5DB6118A5A739AD937742D1C44B643E", hash_generated_method = "CB9E80A8C3936ACB49750D293196188A")
        public  TabView(Context context, ActionBar.Tab tab, boolean forList) {
            super(context, null, com.android.internal.R.attr.actionBarTabStyle);
            mTab = tab;
            {
                setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            } //End block
            update();
            addTaint(context.getTaint());
            addTaint(forList);
            // ---------- Original Method ----------
            //mTab = tab;
            //if (forList) {
                //setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            //}
            //update();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.697 -0400", hash_original_method = "F47DC88329E05996F10046ACC14BB8E5", hash_generated_method = "0C984A7EAC8ED88CF651B5BA283C8A73")
        public void bindTab(ActionBar.Tab tab) {
            mTab = tab;
            update();
            // ---------- Original Method ----------
            //mTab = tab;
            //update();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.705 -0400", hash_original_method = "FFA211085DE297C0E0EC5011B4DE8B57", hash_generated_method = "BABB0ED3F1D74C416E8A31CEB56AB8A3")
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            {
                boolean var324CF3D70AA77B616B77CDF8D6A963D0_539653661 = (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth);
                {
                    super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        heightMeasureSpec);
                } //End block
            } //End collapsed parenthetic
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
            // ---------- Original Method ----------
            //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            //if (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth) {
                //super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        //heightMeasureSpec);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.706 -0400", hash_original_method = "0AA8F20782F60FCDEB51E2F40EEE8538", hash_generated_method = "0BA87D7F68C2A385114A2ADA966231AB")
        public void update() {
            ActionBar.Tab tab;
            tab = mTab;
            View custom;
            custom = tab.getCustomView();
            {
                ViewParent customParent;
                customParent = custom.getParent();
                {
                    boolean varA92912C2F8F3D980AAEE4A18A937AA8F_991212524 = (customParent != this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.707 -0400", hash_original_method = "8ACD8C7DACBB258E07DA374214A46BC1", hash_generated_method = "3F37654AF727788BC207E1DF369D2116")
        public ActionBar.Tab getTab() {
            ActionBar.Tab varB4EAC82CA7396A68D541C85D26508E83_750741138 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_750741138 = mTab;
            varB4EAC82CA7396A68D541C85D26508E83_750741138.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_750741138;
            // ---------- Original Method ----------
            //return mTab;
        }

        
    }


    
    private class TabAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.707 -0400", hash_original_method = "D47CBC6CCDC74B210F03E0CA569B23D5", hash_generated_method = "D47CBC6CCDC74B210F03E0CA569B23D5")
        public TabAdapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.708 -0400", hash_original_method = "8A8A2A6470BE340ED0660B0DF0493034", hash_generated_method = "9B03CB2B5987E2446BF8290E5F27B22C")
        @Override
        public int getCount() {
            int var05B9487F20C1BA2A8719F1ECE24F801B_1628500478 = (mTabLayout.getChildCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58950059 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58950059;
            // ---------- Original Method ----------
            //return mTabLayout.getChildCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.708 -0400", hash_original_method = "A98679EF5D46D1EF9814D015704A8113", hash_generated_method = "C371CCAF51A1A794CE0A60F1129E7D87")
        @Override
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_140000570 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_140000570 = ((TabView) mTabLayout.getChildAt(position)).getTab();
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_140000570.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_140000570;
            // ---------- Original Method ----------
            //return ((TabView) mTabLayout.getChildAt(position)).getTab();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.715 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "8A26C4A14F5CB56C0B62045FC9FD644E")
        @Override
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_832341244 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_832341244;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.727 -0400", hash_original_method = "C541E21433CF0B8E7E2EE0D1C892D4E4", hash_generated_method = "788EB85F3784980E8F1C2AE1C5605837")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_281577220 = null; //Variable for return #1
            {
                convertView = createTabView((ActionBar.Tab) getItem(position), true);
            } //End block
            {
                ((TabView) convertView).bindTab((ActionBar.Tab) getItem(position));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_281577220 = convertView;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_281577220.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_281577220;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.727 -0400", hash_original_method = "4AA29A9A1E8E979F0176DF66C5E11348", hash_generated_method = "4AA29A9A1E8E979F0176DF66C5E11348")
        public TabClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.730 -0400", hash_original_method = "024B6ED45DE6B4C8643F8BD12AD99CDA", hash_generated_method = "93AC56A1FA7C447AF8659F86CC023EB4")
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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
            addTaint(view.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.730 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.730 -0400", hash_original_field = "270EA634CE9CE51A331284B9E8EB3832", hash_generated_field = "5617DA9FA1009CD83DDE5A46F5134947")

        private int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.730 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.731 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "AA9E54B3B00FD39C7E91AEA199E6A903")
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            VisibilityAnimListener varB4EAC82CA7396A68D541C85D26508E83_2073273167 = null; //Variable for return #1
            mFinalVisibility = visibility;
            varB4EAC82CA7396A68D541C85D26508E83_2073273167 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2073273167.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2073273167;
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.731 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "B818DF791669294EDB0F112B9A238DEF")
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //setVisibility(VISIBLE);
            //mVisibilityAnim = animation;
            //mCanceled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.731 -0400", hash_original_method = "FCD0A8E872EDB46A2BFC14B31FFA43CC", hash_generated_method = "7CA14196F462C97CAADC5EADB176F36A")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mCanceled) return;
            //mVisibilityAnim = null;
            //setVisibility(mFinalVisibility);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.738 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "66692DF1E254D3C3C92CC85749BF5C5B")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mCanceled = true;
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.738 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.738 -0400", hash_original_field = "CFF7D9C1D149B4BB31A82847457DB850", hash_generated_field = "56197CC5D90A318DE1AE0590DE9E2B73")

    private static String TAG = "ScrollingTabContainerView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.738 -0400", hash_original_field = "58EA75425C7F0D76C382950FFD0E66A6", hash_generated_field = "D71EB9420CF1988E2188358BCB875B45")

    private static TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.738 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "446F7CFF1903ECC636263E98AB446B41")

    private static int FADE_DURATION = 200;
}

