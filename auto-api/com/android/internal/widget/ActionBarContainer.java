package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "CE7CD8C505C6894370684CBA7E67B65D", hash_generated_field = "527C228A5C97714BAF48C0C499097913")

    private boolean mIsTransitioning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "0DF3EE29D001607FB7ECAD7B0A033A0A", hash_generated_field = "9D4880558BE8637E2C9BE9C42BC7DB01")

    private View mTabContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "98BFBBC15EE0629000250EFBD353EE68", hash_generated_field = "6CC22F47D8F7AAE7532A872F09B0E534")

    private ActionBarView mActionBarView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "0FD12110A291B3958F114906D990C478", hash_generated_field = "0925F2C91F8CBA797C183309FA7634C5")

    private Drawable mBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "0D8D648EC04BAB3A8BB02FC9937AB756", hash_generated_field = "BE3C8909DD0F859198FF64AA78C3183B")

    private Drawable mStackedBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "2225C949EA81FBFB7C5583F73183E256", hash_generated_field = "EAFF30D2C8DDA41FABEEAF56960F2296")

    private Drawable mSplitBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "51EE22FDB23C5E0FDB585C30F8807A27", hash_generated_field = "C9CE7D6607EA26E6C12DDA4008F1DC50")

    private boolean mIsSplit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:27.991 -0400", hash_original_field = "7DE3ED5C15FC8ED5A6D53988E9EB0439", hash_generated_field = "B07E47F3EE2FE730943F4349A2DF3F8F")

    private boolean mIsStacked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.007 -0400", hash_original_method = "11ADB8FB86182A3641DB27767A9D337F", hash_generated_method = "0678D087FC1AE67837931F30216B6ABC")
    public  ActionBarContainer(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.009 -0400", hash_original_method = "63748832C1944A3823B0F9894E29E249", hash_generated_method = "820B135D79D50D9669DA3BF5198E6B12")
    public  ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundDrawable(null);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ActionBar);
        mBackground = a.getDrawable(com.android.internal.R.styleable.ActionBar_background);
        mStackedBackground = a.getDrawable(
                com.android.internal.R.styleable.ActionBar_backgroundStacked);
        {
            boolean var80495DEA47A1645C948067B6ECEF8EB9_1392170043 = (getId() == com.android.internal.R.id.split_action_bar);
            {
                mIsSplit = true;
                mSplitBackground = a.getDrawable(
                    com.android.internal.R.styleable.ActionBar_backgroundSplit);
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        setWillNotDraw(mIsSplit ? mSplitBackground == null :
                mBackground == null && mStackedBackground == null);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.009 -0400", hash_original_method = "69B88AD6BEB0BE6EF5F88037F33C1F3D", hash_generated_method = "F17230A7ADDEE4BBF5B41A0A02A67CB1")
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //mActionBarView = (ActionBarView) findViewById(com.android.internal.R.id.action_bar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.015 -0400", hash_original_method = "78385A861A7FDA3897557FA33D96C5EA", hash_generated_method = "FDD27ACB7F75CC1B3FA7552F1E5A257A")
    public void setPrimaryBackground(Drawable bg) {
        mBackground = bg;
        invalidate();
        // ---------- Original Method ----------
        //mBackground = bg;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.016 -0400", hash_original_method = "D9D97A9D1A3797ABD6FF2A72BC0DD994", hash_generated_method = "73451948A7F40620F184D79F93FAC309")
    public void setStackedBackground(Drawable bg) {
        mStackedBackground = bg;
        invalidate();
        // ---------- Original Method ----------
        //mStackedBackground = bg;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.016 -0400", hash_original_method = "EE7203C1470FAC3396749865559F7B8E", hash_generated_method = "60046CBF2719778BB7A31CCB5A94F420")
    public void setSplitBackground(Drawable bg) {
        mSplitBackground = bg;
        invalidate();
        // ---------- Original Method ----------
        //mSplitBackground = bg;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.016 -0400", hash_original_method = "B47E345D6B402EE0E60D9E3F40581018", hash_generated_method = "07A61885CB04C34DDD25B20B9D4E80D1")
    public void setTransitioning(boolean isTransitioning) {
        mIsTransitioning = isTransitioning;
        setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                : FOCUS_AFTER_DESCENDANTS);
        // ---------- Original Method ----------
        //mIsTransitioning = isTransitioning;
        //setDescendantFocusability(isTransitioning ? FOCUS_BLOCK_DESCENDANTS
                //: FOCUS_AFTER_DESCENDANTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.016 -0400", hash_original_method = "8E69245395EC81C98ED35F3490421A0A", hash_generated_method = "9B6AC497A40705C944980884C6C465BA")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varCB64BEE5318C9BB9804B010A90A93A20_2136702243 = (mIsTransitioning || super.onInterceptTouchEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477874414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477874414;
        // ---------- Original Method ----------
        //return mIsTransitioning || super.onInterceptTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.017 -0400", hash_original_method = "FA8EB54F33D4C310829625567514278C", hash_generated_method = "DCEF7858A5B5D56B77D4344453C45229")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onTouchEvent(ev);
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769262446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769262446;
        // ---------- Original Method ----------
        //super.onTouchEvent(ev);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.017 -0400", hash_original_method = "9A976B5E6EF3A94656A0B6DD07EE34B7", hash_generated_method = "D03A0816BB373D91F2EF416722FAAD4A")
    @Override
    public boolean onHoverEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onHoverEvent(ev);
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842497087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842497087;
        // ---------- Original Method ----------
        //super.onHoverEvent(ev);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.018 -0400", hash_original_method = "56F3757B297FC41285B5D7002065B92C", hash_generated_method = "158C7F4E1900C6F3EFD3FA63F18236A8")
    public void setTabContainer(ScrollingTabContainerView tabView) {
        {
            removeView(mTabContainer);
        } //End block
        mTabContainer = tabView;
        {
            addView(tabView);
            ViewGroup.LayoutParams lp;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.018 -0400", hash_original_method = "1563ACF140881C9576C37880F51665C0", hash_generated_method = "587E602129BF831B5672DA90F58933C1")
    public View getTabContainer() {
        View varB4EAC82CA7396A68D541C85D26508E83_369476886 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_369476886 = mTabContainer;
        varB4EAC82CA7396A68D541C85D26508E83_369476886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_369476886;
        // ---------- Original Method ----------
        //return mTabContainer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.076 -0400", hash_original_method = "643CD56BC30DF4A83018A79008BF6616", hash_generated_method = "5E6AD88B8354CD4F5D77E9787ED1A219")
    @Override
    public void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var53365F3898D8A9E9BAE3603F3CDBE261_983276238 = (getWidth() == 0 || getHeight() == 0);
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
        addTaint(canvas.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.076 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "91A1547503B4802418477F881043ED6F")
    @Override
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_541353460 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_541353460 = null;
        addTaint(child.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_541353460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541353460;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.077 -0400", hash_original_method = "8D0F26C3446558D3092AD9D990B93994", hash_generated_method = "337DA6723B2EA78C33D83DB40E093BB4")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LayoutParams lp;
        lp = (LayoutParams) mActionBarView.getLayoutParams();
        int actionBarViewHeight;
        boolean varB8CE8FF97CCFCA2F576E1917FCA0CA1E_1232323384 = (mActionBarView.isCollapsed());
        actionBarViewHeight = 0;
        actionBarViewHeight = mActionBarView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
        {
            boolean var7181903826D3FC1F71EFE9E63AD232F2_1743110624 = (mTabContainer != null && mTabContainer.getVisibility() != GONE);
            {
                int mode;
                mode = MeasureSpec.getMode(heightMeasureSpec);
                {
                    int maxHeight;
                    maxHeight = MeasureSpec.getSize(heightMeasureSpec);
                    setMeasuredDimension(getMeasuredWidth(),
                        Math.min(actionBarViewHeight + mTabContainer.getMeasuredHeight(),
                                maxHeight));
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.078 -0400", hash_original_method = "325ECF81F05468831378A42F90AA0A17", hash_generated_method = "A53DC6656C8C2EBAF6B156BA8C285506")
    @Override
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLayout(changed, l, t, r, b);
        boolean hasTabs;
        hasTabs = mTabContainer != null && mTabContainer.getVisibility() != GONE;
        {
            boolean var7181903826D3FC1F71EFE9E63AD232F2_1034249567 = (mTabContainer != null && mTabContainer.getVisibility() != GONE);
            {
                int containerHeight;
                containerHeight = getMeasuredHeight();
                int tabHeight;
                tabHeight = mTabContainer.getMeasuredHeight();
                {
                    boolean var15201DCF72EED924BE98CFE94A94FF7B_1942544012 = ((mActionBarView.getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) == 0);
                    {
                        int count;
                        count = getChildCount();
                        {
                            int i;
                            i = 0;
                            {
                                View child;
                                child = getChildAt(i);
                                {
                                    boolean var28A666D856FCA260F0AAF19F9E4D575A_1124549770 = (!mActionBarView.isCollapsed());
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
                boolean varCA15C6C8070D24F0937F9B0071309C40_1073160014 = ((mIsStacked = hasTabs && mStackedBackground != null));
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
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

