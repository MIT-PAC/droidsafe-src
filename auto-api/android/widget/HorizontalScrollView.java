package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
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

public class HorizontalScrollView extends FrameLayout {
    private long mLastScroll;
    private Rect mTempRect = new Rect();
    private OverScroller mScroller;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;
    private float mLastMotionX;
    private boolean mIsLayoutDirty = true;
    private View mChildToScrollTo = null;
    private boolean mIsBeingDragged = false;
    private VelocityTracker mVelocityTracker;
    @ViewDebug.ExportedProperty(category = "layout") private boolean mFillViewport;
    private boolean mSmoothScrollingEnabled = true;
    private int mTouchSlop;
    private int mMinimumVelocity;
    private int mMaximumVelocity;
    private int mOverscrollDistance;
    private int mOverflingDistance;
    private int mActivePointerId = INVALID_POINTER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.084 -0400", hash_original_method = "D579CCE5E39252987369F5EF7BC67FC0", hash_generated_method = "01D1F3FD24DF35D9913C116497D6AD53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HorizontalScrollView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.084 -0400", hash_original_method = "7F7EA51B0CF52F1D171B225CFAE9439C", hash_generated_method = "A550290976C42926A2EB9A688B9AAAC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.horizontalScrollViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.085 -0400", hash_original_method = "ABF3CE2040AE9A0702C38DF91EEF10E7", hash_generated_method = "C0A898F412625A757B83C891A677D7B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        initScrollView();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                android.R.styleable.HorizontalScrollView, defStyle, 0);
        setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        a.recycle();
        // ---------- Original Method ----------
        //initScrollView();
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //android.R.styleable.HorizontalScrollView, defStyle, 0);
        //setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.085 -0400", hash_original_method = "041555434146A9B8485461655BD1A318", hash_generated_method = "F68EBF9AB0F658294EAC2EEE378D934D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getLeftFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_1865650394 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int length;
        length = getHorizontalFadingEdgeLength();
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getHorizontalFadingEdgeLength();
        //if (mScrollX < length) {
            //return mScrollX / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.085 -0400", hash_original_method = "AC1CCEB780F155A105BA88465002385B", hash_generated_method = "F05466B351B37411B14537E884FA53A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getRightFadingEdgeStrength() {
        {
            boolean varF370735710C80808B6618BA2D491D045_1849276883 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int length;
        length = getHorizontalFadingEdgeLength();
        int rightEdge;
        rightEdge = getWidth() - mPaddingRight;
        int span;
        span = getChildAt(0).getRight() - mScrollX - rightEdge;
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (getChildCount() == 0) {
            //return 0.0f;
        //}
        //final int length = getHorizontalFadingEdgeLength();
        //final int rightEdge = getWidth() - mPaddingRight;
        //final int span = getChildAt(0).getRight() - mScrollX - rightEdge;
        //if (span < length) {
            //return span / (float) length;
        //}
        //return 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.086 -0400", hash_original_method = "F72D9B4700B8FCB550AB26E9792E603C", hash_generated_method = "2BB351F7F59BA2E029DAB6666FA4D3AD")
    @DSModeled(DSC.SAFE)
    public int getMaxScrollAmount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) (MAX_SCROLL_FACTOR * (mRight - mLeft));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.086 -0400", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "8A03164972DE1A24C8B4AD83E152C23B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initScrollView() {
        mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setWillNotDraw(false);
        ViewConfiguration configuration;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.086 -0400", hash_original_method = "28BB619967A3B168E514D899D7C1C204", hash_generated_method = "9C50BD036BC8E09B8222917BA1FB5447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_157245730 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.086 -0400", hash_original_method = "D082E00953E9B886F1BBE563E072EA76", hash_generated_method = "2F9945BC633C68FBDD86F155407FFE28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1251464052 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.087 -0400", hash_original_method = "35F41E1C04BFB475A60C431B3898F857", hash_generated_method = "0F5F213367BA61BD41A903703ADAE82F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_989342180 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.087 -0400", hash_original_method = "D331A2B6162E307FE1F025F2ABEA7C28", hash_generated_method = "F69B4DF0BAC2AF708B248586F9AB4D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_2077483443 = (getChildCount() > 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HorizontalScrollView can host only one direct child");
            } //End block
        } //End collapsed parenthetic
        super.addView(child, index, params);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        //}
        //super.addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.087 -0400", hash_original_method = "3DE53F922B0BEA48963A7A11A88BC712", hash_generated_method = "0DD7DCEAB94DEECA75280342FF783A2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canScroll() {
        View child;
        child = getChildAt(0);
        {
            int childWidth;
            childWidth = child.getWidth();
            boolean varA6C40242804D94D2C9C8F4BFEFCFD006_2073855076 = (getWidth() < childWidth + mPaddingLeft + mPaddingRight);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //View child = getChildAt(0);
        //if (child != null) {
            //int childWidth = child.getWidth();
            //return getWidth() < childWidth + mPaddingLeft + mPaddingRight ;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.087 -0400", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "CB0887D69F4F5F65BBCF8E439F5F7ECD")
    @DSModeled(DSC.SAFE)
    public boolean isFillViewport() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFillViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.087 -0400", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "C16E6F3A029E3B657AA73FB3A1344454")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.088 -0400", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "86EFEED6FB5BB63AFD80EC7D8588D564")
    @DSModeled(DSC.SAFE)
    public boolean isSmoothScrollingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSmoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.088 -0400", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "749A8A4CEF1845F2D53551775AF9147F")
    @DSModeled(DSC.SAFE)
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        dsTaint.addTaint(smoothScrollingEnabled);
        // ---------- Original Method ----------
        //mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.088 -0400", hash_original_method = "1306D2831DF4DA9A5EDAD3DA6127274D", hash_generated_method = "08453177AA7CCF11CF11D8E638A2C210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_443113567 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                int width;
                width = getMeasuredWidth();
                {
                    boolean varBA5E95C6C7C7E6CFE039E1AE81F2A9F7_1184062189 = (child.getMeasuredWidth() < width);
                    {
                        FrameLayout.LayoutParams lp;
                        lp = (LayoutParams) child.getLayoutParams();
                        int childHeightMeasureSpec;
                        childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, mPaddingTop
                        + mPaddingBottom, lp.height);
                        width -= mPaddingLeft;
                        width -= mPaddingRight;
                        int childWidthMeasureSpec;
                        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
                        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.088 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "3709BD35239981343601EC0DE6429B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean var160A6DCE359009EE36E492A233BEB313_1540898941 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.089 -0400", hash_original_method = "59EE8B926A303894927E6FAD605B1FF1", hash_generated_method = "00CDE93260FF73FC1EC68062B5A37121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean executeKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        mTempRect.setEmpty();
        {
            boolean varF142AAB9B9E2812C95D81D43568D13C8_1294761050 = (!canScroll());
            {
                {
                    boolean var807A689000786E69147E7D957AAAFB6F_83972395 = (isFocused());
                    {
                        View currentFocused;
                        currentFocused = findFocus();
                        {
                            boolean varCCA9B61B8A448B09DE583C4C7BFDEFBB_614420001 = (currentFocused == this);
                            currentFocused = null;
                        } //End collapsed parenthetic
                        View nextFocused;
                        nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_RIGHT);
                        boolean varE3066A006DC54F43B369F4B21A267608_464730130 = (nextFocused != null && nextFocused != this &&
                        nextFocused.requestFocus(View.FOCUS_RIGHT));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean handled;
        handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_876111847 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_2052093352 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_323100255 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_LEFT);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_LEFT);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    {
                        boolean var6263B7F37C2CF1348DCC37C937DB4EA5_454537235 = (!event.isAltPressed());
                        {
                            handled = arrowScroll(View.FOCUS_RIGHT);
                        } //End block
                        {
                            handled = fullScroll(View.FOCUS_RIGHT);
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_SPACE 
                    pageScroll(event.isShiftPressed() ? View.FOCUS_LEFT : View.FOCUS_RIGHT);
                    //End case KeyEvent.KEYCODE_SPACE 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.089 -0400", hash_original_method = "9319BD4BC402BC56524E94C60EDF0AE3", hash_generated_method = "3B2F196CAB33D0B0B914BBD15A46AAB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean inChild(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1969905835 = (getChildCount() > 0);
            {
                int scrollX;
                scrollX = mScrollX;
                View child;
                child = getChildAt(0);
                boolean var39E4E21670022FBDEFC34F7F342484F1_151515069 = (!(y < child.getTop()
                    || y >= child.getBottom()
                    || x < child.getLeft() - scrollX
                    || x >= child.getRight() - scrollX));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //final int scrollX = mScrollX;
            //final View child = getChildAt(0);
            //return !(y < child.getTop()
                    //|| y >= child.getBottom()
                    //|| x < child.getLeft() - scrollX
                    //|| x >= child.getRight() - scrollX);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.089 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.090 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.090 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.090 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "865CE72BE478ED109800CF1DEE433CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.091 -0400", hash_original_method = "B8EBEABAF4D085F1DC9FA2F6547DBF28", hash_generated_method = "2E09065DEF9FC4660024AD343D84F8E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        int action;
        action = ev.getAction();
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int activePointerId;
            activePointerId = mActivePointerId;
            int pointerIndex;
            pointerIndex = ev.findPointerIndex(activePointerId);
            float x;
            x = ev.getX(pointerIndex);
            int xDiff;
            xDiff = (int) Math.abs(x - mLastMotionX);
            {
                mIsBeingDragged = true;
                mLastMotionX = x;
                initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(ev);
                mParent.requestDisallowInterceptTouchEvent(true);
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            float x;
            x = ev.getX();
            {
                boolean var3405975BC361ED70AE7E5B2027F4D35B_974560837 = (!inChild((int) x, (int) ev.getY()));
                {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                } //End block
            } //End collapsed parenthetic
            mLastMotionX = x;
            mActivePointerId = ev.getPointerId(0);
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
            mIsBeingDragged = !mScroller.isFinished();
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mIsBeingDragged = false;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        mActivePointerId = INVALID_POINTER;
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        {
            boolean varEE5121167538D55FE2ED747573ECA340_1817859360 = (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_POINTER_DOWN 
        {
            int index;
            index = ev.getActionIndex();
            mLastMotionX = ev.getX(index);
            mActivePointerId = ev.getPointerId(index);
        } //End block
        //End case MotionEvent.ACTION_POINTER_DOWN 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        mLastMotionX = ev.getX(ev.findPointerIndex(mActivePointerId));
        //End case MotionEvent.ACTION_POINTER_UP 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.092 -0400", hash_original_method = "DC232709D0DE420641FAAFB6B744429B", hash_generated_method = "005BB26BB8B71B35AF615B2E914DE090")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        int action;
        action = ev.getAction();
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mIsBeingDragged = getChildCount() != 0;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1564015812 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                } //End block
            } //End collapsed parenthetic
            mLastMotionX = ev.getX();
            mActivePointerId = ev.getPointerId(0);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int activePointerIndex;
            activePointerIndex = ev.findPointerIndex(mActivePointerId);
            float x;
            x = ev.getX(activePointerIndex);
            int deltaX;
            deltaX = (int) (mLastMotionX - x);
            mLastMotionX = x;
            int oldX;
            oldX = mScrollX;
            int oldY;
            oldY = mScrollY;
            int range;
            range = getScrollRange();
            int overscrollMode;
            overscrollMode = getOverScrollMode();
            boolean canOverscroll;
            canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
            {
                boolean var4673405DB318F577EB775B557DA805F2_1668201376 = (overScrollBy(deltaX, 0, mScrollX, 0, range, 0,
                            mOverscrollDistance, 0, true));
                {
                    mVelocityTracker.clear();
                } //End block
            } //End collapsed parenthetic
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                int pulledToX;
                pulledToX = oldX + deltaX;
                {
                    mEdgeGlowLeft.onPull((float) deltaX / getWidth());
                    {
                        boolean varD2DEBDA1B3BE7D590185C2C37852D200_799103038 = (!mEdgeGlowRight.isFinished());
                        {
                            mEdgeGlowRight.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowRight.onPull((float) deltaX / getWidth());
                    {
                        boolean varD07D7885146F53648F473CE045927D93_875601961 = (!mEdgeGlowLeft.isFinished());
                        {
                            mEdgeGlowLeft.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var5D2E730F9B7FB13C61A16574D0E5ADB7_2070443759 = (mEdgeGlowLeft != null
                                && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            VelocityTracker velocityTracker;
            velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity;
            initialVelocity = (int) velocityTracker.getXVelocity(mActivePointerId);
            {
                boolean var9C190A50DA656473F4A85C2EF380F022_911068474 = (getChildCount() > 0);
                {
                    {
                        boolean varCB55D3BE2E93A2FD55EF78A581740AFC_270262342 = ((Math.abs(initialVelocity) > mMinimumVelocity));
                        {
                            fling(-initialVelocity);
                        } //End block
                        {
                            {
                                boolean var620455B046FC74D8EB536096D28363E6_680904309 = (mScroller.springBack(mScrollX, mScrollY, 0,
                                    getScrollRange(), 0, 0));
                                {
                                    invalidate();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mActivePointerId = INVALID_POINTER;
            mIsBeingDragged = false;
            recycleVelocityTracker();
            {
                mEdgeGlowLeft.onRelease();
                mEdgeGlowRight.onRelease();
            } //End block
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            boolean var9286919EB531712C93F03BFB604683F8_1594357390 = (mIsBeingDragged && getChildCount() > 0);
            {
                {
                    boolean var22BD84039EB304B13BC2A1C6684C6C6D_700036080 = (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
                mActivePointerId = INVALID_POINTER;
                mIsBeingDragged = false;
                recycleVelocityTracker();
                {
                    mEdgeGlowLeft.onRelease();
                    mEdgeGlowRight.onRelease();
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_CANCEL 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEvent.ACTION_POINTER_UP 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.092 -0400", hash_original_method = "15678E7D87FCB5B2E2A6D15F2CBAE390", hash_generated_method = "1E3ADD3A14574F385FC07F5255EDA665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSecondaryPointerUp(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        int pointerIndex;
        pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        int pointerId;
        pointerId = ev.getPointerId(pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mLastMotionX = ev.getX(newPointerIndex);
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
            //mLastMotionX = ev.getX(newPointerIndex);
            //mActivePointerId = ev.getPointerId(newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.093 -0400", hash_original_method = "EA19C55D5CBC44B40040771841401365", hash_generated_method = "D1968C67F01EF6C8100A449B7F5357CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_2082202346 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_2132631811 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            float hscroll;
                            {
                                boolean varB081D4C178A0E24C7934472C47298D77_735509016 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                                {
                                    hscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                } //End block
                                {
                                    hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                int delta;
                                delta = (int) (hscroll * getHorizontalScrollFactor());
                                int range;
                                range = getScrollRange();
                                int oldScrollX;
                                oldScrollX = mScrollX;
                                int newScrollX;
                                newScrollX = oldScrollX + delta;
                                {
                                    newScrollX = 0;
                                } //End block
                                {
                                    newScrollX = range;
                                } //End block
                                {
                                    super.scrollTo(newScrollX, mScrollY);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_2105579839 = (super.onGenericMotionEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.093 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "EC67567EC5C07259C01BC902C6E9E285")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.093 -0400", hash_original_method = "06CAD3F9DAB24C265A0AAEC7445D85D7", hash_generated_method = "D1F3CB41B477C30F56241D80A64A86F3")
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
            boolean var2844BA5E42FD344CC642021B350DFDAC_1273994388 = (!mScroller.isFinished());
            {
                mScrollX = scrollX;
                mScrollY = scrollY;
                invalidateParentIfNeeded();
                {
                    mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
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
            //if (clampedX) {
                //mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
            //}
        //} else {
            //super.scrollTo(scrollX, scrollY);
        //}
        //awakenScrollBars();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.093 -0400", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "E1E28C5FAAD273D373CA9CE484352C1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.094 -0400", hash_original_method = "7DA515169DBC462D06A7F08F561D2E84", hash_generated_method = "AEEEFC40F1926F066F160BAD08312808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(getScrollRange() > 0);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(mScrollY);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(getScrollRange() > 0);
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //event.setMaxScrollX(getScrollRange());
        //event.setMaxScrollY(mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.094 -0400", hash_original_method = "6035917F8C30F3A1C02AFED333ACB352", hash_generated_method = "8B98FCD717BAA5F74CFBC016FF4AFDE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getScrollRange() {
        int scrollRange;
        scrollRange = 0;
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_441217715 = (getChildCount() > 0);
            {
                View child;
                child = getChildAt(0);
                scrollRange = Math.max(0,
                    child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int scrollRange = 0;
        //if (getChildCount() > 0) {
            //View child = getChildAt(0);
            //scrollRange = Math.max(0,
                    //child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.094 -0400", hash_original_method = "B34C300D12B589B0218EA4927548AE87", hash_generated_method = "EF23AD5537DAA8D205757DB2504577E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findFocusableViewInMyBounds(final boolean leftFocus,
            final int left, View preferredFocusable) {
        dsTaint.addTaint(preferredFocusable.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(leftFocus);
        int fadingEdgeLength;
        fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int leftWithoutFadingEdge;
        leftWithoutFadingEdge = left + fadingEdgeLength;
        int rightWithoutFadingEdge;
        rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;
        {
            boolean var7D87B4F60FE19E28B97792EEA30CCEF8_284156225 = ((preferredFocusable != null)
                && (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                && (preferredFocusable.getRight() > leftWithoutFadingEdge));
        } //End collapsed parenthetic
        View var7E51332D1E34A5225F78D2EA86671F23_2100020936 = (findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                rightWithoutFadingEdge));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        //final int leftWithoutFadingEdge = left + fadingEdgeLength;
        //final int rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;
        //if ((preferredFocusable != null)
                //&& (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                //&& (preferredFocusable.getRight() > leftWithoutFadingEdge)) {
            //return preferredFocusable;
        //}
        //return findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                //rightWithoutFadingEdge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.095 -0400", hash_original_method = "CFAC89DA51B9853AC14992D421225DFD", hash_generated_method = "CB04340E097D862D86D6206FA69D87B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findFocusableViewInBounds(boolean leftFocus, int left, int right) {
        dsTaint.addTaint(left);
        dsTaint.addTaint(leftFocus);
        dsTaint.addTaint(right);
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
                int viewLeft;
                viewLeft = view.getLeft();
                int viewRight;
                viewRight = view.getRight();
                {
                    boolean viewIsFullyContained;
                    viewIsFullyContained = (left < viewLeft) &&
                        (viewRight < right);
                    {
                        focusCandidate = view;
                        foundFullyContainedFocusable = viewIsFullyContained;
                    } //End block
                    {
                        boolean viewIsCloserToBoundary;
                        viewIsCloserToBoundary = (leftFocus && viewLeft < focusCandidate.getLeft()) ||
                                    (!leftFocus && viewRight > focusCandidate.getRight());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.095 -0400", hash_original_method = "DA183CDCD6EA3DA10063DE059735FFD7", hash_generated_method = "0395932099A06AC6445A50711A6A75F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pageScroll(int direction) {
        dsTaint.addTaint(direction);
        boolean right;
        right = direction == View.FOCUS_RIGHT;
        int width;
        width = getWidth();
        {
            mTempRect.left = getScrollX() + width;
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(0);
                {
                    boolean var8C78AEBAFA30CD197C035E0F448FF2FC_642818379 = (mTempRect.left + width > view.getRight());
                    {
                        mTempRect.left = view.getRight() - width;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            mTempRect.left = getScrollX() - width;
            {
                mTempRect.left = 0;
            } //End block
        } //End block
        mTempRect.right = mTempRect.left + width;
        boolean var4D73DD7FC50DAF2C1DFAEF953A983AC8_2093680642 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean right = direction == View.FOCUS_RIGHT;
        //int width = getWidth();
        //if (right) {
            //mTempRect.left = getScrollX() + width;
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(0);
                //if (mTempRect.left + width > view.getRight()) {
                    //mTempRect.left = view.getRight() - width;
                //}
            //}
        //} else {
            //mTempRect.left = getScrollX() - width;
            //if (mTempRect.left < 0) {
                //mTempRect.left = 0;
            //}
        //}
        //mTempRect.right = mTempRect.left + width;
        //return scrollAndFocus(direction, mTempRect.left, mTempRect.right);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.095 -0400", hash_original_method = "13724385C240165AD29E108B78F9E99D", hash_generated_method = "A9DAC17AF84EB5D02D22AC5031AAC639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean fullScroll(int direction) {
        dsTaint.addTaint(direction);
        boolean right;
        right = direction == View.FOCUS_RIGHT;
        int width;
        width = getWidth();
        mTempRect.left = 0;
        mTempRect.right = width;
        {
            int count;
            count = getChildCount();
            {
                View view;
                view = getChildAt(0);
                mTempRect.right = view.getRight();
                mTempRect.left = mTempRect.right - width;
            } //End block
        } //End block
        boolean var4D73DD7FC50DAF2C1DFAEF953A983AC8_1621598109 = (scrollAndFocus(direction, mTempRect.left, mTempRect.right));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean right = direction == View.FOCUS_RIGHT;
        //int width = getWidth();
        //mTempRect.left = 0;
        //mTempRect.right = width;
        //if (right) {
            //int count = getChildCount();
            //if (count > 0) {
                //View view = getChildAt(0);
                //mTempRect.right = view.getRight();
                //mTempRect.left = mTempRect.right - width;
            //}
        //}
        //return scrollAndFocus(direction, mTempRect.left, mTempRect.right);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.096 -0400", hash_original_method = "DF3968C57E4B66E8EEB56F2D4C42BFD9", hash_generated_method = "0C9512D0FAE8F834C8FA20A87EDC7DA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean scrollAndFocus(int direction, int left, int right) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        boolean handled;
        handled = true;
        int width;
        width = getWidth();
        int containerLeft;
        containerLeft = getScrollX();
        int containerRight;
        containerRight = containerLeft + width;
        boolean goLeft;
        goLeft = direction == View.FOCUS_LEFT;
        View newFocused;
        newFocused = findFocusableViewInBounds(goLeft, left, right);
        {
            newFocused = this;
        } //End block
        {
            handled = false;
        } //End block
        {
            int delta;
            delta = (left - containerLeft);
            delta = (right - containerRight);
            doScrollX(delta);
        } //End block
        {
            boolean var2DF5574E3AD9AB6AAA9DDD6415AB9F2D_1669012795 = (newFocused != findFocus());
            newFocused.requestFocus(direction);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean handled = true;
        //int width = getWidth();
        //int containerLeft = getScrollX();
        //int containerRight = containerLeft + width;
        //boolean goLeft = direction == View.FOCUS_LEFT;
        //View newFocused = findFocusableViewInBounds(goLeft, left, right);
        //if (newFocused == null) {
            //newFocused = this;
        //}
        //if (left >= containerLeft && right <= containerRight) {
            //handled = false;
        //} else {
            //int delta = goLeft ? (left - containerLeft) : (right - containerRight);
            //doScrollX(delta);
        //}
        //if (newFocused != findFocus()) newFocused.requestFocus(direction);
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.096 -0400", hash_original_method = "ED0B7D3300F52C8B0FEFDD6EE298A1FB", hash_generated_method = "53AE467D2BCED99437BAE3D7315DAAE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean arrowScroll(int direction) {
        dsTaint.addTaint(direction);
        View currentFocused;
        currentFocused = findFocus();
        {
            boolean varF85CA3EE0100E1E3C5B0606F6BE9D9A9_207539362 = (currentFocused == this);
            currentFocused = null;
        } //End collapsed parenthetic
        View nextFocused;
        nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        int maxJump;
        maxJump = getMaxScrollAmount();
        {
            boolean var2292435FA822AB146936012380ED5BBB_1194367328 = (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump));
            {
                nextFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(nextFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollX(scrollDelta);
                nextFocused.requestFocus(direction);
            } //End block
            {
                int scrollDelta;
                scrollDelta = maxJump;
                {
                    boolean var3623D08ACBADBF97DF4231DD021A3251_1213378039 = (direction == View.FOCUS_LEFT && getScrollX() < scrollDelta);
                    {
                        scrollDelta = getScrollX();
                    } //End block
                    {
                        boolean var31DDA0576A919784AA2E33F0C157B20A_898533524 = (direction == View.FOCUS_RIGHT && getChildCount() > 0);
                        {
                            int daRight;
                            daRight = getChildAt(0).getRight();
                            int screenRight;
                            screenRight = getScrollX() + getWidth();
                            {
                                scrollDelta = daRight - screenRight;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                doScrollX(direction == View.FOCUS_RIGHT ? scrollDelta : -scrollDelta);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var42D708BBCBC43DF6E5AC106D419B282D_1180294512 = (currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused));
            {
                int descendantFocusability;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.097 -0400", hash_original_method = "E39461866A28C70AD36F56E791C6BE3B", hash_generated_method = "A9D73FFFAB46ED09A2823BF5761C26AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOffScreen(View descendant) {
        dsTaint.addTaint(descendant.dsTaint);
        boolean var3CCD939A38ACEEE7749282D1DF99CC78_1788180975 = (!isWithinDeltaOfScreen(descendant, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !isWithinDeltaOfScreen(descendant, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.097 -0400", hash_original_method = "47CB02AABD47C9E7AF2DCBC38CD370E2", hash_generated_method = "BE7AD399E7DD4B5576C9BAB2BE6EE368")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(delta);
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        boolean var05C136A6ECA4FF0F2BC7726A4BFA46FE_1959428313 = ((mTempRect.right + delta) >= getScrollX()
                && (mTempRect.left - delta) <= (getScrollX() + getWidth()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //descendant.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(descendant, mTempRect);
        //return (mTempRect.right + delta) >= getScrollX()
                //&& (mTempRect.left - delta) <= (getScrollX() + getWidth());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.097 -0400", hash_original_method = "3F16B27E18A709EC962C39AF363F3965", hash_generated_method = "BC0E7913FA3956E9B2FDC63B03C877D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doScrollX(int delta) {
        dsTaint.addTaint(delta);
        {
            {
                smoothScrollBy(delta, 0);
            } //End block
            {
                scrollBy(delta, 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (delta != 0) {
            //if (mSmoothScrollingEnabled) {
                //smoothScrollBy(delta, 0);
            //} else {
                //scrollBy(delta, 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.097 -0400", hash_original_method = "DAE9EEC093475C9AC0229EA6C3F406DC", hash_generated_method = "6EC0E67493B6A2CBED27CCCC2E7579CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void smoothScrollBy(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        {
            boolean varF370735710C80808B6618BA2D491D045_441217640 = (getChildCount() == 0);
        } //End collapsed parenthetic
        long duration;
        duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        {
            int width;
            width = getWidth() - mPaddingRight - mPaddingLeft;
            int right;
            right = getChildAt(0).getWidth();
            int maxX;
            maxX = Math.max(0, right - width);
            int scrollX;
            scrollX = mScrollX;
            dx = Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX;
            mScroller.startScroll(scrollX, mScrollY, dx, 0);
            invalidate();
        } //End block
        {
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1741032791 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                } //End block
            } //End collapsed parenthetic
            scrollBy(dx, dy);
        } //End block
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.098 -0400", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "699B8678B40EF4F26170AEAABF8952A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void smoothScrollTo(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        smoothScrollBy(x - mScrollX, y - mScrollY);
        // ---------- Original Method ----------
        //smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.098 -0400", hash_original_method = "344907C67A02819CC7A230367AD45761", hash_generated_method = "0E468F1E117DEADDEAD6EB582C95F682")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeHorizontalScrollRange() {
        int count;
        count = getChildCount();
        int contentWidth;
        contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        int scrollRange;
        scrollRange = getChildAt(0).getRight();
        int scrollX;
        scrollX = mScrollX;
        int overscrollRight;
        overscrollRight = Math.max(0, scrollRange - contentWidth);
        {
            scrollRange -= scrollX;
        } //End block
        {
            scrollRange += scrollX - overscrollRight;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final int contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        //if (count == 0) {
            //return contentWidth;
        //}
        //int scrollRange = getChildAt(0).getRight();
        //final int scrollX = mScrollX;
        //final int overscrollRight = Math.max(0, scrollRange - contentWidth);
        //if (scrollX < 0) {
            //scrollRange -= scrollX;
        //} else if (scrollX > overscrollRight) {
            //scrollRange += scrollX - overscrollRight;
        //}
        //return scrollRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.098 -0400", hash_original_method = "9CF354C1D07DBC59A9E2E44E57F7657B", hash_generated_method = "A30E6B9D0B616F673F3B407135E72764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeHorizontalScrollOffset() {
        int var7A9951C5866872080505940D11B99587_1560087130 = (Math.max(0, super.computeHorizontalScrollOffset()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(0, super.computeHorizontalScrollOffset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.098 -0400", hash_original_method = "1A4819189D92B65ABF3F692114902ED1", hash_generated_method = "DFC69D98E4BA69DA4ADD43D11C8B09FE")
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
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                + mPaddingBottom, lp.height);
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //ViewGroup.LayoutParams lp = child.getLayoutParams();
        //int childWidthMeasureSpec;
        //int childHeightMeasureSpec;
        //childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                //+ mPaddingBottom, lp.height);
        //childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.099 -0400", hash_original_method = "0EA8DFEAF2643806863B304E52EE38A5", hash_generated_method = "EDF28315BDD51D68D8A844F8594F4F44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(widthUsed);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        dsTaint.addTaint(heightUsed);
        MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        int childWidthMeasureSpec;
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        //+ heightUsed, lp.height);
        //final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                //lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.099 -0400", hash_original_method = "D30258BCA66C5E19407EB248DA88CE03", hash_generated_method = "3A2BB5F975DEF89A90350335AD630CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_1559148961 = (mScroller.computeScrollOffset());
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
                    int range;
                    range = getScrollRange();
                    int overscrollMode;
                    overscrollMode = getOverScrollMode();
                    boolean canOverscroll;
                    canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);
                    overScrollBy(x - oldX, y - oldY, oldX, oldY, range, 0,
                        mOverflingDistance, 0, false);
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);
                    {
                        {
                            mEdgeGlowLeft.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                        {
                            mEdgeGlowRight.onAbsorb((int) mScroller.getCurrVelocity());
                        } //End block
                    } //End block
                } //End block
                awakenScrollBars();
                postInvalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.099 -0400", hash_original_method = "988A7EC33B56EE551974E7C841966101", hash_generated_method = "C000CE242E8C9606DA3B37B6384D193E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void scrollToChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        child.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(child, mTempRect);
        int scrollDelta;
        scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        {
            scrollBy(scrollDelta, 0);
        } //End block
        // ---------- Original Method ----------
        //child.getDrawingRect(mTempRect);
        //offsetDescendantRectToMyCoords(child, mTempRect);
        //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        //if (scrollDelta != 0) {
            //scrollBy(scrollDelta, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.100 -0400", hash_original_method = "07633DDCD66F05F9C6104D95040C4376", hash_generated_method = "74E0470A6990024CEA4CB9DDA868B24D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rect.dsTaint);
        int delta;
        delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean scroll;
        scroll = delta != 0;
        {
            {
                scrollBy(delta, 0);
            } //End block
            {
                smoothScrollBy(delta, 0);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        //final boolean scroll = delta != 0;
        //if (scroll) {
            //if (immediate) {
                //scrollBy(delta, 0);
            //} else {
                //smoothScrollBy(delta, 0);
            //}
        //}
        //return scroll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.100 -0400", hash_original_method = "8C5AA93676CE0EF7515972F93F61C0B6", hash_generated_method = "D3A68B84AF3074C9398F9E797C610617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        {
            boolean varF370735710C80808B6618BA2D491D045_247407010 = (getChildCount() == 0);
        } //End collapsed parenthetic
        int width;
        width = getWidth();
        int screenLeft;
        screenLeft = getScrollX();
        int screenRight;
        screenRight = screenLeft + width;
        int fadingEdge;
        fadingEdge = getHorizontalFadingEdgeLength();
        {
            screenLeft += fadingEdge;
        } //End block
        {
            boolean var111E177520853BA7F7EEE5AEE5221F06_1492038641 = (rect.right < getChildAt(0).getWidth());
            {
                screenRight -= fadingEdge;
            } //End block
        } //End collapsed parenthetic
        int scrollXDelta;
        scrollXDelta = 0;
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_1652727632 = (rect.width() > width);
                {
                    scrollXDelta += (rect.left - screenLeft);
                } //End block
                {
                    scrollXDelta += (rect.right - screenRight);
                } //End block
            } //End collapsed parenthetic
            int right;
            right = getChildAt(0).getRight();
            int distanceToRight;
            distanceToRight = right - screenRight;
            scrollXDelta = Math.min(scrollXDelta, distanceToRight);
        } //End block
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_1541476691 = (rect.width() > width);
                {
                    scrollXDelta -= (screenRight - rect.right);
                } //End block
                {
                    scrollXDelta -= (screenLeft - rect.left);
                } //End block
            } //End collapsed parenthetic
            scrollXDelta = Math.max(scrollXDelta, -getScrollX());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.101 -0400", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "7909ED56E97BBD9A15260169C5AADEE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.102 -0400", hash_original_method = "4857D3DE9468292A125F69FE9ECFC007", hash_generated_method = "A61F1C41F1041CD5437193C56030F638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            direction = View.FOCUS_RIGHT;
        } //End block
        {
            direction = View.FOCUS_LEFT;
        } //End block
        View nextFocus;
        nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);
        {
            boolean var2421F6D33436D75DDCB765DA8D416CB8_260533566 = (isOffScreen(nextFocus));
        } //End collapsed parenthetic
        boolean varBB06A889CCA25ED822B35181716FFE90_1965326096 = (nextFocus.requestFocus(direction, previouslyFocusedRect));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (direction == View.FOCUS_FORWARD) {
            //direction = View.FOCUS_RIGHT;
        //} else if (direction == View.FOCUS_BACKWARD) {
            //direction = View.FOCUS_LEFT;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.102 -0400", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "9470D1E6B920808980BD170620292ADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rectangle.dsTaint);
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        boolean var9EED5F05118BACEED05952D173A9E219_475753044 = (scrollToChildRect(rectangle, immediate));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //rectangle.offset(child.getLeft() - child.getScrollX(),
                //child.getTop() - child.getScrollY());
        //return scrollToChildRect(rectangle, immediate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.102 -0400", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "11A20A1DA3E3F0E4689DA3F629925C7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
        // ---------- Original Method ----------
        //mIsLayoutDirty = true;
        //super.requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.103 -0400", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "4E9CA94D148293D5027E3AFF5129CAA4")
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
            boolean varFEFF39315B1161E387E3A3BC8A5B6333_487125889 = (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.103 -0400", hash_original_method = "BFC9FDBBB166F0ED568B66B969E998B2", hash_generated_method = "0B41A27C261F31A8206EC613CE00FF44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(h);
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused;
        currentFocused = findFocus();
        int maxJump;
        maxJump = mRight - mLeft;
        {
            boolean var23B5651428E53758F7813143E4B31F1D_1669129973 = (isWithinDeltaOfScreen(currentFocused, maxJump));
            {
                currentFocused.getDrawingRect(mTempRect);
                offsetDescendantRectToMyCoords(currentFocused, mTempRect);
                int scrollDelta;
                scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
                doScrollX(scrollDelta);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //View currentFocused = findFocus();
        //if (null == currentFocused || this == currentFocused)
            //return;
        //final int maxJump = mRight - mLeft;
        //if (isWithinDeltaOfScreen(currentFocused, maxJump)) {
            //currentFocused.getDrawingRect(mTempRect);
            //offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            //int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            //doScrollX(scrollDelta);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.103 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "A96B95A8FAD67082299290247E023662")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isViewDescendantOf(View child, View parent) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        ViewParent theParent;
        theParent = child.getParent();
        boolean var948A486C9D980B3FCF5DD6DC234D8E28_638471133 = ((theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (child == parent) {
            //return true;
        //}
        //final ViewParent theParent = child.getParent();
        //return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.104 -0400", hash_original_method = "C5A2747735A9CF7D4575D6EE52958D1F", hash_generated_method = "4FD5DCD241DAD0A2247F3DEBBB70C912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fling(int velocityX) {
        dsTaint.addTaint(velocityX);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_114037355 = (getChildCount() > 0);
            {
                int width;
                width = getWidth() - mPaddingRight - mPaddingLeft;
                int right;
                right = getChildAt(0).getWidth();
                mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    Math.max(0, right - width), 0, 0, width/2, 0);
                boolean movingRight;
                movingRight = velocityX > 0;
                View currentFocused;
                currentFocused = findFocus();
                View newFocused;
                newFocused = findFocusableViewInMyBounds(movingRight,
                    mScroller.getFinalX(), currentFocused);
                {
                    newFocused = this;
                } //End block
                {
                    newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
                } //End block
                invalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //int width = getWidth() - mPaddingRight - mPaddingLeft;
            //int right = getChildAt(0).getWidth();
            //mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    //Math.max(0, right - width), 0, 0, width/2, 0);
            //final boolean movingRight = velocityX > 0;
            //View currentFocused = findFocus();
            //View newFocused = findFocusableViewInMyBounds(movingRight,
                    //mScroller.getFinalX(), currentFocused);
            //if (newFocused == null) {
                //newFocused = this;
            //}
            //if (newFocused != currentFocused) {
                //newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
            //}
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.104 -0400", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "750AB8092DB99FEA3374E5CE47930B4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void scrollTo(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1603130669 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.104 -0400", hash_original_method = "7D7EAD2993C7155FA8CA9421487AA499", hash_generated_method = "0B251C3B02C1339A6B1F809F1DB509D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOverScrollMode(int mode) {
        dsTaint.addTaint(mode);
        {
            {
                Context context;
                context = getContext();
                mEdgeGlowLeft = new EdgeEffect(context);
                mEdgeGlowRight = new EdgeEffect(context);
            } //End block
        } //End block
        {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
        } //End block
        super.setOverScrollMode(mode);
        // ---------- Original Method ----------
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mEdgeGlowLeft == null) {
                //Context context = getContext();
                //mEdgeGlowLeft = new EdgeEffect(context);
                //mEdgeGlowRight = new EdgeEffect(context);
            //}
        //} else {
            //mEdgeGlowLeft = null;
            //mEdgeGlowRight = null;
        //}
        //super.setOverScrollMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.105 -0400", hash_original_method = "63AFEEC895B9671DC479FE83536227D7", hash_generated_method = "9312C1D632456A2C576A232329FC0731")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"SuspiciousNameCombination"})
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        super.draw(canvas);
        {
            int scrollX;
            scrollX = mScrollX;
            {
                boolean var1ECF01FA9E017D6BE3235AB8A34635E8_1127194353 = (!mEdgeGlowLeft.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int height;
                    height = getHeight() - mPaddingTop - mPaddingBottom;
                    canvas.rotate(270);
                    canvas.translate(-height + mPaddingTop, Math.min(0, scrollX));
                    mEdgeGlowLeft.setSize(height, getWidth());
                    {
                        boolean var610D4E0E7DF4A306CD193957D2FE9A09_397149266 = (mEdgeGlowLeft.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFB5CAACA6057E33D653CCB246DF230DF_495929050 = (!mEdgeGlowRight.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int width;
                    width = getWidth();
                    int height;
                    height = getHeight() - mPaddingTop - mPaddingBottom;
                    canvas.rotate(90);
                    canvas.translate(-mPaddingTop,
                        -(Math.max(getScrollRange(), scrollX) + width));
                    mEdgeGlowRight.setSize(height, width);
                    {
                        boolean var0CDA4D4B63F069A0ADED01E10A235FEC_2059054160 = (mEdgeGlowRight.draw(canvas));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.105 -0400", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "FAEBB4FB001EC5F2BFE4E61D7A69E92F")
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
        //if ((my + n) > child) {
            //return child - my;
        //}
        //return n;
    }

    
    private static final int ANIMATED_SCROLL_GAP = ScrollView.ANIMATED_SCROLL_GAP;
    private static final float MAX_SCROLL_FACTOR = ScrollView.MAX_SCROLL_FACTOR;
    private static final int INVALID_POINTER = -1;
}

