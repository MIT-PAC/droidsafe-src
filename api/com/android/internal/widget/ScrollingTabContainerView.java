package com.android.internal.widget;

// Droidsafe Imports
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

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "85B61EC738F2056493BB5A07F48F6CE2", hash_generated_field = "E682310941753B94BE1FECAC9286C6E9")

    Runnable mTabSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "7B7BE9A380D80EE64647F123DDF5EE4B", hash_generated_field = "9D65B8DF4295D2997A201C87527D1868")

    private TabClickListener mTabClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "AE6F3073108E075D4F8197E16CD03BFE", hash_generated_field = "E5144854D9186C0CFBAD4E1FE3ACCBAF")

    private LinearLayout mTabLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "19323BA77D1B90D50BDC8C305F409012", hash_generated_field = "992DC55613E9C96C70980F7C6305042C")

    private Spinner mTabSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "1A82A7735BB27C6FDFFDF44101DF2FC1", hash_generated_field = "F02107E932C3D4F526DFB20B4DC44818")

    private boolean mAllowCollapse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "853B3497BE9CA3D38FD649114DCE0E75", hash_generated_field = "2536FBAA8D2459579C241F8EA3302AA1")

    int mMaxTabWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "DD984F5B26439BEE2E88B28167086754", hash_generated_field = "5FAA7FEF18B6FA6D1EC21FF900B235B4")

    private int mSelectedTabIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "1CF5159AB7BA0B608B8FD842C6C652D4", hash_generated_field = "9B230B482D363407A6E2031086F40952")

    protected Animator mVisibilityAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.197 -0400", hash_original_field = "27A07A2C9917014FCD8B9D90F05A92EC", hash_generated_field = "2572558D73FCEA5CB5F54CEC528FD58F")

    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.198 -0400", hash_original_method = "B354C67837F2A6192494F63E2EFB003B", hash_generated_method = "174B0B2047363D65F93E94B4782795A2")
    public  ScrollingTabContainerView(Context context) {
        super(context);
        addTaint(context.getTaint());
        setHorizontalScrollBarEnabled(false);
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.199 -0400", hash_original_method = "3098621744ABB84E77F43010FB80D748", hash_generated_method = "48D5566EBD5655AD9C851CC6959E879C")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final boolean lockedExpanded = widthMode == MeasureSpec.EXACTLY;
        setFillViewport(lockedExpanded);
        final int childCount = mTabLayout.getChildCount();
        if(childCount > 1 &&
                (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST))        
        {
            if(childCount > 2)            
            {
                mMaxTabWidth = (int) (MeasureSpec.getSize(widthMeasureSpec) * 0.4f);
            } //End block
            else
            {
                mMaxTabWidth = MeasureSpec.getSize(widthMeasureSpec) / 2;
            } //End block
        } //End block
        else
        {
            mMaxTabWidth = -1;
        } //End block
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mContentHeight, MeasureSpec.EXACTLY);
        final boolean canCollapse = !lockedExpanded && mAllowCollapse;
        if(canCollapse)        
        {
            mTabLayout.measure(MeasureSpec.UNSPECIFIED, heightMeasureSpec);
            if(mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec))            
            {
                performCollapse();
            } //End block
            else
            {
                performExpand();
            } //End block
        } //End block
        else
        {
            performExpand();
        } //End block
        final int oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int newWidth = getMeasuredWidth();
        if(lockedExpanded && oldWidth != newWidth)        
        {
            setTabSelected(mSelectedTabIndex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.201 -0400", hash_original_method = "0C44DD211AEDE4F8875A759BF8E8E48B", hash_generated_method = "82FFEC8A97A4F3906C1553CD22366C3E")
    private boolean isCollapsed() {
        boolean var76D4844CC4C69129F4F1CDCDA535CE01_114465538 = (mTabSpinner != null && mTabSpinner.getParent() == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_967070675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_967070675;
        // ---------- Original Method ----------
        //return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.202 -0400", hash_original_method = "E654067D8A391E646F927D11468DA221", hash_generated_method = "3CC7274A44B95F0704BA216FDB666531")
    public void setAllowCollapse(boolean allowCollapse) {
        mAllowCollapse = allowCollapse;
        // ---------- Original Method ----------
        //mAllowCollapse = allowCollapse;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.204 -0400", hash_original_method = "002FC4053C0D51D3D52C5463A6463800", hash_generated_method = "8729588479AA3052EE66BEFD5C4BA58F")
    private void performCollapse() {
        if(isCollapsed())        
        return;
        if(mTabSpinner == null)        
        {
            mTabSpinner = createSpinner();
        } //End block
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        if(mTabSpinner.getAdapter() == null)        
        {
            mTabSpinner.setAdapter(new TabAdapter());
        } //End block
        if(mTabSelector != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.205 -0400", hash_original_method = "DC1833D7C81A29FFDE1BB4D9BF0A022D", hash_generated_method = "BAA43726A712C8397ECCEFF5BC457AB2")
    private boolean performExpand() {
        if(!isCollapsed())        
        {
        boolean var68934A3E9455FA72420237EB05902327_6802089 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840905619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840905619;
        }
        removeView(mTabSpinner);
        addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setTabSelected(mTabSpinner.getSelectedItemPosition());
        boolean var68934A3E9455FA72420237EB05902327_228116022 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572988641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572988641;
        // ---------- Original Method ----------
        //if (!isCollapsed()) return false;
        //removeView(mTabSpinner);
        //addView(mTabLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.MATCH_PARENT));
        //setTabSelected(mTabSpinner.getSelectedItemPosition());
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.207 -0400", hash_original_method = "2880D1017429231FB4C783DE8155FB40", hash_generated_method = "2DB326893015A2A947F353A2E4B62E19")
    public void setTabSelected(int position) {
        mSelectedTabIndex = position;
        final int tabCount = mTabLayout.getChildCount();
for(int i = 0;i < tabCount;i++)
        {
            final View child = mTabLayout.getChildAt(i);
            final boolean isSelected = i == position;
            child.setSelected(isSelected);
            if(isSelected)            
            {
                animateToTab(position);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.208 -0400", hash_original_method = "2D264BA3FDE4BFC89C0D29CEF35AB5AF", hash_generated_method = "26F2E91F17A5314422F78CA7BBBD3619")
    public void setContentHeight(int contentHeight) {
        mContentHeight = contentHeight;
        requestLayout();
        // ---------- Original Method ----------
        //mContentHeight = contentHeight;
        //requestLayout();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.210 -0400", hash_original_method = "5C02AED63A2A4EB9B288612999968966", hash_generated_method = "FFED6F9104DBAEB69D2C19042883B9B4")
    private LinearLayout createTabLayout() {
        final LinearLayout tabLayout = new LinearLayout(getContext(), null,
                com.android.internal.R.attr.actionBarTabBarStyle);
        tabLayout.setMeasureWithLargestChildEnabled(true);
        tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
LinearLayout var696580C41E2E1D1E00E87A5731979420_1358646539 =         tabLayout;
        var696580C41E2E1D1E00E87A5731979420_1358646539.addTaint(taint);
        return var696580C41E2E1D1E00E87A5731979420_1358646539;
        // ---------- Original Method ----------
        //final LinearLayout tabLayout = new LinearLayout(getContext(), null,
                //com.android.internal.R.attr.actionBarTabBarStyle);
        //tabLayout.setMeasureWithLargestChildEnabled(true);
        //tabLayout.setLayoutParams(new LinearLayout.LayoutParams(
                //LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //return tabLayout;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.211 -0400", hash_original_method = "37274689DF291E70B964F7E850308591", hash_generated_method = "10308988377C747061D48ADB1C15A2D6")
    private Spinner createSpinner() {
        final Spinner spinner = new Spinner(getContext(), null,
                com.android.internal.R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        spinner.setOnItemSelectedListener(this);
Spinner var2854793BD8388CA4EEEEFC36B3E6FEC7_1482698738 =         spinner;
        var2854793BD8388CA4EEEEFC36B3E6FEC7_1482698738.addTaint(taint);
        return var2854793BD8388CA4EEEEFC36B3E6FEC7_1482698738;
        // ---------- Original Method ----------
        //final Spinner spinner = new Spinner(getContext(), null,
                //com.android.internal.R.attr.actionDropDownStyle);
        //spinner.setLayoutParams(new LinearLayout.LayoutParams(
                //LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //spinner.setOnItemSelectedListener(this);
        //return spinner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.211 -0400", hash_original_method = "DD246DFC5FD99F8FA7C3003D550B61F7", hash_generated_method = "F7DEA7DCC5DE05423EA8EB7E14EFAE9F")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.212 -0400", hash_original_method = "69157A480990C0D905A38CA00057780E", hash_generated_method = "A67A64D4843614424F8A1BCA304A5C7B")
    public void animateToVisibility(int visibility) {
        addTaint(visibility);
        if(mVisibilityAnim != null)        
        {
            mVisibilityAnim.cancel();
        } //End block
        if(visibility == VISIBLE)        
        {
            if(getVisibility() != VISIBLE)            
            {
                setAlpha(0);
            } //End block
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 1);
            anim.setDuration(FADE_DURATION);
            anim.setInterpolator(sAlphaInterpolator);
            anim.addListener(mVisAnimListener.withFinalVisibility(visibility));
            anim.start();
        } //End block
        else
        {
            ObjectAnimator anim = ObjectAnimator.ofFloat(this, "alpha", 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.213 -0400", hash_original_method = "798975849EC8D4C022ED8EB3C4439FA8", hash_generated_method = "788DDC324B2DA589FD7D4E9115B42706")
    public void animateToTab(final int position) {
        addTaint(position);
        final View tabView = mTabLayout.getChildAt(position);
        if(mTabSelector != null)        
        {
            removeCallbacks(mTabSelector);
        } //End block
        mTabSelector = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.213 -0400", hash_original_method = "624465A8A4FF7840574C164453105D67", hash_generated_method = "7302E1286720D09F48E93DAD199B6162")
        public void run() {
            final int scrollPos = tabView.getLeft() - (getWidth() - tabView.getWidth()) / 2;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.213 -0400", hash_original_method = "887CFA274A392DE8385671362C9964CB", hash_generated_method = "4870A0AD27208DC28880E7226D22BA0B")
    @Override
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        if(mTabSelector != null)        
        {
            post(mTabSelector);
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mTabSelector != null) {
            //post(mTabSelector);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.214 -0400", hash_original_method = "18C292ABA374873141A21AD02D4712CF", hash_generated_method = "6F9B351DAAD82762AA79AA47F94E4907")
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        if(mTabSelector != null)        
        {
            removeCallbacks(mTabSelector);
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mTabSelector != null) {
            //removeCallbacks(mTabSelector);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.214 -0400", hash_original_method = "450EFC0E420D351EC7204D6D5C8D9AC6", hash_generated_method = "4D867E334C1AFE93784FF348737720B3")
    private TabView createTabView(ActionBar.Tab tab, boolean forAdapter) {
        addTaint(forAdapter);
        addTaint(tab.getTaint());
        final TabView tabView = new TabView(getContext(), tab, forAdapter);
        if(forAdapter)        
        {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,
                    mContentHeight));
        } //End block
        else
        {
            tabView.setFocusable(true);
            if(mTabClickListener == null)            
            {
                mTabClickListener = new TabClickListener();
            } //End block
            tabView.setOnClickListener(mTabClickListener);
        } //End block
TabView var3D62EBAA544A23B03589BCB47B1A928C_87944170 =         tabView;
        var3D62EBAA544A23B03589BCB47B1A928C_87944170.addTaint(taint);
        return var3D62EBAA544A23B03589BCB47B1A928C_87944170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.215 -0400", hash_original_method = "21975DD541C9968A5D84261D431559E1", hash_generated_method = "30EEE35EF114E7152605CAC3A63B5400")
    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        addTaint(setSelected);
        addTaint(tab.getTaint());
        TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0,
                LayoutParams.MATCH_PARENT, 1));
        if(mTabSpinner != null)        
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        if(setSelected)        
        {
            tabView.setSelected(true);
        } //End block
        if(mAllowCollapse)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.216 -0400", hash_original_method = "120AD652FAF12AEC39493BA97DDC8DBA", hash_generated_method = "E9E0AB28327F2FA7B685FAD67E254F46")
    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        addTaint(setSelected);
        addTaint(position);
        addTaint(tab.getTaint());
        final TabView tabView = createTabView(tab, false);
        mTabLayout.addView(tabView, position, new LinearLayout.LayoutParams(
                0, LayoutParams.MATCH_PARENT, 1));
        if(mTabSpinner != null)        
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        if(setSelected)        
        {
            tabView.setSelected(true);
        } //End block
        if(mAllowCollapse)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.216 -0400", hash_original_method = "AB4E22DBFABD54435D3DD6BE48A7A755", hash_generated_method = "4784CE427F3B3E3FD07B9132081F1688")
    public void updateTab(int position) {
        addTaint(position);
        ((TabView) mTabLayout.getChildAt(position)).update();
        if(mTabSpinner != null)        
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        if(mAllowCollapse)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.217 -0400", hash_original_method = "F55D08535CE5AE8E892CFC88E40F0277", hash_generated_method = "1D4135D665D44A162F1AABBC0C4F6198")
    public void removeTabAt(int position) {
        addTaint(position);
        mTabLayout.removeViewAt(position);
        if(mTabSpinner != null)        
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        if(mAllowCollapse)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.218 -0400", hash_original_method = "505192EE2E755E624302670BB829212B", hash_generated_method = "FC735DC9B08CDD683C98638D8C90A820")
    public void removeAllTabs() {
        mTabLayout.removeAllViews();
        if(mTabSpinner != null)        
        {
            ((TabAdapter) mTabSpinner.getAdapter()).notifyDataSetChanged();
        } //End block
        if(mAllowCollapse)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.218 -0400", hash_original_method = "1E807444FE245168D5D160AA45CB2236", hash_generated_method = "9779246FC5A66267DE3957B61AD31C11")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
        TabView tabView = (TabView) view;
        tabView.getTab().select();
        // ---------- Original Method ----------
        //TabView tabView = (TabView) view;
        //tabView.getTab().select();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.219 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "62984736880CAC76A8EB431CC994B1B9")
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    private class TabView extends LinearLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.219 -0400", hash_original_field = "0420CD3815919DD8AB260E6D64B3A15D", hash_generated_field = "3557E0B9D4809295D85BAFD572E62004")

        private ActionBar.Tab mTab;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.219 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.219 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

        private ImageView mIconView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.219 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

        private View mCustomView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.220 -0400", hash_original_method = "B5DB6118A5A739AD937742D1C44B643E", hash_generated_method = "8D2B0C46504124F08E8CF6BA7077B680")
        public  TabView(Context context, ActionBar.Tab tab, boolean forList) {
            super(context, null, com.android.internal.R.attr.actionBarTabStyle);
            addTaint(forList);
            addTaint(context.getTaint());
            mTab = tab;
            if(forList)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.220 -0400", hash_original_method = "F47DC88329E05996F10046ACC14BB8E5", hash_generated_method = "0C984A7EAC8ED88CF651B5BA283C8A73")
        public void bindTab(ActionBar.Tab tab) {
            mTab = tab;
            update();
            // ---------- Original Method ----------
            //mTab = tab;
            //update();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.221 -0400", hash_original_method = "FFA211085DE297C0E0EC5011B4DE8B57", hash_generated_method = "1575432F06A2685F4AEF33E5862A5FAA")
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(heightMeasureSpec);
            addTaint(widthMeasureSpec);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if(mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth)            
            {
                super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        heightMeasureSpec);
            } //End block
            // ---------- Original Method ----------
            //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            //if (mMaxTabWidth > 0 && getMeasuredWidth() > mMaxTabWidth) {
                //super.onMeasure(MeasureSpec.makeMeasureSpec(mMaxTabWidth, MeasureSpec.EXACTLY),
                        //heightMeasureSpec);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.222 -0400", hash_original_method = "0AA8F20782F60FCDEB51E2F40EEE8538", hash_generated_method = "2327D6DEEE1CD8D3596AF283109C89A4")
        public void update() {
            final ActionBar.Tab tab = mTab;
            final View custom = tab.getCustomView();
            if(custom != null)            
            {
                final ViewParent customParent = custom.getParent();
                if(customParent != this)                
                {
                    if(customParent != null)                    
                    ((ViewGroup) customParent).removeView(custom);
                    addView(custom);
                } //End block
                mCustomView = custom;
                if(mTextView != null)                
                mTextView.setVisibility(GONE);
                if(mIconView != null)                
                {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                } //End block
            } //End block
            else
            {
                if(mCustomView != null)                
                {
                    removeView(mCustomView);
                    mCustomView = null;
                } //End block
                final Drawable icon = tab.getIcon();
                final CharSequence text = tab.getText();
                if(icon != null)                
                {
                    if(mIconView == null)                    
                    {
                        ImageView iconView = new ImageView(getContext());
                        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        lp.gravity = Gravity.CENTER_VERTICAL;
                        iconView.setLayoutParams(lp);
                        addView(iconView, 0);
                        mIconView = iconView;
                    } //End block
                    mIconView.setImageDrawable(icon);
                    mIconView.setVisibility(VISIBLE);
                } //End block
                else
                if(mIconView != null)                
                {
                    mIconView.setVisibility(GONE);
                    mIconView.setImageDrawable(null);
                } //End block
                if(text != null)                
                {
                    if(mTextView == null)                    
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
                    } //End block
                    mTextView.setText(text);
                    mTextView.setVisibility(VISIBLE);
                } //End block
                else
                if(mTextView != null)                
                {
                    mTextView.setVisibility(GONE);
                    mTextView.setText(null);
                } //End block
                if(mIconView != null)                
                {
                    mIconView.setContentDescription(tab.getContentDescription());
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "8ACD8C7DACBB258E07DA374214A46BC1", hash_generated_method = "01D9359675E33FC1F1FFFE35A52C0B56")
        public ActionBar.Tab getTab() {
ActionBar.Tab var2863D7221C8303E9575E533B393C6A71_1007535098 =             mTab;
            var2863D7221C8303E9575E533B393C6A71_1007535098.addTaint(taint);
            return var2863D7221C8303E9575E533B393C6A71_1007535098;
            // ---------- Original Method ----------
            //return mTab;
        }

        
    }


    
    private class TabAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "D47CBC6CCDC74B210F03E0CA569B23D5", hash_generated_method = "D47CBC6CCDC74B210F03E0CA569B23D5")
        public TabAdapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "8A8A2A6470BE340ED0660B0DF0493034", hash_generated_method = "7CA0B2F8DFBAB5757B1A91C2640D21A4")
        @Override
        public int getCount() {
            int var2438AF16E60CE2C4D8064387150CE17E_1422614292 = (mTabLayout.getChildCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620025177 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620025177;
            // ---------- Original Method ----------
            //return mTabLayout.getChildCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "A98679EF5D46D1EF9814D015704A8113", hash_generated_method = "CACE27B9036ED6BC13E1BA6D94BBA715")
        @Override
        public Object getItem(int position) {
            addTaint(position);
Object varF69A319077C91E2F587183FB5AB81B22_1415470376 =             ((TabView) mTabLayout.getChildAt(position)).getTab();
            varF69A319077C91E2F587183FB5AB81B22_1415470376.addTaint(taint);
            return varF69A319077C91E2F587183FB5AB81B22_1415470376;
            // ---------- Original Method ----------
            //return ((TabView) mTabLayout.getChildAt(position)).getTab();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "B5DCFA4B64290FDA4004A844DC631525")
        @Override
        public long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_1613505883 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1027053090 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1027053090;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "C541E21433CF0B8E7E2EE0D1C892D4E4", hash_generated_method = "BB36EE4537CE76E468F34CA60F3AA71D")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            if(convertView == null)            
            {
                convertView = createTabView((ActionBar.Tab) getItem(position), true);
            } //End block
            else
            {
                ((TabView) convertView).bindTab((ActionBar.Tab) getItem(position));
            } //End block
View var78FE9B874BBEC69B62B43EE963245978_691858909 =             convertView;
            var78FE9B874BBEC69B62B43EE963245978_691858909.addTaint(taint);
            return var78FE9B874BBEC69B62B43EE963245978_691858909;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.223 -0400", hash_original_method = "4AA29A9A1E8E979F0176DF66C5E11348", hash_generated_method = "4AA29A9A1E8E979F0176DF66C5E11348")
        public TabClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.224 -0400", hash_original_method = "024B6ED45DE6B4C8643F8BD12AD99CDA", hash_generated_method = "D67179FD0F0ACCCFACD8524687C99C82")
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            TabView tabView = (TabView) view;
            tabView.getTab().select();
            final int tabCount = mTabLayout.getChildCount();
for(int i = 0;i < tabCount;i++)
            {
                final View child = mTabLayout.getChildAt(i);
                child.setSelected(child == view);
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.224 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

        private boolean mCanceled = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.224 -0400", hash_original_field = "270EA634CE9CE51A331284B9E8EB3832", hash_generated_field = "5617DA9FA1009CD83DDE5A46F5134947")

        private int mFinalVisibility;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.224 -0400", hash_original_method = "80D34182BA082FA1C0AC7FE2CE12E2A6", hash_generated_method = "80D34182BA082FA1C0AC7FE2CE12E2A6")
        public VisibilityAnimListener ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.224 -0400", hash_original_method = "42B0250930D53F64D6DEADC73C3EFBBA", hash_generated_method = "7BED256607BD38161C426E61DC5D248D")
        public VisibilityAnimListener withFinalVisibility(int visibility) {
            mFinalVisibility = visibility;
VisibilityAnimListener var72A74007B2BE62B849F475C7BDA4658B_782914034 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_782914034.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_782914034;
            // ---------- Original Method ----------
            //mFinalVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.225 -0400", hash_original_method = "9145E12DF11688F9DD8CB4C23A0F2F13", hash_generated_method = "43A419CBA987813FF6A97459EB9F4822")
        @Override
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            setVisibility(VISIBLE);
            mVisibilityAnim = animation;
            mCanceled = false;
            // ---------- Original Method ----------
            //setVisibility(VISIBLE);
            //mVisibilityAnim = animation;
            //mCanceled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.226 -0400", hash_original_method = "FCD0A8E872EDB46A2BFC14B31FFA43CC", hash_generated_method = "C73DC9668778EC41E6A37E2B557B70D1")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            if(mCanceled)            
            return;
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            // ---------- Original Method ----------
            //if (mCanceled) return;
            //mVisibilityAnim = null;
            //setVisibility(mFinalVisibility);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.227 -0400", hash_original_method = "2F84891C5ED8AB616225A7D641700DEA", hash_generated_method = "8F11757114E12F8DD42F47845FC47878")
        @Override
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            mCanceled = true;
            // ---------- Original Method ----------
            //mCanceled = true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.228 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "4BE2C3EAC3B10B8BD5CE86F0E3077935")
        @Override
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.228 -0400", hash_original_field = "CFF7D9C1D149B4BB31A82847457DB850", hash_generated_field = "8198E33AEA6A4E67CF498CFCEDA7ACFC")

    private static final String TAG = "ScrollingTabContainerView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.228 -0400", hash_original_field = "58EA75425C7F0D76C382950FFD0E66A6", hash_generated_field = "8547110952636D9B94C38943E41DDC94")

    private static final TimeInterpolator sAlphaInterpolator = new DecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.228 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "2297CD97C5AD861EDC516998785F45D4")

    private static final int FADE_DURATION = 200;
}

