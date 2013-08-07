package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "CE7CD8C505C6894370684CBA7E67B65D", hash_generated_field = "527C228A5C97714BAF48C0C499097913")

    private boolean mIsTransitioning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "0DF3EE29D001607FB7ECAD7B0A033A0A", hash_generated_field = "9D4880558BE8637E2C9BE9C42BC7DB01")

    private View mTabContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "98BFBBC15EE0629000250EFBD353EE68", hash_generated_field = "6CC22F47D8F7AAE7532A872F09B0E534")

    private ActionBarView mActionBarView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "0FD12110A291B3958F114906D990C478", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "0D8D648EC04BAB3A8BB02FC9937AB756", hash_generated_field = "BE3C8909DD0F859198FF64AA78C3183B")

    private Drawable mStackedBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "2225C949EA81FBFB7C5583F73183E256", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "51EE22FDB23C5E0FDB585C30F8807A27", hash_generated_field = "C9CE7D6607EA26E6C12DDA4008F1DC50")

    private boolean mIsSplit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_field = "7DE3ED5C15FC8ED5A6D53988E9EB0439", hash_generated_field = "B07E47F3EE2FE730943F4349A2DF3F8F")

    private boolean mIsStacked;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.691 -0400", hash_original_method = "11ADB8FB86182A3641DB27767A9D337F", hash_generated_method = "0678D087FC1AE67837931F30216B6ABC")
    public  ActionBarContainer(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.692 -0400", hash_original_method = "63748832C1944A3823B0F9894E29E249", hash_generated_method = "6EF28D8CDCCD2115F71F8FF66F6FBBBB")
    public  ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setBackgroundDrawable(null);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ActionBar);
        mBackground = a.getDrawable(com.android.internal.R.styleable.ActionBar_background);
        mStackedBackground = a.getDrawable(
                com.android.internal.R.styleable.ActionBar_backgroundStacked);
        if(getId() == com.android.internal.R.id.split_action_bar)        
        {
            mIsSplit = true;
            mSplitBackground = a.getDrawable(
                    com.android.internal.R.styleable.ActionBar_backgroundSplit);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.693 -0400", hash_original_method = "69B88AD6BEB0BE6EF5F88037F33C1F3D", hash_generated_method = "F17230A7ADDEE4BBF5B41A0A02A67CB1")
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.693 -0400", hash_original_method = "78385A861A7FDA3897557FA33D96C5EA", hash_generated_method = "FDD27ACB7F75CC1B3FA7552F1E5A257A")
    public void setPrimaryBackground(Drawable bg) {
        mBackground = bg;
        invalidate();
        // ---------- Original Method ----------
        //mBackground = bg;
        //invalidate();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.694 -0400", hash_original_method = "D9D97A9D1A3797ABD6FF2A72BC0DD994", hash_generated_method = "73451948A7F40620F184D79F93FAC309")
    public void setStackedBackground(Drawable bg) {
        mStackedBackground = bg;
        invalidate();
        // ---------- Original Method ----------
        //mStackedBackground = bg;
        //invalidate();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.694 -0400", hash_original_method = "EE7203C1470FAC3396749865559F7B8E", hash_generated_method = "60046CBF2719778BB7A31CCB5A94F420")
    public void setSplitBackground(Drawable bg) {
        mSplitBackground = bg;
        invalidate();
        // ---------- Original Method ----------
        //mSplitBackground = bg;
        //invalidate();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.695 -0400", hash_original_method = "B47E345D6B402EE0E60D9E3F40581018", hash_generated_method = "07A61885CB04C34DDD25B20B9D4E80D1")
    public void setTransitioning(boolean isTransitioning) {
        mIsTransitioning = isTransitioning;
        setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                : FOCUS_AFTER_DESCENDANTS);
        // ---------- Original Method ----------
        //mIsTransitioning = isTransitioning;
        //setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                //: FOCUS_AFTER_DESCENDANTS);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.695 -0400", hash_original_method = "8E69245395EC81C98ED35F3490421A0A", hash_generated_method = "E701DEDB56633AD650A69EA21D1B691E")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        boolean varBDB5270654E973B6C615C430DB3A1BDA_111763673 = (mIsTransitioning || super.onInterceptTouchEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976100666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_976100666;
        // ---------- Original Method ----------
        //return mIsTransitioning || super.onInterceptTouchEvent(ev);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.695 -0400", hash_original_method = "FA8EB54F33D4C310829625567514278C", hash_generated_method = "F6D6BF218EBC4D1C4D4B8E1A4B051304")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        super.onTouchEvent(ev);
        boolean varB326B5062B2F0E69046810717534CB09_1927238448 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130637164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130637164;
        // ---------- Original Method ----------
        //super.onTouchEvent(ev);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.696 -0400", hash_original_method = "9A976B5E6EF3A94656A0B6DD07EE34B7", hash_generated_method = "DD1536B81A7CCF8A2DBDEFB21E1B22EC")
    @Override
    public boolean onHoverEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        super.onHoverEvent(ev);
        boolean varB326B5062B2F0E69046810717534CB09_1643770053 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754167183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754167183;
        // ---------- Original Method ----------
        //super.onHoverEvent(ev);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.696 -0400", hash_original_method = "56F3757B297FC41285B5D7002065B92C", hash_generated_method = "1B721088708F466C27D91E303F59DEBD")
    public void setTabContainer(ScrollingTabContainerView tabView) {
        if(mTabContainer != null)        
        {
            removeView(mTabContainer);
        } //End block
        mTabContainer = tabView;
        if(tabView != null)        
        {
            addView(tabView);
            final ViewGroup.LayoutParams lp = tabView.getLayoutParams();
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.697 -0400", hash_original_method = "1563ACF140881C9576C37880F51665C0", hash_generated_method = "C29B20BDCEE64978317E006D8480BAFC")
    public View getTabContainer() {
View var377A7B795B2C85DAE993421F8FAE8AE8_19897703 =         mTabContainer;
        var377A7B795B2C85DAE993421F8FAE8AE8_19897703.addTaint(taint);
        return var377A7B795B2C85DAE993421F8FAE8AE8_19897703;
        // ---------- Original Method ----------
        //return mTabContainer;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.698 -0400", hash_original_method = "643CD56BC30DF4A83018A79008BF6616", hash_generated_method = "0D09114FD074A6D13E9933BE44B3EAB7")
    @Override
    public void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        if(getWidth() == 0 || getHeight() == 0)        
        {
            return;
        } //End block
        if(mIsSplit)        
        {
            if(mSplitBackground != null)            
            mSplitBackground.draw(canvas);
        } //End block
        else
        {
            if(mBackground != null)            
            {
                mBackground.draw(canvas);
            } //End block
            if(mStackedBackground != null && mIsStacked)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.700 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "780EA366C766BC66E87F5E64DD8B9C26")
    @Override
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
        addTaint(callback.getTaint());
        addTaint(child.getTaint());
ActionMode var540C13E9E156B687226421B24F2DF178_551911362 =         null;
        var540C13E9E156B687226421B24F2DF178_551911362.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_551911362;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.701 -0400", hash_original_method = "8D0F26C3446558D3092AD9D990B93994", hash_generated_method = "2E5D797330F20ABDDD296029A7792ACE")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(mActionBarView == null)        
        return;
        final LayoutParams lp = (LayoutParams) mActionBarView.getLayoutParams();
        final int actionBarViewHeight = mActionBarView.isCollapsed() ? 0 :
                mActionBarView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
        if(mTabContainer != null && mTabContainer.getVisibility() != GONE)        
        {
            final int mode = MeasureSpec.getMode(heightMeasureSpec);
            if(mode == MeasureSpec.AT_MOST)            
            {
                final int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension(getMeasuredWidth(),
                        Math.min(actionBarViewHeight + mTabContainer.getMeasuredHeight(),
                                maxHeight));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.702 -0400", hash_original_method = "325ECF81F05468831378A42F90AA0A17", hash_generated_method = "5EA2C08E11DBC8AC40D37BAF89FC1C74")
    @Override
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        final boolean hasTabs = mTabContainer != null && mTabContainer.getVisibility() != GONE;
        if(mTabContainer != null && mTabContainer.getVisibility() != GONE)        
        {
            final int containerHeight = getMeasuredHeight();
            final int tabHeight = mTabContainer.getMeasuredHeight();
            if((mActionBarView.getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) == 0)            
            {
                final int count = getChildCount();
for(int i = 0;i < count;i++)
                {
                    final View child = getChildAt(i);
                    if(child == mTabContainer)                    
                    continue;
                    if(!mActionBarView.isCollapsed())                    
                    {
                        child.offsetTopAndBottom(tabHeight);
                    } //End block
                } //End block
                mTabContainer.layout(l, 0, r, tabHeight);
            } //End block
            else
            {
                mTabContainer.layout(l, containerHeight - tabHeight, r, containerHeight);
            } //End block
        } //End block
        boolean needsInvalidate = false;
        if(mIsSplit)        
        {
            if(mSplitBackground != null)            
            {
                mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                needsInvalidate = true;
            } //End block
        } //End block
        else
        {
            if(mBackground != null)            
            {
                mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(),
                        mActionBarView.getRight(), mActionBarView.getBottom());
                needsInvalidate = true;
            } //End block
            if((mIsStacked = hasTabs && mStackedBackground != null))            
            {
                mStackedBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(),
                        mTabContainer.getRight(), mTabContainer.getBottom());
                needsInvalidate = true;
            } //End block
        } //End block
        if(needsInvalidate)        
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

