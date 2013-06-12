package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    private boolean mIsTransitioning;
    private View mTabContainer;
    private ActionBarView mActionBarView;
    private Drawable mBackground;
    private Drawable mStackedBackground;
    private Drawable mSplitBackground;
    private boolean mIsSplit;
    private boolean mIsStacked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.137 -0400", hash_original_method = "11ADB8FB86182A3641DB27767A9D337F", hash_generated_method = "1076A5BF1A4E376493376B1D48D2F171")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContainer(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "63748832C1944A3823B0F9894E29E249", hash_generated_method = "FEE7C498634F2D03B381991C6A3D4DBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        setBackgroundDrawable(null);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ActionBar);
        mBackground = a.getDrawable(com.android.internal.R.styleable.ActionBar_background);
        mStackedBackground = a.getDrawable(
                com.android.internal.R.styleable.ActionBar_backgroundStacked);
        {
            boolean var80495DEA47A1645C948067B6ECEF8EB9_1849653430 = (getId() == com.android.internal.R.id.split_action_bar);
            {
                mIsSplit = true;
                mSplitBackground = a.getDrawable(
                    com.android.internal.R.styleable.ActionBar_backgroundSplit);
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
        // ---------- Original Method ----------
        //setBackgroundDrawable(null);
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.ActionBar);
        //mBackground = a.getDrawable(com.android.internal.R.styleable.ActionBar_background);
        //mStackedBackground = a.getDrawable(
                //com.android.internal.R.styleable.ActionBar_backgroundStacked);
        //if (getId() == com.android.internal.R.id.split_action_bar) {
            //mIsSplit = true;
            //mSplitBackground = a.getDrawable(
                    //com.android.internal.R.styleable.ActionBar_backgroundSplit);
        //}
        //a.recycle();
        //setWillNotDraw(mIsSplit ? mSplitBackground == null :
                //mBackground == null && mStackedBackground == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "69B88AD6BEB0BE6EF5F88037F33C1F3D", hash_generated_method = "BE9CDD6D99E1C293C9263A77F5EFA39F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "78385A861A7FDA3897557FA33D96C5EA", hash_generated_method = "E045FE6AF0EE073B13ADA32F9DF4393C")
    @DSModeled(DSC.SAFE)
    public void setPrimaryBackground(Drawable bg) {
        dsTaint.addTaint(bg.dsTaint);
        invalidate();
        // ---------- Original Method ----------
        //mBackground = bg;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "D9D97A9D1A3797ABD6FF2A72BC0DD994", hash_generated_method = "981E3DA2258DF523811435CACFEE0A7B")
    @DSModeled(DSC.SAFE)
    public void setStackedBackground(Drawable bg) {
        dsTaint.addTaint(bg.dsTaint);
        invalidate();
        // ---------- Original Method ----------
        //mStackedBackground = bg;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "EE7203C1470FAC3396749865559F7B8E", hash_generated_method = "3C91F7A8FA5C9DE199D8C807D3F8F90B")
    @DSModeled(DSC.SAFE)
    public void setSplitBackground(Drawable bg) {
        dsTaint.addTaint(bg.dsTaint);
        invalidate();
        // ---------- Original Method ----------
        //mSplitBackground = bg;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "B47E345D6B402EE0E60D9E3F40581018", hash_generated_method = "5DCA96135A420415E480236246572915")
    @DSModeled(DSC.SAFE)
    public void setTransitioning(boolean isTransitioning) {
        dsTaint.addTaint(isTransitioning);
        setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                : FOCUS_AFTER_DESCENDANTS);
        // ---------- Original Method ----------
        //mIsTransitioning = isTransitioning;
        //setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                //: FOCUS_AFTER_DESCENDANTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "8E69245395EC81C98ED35F3490421A0A", hash_generated_method = "2669AE1E6C318C643102107B53E80297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        boolean varCB64BEE5318C9BB9804B010A90A93A20_1061255149 = (mIsTransitioning || super.onInterceptTouchEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsTransitioning || super.onInterceptTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "FA8EB54F33D4C310829625567514278C", hash_generated_method = "F49D5567E20432FD6AAD764849539532")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        super.onTouchEvent(ev);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //super.onTouchEvent(ev);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "9A976B5E6EF3A94656A0B6DD07EE34B7", hash_generated_method = "B414B1F4A74DC41FC2E446380F080BF2")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onHoverEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        super.onHoverEvent(ev);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //super.onHoverEvent(ev);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "56F3757B297FC41285B5D7002065B92C", hash_generated_method = "1E2416C82353D906F1BF2DF72490AA81")
    @DSModeled(DSC.SAFE)
    public void setTabContainer(ScrollingTabContainerView tabView) {
        dsTaint.addTaint(tabView.dsTaint);
        {
            removeView(mTabContainer);
        } //End block
        {
            addView(tabView);
            final ViewGroup.LayoutParams lp;
            lp = tabView.getLayoutParams();
            lp.width = LayoutParams.MATCH_PARENT;
            lp.height = LayoutParams.WRAP_CONTENT;
            tabView.setAllowCollapse(false);
        } //End block
        // ---------- Original Method ----------
        //if (mTabContainer != null) {
            //removeView(mTabContainer);
        //}
        //mTabContainer = tabView;
        //if (tabView != null) {
            //addView(tabView);
            //final ViewGroup.LayoutParams lp = tabView.getLayoutParams();
            //lp.width = LayoutParams.MATCH_PARENT;
            //lp.height = LayoutParams.WRAP_CONTENT;
            //tabView.setAllowCollapse(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.138 -0400", hash_original_method = "1563ACF140881C9576C37880F51665C0", hash_generated_method = "0F8F3F492B27CFE73A3F8D9CF77F0DEF")
    @DSModeled(DSC.SAFE)
    public View getTabContainer() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTabContainer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.139 -0400", hash_original_method = "643CD56BC30DF4A83018A79008BF6616", hash_generated_method = "8FFFABFDF4FB609BC5BC809BCAB1F238")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var53365F3898D8A9E9BAE3603F3CDBE261_1263375129 = (getWidth() == 0 || getHeight() == 0);
        } //End collapsed parenthetic
        {
            mSplitBackground.draw(canvas);
        } //End block
        {
            {
                mBackground.draw(canvas);
            } //End block
            {
                mStackedBackground.draw(canvas);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (getWidth() == 0 || getHeight() == 0) {
            //return;
        //}
        //if (mIsSplit) {
            //if (mSplitBackground != null) mSplitBackground.draw(canvas);
        //} else {
            //if (mBackground != null) {
                //mBackground.draw(canvas);
            //}
            //if (mStackedBackground != null && mIsStacked) {
                //mStackedBackground.draw(canvas);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.139 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "09DD2561AE4A887ED868D97C955CCCFD")
    @DSModeled(DSC.SAFE)
    @Override
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.139 -0400", hash_original_method = "8D0F26C3446558D3092AD9D990B93994", hash_generated_method = "B7F87784D4990F35D6F6F4932F8700A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final LayoutParams lp;
        lp = (LayoutParams) mActionBarView.getLayoutParams();
        final int actionBarViewHeight;
        boolean varB8CE8FF97CCFCA2F576E1917FCA0CA1E_278551603 = (mActionBarView.isCollapsed());
        actionBarViewHeight = 0;
        actionBarViewHeight = mActionBarView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
        {
            boolean var7181903826D3FC1F71EFE9E63AD232F2_515091472 = (mTabContainer != null && mTabContainer.getVisibility() != GONE);
            {
                final int mode;
                mode = MeasureSpec.getMode(heightMeasureSpec);
                {
                    final int maxHeight;
                    maxHeight = MeasureSpec.getSize(heightMeasureSpec);
                    setMeasuredDimension(getMeasuredWidth(),
                        Math.min(actionBarViewHeight + mTabContainer.getMeasuredHeight(),
                                maxHeight));
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.140 -0400", hash_original_method = "325ECF81F05468831378A42F90AA0A17", hash_generated_method = "AB807275BBE4E3FC339B9C80A82CA621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        final boolean hasTabs;
        hasTabs = mTabContainer != null && mTabContainer.getVisibility() != GONE;
        {
            boolean var7181903826D3FC1F71EFE9E63AD232F2_2127006112 = (mTabContainer != null && mTabContainer.getVisibility() != GONE);
            {
                final int containerHeight;
                containerHeight = getMeasuredHeight();
                final int tabHeight;
                tabHeight = mTabContainer.getMeasuredHeight();
                {
                    boolean var15201DCF72EED924BE98CFE94A94FF7B_428826630 = ((mActionBarView.getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) == 0);
                    {
                        final int count;
                        count = getChildCount();
                        {
                            int i;
                            i = 0;
                            {
                                final View child;
                                child = getChildAt(i);
                                {
                                    boolean var28A666D856FCA260F0AAF19F9E4D575A_2043950694 = (!mActionBarView.isCollapsed());
                                    {
                                        child.offsetTopAndBottom(tabHeight);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        mTabContainer.layout(l, 0, r, tabHeight);
                    } //End block
                    {
                        mTabContainer.layout(l, containerHeight - tabHeight, r, containerHeight);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean needsInvalidate;
        needsInvalidate = false;
        {
            {
                mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                needsInvalidate = true;
            } //End block
        } //End block
        {
            {
                mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(),
                        mActionBarView.getRight(), mActionBarView.getBottom());
                needsInvalidate = true;
            } //End block
            {
                boolean varCA15C6C8070D24F0937F9B0071309C40_1849084112 = ((mIsStacked = hasTabs && mStackedBackground != null));
                {
                    mStackedBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(),
                        mTabContainer.getRight(), mTabContainer.getBottom());
                    needsInvalidate = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


