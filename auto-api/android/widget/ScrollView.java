package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import java.util.List;

public class ScrollView extends FrameLayout {
    static final int ANIMATED_SCROLL_GAP = 250;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private long mLastScroll;
    private final Rect mTempRect = new Rect();
    private OverScroller mScroller;
    private EdgeEffect mEdgeGlowTop;
    private EdgeEffect mEdgeGlowBottom;
    private float mLastMotionY;
    private boolean mIsLayoutDirty = true;
    private View mChildToScrollTo = null;
    private boolean mIsBeingDragged = false;
    private VelocityTracker mVelocityTracker;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mFillViewport;
    private boolean mSmoothScrollingEnabled = true;
    private int mTouchSlop;
    private int mMinimumVelocity;
    private int mMaximumVelocity;
    private int mOverscrollDistance;
    private int mOverflingDistance;
    private int mActivePointerId = INVALID_POINTER;
    private StrictMode.Span mScrollStrictSpan = null;
    private StrictMode.Span mFlingStrictSpan = null;
    private static final int INVALID_POINTER = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "4713E1355E9C805E185DB05E4B4B9810", hash_generated_method = "822D6F9B00AE87B64FC8B7FA3365D10C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScrollView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "D709104905B863FC98F9383546426518", hash_generated_method = "838A2888A1947DCE5BE48733BD2E5084")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.scrollViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "A71F55C63B3167922F139A658C272800", hash_generated_method = "D72DC3FD37A80BE13DB132D85F73EA22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        initScrollView();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        a.recycle();
        // ---------- Original Method ----------
        //initScrollView();
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ScrollView, defStyle, 0);
        //setFillViewport(a.getBoolean(R.styleable.ScrollView_fillViewport, false));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "5080F2EF14C9DC10393EB8319AEC0906")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "2B5BCBF9645A95C024C3D4122E8D2438", hash_generated_method = "3A40A21DCF7E727D602BBE8A36A25218")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getTopFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_1347027085 = (getChildCount() == 0);
        } //End collapsed parenthetic
        final int length;
        length = getVerticalFadingEdgeLength();
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getVerticalFadingEdgeLength();
        //if (mScrollY < length) {
            //return mScrollY / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "F0E4C184CA27C21FD42267E77DCA1374", hash_generated_method = "F6BCD4B3FDB3CB03AEBF4B9FA07191AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getBottomFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_498770335 = (getChildCount() == 0);
        } //End collapsed parenthetic
        final int length;
        length = getVerticalFadingEdgeLength();
        final int bottomEdge;
        bottomEdge = getHeight() - mPaddingBottom;
        final int span;
        span = getChildAt(0).getBottom() - mScrollY - bottomEdge;
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getVerticalFadingEdgeLength();
        //final int bottomEdge = getHeight() - mPaddingBottom;
        //final int span = getChildAt(0).getBottom() - mScrollY - bottomEdge;
        //if (span < length) {
            //return span / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "CEAAABD4DE747FC0C910B456C1725542")
    @DSModeled(DSC.SAFE)
    public int getMaxScrollAmount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.361 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "9DA3B06EADDC24C257E3ECD0B1AF2634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initScrollView() {
        mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setWillNotDraw(false);
        final ViewConfiguration configuration;
        configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        // ---------- Original Method ----------
        //mScroller = new OverScroller(getContext());
        //setFocusable(true);
        //setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        //setWillNotDraw(false);
        //final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        //mTouchSlop = configuration.getScaledTouchSlop();
        //mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        //mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        //mOverscrollDistance = configuration.getScaledOverscrollDistance();
        //mOverflingDistance = configuration.getScaledOverflingDistance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "C2B46C856A31C41C5B4609404338EFA0", hash_generated_method = "261114545634F53697F56C63EB954A23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_804653068 = (getChildCount() > 0);
            {
                throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "E948CE4EC40C516B64A70B82C4D41ABE", hash_generated_method = "D81DDBBF52E8D89D33B0D253744DBBE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1621418024 = (getChildCount() > 0);
            {
                throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "34A1DE7AC13648E903519BA7AEB15B21", hash_generated_method = "14BF20FD4DC57DCB7FFF53455FEBC7FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_2039866243 = (getChildCount() > 0);
            {
                throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "363983D07DF3EAAC15B8A0529305BE77", hash_generated_method = "C7944183B320E38836FB5BF06D2D3979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1976647069 = (getChildCount() > 0);
            {
                throw new IllegalStateException("ScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("ScrollView can host only one direct child");
        //}
        //super.addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "F1DEDB4D65582CE354A1D843D55A4B55", hash_generated_method = "808C5CEF6E9963110F1A3AC8F19DD27B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canScroll() {
        View child;
        child = getChildAt(0);
        {
            int childHeight;
            childHeight = child.getHeight();
            boolean var3A415DE46D6A024E28376F2A13A712DB_1348625665 = (getHeight() < childHeight + mPaddingTop + mPaddingBottom);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //View child = getChildAt(0);
        //if (child != null) {
            //int childHeight = child.getHeight();
            //return getHeight() < childHeight + mPaddingTop + mPaddingBottom;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "04EAAA6E73597F796AE64B4B56F705C6")
    @DSModeled(DSC.SAFE)
    public boolean isFillViewport() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "2718DB38C5B2B42CCAA0CB94A84D93CB")
    @DSModeled(DSC.SAFE)
    public void setFillViewport(boolean fillViewport) {
        dsTaint.addTaint(fillViewport);
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (fillViewport != mFillViewport) {
            //mFillViewport = fillViewport;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "A2D1B214D94746DC1850D6075509DBFB")
    @DSModeled(DSC.SAFE)
    public boolean isSmoothScrollingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSmoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "5449975DA4C9069BB9BA3F91BFF8389A")
    @DSModeled(DSC.SAFE)
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        dsTaint.addTaint(smoothScrollingEnabled);
        // ---------- Original Method ----------
        //mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.362 -0400", hash_original_method = "1504CEEE6604563B648201D50795D68C", hash_generated_method = "741BBF596B4F3ADFEE6B936BE94E7FDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_46807107 = (getChildCount() > 0);
            {
                final View child;
                child = getChildAt(0);
                int height;
                height = getMeasuredHeight();
                {
                    boolean varEEEC94D0CC5FB640673872B86A985E2B_622448380 = (child.getMeasuredHeight() < height);
                    {
                        final FrameLayout.LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        int childWidthMeasureSpec;
                        childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                        mPaddingLeft + mPaddingRight, lp.width);
                        height -= mPaddingTop;
                        height -= mPaddingBottom;
                        int childHeightMeasureSpec;
                        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
                        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "E9C49818455E5FA030B554DA13A0A091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean var160A6DCE359009EE36E492A233BEB313_116338913 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "1E6EE1FACBE8E24D9D58E940A1542C55", hash_generated_method = "B8E41C443FDE76B9C7866004CC43A168")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean executeKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        mTempRect.setEmpty();
        {
            boolean varF142AAB9B9E2812C95D81D43568D13C8_891504677 = (!canScroll());
            {
                {
                    boolean var2897164B636FEEE3DA92631EEF7087B0_921835001 = (isFocused() && event.getKeyCode() != KeyEvent.KEYCODE_BACK);
                    {
                        View currentFocused;
                        currentFocused = findFocus();
                        currentFocused = null;
                        View nextFocused;
                        nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_DOWN);
                        boolean varD482CC356741D5879BD547A170E814F4_552070525 = (nextFocused != null
                        && nextFocused != this
                        && nextFocused.requestFocus(View.FOCUS_DOWN));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean handled;
        handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_1126471087 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_265226116 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_1081463865 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_UP);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_UP);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_385635754 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_DOWN);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_DOWN);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_SPACE 
                    pageScroll(event.isShiftPressed() ? View.FOCUS_UP : View.FOCUS_DOWN);
                    //End case KeyEvent.KEYCODE_SPACE 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "21B5B152D5EE02017A0CB65ECB9B3403", hash_generated_method = "BC75737B1EE187350C82258435A5F90B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean inChild(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1379537818 = (getChildCount() > 0);
            {
                final int scrollY;
                scrollY = mScrollY;
                final View child;
                child = getChildAt(0);
                boolean varB6F197A68897B2FF8EC1E9EDD5403361_1917636618 = (!(y < child.getTop() - scrollY
                    || y >= child.getBottom() - scrollY
                    || x < child.getLeft()
                    || x >= child.getRight()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //final int scrollY = mScrollY;
            //final View child = getChildAt(0);
            //return !(y < child.getTop() - scrollY
                    //|| y >= child.getBottom() - scrollY
                    //|| x < child.getLeft()
                    //|| x >= child.getRight());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "43200DD00A758A81245813B01E7050CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initOrResetVelocityTracker() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        {
            mVelocityTracker.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //} else {
            //mVelocityTracker.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "154B8421283BEBB50C613A81D4F65445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "722D9035C242C77366688C9524CCD357")
    @DSModeled(DSC.SAFE)
    private void recycleVelocityTracker() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.363 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "2B136DF901568B223FCA9653C4C29759")
    @DSModeled(DSC.SAFE)
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        dsTaint.addTaint(disallowIntercept);
        {
            recycleVelocityTracker();
        } //End block
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        // ---------- Original Method ----------
        //if (disallowIntercept) {
            //recycleVelocityTracker();
        //}
        //super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.364 -0400", hash_original_method = "A618CDF234D118EA8A225B0CD965AEA3", hash_generated_method = "2EDF0270D5B6EC24F996CB34E69E5F06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        final int action;
        action = ev.getAction();
        //Begin case MotionEvent.ACTION_MOVE 
        {
            final int activePointerId;
            activePointerId = mActivePointerId;
            final int pointerIndex;
            pointerIndex = ev.findPointerIndex(activePointerId);
            final float y;
            y = ev.getY(pointerIndex);
            final int yDiff;
            yDiff = (int) Math.abs(y - mLastMotionY);
            {
                mIsBeingDragged = true;
                mLastMotionY = y;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                {
                    mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
                } //End block
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            final float y;
            y = ev.getY();
            {
                boolean varFF34B1086FC4594476FFD6F360BBB78C_953865958 = (!inChild((int) ev.getX(), (int) y));
                {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                } //End block
            } //End collapsed parenthetic
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("ScrollView-scroll");
            } //End block
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mIsBeingDragged = false;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mActivePointerId = INVALID_POINTER;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        recycleVelocityTracker();
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        {
            boolean var5A644DDFA364D0381E7012BF55F348DC_1320765443 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.365 -0400", hash_original_method = "83F23D23BD0BAB2CB063E24A3B111651", hash_generated_method = "577DCD1E0BE508C65C34FE4D7CD0EBB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        final int action;
        action = ev.getAction();
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mIsBeingDragged = getChildCount() != 0;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_2076715150 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    {
                        mFlingStrictSpan.finish();
                        mFlingStrictSpan = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mLastMotionY = ev.getY();
            mActivePointerId = ev.getPointerId(0);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            final int activePointerIndex;
            activePointerIndex = ev.findPointerIndex(mActivePointerId);
            final float y;
            y = ev.getY(activePointerIndex);
            final int deltaY;
            deltaY = (int) (mLastMotionY - y);
            mLastMotionY = y;
            final int oldX;
            oldX = mScrollX;
            final int oldY;
            oldY = mScrollY;
            final int range;
            range = getScrollRange();
            final int overscrollMode;
            overscrollMode = getOverScrollMode();
            final boolean canOverscroll;
            canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
            {
                boolean var670E8200B9D4E089C7377D895DE2F86E_96124209 = (overScrollBy(0, deltaY, 0, mScrollY,
                            0, range, 0, mOverscrollDistance, true));
                {
                    mVelocityTracker.clear();
                } //End block
            } //End collapsed parenthetic
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                final int pulledToY;
                pulledToY = oldY + deltaY;
                {
                    mEdgeGlowTop.onPull((float) deltaY / getHeight());
                    {
                        boolean varE6213428B20479BD32BF17B140F5ED52_2007803219 = (!mEdgeGlowBottom.isFinished());
                        {
                            mEdgeGlowBottom.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowBottom.onPull((float) deltaY / getHeight());
                    {
                        boolean var5D6A56784A8F83A042E55ED0998DBE18_537508846 = (!mEdgeGlowTop.isFinished());
                        {
                            mEdgeGlowTop.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4BAAB9D93C535A28BF0C04887423354C_885326500 = (mEdgeGlowTop != null
                                && (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            final VelocityTracker velocityTracker;
            velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity;
            initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
            {
                boolean var9C190A50DA656473F4A85C2EF380F022_1743950945 = (getChildCount() > 0);
                {
                    {
                        boolean varCB55D3BE2E93A2FD55EF78A581740AFC_174672553 = ((Math.abs(initialVelocity) > mMinimumVelocity));
                        {
                            fling(-initialVelocity);
                        } //End block
                        {
                            {
                                boolean varC93C7034440DD4C8753F4F2114A84A37_1700788864 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0,
                                    getScrollRange()));
                                {
                                    invalidate();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mActivePointerId = INVALID_POINTER;
            endDrag();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            boolean var9286919EB531712C93F03BFB604683F8_508618076 = (mIsBeingDragged && getChildCount() > 0);
            {
                {
                    boolean var0B94B4CD263DE1DB92077C5CA547FAC2_685520382 = (mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
                mActivePointerId = INVALID_POINTER;
                endDrag();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL 
        //Begin case MotionEvent.ACTION_POINTER_DOWN 
        {
            final int index;
            index = ev.getActionIndex();
            final float y;
            y = ev.getY(index);
            mLastMotionY = y;
            mActivePointerId = ev.getPointerId(index);
        } //End block
        //End case MotionEvent.ACTION_POINTER_DOWN 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        mLastMotionY = ev.getY(ev.findPointerIndex(mActivePointerId));
        //End case MotionEvent.ACTION_POINTER_UP 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.365 -0400", hash_original_method = "1724FA32F4E11B8EDA6825E1236F6DA2", hash_generated_method = "99EE2D165B4BBBBBCE5EDBAF3ABCA8B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSecondaryPointerUp(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        final int pointerIndex;
        pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId;
        pointerId = ev.getPointerId(pointerIndex);
        {
            final int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mLastMotionY = ev.getY(newPointerIndex);
            mActivePointerId = ev.getPointerId(newPointerIndex);
            {
                mVelocityTracker.clear();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                //MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        //final int pointerId = ev.getPointerId(pointerIndex);
        //if (pointerId == mActivePointerId) {
            //final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            //mLastMotionY = ev.getY(newPointerIndex);
            //mActivePointerId = ev.getPointerId(newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.365 -0400", hash_original_method = "ABBC11F59DDEDBBBBFE897034F702501", hash_generated_method = "866E13F9C4CCFE9E22E27ECC84F3E60C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_598160035 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_989284049 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            final float vscroll;
                            vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                final int delta;
                                delta = (int) (vscroll * getVerticalScrollFactor());
                                final int range;
                                range = getScrollRange();
                                int oldScrollY;
                                oldScrollY = mScrollY;
                                int newScrollY;
                                newScrollY = oldScrollY - delta;
                                {
                                    newScrollY = 0;
                                } //End block
                                {
                                    newScrollY = range;
                                } //End block
                                {
                                    super.scrollTo(mScrollX, newScrollY);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_61486938 = (super.onGenericMotionEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.365 -0400", hash_original_method = "CC5D228BD55E3E42D5A6CE954C441DF3", hash_generated_method = "2CC2D7A0A5FFAE03711D53F52B38C8C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scrollY);
        dsTaint.addTaint(scrollX);
        dsTaint.addTaint(clampedY);
        dsTaint.addTaint(clampedX);
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_90345655 = (!mScroller.isFinished());
            {
                mScrollX = scrollX;
                mScrollY = scrollY;
                invalidateParentIfNeeded();
                {
                    mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
                } //End block
            } //End block
            {
                super.scrollTo(scrollX, scrollY);
            } //End block
        } //End collapsed parenthetic
        awakenScrollBars();
        // ---------- Original Method ----------
        //if (!mScroller.isFinished()) {
            //mScrollX = scrollX;
            //mScrollY = scrollY;
            //invalidateParentIfNeeded();
            //if (clampedY) {
                //mScroller.springBack(mScrollX, mScrollY, 0, 0, 0, getScrollRange());
            //}
        //} else {
            //super.scrollTo(scrollX, scrollY);
        //}
        //awakenScrollBars();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.366 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "D82A1E1620A175B56A79977211F93786")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(getScrollRange() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.366 -0400", hash_original_method = "F1695E9318A6A21B761B35BD458E866B", hash_generated_method = "A4436843AD2E9FC2D138C0A0D2BE8DE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        final boolean scrollable;
        scrollable = getScrollRange() > 0;
        event.setScrollable(scrollable);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(mScrollX);
        event.setMaxScrollY(getScrollRange());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //final boolean scrollable = getScrollRange() > 0;
        //event.setScrollable(scrollable);
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //event.setMaxScrollX(mScrollX);
        //event.setMaxScrollY(getScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.366 -0400", hash_original_method = "54B8D0E6795D053FB63A6E55BD2EA0C5", hash_generated_method = "208B7B4D5DD504E42EC2A9B5440974F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getScrollRange() {
        int scrollRange;
        scrollRange = 0;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1808261791 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                scrollRange = Math.max(0,
                    child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int scrollRange = 0;
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //scrollRange = Math.max(0,
                    //child.getHeight() - (getHeight() - mPaddingBottom - mPaddingTop));
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.366 -0400", hash_original_method = "CCA8F1BE638FE2EC5E8781CBB11ADD24", hash_generated_method = "106AA4E09788809A55FCF54299724479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findFocusableViewInMyBounds(final boolean topFocus,
            final int top, View preferredFocusable) {
        dsTaint.addTaint(preferredFocusable.dsTaint);
        dsTaint.addTaint(topFocus);
        dsTaint.addTaint(top);
        final int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        final int topWithoutFadingEdge;
        topWithoutFadingEdge = top + fadingEdgeLength;
        final int bottomWithoutFadingEdge;
        bottomWithoutFadingEdge = top + getHeight() - fadingEdgeLength;
        {
            boolean var779C321780A81D8A63D26CAE3AB982D5_797269810 = ((preferredFocusable != null)
                && (preferredFocusable.getTop() < bottomWithoutFadingEdge)
                && (preferredFocusable.getBottom() > topWithoutFadingEdge));
        } //End collapsed parenthetic
        View var2D76BFFA63757AA84DF2D0B11412E529_1827974761 = (findFocusableViewInBounds(topFocus, topWithoutFadingEdge,
                bottomWithoutFadingEdge));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int fadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        //final int topWithoutFadingEdge = top + fadingEdgeLength;
        //final int bottomWithoutFadingEdge = top + getHeight() - fadingEdgeLength;
        //if ((preferredFocusable != null)
                //&& (preferredFocusable.getTop() < bottomWithoutFadingEdge)
                //&& (preferredFocusable.getBottom() > topWithoutFadingEdge)) {
            //return preferredFocusable;
        //}
        //return findFocusableViewInBounds(topFocus, topWithoutFadingEdge,
                //bottomWithoutFadingEdge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.366 -0400", hash_original_method = "78998B2E5B42D469D0E131861596BD99", hash_generated_method = "4C584C1A810FF9EA81C56166168EB973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findFocusableViewInBounds(boolean topFocus, int top, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(topFocus);
        dsTaint.addTaint(top);
        List<View> focusables;
        focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate;
        focusCandidate = null;
        boolean foundFullyContainedFocusable;
        foundFullyContainedFocusable = false;
        int count;
        count = focusables.size();
        {
            int i;
            i = 0;
            {
                View view;
                view = focusables.get(i);
                int viewTop;
                viewTop = view.getTop();
                int viewBottom;
                viewBottom = view.getBottom();
                {
                    final boolean viewIsFullyContained;
                    viewIsFullyContained = (top < viewTop) &&
                        (viewBottom < bottom);
                    {
                        focusCandidate = view;
                        foundFullyContainedFocusable = viewIsFullyContained;
                    } //End block
                    {
                        final boolean viewIsCloserToBoundary;
                        viewIsCloserToBoundary = (topFocus && viewTop < focusCandidate.getTop()) ||
                                    (!topFocus && viewBottom > focusCandidate
                                            .getBottom());
                        {
                            {
                                focusCandidate = view;
                            } //End block
                        } //End block
                        {
                            {
                                focusCandidate = view;
                                foundFullyContainedFocusable = true;
                            } //End block
                            {
                                focusCandidate = view;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.367 -0400", hash_original_method = "8096444783AE8C9AF2A604C00C6FDBC2", hash_generated_method = "0B7A43F1ED705005D833578FEEBD68EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pageScroll(int direction) {
        dsTaint.addTaint(direction);
        boolean down;
        down = direction == View.FOCUS_DOWN;
        int height;
        height = getHeight();
        {
            mTempRect.top = getScrollY() + height;
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(count - 1);
                {
                    boolean varED85C349B0DA33BB45D7B420A69B2E3A_1171422975 = (mTempRect.top + height > view.getBottom());
                    {
                        mTempRect.top = view.getBottom() - height;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            mTempRect.top = getScrollY() - height;
            {
                mTempRect.top = 0;
            } //End block
        } //End block
        mTempRect.bottom = mTempRect.top + height;
        boolean var39A84547F8736C141B73A0089E5E641A_512047372 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean down = direction == View.FOCUS_DOWN;
        //int height = getHeight();
        //if (down) {
            //mTempRect.top = getScrollY() + height;
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(count - 1);
                //if (mTempRect.top + height > view.getBottom()) {
                    //mTempRect.top = view.getBottom() - height;
                //}
            //}
        //} else {
            //mTempRect.top = getScrollY() - height;
            //if (mTempRect.top < 0) {
                //mTempRect.top = 0;
            //}
        //}
        //mTempRect.bottom = mTempRect.top + height;
        //return scrollAndFocus(direction, mTempRect.top, mTempRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.367 -0400", hash_original_method = "E10B42C26E723F278A5695B0C5DAB2DB", hash_generated_method = "CD91D412AACAA92E0E5C480B1C5B8F36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean fullScroll(int direction) {
        dsTaint.addTaint(direction);
        boolean down;
        down = direction == View.FOCUS_DOWN;
        int height;
        height = getHeight();
        mTempRect.top = 0;
        mTempRect.bottom = height;
        {
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(count - 1);
                mTempRect.bottom = view.getBottom() + mPaddingBottom;
                mTempRect.top = mTempRect.bottom - height;
            } //End block
        } //End block
        boolean var39A84547F8736C141B73A0089E5E641A_592198143 = (scrollAndFocus(direction, mTempRect.top, mTempRect.bottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean down = direction == View.FOCUS_DOWN;
        //int height = getHeight();
        //mTempRect.top = 0;
        //mTempRect.bottom = height;
        //if (down) {
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(count - 1);
                //mTempRect.bottom = view.getBottom() + mPaddingBottom;
                //mTempRect.top = mTempRect.bottom - height;
            //}
        //}
        //return scrollAndFocus(direction, mTempRect.top, mTempRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.367 -0400", hash_original_method = "AEE85E195E488E817C7C5FD2FB4EC0FB", hash_generated_method = "B0D4E8B804E192A64CDB436A7910A37B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean scrollAndFocus(int direction, int top, int bottom) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(top);
        boolean handled;
        handled = true;
        int height;
        height = getHeight();
        int containerTop;
        containerTop = getScrollY();
        int containerBottom;
        containerBottom = containerTop + height;
        boolean up;
        up = direction == View.FOCUS_UP;
        View newFocused;
        newFocused = findFocusableViewInBounds(up, top, bottom);
        {
            newFocused = this;
        } //End block
        {
            handled = false;
        } //End block
        {
            int delta;
            delta = (top - containerTop);
            delta = (bottom - containerBottom);
            doScrollY(delta);
        } //End block
        {
            boolean var2DF5574E3AD9AB6AAA9DDD6415AB9F2D_1139556072 = (newFocused != findFocus());
            newFocused.requestFocus(direction);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean handled = true;
        //int height = getHeight();
        //int containerTop = getScrollY();
        //int containerBottom = containerTop + height;
        //boolean up = direction == View.FOCUS_UP;
        //View newFocused = findFocusableViewInBounds(up, top, bottom);
        //if (newFocused == null) {
            //newFocused = this;
        //}
        //if (top >= containerTop && bottom <= containerBottom) {
            //handled = false;
        //} else {
            //int delta = up ? (top - containerTop) : (bottom - containerBottom);
            //doScrollY(delta);
        //}
        //if (newFocused != findFocus()) newFocused.requestFocus(direction);
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.367 -0400", hash_original_method = "99A4FFBBF0B3182EC320D3CC49E9281B", hash_generated_method = "0661C40A8E09299A553A6902AB98670F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean arrowScroll(int direction) {
        dsTaint.addTaint(direction);
        View currentFocused;
        currentFocused = findFocus();
        currentFocused = null;
        View nextFocused;
        nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        final int maxJump;
        maxJump = getMaxScrollAmount();
        {
            boolean var9D8E7BEB7B2A9A39F141F9B559F28F2E_1901634128 = (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump, getHeight()));
            {
                nextFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(nextFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollY(scrollDelta);
                nextFocused.requestFocus(direction);
            } //End block
            {
                int scrollDelta;
                scrollDelta = maxJump;
                {
                    boolean var63FC15BACC5B673A5F772C0D7C31E719_718353609 = (direction == View.FOCUS_UP && getScrollY() < scrollDelta);
                    {
                        scrollDelta = getScrollY();
                    } //End block
                    {
                        {
                            boolean varB8CB178E8413E8F52B580007177C5576_1792014961 = (getChildCount() > 0);
                            {
                                int daBottom;
                                daBottom = getChildAt(0).getBottom();
                                int screenBottom;
                                screenBottom = getScrollY() + getHeight() - mPaddingBottom;
                                {
                                    scrollDelta = daBottom - screenBottom;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                doScrollY(direction == View.FOCUS_DOWN ? scrollDelta : -scrollDelta);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var42D708BBCBC43DF6E5AC106D419B282D_951748128 = (currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused));
            {
                final int descendantFocusability;
                descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "98AD346ACFBFFAEC79BE4B86F94546B3", hash_generated_method = "B455AD39822E0C4835629C9CBA82C109")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOffScreen(View descendant) {
        dsTaint.addTaint(descendant.dsTaint);
        boolean varE152D8C04578A7B6775C0B5DD4F62EE3_1036189723 = (!isWithinDeltaOfScreen(descendant, 0, getHeight()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !isWithinDeltaOfScreen(descendant, 0, getHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "472E587EAA6D318183AF3AB1B7CEF83F", hash_generated_method = "F5C46173A8AF027FB57F1288A3064609")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isWithinDeltaOfScreen(View descendant, int delta, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(delta);
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean varF9194AE0C6867682D5312FCB54F0ABEF_882610563 = ((mTempRect.bottom + delta) >= getScrollY()
                && (mTempRect.top - delta) <= (getScrollY() + height));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //return (mTempRect.bottom + delta) >= getScrollY()
                //&& (mTempRect.top - delta) <= (getScrollY() + height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "8E606864EB91DBB174E2D5FEBC80C80F", hash_generated_method = "64C1EB8CBA2DC8B0DA12A0A7B5104ED8")
    @DSModeled(DSC.SAFE)
    private void doScrollY(int delta) {
        dsTaint.addTaint(delta);
        {
            {
                smoothScrollBy(0, delta);
            } //End block
            {
                scrollBy(0, delta);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (delta != 0) {
            //if (mSmoothScrollingEnabled) {
                //smoothScrollBy(0, delta);
            //} else {
                //scrollBy(0, delta);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "2EB75EC7C5D47510D212013AE17ECAD9", hash_generated_method = "B24D0F35885FE138D1B6FD1E6A6FC29E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void smoothScrollBy(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        {
            boolean varF370735710C80808B6618BA2D491D045_621983673 = (getChildCount() == 0);
        } //End collapsed parenthetic
        long duration;
        duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        {
            final int height;
            height = getHeight() - mPaddingBottom - mPaddingTop;
            final int bottom;
            bottom = getChildAt(0).getHeight();
            final int maxY;
            maxY = Math.max(0, bottom - height);
            final int scrollY;
            scrollY = mScrollY;
            dy = Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY;
            mScroller.startScroll(mScrollX, scrollY, 0, dy);
            invalidate();
        } //End block
        {
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_676812470 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    {
                        mFlingStrictSpan.finish();
                        mFlingStrictSpan = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            scrollBy(dx, dy);
        } //End block
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "3FEB53AA60E6CAEF19AF305EC16C9F27")
    @DSModeled(DSC.SAFE)
    public final void smoothScrollTo(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        smoothScrollBy(x - mScrollX, y - mScrollY);
        // ---------- Original Method ----------
        //smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "91313F7EB1086727A920BA0C858900A2", hash_generated_method = "0C3E6474045BCC8F4F8E56B54B1A9F39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollRange() {
        final int count;
        count = getChildCount();
        final int contentHeight;
        contentHeight = getHeight() - mPaddingBottom - mPaddingTop;
        int scrollRange;
        scrollRange = getChildAt(0).getBottom();
        final int scrollY;
        scrollY = mScrollY;
        final int overscrollBottom;
        overscrollBottom = Math.max(0, scrollRange - contentHeight);
        {
            scrollRange -= scrollY;
        } //End block
        {
            scrollRange += scrollY - overscrollBottom;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final int contentHeight = getHeight() - mPaddingBottom - mPaddingTop;
        //if (count == 0) {
            //return contentHeight;
        //}
        //int scrollRange = getChildAt(0).getBottom();
        //final int scrollY = mScrollY;
        //final int overscrollBottom = Math.max(0, scrollRange - contentHeight);
        //if (scrollY < 0) {
            //scrollRange -= scrollY;
        //} else if (scrollY > overscrollBottom) {
            //scrollRange += scrollY - overscrollBottom;
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "3295CF5A20E98E4F1F0B32253FD00545", hash_generated_method = "DE06D4EB77DC8C789B40027A85CE607E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollOffset() {
        int varEB30566907E969E358CA3C9E47523092_1313241431 = (Math.max(0, super.computeVerticalScrollOffset()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(0, super.computeVerticalScrollOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.368 -0400", hash_original_method = "A9DFCA2E7D027D85128F33708BC045A3", hash_generated_method = "B3AEBCB0018857C2B43ED6E959635F31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        ViewGroup.LayoutParams lp;
        lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                + mPaddingRight, lp.width);
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = child.getLayoutParams();
        //int childWidthMeasureSpec;
        //int childHeightMeasureSpec;
        //childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, mPaddingLeft
                //+ mPaddingRight, lp.width);
        //childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.369 -0400", hash_original_method = "39312C7B222B807E39D76A29FDE3363F", hash_generated_method = "C5E4B83A77C3FC2C8B315A9F3D077D57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(widthUsed);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        dsTaint.addTaint(heightUsed);
        final MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec;
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        //+ widthUsed, lp.width);
        //final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                //lp.topMargin + lp.bottomMargin, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.369 -0400", hash_original_method = "71999091E2F6915A9DB2336BBDDFAF94", hash_generated_method = "3AF38505B7FFCBF560E1BB8F960DF90F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_1920660020 = (mScroller.computeScrollOffset());
            {
                int oldX;
                oldX = mScrollX;
                int oldY;
                oldY = mScrollY;
                int x;
                x = mScroller.getCurrX();
                int y;
                y = mScroller.getCurrY();
                {
                    final int range;
                    range = getScrollRange();
                    final int overscrollMode;
                    overscrollMode = getOverScrollMode();
                    final boolean canOverscroll;
                    canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
                    overScrollBy(x - oldX, y - oldY, oldX, oldY, 0, range,
                        0, mOverflingDistance, false);
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                    {
                        {
                            mEdgeGlowTop.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                        {
                            mEdgeGlowBottom.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                    } //End block
                } //End block
                awakenScrollBars();
                postInvalidate();
            } //End block
            {
                {
                    mFlingStrictSpan.finish();
                    mFlingStrictSpan = null;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.369 -0400", hash_original_method = "356AAB4A47E20FEC6EFC92C05FCA16CC", hash_generated_method = "7EFABBCEFA36DE065F0EA0584A50075A")
    @DSModeled(DSC.SAFE)
    private void scrollToChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta;
        scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        {
            scrollBy(0, scrollDelta);
        } //End block
        // ---------- Original Method ----------
        //child.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(child, mTempRect);
        //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        //if (scrollDelta != 0) {
            //scrollBy(0, scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.369 -0400", hash_original_method = "D69703D23BD1E07705411D82E1BC609A", hash_generated_method = "5ECDDE62ADB14CA80510F1EB4ED7D959")
    @DSModeled(DSC.SAFE)
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rect.dsTaint);
        final int delta;
        delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean scroll;
        scroll = delta != 0;
        {
            {
                scrollBy(0, delta);
            } //End block
            {
                smoothScrollBy(0, delta);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        //final boolean scroll = delta != 0;
        //if (scroll) {
            //if (immediate) {
                //scrollBy(0, delta);
            //} else {
                //smoothScrollBy(0, delta);
            //}
        //}
        //return scroll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "8A5FFBB9A861965CD3F605D3125E7C0B", hash_generated_method = "29472A87F47E2C5D4786D9424CB9C2F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        {
            boolean varF370735710C80808B6618BA2D491D045_447323449 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int height;
        height = getHeight();
        int screenTop;
        screenTop = getScrollY();
        int screenBottom;
        screenBottom = screenTop + height;
        int fadingEdge;
        fadingEdge = getVerticalFadingEdgeLength();
        {
            screenTop += fadingEdge;
        } //End block
        {
            boolean var21EF5215D3173B9EEA5879484954AC40_936784872 = (rect.bottom < getChildAt(0).getHeight());
            {
                screenBottom -= fadingEdge;
            } //End block
        } //End collapsed parenthetic
        int scrollYDelta;
        scrollYDelta = 0;
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_241585542 = (rect.height() > height);
                {
                    scrollYDelta += (rect.top - screenTop);
                } //End block
                {
                    scrollYDelta += (rect.bottom - screenBottom);
                } //End block
            } //End collapsed parenthetic
            int bottom;
            bottom = getChildAt(0).getBottom();
            int distanceToBottom;
            distanceToBottom = bottom - screenBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } //End block
        {
            {
                boolean var1852437954D6FC93B41EE304F855C339_1306451408 = (rect.height() > height);
                {
                    scrollYDelta -= (screenBottom - rect.bottom);
                } //End block
                {
                    scrollYDelta -= (screenTop - rect.top);
                } //End block
            } //End collapsed parenthetic
            scrollYDelta = Math.max(scrollYDelta, -getScrollY());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "2FB1A1A2E0BD233E251D0D558B1F6A30")
    @DSModeled(DSC.SAFE)
    @Override
    public void requestChildFocus(View child, View focused) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(focused.dsTaint);
        {
            scrollToChild(focused);
        } //End block
        super.requestChildFocus(child, focused);
        // ---------- Original Method ----------
        //if (!mIsLayoutDirty) {
            //scrollToChild(focused);
        //} else {
            //mChildToScrollTo = focused;
        //}
        //super.requestChildFocus(child, focused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "BC1790D54EF67B6E1EFAB03FC42BAB96", hash_generated_method = "EBA5C175962E03D4288802CEEFC61276")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            direction = View.FOCUS_DOWN;
        } //End block
        {
            direction = View.FOCUS_UP;
        } //End block
        final View nextFocus;
        nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        {
            boolean var2421F6D33436D75DDCB765DA8D416CB8_266949793 = (isOffScreen(nextFocus));
        } //End collapsed parenthetic
        boolean varBB06A889CCA25ED822B35181716FFE90_169700569 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (direction == View.FOCUS_FORWARD) {
            //direction = View.FOCUS_DOWN;
        //} else if (direction == View.FOCUS_BACKWARD) {
            //direction = View.FOCUS_UP;
        //}
        //final View nextFocus = previouslyFocusedRect == null ?
                //FocusFinder.getInstance().findNextFocus(this, null, direction) :
                //FocusFinder.getInstance().findNextFocusFromRect(this,
                        //previouslyFocusedRect, direction);
        //if (nextFocus == null) {
            //return false;
        //}
        //if (isOffScreen(nextFocus)) {
            //return false;
        //}
        //return nextFocus.requestFocus(direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "CCC0F3DE13F7580B1CB53CFD25FE5DAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(rectangle.dsTaint);
        dsTaint.addTaint(immediate);
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var9EED5F05118BACEED05952D173A9E219_478502313 = (scrollToChildRect(rectangle, immediate));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //rectangle.offset(child.getLeft() - child.getScrollX(),
                //child.getTop() - child.getScrollY());
        //return scrollToChildRect(rectangle, immediate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "9D7F044A5F29BF9BA2CF012CCA8E1404")
    @DSModeled(DSC.SAFE)
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        // ---------- Original Method ----------
        //mIsLayoutDirty = true;
        //super.requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "E0B1FFFA746AE76ECF17449388BCEBCA", hash_generated_method = "4E900B3225B743D31408A73E32924E5C")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } //End block
        {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mScrollStrictSpan != null) {
            //mScrollStrictSpan.finish();
            //mScrollStrictSpan = null;
        //}
        //if (mFlingStrictSpan != null) {
            //mFlingStrictSpan.finish();
            //mFlingStrictSpan = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "0C177C2B7175AC38BBDD46E9BE901255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        {
            boolean varFEFF39315B1161E387E3A3BC8A5B6333_998377988 = (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this));
            {
                scrollToChild(mChildToScrollTo);
            } //End block
        } //End collapsed parenthetic
        mChildToScrollTo = null;
        scrollTo(mScrollX, mScrollY);
        // ---------- Original Method ----------
        //super.onLayout(changed, l, t, r, b);
        //mIsLayoutDirty = false;
        //if (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this)) {
            //scrollToChild(mChildToScrollTo);
        //}
        //mChildToScrollTo = null;
        //scrollTo(mScrollX, mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.370 -0400", hash_original_method = "35BE22C8E7AB63B977E9EAA0D1A8EAA6", hash_generated_method = "A0075D36E34953C7D597596D5CC90BE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(h);
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused;
        currentFocused = findFocus();
        {
            boolean varCE6D2EB5D4D2223694B6B3F92A2E212D_1414050488 = (isWithinDeltaOfScreen(currentFocused, 0, oldh));
            {
                currentFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(currentFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollY(scrollDelta);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //View currentFocused = findFocus();
        //if (null == currentFocused || this == currentFocused)
            //return;
        //if (isWithinDeltaOfScreen(currentFocused, 0, oldh)) {
            //currentFocused.getDrawingRect(mTempRect);
            //offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            //doScrollY(scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.371 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "B130508AF2554D2B44C9D218DA202BB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isViewDescendantOf(View child, View parent) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        final ViewParent theParent;
        theParent = child.getParent();
        boolean var948A486C9D980B3FCF5DD6DC234D8E28_618184019 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.371 -0400", hash_original_method = "C7B4AEF12870EFF4E9873FB61486C527", hash_generated_method = "5A62320F60DF3B68C7CB27DC43B5CBBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fling(int velocityY) {
        dsTaint.addTaint(velocityY);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1880962520 = (getChildCount() > 0);
            {
                int height;
                height = getHeight() - mPaddingBottom - mPaddingTop;
                int bottom;
                bottom = getChildAt(0).getHeight();
                mScroller.fling(mScrollX, mScrollY, 0, velocityY, 0, 0, 0,
                    Math.max(0, bottom - height), 0, height/2);
                final boolean movingDown;
                movingDown = velocityY > 0;
                {
                    mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
                } //End block
                invalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //int height = getHeight() - mPaddingBottom - mPaddingTop;
            //int bottom = getChildAt(0).getHeight();
            //mScroller.fling(mScrollX, mScrollY, 0, velocityY, 0, 0, 0,
                    //Math.max(0, bottom - height), 0, height/2);
            //final boolean movingDown = velocityY > 0;
            //if (mFlingStrictSpan == null) {
                //mFlingStrictSpan = StrictMode.enterCriticalSpan("ScrollView-fling");
            //}
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.371 -0400", hash_original_method = "526DB7CB9D9E6BCF2CDE3F8A7F1D2890", hash_generated_method = "5378E7BF1351C996DFA61099DFE540FD")
    @DSModeled(DSC.SAFE)
    private void endDrag() {
        mIsBeingDragged = false;
        recycleVelocityTracker();
        {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        } //End block
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } //End block
        // ---------- Original Method ----------
        //mIsBeingDragged = false;
        //recycleVelocityTracker();
        //if (mEdgeGlowTop != null) {
            //mEdgeGlowTop.onRelease();
            //mEdgeGlowBottom.onRelease();
        //}
        //if (mScrollStrictSpan != null) {
            //mScrollStrictSpan.finish();
            //mScrollStrictSpan = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.371 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "D16E2D3C60C8E56BB72A9A43A102BC05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void scrollTo(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_369677421 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
                y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
                {
                    super.scrollTo(x, y);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
            //y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
            //if (x != mScrollX || y != mScrollY) {
                //super.scrollTo(x, y);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.371 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "49E4C3EEDA409DC13AA987494CC17B17")
    @DSModeled(DSC.SAFE)
    @Override
    public void setOverScrollMode(int mode) {
        dsTaint.addTaint(mode);
        {
            {
                Context context;
                context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } //End block
        } //End block
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } //End block
        super.setOverScrollMode(mode);
        // ---------- Original Method ----------
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mEdgeGlowTop == null) {
                //Context context = getContext();
                //mEdgeGlowTop = new EdgeEffect(context);
                //mEdgeGlowBottom = new EdgeEffect(context);
            //}
        //} else {
            //mEdgeGlowTop = null;
            //mEdgeGlowBottom = null;
        //}
        //super.setOverScrollMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.372 -0400", hash_original_method = "50FAD524FA6B782881C70ABEF15C4DDF", hash_generated_method = "BEC28F22B9DA804ECD8577BC7F4185A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        super.draw(canvas);
        {
            final int scrollY;
            scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_1279595428 = (!mEdgeGlowTop.isFinished());
                {
                    final int restoreCount;
                    restoreCount = canvas.save();
                    final int width;
                    width = getWidth() - mPaddingLeft - mPaddingRight;
                    canvas.translate(mPaddingLeft, Math.min(0, scrollY));
                    mEdgeGlowTop.setSize(width, getHeight());
                    {
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_1961450636 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_1643073205 = (!mEdgeGlowBottom.isFinished());
                {
                    final int restoreCount;
                    restoreCount = canvas.save();
                    final int width;
                    width = getWidth() - mPaddingLeft - mPaddingRight;
                    final int height;
                    height = getHeight();
                    canvas.translate(-width + mPaddingLeft,
                        Math.max(getScrollRange(), scrollY) + height);
                    canvas.rotate(180, width, 0);
                    mEdgeGlowBottom.setSize(width, height);
                    {
                        boolean var61CCF9557D478E1494862B3636E22888_2123303654 = (mEdgeGlowBottom.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.372 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "CAD59239F988986D9F039D07D2F75341")
    @DSModeled(DSC.SAFE)
    private int clamp(int n, int my, int child) {
        dsTaint.addTaint(child);
        dsTaint.addTaint(n);
        dsTaint.addTaint(my);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (my >= child || n < 0) {
            //return 0;
        //}
        //if ((my+n) > child) {
            //return child-my;
        //}
        //return n;
    }

    
}


